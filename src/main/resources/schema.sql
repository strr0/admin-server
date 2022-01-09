/*
 Navicat Premium Data Transfer

 Source Server         : mysql-local
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : strr_admin

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 09/01/2022 19:57:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_authority`;
CREATE TABLE `sys_authority`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求路径',
  `path` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `parent_id` int(0) NULL DEFAULT NULL COMMENT '父菜单',
  `is_menu` tinyint(1) NULL DEFAULT NULL COMMENT '是否为菜单',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '按钮类型',
  `func` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法',
  `creator` int(0) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updator` int(0) NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_authority
-- ----------------------------
INSERT INTO `sys_authority` VALUES (1, '', '/home', '系统管理', '', 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_authority` VALUES (2, '/admin/user', '/user', '用户管理', '', 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_authority` VALUES (3, '/admin/role', '/role', '角色管理', '', 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_authority` VALUES (4, '/admin/authority', '/authority', '权限管理', '', 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_authority` VALUES (5, NULL, NULL, '查看', 'el-icon-view', 2, 0, 'primary', 'show', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (6, NULL, NULL, '添加', 'el-icon-plus', 2, 0, 'success', 'add', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (7, NULL, NULL, '修改', 'el-icon-edit', 2, 0, 'warning', 'edit', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (8, NULL, NULL, '删除', 'el-icon-delete', 2, 0, 'danger', 'del', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (9, NULL, NULL, '权限', 'el-icon-view', 3, 0, 'primary', 'alloc', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (10, NULL, NULL, '添加', 'el-icon-plus', 3, 0, 'success', 'add', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (11, NULL, NULL, '修改', 'el-icon-edit', 3, 0, 'warning', 'edit', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (12, NULL, NULL, '删除', 'el-icon-delete', 3, 0, 'danger', 'del', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (13, NULL, NULL, '查看', 'el-icon-view', 4, 0, 'primary', 'show', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (14, NULL, NULL, '添加', 'el-icon-plus', 4, 0, 'success', 'add', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (15, NULL, NULL, '修改', 'el-icon-edit', 4, 0, 'warning', 'edit', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (16, NULL, NULL, '删除', 'el-icon-delete', 4, 0, 'danger', 'del', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_rel_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_rel_role_authority`;
CREATE TABLE `sys_rel_role_authority`  (
  `rid` int(0) NULL DEFAULT NULL COMMENT '角色id',
  `aid` int(0) NULL DEFAULT NULL COMMENT '权限id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_rel_role_authority
-- ----------------------------
INSERT INTO `sys_rel_role_authority` VALUES (1, 1);
INSERT INTO `sys_rel_role_authority` VALUES (1, 2);
INSERT INTO `sys_rel_role_authority` VALUES (1, 3);
INSERT INTO `sys_rel_role_authority` VALUES (1, 4);
INSERT INTO `sys_rel_role_authority` VALUES (1, 5);
INSERT INTO `sys_rel_role_authority` VALUES (1, 6);
INSERT INTO `sys_rel_role_authority` VALUES (1, 7);
INSERT INTO `sys_rel_role_authority` VALUES (1, 8);
INSERT INTO `sys_rel_role_authority` VALUES (1, 9);
INSERT INTO `sys_rel_role_authority` VALUES (1, 10);
INSERT INTO `sys_rel_role_authority` VALUES (1, 11);
INSERT INTO `sys_rel_role_authority` VALUES (1, 12);
INSERT INTO `sys_rel_role_authority` VALUES (1, 13);
INSERT INTO `sys_rel_role_authority` VALUES (1, 14);
INSERT INTO `sys_rel_role_authority` VALUES (1, 15);
INSERT INTO `sys_rel_role_authority` VALUES (1, 16);

-- ----------------------------
-- Table structure for sys_rel_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_rel_user_role`;
CREATE TABLE `sys_rel_user_role`  (
  `uid` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `rid` int(0) NULL DEFAULT NULL COMMENT '角色id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_rel_user_role
-- ----------------------------
INSERT INTO `sys_rel_user_role` VALUES (1, 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `seq` tinyint(0) NULL DEFAULT NULL COMMENT '排序',
  `creator` int(0) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updator` int(0) NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'ROLE_ADMIN', '管理员', NULL, NULL, NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  `creator` int(0) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updator` int(0) NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$HLpbo23NoKfxTKuv5UAaB.KMCNvXoCPXDXUKlnZUBQlmhrihU.b2S', '管理员', 'admin@example.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
