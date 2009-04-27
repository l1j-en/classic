-- update 45

-- Name fix
update npc set name = "Ghost Soldier Full of Resentment" where npcid = 45913 OR npcid = 45912;

-- Adjust dark elf apprentice mobskill leverage to be slightly less than dark elf wizard.
update mobskill set leverage = 4 where mobid = 45256 and actno = 0;
update mobskill set leverage = 8 where mobid = 45256 and actno = 1;

-- Adjust trirange on dark elf apprentice CoC to be like dark elf wizard
update mobskill set trirange = -6 where mobid = 45256 and actno = 0;

-- Adjust cast freq on dark elf apprentice to be like dark elf wizard
update mobskill set trirnd = 40 where mobid = 45256 and actno = 0;
update mobskill set trirnd = 30 where mobid = 45256 and actno = 1;

-- Increase dark elf wizard CoC leverage (was 4).
update mobskill set leverage = 5 where mobid = 45447 and actno = 0;

-- Slight increase in bear meat droprate from dire bear (was 50000)
update droplist set chance = 75000 where mobid = 45252 and itemid = 41275;

-- Modify some phoenix droprates
update droplist set chance = 15000 where itemid = 20281 and mobid = 45617;
update droplist set chance = 25000 where itemid = 20304 and mobid = 45617;

-- Modify some TQD droprates
update droplist set chance = 12000 where itemid = 40052 and mobid = 45464;
update droplist set chance = 7500 where itemid = 40052 and mobid = 45522;
update droplist set chance = 18000 where itemid = 40052 and mobid = 45529;
update droplist set chance = 7000 where itemid = 40052 and mobid = 45530;
update droplist set chance = 8000 where itemid = 40052 and mobid = 45537;
update droplist set chance = 30000 where itemid = 40052 and mobid = 45583;

-- Modify some int ammy droprates
update droplist set chance = 12000 where itemid = 20266 and mobid = 45609;
update droplist set chance = 550 where itemid = 20266 and mobid = 45481;
update droplist set chance = 17500 where itemid = 20266 and mobid = 45649;

-- ROTC droprate modifications: increase from DK, decraese succ queen
update droplist set chance = 1500 where itemid = 20288 and mobid = 45601;
update droplist set chance = 300 where itemid = 20288 and mobid = 45451;
update droplist set chance = 500 where itemid = 20288 and mobid = 45450;

-- Modify titan belt droprates
update droplist set chance = 4500 where itemid = 20320 and mobid = 45610;
update droplist set chance = 15000 where itemid = 20320 and mobid = 45316;

-- Slight reduction in Giran AG HP regen (was 1500)
update npc set hpr = 1200 where npcid = 45316;

-- Modify TOI scroll droprates
-- 11F
update droplist set chance = 10500 where itemid = 40104 and mobid in (45332, 45348, 45380, 45407);
-- 21F
update droplist set chance = 10500 where itemid = 40105 and mobid in (45386, 45394, 45399, 45406, 45409);
-- 31F
update droplist set chance = 10500 where itemid = 40106 and mobid in (45384, 45440, 45471);
-- 41F
update droplist set chance = 10500 where itemid = 40107 and mobid in (45402, 45403, 45454, 45455, 45493, 45494);
-- 51F
update droplist set chance = 12500 where itemid = 40108 and mobid in (45480, 45522);

-- Modify spellbook droprates
-- sb:i2h
update droplist set chance = 100 where itemid = 40213 and mobid in (45221, 45241, 45244);
update droplist set chance = 75 where itemid = 40213 and mobid = 45283;
update droplist set chance = 500 where itemid = 40213 and mobid = 45379;
update droplist set chance = 700 where itemid = 40213 and mobid = 45241;
update droplist set chance = 1000 where itemid = 40213 and mobid = 45935;
-- sb:blizz
update droplist set chance = 2500 where itemid = 40204 and mobid in (45279, 45393, 45394);
-- sb:silence
update droplist set chance = 3000 where itemid = 40209 and mobid = 45327;
update droplist set chance = 3500 where itemid = 40209 and mobid = 45420;
update droplist set chance = 35000 where itemid = 40209 and mobid in (45610, 45650);
update droplist set chance = 3000 where itemid = 40209 and mobid = 45901;
-- sb:decay
update droplist set chance = 300 where itemid = 40216 and mobid in (45272, 45416, 45418, 45501, 45502);
-- sb:ms
update droplist set chance = 4500 where itemid = 40219 and mobid = 45617;
update droplist set chance = 400 where itemid = 40219 and mobid in (45972, 45973, 46047);
-- sb:destroy
update droplist set chance = 2500 where itemid = 40222 and mobid = 45801;
-- sb:ab
update droplist set chance = 50 where itemid = 40223 and mobid = 45244;

