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
update etcitem set stackable=1 where name="Crystal Ball of Necromancer";
update etcitem set stackable=1 where item_id=41243 or item_id=41244; -- lasta boxes

-- dk/kurtz sets usable by all
-- if you had early custom armor then use
-- update armor set use_dragonknight=1, use_illusionist=1, use_darkelf=1, use_mage=1, use_elf=1, use_knight=1, use_royal=1 where name like "%kurtz%" or name like "%death knight%";
update armor set use_dragonknight=1, use_illusionist=1, use_darkelf=1, use_mage=1, use_elf=1, use_knight=1, use_royal=1 where item_id=20010 or item_id=20041 or item_id=20100 or item_id=20150 or item_id=20166 or item_id=20184 or item_id=20198 or item_id=20214;

-- TODO: Giran teleportation scrolls added to Melissa.

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
