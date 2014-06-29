-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

update armor set name = 'Boots of Dread King' where item_id = 20200;

-- Rebalance DI boss elixir droprates.
update droplist set chance = 200 where mobid in (45640, 45642, 45643, 45644, 45645) and itemid in (40033, 40034, 40035, 40036, 40037, 40038);

-- Remove all freely acquired elven mats from shops.
delete from shop where item_id in (40519, 40502, 40503, 40504, 40505, 40506, 40507, 40515, 40520, 40521) and purchasing_price = 1;

-- This might not be the right template id, but it was using ribians and that was def not right
update spawnlist_npc set npc_templateid = 71035 where id = 90066;

-- Make the right ribian spawn
update spawnlist_npc set count=1 where id = 50031;

-- give killglance ring some stats
UPDATE armor SET add_hp = 20, add_mp = 10, add_hpr = 5, add_mpr = 2, hit_modifier = 1, grade = 1 WHERE item_id = 30009;

-- remove extra Caspa spawn
DELETE FROM spawnlist_boss WHERE npc_id = 45488 AND mapid = 10;

-- remove extra DK spawn
DELETE FROM spawnlist_boss WHERE npc_id = 45601 AND mapid = 12;

-- add shark eggs to shark in deep sea
INSERT INTO droplist VALUES(55800001,'Shark',49040,'Shark Eggs',1,1,30000);

-- add shark eggs to Eva Shark - note: These are not currently spawning
INSERT INTO droplist VALUES(45933,'Shark',49040,'Shark Eggs',1,1,30000);

-- add shark eggs to sharks in kingdom of eva mapid 63
INSERT INTO droplist VALUES(45160,'Shark',49040,'Shark Eggs',1,1,30000);
 
-- add shark eggs to sharks in kingdrom of eva mapid 253
INSERT INTO droplist VALUES(45816,'Shark',49040,'Shark Eggs',1,1,30000);

-- add alligator meat drops
INSERT INTO `droplist` VALUES (45026, 'Mutated Alligator',49041,'Alligator Meat', 1, 1, 30000);
INSERT INTO `droplist` VALUES (45101, 'Alligator',49041, 'Alligator Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45196, 'Alligator',49041, 'Alligator Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45338, 'Crocodile',49041, 'Alligator Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45469, 'Crocodile',49041, 'Alligator Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45814, 'Mutated Alligator',49041, 'Alligator Meat',1, 1, 30000);

-- add turtle dragon egg drops
INSERT INTO `droplist` VALUES (45240, 'Turtle Dragon',49042, 'Turtle Dragon Egg',1, 1, 30000);
INSERT INTO `droplist` VALUES (45422, 'Subterranean Great King Turtle', 49042, 'Turtle Dragon Egg',1, 1, 30000);
INSERT INTO `droplist` VALUES (45822, 'Turtle Dragon',49042, 'Turtle Dragon Egg',1, 1, 30000);
INSERT INTO `droplist` VALUES (45937, 'Eva Turtle Dragon', 49042, 'Turtle Dragon Egg', 1, 1, 30000);

-- add Kiwi Parrot Meat
INSERT INTO `droplist` VALUES (45249, 'Kiwi Parrot',49043, 'Kiwi Parrot Meat',1, 1, 30000);

-- add Scorpion Meat
INSERT INTO `droplist` VALUES (45259, 'Scorpion',49044, 'Scorpion Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45260, 'Scorpaitan',49044, 'Scorpion Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45277, 'Scormystic',49044, 'Scorpion Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45382, 'Subterranean Scormystic',49044, 'Scorpion Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45383, 'Subterranean Scorpaitan',49044, 'Scorpion Meat',1, 1, 30000);

-- add Elakkadom Meat
INSERT INTO `droplist` VALUES (45487, 'Subterranean Elakkadom',49045, 'Elakkadom Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45819, 'Elakkadom',49045, 'Elakkadom Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45938, 'Eva Elekkadom',49045, 'Elakkadom Meat',1, 1, 30000);

