-- Room in Lasta basement that shouldn't allow random teleportation.
update mapids set teleportable=false where mapid=490;

-- Make some of Black Knight of Darkness' attacks regular, upping leverage to
-- compensate.
update mobskill set trirnd=75,leverage=35 where mobid=45503;

-- Other storage tables need accessory bonus columns.
alter table character_elf_warehouse add `m_def` int(4) unsigned not null default 0;
alter table character_elf_warehouse add `add_hp` int(6) unsigned not null default 0;
alter table character_elf_warehouse add `add_mp` int(6) unsigned not null default 0;
alter table character_elf_warehouse add `add_hpr` int(3) unsigned not null default 0;
alter table character_elf_warehouse add `add_mpr` int(3) unsigned not null default 0;
alter table character_elf_warehouse add `add_sp` int(2) unsigned not null default 0;
alter table character_elf_warehouse add `defense_water` int(4) unsigned not null default 0;
alter table character_elf_warehouse add `defense_wind` int(4) unsigned not null default 0;
alter table character_elf_warehouse add `defense_fire` int(4) unsigned not null default 0;
alter table character_elf_warehouse add `defense_earth` int(4) unsigned not null default 0;

alter table character_warehouse add `m_def` int(4) unsigned not null default 0;
alter table character_warehouse add `add_hp` int(6) unsigned not null default 0;
alter table character_warehouse add `add_mp` int(6) unsigned not null default 0;
alter table character_warehouse add `add_hpr` int(3) unsigned not null default 0;
alter table character_warehouse add `add_mpr` int(3) unsigned not null default 0;
alter table character_warehouse add `add_sp` int(2) unsigned not null default 0;
alter table character_warehouse add `defense_water` int(4) unsigned not null default 0;
alter table character_warehouse add `defense_wind` int(4) unsigned not null default 0;
alter table character_warehouse add `defense_fire` int(4) unsigned not null default 0;
alter table character_warehouse add `defense_earth` int(4) unsigned not null default 0;

alter table clan_warehouse add `m_def` int(4) unsigned not null default 0;
alter table clan_warehouse add `add_hp` int(6) unsigned not null default 0;
alter table clan_warehouse add `add_mp` int(6) unsigned not null default 0;
alter table clan_warehouse add `add_hpr` int(3) unsigned not null default 0;
alter table clan_warehouse add `add_mpr` int(3) unsigned not null default 0;
alter table clan_warehouse add `add_sp` int(2) unsigned not null default 0;
alter table clan_warehouse add `defense_water` int(4) unsigned not null default 0;
alter table clan_warehouse add `defense_wind` int(4) unsigned not null default 0;
alter table clan_warehouse add `defense_fire` int(4) unsigned not null default 0;
alter table clan_warehouse add `defense_earth` int(4) unsigned not null default 0;

-- Resolvent updates.
update resolvent,armor set note=name where resolvent.item_id=armor.item_id;
update resolvent,etcitem set note=name where resolvent.item_id=etcitem.item_id;
update resolvent,weapon set note=name where resolvent.item_id=weapon.item_id;

insert into resolvent values (20244, "Old Amulet of Charisma", 700), (20245, "Old Amulet of Dexterity", 700), (20246, "Old Amulet of Strength", 700), (20248, "Old Amulet of Wisdom", 700), (20247, "Old Amulet of Intelligence", 700), (20249, "Old Amulet of Constitution", 700), (20254, "Amulet of Charisma", 1000), (20256, "Amulet of Dexterity", 1000), (20264, "Amulet of Strength", 1000), (20267, "Amulet of Wisdom", 1000), (20268, "Amulet of Constitution", 1000), (20154, "Plate Mail", 1200), (120154, "Plate Mail", 1800), (120128, "Crystal Plate Mail", 2000), (20128, "Crystal Plate Mail", 1600), (20110, "Chain Mail of Magic Resistance", 1100), (41, "Katana", 800), (100041, "Katana", 1200), (200041, "Katana", 0), (125, "Staff of Sorcery", 750);

update resolvent set crystal_count=2400 where note like "belt of%";
update resolvent set crystal_count=1200 where note like "old belt of%";

-- Remove extraneous columns in elf warehouse log.
alter table LogElfWareHouseIn drop ClanId;
alter table LogElfWareHouseIn drop ClanName;
alter table LogElfWareHouseOut drop ClanId;
alter table LogElfWareHouseOut drop ClanName;

-- Make Ivory Tower ring unenchantable, since it's infinitely farmable for
-- free.
update armor set grade=-1 where item_id=20282;

