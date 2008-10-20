<?php
// データベース接続設定
$hostname_l1jdb = "localhost";
$database_l1jdb = "l1jdb";
$username_l1jdb = "root";
$password_l1jdb = "";
$l1jdb = mysql_pconnect($hostname_l1jdb, $username_l1jdb, $password_l1jdb) or trigger_error(mysql_error(),E_USER_ERROR); 
mysql_query("SET NAMES sjis")or die("can not SET NAMES sjis");

// Telnetポート
$telnet_port = 23;

// ログイン出来るaccess_level
// 0でaccounts.access_levelが0の一般ユーザーもログイン可能
// 一般ユーザーからのアクセスが大量にあると動作が重たくなるかもしれません。
$login_access_level = 200;

// チャット監視を有効にする
$chat_watch = true;

// チャット監視有効時、チャットログを更新する間隔（秒）
$renewal_time = 2;

// 表示するチャットログの種類
// []内はaccounts.access_level
//  ()内は以下参照
// 0:通常チャット 1:Whisper 2:叫び 3:全体チャット 4:血盟チャット
// 11:パーティチャット 13:連合チャット 14:チャットパーティ
$type[0] = array(3);
$type[200] = array(0,1,2,3,4,11,13,14);
?>