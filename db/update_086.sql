-- add hidden valley dungeon cursed ettin to enable tio quest
INSERT INTO `spawnlist` (`location`, `count`, `npc_templateid`, `group_id`, `locx`, `locy`, `randomx`, `randomy`, `locx1`, `locy1`, `locx2`, `locy2`, `heading`, `min_respawn_delay`, `max_respawn_delay`, `mapid`, `respawn_screen`, `movement_distance`, `rest`, `near_spawn`, `spawn_home`, `spawn_home_range`, `spawn_home_count`, `spawn_home_delay`) VALUES 
('Cursed Ettin', '1', '45112', '0', '32929', '32735', '6', '6', '0', '0', '0', '0', '0', '60', '120', '86', '0', '0', '0', '0', '1', '0', '2', '100');

-- add black key drop to complete ruba quest
INSERT INTO `droplist` VALUES 
('45110', 'Lesser Succubus Queen', '40613', 'Black Key', '1', '1', '1000000'),
('45110', 'Lesser Succubus Queen', '40308', 'Adena', '40', '90', '1000000');

-- fix ruba quest empty text
UPDATE `npcaction` SET normal_action = 'ruba', caotic_action = 'ruba' WHERE npcid = 70506;

-- enable arena guard in singing island
INSERT INTO `spawnlist_npc` (`location`, `count`, `npc_templateid`, `locx`, `locy`, `randomx`, `randomy`, `heading`, `respawn_delay`, `mapid`, `movement_distance`) VALUES 
('Arena Guide', '1', '550013', '32841', '32786', '0', '0', '6', '0', '68', '0');
INSERT INTO `npc` VALUES 
('550013', 'Arena Guide', '$1500', '', 'L1Teleporter', '148', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '14', '0', '0', '0');
INSERT INTO `npcaction` VALUES 
('550013', 'agsiin', 'agsiin', 'agin', '');