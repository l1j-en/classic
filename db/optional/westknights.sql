-- Westknights has a number of secret db changes (a couple of added drops); this
-- is for public tweaks that other servers might want.

-- skill durations
update skills set stack_limit=6 where name="HolyWalk";

-- skill targets
update skills set target_to=24 where name="NaturesBlessing";
update skills set target_to=12 where name="Brave Aura" or name="Shining Aura" or name="Glowing Aura";

-- item stacking
update etcitem set stackable=1 where name like "%dragon tablet%";
update etcitem set stackable=1 where name like "%memory crystal%"; 
update etcitem set stackable=1 where name like "%spellbook%"; 
update etcitem set stackable=1 where name like "%spirit crystal%"; 
update etcitem set stackable=1 where name like "%dark spirit crystal%"; 
update etcitem set stackable=1 where name like "%technicaldocument%"; 
update etcitem set stackable=1 where name="Crystal Ball of Necromancer";
update etcitem set stackable=1 where item_id=41243 or item_id=41244; -- lasta boxes
update etcitem set stackable=1 where item_id in (40031, 40131, 40132, 40133, 40134, 40135, 41090, 41091, 41092, 40329, 140329); -- orc totems and native totems

-- dk/kurtz sets usable by all
-- if you had early custom armor then use
-- update armor set use_dragonknight=1, use_illusionist=1, use_darkelf=1, use_mage=1, use_elf=1, use_knight=1, use_royal=1 where name like "%kurtz%" or name like "%death knight%";
update armor set use_dragonknight=1, use_illusionist=1, use_darkelf=1, use_mage=1, use_elf=1, use_knight=1, use_royal=1 where item_id=20010 or item_id=20041 or item_id=20100 or item_id=20150 or item_id=20166 or item_id=20184 or item_id=20198 or item_id=20214;

-- On live the accessory and elemental enchant scrolls were sold by an NPC in
-- Aden. Here we're opting to have them dropped by bosses and spirits.

