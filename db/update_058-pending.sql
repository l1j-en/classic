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
insert into spawnlist values (801500690, 'Deker', 1, 70770, 0, 32612, 33195, 10, 10, 0, 0, 0, 0, 0, 120, 180, 4, 0, 100, 0, 0);

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

