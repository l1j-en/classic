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

