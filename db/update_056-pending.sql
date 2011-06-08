-- starting to get our db shaped back to match the latest code

-- I'd definitely not use this if anyone is looking.  wait till we're finished


-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE

-- Queries that are pending an update should be placed here. This allows them 
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 56

-- STRUCTURE CHANGES / New Tables (no data)

-- accounts
alter table accounts add character_slot int(2) unsigned NOT NULL default '0' after banned;

-- armor
alter table armor add unidentified_name_id varchar(45) NOT NULL default '' after name;
alter table armor add identified_name_id varchar(45) NOT NULL default '' after unidentified_name_id;
alter table armor add use_dragonknight int(2) unsigned NOT NULL default '0' after use_darkelf;
alter table armor add use_illusionist int(2) unsigned NOT NULL default '0' after use_dragonknight;
alter table armor add hit_modifier int(10) NOT NULL default '0' after weight_reduction;
alter table armor add dmg_modifier int(10) NOT NULL default '0' after hit_modifier;
alter table armor add bow_hit_modifier int(10) NOT NULL default '0' after dmg_modifier;
alter table armor add bow_dmg_modifier int(10) NOT NULL default '0' after bow_hit_modifier;

-- etcitem
alter table etcitem add unidentified_name_id varchar(45) NOT NULL default '' after name;
alter table etcitem add identified_name_id varchar(45) NOT NULL default '' after unidentified_name_id;
alter table etcitem add can_seal int(2) unsigned NOT NULL default '0' after cant_delete;

-- mail
CREATE TABLE `mail` (
  `id` int(10) unsigned NOT NULL default '0',
  `type` int(10) unsigned NOT NULL default '0',
  `sender` varchar(16) default NULL,
  `receiver` varchar(16) default NULL,
  `date` varchar(16) default NULL,
  `read_status` tinyint(1) unsigned NOT NULL default '0',
  `subject` BLOB,
  `content` BLOB,
  PRIMARY KEY (`id`)
);

-- mobgroup
alter table mobgroup add minion6_id int(10) unsigned NOT NULL default '0' after minion5_count;
alter table mobgroup add minion6_count int(10) unsigned NOT NULL default '0' after minion6_id;
alter table mobgroup add minion7_id int(10) unsigned NOT NULL default '0' after minion6_count;
alter table mobgroup add minion7_count int(10) unsigned NOT NULL default '0' after minion7_id;

-- npc
alter table npc add alt_atk_speed int(10) unsigned not null default '0' after atkspeed;

-- npcchat
alter table npcchat add is_world_chat tinyint(1) unsigned not null default '0' after is_shout;
alter table npcchat add game_time int(10) unsigned NOT NULL default '0' after repeat_interval;

-- skills
alter table skills add castgfx2 int(10) unsigned NOT NULL default '0' after castgfx;

-- ub_settings
alter table ub_settings add enter_dragonknight tinyint(3) unsigned not null after enter_darkelf;
alter table ub_settings add enter_illusionist tinyint(3) unsigned not null after enter_dragonknight;

-- weapon
alter table weapon add unidentified_name_id varchar(45) NOT NULL default '' after name;
alter table weapon add identified_name_id varchar(45) NOT NULL default '' after unidentified_name_id;
alter table weapon add `range` int(10) NOT NULL default '0' after dmg_large;
alter table weapon add use_dragonknight int(2) unsigned NOT NULL default '0' after use_darkelf;
alter table weapon add use_illusionist int(2) unsigned NOT NULL default '0' after use_dragonknight;



alter table character_elf_warehouse add bless int(11) default NULL after last_used;
alter table character_items add bless int(11) default NULL after last_used;
alter table character_warehouse add bless int(11) default NULL after last_used;
alter table clan_warehouse add bless int(11) default NULL after last_used;
alter table characters add PkCountForElf int(10) NOT NULL default '0' after Pkcount;
alter table characters add LastPkForElf datetime default NULL after LastPk;
alter table characters add OriginalStr int(3) NOT NULL default '0' after DeleteTime;
alter table characters add OriginalCon int(3) NOT NULL default '0' after OriginalStr;
alter table characters add OriginalDex int(3) NOT NULL default '0' after OriginalCon;
alter table characters add OriginalCha int(3) NOT NULL default '0' after OriginalDex;
alter table characters add OriginalInt int(3) NOT NULL default '0' after OriginalCha;
alter table characters add OriginalWis int(3) NOT NULL default '0' after OriginalInt;

alter table character_elf_warehouse add attr_enchant_kind int(11) default NULL after bless;
alter table character_elf_warehouse add attr_enchant_level int(11) default NULL after bless;

alter table character_items add attr_enchant_kind int(11) default NULL after bless;
alter table character_items add attr_enchant_level int(11) default NULL after bless;

alter table character_warehouse add attr_enchant_kind int(11) default NULL after bless;
alter table character_warehouse add attr_enchant_level int(11) default NULL after bless;

alter table clan_warehouse add attr_enchant_kind int(11) default NULL after bless;
alter table clan_warehouse add attr_enchant_level int(11) default NULL after bless;

-- NEW DATA

-- ALTERED DATA

