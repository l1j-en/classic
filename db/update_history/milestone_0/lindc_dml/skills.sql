-- update 2

-- de-nerf blizz
update skills set damage_value = 10, damage_dice_count = 8 where skill_id = 59;


-- update 3

-- de-nerf freezing blizz (slightly less powerful than normal blizz)
update skills set damage_value = 8, damage_dice_count = 5 where skill_id = 80;

-- reduce black wizard magic attack dmg by half
update skills set damage_value = 25 where skill_id = 10044;



-- update 4

-- reduce ancient giant's aoe damage by 20%
update skills set damage_value = 80 where skill_id = 10019;



-- update 7

-- correct spelling of paralyze, immune, and tripleshot in skills
update skills set name = 'Paralyze' where skill_id = 33;
update skills set name = 'ImmuneToHarm' where skill_id = 68;
update skills set name = 'TripleShot' where skill_id = 132;

-- increase effectiveness of nature's blessing (dmg dice 12 -> 18)
update skills set damage_dice = 18 where skill_id = 164; 

-- fix skill name for WaterLife (was StormWalk)
update skills set name = 'WaterLife' where skill_id = 170;

-- reduce phoenix ranged skill dmg value 25% (100 -> 75)
update skills set damage_value = 75 where skill_id = 10018;



-- update 14

-- remvoe aoe on black wizard skill (6 -> 0)
update skills set area = 0 where skill_id = 10044;



-- update 15 

-- reduce dark forester magic skill damage_value (50 -> 30)
update skills set damage_value = 30 where skill_id = 10043;



-- update 16

-- correct name of WindShackle skill (was WindCircle)
update skills set name = 'WindShackle' where skill_id = 167;

-- reduce lesser demon 2 cell magic attack damage_value (50 -> 20)
update skills set damage_value = 20 where skill_id = 10042;

-- reduce lesser dragon magic attack damage_value (200 -> 100)
update skills set damage_value = 100 where skill_id = 10008;

-- reduce dark forester aoe damage_value (30 -> 20)
update skills set damage_value = 20 where skill_id = 10043;



-- update 17

-- correct glowing aura mp cost (40 -> 30)
update skills set mpconsume = 30 where skill_id = 114;



-- update 20

-- correct bounce attack hpconsume (120 -> 10)
update skills set hpConsume = 10 where skill_id = 89;

-- fix prince spells
update skills set skill_id = 1169999, skill_number = 3 where skill_id = 115;
update skills set skill_id = 1159999, skill_number = 3 where skill_id = 116;
update skills set skill_id = 115, id = 115, skill_number = 2 where skill_id = 1169999;
update skills set skill_id = 116, id = 116, skill_number = 3 where skill_id = 1159999;



-- update 22

-- decrease fblizz buff duration (32 -> 16)
update skills set buffDuration = 16 where skill_id = 80;

-- add range to ElementalFallDown (0 -> 10)
update skills set ranged = 10 where skill_id = 133;



-- update 24

-- make earth boss rock skill do AoE damage
update skills set area = 3 where skill_id = 10020;

-- create elekkadom skill
insert into skills values (11000, 'Elekkadom Electrical Charge', 0, 0, 8, 0, 0, 0, 0, 0, 'attack', 3, 50, 5, 5, 0, 0, 2, 64, 0, 2, 0, 0, 0, '', 1714, 0, 0, 0, 0);

-- fix fire arrow and stalac
update skills set name = 'FireArrow', skill_number = 6, attr = 2, id = 64, nameid = '$1969', castgfx = 1583, arrowType = 1 where skill_id = 15;
update skills set name = 'Stalac', skill_number = 7, attr = 1, id = 128, nameid = '$1968', castgfx = 1801, arrowType = 0 where skill_id = 16;

