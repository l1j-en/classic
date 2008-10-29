-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here
-- this allows them to be verified as working together before being
-- migrated to the DML scripts

-- update 35

-- new corrected ships dock locs
DELETE FROM dungeon WHERE src_x = "33423" and src_y = "33502" and src_mapid = "4"; 
DELETE FROM dungeon WHERE src_x = "32735" and src_y = "32794" and src_mapid = "83"; 
DELETE FROM dungeon WHERE src_x = "32936" and src_y = "33058" and src_mapid = "70"; 
DELETE FROM dungeon WHERE src_x = "32732" and src_y = "32796" and src_mapid = "84"; 
DELETE FROM dungeon WHERE src_x = "32738" and src_y = "32852" and src_mapid = "445"; 
DELETE FROM dungeon WHERE src_x = "32750" and src_y = "32874" and src_mapid = "445"; 
DELETE FROM dungeon WHERE src_x = "32732" and src_y = "32796" and src_mapid = "447"; 
DELETE FROM dungeon WHERE src_x = "32297" and src_y = "33087" and src_mapid = "440"; 
DELETE FROM dungeon WHERE src_x = "32735" and src_y = "32794" and src_mapid = "446"; 

INSERT INTO `dungeon` VALUES ('33423', '33502', '4', '32735', '32795', '83', '4', ''); 
INSERT INTO `dungeon` VALUES ('33424', '33502', '4', '32735', '32795', '83', '4', ''); 
INSERT INTO `dungeon` VALUES ('33425', '33502', '4', '32735', '32795', '83', '4', ''); 
INSERT INTO `dungeon` VALUES ('33426', '33502', '4', '33735', '32795', '83', '4', ''); 
INSERT INTO `dungeon` VALUES ('32733', '32794', '83', '33425', '33501', '4', '0', ''); 
INSERT INTO `dungeon` VALUES ('32734', '32794', '83', '33425', '33501', '4', '0', ''); 
INSERT INTO `dungeon` VALUES ('32735', '32794', '83', '33425', '33501', '4', '0', ''); 
INSERT INTO `dungeon` VALUES ('32736', '32794', '83', '33425', '33501', '4', '0', ''); 
INSERT INTO `dungeon` VALUES ('32935', '33058', '70', '32734', '32797', '84', '4', ''); 
INSERT INTO `dungeon` VALUES ('32936', '33058', '70', '32734', '32797', '84', '4', ''); 
INSERT INTO `dungeon` VALUES ('32937', '33058', '70', '32734', '32797', '84', '4', ''); 
INSERT INTO `dungeon` VALUES ('32732', '32796', '84', '32936', '33057', '70', '0', ''); 
INSERT INTO `dungeon` VALUES ('32733', '32796', '84', '32936', '33057', '70', '0', ''); 
INSERT INTO `dungeon` VALUES ('32734', '32796', '84', '32936', '33057', '70', '0', ''); 
INSERT INTO `dungeon` VALUES ('32735', '32796', '84', '32936', '33057', '70', '0', ''); 
INSERT INTO `dungeon` VALUES ('32738', '32851', '445', '32738', '32475', '4', '2', ''); 
INSERT INTO `dungeon` VALUES ('32739', '32851', '445', '32738', '32475', '4', '2', ''); 
INSERT INTO `dungeon` VALUES ('32750', '32874', '445', '32732', '32797', '447', '4', ''); 
INSERT INTO `dungeon` VALUES ('32751', '32874', '445', '32732', '32797', '447', '4', ''); 
INSERT INTO `dungeon` VALUES ('32752', '32874', '445', '32732', '32797', '447', '4', ''); 
INSERT INTO `dungeon` VALUES ('32731', '32796', '447', '32751', '32873', '445', '0', ''); 
INSERT INTO `dungeon` VALUES ('32732', '32796', '447', '32751', '32873', '445', '0', ''); 
INSERT INTO `dungeon` VALUES ('32733', '32796', '447', '32751', '32873', '445', '0', ''); 
INSERT INTO `dungeon` VALUES ('32296', '33087', '440', '32735', '32795', '446', '4', ''); 
INSERT INTO `dungeon` VALUES ('32297', '33087', '440', '32735', '32795', '446', '4', ''); 
INSERT INTO `dungeon` VALUES ('32298', '33087', '440', '32735', '32795', '446', '4', ''); 
INSERT INTO `dungeon` VALUES ('32735', '32794', '446', '32297', '33086', '440', '0', ''); 
INSERT INTO `dungeon` VALUES ('32736', '32794', '446', '32297', '33086', '440', '0', ''); 
INSERT INTO `dungeon` VALUES ('32630', '32983', '0', '32733', '32797', '5', '4', ''); 
INSERT INTO `dungeon` VALUES ('32631', '32983', '0', '32733', '32797', '5', '4', ''); 
INSERT INTO `dungeon` VALUES ('32632', '32983', '0', '32733', '32797', '5', '4', ''); 
INSERT INTO `dungeon` VALUES ('32733', '32796', '5', '32631', '32982', '0', '0', ''); 
INSERT INTO `dungeon` VALUES ('32734', '32796', '5', '32631', '32982', '0', '0', ''); 
INSERT INTO `dungeon` VALUES ('32540', '32728', '4', '32735', '32795', '6', '4', ''); 
INSERT INTO `dungeon` VALUES ('32542', '32728', '4', '32735', '32795', '6', '4', ''); 
INSERT INTO `dungeon` VALUES ('32543', '32728', '4', '32735', '32795', '6', '4', ''); 
INSERT INTO `dungeon` VALUES ('32544', '32728', '4', '32735', '32795', '6', '4', ''); 
INSERT INTO `dungeon` VALUES ('32734', '32794', '6', '32544', '32727', '4', '0', ''); 
INSERT INTO `dungeon` VALUES ('32735', '32794', '6', '32544', '32727', '4', '0', ''); 
INSERT INTO `dungeon` VALUES ('32736', '32794', '6', '32544', '32727', '4', '0', '');

-- oren Franco gamble corrected live prices
delete from shop where npc_id = 70068;

INSERT INTO `shop` VALUES (70068, 41, 0, 95000, 0, 22000);
INSERT INTO `shop` VALUES (70068, 148, 1, 88000, 0, 14300);
INSERT INTO `shop` VALUES (70068, 142, 2, 83000, 0, 8800);
INSERT INTO `shop` VALUES (70068, 29, 3, 88000, 0, 13000);
INSERT INTO `shop` VALUES (70068, 129, 4, 77000, 0, 2500);
INSERT INTO `shop` VALUES (70068, 125, 5, 84000, 0, 9000);
INSERT INTO `shop` VALUES (70068, 20125, 6, 63000, 0, 6000);
INSERT INTO `shop` VALUES (70068, 20011, 7, 58000, 0, 3000);
INSERT INTO `shop` VALUES (70068, 20036, 8, 69000, 0, 12000);
INSERT INTO `shop` VALUES (70068, 20013, 9, 81000, 0, 22000);
INSERT INTO `shop` VALUES (70068, 20014, 10, 73000, 0, 15000);
INSERT INTO `shop` VALUES (70068, 20015, 11, 76000, 0, 18000);

-- npc chat delay correction
UPDATE npcchat SET chat_interval="20000"; 