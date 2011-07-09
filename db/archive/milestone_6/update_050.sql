
-- update 50

# Add quick reference info to easily identify drops
ALTER TABLE droplist ADD mob_name varchar(45) after mobid;
ALTER TABLE droplist ADD item_name varchar(45) after itemid;

# Correct incorrect Ghost of Resentment Display Name
update npc set nameid = '$5111' where npcid = 45915;

# correct item name
update etcitem set name = 'Mithril Pet Armor' where item_id = 40764;

# name corrections
update armor set name = 'Evidence Box of the Dark Spirit Army' where item_id = 40636;
update armor set name_id = 'Evidence Box of the Dark Spirit Army' where item_id = 40636;
update armor set name = 'Amulet of Dread Queen' where item_id = 20253;
update armor set name_id = 'Amulet of Dread Queen' where item_id = 20253;
update armor set name = 'Cloak of New King' where item_id = 20067;
update armor set name_id = 'Cloak of New King' where item_id = 20067;
update armor set name = 'Gloves of Assassin King' where item_id = 20178;
update armor set name_id = 'Gloves of Assassin King' where item_id = 20178;
update armor set name = 'Gloves of the Pretender King' where item_id = 20170;
update armor set name_id = 'Gloves of the Pretender King' where item_id = 20170;

# update kafir pouch references
update etcitem set name ='Diamond kafir pouch' where item_id = 49005;
update etcitem set name ='Ruby kafir pouch' where item_id = 49006;
update etcitem set name ='Sapphire kafir pouch' where item_id = 49007;
update etcitem set name ='Emerald kafir pouch' where item_id = 49008;
update etcitem set name ='High Quality Diamond kafir pouch' where item_id = 49009;
update etcitem set name ='High Quality Emerald kafir pouch' where item_id = 49010;
update etcitem set name ='High Quality Ruby kafir pouch' where item_id = 49011;
update etcitem set name ='High Quality Sapphire kafir pouch' where item_id = 49012;

# Update unknown treasure boxes
update etcitem set name = 'Apprentice Prince Pouch' where item_id = 41217;
update etcitem set name = 'Apprentice Knight Pouch' where item_id = 41218;
update etcitem set name = 'Apprentice Elf Pouch' where item_id = 41219;
update etcitem set name = 'Apprentice Wizard Pouch' where item_id = 41220;
update etcitem set name = 'Apprentice Dark Elf Pouch' where item_id = 41221;
update etcitem set name = 'Bag of Bones' where item_id = 41241;

# Novelty Pet Collars
update armor set name = 'High Raccoon Choker' where item_id = 20346;
update armor set name_id = 'High Raccoon Choker' where item_id = 20346;
update armor_set set note = 'High Raccoon Necklace - High Raccoon' where id = 15;
update armor set name = 'High Bear Choker' where item_id = 20419;
update armor set name_id = 'High Bear Choker' where item_id = 20419;
update armor_set set note = 'High Bear Choker - High Bear' where id = 32;

# Add additional Siege Guard to heine outside of siege flags
#insert into spawnlist_npc values (88123,'Heine Guard',1,70857,33535,33300,0,0,5,0,4,100);

