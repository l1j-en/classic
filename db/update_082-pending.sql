-- clear out all old giran dungeon mobs, npcs, and bosses
DELETE FROM `spawnlist` WHERE `mapid` IN (53,54,55,56);
DELETE FROM `spawnlist_boss` WHERE `mapid` IN (53,54,55,56);
DELETE FROM `spawnlist_npc` WHERE `mapid` IN (53,54,55,56);
DELETE FROM `npc` WHERE `npcid` >= 91401 AND `npcid` <= 91429;

-- remove the scroll from melissa if it exists
DELETE FROM `shop` WHERE `item_id` = 40827 AND `npc_id` = 70052;

-- delete the dungeon exit points
DELETE FROM `dungeon` WHERE `src_mapid` = 53 AND `new_mapid` = 4;

-- add skills
INSERT INTO `skills` (`id`,`name`,`skill_level`,`skill_number`,`mpConsume`,`hpConsume`,`itemConsumeId`,`itemConsumeCount`,`reuseDelay`,`buffDuration`,`target`,`target_to`,`damage_value`,`damage_dice`,`damage_dice_count`,`probability_value`,`probability_dice`,`attr`,`type`,`lawful`,`ranged`,`area`,`through`,`skill_id`,`nameid`,`action_id`,`castgfx`,`castgfx2`,`sysmsgID_happen`,`sysmsgID_stop`,`sysmsgID_fail`,`impl`)
VALUES ('91420','Faust (Ranged)','0','0','50','0','0','0','5000','0','attack','3','50','5','5','0','0','1','64','0','4','4','0','0','','18','5010','0','0','0','0',NULL);

-- add mobskills
INSERT INTO `mobskill` (`mobid`,`Skill_Description`,`actNo`,`Type`,`triRnd`,`triHp`,`triCompanionHp`,`triRange`,`triCount`,`ChangeTarget`,`Range`,`AreaWidth`,`AreaHeight`,`Leverage`,`SkillId`,`GfxId`,`ActId`,`SummonId`,`SummonMin`,`SummonMax`,`PolyId`)
VALUES ('91420','Faust (Ranged)','0','2','20','0','0','-4','0','0','4','0','0','10','91420','0','18','0','0','0','0');

-- spr_action
INSERT INTO `spr_action` (`spr_id`,`act_id`,`framecount`,`framerate`) VALUES('7515','0','32','24');
INSERT INTO `spr_action` (`spr_id`,`act_id`,`framecount`,`framerate`) VALUES('7515','1','38','24');
INSERT INTO `spr_action` (`spr_id`,`act_id`,`framecount`,`framerate`) VALUES('7515','30','34','24');
INSERT INTO `spr_action` (`spr_id`,`act_id`,`framecount`,`framerate`) VALUES('7515','19','34','24');
INSERT INTO `spr_action` (`spr_id`,`act_id`,`framecount`,`framerate`) VALUES('7515','18','43','24');

