-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 63

-- girtas fix from darkwolf.  
update npc set passispeed = 0, alt_atk_speed = 2200, ranged=10 where npcid = 81163;

-- populate some null fields in droplist
UPDATE droplist p, weapon pp SET p.item_name = pp.name where p.itemid = pp.item_id;
UPDATE droplist p, armor pp SET p.item_name = pp.name where p.itemid = pp.item_id;
UPDATE droplist p, etcitem pp SET p.item_name = pp.name where p.itemid = pp.item_id;

-- undo the devils blood change
UPDATE droplist SET chance = chance/2 WHERE itemid = 40031;

-- fix the unchosen ones tele skill amount
update mobskill set trirnd = 10 where mobid = 46096;

-- Add column PolyName to Armor_Set for easy identifier
Alter Table `armor_set` add polyname varchar(45) NOT NULL default '' after note;

-- Change armor_set to show poly names
update armor_set set polyname = 'Demon' where id = 1;
update armor_set set polyname = 'Death Knight' where id = 2;
update armor_set set polyname = 'Ken Rahuel' where id = 3;
update armor_set set polyname = 'Kurtz' where id = 4;
update armor_set set polyname = 'Cerenis' where id = 5;
update armor_set set polyname = 'Jack-O-Lantern' where id = 6;
update armor_set set polyname = 'Vampire' where id = 7;
update armor_set set polyname = 'Death' where id = 8;
update armor_set set polyname = 'Pink Vest Mambo' where id = 9;
update armor_set set polyname = 'Orange Vest Mambo' where id = 10;
update armor_set set polyname = 'Skeleton' where id = 11;
update armor_set set polyname = 'Orc Fighter' where id = 12;
update armor_set set polyname = 'Werewolf' where id = 13;
update armor_set set polyname = 'High Collie' where id = 14;
update armor_set set polyname = 'High Raccoon' where id = 15;
update armor_set set polyname = 'Blue Hakama' where id = 16;
update armor_set set polyname = 'Orange Haregi' where id = 17;
update armor_set set polyname = 'Beagle' where id = 18;
update armor_set set polyname = 'Snowman' where id = 19;
update armor_set set polyname = 'Snowman' where id = 20;
update armor_set set polyname = 'Manekineko Cat' where id = 21;
update armor_set set polyname = 'Red Orc' where id = 22;
update armor_set set polyname = 'Captain Drake' where id = 23;
update armor_set set polyname = 'Iris' where id = 24;
update armor_set set polyname = 'Knight Vald' where id = 25;
update armor_set set polyname = 'Succubus Queen' where id = 26;
update armor_set set polyname = 'Red Soccer Player' where id = 27;
update armor_set set polyname = 'Blue Soccer Player' where id = 28;
update armor_set set polyname = 'Red Orc' where id = 29;
update armor_set set polyname = 'Mounted Royal' where id = 30;
update armor_set set polyname = 'Jack-O-Lantern' where id = 31;
update armor_set set polyname = 'High Bear' where id = 32;
update armor_set set polyname = 'None' where id = 33;
update armor_set set polyname = 'Orc Fighter' where id = 34;
update armor_set set polyname = 'Dwarf' where id = 35;
update armor_set set polyname = 'None' where id = 36;
update armor_set set polyname = 'None' where id = 37;
update armor_set set polyname = 'None' where id = 38;
update armor_set set polyname = 'None' where id = 39;
update armor_set set polyname = 'None' where id = 40;
update armor_set set polyname = 'None' where id = 41;
update armor_set set polyname = 'None' where id = 42;
update armor_set set polyname = 'None' where id = 43;
update armor_set set polyname = 'None' where id = 44;
update armor_set set polyname = 'None' where id = 45;
update armor_set set polyname = 'None' where id = 46;
update armor_set set polyname = 'None' where id = 47;
update armor_set set polyname = 'None' where id = 48;
update armor_set set polyname = 'None' where id = 49;
update armor_set set polyname = 'None' where id = 50;
update armor_set set polyname = 'None' where id = 51;
update armor_set set polyname = 'None' where id = 52;
update armor_set set polyname = 'None' where id = 53;
update armor_set set polyname = 'None' where id = 54;
update armor_set set polyname = 'None' where id = 55;
update armor_set set polyname = 'Drowned Male' where id = 56;
update armor_set set polyname = 'Drowned Female' where id = 57;
update armor_set set polyname = 'Male: Briefs' where id = 58;
update armor_set set polyname = 'Male: Trunks' where id = 59;
update armor_set set polyname = 'Woman SwimSuit' where id = 60;
update armor_set set polyname = 'Woman: Bikini' where id = 61;

