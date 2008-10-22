-- update 25

-- reactivate 65+ DE morphs
-- ancient gold assassin morph (polyid: 5733)
update polymorphs set minlevel = 65 where id = 5733;
-- ancient platinum assassin morph (polyid: 5736)
update polymorphs set minlevel = 70 where id = 5736;

-- add probability_dice for fblizz
update skills set probability_dice = 7 where skill_id = 80;

-- remove elf crystals from the buy lists of all shops that only purchase
-- them (to exclude gmshop and IT shop, which sell these)
delete from shop where item_id between 40232 and 40264 and selling_price = -1;

-- add elf crystal purchasing from NPC Melissa in Aden
-- Spirit Crystal(ResistMagic)
insert into shop values (70052, 40232, 0, -1, 0, 500);
-- Spirit Crystal(BodytoMind)
insert into shop values (70052, 40233, 0, -1, 0, 500);
-- Spirit Crystal(TeleportToMotherTree)
insert into shop values (70052, 40234, 0, -1, 0, 500);
-- Spirit Crystal(ClearMind)
insert into shop values (70052, 40235, 0, -1, 0, 1000);
-- Spirit Crystal(ResistElemental) 
insert into shop values (70052, 40236, 0, -1, 0, 1000);
-- Spirit Crystal(ReturnToNature)
insert into shop values (70052, 40237, 0, -1, 0, 1500);
-- Spirit Crystal(BloodtoSoul)
insert into shop values (70052, 40238, 0, -1, 0, 1500);
-- Spirit Crystal(ProtectionFromElemental)
insert into shop values (70052, 40239, 0, -1, 0, 1500);
-- Spirit Crystal(TripleShot)
insert into shop values (70052, 40240, 0, -1, 0, 1500);
-- Spirit Crystal(ElementalFallDown)
insert into shop values (70052, 40241, 0, -1, 0, 2000);
-- Spirit Crystal(EraseMagic)
insert into shop values (70052, 40242, 0, -1, 0, 2000);
-- Spirit Crystal(SummonLesserElement)
insert into shop values (70052, 40243, 0, -1, 0, 2000);
-- Spirit Crystal(AreaOfSilence)
insert into shop values (70052, 40244, 0, -1, 0, 2500);
-- Spirit Crystal(SummonGreaterElement)
insert into shop values (70052, 40245, 0, -1, 0, 2500);
-- Spirit Crystal(CounterMirror)
insert into shop values (70052, 40246, 0, -1, 0, 2500);
-- Spirit Crystal(EarthSkin)
insert into shop values (70052, 40247, 0, -1, 0, 1500);
-- Spirit Crystal(Entangle)
insert into shop values (70052, 40248, 0, -1, 0, 1500);
-- Spirit Crystal(EarthBind)
insert into shop values (70052, 40249, 0, -1, 0, 2000);
-- Spirit Crystal(BlessOfEarth)
insert into shop values (70052, 40250, 0, -1, 0, 2000);
-- Spirit Crystal(IronSkin)
insert into shop values (70052, 40251, 0, -1, 0, 2500);
-- Spirit Crystal(ExoticVitalize)
insert into shop values (70052, 40252, 0, -1, 0, 2500);
-- Spirit Crystal(WaterLife)
insert into shop values (70052, 40253, 0, -1, 0, 1500);
-- Spirit Crystal(NaturesTouch)
insert into shop values (70052, 40254, 0, -1, 0, 2000);
-- Spirit Crystal(NaturesBlessing)
insert into shop values (70052, 40255, 0, -1, 0, 2500);
-- Spirit Crystal(FireWeapon)
insert into shop values (70052, 40256, 0, -1, 0, 1500);
-- Spirit Crystal(BlessOfFire)
insert into shop values (70052, 40257, 0, -1, 0, 2000);
-- Spirit Crystal(BurningWeapon)
insert into shop values (70052, 40258, 0, -1, 0, 2500);
-- Spirit Crystal(ElementalFire)
insert into shop values (70052, 40259, 0, -1, 0, 2500);
-- Spirit Crystal(WindShot)
insert into shop values (70052, 40260, 0, -1, 0, 1500);
-- Spirit Crystal(WindWalk)
insert into shop values (70052, 40261, 0, -1, 0, 1500);
-- Spirit Crystal(EyeofStorm)
insert into shop values (70052, 40262, 0, -1, 0, 2000);
-- Spirit Crystal(StormShot) 
insert into shop values (70052, 40263, 0, -1, 0, 2500);
-- Spirit Crystal(WindShackle) 
insert into shop values (70052, 40264, 0, -1, 0, 2500);

-- set Orim nzel price to 30k
update shop set selling_price = 30000, purchasing_price = 15000 where item_id = 40074 and npc_id = 70017;

-- Spirit Crystal(Natures Miracle)  Fixes for melissa and etcitem
insert into shop values (70052, 41243, 0, -1, 0, 2500);
insert into `etcitem` values ('41243', 'Spirit Crystal(NaturesMiracle)', '$1853', 'spellbook', 'normal', 'gemstone', '7000', '688', '2958', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '3', '3000', '0', '0');

-- slight increase in TOI scroll droprates (10500 -> 12500)
update droplist set chance = 12500 where itemid between 40104 and 40112 and chance = 10500;

-- redo losus island crocodile nzel drop (should be able to drop 1-3)
delete from droplist where mobid = 45338 and itemid = 40074;
insert into droplist values (45338, 40074, 1, 3, 150000);

-- crocodile boss should respawn regardless if a PC is on screen at the time
update spawnlist_boss set respawn_screen = 1 where npc_id = 45338;

-- undouble giant guardian (lvl 45 knight quest) mob
update spawnlist set count = 1 where npc_templateid = 45302;
  
