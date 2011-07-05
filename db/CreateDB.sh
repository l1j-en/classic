#!/bin/bash

mysql -u root -proot -v -e "DROP DATABASE IF EXISTS l1j_en_m6;"
mysql -u root -proot -v -e "CREATE DATABASE l1j_en_m6 CHARACTER SET utf8;"
echo 'Install l1jdb_m6.sql - Please wait, this takes a bit!'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source l1jdb_m6.sql"
echo 'Install update_050.sql'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source update_050.sql"
echo 'Install update_051.sql'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source update_051.sql"
echo 'Install update_052.sql'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source update_052.sql"
echo 'Install update_053.sql'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source update_053.sql"
echo 'Install update_054.sql'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source update_054.sql"
echo 'Install update_055.sql'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source update_055.sql"
echo 'Install update_056.sql'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source update_056.sql"
echo 'Install update_057.sql'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source update_057.sql"
echo 'Install update_058.sql'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source update_058.sql"
echo 'Install update_059.sql'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source update_059.sql"
echo 'Install update_060.sql'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source update_060.sql"
echo 'Install update_061.sql'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source update_061.sql"
echo 'Install update_062.sql'
mysql -u root -proot -D l1j_en_m6 --default-character-set="utf8" -e "source update_062.sql"
echo '------------------------------------------------------'
echo 'Batch File: LinRet CreateDB.bat'
echo 'written by Zylia'
echo '------------------------------------------------------'
echo 'LinRet DataBase Creation Done!'

