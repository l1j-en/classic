-- update 21

-- correct name for Lekman
update npc set name = 'Lekman' where npcid = 50113;

-- correct name for Herbert
update npc set name = 'Herbert' where npcid = 70641;

-- remove spell scroll: light from skt shop, since lanterns work now
delete from shop where item_id = 40860;

-- fix Firewall name and light_size
update npc set name = 'Firewall', light_size = 10 where npcid = 81157;

-- fix firewall/invis cast gfx
update skills set castgfx = 2510 where skill_id in (58, 60);

-- slightly reduce invis droprate from DE (1000 -> 800)
update droplist set chance = 800 where itemid = 40205 and mobid = 45265;

-- Change GMRoom (Jail) so that you cant restart to get out from it
update area set x1 = 32767, y1 = 32796, x2 = 32767, y2 = 32796, flag = 2, restart = 99 where mapid = 99;

