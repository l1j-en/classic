
-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here. This allows them 
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 46

-- Adjust a few TQD droprates
update droplist set chance = 3000 where mobid = 45496 and itemid = 40052;
update droplist set chance = 4000 where mobid = 45522 and itemid = 40052;

