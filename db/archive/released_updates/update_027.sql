
-- update 27

-- corrent name of Amulet of Constitution
update armor set name = 'Amulet of Constitution' where item_id = 20268;

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

-- correct name of Black Lump of Rough Mithral
update etcitem set name = 'Black Lump of Rough Mithral' where item_id = 40444;

-- increase a-g's aoe range to prevent cliffing (-10 -> -11)
update mobskill set trirange = -11 where mobid = 45610 and actno = 0;

-- increase bone dragon mobskill leverage (3 -> 4)
update mobskill set leverage = 4 where mobid = 45522 and actno = 0;


-- Fix name of NPC
update npc set name = "Trembling Person" where npcid = 80049;

-- slightly increase regen on some bosses
-- reduce hp regen on Death Knight (208 -> 310)
update npc set hpr = 310 where npcid = 45601;
-- reduce hp regen on Ancient Giant (150 -> 175)
update npc set hpr = 175 where npcid = 45610;
-- reduce hp regen on Ifrit (75 -> 80)
update npc set hpr = 80 where npcid = 45516;
-- reduce hp regen on Caspa (150 -> 160)
update npc set hpr = 160 where npcid = 45488;
-- reduce hp regen on Baltuzar (145 -> 155)
update npc set hpr = 155 where npcid = 45473;
-- reduce hp regen on Merkyor (175 -> 180)
update npc set hpr = 180 where npcid = 45497;
-- add hp regen on Elindaire (50 -> 55)
update npc set hpr = 55, hprinterval = 5000 where npcid = 81081;
-- reduce hp regen on Necromancer (130 -> 145)
update npc set hpr = 145 where npcid = 45456;
-- reduce Demon hp regen rate (280 -> 285)
update npc set hpr = 285 where npcid = 45649;

-- add hpr to bosses missing it (Sea Dancer, Crocodile)
update npc set hpr = 5, hprinterval = 5000 where npcid in (45228, 45338);


-- added pago to npcaction 
update npcaction set normal_action = "pago" where npcid = 70005;
update npcaction set caotic_action = "pago" where npcid = 70005;

-- fixed illdrath in npcaction
update npcaction set normal_action = "illdrath" where npcid = 50003;
update npcaction set caotic_action = "illdrath" where npcid = 50003;
update npcaction set teleport_url = "illdrath1" where npcid = 50003;


