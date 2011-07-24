-- Thebes updates for LinRet -- July 10, 2011 -- Zylia

# Cleanup invalid mob data 46107 = Mandragora not Treasure Chest of Aden Castle
UPDATE npc set name = 'Mandragora - White' where npcid = 46107;
UPDATE npc set name = 'Mandragora - Dark' where npcid = 46108;
UPDATE npc set name = 'Scarab - Yellow' where npcid = 46109;
UPDATE npc set name = 'Scarab - Blue' where npcid = 46110;
UPDATE npc set name = 'Kalbis - Dark' where npcid = 46111;
UPDATE npc set name = 'Kalbis - Red' where npcid = 46112;
UPDATE npc set name = 'Obelisk - White' where npcid = 46113;
UPDATE npc set name = 'Obelisk - Dark' where npcid = 46114;
UPDATE npc set name = 'Sphinx - White' where npcid = 46115;
UPDATE npc set name = 'Sphinx - Dark' where npcid = 46116;
UPDATE npc set name = 'Horus Falcon - Yellow' where npcid = 46117;
UPDATE npc set name = 'Horus Falcon - Blue' where npcid = 46118;
UPDATE npc set name = 'Thebes Guardian - Dark' where npcid = 46119;
UPDATE npc set name = 'Thebes Guardian - Red' where npcid = 46120;
UPDATE npc set name = 'Thebes Elder - Yellow' where npcid = 46121;
UPDATE npc set name = 'Thebes Elder - Purple' where npcid = 46122;
UPDATE npc set note = 'White' where npcid = 46107;
UPDATE npc set note = 'Black' where npcid = 46108;
UPDATE npc set note = 'Yellow' where npcid = 46109;
UPDATE npc set note = 'Black' where npcid = 46110;
UPDATE npc set note = 'Black' where npcid = 46111;
UPDATE npc set note = 'Red' where npcid = 46112;
UPDATE npc set note = 'White' where npcid = 46113;
UPDATE npc set note = 'Black' where npcid = 46114;
UPDATE npc set note = 'White' where npcid = 46115;
UPDATE npc set note = 'Black' where npcid = 46116;
UPDATE npc set note = 'Yellow' where npcid = 46117;
UPDATE npc set note = 'Blue' where npcid = 46118;
UPDATE npc set note = 'Black' where npcid = 46119;
UPDATE npc set note = 'Red' where npcid = 46120;
UPDATE npc set note = 'Yellow' where npcid = 46121;
UPDATE npc set note = 'Purple' where npcid = 46122;

# Update dungeon content
UPDATE dungeon SET src_loc_name = 'Thebes Desert' WHERE src_mapid = 780;
UPDATE dungeon SET new_loc_name = 'Thebes Desert' WHERE src_mapid = 780;
UPDATE dungeon SET src_loc_name = 'Thebes Pyramid Inside' WHERE src_mapid = 781;
UPDATE dungeon SET new_loc_name = 'Thebes Pyramid Inside' WHERE src_mapid = 781;

# Update getback content
UPDATE getback SET note = 'Thebes Desert' WHERE area_mapid = 780;
UPDATE getback SET note = 'Thebes Pyramid Inside' WHERE area_mapid = 781;
UPDATE getback SET note = 'Thebes Osiris Altar' WHERE area_mapid = 782;

# Update getback_restart content
UPDATE getback_restart SET note = 'Thebes Desert' WHERE area = 780;
UPDATE getback_restart SET note = 'Thebes Pyramid Inside' WHERE area = 781;
UPDATE getback_restart SET note = 'Thebes Osiris Altar' WHERE area = 782;

