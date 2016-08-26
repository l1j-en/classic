-- Migrate old tables still using MyISAM
ALTER TABLE accounts ENGINE='InnoDB';
ALTER TABLE area ENGINE='InnoDB';
ALTER TABLE armor ENGINE='InnoDB';
ALTER TABLE armor_set ENGINE='InnoDB';
ALTER TABLE ban_ip ENGINE='InnoDB';
ALTER TABLE beginner ENGINE='InnoDB';
ALTER TABLE board ENGINE='InnoDB';
ALTER TABLE board_auction ENGINE='InnoDB';
ALTER TABLE castle ENGINE='InnoDB';
ALTER TABLE character_buddys ENGINE='InnoDB';
ALTER TABLE character_buff ENGINE='InnoDB';
ALTER TABLE character_config ENGINE='InnoDB';
ALTER TABLE character_elf_warehouse ENGINE='InnoDB';
ALTER TABLE character_excludes ENGINE='InnoDB';
ALTER TABLE character_items ENGINE='InnoDB';
ALTER TABLE character_pvp ENGINE='InnoDB';
ALTER TABLE character_quests ENGINE='InnoDB';
ALTER TABLE character_skills ENGINE='InnoDB';
ALTER TABLE character_teleport ENGINE='InnoDB';
ALTER TABLE character_warehouse ENGINE='InnoDB';
ALTER TABLE characters ENGINE='InnoDB';
ALTER TABLE clan_data ENGINE='InnoDB';
ALTER TABLE clan_warehouse ENGINE='InnoDB';
ALTER TABLE commands ENGINE='InnoDB';
ALTER TABLE connection_test_table ENGINE='InnoDB';
ALTER TABLE door_gfxs ENGINE='InnoDB';
ALTER TABLE drop_item ENGINE='InnoDB';
ALTER TABLE droplist ENGINE='InnoDB';
ALTER TABLE dungeon ENGINE='InnoDB';
ALTER TABLE dungeon_random ENGINE='InnoDB';
ALTER TABLE etcitem ENGINE='InnoDB';
ALTER TABLE getback ENGINE='InnoDB';
ALTER TABLE getback_restart ENGINE='InnoDB';
ALTER TABLE house ENGINE='InnoDB';
ALTER TABLE inn ENGINE='InnoDB';
ALTER TABLE inn_key ENGINE='InnoDB';
ALTER TABLE letter ENGINE='InnoDB';
ALTER TABLE log_chat ENGINE='InnoDB';
ALTER TABLE log_enchant ENGINE='InnoDB';
ALTER TABLE mail ENGINE='InnoDB';
ALTER TABLE mapids ENGINE='InnoDB';
ALTER TABLE mobgroup ENGINE='InnoDB';
ALTER TABLE mobskill ENGINE='InnoDB';
ALTER TABLE npc ENGINE='InnoDB';
ALTER TABLE npcaction ENGINE='InnoDB';
ALTER TABLE npcchat ENGINE='InnoDB';
ALTER TABLE petitem ENGINE='InnoDB';
ALTER TABLE pets ENGINE='InnoDB';
ALTER TABLE pettypes ENGINE='InnoDB';
ALTER TABLE polymorphs ENGINE='InnoDB';
ALTER TABLE quest_drops ENGINE='InnoDB';
ALTER TABLE resolvent ENGINE='InnoDB';
ALTER TABLE shop ENGINE='InnoDB';
ALTER TABLE skills ENGINE='InnoDB';
ALTER TABLE spawnlist ENGINE='InnoDB';
ALTER TABLE spawnlist_boss ENGINE='InnoDB';
ALTER TABLE spawnlist_door ENGINE='InnoDB';
ALTER TABLE spawnlist_furniture ENGINE='InnoDB';
ALTER TABLE spawnlist_light ENGINE='InnoDB';
ALTER TABLE spawnlist_npc ENGINE='InnoDB';
ALTER TABLE spawnlist_time ENGINE='InnoDB';
ALTER TABLE spawnlist_trap ENGINE='InnoDB';
ALTER TABLE spawnlist_ub ENGINE='InnoDB';
ALTER TABLE spr_action ENGINE='InnoDB';
ALTER TABLE town ENGINE='InnoDB';
ALTER TABLE trap ENGINE='InnoDB';
ALTER TABLE ub_managers ENGINE='InnoDB';
ALTER TABLE ub_settings ENGINE='InnoDB';
ALTER TABLE ub_times ENGINE='InnoDB';
ALTER TABLE weapon ENGINE='InnoDB';
ALTER TABLE weapon_skill ENGINE='InnoDB';