-- Modify u-quiv droprates
update droplist set chance = 4500 where itemid = 40330 and mobid in (45217, 45247, 45274, 45330);
update droplist set chance = 7500 where itemid = 40330 and mobid = 45502;

-- Spread out lasta3f spawn.
update spawnlist set count = 1 where mapid = 309;

-- Replace lasta3f dark elementalist spawn with one that has mobskills
update spawnlist set npc_templateid = 45363 where mapid = 309 and npc_templateid = 45245;

-- Revert some GM commands to old names
-- .invisible -> .invis
update commands set name = 'invis' where name = 'invisible';
-- .visible -> .show
update commands set name = 'show' where name = 'visible';

-- Delete invalid items from droplist
delete from droplist where itemid in (41223, 41224, 41215, 41236, 41216, 41214, 41422);

-- Remove unknown shadow spawn from IT8
delete from spawnlist where npc_templateid = 46041;

-- Re-add .jail command
insert into commands values('jail', 200, 'L1Jail');

-- Revert more GM commands to old names
-- .death -> .kill
update commands set name = 'kill' where name = 'death';
-- .move -> .tele
update commands set name = 'tele' where name = 'move';

-- fix bloodstone drop rates
update droplist set chance = 50000 where itemid = 40718 and chance = 500000;

-- remove .topc command
delete from commands where name = 'topc';

-- fix aden message board nameid (in front of aden church)
update npc set nameid = '$1385' where npcid = 81201;
 
-- fix some op adena drop rates, oops
update droplist set min = 200,max = 800 where min = 50000;
 
-- this 'mob' is actually an unkillable flame, decoration.
delete from droplist where mobid = 81164;

-- restore our -bug related commands
insert into commands values
('resolve',200,'L1Resolve'),
('viewbug',200,'L1ViewBug'),
('gotobug',200,'L1GotoBug');

-- rebalance some rosc droprates
update droplist set chance = 500 where itemid = 20284 and mobid in (45464, 45473, 45488, 45497, 45573);
update droplist set chance = 250 where itemid = 20284 and mobid in (45580, 45522, 45480, 45456);
update droplist set chance = 150 where itemid = 20284 and mobid = 45496;
update droplist set chance = 3500 where itemid = 20284 and mobid in (45601, 45606, 45650);
update droplist set chance = 4000 where itemid = 20284 and mobid in (45618, 45652);

-- reduce the number of teleport traps in haunted house
update spawnlist_trap set count = 5 where id between 321 and 325;

-- remove drops from HV Caves Mop's
DELETE from droplist where mobID = 45026;
DELETE from droplist where mobID = 45028;
DELETE from droplist where mobID = 45052;
DELETE from droplist where mobID = 45057;
DELETE from droplist where mobID = 45072;
DELETE from droplist where mobID = 45074;
DELETE from droplist where mobID = 45076;
DELETE from droplist where mobID = 45085;
DELETE from droplist where mobID = 45086;
DELETE from droplist where mobID = 45075;
DELETE from droplist where mobID = 45112; 

-- Add Drops to HV Caves Mop's
-- Mutated Alligator
INSERT INTO droplist values
('45026', '40308', '15', '35', '1000000'),
('45026', '40013', '1', '1', '50000'),
('45026', '40010', '1', '1', '15000'),
('45026', '40101', '1', '1', '50000'),
('45026', '20403', '1', '1', '50000'),
('45026', '226', '1', '1', '50000'),
('45026', '225', '1', '1', '50000'),
('45026', '40082', '1', '1', '50000');

-- Polluted Orc Zombie
INSERT INTO droplist values
('45028', '40308', '10', '45', '1000000'),
('45028', '40017', '1', '1', '50000'),
('45028', '20385', '1', '1', '50000'),
('45028', '216', '1', '1', '15000'),
('45028', '20034', '1', '1', '15000'),
('45028', '20135', '1', '1', '15000'),
('45028', '20237', '1', '1', '15000'),
('45028', '40101', '1', '1', '15000'),
('45028', '20136', '1', '1', '25000'),
('45028', '40089', '1', '1', '25000');

