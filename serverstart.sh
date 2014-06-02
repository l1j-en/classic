#!/usr/bin/env bash 
 
# exit codes of GameServer: 
#  0 normal shutdown 
#  2 reboot attempt 

if [[ ! -e "log/" ]]; then
  mkdir log;
fi
 
while :; do 
  [ -f log/java0.log.0 ] && mv log/java0.log.0 "log/`date +%Y-%m-%d_%H-%M-%S`_java.log"
  [ -f log/stdout.log ] && mv log/stdout.log "log/`date +%Y-%m-%d_%H-%M-%S`_stdout.log" 
java -Xms1024m -Xmx1024m -cp l1jen.jar:lib/c3p0-0.9.1.2.jar:lib/mysql-connector-java-5.1.17-bin.jar:lib/javolution.jar l1j.server.Server > log/stdout.log 2>&1
 [ $? -ne 2 ] && break 
#       /etc/init.d/mysql restart 
         sleep 10 
done 
