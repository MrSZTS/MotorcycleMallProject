/*
 Navicat MySQL Data Transfer

 Source Server         : z本机
 Source Server Type    : MySQL
 Source Server Version : 50515
 Source Host           : localhost:3306
 Source Schema         : motorbike

 Target Server Type    : MySQL
 Target Server Version : 50515
 File Encoding         : 65001

 Date: 06/07/2020 17:05:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `depart_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门表',
  `depart_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名',
  `depart_effect` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门作用',
  PRIMARY KEY (`depart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '采购部门', '负责渠道销售、公司的收入源泉');
INSERT INTO `department` VALUES (2, '技术部门', '公司产品的研发、技术核心');
INSERT INTO `department` VALUES (3, '后勤部门', '服务公司资产、库存管理');
INSERT INTO `department` VALUES (4, '人力部门', '管理者所在部门');

-- ----------------------------
-- Table structure for driver
-- ----------------------------
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver`  (
  `driver_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '试驾预约表',
  `driver_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试驾人',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试驾车',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `driver_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试驾状态',
  `driver_start` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试驾开始时间',
  `driver_end` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试驾结束时间',
  PRIMARY KEY (`driver_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of driver
-- ----------------------------

-- ----------------------------
-- Table structure for person_role
-- ----------------------------
DROP TABLE IF EXISTS `person_role`;
CREATE TABLE `person_role`  (
  `person_role_id` int(225) NOT NULL AUTO_INCREMENT COMMENT 'person_role',
  `user_id` int(225) NULL DEFAULT NULL COMMENT '用户id',
  `staff_id` int(225) NULL DEFAULT NULL COMMENT '员工',
  PRIMARY KEY (`person_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of person_role
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品信息表',
  `product_series` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车系',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车名',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `product_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '车价',
  `product_num` int(11) NULL DEFAULT NULL COMMENT '产品数量',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase`  (
  `purchase_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单信息表',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车名',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `purchase_num` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  `product_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '车价',
  `purchase_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购买人',
  `apply_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `received_condition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货状态',
  `finish_time` datetime NULL DEFAULT NULL COMMENT '完成订单时间',
  PRIMARY KEY (`purchase_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of purchase
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(225) NOT NULL AUTO_INCREMENT COMMENT 'role',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_depart` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '2');
INSERT INTO `role` VALUES (2, '管理员', '2');
INSERT INTO `role` VALUES (3, '老板', '4');
INSERT INTO `role` VALUES (4, '采购员工', '1');
INSERT INTO `role` VALUES (5, '库存管理员工', '3');
INSERT INTO `role` VALUES (6, '用户', NULL);

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工表',
  `staff_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `staff_age` int(11) NULL DEFAULT NULL,
  `staff_sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_telephone` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_email` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_address` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `staff_birthday` date NULL DEFAULT NULL COMMENT '入职时间',
  `education_background` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `staff_major` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `staff_graduation` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业院校',
  `staff_entrytime` datetime NULL DEFAULT NULL COMMENT '入职时间',
  `staff_account` int(225) NOT NULL COMMENT '员工账户',
  `staff_password` int(225) NOT NULL COMMENT '员工密码',
  PRIMARY KEY (`staff_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of staff
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '用户表',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_account` int(225) NULL DEFAULT NULL COMMENT '用户账户',
  `user_password` int(225) NULL DEFAULT NULL COMMENT '用户密码',
  `telephone` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
