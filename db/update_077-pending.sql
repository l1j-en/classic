-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- Fix itemid for 'Lump of Steel' in Iron Golem/Horrific Iron Golem drops.
update droplist set itemid=40779 where itemid=40799 and (mobid=45372 or mobid=45379);

-- TODO: ultimately determine what to do with Phantasm.
update skills set probability_dice=4 where name="phantasm";
