-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- Add the door graphics for the TI Cave 2f doors
INSERT INTO door_gfxs (gfxid,note,direction,left_edge_offset,right_edge_offset) VALUES
(88,'TICaves Doors',0,0,0),
(89,'TICaves Doors',1,0,0);

-- Add the actual doors to the game for TI Caves 2f. 6006 and 6007 are the golden/pale silver key doors
INSERT INTO spawnlist_door (id,mapid,location,gfxid,locx,locy,hp,keeper) VALUES
(6001,2,'TI Caves 2f',92,32664,32807,0,0),
(6002,2,'TI Caves 2f',93,32673,32820,0,0),
(6003,2,'TI Caves 2f',92,32668,32833,0,0),
(6004,2,'TI Caves 2f',88,32661,32823,0,0),
(6005,2,'TI Caves 2f',89,32672,32858,0,0),
(6008,2,'TI Caves 2f',89,32678,32877,0,0),
(6009,2,'TI Caves 2f',89,32732,32872,0,0),
(6010,2,'TI Caves 2f',89,32736,32872,0,0),
(6011,2,'TI Caves 2f',89,32740,32872,0,0),
(6012,2,'TI Caves 2f',89,32795,32870,0,0),
(6013,2,'TI Caves 2f',88,32803,32862,0,0),
(6014,2,'TI Caves 2f',89,32806,32824,0,0),
(6015,2,'TI Caves 2f',88,32803,32832,0,0),
(6016,2,'TI Caves 2f',92,32798,32844,0,0),
(6017,2,'TI Caves 2f',93,32759,32847,0,0),
(6018,2,'TI Caves 2f',88,32808,32792,0,0),
(6019,2,'TI Caves 2f',93,32776,32806,0,0),
(6020,2,'TI Caves 2f',93,32775,32818,0,0),
(6021,2,'TI Caves 2f',88,32741,32804,0,0),
(6022,2,'TI Caves 2f',89,32740,32788,0,0),
(6023,2,'TI Caves 2f',89,32750,32793,0,0),
(6024,2,'TI Caves 2f',89,32766,32791,0,0),
(6025,2,'TI Caves 2f',93,32755,32818,0,0),
(6026,2,'TI Caves 2f',93,32726,32812,0,0),
(6027,2,'TI Caves 2f',93,32705,32816,0,0),
(6028,2,'TI Caves 2f',92,32698,32803,0,0),
(6029,2,'TI Caves 2f',92,32680,32797,0,0),
(6030,2,'TI Caves 2f',93,32707,32789,0,0),
(6031,2,'TI Caves 2f',92,32725,32795,0,0),
(6032,2,'TI Caves 2f',92,32667,32871,0,0);

-- add new template for the mobs with the pale silver key
INSERT INTO npc (npcid,name,nameid,note,impl,gfxid,lvl,hp,mp,ac,str,con,dex,wis,intel,mr,`exp`,lawful,`size`,weakAttr,ranged,tamable,passispeed,atkspeed,alt_atk_speed,atk_magic_speed,sub_magic_speed,undead,poison_atk,paralysis_atk,agro,agrososc,agrocoi,family,agrofamily,agrogfxid1,agrogfxid2,picupitem,digestitem,bravespeed,hprinterval,hpr,mprinterval,mpr,teleport,randomlevel,randomhp,randommp,randomac,randomexp,randomlawful,damage_reduction,hard,doppel,IsTU,IsErase,bowActId,karma,transform_id,transform_gfxid,light_size,amount_fixed,change_head,cant_resurrect) VALUES (92000, 'Skeleton Archer','$986','Pale silver key','L1Monster',1096,12,80,25,0,16,14,16,12,10,10,145,-12,'small',2,10,1,800,1120,920,1120,1120,1,0,0,1,1,0,'skeleton',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,66,0,-1,0,0,0,0,0),
(92001,'Skeleton Soldier','$988','Pale silver key','L1Monster',1106,13,90,15,8,16,14,15,12,10,10,170,-13,'small',2,2,1,640,880,840,880,880,1,0,0,1,1,0,'skeleton',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0),
('92002','Skeleton Axeman','$987','Pale silver key','L1Monster',1104,13,90,20,0,18,14,14,12,10,10,170,-13,'small',2,1,1,480,840,840,840,840,1,0,0,1,1,0,'skeleton',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0);

-- add the spawns for the pale silver key
INSERT INTO spawnlist (location,count,npc_templateid,group_id,locx,locy,randomx,randomy,locx1,locy1,locx2,locy2,heading,min_respawn_delay,max_respawn_delay,mapid,respawn_screen,movement_distance,rest,near_spawn,spawn_home,spawn_home_range,spawn_home_count,spawn_home_delay) VALUES
('Skeleton Axeman - PSK',3,92002,0,32736,32848,5,5,32730,32848,32740,32858,5,0,0,2,0,20,0,0,1,8,2,100),
('Skeleton Soldier - PSK',3,92001,0,32736,32848,5,5,32730,32848,32740,32858,5,0,0,2,0,20,0,0,1,8,2,100),
('Skeleton Archer - PSK',3,92000,0,32736,32848,5,5,32730,32848,32740,32858,5,0,0,2,0,20,0,0,1,8,2,100);

-- add the pale silver key to the spawns at at 7.5% drop rate
INSERT INTO droplist (mobId,mob_name,itemId,item_name,min,max,chance) VALUES
(92000,'Skeleton Archer',172,'Bow',1,1,50000),
(92000,'Skeleton Archer',20043,'Helmet',1,1,50000),
(92000,'Skeleton Archer',20056,'Cloak of Magic Resistance',1,1,50000),
(92000,'Skeleton Archer',40013,'Haste Potion',1,1,50000),
(92000,'Skeleton Archer',40018,'Greater Haste Potion',1,1,50000),
(92000,'Skeleton Archer',40171,'Spellbook(EnchantDex)',1,1,10000),
(92000,'Skeleton Archer',40240,'Spirit Crystal(TripleShot)',1,1,5000),
(92000,'Skeleton Archer',40308,'Adena',33,65,1000000),
(92000,'Skeleton Archer',40407,'Bone Piece',1,1,50000),
(92000,'Skeleton Archer',40313,'Pale silver key',1,1,75000),
(92001,'Skeleton Soldier',96,'Spear',1,1,10000),
(92001,'Skeleton Soldier',20056,'Cloak of Magic Resistance',1,1,50000),
(92001,'Skeleton Soldier',40013,'Haste Potion',1,1,50000),
(92001,'Skeleton Soldier',40018,'Greater Haste Potion',1,1,50000),
(92001,'Skeleton Soldier',40171,'Spellbook(EnchantDex)',1,1,10000),
(92001,'Skeleton Soldier',40308,'Adena',37,72,1000000),
(92001,'Skeleton Soldier',40407,'Bone Piece',1,1,50000),
(92001,'Skeleton Soldier',40739,'Throwing Knife',1,1,10000),
(92001,'Skeleton Archer',40313,'Pale silver key',1,1,75000),
(92002,'Skeleton Axeman',136,'Axe',1,1,50000),
(92002,'Skeleton Axeman',20056,'Cloak of Magic Resistance',1,1,50000),
(92002,'Skeleton Axeman',40006,'Pine Wand',1,1,10000),
(92002,'Skeleton Axeman',40013,'Haste Potion',1,1,50000),
(92002,'Skeleton Axeman',40018,'Greater Haste Potion',1,1,50000),
(92002,'Skeleton Axeman',40171,'Spellbook(EnchantDex)',1,1,10000),
(92002,'Skeleton Axeman',40187,'Spellbook(EnchantStr)',1,1,10000),
(92002,'Skeleton Axeman',40308,'Adena',37,72,1000000),
(92002,'Skeleton Axeman',40407,'Bone Piece',1,1,50000),
(92002,'Skeleton Archer',40313,'Pale silver key',1,1,75000);

ALTER TABLE `characters` ADD `birthday` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

