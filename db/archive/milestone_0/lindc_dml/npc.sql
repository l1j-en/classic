-- update 1

-- de-aggro elders
update npc set agro = 0 where npcid = 45215;



-- update 3

-- remove elder aggro to sosc
update npc set agrososc = 0 where npcid = 45215;

-- fix bk search party name
update npc set name = 'Black Knight Search Party' where npcid = 81066;

-- fix misnamed dark elf wizard (was black wizard)
update npc set name = 'dark elf wizard' where npcid = 45333;



-- update 4

-- add names to heine dungeon scorp and ramia
update npc set name = 'Scorpian' where npcid = 81077;
update npc set name = 'Ramia' where npcid = 81076;
update npc set nameid = '$966' where npcid = 81077;

-- fix elindaire name and nameid
update npc set name = 'Elindaire', nameid = 'Elindaire' where npcid = 81081;



-- update 8

-- capitalize de wizard name
update npc set name = 'Dark Elf Wizard' where npcid = 45333;



-- update 12

-- fix milk cow name
update npc set name = 'Milk Cow' where npcid = 70984;

-- fix Lyra's name
update npc set name = 'Lyra' where npcid = 70811;

-- fix alchemist's name
update npc set name = 'Alchemist' where npcid = 70520;

-- add hp regen to lvl 30 elf summons and correct their names
-- spirit of earth
update npc set hpr = 2, hprinterval= 5000,  name = 'Spirit of Fire' where npcid = 45303;
-- spirit of water
update npc set hpr = 2, hprinterval= 5000,  name = 'Spirit of Water' where npcid = 45304;
-- spirit of wind
update npc set hpr = 2, hprinterval= 5000,  name = 'Spirit of Wind' where npcid = 45305;
-- spirit of earth
update npc set hpr = 2, hprinterval= 5000,  name = 'Spirit of Earth' where npcid = 45306;



-- update 13

-- fix great spirit of water's name (was great spirit of fire)
update npc set name = 'Great Spirit of Water' where npcid = 45643;

-- fix great spirit of fire's name (was great spirit of water)
update npc set name = 'Great Spirit of Fire' where npcid = 45645;

-- fix NPC Consul's name
update npc set name = 'Consul' where npcid = 50112;

-- fix regen and names on greater elf summons
-- Summoned Spirit of Earth
update npc set name = 'Summoned Spirit of Earth', hprinterval = 5000, hpr = 5 where npcid = 81053;
-- Summoned Spirit of Fire
update npc set name = 'Summoned Spirit of Fire', hprinterval = 5000, hpr = 5 where npcid = 81050;
-- Summoned Spirit of Water
update npc set name = 'Summoned Spirit of Water', hprinterval = 5000, hpr = 5 where npcid = 81051;
-- Summoned Spirit of Wind
update npc set name = 'Summoned Spirit of Wind', hprinterval = 5000, hpr = 5 where npcid = 81052;

-- hp regen modifications for bosses
-- reduce hp regen on Greater Minotaur (200 -> 100)
update npc set hpr = 100 where npcid = 45584;
-- reduce hp regen on Phoenix (500 -> 250)
update npc set hpr = 250 where npcid = 45617;
-- reduce hp regen on Death Knight (416 -> 208)
update npc set hpr = 208 where npcid = 45601;
-- reduce hp regen on Ancient Giant (225 -> 150)
update npc set hpr = 150 where npcid = 45610;
-- reduce hp regen on Ifrit (100 -> 75)
update npc set hpr = 75 where npcid = 45516;
-- reduce hp regen on Caspa (200 -> 150)
update npc set hpr = 150 where npcid = 45488;
-- reduce hp regen on Sema (165 -> 125)
update npc set hpr = 125 where npcid = 45464;
-- reduce hp regen on Baltuzar (180 -> 145)
update npc set hpr = 145 where npcid = 45473;
-- reduce hp regen on Merkyor (250 -> 175)
update npc set hpr = 175 where npcid = 45497;
-- add hp regen on Elindaire (0 -> 50)
update npc set hpr = 50, hprinterval = 5000 where npcid = 81081;
-- reduce hp regen on Necromancer (160 -> 130)
update npc set hpr = 130 where npcid = 45456;
-- reduce giant ant queen hp regen rate (1000 -> 500)
update npc set hpr = 500 where npcid = 45614;
-- reduce Dark Elder hp regen rate (200 -> 180)
update npc set hpr = 180 where npcid = 45545;
-- reduce Demon hp regen rate (350 -> 280)
update npc set hpr = 280 where npcid = 45649;
-- reduce Knight Vlad hp regen rate (300 -> 350)
update npc set hpr = 280 where npcid = 45618;

-- fix name for hiene scorpion
update npc set name = 'Scorpion' where npcid = 81077;

-- de-aggro sharks to sosc and coi
update npc set agrososc = 0, agrocoi = 0 where npcid = 45160;
-- de-aggro crabmen to sosc
update npc set agrososc = 0 where npcid = 45164;
-- de-aggro heine dungeon alligators to sosc
update npc set agrososc = 0 where npcid = 45307;
-- de-aggro aste to sosc
update npc set agrososc = 0 where npcid = 45195;

-- fix name for Skeletal Pirate Soldier (was Skeleton Fighter)
update npc set name = 'Skeletal Pirate Soldier' where npcid = 45274;



-- update 14

-- fix name of Tiger (was Giran Tiger)
update npc set name = 'Tiger' where npcid = 45313;

-- correct name for Giran Vakuuk (was Contaminated Troll)
update npc set name = 'Giran Vakuuk' where npcid = 45187;

-- correct name for Birds (was nothing)
update npc set name = 'Birds' where npcid = 81159;

-- correct name for lvl31 Doppelganger (was nothing)
update npc set name = 'Doppelganger' where npcid = 81069;

-- correct name for Wicked Yeti (was nothing)
update npc set name = 'Wicked Yeti' where npcid = 81043;

-- correct name for Bandit (was nothing)
update npc set name = 'Bandit' where npcid = 81080;

-- correct name for NPC Assistant Manager of the Coliseum (was nothing)
update npc set name = 'Assistant Manager of the Coliseum' where npcid = 50019;

-- correct name for NPC Stanley (was nothing)
update npc set name = 'Stanley' where npcid = 50020;

-- correct name for NPC Castle Gatekeeper (was nothing)
update npc set name = 'Castle Gatekeeper' where npcid = 50021;

-- correct name for NPC Harrison (was nothing)
update npc set name = 'Harrison' where npcid = 50022;

-- correct name for NPC Ober (was nothing)
update npc set name = 'Ober' where npcid = 50023;

-- correct name for NPC Stevie (was nothing)
update npc set name = 'Stevie' where npcid = 50024;

-- correct name for NPC Market Guard (was nothing)
update npc set name = 'Market Guard' where npcid = 50025;

-- correct name for NPC Market Teleporter (was nothing)
update npc set name = 'Market Teleporter' where npcid = 50026;

-- correct name for NPC Market Teleporter (was nothing)
update npc set name = 'Market Teleporter' where npcid = 50027;

-- correct name for NPC Coliseum Manager (was nothing)
update npc set name = 'Coliseum Manager' where npcid = 50028;

-- correct name for NPC Assistant Manager of the Coliseum (was nothing)
update npc set name = 'Assistant Manager of the Coliseum' where npcid = 50029;

-- correct name for NPC Hooper (was nothing)
update npc set name = 'Hooper' where npcid = 50030;

-- correct name for NPC Sepia (was nothing)
update npc set name = 'Sepia' where npcid = 50031;

-- correct name for NPC Market Guard (was nothing)
update npc set name = 'Market Guard' where npcid = 50032;

-- correct name for NPC Market Teleporter (was nothing)
update npc set name = 'Market Teleporter' where npcid = 50033;

-- correct name for NPC Market Teleporter (was nothing)
update npc set name = 'Market Teleporter' where npcid = 50034;

-- correct name for NPC Castle Gatekeeper (was nothing)
update npc set name = 'Castle Gatekeeper' where npcid = 50035;

-- correct name for NPC Wilma (was nothing)
update npc set name = 'Wilma' where npcid = 50036;

-- correct name for NPC Coliseum Manager (was nothing)
update npc set name = 'Coliseum Manager' where npcid = 50037;

-- correct name for NPC Assistant Manager of the Coliseum (was nothing)
update npc set name = 'Assistant Manager of the Coliseum' where npcid = 50038;

-- correct name for NPC Leslie (was nothing)
update npc set name = 'Leslie' where npcid = 50039;

-- correct name for NPC Castle Gatekeeper (was nothing)
update npc set name = 'Castle Gatekeeper' where npcid = 50040;

-- correct name for NPC Coliseum Manager (was nothing)
update npc set name = 'Coliseum Manager' where npcid = 50041;

-- correct name for NPC Assistant Manager of the Coliseum (was nothing)
update npc set name = 'Assistant Manager of the Coliseum' where npcid = 50042;

-- correct name for NPC Ramuda (was nothing)
update npc set name = 'Ramuda' where npcid = 50043;

-- correct name for NPC Sirius (was nothing)
update npc set name = 'Sirius' where npcid = 50044;

-- correct name for NPC Eldin (was nothing)
update npc set name = 'Eldin' where npcid = 50045;

-- correct name for NPC Elleris (was nothing)
update npc set name = 'Elleris' where npcid = 50046;

-- correct name for NPC Castle Gatekeeper (was nothing)
update npc set name = 'Castle Gatekeeper' where npcid = 50047;

-- correct name for NPC Market Guard (was nothing)
update npc set name = 'Market Guard' where npcid = 50048;

-- correct name for NPC Market Teleporter (was nothing)
update npc set name = 'Market Teleporter' where npcid = 50049;

-- correct name for NPC Market Teleporter (was nothing)
update npc set name = 'Market Teleporter' where npcid = 50050;

-- correct name for NPC Kirius (was nothing)
update npc set name = 'Kirius' where npcid = 50051;

-- correct name for NPC Castle Gatekeeper (was nothing)
update npc set name = 'Castle Gatekeeper' where npcid = 50052;

-- correct name for NPC Cobb (was nothing)
update npc set name = 'Cobb' where npcid = 50053;

-- correct name for NPC Trey (was nothing)
update npc set name = 'Trey' where npcid = 50054;

-- correct name for NPC Drist (was nothing)
update npc set name = 'Drist' where npcid = 50055;

-- correct name for NPC Matt (was nothing)
update npc set name = 'Matt' where npcid = 50056;

-- correct name for NPC Bunch (was nothing)
update npc set name = 'Bunch' where npcid = 50057;

-- correct name for NPC Market Guard (was nothing)
update npc set name = 'Market Guard' where npcid = 50058;

-- correct name for NPC Market Teleporter (was nothing)
update npc set name = 'Market Teleporter' where npcid = 50059;

-- correct name for NPC Market Teleporter (was nothing)
update npc set name = 'Market Teleporter' where npcid = 50060;

-- correct name for NPC Coliseum Manager (was nothing)
update npc set name = 'Coliseum Manager' where npcid = 50061;

-- correct name for NPC Assistant Manager of the Coliseum (was nothing)
update npc set name = 'Assistant Manager of the Coliseum' where npcid = 50062;

-- correct name for NPC Fortress Gatekeeper (was nothing)
update npc set name = 'Fortress Gatekeeper' where npcid = 50063;

-- correct name for NPC Duvall (was nothing)
update npc set name = 'Duvall' where npcid = 50064;

-- correct name for NPC Ribian (was nothing)
update npc set name = 'Ribian' where npcid = 50065;

-- correct name for NPC Riol (was nothing)
update npc set name = 'Riol' where npcid = 50066;

-- correct name for NPC Castle Gatekeeper (was nothing)
update npc set name = 'Castle Gatekeeper' where npcid = 50067;

-- correct name for Contaminated Orc Archer (was nothing)
update npc set name = 'Contaminated Orc Archer' where npcid = 81070;

-- correct name for Contaminated Orc (was nothing)
update npc set name = 'Contaminated Orc' where npcid = 81071;

-- correct name for Contaminated Orc Warrior (was nothing)
update npc set name = 'Contaminated Orc Warrior' where npcid = 81072;

-- correct name for Polluted Orc Axe Fighter (was nothing)
update npc set name = 'Polluted Orc Axe Fighter' where npcid = 81073;

-- correct name for Contaminated Orc Spearman (was nothing)
update npc set name = 'Contaminated Orc Spearman' where npcid = 81074;

-- correct name of 81075 Ramia (was nothing)
update npc set name = 'Ramia' where npcid = 81075;

-- correct name for Yahee (was nothing)
update npc set name = 'Yahee' where npcid = 81082;

-- correct name for Owlbear (was nothing)
update npc set name = 'Owlbear' where npcid = 81083;

-- correct name for  Vakuuk (was nothing)
update npc set name = 'Vakuuk' where npcid = 81084;

-- correct name for  Giant Solider Ant (was nothing)
update npc set name = 'Giant Solider Ant' where npcid = 81085;

-- correct name for  Bugbear (was nothing)
update npc set name = 'Bugbear' where npcid = 81086;

-- correct name for  King Bugbear (was nothing)
update npc set name = 'King Bugbear ' where npcid = 81087;

-- correct name for  Skeleton Fighter (was nothing)
update npc set name = 'Skeleton Fighter' where npcid = 81088;

-- correct name for  Ettin (was nothing)
update npc set name = 'Ettin' where npcid = 81089;

-- correct name for  Skeleton Axeman (was nothing)
update npc set name = 'Skeleton Axeman' where npcid = 81090;

-- correct name for  Lycanthrope (was nothing)
update npc set name = 'Lycanthrope' where npcid = 81091;

-- correct name for  Undead Elmore Soldier (was nothing)
update npc set name = 'Undead Elmore Soldier' where npcid = 81091;

-- correct name for  Minotaur (was nothing)
update npc set name = 'Minotaur' where npcid = 81093;

-- correct name for  Skeleton Guard (was nothing)
update npc set name = 'Skeleton Guard' where npcid = 81094;

-- correct name for  Gargoyle (was nothing)
update npc set name = 'Gargoyle' where npcid = 81095;

-- correct name for  Dire Wolf (was nothing)
update npc set name = 'Dire Wolf' where npcid = 81096;

-- correct name for  Lava Golem (was nothing)
update npc set name = 'Lava Golem' where npcid = 81097;

-- correct name for  Cyclops (was nothing)
update npc set name = 'Cyclops' where npcid = 81098;

-- correct name for  Medusa (was nothing)
update npc set name = 'Medusa' where npcid = 81099;

-- correct name for  Skeleton Axeman (was nothing)
update npc set name = 'Skeleton Axeman' where npcid = 81090;

-- correct name for  Lycanthrope (was nothing)
update npc set name = 'Lycanthrope' where npcid = 81091;

-- correct name for  Undead Elmore Soldier (was nothing)
update npc set name = 'Undead Elmore Soldier' where npcid = 81092;

-- correct name for  Minotaur (was nothing)
update npc set name = 'Minotaur' where npcid = 81093;

-- correct name for  Skeleton Guard (was nothing)
update npc set name = 'Skeleton Guard' where npcid = 81094;