-- Accessory Enchant Scrolls
insert into droplist values 
	(45640, "Unicorn", 49148, "Scroll of Enchant Accessory", 1, 1, 20000),
	(45456, "Necromancer", 49148, "Scroll of Enchant Accessory", 1, 1, 15000),
	(45464, "Sema", 49148, "Scroll of Enchant Accessory", 1, 1, 13000),
	(45473, "Baltuzar", 49148, "Scroll of Enchant Accessory", 1, 1, 15000),
	(45488, "Caspa", 49148, "Scroll of Enchant Accessory", 1, 1, 12500),
	(45497, "Merkyor", 49148, "Scroll of Enchant Accessory", 1, 1, 14500),
	(81081, "Elindaire", 49148, "Scroll of Enchant Accessory", 1, 1, 16250),
	(45513, "Zenith Queen", 49148, "Scroll of Enchant Accessory", 1, 1, 21000),
	(45516, "Ifrit", 49148, "Scroll of Enchant Accessory", 1, 1, 2000),
	(45529, "Drake", 49148, "Scroll of Enchant Accessory", 1, 1, 29250),
	(45547, "Seer", 49148, "Scroll of Enchant Accessory", 1, 1, 300000),
	(45546, "Doppelganger", 49148, "Scroll of Enchant Accessory", 1, 1, 52500),
	(45228, "Sea Dancer", 49148, "Scroll of Enchant Accessory", 1, 1, 40000),
	(45573, "Baphomet", 49148, "Scroll of Enchant Accessory", 1, 1, 200000),
	(45581, "Insolent Zenith Queen", 49148, "Scroll of Enchant Accessory", 1, 1, 8000),
	(45772, "Polluted Orc Hunter", 49148, "Scroll of Enchant Accessory", 1, 1, 50000),
	(45583, "Beleth", 49148, "Scroll of Enchant Accessory", 1, 1, 175000),
	(45584, "Greater Minotaur", 49148, "Scroll of Enchant Accessory", 1, 1, 107500),
	(45586, "Lesser Seer", 49148, "Scroll of Enchant Accessory", 1, 1, 7500),
	(45590, "Reaper", 49148, "Scroll of Enchant Accessory", 1, 1, 16000),
	(45600, "Kurtz", 49148, "Scroll of Enchant Accessory", 1, 2, 400000),
	(45601, "Death Knight", 49148, "Scroll of Enchant Accessory", 1, 1, 300000),
	(45604, "Marquise Vampire", 49148, "Scroll of Enchant Accessory", 1, 1, 6000),
	(45316, "Giran Ancient Giant", 49148, "Scroll of Enchant Accessory", 1, 1, 37500),
	(45610, "Ancient Giant", 49148, "Scroll of Enchant Accessory", 1, 1, 300000),
	(45606, "Vampire", 49148, "Scroll of Enchant Accessory", 1, 1, 137500),
	(45609, "Ice Queen", 49148, "Scroll of Enchant Accessory", 1, 1, 225000),
	(45614, "Giant Ant Queen", 49148, "Scroll of Enchant Accessory", 1, 1, 300000),
	(45734, "Great King Squid", 49148, "Scroll of Enchant Accessory", 1, 1, 10000),
	(45617, "Phoenix", 49148, "Scroll of Enchant Accessory", 1, 2, 250000),
	(45595, "Iris", 49148, "Scroll of Enchant Accessory", 1, 1, 9000),
	(45664, "Knight Vald", 49148, "Scroll of Enchant Accessory", 1, 1, 11000),
	(45616, "Mummy Lord", 49148, "Scroll of Enchant Accessory", 1, 1, 10000),
	(46026, "Mammon", 49148, "Scroll of Enchant Accessory", 1, 1, 10000),
	(45649, "Demon", 49148, "Scroll of Enchant Accessory", 1, 1, 300000),
	(45650, "Zombie Lord", 49148, "Scroll of Enchant Accessory", 1, 1, 250000),
	(45652, "Cougar", 49148, "Scroll of Enchant Accessory", 1, 1, 300000),
	(45653, "Mummy Lord", 49148, "Scroll of Enchant Accessory", 1, 1, 300000),
	(45654, "Iris", 49148, "Scroll of Enchant Accessory", 1, 2, 300000),
	(45795, "Spirit", 49148, "Scroll of Enchant Accessory", 1, 1, 40000),
	(45618, "Knight Vald", 49148, "Scroll of Enchant Accessory", 1, 2, 225000),
	(45671, "Ariorc", 49148, "Scroll of Enchant Accessory", 1, 2, 225000),
	(45944, "Gian Worm", 49148, "Scroll of Enchant Accessory", 1, 1, 5000),
	(45672, "Lich", 49148, "Scroll of Enchant Accessory", 1, 2, 300000),
	(45673, "Grim Reaper", 49148, "Scroll of Enchant Accessory", 1, 3, 300000),
	(46037, "Dark Wizard Maya", 49148, "Scroll of Enchant Accessory", 1, 1, 5000),
	(45829, "Barbados", 49148, "Scroll of Enchant Accessory", 1, 1, 10000),
	(45678, "Cerenis", 49148, "Scroll of Enchant Accessory", 1, 1, 180000),
	(45680, "Ken Rauhel", 49148, "Scroll of Enchant Accessory", 1, 1, 300000),
	(45681, "Lindvior", 49148, "Scroll of Enchant Accessory", 1, 3, 225000),
	(45682, "Antharas", 49148, "Scroll of Enchant Accessory", 1, 3, 225000),
	(45683, "Fafurion", 49148, "Scroll of Enchant Accessory", 1, 3, 225000),
	(45684, "Valakas", 49148, "Scroll of Enchant Accessory", 1, 3, 225000),
	(81163, "Girtas", 49148, "Scroll of Enchant Accessory", 1, 3, 300000);

