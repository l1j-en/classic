-- update 28 

-- remove bad snow tiger spawn
delete from spawnlist where id = 12472;

-- slightly reduce Priest of Corruption spawnrate in SoE
update spawnlist set count = 14 where npc_templateid = 45570 and mapid = 410 and count = 16;
update spawnlist set count = 14 where npc_templateid = 45571 and mapid = 410 and count = 16;
update spawnlist set count = 14 where npc_templateid = 45582 and mapid = 410 and count = 16;
update spawnlist set count = 14 where npc_templateid = 45587 and mapid = 410 and count = 16;
update spawnlist set count = 10 where npc_templateid = 45570 and mapid = 410 and count = 12;
update spawnlist set count = 10 where npc_templateid = 45571 and mapid = 410 and count = 12;
update spawnlist set count = 10 where npc_templateid = 45582 and mapid = 410 and count = 12;
update spawnlist set count = 10 where npc_templateid = 45587 and mapid = 410 and count = 12;
update spawnlist set count = 10 where npc_templateid = 45605 and mapid = 410 and count = 12;

-- replace SI starved troll spawn with mutated alligator
update spawnlist set npc_templateid = 45026 where npc_templateid = 45069 and mapid = 68;

-- spread out HV/SI spawn
update spawnlist set count = 1 where mapid = 68 and npc_templateid in (45005, 45008, 45009, 45010, 45012, 45016, 45019, 45021, 45023, 45024, 45034, 45041, 45042, 45065, 45069, 45071, 45081, 45082, 45095, 45096);
update spawnlist set count = 1 where mapid = 68 and count = 0 and npc_templateid in (45062, 45063, 45073, 45086);
update spawnlist set count = 1 where mapid = 69 and npc_templateid in (45008, 45009, 45010, 45012, 45019, 45021, 45022, 45023, 45035, 45041, 45059, 45067, 45069, 45078, 45082, 45090, 45091);
update spawnlist set count = 1 where mapid = 68 and count = 0 and npc_templateid in (45036, 45037, 45038, 45052, 45056);

-- only drop Undead Key to mages
insert into quest_drops values (40581, 'W');
-- only drop Arachnevil Elder\'s Claw to knights
insert into quest_drops values (40590, 'K');

-- de-aggro giran vakuuk to sosc
update npc set agrososc = 0 where npcid = 45187;

-- fix for berserker spell target
update skills set target_to = 24 where skill_id = 55;

-- reenable lvl 70 DE poly
update polymorphs set minlevel = 70 where id = 5736;

-- fix for names being displayed wrong when crafting Thread..
update etcitem set name = 'Pan\'s Mane' where item_id = 40519;
update etcitem set name = 'Thread' where item_id = 40502;
update etcitem set name = 'Web of Arachne' where item_id = 40503;

-- fix more etcitem names
update etcitem set name = 'Bag of Endia' where item_id = 40582;
update etcitem set name = 'Letter of Endia' where item_id = 40583;

-- add FI Drake magic attack
insert into mobskill values (45578, 0, 'Drake', 1, 20, 0, 0, -2, 0, 0, 2, 1, 0, 10, 0, 1064, 30, 0, 0, 0, 0);