-- decrease spawn in TI 1F
-- zombie (80 -> 75)
update spawnlist set count = 75 where npc_templateid =  45065 and mapid = 1;
-- ghoul (80 -> 65)
update spawnlist set count = 65 where npc_templateid =  45157 and mapid = 1;
-- skeleton (160 -> 140)
update spawnlist set count = 140 where npc_templateid =  45107 and mapid = 1;
-- ghoul (40 -> 35)
update spawnlist set count = 35 where npc_templateid =  45068 and mapid = 1;
-- Betrayer's Skeleton Guardsman (10 -> 8)
update spawnlist set count = 8 where npc_templateid =  45100 and mapid = 1;
-- elder (20 -> 15)
update spawnlist set count = 15 where npc_templateid =  45215 and mapid = 1;

-- upped NPC pot merchant Rozen's prices. Should be tax-free, but cost more (+20%)
update shop set selling_price = 44 where npc_id = 70049 and item_id = 40010;
update shop set selling_price = 180 where npc_id = 70049 and item_id = 40011;
update shop set selling_price = 360 where npc_id = 70049 and item_id = 40012;
update shop set selling_price = 84 where npc_id = 70049 and item_id = 40017;
update shop set selling_price = 1800 where npc_id = 70049 and item_id = 40018;

-- increase TOI charm droprates (5000 -> 15000)
update droplist set chance = 15000 where itemid between 40280 and 40288;

-- make whip of beast summoner stackable
update etcitem set stackable = 1 where item_id = 40453;

-- Fix for wrong name in etcitem
update etcitem set name = 'Scroll of Teleportation - TOI 70F', name_id = '$230 - TOI 70F' where item_id=42032;

-- increase devil\'s blood droprate from some mops
-- crabman (5000 -> 7500)
update droplist set chance = 7500 where itemid = 40031 and mobid = 45164;
-- bk (2500 -> 4500)
update droplist set chance = 4500 where itemid = 40031 and mobid = 45165;
-- bugbear (5000 -> 7500)
update droplist set chance = 7500 where itemid = 40031 and mobid in (45223, 45738);
-- de (5000 -> 8500)
update droplist set chance = 8500 where itemid = 40031 and mobid = 45265;
-- Ogre (5000 -> 8500)
update droplist set chance = 8500 where itemid = 40031 and mobid = 45278;
-- King Bugbear (8000 -> 10000)
update droplist set chance = 10000 where itemid = 40031 and mobid = 45298;
-- succubus (3000, 2500 -> 15000)
update droplist set chance = 15000 where itemid = 40031 and mobid in (45393, 45394);
-- succubus queen (5000 -> 18000)
update droplist set chance = 18000 where itemid = 40031 and mobid = 45451;

-- add devil\'s blood to gsa
insert into droplist values (45190, 40031, 1, 1, 5000);

-- add friend\'s bag to drakes quest mop
insert into droplist values(45875, 40710, 1, 1, 1000000);

-- fixed kalba\'s scroll name
update etcitem set name = 'Kalba\'s Scroll' where item_id = 140130;

-- correct time for uncanny dodge (was 192)
update skills set buffDuration = 210 where skill_id = 106;

-- fix GC recluse village area doors (recluse -> GC area connecting to abyss lake)
insert into dungeon values (32823, 32854, 400, 32681, 32971, 400, 2, 'GC Recluse Area');
insert into dungeon values (32681, 32971, 400, 32823, 32854, 400, 2, 'GC Recluse Area');

-- fix castle names
update castle set name = 'Kent Castle' where castle_id = 1;
update castle set name = 'Orc Castle' where castle_id = 2;
update castle set name = 'Windawood Castle' where castle_id = 3;
update castle set name = 'Giran Castle' where castle_id = 4;
update castle set name = 'Heine Castle' where castle_id = 5;
update castle set name = 'Dwarf Castle' where castle_id = 6;
update castle set name = 'Aden Castle' where castle_id = 7;
update castle set name = 'Diad Fortress' where castle_id = 8;

-- fix missed mapid locationname
update mapids set locationname = 'Pago\'s Room' where mapid = 87;

