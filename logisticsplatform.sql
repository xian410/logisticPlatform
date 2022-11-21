/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : logisticsplatform

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 21/11/2022 18:55:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `login_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户主键',
  `money` float NOT NULL DEFAULT 0 COMMENT '账户余额',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '笔记',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `account_ibfk_1`(`login_id`) USING BTREE,
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`login_id`) REFERENCES `login_user` (`login_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '账户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '15510267085', 380, 0, '', '2021-11-15 23:22:05', '2021-12-03 21:51:21');
INSERT INTO `account` VALUES (2, '17320027713', 12, 0, '', '2021-11-17 18:35:49', '2021-12-03 21:10:03');
INSERT INTO `account` VALUES (3, '175200277128', 2, 0, '', '2021-11-18 11:54:58', '2021-12-04 14:10:09');
INSERT INTO `account` VALUES (4, '12345678911', 1554, 0, '', '2021-11-20 13:48:47', '2021-11-20 13:48:47');
INSERT INTO `account` VALUES (7, '18888888888', 7777, 0, '', '2021-12-01 22:44:36', '2021-12-03 13:56:46');
INSERT INTO `account` VALUES (8, '13146897978', 56228, 0, '', '2021-12-01 22:49:48', '2021-12-01 22:49:48');
INSERT INTO `account` VALUES (9, '18398758845', 485, 0, '', '2021-12-04 13:19:22', '2021-12-04 13:19:22');
INSERT INTO `account` VALUES (10, '13146895958', 0, 0, '', '2021-12-04 13:45:34', '2021-12-04 13:45:34');
INSERT INTO `account` VALUES (11, '13333333333', 50, 0, '', '2021-12-04 13:46:01', '2021-12-04 13:46:01');

