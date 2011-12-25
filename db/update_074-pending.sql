
-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

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
(78000011,'Kalbis - Red',3,46112,0,32777,32836,0,0,32787,32832,32798,33000,0,0,0,781,1,0,0,0,1,8,2,100),
(78000012,'Obelisk - Dark',3,46114,0,32777,32836,0,0,32787,32832,32798,33000,0,0,0,781,1,0,0,0,1,8,2,100),
(78000013,'Sphinx - Dark',3,46116,0,32777,32836,0,0,32787,32832,32798,33000,0,0,0,781,1,0,0,0,1,8,2,100);
update spawnlist set count=count*2 where id>=78000001 and id<=78000013;
update spawnlist set count=count*2 where id>=78100001 and id<=78100029;

update weapon set dmgmodifier=3 where type='chainsword';
