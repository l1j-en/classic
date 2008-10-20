-- update 22

-- corrected dialog for healer in HV,SI
update npcaction set normal_action = 'noved' where npcid = 70512;
update npcaction set caotic_action = 'noved' where npcid = 70512;
