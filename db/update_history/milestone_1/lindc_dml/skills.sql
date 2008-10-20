-- update 28

-- fix for berserker spell target
update skills set target_to = 24 where skill_id = 55;

-- some name updates for skills
update skills set name = 'Seer spell' where skill_id = 10001;
update skills set name = 'Ice Queen Blizzard' where skill_id = 10002;
update skills set name = 'Zenith Queen spell e first' where skill_id = 10003;
update skills set name = 'Zenith Queen spell e second' where skill_id = 10004;
update skills set name = 'Vampire spell e' where skill_id = 10005;
update skills set name = 'Vampire spellnd e first' where skill_id = 10006;
update skills set name = 'Vampire spellnd e second' where skill_id = 10007;
update skills set name = 'Lesser Dragon e' where skill_id = 10008;
update skills set name = 'Bone Dragon e' where skill_id = 10009;
update skills set name = 'Lich e four' where skill_id = 10010;
update skills set name = 'Medusa e' where skill_id = 10011;
update skills set name = 'Super grimreaper change magicattack e multi' where skill_id = 10012;
update skills set name = 'Super grimreaper sickle e screen' where skill_id = 10013;
update skills set name = 'Ifrit magic e' where skill_id = 10014;
update skills set name = 'Basilisk s blast' where skill_id = 10015;
update skills set name = 'Windcutter bomb' where skill_id = 10016;
update skills set name = 'Icedagger bomb' where skill_id = 10017;
update skills set name = 'Phoenix magic e' where skill_id = 10018;
update skills set name = 'Giant boss attack e' where skill_id = 10019;
update skills set name = 'Spirit of earth boss rockdown' where skill_id = 10020;
update skills set name = 'Spirit of fire boss fireball' where skill_id = 10021;
update skills set name = 'Spirit of water boss spout' where skill_id = 10022;
update skills set name = 'Spirit of water boss spear' where skill_id = 10023;
update skills set name = 'Demon magic' where skill_id = 10024;
update skills set name = 'Corruption Magic E' where skill_id = 10025;
update skills set name = 'Lindvior effect start' where skill_id = 10026;
update skills set name = 'Antaras effect start' where skill_id = 10027;
update skills set name = 'Valakas effect start' where skill_id = 10028;
update skills set name = 'Fafurion effect start' where skill_id = 10029;
update skills set name = 'Succubus v magic' where skill_id = 10030;
update skills set name = 'Succubus g magic' where skill_id = 10031;
update skills set name = 'Zenith Queen Spell e venom' where skill_id = 10032;
update skills set name = 'Imp Magic' where skill_id = 10033;
update skills set name = 'Bomb Flower E' where skill_id = 10034;
update skills set name = 'Ice Eruption' where skill_id = 10035;
update skills set name = 'Mambo Rabbit V E' where skill_id = 10036;
update skills set name = 'Mambo Rabbit R E' where skill_id = 10037;
update skills set name = 'Abyss Lord Magic' where skill_id = 10038;
update skills set name = 'Ariorc Attack I E' where skill_id = 10039;
update skills set name = 'Ariorc Attack Ii E' where skill_id = 10040;
update skills set name = 'Ariorc Attack Iii E' where skill_id = 10041;
update skills set name = 'Lesser Demon Att E' where skill_id = 10042;
update skills set name = 'Dark Elementalist E Multi' where skill_id = 10043;
update skills set name = 'Black Wizard Attack E' where skill_id = 10044;
update skills set name = 'Dire Bat L E Screen' where skill_id = 10045;
update skills set name = 'Blue Tale Laser' where skill_id = 10046;
update skills set name = 'Priest Of Corruption Iv Appear Effect' where skill_id = 10047;
update skills set name = 'Seadancer M A' where skill_id = 10048;
update skills set name = 'Seadancer M B' where skill_id = 10049;
update skills set name = 'Fafurion Ice b' where skill_id = 10050;
update skills set name = 'Fafurion Magic' where skill_id = 10051;
update skills set name = 'Valakas Breath' where skill_id = 10052;
update skills set name = 'Lindvior Breath' where skill_id = 10053;
update skills set name = 'Antharas Magic' where skill_id = 10054;
update skills set name = 'Burst' where skill_id = 10055;
update skills set name = 'Hellfire' where skill_id = 10056;



-- update 30

