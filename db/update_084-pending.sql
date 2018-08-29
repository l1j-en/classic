-- shadow weapons
INSERT INTO `weapon` VALUES(550012,'Shadow Fid Dagger','Shadow Fid Dagger','Shadow Fid Dagger','dagger','blackmithril',60000,1947,5003,0,23,16,1,0,1,0,0,1,0,0,0,10,10,0,0,2,0,0,0,100,0,0,0,0,0,0,0,0,0,0,0,1,1,0,18000),
(550061,'Shadow Fid 2H Sword','Shadow Fid 2H Sword','Shadow Fid 2H Sword','tohandsword','blackmithril',100000,1945,5002,0,28,33,1,0,0,1,0,0,0,1,0,5,20,2,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,18000),
(550086,'Shadow Fid Edoryu','Shadow Fid Edoryu','Shadow Fid Edoryu','edoryu','blackmithril',50000,1949,5004,0,27,18,1,0,0,0,0,0,1,0,0,10,18,0,0,2,0,2,0,0,0,0,0,0,0,0,25,0,0,0,0,1,1,0,18000),
(550134,'Shadow Fid Staff','Shadow Fid Staff','Shadow Fid Staff','staff','blackmithril',60000,1953,5006,0,13,15,1,0,0,0,1,0,0,0,1,8,0,0,0,0,2,0,0,0,50,0,10,8,0,0,0,0,0,0,0,1,1,0,18000),
(550160,'Shadow Fid Claw','Shadow Fid Claw','Shadow Fid Claw','claw','blackmithril',70000,1951,5005,0,25,20,1,0,0,0,0,0,1,0,0,8,10,0,0,2,0,0,0,0,0,0,0,0,0,0,35,0,0,0,0,1,1,0,18000),
(550284,'Shadow Fid Bow','Shadow Fid Bow','Shadow Fid Bow','bow','blackmithril',30000,3146,7023,0,5,5,-1,6,0,0,0,1,0,0,0,10,15,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,18000),
(550285,'Shadow Fid Chain Sword','Shadow Fid Chain Sword','Shadow Fid Chain Sword','chainsword','blackmithril',110000,3022,6962,0,25,20,2,0,0,0,0,0,0,1,0,10,15,2,0,0,0,0,0,50,0,0,0,0,0,0,0,0,0,0,0,1,1,0,18000),
(550286,'Shadow Fid Kiringku','Shadow Fid Kiringku','Shadow Fid Kiringku','kiringku','blackmithril',10000,3020,6967,0,33,33,1,0,0,0,0,0,0,0,1,0,5,0,0,0,2,0,0,0,0,0,0,5,0,0,0,0,0,0,0,1,1,0,18000);

-- shadow weapon skills
INSERT INTO `weapon_skill` VALUES(550284, 'Shadow Fid Bow', 10, 40, 40, 0, 0, 0, 1809, 0, 1, 4);
INSERT INTO `weapon_skill` VALUES(550134, 'Shadow Fid Staff', 10, 30, 15, 0, 65, 0, 3924, 0, 0, 8);
INSERT INTO `weapon_skill` VALUES(550285, 'Shadow Fid Chain Sword', 10, 40, 40, 0, 50, 0, 756, 0, 0, 4);

-- npc
INSERT INTO `npc` VALUES(99000,'Lastavard Blacksmith','Lastavard Blacksmith','Shadow Fid event','L1Merchant',266,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0);
INSERT INTO `npcaction` VALUES(99000,'shadowevent1','shadowevent1','','');
INSERT INTO `spawnlist_npc` (`location`, `count`, `npc_templateid`, `locx`, `locy`, `heading`, `mapid`) 
VALUES('Lastavard Blacksmith',1,99000,33436,32802,6,4),
('Shadow Merchant',1,99000,34059,32279,6,4),
('Shadow Merchant',1,99000,33087,33390,6,4);

-- add illusion enchant weapon scrolls to the shops that sell normal enchant weapon scrolls
INSERT INTO `shop` (`npc_id`, `item_id`, `selling_price`) VALUES
(70033, 40128, 10000),
(70048, 40128, 10000),
(70057, 40128, 10000),
(70067, 40128, 10000),
(70082, 40128, 10000),
(70092, 40128, 10000),
(70093, 40128, 10000),
(81028, 40128, 10000);

-- update those who already buy it to also sell it
UPDATE `shop` SET `selling_price` = 10000 WHERE item_id = 40128 AND `npc_id` = 70063;

-- Remove the scrolls from shops after event ends
DELETE FROM `shop` WHERE `npc_id` IN(70033,70048,70057,70067,70082,70092,70093,81028) AND `item_id` = 40128 AND `selling_price` = 10000;

-- update the shop that previously bought it to not sell it anymore
UPDATE `shop` SET `selling_price` = -1 WHERE item_id = 40128 AND `npc_id` = 70063;

-- delete all scrolls and weapons from characters, storage, etc.
DELETE FROM `character_items` WHERE `item_id` IN(40128,550012,550061,550086,550134,550160,550284,550285,550286);
DELETE FROM `character_warehouse` WHERE `item_id` IN(40128,550012,550061,550086,550134,550160,550284,550285,550286);
DELETE FROM `character_elf_warehouse` WHERE `item_id` IN(40128,550012,550061,550086,550134,550160,550284,550285,550286);
DELETE FROM `clan_warehouse` WHERE `item_id` IN(40128,550012,550061,550086,550134,550160,550284,550285,550286);