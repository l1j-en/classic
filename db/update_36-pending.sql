-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here
-- this allows them to be verified as working together before being
-- migrated to the DML scripts

-- update 36

-- Set all wand drops to 1. Was causing issues with certain bosses
UPDATE droplist SET min = 1, MAX = 1 WHERE itemid = 40006 OR itemid = 40007 OR itemid = 40008 OR itemid = 40009 OR itemid = 140006 OR itemid = 140008;

-- correct exhausted lizardman warrior spawn location
update spawnlist_npc set locx = 32790, locy = 32975, randomx = 0, randomy = 0 where npc_templateid = 71075;

-- Added npcaction to npc Shian in PI
insert into npcaction values (71050, 'shian', 'shian', '', '');
