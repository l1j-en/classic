-- Update 20

-- correct name of Jack-O-Lantern (was Pumpkin Seed)
update npc set name = 'Jack-O-Lantern' where npcid = 45167;

-- correct name of Skeletal Pirate Rogue (was Skeleton Skull)
update npc set name = 'Skeletal Pirate Rogue' where npcid = 45314;

-- correct name of Polluted Deep Flower (was nothing)
update npc set name = 'Polluted Deep Flower' where npcid = 45775;

-- correct name of Dio (was nothing)
update npc set name = 'Dio' where npcid = 70027;

-- correct name of Fragment of Spirit (was Elven Bone Pieces)
update etcitem set name = 'Fragment of Spirit' where item_id = 40471;

-- correct name of Ivory Tower Scroll of Curse Removal (was Scroll of Curse Remove)
update etcitem set name = 'Ivory Tower Scroll of Curse Removal' where item_id = 40097;

-- correct name of Cursed Diamond Ring (was NULL)
update armor set name = 'Cursed Diamond Ring' where item_id = 220293;

-- correct name of Cursed Ruby Ring (was NULL)
update armor set name = 'Cursed Ruby Ring' where item_id = 220294;

-- correct name of Cursed Sapphire Ring (was NULL)
update armor set name = 'Cursed Sapphire Ring' where item_id = 220295;

-- correct name of Cursed Emerald Ring (was NULL)
update armor set name = 'Cursed Emerald Ring' where item_id = 220296;

-- correct name of Ring of Hero (was nothing)
update armor set name = 'Ring of Hero' where item_id = 20451;

-- correct name of Armor of Legend (was 1)
update armor set name = 'Armor of Legend' where item_id = 20353;

-- correct name of Boots of Legend (was 2)
update armor set name = 'Boots of Legend' where item_id = 20354;

-- correct name of Gloves of Legend (was 3)
update armor set name = 'Gloves of Legend' where item_id = 20355;

-- correct name of Helm of Legend (was 4)
update armor set name = 'Helm of Legend' where item_id = 20356;

-- correct name of Shield of Legend (was 5)
update armor set name = 'Shield of Legend' where item_id = 20357;

-- correct name of Darkness Dealer Plate Mail (was Unknown18)
update armor set name = 'Darkness Dealer Plate Mail', name_id = '$2571 $152' where item_id = 20133;

-- correct name_id of Silver Serpent Amulet (was nothing)
update armor set name_id = 'Silver Serpent Amulet' where item_id in (20251, 20270);

-- correct name_id of Ring of Vitality (was nothing)
update armor set name_id = 'Ring of Vitality' where item_id = 20286;

-- correct name_id of Ring (was nothing)
update armor set name = 'Ring' where item_id = 20305;

-- correct name of Hakama (was Blue Cloth)
update armor set name = 'Hakama', name_id = 'Hakama' where item_id = 20347;

-- correct name of Holiday Attire (was Red Cloth)
update armor set name = 'Holiday Attire', name_id = 'Holiday Attire' where item_id = 20348;

-- correct name_id of Amulet of Beagle (was nothing)
update armor set name_id = 'Amulet of Beagle' where item_id = 20349;

-- correct name_id of Amulet of Snow Man (was nothing)
update armor set name_id = 'Amulet of Snow Man' where item_id = 20350;

-- correct name_id of Carrot (was nothing)
update armor set name_id = 'Carrot' where item_id = 20351;

-- correct name_id of Stocking (was nothing)
update armor set name_id = 'Stocking' where item_id = 20352;

-- correct name of Sword of Dantes (was 195)
update weapon set name = 'Sword of Dantes' where item_id = 195;

-- correct name of Two-Handed Sword of Varlok (was 196)
update weapon set name = 'Two-Handed Sword of Varlok' where item_id = 196;

