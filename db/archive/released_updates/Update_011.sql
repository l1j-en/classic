-- update 11

-- correct name of Scroll of Curse Removal
update etcitem set name = 'Scroll of Curse Removal' where item_id = 40119;

-- increase nzel droprate (10000 -> 40000), increase ndai droprate (10000 -> 20000) from unicorn
update droplist set chance = 40000 where itemid = 40074 and mobid = 45640;
update droplist set chance = 20000 where itemid = 40087 and mobid = 45640;

-- increase bzel droprate (10000 -> 12000), decrease bdai droprate (10000 -> 9000) from unicorn
update droplist set chance = 12000 where itemid = 140074 and mobid = 45640;
update droplist set chance = 9000 where itemid = 140087 and mobid = 45640;

-- decrease cmomr droprate from unicorn (300000 -> 150000)
update droplist set chance = 15000 where itemid = 20110 and mobid = 45640;

-- increase dark cloak droprate from unicorn (5000 -> 7500)
update droplist set chance = 7500 where itemid = 20070 and mobid = 45640;

-- fix succubus drops
-- Potion of Mana Recovery
update droplist set chance = 25000 where itemid = 40015 and mobid = 45393;
-- Potion of Wisdom
update droplist set chance = 25000 where itemid = 40016 and mobid = 45393;
-- Blank Scroll (Level 4)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45393;
-- Spellbook(ConeOfCold) 
update droplist set chance = 5000 where itemid = 40183 and mobid = 45393;
-- Spellbook(ManaDrain) 
update droplist set chance = 3000 where itemid = 40184 and mobid = 45393;
-- Spellbook(CreateZombie)
update droplist set chance = 5000 where itemid = 40186 and mobid = 45393;
-- Spellbook(IceLance)
update droplist set chance = 4000 where itemid = 40195 and mobid = 45393;
-- Spellbook(Summon)
update droplist set chance = 2500 where itemid = 40196 and mobid = 45393;
-- Spellbook(Blizzard)
update droplist set chance = 3000 where itemid = 40204 and mobid = 45393;
-- Spellbook(MassTeleport) 
update droplist set chance = 2500 where itemid = 40214 and mobid = 45393;
-- Spirit Crystal(ReturnToNature)
update droplist set chance = 4000 where itemid = 40237 and mobid = 45393;
-- Spirit Crystal(TripleShot)
update droplist set chance = 5000 where itemid = 40240 and mobid = 45393;
-- Spirit Crystal(NaturesTouch)
update droplist set chance = 4000 where itemid = 40254 and mobid = 45393;
-- Dark Spirit Crystal(DoubleBreak)
update droplist set chance = 4000 where itemid = 40275 and mobid = 45393;
-- Dark Spirit Crystal(ShadowFang) 
update droplist set chance = 4000 where itemid = 40277 and mobid = 45393;
-- Adena
update droplist set chance = 1000000 where itemid = 40308 and mobid = 45393;

-- fix TOI succubus drops
-- Blank Scroll (Level 4)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45394;
-- TOI: 21f  
update droplist set chance = 10500 where itemid = 40105 and mobid = 45394;
-- Spellbook(ConeOfCold)  
update droplist set chance = 5000 where itemid = 40183 and mobid = 45394;
-- Spellbook(CreateZombie) 
update droplist set chance = 5000 where itemid = 40186 and mobid = 45394;
-- Spellbook(IceLance) 
update droplist set chance = 4000 where itemid = 40195 and mobid = 45394;
-- Spellbook(Summon) 
update droplist set chance = 2400 where itemid = 40196 and mobid = 45394;
-- Spellbook(Blizzard) 
update droplist set chance = 2900 where itemid = 40204 and mobid = 45394;
-- Spirit Crystal(ReturnToNature) 
update droplist set chance = 4000 where itemid = 40237 and mobid = 45394;
-- Spirit Crystal(NaturesTouch)
update droplist set chance = 4000 where itemid = 40254 and mobid = 45394;
-- Dark Spirit Crystal(DoubleBreak)
update droplist set chance = 4000 where itemid = 40275 and mobid = 45394;
-- Dark Spirit Crystal(ShadowFang)
update droplist set chance = 4000 where itemid = 40277 and mobid = 45394;
-- Adena
update droplist set chance = 1000000 where itemid = 40308 and mobid = 45394;

