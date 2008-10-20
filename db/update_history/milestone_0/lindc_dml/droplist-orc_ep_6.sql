-- Update 19

-- fix name for Polluted Mane
update etcitem set name = 'Polluted Mane' where item_id = 41069;

-- fix name for Orc Bag
update etcitem set name = 'Orc Bag' where item_id = 41110;

-- fix name for Polluted Water
update etcitem set name = 'Polluted Water' where item_id = 41077;

-- fix name for Polluted Fire
update etcitem set name = 'Polluted Fire' where item_id = 41078;

-- fix name for Polluted Earth
update etcitem set name = 'Polluted Earth' where item_id = 41076;

-- fix name for Polluted Air
update etcitem set name = 'Polluted Air' where item_id = 41079;

-- fix name for Canine Necklace
update etcitem set name = 'Canine Necklace' where item_id = 41082;

-- fix name for Polluted Spirit
update etcitem set name = 'Polluted Spirit' where item_id = 41080;

-- fix name for Silver Candlestick
update etcitem set name = 'Silver Candlestick' where item_id = 41072;

-- fix name for Bandit Bag
update etcitem set name = 'Bandit Bag' where item_id = 41074;

-- fix name for Polluted Hair
update etcitem set name = 'Polluted Hair' where item_id = 41075;

-- fix name for Silver Dish
update etcitem set name = 'Silver Dish' where item_id = 41071;

-- fix name for Roots
update etcitem set name = 'Roots' where item_id = 41086;

-- fix name for Bark
update etcitem set name = 'Bark' where item_id = 41087;

-- fix name for Leaves
update etcitem set name = 'Leaves' where item_id = 41088;

-- fix name for Branch
update etcitem set name = 'Branch' where item_id = 41089;

-- fix name for Orc Tooth
update etcitem set name = 'Orc Tooth' where item_id = 41081;

-- fix name for Key of Bandit
update etcitem set name = 'Key of Bandit' where item_id = 41073;

-- fix name for Polluted Fairy Wings
update etcitem set name = 'Polluted Fairy Wings' where item_id = 41070;

-- fix name for Polluted Elf
update npc set name = 'Polluted Elf' where npcid = 45773;

-- fix name for Pearl of Prophet
update etcitem set name = 'Pearl of Prophet' where item_id = 41085;

-- Add drops to Polluted Pan
-- Add Haste potion to Droplist
insert into droplist values (45776, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45776, 40308, 292, 470, 1000000);
-- Add Polluted Mane to Droplist
insert into droplist values (45776, 41069, 1, 1, 30000);

-- Add drops to Polluted Water Spirit
-- Add Haste potion to Droplist
insert into droplist values (45788, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45788, 40308, 310, 500, 1000000);
-- Add Ring of Water to Droplist
insert into droplist values (45788, 20285, 1, 1, 2000);
-- Add Polluted Water to Droplist
insert into droplist values (45788, 41077, 1, 1, 30000);

-- Add drops to Polluted Orc (Axe)
-- Add Haste potion to Droplist
insert into droplist values (45791, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45791, 40308, 265, 429, 1000000);
-- Add Orc Bag
insert into droplist values (45791, 41110, 1, 1, 15000);

-- Add drops to Polluted Earth Spirit
-- Add Haste potion to Droplist
insert into droplist values (45785, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45785, 40308, 310, 500, 1000000);
-- Add Ring of Earth to Droplist
insert into droplist values (45785, 20300, 1, 1, 2000);
-- Add Polluted Earth to Droplist
insert into droplist values (45785, 41076, 1, 1, 30000);

-- Add drops to Polluted Fang
-- Add Haste potion to Droplist
insert into droplist values (45784, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45784, 40308, 265, 429, 1000000);
-- Add Polluted Spirit to Droplist
insert into droplist values (45784, 41080, 1, 1, 30000);

-- Add drops to Polluted Human (Axe)
-- Add Haste potion to Droplist
insert into droplist values (45781, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45781, 40308, 265, 429, 1000000);
-- Add Polluted Hair to Droplist
insert into droplist values (45781, 41075, 1, 1, 30000);
-- Add Silver Candlestick to Droplist
insert into droplist values (45781, 41072, 1, 1, 30000);
-- Add Bandit Bag to Droplist
insert into droplist values (45781, 41074, 1, 1, 15000);

-- Add drops to Polluted Orc (Fighter)
-- Add Haste potion to Droplist
insert into droplist values (81072, 40013, 1, 1, 15000);
-- Add Canine Necklace
insert into droplist values (81072, 41082, 1, 1, 1000);
-- Add Orc Bag
insert into droplist values (81072, 41110, 1, 1, 15000);