-- Change armor_set correct missing names
update armor_set set note = 'Demon Set' where id = 1;
update armor_set set note = 'Death Knight Set' where id = 2;
update armor_set set note = 'Pretender King Set' where id = 3;
update armor_set set note = 'Kurtz Set' where id = 4;
update armor_set set note = 'Cerenis Set' where id = 5;
update armor_set set note = 'Pumpkin Set' where id = 6;
update armor_set set note = 'Cloak of Vampire' where id = 7;
update armor_set set note = 'Cloak of Sashin' where id = 8;
update armor_set set note = 'Easter Bunny Hat' where id = 9;
update armor_set set note = 'Easter Bunny Hat w/Carrot' where id = 10;
update armor_set set note = 'Left-Hand Ring of Dopple Boss' where id = 11;
update armor_set set note = 'Right-Hand Ring of Dopple Boss' where id = 12;
update armor_set set note = 'Necklace of Doppleganger Boss' where id = 13;
update armor_set set note = 'High Collie Choker' where id = 14;
update armor_set set note = 'High Raccoon Necklace' where id = 15;
update armor_set set note = 'Hakama' where id = 16;
update armor_set set note = 'Holiday Attire' where id = 17;
update armor_set set note = 'Amulet of Beagle' where id = 18;
update armor_set set note = 'Amulet of Snow Man' where id = 19;
update armor_set set note = 'Carrot and Stocking' where id = 20;
update armor_set set note = 'Lucky Cat Scarf' where id = 21;
update armor_set set note = 'Red Mask' where id = 22;
update armor_set set note = 'Red Soccer Uniform' where id = 27;
update armor_set set note = 'Blue Soccer Uniform' where id = 28;
update armor_set set note = 'Red Orc Mask' where id = 29;
update armor_set set note = 'Helmet for Horse Riding' where id = 30;
update armor_set set note = 'Halloween Blessing Cap' where id = 31;
update armor_set set note = 'High Bear Choker' where id = 32;
update armor_set set note = 'Orcish Fighter Set' where id = 34;
update armor_set set note = 'Dwarf Set' where id = 35;
update armor_set set note = 'T-Shirt of Ghost Man' where id = 55;
update armor_set set note = 'T-Shirt of Ghost Woman' where id = 56;
update armor_set set note = 'Male Swimwear: Briefs' where id = 57;
update armor_set set note = 'Male Swimwear: Trunks' where id = 58;
update armor_set set note = 'Woman SwimSuit' where id = 59;
update armor_set set note = 'Women Swimwear: Bikini' where id = 60;

