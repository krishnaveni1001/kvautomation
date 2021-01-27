#!/bin/ash
RATE_DETAIL_UPDATE_SQL="UPDATE cs_ocean_contract_rate_detail SET target_audited = TRUE WHERE ocean_contract_service_info_id IN (SELECT ocsi.ocean_contract_service_info_id FROM cs_ocean_contract_service_info ocsi INNER JOIN cs_ocean_contract_group ocg ON ocg.ocean_contract_group_id = ocsi.ocean_contract_group_id  WHERE ocg.contract_number = ':CONTRACT_NUMBER');"
SURCHARGE_UPDATE_SQL="UPDATE cs_ocean_contract_surcharge SET target_audited = TRUE WHERE ocean_contract_service_info_id IN (SELECT ocsi.ocean_contract_service_info_id FROM cs_ocean_contract_service_info ocsi INNER JOIN cs_ocean_contract_group ocg ON ocg.ocean_contract_group_id = ocsi.ocean_contract_group_id  WHERE ocg.contract_number = ':CONTRACT_NUMBER');"
CONTRACT_NUMBER=$1

# replace contract_number in the sql queries
RATE_DETAIL_UPDATE_SQL=$(echo $RATE_DETAIL_UPDATE_SQL | sed 's/:CONTRACT_NUMBER/'"${CONTRACT_NUMBER}"'/g')
SURCHARGE_UPDATE_SQL=$(echo $SURCHARGE_UPDATE_SQL | sed 's/:CONTRACT_NUMBER/'"${CONTRACT_NUMBER}"'/g')

echo "Approving Contract Rate Details"
psql -h $DB_ADDR -d $DB_DB -U $DB_USER -c "$RATE_DETAIL_UPDATE_SQL"
echo "Approving Contract Surcharges"
psql -h $DB_ADDR -d $DB_DB -U $DB_USER -c "$SURCHARGE_UPDATE_SQL"
