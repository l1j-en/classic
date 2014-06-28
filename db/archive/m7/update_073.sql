-- update 73

-- reduce silence timer for sword of silence

UPDATE weapon_skill SET skill_time = 16 where weapon_id = 47;

-- Adjusting Titan Belt drops from giants.
-- Old rate judged to be too high and accidently dropped blessed belt.
DELETE FROM droplist WHERE item_name = "Titan Belt" and (mob_name = "Giant - Tan" or mob_name = "Giant - Light" or mob_name = "Giant - Dark");
INSERT INTO droplist VALUES(45337, "Giant - Tan", 20320, "Titan Belt", 1, 1, 80);
INSERT INTO droplist VALUES(45295, "Giant - Dark", 20320, "Titan Belt", 1, 1, 90);
INSERT INTO droplist VALUES(45318, "Giant - Light", 20320, "Titan Belt", 1, 1, 100);
INSERT INTO droplist VALUES(45351, "Giant - Light", 20320, "Titan Belt", 1, 1, 100);

-- Misc missing drops.
INSERT INTO droplist VALUES(45584, "Greater Minotaur", 40076, "Ancient Scroll", 1, 1, 9600);
INSERT INTO droplist VALUES(45640, "Unicorn", 211, "Unicorn Horn", 1, 1, 10000);
INSERT INTO droplist VALUES(45622, "Great Spirit of Fire", 41149, "Spirit Crystal(Soul of Flame)", 1, 1, 50);

-- RDS drops roughly according to linlib.
INSERT INTO droplist VALUES(45223, "Bugbear", 40393, "Red Dragon Scales", 1, 1, 30);
INSERT INTO droplist VALUES(45738, "Bugbear", 40393, "Red Dragon Scales", 1, 1, 40);
INSERT INTO droplist VALUES(45298, "King Bugbear", 40393, "Red Dragon Scales", 1, 1, 50);
INSERT INTO droplist VALUES(45471, "Horrific Cerberus", 40393, "Red Dragon Scales", 1, 1, 60);
INSERT INTO droplist VALUES(45480, "Fire Necromancer", 40393, "Red Dragon Scales", 1, 1, 70);
INSERT INTO droplist VALUES(45496, "Lesser Dragon", 40393, "Red Dragon Scales", 1, 1, 80);
INSERT INTO droplist VALUES(45532, "Fire Archer of Darkness", 40393, "Red Dragon Scales", 1, 1, 90);
INSERT INTO droplist VALUES(45529, "Drake", 40393, "Red Dragon Scales", 1, 1, 100);

-- GDS drops roughly according to linlib.
INSERT INTO droplist VALUES(45280, "Troll", 40396, "Green Dragon Scales", 1, 1, 40);
INSERT INTO droplist VALUES(45240, "Turtle Dragon", 40396, "Green Dragon Scales", 1, 1, 50);
INSERT INTO droplist VALUES(45352, "Doppelganger", 40396, "Green Dragon Scaless", 1, 1, 60);

-- WDS drops roughly according to linlib.
INSERT INTO droplist VALUES(45264, "Harpy", 40394, "White Dragon Scales", 1, 1, 30);
INSERT INTO droplist VALUES(45265, "Dark Elf", 40394, "White Dragon Scales", 1, 1, 35);
INSERT INTO droplist VALUES(45286, "Skeleton Fighter", 40394, "White Dragon Scales", 1, 1, 40);
INSERT INTO droplist VALUES(45289, "Muryan", 40394, "White Dragon Scales", 1, 1, 50);
INSERT INTO droplist VALUES(45322, "Living Armor", 40394, "White Dragon Scales", 1, 1, 55);
INSERT INTO droplist VALUES(45393, "Succubus", 40394, "White Dragon Scales", 1, 1, 70);
INSERT INTO droplist VALUES(45394, "Succubus", 40394, "White Dragon Scales", 1, 1, 70);
INSERT INTO droplist VALUES(45451, "Succubus Queen", 40394, "White Dragon Scales", 1, 1, 80);
INSERT INTO droplist VALUES(45503, "Black Knight of Darkness", 40394, "White Dragon Scales", 1, 1, 90);

-- Giran DM updates. Normal mob count might need to be racheted up a little.
update spawnlist_ub set count=20 where ub_id=1 and group_id!=4;
update spawnlist_ub set count=1 where ub_id=1 and group_id=4;
delete from spawnlist_ub where id=100 or id=201;
update spawnlist_ub set count=3 where ub_id=1 and group_id=4 and (npc_templateid=45583 or npc_templateid=45573);

-- FI Mobs - by default, set to same rate as their regular counterparts, since
-- you can already get other nifty stuff from them.
-- INSERT INTO droplist VALUES(45738, "Bugbear", 40393, "Red Dragon Scales", 1, 1, 30);
-- INSERT INTO droplist VALUES(45509, "King Bugbear", 40393, "Red Dragon Scales", 1, 1, 40);
-- INSERT INTO droplist VALUES(45578, "Drake", 40393, "Red Dragon Scales", 1, 1, 100);
-- INSERT INTO droplist VALUES(45477, "Troll", 40396, "Green Dragon Scales", 1, 1, 40);
-- INSERT INTO droplist VALUES(45452, "Harpy", 40394, "White Dragon Scales", 1, 1, 30);
-- INSERT INTO droplist VALUES(45364, "Dark Elf", 40394, "White Dragon Scales", 1, 1, 35);
