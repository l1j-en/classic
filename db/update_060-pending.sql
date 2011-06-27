-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 60

-- Change AS back to 1200 sec.
update skills set buffDuration = 1200 where skill_id = 79;
-- De-aggro Minotaur (axe).
update npc set agro = 0, agrososc = 0, agrocoi = 0 where npcid = 45390;
