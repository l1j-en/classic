/*
MySQL Data Transfer
Source Host: localhost
Source Database: l1new
Target Host: localhost
Target Database: l1new
Date: 2008-08-12 03:41:32
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for bugs
-- ----------------------------
DROP TABLE IF EXISTS `bugs`;
CREATE TABLE `bugs` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT,
  `bugtext` varchar(255) NOT NULL DEFAULT '',
  `charname` varchar(45) NOT NULL DEFAULT '',
  `mapID` int(6) NOT NULL DEFAULT '0',
  `mapX` int(6) NOT NULL DEFAULT '0',
  `mapY` int(6) NOT NULL DEFAULT '0',
  `resolved` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
