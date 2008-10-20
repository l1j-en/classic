<?php
require_once('../setup.php');
session_start();
if (!(isset($_SESSION['l1j_telnet_sid']) and $_SESSION['l1j_telnet_sid'] == session_id())) {
	exit;
}

$id = get_magic_quotes_gpc() ? stripslashes($_POST['id']) : $_POST['id'];

sleep($renewal_time);

mysql_select_db($database_l1jdb, $l1jdb);
$query_R_log_chat = "SELECT * FROM log_chat WHERE id > {$id} ORDER BY id DESC";
$R_log_chat = mysql_query($query_R_log_chat, $l1jdb) or die(mysql_error());
$row_R_log_chat = mysql_fetch_assoc($R_log_chat);
$totalRows_R_log_chat = mysql_num_rows($R_log_chat);
if ($totalRows_R_log_chat > 0) {
	do {
		if (!isset($chatid)) {
			$chatid = $row_R_log_chat['id'];
		}

		if (in_array($row_R_log_chat['type'],$type[$_SESSION['l1j_telnet_access_level']])) {
			switch ($row_R_log_chat['type']){
				case 0:
					echo "<div class=\"chat_normal\">{$row_R_log_chat['mapid']} <span class=\"name\" onclick=\"document.getElementById('command').value = '.charstatus {$row_R_log_chat['char_id']}'\">{$row_R_log_chat['name']}</span> > <span class=\"content\">{$row_R_log_chat['content']}</span></div>";
					break;
				case 1:
					echo "<div class=\"chat_wisper\">\" <span class=\"name\" onclick=\"document.getElementById('command').value = '.charstatus {$row_R_log_chat['char_id']}'\">{$row_R_log_chat['name']}</span> to <span class=\"name\" onclick=\"document.getElementById('command').value = '.charstatus {$row_R_log_chat['target_id']}'\">{$row_R_log_chat['target_name']}</span> > <span class=\"content\">{$row_R_log_chat['content']}</span></div>";
					break;
				case 2:
					echo "<div class=\"chat_shout\">! <span class=\"name\" onclick=\"document.getElementById('command').value = '.charstatus {$row_R_log_chat['char_id']}'\">{$row_R_log_chat['name']}</span> > <span class=\"content\">{$row_R_log_chat['content']}</span></div>";
					break;
				case 3:
					echo "<div class=\"chat_world\">&amp; <span class=\"name\" onclick=\"document.getElementById('command').value = '.charstatus {$row_R_log_chat['char_id']}'\">{$row_R_log_chat['name']}</span> > <span class=\"content\">{$row_R_log_chat['content']}</span></div>";
					break;
				case 4:
					echo "<div class=\"chat_clan\">@ [{$row_R_log_chat['clan_name']}]<span class=\"name\" onclick=\"document.getElementById('command').value = '.charstatus {$row_R_log_chat['char_id']}'\">{$row_R_log_chat['name']}</span> > <span class=\"content\">{$row_R_log_chat['content']}</span></div>";
					break;
				case 11:
					echo "<div class=\"chat_party\"># <span class=\"name\" onclick=\"document.getElementById('command').value = '.charstatus {$row_R_log_chat['char_id']}'\">{$row_R_log_chat['name']}</span> > <span class=\"content\">{$row_R_log_chat['content']}</span></div>";
					break;
				case 13:
					echo "<div class=\"chat_alliance\">% <span class=\"name\" onclick=\"document.getElementById('command').value = '.charstatus {$row_R_log_chat['char_id']}'\">{$row_R_log_chat['name']}</span> > <span class=\"content\">{$row_R_log_chat['content']}</span></div>";
					break;
				case 14:
					echo "<div class=\"chat_chatparty\">* <span class=\"name\" onclick=\"document.getElementById('command').value = '.charstatus {$row_R_log_chat['char_id']}'\">{$row_R_log_chat['name']}</span> > <span class=\"content\">{$row_R_log_chat['content']}</span></div>";
					break;
				default :
					echo "?<span class=\"name\">{$row_R_log_chat['name']}</span> > <span class=\"content\">{$row_R_log_chat['content']}</span></div>";
			}
		}
	} while ($row_R_log_chat = mysql_fetch_assoc($R_log_chat));
	echo "[,]" . $chatid;
}
mysql_free_result($R_log_chat);
?>
