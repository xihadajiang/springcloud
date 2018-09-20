#!/bin/bash
cd `dirname $0`

case "$1" in
	start)
	    ./start.sh
	    ;;
	
	stop)
	    ./stop.sh skip
	    ;;
	
	status)
	    ./status.sh
	    ;;
	dump)
			./dump.sh
	    ;;
	restart)
	    ./stop.sh skip
	    sleep 5
	    ./start.sh
	    ;;
	*)
	    echo $"Usage: $0 {start|stop|restart|status|dump}"
	    exit 1
esac
exit 0
