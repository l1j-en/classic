l1j-en Telnet tool
==================

# Operating Environment
- A web server with PHP and MySQL.
- A default_charset setting in php.ini set to Shift_JIS (Note: may not be
  necessary).
- Port 23 closed from the outside.

# Installing and configuring
- Set TelnetServer = True in server.properties.
- Copy it to the folder of the Web server and unzip the file.  
- Change setup.php to suit your environment.
- Log into index.php to access.

# Commands
The first character in the string has the same affects as in game.

[.]

If access is 200 (defined in access_level), you can run a telnet command.  The
results are displayed after "Result> ".  However, the global chat command
cannot be executed.

Example:
.playerid [Character]
.charstatus [objid]

[&]

Global chat.  The name is [******] if access_level is 200 and isGM is set in
the characters table.

Example:
&Hello
