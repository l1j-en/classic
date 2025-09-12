-- add hidden valley dungeon cursed ettin to enable tio quest
INSERT INTO `spawnlist` VALUES 
(44647, 'Cursed Ettin', '1', '45112', '0', '32929', '32735', '6', '6', '0', '0', '0', '0', '0', '60', '120', '86', '0', '0', '0', '0', '1', '0', '2', '100');

-- add black key drop to complete ruba quest
INSERT INTO `droplist` VALUES 
('45110', 'Lesser Succubus Queen', '40613', 'Black Key', '1', '1', '1000000'),
('45110', 'Lesser Succubus Queen', '40308', 'Adena', '40', '90', '1000000');

-- fix ruba quest empty text
UPDATE `npcaction` SET normal_action = 'ruba', caotic_action = 'ruba' WHERE npcid = 70506;