-- Make stackable Beast Tamer Ring.
update etcitem set stackable = 1 where item_id = 40454;

-- Make stackable Elementalist Ring.
update etcitem set stackable = 1 where item_id = 40465;

-- Make stackable Old Trading Document.
update etcitem set stackable = 1 where item_id = 40540;

-- Set fishing poles to be undeleteable.
update etcitem set cant_delete = 1 where item_id in (41293, 41294);

-- Fix missing mobskills Beleth
Insert into mobskill values
(45573,1,'Baphomet','Summon Skeleton',3,7,0,0,-3,3,0,0,0,0,0,0,0,18,45107,2,6,0),
(45583,1,'Beleth','Summon Cerberus',3,7,0,0,-3,3,0,0,0,0,0,0,0,18,45241,2,4,0);

-- Remove incorrect drops from droplist
delete from droplist where mobid = 45570 and itemid = 40013;
delete from droplist where mobid = 45570 and itemid = 40018;
delete from droplist where mobid = 45570 and itemid = 40225;
delete from droplist where mobid = 45570 and itemid = 40308;
delete from droplist where mobid = 45570 and itemid = 40619;
delete from droplist where mobid = 45570 and itemid = 140100;
delete from droplist where mobid = 45582 and itemid = 40013;
delete from droplist where mobid = 45582 and itemid = 40018;
delete from droplist where mobid = 45582 and itemid = 40216;
delete from droplist where mobid = 45582 and itemid = 40225;
delete from droplist where mobid = 45582 and itemid = 40251;
delete from droplist where mobid = 45582 and itemid = 40255;
delete from droplist where mobid = 45582 and itemid = 40308;
delete from droplist where mobid = 45582 and itemid = 40649; -- north-east jail key
delete from droplist where mobid = 45582 and itemid = 40650; -- north jail key
delete from droplist where mobid = 45582 and itemid = 140100;
delete from droplist where mobid = 45605 and itemid = 40013;
delete from droplist where mobid = 45605 and itemid = 40018;
delete from droplist where mobid = 45605 and itemid = 40089;
delete from droplist where mobid = 45605 and itemid = 40216;
delete from droplist where mobid = 45605 and itemid = 40225;
delete from droplist where mobid = 45605 and itemid = 45251;
delete from droplist where mobid = 45605 and itemid = 45255;
delete from droplist where mobid = 45605 and itemid = 40308;
delete from droplist where mobid = 45605 and itemid = 40650;
delete from droplist where mobid = 45605 and itemid = 140100;
delete from droplist where mobid = 45587 and itemid = 40013;
delete from droplist where mobid = 45587 and itemid = 40018;
delete from droplist where mobid = 45587 and itemid = 40089;
delete from droplist where mobid = 45587 and itemid = 40216;
delete from droplist where mobid = 45587 and itemid = 40225;
delete from droplist where mobid = 45587 and itemid = 40251;
delete from droplist where mobid = 45587 and itemid = 40255;
delete from droplist where mobid = 45587 and itemid = 40308;
delete from droplist where mobid = 45587 and itemid = 40649;
delete from droplist where mobid = 45587 and itemid = 140100;
delete from droplist where mobid = 45685 and itemid = 40619; --	East Jail Key
delete from droplist where mobid = 45685 and itemid = 40649;
delete from droplist where mobid = 45685 and itemid = 40650;

