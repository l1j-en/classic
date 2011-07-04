-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 63

-- fix the unchosen ones tele skill amount
update mobskill set trirnd = 10 where mobid = 46096;