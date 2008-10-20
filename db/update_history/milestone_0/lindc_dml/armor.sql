-- update 4

-- swap images for bpm and cpm
update armor set name_id = '$153' where item_id in (20149, 120149);
update armor set name_id = '$154' where item_id in (20128, 120128);

-- correct n-cpm name
update armor set name = 'Crystal Plate Mail' where item_id = 20128;



-- update 6

-- correct name_id for cpm and bpm
update armor set name_id = '$154' where item_id in (20149, 120149);
update armor set name_id = '$153' where item_id in (20128, 120128);

-- swap inventory images for cpm and bpm
update armor set invgfx = 22 where item_id in (20149, 120149);
update armor set invgfx = 32 where item_id in (20128, 120128);



-- update 8

-- correct name of amulet of yahee
update armor set name = 'Amulet of Yahee' where item_id = 20261;
-- correct name of amulet of vigor
update armor set name = 'Amulet of Vigor' where item_id = 20262;

-- correct name of old amulet of wisdom 
update armor set name = 'Old Amulet of Wisdom' where item_id = 120248;

-- correct name of lastabad leather armor
update armor set name = 'Lastabad Leather Armor' where item_id = 20102;



-- update 13

-- fix stats on cursed diamond ring (was -1con -1wis, should be -10HP -10MP)
update armor set add_hp = -10, add_mp = -10, add_con = 0, add_wis = 0 where item_id = 20293;