-- Elemental Enchant Scrolls
insert into droplist values 
	(45619, "Great Spirit of Earth", 41430, "Scroll of Enchant Weapon: Earth", 1, 1, 18000),
	(45620, "Great Spirit of Water", 41431, "Scroll of Enchant Weapon: Water", 1, 1, 18000),
	(45621, "Great Spirit of Wind", 41429, "Scroll of Enchant Weapon: Wind", 1, 1, 18000),
	(45622, "Great Spirit of Fire", 41432, "Scroll of Enchant Weapon: Fire", 1, 1, 18000),
	(45642, "Great Spirit of Earth", 41430, "Scroll of Enchant Weapon: Earth", 1, 1, 75000),
	(45643, "Great Spirit of Water", 41431, "Scroll of Enchant Weapon: Water", 1, 1, 75000),
	(45644, "Great Spirit of Wind", 41429, "Scroll of Enchant Weapon: Wind", 1, 1, 75000),
	(45645, "Great Spirit of Fire", 41432, "Scroll of Enchant Weapon: Fire", 1, 1, 75000),
	(45681, "Lindvior", 41429, "Scroll of Enchant Weapon: Wind", 3, 6, 300000),
	(45682, "Antharas", 41430, "Scroll of Enchant Weapon: Earth", 3, 6, 300000),
	(45683, "Fafurion", 41431, "Scroll of Enchant Weapon: Water", 3, 6, 300000),
	(45684, "Valakas", 41432, "Scroll of Enchant Weapon: Fire", 3, 6, 300000),
	(45795, "Spirit", 41430, "Scroll of Enchant Weapon: Earth", 1, 1, 80000),
	(45649, "Demon", 41432, "Scroll of Enchant Weapon: Fire", 1, 1, 100000),
	(45944, "Giant Worm", 41430, "Scroll of Enchant Weapon: Earth", 1, 1, 70000),
	(45610, "Ancient Giant", 41430, "Scroll of Enchant Weapon: Earth", 1, 1, 80000),
	(45606, "Vampire", 41430, "Scroll of Enchant Weapon: Earth", 1, 1, 130000),
	(45609, "Ice Queen", 41431, "Scroll of Enchant Weapon: Water", 1, 2, 300000),
	(45614, "Giant Ant Queen", 41430, "Scroll of Enchant Weapon: Earth", 1, 2, 300000),
	(45734, "Great King Squid", 41431, "Scroll of Enchant Weapon: Water", 1, 2, 40000),
	(45617, "Phoenix", 41432, "Scroll of Enchant Weapon: Fire", 1, 2, 250000),
	(45516, "Ifrit", 41432, "Scroll of Enchant Weapon: Fire", 1, 1, 90000),
	(45529, "Drake", 41429, "Scroll of Enchant Weapon: Wind", 1, 1, 80000),
	(45546, "Doppelganger", 41429, "Scroll of Enchant Weapon: Wind", 1, 1, 60000),
	(45573, "Baphomet", 41430, "Scroll of Enchant Weapon: Earth", 1, 1, 120000),
	(45583, "Beleth", 41430, "Scroll of Enchant Weapon: Earth", 1, 1, 160000),
	(45584, "Greater Minotaur", 41430, "Scroll of Enchant Weapon: Earth", 1, 1, 180000),
	(45590, "Reaper", 41430, "Scroll of Enchant Weapon: Earth", 1, 1, 16000),
	(45601, "Death Knight", 41430, "Scroll of Enchant Weapon: Earth", 1, 1, 240000),
	(45500, "Water Spirit Master", 41431, "Scroll of Enchant Weapon: Water", 1, 1, 7000),
	(45508, "Earth Spirit Master", 41430, "Scroll of Enchant Weapon: Earth", 1, 1, 7000),
	(45510, "Wind Spirit Master", 41429, "Scroll of Enchant Weapon: Wind", 1, 1, 7000),
	(45511, "Fire Spirit Master", 41432, "Scroll of Enchant Weapon: Fire", 1, 1, 7000),
	(45591, "Abyss Water Spirit", 41431, "Scroll of Enchant Weapon: Water", 1, 1, 9000),
	(45592, "Abyss Earth Spirit", 41430, "Scroll of Enchant Weapon: Earth", 1, 1, 9000),
	(45593, "Abyss Wind Spirit", 41429, "Scroll of Enchant Weapon: Wind", 1, 1, 9000),
	(45594, "Abyss Fire Spirit", 41432, "Scroll of Enchant Weapon: Fire", 1, 1, 9000);

-- Make Ivory Tower rings unenchantable.
update armor set grade=-1 where item_id=20282;

