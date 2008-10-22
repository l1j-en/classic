-- update 30

-- merge character_warehouse table changes
alter table character_warehouse add column charge_count int(11) default NULL;