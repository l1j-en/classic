SET MYSQL="C:\Program Files\MySQL\MySQL Server 5.2\bin\mysql.exe"
SET PASSWORD=
%MYSQL%  --user=root --password=%PASSWORD% --character-sets-dir=sjis < ..\..\db\makedb.sql
%MYSQL%  --user=root --password=%PASSWORD% --character-sets-dir=sjis < ..\..\db\make_tables.sql