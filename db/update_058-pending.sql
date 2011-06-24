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
