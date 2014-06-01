-- IMPORTANT: THIS UPDATE IS NOT YET FULLY TESTED, USE IT AT YOUR OWN RISK!

-- Disable random teleport in Crystal Cave
UPDATE mapids SET teleportable=0 WHERE mapid in (72,73,74);

-- Spawn the doors for crystal cave
INSERT INTO spawnlist_door VALUES ('5001', 'Ice Crystal Cave 1f', '6640', '32859', '32835', '72', '0', '0');
INSERT INTO spawnlist_door VALUES ('5002', 'Ice Crystal Cave 2f', '6640', '32862', '32764', '73', '0', '0');
INSERT INTO spawnlist_door VALUES ('5003', 'Ice Crystal Cave 2f', '6640', '32845', '32809', '73', '0', '0');
INSERT INTO spawnlist_door VALUES ('5004', 'Ice Crystal Cave 2f', '6642', '32825', '32862', '73', '0', '0');
INSERT INTO spawnlist_door VALUES ('5005', 'Ice Crystal Cave 2f', '6642', '32767', '32837', '73', '0', '0');
INSERT INTO spawnlist_door VALUES ('5006', 'Ice Crystal Cave 2f', '6642', '32752', '32753', '73', '0', '0');
INSERT INTO spawnlist_door VALUES ('5007', 'Ice Crystal Cave 3f', '6640', '32784', '32818', '74', '0', '0');
INSERT INTO spawnlist_door VALUES ('5008', 'Ice Crystal Cave 3f', '6640', '32852', '32806', '74', '0', '0');
INSERT INTO spawnlist_door VALUES ('5009', 'Ice Crystal Cave 3f', '6640', '32822', '32855', '74', '0', '0');
INSERT INTO spawnlist_door VALUES ('5010', 'Ice Crystal Cave 3f', '6642', '32762', '32916', '74', '0', '0');

INSERT INTO door_gfxs VALUES ('6640', 'Ice Crystal Cave 1f', '1', '-1', '3');
INSERT INTO door_gfxs VALUES ('6642', 'Ice Crystal Cave 2f', '0', '-2', '2');

