-- update 3

-- half the spawn rate on DI
update spawnlist set count = count / 2 where mapid = 303;

-- half the spawn rate in de lvl 45 quest area
update spawnlist set count = count / 2 where mapid = 21;

-- remove elder aggro to sosc
update npc set agrososc = 0 where npcid = 45215;

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

-- fix brave claw, edoryu, xbow names
update weapon set name_id = '$2449 $2453' where item_id = 81;
update weapon set name_id = '$372 $2453' where item_id = 162;
update weapon set name_id = '$2451 $2453' where item_id = 177;

-- add sb:summon to ghast lord drop list
insert into droplist values (45346, 40196, 1, 1, 500);

-- fix wis pot name
update etcitem set name = 'Potion of Wisdom' where item_id = 40016;

-- fix maple wand name
update etcitem set name = 'Maple Wand' where item_id = 40008;

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

-- fix bk search party name
update npc set name = 'Black Knight Search Party' where npcid = 81066;

-- reduce black knight t-s, cop drops by half
update droplist set chance = 5000 where itemid = 20085 and mobid = 81066;
update droplist set chance = 5000 where itemid = 20085 and mobid = 45165;
update droplist set chance = 5000 where itemid = 20063 and mobid = 81066;
update droplist set chance = 5000 where itemid = 20063 and mobid = 45165;

-- de-nerf freezing blizz (slightly less powerful than normal blizz)
update skills set damage_value = 8, damage_dice_count = 5 where skill_id = 80;

-- fix misnamed dark elf wizard (was black wizard)
update npc set name = 'dark elf wizard' where npcid = 45333;

-- reduce black wizard magic attack dmg by half
update skills set damage_value = 25 where skill_id = 10044;
