
	-- Removing TI normal mobs spawn
	UPDATE spawnlist SET count = 0 WHERE mapid = 0;

	-- EASIER STUFF
	INSERT INTO `npc`  VALUES ('91316', 'Sakura Baphomet', 'Sakura Baphomet', '', 'L1Monster', '53', '55', '2500', '700', '-65', '85', '20', '25', '17', '35', '80', '20000', '-100', 'small', '2', '1', '0', '480', '400', '800', '500', '1200', '2', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '300', '5000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '-1', '0', '0', '1', '0', '1');
	INSERT INTO `npc`  VALUES ('91317', 'Sakura Mambo Rabbit', 'Sakura Mambo Rabbit', '', 'L1Monster', '4174', '55', '2500', '3000', '-35', '35', '18', '25', '18', '40', '50', '20000', '-100', 'small', '0', '1', '0', '960', '800', '0', '300', '1200', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '8', '5000', '20', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '1', '0', '1');
	INSERT INTO `npc`  VALUES ('91318', 'Sakura Beleth', 'Sakura Beleth', '', 'L1Monster', '1011', '55', '2500', '700', '-66', '85', '20', '25', '20', '35', '80', '20000', '-100', 'small', '2', '1', '0', '480', '400', '800', '500', '1200', '2', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '380', '5000', '380', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '-1', '0', '0', '1', '0', '1');
	INSERT INTO `npc`  VALUES ('91319', 'Sakura Zenith Queen', 'Sakura Zenith Queen', '', 'L1Monster', '2807', '55', '2000', '5000', '-50', '65', '18', '55', '18', '35', '70', '20000', '-70', 'large', '0', '1', '0', '480', '1000', '0', '1000', '1000', '0', '1', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '75', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '3', '1', '0', '1');
	INSERT INTO `npc`  VALUES ('91320', 'Sakura Spirit', 'Sakura Spirit', '', 'L1Monster', '4493', '60', '6000', '3000', '-55', '90', '40', '50', '44', '39', '80', '20000', '0', 'large', '2', '1', '0', '960', '1000', '1200', '1200', '1200', '0', '1', '0', '0', '0', '0', 'pollution', '0', '-1', '-1', '0', '0', '0', '5000', '400', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '0', '-1', '0', '0', '1', '0', '1');

	-- Wabbit
	INSERT INTO `npc` VALUES ('91321', 'Wabbit', 'Wabbit', '', 'L1Monster', '3783', '25', '20', '300', '20', '9', '10', '9', '16', '25', '15', '26', '0', 'small', '0', '1', '1', '960', '1040', '1120', '800', '800', '0', '0', '0', '1', '1', '1', 'manborabbit', '1', '-1', '-1', '0', '0', '0', '5000', '2', '5000', '5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '-1', '0', '0', '1', '0', '1');
	INSERT INTO `mobskill` VALUES ('91321', '0', 'Wabbit', 'Cone of Cold', '2', '100', '0', '0', '-6', '0', '0', '0', '0', '0', '5', '38', '1809', '0', '0', '0', '0', '0');


	-- EASIER STUFF SKILLS
	INSERT INTO `mobskill` VALUES ('91316', '0', 'Sakura Baphomet', 'Eruption', '2', '20', '0', '0', '-6', '0', '0', '0', '0', '0', '20', '45', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91316', '1', 'Sakura Baphomet', 'Summon Skeleton', '3', '7', '0', '0', '-3', '3', '0', '0', '0', '0', '0', '0', '0', '18', '81088', '2', '6', '0');
	INSERT INTO `mobskill` VALUES ('91317', '0', 'Sakura Mambo Rabbit', NULL, '2', '20', '0', '0', '-4', '0', '0', '0', '0', '0', '10', '10037', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91317', '1', 'Sakura Mambo Rabbit', 'Summon Rabbits', '3', '7', '0', '0', '-3', '3', '0', '0', '0', '0', '0', '0', '0', '18', '91321', '5', '10', '0');
	INSERT INTO `mobskill` VALUES ('91317', '2', 'Sakura Mambo Rabbit', 'Ice Eruption', '2', '20', '0', '0', '-6', '0', '0', '0', '0', '0', '30', '10035', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91318', '0', 'Sakura Beleth', 'Fireball', '2', '20', '0', '0', '-6', '0', '0', '0', '0', '0', '60', '25', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91318', '1', 'Sakura Beleth', 'Summon Cerberus', '3', '7', '0', '0', '-3', '3', '0', '0', '0', '0', '0', '0', '0', '18', '45241', '2', '4', '0');
	INSERT INTO `mobskill` VALUES ('91319', '0', 'Sakura Zenith Queen', NULL, '2', '40', '0', '0', '-6', '0', '0', '0', '0', '0', '10', '10004', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91320', '0', 'Sakura Spirit', NULL, '2', '30', '0', '0', '-6', '0', '0', '0', '0', '0', '0', '10079', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91320', '1', 'Sakura Spirit', 'Summon Servant of Spirit', '3', '5', '0', '0', '-3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '45794', '4', '8', '0');

	-- HARDER BOSSES
	INSERT INTO `npc` VALUES ('91322', 'Fruity Phoenix', 'Fruity Phoenix', '', 'L1Monster', '1791', '75', '10000', '800', '-63', '70', '18', '38', '32', '30', '100', '3482', '-130', 'large', '4', '2', '0', '960', '800', '0', '800', '800', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '350', '5000', '500', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '-1', '0', '0', '1', '0', '1');
	INSERT INTO `npc` (`npcid`, `name`, `nameid`, `note`, `impl`, `gfxid`, `lvl`, `hp`, `mp`, `ac`, `str`, `con`, `dex`, `wis`, `intel`, `mr`, `exp`, `lawful`, `size`, `weakAttr`, `ranged`, `tamable`, `passispeed`, `atkspeed`, `alt_atk_speed`, `atk_magic_speed`, `sub_magic_speed`, `undead`, `poison_atk`, `paralysis_atk`, `agro`, `agrososc`, `agrocoi`, `family`, `agrofamily`, `agrogfxid1`, `agrogfxid2`, `picupitem`, `digestitem`, `bravespeed`, `hprinterval`, `hpr`, `mprinterval`, `mpr`, `teleport`, `randomlevel`, `randomhp`, `randommp`, `randomac`, `randomexp`, `randomlawful`, `damage_reduction`, `hard`, `doppel`, `IsTU`, `IsErase`, `bowActId`, `karma`, `transform_id`, `transform_gfxid`, `light_size`, `amount_fixed`, `change_head`, `cant_resurrect`) VALUES ('91323', 'Fruity Iris', 'Fruity Iris', '', 'L1Monster', '3180', '75', '10000', '1200', '-75', '70', '13', '64', '13', '40', '100', '4097', '-80', 'large', '0', '1', '0', '1040', '850', '1920', '800', '800', '3', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '275', '5000', '275', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '-1', '0', '14', '1', '0', '1');
	INSERT INTO `npc` VALUES ('91324', 'Fruity Death', 'Fruity Death', '', 'L1Monster', '4587', '75', '12000', '500', '-65', '85', '21', '21', '21', '40', '100', '4901', '-5', 'large', '0', '2', '0', '1000', '600', '1040', '900', '900', '3', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '250', '5000', '250', '0', '0', '0', '0', '0', '0', '0', '4', '1', '0', '0', '0', '4592', '100', '-1', '0', '0', '1', '0', '1');
	INSERT INTO `npc` VALUES ('91326', 'Fruity Squid', 'Fruity Squid', '', 'L1Monster', '5547', '75', '8000', '700', '-55', '85', '18', '16', '10', '40', '100', '3365', '-200', 'large', '8', '2', '0', '960', '500', '1000', '800', '800', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '50', '5000', '16', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '1', '0', '1');
	INSERT INTO `npc` VALUES ('91327', 'Fruity Varlok', 'Fruity Varlok', '', 'L1Monster', '2538', '75', '6000', '700', '-70', '90', '27', '25', '25', '35', '100', '3250', '-180', 'large', '0', '1', '0', '960', '500', '1400', '800', '800', '2', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '100', '5000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '1', '0', '1');
	INSERT INTO `npc` VALUES ('91328', 'Fruity Queen', 'Fruity Queen', '', 'L1Monster', '1390', '75', '10000', '600', '-75', '65', '18', '20', '17', '60', '100', '3250', '-120', 'large', '2', '3', '0', '1280', '600', '600', '700', '700', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '200', '5000', '200', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '-1', '0', '0', '1', '0', '1');
	INSERT INTO `npc` VALUES ('91329', 'Fruity Death Knight', 'Fruity Death Knight', '', 'L1Monster', '240', '75', '10000', '500', '-67', '75', '18', '17', '15', '30', '100', '3026', '-120', 'small', '2', '1', '0', '640', '300', '650', '650', '650', '3', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '310', '5000', '200', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '-1', '0', '14', '1', '0', '1');
	INSERT INTO `npc` VALUES ('91334', 'Fruity Grim Reaper', 'Fruity Grim Reaper', '', 'L1Monster', '3387', '78', '12000', '2000', '-80', '20', '20', '20', '20', '20', '80', '4625', '-250', 'large', '0', '2', '0', '960', '800', '0', '1000', '2000', '3', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '350', '5000', '350', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '-1', '0', '8', '1', '0', '1');

	-- HARDER BOSSES SKILLS
	INSERT INTO `mobskill` VALUES ('91322', '0', 'Fruity Phoenix', NULL, '2', '30', '0', '0', '-8', '0', '0', '0', '0', '0', '12', '10018', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91322', '1', 'Fruity Phoenix', NULL, '1', '100', '0', '0', '-2', '0', '0', '2', '0', '0', '30', '0', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91322', '2', 'Fruity Phoenix', 'Summon Taurvs', '3', '25', '0', '0', '-3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '45520', '2', '4', '0');
	INSERT INTO `mobskill` VALUES ('91323', '0', 'Fruity Iris', 'Tornado', '2', '30', '0', '0', '-4', '0', '0', '0', '0', '0', '80', '53', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91323', '1', 'Fruity Iris', NULL, '1', '100', '0', '0', '-3', '0', '0', '3', '0', '0', '30', '0', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91323', '2', 'Fruity Iris', 'Summon Tigers', '3', '25', '0', '0', '-3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '45528', '2', '4', '0');
	INSERT INTO `mobskill` VALUES ('91324', '0', 'Fruity Death', NULL, '2', '80', '0', '0', '5', '0', '0', '0', '0', '0', '0', '10057', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91324', '1', 'Fruity Death', 'Shock Stun', '2', '50', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '87', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91324', '2', 'Fruity Death', 'Cancel', '2', '20', '0', '0', '-4', '0', '0', '0', '0', '0', '0', '44', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91324', '4', 'Fruity Death', NULL, '3', '7', '0', '0', '-4', '0', '0', '0', '0', '0', '0', '0', '0', '0', '45542', '1', '1', '0');
	INSERT INTO `mobskill` VALUES ('91324', '6', 'Fruity Death', 'Summon Disciple of Death (Fallen Baphomet)', '3', '15', '0', '0', '-4', '0', '0', '0', '0', '0', '0', '0', '0', '0', '45597', '1', '1', '0');
	INSERT INTO `mobskill` VALUES ('91324', '7', 'Fruity Death', 'Summon Disciple of Death (Fallen Beleth)', '3', '15', '0', '0', '-4', '0', '0', '0', '0', '0', '0', '0', '0', '0', '45598', '1', '1', '0');
	INSERT INTO `mobskill` VALUES ('91324', '8', 'Fruity Death', 'Energy Bolt', '2', '100', '0', '0', '-1', '0', '0', '0', '0', '0', '80', '4', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91324', '9', 'Fruity Death', NULL, '1', '100', '0', '0', '-5', '0', '0', '5', '0', '0', '50', '0', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91326', '0', 'Fruity Squid', NULL, '2', '30', '0', '0', '-7', '0', '0', '0', '0', '0', '30', '10075', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91327', '0', 'Fruity Varlok', NULL, '2', '10', '0', '0', '-4', '0', '0', '0', '0', '0', '20', '10069', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91327', '1', 'Fruity Varlok', NULL, '2', '10', '0', '0', '-15', '0', '0', '0', '0', '0', '20', '10070', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91327', '2', 'Fruity Varlok', 'Shock Stun', '2', '15', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '87', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91327', '3', 'Fruity Varlok', 'Summon Lesser Demon', '3', '20', '0', '0', '-3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '45582', '1', '1', '0');
	INSERT INTO `mobskill` VALUES ('91327', '4', 'Fruity Varlok', 'Summon Succ', '3', '20', '0', '0', '-3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '45450', '1', '1', '0');
	INSERT INTO `mobskill` VALUES ('91328', '0', 'Fruity Giant Ant Queen', NULL, '2', '15', '0', '0', '5', '0', '0', '0', '0', '0', '0', '10057', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91328', '1', 'Fruity Giant Ant Queen', 'Root Debuff', '2', '10', '0', '0', '-5', '0', '0', '0', '0', '0', '30', '10071', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91328', '3', 'Fruity Giant Ant Queen', NULL, '2', '50', '0', '0', '-6', '0', '0', '0', '0', '0', '30', '10056', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91328', '4', 'Fruity Giant Ant Queen', NULL, '2', '50', '0', '0', '-15', '0', '0', '0', '0', '0', '30', '10019', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91328', '5', 'Fruity Giant Ant Queen', NULL, '1', '100', '0', '0', '-3', '0', '0', '3', '0', '0', '30', '0', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91329', '0', 'Fruity Death Knight', 'Vampiric Touch', '2', '20', '0', '0', '-3', '0', '0', '0', '0', '0', '35', '28', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91329', '1', 'Fruity Death Knight', NULL, '2', '45', '0', '0', '-6', '0', '0', '0', '0', '0', '15', '10056', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91329', '2', 'Fruity Death Knight', 'Summon Spartoi', '3', '15', '0', '0', '-3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '45455', '1', '2', '0');
	INSERT INTO `mobskill` VALUES ('91329', '3', 'Fruity Death Knight', NULL, '1', '100', '0', '0', '-1', '0', '0', '1', '0', '0', '20', '0', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91334', '0', 'Fruity Grim Reaper', NULL, '2', '60', '0', '0', '-8', '0', '0', '0', '0', '0', '45', '10062', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91334', '1', 'Fruity Grim Reaper', NULL, '2', '60', '0', '0', '-15', '0', '0', '0', '0', '0', '40', '10012', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91334', '2', 'Fruity Grim Reaper', NULL, '1', '100', '0', '0', '-2', '0', '0', '2', '2', '1', '80', '0', '0', '0', '0', '0', '0', '0');

	-- BIG FAT BOSS
	INSERT INTO `npc` VALUES ('91330', 'Fruity Valakas', 'Fruity Valakas', '', 'L1Monster', '2001', '80', '16000', '4500', '-99', '78', '20', '8', '22', '18', '180', '9026', '10000', 'large', '4', '2', '0', '480', '1840', '2520', '1840', '1840', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '1000', '5000', '500', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '91331', '5306', '0', '1', '0', '1');
	INSERT INTO `npc` VALUES ('91331', 'Kindergarten Fafurion', 'Kindergarten Fafurion', '', 'L1Monster', '1590', '80', '11000', '5000', '-99', '78', '20', '8', '22', '18', '180', '8650', '10000', 'large', '8', '2', '0', '480', '1600', '3480', '1600', '1600', '0', '0', '1', '1', '1', '1', '', '0', '-1', '-1', '0', '0', '0', '5000', '1000', '5000', '500', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '91332', '5306', '0', '1', '0', '1');
	INSERT INTO `npc` VALUES ('91332', 'Baby Lindvior', 'Baby Lindvior', '', 'L1Monster', '2544', '80', '10000', '900', '-99', '66', '21', '18', '20', '18', '180', '7570', '10000', 'large', '1', '2', '0', '480', '1600', '2240', '1600', '1600', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '5000', '1000', '5000', '500', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '91333', '5306', '0', '1', '0', '1');
	INSERT INTO `npc` VALUES ('91333', 'Crying Antharas', 'Crying Antharas', '', 'L1Monster', '1245', '85', '12200', '800', '-99', '80', '21', '10', '20', '18', '180', '8101', '10000', 'large', '2', '2', '0', '480', '2240', '1960', '2240', '2240', '0', '1', '0', '1', '1', '1', '', '0', '-1', '-1', '0', '0', '0', '5000', '1000', '5000', '500', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '-1', '0', '0', '1', '0', '1');

	-- Antharas
	INSERT INTO `mobskill` VALUES ('91333', '0', 'Antharas', NULL, '2', '100', '50', '0', '-15', '3', '0', '0', '0', '0', '1000', '10054', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91333', '1', 'Antharas', NULL, '2', '2', '0', '0', '-9', '0', '0', '0', '0', '0', '0', '10027', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91333', '2', 'Antharas', 'Eruption', '2', '20', '0', '0', '3', '0', '0', '0', '0', '0', '200', '45', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91333', '3', 'Antharas', NULL, '2', '50', '0', '0', '5', '0', '0', '0', '0', '0', '50', '10054', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91333', '4', 'Antharas', NULL, '2', '50', '0', '0', '-4', '0', '0', '0', '0', '0', '50', '10054', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91333', '5', 'Antharas', NULL, '1', '100', '75', '0', '-3', '0', '0', '3', '3', '4', '200', '0', '0', '1', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91333', '6', 'Antharas', NULL, '1', '10', '0', '0', '-2', '0', '0', '2', '0', '0', '150', '0', '0', '5', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91333', '7', 'Antharas', NULL, '1', '10', '0', '0', '-2', '0', '0', '2', '0', '0', '150', '0', '0', '12', '0', '0', '0', '0');


	-- Valakas
	INSERT INTO `mobskill` VALUES ('91330', '0', 'Valakas', NULL, '2', '100', '50', '0', '-15', '3', '0', '0', '0', '0', '1000', '10052', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91330', '1', 'Valakas', NULL, '2', '50', '0', '0', '5', '0', '0', '0', '0', '0', '50', '10052', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91330', '2', 'Valakas', NULL, '2', '50', '0', '0', '0', '0', '0', '0', '0', '0', '50', '10052', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91330', '3', 'Valakas', NULL, '2', '2', '0', '0', '-9', '0', '0', '0', '0', '0', '0', '10028', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91330', '4', 'Valakas', NULL, '1', '100', '75', '0', '-3', '0', '0', '3', '3', '4', '200', '0', '0', '1', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91330', '5', 'Valakas', NULL, '1', '10', '0', '0', '-2', '0', '0', '2', '0', '0', '150', '0', '0', '5', '0', '0', '0', '0');

	-- Lindvior
	INSERT INTO `mobskill` VALUES ('91332', '0', 'Lindvior', NULL, '2', '100', '50', '0', '-15', '3', '0', '0', '0', '0', '1000', '10053', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91332', '1', 'Lindvior', NULL, '2', '2', '0', '0', '-9', '0', '0', '0', '0', '0', '0', '10026', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91332', '2', 'Lindvior', NULL, '2', '50', '0', '0', '5', '0', '0', '0', '0', '0', '50', '10053', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91332', '3', 'Lindvior', NULL, '2', '50', '0', '0', '-4', '0', '0', '0', '0', '0', '50', '10053', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91332', '4', 'Lindvior', NULL, '1', '100', '75', '0', '-3', '0', '0', '3', '3', '4', '200', '0', '0', '1', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91332', '5', 'Lindvior', NULL, '1', '10', '0', '0', '-2', '0', '0', '2', '0', '0', '150', '0', '0', '5', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91332', '6', 'Lindvior', NULL, '1', '10', '0', '0', '-2', '0', '0', '2', '0', '0', '150', '0', '0', '12', '0', '0', '0', '0');

	-- Fafurion
	INSERT INTO `mobskill` VALUES ('91331', '0', 'Fafurion', NULL, '2', '100', '50', '0', '-15', '3', '0', '0', '0', '0', '1000', '10051', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91331', '1', 'Fafurion', NULL, '2', '50', '0', '0', '5', '0', '0', '0', '0', '0', '50', '10051', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91331', '2', 'Fafurion', NULL, '2', '50', '0', '0', '0', '0', '0', '0', '0', '0', '50', '10051', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91331', '3', 'Fafurion', NULL, '2', '10', '0', '0', '-4', '0', '0', '0', '0', '0', '100', '10050', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91331', '4', 'Fafurion', NULL, '1', '100', '75', '0', '-3', '0', '0', '3', '3', '4', '200', '0', '0', '1', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91331', '5', 'Fafurion', NULL, '1', '10', '0', '0', '-2', '0', '0', '2', '0', '0', '150', '0', '0', '5', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91331', '6', 'Fafurion', NULL, '1', '10', '0', '0', '-2', '0', '0', '2', '0', '0', '150', '0', '0', '12', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91331', '7', 'Fafurion', NULL, '1', '10', '0', '0', '-3', '0', '0', '3', '3', '4', '200', '0', '0', '25', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91331', '8', 'Fafurion', NULL, '2', '2', '0', '0', '-9', '0', '0', '0', '0', '0', '0', '10029', '0', '0', '0', '0', '0', '0');

	-- BIG FAT BOSS 2
	INSERT INTO `npc` VALUES ('91335', 'Bossy Girtas', '$4305', '', 'L1Monster', '5620', '99', '28000', '5000', '-99', '80', '21', '18', '20', '20', '99', '9802', '-10000', 'large', '0', '10', '0', '0', '1600', '1700', '1600', '1600', '0', '0', '0', '1', '1', '1', '', '0', '-1', '-1', '0', '0', '0', '5000', '500', '5000', '500', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '-1', '0', '0', '1', '0', '0');

	INSERT INTO `mobskill` VALUES ('91335', '0', 'Bossy Girtas', '', '2', '100', '18', '0', '-15', '0', '0', '0', '0', '0', '20', '10130', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91335', '1', 'Bossy Girtas', '', '2', '10', '0', '0', '-15', '0', '0', '0', '0', '0', '80', '10126', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91335', '2', 'Bossy Girtas', '', '2', '20', '0', '0', '0', '0', '0', '0', '0', '0', '0', '10128', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91335', '3', 'Bossy Girtas', '', '2', '20', '0', '0', '0', '0', '0', '0', '0', '0', '15', '10129', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91335', '4', 'Bossy Girtas', '', '2', '20', '0', '0', '0', '0', '0', '0', '0', '0', '40', '10127', '0', '0', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91335', '5', 'Bossy Girtas', '', '1', '60', '0', '0', '0', '0', '0', '3', '0', '0', '30', '0', '0', '5', '0', '0', '0', '0');
	INSERT INTO `mobskill` VALUES ('91335', '6', 'Bossy Girtas', '', '1', '100', '0', '0', '0', '0', '0', '3', '0', '0', '30', '0', '0', '1', '0', '0', '0', '0');

	-- SPAWNS
	INSERT INTO `spawnlist` VALUES ('801500734', 'Sakura Baphomet', '50', '91316', '0', '0', '0', '0', '0', '32315', '32852', '32734', '33236', '0', '60', '120', '0', '0', '100', '0', '0', '1', '8', '2', '100');
	INSERT INTO `spawnlist` VALUES ('801500735', 'Sakura Mambo Rabbit', '50', '91317', '0', '0', '0', '0', '0', '32315', '32852', '32734', '33236', '0', '60', '120', '0', '0', '100', '0', '0', '1', '8', '2', '100');
	INSERT INTO `spawnlist` VALUES ('801500736', 'Sakura Beleth', '50', '91318', '0', '0', '0', '0', '0', '32315', '32852', '32734', '33236', '0', '60', '120', '0', '0', '100', '0', '0', '1', '8', '2', '100');
	INSERT INTO `spawnlist` VALUES ('801500737', 'Sakura Zenith Queen', '50', '91319', '0', '0', '0', '0', '0', '32315', '32852', '32734', '33236', '0', '60', '120', '0', '0', '100', '0', '0', '1', '8', '2', '100');
	INSERT INTO `spawnlist` VALUES ('801500738', 'Sakura Spirit', '50', '91320', '0', '0', '0', '0', '0', '32315', '32852', '32734', '33236', '0', '60', '120', '0', '0', '100', '0', '0', '1', '8', '2', '100');
	INSERT INTO `spawnlist` VALUES ('801500739', 'Fruity Phoenix', '10', '91322', '0', '0', '0', '0', '0', '32315', '32852', '32734', '33236', '0', '60', '120', '0', '0', '100', '0', '0', '1', '8', '2', '100');
	INSERT INTO `spawnlist` VALUES ('801500740', 'Fruity Iris', '10', '91323', '0', '0', '0', '0', '0', '32315', '32852', '32734', '33236', '0', '60', '120', '0', '0', '100', '0', '0', '1', '8', '2', '100');
	INSERT INTO `spawnlist` VALUES ('801500741', 'Fruity Death', '10', '91324', '0', '0', '0', '0', '0', '32315', '32852', '32734', '33236', '0', '60', '120', '0', '0', '100', '0', '0', '1', '8', '2', '100');
	-- Remove squid for now, no drops, easier to comment out.
	-- INSERT INTO `spawnlist` VALUES ('801500742', 'Fruity Squid', '10', '91326', '0', '0', '0', '0', '0', '32315', '32852', '32734', '33236', '0', '60', '120', '0', '0', '100', '0', '0', '1', '8', '2', '100');
	INSERT INTO `spawnlist` VALUES ('801500743', 'Fruity Varlok', '10', '91327', '0', '0', '0', '0', '0', '32315', '32852', '32734', '33236', '0', '60', '120', '0', '0', '100', '0', '0', '1', '8', '2', '100');
	INSERT INTO `spawnlist` VALUES ('801500744', 'Fruity Queen', '10', '91328', '0', '0', '0', '0', '0', '32315', '32852', '32734', '33236', '0', '60', '120', '0', '0', '100', '0', '0', '1', '8', '2', '100');
	INSERT INTO `spawnlist` VALUES ('801500745', 'Fruity Death Knight', '10', '91329', '0', '0', '0', '0', '0', '32315', '32852', '32734', '33236', '0', '60', '120', '0', '0', '100', '0', '0', '1', '8', '2', '100');
	INSERT INTO `spawnlist` VALUES ('801500746', 'Fruity Grim Reaper', '10', '91334', '0', '0', '0', '0', '0', '32315', '32852', '32734', '33236', '0', '60', '120', '0', '0', '100', '0', '0', '1', '8', '2', '100');

	

	-- DROPSSSSSSSSSS
	-- # Baphomet
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '109', 'Staff of Baphomet', '1', '1', '1200');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '20117', 'Armor of Baphomet', '1', '1', '500');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '20284', 'Ring of Summon Control', '1', '1', '100');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '20285', 'Ring of Water Resistance', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '20288', 'Ring of Teleport Control', '1', '1', '1500');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '40013', 'Haste Potion', '2', '5', '150000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '40014', 'Potion of Bravery', '2', '5', '150000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '40015', 'Potion of Mana', '2', '5', '150000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '40016', 'Potion of Wisdom', '2', '5', '150000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '40018', 'Greater Haste Potion', '2', '5', '150000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '40044', 'Diamond', '1', '2', '150000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '40046', 'Sapphire', '1', '2', '150000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '40047', 'Emerald', '1', '2', '150000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '40048', 'High Quality Diamond', '1', '2', '150000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '40050', 'High Quality Sapphire', '1', '2', '150000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '40051', 'High Quality Emerald', '1', '2', '150000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '40093', 'Blank Scroll (Level 4)', '1', '2', '150000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '40094', 'Blank Scroll (Level 5)', '1', '2', '150000');
	INSERT INTO `droplist` VALUES ('91316', 'Sakura Baphomet', '81', 'Blessed Bravery Edoryu', '1', '2', '5000');

	-- # Beleth
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '110', 'Staff of Beleth', '1', '1', '1200');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '20204', 'Boots of Beleth', '1', '1', '1200');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '20267', 'Amulet of Wisdom', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '20284', 'Ring of Summon Control', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '20288', 'Ring of Teleport Control', '1', '1', '1500');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '20302', 'Ring of Wind Resistance', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '40013', 'Haste Potion', '1', '5', '300000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '40014', 'Potion of Bravery', '1', '5', '300000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '40015', 'Potion of Mana', '1', '5', '300000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '40016', 'Potion of Wisdom', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '40018', 'Greater Haste Potion', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '40044', 'Diamond', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '40045', 'Ruby', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '40048', 'High Quality Diamond', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '40049', 'High Quality Ruby', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '40052', 'Highest Quality Diamond', '1', '1', '30000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '40053', 'Highest Quality Ruby', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '40093', 'Blank Scroll (Level 4)', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '40094', 'Blank Scroll (Level 5)', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '220154', 'Plate Mail', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91318', 'Sakura Beleth', '162', 'Blessed Bravery Claw', '1', '1', '5000');
	
	-- # Mambo Rabbit
	INSERT INTO `droplist` VALUES ('91317', 'Sakura Mambo Rabbit', '20172', 'Glove of Ice Spirit', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91317', 'Sakura Mambo Rabbit', '20177', 'Glove of Dark Spirit', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91317', 'Sakura Mambo Rabbit', '20181', 'Glove of Fire Spirit', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91317', 'Sakura Mambo Rabbit', '20189', 'Glove of Wind Spirit', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91317', 'Sakura Mambo Rabbit', '40013', 'Haste Potion', '1', '1', '100000');
	INSERT INTO `droplist` VALUES ('91317', 'Sakura Mambo Rabbit', '20016', 'Mambo Hat', '1', '1', '1000');
	INSERT INTO `droplist` VALUES ('91317', 'Sakura Mambo Rabbit', '20112', 'Mambo Coat', '1', '1', '1000');
	INSERT INTO `droplist` VALUES ('91317', 'Sakura Mambo Rabbit', '40306', 'Relic of Eva', '1', '1', '10500');
	INSERT INTO `droplist` VALUES ('91317', 'Sakura Mambo Rabbit', '9', 'Oriharukon Dagger', '1', '1', '1500');
	INSERT INTO `droplist` VALUES ('91317', 'Sakura Mambo Rabbit', '20040', 'Cap of Caspa', '1', '1', '600');
	INSERT INTO `droplist` VALUES ('91317', 'Sakura Mambo Rabbit', '20029', 'Cap of Sema', '1', '1', '600');
	INSERT INTO `droplist` VALUES ('91317', 'Sakura Mambo Rabbit', '20059', 'Water Cloak', '1', '1', '10000');
	INSERT INTO `droplist` VALUES ('91317', 'Sakura Mambo Rabbit', '120280', 'Ring of immunity To Magic', '1', '1', '1200');

	-- # Zenith Queen
	INSERT INTO `droplist` VALUES ('91319', 'Sakura Zenith Queen', '57', 'Tsurugi', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91319', 'Sakura Zenith Queen', '20187', 'Power Gloves', '1', '1', '12000');
	INSERT INTO `droplist` VALUES ('91319', 'Sakura Zenith Queen', '20298', 'Ring of Zenith', '1', '1', '6000');
	INSERT INTO `droplist` VALUES ('91319', 'Sakura Zenith Queen', '40006', 'Pine Wand', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91319', 'Sakura Zenith Queen', '40008', 'Maple Wand', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91319', 'Sakura Zenith Queen', '40013', 'Haste Potion', '1', '3', '300000');
	INSERT INTO `droplist` VALUES ('91319', 'Sakura Zenith Queen', '40014', 'Potion of Bravery', '1', '3', '300000');
	INSERT INTO `droplist` VALUES ('91319', 'Sakura Zenith Queen', '40016', 'Potion of Wisdom', '1', '3', '300000');
	INSERT INTO `droplist` VALUES ('91319', 'Sakura Zenith Queen', '40018', 'Greater Haste Potion', '1', '3', '300000');
	INSERT INTO `droplist` VALUES ('91319', 'Sakura Zenith Queen', '100181', 'Blessed Yumi', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91319', 'Sakura Zenith Queen', '20017', 'Crown of Mummy Lord', '1', '1', '5000');

	-- # Spirit
	INSERT INTO `droplist` VALUES ('91320', 'Sakura Spirit', '20187', 'Power Gloves', '1', '1', '50000');
	INSERT INTO `droplist` VALUES ('91320', 'Sakura Spirit', '40018', 'Greater Haste Potion', '1', '3', '150000');
	INSERT INTO `droplist` VALUES ('91320', 'Sakura Spirit', '120280', 'Ring of immunity to magic', '1', '1', '8000');
	INSERT INTO `droplist` VALUES ('91320', 'Sakura Spirit', '120302', 'Ring of Earth Resistance', '1', '1', '10000');
	INSERT INTO `droplist` VALUES ('91320', 'Sakura Spirit', '30001', 'Fortified T-shirts', '1', '1', '50000');
	INSERT INTO `droplist` VALUES ('91320', 'Sakura Spirit', '126', 'Blessed Staff of Mana', '1', '1', '50000');
	INSERT INTO `droplist` VALUES ('91320', 'Sakura Spirit', '20054', 'Earth Cloak', '1', '1', '10000');
	INSERT INTO `droplist` VALUES ('91320', 'Sakura Spirit', '20227', 'Shield of Medusa', '1', '1', '15000');
	INSERT INTO `droplist` VALUES ('91320', 'Sakura Spirit', '20175', 'Crystal Gloves', '1', '1', '15000');

	-- # HARDER STUFF

	-- # Phoenix
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '20281', 'Ring of Polymorph Control', '1', '1', '6000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '20304', 'Ring of Fire Resistance', '1', '1', '10000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '40013', 'Haste Potion', '2', '5', '300000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '40014', 'Potion of Bravery', '2', '5', '300000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '40015', 'Potion of Mana', '2', '5', '300000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '40016', 'Potion of Wisdom', '2', '5', '300000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '40018', 'Greater Haste Potion', '2', '5', '300000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '40048', 'High Quality Diamond', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '40049', 'High Quality Ruby', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '40050', 'High Quality Sapphire', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '40051', 'High Quality Emerald', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '40089', 'Scroll of Resurrection', '1', '2', '750000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '40093', 'Blank Scroll (Level 4)', '1', '2', '500000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '40094', 'Blank Scroll (Level 5)', '1', '2', '500000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '40305', 'Relic of Paagrio', '1', '3', '50000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '49134', 'Memory Crystal(JoyofPain)', '1', '1', '10000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '450001', 'Paagrios Hatred', '1', '1', '3000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '189', 'Kaiser Crossbow', '1', '1', '10000');
	INSERT INTO `droplist` VALUES ('91322', 'Fruity Phoenix', '20071', 'Fire Cloak', '1', '1', '10000');

	-- # Iris
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '20187', 'Power Gloves', '1', '1', '20000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '20264', 'Amulet of Strength', '1', '1', '1000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '20260', 'Amulet of Iris', '1', '1', '1500');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '20281', 'Ring of Polymorph Control', '1', '1', '1000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '20285', 'Ring of Water Resistance', '1', '1', '2500');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '20300', 'Ring of Earth Resistance', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '20302', 'Ring of Wind Resistance', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '20304', 'Ring of Fire Resistance', '1', '1', '2500');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '40014', 'Potion of Bravery', '2', '5', '400000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '40015', 'Potion of Mana', '2', '5', '400000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '40016', 'Potion of Wisdom', '2', '5', '400000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '40018', 'Greater Haste Potion', '2', '5', '400000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '40045', 'Ruby', '1', '1', '400000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '40049', 'High Quality Ruby', '1', '1', '400000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '40053', 'Highest Quality Ruby', '1', '1', '400000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '40089', 'Scroll of Resurrection', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '40093', 'Blank Scroll (Level 4)', '2', '5', '400000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '40094', 'Blank Scroll (Level 5)', '2', '5', '400000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '40202', 'Spellbook(FullHeal)', '1', '1', '85000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '40210', 'Spellbook(LightningStorm)', '1', '1', '20000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '40225', 'Spellbook(FreezingBlizzard)', '1', '1', '10000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '51', 'Gold Scepter', '1', '1', '10000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '20061', 'Wind Cloak', '1', '1', '10000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '21031', 'Int T-shirt', '1', '1', '15000');
	INSERT INTO `droplist` VALUES ('91323', 'Fruity Iris', '20074', 'Silver Cloak', '1', '1', '5000');

	-- # Death
	INSERT INTO `droplist` VALUES ('91324', 'Fruity Death', '40015', 'Potion of Mana', '1', '1', '50000');
	INSERT INTO `droplist` VALUES ('91324', 'Fruity Death', '40213', 'Spellbook(ImmuneToHarm)', '1', '1', '100');
	INSERT INTO `droplist` VALUES ('91324', 'Fruity Death', '40524', 'Black Blood Stone', '1', '1', '10000');
	INSERT INTO `droplist` VALUES ('91324', 'Fruity Death', '20075', 'Cloak of Death', '1', '1', '5000	');
	INSERT INTO `droplist` VALUES ('91324', 'Fruity Death', '20144', 'Armor of Death', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91324', 'Fruity Death', '20183', 'Scale of Death', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91324', 'Fruity Death', '40014', 'Potion of Bravery', '5', '15', '300000');
	INSERT INTO `droplist` VALUES ('91324', 'Fruity Death', '40443', 'Black Lump of Pure Mithril', '1', '5', '300000');
	INSERT INTO `droplist` VALUES ('91324', 'Fruity Death', '40444', 'Black Lump of Rough Mithril', '1', '5', '300000');
	INSERT INTO `droplist` VALUES ('91324', 'Fruity Death', '40678', 'Fragment of Soul Stone', '5', '10', '1000000');
	INSERT INTO `droplist` VALUES ('91324', 'Fruity Death', '20025', 'Baltuzar Cap', '1', '1', '800');

	-- # Varlok
	INSERT INTO `droplist` VALUES ('91327', 'Fruity Varlok', '40443', 'Black Lump of Pure Mithril', '1', '1', '30000');
	INSERT INTO `droplist` VALUES ('91327', 'Fruity Varlok', '40444', 'Black Lump of Rough Mithril', '1', '1', '30000');
	INSERT INTO `droplist` VALUES ('91327', 'Fruity Varlok', '40524', 'Black Blood Stone', '10', '40', '500000');
	INSERT INTO `droplist` VALUES ('91327', 'Fruity Varlok', '40718', 'Fragment of Blood Stone', '5', '10', '100000');
	/*INSERT INTO `droplist` VALUES ('91327', 'Fruity Varlok', '41148', 'TechnicalDocument(CounterBarrier)', '1', '1', '500');  commented out, per soren  */
	INSERT INTO `droplist` VALUES ('91327', 'Fruity Varlok', '190', 'Sayha Bow', '1', '1', '500');
	INSERT INTO `droplist` VALUES ('91327', 'Fruity Varlok', '164', 'Kaiser Claw', '1', '1', '1000');
	INSERT INTO `droplist` VALUES ('91327', 'Fruity Varlok', '21028', 'Str T-shirt', '1', '1', '15000');
	INSERT INTO `droplist` VALUES ('91327', 'Fruity Varlok', '21032', 'Con T-shirt', '1', '1', '15000');

	-- # Ant Queen
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '20049', 'Golden Wing of Giant Ant Queen', '1', '1', '850');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '20050', 'Silver Wing of Giant Ant Queen', '1', '1', '850');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '20300', 'Ring of Earth Resistance', '1', '1', '10000');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '40015', 'Potion of Mana', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '40016', 'Potion of Wisdom', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '40018', 'Greater Haste Potion', '1', '3', '300000');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '40045', 'Ruby', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '40047', 'Emerald', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '40049', 'High Quality Ruby', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '40051', 'High Quality Emerald', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '40053', 'Highest Quality Ruby', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '40055', 'Highest Quality Emerald', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '40093', 'Blank Scroll (Level 4)', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '40094', 'Blank Scroll (Level 5)', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '40216', 'Spellbook(DecayPotion)', '1', '1', '10000');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '40304', 'Relic of Maphr', '1', '1', '10500');
	INSERT INTO `droplist` VALUES ('91328', 'Fruity Queen', '450002', 'Maph Retribution', '1', '1', '3000	 ');

	-- # Death Knight
	INSERT INTO `droplist` VALUES ('91329', 'Fruity Death Knight', '58', 'Fire Sword of Death Knight', '1', '1', '1000');
	INSERT INTO `droplist` VALUES ('91329', 'Fruity Death Knight', '189', 'kaiser Edoryu', '1', '1', '1500');
	INSERT INTO `droplist` VALUES ('91329', 'Fruity Death Knight', '20010', 'Death Knight Helmet', '1', '1', '4000');
	INSERT INTO `droplist` VALUES ('91329', 'Fruity Death Knight', '20100', 'Death Knight Armor', '1', '1', '4000');
	INSERT INTO `droplist` VALUES ('91329', 'Fruity Death Knight', '20264', 'Amulet of Strength', '1', '1', '35000');
	INSERT INTO `droplist` VALUES ('91329', 'Fruity Death Knight', '20266', 'Amulet of Intelligence', '1', '1', '35000');
	INSERT INTO `droplist` VALUES ('91329', 'Fruity Death Knight', '20281', 'Ring of Polymorph Control', '1', '1', '6500');
	INSERT INTO `droplist` VALUES ('91329', 'Fruity Death Knight', '20284', 'Ring of Summon Control', '1', '1', '4500');
	INSERT INTO `droplist` VALUES ('91329', 'Fruity Death Knight', '20288', 'Ring of Teleport Control', '1', '1', '3500');
	INSERT INTO `droplist` VALUES ('91329', 'Fruity Death Knight', '20302', 'Ring of Wind Resistance', '1', '1', '15000');
	INSERT INTO `droplist` VALUES ('91329', 'Fruity Death Knight', '21029', 'Dex T-shirt', '1', '1', '15000');

	-- # Grim Reaper
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '20074', 'Silver Cloak', '1', '1', '8000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '20128', 'Crystal Plate Mail', '1', '1', '35000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '20187', 'Power Gloves', '1', '1', '35000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '20281', 'Ring of Polymorph Control', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '20284', 'Ring of Summon Control', '1', '1', '5000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '20285', 'Ring of Water Resistance', '1', '1', '20000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '20300', 'Ring of Earth Resistance', '1', '1', '20000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '20302', 'Ring of Wind Resistance', '1', '1', '20000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '20304', 'Ring of Fire Resistance', '1', '1', '20000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '40013', 'Haste Potion', '2', '6', '300000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '40014', 'Potion of Bravery', '2', '6', '300000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '40016', 'Potion of Wisdom', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '40018', 'Greater Haste Potion', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '40093', 'Blank Scroll (Level 4)', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '40094', 'Blank Scroll (Level 5)', '1', '1', '300000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '59', 'Sword of Knight Vald', '1', '1', '1000');
	INSERT INTO `droplist` VALUES ('91334', 'Fruity Grim Reaper', '20018', 'Merkyor Cap', '1', '1', '800');

	-- # Add metals to the harder bosses at ~5% base 1-3.
	INSERT INTO droplist VALUES('91334', 'Fruity Grim Reaper', '40468', 'Rough Silver Piece', '1', '3', '50000');
	INSERT INTO droplist VALUES('91334', 'Fruity Grim Reaper', '40441', 'Rough Platinum Piece', '1', '3', '50000');
	INSERT INTO droplist VALUES('91334', 'Fruity Grim Reaper', '40489', 'Rough Gold Piece', '1','3', '50000');
	
	INSERT INTO droplist VALUES('91327', 'Fruity Varlok', '40468', 'Rough Silver Piece', '1', '3', '50000');
	INSERT INTO droplist VALUES('91327', 'Fruity Varlok', '40441', 'Rough Platinum Piece', '1', '3', '50000');
	INSERT INTO droplist VALUES('91327', 'Fruity Varlok', '40489', 'Rough Gold Piece', '1','3', '50000');
	
	INSERT INTO droplist VALUES('91323', 'Fruity Iris', '40468', 'Rough Silver Piece', '1', '3', '50000');
	INSERT INTO droplist VALUES('91323', 'Fruity Iris', '40441', 'Rough Platinum Piece', '1', '3', '50000');
	INSERT INTO droplist VALUES('91323', 'Fruity Iris', '40489', 'Rough Gold Piece', '1','3', '50000');
	
	INSERT INTO droplist VALUES('91324', 'Fruity Death', '40468', 'Rough Silver Piece', '1', '3', '50000');
	INSERT INTO droplist VALUES('91324', 'Fruity Death', '40441', 'Rough Platinum Piece', '1', '3', '50000');
	INSERT INTO droplist VALUES('91324', 'Fruity Death', '40489', 'Rough Gold Piece', '1','3', '50000');
	
	INSERT INTO droplist VALUES('91328', 'Fruity Queen', '40468', 'Rough Silver Piece', '1', '3', '50000');
	INSERT INTO droplist VALUES('91328', 'Fruity Queen', '40441', 'Rough Platinum Piece', '1', '3', '50000');
	INSERT INTO droplist VALUES('91328', 'Fruity Queen', '40489', 'Rough Gold Piece', '1','3', '50000');

	-- # Add accessory enchant scrolls for easier bosses
	INSERT INTO droplist VALUES ('91316', 'Sakura Baphomet', '49148', 'Scroll of Enchant Accessory', '1', '1', '10000');
	INSERT INTO droplist VALUES ('91317', 'Sakura Mambo Rabbit', '49148', 'Scroll of Enchant Accessory', '1', '1', '10000');
	INSERT INTO droplist VALUES ('91318', 'Sakura Beleth', '49148', 'Scroll of Enchant Accessory', '1', '1', '10000');
	INSERT INTO droplist VALUES ('91319', 'Sakura Zenith Queen', '49148', 'Scroll of Enchant Accessory', '1', '1', '10000');
	INSERT INTO droplist VALUES ('91320', 'Sakura Spirit', '49148', 'Scroll of Enchant Accessory', '1', '1', '10000');

	-- # Add accessory enchant scrolls for harder bosses
	INSERT INTO droplist VALUES('91334', 'Fruity Grim Reaper', '49148', 'Scroll of Enchant Accessory', '1','1', '20000');
	INSERT INTO droplist VALUES('91327', 'Fruity Varlok', '49148', 'Scroll of Enchant Accessory', '1','1', '20000');
	INSERT INTO droplist VALUES('91323', 'Fruity Iris', '49148', 'Scroll of Enchant Accessory', '1','1', '20000');
	INSERT INTO droplist VALUES('91324', 'Fruity Death', '49148', 'Scroll of Enchant Accessory', '1','1', '20000');
	INSERT INTO droplist VALUES('91328', 'Fruity Queen', '49148', 'Scroll of Enchant Accessory', '1','1', '20000');
	
	 /* Suggest making stat tshirts tradeable or simply removing them TODO add spawn and drops for Girtas and Dragon.. or leave them out */
	UPDATE armor SET `trade` = '1' where item_id in ('21028', '21029', '21030', '21031');
	-- To change stat t-shirts back to untradeable
	-- UPDATE armor SET 'trade' = '0' where item_id in ('21028', '21029', '21030', '21031');
   
