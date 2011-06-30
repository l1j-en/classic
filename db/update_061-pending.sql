-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 61

-- Redo some of the new NPCs (their stats/settings are off)
delete from npc where npcid = 71255;
INSERT INTO `npc` VALUES (71255, 'Baell Zaer', '$6077', 'Baell Zaer', 'L1Merchant', 6992, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);
delete from npc where npcid = 71256;
INSERT INTO `npc` VALUES (71256, 'Cronos', '$2574', '$2038', 'L1Merchant', 916, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);
delete from npc where npcid = 71257;
INSERT INTO `npc` VALUES (71257, 'Elazer', '$5031', 'Elazer', 'L1Merchant', 1621, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);
delete from npc where npcid = 71258;
INSERT INTO `npc` VALUES (71258, 'Skeleton Mage', '$3989', 'Skeleton Mage', 'L1Merchant', 1621, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);
delete from npc where npcid = 71259;
INSERT INTO `npc` VALUES (71259, 'Skeleton Sorcerer', '$3990', 'Skeleton Sorcerer', 'L1Merchant', 834, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);
delete from npc where npcid = 71260;
INSERT INTO `npc` VALUES (71260, 'Skeleton Wizard', '', 'Skeleton Wizard', 'L1FieldObject', 1758, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
delete from npc where npcid = 71261;
INSERT INTO `npc` VALUES (71261, 'Zarlok', 'Zarlok', 'Zarlok', 'L1Monster', 2887, 1, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 2000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
delete from npc where npcid = 71271;
INSERT INTO `npc` VALUES (71271, 'Kugas', '', 'Kugas', 'L1FieldObject', 134, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);

-- updated a few npc ids to not interfere with npcs merged from l1j-jp
update npc set npcid = 90003 where name = "Baell Zaer";
update npc set npcid = 90004 where name = "Cronos";
update npc set npcid = 90005 where name = "Elazer";
update npc set npcid = 90006 where name = "Skeleton Mage";
update npc set npcid = 90007 where name = "Skeleton Sorcerer";
update npc set npcid = 90008 where name = "Skeleton Wizard";
update npc set npcid = 90009 where name = "Zarlok";
update npc set npcid = 90010 where name = "Kugas";
update npc set npcid = 90011 where name = "Crack of Time";
update spawnlist_boss set npc_id = 90003 where location = "Baell Zaer";
update spawnlist_boss set npc_id = 90004 where location = "Cronos";
update spawnlist_boss set npc_id = 90005 where location = "Elazer";
update spawnlist_boss set npc_id = 90009 where location = "Zarlok";
update spawnlist_boss set npc_id = 90010 where location = "Kugas";

-- added candle merchant tilo
insert into npc values (90012,'Tilo','Tilo','Candle Npc','L1Merchant',1621,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0);
insert into spawnlist_npc values (1900002,'Tilo',1,90012,32608,32775,0,0,4,0,4,0);
insert into npcaction values (90012,'candle','','','');

-- added bag girl
insert into npc values (90013,'Bag Girl','Bag Girl','','L1Merchant',725,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0);
insert into npcaction values (90013,'potionbag1','','','');
insert into spawnlist_npc values (1900003,'Bag Girl',1,90013,32629,33194,0,0,4,0,4,0);
insert into spawnlist_npc values (1900004,'Bag Girl',1,90013,33094,33385,0,0,4,0,4,0);
insert into spawnlist_npc values (1900005,'Bag Girl',1,90013,33642,33290,0,0,6,0,4,0);
insert into spawnlist_npc values (1900006,'Bag Girl',1,90013,33454,32823,0,0,6,0,4,0);
insert into spawnlist_npc values (1900007,'Bag Girl',1,90013,33736,32493,0,0,4,0,4,0);
insert into spawnlist_npc values (1900008,'Bag Girl',1,90013,34062,32290,0,0,4,0,4,0);
update etcitem set weight = 4500 where item_id = "40031";
insert into etcitem values (90000,'Bag of Greater Mana Potions','Bag of Greater Mana Potions','Bag of Greater Mana Potions','treasure_box','normal','leather',14100,1645,4248,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90001,'Bag of Greater Haste Potions','Bag of Greater Haste Potions','Bag of Greater Haste Potions','treasure_box','normal','leather',14100,957,3963,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90002,'Bag of Elven Wafers','Bag of Elven Wafers','Bag of Elven Wafers','treasure_box','normal','leather',15000,1396,3461,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90003,'Bag of Brave Potions','Bag of Brave Potions','Bag of Brave Potions','treasure_box','normal','leather',13500,958,3963,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90004,'Bag of Devil\'s Blood','Bag of Devil\'s Blood','Bag of Devil\'s Blood','treasure_box','normal','leather',13500,1417,4248,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90005,'Bag of Wisdom Potions','Bag of Wisdom Potions','Bag of Wisdom Potions','treasure_box','normal','leather',13500,1643,4246,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90006,'Bag of Mana Potions','Bag of Mana Potions','Bag of Mana Potions','treasure_box','normal','leather',23400,1645,4248,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90007,'Bag of Haste Potions','Bag of Haste Potions','Bag of Haste Potions','treasure_box','normal','leather',11700,957,3963,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90008,'Greater Potion of Mana','Greater Potion of Mana','Greater Potion of Mana','potion','normal','glass',7050,75,20,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0);

-- Lots more npc table merges.
update npc set gfxid = 4744, passispeed = 960, atkspeed = 1040 where npcid = 45847;
update npc set ac = -32, exp = 0, lawful = 0 where npcid = 45848;
update npc set weakAttr = 2 where npcid = 45849;
update npc set lvl = 42, ac = -37, exp = 0, lawful = 0, transform_id = 45849 where npcid = 45850;
update npc set exp = 0, lawful = 0 where npcid = 45851;
update npc set exp = 0, lawful = 0 where npcid = 45852;
update npc set weakAttr = 2, hprinterval = 5000, hpr = 15, mprinterval = 5000, mpr = 25 where npcid = 45853;
update npc set weakAttr = 2, hprinterval = 5000, hpr = 15, mprinterval = 5000, mpr = 25 where npcid = 45859;
update npc set ac = -38, weakAttr = 2, hprinterval = 5000, hpr = 15, mprinterval = 5000, mpr = 25 where npcid = 45860;
update npc set weakAttr = 2 where npcid = 45861;
update npc set weakAttr = 2 where npcid = 45862;
update npc set weakAttr = 2, undead = 0, hprinterval = 5000, hpr = 15, mprinterval = 5000, mpr = 25 where npcid = 45864;
update npc set undead = 0 where npcid = 45865;
update npc set weakAttr = 2, undead = 0, hprinterval = 5000, hpr = 15, mprinterval = 5000, mpr = 25 where npcid = 45866;
update npc set weakAttr = 2, undead = 0, hprinterval = 5000, hpr = 20 where npcid = 45867;
update npc set hprinterval = 5000, hpr = 15, mprinterval = 5000, mpr = 25 where npcid = 45869;
update npc set hp = 820, ac = -43, weakAttr = 2, undead = 0, hprinterval = 5000, hpr = 10, mprinterval = 5000, mpr = 20 where npcid = 45870;
update npc set undead = 0 where npcid = 45871;
update npc set gfxid = 4744, passispeed = 960, atkspeed = 1040 where npcid = 45872;
update npc set nameid = '$2408' where npcid = 45876;
update npc set nameid = '$2408' where npcid = 45877;
update npc set gfxid = 2917 where npcid = 45885;
update npc set gfxid = 2917 where npcid = 45888;
update npc set gfxid = 2917 where npcid = 45889;
update npc set passispeed = 640, atkspeed = 1280 where npcid = 45891;
update npc set passispeed = 1040, atkspeed = 960 where npcid = 45893;
update npc set agrofamily = 0 where npcid = 45895;
update npc set agrofamily = 0 where npcid = 45901;
update npc set agrofamily = 0 where npcid = 45902;
update npc set atk_magic_speed = 2240, sub_magic_speed = 2240 where npcid = 45907;
update npc set passispeed = 960, atkspeed = 1320 where npcid = 45909;
update npc set gfxid = 3364 where npcid = 45923;
update npc set cant_resurrect = 1 where npcid = 45935;
update npc set ranged = 0, bowActId = 0 where npcid = 45936;
update npc set ranged = 2, agrososc = 1, agrocoi = 1 where npcid = 45938;
update npc set agrososc = 1 where npcid = 45939;
update npc set agrososc = 1 where npcid = 45940;
update npc set cant_resurrect = 1 where npcid = 45941;
update npc set cant_resurrect = 1 where npcid = 45942;
update npc set agro = 1, agrososc = 1, agrocoi = 1 where npcid = 45943;
update npc set sub_magic_speed = 1400 where npcid = 45955;
update npc set sub_magic_speed = 1600 where npcid = 45956;
update npc set sub_magic_speed = 1520 where npcid = 45957;
update npc set sub_magic_speed = 1560 where npcid = 45958;
update npc set sub_magic_speed = 1680 where npcid = 45959;
update npc set gfxid = 4701, atkspeed = 1160, atk_magic_speed = 1800 where npcid = 45963;
update npc set ranged = 2, passispeed = 1440, family = 'deepflower' where npcid = 45978;
update npc set atkspeed = 1080 where npcid = 45994;
update npc set atkspeed = 1080 where npcid = 45995;
update npc set atkspeed = 1080 where npcid = 45998;
update npc set atkspeed = 1080 where npcid = 45999;
update npc set atkspeed = 1080 where npcid = 46002;
update npc set atkspeed = 1080 where npcid = 46003;
update npc set atkspeed = 1080 where npcid = 46004;
update npc set atkspeed = 1080 where npcid = 46007;
update npc set IsTU = 1 where npcid = 46009;
update npc set IsTU = 1 where npcid = 46012;
update npc set cant_resurrect = 1 where npcid = 46013;
update npc set undead = 4 where npcid = 46036;
update npc set nameid = '$5522' where npcid = 46041;
update npc set cant_resurrect = 0 where npcid = 46042;
update npc set cant_resurrect = 0 where npcid = 46043;
update npc set cant_resurrect = 0 where npcid = 46044;
update npc set cant_resurrect = 0 where npcid = 46045;
update npc set cant_resurrect = 0 where npcid = 46046;
update npc set atk_magic_speed = 960, sub_magic_speed = 960 where npcid = 46060;
update npc set atk_magic_speed = 1000, sub_magic_speed = 1000 where npcid = 46061;
update npc set sub_magic_speed = 1120 where npcid = 46065;
update npc set sub_magic_speed = 1360 where npcid = 46067;
update npc set impl = 'L1Monster' where npcid = 46082;
update npc set impl = 'L1Monster' where npcid = 46083;
update npc set impl = 'L1Monster' where npcid = 46084;
update npc set impl = 'L1Monster' where npcid = 46085;
update npc set impl = 'L1Monster' where npcid = 46086;
update npc set impl = 'L1Monster' where npcid = 46087;
update npc set impl = 'L1Monster' where npcid = 46088;
update npc set impl = 'L1Monster' where npcid = 46089;
update npc set impl = 'L1Monster' where npcid = 46090;
update npc set impl = 'L1Monster', IsTU = 1 where npcid = 46091;
update npc set IsTU = 1 where npcid = 46092;
update npc set IsTU = 1 where npcid = 46093;
update npc set IsTU = 1 where npcid = 46094;
update npc set IsTU = 1 where npcid = 46095;
update npc set IsTU = 1 where npcid = 46096;
update npc set impl = 'L1Monster', IsTU = 1 where npcid = 46097;
update npc set impl = 'L1Monster', IsTU = 1 where npcid = 46098;
update npc set impl = 'L1Monster', IsTU = 1 where npcid = 46099;
update npc set impl = 'L1Monster' where npcid = 46100;
update npc set impl = 'L1Monster' where npcid = 46101;
update npc set impl = 'L1Monster' where npcid = 46102;
update npc set impl = 'L1Monster' where npcid = 46103;
update npc set impl = 'L1Monster' where npcid = 46104;
update npc set impl = 'L1Monster' where npcid = 46105;
update npc set impl = 'L1Monster', IsTU = 1 where npcid = 46106;
update npc set nameid = '$5492', gfxid = 6555, lvl = 23, hp = 280, mp = 40, ac = -10, str = 13, dex = 13, intel = 10, mr = 50, exp = 530, lawful = -16, passispeed = 480, atkspeed = 1600, atk_magic_speed = 1600, sub_magic_speed = 1600, family = 'tebe_m', picupitem = 0, hprinterval = 5000, hpr = 20, hard = 0 where npcid = 46107;
update npc set change_head = 1 where npcid = 50081;
update npc set change_head = 1 where npcid = 50118;
update npc set change_head = 1 where npcid = 50118;
update npc set amount_fixed = 0 where npcid = 50626;
update npc set amount_fixed = 0 where npcid = 50627;
update npc set amount_fixed = 0 where npcid = 50628;
update npc set amount_fixed = 0 where npcid = 50629;
update npc set amount_fixed = 0 where npcid = 50630;
update npc set amount_fixed = 0 where npcid = 50631;
update npc set passispeed = 960, atkspeed = 1540, atk_magic_speed = 1240, sub_magic_speed = 1240 where npcid = 60563;
update npc set change_head = 1 where npcid = 60565;
update npc set change_head = 1 where npcid = 70001;
update npc set change_head = 1 where npcid = 70002;
update npc set change_head = 1 where npcid = 70003;
update npc set change_head = 1 where npcid = 70004;
update npc set change_head = 1 where npcid = 70005;
update npc set change_head = 1 where npcid = 70006;
update npc set change_head = 1 where npcid = 70007;
update npc set change_head = 1 where npcid = 70008;
update npc set change_head = 1 where npcid = 70009;
update npc set change_head = 1 where npcid = 70010;
update npc set change_head = 1 where npcid = 70011;
update npc set change_head = 1 where npcid = 70012;
update npc set change_head = 1 where npcid = 70013;
update npc set change_head = 1 where npcid = 70014;
update npc set change_head = 1 where npcid = 70015;
update npc set change_head = 1 where npcid = 70016;
update npc set change_head = 1 where npcid = 70017;
update npc set change_head = 1 where npcid = 70018;
update npc set change_head = 1 where npcid = 70019;
update npc set change_head = 1 where npcid = 70020;
update npc set change_head = 1 where npcid = 70021;
update npc set change_head = 1 where npcid = 70022;
update npc set change_head = 1 where npcid = 70023;
update npc set change_head = 1 where npcid = 70024;
update npc set change_head = 1 where npcid = 70025;
update npc set change_head = 1 where npcid = 70026;
update npc set change_head = 1 where npcid = 70027;
update npc set change_head = 1 where npcid = 70028;
update npc set change_head = 1 where npcid = 70029;
update npc set change_head = 1 where npcid = 70030;
update npc set change_head = 1 where npcid = 70031;
update npc set change_head = 1 where npcid = 70032;
update npc set change_head = 1 where npcid = 70033;
update npc set change_head = 1 where npcid = 70034;
update npc set nameid = '$858', change_head = 1 where npcid = 70035;
update npc set change_head = 1 where npcid = 70036;
update npc set change_head = 1 where npcid = 70037;
update npc set change_head = 1 where npcid = 70038;
update npc set change_head = 1 where npcid = 70039;
update npc set change_head = 1 where npcid = 70040;
update npc set change_head = 1 where npcid = 70041;
update npc set nameid = '$886', change_head = 1 where npcid = 70042;
update npc set change_head = 1 where npcid = 70043;
update npc set change_head = 1 where npcid = 70044;
update npc set change_head = 1 where npcid = 70045;
update npc set change_head = 1 where npcid = 70046;
update npc set change_head = 1 where npcid = 70047;
update npc set change_head = 1 where npcid = 70048;
update npc set change_head = 1 where npcid = 70049;
update npc set change_head = 1 where npcid = 70050;
update npc set change_head = 1 where npcid = 70051;
update npc set change_head = 1 where npcid = 70052;
update npc set change_head = 1 where npcid = 70053;
update npc set change_head = 1 where npcid = 70054;
update npc set change_head = 1 where npcid = 70055;
update npc set change_head = 1 where npcid = 70056;
update npc set change_head = 1 where npcid = 70057;
update npc set change_head = 1 where npcid = 70058;
update npc set change_head = 1 where npcid = 70059;
update npc set change_head = 1 where npcid = 70060;
update npc set change_head = 1 where npcid = 70061;
update npc set change_head = 1 where npcid = 70062;
update npc set change_head = 1 where npcid = 70063;
update npc set change_head = 1 where npcid = 70064;
update npc set change_head = 1 where npcid = 70065;
update npc set change_head = 1 where npcid = 70066;
update npc set change_head = 1 where npcid = 70067;
update npc set change_head = 1 where npcid = 70068;
update npc set change_head = 1 where npcid = 70069;
update npc set change_head = 1 where npcid = 70070;
update npc set change_head = 1 where npcid = 70071;
update npc set change_head = 1 where npcid = 70072;
update npc set change_head = 1 where npcid = 70073;
update npc set change_head = 1 where npcid = 70074;
update npc set change_head = 1 where npcid = 70075;
update npc set change_head = 1 where npcid = 70076;
update npc set change_head = 1 where npcid = 70077;
update npc set change_head = 1 where npcid = 70078;
update npc set change_head = 1 where npcid = 70079;
update npc set change_head = 1 where npcid = 70080;
update npc set change_head = 1 where npcid = 70079;
update npc set change_head = 1 where npcid = 70081;
update npc set change_head = 1 where npcid = 70082;
update npc set change_head = 1 where npcid = 70083;
update npc set change_head = 1 where npcid = 70084;
update npc set change_head = 1 where npcid = 70085;
update npc set change_head = 1 where npcid = 70086;
update npc set change_head = 1 where npcid = 70087;
update npc set change_head = 1 where npcid = 70088;
update npc set change_head = 1 where npcid = 70089;
update npc set change_head = 1 where npcid = 70090;
update npc set change_head = 1 where npcid = 70091;
update npc set change_head = 1 where npcid = 70092;
update npc set change_head = 1 where npcid = 70093;
update npc set change_head = 1 where npcid = 70094;
update npc set change_head = 1 where npcid = 70095;
update npc set change_head = 1 where npcid = 70096;
update npc set change_head = 1 where npcid = 70097;
update npc set change_head = 1 where npcid = 70098;
update npc set change_head = 1 where npcid = 70099;
update npc set change_head = 1 where npcid = 70100;
update npc set change_head = 1 where npcid = 70101;
update npc set change_head = 1 where npcid = 70102;
update npc set change_head = 1 where npcid = 70503;
update npc set change_head = 1 where npcid = 70504;
update npc set change_head = 1 where npcid = 70506;
update npc set change_head = 1 where npcid = 70507;
update npc set change_head = 1 where npcid = 70508;
update npc set change_head = 1 where npcid = 70509;
update npc set change_head = 1 where npcid = 70510;
update npc set change_head = 1 where npcid = 70511;
update npc set change_head = 1 where npcid = 70512;
update npc set change_head = 1 where npcid = 70514;
update npc set change_head = 1 where npcid = 70517;
update npc set change_head = 1 where npcid = 70518;
update npc set change_head = 1 where npcid = 70519;
update npc set change_head = 1 where npcid = 70520;
update npc set change_head = 1 where npcid = 70523;
update npc set change_head = 1 where npcid = 70524;
update npc set change_head = 1 where npcid = 70525;
update npc set change_head = 1 where npcid = 70526;
update npc set change_head = 1 where npcid = 70528;
update npc set change_head = 1 where npcid = 70529;
update npc set change_head = 1 where npcid = 70530;
update npc set change_head = 1 where npcid = 70531;
update npc set change_head = 1 where npcid = 70532;
update npc set change_head = 1 where npcid = 70534;
update npc set change_head = 1 where npcid = 70536;
update npc set change_head = 1 where npcid = 70537;
update npc set change_head = 1 where npcid = 70538;
update npc set change_head = 1 where npcid = 70544;
update npc set change_head = 1 where npcid = 70545;
update npc set change_head = 1 where npcid = 70546;
update npc set change_head = 1 where npcid = 70547;
update npc set change_head = 1 where npcid = 70550;
update npc set change_head = 1 where npcid = 70553;
update npc set change_head = 1 where npcid = 70554;
update npc set change_head = 1 where npcid = 70555;
update npc set change_head = 1 where npcid = 70556;
update npc set change_head = 1 where npcid = 70560;
update npc set change_head = 1 where npcid = 70562;
update npc set change_head = 1 where npcid = 70567;
update npc set change_head = 1 where npcid = 70568;
update npc set change_head = 1 where npcid = 70572;
update npc set change_head = 1 where npcid = 70576;
update npc set change_head = 1 where npcid = 70577;
update npc set change_head = 1 where npcid = 70581;
update npc set change_head = 1 where npcid = 70582;
update npc set change_head = 1 where npcid = 70583;
update npc set change_head = 1 where npcid = 70586;
update npc set change_head = 1 where npcid = 70589;
update npc set change_head = 1 where npcid = 70591;
update npc set change_head = 1 where npcid = 70592;
update npc set change_head = 1 where npcid = 70593;
update npc set change_head = 1 where npcid = 70594;
update npc set change_head = 1 where npcid = 70598;
update npc set change_head = 1 where npcid = 70599;
update npc set change_head = 1 where npcid = 70601;
update npc set change_head = 1 where npcid = 70604;
update npc set change_head = 1 where npcid = 70605;
update npc set change_head = 1 where npcid = 70606;
update npc set change_head = 1 where npcid = 70607;
update npc set change_head = 1 where npcid = 70608;
update npc set change_head = 1 where npcid = 70611;
update npc set change_head = 1 where npcid = 70614;
update npc set change_head = 1 where npcid = 70615;
update npc set change_head = 1 where npcid = 70616;
update npc set change_head = 1 where npcid = 70617;
update npc set change_head = 1 where npcid = 70619;
update npc set change_head = 1 where npcid = 70621;
update npc set change_head = 1 where npcid = 70622;
update npc set change_head = 1 where npcid = 70623;
update npc set change_head = 1 where npcid = 70624;
update npc set change_head = 1 where npcid = 70626;
update npc set change_head = 1 where npcid = 70630;
update npc set change_head = 1 where npcid = 70631;
update npc set change_head = 1 where npcid = 70632;
update npc set change_head = 1 where npcid = 70633;
update npc set change_head = 1 where npcid = 70634;
update npc set change_head = 1 where npcid = 70637;
update npc set change_head = 1 where npcid = 70639;
update npc set change_head = 1 where npcid = 70640;
update npc set change_head = 1 where npcid = 70641;
update npc set change_head = 1 where npcid = 70642;
update npc set change_head = 1 where npcid = 70644;
update npc set change_head = 1 where npcid = 70647;
update npc set change_head = 1 where npcid = 70648;
update npc set change_head = 1 where npcid = 70653;
update npc set change_head = 1 where npcid = 70654;
update npc set change_head = 1 where npcid = 70655;
update npc set change_head = 1 where npcid = 70657;
update npc set change_head = 1 where npcid = 70658;
update npc set change_head = 1 where npcid = 70659;
update npc set nameid = '$2931 $2930', gfxid = 1997, change_head = 1 where npcid = 70660;
update npc set nameid = '$2931 $2928', gfxid = 1997, change_head = 1 where npcid = 70661;
update npc set change_head = 1 where npcid = 70662;
update npc set change_head = 1 where npcid = 70663;
update npc set change_head = 1 where npcid = 70664;
update npc set change_head = 1 where npcid = 70665;
update npc set change_head = 1 where npcid = 70666;
update npc set change_head = 1 where npcid = 70667;
update npc set change_head = 1 where npcid = 70671;
update npc set lawful = -1000, change_head = 1 where npcid = 70674;
update npc set change_head = 1 where npcid = 70676;
update npc set change_head = 1 where npcid = 70683;
update npc set change_head = 1 where npcid = 70686;
update npc set change_head = 1 where npcid = 70690;
update npc set change_head = 1 where npcid = 70692;
update npc set change_head = 1 where npcid = 70695;
update npc set change_head = 1 where npcid = 70701;
update npc set change_head = 1 where npcid = 70702;
update npc set lawful = 10000, change_head = 1 where npcid = 70707;
update npc set change_head = 1 where npcid = 70711;
update npc set change_head = 1 where npcid = 70715;
update npc set change_head = 1 where npcid = 70721;
update npc set change_head = 1 where npcid = 70722;
update npc set change_head = 1 where npcid = 70723;
update npc set change_head = 1 where npcid = 70724;
update npc set change_head = 1 where npcid = 70725;
update npc set change_head = 1 where npcid = 70735;
update npc set change_head = 1 where npcid = 70736;
update npc set change_head = 1 where npcid = 70739;
update npc set change_head = 1 where npcid = 70740;
update npc set change_head = 1 where npcid = 70741;
update npc set change_head = 1 where npcid = 70742;
update npc set change_head = 1 where npcid = 70744;
update npc set change_head = 1 where npcid = 70746;
update npc set change_head = 1 where npcid = 70748;
update npc set change_head = 1 where npcid = 70749;
update npc set change_head = 1 where npcid = 70751;
update npc set change_head = 1 where npcid = 70752;
update npc set change_head = 1 where npcid = 70757;
update npc set change_head = 1 where npcid = 70758;
update npc set change_head = 1 where npcid = 70760;
update npc set change_head = 1 where npcid = 70761;
update npc set change_head = 1 where npcid = 70762;
update npc set change_head = 1 where npcid = 70763;
update npc set change_head = 1 where npcid = 70764;
update npc set change_head = 1 where npcid = 70766;
update npc set change_head = 1 where npcid = 70770;
update npc set change_head = 1 where npcid = 70771;
update npc set change_head = 1 where npcid = 70773;
update npc set change_head = 1 where npcid = 70774;
update npc set change_head = 1 where npcid = 70775;
update npc set change_head = 1 where npcid = 70776;
update npc set change_head = 1 where npcid = 70777;
update npc set change_head = 1 where npcid = 70780;
update npc set change_head = 1 where npcid = 70781;
update npc set change_head = 1 where npcid = 70782;
update npc set change_head = 1 where npcid = 70783;
update npc set change_head = 1 where npcid = 70784;
update npc set change_head = 1 where npcid = 70788;
update npc set change_head = 1 where npcid = 70789;
update npc set change_head = 1 where npcid = 70790;
update npc set change_head = 1 where npcid = 70794;
update npc set change_head = 1 where npcid = 70796;
update npc set change_head = 1 where npcid = 70798;
update npc set change_head = 1 where npcid = 70799;
update npc set change_head = 1 where npcid = 70801;
update npc set change_head = 1 where npcid = 70802;
update npc set change_head = 1 where npcid = 70803;
update npc set change_head = 1 where npcid = 70804;
update npc set change_head = 1 where npcid = 70805;
update npc set change_head = 1 where npcid = 70806;
update npc set change_head = 1 where npcid = 70807;
update npc set change_head = 1 where npcid = 70809;
update npc set change_head = 1 where npcid = 70811;
update npc set change_head = 1 where npcid = 70812;
update npc set change_head = 1 where npcid = 70814;
update npc set change_head = 1 where npcid = 70815;
update npc set change_head = 1 where npcid = 70816;
update npc set change_head = 1 where npcid = 70819;
update npc set change_head = 1 where npcid = 70820;
update npc set change_head = 1 where npcid = 70821;
update npc set change_head = 1 where npcid = 70822;
update npc set change_head = 1 where npcid = 70823;
update npc set change_head = 1 where npcid = 70824;
update npc set change_head = 1 where npcid = 70825;
update npc set change_head = 1 where npcid = 70826;
update npc set change_head = 1 where npcid = 70828;
update npc set change_head = 1 where npcid = 70830;
update npc set change_head = 1 where npcid = 70831;
update npc set change_head = 1 where npcid = 70833;
update npc set change_head = 1 where npcid = 70834;
update npc set change_head = 1 where npcid = 70836;
update npc set change_head = 1 where npcid = 70837;
update npc set change_head = 1 where npcid = 70838;
update npc set change_head = 1 where npcid = 70839;
update npc set change_head = 1 where npcid = 70840;
update npc set change_head = 1 where npcid = 70841;
update npc set change_head = 1 where npcid = 70844;
update npc set change_head = 1 where npcid = 70847;
update npc set change_head = 1 where npcid = 70854;
update npc set lawful = 1800, passispeed = 960, atkspeed = 1540, atk_magic_speed = 1240, sub_magic_speed = 1240 where npcid = 70857;
update npc set change_head = 1 where npcid = 70858;
update npc set change_head = 1 where npcid = 70860;
update npc set change_head = 1 where npcid = 70861;
update npc set change_head = 1 where npcid = 70865;
update npc set change_head = 1 where npcid = 70867;
update npc set change_head = 1 where npcid = 70871;
update npc set change_head = 1 where npcid = 70873;
update npc set change_head = 1 where npcid = 70876;
update npc set change_head = 1 where npcid = 70877;
update npc set change_head = 1 where npcid = 70878;
update npc set change_head = 1 where npcid = 70880;
update npc set lawful = 1800 where npcid = 70881;
update npc set change_head = 1 where npcid = 70882;
update npc set change_head = 1 where npcid = 70884;
update npc set change_head = 1 where npcid = 70885;
update npc set change_head = 1 where npcid = 70886;
update npc set change_head = 1 where npcid = 70889;
update npc set change_head = 1 where npcid = 70890;
update npc set change_head = 1 where npcid = 70892;
update npc set change_head = 1 where npcid = 70894;
update npc set change_head = 1 where npcid = 70895;
update npc set change_head = 1 where npcid = 70896;
update npc set change_head = 1 where npcid = 70901;
update npc set change_head = 1 where npcid = 70903;
update npc set change_head = 1 where npcid = 70904;
update npc set change_head = 1 where npcid = 70906;
update npc set change_head = 1 where npcid = 70908;
update npc set change_head = 1 where npcid = 70909;
update npc set change_head = 1 where npcid = 70910;
update npc set change_head = 1 where npcid = 70912;
update npc set change_head = 1 where npcid = 70913;
update npc set change_head = 1 where npcid = 70916;
update npc set change_head = 1 where npcid = 70917;
update npc set change_head = 1 where npcid = 70919;
update npc set gfxid = 3787, change_head = 1 where npcid = 70922;
update npc set change_head = 1 where npcid = 70923;
update npc set change_head = 1 where npcid = 70924;
update npc set change_head = 1 where npcid = 70925;
update npc set change_head = 1 where npcid = 70927;
update npc set change_head = 1 where npcid = 70928;
update npc set impl = 'L1Quest', hp = 1, passispeed = 1400 where npcid = 70957;
update npc set impl = 'L1Merchant', change_head = 1 where npcid = 70928;
update npc set gfxid = 148, lvl = 10, lawful = 1800, ranged = 2 where npcid = 70992;
update npc set change_head = 1 where npcid = 70997;
update npc set change_head = 1 where npcid = 70998;
update npc set change_head = 1 where npcid = 70999;
update npc set change_head = 1 where npcid = 71000;
update npc set change_head = 1 where npcid = 71001;
update npc set change_head = 1 where npcid = 71002;
update npc set change_head = 1 where npcid = 71003;
update npc set change_head = 1 where npcid = 71004;
update npc set change_head = 1 where npcid = 71005;
update npc set change_head = 1 where npcid = 71006;
update npc set change_head = 1 where npcid = 71007;
update npc set change_head = 1 where npcid = 71009;
update npc set change_head = 1 where npcid = 71010;
update npc set change_head = 1 where npcid = 71011;
update npc set change_head = 1 where npcid = 71012;
update npc set change_head = 1 where npcid = 71013;
update npc set change_head = 1 where npcid = 71014;
update npc set change_head = 1 where npcid = 71015;
update npc set change_head = 1 where npcid = 71016;
update npc set change_head = 1 where npcid = 71017;
update npc set change_head = 1 where npcid = 71018;
update npc set change_head = 1 where npcid = 71019;
update npc set change_head = 1 where npcid = 71020;
update npc set change_head = 1 where npcid = 71021;
update npc set change_head = 1 where npcid = 71022;
update npc set change_head = 1 where npcid = 71023;
update npc set change_head = 1 where npcid = 71024;
update npc set change_head = 1 where npcid = 71025;
update npc set change_head = 1 where npcid = 71026;
update npc set change_head = 1 where npcid = 71027;
update npc set change_head = 1 where npcid = 71028;
update npc set change_head = 1 where npcid = 71029;
update npc set change_head = 1 where npcid = 71030;
update npc set change_head = 1 where npcid = 71031;
update npc set change_head = 1 where npcid = 71032;
update npc set change_head = 1 where npcid = 71033;
update npc set change_head = 1 where npcid = 71034;
update npc set change_head = 1 where npcid = 71035;
update npc set change_head = 1 where npcid = 71037;
update npc set change_head = 1 where npcid = 71038;
update npc set change_head = 1 where npcid = 71039;
update npc set change_head = 1 where npcid = 71040;
update npc set change_head = 1 where npcid = 71041;
update npc set change_head = 1 where npcid = 71042;
update npc set change_head = 1 where npcid = 71043;
update npc set change_head = 1 where npcid = 71044;
update npc set change_head = 1 where npcid = 71045;
update npc set change_head = 1 where npcid = 71046;
update npc set change_head = 1 where npcid = 71047;
update npc set change_head = 1 where npcid = 71048;
update npc set change_head = 1 where npcid = 71049;
update npc set change_head = 1 where npcid = 71050;
update npc set change_head = 1 where npcid = 71051;
update npc set change_head = 1 where npcid = 71052;
update npc set change_head = 1 where npcid = 71053;
update npc set change_head = 1 where npcid = 71054;
update npc set change_head = 1 where npcid = 71055;
update npc set change_head = 1 where npcid = 71056;
update npc set change_head = 1 where npcid = 71057;
update npc set change_head = 1 where npcid = 71058;
update npc set change_head = 1 where npcid = 71059;
update npc set change_head = 1 where npcid = 71060;
update npc set change_head = 1 where npcid = 71061;
update npc set impl = 'L1Quest', lvl = 1, hp = 1, size = 'small', passispeed = 1400, change_head = 1 where npcid = 71062;
update npc set change_head = 1 where npcid = 71074;
update npc set impl = 'L1Quest', lvl = 1, hp = 1, passispeed = 1400, change_head = 1 where npcid = 71075;
update npc set change_head = 1 where npcid = 71076;
update npc set change_head = 1 where npcid = 71077;
update npc set change_head = 1 where npcid = 71078;
update npc set change_head = 1 where npcid = 71079;
update npc set change_head = 1 where npcid = 71080;
update npc set change_head = 1 where npcid = 71089;
update npc set change_head = 1 where npcid = 71090;
update npc set change_head = 1 where npcid = 71091;
update npc set change_head = 1 where npcid = 71108;
update npc set change_head = 1 where npcid = 71109;
update npc set change_head = 1 where npcid = 71110;
update npc set change_head = 1 where npcid = 71111;
update npc set change_head = 1 where npcid = 71112;
update npc set change_head = 1 where npcid = 71113;
update npc set change_head = 1 where npcid = 71114;
update npc set change_head = 1 where npcid = 71118;
update npc set change_head = 1 where npcid = 71119;
update npc set change_head = 1 where npcid = 71120;
update npc set change_head = 1 where npcid = 71121;
update npc set change_head = 1 where npcid = 71122;
update npc set change_head = 1 where npcid = 71123;
update npc set change_head = 1 where npcid = 71124;
update npc set change_head = 1 where npcid = 71125;
update npc set change_head = 1 where npcid = 71126;
update npc set change_head = 1 where npcid = 71127;
update npc set change_head = 1 where npcid = 71128;
update npc set change_head = 1 where npcid = 71129;
update npc set change_head = 1 where npcid = 71130;
update npc set change_head = 1 where npcid = 71131;
update npc set change_head = 1 where npcid = 71132;
update npc set change_head = 1 where npcid = 71133;
update npc set change_head = 1 where npcid = 71134;
update npc set change_head = 1 where npcid = 71135;
update npc set change_head = 1 where npcid = 71136;
update npc set change_head = 1 where npcid = 71137;
update npc set change_head = 1 where npcid = 71138;
update npc set change_head = 1 where npcid = 71139;
update npc set change_head = 1 where npcid = 71140;
update npc set change_head = 1 where npcid = 71141;
update npc set change_head = 1 where npcid = 71142;
update npc set change_head = 1 where npcid = 71143;
update npc set change_head = 1 where npcid = 71144;
update npc set change_head = 1 where npcid = 71145;
update npc set change_head = 1 where npcid = 71146;
update npc set change_head = 1 where npcid = 71147;
update npc set change_head = 1 where npcid = 71148;
update npc set change_head = 1 where npcid = 71149;
update npc set change_head = 1 where npcid = 71150;
update npc set change_head = 1 where npcid = 71151;
update npc set change_head = 1 where npcid = 71152;
update npc set change_head = 1 where npcid = 71153;
update npc set change_head = 1 where npcid = 71154;
update npc set change_head = 1 where npcid = 71155;
update npc set change_head = 1 where npcid = 71156;
update npc set change_head = 1 where npcid = 71157;
update npc set change_head = 1 where npcid = 71158;
update npc set change_head = 1 where npcid = 71159;
update npc set change_head = 1 where npcid = 71160;
update npc set change_head = 1 where npcid = 71161;
update npc set change_head = 1 where npcid = 71162;
update npc set change_head = 1 where npcid = 71163;
update npc set change_head = 1 where npcid = 71164;
update npc set change_head = 1 where npcid = 71165;
update npc set change_head = 1 where npcid = 71166;
update npc set change_head = 1 where npcid = 71167;
update npc set change_head = 1 where npcid = 71168;
update npc set change_head = 1 where npcid = 71169;
update npc set change_head = 1 where npcid = 71170;
update npc set change_head = 1 where npcid = 71171;
update npc set change_head = 1 where npcid = 71172;
update npc set change_head = 1 where npcid = 71173;
update npc set change_head = 1 where npcid = 71174;
update npc set change_head = 1 where npcid = 71175;
update npc set change_head = 1 where npcid = 71176;
update npc set change_head = 1 where npcid = 71177;
update npc set change_head = 1 where npcid = 71178;
update npc set change_head = 1 where npcid = 71179;
update npc set change_head = 1 where npcid = 71180;
update npc set change_head = 1 where npcid = 71181;
update npc set change_head = 1 where npcid = 71182;
update npc set change_head = 1 where npcid = 71184;
update npc set change_head = 1 where npcid = 71187;
update npc set change_head = 1 where npcid = 71188;
update npc set change_head = 1 where npcid = 71189;
update npc set change_head = 1 where npcid = 71190;
update npc set change_head = 1 where npcid = 71191;
update npc set change_head = 1 where npcid = 71192;
update npc set change_head = 1 where npcid = 71193;
update npc set change_head = 1 where npcid = 71194;
update npc set change_head = 1 where npcid = 71195;
update npc set change_head = 1 where npcid = 71196;
update npc set size = 'small', change_head = 1 where npcid = 71197;
update npc set change_head = 1 where npcid = 71198;
update npc set lvl = 0, size = '', family = '', change_head = 1 where npcid = 71199;
update npc set nameid = '$5521', change_head = 1 where npcid = 71200;
update npc set impl = 'L1FieldObject' where npcid = 80005;
update npc set change_head = 1 where npcid = 80019;
update npc set change_head = 1 where npcid = 80020;
update npc set change_head = 1 where npcid = 80021;
update npc set change_head = 1 where npcid = 80022;
update npc set change_head = 1 where npcid = 80023;
update npc set change_head = 1 where npcid = 80024;
update npc set change_head = 1 where npcid = 80025;
update npc set change_head = 1 where npcid = 80026;
update npc set change_head = 1 where npcid = 80027;
update npc set change_head = 1 where npcid = 80028;
update npc set change_head = 1 where npcid = 80029;
update npc set change_head = 1 where npcid = 80030;
update npc set change_head = 1 where npcid = 80031;
update npc set change_head = 1 where npcid = 80032;
update npc set change_head = 1 where npcid = 80033;
update npc set change_head = 1 where npcid = 80034;
update npc set change_head = 1 where npcid = 80035;
update npc set change_head = 1 where npcid = 80036;
update npc set change_head = 1 where npcid = 80037;
update npc set change_head = 1 where npcid = 80038;
update npc set change_head = 1 where npcid = 80039;
update npc set change_head = 1 where npcid = 80040;
update npc set change_head = 1 where npcid = 80041;
update npc set change_head = 1 where npcid = 80042;
update npc set change_head = 1 where npcid = 80043;
update npc set change_head = 1 where npcid = 80044;
update npc set change_head = 1 where npcid = 80045;
update npc set change_head = 1 where npcid = 80047;
update npc set change_head = 1 where npcid = 80048;
update npc set change_head = 1 where npcid = 80049;
update npc set change_head = 1 where npcid = 80050;
update npc set change_head = 1 where npcid = 80051;
update npc set change_head = 1 where npcid = 80052;
update npc set change_head = 1 where npcid = 80053;
update npc set change_head = 1 where npcid = 80054;
update npc set change_head = 1 where npcid = 80055;
update npc set change_head = 1 where npcid = 80056;
update npc set change_head = 1 where npcid = 80057;
update npc set change_head = 1 where npcid = 80064;
update npc set change_head = 1 where npcid = 80065;
update npc set change_head = 1 where npcid = 80066;
update npc set change_head = 1 where npcid = 80067;
update npc set change_head = 1 where npcid = 80068;
update npc set change_head = 1 where npcid = 80069;
update npc set change_head = 1 where npcid = 80070;
update npc set change_head = 1 where npcid = 80071;
update npc set change_head = 1 where npcid = 80072;
update npc set change_head = 1 where npcid = 80073;
update npc set change_head = 1 where npcid = 80074;
update npc set change_head = 1 where npcid = 80075;
update npc set change_head = 1 where npcid = 80076;
update npc set gfxid = 3948, change_head = 1 where npcid = 80077;
update npc set change_head = 1 where npcid = 80078;
update npc set change_head = 1 where npcid = 80079;
update npc set change_head = 1 where npcid = 80080;
update npc set change_head = 1 where npcid = 80081;
update npc set change_head = 1 where npcid = 80082;
update npc set change_head = 1 where npcid = 80083;
update npc set change_head = 1 where npcid = 80084;
update npc set change_head = 1 where npcid = 80085;
update npc set change_head = 1 where npcid = 80086;
update npc set change_head = 1 where npcid = 80087;
update npc set change_head = 1 where npcid = 80088;
update npc set change_head = 1 where npcid = 80089;
update npc set change_head = 1 where npcid = 80090;
update npc set change_head = 1 where npcid = 80091;
update npc set change_head = 1 where npcid = 80092;
update npc set change_head = 1 where npcid = 80093;
update npc set change_head = 1 where npcid = 80094;
update npc set change_head = 1 where npcid = 80095;
update npc set change_head = 1 where npcid = 80096;
update npc set change_head = 1 where npcid = 80097;
update npc set change_head = 1 where npcid = 80098;
update npc set change_head = 1 where npcid = 80099;
update npc set change_head = 1 where npcid = 80100;
update npc set change_head = 1 where npcid = 80101;
update npc set change_head = 1 where npcid = 80102;
update npc set change_head = 1 where npcid = 80103;
update npc set change_head = 1 where npcid = 80104;
update npc set change_head = 1 where npcid = 80105;
update npc set change_head = 1 where npcid = 80127;
update npc set change_head = 1 where npcid = 80128;
update npc set undead = 5 where npcid = 81091;
update npc set lawful = -1000 where npcid = 81112;
update npc set lawful = -300000 where npcid = 81114;
update npc set change_head = 1 where npcid = 81119;
update npc set gfxid = 4263, change_head = 1 where npcid = 81120;
update npc set change_head = 1 where npcid = 81121;
update npc set nameid = '$2063', change_head = 1 where npcid = 81123;
update npc set nameid = '$2063', change_head = 1 where npcid = 81124;
update npc set change_head = 1 where npcid = 81155;
update npc set exp = 2 where npcid = 81159;
update npc set atkspeed = 2180, atk_magic_speed = 2180, sub_magic_speed = 2180, hard = 1 where npcid = 81163;
update npc set karma = 0, transform_id = -1 where npcid = 81177;
update npc set karma = 0, transform_id = -1 where npcid = 81178;
update npc set karma = 0, transform_id = -1 where npcid = 81179;
update npc set karma = 0, transform_id = -1 where npcid = 81180;
update npc set karma = 0, transform_id = -1 where npcid = 81181;

-- Add new NPCs.
INSERT INTO `npc` VALUES (46108, 'Mandragora', '$5492', '', 'L1Monster', 6557, 26, 320, 50, -15, 13, 12, 13, 10, 10, 50, 677, -18, 'small', 4, 1, 0, 480, 1600, 0, 1600, 1600, 0, 0, 0, 0, 0, 0, 'tebe_m', 0, -1, -1, 0, 0, 0, 5000, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46109, 'Scarab', '$5493', '', 'L1Monster', 6592, 29, 400, 70, -25, 15, 15, 14, 10, 10, 60, 842, -20, 'small', 2, 1, 0, 600, 920, 0, 920, 920, 0, 0, 0, 0, 0, 0, 'tebe_s', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46110, 'Scarab', '$5493', '', 'L1Monster', 6593, 32, 480, 70, -25, 15, 15, 15, 11, 11, 65, 1025, -20, 'small', 4, 1, 0, 600, 920, 0, 920, 920, 0, 0, 0, 1, 1, 0, 'tebe_s', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46111, 'Kalbis', '$5494', '', 'L1Monster', 6601, 35, 480, 70, -20, 17, 15, 15, 12, 12, 66, 1226, -22, 'small', 2, 1, 0, 640, 800, 1280, 800, 800, 0, 1, 0, 0, 0, 0, 'tebe_k', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46112, 'Kalbis', '$5494', '', 'L1Monster', 6603, 39, 600, 72, -25, 17, 16, 15, 12, 12, 66, 1522, -25, 'small', 8, 1, 0, 600, 800, 1280, 800, 800, 0, 1, 0, 1, 1, 0, 'tebe_k', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46113, 'Obelisk', '$5495', '', 'L1Monster', 6645, 41, 700, 92, -25, 23, 19, 10, 13, 18, 80, 1682, -25, 'large', 8, 1, 0, 1280, 1840, 0, 1840, 1840, 0, 0, 0, 0, 0, 0, 'tebe_o', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46114, 'Obelisk', '$5495', '', 'L1Monster', 6649, 44, 800, 100, -25, 23, 22, 10, 13, 18, 80, 1937, -28, 'large', 4, 1, 0, 1280, 1840, 0, 1840, 1840, 0, 0, 0, 0, 0, 1, 'tebe_o', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46115, 'Sphinx', '$5496', '', 'L1Monster', 6699, 47, 880, 115, -29, 24, 18, 18, 21, 19, 100, 2210, -28, 'large', 0, 2, 0, 720, 1240, 1440, 1240, 1240, 0, 0, 0, 0, 0, 0, 'tebe_sf', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46116, 'Sphinx', '$5496', '', 'L1Monster', 6704, 50, 1120, 140, -32, 24, 19, 19, 21, 21, 100, 2501, -32, 'large', 2, 2, 0, 720, 1240, 1440, 1240, 1240, 0, 0, 0, 1, 1, 1, 'tebe_sf', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46117, 'Horus Falcon', '$5497', '', 'L1Monster', 6664, 50, 900, 250, -20, 20, 15, 18, 18, 17, 60, 2501, -32, 'small', 4, 1, 0, 640, 1280, 0, 1280, 1280, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46118, 'Horus Falcon', '$5497', '', 'L1Monster', 6665, 52, 1120, 200, -30, 20, 15, 18, 18, 17, 60, 2705, -32, 'small', 2, 1, 0, 640, 1280, 0, 1280, 1280, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46119, 'Thebes Guardian', '$5499', '', 'L1Monster', 6653, 54, 1200, 1200, -40, 24, 17, 20, 15, 16, 65, 2917, -34, 'small', 0, 2, 0, 640, 880, 1720, 1720, 1720, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46120, 'Thebes Guardian', '$5499', '', 'L1Monster', 6654, 56, 1300, 1300, -40, 24, 17, 20, 15, 16, 65, 3137, -34, 'small', 0, 2, 0, 640, 880, 1720, 1720, 1720, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46121, 'Thebes Elder', '$5498', '', 'L1Monster', 6562, 58, 1400, 190, -30, 18, 18, 19, 21, 18, 70, 3365, -37, 'small', 0, 1, 0, 600, 920, 1240, 960, 960, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46122, 'Thebes Elder', '$5498', '', 'L1Monster', 6563, 60, 1500, 100, -30, 18, 18, 19, 21, 18, 70, 3601, -37, 'small', 0, 1, 0, 600, 920, 1240, 960, 960, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46123, 'Thebes Horus', '$5501', '', 'L1Monster', 6569, 70, 20000, 100, -140, 70, 22, 21, 21, 22, 80, 4901, -315, 'large', 8, 1, 0, 600, 1720, 1760, 960, 1720, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46124, 'Thebes Anubis', '$5500', '', 'L1Monster', 6595, 70, 25000, 100, -140, 75, 22, 21, 21, 23, 80, 4901, -315, 'large', 1, 1, 0, 600, 1800, 1400, 1600, 1600, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 5000, 5000, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46125, 'Iron Golem', '$1789', '', 'L1Monster', 6638, 43, 566, 10, -29, 70, 30, 8, 5, 5, 50, 1850, -28, 'large', 0, 1, 0, 1920, 1760, 1320, 1760, 1760, 0, 0, 0, 1, 1, 1, 'golem', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46126, 'Lycanthrope', '$990', '', 'L1Monster', 6636, 39, 538, 60, -26, 16, 16, 13, 10, 10, 25, 1522, -24, 'small', 0, 1, 0, 640, 800, 720, 800, 800, 5, 0, 0, 1, 1, 1, 'wolf', 1, -1, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46127, 'Owlbear', '$1047', '', 'L1Monster', 6634, 41, 552, 200, -27, 18, 13, 14, 7, 8, 20, 1682, -26, 'large', 0, 1, 1, 960, 1080, 0, 1080, 1080, 0, 0, 0, 1, 1, 1, 'bear', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46128, 'Snow Tiger', '$1784', '', 'L1Monster', 6632, 42, 554, 0, -18, 19, 18, 16, 12, 10, 0, 1765, -27, 'large', 0, 1, 0, 960, 1360, 800, 1360, 1360, 0, 0, 0, 1, 1, 1, 'tiger', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46129, 'Snowman', '$1783', '', 'L1Monster', 2064, 37, 444, 0, -25, 14, 16, 10, 6, 8, 0, 1370, -22, 'small', 0, 1, 1, 1280, 1080, 1200, 1080, 1080, 0, 0, 0, 1, 1, 1, 'snowman', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46130, 'Yeti', '$1786', '', 'L1Monster', 2134, 44, 528, 10, -29, 16, 20, 12, 9, 6, 22, 1937, -29, 'large', 0, 1, 0, 960, 1400, 1360, 1400, 1400, 0, 0, 0, 1, 1, 1, 'yeti', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46131, 'Ghost', '$1563', '', 'L1Monster', 1321, 46, 644, 10, -31, 11, 11, 11, 9, 13, 5, 2117, -31, 'small', 0, 1, 1, 960, 1000, 1440, 1000, 1000, 1, 0, 0, 1, 1, 1, 'ghost', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46132, 'Ghost', '$1563', '', 'L1Monster', 1318, 48, 672, 10, -32, 11, 11, 11, 9, 13, 23, 2305, -33, 'small', 0, 1, 0, 960, 1000, 1440, 1000, 1000, 1, 0, 0, 1, 1, 1, 'ghost', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46133, 'Ice Golem', '$1395', '', 'L1Monster', 1525, 47, 573, 0, -31, 46, 16, 10, 5, 6, 7, 2210, -32, 'large', 0, 1, 1, 1920, 1480, 1680, 1480, 1480, 0, 0, 0, 1, 1, 1, 'golem', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46134, 'Ice Man', '$1791', '', 'L1Monster', 4915, 48, 586, 20, -30, 17, 17, 17, 12, 12, 21, 2305, -33, 'large', 0, 1, 1, 960, 1600, 960, 1600, 1600, 0, 0, 0, 1, 1, 1, 'iceman', 1, -1, -1, 0, 0, 0, 5000, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46135, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6560, 50, 610, 30, -34, 18, 20, 30, 18, 18, 50, 2501, -35, 'large', 0, 2, 1, 960, 1320, 920, 2080, 2080, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 5000, 30, 5000, 10, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46136, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6558, 40, 800, 30, -50, 18, 20, 30, 18, 18, 50, 2501, -35, 'large', 0, 10, 0, 0, 1920, 920, 2280, 2280, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 5000, 30, 5000, 10, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46137, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6560, 52, 742, 30, -36, 18, 20, 30, 18, 18, 50, 2501, -35, 'large', 0, 2, 1, 960, 1320, 920, 2080, 2080, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 30, 5000, 10, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46138, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6558, 50, 560, 30, -30, 18, 20, 30, 18, 18, 25, 2501, -35, 'large', 0, 10, 0, 640, 1920, 920, 2280, 2280, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 5000, 30, 5000, 10, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46139, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6558, 40, 800, 30, -50, 18, 20, 30, 18, 18, 50, 2501, -35, 'large', 0, 10, 0, 640, 1920, 920, 2280, 2280, 0, 0, 0, 1, 1, 1, '', 1, -1, -1, 0, 0, 0, 5000, 30, 5000, 10, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46140, 'Maid of the Ice Queen', '$2218', '', 'L1Monster', 2118, 10, 1000, 400, -35, 30, 18, 20, 18, 18, 60, 0, -120, 'small', 0, 1, 0, 960, 1320, 0, 1320, 1320, 0, 0, 0, 1, 1, 1, 'icequeen', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0);
INSERT INTO `npc` VALUES (46141, 'Ice Queen', '$1771', '', 'L1Monster', 6581, 70, 10000, 400, -80, 40, 25, 30, 28, 28, 90, 5000, -1000, 'small', 0, 1, 0, 960, 1320, 0, 1320, 1320, 0, 0, 0, 1, 1, 1, 'icequeen', 1, -1, -1, 0, 0, 0, 5000, 400, 5000, 250, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1);
INSERT INTO `npc` VALUES (46142, 'Ice Demon', '$5525', '', 'L1Monster', 6566, 65, 7000, 450, -70, 30, 25, 25, 25, 25, 80, 3600, -1000, 'small', 0, 1, 0, 640, 720, 880, 900, 960, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 250, 5000, 250, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1);
INSERT INTO `npc` VALUES (46143, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6558, 45, 540, 10, -30, 18, 20, 30, 18, 18, 0, 2026, -30, 'large', 0, 12, 0, 0, 1720, 920, 2280, 2280, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46144, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6558, 52, 642, 10, -36, 18, 20, 30, 18, 18, 27, 2705, -38, 'large', 0, 12, 0, 0, 1720, 920, 2280, 2280, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46145, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6558, 52, 642, 10, -36, 18, 20, 30, 18, 18, 27, 2705, -38, 'large', 0, 12, 0, 0, 1720, 920, 2280, 2280, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46146, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6558, 52, 642, 10, -36, 18, 20, 30, 18, 18, 27, 2705, -38, 'large', 0, 12, 0, 0, 1720, 920, 2280, 2280, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46147, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6558, 52, 642, 10, -36, 18, 20, 30, 18, 18, 27, 2705, -38, 'large', 0, 12, 0, 0, 1720, 920, 2280, 2280, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46148, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6558, 52, 642, 10, -36, 18, 20, 30, 18, 18, 27, 2705, -38, 'large', 0, 12, 0, 0, 1720, 920, 2280, 2280, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46149, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6558, 52, 642, 10, -36, 18, 20, 30, 18, 18, 27, 2705, -38, 'large', 0, 12, 0, 0, 1720, 920, 2280, 2280, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46150, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6558, 52, 642, 10, -36, 18, 20, 30, 18, 18, 27, 2705, -38, 'large', 0, 12, 0, 0, 1720, 920, 2280, 2280, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46151, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6558, 52, 642, 10, -36, 18, 20, 30, 18, 18, 27, 2705, -38, 'large', 0, 12, 0, 0, 1720, 920, 2280, 2280, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46152, 'Ice Queen Royal Guard', '$5502', '', 'L1Monster', 6558, 52, 642, 10, -36, 18, 20, 30, 18, 18, 27, 2705, -38, 'large', 0, 12, 0, 0, 1720, 920, 2280, 2280, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 66, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46153, 'Yeti', '$1786', '', 'L1Monster', 2134, 49, 598, 10, -33, 18, 20, 12, 9, 6, 24, 2402, -34, 'large', 0, 1, 0, 960, 1400, 1360, 1400, 1400, 0, 0, 0, 1, 1, 1, 'yeti', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46154, 'Yeti', '$1786', '', 'L1Monster', 2134, 51, 720, 10, -35, 20, 20, 12, 9, 6, 26, 2602, -36, 'large', 0, 1, 0, 960, 1400, 1360, 1400, 1400, 0, 0, 0, 1, 1, 1, 'yeti', 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46155, 'Ice Man', '$1791', '', 'L1Monster', 4915, 50, 700, 20, -34, 17, 17, 17, 12, 12, 25, 2501, -37, 'large', 0, 1, 1, 960, 1600, 960, 1600, 1600, 0, 0, 0, 1, 1, 1, 'iceman', 1, -1, -1, 0, 0, 0, 5000, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46156, 'Succubus Queen', '$1019', '', 'L1Monster', 1116, 60, 30000, 400, -32, 17, 17, 18, 25, 18, 80, 0, -50, 'small', 2, 1, 0, 640, 800, 1080, 1100, 800, 2, 0, 0, 1, 1, 1, 'succubus', 0, -1, -1, 0, 0, 0, 5000, 500, 5000, 400, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46162, 'Elmore Zombie Commander', '$5650', '', 'L1Monster', 6776, 25, 180, 0, -18, 17, 18, 15, 12, 10, 10, 626, -25, 'large', 2, 1, 1, 960, 1200, 1280, 1200, 1200, 1, 0, 0, 1, 0, 0, '', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (46163, 'Vengeful Spirit of Commander of Elmore Solsheica', '$5651', '', 'L1Monster', 6778, 25, 180, 0, -18, 17, 18, 15, 12, 10, 10, 626, -25, 'large', 2, 1, 1, 960, 1200, 1280, 1200, 1200, 1, 0, 0, 1, 0, 0, '', 0, -1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (71247, 'Flag', 'type A', '', 'L1FieldObject', 1449, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (71248, 'Flag', 'type B', '', 'L1FieldObject', 1450, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (71249, '', 'torch', 'right', 'L1FieldObject', 86, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0);
INSERT INTO `npc` VALUES (71250, '', 'torch', 'left', 'L1FieldObject', 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0);
INSERT INTO `npc` VALUES (71252, 'Joe\'s Stone Golem', '$5526', '', 'L1Merchant', 6685, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);
INSERT INTO `npc` VALUES (71253, 'Joe\'s Stone Golem', '$5526', '', 'L1Merchant', 6685, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);
INSERT INTO `npc` VALUES (71262, 'butterfly', '', '', 'L1Monster', 2889, 1, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 2000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (71263, 'butterfly', '', '', 'L1Monster', 2891, 1, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 2000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (71264, 'Shiren', '$4883', '', 'L1Merchant', 2090, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);
INSERT INTO `npc` VALUES (71265, 'Sin Warrior', '$1504', '', 'L1Merchant', 1659, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1800, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 10, 0, 0, 0);
INSERT INTO `npc` VALUES (71266, 'Heine Mercenary Squad', '$1513 $2928', 'can change head', 'L1Merchant', 1659, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1800, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);
INSERT INTO `npc` VALUES (71267, '', '', 'Elven Forest house light', 'L1FieldObject', 874, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 10, 0, 0, 0);
INSERT INTO `npc` VALUES (71268, '', 'weapon bags', 'Desert shop', 'L1FieldObject', 120, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (71269, '', '', 'Desert pool', 'L1FieldObject', 1055, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (71270, 'rune wall', '', '', 'L1FieldObject', 136, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (71272, 'rune wall', '', '', 'L1FieldObject', 264, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (80129, '', '$5414', '', 'L1Doll', 6443, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 320, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0);
INSERT INTO `npc` VALUES (80130, '', '$5415', '', 'L1Doll', 6449, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 320, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0);
INSERT INTO `npc` VALUES (80131, '', '$5416', '', 'L1Doll', 6452, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 'small', 0, 0, 0, 320, 0, 0, 1000, 1000, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0);
INSERT INTO `npc` VALUES (80149, '', '', '', 'L1Effect', 6706, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (80150, '', '', '', 'L1Effect', 6712, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (80151, '', '', '', 'L1Effect', 6718, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (80152, '', '', '', 'L1Effect', 6724, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81241, '', '', '', 'L1Merchant', 98, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);
INSERT INTO `npc` VALUES (81242, '', '', '', 'L1Merchant', 98, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);
INSERT INTO `npc` VALUES (81243, '', '', '', 'L1Merchant', 98, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);
INSERT INTO `npc` VALUES (81244, '', '', '', 'L1Merchant', 98, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);

-- Fix turtle island scroll name.
update etcitem set name = 'Scroll of Teleportation - Turtle Island', unidentified_name_id = '$230 - Turtle Island', identified_name_id = '$230 - Turtle Island' where item_id = 240102;

-- Necro group often ends up never respawning due to some ghoul or floating eye
-- that no one ever kills.  This solves that.
update mobgroup set remove_group_if_leader_die = 1 where id = 15;

-- Merged weapon table.
-- Blade of Revenge
update weapon set dmg_small = 4, dmg_large = 36 where item_id = 16;
-- Sealed Forgotten Great Sword
update weapon set dmg_small = 3, dmg_large = 6, hitmodifier = 3, dmgmodifier =
3 where item_id = 16;
-- Sword of Red Desire
update weapon set add_hpr = -3 where item_id = 34;
-- Large Sword of Blood
update weapon set dmg_small = 13, dmg_large = 15 where item_id = 40;
-- IT Two Handed Sword
update weapon set dmg_small = 15, dmg_large = 15 where item_id = 48;
-- Two Handed Sword
update weapon set dmg_small = 17, dmg_large = 21 where item_id = 52;
-- Sword of Brave Lizardman Soldier
update weapon set dmg_small = 17, dmg_large = 21 where item_id = 53;
-- Fire Sword of Death Knight
update weapon set canbedmg = 1 where item_id = 58;
-- Executuion Sword of Fidelity
update weapon set dmg_small = 28, dmg_large = 33 where item_id = 61;
-- Two-Handed Sword of Pretender King
update weapon set weight = 150000, grdgfx = 4954, dmg_small = 19, dmg_large =
23, dmgmodifier = 5 where item_id = 62;
-- Great Sword
update weapon set dmg_small = 20, dmg_large = 17 where item_id = 64;
-- Sword of Heaven
update weapon set cant_delete = 1 where item_id = 65;
-- Dragon Slayer
update weapon set dmg_small = 24, dmg_large = 33 where item_id = 66;
-- Ancient Great Sword
update weapon set dmg_small = 27, dmg_large = 45 where item_id = 67;
-- Edoryu of Abyss
update weapon set double_dmg_chance = 25 where item_id = 79;
-- Lastavard Edoryu
update weapon set double_dmg_chance = 25 where item_id = 82;
-- Devil's Edoryu
update weapon set double_dmg_chance = 25 where item_id = 85;
-- Bardiche
update weapon set dmg_small = 10, dmg_large = 12 where item_id = 90;
-- Bill-guisarme
update weapon set dmg_small = 10, dmg_large = 17 where item_id = 92;
-- Guisarme
update weapon set dmg_small = 12, dmg_large = 14 where item_id = 97;
-- Glaive
update weapon set dmg_small = 12, dmg_large = 16 where item_id = 98;
-- Lucern Hammer
update weapon set dmg_small = 15, dmg_large = 17 where item_id = 102;
-- Halbred
update weapon set dmg_small = 16, dmg_large = 12 where item_id = 103;
-- Fauchard
update weapon set dmg_small = 16, dmg_large = 16 where item_id = 104;
-- Ivory Tower Spear
update weapon set dmg_small = 16, dmg_large = 17 where item_id = 105;
-- Bec de Corbin
update weapon set dmg_small = 17, dmg_large = 17 where item_id = 106;
-- Crimson Lance
update weapon set dmg_small = 21, dmg_large = 21, hitmodifier = 4 where item_id
= 107;
-- Wand of Laia
update weapon set add_sp = -2 where item_id = 117;
-- Wisdom of the Ancient People
update weapon set cant_delete = 1 where item_id = 133;
-- War Hammer
update weapon set dmg_small = 17, dmg_large = 19 where item_id = 141;
-- Silver Axe
update weapon set dmg_small = 17, dmg_large = 24 where item_id = 142;
-- Battle Axe
update weapon set dmg_small = 18, dmg_large = 18 where item_id = 143;
-- Dwarvish Axe
update weapon set dmg_small = 18, dmg_large = 24 where item_id = 144;
-- Berserker Axe
update weapon set dmg_small = 19, dmg_large = 19 where item_id = 145;
-- Ivory Tower Axe
update weapon set dmg_small = 20, dmg_large = 23 where item_id = 147;
-- Great Axe
update weapon set dmg_small = 20, dmg_large = 26 where item_id = 148;
-- Axe of Minotaur
update weapon set dmg_small = 22, dmg_large = 24 where item_id = 149;
-- Demon Axe
update weapon set dmg_small = 30, dmg_large = 30 where item_id = 151;
-- Bronze Claw
update weapon set double_dmg_chance = 33 where item_id = 152;
-- Steel Claw
update weapon set double_dmg_chance = 33 where item_id = 153;
-- Two-Handed Sword of Varlok
update weapon set dmg_small = 6, dmg_large = 8, hitmodifier = 4 where item_id =
196;
update weapon set dmg_small = 7, dmg_large = 9, hitmodifier = 5 where item_id =
197;
update weapon set dmg_small = 8, dmg_large = 10, hitmodifier = 6 where item_id
= 198;
update weapon set dmg_small = 9, dmg_large = 11, hitmodifier = 7 where item_id
= 199;
update weapon set dmg_small = 10, dmg_large = 12, hitmodifier = 8 where item_id
= 200;
update weapon set dmg_small = 11, dmg_large = 13, hitmodifier = 9 where item_id
= 201;
update weapon set dmg_small = 12, dmg_large = 14, hitmodifier = 10 where
item_id = 202;
update weapon set dmg_small = 13, dmg_large = 15, hitmodifier = 11 where
item_id = 203;
-- Claw of Purgatory
update weapon set double_dmg_chance = 33 where item_id = 207;
-- Spear of Sheba Human
update weapon set dmg_small = 11, dmg_large = 26, hitmodifier = 3, add_hp = 80
where item_id = 210;
-- Trident of the Sea God
update weapon set dmg_small = 20, dmg_large = 22, hitmodifier = 4 where item_id
= 212;
-- Sword of Kirtas
update weapon set dmg_small = 43, dmg_large = 53 where item_id = 217;
-- Iron Mace of Angus
update weapon set haste_item = 1 where item_id = 218;
-- Sword of Legend
update weapon set grdgfx = 4413 where item_id = 228;
-- Dagger of Blue Sky
update weapon set max_use_time = 300000 where item_id = 231;
-- Edoryu of Blue Sky
update weapon set double_dmg_chance = 25 where item_id = 236;
-- Claw of Blue Sky
update weapon set double_dmg_chance = 33 where item_id = 237;
-- Unknown Claw
update weapon set double_dmg_chance = 33 where item_id = 244;
-- Two Handed Sword
update weapon set dmg_small = 17, dmg_large = 21 where item_id = 100052;
-- Two-Handed Sword of Pretender King
update weapon set weight = 150000, dmg_small = 19, dmg_large = 23, dmgmodifier
= 5 where item_id = 100062;
-- Great Sword
update weapon set dmg_small = 20, dmg_large = 17 where item_id = 100064;
-- Glaive
update weapon set dmg_small = 12, dmg_large = 16 where item_id = 100098;
-- Lucern Hammer
update weapon set dmg_small = 15, dmg_large = 17, hitmodifier = 3 where item_id
= 100102;
-- Halberd
update weapon set dmg_small = 16, dmg_large = 12 where item_id = 100103;
-- Crimson Lance
update weapon set dmg_small = 21, dmg_large = 21 where item_id = 100107;
-- Battle Axe
update weapon set dmg_small = 18, dmg_large = 18 where item_id = 100143;
-- Demon Axe
update weapon set dmg_small = 30, dmg_large = 30 where item_id = 100151;
-- Trident of the Sea God
update weapon set dmg_small = 20, dmg_large = 22, hitmodifier = 4 where item_id
= 100212;
-- Two-Handed Sword
update weapon set dmg_small = 17, dmg_large = 21 where item_id = 200052;

-- Added Reinforced and Fortified T-shirts
insert into armor values (30000,'Reinforced T-Shirt','Reinforced T-Shirt','Reinforced T-Shirt','T','steel',6000,2000,5051,0,-2,4,0,1,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into armor values (30001,'Fortified T-Shirt','Fortified T-Shirt','Fortified T-Shirt','T','steel',7500,302,9,0,-4,4,0,1,0,0,0,0,0,0,0,0,0,0,0,15,0,0,0,0,45,0,0,0,3,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into etcitem values (90009,'Fiery Coal','Fiery Coal','Fiery Coal','material','none','none',500,244,774,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into droplist values (45512,'Hell Bound',90009,'Fiery Coal',1,1,4500);

-- Revert Temp fix for Pine/Maple wands recharge bug --
update etcitem set trade = '0' where item_id = 40006;
update etcitem set trade = '0' where item_id = 40008;

-- etcitem table merge.
update etcitem set weight = 2930 where item_id = 40026;
update etcitem set weight = 2930 where item_id = 40027;
update etcitem set weight = 2930 where item_id = 40028;
update etcitem set trade = 0 where item_id = 40310;
update etcitem set grdgfx = 5001 where item_id = 40667;
update etcitem set use_type = 'choice' where item_id = 40925;
update etcitem set use_type = 'choice' where item_id = 40926;
update etcitem set use_type = 'choice' where item_id = 40927;
update etcitem set use_type = 'choice' where item_id = 40928;
update etcitem set use_type = 'choice' where item_id = 40929;
update etcitem set use_type = 'choice' where item_id = 40931;
update etcitem set use_type = 'choice' where item_id = 40932;
update etcitem set use_type = 'choice' where item_id = 40933;
update etcitem set use_type = 'choice' where item_id = 40934;
update etcitem set use_type = 'choice' where item_id = 40935;
update etcitem set use_type = 'choice' where item_id = 40936;
update etcitem set use_type = 'choice' where item_id = 40937;
update etcitem set use_type = 'choice' where item_id = 40938;
update etcitem set use_type = 'choice' where item_id = 40939;
update etcitem set use_type = 'choice' where item_id = 40940;
update etcitem set use_type = 'choice' where item_id = 40941;
update etcitem set use_type = 'choice' where item_id = 40942;
update etcitem set use_type = 'choice' where item_id = 40943;
update etcitem set use_type = 'choice' where item_id = 40944;
update etcitem set use_type = 'choice' where item_id = 40945;
update etcitem set use_type = 'choice' where item_id = 40946;
update etcitem set use_type = 'choice' where item_id = 40947;
update etcitem set use_type = 'choice' where item_id = 40948;
update etcitem set use_type = 'choice' where item_id = 40949;
update etcitem set use_type = 'choice' where item_id = 40950;
update etcitem set use_type = 'choice' where item_id = 40951;
update etcitem set use_type = 'choice' where item_id = 40952;
update etcitem set use_type = 'choice' where item_id = 40953;
update etcitem set use_type = 'choice' where item_id = 40954;
update etcitem set use_type = 'choice' where item_id = 40955;
update etcitem set use_type = 'choice' where item_id = 40958;
update etcitem set use_type = 'choice' where item_id = 40959;
update etcitem set use_type = 'choice' where item_id = 40964;
update etcitem set itemdesc_id = 2261 where item_id = 40987;
update etcitem set itemdesc_id = 2263 where item_id = 40988;
update etcitem set itemdesc_id = 2262 where item_id = 40989;
update etcitem set grdgfx = 3832 where item_id = 41002;
update etcitem set stackable = 1 where item_id = 41003;
update etcitem set stackable = 1 where item_id = 41008;
update etcitem set use_type = 'choice', stackable = 1 where item_id = 41029;
update etcitem set stackable = 1 where item_id = 41036;
update etcitem set unidentified_name_id = '$4502', identified_name_id =
'$4502', invgfx = 2308, itemdesc_id = 2271 where item_id = 41161;
update etcitem set unidentified_name_id = '$4502', identified_name_id =
'$4502', invgfx = 2308, itemdesc_id = 2279 where item_id = 41162;
update etcitem set unidentified_name_id = '$4502', identified_name_id =
'$4502', invgfx = 2308, itemdesc_id = 2275 where item_id = 41163;
update etcitem set unidentified_name_id = '$4503', identified_name_id =
'$4503', itemdesc_id = 2276 where item_id = 41164;
update etcitem set unidentified_name_id = '$4511', identified_name_id =
'$4511', itemdesc_id = 2276 where item_id = 41165;
update etcitem set unidentified_name_id = '$4507', identified_name_id =
'$4507', itemdesc_id = 2276 where item_id = 41166;
update etcitem set unidentified_name_id = '$4504', identified_name_id =
'$4504', invgfx = 2308, itemdesc_id = 2277 where item_id = 41167;
update etcitem set unidentified_name_id = '$4512', identified_name_id =
'$4512', itemdesc_id = 2276 where item_id = 41168;
update etcitem set unidentified_name_id = '$4508', identified_name_id =
'$4508', invgfx = 2308, itemdesc_id = 2277 where item_id = 41169;
update etcitem set unidentified_name_id = '$4505', identified_name_id =
'$4505', itemdesc_id = 2278 where item_id = 41170;
update etcitem set unidentified_name_id = '$4513', identified_name_id =
'$4513', invgfx = 2308, itemdesc_id = 2278 where item_id = 41171;
update etcitem set itemdesc_id = 2278 where item_id = 41172;
update etcitem set unidentified_name_id = '$4579', identified_name_id =
'$4579', invgfx = 2297, itemdesc_id = 2264 where item_id = 41173;
update etcitem set unidentified_name_id = '$4579', identified_name_id =
'$4579', invgfx = 2297, itemdesc_id = 2266 where item_id = 41174;
update etcitem set unidentified_name_id = '$4579', identified_name_id =
'$4579', invgfx = 2297, itemdesc_id = 2265 where item_id = 41175;
update etcitem set unidentified_name_id = '$4514', identified_name_id =
'$4514', invgfx = 2306, itemdesc_id = 2283 where item_id = 41176;
update etcitem set unidentified_name_id = '$4520', identified_name_id =
'$4520', itemdesc_id = 2283 where item_id = 41177;
update etcitem set unidentified_name_id = '$4517', identified_name_id =
'$4517', invgfx = 2306, itemdesc_id = 2283 where item_id = 41178;
update etcitem set unidentified_name_id = '$4515', identified_name_id =
'$4515', itemdesc_id = 2284 where item_id = 41179;
update etcitem set unidentified_name_id = '$4521', identified_name_id =
'$4521', invgfx = 2306, itemdesc_id = 2284 where item_id = 41180;
update etcitem set unidentified_name_id = '$4518', identified_name_id =
'$4518', invgfx = 2306, itemdesc_id = 2283 where item_id = 41181;
update etcitem set unidentified_name_id = '$4516', identified_name_id =
'$4516', itemdesc_id = 2285 where item_id = 41182;
update etcitem set unidentified_name_id = '$4522', identified_name_id =
'$4522', itemdesc_id = 2285 where item_id = 41183;
update etcitem set unidentified_name_id = '$4519', identified_name_id =
'$4519', invgfx = 2306, itemdesc_id = 2285 where item_id = 41184;
update etcitem set unidentified_name_id = '$4559', identified_name_id =
'$4559' where item_id = 41185;
update etcitem set unidentified_name_id = '$4551', identified_name_id =
'$4551' where item_id = 41186;
update etcitem set unidentified_name_id = '$4543', identified_name_id =
'$4543' where item_id = 41187;
update etcitem set unidentified_name_id = '$4552', identified_name_id =
'$4552' where item_id = 41190;
update etcitem set unidentified_name_id = '$4544', identified_name_id =
'$4544' where item_id = 41191;
update etcitem set unidentified_name_id = '$4568', identified_name_id =
'$4568' where item_id = 41192;
update etcitem set unidentified_name_id = '$4561', identified_name_id =
'$4561' where item_id = 41193;
update etcitem set unidentified_name_id = '$4553', identified_name_id =
'$4553' where item_id = 41194;
update etcitem set unidentified_name_id = '$4569', identified_name_id =
'$4569' where item_id = 41196;
update etcitem set unidentified_name_id = '$4562', identified_name_id =
'$4562' where item_id = 41197;
update etcitem set unidentified_name_id = '$4546', identified_name_id =
'$4546' where item_id = 41199;
update etcitem set unidentified_name_id = '$4570', identified_name_id =
'$4570' where item_id = 41200;
update etcitem set use_type = 'normal', locx = 32833, locy = 33089 where
item_id = 45208;
update etcitem set itemdesc_id = 2777 where item_id = 45251;
update etcitem set itemdesc_id = 2552, stackable = 0 where item_id = 45255;
update etcitem set itemdesc_id = 2553, stackable = 0 where item_id = 45256;
update etcitem set itemdesc_id = 2554, stackable = 0 where item_id = 45257;
update etcitem set itemdesc_id = 2555, stackable = 0 where item_id = 45258;
update etcitem set itemdesc_id = 2556, stackable = 0 where item_id = 45259;
update etcitem set itemdesc_id = 2564 where item_id = 41263;
update etcitem set weight = 1000, itemdesc_id = 2564 where item_id = 45264;
update etcitem set itemdesc_id = 2564 where item_id = 41265;
update etcitem set itemdesc_id = 2564 where item_id = 41266;
update etcitem set weight = 1000, itemdesc_id = 2564 where item_id = 41267;
update etcitem set itemdesc_id = 2564 where item_id = 41274;
update etcitem set itemdesc_id = 2564 where item_id = 41275;
update etcitem set itemdesc_id = 2564 where item_id = 41276;
update etcitem set weight = 2000, itemdesc_id = 2562 where item_id = 41277;
update etcitem set weight = 2000, itemdesc_id = 2563 where item_id = 41278;
update etcitem set weight = 2000, itemdesc_id = 2564 where item_id = 41279;
update etcitem set weight = 2000, itemdesc_id = 2565 where item_id = 41280;
update etcitem set weight = 2000, itemdesc_id = 2566 where item_id = 41281;
update etcitem set weight = 2000, itemdesc_id = 2567 where item_id = 41282;
update etcitem set weight = 2000, itemdesc_id = 2568 where item_id = 41283;
update etcitem set weight = 2000, itemdesc_id = 2569 where item_id = 41284;
update etcitem set weight = 2000 where item_id = 41285;
update etcitem set weight = 2000 where item_id = 41286;
update etcitem set weight = 2000 where item_id = 41287;
update etcitem set weight = 3000 where item_id = 41288;
update etcitem set weight = 3000 where item_id = 41289;
update etcitem set weight = 3000 where item_id = 41290;
update etcitem set weight = 2000 where item_id = 41291;
update etcitem set weight = 2000 where item_id = 41292;
update etcitem set use_type = 'treasure_box' where item_id = 41311;
update etcitem set itemdesc_id = 2653 where item_id = 41319;
update etcitem set itemdesc_id = 2654 where item_id = 41320;
update etcitem set itemdesc_id = 2655 where item_id = 41321;
update etcitem set itemdesc_id = 2656 where item_id = 41322;
update etcitem set itemdesc_id = 2657 where item_id = 41323;
update etcitem set itemdesc_id = 2658 where item_id = 41324;
update etcitem set itemdesc_id = 2660 where item_id = 41327;
update etcitem set itemdesc_id = 2661 where item_id = 41328;
update etcitem set use_type = 'treasure_box' where item_id = 41336;
update etcitem set delay_id = 2, delay_time = 1000 where item_id = 41337;
update etcitem set itemdesc_id = 2594 where item_id = 41339;
update etcitem set itemdesc_id = 1760 where item_id = 41340;
update etcitem set itemdesc_id = 2597 where item_id = 41341;
update etcitem set invgfx = 324, itemdesc_id = 2605 where item_id = 41342;
update etcitem set itemdesc_id = 2598 where item_id = 41343;
update etcitem set itemdesc_id = 2595 where item_id = 41344;
update etcitem set itemdesc_id = 2596 where item_id = 41345;
update etcitem set invgfx = 1760, itemdesc_id = 2602 where item_id = 41346;
update etcitem set invgfx = 1760, itemdesc_id = 2603 where item_id = 41347;
update etcitem set invgfx = 1760, itemdesc_id = 2604 where item_id = 41348;
update etcitem set invgfx = 313 where item_id = 41356;
update etcitem set invgfx = 2867, itemdesc_id = 2979 where item_id = 41402;
update etcitem set unidentified_name_id = '$5523', identified_name_id = '$5523'
where item_id = 41422;
update etcitem set locx = 32743, locy = 32833 where item_id = 42002;
update etcitem set locx = 32782, locy = 32736 where item_id = 42003;
update etcitem set locx = 32728, locy = 32815 where item_id = 42004;
update etcitem set invgfx = 2878 where item_id = 42029;

update etcitem set locx = 32572, locy = 32663 where item_id = 40083;
update etcitem set invgfx = 2878 where item_id = 42030;
update etcitem set invgfx = 2878 where item_id = 42031;
update etcitem set invgfx = 2878 where item_id = 42032;
update etcitem set invgfx = 2878 where item_id = 42033;
update etcitem set invgfx = 2878 where item_id = 42035;
update etcitem set invgfx = 2878 where item_id = 42036;
update etcitem set invgfx = 2878 where item_id = 42037;
update etcitem set invgfx = 2878 where item_id = 42038;
update etcitem set invgfx = 2878 where item_id = 42039;
update etcitem set stackable = 1 where item_id = 49032;
update etcitem set stackable = 1 where item_id = 49033;

-- Fix Relic of Expedition Member treasure bag.
delete from etcitem where item_id in (40696, 40697);
INSERT INTO `etcitem` VALUES (40696, 'Gloves of Expedition Member', '$3978', '$3978', 'treasure_box', 'normal', 'none', 0, 957, 3963, 1838, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);
INSERT INTO `etcitem` VALUES (40697, 'Relic of Expedition Member', '$3992', '$3992', 'questitem', 'normal', 'leather', 0, 2054, 3963, 1841, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);

-- Fix boots and dark boots name ids.
update armor set unidentified_name_id = '$329', identified_name_id = '$329' where item_id = 20205;
update armor set unidentified_name_id = '$2452 $329', identified_name_id = '$2452 $329' where item_id = 20210;
