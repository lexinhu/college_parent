/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 127.0.0.1:3306
 Source Schema         : edu_trade

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 16/08/2020 22:51:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for trade_order
-- ----------------------------
DROP TABLE IF EXISTS `trade_order`;
CREATE TABLE `trade_order`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `order_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '订单号',
  `course_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '课程id',
  `course_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程名称',
  `course_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程封面',
  `teacher_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '讲师名称',
  `member_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员昵称',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员手机',
  `total_fee` decimal(20, 2) NULL DEFAULT NULL COMMENT '订单金额（分）',
  `pay_type` tinyint(0) NULL DEFAULT NULL COMMENT '支付类型（1：微信 2：支付宝）',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '订单状态（0：未支付 1：已支付）',
  `is_deleted` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ux_order_no`(`order_no`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE,
  INDEX `idx_member_id`(`member_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trade_order
-- ----------------------------
INSERT INTO `trade_order` VALUES ('1290520153532026882', '20200804132915504', '1283009951186538497', 'MySQL性能瓶颈', 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/cover/2020/07/14/20200714200621.jpg', '钟小湖', '1288903814354698242', '乐心湖', '13729207180', 88800.00, 1, 0, 1, '2020-08-04 13:29:16', '2020-08-04 13:29:16');
INSERT INTO `trade_order` VALUES ('1290549452163223553', '20200804152541380', '1283009951186538497', 'MySQL性能瓶颈', 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/cover/2020/07/14/20200714200621.jpg', '钟小湖', '1288903814354698242', '乐心湖', '13729207180', 88800.00, 1, 0, 1, '2020-08-04 15:25:41', '2020-08-04 15:25:41');
INSERT INTO `trade_order` VALUES ('1290631296195985409', '20200804205054296', '1283009951186538497', 'MySQL性能瓶颈', 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/cover/2020/07/14/20200714200621.jpg', '钟小湖', '1288903814354698242', '乐心湖', '13729207180', 1.00, 1, 1, 0, '2020-08-04 20:50:54', '2020-08-04 20:50:54');
INSERT INTO `trade_order` VALUES ('1290639339612688385', '20200804212252819', '1282899934500245505', 'Linux高级', 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/cover/2020/07/15/20200715042605.jpg', '陈苗苗', '1288903814354698242', '乐心湖', '13729207180', 1.00, 1, 1, 0, '2020-08-04 21:22:52', '2020-08-04 21:22:52');

-- ----------------------------
-- Table structure for trade_pay_log
-- ----------------------------
DROP TABLE IF EXISTS `trade_pay_log`;
CREATE TABLE `trade_pay_log`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `order_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '订单号',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付完成时间',
  `total_fee` bigint(0) NULL DEFAULT NULL COMMENT '支付金额（分）',
  `transaction_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '交易流水号',
  `trade_state` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '交易状态',
  `pay_type` tinyint(0) NOT NULL DEFAULT 0 COMMENT '支付类型（1：微信 2：支付宝）',
  `attr` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '其他属性',
  `is_deleted` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_order_no`(`order_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '支付日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trade_pay_log
-- ----------------------------
INSERT INTO `trade_pay_log` VALUES ('1290631420355772417', '20200804205054296', '2020-08-04 20:51:24', 1, '4200000600202008043507950371', 'SUCCESS', 1, '{\"transaction_id\":\"4200000600202008043507950371\",\"nonce_str\":\"6bf309a6c7e549dab8ae4f8a84f55790\",\"bank_type\":\"OTHERS\",\"openid\":\"oQTXC53sVJhk2PTlSBj6PVInC1v8\",\"sign\":\"8464CF2E566813E67F63FD2692E34D95\",\"fee_type\":\"CNY\",\"mch_id\":\"1543338551\",\"cash_fee\":\"1\",\"out_trade_no\":\"20200804205054296\",\"appid\":\"wxf913bfa3a2c7eeeb\",\"total_fee\":\"1\",\"trade_type\":\"NATIVE\",\"result_code\":\"SUCCESS\",\"time_end\":\"20200804205120\",\"is_subscribe\":\"N\",\"return_code\":\"SUCCESS\"}', 0, '2020-08-04 20:51:24', '2020-08-04 20:51:24');
INSERT INTO `trade_pay_log` VALUES ('1290639447309832194', '20200804212252819', '2020-08-04 21:23:18', 1, '4200000588202008042253619487', 'SUCCESS', 1, '{\"transaction_id\":\"4200000588202008042253619487\",\"nonce_str\":\"85566d655ae84994afaf057a29cb04ee\",\"bank_type\":\"OTHERS\",\"openid\":\"oQTXC53sVJhk2PTlSBj6PVInC1v8\",\"sign\":\"17536151CC5C42ED3854265A8F5437B4\",\"fee_type\":\"CNY\",\"mch_id\":\"1543338551\",\"cash_fee\":\"1\",\"out_trade_no\":\"20200804212252819\",\"appid\":\"wxf913bfa3a2c7eeeb\",\"total_fee\":\"1\",\"trade_type\":\"NATIVE\",\"result_code\":\"SUCCESS\",\"time_end\":\"20200804212312\",\"is_subscribe\":\"N\",\"return_code\":\"SUCCESS\"}', 0, '2020-08-04 21:23:18', '2020-08-04 21:23:18');

SET FOREIGN_KEY_CHECKS = 1;
