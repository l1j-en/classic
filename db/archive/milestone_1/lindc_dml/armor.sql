-- update 27

-- corrent name of Amulet of Constitution
update armor set name = 'Amulet of Constitution' where item_id = 20268;



-- update 28

-- update elven breast plate to be usable by mage
update armor set use_mage = 1 where item_id = 20139;



-- update 30

-- add names for new armor
update armor set name = 'Red Mask' where item_id = 20382;
update armor set name = 'Helmet for Horse Riding' where item_id = 20383;
update armor set name = 'Heibear Necklace' where item_id = 20419;
update armor set name = 'Lucky Cat Scarf' where item_id = 20420;
update armor set name = 'Shiny Ancient Necklace' where item_id = 20422;
update armor set name = 'Necklace of Light' where item_id = 20426;
update armor set name = 'Crafted Ring of Hero 1 (Earth Spirit)' where item_id = 20435;
update armor set name = 'Crafted Ring of Hero 1 (Water Spirit)' where item_id = 20436;
update armor set name = 'Crafted Ring of Hero 1 (Fire Spirit)' where item_id = 20437;
update armor set name = 'Crafted Ring of Hero 1 (Wind Spirit)' where item_id = 20438;
update armor set name = 'Crafted Ring of Hero 2 (Earth Spirit)' where item_id = 20439;
update armor set name = 'Crafted Ring of Hero 2 (Water Spirit)' where item_id = 20440;
update armor set name = 'Crafted Ring of Hero 2 (Fire Spirit)' where item_id = 20441;
update armor set name = 'Crafted Ring of Hero 2 (Wind Spirit)' where item_id = 20442;
update armor set name = 'Crafted Ring of Hero 3 (Earth Spirit)' where item_id = 20443;
update armor set name = 'Crafted Ring of Hero 3 (Water Spirit)' where item_id = 20444;
update armor set name = 'Crafted Ring of Hero 3 (Fire Spirit)' where item_id = 20445;
update armor set name = 'Crafted Ring of Hero 3 (Wind Spirit)' where item_id = 20446;
update armor set name = 'Ring of Hero (Earth Spirit)' where item_id = 20447;
update armor set name = 'Ring of Hero (Water Spirit)' where item_id = 20448;
update armor set name = 'Ring of Hero (Fire Spirit)' where item_id = 20449;
update armor set name = 'Ring of Hero (Wind Spirit)' where item_id = 20450;
update armor set name = 'Drake Captain Transformation Turban' where item_id = 20452;
update armor set name = 'Iris Transformation Turban' where item_id = 20453;
update armor set name = 'Knight Vald Transformation Turban' where item_id = 20454;
update armor set name = 'Succubus Queen Transformation Turban' where item_id = 20455;
update armor set name = 'Red Orc\'s Mask' where item_id = 20458;
update armor set name = 'Red Orc\'s Earrings' where item_id = 20459;
update armor set name = 'Black Wizard Earrings 1' where item_id = 21007;
update armor set name = 'Black Wizard Earrings 1' where item_id = 21014;

