-- update 28

-- max bound kurtz's movement_distance
update spawnlist_boss set movement_distance = 35 where npc_id = 45600;



-- update 30

-- merge spawnlist_boss table changes
delete from spawnlist_boss where id in (12, 13, 14, 15, 19, 20, 66, 67);
update spawnlist_boss set group_id = 15 where id = 10;
update spawnlist_boss set group_id = 14 where id in (17, 16);
update spawnlist_boss set group_id = 49 where id = 18;
update spawnlist_boss set count = 1, group_id = 17 where id in (26, 29);
update spawnlist_boss set group_id = 21 where id = 30;
update spawnlist_boss set group_id = 16 where id = 31;
update spawnlist_boss set group_id = 16 where id = 32;
update spawnlist_boss set group_id = 13 where id = 39;
update spawnlist_boss set group_id = 18 where id = 68;
INSERT INTO `spawnlist_boss` VALUES ('91', 'Jose', 'Oren', '1', '45548', '0', '32775', '32849', '0', '0', '32710', '32770', '32830', '32895', '5', '484', '0', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` VALUES ('92', 'Assassin Squad Leader Blaze', 'Unknown', '1', '45585', '0', '32785', '32837', '0', '0', '0', '0', '0', '0', '5', '495', '1', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` VALUES ('93', 'Palace General Kyte', 'Unknown', '1', '45574', '0', '32831', '32762', '0', '0', '0', '0', '0', '0', '5', '494', '1', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` VALUES ('94', 'Slave of Assassin King', 'Unknown', '1', '45648', '0', '32853', '32863', '0', '0', '0', '0', '0', '0', '5', '492', '1', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` VALUES ('95', 'Brigade Commander Dark Fencer', 'Unknown', '1', '45577', '0', '32783', '32837', '0', '0', '0', '0', '0', '0', '5', '452', '1', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` VALUES ('96', 'Dread King Baranka', 'Unknown', '1', '45844', '0', '32838', '32758', '0', '0', '0', '0', '0', '0', '5', '453', '1', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` VALUES ('97', 'Division Commander Sinclair', 'Unknown', '1', '45588', '0', '32745', '32823', '0', '0', '0', '0', '0', '0', '5', '456', '1', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` VALUES ('98', 'Evil Power Squad Leader Kybar', 'Unknown', '1', '45607', '0', '32758', '32823', '0', '0', '0', '0', '0', '0', '5', '455', '1', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` VALUES ('99', 'Temple Head Bounty', 'Unknown', '1', '45612', '0', '32770', '32829', '0', '0', '0', '0', '0', '0', '5', '466', '1', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` VALUES ('100', 'Evil Magic Squad Leader Carmiel', 'Unknown', '1', '45602', '0', '32842', '32821', '0', '0', '0', '0', '0', '0', '5', '461', '1', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` VALUES ('101', 'Dread Queen Laia', 'Unknown', '1', '45863', '0', '32805', '32839', '0', '0', '0', '0', '0', '0', '5', '462', '1', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` VALUES ('102', 'Mercenary Commander Mephaisto', 'Unknown', '1', '45608', '0', '32791', '32815', '0', '0', '0', '0', '0', '0', '5', '471', '1', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` VALUES ('103', 'Bright Magic Troup Leader Crepus', 'Unknown', '1', '45615', '0', '32922', '32846', '0', '0', '0', '0', '0', '0', '5', '473', '1', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` VALUES ('104', 'Bright Magic King Hellvine', 'Unknown', '1', '45676', '0', '32785', '32844', '0', '0', '0', '0', '0', '0', '5', '475', '1', '0', '0', '0', '100');



-- update 31

-- death knight
DELETE FROM `spawnlist_boss` WHERE mapid = "51"; 

INSERT INTO `spawnlist_boss` VALUES ('45', 'DeathKnight', 'DK', '1', '45614', '0', '32742', '32856', '12', '12', '0', '0', '0', '0', '4', '543', '1', '0', '0', '0', '100'); 
