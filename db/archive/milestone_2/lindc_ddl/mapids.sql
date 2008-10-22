-- update 32

--mapid table updated
-- remember the table needs still tobe updated i set it now to 1 so you can use everywhere items and skills till the table is fixed
alter table mapids add column `usable_item` int(4) unsigned NOT NULL default '1';
alter table mapids add column `usable_skill` int(4) unsigned NOT NULL default '1';