CREATE TABLE IF NOT EXISTS `map_timers` (
  `char_id` int(10) unsigned NOT NULL,
  `map_id` int(10) unsigned NOT NULL,
  `area_id` int(10) unsigned NOT NULL,
  `enter_time` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`char_id`,`area_id`),
  KEY `map_id` (`map_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `pets` ADD `food` tinyint(3) NOT NULL DEFAULT '0';

-- Adjust item Ancient Dark Elf Secret Text.
UPDATE etcitem SET name = 'Ancient Dark Elf`s Secret Text' WHERE item_id = 49162;
UPDATE droplist SET chance = 10000 WHERE itemId = 49162;
INSERT INTO quest_drops (item_id, class) VALUES (49162, 'E');

-- Adjust dragon tablet droprates, mostly reducing the high % chances from
-- lower level mobs.

-- Dragon Tablet(MagmaBreath)
UPDATE droplist SET chance = 5000 WHERE itemId = 49105 and mobId = 45376; -- Giran Lava Golem, was 10000.
UPDATE droplist SET chance = 2500 WHERE itemId = 49105 and mobId = 45241; -- Cerberus, was 10000.
UPDATE droplist SET chance = 8000 WHERE itemId = 49105 and mobId = 45512; -- Hell Bound, was 10000.
UPDATE droplist SET chance = 2500 WHERE itemId = 49105 and mobId = 45121; -- Orc Wizard, was 10000.
UPDATE droplist SET chance = 2500 WHERE itemId = 49105 and mobId = 45424; -- Fang of Flame, was 10000.

-- Dragon Tablet(AwakenAntharas)
UPDATE droplist SET chance = 5000 WHERE itemId = 49106 and mobId = 45373; -- Ettin, was 10000.
UPDATE droplist SET chance = 2500 WHERE itemId = 49106 and mobId = 45311; -- Mole, was 10000.
UPDATE droplist SET chance = 1000 WHERE itemId = 49106 and mobId = 45115; -- Giant Ant, was 10000.
UPDATE droplist SET chance = 2500 WHERE itemId = 49106 and mobId = 45214; -- Mole, was 10000.
UPDATE droplist SET chance = 2500 WHERE itemId = 49106 and mobId = 45147; -- Owlbear, was 10000.
UPDATE droplist SET chance = 2500 WHERE itemId = 49106 and mobId = 45190; -- Giant Soldier Ant, was 10000.
UPDATE droplist SET chance = 2000 WHERE itemId = 49106 and mobId = 45184; -- Arachnevil Elder, was 8000.

-- Dragon Tablet(AwakenFafurion)
UPDATE droplist SET chance = 2500 WHERE itemId = 49111 and mobId = 45158; -- Mad Lizardman, was 10000.
UPDATE droplist SET chance = 8000 WHERE itemId = 49111 and mobId = 45984; -- Guardian of Water Spirit, was 10000.
UPDATE droplist SET chance = 8000 WHERE itemId = 49111 and mobId = 45460; -- Guardian of Water Spirit, was 10000.
UPDATE droplist SET chance = 5000 WHERE itemId = 49111 and mobId = 45936; -- Eva Sea Dancer, was 10000.
UPDATE droplist SET chance = 2500 WHERE itemId = 49111 and mobId = 45322; -- Living Armor, was 10000.
UPDATE droplist SET chance = 8000 WHERE itemId = 49111 and mobId = 45855; -- Guardian of Water Spirit, was 10000.

-- Dragon Tablet(MortalBody)
UPDATE droplist SET chance = 2500 WHERE itemId = 49112 and mobId = 45407; -- Cimaera, was 5000.

-- Dragon Tablet(FreezingBreath)
UPDATE droplist SET chance = 1000 WHERE itemId = 49115 and mobId = 45224; -- Undead Elmore Wizard, was 5000.
UPDATE droplist SET chance = 2500 WHERE itemId = 49115 and mobId = 46140; -- Maid of the Ice Queen, was 5000.
UPDATE droplist SET chance = 2500 WHERE itemId = 49115 and mobId = 45506; -- Cursed Elmore Wizard, was 5000.
UPDATE droplist SET chance = 2500 WHERE itemId = 49115 and mobId = 45422; -- Subterranean Great King Turtle, was 5000.

-- Dragon Tablet(AwakenValakas)
UPDATE droplist SET chance = 2500 WHERE itemId = 49116 and mobId = 45376; -- Giran Lava Golem, was 5000.
UPDATE droplist SET chance = 1000 WHERE itemId = 49116 and mobId = 45365; -- Lava Golem, was 5000.

-- Adjust Memory Cyrstal droprates.

-- Memory Crystal(Phantasm)
UPDATE droplist SET chance = 2500 WHERE itemId = 49128 and mobId = 45407; -- Cimaera, was 5000.

-- Memory Crystal(IllusionDiaGolem)
UPDATE droplist SET chance = 5000 WHERE itemId = 49130 and mobId = 45479; -- Horrific Iron Golem, was 7500.
UPDATE droplist SET chance = 2500 WHERE itemId = 49130 and mobId = 45372; -- Iron Golem, was 5000.
UPDATE droplist SET chance = 2500 WHERE itemId = 49130 and mobId = 45365; -- Lava Golem, was 5000.
UPDATE droplist SET chance = 2500 WHERE itemId = 49130 and mobId = 45796; -- Stone Golem of Maino Shaman, was 5000.

-- Slightly rebalance Ant Cave drops.
-- Giant Ant
UPDATE droplist SET chance = 7500 WHERE itemId = 20014 and mobId = 45115; -- Helm of Magic: Healing, was 10000.
UPDATE droplist SET chance = 25000 WHERE itemId = 40014 and mobId = 45115; -- Potion of Bravery, was 50000.
UPDATE droplist SET chance = 25000 WHERE itemId = 40018 and mobId = 45115; -- Greater Haste Potion, was 50000.
UPDATE droplist SET chance = 150000 WHERE itemId = 140100 and mobId = 45115; -- Scroll of Teleportation, was 175000.
-- Giant Soldier Ant
UPDATE droplist SET chance = 3000 WHERE itemId = 20149 and mobId = 45190; -- Bronze Plate Mail, was 5000.
UPDATE droplist SET chance = 1000 WHERE itemId = 20154 and mobId = 45190; -- Plate Mail, was 1500.
UPDATE droplist SET chance = 35000 WHERE itemId = 40014 and mobId = 45190; -- Potion of Bravery, was 50000.
UPDATE droplist SET chance = 40000 WHERE itemId = 40018 and mobId = 45190; -- Greater Haste Potion, was 50000.
UPDATE droplist SET chance = 175000 WHERE itemId = 140100 and mobId = 45190; -- Scroll of Teleportation, was 200000

-- Mark remaining Level 50 class quest drop items as only for that class.
-- Dantes' Royal Letter (Knight)
INSERT INTO quest_drops (item_id, class) VALUES (49160, 'K');
-- Spirit's Whisper (Knight)
INSERT INTO quest_drops (item_id, class) VALUES (49161, 'K');
-- Movement Order (Prince)
INSERT INTO quest_drops (item_id, class) VALUES (49159, 'P');
-- Secret Intelligence Report (Mage)
INSERT INTO quest_drops (item_id, class) VALUES (49164, 'W');

-- WARNING: THIS WILL TRUNCATE MAIL.
-- Update mail table.
-- TODO: Modify this later to migrate the data if anyone cares about that.
TRUNCATE `mail`;
ALTER TABLE `mail` MODIFY `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE `mail` ADD `inbox_id` int(10) unsigned NOT NULL DEFAULT '0';

-- for the quicklist in bookmarks
ALTER TABLE `character_teleport` ADD `quicklist` bool DEFAULT false;

-- Redo polymorphs table.
DROP TABLE IF EXISTS `polymorphs`;
CREATE TABLE `polymorphs` (
  `id` int(10) unsigned NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `gfx_id` int(10) unsigned NOT NULL,
  `min_level` tinyint(3) unsigned NOT NULL DEFAULT 0,
  `weapon_equip` int(10) unsigned NOT NULL DEFAULT 0,
  `armor_equip` int(10) unsigned NOT NULL DEFAULT 0,
  `can_use_skill` tinyint(1) unsigned DEFAULT 1,
  `cause` tinyint(3) unsigned NOT NULL DEFAULT 7,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
INSERT INTO polymorphs (id,name,gfx_id,min_level,weapon_equip,armor_equip,can_use_skill,cause) VALUES
(29,'floating eye',29,1,0,0,1,7),
(95,'shelob',95,10,0,0,0,7),
(146,'re ungoliant',146,10,0,0,0,7),
(938,'beagle',938,1,0,2,1,7),
(945,'milkcow',945,1,0,0,0,7),
(947,'deer',947,1,0,0,0,7),
(951,'cerberus',951,15,0,0,0,7),
(979,'wild boar',979,1,0,0,1,7),
(1037,'giant ant',1037,1,0,136,0,7),
(1039,'giant ant soldier',1039,1,0,136,0,7),
(1047,'scorpion',1047,15,0,0,0,7),
(2064,'snowman',2064,1,0,1027,1,7),
(2284,'dark elf polymorph',2284,52,256,4095,1,7),
(2323,'orc scout polymorph',2323,15,256,4095,1,7),
(2374,'re skeleton',2374,10,751,4095,1,7),
(2376,'skeleton axeman polymorph',2376,10,1791,4095,1,7),
(2377,'skeleton pike polymorph',2377,10,1791,4095,1,7),
(2378,'spartoi polymorph',2378,10,751,4095,1,7),
(2384,'succubus morph',2384,40,751,4095,1,7),
(2385,'yeti morph',2385,15,751,4095,1,7),
(2386,'minotaur i morph',2386,15,751,4095,1,7),
(2387,'giant a morph',2387,15,1791,4095,1,7),
(2388,'death',2388,1,0,32,0,7),
(2437,'re giant ant',2437,1,0,136,0,7),
(2438,'re giant ant soldier',2438,1,0,136,0,7),
(2501,'jack o lantern',2501,1,751,417,0,7),
(3101,'black knight chief morph',3101,51,751,4095,1,7),
(3102,'great minotaur morph',3102,50,1791,4095,1,7),
(3103,'barlog morph',3103,52,1791,4095,1,7),
(3126,'fire bowman morph',3126,51,256,4095,1,7),
(3630,'cyclops',3630,40,751,4095,1,7),
(3631,'griffon',3631,40,0,32,1,7),
(3632,'re cockatrice',3632,40,0,4095,1,7),
(3633,'ettin',3633,40,751,4095,1,7),
(3634,'assassin',3634,45,751,4095,1,7),
(3664,'baranka',3664,1,704,4095,1,7),
(3750,'haregi',3750,1,0,4095,1,7),
(3784,'death knight',3784,52,751,4095,1,7),
(3860,'bow orc',3860,1,256,4095,1,7),
(3861,'goblin',3861,1,751,913,0,7),
(3862,'kobolds',3862,1,751,913,1,7),
(3863,'re dwarf',3863,1,751,4095,1,7),
(3864,'orc fighter',3864,1,751,4095,1,7),
(3865,'re werewolf',3865,1,751,4095,1,7),
(3866,'gandi orc',3866,10,751,4095,1,7),
(3867,'rova orc',3867,10,751,4095,1,7),
(3868,'atuba orc',3868,10,751,4095,1,7),
(3869,'dudamara orc',3869,10,1791,4095,1,7),
(3870,'neruga orc',3870,10,1791,4095,1,7),
(3871,'re skeleton archer',3871,10,256,4095,1,7),
(3872,'zombie',3872,10,751,4095,1,7),
(3873,'re ghoul',3873,10,751,4095,1,7),
(3874,'re lycanthrope',3874,10,751,4095,1,7),
(3875,'ghast',3875,10,751,945,1,7),
(3876,'bugbear',3876,10,751,945,1,7),
(3877,'ogre',3877,15,1791,913,1,7),
(3878,'troll',3878,15,751,545,1,7),
(3879,'elder',3879,15,751,0,1,7),
(3880,'king bugbear',3880,15,751,945,1,7),
(3881,'dark elder',3881,45,751,4095,1,7),
(3882,'necromancer1',3882,45,751,4095,1,7),
(3883,'necromancer2',3883,45,751,4095,1,7),
(3884,'necromancer3',3884,45,751,4095,1,7),
(3885,'necromancer4',3885,45,751,4095,1,7),
(3886,'lesser demon',3886,45,751,4095,0,7),
(3887,'darkelf carrier',3887,45,1791,4095,0,7),
(3888,'baphomet',3888,50,751,954,1,7),
(3889,'demon',3889,51,751,4095,1,7),
(3890,'ancient black knight morph',3890,55,751,4095,1,7),
(3891,'ancient black mage morph',3891,55,751,4095,1,7),
(3892,'ancient black scouter morph',3892,55,256,4095,1,7),
(3893,'ancient silver knight morph',3893,60,751,4095,1,7),
(3894,'ancient silver mage morph',3894,60,751,4095,1,7),
(3895,'ancient silver scouter morph',3895,60,256,4095,1,7),
(3896,'ancient gold knight morph',3896,65,751,4095,1,7),
(3897,'ancient gold mage morph',3897,65,751,4095,1,7),
(3898,'ancient gold scouter morph',3898,65,256,4095,1,7),
(3899,'ancient platinum knight morph',3899,70,751,4095,1,7),
(3900,'ancient platinum mage morph',3900,70,751,4095,1,7),
(3901,'ancient platinum scouter morph',3901,70,256,4095,1,7),
(3902,'Kelenis Morph',3902,1,43,4095,1,7),
(3903,'Ken Lauhel Morph',3903,1,751,4095,1,7),
(3904,'stone golem',3904,1,751,145,1,7),
(3905,'beleth',3905,50,751,954,1,7),
(3906,'re orc',3906,1,751,4095,1,7),
(3945,'re gelatincube',3945,15,751,0,1,7),
(3950,'re middle oum',3950,15,751,4095,1,7),
(3952,'vampire',3952,1,0,32,0,7),
(4000,'knight vald morph',4000,1,1791,4095,1,7),
(4001,'iris morph',4001,1,1791,4095,1,7),
(4002,'paperman morph',4002,1,1791,4095,1,7),
(4004,'succubus queen morph',4004,1,1791,4095,1,7),
(4186,'robber bone',4186,1,751,4095,0,7),
(4188,'robber bone head',4188,1,751,4095,0,7),
(4190,'robber bone soldier',4190,1,256,4095,0,7),
(4227,'hakama',4227,1,0,4095,1,7),
(4767,'rabbit',4767,1,0,4095,0,7),
(4769,'carrot rabbit',4769,1,0,4095,0,7),
(4917,'darkelf ranger morph',4917,45,256,4095,1,7),
(4918,'bandit bow morph',4918,40,256,4095,1,7),
(4919,'darkelf guard morph',4919,50,256,4095,1,7),
(4920,'elmor general morph',4920,45,1791,4095,1,7),
(4921,'darkelf general morph',4921,52,1791,4095,1,7),
(4922,'guardian armor morph',4922,50,751,4095,1,7),
(4923,'black knight morph',4923,51,1080,4095,1,7),
(4924,'darkelf spear morph',4924,50,1080,4095,1,7),
(4925,'elmor soldier morph',4925,40,1080,4095,1,7),
(4926,'darkelf wizard morph',4926,50,751,4095,1,7),
(4928,'high collie',4928,1,0,2,1,7),
(4929,'high raccoon',4929,1,0,2,1,7),
(4932,'assassin master morph',4932,52,751,4095,1,7),
(5184,'red uniform',5184,1,0,8,1,7),
(5186,'blue uniform',5186,1,0,8,1,7),
(5645,'Halloween Pumpkin',5645,1,4095,4095,1,7),
(5719,'manekineko',5719,1,4095,4095,1,7),
(5727,'ancient black assassin morph',5727,55,751,4095,1,7),
(5730,'ancient silver assassin morph',5730,60,751,4095,1,7),
(5733,'ancient gold assassin morph',5733,65,751,4095,1,7),
(5736,'ancient platinum assassin morph',5736,70,751,4095,1,7),
(5976,'high bear',5976,1,751,2,0,7),
(6002,'spirit of earth boss',6002,1,8,0,1,7),
(6010,'red orc',6010,1,0,1,0,7),
(6034,'priest of corruption',6034,45,751,4095,1,7),
(6035,'quest lesser demon',6035,45,751,4095,1,7),
(6080,'princess horse',6080,1,16,4095,1,7),
(6086,'Rabor Born Head',6086,1,751,4095,1,7),
(6087,'Rabor Born archer',6087,1,256,4095,1,7),
(6088,'Rabor Born knife',6088,1,751,4095,1,7),
(6089,'drake morph',6089,1,1791,4095,1,7),
(6094,'prince horse',6094,1,16,4095,1,7),
(6136,'barlog 52',6136,52,1791,4095,1,7),
(6137,'death 52',6137,52,751,4095,1,7),
(6138,'assassin 52',6138,52,751,4095,1,7),
(6139,'general 52',6139,52,751,4095,1,7),
(6140,'darkelf 52',6140,52,256,4095,1,7),
(6141,'barlog 55',6141,55,1791,4095,1,7),
(6142,'death 55',6142,55,751,4095,1,7),
(6143,'assassin 55',6143,55,751,4095,1,7),
(6144,'general 55',6144,55,751,4095,1,7),
(6145,'darkelf 55',6145,55,256,4095,1,7),
(6146,'barlog 60',6146,60,1791,4095,1,7),
(6147,'death 60',6147,60,751,4095,1,7),
(6148,'assassin 60',6148,60,751,4095,1,7),
(6149,'general 60',6149,60,751,4095,1,7),
(6150,'darkelf 60',6150,60,256,4095,1,7),
(6151,'barlog 65',6151,65,1791,4095,1,7),
(6152,'death 65',6152,65,751,4095,1,7),
(6153,'assassin 65',6153,65,751,4095,1,7),
(6154,'general 65',6154,65,751,4095,1,7),
(6155,'darkelf 65',6155,65,256,4095,1,7),
(6156,'barlog 70',6156,70,1791,4095,1,7),
(6157,'death 70',6157,70,751,4095,1,7),
(6158,'assassin 70',6158,70,751,4095,1,7),
(6159,'general 70',6159,70,751,4095,1,7),
(6160,'darkelf 70',6160,70,256,4095,1,7),
(6180,'unicorn A',6180,0,751,4095,1,10),
(6181,'unicorn B',6181,0,751,4095,1,10),
(6182,'unicorn C',6182,0,751,4095,1,10),
(6183,'unicorn D',6183,0,0,0,0,10),
(6184,'bear A',6184,0,749,4095,1,10),
(6185,'bear B',6185,0,749,4095,1,10),
(6186,'bear C',6186,0,749,4095,1,10),
(6187,'bear D',6187,0,0,0,0,10),
(6188,'mini white dog A',6188,0,751,4095,1,10),
(6189,'mini white dog B',6189,0,751,4095,1,10),
(6190,'mini white dog C',6190,0,751,4095,1,10),
(6191,'mini white dog D',6191,0,0,0,0,10),
(6192,'ratman A',6192,0,751,4095,1,10),
(6193,'ratman B',6193,0,751,4095,1,10),
(6194,'ratman C',6194,0,751,4095,1,10),
(6195,'ratman D',6195,0,0,0,0,10),
(6196,'pet tiger A',6196,0,751,4095,1,10),
(6197,'pet tiger B',6197,0,751,4095,1,10),
(6198,'pet tiger C',6198,0,751,4095,1,10),
(6199,'pet tiger D',6199,0,0,0,0,10),
(6200,'dillo A',6200,0,751,4095,1,10),
(6201,'dillo B',6201,0,751,4095,1,10),
(6202,'dillo C',6202,0,751,4095,1,10),
(6203,'dillo D',6203,0,0,0,0,10),
(6204,'mole A',6204,0,256,4095,1,10),
(6205,'mole B',6205,0,256,4095,1,10),
(6206,'mole C',6206,0,256,4095,1,10),
(6207,'mole D',6207,0,0,0,0,10),
(6208,'darkelf thief A',6208,0,1007,4095,1,10),
(6209,'darkelf thief B',6209,0,1007,4095,1,10),
(6210,'darkelf thief C',6210,0,1007,4095,1,10),
(6211,'darkelf thief D',6211,0,0,0,0,10),
(6212,'ken lauhel A',6212,0,751,4095,1,10),
(6213,'ken lauhel B',6213,0,751,4095,1,10),
(6214,'ken lauhel C',6214,0,751,4095,1,10),
(6215,'ken lauhel D',6215,0,0,0,0,10),
(6216,'kelenis A',6216,0,751,4095,1,10),
(6217,'kelenis B',6217,0,751,4095,1,10),
(6218,'kelenis C',6218,0,751,4095,1,10),
(6219,'kelenis D',6219,0,0,0,0,10),
(6220,'slave A',6220,0,751,4095,1,10),
(6221,'slave B',6221,0,751,4095,1,10),
(6222,'slave C',6222,0,751,4095,1,10),
(6223,'slave D',6223,0,0,0,0,10),
(6224,'dofleganger boss A',6224,0,751,4095,1,10),
(6225,'dofleganger boss B',6225,0,751,4095,1,10),
(6226,'dofleganger boss C',6226,0,751,4095,1,10),
(6227,'dofleganger boss D',6227,0,0,0,0,10),
(6228,'lich A',6228,0,751,4095,1,10),
(6229,'lich B',6229,0,751,4095,1,10),
(6230,'lich C',6230,0,751,4095,1,10),
(6231,'lich D',6231,0,0,0,0,10),
(6232,'woman1 A',6232,0,0,4095,0,10),
(6233,'woman1 B',6233,0,0,0,0,10),
(6234,'woman2 A',6234,0,0,4095,0,10),
(6235,'woman2 B',6235,0,0,0,0,10),
(6236,'woman3 A',6236,0,0,4095,0,10),
(6237,'woman3 B',6237,0,0,0,0,10),
(6238,'woman4 A',6238,0,0,4095,0,10),
(6239,'woman4 B',6239,0,0,0,0,10),
(6240,'woman5 A',6240,0,0,4095,0,10),
(6241,'woman5 B',6241,0,0,0,0,10),
(6242,'noblewoman A',6242,0,0,4095,0,10),
(6243,'noblewoman B',6243,0,0,0,0,10),
(6267,'neo black knight',6267,55,751,4095,1,7),
(6268,'neo black mage',6268,55,751,4095,1,7),
(6269,'neo black scouter',6269,55,256,4095,1,7),
(6270,'neo silver knight',6270,60,751,4095,1,7),
(6271,'neo silver mage',6271,60,751,4095,1,7),
(6272,'neo silver scouter',6272,60,256,4095,1,7),
(6273,'neo gold knight',6273,65,751,4095,1,7),
(6274,'neo gold mage',6274,65,751,4095,1,7),
(6275,'neo gold scouter',6275,65,256,4095,1,7),
(6276,'neo platinum knight',6276,70,751,4095,1,7),
(6277,'neo platinum mage',6277,70,751,4095,1,7),
(6278,'neo platinum scouter',6278,70,256,4095,1,7),
(6279,'neo black assassin',6279,55,751,4095,1,7),
(6280,'neo silver assassin',6280,60,751,4095,1,7),
(6281,'neo gold assassin',6281,65,751,4095,1,7),
(6282,'neo platinum assassin',6282,70,751,4095,1,7),
(6284,'Haunted House jack o lantern',6284,1,0,0,0,7),
(6400,'Halloween jack o lantern',6400,1,4095,4095,1,7),
(7332,'spearm 52',7332,50,1040,4095,1,7),
(7338,'spearm 55',7338,55,1040,4095,1,7),
(7339,'spearm 60',7339,60,1040,4095,1,7),
(7340,'spearm 65',7340,65,1040,4095,1,7),
(7341,'spearm 70',7341,70,1040,4095,1,7),
(8774,'young kelenis',8774,75,751,4095,1,7),
(8812,'young gunter',8812,80,751,4095,1,7),
(8817,'young ken lauel',8817,75,751,4095,1,7),
(8851,'young dantes',8851,75,751,4095,1,7),
(8858,'re ghast',8858,1,751,945,1,7),
(8859,'re bugbear',8859,1,751,945,1,7),
(8860,'re orc scout',8860,1,256,4095,1,7),
(8861,'re succubus',8861,1,751,4095,1,7),
(8862,'re dragon fly',8862,1,751,4095,1,7),
(8863,'re raccoon',8863,1,751,4095,1,7),
(8864,'re owlbear',8864,1,751,4095,1,7),
(8865,'re lizardman',8865,1,751,4095,1,7),
(8866,'re kiwi parrot',8866,1,0,954,1,7),
(8867,'re ratman',8867,1,751,4095,1,7),
(8868,'re wild fang',8868,1,0,4095,1,7),
(8781,'re guard sword',8781,30,751,4095,1,7),
(8782,'re darkelf carrier',8782,30,1080,4095,1,7),
(8783,'re darkelf assassin',8783,30,751,4095,1,7),
(8784,'re elder',8784,30,751,4095,1,7),
(8785,'re orc axe',8785,30,751,4095,1,7),
(8786,'re bandit bow',8786,30,256,4095,1,7),
(8787,'re guard chief',8787,40,751,4095,1,7),
(8788,'re guard spear',8788,40,1080,4095,1,7),
(8789,'re hose',8789,40,751,4095,1,7),
(8790,'re dark elder',8790,40,751,4095,1,7),
(8791,'re bandit axe',8791,40,751,4095,1,7),
(8792,'re darkelf ranger',8792,40,256,4095,1,7),
(8793,'re cargo',8793,45,751,4095,1,7),
(8794,'re darkelf spear',8794,45,1080,4095,1,7),
(8795,'re blaze',8795,45,751,4095,1,7),
(8796,'re black wizard',8796,45,751,4095,1,7),
(8797,'re dwarf boss',8797,45,751,4095,1,7),
(8798,'re darkelf thief',8798,45,256,4095,1,7),
(8799,'re black knight chief',8799,50,751,4095,1,7),
(8800,'re black knight',8800,50,1080,4095,1,7),
(8801,'re assassin master',8801,50,751,4095,1,7),
(8802,'re baphomet',8802,50,751,4095,1,7),
(8803,'re minotaur',8803,50,751,4095,1,7),
(8804,'re darkelf guard',8804,50,256,4095,1,7),
(8805,'re dreik',8805,52,192,4095,1,7),
(8806,'re xinclair',8806,52,751,4095,1,7),
(8807,'re great minotaur',8807,52,8,4095,1,7),
(8808,'re darkelf bow',8808,52,256,4095,1,7),
(8900,'young helvine',8900,75,256,4095,1,7),
(8913,'young gilian',8913,80,256,4095,1,7),
(8978,'young bluedica',8978,80,751,4095,1,7),
(9003,'young joewoo',9003,80,751,4095,1,7),
(9011,'spearm 75',9011,75,1080,4095,1,7),
(9012,'spearm 80',9012,80,1080,4095,1,7),
(9205,'death 75',9205,75,751,4095,1,7),
(9206,'death 80',9206,80,751,4095,1,7),
(9225,'darkelf 75',9225,75,256,4095,1,7),
(9226,'darkelf 80',9226,80,256,4095,1,7),
(9362,'awake antharas',9362,1,1054,4095,1,7),
(9363,'awake valakas',9363,1,1054,4095,1,7),
(9364,'awake fafurion',9364,1,1054,4095,1,7);

-- Add new npc table fields.
ALTER TABLE `npc` ADD COLUMN `is_equality_drop` tinyint(1) unsigned NOT NULL DEFAULT 0;
ALTER TABLE `npc` ADD COLUMN `boss` tinyint(1) NOT NULL DEFAULT 0;

-- Drop unknown NPCs that don't exist in 3.63.  Confirmed not spawned.
DELETE FROM npc WHERE npcid IN
(45007, 60532, 60555, 60564, 60565, 70505, 70543, 70548, 70551, 70552, 70561,
 70566, 70571, 70578, 70579, 70580, 70588, 70673, 70678, 70710, 70720, 70726,
 70727, 70728, 70729, 70730, 70731, 70732, 70733, 70750, 70754, 70755, 70759,
 70791, 70866, 70869, 70879, 70883, 70899, 70905, 70914, 70915, 70918, 70921,
 70926, 70929, 70930, 70931, 70954, 70955, 70958, 70959, 70960, 70961, 70962,
 70968, 70969, 70974, 70975, 70976, 70978, 70979, 80008, 80009, 80011, 80012,
 80013, 80014, 80015, 80016, 80017, 80018, 80019, 80020, 80021, 80022, 80023,
 80024, 80025, 80026, 80027, 80028, 80029, 80030, 80031, 80032, 80033, 80034,
 80035, 80036, 80037, 80038, 80039, 80040, 80041, 80042, 80043, 80044, 80045,
 81044);

-- Sync nameids with 3.63.  Only updating ones that seem incorrect.
UPDATE npc SET nameid = '$4028' WHERE npcid = 45458; -- Was Captain Drake
UPDATE npc SET nameid = '$2933 Soldier' WHERE npcid = 45662; -- Was $2933 ??
UPDATE npc SET nameid = '$3941' WHERE npcid = 45671; -- Was Ariorc
UPDATE npc SET nameid = 'Singing Island Teleporter' WHERE npcid = 50082; -- Was $10078 (dummy)
UPDATE npc SET nameid = '$2344' WHERE npcid = 70535; -- Was ''
UPDATE npc SET nameid = '$455' WHERE npcid = 70539; -- Was ''
UPDATE npc SET nameid = '$2574' WHERE npcid = 70840; -- Was Robiel
UPDATE npc SET nameid = '$3118' WHERE npcid = 70977; -- Was ''
UPDATE npc SET nameid = 'Dromond' WHERE npcid = 70997; -- Was $10051 ((Summon Greater Element))
UPDATE npc SET nameid = 'Singing Island Guide' WHERE npcid = 70998; -- Was $10078 (dummy)
UPDATE npc SET nameid = '$2037' WHERE npcid = 70999; -- Was $10052 ((Burning Weapon))
UPDATE npc SET nameid = '$2037' WHERE npcid = 71000; -- Was $10053 ((Nature's Blessing))
UPDATE npc SET nameid = 'Pharmacist Ikushi' WHERE npcid = 71001; -- Was $10059 ((Elemental Falldown))
UPDATE npc SET nameid = 'Cancellation Teacher' WHERE npcid = 71002; -- Was $10083 (Grand Opening Rice Cake Chest)
UPDATE npc SET nameid = 'Blacksmith Ron' WHERE npcid = 71003; -- Was $10060 ((Counter Mirror))
UPDATE npc SET nameid = 'Adele' WHERE npcid = 71004; -- Was $10063 ((Water Life))
UPDATE npc SET nameid = 'Popilea' WHERE npcid = 71005; -- Was $10054 ((Call of Nature))
UPDATE npc SET nameid = 'Timmie' WHERE npcid = 71006; -- Was $10055 ((Storm Shot))
UPDATE npc SET nameid = 'Dylan' WHERE npcid = 71007; -- Was $10061 ((Wind Shackle))
UPDATE npc SET nameid = 'Blood Pledge Recruitment $1385' WHERE npcid = 71008; -- Was $10077 $1385 (dummy Message Board)
UPDATE npc SET nameid = 'Chicory' WHERE npcid = 71009; -- Was $10057 ((Iron Skin))
UPDATE npc SET nameid = 'Chicory' WHERE npcid = 71010; -- Was $10057 ((Iron Skin))
UPDATE npc SET nameid = 'Burriana' WHERE npcid = 71011; -- Was $10056 ((Wind Shackle))
UPDATE npc SET nameid = 'Burriana' WHERE npcid = 71012; -- Was $10056 ((Wind Shackle))
UPDATE npc SET nameid = 'Village Mercenary' WHERE npcid = 71014; -- Was $10078 (dummy)
UPDATE npc SET nameid = 'Village Mercenary' WHERE npcid = 71015; -- Was $10078 (dummy)
UPDATE npc SET nameid = 'Village Mercenary' WHERE npcid = 71016; -- Was $10078 (dummy)
UPDATE npc SET nameid = 'Village Mercenary' WHERE npcid = 71017; -- Was $10078 (dummy)
UPDATE npc SET nameid = 'Fader' WHERE npcid = 71018; -- Was $10078 (dummy)
UPDATE npc SET nameid = 'Vito Disciple' WHERE npcid = 71019; -- Was $10068 ((Pollute Water))
UPDATE npc SET nameid = 'Region' WHERE npcid = 71020; -- Was $10068 ((Striker Gale))
UPDATE npc SET nameid = 'Bonesmith Matti' WHERE npcid = 71021; -- Was $10073 (Halloween Banana Candy (After Use))
UPDATE npc SET nameid = 'Bonesmith Jinan' WHERE npcid = 71022; -- Was $10072 (Halloween Chocolate Candy (After Use))
UPDATE npc SET nameid = 'Bonesmith Kei' WHERE npcid = 71023; -- Was $10071 (Halloween Milk Candy (After Use))
UPDATE npc SET nameid = 'Kesukin' WHERE npcid = 71025; -- Was $10058 ((Triple Arrow))
UPDATE npc SET nameid = '$1737' WHERE npcid = 71026; -- Was $10078 (dummy)
UPDATE npc SET nameid = '$1730' WHERE npcid = 71027; -- Was $10078 (dummy)
UPDATE npc SET nameid = '$1731' WHERE npcid = 71028; -- Was $10078 (dummy)
UPDATE npc SET nameid = '$1738' WHERE npcid = 71029; -- Was $10078 (dummy)
UPDATE npc SET nameid = 'Mercenary Ryan' WHERE npcid = 71031; -- Was $10066 ((Aqua Protect))
UPDATE npc SET nameid = 'Adventurer Eta' WHERE npcid = 71032; -- Was $10067 ((Aqua Protect))
UPDATE npc SET nameid = 'Hermit' WHERE npcid = 71033; -- Was $10075 (dummy)
UPDATE npc SET nameid = 'Rabbi' WHERE npcid = 71034; -- Was $10074 (Halloween Strawberry Candy (After Use))
UPDATE npc SET nameid = 'Teleporter to Singing Island' WHERE npcid = 71035; -- Was $10078 (dummy)
UPDATE npc SET nameid = 'Mercenary Squad' WHERE npcid = 71176; -- Was ''
UPDATE npc SET nameid = 'Mercenary Squad' WHERE npcid = 71177; -- Was ''
UPDATE npc SET nameid = '$3421' WHERE npcid = 80010; -- Was ''
UPDATE npc SET nameid = 'Muryan - Large' WHERE npcid = 81048; -- Was $10102 (dummy)
UPDATE npc SET nameid = 'Giant Guarding Ant' WHERE npcid = 81078; -- Was $10101 (dummy)
UPDATE npc SET nameid = 'Giant Centipede' WHERE npcid = 81079; -- Was $10103 (dummy)
UPDATE npc SET nameid = 'Acting Magic Merchant' WHERE npcid = 81110; -- Was ''
UPDATE npc SET nameid = '$8988' WHERE npcid = 81200; -- Was ?????????
UPDATE npc SET nameid = 'Shop (Chain Sword)' WHERE npcid = 81241; -- Was ''
UPDATE npc SET nameid = 'Shop (Kiringku)' WHERE npcid = 81242; -- Was ''
UPDATE npc SET nameid = 'Shop (Dragon Tablet)' WHERE npcid = 81243; -- Was ''
UPDATE npc SET nameid = 'Shop (Memory Crystal)' WHERE npcid = 81244; -- Was ''

-- Update the names of any of the above NPCs that mismatch their nameids.
UPDATE npc SET `name` = 'Spirit of Drake' WHERE npcid = 45458; -- Was Captain Drake
UPDATE npc SET `name` = 'Windawood Soldier' WHERE npcid = 45662; -- Was Guard
UPDATE npc SET `name` = 'Ari Orc' WHERE npcid = 45671; -- Was Ariorc
UPDATE npc SET `name` = 'Singing Island Teleporter' WHERE npcid = 50082; -- Was Unknown 50082
UPDATE npc SET `name` = 'Kuper' WHERE npcid = 70535; -- Was Unknown 70535
UPDATE npc SET `name` = 'Fiin' WHERE npcid = 70539; -- Was Uknown 70539
UPDATE npc SET `name` = 'Miner Oum' WHERE npcid = 70977; -- Was Unknown 70977
UPDATE npc SET `name` = 'Dromond' WHERE npcid = 70997; -- Was Unknown 70997
UPDATE npc SET `name` = 'Singing Island Guide' WHERE npcid = 70998; -- Was Unknown 70998
UPDATE npc SET `name` = 'Alex' WHERE npcid = 70999; -- Was Unknown 70999
UPDATE npc SET `name` = 'Alex' WHERE npcid = 71000; -- Was Unknown 71000
UPDATE npc SET `name` = 'Cancellation Teacher' WHERE npcid = 71002; -- Was Unknown 71002
UPDATE npc SET `name` = 'Adele' WHERE npcid = 71004; -- Was Unknown 71004
UPDATE npc SET `name` = 'Popilea' WHERE npcid = 71005; -- Was Unknown 71005
UPDATE npc SET `name` = 'Dylan' WHERE npcid = 71007; -- Was Unknown 71007
UPDATE npc SET `name` = 'Blood Pledge Recruitment Board' WHERE npcid = 71008; -- Was Message Board
UPDATE npc SET `name` = 'Chicory' WHERE npcid = 71010; -- Was Unknown 71010
UPDATE npc SET `name` = 'Burriana' WHERE npcid = 71012; -- Was Unknown 71012
UPDATE npc SET `name` = 'Village Mercenary' WHERE npcid = 71014; -- Was Unknown 71014
UPDATE npc SET `name` = 'Village Mercenary' WHERE npcid = 71015; -- Was Unknown 71015
UPDATE npc SET `name` = 'Village Mercenary' WHERE npcid = 71016; -- Was Unknown 71016
UPDATE npc SET `name` = 'Village Mercenary' WHERE npcid = 71017; -- Was Unknown 71017
UPDATE npc SET `name` = 'Bonesmith Matti' WHERE npcid = 71021; -- Was BoneSmith Matti
UPDATE npc SET `name` = 'Bonesmith Jinan' WHERE npcid = 71022; -- Was BoneSmith Jinan
UPDATE npc SET `name` = 'Bonesmith Kei' WHERE npcid = 71023; -- Was BoneSmith Kei
UPDATE npc SET `name` = 'Coco' WHERE npcid = 71026; -- Was Unknown 71026
UPDATE npc SET `name` = 'Kun' WHERE npcid = 71027; -- Was Unknown 71027
UPDATE npc SET `name` = 'Kiyari' WHERE npcid = 71028; -- Was Unknown 71028
UPDATE npc SET `name` = 'Sky' WHERE npcid = 71029; -- Was Unknown 71029
UPDATE npc SET `name` = 'Mercenary Ryan' WHERE npcid = 71031; -- Was Unknown 71031
UPDATE npc SET `name` = 'Adventurer Eta' WHERE npcid = 71032; -- Was ETA Adventurers
UPDATE npc SET `name` = 'Teleporter to Singing Island' WHERE npcid = 71035; -- Was Unknown 71035
UPDATE npc SET `name` = 'Aden Castle Princess' WHERE npcid = 80010; -- Was Unknown 80010
UPDATE npc SET `name` = 'Muryan - Large' WHERE npcid = 81048; -- Was Unknown 81048
UPDATE npc SET `name` = 'Giant Gaurding Ant' WHERE npcid = 81078; -- Was Unknown 81078
UPDATE npc SET `name` = 'Giant Centipede' WHERE npcid = 81079; -- Was Unknown 81079
UPDATE npc SET `name` = 'Acting Magic Merchant' WHERE npcid = 81110; -- Was Unknown 81110
UPDATE npc SET `name` = 'Shop (Chain Sword)' WHERE npcid = 81241; -- Was ''
UPDATE npc SET `name` = 'Shop (Kiringku)' WHERE npcid = 81242; -- Was ''
UPDATE npc SET `name` = 'Shop (Dragon Tablet)' WHERE npcid = 81243; -- Was ''
UPDATE npc SET `name` = 'Shop (Memory Crystal)' WHERE npcid = 81244; -- Was ''

-- Update NPC gfxids
UPDATE npc SET gfxid = 2354 WHERE npcid = 45196; -- Alligator, was 1574
UPDATE npc SET gfxid = 2350 WHERE npcid = 45377; -- Lizardman, was 1173
UPDATE npc SET gfxid = 2372 WHERE npcid = 45378; -- Ghast, was 255
UPDATE npc SET gfxid = 10573 WHERE npcid = 45529; -- Drake, was 1062
UPDATE npc SET gfxid = 11197 WHERE npcid = 45641; -- Nightmare, was 2332
UPDATE npc SET gfxid = 3920 WHERE npcid = 45804; -- Vakuuk, was 1595
UPDATE npc SET gfxid = 2354 WHERE npcid = 45814; -- Mutated Alligator, was 1574
UPDATE npc SET gfxid = 2351 WHERE npcid = 45815; -- Mutant Ramia, was 1597
UPDATE npc SET gfxid = 2352 WHERE npcid = 45821; -- Mutant Ramia, was 1600
UPDATE npc SET gfxid = 5516 WHERE npcid = 45847; -- Cursed Dark Elf Wizard, was 4744
UPDATE npc SET gfxid = 699 WHERE npcid = 50118; -- Niki, was 940
UPDATE npc SET gfxid = 10669 WHERE npcid = 60001; -- Dorim, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60002; -- Bahof, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60003; -- Thram, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60004; -- Denitz, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60005; -- Luke, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60006; -- Jianku, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60007; -- Karim, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60008; -- Nodim, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60009; -- Sauram, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60010; -- Kasham, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60011; -- Kuron, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60012; -- Tofen, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60013; -- Axellon, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60014; -- Kriom, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60015; -- Ogi, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60016; -- Juke, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60017; -- Karudim, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60018; -- Calvas, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60019; -- Timpukin, was 143
UPDATE npc SET gfxid = 10713 WHERE npcid = 60020; -- Tulak, was 143
UPDATE npc SET gfxid = 10713 WHERE npcid = 60021; -- Hirim, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60022; -- Borgin, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60023; -- Tarkin, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60024; -- Gotham, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60025; -- Kusian, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60027; -- Kuhatin, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60029; -- Haidrim, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60030; -- Hakim, was 143
UPDATE npc SET gfxid = 10669 WHERE npcid = 60037; -- dummy, was 143
UPDATE npc SET gfxid = 7655 WHERE npcid = 60530; -- Dwarf Guard, was 1997
UPDATE npc SET gfxid = 7655 WHERE npcid = 60531; -- Dwarf Guard, was 1997
UPDATE npc SET gfxid = 148 WHERE npcid = 70862; -- Heine Gatekeeper, was 1659
UPDATE npc SET gfxid = 148 WHERE npcid = 70863; -- Heine Gatekeeper, was 1659
UPDATE npc SET gfxid = 3800 WHERE npcid = 70922; -- Oum, was 3787
UPDATE npc SET gfxid = 2429 WHERE npcid = 71179; -- Diez, was 2511
UPDATE npc SET gfxid = 5912 WHERE npcid = 81175; -- Wanted Criminal Kuzak, was 5910
UPDATE npc SET gfxid = 1571 WHERE npcid = 91302; -- Guardian of Noble Will, was 2771

-- remove maps from the server since 3.63 doesn't use them
DELETE FROM `shop` WHERE (`item_id` >= 40373 AND `item_id` <= 40390);
DELETE FROM `character_items` WHERE `item_id` >= 40373 AND `item_id` <= 40390;
DELETE FROM `character_elf_warehouse` WHERE `item_id` >= 40373 AND `item_id` <= 40390;
DELETE FROM `character_warehouse`  WHERE `item_id` >= 40373 AND `item_id` <= 40390;
DELETE FROM `clan_warehouse`  WHERE `item_id` >= 40373 AND `item_id` <= 40390;
DELETE FROM `etcitem` WHERE `item_id` >= 40373 AND `item_id` <= 40390;

-- Update NPC impls
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70576; -- Garth, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70581; -- Gulian, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70582; -- Neil, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70583; -- Nelson, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70586; -- Daisy, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70589; -- Laban, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70591; -- Lina, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70592; -- Leal, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70593; -- Manus, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70615; -- Alda, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70616; -- Aldred, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70619; -- Alice, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70622; -- Eliza, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70624; -- Oliver, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70626; -- Jack, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70630; -- Giles, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70634; -- Tanya, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70637; -- Trovia, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70639; -- Ferdinand, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70640; -- Pierre, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70647; -- Gavin, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70648; -- Daley, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70659; -- Atara, was L1Monster
UPDATE npc SET impl = 'L1Merchant' WHERE npcid = 70660; -- Unknown 70660, was L1Npc
UPDATE npc SET impl = 'L1Merchant' WHERE npcid = 70661; -- Unknown 70661, was L1Npc
UPDATE npc SET impl = 'L1Merchant' WHERE npcid = 70712; -- Jennifer, was L1Npc
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70735; -- Garuga, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70736; -- Derian, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70741; -- Dima, was L1Monster
UPDATE npc SET impl = 'L1Merchant' WHERE npcid = 70745; -- Roku, was 70745
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70746; -- Rotus, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70752; -- Biryan, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70767; -- Haro, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70770; -- Deker, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70803; -- Anotte, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70812; -- Rohan, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70814; -- Ruka, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70819; -- Bob, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70821; -- Sanita, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70825; -- Ellne, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70828; -- Ofo, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70833; -- Tommy, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70834; -- Torban, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70839; -- Doett, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70854; -- Hurindalien, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70858; -- Derick, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70867; -- Shannon, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70870; -- Arina, was L1Merchant
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70871; -- Annabel, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70877; -- Trion, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70878; -- Felix, was L1Monster
UPDATE npc SET impl = 'L1Merchant' WHERE npcid = 70881; -- Heine Mercenary Squad, was L1Npc
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70901; -- Jeti, was L1Monster
UPDATE npc SET impl = 'L1Teleporter' WHERE npcid = 71013; -- Karen, was L1Merchant
UPDATE npc SET impl = 'L1Teleporter' WHERE npcid = 71078; -- Pouare, was L1Merchant
UPDATE npc SET impl = 'L1Teleporter' WHERE npcid = 71080; -- Chief Security Amisu, was L1Merchant
-- Additional impl updates.
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70604; -- Bridget, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70606; -- Victor, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70608; -- Shalina, was L1Monster
UPDATE npc SET impl = 'L1Npc' WHERE npcid = 70621; -- Evelyn, was L1Monster
UPDATE npc SET impl = 'L1Merchant' WHERE npcid = 71112; -- Giles, was L1Monster

-- Update NPC level, hp, mp, ac.
-- NOTE: Some bosses, like Ifrit and Drake were buffed to into the level 70s.
-- Skipping that here for now.
UPDATE npc SET ac = -32 WHERE npcid = 45326; -- Dark Forester, was ac = -10
UPDATE npc SET ac = -43 WHERE npcid = 45533; -- Phantom Knight, was ac = -25
UPDATE npc SET ac = -8 WHERE npcid = 45562; -- Guardian Armor, was ac = -223
UPDATE npc SET hp = 2000 WHERE npcid = 45605; -- Priest of Corruption, was hp = 1000
UPDATE npc SET lvl = 80 WHERE npcid = 45676; -- Arcane King Hellvine, was lvl = 70
UPDATE npc SET hp = 30000 WHERE npcid = 45681; -- Lindvior, was hp = 20000
UPDATE npc SET lvl = 45, hp = 620 WHERE npcid = 45862; -- Cursed Dark Elf Warrior, was lvl = 47, hp = 650
UPDATE npc SET hp = 1000 WHERE npcid = 45931; -- Spirit of Water, was hp = 10000
UPDATE npc SET lvl = 70, hp = 10000, mp = 400, ac = -80 WHERE npcid = 45931; -- Ice Queen, was lvl = 60, hp = 15000, mp = 1000, ac = -65
UPDATE npc SET lvl = 65, hp = 7000, mp = 450, ac = -70 WHERE npcid = 46142; -- Ice Demon, was lvl = 55, hp = 10000, mp = 500, ac = -68
UPDATE npc SET lvl = 25 WHERE npcid = 60563; -- Heine Guard, was lvl = 85
UPDATE npc SET lvl = 25 WHERE npcid = 70857; -- Heine Guard, was lvl = 80
UPDATE npc SET lvl = 10 WHERE npcid = 70862; -- Heine Gatekeeper, was lvl = 85
UPDATE npc SET lvl = 10 WHERE npcid = 70863; -- Heine Gatekeeper, was lvl = 85
UPDATE npc SET hp = 6000 WHERE npcid = 81082; -- Yahee, was hp = 30000
UPDATE npc SET hp = 1000 WHERE npcid = 81240; -- Cougar, was hp = 2000
UPDATE npc SET mp = 0 WHERE npcid = 90506; -- Ecu Juraka (Blue), was mp = 50
UPDATE npc SET mp = 0 WHERE npcid = 90507; -- Ecu Juraka (Green), was mp = 50
UPDATE npc SET ac = -140 WHERE npcid = 90518; -- Jeb Requie (Male), was ac = -120
UPDATE npc SET ac = -140 WHERE npcid = 90519; -- Jeb Requie (Female), was ac = -120
UPDATE npc SET hp = 20000, ac = -75 WHERE npcid = 91309; -- Priest Guignol, was hp = 2000, ac = -50
-- Zero out new L1Npc impls stats.
UPDATE npc SET lvl = 0, hp = 0, mp = 0, ac = 0, str = 0, con = 0, dex = 0,
  wis = 0, intel = 0, mr = 0, exp = 0, lawful = 0, weakAttr = 0, ranged = 0,
  tamable = 0, atkspeed = 0, alt_atk_speed = 0, atk_magic_speed = 0,
  sub_magic_speed = 0, undead = 0, poison_atk = 0, paralysis_atk = 0, agro = 0,
  agrososc = 0, agrocoi = 0, agrofamily = 0, picupitem = 0, digestitem = 0,
  bravespeed = 0, hprinterval = 0, hpr = 0, mprinterval = 0, mpr = 0, teleport = 0
  WHERE npcid IN
  (70576, 70581, 70582, 70583, 70586, 70589, 70591, 70592, 70593, 70604, 70606,
   70608, 70615, 70616, 70619, 70621, 70622, 70624, 70626, 70630, 70634, 70637,
   70639, 70640, 70647, 70648, 70659, 70735, 70736, 70741, 70746, 70752, 70767,
   70770, 70803, 70812, 70814, 70819, 70821, 70825, 70828, 70833, 70834, 70839,
   70854, 70858, 70867, 70871, 70877, 70878, 70901, 71112)
  ORDER BY npcid;

-- Update NPC base stats.
UPDATE npc SET str = 20 WHERE npcid = 45676; -- Arcane King Hellvine, was str = 80.
UPDATE npc SET str = 90, con = 35, dex = 30, wis = 35, intel = 35 WHERE npcid = 81163; -- Girtas, was str = 80, con = 21, dex = 18, wis = 20, intel = 20
UPDATE npc SET str = 6, con = 6, dex = 6, wis = 6, intel = 6 WHERE npcid = 90500; -- Monkey, was str = 1, con = 1, dex = 1, wis = 1, intel = 1
UPDATE npc SET str = 5, con = 2, dex = 7, wis = 7, intel = 7 WHERE npcid = 90501; -- Snake, was str = 1, con = 1, dex = 1, wis = 1, intel = 1
UPDATE npc SET str = 12 WHERE npcid = 90501; -- Starved Warden, was str = 16

-- Update NPC mr, exp, lawful, size.
-- NOTE: Skipping Giran Prison mobs.
UPDATE npc SET lawful = -25 WHERE npcid = 45533; -- Phantom Knight, was lawful = -50
UPDATE npc SET lawful = -5 WHERE npcid = 45647; -- Demon of Varlok, was lawful = -150
UPDATE npc SET `exp` = 4901 WHERE npcid = 45676; -- Arcane King Hellvine, was exp = 6401
UPDATE npc SET mr = 99 WHERE npcid = 45681; -- Lindvior, was mr = 180
UPDATE npc SET mr = 99 WHERE npcid = 45682; -- Antharas, was mr = 180
UPDATE npc SET mr = 99 WHERE npcid = 45683; -- Fafurion, was mr = 180
UPDATE npc SET mr = 99 WHERE npcid = 45684; -- Valakas, was mr = 180
UPDATE npc SET mr = 60 WHERE npcid = 46092; -- Unchosen One, was mr = 100
UPDATE npc SET mr = 90, lawful = -1000 WHERE npcid = 46141; -- Ice Queen, was mr = 60, lawful = -200
UPDATE npc SET lawful = -1000 WHERE npcid = 46142; -- Ice Demon, was lawful = -150
UPDATE npc SET lawful = 1000 WHERE npcid = 60558; -- Gerard Mercenary Squad, was lawful = 0
UPDATE npc SET lawful = 1000 WHERE npcid = 60559; -- Gerard Mercenary Squad, was lawful = 0
UPDATE npc SET lawful = 1800 WHERE npcid = 70809; -- Guard, was lawful = 0
UPDATE npc SET lawful = 1800 WHERE npcid = 70862; -- Heine Gatekeeper, was lawful = 0
UPDATE npc SET lawful = 1800 WHERE npcid = 70863; -- Heine Gatekeeper, was lawful = 0
UPDATE npc SET mr = 110, `exp` = 98020 WHERE npcid = 81163; -- Girtas, was mr = 99, exp = 9802
UPDATE npc SET mr = 75 WHERE npcid = 81240; -- Cougar, was mr = 100
-- Various L1Npcs.
UPDATE npc SET size = 'small' WHERE npcid >= 50001 AND npcid <= 50631;
UPDATE npc SET size = 'small' WHERE npcid >= 60001 AND npcid <= 60037;
UPDATE npc SET size = 'small' WHERE npcid >= 70001 AND npcid <= 70520;
UPDATE npc SET size = 'small' WHERE npcid >= 70522 AND npcid <= 70539;
UPDATE npc SET size = 'small' WHERE npcid >= 70542 AND npcid <= 70547;
UPDATE npc SET size = 'small' WHERE npcid >= 70550 AND npcid <= 70562;
UPDATE npc SET size = 'small' WHERE npcid >= 70567 AND npcid <= 70573;
UPDATE npc SET size = 'small' WHERE npcid = 70577;
UPDATE npc SET size = 'small' WHERE npcid >= 70584 AND npcid <= 70585;
UPDATE npc SET size = 'small' WHERE npcid = 70587;
UPDATE npc SET size = 'small' WHERE npcid = 70590;
UPDATE npc SET size = 'small' WHERE npcid >= 70594 AND npcid <= 70599;
UPDATE npc SET size = 'small' WHERE npcid >= 70601 AND npcid <= 70603;
UPDATE npc SET size = 'small' WHERE npcid = 70605;
UPDATE npc SET size = 'small' WHERE npcid = 70607;
UPDATE npc SET size = 'small' WHERE npcid >= 70609 AND npcid <= 70614;
UPDATE npc SET size = 'small' WHERE npcid >= 70617 AND npcid <= 70618;
UPDATE npc SET size = 'small' WHERE npcid = 70620;
UPDATE npc SET size = 'small' WHERE npcid = 70623;
UPDATE npc SET size = 'small' WHERE npcid = 70625;
UPDATE npc SET size = 'small' WHERE npcid >= 70627 AND npcid <= 70629;
UPDATE npc SET size = 'small' WHERE npcid >= 70631 AND npcid <= 70633;
UPDATE npc SET size = 'small' WHERE npcid >= 70635 AND npcid <= 70636;
UPDATE npc SET size = 'small' WHERE npcid = 70638;
UPDATE npc SET size = 'small' WHERE npcid >= 70641 AND npcid <= 70644;
UPDATE npc SET size = 'small' WHERE npcid >= 70649 AND npcid <= 70655;
UPDATE npc SET size = 'small' WHERE npcid >= 70657 AND npcid <= 70658;
UPDATE npc SET size = 'small' WHERE npcid >= 70660 AND npcid <= 70686;
UPDATE npc SET size = 'small' WHERE npcid >= 70688 AND npcid <= 70702;
UPDATE npc SET size = 'small' WHERE npcid >= 70705 AND npcid <= 70725;
UPDATE npc SET size = 'small' WHERE npcid >= 70737 AND npcid <= 70740;
UPDATE npc SET size = 'small' WHERE npcid >= 70742 AND npcid <= 70745;
UPDATE npc SET size = 'small' WHERE npcid >= 70747 AND npcid <= 70751;
UPDATE npc SET size = 'small' WHERE npcid >= 70753 AND npcid <= 70766;
UPDATE npc SET size = 'small' WHERE npcid >= 70771 AND npcid <= 70777;
UPDATE npc SET size = 'small' WHERE npcid >= 70779 AND npcid <= 70790;
UPDATE npc SET size = 'small' WHERE npcid >= 70794 AND npcid <= 70799;
UPDATE npc SET size = 'small' WHERE npcid >= 70801 AND npcid <= 70802;
UPDATE npc SET size = 'small' WHERE npcid >= 70804 AND npcid <= 70807;
UPDATE npc SET size = 'small' WHERE npcid >= 70810 AND npcid <= 70811;
UPDATE npc SET size = 'small' WHERE npcid = 70813;
UPDATE npc SET size = 'small' WHERE npcid >= 70815 AND npcid <= 70816;
UPDATE npc SET size = 'small' WHERE npcid = 70818;
UPDATE npc SET size = 'small' WHERE npcid = 70820;
UPDATE npc SET size = 'small' WHERE npcid >= 70822 AND npcid <= 70824;
UPDATE npc SET size = 'small' WHERE npcid = 70826;
UPDATE npc SET size = 'small' WHERE npcid >= 70829 AND npcid <= 70832;
UPDATE npc SET size = 'small' WHERE npcid >= 70835 AND npcid <= 70838;
UPDATE npc SET size = 'small' WHERE npcid >= 70840 AND npcid <= 70845;
UPDATE npc SET size = 'small' WHERE npcid = 70847;
UPDATE npc SET size = 'small' WHERE npcid = 70849;
UPDATE npc SET size = 'small' WHERE npcid = 70853;
UPDATE npc SET size = 'small' WHERE npcid = 70856;
UPDATE npc SET size = 'small' WHERE npcid >= 70859 AND npcid <= 70861;
UPDATE npc SET size = 'small' WHERE npcid >= 70864 AND npcid <= 70865;
UPDATE npc SET size = 'small' WHERE npcid >= 70868 AND npcid <= 70870;
UPDATE npc SET size = 'small' WHERE npcid >= 70872 AND npcid <= 70876;
UPDATE npc SET size = 'small' WHERE npcid >= 70880 AND npcid <= 70900;
UPDATE npc SET size = 'small' WHERE npcid >= 70902 AND npcid <= 70956;
UPDATE npc SET size = 'small' WHERE npcid >= 70963 AND npcid <= 70983;
UPDATE npc SET size = 'small' WHERE npcid >= 70997 AND npcid <= 71007;
UPDATE npc SET size = 'small' WHERE npcid >= 71009 AND npcid <= 71061;
UPDATE npc SET size = 'small' WHERE npcid >= 71063 AND npcid <= 71074;
UPDATE npc SET size = 'small' WHERE npcid >= 71076 AND npcid <= 71080;
UPDATE npc SET size = 'small' WHERE npcid >= 71089 AND npcid <= 71091;
UPDATE npc SET size = 'small' WHERE npcid = 71095;
UPDATE npc SET size = 'small' WHERE npcid >= 71108 AND npcid <= 71182;
UPDATE npc SET size = 'small' WHERE npcid = 71184;
UPDATE npc SET size = 'small' WHERE npcid >= 71187 AND npcid <= 71196;
UPDATE npc SET size = 'small' WHERE npcid >= 71198 AND npcid <= 71200;
UPDATE npc SET size = 'small' WHERE npcid >= 71251 AND npcid <= 71253;
UPDATE npc SET size = 'small' WHERE npcid >= 71264 AND npcid <= 71266;
UPDATE npc SET size = 'small' WHERE npcid >= 80007 AND npcid <= 80105;
UPDATE npc SET size = 'small' WHERE npcid >= 80127 AND npcid <= 80128;
UPDATE npc SET size = 'small' WHERE npcid >= 80132 AND npcid <= 80137;
UPDATE npc SET size = 'small' WHERE npcid >= 80141 AND npcid <= 80146;
UPDATE npc SET size = 'small' WHERE npcid = 80168;
UPDATE npc SET size = 'small' WHERE npcid >= 81002 AND npcid <= 81029;
UPDATE npc SET size = 'small' WHERE npcid = 81105;
UPDATE npc SET size = 'small' WHERE npcid = 81110;
UPDATE npc SET size = 'small' WHERE npcid >= 81112 AND npcid <= 81121;
UPDATE npc SET size = 'small' WHERE npcid >= 81123 AND npcid <= 81124;
UPDATE npc SET size = 'small' WHERE npcid = 81155;
UPDATE npc SET size = 'small' WHERE npcid = 81200;
UPDATE npc SET size = 'small' WHERE npcid >= 81202 AND npcid <= 81208;
UPDATE npc SET size = 'small' WHERE npcid >= 81241 AND npcid <= 81244;
UPDATE npc SET size = 'small' WHERE npcid = 81246;

-- Update NPC weakAttr, ranged, tamable.
UPDATE npc SET tamable = 1 WHERE npcid = 45121; -- Orc Wizard, was tamable = 0
UPDATE npc SET ranged = 1 WHERE npcid = 45283; -- Giran Cerberus, was ranged = 2
UPDATE npc SET tamable = 0 WHERE npcid = 45318; -- Giant - Light, was tamable = 1
UPDATE npc SET ranged = 2 WHERE npcid = 45569; -- Baphomet of Varlok, was ranged = 1
UPDATE npc SET ranged = 2 WHERE npcid = 45579; -- Beleth of Varlok, was ranged = 1
UPDATE npc SET ranged = 2 WHERE npcid = 45827; -- Mutant Lizardman, was ranged = 1
UPDATE npc SET weakAttr = 2 WHERE npcid = 45847; -- Cursed Dark Elf Wizard, was weakAttr = 0
UPDATE npc SET ranged = 0 WHERE npcid >= 45883 AND npcid <= 45889;
UPDATE npc SET weakAttr = 4 WHERE npcid = 45930; -- Cursed Lizardman, was weakAttr = 12
UPDATE npc SET weakAttr = 2 WHERE npcid = 46109; -- Scarab - Yellow, was weakAttr = 10
UPDATE npc SET weakAttr = 4 WHERE npcid = 46110; -- Scarab - Blue, was weakAttr = 10
UPDATE npc SET weakAttr = 8 WHERE npcid = 46112; -- Kalbis - Red, was weakAttr = 2
UPDATE npc SET weakAttr = 4 WHERE npcid = 46114; -- Obelisk - Dark, was weakAttr = 8
UPDATE npc SET weakAttr = 2 WHERE npcid = 46116; -- Sphinx - Dark, was weakAttr = 0
UPDATE npc SET weakAttr = 4 WHERE npcid = 46117; -- Horus Falcon - Yellow, was weakAttr = 2
UPDATE npc SET weakAttr = 0 WHERE npcid = 46119; -- Thebes Guardian - Dark, was weakAttr = 10
UPDATE npc SET weakAttr = 0 WHERE npcid = 46120; -- Thebes Guardian - Red, was weakAttr = 10
UPDATE npc SET weakAttr = 0 WHERE npcid = 46121; -- Thebes Elder - Yellow, was weakAttr = 12
UPDATE npc SET weakAttr = 0 WHERE npcid = 46122; -- Thebes Elder - Purple, was weakAttr = 12
UPDATE npc SET ranged = 2 WHERE npcid = 70862; -- Heine Gatekeeper, was ranged = 1
UPDATE npc SET ranged = 2 WHERE npcid = 70863; -- Heine Gatekeeper, was ranged = 1
UPDATE npc SET ranged = 4 WHERE npcid = 90500; -- Monkey, was ranged = 0

-- NOTE: Skipping speeds.  Will do those separately.

-- Update NPC undead flag
UPDATE npc SET undead = 0 WHERE npcid = 45019; -- Orc Archer, was 5
UPDATE npc SET undead = 5 WHERE npcid = 45024; -- Werewolf, was 0
UPDATE npc SET undead = 5 WHERE npcid = 45389; -- Lycanthrope, was 0
UPDATE npc SET undead = 0 WHERE npcid = 45835; -- Cursed Dark Elf Warrior, was 1
UPDATE npc SET undead = 2 WHERE npcid = 81163; -- Girtas, was 0

-- Update NPC poison_atk
UPDATE npc SET poison_atk = 1 WHERE npcid = 45296; -- Gelatinous Cube, was 0

-- Update NPC agro, agrososc, agrocoi
UPDATE npc SET agro = 0, agrososc = 0, agrocoi = 0 WHERE npcid >= 45883 AND npcid <= 45889;
UPDATE npc SET agro = 0, agrososc = 0, agrocoi = 0 WHERE npcid = 45943; -- Kapu, was agro = 1, agrososc = 1, agrocoi = 1

-- Update NPC hprinterval.
UPDATE npc SET hprinterval = 5000 WHERE npcid = 45828; -- Doppelganger Boss, was 0

-- Update NPC hpr.
UPDATE npc SET hpr = 150 WHERE npcid = 45676; -- Arcane King Hellvine, was 300
UPDATE npc SET hpr = 2000 WHERE npcid = 45681; -- Lindvior, was 1000
UPDATE npc SET hpr = 250 WHERE npcid = 45828; -- Doppelganger Boss, was 250
UPDATE npc SET hpr = 3000 WHERE npcid = 81163; -- Girtas, was 500
UPDATE npc SET hpr = 250 WHERE npcid = 91309; -- Priest Guignol, was 100

-- Update NPC mprinterval.
UPDATE npc SET mprinterval = 5000 WHERE npcid = 45828; -- Doppelganger Boss, was 0

-- Update NPC mpr.
UPDATE npc SET mpr = 50 WHERE npcid = 45828; -- Doppelganger Boss, was 0
UPDATE npc SET mpr = 1000 WHERE npcid = 81163; -- Girtas, was 500
UPDATE npc SET mpr = 350 WHERE npcid = 91309; -- Priest Guignol, was 100

-- Update NPC isTU.
UPDATE npc SET IsTU = 0 WHERE npcid IN
(91401, 91403, 91409, 91410, 91415, 91416, 91417, 91418, 91419);

-- Update NPC IsErase.
UPDATE npc SET IsErase = 1 WHERE npcid IN
(45538, 45572, 45578, 45580, 91429);
UPDATE npc SET IsErase = 0 WHERE npcid IN
(70576, 70581, 70582, 70583, 70586, 70589, 70591, 70592, 70593, 70604, 70606,
 70608, 70615, 70616, 70619, 70621, 70622, 70624, 70626, 70630, 70634, 70637,
 70639, 70640, 70647, 70648, 70659, 70735, 70736, 70741, 70746, 70752, 70767,
 70770, 70803, 70812, 70814, 70819, 70821, 70825, 70828, 70833, 70834, 70839,
 70854, 70858, 70867, 70871, 70877, 70878, 70901, 71112, 81254);

-- Update NPC bowactid
UPDATE npc SET bowactid = 1156 WHERE npcid = 45033; -- Imp, was 0
UPDATE npc SET bowactid = 4536 WHERE npcid = 45676; -- Arcane King Hellvine, was 66

-- Update NPC light_size
UPDATE npc SET light_size = 14 WHERE npcid = 81254; -- Cracked Time, was 0
UPDATE npc SET light_size = 14 WHERE npcid = 90521; -- Altar Gakekeeper, was 0

-- Update NPC change_head.
UPDATE npc SET change_head = 1 WHERE npcid IN (50111, 50127, 70712, 70964);
UPDATE npc SET change_head = 0 WHERE npcid IN
(70017, 70050, 70077, 70080, 70520, 70528, 70532, 70534, 70544, 70576, 70581,
 70582, 70583, 70586, 70589, 70591, 70592, 70593, 70604, 70606, 70608, 70615,
 70616, 70617, 70619, 70621, 70622, 70624, 70626, 70630, 70632, 70634, 70637,
 70639, 70640, 70647, 70648, 70653, 70659, 70661, 70664, 70701, 70702, 70723,
 70735, 70736, 70741, 70746, 70749, 70752, 70762, 70766, 70770, 70773, 70803,
 70809, 70812, 70814, 70819, 70821, 70825, 70828, 70833, 70834, 70836, 70839,
 70854, 70858, 70867, 70871, 70873, 70877, 70878, 70901, 71035, 71053, 71121,
 71124, 71178, 71179, 71252, 71253, 80085, 80086, 80087, 80095, 80104, 80105,
 80168, 81200, 81246);

-- Update NPC cant_resurrect.
UPDATE npc SET cant_resurrect = 1 WHERE npcid IN
(45228, 45317, 45338, 45370, 45546, 45772, 46123, 46124, 81081, 81082, 91204);

-- Update NPC boss flag.
UPDATE npc SET boss = 1 WHERE npcid IN
(45228, 45316, 45338, 45370, 45456, 45458, 45488, 45492, 45513, 45516, 45529,
 45534, 45535, 45545, 45546, 45547, 45548, 45573, 45574, 45577, 45583, 45584,
 45585, 45588, 45600, 45601, 45602, 45606, 45607, 45608, 45609, 45610, 45612,
 45614, 45615, 45617, 45618, 45625, 45640, 45642, 45643, 45644, 45645, 45646,
 45648, 45649, 45650, 45651, 45652, 45653, 45654, 45671, 45672, 45673, 45674,
 45680, 45681, 45682, 45683, 45684, 45685, 45734, 45735, 45753, 45772, 45795,
 45801, 45802, 45829, 45844, 45863, 45931, 45935, 45941, 45942, 45943, 45944,
 45955, 45956, 45957, 45958, 45959, 45960, 45961, 45962, 45963, 46024, 46025,
 46026, 46037, 46123, 46124, 46141, 46142, 81081, 81082, 91203, 91204, 91205,
 91206, 91207, 91408, 91414);
