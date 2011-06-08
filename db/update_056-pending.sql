-- starting to get our db shaped back to match the latest code

-- I'd definitely not use this if anyone is looking.  wait till we're finished

alter table ub_settings add enter_dragonknight tinyint(3) unsigned not null after enter_darkelf;
alter table ub_settings add enter_illusionist tinyint(3) unsigned not null after enter_dragonknight;
alter table npcchat add is_world_chat tinyint(1) unsigned not null default '0' after is_shout;
alter table npc add alt_atk_speed int(10) unsigned not null default '0' after atkspeed;
