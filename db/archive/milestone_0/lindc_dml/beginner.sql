-- update 0

INSERT INTO `beginner` VALUES ('1', '40308', '100', '0', 'Adena', 'A');
INSERT INTO `beginner` VALUES ('2', '4', '1', '0', 'Dagger', 'A');
INSERT INTO `beginner` VALUES ('3', '29001', '1', '0', 'Wooden Jacket', 'E');   
INSERT INTO `beginner` VALUES ('4', '172', '1', '0', 'Short Bow', 'E');
INSERT INTO `beginner` VALUES ('5', '40743', '100', '0', 'Arrow', 'E');
INSERT INTO `beginner` VALUES ('6', '40641', '1', '0', 'Talking Scroll', 'A');
INSERT INTO `beginner` VALUES ('7', '20322', '1', '0', 'Leather Jacket', 'P');
INSERT INTO `beginner` VALUES ('8', '20322', '1', '0', 'Leather Jacket', 'K');
INSERT INTO `beginner` VALUES ('9', '20322', '1', '0', 'Leather Jacket', 'W');
INSERT INTO `beginner` VALUES ('10', '20322', '1', '0', 'Leather Jacket', 'D');



-- update 19

-- replace bow in starting items with short bow
update beginner set item_id = 173 where item_id = 172;
