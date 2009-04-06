
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