-- update corrections for NPC names
update npc set name = 'Summoned Stuff of Maya (Skeleton Knight)' where npcid = 46038;
update npc set name = 'Priest of Chaos (Flying Spearman)' where npcid = 45576;
update npc set name = 'Priest of Chaos (Calvary)' where npcid = 45599;
update npc set name = 'Priest of Chaos (Spearman)' where npcid = 45353;
update npc set name = 'Priest of Chaos (Flying Spearman)' where npcid = 45626;
update npc set name = 'Priest of Chaos (Calvary)' where npcid = 45627;
update npc set name = 'Priest of Chaos (Spearman)' where npcid = 45226;
update npc set name = 'Priest of Chaos (Spearman)' where npcid = 45227;
update npc set name = 'Priest of Chaos (Spearman)' where npcid = 45231;
update npc set name = 'Priest of Chaos (Spearman)' where npcid = 45490;
update npc set name = 'Priest of Chaos (Spearman)' where npcid = 45543;
update npc set name = 'Priest of Corruption (Flame Frog)' where npcid = 45570;
update npc set name = 'Priest of Corruption (Assassin)' where npcid = 45571;
update npc set name = 'Priest of Corruption (Butcher)' where npcid = 45582;
update npc set name = 'Priest of Corruption (Poison Beast)' where npcid = 45587;
update npc set name = 'Priest of Corruption (Three-Headed Demon)' where npcid = 45605;
update npc set name = 'Priest of Corruption (Assassin)' where npcid = 70972;
update npc set name = 'Priest of Death (Fallen Lesser Demon)' where npcid = 45536;
update npc set name = 'Priest of Death (Fallen Demon)' where npcid = 45542;
update npc set name = 'Disciple of Death (Fallen Succubus)' where npcid = 45575;
update npc set name = 'Disciple of Death (Fallen Baphomet)' where npcid = 45597;
update npc set name = 'Disciple of Death (Fallen Beleth)' where npcid = 45598;
update npc set name = 'Disciple of Death (Dual-Bladed Horror)' where npcid = 45507;
update npc set name = 'Shade Elemental' where npcid = 45310;

-- update corrections for NPC names
update spawnlist set location = 'Summoned Stuff of Maya (Skeleton Knight)' where npc_templateid = 46038;
update spawnlist set location = 'Priest of Chaos (Flying Spearman)' where npc_templateid = 45576;
update spawnlist set location = 'Priest of Chaos (Calvary)' where npc_templateid = 45599;
update spawnlist set location = 'Priest of Chaos (Spearman)' where npc_templateid = 45353;
update spawnlist set location = 'Priest of Chaos (Flying Spearman)' where npc_templateid = 45626;
update spawnlist set location = 'Priest of Chaos (Calvary)' where npc_templateid = 45627;
update spawnlist set location = 'Priest of Chaos (Spearman)' where npc_templateid = 45226;
update spawnlist set location = 'Priest of Chaos (Spearman)' where npc_templateid = 45227;
update spawnlist set location = 'Priest of Chaos (Spearman)' where npc_templateid = 45231;
update spawnlist set location = 'Priest of Chaos (Spearman)' where npc_templateid = 45490;
update spawnlist set location = 'Priest of Chaos (Spearman)' where npc_templateid = 45543;
update spawnlist set location = 'Priest of Corruption (Flame Frog)' where npc_templateid = 45570;
update spawnlist set location = 'Priest of Corruption (Assassin)' where npc_templateid = 45571;
update spawnlist set location = 'Priest of Corruption (Butcher)' where npc_templateid = 45582;
update spawnlist set location = 'Priest of Corruption (Poison Beast)' where npc_templateid = 45587;
update spawnlist set location = 'Priest of Corruption (Three-Headed Demon)' where npc_templateid = 45605;
update spawnlist set location = 'Priest of Corruption (Assassin)' where npc_templateid = 70972;
update spawnlist set location = 'Priest of Death (Fallen Lesser Demon)' where npc_templateid = 45536;
update spawnlist set location = 'Priest of Death (Fallen Demon)' where npc_templateid = 45542;
update spawnlist set location = 'Disciple of Death (Fallen Succubus)' where npc_templateid = 45575;
update spawnlist set location = 'Disciple of Death (Fallen Baphomet)' where npc_templateid = 45597;
update spawnlist set location = 'Disciple of Death (Fallen Beleth)' where npc_templateid = 45598;
update spawnlist set location = 'Disciple of Death (Dual-Bladed Horror)' where npc_templateid = 45507;
update spawnlist set location = 'Shade Elemental' where npc_templateid = 45310;

