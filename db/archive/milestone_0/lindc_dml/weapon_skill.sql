-- update 1

-- change eva's scorn to proper effect
update weapon_skill set effect_id = 1714 where weapon_id = 36;


-- update 2

-- reduced fixed dmg on thors, eva, ret, paag, bume
update weapon_skill set fix_damage = fix_damage - 5 where weapon_id in (450000, 450001, 450002, 450003, 36);



-- update 10 

-- change eva's scorn fixed_damage to be in line with thor's/bume
update weapon_skill set fix_damage = 15 where weapon_id = 36;

-- change eva's scorn probability to be in line with thor's/bume
update weapon_skill set probability = 13 where weapon_id = 36;



-- update 13

-- undo bume/scorn/thor's nerf
update weapon_skill set fix_damage = fix_damage + 5 where weapon_id in (450000, 450001, 36);
update weapon_skill set probability = 16 where weapon_id = 36;


-- update 20

-- update weapon_skill notes
update weapon_skill set note = 'Sword of Silence' where weapon_id = 47;
update weapon_skill set note = 'Sword of Kurtz ' where weapon_id = 54;
update weapon_skill set note = 'Fire Sword of Death Knight' where weapon_id = 58;
update weapon_skill set note = 'Edoryu of Ronde' where weapon_id = 76;
update weapon_skill set note = 'Staff of Ice Queen' where weapon_id = 121;
update weapon_skill set note = 'Thor\'s Hammer' where weapon_id = 450000;
update weapon_skill set note = 'Paagrio\'s Hatred' where weapon_id = 450001;
update weapon_skill set note = 'Maphr\'s Retribution' where weapon_id = 450002;
update weapon_skill set note = 'Orcish Bume Smache' where weapon_id = 450003;
update weapon_skill set note = 'Eva\'s Scorn' where weapon_id = 36;

-- fix Sword of Silence probability (1 -> 7)
update weapon_skill set probability = 7 where weapon_id = 47;