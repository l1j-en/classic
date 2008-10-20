-- update 32

-- poly gfxid fixes
UPDATE polymorphs SET id='2388',polyid='2388' WHERE name ='death'; 
UPDATE polymorphs SET id='3952',polyid='3952' WHERE name ='vampire'; 
UPDATE polymorphs SET id='4767',polyid='4767' WHERE name ='rabbit'; 
UPDATE polymorphs SET id='4769',polyid='4769' WHERE name ='carrot rabbit'; 
UPDATE polymorphs SET id='4928',polyid='4928' WHERE name ='high collie'; 
UPDATE polymorphs SET id='4929',polyid='4929' WHERE name ='high raccoon'; 
UPDATE polymorphs SET armorequip='2047' WHERE id='5719' and polyid='5719'; 
UPDATE polymorphs SET id='6089',polyid='6089',weaponequip='255',armorequip='2047',isSkillUse='1' WHERE name ='drake morph'; 
UPDATE polymorphs SET weaponequip='255',armorequip='2047',isSkillUse='1' WHERE id='4001' and polyid='4001'; 
UPDATE polymorphs SET weaponequip='255',armorequip='2047',isSkillUse='1' WHERE id='4002' and polyid='4002'; 
UPDATE polymorphs SET weaponequip='239',armorequip='2047',isSkillUse='1' WHERE id='4004' and polyid='4004'; 
UPDATE polymorphs SET id='6002',polyid='6002' WHERE name ='spirit of earth boss'; 
UPDATE polymorphs SET weaponequip='511' WHERE name ='manekineko'; 
UPDATE polymorphs SET weaponequip='255' WHERE name ='knight vald morph'; 
UPDATE polymorphs SET weaponequip='511' WHERE name ='Halloween Pumpkin'; 

-- names i cant find yet
INSERT INTO `polymorphs` VALUES ('3902', '', '3902', '1', '43', '2047', '1'); 
INSERT INTO `polymorphs` VALUES ('3903', '', '3903', '1', '239', '2047', '1'); 
INSERT INTO `polymorphs` VALUES ('5645', '', '5645', '1', '0', '2047', '0'); 
INSERT INTO `polymorphs` VALUES ('5976', '', '5976', '1', '239', '2', '0'); 
INSERT INTO `polymorphs` VALUES ('6086', '', '6086', '1', '239', '2047', '1'); 
INSERT INTO `polymorphs` VALUES ('6087', '', '6087', '1', '256', '2047', '1'); 
INSERT INTO `polymorphs` VALUES ('6088', '', '6088', '1', '239', '2047', '1');

-- black knight polyid fix
UPDATE polymorphs SET id='4923',polyid='4923' WHERE name ='black knight morph';