-- fix all prince spells
-- Glowing Aura
update skills set name = 'Glowing Aura', skill_level = '15',  skill_number = '1',  mpConsume = '30',   hpConsume = '0',  
itemConsumeId = '0',   itemConsumeCount = '0', reuseDelay =  '0', buffDuration = '640', target = 'none',  target_to = '8',  
damage_value = '0', damage_dice = '0', damage_dice_count = '0', probability_value = '0',  probability_dice = '0', 
attr = '0',  type = '2',  lawful =  '0', ranged = '0', area = '-1', through = '0',  id = '2', nameid = '$1996', castgfx = '2277', 
sysmsgID_happen = '0',  sysmsgID_stop = '0', sysmsgID_fail = '0',  arrowType = '0' 
where skill_id = 114;
update skills set name = 'CallPledgeMember', skill_level =  '15', skill_number = '3',  mpConsume = '40',  hpConsume = '0', 
itemConsumeId = '0',  itemConsumeCount = '0', reuseDelay = '0',  buffDuration = '0',  target = 'buff',  target_to = '0',  
damage_value = '0', damage_dice =  '0', damage_dice_count =  '0', probability_value = '0',  probability_dice = '0', 
attr = '0',  type = '2', lawful = '0', ranged = '0', area = '-1', through =  '0', id = '8', nameid = '$1977', castgfx = '0', 
sysmsgID_happen = '0', sysmsgID_stop = '0', sysmsgID_fail = '0', arrowType = '0' 
where skill_id = 116;
update skills set name = 'Shining Aura', skill_level = '15',skill_number = '2', mpConsume = '30', hpConsume = '0',
itemConsumeId = '0', itemConsumeCount = '0', reuseDelay = '0', buffDuration = '640', target = 'none', target_to = '8', 
damage_value = '0', damage_dice = '0', damage_dice_count = '0', probability_value = '0', probability_dice = '0', 
attr = '0', type = '2', lawful = '0', ranged = '0', area = '-1', through = '0', id = '4', nameid = '', castgfx = '3941', 
sysmsgID_happen = '0', sysmsgID_stop = '0', sysmsgID_fail = '280', arrowType = '0' 
where skill_id = 115;
update skills set name = 'Brave Aura', skill_level = '15', skill_number = '4', mpConsume = '40',  hpConsume = '0',
itemConsumeId = '0', itemConsumeCount = '0', reuseDelay = '0', buffDuration = '640', target = 'none', target_to = '8', 
damage_value = '0', damage_dice = '0', damage_dice_count = '0', probability_value = '0', probability_dice =  '0', 
attr = '0', type = '2', lawful =  '0', ranged = '0', area = '-1', through = '0', id = '16', nameid = '$3178', castgfx = '3942', 
sysmsgID_happen = '0', sysmsgID_stop = '0', sysmsgID_fail = '0', arrowType = '0' 
where skill_id = 117;
update skills set name = 'Teleport to Pledge Member', skill_level = '15', skill_number = '5', mpConsume = '30', hpConsume = '0', 
itemConsumeId = '0', itemConsumeCount = '0', reuseDelay = '0', buffDuration = '0', target = 'buff', target_to = '0', 
damage_value = '0', damage_dice = '0', damage_dice_count = '0', probability_value = '0', probability_dice =  '0', 
attr = '0', type = '2', lawful =  '0', ranged = '0', area = '-1', through = '0', id = '32', nameid = '', castgfx = '0', 
sysmsgID_happen = '0', sysmsgID_stop = '0', sysmsgID_fail = '280', arrowType = '0' 
where skill_id = 118;



-- update 25

-- add probability_dice for fblizz
update skills set probability_dice = 7 where skill_id = 80;

-- correct time for uncanny dodge (was 192)
update skills set buffDuration = 210 where skill_id = 106;

