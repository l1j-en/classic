-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

update armor set name = 'Boots of Dread King' where item_id = 20200;

-- Rebalance DI boss elixir droprates.
update droplist set chance = 200 where mobid in (45640, 45642, 45643, 45644, 45645) and itemid in (40033, 40034, 40035, 40036, 40037, 40038);

-- Remove all freely acquired elven mats from shops.
delete from shop where item_id in (40519, 40502, 40503, 40504, 40505, 40506, 40507, 40515, 40520, 40521) and purchasing_price = 1;

-- This might not be the right template id, but it was using Ribian's and that was definitely not right.
update spawnlist_npc set npc_templateid = 71035 where id = 90066;

-- Make the right Ribian spawn.
update spawnlist_npc set count=1 where id = 50031;

-- Give killglance ring some stats.
update armor set add_hp = 20, add_mp = 10, add_hpr = 5, add_mpr = 2, hit_modifier = 1, grade = 1 where item_id = 30009;

-- Remove extra Caspa spawn.
delete from spawnlist_boss where npc_id = 45488 and mapid = 10;

-- Remove extra DK spawn.
delete from spawnlist_boss where npc_id = 45601 and mapid = 12;

-- Add shark eggs to shark in deep sea.
insert into droplist values (55800001,'Shark',49040,'Shark Eggs',1,1,30000);

-- Add shark eggs to Eva Shark - note: These are not currently spawning
insert into droplist values (45933,'Shark',49040,'Shark Eggs',1,1,30000);

-- Add shark eggs to sharks in Kingdom of Eva, mapid 63.
insert into droplist values (45160,'Shark',49040,'Shark Eggs',1,1,30000);
 
-- Add shark eggs to sharks in Kingdom of Eva, mapid 253.
insert INTO droplist values (45816,'Shark',49040,'Shark Eggs',1,1,30000);

-- Add alligator meat drops.
insert into droplist values (45026, 'Mutated Alligator',49041,'Alligator Meat', 1, 1, 30000);
insert into droplist values (45101, 'Alligator',49041, 'Alligator Meat',1, 1, 30000);
insert into droplist values (45196, 'Alligator',49041, 'Alligator Meat',1, 1, 30000);
insert into droplist values (45338, 'Crocodile',49041, 'Alligator Meat',1, 1, 30000);
insert into droplist values (45469, 'Crocodile',49041, 'Alligator Meat',1, 1, 30000);
insert into droplist values (45814, 'Mutated Alligator',49041, 'Alligator Meat',1, 1, 30000);

-- Add turtle dragon egg drops.
insert into droplist values (45240, 'Turtle Dragon',49042, 'Turtle Dragon Egg',1, 1, 30000);
insert into droplist values (45422, 'Subterranean Great King Turtle', 49042, 'Turtle Dragon Egg',1, 1, 30000);
insert into droplist values (45822, 'Turtle Dragon',49042, 'Turtle Dragon Egg',1, 1, 30000);
insert into droplist values (45937, 'Eva Turtle Dragon', 49042, 'Turtle Dragon Egg', 1, 1, 30000);

-- Add Kiwi Parrot Meat.
insert into droplist values (45249, 'Kiwi Parrot',49043, 'Kiwi Parrot Meat',1, 1, 30000);

-- Add Scorpion Meat.
insert into droplist values (45259, 'Scorpion',49044, 'Scorpion Meat',1, 1, 30000);
insert into droplist values (45260, 'Scorpaitan',49044, 'Scorpion Meat',1, 1, 30000);
insert into droplist values (45277, 'Scormystic',49044, 'Scorpion Meat',1, 1, 30000);
insert into droplist values (45382, 'Subterranean Scormystic',49044, 'Scorpion Meat',1, 1, 30000);
insert into droplist values (45383, 'Subterranean Scorpaitan',49044, 'Scorpion Meat',1, 1, 30000);

-- Add Elakkadom Meat.
insert into droplist values (45487, 'Subterranean Elakkadom',49045, 'Elakkadom Meat',1, 1, 30000);
insert into droplist values (45819, 'Elakkadom',49045, 'Elakkadom Meat',1, 1, 30000);
insert into droplist values (45938, 'Eva Elekkadom',49045, 'Elakkadom Meat',1, 1, 30000);

