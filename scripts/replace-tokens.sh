#!/bin/ash
OIFS="$IFS"
IFS=$'\n'
FILE=$1
echo "Working on $FILE"

FORMAT='+%d-%b-%Y'
FORMAT_ALT="'+[\ %Y,\ %-m,\ %-d\ ]'"
FORMAT_YMD='+%Y-%m-%d'

function date_alt {
  local result=`date +[\ %Y,\ %-m,\ %-d\ ] "$@"`
  echo $result
}

TODAY=`date $FORMAT`
TODAY_ALT=$(date_alt)

# future
TODAY_F5=`date $FORMAT -d '+5 days'`
TODAY_F5_ALT=$(date_alt -d '+5 days')
TODAY_F10=`date $FORMAT -d '+10 days'`
TODAY_F10_ALT=$(date_alt -d '+10 days')
TODAY_F15=`date $FORMAT -d '+15 days'`
TODAY_F15_ALT=$(date_alt -d '+15 days')
TODAY_F30=`date $FORMAT -d '+30 days'`
TODAY_F30_ALT=$(date_alt -d '+30 days')
TODAY_F45=`date $FORMAT -d '+45 days'`
TODAY_F45_ALT=$(date_alt -d '+45 days')
TODAY_F60=`date $FORMAT -d '+60 days'`
TODAY_F60_ALT=$(date_alt -d '+60 days')
FIRST_OF_LAST_MONTH_ALT=$(date_alt -d "`date +%Y%m01` -1 month")
LAST_OF_LAST_MONTH_ALT=$(date_alt -d "`date +%Y%m01` -1 day")
FIRST_OF_CURRENT_MONTH_ALT=$(date_alt -d "`date +%Y%m01`")

# past
TODAY_P15=`date $FORMAT -d '-15 days'`
TODAY_P15_ALT=$(date_alt -d '-15 days')
TODAY_P119=`date $FORMAT -d '-119 days'`
TODAY_P119_ALT=$(date_alt -d '-119 days')
TODAY_P120=`date $FORMAT -d '-120 days'`
TODAY_P120_ALT=$(date_alt -d '-120 days')
TODAY_P121=`date $FORMAT -d '-121 days'`
TODAY_P121_ALT=$(date_alt -d '-121 days')
LAST_OF_CURRENT_MONTH_ALT=$(date_alt -d "`date +%Y%m01` +1 month -1 day")
FIRST_OF_NEXT_MONTH_ALT=$(date_alt -d "`date +%Y%m01` +1 month")
LAST_OF_NEXT_MONTH_ALT=$(date_alt -d "`date +%Y%m01` +2 month -1 day")

END_OF_TIME_ALT='[ 9999, 12, 31 ]'

sed -i "s/;END_OF_TIME_ALT;/;$END_OF_TIME_ALT;/g" $FILE
sed -i "s/;TODAY;/;$TODAY;/g" $FILE
sed -i "s/;TODAY_F5;/;$TODAY_F5;/g" $FILE
sed -i "s/;TODAY_F5_ALT;/;$TODAY_F5_ALT;/g" $FILE
sed -i "s/;TODAY_F10;/;$TODAY_F10;/g" $FILE
sed -i "s/;TODAY_F10_ALT;/;$TODAY_F10_ALT;/g" $FILE
sed -i "s/;TODAY_F15;/;$TODAY_F15;/g" $FILE
sed -i "s/;TODAY_F15_ALT;/;$TODAY_F15_ALT;/g" $FILE
sed -i "s/;TODAY_F30;/;$TODAY_F30;/g" $FILE
sed -i "s/;TODAY_F30_ALT;/;$TODAY_F30_ALT;/g" $FILE
sed -i "s/;TODAY_F45;/;$TODAY_F45;/g" $FILE
sed -i "s/;TODAY_F45_ALT;/;$TODAY_F45_ALT;/g" $FILE
sed -i "s/;TODAY_F60;/;$TODAY_F60;/g" $FILE
sed -i "s/;TODAY_F60_ALT;/;$TODAY_F60_ALT;/g" $FILE
sed -i "s/;TODAY_P15;/;$TODAY_P15;/g" $FILE
sed -i "s/;TODAY_P15_ALT;/;$TODAY_P15_ALT;/g" $FILE
sed -i "s/;TODAY_P119;/;$TODAY_P119;/g" $FILE
sed -i "s/;TODAY_P119_ALT;/;$TODAY_P119_ALT;/g" $FILE
sed -i "s/;TODAY_P120;/;$TODAY_P120;/g" $FILE
sed -i "s/;TODAY_P120_ALT;/;$TODAY_P120_ALT;/g" $FILE
sed -i "s/;TODAY_P121;/;$TODAY_P121;/g" $FILE
sed -i "s/;TODAY_P121_ALT;/;$TODAY_P121_ALT;/g" $FILE

echo "Done with $FILE"
