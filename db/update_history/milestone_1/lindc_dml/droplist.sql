-- update 26

-- add nature's miracle to droplists
-- succubus
insert into droplist values(45393, 41243, 1, 1, 1500);
-- toi succubus
insert into droplist values(45394, 41243, 1, 1, 1500);
-- succubus queen
insert into droplist values(45451, 41243, 1, 1, 5000);
-- ice queen 
insert into droplist values(45609, 41243, 1, 1, 12500);
-- cerenis
insert into droplist values(45678, 41243, 1, 1, 12000);
-- fafurion
insert into droplist values(45683, 41243, 1, 1, 300000);

-- modify existing Water Spirit Master drops
-- increase Glove of Ice Spirit droprate from Water Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 20172 and mobid = 45500;
-- increase hq gems droprate from Water Spirit Master (5000 -> 10000)
update droplist set chance = 10000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45500;
-- decrease sc:elemental falldown droprate from Water Spirit Master (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40241 and mobid = 45500;
-- increase Mithril Dagger droprate from Water Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 8 and mobid = 45500;
-- increase Oriharukon Dagger droprate from Water Spirit Master (1000 -> 2500)
update droplist set chance = 2500 where itemid = 9 and mobid = 45500;

-- modify existing Earth Spirit Master drops
-- increase Glove of Dark Spirit droprate from Earth Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 20177 and mobid = 45508;
-- increase hq gems droprate from Earth Spirit Master (5000 -> 10000)
update droplist set chance = 10000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45508;
-- decrease sc:elemental falldown droprate from Earth Spirit Master (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40241 and mobid = 45508;
-- increase Mithril Dagger droprate from Earth Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 8 and mobid = 45508;
-- increase Oriharukon Dagger droprate from Earth Spirit Master (1000 -> 2500)
update droplist set chance = 2500 where itemid = 9 and mobid = 45508;

-- modify existing Wind Spirit Master drops
-- increase Glove of Wind Spirit droprate from Wind Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 20189 and mobid = 45510;
-- increase hq gems droprate from Wind Spirit Master (5000 -> 10000)
update droplist set chance = 10000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45510;
-- decrease sc:elemental falldown droprate from Wind Spirit Master (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40241 and mobid = 45510;
-- increase Mithril Dagger droprate from Wind Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 8 and mobid = 45510;
-- increase Oriharukon Dagger droprate from Wind Spirit Master (1000 -> 2500)
update droplist set chance = 2500 where itemid = 9 and mobid = 45510;

-- modify existing Fire Spirit Master drops
-- increase Glove of Fire Spirit droprate from Fire Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 20181 and mobid = 45511;
-- increase hq gems droprate from Fire Spirit Master (5000 -> 10000)
update droplist set chance = 10000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45511;
-- decrease sc:elemental falldown droprate from Fire Spirit Master (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40241 and mobid = 45511;
-- increase Mithril Dagger droprate from Fire Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 8 and mobid = 45511;
-- increase Oriharukon Dagger droprate from Fire Spirit Master (1000 -> 2500)
update droplist set chance = 2500 where itemid = 9 and mobid = 45511;

-- modify existing Abyss Water Spirit drops
-- increase Glove of Ice Spirit droprate from Abyss Water Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 20172 and mobid = 45591;
-- increase hq gems droprate from Abyss Water Spirit (5000 -> 15000)
update droplist set chance = 15000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45591;
-- increase Mithril Dagger droprate from Abyss Water Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 8 and mobid = 45594;
-- increase Oriharukon Dagger droprate from Abyss Water Spirit (1000 -> 5000)
update droplist set chance = 5000 where itemid = 9 and mobid = 45594;

-- modify existing Abyss Earth Spirit drops
-- increase Glove of Dark Spirit droprate from Abyss Earth Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 20177 and mobid = 45592;
-- increase hq gems droprate from Abyss Earth Spirit (5000 -> 15000)
update droplist set chance = 15000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45592;
-- increase Mithril Dagger droprate from Abyss Earth Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 8 and mobid = 45594;
-- increase Oriharukon Dagger droprate from Abyss Earth Spirit (1000 -> 5000)
update droplist set chance = 5000 where itemid = 9 and mobid = 45594;

-- modify existing Abyss Wind Spirit drops
-- increase Glove of Wind Spirit droprate from Abyss Wind Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 20189 and mobid = 45593;
-- increase hq gems droprate from Abyss Wind Spirit (5000 -> 15000)
update droplist set chance = 15000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45593;
-- increase Mithril Dagger droprate from Abyss Wind Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 8 and mobid = 45593;
-- increase Oriharukon Dagger droprate from Abyss Wind Spirit (1000 -> 5000)
update droplist set chance = 5000 where itemid = 9 and mobid = 45593;

-- modify existing Abyss Fire Spirit drops
-- increase Glove of Fire Spirit droprate from Abyss Fire Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 20181 and mobid = 45594;
-- increase hq gems droprate from Abyss Fire Spirit (5000 -> 15000)
update droplist set chance = 15000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45594;
-- increase Mithril Dagger droprate from Abyss Fire Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 8 and mobid = 45594;
-- increase Oriharukon Dagger droprate from Abyss Fire Spirit (1000 -> 5000)
update droplist set chance = 5000 where itemid = 9 and mobid = 45594;

-- modify existing Abyss Ghoul drops
-- increase nzel droprate from Abyss Ghoul (25000 -> 50000)
update droplist set chance = 50000 where itemid = 40074 and mobid = 45501;



-- update 27

-- modify existing sea dancer boss drops
-- increase pine droprate from sea dancer boss (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40006 and mobid = 45228;
-- increase ebony droprate from sea dancer boss (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40007 and mobid = 45228;
-- increase maple droprate from sea dancer boss (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40008 and mobid = 45228;
-- increase bzel droprate from sea dancer boss (10000 -> 50000)
update droplist set chance = 50000 where itemid = 140074 and mobid = 45228;
-- increase czel droprate from sea dancer boss (10000 -> 85000)
update droplist set chance = 85000 where itemid = 240074 and mobid = 45228;

-- fix single silver arrow drop from Skeletal Pirate Soldier
delete from droplist where itemid = 40744 and mobid = 45274;
insert into droplist values (45274, 40744, 5, 55, 75000);

-- fix single silver arrow drop from Skeletal Pirate Head
delete from droplist where itemid = 40744 and mobid = 45330;
insert into droplist values (45330, 40744, 5, 20, 50000);

-- desuckify all boss drops (only publish this after the boss spawn rate fix is confirmed)

-- modify existing Sema drops
-- increase Cap of Sema droprate from Sema (150 -> 400)
update droplist set chance = 400 where itemid = 20029 and mobid = 45464;
-- increase Cloak of Protection droprate from Sema (50000 -> 100000)
update droplist set chance = 100000 where itemid = 20063 and mobid = 45464;
-- increase Gloves droprate from Sema (50000 -> 100000)
update droplist set chance = 100000 where itemid = 20182 and mobid = 45464;
-- increase Amulet of Dexterity droprate from Sema (5000 -> 6500)
update droplist set chance = 6500 where itemid = 20256 and mobid = 45464;
-- increase Pine Wand droprate from Sema (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40006 and mobid = 45464;
-- increase Maple Wand droprate from Sema (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40008 and mobid = 45464;
-- increase Diamond droprate from Sema (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40044 and mobid = 45464;
-- increase High Quality Diamond droprate from Sema (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40048 and mobid = 45464;
-- increase Highest Quality Diamond droprate from Sema (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40052 and mobid = 45464;
-- increase all sb/sc droprate from Sema (50000 -> 80000)
update droplist set chance = 80000 where itemid in (40171, 40179, 40188, 40192, 40199, 40233, 40260, 40262) and mobid = 45464;
-- increase ring of sema/orim droprate from Sema (1000 -> 1500)
update droplist set chance = 1500 where itemid in (40907, 40908) and mobid = 45464;
-- increase bzel droprate from Sema (12000 -> 20000)
update droplist set chance = 20000 where itemid = 140074 and mobid = 45464;

-- modify existing Necromancer drops
-- increase Cap of Sema droprate from Necromancer (100 -> 250)
update droplist set chance = 250 where itemid = 20029 and mobid = 45456;
-- increase Cloak of Protection droprate from Necromancer (10000 -> 50000)
update droplist set chance = 50000 where itemid = 20063 and mobid = 45456;
-- increase Gloves droprate from Necromancer (150000 -> 180000)
update droplist set chance = 180000 where itemid = 20182 and mobid = 45456;
-- increase Amulet of Dexterity droprate from Necromancer (1000 -> 4500)
update droplist set chance = 4500 where itemid = 20256 and mobid = 45456;
-- increase str/int/wis ammy droprate from Necromancer (1000 -> 2500)
update droplist set chance = 2500 where itemid in (20264, 20266, 20267) and mobid = 45456;
-- increase ropc, rosc, rotc droprate from Necromancer (1000 -> 1500)
update droplist set chance = 1500 where itemid in (20281, 20284, 20288) and mobid = 45456;
-- increase pine/maple/sb/sc droprate from Necromancer (10000 -> 25000)
update droplist set chance = 25000 where itemid in (40006, 40008, 40171, 40179, 40180, 40192, 40199, 40233, 40260, 40262) and mobid = 45456;
-- increase Diamond droprate from Necromancer (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40044 and mobid = 45456;
-- increase ring of orim/sema droprate from Necromancer (1000 -> 2500)
update droplist set chance = 2500 where itemid in (40907, 40908) and mobid = 45456;
-- increase bzel droprate from Necromancer (5000 -> 25000)
update droplist set chance = 25000 where itemid = 140074 and mobid = 45456;
-- increase bdai droprate from Necromancer (2500 -> 5000)
update droplist set chance = 5000 where itemid = 140087 and mobid = 45456;

-- modify existing Caspa drops
-- increase Cap of Caspa droprate from Caspa (1000 -> 1200)
update droplist set chance = 1200 where itemid = 20040 and mobid = 45488;
-- increase Amulet of Strength droprate from Caspa (5000 -> 6500)
update droplist set chance = 6500 where itemid = 20264 and mobid = 45488;
-- increase pine/maple/ruby/sb droprate from Caspa (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40006, 40008, 40045, 40191) and mobid = 45488;
-- increase hpr/tqr/entangle droprate from Caspa (10000 -> 25000)
update droplist set chance = 25000 where itemid in (40049, 40053, 40248) and mobid = 45488;
-- increase Scroll of Enchant Armor droprate from Caspa (12000 -> 20000)
update droplist set chance = 20000 where itemid = 140074 and mobid = 45488;
-- increase bdai droprate from Caspa (7000 -> 8500)
update droplist set chance = 8500 where itemid = 140087 and mobid = 45488;

-- modify existing Baltuzar drops
-- increase Cap of Baltuzar droprate from Baltuzar (150 -> 400)
update droplist set chance = 400 where itemid = 20025 and mobid = 45473;
-- increase boots, wands, Emerald, sbs, some scs droprate from Baltuzar (50000 -> 85000)
update droplist set chance = 85000 where itemid in (20205, 40006, 40008, 40047, 40175, 40177, 40178, 40189, 40190, 40207, 40235, 40242) and mobid = 45473;
-- increase hqe, tqe, entangle droprate from Baltuzar (10000 -> 22000)
update droplist set chance = 22000 where itemid in (40051, 40055, 40248) and mobid = 45473;
-- increase bzel droprate from Baltuzar (12000 -> 25000)
update droplist set chance = 25000 where itemid = 140074 and mobid = 45473;
-- increase bdai droprate from Baltuzar (7000 -> 8500)
update droplist set chance = 8500 where itemid = 140087 and mobid = 45473;

-- modify existing Merkyor drops
-- increase Cap of Merkyor droprate from Merkyor (150 -> 400)
update droplist set chance = 400 where itemid = 20018 and mobid = 45497;
-- increase wands, Sapphire, sbs droprate from Merkyor (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40006, 40008, 40046, 40173, 40180, 40183, 40185, 40186) and mobid = 45497;
-- increase hqs, tqs droprate from Merkyor (10000 -> 22000)
update droplist set chance = 22000 where itemid in (40050, 40054) and mobid = 45497;
-- increase bzel droprate from Merkyor (12000 -> 25000)
update droplist set chance = 25000 where itemid = 140074 and mobid = 45497;
-- increase bdai droprate from Merkyor (7000 -> 8500)
update droplist set chance = 8500 where itemid = 140100 and mobid = 45497;

-- modify existing Spirit of Drake drops
-- increase Shield of Faith droprate from Spirit of Drake (5000 -> 35000)
update droplist set chance = 35000 where itemid = 20234 and mobid = 45458;
-- increase cursed rings, hq gems, sb:ej, scs, uquiver droprate from Spirit of Drake (10000 -> 45000)
update droplist set chance = 45000 where itemid in (20293, 20294, 20295, 20296, 40048, 40049, 40050, 40051, 40175, 40241, 40259, 40330) and mobid = 45458;
-- increase ghaste, gem droprate from Spirit of Drake (50000 -> 150000)
update droplist set chance = 150000 where itemid in (40018, 40044, 40045, 40046, 40047) and mobid = 45458;
-- increase hq gem droprate from Spirit of Drake (5000 -> 25000)
update droplist set chance = 25000 where itemid in (40052, 40053, 40054, 40055) and mobid = 45458;
-- increase lvl4 blank droprate from Spirit of Drake (5000 -> 100000)
update droplist set chance = 100000 where itemid = 40093 and mobid = 45458;
-- increase sb:as droprate from Spirit of Drake (100 -> 1000)
update droplist set chance = 1000 where itemid = 40224 and mobid = 45458;
-- increase frag droprate from Spirit of Drake (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40471 and mobid = 45458;
-- increase key of drake droprate from Spirit of Drake (50000 -> 500000)
update droplist set chance = 500000 where itemid = 40621 and mobid = 45458;
-- increase Sword of Honor, Edoryu of Abyss, Jet-Black Crystal Ball, Crossbow of Silence droprate from Spirit of Drake (5000 -> 20000)
update droplist set chance = 20000 where itemid in (33, 79, 118, 178) and mobid = 45458;
-- increase shamshir, cutlass droprate from Spirit of Drake (10000 -> 50000)
update droplist set chance = 50000 where itemid in (39, 43) and mobid = 45458;

-- modify existing Kuman drops
-- increase c-sapph ring, hqs, stun, sb:res droprate from Kuman (10000 -> 15000)
update droplist set chance = 15000 where itemid in (20295, 40050, 40164, 40206) and mobid = 45492;
-- increase Highest Quality Sapphire droprate from Kuman (5000 -> 12000)
update droplist set chance = 12000 where itemid = 40054 and mobid = 45492;
-- increase bounce droprate from Kuman (1000 -> 1500)
update droplist set chance = 1500 where itemid = 40166 and mobid = 45492;
-- correct Treasure of Lizardman droprate from Kuman (10000000 -> 1000000)
update droplist set chance = 1000000 where itemid = 40634 and mobid = 45492;
-- increase Sword of Brave Lizardman Soldier droprate from Kuman (10000 -> 15000)
update droplist set chance = 15000 where itemid = 53 and mobid = 45492;

-- modify existing Zenith Queen drops
-- increase cpm, pg droprate from Zenith Queen (10000 -> 30000)
update droplist set chance = 30000 where itemid in (20128, 20187) and mobid = 45513;
-- increase zq ring droprate from Zenith Queen (5000 -> 15000)
update droplist set chance = 15000 where itemid = 20298 and mobid = 45513;
-- increase obom, sb, dsc droprate from Zenith Queen (50000 -> 100000)
update droplist set chance = 100000 where itemid in (20308, 40174, 40185, 40192, 40221, 40277) and mobid = 45513;
-- increase Belt of Mind droprate from Zenith Queen (25000 -> 75000)
update droplist set chance = 75000 where itemid = 20319 and mobid = 45513;
-- increase bzel droprate from Zenith Queen (200000 -> 300000)
update droplist set chance = 300000 where itemid = 140074 and mobid = 45513;
-- increase bdai droprate from Zenith Queen (100000 -> 120000)
update droplist set chance = 120000 where itemid = 140087 and mobid = 45513;
-- increase Tsuguri droprate from Zenith Queen (2000 -> 9000)
update droplist set chance = 9000 where itemid = 57 and mobid = 45513;

-- modify existing Ifrit drops
-- increase wands droprate from Ifrit (50000 -> 75000)
update droplist set chance = 75000 where itemid in (40006, 40008) and mobid = 45516;
-- increase hqs droprate from Ifrit (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40050 and mobid = 45516;
-- increase tqd, tqs droprate from Ifrit (10000 -> 15000)
update droplist set chance = 15000 where itemid in (40052, 40054) and mobid = 45516;
-- increase ndai droprate from Ifrit (35000 -> 50000)
update droplist set chance = 50000 where itemid = 40087 and mobid = 45516;
-- increase lvl3 blank droprate from Ifrit (5000 -> 300000)
update droplist set chance = 300000 where itemid = 40092 and mobid = 45516;
-- decrease lvl5 blank droprate from Ifrit (300000 -> 200000)
update droplist set chance = 200000 where itemid = 40094 and mobid = 45516;
-- increase sb: fb, dex, str, cancel, sb droprate from Ifrit (10000 -> 50000)
update droplist set chance = 50000 where itemid in (40170, 40171, 40187, 40189, 40191) and mobid = 45516;
-- increase dsc droprate from Ifrit (5000 -> 15000)
update droplist set chance = 15000 where itemid in (40271, 40275) and mobid = 45516;
-- increase bzel droprate from Ifrit (10000 -> 50000)
update droplist set chance = 50000 where itemid = 140074 and mobid = 45516;
-- increase bdai droprate from Ifrit (5000 -> 12000)
update droplist set chance = 12000 where itemid = 140087 and mobid = 45516;
-- increase nkat droprate from Ifrit (50000 -> 150000)
update droplist set chance = 150000 where itemid = 41 and mobid = 45516;
-- increase bkat droprate from Ifrit (50000 -> 850000)
update droplist set chance = 850000 where itemid = 100041 and mobid = 45516;

-- redo nzel drop from Ifrit
delete from droplist where itemid = 40074 and mobid = 45516;
insert into droplist values (45516, 40074, 1, 3, 180000);

-- modify existing Drake drops
-- increase ruby, hqr, tqd, tqr, tqe, WindShackle droprate from Drake (10000 -> 20000)
update droplist set chance = 20000 where itemid in (40045, 40049, 40052, 40053, 40055) and mobid = 45529;
-- increase sapphire, emerald, hqe, some sbs droprate from Drake (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40046, 40047, 40048, 40055, 40170, 40172, 40181, 40187, 40188) and mobid = 45529;
-- increase bzel droprate from Drake (12500 -> 50000)
update droplist set chance = 50000 where itemid = 140074 and mobid = 45529;
-- increase bdai droprate from Drake (5000 -> 8500)
update droplist set chance = 8500 where itemid = 140087 and mobid = 45529;
-- increase czel droprate from Drake (25000 -> 200000)
update droplist set chance = 200000 where itemid = 240074 and mobid = 45529;
-- increase cdai droprate from Drake (12500 -> 85000)
update droplist set chance = 85000 where itemid = 240087 and mobid = 45529;

-- add additional drops to Drake 
-- add nzel to Drake droplist 
insert into droplist values (45529, 40074, 1, 3, 200000);
-- add ndai to Drake droplist 
insert into droplist values (45529, 40087, 1, 1, 50000);

-- redo Diamond drop from Drake
delete from droplist where itemid = 40044 and mobid = 45529;
insert into droplist values (45529, 40044, 1, 3, 250000);
-- redo bpoly drop from Drake
delete from droplist where itemid = 140088 and mobid = 45529;
insert into droplist values (45529, 140088, 1, 3, 300000);

-- modify existing Mambo Rabbit drops
-- increase mambo hat, coat droprate from Mambo Rabbit (1000 -> 8500)
update droplist set chance = 8500 where itemid in (20016, 20112) and mobid = 45535;
-- increase mambo b-hat, b-coat, b-ori dagger droprate from Mambo Rabbit (1000 -> 3500)
update droplist set chance = 3500 where itemid in (120016, 120112, 100009) and mobid = 45535;
-- increase spirit glove, tq gem, sc droprate from Mambo Rabbit (10000 -> 25000)
update droplist set chance = 25000 where itemid in (20172, 20177, 20181, 20189, 40053, 40054, 40240, 40252, 40259) and mobid = 45535;
-- increase Rabbit Liver droprate from Mambo Rabbit (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40043 and mobid = 45535;
-- increase sb:as droprate from Mambo Rabbit (1000 -> 2500)
update droplist set chance = 2500 where itemid = 40224 and mobid = 45535;
-- increase sc:WaterLife droprate from Mambo Rabbit (2000 -> 15000)
update droplist set chance = 15000 where itemid = 40253 and mobid = 45535;
-- increase mith dagger droprate from Mambo Rabbit (10000 -> 35000)
update droplist set chance = 35000 where itemid = 8 and mobid = 45535;
-- increase ori dagger, b-mith dagger droprate from Mambo Rabbit (5000 -> 12000)
update droplist set chance = 12000 where itemid in (9, 100008) and mobid = 45535;

-- modify existing Dark Elder drops
-- increase Robe of Dark Elder droprate from Dark Elder (1000 -> 6000)
update droplist set chance = 6000 where itemid = 20160 and mobid = 45545;
-- increase gloves, b-gloves droprate from Dark Elder (100000 -> 200000)
update droplist set chance = 200000 where itemid in (20182, 120182) and mobid = 45545;
-- increase Sandals of Dark Elder droprate from Dark Elder (100 -> 700)
update droplist set chance = 700 where itemid = 20218 and mobid = 45545;
-- increase maple, res scroll, sbs, scs droprate from Dark Elder (10000 -> 35000)
update droplist set chance = 35000 where itemid in (40008, 40089, 40179, 40180, 40181, 40242, 40264) and mobid = 45545;
-- increase sc:water life droprate from Dark Elder (8000 -> 20000)
update droplist set chance = 20000 where itemid = 40253 and mobid = 45545;

-- remove it poly scroll from dark elder
delete from droplist where itemid = 40096 and mobid = 45545;

-- add additional drops to Dark Elder 
-- add poly scroll to Dark Elder droplist 
insert into droplist values (45545, 40088, 1, 1, 50000);

-- modify existing Doppelganger boss drops
-- increase dopple rings/ammy droprate from Doppelganger boss (5000 -> 18000)
update droplist set chance = 18000 where itemid in (20250, 20277, 20278) and mobid = 45546;
-- increase bounce droprate from Doppelganger boss (500 -> 1000)
update droplist set chance = 1000 where itemid = 40166 and mobid = 45546;
-- increase sbs droprate from Doppelganger boss (150000/5000 -> 75000)
update droplist set chance = 75000 where itemid in (40170, 40172, 40181, 40187) and mobid = 45546;
-- increase sb:summon, sc droprate from Doppelganger boss (5000 -> 7500)
update droplist set chance = 7500 where itemid in (40196, 40242) and mobid = 45546;
-- increase sbs droprate from Doppelganger boss (5000 -> 15000)
update droplist set chance = 15000 where itemid in (40199, 40207, 40252, 40258) and mobid = 45546;
-- increase bzel droprate from Doppelganger boss (25000 -> 85000)
update droplist set chance = 85000 where itemid = 140074 and mobid = 45546;
-- increase bdai droprate from Doppelganger boss (12500 -> 20000)
update droplist set chance = 20000 where itemid = 140087 and mobid = 45546;

-- modify existing Seer drops
-- increase Cloak of Invisibility droprate from Seer (1000 -> 2500)
update droplist set chance = 2500 where itemid = 20077 and mobid = 45547;
-- increase cpm, pg, tqd droprate from Seer (10000 -> 22000)
update droplist set chance = 22000 where itemid in (20128, 20187, 40052) and mobid = 45547;
-- increase tqs droprate from Seer (12000 -> 50000)
update droplist set chance = 50000 where itemid = 40054 and mobid = 45547;
-- increase sbs droprate from Seer (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40173, 40184, 40185, 40192, 40201) and mobid = 45547;
-- decrease dsc:fb droprate from Seer (50000 -> 30000)
update droplist set chance = 30000 where itemid = 40278 and mobid = 45547;
-- increase tsu droprate from Seer (5500 -> 12000)
update droplist set chance = 12000 where itemid = 57 and mobid = 45547;

-- redo nzel drop from Seer
delete from droplist where itemid = 40074 and mobid = 45547;
insert into droplist values (45547, 40074, 1, 3, 700000);

-- modify existing Baphomet drops
-- increase Armor of Baphomet droprate from Baphomet (50 -> 1000)
update droplist set chance = 1000 where itemid = 20117 and mobid = 45573;
-- increase Old Amulet of Charisma droprate from Baphomet (25000 -> 50000)
update droplist set chance = 50000 where itemid = 20244 and mobid = 45573;
-- decrease Amulet of Charisma droprate from Baphomet (25000 -> 20000)
update droplist set chance = 20000 where itemid = 20254 and mobid = 45573;
-- decrease rosc droprate from Baphomet (15000 -> 5000)
update droplist set chance = 5000 where itemid = 20284 and mobid = 45573;
-- increase old belt droprate from Baphomet (5000 -> 50000)
update droplist set chance = 50000 where itemid in (20306, 20307, 20308) and mobid = 45573;
-- increase belt droprate from Baphomet (2500 -> 25000)
update droplist set chance = 25000 where itemid in (20312, 20316, 20319) and mobid = 45573;
-- increase Golden Key droprate from Baphomet (50 -> 50000)
update droplist set chance = 50000 where itemid = 40163 and mobid = 45573;
-- increase sbs droprate from Baphomet (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40173, 40175, 40181, 40186, 40190, 40193, 40257) and mobid = 45573;
-- decrease sc:storm shot droprate from Baphomet (25000 -> 20000)
update droplist set chance = 20000 where itemid = 40263 and mobid = 45573;
-- increase bzel droprate from Baphomet (150000 -> 300000)
update droplist set chance = 300000 where itemid = 140074 and mobid = 45573;
-- increase Staff of Baphomet droprate from Baphomet (50 -> 950)
update droplist set chance = 950 where itemid = 109 and mobid = 45573;

-- redo nzel drop from Baphomet
delete from droplist where itemid = 40074 and mobid = 45573;
insert into droplist values (45573, 40074, 1, 3, 500000);

-- modify existing Beleth drops
-- increase Boots of Beleth droprate from Beleth (150 -> 1500)
update droplist set chance = 1500 where itemid = 20204 and mobid = 45583;
-- increase old belts droprate from Beleth (10000 -> 35000)
update droplist set chance = 35000 where itemid in (20306, 20307, 20308) and mobid = 45583;
-- increase belts droprate from Beleth (5000 -> 15000)
update droplist set chance = 15000 where itemid in (20312, 20316, 20319) and mobid = 45583;
-- increase sbs droprate from Beleth (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40170, 40171, 40173, 40175, 40180, 40186, 40190, 40191, 40201, 40202) and mobid = 45583;
-- decrease sc:storm shot droprate from Beleth (50000 -> 20000)
update droplist set chance = 20000 where itemid = 40263 and mobid = 45583;
-- increase bzel droprate from Beleth (200000 -> 250000)
update droplist set chance = 250000 where itemid = 140074 and mobid = 45583;
-- increase Staff of Beleth droprate from Beleth (150 -> 1400)
update droplist set chance = 1400 where itemid = 110 and mobid = 45583;

-- redo nzel drop from Baphomet
delete from droplist where itemid = 40074 and mobid = 45583;
insert into droplist values (45583, 40074, 1, 3, 500000);
-- redo haste pot drop from Baphomet
delete from droplist where itemid = 40013 and mobid = 45583;
insert into droplist values (45583, 40013, 1, 5, 300000);
-- redo brave drop from Baphomet
delete from droplist where itemid = 40014 and mobid = 45583;
insert into droplist values (45583, 40014, 1, 5, 300000);
-- redo blue pot drop from Baphomet
delete from droplist where itemid = 40015 and mobid = 45583;
insert into droplist values (45583, 40015, 1, 5, 300000);

-- modify existing Greater Minotaur drops
-- decrease Old Amulet of Strength droprate from Greater Minotaur (300000 -> 100000)
update droplist set chance = 100000 where itemid = 20246 and mobid = 45584;
-- increase Amulet of Strength droprate from Greater Minotaur (5000 -> 15000)
update droplist set chance = 15000 where itemid = 20264 and mobid = 45584;
-- increase Belt of Body droprate from Greater Minotaur (5000 -> 25000)
update droplist set chance = 25000 where itemid = 20312 and mobid = 45584;
-- increase sbs droprate from Greater Minotaur (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40172, 40175, 40193, 40200, 40202) and mobid = 45584;
-- increase bzel droprate from Greater Minotaur (10000 -> 150000)
update droplist set chance = 150000 where itemid = 140074 and mobid = 45584;
-- increase bdai droprate from Greater Minotaur (5000 -> 65000)
update droplist set chance = 65000 where itemid = 140087 and mobid = 45584;
-- increase great sword droprate from Greater Minotaur (25000 -> 75000)
update droplist set chance = 75000 where itemid = 64 and mobid = 45584;
-- increase Axe of Minotaur droprate from Greater Minotaur (5000 -> 15000)
update droplist set chance = 15000 where itemid = 149 and mobid = 45584;
-- increase bkat droprate from Greater Minotaur (10000 -> 50000)
update droplist set chance = 50000 where itemid = 100041 and mobid = 45584;

-- redo red pot drop from Greater Minotaur
delete from droplist where itemid = 40010 and mobid = 45584;
insert into droplist values (45584, 40010, 1, 5, 300000);
-- redo Haste pot drop from Greater Minotaur
delete from droplist where itemid = 40013 and mobid = 45584;
insert into droplist values (45584, 40013, 1, 5, 300000);
-- redo Bravery pot drop from Greater Minotaur
delete from droplist where itemid = 40014 and mobid = 45584;
insert into droplist values (45584, 40014, 1, 5, 300000);
-- redo blue pot drop from Greater Minotaur
delete from droplist where itemid = 40015 and mobid = 45584;
insert into droplist values (45584, 40015, 1, 5, 300000);
-- redo wis pot drop from Greater Minotaur
delete from droplist where itemid = 40016 and mobid = 45584;
insert into droplist values (45584, 40016, 1, 5, 300000);

-- modify existing Kurtz drops
-- increase Helmet of Kurtz droprate from Kurtz (8000 -> 32000)
update droplist set chance = 32000 where itemid = 20041 and mobid = 45600;
-- increase cop, ts droprate from Kurtz (200000 -> 250000)
update droplist set chance = 250000 where itemid in (20063, 20085) and mobid = 45600;
-- increase bpm droprate from Kurtz (50000 -> 100000)
update droplist set chance = 100000 where itemid = 20149 and mobid = 45600;
-- increase Armor of Kurtz droprate from Kurtz (1000 -> 10000)
update droplist set chance = 10000 where itemid = 20150 and mobid = 45600;
-- increase Gloves of Kurtz droprate from Kurtz (8000 -> 35000)
update droplist set chance = 35000 where itemid = 20184 and mobid = 45600;
-- increase Highest Quality Ruby droprate from Kurtz (10000 -> 55000)
update droplist set chance = 55000 where itemid = 40053 and mobid = 45600;
-- increase Highest Quality Diamond droprate from Kurtz (10000 -> 35000)
update droplist set chance = 35000 where itemid = 40052 and mobid = 45600;
-- increase sb:zerk, fs droprate from Kurtz (10000 -> 50000)
update droplist set chance = 50000 where itemid in (40200, 40215) and mobid = 45600;
-- increase Sword of Kurtz  droprate from Kurtz (100 -> 1500)
update droplist set chance = 1500 where itemid = 54 and mobid = 45600;
-- increase bkat droprate from Kurtz (50000 -> 100000)
update droplist set chance = 100000 where itemid = 100041 and mobid = 45600;

-- redo nzel drop from Kurtz
delete from droplist where itemid = 40074 and mobid = 45600;
insert into droplist values (45600, 40074, 1, 5, 700000);
-- redo ndai drop from Kurtz
delete from droplist where itemid = 40087 and mobid = 45600;
insert into droplist values (45600, 40087, 1, 2, 300000);
-- redo bzel drop from Kurtz
delete from droplist where itemid = 140074 and mobid = 45600;
insert into droplist values (45600, 140074, 1, 3, 700000);

-- modify existing Death Knight drops
-- increase Death Knight Helmet droprate from Death Knight (500 -> 7500)
update droplist set chance = 7500 where itemid = 20010 and mobid = 45601;
-- increase Cloak of Invisibility droprate from Death Knight (1000 -> 2500)
update droplist set chance = 2500 where itemid = 20077 and mobid = 45601;
-- increase Death Knight Armor droprate from Death Knight (500 -> 7500)
update droplist set chance = 7500 where itemid = 20100 and mobid = 45601;
-- decrease Amulet of Strength droprate from Death Knight (50000 -> 35000)
update droplist set chance = 35000 where itemid = 20264 and mobid = 45601;
-- increase old belts droprate from Death Knight (10000 -> 50000)
update droplist set chance = 50000 where itemid in (20307, 20308) and mobid = 45601;
-- increase belts droprate from Death Knight (5000 -> 35000)
update droplist set chance = 35000 where itemid in (20316, 20319) and mobid = 45601;
-- increase sbs droprate from Death Knight (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40172, 40173, 40181, 40187, 40191, 40201, 40206, 40207, 40215) and mobid = 45601;
-- increase Fire Sword of Death Knight droprate from Death Knight (150 -> 1200)
update droplist set chance = 1200 where itemid = 58 and mobid = 45601;
-- increase Edoryu of Ronde droprate from Death Knight (150 -> 1200)
update droplist set chance = 1200 where itemid = 76 and mobid = 45601;

-- redo haste pot drop from Death Knight
delete from droplist where itemid = 40013 and mobid = 45601;
insert into droplist values (45601, 40013, 1, 5, 300000);
-- redo brave drop from Death Knight
delete from droplist where itemid = 40014 and mobid = 45601;
insert into droplist values (45601, 40014, 1, 5, 300000);
-- redo blue drop from Death Knight
delete from droplist where itemid = 40015 and mobid = 45601;
insert into droplist values (45601, 40015, 1, 3, 300000);
-- redo wis pot drop from Death Knight
delete from droplist where itemid = 40016 and mobid = 45601;
insert into droplist values (45601, 40016, 1, 3, 300000);
-- redo blind pot drop from Death Knight
delete from droplist where itemid = 40025 and mobid = 45601;
insert into droplist values (45601, 40025, 1, 3, 300000);
-- redo nzel drop from Death Knight
delete from droplist where itemid = 40074 and mobid = 45601;
insert into droplist values (45601, 40074, 1, 5, 300000);
-- redo ndai drop from Death Knight
delete from droplist where itemid = 40087 and mobid = 45601;
insert into droplist values (45601, 40087, 1, 2, 300000);

-- modify existing Vampire drops
-- increase Silver Cloak droprate from Vampire (5000 -> 13000)
update droplist set chance = 13000 where itemid = 20074 and mobid = 45606;
-- increase Cloak of Invisibility droprate from Vampire (1000 -> 2000)
update droplist set chance = 2000 where itemid = 20077 and mobid = 45606;
-- increase cpm droprate from Vampire (10000 -> 22000)
update droplist set chance = 22000 where itemid = 20128 and mobid = 45606;
-- increase rof droprate from Vampire (5000 -> 7500)
update droplist set chance = 7500 where itemid = 20304 and mobid = 45606;
-- increase belt of mind droprate from Vampire (5000 -> 15000)
update droplist set chance = 15000 where itemid = 20319 and mobid = 45606;
-- increase Old Belt of Mind droprate from Vampire (10000 -> 35000)
update droplist set chance = 35000 where itemid = 20308 and mobid = 45606;
-- increase Tsuguri droprate from Vampire (5500 -> 12000)
update droplist set chance = 12000 where itemid = 57 and mobid = 45606;
-- increase sos droprate from Vampire (10000 -> 50000)
update droplist set chance = 50000 where itemid = 131 and mobid = 45606;
-- increase sbs droprate from Vampire (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40173, 40175, 40176, 40184, 40185, 40186, 40192, 40201) and mobid = 45606;
-- decrease summon droprate from Vampire (50000 -> 20000)
update droplist set chance = 20000 where itemid = 40196 and mobid = 45606;
-- increase bzel droprate from Vampire (50000 -> 250000)
update droplist set chance = 250000 where itemid = 140074 and mobid = 45606;

-- redo haste pot drop from Vampire
delete from droplist where itemid = 40013 and mobid = 45606;
insert into droplist values (45606, 40013, 1, 5, 300000);
-- redo brave drop from Vampire
delete from droplist where itemid = 40014 and mobid = 45606;
insert into droplist values (45606, 40014, 1, 5, 300000);
-- redo blue drop from Vampire
delete from droplist where itemid = 40015 and mobid = 45606;
insert into droplist values (45606, 40015, 1, 3, 300000);
-- redo wis pot drop from Vampire
delete from droplist where itemid = 40016 and mobid = 45606;
insert into droplist values (45606, 40016, 1, 3, 300000);
-- redo nzel drop from Vampire
delete from droplist where itemid = 40074 and mobid = 45606;
insert into droplist values (45606, 40074, 1, 5, 300000);

-- modify existing Ice Queen drops
-- increase Alluring Dress of Ice Queen droprate from Ice Queen (1000 -> 3000)
update droplist set chance = 3000 where itemid = 20134 and mobid = 45609;
-- increase cg, demon boots droprate from Ice Queen (5000 -> 8500)
update droplist set chance = 8500 where itemid in (20175, 20197) and mobid = 45609;
-- increase Alluring Sandals of Ice Queen droprate from Ice Queen (3000 -> 8500)
update droplist set chance = 8500 where itemid = 20211 and mobid = 45609;
-- decrease Amulet of Intelligence droprate from Ice Queen (40000 -> 30000)
update droplist set chance = 30000 where itemid = 20266 and mobid = 45609;
-- increase Amulet of Wisdom droprate from Ice Queen (20000 -> 18000)
update droplist set chance = 18000 where itemid = 20267 and mobid = 45609;
-- increase Highest Quality Diamond droprate from Ice Queen (2500 -> 7500)
update droplist set chance = 7500 where itemid = 40052 and mobid = 45609;
-- increase sbs droprate from Ice Queen (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40176, 40185, 40215) and mobid = 45609;
-- increase sb:invis droprate from Ice Queen (1000 -> 2500)
update droplist set chance = 2500 where itemid = 40205 and mobid = 45609;
-- increase Staff of Ice Queen droprate from Ice Queen (250 -> 750)
update droplist set chance = 750 where itemid = 111 and mobid = 45609;
-- increase kxbow droprate from Ice Queen (150 -> 600)
update droplist set chance = 600 where itemid = 189 and mobid = 45609;
-- increase bkat droprate from Ice Queen (50000 -> 85000)
update droplist set chance = 85000 where itemid = 100041 and mobid = 45609;

-- redo nzel drop from Ice Queen
delete from droplist where itemid = 40074 and mobid = 45609;
insert into droplist values (45609, 40074, 1, 5, 700000);
-- redo ndai drop from Ice Queen
delete from droplist where itemid = 40087 and mobid = 45609;
insert into droplist values (45609, 40087, 1, 2, 350000);

-- modify existing Ancient Giant drops
-- increase Ring of Ancient Giant droprate from Ancient Giant (1000 -> 5000)
update droplist set chance = 5000 where itemid = 20314 and mobid = 45610;
-- increase old iws ammy, bos droprate from Ancient Giant (10000 -> 20000)
update droplist set chance = 20000 where itemid in (20248, 20316) and mobid = 45610;
-- increase Titan Belt droprate from Ancient Giant (5000 -> 11000)
update droplist set chance = 11000 where itemid = 20320 and mobid = 45610;
-- increase sbs droprate from Ancient Giant (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40175, 40176, 40177, 40184) and mobid = 45610;

-- redo haste pot drop from Ancient Giant
delete from droplist where itemid = 40013 and mobid = 45610;
insert into droplist values (45610, 40013, 1, 5, 300000);
-- redo brave drop from Ancient Giant
delete from droplist where itemid = 40014 and mobid = 45610;
insert into droplist values (45610, 40014, 1, 3, 300000);
-- redo blue drop from Ancient Giant
delete from droplist where itemid = 40015 and mobid = 45610;
insert into droplist values (45610, 40015, 1, 3, 300000);
-- redo wis pot drop from Ancient Giant
delete from droplist where itemid = 40016 and mobid = 45610;
insert into droplist values (45610, 40016, 1, 3, 300000);
-- redo nzel drop from Ancient Giant
delete from droplist where itemid = 40074 and mobid = 45610;
insert into droplist values (45610, 40074, 1, 5, 300000);
-- redo ndai drop from Ancient Giant
delete from droplist where itemid = 40087 and mobid = 45610;
insert into droplist values (45610, 40087, 1, 2, 300000);
-- redo bzel drop from Ancient Giant
delete from droplist where itemid = 140074 and mobid = 45610;
insert into droplist values (45610, 140074, 1, 2, 300000);

-- modify existing Giant Ant Queen drops
-- increase gold/silver wing droprate from Giant Ant Queen (250 -> 850)
update droplist set chance = 850 where itemid in (20049, 20050) and mobid = 45614;
-- increase Death Knight Boots droprate from Giant Ant Queen (2500 -> 7500)
update droplist set chance = 7500 where itemid = 20198 and mobid = 45614;
-- increase Amulet of Contsitution droprate from Giant Ant Queen (10000 -> 30000)
update droplist set chance = 30000 where itemid = 20268 and mobid = 45614;
-- increase Old Belt of Body droprate from Giant Ant Queen (10000 -> 35000)
update droplist set chance = 35000 where itemid = 20306 and mobid = 45614;
-- increase Belt of Body droprate from Giant Ant Queen (5000 -> 15000)
update droplist set chance = 15000 where itemid = 20312 and mobid = 45614;
-- increase b-pm droprate from Giant Ant Queen (50000 -> 150000)
update droplist set chance = 150000 where itemid = 120154 and mobid = 45614;
-- increase sbs droprate from Giant Ant Queen (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40175, 40177, 40180, 40181, 40185, 40190, 40194) and mobid = 45614;
-- increase bdai droprate from Giant Ant Queen (25000 -> 300000)
update droplist set chance = 300000 where itemid = 140087 and mobid = 45614;
-- increase Sword/Bow of Ancient Elf droprate from Giant Ant Queen (10000 -> 30000)
update droplist set chance = 30000 where itemid in (44, 179) and mobid = 45614;
-- increase kclaw droprate from Giant Ant Queen (100 -> 500)
update droplist set chance = 500 where itemid = 164 and mobid = 45614;

-- redo haste pot drop from Giant Ant Queen
delete from droplist where itemid = 40013 and mobid = 45614;
insert into droplist values (45614, 40013, 1, 5, 300000);
-- redo brave drop from Giant Ant Queen
delete from droplist where itemid = 40014 and mobid = 45614;
insert into droplist values (45614, 40014, 1, 5, 300000);
-- redo ghaste drop from Giant Ant Queen
delete from droplist where itemid = 40018 and mobid = 45614;
insert into droplist values (45614, 40018, 1, 3, 300000);
-- redo bzel drop from Giant Ant Queen
delete from droplist where itemid = 140074 and mobid = 45614;
insert into droplist values (45614, 140074, 1, 3, 300000);

-- modify existing Phoenix drops
-- increase old belts droprate from Phoenix (20000 -> 50000)
update droplist set chance = 50000 where itemid in (20306, 20307, 20308) and mobid = 45617;
-- increase belts droprate from Phoenix (5000 -> 20000)
update droplist set chance = 20000 where itemid in (20312, 20316, 20319) and mobid = 45617;
-- increase rof droprate from Phoenix (25000 -> 35000)
update droplist set chance = 35000 where itemid = 20304 and mobid = 45617;
-- increase sbs droprate from Phoenix (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40170, 40171, 40172, 40180, 40181, 40188, 40191, 40194, 40215) and mobid = 45617;
-- increase sb:ms droprate from Phoenix (2000 -> 6000)
update droplist set chance = 6000 where itemid = 40219 and mobid = 45617;

-- redo bzel drop from Phoenix
delete from droplist where itemid = 140074 and mobid = 45617;
insert into droplist values (45617, 140074, 1, 3, 300000);
-- redo nzel drop from Phoenix
delete from droplist where itemid = 40074 and mobid = 45617;
insert into droplist values (45617, 40074, 1, 5, 750000);
-- redo ndai drop from Phoenix
delete from droplist where itemid = 40087 and mobid = 45617;
insert into droplist values (45617, 40087, 1, 2, 500000);

-- modify existing Knight Vald drops
-- increase Power Gloves droprate from Knight Vald (12000 -> 35000)
update droplist set chance = 35000 where itemid = 20187 and mobid = 45618;
-- increase Tsuguri droprate from Knight Vald (7500 -> 25000)
update droplist set chance = 25000 where itemid = 57 and mobid = 45618;
-- increase Sword of Knight Vald droprate from Knight Vald (800 -> 2500)
update droplist set chance = 2500 where itemid = 59 and mobid = 45618;

-- redo haste drop from Knight Vald
delete from droplist where itemid = 40013 and mobid = 45618;
insert into droplist values (45618, 40013, 1, 5, 300000);
-- redo ghaste drop from Knight Vald
delete from droplist where itemid = 40018 and mobid = 45618;
insert into droplist values (45618, 40018, 1, 3, 300000);
-- redo nzel drop from Knight Vald
delete from droplist where itemid = 40074 and mobid = 45618;
insert into droplist values (45618, 40074, 1, 5, 300000);
-- redo ndai drop from Knight Vald
delete from droplist where itemid = 40087 and mobid = 45618;
insert into droplist values (45618, 40087, 1, 2, 300000);
-- redo rough iron drop from Knight Vald
delete from droplist where itemid = 40899 and mobid = 45618;
insert into droplist values (45618, 40899, 1, 10, 300000);
-- redo bzel drop from Knight Vald
delete from droplist where itemid = 140074 and mobid = 45618;
insert into droplist values (45618, 140074, 1, 3, 300000);
-- redo czel drop from Knight Vald
delete from droplist where itemid = 240074 and mobid = 45618;
insert into droplist values (45618, 240074, 1, 5, 300000);
-- redo cdai drop from Knight Vald
delete from droplist where itemid = 240087 and mobid = 45618;
insert into droplist values (45618, 240087, 1, 5, 300000);

-- modify existing Chaos drops
-- increase Chaos items droprate from Chaos (5000 -> 20000)
update droplist set chance = 20000 where itemid in (20048, 20078, 20158, 20190, 14) and mobid = 45625;

-- modify existing Unicorn drops
-- increase Dark Cloak  droprate from Unicorn (7500 -> 15000)
update droplist set chance = 15000 where itemid = 20070 and mobid = 45640;
-- increase nzel droprate from Unicorn (40000 -> 80000)
update droplist set chance = 80000 where itemid = 40074 and mobid = 45640;
-- increase bzel droprate from Unicorn (15000 -> 30000)
update droplist set chance = 30000 where itemid = 140074 and mobid = 45640;

-- modify existing Great Spirit of Earth drops
-- increase Ring of Earth Resistance droprate from Great Spirit of Earth (10000 -> 12000)
update droplist set chance = 12000 where itemid = 20300 and mobid = 45642;
-- increase Belt of Mind droprate from Great Spirit of Earth (5000 -> 15000)
update droplist set chance = 15000 where itemid = 20319 and mobid = 45642;
-- increase bzel droprate from Great Spirit of Earth (50000 -> 85000)
update droplist set chance = 85000 where itemid = 140074 and mobid = 45642;

-- redo nzel drop from Great Spirit of Earth
delete from droplist where itemid = 40074 and mobid = 45642;
insert into droplist values (45642, 40074, 1, 3, 300000);

-- modify existing Great Spirit of Water drops
-- increase Ring of Water Resistance droprate from Great Spirit of Water (10000 -> 12000)
update droplist set chance = 12000 where itemid = 20285 and mobid = 45643;
-- increase Belt of Mind droprate from Great Spirit of Water (5000 -> 15000)
update droplist set chance = 15000 where itemid = 20319 and mobid = 45643;
-- increase bzel droprate from Great Spirit of Water (50000 -> 85000)
update droplist set chance = 85000 where itemid = 140074 and mobid = 45643;

-- redo nzel drop from Great Spirit of Water
delete from droplist where itemid = 40074 and mobid = 45643;
insert into droplist values (45643, 40074, 1, 3, 300000);

-- modify existing Great Spirit of Wind drops
-- increase Ring of Wind Resistance droprate from Great Spirit of Wind (10000 -> 12000)
update droplist set chance = 12000 where itemid = 20302 and mobid = 45644;
-- increase Belt of Mind droprate from Great Spirit of Wind (5000 -> 15000)
update droplist set chance = 15000 where itemid = 20319 and mobid = 45644;
-- increase bzel droprate from Great Spirit of Wind (50000 -> 85000)
update droplist set chance = 85000 where itemid = 140074 and mobid = 45644;

-- redo nzel drop from Great Spirit of Wind
delete from droplist where itemid = 40074 and mobid = 45644;
insert into droplist values (45644, 40074, 1, 3, 300000);

-- modify existing Great Spirit of Wind drops
-- increase Ring of Fire Resistance droprate from Great Spirit of Wind (10000 -> 12000)
update droplist set chance = 12000 where itemid = 12000 and mobid = 45645;
-- increase Belt of Mind droprate from Great Spirit of Wind (5000 -> 15000)
update droplist set chance = 15000 where itemid = 20319 and mobid = 45645;
-- increase bzel droprate from Great Spirit of Wind (50000 -> 85000)
update droplist set chance = 85000 where itemid = 140074 and mobid = 45645;

-- redo nzel drop from Great Spirit of Wind
delete from droplist where itemid = 40074 and mobid = 45645;
insert into droplist values (45645, 40074, 1, 3, 300000);

-- modify existing Abyss Master drops
-- increase abyss ring, b-abyss ring droprate from Abyss Master (10000 -> 20000)
update droplist set chance = 20000 where itemid in (20289, 120289) and mobid = 45646;
-- increase tq gem droprate from Abyss Master (10000 -> 20000)
update droplist set chance = 20000 where itemid in (40052, 40053, 40054, 40055) and mobid = 45646;
-- increase dk pot droprate from Abyss Master (500 -> 1000)
update droplist set chance = 1000 where itemid = 40216 and mobid = 45646;
-- increase sb:ms droprate from Abyss Master (1000 -> 2000)
update droplist set chance = 2000 where itemid = 40219 and mobid = 45646;
-- increase Crimson Lance, Demon Axe droprate from Abyss Master (10000 -> 20000)
update droplist set chance = 20000 where itemid in (107, 151) and mobid = 45646;
-- increase b-Crimson Lance, b-Demon Axe, b-mith dagger droprate from Abyss Master (10000 -> 15000)
update droplist set chance = 15000 where itemid in (100107, 100151, 100008) and mobid = 45646;
-- increase b-ori dagger droprate from Abyss Master (1000 -> 5000)
update droplist set chance = 5000 where itemid = 100009 and mobid = 45646;

-- redo haste drop from Abyss Master
delete from droplist where itemid = 40013 and mobid = 45646;
insert into droplist values (45646, 40013, 1, 3, 300000);
-- redo bbs drop from Abyss Master
delete from droplist where itemid = 40524 and mobid = 45646;
insert into droplist values (45646, 40524, 1, 3, 150000);

-- add additional drops to Abyss Master 
-- add ori dagger to Abyss Master droplist 
insert into droplist values (45646, 9, 1, 1, 12000);
-- add mith dagger to Abyss Master droplist 
insert into droplist values (45646, 8, 1, 1, 30000);

-- modify existing Demon drops
-- increase Demon Helmet droprate from Demon (5000 -> 20000)
update droplist set chance = 20000 where itemid = 20009 and mobid = 45649;
-- increase Cloak of Invisibility droprate from Demon (500 -> 1500)
update droplist set chance = 1500 where itemid = 20077 and mobid = 45649;
-- increase Demon Armor, cpm droprate from Demon (10000 -> 30000)
update droplist set chance = 30000 where itemid in (20099, 20128) and mobid = 45649;
-- increase pg droprate from Demon (30000 -> 85000)
update droplist set chance = 85000 where itemid = 20187 and mobid = 45649;
-- increase Demon Boots droprate from Demon (150000 -> 200000)
update droplist set chance = 200000 where itemid = 20197 and mobid = 45649;
-- increase rof droprate from Demon (30000 -> 40000)
update droplist set chance = 40000 where itemid = 20304 and mobid = 45649;
-- increase belts droprate from Demon (25000 -> 75000)
update droplist set chance = 75000 where itemid in (20316, 20319) and mobid = 45649;
-- increase tqr, tqd droprate from Demon (50000 -> 100000)
update droplist set chance = 100000 where itemid in (40052, 40053) and mobid = 45649;
-- increase sbs droprate from Demon (25000 -> 100000)
update droplist set chance = 100000 where itemid in (40170, 40173, 40181, 40191) and mobid = 45649;
-- increase sb:ms droprate from Demon (1000 -> 3000)
update droplist set chance = 3000 where itemid = 40219 and mobid = 45649;
-- increase Black Lump of Rough Mihral droprate from Demon (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40444 and mobid = 45649;
-- increase Blade of Revenge droprate from Demon (1000 -> 4000)
update droplist set chance = 4000 where itemid = 16 and mobid = 45649;
-- increase Tsuguri droprate from Demon (1000 -> 14000)
update droplist set chance = 14000 where itemid = 57 and mobid = 45649;
-- increase kedo droprate from Demon (500 -> 1500)
update droplist set chance = 1500 where itemid = 84 and mobid = 45649;
-- increase Staff of Demon droprate from Demon (150 -> 650)
update droplist set chance = 650 where itemid = 108 and mobid = 45649;
-- increase Claw of Hate droprate from Demon (300 -> 1500)
update droplist set chance = 1500 where itemid = 166 and mobid = 45649;
-- increase bkat droprate from Demon (50000 -> 150000)
update droplist set chance = 150000 where itemid = 100041 and mobid = 45649;
-- increase btsu droprate from Demon (250 -> 1200)
update droplist set chance = 1200 where itemid = 100057 and mobid = 45649;

-- redo ghaste drop from Demon
delete from droplist where itemid = 40018 and mobid = 45649;
insert into droplist values (45649, 40018, 1, 3, 300000);
-- redo blind pot drop from Demon
delete from droplist where itemid = 40025 and mobid = 45649;
insert into droplist values (45649, 40025, 1, 5, 300000);
-- redo nzel drop from Demon
delete from droplist where itemid = 40074 and mobid = 45649;
insert into droplist values (45649, 40074, 1, 5, 300000);
-- redo bzel drop from Demon
delete from droplist where itemid = 140074 and mobid = 45649;
insert into droplist values (45649, 140074, 1, 2, 300000);

-- modify existing Zombie Lord drops
-- increase Crystal Plate Mail droprate from Zombie Lord (10000 -> 25000)
update droplist set chance = 25000 where itemid = 20128 and mobid = 45650;
-- increase obom, sbs droprate from Zombie Lord (50000 -> 85000)
update droplist set chance = 85000 where itemid in (20308, 40185, 40186, 40192, 40201, 40206) and mobid = 45650;
-- increase dsc droprate from Zombie Lord (5000 -> 25000)
update droplist set chance = 25000 where itemid in (40275, 40277, 40278) and mobid = 45650;
-- increase nkat, dice droprate from Zombie Lord (50000 -> 120000)
update droplist set chance = 120000 where itemid in (41, 2) and mobid = 45650;
-- increase bzel droprate from Zombie Lord (200000 -> 300000)
update droplist set chance = 300000 where itemid = 140074 and mobid = 45650;
-- increase Tsuguri droprate from Zombie Lord (6500 -> 15000)
update droplist set chance = 15000 where itemid = 57 and mobid = 45650;
-- increase kedo droprate from Zombie Lord (1200 -> 3000)
update droplist set chance = 3000 where itemid = 84 and mobid = 45650;

-- redo nzel drop from Zombie Lord
delete from droplist where itemid = 40074 and mobid = 45650;
insert into droplist values (45650, 40074, 1, 5, 600000);

-- modify existing Baranka drops
-- increase pk helm, armor, gloves, boots, claw, evidence droprate from Baranka (10000 -> 30000)
update droplist set chance = 30000 where itemid in (20020, 20113, 20168, 20201, 40638, 155) and mobid = 45651;
-- increase baranka helm, armor, gloves, boots, claw, evil pk boots droprate from Baranka (100 -> 650)
update droplist set chance = 650 where itemid in (20022, 20116, 20169, 20200, 20202, 163) and mobid = 45651;

-- redo haste drop from Baranka
delete from droplist where itemid = 40013 and mobid = 45651;
insert into droplist values (45651, 40013, 1, 5, 300000);
-- redo adena drop from Baranka
delete from droplist where itemid = 40308 and mobid = 45651;
insert into droplist values (45651, 40308, 6450, 10220, 1000000);

-- modify existing Cougar drops
-- increase Old Belt of Mind droprate from Cougar (50000 -> 100000)
update droplist set chance = 100000 where itemid = 20308 and mobid = 45652;
-- increase Belt of Body droprate from Cougar (5000 -> 50000)
update droplist set chance = 50000 where itemid = 20312 and mobid = 45652;
-- increase pine, maple, res scroll droprate from Cougar (100000 -> 150000)
update droplist set chance = 150000 where itemid in (40006, 40008, 40089) and mobid = 45652;
-- increase Tsuguri droprate from Cougar (6500 -> 17000)
update droplist set chance = 17000 where itemid = 57 and mobid = 45652;

-- redo brave drop from Cougar
delete from droplist where itemid = 40014 and mobid = 45652;
insert into droplist values (45652, 40014, 1, 5, 300000);
-- redo wis pot drop from Cougar
delete from droplist where itemid = 40016 and mobid = 45652;
insert into droplist values (45652, 40016, 1, 5, 300000);
-- redo blind pot drop from Cougar
delete from droplist where itemid = 40025 and mobid = 45652;
insert into droplist values (45652, 40025, 1, 5, 300000);
-- redo nzel drop from Cougar
delete from droplist where itemid = 40074 and mobid = 45652;
insert into droplist values (45652, 40074, 1, 5, 300000);
-- redo ndai drop from Cougar
delete from droplist where itemid = 40087 and mobid = 45652;
insert into droplist values (45652, 40087, 1, 3, 300000);
-- redo bzel drop from Cougar
delete from droplist where itemid = 140074 and mobid = 45652;
insert into droplist values (45652, 140074, 1, 3, 300000);

-- modify existing Mummy Lord drops
-- increase Crown of Mummy Lord droprate from Mummy Lord (500 -> 2500)
update droplist set chance = 2500 where itemid = 20017 and mobid = 45653;
-- increase Old Belt of Soul droprate from Mummy Lord (15000 -> 100000)
update droplist set chance = 100000 where itemid = 20307 and mobid = 45653;
-- increase Belt of Mind droprate from Mummy Lord (7000 -> 50000)
update droplist set chance = 50000 where itemid = 20319 and mobid = 45653;
-- increase pine, maple droprate from Mummy Lord (100000 -> 150000)
update droplist set chance = 150000 where itemid in (40006, 40008) and mobid = 45653;
-- increase Tsuguri droprate from Mummy Lord (2000 -> 18000)
update droplist set chance = 18000 where itemid = 57 and mobid = 45653;

-- redo brave drop from Mummy Lord
delete from droplist where itemid = 40014 and mobid = 45653;
insert into droplist values (45653, 40014, 1, 5, 300000);
-- redo wis pot drop from Mummy Lord
delete from droplist where itemid = 40016 and mobid = 45653;
insert into droplist values (45653, 40016, 1, 5, 300000);
-- redo nzel drop from Mummy Lord
delete from droplist where itemid = 40074 and mobid = 45653;
insert into droplist values (45653, 40074, 1, 5, 700000);
-- redo ndai drop from Mummy Lord
delete from droplist where itemid = 40087 and mobid = 45653;
insert into droplist values (45653, 40087, 1, 3, 350000);
-- redo bzel drop from Mummy Lord
delete from droplist where itemid = 140074 and mobid = 45653;
insert into droplist values (45653, 140074, 1, 3, 300000);
-- redo czel drop from Mummy Lord
delete from droplist where itemid = 240074 and mobid = 45653;
insert into droplist values (45653, 240074, 1, 5, 300000);
-- redo cdai drop from Mummy Lord
delete from droplist where itemid = 240087 and mobid = 45653;
insert into droplist values (45653, 240087, 1, 3, 300000);

-- modify existing Iris drops
-- increase pg droprate from Iris (16000 -> 50000)
update droplist set chance = 50000 where itemid = 20187 and mobid = 45654;
-- increase Amulet of Iris droprate from Iris (800 -> 2400)
update droplist set chance = 2400 where itemid = 20260 and mobid = 45654;
-- increase Old Belt of Mind droprate from Iris (50000 -> 100000)
update droplist set chance = 100000 where itemid = 20308 and mobid = 45654;
-- increase Belt of Mind droprate from Iris (25000 -> 50000)
update droplist set chance = 50000 where itemid = 20319 and mobid = 45654;
-- increase sbs droprate from Iris (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40172, 40175, 40182, 40187, 40202) and mobid = 45654;
-- increase Two Handed Sword droprate from Iris (50000 -> 150000)
update droplist set chance = 150000 where itemid = 52 and mobid = 45654;
-- increase Tsuguri droprate from Iris (7500 -> 19000)
update droplist set chance = 19000 where itemid = 57 and mobid = 45654;
-- increase sb:eq droprate from Iris (25000 -> 50000)
update droplist set chance = 50000 where itemid = 40207 and mobid = 45654;
-- increase sc:fire weap droprate from Iris (5000 -> 25000)
update droplist set chance = 25000 where itemid = 40257 and mobid = 45654;

-- redo blind pot drop from Iris
delete from droplist where itemid = 40025 and mobid = 45654;
insert into droplist values (45654, 40025, 1, 6, 300000);
-- redo nzel drop from Iris
delete from droplist where itemid = 40074 and mobid = 45654;
insert into droplist values (45654, 40074, 1, 5, 700000);
-- redo ndai drop from Iris
delete from droplist where itemid = 40087 and mobid = 45654;
insert into droplist values (45654, 40087, 1, 3, 350000);
-- redo bzel drop from Iris
delete from droplist where itemid = 140074 and mobid = 45654;
insert into droplist values (45654, 140074, 1, 3, 300000);

-- modify existing Aaarrrggg... drops
-- increase Tsuguri droprate from Aaarrrggg... (5000 -> 25000)
update droplist set chance = 25000 where itemid = 57 and mobid = 45671;

-- redo nzel drop from Aaarrrggg...
delete from droplist where itemid = 40074 and mobid = 45671;
insert into droplist values (45671, 40074, 1, 6, 300000);
-- redo ndai drop from Aaarrrggg...
delete from droplist where itemid = 40087 and mobid = 45671;
insert into droplist values (45671, 40087, 1, 3, 150000);
-- redo Old Leather Pouch drop from Aaarrrggg...
delete from droplist where itemid = 40167 and mobid = 45671;
insert into droplist values (45671, 40167, 1, 5, 300000);
-- redo Old Silk Pouch drop from Aaarrrggg...
delete from droplist where itemid = 40168 and mobid = 45671;
insert into droplist values (45671, 40168, 1, 4, 300000);
-- redo Relic Pouch drop from Aaarrrggg...
delete from droplist where itemid = 40415 and mobid = 45671;
insert into droplist values (45671, 40415, 1, 3, 300000);
-- redo bzel drop from Aaarrrggg...
delete from droplist where itemid = 140074 and mobid = 45671;
insert into droplist values (45671, 140074, 1, 3, 300000);
-- redo bres drop from Aaarrrggg...
delete from droplist where itemid = 140089 and mobid = 45671;
insert into droplist values (45671, 140089, 1, 6, 300000);

-- modify existing Lich drops
-- increase Silver Cloak droprate from Lich (10000 -> 30000)
update droplist set chance = 30000 where itemid = 20074 and mobid = 45672;
-- increase Cloak of Invisibility droprate from Lich (1000 -> 3000)
update droplist set chance = 3000 where itemid = 20077 and mobid = 45672;
-- increase Lich Robe droprate from Lich (800 -> 5000)
update droplist set chance = 5000 where itemid = 20107 and mobid = 45672;
-- increase cpm, pg droprate from Lich (10000 -> 30000)
update droplist set chance = 30000 where itemid in (20128, 20187) and mobid = 45672;
-- increase Old Belt of Mind droprate from Lich (50000 -> 100000)
update droplist set chance = 100000 where itemid = 20308 and mobid = 45672;
-- increase Belt of Mind droprate from Lich (25000 -> 50000)
update droplist set chance = 50000 where itemid = 20319 and mobid = 45672;
-- increase sbs droprate from Lich (50000 -> 100000)
update droplist set chance = 100000 where itemid in (40173, 40178, 40184, 40185, 40192, 40201, 40206, 40217) and mobid = 45672;
-- increase sb:destroy, ab droprate from Lich (5000 -> 8000)
update droplist set chance = 8000 where itemid in (40222, 40223) and mobid = 45672;
-- increase Dice Dagger droprate from Lich (50000 -> 150000)
update droplist set chance = 150000 where itemid = 2 and mobid = 45672;
-- increase Tsuguri droprate from Lich (7000 -> 21000)
update droplist set chance = 21000 where itemid = 57 and mobid = 45672;
-- increase bkat droprate from Lich (150000 -> 180000)
update droplist set chance = 180000 where itemid = 100041 and mobid = 45672;

-- redo haste drop from Lich
delete from droplist where itemid = 40013 and mobid = 45672;
insert into droplist values (45672, 40013, 2, 6, 300000);
-- redo brave drop from Lich
delete from droplist where itemid = 40014 and mobid = 45672;
insert into droplist values (45672, 40014, 1, 3, 300000);
-- redo blue drop from Lich
delete from droplist where itemid = 40015 and mobid = 45672;
insert into droplist values (45672, 40015, 2, 6, 300000);
-- redo wis pot drop from Lich
delete from droplist where itemid = 40016 and mobid = 45672;
insert into droplist values (45672, 40016, 2, 6, 300000);
-- redo ghaste drop from Lich
delete from droplist where itemid = 40018 and mobid = 45672;
insert into droplist values (45672, 40018, 1, 5, 300000);
-- redo blind pot drop from Lich
delete from droplist where itemid = 40025 and mobid = 45672;
insert into droplist values (45672, 40025, 2, 6, 300000);
-- redo nzel drop from Lich
delete from droplist where itemid = 40074 and mobid = 45672;
insert into droplist values (45672, 40074, 2, 6, 300000);
-- redo ndai drop from Lich
delete from droplist where itemid = 40087 and mobid = 45672;
insert into droplist values (45672, 40087, 1, 3, 300000);
-- redo Black Lump of Rough Mithral drop from Lich
delete from droplist where itemid = 40444 and mobid = 45672;
insert into droplist values (45672, 40444, 1, 5, 150000);
-- redo bzel drop from Lich
delete from droplist where itemid = 140074 and mobid = 45672;
insert into droplist values (45672, 140074, 1, 3, 300000);

-- modify existing Grim Reaper drops
-- increase Silver Cloak droprate from Grim Reaper (1000 -> 50000)
update droplist set chance = 50000 where itemid = 20074 and mobid = 45673;
-- increase Cloak of Invisibility droprate from Grim Reaper (1000 -> 5000)
update droplist set chance = 5000 where itemid = 20077 and mobid = 45673;
-- increase cpm, pg droprate from Grim Reaper (10000 -> 35000)
update droplist set chance = 35000 where itemid in (20128, 20187) and mobid = 45673;
-- increase Old Belt of Mind droprate from Grim Reaper (50000 -> 150000)
update droplist set chance = 150000 where itemid = 20308 and mobid = 45673;
-- increase Belt of Mind droprate from Grim Reaper (25000 -> 75000)
update droplist set chance = 75000 where itemid = 20319 and mobid = 45673;
-- increase sb:destroy droprate from Grim Reaper (1000 -> 7500)
update droplist set chance = 7500 where itemid = 40222 and mobid = 45673;
-- increase Tsuguri droprate from Grim Reaper (5000 -> 40000)
update droplist set chance = 40000 where itemid = 57 and mobid = 45673;
-- increase Kaiser Edoryu droprate from Grim Reaper (500 -> 3000)
update droplist set chance = 3000 where itemid = 84 and mobid = 45673;

-- redo haste drop from Grim Reaper
delete from droplist where itemid = 40013 and mobid = 45673;
insert into droplist values (45673, 40013, 2, 6, 300000);
-- redo brave drop from Grim Reaper
delete from droplist where itemid = 40014 and mobid = 45673;
insert into droplist values (45673, 40014, 2, 6, 300000);
-- redo devil's blood drop from Grim Reaper
delete from droplist where itemid = 40031 and mobid = 45673;
insert into droplist values (45673, 40031, 2, 6, 300000);
-- redo blind pot drop from Grim Reaper
delete from droplist where itemid = 40025 and mobid = 45673;
insert into droplist values (45673, 40025, 1, 5, 300000);
-- redo nzel drop from Grim Reaper
delete from droplist where itemid = 40074 and mobid = 45673;
insert into droplist values (45673, 40074, 2, 6, 300000);
-- redo ndai drop from Grim Reaper
delete from droplist where itemid = 40087 and mobid = 45673;
insert into droplist values (45673, 40087, 1, 3, 300000);
-- redo res scroll drop from Grim Reaper
delete from droplist where itemid = 40089 and mobid = 45673;
insert into droplist values (45673, 40089, 1, 5, 300000);
-- redo bzel drop from Grim Reaper
delete from droplist where itemid = 140074 and mobid = 45673;
insert into droplist values (45673, 140074, 1, 5, 300000);
-- redo bdai drop from Grim Reaper
delete from droplist where itemid = 140087 and mobid = 45673;
insert into droplist values (45673, 140087, 1, 2, 300000);

-- modify existing Death drops
-- increase death items droprate from Death (5000 -> 14000)
update droplist set chance = 14000 where itemid in (20075, 20144, 20183, 20240, 40704, 40705, 40706, 40708, 40709) and mobid = 45674;
-- increase heads of death droprate from Death (50000 -> 85000)
update droplist set chance = 85000 where itemid in (40707, 40780, 40781) and mobid = 45674;

-- modify existing Yahee drops
-- increase yahee item droprate from Yahee (8000 -> 20000)
update droplist set chance = 20000 where itemid in (20031, 20069, 20131, 20179, 20209, 20261, 20290) and mobid = 45675;

-- redo adena drop from Yahee
delete from droplist where itemid = 40308 and mobid = 45675;
insert into droplist values (45675, 40308, 7490, 17850, 1000000);

-- add additional drops to Yahee 
-- add Potion of Bravery to Yahee droplist 
insert into droplist values (45675, 40014, 2, 6, 300000);
-- add Potion of Mana to Yahee droplist 
insert into droplist values (45675, 40015, 2, 6, 300000);
-- add Black Lump of Pure Mithral to Yahee droplist 
insert into droplist values (45675, 40443, 1, 5, 300000);
-- add Black Lump of Rough Mithral to Yahee droplist 
insert into droplist values (45675, 40444, 1, 5, 300000);
-- add Fragment of Soul Stone to Yahee droplist 
insert into droplist values (45675, 40678, 10, 20, 1000000);
-- add Black Blood Stone to Yahee droplist 
insert into droplist values (45675, 40524, 1, 5, 500000);

-- modify existing Laia drops
-- increase nk items, laia robe, evidence, mineral droprate from Laia (10000 -> 35000)
update droplist set chance = 35000 where itemid in (20030, 20106, 20176, 40635, 40675, 132) and mobid = 45677;
-- increase Robe of Evil Spirit King, Scroll of New King, Necklace of Laia droprate from Laia (1000 -> 4500)
update droplist set chance = 4500 where itemid in (20109, 20233, 20252) and mobid = 45677;
-- increase Boots of New King droprate from Laia (5000 -> 16000)
update droplist set chance = 16000 where itemid = 20208 and mobid = 45677;
-- increase Amulet of Magic Spirit King, Ring of Laia, Wand of Laia droprate from Laia (100 -> 700)
update droplist set chance = 700 where itemid in (20253, 20279, 117) and mobid = 45677;
-- increase sb:as droprate from Laia (1000 -> 2000)
update droplist set chance = 2000 where itemid = 40224 and mobid = 45677;

-- redo haste drop from Laia
delete from droplist where itemid = 40013 and mobid = 45677;
insert into droplist values (45677, 40013, 1, 5, 300000);

-- modify existing Cerenis drops
-- increase wizset items droprate from Cerenis (50000 -> 150000)
update droplist set chance = 150000 where itemid in (20012, 20111) and mobid = 45678;
-- increase Circlet of Cerenis, Robe of Cerenis droprate from Cerenis (1000 -> 6000)
update droplist set chance = 6000 where itemid in (20042, 20151) and mobid = 45678;
-- increase Silver Cloak droprate from Cerenis (5000 -> 25000)
update droplist set chance = 25000 where itemid = 20074 and mobid = 45678;
-- increase Gloves of Cerenis droprate from Cerenis (3000 -> 16000)
update droplist set chance = 16000 where itemid = 20185 and mobid = 45678;
-- increase Boots of Cerenis droprate from Cerenis (10000 -> 32000)
update droplist set chance = 32000 where itemid = 20215 and mobid = 45678;
-- decrease ring droprate from Cerenis (50000 -> 25000)
update droplist set chance = 25000 where itemid in (20285, 20300, 20302, 20304) and mobid = 45678;
-- increase int, wis ammy droprate from Cerenis (50000 -> 20000)
update droplist set chance = 20000 where itemid in (20266, 20267) and mobid = 45678;
-- increase b-Silver Cloak droprate from Cerenis (700 -> 2500)
update droplist set chance = 2500 where itemid = 120074 and mobid = 45678;
-- increase sb:as droprate from Cerenis (5000 -> 7500)
update droplist set chance = 7500 where itemid = 40224 and mobid = 45678;

-- modify existing Ken Rauhel drops
-- increase Helmet of the Pretender King droprate from Ken Rauhel (1000 -> 7000)
update droplist set chance = 7000 where itemid = 20024 and mobid = 45680;
-- increase Armor of the Pretender King droprate from Ken Rauhel (5000 -> 22000)
update droplist set chance = 22000 where itemid = 20118 and mobid = 45680;
-- increase cpm, Gauntlet of the Pretender King droprate from Ken Rauhel (10000 -> 30000)
update droplist set chance = 30000 where itemid in (20128, 20170) and mobid = 45680;
-- increase Boots of the Pretender King droprate from Ken Rauhel (50000 -> 100000)
update droplist set chance = 100000 where itemid = 20203 and mobid = 45680;
-- increase Boots of Cerenis droprate from Ken Rauhel (500 -> 1500)
update droplist set chance = 1500 where itemid = 20215 and mobid = 45680;
-- increase Belt of Body droprate from Ken Rauhel (5000 -> 50000)
update droplist set chance = 50000 where itemid = 20312 and mobid = 45680;
-- decrease str/con ammy droprate from Ken Rauhel (50000 -> 20000)
update droplist set chance = 20000 where itemid in (20264, 20268) and mobid = 45680;
-- increase Tsuguri droprate from Ken Rauhel (5000 -> 16000)
update droplist set chance = 16000 where itemid = 57 and mobid = 45680;
-- increase bounce droprate from Ken Rauhel (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40166 and mobid = 45680;

-- modify existing Elindaire drops
-- increase wis ammy droprate from Elindaire (1000 -> 3000)
update droplist set chance = 3000 where itemid = 20267 and mobid = 81081;
-- decrease rosc droprate from Elindaire (10000 -> 2500)
update droplist set chance = 2500 where itemid = 20284 and mobid = 81081;
-- increase wand droprate from Elindaire (10000 -> 50000)
update droplist set chance = 50000 where itemid in (40006, 40008) and mobid = 81081;
-- increase Sapphire droprate from Elindaire (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40046 and mobid = 81081;
-- increase High Quality Sapphire droprate from Elindaire (5000 -> 20000)
update droplist set chance = 20000 where itemid = 40050 and mobid = 81081;
-- increase Highest Quality Sapphire droprate from Elindaire (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40054 and mobid = 81081;
-- increase nzel droprate from Elindaire (10000 -> 75000)
update droplist set chance = 75000 where itemid = 40074 and mobid = 81081;
-- increase sbs droprate from Elindaire (10000 -> 35000)
update droplist set chance = 35000 where itemid in (40173, 40180, 40183, 40185, 40186) and mobid = 81081;
-- increase bzel droprate from Elindaire (10000 -> 30000)
update droplist set chance = 30000 where itemid = 140074 and mobid = 81081;

-- slight increase in succ/succ queen devil's blood droprates
update droplist set chance = 20000 where itemid = 40031 and mobid in (45393, 45394);
update droplist set chance = 25000 where itemid = 40031 and mobid = 45451;

-- slight increase in bb/kbb/ogre devil's blood droprates
update droplist set chance = 9500 where itemid = 40031 and mobid in (45223, 45738);
update droplist set chance = 12000 where itemid = 40031 and mobid in (45370, 45278);



-- update 28

-- correct totem drop from Neruga Orc (was Totem of Rova)
update droplist set itemid = 40132 where itemid = 40134 and mobid = 45171;

-- reduce battle axe droprate from ogre (120000 -> 85000)
update droplist set chance = 85000 where mobid = 45278 and itemid = 143;

-- modify existing Basilisk drops
-- increase brave droprate from Basilisk (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45381;
-- increase Diamond droprate from Basilisk (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40044 and mobid = 45381;
-- increase hqd droprate from Basilisk (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40048 and mobid = 45381;
-- decrease tqd droprate from Basilisk (10000 -> 4500)
update droplist set chance = 4500 where itemid = 40052 and mobid = 45381;
-- increase nzel droprate from Basilisk (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40074 and mobid = 45381;
-- increase ndai droprate from Basilisk (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40087 and mobid = 45381;
-- increase low sb droprate from Basilisk (10000 -> 15000)
update droplist set chance = 15000 where itemid in (40174, 40178, 40180, 40182, 40190) and mobid = 45381;
-- decrease mid sb droprate from Basilisk (10000 -> 7500)
update droplist set chance = 7500 where itemid in (40189, 40207) and mobid = 45381;
-- increase sc:wl droprate from Basilisk (2000 -> 5000)
update droplist set chance = 5000 where itemid = 40253 and mobid = 45381;
-- increase sc:nb droprate from Basilisk (1000 -> 2500)
update droplist set chance = 2500 where itemid = 40255 and mobid = 45381;
-- decrease basi horn droprate from Basilisk (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40646 and mobid = 45381;

-- modify existing SoE Dark Forester drops
-- increase Armor of Dark Forester droprate from SoE Dark Forester (5000 -> 8500)
update droplist set chance = 8500 where itemid = 20098 and mobid = 45326;
-- increase Boots of Dark Forester droprate from SoE Dark Forester (5000 -> 7500)
update droplist set chance = 7500 where itemid = 20196 and mobid = 45326;
-- increase nzel droprate from SoE Dark Forester (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45326;

-- add drops to Escaped Black Knight
-- adena
insert into droplist values (45035, 40308, 25, 70, 1000000);
-- boots
insert into droplist values (45035, 20205, 1, 1, 15000);
-- Helmet
insert into droplist values (45035, 20043, 1, 1, 5000);
-- Potion of Cure Poison
insert into droplist values (45035, 40017, 1, 1, 15000);
-- Scroll of Return - Hidden Valley
insert into droplist values (45035, 40101, 1, 1, 50000);
-- Trident
insert into droplist values (45035, 93, 1, 1, 15000);
-- Cloak of Protection
insert into droplist values (45035, 20063, 1, 1, 7500);
-- Diamond
insert into droplist values (45035, 40044, 1, 1, 5000);
-- Emerald
insert into droplist values (45035, 40047, 1, 1, 5000);
-- Halberd
insert into droplist values (45035, 103, 1, 1, 15000);
-- Haste Potion
insert into droplist values (45035, 40013, 1, 1, 25000);
-- Lance
insert into droplist values (45035, 95, 1, 1, 15000);
-- Red Potion
insert into droplist values (45035, 40010, 1, 1, 50000);
-- Low Boots
insert into droplist values (45035, 20213, 1, 1, 15000);
-- Partisan
insert into droplist values (45035, 94, 1, 1, 15000);
-- Potion of Bravery
insert into droplist values (45035, 40014, 1, 1, 25000);
-- Ruby
insert into droplist values (45035, 40045, 1, 1, 2500);
-- Sapphire
insert into droplist values (45035, 40046, 1, 1, 5000);
-- Potion of Mana
insert into droplist values (45035, 40015, 1, 1, 15000);
-- Plate Mail
insert into droplist values (45035, 20154, 1, 1, 2500);
-- T-Shirt
insert into droplist values (45035, 20085, 1, 1, 2000);
-- Two Handed Sword
insert into droplist values (45035, 52, 1, 1, 2500);
-- Devil\'s Blood 
insert into droplist values (45035, 40031, 1, 1, 2500);
-- b-lance
insert into droplist values (45035, 100095, 1, 1, 5000);
-- b-halberd
insert into droplist values (45035, 100103, 1, 1, 5000);

-- add drops to Valley Bear
-- Adena
insert into droplist values (45036, 40308, 20, 45, 1000000);
-- Scroll of Return - Hidden Valley
insert into droplist values (45036, 40101, 1, 1, 50000);
-- Red Potion
insert into droplist values (45036, 40010, 1, 1, 50000);
-- Meat
insert into droplist values (45036, 40056, 1, 1, 30000);
-- Haste Potion
insert into droplist values (45036, 40013, 1, 1, 15000);
-- Potion of Cure Poison
insert into droplist values (45036, 40017, 1, 1, 15000);
-- Potion of Bravery
insert into droplist values (45036, 40014, 1, 1, 25000);
-- Greater Haste Potion
insert into droplist values (45036, 40018, 1, 1, 15000);
-- b-Scroll of Teleportation
insert into droplist values (45036, 140100, 1, 1, 30000);

-- add drops to Valley Lycanthrope
-- Adena
insert into droplist values (45037, 40308, 30, 60, 1000000);
-- Red Potion
insert into droplist values (45037, 40010, 1, 1, 50000);
-- Scroll of Return to Hidden Valley
insert into droplist values (45037, 40101, 1, 1, 50000);
-- Battle Axe
insert into droplist values (45037, 143, 1, 1, 10000);
-- Boots
insert into droplist values (45037, 20205, 1, 1, 15000);
-- Haste Potion
insert into droplist values (45037, 40013, 1, 1, 25000);
-- Potion of Cure Poison
insert into droplist values (45037, 40017, 1, 1, 15000);
-- Scale Mail
insert into droplist values (45037, 20122, 1, 1, 12000);
-- Studded Leather Armor
insert into droplist values (45037, 20147, 1, 1, 15000);
-- Large Shield
insert into droplist values (45037, 20242, 1, 1, 15000);
-- Diamond
insert into droplist values (45037, 40044, 1, 1, 20000);
-- Fauchard
insert into droplist values (45037, 104, 1, 1, 15000);
-- Scroll of Enchant Weapon 
insert into droplist values (45037, 40087, 1, 1, 1500);

-- add drops to Valley Arachnevil
-- Adena
insert into droplist values (45038, 40308, 20, 45, 1000000);
-- Red Potion
insert into droplist values (45038, 40010, 1, 1, 50000);
-- Potion of Cure Poison
insert into droplist values (45038, 40017, 1, 1, 25000);
-- Scroll of Return to Hidden Valley
insert into droplist values (45038, 40101, 1, 1, 50000);
-- Haste Potion
insert into droplist values (45038, 40013, 1, 1, 25000);
-- Diamond
insert into droplist values (45038, 40044, 1, 1, 15000);
-- Ebony
insert into droplist values (45038, 40007, 1, 1, 5000);
-- Pine
insert into droplist values (45038, 40006, 1, 1, 7500);
-- b-Scroll of Teleportation
insert into droplist values (45038, 140100, 1, 1, 15000);

-- add drops to Fatigued Ratman
-- Adena
insert into droplist values (45052, 40308, 25, 60, 1000000);
-- Potion of Cure Poison
insert into droplist values (45052, 40017, 1, 1, 50000);
-- Red Potion
insert into droplist values (45052, 40010, 1, 1, 50000);
-- Greater Haste Potion
insert into droplist values (45052, 40018, 1, 1, 15000);
-- Haste Potion
insert into droplist values (45052, 40013, 1, 1, 25000);
-- Low Boots
insert into droplist values (45052, 20213, 1, 1, 15000);
-- b-Scroll of Teleportation
insert into droplist values (45052, 140100, 1, 1, 15000);

-- add drops to Valley Owlbear
-- Adena
insert into droplist values (45056, 40308, 16, 40, 1000000); 
-- Apple
insert into droplist values (45056, 40064, 1, 1, 85000); 
-- Banana
insert into droplist values (45056, 40062, 1, 1, 85000); 
-- Carrot
insert into droplist values (45056, 40060, 1, 1, 85000); 
-- Egg
insert into droplist values (45056, 40059, 1, 1, 85000); 
-- Lemon
insert into droplist values (45056, 40061, 1, 1, 85000); 
-- Orange
insert into droplist values (45056, 40069, 1, 1, 85000); 
-- Lamp
insert into droplist values (45056, 40001, 1, 1, 85000); 
-- Red Potion
insert into droplist values (45056, 40010, 1, 1, 50000); 
-- Scroll of Return to Hidden Valley
insert into droplist values (45056, 40101, 1, 1, 50000); 
-- Hard Leather 
insert into droplist values (45056, 40406, 1, 1, 15000); 

-- add drops to Giant Spider
-- Adena
insert into droplist values (45059, 40308, 30, 70, 1000000); 
-- Red Potion
insert into droplist values (45059, 40010, 1, 1, 50000); 
-- Potion of Cure Poison
insert into droplist values (45059, 40017, 1, 1, 50000); 
-- Scroll of Return to Hidden Valley
insert into droplist values (45059, 40101, 1, 1, 50000); 
-- Haste Potion
insert into droplist values (45059, 40013, 1, 1, 25000); 
-- Diamond
insert into droplist values (45059, 40044, 1, 1, 10000); 
-- Ebony
insert into droplist values (45059, 40007, 1, 1, 7500); 
-- Pine
insert into droplist values (45059, 40006, 1, 1, 5000); 
-- b-Scroll of Teleportation 
insert into droplist values (45059, 140100, 1, 1, 15000); 

-- add drops to Valley Harpy
-- Adena
insert into droplist values (45067, 40308, 35, 70, 1000000); 
-- Red Potion
insert into droplist values (45067, 40010, 1, 1, 50000); 
-- Haste Potion
insert into droplist values (45067, 40013, 1, 1, 15000); 
-- Potion of Cure Poison
insert into droplist values (45067, 40017, 1, 1, 15000); 
-- Potion of Mana
insert into droplist values (45067, 40015, 1, 1, 20000); 
-- Scroll of Return to Hidden Valley
insert into droplist values (45067, 40101, 1, 1, 50000); 
-- Scroll of Teleportation
insert into droplist values (45067, 40100, 1, 1, 25000); 
-- Helmet of Magic: Healing
insert into droplist values (45067, 20014, 1, 1, 2500); 
-- Scroll of Enchant Weapon
insert into droplist values (45067, 40087, 1, 1, 1000); 
-- b-Scroll of Teleportation 
insert into droplist values (45067, 140100, 1, 1, 15000); 

-- add drops to Starved Troll
-- Adena
insert into droplist values (45069, 40308, 35, 70, 1000000); 
-- Condensed Lesser Healing Potion
insert into droplist values (45069, 40019, 1, 1, 15000); 
-- Condensed Healing Potion
insert into droplist values (45069, 40020, 1, 1, 7000); 
-- Condensed Greater Healing Potion
insert into droplist values (45069, 40021, 1, 1, 3500); 
-- Haste Potion
insert into droplist values (45069, 40013, 1, 1, 15000); 
-- Potion of Cure Poison
insert into droplist values (45069, 40017, 1, 1, 15000); 
-- Potion of Bravery
insert into droplist values (45069, 40014, 1, 1, 25000); 
-- Scroll of Return to Hidden Valley
insert into droplist values (45069, 40101, 1, 1, 50000); 
-- Battle Axe
insert into droplist values (45069, 143, 1, 1, 10000); 
-- Berserker Axe
insert into droplist values (45069, 145, 1, 1, 7500); 
-- Great Axe
insert into droplist values (45069, 148, 1, 1, 4500); 
-- Splint Mail
insert into droplist values (45069, 20115, 1, 1, 5000); 
-- Helmet of Magic: Healing
insert into droplist values (45069, 20014, 1, 1, 2500); 

-- add drops to Valley Ogre
-- Adena
insert into droplist values (45078, 40308, 25, 60, 1000000);
-- Red Potion
insert into droplist values (45078, 40010, 1, 1, 50000);
-- Haste Potion
insert into droplist values (45078, 40013, 1, 1, 15000);
-- Potion of Bravery
insert into droplist values (45078, 40014, 1, 1, 25000);
-- Scroll of Return to Hidden Valley
insert into droplist values (45078, 40101, 1, 1, 50000);
-- Battle Axe
insert into droplist values (45078, 143, 1, 1, 25000);
-- Berserker Axe
insert into droplist values (45078, 145, 1, 1, 7500);
-- Great Axe
insert into droplist values (45078, 148, 1, 1, 8500); 
-- Splint Mail
insert into droplist values (45078, 20115, 1, 1, 7500);
-- Blood of Ogre
insert into droplist values (45078, 40513, 1, 1, 100);
-- Helmet of Magic: Power
insert into droplist values (45078, 20015, 1, 1, 1200); 
-- Scroll of Enchant Armor
insert into droplist values (45078, 40074, 1, 1, 1000);
-- Scroll of Enchant Weapon
insert into droplist values (45078, 40087, 1, 1, 500);

-- add drops to Valley Griffon
-- Adena
insert into droplist values (45090, 40308, 25, 60, 1000000); 
-- Potion of Cure Poison
insert into droplist values (45090, 40017, 1, 1, 20000); 
-- Scroll of Return to Hidden Valley
insert into droplist values (45090, 40101, 1, 1, 50000); 
-- Haste Potion
insert into droplist values (45090, 40013, 1, 1, 15000); 
-- High Quality Emerald
insert into droplist values (45090, 40051, 1, 1, 2000); 
-- High Quality Ruby
insert into droplist values (45090, 40049, 1, 1, 2000); 
-- Red Potion
insert into droplist values (45090, 40010, 1, 1, 50000); 
-- High Quality Diamond
insert into droplist values (45090, 40048, 1, 1, 4500); 
-- High Quality Sapphire
insert into droplist values (45090, 40050, 1, 1, 5000); 
-- Scroll of Teleportation
insert into droplist values (45090, 40100, 1, 1, 15000); 
-- Greater Haste Potion
insert into droplist values (45090, 140018, 1, 1, 10000); 
-- Haste Potion
insert into droplist values (45090, 140013, 1, 1, 12000); 
-- Banded Mail
insert into droplist values (45090, 20101, 1, 1, 2500); 

-- add drops to Valley Basilisk
-- Adena
insert into droplist values (45091, 40308, 25, 55, 1000000); 
-- Red Potion
insert into droplist values (45091, 40010, 1, 1, 50000); 
-- Haste Potion
insert into droplist values (45091, 40013, 1, 1, 15000); 
-- Scroll of Return to Hidden Valley
insert into droplist values (45091, 40101, 1, 1, 50000); 
-- Diamond
insert into droplist values (45091, 40044, 1, 1, 10000); 
-- Scroll of Curse Removal
insert into droplist values (45091, 40119, 1, 1, 15000); 
-- High Quality Diamond
insert into droplist values (45091, 40048, 1, 1, 7500); 
-- Scroll of Enchant Armor
insert into droplist values (45091, 40074, 1, 1, 1000); 
-- Scroll of Enchant Weapon
insert into droplist values (45091, 40087, 1, 1, 500); 
-- Basilisk Horn 
insert into droplist values (45091, 40646, 1, 1, 250); 

-- add drops to Rotting Skeleton Guard
-- Adena
insert into droplist values (45062, 40308, 20, 45, 1000000);
-- Lamp
insert into droplist values (45062, 40001, 1, 1, 25000);
-- Red Potion
insert into droplist values (45062, 40010, 1, 1, 50000);
-- Haste Potion
insert into droplist values (45062, 40013, 1, 1, 15000);
-- Potion of Cure Poison
insert into droplist values (45062, 40017, 1, 1, 15000);
-- Scroll of Return to Singing Island
insert into droplist values (45062, 40082, 1, 1, 50000);
-- Bone Piece
insert into droplist values (45062, 40407, 1, 1, 50000);
-- Spear 
insert into droplist values (45062, 96, 1, 1, 25000);

-- add drops to Rotting Skeleton Marksman
-- Adena
insert into droplist values (45063, 40308, 20, 55, 1000000);
-- Bow
insert into droplist values (45063, 172, 1, 1, 25000);
-- Bone Piece
insert into droplist values (45063, 40407, 1, 1, 50000);
-- Scroll of Return to Singing Island
insert into droplist values (45063, 40082, 1, 1, 50000);
-- Red Potion
insert into droplist values (45063, 40010, 1, 1, 50000);
-- Haste Potion
insert into droplist values (45063, 40013, 1, 1, 15000);
-- Arrow
insert into droplist values (45063, 40743, 10, 35, 50000);

-- add drops to Island Ghast
-- Adena
insert into droplist values (45071, 40308, 20, 55, 1000000);
-- Battle Axe
insert into droplist values (45071, 143, 1, 1, 10000);
-- Red Potion
insert into droplist values (45071, 40010, 1, 1, 50000);
-- Potion of Cure Poison
insert into droplist values (45071, 40017, 1, 1, 15000);
-- Scroll of Return to Singing Island 
insert into droplist values (45071, 40082, 1, 1, 50000);
-- Haste Potion
insert into droplist values (45071, 40013, 1, 1, 15000);

-- add drops to Rotting Skeleton Fighter
-- Adena
insert into droplist values (45073, 40308, 20, 65, 1000000);
-- Red Potion
insert into droplist values (45073, 40010, 1, 1, 50000);
-- Bone Piece
insert into droplist values (45073, 40407, 1, 1, 50000);
-- Scroll of Return to Singing Island
insert into droplist values (45073, 40082, 1, 1, 50000);
-- Battle Axe
insert into droplist values (45073, 143, 1, 1, 15000);

-- add drops to Island Ghast Lord
-- Adena
insert into droplist values (45081, 40308, 20, 65, 1000000);
-- Silver Arrow
insert into droplist values (45081, 40744, 10, 35, 25000);
-- Red Potion
insert into droplist values (45081, 40010, 1, 1, 50000);
-- Potion of Cure Poison
insert into droplist values (45081, 40017, 1, 1, 15000);
-- Potion of Wisdom
insert into droplist values (45081, 40016, 1, 1, 15000);
-- Scroll of Return to Singing Island
insert into droplist values (45081, 40082, 1, 1, 50000);
-- Battle Axe
insert into droplist values (45081, 143, 1, 1, 10000);
-- Haste Potion
insert into droplist values (45081, 40013, 1, 1, 15000);
-- Potion of Mana
insert into droplist values (45081, 40015, 1, 1, 25000);
-- Scroll of Curse Removal
insert into droplist values (45081, 40119, 1, 1, 15000);
-- Scroll of Teleportation
insert into droplist values (45081, 40100, 1, 1, 15000);
-- Berserker Axe
insert into droplist values (45081, 145, 1, 1, 8500);
-- Great Axe
insert into droplist values (45081, 148, 1, 1, 7500);
-- Scroll of Enchant Armor
insert into droplist values (45081, 40074, 1, 1, 500);
-- Scroll of Enchant Weapon
insert into droplist values (45081, 40087, 1, 1, 250);
-- b-Scroll of Teleportation 
insert into droplist values (45081, 140100, 1, 1, 15000);

-- add drops to Degenerated Beholder
-- Adena
insert into droplist values (45086, 40308, 20, 55, 1000000);
-- Potion of Cure Poison
insert into droplist values (45086, 40017, 1, 1, 15000);
-- Red Potion
insert into droplist values (45086, 40010, 1, 1, 50000);
-- Potion of Wisdom
insert into droplist values (45086, 40016, 1, 1, 15000);
-- Scroll of Return to Singing Island
insert into droplist values (45086, 40082, 1, 1, 50000);
-- Silver Arrow
insert into droplist values (45086, 40744, 10, 35, 25000);
-- Haste Potion
insert into droplist values (45086, 40013, 1, 1, 15000);
-- Potion of Mana
insert into droplist values (45086, 40015, 1, 1, 25000);
-- Scroll of Enchant Weapon
insert into droplist values (45086, 40087, 1, 1, 250);
-- c-Scroll of Enchant Weapon
insert into droplist values (45086, 140087, 1, 1, 250);

-- add drops to Island Cockatrice
-- Adena
insert into droplist values (45095, 40308, 20, 60, 1000000);
-- Red Potion
insert into droplist values (45095, 40010, 1, 1, 50000);
-- Scroll of Return to Singing Island
insert into droplist values (45095, 40082, 1, 1, 50000);
-- Potion of Mana
insert into droplist values (45095, 40015, 1, 1, 15000);
-- Greater Haste Potion
insert into droplist values (45095, 40012, 1, 1, 10000);
-- Haste Potion
insert into droplist values (45095, 40013, 1, 1, 15000);
-- Potion of Cure Poison
insert into droplist values (45095, 40017, 1, 1, 15000);
-- Potion of Wisdom
insert into droplist values (45095, 40016, 1, 1, 15000);
-- Ebony
insert into droplist values (45095, 40007, 1, 1, 10000);
-- Scroll of Enchant Armor
insert into droplist values (45095, 40074, 1, 1, 500);
-- Scroll of Enchant Weapon
insert into droplist values (45095, 40087, 1, 1, 250);
-- b-Scroll of Teleportation  
insert into droplist values (45095, 140100, 1, 1, 15000);

-- add drops to Island Crocodile
-- Adena
insert into droplist values (45096, 40308, 35, 85, 1000000);
-- Red Potion
insert into droplist values (45096, 40010, 1, 1, 50000);
-- Scroll of Return to Singing Island
insert into droplist values (45096, 40082, 1, 1, 50000);
-- Haste Potion
insert into droplist values (45096, 40013, 1, 1, 15000);
-- Scroll of Curse Removal
insert into droplist values (45096, 40119, 1, 1, 15000);
-- Silver Arrow
insert into droplist values (45096, 40744, 10, 35, 25000);
-- Potion of Cure Poison
insert into droplist values (45096, 40017, 1, 1, 15000);
-- Scroll of Enchant Armor
insert into droplist values (45096, 40074, 1, 1, 750);
-- Ebony
insert into droplist values (45096, 40007, 1, 1, 10000);

-- add drops to Mutated Alligator
-- Adena
insert into droplist values (45026, 40308, 15, 35, 1000000);
-- Haste Potion
insert into droplist values (45026, 40013, 1, 1, 15000);
-- Scroll of Return to Singing Island
insert into droplist values (45026, 40082, 1, 1, 50000);
-- Red Potion 
insert into droplist values (45026, 40010, 1, 1, 50000);

-- modify existing Priest of Corruption (45570) drops
-- increase Potion of Bravery droprate from Priest of Corruption (45570) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45570;
-- increase Potion of Mana droprate from Priest of Corruption (45570) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45570;
-- increase Black Lump of Pure Mithral droprate from Priest of Corruption (45570) (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40443 and mobid = 45570;
-- increase Black Blood Stone droprate from Priest of Corruption (45570) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45570;
-- increase Fragment of Soul Stone droprate from Priest of Corruption (45570) (50000 -> 200000)
update droplist set chance = 200000 where itemid = 40678 and mobid = 45570;
-- increase btele droprate from Priest of Corruption (45570) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45570;

-- modify existing Priest of Corruption (45571) drops
-- increase Potion of Bravery droprate from Priest of Corruption (45571) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45571;
-- increase Potion of Mana droprate from Priest of Corruption (45571) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45571;
-- increase ntele droprate from Priest of Corruption (45571) (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40100 and mobid = 45571;
-- increase Black Lump of Pure Mithral droprate from Priest of Corruption (45571) (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40443 and mobid = 45571;
-- increase Black Blood Stone droprate from Priest of Corruption (45571) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45571;
-- increase Fragment of Soul Stone droprate from Priest of Corruption (45571) (50000 -> 200000)
update droplist set chance = 200000 where itemid = 40678 and mobid = 45571;
-- increase btele droprate from Priest of Corruption (45571) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45571;

-- modify existing Priest of Corruption (45582) drops
-- increase Potion of Bravery droprate from Priest of Corruption (45582) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45582;
-- increase Potion of Mana droprate from Priest of Corruption (45582) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45582;
-- increase Black Lump of Pure Mithral droprate from Priest of Corruption (45582) (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40443 and mobid = 45582;
-- increase Black Blood Stone droprate from Priest of Corruption (45582) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45582;
-- increase Fragment of Soul Stone droprate from Priest of Corruption (45587) (50000 -> 200000)
update droplist set chance = 200000 where itemid = 40678 and mobid = 45582;
-- increase btele droprate from Priest of Corruption (45582) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45582;

-- modify existing Priest of Corruption (45587) drops
-- increase Potion of Bravery droprate from Priest of Corruption (45587) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45587;
-- increase Potion of Mana droprate from Priest of Corruption (45587) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45587;
-- increase Black Lump of Pure Mithral droprate from Priest of Corruption (45587) (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40443 and mobid = 45587;
-- increase Black Blood Stone  droprate from Priest of Corruption (45587) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45587;
-- increase Fragment of Soul Stone droprate from Priest of Corruption (45587) (50000 -> 200000)
update droplist set chance = 200000 where itemid = 40678 and mobid = 45587;
-- increase btele droprate from Priest of Corruption (45587) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45587;

-- modify existing Priest of Corruption (45605) drops
-- increase Potion of Bravery droprate from Priest of Corruption (45605) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45605;
-- increase Potion of Mana droprate from Priest of Corruption (45605) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45605;
-- increase Black Lump of Pure Mithral droprate from Priest of Corruption (45605) (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40443 and mobid = 45605;
-- increase Black Blood Stone  droprate from Priest of Corruption (45605) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45605;
-- increase Fragment of Soul Stone droprate from Priest of Corruption (45605) (50000 -> 200000)
update droplist set chance = 200000 where itemid = 40678 and mobid = 45605;
-- increase btele droprate from Priest of Corruption (45605) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45605;



-- update 29

-- correct the 100% Key of Fate drop from Varlok Servant
update droplist set chance = 1000000 where mobid = 45709 and itemid = 40589; 



-- update 30

-- change sc:nature's miracle to unused item_id 
update droplist set itemid = 50001 where itemid = 41243;


-- merge in new droplist data
INSERT INTO `droplist` VALUES ('45018', '40008', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45018', '40088', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45018', '40308', '10', '30', '1000000');
INSERT INTO `droplist` VALUES ('45018', '40405', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45018', '40899', '1', '1', '10000');
delete from droplist where mobid = 45020;
INSERT INTO `droplist` VALUES ('45020', '40029', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45020', '40082', '1', '1', '80000');
INSERT INTO `droplist` VALUES ('45020', '40308', '5', '10', '1000000');
INSERT INTO `droplist` VALUES ('45040', '41275', '1', '1', '40000');
INSERT INTO `droplist` VALUES ('45115', '41274', '1', '1', '40000');
INSERT INTO `droplist` VALUES ('45120', '158', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45120', '20032', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45120', '20070', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45120', '20110', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45120', '40001', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45120', '40267', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45120', '40308', '20', '45', '1000000');
INSERT INTO `droplist` VALUES ('45120', '40408', '1', '1', '50000');
delete from droplist where itemid = 40329 and mobid = 45139;
INSERT INTO `droplist` VALUES ('45139', '41276', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45139', '140329', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45139', '20425', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45147', '41263', '1', '1', '100000');
delete from droplist where itemid = 20293 and mobid = 45158;
delete from droplist where itemid = 20296 and mobid = 45158;
INSERT INTO `droplist` VALUES ('45158', '140329', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45158', '220293', '1', '1', '8000');
INSERT INTO `droplist` VALUES ('45158', '220296', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45158', '20423', '1', '1', '1000');
delete from droplist where itemid = 40329 and mobid = 45163;
INSERT INTO `droplist` VALUES ('45163', '41276', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45163', '140329', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45163', '20425', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45190', '41274', '1', '1', '50000');
delete from droplist where itemid = 40329 and mobid = 45197;
INSERT INTO `droplist` VALUES ('45197', '41276', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45197', '140329', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45197', '20425', '1', '1', '1000');
delete from droplist where itemid = 20293 and mobid = 45217;
delete from droplist where itemid = 20295 and mobid = 45217;
INSERT INTO `droplist` VALUES ('45217', '220293', '1', '1', '8000');
INSERT INTO `droplist` VALUES ('45217', '220295', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45217', '20423', '1', '1', '1000');
delete from droplist where itemid = 40329 and mobid = 45239;
INSERT INTO `droplist` VALUES ('45239', '140329', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45239', '20425', '1', '1', '1000');
delete from droplist where itemid = 20293 and mobid = 45247;
delete from droplist where itemid = 20296 and mobid = 45247;
INSERT INTO `droplist` VALUES ('45247', '220293', '1', '1', '8000');
INSERT INTO `droplist` VALUES ('45247', '220296', '1', '1', '7500');
INSERT INTO `droplist` VALUES ('45247', '20423', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45247', '20424', '1', '1', '1000');
delete from droplist where itemid = 40329 and mobid = 45249;
INSERT INTO `droplist` VALUES ('45249', '140329', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45249', '20425', '1', '1', '1000');
delete from droplist where itemid = 20293 and mobid = 45251;
delete from droplist where itemid = 20294 and mobid = 45251;
delete from droplist where itemid = 20295 and mobid = 45251;
INSERT INTO `droplist` VALUES ('45251', '220293', '1', '1', '8000');
INSERT INTO `droplist` VALUES ('45251', '220294', '1', '1', '7500');
INSERT INTO `droplist` VALUES ('45251', '220295', '1', '1', '4500');
INSERT INTO `droplist` VALUES ('45251', '20423', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45252', '41275', '1', '1', '50000');
delete from droplist where itemid = 20293 and mobid = 45274;
delete from droplist where itemid = 20296 and mobid = 45274;
INSERT INTO `droplist` VALUES ('45274', '220293', '1', '1', '8000');
INSERT INTO `droplist` VALUES ('45274', '220296', '1', '1', '7500');
INSERT INTO `droplist` VALUES ('45274', '20424', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45294', '41263', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45314', '20424', '1', '1', '1000');
delete from droplist where itemid = 20293 and mobid = 45330;
delete from droplist where itemid = 20294 and mobid = 45330;
INSERT INTO `droplist` VALUES ('45330', '220293', '1', '1', '8000');
INSERT INTO `droplist` VALUES ('45330', '220294', '1', '1', '7500');
INSERT INTO `droplist` VALUES ('45330', '20424', '1', '1', '1000');
update droplist set chance = 1000000 where itemid = 40630 and mobid = 45413;
update droplist set chance = 1000000 where itemid = 40654 and mobid = 45421;
delete from droplist where itemid = 20293 and mobid = 45458;
delete from droplist where itemid = 20294 and mobid = 45458;
delete from droplist where itemid = 20295 and mobid = 45458;
delete from droplist where itemid = 20296 and mobid = 45458;
INSERT INTO `droplist` VALUES ('45458', '220293', '1', '1', '20000');
INSERT INTO `droplist` VALUES ('45458', '220294', '1', '1', '15000');
INSERT INTO `droplist` VALUES ('45458', '220295', '1', '1', '15000');
INSERT INTO `droplist` VALUES ('45458', '220296', '1', '1', '15000');
INSERT INTO `droplist` VALUES ('45459', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45459', '40618', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45459', '40636', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45459', '40635', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45460', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45460', '40643', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45460', '40636', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45460', '40635', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45461', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45461', '40645', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45461', '40636', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45461', '40635', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45462', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45462', '40651', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45462', '40636', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45462', '40635', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45465', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45465', '40676', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45465', '40636', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45465', '40635', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45466', '40429', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45466', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45466', '40703', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45466', '40668', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45466', '40667', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45466', '40640', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45466', '40642', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45466', '20030', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45466', '20067', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45466', '20176', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45466', '20208', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45466', '20313', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45467', '40013', '1', '1', '1000000');
INSERT INTO `droplist` VALUES ('45467', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45467', '40652', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45467', '40655', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45467', '40639', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45467', '40638', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45467', '40454', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45467', '62', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45467', '20168', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45467', '20201', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45471', '41150', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45483', '40013', '1', '1', '1000000');
INSERT INTO `droplist` VALUES ('45483', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45483', '40652', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45483', '40655', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45483', '40639', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45483', '40638', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45483', '40454', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45486', '40429', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45486', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45486', '40640', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45486', '40642', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45486', '55', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45486', '20113', '1', '1', '500');
delete from droplist where itemid = 20295 and mobid = 45492;
update droplist set chance = 500000 where itemid = 40634 and mobid = 45492;
INSERT INTO `droplist` VALUES ('45492', '220295', '1', '1', '15000');
INSERT INTO `droplist` VALUES ('45492', '21019', '1', '1', '1000');
update droplist set chance = 2000 where itemid = 40423 and mobid = 45498;
update droplist set chance = 8000 where itemid = 40464 and mobid = 45498;
INSERT INTO `droplist` VALUES ('45512', '40013', '1', '1', '1000000');
INSERT INTO `droplist` VALUES ('45512', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45512', '40652', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45512', '40655', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45512', '40639', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45512', '40638', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45512', '40454', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45517', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45517', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45517', '40640', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45517', '40642', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45517', '130', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45517', '20132', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45517', '20129', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45517', '20030', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45517', '20208', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45518', '40429', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45518', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45518', '40668', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45518', '40667', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45518', '20030', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45518', '20067', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45518', '20208', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45518', '20313', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45521', '40013', '1', '1', '1000000');
INSERT INTO `droplist` VALUES ('45521', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45521', '40677', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45521', '40703', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45521', '40639', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45521', '40638', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45523', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45523', '40429', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45523', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45523', '40640', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45523', '40642', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45523', '130', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45523', '20030', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45523', '20208', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45526', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45526', '40720', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45526', '40703', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45526', '40639', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45526', '40638', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45526', '62', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45526', '20168', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45526', '20201', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45527', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45527', '40429', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45527', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45527', '40640', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45527', '40642', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45527', '40', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45527', '20030', '1', '1', '500');
update droplist set chance = 35000 where itemid = 40078 and mobid = 45530;
update droplist set chance = 2500 where itemid = 40422 and mobid = 45530;
update droplist set chance = 8500 where itemid = 40463 and mobid = 45530;
INSERT INTO `droplist` VALUES ('45533', '40013', '1', '1', '1000000');
INSERT INTO `droplist` VALUES ('45533', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45533', '40703', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45533', '40639', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45533', '40638', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45533', '62', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45533', '20168', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45533', '20201', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45533', '20313', '1', '1', '1000');
update droplist set chance = 35000 where itemid = 40077 and mobid = 45537;
delete from droplist where itemid = 40129 and mobid = 45537;
delete from droplist where itemid = 40130 and mobid = 45537;
update droplist set chance = 3000 where itemid = 40421 and mobid = 45537;
update droplist set chance = 9000 where itemid = 40462 and mobid = 45537;
INSERT INTO `droplist` VALUES ('45537', '140129', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45537', '140130', '1', '1', '10000');
delete from droplist where itemid = 20293 and mobid = 45548;
delete from droplist where itemid = 20294 and mobid = 45548;
update droplist set chance = 1000000 where itemid = 40717 and mobid = 45548;
INSERT INTO `droplist` VALUES ('45548', '220293', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45548', '220294', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45574', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45574', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45574', '40668', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45574', '40667', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45574', '70', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45574', '20020', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45574', '20168', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45574', '20201', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45574', '20313', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45574', '41147', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45577', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45577', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45577', '40639', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45577', '40638', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45577', '62', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45577', '20228', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45577', '20168', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45577', '20201', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45577', '20313', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45577', '41147', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45585', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45585', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45585', '40668', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45585', '40667', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45585', '70', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45585', '20020', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45585', '20168', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45585', '20201', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45585', '20313', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45585', '41147', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45588', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45588', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45588', '40639', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45588', '40638', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45588', '62', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45588', '20058', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45588', '20168', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45588', '20201', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45588', '20313', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45588', '41147', '1', '1', '5000');
delete from droplist where itemid = 40129 and mobid = 45603;
delete from droplist where itemid = 40130 and mobid = 45603;
update droplist set chance = 2500 where itemid = 40420 and mobid = 45603;
update droplist set chance = 9000 where itemid = 40461 and mobid = 45603;
INSERT INTO `droplist` VALUES ('45603', '140129', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45603', '140130', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45607', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45607', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45607', '40639', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45607', '40638', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45607', '62', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45607', '20020', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45607', '20168', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45607', '20201', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45607', '20313', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45607', '41147', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45608', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45608', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45608', '40640', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45608', '40642', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45608', '132', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45608', '20030', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45608', '20176', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45608', '41147', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45612', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45612', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45612', '40636', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45612', '40635', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45612', '132', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45612', '20030', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45612', '20176', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45612', '20208', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45612', '41147', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45615', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45615', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45615', '40640', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45615', '40642', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45615', '132', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45615', '20030', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45615', '41147', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45648', '40962', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45648', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45648', '40429', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45648', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45648', '40668', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45648', '40667', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45648', '78', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45648', '20020', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45648', '20168', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45648', '20178', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45648', '20201', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45648', '20313', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45676', '40959', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45676', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45676', '40429', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45676', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45676', '40640', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45676', '40642', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45676', '132', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45676', '20030', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45676', '20233', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45676', '20057', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45676', '20255', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45676', '41149', '1', '1', '1000');
delete from droplist where itemid = 40129 and mobid = 45685;
delete from droplist where itemid = 40130 and mobid = 45685;
INSERT INTO `droplist` VALUES ('45685', '140129', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45685', '140130', '1', '1', '3000');
INSERT INTO `droplist` VALUES ('45713', '40044', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45713', '40045', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45713', '40046', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45713', '40047', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45713', '40048', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45713', '40049', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45713', '40050', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45713', '40051', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45713', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45714', '40044', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45714', '40045', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45714', '40046', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45714', '40047', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45714', '40048', '1', '1', '3000');
INSERT INTO `droplist` VALUES ('45714', '40049', '1', '1', '3000');
INSERT INTO `droplist` VALUES ('45714', '40050', '1', '1', '3000');
INSERT INTO `droplist` VALUES ('45714', '40051', '1', '1', '3000');
INSERT INTO `droplist` VALUES ('45714', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45715', '40046', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45715', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45715', '41043', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45715', '41156', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45715', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45716', '40041', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45716', '40183', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45716', '40184', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45716', '40225', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45716', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45716', '41045', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45716', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45717', '40041', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45717', '40183', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45717', '40184', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45717', '40225', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45717', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45717', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45718', '40017', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45718', '40046', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45718', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45718', '41042', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45718', '41156', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45718', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45719', '40046', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45719', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45719', '41156', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45719', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45720', '20411', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45720', '40044', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45720', '40305', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45720', '41038', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45720', '41039', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45720', '41154', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45720', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45721', '20412', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45721', '40044', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45721', '40305', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45721', '41040', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45721', '41041', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45721', '41154', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45721', '41207', '1', '1', '30000');
delete from droplist where mobid = 45722;
INSERT INTO `droplist` VALUES ('45722', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45723', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45723', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45723', '240074', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45723', '240087', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45724', '40074', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45724', '40255', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45724', '41045', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45724', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45725', '40041', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45725', '40044', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45725', '40074', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45725', '40255', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45725', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45725', '41045', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45725', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45726', '20381', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45726', '40047', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45726', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45726', '41044', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45726', '41155', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45726', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45727', '40047', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45727', '40253', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45727', '40255', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45727', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45727', '41044', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45727', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45728', '20381', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45728', '40047', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45728', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45728', '41044', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45728', '41155', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45728', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45729', '20381', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45729', '40047', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45729', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45729', '41155', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45729', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45730', '212', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45730', '40013', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45730', '40017', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45730', '40041', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45730', '40045', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45730', '40206', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45730', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45730', '40524', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45730', '41047', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45730', '41156', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45730', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45731', '40045', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45731', '40206', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45731', '40306', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45731', '40524', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45731', '41156', '1', '1', '3000');
INSERT INTO `droplist` VALUES ('45731', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45731', '100212', '1', '1', '3000');
INSERT INTO `droplist` VALUES ('45732', '40007', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45732', '40304', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45732', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45732', '41046', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45732', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45733', '40074', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45733', '40087', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45733', '40183', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45733', '40185', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45733', '40192', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45733', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45733', '41046', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45733', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45734', '20207', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45734', '20381', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45734', '40050', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45734', '40308', '5000', '25000', '1000000');
INSERT INTO `droplist` VALUES ('45734', '41157', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45734', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45734', '140074', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45734', '140087', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45735', '212', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45735', '20381', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45735', '40013', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45735', '40017', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45735', '40041', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45735', '40052', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45735', '40053', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45735', '40253', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45735', '40306', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45735', '40308', '15000', '35000', '1000000');
INSERT INTO `droplist` VALUES ('45735', '40524', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45735', '41152', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45735', '41157', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45735', '41207', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45735', '240074', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45735', '240087', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45739', '40396', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45739', '40718', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45739', '40978', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45739', '40982', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45739', '40986', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45740', '40395', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45740', '40718', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45740', '40979', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45740', '40983', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45740', '40986', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45741', '40393', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45741', '40718', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45741', '40980', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45741', '40984', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45741', '40986', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45742', '40394', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45742', '40718', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45742', '40981', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45742', '40985', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45742', '40986', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45743', '40443', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45743', '40444', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45743', '40524', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45743', '40718', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45743', '40913', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45743', '40976', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45743', '40977', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45743', '240074', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45743', '240087', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45744', '40443', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45744', '40444', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45744', '40524', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45744', '40718', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45744', '40914', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45744', '240074', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45744', '240087', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45745', '40443', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45745', '40444', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45745', '40524', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45745', '40718', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45745', '40914', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45745', '40974', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45745', '40975', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45745', '240074', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45745', '240087', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45746', '40443', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45746', '40444', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45746', '40524', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45746', '40718', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45746', '40915', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45746', '240074', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45746', '240087', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45747', '40443', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45747', '40444', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45747', '40524', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45747', '40718', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45747', '40915', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45747', '40970', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45747', '40971', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45747', '240074', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45747', '240087', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45749', '40443', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45749', '40444', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45749', '40524', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45749', '40718', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45749', '40916', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45749', '240074', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45749', '240087', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45751', '40443', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45751', '40444', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45751', '40524', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45751', '40718', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45751', '40916', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45751', '40972', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45751', '40973', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45751', '240074', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45751', '240087', '1', '1', '2000');
INSERT INTO `droplist` VALUES ('45753', '40443', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45753', '40444', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45753', '40524', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45753', '40718', '10', '50', '30000');
INSERT INTO `droplist` VALUES ('45753', '40990', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45753', '40991', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45753', '40992', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45753', '40993', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45753', '40994', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45753', '40995', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45753', '40996', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45753', '40997', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45753', '40998', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45753', '41148', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45754', '40029', '1', '1', '650000');
INSERT INTO `droplist` VALUES ('45754', '40056', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45754', '40060', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45754', '40061', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45754', '40062', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45754', '40082', '1', '1', '420000');
INSERT INTO `droplist` VALUES ('45754', '40308', '5', '10', '500000');
INSERT INTO `droplist` VALUES ('45755', '40029', '1', '1', '400000');
INSERT INTO `droplist` VALUES ('45755', '40308', '5', '10', '300000');
INSERT INTO `droplist` VALUES ('45756', '40029', '1', '1', '600000');
INSERT INTO `droplist` VALUES ('45756', '40308', '4', '8', '550000');
INSERT INTO `droplist` VALUES ('45756', '41223', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45757', '40017', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45757', '40029', '1', '2', '400000');
INSERT INTO `droplist` VALUES ('45757', '40082', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45757', '40308', '6', '16', '500000');
INSERT INTO `droplist` VALUES ('45758', '40029', '1', '1', '400000');
INSERT INTO `droplist` VALUES ('45758', '40056', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45758', '40095', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45758', '40098', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45758', '40308', '8', '12', '300000');
INSERT INTO `droplist` VALUES ('45758', '40744', '8', '15', '300000');
INSERT INTO `droplist` VALUES ('45758', '41224', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45759', '40001', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45759', '40029', '1', '2', '400000');
INSERT INTO `droplist` VALUES ('45759', '40056', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45759', '40095', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45759', '40308', '8', '24', '300000');
INSERT INTO `droplist` VALUES ('45759', '41224', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45760', '40029', '1', '1', '400000');
INSERT INTO `droplist` VALUES ('45760', '40057', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45761', '26', '1', '1', '150000');
INSERT INTO `droplist` VALUES ('45761', '40029', '1', '2', '400000');
INSERT INTO `droplist` VALUES ('45761', '40056', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45761', '40095', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45761', '40098', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45761', '40308', '6', '17', '300000');
INSERT INTO `droplist` VALUES ('45761', '41215', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45762', '40029', '1', '1', '400000');
INSERT INTO `droplist` VALUES ('45762', '40056', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45762', '40095', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45762', '40308', '4', '8', '300000');
INSERT INTO `droplist` VALUES ('45763', '31', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45763', '20147', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45763', '40029', '1', '3', '400000');
INSERT INTO `droplist` VALUES ('45763', '40056', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45763', '40095', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45763', '40098', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45763', '40173', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45763', '40308', '8', '24', '700000');
INSERT INTO `droplist` VALUES ('45763', '220122', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45763', '220125', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45763', '220147', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45764', '27', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45764', '40013', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45764', '40018', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45764', '40029', '1', '3', '400000');
INSERT INTO `droplist` VALUES ('45764', '40095', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45764', '40098', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45764', '40308', '12', '34', '700000');
INSERT INTO `droplist` VALUES ('45764', '40407', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45764', '41229', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45764', '200027', '1', '1', '20000');
INSERT INTO `droplist` VALUES ('45765', '172', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45765', '40013', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45765', '40018', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45765', '40029', '1', '3', '400000');
INSERT INTO `droplist` VALUES ('45765', '40095', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45765', '40098', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45765', '40308', '14', '30', '700000');
INSERT INTO `droplist` VALUES ('45765', '40407', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45765', '41236', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45766', '96', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45766', '40013', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45766', '40018', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45766', '40029', '1', '2', '400000');
INSERT INTO `droplist` VALUES ('45766', '40095', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45766', '40098', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45766', '40308', '15', '35', '700000');
INSERT INTO `droplist` VALUES ('45766', '40407', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45766', '41237', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45767', '40002', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45767', '40029', '1', '2', '400000');
INSERT INTO `droplist` VALUES ('45767', '40044', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45767', '40045', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45767', '40046', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45767', '40047', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45767', '40056', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45767', '40095', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45767', '40098', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45767', '40307', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45767', '40308', '4', '16', '300000');
INSERT INTO `droplist` VALUES ('45767', '40496', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45767', '41216', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45768', '40007', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45768', '40653', '1', '1', '1000000');
INSERT INTO `droplist` VALUES ('45769', '40613', '1', '1', '1000000');
INSERT INTO `droplist` VALUES ('45769', '220147', '1', '1', '30000');
delete from droplist where mobid = 45770;
INSERT INTO `droplist` VALUES ('45770', '128', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45770', '129', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45770', '131', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45770', '41084', '1', '1', '100000');
delete from droplist where mobid = 45771;
INSERT INTO `droplist` VALUES ('45771', '40514', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45771', '41070', '1', '1', '100000');
delete from droplist where mobid = 45772;
INSERT INTO `droplist` VALUES ('45772', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45772', '40074', '1', '1', '150000');
INSERT INTO `droplist` VALUES ('45772', '40087', '1', '1', '150000');
INSERT INTO `droplist` VALUES ('45772', '40305', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45772', '41081', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45772', '41082', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45772', '41084', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45772', '41085', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45772', '41242', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45772', '140074', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45772', '140087', '1', '1', '50000');
delete from droplist where mobid = 45773;
INSERT INTO `droplist` VALUES ('45773', '20281', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45773', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45773', '41070', '1', '1', '100000');
delete from droplist where mobid = 45774;
INSERT INTO `droplist` VALUES ('45774', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45774', '40017', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45774', '41067', '1', '1', '100000');
delete from droplist where mobid = 45775;
INSERT INTO `droplist` VALUES ('45775', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45775', '41066', '1', '1', '100000');
delete from droplist where mobid = 45776;
INSERT INTO `droplist` VALUES ('45776', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45776', '41069', '1', '1', '100000');
delete from droplist where mobid = 45777;
INSERT INTO `droplist` VALUES ('45777', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45777', '41068', '1', '1', '100000');
delete from droplist where mobid = 45778;
INSERT INTO `droplist` VALUES ('45778', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45778', '41073', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45778', '41074', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45778', '41075', '1', '1', '100000');
delete from droplist where mobid = 45779;
INSERT INTO `droplist` VALUES ('45779', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45779', '41074', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45779', '41075', '1', '1', '100000');
delete from droplist where mobid = 45780;
INSERT INTO `droplist` VALUES ('45780', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45780', '41071', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45780', '41074', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45780', '41075', '1', '1', '100000');
delete from droplist where mobid = 45781;
INSERT INTO `droplist` VALUES ('45781', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45781', '41072', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45781', '41074', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45781', '41075', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45782', '41080', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45783', '41080', '1', '1', '100000');
delete from droplist where mobid = 45784;
INSERT INTO `droplist` VALUES ('45784', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45784', '41080', '1', '1', '100000');
delete from droplist where mobid = 45785;
INSERT INTO `droplist` VALUES ('45785', '20300', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45785', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45785', '41076', '1', '1', '100000');
delete from droplist where mobid = 45786;
INSERT INTO `droplist` VALUES ('45786', '20304', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45786', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45786', '41078', '1', '1', '100000');
delete from droplist where mobid = 45787;
INSERT INTO `droplist` VALUES ('45787', '20302', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45787', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45787', '41079', '1', '1', '100000');
delete from droplist where mobid = 45788;
INSERT INTO `droplist` VALUES ('45788', '20285', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45788', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45788', '41077', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45789', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45789', '41081', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45789', '41242', '1', '1', '100000');
delete from droplist where mobid = 45790;
INSERT INTO `droplist` VALUES ('45790', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45790', '41084', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45790', '41242', '1', '1', '100000');
delete from droplist where mobid = 45791;
INSERT INTO `droplist` VALUES ('45791', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45791', '41083', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45791', '41242', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45792', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45792', '41082', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45792', '41242', '1', '1', '100000');
delete from droplist where mobid = 45793;
INSERT INTO `droplist` VALUES ('45793', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45793', '41085', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45793', '41242', '1', '1', '100000');
delete from droplist where mobid = 45794;
INSERT INTO `droplist` VALUES ('45794', '40017', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45794', '41086', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45794', '41087', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45794', '41088', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45794', '41089', '1', '1', '50000');
delete from droplist where mobid = 45795;
INSERT INTO `droplist` VALUES ('45795', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45795', '40017', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45795', '40074', '1', '1', '150000');
INSERT INTO `droplist` VALUES ('45795', '40087', '1', '1', '150000');
INSERT INTO `droplist` VALUES ('45795', '40202', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45795', '40205', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45795', '40242', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45795', '40248', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45795', '40250', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45795', '40251', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45795', '40252', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45795', '41086', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45795', '41087', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45795', '41088', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45795', '41089', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45795', '140074', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45795', '140087', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45795', '140089', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45796', '41103', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45797', '149', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45797', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45797', '40074', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45797', '41106', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45798', '41104', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45799', '41105', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45800', '41107', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45801', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45801', '40074', '1', '1', '150000');
INSERT INTO `droplist` VALUES ('45801', '40087', '1', '1', '150000');
INSERT INTO `droplist` VALUES ('45801', '40222', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45801', '41108', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45802', '148', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45802', '149', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45802', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45802', '40074', '1', '1', '150000');
INSERT INTO `droplist` VALUES ('45802', '40087', '1', '1', '150000');
INSERT INTO `droplist` VALUES ('45802', '40179', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45802', '40210', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45802', '41109', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45804', '140088', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45806', '40074', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45806', '40187', '1', '1', '2500');
INSERT INTO `droplist` VALUES ('45806', '140100', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45811', '40074', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45811', '40172', '1', '1', '2500');
INSERT INTO `droplist` VALUES ('45811', '40255', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45811', '140100', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45812', '40015', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45812', '40047', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45812', '40183', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45812', '40202', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45812', '40253', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45812', '40255', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45813', '40015', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45814', '20207', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45814', '40017', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45814', '40119', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45815', '40016', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45815', '40017', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45815', '40306', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45816', '40008', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45816', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45816', '40018', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45818', '40007', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45818', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45818', '40014', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45818', '40018', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45818', '40202', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45818', '140100', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45819', '40007', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45819', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45819', '40014', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45819', '40074', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45819', '40179', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45819', '40196', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45819', '40210', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45819', '40225', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45819', '140100', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45821', '40016', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45821', '40017', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45822', '40014', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45822', '40183', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45822', '40189', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45822', '140100', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45823', '40014', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45823', '40074', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45823', '40087', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45823', '40183', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45823', '40185', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45824', '40006', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45824', '40018', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45824', '40053', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45824', '40089', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45824', '40126', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45826', '40088', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45826', '40126', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45827', '20060', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45827', '20306', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45827', '40044', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45827', '40079', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45828', '129', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45828', '40015', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45828', '40079', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45828', '40089', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45828', '40126', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45828', '40181', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '9', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45829', '41', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45829', '52', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45829', '57', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45829', '64', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45829', '129', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45829', '131', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45829', '20006', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45829', '20056', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45829', '20154', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45829', '20187', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45829', '20284', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45829', '20288', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45829', '40006', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45829', '40008', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45829', '40014', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45829', '40015', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45829', '40018', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45829', '40048', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40052', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40074', '1', '1', '150000');
INSERT INTO `droplist` VALUES ('45829', '40087', '1', '1', '150000');
INSERT INTO `droplist` VALUES ('45829', '40089', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45829', '40093', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45829', '40094', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45829', '40164', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40166', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45829', '40180', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40182', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40184', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40187', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40189', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40191', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40197', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45829', '40210', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45829', '40213', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45829', '40224', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45829', '40246', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40253', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40254', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40255', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45829', '40267', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40277', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45829', '40524', '1', '1', '30000');
INSERT INTO `droplist` VALUES ('45829', '140087', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45831', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45831', '41244', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45831', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45831', '40987', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45832', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45832', '41244', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45832', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45832', '40987', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45833', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45833', '41244', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45833', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45833', '40987', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45834', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45834', '41244', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45834', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45834', '40987', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45835', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45835', '41244', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45835', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45835', '40988', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45836', '40013', '1', '1', '1000000');
INSERT INTO `droplist` VALUES ('45836', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45836', '40652', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45836', '40655', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45836', '40639', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45836', '40638', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45836', '40454', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45839', '41244', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45839', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45839', '40987', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45840', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45840', '41244', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45840', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45840', '40988', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45841', '40013', '1', '1', '1000000');
INSERT INTO `droplist` VALUES ('45841', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45841', '40652', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45841', '40655', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45841', '40639', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45841', '40638', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45841', '40454', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45841', '62', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45841', '20168', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45841', '20201', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45842', '41244', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45842', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45842', '40987', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45843', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45843', '41244', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45843', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45843', '40988', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45844', '40961', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45844', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45844', '40429', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45844', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45844', '40639', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45844', '40638', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45844', '163', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45844', '155', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45844', '20020', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45844', '20022', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45844', '20113', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45844', '20116', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45844', '20168', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45844', '20169', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45844', '20201', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45844', '20202', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45844', '20200', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45844', '20313', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45847', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45847', '40490', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45847', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45847', '40989', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45849', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45849', '41244', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45849', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45849', '40988', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45853', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45853', '40490', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45853', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45853', '40989', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45854', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45854', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45854', '40618', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45854', '40636', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45854', '40635', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45854', '40238', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45855', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45855', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45855', '40643', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45855', '40636', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45855', '40635', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45855', '40238', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45856', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45856', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45856', '40645', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45856', '40636', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45856', '40635', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45856', '40238', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45857', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45857', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45857', '40651', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45857', '40636', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45857', '40635', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45857', '40238', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45858', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45858', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45858', '40676', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45858', '40636', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45858', '40635', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45858', '40238', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45859', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45859', '40490', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45859', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45859', '40989', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45860', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45860', '40490', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45860', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45860', '40989', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45861', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45861', '41244', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45861', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45861', '40988', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45862', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45862', '41244', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45862', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45862', '40988', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45863', '40960', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45863', '40013', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45863', '40429', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('45863', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45863', '40636', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45863', '40635', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45863', '132', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45863', '117', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45863', '20129', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45863', '20106', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45863', '20109', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45863', '20030', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45863', '20176', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45863', '20208', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45863', '20313', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45863', '20252', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45863', '20253', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45863', '20279', '1', '1', '100');
INSERT INTO `droplist` VALUES ('45864', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45864', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45864', '41244', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45864', '40989', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45865', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45865', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45865', '41244', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45865', '40987', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45866', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45866', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45866', '41244', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45866', '40987', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45867', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45867', '41244', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45867', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45867', '40988', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45868', '40429', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45868', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('45868', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45868', '40703', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45868', '40668', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45868', '40667', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45868', '40640', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45868', '40642', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45868', '55', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45869', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45869', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45869', '41244', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45869', '40989', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45870', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45870', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45870', '41244', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45870', '40987', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45871', '41243', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45871', '40969', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45871', '41244', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45871', '40987', '1', '1', '1000');
INSERT INTO `droplist` VALUES ('45872', '40429', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('45872', '40675', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45872', '40668', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45872', '40667', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45872', '20030', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45872', '20067', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45872', '20208', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45872', '20313', '1', '1', '500');
INSERT INTO `droplist` VALUES ('45873', '40308', '3', '5', '200000');
INSERT INTO `droplist` VALUES ('45873', '41214', '1', '1', '1000000');
INSERT INTO `droplist` VALUES ('45874', '20423', '1', '1', '5000');
INSERT INTO `droplist` VALUES ('45876', '40308', '10', '20', '1000000');
INSERT INTO `droplist` VALUES ('45877', '20155', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('45877', '40010', '4', '4', '500000');
INSERT INTO `droplist` VALUES ('45877', '40100', '4', '4', '500000');
INSERT INTO `droplist` VALUES ('45877', '40126', '4', '4', '500000');
INSERT INTO `droplist` VALUES ('45878', '40620', '1', '1', '1000000');
INSERT INTO `droplist` VALUES ('45883', '40596', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45884', '40596', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45885', '40596', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45886', '40596', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45887', '40596', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45888', '40596', '1', '1', '200000');
INSERT INTO `droplist` VALUES ('45889', '40596', '1', '1', '200000');
delete from droplist where mobid = 81068;
delete from droplist where mobid between 81054 and 81065;
INSERT INTO `droplist` VALUES ('81163', '20281', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '20284', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '20288', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40164', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40165', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40166', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40178', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40197', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40202', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40204', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40205', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40206', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40208', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40209', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40210', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40213', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40215', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40216', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40219', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40222', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40223', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40224', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40225', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40227', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40230', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40237', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40238', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40244', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40246', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40248', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40249', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40253', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40255', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40261', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40264', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '40269', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '41149', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '41150', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '100041', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '100057', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '100084', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '100164', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '100189', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120244', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120245', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120246', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120247', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120248', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120249', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120280', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120304', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120309', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120310', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120311', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120312', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120316', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120317', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120319', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120320', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '120321', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '140006', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '140008', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '140015', '5', '15', '300000');
INSERT INTO `droplist` VALUES ('81163', '140074', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81163', '140087', '1', '1', '300000');
INSERT INTO `droplist` VALUES ('81173', '40013', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('81173', '40018', '1', '1', '50000');
INSERT INTO `droplist` VALUES ('81173', '40014', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('81173', '40016', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('81173', '40007', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('81173', '140100', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('81173', '40092', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40307', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40899', '1', '1', '100000');
INSERT INTO `droplist` VALUES ('81173', '40104', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40074', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40087', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40174', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40177', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40178', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40180', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40182', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40188', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40190', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40199', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40207', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40240', '1', '1', '10000');
INSERT INTO `droplist` VALUES ('81173', '40248', '1', '1', '10000');



-- update 31

INSERT INTO `droplist` VALUES ('45946', '148', '1', '1', '40000'); 
INSERT INTO `droplist` VALUES ('45946', '20013', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45946', '20231', '1', '1', '40000'); 
INSERT INTO `droplist` VALUES ('45946', '40020', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45946', '40047', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45946', '40248', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45946', '40250', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45946', '40308', '50', '80', '1000000'); 
INSERT INTO `droplist` VALUES ('45946', '41274', '1', '1', '45000'); 
INSERT INTO `droplist` VALUES ('45947', '148', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45947', '20115', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45947', '20231', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45947', '40049', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45947', '40248', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45947', '40308', '55', '85', '1000000'); 
INSERT INTO `droplist` VALUES ('45947', '41274', '1', '1', '45000'); 
INSERT INTO `droplist` VALUES ('45948', '20015', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45948', '20149', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45948', '40020', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45948', '40047', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45948', '40049', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45948', '40308', '60', '90', '1000000'); 
INSERT INTO `droplist` VALUES ('45948', '41274', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45949', '20013', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45949', '20149', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45949', '20231', '1', '1', '40000'); 
INSERT INTO `droplist` VALUES ('45949', '40020', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45949', '40051', '1', '1', '30000'); 
INSERT INTO `droplist` VALUES ('45949', '40248', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45949', '40251', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45949', '40304', '1', '1', '30000'); 
INSERT INTO `droplist` VALUES ('45949', '40308', '65', '100', '1000000'); 
INSERT INTO `droplist` VALUES ('45949', '41274', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45950', '64', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45950', '20013', '1', '1', '30000'); 
INSERT INTO `droplist` VALUES ('45950', '20115', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45950', '40051', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45950', '40250', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45950', '40251', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45950', '40308', '75', '110', '1000000'); 
INSERT INTO `droplist` VALUES ('45950', '41274', '1', '1', '55000'); 
INSERT INTO `droplist` VALUES ('45951', '52', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45951', '64', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45951', '20013', '1', '1', '10000'); 
INSERT INTO `droplist` VALUES ('45951', '20115', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45951', '20149', '1', '1', '40000'); 
INSERT INTO `droplist` VALUES ('45951', '20231', '1', '1', '45000'); 
INSERT INTO `droplist` VALUES ('45951', '40020', '1', '1', '65000'); 
INSERT INTO `droplist` VALUES ('45951', '40049', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45951', '40051', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45951', '40248', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45951', '40250', '1', '1', '20000'); 
INSERT INTO `droplist` VALUES ('45951', '40304', '1', '1', '50000'); 
INSERT INTO `droplist` VALUES ('45951', '40308', '85', '115', '1000000'); 
INSERT INTO `droplist` VALUES ('45951', '41274', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45952', '44', '1', '1', '40000'); 
INSERT INTO `droplist` VALUES ('45952', '179', '1', '1', '40000'); 
INSERT INTO `droplist` VALUES ('45952', '20231', '1', '1', '60000'); 
INSERT INTO `droplist` VALUES ('45952', '40248', '1', '1', '30000'); 
INSERT INTO `droplist` VALUES ('45952', '40304', '1', '1', '70000'); 
INSERT INTO `droplist` VALUES ('45952', '40308', '100', '135', '1000000'); 
INSERT INTO `droplist` VALUES ('45952', '41274', '1', '1', '70000'); 
