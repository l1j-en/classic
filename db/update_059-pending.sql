-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 59

-- Fixed Orc Emissary respawn delay and loc --
update spawnlist set locx = '32721' where id = 400001;
update spawnlist set locy = '32384' where id = 400001;
update spawnlist set min_respawn_delay = '240' where id = 400001;
update spawnlist set max_respawn_delay = '420' where id = 400001;
update spawnlist set locx = '32674' where id = 400002;
update spawnlist set locy = '32571' where id = 400002;
update spawnlist set min_respawn_delay = '240' where id = 400002;
update spawnlist set max_respawn_delay = '420' where id = 400002;
update spawnlist set locx = '32631' where id = 400003;
update spawnlist set locy = '33105' where id = 400003;
update spawnlist set min_respawn_delay = '240' where id = 400002;
update spawnlist set max_respawn_delay = '420' where id = 400002;
