-- update 26

-- activate more elemental grave spawn
-- fangs
update spawnlist set count = 1 where count = 0 and npc_templateid in (45416, 45418, 45419, 45424);
-- masters
update spawnlist set count = 1 where count = 0 and npc_templateid in (45500, 45508, 45510, 45511);



-- update 27

-- undo the pair spawns of mobs where there exists unused 0 count spawnpoints
-- spread out DV cockatrice spawn
update spawnlist set count = 1 where npc_templateid = 45361 and mapid = 4;
-- spread out Basilisk spawn
update spawnlist set count = 1 where npc_templateid = 45381 and mapid = 4;
-- spread out Cyclops spawn
update spawnlist set count = 1 where npc_templateid = 45420 and mapid = 4;
-- spread out Alligator spawn
update spawnlist set count = 1 where npc_templateid = 45101 and mapid = 4;
-- spread out Iron Golem spawn
update spawnlist set count = 1 where npc_templateid = 45372 and mapid = 4;
-- spread out Lava Golem spawn
update spawnlist set count = 1 where npc_templateid = 45365 and mapid = 4;
-- spread out Astagio spawn
update spawnlist set count = 1 where npc_templateid = 45359 and mapid = 4;
-- spread out Giant spawn
update spawnlist set count = 1 where npc_templateid in (45351, 45337, 45295) and mapid = 4;
-- spread out Beholder spawn
update spawnlist set count = 1 where npc_templateid = 45349 and mapid = 4;
-- spread out Taurverus spawn
update spawnlist set count = 1 where npc_templateid = 45341 and mapid = 4;
-- spread out Bandit spawn
update spawnlist set count = 1 where npc_templateid in (45324, 45329, 81080) and mapid = 4;
-- spread out Griffon spawn
update spawnlist set count = 1 where npc_templateid = 45321 and mapid = 4;
-- spread out Yeti spawn
update spawnlist set count = 1 where npc_templateid = 45294 and mapid = 4;
-- spread out Fire Archer spawn
update spawnlist set count = 1 where npc_templateid = 45291 and mapid = 4;
-- spread out Fire Warrior spawn
update spawnlist set count = 1 where npc_templateid = 45284 and mapid = 4;
-- spread out Right-Hand Bandit spawn
update spawnlist set count = 1 where npc_templateid in (45276, 45194) and mapid = 4;
-- spread out Snow Tiger spawn
update spawnlist set count = 1 where npc_templateid = 45267 and mapid = 4;
-- spread out Dark Elf spawn
update spawnlist set count = 1 where npc_templateid = 45265 and mapid = 4;
-- spread out Bomb Flower spawn
update spawnlist set count = 1 where npc_templateid = 45263 and mapid = 4;
-- spread out Dragonfly spawn
update spawnlist set count = 1 where npc_templateid = 45257 and mapid = 4;
-- spread out Undead Elmore General spawn
update spawnlist set count = 1 where npc_templateid = 45248 and mapid = 4;
-- spread out Harpy spawn
update spawnlist set count = 1 where npc_templateid = 45264 and mapid = 4;
-- spread out Turtle Dragon spawn
update spawnlist set count = 1 where npc_templateid = 45262 and mapid = 4;
-- spread out Undead Elmore Wizard spawn
update spawnlist set count = 1 where npc_templateid = 45224 and mapid = 4;
-- spread out Bugbear spawn
update spawnlist set count = 1 where npc_templateid = 45223 and mapid = 4;
-- spread out Ramia spawn
update spawnlist set count = 1 where npc_templateid = 45222 and mapid = 4;
-- spread out Undead Elmore Soldier spawn
update spawnlist set count = 1 where npc_templateid = 45216 and mapid = 4;
-- spread out Elder spawn
update spawnlist set count = 1 where npc_templateid = 45215 and mapid = 4;
-- spread out Ghast spawn
update spawnlist set count = 1 where npc_templateid = 45213 and mapid = 4;
-- spread out Ice Man spawn
update spawnlist set count = 1 where npc_templateid = 45207 and mapid = 4;
-- spread out Fire Egg spawn
update spawnlist set count = 1 where npc_templateid = 45206 and mapid = 4;
-- spread out Salamander spawn
update spawnlist set count = 1 where npc_templateid = 45203 and mapid = 4;
-- spread out Giant Soldier Ant spawn (just the count 0 ones)
update spawnlist set count = 1 where npc_templateid = 45190 and mapid = 4 and count = 0;
-- spread out Doppelganger spawn
update spawnlist set count = 1 where npc_templateid = 45189 and mapid = 4;
-- spread out Arachnevil Elder spawn
update spawnlist set count = 1 where npc_templateid = 45184 and mapid = 4;
-- spread out Lycanthrope spawn
update spawnlist set count = 1 where npc_templateid = 45173 and mapid = 4;
-- spread out tribal orcs spawn (just the count 0 ones)
update spawnlist set count = 1 where npc_templateid in (45098, 45127, 45143, 45149, 45171) and mapid = 4 and count = 0;
-- spread out Spartoi spawn
update spawnlist set count = 1 where npc_templateid = 45161 and mapid = 4;
-- spread out Ghoul spawn
update spawnlist set count = 1 where npc_templateid = 45157 and mapid = 4;
-- spread out Owlbear spawn
update spawnlist set count = 1 where npc_templateid = 45147 and mapid = 4;
-- spread out Lizardman spawn
update spawnlist set count = 1 where npc_templateid = 45144 and mapid = 4;
-- spread out Hobgoblin spawn
update spawnlist set count = 1 where npc_templateid = 45140 and mapid = 4;
-- spread out Arachnevil spawn
update spawnlist set count = 1 where npc_templateid = 45136 and mapid = 4;
-- spread out Snowman spawn
update spawnlist set count = 1 where npc_templateid = 45133 and mapid = 4;
-- spread out Stone Golem spawn
update spawnlist set count = 1 where npc_templateid = 45126 and mapid = 4;
-- spread out Skeleton Archer spawn
update spawnlist set count = 1 where npc_templateid = 45122 and mapid = 4;
-- spread out Giant Ant spawn (just the count 0 ones)
update spawnlist set count = 1 where npc_templateid = 45115 and mapid = 4 and count = 0;
-- spread out Skeleton spawn
update spawnlist set count = 1 where npc_templateid = 45107 and mapid = 4;
-- spread out Dwarf Warrior spawn
update spawnlist set count = 1 where npc_templateid = 45092 and mapid = 4;
-- spread out Orc Fighter spawn
update spawnlist set count = 1 where npc_templateid = 45082 and mapid = 4;
-- spread out Gnoll spawn
update spawnlist set count = 1 where npc_templateid = 45079 and mapid = 4;
-- spread out Floating Eye spawn
update spawnlist set count = 1 where npc_templateid = 45068 and mapid = 4;
-- spread out Zombie spawn
update spawnlist set count = 1 where npc_templateid = 45065 and mapid = 4;
-- spread out Slime spawn
update spawnlist set count = 1 where npc_templateid = 45060 and mapid = 4;
-- spread out Husky spawn
update spawnlist set count = 1 where npc_templateid = 45053 and mapid = 4;
-- spread out Fox spawn
update spawnlist set count = 1 where npc_templateid = 45048 and mapid = 4;
-- spread out Saint Bernard spawn
update spawnlist set count = 1 where npc_templateid = 45047 and mapid = 4;
-- spread out Beagle spawn
update spawnlist set count = 1 where npc_templateid = 45046 and mapid = 4;
-- spread out Wolf spawn
update spawnlist set count = 1 where npc_templateid = 45043 and mapid = 4;
-- spread out Doberman spawn
update spawnlist set count = 1 where npc_templateid = 45042 and mapid = 4;
-- spread out Dwarf spawn
update spawnlist set count = 1 where npc_templateid = 45041 and mapid = 4;
-- spread out Bear spawn
update spawnlist set count = 1 where npc_templateid = 45040 and mapid = 4;
-- spread out Shepherd spawn
update spawnlist set count = 1 where npc_templateid = 45034 and mapid = 4;
-- spread out Imp spawn
update spawnlist set count = 1 where npc_templateid = 45033 and mapid = 4;
-- spread out Werewolf spawn
update spawnlist set count = 1 where npc_templateid = 45024 and mapid = 4;
-- spread out Wild Boar spawn
update spawnlist set count = 1 where npc_templateid = 45023 and mapid = 4;
-- spread out Deer spawn
update spawnlist set count = 1 where npc_templateid = 45021 and mapid = 4;
-- spread out Orc Archer spawn
update spawnlist set count = 1 where npc_templateid = 45019 and mapid = 4;
-- spread out Kobold spawn
update spawnlist set count = 1 where npc_templateid = 45016 and mapid = 4;
-- spread out Duck spawn
update spawnlist set count = 1 where npc_templateid = 45015 and mapid = 4;
-- spread out Rabbit spawn
update spawnlist set count = 1 where npc_templateid in (45012, 45010) and mapid = 4;
-- spread out Orc spawn
update spawnlist set count = 1 where npc_templateid = 45009 and mapid = 4;
-- spread out Goblin spawn
update spawnlist set count = 1 where npc_templateid = 45008 and mapid = 4;
-- spread out Frog spawn
update spawnlist set count = 1 where npc_templateid = 45005 and mapid = 4;

