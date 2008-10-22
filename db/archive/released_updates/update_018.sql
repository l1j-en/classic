-- update 18

-- change pots to classic lineage prices
-- orange pot (200 -> 150)
update shop set selling_price = 150, purchasing_price = 75 where item_id = 40011;
-- clear pot (600 -> 300)
update shop set selling_price = 300, purchasing_price = 150 where item_id = 40012;

-- add 5MR to Shield of Medusa 
update armor set m_def = 5 where item_id = 20227;

-- increase rough platinum drop from horrific iron golem (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40441 and mobid = 45479;
-- increase rough silver drop from horrific iron golem (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40468 and mobid = 45479;
-- increase rough gold drop from horrific iron golem (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40489 and mobid = 45479;
-- increase pg drop from horrific iron golem (2000 -> 2500)
update droplist set chance = 2500 where itemid = 20187 and mobid = 45479;

-- remove pm from horrific fire egg
delete from droplist where itemid = 20154 and mobid = 45384;

-- increase hqr from horrific cerebus (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40049 and mobid = 45471;
-- increase sos from horrific cerebus (10000 -> 20000)
update droplist set chance = 20000 where itemid = 125 and mobid = 45471;

-- increase blob gastric juice droprate from blob (50000 -> 300000)
update droplist set chance = 300000 where itemid = 40442 and mobid = 45032;

-- decrease sb:hw from dark elf theif (5000 -> 1500)
update droplist set chance = 1500 where itemid = 40197 and mobid = 45220;
update droplist set chance = 1500 where itemid = 40197 and mobid = 45272;
-- decrease sb:hw from dire wolf (5000 -> 2000)
update droplist set chance = 2000 where itemid = 40197 and mobid = 45237;
-- decrease sb:hw from dark elf guard (5000 -> 2000)
update droplist set chance = 2000 where itemid = 40197 and mobid = 45254;
update droplist set chance = 2000 where itemid = 40197 and mobid = 45411;

-- decrease sb:tornado from salamander (5000 -> 1500)
update droplist set chance = 1500 where itemid = 40198 and mobid = 45203;
-- decrease sb:tornado from direbat (10000 -> 1500)
update droplist set chance = 1500 where itemid = 40198 and mobid = 45172;
-- decrease sb:tornado from direbat (5000 -> 1500)
update droplist set chance = 1500 where itemid = 40198 and mobid = 45219;
-- decrease sb:tornado from dark elf (10000 -> 4000)
update droplist set chance = 4000 where itemid = 40198 and mobid = 45265;
-- decrease sb:tornado from griffon (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40198 and mobid = 45321;

-- decrease sb:silence from dark elf ranger (10000 -> 3500)
update droplist set chance = 3500 where itemid = 40209 and mobid = 45327;
update droplist set chance = 3500 where itemid = 40209 and mobid = 45446;
-- decrease sb:silence from cyclops (10000 -> 4500)
update droplist set chance = 4500 where itemid = 40209 and mobid = 45420;

-- decrease sb:i2h from death (350 -> 200)
update droplist set chance = 200 where itemid = 40213 and mobid = 45221;
-- decrease sb:i2h from cerebus (250 -> 150)
update droplist set chance = 150 where itemid = 40213 and mobid = 45241;
-- decrease sb:i2h from dark elemental (250 -> 150)
update droplist set chance = 150 where itemid = 40213 and mobid = 45244;
-- decrease sb:i2h from dark elementalist (1000 -> 400)
update droplist set chance = 400 where itemid = 40213 and mobid = 45245;
-- decrease sb:i2h from giran cerebus (250 -> 100)
update droplist set chance = 100 where itemid = 40213 and mobid = 45283;
-- decrease sb:i2h from living armor (500 -> 250)
update droplist set chance = 250 where itemid = 40213 and mobid = 45322;
-- decrease sb:i2h from dark elf wizard (1000 -> 500)
update droplist set chance = 500 where itemid = 40213 and mobid = 45333;
update droplist set chance = 500 where itemid = 40213 and mobid = 45447;
-- decrease sb:i2h from medusa (1500 -> 500)
update droplist set chance = 500 where itemid = 40213 and mobid = 45380;
-- decrease sb:i2h from horrific cerebus (1000 -> 350)
update droplist set chance = 350 where itemid = 40213 and mobid = 45471;

-- add czel to wicked beholder
insert into droplist values (45406, 240074, 1, 1, 10000);

-- remove 10% ring from bugbear and giran stone golem
delete from droplist where itemid = 20280 and mobid in (45392, 45281);

-- reduce lesser dragon spawnrate in toi41f (84 -> 68)
update spawnlist set count = 68 where npc_templateid = 45496 and mapid = 141;
-- increase fire ghost spawnrate in toi41f (12 -> 16)
update spawnlist set count = 16 where npc_templateid in (45514, 45519) and mapid = 141;

-- reduce fire necromancer spawnrate in toi47f (28 -> 24)
update spawnlist set count = 24 where npc_templateid = 45480 and mapid = 147;
-- reduce lesser dragon spawnrate in toi47f (70 -> 64)
update spawnlist set count = 64 where npc_templateid = 45496 and mapid = 147;
-- reduce bone dragon spawnrate in toi47f (22 -> 20)
update spawnlist set count = 20 where npc_templateid = 45522 and mapid = 147;

-- reduce fire necromancer spawnrate in toi48f (28 -> 24)
update spawnlist set count = 24 where npc_templateid = 45480 and mapid = 148;
-- reduce lesser dragon spawnrate in toi48f (68 -> 52)
update spawnlist set count = 52 where npc_templateid = 45496 and mapid = 148;
-- reduce bone dragon spawnrate in toi48f (26 -> 22)
update spawnlist set count = 22 where npc_templateid = 45522 and mapid = 148;

-- reduce fire necromancer spawnrate in toi49f (28 -> 26)
update spawnlist set count = 26 where npc_templateid = 45480 and mapid = 149;
-- reduce lesser dragon spawnrate in toi49f (66 -> 52)
update spawnlist set count = 52 where npc_templateid = 45496 and mapid = 149;
-- reduce bone dragon spawnrate in toi49f (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45522 and mapid = 149;

-- reduce fire necromancer spawnrate in toi50f (24 -> 22)
update spawnlist set count = 22 where npc_templateid = 45480 and mapid = 150;
-- reduce lesser dragon spawnrate in toi50f (80 -> 56)
update spawnlist set count = 56 where npc_templateid = 45496 and mapid = 150;
-- reduce bone dragon spawnrate in toi50f (40 -> 36)
update spawnlist set count = 36 where npc_templateid = 45522 and mapid = 150;

-- reduce cursed orc zombie spawnrate in toi51f (88 -> 54)
update spawnlist set count = 54 where npc_templateid = 45468 and mapid = 151;
-- increase cursed elmore soldier spawnrate in toi51f (26 -> 38)
update spawnlist set count = 38 where npc_templateid = 45524 and mapid = 151;

-- reduce cursed orc zombie spawnrate in toi52f (24 -> 22)
update spawnlist set count = 22 where npc_templateid = 45468 and mapid = 152;
-- reduce cursed elmore wizard spawnrate in toi52f (32 -> 30)
update spawnlist set count = 30 where npc_templateid = 45506 and mapid = 152;
-- reduce cursed elmore soldier spawnrate in toi52f (62 -> 54)
update spawnlist set count = 54 where npc_templateid = 45524 and mapid = 152;

-- reduce cursed orc zombie spawnrate in toi53f (26 -> 22)
update spawnlist set count = 22 where npc_templateid = 45468 and mapid = 153;
-- increase cursed elmore soldier spawnrate in toi53f (90 -> 70)
update spawnlist set count = 70 where npc_templateid = 45524 and mapid = 153;
-- reduce cursed elmore general spawnrate in toi53f (14 -> 16)
update spawnlist set count = 16 where npc_templateid = 45541 and mapid = 153;

-- reduce Insolent Zenith Queen spawnrate in toi81f (78 -> 68)
update spawnlist set count = 68 where npc_templateid = 45581 and mapid = 181;
-- reduce Lesser Seer spawnrate in toi81f (28 -> 24)
update spawnlist set count = 24 where npc_templateid = 45586 and mapid = 181;
-- reduce Marquise Vampire spawnrate in toi81f (28 -> 24)
update spawnlist set count = 24 where npc_templateid = 45604 and mapid = 181;

-- reduce Insolent Zenith Queen spawnrate in toi82f (66 -> 62)
update spawnlist set count = 62 where npc_templateid = 45581 and mapid = 182;
-- reduce Lesser Seer spawnrate in toi82f (28 -> 24)
update spawnlist set count = 24 where npc_templateid = 45586 and mapid = 182;
-- reduce Marquise Vampire spawnrate in toi82f (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45604 and mapid = 182;

-- disable some of the DV skeleton spawns
update spawnlist set count = 0 where id = 12525;
update spawnlist set count = 0 where id = 12535;
update spawnlist set count = 0 where id = 12542;
update spawnlist set count = 0 where id = 12550;
update spawnlist set count = 0 where id = 12558;
update spawnlist set count = 0 where id = 12566;
update spawnlist set count = 0 where id = 12573;
update spawnlist set count = 0 where id = 12580;
update spawnlist set count = 0 where id = 12746;
update spawnlist set count = 0 where id = 12758;
update spawnlist set count = 0 where id = 12766;
update spawnlist set count = 0 where id = 12784;
update spawnlist set count = 0 where id = 12795;
update spawnlist set count = 0 where id = 12803;
update spawnlist set count = 0 where id = 12809;
update spawnlist set count = 0 where id = 12816;
update spawnlist set count = 0 where id = 12826;
update spawnlist set count = 0 where id = 12844;
update spawnlist set count = 0 where id = 12854;
update spawnlist set count = 0 where id = 12867;
update spawnlist set count = 0 where id = 13354;
update spawnlist set count = 0 where id = 13366;
update spawnlist set count = 0 where id = 13380;
update spawnlist set count = 0 where id = 13390;
update spawnlist set count = 0 where id = 13401;
update spawnlist set count = 0 where id = 13418;
update spawnlist set count = 0 where id = 13432;
update spawnlist set count = 0 where id = 13443;
update spawnlist set count = 0 where id = 13453;
update spawnlist set count = 0 where id = 13459;
update spawnlist set count = 0 where id = 13466;