-- Teleportation scrolls added to Melissa in Aden
DELETE FROM `shop` where npc_id = 70052 and item_id in (40118, 40120, 40856, 40808, 42017, 42007, 40816, 42039, 42038, 42037, 42036, 42035, 42033, 42032, 42031, 42030, 42011, 42020, 40855, 40819, 42021, 42083, 40084, 40827, 42056);
INSERT INTO `shop` VALUES
	(70052, 'Melissa', 40118, 'Scroll of Return - Recluse Village', 30, 6250, 0, -1),
	(70052, 'Melissa', 40120, 'Scroll of Return - Resistance Village', 31, 6250, 0, -1),
	(70052, 'Melissa', 40856, 'Teleport - Pirate Island', 32, 6250, 0, -1),
	(70052, 'Melissa', 40808, 'Teleport - Heine Dungeon 4F', 33, 12500, 0, -1),
	(70052, 'Melissa', 42017, 'Teleport - Dream Island', 34, 62500, 0, -1),
	(70052, 'Melissa', 42007, 'Teleport - Forgotten Island', 35, 125000, 0, -1),
	(70052, 'Melissa', 40816, 'Teleport - Beleth', 36, 250000, 0, -1),
	(70052, 'Melissa', 42039, 'Teleport - TOI 10F', 37, 125000, 0, -1),
	(70052, 'Melissa', 42038, 'Teleport - TOI 20F', 38, 250000, 0, -1),
	(70052, 'Melissa', 42037, 'Teleport - TOI 30F', 39, 375000, 0, -1),
	(70052, 'Melissa', 42036, 'Teleport - TOI 40F', 40, 500000, 0, -1),
	(70052, 'Melissa', 42035, 'Teleport - TOI 50F', 41, 625000, 0, -1),
	(70052, 'Melissa', 42033, 'Teleport - TOI 60F', 42, 750000, 0, -1),
	(70052, 'Melissa', 42032, 'Teleport - TOI 70F', 43, 875000, 0, -1),
	(70052, 'Melissa', 42031, 'Teleport - TOI 80F', 44, 1000000, 0, -1),
	(70052, 'Melissa', 42030, 'Teleport - TOI 90F', 45, 1125000, 0, -1),
	(70052, 'Melissa', 42011, 'Teleport - 1F Meeting Area', 46, 250000, 0, -1),
	(70052, 'Melissa', 42020, 'Teleport - 2F Magic Training', 47, 500000, 0, -1),
	(70052, 'Melissa', 40855, 'Teleport - Abyss Lake', 48, 250000, 0, -1),
	(70052, 'Melissa', 40819, 'Teleport - Ant Cave 3F', 49, 750000, 0, -1),
	(70052, 'Melissa', 42021, 'Teleport - Giant`s Grave', 50, 250000, 0, -1),
	(70052, 'Melissa', 42083, 'Teleport - Losus Island', 51, 6250, 0, -1),
	(70052, 'Melissa', 40084, 'Teleport - Diad Fortress', 52, 250000, 0, -1),
	(70052, 'Melissa', 40827, 'Teleport - Giran Dungeonn 2F', 53, 12500, 0, -1),
	(70052, 'Melissa', 42056, 'Teleport - Giran Hidden Dungeon', 54, 62500, 0, -1);

-- Candle of Reminiscence and doll quest items added to Luth in Gludio
DELETE FROM `shop` where npc_id = 70021 and item_id in (49142, 41251, 41252, 41253, 41254);
INSERT INTO `shop` VALUES
	(70021, 'Luth', 49142, 'Candle of Reminiscence', 40, 10000000, 0, -1),
	(70021, 'Luth', 41251, 'Skeleton Grail', 41, 10000000, 0, -1),
	(70021, 'Luth', 41252, 'Rare Turtle', 42, 10000000, 0, -1),
	(70021, 'Luth', 41253, 'Spices of the Castle Chef', 43, 10000000, 0, -1),
	(70021, 'Luth', 41254, 'Seal of Victory', 44, 10000000, 0, -1);

-- c- and b- zels/dais and wafers / devil's blood added to Verita in Giran
DELETE FROM `shop` where npc_id = 70033 and item_id in (240074, 140074, 240087, 140087, 40068);
INSERT INTO `shop` VALUES
	(70033, 'Verita', 240074, 'Cursed Scroll of Enchant Armor', 40, 125000, 0, -1),
	(70033, 'Verita', 140074, 'Blessed Scroll of Enchant Armor', 41, 400000, 0, -1),
	(70033, 'Verita', 240087, 'Cursed Scroll of Enchant Weapon', 42, 125000, 0, -1),
	(70033, 'Verita', 140087, 'Blessed Scroll of Enchant Weapon', 43, 400000, 0, -1),
	(70033, 'Verita', 40068, 'Elven Wafer', 44, 3000, 0, -1),
	(70033, 'Verita', 40031, 'Devils Blood', 45, 3000, 0, -1);