-- add blue and wis pot to TOI succubus
insert into droplist values (45394, 40015, 1, 1, 25000);
insert into droplist values (45394, 40016, 1, 1, 25000);

-- fix elekkadom drops
-- Ebony Wand 
update droplist set chance = 10000 where itemid = 40007 and mobid = 45279;
-- Potion of Bravery 
update droplist set chance = 25000 where itemid = 40014 and mobid = 45279;
-- Potion of Mana Recovery
update droplist set chance = 25000 where itemid = 40015 and mobid = 45279;
-- Scroll of Enchant: Armor 
update droplist set chance = 11000 where itemid = 40074 and mobid = 45279;
-- Spellbook(CallLightning)
update droplist set chance = 5000 where itemid = 40179 and mobid = 45279;
-- Spellbook(ConeOfCold) 
update droplist set chance = 5000 where itemid = 40183 and mobid = 45279;
-- Spellbook(Summon) 
update droplist set chance = 2500 where itemid = 40196 and mobid = 45279;
-- Spellbook(Blizzard)
update droplist set chance = 3000 where itemid = 40204 and mobid = 45279;
-- Spellbook(LightningStorm)
update droplist set chance = 2500 where itemid = 40210 and mobid = 45279;
-- Spellbook(FreezingBlizzard)
update droplist set chance = 2500 where itemid = 40225 and mobid = 45279;
-- Spirit Crystal(NaturesTouch)
update droplist set chance = 5000 where itemid = 40254 and mobid = 45279;
-- Relic of Eva 
update droplist set chance = 10500 where itemid = 40306 and mobid = 45279;
-- Adena
update droplist set chance = 1000000 where itemid = 40308 and mobid = 45279;
-- Scroll of Teleportation 
update droplist set chance = 25000 where itemid = 140100 and mobid = 45279;

