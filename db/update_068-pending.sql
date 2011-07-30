-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 68

-- remove duplicate spawns in oren market
DELETE FROM spawnlist WHERE mapid = 360;

-- drop the droprate of adena for Subterranean Elekkadoms
UPDATE droplist SET min = 500, max = 1000 WHERE mobId = 45487 AND itemId = 40308;