-- Stat elixirs added to Britt in Heine
DELETE FROM `shop` where npc_id = 70082 and item_id in (40033, 40034, 40035, 40036, 40037, 40038);
INSERT INTO `shop` VALUES
	(70082, 'Britt', 40033, 'Elixer (STR)', 40, 60000000, 0, -1),
	(70082, 'Britt', 40034, 'Elixer (CON)', 41, 60000000, 0, -1),
	(70082, 'Britt', 40035, 'Elixer (DEX)', 42, 60000000, 0, -1),
	(70082, 'Britt', 40036, 'Elixer (INT)', 43, 60000000, 0, -1),
	(70082, 'Britt', 40037, 'Elixer (WIS)', 44, 60000000, 0, -1),
	(70082, 'Britt', 40038, 'Elixer (CHA)', 45, 60000000, 0, -1);

-- Various materials added to Mellin in SKT
DELETE FROM `shop` where npc_id = 70074 and item_id in (40408, 40496, 40320, 40321, 40505, 40519, 40503, 40507);
INSERT INTO `shop` VALUES
	(70074, 'Mellin', 40408, 'Lump of Iron', 40, 1250, 0, -1),
	(70074, 'Mellin', 40496, 'Rough Mithril', 41, 3000, 0, -1),
	(70074, 'Mellin', 40320, 'Bring Stone', 42, 1250, 0, -1),
	(70074, 'Mellin', 40321, 'Dark Stone', 43, 5000, 0, -1),
	(70074, 'Mellin', 40505, 'Bark of Ent', 44, 3000, 0, -1),
	(70074, 'Mellin', 40519, 'Pans Mane', 45, 1500, 0, -1),
	(70074, 'Mellin', 40503, 'Web of Arachne', 46, 4000, 0, -1),
	(70074, 'Mellin', 40507, 'Twig of Ent', 47, 500, 0, -1);

-- Quest items added to Mandra in Oren
DELETE FROM `shop` where npc_id = 70061 and item_id in (20027, 20230, 20318, 20226, 115, 20055, 20021, 20039, 20084, 20171, 20004, 20164, 20195, 20065, 20051, 20287, 56, 50, 184, 51, 20225, 13, 33, 178, 118, 20234, 127, 20167, 269, 21101, 30011, 270, 275, 21103, 21102, 272);
INSERT INTO `shop` VALUES
	(70061, 'Mandra', 20027, 'Red Knights Hood', 40, 500000, 0, -1),
	(70061, 'Mandra', 20230, 'Shield of Red Knight', 41, 1500000, 0, -1),
	(70061, 'Mandra', 20318, 'Belt of Bravery', 42, 5000000, 0, -1),
	(70061, 'Mandra', 20226, 'Book of Magic Powers', 43, 500000, 0, -1),
	(70061, 'Mandra', 115, 'Crystal Staff', 44, 1500000, 0, -1),
	(70061, 'Mandra', 20055, 'Cloak of Mana', 45, 5000000, 0, -1),
	(70061, 'Mandra', 20021, 'Elven Helm of Dexterity', 46, 500000, 0, -1),
	(70061, 'Mandra', 20039, 'Elven Helm of Constitution', 47, 500000, 0, -1),
	(70061, 'Mandra', 20084, 'Elven T-Shirt', 48, 1500000, 0, -1),
	(70061, 'Mandra', 20171, 'Gloves of Protection', 49, 5000000, 0, -1),
	(70061, 'Mandra', 20004, 'Shadow Mask', 50, 500000, 0, -1),
	(70061, 'Mandra', 20164, 'Shadow Gloves', 51, 1500000, 0, -1),
	(70061, 'Mandra', 20195, 'Shadow Boots', 52, 5000000, 0, -1),
	(70061, 'Mandra', 20065, 'Red Cloak', 53, 500000, 0, -1),
	(70061, 'Mandra', 20051, 'Soverigns Majesty', 54, 1500000, 0, -1),
	(70061, 'Mandra', 20287, 'Ring of Gaurdian', 55, 5000000, 0, -1),
	(70061, 'Mandra', 56, 'Death Blade', 56, 15000000, 0, -1),
	(70061, 'Mandra', 50, 'Sword of Flames', 57, 15000000, 0, -1),
	(70061, 'Mandra', 184, 'Bow of Flames', 58, 15000000, 0, -1),
	(70061, 'Mandra', 51, 'Gold Scepter', 59, 15000000, 0, -1),
	(70061, 'Mandra', 20225, 'Mana Crystal Ball', 60, 15000000, 0, -1),
	(70061, 'Mandra', 13, 'Finger of Death', 61, 15000000, 0, -1),
	(70061, 'Mandra', 33, 'Sword of Honor', 62, 3500000, 0, -1),
	(70061, 'Mandra', 178, 'Crossbow of Silence', 63, 3500000, 0, -1),
	(70061, 'Mandra', 118, 'Jet-Black Crystal Ball', 64, 3500000, 0, -1),
	(70061, 'Mandra', 20234, 'Shield of Faith', 65, 3500000, 0, -1),
	(70061, 'Mandra', 127, 'Steel Staff of Mana', 66, 6000000, 0, -1),
	(70061, 'Mandra', 20167, 'Gloves of Lizardman Hero', 67, 500000, 0, -1),
	(70061, 'Mandra', 269, 'Wand of Illusionist', 68, 500000, 0, -1),
	(70061, 'Mandra', 21101, 'Spellbook of Illusionist', 69, 1500000, 0, -1),
	(70061, 'Mandra', 30011, 'Cloak of Illusionist', 70, 5000000, 0, -1),
	(70061, 'Mandra', 270, 'Sapphire Kiringku', 71, 15000000, 0, -1),
	(70061, 'Mandra', 275, 'Two-handed Sword of Dragonknight', 72, 500000, 0, -1),
	(70061, 'Mandra', 21103, 'Dragon Scale Guarder', 73, 1500000, 0, -1),
	(70061, 'Mandra', 21102, 'Cloak of Dragon Knight', 74, 5000000, 0, -1),
	(70061, 'Mandra', 272, 'Destructors Chain Sword', 75, 15000000, 0, -1);