-- correct name for  Gargoyle (was nothing)
update npc set name = 'Gargoyle' where npcid = 81095;

-- correct name for  Dire Wolf (was nothing)
update npc set name = 'Dire Wolf' where npcid = 81096;

-- correct name for  Lava Golem (was nothing)
update npc set name = 'Lava Golem' where npcid = 81097;

-- correct name for  Cyclops (was nothing)
update npc set name = 'Cyclops' where npcid = 81098;

-- correct name for  Medusa (was nothing)
update npc set name = 'Medusa' where npcid = 81099;

-- correct name for  Dire Bear (was nothing)
update npc set name = 'Dire Bear' where npcid = 81100;

-- correct name for  Taurverus (was nothing)
update npc set name = 'Taurverus' where npcid = 81101;

-- correct name for  Cockatrice (was nothing)
update npc set name = 'Cockatrice' where npcid = 81102;

-- correct name for  Doppelganger (was nothing)
update npc set name = 'Doppelganger' where npcid = 81103;

-- correct name for  Cougar (was nothing)
update npc set name = 'Cougar' where npcid = 81104;

-- correct name for  Mysterious Rock (was nothing)
update npc set name = 'Mysterious Rock' where npcid = 81105;

-- remove hard skin from caspa group, necro, fire necro, elindaire
update npc set hard = 0 where npcid in (45488, 45497, 45464, 45473, 45456, 45478, 45480, 81081);



-- update 16

-- remove unnamed npc in skt
delete from spawnlist_npc where id = 90068 and npc_templateid = 71035;

-- correct name of Black Tiger (was Black Dragon Scales)
update npc set name = 'Black Tiger' where npcid = 45357;

-- correct name of Giran Lava Golem (was Black Ent)
update npc set name = 'Giran Lava Golem' where npcid = 45376;

-- correct name of Daniel (was nothing)
update npc set name = 'Daniel' where npcid = 50079;

-- correct name of Paul (was nothing)
update npc set name = 'Paul' where npcid = 50080;

-- correct name of Chico (was nothing)
update npc set name = 'Chico' where npcid = 50114;

-- correct name of Gion (was nothing)
update npc set name = 'Gion' where npcid = 50116;

-- correct name of Syria (was nothing)
update npc set name = 'Syria' where npcid = 50117;

-- correct name of Niki (was nothing)
update npc set name = 'Niki' where npcid = 50118;

-- correct name of Oshillia (was nothing)
update npc set name = 'Oshillia' where npcid = 50119;

-- correct name of Hob (was nothing)
update npc set name = 'Hob' where npcid = 50120;

-- correct name of Honin (was nothing)
update npc set name = 'Honin' where npcid = 50121;

-- correct name of Tuck (was nothing)
update npc set name = 'Tuck' where npcid = 50122;

-- correct name of Galleon (was nothing)
update npc set name = 'Galleon' where npcid = 50123;

-- correct name of Porikan (was nothing)
update npc set name = 'Porikan' where npcid = 50124;

-- correct name of Gilbert (was nothing)
update npc set name = 'Gilbert' where npcid = 50125;

-- correct name of Jerik (was nothing)
update npc set name = 'Jerik' where npcid = 50126;

-- correct name of Consul (was nothing)
update npc set name = 'Consul' where npcid = 50127;

-- correct name of Gleda (was nothing)
update npc set name = 'Gleda' where npcid = 50501;

-- correct name of Ginevra (was nothing)
update npc set name = 'Ginevra' where npcid = 50502;

-- correct name of Noela (was nothing)
update npc set name = 'Noela' where npcid = 50503;

-- correct name of Nicoline (was nothing)
update npc set name = 'Nicoline' where npcid = 50504;

-- correct name of Diane (was nothing)
update npc set name = 'Diane' where npcid = 50505;

-- correct name of Duana (was nothing)
update npc set name = 'Duana' where npcid = 50506;

-- correct name of Leonora (was nothing)
update npc set name = 'Leonora' where npcid = 50507;

-- correct name of Lucinda (was nothing)
update npc set name = 'Lucinda' where npcid = 50508;

-- correct name of Livia (was nothing)
update npc set name = 'Livia' where npcid = 50509;

-- correct name of Marina (was nothing)
update npc set name = 'Marina' where npcid = 50510;

-- correct name of Margery (was nothing)
update npc set name = 'Margery' where npcid = 50511;

-- correct name of Mary (was nothing)
update npc set name = 'Mary' where npcid = 50512;

-- correct name of Mennefer (was nothing)
update npc set name = 'Mennefer' where npcid = 50513;

-- correct name of Minerva (was nothing)
update npc set name = 'Minerva' where npcid = 50514;

-- correct name of Miryam (was nothing)
update npc set name = 'Miryam' where npcid = 50515;

-- correct name of Valeska (was nothing)
update npc set name = 'Valeska' where npcid = 50516;

-- correct name of Bernice (was nothing)
update npc set name = 'Bernice' where npcid = 50517;

-- correct name of Vevina (was nothing)
update npc set name = 'Vevina' where npcid = 50518;

-- correct name of Thram (was nothing)
update npc set name = 'Thram' where npcid = 60003;

-- correct name of Denitz (was nothing)
update npc set name = 'Denitz' where npcid = 60004;

-- correct name of Guard (was nothing)
update npc set name = 'Guard' where npcid = 60501;

-- correct name of Court Guard (was nothing)
update npc set name = 'Court Guard' where npcid = 60524;

-- correct name of Arieh (was nothing)
update npc set name = 'Arieh' where npcid = 70015;

-- correct name of Andyn (was nothing)
update npc set name = 'Andyn' where npcid = 70016;

-- correct name of Orim (was nothing)
update npc set name = 'Orim' where npcid = 70017;

-- correct name of Ysorya (was nothing)
update npc set name = 'Ysorya' where npcid = 70018;

-- correct name of Lolia (was nothing)
update npc set name = 'Lolia' where npcid = 70019;

-- correct name of Rollko (was nothing)
update npc set name = 'Rollko' where npcid = 70020;

-- correct name of Luth (was nothing)
update npc set name = 'Luth' where npcid = 70021;

-- correct name of Harbor Master (was nothing)
update npc set name = 'Harbor Master' where npcid = 70022;

-- correct name of Aden Chamber of Commerce (was nothing)
update npc set name = 'Aden Chamber of Commerce' where npcid = 70023;

-- correct name of Catty (was nothing)
update npc set name = 'Catty' where npcid = 70024;

-- correct name of Hector (was nothing)
update npc set name = 'Hector' where npcid = 70642;

-- correct name of Eno (was nothing)
update npc set name = 'Eno' where npcid = 70707;

-- correct name of Giant Elder (was nothing)
update npc set name = 'Giant Elder' where npcid = 70711;

-- correct name of Jimu (was nothing)
update npc set name = 'Jimu' where npcid = 70715;

-- correct name of Paruit (was nothing)
update npc set name = 'Paruit' where npcid = 70722;

-- correct name of Pau (was nothing)
update npc set name = 'Pau' where npcid = 70723;

-- correct name of Heit (was nothing)
update npc set name = 'Heit' where npcid = 70724;

-- correct name of Blood Pledge Administrator (was nothing)
update npc set name = 'Blood Pledge Administrator' where npcid = 70725;

-- correct name of Soldier of Dicarding (was nothing)
update npc set name = 'Soldier of Dicarding' where npcid = 70740;

-- correct name of Roje (was nothing)
update npc set name = 'Roje' where npcid = 70744;

-- correct name of Village Manager (was nothing)
update npc set name = 'Village Manager' where npcid = 70748;

-- correct name of Milo (was nothing)
update npc set name = 'Milo' where npcid = 70749;

-- correct name of Goddess of Atonement (was nothing)
update npc set name = 'Goddess of Atonement' where npcid = 70757;

-- correct name of Secretary to the Mayor (was nothing)
update npc set name = 'Secretary to the Mayor' where npcid = 70761;

-- correct name of Randith (was nothing)
update npc set name = 'Randith' where npcid = 70771;

-- correct name of Marbin (was nothing)
update npc set name = 'Marbin' where npcid = 70773;

-- correct name of Village Manager (was nothing)
update npc set name = 'Village Manager' where npcid = 70774;

-- correct name of Mark (was nothing)
update npc set name = 'Mark' where npcid = 70775;

-- correct name of Mack (was nothing)
update npc set name = 'Mack' where npcid = 70776;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70778;

-- correct name of Gatekeeper Ant (was nothing)
update npc set name = 'Gatekeeper Ant' where npcid = 70779;

-- correct name of Goddess of Atonement (was nothing)
update npc set name = 'Goddess of Atonement' where npcid = 70781;

-- correct name of Aria (was nothing)
update npc set name = 'Aria' where npcid = 70783;

-- correct name of Secretary to the Mayor (was nothing)
update npc set name = 'Secretary to the Mayor' where npcid = 70788;

-- correct name of Halt (was nothing)
update npc set name = 'Halt' where npcid = 70789;

-- correct name of Blood Pledge Administrator (was nothing)
update npc set name = 'Blood Pledge Administrator' where npcid = 70790;

-- correct name of Gerard (was nothing)
update npc set name = 'Gerard' where npcid = 70794;

-- correct name of Dunham (was nothing)
update npc set name = 'Dunham' where npcid = 70796;

-- correct name of Ricky (was nothing)
update npc set name = 'Ricky' where npcid = 70798;

-- correct name of Village Manager (was nothing)
update npc set name = 'Village Manager' where npcid = 70799;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70800;

-- correct name of Goddess of Atonement (was nothing)
update npc set name = 'Goddess of Atonement' where npcid = 70801;

-- correct name of Aanon (was nothing)
update npc set name = 'Aanon' where npcid = 70802;

-- correct name of Joel (was nothing)
update npc set name = 'Joel' where npcid = 70804;

-- correct name of Julie (was nothing)
update npc set name = 'Julie' where npcid = 70805;

-- correct name of Secretary to the Mayor (was nothing)
update npc set name = 'Secretary to the Mayor' where npcid = 70806;

-- correct name of Pin (was nothing)
update npc set name = 'Pin' where npcid = 70807;

-- correct name of Village Manager (was nothing)
update npc set name = 'Village Manager' where npcid = 70815;

-- correct name of Bludika  (was nothing)
update npc set name = 'Bludika' where npcid = 70895;

-- correct name of Kima (was nothing)
update npc set name = 'Kima' where npcid = 70906;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70986;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70987;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70988;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70989;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70990;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70991;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70992;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70996;

-- correct name of Elder Nanome (was nothing)
update npc set name = 'Elder Nanome' where npcid = 71038;

-- correct name of Ant Cave Entrance (was nothing)
update npc set name = 'Ant Cave Entrance' where npcid = 81106;

-- correct name of Guardian Tower (was nothing)
update npc set name = 'Guardian Tower' where npcid = 81111;

-- correct name of Lary\'s Assistant (was nothing)
update npc set name = 'Lary\'s Assistant' where npcid = 81119;

-- correct name of Jack-O-Lantern (was nothing)
update npc set name = 'Jack-O-Lantern' where npcid = 81123;

-- correct name of Jack-O-Lantern (was nothing)
update npc set name = 'Jack-O-Lantern' where npcid = 81124;

-- correct name of Message Board (was nothing)
update npc set name = 'Message Board' where npcid = 81126;

-- correct name of Message Board (was nothing)
update npc set name = 'Message Board' where npcid = 81130;

-- correct name of Torch Fire (was nothing)
update npc set name = 'Torch Fire' where npcid = 81160;

-- correct name of Auction Board (was nothing)
update npc set name = 'Auction Board' where npcid = 81161;

-- make mainland cyclops tamable
update npc set tamable = 1 where npcid = 45420;

-- un-hardskin dark elder
update npc set hard = 0 where npcid in (45545, 45550);

-- add mermaid to merman family
update npc set family = 'merman' where npcid = 45154;

-- remove sosc aggro from Acaleph 
update npc set agrososc = 0 where npcid = 45097;

-- remove tribal from crabmen (was crab)
update npc set family = '' where npcid = 45164;


-- update 19

-- correct name of Fairy Princess (was nothing)
update npc set name = 'Fairy Princess' where npcid = 70853;

-- correct name of Fairy Queen (was nothing)
update npc set name = 'Fairy Queen' where npcid = 70852;

-- correct name of Black Tiger (was nothing)
update npc set name = 'Black Tiger' where npcid = 45836;

-- correct name of Skeletal Pirate Head (was Skeleton Skull)
update npc set name = 'Skeletal Pirate Head' where npcid = 45330;

-- increase phoenix regen (250 -> 320)
update npc set hpr = 320 where npcid = 45617;

-- update 20

-- correct name of Jack-O-Lantern (was Pumpkin Seed)
update npc set name = 'Jack-O-Lantern' where npcid = 45167;

-- correct name of Skeletal Pirate Rogue (was Skeleton Skull)
update npc set name = 'Skeletal Pirate Rogue' where npcid = 45314;

-- correct name of Polluted Deep Flower (was nothing)
update npc set name = 'Polluted Deep Flower' where npcid = 45775;

-- correct name of Dio (was nothing)
update npc set name = 'Dio' where npcid = 70027;

-- correct horrific iron golem weakness to air
update npc set weak_wind = 1 where npcid = 45479;

-- correct Valley Owlbear weakness to earth, fire
update npc set weak_fire = 1, weak_earth = 1 where npcid = 45056;

-- correct Mutated Lizard weakness to air
update npc set weak_wind = 1 where npcid = 45057;

-- correct Valley Harpy weakness to earth, fire
update npc set weak_fire = 1, weak_earth = 1 where npcid = 45067;

-- correct Starved Troll weakness to fire
update npc set weak_fire = 1 where npcid = 45069;

-- correct Giant Tarantula weakness to air
update npc set weak_wind = 1 where npcid = 45070;

-- correct Island Ghast weakness to fire
update npc set weak_wind = 1 where npcid = 45071;

-- correct Sewer Vakuuk weakness to earth, fire
update npc set weak_fire = 1, weak_earth = 1 where npcid = 45072;

-- correct Underground Ramia weakness to air
update npc set weak_wind = 1 where npcid in (45074, 45076);

-- correct Underground Crabman weakness to air, earth
update npc set weak_wind = 1, weak_earth = 1 where npcid = 45075;

-- correct Valley Ogre weakness to fire
update npc set weak_fire = 1 where npcid = 45078;

-- correct Lesser Succubus weakness to air
update npc set weak_wind = 1 where npcid = 45080;

-- correct Island Ghast Lord weakness to fire
update npc set weak_fire = 1 where npcid = 45081;

-- correct Cursed Bugbear weakness to water
update npc set weak_water = 1 where npcid = 45085;

-- correct Valley Griffon weakness to earth, fire
update npc set weak_fire = 1, weak_earth = 1 where npcid = 45090;

-- correct Valley Basilisk weakness to fire
update npc set weak_fire = 1 where npcid = 45091;

-- correct Island Cockatrice weakness to fire
update npc set weak_fire = 1 where npcid = 45095;

-- correct Island Crocodile weakness to air
update npc set weak_wind = 1 where npcid = 45096;

