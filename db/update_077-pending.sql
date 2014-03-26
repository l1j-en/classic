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
update pets set mp=mp+2*(lvl-1) where npcid=45697;

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
--insert into polymorphs values
--(7332,'spearm 52',7332,52,1080,4095,1,7),
--(7338,'spearm 55',7338,55,1080,4095,1,7),
--(7339,'spearm 60',7339,60,1080,4095,1,7),
--(7340,'spearm 65',7340,65,1080,4095,1,7),
--(7341,'spearm 70',7341,70,1080,4095,1,7);
