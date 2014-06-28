-- Thebes updates for LinRet -- July 10, 2011 -- Zylia
-- Mobskills update Sept 12, 2011 -- Zylia

# Create NPC data
DELETE FROM npc WHERE npcid > 46106 and npcid < 46125;
REPLACE INTO npc VALUES
(46107,'Mandragora - White','$5492','White','L1Monster',6555,23,280,40,-10,13,12,13,10,10,50,530,-16,'small',2,1,0,480,1600,0,1600,1600,0,0,0,0,0,0,'mandragora',0,-1,-1,0,0,0,5000,20,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46108,'Mandragora - Dark','$5492','Black','L1Monster',6557,26,320,50,-15,13,12,13,10,10,50,677,-18,'small',2,1,0,480,1600,0,1600,1600,0,0,0,0,0,0,'mandragora',0,-1,-1,0,0,0,5000,20,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46109,'Scarab - Yellow','$5493','Yellow','L1Monster',6592,29,400,70,-25,15,15,14,10,10,60,842,-20,'small',10,1,0,600,920,0,920,920,0,0,0,0,0,0,'scarab',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46110,'Scarab - Blue','$5493','Black','L1Monster',6593,32,480,70,-25,15,15,15,11,11,65,1025,-20,'small',10,1,0,600,920,0,920,920,0,0,0,1,1,0,'scarab',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46111,'Kalbis - Dark','$5494','Black','L1Monster',6601,35,480,70,-20,17,15,15,12,12,66,1226,-22,'small',2,1,0,640,800,1280,800,800,0,1,0,0,0,0,'kalbas',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46112,'Kalbis - Red','$5494','Red','L1Monster',6603,39,600,72,-25,17,16,15,12,12,66,1522,-25,'small',2,1,0,600,800,1280,800,800,0,1,0,1,1,0,'kalbas',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46113,'Obelisk - White','$5495','White','L1Monster',6645,41,700,92,-25,23,19,10,13,18,80,1682,-25,'large',8,1,0,1280,1840,0,1840,1840,0,0,0,0,0,0,'obelisk',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,-1,0,0,0,0,0),
(46114,'Obelisk - Dark','$5495','Black','L1Monster',6649,44,800,100,-25,23,22,10,13,18,80,1937,-28,'large',8,1,0,1280,1840,0,1840,1840,0,0,0,0,0,1,'obelisk',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,-1,0,0,0,0,0),
(46115,'Sphinx - White','$5496','White','L1Monster',6699,47,880,115,-29,24,18,18,21,19,100,2210,-28,'large',0,2,0,720,1240,1440,1240,1240,0,0,0,0,0,0,'sphinx',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46116,'Sphinx - Dark','$5496','Black','L1Monster',6704,50,1120,140,-32,24,19,19,21,21,100,2501,-32,'large',0,2,0,720,1240,1440,1240,1240,0,0,0,1,1,1,'sphinx',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46117,'Horus Falcon - Yellow','$5497','Yellow','L1Monster',6664,50,900,250,-20,20,15,18,18,17,60,2501,-32,'small',2,1,0,640,1280,0,1280,1280,0,0,0,0,0,0,'h_falcon',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46118,'Horus Falcon - Blue','$5497','Blue','L1Monster',6665,52,1120,200,-30,20,15,18,18,17,60,2705,-32,'small',2,1,0,640,1280,0,1280,1280,0,0,0,1,1,1,'h_falcon',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46119,'Thebes Guardian - Dark','$5499','Black','L1Monster',6653,54,1200,1200,-40,24,17,20,15,16,65,2917,-34,'small',10,2,0,640,880,1720,1720,1720,0,0,0,0,0,0,'t_guardian',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46120,'Thebes Guardian - Red','$5499','Red','L1Monster',6654,56,1300,1300,-40,24,17,20,15,16,65,3137,-34,'small',10,2,0,640,880,1720,1720,1720,0,0,0,1,1,1,'t_guardian',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46121,'Thebes Elder - Yellow','$5498','Yellow','L1Monster',6562,58,1400,190,-30,18,18,19,21,18,70,3365,-37,'small',3,1,0,600,920,1240,960,960,0,0,0,0,0,0,'t_elder',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46122,'Thebes Elder - Purple','$5498','Purple','L1Monster',6563,60,1500,100,-30,18,18,19,21,18,70,3601,-37,'small',3,1,0,600,920,1240,960,960,0,0,0,1,1,1,'t_elder',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46123,'Thebes Horus','$5501','','L1Monster',6569,70,20000,100,-140,70,22,21,21,22,80,4901,-315,'large',0,1,0,600,1720,1760,960,1720,0,0,0,1,1,1,'',0,-1,-1,0,0,0,5000,5000,5000,20,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0),
(46124,'Thebes Anubis','$5500','','L1Monster',6595,70,25000,100,-140,75,22,21,21,23,80,4901,-315,'large',0,1,0,600,1800,1400,1600,1600,0,0,0,1,1,1,'',0,-1,-1,0,0,0,5000,5000,5000,20,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,0,0,0,0,0);