-- undouble wicked yeti spawn
update spawnlist set count = 1 where npc_templateid = 81043 and mapid = 4;
-- undouble Corrupt Guard spawn
update spawnlist set count = 1 where npc_templateid = 45292 and mapid = 4;
-- undouble Birds spawn
update spawnlist set count = 1 where npc_templateid = 81159;



-- update 28 

-- remove bad snow tiger spawn
delete from spawnlist where id = 12472;

-- slightly reduce Priest of Corruption spawnrate in SoE
update spawnlist set count = 14 where npc_templateid = 45570 and mapid = 410 and count = 16;
update spawnlist set count = 14 where npc_templateid = 45571 and mapid = 410 and count = 16;
update spawnlist set count = 14 where npc_templateid = 45582 and mapid = 410 and count = 16;
update spawnlist set count = 14 where npc_templateid = 45587 and mapid = 410 and count = 16;
update spawnlist set count = 10 where npc_templateid = 45570 and mapid = 410 and count = 12;
update spawnlist set count = 10 where npc_templateid = 45571 and mapid = 410 and count = 12;
update spawnlist set count = 10 where npc_templateid = 45582 and mapid = 410 and count = 12;
update spawnlist set count = 10 where npc_templateid = 45587 and mapid = 410 and count = 12;
update spawnlist set count = 10 where npc_templateid = 45605 and mapid = 410 and count = 12;

-- replace SI starved troll spawn with mutated alligator
update spawnlist set npc_templateid = 45026 where npc_templateid = 45069 and mapid = 68;

-- spread out HV/SI spawn
update spawnlist set count = 1 where mapid = 68 and npc_templateid in (45005, 45008, 45009, 45010, 45012, 45016, 45019, 45021, 45023, 45024, 45034, 45041, 45042, 45065, 45069, 45071, 45081, 45082, 45095, 45096);
update spawnlist set count = 1 where mapid = 68 and count = 0 and npc_templateid in (45062, 45063, 45073, 45086);
update spawnlist set count = 1 where mapid = 69 and npc_templateid in (45008, 45009, 45010, 45012, 45019, 45021, 45022, 45023, 45035, 45041, 45059, 45067, 45069, 45078, 45082, 45090, 45091);
update spawnlist set count = 1 where mapid = 68 and count = 0 and npc_templateid in (45036, 45037, 45038, 45052, 45056);



-- update 29

-- undouble the lvl 50 quest area 4F mops
update spawnlist set count = 1 where mapid = 2003;



-- update 30

