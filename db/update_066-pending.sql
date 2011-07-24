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