-- correct name of Sword of Legend (was Gm's Wrath)
update weapon set name = 'Sword of Legend' where item_id = 228;

-- correct name of Morning Star (was 100146)
update weapon set name = 'Morning Star' where item_id = 100146;

-- correct name of Crossbow (was 100180)
update weapon set name = 'Crossbow' where item_id = 100180;

-- correct name of Yumi (was 100181)
update weapon set name = 'Yumi' where item_id = 100181;

-- correct name of Trident of the Sea God (was 100212)
update weapon set name = 'Trident of the Sea God' where item_id = 100212;

-- correct name of Elven Short Sword (was 100028)
update weapon set name = 'Elven Short Sword' where item_id = 100028;

-- correct name of Elven Dagger (was 100005)
update weapon set name = 'Elven Dagger' where item_id = 100005;

-- correct name of Bow of Cold Mystery (was 191)
update weapon set name = 'Bow of Cold Mystery' where item_id = 191;

-- disable resurrection on FI
update mapids set resurrection = 0 where mapid = 70;

-- update weapon_skill notes
update weapon_skill set note = 'Sword of Silence' where weapon_id = 47;
update weapon_skill set note = 'Sword of Kurtz ' where weapon_id = 54;
update weapon_skill set note = 'Fire Sword of Death Knight' where weapon_id = 58;
update weapon_skill set note = 'Edoryu of Ronde' where weapon_id = 76;
update weapon_skill set note = 'Staff of Ice Queen' where weapon_id = 121;
update weapon_skill set note = 'Thor\'s Hammer' where weapon_id = 450000;
update weapon_skill set note = 'Paagrio\'s Hatred' where weapon_id = 450001;
update weapon_skill set note = 'Maphr\'s Retribution' where weapon_id = 450002;
update weapon_skill set note = 'Orcish Bume Smache' where weapon_id = 450003;
update weapon_skill set note = 'Eva\'s Scorn' where weapon_id = 36;

-- fix Sword of Silence probability (1 -> 7)
update weapon_skill set probability = 7 where weapon_id = 47;

-- modify existing lesser dragon drops
-- increase hqd droprate from lesser dragon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40048 and mobid = 45496;
-- increase hqr droprate from lesser dragon (10000 -> 18000)
update droplist set chance = 18000 where itemid = 40049 and mobid = 45496;
-- increase hqs droprate from lesser dragon (10000 -> 18000)
update droplist set chance = 18000 where itemid = 40050 and mobid = 45496;
-- increase hqe droprate from lesser dragon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40051 and mobid = 45496;
-- increase b-poly droprate from lesser dragon (50000 -> 100000)
update droplist set chance = 100000 where itemid = 140088 and mobid = 45496;
-- increase nzel droprate from lesser dragon (20000 -> 40000)
update droplist set chance = 40000 where itemid = 40074 and mobid = 45496;
-- increase ndai droprate from lesser dragon (10000 -> 20000)
update droplist set chance = 20000 where itemid = 40087 and mobid = 45496;

-- remove n-poly from lesser dragon droplist
delete from droplist where itemid = 40088 and mobid = 45496;

-- modify existing horrific iron golem drops
-- decrease sc:exotic droprate from horrific iron golem (5000 -> 3000)
update droplist set chance = 3000 where itemid = 40252 and mobid = 45479;
-- decrease dsc:shadow fang droprate from horrific iron golem (10000 -> 5000)
update droplist set chance = 5000 where itemid = 40277 and mobid = 45479;
-- increase rough droprate from horrific iron golem (50000 -> 65000)
update droplist set chance = 65000 where itemid = 40496 and mobid = 45479;

-- activate additional abyss lake spawn
update spawnlist set count = 1 where mapid = 420 and count = 0;

-- correct nprat drop on GC dire wolf (was IT nprat)
update droplist set itemid = 40119 where itemid = 40097 and mobid = 45237;

-- correct bounce attack hpconsume (120 -> 10)
update skills set hpConsume = 10 where skill_id = 89;

-- correct horrific iron golem weakness to air
update npc set weak_wind = 1 where npcid = 45479;

-- correct Valley Owlbear weakness to earth, fire
update npc set weak_fire = 1, weak_earth = 1 where npcid = 45056;

-- correct Mutated Lizard weakness to air
update npc set weak_wind = 1 where npcid = 45057;

-- correct Valley Harpy weakness to earth, fire
update npc set weak_fire = 1, weak_earth = 1 where npcid = 45067;

-- correct Starved Troll weakness to fire
update npc set weak_fire = 1 where npcid = 45069;

-- correct Giant Tarantula weakness to air
update npc set weak_wind = 1 where npcid = 45070;

-- correct Island Ghast weakness to fire
update npc set weak_wind = 1 where npcid = 45071;

-- correct Sewer Vakuuk weakness to earth, fire
update npc set weak_fire = 1, weak_earth = 1 where npcid = 45072;

-- correct Underground Ramia weakness to air
update npc set weak_wind = 1 where npcid in (45074, 45076);

-- correct Underground Crabman weakness to air, earth
update npc set weak_wind = 1, weak_earth = 1 where npcid = 45075;

-- correct Valley Ogre weakness to fire
update npc set weak_fire = 1 where npcid = 45078;

-- correct Lesser Succubus weakness to air
update npc set weak_wind = 1 where npcid = 45080;

-- correct Island Ghast Lord weakness to fire
update npc set weak_fire = 1 where npcid = 45081;

-- correct Cursed Bugbear weakness to water
update npc set weak_water = 1 where npcid = 45085;

-- correct Valley Griffon weakness to earth, fire
update npc set weak_fire = 1, weak_earth = 1 where npcid = 45090;

-- correct Valley Basilisk weakness to fire
update npc set weak_fire = 1 where npcid = 45091;

-- correct Island Cockatrice weakness to fire
update npc set weak_fire = 1 where npcid = 45095;

-- correct Island Crocodile weakness to air
update npc set weak_wind = 1 where npcid = 45096;

-- correct Lesser Succubus Queen weakness to air
update npc set weak_wind = 1 where npcid = 45110;

-- correct Island Drake weakness to earth, fire
update npc set weak_fire = 1, weak_earth = 1 where npcid = 45111;

-- correct Cursed Ettin weakness to fire
update npc set weak_fire = 1 where npcid = 45112;

-- correct Wild Venom weakness to fire
update npc set weak_fire = 1 where npcid = 45139;

-- correct Giran Lizardman weakness to air
update npc set weak_wind = 1 where npcid = 45156;

-- correct Mad Lizardman weakness to earth
update npc set weak_earth = 1 where npcid = 45158;

-- correct Wild Fang weakness to fire
update npc set weak_fire = 1 where npcid = 45163;

-- correct Giran Vakuuk weakness to fire
update npc set weak_fire = 1 where npcid = 45187;

-- correct Giran Ghast Lord weakness to fire
update npc set weak_fire = 1 where npcid = 45188;

-- correct Dark Elf Guard (bow) weakness to fire
update npc set weak_fire = 1 where npcid in (45175, 45254);

-- correct Right-Hand Bandit weakness to fire
update npc set weak_fire = 1 where npcid in (45194, 45276);

-- correct Wild Magic weakness to earth
update npc set weak_earth = 1 where npcid = 45197;

-- correct Elder weakness to fire
update npc set weak_fire = 1 where npcid = 45215;

-- correct High Lizardman weakness to air
update npc set weak_wind = 1 where npcid = 45217;

-- correct Giran Ramia weakness to air
update npc set weak_wind = 1 where npcid = 45230;

-- correct Dire Bear weakness to fire
update npc set weak_fire = 1 where npcid in (45236, 45252);

-- correct Dire Wolf weakness to earth
update npc set weak_earth = 1 where npcid in (45237, 45282, 45396);

-- correct Blue Tail weakness to air
update npc set weak_wind = 1 where npcid = 45239;

-- correct Giran Tiger weakness to fire
update npc set weak_fire = 1 where npcid = 45243;

-- correct Skeletal Pirate weakness to fire
update npc set weak_fire = 1 where npcid = 45247;

-- correct Kiwi Parrot weakness to earth
update npc set weak_earth = 1 where npcid = 45249;

-- correct Heavy Lizardman weakness to fire
update npc set weak_fire = 1 where npcid = 45251;

-- correct Dark Elf Beast Tamer weakness to water
update npc set weak_water = 1 where npcid in (45266, 45414, 45356);

-- correct Greater Dark Elemental weakness to fire
update npc set weak_fire = 1 where npcid = 45271;

-- correct Skeletal Pirate Soldier weakness to air, fire
update npc set weak_wind = 1, weak_fire = 1 where npcid = 45274;

-- correct Ogre weakness to fire
update npc set weak_fire = 1 where npcid = 45278;

-- correct Giran Stone Golem weakness to air, fire
update npc set weak_wind = 1, weak_fire = 1 where npcid = 45281;

-- correct Giran Cerberus weakness to water
update npc set weak_water = 1 where npcid = 45283;

-- correct Gelatinous Cube weakness to fire
update npc set weak_fire = 1 where npcid = 45296;

-- correct Subterranean Crabman weakness to air
update npc set weak_wind = 1 where npcid = 45297;

-- correct Subterranean Great King Worm weakness to fire
update npc set weak_fire = 1 where npcid = 45360;

-- correct Subterranean Scorpaitan weakness to earth, fire, wind, water
update npc set weak_wind = 1, weak_earth = 1, weak_fire = 1, weak_water = 1 where npcid = 45383;

-- correct Subterranean Great King Turtle weakness to air
update npc set weak_wind = 1 where npcid = 45422;

-- correct Subterranean Elekkadom weakness to air
update npc set weak_wind = 1 where npcid = 45487;

-- correct Giran Arachnevil Elder weakness to fire
update npc set weak_fire = 1 where npcid = 45312;

-- correct Ancient Giant (Fake?) weakness to earth, fire, wind, water
update npc set weak_wind = 1, weak_earth = 1, weak_fire = 1, weak_water = 1 where npcid = 45316;

-- correct Bandit weakness to fire
update npc set weak_fire = 1 where npcid in (45317, 45324, 45329);

-- correct Giran Cimaera weakness to air
update npc set weak_wind = 1 where npcid = 45325;

-- correct Skeletal Pirate Head weakness to fire
update npc set weak_fire = 1 where npcid = 45330;

-- correct Mutant Ramia weakness to air
update npc set weak_wind = 1 where npcid = 45332;

-- correct Mutant Arachnevil Elder weakness to fire
update npc set weak_fire = 1 where npcid = 45348;

-- correct Arachnevil weakness to fire
update npc set weak_fire = 1 where npcid = 45358;

-- correct Bandit Leader weakness to fire
update npc set weak_fire = 1 where npcid = 45370;

-- correct Subterranean Lizardman weakness to air
update npc set weak_wind = 1 where npcid = 45374;

-- correct Giran Lava Golem weakness to water
update npc set weak_water = 1 where npcid = 45376;

-- correct Ghast weakness to fire
update npc set weak_fire = 1 where npcid = 45378;

-- correct Horrific Fire Egg weakness to water
update npc set weak_water = 1 where npcid = 45384;

-- correct Nightmare weakness to water
update npc set weak_water = 1 where npcid in (45385, 45410, 45440, 45564, 45641);

-- correct Dancing Sword weakness to fire
update npc set weak_fire = 1 where npcid = 45386;

-- correct Horrific Cerberus weakness to water
update npc set weak_water = 1 where npcid = 45471;

-- correct Horrific Iron Golem weakness to air
update npc set weak_wind = 1 where npcid = 45479;

-- correct Minotaur weakness to fire
update npc set weak_fire = 1 where npcid in (45390, 45449);

-- correct Succubus of Varlok weakness to air
update npc set weak_wind = 1 where npcid in (45391, 45450);

-- correct Sema weakness to earth, fire
update npc set weak_wind = 1, weak_earth = 1 where npcid = 45464;

-- correct Spirit Taurverus of Fire weakness to water
update npc set weak_water = 1 where npcid = 45520;

-- correct Wicked Mimic weakness to fire
update npc set weak_fire = 1 where npcid = 45399;

-- correct Water Spirit Master weakness to air
update npc set weak_wind = 1 where npcid = 45500;

-- correct Wind Spirit Master weakness to earth
update npc set weak_earth = 1 where npcid = 45510;

-- correct Raging Skeleton Pike weakness to fire
update npc set weak_fire = 1 where npcid = 45403;

-- correct Dark Lycanthrope weakness to earth, fire
update npc set weak_earth = 1, weak_fire = 1 where npcid = 45485;

-- correct Dark Elder weakness to fire
update npc set weak_fire = 1 where npcid in (45550, 45545);

-- correct Demon of Varlok weakness to water
update npc set weak_water = 1 where npcid = 45647;

-- correct Death weakness to fire
update npc set weak_fire = 1 where npcid = 45417;

-- correct Taurverus weakness to 
update npc set weak_water = 1 where npcid = 45408;

-- correct Fang of Earth weakness to fire
update npc set weak_fire = 1 where npcid = 45416;

-- correct Fang of Wind weakness to earth
update npc set weak_earth = 1 where npcid = 45418;

-- correct Fang of Glacier weakness to air
update npc set weak_wind = 1 where npcid = 45419;

-- correct Fang of Flame weakness to water
update npc set weak_water = 1 where npcid = 45424;

-- correct Fire Necromancer weakness to water
update npc set weak_water = 1 where npcid = 45480;

-- correct Fire Ghost  weakness to wind, earth, fire, water
update npc set weak_wind = 1, weak_earth = 1, weak_fire = 1, weak_water = 1 where npcid in (45514, 45519);

-- correct Fire Spirit Master  weakness to water
update npc set weak_water = 1 where npcid = 45511;

-- correct Raging Ghoul weakness to air, fire
update npc set weak_wind = 1, weak_fire = 1 where npcid = 45454;

-- correct Necromancer weakness to earth
update npc set weak_earth = 1 where npcid in (45456, 45478);

-- correct Cursed Orc Zombie weakness to fire, water
update npc set weak_fire = 1, weak_water = 1 where npcid = 45468;

-- correct Crocodile weakness to air
update npc set weak_wind = 1 where npcid = 45469;

-- correct Cruel Snow Tiger weakness to air, fire
update npc set weak_wind = 1, weak_fire = 1 where npcid = 45528;

-- correct Cougar weakness to earth
update npc set weak_earth = 1 where npcid = 45652;

-- correct Baltuzar weakness to fire
update npc set weak_fire = 1 where npcid = 45473;

-- correct Bone Dragon weakness to water
update npc set weak_water = 1 where npcid = 45522;

-- correct Ball Lightning weakness to earth
update npc set weak_earth = 1 where npcid = 45549;

-- correct Fire Warrior of Darkness weakness to water
update npc set weak_water = 1 where npcid = 45540;

-- correct Baphomet of Varlok weakness to fire
update npc set weak_fire = 1 where npcid = 45569;

-- correct Insolent Zenith Queen weakness to wind, earth, fire, water
update npc set weak_wind = 1, weak_earth = 1, weak_fire = 1, weak_water = 1 where npcid = 45581;

-- correct Iris weakness to earth
update npc set weak_earth = 1 where npcid in (45595, 45654);

-- correct Lesser Demon weakness to water
update npc set weak_water = 1 where npcid = 45481;

-- correct Lesser Demon of Varlok weakness to water
update npc set weak_water = 1 where npcid = 45482;

-- correct Lesser Dragon weakness to water
update npc set weak_water = 1 where npcid = 45496;

-- correct Fire Archer of Darkness weakness to water
update npc set weak_water = 1 where npcid = 45532;

-- correct Large Grave Guardian weakness to air, water
update npc set weak_wind = 1, weak_water = 1 where npcid = 45603;

-- correct Great Spirit of Water weakness to air
update npc set weak_wind = 1 where npcid = 45620;

-- correct Grave Guardian Knight weakness to air, water
update npc set weak_wind = 1, weak_water = 1 where npcid = 45537;

-- correct Grave Guardian weakness to air, water
update npc set weak_wind = 1, weak_water = 1 where npcid = 45498;

-- correct Grave Guardian Mage weakness to air, water
update npc set weak_wind = 1, weak_water = 1 where npcid = 45530;

-- correct Killer Bee weakness to earth
update npc set weak_earth = 1 where npcid = 45554;

-- correct Kurtz weakness to water
update npc set weak_water = 1 where npcid = 45600;

-- correct Knight Vald weakness to water
update npc set weak_water = 1 where npcid in (45664, 45618);

-- correct Mummy Lord weakness to fire
update npc set weak_fire = 1 where npcid in (45616, 45653);

-- correct Marquise Vampire weakness to water
update npc set weak_water = 1 where npcid = 45604;

-- correct Abyss Ghoul weakness to air, earth, wather
update npc set weak_wind = 1, weak_earth = 1, weak_water = 1 where npcid = 45501;

-- correct Astagio of Fire weakness to water
update npc set weak_water = 1 where npcid = 45572;

-- correct Abyss Water Spirit weakness to air
update npc set weak_wind = 1 where npcid = 45591;

-- correct Abyss Earth Spirit weakness to fire
update npc set weak_fire = 1 where npcid = 45592;

-- correct Abyss Wind Spirit weakness to earth
update npc set weak_earth = 1 where npcid = 45593;

-- correct Abyss Fire Spirit weakness to water
update npc set weak_water = 1 where npcid = 45594;

-- correct Earth Spirit Master weakness to fire
update npc set weak_fire = 1 where npcid = 45508;

-- correct Zenith Queen weakness to fire, water
update npc set weak_fire = 1, weak_water = 1 where npcid = 45513;

-- correct Zombie Lord of Fear weakness to fire
update npc set weak_fire = 1 where npcid = 45589;

-- correct Zombie Lord weakness to fire
update npc set weak_fire = 1 where npcid = 45650;

-- correct Varlok weakness to water
update npc set weak_water = 1 where npcid = 45613;

-- correct Succubus Queen of Darkness weakness to air
update npc set weak_wind = 1 where npcid = 45580;

-- correct Thing weakness to fire
update npc set weak_fire = 1 where npcid = 45539;

-- correct Lich weakness to earth, water
update npc set weak_earth = 1, weak_water = 1 where npcid = 45672;

-- fix prince spells
update skills set skill_id = 1169999, skill_number = 3 where skill_id = 115;
update skills set skill_id = 1159999, skill_number = 3 where skill_id = 116;
update skills set skill_id = 115, id = 115, skill_number = 2 where skill_id = 1169999;
update skills set skill_id = 116, id = 116, skill_number = 3 where skill_id = 1159999;

