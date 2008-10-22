-- update 32

-- move action_id column in skills table to after castgfx
-- remove old action_id column
alter table skills drop column action_id;
-- more skills table changes/additions
alter table skills add column action_id int(10) unsigned NOT NULL default 0 after castgfx;
-- reinsert action_id data
update skills set action_id = 19;
update skills set action_id = 18 where skill_id in (4, 6, 7, 10, 11, 15, 16, 17, 22, 25, 28, 30, 34, 38, 45, 
46, 50, 53, 58, 59, 62, 65, 70, 74, 77, 80, 108, 132, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 
10008, 10009, 10010, 10011, 10012, 10013, 10014, 10015, 10016, 10017, 10018, 10019, 10020, 10021, 10022, 10023, 
10024, 10025, 10026, 10027, 10028, 10029, 10030, 10031, 10032, 10033, 10034, 10035, 10036, 10037, 10038, 10039, 
10040, 10041, 10042, 10043, 10044, 10045, 10046, 10047, 10048, 10049, 10050, 10051, 10052, 10053, 10054, 10055, 
10056, 10058, 10059, 10060, 10061, 10062, 10063, 10064, 10065, 10066, 10067, 10068, 10069, 10070, 10072, 10073, 
10074, 10075, 10076, 10077, 10078, 10079, 10080, 10081, 10082, 10083, 10084, 10085, 10086, 10087, 10088, 10089);

-- fix tsurugi name
update weapon set name = 'Tsurugi' where item_id = 57;

-- mapid table updated
-- remember the table needs still tobe updated i set it now to 1 so you can use everywhere items and skills till the table is fixed
alter table mapids add column `usable_item` int(4) unsigned NOT NULL default '1';
alter table mapids add column `usable_skill` int(4) unsigned NOT NULL default '1';

-- monster chaotic collum added
alter table npc add column `aggrochao` int(4) unsigned NOT NULL default '0';

-- some missing npcs for trading zones more will follow soon
INSERT INTO `spawnlist_npc` VALUES
(default,'Luke', '1', '60005', '32778', '32853', '0', '0', '5', '0', '340', '0'),
(default,'Denits', '1', '60004', '32745', '32842', '0', '0', '5', '0', '340', '0'),

-- the missing vegetations allready in the source implented
UPDATE etcitem SET itemdesc_id='2592' WHERE item_id ='41337'; 
UPDATE etcitem SET itemdesc_id='2593' WHERE item_id ='41338'; 

