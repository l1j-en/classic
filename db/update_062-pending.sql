-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 62

-- make chaos agro players
UPDATE npc SET agro=1, agrososc = 1, agrocoi = 1 where npcid = 45625;

-- minor adjustment on lasta ele room spawn counts
UPDATE spawnlist SET count = 8 WHERE mapid = 464 AND count = 10;
