-- update 26

-- reduce lich's magic mobskill leverage (30 -> 25)
update mobskill set leverage = 25 where mobid = 45672 and actno in (0, 1);



-- update 27

-- increase a-g's aoe range to prevent cliffing (-10 -> -11)
update mobskill set trirange = -11 where mobid = 45610 and actno = 0;

-- increase bone dragon mobskill leverage (3 -> 4)
update mobskill set leverage = 4 where mobid = 45522 and actno = 0;



-- update 28

-- add FI Drake magic attack
insert into mobskill values (45578, 0, 'Drake', 1, 20, 0, 0, -2, 0, 0, 2, 1, 0, 10, 0, 1064, 30, 0, 0, 0, 0);



-- update 30

-- merge new mobskill entries
INSERT INTO `mobskill` VALUES ('45413', '0', 'Diego', '1', '50', '0', '0', '-8', '0', '0', '2', '0', '0', '30', '0', '1812', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45474', '0', 'Dark Forester', '2', '40', '0', '0', '-4', '0', '0', '0', '0', '0', '0', '10043', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45512', '0', 'Hell Bound', '1', '100', '0', '0', '2', '2', '0', '2', '0', '0', '30', '0', '4646', '3', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45517', '0', 'Spiritologist of Blood', '2', '70', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10086', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45517', '1', 'Spiritologist of Blood', '2', '30', '0', '0', '-7', '0', '0', '0', '0', '0', '0', '10087', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45523', '0', 'Lord of Darkness', '2', '70', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10088', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45523', '1', 'Lord of Darkness', '2', '30', '0', '0', '-7', '0', '0', '0', '0', '0', '0', '10089', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45526', '0', 'Crimson Drake', '1', '100', '0', '0', '5', '0', '0', '5', '0', '0', '30', '0', '4651', '3', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45527', '0', 'Blood Rain Knight', '1', '50', '0', '0', '-1', '0', '0', '1', '0', '0', '5', '0', '4631', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45548', '0', 'Jose', '1', '20', '0', '0', '-4', '0', '0', '3', '5', '5', '80', '0', '4700', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45577', '0', 'Brigade Commander Dark Fencer', '2', '70', '0', '0', '-6', '0', '0', '0', '0', '0', '0', '10083', '4630', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45577', '1', 'Brigade Commander Dark Fencer', '2', '30', '0', '0', '-3', '0', '0', '0', '0', '0', '30', '10084', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45588', '0', 'Division Commander Sinclair', '2', '30', '0', '0', '-15', '0', '0', '0', '0', '0', '30', '74', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45607', '0', 'Evil Power Squad Leader Kybar', '2', '70', '0', '0', '-6', '0', '0', '0', '0', '0', '0', '10083', '4630', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45607', '1', 'Evil Power Squad Leader Kybar', '2', '30', '0', '0', '-3', '0', '0', '0', '0', '0', '30', '10084', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45608', '0', 'Mercenary Commander Mephaisto', '2', '70', '0', '0', '-6', '0', '0', '0', '0', '0', '0', '10083', '4630', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45608', '1', 'Mercenary Commander Mephaisto', '2', '30', '0', '0', '-3', '0', '0', '0', '0', '0', '30', '10084', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45615', '0', 'Bright Magic Troup Leader Crepus', '2', '70', '0', '0', '-6', '0', '0', '0', '0', '0', '0', '10083', '4630', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45615', '1', 'Bright Magic Troup Leader Crepus', '2', '30', '0', '0', '-3', '0', '0', '0', '0', '0', '30', '10084', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45676', '0', 'Bright Magic King Hellvine', '3', '5', '0', '0', '-3', '0', '0', '0', '0', '0', '0', '0', '0', '4540', '45517', '1', '2', '0');
INSERT INTO `mobskill` VALUES ('45676', '1', 'Bright Magic King Hellvine', '3', '5', '0', '0', '-3', '0', '0', '0', '0', '0', '0', '0', '0', '4540', '45523', '1', '2', '0');
INSERT INTO `mobskill` VALUES ('45676', '2', 'Bright Magic King Hellvine', '2', '30', '0', '0', '-15', '0', '0', '0', '0', '0', '30', '74', '4538', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45831', '0', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-6', '0', '0', '0', '0', '0', '5', '10081', '5722', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45831', '1', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-4', '0', '0', '0', '0', '0', '5', '10082', '5635', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45832', '0', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-6', '0', '0', '0', '0', '0', '5', '10081', '5722', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45832', '1', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-4', '0', '0', '0', '0', '0', '5', '10082', '5635', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45833', '0', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-6', '0', '0', '0', '0', '0', '5', '10081', '5722', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45833', '1', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-4', '0', '0', '0', '0', '0', '5', '10082', '5635', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45834', '0', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-6', '0', '0', '0', '0', '0', '5', '10081', '5722', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45834', '1', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-4', '0', '0', '0', '0', '0', '5', '10082', '5635', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45835', '0', 'Cursed Dark Elf Warrior', '2', '15', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '87', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45839', '0', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-6', '0', '0', '0', '0', '0', '5', '10081', '5722', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45839', '1', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-4', '0', '0', '0', '0', '0', '5', '10082', '5635', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45840', '0', 'Cursed Dark Elf Warrior', '2', '15', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '87', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45842', '0', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-6', '0', '0', '0', '0', '0', '5', '10081', '5722', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45842', '1', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-4', '0', '0', '0', '0', '0', '5', '10082', '5635', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45843', '0', 'Cursed Dark Elf Warrior', '2', '15', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '87', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45847', '0', 'Cursed Dark Elf Wizard', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '5', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45847', '1', 'Cursed Dark Elf Wizard', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '5', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45847', '2', 'Cursed Dark Elf Wizard', '2', '30', '0', '0', '-1', '0', '0', '0', '0', '0', '5', '10085', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45849', '0', 'Cursed Dark Elf Warrior', '2', '15', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '87', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45850', '0', 'Dark Forester', '2', '40', '0', '0', '-4', '0', '0', '0', '0', '0', '0', '10043', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45851', '0', 'Dark Forester', '2', '40', '0', '0', '-4', '0', '0', '0', '0', '0', '0', '10043', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45853', '0', 'Cursed Dark Elf Wizard', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '5', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45853', '1', 'Cursed Dark Elf Wizard', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '5', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45853', '2', 'Cursed Dark Elf Wizard', '2', '30', '0', '0', '-1', '0', '0', '0', '0', '0', '5', '10085', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45859', '0', 'Cursed Dark Elf Wizard', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '5', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45859', '1', 'Cursed Dark Elf Wizard', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '5', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45859', '2', 'Cursed Dark Elf Wizard', '2', '30', '0', '0', '-1', '0', '0', '0', '0', '0', '5', '10085', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45860', '0', 'Cursed Dark Elf Wizard', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '5', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45860', '1', 'Cursed Dark Elf Wizard', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '5', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45860', '2', 'Cursed Dark Elf Wizard', '2', '30', '0', '0', '-1', '0', '0', '0', '0', '0', '5', '10085', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45861', '0', 'Cursed Dark Elf Warrior', '2', '15', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '87', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45862', '0', 'Cursed Dark Elf Warrior', '2', '15', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '87', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45863', '0', 'Dread Queen Laia', '2', '30', '0', '0', '-9', '0', '0', '0', '0', '0', '30', '10035', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45863', '1', 'Dread Queen Laia', '4', '5', '0', '0', '-9', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '3906');
INSERT INTO `mobskill` VALUES ('45863', '2', 'Dread Queen Laia', '2', '80', '0', '90', '-15', '0', '0', '0', '0', '0', '100', '35', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45864', '0', 'Cursed Dark Elf Wizard', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '5', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45864', '1', 'Cursed Dark Elf Wizard', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '5', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45864', '2', 'Cursed Dark Elf Wizard', '2', '30', '0', '0', '-1', '0', '0', '0', '0', '0', '5', '10085', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45865', '0', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-6', '0', '0', '0', '0', '0', '5', '10081', '5722', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45865', '1', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-4', '0', '0', '0', '0', '0', '5', '10082', '5635', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45866', '0', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-6', '0', '0', '0', '0', '0', '5', '10081', '5722', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45866', '1', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-4', '0', '0', '0', '0', '0', '5', '10082', '5635', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45867', '0', 'Cursed Dark Elf Warrior', '2', '15', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '87', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45869', '0', 'Cursed Dark Elf Wizard', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '5', '0', '0', '1', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45869', '1', 'Cursed Dark Elf Wizard', '1', '30', '0', '0', '-1', '0', '0', '1', '0', '0', '5', '0', '0', '30', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45869', '2', 'Cursed Dark Elf Wizard', '2', '30', '0', '0', '-1', '0', '0', '0', '0', '0', '5', '10085', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45870', '0', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-6', '0', '0', '0', '0', '0', '5', '10081', '5722', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45870', '1', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-4', '0', '0', '0', '0', '0', '5', '10082', '5635', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45871', '0', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-6', '0', '0', '0', '0', '0', '5', '10081', '5722', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('45871', '1', 'Cursed Dark Elf Knight', '2', '30', '0', '0', '-4', '0', '0', '0', '0', '0', '5', '10082', '5635', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81176', '0', 'Dark Elder', '2', '20', '0', '0', '-4', '0', '0', '0', '0', '0', '20', '53', '0', '0', '0', '0', '0', '0');
INSERT INTO `mobskill` VALUES ('81176', '1', 'Dark Elder', '2', '50', '0', '0', '-8', '0', '0', '0', '0', '0', '0', '10061', '0', '0', '0', '0', '0', '0');



-- update 31

INSERT INTO `mobskill` VALUES ('45952', '0', 'Giant guard ant', '2', '30', '0', '0', '-15', '0', '0', '0', '0', '0', '5', '10090', '0', '0', '0', '0', '0', '0'); 
INSERT INTO `mobskill` VALUES ('45952', '1', 'Giant guard ant', '1', '100', '0', '0', '-3', '0', '0', '3', '0', '0', '15', '0', '0', '30', '0', '0', '0', '0'); 