-- fix dark boot droprates
-- dark elf (10000 -> 5000)
update droplist set chance = 5000 where itemid = 20210 and mobid = 45265;
-- succubus (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20210 and mobid = 45393;
-- TOI succubus (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20210 and mobid = 45394;

-- decrease spellbook droprates from tribal orcs
-- Tribal Orc Spellbook - Gandi
update droplist set chance = 200000 where itemid = 40609 and mobid = 45098;
-- Tribal Orc Spellbook - Neruga
update droplist set chance = 200000 where itemid = 40610 and mobid = 45171;
-- Tribal Orc Spellbook - Duda-Mara
update droplist set chance = 200000 where itemid = 40611 and mobid = 45143;
-- Tribal Orc Spellbook - Atuba
update droplist set chance = 200000 where itemid = 40612 and mobid = 45149;

-- add additional gandi orc drops
-- add ruby to gandi orc droplist
insert into droplist values (45098, 40045, 1, 1, 5000);
-- add egg to gandi orc droplist
insert into droplist values (45098, 40059, 1, 1, 25000);
-- add gradius to gandi orc droplist
insert into droplist values (45098, 32, 1, 1, 2000);
-- add cmomr to gandi orc droplist
insert into droplist values (45098, 20110, 1, 1, 1000);
-- add haste pot to gandi orc droplist
insert into droplist values (45098, 40013, 1, 1, 15000);
-- add plate mail to gandi orc droplist
insert into droplist values (45098, 20154, 1, 1, 200);

-- modify existing rova orc drops
-- decrease homr droprate from rova orc (10000 -> 5000)
update droplist set chance = 5000 where itemid = 20011 and mobid = 45127;
-- decrease comr droprate from rova orc (10000 -> 5000)
update droplist set chance = 5000 where itemid = 20056 and mobid = 45127;
-- decrease cmomr droprate from rova orc (10000 -> 2500)
update droplist set chance = 2500 where itemid = 20110 and mobid = 45127;
-- decrease lamp droprate from rova orc (50000 -> 18000)
update droplist set chance = 18000 where itemid = 40001 and mobid = 45127;
-- decrease lantern droprate from rova orc (15000 -> 10000)
update droplist set chance = 10000 where itemid = 40002 and mobid = 45127;
-- increase haste pot droprate from rova orc (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40013 and mobid = 45127;
-- decrease g-haste pot droprate from rova orc (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40018 and mobid = 45127;
-- decrease egg droprate from rova orc (50000 -> 25000)
update droplist set chance = 25000 where itemid = 40059 and mobid = 45127;
-- decrease bume droprate from rova orc (120 -> 20)
update droplist set chance = 40 where itemid = 450003 and mobid = 45127;

-- add additional rova orc drops
-- lantern oil
insert into droplist values (45127, 40003, 1, 1, 5000);

-- modify existing atuba orc drops
-- decrease homr droprate from atuba orc (10000 -> 7500)
update droplist set chance = 75000 where itemid = 20011 and mobid = 45149;
-- decrease orcish chain mail droprate from atuba orc (50000 -> 12000)
update droplist set chance = 12000 where itemid = 20136 and mobid = 45149;
-- decrease orcish shield droprate from atuba orc (50000 -> 15000)
update droplist set chance = 15000 where itemid = 20237 and mobid = 45149;
-- decrease orc amulet droprate from atuba orc (2000 -> 1500)
update droplist set chance = 1500 where itemid = 20263 and mobid = 45149;
-- decrease lantern droprate from atuba orc (15000 -> 12000)
update droplist set chance = 12000 where itemid = 40002 and mobid = 45149;
-- decrease haste pot droprate from atuba orc (50000 -> 35000)
update droplist set chance = 35000 where itemid = 40013 and mobid = 45149;
-- decrease g-haste pot droprate from atuba orc (50000 -> 20000)
update droplist set chance = 20000 where itemid = 40018 and mobid = 45149;
-- decrease ruby droprate from atuba orc (50000 -> 25000)
update droplist set chance = 25000 where itemid = 40045 and mobid = 45149;
-- decrease damascus droprate from atuba orc (50000 -> 10000)
update droplist set chance = 10000 where itemid = 37 and mobid = 45149;

-- add additional atuba orc drops
-- add carrot to atuba orc droplist
insert into droplist values (45149, 40060, 1, 1, 15000);
-- add egg to atuba orc droplist
insert into droplist values (45149, 40059, 1, 1, 25000);
-- add gradius to atuba orc droplist
insert into droplist values (45149, 32, 1, 1, 5000);
-- add plate mail to atuba orc droplist
insert into droplist values (45149, 20154, 1, 1, 500);
-- add red pot to atuba orc droplist 
insert into droplist values (45149, 40010, 1, 1, 15000);
-- add 2hs to atuba orc droplist 
insert into droplist values (45149, 52, 1, 1, 500);

-- modify existing duda-mura orc drops
-- decrease homr droprate from duda-mura orc (10000 -> 6000)
update droplist set chance = 6000 where itemid = 20011 and mobid = 45143;
-- decrease cmomr droprate from duda-mura orc (50000 -> 10000)
update droplist set chance = 10000 where itemid = 20110 and mobid = 45143;
-- decrease Orcish Shield droprate from duda-mura orc (50000 -> 12000)
update droplist set chance = 12000 where itemid = 20237 and mobid = 45143;
-- decrease Amulet of Orc Warrior droprate from duda-mura orc (2000 -> 800)
update droplist set chance = 800 where itemid = 20263 and mobid = 45143;
-- decrease Lantern droprate from duda-mura orc (15000 -> 10000)
update droplist set chance = 10000 where itemid = 40002 and mobid = 45143;
-- decrease ruby droprate from duda-mura orc (50000 -> 25000)
update droplist set chance = 25000 where itemid = 40045 and mobid = 45143;

-- add additional drops to duda-mura orc
-- add carrot to duda-mura orc droplist 
insert into droplist values (45143, 40060, 1, 1, 15000);
-- add egg to duda-mura orc droplist 
insert into droplist values (45143, 40059, 1, 1, 25000);
-- add red pot to duda-mura orc droplist 
insert into droplist values (45143, 40010, 1, 1, 15000);
-- add g-haste pot to duda-mura orc droplist 
insert into droplist values (45143, 40018, 1, 1, 5000);
-- add haste pot to duda-mura orc droplist 
insert into droplist values (45143, 40013, 1, 1, 10000);
-- add gradius to duda-mura orc droplist 
insert into droplist values (45143, 32, 1, 1, 4000);
-- add plate mail to duda-mura orc droplist 
insert into droplist values (45143, 20154, 1, 1, 300);
-- add 2hs to duda-mura orc droplist 
insert into droplist values (45143, 52, 1, 1, 300);
-- add sb:heal pledge to duda-mura orc droplist 
insert into droplist values (45143, 40194, 1, 1, 800);
-- add bume to duda-mura orc droplist 
insert into droplist values (45143, 450003, 1, 1, 30);

-- modify existing neruga orc drops
-- decrease cmomr droprate from neruga orc (50000 -> 15000)
update droplist set chance = 15000 where itemid = 20110 and mobid = 45171;
-- decrease orcish shield droprate from neruga orc (50000 -> 12000)
update droplist set chance = 12000 where itemid = 20237 and mobid = 45171;
-- decrease Amulet of Orc Warrior droprate from neruga orc (2000 -> 1000)
update droplist set chance = 1000 where itemid = 20263 and mobid = 45171;
-- decrease Lantern droprate from neruga orc (15000 -> 12000)
update droplist set chance = 12000 where itemid = 40002 and mobid = 45171;
-- decrease haste pot droprate from neruga orc (50000 -> 25000)
update droplist set chance = 25000 where itemid = 40013 and mobid = 45171;
-- decrease damascus droprate from neruga orc (50000 -> 5000)
update droplist set chance = 5000 where itemid = 37 and mobid = 45171;
-- decrease c-sls droprate from neruga orc (50000 -> 500)
update droplist set chance = 500 where itemid = 200032 and mobid = 45171;
-- decrease c-2hs droprate from neruga orc (50000 -> 5000)
update droplist set chance = 5000 where itemid = 200052 and mobid = 45171;
-- increase bume droprate from neruga orc (20 -> 40)
update droplist set chance = 40 where itemid = 450003 and mobid = 45171;

-- remove rova totem from neruga droplist
delete from droplist where itemid = 40132 and mobid = 45171;

-- add additional drops to neruga orc
-- add totem of neruga to neruga orc droplist 
insert into droplist values (45171, 40134, 1, 1, 300000);
-- add carrot to neruga orc droplist 
insert into droplist values (45171, 40060, 1, 1, 15000);
-- add egg to neruga orc droplist 
insert into droplist values (45171, 40059, 1, 1, 25000);
-- add red pot to neruga orc droplist 
insert into droplist values (45171, 40010, 1, 1, 15000);
-- add gradius to neruga orc droplist 
insert into droplist values (45171, 32, 1, 1, 4000);
-- add plate mail to neruga orc droplist 
insert into droplist values (45171, 20154, 1, 1, 400);

-- decrease lamp drops from orc fighter (300000 -> 25000), hobgoblin, ghost (50000 -> 25000)
update droplist set chance = 25000 where itemid = 40001 and mobid in (45082, 45140, 45174, 45198);

-- add additional drops to snowman
-- add clear pot to snowman droplist 
insert into droplist values (45133, 40012, 1, 1, 10000);
-- add carrot to snowman droplist 
insert into droplist values (45133, 40060, 1, 1, 50000);

-- modify existing ice golem drops
-- decrease sc:nt droprate from ice golem (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40254 and mobid = 45182;
-- decrease sb:weakness droprate from ice golem (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40192 and mobid = 45182;
-- decrease mace droprate from ice golem (50000 -> 20000)
update droplist set chance = 20000 where itemid = 140 and mobid = 45182;
-- decrease silver axe droprate from ice golem (50000 -> 15000)
update droplist set chance = 15000 where itemid = 142 and mobid = 45182;

-- add additional drops to ice golem
-- add orange pot to ice golem droplist 
insert into droplist values (45182, 40011, 1, 1, 30000);
-- add brave pot to ice golem droplist 
insert into droplist values (45182, 40014, 1, 1, 15000);
-- add wis pot to ice golem droplist 
insert into droplist values (45182, 40016, 1, 1, 12000);
-- add n-prat to ice golem droplist 
insert into droplist values (45182, 40119, 1, 1, 10000);
-- add id scroll to ice golem droplist 
insert into droplist values (45182, 40126, 1, 1, 5000);
-- add n-tele to ice golem droplist 
insert into droplist values (45182, 40100, 1, 1, 25000);
-- add ebony wand to ice golem droplist 
insert into droplist values (45182, 40007, 1, 1, 5000);
-- add sapphire to ice golem droplist 
insert into droplist values (45182, 40046, 1, 1, 2500);
-- add sc:resist elemental to ice golem droplist 
insert into droplist values (45182, 40236, 1, 1, 1000);

-- remove red pot from ice man droplist
delete from droplist where itemid = 40010 and mobid = 45207;
-- remove orage pot from ice man droplist
delete from droplist where itemid = 40011 and mobid = 45207;
-- remove clear pot from ice man droplist
delete from droplist where itemid = 40012 and mobid = 45207;
-- remove sc:nb from ice man droplist
delete from droplist where itemid = 40253 and mobid = 45207;

-- add additional drops to ice man
-- add btele to ice man droplist 
insert into droplist values (45207, 140100, 1, 1, 25000);

-- remove red pot from yeti droplist
delete from droplist where itemid = 40010 and mobid = 45294;

-- add additional drops to yeti
-- add orange pot to yeti droplist 
insert into droplist values (45182, 40012, 1, 1, 10000);

-- modify existing iron golem drops
-- decrease sb:str droprate from iron golem (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40187 and mobid = 45372;
-- decrease sb:weakness droprate from iron golem (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40192 and mobid = 45372;
-- increase rough mith droprate from iron golem (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40496 and mobid = 45372;
-- decrease lump of steel droprate from iron golem (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40899 and mobid = 45372;

-- add additional drops to iron golem
-- add sb:darkness to iron golem droplist 
insert into droplist values (45372, 40185, 1, 1, 2500);
-- add sb:mana drain to iron golem droplist 
insert into droplist values (45372, 40184, 1, 1, 500);
-- add btele to iron golem droplist 
insert into droplist values (45372, 140100, 1, 1, 20000);

-- modify existing death drops
-- decrease Halbred droprate from death  (50000 -> 15000)
update droplist set chance = 15000 where itemid = 103 and mobid = 45221;
-- decrease g-axe droprate from death  (25000 -> 15000)
update droplist set chance = 15000 where itemid = 148 and mobid = 45221;
-- decrease sb:disease droprate from death  (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40201 and mobid = 45221;
-- increase sb:i1h droprate from death  (250 -> 350)
update droplist set chance = 350 where itemid = 40213 and mobid = 45221;
-- decrease splint mail droprate from death  (25000 -> 10000)
update droplist set chance = 10000 where itemid = 20115 and mobid = 45221;

-- add additional drops to death 
-- add sb:darkness to death  droplist 
insert into droplist values (45221, 40185, 1, 1, 2500);
-- add sb:mana drain to death  droplist 
insert into droplist values (45221, 40184, 1, 1, 500);
-- add sb:weakness to death  droplist 
insert into droplist values (45221, 40192, 1, 1, 1500);
-- add sc:b2s to death  droplist 
insert into droplist values (45221, 40238, 1, 1, 500);
-- add dsc:final burn to death  droplist 
insert into droplist values (45221, 40278, 1, 1, 800);

-- modify existing ghost(red) drops
-- decrease cotton robe droprate from ghost(red) (50000 -> 40000)
update droplist set chance = 40000 where itemid = 20114 and mobid = 45198;
-- decrease haste pot droprate from ghost(red) (50000 -> 45000)
update droplist set chance = 45000 where itemid = 40013 and mobid = 45198;
-- decrease sb:ej droprate from ghost(red) (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40175 and mobid = 45198;
-- decrease sb:mana drain droprate from ghost(red) (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40184 and mobid = 45198;

-- add additional drops to ghost(red) 
-- add wis pot to ghost(red) droplist 
insert into droplist values (45198, 40016, 1, 1, 25000);
-- add sb:c-m to ghost(red) droplist 
insert into droplist values (45198, 40176, 1, 1, 2500);

-- modify existing ghost(blue) drops
-- decrease cotton robe droprate from ghost(blue) (50000 -> 40000)
update droplist set chance = 40000 where itemid = 20114 and mobid = 45174;
-- decrease ebony droprate from ghost(blue) (50000 -> 25000)
update droplist set chance = 25000 where itemid = 40007 and mobid = 45174;
-- decrease sb:ej droprate from ghost(red) (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40175 and mobid = 45174;
-- decrease sb:mana drain droprate from ghost(blue) (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40184 and mobid = 45174;
-- decrease sb:freeze droprate from ghost(blue) (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40195 and mobid = 45174;
-- decrease sc:resist elemental droprate from ghost(blue) (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40236 and mobid = 45174;
-- decrease sc:nt droprate from ghost(blue) (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40254 and mobid = 45174;
-- decrease silver axe droprate from ghost(blue) (50000 -> 15000)
update droplist set chance = 15000 where itemid = 142 and mobid = 45174;

-- add additional drops to ghost(blue) 
-- add sb:c-m to ghost(red) droplist 
insert into droplist values (45198, 45174, 1, 1, 2500);

-- modify existing silhouette drops
-- decrease sb:darkness droprate from silhouette (50000 -> 7500)
update droplist set chance = 7500 where itemid = 40185 and mobid = 45162;

-- remove obom from silhouette droplist
delete from droplist where itemid = 20307 and mobid = 45162;

-- add additional drops to silhouette
-- add obos to silhouette droplist 
insert into droplist values (45162, 20308, 1, 1, 7500);
-- add sb:c-m to silhouette droplist 
insert into droplist values (45162, 40176, 1, 1, 500);

-- modify existing living armor drops
-- increase bpm droprate from living armor (5000 -> 7500)
update droplist set chance = 7500 where itemid = 20149 and mobid = 45322;
-- decrease sc:clear mind droprate from living armor (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40235 and mobid = 45322;
-- decrease dsc:shadow fang droprate from living armor (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40277 and mobid = 45322;
-- decrease sb:weakness droprate from living armor (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40192 and mobid = 45322;
-- increase sb:i2h droprate from living armor (250 -> 500)
update droplist set chance = 500 where itemid = 40213 and mobid = 45322;

-- remove splint mail from living armor droplist 
delete from droplist where itemid = 120101 and mobid = 45322;

-- add additional drops to living armor 
-- add banded mail to living armor droplist 
insert into droplist values (45322, 20101, 1, 1, 10000);
-- add sb:darkness to living armor droplist 
insert into droplist values (45322, 40185, 1, 1, 5000);

-- modify existing mimic drops
-- decrease g-haste pot droprate from mimic (50000 -> 25000)
update droplist set chance = 25000 where itemid = 40018 and mobid = 45141;
-- decrease dsc:shadow fang droprate from mimic (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40277 and mobid = 45141;

-- remove homr from mimic droplist
delete from droplist where itemid = 20011 and mobid = 45141;

-- add additional drops to mimic 
-- add poly scroll to mimic droplist 
insert into droplist values (45141, 40088, 1, 1, 20000);
-- add orange pot to mimic droplist 
insert into droplist values (45141, 40011, 1, 1, 50000);
-- add diamond to mimic droplist 
insert into droplist values (45141, 40044, 1, 1, 20000);
-- add blue pot to mimic droplist 
insert into droplist values (45141, 40015, 1, 1, 25000);
-- add emerald to mimic droplist 
insert into droplist values (45141, 40047, 1, 1, 20000);
-- add sapphire to mimic droplist 
insert into droplist values (45141, 40046, 1, 1, 20000);

-- remove lump of black mithral from fi de
delete from droplist where itemid = 40444 and mobid = 45364;

-- remove hard leather vest from unicorn droplist
delete from droplist where itemid = 20145 and mobid = 45640;
