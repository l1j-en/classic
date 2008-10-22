-- update 26

-- Fixed template_id for npc
update spawnlist_npc set npc_templateid = "50002" where id = 90071;
update spawnlist_npc set npc_templateid = "50012" where id = 90070;
update spawnlist_npc set npc_templateid = "50016" where id = 90067;
update spawnlist_npc set npc_templateid = "50065" where id = 90066;
update spawnlist_npc set npc_templateid = "50069" where id = 90069;

-- added earring npcs
INSERT INTO `spawnlist_npc` VALUES ('130904', 'Incarnation of Varlok', '1', '80068', '32748', '32813', '0', '0', '6', '0', '410', '0');
INSERT INTO `spawnlist_npc` VALUES ('130905', 'Assistant of Varlok', '1', '80071', '32746', '32809', '0', '0', '4', '0', '410', '0');

-- remove special spirit crystal from shop buylists
delete from shop where item_id = 40417;

-- added starter dummys to SC
insert into spawnlist_npc values ('130906' , '' , '1' , '45004' , '32762' , '32937' , '0' , '0' , '6' , '0' , '304' , '0');
insert into spawnlist_npc values ('130907' , '' , '1' , '45004' , '32762' , '32935' , '0' , '0' , '6' , '0' , '304' , '0');
insert into spawnlist_npc values ('130908' , '' , '1' , '45004' , '32762' , '32936' , '0' , '0' , '6' , '0' , '304' , '0');
insert into spawnlist_npc values ('130909' , '' , '1' , '45004' , '32762' , '32938' , '0' , '0' , '6' , '0' , '304' , '0');

-- reduce lich hp regen slightly (250 -> 220)
update npc set hpr = 220 where npcid = 45672;

-- reduce lich's magic mobskill leverage (30 -> 25)
update mobskill set leverage = 25 where mobid = 45672 and actno in (0, 1);

-- disable 55+ DE polys (reenable these after ep6/u merge)
-- ancient black assassin morph (polyid: 5727)
update polymorphs set minlevel = 99 where id = 5727;
-- ancient silver assassin morph (polyid: 5730)
update polymorphs set minlevel = 99 where id = 5730;
-- ancient gold assassin morph (polyid: 5733)
update polymorphs set minlevel = 99 where id = 5733;
-- ancient platinum assassin morph (polyid: 5736)
update polymorphs set minlevel = 99 where id = 5736;

-- add nature's miracle to droplists
-- succubus
insert into droplist values(45393, 41243, 1, 1, 1500);
-- toi succubus
insert into droplist values(45394, 41243, 1, 1, 1500);
-- succubus queen
insert into droplist values(45451, 41243, 1, 1, 5000);
-- ice queen 
insert into droplist values(45609, 41243, 1, 1, 12500);
-- cerenis
insert into droplist values(45678, 41243, 1, 1, 12000);
-- fafurion
insert into droplist values(45683, 41243, 1, 1, 300000);

-- add Secret Room Key to knight-only quest drops
insert into quest_drops values (40555, 'K');

-- activate more elemental grave spawn
-- fangs
update spawnlist set count = 1 where count = 0 and npc_templateid in (45416, 45418, 45419, 45424);
-- masters
update spawnlist set count = 1 where count = 0 and npc_templateid in (45500, 45508, 45510, 45511);

