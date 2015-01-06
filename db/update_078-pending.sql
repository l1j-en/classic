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

-- Fix fungus spawn in SKT and TI DM.
update spawnlist_ub set npc_templateid = 45030 where npc_templateid = 45551;

-- Remove non-ASCII chars from Plate Worm npc entry note field.
update npc set note = '' where npcid = 45299;

-- Correct Amulet of Blue Curse item name.
update armor set name = 'Amulet of Blue Curse' where item_id = 20424;
update droplist set item_name = 'Amulet of Blue Curse' where itemid = 20424;

-- Update Captain Drake droplist.
insert into droplist values
   (45458, 'Captain Drake', 220294, 'Cursed Ruby Ring', 1, 1, 7500),
   (45458, 'Captain Drake', 220295, 'Cursed Sapphire Ring', 1, 1, 7500),
   (45458, 'Captain Drake', 220296, 'Cursed Emerald Ring', 1, 1, 7500),
   (45458, 'Captain Drake', 220293, 'Cursed Diamond Ring', 1, 1, 7500),
   (45458, 'Captain Drake', 40018, 'Greater Haste Potion', 1, 1, 20000),
   (45458, 'Captain Drake', 40241, 'Spirit Crystal(ElementalFallDown)', 1, 1, 5000),
   (45458, 'Captain Drake', 40259, 'Spirit Crystal(ElementalFire)', 1, 1, 5000),
   (45458, 'Captain Drake', 40213, 'Spellbook(ImmuneToHarm)', 1, 1, 500),
   (45458, 'Captain Drake', 40176, 'Spellbook(CounterMagic)', 1, 1, 1000),
   (45458, 'Captain Drake', 40224, 'Spellbook(AdvanceSpirit)', 1, 1, 250),
   (45458, 'Captain Drake', 40471, 'Fragment of Spirit', 1, 1, 20000),
   (45458, 'Captain Drake', 40330, 'Unlimited Quiver', 1, 1, 4500),
   (45458, 'Captain Drake', 40044, 'Diamond', 1, 1, 9000),
   (45458, 'Captain Drake', 40048, 'High Quality Diamond', 1, 1, 6000),
   (45458, 'Captain Drake', 40052, 'Highest Quality Diamond', 1, 1, 3000),
   (45458, 'Captain Drake', 40045, 'Ruby', 1, 1, 9000),
   (45458, 'Captain Drake', 40046, 'Sapphire', 1, 1, 9000),
   (45458, 'Captain Drake', 40050, 'High Quality Sapphire', 1, 1, 6000),
   (45458, 'Captain Drake', 40054, 'Highest Quality Sapphire', 1, 1, 3000),
   (45458, 'Captain Drake', 40047, 'Emerald', 1, 1, 9000),
   (45458, 'Captain Drake', 40051, 'High Quality Emerald', 1, 1, 6000),
   (45458, 'Captain Drake', 40055, 'Highest Quality Emerald', 1, 1, 3000),
   (45458, 'Captain Drake', 40306, 'Relic of Eva', 1, 1, 6000),
   (45458, 'Captain Drake', 40307, 'Relic of Sayha', 1, 1, 6000),
   (45458, 'Captain Drake', 40093, 'Blank Scroll (Level 4)', 1, 1, 4000),
   (45458, 'Captain Drake', 39, 'Cutlass', 1, 1, 7500),
   (45458, 'Captain Drake', 43, 'Shamshir', 1, 1, 10000);

-- Redo Caspa group cap droprate updates (npcids were wrong previously).
update droplist set chance = 3600 where itemid = 20040 and mobid = 45488;
update droplist set chance = 1200 where itemid = 20025 and mobid = 45473;
update droplist set chance = 1200 where itemid = 20018 and mobid = 45497;
update droplist set chance = 1200 where itemid = 20029 and mobid = 45464;

-- update quest item reference info
update etcitem set name = 'Letter of Soul (White)' where item_id = 40573;
update etcitem set name = 'Letter of Soul (Black)' where item_id = 40574;
update etcitem set name = 'Letter of Soul (Red)' where item_id = 40575;
update etcitem set name = 'Emblem Piece of the Royal Family (Left)' where item_id = 40586;
update etcitem set name = 'Emblem Piece of the Royal Family (Right)' where item_id = 40587;
update etcitem set name = 'Cloak of Illusionist' where item_id = 21100;
update etcitem set name = 'Sealed Scroll' where item_id = 41146;
update etcitem set identified_name_id = '$3262' where item_id = 41146;
update etcitem set unidentified_name_id = '$3262' where item_id = 41146;

-- update missing npc names
update npc set name = 'Sveil' where npcid = 80141;
update npc set name = 'Blacksmith Bahturu' where npcid = 80142;
update npc set name = 'Azael' where npcid = 80143;
update npc set name = 'Lark' where npcid = 80144;
update npc set name = 'Unchosen One' where npcid = 46092;
update npc set name = 'Unchosen One' where npcid = 46093;
update npc set name = 'Unchosen One' where npcid = 46094;
update npc set name = 'Unchosen One' where npcid = 46095;
update npc set name = 'Unchosen One' where npcid = 46096;
update npc set note = 'Lesser Demon' where npcid = 46092;
update npc set note = 'Demon' where npcid = 46093;
update npc set note = 'Baphomet' where npcid = 46094;
update npc set note = 'Beleth' where npcid = 46095;
update npc set note = 'Succubus' where npcid = 46096;
update npc set note = 'Sand Tomb' where npcid = 46069;
update npc set note = 'Flying Paj' where npcid = 46070;
update npc set note = 'Paj' where npcid = 46071;
update npc set note = 'Flying Pasaj' where npcid = 46072;
update npc set note = 'Pasaj' where npcid = 46073;
update npc set note = 'Shiboin of Earth' where npcid = 46074;
update npc set note = 'Shiboin of Wind' where npcid = 46075;
update npc set note = 'Shiboin of Fire' where npcid = 46076;
update npc set note = 'Shiboin of Waves' where npcid = 46077;
update npc set note = 'Angas' where npcid = 46078;
update npc set note = 'Deangas' where npcid = 46079;
update npc set note = 'Judigo' where npcid = 46080;
update npc set note = 'Dego' where npcid = 46081;

 -- add missing npc's for missing quest data