-- add npcs
INSERT INTO `npc` VALUES (91401,'Evil Spirit','$7444','Faust (Axe) (A)','L1Monster',5969,52,650,200,-46,17,18,15,12,10,50,4328,-65,'small',2,1,0,1280,1120,840,1120,1440,1,0,0,1,1,1,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91402,'Faust','$7445','Faust (A)','L1Monster',7515,57,2000,400,-60,20,20,15,12,10,90,5200,-65,'small',2,2,0,1280,1520,1360,1720,1360,0,0,0,0,1,1,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91403,'Evil Spirit','$7444','Faust\'s Evil Spirit (Sword) (A)','L1Monster',5977,52,650,200,-46,20,20,15,12,10,50,4328,-65,'small',2,2,0,1280,1120,1240,1440,1600,1,0,0,1,1,1,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91404,'Giran Bandit','$7442','Giran Bandit, Faust\'s demon (club) (A)','L1Monster',2443,28,100,10,-40,19,14,12,8,10,55,0,0,'small',0,1,0,480,1000,1280,1000,1000,0,0,0,1,1,1,'',1,-1,-1,0,0,0,5000,50,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,91400,0,0,1,0,1);
INSERT INTO `npc` VALUES (91405,'Giran Bandit','$7442','\"Giran Bandit (Sw), Faust\' s evil spirit (A)\"','L1Monster',2489,32,100,10,-45,17,15,18,11,12,40,0,0,'small',0,1,0,960,1080,1120,1080,1080,0,0,0,1,1,1,'bandit',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,91403,0,0,0,0,0);
INSERT INTO `npc` VALUES (91406,'Giran Bandit','$7442','Giran Bandit (Ax). Faust\' s demon (Ax) (A)','L1Monster',2516,31,100,10,-48,18,16,18,11,10,55,0,0,'small',0,1,0,960,1360,1160,1000,1000,0,0,0,1,1,1,'bandit',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,91401,0,0,0,0,0);
INSERT INTO `npc` VALUES (91407,'Giran Bandit','$7442','Giran Bandit (bow)','L1Monster',2533,28,100,10,-40,16,13,18,10,11,55,0,0,'small',0,10,0,960,1760,1120,1000,1000,0,0,0,1,1,1,'bandit',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,66,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91408,'Bandit Leader Klein','$7443','Bandit Boss Klein (A). Faust (A)','L1Monster',2417,35,300,10,-60,20,20,18,12,13,60,0,0,'small',0,1,0,960,1160,1080,1160,1160,0,0,0,1,1,1,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,91402,0,0,0,0,0);
INSERT INTO `npc` VALUES (91409,'Evil Spirit','$7444','Faust\'s Demon (Club) (B)','L1Monster',5972,45,650,200,-40,17,18,15,12,10,40,3242,-65,'small',2,1,0,1280,1120,1160,960,1280,1,0,0,1,1,1,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91410,'Evil Spirit','$7444','Faust\'s evil spirit (sword) (B)','L1Monster',5977,52,650,200,-46,20,20,15,12,10,40,4328,-65,'small',2,2,0,1280,1120,1240,1440,1600,1,0,0,1,1,1,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91411,'Starved Warden','$7446','Starved Warden (Bow)','L1Monster',4531,45,400,10,-48,16,12,18,12,12,30,3242,-35,'small',0,10,0,800,1600,1360,1280,1280,1,0,0,1,1,1,'giran',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,66,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91414,'Bandit Leader Klein','$7443','Bandit Boss Klein (B). Faust (B)','L1Monster',2417,35,3000,10,-60,20,20,18,12,13,60,0,-35,'small',0,1,0,960,1160,1080,1160,1160,0,0,0,1,1,1,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,91420,0,0,0,0,0);
INSERT INTO `npc` VALUES (91415,'Evil Spirit','$7444','Faust\'s demon (bow)','L1Monster',5972,45,570,250,-40,17,18,15,12,10,50,3242,-65,'small',2,1,0,1280,1120,1160,960,1280,1,0,0,1,1,1,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91416,'Evil Spirit','$7444','Faust\'s Demon (Club) (C)','L1Monster',5972,45,650,200,-46,17,18,15,12,10,40,3242,-65,'small',2,1,0,1280,1120,1160,960,1280,1,0,0,1,1,1,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91417,'Evil Spirit','$7444','Faust\'s evil spirit (sword) (C)','L1Monster',5977,52,550,200,-46,20,20,15,12,10,38,4328,-65,'small',2,2,0,1280,1120,1240,1440,1600,1,0,0,1,1,1,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91418,'Evil Spirit','$7444','Faust\'s demon (Ax) (B)','L1Monster',5969,52,570,200,-46,17,18,15,12,10,40,4328,-65,'small',2,1,0,1280,1120,840,1120,1440,1,0,0,1,1,1,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91419,'Tri Soul','Tri Soul','Tri Soul','L1Monster',2421,56,20000,2000,-63,20,20,18,18,20,90,5019,-80,'large',2,1,0,960,1880,0,1880,1880,1,0,0,0,1,1,'giant',1,-1,-1,0,0,0,5000,225,5000,225,0,0,0,0,0,0,0,0,1,0,1,0,0,0,-1,0,0,1,0,1);
INSERT INTO `npc` VALUES (91420,'Faust','$7445','Faust','L1Monster',7515,57,4000,200,-60,20,20,15,12,10,90,3250,-65,'small',2,2,0,1280,1520,1360,1720,1360,0,0,0,0,1,1,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91421,'Starved Inmate','$7447','Starved Inmate (A)','L1Monster',5110,45,600,430,-40,14,16,6,5,2,50,3242,-65,'small',2,1,0,960,1080,1080,1040,1040,1,0,0,1,1,1,'zombie',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91422,'Starved Inmate','$7447','Starved Inmate (B)','L1Monster',5112,45,630,430,-40,14,16,6,5,2,50,3242,-65,'small',2,1,0,1280,1120,1120,1040,1040,1,0,0,1,1,1,'zombie',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91423,'Starved Warden','$7446','Starved Warden (Spear)','L1Monster',4930,45,550,480,-40,18,14,16,12,10,30,3242,-65,'small',2,2,0,960,1120,1160,1000,960,1,0,0,1,1,1,'zombie',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0);
INSERT INTO `npc` VALUES (91424,'Giran Bandit','$7442','Giran Bandit, Faust\'s demon (club) (B)','L1Monster',2443,28,100,10,-40,19,14,12,8,10,55,0,0,'small',0,1,0,480,1000,1280,1000,1000,0,0,0,1,1,1,'',1,-1,-1,0,0,0,5000,50,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,91409,0,0,1,0,1);
INSERT INTO `npc` VALUES (91425,'Giran Bandit','$7442','\"Giran Bandit (Sw), Faust\' s evil spirit (B)\"','L1Monster',2489,32,100,10,-45,17,15,18,11,12,40,0,0,'small',0,1,0,960,1080,1120,1080,1080,0,0,0,1,1,1,'bandit',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,91410,0,0,0,0,0);
INSERT INTO `npc` VALUES (91426,'Giran Bandit','$7442','Giran Bandit, Faust\'s demon (club) (C)','L1Monster',2443,28,100,10,-40,19,14,12,8,10,55,0,0,'small',0,1,0,480,1000,1280,1000,1000,0,0,0,1,1,1,'',1,-1,-1,0,0,0,5000,50,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,91416,0,0,1,0,1);
INSERT INTO `npc` VALUES (91427,'Giran Bandit','$7442','\"Giran Bandit, Faust\' s Demon (Sword) (C)\"','L1Monster',2489,32,100,10,-45,17,15,18,11,12,40,0,0,'small',0,1,0,960,1080,1120,1080,1080,0,0,0,1,1,1,'bandit',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,91417,0,0,0,0,0);
INSERT INTO `npc` VALUES (91428,'Giran Bandit','$7442','Giran Bandit, Faust\' s demon (Ax) (B)','L1Monster',2516,31,100,10,-48,18,16,18,11,10,55,0,0,'small',0,1,0,960,1360,1160,1000,1000,0,0,0,1,1,1,'bandit',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,91418,0,0,0,0,0);
INSERT INTO `npc` VALUES (91429,'Giran Bandit','$7442','Giran Bandit, Faust\'s demon (bow)    ','L1Monster',2533,28,100,10,-40,16,13,18,10,11,55,0,0,'small',0,10,0,960,1760,1120,1000,1000,0,0,0,1,1,1,'bandit',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,66,0,91415,0,0,0,0,0);

