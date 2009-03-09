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


