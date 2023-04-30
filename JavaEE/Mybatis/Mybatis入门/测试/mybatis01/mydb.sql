/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50647
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50647
File Encoding         : 65001

Date: 2020-04-16 18:09:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuId` int(10) NOT NULL AUTO_INCREMENT,
  `stuName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stuId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'zhangsan');
INSERT INTO `student` VALUES ('2', 'lisi');
INSERT INTO `student` VALUES ('3', 'wangwu');
