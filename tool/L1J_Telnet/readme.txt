####################
 L1J-JP Telnet Tool
####################

■動作環境
PHPとMySQLが動作するWebサーバー
php.iniのdefault_charsetはShift_JISでなければいけません。（default_charset = "Shift_JIS"）
※外部からのポート23が閉じている事。

■インストールと設定
1.server.propertiesの変更
  TelnetServer = True
2.ダウンロードしたファイルを解凍しWebサーバーのフォルダにコピーします。
3.setup.phpを環境に合わせて変更します。
4.ブラウザでindex.phpにアクセスしてログインします。

■コマンドの入力
ゲーム内と同じように先頭に付加する文字列で動作が変わります。
先頭の文字列が一致しない場合は何も行いません。

【.】
acountsテーブルのaccess_levelが200の場合にTelnetコマンドを実行出来ます。
結果は「Result > 」に表示されます。
ただしglobalchatコマンドは実行出来ません。
例：
.playerid [キャラクター名]
.charstatus [objid]

【&】
全体チャットで発言出来ます。
charactersテーブルのIsGMが200だと名前が[******]となります。
例：
&こんにちは
