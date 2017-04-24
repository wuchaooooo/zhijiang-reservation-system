-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: zhijiang-reversation-system
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_code_info`
--

DROP TABLE IF EXISTS `t_code_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_code_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '该表是一个字典表',
  `codeType` varchar(45) NOT NULL COMMENT '字典类型',
  `shortName` varchar(45) NOT NULL COMMENT '简称',
  `fullName` varchar(45) DEFAULT NULL COMMENT '全称',
  `desc` varchar(256) DEFAULT NULL COMMENT '描述',
  `gmtCreate` datetime NOT NULL,
  `gmtModify` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_code_info`
--

LOCK TABLES `t_code_info` WRITE;
/*!40000 ALTER TABLE `t_code_info` DISABLE KEYS */;
INSERT INTO `t_code_info` VALUES (1,'department','体军部','浙江工业大学体军部',NULL,'1999-01-01 00:00:00','1999-01-01 00:00:00');
/*!40000 ALTER TABLE `t_code_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_log`
--

DROP TABLE IF EXISTS `t_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(45) NOT NULL COMMENT '系统日志(system)或者用户日志(user)',
  `userName` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL COMMENT '系统日志类别：比如是登录操作还是别的操作,与t_log表中的字段`codeType`=logType相对应',
  `desc` varchar(128) NOT NULL DEFAULT '',
  `gmtCreate` varchar(45) NOT NULL,
  `ipAddress` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log`
--

LOCK TABLES `t_log` WRITE;
/*!40000 ALTER TABLE `t_log` DISABLE KEYS */;
INSERT INTO `t_log` VALUES (4,'system','admin','login','登录成功','2017-04-11 16:27:18.129','0:0:0:0:0:0:0:1'),(5,'system','王武超','login','登录成功','2017-04-11 16:28:18.745','192.168.0.120'),(6,'system','admin','login','登录成功','2017-04-11 16:51:28.712','0:0:0:0:0:0:0:1'),(7,'system','admin','login','登录成功','2017-04-11 16:53:07.802','0:0:0:0:0:0:0:1'),(8,'system','admin','login','登录成功','2017-04-12 10:27:01.55','0:0:0:0:0:0:0:1'),(9,'system','admin','login','登录成功','2017-04-11 09:27:01.55','0:0:0:0:0:0:0:1'),(10,'system','admin','login','登录成功','2017-04-12 11:21:24.975','0:0:0:0:0:0:0:1'),(11,'system','admin','login','登录成功','2017-04-12 14:26:03.374','0:0:0:0:0:0:0:1'),(12,'system','admin','login','登录成功','2017-04-12 15:22:01.922','192.168.0.120'),(13,'system','admin','login','登录成功','2017-04-12 15:24:52.734','0:0:0:0:0:0:0:1'),(14,'system','admin','login','登录成功','2017-04-12 15:25:30.229','192.168.0.120'),(15,'system','admin','login','登录成功','2017-04-12 15:26:40.417','0:0:0:0:0:0:0:1'),(16,'system','admin','login','登录成功','2017-04-12 15:27:03.637','192.168.0.120'),(17,'system','admin','login','登录成功','2017-04-12 16:48:26.957','0:0:0:0:0:0:0:1'),(18,'system','admin','login','登录成功','2017-04-12 17:25:12.034','192.168.0.120'),(19,'system','admin','login','登录成功','2017-04-12 21:01:56.711','0:0:0:0:0:0:0:1'),(20,'system','admin','login','登录成功','2017-04-13 16:43:40.34','0:0:0:0:0:0:0:1'),(21,'system','admin','login','登录成功','2017-04-13 17:29:28.51','0:0:0:0:0:0:0:1'),(22,'system','admin','login','登录成功','2017-04-13 17:43:46.878','0:0:0:0:0:0:0:1'),(23,'system','admin','login','登录成功','2017-04-20 10:28:46.739','0:0:0:0:0:0:0:1'),(24,'system','admin','login','登录成功','2017-04-20 11:06:09.84','0:0:0:0:0:0:0:1'),(25,'system','admin','login','登录成功','2017-04-20 11:06:22.616','0:0:0:0:0:0:0:1'),(26,'system','admin','login','登录成功','2017-04-20 11:07:52.017','0:0:0:0:0:0:0:1'),(27,'system','admin','login','登录成功','2017-04-20 11:12:35.815','0:0:0:0:0:0:0:1'),(28,'system','admin','login','登录成功','2017-04-20 11:27:34.199','0:0:0:0:0:0:0:1'),(29,'system','admin','login','登录成功','2017-04-20 11:31:46.377','0:0:0:0:0:0:0:1'),(30,'system','admin','login','登录成功','2017-04-20 11:42:12.661','0:0:0:0:0:0:0:1'),(31,'system','admin','login','登录成功','2017-04-20 11:44:16.617','0:0:0:0:0:0:0:1'),(32,'system','admin','login','登录成功','2017-04-20 11:48:07.306','0:0:0:0:0:0:0:1'),(33,'system','admin','login','登录成功','2017-04-20 11:48:28.506','0:0:0:0:0:0:0:1'),(34,'system','admin','login','登录成功','2017-04-20 11:48:44.944','0:0:0:0:0:0:0:1'),(35,'system','admin','login','登录成功','2017-04-20 11:49:25.874','0:0:0:0:0:0:0:1'),(36,'system','admin','login','登录成功','2017-04-20 11:49:56.94','0:0:0:0:0:0:0:1');
/*!40000 ALTER TABLE `t_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_place`
--

DROP TABLE IF EXISTS `t_place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_place` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `placeName` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  `principal` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_place`
--

LOCK TABLES `t_place` WRITE;
/*!40000 ALTER TABLE `t_place` DISABLE KEYS */;
INSERT INTO `t_place` VALUES (1,'体育大馆','体军部','张硕','18787665898'),(2,'体育小馆','体军部','张硕','18787665898'),(3,'广知楼C511','信息学院','陈相位','17868689845'),(4,'健行楼A501','信息学院','辰方','13656876655');
/*!40000 ALTER TABLE `t_place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `role` varchar(45) NOT NULL COMMENT '角色',
  `department` varchar(45) NOT NULL COMMENT '该用户所属部门',
  `gmtCreate` datetime NOT NULL COMMENT '该用户创建时间',
  `gmtModify` datetime DEFAULT NULL COMMENT '该用户修改时间',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '上次登陆时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (5,'陈菲','$2a$10$MOLV5P4BHCfIPhESuk2IiuC0f0n.RG6I6ZdKxbqHEKXD6vTjT4Ca6','departmentLeader','','1999-01-01 00:00:00','2017-04-20 11:12:18','1999-01-01 00:00:00'),(7,'哈哈','$2a$10$u.lhoYEWPi5bvVnGfJtqdeAL6dapV2oCVgOM.je35qLuzW36k4sXG','applicant','经贸学院','2017-04-12 21:03:27','2017-04-12 21:05:25',NULL),(8,'admin','$2a$10$bfhniQ5j2x/2GjJylUz04.ydJBQTWLBc5jP9xBQtPjwP2JqXJ7z0O','admin','','2017-04-20 10:30:23','2017-04-20 11:49:57','2017-04-20 11:49:57');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-24 13:47:10
