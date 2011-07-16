-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 65

-- added KillGlance ring and crafter
insert into npc values (90016,'KillGlance','KillGlance','KillGlance','L1Merchant',2337,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0);
insert into npcaction values (90016,'killglance1','','','');
insert into spawnlist_npc values (1900012,'KillGlance',1,90016,34073,33109,0,0,6,0,4,0);
insert into armor values (30009,'KillGlance`s Ring','KillGlance`s Ring','KillGlance`s Ring','ring','gold',3000,668,21,0,0,-1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0);

-- added .reload from l1j-jp2
INSERT INTO commands VALUES('reload', 0, 'L1Reload');

-- polyrace
INSERT INTO spawnlist_npc VALUES (1310454,'Dufo PolyRace',1,80168,32616,32778,0,0,4,0,4,0);
INSERT INTO `npc` VALUES (80168, 'Dufo', '$5524', 'Polyrace', 'L1Merchant', 118, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'small', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 14, 0, 1, 0);

-- some new door stuffs

DROP TABLE IF EXISTS `door_gfxs`;
CREATE TABLE `door_gfxs` (
  `gfxid` int(11) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `direction` int(11) NOT NULL,
  `left_edge_offset` int(11) NOT NULL,
  `right_edge_offset` int(11) NOT NULL,
  PRIMARY KEY (`gfxid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# ----------------------------
# Records of door_gfxs
# ----------------------------
INSERT INTO door_gfxs VALUES
(92, 'Pago`s Room', 0, 0, 1),
(93, 'Pago`s Room', 1, 0, 0),
(339, 'Kent Castle', 0, -1, 0),
(442, 'Windawood', 0, 0, 0),
(443, 'Dwarf Castle', 1, 0, 1),
(444, 'SKT', 1, 0, 0),
(446, 'SKT', 1, 0, 0),
(447, 'SKT', 0, 0, 0),
(448, 'SKT', 0, 0, 0),
(766, 'Orcish Forest', 1, 0, 0),
(767, 'Orcish Forest', 0, 0, 0),
(768, 'Orcish Forest', 1, 0, 0),
(845, 'SKT', 0, 0, 0),
(1010, 'SKT', 0, 0, 0),
(1327, 'Giran', 1, 0, 0),
(1329, 'Giran', 0, 0, 0),
(1330, 'Giran', 1, 0, 0),
(1331, 'Giran', 0, 0, 0),
(1332, 'Giran', 1, 0, 0),
(1333, 'Giran', 0, 0, 0),
(1334, 'Giran', 0, 0, 0),
(1336, 'Giran Castle', 0, -1, 0),
(1338, 'Giran Castle', 1, 0, 1),
(1341, 'Orcish Forest', 0, 0, 0),
(1342, 'Giran', 1, 0, 1),
(1347, 'Giran', 0, 0, 0),
(1348, 'Giran', 0, 0, 0),
(1349, 'Giran', 0, 0, 0),
(1350, 'Giran', 0, 0, 0),
(1351, 'Giran', 1, 0, 0),
(1352, 'Giran', 0, 0, 0),
(1371, 'Giran', 1, 0, 0),
(1373, 'Giran', 0, 0, 0),
(1487, 'Giran Dog Race', 1, 0, 0),
(1664, 'Heine', 1, 0, 0),
(1665, 'Heine', 0, 0, 0),
(1688, 'Heine', 1, 0, 0),
(1689, 'Heine', 0, 0, 0),
(1690, 'Heine', 0, 0, 0),
(1691, 'Heine', 0, 0, 0),
(1692, 'Heine', 1, 0, 0),
(1700, 'Heine', 0, 0, 0),
(1734, 'Heine', 1, 0, 0),
(1735, 'Heine', 0, 0, 0),
(1736, 'Heine', 0, 0, 0),
(1737, 'Heine', 1, 0, 0),
(1738, 'Heine', 0, 0, 0),
(1739, 'Heine', 1, 0, 0),
(1740, 'Heine', 0, 0, 0),
(1741, 'Heine', 1, 0, 0),
(1743, 'Heine', 0, 0, 0),
(1744, 'Heine', 1, 0, 0),
(1745, 'Heine Castle', 0, -2, 0),
(1750, 'Heine', 1, 0, 0),
(1751, 'Heine', 0, 0, 0),
(1826, 'Dwarf Castle', 1, -2, 1),
(1827, 'Dwarf Castle', 0, -1, 2),
(2083, 'Hidden Valley', 0, 0, 0),
(2089, 'Hidden Valley', 1, 0, 0),
(2114, 'Hidden Valley', 0, 0, 0),
(2128, 'Hidden Valley', 1, 0, 0),
(2160, 'Oren', 0, 0, 0),
(2161, 'Oren', 0, 0, 0),
(2162, 'Oren', 1, 0, 0),
(2163, 'Oren', 0, 0, 0),
(2164, 'Oren', 0, 0, 0),
(2190, 'Oren', 0, 0, 0),
(2191, 'Oren', 1, 0, 0),
(2301, 'Talking Island', 0, 0, 0),
(2303, 'Talking Island', 0, 0, 0),
(2304, 'Talking Island', 0, 0, 0),
(2305, 'Talking Island', 0, 0, 0),
(2306, 'Talking Island', 0, 0, 0),
(2344, 'Talking Island', 1, -364, -364),
(2345, 'Talking Island', 0, 0, 0),
(2346, 'Talking Island', 0, 0, 0),
(2510, 'race', 1, -3, 4),
(2556, 'Aden', 1, 0, 0),
(2558, 'Aden', 0, 0, 0),
(2574, 'Aden', 1, 0, 0),
(2575, 'Aden', 0, 0, 0),
(2578, 'Aden', 0, 0, 0),
(2579, 'Aden', 0, 0, 0),
(2580, 'Aden', 1, 0, 0),
(2581, 'Aden', 0, 0, 0),
(2582, 'Aden', 0, 0, 0),
(2583, 'Aden', 1, 0, 0),
(2585, 'Aden', 0, 0, 0),
(2588, 'Aden', 1, 0, 0),
(2589, 'Aden', 1, 0, 0),
(2590, 'Aden', 0, 0, 0),
(2591, 'Aden', 0, 0, 0),
(2596, 'Aden', 1, 0, 0),
(2597, 'Aden', 0, 0, 0),
(2598, 'Aden', 0, 0, 0),
(2599, 'Aden', 1, 0, 0),
(2600, 'Aden', 1, 0, 0),
(2603, 'Aden', 0, 0, 0),
(2605, 'Aden', 0, 0, 0),
(2606, 'Aden', 1, 0, 0),
(2608, 'Aden', 0, 0, 0),
(2610, 'Aden', 1, 0, 0),
(2628, 'Aden', 1, 0, 0),
(2629, 'Aden', 1, 0, 0),
(2630, 'Aden', 0, 0, 0),
(2631, 'Aden', 0, 0, 0),
(2634, 'Aden', 0, 0, 0),
(2635, 'Aden', 0, 0, 0),
(2732, 'OT Castle', 0, -1, 2),
(2736, 'Kent Castle', 1, -2, 1),
(2744, 'Giran Castle', 0, 0, 3),
(2745, 'Giran Castle', 0, -1, 2),
(2746, 'Giran Castle', 1, -2, 1),
(3234, 'Kent Castle', 0, -2, 1),
(6026, 'Gludio', 0, 0, 0),
(6027, 'Gludio', 1, 0, 0),
(6028, 'Gludio', 1, 0, 0),
(6029, 'Gludio', 0, 0, 1),
(6030, 'Gludio', 0, 0, 1),
(6031, 'Gludio', 1, 0, 0),
(6032, 'Gludio', 0, 0, 0),
(6033, 'Gludio', 1, 0, 0),
(6336, 'Haunted House', 0, -1, 1),
(6351, 'Haunted House', 1, -3, 3),
(6379, 'Haunted House', 1, 0, 2),
(6677, 'race', 1, -3, 4),
(6692, 'Death match', 0, 0, 1),
(6694, 'Death match', 1, -1, 0),
(7536, 'Hardin Quest', 0, 0, 0);

ALTER TABLE spawnlist_door DROP direction;
ALTER TABLE spawnlist_door DROP left_edge_location;
ALTER TABLE spawnlist_door DROP right_edge_location;

INSERT INTO `spawnlist_door` VALUES ('9000', 'race', '6677', '32762', '32848', '5143', '0', '5143');

-- make ZL only drop 1 wand of each type.  this was causing issues
UPDATE droplist SET min = 1 WHERE item_name LIKE '%wand%' AND min > 1;

-- lower droprate of pollute water by a good bit.  this shouldn't be easily farmable imo
UPDATE droplist SET chance = chance / 4 WHERE (itemid = 41152 AND mobid = 45735) OR (itemid = 41152 AND mobid = 45942);
UPDATE droplist SET chance = chance / 2 WHERE (itemid = 41152 AND mobid = 45943) OR (itemid = 41152 AND mobid = 45944);

-- make guardian armor basically resistant to physical damage
UPDATE npc SET ac = -223 WHERE npcid = 45562;

-- remove the broken lancemaster poly's
DELETE FROM polymorphs WHERE id > 7000;

-- make some spawn config changes for better future spawns
ALTER TABLE `spawnlist` ADD `spawn_home` tinyint(1) unsigned NOT NULL DEFAULT 1 AFTER near_spawn;
ALTER TABLE `spawnlist` ADD `spawn_home_range` int(10) NOT NULL DEFAULT 8 AFTER spawn_home;
ALTER TABLE `spawnlist` ADD `spawn_home_count` int(10) NOT NULL DEFAULT 2 AFTER spawn_home_range;
ALTER TABLE `spawnlist` ADD `spawn_home_delay` int(10) NOT NULL DEFAULT 100 AFTER spawn_home_count;

-- make jindo pup's spawn closer to the way they should
DELETE FROM spawnlist WHERE id > 801500428 and id < 801500457 and npc_templateid = 45711;
update spawnlist set locx1 = 32576, locx2 = 33023, locy1 = 32512, locy2 = 32959, spawn_home = 0, min_respawn_delay = 900, max_respawn_delay = 1800 where id = 801500428;
update spawnlist set locx1 = 32512, locx2 = 32831, locy1 = 32704, locy2 = 33023, spawn_home = 0, min_respawn_delay = 900, max_respawn_delay = 1800 where id = 801500457;
INSERT INTO spawnlist VALUES(801500429, "Aden", 5, 45711, 0, 32767, 32767, 10, 10, 32384, 32064, 34303, 33535, 3, 1800, 3600, 4, 0, 0, 0, 0, 0, 8, 2, 100);

# Increase Item Name Size Limit
ALTER TABLE etcitem MODIFY name varchar(60);
ALTER TABLE etcitem MODIFY unidentified_name_id varchar(60);
ALTER TABLE etcitem MODIFY identified_name_id varchar(60);

# Update missing etcitem names
UPDATE etcitem SET name = 'Cracked Nucleus' WHERE item_id = 49092;
UPDATE etcitem SET name = 'Piece of Low-grade Treasure Chest of Osiris' WHERE item_id = 49093;
UPDATE etcitem SET name = 'Piece of Low-grade Treasure Chest of Osiris' WHERE item_id = 49094;
UPDATE etcitem SET name = 'Locked Low-grade Treasure Chest of Osiris' WHERE item_id = 49095;
UPDATE etcitem SET name = 'Opened Low-grade Treasure Chest of Osiris' WHERE item_id = 49096;
UPDATE etcitem SET name = 'Piece of High-grade Treasure Chest of Osiris' WHERE item_id = 49097;
UPDATE etcitem SET name = 'Piece of High-grade Treasure Chest of Osiris' WHERE item_id = 49098;
UPDATE etcitem SET name = 'Locked High-Grade Treasure Chest of Osiris' WHERE item_id = 49099;
UPDATE etcitem SET name = 'Opened High-Grade Treasure Chest of Osiris' WHERE item_id = 49100;
UPDATE etcitem SET name = 'Fragment of Time' WHERE item_id = 49101;
UPDATE etcitem SET name = 'Lastavard Supplies Bag' WHERE item_id = 41243;
UPDATE etcitem SET name = 'Lastavard Supplies Box' WHERE item_id = 41244;
UPDATE etcitem SET name = 'Evidence Box of Dark Spirit Army' WHERE item_id = 40636;
UPDATE etcitem SET name = 'Incomplete Logbook 2,4,6,8,10' WHERE item_id = 49082;
UPDATE etcitem SET name = 'Incomplete Logbook 1,3,5,7,9' WHERE item_id = 49083;
UPDATE etcitem SET name = 'Incomplete Logbook 1,2,4,6,8,10' WHERE item_id = 49084;
UPDATE etcitem SET name = 'Incomplete Logbook 1,2,3,5,7,9' WHERE item_id = 49085;
UPDATE etcitem SET name = 'Incomplete Logbook 1,2,3,4,6,8,10' WHERE item_id = 49086;
UPDATE etcitem SET name = 'Incomplete Logbook 1,2,3,4,5,7,9' WHERE item_id = 49087;
UPDATE etcitem SET name = 'Incomplete Logbook 1,2,3,4,5,6,8,10' WHERE item_id = 49088;
UPDATE etcitem SET name = 'Incomplete Logbook 1,2,3,4,5,6,7,9' WHERE item_id = 49089;
UPDATE etcitem SET name = 'Incomplete Logbook 1,2,3,4,5,6,7,8,10' WHERE item_id = 49090;
UPDATE etcitem SET name = 'Incomplete Logbook 1,2,3,4,5,6,7,8,9' WHERE item_id = 49091;
UPDATE etcitem SET name = 'Cracked Nucleus' WHERE item_id = 49092;
UPDATE etcitem SET name = 'Piece of Low-grade Treasure Chest of Osiris (Upper)' WHERE item_id = 49093;
UPDATE etcitem SET name = 'Piece of Low-grade Treasure Chest of Osiris (Lower)' WHERE item_id = 49094;
UPDATE etcitem SET name = 'Locked Low-grade Treasure Chest of Osiris' WHERE item_id = 49095;
UPDATE etcitem SET name = 'Opened Low-grade Treasure Chest of Osiris' WHERE item_id = 49096;
UPDATE etcitem SET name = 'Piece of High-grade Treasure Chest of Osiris (Upper)' WHERE item_id = 49097;
UPDATE etcitem SET name = 'Piece of High-grade Treasure Chest of Osiris (Lower)' WHERE item_id = 49098;
UPDATE etcitem SET name = 'Locked High-Grade Treasure Chest of Osiris' WHERE item_id = 49099;
UPDATE etcitem SET name = 'Opened High-Grade Treasure Chest of Osiris' WHERE item_id = 49100;
UPDATE etcitem SET name = 'Fragment of Time' WHERE item_id = 49101;
UPDATE etcitem SET unidentified_name_id = '$3030' WHERE item_id = 40467;
UPDATE etcitem SET identified_name_id = '$3030' WHERE item_id = 40467;
UPDATE etcitem SET name = 'Sealed Scroll' WHERE item_id = 41426;
UPDATE etcitem SET name = 'Seal Release Scroll' WHERE item_id = 41427;
UPDATE etcitem SET name = 'Ancient Royal Seal' WHERE item_id = 41428;
UPDATE etcitem SET name = 'Scroll of Enchant Weapon: Wind' WHERE item_id = 41429;
UPDATE etcitem SET name = 'Scroll of Enchant Weapon: Earth' WHERE item_id = 41430;
UPDATE etcitem SET name = 'Scroll of Enchant Weapon: Water' WHERE item_id = 41431;
UPDATE etcitem SET name = 'Scroll of Enchant Weapon: Fire' WHERE item_id = 41432;
UPDATE etcitem SET name = 'Herb' WHERE item_id = 49243;
UPDATE etcitem SET name = 'Roasted Claw of Crustacean' WHERE item_id = 49244;
UPDATE etcitem SET name = 'Griffon Roast' WHERE item_id = 49245;
UPDATE etcitem SET name = 'Cockatrice Steak' WHERE item_id = 49246;
UPDATE etcitem SET name = 'Great King Turtle Roast' WHERE item_id = 49247;
UPDATE etcitem SET name = 'Lesser Dragon Wing Skewers' WHERE item_id = 49248;
UPDATE etcitem SET name = 'Drake Roast' WHERE item_id = 49249;
UPDATE etcitem SET name = 'Deep Sea Fish Stew' WHERE item_id = 49250;
UPDATE etcitem SET name = 'Basilisk Egg Soup' WHERE item_id = 49251;
UPDATE etcitem SET unidentified_name_id = '$6099 $4928' WHERE item_id = 49252;
UPDATE etcitem SET unidentified_name_id = '$6100 $4928' WHERE item_id = 49253;
UPDATE etcitem SET unidentified_name_id = '$6101 $4928' WHERE item_id = 49254;
UPDATE etcitem SET unidentified_name_id = '$6102 $4928' WHERE item_id = 49255;
UPDATE etcitem SET unidentified_name_id = '$6103 $4928' WHERE item_id = 49256;
UPDATE etcitem SET unidentified_name_id = '$6104 $4928' WHERE item_id = 49257;
UPDATE etcitem SET unidentified_name_id = '$6105 $4928' WHERE item_id = 49258;
UPDATE etcitem SET unidentified_name_id = '$6106 $4928' WHERE item_id = 49259;
UPDATE etcitem SET identified_name_id = '$6099 $4928' WHERE item_id = 49252;
UPDATE etcitem SET identified_name_id = '$6100 $4928' WHERE item_id = 49253;
UPDATE etcitem SET identified_name_id = '$6101 $4928' WHERE item_id = 49254;
UPDATE etcitem SET identified_name_id = '$6102 $4928' WHERE item_id = 49255;
UPDATE etcitem SET identified_name_id = '$6103 $4928' WHERE item_id = 49256;
UPDATE etcitem SET identified_name_id = '$6104 $4928' WHERE item_id = 49257;
UPDATE etcitem SET identified_name_id = '$6105 $4928' WHERE item_id = 49258;
UPDATE etcitem SET identified_name_id = '$6106 $4928' WHERE item_id = 49259;
UPDATE etcitem SET name = 'Roasted Claw of Crustacean of Fantasy' WHERE item_id = 49252;
UPDATE etcitem SET name = 'Griffon Roast of Fantasy' WHERE item_id = 49253;
UPDATE etcitem SET name = 'Cockatrice Steak of Fantasy' WHERE item_id = 49254;
UPDATE etcitem SET name = 'Great King Turtle Roast of Fantasy' WHERE item_id = 49255;
UPDATE etcitem SET name = 'Lesser Dragon Wing Skewers of Fantasy' WHERE item_id = 49256;
UPDATE etcitem SET name = 'Drake Roast of Fantasy' WHERE item_id = 49257;
UPDATE etcitem SET name = 'Deep Sea Fish Stew of Fantasy' WHERE item_id = 49258;
UPDATE etcitem SET name = 'Basilisk Egg Soup of Fantasy' WHERE item_id = 49259;
UPDATE etcitem SET name = 'Claw of Crustacean' WHERE item_id = 49260;
UPDATE etcitem SET name = 'Griffon Meat' WHERE item_id = 49261;
UPDATE etcitem SET name = 'Cockatrice Tail' WHERE item_id = 49262;
UPDATE etcitem SET name = 'Great King Turtle Meat' WHERE item_id = 49263;
UPDATE etcitem SET name = 'Lesser Dragon Wing' WHERE item_id = 49264;
UPDATE etcitem SET name = 'Drake Meat' WHERE item_id = 49265;
UPDATE etcitem SET name = 'Deep Sea Fish Meat' WHERE item_id = 49266;
UPDATE etcitem SET name = 'Basilisk Egg' WHERE item_id = 49267;
UPDATE etcitem SET name = 'Gem Stone Powder' WHERE item_id = 49270;
UPDATE etcitem SET name = 'Heart of Emai 1' WHERE item_id = 49271;
UPDATE etcitem SET name = 'Heart of Emai 2' WHERE item_id = 49272;
UPDATE etcitem SET name = 'Heart of Emai 3' WHERE item_id = 49273;
UPDATE etcitem SET name = 'Heart of Emai 4' WHERE item_id = 49274;
UPDATE etcitem SET name = 'Heart of Emai 5' WHERE item_id = 49275;
UPDATE etcitem SET name = 'Heart of Emai 6' WHERE item_id = 49276;
UPDATE etcitem SET name = 'Bronze Pumpkin of a Brave Man (Gold)' WHERE item_id = 49278;
UPDATE etcitem SET name = 'Bronze Pumpkin of a Brave Man (Silver)' WHERE item_id = 49279;
UPDATE etcitem SET name = 'Bronze Pumpkin of a Brave Man (Copper)' WHERE item_id = 49280;
UPDATE etcitem SET name = 'Heart of Emai (Quest)' WHERE item_id = 41097;
