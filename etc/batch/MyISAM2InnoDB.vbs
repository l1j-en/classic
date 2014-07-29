Set fso = CreateObject("Scripting.FileSystemObject")
Set src = fso.GetFolder("..\..\db\MyISAM")

For Each FullName In src.Files
	MyISAM2InnoDB FullName
Next

' Process each subdirectory stored in the specified directory.
tmpMessage = "Folder list:" & vbNewLine
For Each FolderName In src.Subfolders
    tmpMessage = tmpMessage & FolderName & vbNewLine
Next
WScript.Echo "Conversion from MyISAM to InnoDB complete."

Sub MyISAM2InnoDB(FullName)
	Set fso = CreateObject("Scripting.FileSystemObject")
	FileName = fso.GetFileName(FullName)
	Set destFolder = fso.GetFolder("..\..\db\InnoDB")
	Set destFile = destFolder.CreateTextFile(FileName)

	Set srcFile = fso.OpenTextFile(FullName) ' Open the text file.
	Do Until srcFile.AtEndOfStream
		destFile.WriteLine( replace(srcFile.ReadLine,"MyISAM","InnoDB"))
	Loop
	destFile.close()
	srcFile.close()
End Sub
