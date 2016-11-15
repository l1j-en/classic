-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.
INSERT INTO commands (name, access_level, class_name, help_text, run_on_login) VALUES('createpet', 200, 'L1CreatePet', 'Lets to create a pet with a level of your choice', 0);

-- add back the lancemaster polymorph!
insert into polymorphs values (7332,'spearm 52',7332,52,1080,4095,1,7);
insert into polymorphs values (7338,'spearm 55',7338,55,1080,4095,1,7);
insert into polymorphs values (7339,'spearm 60',7339,60,1080,4095,1,7);
insert into polymorphs values (7340,'spearm 65',7340,65,1080,4095,1,7);
insert into polymorphs values (7341,'spearm 70',7341,70,1080,4095,1,7);

CREATE TABLE `log_jail` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `jailed_char_name` varchar(50) NOT NULL,
  `jailer` varchar(50) NOT NULL,
  `message` varchar(100) NOT NULL,
  `unjail` timestamp NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- make noob TOS return you to oren, instead of outside ivory tower
UPDATE getback SET getback_x1 = 34057, getback_y1 = 32269, getback_x2 = 34047, getback_y2 = 32242, getback_x3 = 34080, getback_y3 = 32251 WHERE area_mapid = 521;

-- Add the giveitem log table
CREATE TABLE `LogGiveItem` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `NpcId` int(11) DEFAULT NULL,
  `NpcName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `PlayerBeforeInv` int(11) DEFAULT NULL,
  `PlayerAfterInv` int(11) DEFAULT NULL,
  `TargetBeforeInv` int(11) DEFAULT NULL,
  `TargetAfterInv` int(11) DEFAULT NULL,
  `Count` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- DK Skill fixes
UPDATE `skills` SET `buffDuration` = 60 WHERE name in ('GuardBreak', 'HorrorOfDeath');