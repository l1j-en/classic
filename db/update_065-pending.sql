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

# Update npc names
UPDATE npc SET name = 'Ramia - Blue' WHERE npcid = 45229;
UPDATE npc SET name = 'Ramia - Green' WHERE npcId = 45229;
UPDATE npc SET name = 'Giran Ramia - Green' WHERE npcId = 45230;
UPDATE npc SET name = 'Scorpaitan' WHERE npcId = 45260;
UPDATE npc SET name = 'Scormystic' WHERE npcId = 45277;
UPDATE npc SET name = 'Scorpion - Blue' WHERE npcId = 81077;
UPDATE npc SET name = 'Giant - Dark' WHERE npcid = 45295;
UPDATE npc SET name = 'Muryan - Large' WHERE npcid = 45308;
UPDATE npc SET name = 'Giant - Light' WHERE npcid = 45318;
UPDATE npc SET name = 'Bandit - Dagger' WHERE npcId = 45329;
UPDATE npc SET name = 'Skeletal Pirate Captain' WHERE npcId = 45330;
UPDATE npc SET name = 'Mutant Ramia - Green' WHERE npcId = 45332;
UPDATE npc SET name = 'Giant - Tan' WHERE npcId = 45337;
UPDATE npc SET name = 'Giant - Light' WHERE npcId = 45351;
UPDATE npc SET name = 'Ramia - Green' WHERE npcId = 45387;

