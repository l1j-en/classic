-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

update armor set name = 'Boots of Dread King' where item_id = 20200;

-- Rebalance DI boss elixir droprates.
update droplist set chance = 200 where mobid in (45640, 45642, 45643, 45644, 45645) and itemid in (40033, 40034, 40035, 40036, 40037, 40038);

-- Remove all freely acquired elven mats from shops.
delete from shop where item_id in (40519, 40502, 40503, 40504, 40505, 40506, 40507, 40515, 40520, 40521) and purchasing_price = 1;

-- This might not be the right template id, but it was using ribians and that was def not right
update spawnlist_npc set npc_templateid = 71035 where id = 90066;

-- Make the right ribian spawn
update spawnlist_npc set count=1 where id = 50031;

-- give killglance ring some stats
UPDATE armor SET add_hp = 20, add_mp = 10, add_hpr = 5, add_mpr = 2, hit_modifier = 1 WHERE item_id = 30009;

-- remove extra Caspa spawn
DELETE FROM spawnlist_boss WHERE npc_id = 45488 AND mapid = 10;

-- remove extra DK spawn
DELETE FROM spawnlist_boss WHERE npc_id = 45601 AND mapid = 12;

-- add shark eggs to shark in deep sea
INSERT INTO droplist VALUES(55800001,'Shark',49040,'Shark Eggs',1,1,50000);

-- add shark eggs to Eva Shark - note: These are not currently spawning
INSERT INTO droplist VALUES(45933,'Shark',49040,'Shark Eggs',1,1,50000);

-- add shark eggs to sharks in kingdom of eva mapid 63
INSERT INTO droplist VALUES(45160,'Shark',49040,'Shark Eggs',1,1,50000);
 
-- add shark eggs to sharks in kingdrom of eva mapid 253
INSERT INTO droplist VALUES(45816,'Shark',49040,'Shark Eggs',1,1,50000);