-- fix npc names
update npc set name = 'Oshillia' where npcid = 50119;
update npc set name = 'Beth' where npcid = 50519;
update npc set name = 'Aria' where npcid = 70783;
update npc set name = 'Othmond' where npcid = 70784;
update npc set name = 'Message Board' where npcid = 71008;
update npc set name = 'Vakumo' where npcid = 71042;
update npc set name = 'Booka' where npcid = 71043;
update npc set name = 'Camay' where npcid = 71044;
update npc set name = 'Unknown 71045' where npcid = 71045;
update npc set name = 'Roberto' where npcid = 71046;
update npc set name = 'Lupus' where npcid = 71047;
update npc set name = 'Karu' where npcid = 71048;
update npc set name = 'Rooney' where npcid = 71049;
update npc set name = 'Shian' where npcid = 71050;
update npc set name = 'Monett' where npcid = 71051;
update npc set name = 'Enishia' where npcid = 71052;
update npc set name = 'Berik' where npcid = 71053;
update npc set name = 'Roxanne' where npcid = 71054;
update npc set name = 'Lukein' where npcid = 71055;
update npc set name = 'Simizz' where npcid = 71056;
update npc set name = 'Doyle' where npcid = 71057;
update npc set name = 'Doyle\'s Dog' where npcid = 71058;
update npc set name = 'Rudian' where npcid = 71059;
update npc set name = 'Resta' where npcid = 71060;
update npc set name = 'Cadmus' where npcid = 71061;
update npc set name = 'Kamit' where npcid = 71062;
update npc set name = 'Small Box' where npcid = 71063;
update npc set name = 'Small Box' where npcid = 71064;
update npc set name = 'Small Box' where npcid = 71065;
update npc set name = 'Small Box' where npcid = 71066;
update npc set name = 'Small Box' where npcid = 71067;
update npc set name = 'Small Box' where npcid = 71068;
update npc set name = 'Small Box' where npcid = 71069;
update npc set name = 'Small Box' where npcid = 71070;
update npc set name = 'Small Box' where npcid = 71071;
update npc set name = 'Small Box' where npcid = 71072;
update npc set name = 'Small Box' where npcid = 71073;
update npc set name = 'Lizardman Elder' where npcid = 71074;
update npc set name = 'Exhausted Lizardman Warrior' where npcid = 71075;
update npc set name = 'Young Lizardman Warrior' where npcid = 71076;
update npc set name = 'Geographical Explorer' where npcid = 71077;
update npc set name = 'Unknown 71078' where npcid = 71078;
update npc set name = 'Unknown 71079' where npcid = 71079;
update npc set name = 'Unknown 71080' where npcid = 71080;
update npc set name = 'Unknown 71081' where npcid = 71081;
update npc set name = 'Unknown 71082' where npcid = 71082;
update npc set name = 'Unknown 71083' where npcid = 71083;
update npc set name = 'Unknown 71084' where npcid = 71084;
update npc set name = 'One of the Red Key\'s Secrets' where npcid = 71085;
update npc set name = 'Unknown 71086' where npcid = 71086;
update npc set name = 'Unknown 71087' where npcid = 71087;
update npc set name = 'Unknown 71088' where npcid = 71088;
update npc set name = 'Franco' where npcid = 71089;
update npc set name = 'Crystal of Ordeal' where npcid = 71090;
update npc set name = 'Crystal of Ordeal' where npcid = 71091;
update npc set name = 'Oasis Stuff' where npcid = 80001;
update npc set name = 'Large Christmas Tree' where npcid = 80002;
update npc set name = 'Small Christmas Tree' where npcid = 80003;
update npc set name = 'Large Christmas Tree' where npcid = 80004;
update npc set name = 'Weather Vane' where npcid = 80005;
update npc set name = 'Message Board' where npcid = 80006;
update npc set name = 'Flying Bird' where npcid = 80007;
update npc set name = 'Ship' where npcid = 80008;
update npc set name = 'Treasure Chest' where npcid = 80009;
update npc set name = 'Unknown 80010' where npcid = 80010;
update npc set name = 'Unknown 80011' where npcid = 80011;
update npc set name = 'Unknown 80012' where npcid = 80012;
update npc set name = 'Unknown 80013' where npcid = 80013;
update npc set name = 'Unknown 80014' where npcid = 80014;
update npc set name = 'Unknown 80015' where npcid = 80015;
update npc set name = 'Unknown 80016' where npcid = 80016;
update npc set name = 'Unknown 80017' where npcid = 80017;
update npc set name = 'Unknown 80018' where npcid = 80018;
update npc set name = 'Unknown 80019', nameid = ''  where npcid = 80019;
update npc set name = 'Unknown 80020', nameid = '' where npcid = 80020;
update npc set name = 'Unknown 80021' where npcid = 80021;
update npc set name = 'Unknown 80022' where npcid = 80022;
update npc set name = 'Unknown 80023' where npcid = 80023;
update npc set name = 'Unknown 80024' where npcid = 80024;
update npc set name = 'Unknown 80025' where npcid = 80025;
update npc set name = 'Unknown 80026' where npcid = 80026;
update npc set name = 'Unknown 80027' where npcid = 80027;
update npc set name = 'Unknown 80028' where npcid = 80028;
update npc set name = 'Unknown 80029' where npcid = 80029;
update npc set name = 'Unknown 80030' where npcid = 80030;
update npc set name = 'Unknown 80031' where npcid = 80031;
update npc set name = 'Unknown 80032' where npcid = 80032;
update npc set name = 'Unknown 80033' where npcid = 80033;
update npc set name = 'Unknown 80034', nameid = '' where npcid = 80034;
update npc set name = 'Unknown 80035', nameid = '' where npcid = 80035;
update npc set name = 'Unknown 80036', nameid = '' where npcid = 80036;
update npc set name = 'Unknown 80037', nameid = '' where npcid = 80037;
update npc set name = 'Ivory Tower Wizard' where npcid = 80038;
update npc set name = 'Ivory Tower Wizard' where npcid = 80039;
update npc set name = 'Ivory Tower Wizard' where npcid = 80040;
update npc set name = 'Ivory Tower Wizard' where npcid = 80041;
update npc set name = 'Unknown 80042' where npcid = 80042;
update npc set name = 'Unknown 80043' where npcid = 80043;
update npc set name = 'Unknown 80044' where npcid = 80044;
update npc set name = 'Unknown 80045' where npcid = 80045;
update npc set name = 'Chamberlain of Yahee' where npcid = 80047;
update npc set name = 'Twisting of Space' where npcid = 80048;
update npc set name = 'Unknown 80049' where npcid = 80049;
update npc set name = 'Unknown 80050' where npcid = 80050;
update npc set name = 'Yahee' where npcid = 80051;
update npc set name = 'Unknown 80052' where npcid = 80052;
update npc set name = 'Unknown 80053' where npcid = 80053;
update npc set name = 'Unknown 80054' where npcid = 80054;
update npc set name = 'Unknown 80055' where npcid = 80055;
update npc set name = 'Unknown 80056' where npcid = 80056;
update npc set name = 'Alfons' where npcid = 80057;
update npc set name = 'Unknown 80058' where npcid = 80058;
update npc set name = 'Unknown 80059' where npcid = 80059;
update npc set name = 'Unknown 80060' where npcid = 80060;
update npc set name = 'Unknown 80061' where npcid = 80061;
update npc set name = 'Unknown 80062' where npcid = 80062;
update npc set name = 'Unknown 80063' where npcid = 80063;
update npc set name = 'Unknown 80064' where npcid = 80064;
update npc set name = 'Agent of Varlok' where npcid = 80065;
update npc set name = 'Unknown 80066' where npcid = 80066;
update npc set name = 'Unknown 80067' where npcid = 80067;
update npc set name = 'Incarnation of Varlok' where npcid = 80068;
update npc set name = 'Lesser Demon' where npcid = 80069;
update npc set name = 'Lesser Demon' where npcid = 80070;
update npc set name = 'Assistant of Varlok' where npcid = 80071;
update npc set name = 'Blacksmith of Varlok' where npcid = 80072;
update npc set name = 'Unknown 80073' where npcid = 80073;
update npc set name = 'Unknown 80074' where npcid = 80074;
update npc set name = 'Beheak' where npcid = 80075;
update npc set name = 'Rotting Voyager' where npcid = 80076;
update npc set name = 'Unknown 80077' where npcid = 80077;
update npc set name = 'Harbor Master' where npcid = 81000;
update npc set name = 'Ramia' where npcid = 81107;
update npc set name = 'Zombie' where npcid = 81108;
update npc set name = 'Skeleton' where npcid = 81109;
update npc set name = 'Unknown 81110', nameid = '' where npcid = 81110;
update npc set name = 'Rader' where npcid = 81112;
update npc set name = 'Hagutin' where npcid = 81113;
update npc set name = 'Black Knight Captainn' where npcid = 81115;
update npc set name = 'Fettered Soul' where npcid = 81118;
update npc set name = 'Servant of Kalbas' where npcid = 81120;
update npc set name = 'Ancient Spirit' where npcid = 81121;
update npc set name = 'Siege Flag' where npcid = 81122;
update npc set name = 'Jack-O-Latern' where npcid = 81123;
update npc set name = 'Crown' where npcid = 81125;
update npc set name = 'Black Knight', nameid = 'Black Knight' where npcid = 81030;
update npc set name = 'Black Mage', nameid = 'Black Mage' where npcid = 81031;
update npc set name = 'Black Ranger', nameid = 'Black Ranger' where npcid = 81032;
update npc set name = 'Silver Knight', nameid = 'Silver Knight' where npcid = 81033;
update npc set name = 'Silver Mage', nameid = 'Silver Mage' where npcid = 81034;
update npc set name = 'Silver Ranger', nameid = 'Silver Ranger' where npcid = 81035;
update npc set name = 'Sword Master', nameid = 'Sword Master' where npcid = 81036;
update npc set name = 'Wizardry Master', nameid = 'Wizardry Master' where npcid = 81037;
update npc set name = 'Arrow Master', nameid = 'Arrow Master' where npcid = 81038;
update npc set name = 'Arch Knight', nameid = 'Arch Knight' where npcid = 81039;
update npc set name = 'Arch Mage', nameid = 'Arch Mage' where npcid = 81040;
update npc set name = 'Arch Ranger', nameid = 'Arch Ranger' where npcid = 81041;
update npc set name = 'Acaleph' where npcid = 81042;
update npc set name = 'Varlok\'s Servant' where npcid = 81044;
update npc set name = 'Unknown 81046' where npcid = 81046;
update npc set name = 'Grim Reaper' where npcid = 81047;
update npc set name = 'Unknown 81048' where npcid = 81048;
update npc set name = 'Unknown 81049' where npcid = 81049;
update npc set name = 'Orc' where npcid = 81054;
update npc set name = 'Goblin' where npcid = 81055;
update npc set name = 'Goblin' where npcid = 81056;
update npc set name = 'Kobold' where npcid = 81057;
update npc set name = 'Orc Archer' where npcid = 81058;
update npc set name = 'Eidlon' where npcid = 81059;
update npc set name = 'Dwarf' where npcid = 81060;
update npc set name = 'Orc Fighter' where npcid = 81061;
update npc set name = 'Orc Fighter' where npcid = 81062;
update npc set name = 'Gnoll' where npcid = 81063;
update npc set name = 'Steleton Soldier' where npcid = 81064;
update npc set name = 'Stone Golem' where npcid = 81065;
update npc set name = 'Black Knight' where npcid = 81067;
update npc set name = 'Lycanthrope' where npcid = 81068;
update npc set name = 'Unknown 81078' where npcid = 81078;
update npc set name = 'Unknown 81079' where npcid = 81079;
update npc set name = 'Crown' where npcid = 81125;
update npc set name = 'Message Board' where npcid = 81127;
update npc set name = 'Message Board' where npcid = 81128;
update npc set name = 'Message Board' where npcid = 81129;
update npc set name = 'Unknown 81131', nameid = '' where npcid = 81131;
update npc set name = 'Unknown 81132', nameid = '' where npcid = 81132;
update npc set name = 'Unknown 81133', nameid = 'Unknown $1430' where npcid = 81133;
update npc set name = 'Unknown 81134', nameid = 'Unknown $1497' where npcid = 81134;
update npc set name = 'Unknown 81135', nameid = 'Unknown $1429' where npcid = 81135;
update npc set name = 'Unknown 81136' where npcid = 81136;
update npc set name = 'Unknown 81137', nameid = 'Unknown $1429' where npcid = 81137;
update npc set name = 'Unknown 81138', nameid = '' where npcid = 81138;
update npc set name = 'Unknown 81139', nameid = '' where npcid = 81139;
update npc set name = 'Unknown 81140', nameid = 'Unknown $57' where npcid = 81140;
update npc set name = 'Unknown 81141', nameid = 'Unknown $7' where npcid = 81141;
update npc set name = 'Unknown 81142', nameid = 'Unknown $986' where npcid = 81142;
update npc set name = 'Unknown 81143', nameid = 'Unknown $318' where npcid = 81143;
update npc set name = 'Unknown 81144', nameid = 'Unknown $1563' where npcid = 81144;
update npc set name = 'Unknown 81145', nameid = 'Unknown $1563' where npcid = 81145;
update npc set name = 'Unknown 81146', nameid = 'Unknown $1562' where npcid = 81146;
update npc set name = 'Unknown 81147', nameid = '' where npcid = 81147;
update npc set name = 'Unknown 81148', nameid = '' where npcid = 81148;
update npc set name = 'Unknown 81149', nameid = '' where npcid = 81149;
update npc set name = 'Unknown 81150', nameid = 'Unknown $1016' where npcid = 81150;
update npc set name = 'Unknown 81151', nameid = 'Unknown $1018' where npcid = 81151;
update npc set name = 'Unknown 81152', nameid = 'Unknown $1017' where npcid = 81152;
update npc set name = 'Unknown 81153', nameid = '' where npcid = 81153;
update npc set name = 'Unknown 81154', nameid = '' where npcid = 81154;
update npc set name = 'Olle' where npcid = 81155;
update npc set name = 'Aden Reconnaissance Soldier' where npcid = 81156;
update npc set name = 'Unknown 81158' where npcid = 81158;
update npc set name = 'Unknown 81162' where npcid = 81162;
update npc set name = 'Girtas' where npcid = 81163;
update npc set name = 'Fire' where npcid = 81164;
update npc set name = 'Fire' where npcid = 81165;
update npc set name = 'Light Rays' where npcid = 81166;
update npc set name = 'Light Rays' where npcid = 81167;
update npc set name = 'Freeze Effect' where npcid = 81168;
update npc set name = 'Life Stream Effect' where npcid = 81169;

