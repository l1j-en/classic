-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

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
REPLACE INTO commands VALUES ('ipcheck', '100', 'CheckIP');

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
UPDATE `etcitem` SET `name` = 'Teleport - Heine Dungeonn 3F' where item_id = '40807';
UPDATE `etcitem` SET `name` = 'Teleport - Heine Dungeonn 4F' where item_id = '40808';
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
