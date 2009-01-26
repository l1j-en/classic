-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here. This allows them 
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 40

-- Restored cockatrice eye laser attack
INSERT INTO `skills` VALUES ('12001', 'Cockatrice Laser Attack', '0', '0', '10', '0', '0', '0', '0', '0', 'attack', '3', '50', '5', '5', '0', '0', '0', '64', '0', '6', '0', '0', '0', '0', '19', '1054', '0', '0', '0');
update mobskill set skillid = 12001 where mobid = 45361 and actno = 0;
update skills set name = 'unknown' where  skill_id = 10091;