-- Name corrections for npc's in droplist
update droplist set mob_name = 'Priest of Chaos (Flying Spearman)' where mobId = 45576;
update droplist set mob_name = 'Priest of Chaos (Calvary)' where mobId = 45599;
update droplist set mob_name = 'Priest of Chaos (Flying Spearman)' where mobId = 45626;
update droplist set mob_name = 'Priest of Chaos (Spearman)' where mobId = 45226;
update droplist set mob_name = 'Priest of Chaos (Spearman)' where mobId = 45227;
update droplist set mob_name = 'Priest of Chaos (Spearman)' where mobId = 45231;
update droplist set mob_name = 'Priest of Chaos (Spearman)' where mobId = 45543;
update droplist set mob_name = 'Priest of Corruption (Flame Frog)' where mobId = 45570;
update droplist set mob_name = 'Priest of Corruption (Assassin)' where mobId = 45571;
update droplist set mob_name = 'Priest of Corruption (Butcher)' where mobId = 45582;
update droplist set mob_name = 'Priest of Corruption (Poison Beast)' where mobId = 45587;
update droplist set mob_name = 'Priest of Corruption (Three-Headed Demon)' where mobId = 45605;
update droplist set mob_name = 'Priest of Death (Fallen Lesser Demon)' where mobId = 45536;
update droplist set mob_name = 'Priest of Death (Fallen Demon)' where mobId = 45542;
update droplist set mob_name = 'Disciple of Death (Fallen Succubus)' where mobId = 45575;
update droplist set mob_name = 'Disciple of Death (Fallen Baphomet)' where mobId = 45597;
update droplist set mob_name = 'Disciple of Death (Fallen Beleth)' where mobId = 45598;
update droplist set mob_name = 'Disciple of Death (Dual-Bladed Horror)' where mobId = 45507;
update droplist set mob_name = 'Shade Elemental' where mobId = 45310;

