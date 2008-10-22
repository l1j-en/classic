-- update 3

-- fix wis pot name
update etcitem set name = 'Potion of Wisdom' where item_id = 40016;

-- fix maple wand name
update etcitem set name = 'Maple Wand' where item_id = 40008;


-- update 4

-- correct spelling of "paralyze"
update etcitem set name = 'Spellbook(Paralyze)' where item_id = 40178;
update etcitem set name = 'Scroll of Magic: Paralyze' where item_id = 40891;

-- correct spelling of immune to harm
update etcitem set name = 'Spellbook(ImmuneToHarm)' where item_id = 40213;

-- rename triple shot spirit crystal
update etcitem set name = 'Spirit Crystal(TripleShot)' where item_id = 40240;

-- rename Teleport Scroll to Scroll of Teleportation
update etcitem set name = 'Scroll of Teleportation' where item_id = 40100;



-- update 8

-- correct whetstone name
update etcitem set name = 'Whetstone' where item_id = 40317;

-- correct name of stone of alchemy
update etcitem set name = 'Stone of Alchemy' where item_id = 40414;



-- update 11

-- correct name of Scroll of Curse Removal
update etcitem set name = 'Scroll of Curse Removal' where item_id = 40119;



-- update 12

-- fix name of sb:meditate (was sb:ej)
update etcitem set name_id = '$1861' where item_id = 40177;

-- fix name of sb:c-m (was sb:meditate)
update etcitem set name_id = '$1860' where item_id = 40176;

-- fix name of sb:ej (was sb:c-m)
update etcitem set name_id = '$1586' where item_id = 40175;

-- fix name for Piece of Large Cave Scroll (was "Oum Dungeon Scroll Pieces")
update etcitem set name = 'Piece of Large Cave Scroll' where item_id = 40429;

-- fix name for Diad Scroll Piece (was "Oum Dungeon Scroll Pieces")
update etcitem set name = 'Diad Scroll Piece' where item_id = 40432;

-- fix name for Scroll of Teleportation - Diad Fortress (was "Scroll of Return: Resistance Village")
update etcitem set name = 'Scroll of Teleportation - Diad Fortress' where item_id = 40084;

-- fix name id for Scroll of Teleportation - Resistance Village (was "Scroll of Teleportation")
update etcitem set name_id = '$230 - Resistance Village' where item_id = 40853;



-- update 13

-- fix abyss lake scroll name_id
update etcitem set name_id = '$230 - Abyss Lake' where item_id = 40855;

-- fix name for Scroll of Teleport: Lastabad 1f
update etcitem set name = 'Scroll of Teleport: Lastabad 1f' where item_id = 40852;

-- fix name for Dark Wing
update etcitem set name = 'Dark Wing' where item_id = 40720;

-- fix name for Crystal Ball of Necromancer (was Crystal Orb)
update etcitem set name = 'Crystal Ball of Necromancer' where item_id = 40617;

-- fix name for Scroll of Return - Pledge House (was Scroll of Return: Heine)
update etcitem set name = 'Scroll of Return - Pledge House' where item_id = 40124;

-- fix name for Fruit of Evolution (was Evolution Fruit)
update etcitem set name = 'Fruit of Evolution' where item_id = 40070;

-- fix name for Calling Flute (was nothing)
update etcitem set name = 'Calling Flute' where item_id = 41160;

-- fix name of Spirit Crystal(WaterLife) (was Spirit Crystal(NaturesBlessing))
update etcitem set name = 'Spirit Crystal(WaterLife)' where item_id = 40253;

-- fix name of Spirit Crystal(NaturesBlessing) (was Spirit Crystal(NaturesMiracle))
update etcitem set name = 'Spirit Crystal(NaturesBlessing)' where item_id = 40255;



-- update 14

-- correct name for Stationary (was nothing)
update etcitem set name = 'Stationary' where item_id = 49017;

-- correct name for Blood Pledge Letter (was nothing)
update etcitem set name = 'Blood Pledge Letter' where item_id = 49018;

-- correct name for Blood Pledge Letter (was nothing)
update etcitem set name = 'Blood Pledge Letter' where item_id = 49019;

-- correct name for Cristmas Card (was nothing)
update etcitem set name = 'Cristmas Card' where item_id = 49020;

-- correct name for Cristmas Card (was nothing)
update etcitem set name = 'Cristmas Card' where item_id = 49021;

-- correct name for Valentine\'s Day Card (was nothing)
update etcitem set name = 'Valentine\'s Day Card' where item_id = 49022;

-- correct name for Valentine\'s Day Card (was nothing)
update etcitem set name = 'Valentine\'s Day Card' where item_id = 49023;

-- correct name for White Day Card (was nothing)
update etcitem set name = 'White Day Card' where item_id = 49024;

-- correct name for White Day Card (was nothing)
update etcitem set name = 'White Day Card' where item_id = 49025;



-- update 16

-- correct name of Large Cave Crystal (was Oum Dungeon Crystal)
update etcitem set name = 'Large Cave Crystal' where item_id = 40430;

-- correct name of Spirit Crystal(WindShackle) (was Spirit Crystal(WindCircle))
update etcitem set name = 'Spirit Crystal(WindShackle)' where item_id = 40264;

-- correct name of Potion of Cure Poison (was Cure Poison Potion)
update etcitem set name = 'Potion of Cure Poison' where item_id = 40017;



-- update 17

-- correct name of Totem of Rova (was Totem of Neruga)
update etcitem set name = 'Totem of Rova' where item_id = 40132;

-- correct name of Ivory Tower Scroll of Identify (was Scroll of Identify)
update etcitem set name = 'Tower Scroll of Identify' where item_id = 40098;



-- update 19

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

-- reduce wand weight (7000 -> 70)
update etcitem set weight = 70 where item_id in (40006, 40007, 40008, 40009);

-- reduce gem gamble bag weight (10000 -> 1000)
update etcitem set weight = 1000 where item_id in (49005, 49006, 49007, 49008, 49009, 49010, 49011, 49012);


-- update 20

-- correct name of Fragment of Spirit (was Elven Bone Pieces)
update etcitem set name = 'Fragment of Spirit' where item_id = 40471;

-- correct name of Ivory Tower Scroll of Curse Removal (was Scroll of Curse Remove)
update etcitem set name = 'Ivory Tower Scroll of Curse Removal' where item_id = 40097;



-- update 22