-- ----------------------------
-- Table structure for car_type
-- ----------------------------
DROP TABLE IF EXISTS `car_type`;
CREATE TABLE `car_type`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `car_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类型编号',
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '类型名称',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '笔记',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `car_id`(`car_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '车辆类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_type
-- ----------------------------
INSERT INTO `car_type` VALUES (23, '1', '重型普通货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (24, '2', '重型厢式货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (25, '3', '重型罐式货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (26, '4', '重型平板货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (27, '5', '重型特殊结构货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (28, '6', '重型仓栅式货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (29, '7', '中型普通货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (30, '8', '中型厢式货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (31, '9', '中型罐式货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (32, '10', '中型平板货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (33, '11', '中型特殊结构货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (34, '12', '中型仓栅式货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (35, '13', '轻型普通货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (36, '14', '轻型厢式货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (37, '15', '轻型罐式货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (38, '16', '轻型平板货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (39, '17', '轻型特殊结构货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');
INSERT INTO `car_type` VALUES (40, '18', '轻型仓栅式货车', 0, '', '2021-11-18 11:52:44', '2021-11-18 11:52:44');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `login_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户主键',
  `customer_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '货主id',
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `gender` int(0) NOT NULL DEFAULT -1 COMMENT '性别',
  `telephone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '电话',
  `user_goods` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '常运货物',
  `address` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '住址',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '笔记',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `customer_id`(`customer_id`) USING BTREE,
  INDEX `customer_ibfk_1`(`login_id`) USING BTREE,
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`login_id`) REFERENCES `login_user` (`login_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '货主信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (2, '15510267085', '15510267085', '王永航', 1, '17732438902', '01,02,03,04', '河工大', 0, '这个人很懒，什么都没有留下呢~', '2021-11-15 23:22:05', '2021-11-20 00:46:32');
INSERT INTO `customer` VALUES (3, '17320027713', '17320027713', '刘景', -1, '17320027713', '', '', 0, '', '2021-11-17 18:35:49', '2021-11-20 14:40:22');
INSERT INTO `customer` VALUES (6, '18888888888', '18888888888', '李嘉煦', 1, '188888888888', '02,03', '河北省唐山市', 0, '', '2021-12-01 22:44:36', '2021-12-01 22:44:36');
INSERT INTO `customer` VALUES (7, '18398758845', '18398758845', '王超', 1, '18398758845', '01,02', '北京市坟台区', 0, '', '2021-12-04 13:19:22', '2021-12-04 13:19:22');

-- ----------------------------
-- Table structure for driver
-- ----------------------------
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `login_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户主键',
  `driver_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '司机id',
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `gender` int(0) NOT NULL DEFAULT -1 COMMENT '性别',
  `telephone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '电话',
  `car_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '13' COMMENT '车辆类型编号',
  `car_number` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '车牌号',
  `trans_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '运输类型',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '笔记',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `driver_id`(`driver_id`) USING BTREE,
  INDEX `driver_ibfk_1`(`login_id`) USING BTREE,
  INDEX `driver_ibfk_2`(`car_id`) USING BTREE,
  CONSTRAINT `driver_ibfk_1` FOREIGN KEY (`login_id`) REFERENCES `login_user` (`login_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `driver_ibfk_2` FOREIGN KEY (`car_id`) REFERENCES `car_type` (`car_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '司机信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of driver
-- ----------------------------
INSERT INTO `driver` VALUES (1, '175200277128', '175200277128', '王永航', 0, '1234567897', '7', '京HU1292', '04,05', 0, '', '2021-11-18 11:54:57', '2021-11-19 10:39:15');
INSERT INTO `driver` VALUES (2, '12345678911', '12345678911', '王凡', 0, '', '7', 'SB666', '', 0, '', '2021-11-20 13:48:47', '2021-11-20 13:48:47');
INSERT INTO `driver` VALUES (3, '13146897978', '13146897978', '芮振瑶', 0, '13146897978', '13', '冀HU1368', '06,05', 0, '', '2021-12-01 22:49:48', '2021-12-01 22:49:48');
INSERT INTO `driver` VALUES (4, '13146895958', '13146895958', '王凡', -1, '13146895958', '13', '', '', 0, '', '2021-12-04 13:45:34', '2021-12-04 13:45:34');
INSERT INTO `driver` VALUES (5, '13333333333', '13333333333', '王凡1', -1, '13333333333', '13', '', '', 0, '', '2021-12-04 13:46:01', '2021-12-04 13:46:01');

-- ----------------------------
-- Table structure for driver_intention
-- ----------------------------
DROP TABLE IF EXISTS `driver_intention`;
CREATE TABLE `driver_intention`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `intention_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '意向货物编号',
  `good_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '货物编号',
  `driver_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '司机id',
  `customer_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '货主id',
  `fees` float NOT NULL DEFAULT 0 COMMENT '运费报价',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '笔记',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(0) NOT NULL DEFAULT 0 COMMENT '\r\n意向类型0未知1未同意，2同意',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `intention_id`(`intention_id`) USING BTREE,
  INDEX `driver_intention_ibfk_1`(`good_id`) USING BTREE,
  INDEX `driver_intention_ibfk_2`(`driver_id`) USING BTREE,
  INDEX `driver_intention_ibfk_3`(`customer_id`) USING BTREE,
  CONSTRAINT `driver_intention_ibfk_1` FOREIGN KEY (`good_id`) REFERENCES `goods` (`good_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `driver_intention_ibfk_2` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`driver_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `driver_intention_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '司机意向表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of driver_intention
-- ----------------------------
INSERT INTO `driver_intention` VALUES (32, 'intention-53749890-b01f-4f88-9e85-92c0f73b2d44', 'good-a415eb5f-f155-4956-92bc-55a797d8d4db', '12345678911', '15510267085', 111, '', 0, '', '2021-12-02 19:48:40', '2021-12-03 10:11:37', 1);
INSERT INTO `driver_intention` VALUES (33, 'intention-0ced346a-b57b-491f-9ae6-9f29c493ddd6', 'good-117c24da-9af6-4122-8539-f36f74ceb811', '12345678911', '15510267085', 111, '', 0, '', '2021-12-02 19:49:14', '2021-12-02 20:11:05', 1);
INSERT INTO `driver_intention` VALUES (34, 'intention-f56943c4-33a2-4e1e-b952-91515a329e13', 'good-24d33d44-ade9-4456-8e67-448580a086b2', '12345678911', '15510267085', 111, '', 0, '', '2021-12-02 20:18:55', '2021-12-03 09:01:35', 1);
INSERT INTO `driver_intention` VALUES (35, 'intention-cefb39d3-49e8-4cf2-aa2c-fccbcf922e7a', 'good-0d0f4ddd-9f5b-464c-86c6-28f0da2550de', '12345678911', '18888888888', -1, '', 0, '', '2021-12-02 20:25:54', '2021-12-03 11:19:57', 1);
INSERT INTO `driver_intention` VALUES (36, 'intention-2c9aec7f-5434-48cf-b4d0-de6c5d8d7db0', 'good-a415eb5f-f155-4956-92bc-55a797d8d4db', '175200277128', '15510267085', 100, '', 0, '', '2021-12-02 21:20:03', '2021-12-03 10:11:37', 2);
INSERT INTO `driver_intention` VALUES (37, 'intention-8b064ec1-bd11-4dc2-b051-e95a9eba2e5a', 'good-24d33d44-ade9-4456-8e67-448580a086b2', '175200277128', '15510267085', 99, '', 0, '', '2021-12-03 09:00:48', '2021-12-03 09:01:35', 2);
INSERT INTO `driver_intention` VALUES (39, 'intention-a156ff83-f9aa-43bf-a32f-4e85dac3afd6', 'good-04e948ba-1df4-4a61-b7e4-057cd36f98a1', '13146897978', '15510267085', 300, '我是大瑶啊', 0, '', '2021-12-03 11:16:51', '2022-11-19 12:50:47', 2);
INSERT INTO `driver_intention` VALUES (40, 'intention-15d5b355-bf9d-43d5-ae2a-68b318eb2728', 'good-ecba4274-9e3e-4e43-8431-408740cde13b', '13146897978', '18888888888', 1131, '', 0, '', '2021-12-03 11:17:07', '2021-12-03 11:29:08', 2);
INSERT INTO `driver_intention` VALUES (42, 'intention-b64fc3f8-10c5-455d-8a52-1d7ae86f8606', 'good-9ccc0f0d-c95d-4627-9ea2-54f6a17a8a85', '13146897978', '18888888888', 80, '', 0, '', '2021-12-03 11:31:54', '2021-12-03 11:32:31', 2);
INSERT INTO `driver_intention` VALUES (43, 'intention-abbf0165-7d18-4c20-a517-a32d9800cd89', 'good-1c90ce24-42c4-436f-9430-13b95a439819', '13146897978', '18888888888', 22, '', 0, '', '2021-12-03 11:34:52', '2021-12-03 11:38:01', 2);
INSERT INTO `driver_intention` VALUES (44, 'intention-d9c11e50-3a65-4228-b56a-0f1dd28649ee', 'good-4f124766-7234-44c1-84ff-793a192bdc09', '13146897978', '15510267085', 1, '', 0, '', '2021-12-03 11:57:21', '2021-12-03 11:57:34', 2);
INSERT INTO `driver_intention` VALUES (45, 'intention-448a3658-fc84-44b2-bc84-5e94dcfa522b', 'good-6790f9a3-2f41-43e0-81ae-9c43fea2b670', '13146897978', '15510267085', 88, '', 0, '', '2021-12-03 22:06:38', '2021-12-03 22:06:55', 2);
INSERT INTO `driver_intention` VALUES (47, 'intention-af370b27-797f-4c49-b4b9-3adae1d56d4d', 'good-cf3848ad-1a45-4413-a69a-5adf76f464b2', '13146897978', '18398758845', 123, '', 0, '', '2021-12-04 13:23:31', '2021-12-04 13:24:08', 2);
INSERT INTO `driver_intention` VALUES (48, 'intention-a7a31107-1542-43d6-8fb0-b912e108fde7', 'good-41bae1ec-5aa4-4a6a-8770-be3f64d4e0b4', '13146895958', '18398758845', 30, '让我姐吧', 0, '', '2021-12-04 13:48:30', '2021-12-04 13:51:37', 1);
INSERT INTO `driver_intention` VALUES (49, 'intention-1fcd0e0e-7b7a-4124-86bd-d03178bd5e92', 'good-41bae1ec-5aa4-4a6a-8770-be3f64d4e0b4', '13333333333', '18398758845', 50, '', 0, '', '2021-12-04 13:49:00', '2021-12-04 13:51:36', 2);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `customer_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '货主id',
  `good_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '货物编号',
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '货物名称',
  `type_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '货物类型编号',
  `start` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '起点',
  `destination` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '终点',
  `fees_min` int(0) NOT NULL DEFAULT 0 COMMENT '运费要求-最低',
  `fees_max` int(0) NOT NULL DEFAULT 9999 COMMENT '运费要求-最高',
  `weight` double NOT NULL DEFAULT 15 COMMENT '重量',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '笔记',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `good_id`(`good_id`) USING BTREE,
  INDEX `goods_ibfk_1`(`customer_id`) USING BTREE,
  INDEX `goods_ibfk_2`(`type_id`) USING BTREE,
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `goods_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `goods_type` (`type_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '货物信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (26, '17320027713', 'good-e2189716-4171-4e84-9145-1ee9fbb32349', '精密仪器', '08', '77', '北京', 9, 95, 45, '123', 0, '', '2021-11-18 19:25:53', '2021-11-18 19:25:53');
INSERT INTO `goods` VALUES (27, '15510267085', 'good-983a9402-433a-4702-81ff-4ce61e5927ff', '一些东西', '08', '石家庄', '河南', 0, 132, 1, '事情紧急', 0, '', '2021-11-20 15:21:23', '2021-11-20 15:21:23');
INSERT INTO `goods` VALUES (29, '15510267085', 'good-8eb93bde-2ca8-4902-9f5c-759cfbdaa28c', '零食', '03', '河工大', '北京', 0, 123, 112, '', 0, '', '2021-11-20 16:43:01', '2021-11-20 16:43:01');
INSERT INTO `goods` VALUES (30, '15510267085', 'good-f37b8728-ea37-4cf7-93ec-da4fd0dafdb2', '吃的', '01', '天津', '北京', 0, 123, 123, '', 0, '', '2021-11-20 17:00:36', '2021-11-20 17:00:36');
INSERT INTO `goods` VALUES (32, '15510267085', 'good-98ac98d4-c3c0-43d9-add4-a51bab2ace60', '零食', '02', '河工大', '黑龙江', 0, 444, 123, '', 0, '', '2021-11-21 21:06:19', '2021-11-21 21:06:19');
INSERT INTO `goods` VALUES (33, '15510267085', 'good-6790f9a3-2f41-43e0-81ae-9c43fea2b670', '吃的', '13', '定州', '河工大', 0, 333, 134, '', 0, '', '2021-11-21 21:13:12', '2021-11-21 21:13:12');
INSERT INTO `goods` VALUES (35, '15510267085', 'good-01d3a977-47d5-4227-8b2f-a52f9770397b', '棒棒棒', '14', 'abc', 'debc', 0, 234, 122, '', 0, '', '2021-11-21 21:15:41', '2021-11-21 21:15:41');
INSERT INTO `goods` VALUES (38, '15510267085', 'good-d2972093-0c6d-4bd9-918d-cbc8f609c2f9', '火锅', '14', '河工大', '恒顺', 0, 100, 10, '', 0, '', '2021-11-27 16:41:13', '2021-11-27 16:41:13');
INSERT INTO `goods` VALUES (39, '15510267085', 'good-4f124766-7234-44c1-84ff-793a192bdc09', '盖茨', '03', '天津', '北京', 0, 999, 15, '告辞', 0, '', '2021-11-29 21:44:18', '2021-11-29 21:44:18');
INSERT INTO `goods` VALUES (45, '18888888888', 'good-ed8970bf-a81c-4c36-8c6d-63abadc05c36', '一些工业品', '05', '河北省唐山市', '新疆省喀什市', 0, 600, 10, '没有', 0, '', '2021-12-01 22:47:40', '2021-12-01 22:47:40');
INSERT INTO `goods` VALUES (46, '18888888888', 'good-0d0f4ddd-9f5b-464c-86c6-28f0da2550de', '水和饮料', '12', '巴山出水', '凄凉地', 0, 10, 2, '123', 0, '', '2021-12-02 00:03:21', '2021-12-02 00:40:24');
INSERT INTO `goods` VALUES (47, '18888888888', 'good-ecba4274-9e3e-4e43-8431-408740cde13b', '水杯', '14', '天津', '北京', 200, 500, 1000, '立刻送', 0, '', '2021-12-02 15:58:21', '2021-12-02 15:58:21');
INSERT INTO `goods` VALUES (48, '18888888888', 'good-1c90ce24-42c4-436f-9430-13b95a439819', '充电器', '14', '地球', '火星', 20, 200, 1000, '', 0, '', '2021-12-02 16:02:20', '2021-12-02 16:02:20');
INSERT INTO `goods` VALUES (49, '18888888888', 'good-9ccc0f0d-c95d-4627-9ea2-54f6a17a8a85', '手机', '01', '北辰', '红桥', 50, 100, 2, '', 0, '', '2021-12-02 16:13:34', '2021-12-02 16:13:34');
INSERT INTO `goods` VALUES (50, '15510267085', 'good-24d33d44-ade9-4456-8e67-448580a086b2', '脉动', '01', '图书馆', '宿舍', 0, 222, 12, '', 0, '', '2021-12-02 16:24:01', '2021-12-02 16:24:01');
INSERT INTO `goods` VALUES (51, '15510267085', 'good-117c24da-9af6-4122-8539-f36f74ceb811', '红烧肉', '02', '食堂', '宿舍', 0, 22, 122, '', 0, '', '2021-12-02 16:24:43', '2021-12-02 16:24:43');
INSERT INTO `goods` VALUES (52, '15510267085', 'good-a415eb5f-f155-4956-92bc-55a797d8d4db', '米饭', '05', '恒顺', '河工大', 0, 22, 12, '', 0, '', '2021-12-02 16:25:58', '2021-12-02 16:25:58');
INSERT INTO `goods` VALUES (64, '15510267085', 'good-04e948ba-1df4-4a61-b7e4-057cd36f98a1', '刘景贤的头发', '02', '四川', '海南', 200, 300, 10, '王凡接一下', 0, '', '2021-12-03 11:10:53', '2021-12-03 11:10:53');
INSERT INTO `goods` VALUES (66, '18398758845', 'good-cf3848ad-1a45-4413-a69a-5adf76f464b2', '一些好东西', '02', '停机保号', '偷鸡不成', 0, 44, 1, '', 0, '', '2021-12-04 13:22:28', '2021-12-04 13:22:28');
INSERT INTO `goods` VALUES (67, '18398758845', 'good-41bae1ec-5aa4-4a6a-8770-be3f64d4e0b4', '食品', '03', '天津市北辰', '天津红桥', 0, 100, 10, '', 0, '', '2021-12-04 13:47:37', '2021-12-04 13:47:37');

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类型编号',
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '类型名称',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '笔记',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `type_id`(`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '货物类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES (1, '01', '电子通讯产品', 0, '', '2021-11-16 20:31:39', '2021-11-17 16:42:17');
INSERT INTO `goods_type` VALUES (2, '02', '石油、天然气及制品', 0, '', '2021-11-17 16:51:21', '2021-11-17 16:51:21');
INSERT INTO `goods_type` VALUES (3, '03', '农副产品、食品及饮品', 0, '', '2021-11-17 16:51:25', '2021-11-17 16:51:48');
INSERT INTO `goods_type` VALUES (4, '04', '矿石、矿建材料', 0, '', '2021-11-17 16:51:26', '2021-11-17 16:51:51');
INSERT INTO `goods_type` VALUES (5, '05', '医药、化工品', 0, '', '2021-11-17 16:51:27', '2021-11-17 16:51:55');
INSERT INTO `goods_type` VALUES (6, '06', '塑料橡胶产品', 0, '', '2021-11-17 16:51:28', '2021-11-17 16:51:58');
INSERT INTO `goods_type` VALUES (7, '07', '木制品及家具', 0, '', '2021-11-17 16:51:28', '2021-11-17 16:52:02');
INSERT INTO `goods_type` VALUES (8, '08', '纺织原料及制品', 0, '', '2021-11-17 16:51:29', '2021-11-17 16:52:05');
INSERT INTO `goods_type` VALUES (9, '09', '煤炭', 0, '', '2021-11-17 16:51:32', '2021-11-17 16:52:08');
INSERT INTO `goods_type` VALUES (10, '10', '木浆及纸制品', 0, '', '2021-11-17 16:51:35', '2021-11-17 16:52:11');
INSERT INTO `goods_type` VALUES (11, '11', '金属及制品', 0, '', '2021-11-17 16:51:36', '2021-11-17 16:52:16');
INSERT INTO `goods_type` VALUES (12, '12', '机械、精工产品', 0, '', '2021-11-17 16:51:37', '2021-11-17 16:52:20');
INSERT INTO `goods_type` VALUES (13, '13', '运输设备及零部件', 0, '', '2021-11-17 16:51:38', '2021-11-17 16:52:24');
INSERT INTO `goods_type` VALUES (14, '14', '其他', 0, '', '2021-11-17 16:51:39', '2021-11-17 16:52:41');

-- ----------------------------
-- Table structure for login_user
-- ----------------------------
DROP TABLE IF EXISTS `login_user`;
CREATE TABLE `login_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `login_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录主键',
  `user_type` int(0) NOT NULL DEFAULT 0 COMMENT '用户类型',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '令牌',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '笔记',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `login_id`(`login_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户登录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_user
-- ----------------------------
INSERT INTO `login_user` VALUES (2, '15510267085', 0, '111111', 'token-04ae270b-f631-4d34-85c1-10ff81621e3d', 0, '', '2021-11-15 23:22:05', '2021-12-04 14:48:29');
INSERT INTO `login_user` VALUES (4, '17320027713', 0, '123456', '', 0, '', '2021-11-17 18:35:48', '2021-11-27 14:22:16');
INSERT INTO `login_user` VALUES (7, '175200277128', 1, '123456', 'token-c163045f-dddc-49dc-894c-f177b7f76341', 0, '', '2021-11-18 11:54:57', '2021-12-03 11:15:19');
INSERT INTO `login_user` VALUES (9, '12345678911', 1, '111111', '', 0, '', '2021-11-20 13:48:47', '2021-12-02 22:02:28');
INSERT INTO `login_user` VALUES (12, '18888888888', 0, '111111', 'token-34b49ee5-e4f1-4c88-a319-49ff0629d139', 0, '', '2021-12-01 22:44:36', '2021-12-03 11:15:34');
INSERT INTO `login_user` VALUES (13, '13146897978', 1, '111111', 'token-92b29720-6a75-46e1-bf0f-0b25bac78e10', 0, '', '2021-12-01 22:49:48', '2021-12-03 23:02:06');
INSERT INTO `login_user` VALUES (14, '111111', 3, '111111', 'token-34db9ae1-98ac-4aad-8f9d-1cd8269d393c', 0, '', '2021-12-04 10:11:00', '2021-12-04 14:48:44');
INSERT INTO `login_user` VALUES (15, '18398758845', 0, '111111', 'token-90f44f11-53da-4034-b307-b8086aed707d', 0, '', '2021-12-04 13:19:22', '2021-12-04 13:19:22');
INSERT INTO `login_user` VALUES (16, '13146895958', 1, '111111', 'token-a6a26177-23c5-4d8c-9f59-279b4bb44a0f', 0, '', '2021-12-04 13:45:34', '2021-12-04 13:45:34');
INSERT INTO `login_user` VALUES (17, '13333333333', 1, '111111', 'token-cbdb65a6-e9f6-4b2c-8c54-0ca6cf84d626', 0, '', '2021-12-04 13:46:01', '2021-12-04 13:46:01');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `message_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息编号',
  `login_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户主键',
  `good_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '货物主键',
  `from_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '来源用户Id',
  `status` int(0) NOT NULL DEFAULT 0 COMMENT '消息类型 0未知 1.有司机提出报价，2.货物已到达 3.报价被货主接受 4.被货主拒绝 5.已到账',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '笔记',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `message_id`(`message_id`) USING BTREE,
  INDEX `message_ibfk_1`(`login_id`) USING BTREE,
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`login_id`) REFERENCES `login_user` (`login_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '消息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (21, 'message-3d5c31f0-ee62-4b44-900e-a8cd0632a699', '15510267085', 'good-4f124766-7234-44c1-84ff-793a192bdc09', '13146897978', 1, 1, '', '2021-12-03 11:57:21', '2021-12-03 11:57:21');
INSERT INTO `message` VALUES (22, 'message-7e7df59f-9080-462d-a969-67f56572c791', '13146897978', 'good-4f124766-7234-44c1-84ff-793a192bdc09', '15510267085', 3, 1, '', '2021-12-03 11:57:34', '2021-12-03 11:57:34');
INSERT INTO `message` VALUES (23, 'message-02055eb1-8765-4fdc-a6ad-7fb0e6d04ce6', '175200277128', 'good-4f124766-7234-44c1-84ff-793a192bdc09', '15510267085', 4, 1, '', '2021-12-03 11:57:34', '2021-12-03 11:57:34');
INSERT INTO `message` VALUES (24, 'message-9c51b916-6108-4a7b-b135-74d81b24cdd8', '15510267085', 'good-4f124766-7234-44c1-84ff-793a192bdc09', '13146897978', 2, 1, '', '2021-12-03 11:59:34', '2021-12-03 11:59:34');
INSERT INTO `message` VALUES (25, 'message-96018873-2d5c-42c9-901a-529164caaf41', '13146897978', 'good-4f124766-7234-44c1-84ff-793a192bdc09', '15510267085', 5, 1, '', '2021-12-03 11:59:48', '2021-12-03 11:59:48');
INSERT INTO `message` VALUES (26, 'message-9f9e247e-3981-498c-8f12-91cde557cf46', '15510267085', 'good-6790f9a3-2f41-43e0-81ae-9c43fea2b670', '13146897978', 1, 1, '', '2021-12-03 22:06:38', '2021-12-03 22:06:38');
INSERT INTO `message` VALUES (27, 'message-e13caa4b-bdef-4c89-9492-f075f0d5d6eb', '13146897978', 'good-6790f9a3-2f41-43e0-81ae-9c43fea2b670', '15510267085', 3, 1, '', '2021-12-03 22:06:55', '2021-12-03 22:06:55');
INSERT INTO `message` VALUES (28, 'message-87340b69-931d-4c9d-9237-309d88390dee', '15510267085', 'good-6790f9a3-2f41-43e0-81ae-9c43fea2b670', '13146897978', 2, 1, '', '2021-12-03 22:07:14', '2021-12-03 22:07:14');
INSERT INTO `message` VALUES (29, 'message-a9740bd3-0750-4c5d-8259-4464bf495dc2', '18398758845', 'good-cf3848ad-1a45-4413-a69a-5adf76f464b2', '13146897978', 1, 1, '', '2021-12-04 13:23:12', '2021-12-04 13:23:12');
INSERT INTO `message` VALUES (30, 'message-1e8b7724-1325-4e29-924f-07e2f4e114f1', '18398758845', 'good-cf3848ad-1a45-4413-a69a-5adf76f464b2', '13146897978', 1, 1, '', '2021-12-04 13:23:31', '2021-12-04 13:23:31');
INSERT INTO `message` VALUES (31, 'message-d0d2e620-0127-418f-a190-a2fe71c03327', '13146897978', 'good-cf3848ad-1a45-4413-a69a-5adf76f464b2', '18398758845', 3, 1, '', '2021-12-04 13:24:09', '2021-12-04 13:24:09');
INSERT INTO `message` VALUES (32, 'message-1e9e92df-2d04-40b4-9e0d-74fb02ff6722', '18398758845', 'good-cf3848ad-1a45-4413-a69a-5adf76f464b2', '13146897978', 2, 1, '', '2021-12-04 13:24:29', '2021-12-04 13:24:29');
INSERT INTO `message` VALUES (33, 'message-6d7245e1-0798-4334-99b4-9d80ab6ff297', '13146897978', 'good-cf3848ad-1a45-4413-a69a-5adf76f464b2', '18398758845', 5, 0, '', '2021-12-04 13:24:39', '2021-12-04 13:24:39');
INSERT INTO `message` VALUES (34, 'message-612a14c4-1e95-4bb2-b95e-1ca193d8fb40', '18398758845', 'good-41bae1ec-5aa4-4a6a-8770-be3f64d4e0b4', '13146895958', 1, 0, '', '2021-12-04 13:48:30', '2021-12-04 13:48:30');
INSERT INTO `message` VALUES (35, 'message-8d756236-78c4-4fb2-942e-0129d2dd35db', '18398758845', 'good-41bae1ec-5aa4-4a6a-8770-be3f64d4e0b4', '13333333333', 1, 1, '', '2021-12-04 13:49:00', '2021-12-04 13:49:00');
INSERT INTO `message` VALUES (36, 'message-9635c5a1-fa53-4112-b3ec-317cd6b02251', '13333333333', 'good-41bae1ec-5aa4-4a6a-8770-be3f64d4e0b4', '18398758845', 3, 1, '', '2021-12-04 13:51:37', '2021-12-04 13:51:37');
INSERT INTO `message` VALUES (37, 'message-022707f4-63ff-4d5a-869c-5cdc9617fd1c', '13146895958', 'good-41bae1ec-5aa4-4a6a-8770-be3f64d4e0b4', '18398758845', 4, 1, '', '2021-12-04 13:51:37', '2021-12-04 13:51:37');
INSERT INTO `message` VALUES (38, 'message-6fd26b16-2140-463e-8c55-49f7fa216304', '18398758845', 'good-41bae1ec-5aa4-4a6a-8770-be3f64d4e0b4', '13333333333', 2, 1, '', '2021-12-04 13:53:05', '2021-12-04 13:53:05');
INSERT INTO `message` VALUES (39, 'message-2fddd45f-df93-4e53-8d5a-6d113b2b2724', '13333333333', 'good-41bae1ec-5aa4-4a6a-8770-be3f64d4e0b4', '18398758845', 5, 0, '', '2021-12-04 13:53:17', '2021-12-04 13:53:17');
INSERT INTO `message` VALUES (40, 'message-e25f452a-45b1-4cfe-b03a-49bb6bc31b68', '13146897978', 'good-6790f9a3-2f41-43e0-81ae-9c43fea2b670', '15510267085', 5, 0, '', '2021-12-08 23:03:11', '2021-12-08 23:03:11');
INSERT INTO `message` VALUES (41, 'message-a6eb621d-cb05-4180-becd-87940435376a', '13146897978', 'good-04e948ba-1df4-4a61-b7e4-057cd36f98a1', '15510267085', 3, 0, '', '2022-11-19 12:50:48', '2022-11-19 12:50:48');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单编号',
  `good_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '货物编号',
  `intention_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '意向货物编号',
  `customer_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '货主id',
  `driver_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '司机id',
  `fees` float NOT NULL DEFAULT 0 COMMENT '运费报价',
  `status` int(0) NOT NULL DEFAULT 0 COMMENT '状态\r\n0表示运输中\r\n1表示到达目的地\r\n2表示已签收',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '笔记',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `order_id`(`order_id`) USING BTREE,
  INDEX `orders_ibfk_1`(`intention_id`) USING BTREE,
  INDEX `orders_ibfk_2`(`customer_id`) USING BTREE,
  INDEX `orders_ibfk_3`(`good_id`) USING BTREE,
  INDEX `orders_ibfk_4`(`driver_id`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`intention_id`) REFERENCES `driver_intention` (`intention_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`good_id`) REFERENCES `goods` (`good_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `orders_ibfk_4` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`driver_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (16, 'order-ee16e011-634a-4c7e-b14c-d7a1d73b375b', 'good-117c24da-9af6-4122-8539-f36f74ceb811', 'intention-0ced346a-b57b-491f-9ae6-9f29c493ddd6', '15510267085', '12345678911', 111, 0, 0, '', '2021-12-02 20:11:05', '2021-12-02 20:11:05');
INSERT INTO `orders` VALUES (17, 'order-19755b2f-be78-40fd-b872-9ae0094d3dcd', 'good-24d33d44-ade9-4456-8e67-448580a086b2', 'intention-8b064ec1-bd11-4dc2-b051-e95a9eba2e5a', '15510267085', '175200277128', 99, 2, 0, '', '2021-12-03 09:01:35', '2021-12-03 09:02:34');
INSERT INTO `orders` VALUES (18, 'order-c66aebc2-95e9-4e63-89fe-15cc4433de3b', 'good-a415eb5f-f155-4956-92bc-55a797d8d4db', 'intention-2c9aec7f-5434-48cf-b4d0-de6c5d8d7db0', '15510267085', '175200277128', 100, 1, 0, '', '2021-12-03 10:11:37', '2021-12-03 10:14:08');
INSERT INTO `orders` VALUES (20, 'order-cc68d90c-f8ac-4846-b414-e8823f6da0ed', 'good-ecba4274-9e3e-4e43-8431-408740cde13b', 'intention-15d5b355-bf9d-43d5-ae2a-68b318eb2728', '18888888888', '13146897978', 1131, 1, 0, '', '2021-12-03 11:29:08', '2021-12-03 11:31:27');
INSERT INTO `orders` VALUES (21, 'order-c19eadd5-0e81-47b4-bfe2-4807cf428339', 'good-9ccc0f0d-c95d-4627-9ea2-54f6a17a8a85', 'intention-b64fc3f8-10c5-455d-8a52-1d7ae86f8606', '18888888888', '13146897978', 80, 0, 0, '', '2021-12-03 11:32:31', '2021-12-03 11:32:31');
INSERT INTO `orders` VALUES (22, 'order-5b3e7311-62d0-470c-8ca2-6a95eb0f9af9', 'good-1c90ce24-42c4-436f-9430-13b95a439819', 'intention-abbf0165-7d18-4c20-a517-a32d9800cd89', '18888888888', '13146897978', 22, 0, 0, '', '2021-12-03 11:38:01', '2021-12-03 11:38:01');
INSERT INTO `orders` VALUES (23, 'order-41fd193f-5da6-4945-9b42-2844afaa712c', 'good-4f124766-7234-44c1-84ff-793a192bdc09', 'intention-d9c11e50-3a65-4228-b56a-0f1dd28649ee', '15510267085', '13146897978', 1, 2, 0, '', '2021-12-03 11:57:33', '2021-12-03 11:59:47');
INSERT INTO `orders` VALUES (24, 'order-e144c5eb-e3ec-4983-a9e0-ca553dfa1b7b', 'good-6790f9a3-2f41-43e0-81ae-9c43fea2b670', 'intention-448a3658-fc84-44b2-bc84-5e94dcfa522b', '15510267085', '13146897978', 88, 2, 0, '', '2021-12-03 22:06:55', '2021-12-08 23:03:10');
INSERT INTO `orders` VALUES (25, 'order-1d4ed264-0a65-4387-aed7-36f10e5586ac', 'good-cf3848ad-1a45-4413-a69a-5adf76f464b2', 'intention-af370b27-797f-4c49-b4b9-3adae1d56d4d', '18398758845', '13146897978', 123, 2, 0, '', '2021-12-04 13:24:08', '2021-12-04 13:24:38');
INSERT INTO `orders` VALUES (26, 'order-fb999a53-3f79-4a37-9595-88cc366452c2', 'good-41bae1ec-5aa4-4a6a-8770-be3f64d4e0b4', 'intention-1fcd0e0e-7b7a-4124-86bd-d03178bd5e92', '18398758845', '13333333333', 50, 2, 0, '', '2021-12-04 13:51:36', '2021-12-04 13:53:17');
INSERT INTO `orders` VALUES (27, 'order-f67b70a0-5fb6-4527-ad0b-9b6a3fb6aa34', 'good-04e948ba-1df4-4a61-b7e4-057cd36f98a1', 'intention-a156ff83-f9aa-43bf-a32f-4e85dac3afd6', '15510267085', '13146897978', 300, 0, 0, '', '2022-11-19 12:50:47', '2022-11-19 12:50:47');

-- ----------------------------
-- Table structure for trading_record
-- ----------------------------
DROP TABLE IF EXISTS `trading_record`;
CREATE TABLE `trading_record`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `trade_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '交易编号',
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '订单编号',
  `login_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户主键',
  `sources` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '来源，0表示系统，loginId表示来源',
  `status` int(0) NOT NULL DEFAULT 0 COMMENT '付款类型 0未知 1.充值，2.货主付款 3.司机收款',
  `fees` float NOT NULL COMMENT '钱数',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '笔记',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `trade_id`(`trade_id`) USING BTREE,
  INDEX `trading_record_ibfk_1`(`login_id`) USING BTREE,
  CONSTRAINT `trading_record_ibfk_1` FOREIGN KEY (`login_id`) REFERENCES `login_user` (`login_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '交易记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trading_record
-- ----------------------------
INSERT INTO `trading_record` VALUES (2, 'trade-e58d788d-92a2-4cf6-8fd5-38137f04c32f', '', '15510267085', '0', 1, 10, 0, '', '2021-12-01 19:20:37', '2021-12-01 22:24:13');
INSERT INTO `trading_record` VALUES (3, 'trade-c47a45ba-6554-4962-b338-f7ff41d25d3d', '', '15510267085', '0', 1, 50, 0, '', '2021-12-01 19:29:15', '2021-12-01 22:24:15');
INSERT INTO `trading_record` VALUES (4, 'trade-5e83f2b5-32ae-418b-a83d-34af84964137', '', '15510267085', '0', 1, 35, 0, '', '2021-12-01 22:24:33', '2021-12-01 22:24:33');
INSERT INTO `trading_record` VALUES (5, 'trade-45984314-09eb-4570-ba26-7397df785f84', 'order-95a80233-488d-48aa-829e-14f140492670', '15510267085', '175200277128', 2, -300, 0, '', '2021-12-01 22:26:11', '2021-12-01 22:28:03');
INSERT INTO `trading_record` VALUES (6, 'trade-c82d9169-0157-4bd8-ae96-379126754782', '', '18888888888', '0', 1, 648, 0, '', '2021-12-01 22:57:23', '2021-12-01 22:57:23');
INSERT INTO `trading_record` VALUES (8, 'trade-90610303-268d-42c0-83a6-dee21d024e1a', '', '18888888888', '0', 1, 300, 0, '', '2021-12-01 23:04:43', '2021-12-01 23:04:43');
INSERT INTO `trading_record` VALUES (11, 'trade-f0b0101f-8d10-434b-98a6-48ab050252b0', 'order-047f1518-56c3-42a6-8227-ce68ef645cf0', '18888888888', '13146897978', 2, -350, 0, '', '2021-12-01 23:08:00', '2021-12-01 23:29:55');
INSERT INTO `trading_record` VALUES (12, 'trade-6dbaa40b-d6ed-4dae-8b66-6d6bec9b81a7', 'order-047f1518-56c3-42a6-8227-ce68ef645cf0', '13146897978', '18888888888', 3, 350, 0, '', '2021-12-01 23:08:33', '2021-12-01 23:08:33');
INSERT INTO `trading_record` VALUES (13, 'trade-8be499cc-8151-496d-b42e-32c37c0cf176', '', '18888888888', '0', 1, 648, 0, '', '2021-12-01 23:29:14', '2021-12-01 23:29:14');
INSERT INTO `trading_record` VALUES (14, 'trade-5b9b2f91-e665-4562-80d1-bb4e229c654e', '', '18888888888', '0', 1, 6, 0, '', '2021-12-02 15:57:11', '2021-12-02 15:57:11');
INSERT INTO `trading_record` VALUES (15, 'trade-77c4c7ba-d23e-4212-8e85-c5e300633ab1', 'order-d2e11289-e2ac-48d6-b011-519f72278e44', '18888888888', '12345678911', 2, -666, 0, '', '2021-12-02 15:58:53', '2021-12-02 15:58:53');
INSERT INTO `trading_record` VALUES (16, 'trade-e1b99865-7938-4d09-a6ba-7a2debfbbb78', 'order-a455a378-d03c-4a77-a162-579590410e9d', '18888888888', '12345678911', 2, -222, 0, '', '2021-12-02 16:02:50', '2021-12-02 16:02:50');
INSERT INTO `trading_record` VALUES (17, 'trade-4dfb047a-7c35-4b67-ba86-d3ae504156c3', 'order-d2e11289-e2ac-48d6-b011-519f72278e44', '12345678911', '18888888888', 3, 666, 0, '', '2021-12-02 16:05:40', '2021-12-02 16:05:40');
INSERT INTO `trading_record` VALUES (18, 'trade-6e718dd3-39b1-4b91-96c9-a646bdb83fd7', '', '12345678911', '0', 1, 666, 0, '', '2021-12-02 16:06:03', '2021-12-02 16:06:03');
INSERT INTO `trading_record` VALUES (19, 'trade-57c5954d-c818-40f7-be9c-56e33889a3d4', 'order-a455a378-d03c-4a77-a162-579590410e9d', '12345678911', '18888888888', 3, 222, 0, '', '2021-12-02 16:07:38', '2021-12-02 16:07:38');
INSERT INTO `trading_record` VALUES (20, 'trade-e2f8392c-b1ce-4295-a68c-83f6d965c264', '', '18888888888', '0', 1, 10000000, 0, '', '2021-12-02 16:16:27', '2021-12-02 16:16:27');
INSERT INTO `trading_record` VALUES (21, 'trade-05685158-2d22-4b1d-8242-9925257abbfb', 'order-e74251c7-df5e-479f-99c4-644d0354717f', '18888888888', '12345678911', 2, -99, 0, '', '2021-12-02 16:16:34', '2021-12-02 16:16:34');
INSERT INTO `trading_record` VALUES (22, 'trade-b8f84f8c-6e40-4b92-844f-c50c0588318c', '', '15510267085', '0', 1, 11111, 0, '', '2021-12-02 16:24:23', '2021-12-02 16:24:23');
INSERT INTO `trading_record` VALUES (23, 'trade-6d82d667-c128-4da2-aefa-1b1d316b1c4e', '', '13146897978', '0', 1, 111, 0, '', '2021-12-02 19:54:21', '2021-12-02 19:54:21');
INSERT INTO `trading_record` VALUES (24, 'trade-3022cfb0-e476-4290-88f1-a8faaf27c3a1', '', '13146897978', '0', 1, 11111, 0, '', '2021-12-02 19:54:24', '2021-12-02 19:54:24');
INSERT INTO `trading_record` VALUES (25, 'trade-32bfbe26-dd3a-4dba-938b-ff1a0d614a26', '', '13146897978', '0', 1, 11111, 0, '', '2021-12-02 19:54:26', '2021-12-02 19:54:26');
INSERT INTO `trading_record` VALUES (26, 'trade-4d16395f-f921-4e69-95b0-fbdf0099792f', '', '13146897978', '0', 1, 11111, 0, '', '2021-12-02 19:54:28', '2021-12-02 19:54:28');
INSERT INTO `trading_record` VALUES (27, 'trade-95ae0e0f-14a1-4ba0-b1d9-68ce8d7b7081', '', '13146897978', '0', 1, 11111, 0, '', '2021-12-02 19:54:30', '2021-12-02 19:54:30');
INSERT INTO `trading_record` VALUES (28, 'trade-430c4ec0-ac0c-4b94-99a1-f56fca725bb9', '', '13146897978', '0', 1, 11111, 0, '', '2021-12-02 19:54:34', '2021-12-02 19:54:34');
INSERT INTO `trading_record` VALUES (29, 'trade-4fd01355-32d3-4d01-b108-b0709a8ffe44', 'order-ee16e011-634a-4c7e-b14c-d7a1d73b375b', '15510267085', '12345678911', 2, -111, 0, '', '2021-12-02 20:11:07', '2021-12-02 20:11:07');
INSERT INTO `trading_record` VALUES (30, 'trade-03349666-1452-423d-9d34-6226ee5caa4e', 'order-19755b2f-be78-40fd-b872-9ae0094d3dcd', '15510267085', '175200277128', 2, -99, 0, '', '2021-12-03 09:01:35', '2021-12-03 09:01:35');
INSERT INTO `trading_record` VALUES (31, 'trade-e140c06d-4941-4b97-8cd3-86f83888b0b7', 'order-19755b2f-be78-40fd-b872-9ae0094d3dcd', '175200277128', '15510267085', 3, 99, 0, '', '2021-12-03 09:02:34', '2021-12-03 09:02:34');
INSERT INTO `trading_record` VALUES (32, 'trade-a63f86ff-c85b-47e1-a3b9-be0d8fb01742', '', '175200277128', '0', 1, 99, 0, '', '2021-12-03 09:11:51', '2021-12-03 09:11:51');
INSERT INTO `trading_record` VALUES (33, 'trade-0ab5ba8f-073a-42cf-a207-53cba2a95597', 'order-c66aebc2-95e9-4e63-89fe-15cc4433de3b', '15510267085', '175200277128', 2, -100, 0, '', '2021-12-03 10:11:37', '2021-12-03 10:11:37');
INSERT INTO `trading_record` VALUES (34, 'trade-32677519-2452-4adc-93b3-f9742e65182f', 'order-c9db197f-4285-43f8-bded-e0589b091874', '18888888888', '13146897978', 2, -10, 0, '', '2021-12-03 11:19:57', '2021-12-03 11:19:57');
INSERT INTO `trading_record` VALUES (35, 'trade-46a290fb-e6e3-4ee2-9c6a-87a55e280013', 'order-cc68d90c-f8ac-4846-b414-e8823f6da0ed', '18888888888', '13146897978', 2, -1131, 0, '', '2021-12-03 11:29:08', '2021-12-03 11:29:08');
INSERT INTO `trading_record` VALUES (36, 'trade-df14fef6-3e49-4014-8330-f6ac67d8b1a3', 'order-c19eadd5-0e81-47b4-bfe2-4807cf428339', '18888888888', '13146897978', 2, -80, 0, '', '2021-12-03 11:32:31', '2021-12-03 11:32:31');
INSERT INTO `trading_record` VALUES (37, 'trade-c6ad7a76-4954-4972-8bfd-f162274f8e8c', 'order-5b3e7311-62d0-470c-8ca2-6a95eb0f9af9', '18888888888', '13146897978', 2, -22, 0, '', '2021-12-03 11:38:02', '2021-12-03 11:38:02');
INSERT INTO `trading_record` VALUES (38, 'trade-5c489b9c-4a87-497d-b873-476919ffdd63', 'order-41fd193f-5da6-4945-9b42-2844afaa712c', '15510267085', '13146897978', 2, -1, 0, '', '2021-12-03 11:57:34', '2021-12-03 11:57:34');
INSERT INTO `trading_record` VALUES (39, 'trade-2649468f-ca71-4a7b-8e92-684e2fe3f013', 'order-41fd193f-5da6-4945-9b42-2844afaa712c', '13146897978', '15510267085', 3, 1, 0, '', '2021-12-03 11:59:48', '2021-12-03 11:59:48');
INSERT INTO `trading_record` VALUES (40, 'trade-9036d745-e23f-4092-93a9-9d63c3a98f0d', 'order-e144c5eb-e3ec-4983-a9e0-ca553dfa1b7b', '15510267085', '13146897978', 2, -88, 0, '', '2021-12-03 22:06:55', '2021-12-03 22:06:55');
INSERT INTO `trading_record` VALUES (41, 'trade-e818236e-7c50-430f-bc58-7b32c7efa2d2', '', '18398758845', '0', 1, 648, 0, '', '2021-12-04 13:20:10', '2021-12-04 13:20:10');
INSERT INTO `trading_record` VALUES (42, 'trade-5d338113-edb2-4523-931f-15d41b273553', 'order-1d4ed264-0a65-4387-aed7-36f10e5586ac', '18398758845', '13146897978', 2, -123, 0, '', '2021-12-04 13:24:09', '2021-12-04 13:24:09');
INSERT INTO `trading_record` VALUES (43, 'trade-7aa1c63d-0000-4334-9d6a-7ab7b35727ad', 'order-1d4ed264-0a65-4387-aed7-36f10e5586ac', '13146897978', '18398758845', 3, 123, 0, '', '2021-12-04 13:24:39', '2021-12-04 13:24:39');
INSERT INTO `trading_record` VALUES (44, 'trade-834ce162-0c10-4852-86d7-8b38d347223e', 'order-fb999a53-3f79-4a37-9595-88cc366452c2', '18398758845', '13333333333', 2, -50, 0, '', '2021-12-04 13:51:37', '2021-12-04 13:51:37');
INSERT INTO `trading_record` VALUES (45, 'trade-0b726a0e-6717-49b2-a487-6b8667b0d205', '', '18398758845', '0', 1, 10, 0, '', '2021-12-04 13:52:50', '2021-12-04 13:52:50');
INSERT INTO `trading_record` VALUES (46, 'trade-00e742f8-bf1b-411f-bc37-71817ab6e29d', 'order-fb999a53-3f79-4a37-9595-88cc366452c2', '13333333333', '18398758845', 3, 50, 0, '', '2021-12-04 13:53:17', '2021-12-04 13:53:17');
INSERT INTO `trading_record` VALUES (47, 'trade-62a08674-cf17-4aae-98bb-f4cd9c1fef71', 'order-e144c5eb-e3ec-4983-a9e0-ca553dfa1b7b', '13146897978', '15510267085', 3, 88, 0, '', '2021-12-08 23:03:10', '2021-12-08 23:03:10');
INSERT INTO `trading_record` VALUES (48, 'trade-1cb8c309-dbdd-41ea-804e-ffb47a7daa2b', '', '15510267085', '0', 1, 648, 0, '', '2021-12-08 23:03:26', '2021-12-08 23:03:26');
INSERT INTO `trading_record` VALUES (49, 'trade-10955481-0a9e-4e43-94ed-f49e9a08b2aa', 'order-f67b70a0-5fb6-4527-ad0b-9b6a3fb6aa34', '15510267085', '13146897978', 2, -300, 0, '', '2022-11-19 12:50:47', '2022-11-19 12:50:47');
INSERT INTO `trading_record` VALUES (50, 'trade-5caace30-458c-44e7-a861-463c3d7f4fa8', '', '15510267085', '0', 1, 20, 0, '', '2022-11-19 12:51:07', '2022-11-19 12:51:07');

SET FOREIGN_KEY_CHECKS = 1;
