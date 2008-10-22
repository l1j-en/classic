-- update 6

-- correct name_id for cpm and bpm
update armor set name_id = '$154' where item_id in (20149, 120149);
update armor set name_id = '$153' where item_id in (20128, 120128);

-- swap inventory images for cpm and bpm
update armor set invgfx = 22 where item_id in (20149, 120149);
update armor set invgfx = 32 where item_id in (20128, 120128);