-- Add spider leg meat.
insert into droplist values (45038, 'Valley Arachnevil',49046, 'Spider Leg Meat',1, 1, 30000);
insert into droplist values (45059, 'Giant Spider',49046, 'Spider Leg Meat',1, 1, 30000);
insert into droplist values (45070, 'Giant Tarantula',49046, 'Spider Leg Meat',1, 1, 30000);
insert into droplist values (45136, 'Arachnevil',49046, 'Spider Leg Meat',1, 1, 30000);
insert into droplist values (45184, 'Arachnevil Elder',49046, 'Spider Leg Meat',1, 1, 30000);
insert into droplist values (45289, 'Muryan',49046, 'Spider Leg Meat',1, 1, 30000);
insert into droplist values (45308, 'Muryan Large',49046, 'Spider Leg Meat',1, 1, 30000);
insert into droplist values (45312, 'Giant Arachnevil Elder',49046, 'Spider Leg Meat',1, 1, 30000);
insert into droplist values (45348, 'Mutant Arachnevil Elder',49046, 'Spider Leg Meat',1, 1, 30000);
insert into droplist values (45358, 'Arachnevil',49046, 'Spider Leg Meat',1, 1, 30000);
insert into droplist values (45401, 'Arachnevil Elder',49046, 'Spider Leg Meat',1, 1, 30000);

-- Add crab meat.
insert into droplist values (45075, 'Underground Crabman',49047, 'Crab Meat',1, 1, 30000);
insert into droplist values (45169, 'Giran Crabman',49047, 'Crab Meat',1, 1, 30000);
insert into droplist values (45297, 'Subterranean Crabman',49047, 'Crab Meat',1, 1, 30000);
insert into droplist values (45806, 'Crabman',49047, 'Crab Meat',1, 1, 30000);
insert into droplist values (45811, 'Mutant Crabman',49047, 'Crab Meat',1, 1, 30000);
insert into droplist values (45927, 'Eva Crabman',49047, 'Crab Meat',1, 1, 30000);

-- Add claw of crustacean.
insert into droplist values (45733, 'Grave Crustacean',49260, 'Claw of Crustacean',1, 1, 30000);
insert into droplist values (45823, 'Crustacean',49260, 'Claw of Crustacean',1, 1, 30000);
insert into droplist values (45939, 'Eva Crustacean',49260, 'Claw of Crustacean',1, 1, 30000);

-- Add griffon meat.
insert into droplist values (45090, 'Valley Griffon',49261,'Griffon Meat',1, 1, 30000);
insert into droplist values (45321, 'Griffon',49261,'Griffon Meat',1, 1, 30000);
insert into droplist values (45445, 'Griffon',49261,'Griffon Meat',1, 1, 30000);

-- Add cockatrice tail.
insert into droplist values (45095, 'Island Cockatrice',49262, 'Cockatrice Tail',1, 1, 30000);
insert into droplist values (45361, 'Cockatrice',49262, 'Cockatrice Tail',1, 1, 30000);
insert into droplist values (45362, 'Cockatrice',49262, 'Cockatrice Tail',1, 1, 30000);
insert into droplist values (81173, 'Cockatrice',49262, 'Cockatrice Tail',1, 1, 30000);

-- Add great king turtle meat.
insert into droplist values (45422, 'Subterranean Great King Turtle',49263, 'Great King Turtle Meat',1, 1, 30000);
insert into droplist values (45822, 'Turtle Dragon',49263, 'Great King Turtle Meat',1, 1, 30000);
insert into droplist values (45937, 'Eva Turtle Dragon',49263, 'Great King Turtle Meat',1, 1, 30000);

-- Add lesser dragon wing.
insert into droplist values (45496, 'Lesser Dragon',49264, 'Lesser Dragon Wing',1, 1, 30000);

-- Add drake meat.
insert into droplist values (45111, 'Island Drake',49265, 'Drake Meat',1, 1, 30000);
insert into droplist values (45529, 'Drake',49265, 'Drake Meat',1, 1, 30000);
insert into droplist values (45578, 'Drake',49265, 'Drake Meat',1, 1, 30000);

-- Add deep sea fish meat.
insert into droplist values (45728, 'Deep Sea Fish',49266, 'Deep Sea Fish Meat',1, 1, 30000);
insert into droplist values (45729, 'Hidden Deep Sea Fish',49266, 'Deep Sea Fish Meat',1, 1, 30000);

-- Add basilisk egg.
insert into droplist values (45091, 'Valley Basilisk',49267, 'Basilisk Egg',1, 1, 30000);
insert into droplist values (45381, 'Basilisk',49267, 'Basilisk Egg',1, 1, 30000);
insert into droplist values (45531, 'Basilisk',49267, 'Basilisk Egg',1, 1, 30000);

-- Slow down rabbit walk speed.
update npc set passispeed = 2000 where npcid in (45010, 45011, 45012, 45013);

