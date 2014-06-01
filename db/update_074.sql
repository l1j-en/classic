insert into commands set name="buffcheck", access_level=100, class_name="BuffCheck";

-- Improving summoned Cougar by a little bit based on old videos.
update npc set mr=100 where npcid=81240;

update npc set agro=1 where name='Obelisk - Dark';
update npc set agrofamily=1 where npcid>=46107 and npcid<=46122;

update armor set use_dragonknight=1 where name='Helm of Magic: Speed' or name='Helm of Magic: Power' or name='Helm of Magic: Healing';

update ub_settings set enter_dragonknight=1,enter_illusionist=1;

-- Scale back Fire Necro and Bone Dragon leverages from npcandskilladjustments.
update mobskill set leverage=75 where mobid=45480 and actNo=1;
update mobskill set leverage=10 where mobid=45522 and actNo=0;

insert into spawnlist values
(78100027,'Thebes Guardian - Red',3,46120,0,32835,32848,0,0,32866,32747,32980,32849,0,0,0,781,1,0,0,0,1,8,2,100),
(78100028,'Thebes Elder - Purple',3,46122,0,32835,32848,0,0,32866,32747,32980,32849,0,0,0,781,1,0,0,0,1,8,2,100),
(78100029,'Horus Falcon - Blue',3,46118,0,32835,32848,0,0,32866,32747,32980,32849,0,0,0,781,1,0,0,0,1,8,2,100),
(78000011,'Kalbis - Red',3,46112,0,32777,32836,0,0,32787,32832,32798,33000,0,0,0,780,1,0,0,0,1,8,2,100),
(78000012,'Obelisk - Dark',3,46114,0,32777,32836,0,0,32787,32832,32798,33000,0,0,0,780,1,0,0,0,1,8,2,100),
(78000013,'Sphinx - Dark',3,46116,0,32777,32836,0,0,32787,32832,32798,33000,0,0,0,780,1,0,0,0,1,8,2,100);
update spawnlist set count=count*2 where id>=78000001 and id<=78000013;
update spawnlist set count=count*2 where id>=78100001 and id<=78100029;

update weapon set dmgmodifier=3 where type='chainsword';

insert into armor (item_id, name, unidentified_name_id, identified_name_id, type, material, weight, invgfx, ac, safenchant, use_illusionist, add_mp, add_mpr) values (30011, "Cloak of Illusionist", "$5659", "$5659", "cloak", "cloth", 10000, 3004, -1, 6, 1, 20, 4);
insert into armor (item_id, name, unidentified_name_id, identified_name_id, type, material, weight, invgfx, ac, safenchant, use_darkelf, use_mage, add_mp, add_wis, add_mpr) values (30010, "Hand of the Reaper", "$13789", "$13789", "glove", "bone", 3000, 2008, -1, 0, 1, 1, 20, 1, 3);
insert into weapon (name, unidentified_name_id, identified_name_id, type, material, weight, invgfx, dmg_small, dmg_large, safenchant, use_knight, use_dragonknight, hitmodifier, dmgmodifier, canbedmg, double_dmg_chance) values ("Spirit Defender", "Spirit Defender", "Spirit Defender", "tohandsword", "iron", 150000, 2082, 22, 22, 6, 1, 1, 1, 2, 0, 0);

update droplist set mob_name="Spirit" where mobId=45795;
insert into droplist (mobid, mob_name, itemid, item_name, min, max, chance) values (45795, "Spirit", 450006, "Spirit Defender", 1, 1, 10000);
update droplist set mob_name="Grim Reaper" where mobid=45673;
insert into droplist (mobid, mob_name, itemid, item_name, min, max, chance) values (45673, "Grim Reaper", 30010, "Hand of the Reaper", 1, 1, 2000);
update droplist set mob_name="Great Spirit of Water" where mobid=45620;
insert into droplist (mobid, mob_name, itemid, item_name, min, max, chance) values (45620, "Great Spirit of Water", 41152, "Spirit Crystal(Pollute Water)", 1, 1, 600);
update droplist set mob_name="Great Spirit of Fire" where mobid=45622;

update droplist set chance = 600 where mob_name="Great Spirit of Fire" and itemid=41149;

alter table pets add weapon int(10) unsigned default 0;
alter table pets add armor int(10) unsigned default 0;
