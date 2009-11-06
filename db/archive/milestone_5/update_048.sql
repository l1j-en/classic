
-- update 48

# Update name for Aaarrrggghhh!!! to Ariorc
update npc set name = 'Ariorc' where npcid = 45671;
update mobskill set mobname = 'Ariorc' where mobid = 45671;
update npc set note = 'Kent Castle Dunegon Boss' where npcid = 45671;
# Note - Ariorc skills missing = 10040 and 10041

# Update drops for earrings of Purification, itemid = 21019, change rate from .1% to .5%
update droplist set chance = 5000 where itemid = 21019 and mobid = 45492;
update droplist set chance = 5000 where itemid = 21019 and mobid = 45534;
insert into droplist values (45007,21019,1,1,5000);
insert into droplist values (45548,21019,1,1,5000);
insert into droplist values (45458,21019,1,1,5000);
insert into droplist values (45535,21019,1,1,5000);

# Update missing quest npcs for Lastavard area
INSERT INTO `spawnlist_npc` VALUES ('50113', 'Eris', '1', '71126', '32695', '32804', '0', '0', '6', '0', '450', '0');
INSERT INTO `spawnlist_npc` VALUES ('50114', 'Squaroo', '1', '71127', '32672', '32810', '0', '0', '1', '0', '450', '0');
INSERT INTO `spawnlist_npc` VALUES ('50115', 'Perita', '1', '71128', '32684', '32795', '0', '0', '4', '0', '450', '0');
INSERT INTO `spawnlist_npc` VALUES ('50116', 'Rumtis', '1', '71129', '32672', '32802', '0', '0', '4', '0', '450', '0');

# Update missing crit rate for blessed edoryu and claws
update weapon set double_dmg_chance = 25 where item_id = 100084;
update weapon set double_dmg_chance = 25 where item_id = 100074;
update weapon set double_dmg_chance = 37 where item_id = 100164;
update weapon set double_dmg_chance = 34 where item_id = 100157;

# Update missing ac value for Pretender King Gloves
update armor set ac = -1 where item_id = 20176;

# Correct names for mislabeled armor
update armor set name = 'Belt of New Life' where item_id = 21069;
update armor set name = 'Belt of New Life (Water)' where item_id = 21070;
update armor set name = 'Belt of New Life (Wind)' where item_id = 21071;
update armor set name = 'Belt of New Life (Fire)' where item_id = 21072;
update armor set name = 'Belt of New Life (Earth)' where item_id = 21073;

# update name for unknown npc
update npc set name = 'Timmie' where npcid = 71006;
update npc set name = 'Blacksmith Ron' where npcid = 71003;
update npc set name = 'Pharmacist Ikushi' where npcid = 71001;
update npc set name = 'Chicory' where npcid = 71009;
update npc set name = 'Burriana' where npcid = 71011;
update npc set name = 'ETA Adventurers' where npcid = 71032;
update npc set name = 'Rabbi' where npcid = 71034;
update npc set name = 'Hermit' where npcid = 71033;
update npc set name = 'BoneSmith Jinan' where npcid = 71022;
update npc set name = 'BoneSmith Matti' where npcid = 71021;
update npc set name = 'Region' where npcid = 71020;
update npc set name = 'BoneSmith Kei' where npcid = 71023;
update npc set name = 'Vito Disciples' where npcid = 71019;
update npc set name = 'Fader' where npcid = 71018;
update npc set name = 'Kesukin' where npcid = 71025;

#update missing mobskill reference names
update mobskill set mobname = 'Dark Elf Deserters' where mobid = 45906;
update mobskill set mobname = 'Dark Elementalist' where mobid = 45907;
update mobskill set mobname = 'Black Wizard' where mobid = 46018;
update mobskill set mobname = 'Greedy Wizard' where mobid = 46021;

# Fix Training Dummy Names to not display
update npc set nameid = '' where npcid = 45001;
update npc set nameid = '' where npcid = 45002;
update npc set nameid = '' where npcid = 45003;
update npc set nameid = '' where npcid = 45004;

# Fix to disallow use of summons/pets underwater
update mapids set take_pets = 0 where mapid = 63;
update mapids set recall_pets = 0 where mapid = 63;
update mapids set take_pets = 0 where mapid = 420;
update mapids set recall_pets = 0 where mapid = 420;
update mapids set take_pets = 0 where mapid = 253;
update mapids set recall_pets = 0 where mapid = 253;
update mapids set take_pets = 0 where mapid = 65;
update mapids set recall_pets = 0 where mapid = 65;
update mapids set take_pets = 0 where mapid = 558;
update mapids set recall_pets = 0 where mapid = 558;
update mapids set take_pets = 0 where mapid = 604;
update mapids set recall_pets = 0 where mapid = 604;

# Correct incorrect name for Polluted Orc Warrior
update mobskill set mobname = 'Polluted Orc Hunter' where mobid = 45772;
update npc set name = 'Polluted Orc Hunter' where npcid = 45772;
update npc set nameid = '$4145 $4578' where npcid = 45772;

# change Wind Tear invgfx to 865 was 942
update etcitem set invgfx = 865 where item_id = 40498;

# update proc for moonbow
update weapon_skill set probability = 10 where weapon_id = 205;

# Make Blessed Unicorn Horn Stackable
update etcitem set stackable = 1 where item_id = 41352;