-- undo the pair spawns of mobs where there exists unused 0 count spawnpoints
-- spread out DV cockatrice spawn
update spawnlist set count = 1 where npc_templateid = 45361 and mapid = 4;
-- spread out Basilisk spawn
update spawnlist set count = 1 where npc_templateid = 45381 and mapid = 4;
-- spread out Cyclops spawn
update spawnlist set count = 1 where npc_templateid = 45420 and mapid = 4;
-- spread out Alligator spawn
update spawnlist set count = 1 where npc_templateid = 45101 and mapid = 4;
-- spread out Iron Golem spawn
update spawnlist set count = 1 where npc_templateid = 45372 and mapid = 4;
-- spread out Lava Golem spawn
update spawnlist set count = 1 where npc_templateid = 45365 and mapid = 4;
-- spread out Astagio spawn
update spawnlist set count = 1 where npc_templateid = 45359 and mapid = 4;
-- spread out Giant spawn
update spawnlist set count = 1 where npc_templateid in (45351, 45337, 45295) and mapid = 4;
-- spread out Beholder spawn
update spawnlist set count = 1 where npc_templateid = 45349 and mapid = 4;
-- spread out Taurverus spawn
update spawnlist set count = 1 where npc_templateid = 45341 and mapid = 4;
-- spread out Bandit spawn
update spawnlist set count = 1 where npc_templateid in (45324, 45329, 81080) and mapid = 4;
-- spread out Griffon spawn
update spawnlist set count = 1 where npc_templateid = 45321 and mapid = 4;
-- spread out Yeti spawn
update spawnlist set count = 1 where npc_templateid = 45294 and mapid = 4;
-- spread out Fire Archer spawn
update spawnlist set count = 1 where npc_templateid = 45291 and mapid = 4;
-- spread out Fire Warrior spawn
update spawnlist set count = 1 where npc_templateid = 45284 and mapid = 4;
-- spread out Right-Hand Bandit spawn
update spawnlist set count = 1 where npc_templateid in (45276, 45194) and mapid = 4;
-- spread out Snow Tiger spawn
update spawnlist set count = 1 where npc_templateid = 45267 and mapid = 4;
-- spread out Dark Elf spawn
update spawnlist set count = 1 where npc_templateid = 45265 and mapid = 4;
-- spread out Bomb Flower spawn
update spawnlist set count = 1 where npc_templateid = 45263 and mapid = 4;
-- spread out Dragonfly spawn
update spawnlist set count = 1 where npc_templateid = 45257 and mapid = 4;
-- spread out Undead Elmore General spawn
update spawnlist set count = 1 where npc_templateid = 45248 and mapid = 4;
-- spread out Harpy spawn
update spawnlist set count = 1 where npc_templateid = 45264 and mapid = 4;
-- spread out Turtle Dragon spawn
update spawnlist set count = 1 where npc_templateid = 45262 and mapid = 4;
-- spread out Undead Elmore Wizard spawn
update spawnlist set count = 1 where npc_templateid = 45224 and mapid = 4;
-- spread out Bugbear spawn
update spawnlist set count = 1 where npc_templateid = 45223 and mapid = 4;
-- spread out Ramia spawn
update spawnlist set count = 1 where npc_templateid = 45222 and mapid = 4;
-- spread out Undead Elmore Soldier spawn
update spawnlist set count = 1 where npc_templateid = 45216 and mapid = 4;
-- spread out Elder spawn
update spawnlist set count = 1 where npc_templateid = 45215 and mapid = 4;
-- spread out Ghast spawn
update spawnlist set count = 1 where npc_templateid = 45213 and mapid = 4;
-- spread out Ice Man spawn
update spawnlist set count = 1 where npc_templateid = 45207 and mapid = 4;
-- spread out Fire Egg spawn
update spawnlist set count = 1 where npc_templateid = 45206 and mapid = 4;
-- spread out Salamander spawn
update spawnlist set count = 1 where npc_templateid = 45203 and mapid = 4;
-- spread out Giant Soldier Ant spawn (just the count 0 ones)
update spawnlist set count = 1 where npc_templateid = 45190 and mapid = 4 and count = 0;
-- spread out Doppelganger spawn
update spawnlist set count = 1 where npc_templateid = 45189 and mapid = 4;
-- spread out Arachnevil Elder spawn
update spawnlist set count = 1 where npc_templateid = 45184 and mapid = 4;
-- spread out Lycanthrope spawn
update spawnlist set count = 1 where npc_templateid = 45173 and mapid = 4;
-- spread out tribal orcs spawn (just the count 0 ones)
update spawnlist set count = 1 where npc_templateid in (45098, 45127, 45143, 45149, 45171) and mapid = 4 and count = 0;
-- spread out Spartoi spawn
update spawnlist set count = 1 where npc_templateid = 45161 and mapid = 4;
-- spread out Ghoul spawn
update spawnlist set count = 1 where npc_templateid = 45157 and mapid = 4;
-- spread out Owlbear spawn
update spawnlist set count = 1 where npc_templateid = 45147 and mapid = 4;
-- spread out Lizardman spawn
update spawnlist set count = 1 where npc_templateid = 45144 and mapid = 4;
-- spread out Hobgoblin spawn
update spawnlist set count = 1 where npc_templateid = 45140 and mapid = 4;
-- spread out Arachnevil spawn
update spawnlist set count = 1 where npc_templateid = 45136 and mapid = 4;
-- spread out Snowman spawn
update spawnlist set count = 1 where npc_templateid = 45133 and mapid = 4;
-- spread out Stone Golem spawn
update spawnlist set count = 1 where npc_templateid = 45126 and mapid = 4;
-- spread out Skeleton Archer spawn
update spawnlist set count = 1 where npc_templateid = 45122 and mapid = 4;
-- spread out Giant Ant spawn (just the count 0 ones)
update spawnlist set count = 1 where npc_templateid = 45115 and mapid = 4 and count = 0;
-- spread out Skeleton spawn
update spawnlist set count = 1 where npc_templateid = 45107 and mapid = 4;
-- spread out Dwarf Warrior spawn
update spawnlist set count = 1 where npc_templateid = 45092 and mapid = 4;
-- spread out Orc Fighter spawn
update spawnlist set count = 1 where npc_templateid = 45082 and mapid = 4;
-- spread out Gnoll spawn
update spawnlist set count = 1 where npc_templateid = 45079 and mapid = 4;
-- spread out Floating Eye spawn
update spawnlist set count = 1 where npc_templateid = 45068 and mapid = 4;
-- spread out Zombie spawn
update spawnlist set count = 1 where npc_templateid = 45065 and mapid = 4;
-- spread out Slime spawn
update spawnlist set count = 1 where npc_templateid = 45060 and mapid = 4;
-- spread out Husky spawn
update spawnlist set count = 1 where npc_templateid = 45053 and mapid = 4;
-- spread out Fox spawn
update spawnlist set count = 1 where npc_templateid = 45048 and mapid = 4;
-- spread out Saint Bernard spawn
update spawnlist set count = 1 where npc_templateid = 45047 and mapid = 4;
-- spread out Beagle spawn
update spawnlist set count = 1 where npc_templateid = 45046 and mapid = 4;
-- spread out Wolf spawn
update spawnlist set count = 1 where npc_templateid = 45043 and mapid = 4;
-- spread out Doberman spawn
update spawnlist set count = 1 where npc_templateid = 45042 and mapid = 4;
-- spread out Dwarf spawn
update spawnlist set count = 1 where npc_templateid = 45041 and mapid = 4;
-- spread out Bear spawn
update spawnlist set count = 1 where npc_templateid = 45040 and mapid = 4;
-- spread out Shepherd spawn
update spawnlist set count = 1 where npc_templateid = 45034 and mapid = 4;
-- spread out Imp spawn
update spawnlist set count = 1 where npc_templateid = 45033 and mapid = 4;
-- spread out Werewolf spawn
update spawnlist set count = 1 where npc_templateid = 45024 and mapid = 4;
-- spread out Wild Boar spawn
update spawnlist set count = 1 where npc_templateid = 45023 and mapid = 4;
-- spread out Deer spawn
update spawnlist set count = 1 where npc_templateid = 45021 and mapid = 4;
-- spread out Orc Archer spawn
update spawnlist set count = 1 where npc_templateid = 45019 and mapid = 4;
-- spread out Kobold spawn
update spawnlist set count = 1 where npc_templateid = 45016 and mapid = 4;
-- spread out Duck spawn
update spawnlist set count = 1 where npc_templateid = 45015 and mapid = 4;
-- spread out Rabbit spawn
update spawnlist set count = 1 where npc_templateid in (45012, 45010) and mapid = 4;
-- spread out Orc spawn
update spawnlist set count = 1 where npc_templateid = 45009 and mapid = 4;
-- spread out Goblin spawn
update spawnlist set count = 1 where npc_templateid = 45008 and mapid = 4;
-- spread out Frog spawn
update spawnlist set count = 1 where npc_templateid = 45005 and mapid = 4;

-- undouble wicked yeti spawn
update spawnlist set count = 1 where npc_templateid = 81043 and mapid = 4;
-- undouble Corrupt Guard spawn
update spawnlist set count = 1 where npc_templateid = 45292 and mapid = 4;
-- undouble Birds spawn
update spawnlist set count = 1 where npc_templateid = 81159;
