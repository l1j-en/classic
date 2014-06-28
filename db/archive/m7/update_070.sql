
-- update 70

-- redo joyofpain
DELETE FROM skills WHERE skill_id = 218;
INSERT INTO `skills` VALUES ('218', 'JoyofPain', '28', '1', '40', '0', '0', '0', '0', '2', 'attack', '3', '0', '0', '0', '0', '0', '0', '64', '0', '3', '0', '0', '2', '$5952', '19', '6528', '0', '0', '0', '0');

-- add effect for bone break
INSERT INTO `npc` VALUES ('91208', 'bonebreak', '', '', 'L1Effect', '6552', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0');

-- fix arm breaker
update skills set probability_value = 50 where skill_id = 213;