-- correct Lesser Succubus Queen weakness to air
update npc set weak_wind = 1 where npcid = 45110;

-- correct Island Drake weakness to earth, fire
update npc set weak_fire = 1, weak_earth = 1 where npcid = 45111;

-- correct Cursed Ettin weakness to fire
update npc set weak_fire = 1 where npcid = 45112;

-- correct Wild Venom weakness to fire
update npc set weak_fire = 1 where npcid = 45139;

-- correct Giran Lizardman weakness to air
update npc set weak_wind = 1 where npcid = 45156;

-- correct Mad Lizardman weakness to earth
update npc set weak_earth = 1 where npcid = 45158;

-- correct Wild Fang weakness to fire
update npc set weak_fire = 1 where npcid = 45163;

-- correct Giran Vakuuk weakness to fire
update npc set weak_fire = 1 where npcid = 45187;

-- correct Giran Ghast Lord weakness to fire
update npc set weak_fire = 1 where npcid = 45188;

-- correct Dark Elf Guard (bow) weakness to fire
update npc set weak_fire = 1 where npcid in (45175, 45254);

-- correct Right-Hand Bandit weakness to fire
update npc set weak_fire = 1 where npcid in (45194, 45276);

-- correct Wild Magic weakness to earth
update npc set weak_earth = 1 where npcid = 45197;

-- correct Elder weakness to fire
update npc set weak_fire = 1 where npcid = 45215;

-- correct High Lizardman weakness to air
update npc set weak_wind = 1 where npcid = 45217;

-- correct Giran Ramia weakness to air
update npc set weak_wind = 1 where npcid = 45230;

-- correct Dire Bear weakness to fire
update npc set weak_fire = 1 where npcid in (45236, 45252);

-- correct Dire Wolf weakness to earth
update npc set weak_earth = 1 where npcid in (45237, 45282, 45396);

-- correct Blue Tail weakness to air
update npc set weak_wind = 1 where npcid = 45239;

-- correct Giran Tiger weakness to fire
update npc set weak_fire = 1 where npcid = 45243;

-- correct Skeletal Pirate weakness to fire
update npc set weak_fire = 1 where npcid = 45247;

-- correct Kiwi Parrot weakness to earth
update npc set weak_earth = 1 where npcid = 45249;

-- correct Heavy Lizardman weakness to fire
update npc set weak_fire = 1 where npcid = 45251;

-- correct Dark Elf Beast Tamer weakness to water
update npc set weak_water = 1 where npcid in (45266, 45414, 45356);

-- correct Greater Dark Elemental weakness to fire
update npc set weak_fire = 1 where npcid = 45271;

-- correct Skeletal Pirate Soldier weakness to air, fire
update npc set weak_wind = 1, weak_fire = 1 where npcid = 45274;

-- correct Ogre weakness to fire
update npc set weak_fire = 1 where npcid = 45278;

-- correct Giran Stone Golem weakness to air, fire
update npc set weak_wind = 1, weak_fire = 1 where npcid = 45281;

-- correct Giran Cerberus weakness to water
update npc set weak_water = 1 where npcid = 45283;

-- correct Gelatinous Cube weakness to fire
update npc set weak_fire = 1 where npcid = 45296;

-- correct Subterranean Crabman weakness to air
update npc set weak_wind = 1 where npcid = 45297;

-- correct Subterranean Great King Worm weakness to fire
update npc set weak_fire = 1 where npcid = 45360;

-- correct Subterranean Scorpaitan weakness to earth, fire, wind, water
update npc set weak_wind = 1, weak_earth = 1, weak_fire = 1, weak_water = 1 where npcid = 45383;

-- correct Subterranean Great King Turtle weakness to air
update npc set weak_wind = 1 where npcid = 45422;

-- correct Subterranean Elekkadom weakness to air
update npc set weak_wind = 1 where npcid = 45487;

-- correct Giran Arachnevil Elder weakness to fire
update npc set weak_fire = 1 where npcid = 45312;

-- correct Ancient Giant (Fake?) weakness to earth, fire, wind, water
update npc set weak_wind = 1, weak_earth = 1, weak_fire = 1, weak_water = 1 where npcid = 45316;

-- correct Bandit weakness to fire
update npc set weak_fire = 1 where npcid in (45317, 45324, 45329);

-- correct Giran Cimaera weakness to air
update npc set weak_wind = 1 where npcid = 45325;

-- correct Skeletal Pirate Head weakness to fire
update npc set weak_fire = 1 where npcid = 45330;

-- correct Mutant Ramia weakness to air
update npc set weak_wind = 1 where npcid = 45332;

-- correct Mutant Arachnevil Elder weakness to fire
update npc set weak_fire = 1 where npcid = 45348;

-- correct Arachnevil weakness to fire
update npc set weak_fire = 1 where npcid = 45358;

-- correct Bandit Leader weakness to fire
update npc set weak_fire = 1 where npcid = 45370;

-- correct Subterranean Lizardman weakness to air
update npc set weak_wind = 1 where npcid = 45374;

-- correct Giran Lava Golem weakness to water
update npc set weak_water = 1 where npcid = 45376;

-- correct Ghast weakness to fire
update npc set weak_fire = 1 where npcid = 45378;

-- correct Horrific Fire Egg weakness to water
update npc set weak_water = 1 where npcid = 45384;

-- correct Nightmare weakness to water
update npc set weak_water = 1 where npcid in (45385, 45410, 45440, 45564, 45641);

-- correct Dancing Sword weakness to fire
update npc set weak_fire = 1 where npcid = 45386;

-- correct Horrific Cerberus weakness to water
update npc set weak_water = 1 where npcid = 45471;

-- correct Horrific Iron Golem weakness to air
update npc set weak_wind = 1 where npcid = 45479;

-- correct Minotaur weakness to fire
update npc set weak_fire = 1 where npcid in (45390, 45449);

-- correct Succubus of Varlok weakness to air
update npc set weak_wind = 1 where npcid in (45391, 45450);

-- correct Sema weakness to earth, fire
update npc set weak_wind = 1, weak_earth = 1 where npcid = 45464;

-- correct Spirit Taurverus of Fire weakness to water
update npc set weak_water = 1 where npcid = 45520;

-- correct Wicked Mimic weakness to fire
update npc set weak_fire = 1 where npcid = 45399;

-- correct Water Spirit Master weakness to air
update npc set weak_wind = 1 where npcid = 45500;

-- correct Wind Spirit Master weakness to earth
update npc set weak_earth = 1 where npcid = 45510;

-- correct Raging Skeleton Pike weakness to fire
update npc set weak_fire = 1 where npcid = 45403;

-- correct Dark Lycanthrope weakness to earth, fire
update npc set weak_earth = 1, weak_fire = 1 where npcid = 45485;

-- correct Dark Elder weakness to fire
update npc set weak_fire = 1 where npcid in (45550, 45545);

-- correct Demon of Varlok weakness to water
update npc set weak_water = 1 where npcid = 45647;

-- correct Death weakness to fire
update npc set weak_fire = 1 where npcid = 45417;

-- correct Taurverus weakness to 
update npc set weak_water = 1 where npcid = 45408;

-- correct Fang of Earth weakness to fire
update npc set weak_fire = 1 where npcid = 45416;

-- correct Fang of Wind weakness to earth
update npc set weak_earth = 1 where npcid = 45418;

-- correct Fang of Glacier weakness to air
update npc set weak_wind = 1 where npcid = 45419;

-- correct Fang of Flame weakness to water
update npc set weak_water = 1 where npcid = 45424;

-- correct Fire Necromancer weakness to water
update npc set weak_water = 1 where npcid = 45480;

-- correct Fire Ghost  weakness to wind, earth, fire, water
update npc set weak_wind = 1, weak_earth = 1, weak_fire = 1, weak_water = 1 where npcid in (45514, 45519);

-- correct Fire Spirit Master  weakness to water
update npc set weak_water = 1 where npcid = 45511;

-- correct Raging Ghoul weakness to air, fire
update npc set weak_wind = 1, weak_fire = 1 where npcid = 45454;

-- correct Necromancer weakness to earth
update npc set weak_earth = 1 where npcid in (45456, 45478);

-- correct Cursed Orc Zombie weakness to fire, water
update npc set weak_fire = 1, weak_water = 1 where npcid = 45468;

-- correct Crocodile weakness to air
update npc set weak_wind = 1 where npcid = 45469;

-- correct Cruel Snow Tiger weakness to air, fire
update npc set weak_wind = 1, weak_fire = 1 where npcid = 45528;

-- correct Cougar weakness to earth
update npc set weak_earth = 1 where npcid = 45652;

-- correct Baltuzar weakness to fire
update npc set weak_fire = 1 where npcid = 45473;

-- correct Bone Dragon weakness to water
update npc set weak_water = 1 where npcid = 45522;

-- correct Ball Lightning weakness to earth
update npc set weak_earth = 1 where npcid = 45549;

-- correct Fire Warrior of Darkness weakness to water
update npc set weak_water = 1 where npcid = 45540;

-- correct Baphomet of Varlok weakness to fire
update npc set weak_fire = 1 where npcid = 45569;

-- correct Insolent Zenith Queen weakness to wind, earth, fire, water
update npc set weak_wind = 1, weak_earth = 1, weak_fire = 1, weak_water = 1 where npcid = 45581;

-- correct Iris weakness to earth
update npc set weak_earth = 1 where npcid in (45595, 45654);

-- correct Lesser Demon weakness to water
update npc set weak_water = 1 where npcid = 45481;

-- correct Lesser Demon of Varlok weakness to water
update npc set weak_water = 1 where npcid = 45482;

-- correct Lesser Dragon weakness to water
update npc set weak_water = 1 where npcid = 45496;

-- correct Fire Archer of Darkness weakness to water
update npc set weak_water = 1 where npcid = 45532;

-- correct Large Grave Guardian weakness to air, water
update npc set weak_wind = 1, weak_water = 1 where npcid = 45603;

-- correct Great Spirit of Water weakness to air
update npc set weak_wind = 1 where npcid = 45620;

-- correct Grave Guardian Knight weakness to air, water
update npc set weak_wind = 1, weak_water = 1 where npcid = 45537;

-- correct Grave Guardian weakness to air, water
update npc set weak_wind = 1, weak_water = 1 where npcid = 45498;

-- correct Grave Guardian Mage weakness to air, water
update npc set weak_wind = 1, weak_water = 1 where npcid = 45530;

-- correct Killer Bee weakness to earth
update npc set weak_earth = 1 where npcid = 45554;

-- correct Kurtz weakness to water
update npc set weak_water = 1 where npcid = 45600;

-- correct Knight Vald weakness to water
update npc set weak_water = 1 where npcid in (45664, 45618);

-- correct Mummy Lord weakness to fire
update npc set weak_fire = 1 where npcid in (45616, 45653);

-- correct Marquise Vampire weakness to water
update npc set weak_water = 1 where npcid = 45604;

-- correct Abyss Ghoul weakness to air, earth, wather
update npc set weak_wind = 1, weak_earth = 1, weak_water = 1 where npcid = 45501;

-- correct Astagio of Fire weakness to water
update npc set weak_water = 1 where npcid = 45572;

-- correct Abyss Water Spirit weakness to air
update npc set weak_wind = 1 where npcid = 45591;

-- correct Abyss Earth Spirit weakness to fire
update npc set weak_fire = 1 where npcid = 45592;

-- correct Abyss Wind Spirit weakness to earth
update npc set weak_earth = 1 where npcid = 45593;

-- correct Abyss Fire Spirit weakness to water
update npc set weak_water = 1 where npcid = 45594;

-- correct Earth Spirit Master weakness to fire
update npc set weak_fire = 1 where npcid = 45508;

-- correct Zenith Queen weakness to fire, water
update npc set weak_fire = 1, weak_water = 1 where npcid = 45513;

-- correct Zombie Lord of Fear weakness to fire
update npc set weak_fire = 1 where npcid = 45589;

-- correct Zombie Lord weakness to fire
update npc set weak_fire = 1 where npcid = 45650;

-- correct Varlok weakness to water
update npc set weak_water = 1 where npcid = 45613;

-- correct Succubus Queen of Darkness weakness to air
update npc set weak_wind = 1 where npcid = 45580;

-- correct Thing weakness to fire
update npc set weak_fire = 1 where npcid = 45539;

-- correct Lich weakness to earth, water
update npc set weak_earth = 1, weak_water = 1 where npcid = 45672;



-- update 21

-- correct name for Lekman
update npc set name = 'Lekman' where npcid = 50113;

-- correct name for Herbert
update npc set name = 'Herbert' where npcid = 70641;

-- fix Firewall name and light_size
update npc set name = 'Firewall', light_size = 10 where npcid = 81157;



-- update 22

-- fix name and update law color for Goodman, Evilman, Neutraman
update npc set name = 'Goodman' where npcid = 70503;
update npc set lawful = '32767' where npcid = 70503;
update npc set name = 'Neutralman' where npcid = 70504;
update npc set name = 'Evilman' where npcid = 70511;
update npc set lawful = '-32767' where npcid = 70511;

-- Changed npc that where agro on HV and SI.
update npc set agro = '0' where npcid = 45052;
update npc set agro = '0' where npcid = 45038;
update npc set agro = '0' where npcid = 45035;
update npc set agro = '0' where npcid = 45037;
update npc set agro = '0' where npcid = 45078;
update npc set agro = '0' where npcid = 45067;
update npc set agro = '0' where npcid = 45056;
update npc set agro = '0' where npcid = 45090;
update npc set agro = '0' where npcid = 45091;
update npc set agro = '0' where npcid = 45069;
update npc set agro = '0' where npcid = 45075;
update npc set agro = '0' where npcid = 45076;
update npc set agro = '0' where npcid = 45074;
update npc set agro = '0' where npcid = 45061;
update npc set agro = '0' where npcid = 45063;
update npc set agro = '0' where npcid = 45062;
update npc set agro = '0' where npcid = 45086;
update npc set agro = '0' where npcid = 45073;
update npc set agro = '0' where npcid = 45080;
update npc set agro = '0' where npcid = 45081;
update npc set agro = '0' where npcid = 45071;
update npc set agro = '0' where npcid = 45057;
update npc set agro = '0' where npcid = 45026;
update npc set agro = '0' where npcid = 45085;
update npc set agro = '0' where npcid = 45095;
update npc set agro = '0' where npcid = 45096;

-- fix npc names
UPDATE npc SET name = "Serian" WHERE npcid = 50112;
-- correct name of Head Guardsman Kan
update npc set name = 'Head Guardsman Kan', nameid = 'Head Guardsman Kan' where npcid = 70885;

