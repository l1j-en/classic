-- update 13

-- fix great spirit of water's name (was great spirit of fire)
update npc set name = 'Great Spirit of Water' where npcid = 45643;

-- change ring drop on water boss to water ring
update droplist set itemid = 20285 where itemid = 20304 and mobid = 45643;

-- fix great spirit of fire's name (was great spirit of water)
update npc set name = 'Great Spirit of Fire' where npcid = 45645;

-- change ring drop on fire boss to fire ring
update droplist set itemid = 20304 where itemid = 20285 and mobid = 45645;

-- fix NPC Consul's name
update npc set name = 'Consul' where npcid = 50112;

-- fix abyss lake scroll name_id
update etcitem set name_id = '$230 - Abyss Lake' where item_id = 40855;

-- fix stats on cursed diamond ring (was -1con -1wis, should be -10HP -10MP)
update armor set add_hp = -10, add_mp = -10, add_con = 0, add_wis = 0 where item_id = 20293;

-- reduce normal ranged attack mobskill usage on fangs
-- fang of earth firearrow(?)
update mobskill set trirnd = 45 where mobid = 45416 and actno = 2;
-- Fang of Wind windshuriken
update mobskill set trirnd = 45 where mobid = 45418 and actno = 2;
-- Fang of Glacier ConeOfCold
update mobskill set trirnd = 45 where mobid = 45419 and actno = 1;
-- Fang of Flame  Stalac (?)
update mobskill set trirnd = 45 where mobid = 45424 and actno = 1;

-- half spawnrate on abyss lake
update spawnlist set count = count / 2 where count > 1 and mapid = 430;

-- remove cg from di ice golem droplist
delete from droplist where itemid = 20175 and mobid = 45553;

-- increase cg droprate from normal ice golem
update droplist set chance = 1200 where itemid = 20175 and mobid = 45182;

-- fix regen and names on greater elf summons
-- Summoned Spirit of Earth
update npc set name = 'Summoned Spirit of Earth', hprinterval = 5000, hpr = 5 where npcid = 81053;
-- Summoned Spirit of Fire
update npc set name = 'Summoned Spirit of Fire', hprinterval = 5000, hpr = 5 where npcid = 81050;
-- Summoned Spirit of Water
update npc set name = 'Summoned Spirit of Water', hprinterval = 5000, hpr = 5 where npcid = 81051;
-- Summoned Spirit of Wind
update npc set name = 'Summoned Spirit of Wind', hprinterval = 5000, hpr = 5 where npcid = 81052;

-- increase czel, cdai, bzel, tqs drop on dv drake
update droplist set chance = 25000 where itemid = 240074 and mobid = 45529;
update droplist set chance = 12500 where itemid = 240087 and mobid = 45529;
update droplist set chance = 12500 where itemid = 140074 and mobid = 45529;
update droplist set chance = 20000 where itemid = 40054 and mobid = 45529;

-- reduce dv drake mobskill leverage (30 -> 25)
update mobskill set leverage = 25 where mobid = 45529 and actno = 0;

-- reduce fi de mobskill leverage (30 -> 15)
update mobskill set leverage = 15 where mobid = 45364 and actno = 0;

-- hp regen modifications for bosses
-- reduce hp regen on Greater Minotaur (200 -> 100)
update npc set hpr = 100 where npcid = 45584;
-- reduce hp regen on Phoenix (500 -> 250)
update npc set hpr = 250 where npcid = 45617;
-- reduce hp regen on Death Knight (416 -> 208)
update npc set hpr = 208 where npcid = 45601;
-- reduce hp regen on Ancient Giant (225 -> 150)
update npc set hpr = 150 where npcid = 45610;
-- reduce hp regen on Ifrit (100 -> 75)
update npc set hpr = 75 where npcid = 45516;
-- reduce hp regen on Caspa (200 -> 150)
update npc set hpr = 150 where npcid = 45488;
-- reduce hp regen on Sema (165 -> 125)
update npc set hpr = 125 where npcid = 45464;
-- reduce hp regen on Baltuzar (180 -> 145)
update npc set hpr = 145 where npcid = 45473;
-- reduce hp regen on Merkyor (250 -> 175)
update npc set hpr = 175 where npcid = 45497;
-- add hp regen on Elindaire (0 -> 50)
update npc set hpr = 50, hprinterval = 5000 where npcid = 81081;
-- reduce hp regen on Necromancer (160 -> 130)
update npc set hpr = 130 where npcid = 45456;
-- reduce giant ant queen hp regen rate (1000 -> 500)
update npc set hpr = 500 where npcid = 45614;
-- reduce Dark Elder hp regen rate (200 -> 180)
update npc set hpr = 180 where npcid = 45545;
-- reduce Demon hp regen rate (350 -> 280)
update npc set hpr = 280 where npcid = 45649;
-- reduce Knight Vlad hp regen rate (300 -> 350)
update npc set hpr = 280 where npcid = 45618;