-- mobs spawn
INSERT INTO `spawnlist` VALUES (5300008,'Giran Bandit',28,91405,0,32767,32767,0,0,32704,32704,32831,32831,5,0,0,53,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5300009,'Giran Bandit',44,91406,0,32767,32767,0,0,32704,32704,32831,32831,5,0,0,53,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400006,'Giran Bandit',3,91424,0,32767,32767,0,0,32704,32704,32831,32831,5,0,0,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400007,'Giran Bandit',3,91428,0,32767,32767,0,0,32704,32704,32831,32831,5,0,0,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400008,'Giran Bandit',3,91425,0,32767,32767,0,0,32704,32704,32831,32831,5,0,0,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400009,'Giran Bandit',16,91421,0,32767,32767,0,0,32704,32704,32831,32831,5,0,0,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400010,'Giran Bandit',16,91422,0,32767,32767,0,0,32704,32704,32831,32831,5,0,0,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400011,'Starved Warden',16,91423,0,32767,32767,0,0,32704,32704,32831,32831,5,0,0,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400012,'Giran Bandit',2,91421,0,0,0,0,0,32750,32721,32772,32741,3,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400013,'Giran Bandit',1,91421,0,32721,32750,12,12,32721,32750,32740,32767,2,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400014,'Starved Warden',1,91423,0,32721,32750,12,12,32721,32750,32740,32767,2,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400015,'Giran Bandit',3,91424,0,0,0,0,0,32721,32780,32758,32811,2,60,120,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400016,'Giran Bandit',3,91428,0,0,0,0,0,32721,32780,32758,32811,2,60,120,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400017,'Giran Bandit',3,91425,0,0,0,0,0,32721,32780,32758,32811,2,60,120,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400018,'Giran Bandit',3,91421,0,0,0,0,0,32721,32780,32758,32811,2,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400019,'Giran Bandit',3,91422,0,0,0,0,0,32721,32780,32758,32811,2,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400020,'Giran Bandit',3,91421,0,0,0,0,0,32743,32739,32771,32767,1,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400021,'Giran Bandit',3,91422,0,0,0,0,0,32743,32739,32771,32767,6,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400022,'Giran Bandit',1,91421,0,32721,32750,12,12,32721,32750,32740,32767,2,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400023,'Starved Warden',3,91423,0,0,0,0,0,32750,32721,32772,32741,3,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400024,'Giran Bandit',2,91421,0,0,0,0,0,32750,32721,32772,32741,3,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400025,'Giran Bandit',5,91424,0,0,0,0,0,32781,32729,32805,32811,5,0,0,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400026,'Giran Bandit',5,91428,0,0,0,0,0,32781,32729,32805,32811,5,0,0,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400027,'Giran Bandit',5,91425,0,0,0,0,0,32781,32729,32805,32811,5,0,0,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400028,'Giran Bandit',5,91421,0,0,0,0,0,32781,32729,32805,32811,5,0,0,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400029,'Giran Bandit',5,91422,0,0,0,0,0,32781,32729,32805,32811,5,0,0,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400030,'Starved Warden',5,91423,0,0,0,0,0,32781,32729,32805,32811,5,0,0,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400031,'Starved Warden',3,91423,0,0,0,0,0,32721,32780,32758,32811,2,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400032,'Starved Warden',3,91423,0,0,0,0,0,32743,32739,32771,32767,1,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400033,'Starved Warden',1,91423,0,0,0,0,0,21728,32721,32745,32778,4,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400034,'Giran Bandit',1,91421,0,32736,32733,12,12,0,0,0,0,2,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400035,'Giran Bandit',1,91421,0,0,0,0,0,21728,32721,32745,32778,2,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400036,'Giran Bandit',1,91422,0,0,0,0,0,21728,32721,32745,32778,0,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400037,'Starved Warden',1,91423,0,32736,32733,12,12,0,0,0,0,2,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5400038,'Giran Bandit',1,91421,0,32736,32733,12,12,0,0,0,0,2,40,80,54,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500005,'Starved Warden',4,91411,0,0,0,0,0,32726,32726,32749,32744,4,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500006,'Starved Warden',4,91423,0,0,0,0,0,32722,32732,32749,32744,7,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500007,'Giran Bandit',4,91421,0,0,0,0,0,32722,32732,32749,32744,3,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500008,'Starved Warden',7,91411,0,0,0,0,0,32729,32745,32749,32786,4,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500009,'Starved Warden',7,91423,0,0,0,0,0,32729,32745,32749,32786,7,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500010,'Giran Bandit',7,91421,0,0,0,0,0,32729,32745,32749,32786,7,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500011,'Starved Warden',4,91411,0,0,0,0,0,32731,32791,32749,32820,4,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500012,'Starved Warden',4,91423,0,0,0,0,0,32731,32791,32749,32820,7,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500013,'Giran Bandit',4,91422,0,0,0,0,0,32731,32791,32749,32820,7,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500014,'Starved Warden',4,91411,0,0,0,0,0,32729,32815,32745,32842,4,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500015,'Starved Warden',4,91423,0,0,0,0,0,32729,32815,32745,32842,0,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500016,'Starved Warden',1,91423,0,0,0,0,0,32722,32843,32749,32869,4,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500017,'Starved Warden',7,91411,0,0,0,0,0,32722,32843,32749,32869,0,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500018,'Giran Bandit',7,91422,0,0,0,0,0,32722,32843,32749,32869,0,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500019,'Starved Warden',1,91411,0,0,0,0,0,32722,32862,32741,32877,4,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500020,'Starved Warden',1,91423,0,0,0,0,0,32722,32862,32741,32877,0,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5500021,'Giran Bandit',1,91422,0,0,0,0,0,32722,32862,32741,32877,0,40,80,55,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5600006,'Giran Bandit',29,91429,0,32770,32730,0,0,32704,32704,32831,32831,5,0,0,56,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5600007,'Giran Bandit',29,91426,0,32770,32730,0,0,32704,32704,32831,32831,5,0,0,56,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5600008,'Giran Bandit',29,91428,0,32770,32730,0,0,32704,32704,32831,32831,5,0,0,56,0,0,0,0,1,8,2,100);
INSERT INTO `spawnlist` VALUES (5600009,'Giran Bandit',29,91427,0,32770,32730,0,0,32704,32704,32831,32831,5,0,0,56,0,0,0,0,1,8,2,100);

