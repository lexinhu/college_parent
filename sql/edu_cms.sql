/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 127.0.0.1:3306
 Source Schema         : edu_cms

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 16/08/2020 22:51:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cms_ad
-- ----------------------------
DROP TABLE IF EXISTS `cms_ad`;
CREATE TABLE `cms_ad`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'ID',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '标题',
  `type_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类型ID',
  `image_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '图片地址',
  `color` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '背景颜色',
  `link_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '链接地址',
  `sort` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '广告推荐' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_ad
-- ----------------------------
INSERT INTO `cms_ad` VALUES ('1288062905631248386', '广告1', '1', 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/ad/2020/07/28/20200728184454.jpg', '#BCAFAF', '', 1, '2020-07-28 18:45:02', '2020-07-28 18:45:02');
INSERT INTO `cms_ad` VALUES ('1288062993086681089', '广告2', '1', 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/ad/2020/07/28/20200728184519.jpg', '#483A3A', '', 0, '2020-07-28 18:45:23', '2020-07-28 18:45:23');
INSERT INTO `cms_ad` VALUES ('1288063060078104577', '广告3', '1', 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/ad/2020/07/28/20200728184730.jpg', NULL, '', 0, '2020-07-28 18:45:39', '2020-07-28 18:45:39');

-- ----------------------------
-- Table structure for cms_ad_type
-- ----------------------------
DROP TABLE IF EXISTS `cms_ad_type`;
CREATE TABLE `cms_ad_type`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '推荐位' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_ad_type
-- ----------------------------
INSERT INTO `cms_ad_type` VALUES ('1', '首页', '2020-07-28 17:50:33', '2020-07-28 17:50:33');

SET FOREIGN_KEY_CHECKS = 1;