-- fix all town names
update town set name = 'Talking Island Village' where town_id = 1;
update town set name = 'Silver Knight Town' where town_id = 2;
update town set name = 'Gludio' where town_id = 3;
update town set name = 'Fire Farmers Town' where town_id = 4;
update town set name = 'Windawood' where town_id = 5;
update town set name = 'Kent Village' where town_id = 6;
update town set name = 'Giran' where town_id = 7;
update town set name = 'Heine' where town_id = 8;
update town set name = 'Werldern Village' where town_id = 9;
update town set name = 'Oren' where town_id = 10;

-- fix all trap notes
update trap set note = 'Damage 1' where id = 1;
update trap set note = 'Damage 2' where id = 2;
update trap set note = 'Normal Poison' where id = 3;
update trap set note = 'Silence Poison' where id = 4;
update trap set note = 'Paralysis Poison' where id = 5;
update trap set note = 'Damage 3' where id = 6;
update trap set note = 'Damage 4' where id = 7;
update trap set note = 'TOI4F: Mutant Arachnevil Elder' where id = 8;
update trap set note = 'TOI8F: Cimaera' where id = 9;
update trap set note = 'TOI14F: Succubus' where id = 10;
update trap set note = 'TOI18F: Wicked Beholder' where id = 11;
update trap set note = 'TOI24F: Horrific Fire Egg' where id = 12;
update trap set note = 'TOI28F: Horrific Cerberus' where id = 13;
update trap set note = 'TOI34F: Raging Skeleton Pike' where id = 14;
update trap set note = 'TOI38F: Raging Spartoi' where id = 15;
update trap set note = 'TOI44F: Fire Ghost' where id = 16;
update trap set note = 'TOI48F: Bone Dragon' where id = 17;
update trap set note = 'TOI54F: Cursed Elmore Soldier' where id = 18;
update trap set note = 'TOI64F: Cruel Snow Tiger' where id = 19;
update trap set note = 'TOI74F: Black Knight of Darkness' where id = 20;
update trap set note = 'TOI78F: Fire Archer of Darkness' where id = 21;
update trap set note = 'TOI84F: Lesser Seer' where id = 22;
update trap set note = 'TOI94F: Great Spirit of Wind' where id = 23;
update trap set note = 'IT4F: Iron Golem' where id = 24;
update trap set note = 'IT4F: Mimic' where id = 25;
update trap set note = 'IT4F: Living Armor' where id = 26;
update trap set note = 'IT5F: Iron Golem' where id = 27;
update trap set note = 'IT5F: Mimic' where id = 28;
update trap set note = 'IT5F: Living Armor' where id = 29;
update trap set note = 'IT6F: Silhouette' where id = 30;
update trap set note = 'IT6F: Death' where id = 31;
update trap set note = 'IT7F: Silhouette' where id = 32;
update trap set note = 'IT7F: Death' where id = 33;
update trap set note = 'IT8F: Iron Golem' where id = 34;
update trap set note = 'IT8F: Silhouette' where id = 35;
update trap set note = 'IT8F: Death' where id = 36;
update trap set note = 'IT8F: Living Armor' where id = 37;

