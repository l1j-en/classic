-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here
-- this allows them to be verified as working together before being
-- migrated to the DML scripts

-- update 34

-- drop some old event rows
delete from mobskill where mobid in (90002, 90003);
delete from npc where npcid in (90000, 90001, 90002, 90003);
delete from droplist where mobid in (90000, 90001, 90002, 90003);

-- fix some of the column ordering (note: not all tables need to have the 
-- exact same column order, just those that need to support merging.)

-- armor table
alter table armor drop column cant_delete;
alter table armor add column cant_delete int(2) unsigned NOT NULL default '0' after trade;
alter table armor change regist_stan regist_stun int(2) NOT NULL default '0';

-- etcitem table
alter table etcitem drop column max_charge_count;
alter table etcitem add column max_charge_count int(10) unsigned NOT NULL default '0' after stackable;
update etcitem set max_charge_count = 15 where item_id in (40006, 40007, 40008, 40009, 140006, 140008, 41401);
alter table etcitem drop column cant_delete;
alter table etcitem add column cant_delete int(2) unsigned NOT NULL default '0' after trade;

-- npc table
alter table npc drop column transform_gfxid;
alter table npc add column transform_gfxid int(10) NOT NULL default '0' after transform_id;
update npc set transform_gfxid = 5306 where npcid in (45448, 45474, 45475, 45489, 45495, 45669, 45830, 45837, 45838, 45845, 45846, 45848, 45850, 45851, 45852);
update npc set transform_gfxid = -1 where npcid in (71183, 71184, 71185, 71186, 71187, 71188, 71189);
alter table skills drop column action_id;
alter table skills add column action_id int(10) unsigned NOT NULL default 0 after nameid;
update skills set action_id = 19;
update skills set action_id = 18 where skill_id in (4, 6, 7, 10, 11, 15, 16, 17, 22, 25, 28, 30, 34, 38, 45, 
46, 50, 53, 58, 59, 62, 65, 70, 74, 77, 80, 108, 132, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 
10008, 10009, 10010, 10011, 10012, 10013, 10014, 10015, 10016, 10017, 10018, 10019, 10020, 10021, 10022, 10023, 
10024, 10025, 10026, 10027, 10028, 10029, 10030, 10031, 10032, 10033, 10034, 10035, 10036, 10037, 10038, 10039, 
10040, 10041, 10042, 10043, 10044, 10045, 10046, 10047, 10048, 10049, 10050, 10051, 10052, 10053, 10054, 10055, 
10056, 10058, 10059, 10060, 10061, 10062, 10063, 10064, 10065, 10066, 10067, 10068, 10069, 10070, 10072, 10073, 
10074, 10075, 10076, 10077, 10078, 10079, 10080, 10081, 10082, 10083, 10084, 10085, 10086, 10087, 10088, 10089);

-- weapon table
alter table weapon drop column double_dmg_chance;
ALTER TABLE `weapon` ADD column `double_dmg_chance` int(10) unsigned NOT NULL  AFTER `haste_item`; 
update weapon set double_dmg_chance = 10 where item_id = 69; 
update weapon set double_dmg_chance = 11 where item_id = 70; 
update weapon set double_dmg_chance = 10 where item_id = 71; 
update weapon set double_dmg_chance = 11 where item_id = 72; 
update weapon set double_dmg_chance = 25 where item_id = 73; 
update weapon set double_dmg_chance = 25 where item_id = 74; 
update weapon set double_dmg_chance = 13 where item_id = 75; 
update weapon set double_dmg_chance = 20 where item_id = 76; 
update weapon set double_dmg_chance = 30 where item_id = 77; 
update weapon set double_dmg_chance = 25 where item_id = 78; 
update weapon set double_dmg_chance = 30 where item_id = 79; 
update weapon set double_dmg_chance = 25 where item_id = 80; 
update weapon set double_dmg_chance = 25 where item_id = 81; 
update weapon set double_dmg_chance = 20 where item_id = 82; 
update weapon set double_dmg_chance = 25 where item_id = 83; 
update weapon set double_dmg_chance = 25 where item_id = 84; 
update weapon set double_dmg_chance = 20 where item_id = 85; 
update weapon set double_dmg_chance = 25 where item_id = 86; 
update weapon set double_dmg_chance = 40 where item_id = 152; 
update weapon set double_dmg_chance = 40 where item_id = 153; 
update weapon set double_dmg_chance = 33 where item_id = 154; 
update weapon set double_dmg_chance = 30 where item_id = 155; 
update weapon set double_dmg_chance = 30 where item_id = 156; 
update weapon set double_dmg_chance = 34 where item_id = 157; 
update weapon set double_dmg_chance = 25 where item_id = 158; 
update weapon set double_dmg_chance = 15 where item_id = 159; 
update weapon set double_dmg_chance = 35 where item_id = 160; 
update weapon set double_dmg_chance = 40 where item_id = 161; 
update weapon set double_dmg_chance = 36 where item_id = 162; 
update weapon set double_dmg_chance = 35 where item_id = 163; 
update weapon set double_dmg_chance = 37 where item_id = 164; 
update weapon set double_dmg_chance = 36 where item_id = 165; 
update weapon set double_dmg_chance = 38 where item_id = 166; 

-- add new columns
alter table characters add column DeleteTime datetime default NULL;
alter table weapon_skill add column area int(11) NOT NULL default '0' after random_damage;