-- Dark elf set.
insert into armor (item_id, name, unidentified_name_id, identified_name_id, type, material, weight, invgfx, grdgfx, ac, safenchant, use_darkelf, use_elf) values (30012, "Dark Elf Tunic", "Dark Elf Tunic", "Dark Elf Tunic", "armor", "cloth", 60000, 982, 3830, -1, 6, 1, 1), (30013, "Dark Elf Sandals", "Dark Elf Sandals", "Dark Elf Sandals", "boots", "leather", 30000, 452, 25, -1, 6, 1, 1), (30014, "Dark Elf Circlet", "Dark Elf Circlet", "Dark Elf Circlet", "helm", "iron", 30000, 511, 18, -1, 6, 1, 1);

-- insert into droplist values ();

insert into armor_set (note, polyname, sets, polyid, ac, defense_wind, dex, hpr, mpr) values ("Dark Elf Set", "Dark Elf", "30012,30013,30014", 6140, -3, 10, 2, -2, -7);

insert into droplist values (45265, "Dark Elf", 30012, "Dark Elf Tunic", 1, 1, 200);
insert into droplist values (45265, "Dark Elf", 30013, "Dark Elf Sandals", 1, 1, 200);
insert into droplist values (45265, "Dark Elf", 30014, "Dark Elf Circlet", 1, 1, 200);
insert into droplist values (45364, "Dark Elf", 30012, "Dark Elf Tunic", 1, 1, 400);
insert into droplist values (45364, "Dark Elf", 30013, "Dark Elf Sandals", 1, 1, 400);
insert into droplist values (45364, "Dark Elf", 30014, "Dark Elf Circlet", 1, 1, 400);
insert into droplist values (45584, "Greater Minotaur", 30012, "Dark Elf Tunic", 1, 1, 6000);
insert into droplist values (45584, "Greater Minotaur", 30013, "Dark Elf Sandals", 1, 1, 6000);
insert into droplist values (45584, "Greater Minotaur", 30014, "Dark Elf Circlet", 1, 1, 6000);
insert into droplist values (45654, "Iris", 30012, "Dark Elf Tunic", 1, 1, 8000);
insert into droplist values (45654, "Iris", 30013, "Dark Elf Sandals", 1, 1, 8000);
insert into droplist values (45654, "Iris", 30014, "Dark Elf Circlet", 1, 1, 8000);
insert into droplist values (45648, "Slave of Assassin King", 30012, "Dark Elf Tunic", 1, 1, 7500);
insert into droplist values (45648, "Slave of Assassin King", 30013, "Dark Elf Sandals", 1, 1, 7500);
insert into droplist values (45648, "Slave of Assassin King", 30014, "Dark Elf Circlet", 1, 1, 7500);

insert into commands set name="findskill", access_level=100, class_name="FindSkill";
update npc set mpr=300,mprinterval=5000 where npcid=45753;
update droplist set min=4,max=8,chance=4000 where mobid=45753 and itemid in (40995, 40997, 40990);
update droplist set min=2,max=4,chance=4000 where mobid=45753 and itemid in (40994, 40993, 30998);
update droplist set max=2,chance=4000 where mobid=45753 and itemid in (40996, 40992);
update droplist set min=32,max=112 where mobid=45753 and itemid=40718;
update mobskill set leverage=30 where mobid=45753 and (skillid=10069 or skillid=10070);

update spawnlist set near_spawn=0 where near_spawn=1; 

update mobskill set TriRnd=100, TriHp=75 where ActId=1 and mobname in ('Antharas', 'Fafurion', 'Lindvior', 'Valakas');
update mobskill set TriHp=50 where leverage=1000 and mobname in ('Antharas', 'Fafurion', 'Lindvior', 'Valakas');
-- Varlok buff.
update mobskill set leverage=40 where mobid=45753 and (actNo=0 or actNo=1);
-- Hellvine.
update npc set str=80, lvl=80, mpr=300, mprinterval=5000, hpr=300, exp=6401 where npcid=45676;
update npc set mr=180 where name in ('Antharas', 'Valakas', 'Lindvior', 'Fafurion');
update mobskill set leverage=35 where mobid=45676 and (actNo=2 or actNo=3);
update mobskill set trirange=-8, trirnd=12, summonmin=1, summonmax=3 where mobid=45676 and (actNo=0 or actNo=1);

update armor set use_illusionist=1 where name="Troll Belt";

-- Update dragon drops to go along with increased toughness.
insert into droplist values (45681, 'Lindvior', 40224, 'Spellbook(AdvanceSpirit)', 1, 1, 40000);
insert into droplist values (45682, 'Antharas', 40224, 'Spellbook(AdvanceSpirit)', 1, 1, 40000);
insert into droplist values (45683, 'Fafurion', 40224, 'Spellbook(AdvanceSpirit)', 1, 1, 40000);
insert into droplist values (45684, 'Valakas', 40224, 'Spellbook(AdvanceSpirit)', 1, 1, 40000);

