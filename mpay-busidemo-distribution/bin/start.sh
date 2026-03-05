#!/bin/bash

export WSSERVICE_HOME=$(cd `dirname $0`;cd ../;  pwd)
_moduleName=${WSSERVICE_HOME}
#HEALTH_CHECK_URL=http://localhost:8082/test/redisproxy
#HEALTH_CHECK_PORT=8082

. ${WSSERVICE_HOME}/bin/common.sh
start="${WSSERVICE_HOME}/bin/launch.sh"
startProcess
