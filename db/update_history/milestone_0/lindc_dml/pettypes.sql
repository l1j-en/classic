-- update 25

-- update pettype names
update pettypes p set p.name = (select n.name from npc n where n.npcid = p.basenpcid);