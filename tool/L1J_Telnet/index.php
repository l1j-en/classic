<?php
require_once('setup.php');
session_start();

if (!isset($_SERVER['PHP_AUTH_USER'])) {
	header('WWW-Authenticate: Basic realm="L1J-JP Telnet Tool"');
	header('HTTP/1.0 401 Unauthorized');

	die('このページを見るにはログインが必要です');
}else{
	$password = base64_encode(pack("H*", sha1(utf8_encode($_SERVER['PHP_AUTH_PW']))));

	mysql_select_db($database_l1jdb, $l1jdb);
	$query_R_accounts = "SELECT * FROM accounts WHERE access_level >= {$login_access_level} and login = '{$_SERVER['PHP_AUTH_USER']}' and password = '{$password}'";
	$R_accounts = mysql_query($query_R_accounts, $l1jdb) or die(mysql_error());
	$row_R_accounts = mysql_fetch_assoc($R_accounts);
	$totalRows_R_accounts = mysql_num_rows($R_accounts);

	if ($totalRows_R_accounts != 1) {
		header('WWW-Authenticate: Basic realm="L1J-JP Telnet Tool"');
		header('HTTP/1.0 401 Unauthorized');

		mysql_free_result($R_accounts);

		die('このページを見るにはログインが必要です');
	}

	mysql_free_result($R_accounts);
}

$_SESSION['l1j_telnet_sid'] = session_id();
$_SESSION['l1j_telnet_access_level'] = $row_R_accounts['access_level'];

mysql_select_db($database_l1jdb, $l1jdb);
$query_R_log_chat = "SELECT * FROM log_chat ORDER BY id DESC LIMIT 0,1";
$R_log_chat = mysql_query($query_R_log_chat, $l1jdb) or die(mysql_error());
$row_R_log_chat = mysql_fetch_assoc($R_log_chat);
$totalRows_R_log_chat = mysql_num_rows($R_log_chat);
if ($totalRows_R_log_chat > 0) {
	$chatid = $row_R_log_chat['id'];
} else {
	$chatid = 9999999999;
}
mysql_free_result($R_log_chat);

mysql_select_db($database_l1jdb, $l1jdb);
$query_R_characters = "SELECT * FROM characters WHERE account_name = '{$row_R_accounts['login']}' ORDER BY `level` ASC";
$R_characters = mysql_query($query_R_characters, $l1jdb) or die(mysql_error());
$row_R_characters = mysql_fetch_assoc($R_characters);
$totalRows_R_characters = mysql_num_rows($R_characters);
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=shift_jis" />
<title>L1J-JP Telnet Tool</title>
<script src = "js/jslb_ajax.js" charset = "utf-8"></script>
<script language="javascript" type="text/javascript">
<!--
var isRunCommand = true;
var chatid = <?php echo $chatid; ?>;
function log_chat() {
	query = [];
	query['id'] = chatid;
	sendRequest(log_chat_loaded,query,'POST','call/log_chat.php',true,true);
}
function log_chat_loaded(oj) {
	txt = oj.responseText.split("[,]");
	if (txt[0] != "") {
		document.getElementById('chat_view').innerHTML = txt[0] + document.getElementById('chat_view').innerHTML;
	}
	if (txt[1] > <?php echo $chatid; ?>) {
		chatid = txt[1];
	}
	log_chat();
}
function command(txt) {
	query = [];
	query['name'] = document.getElementById('name').value;
	query['txt'] = txt.substring(1,txt.length);
	isSendCommand = false;
	if (txt.charAt(0) == "&") {
		sendRequest(command_loaded,query,'POST','call/command_globalchat.php',true,true);
		isSendCommand = true;
<?php if ($row_R_accounts['access_level'] == 200) { ?>
	} else if (txt.charAt(0) == ".") {
		sendRequest(command_loaded,query,'POST','call/command_normal.php',true,true);
		isSendCommand = true;
<?php } ?>
	}
	if (!isSendCommand) {
		document.getElementById('command_view').innerHTML = "Result > 何も起こりませんでした。";
		document.getElementById('command').value = ""
		isRunCommand = true;
	}
}
function command_loaded(oj) {
	document.getElementById('command_view').innerHTML = "Result > " + oj.responseText;
	if (document.getElementById('command').value.charAt(0) != ".") {
		document.getElementById('command').value = document.getElementById('command').value.charAt(0);
	} else {
		document.getElementById('command').value = "";
	}
	isRunCommand = true;
}
//-->.
</script>
<style type="text/css">
<!--
.chat_view {
	line-height: 120%;
	overflow:auto;
	width:600px;
	height:300px;
}
.name {
	color:#0000FF;
}
.content {
	color:#000000;
}
.chat_normal {

}
.chat_wisper {

}
.chat_shout {

}
.chat_world {
	background-color: #FFCCCC;
}
.chat_clan {

}
.chat_party {

}
.chat_alliance {

}
.chat_chatparty {

}
-->
</style>
</head>

<body onload="document.getElementById('command').focus();<?php if ($chat_watch) {echo "log_chat();";} ?>">
<h3>L1J-JP Telnet TOOL</h3>
<div id="command_view">Result > &nbsp;</div>
<p>
  <select name="name" id="name">
<?php do { ?>
    <option value="<?php echo $row_R_characters['char_name']; ?>"><?php echo $row_R_characters['char_name']; ?></option>
<?php
	} while ($row_R_characters = mysql_fetch_assoc($R_characters));
	$rows = mysql_num_rows($R_characters);
	if($rows > 0) {
		mysql_data_seek($R_characters, 0);
		$row_R_characters = mysql_fetch_assoc($R_characters);
	}
?>
  </select>
&gt;  <input name="command" type="text" id="command" size="100" onkeypress="if (event.keyCode == 13 & isRunCommand) {isRunCommand=false;command(this.value);}" />
</p>
<div id="chat_view" class="chat_view"></div>
</body>
</html>
<?php
mysql_free_result($R_characters);
?>