update npc set name = 'Orcish Court Guard' where npcid = 45185;
update npc set nameid = 'Sea Dancer' where npcid = 45228;
update npc set name = 'Giran Snow Tiger' where npcid = 45243;
update npc set name = 'Ancient Apparition' where npcid = 45300;
update npc set name = 'Summon Elemental' where npcid = 45310;
update npc set name = 'Giran Ancient Giant',  nameid = 'Giran Ancient Giant' where npcid = 45316;
update npc set name = 'Dark Forester' where npcid = 45474;
update npc set name = 'Priest of Death' where npcid = 45536;
update npc set name = 'Priest of Death' where npcid = 45542;
update npc set name = 'Follower of Chaos' where npcid = 45544;
update npc set name = 'Dread King Baranka' where npcid = 45651;
update npc set name = 'Guard' where npcid = 45655;
update npc set name = 'Guard' where npcid = 45656;
update npc set name = 'Guard' where npcid = 45657;
update npc set name = 'Guard' where npcid = 45658;
update npc set name = 'Guard' where npcid = 45659;
update npc set name = 'Guard' where npcid = 45660;
update npc set name = 'Guard' where npcid = 45661;
update npc set name = 'Guard' where npcid = 45662;
update npc set name = 'Guard' where npcid = 45663;
update npc set name = 'Baras' where npcid = 45665;
update npc set name = 'Zyrus' where npcid = 45668;
update npc set name = 'Lastabad Royal Guard' where npcid = 45670;
update npc set name = 'Forgotten Mimic' where npcid = 45713;
update npc set name = 'Grave Crocodile' where npcid = 45719;
update npc set name = 'Drowned Male' where npcid = 45720;
update npc set name = 'Drowned Female' where npcid = 45721;
update npc set name = 'Grave Crabman' where npcid = 45725;
update npc set name = 'Grave Sea Dancer' where npcid = 45727;
update npc set name = 'Deep Sea Fish' where npcid = 45728;
update npc set name = 'Hidden Deep Sea Fish' where npcid = 45729;
update npc set name = 'Hidden Ugly Mermaid' where npcid = 45731;
update npc set name = 'Grave Elekkadom' where npcid = 45732;
update npc set name = 'Grave Crustacean' where npcid = 45733;
update npc set nameid = '$4326 $4330' where npcid = 45739;
update npc set name = 'Shiboin of Waves', nameid = '$4326 $4327' where npcid = 45740;
update npc set nameid = '$4326 $4328' where npcid = 45741;
update npc set nameid = '$4326 $4329' where npcid = 45742;
update npc set name = 'Judigo' where npcid = 45744;
update npc set name = 'Dego' where npcid = 45745;
update npc set name = 'Deangus' where npcid = 45746;
update npc set name = 'Angus' where npcid = 45747;
update npc set name = 'Paj' where npcid = 45749;
update npc set name = 'Kobold' where npcid = 45754;
update npc set name = 'Goblin' where npcid = 45755;
update npc set name = 'Orc' where npcid = 45756;
update npc set name = 'Zombie' where npcid = 45757;
update npc set name = 'Orc Archer' where npcid = 45758;
update npc set name = 'Orc Fighter' where npcid = 45759;
update npc set name = 'Floating Eye' where npcid = 45760;
update npc set name = 'Dwarf' where npcid = 45761;
update npc set name = 'Imp' where npcid = 45762;
update npc set name = 'Werewolf' where npcid = 45763;
update npc set name = 'Skeleton' where npcid = 45764;
update npc set name = 'Skeleton Archer' where npcid = 45765;
update npc set name = 'Skeleton Soldier' where npcid = 45766;
update npc set name = 'Gnoll' where npcid = 45767;
update npc set name = 'Stone Golem' where npcid = 45768;
update npc set name = 'Lycanthrope' where npcid = 45769;
update npc set name = 'Polluted Orc Wizard' where npcid = 45770;
update npc set name = 'Contaminated Fairy' where npcid = 45771;
update npc set name = 'Polluted Unkown' where npcid = 45772;
update npc set nameid = '$4145 Elf' where npcid = 45773;
update npc set name = 'Contaminated Ent' where npcid = 45774;
update npc set name = 'Polluted Deep Flower' where npcid = 45775;
update npc set name = 'Polluted Pan' where npcid = 45776;
update npc set name = 'Polluted Arachne' where npcid = 45777;
update npc set name = 'Polluted Human' where npcid = 45778;
update npc set name = 'Polluted Human' where npcid = 45779;
update npc set name = 'Polluted Human' where npcid = 45780;
update npc set name = 'Polluted Human' where npcid = 45781;
update npc set name = 'Polluted Great Spirit\'s Dirty Sycophant' where npcid = 45782;
update npc set name = 'Polluted Great Spirit of Darkness' where npcid = 45783;
update npc set name = 'Polluted Great Spirit of Light' where npcid = 45784;
update npc set name = 'Polluted Great Spirit of Earth' where npcid = 45785;
update npc set name = 'Polluted Great Spirit of Fire' where npcid = 45786;
update npc set name = 'Polluted Great Spirit of Wind' where npcid = 45787;
update npc set name = 'Polluted Great Spirit of Water' where npcid = 45788;
update npc set name = 'Contaminated Orc' where npcid = 45789;
update npc set name = 'Contaminated Orc Archer' where npcid = 45790;
update npc set name = 'Polluted Orc Axe Fighter' where npcid = 45791;
update npc set name = 'Contaminated Orc Warrior' where npcid = 45792;
update npc set name = 'Contaminated Orc Spearman' where npcid = 45793;
update npc set name = 'Servant of Spirit' where npcid = 45794;
update npc set name = 'Spirit' where npcid = 45795;
update npc set name = 'Unknown 45796' where npcid = 45796;
update npc set name = 'Unknown 45797' where npcid = 45797;
update npc set name = 'Unknown 45798' where npcid = 45798;
update npc set name = 'Unknown 45799' where npcid = 45799;
update npc set name = 'Unknown 45800' where npcid = 45800;
update npc set name = 'Unknown 45801' where npcid = 45801;
update npc set name = 'Unknown 45802' where npcid = 45802;
update npc set name = 'Werewolf' where npcid = 45803;
update npc set name = 'Vakuuk' where npcid = 45804;
update npc set name = 'Lizardman' where npcid = 45805;
update npc set name = 'Crabman' where npcid = 45806;
update npc set name = 'Doppelganger' where npcid = 45807;
update npc set name = 'Lycanthrope' where npcid = 45808;
update npc set name = 'Ratman' where npcid = 45809;
update npc set name = 'Merman' where npcid = 45810;
update npc set name = 'Unknown Crabman' where npcid = 45811;
update npc set name = 'Sea Dancer' where npcid = 45812;
update npc set name = 'Unknown Merman' where npcid = 45813;
update npc set name = 'Mutated Alligator' where npcid = 45814;
update npc set name = 'Unknown Ramia' where npcid = 45815;
update npc set name = 'Shark' where npcid = 45816;
update npc set name = 'Doppelganger' where npcid = 45817;
update npc set name = 'Aste' where npcid = 45818;
update npc set name = 'Elekkadom' where npcid = 45819;
update npc set name = 'Unknown Werewolf' where npcid = 45820;
update npc set name = 'Unknown Ramia' where npcid = 45821;
update npc set name = 'Turtle Dragon' where npcid = 45822;
update npc set name = 'Crustacean' where npcid = 45823;
update npc set name = 'Unknown Lycanthrope' where npcid = 45824;
update npc set name = 'Unknown Lizardman' where npcid = 45825;
update npc set name = 'Doppelganger' where npcid = 45826;
update npc set name = 'Unknown Lizardman' where npcid = 45827;
update npc set name = 'Unknown Doppelganger' where npcid = 45828;
update npc set name = 'Unknown 45829' where npcid = 45829;
update npc set name = 'Dark Elf Sodier' where npcid = 45830;
update npc set name = 'Cursed Dark Elf Knight' where npcid = 45831;
update npc set name = 'Cursed Dark Elf Knight' where npcid = 45832;
update npc set name = 'Cursed Dark Elf Knight' where npcid = 45833;
update npc set name = 'Cursed Dark Elf Knight' where npcid = 45834;
update npc set name = 'Cursed Dark Elf Warrior' where npcid = 45835;
update npc set name = 'Lastabad Tormenter' where npcid = 45837;
update npc set name = 'Dark Elf General' where npcid = 45838;
update npc set name = 'Cursed Dark Elf Knight' where npcid = 45839;
update npc set name = 'Cursed Dark Elf Warrior' where npcid = 45840;
update npc set name = 'Unknown 45841' where npcid = 45841;
update npc set name = 'Cursed Dark Elf Knight' where npcid = 45842;
update npc set name = 'Cursed Dark Elf Warrior' where npcid = 45843;
update npc set name = 'Dread King Baranka' where npcid = 45844;
update npc set name = 'Dark Elementalist' where npcid = 45845;
update npc set name = 'Dark Elf Wizard' where npcid = 45846;
update npc set name = 'Cursed Dark Elf Wizard' where npcid = 45847;
update npc set name = 'Dark Elf Wizard' where npcid = 45848;
update npc set name = 'Cursed Dark Elf Warrior' where npcid = 45849;
update npc set name = 'Dark Forester' where npcid = 45850;



-- update 24

-- increase hp/mp regen interval of tiger/battle tiger
update npc set hprinterval = 2500 where npcid = 45313;
update npc set hprinterval = 2500, mprinterval = 2500 where npcid = 45710;

-- increase hp regen interval of greater elf summons, and add mp regen
update npc set hprinterval = 2500, mprinterval = 2500, mpr = 5 where npcid in (81050, 81051, 81052, 81053);

-- create element families for elemental grave mops
update npc set family = 'spiritearth' where npcid in (45416, 45508, 45592);
update npc set family = 'spiritwind' where npcid in (45418, 45418, 45593);
update npc set family = 'spiritwater' where npcid in (45419, 45500, 45591);
update npc set family = 'spiritfire' where npcid in (45424, 45511, 45594);
update npc set family = '' where npcid in (45501, 45502, 45535, 45646);

-- all tribal orcs should be aggro to sosc
update npc set agrososc = 1 where npcid = 45171;

-- remove tamable from orc wizards to prevent killing shopmode chars with aoe
update npc set tamable = 0 where npcid = 45121;