update mobskill set Skill_Description = 'Summon Skeleton Knight of Maya' where mobid = 46037 and actNo = 5;
update mobskill set Skill_Description = 'Summon Eva Shark' where mobid = 45931 and actNo = 1;
update mobskill set Skill_Description = 'Summon Dark Elemental' where mobid = 45363 and actNo = 1;
update mobskill set Skill_Description = 'Summon Dark Elemental' where mobid = 45907 and actNo = 1;
update mobskill set Skill_Description = 'Summon Servant of Spirit' where mobid = 45795 and actNo = 1;
update mobskill set Skill_Description = 'Summon Polluted Spirit\'s Dirty Sycophant' where mobid = 45783 and actNo = 1;
update mobskill set Skill_Description = 'Summon Polluted Orc Wizard' where mobid = 45772 and actNo = 0;
update mobskill set Skill_Description = 'Summon Dark Elemental' where mobid = 45723 and actNo = 0;
update mobskill set Skill_Description = 'Summon Dark Elemental' where mobid = 46053 and actNo = 0;
update mobskill set Skill_Description = 'Summon Priest of Chaos (Calvary)' where mobid = 45625 and actNo = 6;
update mobskill set Skill_Description = 'Summon Priest of Death (Fallen Demon)' where mobid = 45685 and actNo = 6;
update mobskill set Skill_Description = 'Summon Disciple of Death (Fallen Beleth)' where mobid = 45674 and actNo = 7;
update mobskill set Skill_Description = 'Summon Disciple of Death (Fallen Baphomet)' where mobid = 45674 and actNo = 6;
update mobskill set Skill_Description = 'Summon Priest of Corruption (Poison Beast)' where mobid = 45685 and actNo = 5;
update mobskill set Skill_Description = 'Summon Priest of Corruption (Butcher)' where mobid = 45685 and actNo = 4;
update mobskill set Skill_Description = 'Summon Priest of Chaos (Flying Spearman)' where mobid = 45625 and actNo = 5;
update mobskill set Skill_Description = 'Summon Disciple of Death (Fallen Succubus)' where mobid = 45674 and actNo = 5;
update mobskill set Skill_Description = 'Summon Priest of Corruption (Assassin)' where mobid = 45685 and actNo = 3;
update mobskill set Skill_Description = 'Summon Priest of Corruption (Flame Frog)' where mobid = 45685 and actNo = 2;
update mobskill set Skill_Description = 'Summon Priest of Death (Fallen Lesser Demon)' where mobid = 45674 and actNo = 3;
update mobskill set Skill_Description = 'Summon Lord of Darkness' where mobid = 45676 and actNo = 1;
update mobskill set Skill_Description = 'Summon Spiritologist of Blood' where mobid = 45676 and actNo = 0;
update mobskill set Skill_Description = 'Summon Hell Bound' where mobid = 45961 and actNo = 2;
update mobskill set Skill_Description = 'Summon Black Knight of Darkness' where mobid = 45618 and actNo = 2;
update mobskill set Skill_Description = 'Summon Raging Skeleton Marksman' where mobid = 45606 and actNo = 0;
update mobskill set Skill_Description = 'Summon Raging Skeleton Fighter' where mobid = 45606 and actNo = 1;
update mobskill set Skill_Description = 'Summon Black Tiger' where mobid = 45651 and actNo = 1;
update mobskill set Skill_Description = 'Summon Black Tiger' where mobid = 45961 and actNo = 1;
update mobskill set Skill_Description = 'Summon Raging Spartoi' where mobid = 45606 and actNo = 2;
update mobskill set Skill_Description = 'Summon Cyclops' where mobid = 45649 and actNo = 8;
update mobskill set Skill_Description = 'Summon Ettin' where mobid = 45649 and actNo = 7;
update mobskill set Skill_Description = 'Summon Iron Golem' where mobid = 45649 and actNo = 5;
update mobskill set Skill_Description = 'Summon Lava Golem' where mobid = 45649 and actNo = 4;
update mobskill set Skill_Description = 'Summon Giant - Light' where mobid = 45316 and actNo = 3;
update mobskill set Skill_Description = 'Summon Taurverus' where mobid = 45649 and actNo = 6;
update mobskill set Skill_Description = 'Summon Shade Elemental' where mobid = 45677 and actNo = 2;
update mobskill set Skill_Description = 'Summon Bats' where mobid = 45606 and actNo = 5;
update mobskill set Skill_Description = 'Summon Skeleton Marksman' where mobid = 45649 and actNo = 3;
update mobskill set Skill_Description = 'Summon Priest of Chaos (Spearman)' where mobid = 45625 and actNo = 4;
update mobskill set Skill_Description = 'Summon Ghost - Red' where mobid = 45649 and actNo = 2;
update mobskill set Skill_Description = 'Summon Spartoi' where mobid = 45601 and actNo = 2;

