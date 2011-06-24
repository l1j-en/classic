-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 58

-- Added pig and hen groups.
insert into mobgroup values (75, 'Hen(5)', 0, 70981, 70981, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
insert into mobgroup values (76, 'Pig(5)', 0, 70983, 70983, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- Change pigs and hens stats to be similar to ducks and milk cows.
update npc set impl = 'L1Monster', lvl = 2, hp = 10, mp = 0, ac = 10, str = 5, con = 12, dex = 12, wis = 1, intel = 0, mr = 0, exp = 5, lawful = 25, size = 'small', ranged = 1, passispeed = 1280, isErase = 1, light_size = 0, amount_fixed = 1 where npcid in (70981, 70983);

-- Spawn pig and hen groups in SKT, Kent, WW, OT, Werldern (hens only), Oren, Giran.
insert into spawnlist values (801500428, 'Pig Group, SKT', 1, 70983, 76, 33099, 33394, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500429, 'Hen Group, SKT', 1, 70981, 75, 33069, 33390, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500430, 'Pig Group, Kent', 1, 70983, 76, 33059, 32745, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500431, 'Hen Group, Kent', 1, 70981, 75, 33047, 32781, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500432, 'Pig Group, Giran', 1, 70983, 76, 33404, 32778, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500433, 'Hen Group, Giran', 1, 70981, 75, 33445, 32810, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500434, 'Hen Group, Werldern', 1, 70981, 75, 33701, 32492, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500435, 'Pig Group, Oren', 1, 70983, 76, 34045, 32264, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500436, 'Hen Group, Oren', 1, 70981, 75, 34071, 32279, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500437, 'Pig Group, Windawood', 1, 70983, 76, 32626, 33206, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500438, 'Hen Group, Windawood', 1, 70981, 75, 32604, 33184, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500439, 'Pig Group, Orc Town', 1, 70983, 76, 32735, 32438, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500440, 'Hen Group, Orc Town', 1, 70981, 75, 32755, 32465, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500441, 'Pig Group, TI', 1, 70983, 76, 32583, 32955, 10, 10, 0, 0, 0, 0, 0, 120, 180, 1, 0, 100, 0, 0);
insert into spawnlist values (801500442, 'Hen Group, TI', 1, 70981, 75, 32579, 32927, 10, 10, 0, 0, 0, 0, 0, 120, 180, 1, 0, 100, 0, 0);
insert into spawnlist values (801500443, 'Pig Group, Gludin', 1, 70983, 76, 32620, 32741, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500444, 'Hen Group, Gludin', 1, 70981, 75, 32607, 32794, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
