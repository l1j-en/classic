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

INSERT INTO `commands` (`name`,`access_level`,`class_name`,`help_text`,`run_on_login`) VALUES('castleowner', 200, 'L1CastleOwner', 'Sets or displays the owner of a specific castle.', 0);

-- Update range on fantasm and set probability value and dice to 0 since the probability is now hard-coded to 30%
-- http://lineage.power.plaync.com/wiki/%ED%8C%90%ED%83%80%EC%A6%98
UPDATE `skills` SET `ranged` = 4, `probability_value` = 0, `probability_dice` = 0 WHERE `name` = 'Phantasm'; 

-- lowered the leverage of high raccoon and raccoon so slow won't land all the time. The leverage was 3x that of a mage.
UPDATE `mobskill` SET `Leverage` = 5 WHERE `Skill_Description` LIKE '%Slow%' AND `mobname` IN('Raccoon', 'High Raccoon');

-- add .wipeout GM Command
INSERT INTO commands (name, access_level, class_name, help_text, run_on_login) VALUES('wipeout', 200, 'L1WipeOut', 'Kills all mobs (or players if specified) on the current screen.', 0);

-- make bapho staff untradeable.  this is how the client prefers it.  Comment out if zelgo doesn't want it
UPDATE weapon SET trade = 1 WHERE item_id = 124;

-- give area of silence and wind shackle level based modifiers and lower aos base chance
-- aos
UPDATE skills SET probability_value = 50, probability_dice = 10 WHERE skill_id = 161;
-- shackle
UPDATE skills SET probability_dice = 20 WHERE skill_id = 167; 

-- remove adena drops from TOI, as discussed in gm room
delete from droplist where mobId in (select npc_templateid from spawnlist where mapid in (select mapid from mapids where locationname like "%insolence%f%")) and itemId = 40308;
-- lower drop rate of n-scrolls on bugbears, as discussed in gm room
update droplist set chance = chance * .5  where mobId in (select npc_templateid from spawnlist where mapid = 28) AND itemid in (40074,40087);

-- make polluted human drops stackable
UPDATE `etcitem` SET `stackable` = '1' WHERE `etcitem`.`item_id` = 41074;
UPDATE `etcitem` SET `stackable` = '1' WHERE `etcitem`.`item_id` = 41073;
UPDATE `etcitem` SET `stackable` = '1' WHERE `etcitem`.`item_id` = 41072;
UPDATE `etcitem` SET `stackable` = '1' WHERE `etcitem`.`item_id` = 41071;