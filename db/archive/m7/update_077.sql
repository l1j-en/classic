-- update 77

-- Fix itemid for 'Lump of Steel' in Iron Golem/Horrific Iron Golem drops.
update droplist set itemid=40779 where itemid=40799 and (mobid=45372 or mobid=45479);

-- TODO: ultimately determine what to do with Phantasm.
update skills set probability_dice=4 where name="phantasm";

-- Correct the Hp of Yahee fly type
update npc set hp=30000 where npcid=81082;

-- Adjust drop rate of Yahee set material 
update droplist set chance=23000 where itemid in (40669, 40671, 40672);
update droplist set chance=460 where itemid in (40670, 40673);
update droplist set chance=30000 where itemid=40674;

-- Adjust drops of Varlok
update droplist set min=10,max=40,chance=500000 where mobid=45753 and itemid=40524;
update droplist set chance=100000 where mobid=45753 and itemid=40718;
update droplist set min=2,max=4 where mobid=45753 and itemid=40998;
update droplist set chance=7600 where mobid=45753 and itemid in (40995, 40997, 40990);
update droplist set chance=7600 where mobid=45753 and itemid in (40994, 40993, 40998);
update droplist set chance=3000 where mobid=45753 and itemid in (40996, 40992);

-- Correct the type of Cockatrice spawned in TOI
update spawnlist set npc_templateid=81173 where npc_templateid=45361 and mapid in (105,107,108,109,110);

-- Remove Assistant of Varlok currently spawned in SOE (should only be spawned in Cave of Desire)
update spawnlist_npc set count=0 where npc_templateid=80071 and mapid=410;

-- Add .ipcheck to GM commands with default access level of 100
INSERT INTO commands VALUES ('ipcheck', '100', 'CheckIP');

-- Correct the wrong itemid of Green Dragon Armor from Antharas
update droplist set itemId=20146 where mobId=45682 and itemId=21046;

-- Pets adjustments
-- Increase the mpr of Jindo Dog from 10mpr/5s to 8mpr/2.5s
update npc set mprinterval=2500, mpr=8 where npcid=45712;

-- Increase the attack speed of High Cat (decrease cooldown from 1000 to 900)
update npc set atkspeed=900 where npcid=45696;

-- Increase the leverage of Cone of Cold from High Rabbit by 10% (original value is 0)
update mobskill set leverage=11 where mobid=45695 and actNo=0;

-- Increase the current max mp of High Raccoon by 2 per lvl (for pets already in db)
update pets set mp=20+6*(lvl-1) where npcid=45697;

-- Increase the mpincrease of High Raccoon by 2 per lvl (for new pets)
update pettypes set MpUpMin=5, MpUpMax=7 where BaseNpcId=45697;

-- TOS 2F/3F soul frag drop adjustments
-- Set the soul frag drop rate to be 10% at 2f
update droplist set chance=100000 where itemId=40678 and mobId in (45536, 45542, 45575, 45597, 45598);

-- Set the soul frag drop rate to be 12% at 3f
update droplist set chance=120000 where itemId=40678 and mobId in (45596, 45623, 45624, 45628, 45629, 45630, 45631, 45632);

-- Increase the amount of soul frags Death drops
update droplist set min=50, max=131 where itemId=40678 and mobId=45674;

-- Increase both the drop rate (originally 3%) and amount of soul frags Yahee drops
update droplist set chance=1000000, min=80, max=151 where itemId=40678 and mobId=81082;

