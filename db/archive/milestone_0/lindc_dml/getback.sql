-- update 24

-- fix SC esc destination
insert into getback values (0, 0, 0, 0, 304, 32857, 32898, 32857, 32898, 32857, 32898, 304, 0, 0, 0, 1, 'Silent Cavern');



-- update 25

-- update getback notes
update getback g set note = (select m.locationname from mapids m where m.mapid = g.area_mapid) 
where exists (select 'x' from mapids m where m.mapid = g.area_mapid);

-- blank out unused getback notes (these maybe should be removed)
update getback g set note = '' where not exists (select 'x' from mapids m where m.mapid = g.area_mapid);