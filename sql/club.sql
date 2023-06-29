/*
 Navicat Premium Data Transfer

 Source Server         : localhost_mysql
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : club

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 28/06/2023 23:04:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `activity_name` varchar(55) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '活动名称',
  `site` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '活动地点',
  `hold_time` varchar(80) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '活动举行时间',
  `introduce` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '活动介绍',
  `apply_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `permission` int NOT NULL DEFAULT 0 COMMENT '社团联是否批准',
  `activity_type_id` int NOT NULL DEFAULT 0,
  `club_id` int NOT NULL DEFAULT 0,
  `number` int UNSIGNED NOT NULL DEFAULT 10,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (39, 'test1', '星巴克', '2023 年 06 月 01 日', '<p>test1 </p>', '2023-06-28 13:41:37', 0, 1, 0, 10);
INSERT INTO `activity` VALUES (40, '2121', '31231', '2023 年 06 月 29 日', '<p>3123132</p>', '2023-06-28 20:08:24', 0, 114514, 0, 10);

-- ----------------------------
-- Table structure for activity_member
-- ----------------------------
DROP TABLE IF EXISTS `activity_member`;
CREATE TABLE `activity_member`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `club_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity_member
-- ----------------------------

-- ----------------------------
-- Table structure for activity_type
-- ----------------------------
DROP TABLE IF EXISTS `activity_type`;
CREATE TABLE `activity_type`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '活动类型',
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '活动类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity_type
-- ----------------------------
INSERT INTO `activity_type` VALUES (1, '活动预告');
INSERT INTO `activity_type` VALUES (2, '精彩活动回顾');

-- ----------------------------
-- Table structure for club
-- ----------------------------
DROP TABLE IF EXISTS `club`;
CREATE TABLE `club`  (
  `num` int NOT NULL AUTO_INCREMENT COMMENT '社团编号',
  `name` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '社团名称',
  `introduce` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '社团简介',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `club_type_id` tinyint NOT NULL DEFAULT 0 COMMENT '社团类型id',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT '社团状态',
  PRIMARY KEY (`num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 123132145 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of club
-- ----------------------------
INSERT INTO `club` VALUES (122, 'sdasd1', '<p>sdadsa1</p>', '2023-06-28 16:00:00', 5, 0);
INSERT INTO `club` VALUES (114514, 'wuhufly的yinp', '<p>玩植物大战僵尸的都该死</p>', '2023-05-30 16:00:00', 5, 0);

-- ----------------------------
-- Table structure for club_apply
-- ----------------------------
DROP TABLE IF EXISTS `club_apply`;
CREATE TABLE `club_apply`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `club_id` int NULL DEFAULT NULL,
  `is_join` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of club_apply
-- ----------------------------
INSERT INTO `club_apply` VALUES (1, 1, 100, 1);
INSERT INTO `club_apply` VALUES (4, 44, 1, 1);
INSERT INTO `club_apply` VALUES (6, 46, 79, NULL);
INSERT INTO `club_apply` VALUES (42, 42, 1, 1);
INSERT INTO `club_apply` VALUES (43, 43, 1, 1);
INSERT INTO `club_apply` VALUES (48, 1, 1, -1);
INSERT INTO `club_apply` VALUES (52, 1, 114514, 0);
INSERT INTO `club_apply` VALUES (53, 1, 114514, 0);

-- ----------------------------
-- Table structure for club_member
-- ----------------------------
DROP TABLE IF EXISTS `club_member`;
CREATE TABLE `club_member`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `club_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of club_member
-- ----------------------------
INSERT INTO `club_member` VALUES (1, 1, 37);
INSERT INTO `club_member` VALUES (2, 1, 39);

-- ----------------------------
-- Table structure for club_type
-- ----------------------------
DROP TABLE IF EXISTS `club_type`;
CREATE TABLE `club_type`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '社团类型',
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '社团类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of club_type
-- ----------------------------
INSERT INTO `club_type` VALUES (1, '理论学习类社团');
INSERT INTO `club_type` VALUES (2, '艺术类型');
INSERT INTO `club_type` VALUES (3, '公益服务类社团');
INSERT INTO `club_type` VALUES (4, '职业发展类社团');
INSERT INTO `club_type` VALUES (5, '体育锻炼类社团');
INSERT INTO `club_type` VALUES (6, '兴趣爱好');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `file_name` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '文件名称',
  `file_path` varchar(120) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '文件路径',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `file_type_id` int NOT NULL DEFAULT 0,
  `passage_id` int NOT NULL DEFAULT 0 COMMENT '关联文章id',
  `activity_id` int NOT NULL DEFAULT 0 COMMENT '关联活动id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 139 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (133, '关于2022年“外研社·国才杯”全国英语演讲大赛、英语写作大赛及英语阅读大赛的通知(1)(1).docx', '/files/关于2022年“外研社·国才杯”全国英语演讲大赛、英语写作大赛及英语阅读大赛的通知(1)(1).docx', '2023-06-28 11:46:17', 2, 0, 0);
INSERT INTO `file` VALUES (134, 'khl20230620234315645.png', '/images/activity//khl20230620234315645.png', '2023-06-28 13:41:37', 6, 0, 37);
INSERT INTO `file` VALUES (135, 'khl20230620234315645.png', '/images/passage//khl20230620234315645.png', '2023-06-28 14:18:31', 4, 130, 0);
INSERT INTO `file` VALUES (136, '114514', '/images/club//Z}84RSGY_47@MLZ6RN}IM$R.jpg', '2023-06-28 14:58:30', 7, 0, 0);
INSERT INTO `file` VALUES (138, 'yong sp.jpg', '/images/activity//yong sp.jpg', '2023-06-28 20:08:24', 6, 0, 38);

-- ----------------------------
-- Table structure for file_type
-- ----------------------------
DROP TABLE IF EXISTS `file_type`;
CREATE TABLE `file_type`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '社团类型',
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '社团类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file_type
-- ----------------------------
INSERT INTO `file_type` VALUES (1, '普通图片');
INSERT INTO `file_type` VALUES (2, '常用文档');
INSERT INTO `file_type` VALUES (3, '社团文件');
INSERT INTO `file_type` VALUES (4, '首页轮播图');
INSERT INTO `file_type` VALUES (5, '文章内部图片');
INSERT INTO `file_type` VALUES (6, '活动内部图片');
INSERT INTO `file_type` VALUES (7, '社团图片');

-- ----------------------------
-- Table structure for one_column
-- ----------------------------
DROP TABLE IF EXISTS `one_column`;
CREATE TABLE `one_column`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `club_name` varchar(80) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '社团名称',
  `club_summary` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '社团概况',
  `introduce` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '社团简介',
  `notice` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '社团快讯',
  `show` varchar(55) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '社团活动风采',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of one_column
-- ----------------------------
INSERT INTO `one_column` VALUES (1, '社员名称', '社团摘要', '社团简介', '社团快讯', '活动风采');

-- ----------------------------
-- Table structure for passage
-- ----------------------------
DROP TABLE IF EXISTS `passage`;
CREATE TABLE `passage`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '文章标题',
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '文章内容',
  `publisher` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '文章发布者',
  `source` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '文章来源',
  `passage_type_id` tinyint NOT NULL DEFAULT 1 COMMENT '文章类型',
  `club_id` int NULL DEFAULT 0 COMMENT '发布文章的社团id',
  `publish_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `click_num` int NOT NULL DEFAULT 0 COMMENT '点击次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 131 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of passage
-- ----------------------------
INSERT INTO `passage` VALUES (130, 'A!', '<p>Apex</p>', '社团管理员', '社团管理员', 1, 0, '2023-06-28 14:18:31', 0);

-- ----------------------------
-- Table structure for passage_type
-- ----------------------------
DROP TABLE IF EXISTS `passage_type`;
CREATE TABLE `passage_type`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '文章类型',
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '文章类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of passage_type
-- ----------------------------
INSERT INTO `passage_type` VALUES (1, '重要通知');
INSERT INTO `passage_type` VALUES (2, '社团要闻');
INSERT INTO `passage_type` VALUES (3, '社团联简介');
INSERT INTO `passage_type` VALUES (4, '社团简介');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `num` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '1' COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `sex` tinyint(1) NOT NULL DEFAULT 0 COMMENT '性别',
  `age` int NULL DEFAULT NULL,
  `email` varchar(80) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '电子邮箱',
  `phone` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `club_num` int NOT NULL DEFAULT 0 COMMENT '社团编号'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `call_name` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '' COMMENT '用户职称',
  `sex` tinyint(1) NOT NULL DEFAULT 0 COMMENT '性别（0保密，1男，2女）',
  `institute` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '学院',
  `account` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `role_id` int NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户创建时间',
  `is_active` tinyint(1) NOT NULL DEFAULT 0 COMMENT '用户是否激活（默认0，未激活；1激活）',
  `last_login_time` varchar(80) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '', 1, 'a', 'admin@163.com', '123456', 1, '2023-06-27 16:00:00', 0, '');
INSERT INTO `user` VALUES (42, 'test', '', 1, '', 'test@163.com', '123456', 2, '2023-06-27 16:00:00', 0, NULL);
INSERT INTO `user` VALUES (43, 'test1', '', 1, '', 'test1@163.com', '123456', 4, '2023-06-27 16:00:00', 0, NULL);
INSERT INTO `user` VALUES (44, 'avd', '', 1, '', 'leil@163.com', '123456', 4, '2023-06-27 16:00:00', 0, NULL);
INSERT INTO `user` VALUES (45, 'hasiudxha', '', 0, '', '1234@qq.com', '123456', 4, '2023-06-28 09:51:41', 0, NULL);

-- ----------------------------
-- Table structure for user_club
-- ----------------------------
DROP TABLE IF EXISTS `user_club`;
CREATE TABLE `user_club`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '职称id',
  `user_id` int NULL DEFAULT NULL COMMENT '职称名称',
  `club_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_club
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, '超级管理员');
INSERT INTO `user_role` VALUES (2, '社团负责人');
INSERT INTO `user_role` VALUES (3, '社团助理');
INSERT INTO `user_role` VALUES (4, '一般用户');

SET FOREIGN_KEY_CHECKS = 1;
