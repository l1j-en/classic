-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- The old Treasure Chest of Aden was accidently overwritten by Mandragoras,
-- so now we're restoring it.
-- The chosen id should be good unless you've used it for custom npcs already,
-- in which case you know enough to find another one to use.
insert into `npc` values ('46164', 'Treasure Chest of Aden Castle', '$5492', '', 'L1Monster', '6555', '23', '280', '40', '-10', '13', '12', '13', '10', '10', '50', '530', '-16', 'small', '2', '1', '0', '480', '1200', '0', '1600', '1600', '0', '0', '0', '0', '0', '0', 'tebe_m', '0', '-1', '-1', '0', '0', '0', '5000', '20', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '0', '0', '0');

-- You know the drill... fix the ids if appropriate.
delete from `spawnlist` where (id = 63000 or id = 63001 or id = 63002) and npc_templateid = 46107;
insert into `spawnlist` values ('63000', 'Treasure Chest of Aden Castle', '25', '46164', '0', '32770', '32851', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '248', '0', '100', '0', '0', 1, 8, 2, 100);
insert into `spawnlist` values ('63001', 'Treasure Chest of Aden Castle', '10', '46164', '0', '32770', '32851', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '249', '0', '100', '0', '0', 1, 8, 2, 100);
insert into `spawnlist` values ('63002', 'Treasure Chest of Aden Castle', '20', '46164', '0', '32770', '32851', '0', '0', '32704', '32768', '32831', '32895', '0', '0', '0', '250', '0', '100', '0', '0', 1, 8, 2, 100);

insert into `droplist` values (46164, 'Treasure Chest of Aden Castle', 42096, 'Ancient Gold Coin', 1, 1, 80000);

-- No idea why this had "Priest of Chaos" on it before. 
update mobskill set mobname = "Mammon" where mobid = 46026;