# Mob Groups
UPDATE mobgroup SET note = 'Mandragora - Light(2)' where id = 63;
REPLACE INTO mobgroup VALUES
(177,'Scarab (3 Yellow)',0,46109,46109,2,0,0,0,0,0,0,0,0,0,0,0,0),
(178,'Scarab (2 Blue)',0,46110,46110,1,0,0,0,0,0,0,0,0,0,0,0,0);

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
REPLACE INTO spawnlist VALUES
(78000001,'Mandragora - Light',12,46107,63,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0,1,8,2,100),
(78000002,'Mandragora - Dark',20,46108,0,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0,1,8,2,100),
(78000003,'Scarab - Yellow',15,46109,177,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0,1,8,2,100),
(78000004,'Scarab - Blue',15,46110,178,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0,1,8,2,100),
(78000005,'Kalbis - Dark',15,46111,0,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0,1,8,2,100),
(78000006,'Kalbis - Red',15,46112,0,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0,1,8,2,100),
(78000007,'Obelisk - Light',15,46113,0,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0,1,8,2,100),
(78000008,'Obelisk - Dark',15,46114,0,32685,32895,0,0,32597,32731,32773,33059,0,0,0,780,0,0,0,0,1,8,2,100),
(78000009,'Sphinx - Light',6,46115,0,32740,32893,0,0,32702,32782,32778,33005,0,0,0,780,0,0,0,0,1,8,2,100),
(78000010,'Sphinx - Dark',6,46116,0,32740,32893,0,0,32702,32782,32778,33005,0,0,0,780,0,0,0,0,1,8,2,100);

