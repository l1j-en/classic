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