-- Insert IQ Royal Guards and gate keepers
INSERT INTO spawnlist VALUES ('7200008', 'Ice Queen Royal Guard', '1', '46136', '0', '32798', '32853', '0', '0', '0', '0', '0', '0', '5', '20', '40', '72', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7200009', 'Ice Queen Royal Guard', '1', '46136', '0', '32798', '32849', '0', '0', '0', '0', '0', '0', '5', '20', '40', '72', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7200010', 'Ice Queen Royal Guard', '1', '46136', '0', '32798', '32821', '0', '0', '0', '0', '0', '0', '5', '20', '40', '72', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7200011', 'Ice Queen Royal Guard', '1', '46136', '0', '32798', '32817', '0', '0', '0', '0', '0', '0', '5', '20', '40', '72', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7200012', 'Ice Queen Royal Guard', '1', '46143', '0', '32856', '32836', '0', '0', '0', '0', '0', '0', '6', '60', '120', '72', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7300007', 'Ice Queen Royal Guard', '3', '46138', '65', '32799', '32831', '5', '5', '32704', '32704', '32895', '32895', '0', '90', '120', '73', '0', '100', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7300008', 'Ice Queen Royal Guard', '3', '46135', '64', '32799', '32831', '5', '5', '32704', '32704', '32895', '32895', '0', '90', '120', '73', '0', '100', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7300009', 'Ice Queen Royal Guard', '1', '46144', '0', '32859', '32765', '0', '0', '0', '0', '0', '0', '6', '60', '120', '73', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7300010', 'Ice Queen Royal Guard', '1', '46145', '0', '32850', '32809', '0', '0', '0', '0', '0', '0', '2',  '60', '120', '73', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7300011', 'Ice Queen Royal Guard', '1', '46146', '0', '32825', '32858', '0', '0', '0', '0', '0', '0', '0', '60', '120', '73', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7300012', 'Ice Queen Royal Guard', '1', '46147', '0', '32767', '32840', '0', '0', '0', '0', '0', '0', '4', '60', '120', '73', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7300013', 'Ice Queen Royal Guard', '1', '46148', '0', '32751', '32756', '0', '0', '0', '0', '0', '0', '4', '60', '120', '73', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7400007', 'Maid of the Ice Queen', '1', '46140', '68', '32842', '32921', '5', '5', '0', '0', '0', '0', '0', '90', '120', '74', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7400008', 'Ice Queen Royal Guard', '3', '46139', '66', '32799', '32853', '5', '5', '32704', '32768', '32895', '32959', '0', '90', '120', '74', '0', '100', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7400009', 'Ice Queen Royal Guard', '3', '46137', '67', '32799', '32853', '5', '5', '32704', '32768', '32895', '32959', '0', '90', '120', '74', '0', '100', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7400010', 'Ice Queen Royal Guard', '1', '46149', '0', '32781', '32819', '0', '0', '0', '0', '0', '0', '6', '60', '120', '74', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7400011', 'Ice Queen Royal Guard', '1', '46150', '0', '32849', '32807', '0', '0', '0', '0', '0', '0', '6', '60', '120', '74', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7400012', 'Ice Queen Royal Guard', '1', '46151', '0', '32826', '32856', '0', '0', '0', '0', '0', '0', '2',  '60', '120', '74', '0', '0', '0', '0','1','8','2', '100');
INSERT INTO spawnlist VALUES ('7400013', 'Ice Queen Royal Guard', '1', '46152', '0', '32762', '32912', '0', '0', '0', '0', '0', '0', '0', '60', '120', '74', '0', '0', '0', '0','1','8','2', '100');

-- Update the stats of Ice Queen and Ice Demon
UPDATE npc SET lvl=60,hp=15000,mp=1000,ac=-65,mr=60,lawful=-200,hpr=150,mpr=100,teleport=1 WHERE npcid=46141;
UPDATE npc SET lvl=55,hp=10000,mp=500,ac=-68,mr=80,lawful=-150,hpr=100,mpr=100 WHERE npcid=46142;

-- Add New Ice Queen and Ice Demon into boss spawnlist and disable the old Ice Queen spawn
INSERT INTO spawnlist_boss VALUES ('126', 'Ice Queen', 'Oren', '1', '46141', '0', '32842', '32921', '0', '0', '0', '0', '0', '0', '5', '74', '1', '0', '0', '0', '100');
INSERT INTO spawnlist_boss VALUES ('127', 'Ice Demon', 'Oren', '1', '46142', '0', '32753', '32776', '0', '0', '0', '0', '0', '0', '5', '73', '1', '0', '0', '0', '100');
UPDATE spawnlist_boss SET percentage=0 WHERE id=43;

-- Add the mobskills
INSERT INTO mobskill VALUES ('46140', '0', 'Maid of the Ice Queen', 'Cone of Cold', '2',  '50', '0', '0', '-6', '0', '0', '6', '0', '0', '0', '38', '0', '1', '0', '0', '0', '0');
INSERT INTO mobskill VALUES ('46141', '0','Ice Queen','Blizzard', '2',  '30', '0', '0', '-10', '0', '0', '0', '0', '0', '70', '59', '0', '19', '0', '0', '0', '0');
INSERT INTO mobskill VALUES ('46141', '1','Ice Queen','Destroy', '2',  '30', '0', '0', '-6', '0', '3', '6', '0', '0', '0', '77', '0', '1', '0', '0', '0', '0');
INSERT INTO mobskill VALUES ('46141', '2', 'Ice Queen','Cone of Cold', '2',  '50', '0', '0', '-6', '0', '3', '6', '0', '0', '0', '38', '0', '18', '0', '0', '0', '0');
INSERT INTO mobskill VALUES ('46142', '0','Ice Demon','Shock Stun', '2',  '30', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '87', '0', '0', '0', '0', '0', '0');
INSERT INTO mobskill VALUES ('46142', '1','Ice Demon','Tornado', '2',  '40', '0', '0', '-4', '0', '0', '0', '0', '0', '30', '53', '0', '19', '0', '0', '0', '0');
INSERT INTO mobskill VALUES ('46142', '2', 'Ice Demon','Lightning Storm', '2',  '40', '0', '0', '-6', '0', '0', '6', '0', '0', '20', '65', '0', '30', '0', '0', '0', '0');
INSERT INTO mobskill VALUES ('46142', '3','Ice Demon','Ice Eruption', '2',  '50', '0', '0', '-6', '0', '0', '6', '0', '0', '0', '10035', '0', '1', '0', '0', '0', '0');

-- Drops
INSERT INTO droplist VALUES ('46135', 'Ice Queen Royal Guard', '142', 'Silver Axe',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46135', 'Ice Queen Royal Guard', '40014', 'Potion of Bravery',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46135', 'Ice Queen Royal Guard', '40021', 'Condensed Greater Healing Potion',  '1', '3', '50000');
INSERT INTO droplist VALUES ('46135', 'Ice Queen Royal Guard', '40087', 'Scroll of Enchant Weapon',  '1', '1', '5000');
INSERT INTO droplist VALUES ('46135', 'Ice Queen Royal Guard', '40308', 'Adena',  '80', '150', '1000000');
INSERT INTO droplist VALUES ('46135', 'Ice Queen Royal Guard', '49135', 'Memory Crystal(IllusionAvatar)',  '1', '1', '5000');
INSERT INTO droplist VALUES ('46136', 'Ice Queen Royal Guard', '40308', 'Adena',  '80', '150', '1000000');
INSERT INTO droplist VALUES ('46137', 'Ice Queen Royal Guard', '148', 'Great Axe',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46137', 'Ice Queen Royal Guard', '20128', 'Crystal Plate Mail',  '1', '1', '1000');
INSERT INTO droplist VALUES ('46137', 'Ice Queen Royal Guard', '21081', 'Ice Queen`s Earring Lvl 0',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46137', 'Ice Queen Royal Guard', '40006', 'Pine Wand',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46137', 'Ice Queen Royal Guard', '40014', 'Potion of Bravery',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46137', 'Ice Queen Royal Guard', '40087', 'Scroll of Enchant Weapon',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46137', 'Ice Queen Royal Guard', '40308', 'Adena',  '80', '150', '1000000');
INSERT INTO droplist VALUES ('46137', 'Ice Queen Royal Guard', '49135', 'Memory Crystal(IllusionAvatar)',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46138', 'Ice Queen Royal Guard', '40021', 'Condensed Greater Healing Potion',  '1', '1',  '50000');
INSERT INTO droplist VALUES ('46138', 'Ice Queen Royal Guard', '40068', 'Elven Wafer',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46138', 'Ice Queen Royal Guard', '40074', 'Scroll of Enchant Armor',  '1', '1', '5000');
INSERT INTO droplist VALUES ('46138', 'Ice Queen Royal Guard', '40089', 'Scroll of Resurrection',  '1', '1', '100000');
INSERT INTO droplist VALUES ('46138', 'Ice Queen Royal Guard', '40308', 'Adena',  '80', '150', '1000000');
INSERT INTO droplist VALUES ('46139', 'Ice Queen Royal Guard', '20175', 'Crystal Gloves',  '1', '1', '1000');
INSERT INTO droplist VALUES ('46139', 'Ice Queen Royal Guard', '21081', 'Ice Queen`s Earring Lvl 0',  '1', '1', '1000');
INSERT INTO droplist VALUES ('46139', 'Ice Queen Royal Guard', '40006', 'Pine Wand',  '1', '1', '5000');
INSERT INTO droplist VALUES ('46139', 'Ice Queen Royal Guard', '40068', 'Elven Wafer',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46139', 'Ice Queen Royal Guard', '40074', 'Scroll of Enchant Armor',  '1', '1', '5000');
INSERT INTO droplist VALUES ('46139', 'Ice Queen Royal Guard', '40308', 'Adena',  '80', '150', '1000000');
INSERT INTO droplist VALUES ('46139', 'Ice Queen Royal Guard', '140100', 'Lesser Healing Potion',  '1', '1', '50000');

delete from droplist where mobid = 46140;
INSERT INTO droplist VALUES ('46140', 'Maid of the Ice Queen', '40015', 'Potion of Mana',  '1', '1', '100000');
INSERT INTO droplist VALUES ('46140', 'Maid of the Ice Queen', '40016', 'Potion of Wisdom',  '1', '1', '300000');
INSERT INTO droplist VALUES ('46140', 'Maid of the Ice Queen', '40021', 'Condensed Greater Healing Potion',  '1', '3', '100000');
INSERT INTO droplist VALUES ('46140', 'Maid of the Ice Queen', '40074', 'Scroll of Enchant Armor',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46140', 'Maid of the Ice Queen', '40087', 'Scroll of Enchant Weapon',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46140', 'Maid of the Ice Queen', '40088', 'Scroll of Polymorph',  '1', '1', '100000');
INSERT INTO droplist VALUES ('46140', 'Maid of the Ice Queen', '40214', 'Spellbook(MassTeleport)',  '1', '1', '5000');
INSERT INTO droplist VALUES ('46140', 'Maid of the Ice Queen', '40308', 'Adena',  '150', '450', '1000000');
INSERT INTO droplist VALUES ('46140', 'Maid of the Ice Queen', '49115', 'Dragon Tablet(FreezingBreath)',  '1', '1', '5000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '11', 'Dagger of Crystal',  '1', '1', '5000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '41', 'Katana',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '52', 'Two Handed Sword',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '111', 'Staff of Ice Queen',  '1', '1', '1000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '20059', 'Water Cloak',  '1', '1', '3000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '20110', 'Chain Mail of Magic Resistance',  '1', '1', '300000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '20134', 'Alluring Dress of Ice Queen',  '1', '1', '3000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '20154', 'Plate Mail',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '20172', 'Glove of Ice Spirit',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '20211', 'Alluring Sandals of Ice Queen',  '1', '1', '8500');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '21081', 'Ice Queen`s Earring Lvl 0',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40044', 'Diamond',  '1', '1', '300000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40048', 'High Quality Diamond',  '1', '1', '300000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40074', 'Scroll of Enchant Armor',  '1', '1', '300000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40087', 'Scroll of Enchant Weapon',  '1', '1', '300000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40089', 'Scroll of Resurrection',  '1', '1', '300000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40094', 'Blank Scroll (Level 5)',  '2', '5', '300000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40185', 'Spellbook(Darkness)',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40196', 'Spellbook(Summon)',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40205', 'Spellbook(Invisibility)',  '1', '1', '1000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40209', 'Spellbook(Silence)',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40214', 'Spellbook(MassTeleport)',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40225', 'Spellbook(FreezingBlizzard)',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40253', 'Spirit Crystal(WaterLife)',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40255', 'Spirit Crystal(NaturesBlessing)',  '1', '1', '5000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40261', 'Spirit Crystal(WindWalk)',  '1', '1', '300000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40306', 'Relic of Eva',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '40308', 'Adena',  '10000', '20000', '1000000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '49031', 'Ice Crystal',  '1', '1', '20000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '49033', 'Ice Queen`s Pouch',  '1', '1', '1000000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '140074', 'Scroll of Enchant Armor', '1', '1', '100000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '140087', 'Scroll of Enchant Weapon', '1', '1', '100000');
INSERT INTO droplist VALUES ('46141', 'Ice Queen', '200052', 'Two Handed Sword', '1', '1', '10000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '2', 'Dice Dagger', '1', '1', '10000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '11', 'Dagger of Crystal',  '1', '1', '5000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '16', 'Blade of Revenge',  '1', '1', '1000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '41', 'Katana',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '52', 'Two Handed Sword',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '108', 'Staff of Demon',  '1', '1', '500');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '166', 'Claw of Hate',  '1', '1', '1000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '20009', 'Demon Helmet',  '1', '1', '1000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '20099', 'Demon Armor',  '1', '1', '1000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '20128', 'Crystal Plate Mail',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '20154', 'Plate Mail',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '20172', 'Glove of Ice Spirit',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '20197', 'Demon Boots',  '1', '1', '1000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '21081', 'Ice Queen`s Earring Lvl 0',  '1', '1', '20000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '40006', 'Pine Wand',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '40018', 'Greater Haste Potion',  '1', '1', '300000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '40048', 'High Quality Diamond',  '1', '1', '300000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '40053', 'Highest Quality Ruby',  '1', '1', '300000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '40089', 'Scroll of Resurrection',  '1', '1', '300000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '40093', 'Blank Scroll (Level 4)',  '2', '5', '300000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '40210', 'Spellbook(LightningStorm)',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '40215', 'Spellbook(FireStorm)',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '40219', 'Spellbook(MeteorStrike)',  '1', '1', '1000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '40308', 'Adena',  '8000', '18000', '1000000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '40524', 'Black Blood Stone',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '49031', 'Ice Crystal',  '1', '1', '10000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '49032', 'Ice Demon`s Pouch',  '1', '1', '1000000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '49123', 'Memory Crystal(MindBreak)',  '1', '1', '50000');
INSERT INTO droplist VALUES ('46142', 'Ice Demon', '140089', 'Scroll of Resurrection', '1', '1', '300000');

-- Add Jewel Craftsman David that crafts Ice Queen's Earring
INSERT INTO npc VALUES ('80192', 'Jewel Craftsman David', '$6446', 'IQEarring', 'L1Merchant', '2293', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'small', '0', '0', '0', '1440', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '14', '0', '0', '0');
INSERT INTO spawnlist_npc VALUES ('1310457', 'Jewel Craftsman David', '1', '80192', '34058', '32287', '0', '0', '4', '0', '4', '0');
INSERT INTO npcaction VALUES ('80192', '8event3', '8event3', '', '');

-- Boost the strength of Ice Queen's skills
UPDATE mobskill SET Leverage=25 WHERE mobid=46141 AND (Skillid=77 OR Skillid=38);
UPDATE mobskill SET Leverage=100 WHERE mobid=46141 AND Skillid=59;

-- Remove the spawn of old Maid of the Ice Queen (quest)
UPDATE spawnlist SET count=0 WHERE npc_templateid=45102 AND mapid=74;

