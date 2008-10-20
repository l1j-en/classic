-- update 8

-- add ring of immunity to magic to fi dark elf
insert into droplist values (45364, 20280, 1, 1, 500);

-- add a-scroll to fi dark elf 
insert into droplist values (45364, 40076, 1, 1, 100);

-- reduce helm of wind droprates by 50%
update droplist set chance = 5000 where itemId = 20023;

-- reduce old helm of wind droprates by 30%
update droplist set chance = 7000 where itemId = 20008;

-- reduce cursed scale mail droprate from 45024 werewolf
update droplist set chance = 25000 where itemid = 220122 and mobid = 45024;

-- reduce SC: elemental falldown droprate (10000 -> 2000) for lower level mobs
update droplist set chance = 2000 where itemid = 40241 and mobid in (45298, 45322, 45359, 45373);

-- reduce SC: fire weapon droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40256 and mobid in (45203, 45206, 45241, 45283, 45284, 45286, 45291, 45341, 45359, 45365, 45408);

-- reduce SC: bless of fire droprate (10000 -> 2000) for lower level mobs
update droplist set chance = 2000 where itemid = 40257 and mobid in (45206, 45284, 45291, 45298, 45341, 45359, 45365, 45408);

-- reduce SC: elemental fire droprate (10000 -> 1000) for lower level mobs
update droplist set chance = 1000 where itemid = 40259 and mobid in (45203, 45206, 45341, 45359);

-- reduce SC: earth skin droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40247 and mobid in (45240, 45259, 45260, 45262, 45269, 45277, 45345, 45372);

-- reduce SC: iron skin droprate (10000 -> 1000) for lower level mobs
update droplist set chance = 1000 where itemid = 40251 and mobid in (45372, 45345, 45570, 45571, 45582, 45587, 45605);

-- reduce SC: wind shot droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40260 and mobid in (45135, 45137, 45138, 45265, 45270);

-- add bless of earth to elindaire
insert into droplist values (81081, 40250, 1, 1, 10000);

-- reduce SC: exotic vitalize droprate (10000 -> 2000) for lower level mobs
update droplist set chance = 2000 where itemid = 40252 and mobid in (45295, 45337, 45345, 45351, 45373, 45416);

-- reduce SC: eye of storm droprate (10000 -> 3000) for lower level mobs
update droplist set chance = 3000 where itemid = 40262 and mobid in (45203, 45264, 45265);

-- reduce SC: counter mirror droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40246 and mobid in (45217, 45419);

-- reduce SC: area of silence droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40244 and mobid in (45257, 45516);

-- reduce SC: triple shot droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40240 and mobid in (45118, 45122, 45291, 45321, 45349, 45361, 45365, 45366, 45418, 45420, 45424);

-- reduce DSC: blind hiding droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40265 and mobid in (45019, 45050, 45065, 45066, 45094, 45104, 45109, 45114, 45126, 45129, 45134, 45181, 45244);

-- reduce DSC: enchant venom droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40266 and mobid in (45065, 45066, 45104, 45109, 45114, 45129, 45181, 45220, 45233, 45244, 45254, 45272, 45398, 45411, 45446);

-- reduce DSC: shadow armor droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40267 and mobid in (45024, 45082, 45094, 45126, 45134, 45144, 45145, 45244, 45287, 45412);