-- blank out the location field in spawnlist_ub
update spawnlist_ub set location = '';

-- update pettype names
update pettypes p set p.name = (select n.name from npc n where n.npcid = p.basenpcid);

-- update spawnlist location 
update spawnlist sl set sl.location = (select n.name from npc n where n.npcid = sl.npc_templateid);

-- update spawnlist_boss location
update spawnlist_boss sb set sb.location = (select n.name from npc n where n.npcid = sb.npc_id);

-- update spawnlist_npc location
update spawnlist_npc sn set sn.location = (select n.name from npc n where n.npcid = sn.npc_templateid);

-- blank out spawnlist_ub location
update spawnlist_ub su set su.location = '';

-- update dungeon note (just putting the destination in here)
update dungeon d set d.note = (select m.locationname from mapids m where m.mapid = d.new_mapid);

-- update getback notes
update getback g set note = (select m.locationname from mapids m where m.mapid = g.area_mapid) 
where exists (select 'x' from mapids m where m.mapid = g.area_mapid);

-- blank out unused getback notes (these maybe should be removed)
update getback g set note = '' where not exists (select 'x' from mapids m where m.mapid = g.area_mapid);

-- update getback_restart areanames
update getback_restart gr set areaname = (select m.locationname from mapids m where m.mapid = gr.area);