-- merge in new spawnlist entries
INSERT INTO `spawnlist` VALUES ('41', 'Frog', '1', '45005', '0', '32565', '32297', '0', '0', '0', '0', '0', '0', '1', '60', '120', '4', '0', '100', '0', '0');
INSERT INTO `spawnlist` VALUES ('1821', 'Gremlin', '15', '45025', '0', '0', '0', '0', '0', '32795', '33333', '32934', '33381', '0', '60', '120', '4', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('1822', 'Gremlin', '12', '45025', '0', '0', '0', '0', '0', '32810', '32820', '32950', '32850', '0', '60', '120', '4', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('1823', 'Gremlin', '8', '45025', '0', '0', '0', '0', '0', '32900', '32775', '32960', '32830', '0', '60', '120', '4', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('1824', 'Gremlin', '1', '45025', '0', '32706', '32801', '10', '10', '0', '0', '0', '0', '0', '60', '120', '4', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('1825', 'Gremlin', '1', '45025', '0', '32736', '32806', '10', '10', '0', '0', '0', '0', '0', '60', '120', '4', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('1826', 'Gremlin', '1', '45025', '0', '32770', '32837', '10', '10', '0', '0', '0', '0', '0', '60', '120', '4', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('1827', 'Gremlin', '1', '45025', '0', '32814', '32834', '10', '10', '0', '0', '0', '0', '0', '60', '120', '4', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('1831', 'Eidlon', '25', '45027', '0', '0', '0', '0', '0', '33260', '32580', '33640', '32610', '0', '60', '120', '4', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('1832', 'Eidlon', '10', '45027', '0', '0', '0', '0', '0', '33500', '32620', '33565', '32680', '0', '60', '120', '4', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('1833', 'Eidlon', '25', '45027', '0', '0', '0', '0', '0', '33550', '32745', '33690', '32900', '0', '60', '120', '4', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('1834', 'Eidlon', '20', '45027', '0', '0', '0', '0', '0', '33300', '32890', '33600', '33000', '0', '60', '120', '4', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('1835', 'Eidlon', '20', '45027', '0', '0', '0', '0', '0', '33260', '32610', '33300', '32980', '0', '60', '120', '4', '0', '0', '0', '0');
update spawnlist set locx = 33117 where id = 8331;
update spawnlist set npc_templateid = 81066, randomx = 3, randomy = 3 where id in (8335, 8336, 8337, 8338, 8339, 8340, 8341);
INSERT INTO `spawnlist` VALUES ('26401', 'Frog', '1', '45005', '0', '33605', '33214', '12', '12', '0', '0', '0', '0', '4', '60', '120', '4', '0', '100', '0', '0');
INSERT INTO `spawnlist` VALUES ('26500', '', '1', '45119', '0', '32629', '32809', '3', '3', '0', '0', '0', '0', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26501', '', '1', '45119', '0', '32641', '32821', '3', '3', '0', '0', '0', '0', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26502', '', '1', '45119', '0', '32676', '32815', '3', '3', '0', '0', '0', '0', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26503', '', '1', '45119', '0', '32650', '32827', '3', '3', '0', '0', '0', '0', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26504', '', '1', '45119', '0', '32680', '32835', '3', '3', '0', '0', '0', '0', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26505', '', '10', '45119', '0', '0', '0', '0', '0', '32660', '32830', '32730', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26506', '', '25', '45018', '0', '0', '0', '0', '0', '32640', '32790', '32750', '32870', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26507', '', '10', '45018', '0', '0', '0', '0', '0', '32660', '32830', '32730', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26508', '', '15', '45030', '0', '0', '0', '0', '0', '32700', '32810', '32750', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26509', '', '30', '45050', '0', '0', '0', '0', '0', '32660', '32830', '32730', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26510', '', '25', '45066', '0', '0', '0', '0', '0', '32630', '32800', '32730', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26511', '', '15', '45084', '0', '0', '0', '0', '0', '32660', '32830', '32730', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26512', '', '10', '45084', '0', '0', '0', '0', '0', '32700', '32810', '32750', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26513', '', '15', '45094', '0', '0', '0', '0', '0', '32640', '32790', '32750', '32870', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26514', '', '10', '45094', '0', '0', '0', '0', '0', '32700', '32810', '32750', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26515', '', '20', '45109', '0', '0', '0', '0', '0', '32660', '32830', '32730', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26516', '', '30', '45114', '0', '0', '0', '0', '0', '32640', '32830', '32690', '33000', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26517', '', '10', '45114', '0', '0', '0', '0', '0', '32650', '32900', '32725', '33000', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26518', '', '20', '45120', '0', '0', '0', '0', '0', '32660', '32830', '32730', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26519', '', '10', '45120', '0', '0', '0', '0', '0', '32700', '32810', '32750', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26520', '', '20', '45129', '0', '0', '0', '0', '0', '32640', '32830', '32690', '33000', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26521', '', '10', '45129', '0', '0', '0', '0', '0', '32650', '32900', '32725', '33000', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26522', '', '5', '45134', '0', '0', '0', '0', '0', '32660', '32800', '32740', '32830', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26523', '', '10', '45134', '0', '0', '0', '0', '0', '32720', '32830', '32760', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26524', '', '5', '45134', '0', '0', '0', '0', '0', '32700', '32810', '32750', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26525', '', '20', '45145', '0', '0', '0', '0', '0', '32660', '32830', '32730', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26526', '', '15', '45145', '0', '0', '0', '0', '0', '32640', '32830', '32690', '33000', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26527', '', '15', '45148', '0', '0', '0', '0', '0', '32660', '32830', '32730', '32970', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26528', '', '10', '45181', '0', '0', '0', '0', '0', '32640', '32830', '32690', '33000', '0', '60', '120', '304', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('26529', '', '15', '45181', '0', '0', '0', '0', '0', '32650', '32900', '32725', '33000', '0', '60', '120', '304', '0', '0', '0', '0');
update spawnlist set count = 1 where id between 26656 and 27464;
INSERT INTO `spawnlist` VALUES ('2100008', '', '2', '45179', '0', '32767', '32767', '0', '0', '32731', '32773', '32831', '32831', '5', '0', '0', '21', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('2100009', '', '5', '45186', '0', '32767', '32767', '0', '0', '32704', '32704', '32766', '32774', '5', '0', '0', '21', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('2100010', '', '5', '45186', '0', '32767', '32767', '0', '0', '32731', '32773', '32831', '32831', '5', '0', '0', '21', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('2100011', '', '10', '45336', '0', '32790', '32743', '0', '0', '32790', '32743', '32805', '32749', '5', '0', '0', '21', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('2100012', '', '1', '45504', '0', '32802', '32746', '1', '1', '0', '0', '0', '0', '0', '60', '120', '21', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('10200004', '', '10', '45380', '0', '32798', '32798', '0', '0', '32704', '32704', '32895', '32895', '0', '0', '0', '102', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10300005', '', '10', '45407', '0', '32798', '32798', '0', '0', '32704', '32704', '32895', '32895', '0', '0', '0', '103', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10400005', '', '12', '45407', '0', '32670', '32861', '0', '0', '32576', '32768', '32767', '32959', '0', '0', '0', '104', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10500004', '', '1', '45380', '24', '32670', '32861', '0', '0', '32576', '32768', '32767', '32959', '0', '0', '0', '105', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10500005', '', '35', '45407', '0', '32670', '32861', '0', '0', '32576', '32768', '32767', '32959', '0', '0', '0', '105', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10500006', '', '3', '45407', '25', '32670', '32861', '0', '0', '32576', '32768', '32767', '32959', '0', '0', '0', '105', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10700004', '', '2', '45380', '24', '32670', '32861', '0', '0', '32576', '32768', '32767', '32959', '0', '0', '0', '107', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10700005', '', '23', '45407', '0', '32670', '32861', '0', '0', '32576', '32768', '32767', '32959', '0', '0', '0', '107', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10700006', '', '5', '45407', '25', '32670', '32861', '0', '0', '32576', '32768', '32767', '32959', '0', '0', '0', '107', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10800004', '', '3', '45380', '24', '32670', '32861', '0', '0', '32576', '32768', '32767', '32959', '0', '0', '0', '108', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10800005', '', '25', '45407', '0', '32670', '32861', '0', '0', '32576', '32768', '32767', '32959', '0', '0', '0', '108', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10800006', '', '5', '45407', '25', '32670', '32861', '0', '0', '32576', '32768', '32767', '32959', '0', '0', '0', '108', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10900004', '', '3', '45380', '24', '32670', '32861', '0', '0', '32576', '32768', '32767', '32959', '0', '0', '0', '109', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10900005', '', '22', '45407', '0', '32670', '32861', '0', '0', '32576', '32768', '32767', '32959', '0', '0', '0', '109', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('10900006', '', '5', '45407', '25', '32670', '32861', '0', '0', '32576', '32768', '32767', '32959', '0', '0', '0', '109', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11000004', '', '3', '45380', '24', '32800', '32799', '0', '0', '32704', '32704', '32895', '32895', '0', '0', '0', '110', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11000005', '', '23', '45407', '0', '32800', '32799', '0', '0', '32704', '32704', '32895', '32895', '0', '0', '0', '110', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11000006', '', '5', '45407', '25', '32800', '32799', '0', '0', '32704', '32704', '32895', '32895', '0', '0', '0', '110', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11100003', '', '10', '45409', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '111', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11200004', '', '12', '45409', '0', '32798', '32798', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '112', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11300004', '', '13', '45409', '0', '32798', '32798', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '113', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11400004', '', '8', '45409', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '114', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11400005', '', '2', '45409', '28', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '114', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11500004', '', '24', '45409', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '115', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11500005', '', '5', '45409', '28', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '115', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11700004', '', '3', '45406', '29', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '117', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11700005', '', '23', '45409', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '117', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11700006', '', '5', '45409', '28', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '117', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11800004', '', '3', '45406', '29', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '118', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11800005', '', '25', '45409', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '118', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11800006', '', '5', '45409', '28', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '118', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11900004', '', '3', '45406', '29', '32670', '32861', '0', '0', '32602', '32794', '32741', '32933', '0', '0', '0', '119', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11900005', '', '30', '45409', '0', '32670', '32861', '0', '0', '32602', '32794', '32741', '32933', '0', '0', '0', '119', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('11900006', '', '5', '45409', '28', '32670', '32861', '0', '0', '32602', '32794', '32741', '32933', '0', '0', '0', '119', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12000004', '', '5', '45406', '29', '32800', '32799', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '120', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12000005', '', '20', '45409', '0', '32800', '32799', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '120', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12000006', '', '10', '45409', '28', '32800', '32799', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '120', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12100003', '', '30', '45440', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '121', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12100004', '', '5', '45440', '31', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '121', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12200004', '', '5', '45440', '31', '32798', '32798', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '122', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12200005', '', '14', '45471', '0', '32798', '32798', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '122', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12200006', '', '3', '45471', '33', '32798', '32798', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '122', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12300004', '', '5', '45440', '31', '32798', '32798', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '123', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12300005', '', '10', '45471', '0', '32798', '32798', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '123', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12300006', '', '3', '45471', '33', '32798', '32798', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '123', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12400004', '', '5', '45440', '31', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '124', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12400005', '', '6', '45471', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '124', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12400006', '', '3', '45471', '33', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '124', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12500004', '', '3', '45471', '33', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '125', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12500005', '', '25', '45481', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '125', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12500006', '', '5', '45481', '34', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '125', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12700004', '', '5', '45481', '34', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '127', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12700005', '', '5', '45515', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '127', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12700006', '', '2', '45515', '35', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '127', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12800004', '', '5', '45481', '34', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '128', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12800005', '', '7', '45515', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '128', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12800006', '', '3', '45515', '35', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '128', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12900004', '', '5', '45481', '34', '32670', '32861', '0', '0', '32602', '32794', '32741', '32933', '0', '0', '0', '129', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12900005', '', '6', '45515', '0', '32670', '32861', '0', '0', '32602', '32794', '32741', '32933', '0', '0', '0', '129', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('12900006', '', '3', '45515', '35', '32670', '32861', '0', '0', '32602', '32794', '32741', '32933', '0', '0', '0', '129', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13000005', '', '20', '45481', '0', '32800', '32799', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '130', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13000006', '', '5', '45481', '34', '32800', '32799', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '130', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13000007', '', '5', '45515', '0', '32800', '32799', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '130', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13000008', '', '5', '45515', '35', '32800', '32799', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '130', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13100003', '', '2', '45454', '37', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '131', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13200004', '', '3', '45454', '0', '32798', '32798', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '132', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13200005', '', '1', '45454', '37', '32798', '32798', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '132', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13300004', '', '3', '45454', '37', '32798', '32798', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '133', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13300005', '', '7', '45455', '0', '32798', '32798', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '133', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13400004', '', '2', '45454', '37', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '134', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13400005', '', '8', '45455', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '134', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13400006', '', '2', '45455', '38', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '134', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13500004', '', '5', '45455', '38', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '135', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13500005', '', '8', '45494', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '135', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13500006', '', '2', '45494', '39', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '135', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13700004', '', '6', '45494', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '137', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13700005', '', '2', '45494', '39', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '137', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13800004', '', '8', '45494', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '138', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13800005', '', '2', '45494', '39', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '138', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13900004', '', '7', '45494', '0', '32670', '32861', '0', '0', '32602', '32794', '32741', '32933', '0', '0', '0', '139', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('13900005', '', '3', '45494', '39', '32670', '32861', '0', '0', '32602', '32794', '32741', '32933', '0', '0', '0', '139', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('14000004', '', '11', '45494', '0', '32800', '32799', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '140', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('14000005', '', '3', '45494', '39', '32800', '32799', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '140', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('15700004', '', '2', '45541', '40', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '157', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('15800005', '', '3', '45541', '40', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '158', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('15900004', '', '3', '45541', '40', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '159', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('16000004', '', '3', '45541', '40', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '160', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('16700004', '', '5', '45572', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '167', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('16700005', '', '2', '45572', '42', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '167', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('16800005', '', '5', '45572', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '168', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('16800006', '', '2', '45572', '42', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '168', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('16900004', '', '5', '45572', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '169', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('16900005', '', '2', '45572', '42', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '169', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('17000004', '', '5', '45572', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '170', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('17000005', '', '2', '45572', '42', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '170', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('17700004', '', '11', '45580', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '177', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('17800005', '', '11', '45580', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '178', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('17900004', '', '11', '45580', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '179', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('18000004', '', '12', '45580', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '180', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('18100004', '', '14', '45604', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '181', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('18200004', '', '15', '45604', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '182', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('18300004', '', '7', '45589', '0', '32670', '32861', '0', '0', '32602', '32794', '32741', '32933', '5', '0', '0', '183', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('18400005', '', '5', '45604', '0', '32798', '32798', '0', '0', '32722', '32722', '32877', '32877', '0', '0', '0', '184', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('18700004', '', '2', '45589', '46', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '5', '0', '0', '187', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('18700005', '', '16', '45604', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '187', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('18700006', '', '3', '45604', '45', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '187', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('18800005', '', '8', '45604', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '188', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('18800006', '', '2', '45604', '45', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '188', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('18800007', '', '14', '45586', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '188', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('18900004', '', '14', '45604', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '189', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('18900005', '', '3', '45604', '45', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '189', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('19000004', '', '14', '45604', '0', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '190', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('19000005', '', '3', '45604', '45', '32670', '32861', '0', '0', '32593', '32785', '32750', '32942', '0', '0', '0', '190', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('20000005', '', '14', '45622', '0', '32784', '32806', '0', '0', '32576', '32768', '32831', '33023', '0', '0', '0', '200', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('20000006', '', '3', '45622', '47', '32784', '32806', '0', '0', '32576', '32768', '32831', '33023', '0', '0', '0', '200', '0', '0', '0', '1');
INSERT INTO `spawnlist` VALUES ('46000001', '', '15', '45465', '0', '32792', '32866', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '460', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46000002', '', '15', '45474', '0', '32792', '32866', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '460', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46000003', '', '15', '45846', '0', '32792', '32866', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '460', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46000004', '', '1', '45412', '0', '32807', '32852', '0', '0', '0', '0', '0', '0', '0', '0', '0', '460', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46100001', '', '15', '45459', '0', '32658', '32862', '0', '0', '32640', '32768', '32895', '32895', '0', '0', '0', '461', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46100002', '', '15', '45460', '0', '32658', '32862', '0', '0', '32640', '32768', '32895', '32895', '0', '0', '0', '461', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46100003', '', '15', '45462', '0', '32658', '32862', '0', '0', '32640', '32768', '32895', '32895', '0', '0', '0', '461', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46100004', '', '15', '45461', '0', '32658', '32862', '0', '0', '32640', '32768', '32895', '32895', '0', '0', '0', '461', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46100005', '', '15', '45846', '0', '32658', '32862', '0', '0', '32640', '32768', '32895', '32895', '0', '0', '0', '461', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46100006', '', '15', '45848', '0', '32658', '32862', '0', '0', '32640', '32768', '32895', '32895', '0', '0', '0', '461', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46100007', '', '1', '45412', '0', '32685', '32860', '0', '0', '0', '0', '0', '0', '0', '0', '0', '461', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46100008', '', '1', '45412', '0', '32684', '32801', '0', '0', '0', '0', '0', '0', '0', '0', '0', '461', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46100009', '', '1', '45412', '0', '32748', '32857', '0', '0', '0', '0', '0', '0', '0', '0', '0', '461', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46100010', '', '1', '45412', '0', '32743', '32805', '0', '0', '0', '0', '0', '0', '0', '0', '0', '461', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46200001', '', '10', '45851', '0', '32682', '32833', '0', '0', '32640', '32768', '32831', '32895', '0', '0', '0', '462', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46200002', '', '10', '45846', '0', '32682', '32833', '0', '0', '32640', '32768', '32831', '32895', '0', '0', '0', '462', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46200003', '', '10', '45848', '0', '32682', '32833', '0', '0', '32640', '32768', '32831', '32895', '0', '0', '0', '462', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46200004', '', '10', '45852', '0', '32682', '32833', '0', '0', '32640', '32768', '32831', '32895', '0', '0', '0', '462', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46300001', '', '15', '45845', '0', '32726', '32821', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '463', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46300002', '', '15', '45846', '0', '32726', '32821', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '463', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46300003', '', '15', '45858', '0', '32726', '32821', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '463', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46300004', '', '1', '45412', '0', '32730', '32854', '0', '0', '0', '0', '0', '0', '0', '0', '0', '463', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46300005', '', '1', '45412', '0', '32779', '32815', '0', '0', '0', '0', '0', '0', '0', '0', '0', '463', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46400001', '', '10', '45459', '0', '32725', '32818', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '464', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46400002', '', '10', '45460', '0', '32725', '32818', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '464', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46400003', '', '10', '45462', '0', '32725', '32818', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '464', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46400004', '', '10', '45461', '0', '32725', '32818', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '464', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46400005', '', '10', '45465', '0', '32725', '32818', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '464', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46400006', '', '10', '45846', '0', '32725', '32818', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '464', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46400007', '', '1', '45412', '0', '32803', '32830', '0', '0', '0', '0', '0', '0', '0', '0', '0', '464', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46500001', '', '15', '45474', '0', '32721', '32818', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '465', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46500002', '', '15', '45854', '0', '32721', '32818', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '465', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46500003', '', '15', '45855', '0', '32721', '32818', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '465', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46500004', '', '15', '45857', '0', '32721', '32818', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '465', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46500005', '', '15', '45856', '0', '32721', '32818', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '465', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46500006', '', '1', '45858', '0', '32794', '32863', '0', '0', '0', '0', '0', '0', '0', '0', '0', '465', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46600001', '', '10', '45845', '0', '32722', '32847', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '466', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46600002', '', '10', '45465', '0', '32722', '32847', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '466', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46600003', '', '10', '45852', '0', '32722', '32847', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '466', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46600004', '', '10', '45850', '0', '32722', '32847', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '466', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('46600005', '', '10', '45858', '0', '32722', '32847', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '466', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47000001', '', '10', '45865', '0', '32722', '32818', '0', '0', '32704', '32768', '32895', '32895', '0', '0', '0', '470', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47000002', '', '10', '45868', '0', '32722', '32818', '0', '0', '32704', '32768', '32895', '32895', '0', '0', '0', '470', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47000003', '', '10', '45517', '0', '32722', '32818', '0', '0', '32704', '32768', '32895', '32895', '0', '0', '0', '470', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47000004', '', '1', '45412', '0', '32747', '32839', '0', '0', '0', '0', '0', '0', '0', '0', '0', '470', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47000005', '', '1', '45412', '0', '32864', '32845', '0', '0', '0', '0', '0', '0', '0', '0', '0', '470', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47100001', '', '7', '45866', '0', '32756', '32878', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '471', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47100002', '', '7', '45867', '0', '32756', '32878', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '471', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47100003', '', '7', '45517', '0', '32756', '32878', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '471', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47100004', '', '7', '45869', '0', '32756', '32878', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '471', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47100005', '', '7', '45870', '0', '32756', '32878', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '471', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47100006', '', '1', '45412', '0', '32767', '32855', '0', '0', '0', '0', '0', '0', '0', '0', '0', '471', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47200001', '', '7', '45865', '0', '32723', '32797', '0', '0', '32704', '32768', '32831', '32831', '0', '0', '0', '472', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47200002', '', '7', '45868', '0', '32723', '32797', '0', '0', '32704', '32768', '32831', '32831', '0', '0', '0', '472', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47200003', '', '7', '45486', '0', '32723', '32797', '0', '0', '32704', '32768', '32831', '32831', '0', '0', '0', '472', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47200004', '', '7', '45872', '0', '32723', '32797', '0', '0', '32704', '32768', '32831', '32831', '0', '0', '0', '472', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47200005', '', '1', '45412', '0', '32744', '32806', '0', '0', '0', '0', '0', '0', '0', '0', '0', '472', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47200006', '', '1', '45412', '0', '32804', '32800', '0', '0', '0', '0', '0', '0', '0', '0', '0', '472', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47300001', '', '15', '45486', '0', '32782', '32868', '0', '0', '32704', '32768', '32959', '32895', '0', '0', '0', '473', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47300002', '', '15', '45527', '0', '32782', '32868', '0', '0', '32704', '32768', '32959', '32895', '0', '0', '0', '473', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47300003', '', '15', '45870', '0', '32782', '32868', '0', '0', '32704', '32768', '32959', '32895', '0', '0', '0', '473', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47300004', '', '15', '45871', '0', '32782', '32868', '0', '0', '32704', '32768', '32959', '32895', '0', '0', '0', '473', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47300005', '', '10', '45872', '0', '32782', '32868', '0', '0', '32704', '32768', '32959', '32895', '0', '0', '0', '473', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47300006', '', '1', '45412', '0', '32789', '32833', '0', '0', '0', '0', '0', '0', '0', '0', '0', '473', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47300007', '', '1', '45412', '0', '32783', '32803', '0', '0', '0', '0', '0', '0', '0', '0', '0', '473', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47300008', '', '1', '45412', '0', '32739', '32821', '0', '0', '0', '0', '0', '0', '0', '0', '0', '473', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47400001', '', '10', '45868', '0', '32724', '32832', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '474', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47400002', '', '10', '45517', '0', '32724', '32832', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '474', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47400003', '', '10', '45869', '0', '32724', '32832', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '474', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47400004', '', '10', '45872', '0', '32724', '32832', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '474', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47500001', '', '10', '45867', '0', '32673', '32836', '0', '0', '32640', '32768', '32831', '32895', '0', '0', '0', '475', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47500002', '', '10', '45517', '0', '32673', '32836', '0', '0', '32640', '32768', '32831', '32895', '0', '0', '0', '475', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47500003', '', '10', '45527', '0', '32673', '32836', '0', '0', '32640', '32768', '32831', '32895', '0', '0', '0', '475', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47500004', '', '10', '45523', '0', '32673', '32836', '0', '0', '32640', '32768', '32831', '32895', '0', '0', '0', '475', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47500005', '', '10', '45869', '0', '32673', '32836', '0', '0', '32640', '32768', '32831', '32895', '0', '0', '0', '475', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47500006', '', '10', '45870', '0', '32673', '32836', '0', '0', '32640', '32768', '32831', '32895', '0', '0', '0', '475', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47500007', '', '1', '45412', '0', '32701', '32849', '0', '0', '0', '0', '0', '0', '0', '0', '0', '475', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47600001', '', '10', '45868', '0', '32768', '32877', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '476', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47600002', '', '10', '45527', '0', '32768', '32877', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '476', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47600003', '', '10', '45523', '0', '32768', '32877', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '476', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47600004', '', '10', '45869', '0', '32768', '32877', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '476', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47600005', '', '1', '45412', '0', '32778', '32855', '0', '0', '0', '0', '0', '0', '0', '0', '0', '476', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47600006', '', '1', '45412', '0', '32800', '32801', '0', '0', '0', '0', '0', '0', '0', '0', '0', '476', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47700001', '', '10', '45865', '0', '32780', '32873', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '477', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47700002', '', '10', '45868', '0', '32780', '32873', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '477', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47700003', '', '10', '45486', '0', '32780', '32873', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '477', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47700004', '', '10', '45517', '0', '32780', '32873', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '477', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47700005', '', '1', '45412', '0', '32803', '32861', '0', '0', '0', '0', '0', '0', '0', '0', '0', '477', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47700006', '', '1', '45412', '0', '32777', '32806', '0', '0', '0', '0', '0', '0', '0', '0', '0', '477', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47700007', '', '1', '45412', '0', '32744', '32793', '0', '0', '0', '0', '0', '0', '0', '0', '0', '477', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47800001', '', '5', '45864', '0', '32742', '32858', '0', '0', '32704', '32768', '32767', '32895', '0', '0', '0', '478', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47800002', '', '5', '45517', '0', '32742', '32858', '0', '0', '32704', '32768', '32767', '32895', '0', '0', '0', '478', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47800003', '', '5', '45527', '0', '32742', '32858', '0', '0', '32704', '32768', '32767', '32895', '0', '0', '0', '478', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47800004', '', '5', '45523', '0', '32742', '32858', '0', '0', '32704', '32768', '32767', '32895', '0', '0', '0', '478', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47800005', '', '1', '45412', '0', '32745', '32814', '0', '0', '0', '0', '0', '0', '0', '0', '0', '478', '0', '0', '0', '0');
INSERT INTO `spawnlist` VALUES ('47800006', '', '1', '45412', '0', '32733', '32792', '0', '0', '0', '0', '0', '0', '0', '0', '0', '478', '0', '0', '0', '0');
delete from spawnlist where id between 801500101 and 801500351;
update spawnlist set group_id = 1 where id in (8335, 8336, 8337, 8338, 8339, 8340, 8341, 26553, 26554, 26555, 26556, 26557, 26558);
update spawnlist set group_id = 2 where id in (11971, 11989, 12007);
update spawnlist set group_id = 3 where id in (11981);
update spawnlist set group_id = 4 where id in (11997);
update spawnlist set group_id = 5 where id in (95, 123, 189, 205, 227, 245, 265);
update spawnlist set group_id = 6 where id in (6515, 6533, 6553, 6589, 6607);
update spawnlist set group_id = 7 where id in (9838, 9939, 9940, 9942, 9943, 9944, 9945, 9946, 62058, 62059, 100006);
update spawnlist set group_id = 8 where id in (3643, 3661, 3691, 3771, 3809, 3837, 3863);
update spawnlist set group_id = 9 where id in (9773, 9791, 9801, 9815, 9823);
update spawnlist set group_id = 10 where id in (14398, 14399, 14400, 14401);
update spawnlist set group_id = 11 where id in (3067, 3071);
update spawnlist set group_id = 12 where id in (6300008);
update spawnlist set group_id = 23 where id in (10200003, 10300003, 10400003);
update spawnlist set group_id = 24 where id in (10500004, 10700004, 10800004, 10900004, 11000004);
update spawnlist set group_id = 25 where id in (10500006, 10700006, 10800006, 10900006, 11000006);
update spawnlist set group_id = 26 where id in (10500002, 10700002, 10800002, 10900002, 11000002);
update spawnlist set group_id = 27 where id in (11100002, 11200002, 11300002, 11400002);
update spawnlist set group_id = 28 where id in (11400005, 11500005, 11700006, 11800006, 11900006, 12000006);
update spawnlist set group_id = 29 where id in (11500003, 11700004, 11800004, 11900004, 12000004);
update spawnlist set group_id = 30 where id in (11700002, 11800002, 11900002, 12000002);
update spawnlist set group_id = 31 where id in (12100004, 12200004, 12300004, 12400004, 12500002, 13000002);
update spawnlist set group_id = 32 where id in (12100002, 12200002, 12300002, 12400002);
update spawnlist set group_id = 33 where id in (12200006, 12300006, 12400006, 12500004, 12700002, 12800002, 12900002, 13000004);
update spawnlist set group_id = 34 where id in (12500006, 12700004, 12800004, 12900004, 13000006);
update spawnlist set group_id = 35 where id in (12700006, 12800006, 12900006, 13000008);
update spawnlist set group_id = 36 where id in (13200003, 13300002, 13400002);
update spawnlist set group_id = 37 where id in (13100003, 13200005, 13300004, 13400004, 13500002);
update spawnlist set group_id = 38 where id in (13400006, 13500004, 13700002, 13800002, 13900002, 14000002);
update spawnlist set group_id = 39 where id in (13500006, 13700005, 13800005, 13900005, 14000005);
update spawnlist set group_id = 40 where id in (15700004, 15800005, 15900004, 16000004);
update spawnlist set group_id = 41 where id in (16700003, 16800003, 16900002, 17000002);
update spawnlist set group_id = 41 where id in (16700005, 16800006, 16900005, 17000005);
update spawnlist set group_id = 43 where id in (17700003, 17800003, 17900002, 18000002);
update spawnlist set group_id = 44 where id in (18100002, 18200002, 18300002, 18400002, 18700002, 18800002);
update spawnlist set group_id = 45 where id in (18700006, 18800006, 18900005, 19000005);
update spawnlist set group_id = 46 where id in (18700004, 18800004, 18900003, 19000003);
update spawnlist set group_id = 47 where id in (19700004, 20000006);
update spawnlist set group_id = 48 where id in (19800004, 19900004, 20000003);


-- Market Teleporters And Market Guards
INSERT INTO `spawnlist` VALUES 
(50038, 'market teleporter', 1, 50027, 0, 32634, 32797, 0, 0, 0, 0, 0, 0, 6, 0, 0, 4, 0, 0, 0, 0),
(50039, 'market teleporter', 1, 50027, 0, 32629, 32721, 0, 0, 0, 0, 0, 0, 5, 0, 0, 4, 0, 0, 0, 0),
(50046, 'market teleporter', 1, 50026, 0, 32780, 32846, 0, 0, 0, 0, 0, 0, 4, 0, 0, 340, 0, 0, 0, 0),
(50054, 'market teleporter', 1, 50033, 0, 32703, 32840, 0, 0, 0, 0, 0, 0, 6, 0, 0, 350, 0, 0, 0, 0),
(50043, 'market teleporter', 1, 50034, 0, 33438, 32809, 0, 0, 0, 0, 0, 0, 5, 0, 0, 4, 0, 0, 0, 0),
(50044, 'market teleporter', 1, 50034, 0, 33510, 32766, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0),
(50052, 'market teleporter', 1, 50049, 0, 32735, 32790, 0, 0, 0, 0, 0, 0,5, 0, 0, 360, 0, 0, 0, 0),
(50041, 'market teleporter', 1, 50050, 0, 34061, 32305, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0),
(50042, 'market teleporter', 1, 50050, 0, 34062, 32273, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0),
(50050, 'market teleporter', 1, 50059, 0, 32735, 32790, 0, 0, 0, 0, 0, 0, 5, 0, 0, 370, 0, 0, 0, 0),
(50036, 'market teleporter', 1, 50060, 0, 33077, 33383, 0, 0, 0, 0, 0, 0, 5, 0, 0, 4, 0, 0, 0, 0),
(50037, 'market teleporter', 1, 50060, 0, 33095, 33358, 0, 0, 0, 0, 0, 0, 5, 0, 0, 4, 0, 0, 0, 0),
(50202, 'market guard', 1, 50025, 0, 32756, 32871, 0, 0, 0, 0, 0, 0, 4, 0, 0, 340, 0, 0, 0, 0),
(50203, 'market guard', 1, 50025, 0, 32761, 32871, 0, 0, 0, 0, 0, 0, 4, 0, 0, 340, 0, 0, 0, 0),
(50211, 'market guard', 1, 50032, 0, 32703, 32806, 0, 0, 0, 0, 0, 0, 4, 0, 0, 350, 0, 0, 0, 0), 
(50212, 'market guard', 1, 50032, 0, 32708, 32806, 0, 0, 0, 0, 0, 0, 4, 0, 0, 350, 0, 0, 0, 0),
(50213, 'market guard', 1, 50032, 0, 32726, 32842, 0, 0, 0, 0, 0, 0, 6, 0, 0, 350, 0, 0, 0, 0),
(50214, 'market guard', 1, 50032, 0, 32671, 32852, 0, 0, 0, 0, 0, 0, 2, 0, 0, 350, 0, 0, 0, 0),
(50215, 'market guard', 1, 50032, 0, 32671, 32847, 0, 0, 0, 0, 0, 0, 2, 0, 0, 350, 0, 0, 0, 0),
(50221, 'market guard', 1, 50048, 0, 32739, 32784, 0, 0, 0, 0, 0, 0, 0, 0, 0, 360, 0, 0, 0, 0),
(50222, 'market guard', 1, 50048, 0, 32735, 32784, 0, 0, 0, 0, 0, 0, 0, 0, 0, 360, 0, 0, 0, 0),
(50223, 'market guard', 1, 50048, 0, 32738, 32815, 0, 0, 0, 0, 0, 0, 4, 0, 0, 360, 0, 0, 0, 0),
(50224, 'market guard', 1, 50048, 0, 32734, 32815, 0, 0, 0, 0, 0, 0, 4, 0, 0, 360, 0, 0, 0, 0),
(50225, 'market guard', 1, 50058, 0, 32732, 32814, 0, 0, 0, 0, 0, 0, 4, 0, 0, 370, 0, 0, 0, 0), 
(50226, 'market guard', 1, 50058, 0, 32735, 32814, 0, 0, 0, 0, 0, 0, 4, 0, 0, 370, 0, 0, 0, 0),
(50227, 'market guard', 1, 50058, 0, 32740, 32784, 0, 0, 0, 0, 0, 0, 0, 0, 0, 370, 0, 0, 0, 0), 
(50228, 'market guard', 1, 50058, 0, 32737, 32784, 0, 0, 0, 0, 0, 0, 0, 0, 0, 370, 0, 0, 0, 0);



-- update 31

DELETE FROM `spawnlist` WHERE mapid = "43"; 
DELETE FROM `spawnlist` WHERE mapid = "44"; 
DELETE FROM `spawnlist` WHERE mapid = "45"; 
DELETE FROM `spawnlist` WHERE mapid = "46"; 
DELETE FROM `spawnlist` WHERE mapid = "47"; 
DELETE FROM `spawnlist` WHERE mapid = "48"; 
DELETE FROM `spawnlist` WHERE mapid = "49"; 
DELETE FROM `spawnlist` WHERE mapid = "50"; 
DELETE FROM `spawnlist` WHERE mapid = "51"; 

INSERT INTO `spawnlist` VALUES 
('801500114', 'ant', '35', '45945', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '45', '0', '0', '0', '0'),
('801500115', 'ant', '35', '45945', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '46', '0', '0', '0', '0'), 
('801500113', 'ant', '35', '45945', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '44', '0', '0', '0', '0'), 
('801500112', 'ant', '30', '45945', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '43', '0', '0', '0', '0'), 
('801500116', 'ant', '35', '45945', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '47', '0', '0', '0', '0'), 
('801500117', 'ant', '35', '45945', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '48', '0', '0', '0', '0'), 
('801500118', 'ant', '25', '45946', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('801500119', 'Giant ant', '15', '45947', '0', '32800', '32800', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'),
('801500120', 'Giant ant', '25', '45948', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('801500121', 'Giant ant', '15', '45950', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('801500122', 'Giant ant', '20', '45949', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('801500123', 'Giant ant', '10', '45951', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('801500124', 'Giant ant', '25', '45946', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('801500125', 'Giant ant', '15', '45947', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('801500126', 'Giant ant', '25', '45948', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('801500127', 'Giant ant', '15', '45949', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('801500128', 'Giant ant', '10', '45950', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('801500129', 'Giant ant', '10', '45951', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('801500130', 'Giant ant', '25', '45948', '0', '32764', '32828', '0', '0', '32640', '32704', '32831', '32895', '5', '0', '0', '51', '0', '0', '0', '0'), 
('801500131', 'Giant ant', '15', '45949', '0', '32764', '32828', '0', '0', '32640', '32704', '32831', '32895', '5', '0', '0', '51', '0', '0', '0', '0'), 
('801500132', 'Giant ant', '15', '45950', '0', '32764', '32828', '0', '0', '32640', '32704', '32831', '32895', '5', '0', '0', '51', '0', '0', '0', '0'), 
('801500133', 'ant soldier', '15', '45951', '0', '32764', '32828', '0', '0', '32640', '32704', '32831', '32895', '5', '0', '0', '51', '0', '0', '0', '0'), 
('801500134', 'ant soldier', '1', '45952', '0', '32738', '32854', '0', '0', '0', '0', '0', '0', '0', '240', '480', '541', '0', '0', '0', '0'), 
('801500135', 'ant soldier', '1', '45952', '0', '32738', '32854', '0', '0', '0', '0', '0', '0', '0', '240', '480', '542', '0', '0', '0', '0'), 
('801500136', 'ant soldier', '1', '45952', '0', '32771', '32856', '0', '0', '0', '0', '0', '0', '2', '240', '480', '543', '0', '0', '0', '0'), 
('801500137', 'ant soldier', '1', '45952', '0', '32747', '32776', '0', '0', '0', '0', '0', '0', '4', '240', '480', '543', '0', '0', '0', '0'), 
('801500138', 'ant soldier', '1', '45952', '0', '32768', '32739', '0', '0', '0', '0', '0', '0', '2', '240', '480', '543', '0', '0', '0', '0'), 
('801500139', 'ant soldier', '1', '45952', '0', '32858', '32798', '0', '0', '0', '0', '0', '0', '0', '240', '480', '543', '0', '0', '0', '0'), 
('801500140', 'ant soldier', '1', '45952', '0', '32848', '32855', '0', '0', '0', '0', '0', '0', '6', '240', '480', '543', '0', '0', '0', '0'), 
('4400001', 'Giant ant', '50', '45115', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '44', '0', '0', '0', '0'),
('4400002', 'Giant ant', '25', '45190', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '44', '0', '0', '0', '0'), 
('4500001', 'Giant ant', '50', '45115', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '45', '0', '0', '0', '0'), 
('4500002', 'Giant ant', '25', '45190', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '45', '0', '0', '0', '0'), 
('4600001', 'Giant ant', '50', '45115', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '46', '0', '0', '0', '0'), 
('4600002', 'Giant ant', '25', '45190', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '46', '0', '0', '0', '0'), 
('4700001', 'Giant ant', '50', '45115', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '47', '0', '0', '0', '0'), 
('4700002', 'Giant ant', '25', '45190', '0', '32800', '32800', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '47', '0', '0', '0', '0'), 
('4800001', 'Giant ant', '50', '45115', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '48', '0', '0', '0', '0'), 
('4800002', 'Giant ant', '25', '45190', '0', '32800', '32800', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '48', '0', '0', '0', '0'), 
('4900001', 'Giant ant', '50', '45115', '0', '32738', '32799', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('4900002', 'Giant ant', '25', '45190', '0', '32800', '32800', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '49', '0', '0', '0', '0'), 
('5000001', 'Giant ant', '50', '45115', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('5000002', 'Giant ant', '25', '45190', '0', '32740', '32802', '0', '0', '32704', '32704', '32831', '32831', '5', '0', '0', '50', '0', '0', '0', '0'), 
('5100001', 'Giant ant', '25', '45115', '0', '32764', '32828', '0', '0', '32640', '32704', '32831', '32895', '5', '0', '0', '51', '0', '0', '0', '0'), 
('5100002', 'Giant ant', '50', '45190', '0', '32764', '32828', '0', '0', '32640', '32704', '32831', '32895', '5', '0', '0', '51', '0', '0', '0', '0'); 