-- some name updates for skills
update skills set name = 'Seer spell' where skill_id = 10001;
update skills set name = 'Ice Queen Blizzard' where skill_id = 10002;
update skills set name = 'Zenith Queen spell e first' where skill_id = 10003;
update skills set name = 'Zenith Queen spell e second' where skill_id = 10004;
update skills set name = 'Vampire spell e' where skill_id = 10005;
update skills set name = 'Vampire spellnd e first' where skill_id = 10006;
update skills set name = 'Vampire spellnd e second' where skill_id = 10007;
update skills set name = 'Lesser Dragon e' where skill_id = 10008;
update skills set name = 'Bone Dragon e' where skill_id = 10009;
update skills set name = 'Lich e four' where skill_id = 10010;
update skills set name = 'Medusa e' where skill_id = 10011;
update skills set name = 'Super grimreaper change magicattack e multi' where skill_id = 10012;
update skills set name = 'Super grimreaper sickle e screen' where skill_id = 10013;
update skills set name = 'Ifrit magic e' where skill_id = 10014;
update skills set name = 'Basilisk s blast' where skill_id = 10015;
update skills set name = 'Windcutter bomb' where skill_id = 10016;
update skills set name = 'Icedagger bomb' where skill_id = 10017;
update skills set name = 'Phoenix magic e' where skill_id = 10018;
update skills set name = 'Giant boss attack e' where skill_id = 10019;
update skills set name = 'Spirit of earth boss rockdown' where skill_id = 10020;
update skills set name = 'Spirit of fire boss fireball' where skill_id = 10021;
update skills set name = 'Spirit of water boss spout' where skill_id = 10022;
update skills set name = 'Spirit of water boss spear' where skill_id = 10023;
update skills set name = 'Demon magic' where skill_id = 10024;
update skills set name = 'Corruption Magic E' where skill_id = 10025;
update skills set name = 'Lindvior effect start' where skill_id = 10026;
update skills set name = 'Antaras effect start' where skill_id = 10027;
update skills set name = 'Valakas effect start' where skill_id = 10028;
update skills set name = 'Fafurion effect start' where skill_id = 10029;
update skills set name = 'Succubus v magic' where skill_id = 10030;
update skills set name = 'Succubus g magic' where skill_id = 10031;
update skills set name = 'Zenith Queen Spell e venom' where skill_id = 10032;
update skills set name = 'Imp Magic' where skill_id = 10033;
update skills set name = 'Bomb Flower E' where skill_id = 10034;
update skills set name = 'Ice Eruption' where skill_id = 10035;
update skills set name = 'Mambo Rabbit V E' where skill_id = 10036;
update skills set name = 'Mambo Rabbit R E' where skill_id = 10037;
update skills set name = 'Abyss Lord Magic' where skill_id = 10038;
update skills set name = 'Ariorc Attack I E' where skill_id = 10039;
update skills set name = 'Ariorc Attack Ii E' where skill_id = 10040;
update skills set name = 'Ariorc Attack Iii E' where skill_id = 10041;
update skills set name = 'Lesser Demon Att E' where skill_id = 10042;
update skills set name = 'Dark Elementalist E Multi' where skill_id = 10043;
update skills set name = 'Black Wizard Attack E' where skill_id = 10044;
update skills set name = 'Dire Bat L E Screen' where skill_id = 10045;
update skills set name = 'Blue Tale Laser' where skill_id = 10046;
update skills set name = 'Priest Of Corruption Iv Appear Effect' where skill_id = 10047;
update skills set name = 'Seadancer M A' where skill_id = 10048;
update skills set name = 'Seadancer M B' where skill_id = 10049;
update skills set name = 'Fafurion Ice b' where skill_id = 10050;
update skills set name = 'Fafurion Magic' where skill_id = 10051;
update skills set name = 'Valakas Breath' where skill_id = 10052;
update skills set name = 'Lindvior Breath' where skill_id = 10053;
update skills set name = 'Antharas Magic' where skill_id = 10054;
update skills set name = 'Burst' where skill_id = 10055;
update skills set name = 'Hellfire' where skill_id = 10056;

-- max bound kurtz's movement_distance
update spawnlist_boss set movement_distance = 35 where npc_id = 45600;

-- update elven breast plate to be usable by mage
update armor set use_mage = 1 where item_id = 20139;

