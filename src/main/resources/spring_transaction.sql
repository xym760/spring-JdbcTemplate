/*
Navicat MySQL Data Transfer

Source Server         : GaoKao
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : spring_transaction

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-06-13 10:59:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `username` varchar(16) DEFAULT NULL,
  `balance` decimal(32,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('AA', '2500.00');
INSERT INTO `account` VALUES (null, null);

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `isbn` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1001', 'Java从入门到精通', '100');
INSERT INTO `book` VALUES ('1002', '操作系统源码解析', '70');

-- ----------------------------
-- Table structure for book_stock
-- ----------------------------
DROP TABLE IF EXISTS `book_stock`;
CREATE TABLE `book_stock` (
  `isbn` int(11) DEFAULT NULL,
  `stock` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_stock
-- ----------------------------
INSERT INTO `book_stock` VALUES ('1001', '0');
INSERT INTO `book_stock` VALUES ('1002', '9');
