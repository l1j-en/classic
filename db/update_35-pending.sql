-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here
-- this allows them to be verified as working together before being
-- migrated to the DML scripts

-- update 35

-- quest lvl 45 knight correction
UPDATE npc SET impl='L1Quest',lvl='1',hp='1',passispeed='1280' WHERE npcid ='71092'; 
UPDATE npc SET impl='L1Quest',lvl='1',hp='1',passispeed='1280' WHERE npcid ='71093'; 
UPDATE npc SET impl='L1Quest',lvl='1',hp='1',passispeed='1440' WHERE npcid ='71094'; 

UPDATE npc SET gfxid='2714' WHERE npcid ='45302'; 
UPDATE spawnlist SET locx='34248',locy='33363' WHERE npc_templateid ='45302'; 

UPDATE npc SET gfxid='2724' WHERE npcid ='70715'; 
UPDATE spawnlist_npc SET heading='6' WHERE npc_templateid ='70715'; 

INSERT INTO `spawnlist` VALUES ('801500141', 'Scout', '1', '71092', '0', '34242', '33356', '10', '10', '0', '0', '0', '0', '0', '120', '300', '4', '0', '0', '0', '0'); 
INSERT INTO `spawnlist` VALUES ('801500142', 'Endia', '1', '71094', '0', '32928', '32276', '10', '10', '0', '0', '0', '0', '0', '120', '300', '4', '0', '0', '0', '0'); 

-- darkelf lvl 30 quest
UPDATE droplist SET chance='400000' WHERE itemId ='40596'; 

-- darkelf lvl 45 quest
UPDATE npcaction SET normal_action='assassin4',caotic_action='assassin4' WHERE npcid ='70824'; 

DELETE FROM dungeon WHERE src_x='32778' and src_y='32738' and src_mapid='21'; 
DELETE FROM dungeon WHERE src_x='32781' and src_y='32728' and src_mapid='21'; 

-- treasure box type set
UPDATE etcitem SET item_type='treasure_box' WHERE item_id ='40582'; 
INSERT INTO `etcitem` VALUES (40583, '', '$2654', 'questitem', 'normal', 'paper', 1000, 1322, 3375, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1),

-- missing npc spawns for Personal Assassin of Bludika
UPDATE npc SET impl='L1Merchant' WHERE npcid ='70896'; 

INSERT INTO `npcaction` VALUES ('70896', 'bluedum', 'bluedum', '', ''); 

INSERT INTO `spawnlist_npc` VALUES ('1310320', '', '1', '70896', '32729', '32788', '0', '0', '4', '0', '305', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310321', '', '1', '70896', '32733', '32788', '0', '0', '4', '0', '305', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310322', '', '1', '70896', '32734', '32794', '0', '0', '4', '0', '305', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310323', '', '1', '70896', '32737', '32794', '0', '0', '4', '0', '305', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310324', '', '1', '70896', '32740', '32794', '0', '0', '4', '0', '305', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310325', '', '1', '70896', '32734', '32801', '0', '0', '0', '0', '305', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310326', '', '1', '70896', '32737', '32801', '0', '0', '0', '0', '305', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310327', '', '1', '70896', '32740', '32801', '0', '0', '0', '0', '305', '0');

-- pagos room missing doors they need a timer too automatic close the doors and need the keys
-- id 4001 and 4002 need itemid 40653 to open 
-- id 4003 and 4004 need itemid 40613 to open 
-- then 10 seconds later closes
INSERT INTO `spawnlist_door` VALUES ('4001', 'Pago\'s Room', '93', '32742', '32805', '87', '1', '32741', '32805', '0', '0'); 
INSERT INTO `spawnlist_door` VALUES ('4002', 'Pago\'s Room', '93', '32742', '32809', '87', '1', '32741', '32809', '0', '0'); 
INSERT INTO `spawnlist_door` VALUES ('4003', 'Pago\'s Room', '92', '32729', '32793', '87', '0', '32730', '32794', '0', '0'); 
INSERT INTO `spawnlist_door` VALUES ('4004', 'Pago\'s Room', '92', '32725', '32793', '87', '0', '32726', '32794', '0', '0'); 
