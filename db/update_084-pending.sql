-- shadow weapons
INSERT INTO `weapon` VALUES(550012,'Wind Blade Dagger','$3835','$3835','dagger','blackmithril',60000,1947,5003,0,23,16,1,0,1,0,0,1,0,0,0,10,10,0,0,2,0,0,0,100,0,0,0,0,0,0,0,0,0,0,0,1,1,0,18000),
(550061,'Execution Sword of Fidelity','$3834','$3834','tohandsword','blackmithril',100000,1945,5002,0,28,33,1,0,0,1,0,0,0,1,0,5,20,2,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,18000),
(550086,'Edoryu of Red Shadow','$3836','$3836','edoryu','blackmithril',50000,1949,5004,0,27,18,1,0,0,0,0,0,1,0,0,10,18,0,0,2,0,2,0,0,0,0,0,0,0,0,25,0,0,0,0,1,1,0,18000),
(550134,'Crystalized Staff','$3838','$3838','staff','blackmithril',60000,1953,5006,0,13,15,1,0,0,0,1,0,0,0,1,8,0,0,0,0,2,0,0,0,50,0,10,8,0,0,0,0,0,0,0,1,1,0,18000),
(550160,'Claw of Savage King','$3837','$3837','claw','blackmithril',70000,1951,5005,0,25,20,1,0,0,0,0,0,1,0,0,8,10,0,0,2,0,0,0,0,0,0,0,0,0,0,35,0,0,0,0,1,1,0,18000),
(550284,'Demon King Bow','Demon King Bow','Demon King Bow','bow','blackmithril',30000,3146,7023,0,5,5,-1,6,0,0,0,1,0,0,0,10,15,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,18000),
(550285,'Fidelity Chain Sword','Fidelity Chain Sword','Fidelity Chain Sword','chainsword','blackmithril',110000,3022,6962,0,25,20,2,0,0,0,0,0,0,1,0,10,15,2,0,0,0,0,0,50,0,0,0,0,0,0,0,0,0,0,0,1,1,0,18000),
(550286,'Fidelity Kiringku','Fidelity Kiringku','Fidelity Kiringku','kiringku','blackmithril',10000,3020,6967,0,33,33,1,0,0,0,0,0,0,0,1,0,5,0,0,0,2,0,0,0,0,0,0,5,0,0,0,0,0,0,0,1,1,0,18000);

-- shadow weapon skills

-- npc
INSERT INTO `npc` VALUES(99000,'Shadow Merchant','Shadow Merchant','Shadow Fid event','L1Merchant',266,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0);
INSERT INTO `npcaction` VALUES(99000,'shadowevent1','shadowevent1','','');
INSERT INTO `spawnlist_npc` (`location`, `count`, `npc_templateid`, `locx`, `locy`, `heading`, `mapid`) 
VALUES('Shadow Merchant',1,99000,33436,32802,6,4),
('Shadow Merchant',1,99000,34059,32279,6,4),
('Shadow Merchant',1,99000,33087,33390,6,4);