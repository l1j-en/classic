-- update 32

-- 2 new resist for armor blind and sustian
alter table armor add column `regist_sustain` int(2) unsigned NOT NULL default '0';
alter table armor add column `regist_blind` int(2) unsigned NOT NULL default '0';