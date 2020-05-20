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

-- Insert new NPC records.
INSERT INTO npc () VALUES
   (46164, 'Lastavard Cube', '$12121', 'Lastavard Cube', 'L1Teleporter', 10150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 1, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46165, 'Lastavard Cube', '$12121', 'Lastavard Cube', 'L1Teleporter', 10150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 1, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46166, 'Lastavard Cube', '$12121', 'Lastavard Cube', 'L1Teleporter', 10150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 1, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46167, 'Lastavard Cube', '$12121', 'Lastavard Cube', 'L1Teleporter', 10150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 1, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46168, 'Paper Man', '$1396', 'Paper Man', 'L1Monster', 1538, 50, 800, 5, -30, 11, 16, 10, 8, 10, 5, 2501, -8, 'small', 1, 1, 1, 960, 960, 800, 960, 960, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46169, 'Mimic', '$1392', 'Mimic', 'L1Monster', 1479, 50, 1250, 20, -50, 16, 12, 14, 10, 11, 20, 2501, -20, 'small', 1, 1, 1, 1280, 1120, 0, 1120, 1120, 0, 0, 0, 1, 0, 0, '', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46170, 'Stone Golem', '$56', 'Stone Golem', 'L1Monster', 4910, 50, 875, 10, -50, 58, 16, 10, 6, 11, 45, 2501, -30, 'large', 1, 1, 0, 1280, 960, 1200, 2640, 2640, 0, 0, 0, 1, 0, 0, 'golem', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46171, 'Iron Golem', '$1789', 'Stone Golem', 'L1Monster', 4867, 51, 910, 10, -51, 70, 30, 8, 5, 5, 20, 2602, -28, 'large', 1, 1, 0, 1920, 1360, 1280, 1120, 1280, 0, 0, 0, 1, 1, 1, 'golem', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46172, 'Gelatinous Cube', '$2115', 'Gelatinous Cube', 'L1Monster', 2541, 52, 946, 10, -47, 21, 20, 8, 5, 9, 0, 2705, -25, 'large', 1, 10, 1, 1440, 1280, 0, 1280, 1280, 0, 1, 0, 1, 1, 0, 'gelatine', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2559, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46173, 'Living Armor', '$1408', 'Living Armor', 'L1Monster', 1578, 53, 983, 40, -53, 18, 15, 12, 12, 10, 40, 2810, -35, 'small', 1, 1, 1, 1440, 1920, 0, 1920, 1920, 2, 0, 0, 1, 1, 0, 'livingarmour', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46174, 'Living Armor', '$1408', 'Living Armor', 'L1Monster', 5348, 54, 1021, 10, -44, 18, 15, 12, 12, 10, 50, 2917, -35, 'small', 1, 1, 1, 960, 1000, 880, 1920, 1920, 2, 0, 0, 1, 1, 0, 'livingarmour', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46175, 'Dancing Sword', '$2111', 'Dancing Sword', 'L1Monster', 2513, 55, 1059, 10, -50, 17, 12, 20, 5, 6, 40, 3026, -39, 'small', 1, 2, 0, 480, 1120, 1440, 1120, 1120, 0, 0, 0, 1, 1, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 4, 0, 0, 0, 0, 0),
   (46176, 'Ball Lightning', '$2485', 'Ball Lightning', 'L1Monster', 2727, 55, 1059, 50, -50, 16, 17, 18, 15, 16, 45, 3026, -10, 'small', 1, 1, 0, 960, 920, 0, 920, 1280, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46177, 'Elder', '$19', 'Elder', 'L1Monster', 32, 55, 1059, 50, -35, 10, 14, 10, 16, 16, 30, 3026, 200, 'small', 1, 1, 1, 800, 1800, 840, 720, 960, 0, 0, 0, 1, 1, 0, 'elder', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46178, 'Cimaera', '$2107', 'Cimaera', 'L1Monster', 2407, 55, 1059, 50, -35, 19, 18, 16, 8, 8, 35, 3026, -40, 'small', 1, 2, 1, 960, 1440, 1560, 1440, 1440, 0, 1, 0, 1, 1, 0, 'cimaera', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46179, 'Ramia', '$1428', 'Ramia', 'L1Monster', 1597, 56, 1098, 50, -36, 15, 15, 12, 12, 10, 10, 3137, -25, 'large', 1, 1, 0, 960, 1880, 2720, 1880, 1880, 0, 1, 0, 1, 0, 0, 'lahmia', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46180, 'Ramia', '$1428', 'Ramia', 'L1Monster', 1600, 56, 1098, 50, -36, 15, 15, 12, 12, 10, 10, 3137, -25, 'large', 1, 1, 0, 960, 1880, 2720, 1880, 1880, 0, 1, 0, 1, 0, 0, 'lahmia', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46181, 'Dark Elder', '$992', 'Dark Elder', 'L1Monster', 183, 57, 1137, 50, -37, 12, 15, 12, 17, 17, 90, 3250, -50, 'small', 1, 1, 0, 640, 880, 800, 600, 800, 0, 0, 0, 1, 1, 1, 'elder', 1, -1, -1, 0, 0, 0, 5000, 200, 5000, 200, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 3, 1, 0, 0, 0, 0),
   (46182, 'Black Wizard', '$3141', 'Black Wizard', 'L1Monster', 5212, 58, 1177, 50, -38, 16, 20, 18, 18, 18, 80, 3365, -50, 'small', 1, 1, 0, 960, 1160, 1080, 1160, 1080, 0, 0, 0, 1, 1, 1, 'blackwizard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46183, 'Death', '$1562', 'Death', 'L1Monster', 1576, 58, 1177, 50, -53, 12, 11, 11, 9, 13, 9, 3365, -28, 'small', 1, 1, 1, 640, 2280, 2080, 2280, 2280, 1, 0, 0, 1, 1, 0, 'death', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46184, 'Silhouette', '$1404', 'Silhouette', 'L1Monster', 1571, 58, 1177, 50, -53, 14, 8, 16, 12, 14, 30, 3365, -14, 'small', 1, 1, 1, 640, 1920, 1760, 1920, 1920, 1, 0, 0, 1, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46185, 'Ghost', '$1563', 'Ghost', 'L1Monster', 3364, 59, 1218, 50, -54, 11, 11, 11, 9, 13, 45, 3482, -10, 'small', 1, 1, 1, 960, 1240, 1080, 640, 640, 1, 0, 0, 0, 0, 0, 'ghost', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46186, 'Depraved Soul', '$2658', 'Depraved Soul', 'L1Monster', 8457, 59, 1345, 50, -57, 75, 18, 17, 15, 17, 50, 3482, -120, 'small', 1, 2, 0, 640, 680, 1080, 960, 1040, 0, 0, 0, 0, 1, 0, 'daemon', 1, -1, -1, 0, 0, 0, 5000, 40, 5000, 20, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (46187, 'Shadow of Beleth', '$11515', 'Shadow of Beleth', 'L1Monster', 1011, 60, 1260, 50, -55, 68, 20, 18, 18, 17, 80, 3601, -5, 'small', 1, 2, 0, 480, 760, 800, 800, 1040, 2, 0, 0, 1, 1, 1, 'daemon', 1, -1, -1, 0, 0, 0, 5000, 15, 5000, 40, 0, 0, 0, 0, 0, 0, 0, 4, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46188, 'Varlok`s Servant', '$2360', 'Varlok`s Servant', 'L1Monster', 2763, 59, 1218, 50, -54, 9, 11, 14, 12, 12, 75, 3482, -10, 'large', 1, 1, 0, 960, 920, 0, 1480, 1480, 2, 0, 0, 1, 1, 1, 'daemon', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46189, 'Lesser Demon', '$2112', 'Lesser Demon', 'L1Monster', 2524, 60, 1260, 50, -55, 20, 17, 16, 12, 14, 80, 3601, -60, 'small', 1, 1, 0, 720, 720, 1040, 1040, 1200, 2, 0, 0, 1, 1, 1, 'daemon', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46190, 'Shadow of Baphomet', '$11516', 'Shadow of Baphomet', 'L1Monster', 53, 62, 1345, 50, -57, 68, 20, 18, 17, 16, 80, 3845, -100, 'small', 1, 1, 0, 480, 760, 800, 800, 1040, 2, 0, 0, 1, 1, 1, 'daemon', 0, -1, -1, 0, 0, 0, 5000, 300, 5000, 30, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (46191, 'Gargoyle', '$2102', 'Gargoyle', 'L1Monster', 2308, 61, 1302, 50, -56, 0, 0, 0, 0, 99, 50, 3722, -30, 'large', 1, 2, 0, 960, 1240, 1240, 1240, 1240, 0, 0, 0, 1, 1, 0, 'daemon', 0, -1, -1, 0, 0, 0, 5000, 55, 5000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46192, 'Pasaj', '$4336', 'Pasaj', 'L1Monster', 5461, 62, 1345, 50, -57, 35, 21, 11, 21, 18, 100, 0, 0, 'large', 1, 1, 0, 800, 960, 0, 1200, 1200, 2, 0, 0, 1, 1, 1, 'daemon', 0, -1, -1, 0, 0, 0, 5000, 10, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46193, 0, 0, 0, 0, 0, 0, 0),
   (46193, 'Pasaj', '$4336', 'Pasaj', 'L1Monster', 5463, 62, 1345, 50, -57, 35, 21, 11, 21, 18, 100, 3845, -5, 'large', 1, 1, 0, 960, 1000, 1120, 1000, 1120, 2, 0, 0, 1, 1, 1, 'daemon', 0, -1, -1, 0, 0, 0, 5000, 10, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46194, 'Incarnation of Varlok', '$3414', 'Incarnation of Varlok', 'L1Monster', 2538, 63, 1389, 50, -58, 70, 20, 18, 20, 20, 70, 3970, -5, 'large', 1, 3, 0, 960, 1520, 1400, 1720, 1520, 2, 0, 0, 1, 1, 1, 'daemon', 1, -1, -1, 0, 0, 0, 5000, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46195, 'Shadow of Demon', '$11517', 'Shadow of Demon', 'L1Monster', 4034, 63, 1389, 50, -58, 20, 20, 20, 18, 20, 60, 3970, -100, 'small', 1, 3, 0, 640, 720, 1760, 880, 960, 2, 0, 0, 0, 0, 0, 'daemon', 1, -1, -1, 0, 0, 0, 5000, 40, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (46196, 'Shadow of Hardin', '$11514', 'Shadow of Hardin', 'L1Monster', 7463, 60, 5000, 50, -50, 8, 12, 7, 16, 38, 99, 3601, 200, 'small', 1, 3, 0, 640, 680, 0, 640, 720, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 40, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46197, 'Maetnob', '$12332', 'Maetnob', 'L1Teleporter', 3232, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46198, 'Maetnob`s blaze', '$12367', 'Maetnob`s blaze', 'L1Teleporter', 7009, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 800, 0, 1320, 1480, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46199, 'Maetnob`s blaze', '$12367', 'Maetnob`s blaze', 'L1Teleporter', 7009, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 800, 0, 1320, 1480, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46200, 'Maetnob`s blaze', '$12367', 'Maetnob`s blaze', 'L1Teleporter', 7009, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 800, 0, 1320, 1480, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46201, 'Maetnob`s blaze', '$12367', 'Maetnob`s blaze', 'L1Teleporter', 7009, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 800, 0, 1320, 1480, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46202, 'Maetnob`s blaze', '$12367', 'Maetnob`s blaze', 'L1Teleporter', 7009, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 800, 0, 1320, 1480, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46203, 'Maetnob`s blaze', '$12367', 'Maetnob`s blaze', 'L1Teleporter', 7009, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 800, 0, 1320, 1480, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46204, 'Maetnob`s blaze', '$12367', 'Maetnob`s blaze', 'L1Teleporter', 7009, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 800, 0, 1320, 1480, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46205, 'Maetnob`s blaze', '$12367', 'Maetnob`s blaze', 'L1Teleporter', 7009, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 800, 0, 1320, 1480, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46206, 'Maetnob`s blaze', '$12367', 'Maetnob`s blaze', 'L1Teleporter', 7009, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 800, 0, 1320, 1480, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46207, 'Maetnob`s blaze', '$12367', 'Maetnob`s blaze', 'L1Teleporter', 7009, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 800, 0, 1320, 1480, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46208, 'Break point', '', 'Tower of Arrogance', 'L1FieldObject', 7572, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46209, 'Mubni', '$12331', 'Mubni', 'L1Merchant', 3232, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46210, 'Reaper`s Watcher', '$12410', 'Reaper`s Watcher', 'L1Monster', 3092, 55, 1800, 400, -60, 25, 20, 20, 25, 15, 70, 3026, -250, 'small', 2, 1, 0, 480, 1400, 1320, 1400, 1400, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 45513, 0, 0, 0, 0, 0, 0, 0),
   (46211, 'Reaper`s Watcher', '$12410', 'Reaper`s Watcher', 'L1Monster', 3092, 55, 1800, 400, -60, 25, 20, 20, 25, 15, 70, 3026, -250, 'small', 2, 1, 0, 480, 1400, 1320, 1400, 1400, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 45547, 0, 0, 0, 0, 0, 0, 0),
   (46212, 'Reaper`s Watcher', '$12410', 'Reaper`s Watcher', 'L1Monster', 3092, 55, 1800, 400, -60, 25, 20, 20, 25, 15, 70, 3026, -250, 'small', 2, 1, 0, 480, 1400, 1320, 1400, 1400, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 45606, 0, 0, 0, 0, 0, 0, 0),
   (46213, 'Reaper`s Watcher', '$12410', 'Reaper`s Watcher', 'L1Monster', 3092, 55, 1800, 400, -60, 25, 20, 20, 25, 15, 70, 3026, -250, 'small', 2, 1, 0, 480, 1400, 1320, 1400, 1400, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 45650, 0, 0, 0, 0, 0, 0, 0),
   (46214, 'Reaper`s Watcher', '$12410', 'Reaper`s Watcher', 'L1Monster', 3092, 55, 1800, 400, -60, 25, 20, 20, 25, 15, 70, 3026, -250, 'small', 2, 1, 0, 480, 1400, 1320, 1400, 1400, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 45652, 0, 0, 0, 0, 0, 0, 0),
   (46215, 'Reaper`s Watcher', '$12410', 'Reaper`s Watcher', 'L1Monster', 3092, 55, 1800, 400, -60, 25, 20, 20, 25, 15, 70, 3026, -250, 'small', 2, 1, 0, 480, 1400, 1320, 1400, 1400, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 45653, 0, 0, 0, 0, 0, 0, 0),
   (46216, 'Reaper`s Watcher', '$12410', 'Reaper`s Watcher', 'L1Monster', 3092, 55, 1800, 400, -60, 25, 20, 20, 25, 15, 70, 3026, -250, 'small', 2, 1, 0, 480, 1400, 1320, 1400, 1400, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 45654, 0, 0, 0, 0, 0, 0, 0),
   (46217, 'Reaper`s Watcher', '$12410', 'Reaper`s Watcher', 'L1Monster', 3092, 55, 1800, 400, -60, 25, 20, 20, 25, 15, 70, 3026, -250, 'small', 2, 1, 0, 480, 1400, 1320, 1400, 1400, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 45618, 0, 0, 0, 0, 0, 0, 0),
   (46218, 'Reaper`s Watcher', '$12410', 'Reaper`s Watcher', 'L1Monster', 3092, 55, 1800, 400, -60, 25, 20, 20, 25, 15, 70, 3026, -250, 'small', 2, 1, 0, 480, 1400, 1320, 1400, 1400, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 45672, 0, 0, 0, 0, 0, 0, 0),
   (46219, 'Reaper`s Watcher', '$12410', 'Reaper`s Watcher', 'L1Monster', 3092, 55, 1800, 400, -60, 25, 20, 20, 25, 15, 70, 3026, -250, 'small', 2, 1, 0, 480, 1400, 1320, 1400, 1400, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 46220, 0, 0, 0, 0, 0, 0, 0),
   (46220, 'Ugnus', '$12447', 'Ugnus', 'L1Monster', 7723, 65, 14500, 2250, -60, 20, 20, 20, 22, 18, 45, 4226, -250, 'large', 0, 2, 0, 640, 960, 1320, 1480, 2760, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 250, 5000, 150, 0, 0, 0, 0, 0, 0, 0, 15, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (46221, 'Mutant Ramia', '$2382', 'Mutant Ramia', 'L1Monster', 1597, 32, 330, 45, -10, 15, 15, 12, 12, 10, 15, 1025, -35, 'large', 0, 1, 0, 960, 1880, 2720, 1880, 1880, 0, 1, 0, 1, 1, 1, 'lahmia', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46210, 0, 0, 0, 0, 0, 0, 0),
   (46222, 'Mutant Arachnevil Elder', '$2381', 'Mutant Arachnevil Elder', 'L1Monster', 146, 33, 370, 20, -13, 18, 16, 14, 6, 5, 20, 1090, -40, 'large', 0, 2, 0, 480, 840, 0, 1680, 1680, 0, 1, 0, 1, 1, 1, 'spider', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46210, 0, 0, 0, 0, 0, 0, 0),
   (46223, 'Medusa', '$2113', 'Medusa', 'L1Monster', 2535, 44, 400, 120, -15, 17, 18, 16, 17, 15, 50, 1297, -39, 'small', 0, 1, 0, 960, 1200, 0, 1280, 1200, 0, 0, 1, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 40, 5000, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46210, 0, 14, 0, 0, 0, 0, 0),
   (46224, 'Cimaera', '$2107', 'Cimaera', 'L1Monster', 2407, 39, 550, 40, -25, 19, 18, 16, 8, 8, 35, 1522, -40, 'small', 0, 2, 1, 960, 1440, 1560, 1440, 1440, 0, 1, 0, 1, 1, 0, 'cimaera', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46210, 0, 0, 0, 0, 0, 0, 0),
   (46225, 'Cockatrice', '$969', 'Cockatrice', 'L1Monster', 1052, 34, 450, 100, -15, 25, 18, 18, 12, 12, 30, 1157, -36, 'large', 1, 1, 0, 520, 1040, 0, 1760, 1760, 0, 0, 2, 1, 1, 0, 'cockatrice', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46210, 0, 0, 0, 0, 0, 0, 0),
   (46226, 'Succubus', '$1000', 'Succubus', 'L1Monster', 1112, 37, 400, 250, -25, 15, 15, 18, 25, 18, 50, 1370, -40, 'small', 2, 1, 0, 640, 800, 1080, 1440, 800, 2, 0, 0, 1, 1, 1, 'succubus', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46211, 0, 0, 0, 0, 0, 0, 0),
   (46227, 'Dire Wolf', '$2105', 'Dire Wolf', 'L1Monster', 2392, 40, 600, 20, -30, 22, 17, 18, 15, 16, 35, 1601, -36, 'large', 0, 2, 0, 480, 1440, 1760, 1440, 1440, 0, 0, 0, 1, 1, 1, 'direwolf', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46211, 0, 0, 0, 0, 0, 0, 0),
   (46228, 'Wicked Mimic', '$2384', 'Wicked Mimic', 'L1Monster', 1479, 38, 500, 30, -2, 16, 12, 14, 11, 10, 40, 1445, -25, 'small', 0, 1, 0, 1280, 1120, 0, 1120, 1120, 0, 0, 0, 1, 1, 0, '', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 46211, 0, 0, 0, 0, 0, 0, 0),
   (46229, 'Wicked Beholder', '$2383', 'Wicked Beholder', 'L1Monster', 1123, 39, 540, 600, -20, 12, 15, 14, 18, 18, 55, 1522, -30, 'large', 0, 1, 0, 960, 1120, 0, 1480, 1120, 0, 0, 1, 1, 1, 1, 'gazer', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46211, 0, 0, 0, 0, 0, 0, 0),
   (46239, 'Dancing Sword', '$2111', 'Dancing Sword', 'L1Monster', 2513, 37, 380, 0, -43, 17, 12, 20, 5, 6, 40, 1370, -39, 'small', 0, 2, 0, 480, 1120, 1440, 1120, 1120, 0, 0, 0, 1, 1, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46211, 0, 4, 0, 0, 0, 0, 0),
   (46240, 'Horrific Fire Egg', '$2386', 'Horrific Fire Egg', 'L1Monster', 1820, 37, 500, 15, -36, 16, 18, 16, 12, 16, 40, 1370, -35, 'small', 0, 1, 0, 1440, 880, 880, 1000, 1000, 0, 0, 0, 1, 1, 1, 'fireegg', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46212, 0, 0, 0, 0, 0, 0, 0),
   (46241, 'Nightmare', '$2103', 'Nightmare', 'L1Monster', 2332, 40, 450, 0, -42, 12, 10, 15, 8, 8, 80, 1601, -38, 'large', 0, 2, 0, 480, 1600, 2240, 1600, 1600, 2, 0, 0, 1, 1, 1, 'nightmare', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46212, 0, 4, 0, 0, 0, 0, 0),
   (46242, 'Horrific Cerberus', '$2385', 'Horrific Cerberus', 'L1Monster', 951, 43, 350, 105, -35, 17, 18, 15, 12, 16, 25, 1850, -40, 'small', 0, 1, 0, 640, 1040, 1840, 1840, 1840, 2, 0, 0, 1, 1, 1, 'cerberus', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46212, 0, 0, 0, 0, 0, 0, 0),
   (46243, 'Lesser Demon', '$2112', 'Transformed into an observer reaper', 'L1Monster', 2524, 44, 420, 100, -38, 20, 17, 16, 12, 14, 80, 1937, -60, 'small', 0, 1, 0, 720, 720, 1040, 1040, 1200, 2, 0, 0, 1, 1, 1, 'daemon', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46212, 0, 14, 0, 0, 0, 0, 0),
   (46244, 'Ifrit', '$1567', 'Transformed into an observer reaper', 'L1Monster', 1773, 46, 1100, 300, -28, 20, 18, 18, 18, 18, 40, 2117, -55, 'large', 4, 1, 0, 960, 1640, 0, 1200, 1640, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46212, 0, 0, 0, 0, 0, 0, 0),
   (46245, 'Ragin Skeleton Axeman', '$2389', 'Transformed into an observer reaper', 'L1Monster', 1104, 39, 500, 50, -30, 18, 14, 14, 12, 10, 25, 1522, -30, 'small', 0, 1, 0, 480, 840, 840, 1680, 1680, 1, 0, 0, 1, 1, 1, 'skeleton', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 46213, 0, 0, 0, 0, 0, 0, 0),
   (46246, 'Bone Dragon', '$2392', 'Transformed into an observer reaper', 'L1Monster', 144, 42, 550, 70, -35, 16, 17, 16, 11, 12, 45, 1764, -50, 'small', 0, 1, 0, 1280, 720, 0, 1440, 1440, 1, 4, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 46213, 0, 0, 0, 0, 0, 0, 0),
   (46247, 'Raging Skeleton Pike', '$2391', 'Transformed into an observer reaper', 'L1Monster', 1106, 39, 450, 45, -30, 16, 14, 15, 12, 10, 35, 1522, -30, 'small', 0, 2, 0, 640, 880, 840, 1680, 1680, 1, 0, 0, 1, 1, 1, 'skeleton', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 46213, 0, 0, 0, 0, 0, 0, 0),
   (46248, 'Raging Spartoi', '$2387', 'Transformed into an observer reaper', 'L1Monster', 145, 42, 550, 50, -38, 17, 15, 16, 14, 14, 40, 1764, -35, 'small', 0, 1, 0, 800, 920, 0, 1440, 1440, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 46213, 0, 0, 0, 0, 0, 0, 0),
   (46249, 'Raging Skeleton Marksman', '$2390', 'Transformed into an observer reaper', 'L1Monster', 1130, 45, 650, 100, -38, 16, 14, 16, 16, 16, 45, 2026, -48, 'small', 0, 10, 0, 800, 1120, 920, 1840, 1840, 1, 0, 0, 1, 1, 1, 'skeleton', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 66, 0, 46213, 0, 0, 0, 0, 0, 0, 0),
   (46250, 'Raging Skeleton Fighter', '$2388', 'Transformed into an observer reaper', 'L1Monster', 1132, 45, 700, 90, -40, 18, 14, 14, 14, 14, 45, 2026, -50, 'small', 0, 1, 0, 480, 840, 840, 1680, 1680, 1, 0, 0, 1, 1, 1, 'skeleton', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 46213, 0, 0, 0, 0, 0, 0, 0),
   (46251, 'Lesser Dragon', '$2104', 'Transformed into an observer reaper', 'L1Monster', 2379, 45, 800, 120, -45, 35, 18, 12, 18, 18, 60, 2026, -45, 'large', 0, 1, 0, 960, 1360, 0, 1800, 1360, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 46214, 0, 14, 0, 0, 0, 0, 0),
   (46252, 'Fire Ghost', '$2393', 'Transformed into an observer reaper (Red)', 'L1Monster', 1321, 45, 500, 25, -45, 18, 14, 14, 14, 14, 45, 2026, -30, 'small', 0, 1, 0, 960, 1000, 1440, 1000, 1000, 1, 0, 0, 1, 1, 1, 'ghost', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 46214, 0, 0, 0, 0, 0, 0, 0),
   (46253, 'Fire Ghost', '$2393', 'Transformed into an observer reaper (Green)', 'L1Monster', 1318, 46, 500, 25, -48, 18, 14, 14, 14, 14, 45, 2117, -30, 'small', 0, 1, 0, 960, 1000, 1440, 1000, 1000, 1, 0, 0, 1, 1, 1, 'ghost', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 46214, 0, 0, 0, 0, 0, 0, 0),
   (46254, 'Horrific Iron Golem', '$2407', 'Transformed into an observer reaper', 'L1Monster', 2147, 44, 800, 20, -37, 70, 18, 18, 10, 10, 35, 1937, -90, 'large', 0, 1, 0, 1920, 1760, 2080, 1760, 1760, 0, 0, 0, 1, 1, 1, 'golem', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 46214, 0, 4, 0, 0, 0, 0, 0),
   (46255, 'Fire Necromancer', '$2394', 'Transformed into an observer reaper', 'L1Monster', 173, 44, 450, 250, -32, 12, 15, 12, 17, 17, 90, 1937, -50, 'small', 0, 1, 0, 640, 1480, 800, 800, 1120, 0, 0, 0, 1, 1, 1, 'necromansar', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 46214, 0, 4, 0, 0, 0, 0, 0),
   (46256, 'Bone Dragon', '$2108', 'Transformed into an observer reaper', 'L1Monster', 2409, 47, 720, 140, -48, 32, 16, 11, 18, 18, 90, 2210, -50, 'large', 0, 1, 0, 960, 1280, 0, 1760, 1280, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 46214, 0, 14, 0, 0, 0, 0, 0),
   (46257, 'Cursed Orc Zombie', '$2610', 'Transformed into an observer reaper', 'L1Monster', 1121, 42, 800, 25, -60, 10, 10, 10, 7, 14, 25, 1765, -10, 'small', 0, 1, 0, 1440, 1800, 0, 1800, 1800, 1, 1, 0, 1, 1, 1, 'zombie', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 46215, 0, 0, 0, 0, 0, 0, 0),
   (46258, 'Cursed Elmore Soldier', '$2611', 'Transformed into an observer reaper', 'L1Monster', 2150, 47, 700, 20, -61, 16, 16, 17, 12, 15, 30, 2210, -20, 'small', 0, 2, 0, 480, 1040, 1400, 1040, 1040, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 46215, 0, 0, 0, 0, 0, 0, 0),
   (46259, 'Cursed Elmore Wizard', '$2612', 'Transformed into an observer reaper', 'L1Monster', 2112, 45, 300, 100, -62, 15, 17, 10, 10, 19, 90, 2026, -20, 'small', 0, 1, 0, 1440, 1920, 1600, 1440, 1920, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 46215, 0, 0, 0, 0, 0, 0, 0),
   (46260, 'Cursed Elmore General', '$2613', 'Transformed into an observer reaper', 'L1Monster', 2137, 50, 750, 100, -63, 17, 18, 15, 12, 15, 40, 2501, -25, 'small', 0, 1, 0, 960, 1200, 1280, 1200, 1200, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 46215, 0, 0, 0, 0, 0, 0, 0),
   (46261, 'Dark Lycanthrope', '$2614', 'Transformed into an observer reaper', 'L1Monster', 1108, 44, 750, 60, -64, 16, 16, 18, 10, 12, 45, 1937, -18, 'small', 0, 1, 0, 640, 800, 720, 1440, 1440, 5, 0, 0, 1, 1, 1, 'wolf', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46216, 0, 0, 0, 0, 0, 0, 0),
   (46262, 'Cruel Snow Tiger', '$2615', 'Transformed into an observer reaper', 'L1Monster', 2086, 48, 850, 50, -64, 19, 18, 17, 12, 10, 20, 2305, -25, 'large', 0, 1, 0, 960, 1360, 1400, 1360, 1360, 0, 0, 0, 1, 1, 1, 'tiger', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46216, 0, 0, 0, 0, 0, 0, 0),
   (46263, 'Spirit Taurverus of Fire', '$2616', 'Transformed into an observer reaper', 'L1Monster', 1780, 46, 830, 80, -65, 20, 20, 18, 18, 18, 55, 2117, -50, 'small', 0, 0, 0, 880, 1000, 1000, 1360, 1440, 2, 0, 0, 1, 1, 1, 'cerberus', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46216, 0, 0, 0, 0, 0, 0, 0),
   (46264, 'Astagio of Fire', '$2617', 'Transformed into an observer reaper', 'L1Monster', 1841, 51, 900, 30, -65, 22, 18, 22, 11, 10, 50, 2602, -30, 'large', 0, 1, 0, 1120, 1360, 1800, 1000, 1000, 0, 0, 0, 1, 1, 1, 'asitagio', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46216, 0, 0, 0, 0, 0, 0, 0),
   (46265, 'Black Knight of Darkness', '$2618', 'Transformed into an observer reaper', 'L1Monster', 4003, 45, 900, 10, -67, 19, 16, 17, 12, 12, 65, 2026, -15, 'small', 0, 2, 0, 480, 1120, 760, 760, 760, 0, 0, 0, 1, 1, 0, 'antiking', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 46217, 0, 14, 0, 0, 0, 0, 0),
   (46266, 'Fire Warrior of Darkness', '$2619', 'Transformed into an observer reaper', 'L1Monster', 1770, 50, 950, 20, -64, 18, 10, 18, 12, 15, 30, 2501, -25, 'small', 0, 2, 0, 960, 1520, 1480, 1520, 1520, 0, 0, 0, 1, 1, 1, 'burningwarrior', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46217, 0, 0, 0, 0, 0, 0, 0),
   (46267, 'Fire Archer of Darkness', '$2620', 'Transformed into an observer reaper', 'L1Monster', 1832, 48, 800, 20, -58, 13, 10, 20, 11, 12, 45, 2305, -25, 'small', 0, 10, 0, 960, 2000, 1320, 2360, 2360, 0, 0, 0, 1, 1, 1, 'burningarcher', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 66, 0, 46217, 0, 0, 0, 0, 0, 0, 0),
   (46268, 'Succubus Queen of Darkness', '$2621', 'Transformed into an observer reaper', 'L1Monster', 1116, 53, 1800, 400, -70, 17, 17, 18, 25, 18, 80, 2810, -50, 'small', 0, 1, 0, 640, 800, 1080, 1080, 800, 2, 0, 0, 1, 1, 1, 'succubus', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 46217, 0, 0, 0, 0, 0, 0, 0),
   (46269, 'Insolent Zenith Queen', '$2622', 'Transformed into an observer reaper', 'L1Monster', 2807, 53, 1800, 250, -65, 25, 18, 18, 18, 18, 100, 2810, -70, 'large', 0, 1, 0, 480, 1480, 0, 1680, 1840, 0, 1, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46218, 0, 2, 0, 0, 0, 0, 0),
   (46270, 'Lesser Seer', '$2623', 'Transformed into an observer reaper', 'L1Monster', 2773, 54, 1600, 350, -63, 15, 15, 15, 18, 18, 99, 2917, -60, 'large', 0, 1, 0, 480, 1440, 0, 1280, 1440, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46218, 0, 0, 0, 0, 0, 0, 0),
   (46271, 'Marquise Vampire', '$2624', 'Transformed into an observer reaper', 'L1Monster', 2757, 56, 2500, 500, -63, 13, 13, 13, 20, 20, 65, 3137, -100, 'small', 0, 1, 0, 960, 1040, 0, 1040, 2240, 2, 0, 0, 1, 1, 1, 'vampire', 1, -1, -1, 0, 0, 0, 0, 0, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46218, 0, 0, 0, 0, 0, 0, 0),
   (46272, 'Zombie Lord of Fear', '$2625', 'Transformed into an observer reaper', 'L1Monster', 2803, 55, 3500, 100, -68, 22, 25, 18, 10, 15, 40, 3026, -180, 'large', 0, 2, 0, 1440, 1880, 0, 1240, 1760, 3, 0, 0, 1, 1, 1, 'zombie', 0, -1, -1, 0, 0, 0, 0, 0, 5000, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46218, 0, 0, 0, 0, 0, 0, 0),
   (46273, 'Great Spirit of Earth', '$2551', 'Transformed into an observer reaper', 'L1Monster', 2749, 60, 2500, 500, -66, 25, 13, 13, 13, 18, 50, 3601, -80, 'large', 2, 2, 0, 960, 1360, 0, 1360, 1240, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 100, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46219, 0, 0, 0, 0, 0, 0, 0),
   (46274, 'Great Spirit of Water', '$2482', 'Transformed into an observer reaper', 'L1Monster', 2738, 60, 2500, 500, -66, 25, 13, 13, 13, 18, 50, 3601, -80, 'large', 0, 2, 0, 960, 2240, 0, 2240, 2240, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 100, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46219, 0, 14, 0, 0, 0, 0, 0),
   (46275, 'Great Spirit of Wind', '$2483', 'Transformed into an observer reaper', 'L1Monster', 2741, 60, 2500, 500, -66, 25, 13, 13, 13, 18, 50, 3601, -80, 'large', 1, 2, 0, 960, 2080, 0, 2080, 2040, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 100, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46219, 0, 14, 0, 0, 0, 0, 0),
   (46276, 'Great Spirit of Fire', '$2481', 'Transformed into an observer reaper', 'L1Monster', 2747, 60, 2500, 500, -66, 25, 13, 13, 13, 18, 50, 3601, -80, 'large', 4, 2, 0, 960, 1200, 0, 1200, 1160, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 100, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46219, 0, 0, 0, 0, 0, 0, 0),
   (46277, 'Iris', '$2609', 'Transformed into an observer reaper', 'L1Monster', 3180, 55, 2500, 900, -70, 25, 13, 13, 13, 18, 80, 3026, -80, 'small', 0, 1, 0, 1040, 1400, 1920, 1240, 1240, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 5000, 250, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46219, 0, 14, 0, 0, 0, 0, 0),
   (46278, 'Mummy Lord', '$2589', 'Transformed into an observer reaper', 'L1Monster', 3086, 58, 4000, 750, -55, 20, 15, 14, 22, 22, 80, 3365, -250, 'large', 0, 1, 0, 1200, 440, 680, 440, 440, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 5000, 250, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46219, 0, 0, 0, 0, 0, 0, 0),
   (46279, 'Knight Vlad', '$2588', 'Transformed into an observer reaper', 'L1Monster', 3066, 60, 5000, 600, -65, 25, 25, 25, 8, 15, 55, 3601, -100, 'small', 0, 1, 0, 1360, 640, 1480, 1240, 1240, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 5000, 400, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46219, 0, 0, 0, 0, 0, 0, 0),
   (46280, 'Losen', '$8560', 'Talking Island', 'L1Merchant', 2090, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46281, 'Derysto', '$8567', 'Gludin', 'L1Merchant', 2090, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46282, 'Liost', '$8569', 'Oren', 'L1Merchant', 2090, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46283, 'Leoberyn', '$8594', 'Gludin', 'L1Merchant', 2090, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46284, 'Seton', '$8564', 'Windawood', 'L1Merchant', 2090, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46285, 'Sharylnn', '$8566', 'Silver Knight Town', 'L1Merchant', 2090, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46286, 'Fehas', '$8568', 'Heine', 'L1Merchant', 2090, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46287, 'Pramas', '$8562', 'Kent', 'L1Merchant', 2090, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46288, 'Alheres', '$8563', 'Hitamura', 'L1Merchant', 2090, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46289, 'Rubarlmong', '$8565', 'Werldern', 'L1Merchant', 2090, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46290, 'Sanokichi', '$13561', 'Japan Event', 'L1Merchant', 10491, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46291, 'Shellman', '$4733', 'Underground Lake', 'L1Monster', 5767, 80, 12000, 5000, -78, 25, 25, 25, 25, 25, 80, 6401, -1000, 'large', 0, 1, 0, 0, 1040, 1080, 1040, 1120, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46292, 'Giant Hydra', '$4734', 'Underground Lake', 'L1Monster', 5802, 50, 800, 1000, -40, 20, 20, 20, 20, 20, 40, 2501, -200, 'large', 8, 1, 0, 0, 1040, 0, 1080, 1080, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (46293, 'Sanokichi', '$13561', 'Hinomoto Update', 'L1Teleporter', 10491, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46294, 'Crack of Time', '', 'Hinomoto Update', 'L1FieldObject', 11203, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46295, 'Tosuke', '$14451', 'Hinomoto Update', 'L1Merchant', 11102, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46296, 'Korokuro', '$14452', 'Hinomoto Update', 'L1Merchant', 11104, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46297, 'Mankichi', '$14453', 'Hinomoto Update', 'L1Merchant', 11105, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46298, 'Hiyoshi Maru', '$14454', 'Hinomoto Update', 'L1Merchant', 11103, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (46299, 'Hinomoto`s privilege', '$14381', 'Hinomoto Update', 'L1Merchant', 10490, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (50085, 'Orb of Spirit', '$3551', 'Spirit Grave (East)', 'L1Teleporter', 4047, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (50086, 'Orb of Spirit', '$3551', 'Spirit Grave (Southeast)', 'L1Teleporter', 4047, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (50087, 'Orb of Spirit', '$3551', 'Spirit Grave (South)', 'L1Teleporter', 4047, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (50088, 'Orb of Spirit', '$3551', 'Spirit Grave (West)', 'L1Teleporter', 4047, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (51000, 'Traveling Man', 'Traveling Man', 'Farthest palace', 'L1Teleporter', 2293, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 1, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (51001, 'Red Lotus', 'Red Lotus', 'Farthest Temple', 'L1Monster', 2524, 25, 300, 100, -38, 15, 17, 16, 12, 12, 80, 626, -60, 'small', 4, 1, 0, 720, 720, 1040, 1040, 1200, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (51002, 'Robbery', 'Robbery', 'Farthest Temple', 'L1Monster', 1011, 31, 450, 350, -66, 15, 30, 18, 20, 12, 80, 962, -100, 'small', 4, 1, 0, 480, 760, 800, 800, 1040, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (51003, 'Business Fire', 'Business Fire', 'Farthest Temple', 'L1Monster', 2379, 31, 400, 120, -45, 16, 18, 12, 18, 15, 60, 962, -45, 'large', 4, 1, 0, 960, 1360, 0, 1800, 1360, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (51004, 'Explosion', 'Explosion', 'Farthest Temple', 'L1Monster', 1180, 35, 500, 300, -60, 18, 21, 21, 21, 18, 100, 1226, -5, 'large', 4, 1, 0, 1280, 960, 0, 1360, 1760, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (51005, 'Evil Flame', 'Evil Flame', 'Farthest Temple', 'L1Monster', 4034, 35, 500, 300, -60, 18, 21, 21, 21, 18, 100, 1226, -5, 'large', 4, 1, 0, 1280, 960, 0, 1360, 1760, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (51006, 'Scorching', 'Scorching', 'Farthest Temple', 'L1Monster', 1773, 38, 650, 300, -38, 18, 18, 18, 18, 18, 80, 1445, -55, 'large', 4, 1, 0, 960, 1640, 0, 1200, 1640, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (51007, 'Scorching', 'Scorching', 'Farthest Temple', 'L1Monster', 2538, 38, 1000, 500, -60, 20, 20, 18, 20, 20, 70, 1445, -5, 'large', 4, 3, 0, 960, 1520, 1400, 1720, 1520, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (51008, 'Emperor Yan', 'Emperor Yan', 'Farthest Temple', 'L1Monster', 1791, 56, 5000, 200, -68, 25, 20, 20, 25, 25, 100, 3137, -130, 'large', 4, 2, 0, 960, 1600, 0, 1920, 1600, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 300, 5000, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (51009, 'Farthest Treasure', 'Farthest Treasure', 'Farthest Temple', 'L1Monster', 7805, 55, 5000, 900, -75, 20, 15, 18, 12, 15, 99, 4097, -80, 'small', 4, 2, 0, 480, 720, 1600, 1240, 1240, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (51010, 'Beast Flame', 'Beast Flame', 'Farthest Temple', 'L1Monster', 5269, 31, 500, 300, -40, 15, 21, 11, 21, 18, 100, 1226, -5, 'small', 4, 1, 0, 960, 1200, 960, 1240, 1240, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, -50, -1, 0, 0, 0, 0, 0, 0, 0),
   (51011, 'Keratitis', 'Keratitis', 'Farthest Temple', 'L1Monster', 5265, 38, 500, 300, -50, 18, 21, 11, 21, 18, 100, 1445, -5, 'large', 4, 1, 0, 960, 1200, 960, 1240, 1240, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, -50, -1, 0, 0, 0, 0, 0, 0, 0),
   (71254, 'Crack of Time', '', '', 'L1FieldObject', 6919, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (71258, 'Marba', '$3989', '', 'L1Merchant', 1621, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1440, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (71259, 'Aras', '$3990', '', 'L1Merchant', 834, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (71260, 'Magic Wall', '', 'Heine 4F - Dragon Lair', 'L1FieldObject', 1758, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (71261, 'butterfly', '', 'Dream Island', 'L1Monster', 2887, 1, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (71271, 'rune wall', '', 'Talking Island Cave 2F', 'L1FieldObject', 134, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 160, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (80154, 'Ramia Magic Doll', '$7450', '', 'L1Doll', 6483, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80155, 'Spartoi Magic Doll', '$7399', '', 'L1Doll', 7257, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80158, 'Rich Magic Doll', 'Rich Magic Doll', '', 'L1Doll', 11092, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80159, 'Doppleganger Magic Doll', 'Doppleganger Magic Doll', '', 'L1Doll', 7516, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80160, 'Sea Dancer Magic Doll', '$5886', '', 'L1Doll', 6477, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80161, 'Load Magic Doll', '$7493', '', 'L1Doll', 5933, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80162, 'Hatchling Magic Doll Azure', '$7901 Azure', '', 'L1Doll', 7662, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 560, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80163, 'Hatchling Magic Doll Crimson', '$7901 Crimson', '', 'L1Doll', 7661, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 720, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80164, 'High-Hatchling Magic Doll Azure', '$7902 Azure', '', 'L1Doll', 7659, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80165, 'High-Hatchling Magic Doll Crimson', '$7902 Crimson', '', 'L1Doll', 7660, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80166, 'Preistess Juris', '$5902', 'The Atonement Bible', 'L1Merchant', 2141, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80167, 'Scroll Labeled ZELGO MER', '$30', 'Transform', 'L1Merchant', 2141, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80169, 'Snowman Magic Doll', '$10149', '', 'L1Doll', 8751, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80170, 'Snowball Battle Fairy', '$10130', '', 'L1Doll', 8751, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80171, 'Beginner Helper', '$8446', 'New Hidden Valley', 'L1Merchant', 5913, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80172, 'Colisium Keeper', '$8447', 'New Hidden Valley', 'L1Merchant', 7868, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 280, 1240, 1160, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80173, 'Asha', '$6084', 'New Hidden Valley', 'L1Teleporter', 6977, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 480, 960, 0, 1360, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80174, 'Faeana', '$6085', 'New Hidden Valley', 'L1Teleporter', 6793, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 480, 920, 0, 1080, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80175, 'Arena Guide', '$1500', 'New Hidden Valley(IN)', 'L1Merchant', 148, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 1, 0, 480, 840, 520, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80176, 'Arena Guide', '$1500', 'New Hidden Valley(OUT)', 'L1Merchant', 148, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 1, 0, 480, 840, 520, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80177, 'Ribian', '$1898', 'New Hidden Valley', 'L1Merchant', 914, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80178, 'Enya', '$2493', 'New Hidden Valley', 'L1Merchant', 2779, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80179, 'dummy', '$8987', 'Beginner support NPC', 'L1Merchant', 2143, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80180, 'traveler helper', '$8481', 'Beginner support NPC', 'L1Merchant', 7868, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 280, 1240, 1160, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80181, 'Bazarl', '$8549', 'Additional Warehouse - Talking Island', 'L1AddWarehouse', 7762, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80182, 'Badarl', '$8550', 'Additional Warehouse - Gludio', 'L1AddWarehouse', 7762, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80183, 'Bagorl', '$8551', 'Additional Warehouse - Gludin', 'L1AddWarehouse', 7762, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80184, 'Basarl', '$8552', 'Additional Warehouse - Aden', 'L1AddWarehouse', 7762, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80185, 'Bamarl', '$8553', 'Additional Warehouse - Oren', 'L1AddWarehouse', 7762, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80186, 'Banorl', '$8554', 'Additional Warehouse - Windawood', 'L1AddWarehouse', 7762, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80187, 'Baorl', '$8555', 'Additional Warehouse - Werldern', 'L1AddWarehouse', 7762, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80188, 'Bahorl', '$8556', 'Additional Warehouse - SKT', 'L1AddWarehouse', 7762, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80189, 'Bakarl', '$8557', 'Additional Warehouse - Kent', 'L1AddWarehouse', 7762, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80190, 'Batorl', '$8558', 'Additional Warehouse - Heine', 'L1AddWarehouse', 7762, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80191, 'Bacharl', '$8559', 'Additional Warehouse - Hitamura', 'L1AddWarehouse', 7762, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80193, 'Trainer', '$5324', 'Kaimopet', 'L1Merchant', 6083, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80194, 'Mini-game Reward Expert Coma', '$7452', '', 'L1Merchant', 1768, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (80195, 'news boy', '$8453', '', 'L1Merchant', 8162, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (80196, 'dummy', '$8984', 'Internet Cafe NPC', 'L1Merchant', 2650, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 1120, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (80197, 'dummy', '$8983', 'Internet Cafe NPC', 'L1Merchant', 2650, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 1120, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (80198, 'dummy', '$8984', 'Internet Cafe NPC', 'L1Merchant', 6083, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80199, 'dummy', '$8985', 'Internet Cafe NPC', 'L1Merchant', 914, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80200, 'dummy', '$9131', 'Internet Cafe NPC', 'L1Merchant', 971, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (80201, 'dummy', '$9130', 'Internet Cafe NPC', 'L1Merchant', 2293, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1440, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80202, 'Wolf', '$268', 'Pets', 'L1Npc', 96, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 480, 1000, 720, 1480, 1480, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80203, 'Doberman', '$905', 'Pets', 'L1Npc', 931, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 560, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80204, 'Beagle', '$908', 'Pets', 'L1Npc', 938, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 720, 960, 1320, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80205, 'Cat', '$2701', 'Pets', 'L1Npc', 3134, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 1040, 1120, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80206, 'Killer Rabbit', '$2563', 'Pets', 'L1Npc', 3783, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 800, 1040, 1120, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80207, 'Sheperd', '$907', 'Pets', 'L1Npc', 936, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 560, 960, 920, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80208, 'Saint Bernard', '$904', 'Pets', 'L1Npc', 929, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 1440, 1480, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80209, 'Bear', '$1495', 'Pets', 'L1Npc', 1642, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 800, 2000, 1120, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80210, 'Fox', '$1397', 'Pets', 'L1Npc', 1540, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 1200, 1440, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80211, 'Husky', '$1788', 'Pets', 'L1Npc', 2145, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 1040, 800, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80212, 'Raccoon', '$3508', 'Pets', 'L1Npc', 4038, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 880, 1600, 720, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80213, 'Werldern Head of Mercenary Squad', '$2931 $2930', 'Changed from 3.3C', 'L1Merchant', 7655, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80214, 'Giant Magic Doll', '$11542', '', 'L1Doll', 8539, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80215, 'Support Giant Magic Doll', '$11543', '', 'L1Doll', 8543, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80216, 'Clever Giant Magic Doll', '$11544', '', 'L1Doll', 8544, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80217, 'Intelligent Giant Magic Doll', '$11545', '', 'L1Doll', 8546, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80218, 'Glowing Giant Magic Doll', '$11546', '', 'L1Doll', 8542, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80219, 'Dazzling Giant Magic Doll', '$11547', '', 'L1Doll', 8545, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80220, 'Cyclops Magic Doll', '$11548', '', 'L1Doll', 8549, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80221, 'Support Cyclops Magic Doll', '$11549', '', 'L1Doll', 8601, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80222, 'Clever Cyclops Magic Doll', '$11550', '', 'L1Doll', 8603, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80223, 'Intelligent Cyclops Magic Doll', '$11551', '', 'L1Doll', 8697, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80224, 'Glowing Cyclops Magic Doll', '$11552', '', 'L1Doll', 8600, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80225, 'Dazzling Cyclops Magic Doll', '$11553', '', 'L1Doll', 8602, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80226, 'Mermaid Magic Doll', '$11468', '', 'L1Doll', 8650, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80227, 'Support Mermaid Magic Doll', '$11469', '', 'L1Doll', 8694, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80228, 'Clever Mermaid Magic Doll', '$11470', '', 'L1Doll', 8695, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80229, 'Intelligent Mermaid Magic Doll', '$11471', '', 'L1Doll', 8696, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80230, 'Glowing Mermaid Magic Doll', '$11472', '', 'L1Doll', 8653, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80231, 'Dazzling Mermaid Magic Doll', '$11473', '', 'L1Doll', 8656, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80232, 'Brute Magic Doll', '$11536', '', 'L1Doll', 8741, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80233, 'Support Brute Magic Doll', '$11537', '', 'L1Doll', 8748, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80234, 'Clever Brute Magic Doll', '$11538', '', 'L1Doll', 8749, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80235, 'Intelligent Brute Magic Doll', '$11539', '', 'L1Doll', 8750, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80236, 'Glowing Brute Magic Doll', '$11540', '', 'L1Doll', 8743, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80237, 'Dazzling Brute Magic Doll', '$11541', '', 'L1Doll', 8744, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80238, 'dummy', '$11449', '$11449', 'L1Merchant', 1273, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80239, 'dummy', '$11450', '$11450', 'L1Merchant', 2429, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80240, 'dummy', '$11451', '$11451', 'L1Merchant', 2314, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80241, 'Special Salesperson', 'Special Salesperson', 'Sap Salesperson', 'L1Merchant', 1282, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80242, 'dummy', '$11525', '$11525', 'L1Merchant', 896, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80243, 'dummy', '$11700', '$11700', 'L1Monster', 852, 4, 20, 10, 5, 6, 10, 12, 6, 6, 0, 17, -5, 'small', 2, 1, 1, 1040, 1480, 0, 1480, 1480, 0, 1, 0, 1, 0, 0, 'fungus', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (80244, 'Drake Magic Doll', '$12854', '', 'L1Doll', 10256, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80245, 'Royal Magic Doll', '$7493', '', 'L1Doll', 9635, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80246, 'Royal Magic Doll', '$7493', '', 'L1Doll', 9638, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80247, 'Knight Magic Doll', '$7494', '', 'L1Doll', 9411, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80248, 'Knight Magic Doll', '$7494', '', 'L1Doll', 9414, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80249, 'Elf Magic Doll', '$7495', '', 'L1Doll', 9398, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80250, 'Elf Magic Doll', '$7495', '', 'L1Doll', 9401, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80251, 'Wizard Magic Doll ', '$7496', '', 'L1Doll', 9381, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80252, 'Wizard Magic Doll ', '$7496', '', 'L1Doll', 9377, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80253, 'Dark Elf Magic Doll', '$7497', '', 'L1Doll', 9391, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80254, 'Dark Elf Magic Doll', '$7497', '', 'L1Doll', 9395, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80255, 'Dragon Knight Magic Doll', '$7498', '', 'L1Doll', 9388, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80256, 'Dragon Knight Magic Doll', '$7498', '', 'L1Doll', 9385, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80257, 'Illusionist Magic Doll ', '$7499', '', 'L1Doll', 9404, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80258, 'Illusionist Magic Doll ', '$7499', '', 'L1Doll', 9407, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80259, 'Peter', '$12249', '$12249', 'L1Teleporter', 2400, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (80260, 'Wizard Adonis', '$11513', '$11513', 'L1Teleporter', 2143, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (80261, 'Mial', '$9139', '', 'L1Merchant', 1298, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (80262, 'Siol', '$9140', '', 'L1Merchant', 1298, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (80263, 'Kiltone', '$9684', '', 'L1Merchant', 1254, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (80264, 'Merlin', '$9685', '', 'L1Merchant', 1298, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (80265, 'Harin', '$9843', '', 'L1Merchant', 723, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (80266, 'Mopo', '$9462', '', 'L1Merchant', 1254, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (80267, 'Copeonba', '$9470', '', 'L1Merchant', 1282, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80268, 'Magic Doll: Sea lion (large)', 'Magic Doll: Sea lion (large)', 'Unimplemented', 'L1Doll', 10154, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80269, 'Magic Doll: Sea lion (small)', 'Magic Doll: Sea lion (small)', 'Unimplemented', 'L1Doll', 10157, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80270, 'Magic Doll: Hedgehog (large)', 'Magic Doll: Hedgehog (large)', 'Unimplemented', 'L1Doll', 10172, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80271, 'Magic Doll: Hedgehog (small)', 'Magic Doll: Hedgehog (small)', 'Unimplemented', 'L1Doll', 10169, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80272, 'Magic Doll: Penguin (Large)', 'Magic Doll: Penguin (Large)', 'Unimplemented', 'L1Doll', 10226, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80273, 'Magic Doll: Penguin (small)', 'Magic Doll: Penguin (small)', 'Unimplemented', 'L1Doll', 10229, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80274, 'Penguin (Brother) Magic Doll', 'Penguin (Brother) Magic Doll', 'Unimplemented', 'L1Doll', 10717, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80275, 'Support Penguin (Brother) Magic Doll', 'Support Penguin (Brother) Magic Doll', 'Unimplemented', 'L1Doll', 10741, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80276, 'Clever Penguin (Brother) Magic Doll', 'Clever Penguin (Brother) Magic Doll', 'Unimplemented', 'L1Doll', 10742, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80277, 'Intelligent Penguin (Brother) Magic Doll', 'Intelligent Penguin (Brother) Magic Doll', 'Unimplemented', 'L1Doll', 10720, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80278, 'Glowing Penguin (Brother) Magic Doll', 'Glowing Penguin (Brother) Magic Doll', 'Unimplemented', 'L1Doll', 10723, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80279, 'Dazzling Penguin (Brother) Magic Doll', 'Dazzling Penguin (Brother) Magic Doll', 'Unimplemented', 'L1Doll', 10726, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80280, 'Penguin (Sister) Magic Doll', 'Penguin (Sister) Magic Doll', 'Unimplemented', 'L1Doll', 10729, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80281, 'Support Penguin (Sister) Magic Doll', 'Support Penguin (Sister) Magic Doll', 'Unimplemented', 'L1Doll', 10743, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80282, 'Clever Penguin (Sister) Magic Doll', 'Clever Penguin (Sister) Magic Doll', 'Unimplemented', 'L1Doll', 10744, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80283, 'Intelligent Penguin (Sister) Magic Doll', 'Intelligent Penguin (Sister) Magic Doll', 'Unimplemented', 'L1Doll', 10732, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80284, 'Glowing Penguin (Sister) Magic Doll', 'Glowing Penguin (Sister) Magic Doll', 'Unimplemented', 'L1Doll', 10735, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (80285, 'Dazzling Penguin (Sister) Magic Doll', 'Dazzling Penguin (Sister) Magic Doll', 'Unimplemented', 'L1Doll', 10738, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (81253, 'Shop (Pattern)', 'Shop (Pattern)', 'Original', 'L1Merchant', 98, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 480, 800, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (81352, 'Terr', '$9153', '$9153', 'L1Merchant', 2143, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (81353, 'Mebarl', '$9154', '$9154', 'L1Merchant', 2143, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (81354, 'Cindarl', '$9155', '$9155', 'L1Merchant', 2143, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (81355, 'Redorl', '$9156', '$9156', 'L1Merchant', 2143, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (81356, 'Rundorl', '$9157', '$9157', 'L1Merchant', 2143, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (81357, 'Jendorl', '$9158', '$9158', 'L1Merchant', 2143, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (81358, 'Mybarl', '$9159', '$9159', 'L1Merchant', 2143, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (81359, 'Denrl', '$9160', '$9160', 'L1Merchant', 2143, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (81360, 'Terorl', '$9161', '$9161', 'L1Merchant', 2143, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (81361, 'Nanierl', '$9162', '$9162', 'L1Merchant', 2143, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (81362, 'Nebarl', '$9163', '$9163', 'L1Merchant', 2143, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (81374, 'Research Assistant', '$7920', 'Ivory Tower Secret Lab', 'L1Merchant', 6804, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (90499, 'Monkey', '$4081', 'Pets', 'L1Monster', 7260, 5, 25, 5, 0, 15, 10, 12, 12, 14, 15, 37, 0, 'small', 0, 1, 0, 480, 1120, 1120, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 3, 5000, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91003, 'Grand Chamberlain Mammon', '$4818', 'Teleporter', 'L1Teleporter', 5900, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (91005, 'マヤの影', '$4863', '瑪雅的影子', 'L1Merchant', 5937, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 1160, 1280, 1200, 1160, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91006, 'Goddess Flora', '$4799', 'Prophet Proya', 'L1Teleporter', 2141, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91007, 'Goddess Amelia', '$4800', 'Virgin Laura', 'L1Merchant', 2141, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91050, 'Druga Veil', '$7744', 'Druga Bag Seller', 'L1Merchant', 7618, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91051, 'Dragon Portal', '$7747', 'Portal (Earth)', 'L1DragonPortal', 7554, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91052, 'Dragon Portal', '$7747', 'Portal (Water)', 'L1DragonPortal', 7548, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91053, 'Dragon Portal', '$7747', 'Portal (Wind)', 'L1DragonPortal', 7552, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91054, 'Dragon Portal', '$7747', 'Portal (Fire)', 'L1DragonPortal', 7550, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91055, 'Bulletin Board', '$7746', 'Dragon Raid Bulletin Board', 'L1Board', 1544, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91056, 'Bankoo', '$7774', 'Bankoo', 'L1Merchant', 7658, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (91057, 'Strong Heios', '$7740', 'Tool Making Strong HIOS', 'L1Merchant', 2255, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91058, 'Sensitive Shunu', '$7741', 'Tool Making Delicate chune', 'L1Merchant', 1621, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1440, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91059, 'Tenacious Dooho', '$7742', 'Tool Making Persistent Dooh', 'L1Merchant', 782, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 840, 0, 960, 960, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91060, 'Luminous Vaemi', '$7743', 'Tool Making Flashy baemi', 'L1Merchant', 6239, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91061, 'Shuerme', '$7892', 'Rice Rice', 'L1Merchant', 6232, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91062, 'Cray', '$1015', 'Antaras Cave', 'L1Merchant', 1049, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1280, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91063, 'Pamyrid', '$7777', 'In front of Antaras rare', 'L1Dwarf', 1997, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 800, 1640, 1120, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91064, 'Irbagil', '$7776', 'In front of Antaras rare', 'L1Merchant', 1997, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 800, 1640, 1120, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91065, 'Wizard Merlin', '$7441', 'Gludin Prison Teleporter', 'L1Teleporter', 2400, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1440, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91066, 'Dragon Portal', '$7747', 'Entrance to the hidden land of the dragon', 'L1DragonPortal', 7585, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91100, 'Trial Elmore Zombie Commander', 'Trial $5650', 'For quest', 'L1Monster', 2137, 25, 180, 0, -18, 17, 18, 15, 12, 10, 10, 626, -25, 'large', 2, 1, 1, 960, 1200, 1280, 1200, 1200, 1, 0, 0, 0, 0, 0, 'elmore', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91101, 'dummy', '$7712', '媽祖', 'L1Monster', 7348, 25, 180, 0, -18, 17, 18, 15, 12, 10, 10, 626, -25, 'large', 2, 1, 1, 640, 1200, 1280, 1200, 1200, 1, 0, 0, 1, 0, 0, 'elmore', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91102, 'dummy', '$7714', '千里眼妖魔', 'L1Monster', 7342, 25, 180, 0, -18, 17, 18, 15, 12, 10, 10, 626, -25, 'large', 2, 1, 1, 480, 520, 1280, 600, 1200, 1, 0, 0, 1, 0, 0, 'elmore', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91103, 'dummy', '$7715', '順風耳妖魔', 'L1Monster', 7351, 25, 180, 0, -18, 17, 18, 15, 12, 10, 10, 626, -25, 'large', 2, 1, 1, 480, 520, 1280, 600, 1200, 1, 0, 0, 1, 0, 0, 'elmore', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91157, 'Uni Dragon (Earth)', '$7770', 'Blue Sky Canyon', 'L1Monster', 7590, 55, 800, 200, -55, 16, 12, 12, 14, 18, 60, 3026, -45, 'large', 2, 1, 0, 960, 640, 960, 960, 1040, 0, 0, 0, 1, 1, 1, 'Dragon', 1, -1, -1, 0, 0, 0, 0, 250, 0, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91158, 'Uni Dragon (Fire)', '$7770', 'Blue Sky Canyon', 'L1Monster', 7587, 55, 700, 200, -45, 9, 10, 9, 16, 16, 50, 3026, -45, 'large', 4, 1, 0, 960, 640, 960, 960, 1040, 0, 0, 0, 1, 1, 1, 'Dragon', 1, -1, -1, 0, 0, 0, 0, 250, 0, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91159, 'Uni Dragon (Water)', '$7770', 'Blue Sky Canyon', 'L1Monster', 7596, 55, 750, 300, -50, 20, 18, 16, 16, 18, 60, 3026, -45, 'large', 8, 1, 0, 960, 640, 960, 960, 1040, 0, 0, 0, 1, 1, 1, 'Dragon', 1, -1, -1, 0, 0, 0, 0, 450, 0, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91160, 'Uni Dragon (Wind)', '$7770', 'Blue Sky Canyon', 'L1Monster', 7593, 55, 750, 350, -68, 9, 10, 10, 16, 16, 80, 3026, -45, 'large', 1, 1, 0, 960, 640, 960, 960, 1040, 0, 0, 0, 1, 1, 1, 'Dragon', 1, -1, -1, 0, 0, 0, 0, 150, 0, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91161, 'Terra Dragon (Earth)', '$7771', 'Blue Sky Canyon', 'L1Monster', 7566, 62, 800, 270, -70, 18, 16, 14, 18, 18, 60, 3845, -50, 'large', 2, 1, 0, 960, 640, 1120, 1400, 1400, 0, 0, 0, 1, 1, 1, 'Dragon', 1, -1, -1, 0, 0, 0, 0, 100, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91162, 'Terra Dragon (Fire)', '$7771', 'Blue Sky Canyon', 'L1Monster', 7559, 62, 700, 200, -57, 24, 20, 18, 16, 18, 50, 3845, -50, 'large', 4, 1, 0, 960, 640, 1120, 1400, 1400, 0, 0, 0, 1, 1, 1, 'Dragon', 1, -1, -1, 0, 0, 0, 0, 150, 0, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91163, 'Terra Dragon (Water)', '$7771', 'Blue Sky Canyon', 'L1Monster', 7580, 62, 750, 450, -60, 24, 22, 18, 14, 18, 60, 3845, -50, 'large', 8, 1, 0, 960, 640, 1120, 1400, 1400, 0, 0, 0, 1, 1, 1, 'Dragon', 1, -1, -1, 0, 0, 0, 0, 250, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91164, 'Terra Dragon (Wind)', '$7771', 'Blue Sky Canyon', 'L1Monster', 7573, 62, 750, 300, -75, 22, 18, 14, 18, 18, 80, 3845, -50, 'large', 1, 1, 0, 960, 640, 1120, 1400, 1400, 0, 0, 0, 1, 1, 1, 'Dragon', 1, -1, -1, 0, 0, 0, 0, 250, 0, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91165, 'Skull Dragon', '$7772', 'Blue Sky Canyon', 'L1Monster', 2409, 70, 850, 450, -75, 22, 20, 18, 16, 22, 100, 4901, -110, 'large', 0, 1, 1, 860, 960, 1120, 1040, 1040, 0, 0, 0, 1, 1, 1, 'Dragon', 1, -1, -1, 0, 0, 0, 0, 400, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91166, 'Koma Yum', '$7754', 'Antara Slade', 'L1Monster', 7481, 53, 2200, 150, -40, 16, 10, 9, 16, 16, 30, 2810, -100, 'small', 0, 1, 0, 640, 640, 1120, 960, 1040, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91167, 'Koma Shin', '$7755', 'Antara Slade', 'L1Monster', 7489, 53, 1900, 200, -40, 14, 12, 12, 16, 16, 80, 2810, -100, 'small', 0, 1, 0, 640, 640, 1120, 960, 1040, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91168, 'Koma Kum', '$7756', 'Antara Slade', 'L1Monster', 7503, 60, 3000, 200, -50, 20, 20, 20, 16, 16, 60, 3601, -300, 'large', 0, 1, 0, 1120, 960, 1120, 960, 1280, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 5000, 2, 5000, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 1),
   (91169, 'Koma Kum', '$7756', 'Antara Slade', 'L1Monster', 7496, 62, 4000, 200, -50, 20, 16, 14, 10, 16, 60, 3845, -300, 'large', 0, 1, 0, 1120, 960, 1120, 960, 1280, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 5000, 2, 5000, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 1),
   (91170, 'Koma Kum', '$7756', 'Antara Slade', 'L1Monster', 7509, 64, 5000, 200, -50, 20, 10, 9, 16, 16, 60, 4097, -300, 'large', 0, 1, 0, 1120, 960, 1120, 960, 1280, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 5000, 2, 5000, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 1),
   (91171, 'Egg', '$8949', 'Dragon Egg 1', 'L1Monster', 7522, 1, 10, 0, 10, 125, 50, 24, 35, 8, 0, 0, 0, 'small', 1, 2, 0, 0, 1960, 0, 2000, 2400, 0, 0, 0, 1, 1, 1, 'tikal', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91172, 'Egg', '$8949', 'Dragon Egg 2', 'L1Monster', 7531, 1, 10, 0, 10, 125, 50, 24, 35, 8, 0, 0, 0, 'small', 0, 2, 0, 0, 2080, 0, 3000, 2920, 0, 0, 0, 1, 1, 1, 'tikal', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91173, 'Hatchling Male', '$4083', '', 'L1Monster', 7369, 50, 2200, 300, -55, 12, 10, 10, 12, 14, 15, 2501, 0, 'small', 0, 1, 1, 560, 960, 1200, 1040, 1040, 0, 0, 0, 0, 0, 0, '', 1, -1, -1, 0, 0, 0, 0, 22, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91174, 'Hatchling Female', '$4084', '', 'L1Monster', 7365, 50, 2000, 600, -55, 12, 10, 10, 14, 16, 15, 2501, 0, 'small', 0, 1, 1, 720, 1080, 1120, 1200, 1040, 0, 0, 0, 0, 0, 0, '', 1, -1, -1, 0, 0, 0, 0, 45, 0, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91175, 'High-Hatchling Male', '$4085', 'Yes Pets', 'L1Monster', 7604, 65, 3400, 450, -75, 20, 20, 24, 24, 8, 1, 37, 0, 'small', 0, 1, 1, 480, 880, 1200, 720, 880, 0, 0, 0, 0, 0, 0, '', 1, -1, -1, 0, 0, 0, 5000, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91176, 'High-Hatchling Female', '$4086', 'Yes Pets', 'L1Monster', 7609, 65, 3300, 450, -75, 26, 24, 24, 22, 26, 0, 37, 0, 'small', 0, 1, 1, 640, 1040, 1200, 1120, 2880, 0, 0, 0, 0, 0, 0, '', 1, -1, -1, 0, 0, 0, 0, 400, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91177, 'Super Monkey', '$4082', 'Yes Pets', 'L1Monster', 7285, 60, 3200, 800, -60, 33, 28, 24, 22, 22, 15, 26, 0, 'small', 0, 1, 1, 480, 1120, 1020, 1120, 980, 0, 0, 0, 0, 0, 0, '', 1, -1, -1, 0, 0, 0, 0, 350, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91178, 'Hatchling', '$7757', 'Antaras Cave', 'L1Monster', 7365, 43, 2000, 600, -55, 12, 9, 9, 16, 12, 12, 1850, 0, 'small', 0, 1, 1, 720, 1080, 1120, 1200, 1040, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 0, 80, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91179, 'Hatchling', '$7757', 'Antaras Cave', 'L1Monster', 7369, 43, 2200, 300, -55, 12, 9, 9, 12, 12, 15, 1850, 0, 'small', 0, 1, 1, 560, 960, 1200, 1040, 1040, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 0, 80, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91180, 'Dwarven Worker', '$7766', 'Dwarf Village', 'L1Monster', 54, 38, 650, 15, -35, 16, 10, 9, 16, 16, 60, 2810, -15, 'small', 0, 1, 1, 600, 1480, 1020, 1480, 1480, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 0, 600, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91181, 'Dwarven Worker', '$7767', 'Dwarf Village', 'L1Monster', 1184, 38, 650, 15, -40, 16, 10, 9, 16, 16, 70, 1445, -20, 'small', 0, 1, 1, 860, 860, 1020, 1020, 1040, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 0, 600, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91182, 'Dwarven General', '$7768', 'Dwarf Village', 'L1Monster', 7335, 45, 700, 15, -50, 16, 10, 9, 16, 16, 70, 2026, -30, 'small', 0, 1, 1, 640, 960, 1280, 1020, 1040, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 0, 600, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91183, 'Dwarven Shaman', '$7769', 'Dwarf Village', 'L1Monster', 7362, 45, 700, 600, -35, 16, 10, 9, 16, 16, 90, 2026, -30, 'small', 0, 1, 1, 960, 1280, 1020, 960, 1120, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 0, 600, 0, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91184, 'Mankoo', '$7775', 'Merchant Mank', 'L1Merchant', 7656, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (91185, 'Mankoo', '$7773', 'Store Hunk', 'L1Merchant', 7657, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (91200, 'Antharas', '$1116', 'lv1', 'L1Monster', 7557, 80, 30000, 5000, -90, 80, 21, 10, 20, 18, 50, 8101, -8000, 'large', 2, 1, 0, 480, 2000, 1960, 2880, 2640, 0, 1, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 2000, 10000, 10000, 0, 0, 0, 0, 0, 0, 0, 30, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (91201, 'Antharas', '$1116', 'lv2', 'L1Monster', 7539, 80, 30000, 5000, -90, 80, 21, 10, 20, 18, 50, 8101, -8000, 'large', 2, 1, 0, 480, 2000, 1960, 2880, 2640, 0, 1, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 2000, 10000, 10000, 0, 0, 0, 0, 0, 0, 0, 30, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (91202, 'Antharas', '$1116', 'lv3', 'L1Monster', 7558, 80, 30000, 5000, -90, 80, 21, 10, 20, 18, 50, 8101, -8000, 'large', 2, 1, 0, 480, 2000, 1960, 2880, 2640, 0, 1, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 2000, 10000, 10000, 0, 0, 0, 0, 0, 0, 0, 30, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (91209, 'Crack of Time', '$5656', 'ILL Lv45 Quest', 'L1Monster', 6920, 45, 100, 200, -1, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 1),
   (91265, 'Skeleton Axeman', '$987', 'Skeleton Axe (Secret)', 'L1Monster', 1104, 13, 450, 20, 0, 18, 14, 14, 12, 10, 10, 401, -13, 'small', 0, 1, 0, 480, 840, 840, 1680, 1680, 1, 0, 0, 1, 1, 0, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91266, 'Skeleton', '$7', 'Skeleton (Secret)', 'L1Monster', 30, 10, 200, 30, 3, 16, 14, 16, 12, 10, 10, 101, -12, 'small', 2, 1, 0, 640, 920, 1280, 1440, 1440, 1, 0, 0, 1, 1, 0, 'skeleton', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91267, 'Skeleton Archer', '$986', 'Skeleton Archer (Secret)', 'L1Monster', 1096, 12, 200, 25, 0, 16, 14, 16, 12, 10, 10, 145, -12, 'small', 2, 10, 0, 800, 1120, 920, 1840, 1840, 1, 0, 0, 1, 1, 0, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 66, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91268, 'Skeleton Soldier', '$988', 'Skeleton Soldier (Secret)', 'L1Monster', 1106, 13, 280, 15, 0, 16, 14, 15, 12, 10, 10, 170, -13, 'small', 2, 2, 0, 640, 880, 840, 1680, 1680, 1, 0, 0, 1, 1, 0, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91270, 'Devildom Spartoi', '$7841 $318', 'Demon World', 'L1Monster', 145, 16, 256, 30, -3, 16, 14, 15, 14, 6, 18, 37, -18, 'small', 0, 1, 0, 800, 920, 0, 1440, 1440, 1, 0, 0, 1, 0, 0, 'skeleton', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91271, 'Devildom Ghost', '$7841 $1563', 'Demon World', 'L1Monster', 1318, 17, 256, 10, -5, 11, 11, 11, 9, 13, 15, 290, -10, 'small', 0, 1, 0, 960, 1000, 1440, 1000, 1000, 1, 0, 0, 0, 0, 0, 'ghost', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91272, 'Devildom Death', '$7841 $1562', 'Demon World', 'L1Monster', 1576, 22, 282, 40, -8, 12, 11, 11, 9, 13, 5, 485, -28, 'small', 0, 1, 0, 640, 2280, 2080, 2280, 2280, 1, 0, 0, 1, 1, 0, 'death', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91273, 'Devildom Cerberus', '$7841 $925', 'Demon World', 'L1Monster', 951, 24, 334, 60, -10, 17, 18, 15, 12, 16, 25, 577, -27, 'small', 0, 1, 0, 640, 1040, 1840, 1840, 1840, 2, 0, 0, 1, 1, 0, 'cerberus', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91274, 'Devildom Skeleton Gaurd', '$7841 $1018', 'Demon World', 'L1Monster', 1134, 27, 551, 60, -15, 16, 14, 15, 14, 14, 25, 730, -30, 'small', 0, 2, 0, 640, 880, 840, 1680, 1680, 1, 0, 0, 1, 1, 0, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91275, 'Devildom Skeleton Fighter', '$7841 $1016', 'Demon World', 'L1Monster', 1130, 27, 295, 60, -12, 16, 14, 16, 16, 16, 25, 730, -30, 'small', 0, 10, 0, 800, 1120, 920, 1840, 1840, 1, 0, 0, 1, 1, 0, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 66, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91276, 'Devildom Skeleton Fighter', '$7841 $1017', 'Demon World', 'L1Monster', 1132, 29, 590, 60, -18, 18, 14, 14, 14, 14, 25, 842, -30, 'small', 0, 1, 0, 480, 840, 840, 1680, 1680, 1, 0, 0, 1, 1, 0, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91277, 'Devildom Dark Elemental', '$7841 $2895', 'Demon World', 'L1Monster', 3364, 30, 655, 120, -20, 18, 11, 12, 10, 10, 30, 842, -18, 'small', 0, 1, 0, 960, 1240, 1080, 1240, 1240, 0, 0, 0, 1, 1, 1, 'elemental', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91278, 'Devildom Salamander', '$7841 $1505', 'Demon World', 'L1Monster', 1666, 32, 720, 180, -22, 17, 12, 15, 12, 10, 10, 1025, -30, 'small', 0, 1, 0, 640, 1080, 1280, 1080, 1080, 0, 0, 0, 1, 1, 0, 'salamander', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91279, 'Devildom Beholder', '$7841 $1001', 'Demon World', 'L1Monster', 1123, 33, 746, 500, -25, 10, 13, 12, 18, 18, 50, 1090, -30, 'large', 0, 1, 0, 960, 1120, 0, 1480, 1120, 0, 0, 1, 1, 1, 1, 'gazer', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91280, 'Devildom World Succubus', '$7841 $1000', 'Demon World', 'L1Monster', 1112, 37, 785, 50, -28, 15, 15, 18, 25, 18, 50, 1370, -40, 'small', 0, 1, 0, 640, 800, 1080, 1440, 800, 2, 0, 0, 1, 1, 1, 'succubus', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91281, 'Devildom Orc Zombie', '$7841 $1041', 'Demon World', 'L1Monster', 1121, 42, 924, 25, -30, 10, 10, 10, 7, 14, 25, 1765, -10, 'small', 0, 1, 0, 1440, 1800, 0, 1800, 1800, 1, 1, 0, 1, 1, 1, 'zombie', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91282, 'Devildom Lycanthrope', '$7841 $990', 'Demon World', 'L1Monster', 1108, 44, 976, 60, -35, 16, 16, 18, 10, 12, 45, 1937, -18, 'small', 0, 1, 0, 640, 800, 720, 1440, 1440, 5, 0, 0, 1, 1, 1, 'wolf', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91283, 'Devildom Lesser Demon', '$7841 $3413', 'Demon World', 'L1Monster', 2524, 44, 950, 100, -32, 20, 17, 16, 12, 14, 80, 1937, -60, 'small', 0, 1, 0, 720, 720, 1040, 1040, 1200, 2, 0, 0, 1, 1, 1, 'daemon', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91284, 'Devildom Taurverus', '$7841 $1568', 'Demon World', 'L1Monster', 1780, 46, 1154, 80, -40, 20, 20, 18, 20, 18, 55, 1522, -50, 'small', 0, 0, 0, 880, 1000, 1000, 1360, 1440, 2, 0, 0, 1, 1, 1, 'cerberus', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91285, 'Devildom Ifrit', '$7841 $1567', 'Demon World', 'L1Monster', 1773, 46, 1115, 300, -38, 20, 18, 18, 18, 18, 80, 2117, -55, 'large', 0, 1, 0, 960, 1640, 0, 1200, 1640, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91286, 'Devildom Bone Dragon', '$7841 $2108', 'Demon World', 'L1Monster', 2409, 47, 1180, 140, -42, 32, 16, 11, 18, 18, 90, 2210, -50, 'large', 0, 1, 0, 960, 1280, 0, 1760, 1280, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (91287, 'Devildom Fire Archer', '$7841 $1572', 'Demon World', 'L1Monster', 1832, 48, 525, 20, -45, 13, 10, 16, 9, 9, 45, 901, -25, 'small', 0, 10, 0, 960, 2000, 1320, 2360, 2360, 0, 0, 0, 1, 0, 0, 'burningarcher', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91288, 'Devildom Fire Warrior', '$7841 $1566', 'Demon World', 'L1Monster', 1770, 50, 1245, 20, -48, 15, 10, 11, 9, 9, 30, 842, -25, 'small', 0, 2, 0, 960, 1520, 1480, 1520, 1520, 0, 0, 0, 1, 0, 0, 'burningwarrior', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91289, 'Devildom Seer', '$7841 $2397', 'Demon World', 'L1Monster', 2773, 54, 1284, 350, -50, 60, 15, 50, 18, 18, 99, 2501, -60, 'large', 0, 1, 0, 480, 1440, 0, 1280, 1440, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 75, 5000, 75, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (91290, 'Reaper', '$2863', 'Reaper (Secret)', 'L1Monster', 3092, 55, 4200, 400, -52, 25, 20, 20, 25, 15, 70, 3026, -250, 'small', 0, 1, 0, 480, 1400, 1320, 1400, 1400, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91291, 'Death Knight', '$371', 'Death Knight (Secret)', 'L1Monster', 240, 55, 4000, 250, -67, 75, 18, 17, 15, 17, 65, 3026, -120, 'small', 2, 1, 0, 640, 600, 760, 880, 960, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 416, 5000, 200, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 14, 1, 0, 1, 0, 1),
   (91292, 'Devildom Greater Minotaur', '$7841 $2106', 'Demon World Greater Minotaur', 'L1Monster', 2402, 55, 1510, 400, -52, 70, 20, 12, 17, 18, 70, 2810, -250, 'small', 2, 1, 0, 960, 1520, 0, 1360, 1520, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 200, 5000, 200, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (91293, 'Phoenix', '$1569', 'Phoenix (Secret)', 'L1Monster', 1791, 59, 4000, 200, -63, 35, 18, 18, 22, 22, 99, 3482, -130, 'large', 0, 2, 0, 960, 1600, 0, 1920, 1600, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 500, 5000, 500, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (91294, 'Baphomet', '$7655', 'Baphomet (Secret)', 'L1Monster', 53, 64, 6100, 900, -75, 68, 20, 18, 17, 16, 99, 4097, -5, 'large', 0, 2, 0, 480, 760, 800, 800, 1040, 2, 0, 0, 1, 1, 1, 'daemon', 1, 7400, 7395, 0, 0, 0, 5000, 150, 5000, 40, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, -2, -1, 0, 0, 0, 0, 0, 0, 0),
   (91295, 'Cerenis', '$7560', 'Black Wing Cerenis', 'L1Monster', 7847, 64, 3100, 900, -75, 0, 0, 0, 0, 0, 99, 0, -80, 'large', 0, 1, 0, 640, 560, 0, 640, 800, 0, 0, 0, 0, 0, 0, '', 0, 53, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91296, 'Cerenis', '$7560', 'Little Cerenis', 'L1Monster', 7845, 64, 3100, 900, -75, 0, 0, 0, 0, 0, 99, 0, 0, 'large', 0, 1, 0, 640, 560, 0, 640, 800, 0, 0, 0, 0, 0, 0, '', 0, 53, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91297, 'Cerenis', '$7560', 'Little Cerenis', 'L1Npc', 7407, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 800, 1120, 0, 960, 760, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91316, 'rune wall', '', 'Magic Circle - Chi', 'L1FieldObject', 7393, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0),
   (91317, 'rune wall', '', 'Magic Circle - Chi', 'L1FieldObject', 7394, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0),
   (91318, 'rune wall', '', 'Magic Circle City', 'L1FieldObject', 7391, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0),
   (91319, 'rune wall', '', 'Magic Circle - White', 'L1FieldObject', 7392, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0),
   (91320, 'rune wall', '', 'Magic Circle - Blue (Large)', 'L1FieldObject', 7572, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0),
   (91321, 'wall', '', 'Past TI2F moving wall', 'L1Monster', 7534, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0),
   (91322, 'wall', '', 'Past TI2F moving wall', 'L1FieldObject', 7535, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0),
   (91323, 'wall', '', 'Past TI2F moving wall', 'L1Npc', 7536, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0),
   (91324, 'wall', '', 'Past TI2F moving wall', 'L1FieldObject', 7537, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0),
   (91325, 'magic-boll', '', 'Green', 'L1Effect', 7567, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0),
   (91326, 'magic-boll', '', 'Red', 'L1Effect', 7480, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0),
   (91327, 'Yurie', '$7918', 'Talking Island', 'L1Merchant', 6804, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0),
   (91328, 'Yuki', '$7919', 'Ivory Tower Secret Lab-ハーディン', 'L1Merchant', 7372, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91329, 'Yuki', '$7919', 'Ivory Tower Secret Lab-オリム', 'L1Merchant', 7372, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91330, 'Hardin', '$7597', 'Past Talking Island', 'L1Merchant', 7463, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 800, 1440, 0, 1440, 1760, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91331, 'Paper Man', '$1396', 'Ivory Tower Secret Lab', 'L1Merchant', 2240, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 960, 800, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (91332, 'Middle Oum', '$3145', 'Asmodian Temple-Dikalden`s Intelligence Agent', 'L1Monster', 3644, 32, 450, 50, -23, 18, 18, 16, 5, 5, 30, 1025, -35, 'small', 0, 2, 0, 853, 1520, 1520, 1520, 1520, 0, 0, 0, 1, 1, 1, 'oum', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (91333, 'Orc', '$59', 'TI', 'L1Monster', 56, 2, 6, 4, 10, 6, 12, 10, 6, 10, 0, 5, -2, 'small', 4, 1, 1, 800, 1320, 0, 1440, 1440, 0, 0, 0, 0, 0, 0, 'orc', 1, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91334, 'Orc Archer', '$267', 'TI', 'L1Monster', 3860, 3, 12, 4, 10, 12, 11, 12, 7, 8, 2, 10, -3, 'small', 4, 10, 1, 800, 1880, 720, 1440, 1760, 0, 0, 0, 0, 0, 0, 'orc', 1, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91335, 'Balsim', '$304', '', 'L1Merchant', 118, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91336, 'Orc Fighter', '$266', 'Usual', 'L1Monster', 3864, 8, 50, 8, 5, 14, 14, 14, 8, 10, 5, 65, -8, 'small', 4, 1, 1, 640, 920, 760, 1400, 1400, 0, 0, 0, 0, 0, 0, 'orc', 1, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91337, 'Gremlin', '$1046', 'Gremlin (Secret) Bonus Monster', 'L1Monster', 1154, 4, 50, 20, 10, 11, 12, 18, 7, 8, 99, 17, -3, 'small', 2, 1, 0, 320, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91338, 'black-rune', '', 'Black Rune-Small', 'L1FieldObject', 4185, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91339, 'rune', '', 'small team around black-rune', 'L1FieldObject', 6709, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 840, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91340, 'Rova Orc', '$497', 'HD (Secret)', 'L1Monster', 784, 40, 450, 100, -50, 12, 12, 12, 8, 14, 60, 170, 0, 'small', 0, 1, 0, 640, 1040, 0, 1040, 1040, 0, 0, 0, 1, 1, 0, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91341, 'Atuba Orc', '$494', '(Secret)', 'L1Monster', 786, 40, 300, 100, -50, 14, 14, 14, 12, 10, 60, 226, 0, 'small', 0, 1, 0, 640, 1040, 0, 1040, 1040, 0, 0, 0, 1, 1, 0, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91342, 'Neruga Orc', '$495', '(Secret)', 'L1Monster', 788, 40, 230, 100, -50, 17, 14, 13, 8, 10, 60, 290, 0, 'small', 0, 2, 0, 640, 1160, 0, 1160, 1160, 0, 0, 0, 1, 0, 0, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91343, 'Yahee', '$3777', 'NPC (Secret)', 'L1Merchant', 4880, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 1280, 1040, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91344, 'Varlok', '$2114', 'New (after transformation)', 'L1Monster', 5511, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 800, 880, 960, 1120, 1280, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91350, 'Vekadoo', '$1213', 'Gludin Bug Bear Race', 'L1Npc', 3497, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91351, 'Tutu', '$1214', 'Gludin Bug Bear Race', 'L1Npc', 3498, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91352, 'Buggy', '$1215', 'Gludin Bug Bear Race', 'L1Npc', 3499, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91353, 'Urloo', '$1216', 'Gludin Bug Bear Race', 'L1Npc', 3500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91354, 'Jeffrey', '$1217', 'Gludin Bug Bear Race', 'L1Npc', 3501, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91355, 'Kai', '$1218', 'Gludin Bug Bear Race', 'L1Npc', 3502, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91356, 'Adolph', '$1219', 'Gludin Bug Bear Race', 'L1Npc', 3503, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91357, 'Overpot', '$1220', 'Gludin Bug Bear Race', 'L1Npc', 3504, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91358, 'Lumps', '$1221', 'Gludin Bug Bear Race', 'L1Npc', 3505, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91359, 'Buka', '$1222', 'Gludin Bug Bear Race', 'L1Npc', 3506, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91360, 'Glook', '$1223', 'Gludin Bug Bear Race', 'L1Npc', 3507, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91361, 'Kundra', '$1224', 'Gludin Bug Bear Race', 'L1Npc', 3508, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91362, 'Kumato', '$1225', 'Gludin Bug Bear Race', 'L1Npc', 3509, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91363, 'Durek', '$1226', 'Gludin Bug Bear Race', 'L1Npc', 3510, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91364, 'Grodon', '$1227', 'Gludin Bug Bear Race', 'L1Npc', 3511, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91365, 'Queniver', '$1228', 'Gludin Bug Bear Race', 'L1Npc', 3512, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91366, 'Pluto', '$1229', 'Gludin Bug Bear Race', 'L1Npc', 3497, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91367, 'Duriba', '$1230', 'Gludin Bug Bear Race', 'L1Npc', 3498, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91368, 'Buruel', '$1231', 'Gludin Bug Bear Race', 'L1Npc', 3499, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91369, 'Elijah', '$1232', 'Gludin Bug Bear Race', 'L1Npc', 3500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 320, 1080, 3360, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91400, 'Evil Spirit', '$7444', 'Faust`s Evil (Club) (A)', 'L1Monster', 5972, 45, 650, 50, -40, 17, 18, 15, 12, 10, 90, 2026, -65, 'small', 2, 1, 0, 1280, 1120, 1160, 960, 1280, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91412, 'Starved Warden', '$7446', 'Starving guard (spear)', 'L1Monster', 4519, 45, 450, 50, -40, 16, 18, 12, 9, 8, 35, 2026, -65, 'small', 0, 2, 0, 560, 1120, 1000, 960, 960, 0, 0, 0, 1, 1, 1, 'giran', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91430, 'Gludin Mercenary captain', '', 'Gun', 'L1Guard', 148, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 480, 840, 520, 0, 0, 0, 0, 0, 0, 0, 0, 'guard', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (91431, 'Fire Shiboin', '$2470 $4326', 'Ifrit summons', 'L1Monster', 5331, 50, 500, 300, -60, 35, 21, 11, 21, 18, 100, 1600, -5, 'large', 4, 6, 0, 960, 1040, 960, 1040, 1040, 2, 0, 0, 1, 1, 1, 'efreet', 1, -1, -1, 0, 0, 0, 5000, 10, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 5334, -6, -1, 0, 0, 0, 0, 0, 0, 0),
   (91432, 'Phoenix', '$1569', 'Phoenix Recall Child Phoenix', 'L1Monster', 8175, 50, 700, 300, -60, 35, 21, 11, 21, 18, 100, 1600, -5, 'small', 4, 2, 0, 960, 1040, 960, 1040, 1040, 2, 0, 0, 1, 1, 1, 'phoenix', 1, -1, -1, 0, 0, 0, 5000, 10, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, -6, -1, 0, 0, 0, 0, 0, 0, 0),
   (91440, 'Winged Mimic Box', '', '', 'L1Monster', 8479, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91441, '', '', 'Pirate Ship A', 'L1Npc', 8260, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91442, '', '', 'Pirate Ship B', 'L1Npc', 8263, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91443, '', 'Wood destruction effect', 'castgfx', 'L1Npc', 8234, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1400, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91444, '', 'Shell drop effect', 'castgfx', 'L1Npc', 8233, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1400, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91445, '', 'Shark', 'castgfx', 'L1Npc', 8142, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 9600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91446, '', 'Assault Ship A', '', 'L1Npc', 8164, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91447, '', 'Assault Ship B', '', 'L1Npc', 8165, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'large', 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91448, '', 'Assault Ship C', '', 'L1Npc', 8166, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'large', 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91449, '', 'Edge of Deck', '', 'L1Npc', 8167, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91450, '', 'Cannon A', '', 'L1Npc', 8187, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91451, '', 'Cannon B', '', 'L1Npc', 8482, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91452, '', 'Send Magic Matrix', '', 'L1Npc', 8324, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91453, '', 'Defensive Matrix', '', 'L1Npc', 8323, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91454, '', 'Attack Magic Matrix', '', 'L1Npc', 8322, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91455, 'Mimic', '$1392', '', 'L1Monster', 1479, 15, 5, 20, -2, 16, 12, 14, 10, 11, 20, 1226, -20, 'small', 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91456, 'Devildom Taurverus', '$7841 $1568', '大空洞', 'L1Monster', 4121, 46, 850, 180, -23, 37, 12, 15, 12, 10, 80, 1625, -30, 'small', 0, 2, 0, 960, 1040, 1200, 1520, 1520, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91457, 'Devildom Hell Bound', '$7841 $3811', '', 'L1Monster', 4643, 48, 1057, 278, -40, 32, 18, 15, 12, 15, 80, 2201, -25, 'small', 0, 1, 0, 640, 1040, 1320, 1080, 1080, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91458, 'Devildom Lava Golem', '$7841 $1565', '', 'L1Monster', 1762, 42, 700, 300, -15, 65, 18, 8, 5, 5, 50, 1226, -40, 'large', 0, 1, 0, 1920, 2160, 2400, 2160, 2160, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91459, 'Devildom Astagio', '$7841 $1580', '', 'L1Monster', 1841, 45, 500, 30, -18, 32, 18, 22, 11, 10, 30, 1557, -30, 'large', 0, 1, 0, 1120, 1360, 1800, 1000, 1000, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91460, 'Devildom Minotaur', '$7841 $1393', 'FI(アックス)', 'L1Monster', 2364, 40, 500, 20, -20, 30, 18, 10, 12, 14, 0, 1570, -20, 'small', 0, 1, 0, 426, 773, 693, 860, 860, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91461, 'Devildom Maino', '$7841 $4868', '', 'L1Monster', 4942, 41, 600, 20, -28, 35, 17, 16, 10, 10, 50, 1600, -35, 'small', 0, 1, 0, 960, 1120, 880, 1120, 1120, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91462, 'Devildom Gargoyle', '$7841 $2102', '普通の', 'L1Monster', 2308, 51, 1000, 0, -60, 32, 16, 18, 12, 15, 80, 2226, -30, 'large', 0, 1, 0, 960, 1240, 1240, 1240, 1240, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91463, 'Devildom Spirit', '$7841 $4148', '', 'L1Monster', 4493, 65, 4000, 3000, -55, 20, 20, 20, 22, 18, 55, 3226, 0, 'large', 2, 1, 0, 960, 1280, 1520, 1520, 1600, 0, 1, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91464, 'Devildom Minotaur', '$7841 $1393', 'FI(フレイル)', 'L1Monster', 2365, 41, 600, 30, -20, 35, 18, 10, 12, 14, 0, 1682, -30, 'small', 0, 1, 0, 426, 773, 693, 860, 860, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91465, 'Devildom Priest of Corruption', '$7841 $2655', 'しっぽ', 'L1Monster', 3969, 56, 2000, 380, -60, 55, 21, 11, 21, 18, 70, 3137, -5, 'small', 0, 3, 0, 720, 960, 880, 1200, 960, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 150, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (91466, 'Devildom Priest of Corruption ', '$7841 $2655', '毒ゴリラ', 'L1Monster', 3984, 54, 2100, 400, -63, 55, 21, 11, 21, 18, 70, 2917, -5, 'small', 0, 2, 0, 720, 1120, 1040, 1360, 1120, 3, 1, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 150, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (91467, 'Devildom Priest of Corruption', '$7841 $2655', 'サンバ使い', 'L1Monster', 3957, 51, 1500, 250, -50, 55, 21, 11, 21, 18, 70, 2602, -5, 'small', 0, 1, 0, 560, 1040, 960, 1320, 1320, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 100, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (91468, 'Devildom Priest of Corruption', '$7841 $2655', '範囲持ち', 'L1Monster', 3989, 53, 1800, 300, -63, 55, 21, 11, 21, 18, 70, 2810, -5, 'small', 0, 2, 0, 720, 1040, 1080, 2400, 1040, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 150, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (91469, 'Devildom Priest of Corruption', '$7841 $2655', '横長', 'L1Monster', 3195, 51, 1500, 100, -53, 55, 21, 11, 21, 18, 70, 2602, -5, 'small', 0, 2, 0, 960, 1320, 1480, 1040, 1040, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 120, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (91470, 'Devildom Devildom', '$7841 $7841 ', '', 'L1Monster', 8338, 50, 1000, 500, -66, 35, 18, 15, 12, 15, 40, 2501, -10, 'small', 0, 0, 0, 960, 1120, 1400, 1200, 0, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91471, 'Oldin', '$9567', '', 'L1Monster', 8470, 60, 5000, 100, -53, 55, 21, 11, 21, 18, 70, 6602, -3000, 'small', 0, 2, 0, 800, 1440, 0, 1440, 1760, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 120, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (91472, 'Sema', '$338', 'セマ１', 'L1Monster', 183, 57, 2000, 500, -66, 35, 18, 15, 12, 15, 150, 0, 0, 'small', 0, 0, 0, 640, 920, 960, 760, 960, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 91493, 0, 0, 0, 0, 1, 0, 0),
   (91473, 'Baltuzar', '$335', '', 'L1Monster', 185, 43, 800, 250, -32, 12, 15, 12, 17, 17, 80, 3850, -50, 'small', 0, 1, 0, 640, 1480, 800, 800, 1000, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 180, 5000, 180, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 4, 0, 0, 1, 0, 0),
   (91474, 'Caspa', '$336', '', 'L1Monster', 173, 44, 450, 250, -32, 12, 15, 12, 17, 17, 80, 3937, -50, 'small', 0, 1, 0, 640, 1480, 800, 800, 1120, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 4, 0, 0, 1, 0, 0),
   (91475, 'Merkyor', '$337', '', 'L1Monster', 187, 45, 450, 250, -32, 12, 15, 12, 17, 17, 80, 3026, -50, 'small', 0, 1, 0, 640, 1480, 800, 800, 1120, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 250, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 4, 1, 0, 0, 0, 0),
   (91476, 'Lich', '$2110', '', 'L1Monster', 2495, 66, 6000, 1250, -75, 50, 20, 66, 22, 23, 99, 4357, -250, 'large', 0, 2, 0, 1920, 1440, 1280, 1440, 1240, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 250, 5000, 350, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (91477, 'Diego', '$3727', '', 'L1Monster', 4677, 40, 1500, 500, -40, 24, 25, 12, 6, 8, 10, 1601, -100, 'large', 0, 1, 0, 960, 1000, 1200, 1480, 1000, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91478, 'Zenith Queen', '$2395', '', 'L1Monster', 2807, 45, 1200, 250, -50, 55, 18, 45, 18, 18, 70, 2026, -70, 'large', 0, 1, 0, 480, 1480, 0, 1680, 1840, 0, 1, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 2, 0, 0, 1, 0, 0),
   (91479, 'Baphomet', '$306', '', 'L1Monster', 53, 51, 6000, 350, -65, 68, 20, 18, 17, 16, 80, 2602, -100, 'small', 2, 1, 0, 480, 760, 800, 800, 1040, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 300, 5000, 300, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91480, 'Tarak', '$3407', '', 'L1Monster', 4068, 68, 5000, 1250, -75, 66, 20, 66, 22, 20, 99, 4625, -10, 'large', 8, 3, 0, 720, 960, 1280, 1560, 1760, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 440, 5000, 150, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91481, 'Kraken', '', '', 'L1Monster', 8239, 66, 6000, 1250, -75, 50, 20, 66, 22, 23, 99, 4357, -250, 'large', 0, 2, 0, 0, 1480, 1080, 1120, 1720, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 250, 5000, 350, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (91482, 'Sea Drake', '$9578', '', 'L1Monster', 8128, 40, 1500, 500, -40, 24, 25, 12, 6, 8, 10, 1601, -100, 'large', 0, 1, 0, 320, 960, 1920, 0, 0, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91483, 'Sea Harpy', '$9577', '', 'L1Monster', 8126, 45, 1200, 250, -50, 55, 18, 45, 18, 18, 70, 2026, -70, 'large', 0, 1, 0, 320, 1240, 0, 2160, 0, 0, 1, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 2, 0, 0, 1, 0, 0),
   (91484, 'Devildom Depraved Soul', '$7841 $2658', '', 'L1Monster', 3073, 51, 3000, 350, -65, 68, 20, 18, 17, 16, 80, 2602, -100, 'small', 2, 1, 0, 960, 880, 1240, 0, 0, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 300, 5000, 300, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91485, 'Zombie Lord', '$2398', '', 'L1Monster', 2803, 62, 8000, 100, -58, 65, 25, 62, 10, 15, 50, 3845, -180, 'large', 0, 2, 0, 1440, 1880, 0, 1240, 1760, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 250, 5000, 250, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91486, 'Devildom Elmore Zombie Commander', '$7841 $5650', '', 'L1Monster', 6776, 25, 800, 0, -18, 17, 18, 15, 12, 10, 80, 1626, -25, 'large', 0, 1, 0, 960, 1200, 1280, 1200, 1200, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91487, '', '', 'Burning Fire', 'L1Npc', 8515, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91488, '', '', 'Belly of Ship', 'L1Npc', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91489, 'Jose', '$3728', '', 'L1Monster', 4698, 50, 800, 500, -60, 16, 10, 16, 6, 8, 60, 2501, -1000, 'small', 0, 8, 0, 640, 1000, 600, 1160, 1000, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2989, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91490, 'Drake Captain', '$972 Captain', '船長', 'L1Monster', 4218, 42, 1200, 50, -35, 18, 18, 20, 18, 18, 50, 1765, -45, 'small', 2, 1, 0, 960, 1280, 1280, 1280, 2000, 3, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 20, 5000, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91491, '', '', 'Squid Foot Left', 'L1Monster', 8229, 50, 4000, 50, -60, 65, 18, 16, 6, 8, 150, 0, 0, 'small', 0, 3, 0, 0, 1120, 1280, 0, 0, 0, 1, 1, 1, 1, 1, 'craken', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91492, '', '', 'Squid Foot Right', 'L1Monster', 8231, 42, 4000, 50, -60, 65, 18, 20, 18, 18, 150, 0, 0, 'small', 0, 3, 0, 0, 1000, 1320, 0, 0, 0, 1, 1, 1, 1, 1, 'craken', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91493, 'Sema', '$338', 'Sema 2', 'L1Monster', 8168, 30, 300, 500, -66, 35, 18, 15, 12, 15, 40, 2501, -10, 'small', 0, 0, 0, 640, 920, 960, 760, 960, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91494, '', '', 'Squid Foot Castgfx', 'L1Npc', 8241, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
   (91495, 'Devildom Lesser Dragon', '$7841 $2104', '', 'L1Monster', 2379, 45, 800, 120, -45, 35, 18, 12, 18, 18, 60, 2026, -45, 'large', 0, 1, 0, 960, 1360, 0, 1800, 1360, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (91500, 'Saell', '$4346', 'Paprion cave', 'L1Merchant', 7904, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1280, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91501, 'Beasamoo', '$8422', 'In front of Papillion Rare', 'L1Dwarf', 1619, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 560, 1480, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91502, 'Kimesamoo', '$8421', 'In front of Papillion Rare', 'L1Merchant', 1619, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 560, 1480, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91503, 'Shellfish', '$8424', 'Paprion cave', 'L1Monster', 7860, 1, 10, 0, 10, 125, 50, 24, 35, 8, 0, 0, 0, 'small', 1, 2, 0, 0, 1960, 0, 2000, 2400, 0, 0, 0, 1, 1, 1, 'tikal', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91504, 'Big Shellfish', '$8423', 'Paprion cave', 'L1Monster', 7862, 1, 10, 0, 10, 125, 50, 24, 35, 8, 0, 0, 0, 'small', 0, 2, 0, 0, 2080, 0, 3000, 2920, 0, 0, 0, 1, 1, 1, 'tikal', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91505, 'Outrageous Bone Eel', '$5253 $4294', 'Paprion cave', 'L1Monster', 5405, 55, 44, 900, -75, 125, 50, 24, 35, 40, 99, 4097, -80, 'small', 0, 2, 0, 800, 920, 1600, 1200, 1240, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91506, 'Rainbow Pearl', '$8415', 'Paprio Summons', 'L1Monster', 7684, 55, 44, 900, -75, 125, 50, 24, 35, 40, 99, 4097, -80, 'small', 0, 2, 0, 480, 720, 1600, 1240, 1240, 0, 0, 0, 1, 1, 1, 'fafurion', 1, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91507, 'Mysterious Rainbow Pearl', '$8416', 'Paprio Summons', 'L1Monster', 7805, 55, 36, 900, -75, 125, 50, 24, 35, 40, 99, 4097, -80, 'small', 0, 2, 0, 480, 720, 1600, 1240, 1240, 0, 0, 0, 1, 1, 1, 'fafurion', 1, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91508, 'Torenare', '$8420', 'Paprio Summons', 'L1Monster', 7719, 99, 28000, 900, -75, 125, 50, 24, 35, 40, 99, 4097, -80, 'small', 0, 2, 0, 640, 760, 1600, 1240, 1240, 0, 0, 0, 1, 1, 1, 'fafurion', 1, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91509, 'Alopus Bia', '$8419', 'Paprion cave', 'L1Monster', 7764, 58, 2100, 900, -75, 125, 50, 24, 35, 40, 99, 4097, -80, 'small', 0, 2, 0, 640, 640, 1600, 960, 1240, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91510, 'Alopus Mega', '$8418', 'Paprion cave', 'L1Monster', 7745, 58, 2400, 900, -75, 125, 50, 24, 35, 40, 99, 4097, -80, 'small', 0, 2, 0, 800, 640, 960, 1240, 1240, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91511, 'Alopus Nero', '$8417', 'Paprion cave', 'L1Monster', 7784, 62, 3700, 900, -75, 125, 50, 24, 35, 40, 99, 4097, -80, 'small', 0, 2, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91512, 'Alopus Nero', '$8417', 'Paprion cave', 'L1Monster', 7786, 64, 4700, 900, -75, 125, 50, 24, 35, 40, 99, 4097, -80, 'small', 0, 2, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91513, 'Alopus Nero', '$8417', 'Paprion cave', 'L1Monster', 7788, 66, 5700, 900, -75, 125, 50, 24, 35, 40, 99, 4097, -80, 'small', 0, 2, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (91514, 'Fafurion', '$1426', 'Fafurion Lv1', 'L1Monster', 7864, 85, 30000, 5000, -85, 78, 20, 8, 22, 18, 50, 8650, -8000, 'large', 8, 2, 0, 480, 1880, 3480, 2560, 2000, 0, 0, 0, 1, 1, 1, 'fafurion', 0, -1, -1, 0, 0, 0, 2000, 1000, 5000, 700, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (91515, 'Fafurion', '$1426', 'Fafurion Lv2', 'L1Monster', 7869, 85, 30000, 5000, -85, 78, 20, 8, 22, 18, 50, 8650, -8000, 'large', 8, 2, 0, 480, 1880, 3480, 2560, 2000, 0, 0, 0, 1, 1, 1, 'fafurion', 0, -1, -1, 0, 0, 0, 2000, 1000, 5000, 700, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (91516, 'Fafurion', '$1426', 'Fafurion Lv3', 'L1Monster', 7870, 85, 30000, 5000, -85, 78, 20, 8, 22, 18, 50, 8650, -8000, 'large', 8, 2, 0, 480, 1880, 3360, 2560, 2000, 0, 0, 0, 1, 1, 1, 'fafurion', 0, -1, -1, 0, 0, 0, 2000, 1000, 5000, 700, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (91600, 'Gunter', '$270', 'Lindviol Cave', 'L1Merchant', 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1280, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (91601, 'Sibile', '$8991', 'Lindviol Cave', 'L1Merchant', 2400, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91602, 'Freddie', '$8992', 'Lindviol Cave', 'L1Dwarf', 10669, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 560, 1480, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91603, 'Lindvior', '$2116', 'Lindvior Lv1', 'L1Monster', 8036, 90, 30000, 5000, -90, 66, 21, 18, 20, 18, 50, 7922, -8000, 'large', 1, 2, 0, 480, 1600, 2240, 2560, 2560, 0, 0, 0, 1, 1, 1, 'lindvior', 0, -1, -1, 0, 0, 0, 5000, 2000, 5000, 500, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (91604, 'Lindvior', '$2116', 'Lindvior Lv2', 'L1Monster', 8056, 90, 30000, 5000, -90, 66, 21, 18, 20, 18, 50, 7922, -8000, 'large', 1, 2, 0, 480, 1600, 2240, 2560, 2560, 0, 0, 0, 1, 1, 1, 'lindvior', 0, -1, -1, 0, 0, 0, 5000, 2000, 5000, 500, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (91605, 'Lindvior', '$2116', 'Lindvior Lv3', 'L1Monster', 8055, 90, 30000, 5000, -90, 66, 21, 18, 20, 18, 50, 7922, -8000, 'large', 1, 2, 0, 480, 1600, 2240, 2560, 2560, 0, 0, 0, 1, 1, 1, 'lindvior', 0, -1, -1, 0, 0, 0, 5000, 3000, 5000, 600, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (91606, 'Cotrot', '$8997', 'Lindviol Cave', 'L1Monster', 7905, 63, 2600, 150, -40, 20, 18, 16, 15, 15, 8, 3970, -100, 'small', 2, 1, 0, 700, 1040, 1320, 1020, 1040, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91607, 'ParPar', '$8998', 'Lindviol Cave', 'L1Monster', 7934, 63, 2300, 500, -40, 16, 15, 16, 18, 20, 12, 3970, -100, 'small', 2, 1, 0, 700, 1040, 1320, 1020, 1040, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91608, 'Parutia Garuda', '$8999', 'Lindviol Cave', 'L1Monster', 7939, 64, 3200, 700, -50, 18, 18, 18, 15, 15, 10, 4097, -300, 'small', 1, 2, 0, 900, 1200, 1320, 1020, 1040, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91609, 'Parutia Garuda', '$8999', 'Lindviol Cave', 'L1Monster', 7940, 64, 4900, 800, -50, 20, 19, 18, 15, 15, 10, 4357, -300, 'small', 1, 2, 0, 900, 1200, 1320, 1020, 1040, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91610, 'Parutia Garuda', '$8999', 'Lindviol Cave', 'L1Monster', 7941, 64, 5900, 900, -50, 22, 20, 18, 15, 15, 10, 4625, -300, 'small', 1, 2, 0, 900, 1200, 1320, 1020, 1040, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91611, 'Mine Golem (Water)', '$9000', 'Lindviol Cave', 'L1Monster', 7989, 65, 5000, 150, -72, 20, 20, 13, 18, 20, 85, 6890, -100, 'small', 1, 1, 0, 700, 1040, 1320, 1020, 1040, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91612, 'Mine Golem (Wind)', '$9000', 'Lindviol Cave', 'L1Monster', 7992, 65, 5000, 150, -70, 18, 20, 13, 12, 15, 75, 6890, -100, 'small', 2, 1, 0, 700, 1040, 1320, 1020, 1040, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91613, 'Mine Golem (Fire)', '$9000', 'Lindviol Cave', 'L1Monster', 7995, 65, 5000, 150, -62, 25, 20, 13, 10, 10, 60, 6890, -100, 'small', 4, 1, 0, 700, 1040, 1320, 1020, 1040, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91614, 'Mine Golem (Earth)', '$9000', 'Lindviol Cave', 'L1Monster', 7998, 65, 5000, 150, -65, 20, 20, 13, 15, 18, 70, 6890, -100, 'small', 8, 1, 0, 700, 1040, 1320, 1020, 1040, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91615, 'Great Spirit of Cloud', '$9001', 'Lindviol Cave', 'L1Monster', 8087, 75, 15000, 1200, -60, 18, 20, 35, 18, 25, 100, 8540, -10, 'large', 1, 2, 0, 200, 750, 820, 780, 840, 0, 0, 0, 1, 1, 1, 'lindvior', 1, -1, -1, 0, 0, 0, 5000, 100, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91616, 'Mysterious Dark Cloud', '$9002', 'Lindviol Cave', 'L1Monster', 8096, 50, 1200, 500, -32, 16, 15, 16, 18, 20, 80, 3200, -5, 'small', 1, 8, 0, 0, 500, 600, 500, 700, 0, 0, 0, 1, 1, 1, 'lindvior', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8091, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91619, '', '', 'Lindviol Reid Waterfall', 'L1FieldObject', 8138, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91620, 'Dwarf guard', '', 'Lindviol Reid', 'L1Guard', 7655, 70, 2500, 300, 0, 126, 126, 126, 126, 126, 0, 0, 0, 'large', 0, 1, 0, 800, 1640, 1120, 840, 840, 0, 0, 0, 0, 0, 0, 'guard', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (91621, 'Sand Worm', '$11993', 'Desert Renewal', 'L1Monster', 10071, 82, 30000, 5000, -90, 127, 127, 127, 127, 127, 50, 18101, -8000, 'large', 1, 4, 0, 1280, 2000, 1960, 2880, 2640, 0, 0, 0, 1, 1, 1, 'sandworm', 1, -1, -1, 0, 0, 0, 2500, 3500, 10000, 1000, 0, 0, 0, 0, 0, 0, 0, 30, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 1, 1),
   (91622, 'Ant Queen', 'Ant Queen', 'Desert Renewal Boss', 'L1Monster', 10899, 82, 30000, 5000, -90, 127, 99, 75, 80, 127, 100, 18101, -8000, 'large', 1, 2, 0, 640, 760, 0, 760, 760, 0, 0, 0, 0, 0, 0, 'ant', 0, -1, -1, 0, 0, 0, 5000, 6000, 10000, 5000, 0, 0, 0, 0, 0, 0, 0, 30, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 1, 1),
   (91623, 'Dark Desert Flower', 'Dark Desert Flower', 'Desert Renewal(召還用)', 'L1Monster', 10050, 45, 500, 60, -30, 50, 21, 10, 20, 18, 30, 1342, -1000, 'small', 1, 2, 0, 0, 2240, 1960, 2840, 2640, 0, 0, 0, 1, 1, 1, 'sandworm', 1, -1, -1, 0, 0, 0, 5000, 100, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91624, 'Dark Sand Scorpion', 'Dark Sand Scorpion', 'Desert Renewal(召還用)', 'L1Monster', 4060, 55, 800, 30, -42, 20, 14, 16, 18, 18, 35, 1297, -30, 'small', 1, 2, 0, 640, 800, 960, 800, 800, 0, 1, 0, 1, 1, 1, 'sandworm', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91625, 'Giant Strong Ant', 'Giant Strong Ant', 'Desert Renewal', 'L1Monster', 1037, 40, 400, 20, -34, 20, 28, 28, 6, 5, 72, 1940, -15, 'small', 2, 1, 1, 640, 880, 0, 880, 880, 0, 0, 0, 0, 0, 1, 'ant', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91626, 'Giant Soldier Ant', 'Giant Soldier Ant', 'Desert Renewal', 'L1Monster', 1039, 44, 600, 100, -29, 35, 22, 23, 20, 15, 76, 2580, -20, 'large', 2, 2, 1, 640, 760, 0, 760, 760, 0, 0, 0, 0, 1, 1, 'ant', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91627, 'Giant Fire Ant', 'Giant Fire Ant', 'Desert Renewal', 'L1Monster', 2460, 48, 600, 200, -33, 20, 25, 18, 16, 12, 60, 2850, -27, 'large', 2, 1, 0, 640, 760, 0, 760, 760, 0, 0, 0, 0, 1, 1, 'ant', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91628, 'Flock of Acid Ants', 'Flock of Acid Ants', 'Desert Renewal', 'L1Monster', 6161, 50, 700, 40, -35, 25, 15, 25, 10, 10, 60, 2950, -16, 'small', 2, 1, 0, 560, 1120, 0, 880, 880, 0, 0, 0, 1, 1, 1, 'ant', 1, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91629, 'Giant Acid Ant', 'Giant Acid Ant', 'Desert Renewal', 'L1Monster', 6302, 53, 750, 55, -38, 15, 18, 25, 18, 20, 60, 2990, -18, 'large', 2, 6, 0, 640, 1040, 0, 1040, 880, 0, 0, 0, 1, 1, 1, 'ant', 1, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 6306, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91630, 'Dark Scorpion', 'Dark $966', 'Desert Renewal', 'L1Monster', 1047, 51, 750, 30, -20, 18, 24, 25, 15, 12, 35, 3050, -18, 'large', 2, 2, 1, 640, 800, 960, 800, 800, 0, 1, 0, 1, 1, 0, 'sandworm', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91631, 'Dark Sand Scorpion', 'Dark Sand $966', 'Desert Renewal', 'L1Monster', 4060, 54, 700, 30, -25, 20, 26, 25, 15, 12, 35, 3190, -18, 'small', 2, 2, 0, 640, 800, 960, 800, 800, 0, 1, 0, 1, 1, 0, 'sandworm', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91632, 'Dark Basilisk', 'Dark $962', 'Desert Renewal', 'L1Monster', 1041, 61, 1300, 100, -50, 35, 25, 22, 18, 18, 30, 5580, -38, 'large', 2, 1, 1, 920, 1240, 0, 1080, 1240, 0, 0, 1, 1, 1, 1, 'sandworm', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91633, 'Raging Giant Guardian Ant', 'Raging Giant Guardian Ant', 'Desert Renewal', 'L1Monster', 6290, 65, 2980, 450, -58, 38, 38, 38, 8, 25, 90, 6890, -50, 'large', 2, 2, 0, 480, 880, 1560, 1080, 1320, 0, 0, 0, 1, 1, 0, 'ant', 1, -1, -1, 0, 0, 0, 5000, 11, 5000, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91634, 'Dark Desert Flower', 'Dark Desert Flower', 'Desert Renewal', 'L1Monster', 10050, 45, 500, 300, -20, 16, 20, 18, 5, 5, 30, 1890, -20, 'large', 2, 2, 0, 0, 1280, 0, 2560, 2560, 0, 0, 0, 1, 1, 1, 'sandworm', 0, -1, -1, 0, 0, 0, 0, 0, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 10, 0, 0, 0, 0, 0),
   (91635, 'Dark Quick Sand', 'Dark Quick Sand', 'Desert Renewal', 'L1Monster', 5574, 50, 500, 30, -35, 35, 25, 15, 26, 25, 100, 2540, -5, 'small', 2, 1, 0, 1280, 880, 0, 840, 880, 2, 0, 0, 0, 0, 0, '', 0, -1, -1, 1, 0, 0, 5000, 10, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91636, 'Desert Griffon', 'Desert $1176', 'Desert Renewal', 'L1Monster', 1204, 40, 500, 150, -27, 20, 18, 15, 15, 10, 25, 1750, -30, 'large', 2, 1, 0, 640, 1280, 1480, 1280, 1280, 0, 0, 0, 1, 1, 0, 'griffon', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91637, 'Desert Lizardman', 'Desert $1174', 'Desert Renewal', 'L1Monster', 1173, 40, 500, 80, -25, 18, 18, 20, 10, 10, 10, 1750, -30, 'small', 8, 1, 1, 640, 920, 800, 920, 920, 0, 0, 0, 1, 0, 0, 'lizardman', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91638, 'Desert Stone Golem', 'Desert $56', 'Desert Renewal', 'L1Monster', 10641, 50, 1000, 10, -35, 50, 18, 12, 6, 10, 20, 2520, -50, 'large', 2, 1, 1, 1350, 2950, 0, 2640, 2640, 0, 0, 0, 0, 0, 0, 'golem', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91639, 'Desert Floating Eye', 'Desert $6', 'Desert Renewal', 'L1Monster', 10631, 49, 650, 100, -35, 15, 20, 18, 7, 18, 25, 2240, -49, 'small', 2, 1, 1, 960, 1720, 0, 1680, 1720, 0, 0, 1, 0, 0, 0, 'elder', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (91640, 'Gale`s Shaski', 'Gale`s Shaski', 'Oren Renewal', 'L1Monster', 6778, 72, 5500, 1500, -80, 50, 20, 25, 18, 17, 120, 10890, -100, 'large', 2, 7, 0, 480, 760, 800, 800, 1040, 2, 0, 0, 1, 1, 1, 'syaski', 0, -1, -1, 0, 0, 1, 5000, 400, 5000, 300, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 6784, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (91641, 'Crazy Shaski', 'Crazy Shaski', 'Oren Renewal', 'L1Monster', 10884, 72, 5500, 1500, -80, 50, 25, 20, 18, 17, 120, 10890, -100, 'large', 2, 7, 0, 480, 760, 800, 800, 1040, 2, 0, 0, 1, 1, 1, 'syaski', 0, -1, -1, 0, 0, 1, 5000, 400, 5000, 300, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 6784, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (91642, 'Bigfoot Mayo', 'Bigfoot Mayo', 'Oren Renewal', 'L1Monster', 10891, 65, 7000, 2000, -70, 69, 25, 20, 18, 17, 90, 10890, -100, 'large', 2, 1, 0, 480, 760, 800, 800, 1040, 2, 0, 0, 1, 1, 1, 'snow', 0, -1, -1, 0, 0, 0, 5000, 400, 5000, 300, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (91643, 'Glacier Ice Man', 'Glacier $1791', 'Oren Renewal', 'L1Monster', 10354, 63, 700, 20, -48, 20, 20, 20, 18, 18, 35, 1677, -25, 'large', 8, 1, 1, 960, 1600, 1640, 1600, 1600, 0, 0, 0, 1, 0, 0, 'iceman', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91644, 'Glacier Ice Man', 'Glacier $1791', 'Oren Renewal', 'L1Monster', 10796, 65, 700, 30, -48, 26, 27, 26, 20, 20, 70, 4305, -33, 'large', 8, 1, 1, 960, 1120, 960, 1080, 1600, 0, 0, 0, 1, 1, 1, 'iceman', 1, -1, -1, 0, 0, 0, 5000, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91645, 'Glacier Yeti', 'Glacier $1786', 'Oren Renewal', 'L1Monster', 10797, 63, 800, 100, -50, 28, 25, 15, 12, 10, 26, 3901, -26, 'large', 8, 1, 1, 960, 1400, 1360, 1400, 1400, 0, 0, 0, 1, 0, 0, 'yeti', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91646, 'Glacier Snow Tiger', 'Glacier $1784', 'Oren Renewal', 'L1Monster', 10800, 63, 700, 30, -48, 26, 24, 20, 18, 15, 70, 1730, -25, 'large', 8, 1, 1, 960, 1360, 1400, 1360, 1360, 0, 0, 0, 1, 0, 0, 'tiger', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91647, 'Glacier Ice Golem', 'Glacier $1395', 'Oren Renewal', 'L1Monster', 10798, 68, 1100, 0, -55, 46, 20, 15, 10, 5, 21, 3985, -10, 'large', 8, 1, 0, 1920, 1480, 1680, 1480, 1480, 0, 0, 0, 0, 0, 0, 'golem', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91648, 'Glacier Iron Golem', 'Glacier $1789', 'Oren Renewal', 'L1Monster', 10799, 68, 1100, 10, -60, 70, 30, 8, 5, 5, 21, 4523, -28, 'large', 2, 1, 0, 1920, 1360, 1280, 1120, 1280, 0, 0, 0, 1, 1, 1, 'golem', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91649, 'Rot Zombie', 'Rot $57', 'Oren Renewal', 'L1Monster', 10790, 50, 800, 96, -35, 20, 22, 12, 8, 5, 40, 1037, -8, 'small', 2, 1, 1, 2000, 1040, 0, 1600, 1600, 1, 0, 0, 1, 0, 1, 'zombie', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91650, 'Undead Elmore Soldier', '$1790', 'Oren Renewal', 'L1Monster', 10792, 55, 900, 50, -42, 22, 20, 21, 12, 12, 40, 1442, -20, 'small', 2, 2, 0, 480, 1040, 1400, 1040, 1040, 1, 0, 0, 1, 0, 0, 'elmore', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91651, 'Undead Elmore Wizard', '$1785', 'Oren Renewal', 'L1Monster', 10793, 55, 600, 230, -40, 17, 20, 13, 10, 15, 50, 1485, -20, 'small', 2, 1, 1, 1440, 1920, 1600, 1440, 1920, 1, 0, 0, 1, 0, 0, 'elmore', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91652, 'Dark Undead Elmore Soldier', 'Dark $1790', 'Oren Renewal', 'L1Monster', 10792, 58, 900, 110, -48, 21, 21, 22, 15, 18, 41, 2860, -20, 'small', 2, 2, 0, 480, 1040, 1400, 1040, 1040, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91653, 'Dark Undead Elmore Wizard', 'Dark $1785', 'Oren Renewal', 'L1Monster', 10793, 58, 600, 230, -45, 18, 21, 15, 15, 22, 80, 2865, -20, 'small', 2, 1, 0, 1440, 1920, 1600, 1440, 1920, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91654, 'Undead Elmore General', '$1787', 'Oren Renewal', 'L1Monster', 10794, 58, 1000, 50, -53, 20, 21, 18, 15, 18, 43, 3501, -25, 'small', 2, 1, 0, 960, 1200, 1280, 1200, 1200, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91655, 'Dark Undead Elmore General', 'Dark $1787', 'Oren Renewal', 'L1Monster', 8459, 60, 1000, 110, -53, 22, 23, 20, 17, 15, 44, 3626, -25, 'large', 2, 1, 1, 960, 1200, 1280, 1200, 1200, 1, 0, 0, 1, 0, 0, '', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91656, 'Bonos Orc Archer', 'Bonos $267', 'Oren Renewal', 'L1Monster', 10624, 41, 1000, 20, -47, 12, 14, 16, 8, 10, 55, 2156, -40, 'small', 4, 8, 0, 820, 1640, 1040, 1640, 1640, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91657, 'Bonos dummy', 'Bonos $10816', 'Oren Renewal', 'L1Monster', 10623, 42, 950, 20, -54, 14, 17, 18, 12, 10, 48, 2156, -50, 'small', 4, 1, 0, 640, 1360, 1360, 1360, 1360, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91658, 'Bonos Orc Fighter', 'Bonos $266', 'Oren Renewal', 'L1Monster', 10619, 44, 1250, 20, -55, 18, 16, 14, 8, 10, 55, 2156, -50, 'small', 4, 2, 0, 640, 1040, 1520, 1040, 1040, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91659, 'Bonos Orc Pike', 'Bonos $59 Pike', 'Oren Renewal', 'L1Monster', 10622, 44, 1100, 20, -55, 18, 16, 14, 8, 10, 60, 2156, -50, 'small', 4, 2, 0, 640, 1280, 1400, 1280, 1280, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91660, 'Bonos Orc Shaman', 'Bonos $59 Shaman', 'Oren Renewal', 'L1Monster', 10625, 41, 800, 400, -50, 6, 12, 10, 13, 10, 30, 2156, -15, 'small', 4, 1, 1, 880, 1240, 0, 2160, 2160, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91661, 'Dwarf Axe', 'Dwarf $1', 'Oren Renewal', 'L1Monster', 10613, 45, 1100, 62, -56, 20, 18, 18, 16, 16, 30, 2026, -15, 'small', 8, 1, 1, 600, 1480, 1020, 1480, 1480, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (91662, 'Dwarf Archer', 'Dwarf Archer', 'Oren Renewal', 'L1Monster', 10614, 45, 900, 60, -48, 15, 16, 20, 12, 14, 45, 2026, -25, 'small', 8, 10, 0, 680, 880, 920, 1400, 1600, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (91663, 'Dwarf Soldier', 'Dwarf Soldier', 'Oren Renewal', 'L1Monster', 10609, 42, 1200, 62, -50, 18, 12, 18, 16, 16, 55, 2026, -30, 'small', 8, 1, 1, 640, 960, 1280, 1020, 1040, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (91664, 'Dwarf Pike', 'Dwarf Pike', 'Oren Renewal', 'L1Monster', 10612, 45, 1000, 50, -45, 18, 18, 18, 16, 16, 42, 2026, -30, 'small', 8, 2, 1, 680, 1280, 1020, 960, 1120, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (91665, 'Dwarf Fighter', 'Dwarf Fighter', 'Oren Renewal', 'L1Monster', 10611, 45, 1200, 70, -48, 18, 12, 10, 10, 10, 40, 2026, -30, 'small', 8, 1, 2, 700, 1040, 1320, 1020, 1040, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (91666, 'Dwarf Mage', 'Dwarf Mage', 'Oren Renewal', 'L1Monster', 10610, 42, 800, 400, -40, 15, 16, 15, 18, 20, 60, 2026, -30, 'small', 8, 1, 2, 700, 1040, 1320, 1020, 1040, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 0, 0, 1, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (98000, 'Lv52 Daming', 'Lv52 Daming', 'JP only', 'L1Monster', 10259, 52, 600, 150, 50, 15, 16, 14, 10, 13, 40, 800, 0, 'small', 0, 1, 0, 640, 560, 560, 880, 880, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 60, 5000, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98001, 'Lv52 Waiter', 'Lv52 Waiter', 'JP only', 'L1Monster', 10232, 52, 800, 30, 60, 21, 18, 12, 9, 8, 30, 800, 0, 'small', 0, 1, 0, 640, 560, 560, 880, 880, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 80, 5000, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98002, 'Lv52 Hime', 'Lv52 Hime', 'JP only', 'L1Monster', 10283, 52, 500, 150, 50, 11, 12, 24, 12, 12, 60, 800, 0, 'small', 0, 10, 0, 640, 720, 720, 880, 1040, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 50, 5000, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 66, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98003, 'Lv52 Ninja', 'Lv52 Ninja', 'JP only', 'L1Monster', 10306, 52, 600, 200, 50, 16, 10, 18, 10, 16, 50, 800, 0, 'small', 0, 1, 0, 600, 600, 600, 1120, 1440, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 60, 5000, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98004, 'Lv52 Onmyoji', 'Lv52 Onmyoji', 'JP only', 'L1Monster', 10245, 52, 400, 300, 40, 8, 12, 7, 16, 23, 50, 800, 0, 'small', 0, 1, 0, 680, 600, 600, 640, 800, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 40, 5000, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98005, 'Lv57 Daming', 'Lv57 Daming', 'JP only', 'L1Monster', 10262, 57, 1000, 200, 60, 17, 18, 16, 12, 15, 50, 1300, 0, 'small', 0, 1, 0, 640, 560, 560, 880, 880, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 100, 5000, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98006, 'Lv57 Waiter', 'Lv57 Waiter', 'JP only', 'L1Monster', 10235, 57, 1300, 80, 70, 26, 20, 12, 9, 8, 40, 1300, 0, 'small', 0, 1, 0, 640, 560, 560, 880, 880, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 130, 5000, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98007, 'Lv57 Hime', 'Lv57 Hime', 'JP only', 'L1Monster', 10286, 57, 900, 200, 60, 11, 12, 29, 12, 14, 70, 1300, 0, 'small', 0, 10, 0, 640, 720, 720, 880, 1040, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 90, 5000, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 66, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98008, 'Lv57 Ninja', 'Lv57 Ninja', 'JP only', 'L1Monster', 10309, 57, 1000, 250, 60, 21, 10, 20, 10, 16, 60, 1300, 0, 'small', 0, 1, 0, 600, 600, 600, 1120, 1440, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 100, 5000, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98009, 'Lv57 Onmyoji', 'Lv57 Onmyoji', 'JP only', 'L1Monster', 10248, 57, 700, 350, 50, 8, 12, 7, 18, 28, 60, 1300, 0, 'small', 0, 1, 0, 680, 600, 600, 640, 800, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 70, 5000, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98010, 'Lv62 Daming', 'Lv62 Daming', 'JP only', 'L1Monster', 10277, 62, 1400, 250, 70, 19, 20, 18, 14, 17, 60, 1800, 0, 'small', 0, 1, 0, 640, 560, 480, 880, 880, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 140, 5000, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98011, 'Lv62 Waiter', 'Lv62 Waiter', 'JP only', 'L1Monster', 10238, 62, 1800, 130, 80, 31, 22, 12, 9, 8, 50, 1800, 0, 'small', 0, 1, 0, 640, 560, 560, 880, 880, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 180, 5000, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98012, 'Lv62 Hime', 'Lv62 Hime', 'JP only', 'L1Monster', 10275, 62, 1200, 250, 70, 11, 12, 34, 12, 16, 80, 1800, 0, 'small', 0, 10, 0, 640, 720, 680, 640, 760, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 120, 5000, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 66, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98013, 'Lv62 Ninja', 'Lv62 Ninja', 'JP only', 'L1Monster', 10276, 62, 1400, 300, 70, 26, 10, 22, 10, 16, 70, 1800, 0, 'small', 0, 1, 0, 600, 600, 520, 1120, 1440, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 0, 5000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98014, 'Lv62 Onmyoji', 'Lv62 Onmyoji', 'JP only', 'L1Monster', 10273, 62, 1000, 400, 60, 8, 12, 7, 20, 33, 70, 1800, 0, 'small', 0, 1, 0, 680, 600, 560, 640, 800, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 0, 5000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98015, 'Soten No Knight', 'Soten No Knight', 'event', 'L1Monster', 7959, 75, 1000, 500, -70, 25, 25, 25, 25, 25, 99, 2000, 0, 'large', 0, 2, 0, 640, 600, 0, 760, 880, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 50, 5000, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98016, 'Soten No Knight (Bow)', 'Soten No Knight', 'event', 'L1Monster', 7959, 75, 1000, 500, -70, 25, 25, 25, 25, 25, 99, 2000, 0, 'large', 0, 10, 0, 640, 760, 0, 760, 880, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 5000, 50, 5000, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7972, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98017, 'Young Ken Lauel', 'Young Ken Lauel', 'young ken lauel', 'L1Monster', 8817, 75, 2000, 500, -75, 30, 30, 30, 30, 30, 99, 3000, 0, 'small', 0, 1, 0, 640, 600, 720, 640, 720, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98018, 'Young Kelenis', 'Young Kelenis', 'young kelenis', 'L1Monster', 8774, 75, 2000, 1000, -75, 30, 30, 30, 30, 30, 99, 3000, 0, 'small', 0, 1, 0, 640, 640, 800, 640, 720, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98019, 'Young Helvine', 'Young Helvine', 'young helvine', 'L1Monster', 8900, 75, 2000, 500, -75, 30, 30, 30, 30, 30, 99, 3000, 0, 'small', 0, 10, 0, 640, 680, 800, 640, 720, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8904, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98020, 'Young Dantes', 'Young Dantes', 'young dantes', 'L1Monster', 8851, 75, 2000, 500, -75, 30, 30, 30, 30, 30, 99, 3000, 0, 'small', 0, 1, 0, 640, 560, 800, 640, 720, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98021, 'Young Gunter', 'Young Gunter', 'young gunter', 'L1Monster', 8812, 80, 2200, 500, -80, 35, 35, 35, 35, 35, 99, 3000, 0, 'small', 0, 1, 0, 640, 600, 800, 640, 720, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98022, 'Young Joewoo', 'Young Joewoo', 'young joewoo', 'L1Monster', 9003, 80, 2200, 1000, -80, 35, 35, 35, 35, 35, 99, 3000, 0, 'small', 0, 1, 0, 640, 600, 800, 640, 720, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98023, 'Young Gilian', 'Young Gilian', 'young gilian', 'L1Monster', 8913, 80, 2200, 500, -80, 35, 35, 35, 35, 35, 99, 3000, 0, 'small', 0, 10, 0, 640, 640, 800, 640, 720, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8916, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (98024, 'Young Bluedica', 'Young Bluedica', 'young bluedica', 'L1Monster', 8978, 80, 2200, 500, -80, 35, 35, 35, 35, 35, 99, 3000, 0, 'small', 0, 1, 0, 640, 600, 800, 640, 720, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99001, 'Narama', '$14413', '', 'L1Monster', 10588, 26, 400, 30, -13, 17, 18, 20, 12, 12, 26, 677, -26, 'small', 0, 5, 1, 960, 1520, 1520, 1600, 1600, 0, 0, 0, 0, 0, 0, 'hinomoto', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 10584, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99002, 'Angry Nagama', '$14707', '', 'L1Monster', 10968, 26, 500, 30, -13, 17, 18, 20, 12, 12, 26, 677, -26, 'small', 0, 5, 0, 960, 1520, 1520, 1600, 1600, 0, 0, 0, 1, 1, 1, 'hinomoto', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 10584, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99003, 'Sickle', '$14415', '', 'L1Monster', 10599, 30, 350, 320, -11, 22, 20, 20, 25, 18, 39, 901, -30, 'small', 1, 7, 1, 1280, 1760, 1400, 1760, 1760, 0, 0, 0, 1, 1, 1, 'hinomoto', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 10603, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99004, 'Kamayu', '$14708', '', 'L1Monster', 10969, 30, 450, 320, -11, 22, 20, 20, 25, 18, 39, 901, -30, 'small', 1, 7, 0, 1280, 1760, 1400, 1760, 1760, 0, 0, 0, 1, 1, 1, 'hinomoto', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 10603, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99005, 'Kappa', '$14414', '', 'L1Monster', 10566, 33, 450, 40, -25, 25, 25, 25, 25, 25, 40, 1090, -33, 'small', 2, 1, 1, 1280, 1760, 1520, 1800, 2000, 0, 0, 0, 1, 1, 1, 'hinomoto', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99006, 'Phantom Demon', '$14709', '', 'L1Monster', 10655, 45, 50, 250, -10, 55, 25, 45, 25, 24, 70, 2026, -70, 'large', 0, 1, 0, 1440, 1920, 1600, 2240, 2240, 0, 0, 0, 0, 0, 0, 'hinomoto', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 1),
   (99007, 'Niu Gui', '$14416', '', 'L1Monster', 10655, 45, 10000, 250, -40, 55, 25, 45, 25, 24, 70, 2026, -70, 'large', 2, 7, 0, 1440, 1920, 1600, 2240, 2240, 0, 0, 0, 1, 1, 1, 'hinomoto', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 10672, 0, -1, 0, 0, 1, 0, 0, 0, 1),
   (99008, 'Ushioni No Chi', '$14798', '', 'L1Monster', 1082, 30, 450, 320, -11, 22, 20, 20, 25, 18, 39, 901, -30, 'small', 2, 1, 1, 1280, 1760, 1400, 1760, 1760, 0, 0, 0, 1, 1, 1, 'hinomoto', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99009, 'Potter`s Neck', '$14417', 'Hinomoto Update(Unimplemented)', 'L1Monster', 10680, 99, 999, 999, -99, 99, 99, 99, 99, 99, 99, 999, -99, 'small', 0, 1, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99010, 'Parasol Ghost', '$14418', 'Hinomoto Update(Unimplemented)', 'L1Monster', 10750, 99, 999, 999, -99, 99, 99, 99, 99, 99, 99, 999, -99, 'small', 0, 1, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99011, 'Coloring', '$14419', 'Hinomoto Update(Unimplemented)', 'L1Monster', 10576, 99, 999, 999, -99, 99, 99, 99, 99, 99, 99, 999, -99, 'small', 0, 1, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99012, 'Red Demon', '$14420', 'Hinomoto Update(Unimplemented)', 'L1Monster', 10659, 99, 999, 999, -99, 99, 99, 99, 99, 99, 99, 999, -99, 'small', 0, 1, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99013, 'Blue Demon', '$14420', 'Hinomoto Update(Unimplemented)', 'L1Monster', 10661, 99, 999, 999, -99, 99, 99, 99, 99, 99, 99, 999, -99, 'small', 0, 1, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99014, 'Tengu', '$14421', 'Hinomoto Update(Unimplemented)', 'L1Monster', 10759, 99, 999, 999, -99, 99, 99, 99, 99, 99, 99, 999, -99, 'small', 0, 1, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99015, 'Ashura statue', '$14423', 'Hinomoto Update(Unimplemented)', 'L1Monster', 10768, 99, 999, 999, -99, 99, 99, 99, 99, 99, 99, 999, -99, 'small', 0, 1, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99016, 'Nine-Tailed fox - Tamamogi', '$14424', 'Hinomoto Update(Unimplemented)', 'L1Monster', 10773, 99, 9999, 9999, -99, 99, 99, 99, 99, 99, 99, 9999, -99, 'large', 0, 1, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99017, 'Nine-Tailed Fox - Nine-Tailed', '$14425', 'Hinomoto Update(Unimplemented)', 'L1Monster', 10851, 99, 9999, 9999, -99, 99, 99, 99, 99, 99, 99, 9999, -99, 'large', 0, 1, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99018, 'Nine-Tailed Fox - Killing Stone', '$14426', 'Hinomoto Update(Unimplemented)', 'L1Monster', 10859, 99, 9999, 9999, -99, 99, 99, 99, 99, 99, 99, 9999, -99, 'large', 0, 1, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99019, 'Gashadokuro', '$14422', 'Hinomoto Update(Unimplemented)', 'L1Monster', 10913, 99, 99999, 99999, -99, 99, 99, 99, 99, 99, 99, 99999, -99, 'large', 0, 1, 0, 1120, 960, 1160, 960, 1400, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99020, 'Elephant Lava Golem', 'Elephant Lava Golem', '', 'L1Merchant', 8334, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1280, 2640, 0, 2640, 2640, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99021, 'Shadow Sleep', '', 'Effect object', 'L1Effect', 9218, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99022, 'Skeleton Guard', '$1018', 'DVC Renewal', 'L1Monster', 1134, 42, 280, 60, -25, 18, 15, 16, 14, 14, 25, 1765, -30, 'small', 2, 2, 1, 640, 880, 840, 1680, 1680, 1, 0, 0, 1, 1, 0, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99023, 'Skeleton Fighter', '$1017', 'DVC Renewal', 'L1Monster', 1132, 42, 280, 60, -22, 20, 14, 14, 14, 14, 25, 1765, -30, 'small', 2, 1, 1, 480, 840, 840, 1680, 1680, 1, 0, 0, 1, 1, 0, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99024, 'Koma Yum', '$7754', 'DVC Renewal', 'L1Monster', 7481, 45, 400, 150, -30, 16, 10, 9, 16, 16, 30, 2026, -1000, 'small', 0, 1, 0, 640, 640, 1120, 960, 1040, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99025, 'Koma Shin', '$7755', 'DVC Renewal', 'L1Monster', 7489, 45, 400, 200, -30, 14, 12, 12, 16, 16, 80, 2026, -100, 'small', 0, 1, 0, 640, 640, 1120, 960, 1040, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99026, 'Muryan', '$991', 'DVC Renewal', 'L1Monster', 1082, 45, 400, 50, -20, 17, 18, 16, 25, 16, 35, 2026, -40, 'small', 2, 1, 1, 640, 720, 0, 1080, 720, 0, 0, 0, 1, 1, 0, 'murrian', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99027, 'Troll', '$989', 'DVC Renewal', 'L1Monster', 1098, 43, 300, 30, -20, 19, 17, 17, 8, 8, 20, 1850, -20, 'large', 2, 1, 1, 960, 1200, 1040, 1520, 1520, 0, 0, 0, 1, 0, 0, 'troll', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99028, 'Ettin', '$1010', 'DVC Renewal', 'L1Monster', 1128, 45, 500, 70, -32, 20, 18, 16, 18, 16, 50, 2026, -40, 'large', 2, 2, 1, 640, 1160, 1240, 1160, 1160, 0, 0, 0, 1, 1, 0, 'brute', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99029, 'Koma Kum', '$7756', 'DVC Renewal', 'L1Monster', 7496, 46, 600, 200, -33, 20, 16, 14, 10, 16, 60, 2117, -300, 'large', 0, 1, 0, 1120, 960, 1120, 960, 1280, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 5000, 2, 5000, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 1),
   (99030, 'Succubus', '$1000', 'DVC Renewal', 'L1Monster', 1112, 47, 400, 250, -30, 15, 15, 18, 26, 20, 50, 2210, -40, 'small', 2, 1, 0, 640, 800, 1080, 1440, 800, 2, 0, 0, 1, 1, 1, 'succubus', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99031, 'Succubus Queen', '$1019', 'DVC Renewal', 'L1Monster', 1116, 49, 500, 400, -40, 18, 18, 18, 26, 18, 80, 2402, -50, 'small', 2, 1, 0, 640, 800, 1080, 1080, 800, 2, 0, 0, 1, 1, 1, 'succubus', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99032, 'Terra Dragon', '$7771', 'DVC Renewal', 'L1Monster', 7566, 52, 700, 270, -45, 18, 16, 14, 18, 18, 60, 2705, -50, 'large', 2, 1, 0, 960, 640, 1120, 1400, 1400, 0, 0, 0, 1, 1, 1, 'Dragon', 1, -1, -1, 0, 0, 0, 0, 100, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99033, 'Vermos', 'Vermos', 'DVC Renewal', 'L1Monster', 1245, 58, 43000, 800, -80, 50, 21, 10, 20, 18, 99, 3365, -10000, 'large', 2, 2, 0, 480, 2240, 1960, 2840, 2640, 0, 1, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 200, 5000, 200, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99034, 'Sand Worm', '$11993', 'Desert Renewal', 'L1Monster', 10071, 82, 30000, 5000, -90, 127, 127, 127, 127, 127, 50, 18101, -8000, 'large', 1, 4, 0, 1280, 2000, 1960, 2880, 2640, 0, 0, 0, 1, 1, 1, 'sandworm', 1, -1, -1, 0, 0, 0, 2500, 3500, 10000, 1000, 0, 0, 0, 0, 0, 0, 0, 30, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 1, 1),
   (99035, 'Dark Desert Flower', 'Dark Desert Flower', 'Desert Renewal', 'L1Monster', 10050, 45, 500, 60, -30, 50, 21, 10, 20, 18, 30, 1342, -1000, 'small', 1, 2, 0, 0, 2240, 1960, 2840, 2640, 0, 0, 0, 1, 1, 1, 'sandworm', 1, -1, -1, 0, 0, 0, 5000, 100, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99036, 'Dark Sand Scorpion', 'Dark Sand Scorpion', 'Desert Renewal (for summoning)', 'L1Monster', 4060, 55, 800, 30, -42, 20, 14, 16, 18, 18, 35, 1297, -30, 'small', 1, 2, 0, 640, 800, 960, 800, 800, 0, 1, 0, 1, 1, 1, 'sandworm', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99037, 'Likante', '$13725', 'TI Renewal', 'L1Monster', 10596, 76, 1890, 50, -60, 38, 18, 16, 15, 12, 60, 8980, -30, 'large', 1, 1, 0, 400, 840, 980, 1400, 1600, 0, 1, 0, 1, 0, 0, 'wolfman', 0, -1, -1, 0, 0, 1, 1000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 1),
   (99038, 'Zakarl', '$13720', 'TI Renewal', 'L1Monster', 10598, 45, 920, 20, -50, 25, 15, 16, 13, 13, 45, 1765, -25, 'small', 1, 1, 0, 680, 840, 960, 1080, 960, 5, 0, 0, 1, 0, 0, 'wolfman', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99039, 'Kazarl', '$13721', 'TI Renewal', 'L1Monster', 10595, 45, 900, 60, -48, 22, 16, 17, 12, 14, 48, 1765, -25, 'small', 1, 1, 0, 680, 880, 920, 1400, 1600, 5, 0, 0, 1, 0, 0, 'wolfman', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99040, 'Deraka', '$13726', 'TI Renewal', 'L1Monster', 10594, 40, 800, 20, -40, 15, 15, 12, 10, 10, 10, 1765, -9, 'small', 1, 1, 0, 520, 640, 0, 960, 960, 5, 0, 0, 1, 0, 0, 'wolfman', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99041, 'Dewarug Axeman', '$13744', 'TI Renewal', 'L1Monster', 10613, 45, 1100, 62, -56, 20, 18, 18, 16, 16, 30, 2026, -15, 'small', 8, 1, 1, 600, 1480, 1020, 1480, 1480, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99042, 'Dewarug Archer', '$13745', 'TI Renewal', 'L1Monster', 10614, 45, 900, 60, -48, 15, 16, 20, 12, 14, 45, 2026, -25, 'small', 8, 10, 0, 680, 880, 920, 1400, 1600, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99043, 'Dewarug General', '$13740', 'TI Renewal', 'L1Monster', 10609, 42, 1200, 62, -50, 18, 12, 18, 16, 16, 55, 2026, -30, 'small', 8, 1, 1, 640, 960, 1280, 1020, 1040, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99044, 'Dewarug Pikeman', '$13743', 'TI Renewal', 'L1Monster', 10612, 45, 1000, 50, -45, 18, 18, 18, 16, 16, 42, 2026, -30, 'small', 8, 2, 1, 680, 1280, 1020, 960, 1120, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99045, 'Dewarug Soldier', '$13742', 'TI Renewal', 'L1Monster', 10611, 45, 1200, 70, -48, 18, 12, 10, 10, 10, 40, 2026, -30, 'small', 8, 1, 2, 700, 1040, 1320, 1020, 1040, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0),
   (99046, 'Dewarug White Shamon', '$13741', 'TI Renewal', 'L1Monster', 10610, 42, 800, 400, -40, 15, 16, 15, 18, 20, 60, 2026, -30, 'small', 8, 1, 2, 700, 1040, 1320, 1020, 1040, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 0, 0, 1, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 1),
   (99047, 'Capalre', '$13724', 'TI Renewal', 'L1Monster', 10042, 60, 1800, 70, -68, 40, 32, 25, 20, 20, 90, 7210, -30, 'large', 8, 1, 2, 640, 1040, 1320, 1020, 1040, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 0, 0, 1, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99048, 'Orc Soldier', '$13882', 'TI Renewal', 'L1Monster', 10616, 40, 720, 20, -58, 14, 14, 14, 8, 10, 45, 1870, -40, 'small', 4, 1, 0, 620, 1040, 1360, 1040, 1040, 0, 0, 0, 0, 0, 0, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99049, 'Orc Archer', '$13883', 'TI Renewal', 'L1Monster', 10617, 41, 640, 20, -47, 12, 14, 16, 8, 10, 55, 1870, -40, 'small', 4, 8, 0, 960, 1640, 1040, 1640, 1640, 0, 0, 0, 0, 0, 0, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99050, 'Orc Swordsman', '$13885', 'TI Renewal', 'L1Monster', 10619, 44, 710, 20, -55, 18, 16, 14, 8, 10, 55, 1870, -50, 'small', 4, 2, 0, 640, 1040, 1520, 1040, 1040, 0, 0, 0, 0, 0, 0, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99051, 'Orc Pikeman', '$13886', 'TI Renewal', 'L1Monster', 10620, 44, 690, 20, -55, 18, 16, 14, 8, 10, 60, 1870, -50, 'small', 4, 2, 0, 640, 1280, 1400, 1280, 1280, 0, 0, 0, 0, 0, 0, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99052, 'Orc Shamon', '$13881', 'TI Renewal', 'L1Monster', 10615, 41, 590, 400, -50, 6, 12, 10, 13, 10, 30, 1870, -15, 'small', 4, 1, 1, 960, 1240, 0, 2160, 2160, 0, 0, 0, 0, 0, 0, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99053, 'Nekrose', '$13738', 'TI Renewal', 'L1Monster', 10621, 70, 1790, 500, -66, 57, 55, 25, 8, 10, 60, 6720, -50, 'large', 4, 2, 0, 550, 1280, 1400, 1280, 1280, 0, 0, 0, 0, 0, 0, 'orc', 1, -1, -1, 0, 0, 1, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 1),
   (99054, 'Ponos Orc Archer', '$13879', 'TI Renewal', 'L1Monster', 10624, 41, 1000, 20, -47, 12, 14, 16, 8, 10, 55, 2156, -40, 'small', 4, 8, 0, 820, 1640, 1040, 1640, 1640, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99055, 'Ponos Orc Axeman', '$13878', 'TI Renewal', 'L1Monster', 10623, 42, 950, 20, -54, 14, 17, 18, 12, 10, 48, 2156, -50, 'small', 4, 1, 0, 640, 1360, 1360, 1360, 1360, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99056, 'Ponose Orc', '$13733', 'TI Renewal', 'L1Monster', 10619, 44, 1250, 20, -55, 18, 16, 14, 8, 10, 55, 2156, -50, 'small', 4, 2, 0, 640, 1040, 1520, 1040, 1040, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99057, 'Ponos Orc Swordsman', '$13877', 'TI Renewal', 'L1Monster', 10622, 44, 1100, 20, -55, 18, 16, 14, 8, 10, 60, 2156, -50, 'small', 4, 2, 0, 640, 1280, 1400, 1280, 1280, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99058, 'Ponos Orc Shaman', '$13880', 'TI Renewal', 'L1Monster', 10625, 41, 800, 400, -50, 6, 12, 10, 13, 10, 30, 2156, -15, 'small', 4, 1, 1, 880, 1240, 0, 2160, 2160, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99059, 'Orukuce', '$13739', 'TI Renewal', 'L1Monster', 10626, 70, 1990, 500, -69, 60, 67, 28, 8, 10, 60, 7720, -50, 'large', 4, 2, 0, 550, 1280, 1400, 1280, 1280, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 1, 5000, 150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 1),
   (99060, 'Turncoat Elder', '$13752 $19', 'TI Renewal', 'L1Monster', 10630, 52, 720, 500, -38, 12, 18, 12, 20, 20, 105, 2240, -100, 'small', 2, 1, 0, 640, 880, 800, 600, 800, 0, 0, 0, 1, 1, 1, 'elder', 1, -1, -1, 0, 0, 0, 0, 0, 5000, 200, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 3, 0, 0, 0, 0, 0),
   (99061, 'Sly Floating Eye', '$13746 $6', 'TI Renewal', 'L1Monster', 10631, 49, 650, 30, -34, 12, 18, 15, 7, 9, 20, 2240, -49, 'small', 2, 1, 1, 960, 1720, 0, 1680, 1720, 0, 0, 1, 0, 0, 0, 'elder', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99062, 'Sly Elder', '$13746 $19', 'TI Renewal', 'L1Monster', 10629, 51, 700, 300, -36, 10, 15, 10, 18, 18, 30, 2240, 200, 'small', 2, 1, 1, 800, 1800, 840, 720, 960, 0, 0, 0, 1, 1, 0, 'elder', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99063, 'Sly Arachnevil', '$13746 $265', 'TI Renewal', 'L1Monster', 10627, 46, 760, 30, -33, 20, 18, 15, 6, 5, 80, 2480, -48, 'large', 2, 2, 0, 420, 840, 0, 1680, 1680, 0, 0, 0, 0, 0, 0, 'spider', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99064, 'Sly Arachnevil Elder', '$13746 $319', 'TI Renewal', 'L1Monster', 10627, 48, 880, 30, -35, 21, 20, 15, 6, 5, 86, 2520, -54, 'large', 2, 2, 0, 400, 840, 0, 1680, 1680, 0, 1, 0, 0, 0, 0, 'spider', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99065, 'Arlpeer', '$13747', 'TI Renewal', 'L1Monster', 10632, 68, 1750, 300, -57, 21, 20, 15, 15, 18, 92, 7370, -54, 'large', 2, 2, 0, 480, 940, 0, 1680, 1680, 0, 1, 0, 0, 0, 0, 'spider', 1, -1, -1, 0, 0, 1, 5000, 200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 1),
   (99066, 'Rupus', '$13749', 'TI Renewal', 'L1Monster', 10635, 54, 880, 108, -51, 20, 18, 15, 8, 10, 86, 5680, -50, 'large', 4, 2, 0, 640, 1040, 1520, 1040, 1040, 0, 0, 0, 0, 0, 0, 'orc', 0, -1, -1, 0, 0, 1, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99067, 'Enternity Slime', '$13751', 'TI Renewal', 'L1Monster', 10642, 60, 600, 100, -60, 20, 21, 20, 14, 14, 77, 1050, -50, 'small', 8, 1, 1, 840, 640, 0, 640, 640, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 1, 60, 0, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99068, 'Stone Golem', '$56', 'TI Renewal', 'L1Monster', 10641, 53, 2100, 50, -11, 60, 18, 12, 6, 10, 15, 2870, -50, 'large', 2, 1, 1, 1350, 2950, 0, 2640, 2640, 0, 0, 0, 0, 0, 0, 'golem', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99069, 'Gremlin', '$1046', 'TI Renewal', 'L1Monster', 1154, 53, 380, 50, -5, 15, 18, 25, 8, 9, 10, 4120, -5, 'small', 2, 1, 1, 320, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99070, 'Black Knight', '$13748', 'TI Renewal', 'L1Monster', 4003, 55, 750, 20, -32, 20, 20, 17, 14, 14, 20, 1870, -15, 'small', 0, 2, 1, 480, 1120, 760, 760, 760, 0, 0, 0, 0, 1, 0, 'antiking', 1, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99071, 'Kurtz', '$274', 'TI Renewal', 'L1Monster', 3101, 72, 2800, 290, -69, 77, 20, 18, 15, 17, 75, 8290, -120, 'small', 0, 1, 0, 640, 680, 1080, 960, 1040, 0, 0, 0, 0, 1, 0, 'antiking', 1, 0, 4, 0, 0, 0, 5000, 450, 5000, 200, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99072, 'Corroded Skeleton Knight', '$13753 $4797', 'TI Renewal (Cave)', 'L1Monster', 10654, 70, 9250, 250, -70, 25, 28, 20, 10, 15, 50, 9810, -100, 'large', 2, 2, 0, 960, 1200, 1240, 1200, 1480, 4, 0, 0, 1, 1, 1, 'skeleton', 1, -1, -1, 0, 0, 0, 5000, 200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (99073, 'Corroded Zombie', '$13753 $57', 'TI Renewal (Cave)', 'L1Monster', 10643, 50, 800, 96, -40, 30, 25, 6, 5, 2, 70, 2005, -35, 'small', 2, 1, 0, 1280, 1120, 1120, 1040, 1040, 1, 0, 0, 1, 0, 1, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99074, 'Corroded Skeleton Axeman', '$13753 $987', 'TI Renewal (Cave)', 'L1Monster', 10647, 53, 860, 96, -50, 32, 30, 14, 12, 10, 90, 2122, -28, 'small', 2, 1, 0, 960, 1160, 920, 1120, 1280, 1, 0, 0, 1, 1, 1, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99075, 'Corroded Skeleton Soldier', '$13753 $988', 'TI Renewal (Cave)', 'L1Monster', 10648, 53, 900, 106, -45, 25, 14, 20, 12, 10, 80, 2122, -28, 'small', 2, 1, 0, 960, 1160, 920, 1120, 1280, 1, 0, 0, 1, 1, 1, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99076, 'Corroded Skeleton Archer', '$13753 $986', 'TI Renewal (Cave)', 'L1Monster', 10649, 53, 820, 106, -43, 16, 14, 35, 12, 18, 90, 2122, -12, 'small', 2, 6, 0, 960, 720, 1120, 840, 1280, 1, 0, 0, 1, 1, 1, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 66, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99077, 'Corroded Zombie General', '$13753 $4794', 'TI Renewal (Cave)', 'L1Monster', 10651, 60, 1240, 250, -60, 35, 35, 25, 12, 10, 150, 2430, -30, 'small', 2, 1, 0, 960, 1120, 1160, 1200, 1280, 1, 0, 0, 1, 1, 1, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99078, 'Corroded Zombie Wizard', '$13753 $4795', 'TI Renewal (Cave)', 'L1Monster', 4937, 57, 720, 500, -55, 16, 14, 16, 30, 35, 120, 2430, -30, 'small', 2, 1, 0, 960, 1240, 1200, 1120, 1120, 1, 0, 0, 1, 1, 1, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99079, 'Baphomet`s Follower', '$13842', 'TI Renewal (Cave)', 'L1Monster', 2763, 51, 5218, 50, -45, 9, 11, 14, 12, 12, 75, 7270, -10, 'large', 1, 1, 0, 960, 920, 0, 1480, 1480, 2, 0, 0, 1, 1, 1, 'skeleton', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99080, 'Baphomet', '$306', 'TI Renewal (Cave)', 'L1Monster', 53, 72, 9800, 550, -67, 69, 25, 20, 18, 17, 90, 10890, -100, 'small', 2, 1, 0, 480, 760, 800, 800, 1040, 2, 0, 0, 1, 1, 1, 'skeleton', 0, -1, -1, 0, 0, 0, 5000, 400, 5000, 300, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99081, 'Arachnevil Elder of Trial', '$13854', 'TI Renewal', 'L1Monster', 10627, 48, 880, 30, -35, 21, 20, 15, 6, 5, 86, 2520, -54, 'large', 2, 2, 0, 480, 840, 0, 1680, 1680, 0, 1, 0, 0, 0, 0, 'spider', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99082, 'Dragon Messenger', 'Dragon Messenger', 'DVC Portal', 'L1Teleporter', 7554, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (99083, '', '', 'Alfia`s nest', 'L1FieldObject', 10697, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99084, '', '', 'Sandstorm', 'L1Monster', 10947, 1, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'large', 0, 0, 0, 1920, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99085, 'Gale`s Shaski', 'Gale`s Shaski', 'Oren Renewal', 'L1Monster', 6778, 72, 5500, 1500, -80, 50, 20, 25, 18, 17, 120, 10890, -100, 'large', 2, 7, 0, 480, 760, 800, 800, 1040, 2, 0, 0, 1, 1, 1, 'syaski', 0, -1, -1, 0, 0, 1, 5000, 400, 5000, 300, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 6784, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99086, 'Crazy Shaski', 'Crazy Shaski', 'Oren Renewal', 'L1Monster', 10884, 72, 5500, 1500, -80, 50, 25, 20, 18, 17, 120, 10890, -100, 'large', 2, 7, 0, 480, 760, 800, 800, 1040, 2, 0, 0, 1, 1, 1, 'syaski', 0, -1, -1, 0, 0, 1, 5000, 400, 5000, 300, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 6784, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99087, 'Bigfoot Mayo', 'Bigfoot Mayo', 'Oren Renewal', 'L1Monster', 10891, 65, 7000, 2000, -70, 69, 25, 20, 18, 17, 90, 10890, -100, 'large', 2, 1, 0, 480, 760, 800, 800, 1040, 2, 0, 0, 1, 1, 1, 'snow', 0, -1, -1, 0, 0, 0, 5000, 400, 5000, 300, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99088, 'Aden Chamber of Commerce', '$3237', '', 'L1Merchant', 1216, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0, 0, 0),
   (99089, 'Ant Queen', 'Ant Queen', 'Desert Renewal Boss', 'L1Monster', 10899, 82, 30000, 5000, -90, 127, 99, 75, 80, 127, 100, 18101, -8000, 'large', 1, 2, 0, 640, 760, 0, 760, 760, 0, 0, 0, 0, 0, 0, 'ant', 0, -1, -1, 0, 0, 0, 5000, 6000, 10000, 5000, 0, 0, 0, 0, 0, 0, 0, 30, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 1, 1),
   (99090, 'Jack-O-Lantern', '$2063', 'Lv30', 'L1Monster', 2501, 30, 550, 5, -5, 18, 17, 20, 5, 6, 10, 901, 0, 'small', 0, 1, 0, 480, 1160, 1720, 1160, 1160, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100151, 7065, 0, 1, 0, 0, 0, 0),
   (99091, 'Jack-O-Lantern', '$2064', 'Lv45', 'L1Monster', 2501, 45, 650, 5, -33, 18, 17, 20, 5, 6, 10, 2026, 0, 'small', 0, 1, 0, 480, 1160, 1720, 1160, 1160, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100151, 7065, 0, 1, 0, 0, 0, 0),
   (99092, 'Valakas', '$1605', '寝ている', 'L1Monster', 10984, 80, 30000, 5000, -90, 90, 55, 50, 20, 70, 50, 18101, -8000, 'large', 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 5000, 7500, 10000, 5000, 0, 0, 0, 0, 0, 0, 0, 30, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 1, 0, 0, 1),
   (99093, 'Bar', 'Bar', 'Kakashi NPC for Halloween', 'L1Merchant', 6399, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99094, 'Giant Strong Ant', 'Giant Strong Ant', 'Desert Renewal', 'L1Monster', 1037, 40, 400, 20, -34, 20, 28, 28, 6, 5, 72, 1940, -15, 'small', 2, 1, 1, 640, 880, 0, 880, 880, 0, 0, 0, 0, 0, 1, 'ant', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99095, 'Giant Rush Ant', 'Giant Rush Ant', 'Desert Renewal', 'L1Monster', 1039, 44, 600, 100, -29, 35, 22, 23, 20, 15, 76, 2580, -20, 'large', 2, 2, 1, 640, 760, 0, 760, 760, 0, 0, 0, 0, 1, 1, 'ant', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99096, 'Giant Fire Ant', 'Giant Fire Ant', 'Desert Renewal', 'L1Monster', 2460, 48, 600, 200, -33, 20, 25, 18, 16, 12, 60, 2850, -27, 'large', 2, 1, 0, 640, 760, 0, 760, 760, 0, 0, 0, 0, 1, 1, 'ant', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99097, 'Flock of Acid Ants', 'Flock of Acid Ants', 'Desert Renewal', 'L1Monster', 6161, 50, 700, 40, -35, 25, 15, 25, 10, 10, 60, 2950, -16, 'small', 2, 1, 0, 560, 1120, 0, 880, 880, 0, 0, 0, 1, 1, 1, 'ant', 1, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99098, 'Giant Acid Ant', 'Giant Acid Ant', 'Desert Renewal', 'L1Monster', 6302, 53, 750, 55, -38, 15, 18, 25, 18, 20, 60, 2990, -18, 'large', 2, 6, 0, 640, 1040, 0, 1040, 880, 0, 0, 0, 1, 1, 1, 'ant', 1, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 6306, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99099, 'Dark Scorpion', 'Dark $966', 'Desert Renewal', 'L1Monster', 1047, 51, 750, 30, -20, 18, 24, 25, 15, 12, 35, 3050, -18, 'large', 2, 2, 1, 640, 800, 960, 800, 800, 0, 1, 0, 1, 1, 0, 'sandworm', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99100, 'Dark Sand Scorpion', 'Dark Sand $966', 'Desert Renewal', 'L1Monster', 4060, 54, 700, 30, -25, 20, 26, 25, 15, 12, 35, 3190, -18, 'small', 2, 2, 0, 640, 800, 960, 800, 800, 0, 1, 0, 1, 1, 0, 'sandworm', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99101, 'Dark Basilisk', 'Dark $962', 'Desert Renewal', 'L1Monster', 1041, 61, 1300, 100, -50, 35, 25, 22, 18, 18, 30, 5580, -38, 'large', 2, 1, 1, 920, 1240, 0, 1080, 1240, 0, 0, 1, 1, 1, 1, 'sandworm', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99102, 'Raging Giant Guardian Ant', 'Raging Giant Guardian Ant', 'Desert Renewal', 'L1Monster', 6290, 65, 2980, 450, -58, 38, 38, 38, 8, 25, 90, 6890, -50, 'large', 2, 2, 0, 480, 880, 1560, 1080, 1320, 0, 0, 0, 1, 1, 0, 'ant', 1, -1, -1, 0, 0, 0, 5000, 11, 5000, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99103, 'Dark Desert Flower', 'Dark Desert Flower', 'Desert Renewal', 'L1Monster', 10050, 45, 500, 300, -20, 16, 20, 18, 5, 5, 30, 1890, -20, 'large', 2, 2, 0, 0, 1280, 0, 2560, 2560, 0, 0, 0, 1, 1, 1, 'sandworm', 0, -1, -1, 0, 0, 0, 0, 0, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 10, 0, 0, 0, 0, 0),
   (99104, 'Dark quick sand', 'Dark quick sand', 'Desert Renewal', 'L1Monster', 5574, 50, 500, 30, -35, 35, 25, 15, 26, 25, 100, 2540, -5, 'small', 2, 1, 0, 1280, 880, 0, 840, 880, 2, 0, 0, 0, 0, 0, '', 0, -1, -1, 1, 0, 0, 5000, 10, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99105, 'Desert Griffon', 'Desert $1176', 'Desert Renewal', 'L1Monster', 1204, 40, 500, 150, -27, 20, 18, 15, 15, 10, 25, 1750, -30, 'large', 2, 1, 0, 640, 1280, 1480, 1280, 1280, 0, 0, 0, 1, 1, 0, 'griffon', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99106, 'Desert Lizardman', 'Desert $1174', 'Desert Renewal', 'L1Monster', 1173, 40, 500, 80, -25, 18, 18, 20, 10, 10, 10, 1750, -30, 'small', 8, 1, 1, 640, 920, 800, 920, 920, 0, 0, 0, 1, 0, 0, 'lizardman', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99107, 'Desert Stone Golem', 'Desert $56', 'Desert Renewal', 'L1Monster', 10641, 50, 1000, 10, -35, 50, 18, 12, 6, 10, 20, 2520, -50, 'large', 2, 1, 1, 1350, 2950, 0, 2640, 2640, 0, 0, 0, 0, 0, 0, 'golem', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99108, 'Desert Floating Eye', 'Desert $6', 'Desert Renewal', 'L1Monster', 10631, 49, 650, 100, -35, 15, 20, 18, 7, 18, 25, 2240, -49, 'small', 2, 1, 1, 960, 1720, 0, 1680, 1720, 0, 0, 1, 0, 0, 0, 'elder', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99109, 'Jack-O-Lantern', '$14397', '2012 Halloween Event 2', 'L1Monster', 5645, 40, 750, 20, -20, 20, 28, 28, 6, 5, 60, 1940, -15, 'small', 1, 1, 1, 640, 880, 0, 880, 880, 0, 0, 0, 0, 0, 0, 'Halloween', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99110, 'Jack-O-Lantern', '$14398', '2012 Halloween Event 2', 'L1Monster', 5645, 44, 900, 100, -25, 35, 22, 23, 20, 15, 70, 2580, -20, 'small', 1, 1, 1, 640, 760, 0, 760, 760, 0, 0, 0, 0, 0, 0, 'Halloween', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99111, 'Jack-O-Lantern', '$14399', '2012 Halloween Event 2', 'L1Monster', 5645, 48, 1200, 200, -30, 20, 25, 18, 16, 12, 50, 2850, -27, 'small', 1, 1, 0, 640, 760, 0, 760, 760, 0, 0, 0, 0, 0, 0, 'Halloween', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99112, 'Jack-O-Lantern', '$14397', '2012 Halloween Event 2', 'L1Monster', 5645, 40, 750, 20, -20, 15, 28, 28, 6, 5, 60, 1940, -15, 'small', 1, 10, 1, 640, 880, 0, 880, 880, 0, 0, 0, 0, 0, 0, 'Halloween', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 8904, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99113, 'Jack-O-Lantern', '$14398', '2012 Halloween Event 2', 'L1Monster', 5645, 44, 900, 100, -25, 18, 22, 35, 20, 15, 70, 2580, -20, 'small', 1, 10, 1, 640, 760, 0, 760, 760, 0, 0, 0, 0, 0, 0, 'Halloween', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 8904, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99114, 'Jack-O-Lantern', '$14399', '2012 Halloween Event 2', 'L1Monster', 5645, 48, 1200, 200, -30, 14, 25, 25, 16, 12, 50, 2850, -27, 'small', 1, 10, 0, 640, 760, 0, 760, 760, 0, 0, 0, 0, 0, 0, 'Halloween', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 8904, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99115, 'Jack-O-Lantern', '$14397', '2012 Halloween Event 2', 'L1Monster', 5645, 40, 750, 20, -20, 15, 28, 28, 25, 30, 60, 1940, -15, 'small', 1, 1, 1, 640, 880, 0, 880, 880, 0, 0, 0, 0, 0, 0, 'Halloween', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99116, 'Jack-O-Lantern', '$14398', '2012 Halloween Event 2', 'L1Monster', 5645, 44, 900, 100, -25, 18, 22, 23, 30, 35, 70, 2580, -20, 'small', 1, 1, 1, 640, 760, 0, 760, 760, 0, 0, 0, 0, 0, 0, 'Halloween', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99117, 'Jack-O-Lantern', '$14399', '2012 Halloween Event 2', 'L1Monster', 5645, 48, 1200, 200, -30, 14, 25, 18, 22, 28, 50, 2850, -27, 'small', 1, 1, 0, 640, 760, 0, 760, 760, 0, 0, 0, 0, 0, 0, 'Halloween', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99118, 'Trial Giant Soldier Ant', 'Trial $961', 'Trial Ant', 'L1Monster', 1039, 25, 250, 100, -25, 30, 18, 20, 17, 15, 60, 401, -20, 'large', 2, 2, 1, 640, 760, 0, 760, 760, 0, 0, 0, 1, 1, 1, 'ant', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99119, 'Alchemist Roche', 'Alchemist Roche', 'Desert Renewal', 'L1Merchant', 2090, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99120, 'Tunnel Ant', 'Tunnel Ant', 'Desert Renewal', 'L1Teleporter', 2438, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 600, 760, 0, 2, 2, 0, 0, 0, 0, 0, 0, 'ant', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99122, 'Fiat', 'Fiat', 'Strange renewal @ Floating Garden', 'L1Merchant', 6768, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99123, 'Clown', 'Clown', 'Strange renewal', 'L1Merchant', 10483, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99124, 'Donki', 'Donki', 'Strange renewal', 'L1Merchant', 9660, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99125, 'Piddle', 'Piddle', 'Strange renewal', 'L1Merchant', 2090, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99126, 'Bius', 'Bius', '', 'L1Dwarf', 10713, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99127, 'Berliner', 'Berliner', 'Strange renewal @ Floating garden', 'L1Merchant', 6768, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99128, 'Magic Doll:Bull Leg', 'Magic Doll:Bull Leg', 'Magic Doll', 'L1Doll', 9710, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 560, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99129, 'Magic Doll:Redeg', 'Magic Doll:Redeg', 'Magic Doll', 'L1Doll', 9698, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 720, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99130, 'Magic Doll:Elleg', 'Magic Doll:Elleg', 'Magic Doll', 'L1Doll', 9692, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 480, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99131, 'Magic Doll: Greg', 'Magic Doll: Greg', 'Magic Doll', 'L1Doll', 9704, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 640, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99142, 'Skeleton Guard of Trial', '$13853', 'TIC renewal', 'L1Monster', 1134, 42, 280, 60, -25, 18, 15, 16, 14, 14, 25, 1765, -30, 'small', 2, 2, 1, 640, 880, 840, 1680, 1680, 1, 0, 0, 1, 1, 0, 'skeleton', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99143, 'Follower of Chaos', '$3782', 'New Ivory Tower: Yahi Camp', 'L1Monster', 4550, 50, 250, 300, -60, 25, 25, 25, 25, 25, 100, 2501, -5, 'large', 0, 6, 0, 960, 720, 880, 750, 750, 3, 0, 0, 1, 1, 1, 'chaos', 1, -1, -1, 0, 0, 0, 5000, 5, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 4552, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99144, 'Priest of Chaos', '$3780', 'New Ivory Tower: Yahi Camp', 'L1Monster', 4544, 55, 1000, 300, -70, 25, 25, 25, 18, 18, 100, 3026, -5, 'large', 0, 6, 0, 960, 1080, 960, 1320, 1125, 3, 0, 0, 0, 0, 0, 'chaos', 1, -1, -1, 0, 0, 0, 5000, 10, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99145, 'Priest of Chaos', '$3780', 'New Ivory Tower: Yahi Camp', 'L1Monster', 4521, 22, 750, 300, -65, 25, 25, 25, 25, 25, 100, 2700, -5, 'large', 0, 6, 0, 960, 1120, 960, 1172, 1172, 3, 0, 0, 0, 0, 0, 'chaos', 1, -1, -1, 0, 0, 0, 5000, 8, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 4552, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99146, 'Priest of Corruption', '$2655', 'New Ivory Tower: Yahi Camp', 'L1Monster', 3957, 51, 1500, 250, -50, 55, 21, 11, 21, 18, 70, 2602, -5, 'small', 0, 1, 0, 560, 1040, 960, 1320, 1320, 3, 0, 0, 1, 1, 1, 'chaos', 1, -1, -1, 0, 0, 0, 5000, 100, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99147, 'Priest of Corruption', '$2655', 'New Ivory Tower: Yahi Camp', 'L1Monster', 3989, 53, 1800, 300, -63, 55, 21, 11, 21, 18, 70, 2810, -5, 'small', 0, 2, 0, 720, 1040, 1080, 2400, 1040, 3, 0, 0, 1, 1, 1, 'chaos', 1, -1, -1, 0, 0, 0, 5000, 150, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99148, 'Priest of Corruption', '$2655', 'New Ivory Tower: Yahi Camp', 'L1Monster', 3969, 56, 2000, 380, -60, 55, 21, 11, 21, 18, 70, 3137, -5, 'small', 0, 3, 0, 720, 960, 880, 1200, 960, 3, 0, 0, 1, 1, 1, 'chaos', 1, -1, -1, 0, 0, 0, 5000, 150, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99149, 'Priest of Corruption', '$2655', 'New Ivory Tower: Yahi Camp', 'L1Monster', 3984, 54, 2100, 400, -63, 55, 21, 11, 21, 18, 70, 2917, -5, 'small', 0, 2, 0, 720, 1120, 1040, 1360, 1120, 3, 1, 0, 1, 1, 1, 'chaos', 1, -1, -1, 0, 0, 0, 5000, 150, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99150, 'Death', '$3779', 'New Ivory Tower: Yahi Camp', 'L1Monster', 4587, 70, 10000, 300, -65, 45, 21, 21, 21, 18, 100, 4901, -5, 'large', 0, 2, 0, 960, 1160, 1040, 1480, 1160, 3, 0, 0, 0, 0, 0, 'chaos', 0, -1, -1, 0, 0, 0, 5000, 250, 5000, 250, 0, 0, 0, 0, 0, 0, 0, 4, 1, 0, 0, 0, 4592, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99151, 'Tarak', '$3407', 'New Ivory Tower: Yahi Camp', 'L1Monster', 4068, 68, 6600, 1250, -75, 66, 20, 66, 22, 20, 99, 4625, -10, 'large', 8, 3, 0, 720, 960, 1280, 1560, 1760, 3, 0, 0, 0, 0, 0, 'chaos', 0, -1, -1, 0, 0, 0, 5000, 440, 5000, 150, 0, 0, 0, 0, 0, 0, 0, 20, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99152, 'Paper Man', '$1396', 'New Ivory Tower: Yahi Camp', 'L1Monster', 1538, 50, 800, 5, -30, 11, 16, 10, 8, 10, 5, 2501, -8, 'small', 1, 1, 1, 960, 960, 800, 960, 960, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99153, 'Mimic', '$1392', 'New Ivory Tower: Yahi Camp', 'L1Monster', 1479, 50, 1250, 20, -50, 16, 12, 14, 10, 11, 20, 2501, -20, 'small', 1, 1, 1, 1280, 1120, 0, 1120, 1120, 0, 0, 0, 1, 0, 0, '', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99154, 'Stone Golem', '$56', 'New Ivory Tower: Yahi Camp', 'L1Monster', 4910, 50, 875, 10, -50, 58, 16, 10, 6, 11, 45, 2501, -30, 'large', 1, 1, 0, 1280, 960, 1200, 2640, 2640, 0, 0, 0, 1, 0, 0, 'golem', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99155, 'Iron Golem', '$1789', 'New Ivory Tower: Yahi Camp', 'L1Monster', 4867, 51, 910, 10, -51, 70, 30, 8, 5, 5, 20, 2602, -28, 'large', 1, 1, 0, 1920, 1360, 1280, 1120, 1280, 0, 0, 0, 1, 1, 1, 'golem', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99156, 'Gelatinous Cube', '$2115', 'New Ivory Tower: Yahi Camp', 'L1Monster', 2541, 52, 946, 10, -47, 21, 20, 8, 5, 9, 0, 2705, -25, 'large', 1, 10, 1, 1440, 1280, 0, 1280, 1280, 0, 1, 0, 1, 1, 0, 'gelatine', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2559, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99157, 'Living Armor', '$1408', 'New Ivory Tower: Yahi Camp - A', 'L1Monster', 1578, 53, 983, 40, -53, 18, 15, 12, 12, 10, 40, 2810, -35, 'small', 1, 1, 1, 1440, 1920, 0, 1920, 1920, 2, 0, 0, 1, 1, 0, 'livingarmour', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99158, 'Living Armor', '$1408', 'New Ivory Tower: Yahi Camp - B', 'L1Monster', 5348, 54, 1021, 10, -44, 18, 15, 12, 12, 10, 50, 2917, -35, 'small', 1, 1, 1, 960, 1000, 880, 1920, 1920, 2, 0, 0, 1, 1, 0, 'livingarmour', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99159, 'Dancing Sword', '$2111', 'New Ivory Tower: Yahi Camp', 'L1Monster', 2513, 55, 1059, 10, -50, 17, 12, 20, 5, 6, 40, 3026, -39, 'small', 1, 2, 0, 480, 1120, 1440, 1120, 1120, 0, 0, 0, 1, 1, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 4, 0, 0, 0, 0, 0),
   (99160, 'Ball Lightning', '$2485', 'New Ivory Tower: Yahi Camp', 'L1Monster', 2727, 55, 1059, 50, -50, 16, 17, 18, 15, 16, 45, 3026, -10, 'small', 1, 1, 0, 960, 920, 0, 920, 1280, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99161, 'Elder', '$19', 'New Ivory Tower: Yahi Camp', 'L1Monster', 32, 55, 1059, 50, -35, 10, 14, 10, 16, 16, 30, 3026, 200, 'small', 1, 1, 1, 800, 1800, 840, 720, 960, 0, 0, 0, 1, 1, 0, 'elder', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99162, 'Cimaera', '$2107', 'New Ivory Tower: Yahi Camp', 'L1Monster', 2407, 55, 1059, 50, -35, 19, 18, 16, 8, 8, 35, 3026, -40, 'small', 1, 2, 1, 960, 1440, 1560, 1440, 1440, 0, 1, 0, 1, 1, 0, 'cimaera', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99163, 'Ramia', '$1428', 'New Ivory Tower: Yahi Camp - Green', 'L1Monster', 1597, 56, 1098, 50, -36, 15, 15, 12, 12, 10, 10, 3137, -25, 'large', 1, 1, 0, 960, 1880, 2720, 1880, 1880, 0, 1, 0, 1, 0, 0, 'lahmia', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99164, 'Ramia', '$1428', 'New Ivory Tower: Yahi Camp - Green', 'L1Monster', 1600, 56, 1098, 50, -36, 15, 15, 12, 12, 10, 10, 3137, -25, 'large', 1, 1, 0, 960, 1880, 2720, 1880, 1880, 0, 1, 0, 1, 0, 0, 'lahmia', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99165, 'Dark Elder', '$992', 'New Ivory Tower: Yahi Camp - Chat None', 'L1Monster', 183, 57, 1137, 50, -37, 12, 15, 12, 17, 17, 90, 3250, -50, 'small', 1, 1, 0, 640, 880, 800, 600, 800, 0, 0, 0, 1, 1, 1, 'elder', 1, -1, -1, 0, 0, 0, 5000, 200, 5000, 200, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 3, 1, 0, 0, 0, 0),
   (99166, 'Black Wizard', '$3141', 'New Ivory Tower: Yahi Camp', 'L1Monster', 5212, 58, 1177, 50, -38, 16, 20, 18, 18, 18, 80, 3365, -50, 'small', 1, 1, 0, 960, 1160, 1080, 1160, 1080, 0, 0, 0, 1, 1, 1, 'blackwizard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99167, 'Death', '$1562', 'New Ivory Tower: Yahi Camp', 'L1Monster', 1576, 58, 1177, 50, -53, 12, 11, 11, 9, 13, 9, 3365, -28, 'small', 1, 1, 1, 640, 2280, 2080, 2280, 2280, 1, 0, 0, 1, 1, 0, 'death', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99168, 'Silhouette', '$1404', 'New Ivory Tower: Yahi Camp', 'L1Monster', 1571, 58, 1177, 50, -53, 14, 8, 16, 12, 14, 30, 3365, -14, 'small', 1, 1, 1, 640, 1920, 1760, 1920, 1920, 1, 0, 0, 1, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99169, 'Ghost', '$1563', 'New Ivory Tower: Yahi Camp', 'L1Monster', 3364, 59, 1218, 50, -54, 11, 11, 11, 9, 13, 45, 3482, -10, 'small', 1, 1, 1, 960, 1240, 1080, 640, 640, 1, 0, 0, 0, 0, 0, 'ghost', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0),
   (99170, 'Depraved Soul', '$2658', 'New Ivory Tower: Yahi Camp', 'L1Monster', 8457, 59, 1345, 50, -57, 75, 18, 17, 15, 17, 50, 3482, -120, 'small', 1, 2, 0, 640, 680, 1080, 960, 1040, 0, 0, 0, 0, 1, 0, 'daemon', 1, -1, -1, 0, 0, 0, 5000, 40, 5000, 20, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (99171, 'rune wall', '', 'TICIF', 'L1FieldObject', 136, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 160, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99172, 'Maris', 'Maris', '', 'L1Merchant', 834, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 1, 0, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (99173, '', '', 'Hangzhou', 'L1FieldObject', 11204, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99176, '', '', 'Dantes Field', 'L1FieldObject', 11219, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99177, '', '', 'Dantes', 'L1Merchant', 11222, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99178, 'Glacier Ice Man', 'Glacier $1791', 'Oren Renewal', 'L1Monster', 10354, 63, 700, 20, -48, 20, 20, 20, 18, 18, 35, 1677, -25, 'large', 8, 1, 1, 960, 1600, 1640, 1600, 1600, 0, 0, 0, 1, 0, 0, 'iceman', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99179, 'Glacier Ice Man', 'Glacier $1791', 'Oren Renewal', 'L1Monster', 10796, 65, 700, 30, -48, 26, 27, 26, 20, 20, 70, 4305, -33, 'large', 8, 1, 1, 960, 1120, 960, 1080, 1600, 0, 0, 0, 1, 1, 1, 'iceman', 1, -1, -1, 0, 0, 0, 5000, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99180, 'Glacier Yeti', 'Glacier $1786', 'Oren Renewal', 'L1Monster', 10797, 63, 800, 100, -50, 28, 25, 15, 12, 10, 26, 3901, -26, 'large', 8, 1, 1, 960, 1400, 1360, 1400, 1400, 0, 0, 0, 1, 0, 0, 'yeti', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99181, 'Glacier Snow Tiger', 'Glacier Wall $1784', 'Oren Renewal', 'L1Monster', 10800, 63, 700, 30, -48, 26, 24, 20, 18, 15, 70, 1730, -25, 'large', 8, 1, 1, 960, 1360, 1400, 1360, 1360, 0, 0, 0, 1, 0, 0, 'tiger', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99182, 'Glacier Ice Golem', 'Glacier $1395', 'Oren Renewal', 'L1Monster', 10798, 68, 1100, 0, -55, 46, 20, 15, 10, 5, 21, 3985, -10, 'large', 8, 1, 0, 1920, 1480, 1680, 1480, 1480, 0, 0, 0, 0, 0, 0, 'golem', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99183, 'Glacier Iron Golem', 'Glacier $1789', 'Oren Renewal', 'L1Monster', 10799, 68, 1100, 10, -60, 70, 30, 8, 5, 5, 21, 4523, -28, 'large', 2, 1, 0, 1920, 1360, 1280, 1120, 1280, 0, 0, 0, 1, 1, 1, 'golem', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99184, 'Rot Zombie', 'Rot $57', 'Oren Renewal', 'L1Monster', 10790, 50, 800, 96, -35, 20, 22, 12, 8, 5, 40, 1037, -8, 'small', 2, 1, 1, 2000, 1040, 0, 1600, 1600, 1, 0, 0, 1, 0, 1, 'zombie', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99185, 'Undead Elmore Soldier', '$1790', 'Oren Renewal', 'L1Monster', 10792, 55, 900, 50, -42, 22, 20, 21, 12, 12, 40, 1442, -20, 'small', 2, 2, 0, 480, 1040, 1400, 1040, 1040, 1, 0, 0, 1, 0, 0, 'elmore', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99186, 'Undead Elmore Wizard', '$1785', 'Oren Renewal', 'L1Monster', 10793, 55, 600, 230, -40, 17, 20, 13, 10, 15, 50, 1485, -20, 'small', 2, 1, 1, 1440, 1920, 1600, 1440, 1920, 1, 0, 0, 1, 0, 0, 'elmore', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99187, 'Dark Undead Elmore Soldier', 'Dark $1790', 'Oren Renewal', 'L1Monster', 10792, 58, 900, 110, -48, 21, 21, 22, 15, 18, 41, 2860, -20, 'small', 2, 2, 0, 480, 1040, 1400, 1040, 1040, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99188, 'Dark Undead Elmore Wizard', 'Dark $1785', 'Oren Renewal', 'L1Monster', 10793, 58, 600, 230, -45, 18, 21, 15, 15, 22, 80, 2865, -20, 'small', 2, 1, 0, 1440, 1920, 1600, 1440, 1920, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99189, 'Undead Elmore General', '$1787', 'Oren Renewal', 'L1Monster', 10794, 58, 1000, 50, -53, 20, 21, 18, 15, 18, 43, 3501, -25, 'small', 2, 1, 0, 960, 1200, 1280, 1200, 1200, 1, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99190, 'Bonos Orc Archer', 'Bonos $267', 'Oren Renewal', 'L1Monster', 10624, 41, 1000, 20, -47, 12, 14, 16, 8, 10, 55, 2156, -40, 'small', 4, 8, 0, 820, 1640, 1040, 1640, 1640, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99191, 'Dark Undead Elmore General', 'Dark $1787', 'Oren Renewal', 'L1Monster', 8459, 60, 1000, 110, -53, 22, 23, 20, 17, 15, 44, 3626, -25, 'large', 2, 1, 1, 960, 1200, 1280, 1200, 1200, 1, 0, 0, 1, 0, 0, '', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99192, 'Bonos dummy', 'Bonos $10816', 'Oren Renewal', 'L1Monster', 10623, 42, 950, 20, -54, 14, 17, 18, 12, 10, 48, 2156, -50, 'small', 4, 1, 0, 640, 1360, 1360, 1360, 1360, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99193, 'Bonos Orc Fighter', 'Bonos $266', 'Oren Renewal', 'L1Monster', 10619, 44, 1250, 20, -55, 18, 16, 14, 8, 10, 55, 2156, -50, 'small', 4, 2, 0, 640, 1040, 1520, 1040, 1040, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99194, 'Bonos Orc Pike', 'Bonos $59 Pike', 'Oren Renewal', 'L1Monster', 10622, 44, 1100, 20, -55, 18, 16, 14, 8, 10, 60, 2156, -50, 'small', 4, 2, 0, 640, 1280, 1400, 1280, 1280, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99195, 'Bonos Orc Sherman', 'Bonos $59 Sherman', 'Oren Renewal', 'L1Monster', 10625, 41, 800, 400, -50, 6, 12, 10, 13, 10, 30, 2156, -15, 'small', 4, 1, 1, 880, 1240, 0, 2160, 2160, 0, 0, 0, 1, 1, 1, 'orc', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99196, 'Dwarf Axe', 'Dwarf $1', 'Oren Renewal', 'L1Monster', 10613, 45, 1100, 62, -56, 20, 18, 18, 16, 16, 30, 2026, -15, 'small', 8, 1, 1, 600, 1480, 1020, 1480, 1480, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (99197, 'Dwarf archer', 'Dwarf archer', 'Oren Renewal', 'L1Monster', 10614, 45, 900, 60, -48, 15, 16, 20, 12, 14, 45, 2026, -25, 'small', 8, 10, 0, 680, 880, 920, 1400, 1600, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99198, 'Dwarf soldier', 'Dwarf soldier', 'Oren Renewal', 'L1Monster', 10609, 42, 1200, 62, -50, 18, 12, 18, 16, 16, 55, 2026, -30, 'small', 8, 1, 1, 640, 960, 1280, 1020, 1040, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (99199, 'Dwarf pike', 'Dwarf pike', 'Oren Renewal', 'L1Monster', 10612, 45, 1000, 50, -45, 18, 18, 18, 16, 16, 42, 2026, -30, 'small', 8, 2, 1, 680, 1280, 1020, 960, 1120, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (99200, 'Dwarf fighter', 'Dwarf fighter', 'Oren Renewal', 'L1Monster', 10611, 45, 1200, 70, -48, 18, 12, 10, 10, 10, 40, 2026, -30, 'small', 8, 1, 2, 700, 1040, 1320, 1020, 1040, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (99201, 'Dwarf mage', 'Dwarf mage', 'Oren Renewal', 'L1Monster', 10610, 42, 800, 400, -40, 15, 16, 15, 18, 20, 60, 2026, -30, 'small', 8, 1, 2, 700, 1040, 1320, 1020, 1040, 0, 0, 0, 0, 0, 0, 'dwarf', 0, -1, -1, 0, 0, 1, 5000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99202, 'Cursed Dark Elf Warrior', '$4285', 'Raster bud renewal', 'L1Monster', 11214, 58, 938, 563, -50, 21, 20, 25, 19, 21, 56, 5292, -63, 'small', 0, 1, 0, 960, 1040, 1040, 1440, 1280, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99203, 'Cursed Dark Elf Wizard', '$4287', 'Raster bud renewal', 'L1Monster', 11178, 55, 788, 563, -43, 20, 19, 23, 20, 23, 100, 4842, -63, 'small', 2, 1, 0, 960, 1160, 1280, 1200, 1160, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 5000, 15, 5000, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99204, 'Cursed Dark Elf Knight', '$4286', 'Raster bud renewal', 'L1Monster', 11215, 63, 1313, 563, -53, 23, 24, 19, 19, 19, 75, 6252, -63, 'small', 0, 1, 0, 960, 1200, 1200, 1440, 1560, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99205, 'Dark Elf Thief', '$2886', 'Raster bud renewal', 'L1Monster', 11131, 35, 938, 38, -23, 25, 23, 15, 15, 10, 25, 1962, -43, 'small', 0, 10, 0, 1280, 1440, 1160, 1440, 1440, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99206, 'Dark Elf General', '$2885', 'Raster bud renewal', 'L1Monster', 11135, 54, 2157, 95, -63, 25, 23, 19, 21, 21, 56, 4626, -63, 'small', 0, 2, 0, 360, 1000, 1400, 1000, 1000, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99207, 'Dark Mage', '$3824', 'Raster bud renewal', 'L1Monster', 11147, 61, 938, 278, -45, 20, 19, 23, 20, 23, 88, 6006, -63, 'small', 0, 1, 0, 1280, 1280, 1920, 1160, 1160, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99208, 'Dark Forester', '$3823', 'Raster bud renewal', 'L1Monster', 11148, 59, 750, 563, -50, 19, 20, 18, 20, 23, 75, 5526, -31, 'small', 1, 2, 0, 853, 1720, 0, 2200, 2200, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99209, 'Dark Elf Wizard', '$2888', 'Raster bud renewal', 'L1Monster', 11141, 55, 938, 750, -40, 21, 21, 23, 31, 28, 94, 4206, -63, 'small', 0, 1, 0, 1920, 1560, 0, 1520, 1440, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99210, 'Dark Elf Thief', '$2886', 'Raster bud renewal(Transform)', 'L1Monster', 11131, 35, 938, 38, -23, 25, 23, 15, 15, 10, 25, 0, -43, 'small', 0, 10, 0, 1280, 1440, 1160, 1440, 1440, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 66, 0, 99204, 5306, 0, 0, 0, 1, 0, 0),
   (99211, 'Dark Elf General', '$2885', 'Raster bud renewal(Transform)', 'L1Monster', 11135, 54, 2157, 95, -63, 25, 23, 19, 21, 21, 56, 0, -63, 'small', 0, 2, 0, 360, 1000, 1400, 1000, 1000, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 99204, 5306, 0, 0, 0, 1, 0, 0),
   (99212, 'Dark Mage', '$3824', 'Raster bud renewal(Transform)', 'L1Monster', 11147, 61, 938, 278, -45, 20, 19, 23, 20, 23, 88, 0, -63, 'small', 0, 1, 0, 1280, 1280, 1920, 1160, 1160, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 99203, 5306, 0, 0, 0, 1, 0, 0),
   (99213, 'Dark Forester', '$3823', 'Raster bud renewal(Transform)', 'L1Monster', 11148, 59, 750, 563, -50, 19, 20, 18, 20, 23, 75, 0, -31, 'small', 1, 2, 0, 853, 1720, 0, 2200, 2200, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 99202, 5306, 0, 0, 0, 1, 0, 0),
   (99214, 'Dark Elf Wizard', '$2888', 'Raster bud renewal(Transform)', 'L1Monster', 11141, 55, 938, 750, -40, 21, 21, 23, 31, 28, 94, 0, -63, 'small', 0, 1, 0, 1920, 1560, 0, 1520, 1440, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 99203, 5306, 0, 0, 0, 1, 0, 0),
   (99215, 'Elder Attendant', '$4304', 'Raster bud renewal', 'L1Monster', 11159, 65, 2813, 1313, -61, 21, 23, 19, 24, 24, 63, 7285, -31, 'small', 2, 1, 0, 960, 1080, 0, 1080, 1520, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99216, 'Tyupon', '$4308', 'Raster bud renewal', 'L1Monster', 11175, 65, 3188, 938, -69, 25, 23, 19, 15, 20, 81, 6762, -31, 'large', 0, 1, 0, 960, 1320, 1200, 1360, 1280, 0, 0, 0, 1, 1, 1, 'lastavard', 0, -1, -1, 0, 0, 0, 5000, 35, 5000, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99217, 'Otyu', '$4306', 'Raster bud renewal', 'L1Monster', 11173, 63, 2813, 470, -63, 19, 23, 25, 18, 20, 63, 6252, -31, 'small', 0, 3, 0, 960, 1120, 920, 1120, 1120, 2, 0, 0, 1, 1, 1, 'lastavard', 0, -1, -1, 0, 0, 0, 5000, 25, 500, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99218, 'Wyvern', '$4307', 'Raster bud renewal', 'L1Monster', 11174, 55, 938, 375, -69, 21, 23, 25, 19, 21, 88, 7292, -31, 'large', 0, 1, 0, 800, 1200, 1280, 1360, 1360, 0, 0, 0, 1, 1, 1, 'lastavard', 0, -1, -1, 0, 0, 0, 5000, 25, 5000, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 1),
   (99219, 'Oum Warrior', '$3830', 'Raster bud renewal', 'L1Monster', 11129, 53, 1178, 0, -63, 19, 18, 18, 13, 10, 50, 4410, -31, 'small', 2, 1, 0, 640, 1280, 1440, 1280, 1280, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 5000, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99220, 'Heavy Oum Warrior', '$3831', 'Raster bud renewal', 'L1Monster', 11130, 61, 2063, 0, -68, 21, 20, 19, 15, 13, 50, 5292, -31, 'large', 2, 2, 0, 960, 1000, 1440, 1000, 1000, 0, 0, 0, 1, 1, 1, 'lastavard', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99221, 'Wolf Beast Tamer', '$4642', 'Raster bud renewal', 'L1Monster', 11137, 54, 1365, 0, -49, 19, 21, 15, 21, 21, 81, 4626, -63, 'small', 4, 2, 0, 960, 1120, 1320, 1360, 1360, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99222, 'Hell Creature', '$3812', 'Raster bud renewal', 'L1Monster', 11140, 60, 1688, 0, -96, 20, 24, 19, 13, 20, 56, 5762, -31, 'small', 2, 1, 0, 960, 960, 1600, 960, 960, 0, 0, 0, 1, 1, 0, 'lastavard', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99223, 'Black Tiger', '$3136', 'Raster bud renewal', 'L1Monster', 11136, 53, 1125, 0, -46, 19, 23, 15, 16, 9, 56, 4412, -63, 'small', 4, 2, 0, 853, 1640, 1800, 1640, 1640, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 9, 0, 0, 1, 0, 0),
   (99224, 'Hell Bound', '$3811', 'Raster bud renewal', 'L1Monster', 11139, 50, 1232, 522, -50, 20, 23, 19, 15, 19, 0, 4002, -31, 'small', 2, 1, 0, 640, 1040, 1320, 1080, 1080, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99225, 'Lord of Darkness', '$3833', 'Raster bud renewal', 'L1Monster', 11149, 65, 2813, 2250, -69, 20, 21, 18, 18, 23, 94, 6762, -31, 'small', 2, 1, 0, 640, 1080, 1440, 1440, 1440, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99226, 'Darkness Avenger', '$3828', 'Raster bud renewal', 'L1Monster', 11150, 63, 3000, 188, -65, 25, 23, 19, 16, 20, 69, 6252, -31, 'small', 2, 1, 0, 960, 1120, 1080, 1120, 1120, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99227, 'Blood Rain Knight', '$3829', 'Raster bud renewal', 'L1Monster', 11152, 65, 3375, 597, -69, 25, 23, 20, 15, 19, 81, 6762, -31, 'small', 2, 1, 0, 960, 1200, 1120, 1200, 1200, 1, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99228, 'Spiritologist of Blood', '$3832', 'Raster bud renewal', 'L1Monster', 11151, 63, 2438, 597, -68, 20, 19, 18, 19, 25, 88, 6252, -31, 'small', 2, 1, 0, 640, 1080, 1440, 1440, 1440, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 5000, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99229, 'Guardian of Earth Spirit', '$3820', 'Raster bud renewal', 'L1Monster', 11142, 56, 1359, 20, -46, 24, 25, 19, 13, 13, 75, 5066, -31, 'small', 2, 1, 0, 960, 1280, 1280, 1400, 1200, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99230, 'Guardian of Water Spirit', '$3818', 'Raster bud renewal', 'L1Monster', 11143, 56, 1359, 20, -46, 24, 25, 19, 13, 13, 75, 5066, -31, 'small', 8, 1, 0, 960, 1280, 1280, 1400, 1200, 0, 0, 0, 1, 1, 1, 'lastavard', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99231, 'Guardian of Wind Spirit', '$3821', 'Raster bud renewal', 'L1Monster', 11144, 56, 1359, 20, -46, 24, 25, 19, 13, 13, 75, 5066, -31, 'small', 1, 1, 0, 960, 1280, 1280, 1520, 1200, 0, 0, 0, 1, 1, 1, 'spirit', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99232, 'Guardian of Fire Spirit', '$3819', 'Raster bud renewal', 'L1Monster', 11145, 56, 1359, 20, -46, 24, 25, 19, 13, 13, 75, 5066, -31, 'small', 4, 1, 0, 960, 1280, 1280, 1400, 1200, 0, 0, 0, 1, 1, 1, 'spirit', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99233, 'Guardian of Darkness Spirit', '$3822', 'Raster bud renewal', 'L1Monster', 11146, 56, 1359, 683, -46, 24, 25, 19, 13, 19, 75, 5066, -31, 'small', 2, 1, 0, 960, 1280, 1280, 1400, 1200, 0, 0, 0, 1, 1, 1, 'spirit', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99234, 'Supreme Court Justice Keyna', '$4300', 'Raster bud renewal', 'L1Monster', 11171, 78, 25313, 938, -81, 19, 23, 25, 18, 20, 75, 9612, -31, 'large', 0, 2, 0, 960, 1240, 1280, 1400, 1400, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 50, 5000, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99235, 'Supreme Court Justice Viatas', '$4302', 'Raster bud renewal', 'L1Monster', 11168, 85, 29063, 938, -86, 24, 23, 21, 16, 15, 63, 11562, -31, 'large', 0, 2, 0, 960, 1400, 1160, 1600, 1600, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 70, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99236, 'Supreme Court Justice Baromes', '$4297', 'Raster bud renewal', 'L1Monster', 11167, 88, 31245, 1313, -89, 23, 23, 24, 25, 25, 85, 12252, -31, 'large', 0, 1, 0, 640, 1000, 1400, 1520, 1520, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 70, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99237, 'Supreme Court Justice Endias', '$4303', 'Raster bud renewal', 'L1Monster', 11169, 91, 35040, 1313, -98, 21, 23, 25, 20, 21, 88, 13326, -31, 'large', 2, 8, 0, 1040, 1240, 1040, 1560, 1560, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 70, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99238, 'Supreme Court Justice Edea', '$4299', 'Raster bud renewal', 'L1Monster', 11170, 80, 27728, 938, -85, 19, 23, 23, 19, 20, 75, 10242, -31, 'large', 0, 2, 0, 720, 1320, 1200, 1680, 1680, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 50, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99239, 'Supreme Courth Justice Tiames', '$4301', 'Raster bud renewal', 'L1Monster', 11172, 90, 34020, 938, -94, 23, 23, 24, 25, 25, 89, 12962, -31, 'large', 2, 1, 0, 640, 1200, 1120, 1280, 1680, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 100, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99240, 'Supreme Court Justice Ramias', '$4298', 'Raster bud renewal', 'L1Monster', 11165, 93, 34973, 657, -98, 26, 25, 20, 15, 16, 81, 13692, -31, 'large', 2, 1, 0, 1040, 1200, 1240, 1600, 2120, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 100, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99241, 'Supreme Court Justice Barode', '$4296', 'Raster bud renewal', 'L1Monster', 11166, 96, 36915, 938, -98, 25, 23, 21, 19, 20, 100, 14826, -31, 'large', 0, 1, 0, 800, 720, 1000, 920, 1200, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 100, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99242, 'Brigade Commander Dark Fencer', '$3807', 'Raster bud renewal', 'L1Monster', 11156, 65, 22553, 563, -59, 24, 25, 23, 20, 19, 50, 6762, -31, 'small', 2, 1, 0, 960, 760, 1080, 1320, 1320, 0, 0, 0, 0, 0, 0, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99243, 'Evil Power Squad Leader Kybar', '$3805', 'Raster bud renewal', 'L1Monster', 11156, 70, 23475, 2250, -64, 24, 25, 23, 20, 19, 88, 7842, -31, 'small', 0, 1, 0, 960, 760, 1080, 1320, 1320, 0, 0, 0, 0, 0, 0, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99244, 'Evil Power King Baranka', '$3804', 'Raster bud renewal', 'L1Monster', 11162, 79, 32420, 0, -73, 28, 31, 25, 23, 23, 81, 9926, -6, 'large', 0, 2, 0, 480, 1000, 860, 1000, 1720, 0, 0, 0, 0, 0, 0, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 150, 5000, 150, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99245, 'Mercenary Commander Mephaisto', '$3827', 'Raster bud renewal', 'L1Monster', 11156, 70, 24905, 1355, -80, 23, 24, 24, 20, 21, 88, 7842, -31, 'small', 2, 1, 0, 960, 760, 1080, 1320, 1320, 0, 0, 0, 0, 0, 0, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99246, 'Bright Magic Troup Leader Crepus', '$3826', 'Raster bud renewal', 'L1Monster', 11156, 73, 25673, 1355, -83, 24, 24, 23, 20, 20, 75, 8412, -31, 'small', 2, 1, 0, 960, 760, 1080, 1320, 1320, 0, 0, 0, 0, 0, 0, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99247, 'Bright Magic King Hellvine', '$3825', 'Raster bud renewal', 'L1Monster', 11164, 88, 42510, 7445, -98, 25, 25, 25, 25, 25, 106, 12252, -31, 'large', 2, 8, 0, 1040, 1560, 1720, 1720, 1880, 0, 0, 0, 0, 0, 0, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 4536, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (99248, 'Palace General Kyte', '$3800', 'Raster bud renewal', 'L1Monster', 11158, 64, 23520, 1373, -76, 20, 19, 21, 15, 20, 75, 6506, -31, 'small', 2, 1, 0, 960, 1160, 0, 1800, 1800, 0, 0, 0, 0, 0, 0, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99249, 'Assassin Squad Leader Blaze', '$3799', 'Raster bud renewal', 'L1Monster', 11161, 66, 24137, 1182, -79, 19, 20, 23, 15, 20, 69, 7026, -31, 'small', 4, 10, 0, 640, 1280, 1360, 1160, 1160, 0, 0, 0, 0, 0, 0, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2989, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99250, 'Slave of Assassin King', '$3798', 'Raster bud renewal', 'L1Monster', 11160, 76, 30380, 2324, -89, 20, 23, 25, 13, 21, 94, 9306, -31, 'large', 0, 10, 0, 640, 800, 0, 1280, 1440, 0, 0, 0, 0, 0, 0, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 120, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 2989, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99251, 'Temple Head Bounty', '$3816', 'Raster bud renewal', 'L1Monster', 11159, 71, 23477, 2649, -61, 19, 23, 18, 19, 24, 63, 8126, -31, 'small', 2, 1, 0, 960, 1080, 0, 1080, 1520, 0, 0, 0, 0, 0, 0, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99252, 'Evil Magic Squad Leader Carmiel', '$3817', 'Raster bud renewal', 'L1Monster', 11159, 69, 23004, 2649, -59, 18, 23, 21, 18, 23, 75, 7566, -31, 'small', 2, 1, 0, 960, 1160, 0, 1080, 1520, 0, 0, 0, 0, 0, 0, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 1),
   (99253, 'Laia', '$3139', 'Raster bud renewal', 'L1Monster', 11163, 81, 28257, 8019, -71, 24, 23, 23, 23, 31, 100, 4842, -6, 'small', 0, 1, 0, 640, 1880, 2120, 1760, 2560, 0, 0, 0, 0, 0, 0, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 80, 5000, 150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 1, 0, 0),
   (99254, 'Assistant Marbes', '$4599', 'Raster bud renewal', 'L1Merchant', 2794, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (99255, 'Elder Attendant Clorence', '$4577', 'Raster bud renewal', 'L1Merchant', 5723, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 0, 1320, 1280, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (99256, 'Siegfried', 'Siegfried', 'Raster bud renewal', 'L1Merchant', 10295, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 960, 0, 1320, 1280, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (99257, 'Lastabad Royal Guard', '$4383', 'Rasta Bud Renewal-Fighter', 'L1Monster', 11155, 56, 750, 95, -50, 25, 23, 14, 6, 13, 38, 0, -25, 'small', 0, 2, 0, 853, 960, 1280, 960, 960, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 99202, 5306, 0, 0, 0, 1, 0, 0),
   (99258, 'Lastabad Royal Guard', '$4383', 'Rasta Bud Renewal-Mage', 'L1Monster', 11155, 56, 750, 95, -50, 25, 23, 14, 6, 13, 38, 0, -25, 'small', 0, 2, 0, 853, 960, 1280, 960, 960, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 99203, 5306, 0, 0, 0, 1, 0, 0),
   (99259, 'Lastabad Royal Guard', '$4383', 'Rasta Bud Renewal-Night', 'L1Monster', 11155, 56, 750, 95, -50, 25, 23, 14, 6, 13, 38, 0, -25, 'small', 0, 2, 0, 853, 960, 1280, 960, 960, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 99204, 5306, 0, 0, 0, 1, 0, 0),
   (99260, 'Lastabad Royal Guard', '$4383', 'Raster bud renewal', 'L1Monster', 11155, 56, 750, 95, -50, 25, 23, 14, 6, 13, 38, 0, -25, 'small', 0, 2, 0, 853, 960, 1280, 960, 960, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99261, 'Assassin of Blood', '$3801', 'Raster bud renewal', 'L1Monster', 5596, 55, 1500, 522, -68, 23, 24, 19, 19, 19, 75, 5066, 0, 'small', 2, 10, 0, 640, 840, 1480, 1080, 1080, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2989, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99262, 'Assassin of Blood', '$3801', 'Rasta Bud Renewal-Night', 'L1Monster', 5596, 55, 1500, 522, -68, 23, 24, 19, 19, 19, 75, 0, 0, 'small', 2, 10, 0, 640, 840, 1480, 1080, 1080, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2989, 0, 99204, 5306, 0, 0, 0, 1, 0, 0),
   (99263, 'Phantom Knight', '$3814', 'Raster bud renewal', 'L1Monster', 4664, 51, 2025, 522, -54, 24, 19, 20, 20, 20, 63, 4206, -31, 'small', 2, 2, 0, 640, 1160, 1400, 1160, 1160, 0, 0, 0, 1, 1, 1, 'lastabad', 1, -1, -1, 0, 0, 0, 5000, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99264, 'Lesya', 'Lesya', 'Raster bud renewal', 'L1Merchant', 2801, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 480, 1160, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (99265, 'Chinus', 'Chinus', 'Raster bud renewal', 'L1Merchant', 2801, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 480, 1160, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 1, 0, 0),
   (99266, 'Kiku', 'Kiku', 'Raster bud renewal', 'L1Dwarf', 10713, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 560, 1480, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0),
   (99267, 'Zou`s Fire Golem', '$13818', 'Zou`s Fire Golem', 'L1Merchant', 8334, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 1280, 2640, 0, 2640, 2640, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0, 0, 0),
   (99268, 'Ghoul of Trial', '$13852', 'Ghoul of Trial', 'L1Monster', 10002, 16, 110, 30, -4, 16, 17, 16, 11, 4, 13, 257, -19, 'small', 2, 1, 1, 1280, 720, 0, 1440, 1440, 1, 4, 0, 1, 0, 1, 'ghoul', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0);

-- Update Kuul sprite.
UPDATE npc SET gfxid = 10669 WHERE npcid = 60034; -- Was 143
-- Drop Gatekeeper, which spawned in Sactuary of Eva.  Seems to do nothing.
DELETE FROM npc WHERE npcid = 71273;
DELETE FROM spawnlist_npc WHERE npc_templateid = 71273;
-- Replace NPC with new field object.
INSERT INTO `npc` VALUES ('71273', 'Tools', '', 'Pandora Back Luggage', 'L1FieldObject', '2299', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0');

-- Fix floating question mark names for some lights.
UPDATE npc SET nameid = '' WHERE impl = 'L1FieldObject' AND nameid LIKE '?%';

-- Add new mapids column.
ALTER TABLE mapids ADD unique_rate tinyint(1) unsigned NOT NULL DEFAULT 1 AFTER drop_rate;

-- Add new mapids.
INSERT INTO mapids () VALUES
   (42, NULL, 32512, 32831, 32704, 33023, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1),
   (100, NULL, 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (261, '1st Orc Unit Outpost', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (262, 'Hidden 1st Orc Unit Outpost', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (263, '2nd Orc Unit Outpost', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (264, '3rd Orc Unit Outpost', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (265, '4th Orc Unit Outpost', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (266, '5th Orc Unit Outpost', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (267, 'Hidden 2nd Orc Unit Outpost', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (268, '6th Orc Unit Outpost', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (269, '7th Orc Unit Outpost', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (270, 'Ivory Tower Secret Lab', 32704, 32767, 32768, 32831, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (271, 'Crystal Cavern', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (272, 'Crystal Cavern', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (273, 'Crystal Cavern', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (274, 'Crystal Cavern', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (275, 'Crystal Cavern', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (276, 'Crystal Cavern', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (277, 'Crystal Cavern', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (278, 'Crystal Cavern', 32704, 32895, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (279, '8th Orc Unit Outpost', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (280, 'Janus Ivory Tower 4F: Ballog camp', 32832, 32959, 32704, 32831, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (281, 'Janus Ivory Tower 5F: Ballog camp', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (282, 'Janus Ivory Tower 6F: Ballog camp', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (283, 'Janus Ivory Tower 7F: Ballog camp', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (284, 'Janus Ivory Tower 8F: Ballog camp', 32640, 32767, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (285, 'Janus Ivory Tower 4F: Yahee Camp', 32832, 32959, 32704, 32831, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (286, 'Janus Ivory Tower 5F: Yahee Camp', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (287, 'Janus Ivory Tower 6F: Yahee Camp', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (288, 'Janus Ivory Tower 7F: Yahee Camp', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (289, 'Janus Ivory Tower 8F: Yahee Camp', 32640, 32767, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (290, 'Hidden 3rd Orc Unit Outpost', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (291, 'Hidden 4th Orc Unit Outpost', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (479, 'Lastavard Castle: Central Square', 32704, 32959, 32640, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (518, NULL, 32640, 32831, 32704, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (537, 'Doomed Dark Elf Holy Place', 32768, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (613, 'Ground of Snowball fight', 32640, 32895, 32768, 33023, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1),
   (620, 'Internet cafe lobby', 32768, 32831, 32768, 32831, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1),
   (621, 'PC Premium Zone', 32640, 32895, 32768, 32959, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1),
   (622, 'Suspicious Sky Garden: Net Cafe Village', 32704, 32895, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (623, 'Suspicious Garden: Hunting ground for cafes', 32576, 32895, 32832, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (630, 'Castle in the Sky', 32704, 33023, 32768, 33087, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1),
   (631, 'Two Dimensional Space', 32704, 33087, 32640, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1),
   (632, 'Brave Man`s Sacred Place 1', 32640, 32959, 32576, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1),
   (653, 'Internet cafe Giran Prison 1F', 32640, 32895, 32640, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (654, 'Internet cafe Giran Prison 2F', 32640, 32895, 32640, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (655, 'Internet cafe Giran Prison 3F', 32640, 32831, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (656, 'Internet cafe Giran Prison 4F', 32640, 32895, 32640, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (725, NULL, 33472, 33663, 32576, 32767, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (726, NULL, 32640, 32767, 32832, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (785, 'Death Knight Training Ground', 32640, 32959, 32576, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (786, 'Death Knight Secret Training Ground', 32640, 32959, 32576, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (787, 'Death Knight Suspicious Training Ground', 32640, 32959, 32576, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (788, NULL, 32640, 32959, 32576, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (789, NULL, 32640, 32959, 32576, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (790, NULL, 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (791, NULL, 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (792, NULL, 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (793, NULL, 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (794, NULL, 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (795, NULL, 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (796, NULL, 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (797, NULL, 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (798, NULL, 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (799, NULL, 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (800, NULL, 32704, 32895, 32832, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1002, 'Hidden Dragon Land', 32576, 33087, 32512, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (1003, NULL, 32640, 32959, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (1004, NULL, 32512, 32959, 32512, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (1005, 'Antara Slade', 32512, 33023, 32576, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1006, 'Antara Slade', 32512, 33023, 32576, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1007, 'Antara Slade', 32512, 33023, 32576, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1008, 'Antara Slade', 32512, 33023, 32576, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1009, 'Antara Slade', 32512, 33023, 32576, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1010, 'Antara Slade', 32512, 33023, 32576, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1011, 'Paprio Raid', 32640, 33151, 32448, 32959, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1012, 'Paprio Raid', 32640, 33151, 32448, 32959, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1013, 'Paprio Raid', 32640, 33151, 32448, 32959, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1014, 'Paprio Raid', 32640, 33151, 32448, 32959, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1015, 'Paprio Raid', 32640, 33151, 32448, 32959, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1016, 'Paprio Raid', 32640, 33151, 32448, 32959, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1017, 'Lindvior Raid', 32512, 33023, 32768, 33279, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1018, 'Lindvior Raid', 32512, 33023, 32768, 33279, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1019, 'Lindvior Raid', 32512, 33023, 32768, 33279, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1020, 'Lindvior Raid', 32512, 33023, 32768, 33279, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1021, 'Lindvior Raid', 32512, 33023, 32768, 33279, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1022, 'Lindvior Raid', 32512, 33023, 32768, 33279, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1),
   (1234, NULL, 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1259, NULL, 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1284, NULL, 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1309, NULL, 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1400, NULL, 32768, 32959, 32704, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1901, NULL, 32576, 32895, 32704, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1902, NULL, 32576, 32895, 32704, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1903, NULL, 32576, 32895, 32704, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1904, NULL, 32576, 32895, 32704, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1905, NULL, 32576, 32895, 32704, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1906, NULL, 32576, 32895, 32704, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1907, NULL, 32576, 32895, 32704, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1908, NULL, 32576, 32895, 32704, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1909, NULL, 32576, 32895, 32704, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1910, NULL, 32576, 32895, 32704, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1911, NULL, 32576, 32895, 32832, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1912, NULL, 32576, 32895, 32832, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1913, NULL, 32576, 32895, 32832, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1914, NULL, 32576, 32895, 32832, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (1915, NULL, 32576, 32895, 32832, 33023, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (2005, 'Northern Valley(Beginners Zone)', 32512, 32895, 32704, 33087, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1),
   (2006, 'Playground of Metis', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (2007, 'Memory Slime', 32512, 32703, 32640, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (2008, NULL, 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (2009, NULL, 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (2010, 'Storm Training Area(Beginners Zone)', 32576, 33087, 32512, 32831, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (2011, 'Storm Training Area(Beginners Zone)', 32576, 33087, 32512, 32831, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (2100, 'Crystal Cavern Entrance', 32768, 32831, 32768, 32831, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (2101, 'Crystal Cavern', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (2151, 'Crystal Cavern', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (2201, 'Mysterious Ice Crystal Cave 1F', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (2202, 'Mysterious Ice Crystal Cave 2F', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (2203, 'Mysterious Ice Crystal Cave 3F', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (2210, 'Varacus Habitat', 32640, 32831, 32704, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (4995, NULL, 32768, 32831, 32768, 32831, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (4996, NULL, 32768, 32831, 32768, 32831, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (4997, NULL, 32768, 32831, 32768, 32831, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (4998, NULL, 32768, 32831, 32768, 32831, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (4999, NULL, 32768, 32831, 32768, 32831, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5000, NULL, 32768, 32831, 32768, 32831, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5141, 'Ghost Mansion', 32640, 32959, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0),
   (5142, 'Ghost Mansion', 32640, 32959, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0),
   (5143, 'Pet Race', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
   (5144, 'Pet Race', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (5145, 'Pet Race', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (5153, NULL, 32576, 32703, 32832, 32959, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1),
   (5154, NULL, 32576, 32703, 32832, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5155, NULL, 32576, 32703, 32832, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5156, NULL, 32576, 32703, 32832, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5166, 'Place of Recollection', 32704, 32831, 32768, 32895, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1),
   (5167, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1),
   (5168, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5169, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5170, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5171, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5172, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5173, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5174, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5175, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5176, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5177, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5178, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5179, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5180, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5181, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5182, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5183, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5184, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5185, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5186, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5187, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5188, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5189, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5190, 'DevilKing`s Field', 32512, 32767, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5191, 'Ivory Tower Underground Warehouse', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5192, 'Ivory Tower Underground Warehouse', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5193, 'Ivory Tower Underground Warehouse', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5194, 'Ivory Tower Underground Warehouse', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5195, 'Ivory Tower Underground Warehouse', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5196, 'Ivory Tower Underground Warehouse', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5197, 'Ivory Tower Underground Warehouse', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5198, 'Ivory Tower Underground Warehouse', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5199, 'Ivory Tower Underground Warehouse', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5200, NULL, 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (5300, NULL, 32640, 32895, 32704, 32959, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1),
   (5301, NULL, 32640, 32895, 32704, 32959, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1),
   (5302, NULL, 32640, 32895, 32704, 32959, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1),
   (5303, 'dungeon of crack low', 32704, 32895, 32768, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (5384, 'dungeon of crack middle', 32704, 32895, 32640, 32831, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (5435, 'dungeon of crack high', 32704, 32959, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (5501, 'Halloween Event', 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (5551, 'Halpas Meeting Place', 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (5554, 'Yahee Wedding Hall', 32640, 32895, 32704, 32959, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (6041, NULL, 32768, 32895, 32768, 32895, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1),
   (6201, 'Valentines Day Party Place', 32768, 33151, 32768, 33151, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (6202, 'Valentines Day Party Place', 32768, 33151, 32768, 33151, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (6203, 'Valentines Day Party Place', 32768, 33151, 32768, 33151, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1),
   (7100, 'Halloween Event', 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1),
   (7101, 'Halloween Event', 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1),
   (7102, 'Halloween Event', 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1),
   (7103, 'Halloween Event', 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1),
   (7104, 'Halloween Event', 32704, 32959, 32832, 33087, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1),
   (9000, 'Past Secret Labratory', 32576, 32895, 32640, 33023, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1),
   (9100, 'Ivory Tower Secret Lab (Hardin)', 32704, 32767, 32832, 32895, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1),
   (9101, NULL, 32640, 32831, 32768, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1),
   (9202, 'Ivory Tower Secret Lab (Olim)', 32704, 32767, 32832, 32895, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1);

-- Update all map boundaries (courtesy of Tricid).
Update `mapids` set startX='32256', endX='32767', startY='32768', endY='33279' Where mapid='0';
Update `mapids` set startX='32576', endX='32831', startY='32704', endY='32959' Where mapid='1';
Update `mapids` set startX='32576', endX='32895', startY='32704', endY='32959' Where mapid='2';
Update `mapids` set startX='32576', endX='32831', startY='32704', endY='32959' Where mapid='3';
Update `mapids` set startX='32448', endX='34303', startY='32064', endY='33599' Where mapid='4';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32831' Where mapid='6';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='7';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='8';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='9';
Update `mapids` set startX='32640', endX='32831', startY='32640', endY='32895' Where mapid='10';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='11';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='12';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='13';
Update `mapids` set startX='32512', endX='33023', startY='32704', endY='32895' Where mapid='14';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='15';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32895' Where mapid='16';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='17';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='18';
Update `mapids` set startX='32704', endX='32895', startY='32640', endY='32895' Where mapid='19';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='20';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='21';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='22';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='23';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='24';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='25';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='26';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='27';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32895' Where mapid='28';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='29';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='30';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='31';
Update `mapids` set startX='32576', endX='32831', startY='32704', endY='32959' Where mapid='32';
Update `mapids` set startX='32576', endX='32831', startY='32704', endY='32959' Where mapid='33';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='34';
Update `mapids` set startX='32576', endX='32831', startY='32704', endY='32959' Where mapid='35';
Update `mapids` set startX='32576', endX='32831', startY='32704', endY='32959' Where mapid='36';
Update `mapids` set startX='32576', endX='32831', startY='32704', endY='32959' Where mapid='37';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='38';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='39';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='40';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='41';
Update `mapids` set startX='32512', endX='32831', startY='32704', endY='33023' Where mapid='42';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='43';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='44';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='45';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='46';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='47';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='48';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='49';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='50';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='51';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32895' Where mapid='52';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='53';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='54';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32959' Where mapid='55';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='56';
Update `mapids` set startX='32576', endX='33023', startY='32512', endY='32959' Where mapid='57';
Update `mapids` set startX='32512', endX='32831', startY='32704', endY='33023' Where mapid='58';
Update `mapids` set startX='32640', endX='32831', startY='32768', endY='32895' Where mapid='59';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32959' Where mapid='60';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32895' Where mapid='61';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32895' Where mapid='62';
Update `mapids` set startX='32576', endX='32895', startY='32640', endY='32959' Where mapid='63';
Update `mapids` set startX='32512', endX='32639', startY='32768', endY='32895' Where mapid='64';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='65';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='66';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='67';
Update `mapids` set startX='32576', endX='33023', startY='32512', endY='32959' Where mapid='68';
Update `mapids` set startX='32512', endX='32831', startY='32704', endY='33023' Where mapid='69';
Update `mapids` set startX='32576', endX='33023', startY='32640', endY='33087' Where mapid='70';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32895' Where mapid='72';
Update `mapids` set startX='32704', endX='32959', startY='32704', endY='32959' Where mapid='73';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='74';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32959' Where mapid='75';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='76';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='77';
Update `mapids` set startX='32832', endX='32959', startY='32704', endY='32831' Where mapid='78';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='79';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='80';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='81';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32895' Where mapid='82';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32831' Where mapid='83';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='84';
Update `mapids` set startX='32512', endX='32831', startY='32640', endY='32959' Where mapid='85';
Update `mapids` set startX='32768', endX='33023', startY='32704', endY='32895' Where mapid='86';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='87';
Update `mapids` set startX='33472', endX='33599', startY='32640', endY='32767' Where mapid='88';
Update `mapids` set startX='32640', endX='32767', startY='32832', endY='32959' Where mapid='89';
Update `mapids` set startX='32640', endX='32767', startY='32832', endY='32959' Where mapid='90';
Update `mapids` set startX='32640', endX='32767', startY='32832', endY='32959' Where mapid='91';
Update `mapids` set startX='32640', endX='32767', startY='32832', endY='32959' Where mapid='92';
Update `mapids` set startX='32640', endX='32767', startY='32832', endY='32959' Where mapid='93';
Update `mapids` set startX='32640', endX='32767', startY='32832', endY='32959' Where mapid='94';
Update `mapids` set startX='32640', endX='32767', startY='32832', endY='32959' Where mapid='95';
Update `mapids` set startX='32640', endX='32767', startY='32832', endY='32959' Where mapid='96';
Update `mapids` set startX='32640', endX='32767', startY='32832', endY='32959' Where mapid='97';
Update `mapids` set startX='32640', endX='32767', startY='32832', endY='32959' Where mapid='98';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='99';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='100';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='101';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='102';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='103';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='104';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='105';
Update `mapids` set startX='32576', endX='33855', startY='32768', endY='32959' Where mapid='106';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='107';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='108';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='109';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='110';
Update `mapids` set startX='32576', endX='32831', startY='32768', endY='33023' Where mapid='111';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='112';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='113';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='114';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='115';
Update `mapids` set startX='32704', endX='32831', startY='32832', endY='32895' Where mapid='116';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='117';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='118';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='119';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='120';
Update `mapids` set startX='32576', endX='32895', startY='32704', endY='32959' Where mapid='121';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='122';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='123';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='124';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='125';
Update `mapids` set startX='32704', endX='32831', startY='32832', endY='32895' Where mapid='126';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='127';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='128';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='129';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='130';
Update `mapids` set startX='32576', endX='32831', startY='32768', endY='33023' Where mapid='131';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='132';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='133';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='134';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='135';
Update `mapids` set startX='32704', endX='32831', startY='32832', endY='32895' Where mapid='136';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='137';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='138';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='139';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='140';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='141';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='142';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='143';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='144';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='145';
Update `mapids` set startX='32576', endX='32831', startY='32768', endY='32959' Where mapid='146';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='147';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='148';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='149';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='150';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='151';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='152';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='153';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='154';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='155';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32831' Where mapid='156';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='157';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='158';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='159';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='160';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='161';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='162';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='163';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='164';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='165';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32831' Where mapid='166';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='167';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='168';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='169';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='170';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='171';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='172';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='173';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='174';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='175';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32831' Where mapid='176';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='177';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='178';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='179';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='180';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='181';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='182';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='183';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='184';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='185';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32831' Where mapid='186';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='187';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='188';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='189';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='190';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='191';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='192';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='193';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='194';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='195';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32831' Where mapid='196';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='197';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='198';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='199';
Update `mapids` set startX='32576', endX='32831', startY='32768', endY='33023' Where mapid='200';
Update `mapids` set startX='32640', endX='33535', startY='32704', endY='32959' Where mapid='201';
Update `mapids` set startX='32640', endX='33535', startY='32704', endY='32895' Where mapid='202';
Update `mapids` set startX='32640', endX='33535', startY='32704', endY='32895' Where mapid='203';
Update `mapids` set startX='32640', endX='33535', startY='32704', endY='32895' Where mapid='204';
Update `mapids` set startX='32640', endX='33535', startY='32704', endY='32895' Where mapid='205';
Update `mapids` set startX='32640', endX='33535', startY='32704', endY='32895' Where mapid='206';
Update `mapids` set startX='32640', endX='33535', startY='32704', endY='32895' Where mapid='207';
Update `mapids` set startX='32640', endX='33535', startY='32704', endY='32895' Where mapid='208';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='209';
Update `mapids` set startX='32640', endX='33535', startY='32704', endY='32895' Where mapid='210';
Update `mapids` set startX='32640', endX='33535', startY='32704', endY='32895' Where mapid='211';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='213';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32831' Where mapid='217';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='221';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='237';
Update `mapids` set startX='32640', endX='32767', startY='33024', endY='33151' Where mapid='240';
Update `mapids` set startX='32704', endX='32831', startY='32832', endY='32959' Where mapid='241';
Update `mapids` set startX='32704', endX='32831', startY='32896', endY='33087' Where mapid='242';
Update `mapids` set startX='32640', endX='32767', startY='32832', endY='33023' Where mapid='243';
Update `mapids` set startX='32704', endX='33023', startY='32768', endY='33087' Where mapid='244';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='248';
Update `mapids` set startX='32704', endX='32831', startY='32832', endY='32895' Where mapid='249';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='250';
Update `mapids` set startX='32768', endX='32831', startY='32768', endY='32831' Where mapid='251';
Update `mapids` set startX='32576', endX='32767', startY='32832', endY='32895' Where mapid='252';
Update `mapids` set startX='32704', endX='32831', startY='32832', endY='33023' Where mapid='253';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='32959' Where mapid='254';
Update `mapids` set startX='32640', endX='32831', startY='32768', endY='32895' Where mapid='255';
Update `mapids` set startX='32640', endX='32895', startY='32768', endY='33023' Where mapid='256';
Update `mapids` set startX='32640', endX='32831', startY='32768', endY='32895' Where mapid='257';
Update `mapids` set startX='32576', endX='32831', startY='32768', endY='33151' Where mapid='258';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='33023' Where mapid='259';
Update `mapids` set startX='32768', endX='32831', startY='32832', endY='32895' Where mapid='260';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='261';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='262';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='263';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='264';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='265';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='266';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='267';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='268';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='269';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='270';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='271';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='272';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='273';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='274';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='275';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='276';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='277';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32895' Where mapid='278';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='279';
Update `mapids` set startX='32832', endX='32959', startY='32704', endY='32831' Where mapid='280';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='281';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='282';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='283';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32895' Where mapid='284';
Update `mapids` set startX='32832', endX='32959', startY='32704', endY='32831' Where mapid='285';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='286';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='287';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='288';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32895' Where mapid='289';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='290';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='291';
Update `mapids` set startX='32832', endX='32959', startY='32448', endY='32639' Where mapid='300';
Update `mapids` set startX='32576', endX='32767', startY='32768', endY='33023' Where mapid='301';
Update `mapids` set startX='32704', endX='32767', startY='32832', endY='32895' Where mapid='302';
Update `mapids` set startX='32576', endX='32959', startY='32512', endY='32895' Where mapid='303';
Update `mapids` set startX='32576', endX='32959', startY='32768', endY='33023' Where mapid='304';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='305';
Update `mapids` set startX='32512', endX='32767', startY='32768', endY='32959' Where mapid='306';
Update `mapids` set startX='32704', endX='32959', startY='32768', endY='32959' Where mapid='307';
Update `mapids` set startX='32704', endX='33023', startY='32768', endY='32959' Where mapid='308';
Update `mapids` set startX='32704', endX='33087', startY='32768', endY='32959' Where mapid='309';
Update `mapids` set startX='32640', endX='32895', startY='32768', endY='33023' Where mapid='310';
Update `mapids` set startX='32640', endX='33087', startY='32768', endY='33087' Where mapid='320';
Update `mapids` set startX='32640', endX='32831', startY='32768', endY='33023' Where mapid='330';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32959' Where mapid='340';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32895' Where mapid='350';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='360';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='370';
Update `mapids` set startX='32256', endX='32767', startY='32768', endY='33279' Where mapid='371';
Update `mapids` set startX='32448', endX='33087', startY='32576', endY='33087' Where mapid='400';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32895' Where mapid='401';
Update `mapids` set startX='32640', endX='32959', startY='32704', endY='33087' Where mapid='410';
Update `mapids` set startX='32640', endX='32831', startY='32832', endY='33151' Where mapid='420';
Update `mapids` set startX='32640', endX='33023', startY='32704', endY='33087' Where mapid='430';
Update `mapids` set startX='32256', endX='32767', startY='32768', endY='33279' Where mapid='440';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32959' Where mapid='441';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='442';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32959' Where mapid='443';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='444';
Update `mapids` set startX='32704', endX='32831', startY='32832', endY='32895' Where mapid='445';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32831' Where mapid='446';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='447';
Update `mapids` set startX='32576', endX='32831', startY='32768', endY='32959' Where mapid='450';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='451';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='452';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='453';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='454';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32895' Where mapid='455';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='456';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32895' Where mapid='457';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32895' Where mapid='460';
Update `mapids` set startX='32640', endX='32895', startY='32768', endY='32895' Where mapid='461';
Update `mapids` set startX='32640', endX='32895', startY='32768', endY='32895' Where mapid='462';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='463';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='464';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='465';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='466';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32895' Where mapid='467';
Update `mapids` set startX='32576', endX='32703', startY='32832', endY='32959' Where mapid='468';
Update `mapids` set startX='32640', endX='32895', startY='32768', endY='32895' Where mapid='470';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='471';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='472';
Update `mapids` set startX='32704', endX='32959', startY='32768', endY='32895' Where mapid='473';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='474';
Update `mapids` set startX='32640', endX='32831', startY='32768', endY='32895' Where mapid='475';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32895' Where mapid='476';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32959' Where mapid='477';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='478';
Update `mapids` set startX='32704', endX='32959', startY='32640', endY='32895' Where mapid='479';
Update `mapids` set startX='32576', endX='32895', startY='32768', endY='33023' Where mapid='480';
Update `mapids` set startX='32640', endX='32831', startY='32768', endY='32895' Where mapid='481';
Update `mapids` set startX='32576', endX='32831', startY='32704', endY='32895' Where mapid='482';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32959' Where mapid='483';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='484';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32895' Where mapid='490';
Update `mapids` set startX='32640', endX='32767', startY='32704', endY='32895' Where mapid='491';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32895' Where mapid='492';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='493';
Update `mapids` set startX='32768', endX='32895', startY='32704', endY='32831' Where mapid='494';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='495';
Update `mapids` set startX='32768', endX='32895', startY='32768', endY='32895' Where mapid='496';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='500';
Update `mapids` set startX='32576', endX='33215', startY='32512', endY='32959' Where mapid='501';
Update `mapids` set startX='32576', endX='33215', startY='32576', endY='32959' Where mapid='502';
Update `mapids` set startX='32576', endX='33215', startY='32576', endY='32959' Where mapid='503';
Update `mapids` set startX='32576', endX='33215', startY='32576', endY='32959' Where mapid='504';
Update `mapids` set startX='32576', endX='33215', startY='32576', endY='32959' Where mapid='505';
Update `mapids` set startX='32512', endX='33215', startY='32576', endY='32959' Where mapid='506';
Update `mapids` set startX='32704', endX='33023', startY='32768', endY='32959' Where mapid='507';
Update `mapids` set startX='32768', endX='32895', startY='33088', endY='33215' Where mapid='508';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='509';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='510';
Update `mapids` set startX='32576', endX='33215', startY='32576', endY='32895' Where mapid='511';
Update `mapids` set startX='32576', endX='33215', startY='32576', endY='32895' Where mapid='512';
Update `mapids` set startX='32576', endX='33215', startY='32576', endY='32895' Where mapid='513';
Update `mapids` set startX='32576', endX='33215', startY='32576', endY='32895' Where mapid='514';
Update `mapids` set startX='32576', endX='33215', startY='32576', endY='32895' Where mapid='515';
Update `mapids` set startX='32576', endX='33215', startY='32576', endY='32895' Where mapid='516';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='518';
Update `mapids` set startX='32576', endX='32767', startY='32832', endY='33023' Where mapid='521';
Update `mapids` set startX='32576', endX='32831', startY='32832', endY='32959' Where mapid='522';
Update `mapids` set startX='32576', endX='32831', startY='32832', endY='32959' Where mapid='523';
Update `mapids` set startX='32576', endX='32831', startY='32832', endY='32959' Where mapid='524';
Update `mapids` set startX='32704', endX='32959', startY='32768', endY='32959' Where mapid='530';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32959' Where mapid='531';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32895' Where mapid='532';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='33023' Where mapid='533';
Update `mapids` set startX='32704', endX='32959', startY='32768', endY='32895' Where mapid='534';
Update `mapids` set startX='32576', endX='32895', startY='32704', endY='33023' Where mapid='535';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='536';
Update `mapids` set startX='32768', endX='32895', startY='32768', endY='32959' Where mapid='537';
Update `mapids` set startX='32640', endX='32831', startY='32768', endY='32895' Where mapid='541';
Update `mapids` set startX='32640', endX='32831', startY='32768', endY='32895' Where mapid='542';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='543';
Update `mapids` set startX='32384', endX='32895', startY='32640', endY='33151' Where mapid='550';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32895' Where mapid='551';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32895' Where mapid='552';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='553';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='554';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32895' Where mapid='555';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='556';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='557';
Update `mapids` set startX='32704', endX='33215', startY='32768', endY='33279' Where mapid='558';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32895' Where mapid='600';
Update `mapids` set startX='32640', endX='32959', startY='32704', endY='32959' Where mapid='601';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32895' Where mapid='602';
Update `mapids` set startX='32640', endX='32767', startY='32768', endY='32895' Where mapid='603';
Update `mapids` set startX='32768', endX='32895', startY='32768', endY='32895' Where mapid='604';
Update `mapids` set startX='32704', endX='32959', startY='32704', endY='32959' Where mapid='605';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32895' Where mapid='606';
Update `mapids` set startX='32640', endX='32895', startY='32768', endY='32959' Where mapid='607';
Update `mapids` set startX='32640', endX='32767', startY='32832', endY='32959' Where mapid='608';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32959' Where mapid='610';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32831' Where mapid='611';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32959' Where mapid='612';
Update `mapids` set startX='32640', endX='32895', startY='32768', endY='33023' Where mapid='613';
Update `mapids` set startX='32768', endX='32831', startY='32768', endY='32831' Where mapid='620';
Update `mapids` set startX='32640', endX='32895', startY='32768', endY='32959' Where mapid='621';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32895' Where mapid='622';
Update `mapids` set startX='32576', endX='32895', startY='32832', endY='33023' Where mapid='623';
Update `mapids` set startX='32704', endX='33023', startY='32768', endY='33087' Where mapid='630';
Update `mapids` set startX='32704', endX='33087', startY='32640', endY='33023' Where mapid='631';
Update `mapids` set startX='32640', endX='32959', startY='32576', endY='32895' Where mapid='632';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='653';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='654';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32959' Where mapid='655';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='656';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='666';
Update `mapids` set startX='32576', endX='33023', startY='32512', endY='32959' Where mapid='701';
Update `mapids` set startX='33472', endX='33663', startY='32576', endY='32767' Where mapid='725';
Update `mapids` set startX='32640', endX='32767', startY='32832', endY='32959' Where mapid='726';
Update `mapids` set startX='32448', endX='32831', startY='32832', endY='33151' Where mapid='777';
Update `mapids` set startX='32640', endX='32959', startY='32576', endY='33023' Where mapid='778';
Update `mapids` set startX='32768', endX='33023', startY='32704', endY='32895' Where mapid='779';
Update `mapids` set startX='32576', endX='32831', startY='32704', endY='33087' Where mapid='780';
Update `mapids` set startX='32704', endX='33023', startY='32704', endY='32895' Where mapid='781';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='782';
Update `mapids` set startX='32704', endX='33343', startY='32576', endY='32959' Where mapid='783';
Update `mapids` set startX='32704', endX='32831', startY='32832', endY='32895' Where mapid='784';
Update `mapids` set startX='32640', endX='32959', startY='32576', endY='32895' Where mapid='785';
Update `mapids` set startX='32640', endX='32959', startY='32576', endY='32895' Where mapid='786';
Update `mapids` set startX='32640', endX='32959', startY='32576', endY='32895' Where mapid='787';
Update `mapids` set startX='32640', endX='32959', startY='32576', endY='32895' Where mapid='788';
Update `mapids` set startX='32640', endX='32959', startY='32576', endY='32895' Where mapid='789';
Update `mapids` set startX='32704', endX='32959', startY='32832', endY='33087' Where mapid='790';
Update `mapids` set startX='32704', endX='32959', startY='32832', endY='33087' Where mapid='791';
Update `mapids` set startX='32704', endX='32959', startY='32832', endY='33087' Where mapid='792';
Update `mapids` set startX='32704', endX='32959', startY='32832', endY='33087' Where mapid='793';
Update `mapids` set startX='32704', endX='32959', startY='32832', endY='33087' Where mapid='794';
Update `mapids` set startX='32704', endX='32959', startY='32832', endY='33087' Where mapid='795';
Update `mapids` set startX='32704', endX='32959', startY='32832', endY='33087' Where mapid='796';
Update `mapids` set startX='32704', endX='32959', startY='32832', endY='33087' Where mapid='797';
Update `mapids` set startX='32704', endX='32959', startY='32832', endY='33087' Where mapid='798';
Update `mapids` set startX='32704', endX='32959', startY='32832', endY='33087' Where mapid='799';
Update `mapids` set startX='32704', endX='32895', startY='32832', endY='33023' Where mapid='800';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='807';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='808';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='809';
Update `mapids` set startX='32640', endX='32831', startY='32640', endY='32895' Where mapid='810';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='811';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='812';
Update `mapids` set startX='32640', endX='32895', startY='32640', endY='32895' Where mapid='813';
Update `mapids` set startX='32704', endX='33215', startY='32768', endY='33279' Where mapid='814';
Update `mapids` set startX='32640', endX='32959', startY='32576', endY='32895' Where mapid='815';
Update `mapids` set startX='32576', endX='32895', startY='32768', endY='33087' Where mapid='820';
Update `mapids` set startX='32576', endX='32895', startY='32768', endY='33087' Where mapid='821';
Update `mapids` set startX='32576', endX='32895', startY='32768', endY='33087' Where mapid='822';
Update `mapids` set startX='32576', endX='32895', startY='32768', endY='33087' Where mapid='823';
Update `mapids` set startX='32576', endX='32895', startY='32768', endY='33087' Where mapid='824';
Update `mapids` set startX='32576', endX='32895', startY='32768', endY='33087' Where mapid='825';
Update `mapids` set startX='32576', endX='32895', startY='32768', endY='33087' Where mapid='826';
Update `mapids` set startX='32576', endX='32895', startY='32768', endY='33087' Where mapid='827';
Update `mapids` set startX='32576', endX='32895', startY='32768', endY='33087' Where mapid='828';
Update `mapids` set startX='32576', endX='32895', startY='32768', endY='33087' Where mapid='829';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='997';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='998';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='1000';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='1001';
Update `mapids` set startX='32576', endX='33087', startY='32512', endY='33023' Where mapid='1002';
Update `mapids` set startX='32640', endX='32895', startY='32832', endY='32959' Where mapid='1003';
Update `mapids` set startX='32512', endX='32959', startY='32512', endY='32895' Where mapid='1004';
Update `mapids` set startX='32512', endX='33023', startY='32576', endY='33023' Where mapid='1005';
Update `mapids` set startX='32512', endX='33023', startY='32576', endY='33023' Where mapid='1006';
Update `mapids` set startX='32512', endX='33023', startY='32576', endY='33023' Where mapid='1007';
Update `mapids` set startX='32512', endX='33023', startY='32576', endY='33023' Where mapid='1008';
Update `mapids` set startX='32512', endX='33023', startY='32576', endY='33023' Where mapid='1009';
Update `mapids` set startX='32512', endX='33023', startY='32576', endY='33023' Where mapid='1010';
Update `mapids` set startX='32640', endX='33151', startY='32448', endY='32959' Where mapid='1011';
Update `mapids` set startX='32640', endX='33151', startY='32448', endY='32959' Where mapid='1012';
Update `mapids` set startX='32640', endX='33151', startY='32448', endY='32959' Where mapid='1013';
Update `mapids` set startX='32640', endX='33151', startY='32448', endY='32959' Where mapid='1014';
Update `mapids` set startX='32640', endX='33151', startY='32448', endY='32959' Where mapid='1015';
Update `mapids` set startX='32640', endX='33151', startY='32448', endY='32959' Where mapid='1016';
Update `mapids` set startX='32512', endX='33023', startY='32768', endY='33279' Where mapid='1017';
Update `mapids` set startX='32512', endX='33023', startY='32768', endY='33279' Where mapid='1018';
Update `mapids` set startX='32512', endX='33023', startY='32768', endY='33279' Where mapid='1019';
Update `mapids` set startX='32512', endX='33023', startY='32768', endY='33279' Where mapid='1020';
Update `mapids` set startX='32512', endX='33023', startY='32768', endY='33279' Where mapid='1021';
Update `mapids` set startX='32512', endX='33023', startY='32768', endY='33279' Where mapid='1022';
Update `mapids` set startX='32512', endX='33023', startY='32576', endY='33023' Where mapid='1029';
Update `mapids` set startX='32640', endX='33151', startY='32448', endY='32959' Where mapid='1035';
Update `mapids` set startX='32512', endX='33023', startY='32768', endY='33279' Where mapid='1041';
Update `mapids` set startX='32512', endX='33023', startY='32576', endY='33023' Where mapid='1053';
Update `mapids` set startX='32640', endX='33151', startY='32448', endY='32959' Where mapid='1059';
Update `mapids` set startX='32512', endX='33023', startY='32768', endY='33279' Where mapid='1065';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='1234';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='1259';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='1284';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='1309';
Update `mapids` set startX='32768', endX='32959', startY='32704', endY='32895' Where mapid='1400';
Update `mapids` set startX='32576', endX='32895', startY='32704', endY='33023' Where mapid='1901';
Update `mapids` set startX='32576', endX='32895', startY='32704', endY='33023' Where mapid='1902';
Update `mapids` set startX='32576', endX='32895', startY='32704', endY='33023' Where mapid='1903';
Update `mapids` set startX='32576', endX='32895', startY='32704', endY='33023' Where mapid='1904';
Update `mapids` set startX='32576', endX='32895', startY='32704', endY='33023' Where mapid='1905';
Update `mapids` set startX='32576', endX='32895', startY='32704', endY='33023' Where mapid='1906';
Update `mapids` set startX='32576', endX='32895', startY='32704', endY='33023' Where mapid='1907';
Update `mapids` set startX='32576', endX='32895', startY='32704', endY='33023' Where mapid='1908';
Update `mapids` set startX='32576', endX='32895', startY='32704', endY='33023' Where mapid='1909';
Update `mapids` set startX='32576', endX='32895', startY='32704', endY='33023' Where mapid='1910';
Update `mapids` set startX='32576', endX='32895', startY='32832', endY='33023' Where mapid='1911';
Update `mapids` set startX='32576', endX='32895', startY='32832', endY='33023' Where mapid='1912';
Update `mapids` set startX='32576', endX='32895', startY='32832', endY='33023' Where mapid='1913';
Update `mapids` set startX='32576', endX='32895', startY='32832', endY='33023' Where mapid='1914';
Update `mapids` set startX='32576', endX='32895', startY='32832', endY='33023' Where mapid='1915';
Update `mapids` set startX='32576', endX='32959', startY='32576', endY='32959' Where mapid='1920';
Update `mapids` set startX='32576', endX='32959', startY='32576', endY='32959' Where mapid='1921';
Update `mapids` set startX='32576', endX='32959', startY='32576', endY='32959' Where mapid='1922';
Update `mapids` set startX='32576', endX='32959', startY='32576', endY='32959' Where mapid='1923';
Update `mapids` set startX='32576', endX='32959', startY='32576', endY='32959' Where mapid='1924';
Update `mapids` set startX='32576', endX='32959', startY='32576', endY='32959' Where mapid='1925';
Update `mapids` set startX='32576', endX='32959', startY='32576', endY='32959' Where mapid='1926';
Update `mapids` set startX='32576', endX='32959', startY='32576', endY='32959' Where mapid='1927';
Update `mapids` set startX='32576', endX='32959', startY='32576', endY='32959' Where mapid='1928';
Update `mapids` set startX='32576', endX='32959', startY='32576', endY='32959' Where mapid='1929';
Update `mapids` set startX='32448', endX='32831', startY='32832', endY='33151' Where mapid='1930';
Update `mapids` set startX='32576', endX='32959', startY='32576', endY='32895' Where mapid='1931';
Update `mapids` set startX='32576', endX='32959', startY='32576', endY='32895' Where mapid='1932';
Update `mapids` set startX='32768', endX='32831', startY='32768', endY='32831' Where mapid='1935';
Update `mapids` set startX='32768', endX='32831', startY='32832', endY='32895' Where mapid='1936';
Update `mapids` set startX='32640', endX='32959', startY='32704', endY='33023' Where mapid='2000';
Update `mapids` set startX='32640', endX='32959', startY='32704', endY='32959' Where mapid='2001';
Update `mapids` set startX='32704', endX='32959', startY='32704', endY='32959' Where mapid='2002';
Update `mapids` set startX='32704', endX='32959', startY='32704', endY='32959' Where mapid='2003';
Update `mapids` set startX='32640', endX='32895', startY='32768', endY='32959' Where mapid='2004';
Update `mapids` set startX='32512', endX='32895', startY='32704', endY='33087' Where mapid='2005';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='2006';
Update `mapids` set startX='32512', endX='32703', startY='32640', endY='32895' Where mapid='2007';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='2008';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='2009';
Update `mapids` set startX='32576', endX='33087', startY='32512', endY='32831' Where mapid='2010';
Update `mapids` set startX='32576', endX='33087', startY='32512', endY='32831' Where mapid='2011';
Update `mapids` set startX='32576', endX='33087', startY='32512', endY='32831' Where mapid='2012';
Update `mapids` set startX='32576', endX='33087', startY='32512', endY='32831' Where mapid='2013';
Update `mapids` set startX='32576', endX='33087', startY='32512', endY='32831' Where mapid='2014';
Update `mapids` set startX='32768', endX='32831', startY='32768', endY='32831' Where mapid='2100';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='2101';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='2151';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='2201';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='2202';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='2203';
Update `mapids` set startX='32640', endX='32831', startY='32704', endY='32895' Where mapid='2210';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32831' Where mapid='2225';
Update `mapids` set startX='32704', endX='32895', startY='32640', endY='32895' Where mapid='2226';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32895' Where mapid='2227';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32895' Where mapid='2228';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='33151' Where mapid='2301';
Update `mapids` set startX='32512', endX='32959', startY='32704', endY='33087' Where mapid='2600';
Update `mapids` set startX='32576', endX='32703', startY='33024', endY='33087' Where mapid='2699';
Update `mapids` set startX='32768', endX='32831', startY='32768', endY='32831' Where mapid='4995';
Update `mapids` set startX='32768', endX='32831', startY='32768', endY='32831' Where mapid='4996';
Update `mapids` set startX='32768', endX='32831', startY='32768', endY='32831' Where mapid='4997';
Update `mapids` set startX='32768', endX='32831', startY='32768', endY='32831' Where mapid='4998';
Update `mapids` set startX='32768', endX='32831', startY='32768', endY='32831' Where mapid='4999';
Update `mapids` set startX='32768', endX='32831', startY='32768', endY='32831' Where mapid='5000';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5001';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5002';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5003';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5004';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5005';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5006';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5007';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5008';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5009';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5010';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5011';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5012';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5013';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5014';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5015';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5016';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5017';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5018';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5019';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5020';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5021';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5022';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5023';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5024';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5025';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5026';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5027';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5028';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5029';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5030';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5031';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5032';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5033';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5034';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5035';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5036';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5037';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5038';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5039';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5040';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5041';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5042';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5043';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5044';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5045';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5046';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5047';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5048';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5049';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5050';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5051';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5052';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5053';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5054';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5055';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5056';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5057';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5058';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5059';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5060';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5061';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5062';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5063';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5064';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5065';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5066';
Update `mapids` set startX='32704', endX='32831', startY='32704', endY='32831' Where mapid='5067';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5068';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5069';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5070';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5071';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5072';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5073';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5074';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5075';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5076';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5077';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5078';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5079';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5080';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5081';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5082';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5083';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5084';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5085';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5086';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5087';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5088';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5089';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5090';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5091';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5092';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5093';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5094';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5095';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5096';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5097';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5098';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5099';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5100';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5101';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5102';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5103';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5104';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5105';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5106';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5107';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5108';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5109';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5110';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5111';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5112';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5113';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5114';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5115';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5116';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5117';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5118';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5119';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5120';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5121';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5122';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5123';
Update `mapids` set startX='32704', endX='32895', startY='32704', endY='32895' Where mapid='5124';
Update `mapids` set startX='32768', endX='32895', startY='32768', endY='32895' Where mapid='5125';
Update `mapids` set startX='32640', endX='32959', startY='32704', endY='32959' Where mapid='5140';
Update `mapids` set startX='32640', endX='32959', startY='32704', endY='32959' Where mapid='5141';
Update `mapids` set startX='32640', endX='32959', startY='32704', endY='32959' Where mapid='5142';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5143';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5144';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5145';
Update `mapids` set startX='32576', endX='32703', startY='32832', endY='32959' Where mapid='5153';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5166';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5167';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5168';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5169';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5170';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5171';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5172';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5173';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5174';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5175';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5176';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5177';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5178';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5179';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5180';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5181';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5182';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5183';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5184';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5185';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5186';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5187';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5188';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5189';
Update `mapids` set startX='32512', endX='32767', startY='32704', endY='32959' Where mapid='5190';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='5191';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='5192';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='5193';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='5194';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='5195';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='5196';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='5197';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='5198';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='5199';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='5200';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5224';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32959' Where mapid='5300';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32959' Where mapid='5301';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32959' Where mapid='5302';
Update `mapids` set startX='32704', endX='32895', startY='32768', endY='32959' Where mapid='5303';
Update `mapids` set startX='32704', endX='32895', startY='32640', endY='32831' Where mapid='5384';
Update `mapids` set startX='32704', endX='32959', startY='32704', endY='32959' Where mapid='5435';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32959' Where mapid='5490';
Update `mapids` set startX='32704', endX='32959', startY='32832', endY='33087' Where mapid='5501';
Update `mapids` set startX='32704', endX='32959', startY='32832', endY='33087' Where mapid='5551';
Update `mapids` set startX='32640', endX='32895', startY='32704', endY='32959' Where mapid='5554';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5800';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5801';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5802';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5803';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5804';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5805';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5806';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5807';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5808';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5809';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5810';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5811';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5812';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5813';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5814';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5815';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5816';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5817';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5818';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5819';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5820';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5821';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5822';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5823';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5825';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5826';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5827';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5828';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5829';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5830';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5831';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5832';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5833';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5834';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5835';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5836';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5837';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5838';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5839';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5840';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5841';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5842';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5843';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5844';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5845';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5846';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5847';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5848';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='5849';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5850';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5851';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5852';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5853';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5854';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5855';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5856';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5857';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5858';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5859';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5860';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5861';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5862';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5863';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5864';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5865';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5866';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5867';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5868';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='5869';
Update `mapids` set startX='32768', endX='32895', startY='32768', endY='32895' Where mapid='6041';
Update `mapids` set startX='32768', endX='33151', startY='32768', endY='33151' Where mapid='6201';
Update `mapids` set startX='32768', endX='33151', startY='32768', endY='33151' Where mapid='6202';
Update `mapids` set startX='32768', endX='33151', startY='32768', endY='33151' Where mapid='6203';
Update `mapids` set startX='32576', endX='32831', startY='32768', endY='33023' Where mapid='6400';
Update `mapids` set startX='32576', endX='32831', startY='32768', endY='33023' Where mapid='6430';
Update `mapids` set startX='32704', endX='32959', startY='32832', endY='33087' Where mapid='7100';
Update `mapids` set startX='32576', endX='32895', startY='32640', endY='33023' Where mapid='9000';
Update `mapids` set startX='32704', endX='32767', startY='32832', endY='32895' Where mapid='9100';
Update `mapids` set startX='32640', endX='32831', startY='32768', endY='32895' Where mapid='9101';
Update `mapids` set startX='32704', endX='32831', startY='32768', endY='32895' Where mapid='9102';
Update `mapids` set startX='32704', endX='32767', startY='32832', endY='32895' Where mapid='9202';
Update `mapids` set startX='32576', endX='33087', startY='32512', endY='33023' Where mapid='10101';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='16384';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='16896';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='17408';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='17920';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='18432';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='18944';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='19456';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='19968';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='20480';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='20992';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='21504';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='22016';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='22528';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='23040';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='23552';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='24064';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='24576';
Update `mapids` set startX='32704', endX='32767', startY='32768', endY='32831' Where mapid='25088';

UPDATE `etcitem` SET `stackable` = 1 WHERE `item_type` = 'spellbook';
