-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 66

-- merge the differences between us and jp on these mobs
-- this may give us a slightly more sane starting point for further adjusting
-- some of our values were obviously wrong just by glancing at them

-- reverse the id's on solidcarriage and counterbarrier
-- this should fix issue #25, and also matches l1j-jp

-- Skill:SolidCarriage-90 id changed from 4 
UPDATE skills SET id = 2 WHERE skill_id = 90;

-- Skill:CounterBarrier-91 probability_value changed from 50 
UPDATE skills SET probability_value = 25 WHERE skill_id = 91;

-- Skill:CounterBarrier-91 id changed from 2 
UPDATE skills SET id = 4 WHERE skill_id = 91;

-- Unchosen One 46069
-- atk_magic_speed changed from 880
UPDATE npc SET atk_magic_speed = 840 WHERE npcid = 46069;
--
-- Unchosen One 46073
-- atk_magic_speed changed from 1120
UPDATE npc SET atk_magic_speed = 1000 WHERE npcid = 46073;
--
-- Unchosen One 46080
-- atkspeed changed from 1120
UPDATE npc SET atkspeed = 1040 WHERE npcid = 46080;
--
-- Unchosen One 46081
-- atkspeed changed from 1120
UPDATE npc SET atkspeed = 1040 WHERE npcid = 46081;
--
-- Patrol 1 46082
-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46082;
-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46082;
--
-- Patrol 2 46083
-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46083;
-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46083;
--
-- Patrol 3 46084
-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46084;
-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46084;
--
-- Patrol 4 46085
-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46085;
-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46085;
--
-- Patrol 5 46086
-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46086;
-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46086;
--
-- Patrol 6 46087
-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46087;
-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46087;
--
-- Patrol 7 46088
-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46088;
-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46088;
--
-- Patrol 8 46089
-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46089;
-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46089;
--
-- Patrol 9 46090
-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46090;
-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46090;
--
-- Guard 46091
-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46091;
-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46091;
--
-- Unchosen One 46092
-- atk_magic_speed changed from 1172
UPDATE npc SET atk_magic_speed = 1160 WHERE npcid = 46092;
-- passispeed changed from 1500
UPDATE npc SET passispeed = 1440 WHERE npcid = 46092;
-- atkspeed changed from 1172
UPDATE npc SET atkspeed = 1120 WHERE npcid = 46092;
--
-- Unchosen One 46093
-- atk_magic_speed changed from 1000
UPDATE npc SET atk_magic_speed = 1360 WHERE npcid = 46093;
-- passispeed changed from 1336
UPDATE npc SET passispeed = 1280 WHERE npcid = 46093;
-- atkspeed changed from 1000
UPDATE npc SET atkspeed = 960 WHERE npcid = 46093;
-- sub_magic_speed changed from 1000
UPDATE npc SET sub_magic_speed = 1760 WHERE npcid = 46093;
--
-- Unchosen One 46094
-- atk_magic_speed changed from 1344
UPDATE npc SET atk_magic_speed = 1680 WHERE npcid = 46094;
-- passispeed changed from 1500
UPDATE npc SET passispeed = 1440 WHERE npcid = 46094;
-- atkspeed changed from 1344
UPDATE npc SET atkspeed = 1280 WHERE npcid = 46094;
--
-- Unchosen One 46095
-- atk_magic_speed changed from 1125
UPDATE npc SET atk_magic_speed = 1880 WHERE npcid = 46095;
-- passispeed changed from 1500
UPDATE npc SET passispeed = 1440 WHERE npcid = 46095;
-- atkspeed changed from 1125
UPDATE npc SET atkspeed = 1080 WHERE npcid = 46095;
--
-- Unchosen One 46096
-- atk_magic_speed changed from 1172
UPDATE npc SET atk_magic_speed = 1200 WHERE npcid = 46096;
-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46096;
-- atkspeed changed from 1172
UPDATE npc SET atkspeed = 1120 WHERE npcid = 46096;
-- Skill: TriRnd changed from 10 
UPDATE mobskill SET TriRnd = 20 WHERE mobid = 46096 and actNo = 0;
-- Skill: TriRnd changed from 10 
UPDATE mobskill SET TriRnd = 100 WHERE mobid = 46096 and actNo = 1;
--
-- Patrol 1 46097
-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46097;
-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46097;
--
-- Patrol 2 46098
-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46098;
-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46098;
--
-- Patrol 3 46099
-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46099;
-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46099;
--
-- Patrol 4 46100
-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46100;
-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46100;
--
-- Patrol 5 46101
-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46101;
-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46101;
--
-- Patrol 6 46102
-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46102;
-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46102;
--
-- Patrol 7 46103
-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46103;
-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46103;
--
-- Patrol 8 46104
-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46104;
-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46104;
--
-- Patrol 9 46105
-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46105;
-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46105;
--
-- Guard 46106
-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46106;
-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46106;

# Update names for Unchosen One
update mapids set locationname = 'Land of the Abandoned' where mapid = 777;
update npc set name = 'Unchosen One (Lesser Demon)' where npcid = 46092;
update npc set mr = 100 where npcid = 46092;
update npc set name = 'Unchosen One (Demon)' where npcid = 46093;
update npc set name = 'Unchosen One (Baphomet)' where npcid = 46094;
update npc set name = 'Unchosen One (Beleth)' where npcid = 46095;
update npc set name = 'Unchosen One (Succubus)' where npcid = 46096;

