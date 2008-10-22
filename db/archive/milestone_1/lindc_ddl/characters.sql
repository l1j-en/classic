-- update 30

-- merge characters table changes
alter table characters add column HighLevel int(11) unsigned NOT NULL default '0';
alter table characters change IsGM AccessLevel int(10) unsigned NOT NULL default '0';



-- update 31

-- clan rank colum
alter table characters add column `ClanRank` int(3) unsigned NOT NULL default '0';