-- Add drops to Polluted Arachne
-- Add Haste potion to Droplist
insert into droplist values (45777, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45777, 40308, 292, 470, 1000000);

-- Add drops to Polluted Orc (Spearman)
-- Add Haste potion to Droplist
insert into droplist values (81074, 40013, 1, 1, 15000);
-- Add Pearl's Prophet to Droplist
insert into droplist values (81074, 41085, 1, 1, 30000);
-- Add Orc Bag
insert into droplist values (81074, 41110, 1, 1, 15000);

-- Add drops to Polluted Orc (Spearman)
-- Add Haste potion to Droplist
insert into droplist values (45793, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45793, 40308, 292, 470, 1000000);
-- Add Pearl's Prophet to Droplist
insert into droplist values (45793, 41085, 1, 1, 30000);
-- Add Orc Bag
insert into droplist values (45793, 41110, 1, 1, 15000);

-- Add drops to Polluted Fire Spirit
-- Add Haste potion to Droplist
insert into droplist values (45786, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45786, 40308, 310, 500, 1000000);
-- Add Ring of Fire to Droplist
insert into droplist values (45786, 20304, 1, 1, 1000);
-- Add Polluted Fire to Droplist
insert into droplist values (45786, 41078, 1, 1, 30000);

-- Add drops to Polluted Air Spirit
-- Add Haste potion to Droplist
insert into droplist values (45787, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45787, 40308, 310, 500, 1000000);
-- Add Ring of Air to Droplist
insert into droplist values (45787, 20302, 1, 1, 1000);
-- Add Polluted Air to Droplist
insert into droplist values (45787, 41079, 1, 1, 30000);

-- Add drops to Polluted Human (Bowman)
-- Add Haste potion to Droplist
insert into droplist values (45780, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45780, 40308, 265, 429, 1000000);
-- Add Polluted Hair to Droplist
insert into droplist values (45780, 41075, 1, 1, 30000);
-- Add Bandit Bag to Droplist
insert into droplist values (45780, 41074, 1, 1, 15000);
-- Add Silver Dish to Droplist
insert into droplist values (45780, 41071, 1, 1, 15000);

-- Add drops to Polluted Spirit
-- Add Cure Pot potion to Droplist
insert into droplist values (45794, 40017, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45794, 40308, 292, 470, 1000000);
-- Add Roots to Droplist
insert into droplist values (45794, 41086, 1, 1, 30000);
-- Add Bark to Droplist
insert into droplist values (45794, 41087, 1, 1, 30000);
-- Add Leaves to Droplist
insert into droplist values (45794, 41088, 1, 1, 30000);
-- Add Branch to Droplist
insert into droplist values (45794, 41089, 1, 1, 30000);

-- Add drops to Polluted Orc Archer
-- Add Haste potion to Droplist
insert into droplist values (45790, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45790, 40308, 265, 429, 1000000);
-- Add Orc Bag
insert into droplist values (45790, 41110, 1, 1, 15000);
 
-- Add drops to Polluted Ent
-- Add Cure Pot potion to Droplist
insert into droplist values (45774, 40017, 1, 1, 15000);
-- Add Haste potion to Droplist
insert into droplist values (45774, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45774, 40308, 265, 429, 1000000);
-- Add Polluted Branches to Droplist
insert into droplist values (45774, 41067, 1, 1, 15000);
-- Add Fruit of Ent to Droplist
insert into droplist values (45774, 40506, 1, 1, 30000);

-- Add drops to Polluted Deep Flower
-- Add Haste potion to Droplist
insert into droplist values (45775, 40013, 1, 1, 15000);
-- Add Adena to Droplist
insert into droplist values (45775, 40308, 265, 429, 1000000);
-- Add Polluted Roots to Droplist
insert into droplist values (45775, 41066, 1, 1, 15000);

-- Add drops to Polluted Fairy
-- Add Adena to Droplist
insert into droplist values (45771, 40308, 265, 429, 1000000);
-- Add Polluted Fairy Wings to Droplist
insert into droplist values (45771, 41070, 1, 1, 15000);

-- Add drops to Polluted Human (Sword)
-- Add Adena to Droplist
insert into droplist values (45779, 40308, 265, 429, 1000000);
-- Add Haste potion to Droplist
insert into droplist values (45779, 40013, 1, 1, 15000);
-- Add Polluted Hair to Droplist
insert into droplist values (45779, 41075, 1, 1, 30000);
-- Add Bandit Bag to Droplist
insert into droplist values (45779, 41074, 1, 1, 15000);

-- Add drops to Polluted Orc Mage
-- Add Adena to Droplist
insert into droplist values (45770, 40308, 229, 310, 1000000);
-- Add Staff of Force to Droplist
insert into droplist values (45770, 131, 1, 1, 10000);
-- Add Mage Staff to Droplist
insert into droplist values (45770, 129, 1, 1, 30000);
-- Add Oak Staff to Droplist
insert into droplist values (45770, 128, 1, 1, 50000);