insert into droplist values (45681, 'Lindvior', 40212, 'Spellbook(Polymorph)', 1, 1, 40000);
insert into droplist values (45682, 'Antharas', 40212, 'Spellbook(Polymorph)', 1, 1, 40000);
insert into droplist values (45683, 'Fafurion', 40212, 'Spellbook(Polymorph)', 1, 1, 40000);
insert into droplist values (45684, 'Valakas', 40212, 'Spellbook(Polymorph)', 1, 1, 40000);

insert into droplist values (45681, 'Lindvior', 40441, 'Rough Platinum Piece', 12, 24, 240000);
insert into droplist values (45682, 'Antharas', 40441, 'Rough Platinum Piece', 12, 24, 240000);
insert into droplist values (45683, 'Fafurion', 40441, 'Rough Platinum Piece', 12, 24, 240000);
insert into droplist values (45684, 'Valakas', 40441, 'Rough Platinum Piece', 12, 24, 240000);

insert into droplist values (45681, 'Lindvior', 40468, 'Rough Silver Piece', 12, 24, 240000);
insert into droplist values (45682, 'Antharas', 40468, 'Rough Silver Piece', 12, 24, 240000);
insert into droplist values (45683, 'Fafurion', 40468, 'Rough Silver Piece', 12, 24, 240000);
insert into droplist values (45684, 'Valakas', 40468, 'Rough Silver Piece', 12, 24, 240000);

insert into droplist values (45681, 'Lindvior', 40489, 'Rough Gold Piece', 12, 24, 240000);
insert into droplist values (45682, 'Antharas', 40489, 'Rough Gold Piece', 12, 24, 240000);
insert into droplist values (45683, 'Fafurion', 40489, 'Rough Gold Piece', 12, 24, 240000);
insert into droplist values (45684, 'Valakas', 40489, 'Rough Gold Piece', 12, 24, 240000);

insert into droplist values (45681, 'Lindvior', 20108, 'Magical Armor of Lindvior', 1, 1, 4000);
insert into droplist values (45682, 'Antharas', 20130, 'Magical Armor of Antharas', 1, 1, 4000);
insert into droplist values (45683, 'Fafurion', 20153, 'Magical Armor of Fafurion', 1, 1, 4000);
insert into droplist values (45684, 'Valakas', 20119, 'Magical Armor of Valakas', 1, 1, 4000);

insert into droplist values (45681, 'Lindvior', 20156, 'White Dragon Armor', 1, 1, 6000);
insert into droplist values (45682, 'Antharas', 21046, 'Green Dragon Armor', 1, 1, 6000);
insert into droplist values (45683, 'Fafurion', 20127, 'Blue Dragon Armor', 1, 1, 6000);
insert into droplist values (45684, 'Valakas', 20159, 'Red Dragon Armor', 1, 1, 6000);

-- Stop players from abusing skill range on Turtle attacks.
update mobskill set trirange=-2 where mobid=45422 and actNo=3;

update npc set atk_magic_speed=2400 where npcid=46096;
update npc set sub_magic_speed=2344 where npcid=46096;
update mobskill set leverage=30 where mobid=46096 and actNo=1;

insert into spawnlist (location, count, npc_templateid, locx, locy, locx1, locy1, locx2, locy2, mapid) values ("Fire Egg", 50, 46068, 32762, 32799, 32704, 32640, 32820, 32959, 778), ("Unchosen One", 30, 46069, 32740, 32842, 32704, 32726, 32777, 32959, 778), ("Unchosen One", 15, 46070, 32888, 32780, 32817, 32740, 32959, 32820, 778), ("Unchosen One", 15, 46072, 32888, 32780, 32817, 32740, 32959, 32820, 778), ("Unchosen One", 10, 46074, 32740, 32842, 32704, 32726, 32777, 32959, 778), ("Unchosen One", 10, 46075, 32888, 32780, 32817, 32740, 32959, 32820, 778), ("Unchosen One", 10, 46076, 32831, 32665, 32704, 32604, 32959, 32726, 778), ("Unchosen One", 15, 46078, 32831, 32665, 32704, 32604, 32959, 32726, 778), ("Unchosen One", 15, 46079, 32831, 32665, 32704, 32604, 32959, 32726, 778);

insert into spawnlist (location, count, npc_templateid, locx, locy, locx1, locy1, locx2, locy2, mapid) values ("Unchosen One", 20, 46077, 32768, 32895, 32832, 32704, 32959, 32831, 779), ("Unchosen One", 20, 46080, 32768, 32895, 32832, 32704, 32959, 32831, 779), ("Unchosen One", 20, 46081, 32768, 32895, 32832, 32704, 32959, 32831, 779);
