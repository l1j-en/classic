-- update 0

-- reduce quest item drops 
-- skeleton skull
update droplist set chance = 100000 where itemid = 40605;
-- ghoul nail
update droplist set chance = 100000 where itemid = 40538;
-- ghoul tooth
update droplist set chance = 100000 where itemid = 40539;
-- secret room key
update droplist set chance = 50000 where itemid = 40555;
-- secret of life 
update droplist set chance = 100000 where itemid = 40564;
-- arachnevil elder's claw
update droplist set chance = 100000 where itemid = 40590;
-- claw of drake
update droplist set chance = 100000 where itemid = 40622;
-- black knight pledge document
update droplist set chance = 100000 where itemid = 40608;
-- old trading document
update droplist set chance = 100000 where itemid = 40540;
-- turtle dragon's shell
update droplist set chance = 100000 where itemid = 40601;
-- horn of basilisk
update droplist set chance = 10000 where itemid = 40646;

-- reduce bezerker axe drops
update droplist set chance = chance / 10 where itemid = 145 and chance > 15000;

-- fix droplist referential integrity error
delete from droplist where itemid = 50000;



-- update 1

-- half cdai, bdai, ndai drops
update droplist set chance = chance / 2 where itemid in (40087, 140087, 240087);

-- increase wafer drops from DEs
update droplist set chance = 50000 where mobid = 45364 and itemid = 40068;
update droplist set chance = 50000 where mobid = 45265 and itemid = 40068;


-- add bzels to lesser dragons
insert into droplist values (45496, 140074, 1, 1, 5000);
-- add bdais to lesser dragons
insert into droplist values (45496, 240087, 1, 1, 2000);
-- half heart of dragon drop
update droplist set chance = 500 where mobid = 45496 and itemid = 40466;



-- update 2

-- rarify thor's, eva's, bume
update droplist set chance = chance / 5 where itemid in (450000, 36, 450003);

-- make o-blood more common, o-belt more rare
update droplist set chance = 500 where itemid = 20317;
update droplist set chance = 2000 where itemid = 40513;

-- reduce secret room key drop rate
update droplist set chance = 20000 where itemid = 40555;



-- update 3

-- add sks to giant droplist
insert into droplist values (45295, 20238, 1, 1, 500);
insert into droplist values (45337, 20238, 1, 1, 500);
insert into droplist values (45351, 20238, 1, 1, 500);

-- add brave pots to giant droplist
insert into droplist values (45295, 40014, 1, 1, 2000);
insert into droplist values (45337, 40014, 1, 1, 2000);
insert into droplist values (45351, 40014, 1, 1, 2000);

-- add orange pots to giant droplist
insert into droplist values (45295, 40011, 1, 1, 2000);
insert into droplist values (45337, 40011, 1, 1, 2000);
insert into droplist values (45351, 40011, 1, 1, 2000);

-- half club drop rate
update droplist set chance = chance / 2 where itemid = 138;

-- half athame drop rate
update droplist set chance = chance / 2 where itemid = 137;

-- half battle axe drop rate
update droplist set chance = chance / 2 where itemid = 143;

-- add sb:summon to ghast lord drop list
insert into droplist values (45346, 40196, 1, 1, 500);

-- reduce unicorn c-kat drop rate
update droplist set chance = chance / 2 where itemid = 200041 and mobid = 45640;
-- reduce unicorn c-2hs drop rate 
update droplist set chance = chance / 2 where itemid = 200052 and mobid = 45640;
-- reduce unicorn coi drop rate by 5x
update droplist set chance = chance / 5 where itemid = 20077 and mobid = 45640;

-- add dark cloak to unicorn droplist
insert into droplist values (45640, 20070, 1, 1, 5000);
-- add hard leather vest to unicorn droplist
insert into droplist values (45640, 20145, 1, 1, 10000);

-- reduce bk search party search document drop rate by 20x
update droplist set chance = 50000 where itemid = 40565 and mobid = 81066;

-- reduce black knight t-s, cop drops by half
update droplist set chance = 5000 where itemid = 20085 and mobid = 81066;
update droplist set chance = 5000 where itemid = 20085 and mobid = 45165;
update droplist set chance = 5000 where itemid = 20063 and mobid = 81066;
update droplist set chance = 5000 where itemid = 20063 and mobid = 45165;



-- update 4

-- add czel to beholder droplist
insert into droplist values (45349, 240074, 1, 1, 5000);

-- add sb: immune to harm to beholder droplist
insert into droplist values (45349, 40213, 1, 1, 100);

-- add diamond to beholder droplist
insert into droplist values (45349, 40044, 1, 1, 5000);

-- increase brave/orange pot droprate from giants
update droplist set chance = 5000 where mobid = 45295 and itemid = 40014;
update droplist set chance = 5000 where mobid = 45337 and itemid = 40014;
update droplist set chance = 5000 where mobid = 45351 and itemid = 40014;
update droplist set chance = 5000 where mobid = 45295 and itemid = 40011;
update droplist set chance = 5000 where mobid = 45337 and itemid = 40011;
update droplist set chance = 5000 where mobid = 45351 and itemid = 40011;

-- modify ancient scroll drop rates for fi drake
update droplist set chance = 1200 where mobid = 45578 and itemid = 40076;

-- reduce ring of magic resistance drops slightly
update droplist set chance = 8000 where itemid = 20303;

-- reduce splint mail and banded mail droprates by 50%
update droplist set chance = chance / 2 where itemid in (20115, 20101);

-- add items to 45738 bbs droplist (same as 45223)
insert into droplist values (45738, 143, 1, 1, 50000);
insert into droplist values (45738, 145, 1, 1, 5000);
insert into droplist values (45738, 148, 1, 1, 50000);
insert into droplist values (45738, 20115, 1, 1, 25000);
insert into droplist values (45738, 40031, 1, 1, 5000);
insert into droplist values (45738, 40074, 1, 1, 50000);
insert into droplist values (45738, 40087, 1, 1, 25000);
insert into droplist values (45738, 40170, 1, 1, 10000);
insert into droplist values (45738, 40172, 1, 1, 10000);
insert into droplist values (45738, 40191, 1, 1, 10000);
insert into droplist values (45738, 40271, 1, 1, 10000);
insert into droplist values (45738, 40305, 1, 1, 10500);
insert into droplist values (45738, 40308, 1, 1, 1000000);
insert into droplist values (45738, 40555, 1, 1, 50000);
insert into droplist values (45738, 140100, 1, 1, 50000);

-- reduce belt of mind, belt of body, belt of soul drop rates globally by 50%
update droplist set chance = chance / 2 where itemid in (20319, 20312, 20316);

-- reduce orc ammy drop rate
update droplist set chance = 2000 where itemid = 20263;

-- reduce immune to harm droprate for death, cerebus, dark elemental, giran cerberus, giran arach elder, living armor
update droplist set chance = 250 where itemid = 40213 and mobid in (45221, 45241, 45244, 45283, 45312, 45322);

-- reduce summon drop rate
update droplist set chance = chance / 2 where mobid in (45142, 45213, 45279, 45393, 45394, 45451, 45546, 45546, 45572, 45573);

-- reduce b2s droprate for crabmen
update droplist set chance = 1000 where mobid = 45164 and itemid = 40238;

-- reduce lastabad heavy xbow droprate by half
update droplist set chance = 2500 where itemid = 188;

-- reduce int ammy drop rate for unicorn
update droplist set chance = 4000 where itemid = 20266 and mobid = 45640;

