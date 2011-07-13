-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 65

-- added KillGlance ring and crafter
insert into npc values (90016,'KillGlance','KillGlance','KillGlance','L1Merchant',2337,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0);
insert into npcaction values (90016,'killglance1','','','');
insert into spawnlist_npc values (1900012,'KillGlance',1,90016,34073,33109,0,0,6,0,4,0);
insert into armor values (30009,'KillGlance`s Ring','KillGlance`s Ring','KillGlance`s Ring','ring','gold',3000,668,21,0,0,-1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0);

-- added .reload from l1j-jp2
INSERT INTO commands VALUES('reload', 0, 'L1Reload');
