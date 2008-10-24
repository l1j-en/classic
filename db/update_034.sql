-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here
-- this allows them to be verified as working together before being
-- migrated to the DML scripts

-- update 34

-- drop some old event rows
delete from mobskill where mobid in (90002, 90003);
delete from npc where npcid in (90000, 90001, 90002, 90003);
delete from droplist where mobid in (90000, 90001, 90002, 90003);

-- fix some of the column ordering (note: not all tables need to have the 
-- exact same column order, just those that need to support merging.)

-- armor table
alter table armor drop column cant_delete;
alter table armor add column cant_delete int(2) unsigned NOT NULL default '0' after trade;
alter table armor change regist_stan regist_stun int(2) NOT NULL default '0';

-- etcitem table
alter table etcitem drop column max_charge_count;
alter table etcitem add column max_charge_count int(10) unsigned NOT NULL default '0' after stackable;
update etcitem set max_charge_count = 15 where item_id in (40006, 40007, 40008, 40009, 140006, 140008, 41401);
alter table etcitem drop column cant_delete;
alter table etcitem add column cant_delete int(2) unsigned NOT NULL default '0' after trade;

-- npc table
alter table npc drop column transform_gfxid;
alter table npc add column transform_gfxid int(10) NOT NULL default '0' after transform_id;
update npc set transform_gfxid = 5306 where npcid in (45448, 45474, 45475, 45489, 45495, 45669, 45830, 45837, 45838, 45845, 45846, 45848, 45850, 45851, 45852);
update npc set transform_gfxid = -1 where npcid in (71183, 71184, 71185, 71186, 71187, 71188, 71189);
alter table skills drop column action_id;
alter table skills add column action_id int(10) unsigned NOT NULL default 0 after nameid;
update skills set action_id = 19;
update skills set action_id = 18 where skill_id in (4, 6, 7, 10, 11, 15, 16, 17, 22, 25, 28, 30, 34, 38, 45, 
46, 50, 53, 58, 59, 62, 65, 70, 74, 77, 80, 108, 132, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 
10008, 10009, 10010, 10011, 10012, 10013, 10014, 10015, 10016, 10017, 10018, 10019, 10020, 10021, 10022, 10023, 
10024, 10025, 10026, 10027, 10028, 10029, 10030, 10031, 10032, 10033, 10034, 10035, 10036, 10037, 10038, 10039, 
10040, 10041, 10042, 10043, 10044, 10045, 10046, 10047, 10048, 10049, 10050, 10051, 10052, 10053, 10054, 10055, 
10056, 10058, 10059, 10060, 10061, 10062, 10063, 10064, 10065, 10066, 10067, 10068, 10069, 10070, 10072, 10073, 
10074, 10075, 10076, 10077, 10078, 10079, 10080, 10081, 10082, 10083, 10084, 10085, 10086, 10087, 10088, 10089);

-- weapon table
alter table weapon drop column double_dmg_chance;
ALTER TABLE `weapon` ADD column `double_dmg_chance` int(10) unsigned NOT NULL  AFTER `haste_item`; 
update weapon set double_dmg_chance = 10 where item_id = 69; 
update weapon set double_dmg_chance = 11 where item_id = 70; 
update weapon set double_dmg_chance = 10 where item_id = 71; 
update weapon set double_dmg_chance = 11 where item_id = 72; 
update weapon set double_dmg_chance = 25 where item_id = 73; 
update weapon set double_dmg_chance = 25 where item_id = 74; 
update weapon set double_dmg_chance = 13 where item_id = 75; 
update weapon set double_dmg_chance = 20 where item_id = 76; 
update weapon set double_dmg_chance = 30 where item_id = 77; 
update weapon set double_dmg_chance = 25 where item_id = 78; 
update weapon set double_dmg_chance = 30 where item_id = 79; 
update weapon set double_dmg_chance = 25 where item_id = 80; 
update weapon set double_dmg_chance = 25 where item_id = 81; 
update weapon set double_dmg_chance = 20 where item_id = 82; 
update weapon set double_dmg_chance = 25 where item_id = 83; 
update weapon set double_dmg_chance = 25 where item_id = 84; 
update weapon set double_dmg_chance = 20 where item_id = 85; 
update weapon set double_dmg_chance = 25 where item_id = 86; 
update weapon set double_dmg_chance = 40 where item_id = 152; 
update weapon set double_dmg_chance = 40 where item_id = 153; 
update weapon set double_dmg_chance = 33 where item_id = 154; 
update weapon set double_dmg_chance = 30 where item_id = 155; 
update weapon set double_dmg_chance = 30 where item_id = 156; 
update weapon set double_dmg_chance = 34 where item_id = 157; 
update weapon set double_dmg_chance = 25 where item_id = 158; 
update weapon set double_dmg_chance = 15 where item_id = 159; 
update weapon set double_dmg_chance = 35 where item_id = 160; 
update weapon set double_dmg_chance = 40 where item_id = 161; 
update weapon set double_dmg_chance = 36 where item_id = 162; 
update weapon set double_dmg_chance = 35 where item_id = 163; 
update weapon set double_dmg_chance = 37 where item_id = 164; 
update weapon set double_dmg_chance = 36 where item_id = 165; 
update weapon set double_dmg_chance = 38 where item_id = 166; 

-- end fix of column ordering

-- add new columns
alter table characters add column DeleteTime datetime default NULL;
alter table weapon_skill add column area int(11) NOT NULL default '0' after random_damage;

