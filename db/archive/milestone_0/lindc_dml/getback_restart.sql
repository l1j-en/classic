-- update 25

-- update getback_restart areanames
update getback_restart gr set areaname = (select m.locationname from mapids m where m.mapid = gr.area);