-- modify existing Water Spirit Master drops
-- increase Glove of Ice Spirit droprate from Water Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 20172 and mobid = 45500;
-- increase hq gems droprate from Water Spirit Master (5000 -> 10000)
update droplist set chance = 10000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45500;
-- decrease sc:elemental falldown droprate from Water Spirit Master (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40241 and mobid = 45500;
-- increase Mithril Dagger droprate from Water Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 8 and mobid = 45500;
-- increase Oriharukon Dagger droprate from Water Spirit Master (1000 -> 2500)
update droplist set chance = 2500 where itemid = 9 and mobid = 45500;

-- modify existing Earth Spirit Master drops
-- increase Glove of Dark Spirit droprate from Earth Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 20177 and mobid = 45508;
-- increase hq gems droprate from Earth Spirit Master (5000 -> 10000)
update droplist set chance = 10000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45508;
-- decrease sc:elemental falldown droprate from Earth Spirit Master (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40241 and mobid = 45508;
-- increase Mithril Dagger droprate from Earth Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 8 and mobid = 45508;
-- increase Oriharukon Dagger droprate from Earth Spirit Master (1000 -> 2500)
update droplist set chance = 2500 where itemid = 9 and mobid = 45508;

-- modify existing Wind Spirit Master drops
-- increase Glove of Wind Spirit droprate from Wind Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 20189 and mobid = 45510;
-- increase hq gems droprate from Wind Spirit Master (5000 -> 10000)
update droplist set chance = 10000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45510;
-- decrease sc:elemental falldown droprate from Wind Spirit Master (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40241 and mobid = 45510;
-- increase Mithril Dagger droprate from Wind Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 8 and mobid = 45510;
-- increase Oriharukon Dagger droprate from Wind Spirit Master (1000 -> 2500)
update droplist set chance = 2500 where itemid = 9 and mobid = 45510;

-- modify existing Fire Spirit Master drops
-- increase Glove of Fire Spirit droprate from Fire Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 20181 and mobid = 45511;
-- increase hq gems droprate from Fire Spirit Master (5000 -> 10000)
update droplist set chance = 10000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45511;
-- decrease sc:elemental falldown droprate from Fire Spirit Master (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40241 and mobid = 45511;
-- increase Mithril Dagger droprate from Fire Spirit Master (5000 -> 9000)
update droplist set chance = 9000 where itemid = 8 and mobid = 45511;
-- increase Oriharukon Dagger droprate from Fire Spirit Master (1000 -> 2500)
update droplist set chance = 2500 where itemid = 9 and mobid = 45511;

-- modify existing Abyss Water Spirit drops
-- increase Glove of Ice Spirit droprate from Abyss Water Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 20172 and mobid = 45591;
-- increase hq gems droprate from Abyss Water Spirit (5000 -> 15000)
update droplist set chance = 15000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45591;
-- increase Mithril Dagger droprate from Abyss Water Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 8 and mobid = 45594;
-- increase Oriharukon Dagger droprate from Abyss Water Spirit (1000 -> 5000)
update droplist set chance = 5000 where itemid = 9 and mobid = 45594;

-- modify existing Abyss Earth Spirit drops
-- increase Glove of Dark Spirit droprate from Abyss Earth Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 20177 and mobid = 45592;
-- increase hq gems droprate from Abyss Earth Spirit (5000 -> 15000)
update droplist set chance = 15000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45592;
-- increase Mithril Dagger droprate from Abyss Earth Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 8 and mobid = 45594;
-- increase Oriharukon Dagger droprate from Abyss Earth Spirit (1000 -> 5000)
update droplist set chance = 5000 where itemid = 9 and mobid = 45594;

-- modify existing Abyss Wind Spirit drops
-- increase Glove of Wind Spirit droprate from Abyss Wind Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 20189 and mobid = 45593;
-- increase hq gems droprate from Abyss Wind Spirit (5000 -> 15000)
update droplist set chance = 15000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45593;
-- increase Mithril Dagger droprate from Abyss Wind Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 8 and mobid = 45593;
-- increase Oriharukon Dagger droprate from Abyss Wind Spirit (1000 -> 5000)
update droplist set chance = 5000 where itemid = 9 and mobid = 45593;

-- modify existing Abyss Fire Spirit drops
-- increase Glove of Fire Spirit droprate from Abyss Fire Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 20181 and mobid = 45594;
-- increase hq gems droprate from Abyss Fire Spirit (5000 -> 15000)
update droplist set chance = 15000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45594;
-- increase Mithril Dagger droprate from Abyss Fire Spirit (5000 -> 13000)
update droplist set chance = 13000 where itemid = 8 and mobid = 45594;
-- increase Oriharukon Dagger droprate from Abyss Fire Spirit (1000 -> 5000)
update droplist set chance = 5000 where itemid = 9 and mobid = 45594;

-- modify existing Abyss Ghoul drops
-- increase nzel droprate from Abyss Ghoul (25000 -> 50000)
update droplist set chance = 50000 where itemid = 40074 and mobid = 45501;