#!/bin/bash
cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/config

JAVA_MEM_OPTS=

if [ -z "$JAVA_MEM_OPTS" ]; then
	JAVA_MEM_OPTS=" -Xms256m -Xmx256m -XX:PermSize=128m -XX:SurvivorRatio=2 -XX:+UseParallelGC -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/opt/heapdumppath/"
fi
JAVA_OPTS=" -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true "
JAVA_DEBUG_OPTS=""
if [ "$1" = "debug" ]; then
    JAVA_DEBUG_OPTS=" -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n "
fi
JAVA_JMX_OPTS=""
if [ "$1" = "jmx" ]; then
    JAVA_JMX_OPTS=" -Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false "
fi

PID=`ps -ef | grep java | grep "$DEPLOY_DIR" |awk '{print $2}'`
if [ -n "$PID" ]; then
    echo "ERROR: The server $DEPLOY_DIR ($PID) already started!"
    exit 1
fi

echo -e "Starting the server $DEPLOY_DIR ...\c"
nohup java $JAVA_OPTS $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS $JAVA_JMX_OPTS -jar $DEPLOY_DIR/*.jar > /dev/null 2>&1 &

PID=$!
COUNT=0
while [ $COUNT -lt 1 ]; do
    echo -e ".\c"
    sleep 1
	COUNT=`ps -ef | grep java | grep "$DEPLOY_DIR" | wc -l`
    P_COUNT=`ps --no-heading $PID | wc -l`
    if [ $P_COUNT -eq 0 ]; then
        echo "ERROR: The service failed to start!"
        exit 1
    fi
done

echo "OK!"
echo "PID: $PID"