-- update 0

-- replace lvl 50 ToS spawn with lvl 22
update spawnlist set npc_templateid = 45226 where mapid = 521 and npc_templateid = 45544;



-- update 3

-- half the spawn rate on DI
update spawnlist set count = count / 2 where mapid = 303;

-- half the spawn rate in de lvl 45 quest area
update spawnlist set count = count / 2 where mapid = 21;



-- update 4

-- reduce by 50% elf lvl 30 quest area spawnrate
update spawnlist set count = count / 2 where mapid = 213;



-- update 12

-- un-double the milk cow spawn count
update spawnlist set count = 1 where npc_templateid = 70984;

-- un-double the slime spawn count
update spawnlist set count = count / 2 where npc_templateid = 45060 and count > 2;

-- undouble spawn on toi 11-13, 21-23, 31-33
update spawnlist set count = count / 2 where mapid in (111, 112, 113, 121, 122, 123, 131, 132, 133) and count > 1;



-- update 13

-- half spawnrate on abyss lake
update spawnlist set count = count / 2 where count > 1 and mapid = 430;

-- remove double spawn from mage lvl 30 quest area
update spawnlist set count = 1 where mapid = 201;

-- undouble spawn count in hell
update spawnlist set count = count / 2 where mapid = 666;

-- undouble spawn count in lvl30 prince quest area
update spawnlist set count = 1 where mapid = 217;



-- update 16

-- modify TOI 4F spawn
-- decrease mutant arachnevil elder count (70 -> 30)
update spawnlist set count = 30 where npc_templateid = 45348 and mapid = 104;
-- increase medusa count (18 -> 50)
update spawnlist set count = 50 where npc_templateid = 45380 and mapid = 104;

-- modify TOI 19F spawn
-- decrease dire wolf count (90 -> 80)
update spawnlist set count = 80 where npc_templateid = 45409 and mapid = 119;

-- modify TOI 21F spawn
-- increase horrific fire egg count (15 -> 45)
update spawnlist set count = 45 where npc_templateid = 45384 and mapid = 121;
-- decrease nightmare count (45 -> 25)
update spawnlist set count = 25 where npc_templateid = 45440 and mapid = 121;

-- modify TOI 22F spawn
-- increase horrific fire egg count (20 -> 35)
update spawnlist set count = 30 where npc_templateid = 45384 and mapid = 122;
-- decrease nightmare  count (45 -> 30)
update spawnlist set count = 30 where npc_templateid = 45440 and mapid = 122;
-- increase horrific cerebus count (23 -> 30)
update spawnlist set count = 30 where npc_templateid = 45471 and mapid = 122;

-- modify TOI 23F spawn
-- increase horrific fire egg count (19 -> 30)
update spawnlist set count = 30 where npc_templateid = 45384 and mapid = 123;
-- decrease nightmare  count (50 -> 35)
update spawnlist set count = 35 where npc_templateid = 45440 and mapid = 123;
-- increase horrific cerebus count (19 -> 35)
update spawnlist set count = 35 where npc_templateid = 45471 and mapid = 123;

-- modify TOI 24F spawn
-- increase horrific fire egg count (38 -> 76)
update spawnlist set count = 76 where npc_templateid = 45384 and mapid = 124;
-- decrease nightmare  count (86 -> 45)
update spawnlist set count = 45 where npc_templateid = 45440 and mapid = 124;
-- increase horrific cerebus count (30 -> 45)
update spawnlist set count = 45 where npc_templateid = 45471 and mapid = 124;

-- modify TOI 31F spawn
-- increase raging ghoul count (13 -> 20)
update spawnlist set count = 20 where npc_templateid = 45454 and mapid = 131;

-- modify TOI 32F spawn
-- increase raging ghoul count (6 -> 20)
update spawnlist set count = 20 where npc_templateid = 45454 and mapid = 132;

-- modify TOI 33F spawn
-- increase raging ghoul count (14 -> 16)
update spawnlist set count = 16 where npc_templateid = 45454 and mapid = 133;
-- increase raging spartoi ount (7 -> 10)
update spawnlist set count = 10 where npc_templateid = 45455 and mapid = 133;

