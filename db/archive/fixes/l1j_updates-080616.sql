-- fix ring drop on water boss (was rof, should be row)
update droplist set itemId = 20285 where mobid = 45645 and itemid = 20304;

-- fix name of lizardman sword
update weapon set name = "Sword of Brave Lizardman Soldier" where item_id = 53;

-- add orc wizard fireball
insert into `mobskill` values (45121, 0, 'Orc Wizard', 2, 30, 0, 0, -6, 0, 0, 0, 0, 0, 0, 25, 171, 0, 0, 0, 0, 0);

-- add dark elf tornado
insert into `mobskill` values (45265, 0, 'Dark Elf', 2, 30, 0, 0, -4, 0, 0, 0, 0, 0, 30, 53, 758, 0, 0, 0, 0, 0);

-- add fi dark elf tornado
insert into `mobskill` values (45364, 0, 'Dark Elf', 2, 40, 0, 0, -4, 0, 0, 0, 0, 0, 50, 53, 758, 0, 0, 0, 0, 0);

-- add dark elf wizard cone of cold 
insert into `mobskill` values (45447, 0, 'Dark Elf Wizard', 2, 40, 0, 0, -6, 0, 0, 0, 0, 0, 25, 38, 1809, 0, 0, 0, 0, 0);
-- add dark elf wizard tornado
insert into `mobskill` values (45447, 1, 'Dark Elf Wizard', 2, 30, 0, 0, -4, 0, 0, 0, 0, 0, 40, 53, 758, 0, 0, 0, 0, 0);


-- double spawn rate
-- excluding DV skeles/ogres, ToS outside, and lasta 4F
update spawnlist set count = count * 2 
where not (npc_templateid in (45122, 45130, 45131, 45278) 
           and mapid == 4) 
  and not (mapid == 521)
  and not (mapid == 320)
  and not (mapid == 70;

-- replace lvl 50 ToS spawn with lvl 22
update spawnlist set npc_templateid = 45226 where mapid = 521 and npc_templateid = 45544;

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
update droplist set chance = chance / 10 where itemid = 145;

-- fix droplist referential integrity error
-- this may fix the disappearing mops issue
delete from droplist where itemid = 50000;

-- fix eva's scorn stats. should be 9/9, +1 dmg, +1 hit (currently just 10/10)
update weapon set dmg_small = 9, dmg_large = 9, hitmodifier = 1, dmgmodifier = 1 where item_id = 36;