-- Update missing or unknown armor names - Zylia
Update armor set name = 'Amulet of the Royalty' where item_id = 20376;
Update armor set name = 'Amulet of the Knight' where item_id = 20377;
Update armor set name = 'Amulet of the Elf' where item_id = 20378;
Update armor set name = 'Amulet of the Wizard' where item_id = 20379;
Update armor set name = 'Helm of Illusion' where item_id = 21035;
Update armor set name = 'T-Shirt of Illusion' where item_id = 21036;
Update armor set name = 'Shield of Illusion' where item_id = 21037;
Update armor set name = 'Boots of Illusion' where item_id = 21038;
Update armor set name = 'Burning Circlet' where item_id = 21039;
Update armor set name = 'Burning Shield' where item_id = 21040;
Update armor set name = 'Burning Boots' where item_id = 21041;
Update armor set name = 'Burning Gloves' where item_id = 21042;
Update armor set name = 'Talisman of Ironclad' where item_id = 21043;
Update armor set name = 'Talisman of Jiedi' where item_id = 21044;
Update armor set name = 'Talisman of Secret Maneuvers' where item_id = 21045;
Update armor set name = 'Talisman of Mercy' where item_id = 21046;
Update armor set name = 'Lucky Coin' where item_id = 21047;
Update armor set name = 'T-Shirt of Ghost Man' where item_id = 21061;
Update armor set name = 'T-Shirt of Ghost Woman' where item_id = 21062;
Update armor set name = 'Swimwear Me\'s Briefs' where item_id = 21063;
Update armor set name = 'Swimwear Men\'s Trunks' where item_id = 21064;
Update armor set name = 'Swimwear Women\'s One Piece' where item_id = 21065;
Update armor set name = 'Swimwear Women\'s Bikini' where item_id = 21066;
Update armor set name = 'Pumpkin Armor' where item_id = 21067;
Update armor set name = 'Ultimate Halloween Pumpkin Armor' where item_id = 21068;
Update armor set name = 'Ice Queen\'s Earring Lvl 0' where item_id = 21081;
Update armor set name = 'Ice Queen\'s Earring Lvl 1' where item_id = 21082;
Update armor set name = 'Ice Queen\'s Earring Lvl 2' where item_id = 21083;
Update armor set name = 'Ice Queen\'s Earring Lvl 3' where item_id = 21084;
Update armor set name = 'Ice Queen\'s Earring Lvl 4' where item_id = 21085;
Update armor set name = 'Ice Queen\'s Earring Lvl 5' where item_id = 21086;
Update armor set name = 'Ice Queen\'s Earring Lvl 6' where item_id = 21087;
Update armor set name = 'Ice Queen\'s Earring Lvl 7' where item_id = 21088;
Update armor set name = 'Ice Queen\'s Earring Lvl 8' where item_id = 21089;
Update armor set name = 'Ice Queen\'s Earring Lvl 9' where item_id = 21090;
Update armor set name = 'Ice Queen\'s Earring Lvl 10' where item_id = 21091;
Update armor set name = 'Ring of Thebes Osiris' where item_id = 21093;
Update armor set name = 'Ring of Thebes Anubis' where item_id = 21094;
Update armor set name = 'Belt of Thebes Osiris' where item_id = 21095;
Update armor set name = 'Golden Box' where item_id = 21096;
Update armor set name = 'Earring of Destiny' where item_id = 21097;
Update armor set name = 'Earring of Rifleman' where item_id = 21098;
Update armor set name = 'Earring of Gladiator' where item_id = 21099;
Update armor set name = 'Earring of the Great Wizard' where item_id = 21100;
Update armor set name = 'Spellbook of Illusionist' where item_id = 21101;
Update armor set name = 'Crystal Guarder' where item_id = 21104;
Update armor set name = 'Wooden Jacket' where item_id = 21107;
Update armor set name = 'T-shirt with %i\'s Mana' where item_id = 21108;
Update armor set unidentified_name_id = 'Amulet of the Royalty' where item_id = 20376;
Update armor set unidentified_name_id = 'Amulet of the Knight' where item_id = 20377;
Update armor set unidentified_name_id = 'Amulet of the Elf' where item_id = 20378;
Update armor set unidentified_name_id = 'Amulet of the Wizard' where item_id = 20379;
Update armor set unidentified_name_id = 'Helm of Illusion' where item_id = 21035;
Update armor set unidentified_name_id = 'T-Shirt of Illusion' where item_id = 21036;
Update armor set unidentified_name_id = 'Shield of Illusion' where item_id = 21037;
Update armor set unidentified_name_id = 'Boots of Illusion' where item_id = 21038;
Update armor set unidentified_name_id = 'Burning Circlet' where item_id = 21039;
Update armor set unidentified_name_id = 'Burning Shield' where item_id = 21040;
Update armor set unidentified_name_id = 'Burning Boots' where item_id = 21041;
Update armor set unidentified_name_id = 'Burning Gloves' where item_id = 21042;
Update armor set unidentified_name_id = 'Talisman of Ironclad' where item_id = 21043;
Update armor set unidentified_name_id = 'Talisman of Jiedi' where item_id = 21044;
Update armor set unidentified_name_id = 'Talisman of Secret Maneuvers' where item_id = 21045;
Update armor set unidentified_name_id = 'Talisman of Mercy' where item_id = 21046;
Update armor set unidentified_name_id = '$1956 $6344' where item_id = 21047;
Update armor set unidentified_name_id = 'T-Shirt of Ghost Man' where item_id = 21061;
Update armor set unidentified_name_id = 'T-Shirt of Ghost Woman' where item_id = 21062;
Update armor set unidentified_name_id = 'Swimwear Men\'s Briefs' where item_id = 21063;
Update armor set unidentified_name_id = 'Swimwear Men\'s Trunks' where item_id = 21064;
Update armor set unidentified_name_id = 'Swimwear Women\'s One Piece' where item_id = 21065;
Update armor set unidentified_name_id = 'Swimwear Women\'s Bikini' where item_id = 21066;
Update armor set unidentified_name_id = '$5256' where item_id = 21108;
Update armor set identified_name_id = 'Amulet of the Royalty' where item_id = 20376;
Update armor set identified_name_id = 'Amulet of the Knight' where item_id = 20377;
Update armor set identified_name_id = 'Amulet of the Elf' where item_id = 20378;
Update armor set identified_name_id = 'Amulet of the Wizard' where item_id = 20379;
Update armor set identified_name_id = 'Helm of Illusion' where item_id = 21035;
Update armor set identified_name_id = 'T-Shirt of Illusion' where item_id = 21036;
Update armor set identified_name_id = 'Shield of Illusion' where item_id = 21037;
Update armor set identified_name_id = 'Boots of Illusion' where item_id = 21038;
Update armor set identified_name_id = 'Burning Circlet' where item_id = 21039;
Update armor set identified_name_id = 'Burning Shield' where item_id = 21040;
Update armor set identified_name_id = 'Burning Boots' where item_id = 21041;
Update armor set identified_name_id = 'Burning Gloves' where item_id = 21042;
Update armor set identified_name_id = 'Talisman of Ironclad' where item_id = 21043;
Update armor set identified_name_id = 'Talisman of Jiedi' where item_id = 21044;
Update armor set identified_name_id = 'Talisman of Secret Maneuvers' where item_id = 21045;
Update armor set identified_name_id = 'Talisman of Mercy' where item_id = 21046;
Update armor set identified_name_id = '$1956 $6344' where item_id = 21047;
Update armor set identified_name_id = 'T-Shirt of Ghost Man' where item_id = 21061;
Update armor set identified_name_id = 'T-Shirt of Ghost Woman' where item_id = 21062;
Update armor set identified_name_id = 'Swimwear Men\'s Briefs' where item_id = 21063;
Update armor set identified_name_id = 'Swimwear Men\'s Trunks' where item_id = 21064;
Update armor set identified_name_id = 'Swimwear Women\'s One Piece' where item_id = 21065;
Update armor set identified_name_id = 'Swimwear Women\'s Bikini' where item_id = 21066;
Update armor set identified_name_id = '$5256' where item_id = 21108;

