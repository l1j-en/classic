-- update 16

-- remove unnamed npc in skt
delete from spawnlist_npc where id = 90068 and npc_templateid = 71035;

-- correct name of Large Cave Crystal (was Oum Dungeon Crystal)
update etcitem set name = 'Large Cave Crystal' where item_id = 40430;

-- correct name of Black Tiger (was Black Dragon Scales)
update npc set name = 'Black Tiger' where npcid = 45357;

-- correct name of Spirit Crystal(WindShackle) (was Spirit Crystal(WindCircle))
update etcitem set name = 'Spirit Crystal(WindShackle)' where item_id = 40264;

-- correct name of WindShackle skill (was WindCircle)
update skills set name = 'WindShackle' where skill_id = 167;

-- correct name of Astagio (was Astiago)
update npc set name = 'Astagio' where npcid = 45359;

-- correct name of Astagio of Fire (was Astiago of Fire)
update npc set name = 'Astagio of Fire' where npcid = 45572;

-- correct name of Potion of Cure Poison (was Cure Poison Potion)
update etcitem set name = 'Potion of Cure Poison' where item_id = 40017;

-- correct name of Giran Lava Golem (was Black Ent)
update npc set name = 'Giran Lava Golem' where npcid = 45376;

-- correct name of Daniel (was nothing)
update npc set name = 'Daniel' where npcid = 50079;

-- correct name of Paul (was nothing)
update npc set name = 'Paul' where npcid = 50080;

-- correct name of Chico (was nothing)
update npc set name = 'Chico' where npcid = 50114;

-- correct name of Gion (was nothing)
update npc set name = 'Gion' where npcid = 50116;

-- correct name of Syria (was nothing)
update npc set name = 'Syria' where npcid = 50117;

-- correct name of Niki (was nothing)
update npc set name = 'Niki' where npcid = 50118;

-- correct name of Oshillia (was nothing)
update npc set name = 'Oshillia' where npcid = 50119;

-- correct name of Hob (was nothing)
update npc set name = 'Hob' where npcid = 50120;

-- correct name of Honin (was nothing)
update npc set name = 'Honin' where npcid = 50121;

-- correct name of Tuck (was nothing)
update npc set name = 'Tuck' where npcid = 50122;

-- correct name of Galleon (was nothing)
update npc set name = 'Galleon' where npcid = 50123;

-- correct name of Porikan (was nothing)
update npc set name = 'Porikan' where npcid = 50124;

-- correct name of Gilbert (was nothing)
update npc set name = 'Gilbert' where npcid = 50125;

-- correct name of Jerik (was nothing)
update npc set name = 'Jerik' where npcid = 50126;

-- correct name of Consul (was nothing)
update npc set name = 'Consul' where npcid = 50127;

-- correct name of Gleda (was nothing)
update npc set name = 'Gleda' where npcid = 50501;

-- correct name of Ginevra (was nothing)
update npc set name = 'Ginevra' where npcid = 50502;

-- correct name of Noela (was nothing)
update npc set name = 'Noela' where npcid = 50503;

-- correct name of Nicoline (was nothing)
update npc set name = 'Nicoline' where npcid = 50504;

-- correct name of Diane (was nothing)
update npc set name = 'Diane' where npcid = 50505;

-- correct name of Duana (was nothing)
update npc set name = 'Duana' where npcid = 50506;

-- correct name of Leonora (was nothing)
update npc set name = 'Leonora' where npcid = 50507;

-- correct name of Lucinda (was nothing)
update npc set name = 'Lucinda' where npcid = 50508;

-- correct name of Livia (was nothing)
update npc set name = 'Livia' where npcid = 50509;

-- correct name of Marina (was nothing)
update npc set name = 'Marina' where npcid = 50510;

-- correct name of Margery (was nothing)
update npc set name = 'Margery' where npcid = 50511;

-- correct name of Mary (was nothing)
update npc set name = 'Mary' where npcid = 50512;

-- correct name of Mennefer (was nothing)
update npc set name = 'Mennefer' where npcid = 50513;

-- correct name of Minerva (was nothing)
update npc set name = 'Minerva' where npcid = 50514;

-- correct name of Miryam (was nothing)
update npc set name = 'Miryam' where npcid = 50515;

-- correct name of Valeska (was nothing)
update npc set name = 'Valeska' where npcid = 50516;

-- correct name of Bernice (was nothing)
update npc set name = 'Bernice' where npcid = 50517;

-- correct name of Vevina (was nothing)
update npc set name = 'Vevina' where npcid = 50518;

-- correct name of Thram (was nothing)
update npc set name = 'Thram' where npcid = 60003;

-- correct name of Denitz (was nothing)
update npc set name = 'Denitz' where npcid = 60004;

-- correct name of Guard (was nothing)
update npc set name = 'Guard' where npcid = 60501;

-- correct name of Court Guard (was nothing)
update npc set name = 'Court Guard' where npcid = 60524;

-- correct name of Arieh (was nothing)
update npc set name = 'Arieh' where npcid = 70015;

-- correct name of Andyn (was nothing)
update npc set name = 'Andyn' where npcid = 70016;

-- correct name of Orim (was nothing)
update npc set name = 'Orim' where npcid = 70017;

-- correct name of Ysorya (was nothing)
update npc set name = 'Ysorya' where npcid = 70018;

-- correct name of Lolia (was nothing)
update npc set name = 'Lolia' where npcid = 70019;

-- correct name of Rollko (was nothing)
update npc set name = 'Rollko' where npcid = 70020;

-- correct name of Luth (was nothing)
update npc set name = 'Luth' where npcid = 70021;

-- correct name of Harbor Master (was nothing)
update npc set name = 'Harbor Master' where npcid = 70022;

-- correct name of Aden Chamber of Commerce (was nothing)
update npc set name = 'Aden Chamber of Commerce' where npcid = 70023;

-- correct name of Catty (was nothing)
update npc set name = 'Catty' where npcid = 70024;

-- correct name of Hector (was nothing)
update npc set name = 'Hector' where npcid = 70642;

-- correct name of Eno (was nothing)
update npc set name = 'Eno' where npcid = 70707;

-- correct name of Giant Elder (was nothing)
update npc set name = 'Giant Elder' where npcid = 70711;

-- correct name of Jimu (was nothing)
update npc set name = 'Jimu' where npcid = 70715;

-- correct name of Paruit (was nothing)
update npc set name = 'Paruit' where npcid = 70722;

-- correct name of Pau (was nothing)
update npc set name = 'Pau' where npcid = 70723;

-- correct name of Heit (was nothing)
update npc set name = 'Heit' where npcid = 70724;

-- correct name of Blood Pledge Administrator (was nothing)
update npc set name = 'Blood Pledge Administrator' where npcid = 70725;

-- correct name of Soldier of Dicarding (was nothing)
update npc set name = 'Soldier of Dicarding' where npcid = 70740;

-- correct name of Roje (was nothing)
update npc set name = 'Roje' where npcid = 70744;

-- correct name of Village Manager (was nothing)
update npc set name = 'Village Manager' where npcid = 70748;

-- correct name of Milo (was nothing)
update npc set name = 'Milo' where npcid = 70749;

-- correct name of Goddess of Atonement (was nothing)
update npc set name = 'Goddess of Atonement' where npcid = 70757;

-- correct name of Secretary to the Mayor (was nothing)
update npc set name = 'Secretary to the Mayor' where npcid = 70761;