-- add spider leg meat
INSERT INTO `droplist` VALUES (45038, 'Valley Arachnevil',49046, 'Spider Leg Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45059, 'Giant Spider',49046, 'Spider Leg Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45070, 'Giant Tarantula',49046, 'Spider Leg Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45136, 'Arachnevil',49046, 'Spider Leg Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45184, 'Arachnevil Elder',49046, 'Spider Leg Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45289, 'Muryan',49046, 'Spider Leg Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45308, 'Muryan Large',49046, 'Spider Leg Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45312, 'Giant Arachnevil Elder',49046, 'Spider Leg Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45348, 'Mutant Arachnevil Elder',49046, 'Spider Leg Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45358, 'Arachnevil',49046, 'Spider Leg Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45401, 'Arachnevil Elder',49046, 'Spider Leg Meat',1, 1, 30000);

-- add crab meat
INSERT INTO `droplist` VALUES (45075, 'Underground Crabman',49047, 'Crab Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45169, 'Giran Crabman',49047, 'Crab Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45297, 'Subterranean Crabman',49047, 'Crab Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45806, 'Crabman',49047, 'Crab Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45811, 'Mutant Crabman',49047, 'Crab Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45927, 'Eva Crabman',49047, 'Crab Meat',1, 1, 30000);

-- add claw of crustacean

INSERT INTO `droplist` VALUES (45733, 'Grave Crustacean',49260, 'Claw of Crustacean',1, 1, 30000);
INSERT INTO `droplist` VALUES (45823, 'Crustacean',49260, 'Claw of Crustacean',1, 1, 30000);
INSERT INTO `droplist` VALUES (45939, 'Eva Crustacean',49260, 'Claw of Crustacean',1, 1, 30000);

-- add griffon meat
INSERT INTO `droplist` VALUES (45090, 'Valley Griffon',49261,'Griffon Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45321, 'Griffon',49261,'Griffon Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45445, 'Griffon',49261,'Griffon Meat',1, 1, 30000);

-- add cockatrice tail
INSERT INTO `droplist` VALUES (45095, 'Island Cockatrice',49262, 'Cockatrice Tail',1, 1, 30000);
INSERT INTO `droplist` VALUES (45361, 'Cockatrice',49262, 'Cockatrice Tail',1, 1, 30000);
INSERT INTO `droplist` VALUES (45362, 'Cockatrice',49262, 'Cockatrice Tail',1, 1, 30000);
INSERT INTO `droplist` VALUES (81173, 'Cockatrice',49262, 'Cockatrice Tail',1, 1, 30000);

-- add great king turtle meat
INSERT INTO `droplist` VALUES (45422, 'Subterranean Great King Turtle',49263, 'Great King Turtle Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45822, 'Turtle Dragon',49263, 'Great King Turtle Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45937, 'Eva Turtle Dragon',49263, 'Great King Turtle Meat',1, 1, 30000);

-- add lesser dragon wing
INSERT INTO `droplist` VALUES (45496, 'Lesser Dragon',49264, 'Lesser Dragon Wing',1, 1, 30000);

-- add drake meat
INSERT INTO `droplist` VALUES (45111, 'Island Drake',49265, 'Drake Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45529, 'Drake',49265, 'Drake Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45578, 'Drake',49265, 'Drake Meat',1, 1, 30000);

-- add deep sea fish meat
INSERT INTO `droplist` VALUES (45728, 'Deep Sea Fish',49266, 'Deep Sea Fish Meat',1, 1, 30000);
INSERT INTO `droplist` VALUES (45729, 'Hidden Deep Sea Fish',49266, 'Deep Sea Fish Meat',1, 1, 30000);

-- add basilisk egg
INSERT INTO `droplist` VALUES (45091, 'Valley Basilisk',49267, 'Basilisk Egg',1, 1, 30000);
INSERT INTO `droplist` VALUES (45381, 'Basilisk',49267, 'Basilisk Egg',1, 1, 30000);
INSERT INTO `droplist` VALUES (45531, 'Basilisk',49267, 'Basilisk Egg',1, 1, 30000);

