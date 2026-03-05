checkProcess(){
   pid=`ps -ef|grep -w ${_moduleName}|grep -v 'grep'|grep -v $0|awk '{print $2}'`
   if [ "X${pid}" != "X" ]; then
      return 0
   else
      return 1
   fi
}

printStartStatus(){
   checkProcess
   if [ $? -eq 0 ]; then
      echo -e "${_moduleName} start sucessful.      \033[32m[OK]\033[0m"
      return 0
   else
      echo -e "${_moduleName} start Failed.      \033[31m[Failed]\033[0m"
      return 1
   fi
}

startProcess(){
   echo $1
   checkProcess
   if [ $? -eq 0 ]; then
	  echo -e "${_moduleName} had started. Please stop before starting.          \033[34m[Warning]\033[0m"
      return 0
   else
      printf "Starting the ${_moduleName}"
      ${start}
      checkProcessStart 
   fi       
}

checkPidAlive() {
   checkProcess
   if [ "$?" -eq 0 ]; then
   	return 0
   else
        echo -e "\nServer pid is not found, maybe server failed to start, Please check yourself.      \033[31m[Failed]\033[0m\n"
        exit 1;
   fi
}

checkProcessStart() {
   declare -i counter=0
   declare -i max_counter=90 # 90*2=180s
   declare -i interval=2
   declare -i total_time=0

   printf "\nWaiting for server startup ."
   
   DISCOVERYED_HEALTH_CHECK_URL="${HEALTH_CHECK_URL}";
   DISCOVERYED_HEALTH_CHECK_PORT="${HEALTH_CHECK_PORT}";
   
   print_flag="N";
   
   printHealthCheckInfo
   
   is_continue_discover='Y'
   if [ "X${DISCOVERYED_HEALTH_CHECK_URL}" != "X" -o "X${DISCOVERYED_HEALTH_CHECK_PORT}" != "X" ]; then
		is_continue_discover='N'
   fi
   
   until [[  counter -ge max_counter  ]];
   do
		if [ "${is_continue_discover}" == "Y" ]; then
			SERVER_PORT=$(findServerListenPort);
			if [ "X${SERVER_PORT}" != "X"  ]; then
				DISCOVERYED_HEALTH_CHECK_URL="http://localhost:${SERVER_PORT}/health"
			fi
			DISCOVERYED_HEALTH_CHECK_PORT=$(findDubboListenPort);
			
			printHealthCheckInfo
		fi
		
		if [ "X${DISCOVERYED_HEALTH_CHECK_URL}" != "X"  ]; then
			if [ $(curl -X GET -w %{http_code} -o /dev/null --silent --connect-timeout 1 --max-time 2 $DISCOVERYED_HEALTH_CHECK_URL) -eq 200 ]; then
				break;
			fi	
		elif [ "X${DISCOVERYED_HEALTH_CHECK_PORT}" != "X"  ]; then
			pid=`ps -ef|grep -w ${_moduleName}|grep -v 'grep'|grep -v $0|awk '{print $2}'`
			if [ "$(netstat -anp | grep $pid | grep -i listen | grep -i ${DISCOVERYED_HEALTH_CHECK_PORT})" != "" ]; then
				break;
			fi
		else
			total_time=counter*interval
			#echo "no port need to bind, wait 30s for server started \n"
			if [ $total_time -ge 60  ]; then
				checkPidAlive
   				pid=`ps -ef|grep -w ${_moduleName}|grep -v 'grep'|grep -v $0|awk '{print $2}'`
			 	echo -e "\n$(date) Server[$pid] started in $total_time seconds!         \033[32m[OK]\033[0m \n"	
				exit 0	
			fi		
		fi

	printf "."
        counter+=1
        sleep $interval
        checkPidAlive
   done

   total_time=counter*interval

   if [[ $counter -ge $max_counter ]]; then
   	echo -e "\n$(date) Server failed to start in $total_time seconds!          \033[31m[Failed]\033[0m\n"
    	exit 1;
   fi

   pid=`ps -ef|grep -w ${_moduleName}|grep -v 'grep'|grep -v $0|awk '{print $2}'`
   echo -e "\n$(date) Server[$pid] started in $total_time seconds!        \033[32m[OK]\033[0m\n"

   exit 0;
}