-- elf warehouse
#----------------------------
# Table structure for character_elf_warehouse
#----------------------------
CREATE TABLE `character_elf_warehouse` (
  `id` int(11) NOT NULL auto_increment,
  `account_name` varchar(13) default NULL,
  `item_id` int(11) default NULL,
  `item_name` varchar(255) default NULL,
  `count` int(11) default NULL,
  `is_equipped` int(11) default NULL,
  `enchantlvl` int(11) default NULL,
  `is_id` int(11) default NULL,
  `durability` int(11) default NULL,
  `charge_count` int(11) default NULL,
  `last_used` datetime default NULL,
  PRIMARY KEY  (`id`),
  KEY `key_id` (`account_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
#----------------------------
# No records for table character_elf_warehouse
#----------------------------

-- add spawnlist_light table
#----------------------------
# Table structure for spawnlist_light
#----------------------------
CREATE TABLE `spawnlist_light` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `npcid` int(10) unsigned NOT NULL default '0',
  `locx` int(10) unsigned NOT NULL default '0',
  `locy` int(10) unsigned NOT NULL default '0',
  `mapid` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


#----------------------------
# Records for table spawnlist_light
#----------------------------
INSERT INTO `spawnlist_light` VALUES
(1, 81177, 33084, 33396, 4),
(2, 81177, 33066, 33395, 4),
(3, 81177, 33049, 33399, 4),
(4, 81177, 33050, 33392, 4),
(5, 81177, 33062, 33418, 4),
(6, 81177, 33068, 33418, 4),
(7, 81177, 33097, 33414, 4),
(8, 81177, 33084, 33367, 4),
(9, 81177, 33084, 33362, 4),
(10, 81177, 33102, 33360, 4),
(11, 81177, 33114, 33360, 4),
(12, 81177, 33125, 33358, 4),
(13, 81177, 33127, 33368, 4),
(14, 81177, 33138, 33370, 4),
(15, 81177, 33122, 33380, 4),
(16, 81177, 33115, 33396, 4),
(17, 81177, 33121, 33330, 4),
(18, 81177, 33121, 33325, 4),
(19, 81177, 33132, 33318, 4),
(20, 81177, 33132, 33326, 4),
(21, 81177, 33145, 33318, 4),
(22, 81177, 33145, 33326, 4),
(23, 81177, 33106, 33332, 4),
(24, 81177, 33100, 33332, 4),
(25, 81177, 33104, 33315, 4),
(26, 81177, 33112, 33315, 4),
(27, 81177, 33610, 33263, 4),
(28, 81177, 33649, 33259, 4),
(29, 81177, 33649, 33253, 4),
(30, 81177, 33654, 33225, 4),
(31, 81177, 33654, 33230, 4),
(32, 81177, 33624, 33216, 4),
(33, 81177, 33621, 33235, 4),
(34, 81177, 33597, 33218, 4),
(35, 81177, 33578, 33219, 4),
(36, 81177, 33558, 33260, 4),
(37, 81177, 33554, 33283, 4),
(38, 81177, 33535, 33277, 4),
(39, 81177, 33535, 33282, 4),
(40, 81177, 33587, 33270, 4),
(41, 81177, 33573, 33304, 4),
(42, 81177, 33608, 33284, 4),
(43, 81177, 33633, 33300, 4),
(44, 81177, 33614, 33324, 4),
(45, 81177, 33614, 33329, 4),
(46, 81177, 33613, 33390, 4),
(47, 81177, 33625, 33409, 4),
(48, 81177, 33604, 33444, 4),
(49, 81177, 33608, 33447, 4),
(50, 81177, 33646, 33426, 4),
(51, 81177, 33652, 33425, 4),
(52, 81178, 33596, 33245, 4),
(53, 81178, 33607, 33245, 4),
(54, 81177, 32584, 32935, 0),
(55, 81177, 32604, 32940, 0),
(56, 81177, 32595, 32910, 0),
(57, 81177, 32588, 32909, 0),
(58, 81177, 32565, 32924, 0),
(59, 81177, 32565, 32931, 0),
(60, 81177, 32571, 32948, 0),
(61, 81177, 32544, 32955, 0),
(62, 81177, 32544, 32962, 0),
(63, 81177, 32553, 32975, 0),
(64, 81177, 32568, 32978, 0),
(65, 81177, 32575, 32978, 0),
(66, 81177, 32589, 32959, 0),
(67, 81177, 32604, 32947, 0),
(68, 81177, 32620, 32952, 0),
(69, 81177, 32620, 32957, 0),
(70, 81177, 32620, 32963, 0),
(71, 81177, 32626, 32967, 0),
(72, 81177, 32637, 32967, 0),
(73, 81177, 32620, 32969, 0),
(74, 81177, 32511, 32865, 0),
(75, 81177, 32507, 32865, 0),
(76, 81177, 32552, 32923, 0),
(77, 81177, 32552, 32926, 0),
(78, 81177, 32530, 32925, 0),
(79, 81177, 33681, 32511, 4),
(80, 81177, 33681, 32522, 4),
(81, 81177, 33712, 32516, 4),
(82, 81177, 33706, 32492, 4),
(83, 81177, 33716, 32471, 4),
(84, 81177, 33728, 32471, 4),
(85, 81177, 33729, 32497, 4),
(86, 81177, 33726, 32520, 4),
(87, 81177, 33736, 32520, 4),
(88, 81177, 32636, 33205, 4),
(89, 81177, 32644, 33218, 4),
(90, 81177, 32620, 33228, 4),
(91, 81177, 32608, 33221, 4),
(92, 81177, 32587, 33197, 4),
(93, 81177, 32587, 33192, 4),
(94, 81177, 32587, 33172, 4),
(95, 81177, 32588, 33162, 4),
(96, 81177, 32611, 33158, 4),
(97, 81177, 32617, 33158, 4),
(98, 81177, 32640, 33176, 4),
(99, 81177, 32619, 33183, 4),
(100, 81177, 33031, 32761, 4),
(101, 81177, 33031, 32773, 4),
(102, 81177, 33029, 32788, 4),
(103, 81177, 33029, 32794, 4),
(104, 81177, 33050, 32813, 4),
(105, 81177, 33067, 32813, 4),
(106, 81177, 33082, 32789, 4),
(107, 81177, 33082, 32775, 4),
(108, 81177, 33082, 32762, 4),
(109, 81177, 33029, 32741, 4),
(110, 81177, 33063, 32722, 4),
(111, 81177, 33069, 32722, 4),
(112, 81177, 33081, 32742, 4),
(113, 81179, 33427, 32850, 4),
(114, 81179, 33384, 32858, 4),
(115, 81179, 33362, 32883, 4),
(116, 81179, 33368, 32890, 4),
(117, 81179, 33411, 32878, 4),
(118, 81179, 33448, 32890, 4),
(119, 81179, 33461, 32891, 4),
(120, 81179, 33467, 32869, 4),
(121, 81179, 33477, 32837, 4),
(122, 81179, 33545, 32844, 4),
(123, 81179, 33545, 32856, 4),
(124, 81179, 33520, 32850, 4),
(125, 81179, 33530, 32894, 4),
(126, 81179, 33518, 32894, 4),
(127, 81179, 33523, 32873, 4),
(128, 81179, 33446, 32826, 4),
(129, 81179, 33346, 32836, 4),
(130, 81179, 33346, 32823, 4),
(131, 81179, 33380, 32814, 4),
(132, 81179, 33364, 32801, 4),
(133, 81179, 33350, 32785, 4),
(134, 81179, 33366, 32776, 4),
(135, 81179, 33373, 32738, 4),
(136, 81179, 33340, 32754, 4),
(137, 81179, 33339, 32739, 4),
(138, 81179, 33342, 32717, 4),
(139, 81179, 33405, 32722, 4),
(140, 81179, 33359, 32691, 4),
(141, 81179, 33333, 32701, 4),
(142, 81179, 33333, 32686, 4),
(143, 81179, 33388, 32667, 4),
(144, 81179, 33417, 32663, 4),
(145, 81179, 33437, 32691, 4),
(146, 81179, 33466, 32662, 4),
(147, 81179, 33491, 32645, 4),
(148, 81179, 33484, 32640, 4),
(149, 81179, 33439, 32652, 4),
(150, 81179, 33418, 32636, 4),
(151, 81179, 33405, 32635, 4),
(152, 81179, 33368, 32643, 4),
(153, 81179, 33357, 32643, 4),
(154, 81179, 33491, 32683, 4),
(155, 81179, 33520, 32694, 4),
(156, 81179, 33531, 32694, 4),
(157, 81179, 33508, 32763, 4),
(158, 81179, 33499, 32763, 4),
(159, 81179, 33514, 32781, 4),
(160, 81179, 33514, 32793, 4),
(161, 81179, 33475, 32809, 4),
(162, 81179, 33439, 32764, 4),
(163, 81179, 33476, 32738, 4),
(164, 81179, 33476, 32730, 4),
(165, 81179, 33451, 32719, 4),
(166, 81180, 32743, 32442, 4),
(167, 81181, 33047, 32809, 4),
(168, 81177, 33625, 33295, 4),
(169, 81177, 33044, 32813, 4),
(170, 81180, 32797, 32284, 4),
(171, 81177, 33492, 33370, 4),
(172, 81177, 33498, 33370, 4),
(173, 81177, 33550, 33370, 4);

-- redo getback_restart table
drop table getback_restart; 
-- ----------------------------
-- Table structure for getback_restart
-- ----------------------------
CREATE TABLE `getback_restart` (
  `area` int(10) NOT NULL default '0',
  `note` varchar(50) default NULL,
  `locx` int(10) NOT NULL default '0',
  `locy` int(10) NOT NULL default '0',
  `mapid` int(10) NOT NULL default '0',
  PRIMARY KEY  (`area`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `getback_restart` VALUES ('5', 'Talking Island Ship to Aden Mainland', '32631', '32983', '0');
INSERT INTO `getback_restart` VALUES ('6', 'Aden Mainland Ship to Talking Island', '32543', '32728', '4');
INSERT INTO `getback_restart` VALUES ('70', '', '32828', '32848', '70');
INSERT INTO `getback_restart` VALUES ('75', '', '34047', '32283', '4');
INSERT INTO `getback_restart` VALUES ('76', '', '34047', '32283', '4');
INSERT INTO `getback_restart` VALUES ('77', '', '34047', '32283', '4');
INSERT INTO `getback_restart` VALUES ('78', '', '34047', '32283', '4');
INSERT INTO `getback_restart` VALUES ('79', '', '34047', '32283', '4');
INSERT INTO `getback_restart` VALUES ('80', '', '34047', '32283', '4');
INSERT INTO `getback_restart` VALUES ('81', '', '34047', '32283', '4');
INSERT INTO `getback_restart` VALUES ('82', '', '34047', '32283', '4');
INSERT INTO `getback_restart` VALUES ('83', 'Aden Mainland Ship to Forgotten Island', '33426', '33499', '4');
INSERT INTO `getback_restart` VALUES ('84', 'Forgotten Island Ship to Aden Mainland', '32936', '33057', '70');
INSERT INTO `getback_restart` VALUES ('88', 'Giran Colosseum', '33442', '32797', '0');
INSERT INTO `getback_restart` VALUES ('91', 'Talking island Colosseum', '32580', '32931', '4');
INSERT INTO `getback_restart` VALUES ('92', 'Gludio Colosseum', '32612', '32734', '0');
INSERT INTO `getback_restart` VALUES ('95', 'Silver knight Colosseum', '33080', '33392', '4');
INSERT INTO `getback_restart` VALUES ('98', 'Welldone Colosseum', '33705', '32504', '4');
INSERT INTO `getback_restart` VALUES ('101', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('102', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('103', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('104', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('105', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('106', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('107', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('108', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('109', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('110', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('111', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('112', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('113', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('114', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('115', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('116', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('117', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('118', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('119', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('120', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('121', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('122', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('123', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('124', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('125', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('126', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('127', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('128', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('129', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('130', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('131', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('132', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('133', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('134', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('135', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('136', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('137', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('138', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('139', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('140', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('141', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('142', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('143', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('144', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('145', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('146', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('147', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('148', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('149', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('150', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('151', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('152', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('153', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('154', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('155', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('156', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('157', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('158', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('159', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('160', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('161', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('162', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('163', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('164', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('165', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('166', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('167', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('168', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('169', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('170', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('171', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('172', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('173', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('174', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('175', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('176', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('177', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('178', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('179', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('180', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('181', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('182', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('183', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('184', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('185', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('186', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('187', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('188', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('189', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('190', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('191', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('192', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('193', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('194', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('195', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('196', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('197', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('198', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('199', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('200', '', '32781', '32816', '101');
INSERT INTO `getback_restart` VALUES ('303', '', '33976', '32936', '4');
INSERT INTO `getback_restart` VALUES ('446', 'Ship Pirate island to Hidden dock', '32297', '33087', '440');
INSERT INTO `getback_restart` VALUES ('447', 'Ship Hidden dock to Pirate island', '32750', '32874', '445');
INSERT INTO `getback_restart` VALUES ('451', '', '32744', '32818', '450');
INSERT INTO `getback_restart` VALUES ('452', '', '32744', '32818', '450');
INSERT INTO `getback_restart` VALUES ('453', '', '32744', '32818', '450');
INSERT INTO `getback_restart` VALUES ('454', '', '32744', '32818', '450');
INSERT INTO `getback_restart` VALUES ('455', '', '32744', '32818', '450');
INSERT INTO `getback_restart` VALUES ('456', '', '32744', '32818', '450');
INSERT INTO `getback_restart` VALUES ('460', '', '32667', '32863', '457');
INSERT INTO `getback_restart` VALUES ('461', '', '32667', '32863', '457');
INSERT INTO `getback_restart` VALUES ('462', '', '32667', '32863', '457');
INSERT INTO `getback_restart` VALUES ('463', '', '32667', '32863', '457');
INSERT INTO `getback_restart` VALUES ('464', '', '32667', '32863', '457');
INSERT INTO `getback_restart` VALUES ('465', '', '32667', '32863', '457');
INSERT INTO `getback_restart` VALUES ('466', '', '32667', '32863', '457');
INSERT INTO `getback_restart` VALUES ('470', '', '32671', '32855', '467');
INSERT INTO `getback_restart` VALUES ('471', '', '32671', '32855', '467');
INSERT INTO `getback_restart` VALUES ('472', '', '32671', '32855', '467');
INSERT INTO `getback_restart` VALUES ('473', '', '32671', '32855', '467');
INSERT INTO `getback_restart` VALUES ('474', '', '32671', '32855', '467');
INSERT INTO `getback_restart` VALUES ('475', '', '32671', '32855', '467');
INSERT INTO `getback_restart` VALUES ('476', '', '32671', '32855', '467');
INSERT INTO `getback_restart` VALUES ('477', '', '32671', '32855', '467');
INSERT INTO `getback_restart` VALUES ('478', '', '32671', '32855', '467');
INSERT INTO `getback_restart` VALUES ('490', '', '32744', '32818', '450');
INSERT INTO `getback_restart` VALUES ('491', '', '32744', '32818', '450');
INSERT INTO `getback_restart` VALUES ('492', '', '32744', '32818', '450');
INSERT INTO `getback_restart` VALUES ('493', '', '32744', '32818', '450');
INSERT INTO `getback_restart` VALUES ('494', '', '32744', '32818', '450');
INSERT INTO `getback_restart` VALUES ('495', '', '32744', '32818', '450');
INSERT INTO `getback_restart` VALUES ('496', '', '32744', '32818', '450');
INSERT INTO `getback_restart` VALUES ('530', '', '32744', '32792', '536');
INSERT INTO `getback_restart` VALUES ('531', '', '32744', '32792', '536');
INSERT INTO `getback_restart` VALUES ('532', '', '32744', '32792', '536');
INSERT INTO `getback_restart` VALUES ('533', '', '32744', '32792', '536');
INSERT INTO `getback_restart` VALUES ('534', '', '32744', '32792', '536');
INSERT INTO `getback_restart` VALUES ('535', '', '32744', '32792', '536');
INSERT INTO `getback_restart` VALUES ('550', '', '32844', '32694', '550');
INSERT INTO `getback_restart` VALUES ('551', '', '32844', '32694', '550');
INSERT INTO `getback_restart` VALUES ('552', '', '32844', '32694', '550');
INSERT INTO `getback_restart` VALUES ('553', '', '32844', '32694', '550');
INSERT INTO `getback_restart` VALUES ('554', '', '32844', '32694', '550');
INSERT INTO `getback_restart` VALUES ('555', '', '32844', '32694', '550');
INSERT INTO `getback_restart` VALUES ('556', '', '32844', '32694', '550');
INSERT INTO `getback_restart` VALUES ('557', '', '32844', '32694', '550');
INSERT INTO `getback_restart` VALUES ('558', '', '32844', '32694', '550');
INSERT INTO `getback_restart` VALUES ('600', '', '32608', '33178', '4');
INSERT INTO `getback_restart` VALUES ('601', '', '32608', '33178', '4');
INSERT INTO `getback_restart` VALUES ('608', '', '34053', '32284', '4');
INSERT INTO `getback_restart` VALUES ('778', '', '32608', '33178', '4');
INSERT INTO `getback_restart` VALUES ('5140', '', '32624', '32813', '4');
INSERT INTO `getback_restart` VALUES ('5124', 'Fishing place', '32815', '32809', '5124');
INSERT INTO `getback_restart` VALUES ('5125', 'petmatch place', '32628', '32781', '4');
INSERT INTO `getback_restart` VALUES ('5131', 'petmatch place', '32628', '32781', '4');
INSERT INTO `getback_restart` VALUES ('5132', 'petmatch place', '32628', '32781', '4');
INSERT INTO `getback_restart` VALUES ('5133', 'petmatch place', '32628', '32781', '4');
INSERT INTO `getback_restart` VALUES ('5134', 'petmatch place', '32628', '32781', '4');

-- merge in new area table changes
update area set x1 = 0, y1 = 0, x2 = 0, y2 = 0, restart = 0 where areaid = 93;
INSERT INTO `area` VALUES ('201', '212', 'Darkelf Dungeon', '0', '0', '0', '0', '1', '0');
INSERT INTO `area` VALUES ('203', '214', 'Darkelf Dungeon', '0', '0', '0', '0', '1', '0');
INSERT INTO `area` VALUES ('204', '215', 'Darkelf Dungeon', '0', '0', '0', '0', '1', '0');
INSERT INTO `area` VALUES ('205', '216', 'Darkelf Dungeon', '0', '0', '0', '0', '1', '0');
INSERT INTO `area` VALUES ('207', '218', 'Mutant Ant Dungeon', '0', '0', '0', '0', '1', '0');
INSERT INTO `area` VALUES ('209', '222', 'Gerard Test Dungeon', '0', '0', '0', '0', '0', '0');
INSERT INTO `area` VALUES ('210', '223', 'Gerard Test Dungeon', '0', '0', '0', '0', '0', '0');
INSERT INTO `area` VALUES ('211', '224', 'Gerard Test Dungeon', '0', '0', '0', '0', '0', '0');
INSERT INTO `area` VALUES ('212', '225', 'Gerard Test Dungeon', '0', '0', '0', '0', '0', '0');
INSERT INTO `area` VALUES ('213', '226', 'Gerard Test Dungeon', '0', '0', '0', '0', '0', '0');
INSERT INTO `area` VALUES ('214', '227', 'Gerard Test Dungeon', '0', '0', '0', '0', '0', '0');
INSERT INTO `area` VALUES ('215', '228', 'Gerard Test Dungeon', '0', '0', '0', '0', '0', '0');

-- remove poorly merged armor entries 
delete from armor where item_id in (21057, 21058, 21059);
-- merge armor table
INSERT INTO `armor` VALUES ('21035', 'Unknown_New', '', 'helm', 'silver', '5000', '1641', '4244', '0', '-4', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21036', 'Unknown_New', '', 'T', 'steel', '5000', '1822', '3830', '0', '-2', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21037', 'Unknown_New', '', 'shield', 'silver', '5000', '1660', '3174', '0', '-4', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21038', 'Unknown_New', '', 'boots', 'silver', '5000', '1639', '4242', '0', '-4', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21039', 'Unknown_New', '', 'helm', 'iron', '5000', '969', '18', '0', '-3', '-1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '5', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21040', 'Unknown_New', '', 'shield', 'iron', '50000', '1660', '3174', '0', '-7', '-1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '10', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21041', 'Unknown_New', '', 'boots', 'iron', '50000', '1669', '4270', '0', '-7', '-1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '10', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21042', 'Unknown_New', '', 'glove', 'iron', '50000', '1665', '4268', '0', '-6', '-1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '10', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21043', 'Unknown_New', '', 'amulet', 'gemstone', '10000', '1187', '3158', '0', '-2', '-1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '16', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21044', 'Unknown_New', '', 'amulet', 'gemstone', '10000', '1190', '3161', '0', '-2', '-1', '1', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '8', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21045', 'Unknown_New', '', 'amulet', 'gemstone', '10000', '1188', '3159', '0', '-2', '-1', '1', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '10', '3', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21046', 'Unknown_New', '', 'amulet', 'gemstone', '10000', '1192', '3163', '0', '-2', '-1', '1', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '6', '5', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21047', 'Unknown_New', '', 'ring', 'gold', '20000', '976', '21', '0', '0', '-1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '2', '2', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21048', 'Repaired Ring', '$5266', 'ring', 'iron', '5000', '2668', '6363', '0', '0', '-1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21049', 'Repaired Earrings', '$5267', 'earring', 'iron', '5000', '2664', '6361', '0', '-1', '-1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21050', 'Repaired Necklace', '$5268', 'amulet', 'iron', '5000', '2666', '6362', '0', '0', '-1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '10', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21051', 'Wet Helmet', '$5269', 'helm', 'iron', '40000', '2625', '6357', '0', '-1', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21052', 'Wet Cloak', '$5270', 'cloak', 'cloth', '30000', '2621', '6356', '0', '-2', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21053', 'Wet Armor', '$5271', 'armor', 'iron', '100000', '2620', '6355', '0', '-3', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21054', 'Wet Gloves', '$5272', 'glove', 'iron', '60000', '2624', '6359', '0', '-2', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21055', 'Wet Boots', '$5273', 'boots', 'iron', '40000', '2623', '6358', '0', '-2', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21056', 'Wet Shield', '$5274', 'shield', 'iron', '80000', '2622', '6360', '0', '-1', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21057', 'Cloak of Training Knight', '$5021', 'cloak', 'leather', '10000', '2551', '6128', '2600', '-1', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21058', 'Cloak of Training Knight', '$5021', 'cloak', 'leather', '10000', '2552', '6127', '2600', '-2', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '5', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21059', 'Cloak of Poison Serpent', '$5022', 'cloak', 'leather', '10000', '2562', '6126', '2601', '-4', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '10', '0', '3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21060', 'Halloween Pumpkin Armor', '$5255', 'armor', 'wood', '200000', '2653', '6402', '2792', '-6', '6', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '10', '31', '6', '6', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '7', '0');
update armor set grdgfx = 5040 where item_id = 21025;
update armor set grdgfx = 3840 where item_id = 20366;
update armor set invgfx = 2282 where item_id = 20133;
update armor set grdgfx = 4956 where item_id = 20113;

-- redo dungeon table
drop table dungeon;
-- ----------------------------
-- Table structure for dungeon
-- ----------------------------
CREATE TABLE `dungeon` (
  `src_x` int(10) NOT NULL default '0',
  `src_y` int(10) NOT NULL default '0',
  `src_mapid` int(10) NOT NULL default '0',
  `new_x` int(10) NOT NULL default '0',
  `new_y` int(10) NOT NULL default '0',
  `new_mapid` int(10) NOT NULL default '0',
  `new_heading` int(10) NOT NULL default '1',
  `note` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`src_x`,`src_y`,`src_mapid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='MyISAM free: 8192 kB';

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `dungeon` VALUES ('32477', '32851', '0', '32669', '32802', '1', '4', 'TI->TIC1F');
INSERT INTO `dungeon` VALUES ('32669', '32802', '1', '32477', '32853', '0', '4', 'TIC1F->TI');
INSERT INTO `dungeon` VALUES ('32709', '32839', '1', '32743', '32852', '1', '0', 'TIC1F->TIC1F');
INSERT INTO `dungeon` VALUES ('32713', '32851', '1', '32745', '32809', '1', '0', 'TIC1F->TIC1F');
INSERT INTO `dungeon` VALUES ('32742', '32852', '1', '32709', '32838', '1', '0', 'TIC1F->TIC1F');
INSERT INTO `dungeon` VALUES ('32745', '32810', '1', '32713', '32850', '1', '0', 'TIC1F->TIC1F');
INSERT INTO `dungeon` VALUES ('32737', '32877', '1', '32665', '32789', '2', '4', 'TIC1F->TIC2F');
INSERT INTO `dungeon` VALUES ('32665', '32788', '2', '32738', '32877', '1', '2', 'TIC2F->TIC1F');
INSERT INTO `dungeon` VALUES ('32659', '32873', '2', '32665', '32876', '2', '2', 'TIC2F->TIC2F');
INSERT INTO `dungeon` VALUES ('32664', '32876', '2', '32659', '32872', '2', '0', 'TIC2F->TIC2F');
INSERT INTO `dungeon` VALUES ('32668', '32865', '2', '32680', '32859', '2', '2', 'TIC2F->TIC2F');
INSERT INTO `dungeon` VALUES ('32679', '32859', '2', '32668', '32864', '2', '0', 'TIC2F->TIC2F');
INSERT INTO `dungeon` VALUES ('32789', '32821', '2', '32808', '32837', '2', '4', 'TIC2F->TIC2F');
INSERT INTO `dungeon` VALUES ('32808', '32838', '2', '32789', '32822', '2', '0', 'TIC2F->TIC2F');
INSERT INTO `dungeon` VALUES ('32804', '32873', '2', '32533', '32800', '14', '2', 'TIC2F->MLC7F');
INSERT INTO `dungeon` VALUES ('32510', '32863', '0', '32675', '32814', '3', '0', 'TI->');
INSERT INTO `dungeon` VALUES ('32675', '32815', '3', '32509', '32865', '0', '4', '->TI');
INSERT INTO `dungeon` VALUES ('32728', '32929', '4', '32812', '32724', '7', '4', 'Gludio->MLC1F');
INSERT INTO `dungeon` VALUES ('33194', '32457', '4', '32744', '32813', '16', '4', 'world map>horun');
INSERT INTO `dungeon` VALUES ('33053', '32329', '4', '32747', '32809', '17', '6', '');
INSERT INTO `dungeon` VALUES ('33054', '32329', '4', '32747', '32809', '17', '6', '');
INSERT INTO `dungeon` VALUES ('32938', '32284', '4', '32805', '32724', '19', '4', ' ->EC1F');
INSERT INTO `dungeon` VALUES ('33138', '33357', '4', '32769', '32767', '22', '5', 'SKT>GerardTestDungeon');
INSERT INTO `dungeon` VALUES ('32951', '33502', '4', '32739', '32805', '25', '1', '  -> 1F');
INSERT INTO `dungeon` VALUES ('32970', '33511', '4', '32809', '32810', '25', '6', '  -> 1F');
INSERT INTO `dungeon` VALUES ('32910', '33503', '4', '32733', '32813', '26', '1', '  2-> 2F');
INSERT INTO `dungeon` VALUES ('32927', '33515', '4', '32803', '32815', '26', '1', '  1-> 2F');
INSERT INTO `dungeon` VALUES ('32880', '33511', '4', '32807', '32813', '27', '1', '  2-> 3F');
INSERT INTO `dungeon` VALUES ('33348', '32347', '4', '32727', '32726', '30', '4', ' ->DVC1F·C');
INSERT INTO `dungeon` VALUES ('33374', '32385', '4', '32742', '32777', '30', '4', ' ->DVC1F·D');
INSERT INTO `dungeon` VALUES ('33395', '32325', '4', '32809', '32737', '30', '6', ' ->DVC1F·B');
INSERT INTO `dungeon` VALUES ('33415', '32412', '4', '32810', '32810', '30', '6', ' ->DVC1F·A');
INSERT INTO `dungeon` VALUES ('32779', '32792', '47', '32807', '32805', '43', '0', 'B1-5 -> B1-1');
INSERT INTO `dungeon` VALUES ('32743', '32778', '47', '32794', '32740', '48', '0', 'B1-5 -> B2-1');
INSERT INTO `dungeon` VALUES ('32744', '32778', '47', '32794', '32740', '48', '0', 'B1-5 -> B2-1');
INSERT INTO `dungeon` VALUES ('32740', '32756', '48', '32807', '32762', '50', '0', 'B2-1 -> B1-6');
INSERT INTO `dungeon` VALUES ('32740', '32757', '48', '32807', '32762', '50', '0', 'B2-1 -> B1-6');
INSERT INTO `dungeon` VALUES ('32755', '33208', '4', '32783', '32751', '43', '0', ' -> B1-1');
INSERT INTO `dungeon` VALUES ('32914', '33220', '4', '32798', '32754', '44', '0', ' -> B1-2');
INSERT INTO `dungeon` VALUES ('32789', '33255', '4', '32776', '32731', '45', '0', ' -> B1-3');
INSERT INTO `dungeon` VALUES ('32848', '33294', '4', '32787', '32795', '46', '0', ' -> B1-4');
INSERT INTO `dungeon` VALUES ('32839', '33172', '4', '32796', '32745', '47', '0', ' -> B1-5');
INSERT INTO `dungeon` VALUES ('32788', '33149', '4', '32768', '32805', '50', '0', ' -> B1-6');
INSERT INTO `dungeon` VALUES ('32807', '32806', '43', '32779', '32793', '47', '0', 'B1-1 -> B1-5');
INSERT INTO `dungeon` VALUES ('32808', '32806', '43', '32779', '32793', '47', '0', 'B1-1 -> B1-5');
INSERT INTO `dungeon` VALUES ('32737', '32781', '44', '32781', '32732', '49', '0', 'B1-2 -> B2-2');
INSERT INTO `dungeon` VALUES ('32737', '32782', '44', '32781', '32732', '49', '0', 'B1-2 -> B2-2');
INSERT INTO `dungeon` VALUES ('32769', '32791', '45', '32745', '32759', '50', '0', 'B1-3 -> B1-6');
INSERT INTO `dungeon` VALUES ('32770', '32791', '45', '32745', '32759', '50', '0', 'B1-3 -> B1-6');
INSERT INTO `dungeon` VALUES ('32790', '32796', '46', '32745', '32783', '49', '0', 'B1-4 -> B2-2');
INSERT INTO `dungeon` VALUES ('32791', '32796', '46', '32745', '32783', '49', '0', 'B1-4 -> B2-2');
INSERT INTO `dungeon` VALUES ('32778', '32792', '47', '32807', '32805', '43', '0', 'B1-5 -> B1-1');
INSERT INTO `dungeon` VALUES ('32740', '32758', '48', '32807', '32762', '50', '0', 'B2-1 -> B1-6');
INSERT INTO `dungeon` VALUES ('32794', '32739', '48', '32744', '32777', '47', '0', 'B2-1 -> B1-5');
INSERT INTO `dungeon` VALUES ('32795', '32739', '48', '32744', '32777', '47', '0', 'B2-1 -> B1-5');
INSERT INTO `dungeon` VALUES ('32778', '32801', '48', '32747', '32790', '541', '0', 'B2-1 -> A');
INSERT INTO `dungeon` VALUES ('32778', '32802', '48', '32747', '32790', '541', '0', 'B2-1 -> A');
INSERT INTO `dungeon` VALUES ('32782', '32731', '49', '32738', '32781', '44', '0', 'B2-2 -> B1-2');
INSERT INTO `dungeon` VALUES ('32782', '32732', '49', '32738', '32781', '44', '0', 'B2-2 -> B1-2');
INSERT INTO `dungeon` VALUES ('32782', '32733', '49', '32738', '32781', '44', '0', 'B2-2 -> B1-2');
INSERT INTO `dungeon` VALUES ('32745', '32782', '49', '32791', '32795', '46', '0', 'B2-2 -> B1-4');
INSERT INTO `dungeon` VALUES ('32746', '32782', '49', '32791', '32795', '46', '0', 'B2-2 -> B1-4');
INSERT INTO `dungeon` VALUES ('32779', '32778', '49', '32747', '32790', '542', '0', 'B2-2 -> B');
INSERT INTO `dungeon` VALUES ('32779', '32779', '49', '32747', '32790', '542', '0', 'B2-2 -> B');
INSERT INTO `dungeon` VALUES ('32745', '32758', '50', '32770', '32790', '45', '0', 'B1-6 -> B1-3');
INSERT INTO `dungeon` VALUES ('32746', '32758', '50', '32770', '32790', '45', '0', 'B1-6 -> B1-3');
INSERT INTO `dungeon` VALUES ('32806', '32763', '50', '32739', '32757', '48', '0', 'B1-6 -> B2-1');
INSERT INTO `dungeon` VALUES ('32807', '32763', '50', '32739', '32757', '48', '0', 'B1-6 -> B2-1');
INSERT INTO `dungeon` VALUES ('32724', '32743', '51', '32722', '32820', '541', '0', 'B3 -> A');
INSERT INTO `dungeon` VALUES ('32725', '32743', '51', '32722', '32820', '541', '0', 'B3 -> A');
INSERT INTO `dungeon` VALUES ('32726', '32743', '51', '32722', '32820', '541', '0', 'B3 -> A');
INSERT INTO `dungeon` VALUES ('32794', '32846', '51', '32723', '32822', '542', '0', 'B3 -> B');
INSERT INTO `dungeon` VALUES ('32794', '32847', '51', '32723', '32822', '542', '0', 'B3 -> B');
INSERT INTO `dungeon` VALUES ('32794', '32848', '51', '32723', '32822', '542', '0', 'B3 -> B');
INSERT INTO `dungeon` VALUES ('32679', '32848', '51', '32873', '32750', '543', '0', 'B3 -> B4');
INSERT INTO `dungeon` VALUES ('32679', '32849', '51', '32873', '32750', '543', '0', 'B3 -> B4');
INSERT INTO `dungeon` VALUES ('32679', '32850', '51', '32873', '32750', '543', '0', 'B3 -> B4');
INSERT INTO `dungeon` VALUES ('32748', '32789', '541', '32779', '32801', '48', '0', 'A -> B2-1');
INSERT INTO `dungeon` VALUES ('32748', '32790', '541', '32779', '32801', '48', '0', 'A -> B2-1');
INSERT INTO `dungeon` VALUES ('32748', '32791', '541', '32779', '32801', '48', '0', 'A -> B2-1');
INSERT INTO `dungeon` VALUES ('32721', '32821', '541', '32725', '32744', '51', '0', 'A -> B3');
INSERT INTO `dungeon` VALUES ('32722', '32821', '541', '32725', '32744', '51', '0', 'A -> B3');
INSERT INTO `dungeon` VALUES ('32748', '32789', '542', '32780', '32778', '49', '0', 'B -> B2-2');
INSERT INTO `dungeon` VALUES ('32748', '32790', '542', '32780', '32778', '49', '0', 'B -> B2-2');
INSERT INTO `dungeon` VALUES ('32748', '32791', '542', '32780', '32778', '49', '0', 'B -> B2-2');
INSERT INTO `dungeon` VALUES ('32721', '32823', '542', '32793', '32847', '51', '0', 'B -> B3');
INSERT INTO `dungeon` VALUES ('32722', '32823', '542', '32793', '32847', '51', '0', 'B -> B3');
INSERT INTO `dungeon` VALUES ('32874', '32749', '543', '32680', '32849', '51', '0', 'B4 -> B3');
INSERT INTO `dungeon` VALUES ('32874', '32750', '543', '32680', '32849', '51', '0', 'B4 -> B3');
INSERT INTO `dungeon` VALUES ('32874', '32751', '543', '32680', '32849', '51', '0', 'B4 -> B3');
INSERT INTO `dungeon` VALUES ('33311', '33061', '4', '32810', '32731', '53', '6', '->1F');
INSERT INTO `dungeon` VALUES ('33627', '33502', '4', '32708', '32789', '59', '4', ' -> 1F');
INSERT INTO `dungeon` VALUES ('33631', '32369', '4', '32738', '32868', '66', '2', '->8');
INSERT INTO `dungeon` VALUES ('33675', '32409', '4', '32810', '32934', '66', '2', '->4');
INSERT INTO `dungeon` VALUES ('33734', '32216', '4', '32797', '32746', '67', '6', ' -> ');
INSERT INTO `dungeon` VALUES ('32178', '32182', '4', '32746', '32787', '72', '4', ' -> CrystalCave 1F  B');
INSERT INTO `dungeon` VALUES ('34177', '32182', '4', '32746', '32787', '72', '4', ' ->CrystalCave1F·B');
INSERT INTO `dungeon` VALUES ('34214', '32248', '4', '32814', '32804', '72', '6', ' ->CrystalCave1F·A');
INSERT INTO `dungeon` VALUES ('34214', '32249', '4', '32814', '32804', '72', '6', ' ->CrystalCave1F·A');
INSERT INTO `dungeon` VALUES ('34041', '32154', '4', '32764', '32902', '75', '0', '->IT1F');
INSERT INTO `dungeon` VALUES ('34042', '32154', '4', '32764', '32902', '75', '0', '->IT1F');
INSERT INTO `dungeon` VALUES ('33423', '33502', '4', '32735', '32794', '83', '4', '->FI');
INSERT INTO `dungeon` VALUES ('34256', '33450', '4', '32725', '32799', '101', '2', ' ->TOI1F');
INSERT INTO `dungeon` VALUES ('34256', '33451', '4', '32725', '32799', '101', '2', ' ->TOI1F');
INSERT INTO `dungeon` VALUES ('34256', '33452', '4', '32725', '32799', '101', '2', ' ->TOI1F');
INSERT INTO `dungeon` VALUES ('34151', '33382', '4', '32678', '32790', '301', '2', '->1F');
INSERT INTO `dungeon` VALUES ('33388', '32272', '4', '32625', '32803', '304', '5', 'WorldMap->SilentCavern 1');
INSERT INTO `dungeon` VALUES ('33388', '32273', '4', '32625', '32803', '304', '5', 'WorldMap->SilentCavern 2');
INSERT INTO `dungeon` VALUES ('32565', '33460', '4', '32761', '32822', '307', '2', '-> 1');
INSERT INTO `dungeon` VALUES ('32812', '32723', '7', '32728', '32929', '4', '5', 'MLC1F->MLC ');
INSERT INTO `dungeon` VALUES ('32740', '32807', '7', '32750', '32798', '8', '4', 'MLC1F->MLC2F');
INSERT INTO `dungeon` VALUES ('32750', '32797', '8', '32740', '32806', '7', '0', 'MLC2F->MLC1F');
INSERT INTO `dungeon` VALUES ('32726', '32744', '8', '32773', '32807', '8', '2', '2C->2C');
INSERT INTO `dungeon` VALUES ('32736', '32772', '8', '32737', '32812', '8', '2', '2D->2D');
INSERT INTO `dungeon` VALUES ('32738', '32813', '8', '32737', '32772', '8', '2', '2D->2D');
INSERT INTO `dungeon` VALUES ('32741', '32745', '8', '32797', '32803', '8', '2', '2B->2B');
INSERT INTO `dungeon` VALUES ('32767', '32734', '8', '32811', '32761', '8', '2', '2A->2A');
INSERT INTO `dungeon` VALUES ('32773', '32808', '8', '32727', '32744', '8', '2', '2C->2C');
INSERT INTO `dungeon` VALUES ('32797', '32745', '8', '32742', '32745', '8', '2', '2B->2B');
INSERT INTO `dungeon` VALUES ('32811', '32762', '8', '32767', '32733', '8', '2', '2A->2A');
INSERT INTO `dungeon` VALUES ('32794', '32728', '8', '32801', '32754', '9', '4', 'MLC2F->MLC3F');
INSERT INTO `dungeon` VALUES ('32802', '32754', '9', '32795', '32728', '8', '2', 'MLC3F->MLC2F');
INSERT INTO `dungeon` VALUES ('32771', '32765', '9', '32763', '32773', '10', '4', 'MLC3F->MLC4F');
INSERT INTO `dungeon` VALUES ('32764', '32772', '10', '32771', '32764', '9', '0', 'MLC4F->MLC3F');
INSERT INTO `dungeon` VALUES ('32726', '32737', '10', '32728', '32723', '11', '4', 'MLC4F->MLC5F');
INSERT INTO `dungeon` VALUES ('32729', '32722', '11', '32727', '32737', '10', '2', 'MLC5F->MLC4F');
INSERT INTO `dungeon` VALUES ('32735', '32739', '11', '32768', '32805', '11', '2', '5B->5B');
INSERT INTO `dungeon` VALUES ('32745', '32805', '11', '32757', '32804', '11', '2', '5A->5A');
INSERT INTO `dungeon` VALUES ('32757', '32805', '11', '32745', '32804', '11', '2', '5A->5A');
INSERT INTO `dungeon` VALUES ('32763', '32738', '11', '32773', '32765', '11', '2', '5C->5C');
INSERT INTO `dungeon` VALUES ('32768', '32806', '11', '32736', '32739', '11', '2', '5B->5B');
INSERT INTO `dungeon` VALUES ('32772', '32765', '11', '32764', '32738', '11', '2', '5C->5C');
INSERT INTO `dungeon` VALUES ('32797', '32810', '11', '32804', '32725', '12', '4', 'MLC5F->MLC6F');
INSERT INTO `dungeon` VALUES ('32805', '32724', '12', '32797', '32809', '11', '2', 'MLC6F->MLC5F');
INSERT INTO `dungeon` VALUES ('32728', '32768', '12', '32764', '32754', '12', '2', '6A->6A');
INSERT INTO `dungeon` VALUES ('32764', '32755', '12', '32729', '32768', '12', '2', '6A->6A');
INSERT INTO `dungeon` VALUES ('32770', '32811', '12', '32727', '32725', '13', '4', 'MLC6F->MLC7F');
INSERT INTO `dungeon` VALUES ('32727', '32724', '13', '32770', '32810', '12', '2', 'MLC7F->MLC6F');
INSERT INTO `dungeon` VALUES ('32764', '32766', '13', '32780', '32741', '13', '2', '7B->7B');
INSERT INTO `dungeon` VALUES ('32780', '32742', '13', '32765', '32766', '13', '2', '7B->7B');
INSERT INTO `dungeon` VALUES ('32786', '32795', '13', '32811', '32729', '13', '2', '7A->7A');
INSERT INTO `dungeon` VALUES ('32801', '32803', '13', '32808', '32802', '13', '2', 'MLC7F->MLC7F_');
INSERT INTO `dungeon` VALUES ('32808', '32802', '13', '32801', '32803', '13', '6', 'MLC7F_ ->MLC7F');
INSERT INTO `dungeon` VALUES ('32811', '32730', '13', '32787', '32795', '13', '2', '7A->7A');
INSERT INTO `dungeon` VALUES ('32806', '32724', '13', '33000', '32808', '14', '7', 'MLC7F->');
INSERT INTO `dungeon` VALUES ('32813', '32810', '13', '32736', '32807', '237', '5', 'MLC7F>JimDungeon');
INSERT INTO `dungeon` VALUES ('32534', '32800', '14', '32803', '32873', '2', '6', ' ->    2F');
INSERT INTO `dungeon` VALUES ('33000', '32808', '14', '32807', '32724', '13', '2', '->MLC7F');
INSERT INTO `dungeon` VALUES ('32744', '32815', '16', '33194', '32458', '4', '0', 'horun>world map');
INSERT INTO `dungeon` VALUES ('32748', '32808', '17', '33054', '32328', '4', '0', '');
INSERT INTO `dungeon` VALUES ('32748', '32809', '17', '33054', '32328', '4', '0', '');
INSERT INTO `dungeon` VALUES ('32805', '32723', '19', '32938', '32283', '4', '0', 'EC1F-> ');
INSERT INTO `dungeon` VALUES ('32723', '32725', '19', '32788', '32758', '19', '2', 'EC1F·2');
INSERT INTO `dungeon` VALUES ('32727', '32797', '19', '32796', '32795', '19', '0', 'EC1F·1');
INSERT INTO `dungeon` VALUES ('32787', '32758', '19', '32724', '32725', '19', '2', 'EC1F·2');
INSERT INTO `dungeon` VALUES ('32796', '32796', '19', '32728', '32797', '19', '2', 'EC1F·1');
INSERT INTO `dungeon` VALUES ('32772', '32783', '19', '32766', '32796', '20', '4', 'EC1F->EC2F');
INSERT INTO `dungeon` VALUES ('32767', '32795', '20', '32772', '32782', '19', '0', 'EC2F->EC1F');
INSERT INTO `dungeon` VALUES ('32763', '32754', '20', '32807', '32791', '20', '0', 'EC2F·');
INSERT INTO `dungeon` VALUES ('32807', '32792', '20', '32764', '32754', '20', '2', 'EC2F·');
INSERT INTO `dungeon` VALUES ('32730', '32732', '20', '32731', '32736', '21', '6', 'EC2F->EC3F');
INSERT INTO `dungeon` VALUES ('32732', '32736', '21', '32731', '32732', '20', '2', 'EC3F->EC2F');
INSERT INTO `dungeon` VALUES ('32736', '32799', '21', '32760', '32763', '21', '0', 'EC3F');
INSERT INTO `dungeon` VALUES ('32760', '32764', '21', '32737', '32799', '21', '2', 'EC3F');
INSERT INTO `dungeon` VALUES ('32778', '32738', '21', '32781', '32728', '21', '2', 'EC3f');
INSERT INTO `dungeon` VALUES ('32781', '32728', '21', '32778', '32738', '21', '6', 'EC3f');
INSERT INTO `dungeon` VALUES ('32777', '32796', '21', '32657', '32872', '32', '2', 'EC3F->DVC3F');
INSERT INTO `dungeon` VALUES ('32769', '32767', '22', '33138', '33357', '4', '2', 'GerardTestDungeon>SKT');
INSERT INTO `dungeon` VALUES ('32727', '32814', '23', '32808', '32814', '24', '4', 'WWC1F>WWC2F');
INSERT INTO `dungeon` VALUES ('32808', '32814', '24', '32727', '32814', '23', '4', 'WWC2F>WWC1F');
INSERT INTO `dungeon` VALUES ('32738', '32806', '25', '32951', '33503', '4', '4', ' 1F->  1');
INSERT INTO `dungeon` VALUES ('32809', '32811', '25', '32970', '33512', '4', '4', ' 1F->  ');
INSERT INTO `dungeon` VALUES ('32732', '32814', '26', '32910', '33505', '4', '4', ' 2F->  2');
INSERT INTO `dungeon` VALUES ('32802', '32816', '26', '32927', '33516', '4', '1', ' 2F->  ');
INSERT INTO `dungeon` VALUES ('32806', '32814', '27', '32880', '33511', '4', '4', ' 3F->  2');
INSERT INTO `dungeon` VALUES ('32723', '32742', '27', '32799', '32798', '28', '4', ' 3F-> 4F');
INSERT INTO `dungeon` VALUES ('32799', '32797', '28', '32723', '32741', '27', '0', ' 4F-> 3F');
INSERT INTO `dungeon` VALUES ('32742', '32790', '29', '32811', '32722', '23', '4', 'WW>WWC1F');
INSERT INTO `dungeon` VALUES ('32811', '32722', '23', '32742', '32790', '29', '4', 'WWC1F>WW');
INSERT INTO `dungeon` VALUES ('32727', '32726', '30', '33348', '32348', '4', '4', 'DVC1F->  C');
INSERT INTO `dungeon` VALUES ('32742', '32776', '30', '33373', '32385', '4', '6', 'DVC1F->  D');
INSERT INTO `dungeon` VALUES ('32810', '32737', '30', '33395', '32326', '4', '4', 'DVC1F->  B');
INSERT INTO `dungeon` VALUES ('32811', '32810', '30', '33414', '32412', '4', '6', 'DVC1F->  A');
INSERT INTO `dungeon` VALUES ('32732', '32813', '30', '32760', '32781', '31', '4', 'DVC1F->DVC2F·A2');
INSERT INTO `dungeon` VALUES ('32733', '32813', '30', '32760', '32781', '31', '4', 'DVC1F->DVC2F·A');
INSERT INTO `dungeon` VALUES ('32740', '32761', '30', '32762', '32749', '31', '4', 'DVC1F->DVC2F·C2');
INSERT INTO `dungeon` VALUES ('32741', '32761', '30', '32762', '32749', '31', '4', 'DVC1F->DVC2F·C');
INSERT INTO `dungeon` VALUES ('32767', '32759', '30', '32803', '32760', '31', '6', 'DVC1F->DVC2F·D');
INSERT INTO `dungeon` VALUES ('32767', '32760', '30', '32803', '32760', '31', '6', 'DVC1F->DVC2F·D2');
INSERT INTO `dungeon` VALUES ('32772', '32774', '30', '32788', '32782', '31', '6', 'DVC1F->DVC2F·B2');
INSERT INTO `dungeon` VALUES ('32772', '32775', '30', '32788', '32782', '31', '6', 'DVC1F->DVC2F·B');
INSERT INTO `dungeon` VALUES ('32760', '32780', '31', '32733', '32812', '30', '0', 'DVC2F->DVC1F·A');
INSERT INTO `dungeon` VALUES ('32762', '32748', '31', '32741', '32760', '30', '0', 'DVC2F->DVC1F·C');
INSERT INTO `dungeon` VALUES ('32789', '32782', '31', '32773', '32774', '30', '2', 'DVC2F->DVC1F·B');
INSERT INTO `dungeon` VALUES ('32804', '32760', '31', '32768', '32759', '30', '2', 'DVC2F->DVC1F·D');
INSERT INTO `dungeon` VALUES ('32772', '32747', '31', '32709', '32818', '32', '4', 'DVC2F->DVC3F');
INSERT INTO `dungeon` VALUES ('32657', '32872', '32', '32777', '32796', '21', '0', 'DVCC3F->EC3F');
INSERT INTO `dungeon` VALUES ('32710', '32817', '32', '32773', '32747', '31', '1', 'DVC3F->DVC2F');
INSERT INTO `dungeon` VALUES ('32746', '32859', '32', '32670', '32868', '33', '4', 'DVC3F->DVC4F');
INSERT INTO `dungeon` VALUES ('32747', '32859', '32', '32670', '32868', '33', '4', 'DVC3F->DVC4F');
INSERT INTO `dungeon` VALUES ('32670', '32867', '33', '32746', '32858', '32', '0', 'DVC4F->DVC3F');
INSERT INTO `dungeon` VALUES ('32728', '32825', '33', '32746', '32801', '35', '6', 'DVC4F->DVC5F');
INSERT INTO `dungeon` VALUES ('32729', '32825', '33', '32746', '32801', '35', '6', 'DVC4F->DVC5F');
INSERT INTO `dungeon` VALUES ('32747', '32801', '35', '32728', '32824', '33', '0', 'DVC5F->DVC4F');
INSERT INTO `dungeon` VALUES ('32660', '32838', '35', '32664', '32846', '36', '4', 'DVC5F->DVC6F');
INSERT INTO `dungeon` VALUES ('32660', '32839', '35', '32664', '32846', '36', '4', 'DVC5F->DVC6F');
INSERT INTO `dungeon` VALUES ('32664', '32845', '36', '32661', '32838', '35', '2', 'DVC6F->DVC5F');
INSERT INTO `dungeon` VALUES ('32746', '32824', '36', '32667', '32868', '37', '6', 'DVC6F->DVC7F');
INSERT INTO `dungeon` VALUES ('32747', '32824', '36', '32667', '32868', '37', '6', 'DVC6F->DVC7F');
INSERT INTO `dungeon` VALUES ('32669', '32868', '37', '32746', '32823', '36', '2', 'DVC7F->DVC6F');
INSERT INTO `dungeon` VALUES ('32811', '32730', '53', '33312', '33061', '4', '2', '1F->');
INSERT INTO `dungeon` VALUES ('32811', '32731', '53', '33312', '33061', '4', '2', '1F->');
INSERT INTO `dungeon` VALUES ('32732', '32787', '53', '32810', '32794', '54', '6', '1F->2F');
INSERT INTO `dungeon` VALUES ('32811', '32793', '54', '32732', '32786', '53', '0', '2F->1F');
INSERT INTO `dungeon` VALUES ('32811', '32794', '54', '32732', '32786', '53', '0', '2F->1F');
INSERT INTO `dungeon` VALUES ('32735', '32726', '54', '32750', '32774', '54', '0', '2F ');
INSERT INTO `dungeon` VALUES ('32750', '32775', '54', '32736', '32726', '54', '2', '2F ');
INSERT INTO `dungeon` VALUES ('32728', '32811', '54', '32735', '32728', '55', '4', '2F->3F');
INSERT INTO `dungeon` VALUES ('32735', '32727', '55', '32728', '32810', '54', '0', '3F->2F');
INSERT INTO `dungeon` VALUES ('32736', '32727', '55', '32728', '32810', '54', '0', '3F->2F');
INSERT INTO `dungeon` VALUES ('32736', '32855', '55', '32769', '32730', '56', '4', '3F->4F');
INSERT INTO `dungeon` VALUES ('32769', '32729', '56', '32736', '32854', '55', '0', '4F->3F');
INSERT INTO `dungeon` VALUES ('32770', '32729', '56', '32736', '32854', '55', '0', '4F->3F');
INSERT INTO `dungeon` VALUES ('32709', '32788', '59', '33627', '33503', '4', '4', ' 1F-> ');
INSERT INTO `dungeon` VALUES ('32663', '32867', '59', '32745', '32858', '60', '6', ' 1F-> 2F');
INSERT INTO `dungeon` VALUES ('32747', '32851', '59', '32744', '32839', '62', '0', 'HC1F->');
INSERT INTO `dungeon` VALUES ('32746', '32857', '60', '32664', '32867', '59', '2', ' 2F-> 1F');
INSERT INTO `dungeon` VALUES ('32706', '32809', '60', '32727', '32807', '61', '4', ' 2F-> 3F');
INSERT INTO `dungeon` VALUES ('32728', '32806', '61', '32704', '32809', '60', '6', ' 3F-> 2F');
INSERT INTO `dungeon` VALUES ('32695', '32824', '61', '32806', '32869', '63', '6', ' 3F-> ');
INSERT INTO `dungeon` VALUES ('32744', '32839', '62', '32746', '32852', '59', '6', '>HC1F');
INSERT INTO `dungeon` VALUES ('32733', '32790', '62', '32572', '32833', '64', '6', '');
INSERT INTO `dungeon` VALUES ('32733', '32791', '62', '32572', '32833', '64', '6', '>');
INSERT INTO `dungeon` VALUES ('32807', '32868', '63', '32694', '32826', '61', '4', '  -> 3F');
INSERT INTO `dungeon` VALUES ('32738', '32674', '63', '32750', '32870', '65', '1', '  ->');
INSERT INTO `dungeon` VALUES ('32572', '32833', '64', '32733', '32791', '62', '4', '>');
INSERT INTO `dungeon` VALUES ('32761', '32870', '65', '32738', '32675', '63', '4', '->  ');
INSERT INTO `dungeon` VALUES ('32737', '32868', '66', '33630', '32369', '4', '2', '8->');
INSERT INTO `dungeon` VALUES ('32810', '32935', '66', '33675', '32410', '4', '2', '4->');
INSERT INTO `dungeon` VALUES ('32798', '32746', '67', '33734', '32217', '4', '4', ' -> ');
INSERT INTO `dungeon` VALUES ('32945', '33012', '70', '32826', '32850', '70', '0', 'FI->FI');
INSERT INTO `dungeon` VALUES ('32936', '33058', '70', '32732', '32796', '84', '4', 'FI->');
INSERT INTO `dungeon` VALUES ('32746', '32786', '72', '34177', '32183', '4', '4', 'CrystalCave1F->OrenGlacialLakeB');
INSERT INTO `dungeon` VALUES ('32747', '32786', '72', '34177', '32183', '4', '4', 'CrystalCave1F->OrenGlacialLakeB');
INSERT INTO `dungeon` VALUES ('32815', '32803', '72', '34213', '32249', '4', '6', 'CrystalCave1F->OrenGlacialLakeA');
INSERT INTO `dungeon` VALUES ('32815', '32804', '72', '34213', '32249', '4', '6', 'CrystalCave1F->OrenGlacialLakeA');
INSERT INTO `dungeon` VALUES ('32726', '32861', '72', '32755', '32870', '73', '6', 'CrystalCave1F->CrystalCave2F');
INSERT INTO `dungeon` VALUES ('32726', '32862', '72', '32755', '32870', '73', '6', 'CrystalCave1F->CrystalCave2F');
INSERT INTO `dungeon` VALUES ('32725', '32845', '73', '33970', '32338', '4', '2', 'CrystalCave 2F->OrenGlacialLake');
INSERT INTO `dungeon` VALUES ('32725', '32846', '73', '33970', '32338', '4', '2', 'CrystalCave 2F->OrenGlacialLake');
INSERT INTO `dungeon` VALUES ('33969', '32337', '4', '32726', '32845', '73', '2', 'OrenGlacialLake->CrystalCave 2F');
INSERT INTO `dungeon` VALUES ('33969', '32338', '4', '32726', '32845', '73', '2', 'OrenGlacialLake->CrystalCave 2F');
INSERT INTO `dungeon` VALUES ('32756', '32870', '73', '32727', '32861', '72', '2', 'CrystalCave2F->CrystalCave1F');
INSERT INTO `dungeon` VALUES ('32756', '32871', '73', '32727', '32861', '72', '2', 'CrystalCave2F->CrystalCave1F');
INSERT INTO `dungeon` VALUES ('32797', '32808', '73', '32732', '32854', '74', '4', 'CrystalCave2F->CrystalCave3F');
INSERT INTO `dungeon` VALUES ('32797', '32809', '73', '32732', '32854', '74', '4', 'CrystalCave2F->CrystalCave3F');
INSERT INTO `dungeon` VALUES ('32731', '32853', '74', '32798', '32808', '73', '2', 'CrystalCave3F->CrystalCave2F');
INSERT INTO `dungeon` VALUES ('32732', '32853', '74', '32798', '32808', '73', '2', 'CrystalCave3F->CrystalCave2F');
INSERT INTO `dungeon` VALUES ('32763', '32903', '75', '34041', '32155', '4', '4', 'IvoryTower1F->Oren');
INSERT INTO `dungeon` VALUES ('32764', '32903', '75', '34041', '32155', '4', '4', 'IvoryTower1F->Oren');
INSERT INTO `dungeon` VALUES ('32773', '32821', '75', '32776', '32820', '76', '6', 'IvoryTower1F->IvoryTower2F');
INSERT INTO `dungeon` VALUES ('32773', '32822', '75', '32776', '32820', '76', '6', 'IvoryTower1F->IvoryTower2F');
INSERT INTO `dungeon` VALUES ('32777', '32819', '76', '32772', '32822', '75', '6', 'IvoryTower2F->IvoryTower1F');
INSERT INTO `dungeon` VALUES ('32777', '32820', '76', '32772', '32822', '75', '6', 'IvoryTower2F->IvoryTower1F');
INSERT INTO `dungeon` VALUES ('32777', '32826', '76', '32766', '32835', '77', '6', 'IvoryTower2F->IvoryTower3F');
INSERT INTO `dungeon` VALUES ('32777', '32827', '76', '32766', '32835', '77', '6', 'IvoryTower2F->IvoryTower3F');
INSERT INTO `dungeon` VALUES ('32767', '32834', '77', '32776', '32827', '76', '6', 'IvoryTower3F->IvoryTower2F');
INSERT INTO `dungeon` VALUES ('32767', '32835', '77', '32776', '32827', '76', '6', 'IvoryTower3F->IvoryTower2F');
INSERT INTO `dungeon` VALUES ('32767', '32841', '77', '32894', '32771', '78', '6', 'IvoryTower3F->IvoryTower4F');
INSERT INTO `dungeon` VALUES ('32767', '32842', '77', '32894', '32771', '78', '6', 'IvoryTower3F->IvoryTower4F');
INSERT INTO `dungeon` VALUES ('32895', '32770', '78', '32766', '32842', '77', '6', 'IvoryTower4F->IvoryTower3F');
INSERT INTO `dungeon` VALUES ('32895', '32771', '78', '32766', '32842', '77', '6', 'IvoryTower4F->IvoryTower3F');
INSERT INTO `dungeon` VALUES ('32923', '32793', '78', '32772', '32804', '79', '5', 'IvoryTower4F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32923', '32795', '78', '32772', '32804', '79', '5', 'IvoryTower4F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32924', '32792', '78', '32772', '32804', '79', '5', 'IvoryTower4F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32924', '32796', '78', '32772', '32804', '79', '5', 'IvoryTower4F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32926', '32792', '78', '32772', '32804', '79', '5', 'IvoryTower4F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32926', '32796', '78', '32772', '32804', '79', '5', 'IvoryTower4F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32927', '32793', '78', '32772', '32804', '79', '5', 'IvoryTower4F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32927', '32795', '78', '32772', '32804', '79', '5', 'IvoryTower4F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32772', '32801', '79', '32923', '32792', '78', '7', 'IvoryTower5F->IvoryTower4F');
INSERT INTO `dungeon` VALUES ('32772', '32803', '79', '32923', '32792', '78', '7', 'IvoryTower5F->IvoryTower4F');
INSERT INTO `dungeon` VALUES ('32773', '32800', '79', '32923', '32792', '78', '7', 'IvoryTower5F->IvoryTower4F');
INSERT INTO `dungeon` VALUES ('32773', '32804', '79', '32923', '32792', '78', '7', 'IvoryTower5F->IvoryTower4F');
INSERT INTO `dungeon` VALUES ('32775', '32800', '79', '32923', '32792', '78', '7', 'IvoryTower5F->IvoryTower4F');
INSERT INTO `dungeon` VALUES ('32775', '32804', '79', '32923', '32792', '78', '7', 'IvoryTower5F->IvoryTower4F');
INSERT INTO `dungeon` VALUES ('32776', '32801', '79', '32923', '32792', '78', '7', 'IvoryTower5F->IvoryTower4F');
INSERT INTO `dungeon` VALUES ('32776', '32803', '79', '32923', '32792', '78', '7', 'IvoryTower5F->IvoryTower4F');
INSERT INTO `dungeon` VALUES ('32803', '32826', '79', '32751', '32800', '80', '3', 'IvoryTower5F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32803', '32828', '79', '32751', '32800', '80', '3', 'IvoryTower5F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32804', '32825', '79', '32751', '32800', '80', '3', 'IvoryTower5F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32804', '32829', '79', '32751', '32800', '80', '3', 'IvoryTower5F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32806', '32825', '79', '32751', '32800', '80', '3', 'IvoryTower5F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32806', '32829', '79', '32751', '32800', '80', '3', 'IvoryTower5F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32807', '32826', '79', '32751', '32800', '80', '3', 'IvoryTower5F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32807', '32828', '79', '32751', '32800', '80', '3', 'IvoryTower5F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32747', '32797', '80', '32803', '32825', '79', '7', 'IvoryTower6F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32747', '32799', '80', '32803', '32825', '79', '7', 'IvoryTower6F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32748', '32796', '80', '32803', '32825', '79', '7', 'IvoryTower6F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32748', '32800', '80', '32803', '32825', '79', '7', 'IvoryTower6F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32750', '32800', '80', '32803', '32825', '79', '7', 'IvoryTower6F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32751', '32799', '80', '32803', '32825', '79', '7', 'IvoryTower6F->IvoryTower5F');
INSERT INTO `dungeon` VALUES ('32771', '32848', '80', '32763', '32848', '81', '7', 'IvoryTower6F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32771', '32850', '80', '32763', '32848', '81', '7', 'IvoryTower6F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32772', '32847', '80', '32763', '32848', '81', '7', 'IvoryTower6F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32772', '32851', '80', '32763', '32848', '81', '7', 'IvoryTower6F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32774', '32847', '80', '32763', '32848', '81', '7', 'IvoryTower6F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32774', '32851', '80', '32763', '32848', '81', '7', 'IvoryTower6F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32775', '32848', '80', '32763', '32848', '81', '7', 'IvoryTower6F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32775', '32850', '80', '32763', '32848', '81', '7', 'IvoryTower6F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32763', '32845', '81', '32771', '32847', '80', '7', 'IvoryTower7F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32763', '32847', '81', '32771', '32847', '80', '7', 'IvoryTower7F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32764', '32844', '81', '32771', '32847', '80', '7', 'IvoryTower7F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32764', '32848', '81', '32771', '32847', '80', '7', 'IvoryTower7F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32766', '32844', '81', '32771', '32847', '80', '7', 'IvoryTower7F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32766', '32848', '81', '32771', '32847', '80', '7', 'IvoryTower7F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32767', '32845', '81', '32771', '32847', '80', '7', 'IvoryTower7F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32767', '32847', '81', '32771', '32847', '80', '7', 'IvoryTower7F->IvoryTower6F');
INSERT INTO `dungeon` VALUES ('32802', '32794', '81', '32738', '32797', '82', '5', 'IvoryTower7F->IvoryTower8F');
INSERT INTO `dungeon` VALUES ('32802', '32796', '81', '32738', '32797', '82', '5', 'IvoryTower7F->IvoryTower8F');
INSERT INTO `dungeon` VALUES ('32803', '32793', '81', '32738', '32797', '82', '5', 'IvoryTower7F->IvoryTower8F');
INSERT INTO `dungeon` VALUES ('32803', '32797', '81', '32738', '32797', '82', '5', 'IvoryTower7F->IvoryTower8F');
INSERT INTO `dungeon` VALUES ('32805', '32793', '81', '32738', '32797', '82', '5', 'IvoryTower7F->IvoryTower8F');
INSERT INTO `dungeon` VALUES ('32805', '32797', '81', '32738', '32797', '82', '5', 'IvoryTower7F->IvoryTower8F');
INSERT INTO `dungeon` VALUES ('32806', '32794', '81', '32738', '32797', '82', '5', 'IvoryTower7F->IvoryTower8F');
INSERT INTO `dungeon` VALUES ('32806', '32796', '81', '32738', '32797', '82', '5', 'IvoryTower7F->IvoryTower8F');
INSERT INTO `dungeon` VALUES ('32738', '32794', '82', '32802', '32797', '81', '5', 'IvoryTower8F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32738', '32796', '82', '32802', '32797', '81', '5', 'IvoryTower8F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32739', '32793', '82', '32802', '32797', '81', '5', 'IvoryTower8F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32739', '32797', '82', '32802', '32797', '81', '5', 'IvoryTower8F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32741', '32793', '82', '32802', '32797', '81', '5', 'IvoryTower8F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32741', '32797', '82', '32802', '32797', '81', '5', 'IvoryTower8F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32742', '32794', '82', '32802', '32797', '81', '5', 'IvoryTower8F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32742', '32796', '82', '32802', '32797', '81', '5', 'IvoryTower8F->IvoryTower7F');
INSERT INTO `dungeon` VALUES ('32735', '32794', '83', '33423', '33502', '4', '0', 'FI->');
INSERT INTO `dungeon` VALUES ('32732', '32796', '84', '32936', '33058', '70', '4', '->FI');
INSERT INTO `dungeon` VALUES ('32736', '32873', '85', '32725', '32789', '87', '4', 'SI1F()');
INSERT INTO `dungeon` VALUES ('32741', '32872', '85', '32730', '32789', '87', '3', 'SI1F()');
INSERT INTO `dungeon` VALUES ('32793', '32872', '86', '32746', '32810', '87', '6', 'SI1F()');
INSERT INTO `dungeon` VALUES ('32794', '32867', '86', '32746', '32805', '87', '6', 'SI1F()');
INSERT INTO `dungeon` VALUES ('32725', '32788', '87', '32737', '32871', '85', '1', 'SI1F()');
INSERT INTO `dungeon` VALUES ('32730', '32788', '87', '32741', '32871', '85', '1', 'SI1F()');
INSERT INTO `dungeon` VALUES ('32747', '32805', '87', '32795', '32867', '86', '2', 'SI1F()');
INSERT INTO `dungeon` VALUES ('32747', '32810', '87', '32795', '32872', '86', '2', 'SI1F()');
INSERT INTO `dungeon` VALUES ('32724', '32798', '101', '34255', '33452', '4', '6', 'TOI1F-> ');
INSERT INTO `dungeon` VALUES ('32724', '32799', '101', '34255', '33452', '4', '6', 'TOI1F-> ');
INSERT INTO `dungeon` VALUES ('32724', '32800', '101', '34255', '33452', '4', '6', 'TOI1F-> ');
INSERT INTO `dungeon` VALUES ('32799', '32797', '101', '32798', '32802', '101', '6', 'TOI1F');
INSERT INTO `dungeon` VALUES ('32799', '32801', '101', '32798', '32798', '102', '6', 'TOI1F->TOI2F');
INSERT INTO `dungeon` VALUES ('32799', '32802', '101', '32798', '32798', '102', '6', 'TOI1F->TOI2F');
INSERT INTO `dungeon` VALUES ('32871', '32870', '101', '32660', '32933', '301', '6', 'TOI1F->');
INSERT INTO `dungeon` VALUES ('32799', '32797', '102', '32798', '32802', '101', '6', 'TOI2F->1F');
INSERT INTO `dungeon` VALUES ('32799', '32798', '102', '32798', '32802', '101', '6', 'TOI2F->1F');
INSERT INTO `dungeon` VALUES ('32743', '32731', '102', '32749', '32747', '103', '0', 'TOI2F->TOI3F(A)');
INSERT INTO `dungeon` VALUES ('32853', '32855', '102', '32851', '32843', '103', '2', 'TOI2F->TOI3F(B)');
INSERT INTO `dungeon` VALUES ('32748', '32748', '103', '32743', '32732', '102', '4', 'TOI3F->TOI2F(A)');
INSERT INTO `dungeon` VALUES ('32749', '32748', '103', '32743', '32732', '102', '4', 'TOI3F->TOI2F(A)');
INSERT INTO `dungeon` VALUES ('32850', '32843', '103', '32852', '32855', '102', '6', 'TOI3F->TOI2F(B)');
INSERT INTO `dungeon` VALUES ('32850', '32844', '103', '32852', '32855', '102', '6', 'TOI3F->TOI2F(B)');
INSERT INTO `dungeon` VALUES ('32744', '32731', '103', '32749', '32747', '103', '0', 'TOI2F->TOI3F(A)');
INSERT INTO `dungeon` VALUES ('32799', '32801', '103', '32671', '32860', '104', '6', 'TOI3F->TOI4F');
INSERT INTO `dungeon` VALUES ('32799', '32802', '103', '32671', '32860', '104', '6', 'TOI3F->TOI4F');
INSERT INTO `dungeon` VALUES ('32672', '32859', '104', '32798', '32802', '103', '6', 'TOI4F->TOI3F');
INSERT INTO `dungeon` VALUES ('32672', '32860', '104', '32798', '32802', '103', '6', 'TOI4F->TOI3F');
INSERT INTO `dungeon` VALUES ('32732', '32924', '104', '32742', '32928', '105', '0', 'TOI4F->TOI5F');
INSERT INTO `dungeon` VALUES ('32733', '32924', '104', '32742', '32928', '105', '0', 'TOI4F->TOI5F');
INSERT INTO `dungeon` VALUES ('32741', '32929', '105', '32732', '32926', '104', '4', 'TOI5F->TOI4F');
INSERT INTO `dungeon` VALUES ('32742', '32929', '105', '32732', '32926', '104', '4', 'TOI5F->TOI4F');
INSERT INTO `dungeon` VALUES ('32672', '32864', '105', '33766', '32865', '106', '6', 'TOI5F->TOI6F');
INSERT INTO `dungeon` VALUES ('32672', '32865', '105', '33766', '32865', '106', '6', 'TOI5F->TOI6F');
INSERT INTO `dungeon` VALUES ('32740', '32903', '106', '32671', '32865', '105', '6', 'TOI6F->TOI5F');
INSERT INTO `dungeon` VALUES ('33808', '32866', '106', '32671', '32860', '107', '6', 'TOI6F->TOI7F');
INSERT INTO `dungeon` VALUES ('33808', '32867', '106', '32671', '32860', '107', '6', 'TOI6F->TOI7F');
INSERT INTO `dungeon` VALUES ('32672', '32859', '107', '33807', '32866', '106', '6', 'TOI7F->TOI6F');
INSERT INTO `dungeon` VALUES ('32672', '32860', '107', '33807', '32866', '106', '6', 'TOI7F->TOI6F');
INSERT INTO `dungeon` VALUES ('32666', '32934', '107', '32670', '32932', '108', '2', 'TOI7F->TOI8F');
INSERT INTO `dungeon` VALUES ('32666', '32935', '107', '32670', '32932', '108', '2', 'TOI7F->TOI8F');
INSERT INTO `dungeon` VALUES ('32669', '32932', '108', '32665', '32935', '107', '6', 'TOI8F->TOI7F');
INSERT INTO `dungeon` VALUES ('32669', '32933', '108', '32665', '32935', '107', '6', 'TOI8F->TOI7F');
INSERT INTO `dungeon` VALUES ('32731', '32806', '108', '32732', '32810', '109', '2', 'TOI8F->TOI9F');
INSERT INTO `dungeon` VALUES ('32731', '32807', '108', '32732', '32810', '109', '2', 'TOI8F->TOI9F');
INSERT INTO `dungeon` VALUES ('32731', '32810', '109', '32730', '32807', '108', '6', 'TOI9F->TOI8F');
INSERT INTO `dungeon` VALUES ('32731', '32811', '109', '32730', '32807', '108', '6', 'TOI9F->TOI8F');
INSERT INTO `dungeon` VALUES ('32621', '32812', '109', '32754', '32739', '110', '0', 'TOI9F->TOI10F');
INSERT INTO `dungeon` VALUES ('32622', '32812', '109', '32754', '32739', '110', '0', 'TOI9F->TOI10F');
INSERT INTO `dungeon` VALUES ('32753', '32740', '110', '32621', '32813', '109', '4', 'TOI10F->TOI9F');
INSERT INTO `dungeon` VALUES ('32754', '32740', '110', '32621', '32813', '109', '4', 'TOI10F->TOI9F');
INSERT INTO `dungeon` VALUES ('32672', '32864', '111', '32798', '32798', '112', '6', 'TOI11F->TOI12F');
INSERT INTO `dungeon` VALUES ('32672', '32865', '111', '32798', '32798', '112', '6', 'TOI11F->TOI12F');
INSERT INTO `dungeon` VALUES ('32799', '32797', '112', '32671', '32865', '111', '6', 'TOI12F->TOI11F');
INSERT INTO `dungeon` VALUES ('32799', '32798', '112', '32671', '32865', '111', '6', 'TOI12F->TOI11F');
INSERT INTO `dungeon` VALUES ('32743', '32731', '112', '32749', '32746', '113', '0', 'TOI12F->TOI13F(A)');
INSERT INTO `dungeon` VALUES ('32744', '32731', '112', '32749', '32747', '113', '0', 'TOI12F->TOI13F(A)');
INSERT INTO `dungeon` VALUES ('32852', '32855', '112', '32851', '32843', '113', '2', 'TOI12F->TOI13F(B)');
INSERT INTO `dungeon` VALUES ('32748', '32747', '113', '32743', '32732', '112', '4', 'TOI13F->TOI12F(A)');
INSERT INTO `dungeon` VALUES ('32749', '32747', '113', '32743', '32732', '112', '4', 'TOI13F->TOI12F(A)');
INSERT INTO `dungeon` VALUES ('32851', '32843', '113', '32851', '32855', '112', '6', 'TOI13F->TOI12F(B)');
INSERT INTO `dungeon` VALUES ('32851', '32844', '113', '32851', '32855', '112', '6', 'TOI13F->TOI12F(B)');
INSERT INTO `dungeon` VALUES ('32799', '32801', '113', '32671', '32860', '114', '6', 'TOI13F->TOI14F');
INSERT INTO `dungeon` VALUES ('32799', '32802', '113', '32671', '32860', '114', '6', 'TOI13F->TOI14F');
INSERT INTO `dungeon` VALUES ('32672', '32859', '114', '32798', '32802', '113', '6', 'TOI14F->TOI13F');
INSERT INTO `dungeon` VALUES ('32672', '32860', '114', '32798', '32802', '113', '6', 'TOI14F->TOI13F');
INSERT INTO `dungeon` VALUES ('32732', '32924', '114', '32671', '32861', '115', '6', 'TOI14F->TOI15F');
INSERT INTO `dungeon` VALUES ('32733', '32924', '114', '32671', '32861', '115', '6', 'TOI14F->TOI15F');
INSERT INTO `dungeon` VALUES ('32672', '32860', '115', '32732', '32926', '114', '4', 'TOI15F->TOI14F');
INSERT INTO `dungeon` VALUES ('32672', '32861', '115', '32732', '32926', '114', '4', 'TOI15F->TOI14F');
INSERT INTO `dungeon` VALUES ('32694', '32786', '115', '32743', '32865', '116', '0', 'TOI15F->TOI16F');
INSERT INTO `dungeon` VALUES ('32742', '32866', '116', '32693', '32786', '115', '6', 'TOI16F->TOI15F');
INSERT INTO `dungeon` VALUES ('32743', '32866', '116', '32693', '32786', '115', '6', 'TOI16F->TOI15F');
INSERT INTO `dungeon` VALUES ('32784', '32866', '116', '32671', '32860', '117', '6', 'TOI16F->TOI17F');
INSERT INTO `dungeon` VALUES ('32784', '32867', '116', '32671', '32860', '117', '6', 'TOI16F->TOI17F');
INSERT INTO `dungeon` VALUES ('32672', '32859', '117', '32783', '32867', '116', '6', 'TOI17F->TOI16F');
INSERT INTO `dungeon` VALUES ('32672', '32860', '117', '32783', '32867', '116', '6', 'TOI17F->TOI16F');
INSERT INTO `dungeon` VALUES ('32666', '32935', '117', '32670', '32932', '118', '2', 'TOI17F->TOI18F');
INSERT INTO `dungeon` VALUES ('32669', '32932', '118', '32665', '32935', '117', '6', 'TOI18F->TOI17F');
INSERT INTO `dungeon` VALUES ('32669', '32933', '118', '32665', '32935', '117', '6', 'TOI18F->TOI17F');
INSERT INTO `dungeon` VALUES ('32731', '32806', '118', '32732', '32810', '119', '2', 'TOI18F->TOI19F');
INSERT INTO `dungeon` VALUES ('32731', '32807', '118', '32732', '32810', '119', '2', 'TOI18F->TOI19F');
INSERT INTO `dungeon` VALUES ('32731', '32810', '119', '32730', '32807', '118', '6', 'TOI19F->TOI18F');
INSERT INTO `dungeon` VALUES ('32731', '32811', '119', '32730', '32807', '118', '6', 'TOI19F->TOI18F');
INSERT INTO `dungeon` VALUES ('32621', '32812', '119', '32754', '32739', '120', '0', 'TOI19F->TOI20F');
INSERT INTO `dungeon` VALUES ('32622', '32812', '119', '32754', '32739', '120', '0', 'TOI19F->TOI20F');
INSERT INTO `dungeon` VALUES ('32753', '32740', '120', '32621', '32813', '119', '4', 'TOI20F->TOI20F');
INSERT INTO `dungeon` VALUES ('32754', '32740', '120', '32621', '32813', '119', '4', 'TOI20F->TOI20F');
INSERT INTO `dungeon` VALUES ('32672', '32864', '121', '32798', '32798', '122', '6', 'TOI21F->TOI22F');
INSERT INTO `dungeon` VALUES ('32672', '32865', '121', '32798', '32798', '122', '6', 'TOI21F->TOI22F');
INSERT INTO `dungeon` VALUES ('32799', '32797', '122', '32671', '32865', '121', '6', 'TOI22F->TOI21F');
INSERT INTO `dungeon` VALUES ('32799', '32798', '122', '32671', '32865', '121', '6', 'TOI22F->TOI21F');
INSERT INTO `dungeon` VALUES ('32748', '32872', '122', '32787', '32870', '123', '0', 'TOI22F->TOI23F(B)');
INSERT INTO `dungeon` VALUES ('32748', '32873', '122', '32787', '32870', '123', '0', 'TOI22F->TOI23F(B)');
INSERT INTO `dungeon` VALUES ('32872', '32723', '122', '32875', '32750', '123', '2', 'TOI22F->TOI23F(A)');
INSERT INTO `dungeon` VALUES ('32786', '32871', '123', '32747', '32873', '122', '6', 'TOI23F->TOI22F(B)');
INSERT INTO `dungeon` VALUES ('32787', '32871', '123', '32747', '32873', '122', '6', 'TOI23F->TOI22F(B)');
INSERT INTO `dungeon` VALUES ('32874', '32750', '123', '32871', '32723', '122', '6', 'TOI23F->TOI22F(A)');
INSERT INTO `dungeon` VALUES ('32874', '32751', '123', '32871', '32723', '122', '6', 'TOI23F->TOI22F(A)');
INSERT INTO `dungeon` VALUES ('32799', '32801', '123', '32671', '32860', '124', '6', 'TOI23F->TOI24F');
INSERT INTO `dungeon` VALUES ('32799', '32802', '123', '32671', '32860', '124', '6', 'TOI23F->TOI24F');
INSERT INTO `dungeon` VALUES ('32672', '32859', '124', '32798', '32802', '123', '6', '');
INSERT INTO `dungeon` VALUES ('32672', '32860', '124', '32798', '32802', '123', '6', '');
INSERT INTO `dungeon` VALUES ('32732', '32924', '124', '32742', '32928', '125', '0', 'TOI24F->TOI25F');
INSERT INTO `dungeon` VALUES ('32733', '32924', '124', '32742', '32928', '125', '0', 'TOI24F->TOI25F');
INSERT INTO `dungeon` VALUES ('32741', '32929', '125', '32732', '32926', '124', '4', 'TOI25F->TOI24F');
INSERT INTO `dungeon` VALUES ('32742', '32929', '125', '32732', '32926', '124', '4', 'TOI25F->TOI24F');
INSERT INTO `dungeon` VALUES ('32672', '32864', '125', '32737', '32853', '126', '6', 'TOI25F->TOI26F');
INSERT INTO `dungeon` VALUES ('32672', '32865', '125', '32737', '32853', '126', '6', 'TOI25F->TOI26F');
INSERT INTO `dungeon` VALUES ('32736', '32854', '126', '32671', '32865', '125', '6', 'TOI26F->TOI25F');
INSERT INTO `dungeon` VALUES ('32737', '32854', '126', '32671', '32865', '125', '6', 'TOI26F->TOI25F');
INSERT INTO `dungeon` VALUES ('32781', '32866', '126', '32799', '32866', '126', '0', 'TOI26F');
INSERT INTO `dungeon` VALUES ('32781', '32867', '126', '32799', '32866', '126', '0', 'TOI26F');
INSERT INTO `dungeon` VALUES ('32798', '32867', '126', '32781', '32866', '126', '2', 'TOI26F');
INSERT INTO `dungeon` VALUES ('32799', '32867', '126', '32781', '32866', '126', '2', 'TOI26F');
INSERT INTO `dungeon` VALUES ('32784', '32866', '126', '32671', '32860', '127', '6', 'TOI26F->TOI27F');
INSERT INTO `dungeon` VALUES ('32784', '32867', '126', '32671', '32860', '127', '6', 'TOI26F->TOI27F');
INSERT INTO `dungeon` VALUES ('32672', '32859', '127', '32783', '32867', '126', '6', 'TOI27F->TOI26F');
INSERT INTO `dungeon` VALUES ('32672', '32860', '127', '32783', '32867', '126', '6', 'TOI27F->TOI26F');
INSERT INTO `dungeon` VALUES ('32666', '32934', '127', '32670', '32932', '128', '2', 'TOI27F->TOI28F');
INSERT INTO `dungeon` VALUES ('32666', '32935', '127', '32670', '32932', '128', '2', 'TOI27F->TOI28F');
INSERT INTO `dungeon` VALUES ('32669', '32932', '128', '32665', '32935', '127', '6', 'TOI28F->TOI27F');
INSERT INTO `dungeon` VALUES ('32669', '32933', '128', '32665', '32935', '127', '6', 'TOI28F->TOI27F');
INSERT INTO `dungeon` VALUES ('32615', '32805', '128', '32723', '32860', '129', '2', 'TOI28F->TOI29F');
INSERT INTO `dungeon` VALUES ('32616', '32805', '128', '32723', '32860', '129', '2', 'TOI28F->TOI29F');
INSERT INTO `dungeon` VALUES ('32722', '32860', '129', '32615', '32806', '128', '4', 'TOI29F->TOI28F');
INSERT INTO `dungeon` VALUES ('32722', '32861', '129', '32615', '32806', '128', '4', 'TOI29F->TOI28F');
INSERT INTO `dungeon` VALUES ('32621', '32812', '129', '32754', '32739', '130', '0', 'TOI29F->TOI30F');
INSERT INTO `dungeon` VALUES ('32622', '32812', '129', '32754', '32739', '130', '0', 'TOI29F->TOI30F');
INSERT INTO `dungeon` VALUES ('32753', '32740', '130', '32621', '32813', '129', '4', 'TOI30F->TOI29F');
INSERT INTO `dungeon` VALUES ('32754', '32740', '130', '32621', '32813', '129', '4', 'TOI30F->TOI29F');
INSERT INTO `dungeon` VALUES ('32672', '32864', '131', '32798', '32798', '132', '6', 'TOI31F->TOI32F');
INSERT INTO `dungeon` VALUES ('32672', '32865', '131', '32798', '32798', '132', '6', 'TOI31F->TOI32F');
INSERT INTO `dungeon` VALUES ('32799', '32797', '132', '32671', '32865', '131', '6', 'TOI32F->TOI31F');
INSERT INTO `dungeon` VALUES ('32799', '32798', '132', '32671', '32865', '131', '6', 'TOI32F->TOI31F');
INSERT INTO `dungeon` VALUES ('32743', '32731', '132', '32749', '32747', '133', '0', 'TOI32F->TOI33F(B)');
INSERT INTO `dungeon` VALUES ('32744', '32731', '132', '32749', '32747', '133', '0', 'TOI32F->TOI33F(B)');
INSERT INTO `dungeon` VALUES ('32853', '32854', '132', '32851', '32843', '133', '2', 'TOI32F->TOI33F(A)');
INSERT INTO `dungeon` VALUES ('32853', '32855', '132', '32851', '32843', '133', '2', 'TOI32F->TOI33F(A)');
INSERT INTO `dungeon` VALUES ('32748', '32748', '133', '32743', '32732', '132', '4', 'TOI33F->TOI32F(B)');
INSERT INTO `dungeon` VALUES ('32749', '32748', '133', '32743', '32732', '132', '4', 'TOI33F->TOI32F(B)');
INSERT INTO `dungeon` VALUES ('32850', '32843', '133', '32852', '32855', '132', '6', 'TOI33F->TOI32F(A)');
INSERT INTO `dungeon` VALUES ('32850', '32844', '133', '32852', '32855', '132', '6', 'TOI33F->TOI32F(A)');
INSERT INTO `dungeon` VALUES ('32799', '32801', '133', '32671', '32860', '134', '6', 'TOI33F->TOI34F');
INSERT INTO `dungeon` VALUES ('32799', '32802', '133', '32671', '32860', '134', '6', 'TOI33F->TOI34F');
INSERT INTO `dungeon` VALUES ('32672', '32859', '134', '32798', '32802', '133', '6', 'TOI34F->TOI33F');
INSERT INTO `dungeon` VALUES ('32672', '32860', '134', '32798', '32802', '133', '6', 'TOI34F->TOI33F');
INSERT INTO `dungeon` VALUES ('32732', '32924', '134', '32742', '32928', '135', '0', 'TOI34F->TOI35F');
INSERT INTO `dungeon` VALUES ('32733', '32924', '134', '32742', '32928', '135', '0', 'TOI34F->TOI35F');
INSERT INTO `dungeon` VALUES ('32741', '32929', '135', '32732', '32926', '134', '4', 'TOI35F->TOI34F');
INSERT INTO `dungeon` VALUES ('32742', '32929', '135', '32732', '32926', '134', '4', 'TOI35F->TOI34F');
INSERT INTO `dungeon` VALUES ('32672', '32864', '135', '32739', '32864', '136', '0', 'TOI35F->TOI36F');
INSERT INTO `dungeon` VALUES ('32672', '32865', '135', '32739', '32864', '136', '0', 'TOI35F->TOI36F');
INSERT INTO `dungeon` VALUES ('32738', '32865', '136', '32671', '32865', '135', '6', 'TOI36F->TOI35F');
INSERT INTO `dungeon` VALUES ('32739', '32865', '136', '32671', '32865', '135', '6', 'TOI36F->TOI35F');
INSERT INTO `dungeon` VALUES ('32786', '32864', '136', '32671', '32860', '137', '6', 'TOI36F->TOI37F');
INSERT INTO `dungeon` VALUES ('32786', '32865', '136', '32671', '32860', '137', '6', 'TOI36F->TOI37F');
INSERT INTO `dungeon` VALUES ('32672', '32859', '137', '32785', '32865', '136', '6', 'TOI37F->TOI36F');
INSERT INTO `dungeon` VALUES ('32672', '32860', '137', '32785', '32865', '136', '6', 'TOI37F->TOI36F');
INSERT INTO `dungeon` VALUES ('32666', '32934', '137', '32670', '32932', '138', '2', 'TOI37F->TOI38F');
INSERT INTO `dungeon` VALUES ('32666', '32935', '137', '32670', '32932', '138', '2', 'TOI37F->TOI38F');
INSERT INTO `dungeon` VALUES ('32669', '32932', '138', '32665', '32935', '137', '6', 'TOI38F->TOI37F');
INSERT INTO `dungeon` VALUES ('32669', '32933', '138', '32665', '32935', '137', '6', 'TOI38F->TOI37F');
INSERT INTO `dungeon` VALUES ('32731', '32806', '138', '32732', '32810', '139', '2', 'TOI38F->TOI39F');
INSERT INTO `dungeon` VALUES ('32731', '32807', '138', '32732', '32810', '139', '2', 'TOI38F->TOI39F');
INSERT INTO `dungeon` VALUES ('32731', '32810', '139', '32730', '32807', '138', '6', 'TOI39F->TOI38F');
INSERT INTO `dungeon` VALUES ('32731', '32811', '139', '32730', '32807', '138', '6', 'TOI39F->TOI38F');
INSERT INTO `dungeon` VALUES ('32621', '32812', '139', '32754', '32739', '140', '0', 'TOI39F->TOI40F');
INSERT INTO `dungeon` VALUES ('32622', '32812', '139', '32754', '32739', '140', '0', 'TOI39F->TOI40F');
INSERT INTO `dungeon` VALUES ('32753', '32740', '140', '32621', '32813', '139', '4', 'TOI40F->TOI39F');
INSERT INTO `dungeon` VALUES ('32754', '32740', '140', '32621', '32813', '139', '4', 'TOI40F->TOI39F');
INSERT INTO `dungeon` VALUES ('32672', '32865', '141', '32798', '32798', '142', '6', 'TOI41F->TOI42F');
INSERT INTO `dungeon` VALUES ('32740', '32903', '141', '32798', '32798', '142', '6', 'TOI41F->TOI42F');
INSERT INTO `dungeon` VALUES ('32799', '32797', '142', '32671', '32865', '141', '6', 'TOI42F->TOI41F');
INSERT INTO `dungeon` VALUES ('32799', '32798', '142', '32671', '32865', '141', '6', 'TOI42F->TOI41F');
INSERT INTO `dungeon` VALUES ('32793', '32864', '142', '32813', '32870', '143', '2', 'TOI42F->TOI43F(B)');
INSERT INTO `dungeon` VALUES ('32793', '32865', '142', '32813', '32870', '143', '2', 'TOI42F->TOI43F(B)');
INSERT INTO `dungeon` VALUES ('32851', '32746', '142', '32843', '32734', '143', '0', 'TOI42F->TOI43F(A)');
INSERT INTO `dungeon` VALUES ('32852', '32746', '142', '32843', '32734', '143', '0', 'TOI42F->TOI43F(A)');
INSERT INTO `dungeon` VALUES ('32812', '32870', '143', '32792', '32865', '142', '6', 'TOI43F->TOI42F(B)');
INSERT INTO `dungeon` VALUES ('32812', '32871', '143', '32792', '32865', '142', '6', 'TOI43F->TOI42F(B)');
INSERT INTO `dungeon` VALUES ('32842', '32735', '143', '32851', '32747', '142', '4', 'TOI43F->TOI42F(A)');
INSERT INTO `dungeon` VALUES ('32843', '32735', '143', '32851', '32747', '142', '4', 'TOI43F->TOI42F(A)');
INSERT INTO `dungeon` VALUES ('32799', '32801', '143', '32671', '32860', '144', '6', 'TOI43F->TOI44F');
INSERT INTO `dungeon` VALUES ('32799', '32802', '143', '32671', '32860', '144', '6', 'TOI43F->TOI44F');
INSERT INTO `dungeon` VALUES ('32672', '32859', '144', '32798', '32802', '143', '6', 'TOI44F->TOI43F');
INSERT INTO `dungeon` VALUES ('32672', '32860', '144', '32798', '32802', '143', '6', 'TOI44F->TOI43F');
INSERT INTO `dungeon` VALUES ('32732', '32924', '144', '32742', '32928', '145', '0', 'TOI44F->TOI45F');
INSERT INTO `dungeon` VALUES ('32733', '32924', '144', '32742', '32928', '145', '0', 'TOI44F->TOI45F');
INSERT INTO `dungeon` VALUES ('32741', '32929', '145', '32732', '32926', '144', '4', 'TOI45F->TOI44F');
INSERT INTO `dungeon` VALUES ('32742', '32929', '145', '32732', '32926', '144', '4', 'TOI45F->TOI44F');
INSERT INTO `dungeon` VALUES ('32672', '32864', '145', '32735', '32869', '146', '0', 'TOI45F->TOI46F');
INSERT INTO `dungeon` VALUES ('32672', '32865', '145', '32735', '32869', '146', '0', 'TOI45F->TOI46F');
INSERT INTO `dungeon` VALUES ('32734', '32870', '146', '32671', '32865', '145', '6', 'TOI46F->TOI45F');
INSERT INTO `dungeon` VALUES ('32735', '32870', '146', '32671', '32865', '145', '6', 'TOI46F->TOI45F');
INSERT INTO `dungeon` VALUES ('32790', '32867', '146', '32671', '32860', '147', '6', 'TOI46F->TOI47F');
INSERT INTO `dungeon` VALUES ('32790', '32868', '146', '32671', '32860', '147', '6', 'TOI46F->TOI47F');
INSERT INTO `dungeon` VALUES ('32672', '32859', '147', '32789', '32868', '146', '6', 'TOI47F->TOI46F');
INSERT INTO `dungeon` VALUES ('32672', '32860', '147', '32789', '32868', '146', '6', 'TOI47F->TOI46F');
INSERT INTO `dungeon` VALUES ('32666', '32934', '147', '32670', '32932', '148', '2', 'TOI47F->TOI48F');
INSERT INTO `dungeon` VALUES ('32666', '32935', '147', '32670', '32932', '148', '2', 'TOI47F->TOI48F');
INSERT INTO `dungeon` VALUES ('32669', '32932', '148', '32665', '32935', '147', '6', 'TOI48F->TOI47F');
INSERT INTO `dungeon` VALUES ('32669', '32933', '148', '32665', '32935', '147', '6', 'TOI48F->TOI47F');
INSERT INTO `dungeon` VALUES ('32731', '32806', '148', '32732', '32810', '149', '2', 'TOI48F->TOI49F');
INSERT INTO `dungeon` VALUES ('32731', '32807', '148', '32732', '32810', '149', '2', 'TOI48F->TOI49F');
INSERT INTO `dungeon` VALUES ('32731', '32810', '149', '32730', '32807', '148', '6', 'TOI49F->TOI48F');
INSERT INTO `dungeon` VALUES ('32731', '32811', '149', '32730', '32807', '148', '6', 'TOI49F->TOI48F');
INSERT INTO `dungeon` VALUES ('32621', '32812', '149', '32754', '32739', '150', '0', 'TOI49F->TOI50F');
INSERT INTO `dungeon` VALUES ('32622', '32812', '149', '32754', '32739', '150', '0', 'TOI49F->TOI50F');
INSERT INTO `dungeon` VALUES ('32753', '32740', '150', '32621', '32813', '149', '4', 'TOI50F->TOI49F');
INSERT INTO `dungeon` VALUES ('32754', '32740', '150', '32621', '32813', '149', '4', 'TOI50F->TOI49F');
INSERT INTO `dungeon` VALUES ('32672', '32864', '151', '32671', '32860', '152', '6', 'TOI51F->TOI52F(A)');
INSERT INTO `dungeon` VALUES ('32672', '32865', '151', '32671', '32860', '152', '6', 'TOI51F->TOI52F(A)');
INSERT INTO `dungeon` VALUES ('32740', '32902', '151', '32732', '32924', '152', '0', 'TOI51F->TOI52F(B)');
INSERT INTO `dungeon` VALUES ('32740', '32903', '151', '32732', '32925', '152', '0', 'TOI51F->TOI52F(B)');
INSERT INTO `dungeon` VALUES ('32672', '32859', '152', '32671', '32865', '151', '6', 'TOI52F->TOI51F(A)');
INSERT INTO `dungeon` VALUES ('32672', '32860', '152', '32671', '32865', '151', '6', 'TOI52F->TOI51F(A)');
INSERT INTO `dungeon` VALUES ('32732', '32925', '152', '32739', '32903', '151', '6', 'TOI52F->TOI51F(B)');
INSERT INTO `dungeon` VALUES ('32731', '32806', '152', '32732', '32807', '153', '0', 'TOI52F->TOI53F(A)');
INSERT INTO `dungeon` VALUES ('32731', '32807', '152', '32732', '32807', '153', '0', 'TOI52F->TOI53F(A)');
INSERT INTO `dungeon` VALUES ('32742', '32838', '152', '32732', '32907', '153', '2', 'TOI52F->TOI53F(B)');
INSERT INTO `dungeon` VALUES ('32742', '32839', '152', '32732', '32907', '153', '2', 'TOI52F->TOI53F(B)');
INSERT INTO `dungeon` VALUES ('32731', '32808', '153', '32730', '32807', '152', '6', 'TOI53F->TOI52F(A)');
INSERT INTO `dungeon` VALUES ('32731', '32908', '153', '32741', '32839', '152', '6', 'TOI53F->TOI52F(B)');
INSERT INTO `dungeon` VALUES ('32732', '32808', '153', '32730', '32807', '152', '6', 'TOI53F->TOI52F(A)');
INSERT INTO `dungeon` VALUES ('32732', '32908', '153', '32741', '32839', '152', '6', 'TOI53F->TOI52F(B)');
INSERT INTO `dungeon` VALUES ('32671', '32864', '153', '32798', '32797', '154', '6', 'TOI53F->TOI54F(A)');
INSERT INTO `dungeon` VALUES ('32671', '32865', '153', '32798', '32797', '154', '6', 'TOI53F->TOI54F(A)');
INSERT INTO `dungeon` VALUES ('32722', '32803', '153', '32846', '32747', '154', '2', 'TOI53F->TOI54F(B)');
INSERT INTO `dungeon` VALUES ('32645', '32747', '154', '32722', '32803', '153', '6', 'TOI54F->TOI53F(B)');
INSERT INTO `dungeon` VALUES ('32799', '32796', '154', '32670', '32865', '153', '6', 'TOI54F->TOI53F(A)');
INSERT INTO `dungeon` VALUES ('32799', '32797', '154', '32670', '32865', '153', '6', 'TOI54F->TOI53F(A)');
INSERT INTO `dungeon` VALUES ('32845', '32748', '154', '32722', '32803', '153', '6', 'TOI54F->TOI53F(B)');
INSERT INTO `dungeon` VALUES ('32745', '32846', '154', '32734', '32848', '155', '0', 'TOI54F->TOI55F(B)');
INSERT INTO `dungeon` VALUES ('32745', '32847', '154', '32734', '32848', '155', '0', 'TOI54F->TOI55F(B)');
INSERT INTO `dungeon` VALUES ('32752', '32742', '154', '32742', '32734', '155', '2', 'TOI54F->TOI55F(A)');
INSERT INTO `dungeon` VALUES ('32753', '32742', '154', '32742', '32734', '155', '2', 'TOI54F->TOI55F(A)');
INSERT INTO `dungeon` VALUES ('32733', '32849', '155', '32744', '32847', '154', '6', 'TOI55F->TOI54F(B)');
INSERT INTO `dungeon` VALUES ('32734', '32849', '155', '32744', '32847', '154', '6', 'TOI55F->TOI54F(B)');
INSERT INTO `dungeon` VALUES ('32741', '32734', '155', '32752', '32743', '154', '4', 'TOI55F->TOI54F(A)');
INSERT INTO `dungeon` VALUES ('32741', '32735', '155', '32752', '32743', '154', '4', 'TOI55F->TOI54F(A)');
INSERT INTO `dungeon` VALUES ('32834', '32819', '155', '32807', '32805', '156', '2', 'TOI55F->TOI56F');
INSERT INTO `dungeon` VALUES ('32834', '32820', '155', '32807', '32805', '156', '2', 'TOI55F->TOI56F');
INSERT INTO `dungeon` VALUES ('32806', '32805', '156', '32833', '32820', '155', '6', 'TOI56F->TOI55F');
INSERT INTO `dungeon` VALUES ('32806', '32806', '156', '32833', '32820', '155', '6', 'TOI56F->TOI55F');
INSERT INTO `dungeon` VALUES ('32727', '32801', '156', '32747', '32898', '157', '0', 'TOI56F->TOI57F');
INSERT INTO `dungeon` VALUES ('32727', '32802', '156', '32747', '32898', '157', '0', 'TOI56F->TOI57F');
INSERT INTO `dungeon` VALUES ('32746', '32899', '157', '32726', '32802', '156', '6', 'TOI57F->TOI56F');
INSERT INTO `dungeon` VALUES ('32747', '32899', '157', '32726', '32802', '156', '6', 'TOI57F->TOI56F');
INSERT INTO `dungeon` VALUES ('32672', '32864', '157', '32671', '32860', '158', '6', 'TOI57F->TOI58F(A)');
INSERT INTO `dungeon` VALUES ('32672', '32865', '157', '32671', '32860', '158', '6', 'TOI57F->TOI58F(A)');
INSERT INTO `dungeon` VALUES ('32745', '32932', '157', '32735', '32921', '158', '2', 'TOI57F->TOI58F(B)');
INSERT INTO `dungeon` VALUES ('32745', '32933', '157', '32735', '32921', '158', '2', 'TOI57F->TOI58F(B)');
INSERT INTO `dungeon` VALUES ('32672', '32859', '158', '32671', '32865', '157', '6', 'TOI58F->TOI57F(A)');
INSERT INTO `dungeon` VALUES ('32672', '32860', '158', '32671', '32865', '157', '6', 'TOI58F->TOI57F(A)');
INSERT INTO `dungeon` VALUES ('32734', '32921', '158', '32744', '32933', '157', '6', 'TOI58F->TOI57F(B)');
INSERT INTO `dungeon` VALUES ('32734', '32922', '158', '32744', '32933', '157', '6', 'TOI58F->TOI57F(B)');
INSERT INTO `dungeon` VALUES ('32614', '32918', '158', '32617', '32916', '159', '2', 'TOI58F->TOI59F(B)');
INSERT INTO `dungeon` VALUES ('32615', '32918', '158', '32617', '32916', '159', '2', 'TOI58F->TOI59F(B)');
INSERT INTO `dungeon` VALUES ('32662', '32798', '158', '32657', '32791', '159', '2', 'TOI58F->TOI59F(A)');
INSERT INTO `dungeon` VALUES ('32662', '32799', '158', '32657', '32791', '159', '2', 'TOI58F->TOI59F(A)');
INSERT INTO `dungeon` VALUES ('32616', '32916', '159', '32614', '32919', '158', '4', 'TOI59F->TOI58F(B)');
INSERT INTO `dungeon` VALUES ('32616', '32917', '159', '32614', '32919', '158', '4', 'TOI59F->TOI58F(B)');
INSERT INTO `dungeon` VALUES ('32656', '32791', '159', '32661', '32799', '158', '6', 'TOI59F->TOI58F(A)');
INSERT INTO `dungeon` VALUES ('32656', '32792', '159', '32661', '32799', '158', '6', 'TOI59F->TOI58F(A)');
INSERT INTO `dungeon` VALUES ('32711', '32806', '159', '32681', '32814', '160', '2', 'TOI59F->TOI60F(A)');
INSERT INTO `dungeon` VALUES ('32711', '32807', '159', '32681', '32814', '160', '2', 'TOI59F->TOI60F(A)');
INSERT INTO `dungeon` VALUES ('32745', '32840', '159', '32749', '32814', '160', '0', 'TOI59F->TOI60F(B)');
INSERT INTO `dungeon` VALUES ('32745', '32841', '159', '32749', '32814', '160', '0', 'TOI59F->TOI60F(B)');
INSERT INTO `dungeon` VALUES ('32680', '32814', '160', '32710', '32807', '159', '6', 'TOI60F->TOI59F(A)');
INSERT INTO `dungeon` VALUES ('32680', '32815', '160', '32710', '32807', '159', '6', 'TOI60F->TOI59F(A)');
INSERT INTO `dungeon` VALUES ('32748', '32815', '160', '32744', '32841', '159', '6', 'TOI60F->TOI59F(B)');
INSERT INTO `dungeon` VALUES ('32749', '32815', '160', '32744', '32841', '159', '6', 'TOI60F->TOI59F(B)');
INSERT INTO `dungeon` VALUES ('32731', '32799', '161', '32695', '32788', '162', '0', 'TOI61F->TOI62F(A)');
INSERT INTO `dungeon` VALUES ('32732', '32799', '161', '32695', '32788', '162', '0', 'TOI61F->TOI62F(A)');
INSERT INTO `dungeon` VALUES ('32740', '32902', '161', '32740', '32915', '162', '2', 'TOI61F->TOI62F(B)');
INSERT INTO `dungeon` VALUES ('32740', '32903', '161', '32740', '32915', '162', '2', 'TOI61F->TOI62F(B)');
INSERT INTO `dungeon` VALUES ('32694', '32789', '162', '32731', '32800', '161', '4', 'TOI62F->TOI61F(A)');
INSERT INTO `dungeon` VALUES ('32695', '32789', '162', '32731', '32800', '161', '4', 'TOI62F->TOI61F(A)');
INSERT INTO `dungeon` VALUES ('32739', '32915', '162', '32739', '32903', '161', '6', 'TOI62F->TOI61F(B)');
INSERT INTO `dungeon` VALUES ('32739', '32916', '162', '32739', '32903', '161', '6', 'TOI62F->TOI61F(B)');
INSERT INTO `dungeon` VALUES ('32742', '32838', '162', '32731', '32847', '163', '2', 'TOI62F->TOI63F(A)');
INSERT INTO `dungeon` VALUES ('32742', '32839', '162', '32731', '32847', '163', '2', 'TOI62F->TOI63F(A)');
INSERT INTO `dungeon` VALUES ('32745', '32878', '162', '32732', '32907', '163', '0', 'TOI62F->TOI63F(B)');
INSERT INTO `dungeon` VALUES ('32745', '32879', '162', '32732', '32907', '163', '0', 'TOI62F->TOI63F(B)');
INSERT INTO `dungeon` VALUES ('32730', '32847', '163', '32741', '32839', '162', '6', 'TOI63F->TOI62F(A)');
INSERT INTO `dungeon` VALUES ('32730', '32848', '163', '32741', '32839', '162', '6', 'TOI63F->TOI62F(A)');
INSERT INTO `dungeon` VALUES ('32731', '32908', '163', '32744', '32879', '162', '6', 'TOI63F->TOI62F(B)');
INSERT INTO `dungeon` VALUES ('32732', '32908', '163', '32744', '32879', '162', '6', 'TOI63F->TOI62F(B)');
INSERT INTO `dungeon` VALUES ('32671', '32864', '163', '32798', '32797', '164', '6', 'TOI63F->TOI64F(B)');
INSERT INTO `dungeon` VALUES ('32671', '32865', '163', '32798', '32797', '164', '6', 'TOI63F->TOI64F(B)');
INSERT INTO `dungeon` VALUES ('32732', '32812', '163', '32873', '32753', '164', '2', 'TOI63F->TOI64F(A)');
INSERT INTO `dungeon` VALUES ('32733', '32812', '163', '32873', '32753', '164', '2', 'TOI63F->TOI64F(A)');
INSERT INTO `dungeon` VALUES ('32799', '32796', '164', '32670', '32865', '163', '6', 'TOI64F->TOI63F(B)');
INSERT INTO `dungeon` VALUES ('32799', '32797', '164', '32670', '32865', '163', '6', 'TOI64F->TOI63F(B)');
INSERT INTO `dungeon` VALUES ('32872', '32753', '164', '32732', '32813', '163', '4', 'TOI64F->TOI63F(A)');
INSERT INTO `dungeon` VALUES ('32872', '32754', '164', '32732', '32813', '163', '4', 'TOI64F->TOI63F(A)');
INSERT INTO `dungeon` VALUES ('32756', '32850', '164', '32734', '32848', '165', '0', 'TOI64F->TOI65F(B)');
INSERT INTO `dungeon` VALUES ('32757', '32850', '164', '32734', '32848', '165', '0', 'TOI64F->TOI65F(B)');
INSERT INTO `dungeon` VALUES ('32870', '32843', '164', '32874', '32858', '165', '2', 'TOI64F->TOI65F(A)');
INSERT INTO `dungeon` VALUES ('32870', '32844', '164', '32874', '32858', '165', '2', 'TOI64F->TOI65F(A)');
INSERT INTO `dungeon` VALUES ('32733', '32849', '165', '32756', '32850', '164', '4', 'TOI65F->TOI64F(B)');
INSERT INTO `dungeon` VALUES ('32734', '32849', '165', '32756', '32850', '164', '4', 'TOI65F->TOI64F(B)');
INSERT INTO `dungeon` VALUES ('32873', '32858', '165', '32869', '32844', '164', '6', 'TOI65F->TOI64F(A)');
INSERT INTO `dungeon` VALUES ('32873', '32859', '165', '32869', '32844', '164', '6', 'TOI65F->TOI64F(A)');
INSERT INTO `dungeon` VALUES ('32871', '32726', '165', '32736', '32802', '166', '2', 'TOI65F->TOI66F');
INSERT INTO `dungeon` VALUES ('32871', '32727', '165', '32736', '32802', '166', '2', 'TOI65F->TOI66F');
INSERT INTO `dungeon` VALUES ('32735', '32802', '166', '32870', '32727', '165', '6', 'TOI66F->TOI65F');
INSERT INTO `dungeon` VALUES ('32735', '32803', '166', '32870', '32727', '165', '6', 'TOI66F->TOI65F');
INSERT INTO `dungeon` VALUES ('32796', '32801', '166', '32747', '32898', '167', '0', 'TOI66F->TOI67F(A)');
INSERT INTO `dungeon` VALUES ('32796', '32802', '166', '32747', '32898', '167', '0', 'TOI66F->TOI67F(A)');
INSERT INTO `dungeon` VALUES ('32746', '32899', '167', '32795', '32802', '166', '6', 'TOI67F->TOI66F(A)');
INSERT INTO `dungeon` VALUES ('32747', '32899', '167', '32795', '32802', '166', '6', 'TOI67F->TOI66F(A)');
INSERT INTO `dungeon` VALUES ('32602', '32790', '167', '32609', '32807', '168', '0', ' TOI 67F -> TOI 68F B');
INSERT INTO `dungeon` VALUES ('32603', '32790', '167', '32609', '32807', '168', '0', 'TOI67F->TOI68F(B)');
INSERT INTO `dungeon` VALUES ('32745', '32932', '167', '32735', '32921', '168', '2', 'TOI67F->TOI68F(A)');
INSERT INTO `dungeon` VALUES ('32745', '32933', '167', '32735', '32921', '168', '2', 'TOI67F->TOI68F(A)');
INSERT INTO `dungeon` VALUES ('32608', '32808', '168', '32602', '32791', '167', '4', 'TOI68F->TOI67F(B)');
INSERT INTO `dungeon` VALUES ('32609', '32808', '168', '32602', '32791', '167', '4', 'TOI68F->TOI67F(B)');
INSERT INTO `dungeon` VALUES ('32734', '32921', '168', '32744', '32933', '167', '6', 'TOI68F->TOI67F(A)');
INSERT INTO `dungeon` VALUES ('32734', '32922', '168', '32744', '32933', '167', '6', 'TOI68F->TOI67F(A)');
INSERT INTO `dungeon` VALUES ('32614', '32918', '168', '32637', '32928', '169', '0', 'TOI68F->TOI69F(B)');
INSERT INTO `dungeon` VALUES ('32615', '32918', '168', '32637', '32928', '169', '0', 'TOI68F->TOI69F(B)');
INSERT INTO `dungeon` VALUES ('32746', '32858', '168', '32744', '32844', '169', '2', 'TOI68F->TOI69F(A)');
INSERT INTO `dungeon` VALUES ('32746', '32859', '168', '32744', '32844', '169', '2', 'TOI68F->TOI69F(A)');
INSERT INTO `dungeon` VALUES ('32636', '32929', '169', '32614', '32919', '168', '4', 'TOI69F->TOI68F(B)');
INSERT INTO `dungeon` VALUES ('32637', '32929', '169', '32614', '32919', '168', '4', 'TOI69F->TOI68F(B)');
INSERT INTO `dungeon` VALUES ('32743', '32844', '169', '32745', '32859', '168', '6', 'TOI69F->TOI68F(A)');
INSERT INTO `dungeon` VALUES ('32743', '32845', '169', '32745', '32859', '168', '6', 'TOI69F->TOI68F(A)');
INSERT INTO `dungeon` VALUES ('32656', '32790', '169', '32634', '32788', '170', '0', 'TOI69F->TOI70F(A)');
INSERT INTO `dungeon` VALUES ('32657', '32790', '169', '32634', '32788', '170', '0', 'TOI69F->TOI70F(A)');
INSERT INTO `dungeon` VALUES ('32710', '32935', '169', '32710', '32925', '170', '2', 'TOI69F->TOI70F(B)');
INSERT INTO `dungeon` VALUES ('32710', '32936', '169', '32710', '32925', '170', '2', 'TOI69F->TOI70F(B)');
INSERT INTO `dungeon` VALUES ('32633', '32789', '170', '32656', '32791', '169', '4', 'TOI70F->TOI69F(A)');
INSERT INTO `dungeon` VALUES ('32634', '32789', '170', '32656', '32791', '169', '4', 'TOI70F->TOI69F(A)');
INSERT INTO `dungeon` VALUES ('32709', '32925', '170', '32709', '32936', '169', '6', 'TOI70F->TOI69F(B)');
INSERT INTO `dungeon` VALUES ('32709', '32926', '170', '32709', '32936', '169', '6', 'TOI70F->TOI69F(B)');
INSERT INTO `dungeon` VALUES ('32604', '32828', '171', '32601', '32844', '172', '0', 'TOI71F->TOI72F(A)');
INSERT INTO `dungeon` VALUES ('32605', '32828', '171', '32601', '32844', '172', '0', 'TOI71F->TOI72F(A)');
INSERT INTO `dungeon` VALUES ('32740', '32902', '171', '32747', '32879', '172', '2', 'TOI71F->TOI72F(B)');
INSERT INTO `dungeon` VALUES ('32740', '32903', '171', '32747', '32879', '172', '2', 'TOI71F->TOI72F(B)');
INSERT INTO `dungeon` VALUES ('32600', '32845', '172', '32604', '32829', '171', '4', ' TOI 72F -> TOI 71F (A)');
INSERT INTO `dungeon` VALUES ('32601', '32845', '172', '32604', '32829', '171', '4', ' TOI 72F ->  71F A');
INSERT INTO `dungeon` VALUES ('32746', '32879', '172', '32739', '32903', '171', '6', 'TOI72F->TOI71F(B)');
INSERT INTO `dungeon` VALUES ('32746', '32880', '172', '32739', '32903', '171', '6', 'TOI72F->TOI71F(B)');
INSERT INTO `dungeon` VALUES ('32657', '32790', '172', '32676', '32798', '173', '0', 'TOI72F->TOI73F(A)');
INSERT INTO `dungeon` VALUES ('32658', '32790', '172', '32676', '32798', '173', '0', 'TOI72F->TOI73F(A)');
INSERT INTO `dungeon` VALUES ('32742', '32838', '172', '32732', '32907', '173', '0', 'TOI72F->TOI73F(B)');
INSERT INTO `dungeon` VALUES ('32742', '32839', '172', '32732', '32907', '173', '0', 'TOI72F->TOI73F(B)');
INSERT INTO `dungeon` VALUES ('32675', '32799', '173', '32657', '32791', '172', '4', 'TOI73F->TOI72F(A)');
INSERT INTO `dungeon` VALUES ('32676', '32799', '173', '32657', '32791', '172', '4', 'TOI73F->TOI72F(A)');
INSERT INTO `dungeon` VALUES ('32731', '32908', '173', '32741', '32839', '172', '6', 'TOI73F->TOI72F(B)');
INSERT INTO `dungeon` VALUES ('32732', '32908', '173', '32741', '32839', '172', '6', 'TOI73F->TOI72F(B)');
INSERT INTO `dungeon` VALUES ('32671', '32864', '173', '32798', '32797', '174', '6', 'TOI73F->TOI74F(A)');
INSERT INTO `dungeon` VALUES ('32671', '32865', '173', '32798', '32797', '174', '6', 'TOI73F->TOI74F(A)');
INSERT INTO `dungeon` VALUES ('32693', '32920', '173', '32826', '32836', '174', '0', 'TOI73F->TOI74F(B)');
INSERT INTO `dungeon` VALUES ('32694', '32920', '173', '32826', '32836', '174', '0', 'TOI73F->TOI74F(B)');
INSERT INTO `dungeon` VALUES ('32799', '32796', '174', '32670', '32865', '173', '6', '');
INSERT INTO `dungeon` VALUES ('32799', '32797', '174', '32670', '32865', '173', '6', '');
INSERT INTO `dungeon` VALUES ('32825', '32837', '174', '32693', '32921', '173', '4', 'TOI74F->TOI73F(B)');
INSERT INTO `dungeon` VALUES ('32826', '32837', '174', '32693', '32921', '173', '4', 'TOI74F->TOI73F(B)');
INSERT INTO `dungeon` VALUES ('32752', '32742', '174', '32791', '32727', '175', '0', 'TOI74F->TOI75F(A)');
INSERT INTO `dungeon` VALUES ('32753', '32742', '174', '32791', '32727', '175', '0', 'TOI74F->TOI75F(A)');
INSERT INTO `dungeon` VALUES ('32870', '32763', '174', '32874', '32858', '175', '2', 'TOI74F->TOI75F(B)');
INSERT INTO `dungeon` VALUES ('32871', '32763', '174', '32874', '32858', '175', '2', 'TOI74F->TOI75F(B)');
INSERT INTO `dungeon` VALUES ('32790', '32728', '175', '32752', '32743', '174', '4', 'TOI75F->TOI74F(A)');
INSERT INTO `dungeon` VALUES ('32791', '32728', '175', '32752', '32743', '174', '4', 'TOI75F->TOI74F(A)');
INSERT INTO `dungeon` VALUES ('32873', '32858', '175', '32870', '32764', '174', '4', 'TOI75F->TOI74F(B)');
INSERT INTO `dungeon` VALUES ('32873', '32859', '175', '32870', '32764', '174', '4', 'TOI75F->TOI74F(B)');
INSERT INTO `dungeon` VALUES ('32871', '32726', '175', '32727', '32789', '176', '0', 'TOI75F->TOI76F');
INSERT INTO `dungeon` VALUES ('32871', '32727', '175', '32727', '32789', '176', '0', 'TOI75F->TOI76F');
INSERT INTO `dungeon` VALUES ('32726', '32790', '176', '32870', '32727', '175', '6', 'TOI76F->TOI75F');
INSERT INTO `dungeon` VALUES ('32727', '32790', '176', '32870', '32727', '175', '6', 'TOI76F->TOI75F');
INSERT INTO `dungeon` VALUES ('32797', '32801', '176', '32671', '32861', '177', '6', 'TOI76F->TOI77F');
INSERT INTO `dungeon` VALUES ('32797', '32802', '176', '32671', '32861', '177', '6', 'TOI76F->TOI77F');
INSERT INTO `dungeon` VALUES ('32672', '32860', '177', '32796', '32802', '176', '6', 'TOI77F->TOI76F');
INSERT INTO `dungeon` VALUES ('32672', '32861', '177', '32796', '32802', '176', '6', 'TOI77F->TOI76F');
INSERT INTO `dungeon` VALUES ('32602', '32790', '177', '32620', '32797', '178', '0', '  77F -> 78F');
INSERT INTO `dungeon` VALUES ('32603', '32790', '177', '32620', '32797', '178', '0', 'TOI77F->TOI78F(A)');
INSERT INTO `dungeon` VALUES ('32745', '32932', '177', '32735', '32921', '178', '2', 'TOI77F->TOI78F(B)');
INSERT INTO `dungeon` VALUES ('32745', '32933', '177', '32735', '32921', '178', '2', 'TOI77F->TOI78F(B)');
INSERT INTO `dungeon` VALUES ('32619', '32798', '178', '32602', '32791', '177', '4', 'TOI78F->TOI77F(A)');
INSERT INTO `dungeon` VALUES ('32620', '32798', '178', '32602', '32791', '177', '4', 'TOI78F->TOI77F(A)');
INSERT INTO `dungeon` VALUES ('32734', '32921', '178', '32744', '32933', '177', '6', '');
INSERT INTO `dungeon` VALUES ('32734', '32922', '178', '32744', '32933', '177', '6', 'TOI78F->TOI77F(B)');
INSERT INTO `dungeon` VALUES ('32614', '32918', '178', '32614', '32914', '179', '0', 'TOI78F->TOI79F(B)');
INSERT INTO `dungeon` VALUES ('32615', '32918', '178', '32614', '32914', '179', '0', 'TOI78F->TOI79F(B)');
INSERT INTO `dungeon` VALUES ('32677', '32790', '178', '32693', '32790', '179', '0', 'TOI78F->TOI79F(A)');
INSERT INTO `dungeon` VALUES ('32678', '32790', '178', '32693', '32790', '179', '0', 'TOI78F->TOI79F(A)');
INSERT INTO `dungeon` VALUES ('32613', '32915', '179', '32614', '32919', '178', '4', 'TOI79F->TOI78F(B)');
INSERT INTO `dungeon` VALUES ('32614', '32915', '179', '32614', '32919', '178', '4', 'TOI79F->TOI78F(B)');
INSERT INTO `dungeon` VALUES ('32692', '32791', '179', '32677', '32791', '178', '4', 'TOI79F->TOI78F(A)');
INSERT INTO `dungeon` VALUES ('32693', '32791', '179', '32677', '32791', '178', '4', 'TOI79F->TOI78F(A)');
INSERT INTO `dungeon` VALUES ('32633', '32790', '179', '32634', '32789', '180', '0', 'TOI79F->TOI80F(A)');
INSERT INTO `dungeon` VALUES ('32634', '32790', '179', '32634', '32789', '180', '0', 'TOI79F->TOI80F(A)');
INSERT INTO `dungeon` VALUES ('32745', '32841', '179', '32749', '32876', '180', '2', 'TOI79F->TOI80F(B)');
INSERT INTO `dungeon` VALUES ('32745', '32842', '179', '32749', '32876', '180', '2', 'TOI79F->TOI80F(B)');
INSERT INTO `dungeon` VALUES ('32633', '32790', '180', '32633', '32791', '179', '4', 'TOI80F->TOI79F(A)');
INSERT INTO `dungeon` VALUES ('32634', '32790', '180', '32633', '32791', '179', '4', 'TOI80F->TOI79F(A)');
INSERT INTO `dungeon` VALUES ('32748', '32876', '180', '32744', '32842', '179', '6', 'TOI80F->TOI79F(B)');
INSERT INTO `dungeon` VALUES ('32748', '32877', '180', '32744', '32842', '179', '6', 'TOI80F->TOI79F(B)');
INSERT INTO `dungeon` VALUES ('32672', '32864', '181', '32671', '32860', '182', '6', 'TOI81F->TOI82F(A)');
INSERT INTO `dungeon` VALUES ('32672', '32865', '181', '32671', '32860', '182', '6', 'TOI81F->TOI82F(A)');
INSERT INTO `dungeon` VALUES ('32740', '32902', '181', '32747', '32879', '182', '2', 'TOI81F->TOI82F(B)');
INSERT INTO `dungeon` VALUES ('32740', '32903', '181', '32747', '32879', '182', '2', 'TOI81F->TOI82F(B)');
INSERT INTO `dungeon` VALUES ('32672', '32859', '182', '32671', '32865', '181', '6', 'TOI82F->TOI81F(A)');
INSERT INTO `dungeon` VALUES ('32672', '32860', '182', '32671', '32865', '181', '6', 'TOI82F->TOI81F(A)');
INSERT INTO `dungeon` VALUES ('32746', '32879', '182', '32739', '32903', '181', '6', 'TOI82F->TOI81F(B)');
INSERT INTO `dungeon` VALUES ('32746', '32880', '182', '32739', '32903', '181', '6', 'TOI82F->TOI81F(B)');
INSERT INTO `dungeon` VALUES ('32681', '32790', '182', '32675', '32799', '183', '0', 'TOI82F->TOI83F(A)');
INSERT INTO `dungeon` VALUES ('32682', '32790', '182', '32675', '32799', '183', '0', 'TOI82F->TOI83F(A)');
INSERT INTO `dungeon` VALUES ('32742', '32838', '182', '32732', '32907', '183', '0', 'TOI82F->TOI83F(B)');
INSERT INTO `dungeon` VALUES ('32742', '32839', '182', '32732', '32907', '183', '0', 'TOI82F->TOI83F(B)');
INSERT INTO `dungeon` VALUES ('32674', '32800', '183', '32681', '32791', '182', '4', 'TOI83F->TOI82F(A)');
INSERT INTO `dungeon` VALUES ('32675', '32800', '183', '32681', '32791', '182', '4', 'TOI83F->TOI82F(A)');
INSERT INTO `dungeon` VALUES ('32731', '32908', '183', '32741', '32839', '182', '6', 'TOI83F->TOI82F(B)');
INSERT INTO `dungeon` VALUES ('32732', '32908', '183', '32741', '32839', '182', '6', 'TOI83F->TOI82F(B)');
INSERT INTO `dungeon` VALUES ('32691', '32927', '183', '32846', '32862', '184', '2', 'TOI83F->TOI84F(B)');
INSERT INTO `dungeon` VALUES ('32691', '32928', '183', '32846', '32862', '184', '2', 'TOI83F->TOI84F(B)');
INSERT INTO `dungeon` VALUES ('32722', '32802', '183', '32873', '32753', '184', '2', 'TOI83F->TOI84F(A)');
INSERT INTO `dungeon` VALUES ('32722', '32803', '183', '32873', '32753', '184', '2', 'TOI83F->TOI84F(A)');
INSERT INTO `dungeon` VALUES ('32845', '32862', '184', '32690', '32928', '183', '6', 'TOI84F->TOI83F(A)');
INSERT INTO `dungeon` VALUES ('32845', '32863', '184', '32690', '32928', '183', '6', 'TOI84F->TOI83F(A)');
INSERT INTO `dungeon` VALUES ('32872', '32753', '184', '32721', '32803', '183', '6', 'TOI84F->TOI83F(B)');
INSERT INTO `dungeon` VALUES ('32872', '32754', '184', '32721', '32803', '183', '6', 'TOI84F->TOI83F(B)');
INSERT INTO `dungeon` VALUES ('32747', '32850', '184', '32734', '32848', '185', '0', 'TOI84F->TOI85F(A)');
INSERT INTO `dungeon` VALUES ('32748', '32850', '184', '32734', '32848', '185', '0', 'TOI84F->TOI85F(A)');
INSERT INTO `dungeon` VALUES ('32870', '32843', '184', '32874', '32858', '185', '2', 'TOI84F->TOI85F(B)');
INSERT INTO `dungeon` VALUES ('32870', '32844', '184', '32874', '32858', '185', '2', 'TOI84F->TOI85F(B)');
INSERT INTO `dungeon` VALUES ('32733', '32849', '185', '32747', '32851', '184', '4', 'TOI85F->TOI84F(A)');
INSERT INTO `dungeon` VALUES ('32734', '32849', '185', '32747', '32851', '184', '4', 'TOI85F->TOI84F(A)');
INSERT INTO `dungeon` VALUES ('32873', '32858', '185', '32869', '32844', '184', '6', 'TOI85F->TOI84F(B)');
INSERT INTO `dungeon` VALUES ('32873', '32859', '185', '32869', '32844', '184', '6', 'TOI85F->TOI84F(B)');
INSERT INTO `dungeon` VALUES ('32871', '32726', '185', '32724', '32797', '186', '0', 'TOI85F->TOI86F');
INSERT INTO `dungeon` VALUES ('32871', '32727', '185', '32724', '32797', '186', '0', 'TOI85F->86F');
INSERT INTO `dungeon` VALUES ('32723', '32798', '186', '32870', '32727', '185', '6', 'TOI86F->TOI85F');
INSERT INTO `dungeon` VALUES ('32724', '32798', '186', '32870', '32727', '185', '6', 'TOI86F->TOI85F');
INSERT INTO `dungeon` VALUES ('32797', '32800', '186', '32671', '32861', '187', '6', 'TOI86F->TOI87F');
INSERT INTO `dungeon` VALUES ('32797', '32801', '186', '32671', '32861', '187', '6', 'TOI86F->TOI87F');
INSERT INTO `dungeon` VALUES ('32672', '32860', '187', '32796', '32801', '186', '6', 'TOI87F->TOI86F');
INSERT INTO `dungeon` VALUES ('32672', '32861', '187', '32796', '32801', '186', '6', 'TOI87F->TOI86F');
INSERT INTO `dungeon` VALUES ('32602', '32790', '187', '32663', '32798', '188', '0', 'TOI87F->TOI88F(A)');
INSERT INTO `dungeon` VALUES ('32603', '32790', '187', '32663', '32798', '188', '0', 'TOI87F->TOI88F(A)');
INSERT INTO `dungeon` VALUES ('32745', '32932', '187', '32735', '32921', '188', '2', 'TOI87F->TOI88F(B)');
INSERT INTO `dungeon` VALUES ('32745', '32933', '187', '32735', '32921', '188', '2', 'TOI87F->TOI88F(B)');
INSERT INTO `dungeon` VALUES ('32662', '32799', '188', '32602', '32791', '187', '4', 'TOI88F->TOI87F(A)');
INSERT INTO `dungeon` VALUES ('32663', '32799', '188', '32602', '32791', '187', '4', 'TOI88F->TOI87F(A)');
INSERT INTO `dungeon` VALUES ('32734', '32921', '188', '32744', '32933', '187', '6', 'TOI88F->TOI87F(B)');
INSERT INTO `dungeon` VALUES ('32734', '32922', '188', '32744', '32933', '187', '6', 'TOI88F->TOI87F(B)');
INSERT INTO `dungeon` VALUES ('32614', '32918', '188', '32637', '32928', '189', '0', 'TOI88F->TOI89F(A)');
INSERT INTO `dungeon` VALUES ('32615', '32918', '188', '32637', '32928', '189', '0', 'TOI88F->TOI89F(A)');
INSERT INTO `dungeon` VALUES ('32745', '32858', '188', '32747', '32877', '189', '2', 'TOI88F->TOI89F(B)');
INSERT INTO `dungeon` VALUES ('32745', '32859', '188', '32747', '32877', '189', '2', 'TOI88F->TOI89F(B)');
INSERT INTO `dungeon` VALUES ('32636', '32929', '189', '32614', '32919', '188', '4', 'TOI89F->TOI88F(A)');
INSERT INTO `dungeon` VALUES ('32637', '32929', '189', '32614', '32919', '188', '4', 'TOI89F->TOI88F(A)');
INSERT INTO `dungeon` VALUES ('32746', '32877', '189', '32744', '32859', '188', '6', 'TOI89F->TOI88F(B)');
INSERT INTO `dungeon` VALUES ('32746', '32878', '189', '32744', '32859', '188', '6', 'TOI89F->TOI88F(B)');
INSERT INTO `dungeon` VALUES ('32656', '32790', '189', '32633', '32789', '190', '0', 'TOI89F->TOI90F(A)');
INSERT INTO `dungeon` VALUES ('32657', '32790', '189', '32633', '32789', '190', '0', 'TOI89F->TOI90F(A)');
INSERT INTO `dungeon` VALUES ('32745', '32841', '189', '32748', '32877', '190', '2', 'TOI89F->TOI90F(B)');
INSERT INTO `dungeon` VALUES ('32745', '32842', '189', '32748', '32877', '190', '2', 'TOI89F->TOI90F(B)');
INSERT INTO `dungeon` VALUES ('32632', '32790', '190', '32656', '32791', '189', '4', 'TOI90F->TOI89F(A)');
INSERT INTO `dungeon` VALUES ('32633', '32790', '190', '32656', '32791', '189', '4', 'TOI90F->TOI89F(A)');
INSERT INTO `dungeon` VALUES ('32747', '32877', '190', '32744', '32842', '189', '6', 'TOI90F->TOI89F(B)');
INSERT INTO `dungeon` VALUES ('32747', '32878', '190', '32744', '32842', '189', '6', 'TOI90F->TOI89F(B)');
INSERT INTO `dungeon` VALUES ('32672', '32864', '191', '32671', '32860', '192', '6', 'TOI91F->TOI92F(A)');
INSERT INTO `dungeon` VALUES ('32672', '32865', '191', '32671', '32860', '192', '6', 'TOI91F->TOI92F(A)');
INSERT INTO `dungeon` VALUES ('32740', '32902', '191', '32747', '32879', '192', '2', 'TOI91F->TOI92F(B)');
INSERT INTO `dungeon` VALUES ('32740', '32903', '191', '32747', '32879', '192', '2', 'TOI91F->TOI92F(B)');
INSERT INTO `dungeon` VALUES ('32672', '32859', '192', '32671', '32865', '191', '6', 'TOI92F->TOI91F(A)');
INSERT INTO `dungeon` VALUES ('32672', '32860', '192', '32671', '32865', '191', '6', 'TOI92F->TOI91F(A)');
INSERT INTO `dungeon` VALUES ('32746', '32879', '192', '32739', '32903', '191', '6', 'TOI92F->TOI91F(B)');
INSERT INTO `dungeon` VALUES ('32746', '32880', '192', '32739', '32903', '191', '6', 'TOI92F->TOI91F(B)');
INSERT INTO `dungeon` VALUES ('32731', '32806', '192', '32730', '32804', '193', '2', '');
INSERT INTO `dungeon` VALUES ('32731', '32807', '192', '32730', '32804', '193', '2', '');
INSERT INTO `dungeon` VALUES ('32736', '32913', '192', '32732', '32907', '193', '0', '');
INSERT INTO `dungeon` VALUES ('32736', '32914', '192', '32732', '32907', '193', '0', '');
INSERT INTO `dungeon` VALUES ('32729', '32804', '193', '32730', '32807', '192', '6', 'TOI93F->TOI92F(A)');
INSERT INTO `dungeon` VALUES ('32729', '32805', '193', '32730', '32807', '192', '6', 'TOI93F->TOI92F(A)');
INSERT INTO `dungeon` VALUES ('32731', '32908', '193', '32735', '32914', '192', '6', 'TOI93F->TOI92F(B)');
INSERT INTO `dungeon` VALUES ('32732', '32908', '193', '32735', '32914', '192', '6', 'TOI93F->TOI92F(B)');
INSERT INTO `dungeon` VALUES ('32662', '32820', '193', '32845', '32748', '194', '2', 'TOI93F->TOI94F(A)');
INSERT INTO `dungeon` VALUES ('32663', '32820', '193', '32845', '32748', '194', '2', 'TOI93F->TOI94F(A)');
INSERT INTO `dungeon` VALUES ('32736', '32858', '193', '32869', '32834', '194', '2', 'TOI93F->TOI94F(B)');
INSERT INTO `dungeon` VALUES ('32736', '32859', '193', '32869', '32834', '194', '2', 'TOI93F->TOI94F(B)');
INSERT INTO `dungeon` VALUES ('32844', '32748', '194', '32662', '32821', '193', '4', 'TOI94F->TOI93F(A)');
INSERT INTO `dungeon` VALUES ('32844', '32749', '194', '32662', '32821', '193', '4', 'TOI94F->TOI93F(A)');
INSERT INTO `dungeon` VALUES ('32868', '32834', '194', '32735', '32859', '193', '6', 'TOI94F->TOI93F(B)');
INSERT INTO `dungeon` VALUES ('32868', '32835', '194', '32735', '32859', '193', '6', 'TOI94F->TOI93F(B)');
INSERT INTO `dungeon` VALUES ('32756', '32824', '194', '32734', '32848', '195', '0', 'TOI94F->TOI95F(A)');
INSERT INTO `dungeon` VALUES ('32757', '32824', '194', '32734', '32848', '195', '0', 'TOI94F->TOI95F(A)');
INSERT INTO `dungeon` VALUES ('32799', '32800', '194', '32798', '32798', '195', '6', 'TOI94F->TOI95F(B)');
INSERT INTO `dungeon` VALUES ('32799', '32801', '194', '32798', '32798', '195', '6', 'TOI94F->TOI95F(B)');
INSERT INTO `dungeon` VALUES ('32733', '32849', '195', '32756', '32825', '194', '4', 'TOI95F->TOI94F(A)');
INSERT INTO `dungeon` VALUES ('32734', '32849', '195', '32756', '32825', '194', '4', 'TOI95F->TOI94F(A)');
INSERT INTO `dungeon` VALUES ('32799', '32797', '195', '32798', '32801', '194', '6', 'TOI95F->TOI94F(B)');
INSERT INTO `dungeon` VALUES ('32799', '32798', '195', '32798', '32801', '194', '6', 'TOI95F->TOI94F(B)');
INSERT INTO `dungeon` VALUES ('32743', '32731', '195', '32733', '32787', '196', '0', 'TOI95F->TOI96F');
INSERT INTO `dungeon` VALUES ('32744', '32731', '195', '32733', '32787', '196', '0', 'TOI95F->TOI96F');
INSERT INTO `dungeon` VALUES ('32732', '32788', '196', '32743', '32732', '195', '4', '');
INSERT INTO `dungeon` VALUES ('32733', '32788', '196', '32743', '32732', '195', '4', '');
INSERT INTO `dungeon` VALUES ('32803', '32806', '196', '32671', '32861', '197', '6', 'TOI96F->TOI97F');
INSERT INTO `dungeon` VALUES ('32803', '32807', '196', '32671', '32861', '197', '6', 'TOI96F->TOI97F');
INSERT INTO `dungeon` VALUES ('32672', '32860', '197', '32802', '32807', '196', '6', 'TOI97F->TOI96F');
INSERT INTO `dungeon` VALUES ('32672', '32861', '197', '32802', '32807', '196', '6', 'TOI97F->TOI96F');
INSERT INTO `dungeon` VALUES ('32602', '32790', '197', '32620', '32797', '198', '0', 'TOI97F->TOI98F(A)');
INSERT INTO `dungeon` VALUES ('32603', '32790', '197', '32620', '32797', '198', '0', 'TOI97F->TOI98F(A)');
INSERT INTO `dungeon` VALUES ('32745', '32932', '197', '32735', '32921', '198', '2', 'TOI97F->TOI98F(B)');
INSERT INTO `dungeon` VALUES ('32745', '32933', '197', '32735', '32921', '198', '2', 'TOI97F->TOI98F(B)');
INSERT INTO `dungeon` VALUES ('32619', '32798', '198', '32602', '32791', '197', '4', 'TOI98F->TOI97F(A)');
INSERT INTO `dungeon` VALUES ('32620', '32798', '198', '32602', '32791', '197', '4', 'TOI98F->TOI97F(A)');
INSERT INTO `dungeon` VALUES ('32734', '32921', '198', '32744', '32933', '197', '6', 'TOI98F->TOI97F(B)');
INSERT INTO `dungeon` VALUES ('32734', '32922', '198', '32744', '32933', '197', '6', 'TOI98F->TOI97F(B)');
INSERT INTO `dungeon` VALUES ('32614', '32918', '198', '32637', '32928', '199', '0', 'TOI98F->TOI99F(A)');
INSERT INTO `dungeon` VALUES ('32615', '32918', '198', '32637', '32928', '199', '0', 'TOI98F->TOI99F(A)');
INSERT INTO `dungeon` VALUES ('32670', '32936', '198', '32711', '32928', '199', '2', 'TOI98F->TOI99F(B)');
INSERT INTO `dungeon` VALUES ('32670', '32937', '198', '32711', '32928', '199', '2', 'TOI98F->TOI99F(B)');
INSERT INTO `dungeon` VALUES ('32636', '32929', '199', '32614', '32919', '198', '4', 'TOI99F->TOI98F(A)');
INSERT INTO `dungeon` VALUES ('32637', '32929', '199', '32614', '32919', '198', '4', 'TOI99F->TOI98F(A)');
INSERT INTO `dungeon` VALUES ('32710', '32928', '199', '32669', '32937', '198', '6', 'TOI99F->TOI98F(B)');
INSERT INTO `dungeon` VALUES ('32710', '32929', '199', '32669', '32937', '198', '6', 'TOI99F->TOI98F(B)');
INSERT INTO `dungeon` VALUES ('32623', '32916', '199', '32632', '32974', '200', '4', 'TOI99F>TOI100F');
INSERT INTO `dungeon` VALUES ('32720', '32872', '199', '32731', '32856', '200', '2', 'TOI99F->TOI100F');
INSERT INTO `dungeon` VALUES ('32720', '32873', '199', '32731', '32856', '200', '2', 'TOI99F->TOI100F');
INSERT INTO `dungeon` VALUES ('32632', '32974', '200', '32623', '32916', '199', '4', 'TOI99F>TOI100F');
INSERT INTO `dungeon` VALUES ('32730', '32856', '200', '32719', '32873', '199', '6', 'TOI100F->TOI99F');
INSERT INTO `dungeon` VALUES ('32730', '32857', '200', '32719', '32873', '199', '6', 'TOI100F->TOI99F');
INSERT INTO `dungeon` VALUES ('32868', '32919', '201', '32929', '32798', '201', '5', 'MQD>MQD');
INSERT INTO `dungeon` VALUES ('32736', '32807', '237', '32813', '32810', '13', '2', 'JimDungeon>MLC7F');
INSERT INTO `dungeon` VALUES ('32670', '33122', '240', '32760', '32882', '241', '4', 'KC1F->KC2F');
INSERT INTO `dungeon` VALUES ('32760', '32882', '241', '32670', '33122', '240', '0', 'KC2F->KC1F');
INSERT INTO `dungeon` VALUES ('32732', '32928', '241', '32808', '32917', '242', '4', 'KC2F->KC3F');
INSERT INTO `dungeon` VALUES ('32808', '32917', '242', '32732', '32928', '241', '0', 'KC3F->KC2F');
INSERT INTO `dungeon` VALUES ('32740', '33007', '242', '32745', '32852', '243', '4', 'KC3F->KC4F');
INSERT INTO `dungeon` VALUES ('32745', '32852', '243', '32740', '33007', '242', '0', 'KC4F->KC3F');
INSERT INTO `dungeon` VALUES ('32752', '32812', '244', '32842', '32917', '244', '0', '');
INSERT INTO `dungeon` VALUES ('32752', '32813', '244', '32842', '32917', '244', '0', '');
INSERT INTO `dungeon` VALUES ('32880', '32907', '244', '32982', '32808', '244', '0', '');
INSERT INTO `dungeon` VALUES ('32880', '32908', '244', '32982', '32808', '244', '0', '');
INSERT INTO `dungeon` VALUES ('32747', '32860', '252', '32575', '32814', '64', '0', '');
INSERT INTO `dungeon` VALUES ('32747', '32861', '252', '32575', '32814', '64', '0', '');
INSERT INTO `dungeon` VALUES ('32599', '32873', '252', '32756', '32859', '253', '0', '');
INSERT INTO `dungeon` VALUES ('32599', '32874', '252', '32757', '32859', '253', '0', '');
INSERT INTO `dungeon` VALUES ('32756', '32858', '253', '32600', '32873', '252', '0', '');
INSERT INTO `dungeon` VALUES ('32757', '32858', '253', '32600', '32874', '252', '0', '');
INSERT INTO `dungeon` VALUES ('32808', '32984', '253', '32615', '32793', '254', '0', '');
INSERT INTO `dungeon` VALUES ('32808', '32985', '253', '32616', '32793', '254', '0', '');
INSERT INTO `dungeon` VALUES ('32616', '32792', '254', '32807', '32984', '253', '0', '');
INSERT INTO `dungeon` VALUES ('32812', '32813', '255', '32696', '32793', '256', '0', '');
INSERT INTO `dungeon` VALUES ('32812', '32814', '255', '32697', '32793', '256', '0', '');
INSERT INTO `dungeon` VALUES ('32696', '32792', '256', '32811', '32813', '255', '0', '');
INSERT INTO `dungeon` VALUES ('32697', '32792', '256', '32811', '32814', '255', '0', '');
INSERT INTO `dungeon` VALUES ('32678', '32789', '301', '34150', '33382', '4', '6', '1F->');
INSERT INTO `dungeon` VALUES ('32661', '32933', '301', '32872', '32870', '101', '2', '->TOI1F');
INSERT INTO `dungeon` VALUES ('32624', '32802', '304', '33389', '32273', '4', '2', 'SilentCavern->WorldMap 2');
INSERT INTO `dungeon` VALUES ('32625', '32802', '304', '33389', '32273', '4', '1', 'SilentCavern->WorldMap 1');
INSERT INTO `dungeon` VALUES ('32803', '32823', '304', '32731', '32786', '305', '2', '');
INSERT INTO `dungeon` VALUES ('32731', '32785', '305', '32802', '32823', '304', '2', '');
INSERT INTO `dungeon` VALUES ('32762', '32822', '307', '32564', '33460', '4', '2', ' 1->');
INSERT INTO `dungeon` VALUES ('32931', '32875', '307', '32751', '32823', '308', '2', '1->2');
INSERT INTO `dungeon` VALUES ('32752', '32823', '308', '32929', '32875', '307', '2', '2->1');
INSERT INTO `dungeon` VALUES ('32993', '32914', '308', '32757', '32836', '309', '2', '2->3');
INSERT INTO `dungeon` VALUES ('32758', '32836', '309', '32992', '32914', '308', '2', '3->2');
INSERT INTO `dungeon` VALUES ('33060', '32882', '309', '32722', '32850', '320', '2', '3-> ');
INSERT INTO `dungeon` VALUES ('32783', '32839', '310', '32863', '32942', '310', '0', '');
INSERT INTO `dungeon` VALUES ('32863', '32942', '310', '32783', '32839', '310', '0', '');
INSERT INTO `dungeon` VALUES ('32785', '32939', '310', '32811', '32788', '320', '2', '');
INSERT INTO `dungeon` VALUES ('32721', '32849', '320', '33059', '32882', '309', '2', ' ->3');
INSERT INTO `dungeon` VALUES ('32811', '32787', '320', '32785', '32938', '310', '2', '');
INSERT INTO `dungeon` VALUES ('33008', '32835', '320', '32729', '33000', '330', '2', '');
INSERT INTO `dungeon` VALUES ('32729', '33001', '330', '33008', '32836', '320', '2', '');
INSERT INTO `dungeon` VALUES ('32795', '32833', '400', '32821', '32843', '400', '2', '()->');
INSERT INTO `dungeon` VALUES ('32799', '33005', '400', '32857', '32945', '400', '2', '->()');
INSERT INTO `dungeon` VALUES ('32820', '32843', '400', '32794', '32833', '400', '2', '->()');
INSERT INTO `dungeon` VALUES ('32858', '32945', '400', '32799', '33004', '400', '2', '()->');
INSERT INTO `dungeon` VALUES ('32826', '33001', '400', '32929', '32995', '410', '2', '');
INSERT INTO `dungeon` VALUES ('32930', '32971', '400', '32777', '32854', '420', '2', '');
INSERT INTO `dungeon` VALUES ('32930', '32995', '410', '32825', '33001', '400', '2', '');
INSERT INTO `dungeon` VALUES ('32777', '32853', '420', '32930', '32972', '400', '2', '-> ');
INSERT INTO `dungeon` VALUES ('32807', '33047', '420', '32934', '32786', '430', '2', '');
INSERT INTO `dungeon` VALUES ('32536', '32888', '440', '32738', '32738', '441', '2', '->PIC1F(A)');
INSERT INTO `dungeon` VALUES ('32537', '32888', '440', '32738', '32738', '441', '2', '->PIC1F(A)');
INSERT INTO `dungeon` VALUES ('32538', '32888', '440', '32738', '32738', '441', '2', '->PIC1F(A)');
INSERT INTO `dungeon` VALUES ('32524', '33134', '440', '32679', '32862', '441', '2', '->PIC1F(B)');
INSERT INTO `dungeon` VALUES ('32524', '33135', '440', '32679', '32862', '441', '2', '->PIC1F(B)');
INSERT INTO `dungeon` VALUES ('32524', '33136', '440', '32679', '32862', '441', '2', '->PIC1F(B)');
INSERT INTO `dungeon` VALUES ('32297', '33087', '440', '32735', '32794', '446', '4', '');
INSERT INTO `dungeon` VALUES ('32725', '33040', '440', '32658', '32944', '480', '2', '()->()');
INSERT INTO `dungeon` VALUES ('32725', '33041', '440', '32658', '32945', '480', '2', '()->()');
INSERT INTO `dungeon` VALUES ('32725', '33042', '440', '32658', '32946', '480', '2', '()->()');
INSERT INTO `dungeon` VALUES ('32733', '32921', '440', '32657', '32863', '480', '2', '()->()');
INSERT INTO `dungeon` VALUES ('32733', '32922', '440', '32657', '32864', '480', '2', '()->()');
INSERT INTO `dungeon` VALUES ('32733', '32923', '440', '32657', '32865', '480', '2', '()->()');
INSERT INTO `dungeon` VALUES ('32737', '32737', '441', '32537', '32890', '440', '2', 'PIC1F(A)->');
INSERT INTO `dungeon` VALUES ('32738', '32737', '441', '32537', '32890', '440', '2', 'PIC1F(A)->');
INSERT INTO `dungeon` VALUES ('32739', '32737', '441', '32537', '32890', '440', '2', 'PIC1F(A)->');
INSERT INTO `dungeon` VALUES ('32678', '32861', '441', '32522', '33135', '440', '2', 'PIC1F(B)->');
INSERT INTO `dungeon` VALUES ('32679', '32861', '441', '32522', '33135', '440', '2', 'PIC1F(B)->');
INSERT INTO `dungeon` VALUES ('32680', '32861', '441', '32522', '33135', '440', '2', 'PIC1F(B)->');
INSERT INTO `dungeon` VALUES ('32805', '32802', '441', '32862', '32730', '442', '2', '1->2');
INSERT INTO `dungeon` VALUES ('32862', '32729', '442', '32806', '32802', '441', '2', '2->1');
INSERT INTO `dungeon` VALUES ('32860', '32799', '442', '32864', '32781', '443', '2', '2->3');
INSERT INTO `dungeon` VALUES ('32864', '32780', '443', '32860', '32798', '442', '2', '3->2');
INSERT INTO `dungeon` VALUES ('32752', '32745', '443', '32745', '32809', '444', '2', '3->4');
INSERT INTO `dungeon` VALUES ('32745', '32809', '444', '32752', '32745', '443', '2', 'PIC4F>PIC3F');
INSERT INTO `dungeon` VALUES ('32738', '32852', '445', '32715', '32448', '4', '5', '');
INSERT INTO `dungeon` VALUES ('32750', '32874', '445', '32732', '32796', '447', '4', '');
INSERT INTO `dungeon` VALUES ('32735', '32794', '446', '32297', '33087', '440', '0', '');
INSERT INTO `dungeon` VALUES ('32732', '32796', '447', '32750', '32874', '445', '0', '');
INSERT INTO `dungeon` VALUES ('32656', '32863', '480', '32732', '32921', '440', '6', '()->()');
INSERT INTO `dungeon` VALUES ('32656', '32864', '480', '32732', '32922', '440', '6', '()->()');
INSERT INTO `dungeon` VALUES ('32656', '32865', '480', '32732', '32923', '440', '6', '()->()');
INSERT INTO `dungeon` VALUES ('32657', '32944', '480', '32724', '33040', '440', '6', '()->()');
INSERT INTO `dungeon` VALUES ('32657', '32945', '480', '32724', '33041', '440', '6', '()->()');
INSERT INTO `dungeon` VALUES ('32657', '32946', '480', '32724', '33042', '440', '6', '()->()');
INSERT INTO `dungeon` VALUES ('32837', '32839', '480', '32735', '32846', '481', '0', '');
INSERT INTO `dungeon` VALUES ('32837', '32840', '480', '32735', '32846', '481', '0', '');
INSERT INTO `dungeon` VALUES ('32837', '32841', '480', '32735', '32846', '481', '0', '');
INSERT INTO `dungeon` VALUES ('32735', '32847', '481', '32836', '32840', '480', '6', '');
INSERT INTO `dungeon` VALUES ('32748', '32955', '521', '32657', '32896', '522', '2', '->1F');
INSERT INTO `dungeon` VALUES ('32748', '32956', '521', '32657', '32896', '522', '2', '->1F');
INSERT INTO `dungeon` VALUES ('32748', '32957', '521', '32657', '32896', '522', '2', '->1F');
INSERT INTO `dungeon` VALUES ('33170', '32759', '4', '32735', '32812', '15', '0', '');
INSERT INTO `dungeon` VALUES ('32735', '32812', '15', '33170', '32759', '4', '4', '');
INSERT INTO `dungeon` VALUES ('33171', '32759', '4', '32736', '32812', '15', '0', '');
INSERT INTO `dungeon` VALUES ('32736', '32812', '15', '33171', '32759', '4', '4', '');
INSERT INTO `dungeon` VALUES ('32677', '33392', '4', '32734', '32816', '29', '0', 'WW->WW');
INSERT INTO `dungeon` VALUES ('32734', '32816', '29', '32677', '33392', '4', '4', 'WW->WW');
INSERT INTO `dungeon` VALUES ('32678', '33392', '4', '32735', '32816', '29', '0', 'WW->WW');
INSERT INTO `dungeon` VALUES ('32735', '32816', '29', '32678', '33392', '4', '4', 'WW->WW');
INSERT INTO `dungeon` VALUES ('33631', '32660', '4', '32728', '32828', '52', '0', '');
INSERT INTO `dungeon` VALUES ('32728', '32828', '52', '33631', '32660', '4', '4', '');
INSERT INTO `dungeon` VALUES ('33632', '32660', '4', '32729', '32828', '52', '0', '');
INSERT INTO `dungeon` VALUES ('32729', '32828', '52', '33632', '32660', '4', '4', '');
INSERT INTO `dungeon` VALUES ('33522', '33385', '4', '32571', '32862', '64', '0', '');
INSERT INTO `dungeon` VALUES ('32571', '32862', '64', '33522', '33385', '4', '4', '');
INSERT INTO `dungeon` VALUES ('33523', '33385', '4', '32572', '32862', '64', '0', '');
INSERT INTO `dungeon` VALUES ('32572', '32862', '64', '33523', '33385', '4', '4', '');
INSERT INTO `dungeon` VALUES ('34090', '33203', '4', '32891', '32580', '300', '0', '');
INSERT INTO `dungeon` VALUES ('32891', '32580', '300', '34090', '33203', '4', '4', '');
INSERT INTO `dungeon` VALUES ('34091', '33203', '4', '32892', '32580', '300', '0', '');
INSERT INTO `dungeon` VALUES ('32892', '32580', '300', '34091', '33203', '4', '4', '');
INSERT INTO `dungeon` VALUES ('32735', '32991', '2000', '32735', '32800', '2001', '5', '1F->2F');
INSERT INTO `dungeon` VALUES ('32812', '32872', '2002', '32736', '32811', '2003', '5', '3F->4F');
INSERT INTO `dungeon` VALUES ('32814', '32796', '600', '32724', '32830', '601', '2', '');
INSERT INTO `dungeon` VALUES ('32814', '32797', '600', '32724', '32831', '601', '2', '');
INSERT INTO `dungeon` VALUES ('32814', '32798', '600', '32724', '32832', '601', '2', '');
INSERT INTO `dungeon` VALUES ('32722', '32830', '601', '32812', '32796', '600', '6', '');
INSERT INTO `dungeon` VALUES ('32722', '32831', '601', '32812', '32797', '600', '6', '');
INSERT INTO `dungeon` VALUES ('32722', '32832', '601', '32812', '32798', '600', '6', '');
INSERT INTO `dungeon` VALUES ('32917', '32794', '778', '32891', '32727', '779', '4', '()->()');
INSERT INTO `dungeon` VALUES ('32918', '32794', '778', '32892', '32727', '779', '4', '()->()');
INSERT INTO `dungeon` VALUES ('32771', '32933', '778', '32937', '32798', '779', '6', '()->()');
INSERT INTO `dungeon` VALUES ('32771', '32934', '778', '32937', '32799', '779', '6', '()->()');
INSERT INTO `dungeon` VALUES ('32891', '32725', '779', '32918', '32792', '778', '0', '()->()');
INSERT INTO `dungeon` VALUES ('32892', '32725', '779', '32917', '32792', '778', '0', '()->()');
INSERT INTO `dungeon` VALUES ('32939', '32798', '779', '32769', '32933', '778', '2', '()->()');
INSERT INTO `dungeon` VALUES ('32939', '32799', '779', '32769', '32934', '778', '2', '()->()');
INSERT INTO `dungeon` VALUES ('32823', '32854', '400', '32680', '32971', '400', '5', '-> ');
INSERT INTO `dungeon` VALUES ('32681', '32971', '400', '32823', '32855', '400', '2', ' ->');
INSERT INTO `dungeon` VALUES ('32758', '32636', '400', '32677', '32819', '400', '2', '()-> ');
INSERT INTO `dungeon` VALUES ('32678', '32819', '400', '32757', '32636', '400', '5', ' ->()');
INSERT INTO `dungeon` VALUES ('32706', '32637', '400', '32804', '32870', '401', '4', '');
INSERT INTO `dungeon` VALUES ('33005', '32762', '400', '32656', '32852', '450', '2', '');
INSERT INTO `dungeon` VALUES ('33005', '32763', '400', '32656', '32853', '450', '2', '');
INSERT INTO `dungeon` VALUES ('33005', '32764', '400', '32656', '32854', '450', '2', '');
INSERT INTO `dungeon` VALUES ('32655', '32852', '450', '33004', '32762', '400', '6', '');
INSERT INTO `dungeon` VALUES ('32655', '32853', '450', '33004', '32763', '400', '6', '');
INSERT INTO `dungeon` VALUES ('32655', '32854', '450', '33004', '32764', '400', '6', '');
INSERT INTO `dungeon` VALUES ('32770', '32848', '450', '32726', '32847', '451', '2', '->1');
INSERT INTO `dungeon` VALUES ('32770', '32849', '450', '32726', '32848', '451', '2', '->1');
INSERT INTO `dungeon` VALUES ('32770', '32850', '450', '32726', '32849', '451', '2', '->1');
INSERT INTO `dungeon` VALUES ('32724', '32848', '451', '32769', '32849', '450', '6', '1->');
INSERT INTO `dungeon` VALUES ('32786', '32792', '451', '32682', '32742', '491', '4', '1->');
INSERT INTO `dungeon` VALUES ('32733', '32859', '491', '32721', '32861', '495', '2', '');
INSERT INTO `dungeon` VALUES ('32733', '32860', '491', '32721', '32861', '495', '2', '');
INSERT INTO `dungeon` VALUES ('32733', '32861', '491', '32721', '32861', '495', '2', '');
INSERT INTO `dungeon` VALUES ('32733', '32862', '491', '32721', '32861', '495', '2', '');
INSERT INTO `dungeon` VALUES ('32815', '32816', '495', '32791', '32815', '496', '2', '');
INSERT INTO `dungeon` VALUES ('32815', '32817', '495', '32791', '32815', '496', '2', '');
INSERT INTO `dungeon` VALUES ('32815', '32818', '495', '32791', '32815', '496', '2', '');
INSERT INTO `dungeon` VALUES ('32815', '32819', '495', '32791', '32815', '496', '2', '');
INSERT INTO `dungeon` VALUES ('32771', '32785', '495', '32797', '32813', '493', '0', '');
INSERT INTO `dungeon` VALUES ('32772', '32785', '495', '32797', '32813', '493', '0', '');
INSERT INTO `dungeon` VALUES ('32773', '32785', '495', '32797', '32813', '493', '0', '');
INSERT INTO `dungeon` VALUES ('32774', '32785', '495', '32797', '32813', '493', '0', '');
INSERT INTO `dungeon` VALUES ('32806', '32769', '493', '32790', '32761', '494', '2', '');
INSERT INTO `dungeon` VALUES ('32806', '32770', '493', '32790', '32761', '494', '2', '');
INSERT INTO `dungeon` VALUES ('32806', '32771', '493', '32790', '32761', '494', '2', '');
INSERT INTO `dungeon` VALUES ('32806', '32772', '493', '32790', '32761', '494', '2', '');
INSERT INTO `dungeon` VALUES ('32744', '32723', '493', '32727', '32858', '490', '0', '');
INSERT INTO `dungeon` VALUES ('32745', '32723', '493', '32727', '32858', '490', '0', '');
INSERT INTO `dungeon` VALUES ('32746', '32723', '493', '32727', '32858', '490', '0', '');
INSERT INTO `dungeon` VALUES ('32747', '32723', '493', '32727', '32858', '490', '0', '');
INSERT INTO `dungeon` VALUES ('32731', '32809', '490', '32785', '32813', '492', '0', '');
INSERT INTO `dungeon` VALUES ('32731', '32810', '490', '32785', '32813', '492', '0', '');
INSERT INTO `dungeon` VALUES ('32731', '32811', '490', '32785', '32813', '492', '0', '');
INSERT INTO `dungeon` VALUES ('32731', '32812', '490', '32785', '32813', '492', '0', '');
INSERT INTO `dungeon` VALUES ('32813', '32832', '451', '32723', '32825', '452', '2', '1->');
INSERT INTO `dungeon` VALUES ('32813', '32833', '451', '32723', '32825', '452', '2', '1->');
INSERT INTO `dungeon` VALUES ('32813', '32834', '451', '32723', '32825', '452', '2', '1->');
INSERT INTO `dungeon` VALUES ('32813', '32835', '451', '32723', '32825', '452', '2', '1->');
INSERT INTO `dungeon` VALUES ('32722', '32824', '452', '32813', '32834', '451', '6', '->1');
INSERT INTO `dungeon` VALUES ('32722', '32826', '452', '32813', '32834', '451', '6', '->1');
INSERT INTO `dungeon` VALUES ('32811', '32835', '452', '32723', '32851', '453', '2', '');
INSERT INTO `dungeon` VALUES ('32811', '32836', '452', '32723', '32851', '453', '2', '');
INSERT INTO `dungeon` VALUES ('32811', '32837', '452', '32723', '32851', '453', '2', '');
INSERT INTO `dungeon` VALUES ('32811', '32838', '452', '32723', '32851', '453', '2', '');
INSERT INTO `dungeon` VALUES ('32722', '32850', '453', '32811', '32837', '452', '6', '');
INSERT INTO `dungeon` VALUES ('32722', '32851', '453', '32811', '32837', '452', '6', '');
INSERT INTO `dungeon` VALUES ('32722', '32852', '453', '32811', '32837', '452', '6', '');
INSERT INTO `dungeon` VALUES ('32722', '32853', '453', '32811', '32837', '452', '6', '');
INSERT INTO `dungeon` VALUES ('32766', '32830', '453', '32729', '32876', '454', '0', '');
INSERT INTO `dungeon` VALUES ('32767', '32830', '453', '32729', '32876', '454', '0', '');
INSERT INTO `dungeon` VALUES ('32768', '32830', '453', '32729', '32876', '454', '0', '');
INSERT INTO `dungeon` VALUES ('32769', '32830', '453', '32729', '32876', '454', '0', '');
INSERT INTO `dungeon` VALUES ('32793', '32851', '453', '32751', '32871', '456', '2', '');
INSERT INTO `dungeon` VALUES ('32793', '32852', '453', '32751', '32871', '456', '2', '');
INSERT INTO `dungeon` VALUES ('32793', '32853', '453', '32751', '32871', '456', '2', '');
INSERT INTO `dungeon` VALUES ('32793', '32854', '453', '32751', '32871', '456', '2', '');
INSERT INTO `dungeon` VALUES ('32723', '32727', '453', '32665', '32852', '457', '4', '->1');
INSERT INTO `dungeon` VALUES ('32723', '32728', '453', '32665', '32852', '457', '4', '->1');
INSERT INTO `dungeon` VALUES ('32727', '32876', '454', '32768', '32830', '453', '4', '');
INSERT INTO `dungeon` VALUES ('32728', '32876', '454', '32768', '32830', '453', '4', '');
INSERT INTO `dungeon` VALUES ('32729', '32876', '454', '32768', '32830', '453', '4', '');
INSERT INTO `dungeon` VALUES ('32730', '32876', '454', '32768', '32830', '453', '4', '');
INSERT INTO `dungeon` VALUES ('32813', '32821', '454', '32723', '32853', '455', '2', '');
INSERT INTO `dungeon` VALUES ('32813', '32822', '454', '32723', '32853', '455', '2', '');
INSERT INTO `dungeon` VALUES ('32813', '32823', '454', '32723', '32853', '455', '2', '');
INSERT INTO `dungeon` VALUES ('32813', '32824', '454', '32723', '32853', '455', '2', '');
INSERT INTO `dungeon` VALUES ('32723', '32851', '455', '32813', '32823', '454', '6', '');
INSERT INTO `dungeon` VALUES ('32723', '32852', '455', '32813', '32823', '454', '6', '');
INSERT INTO `dungeon` VALUES ('32723', '32853', '455', '32813', '32823', '454', '6', '');
INSERT INTO `dungeon` VALUES ('32723', '32854', '455', '32813', '32823', '454', '6', '');
INSERT INTO `dungeon` VALUES ('32809', '32872', '455', '32665', '32852', '457', '4', '->1');
INSERT INTO `dungeon` VALUES ('32810', '32872', '455', '32665', '32852', '457', '4', '->1');
INSERT INTO `dungeon` VALUES ('32751', '32869', '456', '32793', '32853', '453', '6', '');
INSERT INTO `dungeon` VALUES ('32751', '32870', '456', '32793', '32853', '453', '6', '');
INSERT INTO `dungeon` VALUES ('32751', '32871', '456', '32793', '32853', '453', '6', '');
INSERT INTO `dungeon` VALUES ('32751', '32872', '456', '32793', '32853', '453', '6', '');
INSERT INTO `dungeon` VALUES ('32808', '32793', '456', '32665', '32852', '457', '4', '->1');
INSERT INTO `dungeon` VALUES ('32808', '32794', '456', '32665', '32852', '457', '4', '->1');
INSERT INTO `dungeon` VALUES ('32685', '32868', '457', '32725', '32818', '464', '2', '1->');
INSERT INTO `dungeon` VALUES ('32685', '32869', '457', '32725', '32818', '464', '2', '1->');
INSERT INTO `dungeon` VALUES ('32725', '32818', '464', '32684', '32869', '457', '6', '->1');
INSERT INTO `dungeon` VALUES ('32806', '32828', '464', '32721', '32818', '465', '2', '');
INSERT INTO `dungeon` VALUES ('32806', '32829', '464', '32721', '32818', '465', '2', '');
INSERT INTO `dungeon` VALUES ('32806', '32830', '464', '32721', '32818', '465', '2', '');
INSERT INTO `dungeon` VALUES ('32806', '32831', '464', '32721', '32818', '465', '2', '');
INSERT INTO `dungeon` VALUES ('32721', '32817', '465', '32806', '32829', '464', '6', '');
INSERT INTO `dungeon` VALUES ('32721', '32818', '465', '32806', '32829', '464', '6', '');
INSERT INTO `dungeon` VALUES ('32721', '32819', '465', '32806', '32829', '464', '6', '');
INSERT INTO `dungeon` VALUES ('32721', '32820', '465', '32806', '32829', '464', '6', '');
INSERT INTO `dungeon` VALUES ('32811', '32807', '465', '32722', '32847', '466', '2', '');
INSERT INTO `dungeon` VALUES ('32811', '32808', '465', '32722', '32847', '466', '2', '');
INSERT INTO `dungeon` VALUES ('32811', '32809', '465', '32722', '32847', '466', '2', '');
INSERT INTO `dungeon` VALUES ('32811', '32810', '465', '32722', '32847', '466', '2', '');
INSERT INTO `dungeon` VALUES ('32722', '32846', '466', '32811', '32808', '465', '6', '');
INSERT INTO `dungeon` VALUES ('32722', '32847', '466', '32811', '32808', '465', '6', '');
INSERT INTO `dungeon` VALUES ('32722', '32848', '466', '32811', '32808', '465', '6', '');
INSERT INTO `dungeon` VALUES ('32722', '32849', '466', '32811', '32808', '465', '6', '');
INSERT INTO `dungeon` VALUES ('32807', '32843', '466', '32660', '32870', '468', '4', '->2');
INSERT INTO `dungeon` VALUES ('32660', '32868', '468', '32665', '32852', '457', '4', '2->1');
INSERT INTO `dungeon` VALUES ('32661', '32868', '468', '32665', '32852', '457', '4', '2->1');
INSERT INTO `dungeon` VALUES ('32680', '32863', '457', '32792', '32866', '460', '2', '1->');
INSERT INTO `dungeon` VALUES ('32681', '32863', '457', '32792', '32866', '460', '2', '1->');
INSERT INTO `dungeon` VALUES ('32792', '32866', '460', '32680', '32865', '457', '4', '->1');
INSERT INTO `dungeon` VALUES ('32814', '32818', '460', '32658', '32862', '461', '2', '');
INSERT INTO `dungeon` VALUES ('32814', '32819', '460', '32658', '32862', '461', '2', '');
INSERT INTO `dungeon` VALUES ('32814', '32820', '460', '32658', '32862', '461', '2', '');
INSERT INTO `dungeon` VALUES ('32814', '32821', '460', '32658', '32862', '461', '2', '');
INSERT INTO `dungeon` VALUES ('32658', '32861', '461', '32814', '32819', '460', '6', '');
INSERT INTO `dungeon` VALUES ('32658', '32862', '461', '32814', '32819', '460', '6', '');
INSERT INTO `dungeon` VALUES ('32658', '32863', '461', '32814', '32819', '460', '6', '');
INSERT INTO `dungeon` VALUES ('32658', '32864', '461', '32814', '32819', '460', '6', '');
INSERT INTO `dungeon` VALUES ('32695', '32796', '461', '32682', '32833', '462', '2', '');
INSERT INTO `dungeon` VALUES ('32695', '32797', '461', '32682', '32833', '462', '2', '');
INSERT INTO `dungeon` VALUES ('32695', '32798', '461', '32682', '32833', '462', '2', '');
INSERT INTO `dungeon` VALUES ('32695', '32799', '461', '32682', '32833', '462', '2', '');
INSERT INTO `dungeon` VALUES ('32682', '32832', '462', '32695', '32797', '461', '6', '');
INSERT INTO `dungeon` VALUES ('32682', '32833', '462', '32695', '32797', '461', '6', '');
INSERT INTO `dungeon` VALUES ('32682', '32834', '462', '32695', '32797', '461', '6', '');
INSERT INTO `dungeon` VALUES ('32682', '32835', '462', '32695', '32797', '461', '6', '');
INSERT INTO `dungeon` VALUES ('32813', '32864', '462', '32726', '32821', '463', '2', '');
INSERT INTO `dungeon` VALUES ('32813', '32865', '462', '32726', '32821', '463', '2', '');
INSERT INTO `dungeon` VALUES ('32813', '32866', '462', '32726', '32821', '463', '2', '');
INSERT INTO `dungeon` VALUES ('32813', '32867', '462', '32726', '32821', '463', '2', '');
INSERT INTO `dungeon` VALUES ('32726', '32820', '463', '32813', '32865', '462', '6', '');
INSERT INTO `dungeon` VALUES ('32726', '32821', '463', '32813', '32865', '462', '6', '');
INSERT INTO `dungeon` VALUES ('32726', '32822', '463', '32813', '32865', '462', '6', '');
INSERT INTO `dungeon` VALUES ('32726', '32823', '463', '32813', '32865', '462', '6', '');
INSERT INTO `dungeon` VALUES ('32809', '32816', '463', '32663', '32849', '467', '4', '->2');
INSERT INTO `dungeon` VALUES ('32663', '32847', '467', '32665', '32852', '457', '4', '2->1');
INSERT INTO `dungeon` VALUES ('32664', '32847', '467', '32665', '32852', '457', '4', '2->1');
INSERT INTO `dungeon` VALUES ('32685', '32852', '467', '32723', '32797', '472', '2', '2->');
INSERT INTO `dungeon` VALUES ('32685', '32853', '467', '32723', '32797', '472', '2', '2->');
INSERT INTO `dungeon` VALUES ('32723', '32797', '472', '32685', '32852', '467', '6', '->2');
INSERT INTO `dungeon` VALUES ('32808', '32798', '472', '32780', '32873', '477', '2', '');
INSERT INTO `dungeon` VALUES ('32808', '32799', '472', '32780', '32873', '477', '2', '');
INSERT INTO `dungeon` VALUES ('32808', '32800', '472', '32780', '32873', '477', '2', '');
INSERT INTO `dungeon` VALUES ('32808', '32801', '472', '32780', '32873', '477', '2', '');
INSERT INTO `dungeon` VALUES ('32780', '32872', '477', '32808', '32799', '472', '6', '');
INSERT INTO `dungeon` VALUES ('32780', '32873', '477', '32808', '32799', '472', '6', '');
INSERT INTO `dungeon` VALUES ('32780', '32874', '477', '32808', '32799', '472', '6', '');
INSERT INTO `dungeon` VALUES ('32780', '32875', '477', '32808', '32799', '472', '6', '');
INSERT INTO `dungeon` VALUES ('32744', '32788', '477', '32756', '32878', '471', '0', '');
INSERT INTO `dungeon` VALUES ('32745', '32788', '477', '32756', '32878', '471', '0', '');
INSERT INTO `dungeon` VALUES ('32746', '32788', '477', '32756', '32878', '471', '0', '');
INSERT INTO `dungeon` VALUES ('32747', '32788', '477', '32756', '32878', '471', '0', '');
INSERT INTO `dungeon` VALUES ('32755', '32878', '471', '32745', '32788', '477', '4', '');
INSERT INTO `dungeon` VALUES ('32756', '32878', '471', '32745', '32788', '477', '4', '');
INSERT INTO `dungeon` VALUES ('32757', '32878', '471', '32745', '32788', '477', '4', '');
INSERT INTO `dungeon` VALUES ('32758', '32878', '471', '32745', '32788', '477', '4', '');
INSERT INTO `dungeon` VALUES ('32781', '32786', '471', '32719', '32799', '536', '0', '->3');
INSERT INTO `dungeon` VALUES ('32782', '32786', '471', '32719', '32799', '536', '0', '->3');
INSERT INTO `dungeon` VALUES ('32783', '32786', '471', '32719', '32799', '536', '0', '->3');
INSERT INTO `dungeon` VALUES ('32784', '32786', '471', '32719', '32799', '536', '0', '->3');
INSERT INTO `dungeon` VALUES ('32719', '32799', '536', '32663', '32850', '467', '5', '3->2');
INSERT INTO `dungeon` VALUES ('32720', '32799', '536', '32663', '32850', '467', '5', '3->2');
INSERT INTO `dungeon` VALUES ('32683', '32873', '468', '32722', '32818', '470', '2', '2->');
INSERT INTO `dungeon` VALUES ('32683', '32874', '468', '32722', '32819', '470', '2', '2->');
INSERT INTO `dungeon` VALUES ('32722', '32818', '470', '32683', '32873', '468', '6', '->2');
INSERT INTO `dungeon` VALUES ('32722', '32819', '470', '32683', '32873', '468', '6', '->2');
INSERT INTO `dungeon` VALUES ('32815', '32806', '470', '32782', '32868', '473', '0', '');
INSERT INTO `dungeon` VALUES ('32816', '32806', '470', '32782', '32868', '473', '0', '');
INSERT INTO `dungeon` VALUES ('32817', '32806', '470', '32782', '32868', '473', '0', '');
INSERT INTO `dungeon` VALUES ('32818', '32806', '470', '32782', '32868', '473', '0', '');
INSERT INTO `dungeon` VALUES ('32781', '32868', '473', '32816', '32806', '470', '6', '');
INSERT INTO `dungeon` VALUES ('32782', '32868', '473', '32816', '32806', '470', '6', '');
INSERT INTO `dungeon` VALUES ('32783', '32868', '473', '32816', '32806', '470', '6', '');
INSERT INTO `dungeon` VALUES ('32784', '32868', '473', '32816', '32806', '470', '6', '');
INSERT INTO `dungeon` VALUES ('32831', '32792', '473', '32742', '32858', '478', '0', '');
INSERT INTO `dungeon` VALUES ('32832', '32792', '473', '32742', '32858', '478', '0', '');
INSERT INTO `dungeon` VALUES ('32833', '32792', '473', '32742', '32858', '478', '0', '');
INSERT INTO `dungeon` VALUES ('32834', '32792', '473', '32742', '32858', '478', '0', '');
INSERT INTO `dungeon` VALUES ('32741', '32858', '478', '32832', '32792', '473', '6', '');
INSERT INTO `dungeon` VALUES ('32742', '32858', '478', '32832', '32792', '473', '6', '');
INSERT INTO `dungeon` VALUES ('32743', '32858', '478', '32832', '32792', '473', '6', '');
INSERT INTO `dungeon` VALUES ('32744', '32858', '478', '32832', '32792', '473', '6', '');
INSERT INTO `dungeon` VALUES ('32750', '32811', '478', '32724', '32832', '474', '2', '');
INSERT INTO `dungeon` VALUES ('32750', '32812', '478', '32724', '32832', '474', '2', '');
INSERT INTO `dungeon` VALUES ('32750', '32813', '478', '32724', '32832', '474', '2', '');
INSERT INTO `dungeon` VALUES ('32750', '32814', '478', '32724', '32832', '474', '2', '');
INSERT INTO `dungeon` VALUES ('32724', '32831', '474', '32750', '32812', '478', '6', '');
INSERT INTO `dungeon` VALUES ('32724', '32832', '474', '32750', '32812', '478', '6', '');
INSERT INTO `dungeon` VALUES ('32724', '32833', '474', '32750', '32812', '478', '6', '');
INSERT INTO `dungeon` VALUES ('32724', '32834', '474', '32750', '32812', '478', '6', '');
INSERT INTO `dungeon` VALUES ('32733', '32786', '478', '32768', '32877', '476', '0', '');
INSERT INTO `dungeon` VALUES ('32734', '32786', '478', '32768', '32877', '476', '0', '');
INSERT INTO `dungeon` VALUES ('32735', '32786', '478', '32768', '32877', '476', '0', '');
INSERT INTO `dungeon` VALUES ('32736', '32786', '478', '32768', '32877', '476', '0', '');
INSERT INTO `dungeon` VALUES ('32767', '32877', '476', '32734', '32786', '478', '4', '');
INSERT INTO `dungeon` VALUES ('32768', '32877', '476', '32734', '32786', '478', '4', '');
INSERT INTO `dungeon` VALUES ('32769', '32877', '476', '32734', '32786', '478', '4', '');
INSERT INTO `dungeon` VALUES ('32770', '32877', '476', '32734', '32786', '478', '4', '');
INSERT INTO `dungeon` VALUES ('32805', '32799', '476', '32673', '32836', '475', '2', '');
INSERT INTO `dungeon` VALUES ('32805', '32800', '476', '32673', '32836', '475', '2', '');
INSERT INTO `dungeon` VALUES ('32805', '32801', '476', '32673', '32836', '475', '2', '');
INSERT INTO `dungeon` VALUES ('32805', '32802', '476', '32673', '32836', '475', '2', '');
INSERT INTO `dungeon` VALUES ('32673', '32835', '475', '32805', '32800', '476', '6', '');
INSERT INTO `dungeon` VALUES ('32673', '32836', '475', '32805', '32800', '476', '6', '');
INSERT INTO `dungeon` VALUES ('32673', '32837', '475', '32805', '32800', '476', '6', '');
INSERT INTO `dungeon` VALUES ('32673', '32838', '475', '32805', '32800', '476', '6', '');
INSERT INTO `dungeon` VALUES ('32778', '32807', '475', '32742', '32814', '536', '0', '->3');
INSERT INTO `dungeon` VALUES ('32779', '32807', '475', '32742', '32814', '536', '0', '->3');
INSERT INTO `dungeon` VALUES ('32780', '32807', '475', '32742', '32814', '536', '0', '->3');
INSERT INTO `dungeon` VALUES ('32781', '32807', '475', '32742', '32814', '536', '0', '->3');
INSERT INTO `dungeon` VALUES ('32742', '32814', '536', '32660', '32870', '468', '5', '3->2');
INSERT INTO `dungeon` VALUES ('32743', '32814', '536', '32660', '32870', '468', '5', '3->2');
INSERT INTO `dungeon` VALUES ('32746', '32785', '536', '32740', '32880', '530', '0', '3->');
INSERT INTO `dungeon` VALUES ('32747', '32785', '536', '32741', '32880', '530', '0', '3->');
INSERT INTO `dungeon` VALUES ('32740', '32880', '530', '32746', '32785', '536', '4', '->3');
INSERT INTO `dungeon` VALUES ('32741', '32880', '530', '32746', '32785', '536', '4', '->3');
INSERT INTO `dungeon` VALUES ('32877', '32816', '530', '32727', '32744', '531', '2', '');
INSERT INTO `dungeon` VALUES ('32877', '32817', '530', '32727', '32744', '531', '2', '');
INSERT INTO `dungeon` VALUES ('32877', '32818', '530', '32727', '32744', '531', '2', '');
INSERT INTO `dungeon` VALUES ('32877', '32819', '530', '32727', '32744', '531', '2', '');
INSERT INTO `dungeon` VALUES ('32727', '32743', '531', '32877', '32817', '530', '6', '');
INSERT INTO `dungeon` VALUES ('32727', '32744', '531', '32877', '32817', '530', '6', '');
INSERT INTO `dungeon` VALUES ('32727', '32745', '531', '32877', '32817', '530', '6', '');
INSERT INTO `dungeon` VALUES ('32727', '32746', '531', '32877', '32817', '530', '6', '');
INSERT INTO `dungeon` VALUES ('32851', '32871', '531', '32843', '32792', '532', '2', '');
INSERT INTO `dungeon` VALUES ('32851', '32872', '531', '32843', '32792', '532', '2', '');
INSERT INTO `dungeon` VALUES ('32851', '32873', '531', '32843', '32792', '532', '2', '');
INSERT INTO `dungeon` VALUES ('32851', '32874', '531', '32843', '32792', '532', '2', '');
INSERT INTO `dungeon` VALUES ('32843', '32791', '532', '32851', '32872', '531', '6', '');
INSERT INTO `dungeon` VALUES ('32843', '32792', '532', '32851', '32872', '531', '6', '');
INSERT INTO `dungeon` VALUES ('32843', '32793', '532', '32851', '32872', '531', '6', '');
INSERT INTO `dungeon` VALUES ('32843', '32794', '532', '32851', '32872', '531', '6', '');
INSERT INTO `dungeon` VALUES ('32775', '32791', '532', '32868', '32943', '533', '0', '');
INSERT INTO `dungeon` VALUES ('32776', '32791', '532', '32868', '32943', '533', '0', '');
INSERT INTO `dungeon` VALUES ('32777', '32791', '532', '32868', '32943', '533', '0', '');
INSERT INTO `dungeon` VALUES ('32778', '32791', '532', '32868', '32943', '533', '0', '');
INSERT INTO `dungeon` VALUES ('32867', '32943', '533', '32776', '32791', '532', '6', '');
INSERT INTO `dungeon` VALUES ('32868', '32943', '533', '32776', '32791', '532', '6', '');
INSERT INTO `dungeon` VALUES ('32869', '32943', '533', '32776', '32791', '532', '6', '');
INSERT INTO `dungeon` VALUES ('32870', '32943', '533', '32776', '32791', '532', '6', '');
INSERT INTO `dungeon` VALUES ('32725', '32797', '533', '32732', '32876', '534', '0', '');
INSERT INTO `dungeon` VALUES ('32726', '32797', '533', '32732', '32876', '534', '0', '');
INSERT INTO `dungeon` VALUES ('32727', '32797', '533', '32732', '32876', '534', '0', '');
INSERT INTO `dungeon` VALUES ('32728', '32797', '533', '32732', '32876', '534', '0', '');
INSERT INTO `dungeon` VALUES ('32731', '32876', '534', '32726', '32797', '533', '6', '');
INSERT INTO `dungeon` VALUES ('32732', '32876', '534', '32726', '32797', '533', '6', '');
INSERT INTO `dungeon` VALUES ('32733', '32876', '534', '32726', '32797', '533', '6', '');
INSERT INTO `dungeon` VALUES ('32734', '32876', '534', '32726', '32797', '533', '6', '');
INSERT INTO `dungeon` VALUES ('32829', '33096', '550', '32855', '32802', '480', '5', '');
INSERT INTO `dungeon` VALUES ('32829', '33097', '550', '32855', '32802', '480', '5', '');
INSERT INTO `dungeon` VALUES ('32782', '32780', '550', '32727', '32824', '557', '6', 'A->A');
INSERT INTO `dungeon` VALUES ('32727', '32824', '557', '32784', '32779', '550', '2', 'A->A');
INSERT INTO `dungeon` VALUES ('32729', '32829', '557', '32781', '32799', '558', '4', 'A->A');
INSERT INTO `dungeon` VALUES ('32730', '32829', '557', '32782', '32799', '558', '4', 'A->A');
INSERT INTO `dungeon` VALUES ('32781', '32798', '558', '32729', '32828', '557', '0', 'A->A');
INSERT INTO `dungeon` VALUES ('32782', '32798', '558', '32730', '32828', '557', '0', 'A->A');
INSERT INTO `dungeon` VALUES ('32687', '32776', '550', '32736', '32873', '557', '6', 'B->B');
INSERT INTO `dungeon` VALUES ('32736', '32873', '557', '32689', '32775', '550', '2', 'B->B');
INSERT INTO `dungeon` VALUES ('32729', '32877', '557', '32943', '32804', '558', '4', 'B->B');
INSERT INTO `dungeon` VALUES ('32730', '32877', '557', '32944', '32804', '558', '4', 'B->B');
INSERT INTO `dungeon` VALUES ('32943', '32803', '558', '32729', '32876', '557', '0', 'B->B');
INSERT INTO `dungeon` VALUES ('32944', '32803', '558', '32730', '32876', '557', '0', 'B->B');
INSERT INTO `dungeon` VALUES ('32607', '32727', '550', '32757', '32794', '557', '6', 'C->C');
INSERT INTO `dungeon` VALUES ('32757', '32794', '557', '32609', '32726', '550', '2', 'C->C');
INSERT INTO `dungeon` VALUES ('32750', '32798', '557', '33027', '32953', '558', '4', 'C->C');
INSERT INTO `dungeon` VALUES ('32751', '32798', '557', '33027', '32953', '558', '4', 'C->C');
INSERT INTO `dungeon` VALUES ('33027', '32952', '558', '32750', '32797', '557', '0', 'C->C');
INSERT INTO `dungeon` VALUES ('33028', '32952', '558', '32751', '32797', '557', '0', 'C->C');
INSERT INTO `dungeon` VALUES ('32422', '32831', '550', '32759', '32845', '557', '6', 'D->D');
INSERT INTO `dungeon` VALUES ('32759', '32845', '557', '32424', '32830', '550', '2', 'D->D');
INSERT INTO `dungeon` VALUES ('32752', '32849', '557', '33172', '32977', '558', '4', 'D->D');
INSERT INTO `dungeon` VALUES ('32753', '32849', '557', '33173', '32977', '558', '4', 'D->D');
INSERT INTO `dungeon` VALUES ('33172', '32976', '558', '32752', '32848', '557', '0', 'D->D');
INSERT INTO `dungeon` VALUES ('33173', '32976', '558', '32753', '32848', '557', '0', 'D->D');
INSERT INTO `dungeon` VALUES ('32533', '32902', '550', '32782', '32820', '557', '6', 'E->E');
INSERT INTO `dungeon` VALUES ('32782', '32820', '557', '32535', '32901', '550', '2', 'E->E');
INSERT INTO `dungeon` VALUES ('32781', '32825', '557', '32865', '33045', '558', '4', 'E->E');
INSERT INTO `dungeon` VALUES ('32782', '32825', '557', '32866', '33045', '558', '4', 'E->E');
INSERT INTO `dungeon` VALUES ('32865', '33044', '558', '32781', '32824', '557', '0', 'E->E');
INSERT INTO `dungeon` VALUES ('32866', '33044', '558', '32782', '32824', '557', '0', 'E->E');
INSERT INTO `dungeon` VALUES ('32457', '33054', '550', '32785', '32873', '557', '6', 'F->F');
INSERT INTO `dungeon` VALUES ('32785', '32873', '557', '32459', '33053', '550', '2', 'F->F');
INSERT INTO `dungeon` VALUES ('32778', '32877', '557', '32816', '33181', '558', '4', 'F->F');
INSERT INTO `dungeon` VALUES ('32779', '32877', '557', '32817', '33181', '558', '4', 'F->F');
INSERT INTO `dungeon` VALUES ('32816', '33180', '558', '32778', '32876', '557', '0', 'F->F');
INSERT INTO `dungeon` VALUES ('32817', '33180', '558', '32779', '32876', '557', '0', 'F->F');
INSERT INTO `dungeon` VALUES ('32617', '33002', '550', '32808', '32791', '557', '6', 'G->G');
INSERT INTO `dungeon` VALUES ('32808', '32791', '557', '32619', '33002', '550', '2', 'G->G');
INSERT INTO `dungeon` VALUES ('32801', '32795', '557', '32958', '33184', '558', '4', 'G->G');
INSERT INTO `dungeon` VALUES ('32802', '32795', '557', '32959', '33184', '558', '4', 'G->G');
INSERT INTO `dungeon` VALUES ('32958', '33183', '558', '32801', '32794', '557', '0', 'G->G');
INSERT INTO `dungeon` VALUES ('32959', '33183', '558', '32802', '32794', '557', '0', 'G->G');
INSERT INTO `dungeon` VALUES ('32795', '33061', '550', '32807', '32843', '557', '6', 'H->H');
INSERT INTO `dungeon` VALUES ('32807', '32843', '557', '32797', '33060', '550', '2', 'H->H');
INSERT INTO `dungeon` VALUES ('32800', '32847', '557', '33120', '33203', '558', '4', 'H->H');
INSERT INTO `dungeon` VALUES ('32801', '32847', '557', '33121', '33203', '558', '4', 'H->H');
INSERT INTO `dungeon` VALUES ('33120', '33202', '558', '32800', '32846', '557', '0', 'H->H');
INSERT INTO `dungeon` VALUES ('33121', '33202', '558', '32801', '32846', '557', '0', 'H->H');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5068', '33374', '32657', '4', '0', '1->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5069', '33384', '32655', '4', '0', '2->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5070', '33395', '32656', '4', '0', '3->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5071', '33428', '32659', '4', '0', '4->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5072', '33439', '32666', '4', '0', '5->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5073', '33457', '32654', '4', '0', '6->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5074', '33477', '32668', '4', '0', '7->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5075', '33471', '32679', '4', '0', '8->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5076', '33459', '32700', '4', '0', '9->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5077', '33424', '32691', '4', '0', '10->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5078', '33409', '32675', '4', '0', '11->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5079', '33420', '32709', '4', '0', '12->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5080', '33375', '32698', '4', '0', '13->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5081', '33363', '32684', '4', '0', '14->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5082', '33360', '32670', '4', '0', '15->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5083', '33341', '32661', '4', '0', '16->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5084', '33346', '32675', '4', '0', '17->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5085', '33341', '32710', '4', '0', '18->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5086', '33355', '32734', '4', '0', '19->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5087', '33366', '32714', '4', '0', '20->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5088', '33381', '32715', '4', '0', '21->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5089', '33404', '32739', '4', '0', '22->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5090', '33424', '32718', '4', '0', '23->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5091', '33449', '32732', '4', '0', '24->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5092', '33405', '32757', '4', '0', '25->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5093', '33366', '32761', '4', '0', '26->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5094', '33351', '32775', '4', '0', '27->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5095', '33358', '32789', '4', '0', '28->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5096', '33372', '32792', '4', '0', '29->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5097', '33384', '32776', '4', '0', '30->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5098', '33403', '32794', '4', '0', '31->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5099', '33485', '32794', '4', '0', '32->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5100', '33499', '32804', '4', '0', '33->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5101', '33382', '32804', '4', '0', '34->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5102', '33376', '32828', '4', '0', '35->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5103', '33399', '32813', '4', '0', '36->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5104', '33397', '32822', '4', '0', '37->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5105', '33437', '32844', '4', '0', '38->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5106', '33459', '32840', '4', '0', '39->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5107', '33391', '32851', '4', '0', '40->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5108', '33399', '32860', '4', '0', '41->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5109', '33415', '32853', '4', '0', '42->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5110', '33375', '32873', '4', '0', '43->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5111', '33428', '32871', '4', '0', '44->1');
INSERT INTO `dungeon` VALUES ('32782', '32815', '5112', '33443', '32870', '4', '0', '45->1');
INSERT INTO `dungeon` VALUES ('32774', '32814', '5113', '33609', '33217', '4', '0', '1->1');
INSERT INTO `dungeon` VALUES ('32774', '32814', '5114', '33630', '33209', '4', '0', '2->1');
INSERT INTO `dungeon` VALUES ('32774', '32814', '5115', '33628', '33226', '4', '0', '3->1');
INSERT INTO `dungeon` VALUES ('32774', '32814', '5116', '33633', '33248', '4', '0', '4->1');
INSERT INTO `dungeon` VALUES ('32774', '32814', '5117', '33619', '33265', '4', '0', '5->1');
INSERT INTO `dungeon` VALUES ('32774', '32814', '5118', '33575', '33233', '4', '0', '6->1');
INSERT INTO `dungeon` VALUES ('32774', '32814', '5119', '33584', '33306', '4', '0', '7->1');
INSERT INTO `dungeon` VALUES ('32774', '32814', '5120', '33581', '33338', '4', '0', '8->1');
INSERT INTO `dungeon` VALUES ('32774', '32814', '5121', '33620', '33381', '4', '0', '9->1');
INSERT INTO `dungeon` VALUES ('32774', '32814', '5122', '33625', '33398', '4', '0', '10->1');
INSERT INTO `dungeon` VALUES ('32774', '32814', '5123', '33625', '33445', '4', '0', '11->1');
INSERT INTO `dungeon` VALUES ('33066', '32894', '320', '32530', '32805', '400', '2', '');
INSERT INTO `dungeon` VALUES ('33066', '32895', '320', '32530', '32805', '400', '2', '');
INSERT INTO `dungeon` VALUES ('33066', '32896', '320', '32530', '32805', '400', '2', '');
INSERT INTO `dungeon` VALUES ('33066', '32897', '320', '32530', '32805', '400', '2', '');
INSERT INTO `dungeon` VALUES ('32528', '32803', '400', '33065', '32894', '320', '6', '');
INSERT INTO `dungeon` VALUES ('32528', '32804', '400', '33065', '32894', '320', '6', '');
INSERT INTO `dungeon` VALUES ('32528', '32805', '400', '33065', '32894', '320', '6', '');
INSERT INTO `dungeon` VALUES ('32528', '32806', '400', '33065', '32894', '320', '6', '');
INSERT INTO `dungeon` VALUES ('32528', '32807', '400', '33065', '32894', '320', '6', '');
INSERT INTO `dungeon` VALUES ('32804', '32869', '401', '32705', '32637', '400', '6', '');
INSERT INTO `dungeon` VALUES ('32805', '32869', '401', '32705', '32637', '400', '6', '');
INSERT INTO `dungeon` VALUES ('32797', '32837', '401', '32828', '32792', '310', '6', '');
INSERT INTO `dungeon` VALUES ('32798', '32837', '401', '32828', '32792', '310', '6', '');

-- merge etcitem table
INSERT INTO `etcitem` VALUES ('41405', 'Compensation', '$3018', 'treasure_box', 'normal', 'wood', '0', '998', '3963', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `etcitem` VALUES ('41406', 'Money Pouch of Reona', '$3158', 'treasure_box', 'normal', 'none', '80', '958', '3963', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `etcitem` VALUES ('41407', 'Money Pouch of Reona', '$3158', 'treasure_box', 'normal', 'none', '80', '958', '3963', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `etcitem` VALUES ('41408', 'Money Pouch of Reona', '$3158', 'treasure_box', 'normal', 'none', '80', '958', '3963', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `etcitem` VALUES ('41409', 'Money Pouch of Reona', '$3158', 'treasure_box', 'normal', 'none', '80', '958', '3963', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `etcitem` VALUES ('41410', 'Money Pouch of Reona', '$3158', 'treasure_box', 'normal', 'none', '80', '958', '3963', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `etcitem` VALUES ('41416', 'Pet Match Gift Chest', '$5470', 'treasure_box', 'normal', 'leather', '14000', '2267', '3963', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '1');
update etcitem set weight = 7000, stackable = 0 where item_id in (140006, 140008, 40006, 40007, 40008, 40009);
update etcitem set invgfx = 1033, grdgfx = 47 where item_id = 40026;
update etcitem set invgfx = 1034, grdgfx = 47 where item_id = 40027;
update etcitem set invgfx = 1032, grdgfx = 47 where item_id = 40028;
update etcitem set item_type = 'other' where item_id = 40003;
update etcitem set grdgfx = 4324 where item_id = 40042;
update etcitem set grdgfx = 3176 where item_id = 40057;
update etcitem set grdgfx = 2058 where item_id = 40063;
update etcitem set item_type = 'material' where item_id = 40169;
update etcitem set weight = 2000 where item_id = 40318;
update etcitem set use_type = 'spell_long' where item_id = 40410;
update etcitem set name = 'Money Pouch of Reona', item_type = 'treasure_box' where item_id = 40632;
update etcitem set item_type = 'treasure_box' where item_id in (40687, 41001);
update etcitem set name_id = '$3992' where item_id = 40696;
update etcitem set name_id = '$3978' where item_id = 40697;
update etcitem set grdgfx = 5429 where item_id = 40977;

-- merge npc table
INSERT INTO `npc` VALUES ('45955', 'Supreme Court Justice Kenya', '$4300', '', 'L1Monster', '5373', '62', '13500', '500', '-65', '15', '18', '20', '14', '16', '60', '3845', '-25', 'large', '0', '0', '0', '0', '2', '0', '960', '1240', '1400', '0', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '5000', '50', '5000', '30', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '1', 0);
INSERT INTO `npc` VALUES ('45956', 'Supreme Court Justice Viatas', '$4302', '', 'L1Monster', '5365', '68', '15500', '500', '-69', '19', '18', '17', '13', '12', '50', '4625', '-25', 'large', '0', '0', '0', '0', '2', '0', '960', '1400', '1600', '0', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '5000', '70', '5000', '50', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '1', 0);
INSERT INTO `npc` VALUES ('45957', 'Supreme Court Justice Baromes', '$4297', '', 'L1Monster', '5478', '70', '16664', '700', '-71', '18', '18', '19', '20', '20', '68', '4901', '-25', 'large', '0', '0', '0', '0', '1', '0', '640', '1000', '1520', '0', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '5000', '70', '5000', '50', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '1', 0);
INSERT INTO `npc` VALUES ('45958', 'Supreme Court Justice Endias', '$4303', '', 'L1Monster', '5293', '73', '18688', '700', '-78', '17', '18', '20', '16', '17', '70', '5330', '-25', 'large', '0', '0', '1', '0', '8', '0', '1040', '1240', '1560', '0', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '5000', '70', '5000', '50', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '1', 0);
INSERT INTO `npc` VALUES ('45959', 'Supreme Court Justice Edea', '$4299', '', 'L1Monster', '5297', '64', '14788', '500', '-68', '15', '18', '18', '15', '16', '60', '4097', '-25', 'large', '0', '0', '0', '0', '2', '0', '720', '1320', '1680', '0', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '5000', '50', '5000', '50', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '1', 0);
INSERT INTO `npc` VALUES ('45960', 'Supreme Court Justice Tiames', '$4301', '', 'L1Monster', '5274', '72', '18144', '500', '-75', '18', '18', '19', '20', '20', '71', '5185', '-25', 'large', '0', '0', '1', '0', '1', '0', '640', '1200', '1280', '1680', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '5000', '100', '5000', '50', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '1', 0);
INSERT INTO `npc` VALUES ('45961', 'Supreme Court Justice Ramias', '$4298', '', 'L1Monster', '5284', '74', '18652', '350', '-78', '21', '20', '16', '12', '13', '65', '5477', '-25', 'large', '0', '0', '1', '0', '1', '0', '1040', '1200', '1600', '2120', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '5000', '100', '5000', '50', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '1', 0);
INSERT INTO `npc` VALUES ('45962', 'Supreme Court Justice Barode', '$4296', '', 'L1Monster', '5471', '77', '19688', '500', '-78', '20', '18', '17', '15', '16', '80', '5930', '-25', 'large', '0', '0', '0', '0', '1', '0', '800', '720', '920', '1200', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '5000', '100', '5000', '50', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '1', 0);
INSERT INTO `npc` VALUES ('45963', 'New King Adjutant Cassandra', '$4465', '', 'L1Monster', '4855', '67', '16000', '700', '-68', '16', '15', '17', '15', '18', '60', '4490', '-25', 'small', '0', '0', '0', '0', '1', '0', '960', '0', '1080', '1520', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '1', 0);
INSERT INTO `npc` VALUES ('45964', 'Cursed Dark Elf Warrior', '$4285', '', 'L1Monster', '5778', '46', '500', '300', '-40', '17', '16', '20', '15', '15', '45', '2117', '-50', 'small', '0', '0', '0', '0', '1', '0', '960', '1040', '1440', '1280', '0', '0', '0', '1', '1', '1', 'darkelf', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45965', 'Cursed Dark Elf Warrior', '$4285', '', 'L1Monster', '5754', '46', '500', '300', '-40', '17', '16', '20', '15', '17', '45', '2117', '-50', 'small', '0', '0', '0', '0', '1', '0', '960', '1040', '1440', '1280', '0', '0', '0', '1', '1', '1', 'darkelf', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45966', 'Cursed Dark Elf Warrior', '$4285', '', 'L1Monster', '5781', '47', '600', '300', '-40', '19', '17', '16', '15', '15', '45', '2210', '-50', 'small', '0', '0', '0', '0', '1', '0', '960', '1040', '1440', '1280', '0', '0', '0', '1', '1', '1', 'darkelf', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45967', 'Cursed Dark Elf Warrior', '$4285', '', 'L1Monster', '5751', '48', '600', '300', '-40', '17', '15', '20', '17', '17', '45', '2305', '-50', 'small', '0', '0', '0', '0', '1', '0', '960', '1040', '1440', '1280', '0', '0', '0', '1', '1', '1', 'darkelf', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45968', 'Cursed Dark Elf Warrior', '$4285', '', 'L1Monster', '5778', '48', '820', '300', '-40', '15', '15', '20', '17', '17', '45', '2305', '-50', 'small', '0', '0', '0', '0', '1', '0', '960', '1040', '1440', '1280', '0', '0', '0', '1', '1', '1', 'darkelf', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45969', 'Cursed Dark Elf Wizard', '$4287', '', 'L1Monster', '5760', '48', '500', '300', '-38', '16', '15', '18', '16', '18', '70', '2305', '-50', 'small', '0', '0', '0', '0', '1', '0', '960', '1160', '1200', '1160', '0', '0', '0', '1', '1', '1', 'darkelf', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45970', 'Cursed Dark Elf Wizard', '$4287', '', 'L1Monster', '5760', '49', '550', '300', '-38', '16', '15', '18', '16', '18', '70', '2402', '-50', 'small', '0', '0', '0', '0', '1', '0', '960', '1160', '1200', '1160', '0', '0', '0', '1', '1', '1', 'darkelf', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45971', 'Cursed Dark Elf Wizard', '$4287', '', 'L1Monster', '5760', '50', '750', '300', '-38', '16', '15', '18', '16', '18', '80', '2501', '-50', 'small', '0', '0', '0', '0', '1', '0', '960', '1160', '1200', '1160', '0', '0', '0', '1', '1', '1', 'darkelf', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45972', 'Cursed Dark Elf Knight', '$4286', '', 'L1Monster', '5745', '50', '700', '300', '-42', '18', '19', '15', '15', '15', '60', '2501', '-50', 'small', '0', '0', '0', '0', '1', '0', '960', '1200', '1440', '1560', '0', '0', '0', '1', '1', '1', 'darkelf', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45973', 'Cursed Dark Elf Knight', '$4286', '', 'L1Monster', '5742', '50', '700', '300', '-42', '18', '19', '15', '15', '15', '60', '2501', '-50', 'small', '0', '0', '0', '0', '1', '0', '960', '1200', '1440', '1560', '0', '0', '0', '1', '1', '1', 'darkelf', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45974', 'Cursed Dark Elf Knight', '$4286', '', 'L1Monster', '5742', '52', '850', '300', '-50', '20', '15', '18', '15', '15', '50', '2705', '-50', 'small', '0', '0', '0', '0', '1', '0', '960', '1200', '1440', '1560', '0', '0', '0', '1', '1', '1', 'darkelf', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45975', 'Cursed Dark Elf Knight', '$4286', '', 'L1Monster', '5724', '54', '850', '300', '-52', '18', '15', '20', '17', '17', '50', '2917', '-50', 'small', '0', '0', '0', '0', '1', '0', '960', '1200', '1440', '1560', '0', '0', '0', '1', '1', '1', 'darkelf', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45976', 'Lastabad Royal Guard', '$4383', '', 'L1Monster', '3402', '45', '300', '50', '-30', '14', '14', '19', '5', '10', '20', '2026', '-20', 'small', '0', '0', '0', '0', '10', '0', '1280', '1360', '1360', '1360', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '66', '0', '45964', '5306', '0', '0', 0);
INSERT INTO `npc` VALUES ('45977', 'Lastabad Royal Guard', '$4383', '', 'L1Monster', '3404', '45', '400', '50', '-40', '20', '18', '11', '5', '10', '30', '2026', '-20', 'small', '0', '0', '0', '0', '2', '0', '853', '960', '960', '960', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '45966', '5306', '0', '0', 0);
INSERT INTO `npc` VALUES ('45978', 'Deep Flower', '$3148', '', 'L1Monster', '3568', '45', '1300', '500', '-40', '18', '16', '15', '18', '12', '50', '2026', '-20', 'large', '0', '0', '1', '0', '1', '0', '0', '1280', '2560', '2560', '0', '0', '0', '1', '1', '1', 'bombflower', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45979', 'Dark Elemental', '$2895', '', 'L1Monster', '3364', '46', '800', '100', '-42', '20', '18', '16', '12', '16', '35', '2117', '-20', 'small', '0', '0', '0', '0', '1', '0', '960', '1240', '1240', '1240', '0', '0', '0', '1', '1', '1', 'elemental', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45980', 'Lastabad Tormenter', '$3808', '', 'L1Monster', '3694', '47', '400', '50', '-40', '19', '16', '15', '14', '15', '60', '2210', '-30', 'small', '0', '0', '0', '0', '2', '0', '1280', '1560', '1560', '1560', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '45965', '5306', '0', '0', 0);
INSERT INTO `npc` VALUES ('45981', 'Dark Mage', '$3824', '', 'L1Monster', '3698', '47', '400', '148', '-36', '16', '15', '18', '16', '18', '60', '2210', '-25', 'small', '0', '0', '0', '0', '1', '0', '1280', '1280', '1160', '1160', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '45969', '5306', '0', '0', 0);
INSERT INTO `npc` VALUES ('45982', 'Dark Forester', '$3823', '', 'L1Monster', '3747', '47', '400', '300', '-40', '15', '16', '14', '16', '18', '60', '2210', '-25', 'small', '0', '0', '0', '1', '2', '0', '853', '1720', '2200', '2200', '0', '0', '0', '1', '1', '1', 'darkforester', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '45967', '5306', '0', '0', 0);
INSERT INTO `npc` VALUES ('45983', 'Guardian of Earth Spirit', '$3820', '', 'L1Monster', '4634', '47', '900', '10', '-45', '19', '20', '15', '10', '10', '60', '2210', '-25', 'small', '0', '0', '1', '0', '1', '0', '960', '1280', '1400', '1200', '0', '0', '0', '1', '1', '1', 'spirit', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45984', 'Guardian of Water Spirit', '$3818', '', 'L1Monster', '4632', '47', '900', '10', '-45', '19', '20', '15', '10', '10', '60', '2210', '-25', 'small', '0', '1', '0', '0', '1', '0', '960', '1280', '1400', '1200', '0', '0', '0', '1', '1', '1', 'spirit', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45985', 'Guardian of Fire Spirit', '$3819', '', 'L1Monster', '4633', '47', '900', '10', '-45', '19', '20', '15', '10', '10', '60', '2210', '-25', 'small', '1', '0', '0', '0', '1', '0', '960', '1280', '1400', '1200', '0', '0', '0', '1', '1', '1', 'spirit', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45986', 'Guardian of Wind Spirit', '$3821', '', 'L1Monster', '4786', '47', '900', '10', '-37', '19', '20', '15', '10', '10', '60', '2210', '-25', 'small', '0', '0', '0', '1', '1', '0', '960', '1280', '1520', '1200', '0', '0', '0', '1', '1', '1', 'spirit', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45987', 'Guardian of Darkness Spirit', '$3822', '', 'L1Monster', '4787', '47', '900', '364', '-37', '19', '20', '15', '10', '15', '60', '2210', '-25', 'small', '0', '0', '1', '0', '1', '0', '960', '1280', '1400', '1200', '0', '0', '0', '1', '1', '1', 'spirit', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45988', 'Greater Dark Elemental', '$2896', '', 'L1Monster', '3365', '47', '900', '100', '-45', '20', '16', '18', '10', '12', '40', '2210', '-25', 'small', '0', '0', '0', '0', '1', '0', '960', '1400', '1400', '1400', '0', '0', '0', '1', '1', '1', 'elemental', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45989', 'Black Ent', '$3143', '', 'L1Monster', '3678', '47', '1500', '50', '-42', '20', '18', '16', '18', '16', '20', '2210', '-25', 'large', '0', '0', '1', '0', '2', '0', '960', '1960', '1960', '1960', '0', '0', '0', '1', '1', '1', 'ent', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45990', 'Lastabad Royal Guard', '$4383', '', 'L1Monster', '3402', '48', '500', '50', '-40', '14', '14', '18', '5', '10', '30', '2305', '-20', 'small', '0', '0', '0', '0', '10', '0', '1280', '1360', '1360', '1360', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '66', '0', '45968', '5306', '0', '0', 0);
INSERT INTO `npc` VALUES ('45991', 'Dark Elementalist', '$2894', '', 'L1Monster', '3360', '48', '500', '100', '-40', '16', '15', '17', '18', '18', '50', '2305', '-25', 'small', '0', '0', '0', '0', '1', '0', '1280', '1520', '2240', '2240', '0', '0', '0', '1', '1', '1', 'elemental', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '45971', '5306', '0', '0', 0);
INSERT INTO `npc` VALUES ('45992', 'Lastabad Royal Guard', '$4383', '', 'L1Monster', '3366', '48', '600', '50', '-50', '20', '18', '15', '17', '17', '45', '2305', '-25', 'small', '0', '0', '0', '0', '1', '0', '360', '1000', '1000', '1000', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '45972', '5306', '0', '0', 0);
INSERT INTO `npc` VALUES ('45993', 'Dark Elementalist', '$3824', '', 'L1Monster', '3698', '49', '500', '148', '-36', '16', '15', '18', '16', '18', '70', '2402', '-50', 'small', '0', '0', '0', '0', '1', '0', '1280', '1280', '1160', '1160', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '45971', '5306', '0', '0', 0);
INSERT INTO `npc` VALUES ('45994', 'Elder Attendant', '$4304', '', 'L1Monster', '5567', '49', '1000', '500', '-40', '15', '16', '18', '17', '19', '60', '2402', '-25', 'small', '0', '0', '1', '0', '1', '0', '960', '0', '1280', '1280', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45995', 'Elder Attendant', '$4304', '', 'L1Monster', '4667', '49', '1000', '500', '-40', '15', '16', '18', '17', '19', '60', '2402', '-25', 'small', '0', '0', '1', '0', '1', '0', '960', '0', '1080', '1520', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45996', 'Dark Mage', '$3824', '', 'L1Monster', '3698', '50', '430', '148', '-40', '16', '15', '18', '16', '18', '70', '2501', '-50', 'small', '0', '0', '0', '0', '1', '0', '1280', '1280', '1160', '1160', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '45970', '5306', '0', '0', 0);
INSERT INTO `npc` VALUES ('45997', 'Lastabad Royal Guard', '$4383', '', 'L1Monster', '4609', '50', '600', '278', '-50', '19', '18', '18', '12', '14', '50', '2501', '-25', 'small', '0', '0', '0', '0', '1', '0', '640', '1200', '1560', '1560', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '45973', '5306', '0', '0', 0);
INSERT INTO `npc` VALUES ('45998', 'Elder Attendant', '$4304', '', 'L1Monster', '5567', '50', '1000', '500', '-40', '15', '18', '20', '17', '19', '60', '2501', '-25', 'small', '0', '0', '1', '0', '1', '0', '960', '0', '1280', '1280', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('45999', 'Elder Attendant', '$4304', '', 'L1Monster', '4667', '50', '1200', '500', '-49', '15', '16', '12', '18', '20', '60', '2501', '-25', 'small', '0', '0', '1', '0', '1', '0', '960', '0', '1080', '1520', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('46000', 'Spiritologist of Blood', '$3832', '', 'L1Monster', '4670', '50', '1300', '318', '-54', '16', '15', '14', '15', '20', '70', '2501', '-25', 'small', '0', '0', '1', '0', '1', '0', '640', '1080', '1440', '1440', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '5000', '45', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('46001', 'Darkness Avenger', '$3828', '', 'L1Monster', '4603', '50', '1600', '100', '-52', '20', '18', '15', '13', '16', '55', '2501', '-25', 'small', '0', '0', '1', '0', '1', '0', '960', '1120', '1120', '1120', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('46002', 'Elder Attendant', '$4304', '', 'L1Monster', '5567', '51', '1200', '600', '-40', '15', '18', '19', '16', '18', '60', '2602', '-50', 'small', '0', '0', '0', '0', '1', '0', '960', '0', '1280', '1280', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('46003', 'Elder Attendant', '$4304', '', 'L1Monster', '4667', '51', '1300', '500', '-47', '14', '18', '17', '16', '18', '68', '2602', '-25', 'small', '0', '0', '1', '0', '1', '0', '960', '0', '1080', '1520', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('46004', 'Elder Attendant', '$4304', '', 'L1Monster', '4667', '51', '1500', '300', '-49', '15', '16', '12', '18', '20', '60', '2602', '-25', 'small', '0', '0', '1', '0', '1', '0', '960', '0', '1080', '1520', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('46005', 'Lastabad Royal Guard', '$4383', '', 'L1Monster', '4609', '52', '600', '278', '-50', '20', '18', '17', '12', '14', '50', '2705', '-50', 'small', '0', '0', '0', '0', '1', '0', '640', '1200', '1560', '1560', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '45974', '5306', '0', '0', 0);
INSERT INTO `npc` VALUES ('46006', 'Phantom Knight', '$3814', '', 'L1Monster', '4664', '52', '1300', '278', '-50', '19', '15', '16', '16', '16', '50', '2705', '-50', 'small', '0', '0', '0', '0', '2', '0', '640', '1160', '1160', '1160', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('46007', 'Elder Attendant', '$4304', '', 'L1Monster', '4667', '52', '1500', '700', '-49', '17', '18', '15', '19', '19', '50', '2705', '-25', 'small', '0', '0', '1', '0', '1', '0', '960', '0', '1080', '1520', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('46008', 'Lord of Darkness', '$3833', '', 'L1Monster', '4657', '52', '1500', '1200', '-55', '16', '17', '14', '14', '18', '75', '2705', '-25', 'small', '0', '0', '1', '0', '1', '0', '640', '1080', '1440', '1440', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('46009', 'Blood Rain Knight', '$3829', '', 'L1Monster', '4615', '52', '1800', '318', '-55', '20', '18', '16', '12', '15', '65', '2705', '-25', 'small', '0', '0', '1', '0', '1', '0', '960', '1200', '1200', '1200', '1', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('46010', 'Darkness Avenger', '$3828', '', 'L1Monster', '4603', '53', '1500', '50', '-52', '17', '18', '15', '13', '16', '55', '2810', '-50', 'small', '0', '0', '1', '0', '1', '0', '960', '1120', '1120', '1120', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '5000', '25', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('46011', 'Assassin of Blood', '$3801', '', 'L1Monster', '5596', '54', '600', '278', '-54', '18', '19', '15', '15', '15', '60', '2917', '-50', 'small', '0', '0', '1', '0', '10', '0', '640', '840', '1080', '1080', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '2989', '0', '45975', '5306', '0', '0', 0);
INSERT INTO `npc` VALUES ('46012', 'Blood Rain Knight', '$3829', '', 'L1Monster', '4615', '54', '1500', '318', '-55', '20', '18', '16', '12', '15', '65', '2917', '-50', 'small', '0', '0', '1', '0', '1', '0', '960', '1200', '1200', '1200', '1', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('46013', 'Royal Guard Head Shaibbulit', '$4382', '', 'L1Monster', '4618', '54', '3500', '630', '-63', '20', '16', '18', '12', '16', '60', '2917', '-25', 'small', '1', '0', '0', '0', '1', '0', '640', '1280', '1160', '1160', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('46014', 'Lastabad Royal Guard', '$4383', '', 'L1Monster', '4625', '55', '3500', '722', '-64', '20', '19', '19', '16', '17', '70', '3026', '-25', 'small', '0', '0', '1', '0', '1', '0', '960', '760', '1320', '1320', '0', '0', '0', '1', '1', '1', 'lastabad', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '0', '-1', '0', '0', '0', 0);
INSERT INTO `npc` VALUES ('81182', '', '', '', 'L1Effect', '4185', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', 0);

update npc set name = 'Michelle' where npcid = 50626;
update npc set name = 'Foby' where npcid = 50627;
update npc set name = 'Elisha' where npcid = 50628;
update npc set name = 'Dorothy' where npcid = 50629;
update npc set name = 'Natasha' where npcid = 50630;
update npc set name = 'Minoel' where npcid = 50631;

-- merge npcaction table
INSERT INTO `npcaction` VALUES ('50626', 'agit', 'agit', 'agtel0', '');
INSERT INTO `npcaction` VALUES ('50627', 'agit', 'agit', 'agtel0', '');
INSERT INTO `npcaction` VALUES ('50628', 'agit', 'agit', 'agtel0', '');
INSERT INTO `npcaction` VALUES ('50629', 'agit', 'agit', 'agtel0', '');
INSERT INTO `npcaction` VALUES ('50630', 'agit', 'agit', 'agtel0', '');
INSERT INTO `npcaction` VALUES ('50631', 'agit', 'agit', 'agtel0', '');
INSERT INTO `npcaction` VALUES ('70660', 'gdummyc1', 'gdummyc1', '', '');
INSERT INTO `npcaction` VALUES ('70661', 'gdummy1', 'gdummy1', '', '');