-- Fix missing drops from ToS Mobs
Insert into droplist values
(45353,'Priest of Chaos (Spearman)',40015,'Potion of Mana',1,1,50000),
(45353,'Priest of Chaos (Spearman)',40014,'Potion of Bravery',1,1,50000),
(45353,'Priest of Chaos (Spearman)',40524,'Black Blood Stone',1,1,30000),
(45353,'Priest of Chaos (Spearman)',40444,'Black Lump of Rough Mithril',1,1,50000),
(45353,'Priest of Chaos (Spearman)',40443,'Black Lump of Pure Mithril',1,1,10000),
(45353,'Priest of Chaos (Spearman)',40678,'Fragment of Soul Stone',1,1,70000),
(45627,'Priest of Chaos (Calvary)',40015,'Potion of Mana',1,1,50000),
(45627,'Priest of Chaos (Calvary)',40014,'Potion of Bravery',1,1,50000),
(45627,'Priest of Chaos (Calvary)',40524,'Black Blood Stone',1,1,30000),
(45627,'Priest of Chaos (Calvary)',40444,'Black Lump of Rough Mithril',1,1,50000),
(45627,'Priest of Chaos (Calvary)',40443,'Black Lump of Pure Mithril',1,1,10000),
(45627,'Priest of Chaos (Calvary)',40678,'Fragment of Soul Stone',1,1,70000),
(45490,'Priest of Chaos (Spearman)',40015,'Potion of Mana',1,1,50000),
(45490,'Priest of Chaos (Spearman)',40014,'Potion of Bravery',1,1,50000),
(45490,'Priest of Chaos (Spearman)',40524,'Black Blood Stone',1,1,30000),
(45490,'Priest of Chaos (Spearman)',40444,'Black Lump of Rough Mithril',1,1,50000),
(45490,'Priest of Chaos (Spearman)',40443,'Black Lump of Pure Mithril',1,1,10000),
(45490,'Priest of Chaos (Spearman)',40678,'Fragment of Soul Stone',1,1,70000),
(70972,'Priest of Corruption (Assassin)',40015,'Potion of Mana',1,1,50000),
(70972,'Priest of Corruption (Assassin)',40014,'Potion of Bravery',1,1,50000),
(70972,'Priest of Corruption (Assassin)',40524,'Black Blood Stone',1,1,30000),
(70972,'Priest of Corruption (Assassin)',40477,'Tarak\'s Devil Book Volume 1',1,1,10000),
(70972,'Priest of Corruption (Assassin)',40478,'Tarak\'s Devil Book Volume 2',1,1,10000),
(70972,'Priest of Corruption (Assassin)',40479,'Tarak\'s Devil Book Volume 3',1,1,10000),
(70972,'Priest of Corruption (Assassin)',40480,'Tarak\'s Devil Book Volume 4',1,1,10000),
(70972,'Priest of Corruption (Assassin)',40444,'Black Lump of Rough Mithril',1,1,50000),
(70972,'Priest of Corruption (Assassin)',40443,'Black Lump of Pure Mithril',1,1,10000),
(70972,'Priest of Corruption (Assassin)',40678,'Fragment of Soul Stone',1,1,70000),
(45685,'Tarak',49114,'Dragon Tablet(HorrorOfDeath)',1,1,1000);

-- Update Great Sword of Destruction
update weapon set add_hp = 3 where item_id = 262;

-- reduce spawns in Cave of Desire
update spawnlist set count = 18 where id = 60000001; -- reduce Lesser Demon at Cave of Desire Outland
update spawnlist set count = 35 where id = 60100001; -- reduce Lesser Demon at Cave of Desire Lobby

-- update incorrect hit range for specific weapons, values incorrectly set to 0
update weapon set `range` = 1 where item_id in (450000, 450001, 450002, 450003, 450004, 450005);

-- GMino should not drop a spear item (unknown spear), remove from droplist and add to shop buyback so players can offload
delete from droplist where itemid = 87;
insert into shop values
(70039,'Werner',87,'Unknown Spear',0,0,0,10000), -- Giran Shop
(70061,'Mandra',87,'Unknown Spear',0,0,0,10000); -- Oren Shop

