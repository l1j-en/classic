-- update 22

-- Update for Starting Area ScareCrow Spawns
-- these inserts need an id column entry
-- INSERT INTO spawnlist_npc VALUES ("Silent Cavern", 1, 45001, 32883, 32902, 0, 0, 5, 0, 304, 0);
-- INSERT INTO spawnlist_npc VALUES ("Silent Cavern", 1, 45001, 32883, 32905, 0, 0, 5, 0, 304, 0);
-- INSERT INTO spawnlist_npc VALUES ("Silent Cavern", 1, 45001, 32886, 32902, 0, 0, 5, 0, 304, 0);
-- INSERT INTO spawnlist_npc VALUES ("Silent Cavern", 1, 45001, 32886, 32905, 0, 0, 5, 0, 304, 0);
INSERT INTO spawnlist_npc VALUES (130892, 'HV Dummy', 1, 45003, 32609, 32925, 0, 0, 4, 0, 69, 0);
INSERT INTO spawnlist_npc VALUES (130893, 'HV Dummy', 1, 45003, 32619, 32922, 0, 0, 5, 0, 69, 0);
INSERT INTO spawnlist_npc VALUES (130894, 'HV Dummy', 1, 45003, 32619, 32928, 0, 0, 4, 0, 69, 0);
INSERT INTO spawnlist_npc VALUES (130895, 'HV Dummy', 1, 45003, 32615, 32933, 0, 0, 4, 0, 69, 0);
INSERT INTO spawnlist_npc VALUES (130896, 'HV Dummy', 1, 45003, 32613, 32928, 0, 0, 4, 0, 69, 0);
INSERT INTO spawnlist_npc VALUES (130897, 'HV Dummy', 1, 45003, 32614, 32919, 0, 0, 0, 0, 69, 0);
INSERT INTO spawnlist_npc VALUES (130898, 'SI Dummy', 1, 45003, 32706, 32773, 0, 0, 5, 0, 68, 0);
INSERT INTO spawnlist_npc VALUES (130899, 'SI Dummy', 1, 45003, 32703, 32769, 0, 0, 0, 0, 68, 0);
INSERT INTO spawnlist_npc VALUES (130900, 'SI Dummy', 1, 45003, 32697, 32770, 0, 0, 5, 0, 68, 0);
INSERT INTO spawnlist_npc VALUES (130901, 'SI Dummy', 1, 45003, 32699, 32775, 0, 0, 2, 0, 68, 0);
INSERT INTO spawnlist_npc VALUES (130902, 'SI Dummy', 1, 45003, 32705, 32779, 0, 0, 6, 0, 68, 0);
INSERT INTO spawnlist_npc VALUES (130903, 'SI Dummy', 1, 45003, 32694, 32777, 0, 0, 5, 0, 68, 0);

-- update spawn for npc in Singing Island
update spawnlist_npc set locx = 32758, locy = 32765 where id = 50010;



-- update 24

-- activate skt drist spawn
update spawnlist_npc set count = 1 where npc_templateid = 50055;

