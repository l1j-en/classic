-- update 19

-- make kurtz sword tradable
update weapon set trade = 0 where item_id = 54;

-- correct name of Fairy Princess (was nothing)
update npc set name = 'Fairy Princess' where npcid = 70853;

-- correct name of Fairy Queen (was nothing)
update npc set name = 'Fairy Queen' where npcid = 70852;

-- correct name of Black Tiger (was nothing)
update npc set name = 'Black Tiger' where npcid = 45836;

-- correct name of Skeletal Pirate Head (was Skeleton Skull)
update npc set name = 'Skeletal Pirate Head' where npcid = 45330;

-- correct name of Remains of Son
update etcitem set name = 'Remains of Son' where item_id = 40661;

-- correct name of Portrait of Son
update etcitem set name = 'Portrait of Son' where item_id = 40662; 

-- correct name of Native\'s Totem
update etcitem set name = 'Native\'s Totem' where item_id = 40329;

-- correct name of Letter of Son
update etcitem set name = 'Letter of Son' where item_id = 40663;

-- correct name of Resta\'s Ring
update etcitem set name = 'Resta\'s Ring' where item_id = 40631;

-- correct name of Rind of Plate Worm (was Metal Scorpion\'s Skin)
update etcitem set name = 'Rind of Plate Worm' where item_id = 40483;

-- correct name of Venom of Plate Worm (was Metal Scorpion\'s Poison)
update etcitem set name = 'Venom of Plate Worm' where item_id = 40484;

-- correct name of Fang of Plate Worm (was Metal Scorpion\'s Tooth)
update etcitem set name = 'Fang of Plate Worm' where item_id = 40485;

-- correct name of Potion of Dark Forest (was Dark Forest Potion)
update etcitem set name = 'Potion of Dark Forest' where item_id = 40425;

-- correct name of Ring of Dark Forester (was Dark Forest Ring)
update etcitem set name = 'Ring of Dark Forester' where item_id = 40426;

-- correct name of Boots of Dark Forester (was Boot of Dark Forester)
update armor set name = 'Boots of Dark Forester' where item_id = 20196;

-- correct name of Cursed Sapphire Ring (was Cursed Saphire Ring)
update armor set name = 'Cursed Sapphire Ring' where item_id = 20295;

-- correct name of Elven Bow (was Bow)
update weapon set name = 'Elven Bow' where item_id = 170;

-- correct name of Ivory Tower Bow (was Elven Bow)
update weapon set name = 'Ivory Tower Bow' where item_id = 175;

-- correct name of Bow (was Short Bow)
update weapon set name = 'Bow' where item_id = 172;

-- correct name of Short Bow (was Stupid Bow)
update weapon set name = 'Short Bow' where item_id = 173;

-- replace bow in starting items with short bow
update beginner set item_id = 173 where item_id = 172;

-- set FQ's movement distance to 0
update spawnlist_npc set movement_distance = 0 where npc_templateid = 70852;

-- decrease dex ammy droprate from phoenix (50000 -> 15000)
update droplist set chance = 15000 where itemid = 20256 and mobid = 45617;
-- decrease ropc droprate from phoenix (70000 -> 25000)
update droplist set chance = 25000 where itemid = 20281 and mobid = 45617;
-- decrease rof droprate from phoenix (d0000 -> 25000)
update droplist set chance = 25000 where itemid = 20304 and mobid = 45617;

-- increase phoenix regen (250 -> 320)
update npc set hpr = 320 where npcid = 45617;

-- increase mobskill leverage of phoenix ranged attack (10 -> 12)
update mobskill set leverage = 12 where mobid = 45617 and actno = 0;

-- increase a-g's aoe range to prevent cliffing
update mobskill set trirange = -10 where mobid = 45610 and actno = 0;

-- set berserker axe to sell for 900a (was 1a)
update shop set purchasing_price = 900 where item_id = 145 and npc_id in (70074, 70018, 70021, 70030, 70045, 70063, 70079, 70014);

-- reduce wand weight (7000 -> 70)
update etcitem set weight = 70 where item_id in (40006, 40007, 40008, 40009);

-- reduce gem gamble bag weight (10000 -> 1000)
update etcitem set weight = 1000 where item_id in (49005, 49006, 49007, 49008, 49009, 49010, 49011, 49012);

-- change lasta 3f theif spawn to ones with drops
update spawnlist set npc_templateid = 45272 where mapid = 308 and npc_templateid in (45220);

-- reduce spawn in ancient giant ruins
update spawnlist set count = 1 where count = 2 and mapid = 400 and npc_templateid in (45498, 45530, 45537, 45603);

-- modify existing gelatinous cube drops
-- increase mith plate droprate from gelatinous cube (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40497 and mobid = 45296;
-- increase ori plate droprate from gelatinous cube (10000 -> 12000)
update droplist set chance = 12000 where itemid = 40509 and mobid = 45296;

-- modify existing dire bat drops
-- increase wis pot droprate from dire bat (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40016 and mobid = 45219;
-- increase ntele droprate from dire bat (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40100 and mobid = 45219;

-- modify existing gc dire wolf drops
-- increase clear pot droprate from gc dire wolf (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40012 and mobid = 45237;
-- increase brave pot droprate from gc dire wolf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45237;
-- increase wis pot droprate from gc dire wolf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40016 and mobid = 45237;
-- decrease sb:hw droprate from gc dire wolf (2000 -> 500)
update droplist set chance = 500 where itemid = 40197 and mobid = 45237;

-- add additional drops to gc dire wolf 
-- add meat to gc dire wolf droplist 
insert into droplist values (45237, 40056, 1, 1, 75000);
-- add nprat to gc dire wolf droplist 
insert into droplist values (45237, 40097, 1, 1, 75000);
-- add haste pot to gc dire wolf droplist 
insert into droplist values (45237, 40013, 1, 1, 50000);
-- add bbs to gc dire wolf droplist 
insert into droplist values (45237, 40524, 1, 1, 10000);

-- modify existing gc dire bear drops
-- increase nzel droprate from gc dire bear (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40074 and mobid = 45252;
-- increase ntele droprate from gc dire bear (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40100 and mobid = 45252;
-- increase nprat droprate from gc dire bear (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40119 and mobid = 45252;

-- add additional drops to gc dire bear 
-- add wis pot to gc dire bear droplist 
insert into droplist values (45252, 40016, 1, 1, 60000);

-- modify existing black ent drops
-- increase clear pot droprate from black ent (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40012 and mobid = 45367;
-- increase brave pot droprate from black ent (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40014 and mobid = 45367;
-- increase nzel droprate from black ent (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45367;
-- increase Bark of Dark Ent droprate from black ent (1000 -> 1500)
update droplist set chance = 1500 where itemid = 40410 and mobid = 45367;
-- increase Fruit of Dark Ent droprate from black ent (1000 -> 1500)
update droplist set chance = 1500 where itemid = 40411 and mobid = 45367;
-- increase Twig of Dark Ent droprate from black ent (1000 -> 1500)
update droplist set chance = 1500 where itemid = 40412 and mobid = 45367;
-- increase Black Mithril Stone droprate from black ent (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40444 and mobid = 45367;
-- increase Dark Elven Stone droprate from black ent (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40490 and mobid = 45367;

-- modify existing deep flower drops
-- increase orange pot droprate from deep flower (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40011 and mobid = 45273;

-- add additional drops to deep flower 
-- add nprat to deep flower droplist 
insert into droplist values (45273, 85000, 1, 1, 25000);
-- add haste pot to deep flower droplist 
insert into droplist values (45273, 40013, 1, 1, 50000);
-- add ntele to deep flower droplist 
insert into droplist values (45273, 40100, 1, 1, 50000);
-- add cure pot to deep flower droplist 
insert into droplist values (45273, 40017, 1, 1, 50000);

-- modify existing dark elementalist drops
-- decrease sb:i2h droprate from dark elementalist (400 -> 350)
update droplist set chance = 350 where itemid = 40213 and mobid = 45245;
-- increase nzel droprate from dark elementalist (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45245;
-- increase wis pot droprate from dark elementalist (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40016 and mobid = 45245;
-- increase nprat droprate from dark elementalist (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40119 and mobid = 45245;
-- increase bbs droprate from dark elementalist (10000 -> 12000)
update droplist set chance = 12000 where itemid = 40524 and mobid = 45245;

-- modify existing gc dark elementalist drops
-- decrease sb:i2h droprate from gc dark elementalist (1000 -> 250)
update droplist set chance = 250 where itemid = 40213 and mobid = 45363;
-- decrease sb:dk pot droprate from gc dark elementalist (500 -> 400)
update droplist set chance = 400 where itemid = 40216 and mobid = 45363;

-- add additional drops to gc dark elementalist 
-- add Piece of Large Cave Scroll to gc dark elementalist droplist 
insert into droplist values (45363, 40429, 1, 1, 50000);

-- modify existing lizardman drops
-- increase homr droprate from lizardman (10000 -> 12500)
update droplist set chance = 12500 where itemid = 20011 and mobid = 45144;
-- increase haste pot droprate from lizardman (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40013 and mobid = 45144;
-- increase sapphire droprate from lizardman (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40046 and mobid = 45144;

-- add additional drops to lizardman 
-- add cmomr to lizardman droplist 
insert into droplist values (45144, 20110, 1, 1, 500);
-- add hqs to lizardman droplist 
insert into droplist values (45144, 40050, 1, 1, 5000);

-- modify existing owlbear drops
-- increase brave pot droprate from owlbear (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40014 and mobid = 45147;

-- add additional drops to owlbear 
-- add carrot to owlbear droplist 
insert into droplist values (45147, 40060, 1, 1, 150000);
-- add haste pot to owlbear droplist 
insert into droplist values (45147, 40013, 1, 1, 25000);

-- modify existing lycanthrope drops
-- decrease scale mail droprate from lycanthrope (50000 -> 40000)
update droplist set chance = 40000 where itemid = 20122 and mobid = 45173;
-- decrease fauchard droprate from lycanthrope (50000 -> 35000)
update droplist set chance = 35000 where itemid = 104 and mobid = 45173;

-- modify existing dark elf drops
-- increase sc:wind shot droprate from dark elf (5000 -> 7500)
update droplist set chance = 7500 where itemid = 40260 and mobid = 45265;
-- decrease sc:r2n droprate from dark elf (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40237 and mobid = 45265;
-- increase elven cloak droprate from dark elf (10000 -> 15000)
update droplist set chance = 15000 where itemid = 20073 and mobid = 45265;
-- increase elven cloak droprate from dark elf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40068 and mobid = 45265;

-- redo mith arrow drop on dark elf
delete from droplist where itemid = 40746 and mobid = 45265;
insert into droplist values (45265, 40746, 75, 450, 150000);

-- add additional drops to dark elf 
-- add diamond to dark elf droplist 
insert into droplist values (45265, 40044, 1, 1, 7500);
-- add devil's blood to dark elf droplist 
insert into droplist values (45265, 40031, 1, 1, 5000);

-- add additional drops to bandit leader 
-- add tqs to bandit leader droplist 
insert into droplist values (45370, 40054, 1, 1, 15000);
-- add devil's blood to bandit leader droplist 
insert into droplist values (45370, 40031, 1, 1, 25000);

-- modify existing griffon drops
-- increase btele droprate from griffon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45321;
-- decrease sb:tornado droprate from griffon (5000 -> 2500)
update droplist set chance = 2500 where itemid = 40198 and mobid = 45321;
-- decrease sc:r2n droprate from griffon (10000 -> 4500)
update droplist set chance = 4500 where itemid = 40237 and mobid = 45321;
-- increase hqs droprate from griffon (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40050 and mobid = 45321;

-- remove b-splint mail from griffon droplist
delete from droplist where itemid = 120101 and mobid = 45321;

-- add additional drops to griffon 
-- add diamond to griffon droplist 
insert into droplist values (45321, 40044, 1, 1, 45000);
-- add red pot to griffon droplist 
insert into droplist values (45321, 40010, 1, 1, 75000);
-- add banded mail to griffon droplist 
insert into droplist values (45321, 20101, 1, 1, 20000);
-- add g-haste pot to griffon droplist 
insert into droplist values (45321, 40018, 1, 1, 50000);
-- add tqs to griffon droplist 
insert into droplist values (45321, 40054, 1, 1, 8000);
-- add sb:c-m to griffon droplist 
insert into droplist values (45321, 40176, 1, 1, 8500);

-- modify existing cyclops drops
-- decrease b-banded mail droprate from cyclops (50000 -> 20000)
update droplist set chance = 20000 where itemid = 220101 and mobid = 45420;
-- increase brave pot droprate from cyclops (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40014 and mobid = 45420;
-- decrease sb:silence droprate from cyclops (4500 -> 4000)
update droplist set chance = 4000 where itemid = 4500 and mobid = 45420;
-- decrease sb:eq droprate from cyclops (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40207 and mobid = 45420;
-- decrease sb:summon droprate from cyclops (5000 -> 2500)
update droplist set chance = 2500 where itemid = 40196 and mobid = 45420;
-- decrease sc:entangle droprate from cyclops (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40248 and mobid = 45420;
-- decrease sc:bless of earth droprate from cyclops (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40250 and mobid = 45420;
-- increase bzel droprate from cyclops (10000 -> 12000)
update droplist set chance = 12000 where itemid = 140074 and mobid = 45420;

-- add additional drops to cyclops 
-- add red pot to cyclops droplist 
insert into droplist values (45420, 40010, 1, 1, 75000);
-- add sb:ej to cyclops droplist 
insert into droplist values (45420, 40175, 1, 1, 10000);
-- add sb:disease to cyclops droplist 
insert into droplist values (45420, 40201, 1, 1, 4500);
-- add nzel to cyclops droplist 
insert into droplist values (45420, 40074, 1, 1, 25000);

-- modify existing Dark Forester drops
-- increase Armor of Dark Forester droprate from Dark Forester (5000 -> 7500)
update droplist set chance = 7500 where itemid = 20098 and mobid = 45347;
-- increase Boots of Dark Forester droprate from Dark Forester (5000 -> 6500)
update droplist set chance = 6500 where itemid = 20196 and mobid = 45347;
-- increase nzel droprate from Dark Forester (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40074 and mobid = 45347;

-- modify existing Dark Elf Carrier drops
-- increase Lastabad Spear droprate from Dark Elf Carrier (5000 -> 7500)
update droplist set chance = 7500 where itemid = 101 and mobid = 45293;

-- modify existing Beast Summoner drops
-- increase clear pot droprate from Beast Summoner (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40012 and mobid = 45368;
-- increase haste pot droprate from Beast Summoner (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40013 and mobid = 45368;

-- add additional drops to Beast Summoner 
-- add pine wand to Beast Summoner droplist 
insert into droplist values (45368, 40006, 1, 1, 25000);

-- modify existing Black Wizard drops
-- increase bw ammy droprate from Black Wizard (100 -> 200)
update droplist set chance = 200 where itemid = 20257 and mobid = 45405;
-- increase clear pot droprate from Black Wizard (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40012 and mobid = 45405;
-- increase blue pot droprate from Black Wizard (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45405;

-- modify existing Heavy Oum drops
-- increase nzel droprate from Heavy Oum (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40074 and mobid = 45453;
-- increase ndai droprate from Heavy Oum (5000 -> 7500)
update droplist set chance = 7500 where itemid = 40087 and mobid = 45453;
-- increase bzel droprate from Heavy Oum (5000 -> 10000)
update droplist set chance = 10000 where itemid = 140074 and mobid = 45453;

-- modify existing Dark Elf Hunter drops
-- increase Lastabad Leather Armor droprate from Dark Elf Hunter (5000 -> 8500)
update droplist set chance = 8500 where itemid = 20102 and mobid = 45238;
-- increase Lastabad Boots droprate from Dark Elf Hunter (5000 -> 7500)
update droplist set chance = 7500 where itemid = 20199 and mobid = 45238;
-- increase wis pot droprate from Dark Elf Hunter (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40016 and mobid = 45238;
-- increase ntele droprate from Dark Elf Hunter (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40100 and mobid = 45238;
-- increase nprat droprate from Dark Elf Hunter (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40119 and mobid = 45238;
-- increase lastabad bow droprate from Dark Elf Hunter (5000 -> 7500)
update droplist set chance = 7500 where itemid = 176 and mobid = 45238;
-- increase Lastabad Blade droprate from Dark Elf Hunter (5000 -> 6500)
update droplist set chance = 6500 where itemid = 10 and mobid = 45238;

-- modify existing Dark Elf Apprentice drops
-- decrease lasta robe droprate from Dark Elf Apprentice (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20103 and mobid = 45256;
-- decrease lasta staff droprate from Dark Elf Apprentice (5000 -> 3000)
update droplist set chance = 3000 where itemid = 122 and mobid = 45256;

-- add additional drops to Dark Elf Apprentice 
-- add dsc:dress evasion to Dark Elf Apprentice droplist 
insert into droplist values (45256, 40279, 1, 1, 2500);

-- modify existing Dark Elf Soldier drops
-- increase Lastabad Leather Armor droprate from Dark Elf Soldier (5000 -> 8500)
update droplist set chance = 8500 where itemid = 20102 and mobid = 45404;
-- increase Lastabad Boots droprate from Dark Elf Soldier (5000 -> 7500)
update droplist set chance = 7500 where itemid = 20199 and mobid = 45404;
-- increase Lastabad Long Sword droprate from Dark Elf Soldier (5000 -> 6000)
update droplist set chance = 6000 where itemid = 38 and mobid = 45404;
-- increase nzel droprate from Dark Elf Soldier (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40074 and mobid = 45404;
-- increase ndai droprate from Dark Elf Soldier (5000 -> 6000)
update droplist set chance = 6000 where itemid = 40087 and mobid = 45404;
-- increase wis pot droprate from Dark Elf Soldier (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40016 and mobid = 45404;
-- increase ntele droprate from Dark Elf Soldier (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40100 and mobid = 45404;
-- increase nprat droprate from Dark Elf Soldier (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40119 and mobid = 45404;

-- add additional drops to Dark Elf Soldier 
-- add lastabad studded leather armor to Dark Elf Soldier droplist 
insert into droplist values (45404, 20104, 1, 1, 4500);
-- add dsc:enchant venom to Dark Elf Soldier droplist 
insert into droplist values (45404, 40266, 1, 1, 3500);

-- modify existing Dark Elf Guard (bow) drops
-- increase blue pot droprate from Dark Elf Guard (bow) (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40015 and mobid = 45411;
-- increase ndai droprate from Dark Elf Guard (bow) (5000 -> 7500)
update droplist set chance = 7500 where itemid = 40087 and mobid = 45411;
-- increase ntele droprate from Dark Elf Guard (bow) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40100 and mobid = 45411;
-- decrease sb:hw droprate from Dark Elf Guard (bow) (2000 -> 1500)
update droplist set chance = 1500 where itemid = 40197 and mobid = 45411;
-- increase lasta blade droprate from Dark Elf Guard (bow) (5000 -> 6500)
update droplist set chance = 6500 where itemid = 10 and mobid = 45411;
-- increase lhxbow droprate from Dark Elf Guard (bow) (2500 -> 3000)
update droplist set chance = 3000 where itemid = 188 and mobid = 45411;

-- modify existing Dark Elf Guard (spear) drops
-- increase Lastabad Studded Leather Armor  droprate from Dark Elf Guard (spear) (5000 -> 6500)
update droplist set chance = 6500 where itemid = 20104 and mobid = 45412;
-- increase Lastabad Round Shield droprate from Dark Elf Guard (spear) (5000 -> 7000)
update droplist set chance = 7000 where itemid = 20224 and mobid = 45412;
-- increase red pot droprate from Dark Elf Guard (spear) (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40010 and mobid = 45412;
-- increase orange pot droprate from Dark Elf Guard (spear) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45412;
-- increase brave pot droprate from Dark Elf Guard (spear) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45412;
-- increase nzel droprate from Dark Elf Guard (spear) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45412;
-- increase ntele droprate from Dark Elf Guard (spear) (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40100 and mobid = 45412;
-- increase nprat droprate from Dark Elf Guard (spear) (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40119 and mobid = 45412;
-- decrease dsc:shadow fang droprate from Dark Elf Guard (spear) (10000 -> 3500)
update droplist set chance = 3500 where itemid = 40277 and mobid = 45412;
-- increase lasta spear droprate from Dark Elf Guard (spear) (5000 -> 6500)
update droplist set chance = 6500 where itemid = 101 and mobid = 45412;

-- modify existing Dark Elf Wizard drops
-- increase wis pot droprate from Dark Elf Wizard (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40016 and mobid = 45447;
-- increase nzel droprate from Dark Elf Wizard (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45447;
-- increase ntele droprate from Dark Elf Wizard (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40100 and mobid = 45447;
-- increase nprat droprate from Dark Elf Wizard (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40119 and mobid = 45447;
-- decrease sb:fog of sleeping droprate from Dark Elf Wizard (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40211 and mobid = 45447;
-- decrease sb:i2h droprate from Dark Elf Wizard (500 -> 400)
update droplist set chance = 400 where itemid = 40213 and mobid = 45447;
-- decrease sb:counter detect droprate from Dark Elf Wizard (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40217 and mobid = 45447;
-- increase sb:meteor droprate from Dark Elf Wizard (100 -> 120)
update droplist set chance = 120 where itemid = 40219 and mobid = 45447;
-- decrease sb:mass slow droprate from Dark Elf Wizard (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40221 and mobid = 45447;
-- increase sb:adv droprate from Dark Elf Wizard (100 -> 150)
update droplist set chance = 150 where itemid = 40224 and mobid = 45447;
-- increase bbs droprate from Dark Elf Wizard (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45447;

-- modify existing Dark Elf Thief drops
-- increase lasta leather armor droprate from Dark Elf Thief (5000 -> 6500)
update droplist set chance = 6500 where itemid = 20102 and mobid = 45272;
-- decrease sb:hw droprate from Dark Elf Thief (1500 -> 800)
update droplist set chance = 800 where itemid = 40197 and mobid = 45272;
-- decrease sb:dk pot droprate from Dark Elf Thief (500 -> 400)
update droplist set chance = 400 where itemid = 40216 and mobid = 45272;
-- decrease dsc:final burn droprate from Dark Elf Thief (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40278 and mobid = 45272;
-- increase mith arrow droprate from Dark Elf Thief (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40746 and mobid = 45272;

-- add additional drops to Dark Elf Thief 
-- add lasta bow to Dark Elf Thief droplist 
insert into droplist values (45272, 176, 1, 1, 5000);
-- add lastabad dagger to Dark Elf Thief droplist 
insert into droplist values (45272, 6, 1, 1, 7500);
-- add sb:meteor to Dark Elf Thief droplist 
insert into droplist values (45272, 40219, 1, 1, 50);

-- modify existing dark elf beast tamer drops
-- increase red pot droprate from dark elf beast tamer (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40010 and mobid = 45356;
-- increase orange pot droprate from dark elf beast tamer (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45356;
-- increase brave pot droprate from dark elf beast tamer (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45356;
-- increase nzel droprate from dark elf beast tamer (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40074 and mobid = 45356;
-- decrease dsc:dress dex droprate from dark elf beast tamer (10000 -> 3500)
update droplist set chance = 3500 where itemid = 40274 and mobid = 45356;
-- increase dsc:double break droprate from dark elf beast tamer (10000 -> 4500)
update droplist set chance = 4500 where itemid = 40275 and mobid = 45356;

-- add additional drops to dark elf beast tamer 
-- add g-haste pot to dark elf beast tamer droplist 
insert into droplist values (45356, 40018, 1, 1, 25000);

-- remove c-red from toi nightmare
delete from droplist where itemid = 40019 and mobid = 45440;

-- redo c-oj drop on toi nightmare
delete from droplist where itemid = 40020 and mobid = 45440;
insert into droplist values (45440, 40020, 1, 3, 170000);

-- modify existing lesser dragon drops
-- decrease rosc droprate from lesser dragon (400 -> 300)
update droplist set chance = 300 where itemid = 20284 and mobid = 45496;
-- increase diamond droprate from lesser dragon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40044 and mobid = 45496;
-- increase ruby droprate from lesser dragon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40045 and mobid = 45496;
-- increase sapphire droprate from lesser dragon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40046 and mobid = 45496;
-- increase emerald droprate from lesser dragon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40047 and mobid = 45496;
-- decrease sb:firewall droprate from lesser dragon (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40203 and mobid = 45496;

-- modify existing Priest of Chaos (lvl 22) drops
-- increase Fragment of Soulstone droprate from Priest of Chaos (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40678 and mobid in (45226, 45626);

-- modify existing Priest of Chaos (lvl 55) drops
-- increase Fragment of Soulstone droprate from Priest of Chaos (lvl 55) (10000 -> 70000)
update droplist set chance = 70000 where itemid = 40678 and mobid = 45599;
-- increase black mith droprate from Priest of Chaos (lvl 55) (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40444 and mobid = 45599;

-- modify existing Priest of Chaos (lvl 52) drops
-- increase Fragment of Soulstone droprate from Priest of Chaos (lvl 55) (10000 -> 70000)
update droplist set chance = 70000 where itemid = 40678 and mobid = 45576;
-- increase black mith droprate from Priest of Chaos (lvl 55) (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40444 and mobid = 45576;

-- modify existing Subterranean Crabman drops
-- increase devil's blood droprate from Subterranean Crabman (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40031 and mobid = 45297;
-- increase hqd droprate from Subterranean Crabman (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40048 and mobid = 45297;
-- increase hqr droprate from Subterranean Crabman (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40049 and mobid = 45297;
-- increase hqs droprate from Subterranean Crabman (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40050 and mobid = 45297;

-- add additional drops to Subterranean Crabman  
-- add hqe to Subterranean Crabman droplist 
insert into droplist values (45297, 40051, 1, 1, 15000);

-- modify existing Subterranean Great King Worm drops
-- increase blue pot droprate from Subterranean Great King Worm (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40015 and mobid = 45360;

-- modify existing Subterranean Lizardman drops
-- increase sapphire droprate from Subterranean Lizardman (10000 -> 65000)
update droplist set chance = 65000 where itemid = 40046 and mobid = 45374;
-- increase ntele droprate from Subterranean Lizardman (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40100 and mobid = 45374;
-- decrease abyss ring droprate from Subterranean Lizardman (10000 -> 7500)
update droplist set chance = 7500 where itemid = 20289 and mobid = 45374;

-- add additional drops to Subterranean Lizardman 
-- add hqs to Subterranean Lizardman droplist 
insert into droplist values (45374, 40054, 1, 1, 20000);

-- modify existing Subterranean Scormystic drops
-- increase nzel droprate from Subterranean Scormystic (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45382;
-- increase lvl3 blank droprate from Subterranean Scormystic (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40092 and mobid = 45382;

-- modify existing Subterranean Scorpaitan drops
-- increase nzel droprate from Subterranean Scorpaitan (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45383;
-- increase lvl3 blank droprate from Subterranean Scorpaitan (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40092 and mobid = 45383;

-- modify existing Subterranean Beholder drops
-- increase sc:elemental falldown droprate from Subterranean Beholder (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40241 and mobid = 45423;
-- increase sc: erase magic droprate from Subterranean Beholder (10000 -> 5000)
update droplist set chance = 6500 where itemid = 40242 and mobid = 45423;
-- increase sc:wind shackle droprate from Subterranean Beholder (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40264 and mobid = 45423;

-- add additional drops to Subterranean Beholder 
-- add czel to Subterranean Beholder droplist 
insert into droplist values (45423, 240074, 1, 1, 7500);
-- add cdai to Subterranean Beholder droplist 
insert into droplist values (45423, 240087, 1, 1, 2500);

-- modify existing Subterranean Great King Turtle drops
-- increase orange pot droprate from Subterranean Great King Turtle (50000 -> 150000)
update droplist set chance = 150000 where itemid = 40011 and mobid = 45422;
-- increase hqd droprate from Subterranean Great King Turtle (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40048 and mobid = 45422;
-- increase hqs droprate from Subterranean Great King Turtle (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40050 and mobid = 45422;
-- increase hqe droprate from Subterranean Great King Turtle (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40051 and mobid = 45422;
-- decrease tqd droprate from Subterranean Great King Turtle (5000 -> 2500)
update droplist set chance = 2500 where itemid = 40052 and mobid = 45422;
-- decrease sc:triple droprate from Subterranean Great King Turtle (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40240 and mobid = 45422;
-- decrease sc: erase magic droprate from Subterranean Great King Turtle (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40242 and mobid = 45422;
-- increase sc:water life droprate from Subterranean Great King Turtle (2000 -> 5000)
update droplist set chance = 5000 where itemid = 40253 and mobid = 45422;

-- redo adena drop from Subterranean Great King Turtle  
delete from droplist where itemid = 40308 and mobid = 45422;
insert into droplist values (45422, 40308, 1265, 4291, 1000000);

-- add additional drops to Subterranean Great King Turtle 
-- add gloves of ice spirit to Subterranean Great King Turtle droplist 
insert into droplist values (45422, 20172, 1, 1, 7500);

-- modify existing Subterranean Elekkadom drops
-- increase eva's scorn droprate from Subterranean Elekkadom (120 -> 150)
update droplist set chance = 150 where itemid = 36 and mobid = 45487;
-- decrease sc:elemental falldown droprate from Subterranean Elekkadom (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40241 and mobid = 45487;
-- decrease sc:erase magic droprate from Subterranean Elekkadom (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40242 and mobid = 45487;
-- increase sc:water life droprate from Subterranean Elekkadom (2000 -> 4000)
update droplist set chance = 4000 where itemid = 40253 and mobid = 45487;

-- redo adena drop from Subterranean Elekkadom 
delete from droplist where itemid = 40308 and mobid = 45487;
insert into droplist values (45487, 40308, 1619, 7131, 1000000);

-- add additional drops to Subterranean Elekkadom 
-- add relic of maphr to Subterranean Elekkadom droplist 
insert into droplist values (45487, 40304, 1, 1, 10500);

-- redo frag drop from Chaos
delete from droplist where itemid = 40678 and mobid = 45625;
insert into droplist values (45625, 40678, 20, 121, 1000000);

-- modify existing medusa drops
-- decrease sb:para droprate from medusa (25000 -> 20000)
update droplist set chance = 20000 where itemid = 40178 and mobid = 45380;
-- increase sb:i2h droprate from medusa (500 -> 350)
update droplist set chance = 350 where itemid = 40213 and mobid = 45380;
-- increase sb:g-res droprate from medusa (5000 -> 4000)
update droplist set chance = 4000 where itemid = 40220 and mobid = 45380;

-- remove cure pot from medusa droplist
delete from droplist where itemid = 40017 and mobid = 45380;

-- modify existing giants (all) drops
-- increase orange pot droprate from giants (all) (5000 -> 25000)
update droplist set chance = 25000 where itemid = 40011 and mobid in (45295, 45337, 45351);
-- increase brave pot droprate from giants (all) (5000 -> 20000)
update droplist set chance = 20000 where itemid = 40014 and mobid in (45295, 45337, 45351);
-- increase beserker axe droprate from giants (all) (1000 -> 5000)
update droplist set chance = 5000 where itemid = 145 and mobid in (45295, 45337, 45351);
-- decrease battle axe droprate from giants (all) (25000 -> 20000)
update droplist set chance = 20000 where itemid = 143 and mobid in (45295, 45337, 45351);
-- increase sks droprate from giants (all) (500 -> 750)
update droplist set chance = 750 where itemid = 20238 and mobid in (45295, 45337, 45351);

-- modify existing Blue Tail drops
-- increase sapphire droprate from Blue Tail (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40046 and mobid = 45239;
-- fix skin of blue lizard droprate from Blue Tail (10000000 -> 1000000)
update droplist set chance = 1000000 where itemid = 40714 and mobid = 45239;

-- modify existing Wild Venom drops
-- increase ruby droprate from Wild Venom (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40045 and mobid = 45139;

-- modify existing Wild Fang drops
-- increase brave pot droprate from Wild Fang (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40014 and mobid = 45163;
-- increase emerald droprate from Wild Fang (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40047 and mobid = 45163;

-- modify existing Wild Magic drops
-- increase blue pot droprate from Wild Magic (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40015 and mobid = 45197;
-- increase diamond droprate from Wild Magic (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40044 and mobid = 45197;

-- modify existing Kiwi Parrot drops
-- increase Emerald droprate from Kiwi Parrot (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40047 and mobid = 45249;

-- modify existing Mad Lizardman drops
-- decrease cursed diamond ring droprate from Mad Lizardman (10000 -> 8000)
update droplist set chance = 8000 where itemid = 20293 and mobid = 45158;
-- decrease cursed emerald ring droprate from Mad Lizardman (10000 -> 5000)
update droplist set chance = 5000 where itemid = 20296 and mobid = 45158;
-- increase orange pot droprate from Mad Lizardman (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40011 and mobid = 45158;
-- increase emerald droprate from Mad Lizardman (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40047 and mobid = 45158;
-- increase frag droprate from Mad Lizardman (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40471 and mobid = 45158;

-- modify existing High Lizardman drops
-- decrease cursed diamond ring droprate from High Lizardman (10000 -> 8000)
update droplist set chance = 8000 where itemid = 20293 and mobid = 45217;
-- decrease cursed sapphire ring droprate from High Lizardman (10000 -> 5000)
update droplist set chance = 5000 where itemid = 20295 and mobid = 45217;
-- increase orange pot droprate from High Lizardman (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40011 and mobid = 45217;
-- increase sapphire droprate from High Lizardman (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40046 and mobid = 45217;
-- increase frag droprate from High Lizardman (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40661 and mobid = 45217;

-- modify existing Heavy Lizardman drops
-- decrease cursed diamond ring droprate from Heavy Lizardman (10000 -> 8000)
update droplist set chance = 8000 where itemid = 20293 and mobid = 45251;
-- decrease cursed ruby ring droprate from Heavy Lizardman (10000 -> 7500)
update droplist set chance = 7500 where itemid = 20294 and mobid = 45251;
-- decrease cursed sapphire ring droprate from Heavy Lizardman (10000 -> 4500)
update droplist set chance = 4500 where itemid = 20295 and mobid = 45251;
-- increase orange pot droprate from Heavy Lizardman (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45251;
-- increase diamond droprate from Heavy Lizardman (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40044 and mobid = 45251;
-- increase frag droprate from Heavy Lizardman (10000 -> 17500)
update droplist set chance = 17500 where itemid = 40471 and mobid = 45251;

-- modify existing Skeletal Pirate drops
-- decrease cursed diamond ring droprate from Skeletal Pirate (10000 -> 8000)
update droplist set chance = 8000 where itemid = 20293 and mobid = 45247;
-- decrease cursed emerald ring droprate from Skeletal Pirate (10000 -> 7500)
update droplist set chance = 7500 where itemid = 20296 and mobid = 45247;
-- increase g-haste pot droprate from Skeletal Pirate (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40018 and mobid = 45247;
-- increase emerald droprate from Skeletal Pirate (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40047 and mobid = 45247;
-- increase hqe droprate from Skeletal Pirate (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40051 and mobid = 45247;
-- increase frag droprate from Skeletal Pirate (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40471 and mobid = 45247;

-- modify existing Skeletal Pirate Soldier drops
-- increase cursed diamond ring droprate from Skeletal Pirate Soldier (10000 -> 8000)
update droplist set chance = 8000 where itemid = 20293 and mobid = 45274;
-- increase cursed emerald ring droprate from Skeletal Pirate Soldier (10000 -> 7500)
update droplist set chance = 7500 where itemid = 20296 and mobid = 45274;
-- increase g-haste pot droprate from Skeletal Pirate Soldier (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40018 and mobid = 45274;
-- increase sapphire droprate from Skeletal Pirate Soldier (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40046 and mobid = 45274;
-- increase hqs droprate from Skeletal Pirate Soldier (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40050 and mobid = 45274;
-- increase frag droprate from Skeletal Pirate Soldier (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40471 and mobid = 45274;
-- increase silver arrow droprate from Skeletal Pirate Soldier (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40744 and mobid = 45274;

-- add additional drops to Skeletal Pirate Soldier 
-- add ntele to Skeletal Pirate Soldier droplist 
insert into droplist values (45274, 40100, 1, 1, 75000);

-- modify existing Skeletal Pirate Head drops
-- increase cursed diamond ring droprate from Skeletal Pirate Head (10000 -> 8000)
update droplist set chance = 8000 where itemid = 20293 and mobid = 45330;
-- increase cursed ruby ring droprate from Skeletal Pirate Head (10000 -> 7500)
update droplist set chance = 7500 where itemid = 20294 and mobid = 45330;
-- increase g-haste pot droprate from Skeletal Pirate Head (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40018 and mobid = 45330;
-- increase diamond droprate from Skeletal Pirate Head (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40044 and mobid = 45330;
-- increase hqd droprate from Skeletal Pirate Head (5000 -> 20000)
update droplist set chance = 20000 where itemid = 40048 and mobid = 45330;
-- increase frag droprate from Skeletal Pirate Head (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40471 and mobid = 45330;
-- increase silver arrow droprate from Skeletal Pirate Head (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40744 and mobid = 45330;

-- add additional drops to Skeletal Pirate Head 
-- add hom:s to Skeletal Pirate Head droplist 
insert into droplist values (45330, 20013, 1, 1, 5000);

-- modify existing Giran Ghast drops
-- increase blue pot droprate from Giran Ghast (25000 -> 35000)
update droplist set chance = 35000 where itemid = 40015 and mobid = 45142;
-- increase emerald droprate from Giran Ghast (25000 -> 35000)
update droplist set chance = 35000 where itemid = 40047 and mobid = 45142;
-- increase hqe droprate from Giran Ghast (5000 -> 10000)
update droplist set chance = 10000 where itemid = 40051 and mobid = 45142;
-- increase battle axe droprate from Giran Ghast (2500 -> 7500)
update droplist set chance = 7500 where itemid = 143 and mobid = 45142;

-- modify existing Giran Ghast Lord drops
-- increase blue pot droprate from Giran Ghast Lord (10000 -> 35000)
update droplist set chance = 35000 where itemid = 40015 and mobid = 45188;
-- increase hqe droprate from Giran Ghast Lord (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40051 and mobid = 45188;
-- decrease sb:disease droprate from Giran Ghast Lord (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40201 and mobid = 45188;
-- increase btele droprate from Giran Ghast Lord (50000 -> 150000)
update droplist set chance = 150000 where itemid = 140100 and mobid = 45188;
-- increase berserker axe droprate from Giran Ghast Lord (1000 -> 5000)
update droplist set chance = 5000 where itemid = 145 and mobid = 45188;

-- modify existing Giran Lizardman drops
-- increase sapphire droprate from Giran Lizardman (10000 -> 35000)
update droplist set chance = 35000 where itemid = 40046 and mobid = 45156;
-- increase btele droprate from Giran Lizardman (10000 -> 15000)
update droplist set chance = 15000 where itemid = 140100 and mobid = 45156;

-- modify existing Giran Arachnevil Elder drops
-- decrease sb:fog of sleeping droprate from Giran Arachnevil Elder (10000 -> 2000)
update droplist set chance = 2000 where itemid = 40211 and mobid = 45312;
-- decrease sb:i2h droprate from Giran Arachnevil Elder (250 -> 50)
update droplist set chance = 50 where itemid = 40213 and mobid = 45312;
-- increase btele droprate from Giran Arachnevil Elder (50000 -> 150000)
update droplist set chance = 150000 where itemid = 140100 and mobid = 45312;

-- add additional drops to Giran Tiger 
-- add clear pot to Giran Tiger droplist 
insert into droplist values (45243, 40012, 1, 1, 20000);
-- add haste pot to Giran Tiger droplist 
insert into droplist values (45243, 40013, 1, 1, 50000);
-- add Meat to Giran Tiger droplist 
insert into droplist values (45243, 40056, 1, 1, 25000);
-- add g-haste pot to Giran Tiger droplist 
insert into droplist values (45243, 40018, 1, 1, 50000);

-- modify existing Giran Cerberus drops
-- increase ruby droprate from Giran Cerberus (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40045 and mobid = 45283;

-- add additional drops to Giran Cerberus 
-- add btele to Giran Cerberus droplist 
insert into droplist values (45283, 140100, 1, 1, 50000);

-- modify existing Giran Dire Wolf drops
-- decrease 5mr ring droprate from Giran Dire Wolf (8000 -> 2500)
update droplist set chance = 2500 where itemid = 20303 and mobid = 45282;

-- add additional drops to Giran Dire Wolf 
-- add meat to Giran Dire Wolf droplist 
insert into droplist values (45282, 40015, 1, 1, 50000);
-- add wis pot to Giran Dire Wolf droplist 
insert into droplist values (45282, 40016, 1, 1, 50000);
-- add haste pot to Giran Dire Wolf droplist 
insert into droplist values (45282, 40013, 1, 1, 40000);
-- add g-haste pot to Giran Dire Wolf droplist 
insert into droplist values (45282, 40018, 1, 1, 20000);
-- add clear pot to Giran Dire Wolf droplist 
insert into droplist values (45282, 40012, 1, 1, 15000);
-- add btele to Giran Dire Wolf droplist 
insert into droplist values (45282, 140100, 1, 1, 50000);

-- modify existing Giran Cimaera drops
-- increase red pot droprate from Giran Cimaera (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40010 and mobid = 45325;
-- decrease clear pot droprate from Giran Cimaera (50000 -> 20000)
update droplist set chance = 20000 where itemid = 40012 and mobid = 45325;
-- increase c-red droprate from Giran Cimaera (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40019 and mobid = 45325;
-- decrease c-clear droprate from Giran Cimaera (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40021 and mobid = 45325;
-- decrease lvl1 blank droprate from Giran Cimaera (50000 -> 40000)
update droplist set chance = 40000 where itemid = 40090 and mobid = 45325;
-- decrease lvl2 blank droprate from Giran Cimaera (50000 -> 30000)
update droplist set chance = 30000 where itemid = 40091 and mobid = 45325;
-- decrease lvl3 blank droprate from Giran Cimaera (50000 -> 20000)
update droplist set chance = 20000 where itemid = 40092 and mobid = 45325;

-- modify existing Giran Lava Golem drops
-- decrease sb:fs droprate from Giran Lava Golem (10000 -> 1500)
update droplist set chance = 1500 where itemid = 40215 and mobid = 45376;
-- decrease sc:ebind droprate from Giran Lava Golem (1000 -> 500)
update droplist set chance = 500 where itemid = 40249 and mobid = 45376;
-- decrease sc:exotic vitalize droprate from Giran Lava Golem (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40252 and mobid = 45376;
-- decrease sc:burning weapon droprate from Giran Lava Golem (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40258 and mobid = 45376;

-- modify existing Cerenis drops
-- increase sb:adv droprate from Cerenis (5000 -> 7000)
update droplist set chance = 1500 where itemid = 40215 and mobid = 45376;
-- increase silver cloak droprate from Cerenis (5000 -> 7000)
update droplist set chance = 1500 where itemid = 20074 and mobid = 45376;

-- add additional drops to Aaarrrggg... 
-- add tsu to Aaarrrggg... droplist 
insert into droplist values (45671, 57, 1, 1, 5000);
-- add b-banana to Aaarrrggg... droplist 
insert into droplist values (45671, 140062, 1, 1, 500);

-- modify existing FI Alligator drops
-- increase orange pot droprate from FI Alligator (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45196;
-- decrease clear pot droprate from FI Alligator (50000 -> 35000)
update droplist set chance = 35000 where itemid = 40012 and mobid = 45196;
-- decrease c-clear droprate from FI Alligator (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40021 and mobid = 45196;
-- increase c-red droprate from FI Alligator (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40019 and mobid = 45196;
-- increase brave pot droprate from FI Alligator (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40014 and mobid = 45196;
-- decrease lvl2 blank droprate from FI Alligator (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45196;
-- decrease lvl3 blank droprate from FI Alligator (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45196;
-- decrease lvl4 blank droprate from FI Alligator (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40093 and mobid = 45196;
-- decrease lvl5 blank droprate from FI Alligator (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45196;

-- modify existing FI Werewolf drops
-- decrease clear pot droprate from FI Werewolf (50000 -> 35000)
update droplist set chance = 35000 where itemid = 40012 and mobid = 45355;
-- decrease c-clear droprate from FI Werewolf (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40021 and mobid = 45355;
-- increase c-red droprate from FI Werewolf (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40019 and mobid = 45355;
-- increase brave pot droprate from FI Werewolf (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40014 and mobid = 45355;
-- decrease lvl2 blank droprate from FI Werewolf (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45355;
-- decrease lvl3 blank droprate from FI Werewolf (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45355;
-- decrease lvl4 blank droprate from FI Werewolf (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40093 and mobid = 45355;
-- decrease lvl5 blank droprate from FI Werewolf (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45355;
-- decrease fsm droprate from FI Werewolf (5000 -> 1500)
update droplist set chance = 1500 where itemid = 20142 and mobid = 45355;

-- modify existing FI Arachnevil drops
-- decrease clear pot droprate from FI Arachnevil (50000 -> 35000)
update droplist set chance = 35000 where itemid = 40012 and mobid = 45358;
-- decrease c-clear droprate from FI Arachnevil (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40021 and mobid = 45358;
-- increase c-red droprate from FI Arachnevil (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40019 and mobid = 45358;
-- increase wafer droprate from FI Arachnevil (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40068 and mobid = 45358;
-- decrease sb:fog of sleeping droprate from FI Arachnevil (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40211 and mobid = 45358;
-- decrease lvl2 blank droprate from FI Arachnevil (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45358;
-- decrease lvl3 blank droprate from FI Arachnevil (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45358;
-- decrease lvl4 blank droprate from FI Arachnevil (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40093 and mobid = 45358;
-- decrease lvl5 blank droprate from FI Arachnevil (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45358;
-- decrease fsm droprate from FI Arachnevil (5000 -> 1000)
update droplist set chance = 1000 where itemid = 20142 and mobid = 45358;

-- modify existing FI Cockatrice drops
-- decrease fpm droprate from FI Cockatrice (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20143 and mobid = 45362;
-- increase orange pot droprate from FI Cockatrice (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45362;
-- increase brave pot droprate from FI Cockatrice (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40014 and mobid = 45362;
-- increase blue pot droprate from FI Cockatrice (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40015 and mobid = 45362;
-- increase wis pot droprate from FI Cockatrice (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40016 and mobid = 45362;
-- increase g-haste pot droprate from FI Cockatrice (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45362;
-- increase c-red droprate from FI Cockatrice (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40019 and mobid = 45362;
-- increase c-orange droprate from FI Cockatrice (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40020 and mobid = 45362;
-- increase wafer droprate from FI Cockatrice (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40068 and mobid = 45362;
-- decrease lvl3 blank droprate from FI Cockatrice (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40092 and mobid = 45362;
-- decrease lvl4 blank droprate from FI Cockatrice (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45362;
-- decrease lvl5 blank droprate from FI Cockatrice (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40094 and mobid = 45362;
-- increase id scroll droprate from FI Cockatrice (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40126 and mobid = 45362;
-- increase whetstone droprate from FI Cockatrice (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40317 and mobid = 45362;
-- decrease f-sword droprate from FI Cockatrice (10000 -> 2500)
update droplist set chance = 2500 where itemid = 18 and mobid = 45362;

-- modify existing FI Dark Elf drops
-- decrease Old Helm of Wind droprate from FI Dark Elf (7000 -> 3500)
update droplist set chance = 3500 where itemid = 20008 and mobid = 45364;
-- decrease fla droprate from FI Dark Elf (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20140 and mobid = 45364;
-- decrease 10MR droprate from FI Dark Elf (500 -> 400)
update droplist set chance = 400 where itemid = 20280 and mobid = 45364;
-- decrease 5MR droprate from FI Dark Elf (8000 -> 5000)
update droplist set chance = 5000 where itemid = 20303 and mobid = 45364;
-- increase orange pot droprate from FI Dark Elf (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45364;
-- decrease brave pot droprate from FI Dark Elf (10000 -> 8500)
update droplist set chance = 8500 where itemid = 40014 and mobid = 45364;
-- increase wis pot droprate from FI Dark Elf (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40016 and mobid = 45364;
-- increase g-haste pot droprate from FI Dark Elf (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45364;
-- increase c-red droprate from FI Dark Elf (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40019 and mobid = 45364;
-- increase c-orange droprate from FI Dark Elf (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40020 and mobid = 45364;
-- increase wafer droprate from FI Dark Elf (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40068 and mobid = 45364;
-- decrease lvl2 blank droprate from FI Dark Elf (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45364;
-- decrease lvl3 blank droprate from FI Dark Elf (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45364;
-- decrease lvl4 blank droprate from FI Dark Elf (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45364;
-- decrease lvl5 blank droprate from FI Dark Elf (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45364;

-- add additional drops to FI Dark Elf 
-- add ebony to FI Dark Elf droplist 
insert into droplist values (45364, 40007, 1, 1, 25000);

-- modify existing FI Owlbear drops
-- decrease fla droprate from FI Owlbear (5000 -> 2000)
update droplist set chance = 2000 where itemid = 20140 and mobid = 45371;
-- increase orange pot droprate from FI Owlbear (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45371;
-- increase brave pot droprate from FI Owlbear (10000 -> 75000)
update droplist set chance = 75000 where itemid = 40014 and mobid = 45371;
-- increase c-red droprate from FI Owlbear (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40019 and mobid = 45371;
-- increase c-orange droprate from FI Owlbear (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40020 and mobid = 45371;
-- increase wafer droprate from FI Owlbear (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40068 and mobid = 45371;
-- decrease lvl2 blank droprate from FI Owlbear (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45371;
-- decrease lvl3 blank droprate from FI Owlbear (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45371;
-- decrease lvl4 blank droprate from FI Owlbear (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40093 and mobid = 45371;
-- decrease lvl5 blank droprate from FI Owlbear (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45371;

-- modify existing FI Lizardman drops
-- decrease f-robe droprate from FI Lizardman (5000 -> 2500)
update droplist set chance = 2500 where itemid = 20141 and mobid = 45377;
-- increase orange pot droprate from FI Lizardman (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40011 and mobid = 45377;
-- increase g-haste pot droprate from FI Lizardman (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45377;
-- increase c-red droprate from FI Lizardman (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45377;
-- increase c-oj droprate from FI Lizardman (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40020 and mobid = 45377;
-- decrease lvl2 blank droprate from FI Lizardman (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45377;
-- decrease lvl3 blank droprate from FI Lizardman (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45377;
-- decrease lvl4 blank droprate from FI Lizardman (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40093 and mobid = 45377;
-- decrease lvl5 blank droprate from FI Lizardman (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45377;

-- modify existing FI Ghast drops
-- decrease fla droprate from FI Ghast (5000 -> 2000)
update droplist set chance = 2000 where itemid = 20140 and mobid = 45378;
-- increase ebony droprate from FI Ghast (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40007 and mobid = 45378;
-- increase orange pot droprate from FI Ghast (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40011 and mobid = 45378;
-- increase cure pot droprate from FI Ghast (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40017 and mobid = 45378;
-- increase c-red droprate from FI Ghast (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40019 and mobid = 45378;
-- increase c-oj droprate from FI Ghast (10000 -> 17500)
update droplist set chance = 17500 where itemid = 40020 and mobid = 45378;
-- decrease lvl2 blank droprate from FI Ghast (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40091 and mobid = 45378;
-- decrease lvl3 blank droprate from FI Ghast (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45378;
-- decrease lvl4 blank droprate from FI Ghast (10000 -> 3000)
update droplist set chance = 3000 where itemid = 40093 and mobid = 45378;
-- decrease lvl5 blank droprate from FI Ghast (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45378;
-- increase nprat droprate from FI Ghast (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40119 and mobid = 45378;
-- increase res scroll droprate from FI Ghast (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40089 and mobid = 45378;

-- add additional drops to FI Ghast 
-- add 5MR ring to FI Ghast droplist 
insert into droplist values (45378, 20303, 1, 1, 1500);

-- modify existing FI Ramia drops
-- decrease f-robe droprate from FI Ramia (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20141 and mobid = 45387;
-- decrease fsm droprate from FI Ramia (5000 -> 1500)
update droplist set chance = 1500 where itemid = 20142 and mobid = 45387;
-- increase underwater boots droprate from FI Ramia (1000 -> 1200)
update droplist set chance = 1200 where itemid = 20207 and mobid = 45387;
-- increase orange pot droprate from FI Ramia (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45387;
-- increase blue pot droprate from FI Ramia (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40015 and mobid = 45387;
-- increase wis pot droprate from FI Ramia (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40016 and mobid = 45387;
-- increase cure pot droprate from FI Ramia (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40017 and mobid = 45387;
-- increase c-red droprate from FI Ramia (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40019 and mobid = 45387;
-- increase c-oj droprate from FI Ramia (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40020 and mobid = 45387;
-- decrease lvl3 blank droprate from FI Ramia (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45387;
-- decrease lvl4 blank droprate from FI Ramia (10000 -> 4000)
update droplist set chance = 4000 where itemid = 40093 and mobid = 45387;
-- decrease lvl5 blank droprate from FI Ramia (10000 -> 2000)
update droplist set chance = 2000 where itemid = 40094 and mobid = 45387;
-- increase nprat droprate from FI Ramia (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40119 and mobid = 45387;
-- increase id scroll droprate from FI Ramia (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40126 and mobid = 45387;

-- modify existing FI Lycanthrope drops
-- decrease Old Helm of Wind droprate from FI Lycanthrope (7000 -> 3000)
update droplist set chance = 3000 where itemid = 20008 and mobid = 45389;
-- decrease fla droprate from FI Lycanthrope (5000 -> 2500)
update droplist set chance = 2500 where itemid = 20140 and mobid = 45389;
-- decrease 5MR ring droprate from FI Lycanthrope (8000 -> 4000)
update droplist set chance = 4000 where itemid = 20303 and mobid = 45389;
-- increase orange pot droprate from FI Lycanthrope (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45389;
-- increase brave pot droprate from FI Lycanthrope (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40014 and mobid = 45389;
-- increase c-red droprate from FI Lycanthrope (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40019 and mobid = 45389;
-- increase c-oj droprate from FI Lycanthrope (10000 -> 17500)
update droplist set chance = 17500 where itemid = 40020 and mobid = 45389;
-- decrease lvl3 blank droprate from FI Lycanthrope (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45389;
-- decrease lvl4 blank droprate from FI Lycanthrope (10000 -> 4000)
update droplist set chance = 4000 where itemid = 40093 and mobid = 45389;
-- decrease lvl5 blank droprate from FI Lycanthrope (10000 -> 2000)
update droplist set chance = 2000 where itemid = 40094 and mobid = 45389;

-- modify existing FI Minotaur (axe) drops
-- decrease fsm droprate from FI Minotaur (axe) (5000 -> 2500)
update droplist set chance = 2500 where itemid = 20142 and mobid = 45390;
-- decrease 5MR ring droprate from FI Minotaur (axe) (8000 -> 4500)
update droplist set chance = 4500 where itemid = 20303 and mobid = 45390;
-- increase orange pot droprate from FI Minotaur (axe) (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40011 and mobid = 45390;
-- increase brave pot droprate from FI Minotaur (axe) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40014 and mobid = 45390;
-- increase c-red droprate from FI Minotaur (axe) (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45390;
-- increase c-oj droprate from FI Minotaur (axe) (10000 -> 35000)
update droplist set chance = 35000 where itemid = 40020 and mobid = 45390;
-- increase c-clear droprate from FI Minotaur (axe) (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40021 and mobid = 45390;
-- increase wafer droprate from FI Minotaur (axe) (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40068 and mobid = 45390;
-- decrease lvl4 blank droprate from FI Minotaur (axe) (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40093 and mobid = 45390;
-- decrease lvl5 blank droprate from FI Minotaur (axe) (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40094 and mobid = 45390;
-- increase nprat droprate from FI Minotaur (axe) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40119 and mobid = 45390;
-- increase id scroll droprate from FI Minotaur (axe) (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40126 and mobid = 45390;

-- add additional drops to FI Minotaur (axe) 
-- add whetstone to FI Minotaur (axe) droplist 
insert into droplist values (45390, 40317, 1, 1, 20000);

-- modify existing FI Bugbear drops
-- decrease f-robe droprate from FI Bugbear (5000 -> 2000)
update droplist set chance = 2000 where itemid = 20141 and mobid = 45392;
-- increase orange pot droprate from FI Bugbear (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45392;
-- increase c-red droprate from FI Bugbear (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40019 and mobid = 45392;
-- increase c-oj droprate from FI Bugbear (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40020 and mobid = 45392;
-- decrease lvl3 blank droprate from FI Bugbear (10000 -> 6000)
update droplist set chance = 6000 where itemid = 40092 and mobid = 45392;
-- decrease lvl4 blank droprate from FI Bugbear (10000 -> 4000)
update droplist set chance = 4000 where itemid = 40093 and mobid = 45392;
-- decrease lvl5 blank droprate from FI Bugbear (10000 -> 2000)
update droplist set chance = 2000 where itemid = 40094 and mobid = 45392;
-- increase id scroll droprate from FI Bugbear (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40126 and mobid = 45392;
-- increase whetstone droprate from FI Bugbear (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40317 and mobid = 45392;

-- add additional drops to FI Bugbear 
-- add 10MR ring to FI Bugbear droplist 
insert into droplist values (45392, 20280, 1, 1, 100);

-- modify existing FI Arachnevil Elder drops
-- decrease fla droprate from FI Arachnevil Elder (5000 -> 2000)
update droplist set chance = 2000 where itemid = 20140 and mobid = 45401;
-- decrease 5MR ring droprate from FI Arachnevil Elder (8000 -> 2500)
update droplist set chance = 2500 where itemid = 20303 and mobid = 45401;
-- increase orange pot droprate from FI Arachnevil Elder (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45401;
-- increase cure pot droprate from FI Arachnevil Elder (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40017 and mobid = 45401;
-- increase c-red droprate from FI Arachnevil Elder (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40019 and mobid = 45401;
-- increase c-oj droprate from FI Arachnevil Elder (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40020 and mobid = 45401;
-- decrease lvl3 blank droprate from FI Arachnevil Elder (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40092 and mobid = 45401;
-- increase lvl4 blank droprate from FI Arachnevil Elder (10000 -> 2000)
update droplist set chance = 2000 where itemid = 40093 and mobid = 45401;
-- increase lvl5 blank droprate from FI Arachnevil Elder (10000 -> 1000)
update droplist set chance = 1000 where itemid = 40094 and mobid = 45401;
-- increase nprat droprate from FI Arachnevil Elder (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40119 and mobid = 45401;

-- modify existing FI Griffon drops
-- decrease helm of wind droprate from FI Griffon (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20023 and mobid = 45445;
-- decrease f-robe droprate from FI Griffon (5000 -> 3000)
update droplist set chance = 3000 where itemid = 20141 and mobid = 45445;
-- decrease 10MR ring droprate from FI Griffon (1000 -> 900)
update droplist set chance = 900 where itemid = 20280 and mobid = 45445;
-- increase orange pot droprate from FI Griffon (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45445;
-- increase wis pot droprate from FI Griffon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40016 and mobid = 45445;
-- increase c-red droprate from FI Griffon (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40019 and mobid = 45445;
-- increase c-oj droprate from FI Griffon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40020 and mobid = 45445;
-- decrease lvl4 blank droprate from FI Griffon (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40093 and mobid = 45445;
-- decrease lvl5 blank droprate from FI Griffon (10000 -> 4000)
update droplist set chance = 4000 where itemid = 40094 and mobid = 45445;
-- increase id scroll droprate from FI Griffon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40126 and mobid = 45445;
-- increase f-bowgun droprate from FI Griffon (5000 -> 2000)
update droplist set chance = 2000 where itemid = 167 and mobid = 45445;

-- add additional drops to FI Griffon 
-- add 5MR ring to FI Griffon droplist 
insert into droplist values (45445, 20303, 1, 1, 2000);

-- modify existing FI Minotaur (mace) drops
-- decrease fpm droprate from FI Minotaur (mace) (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20143 and mobid = 45449;
-- decrease 5MR ring droprate from FI Minotaur (mace) (8000 -> 5000)
update droplist set chance = 5000 where itemid = 20303 and mobid = 45449;
-- increase orange pot droprate from FI Minotaur (mace) (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45449;
-- increase brave pot droprate from FI Minotaur (mace) (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40014 and mobid = 45449;
-- increase blue pot droprate from FI Minotaur (mace) (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40015 and mobid = 45449;
-- increase wis pot droprate from FI Minotaur (mace) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40016 and mobid = 45449;
-- increase g-haste pot droprate from FI Minotaur (mace) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45449;
-- increase c-red droprate from FI Minotaur (mace) (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45449;
-- increase c-oj droprate from FI Minotaur (mace) (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40020 and mobid = 45449;
-- increase wafer droprate from FI Minotaur (mace) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40068 and mobid = 45449;
-- increase res scroll droprate from FI Minotaur (mace) (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40089 and mobid = 45449;
-- decrease lvl4 blank droprate from FI Minotaur (mace) (10000 -> 8000)
update droplist set chance = 8000 where itemid = 40093 and mobid = 45449;
-- decrease lvl5 blank droprate from FI Minotaur (mace) (1000 -> 4000)
update droplist set chance = 4000 where itemid = 40094 and mobid = 45449;
-- increase nprat droprate from FI Minotaur (mace) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40119 and mobid = 45449;
-- increase id scroll droprate from FI Minotaur (mace) (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40126 and mobid = 45449;

-- add additional drops to FI Minotaur (mace) 
-- add whetstone to FI Minotaur (mace) droplist 
insert into droplist values (45449, 40317, 1, 1, 25000);

-- modify existing FI Harpy drops
-- decrease underwater boots droprate from FI Harpy (1000 -> 800)
update droplist set chance = 800 where itemid = 20207 and mobid = 45452;
-- increase ebony droprate from FI Harpy (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40007 and mobid = 45452;
-- increase orange pot droprate from FI Harpy (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45452;
-- increase blue pot droprate from FI Harpy (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40015 and mobid = 45452;
-- increase wis pot droprate from FI Harpy (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40016 and mobid = 45452;
-- increase c-red droprate from FI Harpy (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40019 and mobid = 45452;
-- increase c-oj droprate from FI Harpy (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40020 and mobid = 45452;
-- increase wafer droprate from FI Harpy (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40068 and mobid = 45452;
-- decrease lvl4 blank droprate from FI Harpy (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45452;
-- decrease lvl5 blank droprate from FI Harpy (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40094 and mobid = 45452;
-- increase nprat droprate from FI Harpy (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40119 and mobid = 45452;

-- add additional drops to FI Harpy 
-- add 5MR ring to FI Harpy droplist 
insert into droplist values (45452, 20303, 1, 1, 2500);
-- add 10MR ring to FI Harpy droplist 
insert into droplist values (45452, 20280, 1, 1, 200);
-- add fsm to FI Harpy droplist 
insert into droplist values (45452, 20142, 1, 1, 2000);
-- add a-scroll to FI Harpy droplist 
insert into droplist values (45452, 40076, 1, 1, 250);
-- add old helm of wind to FI Harpy droplist 
insert into droplist values (45452, 20008, 1, 1, 1500);

-- modify existing FI Doppelganger drops
-- increase orange pot droprate from FI Doppelganger (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45457;
-- increase blue pot droprate from FI Doppelganger (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40015 and mobid = 45457;
-- increase c-red droprate from FI Doppelganger (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45457;
-- increase c-oj droprate from FI Doppelganger (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40020 and mobid = 45457;
-- increase c-clear droprate from FI Doppelganger (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40021 and mobid = 45457;
-- decrease lvl5 blank droprate from FI Doppelganger (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45457;
-- increase nprat droprate from FI Doppelganger (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40119 and mobid = 45457;

-- modify existing FI Crocodile drops
-- decrease fpm droprate from FI Crocodile (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20143 and mobid = 45469;
-- decrease 5MR ring droprate from FI Crocodile (8000 -> 5000)
update droplist set chance = 5000 where itemid = 20303 and mobid = 45469;
-- increase orange pot droprate from FI Crocodile (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40011 and mobid = 45469;
-- increase clear pot droprate from FI Crocodile (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40012 and mobid = 45469;
-- increase brave pot droprate from FI Crocodile (10000 -> 35000)
update droplist set chance = 35000 where itemid = 40014 and mobid = 45469;
-- increase c-red droprate from FI Crocodile (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45469;
-- increase c-oj droprate from FI Crocodile (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40020 and mobid = 45469;
-- increase c-clear droprate from FI Crocodile (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40021 and mobid = 45469;
-- increase wafer droprate from FI Crocodile (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40068 and mobid = 45469;
-- increase whetstone droprate from FI Crocodile (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40317 and mobid = 45469;

-- modify existing FI Ghast Lord drops
-- decrease fla droprate from FI Ghast Lord (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20140 and mobid = 45470;
-- decrease 5MR ring droprate from FI Ghast Lord (8000 -> 5000)
update droplist set chance = 5000 where itemid = 20303 and mobid = 45470;
-- increase c-red droprate from FI Ghast Lord (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45470;
-- increase c-oj droprate from FI Ghast Lord (10000 -> 35000)
update droplist set chance = 35000 where itemid = 40020 and mobid = 45470;
-- increase c-clear droprate from FI Ghast Lord (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40021 and mobid = 45470;
-- increase wafer droprate from FI Ghast Lord (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40068 and mobid = 45470;
-- decrease lvl4 blank droprate from FI Ghast Lord (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40093 and mobid = 45470;
-- increase lvl5 blank droprate from FI Ghast Lord (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40094 and mobid = 45470;
-- increase nprat droprate from FI Ghast Lord (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40119 and mobid = 45470;

-- modify existing FI Troll drops
-- decrease fsm droprate from FI Troll (5000 -> 3000)
update droplist set chance = 3000 where itemid = 20142 and mobid = 45477;
-- decrease troll belt droprate from FI Troll (10000 -> 6500)
update droplist set chance = 6500 where itemid = 20321 and mobid = 45477;
-- increase orange pot droprate from FI Troll (50000 -> 100000)
update droplist set chance = 100000 where itemid = 40011 and mobid = 45477;
-- increase clear pot droprate from FI Troll (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40012 and mobid = 45477;
-- increase brave pot droprate from FI Troll (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40014 and mobid = 45477;
-- increase c-red droprate from FI Troll (10000 -> 75000)
update droplist set chance = 75000 where itemid = 40019 and mobid = 45477;
-- increase c-oj droprate from FI Troll (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40020 and mobid = 45477;
-- increase c-clear droprate from FI Troll (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40021 and mobid = 45477;
-- decrease lvl3 blank droprate from FI Troll (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40092 and mobid = 45477;
-- decrease lvl4 blank droprate from FI Troll (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45477;
-- decrease lvl5 blank droprate from FI Troll (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40094 and mobid = 45477;

-- add additional drops to FI Troll 
-- add fpm to FI Troll droplist 
insert into droplist values (45477, 20143, 1, 1, 1500);

-- modify existing FI Ettin drops
-- decrease fpm droprate from FI Ettin (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20143 and mobid = 45505;
-- increase 10MR ring droprate from FI Ettin (1000 -> 800)
update droplist set chance = 800 where itemid = 20280 and mobid = 45505;
-- increase orange pot droprate from FI Ettin (50000 -> 85000)
update droplist set chance = 85000 where itemid = 40011 and mobid = 45505;
-- increase clear pot droprate from FI Ettin (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40012 and mobid = 45505;
-- increase brave pot droprate from FI Ettin (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40014 and mobid = 45505;
-- increase g-haste pot droprate from FI Ettin (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40018 and mobid = 45505;
-- increase c-red droprate from FI Ettin (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40019 and mobid = 45505;
-- increase c-oj droprate from FI Ettin (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40020 and mobid = 45505;
-- increase c-clear droprate from FI Ettin (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40021 and mobid = 45505;
-- decrease lvl3 blank droprate from FI Ettin (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40092 and mobid = 45505;
-- decrease lvl4 blank droprate from FI Ettin (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45505;
-- decrease lvl5 blank droprate from FI Ettin (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40094 and mobid = 45505;
-- increase whetstone droprate from FI Ettin (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40317 and mobid = 45505;

-- add additional drops to FI Ettin 
-- add f-sword to FI Ettin droplist 
insert into droplist values (45505, 18, 1, 1, 1000);

-- modify existing FI King Bugbear drops
-- increase fpm droprate from FI King Bugbear (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20143 and mobid = 45509;
-- increase 5MR ring droprate from FI King Bugbear (8000 -> 5000)
update droplist set chance = 5000 where itemid = 20303 and mobid = 45509;
-- increase orange pot droprate from FI King Bugbear (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45509;
-- increase clear pot droprate from FI King Bugbear (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40012 and mobid = 45509;
-- increase c-red droprate from FI King Bugbear (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40019 and mobid = 45509;
-- increase c-oj droprate from FI King Bugbear (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40020 and mobid = 45509;
-- increase c-clear droprate from FI King Bugbear (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40021 and mobid = 45509;
-- decrease lvl3 blank droprate from FI King Bugbear (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40092 and mobid = 45509;
-- decrease lvl4 blank droprate from FI King Bugbear (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40093 and mobid = 45509;
-- decrease lvl5 blank droprate from FI King Bugbear (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40094 and mobid = 45509;
-- increase whetstone droprate from FI King Bugbear (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40317 and mobid = 45509;

-- add additional drops to FI King Bugbear 
-- add fsm to FI King Bugbear droplist 
insert into droplist values (45509, 20142, 1, 1, 1500);
-- add 10MR to FI King Bugbear droplist 
insert into droplist values (45509, 20280, 1, 1, 200);

-- modify existing FI Basilisk drops
-- decrease f-sword droprate from FI Basilisk (10000 -> 2500)
update droplist set chance = 2500 where itemid = 18 and mobid = 45531;
-- decrease f-robe droprate from FI Basilisk (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20141 and mobid = 45531;
-- increase orange pot droprate from FI Basilisk (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45531;
-- increase c-red droprate from FI Basilisk (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40019 and mobid = 45531;
-- increase c-oj droprate from FI Basilisk (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40020 and mobid = 45531;
-- increase wafer droprate from FI Basilisk (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40068 and mobid = 45531;

-- modify existing FI Cyclops drops
-- decrease f-gsword droprate from FI Cyclops (10000 -> 3500)
update droplist set chance = 2500 where itemid = 17 and mobid = 45538;
-- decrease fpm droprate from FI Cyclops (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20143 and mobid = 45538;
-- increase orange pot droprate from FI Cyclops (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45538;
-- increase brave pot droprate from FI Cyclops (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40014 and mobid = 45538;
-- increase g-haste pot droprate from FI Cyclops (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45538;
-- increase c-red droprate from FI Cyclops (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40019 and mobid = 45538;
-- increase c-oj droprate from FI Cyclops (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40020 and mobid = 45538;
-- increase nprat droprate from FI Cyclops (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40119 and mobid = 45538;
-- increase id scroll droprate from FI Cyclops (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40126 and mobid = 45538;
-- increase whetstone droprate from FI Cyclops (10000 -> 50000)
update droplist set chance = 50000 where itemid = 40317 and mobid = 45538;

-- modify existing FI Drake drops
-- decrease f-bowgun droprate from FI Drake (10000 -> 3500)
update droplist set chance = 3500 where itemid = 167 and mobid = 45578;
-- decrease 5MR ring droprate from FI Drake (8000 -> 5000)
update droplist set chance = 5000 where itemid = 20303 and mobid = 45578;
-- increase helm of wind droprate from FI Drake (5000 -> 3500)
update droplist set chance = 3500 where itemid = 20023 and mobid = 45578;
-- increase fla droprate from FI Drake (5000 -> 4000)
update droplist set chance = 4000 where itemid = 20140 and mobid = 45578;
-- increase orange pot droprate from FI Drake (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40011 and mobid = 45578;
-- increase clear pot droprate from FI Drake (50000 -> 60000)
update droplist set chance = 60000 where itemid = 40012 and mobid = 45578;
-- increase brave pot droprate from FI Drake (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40014 and mobid = 45578;
-- increase blue pot droprate from FI Drake (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40015 and mobid = 45578;
-- increase wis pot droprate from FI Drake (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40016 and mobid = 45578;
-- increase g-haste pot droprate from FI Drake (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40018 and mobid = 45578;
-- increase c-red droprate from FI Drake (10000 -> 60000)
update droplist set chance = 60000 where itemid = 40019 and mobid = 45578;
-- increase c-oj droprate from FI Drake (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40020 and mobid = 45578;
-- increase c-clear droprate from FI Drake (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40021 and mobid = 45578;
-- increase wafer droprate from FI Drake (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40068 and mobid = 45578;
-- increase res scroll droprate from FI Drake (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40089 and mobid = 45578;
-- increase lvl1 blank droprate from FI Drake (10000 -> 30000)
update droplist set chance = 30000 where itemid = 40090 and mobid = 45578;
-- increase lvl2 blank droprate from FI Drake (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40091 and mobid = 45578;
-- increase lvl3 blank droprate from FI Drake (10000 -> 25000)
update droplist set chance = 25000 where itemid = 40092 and mobid = 45578;
-- increase lvl4 blank droprate from FI Drake (10000 -> 20000)
update droplist set chance = 25000 where itemid = 40093 and mobid = 45578;
-- increase lvl5 blank droprate from FI Drake (10000 -> 20000)
update droplist set chance = 25000 where itemid = 40094 and mobid = 45578;
-- increase nprat droprate from FI Drake (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40119 and mobid = 45578;
-- increase id scroll droprate from FI Drake (10000 -> 75000)
update droplist set chance = 75000 where itemid = 40126 and mobid = 45578;

-- add additional drops to FI Drake 
-- add f-sword to FI Drake droplist 
insert into droplist values (45578, 18, 1, 1, 1000);

-- modify existing Greater Minotaur drops
-- decrease sc:storm shot droprate from Greater Minotaur (50000 -> 20000)
update droplist set chance = 20000 where itemid = 40263 and mobid = 45584;
-- increase great sword droprate from Greater Minotaur (10000 -> 25000)
update droplist set chance = 25000 where itemid = 64 and mobid = 45584;

-- modify existing Bugbear drops
-- decrease splint mail droprate from Bugbear (25000 -> 20000)
update droplist set chance = 20000 where itemid = 20115 and mobid = 45223;
-- decrease nzel droprate from Bugbear (50000 -> 38000)
update droplist set chance = 38000 where itemid = 40074 and mobid = 45223;
-- increase ndai droprate from Bugbear (25000 -> 19000)
update droplist set chance = 19000 where itemid = 40087 and mobid = 45223;
-- increase btele droprate from Bugbear (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45223;
-- decrease b-axe droprate from Bugbear (25000 -> 18000)
update droplist set chance = 18000 where itemid = 143 and mobid = 45223;
-- decrease gaxe droprate from Bugbear (25000 -> 10000)
update droplist set chance = 10000 where itemid = 148 and mobid = 45223;

-- modify existing Cerberus drops
-- decrease sb:i2h droprate from Cerberus (150 -> 120)
update droplist set chance = 120 where itemid = 40213 and mobid = 45241;
-- increase bbs droprate from Cerberus (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40524 and mobid = 45241;

-- modify existing King Bugbear drops
-- decrease banded mail droprate from King Bugbear (25000 -> 18000)
update droplist set chance = 18000 where itemid = 20101 and mobid = 45298;
-- decrease splint mail droprate from King Bugbear (25000 -> 20000)
update droplist set chance = 20000 where itemid = 20115 and mobid = 45298;
-- increase devil's blood droprate from King Bugbear (5000 -> 8000)
update droplist set chance = 8000 where itemid = 40031 and mobid = 45298;
-- increase nzel droprate from King Bugbear (10000 -> 40000)
update droplist set chance = 40000 where itemid = 40074 and mobid = 45298;
-- increase ndai droprate from King Bugbear (5000 -> 20000)
update droplist set chance = 20000 where itemid = 40087 and mobid = 45298;
-- decrease sb:disease droprate from King Bugbear (10000 -> 7500)
update droplist set chance = 7500 where itemid = 40201 and mobid = 45298;
-- increase btele droprate from King Bugbear (50000 -> 75000)
update droplist set chance = 75000 where itemid = 140100 and mobid = 45298;
-- decrease club droprate from King Bugbear (25000 -> 20000)
update droplist set chance = 20000 where itemid = 138 and mobid = 45298;
-- decrease b-axe droprate from King Bugbear (25000 -> 18000)
update droplist set chance = 18000 where itemid = 143 and mobid = 45298;
-- increase beserker axe droprate from King Bugbear (1000 -> 2500)
update droplist set chance = 2500 where itemid = 145 and mobid = 45298;
-- decrease sc:r2n droprate from King Bugbear (10000 -> 2500)
update droplist set chance = 2500 where itemid = 40237 and mobid = 45298;

-- modify existing living armor drops
-- increase hqd droprate from living armor (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40048 and mobid = 45322;
-- increase hqs droprate from living armor (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40050 and mobid = 45322;
-- decrease sb:full heal droprate from living armor (1000 -> 7500)
update droplist set chance = 7500 where itemid = 40202 and mobid = 45322;

-- modify existing crabman drops
-- increase nzel droprate from crabman (10000 -> 15000)
update droplist set chance = 15000 where itemid = 40074 and mobid = 45164;

-- modify existing giant ant drops
-- decrease btele droprate from giant ant (300000 -> 175000)
update droplist set chance = 175000 where itemid = 140100 and mobid = 45115;

-- add additional drops to giant ant 
-- add ruby to giant ant droplist 
insert into droplist values (45115, 40045, 1, 1, 20000);
-- add hqe to giant ant droplist 
insert into droplist values (45115, 40051, 1, 1, 10000);
-- add hqr to giant ant droplist 
insert into droplist values (45115, 40049, 1, 1, 7500);
-- add tqe to giant ant droplist 
insert into droplist values (45115, 40055, 1, 1, 2000);
-- add tqr to giant ant droplist 
insert into droplist values (45115, 40053, 1, 1, 1000);

-- modify existing giant soldier ant drops
-- decrease btele droprate from giant soldier ant (300000 -> 250000)
update droplist set chance = 200000 where itemid = 140100 and mobid = 45190;
-- increase hom:p droprate from giant soldier ant (1000 -> 2000)
update droplist set chance = 2000 where itemid = 20015 and mobid = 45190;
-- increase pm droprate from giant soldier ant (1000 -> 1500)
update droplist set chance = 1500 where itemid = 20154 and mobid = 45190;
-- increase emerald droprate from giant soldier ant (50000 -> 75000)
update droplist set chance = 75000 where itemid = 40047 and mobid = 45190;
-- increase hqe droprate from giant soldier ant (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40051 and mobid = 45190;
-- increase hqr droprate from giant soldier ant (10000 -> 12500)
update droplist set chance = 12500 where itemid = 40049 and mobid = 45190;
-- increase tqe droprate from giant soldier ant (1000 -> 5000)
update droplist set chance = 5000 where itemid = 40055 and mobid = 45190;
-- increase tqr droprate from giant soldier ant (1000 -> 2500)
update droplist set chance = 2500 where itemid = 40053 and mobid = 45190;