-- correct spelling of "carriage" and swap ids with counter barrier
update skills set name = 'SolidCarriage', castgfx = 5832, id = 4 where skill_id = 90;
update skills set name = 'CounterBarrier', castgfx = 5831, id = 2 where skill_id = 91;

-- merge in skills changes
update skills set hpconsume = 6 where skill_id = 147;
INSERT INTO `skills` VALUES ('10081', 'Unknown', '0', '0', '0', '0', '0', '0', '0', '0', 'attack', '3', '10', '5', '5', '0', '0', '0', '64', '0', '6', '7', '0', '0', '', '5633', '0', '0', '0');
INSERT INTO `skills` VALUES ('10082', 'Unknown', '0', '0', '0', '0', '0', '0', '0', '0', 'none', '3', '50', '10', '10', '0', '0', '0', '64', '0', '0', '3', '0', '0', '', '5643', '0', '0', '0');
INSERT INTO `skills` VALUES ('10083', 'Unknown', '0', '0', '0', '0', '0', '0', '0', '0', 'attack', '3', '50', '10', '10', '0', '0', '0', '64', '0', '6', '0', '0', '0', '', '4630', '0', '0', '0');
INSERT INTO `skills` VALUES ('10084', 'Unknown', '0', '0', '0', '0', '0', '0', '0', '0', 'none', '3', '100', '10', '10', '0', '0', '0', '64', '0', '0', '3', '0', '0', '', '4627', '0', '0', '0');
INSERT INTO `skills` VALUES ('10085', 'Unknown', '0', '0', '10', '0', '0', '0', '0', '0', 'attack', '3', '10', '5', '5', '0', '0', '0', '64', '0', '1', '0', '0', '0', '', '5522', '0', '0', '0');
INSERT INTO `skills` VALUES ('10086', 'Unknown', '0', '0', '0', '0', '0', '0', '0', '0', 'attack', '3', '10', '10', '10', '0', '0', '0', '64', '0', '8', '0', '0', '0', '', '4674', '0', '0', '0');
INSERT INTO `skills` VALUES ('10087', 'Unknown', '0', '0', '0', '0', '0', '0', '0', '0', 'none', '3', '50', '10', '10', '0', '0', '0', '64', '0', '0', '7', '0', '0', '', '4676', '0', '0', '0');
INSERT INTO `skills` VALUES ('10088', 'Unknown', '0', '0', '0', '0', '0', '0', '0', '0', 'attack', '3', '10', '10', '10', '0', '0', '0', '64', '0', '8', '0', '0', '0', '', '4661', '0', '0', '0');
INSERT INTO `skills` VALUES ('10089', 'Unknown', '0', '0', '0', '0', '0', '0', '0', '0', 'none', '3', '50', '10', '10', '0', '0', '0', '64', '0', '0', '7', '0', '0', '', '4663', '0', '0', '0');

-- r2n changes
update skills set target_to = 16, probability_value = 50, probability_dice = 30, castgfx = 19, sysmsgID_happen = 2245 where skill_id = 145;

update skills set action_id = 19;
update skills set action_id = 18 where skill_id in (4, 6, 7, 10, 11, 15, 16, 17, 22, 25, 28, 30, 34, 38, 45, 
46, 50, 53, 58, 59, 62, 65, 70, 74, 77, 80, 108, 132, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 
10008, 10009, 10010, 10011, 10012, 10013, 10014, 10015, 10016, 10017, 10018, 10019, 10020, 10021, 10022, 10023, 
10024, 10025, 10026, 10027, 10028, 10029, 10030, 10031, 10032, 10033, 10034, 10035, 10036, 10037, 10038, 10039, 
10040, 10041, 10042, 10043, 10044, 10045, 10046, 10047, 10048, 10049, 10050, 10051, 10052, 10053, 10054, 10055, 
10056, 10058, 10059, 10060, 10061, 10062, 10063, 10064, 10065, 10066, 10067, 10068, 10069, 10070, 10072, 10073, 
10074, 10075, 10076, 10077, 10078, 10079, 10080, 10081, 10082, 10083, 10084, 10085, 10086, 10087, 10088, 10089);



-- update 31

-- skill silence buffduration time fix
update skills set buffDuration = 30 where skill_id = 64;

INSERT INTO `skills` VALUES 
('10090', 'Giant guard ant', '0', '0', '5', '0', '0', '0', '0', '0', 'none', '3', '100', '10', '10', '0', '0', '1', '64', '0', '0', '-1', '0', '0', '', '18', '1812', '0', '0', '0'); 
