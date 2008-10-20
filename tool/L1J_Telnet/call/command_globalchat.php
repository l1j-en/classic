<?php
require_once('../setup.php');
session_start();
if (!(isset($_SESSION['l1j_telnet_sid']) and $_SESSION['l1j_telnet_sid'] == session_id())) {
	exit;
}

$txt = get_magic_quotes_gpc() ? stripslashes($_POST['txt']) : $_POST['txt'];
$txt = mb_convert_encoding($txt,"SJIS","UTF-8");
$name = get_magic_quotes_gpc() ? stripslashes($_POST['name']) : $_POST['name'];
$name = mb_convert_encoding($name,"SJIS","UTF-8");

$fp = fsockopen($hostname_l1jdb, $telnet_port);
if (!$fp) {
	echo "Connection error";
} else {
	fwrite($fp, "globalchat {$name} {$txt}\r\n");
	stream_set_timeout($fp, 3);
	$res=fread($fp, 2000);
	$info = stream_get_meta_data($fp);
	fclose($fp);
	if ($info['timed_out']) {
		echo 'Connection timed out';
	} else {
		echo $res;
	}
}
?>