-- modify TOI 34F spawn
-- increase raging ghoul count (16 -> 20)
update spawnlist set count = 20 where npc_templateid = 45454 and mapid = 134;

-- modify giran 1f spawn
-- decrease giran imp count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45125 and mapid = 53;
-- decrease giran ghast count (60 -> 50)
update spawnlist set count = 50 where npc_templateid = 32831 and mapid = 53;
-- decrease giran imp elder count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45168 and mapid = 53;
-- decrease giran ghast lord count (40 -> 30)
update spawnlist set count = 30 where npc_templateid = 45188 and mapid = 53;

-- modify giran 2f spawn
-- decrease giran lizardman count (40 -> 32)
update spawnlist set count = 32 where npc_templateid = 45156 and mapid = 54;
-- decrease giran crabman count (40 -> 32)
update spawnlist set count = 32 where npc_templateid = 45169 and mapid = 54;
-- decrease giran vakuuk count (40 -> 32)
update spawnlist set count = 32 where npc_templateid = 45187 and mapid = 54;
-- decrease giran arachnevil elder count (40 -> 32)
update spawnlist set count = 32 where npc_templateid = 45312 and mapid = 54;

-- modify giran 3f spawn
-- decrease giran tiger count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45243 and mapid = 55;
-- decrease giran cerebus count (30 -> 28)
update spawnlist set count = 28 where npc_templateid = 45283 and mapid = 55;
-- decrease giran cimaera count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45325 and mapid = 55;

-- modify heine 1f spawn
-- decrease lizardman count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45144 and mapid = 59;
-- decrease alligator count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45307 and mapid = 59;
-- decrease vakuuk count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45116 and mapid = 59;
-- decrease ratman count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45192 and mapid = 59;
-- decrease troglodyte count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45155 and mapid = 59;

-- modify heine 4f spawn
-- decrease shark count (150 -> 120)
update spawnlist set count = 120 where npc_templateid = 45160 and mapid = 63;

-- modify dvc 1f spawn
-- decrease skeleton marksman count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45270 and mapid = 30;
-- decrease skeleton guard count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45269 and mapid = 30;
-- decrease skeleton fighter count (30 -> 24)
update spawnlist set count = 26 where npc_templateid = 45286 and mapid = 30;
-- decrease spartoi count (30 -> 24)
update spawnlist set count = 26 where npc_templateid = 45161 and mapid = 30;
-- decrease arachnevil elder count (20 -> 14)
update spawnlist set count = 14 where npc_templateid = 45184 and mapid = 30;

-- modify dvc 2f spawn
-- decrease skeleton marksman count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45270 and mapid = 31;
-- decrease skeleton guard count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45269 and mapid = 31;
-- decrease skeleton fighter count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45286 and mapid = 31;
-- decrease muryan count (20 -> 18)
update spawnlist set count = 18 where npc_templateid = 45289 and mapid = 31;
         
-- modify dvc 3f spawn
-- decrease skeleton marksman count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45270 and mapid = 32;
-- decrease skeleton guard count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45269 and mapid = 32;
-- decrease skeleton fighter count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45286 and mapid = 32;
-- decrease muryan count (20 -> 18)
update spawnlist set count = 26 where npc_templateid = 45289 and mapid = 32;
-- decrease ettin count (10 -> 8)
update spawnlist set count = 8 where npc_templateid = 45373 and mapid = 32;
         
-- modify dvc 4f spawn
-- decrease skeleton marksman count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45270 and mapid = 33;
-- decrease skeleton guard count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45269 and mapid = 33;
-- decrease skeleton fighter count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45286 and mapid = 33;
-- decrease muryan count (20 -> 18)
update spawnlist set count = 26 where npc_templateid = 45289 and mapid = 33;
-- decrease ettin count (10 -> 8)
update spawnlist set count = 8 where npc_templateid = 45373 and mapid = 33;

-- modify dvc 5f spawn
-- decrease muryan count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45289 and mapid = 35;
-- decrease ettin count (20 -> 14)
update spawnlist set count = 14 where npc_templateid = 45373 and mapid = 35;
-- decrease succubus count (20 -> 18)
update spawnlist set count = 36 where npc_templateid = 45393 and mapid = 35;
-- decrease ettin count (10 -> 8)
update spawnlist set count = 8 where npc_templateid = 45451 and mapid = 35;