-- merge new armor changes
update armor set grdgfx = 4957 where item_id = 20020;
update armor set grdgfx = 3818 where item_id = 20022;
update armor set grdgfx = 4964 where item_id = 20030;
update armor set grdgfx = 4969, itemdesc_id = 0 where item_id = 20057;
update armor set grdgfx = 4958 where item_id = 20058;
update armor set grdgfx = 4965 where item_id = 20067;
update armor set grdgfx = 3814 where item_id = 20073;
update armor set grdgfx = 3830 where item_id = 20089;
update armor set grdgfx = 3293 where item_id = 20100;
update armor set grdgfx = 4970 where item_id = 20109;
update armor set grdgfx = 4959 where item_id = 20113;
update armor set grdgfx = 3840 where item_id = 20122;
update armor set grdgfx = 3773 where item_id = 20125;
update armor set grdgfx = 4963 where item_id = 20129;
update armor set grdgfx = 3840 where item_id = 20142;
update armor set grdgfx = 3768 where item_id = 20143;
update armor set grdgfx = 5016 where item_id = 20144;
update armor set grdgfx = 3842 where item_id = 20147;
update armor set grdgfx = 5038 where item_id = 20158;
update armor set grdgfx = 4765 where item_id = 20167;
update armor set grdgfx = 4959 where item_id = 20168;
update armor set grdgfx = 4966 where item_id = 20176;
update armor set grdgfx = 4972 where item_id = 20178;
update armor set grdgfx = 5058 where item_id = 20179;
update armor set grdgfx = 4971 where item_id = 20200;
update armor set grdgfx = 4960 where item_id = 20201;
update armor set grdgfx = 4967 where item_id = 20208;
update armor set grdgfx = 3317 where item_id = 20214;
update armor set grdgfx = 4961 where item_id = 20228;
update armor set grdgfx = 4968 where item_id = 20233;
update armor set type = 'shield' where item_id = 20240;
update armor set grdgfx = 4974 where item_id = 20253;
update armor set name = 'Ring of Arcane King', grdgfx = 4973 where item_id = 20255;
update armor set grdgfx = 3130 where item_id = 20260;
update armor set grdgfx = 3976 where item_id = 20265;
update armor set grdgfx = 5060 where item_id = 20290;
update armor set grdgfx = 4977 where item_id = 20313;
update armor set grdgfx = 4688 where item_id = 20343;
update armor set grdgfx = 4688 where item_id = 20344;
update armor set grdgfx = 4411 where item_id = 20353;
update armor set grdgfx = 4412 where item_id = 20354;
update armor set grdgfx = 4414 where item_id = 20355;
update armor set grdgfx = 4415 where item_id = 20356;
update armor set grdgfx = 4416 where item_id = 20357;
update armor set grdgfx = 5538 where item_id = 20358;
update armor set grdgfx = 5539 where item_id = 20359;
update armor set grdgfx = 5540 where item_id = 20360;
update armor set grdgfx = 5541 where item_id = 20361;
update armor set grdgfx = 5542 where item_id = 20362;
update armor set grdgfx = 5543 where item_id = 20363;
update armor set grdgfx = 5544 where item_id = 20364;
update armor set grdgfx = 5545 where item_id = 20365;
update armor set grdgfx = 5603 where item_id = 20381;
update armor set grdgfx = 2894 where item_id = 20388;
update armor set grdgfx = 5313 where item_id = 20390;
update armor set grdgfx = 5308 where item_id = 20395;
update armor set grdgfx = 2896 where item_id = 20400;
update armor set grdgfx = 3814 where item_id = 20401;
update armor set grdgfx = 5310 where item_id = 20402;
update armor set grdgfx = 2895 where item_id = 20405;
update armor set grdgfx = 5254 where item_id = 20407;
update armor set grdgfx = 5309 where item_id = 20408;
update armor set grdgfx = 5403 where item_id = 20410;
update armor set grdgfx = 5599 where item_id = 20411;
update armor set grdgfx = 5598 where item_id = 20412;
update armor set grdgfx = 3975 where item_id = 20433;
update armor set invgfx = 2173, grdgfx = 5315 where item_id = 20434;
update armor set grdgfx = 5255 where item_id = 21018;
update armor set grdgfx = 5040 where item_id = 21020;
update armor set grdgfx = 5040 where item_id = 21021;
update armor set grdgfx = 5040 where item_id = 21022;
update armor set grdgfx = 5040 where item_id = 21023;
update armor set grdgfx = 5040 where item_id = 21024;
update armor set grdgfx = 5040 where item_id = 21026;
update armor set grdgfx = 5039 where item_id = 21027; 
INSERT INTO `armor` VALUES ('21028', 'T-shirt with %i\'s Strength', '$5356', 'T', 'cloth', '10000', '2663', '24', '0', '0', '4', '1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21029', 'T-shirt with %i\'s Agility', '$5357', 'T', 'cloth', '10000', '2663', '24', '0', '0', '4', '1', '1', '1', '1', '1', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21030', 'T-shirt with %i\'s Charm', '$5358', 'T', 'cloth', '10000', '2663', '24', '0', '0', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21031', 'T-shirt with %i\'s Magic Power', '$5359', 'T', 'cloth', '10000', '2663', '24', '0', '0', '4', '1', '1', '1', '1', '1', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21032', 'T-shirt with %i\'s Physical Strength', '$5360', 'T', 'cloth', '10000', '2663', '24', '0', '0', '4', '1', '1', '1', '1', '1', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21033', 'T-shirt with %i\'s Mana', '$5361', 'T', 'cloth', '10000', '2663', '24', '0', '0', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21034', 'Rabbit Ring', '$3714', 'ring', 'bone', '1000', '1865', '4687', '0', '-2', '-1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0');
update armor set grdgfx = 3840 where item_id = 220122;
update armor set grdgfx = 3773 where item_id = 220125;
update armor set grdgfx = 3842 where item_id = 220147;



-- update 31

-- new cloaks dont know the names yet
INSERT INTO `armor` VALUES ('21057', ' ', '$5021', 'cloak', 'leather', '10000', '2551', '6128', '2600', '-1', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21058', '', '$5021', 'cloak', 'leather', '10000', '2552', '6127', '2600', '-2', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '5', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `armor` VALUES ('21059', '', '$5022', 'cloak', 'leather', '10000', '2562', '6126', '2601', '-4', '4', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '10', '0', '3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0');

-- armor desc update
UPDATE armor SET itemdesc_id="1715" WHERE item_id="20031"; 
UPDATE armor SET itemdesc_id="1051" WHERE item_id="20037"; 
UPDATE armor SET itemdesc_id="975" WHERE item_id="20068"; 
UPDATE armor SET itemdesc_id="1718" WHERE item_id="20069"; 
UPDATE armor SET itemdesc_id="1381" WHERE item_id="20076"; 
UPDATE armor SET itemdesc_id="1717" WHERE item_id="20083"; 
UPDATE armor SET itemdesc_id="1716" WHERE item_id="20131"; 
UPDATE armor SET itemdesc_id="1748" WHERE item_id="20133"; 
UPDATE armor SET itemdesc_id="655" WHERE item_id="20140"; 
UPDATE armor SET itemdesc_id="656" WHERE item_id="20141"; 
UPDATE armor SET itemdesc_id="657" WHERE item_id="20142"; 
UPDATE armor SET itemdesc_id="654" WHERE item_id="20143"; 
UPDATE armor SET itemdesc_id="1379" WHERE item_id="20152"; 
UPDATE armor SET itemdesc_id="1720" WHERE item_id="20179"; 
UPDATE armor SET itemdesc_id="1380" WHERE item_id="20186"; 
UPDATE armor SET itemdesc_id="1001" WHERE item_id="20204"; 
UPDATE armor SET itemdesc_id="1719" WHERE item_id="20209"; 
UPDATE armor SET itemdesc_id="1382" WHERE item_id="20216"; 
UPDATE armor SET itemdesc_id="666" WHERE item_id="20230"; 
UPDATE armor SET itemdesc_id="114" WHERE item_id="20236"; 
UPDATE armor SET itemdesc_id="289" WHERE item_id="20238"; 
UPDATE armor SET itemdesc_id="282" WHERE item_id="20251"; 
UPDATE armor SET itemdesc_id="1722" WHERE item_id="20261"; 
UPDATE armor SET itemdesc_id="282" WHERE item_id="20270"; 
UPDATE armor SET itemdesc_id="1113" WHERE item_id="20286"; 
UPDATE armor SET itemdesc_id="1292" WHERE item_id="20289"; 
UPDATE armor SET itemdesc_id="1721" WHERE item_id="20290"; 
UPDATE armor SET itemdesc_id="1185" WHERE item_id="20299"; 
UPDATE armor SET itemdesc_id="2104" WHERE item_id="20381"; 
UPDATE armor SET itemdesc_id="1854" WHERE item_id="20389"; 
UPDATE armor SET itemdesc_id="1856" WHERE item_id="20393"; 
UPDATE armor SET itemdesc_id="1857" WHERE item_id="20401"; 
UPDATE armor SET itemdesc_id="1855" WHERE item_id="20406"; 
UPDATE armor SET itemdesc_id="1853" WHERE item_id="20409"; 
UPDATE armor SET itemdesc_id="1724" WHERE item_id="21020"; 
UPDATE armor SET itemdesc_id="1725" WHERE item_id="21021"; 
UPDATE armor SET itemdesc_id="1726" WHERE item_id="21022"; 
UPDATE armor SET itemdesc_id="1727" WHERE item_id="21023"; 
UPDATE armor SET itemdesc_id="1728" WHERE item_id="21024"; 
UPDATE armor SET itemdesc_id="1729" WHERE item_id="21025"; 
UPDATE armor SET itemdesc_id="1730" WHERE item_id="21026"; 
UPDATE armor SET itemdesc_id="1731" WHERE item_id="21027";
