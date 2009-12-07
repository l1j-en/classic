-- update 1

-- set arrow sell price to 0 to prevent infinite money exploit
update shop set selling_price = 0 where item_id = 40743;

-- change eva's scorn to proper effect
update weapon_skill set effect_id = 1714 where weapon_id = 36;

-- de-aggro elders
update npc set agro = 0 where npcid = 45215;

-- add elder c-l cast
insert into `mobskill` values (45215, 0, 'Elder', 2, 35, 0, 0, -4, 0, 0, 0, 0, 0, 25, 34, 10, 0, 0, 0, 0, 0);

-- half cdai, bdai, ndai drops
update droplist set chance = chance / 2 where itemid in (40087, 140087, 240087);

-- increase wafer drops from DEs
update droplist set chance = 50000 where mobid = 45364 and itemid = 40068;
update droplist set chance = 50000 where mobid = 45265 and itemid = 40068;

-- add sb:hw to dv drakes
insert into droplist values (45529, 40197, 1, 1, 500);

-- add bzels to lesser dragons
insert into droplist values (45496, 140074, 1, 1, 5000);
-- add bdais to lesser dragons
insert into droplist values (45496, 240087, 1, 1, 2000);
-- half heart of dragon drop
update droplist set chance = 500 where mobid = 45496 and itemid = 40466;