-- fix skills name fields
update skills set name = 'Unknown' where skill_id = 119;
update skills set name = 'Unknown' where skill_id = 120;
update skills set name = 'Unknown' where skill_id = 10001;
update skills set name = 'Unknown' where skill_id = 10002;
update skills set name = 'Unknown' where skill_id = 10003;
update skills set name = 'Unknown' where skill_id = 10004;
update skills set name = 'Unknown' where skill_id = 10005;
update skills set name = 'Unknown' where skill_id = 10006;
update skills set name = 'Unknown' where skill_id = 10007;
update skills set name = 'Unknown' where skill_id = 10008;
update skills set name = 'Unknown' where skill_id = 10009;
update skills set name = 'Unknown' where skill_id = 10010;
update skills set name = 'Unknown' where skill_id = 10011;
update skills set name = 'Unknown' where skill_id = 10012;
update skills set name = 'Unknown' where skill_id = 10013;
update skills set name = 'Unknown' where skill_id = 10014;
update skills set name = 'Unknown' where skill_id = 10015;
update skills set name = 'Unknown' where skill_id = 10016;
update skills set name = 'Unknown' where skill_id = 10017;
update skills set name = 'Unknown' where skill_id = 10018;
update skills set name = 'Unknown' where skill_id = 10019;
update skills set name = 'Unknown' where skill_id = 10021;
update skills set name = 'Unknown' where skill_id = 10022;
update skills set name = 'Unknown' where skill_id = 10023;
update skills set name = 'Unknown' where skill_id = 10024;
update skills set name = 'Unknown' where skill_id = 10025;
update skills set name = 'Unknown' where skill_id = 10026;
update skills set name = 'Unknown' where skill_id = 10027;
update skills set name = 'Unknown' where skill_id = 10028;
update skills set name = 'Unknown' where skill_id = 10029;
update skills set name = 'Unknown' where skill_id = 10030;
update skills set name = 'Unknown' where skill_id = 10031;
update skills set name = 'Unknown' where skill_id = 10032;
update skills set name = 'Unknown' where skill_id = 10033;
update skills set name = 'Unknown' where skill_id = 10034;
update skills set name = 'Unknown' where skill_id = 10035;
update skills set name = 'Unknown' where skill_id = 10036;
update skills set name = 'Unknown' where skill_id = 10037;
update skills set name = 'Unknown' where skill_id = 10038;
update skills set name = 'Unknown' where skill_id = 10039;
update skills set name = 'Unknown' where skill_id = 10040;
update skills set name = 'Unknown' where skill_id = 10041;
update skills set name = 'Unknown' where skill_id = 10042;
update skills set name = 'Unknown' where skill_id = 10043;
update skills set name = 'Unknown' where skill_id = 10044;
update skills set name = 'Unknown' where skill_id = 10045;
update skills set name = 'Unknown' where skill_id = 10046;
update skills set name = 'Unknown' where skill_id = 10047;
update skills set name = 'Unknown' where skill_id = 10048;
update skills set name = 'Unknown' where skill_id = 10049;
update skills set name = 'Unknown' where skill_id = 10050;
update skills set name = 'Unknown' where skill_id = 10051;
update skills set name = 'Unknown' where skill_id = 10052;
update skills set name = 'Unknown' where skill_id = 10053;
update skills set name = 'Unknown' where skill_id = 10054;
update skills set name = 'Unknown' where skill_id = 10055;
update skills set name = 'Unknown' where skill_id = 10056;
update skills set name = 'Unknown' where skill_id = 10057;
update skills set name = 'Unknown' where skill_id = 10058;
update skills set name = 'Unknown' where skill_id = 10059;
update skills set name = 'Unknown' where skill_id = 10060;
update skills set name = 'Unknown' where skill_id = 10061;
update skills set name = 'Unknown' where skill_id = 10062;
update skills set name = 'Unknown' where skill_id = 10063;
update skills set name = 'Unknown' where skill_id = 10064;
update skills set name = 'Unknown' where skill_id = 10065;
update skills set name = 'Unknown' where skill_id = 10066;
update skills set name = 'Unknown' where skill_id = 10067;
update skills set name = 'Unknown' where skill_id = 10068;
update skills set name = 'Unknown' where skill_id = 10069;
update skills set name = 'Unknown' where skill_id = 10070;
update skills set name = 'Unknown' where skill_id = 10071;
update skills set name = 'Unknown' where skill_id = 10072;
update skills set name = 'Unknown' where skill_id = 10073;
update skills set name = 'Unknown' where skill_id = 10074;
update skills set name = 'Unknown' where skill_id = 10075;
update skills set name = 'Unknown' where skill_id = 10076;
update skills set name = 'Unknown' where skill_id = 10077;
update skills set name = 'Unknown' where skill_id = 10078;
update skills set name = 'Unknown' where skill_id = 10079;
update skills set name = 'Unknown' where skill_id = 10080;