-- reduce DSC: dress mighty droprate (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40269;

-- reduce DSC: burning spirit droprate (10000 -> 5000) 
update droplist set chance = 5000 where itemid = 40271;

-- reduce DSC: dark blind droprate (10000 -> 5000) 
update droplist set chance = 5000 where itemid = 40272;

-- reduce DSC: venom resist droprate (10000 -> 5000) 
update droplist set chance = 5000 where itemid = 40273;

-- reduce DSC: dress dex droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40274 and mobid in (45065, 45066, 45094, 45129, 45181, 45256);

-- reduce DSC: double break droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40275 and mobid in (45244, 45345, 45372, 45380, 45515, 45493);

-- reduce DSC: shadow fang droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40277 and mobid in (45220, 45244, 45272, 45363, 45471, 45481, 45516);

-- reduce DSC: final burn droprate (10000 -> 2000) for lower level mobs
update droplist set chance = 2000 where itemid = 40278 and mobid in (45141, 45244, 45287, 45322, 45345, 45372, 45399, 45406, 45412, 45454, 45494);

-- reduce DSC: dress evasion droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40279 and mobid in (45272, 45406, 45455, 45493);

-- add thor's to dark and light giant droplist
insert into droplist values (45337, 450000, 1, 1, 40);
insert into droplist values (45295, 450000, 1, 1, 50);
-- reduce thor's droprate on medium giant
update droplist set chance = 60 where itemid = 450000 and mobid = 45351;

-- reduce dwarf and dwarf warrior junk drops 
-- Dwarvish Iron Helm  
update droplist set chance = 20000 where itemid = 20007;
-- Dwarvish Cloak  
update droplist set chance = 20000 where itemid = 20052;
-- Dwarvish Round Shield 
update droplist set chance = 15000 where itemid = 20223;
-- Dwarvish Short Sword
update droplist set chance = 15000 where itemid = 26;

-- reduce lantern droprate from gnolls and tribal orcs
update droplist set chance = 15000 where itemid = 40002;

-- reduce candle droprate on orc, orc archer, and gandi orc
update droplist set chance = 25000 where itemid = 40005;

-- reduce stone golem flail droprate
update droplist set chance = 25000 where itemid = 139 and mobid in (45126, 45281);

-- reduce skeleton skull droprate (50000 -> 30000)
update droplist set chance = 30000 where itemid = 40605;

-- reduce skeleton scitimar droprate by 50%
update droplist set chance = 25000 where itemid in (27, 200027) and mobid in (45107, 45114);

-- reduce bpm droprate from atuba orc, spartoi, bk, gsa, elmore general, and living armor, bk search party (10000 -> 5000)
update droplist set chance = 5000 where itemid = 20149 and mobid in (45149, 45161, 45165, 45181, 45190, 45248, 45322, 81066);

-- reduce orcish helm droprate from orc zombie (300000 -> 15000)
update droplist set chance = 15000 where itemid = 20034 and mobid = 45104;

-- reduce orcish ring mail and orcish chain mail droprate from orc zombie (50000 -> 10000)
update droplist set chance = 10000 where itemid in (20135, 20136) and mobid = 45104;

-- add brave pot to cursed orc zombie droplist
insert into droplist values(45468, 40014, 1, 1, 50000);

-- add nzel to cursed orc zombie droplist
insert into droplist values(45468, 40074, 1, 1, 25000);

-- reduce 10% MR ring droprate from 5xf elmores (1000 -> 500)
update droplist set chance = 500 where itemid = 20280 and mobid in (45524, 45506, 45541);

-- add whetstone to cursed elmore general
insert into droplist values(45541, 40317, 1, 1, 10000);

-- correct whetstone name
update etcitem set name = 'Whetstone' where item_id = 40317;

-- capitalize de wizard name
update npc set name = 'Dark Elf Wizard' where npcid = 45333;

-- reduce orcish cloak droprate by 50% 
update droplist set chance = 25000 where itemid = 20072;

-- add orcish cloak drop to orc and orc archer
insert into droplist values (45019, 20072, 1, 1, 15000);
insert into droplist values (45009, 20072, 1, 1, 15000);

-- fixed cursed orcish dagger name (was elven dagger)
update weapon set name = 'Orcish Dagger' where item_id = 200001;

-- reduce g-axe droprate from death, bugbear, ogre, and troll by 50%
update droplist set chance = 25000 where itemid = 148 and mobid in (45221, 45223, 45738, 45278, 45280);

-- increase silver cloak droprate from cerenis (1000 -> 5000)
update droplist set chance = 5000 where itemid = 20074 and mobid = 45678;

-- reduce cerenis blizz leverage (120 -> 40)
update mobskill set leverage = 40 where mobid = 45678 and actno = 1;

-- reduce cerenis full heal leverage (100 -> 50)
update mobskill set leverage = 50 where mobid = 45678 and actno = 0;

-- reduce doppel boss blizz leverage (30 -> 15)
update mobskill set leverage = 15 where mobid = 45546 and actno = 0;

-- reduce DK v-t leverage (50 -> 35)
update mobskill set leverage = 35 where mobid = 45601 and actno = 0;

-- reduce DK aoe leverage (30 -> 15) and trirnd (60 -> 45)
update mobskill set leverage = 15, trirnd = 45 where mobid = 45601 and actno = 1;

-- add drops to yahee
-- adena
insert into droplist values (45675, 40308, 32000, 64000, 1000000);
-- helmet of yahee
insert into droplist values (45675, 20031, 1, 1, 8000);
-- cloak of yahee
insert into droplist values (45675, 20069, 1, 1, 8000);
-- armor of yahee
insert into droplist values (45675, 20131, 1, 1, 8000);
-- gloves of yahee
insert into droplist values (45675, 20179, 1, 1, 8000);
-- boots of yahee
insert into droplist values (45675, 20209, 1, 1, 8000);
-- amulet of yahee
insert into droplist values (45675, 20261, 1, 1, 8000);
-- ring of yahee
insert into droplist values (45675, 20290, 1, 1, 8000);

-- correct name of amulet of yahee
update armor set name = 'Amulet of Yahee' where item_id = 20261;
-- correct name of amulet of vigor
update armor set name = 'Amulet of Vigor' where item_id = 20262;

-- correct non-100% adena droprates
update droplist set chance = 1000000 where itemid = 40308 and chance < 1000000;

-- reduce forgotton armor droprates by 50%
update droplist set chance = 5000 where itemid in (20140, 20141, 20142, 20143);

-- reduce forgotten bowgun droprates from griffon by 50%
update droplist set chance = 5000 where itemid = 167 and mobid = 45445;

-- reduce ropc droprate from succubus and unicorn (5000 -> 500)
update droplist set chance = 500 where itemid = 20281 and mobid in (45393, 45394, 45640);

-- remove ropc from succubus queen of varlok
delete from droplist where itemid = 20281 and mobid = 45450;

-- remove rotc drop from succubus
delete from droplist where itemid = 20288 and mobid = 45394;

-- reduce rotc droprate from bapho and IQ (10000 -> 5000)
update droplist set chance = 5000 where itemid = 20288 and mobid in (45573, 45609);

-- reduce sb:g-res droprate from medusa (10000 -> 900)
update droplist set chance = 900 where itemid = 40220 and mobid = 45380;

-- increase elindaire bzel droprate (5000 -> 10000)
update droplist set chance = 10000 where itemid = 140074 and mobid = 81081;

-- correct name of Bow (was Elven Bow)
update weapon set name = 'Bow' where item_id in (170, 100172);

-- correct name of old amulet of wisdom 
update armor set name = 'Old Amulet of Wisdom' where item_id = 120248;

-- correct name of lastabad leather armor
update armor set name = 'Lastabad Leather Armor' where item_id = 20102;

-- correct name of dark crossbow
update weapon set name = 'Dark Crossbow' where item_id = 168;

-- correct name of stone of alchemy
update etcitem set name = 'Stone of Alchemy' where item_id = 40414;

-- increase abyss ghoul nzel droprate (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45501;

-- remove various items from shop lists (excluding gm shops)
-- ancient items
delete from shop where item_id in (20092, 20093, 20094, 20095, 67, 68, 179, 182) and npc_id < 81000 and selling_price = -1;
-- daggers/swords
delete from shop where item_id in (3, 5, 8, 9, 11, 12, 13, 14, 16, 17, 18, 19, 20, 22, 28, 30, 36, 42, 44, 45, 46, 47, 49, 50, 51, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 100008, 100009, 100028, 100042, 100049, 100057, 100062, 100064) and npc_id < 81000 and selling_price = -1;
-- edoryus
delete from shop where item_id in (70, 74, 78, 79, 81, 82, 83, 84, 85, 86, 100074, 100084) and npc_id < 81000 and selling_price = -1;
-- polearms
delete from shop where item_id in (88, 89, 99, 100, 107, 100099, 100107) and npc_id < 81000 and selling_price = -1;
-- staves
delete from shop where item_id in (108, 109, 110, 111, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 126, 127, 130, 131, 132, 133, 134, 100132) and npc_id < 81000 and selling_price = -1;
-- axes
delete from shop where item_id in (149, 151, 100151) and npc_id < 81000 and selling_price = -1;
-- claws
delete from shop where item_id in (155, 160, 162, 163, 164, 165, 166, 100164) and npc_id < 81000 and selling_price = -1;
-- bows
delete from shop where item_id in (167, 177, 178, 179, 180, 181, 183, 184, 185, 188, 189, 190, 192, 194, 100189) and npc_id < 81000 and selling_price = -1;
-- helms
delete from shop where item_id in (20003, 20004, 20005, 20009, 20010, 20016, 20017, 20018, 20020, 20021, 20022, 20024, 20025, 20027, 20029, 20030, 20031, 20033, 20035, 20039, 20040, 20041, 20042, 20046, 20047, 20048) and npc_id < 81000 and selling_price = -1;
-- cloaks
delete from shop where item_id in (20049, 20050, 20051, 20054, 20055, 20057, 20058, 20059, 20060, 20061, 20062, 20064, 20065, 20066, 20067, 20068, 20069, 20070, 20071, 20074, 20076, 20077, 20078, 20079, 20080) and npc_id < 81000 and selling_price = -1;
-- shirts
delete from shop where item_id in (20082, 20083, 20084, 20086, 20087, 20088) and npc_id < 81000 and selling_price = -1;
-- body armor
delete from shop where item_id in (20091, 20099, 20100, 20106, 20107, 20108, 20109, 20112, 20113, 20116, 20117, 20118, 20119, 20121, 20123, 20127, 20129, 20130, 20131, 20134, 20137, 20138, 20140, 20141, 20142, 20143, 20144, 20146, 20150, 20151, 20152, 20153, 20156, 20157, 20158, 20159, 20160) and npc_id < 81000 and selling_price = -1;
-- gloves
delete from shop where item_id in (20163, 20164, 20165, 20166, 20167, 20168, 20169, 20170, 20171, 20176, 20179, 20183, 20184, 20185, 20186, 20187, 20190) and npc_id < 81000 and selling_price = -1;
-- boots 
delete from shop where item_id in (20194, 20195, 20197, 20198, 20201, 20202, 20203, 20204, 20208, 20209, 20211, 20214, 20215, 20216, 20218) and npc_id < 81000 and selling_price = -1;
-- shields 
delete from shop where item_id in (20220, 20225, 20226, 20228, 20230, 20233, 20234, 20240) and npc_id < 81000 and selling_price = -1;
-- amulets 
delete from shop where item_id in (20243, 20244, 20245, 20246, 20247, 20248, 20249, 20250, 20251, 20252, 20253, 20254, 20255, 20256, 20257, 20258, 20259, 20260, 20261, 20262, 20263, 20264, 20265, 20266, 20267, 20268, 20269, 20270, 120244, 120245, 120246, 120247, 120248, 120249, 120254, 120256, 120264, 120266, 120267, 120268) and npc_id < 81000 and selling_price = -1;
-- rings
delete from shop where item_id in (20277, 20278, 20279, 20280, 20281, 20282, 20284, 20285, 20286, 20287, 20288, 20289, 20290, 20291, 20293, 20294, 20295, 20296, 20297, 20298, 20299, 20300, 20301, 20302, 20303, 20304, 20305, 120280, 120285, 120289, 120300, 120302, 120304) and npc_id < 81000 and selling_price = -1;
-- belts
delete from shop where item_id in (20306, 20307, 20308, 20309, 20310, 20311, 20312, 20313, 20314, 20315, 20316, 20317, 20318, 20319, 20320, 20321, 120306, 120307, 120308, 120309, 120310, 120311, 120312, 120316, 120317, 120319, 120320, 120321) and npc_id < 81000 and selling_price = -1;
-- misc armors
delete from shop where item_id in (20342, 20343, 20344, 20345, 20346, 20347, 20348, 20349, 20350, 20353, 20352, 120016, 120074, 120077, 120085, 120112) and npc_id < 81000 and selling_price = -1;
-- elixirs
delete from shop where item_id in (40033, 40034, 40035, 40036, 40037, 40038) and npc_id < 81000 and selling_price = -1;
-- toi charms
delete from shop where item_id in (20180, 40281, 40282, 40283, 40284, 40285, 40286, 40287, 40288, 40289, 40290, 40291, 40292, 40293, 40294, 40295, 40296, 40297) and npc_id < 81000 and selling_price = -1;
-- relics
delete from shop where item_id in (40304, 40305, 40306, 40307) and npc_id < 81000 and selling_price = -1;
-- misc items
delete from shop where item_id in (40162, 40308, 40314, 40316, 40330, 40466, 40513) and npc_id < 81000 and selling_price = -1;

-- correct ring drop fire boss
delete from droplist where itemid = 20285 and mobid = 45643;
insert into droplist values (45643, 20304, 1, 1, 10000);

-- reduce pg droprate from crawling claw (1000 -> 100)
update droplist set chance = 100 where itemid = 20187 and mobid = 45083;