# Update missing droplist mob names
UPDATE droplist SET mob_name = 'Giant Ant' WHERE mobId = 45115;
UPDATE droplist SET mob_name = 'Orc Wizard' WHERE mobId = 45121;
UPDATE droplist SET mob_name = 'Owlbear' WHERE mobId = 45147;
UPDATE droplist SET mob_name = 'Mad Lizardman' WHERE mobId = 45158;
UPDATE droplist SET mob_name = 'Arachnevil Elder' WHERE mobId = 45184;
UPDATE droplist SET mob_name = 'Giant Soldier Ant' WHERE mobId = 45190;
UPDATE droplist SET mob_name = 'Fire Egg' WHERE mobId = 45206;
UPDATE droplist SET mob_name = 'Ice Man' WHERE mobId = 45207;
UPDATE droplist SET mob_name = 'Ghast' WHERE mobId = 45213;
UPDATE droplist SET mob_name = 'Mole' WHERE mobId = 45214;
UPDATE droplist SET mob_name = 'Elder' WHERE mobId = 45215;
UPDATE droplist SET mob_name = 'Undead Elmore Soldier' WHERE mobId = 45216;
UPDATE droplist SET mob_name = 'High Lizardman' WHERE mobId = 45217;
UPDATE droplist SET mob_name = 'Dire Bat' WHERE mobId = 45219;
UPDATE droplist SET mob_name = 'Dark Elf Thief' WHERE mobId = 45220;
UPDATE droplist SET mob_name = 'Death' WHERE mobId = 45221;
UPDATE droplist SET mob_name = 'Ramia - Blue' WHERE mobId = 45222;
UPDATE droplist SET mob_name = 'Bugbear' WHERE mobId = 45223;
UPDATE droplist SET mob_name = 'Undead Elmore Wizard' WHERE mobId = 45224;
UPDATE droplist SET mob_name = 'Priest of Chaos' WHERE mobId = 45226;
UPDATE droplist SET mob_name = 'Priest of Chaos' WHERE mobId = 45227;
UPDATE droplist SET mob_name = 'Sea Dancer' WHERE mobId = 45228;
UPDATE droplist SET mob_name = 'Ramia - Green' WHERE mobId = 45229;
UPDATE droplist SET mob_name = 'Giran Ramia - Green' WHERE mobId = 45230;
UPDATE droplist SET mob_name = 'Priest of Chaos' WHERE mobId = 45231;
UPDATE droplist SET mob_name = 'Dark Elf Soldier' WHERE mobId = 45233;
UPDATE droplist SET mob_name = 'Large Rat' WHERE mobId = 45235;
UPDATE droplist SET mob_name = 'Dire Wolf' WHERE mobId = 45237;
UPDATE droplist SET mob_name = 'Dark Elf Hunter' WHERE mobId = 45238;
UPDATE droplist SET mob_name = 'Blue Tail' WHERE mobId = 45239;
UPDATE droplist SET mob_name = 'Turtle Dragon' WHERE mobId = 45240;
UPDATE droplist SET mob_name = 'Cerberus' WHERE mobId = 45241;
UPDATE droplist SET mob_name = 'Giran Snow Tiger' WHERE mobId = 45243;
UPDATE droplist SET mob_name = 'Dark Elemental' WHERE mobId = 45244;
UPDATE droplist SET mob_name = 'Dark Elementalist' WHERE mobId = 45245;
UPDATE droplist SET mob_name = 'Dillo' WHERE mobId = 45246;
UPDATE droplist SET mob_name = 'Skeletal Pirate' WHERE mobId = 45247;
UPDATE droplist SET mob_name = 'Undead Elmore General' WHERE mobId = 45248;
UPDATE droplist SET mob_name = 'Kiwi Parrot' WHERE mobId = 45249;
UPDATE droplist SET mob_name = 'Heavy Lizardman' WHERE mobId = 45251;
UPDATE droplist SET mob_name = 'Dire Bear' WHERE mobId = 45252;
UPDATE droplist SET mob_name = 'Dark Elf Guard' WHERE mobId = 45253;
UPDATE droplist SET mob_name = 'Dark Elf Guard' WHERE mobId = 45254;
UPDATE droplist SET mob_name = 'Dark Elf Apprentice' WHERE mobId = 45256;
UPDATE droplist SET mob_name = 'DragonFly' WHERE mobId = 45257;
UPDATE droplist SET mob_name = 'Middle Oum' WHERE mobId = 45258;
UPDATE droplist SET mob_name = 'Scorpion' WHERE mobId = 45259;
UPDATE droplist SET mob_name = 'Scorpaitan' WHERE mobId = 45260;
UPDATE droplist SET mob_name = 'Turtle Dragon' WHERE mobId = 45262;
UPDATE droplist SET mob_name = 'Bomb Flower' WHERE mobId = 45263;
UPDATE droplist SET mob_name = 'Harpy' WHERE mobId = 45264;
UPDATE droplist SET mob_name = 'Dark Elf' WHERE mobId = 45265;
UPDATE droplist SET mob_name = 'Snow Tiger' WHERE mobId = 45267;
UPDATE droplist SET mob_name = 'Skeleton Guard' WHERE mobId = 45269;
UPDATE droplist SET mob_name = 'Skeleton Marksman' WHERE mobId = 45270;
UPDATE droplist SET mob_name = 'Greater Dark Elemental' WHERE mobId = 45271;
UPDATE droplist SET mob_name = 'Dark Elf Thief' WHERE mobId = 45272;
UPDATE droplist SET mob_name = 'Deep Flower' WHERE mobId = 45273;
UPDATE droplist SET mob_name = 'Skeletal Pirate Soldier' WHERE mobId = 45274;
UPDATE droplist SET mob_name = 'Black Ent' WHERE mobId = 45275;
UPDATE droplist SET mob_name = 'Right-Hand Bandit' WHERE mobId = 45276;
UPDATE droplist SET mob_name = 'Scormystic' WHERE mobId = 45277;
UPDATE droplist SET mob_name = 'Ogre' WHERE mobId = 45278;
UPDATE droplist SET mob_name = 'Elekkadom' WHERE mobId = 45279;
UPDATE droplist SET mob_name = 'Troll' WHERE mobId = 45280;
UPDATE droplist SET mob_name = 'Giran Stone Golem' WHERE mobId = 45281;
UPDATE droplist SET mob_name = 'Giran Dire Wolf' WHERE mobId = 45282;
UPDATE droplist SET mob_name = 'Giran Cerberus' WHERE mobId = 45283;
UPDATE droplist SET mob_name = 'Fire Warrior' WHERE mobId = 45284;
UPDATE droplist SET mob_name = 'Crustacean' WHERE mobId = 45285;
UPDATE droplist SET mob_name = 'Skeleton Fighter' WHERE mobId = 45286;
UPDATE droplist SET mob_name = 'Dark Elf Guard' WHERE mobId = 45287;
UPDATE droplist SET mob_name = 'Muryan' WHERE mobId = 45289;
UPDATE droplist SET mob_name = 'Bats' WHERE mobId = 45290;
UPDATE droplist SET mob_name = 'Fire Archer' WHERE mobId = 45291;
UPDATE droplist SET mob_name = 'Corrupt Guard' WHERE mobId = 45292;
UPDATE droplist SET mob_name = 'Dark Elf Carrier' WHERE mobId = 45293;
UPDATE droplist SET mob_name = 'Yeti' WHERE mobId = 45294;
UPDATE droplist SET mob_name = 'Giant - Dark' WHERE mobId = 45295;
UPDATE droplist SET mob_name = 'Gelatinous Cube' WHERE mobId = 45296;
UPDATE droplist SET mob_name = 'Subterranean Crabman' WHERE mobId = 45297;
UPDATE droplist SET mob_name = 'King Bugbear' WHERE mobId = 45298;
UPDATE droplist SET mob_name = 'Plate Worm' WHERE mobId = 45299;
UPDATE droplist SET mob_name = 'Ancient Apparition' WHERE mobId = 45300;
UPDATE droplist SET mob_name = 'Sin of Sepia' WHERE mobId = 45301;
UPDATE droplist SET mob_name = 'Giant Guardian' WHERE mobId = 45302;
UPDATE droplist SET mob_name = 'Alligator' WHERE mobId = 45307;
UPDATE droplist SET mob_name = 'Muryan - Large' WHERE mobId = 45308;
UPDATE droplist SET mob_name = 'Black Tiger' WHERE mobId = 45309;
UPDATE droplist SET mob_name = 'Summon Elemental' WHERE mobId = 45310;
UPDATE droplist SET mob_name = 'Mole' WHERE mobId = 45311;
UPDATE droplist SET mob_name = 'Giran Arachnevil Elder' WHERE mobId = 45312;
UPDATE droplist SET mob_name = 'Tiger' WHERE mobId = 45313;
UPDATE droplist SET mob_name = 'Skeletal Pirate Rogue' WHERE mobId = 45314;
UPDATE droplist SET mob_name = 'Incarnation of Varlok' WHERE mobId = 45315;
UPDATE droplist SET mob_name = 'Giran Ancient Giant' WHERE mobId = 45316;
UPDATE droplist SET mob_name = 'Giant - Light' WHERE mobId = 45318;
UPDATE droplist SET mob_name = 'Griffon' WHERE mobId = 45321;
UPDATE droplist SET mob_name = 'Living Armor' WHERE mobId = 45322;
UPDATE droplist SET mob_name = 'Beast Summoner' WHERE mobId = 45323;
UPDATE droplist SET mob_name = 'Bandit' WHERE mobId = 45324;
UPDATE droplist SET mob_name = 'Giran Cimaera' WHERE mobId = 45325;
UPDATE droplist SET mob_name = 'Dark Forester' WHERE mobId = 45326;
UPDATE droplist SET mob_name = 'Dark Elf Ranger' WHERE mobId = 45327;
UPDATE droplist SET mob_name = 'Dillo' WHERE mobId = 45328;
UPDATE droplist SET mob_name = 'Bandit - Dagger' WHERE mobId = 45329;
UPDATE droplist SET mob_name = 'Skeletal Pirate Captain' WHERE mobId = 45330;
UPDATE droplist SET mob_name = 'Middle Oum' WHERE mobId = 45331;
UPDATE droplist SET mob_name = 'Mutant Ramia - Green' WHERE mobId = 45332;
UPDATE droplist SET mob_name = 'Dark Elf Wizard' WHERE mobId = 45333;
UPDATE droplist SET mob_name = 'Giant - Tan' WHERE mobId = 45337;
UPDATE droplist SET mob_name = 'Crocodile' WHERE mobId = 45338;
UPDATE droplist SET mob_name = 'Plate Worm' WHERE mobId = 45339;
UPDATE droplist SET mob_name = 'Heavy Oum' WHERE mobId = 45340;
UPDATE droplist SET mob_name = 'Taurverus' WHERE mobId = 45341;
UPDATE droplist SET mob_name = 'Mutant Giant Queen Ant' WHERE mobId = 45342;
UPDATE droplist SET mob_name = 'Darkmar' WHERE mobId = 45343;
UPDATE droplist SET mob_name = 'Betrayer of Undead' WHERE mobId = 45344;
UPDATE droplist SET mob_name = 'Giran Iron Golem' WHERE mobId = 45345;
UPDATE droplist SET mob_name = 'Ghast Lord' WHERE mobId = 45346;
UPDATE droplist SET mob_name = 'Dark Forester' WHERE mobId = 45347;
UPDATE droplist SET mob_name = 'Mutant Arachnevil Elder' WHERE mobId = 45348;
UPDATE droplist SET mob_name = 'Beholder' WHERE mobId = 45349;
UPDATE droplist SET mob_name = 'Dark Elf Carrier' WHERE mobId = 45350;
UPDATE droplist SET mob_name = 'Giant - Light' WHERE mobId = 45351;
UPDATE droplist SET mob_name = 'Doppelganger' WHERE mobId = 45352;
UPDATE droplist SET mob_name = 'Werewolf' WHERE mobId = 45355;
UPDATE droplist SET mob_name = 'Dark Elf Beast Tamer' WHERE mobId = 45356;
UPDATE droplist SET mob_name = 'Black Tiger' WHERE mobId = 45357;
UPDATE droplist SET mob_name = 'Arachnevil' WHERE mobId = 45358;
UPDATE droplist SET mob_name = 'Astagio' WHERE mobId = 45359;
UPDATE droplist SET mob_name = 'Subterranean Great King Worm' WHERE mobId = 45360;
UPDATE droplist SET mob_name = 'Cockatrice' WHERE mobId = 45361;
UPDATE droplist SET mob_name = 'Cockatrice' WHERE mobId = 45362;
UPDATE droplist SET mob_name = 'Dark Elementalist' WHERE mobId = 45363;
UPDATE droplist SET mob_name = 'Dark Elementalist' WHERE mobId = 45363;
UPDATE droplist SET mob_name = 'Dark Elf' WHERE mobId = 45364;
UPDATE droplist SET mob_name = 'Lava Golem' WHERE mobId = 45365;
UPDATE droplist SET mob_name = 'Mambo Rabbit Servant' WHERE mobId = 45366;
UPDATE droplist SET mob_name = 'Black Ent' WHERE mobId = 45367;
UPDATE droplist SET mob_name = 'Beast Summoner' WHERE mobId = 45368;
UPDATE droplist SET mob_name = 'Salamander' WHERE mobId = 45369;
UPDATE droplist SET mob_name = 'Bandit Leader' WHERE mobId = 45370;
UPDATE droplist SET mob_name = 'Owlbear' WHERE mobId = 45371;
UPDATE droplist SET mob_name = 'Iron Golem' WHERE mobId = 45372;
UPDATE droplist SET mob_name = 'Ettin' WHERE mobId = 45373;
UPDATE droplist SET mob_name = 'Subterranean Lizardman' WHERE mobId = 45374;
UPDATE droplist SET mob_name = 'Giran Lava Golem' WHERE mobId = 45376;
UPDATE droplist SET mob_name = 'Lizardman' WHERE mobId = 45377;
UPDATE droplist SET mob_name = 'Ghast' WHERE mobId = 45378;
UPDATE droplist SET mob_name = 'Dark Elf Wizard' WHERE mobId = 45379;
UPDATE droplist SET mob_name = 'Medusa' WHERE mobId = 45380;
UPDATE droplist SET mob_name = 'Basilisk' WHERE mobId = 45381;
UPDATE droplist SET mob_name = 'Subterranean Scormystic' WHERE mobId = 45382;
UPDATE droplist SET mob_name = 'Subterranean Scorpaitan' WHERE mobId = 45383;
UPDATE droplist SET mob_name = 'Horrific Fire Egg' WHERE mobId = 45384;
UPDATE droplist SET mob_name = 'Nightmare' WHERE mobId = 45385;
UPDATE droplist SET mob_name = 'Dancing Sword' WHERE mobId = 45386;
UPDATE droplist SET mob_name = 'Ramia - Green' WHERE mobId = 45387;
UPDATE droplist SET mob_name = 'Lycanthrope' WHERE mobId = 45389;
UPDATE droplist SET mob_name = 'Minotaur' WHERE mobId = 45390;
UPDATE droplist SET mob_name = 'Succubus of Varlok' WHERE mobId = 45391;
UPDATE droplist SET mob_name = 'Bugbear' WHERE mobId = 45392;
UPDATE droplist SET mob_name = 'Succubus' WHERE mobId = 45393;
UPDATE droplist SET mob_name = 'Succubus' WHERE mobId = 45394;
UPDATE droplist SET mob_name = 'Dark Elf Ranger' WHERE mobId = 45397;
UPDATE droplist SET mob_name = 'Dark Elf Soldier' WHERE mobId = 45398;
UPDATE droplist SET mob_name = 'Wicked Mimic' WHERE mobId = 45399;
UPDATE droplist SET mob_name = 'Succubus' WHERE mobId = 45400;
UPDATE droplist SET mob_name = 'Arachnevil Elder' WHERE mobId = 45401;
UPDATE droplist SET mob_name = 'Raging Skeleton Axeman' WHERE mobId = 45402;
UPDATE droplist SET mob_name = 'Raging Skeleton Pike' WHERE mobId = 45403;
UPDATE droplist SET mob_name = 'Dark Elf Soldier' WHERE mobId = 45404;
UPDATE droplist SET mob_name = 'Black Wizard' WHERE mobId = 45405;
UPDATE droplist SET mob_name = 'Wicked Beholder' WHERE mobId = 45406;
UPDATE droplist SET mob_name = 'Cimaera' WHERE mobId = 45407;
UPDATE droplist SET mob_name = 'Taurverus' WHERE mobId = 45408;
UPDATE droplist SET mob_name = 'Dire Wolf' WHERE mobId = 45409;
UPDATE droplist SET mob_name = 'Dark Elf Guard' WHERE mobId = 45411;
UPDATE droplist SET mob_name = 'Dark Elf Guard' WHERE mobId = 45412;
UPDATE droplist SET mob_name = 'Diego' WHERE mobId = 45413;
UPDATE droplist SET mob_name = 'Dark Elf Beast Tamer' WHERE mobId = 45414;
UPDATE droplist SET mob_name = 'Dark Elf General' WHERE mobId = 45415;
UPDATE droplist SET mob_name = 'Fang of Earth' WHERE mobId = 45416;
UPDATE droplist SET mob_name = 'Death' WHERE mobId = 45417;
UPDATE droplist SET mob_name = 'Fang of Wind' WHERE mobId = 45418;
UPDATE droplist SET mob_name = 'Fang of Glacier' WHERE mobId = 45419;
UPDATE droplist SET mob_name = 'Cyclops' WHERE mobId = 45420;
UPDATE droplist SET mob_name = 'Goblin of Ordeal' WHERE mobId = 45421;
UPDATE droplist SET mob_name = 'Subterranean Great King Turtle' WHERE mobId = 45422;
UPDATE droplist SET mob_name = 'Subterranean Beholder' WHERE mobId = 45423;
UPDATE droplist SET mob_name = 'Fang of Flame' WHERE mobId = 45424;
UPDATE droplist SET mob_name = 'Black Wizard' WHERE mobId = 45425;
UPDATE droplist SET mob_name = 'Nightmare' WHERE mobId = 45440;
UPDATE droplist SET mob_name = 'Griffon' WHERE mobId = 45445;
UPDATE droplist SET mob_name = 'Dark Elf Ranger' WHERE mobId = 45446;
UPDATE droplist SET mob_name = 'Dark Elf Wizard' WHERE mobId = 45447;
UPDATE droplist SET mob_name = 'Minotaur' WHERE mobId = 45449;
UPDATE droplist SET mob_name = 'Succubus Queen of Varlok' WHERE mobId = 45450;
UPDATE droplist SET mob_name = 'Succubus Queen' WHERE mobId = 45451;
UPDATE droplist SET mob_name = 'Harpy' WHERE mobId = 45452;
UPDATE droplist SET mob_name = 'Heavy Oum' WHERE mobId = 45453;
UPDATE droplist SET mob_name = 'Raging Ghoul' WHERE mobId = 45454;
UPDATE droplist SET mob_name = 'Raging Spartoi' WHERE mobId = 45455;
UPDATE droplist SET mob_name = 'Necromancer' WHERE mobId = 45456;
UPDATE droplist SET mob_name = 'Doppelganger' WHERE mobId = 45457;
UPDATE droplist SET mob_name = 'Captain Drake' WHERE mobId = 45458;
UPDATE droplist SET mob_name = 'Medusa' WHERE mobId = 45463;
UPDATE droplist SET mob_name = 'Sema' WHERE mobId = 45464;
UPDATE droplist SET mob_name = 'Cursed Orc Zombie' WHERE mobId = 45468;
UPDATE droplist SET mob_name = 'Crocodile' WHERE mobId = 45469;
UPDATE droplist SET mob_name = 'Ghast Lord' WHERE mobId = 45470;
UPDATE droplist SET mob_name = 'Horrific Cerberus' WHERE mobId = 45471;
UPDATE droplist SET mob_name = 'Dark Elf General' WHERE mobId = 45472;
UPDATE droplist SET mob_name = 'Baltuzar' WHERE mobId = 45473;
UPDATE droplist SET mob_name = 'Cerberus' WHERE mobId = 45476;
UPDATE droplist SET mob_name = 'Troll' WHERE mobId = 45477;
UPDATE droplist SET mob_name = 'Horrific Iron Golem' WHERE mobId = 45479;
UPDATE droplist SET mob_name = 'Fire Necromancer' WHERE mobId = 45480;
UPDATE droplist SET mob_name = 'Lesser Demon' WHERE mobId = 45481;
UPDATE droplist SET mob_name = 'Lesser Demon of Varlok' WHERE mobId = 45482;
UPDATE droplist SET mob_name = 'Black Tiger' WHERE mobId = 45483;
UPDATE droplist SET mob_name = 'Dark Lycanthrope' WHERE mobId = 45485;
UPDATE droplist SET mob_name = 'Subterranean Elekkadom' WHERE mobId = 45487;
UPDATE droplist SET mob_name = 'Caspa' WHERE mobId = 45488;
UPDATE droplist SET mob_name = 'Kuman' WHERE mobId = 45492;
UPDATE droplist SET mob_name = 'Raging Skeleton Fighter' WHERE mobId = 45493;
UPDATE droplist SET mob_name = 'Raging Skeleton Marksman' WHERE mobId = 45494;
UPDATE droplist SET mob_name = 'Lesser Dragon' WHERE mobId = 45496;
UPDATE droplist SET mob_name = 'Merkyor' WHERE mobId = 45497;
UPDATE droplist SET mob_name = 'Grave Guardian' WHERE mobId = 45498;
UPDATE droplist SET mob_name = 'Vampire' WHERE mobId = 45499;
UPDATE droplist SET mob_name = 'Water Spirit Master' WHERE mobId = 45500;
UPDATE droplist SET mob_name = 'Abyss Ghoul' WHERE mobId = 45501;
UPDATE droplist SET mob_name = 'Abyss Archer' WHERE mobId = 45502;
UPDATE droplist SET mob_name = 'Black Knight of Darkness' WHERE mobId = 45503;
UPDATE droplist SET mob_name = 'Assassin Master' WHERE mobId = 45504;
UPDATE droplist SET mob_name = 'Ettin' WHERE mobId = 45505;
UPDATE droplist SET mob_name = 'Cursed Elmore Wizard' WHERE mobId = 45506;
UPDATE droplist SET mob_name = 'Disciple of Death' WHERE mobId = 45507;
UPDATE droplist SET mob_name = 'Earth Spirit Master' WHERE mobId = 45508;
UPDATE droplist SET mob_name = 'King Bugbear' WHERE mobId = 45509;
UPDATE droplist SET mob_name = 'Wind Spirit Master' WHERE mobId = 45510;
UPDATE droplist SET mob_name = 'Fire Spirit Master' WHERE mobId = 45511;
UPDATE droplist SET mob_name = 'Zenith Queen' WHERE mobId = 45513;
UPDATE droplist SET mob_name = 'Fire Ghost' WHERE mobId = 45514;
UPDATE droplist SET mob_name = 'Ifrit' WHERE mobId = 45515;
UPDATE droplist SET mob_name = 'Basilisk' WHERE mobId = 45516;
UPDATE droplist SET mob_name = 'Fire Ghost' WHERE mobId = 45519;
UPDATE droplist SET mob_name = 'Spirit Taurverus of Fire' WHERE mobId = 45520;
UPDATE droplist SET mob_name = 'Bone Dragon' WHERE mobId = 45522;
UPDATE droplist SET mob_name = 'Cursed Elmore Soldier' WHERE mobId = 45524;
UPDATE droplist SET mob_name = 'Cruel Snow Tiger' WHERE mobId = 45528;
UPDATE droplist SET mob_name = 'Drake' WHERE mobId = 45529;
UPDATE droplist SET mob_name = 'Grave Guardian Mage' WHERE mobId = 45530;
UPDATE droplist SET mob_name = 'Basilisk' WHERE mobId = 45531;
UPDATE droplist SET mob_name = 'Fire Archer of Darkness' WHERE mobId = 45532;
UPDATE droplist SET mob_name = 'Mambo Rabbit Pink Vest' WHERE mobId = 45534;
UPDATE droplist SET mob_name = 'Mambo Rabbit Orange Vest' WHERE mobId = 45535;
UPDATE droplist SET mob_name = 'Priest of Death' WHERE mobId = 45536;
UPDATE droplist SET mob_name = 'Grave Guardian Knight' WHERE mobId = 45537;
UPDATE droplist SET mob_name = 'Cyclops' WHERE mobId = 45538;
UPDATE droplist SET mob_name = 'Thing' WHERE mobId = 45539;
UPDATE droplist SET mob_name = 'Fire Warrior of Darkness' WHERE mobId = 45540;
UPDATE droplist SET mob_name = 'Cursed Elmore General' WHERE mobId = 45541;
UPDATE droplist SET mob_name = 'Priest of Death' WHERE mobId = 45542;
UPDATE droplist SET mob_name = 'Priest of Chaos' WHERE mobId = 45543;
UPDATE droplist SET mob_name = 'Guardian Armor' WHERE mobId = 45562;
UPDATE droplist SET mob_name = 'Baphomet of Varlok' WHERE mobId = 45569;
UPDATE droplist SET mob_name = 'Priest of Corruption' WHERE mobId = 45570;
UPDATE droplist SET mob_name = 'Priest of Corruption' WHERE mobId = 45571;
UPDATE droplist SET mob_name = 'Astagio of Fire' WHERE mobId = 45572;
UPDATE droplist SET mob_name = 'Baphomet' WHERE mobId = 45573;
UPDATE droplist SET mob_name = 'Disciple of Death' WHERE mobId = 45575;
UPDATE droplist SET mob_name = 'Priest of Chaos' WHERE mobId = 45576;
UPDATE droplist SET mob_name = 'Drake' WHERE mobId = 45578;
UPDATE droplist SET mob_name = 'Beleth' WHERE mobId = 45583;
UPDATE droplist SET mob_name = 'Greater Minotaur' WHERE mobId = 45584;
UPDATE droplist SET mob_name = 'Lesser Seer' WHERE mobId = 45586;
UPDATE droplist SET mob_name = 'Lich' WHERE mobId = 45672;
UPDATE droplist SET mob_name = 'Sea Depths Zombie' WHERE mobId = 45715;
UPDATE droplist SET mob_name = 'Troglodyte Scout' WHERE mobId = 45716;
UPDATE droplist SET mob_name = 'Sea Depths Ghoul' WHERE mobId = 45718;
UPDATE droplist SET mob_name = 'Grave Crocodile' WHERE mobId = 45719;
UPDATE droplist SET mob_name = 'Drowned Male' WHERE mobId = 45720;
UPDATE droplist SET mob_name = 'Drowned Female' WHERE mobId = 45721;
UPDATE droplist SET mob_name = 'Shark' WHERE mobId = 45724;
UPDATE droplist SET mob_name = 'Grave Crabman' WHERE mobId = 45725;
UPDATE droplist SET mob_name = 'Bone Eel' WHERE mobId = 45726;
UPDATE droplist SET mob_name = 'Grave Sea Dancer' WHERE mobId = 45727;
UPDATE droplist SET mob_name = 'Deep Sea Fish' WHERE mobId = 45728;
UPDATE droplist SET mob_name = 'Hidden Deep Sea Fish' WHERE mobId = 45729;
UPDATE droplist SET mob_name = 'Ugly Mermaid' WHERE mobId = 45730;
UPDATE droplist SET mob_name = 'Hidden Ugly Mermaid' WHERE mobId = 45731;
UPDATE droplist SET mob_name = 'Grave Elekkadom' WHERE mobId = 45732;
UPDATE droplist SET mob_name = 'Grave Crustacean' WHERE mobId = 45733;
UPDATE droplist SET mob_name = 'Lesser Demon' WHERE mobId = 45736;
UPDATE droplist SET mob_name = 'Polluted Pan' WHERE mobId = 45776;
UPDATE droplist SET mob_name = 'Polluted Great Spirit of Water' WHERE mobId = 45788;
UPDATE droplist SET mob_name = 'Maino' WHERE mobId = 45797;
UPDATE droplist SET mob_name = 'Rodeck' WHERE mobId = 45887;
UPDATE droplist SET mob_name = 'Atushin' WHERE mobId = 45888;
UPDATE droplist SET mob_name = 'Toda' WHERE mobId = 45889;
UPDATE droplist SET mob_name = 'Oum' WHERE mobId = 45890;
UPDATE droplist SET mob_name = 'Cursed Vakuuk' WHERE mobId = 45920;
UPDATE droplist SET mob_name = 'Cursed Troglodyte' WHERE mobId = 45921;

