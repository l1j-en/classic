-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 73

-- reduce silence timer for sword of silence

UPDATE weapon_skill SET skill_time = 16 where weapon_id = 47;
