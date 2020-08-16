/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : edu_ucenter

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 16/08/2020 22:51:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ucenter_member
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_member`;
CREATE TABLE `ucenter_member`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '会员id',
  `openid` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信openid',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '手机号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(0) UNSIGNED NULL DEFAULT NULL COMMENT '性别 1 男，2 女',
  `age` tinyint(0) UNSIGNED NULL DEFAULT NULL COMMENT '年龄',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像',
  `sign` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户签名',
  `is_disabled` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否禁用 1（true）已禁用，  0（false）未禁用',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ucenter_member
-- ----------------------------
INSERT INTO `ucenter_member` VALUES ('1080736474267144193', NULL, '13700000011', '96e79218965eb72c92a549dd5a330112', '用户XJtDfaYeKk', 1, 19, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', NULL, 0, 0, '2019-01-02 12:12:45', '2019-01-02 12:12:56');
INSERT INTO `ucenter_member` VALUES ('1080736474355224577', NULL, '13700000002', '96e79218965eb72c92a549dd5a330112', '用户wUrNkzAPrc', 1, 27, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', NULL, 0, 0, '2019-01-02 12:13:56', '2019-01-02 12:14:07');
INSERT INTO `ucenter_member` VALUES ('1086387099449442306', NULL, '13520191388', '96e79218965eb72c92a549dd5a330112', '用户XTMUeHDAoj', 2, 20, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', NULL, 0, 0, '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `ucenter_member` VALUES ('1086387099520745473', NULL, '13520191389', '96e79218965eb72c92a549dd5a330112', '用户vSdKeDlimn', 1, 21, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', NULL, 0, 0, '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `ucenter_member` VALUES ('1086387099608825858', NULL, '13520191381', '96e79218965eb72c92a549dd5a330112', '用户EoyWUVXQoP', 1, 18, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', NULL, 0, 0, '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `ucenter_member` VALUES ('1086387099701100545', NULL, '13520191382', '96e79218965eb72c92a549dd5a330112', '用户LcAYbxLNdN', 2, 24, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', NULL, 0, 0, '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `ucenter_member` VALUES ('1086387099776598018', NULL, '13520191383', '96e79218965eb72c92a549dd5a330112', '用户dZdjcgltnk', 2, 25, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', NULL, 0, 0, '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `ucenter_member` VALUES ('1086387099852095490', NULL, '13520191384', '96e79218965eb72c92a549dd5a330112', '用户wNHGHlxUwX', 2, 23, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', NULL, 0, 0, '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `ucenter_member` VALUES ('1106746895272849410', 'o1R-t5u2TfEVeVjO9CPGdHPNw-to', NULL, NULL, '檀梵\'', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/zZfLXcetf2Rpsibq6HbPUWKgWSJHtha9y1XBeaqluPUs6BYicW1FJaVqj7U3ozHd3iaodGKJOvY2PvqYTuCKwpyfQ/132', NULL, 0, 0, '2019-03-16 10:39:57', '2019-03-16 10:39:57');
INSERT INTO `ucenter_member` VALUES ('1106823035660357634', 'o1R-t5i4gENwHYRb5lVFy98Z0bdk', NULL, NULL, 'GaoSir', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJI53RcCuc1no02os6ZrattWGiazlPnicoZQ59zkS7phNdLEWUPDk8fzoxibAnXV1Sbx0trqXEsGhXPw/132', NULL, 0, 0, '2019-03-16 15:42:30', '2019-03-16 15:42:30');
INSERT INTO `ucenter_member` VALUES ('1106823115788341250', 'o1R-t5l_3rnbZbn4jWwFdy6Gk6cg', NULL, NULL, '换个网名哇、', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/jJHyeM0EN2jhB70LntI3k8fEKe7W6CwykrKMgDJM4VZqCpcxibVibX397p0vmbKURGkLS4jxjGB0GpZfxCicgt07w/132', NULL, 0, 0, '2019-03-16 15:42:49', '2019-03-16 15:42:49');
INSERT INTO `ucenter_member` VALUES ('1106828185829490690', 'o1R-t5nNlou5lRwBVgGNJFm4rbc4', NULL, NULL, ' 虎头', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKxCqRzuYWQmpwiaqQEjNxbC7WicebicXQusU306jgmfoOzUcFg1qaDq5BStiblwBjw5dUOblQ2gUicQOQ/132', NULL, 0, 0, '2019-03-16 16:02:58', '2019-03-16 16:02:58');
INSERT INTO `ucenter_member` VALUES ('1106830599651442689', 'o1R-t5hZHQB1cbX7HZJsiM727_SA', NULL, NULL, '是吴啊', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ9CsqApybcs7f3Dyib9IxIh0sBqJb7LicbjU4WticJFF0PVwFvHgtbFdBwfmk3H2t3NyqmEmVx17tRA/132', NULL, 0, 0, '2019-03-16 16:12:34', '2019-03-16 16:12:34');
INSERT INTO `ucenter_member` VALUES ('1106830976199278593', 'o1R-t5meKOoyEJ3-IhWRCBKFcvzU', NULL, NULL, '我才是Helen', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epMicP9UT6mVjYWdno0OJZkOXiajG0sllJTbGJ9DYiceej2XvbDSGCK8LCF7jv1PuG2uoYlePWic9XO8A/132', NULL, 0, 0, '2019-03-16 16:14:03', '2019-03-16 16:14:03');
INSERT INTO `ucenter_member` VALUES ('1106831936900415490', 'o1R-t5jXYSWakGtnUBnKbfVT5Iok', NULL, NULL, '文若姬', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/3HEmJwpSzguqqAyzmBwqT6aicIanswZibEOicQInQJI3ZY1qmu59icJC6N7SahKqWYv24GvX5KH2fibwt0mPWcTJ3fg/132', NULL, 0, 0, '2019-03-16 16:17:52', '2019-03-16 16:17:52');
INSERT INTO `ucenter_member` VALUES ('1106832491064442882', 'o1R-t5sud081Qsa2Vb2xSKgGnf_g', NULL, NULL, 'Peanut', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', NULL, 0, 0, '2019-03-16 16:20:04', '2019-03-16 16:20:04');
INSERT INTO `ucenter_member` VALUES ('1106833021442510849', 'o1R-t5lsGc3I8P5bDpHj7m_AIRvQ', NULL, NULL, '食物链终结者', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/MQ7qUmCprK9am16M1Ia1Cs3RK0qiarRrl9y8gsssBjIZeS2GwKSrnq7ZYhmrzuzDwBxSMMAofrXeLic9IBlW4M3Q/132', NULL, 0, 0, '2019-03-16 16:22:11', '2019-03-16 16:22:11');
INSERT INTO `ucenter_member` VALUES ('1191600824445046786', NULL, '15210078344', '96e79218965eb72c92a549dd5a330112', 'IT妖姬', 1, 5, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', NULL, 0, 0, '2019-11-05 14:19:10', '2019-11-08 18:04:43');
INSERT INTO `ucenter_member` VALUES ('1191616288114163713', NULL, '17866603606', '96e79218965eb72c92a549dd5a330112', 'xiaowu', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', NULL, 0, 0, '2019-11-05 15:20:37', '2019-11-05 15:20:37');
INSERT INTO `ucenter_member` VALUES ('1195187659054329857', NULL, '15010546384', '96e79218965eb72c92a549dd5a330112', 'qy', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', NULL, 0, 0, '2019-11-15 11:51:58', '2019-11-15 11:51:58');
INSERT INTO `ucenter_member` VALUES ('1203050193780584450', NULL, '18686842318', 'e10adc3949ba59abbe56e057f20f883e', 'cohen', NULL, NULL, 'https://online-teach-file-helen.oss-cn-beijing.aliyuncs.com/avatar/default.jpg', NULL, 0, 0, '2019-12-07 04:34:52', '2019-12-07 04:34:52');
INSERT INTO `ucenter_member` VALUES ('1203065189981810689', NULL, '13766816630', 'e10adc3949ba59abbe56e057f20f883e', 'helen', NULL, NULL, 'https://online-teach-file-helen.oss-cn-beijing.aliyuncs.com/avatar/default.jpg', NULL, 0, 0, '2019-12-07 05:34:28', '2019-12-07 05:34:28');
INSERT INTO `ucenter_member` VALUES ('1203898148695597058', 'o3_SC58aj3laPkwse2H2mBP8PFyk', '', NULL, '我是Helenฉันคิดถึง', 2, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIhQbQxWia9dQyfUESGSiaI2qxgznhNsRsOoxYXGwn65icSYGRcosxdqTRA4a1g23icGLMSKPibxa0PHGg/132', NULL, 0, 0, '2019-12-09 12:44:21', '2019-12-09 12:44:21');
INSERT INTO `ucenter_member` VALUES ('1288903814354698242', NULL, '13729207180', 'e10adc3949ba59abbe56e057f20f883e', '乐心湖', NULL, NULL, 'https://guli-file-helen.oss-cn-beijing.aliyuncs.com/avatar/default.jpg', NULL, 0, 0, '2020-07-31 02:26:31', '2020-07-31 02:26:31');
INSERT INTO `ucenter_member` VALUES ('1289585306412249089', 'o3_SC56H6mypiPWpAsuG1XXxGx_s', '', NULL, '得了', 1, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjsXq0kW8K28pphuHF3wiahg9vQrK7iay0vazdZaS8H57mapq5yQXfLBBibHSibZOJGNsuTqqA7ic2voA/132', NULL, 0, 0, '2020-08-01 23:34:31', '2020-08-01 23:34:31');

SET FOREIGN_KEY_CHECKS = 1;