-- Update Bapho Armor, add 2 DR per live
UPDATE armor SET damage_reduction = 2 where item_id = 20117;

-- Fix Eva Elekkadom droplist.
update droplist set min = 1, max = 1 where mobid = 45938 and itemid = 40179;
update droplist set min = 1, max = 1 where mobid = 45938 and itemid = 40196;
update droplist set min = 1, max = 1 where mobid = 45938 and itemid = 40210;
update droplist set min = 1, max = 1 where mobid = 45938 and itemid = 40225;

-- Reduce Eva Elekkadom summon droprate to match other elekkadoms.
update droplist set chance = 5000 where mobid = 45938 and itemid = 40196;

-- Allow monitor to recall people
-- -- Let's them do some actual monitoring
update commands set access_level = 100 where name = 'recall';

-- Make Guardian ring non-enchantable
UPDATE armor SET safenchant = -1 WHERE item_id = 20287;

-- Reset any innapropriately enchanted guardian rings to +0
-- Only relevant to a live server
UPDATE character_items SET enchantlvl = 0 WHERE item_id = 20287;
UPDATE character_elf_warehouse SET enchantlvl = 0 WHERE item_id = 20287;
UPDATE character_warehouse SET enchantlvl = 0 WHERE item_id = 20287;
UPDATE clan_warehouse SET enchantlvl = 0 WHERE item_id = 20287;

-- CMOMR at NPC Rollko is now 30k each.
UPDATE shop SET selling_price = 30000 WHERE item_id = 20110;

-- Yahee Drops fixed
delete from droplist where mobid = 45675;
delete from droplist where mobid = 81082 and itemid between 40669 AND 40674;
insert into droplist values
(81082,'Yahee',20031,'Helm of Yahee',1,1,20000),
(81082,'Yahee',20069,'Cloak of Yahee',1,1,20000),
(81082,'Yahee',20131,'Armor of Yahee',1,1,20000),
(81082,'Yahee',20179,'Gloves of Yahee',1,1,20000),
(81082,'Yahee',20209,'Boots of Yahee',1,1,20000),
(81082,'Yahee',20261,'Amulet of Yahee',1,1,20000),
(81082,'Yahee',20290,'Ring of Yahee',1,1,20000);

update droplist set min = 2, max = 6, chance = 300000 where mobid = 81082 and itemid = 40014;
update droplist set min = 2, max = 6, chance = 300000 where mobid = 81082 and itemid = 40015;
update droplist set min = 1, max = 5 ,chance = 300000 where mobid = 81082 and itemid = 40443;
update droplist set min = 1, max = 5 ,chance = 300000 where mobid = 81082 and itemid = 40444;
update droplist set min = 1, max = 5 ,chance = 500000 where mobid = 81082 and itemid = 40524;
update droplist set min = 7490, max = 17850 where mobid = 81082 and itemid = 40308;

-- Tarak's drops updated
UPDATE droplist SET chance=12000 WHERE mobId=45685 AND itemId=20076;
UPDATE droplist SET chance=5000 WHERE  mobId=45685 AND itemId=20152;
UPDATE droplist SET chance=10000 WHERE mobId=45685 AND itemId=20186;
UPDATE droplist SET chance=11000 WHERE mobId=45685 AND itemId=20216;
UPDATE droplist SET chance=12000 WHERE mobId=45685 AND itemId=40473;
UPDATE droplist SET chance=7000 WHERE  mobId=45685 AND itemId=40475;
UPDATE droplist SET chance=35000 WHERE mobId=45685 AND itemId=140129;
UPDATE droplist SET chance=25000 WHERE mobId=45685 AND itemId=140130;

-- Updating 10% ring drop rate
UPDATE droplist SET chance=700 WHERE mobId=45364 AND itemId=20280;
UPDATE droplist SET chance=800 WHERE mobId=45392 AND itemId=20280;
UPDATE droplist SET chance=1000 WHERE mobId=45445 AND itemId=20280;
UPDATE droplist SET chance=800 WHERE mobId=45452 AND itemId=20280;
UPDATE droplist SET chance=1000 WHERE mobId=45505 AND itemId=20280;
UPDATE droplist SET chance=1000 WHERE mobId=45509 AND itemId=20280;
UPDATE droplist SET chance=2000 WHERE mobId=45578 AND itemId=20280;

