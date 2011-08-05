-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 69

-- add Dwarf Adelio

INSERT INTO spawnlist_npc VALUES(NULL,'',1,71125,32579,32659,0,0,6,0,400,0);

-- make ebind two cell ranged

UPDATE skills SET ranged = 2 where skill_id = 157;
