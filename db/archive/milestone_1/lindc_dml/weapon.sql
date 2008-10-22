-- update 30

-- add names for new weapons
update weapon set name = 'Dagger of Blue Sky' where item_id = 231;
update weapon set name = 'Sword of Blue Sky' where item_id = 232;
update weapon set name = 'Great Sword of Blue Sky' where item_id = 233;
update weapon set name = 'Spear of Blue Sky' where item_id = 234;
update weapon set name = 'Axe of Blue Sky' where item_id = 235;
update weapon set name = 'Edoryu of Blue Sky' where item_id = 236;
update weapon set name = 'Claw of Blue Sky' where item_id = 237;
update weapon set name = 'Staff of Blue Sky' where item_id = 238;
update weapon set name = 'Bow of Blue Sky' where item_id = 239;
update weapon set name = 'Gauntlet of Blue Sky' where item_id = 240;
update weapon set name = 'Small Hammer of Happiness' where item_id = 245;

-- merge weapon table changes
update weapon set grdgfx = 4982 where item_id = 11;
update weapon set grdgfx = 3370 where item_id = 13;
update weapon set grdgfx = 5046 where item_id = 14;
update weapon set grdgfx = 4759 where item_id = 33;
update weapon set grdgfx = 4979 where item_id = 40;
delete from weapon where item_id = 44;
INSERT INTO `weapon` VALUES ('44', 'Sword of Ancient Elf', '$2772', 'sword', 'mithril', '20000', '1250', '3314', '1006', '12', '12', '6', '0', '0', '0', '1', '0', '3', '1', '0', '0', '1', '0', '0', '0', '50', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0');
update weapon set grdgfx = 4955 where item_id = 49;
update weapon set grdgfx = 4978 where item_id = 55;
update weapon set itemdesc_id = 0 where item_id = 57;
update weapon set grdgfx = 4317 where item_id = 63;
update weapon set grdgfx = 4981 where item_id = 70;
update weapon set grdgfx = 2925 where item_id = 75;
update weapon set grdgfx = 4975 where item_id = 78;
update weapon set grdgfx = 4763 where item_id = 79;
update weapon set grdgfx = 2927 where item_id = 81;
update weapon set grdgfx = 4980 where item_id = 130;
update weapon set grdgfx = 4962 where item_id = 132;
update weapon set type = 'tohandstaff' where item_id = 134;
update weapon set material = 'platinum', grdgfx = 4976 where item_id = 155;
update weapon set material = 'platinum' where item_id = 163;
update weapon set material = 'platinum' where item_id = 164;
update weapon set material = 'bone' where item_id = 166;
update weapon set grdgfx = 2919 where item_id = 168;
update weapon set grdgfx = 2918 where item_id = 177;
update weapon set grdgfx = 4761 where item_id = 178;
delete from weapon where item_id = 179;
INSERT INTO `weapon` VALUES ('179', 'Bow of Ancient Elf', '$2771', 'singlebow', 'wood', '30000', '1251', '3313', '1005', '3', '3', '6', '0', '0', '0', '1', '0', '1', '2', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0');
update weapon set grdgfx = 4761 where item_id = 242;
INSERT INTO `weapon` VALUES ('246', 'Sword of Ordeal', '$4046', 'sword', 'iron', '40000', '932', '3963', '1866', '10', '10', '5', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1');
INSERT INTO `weapon` VALUES ('247', 'Sword of Ordeal', '$4046', 'sword', 'iron', '40000', '932', '3963', '1867', '10', '10', '5', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1');
INSERT INTO `weapon` VALUES ('248', 'Sword of Ordeal', '$4046', 'sword', 'iron', '40000', '932', '3963', '1868', '10', '10', '5', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1');
INSERT INTO `weapon` VALUES ('249', 'Sword of Ordeal', '$4046', 'sword', 'iron', '40000', '932', '3963', '1869', '10', '10', '5', '1', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1');
update weapon set grdgfx = 4955 where item_id = 100049;
update weapon set grdgfx = 4954 where item_id = 100062;
INSERT INTO `weapon` VALUES ('100114', 'Symbol of Dignity', '$4386', 'blunt', 'iron', '20000', '2228', '5606', '2102', '14', '16', '6', '1', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '40', '0', '0', '0');
INSERT INTO `weapon` VALUES ('100157', 'Silver Claw', '$2454 $372', 'claw', 'silver', '20000', '1086', '2911', '850', '13', '10', '6', '0', '0', '0', '0', '1', '0', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `weapon` VALUES ('100204', 'Indiscriminate Avarist', '$4387', 'bow', 'iron', '25000', '2230', '5601', '2103', '3', '3', '6', '0', '0', '0', '1', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '40', '0', '0', '0');
INSERT INTO `weapon` VALUES ('100207', 'Claw of Purgatory', '$4384', 'claw', 'blackmithril', '50000', '2225', '5605', '2100', '14', '12', '0', '0', '0', '0', '0', '1', '-5', '4', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
update weapon set material = 'platinum' where item_id = 100164;
update weapon set grdgfx = 5607 where item_id = 100212;
update weapon set add_sp = 1 where item_id = 100008;
update weapon set add_sp = 1 where item_id = 8;

update weapon set double_dmg_chance = 10 where item_id = 69; 
update weapon set double_dmg_chance = 11 where item_id = 70; 
update weapon set double_dmg_chance = 10 where item_id = 71; 
update weapon set double_dmg_chance = 11 where item_id = 72; 
update weapon set double_dmg_chance = 25 where item_id = 73; 
update weapon set double_dmg_chance = 25 where item_id = 74; 
update weapon set double_dmg_chance = 13 where item_id = 75; 
update weapon set double_dmg_chance = 20 where item_id = 76; 
update weapon set double_dmg_chance = 30 where item_id = 77; 
update weapon set double_dmg_chance = 25 where item_id = 78; 
update weapon set double_dmg_chance = 30 where item_id = 79; 
update weapon set double_dmg_chance = 25 where item_id = 80; 
update weapon set double_dmg_chance = 25 where item_id = 81; 
update weapon set double_dmg_chance = 20 where item_id = 82; 
update weapon set double_dmg_chance = 25 where item_id = 83; 
update weapon set double_dmg_chance = 25 where item_id = 84; 
update weapon set double_dmg_chance = 20 where item_id = 85; 
update weapon set double_dmg_chance = 25 where item_id = 86; 
update weapon set double_dmg_chance = 40 where item_id = 152; 
update weapon set double_dmg_chance = 40 where item_id = 153; 
update weapon set double_dmg_chance = 33 where item_id = 154; 
update weapon set double_dmg_chance = 30 where item_id = 155; 
update weapon set double_dmg_chance = 30 where item_id = 156; 
update weapon set double_dmg_chance = 34 where item_id = 157; 
update weapon set double_dmg_chance = 25 where item_id = 158; 
update weapon set double_dmg_chance = 15 where item_id = 159; 
update weapon set double_dmg_chance = 35 where item_id = 160; 
update weapon set double_dmg_chance = 40 where item_id = 161; 
update weapon set double_dmg_chance = 36 where item_id = 162; 
update weapon set double_dmg_chance = 35 where item_id = 163; 
update weapon set double_dmg_chance = 37 where item_id = 164; 
update weapon set double_dmg_chance = 36 where item_id = 165; 
update weapon set double_dmg_chance = 38 where item_id = 166; 



-- update 31

DELETE FROM weapon WHERE item_id = "230";

-- weapon desc update
UPDATE weapon SET itemdesc_id="996" WHERE item_id="16"; 
UPDATE weapon SET itemdesc_id="659" WHERE item_id="17"; 
UPDATE weapon SET itemdesc_id="660" WHERE item_id="18"; 
UPDATE weapon SET itemdesc_id="276" WHERE item_id="22"; 
UPDATE weapon SET itemdesc_id="284" WHERE item_id="28" or item_id="100028"; 
UPDATE weapon SET itemdesc_id="235" WHERE item_id="37" or item_id="100037"; 
UPDATE weapon SET itemdesc_id="1497" WHERE item_id="43"; 
UPDATE weapon SET itemdesc_id="152" WHERE item_id="45"; 
UPDATE weapon SET itemdesc_id="787" WHERE item_id="56"; 
UPDATE weapon SET itemdesc_id="760" WHERE item_id="65"; 
UPDATE weapon SET itemdesc_id="1808" WHERE item_id="79"; 
UPDATE weapon SET itemdesc_id="1199" WHERE item_id="83"; 
UPDATE weapon SET itemdesc_id="994" WHERE item_id="87"; 
UPDATE weapon SET itemdesc_id="772" WHERE item_id="133"; 
UPDATE weapon SET itemdesc_id="995" WHERE item_id="135"; 
UPDATE weapon SET itemdesc_id="1704" WHERE item_id="150"; 
UPDATE weapon SET itemdesc_id="997" WHERE item_id="166"; 
UPDATE weapon SET itemdesc_id="661" WHERE item_id="167"; 
UPDATE weapon SET itemdesc_id="1200" WHERE item_id="186"; 
UPDATE weapon SET itemdesc_id="1705" WHERE item_id="191"; 
UPDATE weapon SET itemdesc_id="771" WHERE item_id="192"; 
UPDATE weapon SET itemdesc_id="286" WHERE item_id="208"; 
UPDATE weapon SET itemdesc_id="346" WHERE item_id="209"; 
UPDATE weapon SET itemdesc_id="347" WHERE item_id="215";
