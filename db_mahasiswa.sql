/*
 Navicat Premium Data Transfer

 Source Server         : koneksi01
 Source Server Type    : MySQL
 Source Server Version : 100427 (10.4.27-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : db_mahasiswa

 Target Server Type    : MySQL
 Target Server Version : 100427 (10.4.27-MariaDB)
 File Encoding         : 65001

 Date: 19/03/2024 17:46:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mahasiswa
-- ----------------------------
DROP TABLE IF EXISTS `mahasiswa`;
CREATE TABLE `mahasiswa`  (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NIM` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Nama` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `JenisKelamin` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ProgramStudi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mahasiswa
-- ----------------------------
INSERT INTO `mahasiswa` VALUES (1, '2203999', 'Amelia Zalfa Julianti', 'Perempuan', 'Computer Science');
INSERT INTO `mahasiswa` VALUES (2, '2202292', 'Muhammad Iqbal Fadhilah', 'Laki-laki', 'Business Administration');
INSERT INTO `mahasiswa` VALUES (3, '2202346', 'Muhammad Rifky Afandi', 'Laki-laki', 'Computer Science');
INSERT INTO `mahasiswa` VALUES (4, '2210239', 'Muhammad Hanif Abdillah', 'Laki-laki', 'Economics');
INSERT INTO `mahasiswa` VALUES (5, '2202046', 'Nurainun', 'Perempuan', 'Computer Science');
INSERT INTO `mahasiswa` VALUES (6, '2205101', 'Kelvin Julian Putra', 'Laki-laki', 'Business Administration');
INSERT INTO `mahasiswa` VALUES (7, '2200163', 'Rifanny Lysara Annastasya', 'Perempuan', 'Computer Science');
INSERT INTO `mahasiswa` VALUES (8, '2202869', 'Revana Faliha Salma', 'Perempuan', 'Economics');
INSERT INTO `mahasiswa` VALUES (9, '2209489', 'Rakha Dhifiargo Hariadi', 'Laki-laki', 'Computer Science');
INSERT INTO `mahasiswa` VALUES (10, '2203142', 'Roshan Syalwan Nurilham', 'Laki-laki', 'Business Administration');
INSERT INTO `mahasiswa` VALUES (11, '2200311', 'Raden Rahman Ismail', 'Laki-laki', 'Economics');
INSERT INTO `mahasiswa` VALUES (12, '2200978', 'Ratu Syahirah Khairunnisa', 'Perempuan', 'Computer Science');
INSERT INTO `mahasiswa` VALUES (13, '2204509', 'Muhammad Fahreza Fauzan', 'Laki-laki', 'Business Administration');
INSERT INTO `mahasiswa` VALUES (14, '2205027', 'Muhammad Rizki Revandi', 'Laki-laki', 'Computer Science');
INSERT INTO `mahasiswa` VALUES (15, '2203484', 'Arya Aydin Margono', 'Laki-laki', 'Economics');
INSERT INTO `mahasiswa` VALUES (16, '2200481', 'Marvel Ravindra Dioputra', 'Laki-laki', 'Computer Science');
INSERT INTO `mahasiswa` VALUES (17, '2209889', 'Muhammad Fadlul Hafiizh', 'Laki-laki', 'Business Administration');
INSERT INTO `mahasiswa` VALUES (18, '2206697', 'Rifa Sania', 'Perempuan', 'Computer Science');
INSERT INTO `mahasiswa` VALUES (19, '2207260', 'Imam Chalish Rafidhul Haque', 'Laki-laki', 'Business Administration');
INSERT INTO `mahasiswa` VALUES (20, '2204343', 'Meiva Labibah Putri', 'Perempuan', 'Economics');

SET FOREIGN_KEY_CHECKS = 1;
