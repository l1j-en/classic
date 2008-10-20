Set fso = CreateObject("Scripting.FileSystemObject")
Set src = fso.GetFolder("..\..\db\MyISAM")

For Each FullName In src.Files
	MyISAM2InnoDB FullName
Next

' 指定のフォルダに格納された各サブフォルダを処理する
tmpMessage = "フォルダ一覧:" & vbNewLine
For Each FolderName In src.Subfolders
    tmpMessage = tmpMessage & FolderName & vbNewLine
Next
WScript.Echo "MyISAMからInnoDBへ変換終わりました。"

Sub MyISAM2InnoDB(FullName)
	Set fso = CreateObject("Scripting.FileSystemObject")
	FileName = fso.GetFileName(FullName)
	Set destFolder = fso.GetFolder("..\..\db\InnoDB")
	Set destFile = destFolder.CreateTextFile(FileName)

	Set srcFile = fso.OpenTextFile(FullName) ' テキストファイルのオープン
	Do Until srcFile.AtEndOfStream
		destFile.WriteLine( replace(srcFile.ReadLine,"MyISAM","InnoDB"))
	Loop
	destFile.close()
	srcFile.close()
End Sub