printHealthCheckInfo() {
	if [ "${print_flag}" == "N" ]; then
		if [ "X${DISCOVERYED_HEALTH_CHECK_URL}" != "X"  ]; then
			printf "\nHealth checking for url: ${DISCOVERYED_HEALTH_CHECK_URL} ."
			print_flag="Y";
		elif [ "X${DISCOVERYED_HEALTH_CHECK_PORT}" != "X"  ]; then
			printf "\nHealth checking for listen port: ${DISCOVERYED_HEALTH_CHECK_PORT} ."
			print_flag="Y";
		fi
	fi
}

findDubboListenPort(){
   for configfile in $(ls ${WSSERVICE_HOME}/conf/*/config-cache/ 2> /dev/null)
   do
        if [ -f ${WSSERVICE_HOME}/conf/*/config-cache/$configfile ]; then
			DUBBO_LISTEN_PORT=$(grep "dubbo.protocol.port" ${WSSERVICE_HOME}/conf/*/config-cache/$configfile|awk -F "=" '{print $2}')
            if [ "X${DUBBO_LISTEN_PORT}" != "X"  ]; then
				echo $DUBBO_LISTEN_PORT
				break;
            fi
        fi
   done
}

findServerListenPort(){
   for configfile in $(ls ${WSSERVICE_HOME}/conf/*/config-cache/ 2> /dev/null)
   do
        if [ -f ${WSSERVICE_HOME}/conf/*/config-cache/$configfile ]; then
			SERVER_LISTEN_PORT=$(grep "server.port" ${WSSERVICE_HOME}/conf/*/config-cache/$configfile|awk -F "=" '{print $2}')
            if [ "X${SERVER_LISTEN_PORT}" != "X"  ]; then
				echo $SERVER_LISTEN_PORT
				break;
            fi
        fi
   done
}


stopProcess(){
   echo $1
   checkProcess
   if [ $? -eq 1 ]; then
      echo -e "${_moduleName} not running.         \033[34m[Warning]\033[0m"
	  return 0;
   else
      pid=`ps -ef|grep -w ${_moduleName}|grep -v 'grep'|grep -v $0|awk '{print $2}'`
      if [ "X${pid}" = "X" ]; then
          echo -e "${_moduleName} had stop.        \033[32m[OK]\033[0m"
	  return 0;
      else
          kill $pid
	  declare -i counter=0
   	  declare -i max_counter=30 # 30*2=60s
   	  declare -i interval=2
   	  declare -i total_time=0

   	  printf "Waiting for server stop ."
   	  until [[  counter -ge max_counter  ]];
   	  do
		checkProcess
		if [ $? -eq 1 ]; then
			break;	
   		fi

		printf "."
        	counter+=1
        	sleep $interval
	  done

	  checkProcess
	  if [ $? -eq 0 ]; then
		kill -9 $pid
          fi
	  echo -e "\n${_moduleName} stopped.          \033[32m[OK]\033[0m"
	  echo $pid
	  return 0;
      fi
   fi
}

restartProcess(){
   stopProcess $1
   if [ $? -eq 0 ]; then
	  startProcess $2
      return 0
   fi
}

getProcessStatus(){
   checkProcess
   if [ $? -eq 0 ]; then
      echo "${_moduleName} is running."
      return 0
   else
      echo "${_moduleName} is not running."
      return 1
   fi
}

uninstall(){
   checkProcess
   if [ $? -eq 0 ]; then
      pid=`ps -ef|grep -w ${_moduleName}|grep -v 'grep'|awk '{print $2}'`
      if [ "X${pid}" != "X" ]; then
         kill $pid
      fi
   fi
   ${remove}
}

commandError(){
   echo ""
   echo "ERROR:UNKNOWN COMMAND:\"$_command\" "
   exit 1
}