-- fix all npc names
update npc set name = 'Dark Forester' where npcid = 45851;
update npc set name = 'Dark Elementalist' where npcid = 45852;
update npc set name = 'Cursed Dark Elf Wizard' where npcid = 45853;
update npc set name = 'Guardian of Earth Spirit' where npcid = 45854;
update npc set name = 'Guardian of Water Spirit' where npcid = 45855;
update npc set name = 'Guardian of Wind Spirit' where npcid = 45856;
update npc set name = 'Guardian of Fire Spirit' where npcid = 45857;
update npc set name = 'Guardian of Darkness Spirit' where npcid = 45858;
update npc set name = 'Cursed Dark Elf Wizard' where npcid = 45859;
update npc set name = 'Cursed Dark Elf Wizard' where npcid = 45860;
update npc set name = 'Cursed Dark Elf Warrior' where npcid = 45861;
update npc set name = 'Cursed Dark Elf Warrior' where npcid = 45862;
update npc set name = 'Dread Queen Laia' where npcid = 45863;
update npc set name = 'Cursed Dark Elf Wizard' where npcid = 45864;
update npc set name = 'Cursed Dark Elf Knight' where npcid = 45865;
update npc set name = 'Cursed Dark Elf Knight' where npcid = 45866;
update npc set name = 'Cursed Dark Elf Warrior' where npcid = 45867;
update npc set name = 'Oum Warrior' where npcid = 45868;
update npc set name = 'Cursed Dark Elf Wizard' where npcid = 45869;
update npc set name = 'Cursed Dark Elf Knight' where npcid = 45870;
update npc set name = 'Cursed Dark Elf Knight' where npcid = 45871;
update npc set name = 'Heavy Oum Warrior' where npcid = 45872;
update npc set name = 'Eidlon' where npcid = 45873;
update npc set name = 'Unknown Lizardman' where npcid = 45874;
update npc set name = 'Skeletal Pirate Head' where npcid = 45875;
update npc set name = 'Unknown 45876' where npcid = 45876;
update npc set name = 'Treasure Chest' where npcid = 45877;
update npc set name = 'Spirit of Drake' where npcid = 45878;
update npc set name = 'Goblin of Ordeal' where npcid = 45879;
update npc set name = 'Goblin of Ordeal' where npcid = 45880;
update npc set name = 'Goblin of Ordeal' where npcid = 45881;
update npc set name = 'Goblin of Ordeal' where npcid = 45882;
update npc set name = 'Barnia' where npcid = 50001;
update npc set name = 'Sky' where npcid = 50002;
update npc set name = 'Illdrath' where npcid = 50003;
update npc set name = 'Novice Teleporter' where npcid = 50004;
update npc set name = 'Karen' where npcid = 50005;
update npc set name = 'Coco' where npcid = 50006;
update npc set name = 'Esmeralda' where npcid = 50007;
update npc set name = 'Arena Guide' where npcid = 50008;
update npc set name = 'Ishtar' where npcid = 50009;
update npc set name = 'Novice Teleporter' where npcid = 50010;
update npc set name = 'Kun' where npcid = 50011;
update npc set name = 'Kiyari' where npcid = 50012;
update npc set name = 'Arena Guide' where npcid = 50013;
update npc set name = 'Dilong' where npcid = 50014;
update npc set name = 'Lucas' where npcid = 50015;
update npc set name = 'Zeno' where npcid = 50016;
update npc set name = 'Keith' where npcid = 50017;
update npc set name = 'Coliseum Manager' where npcid = 50018;
update npc set name = 'Deanos' where npcid = 50068;
update npc set name = 'Enya' where npcid = 50069;
update npc set name = 'Lucky' where npcid = 50070;
update npc set name = 'Ishiris' where npcid = 50071;
update npc set name = 'Teleporter Diarus' where npcid = 50072;
update npc set name = 'Teleporter Diabes' where npcid = 50073;
update npc set name = 'Large Cave Teleporter' where npcid = 50074;
update npc set name = 'Fortress Gatekeeper' where npcid = 50075;
update npc set name = 'Orb of Spirit' where npcid = 50076;
update npc set name = 'Orb of Spirit' where npcid = 50077;
update npc set name = 'Orb of Spirit' where npcid = 50078;
update npc set name = 'Explorer\'s Assistant' where npcid = 50081;
update npc set name = 'Unknown 50082' where npcid = 50082;
update npc set name = 'Unknown 50083' where npcid = 50083;
update npc set name = 'Guard' where npcid = 50084;
update npc set name = 'Liri' where npcid = 50111;
update npc set name = 'Jaruman' where npcid = 50115;
update npc set name = 'Beth' where npcid = 50119;
update npc set name = 'Sarah' where npcid = 50520;
update npc set name = 'Saloma' where npcid = 50521;
update npc set name = 'Sigrid' where npcid = 50522;
update npc set name = 'Erma' where npcid = 50523;
update npc set name = 'Emilia' where npcid = 50524;
update npc set name = 'Eulalia' where npcid = 50525;
update npc set name = 'Eleanora' where npcid = 50526;
update npc set name = 'Emma' where npcid = 50527;
update npc set name = 'Osa' where npcid = 50528;
update npc set name = 'Even' where npcid = 50529;
update npc set name = 'Ione' where npcid = 50530;
update npc set name = 'Justine' where npcid = 50531;
update npc set name = 'Geraldine' where npcid = 50532;
update npc set name = 'Joanna' where npcid = 50533;
update npc set name = 'Julia' where npcid = 50534;
update npc set name = 'Juliana' where npcid = 50535;
update npc set name = 'Jilda' where npcid = 50536;
update npc set name = 'Karelia' where npcid = 50537;
update npc set name = 'Carmel' where npcid = 50538;
update npc set name = 'Karine' where npcid = 50539;
update npc set name = 'Catriona' where npcid = 50540;
update npc set name = 'Tessa' where npcid = 50541;
update npc set name = 'Teodora' where npcid = 50542;
update npc set name = 'Tekla' where npcid = 50543;
update npc set name = 'Paulina' where npcid = 50544;
update npc set name = 'Henrietta' where npcid = 50545;
update npc set name = 'Nadine' where npcid = 50546;
update npc set name = 'Nash' where npcid = 50547;
update npc set name = 'Natalia' where npcid = 50548;
update npc set name = 'Nona' where npcid = 50549;
update npc set name = 'Nita' where npcid = 50550;
update npc set name = 'Diana' where npcid = 50551;
update npc set name = 'Doria' where npcid = 50552;
update npc set name = 'Dina' where npcid = 50553;
update npc set name = 'Levins' where npcid = 50554;
update npc set name = 'Lucie' where npcid = 50555;
update npc set name = 'Rociri' where npcid = 50556;
update npc set name = 'Locis' where npcid = 50557;
update npc set name = 'Ressie' where npcid = 50558;
update npc set name = 'Lucinda' where npcid = 50559;
update npc set name = 'Liz' where npcid = 50560;
update npc set name = 'Rija' where npcid = 50561;
update npc set name = 'Mariel' where npcid = 50562;
update npc set name = 'McCauley' where npcid = 50563;
update npc set name = 'Meyo' where npcid = 50564;
update npc set name = 'May' where npcid = 50565;
update npc set name = 'Mella' where npcid = 50566;
update npc set name = 'Morin' where npcid = 50567;
update npc set name = 'Mitchel' where npcid = 50568;
update npc set name = 'Michelli' where npcid = 50569;
update npc set name = 'Mindy' where npcid = 50570;
update npc set name = 'Beverly' where npcid = 50571;
update npc set name = 'Beth' where npcid = 50572;
update npc set name = 'Bella' where npcid = 50573;
update npc set name = 'Bonie' where npcid = 50574;
update npc set name = 'Bobby' where npcid = 50575;
update npc set name = 'Brittainy' where npcid = 50576;
update npc set name = 'Bianca' where npcid = 50577;
update npc set name = 'Violet' where npcid = 50578;
update npc set name = 'Sadie' where npcid = 50579;
update npc set name = 'Cellay' where npcid = 50580;
update npc set name = 'Celina' where npcid = 50581;
update npc set name = 'Sophia' where npcid = 50582;
update npc set name = 'Sherrie' where npcid = 50583;
update npc set name = 'Sibia' where npcid = 50584;
update npc set name = 'Cindy' where npcid = 50585;
update npc set name = 'Sylvia' where npcid = 50586;
update npc set name = 'Arana' where npcid = 50587;
update npc set name = 'Amie' where npcid = 50588;
update npc set name = 'Aberi' where npcid = 50589;
update npc set name = 'Acacia' where npcid = 50590;
update npc set name = 'Angelina' where npcid = 50591;
update npc set name = 'Angelica' where npcid = 50592;
update npc set name = 'Edie' where npcid = 50593;
update npc set name = 'Ebony' where npcid = 50594;
update npc set name = 'Angeline' where npcid = 50595;
update npc set name = 'Odia' where npcid = 50596;
update npc set name = 'Ophelia' where npcid = 50597;
update npc set name = 'Wanda' where npcid = 50598;
update npc set name = 'Isabelle' where npcid = 50599;
update npc set name = 'Genesse' where npcid = 50600;
update npc set name = 'Zenith' where npcid = 50601;
update npc set name = 'Joanne' where npcid = 50602;
update npc set name = 'Judith' where npcid = 50603;
update npc set name = 'Chellany' where npcid = 50604;
update npc set name = 'Karot' where npcid = 50605;
update npc set name = 'Karisha' where npcid = 50606;
update npc set name = 'Candice' where npcid = 50607;
update npc set name = 'Kinin' where npcid = 50608;
update npc set name = 'Tamara' where npcid = 50609;
update npc set name = 'Teresa' where npcid = 50610;
update npc set name = 'Prolance' where npcid = 50611;
update npc set name = 'Florina' where npcid = 50612;
update npc set name = 'Helena' where npcid = 50613;
update npc set name = 'Novita' where npcid = 50614;
update npc set name = 'Dain' where npcid = 50615;
update npc set name = 'Delia' where npcid = 50616;
update npc set name = 'Lorena' where npcid = 50617;
update npc set name = 'Morna' where npcid = 50618;
update npc set name = 'Miriam' where npcid = 50619;
update npc set name = 'Adina' where npcid = 50620;
update npc set name = 'Edry' where npcid = 50621;
update npc set name = 'Elsha' where npcid = 50622;
update npc set name = 'Zenia' where npcid = 50623;
update npc set name = 'Triona' where npcid = 50624;
update npc set name = 'Ancient Person' where npcid = 50625;
update npc set name = 'Dorin' where npcid = 60001;
update npc set name = 'Bahof' where npcid = 60002;
update npc set name = 'Luke' where npcid = 60005;
update npc set name = 'Jianku' where npcid = 60006;
update npc set name = 'Karim' where npcid = 60007;
update npc set name = 'Nodim' where npcid = 60008;
update npc set name = 'Sauram' where npcid = 60009;
update npc set name = 'Kasham' where npcid = 60010;
update npc set name = 'Kuron' where npcid = 60011;
update npc set name = 'Tofen' where npcid = 60012;
update npc set name = 'Axellon' where npcid = 60013;
update npc set name = 'Kriom' where npcid = 60014;
update npc set name = 'Ogi' where npcid = 60015;
update npc set name = 'Juke' where npcid = 60016;
update npc set name = 'Karudim' where npcid = 60017;
update npc set name = 'Calvas' where npcid = 60018;
update npc set name = 'Timpukin' where npcid = 60019;
update npc set name = 'Tulak' where npcid = 60020;
update npc set name = 'Hirim' where npcid = 60021;
update npc set name = 'Borgin' where npcid = 60022;
update npc set name = 'Tarkin' where npcid = 60023;
update npc set name = 'Gotham' where npcid = 60024;
update npc set name = 'Kusian' where npcid = 60025;
update npc set name = 'Orclon' where npcid = 60026;
update npc set name = 'Kuhatin' where npcid = 60027;
update npc set name = 'El' where npcid = 60028;
update npc set name = 'Haidrim' where npcid = 60029;
update npc set name = 'Hakim' where npcid = 60030;
update npc set name = 'Rayearth' where npcid = 60031;
update npc set name = 'Storage House Keeper Garin' where npcid = 60032;
update npc set name = 'Storage House Keeper Gaul' where npcid = 60033;
update npc set name = 'Kuud' where npcid = 60034;
update npc set name = 'Zidar' where npcid = 60035;
update npc set name = 'Tigus' where npcid = 60036;
update npc set name = 'Unknown 60037' where npcid = 60037;
update npc set name = 'Guard' where npcid = 60502;
update npc set name = 'Ranger' where npcid = 60503;
update npc set name = 'Ranger' where npcid = 60504;
update npc set name = 'Guard' where npcid = 60505;
update npc set name = 'Guard' where npcid = 60506;
update npc set name = 'Guard' where npcid = 60507;
update npc set name = 'Guard' where npcid = 60508;
update npc set name = 'Guard' where npcid = 60509;
update npc set name = 'Guard' where npcid = 60510;
update npc set name = 'Court Guard' where npcid = 60511;
update npc set name = 'Court Guard' where npcid = 60512;
update npc set name = 'Guard' where npcid = 60513;
update npc set name = 'Court Guard' where npcid = 60514;
update npc set name = 'Kent Mercenary Squad' where npcid = 60515;
update npc set name = 'Kent Mercenary Squad' where npcid = 60516;
update npc set name = 'Guard' where npcid = 60517;
update npc set name = 'Guard' where npcid = 60518;
update npc set name = 'Blue Sharks' where npcid = 60519;
update npc set name = 'Kent Mercenary Squad' where npcid = 60520;
update npc set name = 'Kent Mercenary Squad' where npcid = 60521;
update npc set name = 'Guard' where npcid = 60522;
update npc set name = 'Guard' where npcid = 60523;
update npc set name = 'Court Guard' where npcid = 60525;
update npc set name = 'Giran Mercenary Squad' where npcid = 60526;
update npc set name = 'Giran Mercenary Squad' where npcid = 60527;
update npc set name = 'Gludin Guard', nameid = 'Gludin $240' where npcid = 60528;
update npc set name = 'Court Guard' where npcid = 60529;
update npc set name = 'Dwarf Guard' where npcid = 60530;
update npc set name = 'Dwarf Guard' where npcid = 60531;
update npc set name = 'Unknown 60532', nameid = 'Unknown 60532' where npcid = 60532;
update npc set name = 'Aden Castle Guard', nameid = 'Aden Castle $240' where npcid = 60533;
update npc set name = 'Aden Castle Guard', nameid = 'Aden Castle $240' where npcid = 60534;
update npc set name = 'Aden Court Guard' where npcid = 60535;
update npc set name = 'Aden Court Guard' where npcid = 60536;
update npc set name = 'Aden Guard' where npcid = 60537;
update npc set name = 'Aden Guard' where npcid = 60538;
update npc set name = 'Aden Mercenary Squad' where npcid = 60539;
update npc set name = 'Aden Mercenary Squad' where npcid = 60540;
update npc set name = 'Guard' where npcid = 60541;
update npc set name = 'Guard' where npcid = 60542;
update npc set name = 'Guard' where npcid = 60543;
update npc set name = 'Guard' where npcid = 60544;
update npc set name = 'Guard' where npcid = 60545;
update npc set name = 'Guard' where npcid = 60546;
update npc set name = 'Guard' where npcid = 60547;
update npc set name = 'Guard' where npcid = 60548;
update npc set name = 'Court Guard' where npcid = 60549;
update npc set name = 'Court Guard' where npcid = 60550;
update npc set name = 'Windawood Castle Guard' where npcid = 60551;
update npc set name = 'Court Guard' where npcid = 60552;
update npc set name = 'Windawood Mercenary Squad' where npcid = 60553;
update npc set name = 'Windawood Mercenary Squad' where npcid = 60554;
update npc set name = 'Unknown 60555', nameid = 'Unknown 60555' where npcid = 60555;
update npc set name = 'Guard' where npcid = 60556;
update npc set name = 'Guard' where npcid = 60557;
update npc set name = 'Gerard Mercenary Squad' where npcid = 60558;
update npc set name = 'Gerard Mercenary Squad' where npcid = 60559;
update npc set name = 'Orcish Court Guard' where npcid = 60560;
update npc set name = 'Court Guard' where npcid = 60561;
update npc set name = 'Court Guard' where npcid = 60562;
update npc set name = 'Heine Guard' where npcid = 60563;
update npc set name = 'Unknown 60564', nameid = 'Unknown 60564' where npcid = 60564;
update npc set name = 'Unknown 60565', nameid = 'Unknown 60565' where npcid = 60565;
update npc set name = 'Dark Elf Ranger' where npcid = 60566;
update npc set name = 'Guard' where npcid = 60567;
update npc set name = 'Rose' where npcid = 70001;
update npc set name = 'Sasha' where npcid = 70002;
update npc set name = 'Siriss' where npcid = 70003;
update npc set name = 'Unknown 70004' where npcid = 70004;
update npc set name = 'Pago' where npcid = 70005;
update npc set name = 'Kiris' where npcid = 70006;
update npc set name = 'Tina' where npcid = 70007;
update npc set name = 'Fraoun' where npcid = 70008;
update npc set name = 'Gereng' where npcid = 70009;
update npc set name = 'Balsim' where npcid = 70010;
update npc set name = 'Harbor Master' where npcid = 70011;
update npc set name = 'Selena' where npcid = 70012;
update npc set name = 'Cole' where npcid = 70013;
update npc set name = 'Pandora' where npcid = 70014;
update npc set name = 'Pasim' where npcid = 70025;
update npc set name = 'Derek' where npcid = 70026;
update npc set name = 'Randal' where npcid = 70028;
update npc set name = 'Margaret' where npcid = 70029;
update npc set name = 'Mayer' where npcid = 70030;
update npc set name = 'Molly' where npcid = 70031;
update npc set name = 'Vergil' where npcid = 70032;
update npc set name = 'Verita' where npcid = 70033;
update npc set name = 'Vincent' where npcid = 70034;
update npc set name = 'Izawa' where npcid = 70035;
update npc set name = 'Stella' where npcid = 70036;
update npc set name = 'Aden Chamber of Commerce' where npcid = 70037;
update npc set name = 'Evert' where npcid = 70038;
update npc set name = 'Werner' where npcid = 70039;
update npc set name = 'Jason' where npcid = 70040;
update npc set name = 'Maeno' where npcid = 70041;
update npc set name = 'Tanaka' where npcid = 70042;
update npc set name = 'Philip' where npcid = 70043;
update npc set name = 'Ralf' where npcid = 70044;
update npc set name = 'Berry' where npcid = 70045;
update npc set name = 'Jin' where npcid = 70046;
update npc set name = 'Defman' where npcid = 70047;
update npc set name = 'Raon' where npcid = 70048;
update npc set name = 'Rozen' where npcid = 70049;
update npc set name = 'Ruky' where npcid = 70050;
update npc set name = 'Magus' where npcid = 70051;
update npc set name = 'Melissa' where npcid = 70052;
update npc set name = 'Shara' where npcid = 70053;
update npc set name = 'Sabin' where npcid = 70054;
update npc set name = 'Ashinnue' where npcid = 70055;
update npc set name = 'Jode' where npcid = 70056;
update npc set name = 'Catherine' where npcid = 70057;
update npc set name = 'Fega' where npcid = 70058;
update npc set name = 'Dico' where npcid = 70059;
update npc set name = 'Linda' where npcid = 70060;
update npc set name = 'Mandra' where npcid = 70061;
update npc set name = 'Varyeth' where npcid = 70062;
update npc set name = 'Bius' where npcid = 70063;
update npc set name = 'Aden Chamber of Commerce' where npcid = 70064;
update npc set name = 'Enke' where npcid = 70065;
update npc set name = 'Kreister' where npcid = 70066;
update npc set name = 'Pagoru' where npcid = 70067;
update npc set name = 'Franko' where npcid = 70068;
update npc set name = 'Momo' where npcid = 70069;
update npc set name = 'Velisa' where npcid = 70070;
update npc set name = 'Ashur' where npcid = 70071;
update npc set name = 'Elmina' where npcid = 70072;
update npc set name = 'Glen' where npcid = 70073;
update npc set name = 'Mellin' where npcid = 70074;
update npc set name = 'Miranda' where npcid = 70075;
update npc set name = 'Aden Chamber of Commerce' where npcid = 70076;
update npc set name = 'Rodney' where npcid = 70077;
update npc set name = 'Orcm' where npcid = 70078;
update npc set name = 'Jackson' where npcid = 70079;
update npc set name = 'Horun' where npcid = 70080;
update npc set name = 'Buakheu' where npcid = 70081;
update npc set name = 'Britt' where npcid = 70082;
update npc set name = 'Shivan' where npcid = 70083;
update npc set name = 'Elly' where npcid = 70084;
update npc set name = 'Old' where npcid = 70085;
update npc set name = 'Isvall' where npcid = 70086;
update npc set name = 'Sedia' where npcid = 70087;
update npc set name = 'Squalid' where npcid = 70088;
update npc set name = 'Oblivion' where npcid = 70089;
update npc set name = 'Chicky' where npcid = 70090;
update npc set name = 'Tilon' where npcid = 70091;
update npc set name = 'Trader Emart' where npcid = 70092;
update npc set name = 'Trader Carupu' where npcid = 70093;
update npc set name = 'Duran' where npcid = 70094;
update npc set name = 'Duron' where npcid = 70095;
update npc set name = 'Millay' where npcid = 70096;
update npc set name = 'Foni' where npcid = 70097;
update npc set name = 'Bobo' where npcid = 70098;
update npc set name = 'Kuper' where npcid = 70099;
update npc set name = 'Lengo' where npcid = 70100;
update npc set name = 'Fiin' where npcid = 70101;
update npc set name = 'Judice' where npcid = 70102;
update npc set name = 'Eban' where npcid = 70501;
update npc set name = 'Arena Guide' where npcid = 70502;
update npc set name = 'Unknown 70505' where npcid = 70505;
update npc set name = 'Ruba' where npcid = 70506;
update npc set name = 'Rion' where npcid = 70507;
update npc set name = 'Weapon Enchanter' where npcid = 70508;
update npc set name = 'Armor Enchanter' where npcid = 70509;
update npc set name = 'Polymorph Magician' where npcid = 70510;
update npc set name = 'Healer' where npcid = 70512;
update npc set name = 'Peria' where npcid = 70513;
update npc set name = 'Haste Master' where npcid = 70514;
update npc set name = 'Mubo' where npcid = 70515;
update npc set name = 'Belgeter' where npcid = 70516;
update npc set name = 'Cuse' where npcid = 70517;
update npc set name = 'Tio' where npcid = 70518;
update npc set name = 'Peria' where npcid = 70519;
update npc set name = 'Guard' where npcid = 70521;
update npc set name = 'Gunter' where npcid = 70522;
update npc set name = 'Ladar' where npcid = 70523;
update npc set name = 'Lavienue' where npcid = 70524;
update npc set name = 'Lien' where npcid = 70525;
update npc set name = 'Raidar' where npcid = 70526;
update npc set name = 'Terry' where npcid = 70527;
update npc set name = 'Village Manager' where npcid = 70528;
update npc set name = 'Mona' where npcid = 70529;
update npc set name = 'Goddess of Atonement' where npcid = 70530;
update npc set name = 'Jem' where npcid = 70531;
update npc set name = 'Johnson' where npcid = 70532;
update npc set name = 'Judice' where npcid = 70533;
update npc set name = 'Secratary to the Mayor' where npcid = 70534;
update npc set name = 'Unknown 70535' where npcid = 70535;
update npc set name = 'Touma' where npcid = 70536;
update npc set name = 'Farlin' where npcid = 70537;
update npc set name = 'Blood Pledge Administrator' where npcid = 70538;
update npc set name = 'Unknown 70539' where npcid = 70539;
update npc set name = 'Guard' where npcid = 70541;
update npc set name = 'Gayle' where npcid = 70542;
update npc set name = 'Unknown 70543' where npcid = 70543;
update npc set name = 'Rick' where npcid = 70544;
update npc set name = 'Richard' where npcid = 70545;
update npc set name = 'Village Manager' where npcid = 70546;
update npc set name = 'Weapon Enchanter' where npcid = 70547;
update npc set name = 'Unknown 70548' where npcid = 70548;
update npc set name = 'Gatekeeper' where npcid = 70549;
update npc set name = 'Armor Enchanter' where npcid = 70550;
update npc set name = 'Unknown 70551' where npcid = 70551;
update npc set name = 'Unknown 70552' where npcid = 70552;
update npc set name = 'Ishmael' where npcid = 70553;
update npc set name = 'Zero' where npcid = 70554;
update npc set name = 'Jim' where npcid = 70555;
update npc set name = 'Secratary to the Mayor' where npcid = 70556;
update npc set name = 'Cana' where npcid = 70557;
update npc set name = 'Kent Mercenary Squad' where npcid = 70558;
update npc set name = 'Kent Mercenary Squad' where npcid = 70559;
update npc set name = 'Blood Pledge Administrator' where npcid = 70560;
update npc set name = 'Unknown 70561', nameid = 'Unknown 70561' where npcid = 70561;
update npc set name = 'Mercenary Captain Hunt' where npcid = 70562;
update npc set name = 'Guard' where npcid = 70564;
update npc set name = 'Unknown 70566' where npcid = 70566;
update npc set name = 'Village Manager' where npcid = 70567;
update npc set name = 'Yuno' where npcid = 70568;
update npc set name = 'Jaint' where npcid = 70569;
update npc set name = 'Jyta' where npcid = 70570;
update npc set name = 'Unknown 70571' where npcid = 70571;
update npc set name = 'Secratary to the Mayor' where npcid = 70572;
update npc set name = 'Farbo' where npcid = 70573;
update npc set name = 'Guard' where npcid = 70575;
update npc set name = 'Garth' where npcid = 70576;
update npc set name = 'Auctioneer' where npcid = 70577;
update npc set name = 'Unknown 70578' where npcid = 70578;
update npc set name = 'Unknown 70579' where npcid = 70579;
update npc set name = 'Unknown 70580' where npcid = 70580;
update npc set name = 'Gulian' where npcid = 70581;
update npc set name = 'Neil' where npcid = 70582;
update npc set name = 'Nelson' where npcid = 70583;
update npc set name = 'Daria' where npcid = 70584;
update npc set name = 'Damon' where npcid = 70585;
update npc set name = 'Daisy' where npcid = 70586;
update npc set name = 'Doris' where npcid = 70587;
update npc set name = 'Unknown 70588' where npcid = 70588;
update npc set name = 'Laban' where npcid = 70589;
update npc set name = 'Luke' where npcid = 70590;
update npc set name = 'Lina' where npcid = 70591;
update npc set name = 'Leal' where npcid = 70592;
update npc set name = 'Manus' where npcid = 70593;
update npc set name = 'Village Manager' where npcid = 70594;
update npc set name = 'Mandel' where npcid = 70595;
update npc set name = 'Malcom' where npcid = 70596;
update npc set name = 'Moran' where npcid = 70597;
update npc set name = 'Moria' where npcid = 70598;
update npc set name = 'Weapon Enchanter' where npcid = 70599;
update npc set name = 'Gatekeeper' where npcid = 70600;
update npc set name = 'Armor Enchanter' where npcid = 70601;
update npc set name = 'Velma' where npcid = 70602;
update npc set name = 'Bruno' where npcid = 70603;
update npc set name = 'Bridget' where npcid = 70604;
update npc set name = 'Blaise' where npcid = 70605;
update npc set name = 'Victor' where npcid = 70606;
update npc set name = 'Sarsha' where npcid = 70607;
update npc set name = 'Shalina' where npcid = 70608;
update npc set name = 'Sally' where npcid = 70609;
update npc set name = 'Sherwin' where npcid = 70610;
update npc set name = 'Goddess of Atonement' where npcid = 70611;
update npc set name = 'Sidney' where npcid = 70612;
update npc set name = 'Amanda' where npcid = 70613;
update npc set name = 'Anton' where npcid = 70614;
update npc set name = 'Alda' where npcid = 70615;
update npc set name = 'Aldred' where npcid = 70616;
update npc set name = 'Almon' where npcid = 70617;
update npc set name = 'Andrew' where npcid = 70618;
update npc set name = 'Alice' where npcid = 70619;
update npc set name = 'Eban' where npcid = 70620;
update npc set name = 'Evelyn' where npcid = 70621;
update npc set name = 'Eliza' where npcid = 70622;
update npc set name = 'Orville' where npcid = 70623;
update npc set name = 'Oliver' where npcid = 70624;
update npc set name = 'Iola' where npcid = 70625;
update npc set name = 'Jack' where npcid = 70626;
update npc set name = 'Jenny' where npcid = 70627;
update npc set name = 'Jessy' where npcid = 70628;
update npc set name = 'James' where npcid = 70629;
update npc set name = 'Giles' where npcid = 70630;
update npc set name = 'Secratary to the Mayor' where npcid = 70631;
update npc set name = 'Kevin' where npcid = 70632;
update npc set name = 'Colbert' where npcid = 70633;
update npc set name = 'Tanya' where npcid = 70634;
update npc set name = 'Tyrus' where npcid = 70635;
update npc set name = 'Terry' where npcid = 70636;
update npc set name = 'Tovia' where npcid = 70637;
update npc set name = 'Tracey' where npcid = 70638;
update npc set name = 'Ferdinand' where npcid = 70639;
update npc set name = 'Pierre' where npcid = 70640;
update npc set name = 'Helen' where npcid = 70641;
update npc set name = 'Blood Pledge Administrator' where npcid = 70644;
update npc set name = 'Guard' where npcid = 70646;
update npc set name = 'Gavin' where npcid = 70647;
update npc set name = 'Daley' where npcid = 70648;
update npc set name = 'Lary' where npcid = 70649;
update npc set name = 'Horse of Lary' where npcid = 70650;
update npc set name = 'Lary\'s Soldier' where npcid = 70651;
update npc set name = 'Lary\'s Assistant' where npcid = 70652;
update npc set name = 'Marshall' where npcid = 70653;
update npc set name = 'Village Manager' where npcid = 70654;
update npc set name = 'Weapon Enchanter' where npcid = 70655;
update npc set name = 'Gatekeeper' where npcid = 70656;
update npc set name = 'Armor Enchanter' where npcid = 70657;
update npc set name = 'Goddess of Atonement' where npcid = 70658;
update npc set name = 'Atara' where npcid = 70659;
update npc set name = 'Unknown 70660' where npcid = 70660;
update npc set name = 'Unknown 70661' where npcid = 70661;
update npc set name = 'Ivelviin' where npcid = 70662;
update npc set name = 'Secratary to the Mayor' where npcid = 70663;
update npc set name = 'Cove' where npcid = 70664;
update npc set name = 'Potempin' where npcid = 70665;
update npc set name = 'Freckson' where npcid = 70666;
update npc set name = 'Blood Pledge Administrator' where npcid = 70667;
update npc set name = 'Auctioneer' where npcid = 70669;
update npc set name = 'Cray' where npcid = 70670;
update npc set name = 'Nose' where npcid = 70671;
update npc set name = 'Raphael' where npcid = 70672;
update npc set name = 'Unknown 70673' where npcid = 70673;
update npc set name = 'Reona' where npcid = 70674;
update npc set name = 'Rose' where npcid = 70675;
update npc set name = 'Ryumiel' where npcid = 70676;
update npc set name = 'Lilia' where npcid = 70677;
update npc set name = 'Unknown 70678' where npcid = 70678;
update npc set name = 'Marja' where npcid = 70679;
update npc set name = 'Mikey' where npcid = 70680;
update npc set name = 'Matilda' where npcid = 70681;
update npc set name = 'Marx' where npcid = 70682;
update npc set name = 'Montes' where npcid = 70683;
update npc set name = 'Words of Montes' where npcid = 70684;
update npc set name = 'Words of Montes' where npcid = 70685;
update npc set name = 'Weapon Enchanter' where npcid = 70686;
update npc set name = 'Gatekeeper' where npcid = 70687;
update npc set name = 'Muras' where npcid = 70688;
update npc set name = 'Misa' where npcid = 70689;
update npc set name = 'Bamute' where npcid = 70690;
update npc set name = 'Barbara' where npcid = 70691;
update npc set name = 'Armor Enchanter' where npcid = 70692;
update npc set name = 'Buckley' where npcid = 70693;
update npc set name = 'Brutus' where npcid = 70694;
update npc set name = 'Biust' where npcid = 70695;
update npc set name = 'Bindro' where npcid = 70696;
update npc set name = 'Seratti' where npcid = 70697;
update npc set name = 'Selma' where npcid = 70698;
update npc set name = 'Sheryan' where npcid = 70699;
update npc set name = 'Sabin' where npcid = 70700;
update npc set name = 'Goddess Agata' where npcid = 70701;
update npc set name = 'Goddess Ariel' where npcid = 70702;
update npc set name = 'Aden Court Guard' where npcid = 70703;
update npc set name = 'Aden Court Guard' where npcid = 70704;
update npc set name = 'Arin' where npcid = 70705;
update npc set name = 'Aquin' where npcid = 70706;
update npc set name = 'Eno' where npcid = 70707;
update npc set name = 'Affleck' where npcid = 70708;
update npc set name = 'Elleanor' where npcid = 70709;
update npc set name = 'Unknown 70710' where npcid = 70710;
update npc set name = 'Jennifer' where npcid = 70712;
update npc set name = 'Jessica' where npcid = 70713;
update npc set name = 'Jaimy' where npcid = 70714;
update npc set name = 'Jimu' where npcid = 70715;
update npc set name = 'Chobi' where npcid = 70716;
update npc set name = 'Karas' where npcid = 70717;
update npc set name = 'Kenihi' where npcid = 70718;
update npc set name = 'Calvin' where npcid = 70719;
update npc set name = 'Unknown 70720' where npcid = 70720;
update npc set name = 'Timon' where npcid = 70721;
update npc set name = 'Paruit' where npcid = 70722;
update npc set name = 'Pau' where npcid = 70723;
update npc set name = 'Heit' where npcid = 70724;
update npc set name = 'Unknown 70726' where npcid = 70726;
update npc set name = 'Unknown 70727' where npcid = 70727;
update npc set name = 'Unknown 70728' where npcid = 70728;
update npc set name = 'Unknown 70729' where npcid = 70729;
update npc set name = 'Unknown 70730' where npcid = 70730;
update npc set name = 'Unknown 70731' where npcid = 70731;
update npc set name = 'Unknown 70732' where npcid = 70732;
update npc set name = 'Unknown 70733' where npcid = 70733;
update npc set name = 'Garuga' where npcid = 70735;
update npc set name = 'Derian' where npcid = 70736;
update npc set name = 'Dekan' where npcid = 70737;
update npc set name = 'Defuri' where npcid = 70738;
update npc set name = 'Dicarding' where npcid = 70739;
update npc set name = 'Soldier of Dicarding' where npcid = 70740;
update npc set name = 'Dima' where npcid = 70741;
update npc set name = 'Detector' where npcid = 70742;
update npc set name = 'Lazloth' where npcid = 70743;
update npc set name = 'Roku' where npcid = 70745;
update npc set name = 'Rotus' where npcid = 70746;
update npc set name = 'Lulu' where npcid = 70747;
update npc set name = 'Unknown 70750' where npcid = 70750;
update npc set name = 'Brad' where npcid = 70751;
update npc set name = 'Biyan' where npcid = 70752;
update npc set name = 'Bion' where npcid = 70753;
update npc set name = 'Unknown 70754' where npcid = 70754;
update npc set name = 'Unknown 70755' where npcid = 70755;
update npc set name = 'Moria' where npcid = 70756;
update npc set name = 'Sabin' where npcid = 70758;
update npc set name = 'Unknown 70759' where npcid = 70759;
update npc set name = 'Ellyonne' where npcid = 70760;
update npc set name = 'Karif' where npcid = 70762;
update npc set name = 'Talass' where npcid = 70763;
update npc set name = 'Taus' where npcid = 70764;
update npc set name = 'Tifany' where npcid = 70765;
update npc set name = 'Paper Man' where npcid = 70766;
update npc set name = 'Haro' where npcid = 70767;
update npc set name = 'Guard' where npcid = 70769;
update npc set name = 'Deker' where npcid = 70770;
update npc set name = 'Raidar' where npcid = 70772;
update npc set name = 'Weapon Enchanter' where npcid = 70777;
update npc set name = 'Armor Enchanter' where npcid = 70780;
update npc set name = 'Search Ant' where npcid = 70782;
update npc set name = 'Othmond' where npcid = 70783;
update npc set name = 'Windawood Mercenary Squad' where npcid = 70785;
update npc set name = 'Windawood Mercenary Squad' where npcid = 70786;
update npc set name = 'Windawood Head of Mercenary Squad' where npcid = 70787;
update npc set name = 'Unknown 70791' where npcid = 70791;
update npc set name = 'Guard' where npcid = 70793;
update npc set name = 'Gerard Mercenary Squad' where npcid = 70795;
update npc set name = 'Anotte' where npcid = 70803;
update npc set name = 'Guard' where npcid = 70809;
update npc set name = 'Nenani Guard' where npcid = 70810;
update npc set name = 'Rohan' where npcid = 70812;
update npc set name = 'Ruu Duda-Mara' where npcid = 70813;
update npc set name = 'Ruka' where npcid = 70814;
update npc set name = 'Weapon Enchanter' where npcid = 70816;
update npc set name = 'Gatekeeper' where npcid = 70817;
update npc set name = 'Bazure Atuba' where npcid = 70818;
update npc set name = 'Bob' where npcid = 70819;
update npc set name = 'Armor Enchanter' where npcid = 70820;
update npc set name = 'Sanita' where npcid = 70821;
update npc set name = 'Saghem Atuba' where npcid = 70822;
update npc set name = 'Goddess of Atonement' where npcid = 70823;
update npc set name = 'Assassin Master\'s Apprentice' where npcid = 70824;
update npc set name = 'Ellne' where npcid = 70825;
update npc set name = 'Oth' where npcid = 70826;
update npc set name = 'Orcish Court Guard' where npcid = 70827;
update npc set name = 'Ofo' where npcid = 70828;
update npc set name = 'Woodford' where npcid = 70829;
update npc set name = 'Secretary to the Mayor' where npcid = 70830;
update npc set name = 'Kentu Neruga' where npcid = 70831;
update npc set name = 'Taga Rova' where npcid = 70832;
update npc set name = 'Tommy' where npcid = 70833;
update npc set name = 'Torban' where npcid = 70834;
update npc set name = 'Hanna' where npcid = 70835;
update npc set name = 'Hans' where npcid = 70836;
update npc set name = 'Narhen' where npcid = 70837;
update npc set name = 'Nerupa' where npcid = 70838;
update npc set name = 'Doett' where npcid = 70839;
update npc set name = 'Robiel' where npcid = 70840;
update npc set name = 'Luudiel' where npcid = 70841;
update npc set name = 'Marba' where npcid = 70842;
update npc set name = 'Morien' where npcid = 70843;
update npc set name = 'Unknown 70844' where npcid = 70844;
update npc set name = 'Aras' where npcid = 70845;
update npc set name = 'Arachne' where npcid = 70846;
update npc set name = 'Est' where npcid = 70847;
update npc set name = 'Ent' where npcid = 70848;
update npc set name = 'Theodore' where npcid = 70849;
update npc set name = 'Pan' where npcid = 70850;
update npc set name = 'Fairy' where npcid = 70851;
update npc set name = 'Hurindalien' where npcid = 70854;
update npc set name = 'Gayle' where npcid = 70856;
update npc set name = 'Heine Guard' where npcid = 70857;
update npc set name = 'Derick' where npcid = 70858;
update npc set name = 'Velma' where npcid = 70859;
update npc set name = 'Village Manager' where npcid = 70860;
update npc set name = 'Weapon Enchanter' where npcid = 70861;
update npc set name = 'Heine Gatekeeper' where npcid = 70862;
update npc set name = 'Heine Gatekeeper' where npcid = 70863;
update npc set name = 'Vaiger' where npcid = 70864;
update npc set name = 'Armor Enchanter' where npcid = 70865;
update npc set name = 'Unknown 70866' where npcid = 70866;
update npc set name = 'Shannon' where npcid = 70867;
update npc set name = 'Stra' where npcid = 70868;
update npc set name = 'Unknown 70869' where npcid = 70869;
update npc set name = 'Arina' where npcid = 70870;
update npc set name = 'Annabel' where npcid = 70871;
update npc set name = 'Eveurol' where npcid = 70872;
update npc set name = 'Ellan' where npcid = 70873;
update npc set name = 'Elina' where npcid = 70874;
update npc set name = 'Oriel' where npcid = 70875;
update npc set name = 'Secretary to the Mayor' where npcid = 70876;
update npc set name = 'Trion' where npcid = 70877;
update npc set name = 'Felix' where npcid = 70878;
update npc set name = 'Unknown 70879' where npcid = 70879;
update npc set name = 'Fisher' where npcid = 70880;
update npc set name = 'Heine Mercenary Squad' where npcid = 70881;
update npc set name = 'Vaiger' where npcid = 70882;
update npc set name = 'Unknown 70883' where npcid = 70883;
update npc set name = 'Blood Pledge Administrator' where npcid = 70884;
update npc set name = 'Unknown 70886' where npcid = 70886;
update npc set name = 'Granik' where npcid = 70887;
update npc set name = 'Derin' where npcid = 70888;
update npc set name = 'Ramune' where npcid = 70889;
update npc set name = 'Rabor' where npcid = 70890;
update npc set name = 'Rondo' where npcid = 70891;
update npc set name = 'Ronde' where npcid = 70892;
update npc set name = 'Ronde\'s Horse' where npcid = 70893;
update npc set name = 'Ronde\'s Bodyguard' where npcid = 70894;
update npc set name = 'Personal Assassin of Bludika' where npcid = 70896;
update npc set name = 'Bishop' where npcid = 70897;
update npc set name = 'Seria' where npcid = 70898;
update npc set name = 'Unknown 70899' where npcid = 70899;
update npc set name = 'Ellvienue' where npcid = 70900;
update npc set name = 'Jeti' where npcid = 70901;
update npc set name = 'Kalynue' where npcid = 70902;
update npc set name = 'Kan\'s Guard' where npcid = 70903;
update npc set name = 'Koup' where npcid = 70904;
update npc set name = 'Unknown 70905' where npcid = 70905;
update npc set name = 'Personal Assassin of Kima' where npcid = 70907;
update npc set name = 'Pierce' where npcid = 70908;
update npc set name = 'Pierot' where npcid = 70909;
update npc set name = 'Hadesty' where npcid = 70910;
update npc set name = 'Hamud' where npcid = 70911;
update npc set name = 'Miner Oum' where npcid = 70912;
update npc set name = 'Miner Oum' where npcid = 70913;
update npc set name = 'Unknown 70914' where npcid = 70914;
update npc set name = 'Unknown 70915' where npcid = 70915;
update npc set name = 'Redin' where npcid = 70916;
update npc set name = 'Burns' where npcid = 70917;
update npc set name = 'Unknown 70918' where npcid = 70918;
update npc set name = 'Smiter' where npcid = 70919;
update npc set name = 'Aden Reconnaissance Soldier' where npcid = 70920;
update npc set name = 'Unknown 70921' where npcid = 70921;
update npc set name = 'Oum' where npcid = 70922;
update npc set name = 'Olle' where npcid = 70923;
update npc set name = 'Unknown Oum',  nameid = 'Unknown $3124' where npcid = 70924;
update npc set name = 'Elder Oum' where npcid = 70925;
update npc set name = 'Unknown 70926' where npcid = 70926;
update npc set name = 'Coderage' where npcid = 70927;
update npc set name = 'Tristan' where npcid = 70928;
update npc set name = 'Unknown 70929' where npcid = 70929;
update npc set name = 'Unknown 70930' where npcid = 70930;
update npc set name = 'Unknown 70931' where npcid = 70931;
update npc set name = 'Doyle' where npcid = 70932;
update npc set name = 'Doyle\'s Dog' where npcid = 70933;
update npc set name = 'Resta' where npcid = 70934;
update npc set name = 'Roberto' where npcid = 70935;
update npc set name = 'Rooney' where npcid = 70936;
update npc set name = 'Rudien' where npcid = 70937;
update npc set name = 'Lukein' where npcid = 70938;
update npc set name = 'Lupus' where npcid = 70939;
update npc set name = 'Lizardman Elder' where npcid = 70940;
update npc set name = 'Young Lizardman Warrior' where npcid = 70941;
update npc set name = 'Monett' where npcid = 70942;
update npc set name = 'Berik' where npcid = 70943;
update npc set name = 'Shian' where npcid = 70944;
update npc set name = 'Simizz' where npcid = 70945;
update npc set name = 'Enishia' where npcid = 70946;
update npc set name = 'Exhausted Lizardman Warrior' where npcid = 70947;
update npc set name = 'Cadmus' where npcid = 70948;
update npc set name = 'Karu' where npcid = 70949;
update npc set name = 'Kamit' where npcid = 70950;
update npc set name = 'Spirit of Kamyla' where npcid = 70951;
update npc set name = 'Franko' where npcid = 70952;
update npc set name = 'Unknown 70954' where npcid = 70954;
update npc set name = 'Unknown 70955' where npcid = 70955;
update npc set name = 'Lesser Demon' where npcid = 70956;
update npc set name = 'Roy' where npcid = 70957;
update npc set name = 'Unknown 70958' where npcid = 70958;
update npc set name = 'Unknown 70959' where npcid = 70959;
update npc set name = 'Unknown 70960' where npcid = 70960;
update npc set name = 'Unknown 70961' where npcid = 70961;
update npc set name = 'Unknown 70962' where npcid = 70962;
update npc set name = 'Incarnation of Varlok' where npcid = 70963;
update npc set name = 'Basch' where npcid = 70964;
update npc set name = 'Shackled Aden Soldier' where npcid = 70965;
update npc set name = 'Shackled Aden Soldier' where npcid = 70966;
update npc set name = 'Shackled Aden Soldier' where npcid = 70967;
update npc set name = 'Unknown 70968' where npcid = 70968;
update npc set name = 'Unknown 70969' where npcid = 70969;
update npc set name = 'Priest of Corruption' where npcid = 70972;
update npc set name = 'Fesco' where npcid = 70973;
update npc set name = 'Unknown 70974' where npcid = 70974;
update npc set name = 'Unknown 70975' where npcid = 70975;
update npc set name = 'Unknown 70976' where npcid = 70976;
update npc set name = 'Unknown 70977' where npcid = 70977;
update npc set name = 'Unknown 70978' where npcid = 70978;
update npc set name = 'Unknown 70979' where npcid = 70979;
update npc set name = 'Liri' where npcid = 70980;
update npc set name = 'Hen' where npcid = 70981;
update npc set name = 'Duck' where npcid = 70982;
update npc set name = 'Pig' where npcid = 70983;
update npc set name = 'Gatekeeper' where npcid = 70985;
update npc set name = 'Gatekeeper' where npcid = 70986;
update npc set name = 'Gatekeeper' where npcid = 70987;
update npc set name = 'Gatekeeper' where npcid = 70988;
update npc set name = 'Gatekeeper' where npcid = 70989;
update npc set name = 'Gatekeeper' where npcid = 70990;
update npc set name = 'Gatekeeper' where npcid = 70991;
update npc set name = 'Gatekeeper' where npcid = 70992;
update npc set name = 'Gatekeeper' where npcid = 70993;
update npc set name = 'Gatekeeper' where npcid = 70994;
update npc set name = 'Gatekeeper' where npcid = 70995;
update npc set name = 'Gatekeeper' where npcid = 70996;
update npc set name = 'Unknown 70997' where npcid = 70997;
update npc set name = 'Unknown 70998' where npcid = 70998;
update npc set name = 'Unknown 70999' where npcid = 70999;
update npc set name = 'Unknown 71000' where npcid = 71000;
update npc set name = 'Unknown 71001' where npcid = 71001;
update npc set name = 'Unknown 71002' where npcid = 71002;
update npc set name = 'Unknown 71003' where npcid = 71003;
update npc set name = 'Unknown 71004' where npcid = 71004;
update npc set name = 'Unknown 71005' where npcid = 71005;
update npc set name = 'Unknown 71006' where npcid = 71006;
update npc set name = 'Unknown 71007' where npcid = 71007;
update npc set name = 'Message Board' where npcid = 72008;
update npc set name = 'Unknown 71009' where npcid = 71009;
update npc set name = 'Unknown 71010' where npcid = 71010;
update npc set name = 'Unknown 71011' where npcid = 71011;
update npc set name = 'Unknown 71012' where npcid = 71012;
update npc set name = 'Karen' where npcid = 71013;
update npc set name = 'Unknown 71014' where npcid = 71014;
update npc set name = 'Unknown 71015' where npcid = 71015;
update npc set name = 'Unknown 71016' where npcid = 71016;
update npc set name = 'Unknown 71017' where npcid = 71017;
update npc set name = 'Unknown 71018' where npcid = 71018;
update npc set name = 'Unknown 71019' where npcid = 71019;
update npc set name = 'Unknown 71020' where npcid = 71020;
update npc set name = 'Unknown 71021' where npcid = 71021;
update npc set name = 'Unknown 71022' where npcid = 71022;
update npc set name = 'Unknown 71023' where npcid = 71023;
update npc set name = 'Garrett' where npcid = 71024;
update npc set name = 'Unknown 71025' where npcid = 71025;
update npc set name = 'Unknown 71026' where npcid = 71026;
update npc set name = 'Unknown 71027' where npcid = 71027;
update npc set name = 'Unknown 71028' where npcid = 71028;
update npc set name = 'Unknown 71029' where npcid = 71029;
update npc set name = 'Healer' where npcid = 71030;
update npc set name = 'Unknown 71031' where npcid = 71031;
update npc set name = 'Unknown 71032' where npcid = 71032;
update npc set name = 'Unknown 71033' where npcid = 71033;
update npc set name = 'Unknown 71034' where npcid = 71034;
update npc set name = 'Unknown 71035' where npcid = 71035;
update npc set name = 'Spirit of Kamyla' where npcid = 71036;
update npc set name = 'Healer' where npcid = 71037;
update npc set name = 'Unknown 71039' where npcid = 71039;
update npc set name = 'Noah' where npcid = 71040;
update npc set name = 'Hoomo' where npcid = 71041;

