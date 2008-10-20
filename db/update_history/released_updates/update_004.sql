-- update 4

-- add czel to beholder droplist
insert into droplist values (45349, 240074, 1, 1, 5000);

-- add sb: immune to harm to beholder droplist
insert into droplist values (45349, 40213, 1, 1, 100);

-- add diamond to beholder droplist
insert into droplist values (45349, 40044, 1, 1, 5000);

-- correct spelling of "paralyze"
update etcitem set name = 'Spellbook(Paralyze)' where item_id = 40178;
update etcitem set name = 'Scroll of Magic: Paralyze' where item_id = 40891;

-- correct spelling of immune to harm
update etcitem set name = 'Spellbook(ImmuneToHarm)' where item_id = 40213;

-- increase brave/orange pot droprate from giants
update droplist set chance = 5000 where mobid = 45295 and itemid = 40014;
update droplist set chance = 5000 where mobid = 45337 and itemid = 40014;
update droplist set chance = 5000 where mobid = 45351 and itemid = 40014;
update droplist set chance = 5000 where mobid = 45295 and itemid = 40011;
update droplist set chance = 5000 where mobid = 45337 and itemid = 40011;
update droplist set chance = 5000 where mobid = 45351 and itemid = 40011;

-- add names to heine dungeon scorp and ramia
update npc set name = 'Scorpian' where npcid = 81077;
update npc set name = 'Ramia' where npcid = 81076;
update npc set nameid = '$966' where npcid = 81077;

-- fix elindaire name and nameid
update npc set name = 'Elindaire', nameid = 'Elindaire' where npcid = 81081;

-- reduce by 50% elf lvl 30 quest area spawnrate
update spawnlist set count = count / 2 where mapid = 213;

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

-- reduce ancient giant's aoe damage by 20%
update skills set damage_value = 80 where skill_id = 10019;

-- reduce ancient giant's aoe range by 4 and reduce frequency ancient giant casts aoe
update mobskill set trirange = -7, trirnd = 20 where mobid = 45610 and actno = 0;

-- swap images for bpm and cpm
update armor set name_id = '$153' where item_id in (20149, 120149);
update armor set name_id = '$154' where item_id in (20128, 120128);

-- correct n-cpm name
update armor set name = 'Crystal Plate Mail' where item_id = 20128;

-- reduce immune to harm droprate for death, cerebus, dark elemental, giran cerberus, giran arach elder, living armor
update droplist set chance = 250 where itemid = 40213 and mobid in (45221, 45241, 45244, 45283, 45312, 45322);

-- correct staff of sorcery name
update weapon set name = 'Staff of Sorcery' where item_id = 125;

-- reduce summon drop rate
update droplist set chance = chance / 2 where mobid in (45142, 45213, 45279, 45393, 45394, 45451, 45546, 45546, 45572, 45573);

-- rename triple shot spirit crystal
update etcitem set name = 'Spirit Crystal(TripleShot)' where item_id = 40240;

-- change Cursed Katana name to just Katana
update weapon set name = 'Katana' where item_id = 200041;

-- rename Teleport Scroll to Scroll of Teleportation
update etcitem set name = 'Scroll of Teleportation' where item_id = 40100;

-- reduce b2s droprate for crabmen
update droplist set chance = 1000 where mobid = 45164 and itemid = 40238;

-- reduce lastabad heavy xbow droprate by half
update droplist set chance = 2500 where itemid = 188;

-- reduce int ammy drop rate for unicorn
update droplist set chance = 4000 where itemid = 20266 and mobid = 45640;

-- reduce magic dmg from normal/fi dark elf
update mobskill set leverage = 18 where mobid = 45265 and actno = 0;
update mobskill set leverage = 30 where mobid = 45363 and actno = 0;

-- add leverage to high cat and update mobname
update mobskill set leverage = 5, mobname = 'High Cat' where mobid = 45696 and actno = 0;

-- reduce blizz droprate (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40204 and mobid = 45279;
update droplist set chance = 5000 where itemid = 40204 and mobid = 45393;
update droplist set chance = 5000 where itemid = 40204 and mobid = 45394;

-- reduce freezing blizz droprate from low level mobs
update droplist set chance = 500 where itemid = 40225 and mobid = 45155;
update droplist set chance = 500 where itemid = 40225 and mobid = 45159;
update droplist set chance = 500 where itemid = 40225 and mobid = 45170;

