-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 61

-- updated a few npc ids to not interfere with npcs merged from l1j-jp
update npc set npcid = 90003 where name = "Baell Zaer";
update npc set npcid = 90004 where name = "Cronos";
update npc set npcid = 90005 where name = "Elazer";
update npc set npcid = 90006 where name = "Skeleton Mage";
update npc set npcid = 90007 where name = "Skeleton Sorcerer";
update npc set npcid = 90008 where name = "Skeleton Wizard";
update npc set npcid = 90009 where name = "Zarlok";
update npc set npcid = 90010 where name = "Kugas";
update npc set npcid = 90011 where name = "Crack of Time";
update spawnlist_boss set npc_id = 90003 where location = "Baell Zaer";
update spawnlist_boss set npc_id = 90004 where location = "Cronos";
update spawnlist_boss set npc_id = 90005 where location = "Elazer";
update spawnlist_boss set npc_id = 90009 where location = "Zarlok";
update spawnlist_boss set npc_id = 90010 where location = "Kugas";

-- added candle merchant tilo
insert into npc values (90012,'Tilo','Tilo','Candle Npc','L1Merchant',1621,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0);
insert into spawnlist_npc values (1900002,'Tilo',1,90012,32608,32775,0,0,4,0,4,0);
insert into npcaction values (90012,'candle','','','');

-- added bag girl
insert into npc values (90013,'Bag Girl','Bag Girl','','L1Merchant',725,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0);
insert into npcaction values (90013,'potionbag1','','','');
insert into spawnlist_npc values (1900003,'Bag Girl',1,90013,32629,33194,0,0,4,0,4,0);
insert into spawnlist_npc values (1900004,'Bag Girl',1,90013,33094,33385,0,0,4,0,4,0);
insert into spawnlist_npc values (1900005,'Bag Girl',1,90013,33642,33290,0,0,6,0,4,0);
insert into spawnlist_npc values (1900006,'Bag Girl',1,90013,33454,32823,0,0,6,0,4,0);
insert into spawnlist_npc values (1900007,'Bag Girl',1,90013,33736,32493,0,0,4,0,4,0);
insert into spawnlist_npc values (1900008,'Bag Girl',1,90013,34062,32290,0,0,4,0,4,0);
update etcitem set weight = 4500 where item_id = "40031";
insert into etcitem values (90000,'Bag of Greater Mana Potion\'s','Bag of Greater Mana Potion\'s','Bag of Greater Mana Potion\'s','treasure_box','normal','leather',14100,1645,4248,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90001,'Bag of Greater Haste Potion\'s','Bag of Greater Haste Potion\'s','Bag of Greater Haste Potion\'s','treasure_box','normal','leather',14100,957,3963,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90002,'Bag of Elven Wafer\'s','Bag of Elven Wafer\'s','Bag of Elven Wafer\'s','treasure_box','normal','leather',15000,1396,3461,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90003,'Bag of Brave Potion\'s','Bag of Brave Potion\'s','Bag of Brave Potion\'s','treasure_box','normal','leather',13500,958,3963,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90004,'Bag of Devil\'s Blood','Bag of Devil\'s Blood','Bag of Devil\'s Blood','treasure_box','normal','leather',13500,1417,4248,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90005,'Bag of Wisdom Potion\'s','Bag of Wisdom Potion\'s','Bag of Wisdom Potion\'s','treasure_box','normal','leather',13500,1643,4246,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90006,'Bag of Mana Potion\'s','Bag of Mana Potion\'s','Bag of Mana Potion\'s','treasure_box','normal','leather',23400,1645,4248,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90007,'Bag of Haste Potion\'s','Bag of Haste Potion\'s','Bag of Haste Potion\'s','treasure_box','normal','leather',11700,957,3963,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into etcitem values (90008,'Greater Potion of Mana','Greater Potion of Mana','Greater Potion of Mana','potion','normal','glass',7050,75,20,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0);
