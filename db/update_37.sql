-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here
-- this allows them to be verified as working together before being
-- migrated to the DML scripts

-- update 37

-- swap name/nameids of Coin of Reputation and Coin of Bravery
update etcitem set name = 'Coin of Bravery', name_id = '$3059' where item_id = 40733;
update etcitem set name = 'Coin of Reputation', name_id = '$3056' where item_id = 40735;

-- correct name of npc becky
update npc set name = 'Becky', nameid = 'Becky' where npcid = 71191;