-- ----------------------------
-- Table structure for LogIP
-- ----------------------------
DROP TABLE IF EXISTS LogIP;
CREATE TABLE LogIP (
  LoginTime varchar(255) DEFAULT NULL,
  Ip varchar(255) DEFAULT NULL,
  Account varchar(255) DEFAULT NULL,
  CharName varchar(255) DEFAULT NULL,
  LogoutTime varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Lance master crashes Tikal client
delete from polymorphs where id = 7338 or id = 7339 or id = 7340 or id = 7341 or id = 7332;
-- insert into polymorphs values
-- (7332,'spearm 52',7332,52,1080,4095,1,7),
-- (7338,'spearm 55',7338,55,1080,4095,1,7),
-- (7339,'spearm 60',7339,60,1080,4095,1,7),
-- (7340,'spearm 65',7340,65,1080,4095,1,7),
-- (7341,'spearm 70',7341,70,1080,4095,1,7);

-- Shorten length of custom teleport scroll names for better display
UPDATE `etcitem` SET `name` = 'Teleport - Lastabad' where item_id = '40083';
UPDATE `etcitem` SET `name` = 'Teleport - Diad Fortress' where item_id = '40084';
UPDATE `etcitem` SET `name` = 'Teleport - Diad Fortress' where item_id = '40121';
UPDATE `etcitem` SET `name` = 'Teleport - Giant Bridge' where item_id = '40801';
UPDATE `etcitem` SET `name` = 'Teleport - Aden Castle' where item_id = '40802';
UPDATE `etcitem` SET `name` = 'Teleport - Mirror Forest' where item_id = '40803';
UPDATE `etcitem` SET `name` = 'Teleport - Valakas' where item_id = '40804';
UPDATE `etcitem` SET `name` = 'Teleport - Fafurion' where item_id = '40805';
UPDATE `etcitem` SET `name` = 'Teleport - Lindvior' where item_id = '40806';
UPDATE `etcitem` SET `name` = 'Teleport - Heine Dungeon 3F' where item_id = '40807';
UPDATE `etcitem` SET `name` = 'Teleport - Heine Dungeon 4F' where item_id = '40808';
UPDATE `etcitem` SET `name` = 'Teleport - Fire Valley Bridge' where item_id = '40809';
UPDATE `etcitem` SET `name` = 'Teleport - Dragon Valley' where item_id = '40810';
UPDATE `etcitem` SET `name` = 'Teleport - Oasis' where item_id = '40811';
UPDATE `etcitem` SET `name` = 'Teleport - Oren Wasteland' where item_id = '40812';
UPDATE `etcitem` SET `name` = 'Teleport - Wasteland' where item_id = '40813';
UPDATE `etcitem` SET `name` = 'Teleport - Small Wasteland' where item_id = '40814';
UPDATE `etcitem` SET `name` = 'Teleport - Woodbec Castle' where item_id = '40815';
UPDATE `etcitem` SET `name` = 'Teleport - Beleth' where item_id = '40816';
UPDATE `etcitem` SET `name` = 'Teleport - Ant Cave 1F' where item_id = '40817';
UPDATE `etcitem` SET `name` = 'Teleport - Ant Cave 2F' where item_id = '40818';
UPDATE `etcitem` SET `name` = 'Teleport - Ant Cave 3F' where item_id = '40819';
UPDATE `etcitem` SET `name` = 'Teleport - Ivory Tower 5F' where item_id = '40820';
UPDATE `etcitem` SET `name` = 'Teleport - Ivory Tower 6F' where item_id = '40821';
UPDATE `etcitem` SET `name` = 'Teleport - Ivory Tower 7F' where item_id = '40822';
UPDATE `etcitem` SET `name` = 'Teleport - Ivory Tower 8F' where item_id = '40823';
UPDATE `etcitem` SET `name` = 'Teleport - SKT Caves 2F' where item_id = '40824';
UPDATE `etcitem` SET `name` = 'Teleport - SKT Caves 3F' where item_id = '40825';
UPDATE `etcitem` SET `name` = 'Teleport - SKT Caves 4F' where item_id = '40826';
UPDATE `etcitem` SET `name` = 'Teleport - Giran Dungeonn 2F' where item_id = '40827';
UPDATE `etcitem` SET `name` = 'Teleport - Giran Dungeonn 3F' where item_id = '40828';
UPDATE `etcitem` SET `name` = 'Teleport - Giran Dungeonn 4F' where item_id = '40829';
UPDATE `etcitem` SET `name` = 'Teleport - MLC 3F' where item_id = '40830';
UPDATE `etcitem` SET `name` = 'Teleport - MLC 4F' where item_id = '40831';
UPDATE `etcitem` SET `name` = 'Teleport - MLC 5F' where item_id = '40832';
UPDATE `etcitem` SET `name` = 'Teleport - MLC 6F' where item_id = '40833';
UPDATE `etcitem` SET `name` = 'Teleport - MLC 7F' where item_id = '40834';
UPDATE `etcitem` SET `name` = 'Teleport - DVC 1F' where item_id = '40835';
UPDATE `etcitem` SET `name` = 'Teleport - DVC 2F' where item_id = '40836';
UPDATE `etcitem` SET `name` = 'Teleport - DVC 3F' where item_id = '40837';
UPDATE `etcitem` SET `name` = 'Teleport - DVC 4F' where item_id = '40838';
UPDATE `etcitem` SET `name` = 'Teleport - DVC 5F' where item_id = '40839';
UPDATE `etcitem` SET `name` = 'Teleport - DVC 6F' where item_id = '40840';
UPDATE `etcitem` SET `name` = 'Teleport - Antharas' where item_id = '40841';
UPDATE `etcitem` SET `name` = 'Teleport - Windawood Castle' where item_id = '40842';
UPDATE `etcitem` SET `name` = 'Teleport - Desert' where item_id = '40843';
UPDATE `etcitem` SET `name` = 'Teleport - Elder Room' where item_id = '40844';
UPDATE `etcitem` SET `name` = 'Teleport - Silent Cavern' where item_id = '40845';
UPDATE `etcitem` SET `name` = 'Teleport - Diad 1F' where item_id = '40846';
UPDATE `etcitem` SET `name` = 'Teleport - Diad 2F' where item_id = '40847';
UPDATE `etcitem` SET `name` = 'Teleport - Diad 3F' where item_id = '40848';
UPDATE `etcitem` SET `name` = 'Teleport - Trails 1F' where item_id = '40849';
UPDATE `etcitem` SET `name` = 'Teleport - Trails 2F' where item_id = '40850';
UPDATE `etcitem` SET `name` = 'Teleport - Trails 4F' where item_id = '40851';
UPDATE `etcitem` SET `name` = 'Teleport - Lastabad 1F' where item_id = '40852';
UPDATE `etcitem` SET `name` = 'Teleport - Resistance Village' where item_id = '40853';
UPDATE `etcitem` SET `name` = 'Teleport - SoE 1F' where item_id = '40854';
UPDATE `etcitem` SET `name` = 'Teleport - Abyss Lake' where item_id = '40855';
UPDATE `etcitem` SET `name` = 'Teleport - Pirate Island' where item_id = '40856';
UPDATE `etcitem` SET `name` = 'Teleport - Diad Fortress' where item_id = '40857';
UPDATE `etcitem` SET `name` = 'Teleport - GM' where item_id = '42001';
UPDATE `etcitem` SET `name` = 'Teleport - Crystal Cave 1F' where item_id = '42002';
UPDATE `etcitem` SET `name` = 'Teleport - Crystal Cave 2F' where item_id = '42003';
UPDATE `etcitem` SET `name` = 'Teleport - Crystal Cave 3F' where item_id = '42004';
UPDATE `etcitem` SET `name` = 'Teleport - Ivory Tower 1F' where item_id = '42005';
UPDATE `etcitem` SET `name` = 'Teleport - Kent Dungeonn 1F' where item_id = '42006';
UPDATE `etcitem` SET `name` = 'Teleport - Forgotten Island' where item_id = '42007';
UPDATE `etcitem` SET `name` = 'Teleport - Kent Dungeonn 2F' where item_id = '42008';
UPDATE `etcitem` SET `name` = 'Teleport - Kent Dungeonn 3F' where item_id = '42009';
UPDATE `etcitem` SET `name` = 'Teleport - Kent Dungeonn 4F' where item_id = '42010';
UPDATE `etcitem` SET `name` = 'Teleport - 1F Meeting Area' where item_id = '42011';
UPDATE `etcitem` SET `name` = 'Teleport - 1F Squad Training' where item_id = '42012';
UPDATE `etcitem` SET `name` = 'Teleport - 1F Power King' where item_id = '42013';
UPDATE `etcitem` SET `name` = 'Teleport - 1F Dark Warrens' where item_id = '42014';
UPDATE `etcitem` SET `name` = 'Teleport - 1F Dark Warrens' where item_id = '42016';
UPDATE `etcitem` SET `name` = 'Teleport - Dream Island' where item_id = '42017';
UPDATE `etcitem` SET `name` = 'Teleport - 1F Summoning' where item_id = '42018';
UPDATE `etcitem` SET `name` = 'Teleport - 1F Dark Barrier' where item_id = '42019';
UPDATE `etcitem` SET `name` = 'Teleport - 2F Magic Training' where item_id = '42020';
UPDATE `etcitem` SET `name` = 'Teleport - Giant`s Grave' where item_id = '42021';
UPDATE `etcitem` SET `name` = 'Teleport - Aden Castle' where item_id = '42022';
UPDATE `etcitem` SET `name` = 'Teleport - GM Room' where item_id = '42023';
UPDATE `etcitem` SET `name` = 'Teleport - Lawful Temple' where item_id = '42024';
UPDATE `etcitem` SET `name` = 'Teleport - Chaotic Temple' where item_id = '42025';
UPDATE `etcitem` SET `name` = 'Teleport - Aden Tower' where item_id = '42026';
UPDATE `etcitem` SET `name` = 'Teleport - MLC7' where item_id = '42028';
UPDATE `etcitem` SET `name` = 'Teleport - TOI 100F' where item_id = '42029';
UPDATE `etcitem` SET `name` = 'Teleport - TOI 90F' where item_id = '42030';
UPDATE `etcitem` SET `name` = 'Teleport - TOI 80F' where item_id = '42031';
UPDATE `etcitem` SET `name` = 'Teleport - TOI 70F' where item_id = '42032';
UPDATE `etcitem` SET `name` = 'Teleport - TOI 60F' where item_id = '42033';
UPDATE `etcitem` SET `name` = 'Teleport - TOI 50F' where item_id = '42035';
UPDATE `etcitem` SET `name` = 'Teleport - TOI 40F' where item_id = '42036';
UPDATE `etcitem` SET `name` = 'Teleport - TOI 30F' where item_id = '42037';
UPDATE `etcitem` SET `name` = 'Teleport - TOI 20F' where item_id = '42038';
UPDATE `etcitem` SET `name` = 'Teleport - TOI 10F' where item_id = '42039';
UPDATE `etcitem` SET `name` = 'Teleport - PI Dungeon 1F' where item_id = '42040';
UPDATE `etcitem` SET `name` = 'Teleport - PI Dungeon 2F' where item_id = '42041';
UPDATE `etcitem` SET `name` = 'Teleport - PI Dungeon 3F' where item_id = '42042';
UPDATE `etcitem` SET `name` = 'Teleport - Abyss Lake' where item_id = '42043';
UPDATE `etcitem` SET `name` = 'Teleport - TI Training' where item_id = '42044';
UPDATE `etcitem` SET `name` = 'Teleport - Pledge House' where item_id = '42045';
UPDATE `etcitem` SET `name` = 'Teleport - Pledge House' where item_id = '42046';
UPDATE `etcitem` SET `name` = 'Teleport - Ancient Space 3F' where item_id = '42047';
UPDATE `etcitem` SET `name` = 'Teleport - Oum Dungeonn' where item_id = '42048';
UPDATE `etcitem` SET `name` = 'Teleport - Forgotten Island' where item_id = '42049';
UPDATE `etcitem` SET `name` = 'Teleport - Temple of Shadows' where item_id = '42051';
UPDATE `etcitem` SET `name` = 'Teleport - ToS 1F' where item_id = '42052';
UPDATE `etcitem` SET `name` = 'Teleport - ToS 2F' where item_id = '42053';
UPDATE `etcitem` SET `name` = 'Teleport - ToS 3F' where item_id = '42054';
UPDATE `etcitem` SET `name` = 'Teleport - Polluted Land of Blessing' where item_id = '42055';
UPDATE `etcitem` SET `name` = 'Teleport - Giran Hidden Dungeon' where item_id = '42056';
UPDATE `etcitem` SET `name` = 'Teleport - Giran Hidden Dungeon' where item_id = '42057';
UPDATE `etcitem` SET `name` = 'Teleport - Giran Hidden Dungeon' where item_id = '42058';
UPDATE `etcitem` SET `name` = 'Teleport - Count`s Room' where item_id = '42059';
UPDATE `etcitem` SET `name` = 'Teleport - Heine Basement Dungeon' where item_id = '42060';
UPDATE `etcitem` SET `name` = 'Teleport - Kingdom of Eva' where item_id = '42061';
UPDATE `etcitem` SET `name` = 'Teleport - Barbados Hideout' where item_id = '42062';
UPDATE `etcitem` SET `name` = 'Teleport - Dwarf Mine' where item_id = '42063';
UPDATE `etcitem` SET `name` = 'Teleport - Wilderness' where item_id = '42064';
UPDATE `etcitem` SET `name` = 'Teleport - Basement Floor 1 Path of the Dead' where item_id = '42065';
UPDATE `etcitem` SET `name` = 'Teleport - Basement Floor 2 Grave of the Dead' where item_id = '42066';
UPDATE `etcitem` SET `name` = 'Teleport - Basement Floor 3 Path of the Dead' where item_id = '42067';
UPDATE `etcitem` SET `name` = 'Teleport - Basement Floor 2 Grave of the Dead' where item_id = '42068';
UPDATE `etcitem` SET `name` = 'Teleport - Talking Island Dungeon' where item_id = '42069';
UPDATE `etcitem` SET `name` = 'Teleport - Talking Island Dungeon' where item_id = '42070';
UPDATE `etcitem` SET `name` = 'Teleport - Underground Passage' where item_id = '42071';
UPDATE `etcitem` SET `name` = 'Teleport - Elven Forest Dungeon' where item_id = '42072';
UPDATE `etcitem` SET `name` = 'Teleport - Elven Forest Dungeon' where item_id = '42073';
UPDATE `etcitem` SET `name` = 'Teleport - Elven Forest Dungeon' where item_id = '42074';
UPDATE `etcitem` SET `name` = 'Teleport - Sanctuary of Oblivion' where item_id = '42075';
UPDATE `etcitem` SET `name` = 'Teleport - Sanctuary of Oblivion' where item_id = '42076';
UPDATE `etcitem` SET `name` = 'Teleport - Sanctuary of Oblivion' where item_id = '42077';
UPDATE `etcitem` SET `name` = 'Teleport - Garden Square 4F' where item_id = '42078';
UPDATE `etcitem` SET `name` = 'Teleport - Elder Meeting Room' where item_id = '42079';
UPDATE `etcitem` SET `name` = 'Teleport - Pirate Island Lizard' where item_id = '42080';
UPDATE `etcitem` SET `name` = 'Teleport - Watery Grave of Spirit' where item_id = '42081';
UPDATE `etcitem` SET `name` = 'Teleport - Deep Sea Grave of Spirit' where item_id = '42082';
UPDATE `etcitem` SET `name` = 'Teleport - Losus Island' where item_id = '42083';
UPDATE `etcitem` SET `name` = 'Teleport - Room of Waves' where item_id = '42084';
UPDATE `etcitem` SET `name` = 'Teleport - Room of Flames' where item_id = '42085';
UPDATE `etcitem` SET `name` = 'Teleport - Room of Hurricanes' where item_id = '42086';
UPDATE `etcitem` SET `name` = 'Teleport - Room of Earthquakes' where item_id = '42087';
UPDATE `etcitem` SET `name` = 'Teleport - Turtle Island' where item_id = '240102';
UPDATE `etcitem` SET `name` = 'Teleport - Boss Event' where item_id = '42099';

-- Reduce spell damage in noob TOS
UPDATE `mobskill` SET `leverage` = 0 WHERE mobid in (46094, 46096);

-- Adjust spawn rate in DV
DELETE FROM `spawnlist` where `npc_templateid` in (45269, 45286, 45270) and `mapid` = 4;
DELETE FROM `spawnlist` where `mapid` = 4 and `locx` >= 33229 and `locx` <= 33449
	and `locy` >= 32232 and `locy` <= 32483 and `npc_templateid` in (45161, 45259);
INSERT INTO `spawnlist` VALUES
	(12525, 'Skeleton Guard', 60, 45269, 0, 0, 0, 0, 0, 33229, 32232, 33449, 32483, 0, 60, 120, 4, 0, 100, 0, 0, 1, 8, 2, 100),
	(13400, 'Skeleton Fighter', 60, 45286, 0, 0, 0, 0, 0, 33229, 32232, 33449, 32483, 0, 60, 120, 4, 0, 100, 0, 0, 1, 8, 2, 100),
	(12746, 'Skeleton Marksman', 60, 45270, 0, 0, 0, 0, 0, 33229, 32232, 33449, 32483, 0, 60, 120, 4, 0, 100, 0, 0, 1, 8, 2, 100),
	(7799, 'Spartoi', 50, 45161, 0, 0, 0, 0, 0, 33231, 32277, 33443, 32475, 0, 60, 120, 4, 0, 100, 0, 0, 1, 8, 2, 100),
	(12171, 'Scorpion', 50, 45259, 0, 0, 0, 0, 0, 33231, 32277, 33443, 32475, 0, 60, 120, 4, 0, 100, 0, 0, 1, 8, 2, 100);

-- Increase Cougar summon's hp and regen
UPDATE `npc` SET `hp` = 2000, `hpr` = 100 WHERE `npcid` = 81240;

-- Decrease TI Dungeon spawn rate
UPDATE `spawnlist` set `count` = 10 WHERE `mapid` = 1 and `npc_templateid` = 45060;
UPDATE `spawnlist` set `count` = 35 WHERE `mapid` = 1 and `npc_templateid` = 45065;
UPDATE `spawnlist` set `count` = 30 WHERE `mapid` = 1 and `npc_templateid` = 45157;
UPDATE `spawnlist` set `count` = 70 WHERE `mapid` = 1 and `npc_templateid` = 45107;
UPDATE `spawnlist` set `count` = 15 WHERE `mapid` = 1 and `npc_templateid` = 45068;
UPDATE `spawnlist` set `count` = 4 WHERE `mapid` = 1 and `npc_templateid` = 45100;
UPDATE `spawnlist` set `count` = 6 WHERE `mapid` = 1 and `npc_templateid` = 45215;
UPDATE `spawnlist` set `count` = 5 WHERE `mapid` = 2 and `npc_templateid` = 45060;
UPDATE `spawnlist` set `count` = 10 WHERE `mapid` = 2 and `npc_templateid` = 45065;
UPDATE `spawnlist` set `count` = 10 WHERE `mapid` = 2 and `npc_templateid` = 45024;
UPDATE `spawnlist` set `count` = 10 WHERE `mapid` = 2 and `npc_templateid` = 45068;
UPDATE `spawnlist` set `count` = 20 WHERE `mapid` = 2 and `npc_templateid` = 45107;
UPDATE `spawnlist` set `count` = 20 WHERE `mapid` = 2 and `npc_templateid` = 45122;
UPDATE `spawnlist` set `count` = 20 WHERE `mapid` = 2 and `npc_templateid` = 45131;
UPDATE `spawnlist` set `count` = 20 WHERE `mapid` = 2 and `npc_templateid` = 45130;
UPDATE `spawnlist` set `count` = 10 WHERE `mapid` = 2 and `npc_templateid` = 45126;
UPDATE `spawnlist` set `count` = 20 WHERE `mapid` = 2 and `npc_templateid` = 45136;
UPDATE `spawnlist` set `count` = 20 WHERE `mapid` = 2 and `npc_templateid` = 45161;
UPDATE `spawnlist` set `count` = 20 WHERE `mapid` = 2 and `npc_templateid` = 45157;
UPDATE `spawnlist` set `count` = 10 WHERE `mapid` = 2 and `npc_templateid` = 45173;
UPDATE `spawnlist` set `count` = 10 WHERE `mapid` = 2 and `npc_templateid` = 45184;

-- Fix intervals for some morphs triggering speedhack detection
UPDATE `spr_action` SET `framecount` = 17 WHERE `spr_id` = 6137;

-- Fix Orc Emissary sometimes spawning inside wall in Heine 3F
UPDATE `spawnlist_npc` SET `randomx` = 0, `randomy` = 0 WHERE `npc_templateid` = 81245 AND `mapid` = 61;

-- Proactively fix potential shop exploit.
update shop set selling_price = 1000 where npc_id = 81243 and item_id = 49103;
update shop set selling_price = 1000 where npc_id = 81243 and item_id = 49104;
update shop set selling_price = 4500 where npc_id = 81243 and item_id = 49108;
update shop set selling_price = 4500 where npc_id = 81243 and item_id = 49109;

-- Fix Heine3f Poison Serpent quest boss HPR and MPR, such that it can be
-- soloed by high level players.
update npc set hpr = 100, mpr = 100 where npcid = 45942;

-- Fix FI lizardman sprite.
update npc set gfxid = 1173 where npcid = 45377;

-- Fix Shield of Medusa stats.
update armor set m_def = 30, regist_stone = 5 where item_id = 20227;

-- Slightly increase dark headband droprate from rare drop mops.
update droplist set chance = 2000 where itemid = 20032 and chance = 1000;

-- Rebalance TOI 2F spawn.
update spawnlist set count = 55 where id = 10200001;
update spawnlist set count = 55 where id = 10200002;
update spawnlist set count = 35 where id = 10200003;
update spawnlist set count = 15 where id = 10200004;
-- Rebalance TOI 3F spawn.
update spawnlist set count = 75 where id = 10300001;
update spawnlist set count = 38 where id = 10300002;
update spawnlist set count = 30 where id = 10300003;
-- Rebalance TOI 4F spawn.
update spawnlist set count = 55 where id = 10400001;
update spawnlist set count = 25 where id = 10400002;
update spawnlist set count = 40 where id = 10400003;

-- Rebalance skeleton droprates.
-- Helmet
update droplist set chance = 30000 where mobid = 45107 and itemid = 20043;
-- N-COMR
update droplist set chance = 9000 where mobid = 45107 and itemid = 20056;
-- Large Shield
update droplist set chance = 9000 where mobid = 45107 and itemid = 20242;
-- C-Helmet
update droplist set chance = 30000 where mobid = 45107 and itemid = 220043;
-- C-COMR
update droplist set chance = 40000 where mobid = 45107 and itemid = 220056;
-- Pine
update droplist set chance = 5000 where mobid = 45107 and itemid = 40006;
-- G-haste
update droplist set chance = 25000 where mobid = 45107 and itemid = 40018;
-- SB:Dex
update droplist set chance = 8000 where mobid = 45107 and itemid = 40171;
-- Skeleton Skull
update droplist set chance = 25000 where mobid = 45107 and itemid = 40605;
-- Scimitar
update droplist set chance = 20000 where mobid = 45107 and itemid = 27;
-- b-Scimitar
update droplist set chance = 15000 where mobid = 45107 and itemid = 100027;

-- Rebalance Arachnevil droprates.
-- Pine
update droplist set chance = 8000 where mobid = 45136 and itemid = 40006;
-- Ebony
update droplist set chance = 20000 where mobid = 45136 and itemid = 40007;
-- G-haste
update droplist set chance = 30000 where mobid = 45136 and itemid = 40018;
-- SB:Slow
update droplist set chance = 12000 where mobid = 45136 and itemid = 40174;
-- SB:Erupt
update droplist set chance = 9000 where mobid = 45136 and itemid = 40190;

-- Rebalance Arachnevil Elder droprates.
-- Ebony
update droplist set chance = 30000 where mobid = 45184 and itemid = 40007;
-- G-haste
update droplist set chance = 40000 where mobid = 45184 and itemid = 40018;
-- SB:Dex
update droplist set chance = 25000 where mobid = 45184 and itemid = 40171;
-- SB:VT
update droplist set chance = 25000 where mobid = 45184 and itemid = 40173;
-- SB:Slow
update droplist set chance = 30000 where mobid = 45184 and itemid = 40174;
-- Claw
update droplist set chance = 35000 where mobid = 45184 and itemid = 40590;
-- Dragon Tablet(AwakenAntharas)
update droplist set chance = 8000 where mobid = 45184 and itemid = 49106;
-- B-tele
update droplist set chance = 55000 where mobid = 45184 and itemid = 140100;

-- Rebalance MLC 1F spawnrates.
-- Skeleton 80 -> 75
update spawnlist set count = 75 where id = 700005;
-- Skeleton Archer 40 -> 35
update spawnlist set count = 35 where id = 700006;

-- Rebalance MLC 2F spawnrates.
-- Ghoul 20 -> 10
update spawnlist set count = 10 where id = 800003;
-- Skeleton 40 -> 30
update spawnlist set count = 30 where id = 800004;
-- Skeleton Archer 40 -> 25
update spawnlist set count = 25 where id = 800005;
-- Arachnevil Elder 20 -> 12
update spawnlist set count = 12 where id = 800009;

-- Rebalance MLC 3F spawnrates.
-- Zombie 20 -> 18
update spawnlist set count = 18 where id = 900002;
-- Ghoul 15 -> 12
update spawnlist set count = 12 where id = 900003;
-- Skeleton 40 -> 35
update spawnlist set count = 35 where id = 900004;
-- Skeleton Archer 20 -> 17
update spawnlist set count = 17 where id = 900005;
-- Stone Golem 15 -> 10
update spawnlist set count = 10 where id = 900007;
-- Arachnevil Elder 30 -> 18
update spawnlist set count = 18 where id = 900008;
-- Bugbear 35 -> 25
update spawnlist set count = 25 where id = 900009;

-- Rebalance MLC 4F spawnrates.
-- Ghoul 20 -> 18
update spawnlist set count = 18 where id = 1000003;
-- Arachnevil Elder 15 -> 13
update spawnlist set count = 13 where id = 1000009;
-- Bugbear 35 -> 30
update spawnlist set count = 30 where id = 1000010;
-- Cerberus 20 -> 18
update spawnlist set count = 18 where id = 1000011;

-- Rebalance MLC 5F spawnrates.
-- Crawling Claw 5 -> 3
update spawnlist set count = 3 where id = 1200005;
-- Arachnevil Elder 15 -> 14
update spawnlist set count = 14 where id = 1200006;
-- King Bugbear 15 -> 12
update spawnlist set count = 12 where id = 1200009;

-- Reblanace Fire Egg droprates.
-- b-zel
update droplist set chance = 1500 where mobid = 45206 and itemid = 140074;
-- b-dai
update droplist set chance = 750 where mobid = 45206 and itemid = 140087;

-- Rebalance Horrific Fire Egg droprates.
-- SB:Sunburst
update droplist set chance = 7500 where mobid = 45384 and itemid = 40191;
-- SB:FW
update droplist set chance = 3500 where mobid = 45384 and itemid = 40203;

-- Rebalance Dragonfly droprates.
-- b-zel
update droplist set chance = 1500 where mobid = 45257 and itemid = 140074;
-- b-dai
update droplist set chance = 750 where mobid = 45257 and itemid = 140087;

-- Rebalance Horrific Cerebus droprates.
-- HQR
update droplist set chance = 50000 where mobid = 45471 and itemid = 40049;
-- SC:Additional Fire
update droplist set chance = 7500 where mobid = 45471 and itemid = 41150;

-- Rebalance Nightmare (TOI) droprates.
-- SB:Disease
update droplist set chance = 7500 where mobid = 45440 and itemid = 40201;

-- Rebalance Ifrit (TOI) droprates.
-- nzel
update droplist set chance = 65000 where mobid = 45515 and itemid = 40074;
-- Blank Scroll (Level 5)
update droplist set chance = 40000 where mobid = 45515 and itemid = 40094;
-- SB:FireStorm
update droplist set chance = 7500 where mobid = 45515 and itemid = 40215;
-- Dragon Tablet(MagmaBreath)
update droplist set chance = 5000 where mobid = 45515 and itemid = 49105;
-- b-zel
update droplist set chance = 3000 where mobid = 45515 and itemid = 140074;

-- Rebalance Lesser Demon droprates.
-- Blank Scroll (Level 5)
update droplist set chance = 40000 where mobid = 45481 and itemid = 40094;

-- Rebalance Lesser Dragon droprates.
-- Dragon Tablet(MagmaBreath)
update droplist set chance = 7500 where mobid = 45496 and itemid = 49105;
-- Dragon Tablet(AwakenAntharas)
update droplist set chance = 5000 where mobid = 45496 and itemid = 49106;

-- Rebalance Horrific Iron Golem droprates.
-- Memory Crystal(IllusionDiaGolem)
update droplist set chance = 7500 where mobid = 45479 and itemid = 49130;

-- Rebalance Bone Dragon droprates.
-- Blank Scroll (Level 5)
update droplist set chance = 40000 where mobid = 45522 and itemid = 40094;
-- Spirit Crystal(ElementalFallDown)
update droplist set chance = 5000 where mobid = 45522 and itemid = 40241;
-- Dragon Tablet(AwakenValakas)
update droplist set chance = 5000 where mobid = 45522 and itemid = 49116;

-- Giant Worm rebalance: Should be soloable by 70+ chars, killable by a group
-- of 2 if lower level.
-- Reduce Giant Worm regen.
update npc set hpr = 150, mpr = 150 where npcid = 45944;
-- Reduce Giant Worm AOE damage.
update mobskill set leverage = 30 where mobid = 45944 and actno = 1;

-- Rebalance TOI Cockatrice droprates.
-- Ebony Wand
update droplist set chance = 25000 where mobid = 81173 and itemid = 40007;
-- Spellbook(Eruption)
update droplist set chance = 7500 where mobid = 81173 and itemid = 40190;
-- Spellbook(GreaterHaste)
update droplist set chance = 7500 where mobid = 81173 and itemid = 40199;
-- Spellbook(Earthquake)
update droplist set chance = 7500 where mobid = 81173 and itemid = 40207;
-- Spirit Crystal(TripleShot)
update droplist set chance = 7500 where mobid = 81173 and itemid = 40240;
-- Spirit Crystal(Entangle)
update droplist set chance = 7500 where mobid = 81173 and itemid = 40248;
-- Lump of Rough Iron
update droplist set chance = 75000 where mobid = 81173 and itemid = 40899;

-- Fix Devil's Blood name.
update etcitem set name = 'Devil\'s Blood' where item_id = 40031;

-- Rebalance TOI 20F spawn and fix group_ids.
-- Dancing Sword 25 -> (6 * 3)
update spawnlist set count = 6, group_id = 30 where id = 12000001;
-- Wicked Beholder 50 -> (12 * 3)
update spawnlist set count = 12, group_id = 29 where id = 12000002;
-- Dire Wolf 100 -> (12 * 3)
update spawnlist set count = 15, group_id = 28 where id = 12000003;
-- Dire Wolf 20 -> 35
update spawnlist set count = 35 where id = 12000005;

-- Rebalance TOI 19F spawn and fix group_ids.
-- Dancing Sword 22 -> 15
update spawnlist set count = 15 where id = 11900001;
-- Wicked Beholder
update spawnlist set group_id = 0 where id = 11900002;
-- Dire Wolf 80 -> 65
update spawnlist set count = 65 where id = 11900003;

-- Rebalance TOI 18F spawn and fix group_ids.
-- Dancing Sword 20 -> 12
update spawnlist set count = 12 where id = 11800001;
-- Wicked Beholder
update spawnlist set group_id = 0 where id = 11800002;
--  Dire Wolf 80 -> 60
update spawnlist set count = 60 where id = 11800003;

-- Rebalance TOI 17F spawn and fix group_ids.
-- Dancing Sword 19 -> 10
update spawnlist set count = 10 where id = 11700001;
-- Wicked Beholder
update spawnlist set group_id = 0 where id = 11700002;
-- Dire Wolf 76 -> 55
update spawnlist set count = 55 where id = 11700003;

-- Correct Necromancer spawn cycle.
update spawnlist_boss set cycle_type='Caspa' where id = 10;

-- Correct Zenith Queen light_size.
update npc set light_size = 3 where npcid = 45513;

-- Correct Seer light_size.
update npc set light_size = 3 where npcid = 45547;

-- Correct TOI Vampire light_size.
update npc set light_size = 3 where npcid = 45606;

-- Correct Zombie Lord light_size.
update npc set light_size = 3 where npcid = 45650;

-- Correct Cougar light_size.
update npc set light_size = 3 where npcid = 45652;

-- Correct Mummy Lord light_size.
update npc set light_size = 3 where npcid = 45653;

-- Correct Knight Vlad light_size.
update npc set light_size = 3 where npcid = 45618;

-- Correct Grim Reaper light_size.
update npc set light_size = 8 where npcid = 45673;

-- Update beginner equipment.
delete from beginner where id = 2;
insert into beginner values (2, 4, 1, 0, 'Dagger', 'P', 0, 0);
insert into beginner values (11, 4, 1, 0, 'Dagger', 'K', 0, 0);
insert into beginner values (12, 4, 1, 0, 'Dagger', 'E', 0, 0);
insert into beginner values (13, 4, 1, 0, 'Dagger', 'W', 0, 0);
insert into beginner values (14, 4, 1, 0, 'Dagger', 'D', 0, 0);
insert into beginner values (15, 138, 1, 0, 'Club', 'R', 0, 0);
insert into beginner values (16, 138, 1, 0, 'Club', 'I', 0, 0);
insert into beginner values (17, 20322, 1, 0, 'Leather Jacket', 'R', 0, 0);
insert into beginner values (18, 20322, 1, 0, 'Leather Jacket', 'I', 0, 0);

-- Fix broken stairs on DVC2F.
insert into dungeon values (32727, 32809, 31, "Dragon Valley Caves 2F", 32709, 32818, 32, "Dragon Valley Caves 3F", 4);

-- Fix Ifrit naming in droplist, was erroneously labeled Basilisk
update droplist set mob_name = 'Ifrit' where mobId = 45516;

-- Fix wolf range
update npc set ranged = 2 where npcid = 45043;

-- Gelatinous cube is not supposed to poison
update npc set poison_atk = 0 where npcid = 45296;

-- Reduce npcchat spam on mobs that repeatedly chat (caspa group, dark elder, etc)
update npcchat set repeat_interval = 120000 where npc_id in (45473, 45488, 45497, 45464);
update npcchat set repeat_interval = 60000 where npc_id in (45545, 81175);

-- Spartois are supposed to slowly regen hp while hidden
update npc set hpr = 5 where npcid in (45161, 45181);
update npc set hpr = 15 where npcid = 45455;
update npc set hprinterval = 5000 where npcid in (45161, 45181, 45455);

-- Fix greater minotaur's attack interval for two handed blunt weapons
update spr_action set framecount = 13 where spr_id = 3102 and act_id = 12;

-- Add fungus juice to droplist for elven forest fungus
insert into droplist values ('45030', 'Fungus', '40499', 'Fungus Juice', '1', '1', '150000');

-- Fix Peddler Johan on Singing Island
update spawnlist_npc set locx = 32827, locy = 32723 where id = 60807;
update npc set nameid = '$1414' where npcid = 70004;
insert into shop values ('70004', 'Peddler Johan', '40010', 'Lesser Healing Potion', '0', '37', '0', '19');
insert into shop values ('70004', 'Peddler Johan', '40013', 'Haste Potion', '0', '200', '0', '100');

-- Move Serian (Talking Scroll NPC) near new starting location and other useful Singing Island NPCs
update spawnlist_npc set locx = 32817, locy = 32728 where id = 87546;

-- Add Serian (Talking Scroll NPC) spawn to Talking Island
insert into spawnlist_npc values ('87557', 'Serian', '1', '50112', '32600', '32916', '0', '0', '6', '0', '0', '0');

-- Add goblin spawns near the south exit of Singing Island town
insert into spawnlist values
	(801500719, 'Goblin', '10', '45008', '0', '0', '0', '0', '0', '32678', '32753', '32718', '32792', '0', '0', '0', '68', '0', '50', '0', '0', '1', '6', '2', '100');

-- Remove Zombie spawns from Singing Island
delete from spawnlist where npc_templateid = 45065 and mapid = 68;

-- Move Singing Island's teleport home location
update getback set getback_x1 = 32818, getback_y1 = 32734, getback_x2 = 32818, getback_y2 = 32734, getback_x3 = 32818, getback_y3 = 32734 where area_mapid = 68;

-- Fix Shield of Medusa stats.
update armor set m_def = 5, regist_stone = 30 where item_id = 20227;
