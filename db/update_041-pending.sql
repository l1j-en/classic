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

