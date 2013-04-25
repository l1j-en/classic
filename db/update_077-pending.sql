-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- Fix itemid for 'Lump of Steel' in Iron Golem/Horrific Iron Golem drops.
update droplist set itemid=40779 where itemid=40799 and (mobid=45372 or mobid=45479);

-- TODO: ultimately determine what to do with Phantasm.
update skills set probability_dice=4 where name="phantasm";

-- Correct the Hp of Yahee fly type
update npc set hp=30000 where npcid=81082;

-- Adjust drop rate of Yahee set material 
update droplist set chance=23000 where itemid in (40669, 40671, 40672);
update droplist set chance=460 where itemid in (40670, 40673);
update droplist set chance=30000 where itemid=40674;

-- Adjust drops of Varlok
update droplist set min=10,max=40,chance=500000 where mobid=45753 and itemid=40524;
update droplist set chance=100000 where mobid=45753 and itemid=40718;
update droplist set min=2,max=4 where mobid=45753 and itemid=40998;
update droplist set chance=7600 where mobid=45753 and itemid in (40995, 40997, 40990);
update droplist set chance=7600 where mobid=45753 and itemid in (40994, 40993, 40998);
update droplist set chance=3000 where mobid=45753 and itemid in (40996, 40992);