-- jp char cleanup spawnlist_npc locations
update spawnlist_npc set location = "HV-Novice tele" where npc_templateid = 50004;
update spawnlist_npc set location = "SI-Novice tele" where npc_templateid = 50010;
update spawnlist_npc set location = "SKT-Drist" where npc_templateid = 50055;
update spawnlist_npc set location = "SKT-Matt" where npc_templateid = 50056;
update spawnlist_npc set location = "Windawood-Trey" where npc_templateid = 50054;
update spawnlist_npc set location = "Gludio-Stevie" where npc_templateid = 50024;
update spawnlist_npc set location = "TI-Lucas" where npc_templateid = 50015;
update spawnlist_npc set location = "Kent-Stanley" where npc_templateid = 50020;
update spawnlist_npc set location = "Heine-Riol" where npc_templateid = 50066;
update spawnlist_npc set location = "Aden-Sirius" where npc_templateid = 50044;
update spawnlist_npc set location = "Aden-Elleris" where npc_templateid = 50046;
update spawnlist_npc set location = "Aden-Kinin" where npc_templateid = 50608;
update spawnlist_npc set location = "Oren-Kirius" where npc_templateid = 50051;
update spawnlist_npc set location = "Werldern-Leslie" where npc_templateid = 50039;
update spawnlist_npc set location = "Giran-Wilma" where npc_templateid = 50036;
update spawnlist_npc set location = "Orc Forest-Daniel" where npc_templateid = 50079;
update spawnlist_npc set location = "Gludio-Paul" where npc_templateid = 50080;
update spawnlist_npc set location = "Elven-Ribian" where npc_templateid = 50065;
update spawnlist_npc set location = "HV-Coco" where npc_templateid = 50006;
update spawnlist_npc set location = "HV-Illdrath" where npc_templateid = 50003;
update spawnlist_npc set location = "HV-Barnia" where npc_templateid = 50001;
update spawnlist_npc set location = "SKT-Market Tele outside" where npc_templateid = 50060;
update spawnlist_npc set location = "Gludio-Market Tele outside" where npc_templateid = 50027; 
update spawnlist_npc set location = "Oren-Market Tele outside" where npc_templateid = 50050;
update spawnlist_npc set location = "Giran-Market Tele outside" where npc_templateid = 50034;
update spawnlist_npc set location = "HV,SI-Esmeralda" where npc_templateid = 50007;
update spawnlist_npc set location = "SI-Ishtar" where npc_templateid = 50009;
update spawnlist_npc set location = "FI-Ishiris" where npc_templateid = 50071;
update spawnlist_npc set location = "FI-Lucky" where npc_templateid = 50070;
update spawnlist_npc set location = "SI-Kun" where npc_templateid = 50011;
update spawnlist_npc set location = "Aden-Edlin" where npc_templateid = 50045;
update spawnlist_npc set location = "HV-Karen" where npc_templateid = 50005;
update spawnlist_npc set location = "HV-Enya" where npc_templateid = 50069;
update spawnlist_npc set location = "SC-Deanos" where npc_templateid = 50068;
update spawnlist_npc set location = "SKT-Bunch" where npc_templateid = 50057;
update spawnlist_npc set location = "TI-Keith" where npc_templateid = 50017;
update spawnlist_npc set location = "Gludio-Hooper" where npc_templateid = 50030;
update spawnlist_npc set location = "Kent-Harrison" where npc_templateid = 50022;
update spawnlist_npc set location = "Windawood-Cobb" where npc_templateid = 50053;
update spawnlist_npc set location = "Gludio-Market Tel inside" where npc_templateid = 50026;
update spawnlist_npc set location = "SKT-Market Tele inside" where npc_templateid = 50059;
update spawnlist_npc set location = "Oren-Market Tele inside" where npc_templateid = 50049;
update spawnlist_npc set location = "Giran-Market Tele inside" where npc_templateid = 50033;
update spawnlist_npc set location = "TOI-2F-Ramuda" where npc_templateid = 50043;
update spawnlist_npc set location = "TI-Dungeon-1F-Dilong" where npc_templateid = 50014;
update spawnlist_npc set location = "Assistant Manager of Coliseum" where npc_templateid = 50019;
update spawnlist_npc set location = "SI-Dueling Field Guide" where npc_templateid = 50013;
update spawnlist_npc set location = "HV-Dueling Field Guide" where npc_templateid = 50008;
update spawnlist_npc set location = "SKT-Coliseum Manager" where npc_templateid = 50061;
update spawnlist_npc set location = "Giran-Coliseum Manager" where npc_templateid = 50037;
update spawnlist_npc set location = "Giran-Coliseum Guard" where npc_templateid = 50084;
update spawnlist_npc set location = "TI-Coliseum Manager" where npc_templateid = 50018;
update spawnlist_npc set location = "Gludio-Coliseum Manager" where npc_templateid = 50028;
update spawnlist_npc set location = "SKT-Assistant Manager of Coliseum" where npc_templateid = 50062;
update spawnlist_npc set location = "Giran-Assistant Manager of Coliseum" where npc_templateid = 50038;
update spawnlist_npc set location = "Giran-Assistant Manager of Coliseum" where npc_templateid = 50029;
update spawnlist_npc set location = "Werldern-Coliseum Manager" where npc_templateid = 50041;
update spawnlist_npc set location = "Werldern-Assistant Manager of Coliseum" where npc_templateid = 50042;
update spawnlist_npc set location = "Kent-Inner Castle-Ober" where npc_templateid = 50023;
update spawnlist_npc set location = "Still need to find" where npc_templateid = 50016;
update spawnlist_npc set location = "Kent-Inner Castle Gatekeeper" where npc_templateid = 50021;
update spawnlist_npc set location = "Windawood-Inner Castle Gatekeeper" where npc_templateid = 50052;
update spawnlist_npc set location = "Orc Forest-Fortress Gatekeeper" where npc_templateid = 50063;
update spawnlist_npc set location = "Giran-Inner Castle Gatekeeper" where npc_templateid = 50035;
update spawnlist_npc set location = "Heine-Inner Castle Gatekeeper" where npc_templateid = 50067;
update spawnlist_npc set location = "Iron Gate-Inner Castle Gatekeeper" where npc_templateid = 50040;
update spawnlist_npc set location = "Aden-Inner Castle Gatekeeper" where npc_templateid = 50047;
update spawnlist_npc set location = "Elven-Fairy Princess" where npc_templateid = 70853;
update spawnlist_npc set location = "Dragon Valley 3F-Sepia" where npc_templateid = 50031;
update spawnlist_npc set location = "Kent-Inner Castle-Niki" where npc_templateid = 50118;
update spawnlist_npc set location = "Lastabad Dungeon 1F-Consul" where npc_templateid = 50127;
update spawnlist_npc set location = "Giudin-TZ-Guard" where npc_templateid = 50025;
update spawnlist_npc set location = "Giran-TZ-Guard" where npc_templateid = 50032;
update spawnlist_npc set location = "Oren-TZ-Guard" where npc_templateid = 50048;
update spawnlist_npc set location = "SKT-TZ-Guard" where npc_templateid = 50058;
update spawnlist_npc set location = "Orc Forest-Duvall" where npc_templateid = 50064;
update spawnlist_npc set location = "Oum Dungeon-Teleporter Diarus" where npc_templateid = 50072;
update spawnlist_npc set location = "Diad Fortress-Teleporter Diabes" where npc_templateid = 50073;
update spawnlist_npc set location = "Diad Fortress-Large Cave Teleporter" where npc_templateid = 50074;
update spawnlist_npc set location = "Diad Fortress-Fortress Gatekeeper" where npc_templateid = 50075;



-- update 25

-- update spawnlist_npc location
update spawnlist_npc sn set sn.location = (select n.name from npc n where n.npcid = sn.npc_templateid);
