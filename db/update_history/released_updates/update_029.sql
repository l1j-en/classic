-- update 29

-- undouble the lvl 50 quest area 4F mops
update spawnlist set count = 1 where mapid = 2003;

-- correct the 100% Key of Fate drop from Varlok Servant
update droplist set chance = 1000000 where mobid = 45709 and itemid = 40589; 