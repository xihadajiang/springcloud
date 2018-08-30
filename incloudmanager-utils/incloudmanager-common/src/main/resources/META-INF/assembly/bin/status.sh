#!/bin/bash
cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/conf
SERVER_PORT=`sed '/^dubbo.protocol.port/!d;s/.*=//' conf/incloudConfig.properties | tr -d '\r'`

PIDS=`ps -ef | grep java | grep "$CONF_DIR" |awk '{print $2}'`
COUNT=`echo statu | netstat -lntp | grep $SERVER_PORT | grep -c java`
if [ -z "$PIDS" ]; then
    echo "The server $DEPLOY_DIR is stopped"
elif [ $COUNT -lt 1 ]
then
	echo "The server $DEPLOY_DIR is starting to bound to port $SERVER_PORT"
else
    echo "The server $DEPLOY_DIR ($PIDS) is running"
fi