# map: 781
UPDATE mapids SET locationname = 'Thebes Pyramid Inside' where mapid = 781;
REPLACE INTO spawnlist VALUES
(78100001,'Horus Falcon - Yellow',3,46117,0,32757,32845,0,0,32730,32828,32784,32862,0,0,0,781,1,0,0,0,1,8,2,100),
(78100003,'Horus Falcon - Yellow',2,46117,0,32790,32794,0,0,32758,32727,32822,32861,0,0,0,781,1,0,0,0,1,8,2,100),
(78100009,'Horus Falcon - Yellow',3,46117,0,32942,32858,0,0,32892,32847,32993,32870,0,0,0,781,1,0,0,0,1,8,2,100),
(78100015,'Horus Falcon - Yellow',3,46117,0,32870,32746,0,0,32828,32729,32913,32764,0,0,0,781,1,0,0,0,1,8,2,100),
(78100021,'Horus Falcon - Yellow',3,46117,0,32913,32792,0,0,32838,32775,32989,32809,0,0,0,781,1,0,0,0,1,8,2,100),
(78100002,'Horus Falcon - Blue',3,46118,0,32757,32845,0,0,32730,32828,32784,32862,0,0,0,781,1,0,0,0,1,8,2,100),
(78100004,'Horus Falcon - Blue',2,46118,0,32790,32794,0,0,32758,32727,32822,32861,0,0,0,781,1,0,0,0,1,8,2,100),
(78100010,'Horus Falcon - Blue',3,46118,0,32942,32858,0,0,32892,32847,32993,32870,0,0,0,781,1,0,0,0,1,8,2,100),
(78100016,'Horus Falcon - Blue',3,46118,0,32870,32746,0,0,32828,32729,32913,32764,0,0,0,781,1,0,0,0,1,8,2,100),
(78100022,'Horus Falcon - Blue',3,46118,0,32913,32792,0,0,32838,32775,32989,32809,0,0,0,781,1,0,0,0,1,8,2,100),
(78100005,'Thebes Guardian - Dark',3,46119,0,32790,32794,0,0,32758,32727,32822,32861,0,0,0,781,1,0,0,0,1,8,2,100),
(78100011,'Thebes Guardian - Dark',3,46119,0,32942,32858,0,0,32892,32847,32993,32870,0,0,0,781,1,0,0,0,1,8,2,100),
(78100017,'Thebes Guardian - Dark',3,46119,0,32870,32746,0,0,32828,32729,32913,32764,0,0,0,781,1,0,0,0,1,8,2,100),
(78100023,'Thebes Guardian - Dark',3,46119,0,32913,32792,0,0,32838,32775,32989,32809,0,0,0,781,1,0,0,0,1,8,2,100),
(78100006,'Thebes Guardian - Red',3,46120,0,32790,32794,0,0,32758,32727,32822,32861,0,0,0,781,1,0,0,0,1,8,2,100),
(78100012,'Thebes Guardian - Red',3,46120,0,32942,32858,0,0,32892,32847,32993,32870,0,0,0,781,1,0,0,0,1,8,2,100),
(78100018,'Thebes Guardian - Red',3,46120,0,32870,32746,0,0,32828,32729,32913,32764,0,0,0,781,1,0,0,0,1,8,2,100),
(78100024,'Thebes Guardian - Red',3,46120,0,32913,32792,0,0,32838,32775,32989,32809,0,0,0,781,1,0,0,0,1,8,2,100),
(78100007,'Thebes Elder - Yellow',3,46121,0,32790,32794,0,0,32758,32727,32822,32861,0,0,0,781,1,0,0,0,1,8,2,100),
(78100013,'Thebes Elder - Yellow',3,46121,0,32942,32858,0,0,32892,32847,32993,32870,0,0,0,781,1,0,0,0,1,8,2,100),
(78100019,'Thebes Elder - Yellow',3,46121,0,32870,32746,0,0,32828,32729,32913,32764,0,0,0,781,1,0,0,0,1,8,2,100),
(78100025,'Thebes Elder - Yellow',3,46121,0,32913,32792,0,0,32838,32775,32989,32809,0,0,0,781,1,0,0,0,1,8,2,100),
(78100008,'Thebes Elder - Purple',3,46122,0,32790,32794,0,0,32758,32727,32822,32861,0,0,0,781,1,0,0,0,1,8,2,100),
(78100014,'Thebes Elder - Purple',3,46122,0,32942,32858,0,0,32892,32847,32993,32870,0,0,0,781,1,0,0,0,1,8,2,100),
(78100020,'Thebes Elder - Purple',3,46122,0,32870,32746,0,0,32828,32729,32913,32764,0,0,0,781,1,0,0,0,1,8,2,100),
(78100026,'Thebes Elder - Purple',3,46122,0,32913,32792,0,0,32838,32775,32989,32809,0,0,0,781,1,0,0,0,1,8,2,100);

