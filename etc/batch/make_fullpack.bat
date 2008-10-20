copy /Y ..\..\db\makedb.sql + ..\..\db\MyISAM\*.sql ..\..\db\MyISAM.sql
"C:\Program Files\7-Zip\7z.exe" a -tzip ..\..\..\l1j_jp.zip ..\..\* -r -x@Exclusion.lst -mx=9
del /F ..\..\db\MyISAM.sql