-- Adding Bring Stone drops to all SC mobs
INSERT INTO droplist VALUES
('45050', 'Orc Archer', '40320', 'Bring Stone', '1', '1', '80000'),
('45119', 'Orc Elder', '40320', 'Bring Stone', '1', '1', '80000'),
('45018', 'Orc', '40320', 'Bring Stone', '1', '1', '80000'),
('45030', 'Fungus', '40320', 'Bring Stone', '1', '1', '80000'),
('26510', 'Zombie', '40320', 'Bring Stone', '1', '1', '80000'),
('26511', 'Crawling Craw', '40320', 'Bring Stone', '1', '1', '80000'),
('45094', 'Werewolf', '40320', 'Bring Stone', '1', '1', '80000'),
('45109', 'Orc Zombie', '40320', 'Bring Stone', '1', '1', '80000'),
('45114', 'Skeleton', '40320', 'Bring Stone', '1', '1', '80000'),
('45120', 'Orc Fighter', '40320', 'Bring Stone', '1', '1', '80000'),
('45129', 'Skeleton Archer', '40320', 'Bring Stone', '1', '1', '80000'),
('45134', 'Stone Golem', '40320', 'Bring Stone', '1', '1', '80000'),
('45145', 'Lizardman', '40320', 'Bring Stone', '1', '1', '80000'),
('45148', 'Owlbear', '40320', 'Bring Stone', '1', '1', '80000'),
('45181', 'Spartoi', '40320', 'Bring Stone', '1', '1', '80000');

-- Fiery coal should drop from Lava Golems
INSERT INTO droplist VALUES('45365', 'Lava Golem', '90009', 'Fiery Coal', '1', '1', '1000');

-- Stronger Minotaur should drop 10% rings as well.
INSERT INTO droplist VALUES('45449', 'Minotaur', '20280', 'Ring of Immunity to Magic', '1', '1', '700');

-- Fix 45 royal quest
insert into spawnlist_npc values (87527,'White Wizard Pieta', 1, 71200, 32738, 32849, 0,0, 2, 0, 77, 0);
update npc set name = 'Devourer of Souls' where npcid = 46041;
insert into quest_drops values (41422, 'P');
delete from droplist where itemid = 41422;
insert into droplist values (46041,'Devourer of Souls',41422,'Lifeless Soul',1,1,1000000);
update etcitem set name = 'Lightless Soul', cant_delete = 0 where item_id = 41422;
insert into spawnlist values (8200005,'Devourer of Souls', 1, 46041,0,32698,32823,0,0,32640,32768,32767,32895,5,60,120,82,0,0,0,0,1,8,2,100);

-- update shop tables to remove sales of the below listed items to correct an exploit
update shop set purchasing_price = -1 where item_id = 214; -- Heavy Throwing Knife
update shop set purchasing_price = -1 where item_id = 40738; -- Silver Throwing Knife
update shop set purchasing_price = -1 where item_id = 40739; -- Throwing Knife
update shop set purchasing_price = -1 where item_id = 40740; -- Heavy Throwing Knife
update shop set purchasing_price = -1 where item_id = 40743; -- Arrow
update shop set purchasing_price = -1 where item_id = 40744; -- Silver Arrow
update shop set purchasing_price = -1 where item_id = 40746; -- Mithril Arrow

REPLACE INTO commands (name, access_level, class_name) VALUES('toggleshop', '100', 'L1ToggleShop');
REPLACE INTO commands (name, access_level, class_name) VALUES('dropitems', '100', 'L1DropItems');
UPDATE commands SET name = 'chatban' where name = 'chatng';
