-- update 30

-- merge skills column changes
alter table skills drop column arrowType;

-- more skills table changes/additions
alter table skills add column action_id int(10) unsigned NOT NULL default 0;