-- add wooden jacket
insert into armor values(29001, 'Wooden Jacket', 'Wooden Jacket', 'armor', 'wood', 40000, 51, 9, 0, -1, 4, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- increase wis pot droprate on taurverus (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40016 and mobid = 45341;

-- increase res scroll droprate on taurverus (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40089 and mobid = 45341;

-- increase diamond droprate from dv drake (10000 -> 100000)
update droplist set chance = 100000 where itemid = 40044 and mobid = 45529;

-- increase sapphire droprate from dv drake (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40046 and mobid = 45529;

-- increase emerald droprate from dv drake (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40047 and mobid = 45529;

-- increase hqd droprate from dv drake (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40048 and mobid = 45529;

-- increase hqs droprate from dv drake (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40050 and mobid = 45529;

-- increase hqe droprate from dv drake (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40051 and mobid = 45529;

-- reduce claw of drake droprate from dv drake (50000 -> 5000)
update droplist set chance = 5000 where itemid = 40622 and mobid = 45529;

-- reduce Crystal Orb droprate (5000 -> 1000)
update droplist set chance = 1000 where itemid = 40617;

-- increase gloves droprate from necromancer (10000 -> 150000)
update droplist set chance = 150000 where itemid = 20182 and mobid = 45456;

-- increase buy price of b-scimitar (660 -> 1320)
update shop set purchasing_price = 1320 where item_id = 100027;

-- decrease buy price of c-scimitar (11000 -> 320)
update shop set purchasing_price = 320 where item_id = 200027;

-- remove duplicate shop buylist entries
delete from shop where item_id = 4 and order_id = 0 and selling_price = -1 and npc_id in (70018, 70021, 70030, 70045, 70063, 70074);
delete from shop where item_id = 20213 and order_id = 0 and selling_price = -1 and npc_id in (70014, 70045, 70074, 70079);
delete from shop where item_id = 40001 and order_id = 0 and selling_price = -1 and npc_id in (70045, 70074);
delete from shop where item_id = 40002 and order_id = 0 and selling_price = -1 and npc_id in (70014, 70045, 70074, 70079);
delete from shop where item_id = 40003 and order_id = 0 and selling_price = -1 and npc_id in (70014, 70045, 70074, 70079);
delete from shop where item_id = 40009 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40010 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40011 and order_id = 0 and selling_price = -1 and npc_id in (70074, 70079);
delete from shop where item_id = 40012 and order_id = 0 and selling_price = -1 and npc_id in (70074, 70079);
delete from shop where item_id = 40013 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40017 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40018 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40022 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40023 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40024 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40100 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40119 and order_id = 0 and selling_price = -1 and npc_id in (70074, 70079);
delete from shop where item_id = 40126 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40310 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40311 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40315 and order_id = 0 and selling_price = -1 and npc_id in (70074, 70079);
delete from shop where item_id = 40317 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40380 and order_id = 0 and selling_price = -1 and npc_id in (70014, 70018, 70021, 70030, 70045, 70063, 70074, 70079);

-- reduce mobskill leverage for normal de (18 -> 10)
update mobskill set leverage = 10 where mobid = 45265 and actno = 0;

-- fix maple buy price on shops 70079, 70014
update shop set purchasing_price = 1000 where item_id = 4008 and npc_id in (70079, 70014);

-- remove evolution fruit from shop buylist
delete from shop where item_id = 40070 and selling_price = -1;

-- remove ancient scroll from shop buylist
delete from shop where item_id = 40076 and selling_price = -1;

-- fix name for Scroll of Teleport: Lastabad 1f
update etcitem set name = 'Scroll of Teleport: Lastabad 1f' where item_id = 40852;

-- remove double spawn from mage lvl 30 quest area
update spawnlist set count = 1 where mapid = 201;

-- fix name for Dark Wing
update etcitem set name = 'Dark Wing' where item_id = 40720;

-- fix name for hiene scorpion
update npc set name = 'Scorpion' where npcid = 81077;

-- change name of Blessed Helmet to just Helmet
update armor set name = 'Helmet' where item_id = 120043;

-- modify existing spartoi drops
-- decrease scimitar droprate from spartoi (50000 -> 30000)
update droplist set chance = 30000 where itemid = 27 and mobid = 45161;

-- add additional drops to spartoi 
-- add sb:dex to spartoi droplist 
insert into droplist values (45161, 40171, 1, 1, 10000);
-- add sb:str to spartoi droplist 
insert into droplist values (45161, 40187, 1, 1, 8000);

-- modify existing harpy drops 
-- increase blue pot droprate from harpy (50000 -> 1500000)
update droplist set chance = 1500000 where itemid = 40015 and mobid = 45264;

-- remove ndai from harpy droplist
delete from droplist where itemid = 40087 and mobid = 45264;
-- remove b-splint mail from harpy droplist
delete from droplist where itemid = 120101 and mobid = 45264;
-- remove sb:g-haste from harpy droplist
delete from droplist where itemid = 40199 and mobid = 45264;

-- add additional drops to harpy 
-- add diamond to harpy droplist 
insert into droplist values (45264, 40044, 1, 1, 10000);

-- add additional drops scorpion 
-- add sb:ej to scorpion droplist 
insert into droplist values (45259, 40175, 1, 1, 5000);
-- add dsc:burning spirit to scorpion droplist 
insert into droplist values (45259, 40271, 1, 1, 5000);

-- modify existing skeleton guard drops
-- decrease b-glaive droprate from skeleton guard (50000 -> 15000)
update droplist set chance = 15000 where itemid = 100098 and mobid = 45269;
-- decrease sb:tame droprate from skeleton guard (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40181 and mobid = 45269;
-- decrease b-helmet droprate from skeleton guard (50000 -> 15000)
update droplist set chance = 15000 where itemid = 120043 and mobid = 45269;

-- add additional drops to skeleton guard
-- add glaive to skeleton guard droplist 
insert into droplist values (45269, 98, 1, 1, 5000);
-- add helmet to skeleton guard droplist 
insert into droplist values (45269, 20043, 1, 1, 5000);
-- add bcomr to skeleton guard droplist 
insert into droplist values (45269, 120056, 1, 1, 12000);
-- add large shield to skeleton guard droplist 
insert into droplist values (45269, 20242, 1, 1, 5000);

-- remove b-bow from skeleton marksman droplist
delete from droplist where itemid = 100172 and mobid = 45270;
-- remove sb:tame from skeleton marksman droplist
delete from droplist where itemid = 40181 and mobid = 45270;
-- remove dsc:shadow fang from skeleton marksman droplist
delete from droplist where itemid = 40277 and mobid = 45270;

-- add additional drops to skeleton marksman
-- add bow to skeleton marksman droplist 
insert into droplist values (45270, 172, 1, 1, 30000);
-- add dsc:venom resist to skeleton marksman droplist 
insert into droplist values (45270, 40273, 1, 1, 5000);
-- add helmet to skeleton marksman droplist 
insert into droplist values (45270, 20043, 1, 1, 5000);
-- add large shield to skeleton marksman droplist 
insert into droplist values (45270, 20242, 1, 1, 2500);
-- add bcomr to skeleton marksman droplist 
insert into droplist values (45270, 120056, 1, 1, 10000);

-- modify existing ogre drops
-- decrease battle axe droprate from ogre (150000 -> 120000)
update droplist set chance = 120000 where itemid = 143 and mobid = 45278;
-- increase nzel droprate from ogre (10000 -> 17500)
update droplist set chance = 17500 where itemid = 40074 and mobid = 45278;
-- increase ndai droprate from ogre (5000 -> 7500)
update droplist set chance = 7500 where itemid = 40087 and mobid = 45278;
-- increase brave pot droprate from ogre (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45278;

-- add additional drops to ogre 
-- add devil's blood to ogre droplist 
insert into droplist values (45278, 40031, 1, 1, 5000);

-- modify existing skeleton fighter drops
-- decrease bcomr droprate from skeleton fighter (50000 -> 25000)
update droplist set chance = 25000 where itemid = 120056 and mobid = 45286;
-- decrease b-large shield droprate from skeleton fighter (50000 -> 25000)
update droplist set chance = 25000 where itemid = 120242 and mobid = 45286;
-- decrease b-battle axe droprate from skeleton fighter (50000 -> 25000)
update droplist set chance = 25000 where itemid = 100143 and mobid = 45286;

-- add additional drops to skeleton fighter
-- add helmet to skeleton fighter droplist 
insert into droplist values (45286, 20043, 1, 1, 5000);
-- add b-helmet to skeleton fighter droplist 
insert into droplist values (45286, 120043, 1, 1, 5000);

-- modify existing cockatrice drops
-- increase nzel droprate from cockatrice (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40074 and mobid = 45361;
-- increase ndai droprate from cockatrice (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40087 and mobid = 45361;
-- increase brave pot droprate from cockatrice (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40014 and mobid = 45361;
-- decrease sc:entangle droprate from cockatrice (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40248 and mobid = 45361;
-- increase wis pot droprate from cockatrice (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40016 and mobid = 45361;

-- remove sb:meditate from cockatrice droplist
delete from droplist where itemid = 40177 and mobid = 45361;

-- add additional drops to cockatrice 
-- add sb:ej to cockatrice droplist 
insert into droplist values (45361, 40175, 1, 1, 5000);

-- modify existing dark elder drops
-- increase b-gloves droprate from dark elder (50000 -> 100000)
update droplist set chance = 100000 where itemid = 120182 and mobid = 45545;
-- increase sc:nb droprate from dark elder (2000 -> 8000)
update droplist set chance = 8000 where itemid = 40253 and mobid = 45545;

-- remove sb:f-blizz from dark elder droplist
delete from droplist where itemid = 40225 and mobid = 45545;

-- add additional drops to dark elder
-- add b-blue pot to dark elder droplist 
insert into droplist values (45545, 140015, 1, 1, 50000);
-- add sc:windcircle to dark elder droplist 
insert into droplist values (45545, 40264, 1, 1, 10000);
-- add sb:coc to dark elder droplist 
insert into droplist values (45545, 40183, 1, 1, 50000);
-- add wis pot to dark elder droplist 
insert into droplist values (45545, 40016, 1, 1, 300000);
-- add gloves to dark elder droplist 
insert into droplist values (45545, 20182, 1, 1, 100000);
-- add sc:b2s to dark elder droplist 
insert into droplist values (45545, 40238, 1, 1, 50000);
-- add n-prat to dark elder droplist 
insert into droplist values (45545, 40119, 1, 1, 300000);
-- add sb:tame to dark elder droplist 
insert into droplist values (45545, 40181, 1, 1, 10000);
-- add sb:c-l to dark elder droplist 
insert into droplist values (45545, 40179, 1, 1, 10000);
-- add sb:g-h to dark elder droplist 
insert into droplist values (45545, 40180, 1, 1, 10000);
-- add res scroll to dark elder droplist 
insert into droplist values (45545, 40096, 1, 1, 10000);
-- add poly scroll to dark elder droplist 
insert into droplist values (45545, 40089, 1, 1, 10000);
-- add maple wand to dark elder droplist 
insert into droplist values (45545, 40008, 1, 1, 10000);

-- undouble spawn count in hell
update spawnlist set count = count / 2 where mapid = 666;

-- reduce number of spawn traps in IT5 (3x50 -> 3x25)
update spawnlist_trap set count = 25 where mapid = 79;

-- undo bume/scorn/thor's nerf
update weapon_skill set fix_damage = fix_damage + 5 where weapon_id in (450000, 450001, 36);
update weapon_skill set probability = 16 where weapon_id = 36;

-- undouble spawn count in lvl30 prince quest area
update spawnlist set count = 1 where mapid = 217;

-- remove weaponequip on baranka morph (192 -> 0)
update polymorphs set weaponequip = 0 where id = 3664;

-- de-aggro sharks to sosc and coi
update npc set agrososc = 0, agrocoi = 0 where npcid = 45160;
-- de-aggro crabmen to sosc
update npc set agrososc = 0 where npcid = 45164;
-- de-aggro heine dungeon alligators to sosc
update npc set agrososc = 0 where npcid = 45307;
-- de-aggro aste to sosc
update npc set agrososc = 0 where npcid = 45195;

-- fix name of Leather Jacket in beginner table
update beginner set item_name = "Leather Jacket" where item_id = 20322;

-- fix name of Leather Jacket in character_items table
update beginner set item_name = "Leather Jacket" where item_id = 20322;

-- fix name for Crystal Ball of Necromancer (was Crystal Orb)
update etcitem set name = 'Crystal Ball of Necromancer' where item_id = 40617;

-- fix name for Scroll of Return - Pledge House (was Scroll of Return: Heine)
update etcitem set name = 'Scroll of Return - Pledge House' where item_id = 40124;

-- fix name for Fruit of Evolution (was Evolution Fruit)
update etcitem set name = 'Fruit of Evolution' where item_id = 40070;

-- fix name for Calling Flute (was nothing)
update etcitem set name = 'Calling Flute' where item_id = 41160;

-- fix name for Skeletal Pirate Soldier (was Skeleton Fighter)
update npc set name = 'Skeletal Pirate Soldier' where npcid = 45274;

-- fix skill name for WaterLife (was StormWalk)
update skills set name = 'WaterLife' where skill_id = 170;

-- fix name of Spirit Crystal(WaterLife) (was Spirit Crystal(NaturesBlessing))
update etcitem set name = 'Spirit Crystal(WaterLife)' where item_id = 40253;

-- fix name of Spirit Crystal(NaturesBlessing) (was Spirit Crystal(NaturesMiracle))
update etcitem set name = 'Spirit Crystal(NaturesBlessing)' where item_id = 40255;

-- remove mlc7f DK
delete from spawnlist where id = 41;

-- swap shop prices for b-pm and pm
update shop set purchasing_price = 18500 where item_id = 20154 and purchasing_price = 25900;
update shop set purchasing_price = 25900 where item_id = 120154 and purchasing_price = 18500;

-- modify existing troll drops
-- increase brave pot droprate from troll (50000 -> 1000000)
update droplist set chance = 100000 where itemid = 40014 and mobid = 45280;

-- remove adena from troll droplist
delete from droplist where itemid = 40308 and mobid = 45280;
-- remove c-splint mail from troll droplist
delete from droplist where itemid = 220115 and mobid = 45280;

-- modify existing arachnevil elder drops
-- decrease sb:fog of sleeping droprate from arachnevil elder (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40211 and mobid = 45184;
-- increase b-tele droprate from arachnevil elder (50000 -> 65000)
update droplist set chance = 65000 where itemid = 140100 and mobid = 45184;
-- decrease sb:tame droprate from arachnevil elder (50000 -> 10000)
update droplist set chance = 10000 where itemid = 40181 and mobid = 45184;
-- decrease sb:slow droprate from arachnevil elder (50000 -> 35000)
update droplist set chance = 35000 where itemid = 40174 and mobid = 45184;

-- add additional drops to arachnevil elder 
-- add sb:dex to arachnevil elder droplist 
insert into droplist values (45184, 40171, 1, 1, 30000);
-- add sb:v-t to arachnevil elder droplist 
insert into droplist values (45184, 40173, 1, 1, 30000);
-- add sb:e-j to arachnevil elder droplist 
insert into droplist values (45184, 40175, 1, 1, 10000);

-- modify existing ettin drops
-- increase brave pot droprate from ettin (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40014 and mobid = 45373;

-- remove sb:meditate from ettin
delete from droplist where itemid = 40177 and mobid = 45373;

-- add additional drops to ettin
-- add sc:entangle to ettin droplist 
insert into droplist values (45373, 40248, 1, 1, 5000);
-- add sb:e-j to ettin droplist 
insert into droplist values (45373, 40175, 1, 1, 10000);

-- modify existing succubus drops
-- decrease dark boots droprate from succubus (4000 -> 3500)
update droplist set chance = 3500 where itemid = 20210 and mobid = 45393;
-- increase blue pot droprate from succubus (25000 -> 150000)
update droplist set chance = 150000 where itemid = 40015 and mobid = 45393;
-- increase wis pot droprate from succubus (25000 -> 150000)
update droplist set chance = 150000 where itemid = 40016 and mobid = 45393;
-- increase lvl4 blank droprate from succubus (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40093 and mobid = 45393;
-- increase sb:coc droprate from succubus (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40183 and mobid = 45393;
-- increase sb:mana drain droprate from succubus (3000 -> 8000)
update droplist set chance = 8000 where itemid = 40184 and mobid = 45393;
-- increase sb:cz droprate from succubus (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40186 and mobid = 45393;
-- increase sb:freeze droprate from succubus (4000 -> 10000)
update droplist set chance = 10000 where itemid = 40195 and mobid = 45393;
-- increase sb:mass tele droprate from succubus (2500 -> 3000)
update droplist set chance = 3000 where itemid = 40214 and mobid = 45393;
-- increase sb:nt droprate from succubus (4000 -> 7000)
update droplist set chance = 7000 where itemid = 40254 and mobid = 45393;

-- add additional drops to succubus 
-- add dark robe to succubus droplist 
insert into droplist values (45393, 20132, 1, 1, 1000);
-- add devil's blood to succubus droplist 
insert into droplist values (45393, 40031, 1, 1, 3000);

-- modify existing succubus queen drops
-- decrease dark robe droprate from succubus queen (5000 -> 2500)
update droplist set chance = 3500 where itemid = 20132 and mobid = 45451;
-- increase blue pot droprate from succubus queen (25000 -> 150000)
update droplist set chance = 150000 where itemid = 40015 and mobid = 45451;
-- increase wis pot droprate from succubus queen (25000 -> 150000)
update droplist set chance = 150000 where itemid = 40016 and mobid = 45451;
-- increase lvl4 blank droprate from succubus queen (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40093 and mobid = 45451; 
-- increase sb:coc droprate from succubus queen (5000 -> 12000)
update droplist set chance = 12000 where itemid = 40183 and mobid = 45451;
-- increase sb:mana drain droprate from succubus queen (3000 -> 8000)
update droplist set chance = 8000 where itemid = 40184 and mobid = 45451;
-- increase sb:cz droprate from succubus queen (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40186 and mobid = 45451;
-- increase sb:summon droprate from succubus queen (2500 -> 3500)
update droplist set chance = 3500 where itemid = 40196 and mobid = 45451;
-- increase sb:l-s droprate from succubus queen (2500 -> 3000)
update droplist set chance = 3000 where itemid = 40210 and mobid = 45451;
-- increase sc:nb droprate from succubus queen (500 -> 2500)
update droplist set chance = 2500 where itemid = 40255 and mobid = 45451;

-- add additional drops to succubus queen
-- add devil's blood to succubus queen droplist 
insert into droplist values (45451, 40031, 1, 1, 5000);
-- add sc:r2n to succubus queen droplist 
insert into droplist values (45451, 40237, 1, 1, 2000);
-- add sc:exotic vitalize to succubus queen droplist 
insert into droplist values (45451, 40252, 1, 1, 2000);
-- add dsc:double break to succubus queen droplist 
insert into droplist values (45451, 40275, 1, 1, 3000);

-- modify existing toi succubus drops
-- decrease dark boots droprate from toi succubus (4000 -> 3000)
update droplist set chance = 3000 where itemid = 20210 and mobid = 45394;
-- increase blue pot droprate from toi succubus (25000 -> 150000)
update droplist set chance = 150000 where itemid = 40015 and mobid = 45394;
-- increase wis pot droprate from toi succubus (25000 -> 150000)
update droplist set chance = 150000 where itemid = 40016 and mobid = 45394;
-- increase lvl4 blank droprate from toi succubus (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40093 and mobid = 45394;
-- increase sb:coc droprate from toi succubus (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40183 and mobid = 45394;
-- increase sb:mana drain droprate from toi succubus (3000 -> 8000)
update droplist set chance = 8000 where itemid = 40184 and mobid = 45394;
-- increase sb:cz droprate from toi succubus (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40186 and mobid = 45394;
-- increase sb:freeze droprate from toi succubus (4000 -> 10000)
update droplist set chance = 10000 where itemid = 40195 and mobid = 45394;
-- increase sb:nt droprate from toi succubus (4000 -> 7000)
update droplist set chance = 7000 where itemid = 40254 and mobid = 45394;

-- add additional drops to toi succubus 
-- add dark robe to toi succubus droplist 
insert into droplist values (45394, 20132, 1, 1, 1000);
-- add devil's blood to toi succubus droplist 
insert into droplist values (45394, 40031, 1, 1, 2500);

-- reduce phoenix ranged skill dmg value 25% (100 -> 75)
update skills set damage_value = 75 where skill_id = 10018;

-- correct name of c-orcish bow (was Bow)
update weapon set name = 'Orcish Bow' where item_id = 200171;

-- increase red pot droprate from goblin (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40010 and mobid = 45008;

-- modify existing orc drops
-- increase rough mith droprate from orc (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40496 and mobid = 45009;
-- increase poly scroll droprate from orc (1000 -> 2000)
update droplist set chance = 2000 where itemid = 40088 and mobid = 45009;

-- remove maple wand from orc droplist
delete from droplist where itemid = 40008 and mobid = 45009;

-- add additional drops to orc 
-- add pine wand to orc droplist 
insert into droplist values (45009, 40006, 1, 1, 1000);
-- add pure mith to orc droplist 
insert into droplist values (45009, 40494, 1, 1, 50000);
-- add meat to orc droplist
insert into droplist values (45009, 40056, 1, 1, 25000);

-- increase red pot droprate from kobold (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40010 and mobid = 45016;

-- modify existing orc archer drops
-- increase red pot droprate from orc archer (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40010 and mobid = 45019;
-- decrease c-orcish ring mail droprate from orc archer (50000 -> 25000)
update droplist set chance = 25000 where itemid = 220135 and mobid = 45019;
-- increase cure pot droprate from orc archer (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40017 and mobid = 45019;

-- add additional drops to orc archer
-- add fur to orc archer droplist 
insert into droplist values (45019, 40405, 1, 1, 20000);
-- add sc:wind shot to orc archer droplist 
insert into droplist values (45019, 40260, 1, 1, 1000);
-- add sc:teleport to mother to orc archer droplist 
insert into droplist values (45019, 40234, 1, 1, 5000);
-- add sc:triple arrow to orc archer droplist 
insert into droplist values (45019, 40240, 1, 1, 1000);

-- add lvl1 blank to dwarf droplist 
insert into droplist values (45041, 40090, 1, 1, 5000);

-- modify existing gnoll drops
-- increase diamond droprate from gnoll (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40044 and mobid = 45079;
-- increase rough mith droprate from gnoll (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40496 and mobid = 45079;
-- increase emerald droprate from gnoll (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40047 and mobid = 45079;

-- modify existing orc fighter drops
-- decrease orcish ring mail droprate from orc fighter (50000 -> 25000)
update droplist set chance = 25000 where itemid = 20135 and mobid = 45082;

-- add additional drops to orc fighter
-- add lantern to orc fighter droplist 
insert into droplist values (45082, 40002, 1, 1, 2500);
-- add orcish short sword to orc fighter droplist 
insert into droplist values (45082, 21, 1, 1, 15000);
-- add orcish dagger to orc fighter droplist 
insert into droplist values (45082, 1, 1, 1, 25000);
-- add dsc:blind hiding to orc fighter droplist 
insert into droplist values (45082, 40265, 1, 1, 5000);

-- remove c-scimitar from skeleton droplist
delete from droplist where itemid = 200027 and mobid = 45107;

-- add additional drops to skeleton
-- add b-scimitar to skeleton droplist 
insert into droplist values (45107, 100027, 1, 1, 25000);
-- add dsc:enchant venom to skeleton droplist 
insert into droplist values (45107, 40266, 1, 1, 1000);
-- add sb:tame to skeleton droplist 
insert into droplist values (45107, 40181, 1, 1, 500);

-- modify existing orc wizard drops
-- increase blue pot droprate from orc wizard (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45121;

-- add additional drops to orc wizard
-- add sb:a-b to orc wizard droplist (insanely rare)
insert into droplist values (45121, 40223, 1, 1, 10);

-- remove battle axe from stone golem droplist
delete from droplist where itemid = 143 and mobid = 45126;

-- add additional drops to stone golem
-- add mace to stone golem droplist 
insert into droplist values (45126, 140, 1, 1, 10000);
-- add morning star to stone golem droplist 
insert into droplist values (45126, 146, 1, 1, 5000);
-- add broad sword to stone golem droplist 
insert into droplist values (45126, 23, 1, 1, 25000);

-- modify existing arachnevil drops
-- decrease sb:fog of sleeping droprate from arachnevil (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40211 and mobid = 45136;

-- remove dsc:shadow armor from lizardman droplist
delete from droplist where itemid = 40267 and mobid = 45144;

-- add dsc:dark blind to lizardman droplist 
insert into droplist values (45144, 40272, 1, 1, 5000);

-- modify existing troglodyte drops
-- increase splint mail droprate from troglodyte (500 -> 20000)
update droplist set chance = 20000 where itemid = 20115 and mobid = 45155;
-- increase sb:coc droprate from troglodyte (500 -> 8000)
update droplist set chance = 8000 where itemid = 40183 and mobid = 45155;
-- increase sb:mana drain droprate from troglodyte (500 -> 2500)
update droplist set chance = 2500 where itemid = 40184 and mobid = 45155;
-- increase relic of eva droprate from troglodyte (500 -> 10500)
update droplist set chance = 10500 where itemid = 40306 and mobid = 45155;
-- increase sc:resist elemental droprate from troglodyte (500 -> 9000)
update droplist set chance = 9000 where itemid = 40236 and mobid = 45155;
-- increase btele droprate from troglodyte (500 -> 50000)
update droplist set chance = 50000 where itemid = 140100 and mobid = 45155;
-- increase battle axe droprate from troglodyte (500 -> 15000)
update droplist set chance = 15000 where itemid = 143 and mobid = 45155;
-- increase g-axe droprate from troglodyte (500 -> 10000)
update droplist set chance = 10000 where itemid = 148 and mobid = 45155;

-- add additional drops to troglodyte 
-- add sc:resist magic to troglodyte droplist 
insert into droplist values (45155, 40232, 1, 1, 9000);
-- add sb:fb to troglodyte droplist 
insert into droplist values (45155, 40170, 1, 1, 10000);
-- add sb:wb to troglodyte droplist 
insert into droplist values (45155, 40172, 1, 1, 10000);
-- add sb:tame to troglodyte droplist 
insert into droplist values (45155, 40181, 1, 1, 2500);
-- add sb:a-b to troglodyte droplist (insanely rare)
insert into droplist values (45155, 40223, 1, 1, 10);

-- modify existing merman drops
-- increase sc:nb droprate from merman (500 -> 1000)
update droplist set chance = 1000 where itemid = 40255 and mobid = 45159;
-- increase relic of eva droprate from merman (500 -> 10500)
update droplist set chance = 10500 where itemid = 40306 and mobid = 45159;

-- modify existing giran troglodyte drops
-- increase splint mail droprate from giran troglodyte (500 -> 20000)
update droplist set chance = 20000 where itemid = 20115 and mobid = 45170;
-- increase sb:coc droprate from giran troglodyte (500 -> 8000)
update droplist set chance = 8000 where itemid = 40183 and mobid = 45170;
-- increase sb:mana drain droprate from giran troglodyte (500 -> 2500)
update droplist set chance = 2500 where itemid = 40184 and mobid = 45170;
-- increase relic of eva droprate from giran troglodyte (500 -> 10500)
update droplist set chance = 10500 where itemid = 40306 and mobid = 45170;
-- increase sc:resist elemental droprate from giran troglodyte (500 -> 9000)
update droplist set chance = 9000 where itemid = 40236 and mobid = 45170;
-- increase btele droprate from giran troglodyte (500 -> 50000)
update droplist set chance = 50000 where itemid = 140100 and mobid = 45170;
-- increase battle axe droprate from giran troglodyte (500 -> 15000)
update droplist set chance = 15000 where itemid = 143 and mobid = 45170;
-- increase g-axe droprate from giran troglodyte (500 -> 10000)
update droplist set chance = 10000 where itemid = 148 and mobid = 45170;

-- add additional drops to giran troglodyte 
-- add sc:resist magic to giran troglodyte droplist 
insert into droplist values (45170, 40232, 1, 1, 9000);
-- add sb:fb to giran troglodyte droplist 
insert into droplist values (45170, 40170, 1, 1, 10000);
-- add sb:wb to giran troglodyte droplist 
insert into droplist values (45170, 40172, 1, 1, 10000);
-- add sb:tame to giran troglodyte droplist 
insert into droplist values (45170, 40181, 1, 1, 2500);
-- add sb:a-b to giran troglodyte droplist (insanely rare)
insert into droplist values (45170, 40223, 1, 1, 10);

-- modify existing black knight drops
-- increase cop droprate from black knight (5000 -> 7500)
update droplist set chance = 7500 where itemid = 20063 and mobid = 45165;
-- increase ts droprate from black knight (5000 -> 7500)
update droplist set chance = 7500 where itemid = 20085 and mobid = 45165;
-- increase diamond droprate from black knight (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40044 and mobid = 45165;

-- add additional drops to black knight
-- add helmet to black knight droplist 
insert into droplist values (45165, 20043, 1, 1, 10000);
-- add sb:dex to black knight droplist 
insert into droplist values (45165, 40171, 1, 1, 10000);
-- add large shield to black knight droplist 
insert into droplist values (45165, 20242, 1, 1, 10000);
-- add katana to black knight droplist 
insert into droplist values (45165, 41, 1, 1, 1500);
-- add devil's blood to black knight droplist 
insert into droplist values (45165, 40031, 1, 1, 2500);

-- modify existing turtle dragon drops
-- increase brave pot droprate from turtle dragon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45240;
-- increase sc:water life droprate from turtle dragon (2000 -> 10000)
update droplist set chance = 10000 where itemid = 40253 and mobid = 45240;

-- add additional drops turtle dragon
-- add sb:c-l to turtle dragon droplist 
insert into droplist values (45240, 40179, 1, 1, 10000);
