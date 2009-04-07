
-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here. This allows them 
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

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