-- With Capsa group and DK spawns fixed, we can up their rare droprates.
update droplist set chance = 15000 where itemid = 20010 and mobid = 45601;
update droplist set chance = 5000 where itemid = 20077 and mobid = 45601;
update droplist set chance = 15000 where itemid = 20100 and mobid = 45601;
update droplist set chance = 3500 where itemid = 20266 and mobid = 45601;
update droplist set chance = 6500 where itemid = 20281 and mobid = 45601;
update droplist set chance = 4500 where itemid = 20284 and mobid = 45601;
update droplist set chance = 2500 where itemid = 20288 and mobid = 45601;
update droplist set chance = 15000 where itemid = 20302 and mobid = 45601;
update droplist set chance = 10000 where itemid = 40166 and mobid = 45601;
update droplist set chance = 100000 where itemid = 40052 and mobid = 45601;
update droplist set chance = 3500 where itemid = 58 and mobid = 45601;
update droplist set chance = 3500 where itemid = 76 and mobid = 45601;
update droplist set chance = 3600 where itemid = 20040 and mobid = 45601;
update droplist set chance = 1200 where itemid = 20025 and mobid = 45601;
update droplist set chance = 1200 where itemid = 20018 and mobid = 45601;
update droplist set chance = 1200 where itemid = 20029 and mobid = 45601;

-- Move Jewel Craftsman David a few cells so as not to block the direct path
-- between Oren dwarf and pot shop.
update spawnlist_npc set locx = 34059, locy = 32288, heading = 6 where npc_templateid = 80192;

-- High Wolf should have attack range of 2.
update npc set ranged = 2 where npcid = 45686;

-- Fix ori dagger and fist swing speed in DK polymorph.
update spr_action set framecount = 16 where spr_id = 6137 and act_id = 47;
update spr_action set framecount = 16 where spr_id = 6137 and act_id = 1;

-- Update Sword of Heaven to be deletable.
update weapon set cant_delete = 0 where item_id = 65;

-- Update NPC name data.
update npc set name = 'Elder Magic Doll' where npcid = 80129;
update npc set name = 'Crustacean Magic Doll' where npcid = 80130;
update npc set name = 'Stone Golem Magic Doll' where npcid = 80131;
update npc set name = 'Great Grave Guardian' where npcid = 45603;
update npc set name = 'Arcane King Hellvine' where npcid = 45676;
update npc set name = 'Arcane Troup Leader Crepus' where npcid = 45615;

-- Update missing armor name data for cloak of new king.
update armor set unidentified_name_id = '$3850' where item_id = 20067;
update armor set identified_name_id = '$3850' where item_id = 20067;

-- Update droplist name data.
update droplist set chance = 10000 where mobId = 45677 and itemId = 20176;

-- Update spawnlist names.
update spawnlist set location = 'Great Grave Guardian' where npc_templateid = 45603;

-- Update spawnlist_boss names.
update spawnlist_boss set location = 'Arcane King Hellvine' where npc_id = 45676;
update spawnlist_boss set location = 'Arcane Troup Leader Crepus' where npc_id = 45615;
update spawnlist_boss set location = 'Priest Adjutant Cassandra' where npc_id = 45963;

-- Update drops for Gloves of New King (Gloves of the Priest) (item id: 20176).
insert into droplist values
   (45986,'Guardian of Wind Spirit',20176,'Gloves of New King',1,1,5000),
   (45856,'Guardian of Wind Spirit',20176,'Gloves of New King',1,1,5000),
   (45461,'Guardian of Wind Spirit',20176,'Gloves of New King',1,1,5000),
   (45517,'Spiritologist of Blood',20176,'Gloves of New King',1,1,5000),
   (46000,'Spiritologist of Blood',20176,'Gloves of New King',1,1,5000),
   (45523,'Lord of Darkness',20176,'Gloves of New King',1,1,5000),
   (45994,'Elder Attendant',20176,'Gloves of New King',1,1,5000),
   (45995,'Elder Attendant',20176,'Gloves of New King',1,1,5000),
   (45998,'Elder Attendant',20176,'Gloves of New King',1,1,5000),
   (45999,'Elder Attendant',20176,'Gloves of New King',1,1,5000),
   (46002,'Elder Attendant',20176,'Gloves of New King',1,1,5000),
   (46003,'Elder Attendant',20176,'Gloves of New King',1,1,5000),
   (46004,'Elder Attendant',20176,'Gloves of New King',1,1,5000),
   (46007,'Elder Attendant',20176,'Gloves of New King',1,1,5000),
   (45602,'Evil Magic Squad Leader Carmiel',20176,'Gloves of New King',1,1,5000),
   (45615,'Arcane Troup Leader Crepus',20176,'Gloves of New King',1,1,10000),
   (45955,'Supreme Court Justice Keyna',20176,'Gloves of New King',1,1,10000),
   (45676,'Arcane King Hellvine',20176,'Gloves of New King',1,1,10000),
   (45962,'Supreme Court Justice Barode',20176,'Gloves of New King',1,1,10000),
   (45969,'Cursed Dark Elf Wizard',20176,'Gloves of New King',1,1,5000),
   (45971,'Cursed Dark Elf Wizard',20176,'Gloves of New King',1,1,5000);