-- add wooden jacket
insert into armor values(29001, 'Wooden Jacket', 'Wooden Jacket', 'armor', 'wood', 40000, 51, 9, 0, -1, 4, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- change name of Blessed Helmet to just Helmet
update armor set name = 'Helmet' where item_id = 120043;



-- update 14

-- correct name for Slave Earrings (was nothing)
update armor set name = 'Slave Earrings' where item_id = 21027;

-- correct name for Clan Earrings (was nothing)
update armor set name = 'Clan Earrings' where item_id = 21026;

-- correct name for Fantasy Horse Earrings (was nothing)
update armor set name = 'Fantasy Horse Earrings' where item_id = 21025;

-- correct name for Reckless Earrings (was nothing)
update armor set name = 'Reckless Earrings' where item_id = 21024;

-- correct name for Zenith Earrings (was nothing)
update armor set name = 'Zenith Earrings' where item_id = 21023;

-- correct name for Festival Earrings (was nothing)
update armor set name = 'Festival Earrings' where item_id = 21022;

-- correct name for Twin Earrings (was nothing)
update armor set name = 'Twin Earrings' where item_id = 21021;

-- correct name for Dancing Earrings (was nothing)
update armor set name = 'Dancing Earrings' where item_id = 21020;

-- correct name for Earrings of purification (was nothing)
update armor set name = 'Earrings of purification' where item_id = 21019;

-- correct name for Heliocham Earrings (was nothing)
update armor set name = 'Heliocham Earrings' where item_id = 21018;

-- correct name for Black Fighter Earrings 1 (was nothing)
update armor set name = 'Black Fighter Earrings 1' where item_id = 21017;

-- correct name for Black Wizard Earrings 3 (was nothing)
update armor set name = 'Black Wizard Earrings 3' where item_id = 21016;

-- correct name for Black Wizard Earrings 2 (was nothing)
update armor set name = 'Black Wizard Earrings 2' where item_id = 21015;

-- correct name for Black Knight Earrings 3 (was nothing)
update armor set name = 'Black Knight Earrings 3' where item_id = 21012;

-- correct name for Black Knight Earrings 1 (was nothing)
update armor set name = 'Black Knight Earrings 1' where item_id = 21011;

-- correct name for Black Fighter Earrings 3 (was nothing)
update armor set name = 'Black Fighter Earrings 3' where item_id = 21010;

-- correct name for Black Knight Earrings 2 (was nothing)
update armor set name = 'Black Knight Earrings 2' where item_id = 21009;

-- correct name for Black Fighter Earrings 2 (was nothing)
update armor set name = 'Black Fighter Earrings 2' where item_id = 21008;

-- correct name for Black Wizard Earrings 1 (was nothing)
update armor set name = 'Black Wizard Earrings 1' where item_id = 21006;

-- correct name for Earrings of Hero (was nothing)
update armor set name = 'Earrings of Hero' where item_id = 21005;

-- correct name for Earrings of Warrior (was nothing)
update armor set name = 'Earrings of Warrior' where item_id = 21004;

-- correct name for Earrings of Valor (was nothing)
update armor set name = 'Earrings of Valor' where item_id = 21003;

-- add event earrings
INSERT INTO `armor` VALUES ('29002', 'Amateur Poet Earrings', '$4092', 'earring', 'gold', '15000', '2030', '3963', '1815', '5', '-1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0');



-- update 15 

-- fix rk shield ac (-2 -> -3)
update armor set ac = -3 where item_id = 20230;

-- fix name for Old Belt of Soul (was Old Belt of Mind)
update armor set name = 'Old Belt of Soul' where item_id = 20307;

-- fix name for Old Belt of Mind (was Old Belt of Soul)
update armor set name = 'Old Belt of Mind' where item_id = 20308;



-- update 16

-- make ishield base ac 4
update armor set ac = -4 where item_id = 20220;

-- make ivisor base ac 4
update armor set ac = -4 where item_id = 20003;



-- update 19

-- correct name of Boots of Dark Forester (was Boot of Dark Forester)
update armor set name = 'Boots of Dark Forester' where item_id = 20196;

-- correct name of Cursed Sapphire Ring (was Cursed Saphire Ring)
update armor set name = 'Cursed Sapphire Ring' where item_id = 20295;


-- update 20

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
update armor set name = 'Darkness Dealer Plate Mail', name_id = '$2571? $152' where item_id = 20133;

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



-- update 22

-- fix all misnamed armors
update armor set name = 'Knight\'s Hood' where item_id = 20005;
update armor set name = 'Knight\s Visor' where item_id = 20006;
update armor set name = 'Helmet of Magic Resistance' where item_id = 20011;
update armor set name = 'Wizard Cap' where item_id = 20012;
update armor set name = 'Helm of Magic: Speed' where item_id = 20013;
update armor set name = 'Helm of Magic: Healing' where item_id = 20014;
update armor set name = 'Helm of Magic: Power' where item_id = 20015;
update armor set name = 'Crown of Mummy Lord' where item_id = 20017;
update armor set name = 'Helm of Pretender King' where item_id = 20020;
update armor set name = 'Helmet of Baranka' where item_id = 20022;
update armor set name = 'Helmet of the Pretender King' where item_id = 20024;
update armor set name = 'Red Knight\'s Hood' where item_id = 20027;
update armor set name = 'Ivory Tower Leather Helm' where item_id = 20028;
update armor set name = 'Helm of New King' where item_id = 20030;
update armor set name = 'Helm of Yahee' where item_id = 20031;
update armor set name = 'Studded Leather Cap' where item_id = 20038;
update armor set name = 'Helmet of Kurtz' where item_id = 20041;
update armor set name = 'Blue Pirate Bandanna' where item_id = 20044;
update armor set name = 'Skull Helmet' where item_id = 20045;
update armor set name = 'Pumpkin Mask' where item_id = 20046;
update armor set name = 'Pumpkin Costume' where item_id = 20047;
update armor set name = 'Helm of Chaos' where item_id = 20048;
update armor set name = 'Golden Wing of Giant Ant Queen' where item_id = 20049;
update armor set name = 'Sovereign\'s Majesty' where item_id = 20051;
update armor set name = 'Wolf Skin Cloak' where item_id = 20053;
update armor set name = 'Earth Cloak' where item_id = 20054;
update armor set name = 'Cloak of Arcane King' where item_id = 20057;
update armor set name = 'Water Cloak' where item_id = 20059;
update armor set name = 'Wind Cloak' where item_id = 20061;
update armor set name = 'Varlok\'s Blood-Colered Cloak' where item_id = 20062;
update armor set name = 'Red Knight Cloak' where item_id = 20064;
update armor set name = 'Bishop Cloak' where item_id = 20067;
update armor set name = 'Cloak of the Aden Knights' where item_id = 20068;
update armor set name = 'Fire Cloak' where item_id = 20071;
update armor set name = 'Cloak of Death' where item_id = 20075;
update armor set name = 'Cloak of Chaos' where item_id = 20078;
update armor set name = 'Shirt of Yahee' where item_id = 20083;
update armor set name = 'Doublet Lomejeech' where item_id = 20086;
update armor set name = 'Doublet Lomebuich' where item_id = 20087;
update armor set name = 'Doublet Lomechech' where item_id = 20088;
update armor set name = 'Wooden Armor' where item_id = 20097;
update armor set name = 'Magical Armor of Lindvior' where item_id = 20108;
update armor set name = 'Wizard Clothing' where item_id = 20111;
update armor set name = 'Armor of the Pretender King' where item_id = 20118;
update armor set name = 'Magical Armor of Valakas' where item_id = 20119;
update armor set name = 'Leather Vest with Belt' where item_id = 20120;
update armor set name = 'Robe of Black Wizard' where item_id = 20121;
update armor set name = 'Blue Dragon Armor' where item_id = 20127;
update armor set name = 'Magical Armor of Antharas' where item_id = 20130;
update armor set name_id = '$2571 $152' where item_id = 20133;
update armor set name = 'Green Dragon Armor' where item_id = 20146;
update armor set name = 'Tarak\'s Robe' where item_id = 20152;
update armor set name = 'Magical Armor of Fafurion' where item_id = 20153;
update armor set name = 'White Dragon Armor' where item_id = 20156;
update armor set name = 'Emblem of Chaos' where item_id = 20158;
update armor set name = 'Red Dragon Armor' where item_id = 20159;
update armor set name = 'Armor of Illusion' where item_id = 20161;
update armor set name = 'Demon Gloves' where item_id = 20165;
update armor set name = 'Death Knight Gloves' where item_id = 20166;
update armor set name = 'Gloves of Pretender King' where item_id = 20168;
update armor set name = 'Gauntlet of the Pretender King' where item_id = 20170;
update armor set name = 'Glove of Ice Spirit' where item_id = 20172;
update armor set name = 'Ivory Tower Leather Gloves' where item_id = 20173;
update armor set name = 'Glove of Dark Spirit' where item_id = 20177;
update armor set name = 'Gloves of Assasin King' where item_id = 20178;
update armor set name = 'Glove of Fire Spirit' where item_id = 20181;
update armor set name = 'Scale of Death' where item_id = 20183;
update armor set name = 'Glove of Wind Spirit' where item_id = 20189;
update armor set name = 'Finger of Chaos' where item_id = 20190;
update armor set name = 'Leather Sandal' where item_id = 20193;
update armor set name = 'Boots of Evil Power King' where item_id = 20200;
update armor set name = 'Boots of the Pretender King' where item_id = 20203;
update armor set name_id = '$329' where item_id = 20205;
update armor set name = 'Ivory Tower Leather Sandals' where item_id = 20206;
update armor set name = 'Boots of New King' where item_id = 20208;
update armor set name_id = '$2452 $329' where item_id = 20210;
update armor set name = 'Studded Leather Sandals' where item_id = 20212;
update armor set name = 'Tarak\'s Boots' where item_id = 20216;
update armor set name = 'Wooden Shield' where item_id = 20222;
update armor set name = 'Mana Crystal Ball' where item_id = 20225;
update armor set name = 'Shield of Red Knight', name_id = '$2035' where item_id = 20230;
update armor set name = 'Ivory Tower Leather Shield' where item_id = 20232;
update armor set name = 'Scroll of New King' where item_id = 20233;
update armor set name = 'Shield of the Silver Knight' where item_id = 20238;
update armor set name = 'Armor of Death Piece', type = 'armor' where item_id = 20240;
update armor set name = 'Hidden Valley Amulet' where item_id = 20243;
update armor set name = 'Amulet of Magic Spirit King' where item_id = 20253;
update armor set name = 'Seal of Harmony' where item_id = 20265;
update armor set name = 'Right-Hand Ring of Doppelganger Boss' where item_id = 20277;
update armor set name = 'Left-Hand Ring of Doppelganger Boss' where item_id = 20278;
update armor set name = 'Ring of Immunity to Magic' where item_id = 20280;
update armor set name = 'Ivory Tower Ring' where item_id = 20282;
update armor set name = 'Ring of Gaurdian' where item_id = 20287;
update armor set name = 'Seal of Mental Ability' where item_id = 20297;
update armor set name = 'Ring of Zenith' where item_id = 20298;
update armor set name = 'Seal of Physical Ability' where item_id = 20301;
update armor set name_id = '$90' where item_id = 20305;
update armor set name = 'Ring of Ancient Giant' where item_id = 20314;
update armor set name = 'Belt of Vigor' where item_id = 20315;
update armor set name = 'Cloak of Sashin' where item_id = 20342;
update armor set name_id = 'Easter Bunny Hat' where item_id = 20343;
update armor set name_id = 'Easter Bunny with Carrot Hat' where item_id = 20344;
update armor set name_id = 'High Collie Choker' where item_id = 20345;
update armor set name_id = 'High Raccon Choker' where item_id = 20346;
update armor set name = 'Amulet of Kahel 1' where item_id = 20358;
update armor set name = 'Amulet of Kahel 2' where item_id = 20359;
update armor set name = 'Amulet of Kahel 3' where item_id = 20360;
update armor set name = 'Amulet of Kahel 4' where item_id = 20361;
update armor set name = 'Amulet of Kahel 5' where item_id = 20362;
update armor set name = 'Amulet of Kahel 6' where item_id = 20363;
update armor set name = 'Amulet of Kahel 7' where item_id = 20364;
update armor set name = 'Amulet of Kahel 8' where item_id = 20365;
update armor set name = 'Unknown 20366', name_id = 'Unknown $162' where item_id = 20366;
update armor set name = 'Unknown 20367', name_id = 'Unknown $152' where item_id = 20367;
update armor set name = 'Unknown 20368', name_id = 'Unknown $116' where item_id = 20368;
update armor set name = 'Unknown 20369', name_id = 'Unknown $2466' where item_id = 20369;
update armor set name = 'Unknown 20370', name_id = 'Unknown $225' where item_id = 20370;
update armor set name = 'Unknown 20371', name_id = 'Unknown $207' where item_id = 20371;
update armor set name = 'Unknown 20372', name_id = 'Unknown $330' where item_id = 20372;
update armor set name = 'Unknown 20373', name_id = 'Unknown $128' where item_id = 20373;
update armor set name = 'Unknown 20374', name_id = 'Unknown $4196' where item_id = 20374;
update armor set name = 'Unknown 20375', name_id = 'Unknown $3617' where item_id = 20375;
update armor set name = 'Unknown 20376', name_id = 'Unknown 20376' where item_id = 20376;
update armor set name = 'Unknown 20377', name_id = 'Unknown 20377' where item_id = 20377;
update armor set name = 'Unknown 20378', name_id = 'Unknown 20378' where item_id = 20378;
update armor set name = 'Unknown 20379', name_id = 'Unknown 20379' where item_id = 20379;
update armor set name = 'Halloween Blessing Cap' where item_id = 20380;
update armor set name = 'Hair Clip of Lucidity' where item_id = 20381;
update armor set name = 'Unknown 20382' where item_id = 20382;
update armor set name = 'Unknown 20383' where item_id = 20383;
update armor set name = 'Apprentice Prince Helm' where item_id = 20384;
update armor set name = 'Apprentice Knight Helm' where item_id = 20385;
update armor set name = 'Apprentice Elf Helm' where item_id = 20386;
update armor set name = 'Apprentice Wizard Cap' where item_id = 20387;
update armor set name = 'Dark Elf\'s Training Helmet' where item_id = 20388;
update armor set name = 'Elven Helm of %i' where item_id = 20389;
update armor set name = 'Helm of Fidelity' where item_id = 20390;
update armor set name = 'Apprentice Prince Armor' where item_id = 20391;
update armor set name = 'Apprentice Elf Armor' where item_id = 20392;
update armor set name = 'Elven Armor of %i' where item_id = 20393;
update armor set name = 'Apprentice Knight Armor' where item_id = 20394;
update armor set name = 'Armor of Fidelity' where item_id = 20395;
update armor set name = 'Shield of Sheba Human' where item_id = 20396;
update armor set name = 'Apprentice Prince Shield' where item_id = 20397;
update armor set name = 'Apprentice Knight Shield' where item_id = 20398;
update armor set name = 'Apprentice Wizard Cloak' where item_id = 20399;
update armor set name = 'Dark Elf\'s Training Cloak' where item_id = 20400;
update armor set name = 'Elven Cloak of %i' where item_id = 20401;
update armor set name = 'Cloak of Fidelity' where item_id = 20402;
update armor set name = 'Apprentice Elf Boots' where item_id = 20403;
update armor set name = 'Apprentice Wizard Boots' where item_id = 20404;
update armor set name = 'Dark Elf\'s Training Boots' where item_id = 20405;
update armor set name = 'Elven Boots of %i' where item_id = 20406;
update armor set name = 'Militia Boots' where item_id = 20407;
update armor set name = 'Boots of Fidelity' where item_id = 20408;
update armor set name = 'Elven Gloves of %i' where item_id = 20409;
update armor set name = 'Gloves of Fidelity' where item_id = 20410;
update armor set name = 'Amulet of Suffering' where item_id = 20411;
update armor set name = 'Amulet of Anguish' where item_id = 20412;
update armor set name = 'Amulet of Hope' where item_id = 20413;
update armor set name = 'Amulet of Luck' where item_id = 20414;
update armor set name = 'Amulet of Passion' where item_id = 20415;
update armor set name = 'Amulet of Truth' where item_id = 20416;
update armor set name = 'Amulet of Miracle' where item_id = 20417;
update armor set name = 'Amulet of Affection' where item_id = 20418;
update armor set name = 'Unknown 20419' where item_id = 20419;
update armor set name = 'Unknown 20420' where item_id = 20420;
update armor set name = 'Amulet of Eris' where item_id = 20421;
update armor set name = 'Unknown 20422' where item_id = 20422;
update armor set name = 'Amulet of Red Curse' where item_id = 20423;
update armor set name = 'Amulet of  Blue Curse' where item_id = 20424;
update armor set name = 'Amulet of Green Curse' where item_id = 20425;
update armor set name = 'Unknown 20426' where item_id = 20426;
update armor set name = 'Talisman' where item_id = 20427;
update armor set name = 'Ring of Hope' where item_id = 20428;
update armor set name = 'Ring of Passion' where item_id = 20429;
update armor set name = 'Ring of Luck' where item_id = 20430;
update armor set name = 'Ring of Truth' where item_id = 20431;
update armor set name = 'Ring of Miracles' where item_id = 20432;
update armor set name = 'Ring of Bravery' where item_id = 20433;
update armor set name = 'Ring of Eris' where item_id = 20434;
update armor set name = 'Unknown 20435' where item_id = 20435;
update armor set name = 'Unknown 20436' where item_id = 20436;
update armor set name = 'Unknown 20437' where item_id = 20437;
update armor set name = 'Unknown 20438' where item_id = 20438;
update armor set name = 'Unknown 20439' where item_id = 20439;
update armor set name = 'Unknown 20440' where item_id = 20440;
update armor set name = 'Unknown 20441' where item_id = 20441;
update armor set name = 'Unknown 20442' where item_id = 20442;
update armor set name = 'Unknown 20443' where item_id = 20443;
update armor set name = 'Unknown 20444' where item_id = 20444;
update armor set name = 'Unknown 20445' where item_id = 20445;
update armor set name = 'Unknown 20446' where item_id = 20446;
update armor set name = 'Unknown 20447' where item_id = 20447;
update armor set name = 'Unknown 20448' where item_id = 20448;
update armor set name = 'Unknown 20449' where item_id = 20449;
update armor set name = 'Unknown 20450' where item_id = 20450;
update armor set name = 'Unknown 20452' where item_id = 20452;
update armor set name = 'Unknown 20453' where item_id = 20453;
update armor set name = 'Unknown 20454' where item_id = 20454;
update armor set name = 'Unknown 20455' where item_id = 20455;
update armor set name = 'Red Soccer Uniform' where item_id = 20456;
update armor set name = 'Blue Soccer Uniform' where item_id = 20457;
update armor set name = 'Unknown 20458' where item_id = 20458;
update armor set name = 'Unknown 20459' where item_id = 20459;
update armor set name = 'Amulet of Glory' where item_id = 20460;
update armor set name = 'Succubus Earring', name_id = '$1000 Earring' where item_id = 21000;
update armor set name = 'Snowman Earring', name_id = '$1783 Earring' where item_id = 21001;
update armor set name = 'Ice Golem Earring', name_id = '$1395 Earring' where item_id = 21002;
update armor set name = 'Unknown 21007' where item_id = 21007;
update armor set name = 'Unprocessed Black Fighter Earrings 1' where item_id = 21013;
update armor set name = 'Unknown 21014' where item_id = 21014;
update armor set name = 'Helmet of Magic Resistance' where item_id = 120011;
update armor set name = 'Ring of Immunity to Magic' where item_id = 120280;