-- Fix for Magic Gem weight (taken correct weight from lineagedb.com
update etcitem set weight = 1000 where item_id = 40318;

-- correct totem drop from Neruga Orc (was Totem of Rova)
update droplist set itemid = 40132 where itemid = 40134 and mobid = 45171;

-- reduce battle axe droprate from ogre (120000 -> 85000)
update droplist set chance = 85000 where mobid = 45278 and itemid = 143;

-- modify existing Basilisk drops
-- increase brave droprate from Basilisk (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45381;
-- increase Diamond droprate from Basilisk (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40044 and mobid = 45381;
-- increase hqd droprate from Basilisk (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40048 and mobid = 45381;
-- decrease tqd droprate from Basilisk (10000 -> 4500)
update droplist set chance = 4500 where itemid = 40052 and mobid = 45381;
-- increase nzel droprate from Basilisk (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40074 and mobid = 45381;
-- increase ndai droprate from Basilisk (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40087 and mobid = 45381;
-- increase low sb droprate from Basilisk (10000 -> 15000)
update droplist set chance = 15000 where itemid in (40174, 40178, 40180, 40182, 40190) and mobid = 45381;
-- decrease mid sb droprate from Basilisk (10000 -> 7500)
update droplist set chance = 7500 where itemid in (40189, 40207) and mobid = 45381;
-- increase sc:wl droprate from Basilisk (2000 -> 5000)
update droplist set chance = 5000 where itemid = 40253 and mobid = 45381;
-- increase sc:nb droprate from Basilisk (1000 -> 2500)
update droplist set chance = 2500 where itemid = 40255 and mobid = 45381;
-- decrease basi horn droprate from Basilisk (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40646 and mobid = 45381;

-- modify existing SoE Dark Forester drops
-- increase Armor of Dark Forester droprate from SoE Dark Forester (5000 -> 8500)
update droplist set chance = 8500 where itemid = 20098 and mobid = 45326;
-- increase Boots of Dark Forester droprate from SoE Dark Forester (5000 -> 7500)
update droplist set chance = 7500 where itemid = 20196 and mobid = 45326;
-- increase nzel droprate from SoE Dark Forester (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45326;

-- add drops to Escaped Black Knight
-- adena
insert into droplist values (45035, 40308, 25, 70, 1000000);
-- boots
insert into droplist values (45035, 20205, 1, 1, 15000);
-- Helmet
insert into droplist values (45035, 20043, 1, 1, 5000);
-- Potion of Cure Poison
insert into droplist values (45035, 40017, 1, 1, 15000);
-- Scroll of Return - Hidden Valley
insert into droplist values (45035, 40101, 1, 1, 50000);
-- Trident
insert into droplist values (45035, 93, 1, 1, 15000);
-- Cloak of Protection
insert into droplist values (45035, 20063, 1, 1, 7500);
-- Diamond
insert into droplist values (45035, 40044, 1, 1, 5000);
-- Emerald
insert into droplist values (45035, 40047, 1, 1, 5000);
-- Halberd
insert into droplist values (45035, 103, 1, 1, 15000);
-- Haste Potion
insert into droplist values (45035, 40013, 1, 1, 25000);
-- Lance
insert into droplist values (45035, 95, 1, 1, 15000);
-- Red Potion
insert into droplist values (45035, 40010, 1, 1, 50000);
-- Low Boots
insert into droplist values (45035, 20213, 1, 1, 15000);
-- Partisan
insert into droplist values (45035, 94, 1, 1, 15000);
-- Potion of Bravery
insert into droplist values (45035, 40014, 1, 1, 25000);
-- Ruby
insert into droplist values (45035, 40045, 1, 1, 2500);
-- Sapphire
insert into droplist values (45035, 40046, 1, 1, 5000);
-- Potion of Mana
insert into droplist values (45035, 40015, 1, 1, 15000);
-- Plate Mail
insert into droplist values (45035, 20154, 1, 1, 2500);
-- T-Shirt
insert into droplist values (45035, 20085, 1, 1, 2000);
-- Two Handed Sword
insert into droplist values (45035, 52, 1, 1, 2500);
-- Devil\'s Blood 
insert into droplist values (45035, 40031, 1, 1, 2500);
-- b-lance
insert into droplist values (45035, 100095, 1, 1, 5000);
-- b-halberd
insert into droplist values (45035, 100103, 1, 1, 5000);

-- add drops to Valley Bear
-- Adena
insert into droplist values (45036, 40308, 20, 45, 1000000);
-- Scroll of Return - Hidden Valley
insert into droplist values (45036, 40101, 1, 1, 50000);
-- Red Potion
insert into droplist values (45036, 40010, 1, 1, 50000);
-- Meat
insert into droplist values (45036, 40056, 1, 1, 30000);
-- Haste Potion
insert into droplist values (45036, 40013, 1, 1, 15000);
-- Potion of Cure Poison
insert into droplist values (45036, 40017, 1, 1, 15000);
-- Potion of Bravery
insert into droplist values (45036, 40014, 1, 1, 25000);
-- Greater Haste Potion
insert into droplist values (45036, 40018, 1, 1, 15000);
-- b-Scroll of Teleportation
insert into droplist values (45036, 140100, 1, 1, 30000);

-- add drops to Valley Lycanthrope
-- Adena
insert into droplist values (45037, 40308, 30, 60, 1000000);
-- Red Potion
insert into droplist values (45037, 40010, 1, 1, 50000);
-- Scroll of Return to Hidden Valley
insert into droplist values (45037, 40101, 1, 1, 50000);
-- Battle Axe
insert into droplist values (45037, 143, 1, 1, 10000);
-- Boots
insert into droplist values (45037, 20205, 1, 1, 15000);
-- Haste Potion
insert into droplist values (45037, 40013, 1, 1, 25000);
-- Potion of Cure Poison
insert into droplist values (45037, 40017, 1, 1, 15000);
-- Scale Mail
insert into droplist values (45037, 20122, 1, 1, 12000);
-- Studded Leather Armor
insert into droplist values (45037, 20147, 1, 1, 15000);
-- Large Shield
insert into droplist values (45037, 20242, 1, 1, 15000);
-- Diamond
insert into droplist values (45037, 40044, 1, 1, 20000);
-- Fauchard
insert into droplist values (45037, 104, 1, 1, 15000);
-- Scroll of Enchant Weapon 
insert into droplist values (45037, 40087, 1, 1, 1500);

-- add drops to Valley Arachnevil
-- Adena
insert into droplist values (45038, 40308, 20, 45, 1000000);
-- Red Potion
insert into droplist values (45038, 40010, 1, 1, 50000);
-- Potion of Cure Poison
insert into droplist values (45038, 40017, 1, 1, 25000);
-- Scroll of Return to Hidden Valley
insert into droplist values (45038, 40101, 1, 1, 50000);
-- Haste Potion
insert into droplist values (45038, 40013, 1, 1, 25000);
-- Diamond
insert into droplist values (45038, 40044, 1, 1, 15000);
-- Ebony
insert into droplist values (45038, 40007, 1, 1, 5000);
-- Pine
insert into droplist values (45038, 40006, 1, 1, 7500);
-- b-Scroll of Teleportation
insert into droplist values (45038, 140100, 1, 1, 15000);

-- add drops to Fatigued Ratman
-- Adena
insert into droplist values (45052, 40308, 25, 60, 1000000);
-- Potion of Cure Poison
insert into droplist values (45052, 40017, 1, 1, 50000);
-- Red Potion
insert into droplist values (45052, 40010, 1, 1, 50000);
-- Greater Haste Potion
insert into droplist values (45052, 40018, 1, 1, 15000);
-- Haste Potion
insert into droplist values (45052, 40013, 1, 1, 25000);
-- Low Boots
insert into droplist values (45052, 20213, 1, 1, 15000);
-- b-Scroll of Teleportation
insert into droplist values (45052, 140100, 1, 1, 15000);

-- add drops to Valley Owlbear
-- Adena
insert into droplist values (45056, 40308, 16, 40, 1000000); 
-- Apple
insert into droplist values (45056, 40064, 1, 1, 85000); 
-- Banana
insert into droplist values (45056, 40062, 1, 1, 85000); 
-- Carrot
insert into droplist values (45056, 40060, 1, 1, 85000); 
-- Egg
insert into droplist values (45056, 40059, 1, 1, 85000); 
-- Lemon
insert into droplist values (45056, 40061, 1, 1, 85000); 
-- Orange
insert into droplist values (45056, 40069, 1, 1, 85000); 
-- Lamp
insert into droplist values (45056, 40001, 1, 1, 85000); 
-- Red Potion
insert into droplist values (45056, 40010, 1, 1, 50000); 
-- Scroll of Return to Hidden Valley
insert into droplist values (45056, 40101, 1, 1, 50000); 
-- Hard Leather 
insert into droplist values (45056, 40406, 1, 1, 15000); 

-- add drops to Giant Spider
-- Adena
insert into droplist values (45059, 40308, 30, 70, 1000000); 
-- Red Potion
insert into droplist values (45059, 40010, 1, 1, 50000); 
-- Potion of Cure Poison
insert into droplist values (45059, 40017, 1, 1, 50000); 
-- Scroll of Return to Hidden Valley
insert into droplist values (45059, 40101, 1, 1, 50000); 
-- Haste Potion
insert into droplist values (45059, 40013, 1, 1, 25000); 
-- Diamond
insert into droplist values (45059, 40044, 1, 1, 10000); 
-- Ebony
insert into droplist values (45059, 40007, 1, 1, 7500); 
-- Pine
insert into droplist values (45059, 40006, 1, 1, 5000); 
-- b-Scroll of Teleportation 
insert into droplist values (45059, 140100, 1, 1, 15000); 

-- add drops to Valley Harpy
-- Adena
insert into droplist values (45067, 40308, 35, 70, 1000000); 
-- Red Potion
insert into droplist values (45067, 40010, 1, 1, 50000); 
-- Haste Potion
insert into droplist values (45067, 40013, 1, 1, 15000); 
-- Potion of Cure Poison
insert into droplist values (45067, 40017, 1, 1, 15000); 
-- Potion of Mana
insert into droplist values (45067, 40015, 1, 1, 20000); 
-- Scroll of Return to Hidden Valley
insert into droplist values (45067, 40101, 1, 1, 50000); 
-- Scroll of Teleportation
insert into droplist values (45067, 40100, 1, 1, 25000); 
-- Helmet of Magic: Healing
insert into droplist values (45067, 20014, 1, 1, 2500); 
-- Scroll of Enchant Weapon
insert into droplist values (45067, 40087, 1, 1, 1000); 
-- b-Scroll of Teleportation 
insert into droplist values (45067, 140100, 1, 1, 15000); 

-- add drops to Starved Troll
-- Adena
insert into droplist values (45069, 40308, 35, 70, 1000000); 
-- Condensed Lesser Healing Potion
insert into droplist values (45069, 40019, 1, 1, 15000); 
-- Condensed Healing Potion
insert into droplist values (45069, 40020, 1, 1, 7000); 
-- Condensed Greater Healing Potion
insert into droplist values (45069, 40021, 1, 1, 3500); 
-- Haste Potion
insert into droplist values (45069, 40013, 1, 1, 15000); 
-- Potion of Cure Poison
insert into droplist values (45069, 40017, 1, 1, 15000); 
-- Potion of Bravery
insert into droplist values (45069, 40014, 1, 1, 25000); 
-- Scroll of Return to Hidden Valley
insert into droplist values (45069, 40101, 1, 1, 50000); 
-- Battle Axe
insert into droplist values (45069, 143, 1, 1, 10000); 
-- Berserker Axe
insert into droplist values (45069, 145, 1, 1, 7500); 
-- Great Axe
insert into droplist values (45069, 148, 1, 1, 4500); 
-- Splint Mail
insert into droplist values (45069, 20115, 1, 1, 5000); 
-- Helmet of Magic: Healing
insert into droplist values (45069, 20014, 1, 1, 2500); 

-- add drops to Valley Ogre
-- Adena
insert into droplist values (45078, 40308, 25, 60, 1000000);
-- Red Potion
insert into droplist values (45078, 40010, 1, 1, 50000);
-- Haste Potion
insert into droplist values (45078, 40013, 1, 1, 15000);
-- Potion of Bravery
insert into droplist values (45078, 40014, 1, 1, 25000);
-- Scroll of Return to Hidden Valley
insert into droplist values (45078, 40101, 1, 1, 50000);
-- Battle Axe
insert into droplist values (45078, 143, 1, 1, 25000);
-- Berserker Axe
insert into droplist values (45078, 145, 1, 1, 7500);
-- Great Axe
insert into droplist values (45078, 148, 1, 1, 8500); 
-- Splint Mail
insert into droplist values (45078, 20115, 1, 1, 7500);
-- Blood of Ogre
insert into droplist values (45078, 40513, 1, 1, 100);
-- Helmet of Magic: Power
insert into droplist values (45078, 20015, 1, 1, 1200); 
-- Scroll of Enchant Armor
insert into droplist values (45078, 40074, 1, 1, 1000);
-- Scroll of Enchant Weapon
insert into droplist values (45078, 40087, 1, 1, 500);

-- add drops to Valley Griffon
-- Adena
insert into droplist values (45090, 40308, 25, 60, 1000000); 
-- Potion of Cure Poison
insert into droplist values (45090, 40017, 1, 1, 20000); 
-- Scroll of Return to Hidden Valley
insert into droplist values (45090, 40101, 1, 1, 50000); 
-- Haste Potion
insert into droplist values (45090, 40013, 1, 1, 15000); 
-- High Quality Emerald
insert into droplist values (45090, 40051, 1, 1, 2000); 
-- High Quality Ruby
insert into droplist values (45090, 40049, 1, 1, 2000); 
-- Red Potion
insert into droplist values (45090, 40010, 1, 1, 50000); 
-- High Quality Diamond
insert into droplist values (45090, 40048, 1, 1, 4500); 
-- High Quality Sapphire
insert into droplist values (45090, 40050, 1, 1, 5000); 
-- Scroll of Teleportation
insert into droplist values (45090, 40100, 1, 1, 15000); 
-- Greater Haste Potion
insert into droplist values (45090, 140018, 1, 1, 10000); 
-- Haste Potion
insert into droplist values (45090, 140013, 1, 1, 12000); 
-- Banded Mail
insert into droplist values (45090, 20101, 1, 1, 2500); 

-- add drops to Valley Basilisk
-- Adena
insert into droplist values (45091, 40308, 25, 55, 1000000); 
-- Red Potion
insert into droplist values (45091, 40010, 1, 1, 50000); 
-- Haste Potion
insert into droplist values (45091, 40013, 1, 1, 15000); 
-- Scroll of Return to Hidden Valley
insert into droplist values (45091, 40101, 1, 1, 50000); 
-- Diamond
insert into droplist values (45091, 40044, 1, 1, 10000); 
-- Scroll of Curse Removal
insert into droplist values (45091, 40119, 1, 1, 15000); 
-- High Quality Diamond
insert into droplist values (45091, 40048, 1, 1, 7500); 
-- Scroll of Enchant Armor
insert into droplist values (45091, 40074, 1, 1, 1000); 
-- Scroll of Enchant Weapon
insert into droplist values (45091, 40087, 1, 1, 500); 
-- Basilisk Horn 
insert into droplist values (45091, 40646, 1, 1, 250); 

-- add drops to Rotting Skeleton Guard
-- Adena
insert into droplist values (45062, 40308, 20, 45, 1000000);
-- Lamp
insert into droplist values (45062, 40001, 1, 1, 25000);
-- Red Potion
insert into droplist values (45062, 40010, 1, 1, 50000);
-- Haste Potion
insert into droplist values (45062, 40013, 1, 1, 15000);
-- Potion of Cure Poison
insert into droplist values (45062, 40017, 1, 1, 15000);
-- Scroll of Return to Singing Island
insert into droplist values (45062, 40082, 1, 1, 50000);
-- Bone Piece
insert into droplist values (45062, 40407, 1, 1, 50000);
-- Spear 
insert into droplist values (45062, 96, 1, 1, 25000);

-- add drops to Rotting Skeleton Marksman
-- Adena
insert into droplist values (45063, 40308, 20, 55, 1000000);
-- Bow
insert into droplist values (45063, 172, 1, 1, 25000);
-- Bone Piece
insert into droplist values (45063, 40407, 1, 1, 50000);
-- Scroll of Return to Singing Island
insert into droplist values (45063, 40082, 1, 1, 50000);
-- Red Potion
insert into droplist values (45063, 40010, 1, 1, 50000);
-- Haste Potion
insert into droplist values (45063, 40013, 1, 1, 15000);
-- Arrow
insert into droplist values (45063, 40743, 10, 35, 50000);

-- add drops to Island Ghast
-- Adena
insert into droplist values (45071, 40308, 20, 55, 1000000);
-- Battle Axe
insert into droplist values (45071, 143, 1, 1, 10000);
-- Red Potion
insert into droplist values (45071, 40010, 1, 1, 50000);
-- Potion of Cure Poison
insert into droplist values (45071, 40017, 1, 1, 15000);
-- Scroll of Return to Singing Island 
insert into droplist values (45071, 40082, 1, 1, 50000);
-- Haste Potion
insert into droplist values (45071, 40013, 1, 1, 15000);

-- add drops to Rotting Skeleton Fighter
-- Adena
insert into droplist values (45073, 40308, 20, 65, 1000000);
-- Red Potion
insert into droplist values (45073, 40010, 1, 1, 50000);
-- Bone Piece
insert into droplist values (45073, 40407, 1, 1, 50000);
-- Scroll of Return to Singing Island
insert into droplist values (45073, 40082, 1, 1, 50000);
-- Battle Axe
insert into droplist values (45073, 143, 1, 1, 15000);

-- add drops to Island Ghast Lord
-- Adena
insert into droplist values (45081, 40308, 20, 65, 1000000);
-- Silver Arrow
insert into droplist values (45081, 40744, 10, 35, 25000);
-- Red Potion
insert into droplist values (45081, 40010, 1, 1, 50000);
-- Potion of Cure Poison
insert into droplist values (45081, 40017, 1, 1, 15000);
-- Potion of Wisdom
insert into droplist values (45081, 40016, 1, 1, 15000);
-- Scroll of Return to Singing Island
insert into droplist values (45081, 40082, 1, 1, 50000);
-- Battle Axe
insert into droplist values (45081, 143, 1, 1, 10000);
-- Haste Potion
insert into droplist values (45081, 40013, 1, 1, 15000);
-- Potion of Mana
insert into droplist values (45081, 40015, 1, 1, 25000);
-- Scroll of Curse Removal
insert into droplist values (45081, 40119, 1, 1, 15000);
-- Scroll of Teleportation
insert into droplist values (45081, 40100, 1, 1, 15000);
-- Berserker Axe
insert into droplist values (45081, 145, 1, 1, 8500);
-- Great Axe
insert into droplist values (45081, 148, 1, 1, 7500);
-- Scroll of Enchant Armor
insert into droplist values (45081, 40074, 1, 1, 500);
-- Scroll of Enchant Weapon
insert into droplist values (45081, 40087, 1, 1, 250);
-- b-Scroll of Teleportation 
insert into droplist values (45081, 140100, 1, 1, 15000);

-- add drops to Degenerated Beholder
-- Adena
insert into droplist values (45086, 40308, 20, 55, 1000000);
-- Potion of Cure Poison
insert into droplist values (45086, 40017, 1, 1, 15000);
-- Red Potion
insert into droplist values (45086, 40010, 1, 1, 50000);
-- Potion of Wisdom
insert into droplist values (45086, 40016, 1, 1, 15000);
-- Scroll of Return to Singing Island
insert into droplist values (45086, 40082, 1, 1, 50000);
-- Silver Arrow
insert into droplist values (45086, 40744, 10, 35, 25000);
-- Haste Potion
insert into droplist values (45086, 40013, 1, 1, 15000);
-- Potion of Mana
insert into droplist values (45086, 40015, 1, 1, 25000);
-- Scroll of Enchant Weapon
insert into droplist values (45086, 40087, 1, 1, 250);
-- c-Scroll of Enchant Weapon
insert into droplist values (45086, 140087, 1, 1, 250);

-- add drops to Island Cockatrice
-- Adena
insert into droplist values (45095, 40308, 20, 60, 1000000);
-- Red Potion
insert into droplist values (45095, 40010, 1, 1, 50000);
-- Scroll of Return to Singing Island
insert into droplist values (45095, 40082, 1, 1, 50000);
-- Potion of Mana
insert into droplist values (45095, 40015, 1, 1, 15000);
-- Greater Haste Potion
insert into droplist values (45095, 40012, 1, 1, 10000);
-- Haste Potion
insert into droplist values (45095, 40013, 1, 1, 15000);
-- Potion of Cure Poison
insert into droplist values (45095, 40017, 1, 1, 15000);
-- Potion of Wisdom
insert into droplist values (45095, 40016, 1, 1, 15000);
-- Ebony
insert into droplist values (45095, 40007, 1, 1, 10000);
-- Scroll of Enchant Armor
insert into droplist values (45095, 40074, 1, 1, 500);
-- Scroll of Enchant Weapon
insert into droplist values (45095, 40087, 1, 1, 250);
-- b-Scroll of Teleportation  
insert into droplist values (45095, 140100, 1, 1, 15000);

-- add drops to Island Crocodile
-- Adena
insert into droplist values (45096, 40308, 35, 85, 1000000);
-- Red Potion
insert into droplist values (45096, 40010, 1, 1, 50000);
-- Scroll of Return to Singing Island
insert into droplist values (45096, 40082, 1, 1, 50000);
-- Haste Potion
insert into droplist values (45096, 40013, 1, 1, 15000);
-- Scroll of Curse Removal
insert into droplist values (45096, 40119, 1, 1, 15000);
-- Silver Arrow
insert into droplist values (45096, 40744, 10, 35, 25000);
-- Potion of Cure Poison
insert into droplist values (45096, 40017, 1, 1, 15000);
-- Scroll of Enchant Armor
insert into droplist values (45096, 40074, 1, 1, 750);
-- Ebony
insert into droplist values (45096, 40007, 1, 1, 10000);

-- add drops to Mutated Alligator
-- Adena
insert into droplist values (45026, 40308, 15, 35, 1000000);
-- Haste Potion
insert into droplist values (45026, 40013, 1, 1, 15000);
-- Scroll of Return to Singing Island
insert into droplist values (45026, 40082, 1, 1, 50000);
-- Red Potion 
insert into droplist values (45026, 40010, 1, 1, 50000);

-- modify existing Priest of Corruption (45570) drops
-- increase Potion of Bravery droprate from Priest of Corruption (45570) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45570;
-- increase Potion of Mana droprate from Priest of Corruption (45570) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45570;
-- increase Black Lump of Pure Mithral droprate from Priest of Corruption (45570) (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40443 and mobid = 45570;
-- increase Black Blood Stone droprate from Priest of Corruption (45570) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45570;
-- increase Fragment of Soul Stone droprate from Priest of Corruption (45570) (50000 -> 200000)
update droplist set chance = 200000 where itemid = 40678 and mobid = 45570;
-- increase btele droprate from Priest of Corruption (45570) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45570;

-- modify existing Priest of Corruption (45571) drops
-- increase Potion of Bravery droprate from Priest of Corruption (45571) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45571;
-- increase Potion of Mana droprate from Priest of Corruption (45571) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45571;
-- increase ntele droprate from Priest of Corruption (45571) (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40100 and mobid = 45571;
-- increase Black Lump of Pure Mithral droprate from Priest of Corruption (45571) (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40443 and mobid = 45571;
-- increase Black Blood Stone droprate from Priest of Corruption (45571) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45571;
-- increase Fragment of Soul Stone droprate from Priest of Corruption (45571) (50000 -> 200000)
update droplist set chance = 200000 where itemid = 40678 and mobid = 45571;
-- increase btele droprate from Priest of Corruption (45571) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45571;

-- modify existing Priest of Corruption (45582) drops
-- increase Potion of Bravery droprate from Priest of Corruption (45582) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45582;
-- increase Potion of Mana droprate from Priest of Corruption (45582) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45582;
-- increase Black Lump of Pure Mithral droprate from Priest of Corruption (45582) (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40443 and mobid = 45582;
-- increase Black Blood Stone droprate from Priest of Corruption (45582) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45582;
-- increase Fragment of Soul Stone droprate from Priest of Corruption (45587) (50000 -> 200000)
update droplist set chance = 200000 where itemid = 40678 and mobid = 45582;
-- increase btele droprate from Priest of Corruption (45582) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45582;

-- modify existing Priest of Corruption (45587) drops
-- increase Potion of Bravery droprate from Priest of Corruption (45587) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45587;
-- increase Potion of Mana droprate from Priest of Corruption (45587) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45587;
-- increase Black Lump of Pure Mithral droprate from Priest of Corruption (45587) (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40443 and mobid = 45587;
-- increase Black Blood Stone  droprate from Priest of Corruption (45587) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45587;
-- increase Fragment of Soul Stone droprate from Priest of Corruption (45587) (50000 -> 200000)
update droplist set chance = 200000 where itemid = 40678 and mobid = 45587;
-- increase btele droprate from Priest of Corruption (45587) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45587;

-- modify existing Priest of Corruption (45605) drops
-- increase Potion of Bravery droprate from Priest of Corruption (45605) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45605;
-- increase Potion of Mana droprate from Priest of Corruption (45605) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45605;
-- increase Black Lump of Pure Mithral droprate from Priest of Corruption (45605) (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40443 and mobid = 45605;
-- increase Black Blood Stone  droprate from Priest of Corruption (45605) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45605;
-- increase Fragment of Soul Stone droprate from Priest of Corruption (45605) (50000 -> 200000)
update droplist set chance = 200000 where itemid = 40678 and mobid = 45605;
-- increase btele droprate from Priest of Corruption (45605) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45605;