-- correct name of Randith (was nothing)
update npc set name = 'Randith' where npcid = 70771;

-- correct name of Marbin (was nothing)
update npc set name = 'Marbin' where npcid = 70773;

-- correct name of Village Manager (was nothing)
update npc set name = 'Village Manager' where npcid = 70774;

-- correct name of Mark (was nothing)
update npc set name = 'Mark' where npcid = 70775;

-- correct name of Mack (was nothing)
update npc set name = 'Mack' where npcid = 70776;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70778;

-- correct name of Gatekeeper Ant (was nothing)
update npc set name = 'Gatekeeper Ant' where npcid = 70779;

-- correct name of Goddess of Atonement (was nothing)
update npc set name = 'Goddess of Atonement' where npcid = 70781;

-- correct name of Aria (was nothing)
update npc set name = 'Aria' where npcid = 70783;

-- correct name of Secretary to the Mayor (was nothing)
update npc set name = 'Secretary to the Mayor' where npcid = 70788;

-- correct name of Halt (was nothing)
update npc set name = 'Halt' where npcid = 70789;

-- correct name of Blood Pledge Administrator (was nothing)
update npc set name = 'Blood Pledge Administrator' where npcid = 70790;

-- correct name of Gerard (was nothing)
update npc set name = 'Gerard' where npcid = 70794;

-- correct name of Dunham (was nothing)
update npc set name = 'Dunham' where npcid = 70796;

-- correct name of Ricky (was nothing)
update npc set name = 'Ricky' where npcid = 70798;

-- correct name of Village Manager (was nothing)
update npc set name = 'Village Manager' where npcid = 70799;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70800;

-- correct name of Goddess of Atonement (was nothing)
update npc set name = 'Goddess of Atonement' where npcid = 70801;

-- correct name of Aanon (was nothing)
update npc set name = 'Aanon' where npcid = 70802;

-- correct name of Joel (was nothing)
update npc set name = 'Joel' where npcid = 70804;

-- correct name of Julie (was nothing)
update npc set name = 'Julie' where npcid = 70805;

-- correct name of Secretary to the Mayor (was nothing)
update npc set name = 'Secretary to the Mayor' where npcid = 70806;

-- correct name of Pin (was nothing)
update npc set name = 'Pin' where npcid = 70807;

-- correct name of Village Manager (was nothing)
update npc set name = 'Village Manager' where npcid = 70815;

-- correct name of Bludika  (was nothing)
update npc set name = 'Bludika' where npcid = 70895;

-- correct name of Kima (was nothing)
update npc set name = 'Kima' where npcid = 70906;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70986;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70987;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70988;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70989;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70990;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70991;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70992;

-- correct name of Gatekeeper (was nothing)
update npc set name = 'Gatekeeper' where npcid = 70996;

-- correct name of Elder Nanome (was nothing)
update npc set name = 'Elder Nanome' where npcid = 71038;

-- correct name of Ant Cave Entrance (was nothing)
update npc set name = 'Ant Cave Entrance' where npcid = 81106;

-- correct name of Guardian Tower (was nothing)
update npc set name = 'Guardian Tower' where npcid = 81111;

-- correct name of Lary\'s Assistant (was nothing)
update npc set name = 'Lary\'s Assistant' where npcid = 81119;

-- correct name of Jack-O-Lantern (was nothing)
update npc set name = 'Jack-O-Lantern' where npcid = 81123;

-- correct name of Jack-O-Lantern (was nothing)
update npc set name = 'Jack-O-Lantern' where npcid = 81124;

-- correct name of Message Board (was nothing)
update npc set name = 'Message Board' where npcid = 81126;

-- correct name of Message Board (was nothing)
update npc set name = 'Message Board' where npcid = 81130;

-- correct name of Torch Fire (was nothing)
update npc set name = 'Torch Fire' where npcid = 81160;

-- correct name of Auction Board (was nothing)
update npc set name = 'Auction Board' where npcid = 81161;

-- make mainland cyclops tamable
update npc set tamable = 1 where npcid = 45420;

-- reduce lesser demon 2 cell magic attack damage_value (50 -> 20)
update skills set damage_value = 20 where skill_id = 10042;

-- reduce lesser dragon magic attack damage_value (200 -> 100)
update skills set damage_value = 100 where skill_id = 10008;

-- reduce dark forester aoe damage_value (30 -> 20)
update skills set damage_value = 20 where skill_id = 10043;

-- un-hardskin dark elder
update npc set hard = 0 where npcid in (45545, 45550);

-- make ishield base ac 4
update armor set ac = -4 where item_id = 20220;

-- make ivisor base ac 4
update armor set ac = -4 where item_id = 20003;

-- reduce bw staff droprate (5000 -> 1500)
update droplist set chance = 1500 where itemid = 116 and mobid in (45405, 45425);

-- add light scroll to skt shop
insert into shop values (70074, 40860, 49, 127, 0, 0);

-- remove duplicate candy from skt shop
delete from shop where npc_id = 70074 and item_id = 40065 and selling_price = -1;

-- remove duplicate esc scroll from skt shop
delete from shop where npc_id = 70074 and item_id = 40079 and selling_price = -1;

-- remove duplicate res scroll from skt shop
delete from shop where npc_id = 70074 and item_id = 40089 and selling_price = -1;

-- fix hbow sell to store price
update shop set purchasing_price = 2500 where item_id = 169 and purchasing_price = 25;

-- increase hbow droprate from fire archer (10000 -> 50000)
update droplist set chance = 50000 where itemid = 169 and mobid = 45291;

-- add mermaid to merman family
update npc set family = 'merman' where npcid = 45154;

-- remove sosc aggro from Acaleph 
update npc set agrososc = 0 where npcid = 45097;

-- remove tribal from crabmen (was crab)
update npc set family = '' where npcid = 45164;

-- modify existing demon drops
-- increase demon helmet droprate from demon (1000 -> 5000)
update droplist set chance = 5000 where itemid = 20009 and mobid = 45649;
-- increase demon armor droprate from demon (2000 -> 10000)
update droplist set chance = 10000 where itemid = 20099 and mobid = 45649;
-- increase demon staff droprate from demon (100 -> 150)
update droplist set chance = 150 where itemid = 108 and mobid = 45649;
-- increase tsu droprate from demon (500 -> 1000)
update droplist set chance = 1000 where itemid = 57 and mobid = 45649;
-- increase bkat droprate from demon (25000 -> 50000)
update droplist set chance = 50000 where itemid = 100041 and mobid = 45649;
-- increase bdai droprate from demon (150000 -> 300000)
update droplist set chance = 300000 where itemid = 140087 and mobid = 45649;

-- add btsu to demon droplist
insert into droplist values (45649, 100057, 1, 1, 250);

