-- update 26

-- disable 65 DE poly (reenable these after ep6/u merge)
-- ancient gold assassin morph (polyid: 5733)
update polymorphs set minlevel = 99 where id = 5733;



-- update 28

-- reenable lvl 70 DE poly
update polymorphs set minlevel = 70 where id = 5736;



-- update 30

-- reenable 55+ DE polies
update polymorphs set minlevel = 55 where id = 5727;
update polymorphs set minlevel = 60 where id = 5730;
update polymorphs set minlevel = 65 where id = 5733;
-- reenable red orc poly
update polymorphs set minlevel = 1 where id = 6010;

-- merge in new polymorphs entries
INSERT INTO `polymorphs` VALUES ('6080', 'princess horse', '6080', '1', '16', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6094', 'prince horse', '6094', '1', '16', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6137', 'death 52', '6137', '52', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6140', 'darkelf 52', '6140', '52', '256', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6136', 'barlog 52', '6136', '52', '255', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6139', 'general 52', '6139', '52', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6138', 'assassin 52', '6138', '52', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6267', 'neo black knight', '6267', '55', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6268', 'neo black mage', '6268', '55', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6269', 'neo black scouter', '6269', '55', '256', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6279', 'neo black assassin', '6279', '55', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6142', 'death 55', '6142', '55', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6145', 'darkelf 55', '6145', '55', '256', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6141', 'barlog 55', '6141', '55', '255', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6144', 'general 55', '6144', '55', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6143', 'assassin 55', '6143', '55', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6270', 'neo silver knight', '6270', '60', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6271', 'neo silver mage', '6271', '60', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6272', 'neo silver scouter', '6272', '60', '256', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6280', 'neo silver assassin', '6280', '60', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6147', 'death 60', '6147', '60', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6150', 'darkelf 60', '6150', '60', '256', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6146', 'barlog 60', '6146', '60', '255', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6149', 'general 60', '6149', '60', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6148', 'assassin 60', '6148', '60', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6273', 'neo gold knight', '6273', '65', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6274', 'neo gold mage', '6274', '65', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6275', 'neo gold scouter', '6275', '65', '256', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6281', 'neo gold assassin', '6281', '65', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6152', 'death 65', '6152', '65', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6155', 'darkelf 65', '6155', '65', '256', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6151', 'barlog 65', '6151', '65', '255', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6154', 'general 65', '6154', '65', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6153', 'assassin 65', '6153', '65', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6276', 'neo platinum knight', '6276', '70', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6277', 'neo platinum mage', '6277', '70', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6278', 'neo platinum scouter', '6278', '70', '256', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6282', 'neo platinum assassin', '6282', '70', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6157', 'death 70', '6157', '70', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6160', 'darkelf 70', '6160', '70', '256', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6156', 'barlog 70', '6156', '70', '255', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6159', 'general 70', '6159', '70', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6158', 'assassin 70', '6158', '70', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6180', 'unicorn A', '6180', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6181', 'unicorn B', '6181', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6182', 'unicorn C', '6182', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6183', 'unicorn D', '6183', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6184', 'bear A', '6184', '1', '237', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6185', 'bear B', '6185', '1', '237', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6186', 'bear C', '6186', '1', '237', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6187', 'bear D', '6187', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6188', 'mini white dog A', '6188', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6189', 'mini white dog B', '6189', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6190', 'mini white dog C', '6190', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6191', 'mini white dog D', '6191', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6192', 'ratman A', '6192', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6193', 'ratman B', '6193', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6194', 'ratman C', '6194', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6195', 'ratman D', '6195', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6196', 'pet tiger A', '6196', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6197', 'pet tiger B', '6197', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6198', 'pet tiger C', '6198', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6199', 'pet tiger D', '6199', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6200', 'dillo A', '6200', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6201', 'dillo B', '6201', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6202', 'dillo C', '6202', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6203', 'dillo D', '6203', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6204', 'mole A', '6204', '1', '256', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6205', 'mole B', '6205', '1', '256', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6206', 'mole C', '6206', '1', '256', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6207', 'mole D', '6207', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6208', 'darkelf thief A', '6208', '1', '495', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6209', 'darkelf thief B', '6209', '1', '495', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6210', 'darkelf thief C', '6210', '1', '495', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6211', 'darkelf thief D', '6211', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6212', 'ken lauhel A', '6212', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6213', 'ken lauhel B', '6213', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6214', 'ken lauhel C', '6214', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6215', 'ken lauhel D', '6215', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6216', 'kelenis A', '6216', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6217', 'kelenis B', '6217', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6218', 'kelenis C', '6218', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6219', 'kelenis D', '6219', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6220', 'slave A', '6220', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6221', 'slave B', '6221', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6222', 'slave C', '6222', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6223', 'slave D', '6223', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6224', 'dofleganger boss A', '6224', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6225', 'dofleganger boss B', '6225', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6226', 'dofleganger boss C', '6226', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6227', 'dofleganger boss D', '6227', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6228', 'lich A', '6228', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6229', 'lich B', '6229', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6230', 'lich C', '6230', '1', '239', '2047', '1');
INSERT INTO `polymorphs` VALUES ('6231', 'lich D', '6231', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6232', 'woman1 A', '6232', '1', '0', '2047', '0');
INSERT INTO `polymorphs` VALUES ('6233', 'woman1 B', '6233', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6234', 'woman2 A', '6234', '1', '0', '2047', '0');
INSERT INTO `polymorphs` VALUES ('6235', 'woman2 B', '6235', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6236', 'woman3 A', '6236', '1', '0', '2047', '0');
INSERT INTO `polymorphs` VALUES ('6237', 'woman3 B', '6237', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6238', 'woman4 A', '6238', '1', '0', '2047', '0');
INSERT INTO `polymorphs` VALUES ('6239', 'woman4 B', '6239', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6240', 'woman5 A', '6240', '1', '0', '2047', '0');
INSERT INTO `polymorphs` VALUES ('6241', 'woman5 B', '6241', '1', '0', '0', '0');
INSERT INTO `polymorphs` VALUES ('6242', 'noblewoman A', '6242', '1', '0', '2047', '0');
INSERT INTO `polymorphs` VALUES ('6243', 'noblewoman B', '6243', '1', '0', '0', '0');