update npc set name = 'Psuedo Shadow of Flame', nameid = 'Psuedo Shadow of Flame', lawful = -32767 where npcid = 81114;



-- update 25

-- fix npc names
update npc set name = 'Oshillia' where npcid = 50119;
update npc set name = 'Beth' where npcid = 50519;
update npc set name = 'Aria' where npcid = 70783;
update npc set name = 'Othmond' where npcid = 70784;
update npc set name = 'Message Board' where npcid = 71008;
update npc set name = 'Vakumo' where npcid = 71042;
update npc set name = 'Booka' where npcid = 71043;
update npc set name = 'Camay' where npcid = 71044;
update npc set name = 'Unknown 71045' where npcid = 71045;
update npc set name = 'Roberto' where npcid = 71046;
update npc set name = 'Lupus' where npcid = 71047;
update npc set name = 'Karu' where npcid = 71048;
update npc set name = 'Rooney' where npcid = 71049;
update npc set name = 'Shian' where npcid = 71050;
update npc set name = 'Monett' where npcid = 71051;
update npc set name = 'Enishia' where npcid = 71052;
update npc set name = 'Berik' where npcid = 71053;
update npc set name = 'Roxanne' where npcid = 71054;
update npc set name = 'Lukein' where npcid = 71055;
update npc set name = 'Simizz' where npcid = 71056;
update npc set name = 'Doyle' where npcid = 71057;
update npc set name = 'Doyle\'s Dog' where npcid = 71058;
update npc set name = 'Rudian' where npcid = 71059;
update npc set name = 'Resta' where npcid = 71060;
update npc set name = 'Cadmus' where npcid = 71061;
update npc set name = 'Kamit' where npcid = 71062;
update npc set name = 'Small Box' where npcid = 71063;
update npc set name = 'Small Box' where npcid = 71064;
update npc set name = 'Small Box' where npcid = 71065;
update npc set name = 'Small Box' where npcid = 71066;
update npc set name = 'Small Box' where npcid = 71067;
update npc set name = 'Small Box' where npcid = 71068;
update npc set name = 'Small Box' where npcid = 71069;
update npc set name = 'Small Box' where npcid = 71070;
update npc set name = 'Small Box' where npcid = 71071;
update npc set name = 'Small Box' where npcid = 71072;
update npc set name = 'Small Box' where npcid = 71073;
update npc set name = 'Lizardman Elder' where npcid = 71074;
update npc set name = 'Exhausted Lizardman Warrior' where npcid = 71075;
update npc set name = 'Young Lizardman Warrior' where npcid = 71076;
update npc set name = 'Geographical Explorer' where npcid = 71077;
update npc set name = 'Unknown 71078' where npcid = 71078;
update npc set name = 'Unknown 71079' where npcid = 71079;
update npc set name = 'Unknown 71080' where npcid = 71080;
update npc set name = 'Unknown 71081' where npcid = 71081;
update npc set name = 'Unknown 71082' where npcid = 71082;
update npc set name = 'Unknown 71083' where npcid = 71083;
update npc set name = 'Unknown 71084' where npcid = 71084;
update npc set name = 'One of the Red Key\'s Secrets' where npcid = 71085;
update npc set name = 'Unknown 71086' where npcid = 71086;
update npc set name = 'Unknown 71087' where npcid = 71087;
update npc set name = 'Unknown 71088' where npcid = 71088;
update npc set name = 'Franco' where npcid = 71089;
update npc set name = 'Crystal of Ordeal' where npcid = 71090;
update npc set name = 'Crystal of Ordeal' where npcid = 71091;
update npc set name = 'Oasis Stuff' where npcid = 80001;
update npc set name = 'Large Christmas Tree' where npcid = 80002;
update npc set name = 'Small Christmas Tree' where npcid = 80003;
update npc set name = 'Large Christmas Tree' where npcid = 80004;
update npc set name = 'Weather Vane' where npcid = 80005;
update npc set name = 'Message Board' where npcid = 80006;
update npc set name = 'Flying Bird' where npcid = 80007;
update npc set name = 'Ship' where npcid = 80008;
update npc set name = 'Treasure Chest' where npcid = 80009;
update npc set name = 'Unknown 80010' where npcid = 80010;
update npc set name = 'Unknown 80011' where npcid = 80011;
update npc set name = 'Unknown 80012' where npcid = 80012;
update npc set name = 'Unknown 80013' where npcid = 80013;
update npc set name = 'Unknown 80014' where npcid = 80014;
update npc set name = 'Unknown 80015' where npcid = 80015;
update npc set name = 'Unknown 80016' where npcid = 80016;
update npc set name = 'Unknown 80017' where npcid = 80017;
update npc set name = 'Unknown 80018' where npcid = 80018;
update npc set name = 'Unknown 80019', nameid = ''  where npcid = 80019;
update npc set name = 'Unknown 80020', nameid = '' where npcid = 80020;
update npc set name = 'Unknown 80021' where npcid = 80021;
update npc set name = 'Unknown 80022' where npcid = 80022;
update npc set name = 'Unknown 80023' where npcid = 80023;
update npc set name = 'Unknown 80024' where npcid = 80024;
update npc set name = 'Unknown 80025' where npcid = 80025;
update npc set name = 'Unknown 80026' where npcid = 80026;
update npc set name = 'Unknown 80027' where npcid = 80027;
update npc set name = 'Unknown 80028' where npcid = 80028;
update npc set name = 'Unknown 80029' where npcid = 80029;
update npc set name = 'Unknown 80030' where npcid = 80030;
update npc set name = 'Unknown 80031' where npcid = 80031;
update npc set name = 'Unknown 80032' where npcid = 80032;
update npc set name = 'Unknown 80033' where npcid = 80033;
update npc set name = 'Unknown 80034', nameid = '' where npcid = 80034;
update npc set name = 'Unknown 80035', nameid = '' where npcid = 80035;
update npc set name = 'Unknown 80036', nameid = '' where npcid = 80036;
update npc set name = 'Unknown 80037', nameid = '' where npcid = 80037;
update npc set name = 'Ivory Tower Wizard' where npcid = 80038;
update npc set name = 'Ivory Tower Wizard' where npcid = 80039;
update npc set name = 'Ivory Tower Wizard' where npcid = 80040;
update npc set name = 'Ivory Tower Wizard' where npcid = 80041;
update npc set name = 'Unknown 80042' where npcid = 80042;
update npc set name = 'Unknown 80043' where npcid = 80043;
update npc set name = 'Unknown 80044' where npcid = 80044;
update npc set name = 'Unknown 80045' where npcid = 80045;
update npc set name = 'Chamberlain of Yahee' where npcid = 80047;
update npc set name = 'Twisting of Space' where npcid = 80048;
update npc set name = 'Unknown 80049' where npcid = 80049;
update npc set name = 'Unknown 80050' where npcid = 80050;
update npc set name = 'Yahee' where npcid = 80051;
update npc set name = 'Unknown 80052' where npcid = 80052;
update npc set name = 'Unknown 80053' where npcid = 80053;
update npc set name = 'Unknown 80054' where npcid = 80054;
update npc set name = 'Unknown 80055' where npcid = 80055;
update npc set name = 'Unknown 80056' where npcid = 80056;
update npc set name = 'Alfons' where npcid = 80057;
update npc set name = 'Unknown 80058' where npcid = 80058;
update npc set name = 'Unknown 80059' where npcid = 80059;
update npc set name = 'Unknown 80060' where npcid = 80060;
update npc set name = 'Unknown 80061' where npcid = 80061;
update npc set name = 'Unknown 80062' where npcid = 80062;
update npc set name = 'Unknown 80063' where npcid = 80063;
update npc set name = 'Unknown 80064' where npcid = 80064;
update npc set name = 'Agent of Varlok' where npcid = 80065;
update npc set name = 'Unknown 80066' where npcid = 80066;
update npc set name = 'Unknown 80067' where npcid = 80067;
update npc set name = 'Incarnation of Varlok' where npcid = 80068;
update npc set name = 'Lesser Demon' where npcid = 80069;
update npc set name = 'Lesser Demon' where npcid = 80070;
update npc set name = 'Assistant of Varlok' where npcid = 80071;
update npc set name = 'Blacksmith of Varlok' where npcid = 80072;
update npc set name = 'Unknown 80073' where npcid = 80073;
update npc set name = 'Unknown 80074' where npcid = 80074;
update npc set name = 'Beheak' where npcid = 80075;
update npc set name = 'Rotting Voyager' where npcid = 80076;
update npc set name = 'Unknown 80077' where npcid = 80077;
update npc set name = 'Harbor Master' where npcid = 81000;
update npc set name = 'Ramia' where npcid = 81107;
update npc set name = 'Zombie' where npcid = 81108;
update npc set name = 'Skeleton' where npcid = 81109;
update npc set name = 'Unknown 81110', nameid = '' where npcid = 81110;
update npc set name = 'Rader' where npcid = 81112;
update npc set name = 'Hagutin' where npcid = 81113;
update npc set name = 'Black Knight Captainn' where npcid = 81115;
update npc set name = 'Fettered Soul' where npcid = 81118;
update npc set name = 'Servant of Kalbas' where npcid = 81120;
update npc set name = 'Ancient Spirit' where npcid = 81121;
update npc set name = 'Siege Flag' where npcid = 81122;
update npc set name = 'Jack-O-Latern' where npcid = 81123;
update npc set name = 'Crown' where npcid = 81125;
update npc set name = 'Black Knight', nameid = 'Black Knight' where npcid = 81030;
update npc set name = 'Black Mage', nameid = 'Black Mage' where npcid = 81031;
update npc set name = 'Black Ranger', nameid = 'Black Ranger' where npcid = 81032;
update npc set name = 'Silver Knight', nameid = 'Silver Knight' where npcid = 81033;
update npc set name = 'Silver Mage', nameid = 'Silver Mage' where npcid = 81034;
update npc set name = 'Silver Ranger', nameid = 'Silver Ranger' where npcid = 81035;
update npc set name = 'Sword Master', nameid = 'Sword Master' where npcid = 81036;
update npc set name = 'Wizardry Master', nameid = 'Wizardry Master' where npcid = 81037;
update npc set name = 'Arrow Master', nameid = 'Arrow Master' where npcid = 81038;
update npc set name = 'Arch Knight', nameid = 'Arch Knight' where npcid = 81039;
update npc set name = 'Arch Mage', nameid = 'Arch Mage' where npcid = 81040;
update npc set name = 'Arch Ranger', nameid = 'Arch Ranger' where npcid = 81041;
update npc set name = 'Acaleph' where npcid = 81042;
update npc set name = 'Varlok\'s Servant' where npcid = 81044;
update npc set name = 'Unknown 81046' where npcid = 81046;
update npc set name = 'Grim Reaper' where npcid = 81047;
update npc set name = 'Unknown 81048' where npcid = 81048;
update npc set name = 'Unknown 81049' where npcid = 81049;
update npc set name = 'Orc' where npcid = 81054;
update npc set name = 'Goblin' where npcid = 81055;
update npc set name = 'Goblin' where npcid = 81056;
update npc set name = 'Kobold' where npcid = 81057;
update npc set name = 'Orc Archer' where npcid = 81058;
update npc set name = 'Eidlon' where npcid = 81059;
update npc set name = 'Dwarf' where npcid = 81060;
update npc set name = 'Orc Fighter' where npcid = 81061;
update npc set name = 'Orc Fighter' where npcid = 81062;
update npc set name = 'Gnoll' where npcid = 81063;
update npc set name = 'Steleton Soldier' where npcid = 81064;
update npc set name = 'Stone Golem' where npcid = 81065;
update npc set name = 'Black Knight' where npcid = 81067;
update npc set name = 'Lycanthrope' where npcid = 81068;
update npc set name = 'Unknown 81078' where npcid = 81078;
update npc set name = 'Unknown 81079' where npcid = 81079;
update npc set name = 'Crown' where npcid = 81125;
update npc set name = 'Message Board' where npcid = 81127;
update npc set name = 'Message Board' where npcid = 81128;
update npc set name = 'Message Board' where npcid = 81129;
update npc set name = 'Unknown 81131', nameid = '' where npcid = 81131;
update npc set name = 'Unknown 81132', nameid = '' where npcid = 81132;
update npc set name = 'Unknown 81133', nameid = 'Unknown $1430' where npcid = 81133;
update npc set name = 'Unknown 81134', nameid = 'Unknown $1497' where npcid = 81134;
update npc set name = 'Unknown 81135', nameid = 'Unknown $1429' where npcid = 81135;
update npc set name = 'Unknown 81136' where npcid = 81136;
update npc set name = 'Unknown 81137', nameid = 'Unknown $1429' where npcid = 81137;
update npc set name = 'Unknown 81138', nameid = '' where npcid = 81138;
update npc set name = 'Unknown 81139', nameid = '' where npcid = 81139;
update npc set name = 'Unknown 81140', nameid = 'Unknown $57' where npcid = 81140;
update npc set name = 'Unknown 81141', nameid = 'Unknown $7' where npcid = 81141;
update npc set name = 'Unknown 81142', nameid = 'Unknown $986' where npcid = 81142;
update npc set name = 'Unknown 81143', nameid = 'Unknown $318' where npcid = 81143;
update npc set name = 'Unknown 81144', nameid = 'Unknown $1563' where npcid = 81144;
update npc set name = 'Unknown 81145', nameid = 'Unknown $1563' where npcid = 81145;
update npc set name = 'Unknown 81146', nameid = 'Unknown $1562' where npcid = 81146;
update npc set name = 'Unknown 81147', nameid = '' where npcid = 81147;
update npc set name = 'Unknown 81148', nameid = '' where npcid = 81148;
update npc set name = 'Unknown 81149', nameid = '' where npcid = 81149;
update npc set name = 'Unknown 81150', nameid = 'Unknown $1016' where npcid = 81150;
update npc set name = 'Unknown 81151', nameid = 'Unknown $1018' where npcid = 81151;
update npc set name = 'Unknown 81152', nameid = 'Unknown $1017' where npcid = 81152;
update npc set name = 'Unknown 81153', nameid = '' where npcid = 81153;
update npc set name = 'Unknown 81154', nameid = '' where npcid = 81154;
update npc set name = 'Olle' where npcid = 81155;
update npc set name = 'Aden Reconnaissance Soldier' where npcid = 81156;
update npc set name = 'Unknown 81158' where npcid = 81158;
update npc set name = 'Unknown 81162' where npcid = 81162;
update npc set name = 'Girtas' where npcid = 81163;
update npc set name = 'Fire' where npcid = 81164;
update npc set name = 'Fire' where npcid = 81165;
update npc set name = 'Light Rays' where npcid = 81166;
update npc set name = 'Light Rays' where npcid = 81167;
update npc set name = 'Freeze Effect' where npcid = 81168;
update npc set name = 'Life Stream Effect' where npcid = 81169;