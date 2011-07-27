-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 67

-- make Firey sword of death knight unbreakable
UPDATE weapon SET canbedmg = 0 WHERE item_id = 58;

-- make 30 DE quest mobs agro
UPDATE npc SET agro = 1, agrososc = 1, agrocoi = 1, atkspeed = 960, ranged = 1 WHERE npcid > 45882 and npcid < 45890;