-- Fatigued Ratman
INSERT INTO droplist values
('45052', '40308', '15', '45', '1000000'),
('45052', '40010', '1', '1', '15000'),
('45052', '40018', '1', '1', '25000'),
('45052', '20213', '1', '1', '15000'),
('45052', '96', '1', '1', '15000'),
('45052', '140100', '1', '1', '15000'),
('45052', '40013', '1', '1', '25000'),
('45052', '40017', '1', '1', '50000');

-- Mutated Lizard
INSERT INTO droplist values
('45057', '40308', '20', '65', '1000000'),
('45057', '40010', '1', '1', '50000'),
('45057', '20392', '1', '1', '50000'),
('45057', '40743', '1', '10', '50000'),
('45057', '40013', '1', '1', '15000'),
('45057', '20242', '1', '1', '15000'),
('45057', '20237', '1', '1', '15000'),
('45057', '40046', '1', '1', '15000'),
('45057', '40101', '1', '1', '15000'),
('45057', '40082', '1', '1', '15000'),
('45057', '40100', '1', '1', '15000'),
('45057', '40018', '1', '1', '25000'),
('45057', '20011', '1', '1', '25000'),
('45057', '25', '1', '1', '25000');

-- Sewer Vakuuk
INSERT INTO droplist values
('45072', '40308', '20', '65', '1000000'),
('45072', '40017', '1', '1', '50000'),
('45072', '40013', '1', '1', '15000'),
('45072', '40049', '1', '1', '15000'),
('45072', '40101', '1', '1', '15000'),
('45072', '40018', '1', '1', '25000'),
('45072', '20011', '1', '1', '25000');

-- Underground Ramia
INSERT INTO droplist values
('45074', '40308', '20', '65', '1000000'),
('45074', '40017', '1', '1', '50000'),
('45074', '40015', '1', '1', '15000'),
('45074', '40101', '1', '1', '15000'),
('45074', '40087', '1', '1', '25000');

-- Underground Ramia
INSERT INTO droplist values
('45076', '40308', '20', '65', '1000000'),
('45076', '40017', '1', '1', '50000'),
('45076', '40015', '1', '1', '15000'),
('45076', '40101', '1', '1', '15000'),
('45076', '40087', '1', '1', '25000');

-- Cursed Bugbear
INSERT INTO droplist values
('45085', '40308', '40', '90', '1000000'),
('45085', '40101', '1', '1', '50000'),
('45085', '20394', '1', '1', '50000'),
('45085', '143', '1', '1', '15000'),
('45085', '148', '1', '1', '25000'),
('45085', '40074', '1', '1', '25000'),
('45085', '40087', '1', '1', '25000'),
('45085', '20115', '1', '1', '25000');

-- Degenerated Beholder
INSERT INTO droplist values
('45086', '40308', '20', '65', '1000000'),
('45086', '40010', '1', '1', '50000'),
('45086', '40016', '1', '1', '50000'),
('45086', '40101', '1', '1', '50000'),
('45086', '40082', '1', '1', '50000'),
('45086', '40744', '1', '15', '50000'),
('45086', '40013', '1', '1', '15000'),
('45086', '40015', '1', '1', '15000'),
('45086', '40087', '1', '1', '25000'),
('45086', '240087', '1', '1', '25000'),
('45086', '40017', '1', '1', '50000');

-- Underground Crabman
INSERT INTO droplist values
('45075', '40308', '20', '65', '1000000'),
('45075', '40010', '1', '1', '15000'),
('45075', '40074', '1', '1', '15000'),
('45075', '40101', '1', '1', '15000'),
('45075', '40100', '1', '1', '15000'),
('45075', '226', '1', '1', '50000'),
('45075', '140100', '1', '1', '15000');

-- Cursed Ettin
INSERT INTO droplist values
('45112', '40308', '40', '90', '1000000'),
('45112', '40653', '1', '1', '1000000');

-- Fix for Issue 63 (Stationaries)
update etcitem set trade = 1 where item_id = 40310;

-- update dc_checkdropmops stored proc to order by chance
DELIMITER $$

DROP PROCEDURE IF EXISTS `dc_CheckDropMops` $$
CREATE PROCEDURE `dc_CheckDropMops`( IN ItemID INT )
BEGIN
  select
    n.name, n.npcid, d.chance
  from
    npc n, droplist d
  where n.npcid = d.mobid
    and d.itemid = ItemID
  order by d.chance desc;
END $$
DELIMITER ;
