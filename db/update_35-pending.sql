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