# map: 780
UPDATE mapids SET locationname = 'Thebes Desert' where mapid = 780;
INSERT INTO spawnlist VALUES
(78000001,'Mandragora - White',20,46107,0,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0),
(78000002,'Mandragora - Dark',20,46108,0,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0),
(78000003,'Scarab - Yellow',20,46109,0,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0),
(78000004,'Scarab - Blue',20,46110,0,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0),
(78000005,'Kalbis - Dark',15,46111,0,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0),
(78000006,'Kalbis - Red',15,46112,0,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0),
(78000007,'Obelisk - White',15,46113,0,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0),
(78000008,'Obelisk - Dark',15,46114,0,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0),
(78000009,'Sphinx - White',6,46115,0,32740,32893,0,0,32702,32782,32778,33005,0,0,0,780,0,0,0,0),
(78000010,'Sphinx - Dark',6,46116,0,32740,32893,0,0,32702,32782,32778,33005,0,0,0,780,0,0,0,0);

# Mob Groups
(63, 46107,'Mandragora - White', x2
(46108,'Mandragora - Dark', x2
(46109,'Scarab - Yellow', x3
(46110,'Scarab - Blue', x2

# map: 781
UPDATE mapids SET locationname = 'Thebes Pyramid Inside' where mapid = 781;
INSERT INTO spawnlist VALUES
(78100001,'Horus Falcon - Yellow',3,46117,0,32757,32845,0,0,32730,32828,32784,32862,0,0,0,781,1,0,0,0),
(78100003,'Horus Falcon - Yellow',2,46117,0,32790,32794,0,0,32758,32727,32822,32861,0,0,0,781,1,0,0,0),
(78100009,'Horus Falcon - Yellow',3,46117,0,32942,32858,0,0,32892,32847,32993,32870,0,0,0,781,1,0,0,0),
(78100015,'Horus Falcon - Yellow',3,46117,0,32870,32746,0,0,32828,32729,32913,32764,0,0,0,781,1,0,0,0),
(78100021,'Horus Falcon - Yellow',3,46117,0,32913,32792,0,0,32838,32775,32989,32809,0,0,0,781,1,0,0,0),
(78100002,'Horus Falcon - Blue',3,46118,0,32757,32845,0,0,32730,32828,32784,32862,0,0,0,781,1,0,0,0),
(78100004,'Horus Falcon - Blue',2,46118,0,32790,32794,0,0,32758,32727,32822,32861,0,0,0,781,1,0,0,0),
(78100010,'Horus Falcon - Blue',3,46118,0,32942,32858,0,0,32892,32847,32993,32870,0,0,0,781,1,0,0,0),
(78100016,'Horus Falcon - Blue',3,46118,0,32870,32746,0,0,32828,32729,32913,32764,0,0,0,781,1,0,0,0),
(78100022,'Horus Falcon - Blue',3,46118,0,32913,32792,0,0,32838,32775,32989,32809,0,0,0,781,1,0,0,0),
(78100005,'Thebes Guardian - Dark',3,46119,0,32790,32794,0,0,32758,32727,32822,32861,0,0,0,781,1,0,0,0),
(78100011,'Thebes Guardian - Dark',3,46119,0,32942,32858,0,0,32892,32847,32993,32870,0,0,0,781,1,0,0,0),
(78100017,'Thebes Guardian - Dark',3,46119,0,32870,32746,0,0,32828,32729,32913,32764,0,0,0,781,1,0,0,0),
(78100023,'Thebes Guardian - Dark',3,46119,0,32913,32792,0,0,32838,32775,32989,32809,0,0,0,781,1,0,0,0),
(78100006,'Thebes Guardian - Red',3,46120,0,32790,32794,0,0,32758,32727,32822,32861,0,0,0,781,1,0,0,0),
(78100012,'Thebes Guardian - Red',3,46120,0,32942,32858,0,0,32892,32847,32993,32870,0,0,0,781,1,0,0,0),
(78100018,'Thebes Guardian - Red',3,46120,0,32870,32746,0,0,32828,32729,32913,32764,0,0,0,781,1,0,0,0),
(78100024,'Thebes Guardian - Red',3,46120,0,32913,32792,0,0,32838,32775,32989,32809,0,0,0,781,1,0,0,0),
(78100007,'Thebes Elder - Yellow',3,46121,0,32790,32794,0,0,32758,32727,32822,32861,0,0,0,781,1,0,0,0),
(78100013,'Thebes Elder - Yellow',3,46121,0,32942,32858,0,0,32892,32847,32993,32870,0,0,0,781,1,0,0,0),
(78100019,'Thebes Elder - Yellow',3,46121,0,32870,32746,0,0,32828,32729,32913,32764,0,0,0,781,1,0,0,0),
(78100025,'Thebes Elder - Yellow',3,46121,0,32913,32792,0,0,32838,32775,32989,32809,0,0,0,781,1,0,0,0),
(78100008,'Thebes Elder - Purple',3,46122,0,32790,32794,0,0,32758,32727,32822,32861,0,0,0,781,1,0,0,0),
(78100014,'Thebes Elder - Purple',3,46122,0,32942,32858,0,0,32892,32847,32993,32870,0,0,0,781,1,0,0,0),
(78100020,'Thebes Elder - Purple',3,46122,0,32870,32746,0,0,32828,32729,32913,32764,0,0,0,781,1,0,0,0),
(78100026,'Thebes Elder - Purple',,46122,0,32913,32792,0,0,32838,32775,32989,32809,0,0,0,781,1,0,0,0);

# map: 782
UPDATE mapids SET locationname = 'Thebes Osiris Altar' where mapid = 782;
INSERT INTO spawnlist_boss VALUES
(124,'Thebes Anubis','etc1',1,46124,0,32782,32827,0,0,0,0,0,0,6,782,1,0,0,0,100),
(125,'Thebes Horus','etc1',1,46123,0,32782,32836,0,0,0,0,0,0,6,782,1,0,0,0,100);

# Remove old droplist entries for Thebes Mobs
DELETE FROM droplist WHERE mobid = 46106;
DELETE FROM droplist WHERE mobid = 46107;
DELETE FROM droplist WHERE mobid = 46108;
DELETE FROM droplist WHERE mobid = 46111;
DELETE FROM droplist WHERE mobid = 46112;
DELETE FROM droplist WHERE mobid = 46115;
DELETE FROM droplist WHERE mobid = 46116;
DELETE FROM droplist WHERE mobid = 46121;
DELETE FROM droplist WHERE mobid = 46122;

# Add Droplist missing Data
INSERT INTO droplist VALUES
(46107,'Mandragora - White',49101,'Fragment of Time',3,3,150000),
(46107,'Mandragora - White',40020,'Condensed Healing Potion',1,1,100000),
(46107,'Mandragora - White',49093,'Piece of Low-grade Treasure Chest of Osiris (Upper)',1,1,50000),
(46107,'Mandragora - White',40304,'Relic of Maphr',1,1,10000),
(46107,'Mandragora - White',49111,'Dragon Tablet(AwakenFafurion)',1,1,5000),
(46108,'Mandragora - Dark',49101,'Fragment of Time',3,3,50000),
(46108,'Mandragora - Dark',40020,'Condensed Healing Potion',1,1,100000),
(46108,'Mandragora - Dark',49094,'Piece of Low-grade Treasure Chest of Osiris (Lower)',1,1,20000),
(46108,'Mandragora - Dark',40304,'Relic of Maphr',1,1,10000),
(46109,'Scarab - Yellow',49101,'Fragment of Time',3,3,150000),
(46109,'Scarab - Yellow',40020,'Condensed Healing Potion',1,1,100000),
(46109,'Scarab - Yellow',49093,'Piece of Low-grade Treasure Chest of Osiris (Upper)',1,1,50000),
(46109,'Scarab - Yellow',40304,'Relic of Maphr',1,1,10000),
(46110,'Scarab - Blue',49101,'Fragment of Time',3,3,150000),
(46110,'Scarab - Blue',40020,'Condensed Healing Potion',1,1,100000),
(46110,'Scarab - Blue',49094,'Piece of Low-grade Treasure Chest of Osiris (Lower)',1,1,20000),
(46110,'Scarab - Blue',40304,'Relic of Maphr',1,1,10000),
(46111,'Kalbis - Dark',49101,'Fragment of Time',3,3,150000),
(46111,'Kalbis - Dark',40020,'Condensed Healing Potion',1,1,100000),
(46111,'Kalbis - Dark',49093,'Piece of Low-grade Treasure Chest of Osiris (Upper)',1,1,50000),
(46111,'Kalbis - Dark',40304,'Relic of Maphr',1,1,10000),
(46111,'Kalbis - Dark',49106,'Dragon Tablet(AwakenAntharas)',1,1,5000),
(46112,'Kalbis - Red',49101,'Fragment of Time',3,3,150000),
(46112,'Kalbis - Red',40020,'Condensed Healing Potion',1,1,100000),
(46112,'Kalbis - Red',49094,'Piece of Low-grade Treasure Chest of Osiris (Lower)',1,1,10000),
(46112,'Kalbis - Red',40304,'Relic of Maphr',1,1,10000),
(46112,'Kalbis - Red',49106,'Dragon Tablet(AwakenAntharas)',1,1,5000),
(46113,'Obelisk - White',49101,'Fragment of Time',3,3,150000),
(46113,'Obelisk - White',40020,'Condensed Healing Potion',1,1,100000),
(46113,'Obelisk - White',49093,'Piece of Low-grade Treasure Chest of Osiris (Upper)',1,1,50000),
(46113,'Obelisk - White',40304,'Relic of Maphr',1,1,10000),
(46113,'Obelisk - White',49126,'Memory Crystal(CubeQuake)',1,1,5000),
(46114,'Obelisk - Dark',49101,'Fragment of Time',3,3,150000),
(46114,'Obelisk - Dark',40020,'Condensed Healing Potion',1,1,100000),
(46114,'Obelisk - Dark',49094,'Piece of Low-grade Treasure Chest of Osiris (Lower)',1,1,10000),
(46114,'Obelisk - Dark',40304,'Relic of Maphr',1,1,10000),
(46114,'Obelisk - Dark',49126,'Memory Crystal(CubeQuake)',1,1,5000),
(46115,'Sphinx - White',49101,'Fragment of Time',3,3,150000),
(46115,'Sphinx - White',40020,'Condensed Healing Potion',1,1,100000),
(46115,'Sphinx - White',49093,'Piece of Low-grade Treasure Chest of Osiris (Upper)',1,1,20000),
(46115,'Sphinx - White',40304,'Relic of Maphr',1,1,10000),
(46115,'Sphinx - White',49110,'Dragon Tablet(ShockSkin)',1,1,500),
(46116,'Sphinx - Dark',49101,'Fragment of Time',3,3,150000),
(46116,'Sphinx - Dark',40020,'Condensed Healing Potion',1,1,100000),
(46116,'Sphinx - Dark',49094,'Piece of Low-grade Treasure Chest of Osiris (Lower)',1,1,20000),
(46116,'Sphinx - Dark',40304,'Relic of Maphr',1,1,10000),
(46116,'Sphinx - Dark',49110,'Dragon Tablet(ShockSkin)',1,1,500),
(46117,'Horus Falcon - Yellow',49101,'Fragment of Time',3,3,150000),
(46117,'Horus Falcon - Yellow',49242,'Thebes Osiris Altar Key',1,1,20000),
(46117,'Horus Falcon - Yellow',40021,'Condensed Greater Healing Potion',1,1,100000),
(46117,'Horus Falcon - Yellow',49097,'Piece of High-grade Treasure Chest of Osiris (Upper)',1,1,50000),
(46117,'Horus Falcon - Yellow',40304,'Relic of Maphr',1,1,10000),
(46118,'Horus Falcon - Blue',49101,'Fragment of Time',3,3,150000),
(46118,'Horus Falcon - Blue',49242,'Thebes Osiris Altar Key',1,1,20000),
(46118,'Horus Falcon - Blue',40021,'Condensed Greater Healing Potion',1,1,100000),
(46118,'Horus Falcon - Blue',49098,'Piece of High-grade Treasure Chest of Osiris (Lower)',1,1,10000),
(46118,'Horus Falcon - Blue',40304,'Relic of Maphr',1,1,10000),
(46119,'Thebes Guardian - Dark',49101,'Fragment of Time',3,3,150000),
(46119,'Thebes Guardian - Dark',49242,'Thebes Osiris Altar Key',1,1,20000),
(46119,'Thebes Guardian - Dark',40021,'Condensed Greater Healing Potion',1,1,100000),
(46119,'Thebes Guardian - Dark',49097,'Piece of High-grade Treasure Chest of Osiris (Upper)',1,1,50000),
(46119,'Thebes Guardian - Dark',40304,'Relic of Maphr',1,1,10000),
(46120,'Thebes Guardian - Red',49101,'Fragment of Time',3,3,150000),
(46120,'Thebes Guardian - Red',49242,'Thebes Osiris Altar Key',1,1,20000),
(46120,'Thebes Guardian - Red',40021,'Condensed Greater Healing Potion',1,1,100000),
(46120,'Thebes Guardian - Red',49098,'Piece of High-grade Treasure Chest of Osiri (Lower)s',1,1,10000),
(46120,'Thebes Guardian - Red',40304,'Relic of Maphr',1,1,10000),
(46121,'Thebes Elder - Yellow',49101,'Fragment of Time',3,3,150000),
(46121,'Thebes Elder - Yellow',49242,'Thebes Osiris Altar Key',1,1,20000),
(46121,'Thebes Elder - Yellow',40021,'Condensed Greater Healing Potion',1,1,100000),
(46121,'Thebes Elder - Yellow',49097,'Piece of High-grade Treasure Chest of Osiris (Upper)',1,1,50000),
(46121,'Thebes Elder - Yellow',40304,'Relic of Maphr',1,1,10000),
(46121,'Thebes Elder - Yellow',49113,'Dragon Tablet(ThunderGrab)',1,1,3000),
(46122,'Thebes Elder - Purple',49101,'Fragment of Time',3,3,150000),
(46122,'Thebes Elder - Purple',49242,'Thebes Osiris Altar Key',1,1,20000),
(46122,'Thebes Elder - Purple',40021,'Condensed Greater Healing Potion'1,1,100000),
(46122,'Thebes Elder - Purple',49098,'Piece of High-grade Treasure Chest of Osiris (Lower)',1,1,10000),
(46122,'Thebes Elder - Purple',40304,'Relic of Maphr',1,1,10000),
(46122,'Thebes Elder - Purple',49113,'Dragon Tablet(ThunderGrab)',1,1,3000),
(46124,'Thebes Anubis'20264,'Amulet of Strength',1,1,5000),
(46124,'Thebes Anubis'20256,'Amulet of Dexterity',1,1,10000),
(46124,'Thebes Anubis'20268,'Amulet of Constitution',1,1,7500),
(46124,'Thebes Anubis'20266,'Amulet of Intelligence',1,1,3000),
(46124,'Thebes Anubis'20267,'Amulet of Wisdom',1,1,5000),
(46124,'Thebes Anubis'20254,'Amulet of Charisma',1,1,5000),
(46124,'Thebes Anubis'20284,'Ring of Summon Control',1,1,20000),
(46124,'Thebes Anubis'20281,'Ring of Polymorph Conrol',1,1,15000),
(46124,'Thebes Anubis'20288,'Ring of Teleport Control',1,1,20000),
(46124,'Thebes Anubis'20303,'Ring of Magic Resistance',1,1,3000),
(46124,'Thebes Anubis'20280,'Ring of Immunity to Magic',1,1,1500),
(46124,'Thebes Anubis'21095,'Belt of Thebes Osiris',1,1,1000),
(46124,'Thebes Anubis'21093,'Ring of Thebes Osiris',1,1,1000),
(46124,'Thebes Anubis'21094,'Ring of Thebes Anubis',1,1,1000),
(46124,'Thebes Anubis'40024,'Ancient Greater Healing Potion',1,20,1000000),
(46124,'Thebes Anubis'49099,'Locked High-Grade Treasure Chest of Osiris',1,1,1000000),
(46124,'Thebes Anubis'49092,'Cracked Nucleus',1,1,1000000),
(46124,'Thebes Anubis'140100,'Scroll of Teleportation',1,1,500000),
(46124,'Thebes Anubis'40087,'Scroll of Enchant Weapon',1,1,1000000),
(46124,'Thebes Anubis'140087,'Scroll of Enchant Weapon',1,1,500000),
(46124,'Thebes Anubis'40074,'Scroll of Enchant Armor',1,1,1000000),
(46124,'Thebes Anubis'140074,'Scroll of Enchant Armor',1,1,500000),
(46123,'Thebes Horus',20264,'Amulet of Strength',1,1,5000),
(46123,'Thebes Horus',20256,'Amulet of Dexterity',1,1,10000),
(46123,'Thebes Horus',20268,'Amulet of Constitution',1,1,7500),
(46123,'Thebes Horus',20266,'Amulet of Intelligence',1,1,3000),
(46123,'Thebes Horus',20267,'Amulet of Wisdom',1,1,5000),
(46123,'Thebes Horus',20254,'Amulet of Charisma',1,1,5000),
(46123,'Thebes Horus',20284,'Ring of Summon Control',1,1,20000),
(46123,'Thebes Horus',20281,'Ring of Polymorph Conrol',1,1,15000),
(46123,'Thebes Horus',20288,'Ring of Teleport Control',1,1,20000),
(46123,'Thebes Horus',20303,'Ring of Magic Resistance',1,1,3000),
(46123,'Thebes Horus',20280,'Ring of Immunity to Magic',1,1,1500),
(46123,'Thebes Horus',21095,'Belt of Thebes Osiris',1,1,1000),
(46123,'Thebes Horus',21093,'Ring of Thebes Osiris',1,1,1000),
(46123,'Thebes Horus',21094,'Ring of Thebes Anubis',1,1,1000),
(46123,'Thebes Horus',40024,'Ancient Greater Healing Potion',1,20,1000000),
(46123,'Thebes Horus',49099,'Locked High-Grade Treasure Chest of Osiris',1,1,1000000),
(46123,'Thebes Horus',49092,'Cracked Nucleus',1,1,1000000),
(46123,'Thebes Horus',140100,'Scroll of Teleportation',1,1,500000),
(46123,'Thebes Horus',40087,'Scroll of Enchant Weapon',1,1,1000000),
(46123,'Thebes Horus',140087,'Scroll of Enchant Weapon',1,1,500000),
(46123,'Thebes Horus',40074,'Scroll of Enchant Armor',1,1,1000000),
(46123,'Thebes Horus',140074,'Scroll of Enchant Armor',1,1,500000);

# Crack of Time Locations
# map 4, 32732, 32698, Gludio Greater Wastelands SW
# map 4, 32832, 32647, Gludio Greater Wastelands N
# map 4, 32851, 32713, Gludio Greater Wastelands E
# map 4, 32910, 33170, Windawood Desert NW Oasis
# map 4, 32960, 33252, Windawood Desert NE Oasis
# map 4, 32914, 33427, Windawood Desert E
# map 4, 34257, 33203, Twilight Mountains SW
# map 4, 34226, 33313, Twilight Mountains S
# map 4, 34272, 33361, Twilight Mountains SE

# Mobskills compiled and corrected by Valakas
INSERT into mobskills VALUES
(46111,0,'Kalbis - Dark','',1,30,0,0,-1,0,0,1,0,0,15,0,0,30,0,0,0,0),
(46112,0,'Kalbis - Red','',1,10,0,0,-1,0,0,1,0,0,15,0,0,30,0,0,0,0),
(46113,0,'Obelisk - White','Tornado',2,10,0,0,-4,0,0,0,0,0,20,10131,0,0,0,0,0,0),
(46113,1,'Obelisk - White','',1,30,0,0,-1,0,0,1,0,0,15,0,0,1,0,0,0,0),
(46114,0,'Obelisk - Dark','Tornado',2,10,0,0,-4,0,0,0,0,0,20,10131,0,0,0,0,0,0),
(46114,1,'Obelisk - Dark','',1,30,0,0,-1,0,0,1,0,0,15,0,0,1,0,0,0,0),
(46115,0,'Sphinx - White','',1,30,0,0,-1,0,0,1,0,0,15,0,0,30,0,0,0,0),
(46115,1,'Sphinx - White','',2,15,0,0,-2,0,0,0,0,0,10,10132,0,3,0,0,0,0),
(46116,0,'Sphinx - Dark','',1,30,0,0,-1,0,0,1,0,0,15,0,0,30,0,0,0,0),
(46116,1,'Sphinx - Dark','',2,15,0,0,-2,0,0,0,0,0,10,10132,0,0,0,0,0,0),
(46117,0,'Horus Falcon - Yellow','',2,20,0,0,-6,0,0,0,0,0,12,10137,0,0,0,0,0,0),
(46118,0,'Horus Falcon - Blue','',2,20,0,0,-6,0,0,0,0,0,12,10137,0,0,0,0,0,0),
(46119,0,'Thebes Guardian - Dark','',1,10,0,0,-2,0,0,2,0,0,5,0,0,30,0,0,0,0),
(46120,0,'Thebes Guardian - Red','',1,10,0,0,-2,0,0,2,0,0,5,0,0,30,0,0,0,0),
(46121,0,'Thebes Elder - Yellow','Lightning Storm',2,30,0,0,-10,0,0,0,0,0,20,65,0,0,0,0,0,0),
(46121,1,'Thebes Elder - Yellow','',1,20,0,0,-1,0,0,1,0,0,5,0,0,30,0,0,0,0),
(46122,0,'Thebes Elder - Purple','Lightning Storm',2,30,0,0,-10,0,0,0,0,0,20,65,0,0,0,0,0,0),
(46122,1,'Thebes Elder - Purple','',1,20,0,0,-1,0,0,1,0,0,5,0,0,30,0,0,0,0),
(46123,0,'Thebes Horus','',2,25,0,0,-6,0,0,0,0,0,6,10138,0,0,0,0,0,0),
(46123,1,'Thebes Horus','',2,10,0,0,-4,0,0,0,0,0,8,10140,0,0,0,0,0,0),
(46123,2,'Thebes Horus','',1,20,0,0,-1,0,0,1,0,2,10,0,0,30,0,0,0,0),
(46123,3,'Thebes Horus','Summon Horus Falcon',3,10,0,0,-3,3,0,0,0,0,0,0,0,18,46118,2,2,0),
(46124,0,'Thebes Anubis','',2,25,0,0,-6,0,0,0,0,0,6,10139,0,0,0,0,0,0),
(46124,1,'Thebes Anubis','',2,10,0,0,-4,0,0,0,0,0,8,10141,0,0,0,0,0,0),
(46124,2,'Thebes Anubis','',1,10,0,0,-1,0,0,1,0,2,10,0,0,30,0,0,0,0),
(46124,3,'Thebes Anubis','Summon Thebes Guardian',3,10,0,0,-3,3,0,0,0,0,0,0,0,18,46120,2,2,0),
(46124,4,'Thebes Anubis','Summon Thebes Elder',3,10,0,0,-3,3,0,0,0,0,0,0,0,18,46122,2,2,0);

# update npc info
UPDATE npc set name = 'Mandragora' where npcid = 46107;
UPDATE npc set agrofamily = 1 where npcid = 46107;
UPDATE npc set name = 'Mandragora' where npcid = 46108;
UPDATE npc set agrofamily = 1 where npcid = 46108;
UPDATE npc set agro = 1 where npcid = 46108;
UPDATE npc set agrososc = 1 where npcid = 46108;
UPDATE npc set name = 'Scarab' where npcid = 46109;
UPDATE npc set agrofamily = 1 where npcid = 46109;
UPDATE npc set name = 'Scarab' where npcid = 46110;
UPDATE npc set agrofamily = 1 where npcid = 46110;
UPDATE npc set name = 'Kalbis' where npcid = 46111;
UPDATE npc set agrofamily = 1 where npcid = 46111;
UPDATE npc set name = 'Kalbis' where npcid = 46112;
UPDATE npc set agrofamily = 1 where npcid = 46112;
UPDATE npc set name = 'Obelisk' where npcid = 46113;
UPDATE npc set agrofamily = 1 where npcid = 46113;
UPDATE npc set name = 'Obelisk' where npcid = 46114;
UPDATE npc set agrofamily = 1 where npcid = 46114;
UPDATE npc set agro = 1 where npcid = 46114;
UPDATE npc set agrososc = 1 where npcid = 46114;
UPDATE npc set name = 'Sphinx' where npcid = 46115;
UPDATE npc set agrofamily = 1 where npcid = 46115;
UPDATE npc set name = 'Sphinx' where npcid = 46116;
UPDATE npc set agrofamily = 1 where npcid = 46116;
UPDATE npc set name = 'Horus Falcon' where npcid = 46117;
UPDATE npc set agrofamily = 1 where npcid = 46117;
UPDATE npc set family = 'tebes' where npcid = 46117;
UPDATE npc set name = 'Horus Falcon' where npcid = 46118;
UPDATE npc set agrofamily = 1 where npcid = 46118;
UPDATE npc set family = 'tebes' where npcid = 46118;
UPDATE npc set name = 'Thebes Guardian' where npcid = 46119;
UPDATE npc set agrofamily = 1 where npcid = 46119;
UPDATE npc set family = 'tebes' where npcid = 46119;
UPDATE npc set name = 'Thebes Guardian' where npcid = 46120;
UPDATE npc set agrofamily = 1 where npcid = 46120;
UPDATE npc set family = 'tebes' where npcid = 46120;
UPDATE npc set name = 'Thebes Elder' where npcid = 46121;
UPDATE npc set agrofamily = 1 where npcid = 46121;
UPDATE npc set family = 'tebes' where npcid = 46121;
UPDATE npc set name = 'Thebes Elder' where npcid = 46122;
UPDATE npc set agrofamily = 1 where npcid = 46122;
UPDATE npc set family = 'tebes' where npcid = 46122;
UPDATE npc set agrofamily = 1 where npcid = 46123;
UPDATE npc set family = 'tebes' where npcid = 46123;
UPDATE npc set agrofamily = 1 where npcid = 46124;
UPDATE npc set family = 'tebes' where npcid = 46124;
UPDATE npc set note = 'White' where npcid = 46107;
UPDATE npc set note = 'Black' where npcid = 46108;
UPDATE npc set note = 'Yellow' where npcid = 46109;
UPDATE npc set note = 'Black' where npcid = 46110;
UPDATE npc set note = 'Black' where npcid = 46111;
UPDATE npc set note = 'Red' where npcid = 46112;
UPDATE npc set note = 'White' where npcid = 46113;
UPDATE npc set note = 'Black' where npcid = 46114;
UPDATE npc set note = 'White' where npcid = 46115;
UPDATE npc set note = 'Black' where npcid = 46116;
UPDATE npc set note = 'Yellow' where npcid = 46117;
UPDATE npc set note = 'Blue' where npcid = 46118;
UPDATE npc set note = 'Black' where npcid = 46119;
UPDATE npc set note = 'Red' where npcid = 46120;
UPDATE npc set note = 'Yellow' where npcid = 46121;
UPDATE npc set note = 'Purple' where npcid = 46122;