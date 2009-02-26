-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here. This allows them 
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 42

-- correct bbs drop on desire cave lesser demon
update droplist set itemid = 40524, chance = 10000 where itemid = 40678 and mobid = 45736;
