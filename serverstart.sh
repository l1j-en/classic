#!/usr/bin/env bash 
 
# exit codes of GameServer: 
#  0 normal shutdown 
#  2 reboot attempt 

if [[ ! -e "log/" ]]; then
  mkdir log;
fi

if [[ ! -e "emblem/" ]]; then
  mkdir emblem;
fi
 
while :; do 
  [ -f log/java0.log.0 ] && mv log/java0.log.0 "log/`date +%Y-%m-%d_%H-%M-%S`_java.log"
  [ -f log/stdout.log ] && mv log/stdout.log "log/`date +%Y-%m-%d_%H-%M-%S`_stdout.log" 
  java -Xms1024m -Xmx1024m -cp \
      l1jen.jar:lib/slf4j-api-1.7.5.jar:lib/slf4j-simple-1.7.5.jar:.jar:lib/guava-17.0.jar:lib/bonecp-0.8.0.RELEASE.jar:lib/mysql-connector-java-5.1.31-bin.jar:lib/javolution.jar \
      l1j.server.Server | tee log/stdout.log 2>&1
 [ $? -ne 2 ] && break 
#       /etc/init.d/mysql restart 
         sleep 10 
done 
