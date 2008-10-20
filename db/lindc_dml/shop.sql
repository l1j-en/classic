-- update 32

-- shop price correction
UPDATE shop SET npc_id=71054,order_id=0,selling_price=690 WHERE item_id=40303 and selling_price <> -1;

-- replace missing sbs from IT 2F npcs
INSERT INTO `shop` VALUES ('70062', '40170', '0', '3300', '0', '1000');
INSERT INTO `shop` VALUES ('70062', '40173', '1', '3300', '0', '1000');
INSERT INTO `shop` VALUES ('70062', '40177', '2', '3300', '0', '1000');
INSERT INTO `shop` VALUES ('70062', '40179', '3', '8250', '0', '2000');
INSERT INTO `shop` VALUES ('70062', '40183', '4', '8250', '0', '2000');
INSERT INTO `shop` VALUES ('70066', '40171', '0', '3300', '0', '1000');
INSERT INTO `shop` VALUES ('70066', '40176', '1', '3300', '0', '1000');
INSERT INTO `shop` VALUES ('70066', '40180', '2', '8250', '0', '2000');
INSERT INTO `shop` VALUES ('70066', '40182', '3', '8250', '0', '2000');