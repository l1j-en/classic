
-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED

-- Queries that are pending an update should be placed here. This allows them 
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 47

-- update to spawnlist_boss for missing bosses in giran castle dungeon 4f
INSERT INTO spawnlist_boss VALUES (15,'Count Taros','Oren',1,46025,0,32797,32788,0,0,0,0,0,0,0,251,1,0,0,0,100);
INSERT INTO spawnlist_boss VALUES (20,'Mammon','Oren',1,46026,0,32797,32792,0,0,0,0,0,0,0,251,1,0,0,0,100);

-- Name fix for unknown mobskill list
update mobskill set mobname = 'Doppleganger Boss' where mobid = 45828;
update mobskill set mobname = 'Diamond Golem of Maino Shaman' where mobid = 45801;
update mobskill set mobname = 'Maino Shaman' where mobid = 45802;
update mobskill set mobname = 'Barbados' where mobid = 45829;
update mobskill set mobname = 'Mutant Lizardman' where mobid = 45874;
update mobskill set mobname = 'Polluted Orc Warrior' where mobid = 45772;
update mobskill set mobname = 'Mambo Rabbit (Pink Vest)' where mobid = 45534;
update mobskill set mobname = 'Mambo Rabbit (Orange Vest)' where mobid = 45535;

-- Temp Aggro fix for Chaos due to karma hunting safety
update npc set agro = 0 where npcid = 45625;
update npc set agrososc = 0 where npcid = 45625;

-- Name fix for NPC
update npc set name = 'Doppleganger Boss' where npcid = 45828;
update npc set name = 'Captain Drake' where npcid = 45458;

-- Note fix for Forgotten Island Mobs
update npc set note = 'Forgotten Island' where npcid = 45505;

-- Note fix for npcchat
update npcchat set note = 'Baphomet' where npc_id = 45573;

-- Update name fix for mismarked wooden shield
update armor set name = "Small Shield" where item_id = 20239;

-- Update incorrect name for polymorph
update polymorphs set name = 'Death Knight 52' where id = 6137;

-- update description mob id 45239 for Blue Tail
update skills set name = 'Blue Tail\'s Laser Attack' where skill_id = 10046;

-- Name corrections to area
update area set areaname = 'Count Taros\' Throne Room' where areaid = 350;
update area set areaname = '1F Evil Power King\'s Office' where areaid = 300;
update area set areaname = '2F Evil Spirit King\'s Library' where areaid = 308;
update area set areaname = '2F Evil Spirit King\'s Office' where areaid = 307;
update area set areaname = '3F Bright Magic King\'s Office' where areaid = 319;
update area set areaname = '4F Gran Kain\'s Temple' where areaid = 360;
update area set areaname = '4F Barome\'s Office' where areaid = 361;
update area set areaname = '4F Edea\'s Office' where areaid = 362;
update area set areaname = '4F Barode\'s Office' where areaid = 363;
update area set areaname = '4F Cassandra\'s Office' where areaid = 364;
update area set areaname = 'Aden Castle Basement 1F Path of the Dead' where areaid = 356;
update area set areaname = 'Aden Castle Basement 2F Grave of the Dead' where areaid = 357;
update area set areaname = 'Aden Castle Basement 3F Path of the Dead' where areaid = 358;
update area set areaname = 'Assassin King\'s Office' where areaid = 325;
update area set areaname = 'Franco\'s Labyrinth' where areaid = 333;
update area set areaname = 'Gunter\'s House' where areaid = 4;
update area set areaname = 'Hardin\'s Laboratory' where areaid = 16;
update area set areaname = 'Jim\'s Dungeon' where areaid = 216;
update area set areaname = 'Kamyla\'s Room' where areaid = 331;
update area set areaname = 'Nerupa\'s Cave' where areaid = 17;
update area set areaname = 'Pago\'s Room' where areaid = 81;
update area set areaname = 'Pirate\'s Isle' where areaid = 330;
update area set areaname = 'Yahee\'s Laboratory' where areaid = 383;
update area set areaname = 'Doromond\'s Room' where areaid = 342;
update area set areaname = 'Ant Caves 8F' where areaid = 37;
update area set areaname = 'Ant Caves 6F' where areaid = 38;
update area set areaname = 'Ant Caves 2F' where areaid = 39;
update area set areaname = 'Ant Caves 3F' where areaid = 40;
update area set areaname = 'Ant Caves 1F' where areaid = 41;
update area set areaname = 'Ant Caves 4F' where areaid = 42;
update area set areaname = 'Ant Caves 5F' where areaid = 43;
update area set areaname = 'Ant Caves 7F' where areaid = 44;
update area set areaname = 'Ant Caves 9F' where areaid = 45;
update area set areaname = 'Varlok\'s Lair' where areaid = 378;
update area set areaname = 'Varlok\'s Room' where areaid = 377;
update area set areaname = 'Duplegenon\'s Quarters' where areaid = 18;
update area set areaname = 'Deep Sea Floor' where areaid = 374;
update area set areaname = 'Heine Basement Prison' where areaid = 351;
update area set areaname = 'Kingdom of Eva' where areaid = 352;
update area set areaname = 'Barbados\' Hideout' where areaid = 353;
update area set areaname = 'Underground Jail of Jose' where areaid = 335;
update area set areaname = 'Basement Control Room' where areaid = 326;
update area set areaname = 'Basement Battle Arena' where areaid = 328;
update area set areaname = 'Basement Prison' where areaid = 329;
update area set areaname = 'Basement Passageway' where areaid = 324;
update area set areaname = 'Basement Execution Room' where areaid = 327;
update area set areaname = 'Basement Training Room' where areaid = 323;
update area set areaname = 'Windawood Castle Dungeon 2F' where areaid = 24;
update area set areaname = 'Windawood Castle Dungeon 1F' where areaid = 23;