insert into npc values
(81247,'Dead White Ant Remains','$5652','Lv45 Illusionist Quest NPC (1st Floor)','L1Merchant',6901,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,2,0,2,2,0,0,0,0,0,0,'ant',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0),
(81248,'Dead White Ant Remains','$5652','Lv45 Illusionist Quest NPC (2nd Floor)','L1Merchant',6901,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,2,0,2,2,0,0,0,0,0,0,'ant',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0),
(81249,'Dead White Ant Remains','$5652','Lv45 Illusionist Quest NPC (3rd Floor)','L1Merchant',6901,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,2,0,2,2,0,0,0,0,0,0,'ant',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0),
(81250,'Soil of White Ant','$5653','Lv45 Illusionist Element','L1Merchant',6918,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,2,0,2,2,0,0,0,0,0,0,'ant',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0),
(81251,'Acidic Liquid of White Ant','$5654','Lv45 Illusionist Element','L1Merchant',6909,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,2,0,2,2,0,0,0,0,0,0,'ant',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0),
(81252,'Shell of White Ant','$5655','Lv45 Illusionist Element','L1Merchant',6910,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,2,0,2,2,0,0,0,0,0,0,'ant',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0),
(91203,'Savius','$5658','Outsider','L1Monster',6788,46,1100,300,-40,20,24,24,22,28,40,2117,-55,'large',4,1,0,960,1640,0,1200,1640,2,0,0,1,1,1,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(91298,'Official Kiholl','$5790','Lv50 Quest NPC','L1Merchant',6773,22,750,300,-65,25,25,25,25,25,100,485,-5,'small',0,6,0,960,1120,960,1172,1172,3,0,0,0,0,0,'chaos',1,-1,-1,0,0,0,5000,8,5000,50,0,0,0,0,0,0,0,4,0,0,0,0,4552,2,-1,0,0,0,0,0),
(91299,'Entrance to Shrine','$5777','Lv50 Quest NPC','L1Merchant',155,0,0,0,0,0,0,0,0,0,0,0,0,'small',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,0,0,0,0),
(91300,'Guignol\'s Warrior','$5747','Lv50 Quest NPC','L1Monster',1578,31,300,50,-25,18,15,12,12,10,40,962,-35,'small',2,1,1,1440,1920,0,1920,1920,2,0,0,1,1,0,'livingarmour',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,-1,0,0,0,0,0),
(91301,'Warrior of Noble Will','$5753','Lv50 Quest NPC','L1Monster',4664,41,1080,278,-43,19,15,16,16,16,50,1682,-25,'small',2,2,0,640,1160,1400,1160,1160,0,0,0,1,1,1,'lastabad',1,-1,-1,0,0,0,5000,25,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(91302,'Guardian of Noble Will','$5770','Lv50 Quest NPC','L1Monster',1571,52,1800,318,-55,20,18,16,12,15,65,2705,-25,'small',2,1,0,960,1200,1120,1200,1200,1,0,0,1,1,1,'lastabad',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,-1,0,0,0,0,0),
(91303,'Guignol\'s Fighter','$5748','Lv50 Quest NPC','L1Monster',2308,35,550,0,-30,0,0,0,0,99,0,1226,-30,'large',0,1,0,960,1240,1240,1240,1240,0,0,0,1,1,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(91304,'Fighter of Noble Will','$5754','Lv50 Quest NPC','L1Monster',4034,60,4000,100,-60,20,20,20,18,20,60,3601,-100,'small',0,3,0,640,720,1760,880,960,2,0,0,0,0,0,'spirit',1,-1,-1,0,0,0,5000,40,5000,100,0,0,0,0,0,0,0,0,1,0,0,0,0,0,-1,0,0,1,0,1),
(91305,'Guignol\'s Watcher','$5751','Lv50 Quest NPC','L1Monster',1123,33,450,500,-10,10,13,12,18,18,50,1090,-30,'large',1,1,1,960,1120,0,1480,1120,0,0,1,1,1,1,'gazer',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(91306,'Guardian of Noble Will','$5770','Lv50 Quest NPC','L1Monster',1571,16,110,15,-18,14,8,16,12,14,30,257,-14,'small',2,1,1,640,1920,1760,1920,1920,1,0,0,1,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0),
(91307,'Rotting Corpse','$5752','Lv50 Quest NPC','L1Merchant',5676,0,0,0,0,0,0,0,0,0,0,0,0,'small',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,0,0),
(91308,'Rotting Corpse','$5752','Lv50 Quest NPC','L1Merchant',5676,0,0,0,0,0,0,0,0,0,0,0,0,'small',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,0,0),
(91309,'Priest Guignol','$5746','Lv50 Quest NPC','L1Monster',2495,66,20000,1250,-75,50,20,66,22,23,99,4357,-250,'large',0,2,0,1920,1440,1280,1440,1240,3,0,0,1,1,1,'',0,-1,-1,0,0,0,5000,250,5000,350,0,0,0,0,0,0,0,0,1,0,0,0,0,0,-1,0,14,1,0,1),
(91310,'Altar of Reviving','$5755','Lv50 Quest NPC','L1Monster',6892,40,5000,50,-20,0,0,0,0,0,60,0,-5000,'small',0,0,0,0,960,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,0,0,0,1),
(91311,'Dicarding\'s Spy','$6068','Lvl 50 Wizard Quest NPC','L1Merchant',148,0,0,0,0,0,0,0,0,0,0,0,0,'small',0,0,0,480,840,520,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,0,0,0,0),
(91312,'Female Spy of Dicarding','$5800','Lv50 Elf Quest NPC','L1Quest',3097,1,1000,0,-15,0,0,0,0,0,0,1,0,'small',0,0,0,640,800,0,1320,1480,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,0,0,0,0),
(91313,'Assassination Squad of Sorcerers','$5801','Lv50 Elf Quest NPC','L1Monster',3989,53,1800,300,-63,55,21,11,21,18,70,2810,-5,'small',0,2,0,720,1040,1080,2400,1040,3,0,0,1,1,1,'chaos',1,-1,-1,0,0,0,5000,150,5000,50,0,0,0,0,0,0,0,4,0,0,0,0,0,30,-1,0,14,0,0,0),
(91314,'Flame of Blue Soul','$5657','Lv50 Illusionist Quest NPC','L1Merchant',7009,0,0,0,0,0,0,0,0,0,0,0,0,'small',0,0,0,640,800,0,1320,1480,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,0,0,0,0),
(91315,'Red Soul\'s Flame','$5919','Lv50 Dragon Knight Quest NPC','L1Merchant',6786,0,0,0,0,0,0,0,0,0,0,0,0,'small',0,0,0,640,800,0,1320,1480,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,0,0,0,0);

-- Updates for Lv 45 Illusionist Quest
insert into npcaction values (81247, 'wcorpse1', 'wcorpse1', '', '');
insert into npcaction values (81248, 'wcorpse4', 'wcorpse4', '', '');
insert into npcaction values (81249, 'wcorpse7', 'wcorpse7', '', '');
insert into npcaction values (81250, 'wa_earth1', 'wa_earth1', '', '');
insert into npcaction values (81251, 'wa_acidw1', 'wa_acidw1', '', '');
insert into npcaction values (81252, 'wa_egg1', 'wa_egg1', '', '');

insert into npc values (81254, 'Cracked Time', '$5656', 'Lv45 Illusionist Quest NPC', 'L1Monster', 6920, 1, 1, 0, 10, 0, 0, 0, 0, 0, 0, 2, 0, 'small', 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0);

-- Updates for Lv 45 Illusionist Quest
insert into spawnlist_npc values (90455, 'Dead Ant Remains', 1, 81247, 32739, 32794, 0, 0, 0, 0, 44, 0);
insert into spawnlist_npc values (90456, 'Dead Ant Remains', 1, 81248, 32785, 32751, 0, 0, 4, 0, 46, 0);
insert into spawnlist_npc values (90457, 'Dead Ant Remains', 1, 81249, 32741, 32806, 0, 0, 1, 0, 50, 0);
insert into spawnlist_npc values (90458, 'Soil of White Ant', 1, 81250, 33712, 32348, 0, 0, 6, 0, 4, 0);
insert into spawnlist_npc values (90459, 'Acidic Liquid of White Ant', 1, 81251, 33677, 32383, 0, 0, 5, 0, 4, 0);
insert into spawnlist_npc values (90460, 'Shell of White Ant', 1, 81252, 33655, 32396, 0, 0, 2, 0, 4, 0);

-- Updates for Lv 45 Illusionist Quest
update etcitem set use_type = 'normal' where item_id = 49200;
update etcitem set use_type = 'normal' where item_id = 49201;

-- Updates for Lv 45 Illusionist Quest
insert into droplist values  (81254, 'Cracked Time', 49202, 'Thought Piece of Time', 1, 1, 1000000);

-- Update description for Illusionist Cloak
update armor set name = 'Cloak of Illusionist' where item_id = 21100;

-- re-add Knight's Visor to shoplists in Giran and Oren
insert into shop values
(70032,'Virgil',20006,'Knight\'s Visor',21,5000,0,2500),
(70061,'Mandra',20006,'Knight\'s Visor',38,5000,0,2500);

-- Updates for Lv 50 Illusionist Quest
update mapids set locationname = 'Goras - Level 50 Illusionist Quest' where mapid = 2004;

-- Updates for Lv 50 Illusionist Quest
insert into npc values ( 91205, 'Cracked Time', '$5656', 'Level 50 Illusionist Quest NPC', 'L1Monster', 6920, 45, 100, 200, -1, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
insert into npc values ( 91206, 'Wyvern (Q)', '$4307', 'Level 50 Illusionist Quest NPC', 'L1Monster', 5282, 44, 500, 200, -55, 17, 18, 20, 15, 17, 70, 2917, -25, 'large', 0, 1, 0, 800, 1200, 1280, 1360, 1360, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 25, 5000, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);
insert into npc values ( 91207, 'Otyu', '$4306', 'Level 50 Illusionist Quest NPC', 'L1Monster', 5442, 40, 400, 250, -40, 15, 18, 20, 14, 16, 50, 2501, -25, 'small', 0, 3, 0, 960, 1120, 920, 1120, 1120, 2, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 5000, 25, 500, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0, 0, 0);

-- Monsters
-- location coords seem to be slightly off ( l1j.org base )..
-- going to try to offset X by +75 and Y by -15
insert into spawnlist_npc values ( 90461, 'Cracked Time', 30, 91205, 32854, 32753, 100, 50, 4, 15, 2004, 50 );
insert into spawnlist_npc values ( 90462,'Wyvern',30,91206,32801,32841,25,50,4,15,2004,50 );
insert into spawnlist_npc values ( 90463,'Otyu',30,91207,32843,32860,25,50,4,15,2004,50 );

-- NPC
insert into spawnlist_npc values ( 90464,'Flame of Blue Soul',1,91314,32857,32817,0,0,6,0,2004,0 );
insert into spawnlist_npc values ( 90465,'Flame of Red Soul',1,91315,32857,32812,0,0,6,0,2004,0 );

-- Text for Flame of Red/Blue soul
insert into npcaction values (91314,'bluesoul_f4','bluesoul_f4','','');
insert into npcaction values (91315,'redsoul_f4','redsoul_f4','','');

-- Items
-- insert into droplist values (91203,'Savius',49229,'Thought Piece of Savius',1,1,1000000);
insert into droplist values (91203,'Savius',49206,'Thought Piece of Savius',1,1,1000000);
insert into droplist values (91206,'Wyvern (Q)', 49204,'Tears of Wyvern',1,1,500000);
insert into droplist values (91207,'Otyu', 49203,'Tears of Otyu',1,1,500000);

update etcitem set name = 'Tears of Wyvern' where item_id = 49204;
update etcitem set name = 'Tears of Otyu' where item_id = 49203;
update etcitem set use_type = 'normal' where item_id = 49202;

-- Fix text
update etcitem set name = 'Head of Chaos' where item_id = 40719;
update droplist set item_name = 'Head of Chaos' where itemId = 40719;

-- Add Spellbook: Polymorph to doppleganger boss
insert into droplist values (45546,'Doppleganger (Boss)', 40212, 'Spellbook (Polymorph)',1,1,4500);

-- Update level 45 elf quest to only spawn a single boss instead of 2
update spawnlist set count = 1 where npc_templateid = 45301;

-- Reduce spawn count on ToS 2f from 20 to 10
update spawnlist set count = 10 where mapid = 523;

-- Make Jeif spawn
insert into spawnlist_npc values (null,'Aden',1,71180,33454,32824,0,0,5,0,4,0);

-- Make Emai spawn
insert into spawnlist_npc values (null,'Aden',1,71181,33493,32683,0,0,6,0,4,0);

-- Correct Sharna name
update npc set nameid = '$5885' where npcid = 81246;

-- Update DM to replace Kurtz with a slightly stronger BK.
-- If we need to tweak we can later
update spawnlist_ub set npc_templateid = 81067 where id = 279;

-- Fix some item/mob names
UPDATE weapon SET name = 'Execution Sword of Fidelity' WHERE item_id = 61;
UPDATE etcitem SET name = 'Assorted Spice Sauce' WHERE item_id = 49048;
UPDATE etcitem SET unidentified_name_id = '$5430 $4928', identified_name_id = '$5430 $4928' WHERE item_id = 49057;
UPDATE etcitem SET unidentified_name_id = '$5431 $4928', identified_name_id = '$5431 $4928' WHERE item_id = 49058;
UPDATE etcitem SET unidentified_name_id = '$5432 $4928', identified_name_id = '$5432 $4928' WHERE item_id = 49059;
UPDATE etcitem SET unidentified_name_id = '$5433 $4928', identified_name_id = '$5433 $4928' WHERE item_id = 49060;
UPDATE etcitem SET unidentified_name_id = '$5434 $4928', identified_name_id = '$5434 $4928' WHERE item_id = 49061;
UPDATE etcitem SET unidentified_name_id = '$5435 $4928', identified_name_id = '$5435 $4928' WHERE item_id = 49062;
UPDATE etcitem SET unidentified_name_id = '$5436 $4928', identified_name_id = '$5436 $4928' WHERE item_id = 49063;
UPDATE etcitem SET unidentified_name_id = '$5437 $4928', identified_name_id = '$5437 $4928' WHERE item_id = 49064;
UPDATE npc SET name = 'Doppelganger Boss' WHERE npcid = 45828;

-- Lower TOI 74+ spawn amount by 1/3 and set respawn delay to 2-3 minutes
UPDATE spawnlist SET min_respawn_delay = 120, max_respawn_delay = 180 WHERE mapid >= 174 AND mapid <= 180;
UPDATE spawnlist SET count = 15 WHERE id = 17400001;
UPDATE spawnlist SET count = 45 WHERE id = 17400002;
UPDATE spawnlist SET count = 17 WHERE id = 17400003;
UPDATE spawnlist SET count = 7 WHERE id = 17400004;
UPDATE spawnlist SET count = 17 WHERE id = 17500001;
UPDATE spawnlist SET count = 59 WHERE id = 17500002;
UPDATE spawnlist SET count = 7 WHERE id = 17500003;
UPDATE spawnlist SET count = 19 WHERE id = 17700001;
UPDATE spawnlist SET count = 47 WHERE id = 17700002;
UPDATE spawnlist SET count = 15 WHERE id = 17700003;
UPDATE spawnlist SET count = 7 WHERE id = 17700004;
UPDATE spawnlist SET count = 15 WHERE id = 17800001;
UPDATE spawnlist SET count = 19 WHERE id = 17800002;
UPDATE spawnlist SET count = 45 WHERE id = 17800003;
UPDATE spawnlist SET count = 15 WHERE id = 17800004;
UPDATE spawnlist SET count = 7 WHERE id = 17800005;
UPDATE spawnlist SET count = 19 WHERE id = 17900001;
UPDATE spawnlist SET count = 47 WHERE id = 17900002;
UPDATE spawnlist SET count = 15 WHERE id = 17900003;
UPDATE spawnlist SET count = 7 WHERE id = 17900004;
UPDATE spawnlist SET count = 25 WHERE id = 18000001;
UPDATE spawnlist SET count = 48 WHERE id = 18000002;
UPDATE spawnlist SET count = 16 WHERE id = 18000003;
UPDATE spawnlist SET count = 8 WHERE id = 18000004;

-- Increase TOI 42f spawn by 33%
UPDATE spawnlist SET count = 114 WHERE id = 14200001;
UPDATE spawnlist SET count = 24 WHERE id = 14200002;
UPDATE spawnlist SET count = 21 WHERE id = 14200003;

-- Update maps in database to match what was hardcoded
update mapids set startX = 32704, endX = 32895, startY = 32768, endY = 32895 where mapid = 72;
update mapids set startX = 32704, endX = 32895, startY = 32704, endY = 32895 where mapid = 73;
update mapids set startX = 32704, endX = 32895, startY = 32768, endY = 32959 where mapid = 74;
-- Remove some old(?)/new(?) maps
delete from mapids where mapid = 17492;
delete from mapids where mapid = 17820;

-- update walking/attack speeds
update npc set passispeed = 1280 where npcid = 45359;
update npc set passispeed = 1280 where npcid = 45206 or npcid = 45555 or npcid = 46068;
update npc set passispeed = 480 where npcid = 81231;
update npc set passispeed = 640 where npcid = 45824 or npcid = 45820;
update npc set passispeed = 1120 where npcid = 45829;

-- Update mountain fortress ant to not pick up off ground
update npc set picupitem = 0 where npcid = 81232;

-- Add adena drops to thebes
insert into droplist values ( 46107, 'Mandragora - Light', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46108, 'Mandragora - Dark', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46109, 'Scarab - Yellow', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46110, 'Scarab - Blue', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46111, 'Kalbis - Dark', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46112, 'Kalbis - Red', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46113, 'Obelisk - Light', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46114, 'Obelisk - Dark', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46115, 'Sphinx - Light', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46116, 'Sphinx - Dark', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46117, 'Horus Falcon - Yellow', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46118, 'Horus Falcon - Blue', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46119, 'Thebes Guardian - Dark', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46120, 'Thebes Guardian - Red', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46121, 'Thebes Elder - Yellow', 40308, 'Adena', 350, 500, 1000000 );
insert into droplist values ( 46122, 'Thebes Elder - Purple', 40308, 'Adena', 350, 500, 1000000 );

-- Update treasure box piece drop rates to be the same
update droplist set chance = 50000 where itemid in ( 49094, 49093, 49098 );

-- Lv 50 NPCs
-- -- Living Armor
-- (91300,'Guignol\'s Warrior','$5747','Lv50 Quest NPC','L1Monster',1578,31,300,50,-25,18,15,12,12,10,40,962,-35,'small',2,1,1,1440,1920,0,1920,1920,2,0,0,1,1,0,'livingarmour',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,-1,0,0,0,0,0),
-- -- Phantom Knight
-- (91301,'Warrior of Noble Will','$5753','Lv50 Quest NPC','L1Monster',4664,41,1080,278,-43,19,15,16,16,16,50,1682,-25,'small',2,2,0,640,1160,1400,1160,1160,0,0,0,1,1,1,'lastabad',1,-1,-1,0,0,0,5000,25,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
-- -- Silhouette | Guardian Armor
-- (91302,'Guardian of Noble Will','$5770','Lv50 Quest NPC','L1Monster',1571,52,1800,318,-55,20,18,16,12,15,65,2705,-25,'small',2,1,0,960,1200,1120,1200,1200,1,0,0,1,1,1,'lastabad',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,-1,0,0,0,0,0),
-- -- Gargoyle
-- (91303,'Guignol\'s Fighter','$5748','Lv50 Quest NPC','L1Monster',2308,35,550,0,-30,0,0,0,0,99,0,1226,-30,'large',0,1,0,960,1240,1240,1240,1240,0,0,0,1,1,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
-- -- Blue Demon
-- (91304,'Fighter of Noble Will','$5754','Lv50 Quest NPC','L1Monster',4034,60,4000,100,-60,20,20,20,18,20,60,3601,-100,'small',0,3,0,640,720,1760,880,960,2,0,0,0,0,0,'spirit',1,-1,-1,0,0,0,5000,40,5000,100,0,0,0,0,0,0,0,0,1,0,0,0,0,0,-1,0,0,1,0,1),
-- -- Beholder
-- (91305,'Guignol\'s Watcher','$5751','Lv50 Quest NPC','L1Monster',1123,33,450,500,-10,10,13,12,18,18,50,1090,-30,'large',1,1,1,960,1120,0,1480,1120,0,0,1,1,1,1,'gazer',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
-- -- Silhouette
-- (91306,'Guardian of Noble Will','$5770','Lv50 Quest NPC','L1Monster',1571,16,110,15,-18,14,8,16,12,14,30,257,-14,'small',2,1,1,640,1920,1760,1920,1920,1,0,0,1,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0),

-- -- 2771 gfxid = guardian armor
update npc set gfxid = 2771 where npcid = 91302;

-- Droplists for secret intelligence report from SoE Oum's
insert into droplist values (45331,'',49164,'Secret Intelligence Report',1,1,250000);
insert into droplist values (45391,'',49164,'Secret Intelligence Report',1,1,250000);
insert into droplist values (45450,'',49164,'Secret Intelligence Report',1,1,250000);
insert into droplist values (45453,'',49164,'Secret Intelligence Report',1,1,100000);
insert into droplist values (45482,'',49164,'Secret Intelligence Report',1,1,250000);
insert into droplist values (45569,'',49164,'Secret Intelligence Report',1,1,250000);
insert into droplist values (45570,'',49164,'Secret Intelligence Report',1,1,250000);
insert into droplist values (45571,'',49164,'Secret Intelligence Report',1,1,250000);
insert into droplist values (45579,'',49164,'Secret Intelligence Report',1,1,250000);
insert into droplist values (45582,'',49164,'Secret Intelligence Report',1,1,250000);
insert into droplist values (45587,'',49164,'Secret Intelligence Report',1,1,250000);
insert into droplist values (45605,'',49164,'Secret Intelligence Report',1,1,250000);
insert into droplist values (45615,'',49164,'Secret Intelligence Report',1,1,250000);
insert into droplist values (45647,'',49164,'Secret Intelligence Report',1,1,250000);
insert into droplist values (46016,'',49164,'Secret Intelligence Report',1,1,100000);

-- Droplists for various parts of lv 50 dungeon
-- 1f Drops
insert into droplist values (91300,'',49165,'Sanctum 2nd Floor Key',1,1,200000);
insert into droplist values (91301,'',49165,'Sanctum 2nd Floor Key',1,1,1000000);
-- 2f Drops
insert into droplist values (91304,'',49166,'Sanctum 3rd Floor Key',1,1,1000000);
-- 3f Drops
insert into droplist values (91306,'',49167,'Ma\'s Horn Flute',1,1,1000000);
-- Altar Room
insert into droplist values (91309,'',49168,'Secret Medicine of Destruction',1,1,1000000);
insert into droplist values (91310,'',49241,'Fragment of Altar',1,1,1000000);

-- Level 50 Quest entry
insert into spawnlist_npc values ( null,'Entrance to the Sanctuary',1,91299,32918,32994,0,0,0,0,410,0);

-- NPC Spawn
-- | id | location | count | npc_templateid | group_id | locx  | locy  | randomx | randomy | locx1 | locy1 | locx2 | locy2 | heading | min_respawn_delay | max_respawn_delay | mapid | respawn_screen | movement_distance | rest | near_spawn | spawn_home | spawn_home_range | spawn_home_count | spawn_home_delay |
-- | id | npc_id | note | group_id | count | loc_x | loc_y | random_x | random_y | loc_x1 | loc_y1 | loc_x2 | loc_y2 | heading | min_respawn_delay | max_respawn_delay | map_id | respawn_screen | movement_distance | rest | near_spawn

-- Pseudo maps
-- 1f: 32704 - 32895, 32832 - 33023
-- West:         32720, 32857 2000
-- North: Start: 32809, 32857   2000
-- East:         32809, 32941
-- South:        32720, 32941 2000

-- 2f:
-- Start: 32856, 32740   2000
-- End: 32882, 32906 2000  ( +20 x/y for demon + gargoyle spawn )

-- 3f:
-- Start: 32738, 32773
-- Mid: 32758, 32771

-- Altar:
-- Start: 32788, 32773 2000

-- OLD 50 quest
-- 32729 32989 2000

-- 1f
-- npc_templateid 91300 | group_id 0 | locx 32768  | locy 32895  | randomx 42 | randomy 42 | locx1 0 | locy1 0 | locx2 0 | locy2 0 | heading 0 | min_respawn_delay 15 | max_respawn_delay 30 | mapid 2000 | respawn_screen | movement_distance | rest | near_spawn | spawn_home | spawn_home_range | spawn_home_count | spawn_home_delay |
insert into spawnlist values (null,'Sanctum of Restoration', 30, 91300, 0, 32768, 32895, 42, 42, 0, 0, 0, 0, 0, 15, 30, 2000, 0, 0, 0, 0, 0, 0, 0, 0);
insert into spawnlist values (null,'Sanctum of Restoration', 5, 91301, 0, 32768, 32895, 42, 42, 0, 0, 0, 0, 0, 15, 30, 2000, 0, 0, 0, 0, 0, 0, 0, 0);

-- 2f
-- first hallway
insert into spawnlist values (null,'Sanctum of Restoration', 20, 91305, 0, 32910, 32740, 20, 20, 0, 0, 0, 0, 0, 15, 30, 2000, 0, 0, 0, 0, 0, 0, 0, 0);
-- second hallway
insert into spawnlist values (null,'Sanctum of Restoration', 20, 91305, 0, 32930, 32820, 10, 80, 0, 0, 0, 0, 0, 15, 30, 2000, 0, 0, 0, 0, 0, 0, 0, 0);
-- third hallway
insert into spawnlist values (null,'Sanctum of Restoration', 20, 91305, 0, 32890, 32820, 100, 20, 0, 0, 0, 0, 0, 15, 30, 2000, 0, 0, 0, 0, 0, 0, 0, 0);
insert into spawnlist values (null,'Sanctum of Restoration', 1, 91304, 0, 32882, 32906, 20, 20, 0, 0, 0, 0, 0, 15, 30, 2000, 0, 0, 0, 0, 0, 0, 0, 0);
insert into spawnlist values (null,'Sanctum of Restoration', 6, 91303, 0, 32882, 32906, 20, 20, 0, 0, 0, 0, 0, 15, 30, 2000, 0, 0, 0, 0, 0, 0, 0, 0);

-- 3f
insert into spawnlist values (null,'Sanctum of Restoration', 20, 91306, 0, 32758, 32771, 20, 20, 0, 0, 0, 0, 0, 15, 30, 2000, 0, 0, 0, 0, 0, 0, 0, 0);
insert into spawnlist values (null,'Sanctum of Restoration', 20, 91302, 0, 32758, 32771, 20, 20, 0, 0, 0, 0, 0, 15, 30, 2000, 0, 0, 0, 0, 0, 0, 0, 0);

-- Altar Room
insert into spawnlist values (null,'Sanctum of Restoration', 1, 91310, 0, 32816, 32773, 0, 0, 0, 0, 0, 0, 0, 15, 30, 2000, 0, 0, 0, 0, 0, 0, 0, 0);

-- Create text stuff for rotting corpse
insert into npcaction values ( 91307, '','','','' );
insert into npcaction values ( 91308, '','','','' );
-- Create text stuff for entrance to sanctuary
insert into npcaction values ( 91299, '','','','' );
-- Create text stuff for Dicarding spy
insert into npcaction values (91311,'','','','');

-- 2f key needs to be usable
update etcitem set use_type = 'normal' where item_id = 49165;
-- 3f key needs to be usable
update etcitem set use_type = 'normal' where item_id = 49166;
-- Ma's Horn Flute needs to be usable
update etcitem set use_type = 'normal' where item_id = 49167;
-- Will of Destruction to be usable
update etcitem set use_type = 'normal' where item_id = 49239;

-- Update Priest Guignol hp to 2000 from 20000
update npc set hp = 2000 where npcid = 91309;

insert into spawnlist_npc values ( 90562,'Rotting Corpse',1,91308,32774,32772,0,0,6,0,2000,0 );
insert into spawnlist_npc values ( 90566,'Rotting Corpse',1,91307,32808,32749,0,0,3,0,2000,0 );
insert into spawnlist_npc values ( 90571,'Dicarding\'s Spy',1,91311,32923,32980,0,0,5,0,410,0 );

-- Update map to be better
update mapids set startX = 32640, endX = 32959, startY = 32704, endY = 33023 where mapid = 2000;

-- Elf Lv 50 Quest
-- Add droplist 49162 to giant ant cave drops..
update etcitem set name = 'Ancient Dark Elf\'s Secret Text' where item_id = 41962;
insert into droplist values (45115,'Giant Ant',49162,'Ancient Dark Elf\'s Text',1,1,50000 );
insert into droplist values (45190,'Giant Soldier Ant',49162,'Ancient Dark Elf\'s Text',1,1,50000 );

-- Unrelated update, but noticed ant queen is named deathknight in spawnlist table
update spawnlist_boss set location = 'Ant Queen' where npc_id = 45614;

-- find proper spawn location for 91312 ( female dicarding spy )
-- past diad fortress.. near 32839, 32805, 400
insert into spawnlist_npc values ( null, 'Female Spy of Dicarding', 1, 91312, 32840,32804, 0, 0, 5, 0, 400, 10 );

-- Find out how to make priest of chaos(?) with the arms that go underground spawn along the way
-- nice to have

-- Find out how to make npc(91312) arrival to resistance village reward with 49163 ( secret intelligence report )
-- complete

-- altar of reviving did not drop fragment... why?? <----- need to be close to it and drop worked.. ?

-- Royal Lv 50 Quest
update etcitem set name = 'Dantes\' Royal Letter' where item_id = 49160;
insert into droplist values (45481,'Lesser Demon',49159,'Movement Order',1,1,50000 );

-- Create text stuff for Official Kihal
insert into npcaction values (91298,'','','','');
insert into spawnlist_npc values ( null, 'Official Kihal', 1, 49198, 32927,32830, 0, 0, 5, 0, 410, 50 );
update npc set name = 'Official Kihal' where npcid = 49198;

-- Additional nerf for priest of guignol
update npc set ac = -50, mpr = 100, hpr = 100 where npcid = 91309;

-- Knight Lv 50 Quest
-- We'll hijack 45415 as it doesn't currently spawn
insert into droplist values (45415, 'Dark Elf General', 49160, 'Dantes\' Royal Letter', 1, 1, 50000 );
insert into spawnlist values ( null, 'Dark Elf General (Lv 50 Knight Quest )', 10, 45415, 0, 32961, 32714, 20, 20, 0, 0, 0, 0, 0, 45, 90, 400, 0,0,0,0,0,0,0,0 );

-- Unrelated update
update etcitem set name = 'Teleport - Elemental Grave' where item_id = 40855;
update etcitem set name = 'Spirit\'s Whisper', stackable = 1 where item_id = 49161;
insert into droplist values ( 45416,"Fang of Earth", 49161, 'Spirit\'s Whisper', 1, 1, 50000 );
insert into droplist values ( 45418,"Fang of Wind", 49161, 'Spirit\'s Whisper', 1, 1, 50000 );
insert into droplist values ( 45419,"Fang of Glacier", 49161, 'Spirit\'s Whisper', 1, 1, 50000 );
insert into droplist values ( 45424,"Fang of Flame", 49161, 'Spirit\'s Whisper', 1, 1, 50000 );
insert into droplist values ( 45500,"Water Spirit Master", 49161, 'Spirit\'s Whisper', 1, 1, 50000 );
insert into droplist values ( 45508,"Earth Spirit Master", 49161, 'Spirit\'s Whisper', 1, 1, 50000 );
insert into droplist values ( 45510,"Wind Spirit Master", 49161, 'Spirit\'s Whisper', 1, 1, 50000 );
insert into droplist values ( 45511,"Fire Spirit Master", 49161, 'Spirit\'s Whisper', 1, 1, 50000 );
insert into droplist values ( 45591,"Abyss Water Spirit", 49161, 'Spirit\'s Whisper', 1, 1, 50000 );
insert into droplist values ( 45592,"Abyss Earth Spirit", 49161, 'Spirit\'s Whisper', 1, 1, 50000 );
insert into droplist values ( 45593,"Abyss Wind Spirit", 49161, 'Spirit\'s Whisper', 1, 1, 50000 );
insert into droplist values ( 45594,"Abyss Fire Spirit", 49161, 'Spirit\'s Whisper', 1, 1, 50000 );

-- Additional nerf
-- Note for later
-- May want to restrict use of ma's horn to
-- 32805, 32771 2000
-- 32809, 32771 2000
-- 32809, 32775 2000
-- 32805, 32775 2000

-- Remove Scroll of Teleportation - GM Room from GM Shop
DELETE FROM shop WHERE item_id = 42023;

-- Fix incorrect item id for Spirit Defender
UPDATE droplist SET itemId = 450005 WHERE item_name = 'Spirit Defender';

-- Helms of Magic should not be usable by DKs
UPDATE armor SET use_dragonknight = 0 WHERE item_id in (20013,20014,20015);

-- Dragon Knight Lv 50 Quest
insert into droplist values ( 91205, 'Cracked Time', 49229, 'Otherworldly Thought Powder', 1, 1, 150000 );
insert into npc values ( 91204,'Lucius','$1279','Outsider','L1Monster',1773,46,1500,300,-40,20,24,24,22,28,30,2117,-55,'large',4,1,0,960,1640,0,1200,1640,2,0,0,1,1,1,'',0,-1,-1,0,0,0,5000,100,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,-1,0,0,0,0,0);
insert into droplist values ( 91204,'Lucius',49231,'Thought Piece of Lucius',1,1,1000000);

-- Updating incorrectly placed monsters
delete from spawnlist_npc where id in ( 90461, 90462, 90463 );

insert into spawnlist values ( null, 'Cracked Time', 30, 91205, 0, 32825, 32842, 60, 60, 0, 0, 0, 0, 0, 30, 45, 2004, 0,0,0,0,0,0,0,0 );
insert into spawnlist values ( null, 'Wyvern', 12, 91206, 0, 32825, 32842, 60, 60, 0, 0, 0, 0, 0, 30, 45, 2004, 0,0,0,0,0,0,0,0 );
insert into spawnlist values ( null, 'Otyu', 12, 91207, 0, 32825, 32842, 60, 60, 0, 0, 0, 0, 0, 30, 45, 2004, 0,0,0,0,0,0,0,0 );

-- Add Heine Castle door to Sanctuary of Eva entrance
INSERT INTO npc VALUES (71273, 'Gatekeeper', '$474', '', 'L1Guard', 148, 10, 3000, 300, 0, 126, 126, 126, 126, 126, 0, 0, 1800, 'large', 0, 2, 0, 480, 840, 0, 840, 840, 0, 0, 0, 0, 0, 0, 'guard', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 0, 0);
INSERT INTO spawnlist_door VALUES (2043, 'Heine Castle', 1336, 32734, 32790, 62, 0, 71273);
UPDATE dungeon SET src_x = 32734, src_y = 32790 WHERE src_x = 32733 and src_y = 32791 and src_mapid = 62;
INSERT INTO spawnlist_npc VALUES (88229, 'Gatekeeper', 1, 71273, 32734, 32793, 0, 0, 4, 0, 62, 100);

-- Remove aggro from Lindvior.
update npc set agro = 0, agrososc = 0, agrocoi = 0 where npcid = 45681;

-- Set stackable some of the new high droprate quest items.
update etcitem set stackable = 1 where item_id = 49164;
update etcitem set stackable = 1 where item_id = 49162;

-- Fix ettin polymorph's swing speed with axes
update spr_action set framecount = 20 where spr_id = 3633 and act_id = 12;

-- Fix name for Rock of Mental Control
update etcitem set name = 'Rock of Mental Control' where item_id = 40703;

-- Disable (temporarily?) the AOE on Gold Dragon.
-- Change skill area from 2 to 1.
update skills set area = 1 where skill_id = 20005;
-- Change mobskill AreaHeight from 2 to 1.
update mobskill set AreaHeight = 1 where mobid = 46046 and actno = 1;
-- Compensate for nerf with a higher mpr, from 4 to 10 (matching high cat).
update npc set mpr = 10 where npcid = 46046;

-- Fix settings for Official Kiholl.  Was incorrectly named and had wrong npcid.
update spawnlist_npc set location = 'Official Kiholl' where npc_templateid = 49198;
update spawnlist_npc set npc_templateid = 91298 where npc_templateid = 49198;

-- Set stackable Movement Order drop from TOI lesser demons.
update etcitem set stackable = 1 where item_id = 49159;

-- Set area to 0 for Gold Dragon Fire Breath.
update mobskill set AreaWidth = 0, AreaHeight = 0 where mobid = 46046 and actno = 1;
update skills set area = 0 where skill_id = 20005;

-- Reduce TOS 2F spawn by 20%.
update spawnlist set count = 8
       where id in (52300001, 52300002, 52300003, 52300004, 52300005, 52300006);

-- Fix insane regen on Cloak of Training Knight quest mob.
update npc set hpr = 50, mpr = 50 where npcid = 45931;

-- Fix incorrect itemdesc_id for scroll of identify.
update etcitem set itemdesc_id = 22 where item_id = 40126;

-- Update dragon hpr to be closer to live.
update npc set hpr = 1000 where npcid in (45681, 45684, 45683, 45682);

-- Fix incorrect Name ID for Scroll of Teleportation: 2F Magic Training
update etcitem set unidentified_name_id = '$230 - 2F Magic Training' where item_id = 42020;
update etcitem set identified_name_id = '$230 - 2F Magic Training' where item_id = 42020;

-- Reduce number of Kurtz spawns to 5 in Giran DM (was 20).
update spawnlist_ub set count = 5 where id = 279 and npc_templateid = 45600;

-- Fix Black-Light Wing name (was Giant Pumpkin Seed).
update droplist set item_name = 'Black-Light Wing' where mobid = 45526 and itemid = 40720;
update etcitem set name = 'Black-Light Wing' where item_id = 40720;

-- Add 2 candles to starting equipment for all classes, matching live starting
-- gear.
insert into beginner values (19, 40005, 1, 0, 'Candle', 'A', 0, 0);
insert into beginner values (20, 40005, 1, 0, 'Candle', 'A', 0, 0);

-- Reduce spawnrate on TOI 81F.
-- Insolent Zenith Queen, 68->51.
update spawnlist set count = 51
    where npc_templateid = 45581 and mapid = 181 and count = 68;
-- Lesser Seer, 24->18.
update spawnlist set count = 18
    where npc_templateid = 45586 and mapid = 181 and count = 24;
-- Marquise Vampire, 24->18.
update spawnlist set count = 18
    where npc_templateid = 45604 and mapid = 181 and count = 24;
-- Reduce spawnrate on TOI 82F.
-- Insolent Zenith Queen, 62->46.
update spawnlist set count = 46
    where npc_templateid = 45581 and mapid = 182 and count = 62;
-- Lesser Seer, 24->18.
update spawnlist set count = 18
    where npc_templateid = 45586 and mapid = 182 and count = 24;
-- Marquise Vampire, 26->19.
update spawnlist set count = 19
    where npc_templateid = 45604 and mapid = 182 and count = 26;
-- Reduce spawnrate on TOI 83F.
-- Insolent Zenith Queen, 96->72.
update spawnlist set count = 72
    where npc_templateid = 45581 and mapid = 183 and count = 96;
-- Lesser Seer, 22->16.
update spawnlist set count = 16
    where npc_templateid = 45586 and mapid = 183 and count = 22;
-- Zombie Lord of Fear, 14->8.
update spawnlist set count = 8
    where npc_templateid = 45589 and mapid = 183 and count = 14;
-- Reduce spawnrate on TOI 84F.
-- Insolent Zenith Queen, 88->66.
update spawnlist set count = 66
    where npc_templateid = 45581 and mapid = 184 and count = 88;
-- Lesser Seer, 28->21.
update spawnlist set count = 21
    where npc_templateid = 45586 and mapid = 184 and count = 28;
-- Zombie Lord of Fear, 24->18.
update spawnlist set count = 18
    where npc_templateid = 45589 and mapid = 184 and count = 24;
-- Marquise Vampire, 10->8.
update spawnlist set count = 8
    where npc_templateid = 45604 and mapid = 184 and count = 10;
-- Reduce spawnrate on TOI 85F.
-- Lesser Seer, 84->63.
update spawnlist set count = 63
    where npc_templateid = 45586 and mapid = 185  and count = 84;
-- Zombie Lord of Fear, 22->16.
update spawnlist set count = 16
    where npc_templateid = 45589 and mapid = 185 and count = 22;
-- Marquise Vampire, 32->24
update spawnlist set count = 24
    where npc_templateid = 45604 and mapid = 185 and count = 32;
-- Reduce spawnrate on TOI 87F.
-- Insolent Zenith Queen, 70->52
update spawnlist set count = 52
    where npc_templateid = 45581 and mapid = 187 and count = 70;
-- Zombie Lord of Fear, 22->16.
update spawnlist set count = 16
    where npc_templateid = 45589 and mapid = 187 and count = 22;
-- Marquise Vampire, 50->37.
update spawnlist set count = 37
    where npc_templateid = 45604 and mapid = 187 and count = 50;
-- Reduce spawnrate on TOI 88F.
-- Insolent Zenith Queen, 70->52.
update spawnlist set count = 52
    where npc_templateid = 45581 and mapid = 188 and count = 70;
-- Zombie Lord of Fear, 22->16.
update spawnlist set count = 16
    where npc_templateid = 45589 and mapid = 188 and count = 22;
-- Marquise Vampire, 28->21.
update spawnlist set count = 21
    where npc_templateid = 45604 and mapid = 188 and count = 28;
-- Lesser Seer, 28->21.
update spawnlist set count = 21
    where npc_templateid = 45586 and mapid = 188 and count = 28;
-- Reduce spawnrate on TOI 89F.
-- Lesser Seer, 52->38.
update spawnlist set count = 38
    where npc_templateid = 45586 and mapid = 189 and count = 52;
-- Zombie Lord of Fear, 40->39.
update spawnlist set count = 30
    where npc_templateid = 45589 and mapid = 189 and count = 40;
-- Marquise Vampire, 46->34.
update spawnlist set count = 34
    where npc_templateid = 45604 and mapid = 189 and count = 46;
-- Reduce spawnrate on TOI 90F.
-- Lesser Seer, 52->39.
update spawnlist set count = 39
    where npc_templateid = 45586 and mapid = 190 and count = 52;
-- Zombie Lord of Fear, 48->36.
update spawnlist set count = 36
    where npc_templateid = 45589 and mapid = 190 and count = 48;
-- Marquise Vampire, 46->34.
update spawnlist set count = 34
    where npc_templateid = 45604 and mapid = 190 and count = 46;

-- Remove old event item (Pink Unisex Earrings).
delete from armor where item_id = 29002;
-- Just in case anyone had one of these.
delete from character_items where item_id = 29002;
delete from character_warehouse where item_id = 29002;
delete from character_elf_warehouse where item_id = 29002;
delete from clan_warehouse where item_id = 29002;

-- Add new doll etcitem and npc entries.  Still need code support and some very
-- low Arka bag rates.  Research by Zylaxyma.
insert into etcitem values (49289,'Magic Doll: Yeti','$7512','$7512','other','normal','wood',12000,3218,6174,2772,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (49292,'Magic Doll: Scarecrow','$9590','$9590','other','normal','wood',1000,3338,6174,2772,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (49293,'Magic Doll: Cockatrice','$7511','$7511','other','normal','wood',12000,3337,6174,2772,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into npc values (80153,'Yeti Magic Doll','$6416','','L1Doll',6480,1,1,1,1,1,1,1,1,1,1,0,0,'small',0,0,0,320,0,0,1000,1000,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,0,0);
insert into npc values (80156,'Scarecrow Magic Doll','$9591','','L1Doll',7050,1,1,1,1,1,1,1,1,1,1,0,0,'small',0,0,0,320,0,0,1000,1000,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,0,0);
insert into npc values (80157,'Cockatrice Magic Doll','$7510','','L1Doll',7047,1,1,1,1,1,1,1,1,1,1,0,0,'small',0,0,0,320,0,0,1000,1000,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,0,0);

-- Make stackable cursed black earrings (all 3 base types), ring of dark
-- forester, ring of beast summoner, and ring of black wizard.
update etcitem set stackable = 1 where item_id in (40987, 40988, 40989, 40426, 40446, 40452);

-- Increase respawn delay for all normal spawn on 81-90F.
update spawnlist set min_respawn_delay = 120, max_respawn_delay = 180 where mapid >= 181 and mapid <= 190;

-- Add character_excludes table to prep for /exclude persistence
-- schema the same as character_buddys
CREATE TABLE `character_excludes` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `char_id` int(10) NOT NULL DEFAULT '0',
  `exclude_id` int(10) unsigned NOT NULL DEFAULT '0',
  `exclude_name` varchar(45) NOT NULL,
  PRIMARY KEY (`char_id`,`exclude_id`),
  KEY `key_id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=868 DEFAULT CHARSET=utf8 COMMENT='MyISAM free: 10240 kB; MyISAM free: 10240 kB';

-- Remove TOS keys from shop.
delete from shop where item_id in (40615, 40616, 40782, 40783);

-- Set Secret Room Key to stackable
update etcitem set stackable = 1 where item_id = 40555;

-- Fix name of Robe of Dread Queen (was Robe of Evil Spirit King).
update armor set name = 'Robe of Dread Queen' where item_id = 20109;
update droplist set item_name = 'Robe of Dread Queen' where itemid = 20109;
