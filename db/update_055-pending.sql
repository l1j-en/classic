
-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here. This allows them 
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 55

-- Fix some broken wand drops.
update droplist set max = 1 where itemId in (40006, 40007, 40008);

-- Reduce Fire Necromancer melee damage.
update mobskill set leverage = 50 where mobid = 45480 and actno = 1;

-- Reduce certain spawns in DI.
update spawnlist set count = 30 where id in (61004, 61000);
update spawnlist set count = 15 where id in (61041, 61042, 61043, 61044);

-- Detach DI boss spawns from being in a group.
update spawnlist_boss set count = 1 where id in (50, 51, 52, 53);
insert into spawnlist_boss values(200, 'Great Spirit of Earth', 'Caspa', 1, 45642, 0, 32727, 32749, 0, 0, 32685, 32701, 32770, 32798, 4, 303, 1, 0, 0, 0, 100);
insert into spawnlist_boss values(201, 'Great Spirit of Earth', 'Caspa', 1, 45642, 0, 32727, 32749, 0, 0, 32685, 32701, 32770, 32798, 4, 303, 1, 0, 0, 0, 100);
insert into spawnlist_boss values(202, 'Great Spirit of Water', 'Caspa', 1, 45643, 0, 32762, 32616, 0, 0, 32717, 32593, 32808, 32640, 4, 303, 1, 0, 0, 0, 100);
insert into spawnlist_boss values(203, 'Great Spirit of Water', 'Caspa', 1, 45643, 0, 32762, 32616, 0, 0, 32717, 32593, 32808, 32640, 4, 303, 1, 0, 0, 0, 100);
insert into spawnlist_boss values(204, 'Great Spirit of Fire', 'Caspa', 1, 45645, 0, 32833, 32778, 0, 0, 32798, 32738, 32869, 32818, 4, 303, 1, 0, 0, 0, 100);
insert into spawnlist_boss values(205, 'Great Spirit of Fire', 'Caspa', 1, 45645, 0, 32833, 32778, 0, 0, 32798, 32738, 32869, 32818, 4, 303, 1, 0, 0, 0, 100);

-- Reduce dancing sword spawnrate.
update spawnlist set count = count / 2 where npc_templateid = 45386;

-- Redo spawnrate on TOI 30F.
update spawnlist set count = 50 where npc_templateid = 45440 and mapid = 130;
update spawnlist set count = 50 where npc_templateid = 45471 and mapid = 130;
update spawnlist set count = 50 where npc_templateid = 45481 and mapid = 130;
update spawnlist set count = 35 where npc_templateid = 45515 and mapid = 130;
update spawnlist set count = 5 where id in (13000005, 13000006,  13000007, 13000008);

-- Tweaking spawnlist in MLC 3F.
update spawnlist set count = 15 where id = 900007;
update spawnlist set count = 30 where id = 900008;
update spawnlist set count = 35 where id = 900009;
update spawnlist set count = 15 where id = 900003;
-- MLC 4F.
update spawnlist set count = 10 where id = 1000002;
update spawnlist set count = 10 where id = 1000008;
update spawnlist set count = 15 where id = 1000009;
update spawnlist set count = 35 where id = 1000010;
update spawnlist set count = 20 where id = 1000011;
-- MLC 5F.
update spawnlist set count = 20 where id = 1100003;
update spawnlist set count = 20 where id = 1100004;
update spawnlist set count = 15 where id = 1100005;
update spawnlist set count = 15 where id = 1100006;
update spawnlist set count = 35 where id = 1100009;
update spawnlist set count = 28 where id = 1100010;
-- MLC 6F.
update spawnlist set count = 5 where id = 1200005;
update spawnlist set count = 15 where id = 1200006;
update spawnlist set count = 15 where id = 1200009;

-- Recreate a more accurate Orc Fields spawn.
INSERT INTO `spawnlist` VALUES ('801500422', 'Gandi Orc', '20', '45098', '0', '32790', '32359', '0', '0', '32703', '32346', '32831', '32364', '1', '60', '120', '4', '0', '100', '0', '0');
INSERT INTO `spawnlist` VALUES ('801500423', 'Orc Wizard', '10', '45121', '0', '32790', '32359', '0', '0', '32703', '32346', '32831', '32364', '1', '60', '120', '4', '0', '100', '0', '0');
INSERT INTO `spawnlist` VALUES ('801500424', 'Rova Orc', '20', '45127', '0', '32790', '32359', '0', '0', '32703', '32346', '32831', '32364', '1', '60', '120', '4', '0', '100', '0', '0');
INSERT INTO `spawnlist` VALUES ('801500425', 'Duda-Mara Orc', '20', '45143', '0', '32790', '32359', '0', '0', '32703', '32346', '32831', '32364', '1', '60', '120', '4', '0', '100', '0', '0');
INSERT INTO `spawnlist` VALUES ('801500426', 'Atuba Orc', '20', '45149', '0', '32790', '32359', '0', '0', '32703', '32346', '32831', '32364', '1', '60', '120', '4', '0', '100', '0', '0');
INSERT INTO `spawnlist` VALUES ('801500427', 'Neruga Orc', '20', '45171', '0', '32790', '32359', '0', '0', '32703', '32346', '32831', '32364', '1', '60', '120', '4', '0', '100', '0', '0');