-- Update Note descriptions for Armor Sets
update armor_set set note = 'Demon Set - Demon' where id = 1;
update armor_set set note = 'Death Knight Set - Death Knight' where id = 2;
update armor_set set note = 'Pretender King Set - Ken Rahuel' where id = 3;
update armor_set set note = 'Kurtz Set - Kurtz' where id = 4;
update armor_set set note = 'Cerenis Set - Cerenis' where id = 5;
update armor_set set note = 'Pumpkin Set - Jack-O-Lantern' where id = 6;
update armor_set set note = 'Cloak of Vampire - Vampire' where id = 7;
update armor_set set note = 'Cloak of Sashin - Death' where id = 8;
update armor_set set note = 'Easter Bunny Hat - Pink Vest Mambo' where id = 9;
update armor_set set note = 'Easter Bunny Hat w/Carrot - Orange Vest Mambo' where id = 10;
update armor_set set note = 'Left-Hand Ring of Dopple Boss - Skeleton' where id = 11;
update armor_set set note = 'Right-Hand Ring of Dopple Boss - Orc Fighter' where id = 12;
update armor_set set note = 'Necklace of Doppleganger Boss - Werewolf' where id = 13;
update armor_set set note = 'High Collie Choker - High Collie' where id = 14;
update armor_set set note = 'High Racoon Choker - High Raccoon' where id = 15;
update armor_set set note = 'Hakama - Blue Hakama' where id = 16;
update armor_set set note = 'Holiday Attire - Orange Haregi' where id = 17;
update armor_set set note = 'Amulet of Beagle - Beagle' where id = 18;
update armor_set set note = 'Amulet of Snow Man - Snowman' where id = 19;
update armor_set set note = 'Carrot and Stocking - Snowman' where id = 20;
update armor_set set note = 'Lucky Cat Scarf - Manekineko Cat' where id = 21;
update armor_set set note = 'Red Mask - Red Orc' where id = 22;
update armor_set set note = 'Drake Captain Transformation Turban' where id = 23;
update armor_set set note = 'Iris Transformation Turban' where id = 24;
update armor_set set note = 'Knight Vald Transformation Turban' where id = 25;
update armor_set set note = 'Succubus Queen Transformation Turban' where id = 26;
update armor_set set note = 'Red Soccer Uniform - Red Soccer Player' where id = 27;
update armor_set set note = 'Blue Soccer Uniform - blue Soccer Player' where id = 28;
update armor_set set note = 'Red Orc Mask - Red Orc' where id = 29;
update armor_set set note = 'Helmet for Horse Riding  - Mounted Royal' where id = 30;
update armor_set set note = 'Halloween Blessing Cap - Jack-O-Lantern' where id = 31;
update armor_set set note = 'High Bear Necklace - High Bear' where id = 32;
update armor_set set note = 'Leather Set' where id = 33;
update armor_set set note = 'Orcish Fighter Set - Orc Fighter' where id = 34;
update armor_set set note = 'Dwarf Set - Dwarf' where id = 35;
update armor_set set note = 'Studded Leather Set' where id = 36;
update armor_set set note = 'Bone Set' where id = 37;
update armor_set set note = 'Elven Named Set' where id = 38;
update armor_set set note = 'Mage Set' where id = 39;
update armor_set set note = 'Iron Set' where id = 40;
update armor_set set note = 'Blue Pirate Set' where id = 41;
update armor_set set note = 'Yahee Set' where id = 42;
update armor_set set note = 'Arcane King Set' where id = 43;
update armor_set set note = 'Fidelity Set' where id = 44;
update armor_set set note = 'Wet Set' where id = 45;
update armor_set set note = 'Hope Set' where id = 46;
update armor_set set note = 'Luck Set' where id = 47;
update armor_set set note = 'Passion Set' where id = 48;
update armor_set set note = 'Truth Set' where id = 49;
update armor_set set note = 'Miracle Set' where id = 50;
update armor_set set note = 'Affection Set' where id = 51;
update armor_set set note = 'Red Curse Set' where id = 52;
update armor_set set note = 'Blue Curse Set' where id = 53;
update armor_set set note = 'Green Curse Set' where id = 54;
update armor_set set note = 'Red Knight Set' where id = 55;