-- update mobskill mobnames
update mobskill ms set ms.mobname = (select n.name from npc n where n.npcid = ms.mobid);

-- fix all house house_name and location fields
-- excluding already named houses on lindc server, will need to update these for dml script migration
update house set house_name = 'Giran House 1', location = 'Giran' where house_id = 262145;
update house set house_name = 'Giran House 2', location = 'Giran' where house_id = 262146;
update house set location = 'Giran' where house_id = 262147;
update house set house_name = 'Giran House 4', location = 'Giran' where house_id = 262148;
update house set house_name = 'Giran House 5', location = 'Giran' where house_id = 262149;
update house set house_name = 'Giran House 6', location = 'Giran' where house_id = 262150;
update house set house_name = 'Giran House 7', location = 'Giran' where house_id = 262151;
update house set house_name = 'Giran House 8', location = 'Giran' where house_id = 262152;
update house set house_name = 'Giran House 9', location = 'Giran' where house_id = 262153;
update house set house_name = 'Giran House 10', location = 'Giran' where house_id = 262154;
update house set house_name = 'Giran House 11', location = 'Giran' where house_id = 262155;
update house set house_name = 'Giran House 12', location = 'Giran' where house_id = 262156;
update house set house_name = 'Giran House 13', location = 'Giran' where house_id = 262157;
update house set house_name = 'Giran House 14', location = 'Giran' where house_id = 262158;
update house set house_name = 'Giran House 15', location = 'Giran' where house_id = 262159;
update house set house_name = 'Giran House 16', location = 'Giran' where house_id = 262160;
update house set house_name = 'Giran House 17', location = 'Giran' where house_id = 262161;
update house set house_name = 'Giran House 18', location = 'Giran' where house_id = 262162;
update house set house_name = 'Giran House 19', location = 'Giran' where house_id = 262163;
update house set house_name = 'Giran House 20', location = 'Giran' where house_id = 262164;
update house set house_name = 'Giran House 21', location = 'Giran' where house_id = 262165;
update house set house_name = 'Giran House 22', location = 'Giran' where house_id = 262166;
update house set house_name = 'Giran House 23', location = 'Giran' where house_id = 262167;
update house set house_name = 'Giran House 24', location = 'Giran' where house_id = 262168;
update house set house_name = 'Giran House 25', location = 'Giran' where house_id = 262169;
update house set location = 'Giran' where house_id = 262170;
update house set house_name = 'Giran House 27', location = 'Giran' where house_id = 262171;
update house set house_name = 'Giran House 28', location = 'Giran' where house_id = 262172;
update house set house_name = 'Giran House 29', location = 'Giran' where house_id = 262173;
update house set house_name = 'Giran House 30', location = 'Giran' where house_id = 262174;
update house set house_name = 'Giran House 31', location = 'Giran' where house_id = 262175;
update house set house_name = 'Giran House 32', location = 'Giran' where house_id = 262176;
update house set house_name = 'Giran House 33', location = 'Giran' where house_id = 262177;
update house set house_name = 'Giran House 34', location = 'Giran' where house_id = 262178;
update house set location = 'Giran' where house_id = 262179;
update house set house_name = 'Giran House 36', location = 'Giran' where house_id = 262180;
update house set house_name = 'Giran House 37', location = 'Giran' where house_id = 262181;
update house set house_name = 'Giran House 38', location = 'Giran' where house_id = 262182;
update house set house_name = 'Giran House 39', location = 'Giran' where house_id = 262183;
update house set house_name = 'Giran House 40', location = 'Giran' where house_id = 262184;
update house set house_name = 'Giran House 41', location = 'Giran' where house_id = 262185;
update house set house_name = 'Giran House 42', location = 'Giran' where house_id = 262186;
update house set house_name = 'Giran House 43', location = 'Giran' where house_id = 262187;
update house set house_name = 'Giran House 44', location = 'Giran' where house_id = 262188;
update house set house_name = 'Giran House 45', location = 'Giran' where house_id = 262189;
update house set house_name = 'Heine House 1', location = 'Heine' where house_id = 327681;
update house set house_name = 'Heine House 2', location = 'Heine' where house_id = 327682;
update house set house_name = 'Heine House 3', location = 'Heine' where house_id = 327683;
update house set house_name = 'Heine House 4', location = 'Heine' where house_id = 327684;
update house set house_name = 'Heine House 5', location = 'Heine' where house_id = 327685;
update house set house_name = 'Heine House 6', location = 'Heine' where house_id = 327686;
update house set house_name = 'Heine House 7', location = 'Heine' where house_id = 327687;
update house set house_name = 'Heine House 8', location = 'Heine' where house_id = 327688;
update house set house_name = 'Heine House 9', location = 'Heine' where house_id = 327689;
update house set house_name = 'Heine House 10', location = 'Heine' where house_id = 327690;
update house set house_name = 'Heine House 11', location = 'Heine' where house_id = 327691;
update house set house_name = 'Aden House 1', location = 'Aden' where house_id = 458753;
update house set house_name = 'Aden House 2', location = 'Aden' where house_id = 458754;
update house set house_name = 'Aden House 3', location = 'Aden' where house_id = 458755;
update house set house_name = 'Aden House 4', location = 'Aden' where house_id = 458756;
update house set house_name = 'Aden House 5', location = 'Aden' where house_id = 458757;
update house set house_name = 'Aden House 6', location = 'Aden' where house_id = 458758;
update house set house_name = 'Aden House 7', location = 'Aden' where house_id = 458759;
update house set house_name = 'Aden House 8', location = 'Aden' where house_id = 458760;
update house set house_name = 'Aden House 9', location = 'Aden' where house_id = 458761;
update house set house_name = 'Aden House 10', location = 'Aden' where house_id = 458762;
update house set house_name = 'Aden House 11', location = 'Aden' where house_id = 458763;
update house set house_name = 'Aden House 12', location = 'Aden' where house_id = 458764;
update house set house_name = 'Aden House 13', location = 'Aden' where house_id = 458765;
update house set house_name = 'Aden House 14', location = 'Aden' where house_id = 458766;
update house set house_name = 'Aden House 15', location = 'Aden' where house_id = 458767;
update house set house_name = 'Aden House 16', location = 'Aden' where house_id = 458768;
update house set house_name = 'Aden House 17', location = 'Aden' where house_id = 458769;
update house set house_name = 'Aden House 18', location = 'Aden' where house_id = 458770;
update house set house_name = 'Aden House 19', location = 'Aden' where house_id = 458771;
update house set house_name = 'Aden House 20', location = 'Aden' where house_id = 458772;
update house set house_name = 'Aden House 21', location = 'Aden' where house_id = 458773;
update house set house_name = 'Aden House 22', location = 'Aden' where house_id = 458774;
update house set house_name = 'Aden House 23', location = 'Aden' where house_id = 458775;
update house set house_name = 'Aden House 24', location = 'Aden' where house_id = 458776;
update house set house_name = 'Aden House 25', location = 'Aden' where house_id = 458777;
update house set house_name = 'Aden House 26', location = 'Aden' where house_id = 458778;
update house set house_name = 'Aden House 27', location = 'Aden' where house_id = 458779;
update house set house_name = 'Aden House 28', location = 'Aden' where house_id = 458780;
update house set house_name = 'Aden House 29', location = 'Aden' where house_id = 458781;
update house set house_name = 'Aden House 30', location = 'Aden' where house_id = 458782;
update house set house_name = 'Aden House 31', location = 'Aden' where house_id = 458783;
update house set house_name = 'Aden House 32', location = 'Aden' where house_id = 458784;
update house set house_name = 'Aden House 33', location = 'Aden' where house_id = 458785;
update house set house_name = 'Aden House 34', location = 'Aden' where house_id = 458786;
update house set house_name = 'Aden House 35', location = 'Aden' where house_id = 458787;
update house set house_name = 'Aden House 36', location = 'Aden' where house_id = 458788;
update house set house_name = 'Aden House 37', location = 'Aden' where house_id = 458789;
update house set house_name = 'Aden House 38', location = 'Aden' where house_id = 458790;
update house set house_name = 'Aden House 39', location = 'Aden' where house_id = 458791;
update house set house_name = 'Aden House 40', location = 'Aden' where house_id = 458792;
update house set house_name = 'Aden House 41', location = 'Aden' where house_id = 458793;
update house set house_name = 'Aden House 42', location = 'Aden' where house_id = 458794;
update house set house_name = 'Aden House 43', location = 'Aden' where house_id = 458795;
update house set house_name = 'Aden House 44', location = 'Aden' where house_id = 458796;
update house set house_name = 'Aden House 45', location = 'Aden' where house_id = 458797;
update house set house_name = 'Aden House 46', location = 'Aden' where house_id = 458798;
update house set house_name = 'Aden House 47', location = 'Aden' where house_id = 458799;
update house set house_name = 'Aden House 48', location = 'Aden' where house_id = 458800;
update house set house_name = 'Aden House 49', location = 'Aden' where house_id = 458801;
update house set house_name = 'Aden House 50', location = 'Aden' where house_id = 458802;
update house set house_name = 'Aden House 51', location = 'Aden' where house_id = 458803;
update house set house_name = 'Aden House 52', location = 'Aden' where house_id = 458804;
update house set house_name = 'Aden House 53', location = 'Aden' where house_id = 458805;
update house set house_name = 'Aden House 54', location = 'Aden' where house_id = 458806;
update house set house_name = 'Aden House 55', location = 'Aden' where house_id = 458807;
update house set house_name = 'Aden House 56', location = 'Aden' where house_id = 458808;
update house set house_name = 'Aden House 57', location = 'Aden' where house_id = 458809;
update house set house_name = 'Aden House 58', location = 'Aden' where house_id = 458810;
update house set house_name = 'Aden House 59', location = 'Aden' where house_id = 458811;
update house set house_name = 'Aden House 60', location = 'Aden' where house_id = 458812;
update house set house_name = 'Aden House 61', location = 'Aden' where house_id = 458813;
update house set house_name = 'Aden House 62', location = 'Aden' where house_id = 458814;
update house set house_name = 'Aden House 63', location = 'Aden' where house_id = 458815;
update house set house_name = 'Aden House 64', location = 'Aden' where house_id = 458816;
update house set house_name = 'Aden House 65', location = 'Aden' where house_id = 458817;
update house set house_name = 'Aden House 66', location = 'Aden' where house_id = 458818;
update house set house_name = 'Aden House 67', location = 'Aden' where house_id = 458819;

