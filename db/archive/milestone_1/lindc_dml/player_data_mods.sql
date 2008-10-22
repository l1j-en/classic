-- update 30

-- remove all player-owned charge items
delete from character_items where item_id in (40006, 40007, 40008, 40009, 41401, 140006, 140008);
delete from character_warehouse where item_id in (40006, 40007, 40008, 40009, 41401, 140006, 140008);
delete from clan_warehouse where item_id in (40006, 40007, 40008, 40009, 41401, 140006, 140008);