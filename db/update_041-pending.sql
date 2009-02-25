-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here. This allows them 
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 41

-- reduce the uber regen of most summons to about 60-75% previous value
update npc set hpr = 9 where npcid = 81084; -- was 11
update npc set hpr = 10 where npcid = 81085; -- was 16
update npc set hpr = 12 where npcid = 81086; -- was 25
update npc set hpr = 16 where npcid = 81087; -- was 40
update npc set hpr = 20 where npcid = 81088; -- was 30
update npc set hpr = 22 where npcid = 81089; -- was 38
update npc set hpr = 9 where npcid = 81091; -- was 11
update npc set hpr = 11 where npcid = 81092; -- was 18
update npc set hpr = 12 where npcid = 81093; -- was 25
update npc set hpr = 20 where npcid = 81094; -- was 29
update npc set hpr = 30 where npcid = 81095; -- was 55
update npc set hpr = 32 where npcid = 81096; -- was 60
update npc set hpr = 38 where npcid = 81097; -- was 70
update npc set hpr = 28 where npcid = 81098; -- was 50
update npc set hpr = 22 where npcid = 81099; -- was 40
update npc set hpr = 38 where npcid = 81100; -- was 70
update npc set hpr = 28 where npcid = 81101; -- was 50
update npc set hpr = 28 where npcid = 81102; -- was 40
update npc set hpr = 60 where npcid = 81103; -- was 100
update npc set hpr = 60 where npcid = 81104; -- was 100

-- correct Black Knight Captain name
update npc set name = 'Black Knight Captain' where npcid = 81115;

-- Fix semi-exploit of killing subterranean turtles/elekkadoms without taking magic dmg
update mobskill set trirange = -2 where mobid = 45422 and actno = 3;
update mobskill set trirange = -2 where mobid = 45487 and actno = 0;

-- Reduce overpowered subterranean turtle magic attack
update mobskill set leverage = 40 where mobid = 45422 and actno = 3;

-- tweak negative karma frag droprates
update droplist set chance = 20000 where itemid = 40718 and mobid in (45739, 45740, 45741, 45742, 45743, 45744);
update droplist set chance = 500000 where itemid = 40718 and mobid in (45745, 45746, 45747, 45749, 45751, 45753);

-- add a few crappy drops to desire cave lesser demons
-- NOTE: keep an eye out if jp adds some drops here later
-- adena
insert into droplist values(45736, 40308, 56, 112, 1000000);
-- fragment of bloodstone
insert into droplist values(45736, 40718, 1, 1, 10000);
-- blue pot
insert into droplist values(45736, 40015, 1, 1, 50000);
-- brave
insert into droplist values(45736, 40014, 1, 1, 50000);
-- black rough mith
insert into droplist values(45736, 40444, 1, 1, 25000);
-- black pure mith
insert into droplist values(45736, 40443, 1, 1, 10000);
-- bbs
insert into droplist values(45736, 40678, 1, 1, 30000);

-- up the respawn delay for SKT BK groups (was 60-120)
update spawnlist set min_respawn_delay = 120, max_respawn_delay = 180 where group_id = 50;

-- make crystal of dark elf soul tradable
update etcitem set trade = 0 where item_id = 40969;

-- reduce GC dark elementalist mobskill leverage
update mobskill set leverage = 10 where mobid = 45363 and actno = 0;
update mobskill set leverage = 10 where mobid = 45907 and actno = 0;