-- fix ub_settings ub_name fields
update ub_settings set ub_name = 'Giran UB' where ub_id = 1;
update ub_settings set ub_name = 'Werldern UB' where ub_id = 2;
update ub_settings set ub_name = 'Gludio UB' where ub_id = 3;
update ub_settings set ub_name = 'TI UB' where ub_id = 4;
update ub_settings set ub_name = 'SKT UB' where ub_id = 5;

-- fix skills name fields
update skills set name = 'Unknown' where skill_id = 119;
update skills set name = 'Unknown' where skill_id = 120;
update skills set name = 'Unknown' where skill_id = 10001;
update skills set name = 'Unknown' where skill_id = 10002;
update skills set name = 'Unknown' where skill_id = 10003;
update skills set name = 'Unknown' where skill_id = 10004;
update skills set name = 'Unknown' where skill_id = 10005;
update skills set name = 'Unknown' where skill_id = 10006;
update skills set name = 'Unknown' where skill_id = 10007;
update skills set name = 'Unknown' where skill_id = 10008;
update skills set name = 'Unknown' where skill_id = 10009;
update skills set name = 'Unknown' where skill_id = 10010;
update skills set name = 'Unknown' where skill_id = 10011;
update skills set name = 'Unknown' where skill_id = 10012;
update skills set name = 'Unknown' where skill_id = 10013;
update skills set name = 'Unknown' where skill_id = 10014;
update skills set name = 'Unknown' where skill_id = 10015;
update skills set name = 'Unknown' where skill_id = 10016;
update skills set name = 'Unknown' where skill_id = 10017;
update skills set name = 'Unknown' where skill_id = 10018;
update skills set name = 'Unknown' where skill_id = 10019;
update skills set name = 'Unknown' where skill_id = 10021;
update skills set name = 'Unknown' where skill_id = 10022;
update skills set name = 'Unknown' where skill_id = 10023;
update skills set name = 'Unknown' where skill_id = 10024;
update skills set name = 'Unknown' where skill_id = 10025;
update skills set name = 'Unknown' where skill_id = 10026;
update skills set name = 'Unknown' where skill_id = 10027;
update skills set name = 'Unknown' where skill_id = 10028;
update skills set name = 'Unknown' where skill_id = 10029;
update skills set name = 'Unknown' where skill_id = 10030;
update skills set name = 'Unknown' where skill_id = 10031;
update skills set name = 'Unknown' where skill_id = 10032;
update skills set name = 'Unknown' where skill_id = 10033;
update skills set name = 'Unknown' where skill_id = 10034;
update skills set name = 'Unknown' where skill_id = 10035;
update skills set name = 'Unknown' where skill_id = 10036;
update skills set name = 'Unknown' where skill_id = 10037;
update skills set name = 'Unknown' where skill_id = 10038;
update skills set name = 'Unknown' where skill_id = 10039;
update skills set name = 'Unknown' where skill_id = 10040;
update skills set name = 'Unknown' where skill_id = 10041;
update skills set name = 'Unknown' where skill_id = 10042;
update skills set name = 'Unknown' where skill_id = 10043;
update skills set name = 'Unknown' where skill_id = 10044;
update skills set name = 'Unknown' where skill_id = 10045;
update skills set name = 'Unknown' where skill_id = 10046;
update skills set name = 'Unknown' where skill_id = 10047;
update skills set name = 'Unknown' where skill_id = 10048;
update skills set name = 'Unknown' where skill_id = 10049;
update skills set name = 'Unknown' where skill_id = 10050;
update skills set name = 'Unknown' where skill_id = 10051;
update skills set name = 'Unknown' where skill_id = 10052;
update skills set name = 'Unknown' where skill_id = 10053;
update skills set name = 'Unknown' where skill_id = 10054;
update skills set name = 'Unknown' where skill_id = 10055;
update skills set name = 'Unknown' where skill_id = 10056;
update skills set name = 'Unknown' where skill_id = 10057;
update skills set name = 'Unknown' where skill_id = 10058;
update skills set name = 'Unknown' where skill_id = 10059;
update skills set name = 'Unknown' where skill_id = 10060;
update skills set name = 'Unknown' where skill_id = 10061;
update skills set name = 'Unknown' where skill_id = 10062;
update skills set name = 'Unknown' where skill_id = 10063;
update skills set name = 'Unknown' where skill_id = 10064;
update skills set name = 'Unknown' where skill_id = 10065;
update skills set name = 'Unknown' where skill_id = 10066;
update skills set name = 'Unknown' where skill_id = 10067;
update skills set name = 'Unknown' where skill_id = 10068;
update skills set name = 'Unknown' where skill_id = 10069;
update skills set name = 'Unknown' where skill_id = 10070;
update skills set name = 'Unknown' where skill_id = 10071;
update skills set name = 'Unknown' where skill_id = 10072;
update skills set name = 'Unknown' where skill_id = 10073;
update skills set name = 'Unknown' where skill_id = 10074;
update skills set name = 'Unknown' where skill_id = 10075;
update skills set name = 'Unknown' where skill_id = 10076;
update skills set name = 'Unknown' where skill_id = 10077;
update skills set name = 'Unknown' where skill_id = 10078;
update skills set name = 'Unknown' where skill_id = 10079;
update skills set name = 'Unknown' where skill_id = 10080;

-- update board_auction house_name and location fields
update board_auction ba set 
ba.house_name = (select h.house_name from house h where h.house_id = ba.house_id), 
ba.location = (select h.location from house h where h.house_id = ba.house_id);

-- blank out mobgroup note (maybe fill these in later)
update mobgroup set note = '';
