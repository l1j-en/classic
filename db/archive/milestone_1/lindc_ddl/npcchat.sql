-- update 30

-- add new npcchat table
#----------------------------
# Table structure for npcchat
#----------------------------
CREATE TABLE `npcchat` (
  `npc_id` int(10) unsigned NOT NULL default '0',
  `chat_timing` tinyint(1) unsigned NOT NULL default '0',
  `note` varchar(45) NOT NULL default '',
  `start_delay_time` int(10) NOT NULL default '0',
  `chat_id1` varchar(45) NOT NULL default '',
  `chat_id2` varchar(45) NOT NULL default '',
  `chat_id3` varchar(45) NOT NULL default '',
  `chat_id4` varchar(45) NOT NULL default '',
  `chat_id5` varchar(45) NOT NULL default '',
  `chat_interval` int(10) unsigned NOT NULL default '0',
  `is_shout` tinyint(1) unsigned NOT NULL default '0',
  `is_repeat` tinyint(1) unsigned NOT NULL default '0',
  `repeat_interval` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`npc_id`,`chat_timing`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `npcchat` VALUES
(45473, 0, 'Baltuzar', 0, '$339', '', '', '', '', 0, 1, 1, 20000),
(45488, 0, 'Caspa', 5000, '$340', '', '', '', '', 0, 1, 1, 20000),
(45497, 0, 'Merkyor', 10000, '$341', '', '', '', '', 0, 1, 1, 20000),
(45464, 0, 'Sema', 15000, '$342', '', '', '', '', 0, 1, 1, 20000),
(45545, 0, 'Dark Elder', 0, '$993', '', '', '', '', 0, 1, 1, 10000),
(45545, 1, 'Dark Elder', 0, '$995', '', '', '', '', 0, 1, 0, 0),
(45600, 0, 'Kurtz', 0, '$275', '$279', '$281', '$285', '$287', 5000, 0, 0, 0),
(45600, 1, 'Kurtz', 0, '$302', '', '', '', '', 0, 1, 0, 0),
(45264, 2, 'Harpy', 0, '$994', '', '', '', '', 0, 0, 0, 0);