-- update 67

-- make Firey sword of death knight unbreakable
UPDATE weapon SET canbedmg = 0 WHERE item_id = 58;

-- make 30 DE quest mobs agro
UPDATE npc SET agro = 1, agrososc = 1, agrocoi = 1, atkspeed = 960, ranged = 1 WHERE npcid > 45882 and npcid < 45890;

-- add start siege command
INSERT INTO `commands` VALUES ('siege', '200', 'L1WarStart');

-- ----------------------------

-- Table structure for checkwartime

-- ----------------------------

DROP TABLE IF EXISTS `checkwartime`;
CREATE TABLE `checkwartime` (

  `castle_id` int(12) NOT NULL auto_increment,

  `name` varchar(45) default NULL,

  `isActive` int(1) NOT NULL default '1',

  PRIMARY KEY  (`castle_id`)

) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;



INSERT INTO `checkwartime` VALUES ('1', 'Kent Castle', '0');

INSERT INTO `checkwartime` VALUES ('2', 'Orc Castle', '0');

INSERT INTO `checkwartime` VALUES ('3', 'Windawood Castle', '0');

INSERT INTO `checkwartime` VALUES ('4', 'Giran Castle', '0');

INSERT INTO `checkwartime` VALUES ('5', 'Heine Castle', '0');

INSERT INTO `checkwartime` VALUES ('6', 'Dwarf Castle', '0');

INSERT INTO `checkwartime` VALUES ('7', 'Aden Castle', '0');

INSERT INTO `checkwartime` VALUES ('8', 'Diad Fortress', '0');
