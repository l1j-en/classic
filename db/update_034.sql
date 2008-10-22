-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here
-- this allows them to be verified as working together before being
-- migrated to the DML scripts

-- update 34

-- drop some old event rows
delete from mobskill where mobid in (90002, 90003);
delete from npc where npcid in (90000, 90001, 90002, 90003);
delete from droplist where mobid in (90000, 90001, 90002, 90003);