-- drops
INSERT INTO `droplist` VALUES (91401,'Evil Spirit',40308,'adena',100,250,600000);
INSERT INTO `droplist` VALUES (91403,'Evil Spirit',40308,'adena',100,250,600000);
INSERT INTO `droplist` VALUES (91410,'Evil Spirit',40308,'adena',100,250,600000);
INSERT INTO `droplist` VALUES (91415,'Evil Spirit',40308,'adena',100,250,600000);
INSERT INTO `droplist` VALUES (91417,'Evil Spirit',40308,'adena',100,250,600000);
INSERT INTO `droplist` VALUES (91418,'Evil Spirit',40308,'adena',100,250,600000);
INSERT INTO `droplist` VALUES (91421,'Starved Inmate',40308,'adena',80,200,600000);
INSERT INTO `droplist` VALUES (91422,'Starved Inmate',40308,'adena',80,200,600000);
INSERT INTO `droplist` VALUES (91423,'Starved Warden',40308,'adena',80,200,600000);
INSERT INTO `droplist` VALUES (91424,'Starved Warden',40308,'adena',80,200,600000);


-- fix Great Spirit of Wind spawns on DI to match other elements (3 of each on CASPA timer)
INSERT INTO `spawnlist_boss` (`id`, `location`, `cycle_type`, `count`, `npc_id`, `group_id`, `locx`, `locy`, `randomx`, `randomy`, `locx1`, `locy1`, `locx2`, `locy2`, `heading`, `mapid`, `respawn_screen`, `movement_distance`, `rest`, `spawn_type`, `percentage`) VALUES (NULL, 'Great Spirit of Wind', 'Caspa', '1', '45644', '0', '32624', '32807', '0', '0', '32588', '32739', '32660', '32876', '4', '303', '1', '0', '0', '0', '100');
INSERT INTO `spawnlist_boss` (`id`, `location`, `cycle_type`, `count`, `npc_id`, `group_id`, `locx`, `locy`, `randomx`, `randomy`, `locx1`, `locy1`, `locx2`, `locy2`, `heading`, `mapid`, `respawn_screen`, `movement_distance`, `rest`, `spawn_type`, `percentage`) VALUES (NULL, 'Great Spirit of Wind', 'Caspa', '1', '45644', '0', '32624', '32807', '0', '0', '32588', '32739', '32660', '32876', '4', '303', '1', '0', '0', '0', '100');

