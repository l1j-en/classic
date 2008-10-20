-- update 30

-- merge in etcitem column changes
alter table etcitem add column `max_charge_count` int(10) unsigned NOT NULL DEFAULT '0';
alter table etcitem add column `save_at_once` tinyint(1) unsigned NOT NULL DEFAULT '1';

-- more etcitem changes/additions
alter table etcitem add column `cant_delete` int(2) unsigned NOT NULL default '0';