-- update 31

-- skill silence buffduration time fix
update skills set buffDuration = 30 where skill_id = 64;

-- the juice endel npc add heine fontain added
INSERT INTO `spawnlist_npc` VALUES ('1310144', 'Endel', '1', '71197', '33609', '33249', '0', '0', '0', '0', '4', '0'); 

-- juice endel npc
INSERT INTO `npc` VALUES ('71197', 'Endel', '$4886', 'L1Merchant', '1513', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'small', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0');

-- juice endel npc
INSERT INTO `npcaction` VALUES(71197, 'endel1', 'endel1', '', '');

-- shop update
delete from shop where npc_id in (70060, 40256, 5, 50, 0, -1);
delete from shop where npc_id in (70060, 40260, 6, 50, 0, -1);
delete from shop where npc_id in (70060, 40247, 7, 50, 0, -1);
delete from shop where npc_id in (70062, 40193, 5, 50, 0, -1);
delete from shop where npc_id in (70066, 40187, 4, 50, 0, -1);
delete from shop where npc_id in (70066, 40188, 5, 50, 0, -1);
delete from shop where npc_id in (70066, 40194, 6, 50, 0, -1);

-- shop update
INSERT INTO `shop` VALUES (70060, 40239, 5, 16500, 0, -1);
INSERT INTO `shop` VALUES (70060, 40256, 6, 16500, 0, -1);
INSERT INTO `shop` VALUES (70060, 40260, 7, 16500, 0, -1);
INSERT INTO `shop` VALUES (70060, 40247, 8, 16500, 0, -1);
INSERT INTO `shop` VALUES (70062, 40193, 5, 16500, 0, -1);
INSERT INTO `shop` VALUES (70066, 40187, 4, 16500, 0, -1);
INSERT INTO `shop` VALUES (70066, 40188, 5, 16500, 0, -1);
INSERT INTO `shop` VALUES (70066, 40194, 6, 29700, 0, -1);

INSERT INTO `spawnlist_npc` VALUES
(1310054, '', 1, 71167, 32865, 32895, 0, 0, 5, 0, 320, 0),  
(1310055, '', 1, 70917, 32857, 32923, 0, 0, 6, 0, 320, 0),  
(1310056, '', 1, 81113, 32874, 32911, 0, 0, 6, 0, 320, 0);

INSERT INTO `shop` VALUES
(70092, 41245, 1, 75, 10, -1), 
(70092, 40011, 2, 185, 0, -1),  
(70092, 40012, 3, 416, 0, -1),  
(70092, 40020, 4, 227, 0, -1),  
(70092, 40021, 5, 624, 0, -1),  
(70092, 40023, 6, 344, 0, -1),  
(70092, 40024, 7, 687, 0, -1),  
(70092, 40017, 8, 110, 0, -1),  
(70092, 40013, 9, 280, 0, -1),  
(70092, 40018, 10, 1800, 0, -1),  
(70092, 40014, 11, 880, 0, -1),  
(70092, 40016, 12, 660, 0, -1),  
(70092, 40126, 13, 55, 0, -1),  
(70092, 40100, 14, 77, 0, -1),  
(70092, 40079, 15, 130, 0, -1),  
(70092, 40124, 16, 130, 0, -1),  
(70092, 40119, 17, 110, 0, -1),  
(70092, 40089, 18, 1100, 0, -1),  
(70092, 40088, 19, 1430, 0, -1),  
(70092, 40074, 20, 34000, 0, -1),  
(70092, 40087, 21, 81000, 0, -1),  
(70092, 40310, 22, 38, 0, -1),  
(70092, 40311, 23, 1450, 0, -1),  
(70092, 40315, 24, 650, 0, -1),  
(70092, 41160, 25, 2600, 10, -1),  
(70092, 40317, 26, 170, 0, -1),  
(70092, 40056, 27, 2, 0, -1),  
(70092, 41260, 28, 330, 0, -1),  
(70093, 40011, 1, 168, 0, -1),  
(70093, 40012, 2, 378, 0, -1),  
(70093, 40020, 3, 300, 0, -1),  
(70093, 40021, 4, 900, 0, -1),  
(70093, 40023, 5, 375, 0, -1),  
(70093, 40024, 6, 990, 0, -1),  
(70093, 40017, 7, 70, 0, -1),  
(70093, 40013, 8, 200, 0, -1),  
(70093, 40018, 9, 1500, 0, -1),  
(70093, 40014, 10, 800, 0, -1),  
(70093, 40016, 11, 600, 0, -1),  
(70093, 40126, 12, 50, 0, -1),  
(70093, 40100, 13, 70, 0, 38),  
(70093, 40079, 14, 120, 0, 65),  
(70093, 40124, 15, 120, 0, -1),  
(70093, 40119, 16, 100, 0, 55),  
(70093, 40089, 17, 1000, 0, 550),  
(70093, 40088, 18, 1300, 0, -1),  
(70093, 40074, 19, 41000, 0, 17000),  
(70093, 40087, 20, 85000, 0, -1),  
(70093, 40310, 21, 35, 0, 19),  
(70093, 40311, 22, 1200, 0, -1),  
(70093, 40317, 23, 150, 0, -1),  
(70093, 40056, 23, 1, 0, -1),  
(70093, 41260, 24, 300, 0, -1),  
(70093, 40743, 25, 1, 10, -1),  
(70093, 40744, 26, 1, 5, -1),  
(70093, 40739, 27, 1, 2, -1),  
(70093, 40738, 28, 1, 0, -1),  
(70093, 40740, 29, 1, 0, -1),  
(70093, 193, 30, 11000, 0, 5500), 
(70093, 80, 31, 33000, 0, 16500),  
(70093, 161, 32, 44000, 0, 22000), 
(71196, 40743, 1, 1, 10, -1), 
(71196, 40744, 2, 1, 5, -1),  
(71196, 40739, 3, 1, 2, -1),  
(71196, 40738, 4, 1, 0, -1),  
(71196, 40740, 5, 2, 0, -1),  
(71196, 80, 6, 33000, 0, -1),  
(71196, 161, 7, 44000, 0, -1),  
(71196, 101, 8, 1000, 0, -1),  
(71196, 6, 9, 1000, 0, -1),  
(71196, 38, 10, 11000, 0, -1), 
(71196, 82, 11, 10000, 0, -1),  
(71196, 122, 12, 10000, 0, -1),  
(71196, 176, 13, 5000, 0, -1),  
(71196, 187, 14, 10000, 0, -1),  
(71196, 193, 15, 11000, 0, -1),  
(71196, 20105, 16, 5000, 0, -1),  
(71196, 20102, 17, 1500, 0, -1),  
(71196, 20104, 18, 2000, 0, -1),  
(71196, 20199, 19, 1500, 0, -1),  
(71196, 20224, 20, 1000, 0, -1);

INSERT INTO `spawnlist_npc` VALUES
(1310057, '', 0, 70092, 32986, 32861, 0, 0, 4, 0, 320, 0),
(1310058, '', 1, 70093, 32788, 32806, 0, 0, 4, 0, 310, 0),
(1310059, '', 1, 71196, 32806, 32890, 0, 0, 4, 0, 320, 0);

-- dummys
UPDATE npc SET gfxid="3447" WHERE npcid="60558"; 

UPDATE npcaction SET normal_action="sdummy1", caotic_action="sdummy1" WHERE npcid="60558"; 
UPDATE npcaction SET normal_action="sdummy1", caotic_action="sdummy1" WHERE npcid="60559"; 

-- skt mercs
INSERT INTO `spawnlist_npc` VALUES ('1310118', 'mercenaries', '1', '60559', '33101', '33359', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310119', 'mercenaries', '1', '60558', '33102', '33362', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310120', 'mercenaries', '1', '60558', '33102', '33363', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310121', 'mercenaries', '1', '60558', '33102', '33365', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310122', 'mercenaries', '1', '60558', '33102', '33366', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310123', 'mercenaries', '1', '60559', '33103', '33362', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310124', 'mercenaries', '1', '60559', '33103', '33363', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310125', 'mercenaries', '1', '60559', '33103', '33365', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310126', 'mercenaries', '1', '60559', '33103', '33366', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310127', 'mercenaries', '1', '60558', '33106', '33362', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310128', 'mercenaries', '1', '60558', '33106', '33363', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310129', 'mercenaries', '1', '60558', '33106', '33365', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310130', 'mercenaries', '1', '60558', '33106', '33366', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310131', 'mercenaries', '1', '60559', '33107', '33362', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310132', 'mercenaries', '1', '60559', '33107', '33363', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310133', 'mercenaries', '1', '60559', '33107', '33365', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310134', 'mercenaries', '1', '60559', '33107', '33366', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310135', 'mercenaries', '1', '60559', '33097', '33369', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310136', 'mercenaries', '1', '60558', '33080', '33361', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310137', 'mercenaries', '1', '60559', '33080', '33368', '0', '0', '6', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310138', 'mercenaries', '1', '60558', '33120', '33353', '0', '0', '1', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310139', 'mercenaries', '1', '60559', '33122', '33353', '0', '0', '1', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310140', 'mercenaries', '1', '60558', '33110', '33400', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310141', 'mercenaries', '1', '60559', '33116', '33400', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310142', 'mercenaries', '1', '60559', '33068', '33422', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310143', 'mercenaries', '1', '60558', '33061', '33422', '0', '0', '4', '0', '4', '0');

-- shop update
UPDATE`shop`SET`selling_price`='16500' WHERE `npc_id` ='70066' and `item_id` = '40187'; 
UPDATE`shop`SET`selling_price`='16500' WHERE `npc_id` ='70066' and `item_id` = '40188'; 
UPDATE`shop`SET`selling_price`='29700' WHERE `npc_id` ='70066' and `item_id` = '40194'; 
UPDATE`shop`SET`selling_price`='16500' WHERE `npc_id` ='70062' and `item_id` = '40193'; 
DELETE FROM shop WHERE npc_id = "70060"; 

INSERT INTO `shop` VALUES ('70060', '40232', '0', '3300', '0', '-1'); 
INSERT INTO `shop` VALUES ('70060', '40233', '1', '3300', '0', '-1'); 
INSERT INTO `shop` VALUES ('70060', '40234', '2', '3300', '0', '-1'); 
INSERT INTO `shop` VALUES ('70060', '40235', '3', '8250', '0', '-1'); 
INSERT INTO `shop` VALUES ('70060', '40236', '4', '8250', '0', '-1'); 
INSERT INTO `shop` VALUES ('70060', '40239', '5', '16500', '0', '-1'); 
INSERT INTO `shop` VALUES ('70060', '40256', '6', '16500', '0', '-1'); 
INSERT INTO `shop` VALUES ('70060', '40260', '7', '16500', '0', '-1'); 
INSERT INTO `shop` VALUES ('70060', '40247', '8', '16500', '0', '-1');

-- scarecrows for silent cavern
INSERT INTO `spawnlist_npc` VALUES ('1310109', 'Silent Cavern scarecrow', '1', '45004', '32789', '32821', '0', '0', '1', '0', '304', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310110', 'Silent Cavern scarecrow', '1', '45004', '32792', '32821', '0', '0', '1', '0', '304', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310111', 'Silent Cavern scarecrow', '1', '45004', '32795', '32821', '0', '0', '1', '0', '304', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310112', 'Silent Cavern scarecrow', '1', '45004', '32798', '32821', '0', '0', '1', '0', '304', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310113', 'Silent Cavern scarecrow', '1', '45004', '32790', '32810', '0', '0', '1', '0', '304', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310114', 'Silent Cavern scarecrow', '1', '45004', '32793', '32810', '0', '0', '1', '0', '304', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310115', 'Silent Cavern scarecrow', '1', '45004', '32796', '32810', '0', '0', '1', '0', '304', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310116', 'Silent Cavern scarecrow', '1', '45004', '32799', '32810', '0', '0', '1', '0', '304', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310117', 'Silent Cavern scarecrow', '1', '45004', '32802', '32810', '0', '0', '1', '0', '304', '0');

-- scarecrows for skt
INSERT INTO `spawnlist_npc` VALUES ('1310060', 'Sktscarecrow', '1', '45001', '33130', '33316', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310061', 'Sktscarecrow', '1', '45001', '33134', '33316', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310062', 'Sktscarecrow', '1', '45001', '33138', '33316', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310063', 'Sktscarecrow', '1', '45001', '33142', '33316', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310064', 'Sktscarecrow', '1', '45002', '33130', '33320', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310065', 'Sktscarecrow', '1', '45002', '33134', '33320', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310066', 'Sktscarecrow', '1', '45002', '33138', '33320', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310067', 'Sktscarecrow', '1', '45002', '33142', '33320', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310068', 'Sktscarecrow', '1', '45001', '33130', '33324', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310069', 'Sktscarecrow', '1', '45001', '33134', '33324', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310070', 'Sktscarecrow', '1', '45001', '33138', '33324', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310071', 'Sktscarecrow', '1', '45001', '33142', '33324', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310072', 'Sktscarecrow', '1', '45002', '33130', '33328', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310073', 'Sktscarecrow', '1', '45002', '33134', '33328', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310074', 'Sktscarecrow', '1', '45002', '33138', '33328', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310075', 'Sktscarecrow', '1', '45002', '33142', '33328', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310076', 'Sktscarecrow', '1', '45001', '33102', '33314', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310077', 'Sktscarecrow', '1', '45002', '33102', '33318', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310078', 'Sktscarecrow', '1', '45001', '33102', '33322', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310079', 'Sktscarecrow', '1', '45002', '33102', '33326', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310080', 'Sktscarecrow', '1', '45001', '33106', '33318', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310081', 'Sktscarecrow', '1', '45002', '33106', '33322', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310082', 'Sktscarecrow', '1', '45001', '33106', '33326', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310083', 'Sktscarecrow', '1', '45002', '33110', '33318', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310084', 'Sktscarecrow', '1', '45001', '33110', '33322', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310085', 'Sktscarecrow', '1', '45002', '33114', '33314', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310086', 'Sktscarecrow', '1', '45001', '33114', '33318', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310087', 'Sktscarecrow', '1', '45002', '33114', '33322', '0', '0', '4', '0', '4', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310088', 'Sktscarecrow', '1', '45003', '32730', '32814', '0', '0', '4', '0', '69', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310089', 'Sktscarecrow', '1', '45003', '32736', '32814', '0', '0', '4', '0', '69', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310090', 'Sktscarecrow', '1', '45003', '32742', '32814', '0', '0', '4', '0', '69', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310091', 'Sktscarecrow', '1', '45003', '32748', '32814', '0', '0', '4', '0', '69', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310092', 'Sktscarecrow', '1', '45003', '32748', '32808', '0', '0', '4', '0', '69', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310093', 'Sktscarecrow', '1', '45003', '32742', '32808', '0', '0', '4', '0', '69', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310094', 'Sktscarecrow', '1', '45003', '32736', '32808', '0', '0', '4', '0', '69', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310095', 'Sktscarecrow', '1', '45003', '32730', '32808', '0', '0', '4', '0', '69', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310096', 'Sktscarecrow', '1', '45003', '32730', '32802', '0', '0', '4', '0', '69', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310097', 'Sktscarecrow', '1', '45003', '32736', '32802', '0', '0', '4', '0', '69', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310098', 'Sktscarecrow', '1', '45003', '32742', '32802', '0', '0', '4', '0', '69', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310099', 'Sktscarecrow', '1', '45003', '32748', '32802', '0', '0', '4', '0', '69', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310100', 'Sktscarecrow', '1', '45003', '32684', '32789', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310101', 'Sktscarecrow', '1', '45003', '32690', '32789', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310102', 'Sktscarecrow', '1', '45003', '32696', '32789', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310103', 'Sktscarecrow', '1', '45003', '32702', '32789', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310104', 'Sktscarecrow', '1', '45003', '32702', '32783', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310105', 'Sktscarecrow', '1', '45003', '32702', '32777', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310106', 'Sktscarecrow', '1', '45003', '32702', '32771', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310107', 'Sktscarecrow', '1', '45003', '32696', '32771', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310108', 'Sktscarecrow', '1', '45003', '32696', '32777', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310145', 'Sktscarecrow', '1', '45003', '32696', '32783', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310146', 'Sktscarecrow', '1', '45003', '32690', '32783', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310147', 'Sktscarecrow', '1', '45003', '32690', '32777', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310148', 'Sktscarecrow', '1', '45003', '32690', '32771', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310149', 'Sktscarecrow', '1', '45003', '32684', '32771', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310150', 'Sktscarecrow', '1', '45003', '32684', '32777', '0', '0', '4', '0', '68', '0'); 
INSERT INTO `spawnlist_npc` VALUES ('1310151', 'Sktscarecrow', '1', '45003', '32684', '32783', '0', '0', '4', '0', '68', '0');

DELETE FROM `mapids` WHERE mapid = "43"; 
DELETE FROM `mapids` WHERE mapid = "44"; 
DELETE FROM `mapids` WHERE mapid = "45"; 
DELETE FROM `mapids` WHERE mapid = "46"; 
DELETE FROM `mapids` WHERE mapid = "47"; 
DELETE FROM `mapids` WHERE mapid = "48"; 
DELETE FROM `mapids` WHERE mapid = "49"; 
DELETE FROM `mapids` WHERE mapid = "50"; 
DELETE FROM `mapids` WHERE mapid = "51"; 

INSERT INTO `mapids` VALUES ('43', 'Ant Caves 1F', '32704', '32831', '32704', '32831', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1'); 
INSERT INTO `mapids` VALUES ('44', 'Ant Caves 2F', '32704', '32831', '32704', '32831', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1'); 
INSERT INTO `mapids` VALUES ('45', 'Ant Caves 3F', '32704', '32831', '32704', '32831', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1'); 
INSERT INTO `mapids` VALUES ('46', 'Ant Caves 4F', '32704', '32831', '32704', '32831', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1'); 
INSERT INTO `mapids` VALUES ('47', 'Ant Caves 5F', '32704', '32831', '32704', '32831', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1'); 
INSERT INTO `mapids` VALUES ('48', 'Ant Caves 6F', '32704', '32831', '32704', '32831', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1'); 
INSERT INTO `mapids` VALUES ('49', 'Ant Caves 7F', '32704', '32831', '32704', '32831', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1'); 
INSERT INTO `mapids` VALUES ('50', 'Ant Caves 8F', '32704', '32831', '32704', '32831', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1'); 
INSERT INTO `mapids` VALUES ('51', 'Ant Caves 9F', '32640', '32831', '32704', '32895', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1'); 
INSERT INTO `mapids` VALUES ('541', 'ant A', '32704', '32767', '32768', '32895', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1'); 
INSERT INTO `mapids` VALUES ('542', 'ant B', '32704', '32767', '32768', '32895', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1'); 
INSERT INTO `mapids` VALUES ('543', 'Queen ant room', '32704', '32895', '32704', '32895', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1'); 

INSERT INTO `droplist` VALUES ('45946', '148', '1', '1', '40000'); 
INSERT INTO `droplist` VALUES ('45946', '20013', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45946', '20231', '1', '1', '40000'); 
INSERT INTO `droplist` VALUES ('45946', '40020', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45946', '40047', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45946', '40248', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45946', '40250', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45946', '40308', '50', '80', '1000000'); 
INSERT INTO `droplist` VALUES ('45946', '41274', '1', '1', '45000'); 
INSERT INTO `droplist` VALUES ('45947', '148', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45947', '20115', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45947', '20231', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45947', '40049', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45947', '40248', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45947', '40308', '55', '85', '1000000'); 
INSERT INTO `droplist` VALUES ('45947', '41274', '1', '1', '45000'); 
INSERT INTO `droplist` VALUES ('45948', '20015', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45948', '20149', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45948', '40020', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45948', '40047', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45948', '40049', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45948', '40308', '60', '90', '1000000'); 
INSERT INTO `droplist` VALUES ('45948', '41274', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45949', '20013', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45949', '20149', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45949', '20231', '1', '1', '40000'); 
INSERT INTO `droplist` VALUES ('45949', '40020', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45949', '40051', '1', '1', '30000'); 
INSERT INTO `droplist` VALUES ('45949', '40248', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45949', '40251', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45949', '40304', '1', '1', '30000'); 
INSERT INTO `droplist` VALUES ('45949', '40308', '65', '100', '1000000'); 
INSERT INTO `droplist` VALUES ('45949', '41274', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45950', '64', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45950', '20013', '1', '1', '30000'); 
INSERT INTO `droplist` VALUES ('45950', '20115', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45950', '40051', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45950', '40250', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45950', '40251', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45950', '40308', '75', '110', '1000000'); 
INSERT INTO `droplist` VALUES ('45950', '41274', '1', '1', '55000'); 
INSERT INTO `droplist` VALUES ('45951', '52', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45951', '64', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45951', '20013', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45951', '20115', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45951', '20149', '1', '1', '40000'); 
INSERT INTO `droplist` VALUES ('45951', '20231', '1', '1', '45000'); 
INSERT INTO `droplist` VALUES ('45951', '40020', '1', '1', '65000'); 
INSERT INTO `droplist` VALUES ('45951', '40049', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45951', '40051', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45951', '40248', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45951', '40250', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45951', '40304', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45951', '40308', '85', '115', '1000000'); 
INSERT INTO `droplist` VALUES ('45951', '41274', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45952', '44', '1', '1', '40000'); 
INSERT INTO `droplist` VALUES ('45952', '179', '1', '1', '40000'); 
INSERT INTO `droplist` VALUES ('45952', '20231', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45952', '40248', '1', '1', '30000'); 
INSERT INTO `droplist` VALUES ('45952', '40304', '1', '1', '70000'); 
INSERT INTO `droplist` VALUES ('45952', '40308', '100', '135', '1000000'); 
INSERT INTO `droplist` VALUES ('45952', '41274', '1', '1', '70000'); 

-- ant caves
DELETE FROM `dungeon` WHERE new_mapid = "43"; 
DELETE FROM `dungeon` WHERE new_mapid = "44"; 
DELETE FROM `dungeon` WHERE new_mapid = "45"; 
DELETE FROM `dungeon` WHERE new_mapid = "46"; 
DELETE FROM `dungeon` WHERE new_mapid = "47"; 
DELETE FROM `dungeon` WHERE new_mapid = "48"; 
DELETE FROM `dungeon` WHERE new_mapid = "49"; 
DELETE FROM `dungeon` WHERE new_mapid = "50"; 
DELETE FROM `dungeon` WHERE new_mapid = "51"; 

INSERT INTO `dungeon` VALUES ('32779', '32792', '47', '32807', '32805', '43', '0', 'Ant B1-5 -> B1-1'); 
INSERT INTO `dungeon` VALUES ('32743', '32778', '47', '32794', '32740', '48', '0', 'Ant B1-5 -> B2-1'); 
INSERT INTO `dungeon` VALUES ('32744', '32778', '47', '32794', '32740', '48', '0', 'Ant B1-5 -> B2-1'); 
INSERT INTO `dungeon` VALUES ('32740', '32756', '48', '32807', '32762', '50', '0', 'Ant B2-1 -> B1-6'); 
INSERT INTO `dungeon` VALUES ('32740', '32757', '48', '32807', '32762', '50', '0', 'Ant B2-1 -> B1-6'); 
INSERT INTO `dungeon` VALUES ('32755', '33208', '4', '32783', '32751', '43', '0', 'Sand desert -> Ant B1-1'); 
INSERT INTO `dungeon` VALUES ('32914', '33220', '4', '32798', '32754', '44', '0', 'Sand desert -> Ant B1-2'); 
INSERT INTO `dungeon` VALUES ('32789', '33255', '4', '32776', '32731', '45', '0', 'Sand desert -> Ant B1-3'); 
INSERT INTO `dungeon` VALUES ('32848', '33294', '4', '32787', '32795', '46', '0', 'Sand desert -> Ant B1-4'); 
INSERT INTO `dungeon` VALUES ('32839', '33172', '4', '32796', '32745', '47', '0', 'Sand desert -> Ant B1-5'); 
INSERT INTO `dungeon` VALUES ('32788', '33149', '4', '32768', '32805', '50', '0', 'Sand desert -> Ant B1-6'); 
INSERT INTO `dungeon` VALUES ('32807', '32806', '43', '32779', '32793', '47', '0', 'Ant B1-1 -> B1-5'); 
INSERT INTO `dungeon` VALUES ('32808', '32806', '43', '32779', '32793', '47', '0', 'Ant B1-1 -> B1-5'); 
INSERT INTO `dungeon` VALUES ('32737', '32781', '44', '32781', '32732', '49', '0', 'Ant B1-2 -> B2-2'); 
INSERT INTO `dungeon` VALUES ('32737', '32782', '44', '32781', '32732', '49', '0', 'Ant B1-2 -> B2-2'); 
INSERT INTO `dungeon` VALUES ('32769', '32791', '45', '32745', '32759', '50', '0', 'Ant B1-3 -> B1-6'); 
INSERT INTO `dungeon` VALUES ('32770', '32791', '45', '32745', '32759', '50', '0', 'Ant B1-3 -> B1-6'); 
INSERT INTO `dungeon` VALUES ('32790', '32796', '46', '32745', '32783', '49', '0', 'Ant B1-4 -> B2-2'); 
INSERT INTO `dungeon` VALUES ('32791', '32796', '46', '32745', '32783', '49', '0', 'Ant B1-4 -> B2-2'); 
INSERT INTO `dungeon` VALUES ('32778', '32792', '47', '32807', '32805', '43', '0', 'Ant B1-5 -> B1-1'); 
INSERT INTO `dungeon` VALUES ('32740', '32758', '48', '32807', '32762', '50', '0', 'Ant B2-1 -> B1-6'); 
INSERT INTO `dungeon` VALUES ('32794', '32739', '48', '32744', '32777', '47', '0', 'Ant B2-1 -> B1-5'); 
INSERT INTO `dungeon` VALUES ('32795', '32739', '48', '32744', '32777', '47', '0', 'Ant B2-1 -> B1-5'); 
INSERT INTO `dungeon` VALUES ('32778', '32801', '48', '32747', '32790', '541', '0', 'Ant B2-1 -> ant A'); 
INSERT INTO `dungeon` VALUES ('32778', '32802', '48', '32747', '32790', '541', '0', 'Ant B2-1 -> ant A'); 
INSERT INTO `dungeon` VALUES ('32782', '32731', '49', '32738', '32781', '44', '0', 'ant B2-2 -> B1-2'); 
INSERT INTO `dungeon` VALUES ('32782', '32732', '49', '32738', '32781', '44', '0', 'ant B2-2 -> B1-2'); 
INSERT INTO `dungeon` VALUES ('32782', '32733', '49', '32738', '32781', '44', '0', 'ant B2-2 -> B1-2'); 
INSERT INTO `dungeon` VALUES ('32745', '32782', '49', '32791', '32795', '46', '0', 'ant B2-2 -> B1-4'); 
INSERT INTO `dungeon` VALUES ('32746', '32782', '49', '32791', '32795', '46', '0', 'ant B2-2 -> B1-4'); 
INSERT INTO `dungeon` VALUES ('32779', '32778', '49', '32747', '32790', '542', '0', 'ant B2-2 -> ant B'); 
INSERT INTO `dungeon` VALUES ('32779', '32779', '49', '32747', '32790', '542', '0', 'ant B2-2 -> ant B'); 
INSERT INTO `dungeon` VALUES ('32745', '32758', '50', '32770', '32790', '45', '0', 'ant B1-6 -> B1-3'); 
INSERT INTO `dungeon` VALUES ('32746', '32758', '50', '32770', '32790', '45', '0', 'ant B1-6 -> B1-3'); 
INSERT INTO `dungeon` VALUES ('32806', '32763', '50', '32739', '32757', '48', '0', 'ant B1-6 -> B2-1'); 
INSERT INTO `dungeon` VALUES ('32807', '32763', '50', '32739', '32757', '48', '0', 'ant B1-6 -> B2-1'); 
INSERT INTO `dungeon` VALUES ('32724', '32743', '51', '32722', '32820', '541', '0', 'ant B3 -> ant A'); 
INSERT INTO `dungeon` VALUES ('32725', '32743', '51', '32722', '32820', '541', '0', 'ant B3 -> ant A'); 
INSERT INTO `dungeon` VALUES ('32726', '32743', '51', '32722', '32820', '541', '0', 'ant B3 -> ant A'); 
INSERT INTO `dungeon` VALUES ('32794', '32846', '51', '32723', '32822', '542', '0', 'ant B3 -> ant B'); 
INSERT INTO `dungeon` VALUES ('32794', '32847', '51', '32723', '32822', '542', '0', 'ant B3 -> ant B'); 
INSERT INTO `dungeon` VALUES ('32794', '32848', '51', '32723', '32822', '542', '0', 'ant B3 -> ant B'); 
INSERT INTO `dungeon` VALUES ('32679', '32848', '51', '32873', '32750', '543', '0', 'ant B3 -> B4'); 
INSERT INTO `dungeon` VALUES ('32679', '32849', '51', '32873', '32750', '543', '0', 'ant B3 -> B4'); 
INSERT INTO `dungeon` VALUES ('32679', '32850', '51', '32873', '32750', '543', '0', 'ant B3 -> B4'); 
INSERT INTO `dungeon` VALUES ('32748', '32789', '541', '32779', '32801', '48', '0', 'ant A -> B2-1'); 
INSERT INTO `dungeon` VALUES ('32748', '32790', '541', '32779', '32801', '48', '0', 'ant A -> B2-1'); 
INSERT INTO `dungeon` VALUES ('32748', '32791', '541', '32779', '32801', '48', '0', 'ant A -> B2-1'); 
INSERT INTO `dungeon` VALUES ('32721', '32821', '541', '32725', '32744', '51', '0', 'ant A -> B3'); 
INSERT INTO `dungeon` VALUES ('32722', '32821', '541', '32725', '32744', '51', '0', 'ant A -> B3'); 
INSERT INTO `dungeon` VALUES ('32748', '32789', '542', '32780', '32778', '49', '0', 'ant B -> B2-2'); 
INSERT INTO `dungeon` VALUES ('32748', '32790', '542', '32780', '32778', '49', '0', 'ant B -> B2-2'); 
INSERT INTO `dungeon` VALUES ('32748', '32791', '542', '32780', '32778', '49', '0', 'ant B -> B2-2'); 
INSERT INTO `dungeon` VALUES ('32721', '32823', '542', '32793', '32847', '51', '0', 'ant B -> B3'); 
INSERT INTO `dungeon` VALUES ('32722', '32823', '542', '32793', '32847', '51', '0', 'ant B -> B3'); 
INSERT INTO `dungeon` VALUES ('32874', '32749', '543', '32680', '32849', '51', '0', 'ant B4 -> B3'); 
INSERT INTO `dungeon` VALUES ('32874', '32750', '543', '32680', '32849', '51', '0', 'ant B4 -> B3'); 
INSERT INTO `dungeon` VALUES ('32874', '32751', '543', '32680', '32849', '51', '0', 'ant B4 -> B3'); 

INSERT INTO `mobskill` VALUES ('45952', '0', 'Giant guard ant', '2', '30', '0', '0', '-15', '0', '0', '0', '0', '0', '5', '10090', '0', '0', '0', '0', '0', '0'); 
INSERT INTO `mobskill` VALUES ('45952', '1', 'Giant guard ant', '1', '100', '0', '0', '-3', '0', '0', '3', '0', '0', '15', '0', '0', '30', '0', '0', '0', '0'); 

INSERT INTO `skills` VALUES 
('10090', 'Giant guard ant', '0', '0', '5', '0', '0', '0', '0', '0', 'none', '3', '100', '10', '10', '0', '0', '1', '64', '0', '0', '-1', '0', '0', '', '18', '1812', '0', '0', '0'); 

DELETE FROM `spawnlist` WHERE mapid = "43"; 
DELETE FROM `spawnlist` WHERE mapid = "44"; 
DELETE FROM `spawnlist` WHERE mapid = "45"; 
DELETE FROM `spawnlist` WHERE mapid = "46"; 
DELETE FROM `spawnlist` WHERE mapid = "47"; 
DELETE FROM `spawnlist` WHERE mapid = "48"; 
DELETE FROM `spawnlist` WHERE mapid = "49"; 
DELETE FROM `spawnlist` WHERE mapid = "50"; 
DELETE FROM `spawnlist` WHERE mapid = "51"; 



INSERT INTO `spawnlist` VALUES 

('801500114', 'ant', '35', '45945', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '45', '0', '0', '0', '0'),
('801500115', 'ant', '35', '45945', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '46', '0', '0', '0', '0'), 
('801500113', 'ant', '35', '45945', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '44', '0', '0', '0', '0'), 
('801500112', 'ant', '30', '45945', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '43', '0', '0', '0', '0'), 
('801500116', 'ant', '35', '45945', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '47', '0', '0', '0', '0'), 
('801500117', 'ant', '35', '45945', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '48', '0', '0', '0', '0'), 
('801500118', 'ant', '25', '45946', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('801500119', 'Giant ant', '15', '45947', '0', '32800', '32800', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'),
('801500120', 'Giant ant', '25', '45948', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('801500121', 'Giant ant', '15', '45950', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('801500122', 'Giant ant', '20', '45949', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('801500123', 'Giant ant', '10', '45951', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('801500124', 'Giant ant', '25', '45946', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('801500125', 'Giant ant', '15', '45947', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('801500126', 'Giant ant', '25', '45948', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('801500127', 'Giant ant', '15', '45949', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('801500128', 'Giant ant', '10', '45950', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('801500129', 'Giant ant', '10', '45951', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('801500130', 'Giant ant', '25', '45948', '0', '32764', '32828', '0', '0', '32640', '32704', '32831', '32895', '5', '0', '0', '51', '0', '0', '0', '0'), 
('801500131', 'Giant ant', '15', '45949', '0', '32764', '32828', '0', '0', '32640', '32704', '32831', '32895', '5', '0', '0', '51', '0', '0', '0', '0'), 
('801500132', 'Giant ant', '15', '45950', '0', '32764', '32828', '0', '0', '32640', '32704', '32831', '32895', '5', '0', '0', '51', '0', '0', '0', '0'), 
('801500133', 'ant soldier', '15', '45951', '0', '32764', '32828', '0', '0', '32640', '32704', '32831', '32895', '5', '0', '0', '51', '0', '0', '0', '0'), 
('801500134', 'ant soldier', '1', '45952', '0', '32738', '32854', '0', '0', '0', '0', '0', '0', '0', '240', '480', '541', '0', '0', '0', '0'), 
('801500135', 'ant soldier', '1', '45952', '0', '32738', '32854', '0', '0', '0', '0', '0', '0', '0', '240', '480', '542', '0', '0', '0', '0'), 
('801500136', 'ant soldier', '1', '45952', '0', '32771', '32856', '0', '0', '0', '0', '0', '0', '2', '240', '480', '543', '0', '0', '0', '0'), 
('801500137', 'ant soldier', '1', '45952', '0', '32747', '32776', '0', '0', '0', '0', '0', '0', '4', '240', '480', '543', '0', '0', '0', '0'), 
('801500138', 'ant soldier', '1', '45952', '0', '32768', '32739', '0', '0', '0', '0', '0', '0', '2', '240', '480', '543', '0', '0', '0', '0'), 
('801500139', 'ant soldier', '1', '45952', '0', '32858', '32798', '0', '0', '0', '0', '0', '0', '0', '240', '480', '543', '0', '0', '0', '0'), 
('801500140', 'ant soldier', '1', '45952', '0', '32848', '32855', '0', '0', '0', '0', '0', '0', '6', '240', '480', '543', '0', '0', '0', '0'), 
('4400001', 'Giant ant', '50', '45115', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '44', '0', '0', '0', '0'),
('4400002', 'Giant ant', '25', '45190', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '44', '0', '0', '0', '0'), 
('4500001', 'Giant ant', '50', '45115', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '45', '0', '0', '0', '0'), 
('4500002', 'Giant ant', '25', '45190', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '45', '0', '0', '0', '0'), 
('4600001', 'Giant ant', '50', '45115', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '46', '0', '0', '0', '0'), 
('4600002', 'Giant ant', '25', '45190', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '46', '0', '0', '0', '0'), 
('4700001', 'Giant ant', '50', '45115', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '47', '0', '0', '0', '0'), 
('4700002', 'Giant ant', '25', '45190', '0', '32800', '32800', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '47', '0', '0', '0', '0'), 
('4800001', 'Giant ant', '50', '45115', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '48', '0', '0', '0', '0'), 
('4800002', 'Giant ant', '25', '45190', '0', '32800', '32800', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '48', '0', '0', '0', '0'), 
('4900001', 'Giant ant', '50', '45115', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('4900002', 'Giant ant', '25', '45190', '0', '32800', '32800', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('5000001', 'Giant ant', '50', '45115', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('5000002', 'Giant ant', '25', '45190', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('5100001', 'Giant ant', '25', '45115', '0', '32764', '32828', '0', '0', '32640', '32704', '32831', '32895', '5', '0', '0', '51', '0', '0', '0', '0'), 
('5100002', 'Giant ant', '50', '45190', '0', '32764', '32828', '0', '0', '32640', '32704', '32831', '32895', '5', '0', '0', '51', '0', '0', '0', '0'); 

-- death knight
DELETE FROM `spawnlist_boss` WHERE mapid = "51"; 

INSERT INTO `spawnlist_boss` VALUES ('45', 'DeathKnight', 'DK', '1', '45614', '0', '32742', '32856', '12', '12', '0', '0', '0', '0', '4', '543', '1', '0', '0', '0', '100'); 

-- clan rank colum
alter table characters add column `ClanRank` int(3) unsigned NOT NULL default '0';

-- new cloaks dont know the names yet
INSERT INTO `armor` VALUES ('21057', ' ', '$5021', 'cloak', 'leather', '10000', '2551', '6128', '2600', '-1', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21058', '', '$5021', 'cloak', 'leather', '10000', '2552', '6127', '2600', '-2', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '5', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21059', '', '$5022', 'cloak', 'leather', '10000', '2562', '6126', '2601', '-4', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '10', '0', '3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0');

-- not used npcs anymore
DELETE FROM npc WHERE npcid = "45964"; 
DELETE FROM npc WHERE npcid = "45965"; 
DELETE FROM npc WHERE npcid = "45966"; 
DELETE FROM npc WHERE npcid = "45967"; 
DELETE FROM npc WHERE npcid = "45968";
DELETE FROM weapon WHERE item_id = "230";

-- weapon desc update
UPDATE weapon SET itemdesc_id="996" WHERE item_id="16"; 
UPDATE weapon SET itemdesc_id="659" WHERE item_id="17"; 
UPDATE weapon SET itemdesc_id="660" WHERE item_id="18"; 
UPDATE weapon SET itemdesc_id="276" WHERE item_id="22"; 
UPDATE weapon SET itemdesc_id="284" WHERE item_id="28" or item_id="100028"; 
UPDATE weapon SET itemdesc_id="235" WHERE item_id="37" or item_id="100037"; 
UPDATE weapon SET itemdesc_id="1497" WHERE item_id="43"; 
UPDATE weapon SET itemdesc_id="152" WHERE item_id="45"; 
UPDATE weapon SET itemdesc_id="787" WHERE item_id="56"; 
UPDATE weapon SET itemdesc_id="760" WHERE item_id="65"; 
UPDATE weapon SET itemdesc_id="1808" WHERE item_id="79"; 
UPDATE weapon SET itemdesc_id="1199" WHERE item_id="83"; 
UPDATE weapon SET itemdesc_id="994" WHERE item_id="87"; 
UPDATE weapon SET itemdesc_id="772" WHERE item_id="133"; 
UPDATE weapon SET itemdesc_id="995" WHERE item_id="135"; 
UPDATE weapon SET itemdesc_id="1704" WHERE item_id="150"; 
UPDATE weapon SET itemdesc_id="997" WHERE item_id="166"; 
UPDATE weapon SET itemdesc_id="661" WHERE item_id="167"; 
UPDATE weapon SET itemdesc_id="1200" WHERE item_id="186"; 
UPDATE weapon SET itemdesc_id="1705" WHERE item_id="191"; 
UPDATE weapon SET itemdesc_id="771" WHERE item_id="192"; 
UPDATE weapon SET itemdesc_id="286" WHERE item_id="208"; 
UPDATE weapon SET itemdesc_id="346" WHERE item_id="209"; 
UPDATE weapon SET itemdesc_id="347" WHERE item_id="215";

-- armor desc update
UPDATE armor SET itemdesc_id="1715" WHERE item_id="20031"; 
UPDATE armor SET itemdesc_id="1051" WHERE item_id="20037"; 
UPDATE armor SET itemdesc_id="975" WHERE item_id="20068"; 
UPDATE armor SET itemdesc_id="1718" WHERE item_id="20069"; 
UPDATE armor SET itemdesc_id="1381" WHERE item_id="20076"; 
UPDATE armor SET itemdesc_id="1717" WHERE item_id="20083"; 
UPDATE armor SET itemdesc_id="1716" WHERE item_id="20131"; 
UPDATE armor SET itemdesc_id="1748" WHERE item_id="20133"; 
UPDATE armor SET itemdesc_id="655" WHERE item_id="20140"; 
UPDATE armor SET itemdesc_id="656" WHERE item_id="20141"; 
UPDATE armor SET itemdesc_id="657" WHERE item_id="20142"; 
UPDATE armor SET itemdesc_id="654" WHERE item_id="20143"; 
UPDATE armor SET itemdesc_id="1379" WHERE item_id="20152"; 
UPDATE armor SET itemdesc_id="1720" WHERE item_id="20179"; 
UPDATE armor SET itemdesc_id="1380" WHERE item_id="20186"; 
UPDATE armor SET itemdesc_id="1001" WHERE item_id="20204"; 
UPDATE armor SET itemdesc_id="1719" WHERE item_id="20209"; 
UPDATE armor SET itemdesc_id="1382" WHERE item_id="20216"; 
UPDATE armor SET itemdesc_id="666" WHERE item_id="20230"; 
UPDATE armor SET itemdesc_id="114" WHERE item_id="20236"; 
UPDATE armor SET itemdesc_id="289" WHERE item_id="20238"; 
UPDATE armor SET itemdesc_id="282" WHERE item_id="20251"; 
UPDATE armor SET itemdesc_id="1722" WHERE item_id="20261"; 
UPDATE armor SET itemdesc_id="282" WHERE item_id="20270"; 
UPDATE armor SET itemdesc_id="1113" WHERE item_id="20286"; 
UPDATE armor SET itemdesc_id="1292" WHERE item_id="20289"; 
UPDATE armor SET itemdesc_id="1721" WHERE item_id="20290"; 
UPDATE armor SET itemdesc_id="1185" WHERE item_id="20299"; 
UPDATE armor SET itemdesc_id="2104" WHERE item_id="20381"; 
UPDATE armor SET itemdesc_id="1854" WHERE item_id="20389"; 
UPDATE armor SET itemdesc_id="1856" WHERE item_id="20393"; 
UPDATE armor SET itemdesc_id="1857" WHERE item_id="20401"; 
UPDATE armor SET itemdesc_id="1855" WHERE item_id="20406"; 
UPDATE armor SET itemdesc_id="1853" WHERE item_id="20409"; 
UPDATE armor SET itemdesc_id="1724" WHERE item_id="21020"; 
UPDATE armor SET itemdesc_id="1725" WHERE item_id="21021"; 
UPDATE armor SET itemdesc_id="1726" WHERE item_id="21022"; 
UPDATE armor SET itemdesc_id="1727" WHERE item_id="21023"; 
UPDATE armor SET itemdesc_id="1728" WHERE item_id="21024"; 
UPDATE armor SET itemdesc_id="1729" WHERE item_id="21025"; 
UPDATE armor SET itemdesc_id="1730" WHERE item_id="21026"; 
UPDATE armor SET itemdesc_id="1731" WHERE item_id="21027";

-- added a SuperDk Scroll for events or gm use
INSERT INTO `etcitem` VALUES ('240101', 'SuperDK', 'SuperDK', 'scroll', 'normal', 'paper', '630', '472', '22', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0');

-- a few item name fixes
update etcitem set name = 'Skeleton Skull', name_id = 'Skeleton Skull' where item_id = 41229;
update etcitem set name = 'Bone Piece', name_id = 'Bone Piece' where item_id = 41237;