-- reduce blizz droprate (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40204 and mobid in (45279, 45393, 45394);

-- reduce freezing blizz droprate from low level mobs
update droplist set chance = 500 where itemid = 40225 and mobid in (45155, 45159, 45170);



-- update 5

-- add sb:polymorph as rare to lvl 19 doppel
insert into droplist values (45189, 40212, 1, 1, 100);

-- add a-scroll to fi griffon droplist
insert into droplist values (45445, 40076, 1, 1, 500);



-- update 7

-- make normal succubus always drop adena
update droplist set chance = 1000000 where itemid = 40308 and mobid in (45394, 45393, 45451);

-- add i-visor, ipm, and ndai to horrific iron golem 
insert into droplist values (45479, 20003, 1, 1, 5000);
insert into droplist values (45479, 20091, 1, 1, 3000);
insert into droplist values (45479, 40087, 1, 1, 10000);

-- add bzel to fire ghost droplist
insert into droplist values (45519, 140074, 1, 1, 5000);



-- update 8

-- add ring of immunity to magic to fi dark elf
insert into droplist values (45364, 20280, 1, 1, 500);

-- add a-scroll to fi dark elf 
insert into droplist values (45364, 40076, 1, 1, 100);

-- reduce helm of wind droprates by 50%
update droplist set chance = 5000 where itemId = 20023;

-- reduce old helm of wind droprates by 30%
update droplist set chance = 7000 where itemId = 20008;

-- reduce cursed scale mail droprate from 45024 werewolf
update droplist set chance = 25000 where itemid = 220122 and mobid = 45024;

-- reduce SC: elemental falldown droprate (10000 -> 2000) for lower level mobs
update droplist set chance = 2000 where itemid = 40241 and mobid in (45298, 45322, 45359, 45373);

-- reduce SC: fire weapon droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40256 and mobid in (45203, 45206, 45241, 45283, 45284, 45286, 45291, 45341, 45359, 45365, 45408);

-- reduce SC: bless of fire droprate (10000 -> 2000) for lower level mobs
update droplist set chance = 2000 where itemid = 40257 and mobid in (45206, 45284, 45291, 45298, 45341, 45359, 45365, 45408);

-- reduce SC: elemental fire droprate (10000 -> 1000) for lower level mobs
update droplist set chance = 1000 where itemid = 40259 and mobid in (45203, 45206, 45341, 45359);

-- reduce SC: earth skin droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40247 and mobid in (45240, 45259, 45260, 45262, 45269, 45277, 45345, 45372);

-- reduce SC: iron skin droprate (10000 -> 1000) for lower level mobs
update droplist set chance = 1000 where itemid = 40251 and mobid in (45372, 45345, 45570, 45571, 45582, 45587, 45605);

-- reduce SC: wind shot droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40260 and mobid in (45135, 45137, 45138, 45265, 45270);

-- add bless of earth to elindaire
insert into droplist values (81081, 40250, 1, 1, 10000);

-- reduce SC: exotic vitalize droprate (10000 -> 2000) for lower level mobs
update droplist set chance = 2000 where itemid = 40252 and mobid in (45295, 45337, 45345, 45351, 45373, 45416);

-- reduce SC: eye of storm droprate (10000 -> 3000) for lower level mobs
update droplist set chance = 3000 where itemid = 40262 and mobid in (45203, 45264, 45265);

-- reduce SC: counter mirror droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40246 and mobid in (45217, 45419);

-- reduce SC: area of silence droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40244 and mobid in (45257, 45516);

-- reduce SC: triple shot droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40240 and mobid in (45118, 45122, 45291, 45321, 45349, 45361, 45365, 45366, 45418, 45420, 45424);

-- reduce DSC: blind hiding droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40265 and mobid in (45019, 45050, 45065, 45066, 45094, 45104, 45109, 45114, 45126, 45129, 45134, 45181, 45244);

-- reduce DSC: enchant venom droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40266 and mobid in (45065, 45066, 45104, 45109, 45114, 45129, 45181, 45220, 45233, 45244, 45254, 45272, 45398, 45411, 45446);

-- reduce DSC: shadow armor droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40267 and mobid in (45024, 45082, 45094, 45126, 45134, 45144, 45145, 45244, 45287, 45412);

-- reduce DSC: dress mighty droprate (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40269;

-- reduce DSC: burning spirit droprate (10000 -> 5000) 
update droplist set chance = 5000 where itemid = 40271;

-- reduce DSC: dark blind droprate (10000 -> 5000) 
update droplist set chance = 5000 where itemid = 40272;

-- reduce DSC: venom resist droprate (10000 -> 5000) 
update droplist set chance = 5000 where itemid = 40273;

-- reduce DSC: dress dex droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40274 and mobid in (45065, 45066, 45094, 45129, 45181, 45256);

-- reduce DSC: double break droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40275 and mobid in (45244, 45345, 45372, 45380, 45515, 45493);

-- reduce DSC: shadow fang droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40277 and mobid in (45220, 45244, 45272, 45363, 45471, 45481, 45516);

-- reduce DSC: final burn droprate (10000 -> 2000) for lower level mobs
update droplist set chance = 2000 where itemid = 40278 and mobid in (45141, 45244, 45287, 45322, 45345, 45372, 45399, 45406, 45412, 45454, 45494);

-- reduce DSC: dress evasion droprate (10000 -> 5000) for lower level mobs
update droplist set chance = 5000 where itemid = 40279 and mobid in (45272, 45406, 45455, 45493);

-- add thor's to dark and light giant droplist
insert into droplist values (45337, 450000, 1, 1, 40);
insert into droplist values (45295, 450000, 1, 1, 50);
-- reduce thor's droprate on medium giant
update droplist set chance = 60 where itemid = 450000 and mobid = 45351;

-- reduce dwarf and dwarf warrior junk drops 
-- Dwarvish Iron Helm  
update droplist set chance = 20000 where itemid = 20007;
-- Dwarvish Cloak  
update droplist set chance = 20000 where itemid = 20052;
-- Dwarvish Round Shield 
update droplist set chance = 15000 where itemid = 20223;
-- Dwarvish Short Sword
update droplist set chance = 15000 where itemid = 26;

-- reduce lantern droprate from gnolls and tribal orcs
update droplist set chance = 15000 where itemid = 40002;

-- reduce candle droprate on orc, orc archer, and gandi orc
update droplist set chance = 25000 where itemid = 40005;

-- reduce stone golem flail droprate
update droplist set chance = 25000 where itemid = 139 and mobid in (45126, 45281);

-- reduce skeleton skull droprate (50000 -> 30000)
update droplist set chance = 30000 where itemid = 40605;

-- reduce skeleton scitimar droprate by 50%
update droplist set chance = 25000 where itemid in (27, 200027) and mobid in (45107, 45114);

-- reduce bpm droprate from atuba orc, spartoi, bk, gsa, elmore general, and living armor, bk search party (10000 -> 5000)
update droplist set chance = 5000 where itemid = 20149 and mobid in (45149, 45161, 45165, 45181, 45190, 45248, 45322, 81066);

-- reduce orcish helm droprate from orc zombie (300000 -> 15000)
update droplist set chance = 15000 where itemid = 20034 and mobid = 45104;

-- reduce orcish ring mail and orcish chain mail droprate from orc zombie (50000 -> 10000)
update droplist set chance = 10000 where itemid in (20135, 20136) and mobid = 45104;

-- add brave pot to cursed orc zombie droplist
insert into droplist values(45468, 40014, 1, 1, 50000);

-- add nzel to cursed orc zombie droplist
insert into droplist values(45468, 40074, 1, 1, 25000);

-- reduce 10% MR ring droprate from 5xf elmores (1000 -> 500)
update droplist set chance = 500 where itemid = 20280 and mobid in (45524, 45506, 45541);

-- add whetstone to cursed elmore general
insert into droplist values(45541, 40317, 1, 1, 10000);

-- reduce orcish cloak droprate by 50% 
update droplist set chance = 25000 where itemid = 20072;

-- add orcish cloak drop to orc and orc archer
insert into droplist values (45019, 20072, 1, 1, 15000);
insert into droplist values (45009, 20072, 1, 1, 15000);

-- reduce g-axe droprate from death, bugbear, ogre, and troll by 50%
update droplist set chance = 25000 where itemid = 148 and mobid in (45221, 45223, 45738, 45278, 45280);

-- increase silver cloak droprate from cerenis (1000 -> 5000)
update droplist set chance = 5000 where itemid = 20074 and mobid = 45678;

-- add drops to yahee
-- adena
insert into droplist values (45675, 40308, 32000, 64000, 1000000);
-- helmet of yahee
insert into droplist values (45675, 20031, 1, 1, 8000);
-- cloak of yahee
insert into droplist values (45675, 20069, 1, 1, 8000);
-- armor of yahee
insert into droplist values (45675, 20131, 1, 1, 8000);
-- gloves of yahee
insert into droplist values (45675, 20179, 1, 1, 8000);
-- boots of yahee
insert into droplist values (45675, 20209, 1, 1, 8000);
-- amulet of yahee
insert into droplist values (45675, 20261, 1, 1, 8000);
-- ring of yahee
insert into droplist values (45675, 20290, 1, 1, 8000);

-- correct non-100% adena droprates
update droplist set chance = 1000000 where itemid = 40308 and chance < 1000000;

-- reduce forgotton armor droprates by 50%
update droplist set chance = 5000 where itemid in (20140, 20141, 20142, 20143);

-- reduce forgotten bowgun droprates from griffon by 50%
update droplist set chance = 5000 where itemid = 167 and mobid = 45445;

-- reduce ropc droprate from succubus and unicorn (5000 -> 500)
update droplist set chance = 500 where itemid = 20281 and mobid in (45393, 45394, 45640);

-- remove ropc from succubus queen of varlok
delete from droplist where itemid = 20281 and mobid = 45450;

-- remove rotc drop from succubus
delete from droplist where itemid = 20288 and mobid = 45394;

-- reduce rotc droprate from bapho and IQ (10000 -> 5000)
update droplist set chance = 5000 where itemid = 20288 and mobid in (45573, 45609);

-- reduce sb:g-res droprate from medusa (10000 -> 900)
update droplist set chance = 900 where itemid = 40220 and mobid = 45380;

-- increase elindaire bzel droprate (5000 -> 10000)
update droplist set chance = 10000 where itemid = 140074 and mobid = 81081;

-- increase abyss ghoul nzel droprate (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45501;

-- correct ring drop fire boss
delete from droplist where itemid = 20285 and mobid = 45643;
insert into droplist values (45643, 20304, 1, 1, 10000);

-- reduce pg droprate from crawling claw (1000 -> 100)
update droplist set chance = 100 where itemid = 20187 and mobid = 45083;



-- update 10 

-- add sb:destroy to lich droplist
insert into droplist values (45672, 40222, 1, 1, 2000);

-- fix eva scorn droprate (5000 -> 100)
update droplist set chance = 100 where itemid = 36 and mobid = 45279;

-- correct mlc 7 bb adena drop min/max
update droplist d set d.min = 141, d.max = 223 where mobid = 45738 and itemid = 40308;



-- update 11

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



-- update 12

-- increase wis pot drops on taurverus 
update droplist set max = 3 and chance = 200000 where itemid = 40016 and mobid = 45341;

-- increase res scroll drops on taurverus 
update droplist set max = 3 and chance = 200000 where itemid = 40089 and mobid = 45341;

-- increase brave pot drops on fire warrior 
update droplist set chance = 200000 where itemid = 40014 and mobid = 45284;

-- increase brave pot drops on astagio
update droplist set chance = 300000 where itemid = 40014 and mobid = 45359;

-- increase brave pot drops on lava golem
update droplist set chance = 150000 where itemid = 40014 and mobid = 45365;

-- increase  a-scroll droprate on fi doppel and basi (800 -> 1000)
update droplist set chance = 1000 where itemid = 40076 and mobid in (45457, 45531);

-- reduce rosc droprate on unicorn
update droplist set chance = 1000 where itemid = 20284 and mobid = 45640;
-- increase bzel droprate on unicorn
update droplist set chance = 15000 where itemid = 140074 and mobid = 45640;



-- update 13

-- change ring drop on water boss to water ring
update droplist set itemid = 20285 where itemid = 20304 and mobid = 45643;

-- change ring drop on fire boss to fire ring
update droplist set itemid = 20304 where itemid = 20285 and mobid = 45645;

-- remove cg from di ice golem droplist
delete from droplist where itemid = 20175 and mobid = 45553;

-- increase cg droprate from normal ice golem
update droplist set chance = 1200 where itemid = 20175 and mobid = 45182;

-- increase czel, cdai, bzel, tqs drop on dv drake
update droplist set chance = 25000 where itemid = 240074 and mobid = 45529;
update droplist set chance = 12500 where itemid = 240087 and mobid = 45529;
update droplist set chance = 12500 where itemid = 140074 and mobid = 45529;
update droplist set chance = 20000 where itemid = 40054 and mobid = 45529;

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



-- update 14

-- add thor's hammer to dark elf general droplist
insert into droplist values (45472, 450000, 1, 1, 25);

-- increase shining scale droprate from ramias (20000 -> 40000)
update droplist set chance = 40000 where itemid = 40458 and mobid in (45222, 45229, 45230, 45387, 81075, 81076);

-- increase shining scale droprate from mutant ramias (20000 -> 60000)
update droplist set chance = 60000 where itemid = 40458 and mobid = 45332;

-- modify existing fire egg drops
-- increase blue pot droprate from fire egg (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45206;
-- increase esc scroll droprate from fire egg (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40079 and mobid = 45206;
-- increase poly scroll droprate from fire egg (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40088 and mobid = 45206;
-- increase n-prat droprate from fire egg (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40119 and mobid = 45206;

-- add additional drops to fire egg
-- add sb:haste to fire egg droplist
insert into droplist values (45206, 40188, 1, 1, 7500);

-- modify existing bomb flower drops
-- increase btele droprate from bomb flower (50000 -> 300000)
update droplist set chance = 300000 where itemid = 140100 and mobid = 45263;

-- add additional drops to bomb flower
-- add sb:v-t to bomb flower droplist
insert into droplist values (45263, 40173, 1, 1, 7500);
-- add sb:para to bomb flower droplist
insert into droplist values (45263, 40178, 1, 1, 2500);

-- modify existing dragonfly drops
-- increase ntele droprate from dragonfly (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40100 and mobid = 45257;

-- add additional drops to dragonfly
-- add sb:para to dragonfly droplist
insert into droplist values (45257, 40178, 1, 1, 2500);
-- add sb:sunburst to dragonfly droplist
insert into droplist values (45257, 40191, 1, 1, 2500);

-- add additional drops to fire warrior
-- add sc:erase magic to fire warrior droplist
insert into droplist values (45284, 40242, 1, 1, 500);
-- add shock stun to fire warrior droplist
insert into droplist values (45284, 40164, 1, 1, 500);

-- modify existing salamander drops
-- increase hqd droprate from salamander (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40048 and mobid = 45203;
-- increase hqs droprate from salamander (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40050 and mobid = 45203;
-- decrease sb:tornado droprate from salamander (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40198 and mobid = 45203;
-- decrease sb:fs droprate from salamander (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40215 and mobid = 45203;
-- decrease sb:burning weapon droprate from salamander (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40258 and mobid = 45203;
-- decrease sb:erase magic droprate from salamander (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40242 and mobid = 45203;
-- increase btele droprate from salamander (50000 -> 150000)
update droplist set chance = 150000 where itemid = 140100 and mobid = 45203;

-- add additional drops to salamander
-- add sb:nt to salamander droplist
insert into droplist values (45203, 40254, 1, 1, 2000);
-- add sb:erupt to salamander droplist
insert into droplist values (45203, 40190, 1, 1, 2000);

-- modify existing astiago drops
-- increase btele droprate from astiago (50000 -> 150000)
update droplist set chance = 150000 where itemid = 140100 and mobid = 45359;

-- add additional drops to astiago
-- add sb:erase magic to astiago droplist
insert into droplist values (45359, 40242, 1, 1, 1000);

-- modify existing lava golem drops
-- increase 2hs droprate from lava golem (10000 -> 25000)
update droplist set chance = 25000 where itemid = 52 and mobid = 45365;
-- increase g-axe droprate from lava golem (10000 -> 25000)
update droplist set chance = 25000 where itemid = 148 and mobid = 45365;
-- decrease sc: burning weapon droprate from lava golem (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40258 and mobid = 45365;
-- decrease sb:fs droprate from lava golem (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40215 and mobid = 45365;

-- add additional drops to lava golem
-- add n-prat to lava golem droplist
insert into droplist values (45365, 40119, 1, 1, 2500);

-- modify existing taurverus drops
-- decrease sc:erase magic droprate from taurverus (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40242 and mobid = 45341;
-- decrease sc:burning weapon droprate from taurverus (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40258 and mobid = 45341;
-- increase c-zel droprate from taurverus (10000 -> 11000)
update droplist set chance = 11000 where itemid = 240074 and mobid = 45341;
-- increase sb:mass slow droprate from taurverus (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40221 and mobid = 45341;
-- decrease sb:fs droprate from taurverus (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40215 and mobid = 45341;

-- add additional drops to taurverus
-- add sc:triple arrow to taurverus droplist
insert into droplist values (45341, 40240, 1, 1, 2500);

-- modify existing ifrit drops
-- increase hqd droprate from ifrit (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40048 and mobid = 45516;
-- increase hqr droprate from ifrit (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40049 and mobid = 45516;
-- increase nzel droprate from ifrit (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40074 and mobid = 45516;
-- increase ndai droprate from ifrit (25000 -> 35000)
update droplist set chance = 35000 where itemid = 40087 and mobid = 45516;
-- decrease dsc:final burn droprate from ifrit (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40278 and mobid = 45516;

-- add additional drops to ifrit
-- add lvl3 blank to ifrit droplist
insert into droplist values (45516, 40092, 1, 1, 5000);
-- add dsc:double break to ifrit droplist
insert into droplist values (45516, 40275, 1, 1, 5000);

-- modify existing phoenix drops
-- increase ndai droprate from phoenix (375000 -> 500000)
update droplist set chance = 500000 where itemid = 40087 and mobid = 45617;
-- increase bdai droprate from phoenix (150000 -> 200000)
update droplist set chance = 200000 where itemid = 140087 and mobid = 45617;

-- add additional drops to phoenix
-- add sb:g-res to phoenix droplist
insert into droplist values (45617, 40220, 1, 1, 50000);
-- add sb:dex to phoenix droplist
insert into droplist values (45617, 40171, 1, 1, 50000);
-- add sb:fb to phoenix droplist
insert into droplist values (45617, 40170, 1, 1, 50000);
-- add sb:tame to phoenix droplist
insert into droplist values (45617, 40181, 1, 1, 50000);
-- add sb:wb to phoenix droplist
insert into droplist values (45617, 40172, 1, 1, 50000);
-- add sb:gheal to phoenix droplist
insert into droplist values (45617, 40180, 1, 1, 50000);
-- add sb:haste to phoenix droplist
insert into droplist values (45617, 40188, 1, 1, 50000);
-- add sb:heal pledge to phoenix droplist
insert into droplist values (45617, 40194, 1, 1, 50000);

-- modify existing ancient giant drops
-- increase bzel droprate from ancient giant (250000 -> 750000)
update droplist set chance = 750000 where itemid = 140074 and mobid = 45610;
-- increase bdai droprate from ancient giant (125000 -> 500000)
update droplist set chance = 500000 where itemid = 140087 and mobid = 45610;
-- increase ndai droprate from ancient giant (375000 -> 750000)
update droplist set chance = 750000 where itemid = 40087 and mobid = 45610;

-- add additional drops to ancient giant
-- add sb:meditate to ancient giant droplist
insert into droplist values (45610, 40177, 1, 1, 50000);
-- add sc:earth bind to ancient giant droplist
insert into droplist values (45610, 40249, 1, 1, 10000);
-- add ebony to ancient giant droplist
insert into droplist values (45610, 40007, 1, 1, 50000);

-- modify existing crocodile  drops
-- increase nzel droprate from crocodile (10000 -> 120000)
update droplist set chance = 120000 where itemid = 40074 and mobid = 45338;
-- increase sc:water life droprate from crocodile (2000 -> 5000)
update droplist set chance = 5000 where itemid = 40253 and mobid = 45338;

-- add sb:adv to laia droplist
insert into droplist values (45677, 40224, 1, 1, 1000);

-- add additional drops to grim reaper
-- add 2hs to grim reaper droplist
insert into droplist values (45673, 52, 1, 1, 300000);
-- add dice dagger to grim reaper droplist
insert into droplist values (45673, 200002, 1, 1, 300000);
-- add devil's blood to grim reaper droplist
insert into droplist values (45673, 40031, 1, 1, 300000);
-- add rotc to grim reaper droplist
insert into droplist values (45673, 20288, 1, 1, 2500);
-- add kedo to grim reaper droplist
insert into droplist values (45673, 84, 1, 1, 500);
-- add bkat to grim reaper droplist
insert into droplist values (45673, 100041, 1, 1, 300000);
-- add b-kedo to grim reaper droplist
insert into droplist values (45673, 100084, 1, 1, 250);

-- modify existing knight vlad drops
-- increase bzel droprate from knight vlad (50000 -> 300000)
update droplist set chance = 300000 where itemid = 140074 and mobid = 45618;
-- increase bdai droprate from knight vlad (25000 -> 150000)
update droplist set chance = 150000 where itemid = 140087 and mobid = 45618;
-- increase ndai droprate from knight vlad (150000 -> 300000)
update droplist set chance = 300000 where itemid = 40087 and mobid = 45618;

-- add additional drops to knight vlad
-- add czel to knight vlad droplist
insert into droplist values (45618, 240074, 1, 1, 300000);
-- add cdai to knight vlad droplist
insert into droplist values (45618, 240087, 1, 1, 300000);
-- add rotc to knight vlad droplist
insert into droplist values (45618, 20288, 1, 1, 2000);
-- add ropc to knight vlad droplist
insert into droplist values (45618, 20281, 1, 1, 2500);
-- add sb:res to knight vlad droplist
insert into droplist values (45618, 40206, 1, 1, 10000);

-- modify existing lich drops
-- increase silver cloak droprate from lich (1000 -> 2500)
update droplist set chance = 2500 where itemid = 20074 and mobid = 45672;
-- increase lich robe droprate from lich (100 -> 800)
update droplist set chance = 800 where itemid = 20107 and mobid = 45672;
-- increase ndai droprate from lich (150000 -> 300000)
update droplist set chance = 300000 where itemid = 40087 and mobid = 45672;

-- add additional drops to lich
-- add sb:vt to lich droplist 
insert into droplist values (45672, 40173, 1, 1, 50000);
-- add sb:c-p to lich droplist 
insert into droplist values (45672, 40178, 1, 1, 50000);
-- add sb:mana drain to lich droplist 
insert into droplist values (45672, 40184, 1, 1, 50000);
-- add dice dagger to lich droplist 
insert into droplist values (45672, 2, 1, 1, 50000);
-- add sb:ab to lich droplist 
insert into droplist values (45672, 40223, 1, 1, 2000);
-- add bkat to lich droplist 
insert into droplist values (45672, 100041, 1, 1, 50000);

-- modify existing iris drops
-- increase bdai droprate from iris (150000 -> 300000)
update droplist set chance = 300000 where itemid = 140087 and mobid = 45654;

-- add additional drops to iris
-- add blind pot to iris droplist 
insert into droplist values (45654, 40025, 1, 1, 500000);
-- add dice dagger to iris droplist 
insert into droplist values (45654, 2, 1, 1, 50000);
-- add maple to iris droplist 
insert into droplist values (45654, 40008, 1, 1, 300000);
-- add pine to iris droplist 
insert into droplist values (45654, 40006, 1, 1, 300000);
-- add sb:ej to iris droplist 
insert into droplist values (45654, 40175, 1, 1, 50000);
-- add sb:str to iris droplist 
insert into droplist values (45654, 40187, 1, 1, 50000);
-- add sc:fire weapon to iris droplist 
insert into droplist values (45654, 40256, 1, 1, 25000);
-- add nkat to iris droplist 
insert into droplist values (45654, 41, 1, 1, 50000);
-- add 2hs to iris droplist 
insert into droplist values (45654, 52, 1, 1, 50000);
-- add sb:eq to iris droplist 
insert into droplist values (45654, 40207, 1, 1, 25000);
-- add sb:rc to iris droplist 
insert into droplist values (45654, 40182, 1, 1, 50000);
-- add sc:burning weapon to iris droplist 
insert into droplist values (45654, 40258, 1, 1, 10000);
-- add sb:wb to iris droplist 
insert into droplist values (45654, 40172, 1, 1, 50000);
-- add sc:bless of fire to iris droplist 
insert into droplist values (45654, 40257, 1, 1, 5000);
-- add roa to iris droplist 
insert into droplist values (45654, 20302, 1, 1, 3000);
-- add roe to iris droplist 
insert into droplist values (45654, 20300, 1, 1, 3000);
-- add rof to iris droplist 
insert into droplist values (45654, 20304, 1, 1, 1500);
-- add row to iris droplist 
insert into droplist values (45654, 20285, 1, 1, 1500);
-- add ropc to iris droplist 
insert into droplist values (45654, 20281, 1, 1, 1000);

-- modify existing mummy lord drops
-- decrease row droprate from mummy lord (10000 -> 1000)
update droplist set chance = 1000 where itemid = 20285 and mobid = 45653;
-- decrease roe droprate from mummy lord (10000 -> 4500)
update droplist set chance = 4500 where itemid = 20300 and mobid = 45653;
-- decrease rof droprate from mummy lord (10000 -> 1000)
update droplist set chance = 1000 where itemid = 20304 and mobid = 45653;
-- decrease roa droprate from mummy lord (10000 -> 1000)
update droplist set chance = 1000 where itemid = 20302 and mobid = 45653;
-- increase bdai droprate from mummy lord (150000 -> 300000)
update droplist set chance = 300000 where itemid = 140087 and mobid = 45653;
-- increase czel droprate from mummy lord (50000 -> 300000)
update droplist set chance = 300000 where itemid = 240074 and mobid = 45653;
-- increase cdai droprate from mummy lord (25000 -> 300000)
update droplist set chance = 300000 where itemid = 240087 and mobid = 45653;

-- add additional drops to mummy lord
-- add ropc to mummy lord droplist 
insert into droplist values (45653, 20281, 1, 1, 500);
-- add tsu to mummy lord droplist 
insert into droplist values (45653, 57, 1, 1, 2000);
-- add obom to mummy lord droplist 
insert into droplist values (45653, 20307, 1, 1, 15000);
-- add bom to mummy lord droplist 
insert into droplist values (45653, 20319, 1, 1, 7000);
-- add 2hs to mummy lord droplist 
insert into droplist values (45653, 52, 1, 1, 100000);
-- add blind pot to mummy lord droplist 
insert into droplist values (45653, 40025, 1, 1, 300000);
-- add brave pot to mummy lord droplist 
insert into droplist values (45653, 40014, 1, 1, 150000);
-- add wis pot to mummy lord droplist 
insert into droplist values (45653, 40016, 1, 1, 150000);
-- add dice dagger to mummy lord droplist 
insert into droplist values (45653, 2, 1, 1, 300000);
-- add maple to mummy lord droplist 
insert into droplist values (45653, 40008, 1, 1, 100000);
-- add pine to mummy lord droplist 
insert into droplist values (45653, 40006, 1, 1, 100000);
-- add res scroll to mummy lord droplist 
insert into droplist values (45653, 40089, 1, 1, 100000);

-- modify existing cougar drops
-- increase dai droprate from cougar (100000 -> 300000)
update droplist set chance = 300000 where itemid = 140087 and mobid = 45652;
-- increase nzel droprate from cougar (100000 -> 300000)
update droplist set chance = 300000 where itemid = 40074 and mobid = 45652;
-- increase ndai droprate from cougar (100000 -> 300000)
update droplist set chance = 300000 where itemid = 40087 and mobid = 45652;

-- add additional drops to cougar
-- add rosc to cougar droplist 
insert into droplist values (45652, 20284, 1, 1, 5000);
-- add roe to cougar droplist 
insert into droplist values (45652, 20300, 1, 1, 10000);
-- add tsu to cougar droplist 
insert into droplist values (45652, 57, 1, 1, 2000);
-- add blind pot to cougar droplist 
insert into droplist values (45652, 40025, 1, 1, 300000);
-- add brave pot to cougar droplist 
insert into droplist values (45652, 40014, 1, 1, 150000);
-- add wis pot to cougar droplist 
insert into droplist values (45652, 40016, 1, 1, 150000);
-- add dice dagger to cougar droplist 
insert into droplist values (45652, 2, 1, 1, 300000);
-- add maple to cougar droplist 
insert into droplist values (45652, 40008, 1, 1, 100000);
-- add pine to cougar droplist 
insert into droplist values (45652, 40006, 1, 1, 100000);
-- add res scroll to cougar droplist 
insert into droplist values (45652, 40089, 1, 1, 100000);
-- add nkat to cougar droplist 
insert into droplist values (45652, 41, 1, 1, 50000);
-- add lvl4 blank to cougar droplist 
insert into droplist values (45652, 40093, 1, 1, 100000);
-- add lvl5 blank to cougar droplist 
insert into droplist values (45652, 40094, 1, 1, 100000);

-- modify existing zombie lord drops
-- decrease rosc droprate from zombie lord (10000 -> 8000)
update droplist set chance = 8000 where itemid = 20284 and mobid = 45650;
-- decrease row droprate from zombie lord (20000 -> 5000)
update droplist set chance = 5000 where itemid = 20285 and mobid = 45650;
-- decrease roe droprate from zombie lord (40000 -> 8000)
update droplist set chance = 8000 where itemid = 20300 and mobid = 45650;
-- decrease roa droprate from zombie lord (10000 -> 2500)
update droplist set chance = 2500 where itemid = 20302 and mobid = 45650;
-- decrease rof droprate from zombie lord (10000 -> 2500)
update droplist set chance = 2500 where itemid = 20304 and mobid = 45650;
-- increase bdai droprate from zombie lord (100000 -> 200000)
update droplist set chance = 200000 where itemid = 140087 and mobid = 45650;

-- add additional drops to zombie lord
-- add dice dagger to zombie lord droplist 
insert into droplist values (45650, 2, 1, 1, 50000);
-- add nkat to zombie lord droplist 
insert into droplist values (45650, 41, 1, 1, 50000);
-- add dsc:double break to zombie lord droplist 
insert into droplist values (45650, 40275, 1, 1, 5000);
-- add dsc:final burn to zombie lord droplist 
insert into droplist values (45650, 40278, 1, 1, 5000);
-- add ropc to zombie lord droplist 
insert into droplist values (45650, 20281, 1, 1, 500);

-- add additional drops to demon
-- add res scroll to demon droplist 
insert into droplist values (45649, 40089, 1, 1, 100000);
-- add sb:fb to demon droplist 
insert into droplist values (45649, 40170, 1, 1, 25000);
-- add sb:sb to demon droplist 
insert into droplist values (45649, 40191, 1, 1, 25000);
-- add sb:vt to demon droplist 
insert into droplist values (45649, 40173, 1, 1, 25000);
-- add g-haste pot to demon droplist 
insert into droplist values (45649, 40018, 1, 1, 300000);
-- add sb:tame to demon droplist 
insert into droplist values (45649, 40181, 1, 1, 25000);
-- add ropc to demon droplist 
insert into droplist values (45649, 20281, 1, 1, 500);
-- add sb:res to demon droplist 
insert into droplist values (45649, 40206, 1, 1, 10000);
-- add bkat to demon droplist 
insert into droplist values (45649, 100041, 1, 1, 25000);

-- modify existing chaos drops
-- increase head of chaos droprate from chaos (200000 -> 1000000)
update droplist set chance = 1000000 where itemid = 40719 and mobid = 45625;

-- modify existing giant ant queen drops
-- increase gold wing droprate from giant ant queen (100 -> 250)
update droplist set chance = 250 where itemid = 20049 and mobid = 45614;
-- increase silver wing droprate from giant ant queen (100 -> 250)
update droplist set chance = 250 where itemid = 20050 and mobid = 45614;
-- increase dk boots droprate from giant ant queen (1000 -> 2500)
update droplist set chance = 2500 where itemid = 20198 and mobid = 45614;

-- add additional drops to giant ant queen
-- add blue pot to giant ant queen droplist 
insert into droplist values (45614, 40015, 1, 1, 300000);
-- add sb:ej to giant ant queen droplist 
insert into droplist values (45614, 40175, 1, 1, 50000);

-- add additional drops to vampire
-- add dice dagger to vampire droplist 
insert into droplist values (45606, 200002, 1, 1, 50000);
-- add sb:c-m to vampire droplist 
insert into droplist values (45606, 40176, 1, 1, 50000);
-- add 2hs to vampire droplist 
insert into droplist values (45606, 52, 1, 1, 50000);

-- modify existing ice queen drops
-- increase sc:nb droprate from ice queen (5000 -> 20000)
update droplist set chance = 20000 where itemid = 40255 and mobid = 45609;
-- increase iq staff droprate from ice queen (100 -> 250)
update droplist set chance = 250 where itemid = 111 and mobid = 45609;
-- increase k-xbow droprate from ice queen (100 -> 150)
update droplist set chance = 150 where itemid = 189 and mobid = 45609;

-- add additional drops to ice queen
-- add bpm to ice queen droplist 
insert into droplist values (45609, 20128, 1, 1, 50000);
-- add nkat to ice queen droplist 
insert into droplist values (45609, 41, 1, 1, 150000);
-- add sb:c-m to ice queen droplist 
insert into droplist values (45609, 40176, 1, 1, 50000);
-- add sb:darkness to ice queen droplist 
insert into droplist values (45609, 40185, 1, 1, 50000);
-- add tqd to ice queen droplist 
insert into droplist values (45609, 40052, 1, 1, 2500);
-- add cg to ice queen droplist 
insert into droplist values (45609, 20175, 1, 1, 5000);
-- add bkat to ice queen droplist 
insert into droplist values (45609, 100041, 1, 1, 50000);

-- modify existing reaper drops
-- increase bzel droprate from reaper (5000 -> 20000)
update droplist set chance = 20000 where itemid = 140087 and mobid = 45590;

-- modify existing death knight drops
-- increase dk fire sword droprate from death knight (100 -> 150)
update droplist set chance = 150 where itemid = 58 and mobid = 45601;
-- increase ronde edo droprate from death knight (100 -> 150)
update droplist set chance = 150 where itemid = 76 and mobid = 45601;
-- increase dk helm droprate from death knight (100 -> 500)
update droplist set chance = 500 where itemid = 20010 and mobid = 45601;
-- increase dk armor droprate from death knight (100 -> 500)
update droplist set chance = 500 where itemid = 20100 and mobid = 45601;
-- increase bzel droprate from death knight (50000 -> 300000)
update droplist set chance = 300000 where itemid = 140074 and mobid = 45601;
-- increase bdai droprate from death knight (25000 -> 300000)
update droplist set chance = 300000 where itemid = 140087 and mobid = 45601;
-- increase ddai droprate from death knight (150000 -> 300000)
update droplist set chance = 300000 where itemid = 40087 and mobid = 45601;

-- add additional drops to death knight
-- add sb:wb to death knight droplist 
insert into droplist values (45601, 40172, 1, 1, 50000);
-- add sb:eq to death knight droplist 
insert into droplist values (45601, 40207, 1, 1, 50000);
-- add int ammy to death knight droplist 
insert into droplist values (45601, 20266, 1, 1, 2500);
-- add rotc to death knight droplist 
insert into droplist values (45601, 20288, 1, 1, 500);

-- modify existing greater minotaur drops
-- increase ndai droprate from greater minotaur (150000 -> 200000)
update droplist set chance = 200000 where itemid = 40087 and mobid = 45584;

-- add additional drops to greater minotaur
-- add sb:wb to greater minotaur droplist 
insert into droplist values (45584, 40172, 1, 1, 50000);
-- add sb:ej  to greater minotaur droplist 
insert into droplist values (45584, 40175, 1, 1, 50000);

-- modify existing beleth drops
-- increase beleth boots droprate from beleth (100 -> 150)
update droplist set chance = 150 where itemid = 20204 and mobid = 45583;
-- increase beleth staff droprate from beleth (100 -> 150)
update droplist set chance = 150 where itemid = 110 and mobid = 45583;
-- increase bzel droprate from beleth (50000 -> 200000)
update droplist set chance = 200000 where itemid = 140074 and mobid = 45583;
-- increase bdai droprate from beleth (25000 -> 100000)
update droplist set chance = 100000 where itemid = 140087 and mobid = 45583;

-- add additional drops to beleth
-- add sb:erupt to beleth droplist 
insert into droplist values (45583, 40190, 1, 1, 50000);
-- add sb:fb to beleth droplist 
insert into droplist values (45583, 40170, 1, 1, 50000);
-- add sb:dex to beleth droplist 
insert into droplist values (45583, 40171, 1, 1, 50000);
-- add sb:vt to beleth droplist 
insert into droplist values (45583, 40173, 1, 1, 50000);
-- add rosc to beleth droplist 
insert into droplist values (45583, 20284, 1, 1, 500);

-- modify existing baphomet drops
-- increase nzel droprate from baphomet (150000 -> 300000)
update droplist set chance = 300000 where itemid = 40074 and mobid = 45573;
-- increase ndai droprate from baphomet (75000 -> 150000)
update droplist set chance = 150000 where itemid = 40087 and mobid = 45573;
-- increase bdai droprate from baphomet (75000 -> 100000)
update droplist set chance = 100000 where itemid = 140087 and mobid = 45573;

-- remove sb:summon from baphomet droplist
delete from droplist where itemid = 40196 and mobid = 45573;

-- add additional drops to baphomet
-- add sb:cz to baphomet droplist 
insert into droplist values (45573, 40186, 1, 1, 50000);
-- add sb:erupt to baphomet droplist 
insert into droplist values (45573, 40190, 1, 1, 50000);
-- add sb:vt to baphomet droplist 
insert into droplist values (45573, 40173, 1, 1, 50000);
-- add sb:ej to baphomet droplist 
insert into droplist values (45573, 40175, 1, 1, 50000);
-- add sb:eq to baphomet droplist 
insert into droplist values (45573, 40207, 1, 1, 50000);

-- modify existing seer drops
-- increase ndai droprate from seer (350000 -> 500000)
update droplist set chance = 500000 where itemid = 40087 and mobid = 45547;
-- increase bdai droprate from seer (150000 -> 300000)
update droplist set chance = 300000 where itemid = 140087 and mobid = 45547;

-- add additional drops to seer
-- add daimond to seer droplist 
insert into droplist values (45547, 40044, 1, 1, 300000);
-- add hqd to seer droplist 
insert into droplist values (45547, 40048, 1, 1, 150000);
-- add hqs to seer droplist 
insert into droplist values (45547, 40050, 1, 1, 150000);
-- add tqd to seer droplist 
insert into droplist values (45547, 40052, 1, 1, 8000);
-- add tqs to seer droplist 
insert into droplist values (45547, 40054, 1, 1, 12000);
-- add sb:i2h to seer droplist 
insert into droplist values (45547, 40213, 1, 1, 5000);

-- modify existing caspa drops
-- decrease ropc droprate from caspa (5000 -> 500)
update droplist set chance = 500 where itemid = 20281 and mobid = 45488;
-- decrease rosc droprate from caspa (5000 -> 2500)
update droplist set chance = 2500 where itemid = 20284 and mobid = 45488;
-- increase bzel droprate from caspa (10000 -> 12000)
update droplist set chance = 12000 where itemid = 140074 and mobid = 45488;
-- increase bdai droprate from caspa (5000 -> 7000)
update droplist set chance = 7000 where itemid = 140087 and mobid = 45488;

-- modify existing merkyor drops
-- increase sema merk droprate from merkyor (100 -> 150)
update droplist set chance = 150 where itemid = 20018 and mobid = 45497;
-- decrease ropc droprate from merkyor (5000 -> 500)
update droplist set chance = 500 where itemid = 20281 and mobid = 45497;
-- decrease rosc droprate from merkyor (5000 -> 2500)
update droplist set chance = 2500 where itemid = 20284 and mobid = 45497;
-- increase bzel droprate from merkyor (10000 -> 12000)
update droplist set chance = 12000 where itemid = 140074 and mobid = 45497;
-- increase bdai droprate from merkyor (5000 -> 7000)
update droplist set chance = 7000 where itemid = 140087 and mobid = 45497;

-- modify existing sema drops
-- increase sema cap droprate from sema (100 -> 150)
update droplist set chance = 150 where itemid = 20029 and mobid = 45464;
-- decrease rosc droprate from sema (5000 -> 2500)
update droplist set chance = 2500 where itemid = 20284 and mobid = 45464;
-- increase bzel droprate from sema (10000 -> 12000)
update droplist set chance = 12000 where itemid = 140074 and mobid = 45464;
-- increase bdai droprate from sema (5000 -> 7000)
update droplist set chance = 7000 where itemid = 140087 and mobid = 45464;

-- modify existing baltuzar drops
-- increase balt cap droprate from baltuzar (100 -> 150)
update droplist set chance = 150 where itemid = 20025 and mobid = 45473;
-- decrease rosc droprate from baltuzar (5000 -> 2500)
update droplist set chance = 2500 where itemid = 20284 and mobid = 45473;
-- increase cop droprate from baltuzar (50000 -> 100000)
update droplist set chance = 100000 where itemid = 20063 and mobid = 45473;
-- increase bzel droprate from baltuzar (10000 -> 12000)
update droplist set chance = 12000 where itemid = 140074 and mobid = 45473;
-- increase bdai droprate from baltuzar (5000 -> 7000)
update droplist set chance = 7000 where itemid = 140087 and mobid = 45473;



-- update 15 

-- increase sb:gres droprate from medusa
update droplist set chance = 5000 where mobid = 45380 and itemid = 40220;



-- update 16

-- reduce bw staff droprate (5000 -> 1500)
update droplist set chance = 1500 where itemid = 116 and mobid in (45405, 45425);

-- increase hbow droprate from fire archer (10000 -> 50000)
update droplist set chance = 50000 where itemid = 169 and mobid = 45291;

-- modify existing demon drops
-- increase demon helmet droprate from demon (1000 -> 5000)
update droplist set chance = 5000 where itemid = 20009 and mobid = 45649;
-- increase demon armor droprate from demon (2000 -> 10000)
update droplist set chance = 10000 where itemid = 20099 and mobid = 45649;
-- increase demon staff droprate from demon (100 -> 150)
update droplist set chance = 150 where itemid = 108 and mobid = 45649;
-- increase tsu droprate from demon (500 -> 1000)
update droplist set chance = 1000 where itemid = 57 and mobid = 45649;
-- increase bkat droprate from demon (25000 -> 50000)
update droplist set chance = 50000 where itemid = 100041 and mobid = 45649;
-- increase bdai droprate from demon (150000 -> 300000)
update droplist set chance = 300000 where itemid = 140087 and mobid = 45649;

-- add btsu to demon droplist
insert into droplist values (45649, 100057, 1, 1, 250);

-- modify existing mutant ramia drops
-- increase cure pot droprate from mutant ramia (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40017 and mobid = 45332;
-- increase ndai droprate from mutant ramia (5000 -> 20000)
update droplist set chance = 20000 where itemid = 40087 and mobid = 45332;
-- increase btele droprate from mutant ramia (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45332;

-- modify existing mutant arachnevil elder drops
-- increase cure pot droprate from mutant arachnevil elder (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40017 and mobid = 45348;
-- increase nzel droprate from mutant arachnevil elder (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45348;
-- increase ndai droprate from mutant arachnevil elder (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40087 and mobid = 45348;
-- increase btele droprate from mutant arachnevil elder (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45348;

-- add additional drops to mutant arachnevil elder
-- add dsc:venom resist to mutant arachnevil elder droplist 
insert into droplist values (45348, 40273, 1, 1, 10000);

-- modify existing medusa drops
-- increase nzel droprate from medusa (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45380;
-- increase czel droprate from medusa (5000 -> 10000)
update droplist set chance = 10000 where itemid = 240074 and mobid = 45380;
-- increase wis pot droprate from medusa (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40016 and mobid = 45380;
-- increase res scroll droprate from medusa (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40089 and mobid = 45380;
-- increase cdai droprate from medusa (2500 -> 5000)
update droplist set chance = 5000 where itemid = 240087 and mobid = 45380;
-- increase sb:i2h droprate from medusa (1000 -> 1500)
update droplist set chance = 1500 where itemid = 40213 and mobid = 45380;

-- add additional drops to medusa 
-- add cure pot to medusa droplist 
insert into droplist values (45380, 40017, 1, 1, 50000);
-- add sb:cp to medusa droplist 
insert into droplist values (45380, 40178, 1, 1, 25000);
-- add sb:darkness to medusa droplist 
insert into droplist values (45380, 40185, 1, 1, 10000);

-- modify existing cimaera drops
-- increase wis pot droprate from cimaera (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40016 and mobid = 45407;

-- add additional drops to cimaera
-- add nzel to cimaera droplist 
insert into droplist values (45407, 40074, 1, 1, 10000);
-- add shielf of medusa to cimaera droplist 
insert into droplist values (45407, 20227, 1, 1, 500);

-- modify existing toi dire wolf drops
-- increase wis pot droprate from toi dire wolf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40016 and mobid = 45409;
-- decrease nprat droprate from toi dire wolf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40119 and mobid = 45409;
-- decrease btele droprate from toi dire wolf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45409;

-- add additional drops to toi dire wolf
-- add meat to toi dire wolf droplist 
insert into droplist values (45409, 40056, 1, 1, 50000);
-- add haste pot to toi dire wolf droplist 
insert into droplist values (45409, 40013, 1, 1, 25000);
-- add brave pot to toi dire wolf droplist 
insert into droplist values (45409, 40014, 1, 1, 80000);
-- add obom to toi dire wolf droplist 
insert into droplist values (45409, 20307, 1, 1, 1000);
-- add sb:haste to toi dire wolf droplist 
insert into droplist values (45409, 40188, 1, 1, 10000);
-- add sb:str to toi dire wolf droplist 
insert into droplist values (45409, 40187, 1, 1, 10000);

-- remove ring mail from dancing sword droplist
delete from droplist where itemid = 20096 and mobid = 45386;
-- remove scimitar from dancing sword droplist
delete from droplist where itemid = 27 and mobid = 45386;

-- add additional drops to dancing sword
-- add blue pot to dancing sword droplist 
insert into droplist values (45386, 40015, 1, 1, 50000);
-- add red pot to dancing sword droplist 
insert into droplist values (45386, 40010, 1, 1, 50000);
-- add c-red pot to dancing sword droplist 
insert into droplist values (45386, 40019, 1, 1, 50000);
-- add nkat to dancing sword droplist 
insert into droplist values (45386, 41, 1, 1, 7500);
-- add sb:haste to dancing sword droplist 
insert into droplist values (45386, 40188, 1, 1, 10000);
-- add sb:dex to dancing sword droplist 
insert into droplist values (45386, 40171, 1, 1, 10000);
-- add sb:wb to dancing sword droplist 
insert into droplist values (45386, 40172, 1, 1, 10000);
-- add id scroll to dancing sword droplist 
insert into droplist values (45386, 40098, 1, 1, 50000);
-- add sb:bless weapon to dancing sword droplist 
insert into droplist values (45386, 40193, 1, 1, 10000);
-- add 2hs to dancing sword droplist 
insert into droplist values (45386, 52, 1, 1, 7500);
-- add sb:create magical weapon to dancing sword droplist 
insert into droplist values (45386, 40218, 1, 1, 100);
-- add btele to dancing sword droplist 
insert into droplist values (45386, 140100, 1, 1, 50000);

-- modify existing wicked beholder drops
-- increase wis pot droprate from wicked beholder (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40016 and mobid = 45406;
-- increase cdai droprate from wicked beholder (2500 -> 5000)
update droplist set chance = 5000 where itemid = 240087 and mobid = 45406;

-- add additional drops to wicked beholder
-- add sb:ab to wicked beholder droplist 
insert into droplist values (45406, 40223, 1, 1, 100);
-- add sc:r2n to wicked beholder droplist 
insert into droplist values (45406, 40237, 1, 1, 2500);

-- modify existing wicked mimic drops
-- increase brave pot droprate from wicked mimic (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45399;
-- increase blue pot droprate from wicked mimic (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40015 and mobid = 45399;
-- increase nzel droprate from wicked mimic (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45399;

-- modify existing horrific fire egg drops
-- increase blue pot droprate from horrific fire egg (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45384;
-- increase poly scroll droprate from horrific fire egg (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40088 and mobid = 45384;
-- increase nprat droprate from horrific fire egg (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40119 and mobid = 45384;

-- add additional drops to horrific fire egg
-- add sc: fire weapon to horrific fire egg droplist 
insert into droplist values (45384, 40256, 1, 1, 8000);
-- add plate mail to horrific fire egg droplist 
insert into droplist values (45384, 20154, 1, 1, 2500);
-- add esc scroll to horrific fire egg droplist 
insert into droplist values (45384, 40079, 1, 1, 75000);
-- add sb:rc to horrific fire egg droplist 
insert into droplist values (45384, 40182, 1, 1, 10000);

-- modify existing nightmare drops
-- decrease sb:counter detect droprate from nightmare (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40217 and mobid = 45440;
-- decrease sc:triple arrow droprate from nightmare (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40240 and mobid = 45440;
-- increase btele droprate from nightmare (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45440;

-- remove clear pot from nightmare
delete from droplist where itemid = 40018 and mobid = 45440;

-- add additional drops to nightmare 
-- add c-red pot to nightmare droplist 
insert into droplist values (45440, 40019, 1, 1, 50000);
-- add c-clear pot to nightmare droplist 
insert into droplist values (45440, 40021, 1, 1, 50000);
-- add brave pot to nightmare droplist 
insert into droplist values (45440, 40014, 1, 1, 75000);
-- add dsc:final burn to nightmare droplist 
insert into droplist values (45440, 40278, 1, 1, 5000);

-- modify existing horrific cerberus drops
-- increase brave pot droprate from horrific cerberus (50000 -> 200000)
update droplist set chance = 200000 where itemid = 40014 and mobid = 45471;
-- decrease sb:firewall droprate from horrific cerberus (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40203 and mobid = 45471;
-- increase hqr droprate from horrific cerberus (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40049 and mobid = 45471;
-- decrease sc:final burn droprate from horrific cerberus (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40278 and mobid = 45471;
-- increase btele droprate from horrific cerberus (50000 -> 100000)
update droplist set chance = 100000 where itemid = 140100 and mobid = 45471;

-- add additional drops to horrific cerberus
-- add ruby to horrific cerberus droplist 
insert into droplist values (45471, 40045, 1, 1, 75000);
-- add sb:fb to horrific cerberus droplist 
insert into droplist values (45471, 40170, 1, 1, 15000);
-- add tqr to horrific cerberus droplist 
insert into droplist values (45471, 40053, 1, 1, 10000);

-- modify existing lesser demon drops
-- decrease rof droprate from lesser demon (1000 -> 500)
update droplist set chance = 500 where itemid = 20304 and mobid = 45481;
-- decrease int ammy droprate from lesser demon (1000 -> 750)
update droplist set chance = 750 where itemid = 20266 and mobid = 45481;
-- decrease str ammy droprate from lesser demon (1000 -> 850)
update droplist set chance = 850 where itemid = 20264 and mobid = 45481;
-- decrease demon armor droprate from lesser demon (1000 -> 550)
update droplist set chance = 550 where itemid = 20099 and mobid = 45481;
-- increase blue pot droprate from lesser demon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45481;
-- increase res scroll droprate from lesser demon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40089 and mobid = 45481;
-- increase nzel droprate from lesser demon (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45481;
-- increase ndai droprate from lesser demon (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40087 and mobid = 45481;
-- decrease sb:firewall droprate from lesser demon (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40203 and mobid = 45481;
-- increase sc:erase magic droprate from lesser demon (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40242 and mobid = 45481;
-- increase dsc:final burn droprate from lesser demon (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40278 and mobid = 45481;

-- add additional drops to lesser demon 
-- add sb:fb to lesser demon droplist 
insert into droplist values (45481, 40170, 1, 1, 15000);
-- add pine to lesser demon droplist 
insert into droplist values (45481, 40006, 1, 1, 10000);
-- add wis pot to lesser demon droplist 
insert into droplist values (45481, 40016, 1, 1, 75000);
-- add nkat to lesser demon droplist 
insert into droplist values (45481, 41, 1, 1, 10000);
-- add 2hs to lesser demon droplist 
insert into droplist values (45481, 52, 1, 1, 7500);
-- add dsc:shadow fang to lesser demon droplist 
insert into droplist values (45481, 40277, 1, 1, 5000);
-- add plate mail to lesser demon droplist 
insert into droplist values (45481, 20154, 1, 1, 5000);
-- add cmomr to lesser demon droplist 
insert into droplist values (45481, 20110, 1, 1, 2500);
-- add cpm to lesser demon droplist 
insert into droplist values (45481, 20128, 1, 1, 500);
-- add obom to lesser demon droplist 
insert into droplist values (45481, 20307, 1, 1, 2500);
-- add obos to lesser demon droplist 
insert into droplist values (45481, 20308, 1, 1, 2500);
-- add sb:i2h to lesser demon droplist 
insert into droplist values (45481, 40213, 1, 1, 1000);
-- add bom to lesser demon droplist 
insert into droplist values (45481, 20319, 1, 1, 1000);
 
-- modify existing toi ifrit drops
-- increase blue pot droprate from toi ifrit (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40015 and mobid = 45515;
-- decrease sc:fire weapon droprate from toi ifrit (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40256 and mobid = 45515;
-- decrease sc:bless of fire droprate from toi ifrit (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40257 and mobid = 45515;

-- add additional drops to toi ifrit
-- add hqr to toi ifrit droplist 
insert into droplist values (45515, 40049, 1, 1, 50000);
-- add hqd to toi ifrit droplist 
insert into droplist values (45515, 40048, 1, 1, 50000);
-- add nkat to toi ifrit droplist 
insert into droplist values (45515, 41, 1, 1, 25000);
-- add rof to toi ifrit droplist 
insert into droplist values (45515, 20304, 1, 1, 250);
-- add nzel to toi ifrit droplist 
insert into droplist values (45515, 40074, 1, 1, 50000);
-- add bzel to toi ifrit droplist 
insert into droplist values (45515, 140074, 1, 1, 2500);

-- modify existing raging skeleton axeman drops
-- increase nzel droprate from raging skeleton axeman (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45402;
-- increase ndai droprate from raging skeleton axeman (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40087 and mobid = 45402;

-- add sb:dex to raging skeleton axeman droplist 
insert into droplist values (45402, 40171, 1, 1, 1000);

-- modify existing raging ghoul drops
-- increase brave pot droprate from raging ghoul (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40014 and mobid = 45454;
-- increase nzel droprate from raging ghoul (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45454;
-- increase res scroll droprate from raging ghoul (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40089 and mobid = 45454;
-- increase wis pot droprate from raging ghoul (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40016 and mobid = 45454;
-- increase btele droprate from raging ghoul (50000 -> 150000)
update droplist set chance = 150000 where itemid = 140100 and mobid = 45454;

-- modify existing raging skeleton pike drops
-- increase brave pot droprate from raging skeleton pike (50000 -> 120000)
update droplist set chance = 120000 where itemid = 40014 and mobid = 45403;
-- increase nzel droprate from raging skeleton pike (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40074 and mobid = 45403;

-- modify existing raging spartoi drops
-- increase homr droprate from raging spartoi (10000 -> 50000)
update droplist set chance = 50000 where itemid = 20011 and mobid = 45455;
-- increase nzel droprate from raging spartoi (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40074 and mobid = 45455;
-- increase poly scroll droprate from raging spartoi (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40088 and mobid = 45455;

-- add additional drops to raging spartoi
-- add ndai to raging spartoi droplist 
insert into droplist values (45455, 40087, 1, 1, 5000);

-- modify existing raging skeleton marksman drops
-- increase brave pot droprate from raging skeleton marksman (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45494;
-- decrease sc:windshot droprate from raging skeleton marksman (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40260 and mobid = 45494;
-- increase ndai droprate from raging skeleton marksman (5000 -> 8000)
update droplist set chance = 8000 where itemid = 40087 and mobid = 45494;

-- add additional drops to raging skeleton marksman
-- add wis pot to raging skeleton marksman droplist 
insert into droplist values (45494, 40016, 1, 1, 150000);
-- add nzel to raging skeleton marksman droplist 
insert into droplist values (45494, 40074, 1, 1, 25000);

-- modify existing raging skeleton fighter drops
-- increase ghaste droprate from raging skeleton fighter (50000 -> 100000)
update droplist set chance = 1000000 where itemid = 40018 and mobid = 45493;
-- increase ndai droprate from raging skeleton fighter (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40087 and mobid = 45493;
-- increase bzel droprate from raging skeleton fighter (5000 -> 6000)
update droplist set chance = 6000 where itemid = 140074 and mobid = 45493;

-- add additional drops to raging skeleton fighter
-- add nzel to raging skeleton fighter droplist 
insert into droplist values (45493, 40074, 1, 1, 20000);

-- modify existing fire necromancer drops
-- increase maple droprate from fire necromancer (50000 -> 120000)
update droplist set chance = 120000 where itemid = 40008 and mobid = 45480;
-- increase pine droprate from fire necromancer (50000 -> 120000)
update droplist set chance = 120000 where itemid = 40006 and mobid = 45480;
-- increase bzel droprate from fire necromancer (5000 -> 7500)
update droplist set chance = 7500 where itemid = 140074 and mobid = 45480;
-- increase bdai droprate from fire necromancer (2500 -> 3500)
update droplist set chance = 3500 where itemid = 140087 and mobid = 45480;
-- increase 51f droprate from fire necromancer (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40108 and mobid = 45480;

-- add additional drops to fire necromancer
-- add ruby to fire necromancer droplist 
insert into droplist values (45480, 40045, 1, 1, 150000);
-- add blue pot to fire necromancer droplist 
insert into droplist values (45480, 40015, 1, 1, 100000);
-- add tqr to fire necromancer droplist 
insert into droplist values (45480, 40053, 1, 1, 75000);

-- modify existing bone dragon drops
-- increase diamond, ruby, sapphire, emerald droprate from bone dragon (50000 -> 75000)
update droplist set chance = 75000 where itemid in (40044, 40045, 40046, 40047) and mobid = 45522;
-- increase hqd, tqr, hqs, hqe droprate from bone dragon (10000 -> 50000)
update droplist set chance = 50000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45522;
-- increase tqd, tqs, tqr, tqe droprate from bone dragon (10000 -> 12500)
update droplist set chance = 12500 where itemid in (40052, 40053, 40054, 40055) and mobid = 45522;
-- increase 51f droprate from bone dragon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40108 and mobid = 45522;

-- add additional drops to bone dragon
-- add blue pot to bone dragon droplist 
insert into droplist values (45522, 40015, 1, 1, 150000);
-- add sb:dex to bone dragon droplist 
insert into droplist values (45522, 40171, 1, 1, 25000);
-- add sb:mana drain to bone dragon droplist 
insert into droplist values (45522, 40184, 1, 1, 25000);
-- add sb:weakness to bone dragon droplist 
insert into droplist values (45522, 40192, 1, 1, 25000);
-- add btele to bone dragon droplist 
insert into droplist values (45522, 140100, 1, 1, 150000);

-- add additional drops to cursed elmore wizard 
-- add g-haste pot to cursed elmore wizard droplist 
insert into droplist values (45506, 40018, 1, 1, 50000);
-- add cure pot to cursed elmore wizard droplist 
insert into droplist values (45506, 40017, 1, 1, 50000);
-- add blue pot to cursed elmore wizard droplist 
insert into droplist values (45506, 40015, 1, 1, 50000);

-- modify existing cursed elmore general drops
-- increase brave pot droprate from cursed elmore general (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45541;
-- increase blue pot droprate from cursed elmore general (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40015 and mobid = 45541;
-- increase wafer droprate from cursed elmore general (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40068 and mobid = 45541;

-- add additional drops to cursed elmore general
-- add cure pot pot to cursed elmore general droplist 
insert into droplist values (45541, 40017, 1, 1, 25000);

-- modify existing dark lycanthrope drops
-- increase pine droprate from dark lycanthrope (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40006 and mobid = 45485;
-- increase maple droprate from dark lycanthrope (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40008 and mobid = 45485;

-- modify existing cruel snow tiger drops
-- increase brave pot droprate from cruel snow tiger (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40014 and mobid = 45528;
-- increase nzel droprate from cruel snow tiger (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45528;
-- increase ndai droprate from cruel snow tiger (5000 -> 12000)
update droplist set chance = 12000 where itemid = 40087 and mobid = 45528;

-- add additional drops to cruel snow tiger
-- add maple to cruel snow tiger droplist 
insert into droplist values (45528, 40008, 1, 1, 50000);

-- modify existing spirit taurverus of fire drops
-- increase wis pot droprate from spirit taurverus of fire (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40016 and mobid = 45520;
-- increase nzel droprate from spirit taurverus of fire (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40074 and mobid = 45520;
-- increase ndai droprate from spirit taurverus of fire (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40087 and mobid = 45520;

-- modify existing astagio of fire drops
-- increase brave pot droprate from astagio of fire (25000 -> 150000)
update droplist set chance = 150000 where itemid = 40014 and mobid = 45572;
-- increase blue pot droprate from astagio of fire (25000 -> 60000)
update droplist set chance = 60000 where itemid = 40015 and mobid = 45572;
-- increase nzel droprate from astagio of fire (5000 -> 65000)
update droplist set chance = 65000 where itemid = 40074 and mobid = 45572;
-- increase ndai droprate from astagio of fire (2500 -> 30000)
update droplist set chance = 30000 where itemid = 40087 and mobid = 45572;
-- increase sb:erupt droprate from astagio of fire (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40190 and mobid = 45572;
-- increase sb:eq droprate from astagio of fire (5000 -> 13000)
update droplist set chance = 13000 where itemid = 40207 and mobid = 45572;

-- add additional drops to astagio of fire
-- add wis pot to astagio of fire droplist 
insert into droplist values (45572, 40016, 1, 1, 100000);

-- modify existing black knight of darkness drops
-- increase brave pot droprate from black knight of darkness (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45503;
-- increase blue pot droprate from black knight of darkness (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45503;
-- increase nprat droprate from black knight of darkness (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40119 and mobid = 45503;

-- add additional drops to fire warrior of darkness
-- add lvl3 blank to fire warrior of darkness droplist 
insert into droplist values (45540, 40092, 1, 1, 30000);
-- add lvl4 blank to fire warrior of darkness droplist 
insert into droplist values (45540, 40093, 1, 1, 25000);
-- add lvl5 blank to fire warrior of darkness droplist 
insert into droplist values (45540, 40094, 1, 1, 20000);

-- modify existing insolent zenith queen drops
-- increase zq ring droprate from insolent zenith queen (100 -> 250)
update droplist set chance = 250 where itemid = 20298 and mobid = 45581;
-- increase bzel droprate from insolent zenith queen (5000 -> 10000)
update droplist set chance = 10000 where itemid = 140074 and mobid = 45581;
-- increase bdai droprate from insolent zenith queen (2500 -> 5000)
update droplist set chance = 5000 where itemid = 140087 and mobid = 45581;
-- increase czel droprate from insolent zenith queen (5000 -> 25000)
update droplist set chance = 25000 where itemid = 240074 and mobid = 45581;
-- increase cdai droprate from insolent zenith queen (2500 -> 12500)
update droplist set chance = 12500 where itemid = 140087 and mobid = 45581;

-- modify existing lesser seer drops
-- increase sb:ab droprate from lesser seer (100 -> 150)
update droplist set chance = 150 where itemid = 40223 and mobid = 45586;
-- increase nzel droprate from lesser seer (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45586;
-- increase ndai droprate from lesser seer (5000 -> 12000)
update droplist set chance = 12000 where itemid = 40087 and mobid = 45586;
-- increase bzel droprate from lesser seer (5000 -> 10000)
update droplist set chance = 10000 where itemid = 140074 and mobid = 45586;
-- increase bdai droprate from lesser seer (2500 -> 5000)
update droplist set chance = 5000 where itemid = 140087 and mobid = 45586;
-- increase czel droprate from lesser seer (5000 -> 12000)
update droplist set chance = 12000 where itemid = 240074 and mobid = 45586;
-- increase cdai droprate from lesser seer (2500 -> 7000)
update droplist set chance = 7000 where itemid = 240087 and mobid = 45586;

-- modify existing marquise vampire drops
-- increase ndai droprate from marquise vampire (5000 -> 12000)
update droplist set chance = 12000 where itemid = 40087 and mobid = 45604;
-- increase sb:adv droprate from marquise vampire (100 -> 350)
update droplist set chance = 350 where itemid = 40224 and mobid = 45604;
-- increase bzel droprate from marquise vampire (5000 -> 8000)
update droplist set chance = 8000 where itemid = 140074 and mobid = 45604;

-- modify existing zombie lord of fear drops
-- increase pg droprate from zombie lord of fear (5000 -> 5500)
update droplist set chance = 5500 where itemid = 20187 and mobid = 45589;
-- increase ndai droprate from zombie lord of fear (5000 -> 25000)
update droplist set chance = 15000 where itemid = 40087 and mobid = 45589;
-- increase sb:cz droprate from zombie lord of fear (10000 -> 100000)
update droplist set chance = 100000 where itemid = 40186 and mobid = 45589;

-- add additional drops to zombie lord of fear
-- add nzel to zombie lord of fear droplist 
insert into droplist values (45589, 40074, 1, 1, 50000);

-- modify existing undead elmore soldier drops
-- decrease leather armor droprate from undead elmore soldier (50000 -> 25000)
update droplist set chance = 25000 where itemid = 20089 and mobid = 45216;
-- decrease studdend leather armor droprate from undead elmore soldier (50000 -> 20000)
update droplist set chance = 20000 where itemid = 20147 and mobid = 45216;
-- decrease glaive droprate from undead elmore soldier (50000 -> 25000)
update droplist set chance = 25000 where itemid = 98 and mobid = 45216;

-- add additional drops to undead elmore soldier
-- add clear to undead elmore soldier droplist 
insert into droplist values (45216, 40012, 1, 1, 10000);
-- add low boots to undead elmore soldier droplist 
insert into droplist values (45216, 20213, 1, 1, 10000);
-- add bpm to undead elmore soldier droplist 
insert into droplist values (45216, 20149, 1, 1, 1500);

-- redo adena drop from undead elmore soldier
delete from droplist where itemid = 40308 and mobid = 45216; 
insert into droplist values (45216, 40308, 111, 231, 1000000);

-- modify existing undead elmore wizard drops
-- increase blue pot droprate from undead elmore wizard (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40015 and mobid = 45224;
-- increase sb:coc droprate from undead elmore wizard (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40183 and mobid = 45224;
-- increase btele droprate from undead elmore wizard (50000 -> 100000)
update droplist set chance = 100000 where itemid = 140100 and mobid = 45224;

-- add additional drops to undead elmore wizard
-- add sof to undead elmore wizard droplist 
insert into droplist values (45224, 131, 1, 1, 500);
-- add sb:mass slow to undead elmore wizard droplist 
insert into droplist values (45224, 40221, 1, 1, 1000);

-- redo adena drop from undead elmore wizard
delete from droplist where itemid = 40308 and mobid = 45224; 
insert into droplist values (45224, 40308, 187, 301, 1000000);

-- modify existing undead elmore general drops
-- increase brave pot droprate from undead elmore general (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45248;
-- decrease great sword droprate from undead elmore general (10000 -> 2500)
update droplist set chance = 2500 where itemid = 64 and mobid = 45248;

-- add additional drops to undead elmore general 
-- add low boots to undead elmore general droplist 
insert into droplist values (45248, 20213, 1, 1, 25000);
-- add boots to undead elmore general droplist 
insert into droplist values (45248, 20205, 1, 1, 20000);
-- add spear to undead elmore general droplist 
insert into droplist values (45248, 96, 1, 1, 15000);
-- add glaive to undead elmore general droplist 
insert into droplist values (45248, 98, 1, 1, 10000);
-- add sc:triple arrow to undead elmore general droplist 
insert into droplist values (45248, 40240, 1, 1, 8000);

-- redo adena drop from undead elmore general
delete from droplist where itemid = 40308 and mobid = 45248; 
insert into droplist values (45248, 40308, 227, 365, 1000000);

-- modify existing lesser dragon drops
-- increase nzel droprate from lesser dragon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40074 and mobid = 45496;
-- increase heart of dragon droprate from lesser dragon (500 -> 600)
update droplist set chance = 600 where itemid = 40466 and mobid = 45496;
-- increase tqd droprate from lesser dragon (2000 -> 4000)
update droplist set chance = 4000 where itemid = 40052 and mobid = 45496;
-- increase bzel droprate from lesser dragon (5000 -> 8000)
update droplist set chance = 8000 where itemid = 140074 and mobid = 45496;
-- increase bdai droprate from lesser dragon (1000 -> 4000)
update droplist set chance = 4000 where itemid = 140087 and mobid = 45496;

-- add additional drops to lesser dragon
-- add g-haste pot to lesser dragon droplist 
insert into droplist values (45496, 40018, 1, 1, 50000);
-- add haste pot to lesser dragon droplist 
insert into droplist values (45496, 40013, 1, 1, 50000);
-- add brave pot to lesser dragon droplist 
insert into droplist values (45496, 40014, 1, 1, 75000);
-- add wis pot to lesser dragon droplist 
insert into droplist values (45496, 40016, 1, 3, 75000);
-- add blue pot to lesser dragon droplist 
insert into droplist values (45496, 40015, 1, 3, 75000);
-- add poly scroll to lesser dragon droplist 
insert into droplist values (45496, 40088, 1, 1, 75000);
-- add sb:tame to lesser dragon droplist 
insert into droplist values (45496, 40181, 1, 1, 15000);
-- add ndai to lesser dragon droplist 
insert into droplist values (45496, 40087, 1, 1, 10000);
-- add sb:fb to lesser dragon droplist 
insert into droplist values (45496, 40170, 1, 1, 15000);
-- add sb:haste to lesser dragon droplist 
insert into droplist values (45496, 40188, 1, 1, 10000);
-- add sb:str to lesser dragon droplist 
insert into droplist values (45496, 40187, 1, 1, 10000);
-- add sb:wb to lesser dragon droplist 
insert into droplist values (45496, 40172, 1, 1, 10000);
-- add rosc to lesser dragon droplist 
insert into droplist values (45496, 20284, 1, 1, 400);
-- add sb:g-haste to lesser dragon droplist 
insert into droplist values (45496, 40199, 1, 1, 7500);
-- add dsc:final burn to lesser dragon droplist 
insert into droplist values (45496, 40278, 1, 1, 2500);
-- add sb:gres to lesser dragon droplist 
insert into droplist values (45496, 40220, 1, 1, 2000);

-- modify existing fire ghost (red) drops
-- increase c-oj droprate from fire ghost (red) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40020 and mobid = 45514;

-- modify existing fire ghost (blue) drops
-- increase c-oj droprate from fire ghost (red) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40020 and mobid = 45519;

-- modify existing horrific iron golem drops
-- decrease roe droprate from horrific iron golem (1000 -> 750)
update droplist set chance = 750 where itemid = 20300 and mobid = 45479;
-- increase pg droprate from horrific iron golem (1000 -> 2000)
update droplist set chance = 2000 where itemid = 20187 and mobid = 45479;
-- decrease sc:exotic vitalize droprate from horrific iron golem (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40252 and mobid = 45479;
-- increase brave pot droprate from horrific iron golem (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45479;
-- increase ndai droprate from horrific iron golem (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40087 and mobid = 45479;

-- increase c-oj droprate from nightmare (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40020 and mobid = 45440;

-- modify existing di fungus drops
-- increase fungus juice droprate from di fungus (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40499 and mobid = 45551;
-- increase pine droprate from di fungus (1000 -> 8000)
update droplist set chance = 8000 where itemid = 40006 and mobid = 45551;
-- increase maple droprate from di fungus (1000 -> 10000)
update droplist set chance = 10000 where itemid = 40008 and mobid = 45551;
-- increase nzel droprate from di fungus (1000 -> 9000)
update droplist set chance = 9000 where itemid = 40074 and mobid = 45551;
-- increase ndai droprate from di fungus (500 -> 4000)
update droplist set chance = 4000 where itemid = 40087 and mobid = 45551;
-- increase wis pot droprate from di fungus (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40016 and mobid = 45551;

-- modify existing di fire egg drops
-- increase pine droprate from di fire egg (1000 -> 5000)
update droplist set chance = 5000 where itemid = 40006 and mobid = 45555;
-- increase maple droprate from di fire egg (1000 -> 5000)
update droplist set chance = 5000 where itemid = 40008 and mobid = 45555;
-- increase blue pot droprate from di fire egg (10000 -> 50000)
update droplist set chance = 40015 where itemid = 40015 and mobid = 45555;
-- increase esc scroll droprate from di fire egg (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40079 and mobid = 45555;
-- increase nzel droprate from di fire egg (1000 -> 20000)
update droplist set chance = 20000 where itemid = 40074 and mobid = 45555;
-- increase ndai droprate from di fire egg (500 -> 5000)
update droplist set chance = 5000 where itemid = 40087 and mobid = 45555;
-- increase poly scroll droprate from di fire egg (10000 -> 65000)
update droplist set chance = 65000 where itemid = 40088 and mobid = 45555;
-- increase nprat droprate from di fire egg (10000 -> 65000)
update droplist set chance = 65000 where itemid = 40119 and mobid = 45555;
-- increase bzel droprate from di fire egg (100 -> 1000)
update droplist set chance = 1000 where itemid = 140074 and mobid = 45555;
-- increase bdai droprate from di fire egg (50 -> 500)
update droplist set chance = 500 where itemid = 140087 and mobid = 45555;
-- increase g-haste pot droprate from di fire egg (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45555;

-- modify existing di salamander drops
-- increase ebony droprate from di salamander (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40007 and mobid = 45552;
-- increase haste pot droprate from di salamander (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40013 and mobid = 45552;
-- increase brave pot droprate from di salamander (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40014 and mobid = 45552;
-- increase nzel droprate from di salamander (1000 -> 9000)
update droplist set chance = 9000 where itemid = 40074 and mobid = 45552;
-- increase ndai droprate from di salamander (500 -> 2000)
update droplist set chance = 2000 where itemid = 40087 and mobid = 45552;

-- add additional drops to di salamander
-- add 2hs to di salamander droplist 
insert into droplist values (45552, 52, 1, 1, 15000);
-- add g-axe to di salamander droplist 
insert into droplist values (45552, 143, 1, 1, 12000);
-- add sb:summon to di salamander droplist 
insert into droplist values (45552, 40196, 1, 1, 150);

-- modify existing di ice man drops
-- increase pine droprate from di ice man (1000 -> 2000)
update droplist set chance = 2000 where itemid = 40006 and mobid = 45556;
-- increase ebony droprate from di ice man (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40007 and mobid = 45556;
-- increase maple droprate from di ice man (1000 -> 2500)
update droplist set chance = 2500 where itemid = 40008 and mobid = 45556;
-- increase nzel droprate from di ice man (1000 -> 7500)
update droplist set chance = 7500 where itemid = 40074 and mobid = 45556;
-- increase ndai droprate from di ice man (500 -> 3000)
update droplist set chance = 3000 where itemid = 40087 and mobid = 45556;
-- increase red pot droprate from di ice man (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40010 and mobid = 45556;
-- increase orange pot droprate from di ice man (10000 -> 35000)
update droplist set chance = 35000 where itemid = 40011 and mobid = 45556;
-- increase clear pot droprate from di ice man (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40012 and mobid = 45556;

-- add additional drops to di ice man 
-- add lvl1 blank to di ice man droplist 
insert into droplist values (45556, 40090, 1, 1, 10000);

-- modify existing di ice golem drops
-- increase pine droprate from di ice golem (1000 -> 2000)
update droplist set chance = 2000 where itemid = 40006 and mobid = 45553;
-- increase ebony droprate from di ice golem (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40007 and mobid = 45553;
-- increase maple droprate from di ice golem (1000 -> 2500)
update droplist set chance = 2500 where itemid = 40008 and mobid = 45553;
-- increase hqd droprate from di ice golem (1000 -> 5000)
update droplist set chance = 5000 where itemid = 40048 and mobid = 45553;
-- increase nzel droprate from di ice golem (1000 -> 12000)
update droplist set chance = 12000 where itemid = 40074 and mobid = 45553;
-- increase ndai droprate from di ice golem (500 -> 4500)
update droplist set chance = 4500 where itemid = 40087 and mobid = 45553;
-- increase wis pot droprate from di ice golem (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40016 and mobid = 45553;

-- modify existing killer bee drops
-- increase pine droprate from killer bee (1000 -> 10000)
update droplist set chance = 10000 where itemid = 40006 and mobid = 45554;
-- increase maple droprate from killer bee (1000 -> 10000)
update droplist set chance = 10000 where itemid = 40008 and mobid = 45554;
-- increase brave pot droprate from killer bee (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40014 and mobid = 45554;
-- increase wis pot droprate from killer bee (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40016 and mobid = 45554;
-- increase hqd droprate from killer bee (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40048 and mobid = 45554;
-- increase nzel droprate from killer bee (1000 -> 35000)
update droplist set chance = 35000 where itemid = 40074 and mobid = 45554;
-- increase ndai droprate from killer bee (500 -> 20000)
update droplist set chance = 20000 where itemid = 40087 and mobid = 45554;

-- modify existing ball lightning drops
-- increase pine droprate from ball lightning (1000 -> 15000)
update droplist set chance = 15000 where itemid = 40006 and mobid = 45549;
-- increase ebony droprate from ball lightning (10000 -> 65000)
update droplist set chance = 65000 where itemid = 40007 and mobid = 45549;
-- increase maple droprate from ball lightning (1000 -> 15000)
update droplist set chance = 15000 where itemid = 40008 and mobid = 45549;
-- increase blue pot droprate from ball lightning (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40015 and mobid = 45549;
-- increase nzel droprate from ball lightning (1000 -> 6000)
update droplist set chance = 6000 where itemid = 40074 and mobid = 45549;
-- increase ndai droprate from ball lightning (500 -> 2500)
update droplist set chance = 2500 where itemid = 40087 and mobid = 45549;

-- modify existing will o\' wisp drops
-- increase pine droprate from will o\' wisp (1000 -> 15000)
update droplist set chance = 15000 where itemid = 40006 and mobid in (45557, 45558, 45559, 45560, 45561);
-- increase maple droprate from will o\' wisp (1000 -> 15000)
update droplist set chance = 15000 where itemid = 40008 and mobid in (45557, 45558, 45559, 45560, 45561);
-- increase nzel droprate from will o\' wisp (1000 -> 6000)
update droplist set chance = 6000 where itemid = 40074 and mobid in (45557, 45558, 45559, 45560, 45561);
-- increase ndai droprate from will o\' wisp (500 -> 2500)
update droplist set chance = 2500 where itemid = 40087 and mobid in (45557, 45558, 45559, 45560, 45561);



-- update 17

-- remove invalid drop from ghost
delete from droplist where mobid = 45198 and itemid = 45174;

-- increase undead key droprate from lvl 30 mage quest mop (50000 -> 250000)
update droplist set chance = 250000 where itemid = 40581 and mobid = 45100;

-- correct id scroll drops from dancing sword (was IT id scroll)
update droplist set itemid = 40126 where mobid = 45386 and itemid = 40098;

-- modify existing seer drops
-- increase tsu droprate from seer (5000 -> 5500)
update droplist set chance = 5500 where itemid = 57 and mobid = 45547;
-- increase tqd droprate from seer (8000 -> 1000)
update droplist set chance = 10000 where itemid = 40052 and mobid = 45547;

-- modify existing vampire drops
-- increase silver cloak droprate from vampire (1000 -> 5000)
update droplist set chance = 5000 where itemid = 20074 and mobid = 45606;
-- increase sof droprate from vampire (5000 -> 10000)
update droplist set chance = 10000 where itemid = 131 and mobid = 45606;
-- increase tsu droprate from vampire (5000 -> 5500)
update droplist set chance = 5500 where itemid = 57 and mobid = 45606;

-- modify existing zombie lord drops
-- increase tsu droprate from zombie lord (5000 -> 6500)
update droplist set chance = 6500 where itemid = 57 and mobid = 45650;
-- increase k-edo droprate from zombie lord (500 -> 1200)
update droplist set chance = 1200 where itemid = 84 and mobid = 45650;

-- modify existing cougar drops
-- increase nkat droprate from cougar (50000 -> 150000)
update droplist set chance = 150000 where itemid = 41 and mobid = 45652;
-- increase tsu droprate from cougar (2000 -> 7500)
update droplist set chance = 7500 where itemid = 57 and mobid = 45652;

-- modify existing mummy lord drops
-- increase helm of mummy lord droprate from mummy lord (500 -> 750)
update droplist set chance = 750 where itemid = 20017 and mobid = 45652;
-- increase roe droprate from mummy lord (4500 -> 9500)
update droplist set chance = 9500 where itemid = 20300 and mobid = 45652;
-- increase row, roa, rof droprate from mummy lord (1000 -> 3000)
update droplist set chance = 3000 where itemid in (20285, 20302, 20304) and mobid = 45652;
-- increase sb:decay pot droprate from mummy lord (1000 -> 2500)
update droplist set chance = 2500 where itemid = 40216 and mobid = 45652;
-- increase tsu droprate from mummy lord (2000 -> 6500)
update droplist set chance = 6500 where itemid = 57 and mobid = 45652;

-- modify existing iris drops
-- increase row, rof droprate from iris (1500 -> 2500)
update droplist set chance = 2500 where itemid in (20285, 20304) and mobid = 45654;
-- increase roe, roa droprate from iris (3000 -> 5000)
update droplist set chance = 5000 where itemid in (20300, 20302) and mobid = 45654;
-- increase pg droprate from iris (15000 -> 16000)
update droplist set chance = 16000 where itemid = 20187 and mobid = 45654;
-- increase dice dagger droprate from iris (50000 -> 300000)
update droplist set chance = 300000 where itemid = 2 and mobid = 45654;
-- increase nkat droprate from iris (50000 -> 150000)
update droplist set chance = 150000 where itemid = 41 and mobid = 45654;
-- increase tsu droprate from iris (2000 -> 7500)
update droplist set chance = 7500 where itemid = 57 and mobid = 45654;

-- modify existing knight vald drops
-- increase pg droprate from knight vald (10000 -> 12000)
update droplist set chance = 12000 where itemid = 20187 and mobid = 45618;
-- increase tsu droprate from knight vald (5000 -> 7500)
update droplist set chance = 7500 where itemid = 57 and mobid = 45618;
-- increase kv sword droprate from knight vald (100 -> 600)
update droplist set chance = 800 where itemid = 59 and mobid = 45618;

-- modify existing lich drops
-- increase silver cloak droprate from lich (2500 -> 10000)
update droplist set chance = 10000 where itemid = 20074 and mobid = 45672;
-- increase bzel droprate from lich (50000 -> 500000)
update droplist set chance = 500000 where itemid = 140074 and mobid = 45672;
-- increase bdai droprate from lich (25000 -> 300000)
update droplist set chance = 300000 where itemid = 140087 and mobid = 45672;
-- increase sb:destroy droprate from lich (2000 -> 5000)
update droplist set chance = 5000 where itemid = 40222 and mobid = 45672;
-- increase sb:ab droprate from lich (20000 -> 5000)
update droplist set chance = 5000 where itemid = 40223 and mobid = 45672;
-- increase bkat droprate from lich (50000 -> 150000)
update droplist set chance = 150000 where itemid = 100041 and mobid = 45672;
-- increase tsu droprate from lich (5000 -> 7000)
update droplist set chance = 7000 where itemid = 57 and mobid = 45672;

-- add sb:hw to drake droplist
insert into droplist values (45529, 40197, 1, 1, 5000);


-- update 19

-- decrease dex ammy droprate from phoenix (50000 -> 15000)
update droplist set chance = 15000 where itemid = 20256 and mobid = 45617;
-- decrease ropc droprate from phoenix (70000 -> 25000)
update droplist set chance = 25000 where itemid = 20281 and mobid = 45617;
-- decrease rof droprate from phoenix (d0000 -> 25000)
update droplist set chance = 25000 where itemid = 20304 and mobid = 45617;

-- modify existing gelatinous cube drops
-- increase mith plate droprate from gelatinous cube (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40497 and mobid = 45296;
-- increase ori plate droprate from gelatinous cube (10000 -> 12000)
update droplist set chance = 12000 where itemid = 40509 and mobid = 45296;

-- modify existing dire bat drops
-- increase wis pot droprate from dire bat (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40016 and mobid = 45219;
-- increase ntele droprate from dire bat (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40100 and mobid = 45219;

-- modify existing gc dire wolf drops
-- increase clear pot droprate from gc dire wolf (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40012 and mobid = 45237;
-- increase brave pot droprate from gc dire wolf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45237;
-- increase wis pot droprate from gc dire wolf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40016 and mobid = 45237;
-- decrease sb:hw droprate from gc dire wolf (2000 -> 500)
update droplist set chance = 500 where itemid = 40197 and mobid = 45237;

-- add additional drops to gc dire wolf 
-- add meat to gc dire wolf droplist 
insert into droplist values (45237, 40056, 1, 1, 75000);
-- add nprat to gc dire wolf droplist 
insert into droplist values (45237, 40097, 1, 1, 75000);
-- add haste pot to gc dire wolf droplist 
insert into droplist values (45237, 40013, 1, 1, 50000);
-- add bbs to gc dire wolf droplist 
insert into droplist values (45237, 40524, 1, 1, 10000);

-- modify existing gc dire bear drops
-- increase nzel droprate from gc dire bear (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40074 and mobid = 45252;
-- increase ntele droprate from gc dire bear (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40100 and mobid = 45252;
-- increase nprat droprate from gc dire bear (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40119 and mobid = 45252;

-- add additional drops to gc dire bear 
-- add wis pot to gc dire bear droplist 
insert into droplist values (45252, 40016, 1, 1, 60000);

-- modify existing black ent drops
-- increase clear pot droprate from black ent (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40012 and mobid = 45367;
-- increase brave pot droprate from black ent (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40014 and mobid = 45367;
-- increase nzel droprate from black ent (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45367;
-- increase Bark of Dark Ent droprate from black ent (1000 -> 1500)
update droplist set chance = 1500 where itemid = 40410 and mobid = 45367;
-- increase Fruit of Dark Ent droprate from black ent (1000 -> 1500)
update droplist set chance = 1500 where itemid = 40411 and mobid = 45367;
-- increase Twig of Dark Ent droprate from black ent (1000 -> 1500)
update droplist set chance = 1500 where itemid = 40412 and mobid = 45367;
-- increase Black Mithril Stone droprate from black ent (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40444 and mobid = 45367;
-- increase Dark Elven Stone droprate from black ent (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40490 and mobid = 45367;

-- modify existing deep flower drops
-- increase orange pot droprate from deep flower (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40011 and mobid = 45273;

-- add additional drops to deep flower 
-- add haste pot to deep flower droplist 
insert into droplist values (45273, 40013, 1, 1, 50000);
-- add ntele to deep flower droplist 
insert into droplist values (45273, 40100, 1, 1, 50000);
-- add cure pot to deep flower droplist 
insert into droplist values (45273, 40017, 1, 1, 50000);

-- modify existing dark elementalist drops
-- decrease sb:i2h droprate from dark elementalist (400 -> 350)
update droplist set chance = 350 where itemid = 40213 and mobid = 45245;
-- increase nzel droprate from dark elementalist (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45245;
-- increase wis pot droprate from dark elementalist (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40016 and mobid = 45245;
-- increase nprat droprate from dark elementalist (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40119 and mobid = 45245;
-- increase bbs droprate from dark elementalist (10000 -> 12000)
update droplist set chance = 12000 where itemid = 40524 and mobid = 45245;

-- modify existing gc dark elementalist drops
-- decrease sb:i2h droprate from gc dark elementalist (1000 -> 250)
update droplist set chance = 250 where itemid = 40213 and mobid = 45363;
-- decrease sb:dk pot droprate from gc dark elementalist (500 -> 400)
update droplist set chance = 400 where itemid = 40216 and mobid = 45363;

-- add additional drops to gc dark elementalist 
-- add Piece of Large Cave Scroll to gc dark elementalist droplist 
insert into droplist values (45363, 40429, 1, 1, 50000);

-- modify existing lizardman drops
-- increase homr droprate from lizardman (10000 -> 12500)
update droplist set chance = 12500 where itemid = 20011 and mobid = 45144;
-- increase haste pot droprate from lizardman (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40013 and mobid = 45144;
-- increase sapphire droprate from lizardman (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40046 and mobid = 45144;

-- add additional drops to lizardman 
-- add cmomr to lizardman droplist 
insert into droplist values (45144, 20110, 1, 1, 500);
-- add hqs to lizardman droplist 
insert into droplist values (45144, 40050, 1, 1, 5000);

-- modify existing owlbear drops
-- increase brave pot droprate from owlbear (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40014 and mobid = 45147;

-- add additional drops to owlbear 
-- add carrot to owlbear droplist 
insert into droplist values (45147, 40060, 1, 1, 150000);
-- add haste pot to owlbear droplist 
insert into droplist values (45147, 40013, 1, 1, 25000);

-- modify existing lycanthrope drops
-- decrease scale mail droprate from lycanthrope (50000 -> 40000)
update droplist set chance = 40000 where itemid = 20122 and mobid = 45173;
-- decrease fauchard droprate from lycanthrope (50000 -> 35000)
update droplist set chance = 35000 where itemid = 104 and mobid = 45173;

-- modify existing dark elf drops
-- increase sc:wind shot droprate from dark elf (5000 -> 7500)
update droplist set chance = 7500 where itemid = 40260 and mobid = 45265;
-- decrease sc:r2n droprate from dark elf (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40237 and mobid = 45265;
-- increase elven cloak droprate from dark elf (10000 -> 15000)
update droplist set chance = 15000 where itemid = 20073 and mobid = 45265;
-- increase elven cloak droprate from dark elf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40068 and mobid = 45265;

-- redo mith arrow drop on dark elf
delete from droplist where itemid = 40746 and mobid = 45265;
insert into droplist values (45265, 40746, 75, 450, 150000);

-- add additional drops to dark elf 
-- add diamond to dark elf droplist 
insert into droplist values (45265, 40044, 1, 1, 7500);
-- add devil's blood to dark elf droplist 
insert into droplist values (45265, 40031, 1, 1, 5000);

-- add additional drops to bandit leader 
-- add tqs to bandit leader droplist 
insert into droplist values (45370, 40054, 1, 1, 15000);
-- add devil's blood to bandit leader droplist 
insert into droplist values (45370, 40031, 1, 1, 25000);

-- modify existing griffon drops
-- increase btele droprate from griffon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45321;
-- decrease sb:tornado droprate from griffon (5000 -> 2500)
update droplist set chance = 2500 where itemid = 40198 and mobid = 45321;
-- decrease sc:r2n droprate from griffon (10000 -> 4500)
update droplist set chance = 4500 where itemid = 40237 and mobid = 45321;
-- increase hqs droprate from griffon (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40050 and mobid = 45321;

-- remove b-splint mail from griffon droplist
delete from droplist where itemid = 120101 and mobid = 45321;

-- add additional drops to griffon 
-- add diamond to griffon droplist 
insert into droplist values (45321, 40044, 1, 1, 45000);
-- add red pot to griffon droplist 
insert into droplist values (45321, 40010, 1, 1, 75000);
-- add banded mail to griffon droplist 
insert into droplist values (45321, 20101, 1, 1, 20000);
-- add g-haste pot to griffon droplist 
insert into droplist values (45321, 40018, 1, 1, 50000);
-- add tqs to griffon droplist 
insert into droplist values (45321, 40054, 1, 1, 8000);
-- add sb:c-m to griffon droplist 
insert into droplist values (45321, 40176, 1, 1, 8500);

-- modify existing cyclops drops
-- decrease b-banded mail droprate from cyclops (50000 -> 20000)
update droplist set chance = 20000 where itemid = 220101 and mobid = 45420;
-- increase brave pot droprate from cyclops (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40014 and mobid = 45420;
-- decrease sb:silence droprate from cyclops (4500 -> 4000)
update droplist set chance = 4000 where itemid = 4500 and mobid = 45420;
-- decrease sb:eq droprate from cyclops (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40207 and mobid = 45420;
-- decrease sb:summon droprate from cyclops (5000 -> 2500)
update droplist set chance = 2500 where itemid = 40196 and mobid = 45420;
-- decrease sc:entangle droprate from cyclops (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40248 and mobid = 45420;
-- decrease sc:bless of earth droprate from cyclops (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40250 and mobid = 45420;
-- increase bzel droprate from cyclops (10000 -> 12000)
update droplist set chance = 12000 where itemid = 140074 and mobid = 45420;

-- add additional drops to cyclops 
-- add red pot to cyclops droplist 
insert into droplist values (45420, 40010, 1, 1, 75000);
-- add sb:ej to cyclops droplist 
insert into droplist values (45420, 40175, 1, 1, 10000);
-- add sb:disease to cyclops droplist 
insert into droplist values (45420, 40201, 1, 1, 4500);
-- add nzel to cyclops droplist 
insert into droplist values (45420, 40074, 1, 1, 25000);

-- modify existing Dark Forester drops
-- increase Armor of Dark Forester droprate from Dark Forester (5000 -> 7500)
update droplist set chance = 7500 where itemid = 20098 and mobid = 45347;
-- increase Boots of Dark Forester droprate from Dark Forester (5000 -> 6500)
update droplist set chance = 6500 where itemid = 20196 and mobid = 45347;
-- increase nzel droprate from Dark Forester (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40074 and mobid = 45347;

-- modify existing Dark Elf Carrier drops
-- increase Lastabad Spear droprate from Dark Elf Carrier (5000 -> 7500)
update droplist set chance = 7500 where itemid = 101 and mobid = 45293;

-- modify existing Beast Summoner drops
-- increase clear pot droprate from Beast Summoner (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40012 and mobid = 45368;
-- increase haste pot droprate from Beast Summoner (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40013 and mobid = 45368;

-- add additional drops to Beast Summoner 
-- add pine wand to Beast Summoner droplist 
insert into droplist values (45368, 40006, 1, 1, 25000);

-- modify existing Black Wizard drops
-- increase bw ammy droprate from Black Wizard (100 -> 200)
update droplist set chance = 200 where itemid = 20257 and mobid = 45405;
-- increase clear pot droprate from Black Wizard (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40012 and mobid = 45405;
-- increase blue pot droprate from Black Wizard (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45405;

-- modify existing Heavy Oum drops
-- increase nzel droprate from Heavy Oum (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45453;
-- increase ndai droprate from Heavy Oum (5000 -> 7500)
update droplist set chance = 7500 where itemid = 40087 and mobid = 45453;
-- increase bzel droprate from Heavy Oum (5000 -> 10000)
update droplist set chance = 10000 where itemid = 140074 and mobid = 45453;

-- modify existing Dark Elf Hunter drops
-- increase Lastabad Leather Armor droprate from Dark Elf Hunter (5000 -> 8500)
update droplist set chance = 8500 where itemid = 20102 and mobid = 45238;
-- increase Lastabad Boots droprate from Dark Elf Hunter (5000 -> 7500)
update droplist set chance = 7500 where itemid = 20199 and mobid = 45238;
-- increase wis pot droprate from Dark Elf Hunter (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40016 and mobid = 45238;
-- increase ntele droprate from Dark Elf Hunter (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40100 and mobid = 45238;
-- increase nprat droprate from Dark Elf Hunter (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40119 and mobid = 45238;
-- increase lastabad bow droprate from Dark Elf Hunter (5000 -> 7500)
update droplist set chance = 7500 where itemid = 176 and mobid = 45238;
-- increase Lastabad Blade droprate from Dark Elf Hunter (5000 -> 6500)
update droplist set chance = 6500 where itemid = 10 and mobid = 45238;

-- modify existing Dark Elf Apprentice drops
-- decrease lasta robe droprate from Dark Elf Apprentice (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20103 and mobid = 45256;
-- decrease lasta staff droprate from Dark Elf Apprentice (5000 -> 3000)
update droplist set chance = 3000 where itemid = 122 and mobid = 45256;

-- add additional drops to Dark Elf Apprentice 
-- add dsc:dress evasion to Dark Elf Apprentice droplist 
insert into droplist values (45256, 40279, 1, 1, 2500);

-- modify existing Dark Elf Soldier drops
-- increase Lastabad Leather Armor droprate from Dark Elf Soldier (5000 -> 8500)
update droplist set chance = 8500 where itemid = 20102 and mobid = 45404;
-- increase Lastabad Boots droprate from Dark Elf Soldier (5000 -> 7500)
update droplist set chance = 7500 where itemid = 20199 and mobid = 45404;
-- increase Lastabad Long Sword droprate from Dark Elf Soldier (5000 -> 6000)
update droplist set chance = 6000 where itemid = 38 and mobid = 45404;
-- increase nzel droprate from Dark Elf Soldier (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40074 and mobid = 45404;
-- increase ndai droprate from Dark Elf Soldier (5000 -> 6000)
update droplist set chance = 6000 where itemid = 40087 and mobid = 45404;
-- increase wis pot droprate from Dark Elf Soldier (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40016 and mobid = 45404;
-- increase ntele droprate from Dark Elf Soldier (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40100 and mobid = 45404;
-- increase nprat droprate from Dark Elf Soldier (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40119 and mobid = 45404;

-- add additional drops to Dark Elf Soldier 
-- add lastabad studded leather armor to Dark Elf Soldier droplist 
insert into droplist values (45404, 20104, 1, 1, 4500);
-- add dsc:enchant venom to Dark Elf Soldier droplist 
insert into droplist values (45404, 40266, 1, 1, 3500);

-- modify existing Dark Elf Guard (bow) drops
-- increase blue pot droprate from Dark Elf Guard (bow) (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40015 and mobid = 45411;
-- increase ndai droprate from Dark Elf Guard (bow) (5000 -> 7500)
update droplist set chance = 7500 where itemid = 40087 and mobid = 45411;
-- increase ntele droprate from Dark Elf Guard (bow) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40100 and mobid = 45411;
-- decrease sb:hw droprate from Dark Elf Guard (bow) (2000 -> 1500)
update droplist set chance = 1500 where itemid = 40197 and mobid = 45411;
-- increase lasta blade droprate from Dark Elf Guard (bow) (5000 -> 6500)
update droplist set chance = 6500 where itemid = 10 and mobid = 45411;
-- increase lhxbow droprate from Dark Elf Guard (bow) (2500 -> 3000)
update droplist set chance = 3000 where itemid = 188 and mobid = 45411;

-- modify existing Dark Elf Guard (spear) drops
-- increase Lastabad Studded Leather Armor  droprate from Dark Elf Guard (spear) (5000 -> 6500)
update droplist set chance = 6500 where itemid = 20104 and mobid = 45412;
-- increase Lastabad Round Shield droprate from Dark Elf Guard (spear) (5000 -> 7000)
update droplist set chance = 7000 where itemid = 20224 and mobid = 45412;
-- increase red pot droprate from Dark Elf Guard (spear) (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40010 and mobid = 45412;
-- increase orange pot droprate from Dark Elf Guard (spear) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45412;
-- increase brave pot droprate from Dark Elf Guard (spear) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45412;
-- increase nzel droprate from Dark Elf Guard (spear) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45412;
-- increase ntele droprate from Dark Elf Guard (spear) (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40100 and mobid = 45412;
-- increase nprat droprate from Dark Elf Guard (spear) (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40119 and mobid = 45412;
-- decrease dsc:shadow fang droprate from Dark Elf Guard (spear) (10000 -> 3500)
update droplist set chance = 3500 where itemid = 40277 and mobid = 45412;
-- increase lasta spear droprate from Dark Elf Guard (spear) (5000 -> 6500)
update droplist set chance = 6500 where itemid = 101 and mobid = 45412;

-- modify existing Dark Elf Wizard drops
-- increase wis pot droprate from Dark Elf Wizard (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40016 and mobid = 45447;
-- increase nzel droprate from Dark Elf Wizard (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45447;
-- increase ntele droprate from Dark Elf Wizard (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40100 and mobid = 45447;
-- increase nprat droprate from Dark Elf Wizard (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40119 and mobid = 45447;
-- decrease sb:fog of sleeping droprate from Dark Elf Wizard (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40211 and mobid = 45447;
-- decrease sb:i2h droprate from Dark Elf Wizard (500 -> 400)
update droplist set chance = 400 where itemid = 40213 and mobid = 45447;
-- decrease sb:counter detect droprate from Dark Elf Wizard (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40217 and mobid = 45447;
-- increase sb:meteor droprate from Dark Elf Wizard (100 -> 120)
update droplist set chance = 120 where itemid = 40219 and mobid = 45447;
-- decrease sb:mass slow droprate from Dark Elf Wizard (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40221 and mobid = 45447;
-- increase sb:adv droprate from Dark Elf Wizard (100 -> 150)
update droplist set chance = 150 where itemid = 40224 and mobid = 45447;
-- increase bbs droprate from Dark Elf Wizard (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45447;

-- modify existing Dark Elf Thief drops
-- increase lasta leather armor droprate from Dark Elf Thief (5000 -> 6500)
update droplist set chance = 6500 where itemid = 20102 and mobid = 45272;
-- decrease sb:hw droprate from Dark Elf Thief (1500 -> 800)
update droplist set chance = 800 where itemid = 40197 and mobid = 45272;
-- decrease sb:dk pot droprate from Dark Elf Thief (500 -> 400)
update droplist set chance = 400 where itemid = 40216 and mobid = 45272;
-- decrease dsc:final burn droprate from Dark Elf Thief (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40278 and mobid = 45272;
-- increase mith arrow droprate from Dark Elf Thief (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40746 and mobid = 45272;

-- add additional drops to Dark Elf Thief 
-- add lasta bow to Dark Elf Thief droplist 
insert into droplist values (45272, 176, 1, 1, 5000);
-- add lastabad dagger to Dark Elf Thief droplist 
insert into droplist values (45272, 6, 1, 1, 7500);
-- add sb:meteor to Dark Elf Thief droplist 
insert into droplist values (45272, 40219, 1, 1, 50);

-- modify existing dark elf beast tamer drops
-- increase red pot droprate from dark elf beast tamer (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40010 and mobid = 45356;
-- increase orange pot droprate from dark elf beast tamer (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45356;
-- increase brave pot droprate from dark elf beast tamer (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45356;
-- increase nzel droprate from dark elf beast tamer (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40074 and mobid = 45356;
-- decrease dsc:dress dex droprate from dark elf beast tamer (10000 -> 3500)
update droplist set chance = 3500 where itemid = 40274 and mobid = 45356;
-- increase dsc:double break droprate from dark elf beast tamer (10000 -> 4500)
update droplist set chance = 4500 where itemid = 40275 and mobid = 45356;

-- add additional drops to dark elf beast tamer 
-- add g-haste pot to dark elf beast tamer droplist 
insert into droplist values (45356, 40018, 1, 1, 25000);

-- remove c-red from toi nightmare
delete from droplist where itemid = 40019 and mobid = 45440;

-- redo c-oj drop on toi nightmare
delete from droplist where itemid = 40020 and mobid = 45440;
insert into droplist values (45440, 40020, 1, 3, 170000);

-- modify existing lesser dragon drops
-- decrease rosc droprate from lesser dragon (400 -> 300)
update droplist set chance = 300 where itemid = 20284 and mobid = 45496;
-- increase diamond droprate from lesser dragon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40044 and mobid = 45496;
-- increase ruby droprate from lesser dragon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40045 and mobid = 45496;
-- increase sapphire droprate from lesser dragon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40046 and mobid = 45496;
-- increase emerald droprate from lesser dragon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40047 and mobid = 45496;
-- decrease sb:firewall droprate from lesser dragon (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40203 and mobid = 45496;

-- modify existing Priest of Chaos (lvl 22) drops
-- increase Fragment of Soulstone droprate from Priest of Chaos (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40678 and mobid in (45226, 45626);

-- modify existing Priest of Chaos (lvl 55) drops
-- increase Fragment of Soulstone droprate from Priest of Chaos (lvl 55) (10000 -> 70000)
update droplist set chance = 70000 where itemid = 40678 and mobid = 45599;
-- increase black mith droprate from Priest of Chaos (lvl 55) (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40444 and mobid = 45599;

-- modify existing Priest of Chaos (lvl 52) drops
-- increase Fragment of Soulstone droprate from Priest of Chaos (lvl 55) (10000 -> 70000)
update droplist set chance = 70000 where itemid = 40678 and mobid = 45576;
-- increase black mith droprate from Priest of Chaos (lvl 55) (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40444 and mobid = 45576;

-- modify existing Subterranean Crabman drops
-- increase devil's blood droprate from Subterranean Crabman (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40031 and mobid = 45297;
-- increase hqd droprate from Subterranean Crabman (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40048 and mobid = 45297;
-- increase hqr droprate from Subterranean Crabman (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40049 and mobid = 45297;
-- increase hqs droprate from Subterranean Crabman (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40050 and mobid = 45297;

-- add additional drops to Subterranean Crabman  
-- add hqe to Subterranean Crabman droplist 
insert into droplist values (45297, 40051, 1, 1, 15000);

-- modify existing Subterranean Great King Worm drops
-- increase blue pot droprate from Subterranean Great King Worm (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45360;

-- modify existing Subterranean Lizardman drops
-- increase sapphire droprate from Subterranean Lizardman (10000 -> 65000)
update droplist set chance = 65000 where itemid = 40046 and mobid = 45374;
-- increase ntele droprate from Subterranean Lizardman (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40100 and mobid = 45374;
-- decrease abyss ring droprate from Subterranean Lizardman (10000 -> 7500)
update droplist set chance = 7500 where itemid = 20289 and mobid = 45374;

-- add additional drops to Subterranean Lizardman 
-- add hqs to Subterranean Lizardman droplist 
insert into droplist values (45374, 40054, 1, 1, 20000);

-- modify existing Subterranean Scormystic drops
-- increase nzel droprate from Subterranean Scormystic (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45382;
-- increase lvl3 blank droprate from Subterranean Scormystic (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40092 and mobid = 45382;

-- modify existing Subterranean Scorpaitan drops
-- increase nzel droprate from Subterranean Scorpaitan (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45383;
-- increase lvl3 blank droprate from Subterranean Scorpaitan (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40092 and mobid = 45383;

-- modify existing Subterranean Beholder drops
-- increase sc:elemental falldown droprate from Subterranean Beholder (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40241 and mobid = 45423;
-- increase sc: erase magic droprate from Subterranean Beholder (10000 -> 5000)
update droplist set chance = 6500 where itemid = 40242 and mobid = 45423;
-- increase sc:wind shackle droprate from Subterranean Beholder (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40264 and mobid = 45423;

-- add additional drops to Subterranean Beholder 
-- add czel to Subterranean Beholder droplist 
insert into droplist values (45423, 240074, 1, 1, 7500);
-- add cdai to Subterranean Beholder droplist 
insert into droplist values (45423, 240087, 1, 1, 2500);

-- modify existing Subterranean Great King Turtle drops
-- increase orange pot droprate from Subterranean Great King Turtle (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40011 and mobid = 45422;
-- increase hqd droprate from Subterranean Great King Turtle (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40048 and mobid = 45422;
-- increase hqs droprate from Subterranean Great King Turtle (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40050 and mobid = 45422;
-- increase hqe droprate from Subterranean Great King Turtle (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40051 and mobid = 45422;
-- decrease tqd droprate from Subterranean Great King Turtle (5000 -> 2500)
update droplist set chance = 2500 where itemid = 40052 and mobid = 45422;
-- decrease sc:triple droprate from Subterranean Great King Turtle (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40240 and mobid = 45422;
-- decrease sc: erase magic droprate from Subterranean Great King Turtle (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40242 and mobid = 45422;
-- increase sc:water life droprate from Subterranean Great King Turtle (2000 -> 5000)
update droplist set chance = 5000 where itemid = 40253 and mobid = 45422;

-- redo adena drop from Subterranean Great King Turtle  
delete from droplist where itemid = 40308 and mobid = 45422;
insert into droplist values (45422, 40308, 1265, 4291, 1000000);

-- add additional drops to Subterranean Great King Turtle 
-- add gloves of ice spirit to Subterranean Great King Turtle droplist 
insert into droplist values (45422, 20172, 1, 1, 7500);

-- modify existing Subterranean Elekkadom drops
-- increase eva's scorn droprate from Subterranean Elekkadom (120 -> 150)
update droplist set chance = 150 where itemid = 36 and mobid = 45487;
-- decrease sc:elemental falldown droprate from Subterranean Elekkadom (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40241 and mobid = 45487;
-- decrease sc:erase magic droprate from Subterranean Elekkadom (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40242 and mobid = 45487;
-- increase sc:water life droprate from Subterranean Elekkadom (2000 -> 4000)
update droplist set chance = 4000 where itemid = 40253 and mobid = 45487;

-- redo adena drop from Subterranean Elekkadom 
delete from droplist where itemid = 40308 and mobid = 45487;
insert into droplist values (45487, 40308, 1619, 7131, 1000000);

-- add additional drops to Subterranean Elekkadom 
-- add relic of maphr to Subterranean Elekkadom droplist 
insert into droplist values (45487, 40304, 1, 1, 10500);

-- redo frag drop from Chaos
delete from droplist where itemid = 40678 and mobid = 45625;
insert into droplist values (45625, 40678, 20, 121, 1000000);

-- modify existing medusa drops
-- decrease sb:para droprate from medusa (25000 -> 20000)
update droplist set chance = 20000 where itemid = 40178 and mobid = 45380;
-- increase sb:i2h droprate from medusa (500 -> 350)
update droplist set chance = 350 where itemid = 40213 and mobid = 45380;
-- increase sb:g-res droprate from medusa (5000 -> 4000)
update droplist set chance = 4000 where itemid = 40220 and mobid = 45380;

-- remove cure pot from medusa droplist
delete from droplist where itemid = 40017 and mobid = 45380;

-- modify existing giants (all) drops
-- increase orange pot droprate from giants (all) (5000 -> 25000)
update droplist set chance = 25000 where itemid = 40011 and mobid in (45295, 45337, 45351);
-- increase brave pot droprate from giants (all) (5000 -> 20000)
update droplist set chance = 20000 where itemid = 40014 and mobid in (45295, 45337, 45351);
-- increase beserker axe droprate from giants (all) (1000 -> 5000)
update droplist set chance = 5000 where itemid = 145 and mobid in (45295, 45337, 45351);
-- decrease battle axe droprate from giants (all) (25000 -> 20000)
update droplist set chance = 20000 where itemid = 143 and mobid in (45295, 45337, 45351);
-- increase sks droprate from giants (all) (500 -> 750)
update droplist set chance = 750 where itemid = 20238 and mobid in (45295, 45337, 45351);

-- modify existing Blue Tail drops
-- increase sapphire droprate from Blue Tail (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40046 and mobid = 45239;
-- fix skin of blue lizard droprate from Blue Tail (10000000 -> 1000000)
update droplist set chance = 1000000 where itemid = 40714 and mobid = 45239;

-- modify existing Wild Venom drops
-- increase ruby droprate from Wild Venom (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40045 and mobid = 45139;

-- modify existing Wild Fang drops
-- increase brave pot droprate from Wild Fang (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40014 and mobid = 45163;
-- increase emerald droprate from Wild Fang (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40047 and mobid = 45163;

-- modify existing Wild Magic drops
-- increase blue pot droprate from Wild Magic (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40015 and mobid = 45197;
-- increase diamond droprate from Wild Magic (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40044 and mobid = 45197;

-- modify existing Kiwi Parrot drops
-- increase Emerald droprate from Kiwi Parrot (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40047 and mobid = 45249;

-- modify existing Mad Lizardman drops
-- decrease cursed diamond ring droprate from Mad Lizardman (10000 -> 8000)
update droplist set chance = 8000 where itemid = 20293 and mobid = 45158;
-- decrease cursed emerald ring droprate from Mad Lizardman (10000 -> 5000)
update droplist set chance = 5000 where itemid = 20296 and mobid = 45158;
-- increase orange pot droprate from Mad Lizardman (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40011 and mobid = 45158;
-- increase emerald droprate from Mad Lizardman (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40047 and mobid = 45158;
-- increase frag droprate from Mad Lizardman (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40471 and mobid = 45158;

-- modify existing High Lizardman drops
-- decrease cursed diamond ring droprate from High Lizardman (10000 -> 8000)
update droplist set chance = 8000 where itemid = 20293 and mobid = 45217;
-- decrease cursed sapphire ring droprate from High Lizardman (10000 -> 5000)
update droplist set chance = 5000 where itemid = 20295 and mobid = 45217;
-- increase orange pot droprate from High Lizardman (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40011 and mobid = 45217;
-- increase sapphire droprate from High Lizardman (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40046 and mobid = 45217;
-- increase frag droprate from High Lizardman (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40661 and mobid = 45217;

-- modify existing Heavy Lizardman drops
-- decrease cursed diamond ring droprate from Heavy Lizardman (10000 -> 8000)
update droplist set chance = 8000 where itemid = 20293 and mobid = 45251;
-- decrease cursed ruby ring droprate from Heavy Lizardman (10000 -> 7500)
update droplist set chance = 7500 where itemid = 20294 and mobid = 45251;
-- decrease cursed sapphire ring droprate from Heavy Lizardman (10000 -> 4500)
update droplist set chance = 4500 where itemid = 20295 and mobid = 45251;
-- increase orange pot droprate from Heavy Lizardman (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45251;
-- increase diamond droprate from Heavy Lizardman (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40044 and mobid = 45251;
-- increase frag droprate from Heavy Lizardman (10000 -> 17500)
update droplist set chance = 17500 where itemid = 40471 and mobid = 45251;

-- modify existing Skeletal Pirate drops
-- decrease cursed diamond ring droprate from Skeletal Pirate (10000 -> 8000)
update droplist set chance = 8000 where itemid = 20293 and mobid = 45247;
-- decrease cursed emerald ring droprate from Skeletal Pirate (10000 -> 7500)
update droplist set chance = 7500 where itemid = 20296 and mobid = 45247;
-- increase g-haste pot droprate from Skeletal Pirate (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40018 and mobid = 45247;
-- increase emerald droprate from Skeletal Pirate (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40047 and mobid = 45247;
-- increase hqe droprate from Skeletal Pirate (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40051 and mobid = 45247;
-- increase frag droprate from Skeletal Pirate (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40471 and mobid = 45247;

-- modify existing Skeletal Pirate Soldier drops
-- increase cursed diamond ring droprate from Skeletal Pirate Soldier (10000 -> 8000)
update droplist set chance = 8000 where itemid = 20293 and mobid = 45274;
-- increase cursed emerald ring droprate from Skeletal Pirate Soldier (10000 -> 7500)
update droplist set chance = 7500 where itemid = 20296 and mobid = 45274;
-- increase g-haste pot droprate from Skeletal Pirate Soldier (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40018 and mobid = 45274;
-- increase sapphire droprate from Skeletal Pirate Soldier (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40046 and mobid = 45274;
-- increase hqs droprate from Skeletal Pirate Soldier (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40050 and mobid = 45274;
-- increase frag droprate from Skeletal Pirate Soldier (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40471 and mobid = 45274;
-- increase silver arrow droprate from Skeletal Pirate Soldier (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40744 and mobid = 45274;

-- add additional drops to Skeletal Pirate Soldier 
-- add ntele to Skeletal Pirate Soldier droplist 
insert into droplist values (45274, 40100, 1, 1, 75000);

-- modify existing Skeletal Pirate Head drops
-- increase cursed diamond ring droprate from Skeletal Pirate Head (10000 -> 8000)
update droplist set chance = 8000 where itemid = 20293 and mobid = 45330;
-- increase cursed ruby ring droprate from Skeletal Pirate Head (10000 -> 7500)
update droplist set chance = 7500 where itemid = 20294 and mobid = 45330;
-- increase g-haste pot droprate from Skeletal Pirate Head (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40018 and mobid = 45330;
-- increase diamond droprate from Skeletal Pirate Head (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40044 and mobid = 45330;
-- increase hqd droprate from Skeletal Pirate Head (5000 -> 20000)
update droplist set chance = 20000 where itemid = 40048 and mobid = 45330;
-- increase frag droprate from Skeletal Pirate Head (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40471 and mobid = 45330;
-- increase silver arrow droprate from Skeletal Pirate Head (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40744 and mobid = 45330;

-- add additional drops to Skeletal Pirate Head 
-- add hom:s to Skeletal Pirate Head droplist 
insert into droplist values (45330, 20013, 1, 1, 5000);

-- modify existing Giran Ghast drops
-- increase blue pot droprate from Giran Ghast (25000 -> 35000)
update droplist set chance = 35000 where itemid = 40015 and mobid = 45142;
-- increase emerald droprate from Giran Ghast (25000 -> 35000)
update droplist set chance = 35000 where itemid = 40047 and mobid = 45142;
-- increase hqe droprate from Giran Ghast (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40051 and mobid = 45142;
-- increase battle axe droprate from Giran Ghast (2500 -> 7500)
update droplist set chance = 7500 where itemid = 143 and mobid = 45142;

-- modify existing Giran Ghast Lord drops
-- increase blue pot droprate from Giran Ghast Lord (10000 -> 35000)
update droplist set chance = 35000 where itemid = 40015 and mobid = 45188;
-- increase hqe droprate from Giran Ghast Lord (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40051 and mobid = 45188;
-- decrease sb:disease droprate from Giran Ghast Lord (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40201 and mobid = 45188;
-- increase btele droprate from Giran Ghast Lord (50000 -> 150000)
update droplist set chance = 150000 where itemid = 140100 and mobid = 45188;
-- increase berserker axe droprate from Giran Ghast Lord (1000 -> 5000)
update droplist set chance = 5000 where itemid = 145 and mobid = 45188;

-- modify existing Giran Lizardman drops
-- increase sapphire droprate from Giran Lizardman (10000 -> 35000)
update droplist set chance = 35000 where itemid = 40046 and mobid = 45156;
-- increase btele droprate from Giran Lizardman (10000 -> 15000)
update droplist set chance = 15000 where itemid = 140100 and mobid = 45156;

-- modify existing Giran Arachnevil Elder drops
-- decrease sb:fog of sleeping droprate from Giran Arachnevil Elder (10000 -> 2000)
update droplist set chance = 2000 where itemid = 40211 and mobid = 45312;
-- decrease sb:i2h droprate from Giran Arachnevil Elder (250 -> 50)
update droplist set chance = 50 where itemid = 40213 and mobid = 45312;
-- increase btele droprate from Giran Arachnevil Elder (50000 -> 150000)
update droplist set chance = 150000 where itemid = 140100 and mobid = 45312;

-- add additional drops to Giran Tiger 
-- add clear pot to Giran Tiger droplist 
insert into droplist values (45243, 40012, 1, 1, 20000);
-- add haste pot to Giran Tiger droplist 
insert into droplist values (45243, 40013, 1, 1, 50000);
-- add Meat to Giran Tiger droplist 
insert into droplist values (45243, 40056, 1, 1, 25000);
-- add g-haste pot to Giran Tiger droplist 
insert into droplist values (45243, 40018, 1, 1, 50000);

-- modify existing Giran Cerberus drops
-- increase ruby droprate from Giran Cerberus (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40045 and mobid = 45283;

-- add additional drops to Giran Cerberus 
-- add btele to Giran Cerberus droplist 
insert into droplist values (45283, 140100, 1, 1, 50000);

-- modify existing Giran Dire Wolf drops
-- decrease 5mr ring droprate from Giran Dire Wolf (8000 -> 2500)
update droplist set chance = 2500 where itemid = 20303 and mobid = 45282;

-- add additional drops to Giran Dire Wolf 
-- add meat to Giran Dire Wolf droplist 
insert into droplist values (45282, 40015, 1, 1, 50000);
-- add wis pot to Giran Dire Wolf droplist 
insert into droplist values (45282, 40016, 1, 1, 50000);
-- add haste pot to Giran Dire Wolf droplist 
insert into droplist values (45282, 40013, 1, 1, 40000);
-- add g-haste pot to Giran Dire Wolf droplist 
insert into droplist values (45282, 40018, 1, 1, 20000);
-- add clear pot to Giran Dire Wolf droplist 
insert into droplist values (45282, 40012, 1, 1, 15000);
-- add btele to Giran Dire Wolf droplist 
insert into droplist values (45282, 140100, 1, 1, 50000);

-- modify existing Giran Cimaera drops
-- increase red pot droprate from Giran Cimaera (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40010 and mobid = 45325;
-- decrease clear pot droprate from Giran Cimaera (50000 -> 20000)
update droplist set chance = 20000 where itemid = 40012 and mobid = 45325;
-- increase c-red droprate from Giran Cimaera (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40019 and mobid = 45325;
-- decrease c-clear droprate from Giran Cimaera (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40021 and mobid = 45325;
-- decrease lvl1 blank droprate from Giran Cimaera (50000 -> 40000)
update droplist set chance = 40000 where itemid = 40090 and mobid = 45325;
-- decrease lvl2 blank droprate from Giran Cimaera (50000 -> 30000)
update droplist set chance = 30000 where itemid = 40091 and mobid = 45325;
-- decrease lvl3 blank droprate from Giran Cimaera (50000 -> 20000)
update droplist set chance = 20000 where itemid = 40092 and mobid = 45325;

-- modify existing Giran Lava Golem drops
-- decrease sb:fs droprate from Giran Lava Golem (10000 -> 1500)
update droplist set chance = 1500 where itemid = 40215 and mobid = 45376;
-- decrease sc:ebind droprate from Giran Lava Golem (1000 -> 500)
update droplist set chance = 500 where itemid = 40249 and mobid = 45376;
-- decrease sc:exotic vitalize droprate from Giran Lava Golem (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40252 and mobid = 45376;
-- decrease sc:burning weapon droprate from Giran Lava Golem (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40258 and mobid = 45376;

-- modify existing Cerenis drops
-- increase sb:adv droprate from Cerenis (5000 -> 7000)
update droplist set chance = 1500 where itemid = 40215 and mobid = 45376;
-- increase silver cloak droprate from Cerenis (5000 -> 7000)
update droplist set chance = 1500 where itemid = 20074 and mobid = 45376;

-- add additional drops to Aaarrrggg... 
-- add tsu to Aaarrrggg... droplist 
insert into droplist values (45671, 57, 1, 1, 5000);
-- add b-banana to Aaarrrggg... droplist 
insert into droplist values (45671, 140062, 1, 1, 500);

-- modify existing FI Alligator drops
-- increase orange pot droprate from FI Alligator (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45196;
-- decrease clear pot droprate from FI Alligator (50000 -> 35000)
update droplist set chance = 35000 where itemid = 40012 and mobid = 45196;
-- decrease c-clear droprate from FI Alligator (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40021 and mobid = 45196;
-- increase c-red droprate from FI Alligator (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40019 and mobid = 45196;
-- increase brave pot droprate from FI Alligator (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40014 and mobid = 45196;
-- decrease lvl2 blank droprate from FI Alligator (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45196;
-- decrease lvl3 blank droprate from FI Alligator (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45196;
-- decrease lvl4 blank droprate from FI Alligator (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40093 and mobid = 45196;
-- decrease lvl5 blank droprate from FI Alligator (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45196;

-- modify existing FI Werewolf drops
-- decrease clear pot droprate from FI Werewolf (50000 -> 35000)
update droplist set chance = 35000 where itemid = 40012 and mobid = 45355;
-- decrease c-clear droprate from FI Werewolf (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40021 and mobid = 45355;
-- increase c-red droprate from FI Werewolf (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40019 and mobid = 45355;
-- increase brave pot droprate from FI Werewolf (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40014 and mobid = 45355;
-- decrease lvl2 blank droprate from FI Werewolf (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45355;
-- decrease lvl3 blank droprate from FI Werewolf (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45355;
-- decrease lvl4 blank droprate from FI Werewolf (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40093 and mobid = 45355;
-- decrease lvl5 blank droprate from FI Werewolf (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45355;
-- decrease fsm droprate from FI Werewolf (5000 -> 1500)
update droplist set chance = 1500 where itemid = 20142 and mobid = 45355;

-- modify existing FI Arachnevil drops
-- decrease clear pot droprate from FI Arachnevil (50000 -> 35000)
update droplist set chance = 35000 where itemid = 40012 and mobid = 45358;
-- decrease c-clear droprate from FI Arachnevil (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40021 and mobid = 45358;
-- increase c-red droprate from FI Arachnevil (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40019 and mobid = 45358;
-- increase wafer droprate from FI Arachnevil (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40068 and mobid = 45358;
-- decrease sb:fog of sleeping droprate from FI Arachnevil (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40211 and mobid = 45358;
-- decrease lvl2 blank droprate from FI Arachnevil (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45358;
-- decrease lvl3 blank droprate from FI Arachnevil (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45358;
-- decrease lvl4 blank droprate from FI Arachnevil (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40093 and mobid = 45358;
-- decrease lvl5 blank droprate from FI Arachnevil (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45358;
-- decrease fsm droprate from FI Arachnevil (5000 -> 1000)
update droplist set chance = 1000 where itemid = 20142 and mobid = 45358;

-- modify existing FI Cockatrice drops
-- decrease fpm droprate from FI Cockatrice (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20143 and mobid = 45362;
-- increase orange pot droprate from FI Cockatrice (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45362;
-- increase brave pot droprate from FI Cockatrice (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40014 and mobid = 45362;
-- increase blue pot droprate from FI Cockatrice (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40015 and mobid = 45362;
-- increase wis pot droprate from FI Cockatrice (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40016 and mobid = 45362;
-- increase g-haste pot droprate from FI Cockatrice (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45362;
-- increase c-red droprate from FI Cockatrice (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40019 and mobid = 45362;
-- increase c-orange droprate from FI Cockatrice (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40020 and mobid = 45362;
-- increase wafer droprate from FI Cockatrice (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40068 and mobid = 45362;
-- decrease lvl3 blank droprate from FI Cockatrice (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40092 and mobid = 45362;
-- decrease lvl4 blank droprate from FI Cockatrice (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45362;
-- decrease lvl5 blank droprate from FI Cockatrice (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40094 and mobid = 45362;
-- increase id scroll droprate from FI Cockatrice (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40126 and mobid = 45362;
-- increase whetstone droprate from FI Cockatrice (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40317 and mobid = 45362;
-- decrease f-sword droprate from FI Cockatrice (10000 -> 2500)
update droplist set chance = 2500 where itemid = 18 and mobid = 45362;

-- modify existing FI Dark Elf drops
-- decrease Old Helm of Wind droprate from FI Dark Elf (7000 -> 3500)
update droplist set chance = 3500 where itemid = 20008 and mobid = 45364;
-- decrease fla droprate from FI Dark Elf (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20140 and mobid = 45364;
-- decrease 10MR droprate from FI Dark Elf (500 -> 400)
update droplist set chance = 400 where itemid = 20280 and mobid = 45364;
-- decrease 5MR droprate from FI Dark Elf (8000 -> 5000)
update droplist set chance = 5000 where itemid = 20303 and mobid = 45364;
-- increase orange pot droprate from FI Dark Elf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45364;
-- decrease brave pot droprate from FI Dark Elf (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40014 and mobid = 45364;
-- increase wis pot droprate from FI Dark Elf (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40016 and mobid = 45364;
-- increase g-haste pot droprate from FI Dark Elf (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45364;
-- increase c-red droprate from FI Dark Elf (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40019 and mobid = 45364;
-- increase c-orange droprate from FI Dark Elf (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40020 and mobid = 45364;
-- increase wafer droprate from FI Dark Elf (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40068 and mobid = 45364;
-- decrease lvl2 blank droprate from FI Dark Elf (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45364;
-- decrease lvl3 blank droprate from FI Dark Elf (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45364;
-- decrease lvl4 blank droprate from FI Dark Elf (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45364;
-- decrease lvl5 blank droprate from FI Dark Elf (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45364;

-- add additional drops to FI Dark Elf 
-- add ebony to FI Dark Elf droplist 
insert into droplist values (45364, 40007, 1, 1, 25000);

-- modify existing FI Owlbear drops
-- decrease fla droprate from FI Owlbear (5000 -> 2000)
update droplist set chance = 2000 where itemid = 20140 and mobid = 45371;
-- increase orange pot droprate from FI Owlbear (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45371;
-- increase brave pot droprate from FI Owlbear (10000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45371;
-- increase c-red droprate from FI Owlbear (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40019 and mobid = 45371;
-- increase c-orange droprate from FI Owlbear (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40020 and mobid = 45371;
-- increase wafer droprate from FI Owlbear (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40068 and mobid = 45371;
-- decrease lvl2 blank droprate from FI Owlbear (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45371;
-- decrease lvl3 blank droprate from FI Owlbear (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45371;
-- decrease lvl4 blank droprate from FI Owlbear (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40093 and mobid = 45371;
-- decrease lvl5 blank droprate from FI Owlbear (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45371;

-- modify existing FI Lizardman drops
-- decrease f-robe droprate from FI Lizardman (5000 -> 2500)
update droplist set chance = 2500 where itemid = 20141 and mobid = 45377;
-- increase orange pot droprate from FI Lizardman (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40011 and mobid = 45377;
-- increase g-haste pot droprate from FI Lizardman (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45377;
-- increase c-red droprate from FI Lizardman (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45377;
-- increase c-oj droprate from FI Lizardman (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40020 and mobid = 45377;
-- decrease lvl2 blank droprate from FI Lizardman (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45377;
-- decrease lvl3 blank droprate from FI Lizardman (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45377;
-- decrease lvl4 blank droprate from FI Lizardman (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40093 and mobid = 45377;
-- decrease lvl5 blank droprate from FI Lizardman (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45377;

-- modify existing FI Ghast drops
-- decrease fla droprate from FI Ghast (5000 -> 2000)
update droplist set chance = 2000 where itemid = 20140 and mobid = 45378;
-- increase ebony droprate from FI Ghast (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40007 and mobid = 45378;
-- increase orange pot droprate from FI Ghast (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40011 and mobid = 45378;
-- increase cure pot droprate from FI Ghast (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40017 and mobid = 45378;
-- increase c-red droprate from FI Ghast (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40019 and mobid = 45378;
-- increase c-oj droprate from FI Ghast (10000 -> 17500)
update droplist set chance = 17500 where itemid = 40020 and mobid = 45378;
-- decrease lvl2 blank droprate from FI Ghast (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45378;
-- decrease lvl3 blank droprate from FI Ghast (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45378;
-- decrease lvl4 blank droprate from FI Ghast (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40093 and mobid = 45378;
-- decrease lvl5 blank droprate from FI Ghast (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45378;
-- increase nprat droprate from FI Ghast (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40119 and mobid = 45378;
-- increase res scroll droprate from FI Ghast (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40089 and mobid = 45378;

-- add additional drops to FI Ghast 
-- add 5MR ring to FI Ghast droplist 
insert into droplist values (45378, 20303, 1, 1, 1500);

-- modify existing FI Ramia drops
-- decrease f-robe droprate from FI Ramia (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20141 and mobid = 45387;
-- decrease fsm droprate from FI Ramia (5000 -> 1500)
update droplist set chance = 1500 where itemid = 20142 and mobid = 45387;
-- increase underwater boots droprate from FI Ramia (1000 -> 1200)
update droplist set chance = 1200 where itemid = 20207 and mobid = 45387;
-- increase orange pot droprate from FI Ramia (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45387;
-- increase blue pot droprate from FI Ramia (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40015 and mobid = 45387;
-- increase wis pot droprate from FI Ramia (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40016 and mobid = 45387;
-- increase cure pot droprate from FI Ramia (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40017 and mobid = 45387;
-- increase c-red droprate from FI Ramia (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40019 and mobid = 45387;
-- increase c-oj droprate from FI Ramia (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40020 and mobid = 45387;
-- decrease lvl3 blank droprate from FI Ramia (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45387;
-- decrease lvl4 blank droprate from FI Ramia (10000 -> 4000)
update droplist set chance = 4000 where itemid = 40093 and mobid = 45387;
-- decrease lvl5 blank droprate from FI Ramia (10000 -> 2000)
update droplist set chance = 2000 where itemid = 40094 and mobid = 45387;
-- increase nprat droprate from FI Ramia (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40119 and mobid = 45387;
-- increase id scroll droprate from FI Ramia (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40126 and mobid = 45387;

-- modify existing FI Lycanthrope drops
-- decrease Old Helm of Wind droprate from FI Lycanthrope (7000 -> 3000)
update droplist set chance = 3000 where itemid = 20008 and mobid = 45389;
-- decrease fla droprate from FI Lycanthrope (5000 -> 2500)
update droplist set chance = 2500 where itemid = 20140 and mobid = 45389;
-- decrease 5MR ring droprate from FI Lycanthrope (8000 -> 4000)
update droplist set chance = 4000 where itemid = 20303 and mobid = 45389;
-- increase orange pot droprate from FI Lycanthrope (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45389;
-- increase brave pot droprate from FI Lycanthrope (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40014 and mobid = 45389;
-- increase c-red droprate from FI Lycanthrope (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40019 and mobid = 45389;
-- increase c-oj droprate from FI Lycanthrope (10000 -> 17500)
update droplist set chance = 17500 where itemid = 40020 and mobid = 45389;
-- decrease lvl3 blank droprate from FI Lycanthrope (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45389;
-- decrease lvl4 blank droprate from FI Lycanthrope (10000 -> 4000)
update droplist set chance = 4000 where itemid = 40093 and mobid = 45389;
-- decrease lvl5 blank droprate from FI Lycanthrope (10000 -> 2000)
update droplist set chance = 2000 where itemid = 40094 and mobid = 45389;

-- modify existing FI Minotaur (axe) drops
-- decrease fsm droprate from FI Minotaur (axe) (5000 -> 2500)
update droplist set chance = 2500 where itemid = 20142 and mobid = 45390;
-- decrease 5MR ring droprate from FI Minotaur (axe) (8000 -> 4500)
update droplist set chance = 4500 where itemid = 20303 and mobid = 45390;
-- increase orange pot droprate from FI Minotaur (axe) (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40011 and mobid = 45390;
-- increase brave pot droprate from FI Minotaur (axe) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40014 and mobid = 45390;
-- increase c-red droprate from FI Minotaur (axe) (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45390;
-- increase c-oj droprate from FI Minotaur (axe) (10000 -> 35000)
update droplist set chance = 35000 where itemid = 40020 and mobid = 45390;
-- increase c-clear droprate from FI Minotaur (axe) (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40021 and mobid = 45390;
-- increase wafer droprate from FI Minotaur (axe) (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40068 and mobid = 45390;
-- decrease lvl4 blank droprate from FI Minotaur (axe) (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40093 and mobid = 45390;
-- decrease lvl5 blank droprate from FI Minotaur (axe) (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40094 and mobid = 45390;
-- increase nprat droprate from FI Minotaur (axe) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40119 and mobid = 45390;
-- increase id scroll droprate from FI Minotaur (axe) (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40126 and mobid = 45390;

-- add additional drops to FI Minotaur (axe) 
-- add whetstone to FI Minotaur (axe) droplist 
insert into droplist values (45390, 40317, 1, 1, 20000);

-- modify existing FI Bugbear drops
-- decrease f-robe droprate from FI Bugbear (5000 -> 2000)
update droplist set chance = 2000 where itemid = 20141 and mobid = 45392;
-- increase orange pot droprate from FI Bugbear (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45392;
-- increase c-red droprate from FI Bugbear (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40019 and mobid = 45392;
-- increase c-oj droprate from FI Bugbear (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40020 and mobid = 45392;
-- decrease lvl3 blank droprate from FI Bugbear (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45392;
-- decrease lvl4 blank droprate from FI Bugbear (10000 -> 4000)
update droplist set chance = 4000 where itemid = 40093 and mobid = 45392;
-- decrease lvl5 blank droprate from FI Bugbear (10000 -> 2000)
update droplist set chance = 2000 where itemid = 40094 and mobid = 45392;
-- increase id scroll droprate from FI Bugbear (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40126 and mobid = 45392;
-- increase whetstone droprate from FI Bugbear (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40317 and mobid = 45392;

-- add additional drops to FI Bugbear 
-- add 10MR ring to FI Bugbear droplist 
insert into droplist values (45392, 20280, 1, 1, 100);

-- modify existing FI Arachnevil Elder drops
-- decrease fla droprate from FI Arachnevil Elder (5000 -> 2000)
update droplist set chance = 2000 where itemid = 20140 and mobid = 45401;
-- decrease 5MR ring droprate from FI Arachnevil Elder (8000 -> 2500)
update droplist set chance = 2500 where itemid = 20303 and mobid = 45401;
-- increase orange pot droprate from FI Arachnevil Elder (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45401;
-- increase cure pot droprate from FI Arachnevil Elder (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40017 and mobid = 45401;
-- increase c-red droprate from FI Arachnevil Elder (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40019 and mobid = 45401;
-- increase c-oj droprate from FI Arachnevil Elder (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40020 and mobid = 45401;
-- decrease lvl3 blank droprate from FI Arachnevil Elder (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40092 and mobid = 45401;
-- increase lvl4 blank droprate from FI Arachnevil Elder (10000 -> 2000)
update droplist set chance = 2000 where itemid = 40093 and mobid = 45401;
-- increase lvl5 blank droprate from FI Arachnevil Elder (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45401;
-- increase nprat droprate from FI Arachnevil Elder (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40119 and mobid = 45401;

-- modify existing FI Griffon drops
-- decrease helm of wind droprate from FI Griffon (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20023 and mobid = 45445;
-- decrease f-robe droprate from FI Griffon (5000 -> 3000)
update droplist set chance = 3000 where itemid = 20141 and mobid = 45445;
-- decrease 10MR ring droprate from FI Griffon (1000 -> 900)
update droplist set chance = 900 where itemid = 20280 and mobid = 45445;
-- increase orange pot droprate from FI Griffon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45445;
-- increase wis pot droprate from FI Griffon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40016 and mobid = 45445;
-- increase c-red droprate from FI Griffon (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40019 and mobid = 45445;
-- increase c-oj droprate from FI Griffon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40020 and mobid = 45445;
-- decrease lvl4 blank droprate from FI Griffon (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40093 and mobid = 45445;
-- decrease lvl5 blank droprate from FI Griffon (10000 -> 4000)
update droplist set chance = 4000 where itemid = 40094 and mobid = 45445;
-- increase id scroll droprate from FI Griffon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40126 and mobid = 45445;
-- increase f-bowgun droprate from FI Griffon (5000 -> 2000)
update droplist set chance = 2000 where itemid = 167 and mobid = 45445;

-- add additional drops to FI Griffon 
-- add 5MR ring to FI Griffon droplist 
insert into droplist values (45445, 20303, 1, 1, 2000);

-- modify existing FI Minotaur (mace) drops
-- decrease fpm droprate from FI Minotaur (mace) (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20143 and mobid = 45449;
-- decrease 5MR ring droprate from FI Minotaur (mace) (8000 -> 5000)
update droplist set chance = 5000 where itemid = 20303 and mobid = 45449;
-- increase orange pot droprate from FI Minotaur (mace) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45449;
-- increase brave pot droprate from FI Minotaur (mace) (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40014 and mobid = 45449;
-- increase blue pot droprate from FI Minotaur (mace) (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40015 and mobid = 45449;
-- increase wis pot droprate from FI Minotaur (mace) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40016 and mobid = 45449;
-- increase g-haste pot droprate from FI Minotaur (mace) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45449;
-- increase c-red droprate from FI Minotaur (mace) (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45449;
-- increase c-oj droprate from FI Minotaur (mace) (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40020 and mobid = 45449;
-- increase wafer droprate from FI Minotaur (mace) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40068 and mobid = 45449;
-- increase res scroll droprate from FI Minotaur (mace) (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40089 and mobid = 45449;
-- decrease lvl4 blank droprate from FI Minotaur (mace) (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40093 and mobid = 45449;
-- decrease lvl5 blank droprate from FI Minotaur (mace) (1000 -> 4000)
update droplist set chance = 4000 where itemid = 40094 and mobid = 45449;
-- increase nprat droprate from FI Minotaur (mace) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40119 and mobid = 45449;
-- increase id scroll droprate from FI Minotaur (mace) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40126 and mobid = 45449;

-- add additional drops to FI Minotaur (mace) 
-- add whetstone to FI Minotaur (mace) droplist 
insert into droplist values (45449, 40317, 1, 1, 25000);

-- modify existing FI Harpy drops
-- decrease underwater boots droprate from FI Harpy (1000 -> 800)
update droplist set chance = 800 where itemid = 20207 and mobid = 45452;
-- increase ebony droprate from FI Harpy (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40007 and mobid = 45452;
-- increase orange pot droprate from FI Harpy (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45452;
-- increase blue pot droprate from FI Harpy (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40015 and mobid = 45452;
-- increase wis pot droprate from FI Harpy (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40016 and mobid = 45452;
-- increase c-red droprate from FI Harpy (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40019 and mobid = 45452;
-- increase c-oj droprate from FI Harpy (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40020 and mobid = 45452;
-- increase wafer droprate from FI Harpy (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40068 and mobid = 45452;
-- decrease lvl4 blank droprate from FI Harpy (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45452;
-- decrease lvl5 blank droprate from FI Harpy (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40094 and mobid = 45452;
-- increase nprat droprate from FI Harpy (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40119 and mobid = 45452;

-- add additional drops to FI Harpy 
-- add 5MR ring to FI Harpy droplist 
insert into droplist values (45452, 20303, 1, 1, 2500);
-- add 10MR ring to FI Harpy droplist 
insert into droplist values (45452, 20280, 1, 1, 200);
-- add fsm to FI Harpy droplist 
insert into droplist values (45452, 20142, 1, 1, 2000);
-- add a-scroll to FI Harpy droplist 
insert into droplist values (45452, 40076, 1, 1, 250);
-- add old helm of wind to FI Harpy droplist 
insert into droplist values (45452, 20008, 1, 1, 1500);

-- modify existing FI Doppelganger drops
-- increase orange pot droprate from FI Doppelganger (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45457;
-- increase blue pot droprate from FI Doppelganger (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40015 and mobid = 45457;
-- increase c-red droprate from FI Doppelganger (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45457;
-- increase c-oj droprate from FI Doppelganger (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40020 and mobid = 45457;
-- increase c-clear droprate from FI Doppelganger (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40021 and mobid = 45457;
-- decrease lvl5 blank droprate from FI Doppelganger (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45457;
-- increase nprat droprate from FI Doppelganger (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40119 and mobid = 45457;

-- modify existing FI Crocodile drops
-- decrease fpm droprate from FI Crocodile (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20143 and mobid = 45469;
-- decrease 5MR ring droprate from FI Crocodile (8000 -> 5000)
update droplist set chance = 5000 where itemid = 20303 and mobid = 45469;
-- increase orange pot droprate from FI Crocodile (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40011 and mobid = 45469;
-- increase clear pot droprate from FI Crocodile (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40012 and mobid = 45469;
-- increase brave pot droprate from FI Crocodile (10000 -> 35000)
update droplist set chance = 35000 where itemid = 40014 and mobid = 45469;
-- increase c-red droprate from FI Crocodile (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45469;
-- increase c-oj droprate from FI Crocodile (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40020 and mobid = 45469;
-- increase c-clear droprate from FI Crocodile (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40021 and mobid = 45469;
-- increase wafer droprate from FI Crocodile (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40068 and mobid = 45469;
-- increase whetstone droprate from FI Crocodile (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40317 and mobid = 45469;

-- modify existing FI Ghast Lord drops
-- decrease fla droprate from FI Ghast Lord (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20140 and mobid = 45470;
-- decrease 5MR ring droprate from FI Ghast Lord (8000 -> 5000)
update droplist set chance = 5000 where itemid = 20303 and mobid = 45470;
-- increase c-red droprate from FI Ghast Lord (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45470;
-- increase c-oj droprate from FI Ghast Lord (10000 -> 35000)
update droplist set chance = 35000 where itemid = 40020 and mobid = 45470;
-- increase c-clear droprate from FI Ghast Lord (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40021 and mobid = 45470;
-- increase wafer droprate from FI Ghast Lord (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40068 and mobid = 45470;
-- decrease lvl4 blank droprate from FI Ghast Lord (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40093 and mobid = 45470;
-- increase lvl5 blank droprate from FI Ghast Lord (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40094 and mobid = 45470;
-- increase nprat droprate from FI Ghast Lord (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40119 and mobid = 45470;

-- modify existing FI Troll drops
-- decrease fsm droprate from FI Troll (5000 -> 3000)
update droplist set chance = 3000 where itemid = 20142 and mobid = 45477;
-- decrease troll belt droprate from FI Troll (10000 -> 6500)
update droplist set chance = 6500 where itemid = 20321 and mobid = 45477;
-- increase orange pot droprate from FI Troll (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40011 and mobid = 45477;
-- increase clear pot droprate from FI Troll (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40012 and mobid = 45477;
-- increase brave pot droprate from FI Troll (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40014 and mobid = 45477;
-- increase c-red droprate from FI Troll (10000 -> 75000)
update droplist set chance = 75000 where itemid = 40019 and mobid = 45477;
-- increase c-oj droprate from FI Troll (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40020 and mobid = 45477;
-- increase c-clear droprate from FI Troll (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40021 and mobid = 45477;
-- decrease lvl3 blank droprate from FI Troll (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40092 and mobid = 45477;
-- decrease lvl4 blank droprate from FI Troll (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45477;
-- decrease lvl5 blank droprate from FI Troll (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40094 and mobid = 45477;

-- add additional drops to FI Troll 
-- add fpm to FI Troll droplist 
insert into droplist values (45477, 20143, 1, 1, 1500);

-- modify existing FI Ettin drops
-- decrease fpm droprate from FI Ettin (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20143 and mobid = 45505;
-- increase 10MR ring droprate from FI Ettin (1000 -> 800)
update droplist set chance = 800 where itemid = 20280 and mobid = 45505;
-- increase orange pot droprate from FI Ettin (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40011 and mobid = 45505;
-- increase clear pot droprate from FI Ettin (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40012 and mobid = 45505;
-- increase brave pot droprate from FI Ettin (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40014 and mobid = 45505;
-- increase g-haste pot droprate from FI Ettin (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40018 and mobid = 45505;
-- increase c-red droprate from FI Ettin (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45505;
-- increase c-oj droprate from FI Ettin (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40020 and mobid = 45505;
-- increase c-clear droprate from FI Ettin (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40021 and mobid = 45505;
-- decrease lvl3 blank droprate from FI Ettin (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40092 and mobid = 45505;
-- decrease lvl4 blank droprate from FI Ettin (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45505;
-- decrease lvl5 blank droprate from FI Ettin (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40094 and mobid = 45505;
-- increase whetstone droprate from FI Ettin (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40317 and mobid = 45505;

-- add additional drops to FI Ettin 
-- add f-sword to FI Ettin droplist 
insert into droplist values (45505, 18, 1, 1, 1000);

-- modify existing FI King Bugbear drops
-- increase fpm droprate from FI King Bugbear (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20143 and mobid = 45509;
-- increase 5MR ring droprate from FI King Bugbear (8000 -> 5000)
update droplist set chance = 5000 where itemid = 20303 and mobid = 45509;
-- increase orange pot droprate from FI King Bugbear (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45509;
-- increase clear pot droprate from FI King Bugbear (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40012 and mobid = 45509;
-- increase c-red droprate from FI King Bugbear (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40019 and mobid = 45509;
-- increase c-oj droprate from FI King Bugbear (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40020 and mobid = 45509;
-- increase c-clear droprate from FI King Bugbear (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40021 and mobid = 45509;
-- decrease lvl3 blank droprate from FI King Bugbear (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40092 and mobid = 45509;
-- decrease lvl4 blank droprate from FI King Bugbear (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45509;
-- decrease lvl5 blank droprate from FI King Bugbear (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40094 and mobid = 45509;
-- increase whetstone droprate from FI King Bugbear (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40317 and mobid = 45509;

-- add additional drops to FI King Bugbear 
-- add fsm to FI King Bugbear droplist 
insert into droplist values (45509, 20142, 1, 1, 1500);
-- add 10MR to FI King Bugbear droplist 
insert into droplist values (45509, 20280, 1, 1, 200);

-- modify existing FI Basilisk drops
-- decrease f-sword droprate from FI Basilisk (10000 -> 2500)
update droplist set chance = 2500 where itemid = 18 and mobid = 45531;
-- decrease f-robe droprate from FI Basilisk (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20141 and mobid = 45531;
-- increase orange pot droprate from FI Basilisk (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45531;
-- increase c-red droprate from FI Basilisk (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40019 and mobid = 45531;
-- increase c-oj droprate from FI Basilisk (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40020 and mobid = 45531;
-- increase wafer droprate from FI Basilisk (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40068 and mobid = 45531;

-- modify existing FI Cyclops drops
-- decrease f-gsword droprate from FI Cyclops (10000 -> 3500)
update droplist set chance = 2500 where itemid = 17 and mobid = 45538;
-- decrease fpm droprate from FI Cyclops (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20143 and mobid = 45538;
-- increase orange pot droprate from FI Cyclops (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45538;
-- increase brave pot droprate from FI Cyclops (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40014 and mobid = 45538;
-- increase g-haste pot droprate from FI Cyclops (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45538;
-- increase c-red droprate from FI Cyclops (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40019 and mobid = 45538;
-- increase c-oj droprate from FI Cyclops (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40020 and mobid = 45538;
-- increase nprat droprate from FI Cyclops (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40119 and mobid = 45538;
-- increase id scroll droprate from FI Cyclops (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40126 and mobid = 45538;
-- increase whetstone droprate from FI Cyclops (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40317 and mobid = 45538;

-- modify existing FI Drake drops
-- decrease f-bowgun droprate from FI Drake (10000 -> 3500)
update droplist set chance = 3500 where itemid = 167 and mobid = 45578;
-- decrease 5MR ring droprate from FI Drake (8000 -> 5000)
update droplist set chance = 5000 where itemid = 20303 and mobid = 45578;
-- increase helm of wind droprate from FI Drake (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20023 and mobid = 45578;
-- increase fla droprate from FI Drake (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20140 and mobid = 45578;
-- increase orange pot droprate from FI Drake (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45578;
-- increase clear pot droprate from FI Drake (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40012 and mobid = 45578;
-- increase brave pot droprate from FI Drake (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40014 and mobid = 45578;
-- increase blue pot droprate from FI Drake (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40015 and mobid = 45578;
-- increase wis pot droprate from FI Drake (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40016 and mobid = 45578;
-- increase g-haste pot droprate from FI Drake (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45578;
-- increase c-red droprate from FI Drake (10000 -> 60000)
update droplist set chance = 60000 where itemid = 40019 and mobid = 45578;
-- increase c-oj droprate from FI Drake (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40020 and mobid = 45578;
-- increase c-clear droprate from FI Drake (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40021 and mobid = 45578;
-- increase wafer droprate from FI Drake (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40068 and mobid = 45578;
-- increase res scroll droprate from FI Drake (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40089 and mobid = 45578;
-- increase lvl1 blank droprate from FI Drake (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40090 and mobid = 45578;
-- increase lvl2 blank droprate from FI Drake (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40091 and mobid = 45578;
-- increase lvl3 blank droprate from FI Drake (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40092 and mobid = 45578;
-- increase lvl4 blank droprate from FI Drake (10000 -> 20000)
update droplist set chance = 25000 where itemid = 40093 and mobid = 45578;
-- increase lvl5 blank droprate from FI Drake (10000 -> 20000)
update droplist set chance = 25000 where itemid = 40094 and mobid = 45578;
-- increase nprat droprate from FI Drake (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40119 and mobid = 45578;
-- increase id scroll droprate from FI Drake (10000 -> 75000)
update droplist set chance = 75000 where itemid = 40126 and mobid = 45578;

-- add additional drops to FI Drake 
-- add f-sword to FI Drake droplist 
insert into droplist values (45578, 18, 1, 1, 1000);

-- modify existing Greater Minotaur drops
-- decrease sc:storm shot droprate from Greater Minotaur (50000 -> 20000)
update droplist set chance = 20000 where itemid = 40263 and mobid = 45584;
-- increase great sword droprate from Greater Minotaur (10000 -> 25000)
update droplist set chance = 25000 where itemid = 64 and mobid = 45584;

-- modify existing Bugbear drops
-- decrease splint mail droprate from Bugbear (25000 -> 20000)
update droplist set chance = 20000 where itemid = 20115 and mobid = 45223;
-- decrease nzel droprate from Bugbear (50000 -> 38000)
update droplist set chance = 38000 where itemid = 40074 and mobid = 45223;
-- increase ndai droprate from Bugbear (25000 -> 19000)
update droplist set chance = 19000 where itemid = 40087 and mobid = 45223;
-- increase btele droprate from Bugbear (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45223;
-- decrease b-axe droprate from Bugbear (25000 -> 18000)
update droplist set chance = 18000 where itemid = 143 and mobid = 45223;
-- decrease gaxe droprate from Bugbear (25000 -> 10000)
update droplist set chance = 10000 where itemid = 148 and mobid = 45223;

-- modify existing Cerberus drops
-- decrease sb:i2h droprate from Cerberus (150 -> 120)
update droplist set chance = 120 where itemid = 40213 and mobid = 45241;
-- increase bbs droprate from Cerberus (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45241;

-- modify existing King Bugbear drops
-- decrease banded mail droprate from King Bugbear (25000 -> 18000)
update droplist set chance = 18000 where itemid = 20101 and mobid = 45298;
-- decrease splint mail droprate from King Bugbear (25000 -> 20000)
update droplist set chance = 20000 where itemid = 20115 and mobid = 45298;
-- increase devil's blood droprate from King Bugbear (5000 -> 8000)
update droplist set chance = 8000 where itemid = 40031 and mobid = 45298;
-- increase nzel droprate from King Bugbear (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40074 and mobid = 45298;
-- increase ndai droprate from King Bugbear (5000 -> 20000)
update droplist set chance = 20000 where itemid = 40087 and mobid = 45298;
-- decrease sb:disease droprate from King Bugbear (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40201 and mobid = 45298;
-- increase btele droprate from King Bugbear (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45298;
-- decrease club droprate from King Bugbear (25000 -> 20000)
update droplist set chance = 20000 where itemid = 138 and mobid = 45298;
-- decrease b-axe droprate from King Bugbear (25000 -> 18000)
update droplist set chance = 18000 where itemid = 143 and mobid = 45298;
-- increase beserker axe droprate from King Bugbear (1000 -> 2500)
update droplist set chance = 2500 where itemid = 145 and mobid = 45298;
-- decrease sc:r2n droprate from King Bugbear (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40237 and mobid = 45298;

-- modify existing living armor drops
-- increase hqd droprate from living armor (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40048 and mobid = 45322;
-- increase hqs droprate from living armor (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40050 and mobid = 45322;
-- decrease sb:full heal droprate from living armor (1000 -> 7500)
update droplist set chance = 7500 where itemid = 40202 and mobid = 45322;

-- modify existing crabman drops
-- increase nzel droprate from crabman (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45164;

-- modify existing giant ant drops
-- decrease btele droprate from giant ant (300000 -> 175000)
update droplist set chance = 175000 where itemid = 140100 and mobid = 45115;

-- add additional drops to giant ant 
-- add ruby to giant ant droplist 
insert into droplist values (45115, 40045, 1, 1, 20000);
-- add hqe to giant ant droplist 
insert into droplist values (45115, 40051, 1, 1, 10000);
-- add hqr to giant ant droplist 
insert into droplist values (45115, 40049, 1, 1, 7500);
-- add tqe to giant ant droplist 
insert into droplist values (45115, 40055, 1, 1, 2000);
-- add tqr to giant ant droplist 
insert into droplist values (45115, 40053, 1, 1, 1000);

-- modify existing giant soldier ant drops
-- decrease btele droprate from giant soldier ant (300000 -> 250000)
update droplist set chance = 200000 where itemid = 140100 and mobid = 45190;
-- increase hom:p droprate from giant soldier ant (1000 -> 2000)
update droplist set chance = 2000 where itemid = 20015 and mobid = 45190;
-- increase pm droprate from giant soldier ant (1000 -> 1500)
update droplist set chance = 1500 where itemid = 20154 and mobid = 45190;
-- increase emerald droprate from giant soldier ant (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40047 and mobid = 45190;
-- increase hqe droprate from giant soldier ant (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40051 and mobid = 45190;
-- increase hqr droprate from giant soldier ant (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40049 and mobid = 45190;
-- increase tqe droprate from giant soldier ant (1000 -> 5000)
update droplist set chance = 5000 where itemid = 40055 and mobid = 45190;
-- increase tqr droprate from giant soldier ant (1000 -> 2500)
update droplist set chance = 2500 where itemid = 40053 and mobid = 45190;



-- update 19.1

-- cleanup invalid droplist items
delete from droplist where mobid = 45772 and itemid = 141087;
delete from droplist where mobid = 45772 and itemid = 141074;
delete from droplist where mobid = 45795 and itemid = 141087;
delete from droplist where mobid = 45795 and itemid = 141074;
delete from droplist where mobid = 45273 and itemid = 85000;



-- update 20

-- modify existing lesser dragon drops
-- increase hqd droprate from lesser dragon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40048 and mobid = 45496;
-- increase hqr droprate from lesser dragon (10000 -> 18000)
update droplist set chance = 18000 where itemid = 40049 and mobid = 45496;
-- increase hqs droprate from lesser dragon (10000 -> 18000)
update droplist set chance = 18000 where itemid = 40050 and mobid = 45496;
-- increase hqe droprate from lesser dragon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40051 and mobid = 45496;
-- increase b-poly droprate from lesser dragon (50000 -> 100000)
update droplist set chance = 100000 where itemid = 140088 and mobid = 45496;
-- increase nzel droprate from lesser dragon (20000 -> 40000)
update droplist set chance = 40000 where itemid = 40074 and mobid = 45496;
-- increase ndai droprate from lesser dragon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40087 and mobid = 45496;

-- remove n-poly from lesser dragon droplist
delete from droplist where itemid = 40088 and mobid = 45496;

-- modify existing horrific iron golem drops
-- decrease sc:exotic droprate from horrific iron golem (5000 -> 3000)
update droplist set chance = 3000 where itemid = 40252 and mobid = 45479;
-- decrease dsc:shadow fang droprate from horrific iron golem (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40277 and mobid = 45479;
-- increase rough droprate from horrific iron golem (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40496 and mobid = 45479;

-- correct nprat drop on GC dire wolf (was IT nprat)
update droplist set itemid = 40119 where itemid = 40097 and mobid = 45237;



-- update 21

-- slightly reduce invis droprate from DE (1000 -> 800)
update droplist set chance = 800 where itemid = 40205 and mobid = 45265;



-- update 24

-- add toi81f to knight vald droplist
insert into droplist values (45618, 40111, 1, 5, 500000);



-- update 25

-- slight increase in TOI scroll droprates (10500 -> 12500)
update droplist set chance = 12500 where itemid between 40104 and 40112 and chance = 10500;

-- redo losus island crocodile nzel drop (should be able to drop 1-3)
delete from droplist where mobid = 45338 and itemid = 40074;
insert into droplist values (45338, 40074, 1, 3, 150000);

-- increase devil\'s blood droprate from some mops
-- crabman (5000 -> 7500)
update droplist set chance = 7500 where itemid = 40031 and mobid = 45164;
-- bk (2500 -> 4500)
update droplist set chance = 4500 where itemid = 40031 and mobid = 45165;
-- bugbear (5000 -> 7500)
update droplist set chance = 7500 where itemid = 40031 and mobid in (45223, 45738);
-- de (5000 -> 8500)
update droplist set chance = 8500 where itemid = 40031 and mobid = 45265;
-- Ogre (5000 -> 8500)
update droplist set chance = 8500 where itemid = 40031 and mobid = 45278;
-- King Bugbear (8000 -> 10000)
update droplist set chance = 10000 where itemid = 40031 and mobid = 45298;
-- succubus (3000, 2500 -> 15000)
update droplist set chance = 15000 where itemid = 40031 and mobid in (45393, 45394);
-- succubus queen (5000 -> 18000)
update droplist set chance = 18000 where itemid = 40031 and mobid = 45451;

-- add devil\'s blood to gsa
insert into droplist values (45190, 40031, 1, 1, 5000);

-- add friend\'s bag to drakes quest mop
insert into droplist values(45875, 40710, 1, 1, 1000000);

-- increase TOI charm droprates (5000 -> 15000)
update droplist set chance = 15000 where itemid between 40280 and 40288;