-- Update missing polymorph values for orc fighter and dwarf sets
update armor_set set polyid = 3864 where id = 34;
update armor_set set polyid = 3863 where id = 35;

-- update misnamed quest item: Money Pouch of Reona
update etcitem set name = 'Ring of Resta' where item_id = 40631;

-- Fix for -bug # - Submitted by Cronicx
update npc set change_head = 1 where npcid_id = 45215;

-- Update to mobskills, thanks to Cronicx for research and testing, formatting and error control by Zylia
INSERT INTO mobskill VALUES (45359,0,'Astagio',1,50,0,0,-3,0,0,1,0,0,9,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45572,1,'Astagio of Fire',1,50,0,0,-3,0,0,1,0,0,26,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45572,0,'Astagio of Fire',1,50,0,0,-1,0,0,1,0,0,30,0,0,0,0,0,0,0);
INSERT INTO mobskill VALUES (45473,0,'Baltuzar',2,20,0,0,-6,0,0,0,0,0,14,45,0,0,0,0,0,0);
INSERT INTO mobskill VALUES (45381,0,'Basilisk',2,50,0,0,-3,0,0,15,0,0,10,10015,0,18,0,0,0,0);
INSERT INTO mobskill VALUES (45165,0,'Black Knight',1,50,0,0,-3,0,0,1,0,0,9,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45239,0,'Blue Tail',1,50,0,0,-3,0,0,1,0,0,11,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45223,0,'Bugbear',1,50,0,0,-3,0,0,1,0,0,8,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45738,0,'Bugbear',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45407,0,'Cimaera',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45806,1,'Crabman',1,50,0,0,-3,0,0,1,0,0,9,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45519,1,'Cruel Snow Tiger',1,50,0,0,-3,0,0,1,0,0,27,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45506,1,'Cursed Elmore Wizard',1,50,0,0,-3,0,0,1,0,0,12,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45420,0,'Cyclops',1,0,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45386,0,'Dancing Sword',1,50,0,0,-3,0,0,2,0,0,11,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45288,0,'Dark Elf General',1,50,0,0,-3,0,0,1,0,0,9,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45287,0,'Dark Elf Guard',1,50,0,0,-3,0,0,1,0,0,9,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45485,1,'Dark Lycanthrope',1,50,0,0,-3,0,0,1,0,0,11,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45409,0,'Dire Wolf',1,50,0,0,-3,0,0,1,0,0,11,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45257,0,'Dragonfly',1,50,0,0,-3,0,0,1,0,0,8,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45035,0,'Escaped Black Knight',1,50,0,0,-3,0,0,1,0,0,3,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45373,1,'Ettin',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45519,0,'Fire Ghost',1,50,0,0,-3,0,0,1,0,0,12,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45284,1,'Fire Warrior',1,50,0,0,-3,0,0,2,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45509,0,'Forgotten Island King Bugbear',1,50,0,0,-3,0,0,1,0,0,12,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45392,0,'Forgotten Island Bugbear',1,50,0,0,-3,0,0,0,0,0,11,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45505,1,'Forgotten Island Ettin',1,50,0,0,-3,0,0,1,0,0,13,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45452,0,'Forgotten Island Harpy',2,50,0,0,-3,0,0,1,0,0,10,10,0,18,0,0,0,0);
INSERT INTO mobskill VALUES (45387,0,'Forgotten Island Ramia',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45174,0,'Ghost',1,50,0,0,0,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45198,0,'Ghost',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45295,0,'Giant',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45079,0,'Gnoll',1,50,0,0,-3,0,0,1,0,0,5,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45321,0,'Griffon',1,50,0,0,-3,0,0,1,0,0,8,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45445,0,'Griffon',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45140,0,'Hobgoblin',1,50,0,0,-3,0,0,1,0,0,5,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45479,0,'Horrific Iron Golem',1,50,0,0,-3,0,0,1,0,0,12,0,30,0,0,0,0,0);
INSERT INTO mobskill VALUES (45556,0,'Ice Man',1,50,0,0,-3,0,0,1,0,0,13,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45372,0,'Iron Golem',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45298,0,'King Bugbear',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45600,2,'Kurtz',1,50,0,0,-3,0,0,1,0,0,30,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45365,0,'Lava Golem',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45377,0,'Lizardman',1,50,0,0,-3,0,0,1,0,0,9,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45805,0,'LizardMan',1,50,0,0,-3,0,0,1,0,0,7,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45144,0,'Lizardman',1,50,0,0,-3,0,0,1,0,0,7,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45145,0,'Lizardman',1,50,0,0,-3,0,0,1,0,0,7,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45380,0,'Medusa',1,50,0,0,-3,0,0,1,0,0,10,0,0,18,0,0,0,0);
INSERT INTO mobskill VALUES (45390,0,'Minotaur',1,50,0,0,-3,0,0,1,0,0,11,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45332,0,'Mutant Ramia',1,50,0,0,-3,0,0,1,0,0,9,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45815,0,'Mutant Ramia',1,50,0,0,-3,0,0,1,0,0,17,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45385,0,'Nightmare',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45440,0,'Nightmare',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45759,0,'Orc Fighter',1,50,0,0,-3,0,0,1,0,0,5,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45402,0,'Raging Skeleton Axeman',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (81088,0,'Raging Skeleton Fighter',1,50,0,0,-3,0,0,1,0,0,8,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45403,0,'Raging Skeleton Pike',1,50,0,0,-3,0,0,2,0,0,11,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45809,0,'Ratman',1,50,0,0,-3,0,0,1,0,0,9,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45369,0,'Salamander',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45552,0,'Salamander',1,50,0,0,-3,0,0,1,0,0,12,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45259,0,'Scorpion',1,50,0,0,-3,0,0,1,0,0,8,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45130,0,'Skeleton Axeman',1,50,0,0,-3,0,0,1,0,0,6,0,0,18,0,0,0,0);
INSERT INTO mobskill VALUES (45286,0,'Skeleton Fighter',1,50,0,0,-3,0,0,1,0,0,9,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45267,0,'Snow Tiger',1,50,0,0,-3,0,0,1,0,0,11,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45133,0,'Snowman',1,50,0,0,-3,0,0,1,0,0,5,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45297,0,'Subterrean Crabman',1,50,0,0,-3,0,0,1,0,0,8,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45155,0,'Troglodyte',1,50,0,0,-3,0,0,1,0,0,8,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45280,0,'Troll',1,50,0,0,-3,0,0,1,0,0,8,0,0,18,0,0,0,0);
INSERT INTO mobskill VALUES (45248,0,'Undead Elmore General',1,50,0,0,-3,0,0,1,0,0,12,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45216,0,'Undead Elmore Soldier',1,50,0,0,-3,0,0,2,0,0,9,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45224,1,'Undead Elmore Wizard',1,50,0,0,-3,0,0,1,0,0,11,0,0,30,0,0,0,0);
INSERT INTO mobskill VALUES (45294,0,'Yeti',1,50,0,0,-3,0,0,1,0,0,10,0,0,30,0,0,0,0);
