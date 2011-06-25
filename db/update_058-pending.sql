-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 58

-- Added pig and hen groups.
insert into mobgroup values (75, 'Hen(5)', 0, 70981, 70981, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
insert into mobgroup values (76, 'Pig(5)', 0, 70983, 70983, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- Change pigs and hens stats to be similar to ducks and milk cows.
update npc set impl = 'L1Monster', lvl = 2, hp = 10, mp = 0, ac = 10, str = 5, con = 12, dex = 12, wis = 1, intel = 0, mr = 0, exp = 5, lawful = 25, size = 'small', ranged = 1, passispeed = 1280, isErase = 1, light_size = 0, amount_fixed = 1 where npcid in (70981, 70983);

-- Spawn pig and hen groups in SKT, Kent, WW, OT, Werldern (hens only), Oren, Giran.
insert into spawnlist values (801500629, 'Pig Group, SKT', 1, 70983, 76, 33099, 33394, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500630, 'Hen Group, SKT', 1, 70981, 75, 33069, 33390, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500631, 'Pig Group, Kent', 1, 70983, 76, 33059, 32745, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500632, 'Hen Group, Kent', 1, 70981, 75, 33047, 32781, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500633, 'Pig Group, Giran', 1, 70983, 76, 33404, 32778, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500634, 'Hen Group, Giran', 1, 70981, 75, 33445, 32810, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500635, 'Hen Group, Werldern', 1, 70981, 75, 33701, 32492, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500636, 'Pig Group, Oren', 1, 70983, 76, 34045, 32264, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500637, 'Hen Group, Oren', 1, 70981, 75, 34071, 32279, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500638, 'Pig Group, Windawood', 1, 70983, 76, 32626, 33206, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500639, 'Hen Group, Windawood', 1, 70981, 75, 32604, 33184, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500640, 'Pig Group, Orc Town', 1, 70983, 76, 32735, 32438, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500641, 'Hen Group, Orc Town', 1, 70981, 75, 32755, 32465, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500642, 'Pig Group, TI', 1, 70983, 76, 32583, 32955, 10, 10, 0, 0, 0, 0, 0, 120, 180, 1, 0, 100, 0, 0);
insert into spawnlist values (801500643, 'Hen Group, TI', 1, 70981, 75, 32579, 32927, 10, 10, 0, 0, 0, 0, 0, 120, 180, 1, 0, 100, 0, 0);
insert into spawnlist values (801500644, 'Pig Group, Gludin', 1, 70983, 76, 32620, 32741, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500645, 'Hen Group, Gludin', 1, 70981, 75, 32607, 32794, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

-- Also adding pig group to Werldern, and both types to Heine (checked live and they have them).
insert into spawnlist values (801500646, 'Pig Group, Werldern', 1, 70983, 76, 33742, 32486, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500647, 'Pig Group, Heine', 1, 70983, 76, 33587, 33240, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500648, 'Hen Group, Heine', 1, 70981, 75, 33613, 33235, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

-- Oren roaming NPCs.  
update npc set impl = 'L1Monster', lvl = 2, hp = 30, mp = 0, ac = 10, str = 5, con = 12, dex = 12, wis = 1, intel = 0, mr = 0, exp = 5, lawful = 1000, size = 'small', ranged = 1, passispeed = 1280, isErase = 1, light_size = 0, amount_fixed = 1 where npcid in (70735, 70736, 70767, 70741, 70752, 70746);
insert into spawnlist values (801500649, 'Garuga', 1, 70735, 0, 34056, 32268, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500650, 'Derian', 1, 70736, 0, 34047, 32265, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500651, 'Dima', 1, 70741, 0, 34049, 32276, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500652, 'Rotus', 1, 70746, 0, 34053, 32294, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500653, 'Biyan', 1, 70752, 0, 34060, 32286, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500654, 'Haro', 1, 70767, 0, 34071, 32281, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

-- SKT roaming NPCs.
update npc set impl = 'L1Monster', lvl = 2, hp = 30, mp = 0, ac = 10, str = 5, con = 12, dex = 12, wis = 1, intel = 0, mr = 0, exp = 5, lawful = 1000, size = 'small', ranged = 1, passispeed = 1280, isErase = 1, light_size = 0, amount_fixed = 1 where npcid in (70803);
insert into spawnlist values (801500655, 'Anotte', 1, 70803, 0, 33089, 33397, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

-- Add two milk cows to WW vineyard (live has these).
insert into spawnlist values (801500656, 'Milk Cow', 1, 70984, 0, 32620, 33262, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500657, 'Milk Cow', 1, 70984, 0, 32601, 33281, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

-- Add campfire in Kent-Gludio vineyard.
insert into spawnlist_npc values (1310417, 'Fire', 1, 81164, 32871, 32807, 0, 0, 6, 0, 4, 0);
-- Vineyard hen/pig groups, and 2 cows.
insert into spawnlist values (801500658, 'Pig Group, Vineyard', 1, 70983, 76, 32865, 32782, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500659, 'Hen Group, Vineyard', 1, 70981, 75, 32863, 32813, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500660, 'Milk Cow', 1, 70984, 0, 32876, 32810, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500661, 'Milk Cow', 1, 70984, 0, 32867, 32787, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

-- Giran town roaming NPCs.
update npc set impl = 'L1Monster', lvl = 2, hp = 30, mp = 0, ac = 10, str = 5, con = 12, dex = 12, wis = 1, intel = 0, mr = 0, exp = 5, lawful = 1000, size = 'small', ranged = 1, passispeed = 1280, isErase = 1, light_size = 0, amount_fixed = 1 where npcid in (70576, 70581, 70586, 70589, 70591, 70592, 70593, 70604, 70615, 70616, 70619, 70621, 70624, 70626, 70630, 70634, 70637, 70639, 70640, 71112);
insert into spawnlist values (801500662, 'Garth', 1, 70576, 0, 33442, 32803, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500663, 'Gulian', 1, 70581, 0, 33442, 32810, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500664, 'Daisy', 1, 70586, 0, 33442, 32817, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500665, 'Laban', 1, 70589, 0, 33442, 32824, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500666, 'Lina', 1, 70591, 0, 33442, 32831, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500667, 'Leal', 1, 70592, 0, 33435, 32829, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500668, 'Manus', 1, 70593, 0, 33428, 32829, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500669, 'Bridget', 1, 70604, 0, 33421, 32829, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500670, 'Alda', 1, 70615, 0, 33414, 32829, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500671, 'Aldred', 1, 70616, 0, 33407, 32829, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500672, 'Alice', 1, 70619, 0, 33400, 32829, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500673, 'Evelyn', 1, 70621, 0, 33412, 32820, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500674, 'Oliver', 1, 70624, 0, 33412, 32813, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500675, 'Jack', 1, 70626, 0, 33412, 32806, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500676, 'Giles', 1, 70630, 0, 33412, 32799, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500677, 'Tanya', 1, 70634, 0, 33412, 32792, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500678, 'Tovia', 1, 70637, 0, 33422, 32799, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500679, 'Ferdinand', 1, 70639, 0, 33429, 32799, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500681, 'Pierre', 1, 70640, 0, 33436, 32799, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

-- Giran dog race roaming NPCs.
update npc set impl = 'L1Monster', lvl = 2, hp = 30, mp = 0, ac = 10, str = 5, con = 12, dex = 12, wis = 1, intel = 0, mr = 0, exp = 5, lawful = 1000, size = 'small', ranged = 1, passispeed = 1280, isErase = 1, light_size = 0, amount_fixed = 1 where npcid in (70582, 70583, 70606, 70608, 70622);
insert into spawnlist values (801500682, 'Neil', 1, 70582, 0, 33461, 32847, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500683, 'Nelson', 1, 70583, 0, 33458, 32856, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500684, 'Victor', 1, 70606, 0, 33458, 32863, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500685, 'Shalina', 1, 70608, 0, 33458, 32870, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500686, 'Eliza', 1, 70622, 0, 33458, 32863, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

-- Werldern roaming NPCs.
update npc set impl = 'L1Monster', lvl = 2, hp = 30, mp = 0, ac = 10, str = 5, con = 12, dex = 12, wis = 1, intel = 0, mr = 0, exp = 5, lawful = 1000, size = 'small', ranged = 1, passispeed = 1280, isErase = 1, light_size = 0, amount_fixed = 1 where npcid in (70647, 70648, 70659);
insert into spawnlist values (801500687, 'Gavin', 1, 70647, 0, 33723, 32496, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500688, 'Daley', 1, 70648, 0, 33712, 32491, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500689, 'Atara', 1, 70659, 0, 33711, 32504, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

-- SC roaming NPCs.
update npc set impl = 'L1Monster', lvl = 2, hp = 30, mp = 0, ac = 10, str = 5, con = 12, dex = 12, wis = 1, intel = 0, mr = 0, exp = 5, lawful = 1000, size = 'small', ranged = 1, passispeed = 1280, isErase = 1, light_size = 0, amount_fixed = 1 where npcid in (70901);
insert into spawnlist values (801500690, 'Jeti', 1, 70901, 0, 32863, 32895, 10, 10, 0, 0, 0, 0, 0, 120, 180, 304, 0, 100, 0, 0);

-- WW roaming NPCs.
update npc set impl = 'L1Monster', lvl = 2, hp = 30, mp = 0, ac = 10, str = 5, con = 12, dex = 12, wis = 1, intel = 0, mr = 0, exp = 5, lawful = 1000, size = 'small', ranged = 1, passispeed = 1280, isErase = 1, light_size = 0, amount_fixed = 1 where npcid in (70770);
insert into spawnlist values (801500706, 'Deker', 1, 70770, 0, 32612, 33195, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

-- OT roaming NPCs.
update npc set impl = 'L1Monster', lvl = 2, hp = 30, mp = 0, ac = 10, str = 5, con = 12, dex = 12, wis = 1, intel = 0, mr = 0, exp = 5, lawful = 1000, size = 'small', ranged = 1, passispeed = 1280, isErase = 1, light_size = 0, amount_fixed = 1 where npcid in (70812, 70814, 70819, 70821, 70825, 70828, 70833, 70834);
insert into spawnlist values (801500691, 'Rohan', 1, 70812, 0, 32736, 32438, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500692, 'Ruka', 1, 70814, 0, 32741, 32437, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500693, 'Bob', 1, 70819, 0, 32752, 32438, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500694, 'Sanita', 1, 70821, 0, 32751, 32443, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500695, 'Ellne', 1, 70825, 0, 32750, 32447, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500696, 'Ofo', 1, 70828, 0, 32742, 32451, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500697, 'Tommy', 1, 70833, 0, 32734, 32456, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500698, 'Torban', 1, 70834, 0, 32721, 32452, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

-- Checked live, and orc wizards are aggro to unpoly.
update npc set agro = 1 where npcid = 45121;
-- Minotaur (axe) are aggro to unpoly, sosc, and coi.
update npc set agro = 1, agrososc = 1, agrocoi = 1 where npcid = 45390;

-- De-uberfied OF spawnrate (to reduce AOE-spamfests).
update spawnlist set count = 15 where id = 801500422;
update spawnlist set count = 8 where id = 801500423;
update spawnlist set count = 15 where id = 801500424;
update spawnlist set count = 15 where id = 801500425;
update spawnlist set count = 15 where id = 801500426;
update spawnlist set count = 15 where id = 801500427;

-- EF roaming NPCs.
update npc set impl = 'L1Monster', lvl = 2, hp = 30, mp = 0, ac = 10, str = 5, con = 12, dex = 12, wis = 1, intel = 0, mr = 0, exp = 5, lawful = 1000, size = 'small', ranged = 1, passispeed = 1280, isErase = 1, light_size = 0, amount_fixed = 1 where npcid in (70839, 70854);
insert into spawnlist values (801500699, 'Doett', 1, 70839, 0, 33058, 32319, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500700, 'Hurindalien', 1, 70854, 0, 33069, 32330, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

-- Heine roaming NPCs.
update npc set impl = 'L1Monster', lvl = 2, hp = 30, mp = 0, ac = 10, str = 5, con = 12, dex = 12, wis = 1, intel = 0, mr = 0, exp = 5, lawful = 1000, size = 'small', ranged = 1, passispeed = 1280, isErase = 1, light_size = 0, amount_fixed = 1 where npcid in (70858, 70867, 70871, 70877, 70878);
insert into spawnlist values (801500701, 'Derick', 1, 70858, 0, 33615, 33253, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500702, 'Shannon', 1, 70867, 0, 33615, 33246, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500703, 'Annabel', 1, 70871, 0, 33615, 33239, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500704, 'Trion', 1, 70877, 0, 33615, 33232, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);
insert into spawnlist values (801500705, 'Felix', 1, 70878, 0, 33597, 33233, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

-- Add the Kent Castle Guard at the guard post by Kent bridge.
insert into spawnlist_npc values (1310418, 'Kent Castle Guard', 1, 71183, 32975, 32782, 0, 0, 4, 0, 4, 0);

-- Change a shop price.
update shop set purchasing_price = 25 where npc_id = 71127 and item_id = 40126;

-- Fix helm of speed purchasing price on some shops.
update shop set purchasing_price = 11000 where item_id = 20013 and purchasing_price = 1100;

-- Set all wand sell prices to 3a (like they are on live).
update shop set purchasing_price = 3 where item_id in (40006, 40007, 40008, 40009, 140006, 140008) and purchasing_price > 0;

-- Correct dwarvish iron helm sell price.
update shop set purchasing_price = 150 where item_id = 20007;

-- Add non-interactive arachne for Nerupa's cave.
insert into npc values (81246, 'Arachne', '$752', '', 'L1Guardian', 864, 30, 3000, 300, 0, 30, 30, 30, 30, 30, 70, 0, 0, 'small', 0, 2, 0, 420, 840, 0, 840, 840, 0, 0, 0, 1, 1, 1, '', 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
-- 2 aranches in Nerupa's cave
insert into spawnlist_npc values (1310419, 'Arachne', 2, 81246, 32739, 32800, 0, 0, 4, 0, 17, 0);

-- Merged in our missing npcactions.
INSERT INTO npcaction VALUES ('46069', 'minicod1', 'minicod1', '', '');
INSERT INTO npcaction VALUES ('46070', 'minicod3', 'minicod3', '', '');
INSERT INTO npcaction VALUES ('46077', 'minicod2', 'minicod2', '', '');
INSERT INTO npcaction VALUES ('46072', 'minicod2', 'minicod2', '', '');
INSERT INTO npcaction VALUES ('46076', 'minicod1', 'minicod1', '', '');
INSERT INTO npcaction VALUES ('46074', 'minicod2', 'minicod2', '', '');
INSERT INTO npcaction VALUES ('46075', 'minicod3', 'minicod3', '', '');
INSERT INTO npcaction VALUES ('46078', 'minicod1', 'minicod1', '', '');
INSERT INTO npcaction VALUES ('46079', 'minicod2', 'minicod2', '', '');
INSERT INTO npcaction VALUES ('46080', 'minicod1', 'minicod1', '', '');
INSERT INTO npcaction VALUES ('46081', 'minicod2', 'minicod2', '', '');
INSERT INTO npcaction VALUES ('46092', 'minitos3', 'minitos3', '', '');
INSERT INTO npcaction VALUES ('46093', 'minitos3', 'minitos3', '', '');
INSERT INTO npcaction VALUES ('46094', 'minitos2', 'minitos2', '', '');
INSERT INTO npcaction VALUES ('46095', 'minitos2', 'minitos2', '', '');
INSERT INTO npcaction VALUES ('46096', 'minitos1', 'minitos1', '', '');
INSERT INTO npcaction VALUES ('50083', 'en0231', 'en0231', '', '');
INSERT INTO npcaction VALUES ('70712', 'jennifer1', 'jennifer1', '', '');
update npcaction set normal_action = 'gdummy1', caotic_action = 'gdummy1' where npcid = 70881;
INSERT INTO npcaction VALUES ('70964', 'basch', 'basch', '', '');
INSERT INTO npcaction VALUES ('71049', 'rooney', 'rooney', '', '');
INSERT INTO npcaction VALUES ('71252', 'joegolem', 'joegolem', '', '');
INSERT INTO npcaction VALUES ('71253', 'joegolem17', 'joegolem17', '', '');
INSERT INTO npcaction VALUES ('71255', 'tebegate1', 'tebegate1', '', '');
INSERT INTO npcaction VALUES ('71256', 'robinhood1', 'robinhood1', '', '');
INSERT INTO npcaction VALUES ('71257', 'zybril1', 'zybril1', '', '');
INSERT INTO npcaction VALUES ('71258', 'marba3', 'marba1', '', '');
INSERT INTO npcaction VALUES ('71259', 'aras1', 'aras11', '', '');
INSERT INTO npcaction VALUES ('71264', 'sciairen1', 'sciairen2', '', '');
INSERT INTO npcaction VALUES ('71265', 'sinwarrior', 'sinwarrior', '', '');
INSERT INTO npcaction VALUES ('71266', 'gdummy1', 'gdummy1', '', '');
INSERT INTO npcaction VALUES ('71270', 'dunsign1', 'dunsign1', '', '');
INSERT INTO npcaction VALUES ('71271', 'dunboard2', 'dunboard2', '', '');
INSERT INTO npcaction VALUES ('71272', 'dunsign2', 'dunsign2', '', '');
INSERT INTO npcaction VALUES ('81200', 'nobelt', 'nobelt', '', '');
INSERT INTO npcaction VALUES ('81202', 'minitos08', 'minitos08', '', '');
INSERT INTO npcaction VALUES ('81203', 'minitos3', 'minitos3', '', '');
INSERT INTO npcaction VALUES ('81204', 'minitos3', 'minitos3', '', '');
INSERT INTO npcaction VALUES ('81205', 'minitos2', 'minitos2', '', '');
INSERT INTO npcaction VALUES ('81206', 'minitos2', 'minitos2', '', '');
INSERT INTO npcaction VALUES ('81207', 'minitos1', 'minitos1', '', '');
INSERT INTO npcaction VALUES ('81208', 'minibrob01', 'minibrob01', '', '');
INSERT INTO npcaction VALUES ('81241', 'cold1', 'cold1', '', '');
INSERT INTO npcaction VALUES ('81242', 'cold1', 'cold1', '', '');
INSERT INTO npcaction VALUES ('81243', 'cold1', 'cold1', '', '');
INSERT INTO npcaction VALUES ('81244', 'cold1', 'cold1', '', '');
INSERT INTO npcaction VALUES ('81246', 'sharna1', 'sharna2', '', '');
INSERT INTO npcaction VALUES ('80166', 'yuris1', 'yuris1', '', '');
INSERT INTO npcaction VALUES ('80167', 'churchm1', 'churchm1', '', '');
INSERT INTO npcaction VALUES ('80168', 'dufo', 'dufo', '', '');
INSERT INTO npcaction VALUES ('80213', 'gdummyc1', 'gdummyc1', '', '');
INSERT INTO npcaction VALUES ('91003', 'gr_mammon1', 'gr_mammon2', 'gr_mammon3', '');
INSERT INTO npcaction VALUES ('91005', 'adenshadow1', 'adenshadow1', '', '');
INSERT INTO npcaction VALUES ('91006', 'adenflora1', 'adenflora1', 'adenflora2', '');
INSERT INTO npcaction VALUES ('91007', 'amelia', 'amelia1', '', '');
INSERT INTO npcaction VALUES ('91050', 'veil1', 'veil1', '', '');
INSERT INTO npcaction VALUES ('91051', 'dragonsmap', 'dragonsmap', '', '');
INSERT INTO npcaction VALUES ('91056', 'bankoo1', 'bankoo1', '', '');
INSERT INTO npcaction VALUES ('91057', 'fivelviin1', 'fivelviin1', '', '');
INSERT INTO npcaction VALUES ('91058', 'fivelviin2', 'fivelviin2', '', '');
INSERT INTO npcaction VALUES ('91059', 'fivelviin3', 'fivelviin3', '', '');
INSERT INTO npcaction VALUES ('91060', 'fivelviin4', 'fivelviin4', '', '');
INSERT INTO npcaction VALUES ('91061', 'sherme2', 'sherme2', '', '');
INSERT INTO npcaction VALUES ('91062', 'grayknight1', 'grayknight1', '', '');
INSERT INTO npcaction VALUES ('91063', 'familyed', 'familyedl', 'pfamilyed', '');
INSERT INTO npcaction VALUES ('91064', 'ilbakiel', 'ilbakiel', '', '');
INSERT INTO npcaction VALUES ('91065', 'merlin1', 'merlin1', 'merlin2', '');
INSERT INTO npcaction VALUES ('91066', 'dsecret1', 'dsecret2', 'dsecret3', '');
INSERT INTO npcaction VALUES ('91184', 'dwfmerchant', 'dwfmerchant', '', '');
INSERT INTO npcaction VALUES ('91185', 'hankoo1', 'hankoo1', '', '');
INSERT INTO npcaction VALUES ('91327', 'j_html00', 'j_html00', '', '');
INSERT INTO npcaction VALUES ('91328', 'id0', 'id0', '', '');

-- Merge in our missing npcchat data.
INSERT INTO npcchat VALUES ('45931', '1', 'Spirit of Water', '0', '$5167', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45935', '0', 'Cursed Medusa', '0', '$5169', '', '', '', '', '0', '0', '0', '0', '10000', '0');
INSERT INTO npcchat VALUES ('45941', '1', 'Cursed Exorcist Saell', '0', '$5166', '', '', '', '', '0', '1', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45942', '0', 'Cursed Great Spirit of Water', '0', '$5170', '', '', '', '', '0', '1', '0', '0', '10000', '0');
INSERT INTO npcchat VALUES ('45943', '1', 'Kapu', '0', '$5165', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('46083', '0', 'Patrol 2', '0', '$5016', '', '', '', '', '0', '1', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('46098', '0', 'Patrol 2', '0', '$5014', '', '', '', '', '0', '1', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45577', '1', 'Brigade Commander Dark Fencer', '0', '$3892', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45607', '1', 'Evil Power Squad Leader Kybar', '0', '$3900', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45863', '1', 'Dread Queen Laia', '0', '$3908', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45676', '1', 'Bright Magic King Hellvine', '0', '$3923', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45648', '1', 'Slave of Assassin King', '0', '$3940', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45588', '1', 'Division Commander Sinclair', '0', '$3901', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45602', '1', 'Evil Magic Squad Leader Carmiel', '0', '$3903', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45608', '1', 'Mercenary Commander Mephaisto', '0', '$3930', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45612', '1', 'Temple Head Bounty', '0', '$3912', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45844', '1', 'Dread King Baranka', '0', '$3895', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45615', '1', 'Bright Magic Troup Leader Crepus', '0', '$3917', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45585', '1', 'Assassin Squad Leader Blaze', '0', '$3939', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45574', '1', 'Palace General Kyte', '0', '$3938', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45492', '1', 'Kuman', '0', '$3943', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45548', '1', 'Jose', '0', '$4030', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45955', '1', 'Supreme Court Justice Kenya', '0', '$4625', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45959', '1', 'Supreme Court Justice Edea', '0', '$4626', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45963', '1', 'New King Adjutant Cassandra', '0', '$3888', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('46157', '1', 'Orc Emissary', '0', '$6127', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('46158', '1', 'Orc Emissary', '0', '$6127', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('46159', '1', 'Orc Emissary', '0', '$6127', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('81175', '0', 'Wanted Criminal Kuzak', '0', '$5325', '', '', '', '', '0', '1', '0', '1', '15000', '0');
INSERT INTO npcchat VALUES ('81175', '1', 'Wanted Criminal Kuzak', '0', '$5327', '', '', '', '', '0', '0', '0', '0', '0', '0');
INSERT INTO npcchat VALUES ('45458', '1', 'Captain Drake', '0', '$3603', '', '', '', '', '0', '0', '0', '0', '0', '0');

-- Move our custom RK set to a higher ID, as it clobbered some new set.
update armor_set set id = 75 where id = 55;
-- Reinsert set 55.
INSERT INTO armor_set VALUES ('55', '', '21061', '5484', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');

-- An attempt at merging the dungeon table.  There's definitely a lot of
-- changes, but I also don't want to clobber our fixes.  These entries are
-- completely new.
INSERT INTO `dungeon` VALUES ('32810', '32890', '780', '32742', '32800', '781', '4', '');
INSERT INTO `dungeon` VALUES ('32810', '32891', '780', '32742', '32800', '781', '4', '');
INSERT INTO `dungeon` VALUES ('32742', '32800', '781', '32810', '32890', '780', '6', '');
INSERT INTO `dungeon` VALUES ('32786', '32861', '1000', '34090', '32168', '4', '10', '');
INSERT INTO `dungeon` VALUES ('32786', '32862', '1000', '34091', '32167', '4', '10', '');
INSERT INTO `dungeon` VALUES ('32787', '32862', '1000', '34090', '32165', '4', '10', '');
INSERT INTO `dungeon` VALUES ('32802', '32877', '1000', '34094', '32170', '4', '10', '');
INSERT INTO `dungeon` VALUES ('32802', '32878', '1000', '34093', '32169', '4', '10', '');
INSERT INTO `dungeon` VALUES ('32803', '32878', '1000', '34093', '32167', '4', '10', '');
INSERT INTO `dungeon` VALUES ('32779', '32857', '1001', '33639', '32400', '4', '10', '');
INSERT INTO `dungeon` VALUES ('32780', '32858', '1001', '33641', '32402', '4', '10', '');
INSERT INTO `dungeon` VALUES ('32810', '32887', '1001', '33640', '32400', '4', '10', '');
INSERT INTO `dungeon` VALUES ('32811', '32888', '1001', '33641', '32401', '4', '10', '');
INSERT INTO `dungeon` VALUES ('32624', '32725', '1005', '32671', '32667', '1005', '1', '');
INSERT INTO `dungeon` VALUES ('32679', '32745', '1005', '32937', '32802', '1005', '1', '');
INSERT INTO `dungeon` VALUES ('32680', '32743', '1005', '32809', '32802', '1005', '1', '');
INSERT INTO `dungeon` VALUES ('32681', '32742', '1005', '32681', '32802', '1005', '1', '');
INSERT INTO `dungeon` VALUES ('32682', '32741', '1005', '32937', '32610', '1005', '1', '');
INSERT INTO `dungeon` VALUES ('32683', '32924', '1005', '32658', '32678', '1005', '1', '');
INSERT INTO `dungeon` VALUES ('32703', '32670', '1005', '32796', '32662', '1005', '1', '');
INSERT INTO `dungeon` VALUES ('32811', '32924', '1005', '32658', '32678', '1005', '1', '');
INSERT INTO `dungeon` VALUES ('32939', '32924', '1005', '32658', '32678', '1005', '1', '');
INSERT INTO `dungeon` VALUES ('32939', '32732', '1005', '32658', '32678', '1005', '1', '');

-- New getback records.
INSERT INTO getback VALUES ('0', '0', '0', '0', '780', '32639', '32876', '32639', '32876', '32639', '32876', '780', '0', '0', '0', '0', '');
INSERT INTO getback VALUES ('0', '0', '0', '0', '781', '32639', '32876', '32639', '32876', '32639', '32876', '780', '0', '0', '0', '0', '');
INSERT INTO getback VALUES ('0', '0', '0', '0', '782', '32639', '32876', '32639', '32876', '32639', '32876', '780', '0', '0', '0', '0', '');
INSERT INTO getback VALUES ('0', '0', '0', '0', '783', '32879', '32750', '32879', '32750', '32879', '32750', '783', '0', '0', '0', '1', '');
INSERT INTO getback VALUES ('0', '0', '0', '0', '784', '32879', '32750', '32879', '32750', '32879', '32750', '783', '0', '0', '0', '1', '');
INSERT INTO getback VALUES ('0', '0', '0', '0', '1002', '32820', '32904', '32820', '32904', '32820', '32904', '1002', '0', '0', '0', '1', '');
INSERT INTO getback VALUES ('0', '0', '0', '0', '2005', '32688', '32873', '32675', '32863', '32691', '32862', '2005', '0', '0', '0', '1', '');

-- New getback_restart records.
INSERT INTO getback_restart VALUES ('53', '', '33426', '32823', '4');
INSERT INTO getback_restart VALUES ('54', '', '33426', '32823', '4');
INSERT INTO getback_restart VALUES ('55', '', '33426', '32823', '4');
INSERT INTO getback_restart VALUES ('56', '', '33426', '32823', '4');
INSERT INTO getback_restart VALUES ('777', '', '34043', '32184', '4');
INSERT INTO getback_restart VALUES ('779', '', '32608', '33178', '4');
INSERT INTO getback_restart VALUES ('780', '', '33966', '33253', '4');
INSERT INTO getback_restart VALUES ('781', '', '33966', '33253', '4');
INSERT INTO getback_restart VALUES ('782', '', '33966', '33253', '4');
INSERT INTO getback_restart VALUES ('783', '', '32795', '32751', '783');
INSERT INTO getback_restart VALUES ('784', '', '32795', '32751', '783');
INSERT INTO getback_restart VALUES ('1002', '', '33705', '32504', '4');
INSERT INTO getback_restart VALUES ('2005', '', '32691', '32864', '2005');
INSERT INTO getback_restart VALUES ('5143', '', '32628', '32772', '4');

-- Need to move our custom mobgroups up in ID to make room for the new ones.
update mobgroup set id = 172 where id = 72;
update mobgroup set id = 173 where id = 73;
update mobgroup set id = 174 where id = 74;
update mobgroup set id = 175 where id = 75;
update mobgroup set id = 176 where id = 76;
-- Update all spawns that use the above groups.
update spawnlist set group_id = 172 where group_id = 72;
update spawnlist set group_id = 173 where group_id = 73;
update spawnlist set group_id = 174 where group_id = 74;
update spawnlist set group_id = 175 where group_id = 75;
update spawnlist set group_id = 176 where group_id = 76;

-- New mobgroup records.
INSERT INTO mobgroup VALUES ('52', '', '0', '46082', '46083', '1', '46084', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('53', '', '0', '46085', '46086', '1', '46087', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('54', '', '0', '46088', '46089', '1', '46090', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('55', '', '0', '46097', '46098', '1', '46099', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('56', '', '0', '46100', '46101', '1', '46102', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('57', '', '0', '46103', '46104', '1', '46105', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('58', '', '0', '45539', '45501', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('59', '', '0', '45539', '45502', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('60', '', '0', '45422', '45297', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('61', '', '0', '45423', '45374', '3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('62', '', '0', '45603', '45537', '1', '45530', '1', '45498', '1', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('63', '', '0', '46107', '46107', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('64', '', '0', '46135', '46135', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('65', '', '0', '46138', '46138', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('66', '', '0', '46139', '46139', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('67', '', '0', '46137', '46137', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('68', '', '0', '46141', '46140', '3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('69', '', '0', '45448', '45836', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('70', '', '0', '45315', '45647', '1', '45579', '1', '45569', '1', '45482', '1', '45450', '1', '45391', '1', '0', '0');
INSERT INTO mobgroup VALUES ('71', '', '0', '45570', '45571', '1', '45582', '1', '45587', '1', '45605', '1', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('72', '', '1', '46157', '46160', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('73', '', '1', '46158', '46160', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('74', '', '1', '46159', '46160', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('75', '', '0', '45624', '45628', '2', '45629', '1', '45630', '1', '45596', '2', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('76', '', '0', '45623', '45631', '2', '45632', '4', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('77', '', '0', '91266', '91265', '2', '91266', '2', '91267', '2', '91268', '2', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('78', '', '0', '91272', '91273', '2', '91270', '1', '91271', '3', '91276', '1', '91274', '1', '91275', '1', '0', '0');
INSERT INTO mobgroup VALUES ('79', '', '0', '91272', '91273', '4', '91270', '3', '91271', '3', '91274', '1', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('80', '', '0', '91271', '91273', '2', '91270', '2', '91271', '1', '91274', '4', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('81', '', '0', '91272', '91273', '1', '91271', '2', '91276', '3', '91275', '2', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('82', '', '0', '91269', '91273', '2', '91270', '3', '91271', '2', '91276', '1', '91274', '1', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('83', '', '0', '91270', '91273', '1', '91270', '1', '91271', '2', '91272', '1', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('84', '', '0', '91273', '91273', '1', '91271', '3', '91276', '2', '91274', '2', '91275', '3', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('86', '', '0', '91340', '91340', '1', '45278', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('85', '', '0', '91341', '91340', '2', '91341', '2', '91342', '2', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO mobgroup VALUES ('87', '', '0', '91341', '91341', '1', '45298', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');

-- New polymorphs records.
INSERT INTO `polymorphs` VALUES ('6894', 'awake', '6894', '1', '751', '4095', '1', '7');
INSERT INTO `polymorphs` VALUES ('7338', 'spearm 55', '7338', '55', '1040', '4095', '1', '7');
INSERT INTO `polymorphs` VALUES ('7339', 'spearm 60', '7339', '60', '1040', '4095', '1', '7');
INSERT INTO `polymorphs` VALUES ('7340', 'spearm 65', '7340', '65', '1040', '4095', '1', '7');
INSERT INTO `polymorphs` VALUES ('7341', 'spearm 70', '7341', '70', '1040', '4095', '1', '7');
INSERT INTO `polymorphs` VALUES ('7332', 'spearm 52', '7332', '50', '1040', '4095', '1', '7');

-- Merge in latest skills changes.
-- Fix life stream fail msg (should fix issue 50).
update skills set sysmsgID_fail = 0 where skill_id = 63;
-- AS duration increase.
update skills set buffDuration = 1800 where skill_id = 79;
-- Bounce attack should consume 120 HP.
update skills set hpConsume = 120 where skill_id = 89;
-- Correct protection from elemental's cost.
update skills set mpConsume = 6, hpConsume = 0 where skill_id = 147;

-- Merge latest mobskill changes.
INSERT INTO `mobskill` VALUES ('45309', '0', 'Black Tiger', '', '1', '50', '0', '0', '-2', '0', '0', '2', '0', '0', '0', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45323', '0', 'Beast Summoner', '', '1', '50', '0', '0', '-2', '0', '0', '2', '0', '0', '2', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45357', '0', 'Black Tiger', '', '1', '50', '0', '0', '-2', '0', '0', '2', '0', '0', '0', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45374', '0', 'Subterranean Lizardman', '', '2', '100', '0', '0', '-6', '0', '0', '6', '0', '0', '0', '10133', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45382', '0', 'Subterranean Scormystic', '', '1', '50', '0', '0', '-2', '0', '0', '2', '0', '0', '0', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45383', '0', 'Subterranean Scorpaitan', '', '1', '50', '0', '0', '-2', '0', '0', '2', '0', '0', '0', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45423', '0', 'Subterranean Beholder', '', '2', '25', '0', '0', '-4', '0', '0', '4', '0', '0', '0', '167', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45448', '0', 'Lastabad Tormenter', '', '1', '50', '0', '0', '-2', '0', '0', '2', '0', '0', '2', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45483', '0', 'Black Tiger', '', '1', '50', '0', '0', '-2', '0', '0', '2', '0', '0', '0', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45498', '0', 'Grave Guardian', '', '1', '50', '0', '0', '0', '0', '0', '2', '0', '0', '0', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45530', '0', 'Grave Guardian Mage', '', '1', '45', '0', '0', '0', '0', '0', '2', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45530', '1', 'Grave Guardian Mage', '', '1', '50', '0', '0', '0', '0', '0', '2', '0', '0', '0', '0', '0', '18', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45530', '2', 'Grave Guardian Mage', '', '2', '85', '0', '0', '-6', '0', '0', '0', '0', '0', '45', '10136', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45537', '0', 'Grave Guardian Knight', '', '1', '50', '0', '0', '0', '0', '0', '2', '0', '0', '0', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45574', '0', 'Palace General Kyte', '', '2', '80', '0', '0', '-8', '0', '0', '0', '0', '0', '12', '10104', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45588', '1', 'Division Commander Sinclair', '', '2', '30', '0', '0', '-15', '0', '0', '0', '0', '0', '30', '10107', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45602', '0', 'Evil Magic Squad Leader Carmiel', '', '2', '80', '0', '0', '-8', '0', '0', '0', '0', '0', '12', '10105', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45603', '0', 'Large Grave Guardian', '', '1', '50', '0', '0', '0', '0', '0', '5', '0', '0', '0', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45612', '0', 'Temple Head Bounty', '', '2', '80', '0', '0', '-8', '0', '0', '0', '0', '0', '15', '10103', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45727', '1', 'Grave Sea Dancer', '', '2', '100', '0', '0', '-10', '0', '0', '0', '0', '0', '20', '10097', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45743', '0', 'Sand Tomb', '', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '20', '0', '0', '18', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45812', '1', 'Sea Dancer', '', '2', '100', '0', '0', '-10', '0', '0', '8', '0', '0', '0', '10097', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45836', '0', 'Black Tiger', '', '1', '50', '0', '0', '-2', '0', '0', '2', '0', '0', '0', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45837', '0', 'Lastabad Tormenter', '', '1', '50', '0', '0', '-2', '0', '0', '2', '0', '0', '2', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45845', '0', 'Dark Elementalist', '', '2', '100', '0', '0', '-3', '4', '0', '3', '0', '0', '0', '10091', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45852', '0', 'Dark Elementalist', '', '2', '100', '0', '0', '-3', '4', '0', '3', '0', '0', '0', '10091', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45926', '0', 'Cursed Beholder', '', '2', '50', '0', '0', '-2', '0', '0', '0', '0', '0', '0', '10101', '0', '18', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45931', '0', 'Spirit of Water', '', '2', '30', '0', '0', '-10', '0', '0', '0', '0', '0', '20', '6', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45931', '1', 'Spirit of Water', '', '3', '50', '0', '0', '-2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '45932', '2', '2', '0');
INSERT INTO `mobskill` VALUES ('45935', '0', 'Cursed Medusa', '', '2', '50', '0', '0', '-2', '0', '0', '0', '0', '0', '0', '10101', '0', '18', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45936', '0', 'Eva Sea Dancer', '', '2', '100', '0', '0', '-10', '0', '0', '10', '0', '0', '0', '10096', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45936', '1', 'Eva Sea Dancer', '', '2', '100', '0', '0', '-10', '0', '0', '8', '0', '0', '0', '10097', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45938', '0', 'Eva Elekkadom', '', '1', '80', '0', '0', '-3', '0', '0', '2', '5', '5', '20', '0', '0', '18', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45941', '0', 'Cursed Exorcist Saell', '', '2', '50', '0', '0', '-1', '0', '0', '1', '0', '0', '10', '10100', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45942', '0', 'Cursed Great Spirit of Water', '', '2', '60', '0', '0', '-6', '0', '0', '0', '0', '0', '0', '38', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45943', '0', 'Kapu', '', '2', '50', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10098', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45945', '2', 'Cleaning Ant', '', '1', '100', '1', '0', '-1', '0', '0', '1', '7', '7', '300', '0', '5793', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45955', '0', 'Supreme Court Justice Kenya', '', '2', '60', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10113', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45955', '1', 'Supreme Court Justice Kenya', '', '2', '15', '0', '0', '-5', '0', '0', '0', '0', '0', '0', '10117', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45955', '2', 'Supreme Court Justice Kenya', '', '1', '100', '0', '0', '-2', '0', '0', '2', '0', '0', '20', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45956', '0', 'Supreme Court Justice Viatas', '', '2', '15', '0', '0', '-5', '0', '0', '0', '0', '0', '0', '10116', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45956', '1', 'Supreme Court Justice Viatas', '', '1', '100', '0', '0', '-2', '0', '0', '2', '0', '0', '20', '0', '5367', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45957', '0', 'Supreme Court Justice Baromes', '', '2', '10', '0', '0', '-5', '0', '0', '0', '0', '0', '7', '10109', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45957', '1', 'Supreme Court Justice Baromes', '', '2', '10', '0', '0', '-7', '0', '0', '0', '0', '0', '8', '10115', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45957', '2', 'Supreme Court Justice Baromes', '', '1', '100', '0', '0', '-1', '0', '0', '0', '0', '0', '20', '0', '5480', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45958', '0', 'Supreme Court Justice Endias', '', '2', '15', '0', '0', '-5', '0', '0', '0', '0', '0', '0', '10114', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45958', '1', 'Supreme Court Justice Endias', '', '1', '100', '0', '0', '-8', '0', '0', '8', '0', '0', '20', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45959', '0', 'Supreme Court Justice Edea', '', '2', '60', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10113', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45959', '1', 'Supreme Court Justice Edea', '', '1', '100', '0', '0', '-2', '0', '0', '2', '0', '0', '30', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45960', '0', 'Supreme Court Justice Tiames', '', '2', '60', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10111', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45960', '1', 'Supreme Court Justice Tiames', '', '2', '15', '0', '0', '-15', '0', '0', '0', '0', '0', '30', '10112', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45960', '2', 'Supreme Court Justice Tiames', '', '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '30', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45961', '0', 'Supreme Court Justice Ramias', '', '2', '30', '0', '0', '-5', '0', '0', '0', '0', '0', '0', '10110', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45961', '1', 'Supreme Court Justice Ramias', '', '3', '20', '50', '0', '-3', '10', '0', '0', '0', '0', '0', '0', '0', '0', '45483', '1', '1', '0');
INSERT INTO `mobskill` VALUES ('45961', '2', 'Supreme Court Justice Ramias', '', '3', '20', '50', '0', '-3', '10', '0', '0', '0', '0', '0', '0', '0', '0', '45512', '1', '1', '0');
INSERT INTO `mobskill` VALUES ('45961', '3', 'Supreme Court Justice Ramias', '', '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '30', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45962', '0', 'Supreme Court Justice Barode', '', '2', '60', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10108', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45962', '1', 'Supreme Court Justice Barode', '', '2', '10', '0', '0', '-5', '0', '0', '0', '0', '0', '0', '10109', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45962', '2', 'Supreme Court Justice Barode', '', '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '20', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45963', '0', 'New King Adjutant Cassandra', '', '2', '80', '0', '0', '-8', '0', '0', '0', '0', '0', '12', '10104', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45980', '0', 'Lastabad Tormenter', '', '1', '50', '0', '0', '-2', '0', '0', '2', '0', '0', '2', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45982', '0', 'Dark Forester', '', '2', '100', '0', '0', '-6', '5', '0', '6', '0', '0', '0', '10093', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45991', '0', 'Dark Elementalist', '', '2', '100', '0', '0', '-3', '4', '0', '3', '0', '0', '0', '10091', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45994', '0', 'Elder Attendant', '', '2', '80', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10102', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45995', '0', 'Elder Attendant', '', '2', '80', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10103', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45998', '0', 'Elder Attendant', '', '2', '80', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10102', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45999', '0', 'Elder Attendant', '', '2', '80', '0', '0', '-8', '0', '0', '0', '0', '0', '11', '10103', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46002', '0', 'Elder Attendant', '', '2', '80', '0', '0', '-8', '0', '0', '0', '0', '0', '9', '10102', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46003', '0', 'Elder Attendant', '', '2', '80', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10103', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46004', '0', 'Elder Attendant', '', '2', '80', '0', '0', '-8', '0', '0', '0', '0', '0', '11', '10103', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46007', '0', 'Elder Attendant', '', '2', '80', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10103', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46053', '0', 'Evil Spirit of Ship', '', '3', '5', '0', '0', '-3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '45722', '1', '2', '0');
INSERT INTO `mobskill` VALUES ('46062', '0', 'Cursed Dark Elf Warrior', '', '2', '15', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '87', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46062', '1', 'Cursed Dark Elf Warrior', '', '2', '60', '0', '0', '-6', '0', '0', '0', '0', '0', '0', '10119', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46063', '0', 'Cursed Dark Elf Wizard', '', '2', '60', '0', '0', '-10', '0', '0', '0', '0', '0', '0', '10120', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46064', '0', 'Cursed Dark Elf Knight', '', '2', '15', '0', '0', '-6', '0', '0', '0', '0', '0', '0', '10121', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46064', '2', 'Cursed Dark Elf Knight', '', '2', '15', '0', '0', '-4', '0', '0', '0', '0', '0', '0', '10123', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46064', '1', 'Cursed Dark Elf Knight', '', '2', '15', '0', '0', '-7', '0', '0', '0', '0', '0', '0', '10122', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46065', '0', 'Otyu', '', '2', '60', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10124', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46066', '0', 'Tyupon', '', '2', '30', '0', '0', '-5', '0', '0', '0', '0', '0', '0', '10125', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46067', '0', 'Wyvern', '', '2', '30', '0', '0', '-4', '0', '0', '0', '0', '0', '20', '53', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46069', '0', 'Unchosen One', '', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '10', '0', '0', '18', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46070', '0', 'Unchosen One', '', '2', '20', '0', '0', '-4', '0', '0', '0', '0', '0', '5', '53', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46071', '0', 'Unchosen One', '', '2', '100', '0', '0', '-8', '0', '0', '0', '0', '0', '2', '10065', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46072', '0', 'Unchosen One', '', '2', '20', '0', '0', '-4', '0', '0', '0', '0', '0', '5', '53', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46073', '0', 'Unchosen One', '', '2', '100', '0', '0', '-8', '0', '0', '0', '0', '0', '2', '10066', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46078', '0', 'Unchosen One', '', '2', '20', '0', '0', '-5', '0', '0', '5', '1', '5', '0', '10067', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46079', '0', 'Unchosen One', '', '2', '20', '0', '0', '-5', '0', '0', '5', '1', '5', '0', '10068', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46082', '0', 'Patrol 1', '', '2', '50', '0', '0', '-2', '0', '0', '0', '0', '0', '0', '10042', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46082', '1', 'Patrol 1', '', '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '10', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46083', '0', 'Patrol 2', '', '2', '50', '0', '0', '-2', '0', '0', '0', '0', '0', '0', '10042', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46083', '1', 'Patrol 2', '', '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '10', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46084', '0', 'Patrol 3', '', '2', '50', '0', '0', '-2', '0', '0', '0', '0', '0', '0', '10042', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46084', '1', 'Patrol 3', '', '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '10', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46085', '0', 'Patrol 4', '', '2', '50', '0', '0', '-2', '0', '0', '0', '0', '0', '0', '10042', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46085', '1', 'Patrol 4', '', '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '10', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46086', '0', 'Patrol 5', '', '2', '50', '0', '0', '-2', '0', '0', '0', '0', '0', '0', '10042', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46086', '1', 'Patrol 5', '', '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '10', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46087', '0', 'Patrol 6', '', '2', '50', '0', '0', '-2', '0', '0', '0', '0', '0', '0', '10042', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46087', '1', 'Patrol 6', '', '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '10', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46088', '0', 'Patrol 7', '', '2', '50', '0', '0', '-2', '0', '0', '0', '0', '0', '0', '10042', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46088', '1', 'Patrol 7', '', '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '10', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46089', '0', 'Patrol 8', '', '2', '50', '0', '0', '-2', '0', '0', '0', '0', '0', '0', '10042', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46089', '1', 'Patrol 8', '', '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '10', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46090', '0', 'Patrol 9', '', '2', '50', '0', '0', '-2', '0', '0', '0', '0', '0', '0', '10042', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46090', '1', 'Patrol 9', '', '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '10', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46091', '0', 'Guard', '', '2', '50', '0', '0', '-2', '0', '0', '0', '0', '0', '0', '10042', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46091', '1', 'Guard', '', '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '10', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46093', '0', 'Unchosen One', '', '2', '100', '0', '0', '2', '0', '0', '0', '0', '0', '0', '10060', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46094', '0', 'Unchosen One', '', '2', '100', '0', '0', '3', '0', '0', '0', '0', '0', '10', '45', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46095', '0', 'Unchosen One', '', '2', '100', '0', '0', '3', '0', '0', '0', '0', '0', '0', '10059', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46096', '0', 'Unchosen One', '', '2', '20', '0', '0', '5', '0', '0', '0', '0', '0', '0', '10057', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('46096', '1', 'Unchosen One', '', '2', '100', '0', '0', '2', '0', '0', '0', '0', '0', '0', '10058', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('60563', '0', 'Heine Guard', '', '2', '100', '0', '0', '-10', '0', '0', '10', '0', '0', '0', '10145', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('70857', '0', 'Heine Guard', '', '2', '100', '0', '0', '-10', '0', '0', '10', '0', '0', '0', '10145', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81163', '0', 'Girtas', '', '2', '100', '18', '0', '-15', '0', '0', '0', '0', '0', '20', '10130', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81163', '1', 'Girtas', '', '2', '10', '0', '0', '-15', '0', '0', '0', '0', '0', '80', '10126', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81163', '2', 'Girtas', '', '2', '20', '0', '0', '0', '0', '0', '0', '0', '0', '0', '10128', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81163', '3', 'Girtas', '', '2', '20', '0', '0', '0', '0', '0', '0', '0', '0', '15', '10129', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81163', '4', 'Girtas', '', '2', '20', '0', '0', '0', '0', '0', '0', '0', '0', '40', '10127', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81163', '5', 'Girtas', '', '1', '60', '0', '0', '0', '0', '0', '3', '0', '0', '30', '0', '0', '5', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81163', '6', 'Girtas', '', '1', '100', '0', '0', '0', '0', '0', '3', '0', '0', '30', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81224', '0', 'High Lizardman', '', '2', '100', '0', '0', '-6', '0', '0', '0', '0', '0', '0', '10135', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81231', '0', 'Giant Guardian Ant', '', '1', '100', '0', '0', '-3', '0', '0', '3', '0', '0', '15', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81236', '0', 'Otyu', '', '2', '60', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10124', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81237', '0', 'Hell Bound', '', '1', '100', '0', '0', '2', '2', '0', '2', '0', '0', '30', '0', '4646', '3', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81238', '0', 'Doppelganger', '', '2', '30', '0', '0', '-6', '0', '0', '0', '0', '0', '0', '10035', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81238', '1', 'Doppelganger', '', '2', '30', '0', '0', '-6', '0', '0', '0', '0', '0', '30', '16', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81238', '2', 'Doppelganger', '', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '30', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81239', '1', 'Greater Minotaur', '', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '30', '0', '0', '0', '0', '0', '0', '0');

-- Fix some unchosen one skills.
update skills set castgfx = 4696 where skill_id = 10058;
update skills set castgfx = 4655 where skill_id = 10059;
-- Fix bomb flower graphic to prevent crashes.
update skills set castgfx = 1991 where skill_id = 10034;
-- Re-add bomb flower skill.
INSERT INTO `mobskill` VALUES ('45263', '0', 'Bomb Flower', '10 cell ranged', '2', '100', '0', '0', '-10', '0', '0', '10', '0', '0', '0', '10034', '0', '0', '0', '0', '0', '0');