# Update Polymorph Table with corrections to armor/weapon equip and name cleanup
DROP TABLE IF EXISTS `polymorphs`;
CREATE TABLE `polymorphs` (
`id` int(11) NOT NULL auto_increment,
`name` varchar(255) default NULL,`polyid` int(11) default NULL,`minlevel` int(11) default NULL,`weaponequip` int(11) default NULL,`armorequip` int(11) default NULL,`isSkillUse` int(11) default NULL,
`cause` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7342 DEFAULT CHARSET=utf8 COMMENT='MyISAM free: 10240 kB';
INSERT INTO polymorphs VALUES
(29,'Floating Eye',29,1,0,0,1,7),
(95,'Arachnevil',95,10,0,0,0,7),
(146,'Arachnevil Elder',146,10,0,0,0,7),
(938,'Beagle',938,100,0,2,1,7),
(945,'Cow',945,1,0,0,0,7),
(947,'Deer',947,1,0,0,0,7),
(951,'Cerberus',951,15,0,0,0,7),
(979,'Wild Boar',979,1,0,0,1,7),
(1037,'Giant Ant',1037,1,0,136,0,7),
(1039,'Giant Ant Soldier',1039,1,0,136,0,7),
(1047,'Scorpion',1047,15,0,0,0,7),
(2064,'Snowman',2064,100,0,1027,1,7),
(2284,'Dark Elf',2284,52,256,4095,1,7),
(2323,'Orc Scout',2323,15,256,4095,1,7),
(2374,'Skeleton',2374,10,751,4095,1,7),
(2376,'Skeleton Axeman',2376,10,751,4095,1,7),
(2377,'Skeleton Pike',2377,10,1791,4095,1,7),
(2378,'Spartoi',2378,10,751,4095,1,7),
(2382,'Aden Archer Guard',6406,100,256,4095,1,7),
(2384,'Succubus',2384,40,751,4095,1,7),
(2385,'Yeti',2385,15,751,4095,1,7),
(2386,'Minotaur - Axe',2386,15,751,4095,1,7),
(2387,'Giant - Tan',2387,15,1791,4095,1,7),
(2388,'Death',2388,100,0,32,0,7),
(2501,'Jack o Lantern',2501,100,751,417,0,7),
(3101,'Black Knight Chief',3101,51,751,4095,1,7),
(3102,'Greater Minotaur',3102,50,1791,4095,1,7),
(3103,'Varlok',3103,52,1791,4095,1,7),
(3126,'Fire Archer',3126,51,256,4095,1,7),
(3630,'Cyclops',3630,40,751,4095,1,7),
(3631,'Griffon',3631,40,0,32,1,7),
(3632,'Cockatrice',3632,40,0,4095,1,7),
(3633,'Ettin',3633,40,751,4095,1,7),
(3634,'Assassin',3634,45,751,4095,1,7),
(3664,'Baranka',3664,100,704,4095,1,7),
(3750,'Haregi',3750,100,0,4095,1,7),
(3784,'Death Knight',6137,52,751,4095,1,7),
(3860,'Orc Archer',3860,1,256,4095,1,7),
(3861,'Goblin',3861,1,751,913,0,7),
(3862,'Kobold',3862,1,751,913,1,7),
(3863,'Dwarf',3863,1,751,4095,1,7),
(3864,'Orc Fighter',3864,1,751,4095,1,7),
(3865,'Werewolf',3865,1,751,4095,1,7),
(3866,'Gandi Orc',3866,10,751,4095,1,7),
(3867,'Rova Orc',3867,10,751,4095,1,7),
(3868,'Atuba Orc',3868,10,751,4095,1,7),
(3869,'DudaMara Orc',3869,10,1791,4095,1,7),
(3870,'Neruga Orc',3870,10,1791,4095,1,7),
(3871,'Skeleton Archer',3871,10,256,4095,1,7),
(3872,'Zombie',3872,10,751,4095,1,7),
(3873,'Ghoul',3873,10,751,4095,1,7),
(3874,'Lycanthrope',3874,10,751,4095,1,7),
(3875,'Ghast',3875,10,751,945,1,7),
(3876,'Bugbear',3876,10,751,945,1,7),
(3877,'Ogre',3877,15,1791,913,1,7),
(3878,'Troll',3878,15,751,545,1,7),
(3879,'Elder',3879,15,751,0,1,7),
(3880,'King Bugbear',3880,15,751,2047,1,7),
(3881,'Dark Elder',3881,45,751,4095,1,7),
(3882,'Baltazar',3882,45,751,4095,1,7),
(3883,'Caspa',3883,45,751,4095,1,7),
(3884,'Merkyor',3884,45,751,4095,1,7),
(3885,'Sema',3885,45,751,4095,1,7),
(3886,'Lesser Demon',3886,45,751,4095,0,7),
(3887,'Darkelf Carrier',3887,45,1791,4095,0,7),
(3888,'Baphomet',3888,50,751,954,1,7),
(3889,'Demon',3889,51,751,4095,1,7),
(3890,'Ancient Black Knight',3890,55,751,4095,1,7),
(3891,'Ancient Black Wizard',3891,55,751,4095,1,7),
(3892,'Ancient Black Archer',3892,55,256,2047,1,7),
(3893,'Ancient Silver Knight',3893,60,239,2047,1,7),
(3894,'Ancient Silver Wizard',3894,60,239,2047,1,7),
(3895,'Ancient Silver Archer',3895,60,256,2047,1,7),
(3896,'Ancient Gold Knight',3896,65,239,2047,1,7),
(3897,'Ancient Gold Wizard',3897,65,239,2047,1,7),
(3898,'Ancient Gold Archer',3898,65,256,2047,1,7),
(3899,'Ancient Platinum Knight',3899,70,239,2047,1,7),
(3900,'Ancient Platinum Wizard',3900,70,239,2047,1,7),
(3901,'Ancient Platinum Archer',3901,70,256,2047,1,7),
(3902,'Cerenis',3902,100,43,4095,1,7),
(3903,'Ken Rahuel',3903,100,751,4095,1,7),
(3904,'Stone Golem',3904,1,751,145,1,7),
(3905,'Beleth',3905,50,751,954,1,7),
(3906,'Orc',3906,1,751,4095,1,7),
(3945,'Gelatinous Cube',3945,15,751,0,1,7),
(3950,'Middle Oum',3950,15,751,4095,1,7),
(3952,'Vampire',3952,100,0,32,0,7),
(4000,'Knight Vald',4000,100,1791,4095,1,7),
(4001,'Iris',4001,100,1791,4095,1,7),
(4002,'Paperman',4002,100,1791,4095,1,7),
(4004,'Succubus Queen',4004,100,1791,4095,1,7),
(4186,'Skeletal Pirate',4186,100,751,4095,0,7),
(4188,'Skeletal Pirate Captain',4188,100,751,4095,0,7),
(4190,'Skeletal Pirate Soldier',4190,100,256,4095,0,7),
(4227,'Hakama',4227,100,0,4095,1,7),
(4767,'Mambo Rabbit - Pink Vest',4767,100,0,4095,0,7),
(4769,'Mambo Rabbit - Orange Vest',4769,100,0,4095,0,7),
(4917,'Darkelf Ranger',4917,45,256,4095,1,7),
(4918,'Bandit Archer',4918,40,256,4095,1,7),
(4919,'Darkelf Guard',4919,50,256,4095,1,7),
(4920,'Elmore General',4920,45,1791,4095,1,7),
(4921,'Darkelf General',4921,52,1791,4095,1,7),
(4922,'Guardian Armor',4922,50,751,4095,1,7),
(4923,'Black Knight',4923,51,1080,4095,1,7),
(4924,'Darkelf Guard',4924,50,1080,4095,1,7),
(4925,'Elmore Soldier',4925,40,1080,4095,1,7),
(4926,'Darkelf Wizard',4926,50,751,4095,1,7),
(4928,'High Collie',4928,100,0,2,1,7),
(4929,'High Raccoon',4929,100,0,2,1,7),
(4932,'Assassin Master',4932,52,751,4095,1,7),
(5184,'Red Soccer Uniform',5184,100,0,8,1,7),
(5186,'Blue Soccer Uniform',5186,100,0,8,1,7),
(5645,'Halloween Pumpkin',5645,100,2047,4095,1,7),
(5719,'Manekineko Cat',5719,100,2047,4095,1,7),
(5727,'Ancient Black Assassin',5727,55,239,2047,1,7),
(5730,'Ancient Silver Assassin',5730,60,239,2047,1,7),
(5733,'Ancient Gold Assassin',5733,65,239,2047,1,7),
(5736,'Ancient Platinum Assassin',5736,70,239,2047,1,7),
(5976,'High Bear',5976,100,751,2,0,7),
(6002,'Spirit of Earth',6002,100,8,0,1,7),
(6010,'Red Orc',6010,100,0,1,0,7),
(6034,'Priest of Corruption - Imp',6034,45,239,2047,1,7),
(6080,'Princess on Horse',6080,100,16,4095,1,7),
(6086,'Skeletal Pirate Captain',6086,100,751,4095,1,7),
(6087,'Skeletal Pirate Archer',6087,100,256,4095,1,7),
(6088,'Skeletal Pirate Rogue',6088,100,751,4095,1,7),
(6089,'Captain Drake',6089,100,1791,4095,1,7),
(6094,'Prince on a Horse',6094,100,16,4095,1,7),
(6136,'Varlok 52',6136,52,1791,4095,1,7),
(6137,'Death 52',6137,52,751,4095,1,7),
(6138,'Assassin 52',6138,52,751,4095,1,7),
(6139,'Darkelf General 52',6141,52,751,4095,1,7),
(6140,'Darkelf 52',6140,52,256,4095,1,7),
(6141,'Varlok 55',6141,55,1791,4095,1,7),
(6142,'Death 55',6142,55,751,4095,1,7),
(6143,'Assassin 55',6143,55,751,4095,1,7),
(6144,'Darkelf General 55',6144,55,751,4095,1,7),
(6145,'Darkelf 55',6145,55,256,4095,1,7),
(6146,'Varlok 60',6146,60,1791,4095,1,7),
(6147,'Death 60',6147,60,751,4095,1,7),
(6148,'Assassin 60',6148,60,751,4095,1,7),
(6149,'Darkelf General 60',6149,60,751,4095,1,7),
(6150,'Darkelf 60',6150,60,256,4095,1,7),
(6151,'Varlok 65',6151,65,1791,4095,1,7),
(6152,'Death 65',6152,65,751,4095,1,7),
(6153,'Assassin 65',6153,65,751,4095,1,7),
(6154,'Darkelf General 65',6154,65,751,4095,1,7),
(6155,'Darkelf 65',6155,65,256,4095,1,7),
(6156,'Varlok 70',6156,70,1791,4095,1,7),
(6157,'Death 70',6157,70,751,4095,1,7),
(6158,'Assassin 70',6158,70,751,4095,1,7),
(6159,'Darkelf General 70',6159,70,751,4095,1,7),
(6160,'Darkelf 70',6160,70,256,4095,1,7),
(6180,'Unicorn A',6180,100,751,4095,1,10),
(6181,'Unicorn B',6181,100,751,4095,1,10),
(6182,'Unicorn C',6182,100,751,4095,1,10),
(6183,'Unicorn D',6183,100,0,0,0,10),
(6184,'Bear A',6184,100,749,4095,1,10),
(6185,'Bear B',6185,100,749,4095,1,10),
(6186,'Bear C',6186,100,749,4095,1,10),
(6187,'Bear D',6187,100,0,0,0,10),
(6188,'Jindo Puppy A',6188,100,751,4095,1,10),
(6189,'Jindo Puppy B',6189,100,751,4095,1,10),
(6190,'Jindo Puppy C',6190,100,751,4095,1,10),
(6191,'Jindo Puppy D',6191,100,0,0,0,10),
(6192,'Ratman A',6192,100,751,4095,1,10),
(6193,'Ratman B',6193,100,751,4095,1,10),
(6194,'Ratman C',6194,100,751,4095,1,10),
(6195,'Ratman D',6195,100,0,0,0,10),
(6196,'Tiger A',6196,100,751,4095,1,10),
(6197,'Tiger B',6197,100,751,4095,1,10),
(6198,'Tiger C',6198,100,751,4095,1,10),
(6199,'Tiger D',6199,100,0,0,0,10),
(6200,'Dillo A',6200,100,751,4095,1,10),
(6201,'Dillo B',6201,100,751,4095,1,10),
(6202,'Dillo C',6202,100,751,4095,1,10),
(6203,'Dillo D',6203,100,0,0,0,10),
(6204,'Mole A',6204,100,256,4095,1,10),
(6205,'Mole B',6205,100,256,4095,1,10),
(6206,'Mole C',6206,100,256,4095,1,10),
(6207,'Mole D',6207,100,0,0,0,10),
(6208,'Darkelf Thief A',6208,100,1007,4095,1,10),
(6209,'Darkelf Thief B',6209,100,1007,4095,1,10),
(6210,'Darkelf Thief C',6210,100,1007,4095,1,10),
(6211,'Darkelf Thief D',6211,100,0,0,0,10),
(6212,'Ken Rahuel A',6212,100,751,4095,1,10),
(6213,'Ken Rahuel B',6213,100,751,4095,1,10),
(6214,'Ken Rahuel C',6214,100,751,4095,1,10),
(6215,'Ken Rahuel D',6215,100,0,0,0,10),
(6216,'Cerenis A',6216,100,751,4095,1,10),
(6217,'Cerenis B',6217,100,751,4095,1,10),
(6218,'Cerenis C',6218,100,751,4095,1,10),
(6219,'Cerenis D',6219,100,0,0,0,10),
(6220,'Slave A',6220,100,751,4095,1,10),
(6221,'Slave B',6221,100,751,4095,1,10),
(6222,'Slave C',6222,100,751,4095,1,10),
(6223,'Slave D',6223,100,0,0,0,10),
(6224,'Doppelganger Boss A',6224,100,751,4095,1,10),
(6225,'Doppelganger Boss B',6225,100,751,4095,1,10),
(6226,'Doppelganger Boss C',6226,100,751,4095,1,10),
(6227,'Doppelganger Boss D',6227,100,0,0,0,10),
(6228,'Lich A',6228,100,751,4095,1,10),
(6229,'Lich B',6229,100,751,4095,1,10),
(6230,'Lich C',6230,100,751,4095,1,10),
(6231,'Lich D',6231,100,0,0,0,10),
(6232,'Woman in White A',6232,100,0,4095,0,10),
(6233,'Woman in White B',6233,100,0,0,0,10),
(6234,'Woman in Blue Shirt A',6234,100,0,4095,0,10),
(6235,'Woman in Blue Shirt B',6235,100,0,0,0,10),
(6236,'Woman in Green A',6236,100,0,4095,0,10),
(6237,'Woman in Green B',6237,100,0,0,0,10),
(6238,'Druid Woman A',6238,100,0,4095,0,10),
(6239,'Druid Woman B',6239,100,0,0,0,10),
(6240,'Simizz A',6240,100,0,4095,0,10),
(6241,'Simizz B',6241,100,0,0,0,10),
(6242,'Noble Woman A',6242,100,0,4095,0,10),
(6243,'Noble Woman B',6243,100,0,0,0,10),
(6267,'Neo Black Knight',6267,55,751,4095,1,7),
(6268,'Neo Black Wizard',6268,55,751,4095,1,7),
(6269,'Neo Black Archer',6269,55,256,4095,1,7),
(6270,'Neo Silver Knight',6270,60,751,4095,1,7),
(6271,'Neo Silver Wizard',6271,60,751,4095,1,7),
(6272,'Neo Silver Archer',6272,60,256,4095,1,7),
(6273,'Neo Gold Knight',6273,65,751,4095,1,7),
(6274,'Neo Gold Wizard',6274,65,751,4095,1,7),
(6275,'Neo Gold Archer',6275,65,256,4095,1,7),
(6276,'Neo Platinum Knight',6276,70,751,4095,1,7),
(6277,'Neo Platinum Wizard',6277,70,751,4095,1,7),
(6278,'Neo Platinum Archer',6278,70,256,4095,1,7),
(6279,'Neo Black Assassin',6279,55,751,4095,1,7),
(6280,'Neo Silver Assassin',6280,60,751,4095,1,7),
(6281,'Neo Gold Assassin',6281,65,751,4095,1,7),
(6282,'Neo Platinum Assassin',6282,70,751,4095,1,7),
(6284,'Haunted House Jack o Lantern',6284,100,0,0,0,7),
(6400,'Halloween Jack o Lantern',6400,100,2047,4095,1,7),
(6406,'Aden Archer Guard',6406,100,256,4095,1,7),
(6697,'Harpy',6697,100,751,4095,0,7),
(6698,'Black Wizard',6698,100,751,4095,1,7),
(6894,'Awakened DragonKnight',6894,1,751,4095,1,7),
(7126,'Behimous Male',7126,100,751,4095,1,7),
(7127,'Behimous Female',7127,100,751,4095,1,7),
(7128,'Silveria Male',7128,100,751,4095,1,7),
(7129,'Silveria Female',7129,100,751,4095,1,7),
(7332,'Spear Master 50',7332,52,1080,4095,1,7),
(7338,'Spear Master 55',7338,55,1080,4095,1,7),
(7339,'Spear Master 60',7339,60,1080,4095,1,7),
(7340,'Spear Master 65',7340,65,1080,4095,1,7),
(7341,'Spear Master 70',7341,70,1080,4095,1,7);

# Update npc names
UPDATE npc SET name = 'Patrol 1 - Demon' WHERE npcid = 46082;
UPDATE npc SET name = 'Patrol 2 - Demon' WHERE npcid = 46083;
UPDATE npc SET name = 'Patrol 3 - Demon' WHERE npcid = 46084;
UPDATE npc SET name = 'Patrol 4 - Demon' WHERE npcid = 46085;
UPDATE npc SET name = 'Patrol 5 - Demon' WHERE npcid = 46086;
UPDATE npc SET name = 'Patrol 6 - Demon' WHERE npcid = 46087;
UPDATE npc SET name = 'Patrol 7 - Demon' WHERE npcid = 46088;
UPDATE npc SET name = 'Patrol 8 - Demon' WHERE npcid = 46089;
UPDATE npc SET name = 'Patrol 9 - Demon' WHERE npcid = 46090;

-- pet food collum added + equipe
ALTER TABLE pets ADD food int(2) NOT NULL DEFAULT 0 after lawful;
ALTER TABLE pettypes ADD canUseEquipment tinyint(1) NOT NULL DEFAULT 0 after DefyMessageId;
ALTER TABLE pettypes ADD EvolvItemId int(10) NOT NULL DEFAULT 40070 after MpUpMax;

UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45686;
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45687; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45688; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45689; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45690; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45691; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45692; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45693; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45694; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45695; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45696; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45697; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45710; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 45712; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 46043; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 46045; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 46046; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 91177; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 91176; 
UPDATE pettypes SET canUseEquipment = 1 WHERE BaseNpcId = 91174;

DELETE FROM npcaction WHERE npcid = 81200;
INSERT INTO npcaction VALUES ('81200', 'bankoo1', 'bankoo1', '', '');

update npc set nameid = 'Bankoo' where npcid = 81200;
update npc set name = 'Bankoo' where npcid = 81200;
update npc set name = 'Sveil' where npcid = 80141;
update npc set name = 'Blacksmith Bahturu' where npcid = 80142;
update npc set name = 'Azael' where npcid = 80143;
update npc set name = 'Lark' where npcid = 80144;
update npc set name = 'Charriere' where npcid = 80146;
update npc set name = 'UnknownNpc' where npcid = 81243;
update npc set name = 'UnknownNpc' where npcid = 81244;

-- forgot to commit the race and deathmatch doors and some missing doors.
INSERT INTO `door_gfxs` VALUES ('88', 'Talking Island Caves 2F', '0', '0', '0');
INSERT INTO `door_gfxs` VALUES ('89', 'Talking Island Caves 2F', '1', '0', '0');
INSERT INTO `door_gfxs` VALUES ('6640', 'Crystal Caves 1F', '1', '-1', '3');
INSERT INTO `door_gfxs` VALUES ('6642', 'Crystal Caves 2F', '0', '-2', '2');
INSERT INTO `spawnlist_door` VALUES ('5001', 'Crystal Caves 1F', '6640', '32859', '32835', '72', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('5002', 'Crystal Caves 2F', '6640', '32862', '32764', '73', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('5003', 'Crystal Caves 2F', '6640', '32845', '32809', '73', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('5004', 'Crystal Caves 2F', '6642', '32825', '32862', '73', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('5005', 'Crystal Caves 2F', '6642', '32767', '32837', '73', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('5006', 'Crystal Caves 2F', '6642', '32752', '32753', '73', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('5007', 'Crystal Caves 3F', '6640', '32784', '32818', '74', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('5008', 'Crystal Caves 3F', '6640', '32852', '32806', '74', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('5009', 'Crystal Caves 3F', '6640', '32822', '32855', '74', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('5010', 'Crystal Caves 3F', '6642', '32762', '32916', '74', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6001', 'Talking Island Caves 2F', '92', '32664', '32807', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6002', 'Talking Island Caves 2F', '93', '32673', '32820', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6003', 'Talking Island Caves 2F', '92', '32668', '32833', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6004', 'Talking Island Caves 2F', '88', '32661', '32823', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6005', 'Talking Island Caves 2F', '89', '32672', '32858', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6006', 'Talking Island Caves 2F', '93', '32684', '32850', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6007', 'Talking Island Caves 2F', '93', '32723', '32848', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6008', 'Talking Island Caves 2F', '89', '32678', '32877', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6009', 'Talking Island Caves 2F', '89', '32732', '32872', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6010', 'Talking Island Caves 2F', '89', '32736', '32872', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6011', 'Talking Island Caves 2F', '89', '32740', '32872', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6012', 'Talking Island Caves 2F', '89', '32795', '32870', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6013', 'Talking Island Caves 2F', '88', '32803', '32862', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6014', 'Talking Island Caves 2F', '89', '32806', '32824', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6015', 'Talking Island Caves 2F', '88', '32803', '32832', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6016', 'Talking Island Caves 2F', '92', '32798', '32844', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6017', 'Talking Island Caves 2F', '93', '32759', '32847', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6018', 'Talking Island Caves 2F', '88', '32808', '32792', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6019', 'Talking Island Caves 2F', '93', '32776', '32806', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6020', 'Talking Island Caves 2F', '93', '32775', '32818', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6021', 'Talking Island Caves 2F', '88', '32741', '32804', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6022', 'Talking Island Caves 2F', '89', '32740', '32788', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6023', 'Talking Island Caves 2F', '89', '32750', '32793', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6024', 'Talking Island Caves 2F', '89', '32766', '32791', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6025', 'Talking Island Caves 2F', '93', '32755', '32818', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6026', 'Talking Island Caves 2F', '93', '32726', '32812', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6027', 'Talking Island Caves 2F', '93', '32705', '32816', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6028', 'Talking Island Caves 2F', '92', '32698', '32803', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6029', 'Talking Island Caves 2F', '92', '32680', '32797', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6030', 'Talking Island Caves 2F', '93', '32707', '32789', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6031', 'Talking Island Caves 2F', '92', '32725', '32795', '2', '0', '0');
INSERT INTO `spawnlist_door` VALUES ('6032', 'Talking Island Caves 2F', '92', '32667', '32871', '2', '0', '0');

-- Antharas Instance Dungeon
INSERT INTO `npcaction` VALUES ('81277', 'dsecret3', 'dsecret3', '', '');
INSERT INTO `getback_restart` VALUES ('1005', 'Antharas Lair', '33710', '32521', '4'); 
INSERT INTO `getback_restart` VALUES ('1006', 'Antharas Lair', '33710', '32521', '4');
INSERT INTO `getback_restart` VALUES ('1007', 'Antharas Lair', '33710', '32521', '4');
INSERT INTO `getback_restart` VALUES ('1008', 'Antharas Lair', '33710', '32521', '4');
INSERT INTO `getback_restart` VALUES ('1009', 'Antharas Lair', '33710', '32521', '4');
INSERT INTO `getback_restart` VALUES ('1010', 'Antharas Lair', '33710', '32521', '4');

INSERT INTO `mapids` VALUES ('1005', 'Antharas Lair', '32576', '32959', '32576', '32959', '1', '1', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `mapids` VALUES ('1006', 'Antharas Lair', '32576', '32959', '32576', '32959', '1', '1', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `mapids` VALUES ('1007', 'Antharas Lair', '32576', '32959', '32576', '32959', '1', '1', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `mapids` VALUES ('1008', 'Antharas Lair', '32576', '32959', '32576', '32959', '1', '1', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `mapids` VALUES ('1009', 'Antharas Lair', '32576', '32959', '32576', '32959', '1', '1', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `mapids` VALUES ('1010', 'Antharas Lair', '32576', '32959', '32576', '32959', '1', '1', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1');

INSERT INTO `spawnlist_npc` VALUES ('89820', '', '1', '81279', '32935', '32732', '0', '0', '6', '0', '1006', '0');
INSERT INTO `spawnlist_npc` VALUES ('89821', '', '1', '81280', '32681', '32680', '0', '0', '5', '0', '1006', '0');
INSERT INTO `spawnlist_npc` VALUES ('89822', '', '1', '81281', '32684', '32663', '0', '0', '5', '0', '1006', '0');
INSERT INTO `spawnlist_npc` VALUES ('89823', '', '1', '81279', '32935', '32732', '0', '0', '6', '0', '1007', '0');
INSERT INTO `spawnlist_npc` VALUES ('89824', '', '1', '81280', '32681', '32680', '0', '0', '5', '0', '1007', '0');
INSERT INTO `spawnlist_npc` VALUES ('89825', '', '1', '81281', '32684', '32663', '0', '0', '5', '0', '1007', '0');
INSERT INTO `spawnlist_npc` VALUES ('89826', '', '1', '81279', '32935', '32732', '0', '0', '6', '0', '1008', '0');
INSERT INTO `spawnlist_npc` VALUES ('89827', '', '1', '81280', '32681', '32680', '0', '0', '5', '0', '1008', '0');
INSERT INTO `spawnlist_npc` VALUES ('89828', '', '1', '81281', '32684', '32663', '0', '0', '5', '0', '1008', '0');
INSERT INTO `spawnlist_npc` VALUES ('89829', '', '1', '81279', '32935', '32732', '0', '0', '6', '0', '1009', '0');
INSERT INTO `spawnlist_npc` VALUES ('89830', '', '1', '81280', '32681', '32680', '0', '0', '5', '0', '1009', '0');
INSERT INTO `spawnlist_npc` VALUES ('89831', '', '1', '81281', '32684', '32663', '0', '0', '5', '0', '1009', '0');
INSERT INTO `spawnlist_npc` VALUES ('89832', '', '1', '81279', '32935', '32732', '0', '0', '6', '0', '1010', '0');
INSERT INTO `spawnlist_npc` VALUES ('89833', '', '1', '81280', '32681', '32680', '0', '0', '5', '0', '1010', '0');
INSERT INTO `spawnlist_npc` VALUES ('89834', '', '1', '81281', '32684', '32663', '0', '0', '5', '0', '1010', '0');
INSERT INTO `spawnlist_npc` VALUES ('89835', '', '1', '81292', '33051', '32536', '0', '0', '4', '0', '1012', '0');
INSERT INTO `spawnlist_npc` VALUES ('89836', '', '1', '81293', '32935', '32680', '0', '0', '5', '0', '1012', '0');
INSERT INTO `spawnlist_npc` VALUES ('89837', '', '1', '81294', '32920', '32664', '0', '0', '4', '0', '1012', '0');
INSERT INTO `spawnlist_npc` VALUES ('89838', '', '1', '81292', '33051', '32536', '0', '0', '4', '0', '1013', '0');
INSERT INTO `spawnlist_npc` VALUES ('89839', '', '1', '81293', '32935', '32680', '0', '0', '5', '0', '1013', '0');
INSERT INTO `spawnlist_npc` VALUES ('89840', '', '1', '81294', '32920', '32664', '0', '0', '4', '0', '1013', '0');
INSERT INTO `spawnlist_npc` VALUES ('89841', '', '1', '81292', '33051', '32536', '0', '0', '4', '0', '1014', '0');
INSERT INTO `spawnlist_npc` VALUES ('89842', '', '1', '81293', '32935', '32680', '0', '0', '5', '0', '1014', '0');
INSERT INTO `spawnlist_npc` VALUES ('89843', '', '1', '81294', '32920', '32664', '0', '0', '4', '0', '1014', '0');
INSERT INTO `spawnlist_npc` VALUES ('89844', '', '1', '81292', '33051', '32536', '0', '0', '4', '0', '1015', '0');
INSERT INTO `spawnlist_npc` VALUES ('89845', '', '1', '81293', '32935', '32680', '0', '0', '5', '0', '1015', '0');
INSERT INTO `spawnlist_npc` VALUES ('89846', '', '1', '81294', '32920', '32664', '0', '0', '4', '0', '1015', '0');
INSERT INTO `spawnlist_npc` VALUES ('89847', '', '1', '81292', '33051', '32536', '0', '0', '4', '0', '1016', '0');
INSERT INTO `spawnlist_npc` VALUES ('89848', '', '1', '81293', '32935', '32680', '0', '0', '5', '0', '1016', '0');
INSERT INTO `spawnlist_npc` VALUES ('89849', '', '1', '81294', '32920', '32664', '0', '0', '4', '0', '1016', '0');
INSERT INTO `spawnlist_npc` VALUES ('89850', '', '1', '80001', '32647', '32950', '0', '0', '5', '0', '0', '0');
INSERT INTO `spawnlist_npc` VALUES ('89851', '', '1', '81166', '33054', '32337', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('89852', '', '1', '71097', '33601', '33245', '0', '0', '5', '0', '4', '0');

INSERT INTO `spawnlist_npc` VALUES ('89857', '', '1', '81301', '32703', '32670', '0', '0', '0', '0', '1005', '0');
INSERT INTO `spawnlist_npc` VALUES ('89858', '', '1', '81301', '32703', '32670', '0', '0', '0', '0', '1006', '0');
INSERT INTO `spawnlist_npc` VALUES ('89859', '', '1', '81301', '32703', '32670', '0', '0', '0', '0', '1007', '0');
INSERT INTO `spawnlist_npc` VALUES ('89860', '', '1', '81301', '32703', '32670', '0', '0', '0', '0', '1008', '0');
INSERT INTO `spawnlist_npc` VALUES ('89861', '', '1', '81301', '32703', '32670', '0', '0', '0', '0', '1009', '0');
INSERT INTO `spawnlist_npc` VALUES ('89862', '', '1', '81301', '32703', '32670', '0', '0', '0', '0', '1010', '0');
INSERT INTO `spawnlist_npc` VALUES ('89863', '', '1', '81302', '32796', '32661', '0', '0', '0', '0', '1005', '0');
INSERT INTO `spawnlist_npc` VALUES ('89864', '', '1', '81302', '32796', '32661', '0', '0', '0', '0', '1006', '0');
INSERT INTO `spawnlist_npc` VALUES ('89865', '', '1', '81302', '32796', '32661', '0', '0', '0', '0', '1007', '0');
INSERT INTO `spawnlist_npc` VALUES ('89866', '', '1', '81302', '32796', '32661', '0', '0', '0', '0', '1008', '0');
INSERT INTO `spawnlist_npc` VALUES ('89867', '', '1', '81302', '32796', '32661', '0', '0', '0', '0', '1009', '0');
INSERT INTO `spawnlist_npc` VALUES ('89868', '', '1', '81302', '32796', '32661', '0', '0', '0', '0', '1010', '0');
INSERT INTO `spawnlist_npc` VALUES ('89869', '', '1', '81303', '32941', '32671', '0', '0', '0', '0', '1011', '0');
INSERT INTO `spawnlist_npc` VALUES ('89870', '', '1', '81303', '32941', '32671', '0', '0', '0', '0', '1012', '0');
INSERT INTO `spawnlist_npc` VALUES ('89871', '', '1', '81303', '32941', '32671', '0', '0', '0', '0', '1013', '0');
INSERT INTO `spawnlist_npc` VALUES ('89872', '', '1', '81303', '32941', '32671', '0', '0', '0', '0', '1014', '0');
INSERT INTO `spawnlist_npc` VALUES ('89873', '', '1', '81303', '32941', '32671', '0', '0', '0', '0', '1015', '0');
INSERT INTO `spawnlist_npc` VALUES ('89874', '', '1', '81303', '32941', '32671', '0', '0', '0', '0', '1016', '0');
INSERT INTO `spawnlist_npc` VALUES ('89875', '', '1', '81304', '32993', '32841', '0', '0', '0', '0', '1011', '0');
INSERT INTO `spawnlist_npc` VALUES ('89876', '', '1', '81304', '32993', '32841', '0', '0', '0', '0', '1012', '0');
INSERT INTO `spawnlist_npc` VALUES ('89877', '', '1', '81304', '32993', '32841', '0', '0', '0', '0', '1013', '0');
INSERT INTO `spawnlist_npc` VALUES ('89878', '', '1', '81304', '32993', '32841', '0', '0', '0', '0', '1014', '0');
INSERT INTO `spawnlist_npc` VALUES ('89879', '', '1', '81304', '32993', '32841', '0', '0', '0', '0', '1015', '0');
INSERT INTO `spawnlist_npc` VALUES ('89880', '', '1', '81304', '32993', '32841', '0', '0', '0', '0', '1016', '0');
INSERT INTO `spawnlist_npc` VALUES ('89881', '', '1', '81279', '32935', '32924', '0', '0', '6', '0', '1005', '0');
INSERT INTO `spawnlist_npc` VALUES ('89882', '', '1', '81279', '32807', '32924', '0', '0', '6', '0', '1005', '0');
INSERT INTO `spawnlist_npc` VALUES ('89883', '', '1', '81279', '32679', '32924', '0', '0', '6', '0', '1005', '0');
INSERT INTO `spawnlist_npc` VALUES ('89884', '', '1', '81279', '32935', '32924', '0', '0', '6', '0', '1006', '0');
INSERT INTO `spawnlist_npc` VALUES ('89885', '', '1', '81279', '32807', '32924', '0', '0', '6', '0', '1006', '0');
INSERT INTO `spawnlist_npc` VALUES ('89886', '', '1', '81279', '32679', '32924', '0', '0', '6', '0', '1006', '0');
INSERT INTO `spawnlist_npc` VALUES ('89887', '', '1', '81279', '32935', '32924', '0', '0', '6', '0', '1007', '0');
INSERT INTO `spawnlist_npc` VALUES ('89888', '', '1', '81279', '32807', '32924', '0', '0', '6', '0', '1007', '0');
INSERT INTO `spawnlist_npc` VALUES ('89889', '', '1', '81279', '32679', '32924', '0', '0', '6', '0', '1007', '0');
INSERT INTO `spawnlist_npc` VALUES ('89890', '', '1', '81279', '32935', '32924', '0', '0', '6', '0', '1008', '0');
INSERT INTO `spawnlist_npc` VALUES ('89891', '', '1', '81279', '32807', '32924', '0', '0', '6', '0', '1008', '0');
INSERT INTO `spawnlist_npc` VALUES ('89892', '', '1', '81279', '32679', '32924', '0', '0', '6', '0', '1008', '0');
INSERT INTO `spawnlist_npc` VALUES ('89893', '', '1', '81279', '32935', '32924', '0', '0', '6', '0', '1009', '0');
INSERT INTO `spawnlist_npc` VALUES ('89894', '', '1', '81279', '32807', '32924', '0', '0', '6', '0', '1009', '0');
INSERT INTO `spawnlist_npc` VALUES ('89895', '', '1', '81279', '32679', '32924', '0', '0', '6', '0', '1009', '0');
INSERT INTO `spawnlist_npc` VALUES ('89896', '', '1', '81279', '32935', '32924', '0', '0', '6', '0', '1010', '0');
INSERT INTO `spawnlist_npc` VALUES ('89897', '', '1', '81279', '32807', '32924', '0', '0', '6', '0', '1010', '0');
INSERT INTO `spawnlist_npc` VALUES ('89898', '', '1', '81279', '32679', '32924', '0', '0', '6', '0', '1010', '0');
INSERT INTO `spawnlist_npc` VALUES ('89899', '', '1', '81305', '32680', '32744', '0', '0', '0', '0', '1005', '0');
INSERT INTO `spawnlist_npc` VALUES ('89900', '', '1', '81305', '32680', '32744', '0', '0', '0', '0', '1006', '0');
INSERT INTO `spawnlist_npc` VALUES ('89901', '', '1', '81305', '32680', '32744', '0', '0', '0', '0', '1007', '0');
INSERT INTO `spawnlist_npc` VALUES ('89902', '', '1', '81305', '32680', '32744', '0', '0', '0', '0', '1008', '0');
INSERT INTO `spawnlist_npc` VALUES ('89903', '', '1', '81305', '32680', '32744', '0', '0', '0', '0', '1009', '0');
INSERT INTO `spawnlist_npc` VALUES ('89904', '', '1', '81305', '32680', '32744', '0', '0', '0', '0', '1010', '0');
INSERT INTO `spawnlist_npc` VALUES ('89905', '', '1', '81306', '32938', '32610', '0', '0', '0', '0', '1005', '0');
INSERT INTO `spawnlist_npc` VALUES ('89906', '', '1', '81306', '32682', '32802', '0', '0', '0', '0', '1005', '0');
INSERT INTO `spawnlist_npc` VALUES ('89907', '', '1', '81306', '32810', '32802', '0', '0', '0', '0', '1005', '0');
INSERT INTO `spawnlist_npc` VALUES ('89908', '', '1', '81306', '32938', '32802', '0', '0', '0', '0', '1005', '0');

INSERT INTO `npc` VALUES (81293, '', '$8422', '$8422', 'L1Dwarf', 1619, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81294, '', '$8421', '$8421', 'L1Merchant', 1619, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81292, '', '$4347', '$4347', 'L1Merchant', 7904, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81279, '', '$1015', '$1015', 'L1Merchant', 1049, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81281, '', '$7776', '$7776', 'L1Merchant', 1997, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81280, '', '$7777', '$7777', 'L1Dwarf', 1997, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81273, '', '$7747', '$7747', 'L1DragonPortal', 7554, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81274, '', '$7747', '$7747', 'L1DragonPortal', 7548, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81275, '', '$7747', '$7747', 'L1DragonPortal', 7552, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81276, '', '$7747', '$7747', 'L1DragonPortal', 7550, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81277, '', '$7747', '$7747', 'L1DragonPortal', 7585, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81301, '', '$1116', '$1116', 'L1DragonPortal', 7597, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81302, '', '$1116', '$1116', 'L1DragonPortal', 7597, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81303, '', '$1116', '$1116', 'L1DragonPortal', 7597, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81304, '', '$1116', '$1116', 'L1DragonPortal', 7597, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81305, '', '$1116', '$1116', 'L1DragonPortal', 7597, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81306, '', '$1116', '$1116', 'L1DragonPortal', 7597, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);

-- turtle island spawns + getbackrestart
INSERT INTO `getback_restart` VALUES ('701', 'Turtle Island', '32574', '32941', '0');

INSERT INTO `npc` VALUES ('81315', 'Dread Tom Kidd', 'Dread Tom Kidd', '', 'L1Monster', '2417', '25', '200', '50', '-15', '20', '20', '18', '13', '12', '10', '626', '0', 'small', '1', '0', '0', '320', '880', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'pirate', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0');
INSERT INTO `npc` VALUES ('81316', 'Pirate Club', 'Pirate', '', 'L1Monster', '2443', '21', '150', '20', '-10', '18', '18', '16', '12', '10', '9', '442', '0', 'small', '1', '0', '0', '320', '780', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'pirate', '1', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0');
INSERT INTO `npc` VALUES ('81317', 'Pirate Axe', 'Pirate', '', 'L1Monster', '2516', '22', '120', '22', '-9', '15', '15', '14', '11', '10', '8', '485', '0', 'small', '1', '0', '0', '320', '780', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'pirate', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0');

-- dread tom kidd drops - missing royal nectar and teleport ocean floor scroll they are not on the database.
insert into droplist values (81315,'Dread Tom Kidd',20149,'Bronze Plate Mail',1,1,1000000);
insert into droplist values (81315,'Dread Tom Kidd',120149,'Blessed Bronze Plate Mail',1,1,1100000);
insert into droplist values (81315,'Dread Tom Kidd',20063,'Cloak of Protection',1,1,900000);
insert into droplist values (81315,'Dread Tom Kidd',20229,'Shield of Reflection',1,1,1300000);
insert into droplist values (81315,'Dread Tom Kidd',40013,'Haste Potion',1,1,50000);
insert into droplist values (81315,'Dread Tom Kidd',40016,'Potion of Wisdom',1,1,60000);
insert into droplist values (81315,'Dread Tom Kidd',40051,'High Quality Emerald',1,1,120000);
insert into droplist values (81315,'Dread Tom Kidd',40308,'Adena',85,240,1000000);

-- pirates on turtle island
insert into droplist values (81316,'Pirate',20149,'Bronze Plate Mail',1,1,1300000);
insert into droplist values (81316,'Pirate',20154,'Plate Mail',1,1,1200000);
insert into droplist values (81316,'Pirate',40308,'Adena',55,160,1300000);
insert into droplist values (81316,'Pirate',20063,'Cloak of Protection',1,1,1100000);
insert into droplist values (81316,'Pirate',20162,'Leather Gloves',1,1,800000);
insert into droplist values (81316,'Pirate',20043,'Helmet',1,1,500000);
insert into droplist values (81316,'Pirate',20085,'T-Shirt',1,1,600000);
insert into droplist values (81316,'Pirate',20213,'Low Boots',1,1,400000);
insert into droplist values (81316,'Pirate',20205,'Boots',1,1,500000);
insert into droplist values (81316,'Pirate',40015,'Potion of Mana',1,1,50000);
insert into droplist values (81316,'Pirate',40016,'Potion of Wisdom',1,1,60000);
insert into droplist values (81316,'Pirate',40044,'Diamond',1,1,70000);
insert into droplist values (81316,'Pirate',40045,'Ruby',1,1,60000);
insert into droplist values (81316,'Pirate',40047,'Emerald',1,1,80000);
insert into droplist values (81316,'Pirate',52,'Two Handed Sword',1,1,600000);
insert into droplist values (81316,'Pirate',93,'Trident',1,1,400000);
insert into droplist values (81316,'Pirate',94,'Partisan',1,1,300000);
insert into droplist values (81316,'Pirate',100095,'Lance',1,1,700000);
insert into droplist values (81316,'Pirate',100103,'Halberd',1,1,700000);
insert into droplist values (81317,'Pirate',20149,'Bronze Plate Mail',1,1,1300000);
insert into droplist values (81317,'Pirate',20154,'Plate Mail',1,1,1200000);
insert into droplist values (81317,'Pirate',40308,'Adena',60,170,1300000);
insert into droplist values (81317,'Pirate',20063,'Cloak of Protection',1,1,1100000);
insert into droplist values (81317,'Pirate',20162,'Leather Gloves',1,1,800000);
insert into droplist values (81317,'Pirate',20043,'Helmet',1,1,500000);
insert into droplist values (81317,'Pirate',20085,'T-Shirt',1,1,600000);
insert into droplist values (81317,'Pirate',20213,'Low Boots',1,1,400000);
insert into droplist values (81317,'Pirate',20205,'Boots',1,1,500000);
insert into droplist values (81317,'Pirate',40015,'Potion of Mana',1,1,50000);
insert into droplist values (81317,'Pirate',40016,'Potion of Wisdom',1,1,60000);
insert into droplist values (81317,'Pirate',40044,'Diamond',1,1,70000);
insert into droplist values (81317,'Pirate',40045,'Ruby',1,1,60000);
insert into droplist values (81317,'Pirate',40047,'Emerald',1,1,80000);
insert into droplist values (81317,'Pirate',52,'Two Handed Sword',1,1,600000);
insert into droplist values (81317,'Pirate',93,'Trident',1,1,400000);
insert into droplist values (81317,'Pirate',94,'Partisan',1,1,300000);
insert into droplist values (81317,'Pirate',100095,'Lance',1,1,700000);
insert into droplist values (81317,'Pirate',100103,'Halberd',1,1,700000);

INSERT INTO `spawnlist_boss` VALUES ('212', 'Dread Tom Kidd', 'DreadTomKid', '1', '81315', '0', '32877', '32638', '12', '12', '0', '0', '0', '0', '5', '701', '1', '100', '0', '0', '100');

INSERT INTO `spawnlist` VALUES ('801500710', 'Orc', '1', '45009', '0', '32850', '32794', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500711', 'Orc', '1', '45009', '0', '32846', '32779', '12', '12', '0', '0', '0', '0', '7', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500712', 'Orc Archer', '1', '45019', '0', '32840', '32761', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500713', 'Orc Archer', '1', '45019', '0', '32846', '32780', '12', '12', '0', '0', '0', '0', '5', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500714', 'Rock Golem', '1', '45045', '0', '32848', '32748', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500715', 'Rock Golem', '1', '45045', '0', '32863', '32746', '12', '12', '0', '0', '0', '0', '2', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500716', 'Rock Golem', '1', '45045', '0', '32866', '32722', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500717', 'Rock Golem', '1', '45045', '0', '32854', '32714', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500718', 'Rock Golem', '1', '45045', '0', '32850', '32728', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500719', 'Orc', '1', '45009', '0', '32840', '32720', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500720', 'Orc Fighter', '1', '45082', '0', '32847', '32718', '12', '12', '0', '0', '0', '0', '2', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500721', 'Orc Fighter', '1', '45082', '0', '32842', '32733', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500722', 'Orc Archer', '1', '45019', '0', '32851', '32735', '12', '12', '0', '0', '0', '0', '1', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500723', 'Orc Fighter', '1', '45082', '0', '32845', '32754', '12', '12', '0', '0', '0', '0', '5', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500724', 'Orc Fighter', '1', '45082', '0', '32847', '32771', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500725', 'Orc Archer', '1', '45019', '0', '32841', '32770', '12', '12', '0', '0', '0', '0', '7', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500726', 'Orc Fighter', '1', '45082', '0', '32828', '32762', '12', '12', '0', '0', '0', '0', '7', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500727', 'Crustacean', '1', '45823', '0', '32855', '32758', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500728', 'Crustacean', '1', '45823', '0', '32871', '32738', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500729', 'Crustacean', '1', '45823', '0', '32880', '32704', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500730', 'Turtle Dragon', '1', '45240', '0', '32893', '32685', '12', '12', '0', '0', '0', '0', '1', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500731', 'Turtle Dragon', '1', '45240', '0', '32883', '32681', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500732', 'Turtle Dragon', '1', '45240', '0', '32876', '32713', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500733', 'Turtle Dragon', '1', '45240', '0', '32891', '32723', '12', '12', '0', '0', '0', '0', '2', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500734', 'Crustacean', '1', '45823', '0', '32898', '32726', '12', '12', '0', '0', '0', '0', '2', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500735', 'Turtle Dragon', '1', '45240', '0', '32857', '32766', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500736', 'Bear', '1', '45040', '0', '32856', '32695', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500737', 'Bear', '1', '45040', '0', '32854', '32679', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500738', 'Bear', '1', '45040', '0', '32870', '32668', '12', '12', '0', '0', '0', '0', '2', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500739', 'Bear', '1', '45040', '0', '32861', '32640', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500740', 'Bear', '1', '45040', '0', '32822', '32657', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500741', 'Orc', '1', '45009', '0', '32813', '32659', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500742', 'Orc', '1', '45009', '0', '32807', '32651', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500743', 'Orc Archer', '1', '45019', '0', '32805', '32649', '12', '12', '0', '0', '0', '0', '7', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500744', 'Orc Fighter', '1', '45082', '0', '32802', '32640', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500745', 'Orc Fighter', '1', '45082', '0', '32789', '32642', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500746', 'Bear', '1', '45040', '0', '32789', '32642', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500747', 'Bear', '1', '45040', '0', '32783', '32657', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500748', 'Bear', '1', '45040', '0', '32795', '32671', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500749', 'Orc', '1', '45009', '0', '32794', '32684', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500750', 'Orc', '1', '45009', '0', '32795', '32688', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500751', 'Orc Archer', '1', '45019', '0', '32786', '32684', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500752', 'Orc Archer', '1', '45019', '0', '32786', '32684', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500753', 'Orc Fighter', '1', '45082', '0', '32786', '32684', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500754', 'Bear', '1', '45040', '0', '32778', '32699', '12', '12', '0', '0', '0', '0', '5', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500755', 'Bear', '1', '45040', '0', '32794', '32711', '12', '12', '0', '0', '0', '0', '3', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500756', 'Orc', '1', '45009', '0', '32710', '32716', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500757', 'Orc', '1', '45009', '0', '32710', '32716', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500758', 'Orc Fighter', '1', '45082', '0', '32710', '32716', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500759', 'Orc Fighter', '1', '45082', '0', '32705', '32721', '12', '12', '0', '0', '0', '0', '5', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500760', 'Orc Archer', '1', '45019', '0', '32702', '32716', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500761', 'Orc Archer', '1', '45019', '0', '32702', '32716', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500762', 'Goblin', '1', '45008', '0', '32792', '32718', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500763', 'Goblin', '1', '45008', '0', '32798', '32704', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500764', 'Goblin', '1', '45008', '0', '32785', '32699', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500765', 'Goblin', '1', '45008', '0', '32796', '32675', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500766', 'Goblin', '1', '45008', '0', '32784', '32661', '12', '12', '0', '0', '0', '0', '7', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500767', 'Goblin', '1', '45008', '0', '32790', '32642', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500768', 'Eidlon', '1', '45027', '0', '32790', '32642', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500769', 'Eidlon', '1', '45027', '0', '32800', '32634', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500770', 'Eidlon', '1', '45027', '0', '32817', '32633', '12', '12', '0', '0', '0', '0', '1', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500771', 'Eidlon', '1', '45027', '0', '32828', '32621', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500772', 'Eidlon', '1', '45027', '0', '32830', '32625', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500773', 'Dwarf', '1', '45041', '0', '32836', '32627', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500774', 'Dwarf', '1', '45041', '0', '32825', '32618', '12', '12', '0', '0', '0', '0', '7', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500775', 'Dwarf', '1', '45041', '0', '32806', '32618', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500776', 'Dwarf', '1', '45041', '0', '32829', '32641', '12', '12', '0', '0', '0', '0', '2', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500777', 'Dwarf', '1', '45041', '0', '32851', '32660', '12', '12', '0', '0', '0', '0', '2', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500778', 'Dwarf', '1', '45041', '0', '32862', '32670', '12', '12', '0', '0', '0', '0', '2', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500779', 'Dwarf', '1', '45041', '0', '32874', '32686', '12', '12', '0', '0', '0', '0', '2', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500780', 'Dwarf', '1', '45041', '0', '32860', '32693', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500781', 'Rock Golem', '1', '45045', '0', '32851', '32680', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500782', 'Rock Golem', '1', '45045', '0', '32835', '32671', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500783', 'Ghast', '1', '45213', '0', '32835', '32671', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500784', 'Ghast', '1', '45213', '0', '32842', '32651', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500785', 'Ghast', '1', '45213', '0', '32854', '32629', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500786', 'Ghast', '1', '45213', '0', '32871', '32624', '12', '12', '0', '0', '0', '0', '2', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500787', 'Ghast', '1', '45213', '0', '32882', '32640', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500788', 'Ogre', '1', '45278', '0', '32894', '32624', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500789', 'Ogre', '1', '45278', '0', '32848', '32648', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500790', 'Ogre', '1', '45278', '0', '32823', '32678', '12', '12', '0', '0', '0', '0', '4', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500793', 'Alligator', '1', '45307', '0', '32858', '32737', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500794', 'Alligator', '1', '45307', '0', '32859', '32721', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500795', 'Alligator', '1', '45307', '0', '32853', '32710', '12', '12', '0', '0', '0', '0', '7', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500796', 'Alligator', '1', '45307', '0', '32867', '32700', '12', '12', '0', '0', '0', '0', '2', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500797', 'Alligator', '1', '45307', '0', '32874', '32677', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500798', 'Alligator', '1', '45307', '0', '32877', '32662', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500799', 'Orc Wizard', '1', '45121', '0', '32875', '32655', '12', '12', '0', '0', '0', '0', '0', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500800', 'Orc Wizard', '1', '45121', '0', '32842', '32638', '12', '12', '0', '0', '0', '0', '5', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500801', 'Orc Wizard', '1', '45121', '0', '32803', '32639', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500802', 'Orc Wizard', '1', '45121', '0', '32792', '32634', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);
INSERT INTO `spawnlist` VALUES ('801500803', 'Orc Wizard', '1', '45121', '0', '32777', '32649', '12', '12', '0', '0', '0', '0', '6', '60', '120', '701', '0', '0', '0', '0',1,8,2,100);

-- some missing fieldobjects
INSERT INTO `npc` VALUES (81307, 'FafurionStarGate', '', '', 'L1FieldObject', 1758, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81308, 'SeaHorse', 'SeaHorse', '', 'L1Npc', 1584, 1, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 840, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81310, 'seabra fishgroup', '', '', 'L1Npc', 1634, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 840, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81311, 'yellow fishgroup', '', '', 'L1Npc', 1640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 840, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81312, 'blue fishgroup', '', '', 'L1Npc', 1653, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 840, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81313, 'blueorange fishgroup', '', '', 'L1Npc', 1655, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 840, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
INSERT INTO `npc` VALUES (81314, 'bluered fishgroup', '', '', 'L1Npc', 1657, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 840, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);

-- elvenforrest butterflys
INSERT INTO `spawnlist_npc` VALUES ('1900036', 'butterfly', '1', '71262', '33013', '32373', '0', '0', '4', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('1900037', 'butterfly', '1', '71263', '33038', '32382', '0', '0', '2', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('1900038', 'butterfly', '1', '71262', '33055', '32389', '0', '0', '0', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('1900039', 'butterfly', '1', '71263', '33067', '32372', '0', '0', '0', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('1900040', 'butterfly', '1', '71262', '33090', '32314', '0', '0', '4', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('1900041', 'butterfly', '1', '71263', '33127', '32327', '0', '0', '5', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('1900042', 'butterfly', '1', '71262', '33131', '32332', '0', '0', '4', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('1900043', 'butterfly', '1', '71263', '33010', '32312', '0', '0', '6', '0', '4', '0');
INSERT INTO `spawnlist_npc` VALUES ('1900044', 'butterfly', '1', '71262', '33009', '32320', '0', '0', '4', '0', '4', '0');

-- fafurion gate star
INSERT INTO `spawnlist_npc` VALUES ('1900055', 'FafurionStarGate', '1', '81307', '32734', '32679', '0', '0', '0', '0', '63', '0');

-- kingdom of eva fishes and seahorses.
INSERT INTO `spawnlist_npc` VALUES ('1900056', 'SeaHorse', '1', '81308', '32745', '32699', '5', '5', '1', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900057', 'SeaHorse', '1', '81308', '32747', '32720', '5', '5', '5', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900058', 'seabra fishgroup', '1', '81310', '32739', '32717', '5', '5', '6', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900059', 'yellow fishgroup', '1', '81311', '32727', '32720', '5', '5', '6', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900060', 'blue fishgroup', '1', '81312', '32732', '32702', '5', '5', '0', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900061', 'blueorange fishgroup', '1', '81313', '32711', '32702', '5', '5', '6', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900062', 'bluered fishgroup', '1', '81314', '32701', '32694', '5', '5', '6', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900063', 'yellow fishgroup', '1', '81311', '32711', '32682', '5', '5', '0', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900064', 'blue fishgroup', '1', '81312', '32719', '32684', '5', '5', '2', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900065', 'blueorange fishgroup', '1', '81313', '32724', '32699', '5', '5', '4', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900066', 'bluered fishgroup', '1', '81314', '32740', '32737', '5', '5', '4', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900067', 'blue fishgroup', '1', '81312', '32752', '32746', '5', '5', '3', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900068', 'yellow fishgroup', '1', '81311', '32775', '32740', '5', '5', '2', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900069', 'seabra fishgroup', '1', '81310', '32780', '32731', '5', '5', '0', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900070', 'seabra fishgroup', '1', '81310', '32796', '32738', '5', '5', '2', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900071', 'yellow fishgroup', '1', '81311', '32800', '32740', '5', '5', '2', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900072', 'blue fishgroup', '1', '81312', '32802', '32751', '5', '5', '4', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900073', 'blueorange fishgroup', '1', '81313', '32809', '32766', '5', '5', '4', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900074', 'bluered fishgroup', '1', '81314', '32808', '32766', '5', '5', '6', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900075', 'yellow fishgroup', '1', '81311', '32802', '32782', '5', '5', '4', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900076', 'blueorange fishgroup', '1', '81313', '32813', '32791', '5', '5', '2', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900077', 'bluered fishgroup', '1', '81314', '32786', '32813', '5', '5', '4', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900078', 'seabra fishgroup', '1', '81310', '32777', '32818', '5', '5', '5', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900079', 'SeaHorse', '1', '81308', '32781', '32816', '5', '5', '0', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900080', 'SeaHorse', '1', '81308', '32767', '32816', '5', '5', '5', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900081', 'SeaHorse', '1', '81308', '32761', '32802', '5', '5', '0', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900082', 'SeaHorse', '1', '81308', '32744', '32788', '5', '5', '6', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900084', 'SeaHorse', '1', '81308', '32734', '32759', '5', '5', '0', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900085', 'seabra fishgroup', '1', '81310', '32734', '32759', '5', '5', '0', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900086', 'blue fishgroup', '1', '81312', '32741', '32756', '5', '5', '2', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900087', 'SeaHorse', '1', '81308', '32738', '32745', '5', '5', '0', '0', '63', '100');
INSERT INTO `spawnlist_npc` VALUES ('1900088', 'SeaHorse', '1', '81308', '32739', '32729', '5', '5', '1', '0', '63', '100');

-- some gmcommands
INSERT INTO `commands` VALUES ('exprate', '200', 'L1ChangeExp');
INSERT INTO `commands` VALUES ('droprate', '200', 'L1ChangeDrop');
INSERT INTO `commands` VALUES ('ressall', '200', 'L1RessAll');
INSERT INTO `commands` VALUES ('allbufftoall', '200', 'L1AllBuffToAll');
INSERT INTO `commands` VALUES ('shop', '200', 'L1AddItemShop');
INSERT INTO `commands` VALUES ('siege', '200', 'L1WarStart');
INSERT INTO `commands` VALUES ('remove_instancemap', '200', 'L1RemoveInstanceMap');
INSERT INTO `commands` VALUES ('add_instancemap', '200', 'L1AddInstanceMap');
INSERT INTO `commands` VALUES ('tile', '200', 'L1Tile');

-- missing auctions added
INSERT INTO `board_auction` VALUES ('458753', 'Aden House 1', '51', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458754', 'Aden House 2', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458755', 'Aden House 3', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458756', 'Aden House 4', '56', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458757', 'Aden House 5', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458758', 'Aden House 6', '63', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458759', 'Aden House 7', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458760', 'Aden House 8', '63', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458761', 'Aden House 9', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458762', 'Aden House 10', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458763', 'Aden House 11', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458764', 'Aden House 12', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458765', 'Aden House 13', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458766', 'Aden House 14', '63', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458767', 'Aden House 15', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458768', 'Aden House 16', '56', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458769', 'Aden House 17', '63', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458770', 'Aden House 18', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458771', 'Aden House 19', '32', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458772', 'Aden House 20', '64', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458773', 'Aden House 21', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458774', 'Aden House 22', '20', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458775', 'Aden House 23', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458776', 'Aden House 24', '56', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458777', 'Aden House 25', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458778', 'Aden House 26', '20', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458779', 'Aden House 27', '42', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458780', 'Aden House 28', '15', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458781', 'Aden House 29', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458782', 'Aden House 30', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458783', 'Aden House 31', '42', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458784', 'Aden House 32', '48', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458785', 'Aden House 33', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458786', 'Aden House 34', '15', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458787', 'Aden House 35', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458788', 'Aden House 36', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458789', 'Aden House 37', '64', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458790', 'Aden House 38', '15', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458791', 'Aden House 39', '15', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458792', 'Aden House 40', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458793', 'Aden House 41', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458794', 'Aden House 42', '29', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458795', 'Aden House 43', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458796', 'Aden House 44', '15', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458797', 'Aden House 45', '56', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458798', 'Aden House 46', '15', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458799', 'Aden House 47', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458800', 'Aden House 48', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458801', 'Aden House 49', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458802', 'Aden House 50', '48', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458803', 'Aden House 51', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458804', 'Aden House 52', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458805', 'Aden House 53', '54', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458806', 'Aden House 54', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458807', 'Aden House 55', '63', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458808', 'Aden House 56', '63', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458809', 'Aden House 57', '42', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458810', 'Aden House 58', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458811', 'Aden House 59', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458812', 'Aden House 60', '63', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458813', 'Aden House 61', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458814', 'Aden House 62', '21', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458815', 'Aden House 63', '63', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458816', 'Aden House 64', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458817', 'Aden House 65', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458818', 'Aden House 66', '48', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('458819', 'Aden House 67', '24', '2010-10-28 23:00:00', '100000', 'Aden', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('262166', 'Giran House 22', '120', '2010-10-28 23:00:00', '100000', 'Giran', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('262170', 'Giran House 26', '120', '2010-10-28 23:00:00', '100000', 'Giran', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('262179', 'Giran House 35', '120', '2010-10-28 23:00:00', '100000', 'Giran', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('262180', 'Giran House 36', '45', '2010-10-28 23:00:00', '100000', 'Giran', '', '0', '', '0');
INSERT INTO `board_auction` VALUES ('262188', 'Giran House 44', '120', '2010-10-28 23:00:00', '100000', 'Giran', '', '0', '', '0');

-- ----------------------------
-- Table structure for `logclanwarehousein`
-- ----------------------------
DROP TABLE IF EXISTS `logclanwarehousein`;
CREATE TABLE `logclanwarehousein` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `ClanId` int(11) DEFAULT NULL,
  `ClanName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCountBefore` int(11) DEFAULT NULL,
  `ItemCountAfter` int(11) DEFAULT NULL,
  `ItemCountDiff` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL,
  `InCount` int(11) DEFAULT NULL,
  `CountDiff` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `logclanwarehouseOut`
-- ----------------------------
DROP TABLE IF EXISTS `logclanwarehouseOut`;
CREATE TABLE `logclanwarehouseOut` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `ClanId` int(11) DEFAULT NULL,
  `ClanName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCountBefore` int(11) DEFAULT NULL,
  `ItemCountAfter` int(11) DEFAULT NULL,
  `ItemCountDiff` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL,
  `InCount` int(11) DEFAULT NULL,
  `CountDiff` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogDeleteChar`
-- ----------------------------
DROP TABLE IF EXISTS `LogDeleteChar`;
CREATE TABLE `LogDeleteChar` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogDeleteItem`
-- ----------------------------
DROP TABLE IF EXISTS `LogDeleteItem`;
CREATE TABLE `LogDeleteItem` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogDropItem`
-- ----------------------------
DROP TABLE IF EXISTS `LogDropItem`;
CREATE TABLE `LogDropItem` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `BeforeInven` int(11) DEFAULT NULL,
  `AfterInven` int(11) DEFAULT NULL,
  `BeforeGround` int(11) DEFAULT NULL,
  `AfterGround` int(11) DEFAULT NULL,
  `Count` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
		
-- ----------------------------
-- Table structure for `LogElfWareHouseIn`
-- ----------------------------
DROP TABLE IF EXISTS `LogElfWareHouseIn`;
CREATE TABLE `LogElfWareHouseIn` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `ClanId` int(11) DEFAULT NULL,
  `ClanName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCountBefore` int(11) DEFAULT NULL,
  `ItemCountAfter` int(11) DEFAULT NULL,
  `ItemCountDiff` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL,
  `InCount` int(11) DEFAULT NULL,
  `CountDiff` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogElfWareHouseOut`
-- ----------------------------
DROP TABLE IF EXISTS `LogElfWareHouseOut`;
CREATE TABLE `LogElfWareHouseOut` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `ClanId` int(11) DEFAULT NULL,
  `ClanName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCountBefore` int(11) DEFAULT NULL,
  `ItemCountAfter` int(11) DEFAULT NULL,
  `ItemCountDiff` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL,
  `InCount` int(11) DEFAULT NULL,
  `CountDiff` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogEnchantFail`
-- ----------------------------
DROP TABLE IF EXISTS `LogEnchantFail`;
CREATE TABLE `LogEnchantFail` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogEnchantSuccess`
-- ----------------------------
DROP TABLE IF EXISTS `LogEnchantSuccess`;
CREATE TABLE `LogEnchantSuccess` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL,
  `EnchantBefore` int(11) DEFAULT NULL,
  `EnchantAfter` int(11) DEFAULT NULL,
  `EnchantDiff` int(11) DEFAULT NULL,
  `EnchantNum` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogPickUpItem`
-- ----------------------------
DROP TABLE IF EXISTS `LogPickUpItem`;
CREATE TABLE `LogPickUpItem` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `BeforeInven` int(11) DEFAULT NULL,
  `AfterInven` int(11) DEFAULT NULL,
  `BeforeGround` int(11) DEFAULT NULL,
  `AfterGround` int(11) DEFAULT NULL,
  `PickupCount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogPrivateShopBuy`
-- ----------------------------
DROP TABLE IF EXISTS `LogPrivateShopBuy`;
CREATE TABLE `LogPrivateShopBuy` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `TargetIp` varchar(255) DEFAULT NULL,
  `TargetAccount` varchar(255) DEFAULT NULL,
  `TargetCharId` int(11) DEFAULT NULL,
  `TargetCharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL,
  `ItemBefore` int(11) DEFAULT NULL,
  `ItemAfter` int(11) DEFAULT NULL,
  `ItemDiff` int(11) DEFAULT NULL,
  `BuyCount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogPrivateShopSell`
-- ----------------------------
DROP TABLE IF EXISTS `LogPrivateShopSell`;
CREATE TABLE `LogPrivateShopSell` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `TargetIp` varchar(255) DEFAULT NULL,
  `TargetAccount` varchar(255) DEFAULT NULL,
  `TargetCharId` int(11) DEFAULT NULL,
  `TargetCharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL,
  `ItemBefore` int(11) DEFAULT NULL,
  `ItemAfter` int(11) DEFAULT NULL,
  `ItemDiff` int(11) DEFAULT NULL,
  `SellCount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogShopBuy`
-- ----------------------------
DROP TABLE IF EXISTS `LogShopBuy`;
CREATE TABLE `LogShopBuy` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL,
  `AdenaBefore` int(11) DEFAULT NULL,
  `AdenaAfter` int(11) DEFAULT NULL,
  `AdenaDiff` int(11) DEFAULT NULL,
  `BuyPrice` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogShopSell`
-- ----------------------------
DROP TABLE IF EXISTS `LogShopSell`;
CREATE TABLE `LogShopSell` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL,
  `AdenaBefore` int(11) DEFAULT NULL,
  `AdenaAfter` int(11) DEFAULT NULL,
  `AdenaDiff` int(11) DEFAULT NULL,
  `SellPrice` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogSpeedHack`
-- ----------------------------
DROP TABLE IF EXISTS `LogSpeedHack`;
CREATE TABLE `LogSpeedHack` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
-- ----------------------------
-- Table structure for `LogStatusUp`
-- ----------------------------
DROP TABLE IF EXISTS `LogStatusUp`;
CREATE TABLE `LogStatusUp` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `Level` int(11) DEFAULT NULL,
  `Str` int(11) DEFAULT NULL,
  `BaseStr` int(11) DEFAULT NULL,
  `Dex` int(11) DEFAULT NULL,
  `BaseDex` int(11) DEFAULT NULL,
  `Con` int(11) DEFAULT NULL,
  `BaseCon` int(11) DEFAULT NULL,
  `Int` int(11) DEFAULT NULL,
  `BaseInt` int(11) DEFAULT NULL,
  `Wis` int(11) DEFAULT NULL,
  `BaseWis` int(11) DEFAULT NULL,
  `Cha` int(11) DEFAULT NULL,
  `BaseCha` int(11) DEFAULT NULL,
  `SorceStat` int(11) DEFAULT NULL,
  `BonusStats` int(11) DEFAULT NULL,
  `AllStats` int(11) DEFAULT NULL,
  `DiffSc` int(11) DEFAULT NULL,
  `DiffSr` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogTradeAddItem`
-- ----------------------------
DROP TABLE IF EXISTS `LogTradeAddItem`;
CREATE TABLE `LogTradeAddItem` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `TargetIp` varchar(255) DEFAULT NULL,
  `TargetAccount` varchar(255) DEFAULT NULL,
  `TargetCharId` int(11) DEFAULT NULL,
  `TargetCharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL,
  `ItemBefore` int(11) DEFAULT NULL,
  `ItemAfter` int(11) DEFAULT NULL,
  `ItemDiff` int(11) DEFAULT NULL,
  `TradeCount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogTradeBugItem`
-- ----------------------------
DROP TABLE IF EXISTS `LogTradeBugItem`;
CREATE TABLE `LogTradeBugItem` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `TargetIp` varchar(255) DEFAULT NULL,
  `TargetAccount` varchar(255) DEFAULT NULL,
  `TargetCharId` int(11) DEFAULT NULL,
  `TargetCharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogTradeComplete`
-- ----------------------------
DROP TABLE IF EXISTS `LogTradeComplete`;
CREATE TABLE `LogTradeComplete` (
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Ip` varchar(255) DEFAULT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `TargetIp` varchar(255) DEFAULT NULL,
  `TargetAccount` varchar(255) DEFAULT NULL,
  `TargetCharId` int(11) DEFAULT NULL,
  `TargetCharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL,
  `ItemBeforeTrade` int(11) DEFAULT NULL,
  `ItemBeforeInven` int(11) DEFAULT NULL,
  `ItemAfter` int(11) DEFAULT NULL,
  `ItemDiff` int(11) DEFAULT NULL,
  `TradeCount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogWareHouseIn`
-- ----------------------------
DROP TABLE IF EXISTS `LogWareHouseIn`;
CREATE TABLE `LogWareHouseIn` (
  `Account` varchar(255) DEFAULT NULL,
  `Ip` varchar(255) DEFAULT NULL,
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCountBefore` int(11) DEFAULT NULL,
  `ItemCountAfter` int(11) DEFAULT NULL,
  `ItemCountDiff` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL,
  `InCount` int(11) DEFAULT NULL,
  `CountDiff` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `LogWareHouseOut`
-- ----------------------------
DROP TABLE IF EXISTS `LogWareHouseOut`;
CREATE TABLE `LogWareHouseOut` (
  `Account` varchar(255) DEFAULT NULL,
  `Ip` varchar(255) DEFAULT NULL,
  `Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `CharId` int(11) DEFAULT NULL,
  `CharName` varchar(255) DEFAULT NULL,
  `ObjectId` int(11) DEFAULT NULL,
  `ItemName` varchar(255) DEFAULT NULL,
  `EnchantLevel` int(11) DEFAULT NULL,
  `ItemCountBefore` int(11) DEFAULT NULL,
  `ItemCountAfter` int(11) DEFAULT NULL,
  `ItemCountDiff` int(11) DEFAULT NULL,
  `ItemCount` int(11) DEFAULT NULL,
  `OutCount` int(11) DEFAULT NULL,
  `CountDiff` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `BotReport`
-- ----------------------------
DROP TABLE IF EXISTS `BotReport`;
CREATE TABLE `BotReport` (
  `id` int(11) NOT NULL,
  `date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `charname` varchar(45) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- stone effect spell fixes.
INSERT INTO `mobskill` VALUES ('45760', '0', 'Floating Eye', null, '2', '50', '0', '0', '-3', '0', '0', '3', '0', '0', '60', '12002', '0', '18', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45068', '0', 'Floating Eye', null, '2', '50', '0', '0', '-3', '0', '0', '3', '0', '0', '60', '12002', '0', '18', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45349', '0', 'Beholder', null, '2', '50', '0', '0', '-3', '0', '0', '3', '0', '0', '60', '12003', '0', '18', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45406', '0', 'Wicked Beholder', null, '2', '50', '0', '0', '-3', '0', '0', '3', '0', '0', '60', '12003', '0', '18', '0', '0', '0', '0');
-- INSERT INTO `mobskill` VALUES ('45423', '0', 'Subterranean Beholder', null, '2', '50', '0', '0', '-3', '0', '0', '3', '0', '0', '60', '12003', '0', '18', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45086', '0', 'Degenerated Beholder', null, '2', '50', '0', '0', '-3', '0', '0', '3', '0', '0', '60', '12003', '0', '18', '0', '0', '0', '0');

INSERT INTO `skills` VALUES ('12002', 'Floating Eye Attack', '0', '0', '10', '0', '0', '0', '0', '0', 'attack', '3', '50', '5', '5', '0', '0', '0', '64', '0', '2', '0', '0', '0', '0', '19', '0', '0', '0', '0', '0');
INSERT INTO `skills` VALUES ('12003', 'Beholder Attack', '0', '0', '10', '0', '0', '0', '0', '0', 'attack', '3', '50', '5', '5', '0', '0', '0', '64', '0', '2', '0', '0', '0', '0', '19', '0', '0', '0', '0', '0');

-- pvp deathmatch fix for not using skills and items.
-- INSERT INTO `mapids` VALUES ('5153', 'Death Match', '32576', '32703', '32832', '32959', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1');

-- npc Jode at gypsy town fix.
-- INSERT INTO `shop` VALUES ('70056', null, '37', null, '1', '80000', '0', '-1', null);
-- INSERT INTO `shop` VALUES ('70056', null, '148', null, '2', '88000', '0', '-1', null);
-- INSERT INTO `shop` VALUES ('70056', null, '100041', null, '3', '95000', '0', '-1', null);
-- INSERT INTO `shop` VALUES ('70056', null, '100102', null, '4', '85000', '0', '-1', null);
-- INSERT INTO `shop` VALUES ('70056', null, '142', null, '5', '83000', '0', '-1', null);
-- INSERT INTO `shop` VALUES ('70056', null, '100025', null, '6', '77000', '0', '-1', null);
-- INSERT INTO `shop` VALUES ('70056', null, '20101', null, '7', '84000', '0', '-1', null);
-- INSERT INTO `shop` VALUES ('70056', null, '20154', null, '8', '98000', '0', '-1', null);
-- INSERT INTO `shop` VALUES ('70056', null, '20229', null, '9', '78000', '0', '-1', null);
-- INSERT INTO `shop` VALUES ('70056', null, '20036', null, '10', '69000', '0', '-1', null);

-- mp hpr interval fixes
update npc set hprinterval = 3000;
update npc set Mprinterval = 2000;
update npc set hpr = 16;
update npc set mpr = 12;

-- normal monsters --
update npc set hprinterval = 2 where npcid = 45005;
update npc set hpr = 2000 where npcid = 45005;
update npc set hprinterval = 2000 where npcid = 45006;
update npc set hpr = 2 where npcid = 45006;
update npc set hprinterval = 2000 where npcid = 45008;
update npc set hpr = 2 where npcid = 45008;
update npc set hprinterval = 2000 where npcid = 45009;
update npc set hpr = 2 where npcid = 45009;
update npc set hprinterval = 2000 where npcid = 45010;
update npc set hpr = 2 where npcid = 45010;
update npc set hprinterval = 2000 where npcid = 45011;
update npc set hpr = 2 where npcid = 45011;
update npc set hprinterval = 2000 where npcid = 45012;
update npc set hpr = 2 where npcid = 45012;
update npc set hprinterval = 2000 where npcid = 45013;
update npc set hpr = 2 where npcid = 45013;
update npc set hprinterval = 2000 where npcid = 45015;
update npc set hpr = 2 where npcid = 45015;
update npc set hprinterval = 2000 where npcid = 45016;
update npc set hpr = 3 where npcid = 45016;
update npc set hprinterval = 2000 where npcid = 45017;
update npc set hpr = 2 where npcid = 45017;
update npc set hprinterval = 2000 where npcid = 45019;
update npc set hpr = 3 where npcid = 45019;
update npc set hprinterval = 2000 where npcid = 45020;
update npc set hpr = 3 where npcid = 45020;
update npc set hprinterval = 2000 where npcid = 45021;
update npc set hpr = 3 where npcid = 45021;
update npc set hprinterval = 2000 where npcid = 45022;
update npc set hpr = 3 where npcid = 45022;
update npc set hprinterval = 2000 where npcid = 45023;
update npc set hpr = 4 where npcid = 45023;
update npc set hprinterval = 2000 where npcid = 45024;
update npc set hpr = 6 where npcid = 45024;
update npc set hprinterval = 2000 where npcid = 45025;
update npc set hpr = 10 where npcid = 45025;
update npc set hprinterval = 2000 where npcid = 45026;
update npc set hpr = 8 where npcid = 45026;
update npc set hprinterval = 2000 where npcid = 45027;
update npc set hpr = 5 where npcid = 45027;
update npc set hprinterval = 2000 where npcid = 45028;
update npc set hpr = 8 where npcid = 45028;
update npc set hprinterval = 2000 where npcid = 45029;
update npc set hpr = 5 where npcid = 45029;
update npc set hprinterval = 2000 where npcid = 45030;
update npc set hpr = 6 where npcid = 45030;
update npc set hprinterval = 2000 where npcid = 45031;
update npc set hpr = 5 where npcid = 45031;
update npc set hprinterval = 2000 where npcid = 45032;
update npc set hpr = 5 where npcid = 45032;
update npc set hprinterval = 2000 where npcid = 45033;
update npc set hpr = 10 where npcid = 45033;
update npc set hprinterval = 2000 where npcid = 45034;
update npc set hpr = 10 where npcid = 45034;
update npc set hprinterval = 2000 where npcid = 45035;
update npc set hpr = 10 where npcid = 45035;
update npc set hprinterval = 2000 where npcid = 45036;
update npc set hpr = 12 where npcid = 45036;
update npc set hprinterval = 2000 where npcid = 45037;
update npc set hpr = 8 where npcid = 45037;
update npc set hprinterval = 2000 where npcid = 45038;
update npc set hpr = 8 where npcid = 45038;
update npc set hprinterval = 2000 where npcid = 45039;
update npc set hpr = 8 where npcid = 45039;
update npc set hprinterval = 2000 where npcid = 45041;
update npc set hpr = 10 where npcid = 45041;
update npc set hprinterval = 2000 where npcid = 45042;
update npc set hpr = 6 where npcid = 45042;
update npc set hprinterval = 2000 where npcid = 45043;
update npc set hpr = 8 where npcid = 45043;
update npc set hprinterval = 2000 where npcid = 45044;
update npc set hpr = 8 where npcid = 45044;
update npc set hprinterval = 2000 where npcid = 45045;
update npc set hpr = 12 where npcid = 45045;
update npc set hprinterval = 2000 where npcid = 45046;
update npc set hpr = 8 where npcid = 45046;
update npc set hprinterval = 2000 where npcid = 45047;
update npc set hpr = 8 where npcid = 45047;
update npc set hprinterval = 2000 where npcid = 45048;
update npc set hpr = 8 where npcid = 45048;
update npc set hprinterval = 2000 where npcid = 45049;
update npc set hpr = 8 where npcid = 45049;
update npc set hprinterval = 2000 where npcid = 45050;
update npc set hpr = 4 where npcid = 45050;
update npc set hprinterval = 2000 where npcid = 45051;
update npc set hpr = 6 where npcid = 45051;
update npc set hprinterval = 2000 where npcid = 45052;
update npc set hpr = 7 where npcid = 45052;
update npc set hprinterval = 2000 where npcid = 45053;
update npc set hpr = 8 where npcid = 45053;
update npc set hprinterval = 2000 where npcid = 45054;
update npc set hpr = 8 where npcid = 45054;
update npc set hprinterval = 2000 where npcid = 45055;
update npc set hpr = 5 where npcid = 45055;
update npc set hprinterval = 2000 where npcid = 45056;
update npc set hpr = 10 where npcid = 45056;
update npc set hprinterval = 2000 where npcid = 45057;
update npc set hpr = 9 where npcid = 45057;
update npc set hprinterval = 2000 where npcid = 45058;
update npc set hpr = 8 where npcid = 45058;
update npc set hprinterval = 2000 where npcid = 45059;
update npc set hpr = 12 where npcid = 45059;
update npc set hprinterval = 2000 where npcid = 45060;
update npc set hpr = 14 where npcid = 45060;
update npc set hprinterval = 2000 where npcid = 45061;
update npc set hpr = 12 where npcid = 45061;
update npc set hprinterval = 2000 where npcid = 45062;
update npc set hpr = 10 where npcid = 45062;
update npc set hprinterval = 2000 where npcid = 45063;
update npc set hpr = 10 where npcid = 45063;
update npc set hprinterval = 2000 where npcid = 45064;
update npc set hpr = 15 where npcid = 45064;
update npc set hprinterval = 2000 where npcid = 45065;
update npc set hpr = 9 where npcid = 45065;
update npc set hprinterval = 2000 where npcid = 45066;
update npc set hpr = 9 where npcid = 45066;
update npc set hprinterval = 2000 where npcid = 45067;
update npc set hpr = 7 where npcid = 45067;
update npc set hprinterval = 2000 where npcid = 45068;
update npc set hpr = 7 where npcid = 45068;
update npc set hprinterval = 2000 where npcid = 45069;
update npc set hpr = 8 where npcid = 45069;
update npc set hprinterval = 2000 where npcid = 45070;
update npc set hpr = 9 where npcid = 45070;
update npc set hprinterval = 2000 where npcid = 45071;
update npc set hpr = 8 where npcid = 45071;
update npc set hprinterval = 2000 where npcid = 45072;
update npc set hpr = 15 where npcid = 45072;
update npc set hprinterval = 2000 where npcid = 45073;
update npc set hpr = 10 where npcid = 45073;
update npc set hprinterval = 2000 where npcid = 45074;
update npc set hpr = 10 where npcid = 45074;
update npc set hprinterval = 2000 where npcid = 45075;
update npc set hpr = 10 where npcid = 45075;
update npc set hprinterval = 2000 where npcid = 45076;
update npc set hpr = 15 where npcid = 45076;
update npc set hprinterval = 2000 where npcid = 45077;
update npc set hpr = 8 where npcid = 45077;
update npc set hprinterval = 2000 where npcid = 45078;
update npc set hpr = 12 where npcid = 45078;
update npc set hprinterval = 2000 where npcid = 45079;
update npc set hpr = 12 where npcid = 45079;
update npc set hprinterval = 2000 where npcid = 45080;
update npc set hpr = 14 where npcid = 45080;
update npc set hprinterval = 2000 where npcid = 45081;
update npc set hpr = 9 where npcid = 45081;
update npc set hprinterval = 2000 where npcid = 45082;
update npc set hpr = 8 where npcid = 45082;
update npc set hprinterval = 2000 where npcid = 45083;
update npc set hpr = 6 where npcid = 45083;
update npc set hprinterval = 2000 where npcid = 45084;
update npc set hpr = 6 where npcid = 45084;
update npc set hprinterval = 2000 where npcid = 45085;
update npc set hpr = 14 where npcid = 45085;
update npc set hprinterval = 2000 where npcid = 45086;
update npc set hpr = 12 where npcid = 45086;
update npc set hprinterval = 2000 where npcid = 45087;
update npc set hpr = 10 where npcid = 45087;
update npc set hprinterval = 2000 where npcid = 45088;
update npc set hpr = 6 where npcid = 45088;
update npc set hprinterval = 2000 where npcid = 45089;
update npc set hpr = 12 where npcid = 45089;
update npc set hprinterval = 2000 where npcid = 45090;
update npc set hpr = 14 where npcid = 45090;
update npc set hprinterval = 2000 where npcid = 45091;
update npc set hpr = 12 where npcid = 45091;
update npc set hprinterval = 2000 where npcid = 45092;
update npc set hpr = 8 where npcid = 45092;
update npc set hprinterval = 2000 where npcid = 45093;
update npc set hpr = 10 where npcid = 45093;
update npc set hprinterval = 2000 where npcid = 45094;
update npc set hpr = 12 where npcid = 45094;
update npc set hprinterval = 2000 where npcid = 45095;
update npc set hpr = 12 where npcid = 45095;
update npc set hprinterval = 2000 where npcid = 45096;
update npc set hpr = 12 where npcid = 45096;
update npc set hprinterval = 3000 where npcid = 45097;
update npc set hpr = 25 where npcid = 45097;
update npc set hprinterval = 3000 where npcid = 45098;
update npc set hpr = 14 where npcid = 45098;
update npc set hprinterval = 3000 where npcid = 45099;
update npc set hpr = 20 where npcid = 45099;
update npc set hprinterval = 3000 where npcid = 45100;
update npc set hpr = 20 where npcid = 45100;
update npc set hprinterval = 3000 where npcid = 45101;
update npc set hpr = 15 where npcid = 45101;
update npc set hprinterval = 5000 where npcid = 45102;
update npc set hpr = 80 where npcid = 45102;
update npc set Mprinterval = 3000 where npcid = 45102;
update npc set mpr = 50 where npcid = 45102;
update npc set hprinterval = 3000 where npcid = 45103;
update npc set hpr = 10 where npcid = 45103;
update npc set hprinterval = 3000 where npcid = 45104;
update npc set hpr = 50 where npcid = 45104;
update npc set hprinterval = 3000 where npcid = 45105;
update npc set hpr = 20 where npcid = 45105;
update npc set hprinterval = 3000 where npcid = 45106;
update npc set hpr = 20 where npcid = 45106;
update npc set hprinterval = 3000 where npcid = 45107;
update npc set hpr = 20 where npcid = 45107;
update npc set hprinterval = 3000 where npcid = 45108;
update npc set hpr = 50 where npcid = 45108;
update npc set hprinterval = 3000 where npcid = 45109;
update npc set hpr = 50 where npcid = 45109;
update npc set hprinterval = 3000 where npcid = 45110;
update npc set Mprinterval = 2000 where npcid = 45110;
update npc set hpr = 16 where npcid = 45110;
update npc set mpr = 12 where npcid = 45110;
update npc set hprinterval = 3000 where npcid = 45111;
update npc set Mprinterval = 2000 where npcid = 45111;
update npc set hpr = 14 where npcid = 45111;
update npc set mpr = 6 where npcid = 45111;

-- 4 dragons --
update npc set hprinterval = 30000 where npcid = 45681;
update npc set Mprinterval = 25000 where npcid = 45681;
update npc set hpr = 500 where npcid = 45681;
update npc set mpr = 400 where npcid = 45681;
update npc set hprinterval = 35000 where npcid = 45682;
update npc set Mprinterval = 25000 where npcid = 45682;
update npc set hpr = 600 where npcid = 45682;
update npc set mpr = 500 where npcid = 45682;
update npc set hprinterval = 25000 where npcid = 45683;
update npc set Mprinterval = 20000 where npcid = 45683;
update npc set hpr = 500 where npcid = 45683;
update npc set mpr = 400 where npcid = 45683;
update npc set hprinterval = 20000 where npcid = 45684;
update npc set Mprinterval = 15000 where npcid = 45684;
update npc set hpr = 400 where npcid = 45684;
update npc set mpr = 300 where npcid = 45684;

-- Demon of Varlok --
update npc set hprinterval = 6000 where npcid = 45647;
update npc set hpr = 180 where npcid = 45647;
update npc set Mprinterval = 4000 where npcid = 45647;
update npc set mpr = 150 where npcid = 45647;

-- Slave of Assassin King --
update npc set hprinterval = 6000 where npcid = 45648;
update npc set hpr = 120 where npcid = 45648;

-- Demon --
update npc set hprinterval = 6000 where npcid = 45649;
update npc set hpr = 280 where npcid = 45649;
update npc set Mprinterval = 4000 where npcid = 45649;
update npc set mpr = 220 where npcid = 45649;

-- Zombie Lord --
update npc set hprinterval = 6000 where npcid = 45650;
update npc set hpr = 250 where npcid = 45650;
update npc set Mprinterval = 4000 where npcid = 45650;
update npc set mpr = 200 where npcid = 45650;


-- Dread King Baranka --
update npc set hprinterval = 6000 where npcid = 45651;
update npc set hpr = 150 where npcid = 45651;
update npc set Mprinterval = 4000 where npcid = 45651;
update npc set mpr = 130 where npcid = 45651;

-- Mummy Lord --
update npc set hprinterval = 6000 where npcid = 45653;
update npc set hpr = 250 where npcid = 45653;
update npc set Mprinterval = 4000 where npcid = 45653;
update npc set mpr = 200 where npcid = 45653;

-- Iris --
update npc set hprinterval = 6000 where npcid = 45654;
update npc set hpr = 270 where npcid = 45654;
update npc set Mprinterval = 4000 where npcid = 45654;
update npc set mpr = 220 where npcid = 45654;

-- Knight Vald --
update npc set hprinterval = 6000 where npcid = 45664;
update npc set hpr = 300 where npcid = 45664;

-- Baras --
update npc set hprinterval = 6000 where npcid = 45665;
update npc set hpr = 300 where npcid = 45665;

-- Teranus --
update npc set hprinterval = 6000 where npcid = 45666;
update npc set hpr = 300 where npcid = 45666;

-- Kunos --
update npc set hprinterval = 6000 where npcid = 45667;
update npc set hpr = 300 where npcid = 45667;

-- Zyrus --
update npc set hprinterval = 6000 where npcid = 45668;
update npc set hpr = 300 where npcid = 45668;

-- Ariorc --
update npc set hprinterval = 6000 where npcid = 45671;
update npc set Mprinterval = 4000 where npcid = 45671;
update npc set hpr = 250 where npcid = 45671;
update npc set mpr = 200 where npcid = 45671;

-- Lich --
update npc set hprinterval = 8000 where npcid = 45672;
update npc set Mprinterval = 5000 where npcid = 45672;
update npc set hpr = 350 where npcid = 45672;
update npc set mpr = 280 where npcid = 45672;

-- GrimReaper --
update npc set hprinterval = 6000 where npcid = 45673;
update npc set Mprinterval = 3000 where npcid = 45673;
update npc set hpr = 350 where npcid = 45673;
update npc set mpr = 280 where npcid = 45673;

-- Death --
update npc set hprinterval = 5000 where npcid = 45674;
update npc set Mprinterval = 3000 where npcid = 45674;
update npc set hpr = 250 where npcid = 45674;
update npc set mpr = 220 where npcid = 45674;

-- Yahee --
update npc set hprinterval = 8000 where npcid = 45675;
update npc set Mprinterval = 6000 where npcid = 45675;
update npc set hpr = 200 where npcid = 45675;
update npc set mpr = 160 where npcid = 45675;

-- Bright Magic King Hellvine --
update npc set hprinterval = 7000 where npcid = 45676;
update npc set hpr = 150 where npcid = 45676;

-- Dread Queen Laia --
update npc set hprinterval = 8000 where npcid = 45677;
update npc set Mprinterval = 4000 where npcid = 45677;
update npc set hpr = 150 where npcid = 45677;
update npc set mpr = 110 where npcid = 45677;

-- Cerenis --
update npc set hprinterval = 8000 where npcid = 45678;
update npc set Mprinterval = 5000 where npcid = 45678;
update npc set hpr = 180 where npcid = 45678;
update npc set mpr = 150 where npcid = 45678;

-- Ken Rahaul --
update npc set hprinterval = 10000 where npcid = 45680;
update npc set Mprinterval = 8000 where npcid = 45680;
update npc set hpr = 350 where npcid = 45680;
update npc set mpr = 250 where npcid = 45680;

-- Tarak --
update npc set hprinterval = 15000 where npcid = 45685;
update npc set Mprinterval = 10000 where npcid = 45685;
update npc set hpr = 350 where npcid = 45685;
update npc set mpr = 200 where npcid = 45685;

-- ----------------------------
-- Table structure for checkwartime
-- ----------------------------
CREATE TABLE `checkwartime` (
  `castle_id` int(12) NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  `isActive` int(1) NOT NULL default '1',
  PRIMARY KEY  (`castle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

INSERT INTO `checkwartime` VALUES ('1', 'Kent Castle', '0');
INSERT INTO `checkwartime` VALUES ('2', 'Orc Castle', '0');
INSERT INTO `checkwartime` VALUES ('3', 'Windawood Castle', '0');
INSERT INTO `checkwartime` VALUES ('4', 'Giran Castle', '0');
INSERT INTO `checkwartime` VALUES ('5', 'Heine Castle', '0');
INSERT INTO `checkwartime` VALUES ('6', 'Dwarf Castle', '0');
INSERT INTO `checkwartime` VALUES ('7', 'Aden Castle', '0');
INSERT INTO `checkwartime` VALUES ('8', 'Diad Fortress', '0');

-- add Dwarf Adelio
INSERT INTO spawnlist_npc VALUES(NULL,'',1,71125,32579,32659,0,0,6,0,400,0);
