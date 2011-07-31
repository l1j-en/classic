-- update 68

-- remove duplicate spawns in oren market
DELETE FROM spawnlist WHERE mapid = 360;

-- drop the droprate of adena for Subterranean Elekkadoms
UPDATE droplist SET min = 500, max = 1000 WHERE mobId = 45487 AND itemId = 40308;

# changes from jp's npcandskilladjusmtents that appear correct
--
-- Valley Harpy 45067
-- agro changed from 0
UPDATE npc SET agro = 1 WHERE npcid = 45067;
--
-- Island Ghast Lord 45081
-- agro changed from 0
UPDATE npc SET agro = 1 WHERE npcid = 45081;
--
-- Degenerated Beholder 45086
-- agro changed from 0
UPDATE npc SET agro = 1 WHERE npcid = 45086;
--
-- Valley Griffon 45090
-- agro changed from 0
UPDATE npc SET agro = 1 WHERE npcid = 45090;
--
-- Valley Basilisk 45091
-- agro changed from 0
UPDATE npc SET agro = 1 WHERE npcid = 45091;
--
-- Island Cockatrice 45095
-- agro changed from 0
UPDATE npc SET agro = 1 WHERE npcid = 45095;
--
-- Island Crocodile 45096
-- family changed from cockatrice
UPDATE npc SET family = 'alligator' WHERE npcid = 45096;
-- agro changed from 0
UPDATE npc SET agro = 1 WHERE npcid = 45096;

# update non-spawning mobs
update spawnlist set count = 1 where count = 0;

-- add gmcommand account
INSERT INTO commands VALUES('account', 200, 'L1Account');
