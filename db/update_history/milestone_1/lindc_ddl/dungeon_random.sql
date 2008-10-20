-- update 30

-- create new table dungeon_random
#----------------------------
# Table structure for dungeon_random
#----------------------------
CREATE TABLE `dungeon_random` (
  `src_x` int(10) NOT NULL default '0',
  `src_y` int(10) NOT NULL default '0',
  `src_mapid` int(10) NOT NULL default '0',
  `new_x1` int(10) NOT NULL default '0',
  `new_y1` int(10) NOT NULL default '0',
  `new_mapid1` int(10) NOT NULL default '0',
  `new_x2` int(10) NOT NULL default '0',
  `new_y2` int(10) NOT NULL default '0',
  `new_mapid2` int(10) NOT NULL default '0',
  `new_x3` int(10) NOT NULL default '0',
  `new_y3` int(10) NOT NULL default '0',
  `new_mapid3` int(10) NOT NULL default '0',
  `new_x4` int(10) NOT NULL default '0',
  `new_y4` int(10) NOT NULL default '0',
  `new_mapid4` int(10) NOT NULL default '0',
  `new_x5` int(10) NOT NULL default '0',
  `new_y5` int(10) NOT NULL default '0',
  `new_mapid5` int(10) NOT NULL default '0',
  `new_heading` int(10) NOT NULL default '1',
  `note` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`src_x`,`src_y`,`src_mapid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='MyISAM free: 8192 kB';
#----------------------------
# Records for table dungeon_random
#----------------------------


INSERT INTO `dungeon_random` VALUES
(32770, 32788, 5140, 32774, 32797, 5140, 32773, 32817, 5140, 32784, 32831, 5140, 32776, 32857, 5140, 32783, 32874, 5140, 2, ''),
(32770, 32807, 5140, 32774, 32797, 5140, 32773, 32817, 5140, 32784, 32831, 5140, 32776, 32857, 5140, 32783, 32874, 5140, 2, ''),
(32774, 32830, 5140, 32774, 32797, 5140, 32773, 32817, 5140, 32784, 32831, 5140, 32776, 32857, 5140, 32783, 32874, 5140, 2, ''),
(32772, 32846, 5140, 32774, 32797, 5140, 32773, 32817, 5140, 32784, 32831, 5140, 32776, 32857, 5140, 32783, 32874, 5140, 2, ''),
(32769, 32869, 5140, 32774, 32797, 5140, 32773, 32817, 5140, 32784, 32831, 5140, 32776, 32857, 5140, 32783, 32874, 5140, 2, ''),
(32824, 32796, 5140, 32835, 32788, 5140, 32834, 32807, 5140, 32827, 32828, 5140, 32823, 32849, 5140, 32828, 32875, 5140, 2, ''),
(32821, 32819, 5140, 32835, 32788, 5140, 32834, 32807, 5140, 32827, 32828, 5140, 32823, 32849, 5140, 32828, 32875, 5140, 2, ''),
(32822, 32840, 5140, 32835, 32788, 5140, 32834, 32807, 5140, 32827, 32828, 5140, 32823, 32849, 5140, 32828, 32875, 5140, 2, ''),
(32816, 32859, 5140, 32835, 32788, 5140, 32834, 32807, 5140, 32827, 32828, 5140, 32823, 32849, 5140, 32828, 32875, 5140, 2, ''),
(32815, 32873, 5140, 32835, 32788, 5140, 32834, 32807, 5140, 32827, 32828, 5140, 32823, 32849, 5140, 32828, 32875, 5140, 2, '');
