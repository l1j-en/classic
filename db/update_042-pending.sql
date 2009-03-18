-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here. This allows them 
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 42

-- correct bbs drop on desire cave lesser demon
update droplist set itemid = 40524, chance = 10000 where itemid = 40678 and mobid = 45736;

-- change HV/SI return scrolls to appropriate destinations for US servers
update etcitem set locx = 32675, locy = 32861, mapid = 69 where item_id = 40101;
update etcitem set locx = 32816, locy = 32735, mapid = 68 where item_id = 40082;

-- increase croc drops
-- brave (was 50000)
update droplist set chance = 120000 where itemid = 40014 and mobid = 45338;
-- emerald (was 50000)
update droplist set chance = 120000 where itemid = 40047 and mobid = 45338;
-- sb:c-l (was 10000)
update droplist set chance = 35000 where itemid = 40179 and mobid = 45338;

-- increase alligator emerald droprate (was 50000)
update droplist set chance = 75000 where itemid = 40047 and mobid = 45101;

-- I dont think these should be markable - lasta - underground passage - upper PI - some PI dungeon areas
update mapids set markable = 0 where mapid in (490, 492, 494, 480, 496, 481, 482, 483, 484, 491, 493, 495);

-- Adjust earthbind
update skills set probability_value = 50,probability_dice = 30 where skill_id = 157;

-- Adjust entangle
update skills set probability_value = 50,probability_dice = 30 where skill_id = 152;

-- Adjust erase
update skills set probability_value = 50,probability_dice = 30 where skill_id = 153;

-- Adjust shockstun
update skills set probability_value = 50 where skill_id = 87;

-- rebalance bdai drops slightly
update droplist set chance = 4000 where mobid in (45341, 45420, 45497) and itemid = 140087;
update droplist set chance = 1500 where mobid = 45384 and itemid = 140087;
update droplist set chance = 5000 where mobid in (45473, 45488) and itemid = 140087;
update droplist set chance = 100000 where mobid = 45600 and itemid = 140087;

-- minor bb 45223 drop rebalance
update droplist set chance = 18000 where mobid = 45223 and itemid = 20115;
update droplist set chance = 18000 where mobid = 45223 and itemid = 40087;
update droplist set chance = 17000 where mobid = 45223 and itemid = 143;
update droplist set chance = 4500 where mobid = 45223 and itemid = 145;
update droplist set chance = 9000 where mobid = 45223 and itemid = 148;

-- adjust bb 45738 drops to match bb 45223
update droplist set chance = 18000 where mobid = 45223 and itemid = 20115;
update droplist set chance = 38000 where mobid = 45223 and itemid = 40074;
update droplist set chance = 18000 where mobid = 45223 and itemid = 40087;
update droplist set chance = 75000 where mobid = 45223 and itemid = 140100;
update droplist set chance = 17000 where mobid = 45223 and itemid = 143;
update droplist set chance = 4500 where mobid = 45223 and itemid = 145;
update droplist set chance = 9000 where mobid = 45223 and itemid = 148;

-- rebalance some ndai drops slightly
update droplist set chance = 3000 where mobid = 45173 and itemid = 40087;
update droplist set chance = 18000 where mobid = 45298 and itemid = 40087;
update droplist set chance = 22000 where mobid = 45321 and itemid = 40087;
update droplist set chance = 22000 where mobid = 45359 and itemid = 40087;

-- minor kbb drop rebalance
update droplist set chance = 15000 where mobid = 45298 and itemid = 20101;
update droplist set chance = 18000 where mobid = 45298 and itemid = 20115;
update droplist set chance = 15000 where mobid = 45298 and itemid = 143;

-- fix some shop prices
update shop set selling_price = 23000 where npc_id = 70058 and item_id = 20101;
update shop set selling_price = 150 where npc_id = 70095 and item_id = 20043;
