#!/bin/ash
echo "Copying contract to shared location"

CARRIER=$1

CONTRACT_SRC=/usr/local/contracts/$CARRIER
CONTRACT_DEST=/home/cron/mnt/in/$CARRIER

OIFS="$IFS"
IFS=$'\n'

TOTAL_CONTRACTS_TO_LOAD=`ls /usr/local/cargosphere/contracts/$CARRIER | wc -l`

# Copy all contracts from /assets/contracts to the $CONTRACT_DEST
# This ensures the tokenized contract remains intact
echo "Copying $TOTAL_CONTRACTS_TO_LOAD tokenized contract(s)"
for f in `find /usr/local/cargosphere/contracts/$CARRIER -type f -name "*.csv"`
do
  cp "$f" $CONTRACT_DEST
done

echo "Performing token replacement"
for f in `find $CONTRACT_DEST -type f -name "*.csv"`
do
  /usr/local/cargosphere/scripts/replace-tokens.sh "$f"
done

echo "Getting auth token"
TOKEN=`curl \
  -k \
  -X POST \
  --header 'Content-Type: application/json' \
  --header 'Accept: application/json' \
  -d '{ "environment": "E-MAEU", "password": "pass", "username": "e-maeu_super" }' \
  'http://proxy/api/auth/login' | \
    jq -r '.accessToken'`

echo "Calling copy-and-persist to kick off contract ingestion"
curl \
  -k \
  --header 'Accept: application/json' \
  --header "Authorization: bearer $TOKEN" \
  "http://proxy/api/cap/contracts/$CARRIER"

echo "Waiting for data to finish loading…"
while :
do
  total_302s=`psql -h $DB_ADDR -d $DB_DB -U $DB_USER -c "select count(*) from cs_esuds_carrier_file_status where status_id = 302;" -t | xargs`;
  if [ $TOTAL_CONTRACTS_TO_LOAD = $total_302s ]; then
    echo "Detected data load complete. $total_302s contracts loaded"
    break
  else
    echo "Waiting for data to finish loading. $total_302s/$TOTAL_CONTRACTS_TO_LOAD complete…"
    sleep 5
  fi
done
