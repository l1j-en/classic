-- update 2

-- reduced fixed dmg on thors, eva, ret, paag, bume
update weapon_skill set fix_damage = fix_damage - 5 where weapon_id in (450000, 450001, 450002, 450003, 36);

-- fix eva's name
update weapon set name_id = 'Eva\'s Scorn' where item_id = 36;

-- fix thor's name
update weapon set name_id = 'Thor\'s Hammer', name = 'Thor\'s Hammer' where item_id = 450000;

-- rarify thor's, eva's, bume
update droplist set chance = chance / 5 where itemid in (450000, 36, 450003);

-- de-nerf blizz
update skills set damage_value = 10, damage_dice_count = 8 where skill_id = 59;

-- make o-blood more common, o-belt more rare
update droplist set chance = 500 where itemid = 20317;
update droplist set chance = 2000 where itemid = 40513;

-- nerf elder c-l dmg
update mobskill set leverage = 5 where mobid = 45215 and actno = 0;

-- nerf Dark Elf c-l dmg
update mobskill set leverage = 15 where mobid = 45265 and actno = 0;
update mobskill set leverage = 30 where mobid = 45364 and actno = 0;

-- nerf Dark Elf Wizard coc and tornado dmg
update mobskill set leverage = 15 where mobid = 45447 and actno = 0;
update mobskill set leverage = 30 where mobid = 45447 and actno = 1;

-- reduce secret room key drop rate
update droplist set chance = 20000 where itemid = 40555;
