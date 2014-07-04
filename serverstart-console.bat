@echo off 
title L1J-En Server Console 
:start 
echo Starting L1J-En Server. 
echo. 
REM ------------------------------------- 
REM Default parameters for a basic server. 
java -Xmx1024m -Xincgc -cp l1jen.jar;lib\guava-17.0.jar;lib\bonecp-0.8.0.RELEASE.jar;lib\mysql-connector-java-5.1.31-bin.jar;lib\javolution.jar l1j.server.Server
REM 
REM If you have a big server and lots of memory, you could experiment for example with 
REM java -server -Xmx1536m -Xms1024m -Xmn512m -XX:PermSize=256m -XX:SurvivorRatio=8 -Xnoclassgc -XX:+AggressiveOpts 
REM ------------------------------------- 
if ERRORLEVEL 2 goto restart 
if ERRORLEVEL 1 goto error 
goto end 
:restart 
echo. 
echo Admin Restart ... 
echo. 
goto start 
:error 
echo. 
echo Server terminated abnormaly 
echo. 
:end 
echo. 
echo server terminated 
echo. 
pause 

