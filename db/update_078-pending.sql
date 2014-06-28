-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

update armor set name = 'Boots of Dread King' where item_id = 20200;

-- Rebalance DI boss elixir droprates.
update droplist set chance = 200 where mobid in (45640, 45642, 45643, 45644, 45645) and itemid in (40033, 40034, 40035, 40036, 40037, 40038);