-- modify dvc 6f spawn
-- decrease ettin count (40 -> 20)
update spawnlist set count = 20 where npc_templateid = 45373 and mapid = 36;
-- decrease succubus count (40 -> 36)
update spawnlist set count = 36 where npc_templateid = 45393 and mapid = 36;
-- decrease ettin count (20 -> 18)
update spawnlist set count = 18 where npc_templateid = 45451 and mapid = 36;

-- activate 0 count skeleton marksman, fighter, guard spawnpoints and remove doublespawns
update spawnlist set count = 1 where npc_templateid in (45269, 45270, 45286) and mapid = 4;
-- activate 0 count scorpion spawnpoints and remove doublespawns
update spawnlist set count = 1 where npc_templateid = 45259 and mapid = 4;



-- update 19

-- set FQ's movement distance to 0
update spawnlist_npc set movement_distance = 0 where npc_templateid = 70852;

-- change lasta 3f theif spawn to ones with drops
update spawnlist set npc_templateid = 45272 where mapid = 308 and npc_templateid in (45220);

-- reduce spawn in ancient giant ruins
update spawnlist set count = 1 where count = 2 and mapid = 400 and npc_templateid in (45498, 45530, 45537, 45603);


-- update 20

-- activate additional abyss lake spawn
update spawnlist set count = 1 where mapid = 420 and count = 0;



-- update 22

-- Update for Elven Forest Spawns
INSERT INTO spawnlist VALUES (801500397,"Elven Forest, Orc", 1, 45017, 0, 33095, 32235, 12, 12, 0, 0, 0, 0, 7, 20, 30, 4, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (801500398,"Elven Forest, Orc", 1, 45017, 0, 33114, 32253, 12, 12, 0, 0, 0, 0, 2, 20, 30, 4, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (801500399,"Elven Forest, Orc", 1, 45017, 0, 33088, 32265, 12, 12, 0, 0, 0, 0, 6, 20, 30, 4, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (801500400,"Elven Forest, Orc", 1, 45017, 0, 33104, 32283, 12, 12, 0, 0, 0, 0, 3, 20, 30, 4, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (801500401,"Elven Forest, Fungus", 2, 45029, 0, 33133, 32224, 6, 6, 0, 0, 0, 0, 0, 20, 30, 4, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (801500402,"Elven Forest, Fungus", 2, 45029, 0, 33125, 32222, 6, 6, 0, 0, 0, 0, 7, 20, 30, 4, 0, 0, 0, 0);



-- update 24

-- activate additional elemental grave spawn
-- fangs
update spawnlist set count = 1 where id in (17648, 17654, 17660, 17666, 17672, 17678, 17684, 17690, 17696, 17702, 17726, 17732);
-- masters
update spawnlist set count = 1 where id in (20126, 20712, 20742, 20750);
-- undead
update spawnlist set count = 1 where id in (20132, 20138, 20144, 20150, 20156, 20162, 20168, 23442);



-- update 25

-- undouble giant guardian (lvl 45 knight quest) mob
update spawnlist set count = 1 where npc_templateid = 45302;
  
-- decrease spawn in TI 1F
-- zombie (80 -> 75)
update spawnlist set count = 75 where npc_templateid =  45065 and mapid = 1;
-- ghoul (80 -> 65)
update spawnlist set count = 65 where npc_templateid =  45157 and mapid = 1;
-- skeleton (160 -> 140)
update spawnlist set count = 140 where npc_templateid =  45107 and mapid = 1;
-- ghoul (40 -> 35)
update spawnlist set count = 35 where npc_templateid =  45068 and mapid = 1;
-- Betrayer's Skeleton Guardsman (10 -> 8)
update spawnlist set count = 8 where npc_templateid =  45100 and mapid = 1;
-- elder (20 -> 15)
update spawnlist set count = 15 where npc_templateid =  45215 and mapid = 1;

-- update spawnlist location 
update spawnlist sl set sl.location = (select n.name from npc n where n.npcid = sl.npc_templateid);