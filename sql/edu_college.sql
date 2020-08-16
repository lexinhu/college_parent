/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : edu_college

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 16/08/2020 22:51:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for edu_chapter
-- ----------------------------
DROP TABLE IF EXISTS `edu_chapter`;
CREATE TABLE `edu_chapter`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '章节ID',
  `course_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程ID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '章节名称',
  `sort` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '显示排序',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of edu_chapter
-- ----------------------------
INSERT INTO `edu_chapter` VALUES ('1283811262412816386', '1283009951186538497', '第一章-MySQL基础复习', 0, '2020-07-17 01:10:32', '2020-07-17 01:10:32');
INSERT INTO `edu_chapter` VALUES ('1283814341837258754', '1283009951186538497', '第二章-MySQL存储引擎', 0, '2020-07-17 01:22:46', '2020-07-17 01:22:46');
INSERT INTO `edu_chapter` VALUES ('1284034348756107265', '1283009951186538497', '第三者-MySQL索引优化', 0, '2020-07-17 15:57:00', '2020-07-17 15:57:00');
INSERT INTO `edu_chapter` VALUES ('1284034433770455042', '1283009951186538497', '第四章-MySQL多表联查', 0, '2020-07-17 15:57:20', '2020-07-17 15:57:20');
INSERT INTO `edu_chapter` VALUES ('1290839564038057985', '1282899934500245505', '第一章 ', 0, '2020-08-05 10:38:29', '2020-08-05 10:38:29');

-- ----------------------------
-- Table structure for edu_comment
-- ----------------------------
DROP TABLE IF EXISTS `edu_comment`;
CREATE TABLE `edu_comment`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '讲师ID',
  `course_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '课程id',
  `teacher_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '讲师id',
  `member_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员昵称',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员头像',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE,
  INDEX `idx_teacher_id`(`teacher_id`) USING BTREE,
  INDEX `idx_member_id`(`member_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_comment
-- ----------------------------

-- ----------------------------
-- Table structure for edu_course
-- ----------------------------
DROP TABLE IF EXISTS `edu_course`;
CREATE TABLE `edu_course`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程ID',
  `teacher_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程讲师ID',
  `subject_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程专业ID',
  `subject_parent_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程专业父级ID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程标题',
  `price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '课程销售价格，设置为0则可免费观看',
  `lesson_num` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '总课时',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程封面图片路径',
  `buy_count` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '销售数量',
  `view_count` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '浏览数量',
  `version` bigint(0) UNSIGNED NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Draft' COMMENT '课程状态 Draft未发布  Normal已发布',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_title`(`title`) USING BTREE,
  INDEX `idx_subject_id`(`subject_id`) USING BTREE,
  INDEX `idx_teacher_id`(`teacher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of edu_course
-- ----------------------------
INSERT INTO `edu_course` VALUES ('1282745841639186434', '1282651629472145410', '1282653842487599105', '1282653842470821890', 'Java初级语法', 5.00, 10, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/cover/2020/07/15/20200715042626.jpg', 0, 3, 1, 'Normal', '2020-07-14 02:36:56', '2020-07-17 13:29:34');
INSERT INTO `edu_course` VALUES ('1282898591765192706', '1282652146675965954', '1282653842521153538', '1282653842470821890', 'Python进阶', 999.00, 1, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/cover/2020/07/15/20200715042639.jpg', 0, 12, 1, 'Normal', '2020-07-14 12:43:54', '2020-07-16 03:52:47');
INSERT INTO `edu_course` VALUES ('1282899934500245505', '1282653117380517890', '1282653842676342786', '1282653842655371266', 'Linux高级', 0.01, 6, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/cover/2020/07/15/20200715042605.jpg', 1, 10, 1, 'Normal', '2020-07-14 12:49:14', '2020-08-05 10:39:02');
INSERT INTO `edu_course` VALUES ('1283009951186538497', '1282651629472145410', '1282653842730868737', '1282653842718285825', 'MySQL性能瓶颈', 0.01, 8, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/cover/2020/07/14/20200714200621.jpg', 0, 51, 1, 'Normal', '2020-07-14 20:06:24', '2020-08-05 18:22:06');

-- ----------------------------
-- Table structure for edu_course_collect
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_collect`;
CREATE TABLE `edu_course_collect`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收藏ID',
  `course_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程讲师ID',
  `member_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '课程专业ID',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程收藏' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of edu_course_collect
-- ----------------------------
INSERT INTO `edu_course_collect` VALUES ('1290568019134820353', '1283009951186538497', '1288903814354698242', '2020-08-04 16:39:28', '2020-08-04 16:39:28');

-- ----------------------------
-- Table structure for edu_course_description
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_description`;
CREATE TABLE `edu_course_description`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程ID',
  `description` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '课程简介',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程简介' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_course_description
-- ----------------------------
INSERT INTO `edu_course_description` VALUES ('1282745841639186434', '<p><img src=\"static/tinymce4.7.5/plugins/emoticons/img/smiley-cool.gif\" alt=\"cool\" />一起来学习吧</p>', '2020-07-14 02:36:56', '2020-07-15 04:26:29');
INSERT INTO `edu_course_description` VALUES ('1282898591765192706', '<p><img src=\"static/tinymce4.7.5/plugins/emoticons/img/smiley-sealed.gif\" alt=\"sealed\" /></p>', '2020-07-14 12:43:54', '2020-07-15 04:26:40');
INSERT INTO `edu_course_description` VALUES ('1282899934500245505', '', '2020-07-14 12:49:14', '2020-08-05 10:38:22');
INSERT INTO `edu_course_description` VALUES ('1283009951186538497', '<p>大佬给他上一课</p>', '2020-07-14 20:06:24', '2020-08-04 20:43:08');

-- ----------------------------
-- Table structure for edu_subject
-- ----------------------------
DROP TABLE IF EXISTS `edu_subject`;
CREATE TABLE `edu_subject`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程类别ID',
  `title` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类别名称',
  `parent_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序字段',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_parent_id`(`parent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程科目' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of edu_subject
-- ----------------------------
INSERT INTO `edu_subject` VALUES ('1282653842470821890', '后端开发', '0', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842487599105', 'Java', '1282653842470821890', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842521153538', 'Python', '1282653842470821890', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842537930753', '前端开发', '0', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842554707970', 'HTML/CSS', '1282653842537930753', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842571485185', 'JavaScript', '1282653842537930753', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842596651009', '云计算', '0', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842613428226', 'Docker', '1282653842596651009', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842638594049', 'Linux', '1282653842596651009', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842655371266', '系统/运维', '0', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842676342786', 'Linux', '1282653842655371266', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842701508610', 'Windows', '1282653842655371266', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842718285825', '数据库', '0', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842730868737', 'MySQL', '1282653842718285825', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842760228866', 'MongoDB', '1282653842718285825', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842781200385', '大数据', '0', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842789588994', 'Hadoop', '1282653842781200385', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842814754817', 'Spark', '1282653842781200385', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842831532034', '人工智能', '0', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842848309249', 'Python', '1282653842831532034', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842865086466', '编程语言', '0', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');
INSERT INTO `edu_subject` VALUES ('1282653842881863681', 'Java', '1282653842865086466', 0, '2020-07-13 20:31:21', '2020-07-13 20:31:21');

-- ----------------------------
-- Table structure for edu_teacher
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher`;
CREATE TABLE `edu_teacher`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '讲师ID',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '讲师姓名',
  `intro` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '讲师简介',
  `career` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '讲师资历,一句话说明讲师',
  `level` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '头衔 1高级讲师 2首席讲师',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '讲师头像',
  `sort` int(0) UNSIGNED NULL DEFAULT 0 COMMENT '排序',
  `join_date` date NULL DEFAULT NULL COMMENT '入驻时间',
  `is_deleted` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uk_name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '讲师' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_teacher
-- ----------------------------
INSERT INTO `edu_teacher` VALUES ('1282651160356020225', '王一明', '中国人民大学附属中学数学一级教师', '中国科学院数学与系统科学研究院应用数学专业博士，研究方向为数字图像处理，中国工业与应用数学学会会员。参与全国教育科学“十五”规划重点课题“信息化进程中的教育技术发展研究”的子课题“基与课程改革的资源开发与应用”，以及全国“十五”科研规划全国重点项目“掌上型信息技术产品在教学中的运用和开发研究”的子课题“用技术学数学”。', 2, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/avatar/2020/07/18/20200718192802.jpg', 2, '2018-07-03', 0, '2020-07-13 20:20:42', '2020-07-13 20:20:42');
INSERT INTO `edu_teacher` VALUES ('1282651629472145410', '钟小湖', '深圳信息职业技术学院顶尖学员', '老板呀', 2, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/avatar/2020/07/27/20200727205314.jpg', 1, '2020-07-05', 0, '2020-07-13 20:22:34', '2020-07-13 20:22:34');
INSERT INTO `edu_teacher` VALUES ('1282652146675965954', '明小哥', '教育学院资深老教授', '十年课程研发和培训咨询经验，曾任国企人力资源经理、大型外企培训经理，负责企业大学和培训体系搭建；曾任专业培训机构高级顾问、研发部总监，为包括广东移动、东莞移动、深圳移动、南方电网、工商银行、农业银行、民生银行、邮储银行、TCL集团、清华大学继续教育学院、中天路桥、广西扬翔股份等超过200家企业提供过培训与咨询服务，并担任近50个大型项目的总负责人。', 1, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/avatar/2020/07/27/20200727205056.jpg', 0, '2014-07-16', 0, '2020-07-13 20:24:37', '2020-07-13 20:24:37');
INSERT INTO `edu_teacher` VALUES ('1282652836743831554', '姚晨晨', '华东师范大学数学系硕士生导师，中国数学奥林匹克高级教练', '曾参与北京市及全国多项数学活动的命题和组织工作，多次带领北京队参加高中、初中、小学的各项数学竞赛，均取得优异成绩。教学活而新，能够调动学生的学习兴趣并擅长对学生进行思维点拨，对学生学习习惯的养成和非智力因素培养有独到之处，是一位深受学生喜爱的老师。', 1, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/avatar/2020/07/27/20200727205119.jpg', 4, '2019-07-11', 0, '2020-07-13 20:27:21', '2020-07-13 20:27:21');
INSERT INTO `edu_teacher` VALUES ('1282653117380517890', '陈苗苗', '人大附中2009届毕业生', '北京大学数学科学学院2008级本科生，2012年第八届学生五四奖章获得者，在数学领域取得多项国际国内奖项，学术研究成绩突出。曾被两次评为北京大学三好学生、一次评为北京大学三好标兵，获得过北京大学国家奖学金、北京大学廖凯原奖学金、北京大学星光国际一等奖学金、北京大学明德新生奖学金等。', 1, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/avatar/2020/07/27/20200727205141.jpg', 4, '2020-07-05', 0, '2020-07-13 20:28:28', '2020-07-13 20:28:28');
INSERT INTO `edu_teacher` VALUES ('1282653214877114369', '小伦', '长期从事考研政治课讲授和考研命题趋势与应试对策研究。考研辅导新锐派的代表。', '政治学博士、管理学博士后，北京师范大学马克思主义学院副教授。多年来总结出了一套行之有效的应试技巧与答题方法，针对性和实用性极强，能帮助考生在轻松中应考，在激励的竞争中取得高分，脱颖而出。', 1, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/avatar/2020/07/27/20200727205210.jpg', 4, '2020-07-11', 0, '2020-07-13 20:28:52', '2020-07-13 20:28:52');
INSERT INTO `edu_teacher` VALUES ('1282653317058748418', '周一名', '中国人民大学附属中学数学一级教师', '中国科学院数学与系统科学研究院应用数学专业博士，研究方向为数字图像处理，中国工业与应用数学学会会员。参与全国教育科学“十五”规划重点课题“信息化进程中的教育技术发展研究”的子课题“基与课程改革的资源开发与应用”，以及全国“十五”科研规划全国重点项目“掌上型信息技术产品在教学中的运用和开发研究”的子课题“用技术学数学”。', 1, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/avatar/2020/07/27/20200727205427.jpg', 4, '2020-07-07', 0, '2020-07-13 20:29:16', '2020-07-13 20:29:16');
INSERT INTO `edu_teacher` VALUES ('1282653455454003201', '唐唐', '北京师范大学法学院副教授', '北京师范大学法学院副教授、清华大学法学博士。自2004年至今已有9年的司法考试培训经验。长期从事司法考试辅导，深知命题规律，了解解题技巧。内容把握准确，授课重点明确，层次分明，调理清晰，将法条法理与案例有机融合，强调综合，深入浅出。', 1, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/avatar/2020/07/27/20200727205337.jpg', 4, '2020-07-10', 0, '2020-07-13 20:29:49', '2020-07-13 20:29:49');
INSERT INTO `edu_teacher` VALUES ('1282653603210944514', '刘花花', '毕业于师范大学数学系，热爱教育事业，执教数学思维6年有余', '具备深厚的数学思维功底、丰富的小学教育经验，授课风格生动活泼，擅长用形象生动的比喻帮助理解、简单易懂的语言讲解难题，深受学生喜欢', 1, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/avatar/2020/07/27/20200727205323.jpg', 4, '2017-07-04', 0, '2020-07-13 20:30:24', '2020-07-13 20:30:24');
INSERT INTO `edu_teacher` VALUES ('1290682115603705858', '妙姐', '暂无', NULL, 1, 'https://edu-college.oss-cn-shenzhen.aliyuncs.com/avatar/2020/08/05/20200805001213.png', 0, '2020-08-04', 0, '2020-08-05 00:12:51', '2020-08-05 00:12:51');

-- ----------------------------
-- Table structure for edu_video
-- ----------------------------
DROP TABLE IF EXISTS `edu_video`;
CREATE TABLE `edu_video`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频ID',
  `course_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程ID',
  `chapter_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '章节ID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '节点名称',
  `video_source_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '原始文件名称',
  `sort` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序字段',
  `play_count` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '播放次数',
  `is_free` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否可以试听：0收费 1免费',
  `duration` float NOT NULL DEFAULT 0 COMMENT '视频时长（秒）',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Empty' COMMENT '状态',
  `size` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '视频源文件大小（字节）',
  `version` bigint(0) UNSIGNED NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE,
  INDEX `idx_chapter_id`(`chapter_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程视频' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of edu_video
-- ----------------------------
INSERT INTO `edu_video` VALUES ('1284165406466125826', '1283009951186538497', '1283811262412816386', '01-MySQL由来', '07b0347458884e65ac395dd8021f3ddf', 'ccfeac060617897d97a6b21fe10d3b5e.mp4', 1, 0, 1, 0, 'Empty', 0, 1, '2020-07-18 00:37:46', '2020-07-18 00:37:46');
INSERT INTO `edu_video` VALUES ('1284165651858075649', '1283009951186538497', '1283811262412816386', '02-MySQL用途', '5547b0637cc34fada01f989ab541ddd4', 'microMsg.1560814690415.mp4', 2, 0, 0, 0, 'Empty', 0, 1, '2020-07-18 00:38:45', '2020-07-18 00:38:45');
INSERT INTO `edu_video` VALUES ('1290839629284651010', '1282899934500245505', '1290839564038057985', '第一课时', 'd55d548c5c044f77bfdc7acb78f25555', 'microMsg.1560778260502.mp4', 0, 0, 1, 0, 'Empty', 0, 1, '2020-08-05 10:38:45', '2020-08-05 10:38:45');
INSERT INTO `edu_video` VALUES ('1290956170483462145', '1283009951186538497', '1283811262412816386', '秦时明月', 'f434e9e957d4451bbbd92cf3ba88556f', '172174105-1-208.mp4', 0, 0, 1, 0, 'Empty', 0, 1, '2020-08-05 18:21:51', '2020-08-05 18:21:51');

SET FOREIGN_KEY_CHECKS = 1;
