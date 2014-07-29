<?php
// Database connection settings.
$hostname_l1jdb = "localhost";
$database_l1jdb = "l1jdb";
$username_l1jdb = "root";
$password_l1jdb = "";
$l1jdb = mysql_pconnect($hostname_l1jdb, $username_l1jdb, $password_l1jdb) or trigger_error(mysql_error(),E_USER_ERROR); 
mysql_query("SET NAMES")or die("can not SET NAMES");

// Telnet port.
$telnet_port = 23;

// The access_level you can login as.
// For accounts.access_level 0 (general users), use 0.
$login_access_level = 200;

// Enable chat monitoring.
$chat_watch = true;

// If chat monitoring is enabled, this is the interval to update the chat log.
$renewal_time = 2;


// Kinds of chat logs to be displayed for the access level specified in [].
// In (), specify values corresponding to:
// 0: normal chat
// 1: whisper
// 2: shout
// 3: the entire chat
// 4: clan chat
// 11: party chat
// 13: union chat
// 14: chat party
$type[0] = array(3);
$type[200] = array(0,1,2,3,4,11,13,14);
?>