-- fix all misnamed etcitems
update etcitem set name = 'Magic Lantern' where item_id = 40004;
update etcitem set name = 'Wand of Blink' where item_id = 40009;
update etcitem set name = 'Potion of Mana' where item_id = 40015;
update etcitem set name = 'Cure Poison Potion' where item_id = 40017;
update etcitem set name = 'Blinding Potion' where item_id = 40025;
update etcitem set name = 'Ivory Tower Healing Potion' where item_id = 40029;
update etcitem set name = 'Ivory Tower Haste Potion' where item_id = 40030;
update etcitem set name = 'Scale of Mermaid' where item_id = 40041;
update etcitem set name = 'Potion of Mental Acuity' where item_id = 40042;
update etcitem set name = 'Highest Quality Diamond' where item_id = 40052;
update etcitem set name = 'Highest Quality Ruby' where item_id = 40053;
update etcitem set name = 'Highest Quality Sapphire' where item_id = 40054;
update etcitem set name = 'Highest Quality Emerald' where item_id = 40055;
update etcitem set name = 'Brown Piece of Bread' where item_id = 40058;
update etcitem set name = 'Valentines Day chocolate' where item_id = 40063;
update etcitem set name = 'Rice-cake' where item_id = 40066;
update etcitem set name = 'Mugwort rice-cake' where item_id = 40067;
update etcitem set name = 'Burnt Piece of Bread' where item_id = 40071;
update etcitem set name = 'Pizza' where item_id = 40072;
update etcitem set name_id = 'Easter Basket' where item_id = 40073;
update etcitem set name = 'Scroll of Enchant Armor' where item_id = 40074;
update etcitem set name = 'Ancients\' Alchemy Scroll' where item_id = 40077;
update etcitem set name = 'Ancients\' Magic Scroll' where item_id = 40078;
update etcitem set name = 'Scroll of Return - Gludin Town' where item_id = 40080;
update etcitem set name = 'Scroll of Escape to Giran' where item_id = 40081;
update etcitem set name = 'Scroll of Return - Singing Island' where item_id = 40082;
update etcitem set name = 'Scroll of Teleportation - Lastabad', name_id = '$230 - Lastabad' where item_id = 40083;
update etcitem set name = 'Scroll of Return - Talking Island' where item_id = 40085;
update etcitem set name = 'Scroll of Enchant Weapon' where item_id = 40087;
update etcitem set name = 'Ivory Tower Scroll of Return' where item_id = 40095;
update etcitem set name = 'Ivory Tower Scroll of Polymorph' where item_id = 40096;
update etcitem set name = 'Ivory Tower Scroll of Identify' where item_id = 40098;
update etcitem set name = 'Ivory Tower Teleport Scroll' where item_id = 40099;
update etcitem set name = 'Scroll of Return - Hidden Valley' where item_id = 40101;
update etcitem set name = 'Scroll of Return - Aden City' where item_id = 40102;
update etcitem set name = 'Scroll of Return - Ivory Tower Town' where item_id = 40103;
update etcitem set name = 'TOI Teleport Scroll, 11F' where item_id = 40104;
update etcitem set name = 'TOI Teleport Scroll, 21F' where item_id = 40105;
update etcitem set name = 'TOI Teleport Scroll, 31F' where item_id = 40106;
update etcitem set name = 'TOI Teleport Scroll, 41F' where item_id = 40107;
update etcitem set name = 'TOI Teleport Scroll, 51F' where item_id = 40108;
update etcitem set name = 'TOI Teleport Scroll, 61F' where item_id = 40109;
update etcitem set name = 'TOI Teleport Scroll, 71F' where item_id = 40110;
update etcitem set name = 'TOI Teleport Scroll, 81F' where item_id = 40111;
update etcitem set name = 'TOI Teleport Scroll, 91F' where item_id = 40112;
update etcitem set name = 'TOI Teleport Scroll, 100F' where item_id = 40113;
update etcitem set name = 'Scroll of Return - Elven Forest' where item_id = 40114;
update etcitem set name = 'Scroll of Return - Woodbec Village' where item_id = 40115;
update etcitem set name = 'Scroll of Return - Werldern Town' where item_id = 40116;
update etcitem set name = 'Scroll of Return - Silver Knight Town' where item_id = 40117;
update etcitem set name = 'Scroll of Return - Recluse Village' where item_id = 40118;
update etcitem set name = 'Scroll of Return - Resistance Village' where item_id = 40120;
update etcitem set name = 'Scroll of Teleportation - Diad Fortress', name_id = '$230 - Diad Fortress' where item_id = 40121;
update etcitem set name = 'Scroll of Return - Kent Village' where item_id = 40122;
update etcitem set name = 'Scroll of Return - Heine City' where item_id = 40123;
update etcitem set name = 'Scroll of Return - Orctown' where item_id = 40125;
update etcitem set name = 'Scroll of Enchant Armor Illusion' where item_id = 40127;
update etcitem set name = 'Scroll of Enchant Weapon Illusion' where item_id = 40128;
update etcitem set name = 'Gian\'s Scroll' where item_id = 40129;
update etcitem set name = 'Kalba\'s Scroll' where item_id = 40130;
update etcitem set name = 'Totem of Gandi' where item_id = 40131;
update etcitem set name = 'Totem of Neruga' where item_id = 40132;
update etcitem set name = 'Totem of Duda-Mara' where item_id = 40133;
update etcitem set name = 'Totem of Rova' where item_id = 40134;
update etcitem set name = 'Shot Firework' where item_id = 40136;
update etcitem set name = 'Shot Mega Bam Firework' where item_id = 40137;
update etcitem set name = 'High Quality Shot Mega Bam Firework' where item_id = 40138;
update etcitem set name = 'Deep Blue Level 2 Firework' where item_id = 40139;
update etcitem set name = 'Deep Blue Sparkler' where item_id = 40140;
update etcitem set name = 'Deep Blue Firework' where item_id = 40141;
update etcitem set name = 'Deep Blue Heart Firework' where item_id = 40142;
update etcitem set name = 'Red Level 2 Firework' where item_id = 40143;
update etcitem set name = 'Red Sparkler' where item_id = 40144;
update etcitem set name = 'Red Firework' where item_id = 40145;
update etcitem set name = 'Red Heart Firework' where item_id = 40146;
update etcitem set name = 'Blue Level 2 Circle Firework' where item_id = 40147;
update etcitem set name = 'Blue Level 2 Firework' where item_id = 40148;
update etcitem set name = 'Blue Snow Flower Firework' where item_id = 40149;
update etcitem set name = 'Blue Sparkler' where item_id = 40150;
update etcitem set name = 'Blue Circle Firework' where item_id = 40151;
update etcitem set name = 'Blue Firework' where item_id = 40152;
update etcitem set name = 'Blue Heart Firework' where item_id = 40153;
update etcitem set name = 'Christmas Firecracker' where item_id = 40154;
update etcitem set name = 'Yellow Level 2 Circle Firework' where item_id = 40155;
update etcitem set name = 'Yellow Level 2 Firework' where item_id = 40156;
update etcitem set name = 'Yellow Snow Flower Firework' where item_id = 40157;
update etcitem set name = 'Yellow Sparkler' where item_id = 40158;
update etcitem set name = 'Yellow Circle Firework' where item_id = 40159;
update etcitem set name = 'Yellow Firework' where item_id = 40160;
update etcitem set name = 'Yellow Heart Firework' where item_id = 40161;
update etcitem set name = 'Old Leather Pouch' where item_id = 40167;
update etcitem set name = 'Old Silk Pouch' where item_id = 40168;
update etcitem set name = 'Sealed TOI Teleport Charm, 11F' where item_id = 40280;
update etcitem set name = 'Sealed TOI Teleport Charm, 21F' where item_id = 40281;
update etcitem set name = 'Sealed TOI Teleport Charm, 31F' where item_id = 40282;
update etcitem set name = 'Sealed TOI Teleport Charm, 41F' where item_id = 40283;
update etcitem set name = 'Sealed TOI Teleport Charm, 51F' where item_id = 40284;
update etcitem set name = 'Sealed TOI Teleport Charm, 61F' where item_id = 40285;
update etcitem set name = 'Sealed TOI Teleport Charm, 71F' where item_id = 40286;
update etcitem set name = 'Sealed TOI Teleport Charm, 81F' where item_id = 40287;
update etcitem set name = 'Sealed TOI Teleport Charm, 91F' where item_id = 40288;
update etcitem set name = 'TOI Teleport Charm, 11F' where item_id = 40289;
update etcitem set name = 'TOI Teleport Charm, 21F' where item_id = 40290;
update etcitem set name = 'TOI Teleport Charm, 31F' where item_id = 40291;
update etcitem set name = 'TOI Teleport Charm, 41F' where item_id = 40292;
update etcitem set name = 'TOI Teleport Charm, 51F' where item_id = 40293;
update etcitem set name = 'TOI Teleport Charm, 61F' where item_id = 40294;
update etcitem set name = 'TOI Teleport Charm, 71F' where item_id = 40295;
update etcitem set name = 'TOI Teleport Charm, 81F' where item_id = 40296;
update etcitem set name = 'TOI Teleport Charm, 91F' where item_id = 40297;
update etcitem set name = 'Boat Ticket to Island' where item_id = 40298;
update etcitem set name = 'Ticket to Gludio Estate' where item_id = 40299;
update etcitem set name = 'Forgotten Island Boat Ticket' where item_id = 40300;
update etcitem set name = 'Heine Boat Ticket' where item_id = 40301;
update etcitem set name = 'Boat Ticket to Pirate\'s Island' where item_id = 40302;
update etcitem set name = 'Boat Ticket to Hidden Dock' where item_id = 40303;
update etcitem set name = 'Race Ticket' where item_id = 40309;
update etcitem set name = 'Stationary' where item_id = 40310;
update etcitem set name = 'Blood Pledge Letter' where item_id = 40311;
update etcitem set name = 'Inn Room Key' where item_id = 40312;
update etcitem set name = 'Pale Silver Key' where item_id = 40313;
update etcitem set name = 'Pet Collar' where item_id = 40314;
update etcitem set name = 'Pet Whistle' where item_id = 40315;
update etcitem set name = 'Pet Collar' where item_id = 40316;
update etcitem set name = 'Two-Sided Magic Dice' where item_id = 40325;
update etcitem set name = 'Three-Sided Magic Dice', name_id = '$2720' where item_id = 40326;
update etcitem set name = 'Four-Sided Magic Dice' where item_id = 40327;
update etcitem set name = 'Six-Sided Magic Dice' where item_id = 40328;
update etcitem set name = 'Sword of Kent Soldier' where item_id = 40331;
update etcitem set name = 'Bow of Kent Archer' where item_id = 40332;
update etcitem set name = 'Staff of Kent Wizard' where item_id = 40333;
update etcitem set name = 'Edoryu of Kent Assassin' where item_id = 40334;
update etcitem set name = 'Axe of Kent Warrior' where item_id = 40334;
update etcitem set name = 'Kent Emblem Boots' where item_id = 40336;
update etcitem set name = 'Kent Emblem Armor' where item_id = 40337;
update etcitem set name = 'Kent Emblem Gloves' where item_id = 40338;
update etcitem set name = 'Kent Emblem Shield' where item_id = 40339;
update etcitem set name = 'Kent Emblem Helm' where item_id = 40340;
update etcitem set name = 'Crushed Claw of Antharas' where item_id = 40342;
update etcitem set name = 'Antharas Flesh' where item_id = 40345;
update etcitem set name = 'Crushed Claw of Valakas' where item_id = 40350;
update etcitem set name = 'Valakas Flesh' where item_id = 40353;
update etcitem set name = 'Crushed Claw of Fafurion' where item_id = 40358;
update etcitem set name = 'Fafurion Flesh' where item_id = 40361;
update etcitem set name = 'Crushed Claw of Lindvior' where item_id = 40366;
update etcitem set name = 'Map:All of Aden' where item_id = 40373;
update etcitem set name = 'Map:Talking Island' where item_id = 40374;
update etcitem set name = 'Map:Gludio' where item_id = 40375;
update etcitem set name = 'Map:Kent Castle' where item_id = 40376;
update etcitem set name = 'Map:Orcish Fortress' where item_id = 40377;
update etcitem set name = 'Map:Elven Forest' where item_id = 40378;
update etcitem set name = 'Map:Windawood' where item_id = 40379;
update etcitem set name = 'Map:Silver Knight Town' where item_id = 40380;
update etcitem set name = 'Map:Dragon Valley' where item_id = 40381;
update etcitem set name = 'Map:Giran' where item_id = 40382;
update etcitem set name = 'Map:Singing Island' where item_id = 40383;
update etcitem set name = 'Map:Hidden Valley' where item_id = 40384;
update etcitem set name = 'Map:Heine' where item_id = 40385;
update etcitem set name = 'Map:Lair of Valakas' where item_id = 40386;
update etcitem set name = 'Map:Oren' where item_id = 40387;
update etcitem set name = 'Red Dragon Scales' where item_id = 40393;
update etcitem set name = 'White Dragon Scales' where item_id = 40394;
update etcitem set name = 'Blue Dragon Scales' where item_id = 40395;
update etcitem set name = 'Green Dragon Scales' where item_id = 40396;
update etcitem set name = 'Cimaera Skin (Dragon)' where item_id = 40397;
update etcitem set name = 'Cimaera Skin (Goat)' where item_id = 40398;
update etcitem set name = 'Cimaera Skin (Lion)' where item_id = 40399;
update etcitem set name = 'Cimaera Skin (Snake)' where item_id = 40400;
update etcitem set name = 'Bone Piece' where item_id = 40407;
update etcitem set name = 'Heart of Firebird' where item_id = 40408;
update etcitem set name = 'Bark of Black Ent' where item_id = 40410;
update etcitem set name = 'Fruit of Black Ent' where item_id = 40411;
update etcitem set name = 'Twig of Black Ent' where item_id = 40412;
update etcitem set name = 'Alchemist\'s Stone' where item_id = 40414;
update etcitem set name = 'Relic Pouch' where item_id = 40415;
update etcitem set name = 'Special Spirit Crystal' where item_id = 40417;
update etcitem set name = 'Tarak\'s Valuables' where item_id = 40418;
update etcitem set name = 'Web of Muryan' where item_id = 40419;
update etcitem set name = 'Ancients\' Book of Magic, Volume 1' where item_id = 40420;
update etcitem set name = 'Ancients\' Book of Magic, Volume 2' where item_id = 40421;
update etcitem set name = 'Ancients\' Book of Magic, Volume 3' where item_id = 40422;
update etcitem set name = 'Ancients\' Book of Magic, Volume 4' where item_id = 40423;
update etcitem set name = 'Wolf Pelt' where item_id = 40424;
update etcitem set name = 'Dark Elven Pouch' where item_id = 40427;
update etcitem set name = 'Tear of Moonlight' where item_id = 40428;
update etcitem set name = 'Dillo Claw' where item_id = 40433;
update etcitem set name = 'Tail of Dillo' where item_id = 40434;
update etcitem set name = 'Bud of Deep Flower' where item_id = 40435;
update etcitem set name = 'Root of Deep Flower' where item_id = 40436;
update etcitem set name = 'Deep Flower Twig' where item_id = 40437;
update etcitem set name = 'Bat Fang' where item_id = 40438;
update etcitem set name = 'Rough Platinum Piece' where item_id = 40441;
update etcitem set name = 'Black Lump of Pure Mithral' where item_id = 40443;
update etcitem set name = 'Black Lump of Rough Mihral' where item_id = 40444;
update etcitem set name = 'Ring of Black Wizard' where item_id = 40446;
update etcitem set name = 'Leather of Black Tiger' where item_id = 40447;
update etcitem set name = 'Claw of Black Tiger' where item_id = 40448;
update etcitem set name = 'Fang of Black Tiger' where item_id = 40449;
update etcitem set name = 'Twig of Black Ent' where item_id = 40450;
update etcitem set name = 'Black Tiger Heart' where item_id = 40451;
update etcitem set name = 'Beast Tamer Ring' where item_id = 40454;
update etcitem set name = 'Scorpion Shell' where item_id = 40459;
update etcitem set name = 'Devil\'s Black Shackles' where item_id = 40461;
update etcitem set name = 'Devil\'s Red Shackles' where item_id = 40462;
update etcitem set name = 'Devil\'s Blue Shackles' where item_id = 40463;
update etcitem set name = 'Devil\'s White Shackles' where item_id = 40464;
update etcitem set name = 'Elementalist Ring' where item_id = 40465;
update etcitem set name_id = 'Lump of Silver' where item_id = 40467;
update etcitem set name = 'Rough Silver Piece' where item_id = 40468;
update etcitem set name = 'Piece of Soul' where item_id = 40470;
update etcitem set name = 'Cerberus Fur' where item_id = 40472;
update etcitem set name = 'Tarak\'s Sickle' where item_id = 40473;
update etcitem set name = 'Corruption\'s Poison' where item_id = 40474;
update etcitem set name = 'Tarak\'s Head' where item_id = 40475;
update etcitem set name = 'Corruption\'s Hand' where item_id = 40476;
update etcitem set name = 'Tarak\'s Devil Book, Volume 1' where item_id = 40477;
update etcitem set name = 'Tarak\'s Devil Book, Volume 2' where item_id = 40478;
update etcitem set name = 'Tarak\'s Devil Book, Volume 3' where item_id = 40479;
update etcitem set name = 'Tarak\'s Devil Book, Volume 4' where item_id = 40480;
update etcitem set name = 'Corruption\'s Tooth' where item_id = 40481;
update etcitem set name = 'Corruption\'s Tongue' where item_id = 40482;
update etcitem set name = 'Volcanic Ash' where item_id = 40486;
update etcitem set name = 'Gold Plate' where item_id = 40487;
update etcitem set name = 'Rough Gold Piece' where item_id = 40489;
update etcitem set name = 'Black Spirit Stone' where item_id = 40490;
update etcitem set name = 'Wind Tear' where item_id = 40498;
update etcitem set name = 'Arachne\'s Web' where item_id = 40503;
update etcitem set name = 'Bark of Contaminated Ent' where item_id = 40510;
update etcitem set name = 'Fruit of Contaminated Ent' where item_id = 40511;
update etcitem set name = 'Root of Contaminated Ent' where item_id = 40512;
update etcitem set name = 'Tear of Spirit' where item_id = 40514;
update etcitem set name = 'Large Green Crystal' where item_id = 40516;
update etcitem set name = 'Large Red Crystal' where item_id = 40517;
update etcitem set name = 'Large Blue Crystal' where item_id = 40518;
update etcitem set name = 'Fairydust' where item_id = 40519;
update etcitem set name = 'Thin Plate' where item_id = 40526;
update etcitem set name = 'Pickaxe' where item_id = 40527;
update etcitem set name = 'Guardian\'s Bag' where item_id = 40528;
update etcitem set name = 'Key of Ancient Prince' where item_id = 40530;
update etcitem set name = 'Key of Ancient Knight' where item_id = 40531;
update etcitem set name = 'Key of Ancient Wizard' where item_id = 40532;
update etcitem set name = 'Body of Ancient Key' where item_id = 40533;
update etcitem set name = 'Head of Ancient Key' where item_id = 40534;
update etcitem set name = 'Key of Ancient Elf' where item_id = 40535;
update etcitem set name = 'Key to Ramia\'s Room' where item_id = 40543;
update etcitem set name = 'Ramia\'s Scale' where item_id = 40544;
update etcitem set name = 'Ronde\'s Pouch' where item_id = 40545;
update etcitem set name = 'Marshall\'s Reward' where item_id = 40546;
update etcitem set name = 'Apparition\'s Bag' where item_id = 40548;
update etcitem set name = 'Bludika\'s Pouch' where item_id = 40553;
update etcitem set name = 'Secret List' where item_id = 40554;
update etcitem set name = 'Hit List Bag' where item_id = 40556;
update etcitem set name = 'Hit List (Gludin)' where item_id = 40557;
update etcitem set name = 'Hit List (Giran)' where item_id = 40558;
update etcitem set name = 'Hit List (Aden City)' where item_id = 40559;
update etcitem set name = 'Hit List (Woodbec)' where item_id = 40560;
update etcitem set name = 'Hit List (Kent)' where item_id = 40561;
update etcitem set name = 'Hit List (Heine)' where item_id = 40562;
update etcitem set name = 'Hit List (Fire-Field Farmers Town)' where item_id = 40563;
update etcitem set name = 'Search Document' where item_id = 40565;
update etcitem set name = 'Mysterious Shell' where item_id = 40566;
update etcitem set name = 'Mysterious Bag' where item_id = 40568;
update etcitem set name = 'Aria\'s Reward' where item_id = 40570;
update etcitem set name = 'Assassin Master\'s Box' where item_id = 40571;
update etcitem set name = 'Assassin\'s Token' where item_id = 40572;
update etcitem set name = 'Letter of Soul' where item_id = 40573;
update etcitem set name = 'Letter of Soul' where item_id = 40574;
update etcitem set name = 'Letter of Soul' where item_id = 40575;
update etcitem set name = 'Crystal Piece of Soul' where item_id = 40576;
update etcitem set name = 'Crystal Piece of Soul' where item_id = 40577;
update etcitem set name = 'Crystal Piece of Soul' where item_id = 40578;
update etcitem set name = 'Bone of Undead' where item_id = 40579;
update etcitem set name = 'Bone Piece of Undead' where item_id = 40580;
update etcitem set name = 'Undead Key' where item_id = 40581;
update etcitem set name = 'Bag of Endia' where item_id = 40502;
update etcitem set name = 'Letter of Endia' where item_id = 40503;
update etcitem set name = 'Head of Yeti' where item_id = 40584;
update etcitem set name = 'Emblem Piece of the Royal Family' where item_id = 40586;
update etcitem set name = 'Emblem Piece of the Royal Family' where item_id = 40587;
update etcitem set name = 'Elven Treasure' where item_id = 40588;
update etcitem set name = 'Key of Fate' where item_id = 40589;
update etcitem set name = 'Cursed Elven Spellbook' where item_id = 40592;
update etcitem set name = 'Piece of Scout\'s Report' where item_id = 40593;
update etcitem set name = 'Zombie Key' where item_id = 40594;
update etcitem set name = 'Kan\'s Pouch' where item_id = 40598;
update etcitem set name = 'Turtle Dragon Shell' where item_id = 40601;
update etcitem set name = 'Potion of Revival' where item_id = 40607;
update etcitem set name = 'Black Knight\'s Pledge Document' where item_id = 40608;
update etcitem set name = 'Gandi Spellbook' where item_id = 40609;
update etcitem set name = 'Neruga Spellbook' where item_id = 40610;
update etcitem set name = 'Duda-Mara Spellbook' where item_id = 40611;
update etcitem set name = 'Atuba Spellbook' where item_id = 40612;
update etcitem set name = 'Black Key' where item_id = 40613;
update etcitem set name = 'Mineral Removal Document' where item_id = 40614;
update etcitem set name = 'Key to 2nd Floor of Temple of Shadows' where item_id = 40615;
update etcitem set name = 'Key to 3rd Floor of Temple of Shadows' where item_id = 40616;
update etcitem set name = 'East Jail Key' where item_id = 40619;
update etcitem set name = 'Second Labyrinth Key' where item_id = 40620;
update etcitem set name = 'Key of Drake' where item_id = 40621;
update etcitem set name = 'Drake\'s Claw' where item_id = 40622;
update etcitem set name = 'Diego\'s Old Diary' where item_id = 40630;
update etcitem set name = 'Money Pouch of Reona' where item_id = 40631;
update etcitem set name = 'Report of Lizardman' where item_id = 40633;
update etcitem set name = 'Treasure of Lizardman' where item_id = 40634;
update etcitem set name = 'Evidence of Dark Spirit Army' where item_id = 40635;
update etcitem set name = 'Unknown 40636', name_id = 'Unknown 40636' where item_id = 40636;
update etcitem set name = 'Letter of Marba' where item_id = 40637;
update etcitem set name = 'Evidence of Dark Power Army' where item_id = 40638;
update etcitem set name = 'Unknown 40639', name_id = 'Unknown 40639' where item_id = 40639;
update etcitem set name = 'Unknown 40640', name_id = 'Unknown 40640' where item_id = 40640;
update etcitem set name = 'Evidence of Arcane Army' where item_id = 40642;
update etcitem set name = 'Labyrinth Map' where item_id = 40644;
update etcitem set name = 'Basilisk\'s Horn' where item_id = 40646;
update etcitem set name = 'Piece of Treasure Map' where item_id = 40647;
update etcitem set name = 'Assassin\'s Rusted Sword' where item_id = 40648;
update etcitem set name = 'North-East Jail Key' where item_id = 40649;
update etcitem set name = 'North Jail Key' where item_id = 40650;
update etcitem set name = 'Burning Leather' where item_id = 40652;
update etcitem set name = 'Red Key' where item_id = 40653;
update etcitem set name = 'Third Labyrinth Key' where item_id = 40654;
update etcitem set name = 'Crystal Fang' where item_id = 40655;
update etcitem set name = 'Sword of Ordeal A' where item_id = 40656;
update etcitem set name = 'Sword of Ordeal B' where item_id = 40657;
update etcitem set name = 'Sword of Ordeal C' where item_id = 40658;
update etcitem set name = 'Sword of Ordeal D' where item_id = 40659;
update etcitem set name = 'Spellbook of Ordeal' where item_id = 40660;
update etcitem set name = 'Amulet of Aras' where item_id = 40664;
update etcitem set name = 'Letter of Aras' where item_id = 40665;
update etcitem set name = 'Unknown Heirloom' where item_id = 40666;
update etcitem set name = 'Evidence of Assassin Army' where item_id = 40667;
update etcitem set name = 'Unknown 40668', name_id = 'Unknown 40668' where item_id = 40668;
update etcitem set name = 'Rib of Yahee' where item_id = 40669;
update etcitem set name = 'Tail of Yahee' where item_id = 40670;
update etcitem set name = 'Wing of Yahee' where item_id = 40671;
update etcitem set name = 'Backbone of Yahee' where item_id = 40672;
update etcitem set name = 'Head of Yahee' where item_id = 40673;
update etcitem set name = 'Claw of Yahee' where item_id = 40674;
update etcitem set name = 'Mineral of Darkness' where item_id = 40675;
update etcitem set name = 'Breath of Darkness' where item_id = 40676;
update etcitem set name = 'Ingot of Darkness' where item_id = 40677;
update etcitem set name = 'Fragment of Soul Stone' where item_id = 40678;
update etcitem set name = 'Contaminated Armor' where item_id = 40679;
update etcitem set name = 'Contaminated Cloak' where item_id = 40680;
update etcitem set name = 'Contaminated Boots' where item_id = 40681;
update etcitem set name = 'Contaminated Gloves' where item_id = 40682;
update etcitem set name = 'Contaminated Helm' where item_id = 40683;
update etcitem set name = 'Contaminated Bow' where item_id = 40684;
update etcitem set name = 'Oum Fine Statue' where item_id = 40685;
update etcitem set name = 'Oum Completed Statue' where item_id = 40686;
update etcitem set name = 'Pouch of Oum' where item_id = 40687;
update etcitem set name = 'Oum Painted Statue' where item_id = 40688;
update etcitem set name = 'Oum Rough Statue' where item_id = 40689;
update etcitem set name = 'Oum Refined Statue' where item_id = 40690;
update etcitem set name = 'Oum Statue' where item_id = 40691;
update etcitem set name = 'Completed Treasure Map' where item_id = 40692;
update etcitem set name = 'Armor of Expedition Member' where item_id = 40693;
update etcitem set name = 'Cloak of Expedition Member' where item_id = 40694;
update etcitem set name = 'Boots of Expedition Member' where item_id = 40695;
update etcitem set name = 'Gloves of Expedition Member', name_id = '$3992' where item_id = 40696;
update etcitem set name = 'Relic of Expedition Member', name_id = '$3978' where item_id = 40697;
update etcitem set name = 'Helm of Expedition Member' where item_id = 40698;
update etcitem set name = 'Bow of Expedition Member' where item_id = 40699;
update etcitem set name = 'Silver Flute' where item_id = 40700;
update etcitem set name = 'Small Treasure Map' where item_id = 40701;
update etcitem set name = 'Small Pouch' where item_id = 40702;
update etcitem set name = 'Book of Mental Control' where item_id = 40703;
update etcitem set name = 'Tailbone of Death' where item_id = 40704;
update etcitem set name = 'Hammer of Death' where item_id = 40706;
update etcitem set name = 'Knife of Death' where item_id = 40709;
update etcitem set name = 'Friend\'s Bag' where item_id = 40710;
update etcitem set name = 'Amulet of Cadmus' where item_id = 40711;
update etcitem set name = 'High Quality Pouch of Karif' where item_id = 40712;
update etcitem set name = 'Karif Pouch' where item_id = 40713;
update etcitem set name = 'Skin of Blue Lizard' where item_id = 40714;
update etcitem set name = 'Gift Bag from Pierce' where item_id = 40715;
update etcitem set name = 'Grandfather\'s Treasure' where item_id = 40716;
update etcitem set name = 'Crumpled Up Breaking-Up Letter' where item_id = 40717;
update etcitem set name = 'Fragment of Blood Stone' where item_id = 40718;
update etcitem set name = 'Black-Light Wing' where item_id = 40719;
update etcitem set name = 'Giant Pumpkin Seed' where item_id = 40720;
update etcitem set name = 'Red Sock' where item_id = 40728;
update etcitem set name = 'Golden Socks' where item_id = 40729;
update etcitem set name = 'Valentines Day Card' where item_id = 40731;
update etcitem set name = 'White Day Card' where item_id = 40732;
update etcitem set name = 'Coin of Reputation' where item_id = 40733;
update etcitem set name = 'Coin of Trust' where item_id = 40734;
update etcitem set name = 'Coin of Bravery' where item_id = 40735;
update etcitem set name = 'Coin of Wisdom' where item_id = 40736;
update etcitem set name = 'Oriharukon-Plated Bone Arrow' where item_id = 40741;
update etcitem set name = 'Ancient Arrow' where item_id = 40742;
update etcitem set name = 'Black Lump of Pure Mithral Arrow' where item_id = 40747;
update etcitem set name = 'Fang of Hunting Dog' where item_id = 40749;
update etcitem set name = 'Fang of Destruction' where item_id = 40750;
update etcitem set name = 'Fang of Fighting Dog' where item_id = 40751;
update etcitem set name = 'Fang of Gold' where item_id = 40752;
update etcitem set name = 'Unknown Fang 1', name_id = 'Unknown Fang 1' where item_id = 40753;
update etcitem set name = 'Unknown Fang 2', name_id = 'Unknown Fang 2' where item_id = 40754;
update etcitem set name = 'Unknown Fang 3', name_id = 'Unknown Fang 3' where item_id = 40755;
update etcitem set name = 'Fang of Demon' where item_id = 40756;
update etcitem set name = 'Fang of Steel' where item_id = 40757;
update etcitem set name = 'Fang of Victory' where item_id = 40758;
update etcitem set name = 'Unknown Pet Armor 1', name_id = 'Unknown Pet Armor 1' where item_id = 40759;
update etcitem set name = 'Unknown Pet Armor 2', name_id = 'Unknown Pet Armor 2' where item_id = 40760;
update etcitem set name = 'Leather Pet Armor' where item_id = 40761;
update etcitem set name = 'Skeleton Pet Armor' where item_id = 40762;
update etcitem set name = 'Steel Pet Armor' where item_id = 40763;
update etcitem set name = 'Mithral Pet Armor' where item_id = 40764;
update etcitem set name = 'Cloth Pet Armor' where item_id = 40765;
update etcitem set name = 'Chain Pet Armor' where item_id = 40766;
update etcitem set name = 'Lump of Steel' where item_id = 40779;
update etcitem set name = 'Head of Death' where item_id = 40780;
update etcitem set name = 'Head of Death' where item_id = 40781;
update etcitem set name = 'Key to 3rd Floor of Temple of Shadows' where item_id = 40782;
update etcitem set name = 'Key to 3rd Floor of Temple of Shadows' where item_id = 40783;
update etcitem set name = 'Scroll of Teleportation - Giant Bridge', name_id = '$230 - Giant Bridge' where item_id = 40801;
update etcitem set name = 'Scroll of Teleportation - Aden Castle', name_id = '$230 - Aden Castle' where item_id = 40802;
update etcitem set name = 'Scroll of Teleportation - Mirror Forest', name_id = '$230 - Mirror Forest' where item_id = 40803;
update etcitem set name = 'Scroll of Teleportation - Valakas', name_id = '$230 - Valakas' where item_id = 40804;
update etcitem set name = 'Scroll of Teleportation - Fafurion', name_id = '$230 - Fafurion' where item_id = 40805;
update etcitem set name = 'Scroll of Teleportation - Lindvior', name_id = '$230 - Lindvior' where item_id = 40806;
update etcitem set name = 'Scroll of Teleportation - Heine Dungeon 3F', name_id = '$230 - Heine Dungeon 3F' where item_id = 40807;
update etcitem set name = 'Scroll of Teleportation - Heine Dungeon 4F', name_id = '$230 - Heine Dungeon 4F' where item_id = 40808;
update etcitem set name = 'Scroll of Teleportation - Fire Valley Bridge', name_id = '$230 - Fire Valley Bridge' where item_id = 40809;
update etcitem set name = 'Scroll of Teleportation - Dragon Valley', name_id = '$230 - Dragon Valley' where item_id = 40810;
update etcitem set name = 'Scroll of Teleportation - Oasis', name_id = '$230 - Oasis' where item_id = 40811;
update etcitem set name = 'Scroll of Teleportation - Oren Wasteland', name_id = '$230 - Oren Wasteland' where item_id = 40812;
update etcitem set name = 'Scroll of Teleportation - Wasteland', name_id = '$230 - Wasteland' where item_id = 40813;
update etcitem set name = 'Scroll of Teleportation - Small Wasteland', name_id = '$230 - Small Wasteland' where item_id = 40814;
update etcitem set name = 'Scroll of Teleportation - Woodbec Castle', name_id = '$230 - Woodbec Castle' where item_id = 40815;
update etcitem set name = 'Scroll of Teleportation - Beleth', name_id = '$230 - Beleth' where item_id = 40816;
update etcitem set name = 'Scroll of Teleportation - Ant Cave 1F', name_id = '$230 - Ant Cave 1F' where item_id = 40817;
update etcitem set name = 'Scroll of Teleportation - Ant Cave 2F', name_id = '$230 - Ant Cave 2F' where item_id = 40818;
update etcitem set name = 'Scroll of Teleportation - Ant Cave 3F', name_id = '$230 - Ant Cave 3F' where item_id = 40819;
update etcitem set name = 'Scroll of Teleportation - Ivory Tower 5F', name_id = '$230 - Ivory Tower 5F' where item_id = 40820;
update etcitem set name = 'Scroll of Teleportation - Ivory Tower 6F', name_id = '$230 - Ivory Tower 6F' where item_id = 40821;
update etcitem set name = 'Scroll of Teleportation - Ivory Tower 7F', name_id = '$230 - Ivory Tower 7F' where item_id = 40822;
update etcitem set name = 'Scroll of Teleportation - Ivory Tower 8F', name_id = '$230 - Ivory Tower 8F' where item_id = 40823;
update etcitem set name = 'Scroll of Teleportation - SKT Caves 2F', name_id = '$230 - SKT Caves 2F' where item_id = 40824;
update etcitem set name = 'Scroll of Teleportation - SKT Caves 3F', name_id = '$230 - SKT Caves 3F' where item_id = 40825;
update etcitem set name = 'Scroll of Teleportation - SKT Caves 4F', name_id = '$230 - SKT Caves 4F' where item_id = 40826;
update etcitem set name = 'Scroll of Teleportation - Giran Dungeon 2F', name_id = '$230 - Giran Dungeon 2F' where item_id = 40827;
update etcitem set name = 'Scroll of Teleportation - Giran Dungeon 3F', name_id = '$230 - Giran Dungeon 3F' where item_id = 40828;
update etcitem set name = 'Scroll of Teleportation - Giran Dungeon 4F', name_id = '$230 - Giran Dungeon 4F' where item_id = 40829;
update etcitem set name = 'Scroll of Teleportation - MLC 3F', name_id = '$230 - MLC 3F' where item_id = 40830;
update etcitem set name = 'Scroll of Teleportation - MLC 4F', name_id = '$230 - MLC 4F' where item_id = 40831;
update etcitem set name = 'Scroll of Teleportation - MLC 5F', name_id = '$230 - MLC 5F' where item_id = 40832;
update etcitem set name = 'Scroll of Teleportation - MLC 6F', name_id = '$230 - MLC 6F' where item_id = 40833;
update etcitem set name = 'Scroll of Teleportation - MLC 7F', name_id = '$230 - MLC 7F' where item_id = 40834;
update etcitem set name = 'Scroll of Teleportation - DVC 1F', name_id = '$230 - DVC 1F' where item_id = 40835;
update etcitem set name = 'Scroll of Teleportation - DVC 2F', name_id = '$230 - DVC 2F' where item_id = 40836;
update etcitem set name = 'Scroll of Teleportation - DVC 3F', name_id = '$230 - DVC 3F' where item_id = 40837;
update etcitem set name = 'Scroll of Teleportation - DVC 4F', name_id = '$230 - DVC 4F' where item_id = 40838;
update etcitem set name = 'Scroll of Teleportation - DVC 5F', name_id = '$230 - DVC 5F' where item_id = 40839;
update etcitem set name = 'Scroll of Teleportation - DVC 6F', name_id = '$230 - DVC 6F' where item_id = 40840;
update etcitem set name = 'Scroll of Teleportation - Antharas', name_id = '$230 - Antharas' where item_id = 40841;
update etcitem set name = 'Scroll of Teleportation - Windawood Castle', name_id = '$230 - Windawood Castle' where item_id = 40842;
update etcitem set name = 'Scroll of Teleportation - Desert', name_id = '$230 - Desert' where item_id = 40843;
update etcitem set name = 'Scroll of Teleportation - Elder Room', name_id = '$230 - Elder Room' where item_id = 40844;
update etcitem set name = 'Scroll of Teleportation - Silent Cavern', name_id = '$230 - Silent Cavern' where item_id = 40845;
update etcitem set name = 'Scroll of Teleportation - Diad 1F', name_id = '$230 - Diad 1F' where item_id = 40846;
update etcitem set name = 'Scroll of Teleportation - Diad 2F', name_id = '$230 - Diad 2F' where item_id = 40847;
update etcitem set name = 'Scroll of Teleportation - Diad 3F', name_id = '$230 - Diad 3F' where item_id = 40848;
update etcitem set name = 'Scroll of Teleportation - Trails 1F', name_id = '$230 - Trails 1F' where item_id = 40849;
update etcitem set name = 'Scroll of Teleportation - Trails 2F', name_id = '$230 - Trails 2F' where item_id = 40850;
update etcitem set name = 'Scroll of Teleportation - Trails 4F', name_id = '$230 - Trails 4F' where item_id = 40851;
update etcitem set name = 'Scroll of Teleportation - Lastabad 1F', name_id = '$230 - Lastabad 1F' where item_id = 40852;
update etcitem set name = 'Scroll of Teleportation - Resistance Village', name_id = '$230 - Resistance Village' where item_id = 40853;
update etcitem set name = 'Scroll of Teleportation - SoE 1F', name_id = '$230 - SoE 1F' where item_id = 40854;
update etcitem set name = 'Scroll of Teleportation - Abyss Lake', name_id = '$230 - Abyss Lake' where item_id = 40855;
update etcitem set name = 'Scroll of Teleportation - Pirate Island', name_id = '$230 - Pirate Island' where item_id = 40856;
update etcitem set name = 'Scroll of Teleportation - Diad Fortress', name_id = '$230 - Diad Fortress' where item_id = 40857;
update etcitem set name = 'Liquor', name_id = 'Liquor' where item_id = 40858;
update etcitem set name = 'Spell Scroll (Lesser Heal)' where item_id = 40859;
update etcitem set name = 'Spell Scroll (Light)' where item_id = 40860;
update etcitem set name = 'Spell Scroll (Shield)' where item_id = 40861;
update etcitem set name = 'Spell Scroll (Energy Bolt)' where item_id = 40862;
update etcitem set name = 'Spell Scroll (Teleport)' where item_id = 40863;
update etcitem set name = 'Spell Scroll (Ice Dagger)' where item_id = 40864;
update etcitem set name = 'Spell Scroll (Wind Shuriken)' where item_id = 40865;
update etcitem set name = 'Spell Scroll (Holy Weapon)' where item_id = 40866;
update etcitem set name = 'Spell Scroll (Cure Poison)' where item_id = 40867;
update etcitem set name = 'Spell Scroll (Chill Touch)' where item_id = 40868;
update etcitem set name = 'Spell Scroll (Curse: Poison)' where item_id = 40869;
update etcitem set name = 'Spell Scroll (Enchant Weapon)' where item_id = 40870;
update etcitem set name = 'Spell Scroll (Detection)' where item_id = 40871;
update etcitem set name = 'Spell Scroll (Decrease Weight)' where item_id = 40872;
update etcitem set name = 'Spell Scroll (Fire Arrow)' where item_id = 40873;
update etcitem set name = 'Spell Scroll (Stalac)' where item_id = 40874;
update etcitem set name = 'Spell Scroll (Lightning)' where item_id = 40875;
update etcitem set name = 'Spell Scroll (Turn Undead)' where item_id = 40876;
update etcitem set name = 'Spell Scroll (Heal)' where item_id = 40877;
update etcitem set name = 'Spell Scroll (Curse: Blind)' where item_id = 40878;
update etcitem set name = 'Spell Scroll (Blessed Armor)' where item_id = 40879;
update etcitem set name = 'Spell Scroll (Frozen Cloud)' where item_id = 40880;
update etcitem set name = 'Spell Scroll (Reveal Weakness)' where item_id = 40881;
update etcitem set name = 'Spell Scroll (Fireball)' where item_id = 40883;
update etcitem set name = 'Spell Scroll (Enchant Dexterity)' where item_id = 40884;
update etcitem set name = 'Spell Scroll (Weapon Break)' where item_id = 40885;
update etcitem set name = 'Spell Scroll (Vampiric Touch)' where item_id = 40886;
update etcitem set name = 'Spell Scroll (Slow)' where item_id = 40887;
update etcitem set name = 'Spell Scroll (Earth Jail)' where item_id = 40888;
update etcitem set name = 'Spell Scroll (Counter Magic)' where item_id = 40889;
update etcitem set name = 'Spell Scroll (Meditation)' where item_id = 40890;
update etcitem set name = 'Spell Scroll (Curse: Paralyze)' where item_id = 40891;
update etcitem set name = 'Spell Scroll (Call Lightning)' where item_id = 40892;
update etcitem set name = 'Spell Scroll (Greater Heal)' where item_id = 40893;
update etcitem set name = 'Spell Scroll (Tame Monster)' where item_id = 40894;
update etcitem set name = 'Spell Scroll (Remove Curse)' where item_id = 40895;
update etcitem set name = 'Spell Scroll (Cone of Cold)' where item_id = 40896;
update etcitem set name = 'Spell Scroll (Mana Drain)' where item_id = 40897;
update etcitem set name = 'Spell Scroll (Darkness)' where item_id = 40898;
update etcitem set name = 'Lump of Rough Iron' where item_id = 40899;
update etcitem set name = 'Wedding Ring (Silver)' where item_id = 40901;
update etcitem set name = 'Wedding Ring (Gold)' where item_id = 40902;
update etcitem set name = 'Wedding Ring (Sapphire)' where item_id = 40903;
update etcitem set name = 'Wedding Ring (Emerald)' where item_id = 40904;
update etcitem set name = 'Wedding Ring (Ruby)' where item_id = 40905;
update etcitem set name = 'Wedding Ring (Diamond)' where item_id = 40906;
update etcitem set name = 'Ring of Sema' where item_id = 40907;
update etcitem set name = 'Ring of Orim' where item_id = 40908;
update etcitem set name = 'Unknown 40909' where item_id = 40909;
update etcitem set name = 'Unknown 40910' where item_id = 40910;
update etcitem set name = 'Unknown 40911' where item_id = 40911;
update etcitem set name = 'Unknown 40912' where item_id = 40912;
update etcitem set name = 'Unknown 40913' where item_id = 40913;
update etcitem set name = 'Unknown 40914' where item_id = 40914;
update etcitem set name = 'Unknown 40915' where item_id = 40915;
update etcitem set name = 'Unknown 40916' where item_id = 40916;
update etcitem set name = 'Unknown 40917' where item_id = 40917;
update etcitem set name = 'Unknown 40918' where item_id = 40918;
update etcitem set name = 'Unknown 40919' where item_id = 40919;
update etcitem set name = 'Unknown 40920' where item_id = 40920;
update etcitem set name = 'Unknown 40921' where item_id = 40921;
update etcitem set name = 'Unknown 40922' where item_id = 40922;
update etcitem set name = 'Unknown 40923' where item_id = 40923;
update etcitem set name = 'Unknown 40924' where item_id = 40924;
update etcitem set name = 'Unknown 40925' where item_id = 40925;
update etcitem set name = 'Unknown 40926' where item_id = 40926;
update etcitem set name = 'Unknown 40927' where item_id = 40927;
update etcitem set name = 'Unknown 40928' where item_id = 40928;
update etcitem set name = 'Unknown 40929' where item_id = 40929;
update etcitem set name = 'Barbeque' where item_id = 40930;
update etcitem set name = 'Unknown 40931' where item_id = 40931;
update etcitem set name = 'Unknown 40932' where item_id = 40932;
update etcitem set name = 'Unknown 40933' where item_id = 40933;
update etcitem set name = 'Unknown 40934' where item_id = 40934;
update etcitem set name = 'Unknown 40935' where item_id = 40935;
update etcitem set name = 'Unknown 40936' where item_id = 40936;
update etcitem set name = 'Unknown 40937' where item_id = 40937;
update etcitem set name = 'Unknown 40938' where item_id = 40938;
update etcitem set name = 'Unknown 40939' where item_id = 40939;
update etcitem set name = 'Unknown 40940' where item_id = 40940;
update etcitem set name = 'Unknown 40941' where item_id = 40941;
update etcitem set name = 'Unknown 40942' where item_id = 40942;
update etcitem set name = 'Unknown 40943' where item_id = 40943;
update etcitem set name = 'Unknown 40944' where item_id = 40944;
update etcitem set name = 'Unknown 40945' where item_id = 40945;
update etcitem set name = 'Unknown 40946' where item_id = 40946;
update etcitem set name = 'Unknown 40947' where item_id = 40947;
update etcitem set name = 'Unknown 40948' where item_id = 40948;
update etcitem set name = 'Unknown 40949' where item_id = 40949;
update etcitem set name = 'Unknown 40950' where item_id = 40950;
update etcitem set name = 'Unknown 40951' where item_id = 40951;
update etcitem set name = 'Unknown 40952' where item_id = 40952;
update etcitem set name = 'Unknown 40953' where item_id = 40953;
update etcitem set name = 'Unknown 40954' where item_id = 40954;
update etcitem set name = 'Unknown 40955' where item_id = 40955;
update etcitem set name = 'Unknown 40956' where item_id = 40956;
update etcitem set name = 'Unknown 40957' where item_id = 40957;
update etcitem set name = 'Unknown 40958' where item_id = 40958;
update etcitem set name = 'Seal of Arcane King' where item_id = 40959;
update etcitem set name = 'Seal of Dread Queen' where item_id = 40960;
update etcitem set name = 'Seal of Dread King' where item_id = 40961;
update etcitem set name = 'Seal of Assassin King' where item_id = 40962;
update etcitem set name = 'Black Magic Powder' where item_id = 40964;
update etcitem set name = 'Unknown 40965' where item_id = 40965;
update etcitem set name = 'Unknown 40966' where item_id = 40966;
update etcitem set name = 'Unknown 40967' where item_id = 40967;
update etcitem set name = 'Unknown 40968' where item_id = 40968;
update etcitem set name = 'Crystal of Dark Elf Soul' where item_id = 40969;
update etcitem set name = 'Tail of Angus' where item_id = 40970;
update etcitem set name = 'Tooth of Angus' where item_id = 40971;
update etcitem set name = 'Resiliant Muscles of Pasaj' where item_id = 40972;
update etcitem set name = 'Wings of Pasaj' where item_id = 40973;
update etcitem set name = 'Blood of Dego' where item_id = 40974;
update etcitem set name = 'Fin of Digo' where item_id = 40975;
update etcitem set name = 'Sand' where item_id = 40976;
update etcitem set name = 'Bloodied Sand' where item_id = 40977;
update etcitem set name = 'Tail of Sheba Human: Earth' where item_id = 40978;
update etcitem set name = 'Tail of Sheba Human: Water' where item_id = 40979;
update etcitem set name = 'Tail of Sheba Human: Fire' where item_id = 40980;
update etcitem set name = 'Tail of Sheba Human: Air' where item_id = 40981;
update etcitem set name = 'Leather of Sheba Human: Earth' where item_id = 40982;
update etcitem set name = 'Leather of Sheba Human: Water' where item_id = 40983;
update etcitem set name = 'Leather of Sheba Human: Fire' where item_id = 40984;
update etcitem set name = 'Leather of Sheba Human: Air' where item_id = 40985;
update etcitem set name = 'Fang of Sheba Human' where item_id = 40986;
update etcitem set name = 'Unknown 40987' where item_id = 40987;
update etcitem set name = 'Unknown 40988' where item_id = 40988;
update etcitem set name = 'Unknown 40989' where item_id = 40989;
update etcitem set name = 'Wings of Varlok' where item_id = 40990;
update etcitem set name = 'Two-Handed Sword of Varlok' where item_id = 40991;
update etcitem set name = 'Head of Varlok' where item_id = 40992;
update etcitem set name = 'Horns of Varlok' where item_id = 40993;
update etcitem set name = 'Cut of Varlok Meat' where item_id = 40994;
update etcitem set name = 'Claws of Varlok' where item_id = 40995;
update etcitem set name = 'Heart of Varlok' where item_id = 40996;
update etcitem set name = 'Fangs of Varlok' where item_id = 40997;
update etcitem set name = 'Lungs of Varlok' where item_id = 40998;
update etcitem set name = 'Dark Elven Soldier Badge' where item_id = 40999;
update etcitem set name = 'Dark Elven General Badge' where item_id = 41000;
update etcitem set name = 'Compensation' where item_id = 41001;
update etcitem set name = 'Mineral Pouch' where item_id = 41002;
update etcitem set name = 'Roy\'s Pouch' where item_id = 41003;
update etcitem set name = 'Rabla\'s Pouch' where item_id = 41004;
update etcitem set name = 'Contract of Resurrection and Eternal Life' where item_id = 41005;
update etcitem set name = 'Rabor\'s Pouch' where item_id = 41006;
update etcitem set name = 'Directive of Eris 1' where item_id = 41007;
update etcitem set name = 'Bag of Eris' where item_id = 41008;
update etcitem set name = 'Directive of Eris 2' where item_id = 41009;
update etcitem set name = 'Document Letter of Eris' where item_id = 41010;
update etcitem set name = 'Unknown 41011' where item_id = 41011;
update etcitem set name = 'Unknown 41012' where item_id = 41012;
update etcitem set name = 'Unknown 41013' where item_id = 41013;
update etcitem set name = 'Unknown 41014' where item_id = 41014;
update etcitem set name = 'Unknown 41015' where item_id = 41015;
update etcitem set name = 'Unknown 41016' where item_id = 41016;
update etcitem set name = 'Unknown 41017' where item_id = 41017;
update etcitem set name = 'Unknown 41018' where item_id = 41018;
update etcitem set name = 'Unknown 41019' where item_id = 41019;
update etcitem set name = 'Unknown 41020' where item_id = 41020;
update etcitem set name = 'Unknown 41021' where item_id = 41021;
update etcitem set name = 'Unknown 41022' where item_id = 41022;
update etcitem set name = 'Unknown 41023' where item_id = 41023;
update etcitem set name = 'Unknown 41024' where item_id = 41024;
update etcitem set name = 'Unknown 41025' where item_id = 41025;
update etcitem set name = 'Unknown 41026' where item_id = 41026;
update etcitem set name = 'Unknown 41027' where item_id = 41027;
update etcitem set name = 'Unknown 41028' where item_id = 41028;
update etcitem set name = 'Unknown 41029' where item_id = 41029;
update etcitem set name = 'Unknown 41030' where item_id = 41030;
update etcitem set name = 'Unknown 41031' where item_id = 41031;
update etcitem set name = 'Unknown 41032' where item_id = 41032;
update etcitem set name = 'Unknown 41033' where item_id = 41033;
update etcitem set name = 'Unknown 41034' where item_id = 41034;
update etcitem set name = 'Unknown 41035' where item_id = 41035;
update etcitem set name = 'Glue' where item_id = 41036;
update etcitem set name = 'Incomplete Logbook' where item_id = 41037;
update etcitem set name = 'Logbook Page 1' where item_id = 41038;
update etcitem set name = 'Logbook Page 2' where item_id = 41039;
update etcitem set name = 'Logbook Page 3' where item_id = 41040;
update etcitem set name = 'Logbook Page 4' where item_id = 41041;
update etcitem set name = 'Logbook Page 5' where item_id = 41042;
update etcitem set name = 'Logbook Page 6' where item_id = 41043;
update etcitem set name = 'Logbook Page 7' where item_id = 41044;
update etcitem set name = 'Logbook Page 8' where item_id = 41045;
update etcitem set name = 'Logbook Page 9' where item_id = 41046;
update etcitem set name = 'Logbook Page 10' where item_id = 41047;
update etcitem set name = 'Unknown 41048' where item_id = 41048;
update etcitem set name = 'Unknown 41049' where item_id = 41049;
update etcitem set name = 'Unknown 41050' where item_id = 41050;
update etcitem set name = 'Unknown 41051' where item_id = 41051;
update etcitem set name = 'Unknown 41052' where item_id = 41052;
update etcitem set name = 'Unknown 41053' where item_id = 41053;
update etcitem set name = 'Unknown 41054' where item_id = 41054;
update etcitem set name = 'Unknown 41055' where item_id = 41055;
update etcitem set name = 'Unknown 41056' where item_id = 41056;
update etcitem set name = 'Unknown 41057' where item_id = 41057;
update etcitem set name = 'Complete Logbook' where item_id = 41058;
update etcitem set name = 'Pouch of Voyager' where item_id = 41059;
update etcitem set name = 'Unknown 41060' where item_id = 41060;
update etcitem set name = 'Unknown 41061' where item_id = 41061;
update etcitem set name = 'Unknown 41062' where item_id = 41062;
update etcitem set name = 'Unknown 41063' where item_id = 41063;
update etcitem set name = 'Unknown 41064' where item_id = 41064;
update etcitem set name = 'Unknown 41065' where item_id = 41065;
update etcitem set name = 'Unknown 41067' where item_id = 41067;
update etcitem set name = 'Unknown 41068' where item_id = 41068;
update etcitem set name = 'Silver Tray' where item_id = 41071;
update etcitem set name = 'Silver Candle' where item_id = 41072;
update etcitem set name = 'Key of Bandit' where item_id = 41073;
update etcitem set name = 'Bandit Pouch' where item_id = 41074;
update etcitem set name = 'Orc Fang' where item_id = 41081;
update etcitem set name = 'Orc Fang Amulet' where item_id = 41082;
update etcitem set name = 'Enchanted Powder' where item_id = 41083;
update etcitem set name = 'Pure Powder' where item_id = 41084;
update etcitem set name = 'Totem of Neruga' where item_id = 41090;
update etcitem set name = 'Totem of Duda-Mara' where item_id = 41091;
update etcitem set name = 'Totem of Atuba' where item_id = 41092;
update etcitem set name = 'Unknown 41093' where item_id = 41093;
update etcitem set name = 'Unknown 41094' where item_id = 41094;
update etcitem set name = 'Unknown 41095' where item_id = 41095;
update etcitem set name = 'Unknown 41096' where item_id = 41096;
update etcitem set name = 'Unknown 41097' where item_id = 41097;
update etcitem set name = 'Unknown 41098' where item_id = 41098;
update etcitem set name = 'Unknown 41099' where item_id = 41099;
update etcitem set name = 'Unknown 41100' where item_id = 41100;
update etcitem set name = 'Unknown 41101' where item_id = 41101;
update etcitem set name = 'Unknown 41102' where item_id = 41102;
update etcitem set name = 'Unknown 41103' where item_id = 41103;
update etcitem set name = 'Unknown 41104' where item_id = 41104;
update etcitem set name = 'Unknown 41105' where item_id = 41105;
update etcitem set name = 'Unknown 41106' where item_id = 41106;
update etcitem set name = 'Unknown 41107' where item_id = 41107;
update etcitem set name = 'Unknown 41108' where item_id = 41108;
update etcitem set name = 'Unknown 41109' where item_id = 41109;
update etcitem set name = 'Unknown 41111' where item_id = 41111;
update etcitem set name = 'Unknown 41112' where item_id = 41112;
update etcitem set name = 'Unknown 41113' where item_id = 41113;
update etcitem set name = 'Unknown 41114' where item_id = 41114;
update etcitem set name = 'Unknown 41115' where item_id = 41115;
update etcitem set name = 'Unknown 41116' where item_id = 41116;
update etcitem set name = 'Unknown 41117' where item_id = 41117;
update etcitem set name = 'Unknown 41118' where item_id = 41118;
update etcitem set name = 'Unknown 41119' where item_id = 41119;
update etcitem set name = 'Unknown 41120' where item_id = 41120;
update etcitem set name = 'Unknown 41121' where item_id = 41121;
update etcitem set name = 'Unknown 41122' where item_id = 41122;
update etcitem set name = 'Unknown 41123' where item_id = 41123;
update etcitem set name = 'Unknown 41124' where item_id = 41124;
update etcitem set name = 'Unknown 41125' where item_id = 41125;
update etcitem set name = 'Unknown 41126' where item_id = 41126;
update etcitem set name = 'Unknown 41127' where item_id = 41127;
update etcitem set name = 'Unknown 41128' where item_id = 41128;
update etcitem set name = 'Unknown 41129' where item_id = 41129;
update etcitem set name = 'Unknown 41130' where item_id = 41130;
update etcitem set name = 'Unknown 41131' where item_id = 41131;
update etcitem set name = 'Unknown 41132' where item_id = 41132;
update etcitem set name = 'Unknown 41133' where item_id = 41133;
update etcitem set name = 'Unknown 41134' where item_id = 41134;
update etcitem set name = 'Unknown 41135' where item_id = 41135;
update etcitem set name = 'Unknown 41136' where item_id = 41136;
update etcitem set name = 'Unknown 41137' where item_id = 41137;
update etcitem set name = 'Unknown 41138' where item_id = 41138;
update etcitem set name = 'Unknown 41139' where item_id = 41139;
update etcitem set name = 'Unknown 41140' where item_id = 41140;
update etcitem set name = 'Unknown 41141' where item_id = 41141;
update etcitem set name = 'Unknown 41142' where item_id = 41142;
update etcitem set name = 'Unknown 41143' where item_id = 41143;
update etcitem set name = 'Unknown 41144' where item_id = 41144;
update etcitem set name = 'Unknown 41145' where item_id = 41145;
update etcitem set name = 'Unknown 41146' where item_id = 41146;
update etcitem set name = 'Scale of Darkness' where item_id = 41154;
update etcitem set name = 'Scale of Flames' where item_id = 41155;
update etcitem set name = 'Scale of Immortality' where item_id = 41156;
update etcitem set name = 'Scale of Hatred' where item_id = 41157;
update etcitem set name = 'Unknown 41158' where item_id = 41158;
update etcitem set name = 'Unknown 41159' where item_id = 41159;
update etcitem set name = 'Unknown 41161' where item_id = 41161;
update etcitem set name = 'Unknown 41162' where item_id = 41162;
update etcitem set name = 'Unknown 41163' where item_id = 41163;
update etcitem set name = 'Unknown 41164' where item_id = 41164;
update etcitem set name = 'Unknown 41165' where item_id = 41165;
update etcitem set name = 'Unknown 41166' where item_id = 41166;
update etcitem set name = 'Unknown 41167' where item_id = 41167;
update etcitem set name = 'Unknown 41168' where item_id = 41168;
update etcitem set name = 'Unknown 41169' where item_id = 41169;
update etcitem set name = 'Unknown 41170' where item_id = 41170;
update etcitem set name = 'Unknown 41171' where item_id = 41171;
update etcitem set name = 'Unknown 41172' where item_id = 41172;
update etcitem set name = 'Unknown 41173' where item_id = 41173;
update etcitem set name = 'Unknown 41174' where item_id = 41174;
update etcitem set name = 'Unknown 41175' where item_id = 41175;
update etcitem set name = 'Unknown 41176' where item_id = 41176;
update etcitem set name = 'Unknown 41177' where item_id = 41177;
update etcitem set name = 'Unknown 41178' where item_id = 41178;
update etcitem set name = 'Unknown 41179' where item_id = 41179;
update etcitem set name = 'Unknown 41180' where item_id = 41180;
update etcitem set name = 'Unknown 41181' where item_id = 41181;
update etcitem set name = 'Unknown 41182' where item_id = 41182;
update etcitem set name = 'Unknown 41183' where item_id = 41183;
update etcitem set name = 'Unknown 41184' where item_id = 41184;
update etcitem set name = 'Unknown 41185' where item_id = 41185;
update etcitem set name = 'Unknown 41186' where item_id = 41186;
update etcitem set name = 'Unknown 41187' where item_id = 41187;
update etcitem set name = 'Unknown 41188' where item_id = 41188;
update etcitem set name = 'Unknown 41189' where item_id = 41189;
update etcitem set name = 'Unknown 41190' where item_id = 41190;
update etcitem set name = 'Unknown 41191' where item_id = 41191;
update etcitem set name = 'Unknown 41192' where item_id = 41192;
update etcitem set name = 'Unknown 41193' where item_id = 41193;
update etcitem set name = 'Unknown 41194' where item_id = 41194;
update etcitem set name = 'Unknown 41195' where item_id = 41195;
update etcitem set name = 'Unknown 41196' where item_id = 41196;
update etcitem set name = 'Unknown 41197' where item_id = 41197;
update etcitem set name = 'Unknown 41198' where item_id = 41198;
update etcitem set name = 'Unknown 41199' where item_id = 41199;
update etcitem set name = 'Unknown 41200' where item_id = 41200;
update etcitem set name = 'Unknown 41201' where item_id = 41201;
update etcitem set name = 'Unknown 41202' where item_id = 41202;
update etcitem set name = 'Unknown 41203' where item_id = 41203;
update etcitem set name = 'Unknown 41204' where item_id = 41204;
update etcitem set name = 'Unknown 41205' where item_id = 41205;
update etcitem set name = 'Unknown 41206' where item_id = 41206;
update etcitem set name = 'Unknown 41207' where item_id = 41207;
update etcitem set name = 'Unknown 41208' where item_id = 41208;
update etcitem set name = 'Unknown 41209' where item_id = 41209;
update etcitem set name = 'Unknown 41210' where item_id = 41210;
update etcitem set name = 'Herb' where item_id = 41211;
update etcitem set name = 'Unknown 41212' where item_id = 41212;
update etcitem set name = 'Unknown 41213' where item_id = 41213;
update etcitem set name = 'Unknown 41214' where item_id = 41214;
update etcitem set name = 'Unknown 41215' where item_id = 41215;
update etcitem set name = 'Unknown 41216' where item_id = 41216;
update etcitem set name = 'Unknown 41217' where item_id = 41217;
update etcitem set name = 'Unknown 41218' where item_id = 41218;
update etcitem set name = 'Unknown 41219' where item_id = 41219;
update etcitem set name = 'Unknown 41220' where item_id = 41220;
update etcitem set name = 'Dark Elven Pouch' where item_id = 41221;
update etcitem set name = 'Unknown 41222' where item_id = 41222;
update etcitem set name = 'Unknown 41223' where item_id = 41223;
update etcitem set name = 'Unknown 41224' where item_id = 41224;
update etcitem set name = 'Unknown 41225' where item_id = 41225;
update etcitem set name = 'Unknown 41226' where item_id = 41226;
update etcitem set name = 'Unknown 41227' where item_id = 41227;
update etcitem set name = 'Unknown 41228' where item_id = 41228;
update etcitem set name = 'Unknown 41229' where item_id = 41229;
update etcitem set name = 'Unknown 41230' where item_id = 41230;
update etcitem set name = 'Unknown 41231' where item_id = 41231;
update etcitem set name = 'Unknown 41232' where item_id = 41232;
update etcitem set name = 'Unknown 41233' where item_id = 41233;
update etcitem set name = 'Unknown 41234' where item_id = 41234;
update etcitem set name = 'Unknown 41235' where item_id = 41235;
update etcitem set name = 'Unknown 41236' where item_id = 41236;
update etcitem set name = 'Unknown 41237' where item_id = 41237;
update etcitem set name = 'Unknown 41238' where item_id = 41238;
update etcitem set name = 'Unknown 41239' where item_id = 41239;
update etcitem set name = 'Unknown 41240' where item_id = 41240;
update etcitem set name = 'Unknown 41241' where item_id = 41241;
update etcitem set name = 'Orc Treasure Bag' where item_id = 41242;
update etcitem set name = 'Scroll of Teleportation - GM', name_id = '$230 - GM' where item_id = 42001;
update etcitem set name = 'Scroll of Teleportation - Crystal Cave 1F', name_id = '$230 - Crystal Cave 1F' where item_id = 42002;
update etcitem set name = 'Scroll of Teleportation - Crystal Cave 2F', name_id = '$230 - Crystal Cave 2F' where item_id = 42003;
update etcitem set name = 'Scroll of Teleportation - Crystal Cave 3F', name_id = '$230 - Crystal Cave 3F' where item_id = 42004;
update etcitem set name = 'Scroll of Teleportation - Ivory Tower 1F', name_id = '$230 - Ivory Tower 1F' where item_id = 42005;
update etcitem set name = 'Scroll of Teleportation - Kent Dungeon 1F', name_id = '$230 - Kent Dungeon 1F' where item_id = 42006;
update etcitem set name = 'Scroll of Teleportation - Forgotten Island', name_id = '$230 - Forgotten Island' where item_id = 42007;
update etcitem set name = 'Scroll of Teleportation - Kent Dungeon 2F', name_id = '$230 - Kent Dungeon 2F' where item_id = 42008;
update etcitem set name = 'Scroll of Teleportation - Kent Dungeon 3F', name_id = '$230 - Kent Dungeon 3F' where item_id = 42009;
update etcitem set name = 'Scroll of Teleportation - Kent Dungeon 4F', name_id = '$230 - Kent Dungeon 4F' where item_id = 42010;
update etcitem set name = 'Scroll of Teleportation - 1F Meeting Area', name_id = '$230 - 1F Meeting Area' where item_id = 42011;
update etcitem set name = 'Scroll of Teleportation - 1F Squad Training', name_id = '$230 - 1F Squad Training' where item_id = 42012;
update etcitem set name = 'Scroll of Teleportation - 1F Power King', name_id = '$230 - 1F Power King' where item_id = 42013;
update etcitem set name = 'Scroll of Teleportation - 1F Dark Warrens', name_id = '$230 - 1F Dark Warrens' where item_id = 42014;
update etcitem set name = 'Scroll of Teleportation - 1F Dark Warrens', name_id = '$230 - 1F Dark Warrens' where item_id = 42016;
update etcitem set name = 'Scroll of Teleportation - Dream Island', name_id = '$230 - Dream Island' where item_id = 42017;
update etcitem set name = 'Scroll of Teleportation - 1F Summoning', name_id = '$230 - 1F Summoning' where item_id = 42018;
update etcitem set name = 'Scroll of Teleportation - 1F Dark Barrier', name_id = '$230 - 1F Dark Barrier' where item_id = 42019;
update etcitem set name = 'Scroll of Teleportation - 2F Magic Training', name_id = '$230 - 1F Magic Training' where item_id = 42020;
update etcitem set name = 'Scroll of Teleportation - Giant\'s Grave', name_id = '$230 - Giant\'s Grave' where item_id = 42021;
update etcitem set name = 'Scroll of Teleportation - Aden Castle', name_id = '$230 - Aden Castle' where item_id = 42022;
update etcitem set name = 'Scroll of Teleportation - GM Room', name_id = '$230 - GM Room' where item_id = 42023;
update etcitem set name = 'Scroll of Teleportation - Lawful Temple', name_id = '$230 - Lawful Temple' where item_id = 42024;
update etcitem set name = 'Scroll of Teleportation - Chaotic Temple', name_id = '$230 - Chaotic Temple' where item_id = 42025;
update etcitem set name = 'Scroll of Teleportation - Aden Tower', name_id = '$230 - Aden Tower' where item_id = 42026;
update etcitem set name = 'Scroll of Escape - Silver Knight Town', name_id = '$505 - Silver Knight Town' where item_id = 42027;
update etcitem set name = 'Scroll of Teleportation - MLC7', name_id = '$230 - MLC7' where item_id = 42028;
update etcitem set name = 'Scroll of Teleportation - TOI 100F', name_id = '$230 - TOI 100F' where item_id = 42029;
update etcitem set name = 'Scroll of Teleportation - TOI 90F', name_id = '$230 - TOI 90F' where item_id = 42030;
update etcitem set name = 'Scroll of Teleportation - TOI 80F', name_id = '$230 - TOI 80F' where item_id = 42031;
update etcitem set name = 'Scroll of Teleportation - TOI 70F', name_id = '$230 - TOI 70F' where item_id = 42033;
update etcitem set name = 'Scroll of Teleportation - TOI 60F', name_id = '$230 - TOI 60F' where item_id = 42033;
update etcitem set name = 'Scroll of Teleportation - TOI 50F', name_id = '$230 - TOI 50F' where item_id = 42035;
update etcitem set name = 'Scroll of Teleportation - TOI 40F', name_id = '$230 - TOI 40F' where item_id = 42036;
update etcitem set name = 'Scroll of Teleportation - TOI 30F', name_id = '$230 - TOI 30F' where item_id = 42037;
update etcitem set name = 'Scroll of Teleportation - TOI 20F', name_id = '$230 - TOI 20F' where item_id = 42038;
update etcitem set name = 'Scroll of Teleportation - TOI 10F', name_id = '$230 - TOI 10F' where item_id = 42039;
update etcitem set name = 'Scroll of Teleportation - PI Dugeon 1F', name_id = '$230 - PI Dugeon 1F' where item_id = 42040;
update etcitem set name = 'Scroll of Teleportation - PI Dugeon 2F', name_id = '$230 - PI Dugeon 2F' where item_id = 42041;
update etcitem set name = 'Scroll of Teleportation - PI Dugeon 3F', name_id = '$230 - PI Dugeon 3F' where item_id = 42042;
update etcitem set name = 'Scroll of Teleportation - Abyss Lake', name_id = '$230 - Abyss Lake' where item_id = 42043;
update etcitem set name = 'Scroll of Teleportation - TI Training', name_id = '$230 - TI Training' where item_id = 42044;
update etcitem set name = 'Scroll of Teleportation - Pledge House', name_id = '$230 - Pledge House' where item_id = 42045;
update etcitem set name = 'Scroll of Teleportation - Pledge House', name_id = '$230 - Pledge House' where item_id = 42046;
update etcitem set name = 'Scroll of Teleportation - Ancient Space 3F', name_id = '$230 - Ancient Space 3F' where item_id = 42047;
update etcitem set name = 'Scroll of Teleportation - Oum Dungeon', name_id = '$230 - Oum Dungeon' where item_id = 42048;
update etcitem set name = 'Scroll of Teleportation - Forgotten Island', name_id = '$230 - Forgotten Island' where item_id = 42049;
update etcitem set name = 'Ticket to Hell' where item_id = 42050;
update etcitem set name = 'Scroll of Teleportation - Temple of Shadows', name_id = '$230 - Temple of Shadows' where item_id = 42051;
update etcitem set name = 'Scroll of Teleportation - ToS 1F', name_id = '$230 - ToS 1F' where item_id = 42052;
update etcitem set name = 'Scroll of Teleportation - ToS 2F', name_id = '$230 - ToS 2F' where item_id = 42053;
update etcitem set name = 'Scroll of Teleportation - ToS 3F', name_id = '$230 - ToS 3F' where item_id = 42054;
update etcitem set name = 'Potion of Revival' where item_id = 43000;
update etcitem set name = 'Karif Pouch' where item_id = 49005;
update etcitem set name = 'Karif Pouch' where item_id = 49006;
update etcitem set name = 'Karif Pouch' where item_id = 49007;
update etcitem set name = 'Karif Pouch' where item_id = 49008;
update etcitem set name = 'High Quality Pouch of Karif' where item_id = 49009;
update etcitem set name = 'High Quality Pouch of Karif' where item_id = 49010;
update etcitem set name = 'High Quality Pouch of Karif' where item_id = 49011;
update etcitem set name = 'High Quality Pouch of Karif' where item_id = 49012;
update etcitem set name = 'Scroll of Soul' where item_id = 49013;
update etcitem set name = 'Stationary' where item_id = 49016;
update etcitem set name = 'Valentines Day Card' where item_id = 49022;
update etcitem set name = 'Valentines Day Card' where item_id = 49023;
update etcitem set name = 'Potion of Bravery' where item_id = 140014;
update etcitem set name = 'Potion of Mana' where item_id = 140015;
update etcitem set name = 'Potion of Wisdom' where item_id = 140016;
update etcitem set name = 'Scroll of Enchant Armor' where item_id = 140074;
update etcitem set name = 'Scroll of Enchant Weapon' where item_id = 140087;
update etcitem set name = 'Gian\'s Scroll' where item_id = 140129;
update etcitem set name = 'Kalba\'s Scroll' where item_id = 14030;
update etcitem set name = 'Native\'s Totem' where item_id = 140329;
update etcitem set name = 'Scroll of Enchant Armor' where item_id = 240074;
update etcitem set name = 'Scroll of Enchant Weapon' where item_id = 240087;


-- update 24

-- fix name on lump of iron and heart of firebird
update etcitem set name = 'Lump of Iron' where item_id = 40408;
update etcitem set name = 'Heart of Firebird' where item_id = 40409;

-- correct misnamed pan's mane/fairydust
update etcitem set name = 'Pan\'s Mane' where item_id = 40520;
update etcitem set name = 'Fairydust' where item_id = 40520;



-- update 25

-- Spirit Crystal(Natures Miracle)  Fix
insert into `etcitem` values ('41243', 'Spirit Crystal(NaturesMiracle)', '$1853', 'spellbook', 'normal', 'gemstone', '7000', '688', '2958', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '3', '3000', '0', '0');

-- make whip of beast summoner stackable
update etcitem set stackable = 1 where item_id = 40453;

-- Fix for wrong name in etcitem
update etcitem set name = 'Scroll of Teleportation - TOI 70F', name_id = '$230 - TOI 70F' where item_id=42032;

-- fixed kalba\'s scroll name
update etcitem set name = 'Kalba\'s Scroll' where item_id = 140130;