-- Update missing drops - Source: linlib.
insert into droplist values 
   (45602,'Evil Magic Squad Leader Carmiel',20313,'Belt of Darkness',1,1,5000),
   (45602,'Evil Magic Squad Leader Carmiel',20129,'Robe of New King',1,1,5000),
   (45602,'Evil Magic Squad Leader Carmiel',20030,'Helm of New King',1,1,5000),
   (45602,'Evil Magic Squad Leader Carmiel',20067,'Cloak of New King',1,1,5000),
   (45602,'Evil Magic Squad Leader Carmiel',20208,'Boots of New King',1,1,5000),
   (45602,'Evil Magic Squad Leader Carmiel',20233,'Scroll of New King',1,1,5000),
   (45602,'Evil Magic Squad Leader Carmiel',40013,'Haste Potion',1,1,50000),
   (45602,'Evil Magic Squad Leader Carmiel',41147,'TechnicalDocument(SolidCarriage)',1,1,5000),
   (45602,'Evil Magic Squad Leader Carmiel',40675,'Mineral of Darkness',1,1,10000),
   (45602,'Evil Magic Squad Leader Carmiel',40636,'Evidence Box of Dark Spirit Army',1,1,10000),
   (45602,'Evil Magic Squad Leader Carmiel',40635,'Evidence of Dark Spirit Army',1,1,10000),
   (45602,'Evil Magic Squad Leader Carmiel',132,'Staff of New King',1,1,5000),
   (45677,'Dread Queen Laia',20067,'Cloak of New King',1,1,5000),
   (45677,'Dread Queen Laia',49115,'Dragon Tablet(FreezingBreath)',1,1,5000),
   (45677,'Dread Queen Laia',20129,'Robe of New King',1,1,5000),
   (45677,'Dread Queen Laia',40636,'Evidence Box of Dark Spirit Army',1,1,10000),
   (45677,'Dread Queen Laia',40960,'Seal of Dread Queen',1,1,5000),
   (45863,'Dread Queen Laia',20067,'Cloak of New King',1,1,5000),
   (45863,'Dread Queen Laia',20233,'Scroll of New King',1,1,5000),
   (45863,'Dread Queen Laia',40224,'Spellbook(AdvanceSpirit)',1,1,2000),
   (45676,'Arcane King Hellvine',20129,'Robe of New King',1,1,5000),
   (45676,'Arcane King Hellvine',20067,'Cloak of New King',1,1,5000),
   (45676,'Arcane King Hellvine',20208,'Boots of New King',1,1,5000);

 -- Remove incorrect item drop entry from Oum Warrior.
delete from droplist where mobId = 45466 and itemId = 20030;
delete from droplist where mobId = 45466 and itemId = 20067;
delete from droplist where mobId = 45466 and itemId = 20176;
delete from droplist where mobId = 45466 and itemId = 20208;

update droplist set mob_name = 'Great Grave Guardian' where mobid = 45603;
update npc set name = 'Great Grave Guardian' where npcid = 45603;
update armor set name = 'Gauntlet of the Pretender King' where item_id = 21070;
update armor set unidentified_name_id = '$2191' where item_id = 21070;
update armor set identified_name_id = '$2191' where item_id = 21070;

update etcitem set name = 'Arcane Book of Magic Vol 1' where item_id = 40420;
update etcitem set name = 'Arcane Book of Magic Vol 2' where item_id = 40421;
update etcitem set name = 'Arcane Book of Magic Vol 3' where item_id = 40422;
update etcitem set name = 'Arcane Book of Magic Vol 4' where item_id = 40423;
update droplist set item_name = 'Arcane Book of Magic Vol 1' where itemid = 40420;
update droplist set item_name = 'Arcane Book of Magic Vol 2' where itemid = 40421;
update droplist set item_name = 'Arcane Book of Magic Vol 3' where itemid = 40422;
update droplist set item_name = 'Arcane Book of Magic Vol 4' where itemid = 40423;

