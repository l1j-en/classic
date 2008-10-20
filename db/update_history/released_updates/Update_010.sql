-- update 10 

-- add sb:destroy to lich droplist
insert into droplist values (45672, 40222, 1, 1, 2000);

-- fix eva scorn droprate (5000 -> 100)
update droplist set chance = 100 where itemid = 36 and mobid = 45279;

-- change eva's scorn fixed_damage to be in line with thor's/bume
update weapon_skill set fix_damage = 15 where weapon_id = 36;

-- change eva's scorn probability to be in line with thor's/bume
update weapon_skill set probability = 13 where weapon_id = 36;

-- correct mlc 7 bb adena drop min/max
update droplist d set d.min = 141, d.max = 223 where mobid = 45738 and itemid = 40308;