-- updated some missing dark elementalist spawns
update spawnlist set count = 1 where npc_templateid = 45363;

-- added mermaid ring and drops
insert into armor values (30006,'Mermaid\'s Ring','Mermaid\'s Ring','Mermaid\'s Ring','ring','gold',1000,629,21,0,0,-1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
insert into droplist values (45154,'Mermaid',30006,'Mermaid\'s Ring',1,1,8000);

-- added sarah, benole, arina ring/ammy crafters in heine
update npc set impl = "L1Merchant" where npcid = 70870;
insert into npc values 
(90014,'Benole','Benole','','L1Merchant',1271,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0),
(90015,'Sarah','Sarah','','L1Merchant',706,0,0,0,0,0,0,0,0,0,0,0,0,'',0,0,0,0,0,0,0,0,0,0,0,0,0,0,'',0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,14,0,1,0);
insert into npcaction values 
(90014,'ringq6','','',''),
(90015,'ammymkr','','',''),
(70870,'arina1x','','','');
insert into spawnlist_npc values 
(1900009,'Benole',1,90014,33604,33253,0,0,4,0,4,0),
(1900010,'Sarah',1,90015,33593,33242,0,0,6,0,4,0),
(1900011,'Arina',1,70870,33593,33247,0,0,6,0,4,0);
insert into etcitem values 
(90010,'Lump of Metal','Lump of Metal','Lump of Metal','material','none','iron',400,521,1498,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1);
insert into droplist values 
(45008,'Goblin',90010,'Lump of Metal',1,2,75000),
(45009,'Orc',90010,'Lump of Metal',1,2,75000),
(45016,'Kobold',90010,'Lump of Metal',1,2,75000),
(45017,'Orc',90010,'Lump of Metal',1,2,75000),
(45018,'Orc Archer',90010,'Lump of Metal',1,2,75000),
(45050,'Orc Archer',90010,'Lump of Metal',1,2,75000),
(45140,'Hobgoblin',90010,'Lump of Metal',1,2,75000);
insert into resolvent values 
(90010,'Lump of Metal',2);
insert into armor values 
(30008,'Mermaid`s Necklace','Mermaid`s Necklace','Mermaid`s Necklace','amulet','gemstone',5000,436,3161,0,0,-1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0),
(30002,'Ruby Ring','Ruby Ring','Ruby Ring','ring','iron',1000,628,21,0,0,-1,1,1,1,1,1,1,1,0,0,0,0,0,0,6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0),
(30003,'Sapphire Ring','Sapphire Ring','Sapphire Ring','ring','iron',1000,629,21,0,0,-1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,6,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0),
(30004,'Moonstone Ring','Moonstone Ring','Moonstone Ring','ring','iron',1000,630,21,0,0,-1,1,1,1,1,1,1,1,0,0,0,0,0,0,-4,8,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0),
(30005,'Carnelian Ring','Carnelian Ring','Carnelian Ring','ring','iron',1000,627,21,0,0,-1,1,1,1,1,1,1,1,0,0,0,0,0,0,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0),
(30007,'Amulet','Amulet','Amulet','amulet','gemstone',5000,6,3164,0,0,-1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0);

-- correct a mistake on the mermaid ring previously added
update armor set bless = "1" where item_id = 30006;