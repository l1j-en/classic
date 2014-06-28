-- update 69

-- add Dwarf Adelio

INSERT INTO spawnlist_npc VALUES(NULL,'',1,71125,32579,32659,0,0,6,0,400,0);

-- make ebind two cell ranged

UPDATE skills SET ranged = 2 where skill_id = 157;

-- Make iris ammy drop from 9xF iris's

INSERT INTO droplist VALUES(45595,"Iris - Toi 9xf", 20260, "Amulet of Iris", 1, 1, 1200);

-- Thor's Hammer usable by mages.
UPDATE weapon SET use_mage = 1 where name="Thor's Hammer";

-- Spear of Intense Winter is a 1-handed weapon.
UPDATE weapon SET type = "singlespear" where name="Spear of Intense Winter";

-- Illusionists should be able to use Amulet of Black Wizard.
UPDATE armor SET use_illusionist = 1 where name="Amulet of Black Wizard";

-- Giants drop Titan Belt and 11f ToI scrolls.
INSERT INTO droplist VALUES(45337, "Giant - Tan", 120320, "Titan Belt", 1, 1, 210);
INSERT INTO droplist VALUES(45295, "Giant - Dark", 120320, "Titan Belt", 1, 1, 230);
INSERT INTO droplist VALUES(45318, "Giant - Light", 120320, "Titan Belt", 1, 1, 250);
INSERT INTO droplist VALUES(45351, "Giant - Light", 120320, "Titan Belt", 1, 1, 250);
INSERT INTO droplist VALUES(45337, "Giant - Tan", 40104, "TOI Teleport Scroll, 11F", 1, 1, 7000);
INSERT INTO droplist VALUES(45295, "Giant - Light", 40104, "TOI Teleport Scroll, 11F", 1, 1, 8000);
INSERT INTO droplist VALUES(45318, "Giant - Light", 40104, "TOI Teleport Scroll, 11F", 1, 1, 9000);
INSERT INTO droplist VALUES(45351, "Giant - Dark", 40104, "TOI Teleport Scroll, 11F", 1, 1, 9000);

-- Mummy Lord (ToI 9x) should drop Crown of the Mummy Lord.
INSERT INTO droplist VALUES(45616, "Mummy Lord - ToI 9xF", 20017, "Crown of Mummy Lord", 1, 1, 1200);

-- Knight Vald (ToI 9x) should drop Knight Vald sword.
INSERT INTO droplist VALUES(45664, "Knight Vald - ToI 9xF", 59, "Sword of Knight Vald", 1, 1, 300);

-- Black Knight of Darkness should drop rough metals.
INSERT INTO droplist VALUES(45503, "Black Knight of Darkness", 40441, "Rough Platinum Piece", 1, 1, 20000);
INSERT INTO droplist VALUES(45503, "Black Knight of Darkness", 40468, "Rough Silver Piece", 1, 1, 20000);
INSERT INTO droplist VALUES(45503, "Black Knight of Darkness", 40489, "Rough Gold Piece", 1, 1, 20000);

-- Iron Golem should drop Lump of Steel.
INSERT INTO droplist VALUES(45372, "Iron Golem", 40799, "Lump of Steel", 1, 1, 6000);
INSERT INTO droplist VALUES(45479, "Horrific Iron Golem", 40799, "Lump of Steel", 1, 1, 8000);

-- Delete duplicate door spawns.
delete from spawnlist_door where id = 783;
delete from spawnlist_door where id = 1030;
delete from spawnlist_door where id = 1140;
delete from spawnlist_door where id = 1177;
delete from spawnlist_door where id = 1226;
delete from spawnlist_door where id = 1228;

-- Remove incorrect item_id entries above.
delete from droplist where mobid = 45372 and itemid = 40799;
delete from droplist where mobid = 45479 and itemid = 40799;

-- Iron Golem should drop Lump of Steel.
INSERT INTO droplist VALUES(45372, "Iron Golem", 40779, "Lump of Steel", 1, 1, 6000);
INSERT INTO droplist VALUES(45479, "Horrific Iron Golem", 40779, "Lump of Steel", 1, 1, 8000);