-- fix boarding boat to FI
UPDATE `dungeon` SET `new_x` = 32736, `new_y` = 32795 WHERE `src_mapid` = 4 AND `new_mapid` = 83;

-- fix the getback locations for the boats
UPDATE `getback` SET `getback_x1` = 32565, `getback_y1` = 32726, `getback_x2` = 32565, `getback_y2` = 32726, `getback_x3` = 32565, `getback_y3` = 32726, `getback_mapid` = 4 WHERE `area_mapid` = 5;
UPDATE `getback` SET `getback_x1` = 32632, `getback_y1` = 32973, `getback_x2` = 32632, `getback_y2` = 32973, `getback_x3` = 32632, `getback_y3` = 32973, `getback_mapid` = 0 WHERE `area_mapid` = 6;
UPDATE `getback` SET `getback_x1` = 32936, `getback_y1` = 33052, `getback_x2` = 32936, `getback_y2` = 33052, `getback_x3` = 32936, `getback_y3` = 33052, `getback_mapid` = 70 WHERE `area_mapid` = 83;
UPDATE `getback` SET `getback_x1` = 33426, `getback_y1` = 33499, `getback_x2` = 33426, `getback_y2` = 33499, `getback_x3` = 33426, `getback_y3` = 33499, `getback_mapid` = 4 WHERE `area_mapid` = 84;

-- Update Counter Barrier to have a 20% success rate instead of 25% 
UPDATE `skills` SET probability_value = 20 WHERE skill_id = 91;