# map: 782
UPDATE mapids SET locationname = 'Thebes Osiris Altar' where mapid = 782;
REPLACE INTO spawnlist_boss VALUES
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
REPLACE INTO droplist VALUES
(46107,'Mandragora - Light',49101,'Fragment of Time',3,3,150000),
(46107,'Mandragora - Light',40020,'Condensed Healing Potion',1,1,100000),
(46107,'Mandragora - Light',49093,'Piece of Low-grade Treasure Chest of Osiris (Upper)',1,1,50000),
(46107,'Mandragora - Light',40304,'Relic of Maphr',1,1,10000),
(46107,'Mandragora - Light',49111,'Dragon Tablet(AwakenFafurion)',1,1,5000),
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
(46113,'Obelisk - Light',49101,'Fragment of Time',3,3,150000),
(46113,'Obelisk - Light',40020,'Condensed Healing Potion',1,1,100000),
(46113,'Obelisk - Light',49093,'Piece of Low-grade Treasure Chest of Osiris (Upper)',1,1,50000),
(46113,'Obelisk - Light',40304,'Relic of Maphr',1,1,10000),
(46113,'Obelisk - Light',49126,'Memory Crystal(CubeQuake)',1,1,5000),
(46114,'Obelisk - Dark',49101,'Fragment of Time',3,3,150000),
(46114,'Obelisk - Dark',40020,'Condensed Healing Potion',1,1,100000),
(46114,'Obelisk - Dark',49094,'Piece of Low-grade Treasure Chest of Osiris (Lower)',1,1,10000),
(46114,'Obelisk - Dark',40304,'Relic of Maphr',1,1,10000),
(46114,'Obelisk - Dark',49126,'Memory Crystal(CubeQuake)',1,1,5000),
(46115,'Sphinx - Light',49101,'Fragment of Time',3,3,150000),
(46115,'Sphinx - Light',40020,'Condensed Healing Potion',1,1,100000),
(46115,'Sphinx - Light',49093,'Piece of Low-grade Treasure Chest of Osiris (Upper)',1,1,20000),
(46115,'Sphinx - Light',40304,'Relic of Maphr',1,1,10000),
(46115,'Sphinx - Light',49110,'Dragon Tablet(ShockSkin)',1,1,500),
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
(46122,'Thebes Elder - Purple',40021,'Condensed Greater Healing Potion',1,1,100000),
(46122,'Thebes Elder - Purple',49098,'Piece of High-grade Treasure Chest of Osiris (Lower)',1,1,10000),
(46122,'Thebes Elder - Purple',40304,'Relic of Maphr',1,1,10000),
(46122,'Thebes Elder - Purple',49113,'Dragon Tablet(ThunderGrab)',1,1,3000),
(46124,'Thebes Anubis',20264,'Amulet of Strength',1,1,5000),
(46124,'Thebes Anubis',20256,'Amulet of Dexterity',1,1,10000),
(46124,'Thebes Anubis',20268,'Amulet of Constitution',1,1,7500),
(46124,'Thebes Anubis',20266,'Amulet of Intelligence',1,1,3000),
(46124,'Thebes Anubis',20267,'Amulet of Wisdom',1,1,5000),
(46124,'Thebes Anubis',20254,'Amulet of Charisma',1,1,5000),
(46124,'Thebes Anubis',20284,'Ring of Summon Control',1,1,20000),
(46124,'Thebes Anubis',20281,'Ring of Polymorph Conrol',1,1,15000),
(46124,'Thebes Anubis',20288,'Ring of Teleport Control',1,1,20000),
(46124,'Thebes Anubis',20303,'Ring of Magic Resistance',1,1,3000),
(46124,'Thebes Anubis',20280,'Ring of Immunity to Magic',1,1,1500),
(46124,'Thebes Anubis',21095,'Belt of Thebes Osiris',1,1,1000),
(46124,'Thebes Anubis',21093,'Ring of Thebes Osiris',1,1,1000),
(46124,'Thebes Anubis',21094,'Ring of Thebes Anubis',1,1,1000),
(46124,'Thebes Anubis',40024,'Ancient Greater Healing Potion',1,20,1000000),
(46124,'Thebes Anubis',49099,'Locked High-Grade Treasure Chest of Osiris',1,1,1000000),
(46124,'Thebes Anubis',49092,'Cracked Nucleus',1,1,1000000),
(46124,'Thebes Anubis',140100,'Scroll of Teleportation',1,1,500000),
(46124,'Thebes Anubis',40087,'Scroll of Enchant Weapon',1,1,1000000),
(46124,'Thebes Anubis',140087,'Scroll of Enchant Weapon',1,1,500000),
(46124,'Thebes Anubis',40074,'Scroll of Enchant Armor',1,1,1000000),
(46124,'Thebes Anubis',140074,'Scroll of Enchant Armor',1,1,500000),
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
REPLACE into mobskill VALUES
(46107,2,'Mandragora - White','Death Scream',2,10,80,0,0,0,0,0,3,3,5,0,0,18,0,0,0,0),
(46108,2,'Mandragora - Dark','Death Scream',2,10,100,0,0,0,0,0,3,3,5,0,0,18,0,0,0,0),
(46111,0,'Kalbis - Dark','Tail Stab',1,10,0,0,-1,0,0,1,0,0,15,0,0,30,0,0,0,0),
(46112,0,'Kalbis - Red','Tail Stab',1,10,0,0,-1,0,0,1,0,0,15,0,0,30,0,0,0,0),
(46113,0,'Obelisk - White','Sandstorm',2,10,0,0,-4,0,0,0,4,4,20,10131,0,0,0,0,0,0),
(46114,0,'Obelisk - Dark','Sandstorm',2,10,0,0,-4,0,0,0,4,4,15,0,0,0,0,0,0,0),
(46115,0,'Sphinx - Light','',1,30,0,0,-1,0,0,1,0,0,15,0,0,30,0,0,0,0),
(46115,1,'Sphinx - White','AOE - Rainbow Fluctuations',2,15,0,0,-2,0,0,0,3,3,10,10132,0,0,0,0,0,0),
(46116,0,'Sphinx - Dark','',1,30,0,0,-1,0,0,1,0,0,15,0,0,30,0,0,0,0),
(46116,1,'Sphinx - Dark','AOE - Rainbow Fluctuations',2,15,0,0,-2,0,0,0,3,3,10,10132,0,0,0,0,0,0),
(46117,0,'Horus Falcon - Yellow','Burning Fireball',2,20,0,0,-6,0,0,0,0,0,12,10137,0,0,0,0,0,0),
(46118,0,'Horus Falcon - Blue','Burning Fireball',2,20,0,0,-6,0,0,0,0,0,12,10137,0,0,0,0,0,0),
(46119,0,'Thebes Guardian - Dark','Double Hand Sword Smash',1,10,0,0,-2,0,0,2,0,0,5,0,0,30,0,0,0,0),
(46120,0,'Thebes Guardian - Red','Double Hand Sword Smash',1,10,0,0,-2,0,0,1,0,0,5,0,0,30,0,0,0,0),
(46121,0,'Thebes Elder - Yellow','Thunderstorm',2,30,0,0,-10,0,0,0,4,4,20,65,6565,18,0,0,0,0),
(46121,1,'Thebes Elder - Yellow','Two Hand Claw Swipe',1,20,0,0,-1,0,0,1,0,0,5,0,0,30,0,0,0,0),
(46122,0,'Thebes Elder - Purple','Thunderstorm',2,30,0,0,-10,0,0,0,4,4,20,65,6565,18,0,0,0,0),
(46122,1,'Thebes Elder - Purple','Two Hand Claw Swipe',1,20,0,0,-1,0,0,1,0,0,5,0,0,30,0,0,0,0),
(46123,0,'Thebes Horus','',2,25,0,0,-6,0,0,0,0,0,6,10138,0,0,0,0,0,0),
(46123,1,'Thebes Horus','',2,10,0,0,-4,0,0,0,0,0,8,10140,0,0,0,0,0,0),
(46123,2,'Thebes Horus','',1,20,0,0,-1,0,0,1,0,2,10,0,0,30,0,0,0,0),
(46123,3,'Thebes Horus','Summon Horus Falcon',3,10,0,0,-3,3,0,0,0,0,0,0,0,18,46118,2,2,0),
(46124,0,'Thebes Anubis','',2,25,0,0,-6,0,0,0,0,0,6,10139,0,0,0,0,0,0),
(46124,1,'Thebes Anubis','',2,10,0,0,-4,0,0,0,0,0,8,10141,0,0,0,0,0,0),
(46124,2,'Thebes Anubis','',1,10,0,0,-1,0,0,1,0,2,10,0,0,30,0,0,0,0),
(46124,3,'Thebes Anubis','Summon Thebes Guardian',3,10,0,0,-3,3,0,0,0,0,0,0,0,18,46120,2,2,0),
(46124,4,'Thebes Anubis','Summon Thebes Elder',3,10,0,0,-3,3,0,0,0,0,0,0,0,18,46122,2,2,0);

