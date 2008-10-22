-- update 30

-- merge character_items table changes
alter table character_items add column charge_count int(11) default NULL;