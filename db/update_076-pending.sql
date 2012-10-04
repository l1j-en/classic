-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- Room in Lasta basement that shouldn't allow random teleportation.
update mapids set teleportable=false where mapid=490;

-- Make some of Black Knight of Darkness' attacks regular, upping leverage to
-- compensate.
update mobskill set trirnd=75,leverage=35 where mobid=45503;
