-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here. This allows them 
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 38

# restore crystal caverns
# jp took it out (I think) because crystal caverns is getting a major 
# overhaul soon. We can just leave it as is until that is complete

INSERT INTO dungeon VALUES (32178, 32182, 4, 32746, 32787, 72, 4, " -> CrystalCave 1F  B");
INSERT INTO dungeon VALUES (34177, 32182, 4, 32746, 32787, 72, 4, " ->CrystalCave1F");
INSERT INTO dungeon VALUES (34214, 32248, 4, 32814, 32804, 72, 6, " ->CrystalCave1F");
INSERT INTO dungeon VALUES (34214, 32249, 4, 32814, 32804, 72, 6, " ->CrystalCave1F");
INSERT INTO dungeon VALUES (32726, 32861, 72, 32755, 32870, 73, 6, "CrystalCave1F->CrystalCave2F");
INSERT INTO dungeon VALUES (32726, 32862, 72, 32755, 32870, 73, 6, "CrystalCave1F->CrystalCave2F");
INSERT INTO dungeon VALUES (33969, 32337, 4, 32726, 32845, 73, 2, "OrenGlacialLake->CrystalCave 2F");
INSERT INTO dungeon VALUES (33969, 32338, 4, 32726, 32845, 73, 2, "OrenGlacialLake->CrystalCave 2F");
INSERT INTO dungeon VALUES (32756, 32870, 73, 32727, 32861, 72, 2, "CrystalCave2F->CrystalCave1F");
INSERT INTO dungeon VALUES (32756, 32871, 73, 32727, 32861, 72, 2, "CrystalCave2F->CrystalCave1F");
INSERT INTO dungeon VALUES (32797, 32808, 73, 32732, 32854, 74, 4, "CrystalCave2F->CrystalCave3F");
INSERT INTO dungeon VALUES (32797, 32809, 73, 32732, 32854, 74, 4, "CrystalCave2F->CrystalCave3F");
INSERT INTO dungeon VALUES (32731, 32853, 74, 32798, 32808, 73, 2, "CrystalCave3F->CrystalCave2F");
INSERT INTO dungeon VALUES (32732, 32853, 74, 32798, 32808, 73, 2, "CrystalCave3F->CrystalCave2F");

delete from spawnlist where id > 7200000 AND id < 7300007;                 
delete from spawnlist where id > 7400000 AND id < 7400007;

INSERT INTO spawnlist VALUES (7200001, 'Fungus', 10, 45029, 0, 32746, 32787, 0, 0, 32704, 32768, 32831, 32895, 5, 0, 0, 72, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7200002, 'Ice Golem', 30, 45182, 0, 32746, 32787, 0, 0, 32704, 32768, 32831, 32895, 5, 0, 0, 72, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7200003, 'Snowman', 10, 45133, 0, 32746, 32787, 0, 0, 32704, 32768, 32831, 32895, 5, 0, 0, 72, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7200004, 'Ice Man', 30, 45207, 0, 32746, 32787, 0, 0, 32704, 32768, 32831, 32895, 5, 0, 0, 72, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7200005, 'Snow Tiger', 20, 45267, 0, 32746, 32787, 0, 0, 32704, 32768, 32831, 32895, 5, 0, 0, 72, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7200006, 'Yeti', 20, 45294, 0, 32746, 32787, 0, 0, 32704, 32768, 32831, 32895, 5, 0, 0, 72, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7200007, 'Iron Golem', 10, 45372, 0, 32746, 32787, 0, 0, 32704, 32768, 32831, 32895, 5, 0, 0, 72, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7300001, 'Fungus', 10, 45029, 0, 32755, 32871, 0, 0, 32704, 32768, 32831, 32895, 5, 0, 0, 73, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7300002, 'Ice Golem', 30, 45182, 0, 32755, 32871, 0, 0, 32704, 32768, 32831, 32895, 5, 0, 0, 73, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7300003, 'Ice Man', 30, 45207, 0, 32755, 32871, 0, 0, 32704, 32768, 32831, 32895, 5, 0, 0, 73, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7300004, 'Snow Tiger', 20, 45267, 0, 32755, 32871, 0, 0, 32704, 32768, 32831, 32895, 5, 0, 0, 73, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7300005, 'Yeti', 20, 45294, 0, 32755, 32871, 0, 0, 32704, 32768, 32831, 32895, 5, 0, 0, 73, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7300006, 'Iron Golem', 10, 45372, 0, 32755, 32871, 0, 0, 32704, 32768, 32831, 32895, 5, 0, 0, 73, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7400001, 'Ice Golem', 20, 45182, 0, 32731, 32854, 0, 0, 32704, 32832, 32831, 32959, 5, 0, 0, 74, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7400002, 'Ice Man', 20, 45207, 0, 32731, 32854, 0, 0, 32704, 32832, 32831, 32959, 5, 0, 0, 74, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7400003, 'Snow Tiger', 20, 45267, 0, 32731, 32854, 0, 0, 32704, 32832, 32831, 32959, 5, 0, 0, 74, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7400004, 'Yeti', 20, 45294, 0, 32731, 32854, 0, 0, 32704, 32832, 32831, 32959, 5, 0, 0, 74, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7400005, 'Iron Golem', 10, 45372, 0, 32731, 32854, 0, 0, 32704, 32832, 32831, 32959, 5, 0, 0, 74, 0, 0, 0, 0);
INSERT INTO spawnlist VALUES (7400006, 'Maid of the Ice Queen', 2, 45102, 0, 32767, 32900, 0, 0, 32763, 32886, 32783, 32910, 5, 60, 120, 74, 1, 0, 0, 0);

# fix red knight set bonuses
INSERT INTO armor_set VALUES (55, 'Red Knight Set', '20230,20027', -1, -2, 10, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0);

