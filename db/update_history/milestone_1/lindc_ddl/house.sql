-- update 30

-- merge in house column changes
alter table house add column `is_purchase_basement` int(10) unsigned NOT NULL default '0';
alter table house add column `tax_deadline` datetime;