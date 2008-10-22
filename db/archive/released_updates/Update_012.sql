-- update 12

-- increase wis pot drops on taurverus 
update droplist set max = 3 and chance = 200000 where itemid = 40016 and mobid = 45341;

-- increase res scroll drops on taurverus 
update droplist set max = 3 and chance = 200000 where itemid = 40089 and mobid = 45341;

-- increase brave pot drops on fire warrior 
update droplist set chance = 200000 where itemid = 40014 and mobid = 45284;

-- increase brave pot drops on astagio
update droplist set chance = 300000 where itemid = 40014 and mobid = 45359;

-- increase brave pot drops on lava golem
update droplist set chance = 150000 where itemid = 40014 and mobid = 45365;

-- fix milk cow name
update npc set name = 'Milk Cow' where npcid = 70984;

-- un-double the milk cow spawn count
update spawnlist set count = 1 where npc_templateid = 70984;

-- un-double the slime spawn count
update spawnlist set count = count / 2 where npc_templateid = 45060 and count > 2;

-- fix de wizard mobskill with a 75% leverage reduction
update mobskill set leverage = 4 where mobid = 45447 and actno = 0;
update mobskill set leverage = 9 where mobid = 45447 and actno = 1;

-- fix Lyra's name
update npc set name = 'Lyra' where npcid = 70811;

-- fix alchemist's name
update npc set name = 'Alchemist' where npcid = 70520;

-- fix name of sb:meditate (was sb:ej)
update etcitem set name_id = '$1861' where item_id = 40177;

-- fix name of sb:c-m (was sb:meditate)
update etcitem set name_id = '$1860' where item_id = 40176;

-- fix name of sb:ej (was sb:c-m)
update etcitem set name_id = '$1586' where item_id = 40175;

-- increase  a-scroll droprate on fi doppel and basi (800 -> 1000)
update droplist set chance = 1000 where itemid = 40076 and mobid in (45457, 45531);

-- add hp regen to lvl 30 elf summons and correct their names
-- spirit of earth
update npc set hpr = 2, hprinterval= 5000,  name = 'Spirit of Fire' where npcid = 45303;
-- spirit of water
update npc set hpr = 2, hprinterval= 5000,  name = 'Spirit of Water' where npcid = 45304;
-- spirit of wind
update npc set hpr = 2, hprinterval= 5000,  name = 'Spirit of Wind' where npcid = 45305;
-- spirit of earth
update npc set hpr = 2, hprinterval= 5000,  name = 'Spirit of Earth' where npcid = 45306;

-- undouble spawn on toi 11-13, 21-23, 31-33
update spawnlist set count = count / 2 where mapid in (111, 112, 113, 121, 122, 123, 131, 132, 133) and count > 1;

-- reduce rosc droprate on unicorn
update droplist set chance = 1000 where itemid = 20284 and mobid = 45640;
-- increase bzel droprate on unicorn
update droplist set chance = 15000 where itemid = 140074 and mobid = 45640;

-- fix name for Piece of Large Cave Scroll (was "Oum Dungeon Scroll Pieces")
update etcitem set name = 'Piece of Large Cave Scroll' where item_id = 40429;

-- fix name for Diad Scroll Piece (was "Oum Dungeon Scroll Pieces")
update etcitem set name = 'Diad Scroll Piece' where item_id = 40432;

-- fix name for Scroll of Teleportation - Diad Fortress (was "Scroll of Return: Resistance Village")
update etcitem set name = 'Scroll of Teleportation - Diad Fortress' where item_id = 40084;

-- fix name id for Scroll of Teleportation - Resistance Village (was "Scroll of Teleportation")
update etcitem set name_id = '$230 - Resistance Village' where item_id = 40853;