-- Add drops to Polluted Ghost
-- Add Adena to Droplist
insert into droplist values (45722, 40308, 229, 310, 1000000);
-- Add Polluted Spirit to Droplist
insert into droplist values (45722, 41080, 1, 1, 30000);

-- Add drops to Polluted Human (Mace)
-- Add Adena to Droplist
insert into droplist values (45778, 40308, 265, 429, 1000000);
-- Add Haste potion to Droplist
insert into droplist values (45778, 40013, 1, 1, 15000);
-- Add Polluted Hair to Droplist
insert into droplist values (45778, 41075, 1, 1, 30000);
-- Add Bandit Bag to Droplist
insert into droplist values (45778, 41074, 1, 1, 15000);
-- Add Bandit Key
insert into droplist values (45778, 41073, 1, 1, 15000);

-- Add drops to Polluted Elf
-- Add Adena to Droplist
insert into droplist values (45773, 40308, 265, 429, 1000000);
-- Add Polluted Fairy Wings to Droplist
insert into droplist values (45773, 41070, 1, 1, 15000);
-- Add ROPC to Droplist
insert into droplist values (45773, 20281, 1, 1, 5000);
-- Add Haste potion to Droplist
insert into droplist values (45773, 40013, 1, 1, 15000);

-- Add drops to Polluted Orc
-- Add Haste potion to Droplist
insert into droplist values (81071, 40013, 1, 1, 15000);
-- Add Orc Tooth to Droplist
insert into droplist values (81071, 41081, 1, 1, 30000);
-- Add Orc Bag
insert into droplist values (81071, 41110, 1, 1, 15000);

-- Add drops to Polluted Orc Soldier (Level 51 Boss)
-- Add Adena to Droplist
insert into droplist values (45772, 40308, 20000, 50000, 1000000);
-- Add Haste potion to Droplist
insert into droplist values (45772, 40013, 1, 1, 150000);
-- Add Orc Tooth to Droplist
insert into droplist values (45772, 41081, 1, 1, 30000);
-- Add Orc Bag
insert into droplist values (45772, 41110, 1, 1, 15000);
-- Add Pearl's Prophet to Droplist
insert into droplist values (45772, 41085, 1, 1, 30000);
-- Add NDai to Droplist
insert into droplist values (45772, 41087, 1, 1, 300000);
-- Add BDai to Droplist
insert into droplist values (45772, 140087, 1, 1, 130000);
-- Add NZel to Droplist
insert into droplist values (45772, 41074, 1, 1, 300000);
-- Add BZel to Droplist
insert into droplist values (45772, 140074, 1, 1, 130000);
-- Add Orc Amulet to Droplist
insert into droplist values (45772, 20263, 1, 1, 15000);

-- Add drops to Polluted Shujing (Level 65 Boss)
-- Add Adena to Droplist
insert into droplist values (45795, 40308, 32000, 64000, 1000000);
-- Add Haste potion to Droplist
insert into droplist values (45795, 41085, 1, 1, 300000);
-- Add NDai to Droplist
insert into droplist values (45795, 40013, 1, 1, 400000);
-- Add BDai to Droplist
insert into droplist values (45795, 140087, 1, 1, 300000);
-- Add NZel to Droplist
insert into droplist values (45795, 41074, 1, 1, 400000);
-- Add BZel to Droplist
insert into droplist values (45795, 140074, 1, 1, 300000);
-- Add Roots to Droplist
insert into droplist values (45795, 41086, 1, 1, 150000);
-- Add Bark to Droplist
insert into droplist values (45795, 41087, 1, 1, 150000);
-- Add Leaves to Droplist
insert into droplist values (45795, 41088, 1, 1, 150000);
-- Add Branch to Droplist
insert into droplist values (45795, 41089, 1, 1, 150000);
-- Add Iron Skin to Droplist
insert into droplist values (45795, 40251, 1, 1, 75000);
-- Add Entangle to Droplist
insert into droplist values (45795, 40248, 1, 1, 10000);
-- Add Exotic Vitalize
insert into droplist values (45795, 40252, 1, 1, 75000);
-- Add Wind Walk
insert into droplist values (45795, 40261, 1, 1, 75000);
-- Add Full Heal
insert into droplist values (45795, 40202, 1, 1, 50000);
-- Add Invisible
insert into droplist values (45795, 40205, 1, 1, 10000);
-- Add Erase Magic
insert into droplist values (45795, 40242, 1, 1, 50000);
-- Add Cure Pot potion to Droplist
insert into droplist values (45795, 40017, 1, 1, 250000);