INSERT INTO `etcitem` VALUES ('41411', '', '$3025', 'potion', 'normal', 'vegetation', '0', '1396', '3461', '1101', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0'); 
INSERT INTO `etcitem` VALUES ('41412', '', '$3026', 'potion', 'normal', 'vegetation', '0', '1397', '3462', '1102', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0'); 
INSERT INTO `etcitem` VALUES ('41413', '', '$2580', 'potion', 'normal', 'vegetation', '6000', '1159', '3039', '920', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0'); 
INSERT INTO `etcitem` VALUES ('41414', '', '$2581', 'potion', 'normal', 'vegetation', '12000', '1160', '3040', '921', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0'); 
INSERT INTO `etcitem` VALUES ('41415', '', '$4913', 'potion', 'normal', 'glass', '9400', '2464', '5959', '296', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0'); 

-- shop price correction
UPDATE shop SET npc_id=71054,order_id=0,selling_price=690 WHERE item_id=40303 and selling_price <> -1;

-- food volume fix
UPDATE etcitem SET item_type='other',use_type='normal' WHERE item_id ='40070'; 
UPDATE etcitem SET food_volume='200' WHERE item_id ='41252'; 
UPDATE etcitem SET food_volume='80' WHERE item_id ='41266'; 
UPDATE etcitem SET food_volume='80' WHERE item_id ='41267'; 
UPDATE etcitem SET food_volume='100' WHERE item_id ='41274'; 
UPDATE etcitem SET food_volume='100' WHERE item_id ='41275'; 
UPDATE etcitem SET food_volume='100' WHERE item_id ='41276';

-- missing npc actions
INSERT INTO `npcaction` VALUES ('71198', 'tion1', 'tion1', '', ''); 
INSERT INTO `npcaction` VALUES ('71199', 'jeron1', 'jeron1', '', ''); 

-- the npcs for there quest
INSERT INTO `npc` VALUES ('71198', 'Tion', '$5030', '', 'L1Merchant', '1659', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0'); 
INSERT INTO `npc` VALUES ('71199', 'Jeron', '$5029', '', 'L1Merchant', '1254', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0'); 

-- replace missing sbs from IT 2F npcs
INSERT INTO `shop` VALUES ('70062', '40170', '0', '3300', '0', '1000');
INSERT INTO `shop` VALUES ('70062', '40173', '1', '3300', '0', '1000');
INSERT INTO `shop` VALUES ('70062', '40177', '2', '3300', '0', '1000');
INSERT INTO `shop` VALUES ('70062', '40179', '3', '8250', '0', '2000');
INSERT INTO `shop` VALUES ('70062', '40183', '4', '8250', '0', '2000');
INSERT INTO `shop` VALUES ('70066', '40171', '0', '3300', '0', '1000');
INSERT INTO `shop` VALUES ('70066', '40176', '1', '3300', '0', '1000');
INSERT INTO `shop` VALUES ('70066', '40180', '2', '8250', '0', '2000');
INSERT INTO `shop` VALUES ('70066', '40182', '3', '8250', '0', '2000');

-- make elders aggro to chao
update npc set aggrochao = 1 where npcid = 45215;

-- correct some transform_ids in npc table
update npc set transform_id = 45976 where npcid = 45964;
update npc set transform_id = 45977 where npcid = 45966;
update npc set transform_id = 45980 where npcid = 45965;
update npc set transform_id = 45981 where npcid = 45969;
update npc set transform_id = 45982 where npcid = 45967;
update npc set transform_id = 45990 where npcid = 45968;
update npc set transform_id = 45991 where npcid = 45971;
update npc set transform_id = 45992 where npcid = 45972;
update npc set transform_id = 45993 where npcid = 45971;
update npc set transform_id = 45996 where npcid = 45970;
update npc set transform_id = 45997 where npcid = 45973;
update npc set transform_id = 46005 where npcid = 45974;
update npc set transform_id = 46011 where npcid = 45975;

-- fixing some typos and spelling errors I noticed, using to get a feel
-- for how to use svn. Let me know if this is ok. - Tricid

update etcitem set name = 'Black Mithril Arrow' where item_id = 40747;
update etcitem set name = 'Black Lump of Pure Mithril' where item_id = 40443;

-- 2 new resist for armor blind and sustian
alter table armor add column `regist_sustain` int(2) unsigned NOT NULL default '0';
alter table armor add column `regist_blind` int(2) unsigned NOT NULL default '0';

UPDATE armor SET regist_stone='20',regist_freeze='0' WHERE item_id ='20229';
UPDATE armor SET regist_stan='0',regist_stone='1' WHERE item_id ='20443';
UPDATE armor SET regist_stan='0',regist_freeze='1' WHERE item_id ='20444';
UPDATE armor SET regist_stan='0',regist_sleep='1' WHERE item_id ='20446';
UPDATE armor SET regist_stan='0',regist_stone='1' WHERE item_id ='20447';
UPDATE armor SET regist_stan='0',regist_freeze='1' WHERE item_id ='20448';
UPDATE armor SET regist_stan='0',regist_sleep='1' WHERE item_id ='20450';
UPDATE armor SET regist_sustain='7' WHERE item_id ='21060';
UPDATE armor SET material='leather',invgfx='2259',ac='-1' WHERE item_id ='20380'; 
UPDATE armor SET regist_freeze='8' WHERE item_id ='120016';
-- NOTE: removing these for now. need to make sure each column matches up with ours before adding l1j data. 
-- these inserts don't currently work
-- INSERT INTO `armor` VALUES ('21060', '', '$5255', 'armor', 'wood', '200000', '2653', '6402', '2792', '-6', '6', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '10', '31', '6', '6', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
-- INSERT INTO `weapon` VALUES ('256', '', '$5254', 'sword', 'wood', '35000', '2651', '6401', '2791', '10', '10', '6', '1', '1', '1', '1', '1', '3', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0');
-- INSERT INTO `weapon_skill` VALUES ('256', '', '8', '35', '25', '0', '0', '2750', '0');

-- poly gfxid fixes
UPDATE polymorphs SET id='2388',polyid='2388' WHERE name ='death'; 
UPDATE polymorphs SET id='3952',polyid='3952' WHERE name ='vampire'; 
UPDATE polymorphs SET id='4767',polyid='4767' WHERE name ='rabbit'; 
UPDATE polymorphs SET id='4769',polyid='4769' WHERE name ='carrot rabbit'; 
UPDATE polymorphs SET id='4928',polyid='4928' WHERE name ='high collie'; 
UPDATE polymorphs SET id='4929',polyid='4929' WHERE name ='high raccoon'; 
UPDATE polymorphs SET armorequip='2047' WHERE id='5719' and polyid='5719'; 
UPDATE polymorphs SET id='6089',polyid='6089',weaponequip='255',armorequip='2047',isSkillUse='1' WHERE name ='drake morph'; 
UPDATE polymorphs SET weaponequip='255',armorequip='2047',isSkillUse='1' WHERE id='4001' and polyid='4001'; 
UPDATE polymorphs SET weaponequip='255',armorequip='2047',isSkillUse='1' WHERE id='4002' and polyid='4002'; 
UPDATE polymorphs SET weaponequip='239',armorequip='2047',isSkillUse='1' WHERE id='4004' and polyid='4004'; 
UPDATE polymorphs SET id='6002',polyid='6002' WHERE name ='spirit of earth boss'; 
UPDATE polymorphs SET weaponequip='511' WHERE name ='manekineko'; 
UPDATE polymorphs SET weaponequip='255' WHERE name ='knight vald morph'; 
UPDATE polymorphs SET weaponequip='511' WHERE name ='Halloween Pumpkin'; 

-- names i cant find yet
INSERT INTO `polymorphs` VALUES ('3902', '', '3902', '1', '43', '2047', '1'); 
INSERT INTO `polymorphs` VALUES ('3903', '', '3903', '1', '239', '2047', '1'); 
INSERT INTO `polymorphs` VALUES ('5645', '', '5645', '1', '0', '2047', '0'); 
INSERT INTO `polymorphs` VALUES ('5976', '', '5976', '1', '239', '2', '0'); 
INSERT INTO `polymorphs` VALUES ('6086', '', '6086', '1', '239', '2047', '1'); 
INSERT INTO `polymorphs` VALUES ('6087', '', '6087', '1', '256', '2047', '1'); 
INSERT INTO `polymorphs` VALUES ('6088', '', '6088', '1', '239', '2047', '1');

-- id fixes in etcitem to match the new quest and talk stuff
UPDATE etcitem SET itemdesc_id='2659' WHERE item_id ='41315'; 
UPDATE etcitem SET itemdesc_id='2670' WHERE item_id ='41316'; 
UPDATE etcitem SET itemdesc_id='2474' WHERE item_id ='41354'; 

-- mapid 4 starty fix
UPDATE mapids SET startY="32064" WHERE mapid="4";

-- black knight polyid fix
UPDATE polymorphs SET id='4923',polyid='4923' WHERE name ='black knight morph';

-- item gfxs fixes and weight and trade able
UPDATE`armor`SET`grdgfx`='6098' WHERE `item_id` ='20383'; 
UPDATE`armor`SET`grdgfx`='5964' WHERE `item_id` ='20419'; 
UPDATE`weapon`SET`add_hpr`='-30' WHERE `item_id` ='195'; 
UPDATE`etcitem`SET`grdgfx`='2475' WHERE `item_id` ='40726'; 
UPDATE`etcitem`SET`grdgfx`='2476' WHERE `item_id` ='40721'; 
UPDATE`etcitem`SET`grdgfx`='4377' WHERE `item_id` ='40623'; 
UPDATE`etcitem`SET`grdgfx`='4379' WHERE `item_id` ='40624'; 
UPDATE`etcitem`SET`grdgfx`='4381' WHERE `item_id` ='40625'; 
UPDATE`etcitem`SET`grdgfx`='4383' WHERE `item_id` ='40626'; 
UPDATE`etcitem`SET`grdgfx`='4385' WHERE `item_id` ='40627'; 
UPDATE`etcitem`SET`grdgfx`='4387' WHERE `item_id` ='40628'; 
UPDATE`etcitem`SET`grdgfx`='4389' WHERE `item_id` ='40629'; 
UPDATE`etcitem`SET`use_type`='normal' WHERE `item_id` ='41160'; 
UPDATE`shop`SET`pack_count`='1' WHERE `npc_id` ='70005' and `item_id` ='4'; 
UPDATE`etcitem`SET`trade`='1' WHERE `item_id` ='40733'; 
UPDATE`etcitem`SET`trade`='1' WHERE `item_id` ='40734'; 
UPDATE`etcitem`SET`trade`='1' WHERE `item_id` ='40735'; 
UPDATE`etcitem`SET`trade`='1' WHERE `item_id` ='40736'; 
UPDATE`etcitem`SET`trade`='1' WHERE `item_id` ='40641'; 
UPDATE`etcitem`SET`trade`='1' WHERE `item_id` ='41159'; 
UPDATE`etcitem`SET`locx`='32867',`locy`='32510' WHERE `item_id` ='40114'; 
UPDATE`etcitem`SET`locx`='32752',`locy`='32441' WHERE `item_id` ='40125'; 
UPDATE`etcitem`SET`locx`='32617',`locy`='33201' WHERE `item_id` ='40115'; 
UPDATE`etcitem`SET`locx`='33614',`locy`='33253' WHERE `item_id` ='40123'; 
UPDATE`etcitem`SET`locx`='32851',`locy`='32904' WHERE `item_id` ='40845'; 
UPDATE`etcitem`SET`item_type`='other',`material`='glass' WHERE `item_id` ='43000'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40623'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40624'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40625'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40626'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40627'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40628'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40629'; 
UPDATE`etcitem`SET`invgfx`='1786',`grdgfx`='4377' WHERE `item_id` ='40666'; 
UPDATE`armor`SET`weight`='10000',`use_royal`='0',`use_knight`='0',`use_mage`='0',`use_elf`='0' WHERE `item_id` ='20037'; 
UPDATE`etcitem`SET`use_type`='none' WHERE `item_id` ='40602'; 
UPDATE`droplist`SET`min`='30',`max`='100' WHERE `itemId` ='40742'; 
UPDATE`droplist`SET`min`='10',`max`='30' WHERE `itemId` ='40743'; 
UPDATE`droplist`SET`min`='10',`max`='30' WHERE `itemId` ='40744'; 
UPDATE`droplist`SET`min`='30',`max`='100' WHERE `itemId` ='40746'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='231'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='232'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='233'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='234'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='235'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='236'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='237'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='238'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='239'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='240'; 
UPDATE`etcitem`SET`itemdesc_id`='17' WHERE `item_id` ='40013'; 
UPDATE`etcitem`SET`itemdesc_id`='17' WHERE `item_id` ='40018'; 
UPDATE`etcitem`SET`itemdesc_id`='1343' WHERE `item_id` ='40030'; 
UPDATE armor SET use_royal="0", use_mage="0", use_elf="0", use_darkelf="0" WHERE item_id="20026";
UPDATE etcitem SET stackable="0" WHERE item_id="40300";

-- chao npcs if you talk to them they will answer a different txt
UPDATE npcaction SET caotic_action="dorinl" WHERE npcid="60001"; 
UPDATE npcaction SET caotic_action="thraml" WHERE npcid="60003"; 
UPDATE npcaction SET caotic_action="denitzl" WHERE npcid="60004"; 
UPDATE npcaction SET caotic_action="lukul" WHERE npcid="60005"; 
UPDATE npcaction SET caotic_action="jiankul" WHERE npcid="60006"; 
UPDATE npcaction SET caotic_action="kariml" WHERE npcid="60007"; 
UPDATE npcaction SET caotic_action="nodiml" WHERE npcid="60008"; 
UPDATE npcaction SET caotic_action="sauraml" WHERE npcid="60009"; 
UPDATE npcaction SET caotic_action="kashaml" WHERE npcid="60010"; 
UPDATE npcaction SET caotic_action="kuronl" WHERE npcid="60011"; 
UPDATE npcaction SET caotic_action="axellonl" WHERE npcid="60013"; 
UPDATE npcaction SET caotic_action="jukel" WHERE npcid="60016"; 
UPDATE npcaction SET caotic_action="karudiml" WHERE npcid="60017"; 
UPDATE npcaction SET caotic_action="kamul" WHERE npcid="60018"; 
UPDATE npcaction SET caotic_action="timpukinl" WHERE npcid="60019"; 
UPDATE npcaction SET caotic_action="tulakl" WHERE npcid="60020"; 
UPDATE npcaction SET caotic_action="hiriml" WHERE npcid="60021"; 
UPDATE npcaction SET caotic_action="tarkinl" WHERE npcid="60023"; 
UPDATE npcaction SET caotic_action="gothaml" WHERE npcid="60024"; 
UPDATE npcaction SET caotic_action="kusianl" WHERE npcid="60025"; 
UPDATE npcaction SET caotic_action="kuhatinl" WHERE npcid="60027"; 
UPDATE npcaction SET caotic_action="hakiml" WHERE npcid="60030"; 
UPDATE npcaction SET caotic_action="rayearth2" WHERE npcid="60031"; 
UPDATE npcaction SET caotic_action="garinl" WHERE npcid="60032"; 
UPDATE npcaction SET caotic_action="gawll" WHERE npcid="60033"; 
UPDATE npcaction SET caotic_action="kuudl" WHERE npcid="60034"; 
UPDATE npcaction SET caotic_action="zadarl" WHERE npcid="60035"; 
UPDATE npcaction SET caotic_action="tigusl" WHERE npcid="60036";

-- sosc type set on item 40410
UPDATE`etcitem`SET`use_type`='sosc' WHERE `item_id` ='40410'; 

-- resist fix
UPDATE armor SET regist_freeze='0',regist_sustain='5' WHERE item_id ='20412'; 
UPDATE armor SET regist_stone='20' WHERE item_id ='20365';

-- windshacke system txt fix
UPDATE skills SET sysmsgID_happen='1001' WHERE name ='WindShackle'; 