-- Update name $ values.
update armor set unidentified_name_id = '$3857' where item_id = 20178; -- Gloves of Assassin King
update armor set identified_name_id = '$3857' where item_id = 20178; -- Gloves of Assassin King
update armor set unidentified_name_id = '$3859' where item_id = 20253; -- Amulet of Dread Queen
update armor set identified_name_id = '$3859' where item_id = 20253; -- Amulet of Dread Queen
update armor set unidentified_name_id = '$1560' where item_id = 20270; -- Silver Serpent Amulet
update armor set identified_name_id = '$1560' where item_id = 20270; -- Silver Serpent Amulet
update armor set unidentified_name_id = '$3724' where item_id = 20345; -- High Collie Collar
update armor set identified_name_id = '$3724' where item_id = 20345; -- High Collie Collar
update armor set unidentified_name_id = '$3725' where item_id = 20346; -- High Raccoon Collar
update armor set identified_name_id = '$3725' where item_id = 20346; -- High Raccoon Collar
update armor set unidentified_name_id = '$4945' where item_id = 20419; -- High Bear Collar
update armor set identified_name_id = '$4945' where item_id = 20419; -- High Bear Collar
update armor set name = 'High Bear Collar' where item_id = 20419; -- High Bear Collar
update armor set unidentified_name_id = '$798' where item_id = 29001; -- Wooden Jacket
update armor set identified_name_id = '$798' where item_id = 29001; -- Wooden Jacket
update armor set unidentified_name_id = '$13787' where item_id = 30000; -- Reinforced T-Shirt
update armor set identified_name_id = '$13787' where item_id = 30000; -- Reinforced T-Shirt
update armor set unidentified_name_id = '$13788' where item_id = 30001; -- Fortified T-Shirt
update armor set identified_name_id = '$13788' where item_id = 30001; -- Fortified T-Shirt
update armor set unidentified_name_id = '$13683' where item_id = 30009; -- KillGlance's Ring
update armor set identified_name_id = '$13683' where item_id = 30009; -- KillGlance's Ring
update armor set unidentified_name_id = '$13648' where item_id = 30008; -- Mermaid's Necklace
update armor set identified_name_id = '$13648' where item_id = 30008; -- Mermaid's Necklace
update armor set unidentified_name_id = '$13582' where item_id = 30002; -- Ruby Ring
update armor set identified_name_id = '$13582' where item_id = 30002; -- Ruby Ring
update armor set unidentified_name_id = '$13583' where item_id = 30003; -- Sapphire Ring
update armor set identified_name_id = '$13583' where item_id = 30003; -- Sapphire Ring
update armor set unidentified_name_id = '$13584' where item_id = 30004; -- Moonstone Ring
update armor set identified_name_id = '$13584' where item_id = 30004; -- Moonstone Ring
update armor set unidentified_name_id = '$13585' where item_id = 30005; -- Carnelian Ring
update armor set identified_name_id = '$13585' where item_id = 30005; -- Carnelian Ring
update armor set unidentified_name_id = '$13575' where item_id = 30006; -- Mermaid's Ring
update armor set identified_name_id = '$13575' where item_id = 30006; -- Mermaid's Ring
update armor set unidentified_name_id = '$13686' where item_id = 30007; -- Amulet
update armor set identified_name_id = '$13686' where item_id = 30007; -- Amulet
update armor set unidentified_name_id = '$13735' where item_id = 30012; -- Dark Elf Tunic
update armor set identified_name_id = '$13735' where item_id = 30012; -- Dark Elf Tunic
update armor set unidentified_name_id = '$13736' where item_id = 30013; -- Dark Elf Sandals
update armor set identified_name_id = '$13736' where item_id = 30013; -- Dark Elf Sandals
update armor set unidentified_name_id = '$13737' where item_id = 30014; -- Dark Elf Circlet
update armor set identified_name_id = '$13737' where item_id = 30014; -- Dark Elf Circlet

-- Update incorrect data for duplicate Silver Serpent Amulet.
update armor set name = 'Necklace of Dupelgenon' where item_id = 20251;
update armor set unidentified_name_id = '$797' where item_id = 20251;
update armor set identified_name_id = '$797' where item_id = 20251;
update armor set trade = 1 where item_id = 20251;

-- Ogre Belt and Troll Belt weight reduction was incorrect.
update armor set weight_reduction = 10 where item_id in (20321, 120321);
update armor set weight_reduction = 20 where item_id in (20317, 120317);
