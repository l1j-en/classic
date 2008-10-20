-- update 25

-- fix GC recluse village area doors (recluse -> GC area connecting to abyss lake)
insert into dungeon values (32823, 32854, 400, 32681, 32971, 400, 2, 'GC Recluse Area');
insert into dungeon values (32681, 32971, 400, 32823, 32854, 400, 2, 'GC Recluse Area');

-- update dungeon note (just putting the destination in here)
update dungeon d set d.note = (select m.locationname from mapids m where m.mapid = d.new_mapid);