-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 59

-- Fixed Orc Emissary respawn delay and loc --
update spawnlist set locx = '32721' where id = 400001;
update spawnlist set locy = '32384' where id = 400001;
update spawnlist set min_respawn_delay = '240' where id = 400001;
update spawnlist set max_respawn_delay = '420' where id = 400001;
update spawnlist set locx = '32674' where id = 400002;
update spawnlist set locy = '32571' where id = 400002;
update spawnlist set min_respawn_delay = '240' where id = 400002;
update spawnlist set max_respawn_delay = '420' where id = 400002;
update spawnlist set locx = '32631' where id = 400003;
update spawnlist set locy = '33105' where id = 400003;
update spawnlist set min_respawn_delay = '240' where id = 400003;
update spawnlist set max_respawn_delay = '420' where id = 400003;

-- Miscellaneous NPC fixes.
-- Fix wind spirit master's family.
update npc set family = 'spiritwind' where npcid = 45510;
-- AG hpr semi-denerf.
update npc set hpr = 200 where npcid = 45610;
-- Phoenix hpr semi-denerf.
update npc set hpr = 350 where npcid = 45617;
-- Knight Vlad hpr semi-denerf.
update npc set hpr = 320 where npcid = 45618;

-- More npc table merges.
update npc set alt_atk_speed = 1800, IsErase = 0 where npcid = 45483;
update npc set lvl = 42, hp = 110, exp = 0, lawful = 0, alt_atk_speed = 1920, transform_id = 45847, transform_gfxid = 5306, light_size = 9 where npcid = 45484;
update npc set alt_atk_speed = 720, undead = 5 where npcid = 45485;
update npc set alt_atk_speed = 1080 where npcid = 45486;
update npc set alt_atk_speed = 960 where npcid = 45487;
update npc set alt_atk_speed = 800 where npcid = 45488;
update npc set exp = 0, lawful = 0, alt_atk_speed = 1480 where npcid = 45489;
update npc set alt_atk_speed = 880 where npcid = 45490;
update npc set alt_atk_speed = 960 where npcid = 45491;
update npc set alt_atk_speed = 960 where npcid = 45492;
update npc set alt_atk_speed = 840 where npcid = 45493;
update npc set alt_atk_speed = 920 where npcid = 45494;
update npc set exp = 0, lawful = 0, alt_atk_speed = 1120 where npcid = 45495;
update npc set alt_atk_speed = 800 where npcid = 45497;
update npc set ac = -50, alt_atk_speed = 1000 where npcid = 45498;
update npc set alt_atk_speed = 760 where npcid = 45503;
update npc set alt_atk_speed = 1320 where npcid = 45504;
update npc set gfxid = 2356, passispeed = 440, atkspeed = 760, alt_atk_speed = 1240, atk_magic_speed = 1080, sub_magic_speed = 1080, bravespeed = 0 where npcid = 45505;
update npc set alt_atk_speed = 1600 where npcid = 45506;
update npc set alt_atk_speed = 1840 where npcid = 45507;
update npc set alt_atk_speed = 2080 where npcid = 45508;
update npc set gfxid = 2358, passispeed = 480, atkspeed = 640, alt_atk_speed = 720, atk_magic_speed = 640, sub_magic_speed = 640, bravespeed = 0 where npcid = 45509;
update npc set alt_atk_speed = 1280 where npcid = 45511;
update npc set alt_atk_speed = 1320 where npcid = 45512;
update npc set alt_atk_speed = 1440 where npcid = 45514;
update npc set cant_resurrect = 1 where npcid = 45516;
update npc set alt_atk_speed = 1440 where npcid = 45517;
update npc set gfxid = 4744, passispeed = 960, atkspeed = 1040, alt_atk_speed = 1480, atk_magic_speed = 1800, sub_magic_speed = 1800 where npcid = 45518;
update npc set alt_atk_speed = 1440 where npcid = 45519;
update npc set ranged = 0, alt_atk_speed = 1000, atk_magic_speed = 1440, sub_magic_speed = 1440 where npcid = 45520;
update npc set alt_atk_speed = 1600 where npcid = 45521;
update npc set alt_atk_speed = 1440 where npcid = 45523;
update npc set alt_atk_speed = 1400 where npcid = 45524;
update npc set alt_atk_speed = 1760 where npcid = 45526;
update npc set alt_atk_speed = 1120, IsTU = 1 where npcid = 45527;
update npc set alt_atk_speed = 1400 where npcid = 45528;
update npc set alt_atk_speed = 1920, cant_resurrect = 1 where npcid = 45529;
update npc set alt_atk_speed = 1000 where npcid = 45530;
update npc set gfxid = 2359, passispeed = 620, atkspeed = 860, atk_magic_speed = 1180, sub_magic_speed = 1180, bravespeed = 0 where npcid = 45531;
update npc set alt_atk_speed = 1320 where npcid = 45532;
update npc set lvl = 41, hp = 1080, exp = 1682, ac = -25, alt_atk_speed = 1400 where npcid = 45533;
update npc set alt_atk_speed = 1440, family = 'pirate', agrofamily = 1 where npcid = 45534;
update npc set alt_atk_speed = 1480, family = 'spirit' where npcid = 45535;
update npc set alt_atk_speed = 1200 where npcid = 45536;
update npc set alt_atk_speed = 1120 where npcid = 45537;
update npc set gfxid = 2361, passispeed = 640, atkspeed = 780, alt_atk_speed = 1120, atk_magic_speed = 780, sub_magic_speed = 780, bravespeed = 0 where npcid = 45538;
update npc set alt_atk_speed = 2080 where npcid = 45539;
update npc set alt_atk_speed = 1480 where npcid = 45540;
update npc set alt_atk_speed = 1280 where npcid = 45541;
update npc set alt_atk_speed = 880 where npcid = 45543;
update npc set alt_atk_speed = 880 where npcid = 45544;
update npc set alt_atk_speed = 800, cant_resurrect = 1 where npcid = 45545;
update npc set alt_atk_speed = 600 where npcid = 45548;
update npc set alt_atk_speed = 800 where npcid = 45550;
update npc set alt_atk_speed = 1280 where npcid = 45552;
update npc set alt_atk_speed = 1680 where npcid = 45553;
update npc set alt_atk_speed = 1280 where npcid = 45554;
update npc set passispeed = 1440, atkspeed = 880, alt_atk_speed = 880 where npcid = 45555;
update npc set alt_atk_speed = 1640 where npcid = 45556;
update npc set alt_atk_speed = 1720 where npcid = 45562;
update npc set alt_atk_speed = 2240 where npcid = 45564;
update npc set hp = 1500, lawful = -5, alt_atk_speed = 800, light_size = 14 where npcid = 45569;
update npc set hp = 1500, lawful = -5, alt_atk_speed = 960, light_size = 14 where npcid = 45570;
update npc set hp = 1500, lawful = -5, passispeed = 960, alt_atk_speed = 1480, light_size = 14 where npcid = 45571;
update npc set alt_atk_speed = 1800 where npcid = 45572;
update npc set alt_atk_speed = 800 where npcid = 45573;
update npc set ranged = 1, bowActId = 0 where npcid = 45574;
update npc set alt_atk_speed = 960 where npcid = 45576;
update npc set alt_atk_speed = 1080 where npcid = 45577;
update npc set gfxid = 2362, passispeed = 280, atkspeed = 640, alt_atk_speed = 1920, atk_magic_speed = 960, sub_magic_speed = 960, bravespeed = 0 where npcid = 45578;
update npc set hp = 1600, lawful = -5, alt_atk_speed = 800, hpr = 150, mpr = 40, light_size = 14 where npcid = 45579;
update npc set alt_atk_speed = 1080 where npcid = 45580;
update npc set hp = 1800, ac = -63, lawful = -5, alt_atk_speed = 1080, light_size = 14 where npcid = 45582;
update npc set alt_atk_speed = 800 where npcid = 45583;
update npc set alt_atk_speed = 1360 where npcid = 45585;
update npc set hp = 2100, lawful = -5, alt_atk_speed = 1040, light_size = 14 where npcid = 45587;
update npc set gfxid = 4854, ranged = 1, bowActId = 0 where npcid = 45588;
update npc set alt_atk_speed = 1320 where npcid = 45590;
update npc set alt_atk_speed = 1920 where npcid = 45595;
update npc set alt_atk_speed = 1200 where npcid = 45596;
update npc set alt_atk_speed = 1480 where npcid = 45597;
update npc set alt_atk_speed = 1120 where npcid = 45598;
update npc set alt_atk_speed = 960 where npcid = 45599;
update npc set alt_atk_speed = 1080 where npcid = 45600;
update npc set alt_atk_speed = 760 where npcid = 45601;
update npc set gfxid = 4855, ranged = 1, bowActId = 0 where npcid = 45602;
update npc set alt_atk_speed = 960 where npcid = 45603;
update npc set hp = 2000, lawful = -5, alt_atk_speed = 880, light_size = 14 where npcid = 45605;
update npc set alt_atk_speed = 1080 where npcid = 45607;
update npc set alt_atk_speed = 1080 where npcid = 45608;
update npc set alt_atk_speed = 1400, hpr = 70, mpr = 40 where npcid = 45611;
update npc set gfxid = 4667, ranged = 1, bowActId = 0 where npcid = 45612;
update npc set alt_atk_speed = 1400 where npcid = 45613;
update npc set hpr = 200 where npcid = 45614;
update npc set alt_atk_speed = 1080 where npcid = 45615;
update npc set alt_atk_speed = 680 where npcid = 45616;
update npc set alt_atk_speed = 1480 where npcid = 45618;
update npc set alt_atk_speed = 960 where npcid = 45623;
update npc set alt_atk_speed = 1440, agrososc = 1 where npcid = 45625;
update npc set alt_atk_speed = 960 where npcid = 45626;
update npc set alt_atk_speed = 960 where npcid = 45627;
update npc set alt_atk_speed = 1480 where npcid = 45629;
update npc set alt_atk_speed = 1120 where npcid = 45630;
update npc set alt_atk_speed = 960 where npcid = 45631;
update npc set alt_atk_speed = 880 where npcid = 45632;
update npc set alt_atk_speed = 1760 where npcid = 45640;
update npc set alt_atk_speed = 2240 where npcid = 45641;
update npc set alt_atk_speed = 1760 where npcid = 45646;
update npc set hp = 1000, lawful = -5, alt_atk_speed = 1760, mpr = 40 where npcid = 45605;
update npc set cant_resurrect = 1 where npcid = 45648;
update npc set alt_atk_speed = 1760 where npcid = 45649;
update npc set alt_atk_speed = 1720 where npcid = 45651;
update npc set alt_atk_speed = 1560 where npcid = 45652;
update npc set alt_atk_speed = 680 where npcid = 45653;
update npc set alt_atk_speed = 1920 where npcid = 45654;
update npc set alt_atk_speed = 520 where npcid = 45655;
update npc set alt_atk_speed = 520 where npcid = 45656;
update npc set alt_atk_speed = 520 where npcid = 45657;
update npc set alt_atk_speed = 520 where npcid = 45658;
update npc set alt_atk_speed = 520 where npcid = 45659;
update npc set alt_atk_speed = 520 where npcid = 45660;
update npc set alt_atk_speed = 520 where npcid = 45661;
update npc set alt_atk_speed = 520 where npcid = 45662;
update npc set alt_atk_speed = 1480 where npcid = 45664;
update npc set alt_atk_speed = 1400, cant_resurrect = 1 where npcid = 45665;
update npc set alt_atk_speed = 1400, cant_resurrect = 1 where npcid = 45666;
update npc set alt_atk_speed = 1400, cant_resurrect = 1 where npcid = 45667;
update npc set alt_atk_speed = 1400, cant_resurrect = 1 where npcid = 45668;
update npc set exp = 0, lawful = 0, alt_atk_speed = 1400, light_size = 4 where npcid = 45669;
update npc set alt_atk_speed = 1400 where npcid = 45670;
update npc set alt_atk_speed = 1320 where npcid = 45671;
update npc set alt_atk_speed = 1280, hpr = 250 where npcid = 45672;
update npc set alt_atk_speed = 1040 where npcid = 45674;
update npc set alt_atk_speed = 1600 where npcid = 45675;
update npc set alt_atk_speed = 1720, bowActId = 4536 where npcid = 45675;
update npc set alt_atk_speed = 2120 where npcid = 45677;
update npc set alt_atk_speed = 1600 where npcid = 45678;
update npc set alt_atk_speed = 2240 where npcid = 45681;
update npc set alt_atk_speed = 1960 where npcid = 45682;
update npc set alt_atk_speed = 3480 where npcid = 45683;
update npc set alt_atk_speed = 2520 where npcid = 45684;
update npc set alt_atk_speed = 1280 where npcid = 45685;
update npc set alt_atk_speed = 1200, cant_resurrect = 0 where npcid = 45686;
update npc set alt_atk_speed = 1120, cant_resurrect = 0 where npcid = 45687;
update npc set alt_atk_speed = 1120, cant_resurrect = 0 where npcid = 45688;
update npc set alt_atk_speed = 1200, cant_resurrect = 0 where npcid = 45689;
update npc set alt_atk_speed = 1320, cant_resurrect = 0 where npcid = 45690;
update npc set alt_atk_speed = 1120, cant_resurrect = 0 where npcid = 45691;
update npc set cant_resurrect = 0 where npcid = 45692;
update npc set cant_resurrect = 0 where npcid = 45693;
update npc set alt_atk_speed = 1200, cant_resurrect = 0 where npcid = 45694;
update npc set alt_atk_speed = 1120, cant_resurrect = 0 where npcid = 45695;
update npc set cant_resurrect = 0 where npcid = 45696;
update npc set alt_atk_speed = 2160, cant_resurrect = 0 where npcid = 45697;
update npc set alt_atk_speed = 2080 where npcid = 45698;
update npc set alt_atk_speed = 920 where npcid = 45699;
update npc set alt_atk_speed = 840 where npcid = 45700;
update npc set alt_atk_speed = 800 where npcid = 45701;
update npc set alt_atk_speed = 800 where npcid = 45702;
update npc set alt_atk_speed = 800 where npcid = 45703;
update npc set alt_atk_speed = 800 where npcid = 45704;
update npc set alt_atk_speed = 2240, light_size = 4 where npcid = 45706;
update npc set alt_atk_speed = 1760 where npcid = 45707;
update npc set alt_atk_speed = 1040 where npcid = 45708;
update npc set alt_atk_speed = 1760 where npcid = 45709;
update npc set alt_atk_speed = 800, cant_resurrect = 0 where npcid = 45710;
update npc set alt_atk_speed = 1120 where npcid = 45711;
update npc set alt_atk_speed = 1120, cant_resurrect = 0 where npcid = 45712;
update npc set alt_atk_speed = 1000 where npcid = 45716;
update npc set alt_atk_speed = 1000 where npcid = 45717;
update npc set alt_atk_speed = 1240 where npcid = 45719;
update npc set ranged = 2, passispeed = 1040, atkspeed = 1120, atk_magic_speed = 1120, sub_magic_speed = 1120 where npcid = 45720;
update npc set atkspeed = 720, alt_atk_speed = 960, atk_magic_speed = 720, sub_magic_speed = 720 where npcid = 45721;
update npc set passispeed = 960, atkspeed = 1240, alt_atk_speed = 1080, atk_magic_speed = 1240, sub_magic_speed = 1240 where npcid = 45722;
update npc set gfxid = 3365, passispeed = 960, atkspeed = 1400, alt_atk_speed = 1600, atk_magic_speed = 1400, sub_magic_speed = 1400 where npcid = 45723;
update npc set alt_atk_speed = 1840 where npcid = 45725;
update npc set passispeed = 720, atkspeed = 1000, atk_magic_speed = 1000, sub_magic_speed = 1000 where npcid = 45726;
update npc set gfxid = 1603, ranged = 0, passispeed = 960, atkspeed = 1440, atk_magic_speed = 1440, sub_magic_speed = 1440 where npcid = 45727;
update npc set atkspeed = 1040, alt_atk_speed = 1200 where npcid = 45728;
update npc set atkspeed = 1040, alt_atk_speed = 1200 where npcid = 45729;
update npc set passispeed = 800, atkspeed = 720, alt_atk_speed = 640, atk_magic_speed = 1440, sub_magic_speed = 1440 where npcid = 45730;
update npc set passispeed = 800, atkspeed = 720, alt_atk_speed = 640, atk_magic_speed = 1440, sub_magic_speed = 1440 where npcid = 45731;
update npc set alt_atk_speed = 960 where npcid = 45732;
update npc set alt_atk_speed = 1520 where npcid = 45733;
update npc set passispeed = 960, atkspeed = 960, alt_atk_speed = 1000, atk_magic_speed = 1440, sub_magic_speed = 1440 where npcid = 45734;
update npc set gfxid = 5708, passispeed = 800, atkspeed = 720, alt_atk_speed = 640, atk_magic_speed = 1440, sub_magic_speed = 1440 where npcid = 45735;








