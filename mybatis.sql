/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-05-13 19:54:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_department
-- ----------------------------
DROP TABLE IF EXISTS `tbl_department`;
CREATE TABLE `tbl_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_department
-- ----------------------------
INSERT INTO `tbl_department` VALUES ('1', '开发部');
INSERT INTO `tbl_department` VALUES ('2', '测试部');

-- ----------------------------
-- Table structure for tbl_employee
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employee`;
CREATE TABLE `tbl_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) DEFAULT NULL,
  `email` char(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `d_id` (`d_id`),
  CONSTRAINT `tbl_employee_ibfk_1` FOREIGN KEY (`d_id`) REFERENCES `tbl_department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_employee
-- ----------------------------
INSERT INTO `tbl_employee` VALUES ('1', 'David', 'smaj@qq.com', '1', '1');
INSERT INTO `tbl_employee` VALUES ('4', 'joe', 'joe@qq.com', '1', '2');
INSERT INTO `tbl_employee` VALUES ('5', 'jack', 'jack@qq.com', '1', '2');
INSERT INTO `tbl_employee` VALUES ('6', 'jjj', 'jjj@qq.com', '1', '1');
INSERT INTO `tbl_employee` VALUES ('7', 'ddd', 'ddd@qq.com', '0', '2');

-- ----------------------------
-- Table structure for tb_idcard
-- ----------------------------
DROP TABLE IF EXISTS `tb_idcard`;
CREATE TABLE `tb_idcard` (
  `id` int(11) NOT NULL,
  `CODE` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_idcard
-- ----------------------------
INSERT INTO `tb_idcard` VALUES ('1', '123456');
INSERT INTO `tb_idcard` VALUES ('2', '789012');

-- ----------------------------
-- Table structure for tb_person
-- ----------------------------
DROP TABLE IF EXISTS `tb_person`;
CREATE TABLE `tb_person` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `card_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `card_id` (`card_id`),
  CONSTRAINT `tb_person_ibfk_1` FOREIGN KEY (`card_id`) REFERENCES `tb_idcard` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_person
-- ----------------------------
INSERT INTO `tb_person` VALUES ('1', 'Rose', '29', '女', '1');
INSERT INTO `tb_person` VALUES ('2', 'tom', '27', '男', '2');

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(32) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `jobs` varchar(50) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1', 'joy', 'teacher', '123');
INSERT INTO `t_customer` VALUES ('2', 'jack', 'student', '456');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `t_id` int(11) NOT NULL,
  `t_name` varchar(50) DEFAULT NULL,
  `t_age` int(11) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'Lucy', '25');
INSERT INTO `t_user` VALUES ('2', 'Lili', '20');
INSERT INTO `t_user` VALUES ('3', 'Jim', '20');
