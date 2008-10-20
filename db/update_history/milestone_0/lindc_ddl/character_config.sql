#----------------------------
# Table structure for character_config
#----------------------------
CREATE TABLE `character_config` (
  `object_id` int(10) NOT NULL DEFAULT '0',
  `length` int(10) unsigned NOT NULL default '0',
  `data` BLOB,
  PRIMARY KEY (`object_id`)
) ENGINE=MyISAM DEFAULT CHARSET=sjis;

#----------------------------
# No records for table character_config
#----------------------------
