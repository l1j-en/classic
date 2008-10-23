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