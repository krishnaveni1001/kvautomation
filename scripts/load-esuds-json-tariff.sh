#!/bin/ash
echo "Copying contract to shared location"

DATA_DIR=$1
ENVIRONMENT_TYPE=$2
USERNAME=$3

DATA_SRC=/usr/local/cargosphere/contracts/$DATA_DIR
DATA_DEST=/home/cron/mnt/in/$DATA_DIR

OIFS="$IFS"
IFS=$'\n'

TOTAL_REQUESTS_TO_PROCESS=`ls $DATA_SRC | wc -l`

# Copy all contracts from $DATA_SRC to the $DATA_DEST
# This ensures the tokenized contract remains intact
echo "Copying $TOTAL_REQUESTS_TO_PROCESS tokenized contract(s)"
for f in `find $DATA_SRC -type f -name "*.json"`
do
  cp "$f" $DATA_DEST
done

# Do token replacement on all *.json files in the destination directory
echo "Performing token replacement"
for f in `find $DATA_DEST -type f -name "*.json"`
do
  /usr/local/cargosphere/scripts/replace-tokens.sh "$f"
done

echo "Getting auth token"
TOKEN=`curl \
  -k \
  -X POST \
  --header 'Content-Type: application/json' \
  --header 'Accept: application/json' \
  -d "{\"environment\":\"$ENVIRONMENT_TYPE\",\"password\":\"pass\",\"username\":\"$USERNAME\"}" \
  'http://proxy/api/auth/login' | \
    jq -r '.accessToken'`

echo "Calling copy-and-persist to kick off contract ingestion"
curl \
  -k \
  --header 'Accept: application/json' \
  --header "Authorization: bearer $TOKEN" \
  "http://proxy/api/cap/contracts/tariff"

echo "Waiting for data to finish loading…"
while :
do
  total_302s=`psql -h $DB_ADDR -d $DB_DB -U $DB_USER -c "select count(*) from cs_esuds_carrier_file_status where status_id = 302;" -t | xargs`;
  if [ $TOTAL_REQUESTS_TO_PROCESS = $total_302s ]; then
    echo "Detected data load complete. $total_302s contracts loaded"
    break
  else
    echo "Waiting for data to finish loading. $total_302s/$TOTAL_REQUESTS_TO_PROCESS complete…"
    sleep 5
  fi
done
