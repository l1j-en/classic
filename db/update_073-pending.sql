-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 73

-- reduce silence timer for sword of silence

UPDATE weapon_skill SET skill_time = 16 where weapon_id = 47;

-- Adjusting Titan Belt drops from giants.
-- Old rate judged to be too high and accidently dropped blessed belt.
DELETE FROM droplist WHERE item_name = "Titan Belt" and (mob_name = "Giant - Tan" or mob_name = "Giant - Light" or mob_name = "Giant - Dark");
INSERT INTO droplist VALUES(45337, "Giant - Tan", 20320, "Titan Belt", 1, 1, 80);
INSERT INTO droplist VALUES(45295, "Giant - Dark", 20320, "Titan Belt", 1, 1, 90);
INSERT INTO droplist VALUES(45318, "Giant - Light", 20320, "Titan Belt", 1, 1, 100);
INSERT INTO droplist VALUES(45351, "Giant - Light", 20320, "Titan Belt", 1, 1, 100);