-- modify existing mutant ramia drops
-- increase cure pot droprate from mutant ramia (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40017 and mobid = 45332;
-- increase ndai droprate from mutant ramia (5000 -> 20000)
update droplist set chance = 20000 where itemid = 40087 and mobid = 45332;
-- increase btele droprate from mutant ramia (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45332;

-- modify existing mutant arachnevil elder drops
-- increase cure pot droprate from mutant arachnevil elder (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40017 and mobid = 45348;
-- increase nzel droprate from mutant arachnevil elder (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45348;
-- increase ndai droprate from mutant arachnevil elder (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40087 and mobid = 45348;
-- increase btele droprate from mutant arachnevil elder (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45348;

-- add additional drops to mutant arachnevil elder
-- add dsc:venom resist to mutant arachnevil elder droplist 
insert into droplist values (45348, 40273, 1, 1, 10000);

-- modify existing medusa drops
-- increase nzel droprate from medusa (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45380;
-- increase czel droprate from medusa (5000 -> 10000)
update droplist set chance = 10000 where itemid = 240074 and mobid = 45380;
-- increase wis pot droprate from medusa (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40016 and mobid = 45380;
-- increase res scroll droprate from medusa (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40089 and mobid = 45380;
-- increase cdai droprate from medusa (2500 -> 5000)
update droplist set chance = 5000 where itemid = 240087 and mobid = 45380;
-- increase sb:i2h droprate from medusa (1000 -> 1500)
update droplist set chance = 1500 where itemid = 40213 and mobid = 45380;

-- add additional drops to medusa 
-- add cure pot to medusa droplist 
insert into droplist values (45380, 40017, 1, 1, 50000);
-- add sb:cp to medusa droplist 
insert into droplist values (45380, 40178, 1, 1, 25000);
-- add sb:darkness to medusa droplist 
insert into droplist values (45380, 40185, 1, 1, 10000);

-- modify existing cimaera drops
-- increase wis pot droprate from cimaera (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40016 and mobid = 45407;

-- add additional drops to cimaera
-- add nzel to cimaera droplist 
insert into droplist values (45407, 40074, 1, 1, 10000);
-- add shielf of medusa to cimaera droplist 
insert into droplist values (45407, 20227, 1, 1, 500);

-- modify existing toi dire wolf drops
-- increase wis pot droprate from toi dire wolf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40016 and mobid = 45409;
-- decrease nprat droprate from toi dire wolf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40119 and mobid = 45409;
-- decrease btele droprate from toi dire wolf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45409;

-- add additional drops to toi dire wolf
-- add meat to toi dire wolf droplist 
insert into droplist values (45409, 40056, 1, 1, 50000);
-- add haste pot to toi dire wolf droplist 
insert into droplist values (45409, 40013, 1, 1, 25000);
-- add brave pot to toi dire wolf droplist 
insert into droplist values (45409, 40014, 1, 1, 80000);
-- add obom to toi dire wolf droplist 
insert into droplist values (45409, 20307, 1, 1, 1000);
-- add sb:haste to toi dire wolf droplist 
insert into droplist values (45409, 40188, 1, 1, 10000);
-- add sb:str to toi dire wolf droplist 
insert into droplist values (45409, 40187, 1, 1, 10000);

-- remove ring mail from dancing sword droplist
delete from droplist where itemid = 20096 and mobid = 45386;
-- remove scimitar from dancing sword droplist
delete from droplist where itemid = 27 and mobid = 45386;

-- add additional drops to dancing sword
-- add blue pot to dancing sword droplist 
insert into droplist values (45386, 40015, 1, 1, 50000);
-- add red pot to dancing sword droplist 
insert into droplist values (45386, 40010, 1, 1, 50000);
-- add c-red pot to dancing sword droplist 
insert into droplist values (45386, 40019, 1, 1, 50000);
-- add nkat to dancing sword droplist 
insert into droplist values (45386, 41, 1, 1, 7500);
-- add sb:haste to dancing sword droplist 
insert into droplist values (45386, 40188, 1, 1, 10000);
-- add sb:dex to dancing sword droplist 
insert into droplist values (45386, 40171, 1, 1, 10000);
-- add sb:wb to dancing sword droplist 
insert into droplist values (45386, 40172, 1, 1, 10000);
-- add id scroll to dancing sword droplist 
insert into droplist values (45386, 40098, 1, 1, 50000);
-- add sb:bless weapon to dancing sword droplist 
insert into droplist values (45386, 40193, 1, 1, 10000);
-- add 2hs to dancing sword droplist 
insert into droplist values (45386, 52, 1, 1, 7500);
-- add sb:create magical weapon to dancing sword droplist 
insert into droplist values (45386, 40218, 1, 1, 100);
-- add btele to dancing sword droplist 
insert into droplist values (45386, 140100, 1, 1, 50000);

-- modify existing wicked beholder drops
-- increase wis pot droprate from wicked beholder (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40016 and mobid = 45406;
-- increase cdai droprate from wicked beholder (2500 -> 5000)
update droplist set chance = 5000 where itemid = 240087 and mobid = 45406;

-- add additional drops to wicked beholder
-- add sb:ab to wicked beholder droplist 
insert into droplist values (45406, 40223, 1, 1, 100);
-- add sc:r2n to wicked beholder droplist 
insert into droplist values (45406, 40237, 1, 1, 2500);

-- modify existing wicked mimic drops
-- increase brave pot droprate from wicked mimic (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45399;
-- increase blue pot droprate from wicked mimic (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40015 and mobid = 45399;
-- increase nzel droprate from wicked mimic (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45399;

-- modify existing horrific fire egg drops
-- increase blue pot droprate from horrific fire egg (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45384;
-- increase poly scroll droprate from horrific fire egg (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40088 and mobid = 45384;
-- increase nprat droprate from horrific fire egg (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40119 and mobid = 45384;

-- add additional drops to horrific fire egg
-- add sc: fire weapon to horrific fire egg droplist 
insert into droplist values (45384, 40256, 1, 1, 8000);
-- add plate mail to horrific fire egg droplist 
insert into droplist values (45384, 20154, 1, 1, 2500);
-- add esc scroll to horrific fire egg droplist 
insert into droplist values (45384, 40079, 1, 1, 75000);
-- add sb:rc to horrific fire egg droplist 
insert into droplist values (45384, 40182, 1, 1, 10000);

-- modify existing nightmare drops
-- decrease sb:counter detect droprate from nightmare (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40217 and mobid = 45440;
-- decrease sc:triple arrow droprate from nightmare (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40240 and mobid = 45440;
-- increase btele droprate from nightmare (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45440;

-- remove clear pot from nightmare
delete from droplist where itemid = 40018 and mobid = 45440;

-- add additional drops to nightmare 
-- add c-red pot to nightmare droplist 
insert into droplist values (45440, 40019, 1, 1, 50000);
-- add c-clear pot to nightmare droplist 
insert into droplist values (45440, 40021, 1, 1, 50000);
-- add brave pot to nightmare droplist 
insert into droplist values (45440, 40014, 1, 1, 75000);
-- add dsc:final burn to nightmare droplist 
insert into droplist values (45440, 40278, 1, 1, 5000);

-- modify existing horrific cerberus drops
-- increase brave pot droprate from horrific cerberus (50000 -> 200000)
update droplist set chance = 200000 where itemid = 40014 and mobid = 45471;
-- decrease sb:firewall droprate from horrific cerberus (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40203 and mobid = 45471;
-- increase hqr droprate from horrific cerberus (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40049 and mobid = 45471;
-- decrease sc:final burn droprate from horrific cerberus (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40278 and mobid = 45471;
-- increase btele droprate from horrific cerberus (50000 -> 100000)
update droplist set chance = 100000 where itemid = 140100 and mobid = 45471;

-- add additional drops to horrific cerberus
-- add ruby to horrific cerberus droplist 
insert into droplist values (45471, 40045, 1, 1, 75000);
-- add sb:fb to horrific cerberus droplist 
insert into droplist values (45471, 40170, 1, 1, 15000);
-- add tqr to horrific cerberus droplist 
insert into droplist values (45471, 40053, 1, 1, 10000);

-- modify existing lesser demon drops
-- decrease rof droprate from lesser demon (1000 -> 500)
update droplist set chance = 500 where itemid = 20304 and mobid = 45481;
-- decrease int ammy droprate from lesser demon (1000 -> 750)
update droplist set chance = 750 where itemid = 20266 and mobid = 45481;
-- decrease str ammy droprate from lesser demon (1000 -> 850)
update droplist set chance = 850 where itemid = 20264 and mobid = 45481;
-- decrease demon armor droprate from lesser demon (1000 -> 550)
update droplist set chance = 550 where itemid = 20099 and mobid = 45481;
-- increase blue pot droprate from lesser demon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45481;
-- increase res scroll droprate from lesser demon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40089 and mobid = 45481;
-- increase nzel droprate from lesser demon (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45481;
-- increase ndai droprate from lesser demon (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40087 and mobid = 45481;
-- decrease sb:firewall droprate from lesser demon (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40203 and mobid = 45481;
-- increase sc:erase magic droprate from lesser demon (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40242 and mobid = 45481;
-- increase dsc:final burn droprate from lesser demon (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40278 and mobid = 45481;

-- add additional drops to lesser demon 
-- add sb:fb to lesser demon droplist 
insert into droplist values (45481, 40170, 1, 1, 15000);
-- add pine to lesser demon droplist 
insert into droplist values (45481, 40006, 1, 1, 10000);
-- add wis pot to lesser demon droplist 
insert into droplist values (45481, 40016, 1, 1, 75000);
-- add nkat to lesser demon droplist 
insert into droplist values (45481, 41, 1, 1, 10000);
-- add 2hs to lesser demon droplist 
insert into droplist values (45481, 52, 1, 1, 7500);
-- add dsc:shadow fang to lesser demon droplist 
insert into droplist values (45481, 40277, 1, 1, 5000);
-- add plate mail to lesser demon droplist 
insert into droplist values (45481, 20154, 1, 1, 5000);
-- add cmomr to lesser demon droplist 
insert into droplist values (45481, 20110, 1, 1, 2500);
-- add cpm to lesser demon droplist 
insert into droplist values (45481, 20128, 1, 1, 500);
-- add obom to lesser demon droplist 
insert into droplist values (45481, 20307, 1, 1, 2500);
-- add obos to lesser demon droplist 
insert into droplist values (45481, 20308, 1, 1, 2500);
-- add sb:i2h to lesser demon droplist 
insert into droplist values (45481, 40213, 1, 1, 1000);
-- add bom to lesser demon droplist 
insert into droplist values (45481, 20319, 1, 1, 1000);
 
-- modify existing toi ifrit drops
-- increase blue pot droprate from toi ifrit (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40015 and mobid = 45515;
-- decrease sc:fire weapon droprate from toi ifrit (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40256 and mobid = 45515;
-- decrease sc:bless of fire droprate from toi ifrit (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40257 and mobid = 45515;

-- add additional drops to toi ifrit
-- add hqr to toi ifrit droplist 
insert into droplist values (45515, 40049, 1, 1, 50000);
-- add hqd to toi ifrit droplist 
insert into droplist values (45515, 40048, 1, 1, 50000);
-- add nkat to toi ifrit droplist 
insert into droplist values (45515, 41, 1, 1, 25000);
-- add rof to toi ifrit droplist 
insert into droplist values (45515, 20304, 1, 1, 250);
-- add nzel to toi ifrit droplist 
insert into droplist values (45515, 40074, 1, 1, 50000);
-- add bzel to toi ifrit droplist 
insert into droplist values (45515, 140074, 1, 1, 2500);

-- modify existing raging skeleton axeman drops
-- increase nzel droprate from raging skeleton axeman (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45402;
-- increase ndai droprate from raging skeleton axeman (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40087 and mobid = 45402;

-- add sb:dex to raging skeleton axeman droplist 
insert into droplist values (45402, 40171, 1, 1, 1000);

-- modify existing raging ghoul drops
-- increase brave pot droprate from raging ghoul (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40014 and mobid = 45454;
-- increase nzel droprate from raging ghoul (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45454;
-- increase res scroll droprate from raging ghoul (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40089 and mobid = 45454;
-- increase wis pot droprate from raging ghoul (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40016 and mobid = 45454;
-- increase btele droprate from raging ghoul (50000 -> 150000)
update droplist set chance = 150000 where itemid = 140100 and mobid = 45454;

-- modify existing raging skeleton pike drops
-- increase brave pot droprate from raging skeleton pike (50000 -> 120000)
update droplist set chance = 120000 where itemid = 40014 and mobid = 45403;
-- increase nzel droprate from raging skeleton pike (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40074 and mobid = 45403;

-- modify existing raging spartoi drops
-- increase homr droprate from raging spartoi (10000 -> 50000)
update droplist set chance = 50000 where itemid = 20011 and mobid = 45455;
-- increase nzel droprate from raging spartoi (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40074 and mobid = 45455;
-- increase poly scroll droprate from raging spartoi (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40088 and mobid = 45455;

-- add additional drops to raging spartoi
-- add ndai to raging spartoi droplist 
insert into droplist values (45455, 40087, 1, 1, 5000);

-- modify existing raging skeleton marksman drops
-- increase brave pot droprate from raging skeleton marksman (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45494;
-- decrease sc:windshot droprate from raging skeleton marksman (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40260 and mobid = 45494;
-- increase ndai droprate from raging skeleton marksman (5000 -> 8000)
update droplist set chance = 8000 where itemid = 40087 and mobid = 45494;

-- add additional drops to raging skeleton marksman
-- add wis pot to raging skeleton marksman droplist 
insert into droplist values (45494, 40016, 1, 1, 150000);
-- add nzel to raging skeleton marksman droplist 
insert into droplist values (45494, 40074, 1, 1, 25000);

-- modify existing raging skeleton fighter drops
-- increase ghaste droprate from raging skeleton fighter (50000 -> 100000)
update droplist set chance = 1000000 where itemid = 40018 and mobid = 45493;
-- increase ndai droprate from raging skeleton fighter (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40087 and mobid = 45493;
-- increase bzel droprate from raging skeleton fighter (5000 -> 6000)
update droplist set chance = 6000 where itemid = 140074 and mobid = 45493;

-- add additional drops to raging skeleton fighter
-- add nzel to raging skeleton fighter droplist 
insert into droplist values (45493, 40074, 1, 1, 20000);

-- modify existing fire necromancer drops
-- increase maple droprate from fire necromancer (50000 -> 120000)
update droplist set chance = 120000 where itemid = 40008 and mobid = 45480;
-- increase pine droprate from fire necromancer (50000 -> 120000)
update droplist set chance = 120000 where itemid = 40006 and mobid = 45480;
-- increase bzel droprate from fire necromancer (5000 -> 7500)
update droplist set chance = 7500 where itemid = 140074 and mobid = 45480;
-- increase bdai droprate from fire necromancer (2500 -> 3500)
update droplist set chance = 3500 where itemid = 140087 and mobid = 45480;
-- increase 51f droprate from fire necromancer (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40108 and mobid = 45480;

-- add additional drops to fire necromancer
-- add ruby to fire necromancer droplist 
insert into droplist values (45480, 40045, 1, 1, 150000);
-- add blue pot to fire necromancer droplist 
insert into droplist values (45480, 40015, 1, 1, 100000);
-- add tqr to fire necromancer droplist 
insert into droplist values (45480, 40053, 1, 1, 75000);

-- modify existing bone dragon drops
-- increase diamond, ruby, sapphire, emerald droprate from bone dragon (50000 -> 75000)
update droplist set chance = 75000 where itemid in (40044, 40045, 40046, 40047) and mobid = 45522;
-- increase hqd, tqr, hqs, hqe droprate from bone dragon (10000 -> 50000)
update droplist set chance = 50000 where itemid in (40048, 40049, 40050, 40051) and mobid = 45522;
-- increase tqd, tqs, tqr, tqe droprate from bone dragon (10000 -> 12500)
update droplist set chance = 12500 where itemid in (40052, 40053, 40054, 40055) and mobid = 45522;
-- increase 51f droprate from bone dragon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40108 and mobid = 45522;

-- add additional drops to bone dragon
-- add blue pot to bone dragon droplist 
insert into droplist values (45522, 40015, 1, 1, 150000);
-- add sb:dex to bone dragon droplist 
insert into droplist values (45522, 40171, 1, 1, 25000);
-- add sb:mana drain to bone dragon droplist 
insert into droplist values (45522, 40184, 1, 1, 25000);
-- add sb:weakness to bone dragon droplist 
insert into droplist values (45522, 40192, 1, 1, 25000);
-- add btele to bone dragon droplist 
insert into droplist values (45522, 140100, 1, 1, 150000);

-- add additional drops to cursed elmore wizard 
-- add g-haste pot to cursed elmore wizard droplist 
insert into droplist values (45506, 40018, 1, 1, 50000);
-- add cure pot to cursed elmore wizard droplist 
insert into droplist values (45506, 40017, 1, 1, 50000);
-- add blue pot to cursed elmore wizard droplist 
insert into droplist values (45506, 40015, 1, 1, 50000);

-- modify existing cursed elmore general drops
-- increase brave pot droprate from cursed elmore general (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45541;
-- increase blue pot droprate from cursed elmore general (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40015 and mobid = 45541;
-- increase wafer droprate from cursed elmore general (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40068 and mobid = 45541;

-- add additional drops to cursed elmore general
-- add cure pot pot to cursed elmore general droplist 
insert into droplist values (45541, 40017, 1, 1, 25000);

-- modify existing dark lycanthrope drops
-- increase pine droprate from dark lycanthrope (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40006 and mobid = 45485;
-- increase maple droprate from dark lycanthrope (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40008 and mobid = 45485;

-- modify existing cruel snow tiger drops
-- increase brave pot droprate from cruel snow tiger (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40014 and mobid = 45528;
-- increase nzel droprate from cruel snow tiger (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45528;
-- increase ndai droprate from cruel snow tiger (5000 -> 12000)
update droplist set chance = 12000 where itemid = 40087 and mobid = 45528;

-- add additional drops to cruel snow tiger
-- add maple to cruel snow tiger droplist 
insert into droplist values (45528, 40008, 1, 1, 50000);

-- modify existing spirit taurverus of fire drops
-- increase wis pot droprate from spirit taurverus of fire (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40016 and mobid = 45520;
-- increase nzel droprate from spirit taurverus of fire (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40074 and mobid = 45520;
-- increase ndai droprate from spirit taurverus of fire (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40087 and mobid = 45520;

-- modify existing astagio of fire drops
-- increase brave pot droprate from astagio of fire (25000 -> 150000)
update droplist set chance = 150000 where itemid = 40014 and mobid = 45572;
-- increase blue pot droprate from astagio of fire (25000 -> 60000)
update droplist set chance = 60000 where itemid = 40015 and mobid = 45572;
-- increase nzel droprate from astagio of fire (5000 -> 65000)
update droplist set chance = 65000 where itemid = 40074 and mobid = 45572;
-- increase ndai droprate from astagio of fire (2500 -> 30000)
update droplist set chance = 30000 where itemid = 40087 and mobid = 45572;
-- increase sb:erupt droprate from astagio of fire (5000 -> 15000)
update droplist set chance = 15000 where itemid = 40190 and mobid = 45572;
-- increase sb:eq droprate from astagio of fire (5000 -> 13000)
update droplist set chance = 13000 where itemid = 40207 and mobid = 45572;

-- add additional drops to astagio of fire
-- add wis pot to astagio of fire droplist 
insert into droplist values (45572, 40016, 1, 1, 100000);

-- modify existing black knight of darkness drops
-- increase brave pot droprate from black knight of darkness (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45503;
-- increase blue pot droprate from black knight of darkness (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45503;
-- increase nprat droprate from black knight of darkness (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40119 and mobid = 45503;

-- add additional drops to fire warrior of darkness
-- add lvl3 blank to fire warrior of darkness droplist 
insert into droplist values (45540, 40092, 1, 1, 30000);
-- add lvl4 blank to fire warrior of darkness droplist 
insert into droplist values (45540, 40093, 1, 1, 25000);
-- add lvl5 blank to fire warrior of darkness droplist 
insert into droplist values (45540, 40094, 1, 1, 20000);

-- modify existing insolent zenith queen drops
-- increase zq ring droprate from insolent zenith queen (100 -> 250)
update droplist set chance = 250 where itemid = 20298 and mobid = 45581;
-- increase bzel droprate from insolent zenith queen (5000 -> 10000)
update droplist set chance = 10000 where itemid = 140074 and mobid = 45581;
-- increase bdai droprate from insolent zenith queen (2500 -> 5000)
update droplist set chance = 5000 where itemid = 140087 and mobid = 45581;
-- increase czel droprate from insolent zenith queen (5000 -> 25000)
update droplist set chance = 25000 where itemid = 240074 and mobid = 45581;
-- increase cdai droprate from insolent zenith queen (2500 -> 12500)
update droplist set chance = 12500 where itemid = 140087 and mobid = 45581;

-- modify existing lesser seer drops
-- increase sb:ab droprate from lesser seer (100 -> 150)
update droplist set chance = 150 where itemid = 40223 and mobid = 45586;
-- increase nzel droprate from lesser seer (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45586;
-- increase ndai droprate from lesser seer (5000 -> 12000)
update droplist set chance = 12000 where itemid = 40087 and mobid = 45586;
-- increase bzel droprate from lesser seer (5000 -> 10000)
update droplist set chance = 10000 where itemid = 140074 and mobid = 45586;
-- increase bdai droprate from lesser seer (2500 -> 5000)
update droplist set chance = 5000 where itemid = 140087 and mobid = 45586;
-- increase czel droprate from lesser seer (5000 -> 12000)
update droplist set chance = 12000 where itemid = 240074 and mobid = 45586;
-- increase cdai droprate from lesser seer (2500 -> 7000)
update droplist set chance = 7000 where itemid = 240087 and mobid = 45586;

-- modify existing marquise vampire drops
-- increase ndai droprate from marquise vampire (5000 -> 12000)
update droplist set chance = 12000 where itemid = 40087 and mobid = 45604;
-- increase sb:adv droprate from marquise vampire (100 -> 350)
update droplist set chance = 350 where itemid = 40224 and mobid = 45604;
-- increase bzel droprate from marquise vampire (5000 -> 8000)
update droplist set chance = 8000 where itemid = 140074 and mobid = 45604;

-- modify existing zombie lord of fear drops
-- increase pg droprate from zombie lord of fear (5000 -> 5500)
update droplist set chance = 5500 where itemid = 20187 and mobid = 45589;
-- increase ndai droprate from zombie lord of fear (5000 -> 25000)
update droplist set chance = 15000 where itemid = 40087 and mobid = 45589;
-- increase sb:cz droprate from zombie lord of fear (10000 -> 100000)
update droplist set chance = 100000 where itemid = 40186 and mobid = 45589;

-- add additional drops to zombie lord of fear
-- add nzel to zombie lord of fear droplist 
insert into droplist values (45589, 40074, 1, 1, 50000);

-- modify existing undead elmore soldier drops
-- decrease leather armor droprate from undead elmore soldier (50000 -> 25000)
update droplist set chance = 25000 where itemid = 20089 and mobid = 45216;
-- decrease studdend leather armor droprate from undead elmore soldier (50000 -> 20000)
update droplist set chance = 20000 where itemid = 20147 and mobid = 45216;
-- decrease glaive droprate from undead elmore soldier (50000 -> 25000)
update droplist set chance = 25000 where itemid = 98 and mobid = 45216;

-- add additional drops to undead elmore soldier
-- add clear to undead elmore soldier droplist 
insert into droplist values (45216, 40012, 1, 1, 10000);
-- add low boots to undead elmore soldier droplist 
insert into droplist values (45216, 20213, 1, 1, 10000);
-- add bpm to undead elmore soldier droplist 
insert into droplist values (45216, 20149, 1, 1, 1500);

-- redo adena drop from undead elmore soldier
delete from droplist where itemid = 40308 and mobid = 45216; 
insert into droplist values (45216, 40308, 111, 231, 1000000);

-- modify existing undead elmore wizard drops
-- increase blue pot droprate from undead elmore wizard (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40015 and mobid = 45224;
-- increase sb:coc droprate from undead elmore wizard (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40183 and mobid = 45224;
-- increase btele droprate from undead elmore wizard (50000 -> 100000)
update droplist set chance = 100000 where itemid = 140100 and mobid = 45224;

-- add additional drops to undead elmore wizard
-- add sof to undead elmore wizard droplist 
insert into droplist values (45224, 131, 1, 1, 500);
-- add sb:mass slow to undead elmore wizard droplist 
insert into droplist values (45224, 40221, 1, 1, 1000);

-- redo adena drop from undead elmore wizard
delete from droplist where itemid = 40308 and mobid = 45224; 
insert into droplist values (45224, 40308, 187, 301, 1000000);

-- modify existing undead elmore general drops
-- increase brave pot droprate from undead elmore general (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45248;
-- decrease great sword droprate from undead elmore general (10000 -> 2500)
update droplist set chance = 2500 where itemid = 64 and mobid = 45248;

-- add additional drops to undead elmore general 
-- add low boots to undead elmore general droplist 
insert into droplist values (45248, 20213, 1, 1, 25000);
-- add boots to undead elmore general droplist 
insert into droplist values (45248, 20205, 1, 1, 20000);
-- add spear to undead elmore general droplist 
insert into droplist values (45248, 96, 1, 1, 15000);
-- add glaive to undead elmore general droplist 
insert into droplist values (45248, 98, 1, 1, 10000);
-- add sc:triple arrow to undead elmore general droplist 
insert into droplist values (45248, 40240, 1, 1, 8000);

-- redo adena drop from undead elmore general
delete from droplist where itemid = 40308 and mobid = 45248; 
insert into droplist values (45248, 40308, 227, 365, 1000000);

-- modify existing lesser dragon drops
-- increase nzel droprate from lesser dragon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40074 and mobid = 45496;
-- increase heart of dragon droprate from lesser dragon (500 -> 600)
update droplist set chance = 600 where itemid = 40466 and mobid = 45496;
-- increase tqd droprate from lesser dragon (2000 -> 4000)
update droplist set chance = 4000 where itemid = 40052 and mobid = 45496;
-- increase bzel droprate from lesser dragon (5000 -> 8000)
update droplist set chance = 8000 where itemid = 140074 and mobid = 45496;
-- increase bdai droprate from lesser dragon (1000 -> 4000)
update droplist set chance = 4000 where itemid = 140087 and mobid = 45496;

-- add additional drops to lesser dragon
-- add g-haste pot to lesser dragon droplist 
insert into droplist values (45496, 40018, 1, 1, 50000);
-- add haste pot to lesser dragon droplist 
insert into droplist values (45496, 40013, 1, 1, 50000);
-- add brave pot to lesser dragon droplist 
insert into droplist values (45496, 40014, 1, 1, 75000);
-- add wis pot to lesser dragon droplist 
insert into droplist values (45496, 40016, 1, 3, 75000);
-- add blue pot to lesser dragon droplist 
insert into droplist values (45496, 40015, 1, 3, 75000);
-- add poly scroll to lesser dragon droplist 
insert into droplist values (45496, 40088, 1, 1, 75000);
-- add sb:tame to lesser dragon droplist 
insert into droplist values (45496, 40181, 1, 1, 15000);
-- add ndai to lesser dragon droplist 
insert into droplist values (45496, 40087, 1, 1, 10000);
-- add sb:fb to lesser dragon droplist 
insert into droplist values (45496, 40170, 1, 1, 15000);
-- add sb:haste to lesser dragon droplist 
insert into droplist values (45496, 40188, 1, 1, 10000);
-- add sb:str to lesser dragon droplist 
insert into droplist values (45496, 40187, 1, 1, 10000);
-- add sb:wb to lesser dragon droplist 
insert into droplist values (45496, 40172, 1, 1, 10000);
-- add rosc to lesser dragon droplist 
insert into droplist values (45496, 20284, 1, 1, 400);
-- add sb:g-haste to lesser dragon droplist 
insert into droplist values (45496, 40199, 1, 1, 7500);
-- add dsc:final burn to lesser dragon droplist 
insert into droplist values (45496, 40278, 1, 1, 2500);
-- add sb:gres to lesser dragon droplist 
insert into droplist values (45496, 40220, 1, 1, 2000);

-- modify existing fire ghost (red) drops
-- increase c-oj droprate from fire ghost (red) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40020 and mobid = 45514;

-- modify existing fire ghost (blue) drops
-- increase c-oj droprate from fire ghost (red) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40020 and mobid = 45519;

-- modify existing horrific iron golem drops
-- decrease roe droprate from horrific iron golem (1000 -> 750)
update droplist set chance = 750 where itemid = 20300 and mobid = 45479;
-- increase pg droprate from horrific iron golem (1000 -> 2000)
update droplist set chance = 2000 where itemid = 20187 and mobid = 45479;
-- decrease sc:exotic vitalize droprate from horrific iron golem (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40252 and mobid = 45479;
-- increase brave pot droprate from horrific iron golem (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45479;
-- increase ndai droprate from horrific iron golem (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40087 and mobid = 45479;

-- increase c-oj droprate from nightmare (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40020 and mobid = 45440;

-- modify existing di fungus drops
-- increase fungus juice droprate from di fungus (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40499 and mobid = 45551;
-- increase pine droprate from di fungus (1000 -> 8000)
update droplist set chance = 8000 where itemid = 40006 and mobid = 45551;
-- increase maple droprate from di fungus (1000 -> 10000)
update droplist set chance = 10000 where itemid = 40008 and mobid = 45551;
-- increase nzel droprate from di fungus (1000 -> 9000)
update droplist set chance = 9000 where itemid = 40074 and mobid = 45551;
-- increase ndai droprate from di fungus (500 -> 4000)
update droplist set chance = 4000 where itemid = 40087 and mobid = 45551;
-- increase wis pot droprate from di fungus (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40016 and mobid = 45551;

-- modify existing di fire egg drops
-- increase pine droprate from di fire egg (1000 -> 5000)
update droplist set chance = 5000 where itemid = 40006 and mobid = 45555;
-- increase maple droprate from di fire egg (1000 -> 5000)
update droplist set chance = 5000 where itemid = 40008 and mobid = 45555;
-- increase blue pot droprate from di fire egg (10000 -> 50000)
update droplist set chance = 40015 where itemid = 40015 and mobid = 45555;
-- increase esc scroll droprate from di fire egg (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40079 and mobid = 45555;
-- increase nzel droprate from di fire egg (1000 -> 20000)
update droplist set chance = 20000 where itemid = 40074 and mobid = 45555;
-- increase ndai droprate from di fire egg (500 -> 5000)
update droplist set chance = 5000 where itemid = 40087 and mobid = 45555;
-- increase poly scroll droprate from di fire egg (10000 -> 65000)
update droplist set chance = 65000 where itemid = 40088 and mobid = 45555;
-- increase nprat droprate from di fire egg (10000 -> 65000)
update droplist set chance = 65000 where itemid = 40119 and mobid = 45555;
-- increase bzel droprate from di fire egg (100 -> 1000)
update droplist set chance = 1000 where itemid = 140074 and mobid = 45555;
-- increase bdai droprate from di fire egg (50 -> 500)
update droplist set chance = 500 where itemid = 140087 and mobid = 45555;
-- increase g-haste pot droprate from di fire egg (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45555;

-- modify existing di salamander drops
-- increase ebony droprate from di salamander (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40007 and mobid = 45552;
-- increase haste pot droprate from di salamander (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40013 and mobid = 45552;
-- increase brave pot droprate from di salamander (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40014 and mobid = 45552;
-- increase nzel droprate from di salamander (1000 -> 9000)
update droplist set chance = 9000 where itemid = 40074 and mobid = 45552;
-- increase ndai droprate from di salamander (500 -> 2000)
update droplist set chance = 2000 where itemid = 40087 and mobid = 45552;

-- add additional drops to di salamander
-- add 2hs to di salamander droplist 
insert into droplist values (45552, 52, 1, 1, 15000);
-- add g-axe to di salamander droplist 
insert into droplist values (45552, 143, 1, 1, 12000);
-- add sb:summon to di salamander droplist 
insert into droplist values (45552, 40196, 1, 1, 150);

-- modify existing di ice man drops
-- increase pine droprate from di ice man (1000 -> 2000)
update droplist set chance = 2000 where itemid = 40006 and mobid = 45556;
-- increase ebony droprate from di ice man (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40007 and mobid = 45556;
-- increase maple droprate from di ice man (1000 -> 2500)
update droplist set chance = 2500 where itemid = 40008 and mobid = 45556;
-- increase nzel droprate from di ice man (1000 -> 7500)
update droplist set chance = 7500 where itemid = 40074 and mobid = 45556;
-- increase ndai droprate from di ice man (500 -> 3000)
update droplist set chance = 3000 where itemid = 40087 and mobid = 45556;
-- increase red pot droprate from di ice man (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40010 and mobid = 45556;
-- increase orange pot droprate from di ice man (10000 -> 35000)
update droplist set chance = 35000 where itemid = 40011 and mobid = 45556;
-- increase clear pot droprate from di ice man (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40012 and mobid = 45556;

-- add additional drops to di ice man 
-- add lvl1 blank to di ice man droplist 
insert into droplist values (45556, 40090, 1, 1, 10000);

-- modify existing di ice golem drops
-- increase pine droprate from di ice golem (1000 -> 2000)
update droplist set chance = 2000 where itemid = 40006 and mobid = 45553;
-- increase ebony droprate from di ice golem (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40007 and mobid = 45553;
-- increase maple droprate from di ice golem (1000 -> 2500)
update droplist set chance = 2500 where itemid = 40008 and mobid = 45553;
-- increase hqd droprate from di ice golem (1000 -> 5000)
update droplist set chance = 5000 where itemid = 40048 and mobid = 45553;
-- increase nzel droprate from di ice golem (1000 -> 12000)
update droplist set chance = 12000 where itemid = 40074 and mobid = 45553;
-- increase ndai droprate from di ice golem (500 -> 4500)
update droplist set chance = 4500 where itemid = 40087 and mobid = 45553;
-- increase wis pot droprate from di ice golem (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40016 and mobid = 45553;

-- modify existing killer bee drops
-- increase pine droprate from killer bee (1000 -> 10000)
update droplist set chance = 10000 where itemid = 40006 and mobid = 45554;
-- increase maple droprate from killer bee (1000 -> 10000)
update droplist set chance = 10000 where itemid = 40008 and mobid = 45554;
-- increase brave pot droprate from killer bee (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40014 and mobid = 45554;
-- increase wis pot droprate from killer bee (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40016 and mobid = 45554;
-- increase hqd droprate from killer bee (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40048 and mobid = 45554;
-- increase nzel droprate from killer bee (1000 -> 35000)
update droplist set chance = 35000 where itemid = 40074 and mobid = 45554;
-- increase ndai droprate from killer bee (500 -> 20000)
update droplist set chance = 20000 where itemid = 40087 and mobid = 45554;

-- modify existing ball lightning drops
-- increase pine droprate from ball lightning (1000 -> 15000)
update droplist set chance = 15000 where itemid = 40006 and mobid = 45549;
-- increase ebony droprate from ball lightning (10000 -> 65000)
update droplist set chance = 65000 where itemid = 40007 and mobid = 45549;
-- increase maple droprate from ball lightning (1000 -> 15000)
update droplist set chance = 15000 where itemid = 40008 and mobid = 45549;
-- increase blue pot droprate from ball lightning (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40015 and mobid = 45549;
-- increase nzel droprate from ball lightning (1000 -> 6000)
update droplist set chance = 6000 where itemid = 40074 and mobid = 45549;
-- increase ndai droprate from ball lightning (500 -> 2500)
update droplist set chance = 2500 where itemid = 40087 and mobid = 45549;

-- modify existing will o\' wisp drops
-- increase pine droprate from will o\' wisp (1000 -> 15000)
update droplist set chance = 15000 where itemid = 40006 and mobid in (45557, 45558, 45559, 45560, 45561);
-- increase maple droprate from will o\' wisp (1000 -> 15000)
update droplist set chance = 15000 where itemid = 40008 and mobid in (45557, 45558, 45559, 45560, 45561);
-- increase nzel droprate from will o\' wisp (1000 -> 6000)
update droplist set chance = 6000 where itemid = 40074 and mobid in (45557, 45558, 45559, 45560, 45561);
-- increase ndai droprate from will o\' wisp (500 -> 2500)
update droplist set chance = 2500 where itemid = 40087 and mobid in (45557, 45558, 45559, 45560, 45561);

-- modify TOI 4F spawn
-- decrease mutant arachnevil elder count (70 -> 30)
update spawnlist set count = 30 where npc_templateid = 45348 and mapid = 104;
-- increase medusa count (18 -> 50)
update spawnlist set count = 50 where npc_templateid = 45380 and mapid = 104;

-- modify TOI 19F spawn
-- decrease dire wolf count (90 -> 80)
update spawnlist set count = 80 where npc_templateid = 45409 and mapid = 119;

-- modify TOI 21F spawn
-- increase horrific fire egg count (15 -> 45)
update spawnlist set count = 45 where npc_templateid = 45384 and mapid = 121;
-- decrease nightmare count (45 -> 25)
update spawnlist set count = 25 where npc_templateid = 45440 and mapid = 121;

-- modify TOI 22F spawn
-- increase horrific fire egg count (20 -> 35)
update spawnlist set count = 30 where npc_templateid = 45384 and mapid = 122;
-- decrease nightmare  count (45 -> 30)
update spawnlist set count = 30 where npc_templateid = 45440 and mapid = 122;
-- increase horrific cerebus count (23 -> 30)
update spawnlist set count = 30 where npc_templateid = 45471 and mapid = 122;

-- modify TOI 23F spawn
-- increase horrific fire egg count (19 -> 30)
update spawnlist set count = 30 where npc_templateid = 45384 and mapid = 123;
-- decrease nightmare  count (50 -> 35)
update spawnlist set count = 35 where npc_templateid = 45440 and mapid = 123;
-- increase horrific cerebus count (19 -> 35)
update spawnlist set count = 35 where npc_templateid = 45471 and mapid = 123;

-- modify TOI 24F spawn
-- increase horrific fire egg count (38 -> 76)
update spawnlist set count = 76 where npc_templateid = 45384 and mapid = 124;
-- decrease nightmare  count (86 -> 45)
update spawnlist set count = 45 where npc_templateid = 45440 and mapid = 124;
-- increase horrific cerebus count (30 -> 45)
update spawnlist set count = 45 where npc_templateid = 45471 and mapid = 124;

-- modify TOI 31F spawn
-- increase raging ghoul count (13 -> 20)
update spawnlist set count = 20 where npc_templateid = 45454 and mapid = 131;

-- modify TOI 32F spawn
-- increase raging ghoul count (6 -> 20)
update spawnlist set count = 20 where npc_templateid = 45454 and mapid = 132;

-- modify TOI 33F spawn
-- increase raging ghoul count (14 -> 16)
update spawnlist set count = 16 where npc_templateid = 45454 and mapid = 133;
-- increase raging spartoi ount (7 -> 10)
update spawnlist set count = 10 where npc_templateid = 45455 and mapid = 133;

-- modify TOI 34F spawn
-- increase raging ghoul count (16 -> 20)
update spawnlist set count = 20 where npc_templateid = 45454 and mapid = 134;

-- modify giran 1f spawn
-- decrease giran imp count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45125 and mapid = 53;
-- decrease giran ghast count (60 -> 50)
update spawnlist set count = 50 where npc_templateid = 32831 and mapid = 53;
-- decrease giran imp elder count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45168 and mapid = 53;
-- decrease giran ghast lord count (40 -> 30)
update spawnlist set count = 30 where npc_templateid = 45188 and mapid = 53;

-- modify giran 2f spawn
-- decrease giran lizardman count (40 -> 32)
update spawnlist set count = 32 where npc_templateid = 45156 and mapid = 54;
-- decrease giran crabman count (40 -> 32)
update spawnlist set count = 32 where npc_templateid = 45169 and mapid = 54;
-- decrease giran vakuuk count (40 -> 32)
update spawnlist set count = 32 where npc_templateid = 45187 and mapid = 54;
-- decrease giran arachnevil elder count (40 -> 32)
update spawnlist set count = 32 where npc_templateid = 45312 and mapid = 54;

-- modify giran 3f spawn
-- decrease giran tiger count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45243 and mapid = 55;
-- decrease giran cerebus count (30 -> 28)
update spawnlist set count = 28 where npc_templateid = 45283 and mapid = 55;
-- decrease giran cimaera count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45325 and mapid = 55;

-- modify heine 1f spawn
-- decrease lizardman count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45144 and mapid = 59;
-- decrease alligator count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45307 and mapid = 59;
-- decrease vakuuk count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45116 and mapid = 59;
-- decrease ratman count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45192 and mapid = 59;
-- decrease troglodyte count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45155 and mapid = 59;

-- modify heine 4f spawn
-- decrease shark count (150 -> 120)
update spawnlist set count = 120 where npc_templateid = 45160 and mapid = 63;

-- modify dvc 1f spawn
-- decrease skeleton marksman count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45270 and mapid = 30;
-- decrease skeleton guard count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45269 and mapid = 30;
-- decrease skeleton fighter count (30 -> 24)
update spawnlist set count = 26 where npc_templateid = 45286 and mapid = 30;
-- decrease spartoi count (30 -> 24)
update spawnlist set count = 26 where npc_templateid = 45161 and mapid = 30;
-- decrease arachnevil elder count (20 -> 14)
update spawnlist set count = 14 where npc_templateid = 45184 and mapid = 30;

-- modify dvc 2f spawn
-- decrease skeleton marksman count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45270 and mapid = 31;
-- decrease skeleton guard count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45269 and mapid = 31;
-- decrease skeleton fighter count (30 -> 24)
update spawnlist set count = 24 where npc_templateid = 45286 and mapid = 31;
-- decrease muryan count (20 -> 18)
update spawnlist set count = 18 where npc_templateid = 45289 and mapid = 31;
         
-- modify dvc 3f spawn
-- decrease skeleton marksman count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45270 and mapid = 32;
-- decrease skeleton guard count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45269 and mapid = 32;
-- decrease skeleton fighter count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45286 and mapid = 32;
-- decrease muryan count (20 -> 18)
update spawnlist set count = 26 where npc_templateid = 45289 and mapid = 32;
-- decrease ettin count (10 -> 8)
update spawnlist set count = 8 where npc_templateid = 45373 and mapid = 32;
         
-- modify dvc 4f spawn
-- decrease skeleton marksman count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45270 and mapid = 33;
-- decrease skeleton guard count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45269 and mapid = 33;
-- decrease skeleton fighter count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45286 and mapid = 33;
-- decrease muryan count (20 -> 18)
update spawnlist set count = 26 where npc_templateid = 45289 and mapid = 33;
-- decrease ettin count (10 -> 8)
update spawnlist set count = 8 where npc_templateid = 45373 and mapid = 33;

-- modify dvc 5f spawn
-- decrease muryan count (30 -> 26)
update spawnlist set count = 26 where npc_templateid = 45289 and mapid = 35;
-- decrease ettin count (20 -> 14)
update spawnlist set count = 14 where npc_templateid = 45373 and mapid = 35;
-- decrease succubus count (20 -> 18)
update spawnlist set count = 36 where npc_templateid = 45393 and mapid = 35;
-- decrease ettin count (10 -> 8)
update spawnlist set count = 8 where npc_templateid = 45451 and mapid = 35;

-- modify dvc 6f spawn
-- decrease ettin count (40 -> 20)
update spawnlist set count = 20 where npc_templateid = 45373 and mapid = 36;
-- decrease succubus count (40 -> 36)
update spawnlist set count = 36 where npc_templateid = 45393 and mapid = 36;
-- decrease ettin count (20 -> 18)
update spawnlist set count = 18 where npc_templateid = 45451 and mapid = 36;

-- activate 0 count skeleton marksman, fighter, guard spawnpoints and remove doublespawns
update spawnlist set count = 1 where npc_templateid in (45269, 45270, 45286) and mapid = 4;
-- activate 0 count scorpion spawnpoints and remove doublespawns
update spawnlist set count = 1 where npc_templateid = 45259 and mapid = 4;

