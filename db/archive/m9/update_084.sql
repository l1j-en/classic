update mapids set endx = 32831, endy = 32959 where mapid = 3;
update mapids set endX = 32831, startY = 32704 where mapid = 34;
update mapids set startX = 32576, startY = 32768, endY = 32959 where mapid = 106;
update mapids set endX = 32831 where mapid = 111;
update mapids set startX = 32576, startY = 32768, endY = 32959 where mapid = 116;
update mapids set endX = 32831 where mapid = 121;
update mapids set startX = 32576, startY = 32768, endY = 32959 where mapid = 126;
update mapids set endX = 32831 where mapid = 131;
update mapids set startX = 32576, startY = 32768, endY = 32959 where mapid = 136;
update mapids set endX = 32831 where mapid = 141;
update mapids set startX = 32576, startY = 32768, endY = 32959 where mapid = 146;
update mapids set startX = 32640, endX = 33535, startY = 32704 where mapid = 201;
update mapids set endX = 33535, startY = 32704, endY = 32959 where mapid = 202;
update mapids set endX = 33535, startY = 32704, endY = 32959 where mapid = 203;
update mapids set endX = 33535, startY = 32704, endY = 32959 where mapid = 204;
update mapids set endX = 33535, startY = 32704 where mapid = 205;
update mapids set endX = 33535, startY = 32704 where mapid = 206;
update mapids set endX = 33535, startY = 32704 where mapid = 207;
update mapids set endX = 33535, startY = 32704 where mapid = 208;
update mapids set endX = 33535, startY = 32704 where mapid = 209;
update mapids set endX = 33535, startY = 32704 where mapid = 210;
update mapids set endX = 33535, startY = 32704 where mapid = 211;
update mapids set startY = 32704 where mapid = 304;
update mapids set startX = 32640, startY = 32704 where mapid = 340;
update mapids set startX = 32576, endX = 33215, endY = 32959 where mapid = 501;
update mapids set startX = 32576, endX = 33215, endY = 32959 where mapid = 502;
update mapids set startX = 32576, endX = 33215, endY = 32959 where mapid = 503;
update mapids set startX = 32576, endX = 33215, endY = 32959 where mapid = 504;
update mapids set startX = 32576, endX = 33215, endY = 32959 where mapid = 505;
update mapids set startX = 32576, endX = 33215, endY = 32959 where mapid = 506;
update mapids set startX = 32576, endX = 33215, endY = 32895 where mapid = 511;
update mapids set startX = 32576, endX = 33215, endY = 32895 where mapid = 512;
update mapids set startX = 32576, endX = 33215, endY = 32895 where mapid = 513;
update mapids set startX = 32576, endX = 33215, endY = 32895 where mapid = 514;
update mapids set startX = 32576, endX = 33215, endY = 32895 where mapid = 515;
update mapids set startX = 32576, endX = 33215, endY = 32895 where mapid = 516;
update mapids set startY = 32832 where mapid = 521;
update mapids set endX = 32959, endY = 32959 where mapid = 2001;
update mapids set endX = 32959, startY = 32704, endY = 32959 where mapid = 2002;
update mapids set endX = 32959, startY = 32704 where mapid = 2003;
update mapids set endY = 32895 where mapid = 2004;
update mapids set startX = 32512, endX = 33023 where mapid = 1001;
update mapids set startX = 32448 where mapid = 4;
INSERT INTO skills VALUES('14012', 'Jeb Requie (Right) Sandstorm', '0', '0', '5', '0', '0', '0', '0', '0', 'none', '3', '120', '5', '3', '0', '0', '0', '64', '0', '15', '17', '0', '0', '', '19', '7293', '0', '0', '0', '0', NULL, '1'),
('14013', 'Jeb Requie (Right) - Pole Mine', '0', '0', '5', '0', '0', '0', '0', '0', 'attack', '3', '90', '5', '3', '0', '0', '0', '64', '0', '15', '17', '0', '0', '', '30', '10', '0', '0', '0', '0', NULL, '1');
INSERT INTO skills VALUES ('15005', 'Jeb Requie (Right) - Poison Spray', '0', '0', '5', '0', '0', '0', '0', '0', 'none', '3', '200', '5', '3', '0', '0', '4', '64', '0', '6', '6', '0', '0', '', '11', '7272', '0', '0', '0', '0', NULL, '1');
INSERT INTO skills VALUES ('15000', 'Jeb Requie (Left) - Posion Spray', '0', '0', '5', '0', '0', '0', '0', '0', 'none', '3', '200', '5', '3', '0', '0', '4', '64', '0', '6', '6', '0', '0', '', '11', '7272', '0', '0', '0', '0', NULL, '1');

-- Fix names of various teleport scrolls.
update etcitem set name = 'Teleport - Giran Dungeon 2F' where item_id = 40827;
update etcitem set name = 'Teleport - Giran Dungeon 3F' where item_id = 40828;
update etcitem set name = 'Teleport - Giran Dungeon 4F' where item_id = 40829;
update etcitem set name = 'Teleport - Kent Dungeon 1F' where item_id = 42006;
update etcitem set name = 'Teleport - Kent Dungeon 2F' where item_id = 42008;
update etcitem set name = 'Teleport - Kent Dungeon 3F' where item_id = 42009;
update etcitem set name = 'Teleport - Kent Dungeon 4F' where item_id = 42010;
update etcitem set name = 'Teleport - Oum Dungeon' where item_id = 42048;

-- Fix zombie group aggro.
update npc set agrofamily = 0 where npcid in (45065, 45105, 45757);

-- Remove Unknown Spear from Mandra (Oren weapon shop).
delete from shop where npc_id = 70061 and item_id = 87;

-- Enable .burf command for monitors.
update commands set access_level = 100 where name = 'burf';

-- Remove SKT map from Berry (Werldern pot shop).
delete from shop where npc_id = 70045 and item_id = 40380;

-- Remove SKT map from Bius (Oren pot shop).
delete from shop where npc_id = 70063 and item_id = 40380;
