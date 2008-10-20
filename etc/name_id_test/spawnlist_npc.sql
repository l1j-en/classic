/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2008/04/25 2:53:08
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for spawnlist_npc
-- ----------------------------
CREATE TABLE `spawnlist_npc` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `location` varchar(19) NOT NULL DEFAULT '',
  `count` int(10) unsigned NOT NULL DEFAULT '0',
  `npc_templateid` int(10) unsigned NOT NULL DEFAULT '0',
  `locx` int(10) unsigned NOT NULL DEFAULT '0',
  `locy` int(10) unsigned NOT NULL DEFAULT '0',
  `randomx` int(10) unsigned NOT NULL DEFAULT '0',
  `randomy` int(10) unsigned NOT NULL DEFAULT '0',
  `heading` int(10) unsigned NOT NULL DEFAULT '0',
  `respawn_delay` int(10) unsigned NOT NULL DEFAULT '0',
  `mapid` int(10) unsigned NOT NULL DEFAULT '0',
  `movement_distance` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=130935 DEFAULT CHARSET=sjis;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `spawnlist_npc` VALUES ('50001', '', '1', '1', '33876', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50002', '初心者のテレポーター_HV', '1', '2', '33878', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50003', '初心者のテレポーター_HV', '1', '3', '33880', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50004', '初心者のテレポーター_HV', '1', '4', '33882', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50005', '初心者のテレポーター_HV', '1', '5', '33884', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50006', '初心者のテレポーター_HV', '1', '6', '33886', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50007', '初心者のテレポーター_HV', '1', '7', '33888', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50008', '初心者のテレポーター_HV', '1', '8', '33890', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50009', '初心者のテレポーター_HV', '1', '9', '33892', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50010', '初心者のテレポーター_SI', '1', '10', '33894', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50011', '初心者のテレポーター_SI', '1', '11', '33896', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50012', '初心者のテレポーター_SI', '1', '12', '33898', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50013', '初心者のテレポーター_SI', '1', '13', '33900', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50014', '初心者のテレポーター_SI', '1', '14', '33902', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50015', '初心者のテレポーター_SI', '1', '15', '33904', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50016', 'ドリスト', '1', '16', '33906', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50017', 'メット', '1', '17', '33908', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50018', 'トレイ', '1', '18', '33910', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50019', 'スティーブ', '1', '19', '33912', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50020', 'ルーカス', '1', '20', '33914', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50021', 'スタンリー', '1', '21', '33916', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50022', 'リオル', '1', '22', '33918', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50023', 'シリウス', '1', '23', '33920', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50024', 'エレリス', '1', '24', '33922', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50026', 'キリウス', '1', '25', '33924', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50027', 'レスリー', '1', '26', '33926', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50028', 'ウィルマ', '1', '27', '33928', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50029', 'ダニエル', '1', '28', '33930', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50030', 'パウル', '1', '29', '33932', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50031', 'リビアン', '1', '30', '33934', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50032', 'ココ', '1', '31', '33936', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50033', 'スカイ', '1', '32', '33938', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50034', 'イルドラス', '1', '33', '33940', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50035', 'バルニア', '1', '34', '33942', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50036', '市場テレポーター_SKT:市場外', '1', '35', '33944', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50037', '市場テレポーター_SKT:市場外', '1', '36', '33946', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50038', '市場テレポーター_グルーディオ:市場外', '1', '37', '33948', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50039', '市場テレポーター_グルーディオ:市場外', '1', '38', '33950', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50040', '市場テレポーター_グルーディオ:市場外', '1', '39', '33952', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50041', '市場テレポーター_オーレン:市場外', '1', '40', '33954', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50042', '市場テレポーター_オーレン:市場外', '1', '41', '33956', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50043', '市場テレポーター_ギラン:市場外', '1', '42', '33958', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50044', '市場テレポーター_ギラン:市場外', '1', '43', '33960', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50045', 'イスメラルダ_HV', '1', '44', '33962', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50046', '市場テレポーター_グルーディン:市場内', '1', '45', '33964', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50047', '市場テレポーター_グルーディン:市場内', '1', '46', '33966', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50048', '市場テレポーター_グルーディン:市場内', '1', '47', '33968', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50049', '市場テレポーター_グルーディン:市場内', '1', '48', '33970', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50050', '市場テレポーター_SKT:市場内?', '1', '49', '33972', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50051', '市場テレポーター_SKT:市場内?', '1', '50', '33974', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50052', '市場テレポーター_オーレン:市場内?', '1', '51', '33976', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50053', '市場テレポーター_オーレン:市場内?', '1', '52', '33978', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50054', '市場テレポーター_ギラン:市場内?', '1', '53', '33980', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50055', '市場テレポーター_ギラン:市場内?', '1', '54', '33982', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50056', '市場テレポーター_ギラン:市場内?', '1', '55', '33984', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50057', 'イスメラルダ_SI', '1', '56', '33986', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50058', 'イシター', '1', '57', '33988', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50059', 'ジェノ', '1', '58', '33990', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50060', 'アシリス', '1', '59', '33992', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50061', 'ラッキー', '1', '60', '33994', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50062', 'クン', '1', '61', '33996', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50063', 'キヨリ', '1', '62', '33998', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50064', 'エドレン', '1', '63', '34000', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50065', 'カレン', '1', '64', '34002', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50066', 'エニャ', '1', '65', '34004', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50067', 'ディアノス', '1', '66', '34006', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50068', 'バンチ', '1', '67', '34008', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50069', 'キース', '1', '68', '34010', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50070', 'フッファー', '1', '69', '34012', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50071', 'ハリソン', '1', '70', '34014', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50072', 'コッブ', '1', '71', '34016', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50073', 'ラムダ', '1', '72', '34018', '33246', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50074', 'ディロン', '1', '73', '33876', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50075', 'コロシアム副管理人_SKT', '1', '74', '33878', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50076', '決闘場案内員_SI', '1', '75', '33880', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50077', 'コロシアム副管理人_SI', '1', '76', '33882', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50078', '決闘場案内員_HV', '1', '77', '33884', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50079', 'コロシアム副管理人_HV', '1', '78', '33886', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50080', 'コロシアム管理人_SKT', '1', '79', '33888', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50081', 'コロシアム副管理人_SKT?', '1', '80', '33890', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50082', 'コロシアム管理人_ギラン', '1', '81', '33892', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50083', 'コロシアム副管理人_ギラン?', '1', '82', '33894', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50084', 'コロシアム管理人_ハイネ', '1', '83', '33896', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50085', 'コロシアム副管理人_ハイネ?', '1', '84', '33898', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50086', 'コロシアム管理人_TI', '1', '85', '33900', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50087', 'コロシアム副管理人_TI?', '1', '86', '33902', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50088', 'コロシアム管理人_グルーディオ', '1', '87', '33904', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50089', 'コロシアム副管理人_グルーディオ?', '1', '88', '33906', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50090', 'コロシアム管理人_ケント', '1', '89', '33908', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50091', 'コロシアム副管理人_ケント?', '1', '90', '33910', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50092', 'コロシアム管理人_WB', '1', '91', '33912', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50093', 'コロシアム副管理人_WB?', '1', '92', '33914', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50094', 'コロシアム管理人_ウェルダン', '1', '93', '33916', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50095', 'コロシアム副管理人_ウェルダン?', '1', '94', '33918', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50096', 'オベール', '1', '95', '33920', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50097', 'ケント城 ゲートキーパー', '1', '96', '33922', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50098', 'ウィンダウッド城 ゲートキーパー', '1', '97', '33924', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50099', 'オーク要塞 ゲートキーパー', '1', '98', '33926', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('50100', 'ギラン城 ゲートキーパー', '1', '99', '33928', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130934', '', '1', '100', '33930', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130884', '', '1', '102', '33934', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130885', '', '1', '103', '33936', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130886', '', '1', '104', '33938', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130887', '', '1', '105', '33940', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130888', '', '1', '106', '33942', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130889', '', '1', '107', '33944', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130890', '', '1', '108', '33946', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130891', '', '1', '109', '33948', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130892', '', '1', '110', '33950', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130893', '', '1', '111', '33952', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130894', '', '1', '112', '33954', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130895', '', '1', '113', '33956', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130896', '', '1', '114', '33958', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130897', '', '1', '115', '33960', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130898', '', '1', '116', '33962', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130899', '', '1', '117', '33964', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130900', '', '1', '118', '33966', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130901', '', '1', '119', '33968', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130902', '', '1', '120', '33970', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130903', '', '1', '121', '33972', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130904', '', '1', '122', '33974', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130905', '', '1', '123', '33976', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130906', '', '1', '124', '33978', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130907', '', '1', '125', '33980', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130908', '', '1', '126', '33982', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130909', '', '1', '127', '33984', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130910', '', '1', '128', '33986', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130911', '', '1', '129', '33988', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130912', '', '1', '130', '33990', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130913', '', '1', '131', '33992', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130914', '', '1', '132', '33994', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130915', '', '1', '133', '33996', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130916', '', '1', '134', '33998', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130917', '', '1', '135', '34000', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130918', '', '1', '136', '34002', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130919', '', '1', '137', '34004', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130920', '', '1', '138', '34006', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130921', '', '1', '139', '34008', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130922', '', '1', '140', '34010', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130923', '', '1', '141', '34012', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130924', '', '1', '142', '34014', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130925', '', '1', '143', '34016', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130926', '', '1', '144', '34018', '33250', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('130933', '', '1', '101', '33932', '33250', '0', '0', '6', '0', '4', '0');
