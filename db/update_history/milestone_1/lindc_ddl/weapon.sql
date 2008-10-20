-- update 30

-- more weapon changes/additions
alter table weapon add column `cant_delete` int(2) unsigned NOT NULL default '0';

-- update and add doubledmgchange at weapon table
ALTER TABLE `weapon` ADD column `double_dmg_chance` int(10) NOT NULL AFTER `cant_delete`; 