# Add npc for Thebes Desert
replace into spawnlist_npc values (90453,'Joe`s Stone Golem',1,71253,32627,32895,0,0,4,0,780,0);
replace into npc values (71255,'Thebes Osiris Altar Gatekeeper','$6077','','L1Merchant',6992,0,0,0,0,0,0,0,0,0,0,0,0,'small',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0);
replace into spawnlist_npc values (90454,'Thebes Osiris Altar Gatekeeper',1,71255,32997,32747,0,0,4,0,781,0);

# Thebes updates for LinRet -- Zylia & Valakas

# Update weaknesses for Thebes Mobs
update npc set weakattr = 12 where npcid = 46121;
update npc set weakattr = 12 where npcid = 46122;
update npc set weakattr = 8 where npcid = 46123; # air 3
update npc set weakattr = 1 where npcid = 46124; # earth 2
REPLACE into mobskill VALUES
(46107,0,'Mandragora - White','Camoflage (Bury Self)',1,30,0,0,0,0,0,0,0,0,0,0,0,11,0,0,0,0),
(46107,1,'Mandragora - White','Unbury',1,20,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0),
(46108,0,'Mandragora - Dark','Camoflage (Bury Self)',1,30,0,0,0,0,0,0,0,0,0,0,0,11,0,0,0,0),
(46108,1,'Mandragora - Dark','Unbury',1,20,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0);
