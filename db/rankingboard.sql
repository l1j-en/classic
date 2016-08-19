# run this to add the ranking board to oren
INSERT INTO `npc` VALUES ('81150', 'Ranking Board', 'Ranking Board', '', 'L1Board', '2205', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0');
INSERT INTO `spawnlist_npc` VALUES ('1900021', 'Oren Ranking Board', '1', '81150', '34053', '32277', '0', '0', '6', '0', '4', '0');

ALTER TABLE character_pvp ADD killer_pledge VARCHAR(45) DEFAULT NULL;
ALTER TABLE character_pvp ADD victim_pledge VARCHAR(45) DEFAULT NULL;