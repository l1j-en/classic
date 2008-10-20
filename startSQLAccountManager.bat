@echo off
cls
title L1J - SQL Account Manager
color 11
java -Xmx1024m -cp lindc.jar;lib\c3p0-0.9.1.jar;lib\mysql-connector-java-5.1.6-bin.jar;lib\javolution.jar l1j.server.accountmanager.SQLAccountManager 2> NUL
if %errorlevel% == 0 (
echo.
echo Execution succesful
echo.
) else (
echo.
echo An error has ocurred while running the L1J Account Manager!
echo.
echo Possible reasons for this to happen:
echo.
echo - Missing .jar files or ../libs directory.
echo - MySQL server not running or incorrect MySQL settings:
echo    check ./config/loginserver.properties
echo - Wrong data types or values out of range were provided:
echo    specify correct values for each required field
echo.
)
pause