-- Gloves purchasing_price 1 adena -> 2k
update shop set purchasing_price = 2000 where item_id = 20182;
-- Cloak of Protection purchasing_price 1 adena -> 10k
update shop set purchasing_price = 10000 where item_id = 20063;

-- Make Candle of Reminiscence tradeable
UPDATE etcitem SET trade = 0 WHERE item_id = 49142;

-- Missing Knight Weapons
insert into droplist values 
	(45652, "Cougar", 450001, "Paagrio's Hatred", 1, 1, 10000),
	(45653, "Mummy Lord", 450002, "Maphr's Retribution", 1, 1, 10000);

-- Change Paagrio's Hatred proc animation to Lesser Demon's spell
-- to avoid screen shaking
update weapon_skill set effect_id = 2527 where weapon_id = 450001;

-- add Griffon Feather and Wind tear drop to FI Griffons
insert into droplist values
(45445,'Griffon',40491,'Griffon Feather',1,1,3000),
(45445,'Griffon',40498,'Wind Tear',1,1,3000);

update npc set note = 'Forgotten Island' where npcid = 45445;

-- Royal Useable
/* Add Royal to SoS, Kurtz, PH */
UPDATE `weapon` SET use_royal = '1' where item_id in (47,54,450001);
	
/* Add Royal, (X)DragonKnight to Reinforced T-Shirt, Titan Belt */
UPDATE `armor` SET use_royal = 1, use_dragonknight = 1 where item_id in (30000,20320);

-- Item Alterations
/* 2Cha > 2Wis on SoF, (X)3 StunResist on RoG 1DR 1AC */
update armor set add_wis = 2, add_cha = 0 where item_id = 20287;
update armor set regist_stun = 3, damage_reduction = 1, ac = 1 where item_id = 20234;

/* Logbook quest fails at step to combine pages- I believe this may fix them (Glued Logbook Pages 1-10 Use_Type: normal -> choice */
UPDATE `etcitem` SET `use_type` = 'choice' WHERE item_id IN (41048,41049,41050,41051,41052,41053,41054,41055,41056,41057);

-- Increase Longbow of Moon proc damage
update weapon_skill set fix_damage = 15, random_damage = 30 where weapon_id = 205;
