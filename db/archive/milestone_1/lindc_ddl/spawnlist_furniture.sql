-- update 30

-- create spawnlist_furniture

CREATE TABLE `spawnlist_furniture` (
  `item_obj_id` int(10) unsigned NOT NULL default '0',
  `npcid` int(10) unsigned NOT NULL default '0',
  `locx` int(10) NOT NULL default '0',
  `locy` int(10) NOT NULL default '0',
  `mapid` int(10) NOT NULL default '0',
  PRIMARY KEY  (`item_obj_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;