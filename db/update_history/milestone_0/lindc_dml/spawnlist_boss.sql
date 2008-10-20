-- update 13

-- remove mlc7f DK
delete from spawnlist_boss where id = 41;



-- update 25

-- crocodile boss should respawn regardless if a PC is on screen at the time
update spawnlist_boss set respawn_screen = 1 where npc_id = 45338;

-- update spawnlist_boss location
update spawnlist_boss sb set sb.location = (select n.name from npc n where n.npcid = sb.npc_id);