-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: zhijiang-reservation-system
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
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log`
--

LOCK TABLES `t_log` WRITE;
/*!40000 ALTER TABLE `t_log` DISABLE KEYS */;
INSERT INTO `t_log` VALUES (4,'system','admin','login','登录成功','2017-04-11 16:27:18.129','0:0:0:0:0:0:0:1'),(5,'system','王武超','login','登录成功','2017-04-11 16:28:18.745','192.168.0.120'),(6,'system','admin','login','登录成功','2017-04-11 16:51:28.712','0:0:0:0:0:0:0:1'),(7,'system','admin','login','登录成功','2017-04-11 16:53:07.802','0:0:0:0:0:0:0:1'),(8,'system','admin','login','登录成功','2017-04-12 10:27:01.55','0:0:0:0:0:0:0:1'),(9,'system','admin','login','登录成功','2017-04-11 09:27:01.55','0:0:0:0:0:0:0:1'),(10,'system','admin','login','登录成功','2017-04-12 11:21:24.975','0:0:0:0:0:0:0:1'),(11,'system','admin','login','登录成功','2017-04-12 14:26:03.374','0:0:0:0:0:0:0:1'),(12,'system','admin','login','登录成功','2017-04-12 15:22:01.922','192.168.0.120'),(13,'system','admin','login','登录成功','2017-04-12 15:24:52.734','0:0:0:0:0:0:0:1'),(14,'system','admin','login','登录成功','2017-04-12 15:25:30.229','192.168.0.120'),(15,'system','admin','login','登录成功','2017-04-12 15:26:40.417','0:0:0:0:0:0:0:1'),(16,'system','admin','login','登录成功','2017-04-12 15:27:03.637','192.168.0.120'),(17,'system','admin','login','登录成功','2017-04-12 16:48:26.957','0:0:0:0:0:0:0:1'),(18,'system','admin','login','登录成功','2017-04-12 17:25:12.034','192.168.0.120'),(19,'system','admin','login','登录成功','2017-04-12 21:01:56.711','0:0:0:0:0:0:0:1'),(20,'system','admin','login','登录成功','2017-04-13 16:43:40.34','0:0:0:0:0:0:0:1'),(21,'system','admin','login','登录成功','2017-04-13 17:29:28.51','0:0:0:0:0:0:0:1'),(22,'system','admin','login','登录成功','2017-04-13 17:43:46.878','0:0:0:0:0:0:0:1'),(23,'system','admin','login','登录成功','2017-04-20 10:28:46.739','0:0:0:0:0:0:0:1'),(24,'system','admin','login','登录成功','2017-04-20 11:06:09.84','0:0:0:0:0:0:0:1'),(25,'system','admin','login','登录成功','2017-04-20 11:06:22.616','0:0:0:0:0:0:0:1'),(26,'system','admin','login','登录成功','2017-04-20 11:07:52.017','0:0:0:0:0:0:0:1'),(27,'system','admin','login','登录成功','2017-04-20 11:12:35.815','0:0:0:0:0:0:0:1'),(28,'system','admin','login','登录成功','2017-04-20 11:27:34.199','0:0:0:0:0:0:0:1'),(29,'system','admin','login','登录成功','2017-04-20 11:31:46.377','0:0:0:0:0:0:0:1'),(30,'system','admin','login','登录成功','2017-04-20 11:42:12.661','0:0:0:0:0:0:0:1'),(31,'system','admin','login','登录成功','2017-04-20 11:44:16.617','0:0:0:0:0:0:0:1'),(32,'system','admin','login','登录成功','2017-04-20 11:48:07.306','0:0:0:0:0:0:0:1'),(33,'system','admin','login','登录成功','2017-04-20 11:48:28.506','0:0:0:0:0:0:0:1'),(34,'system','admin','login','登录成功','2017-04-20 11:48:44.944','0:0:0:0:0:0:0:1'),(35,'system','admin','login','登录成功','2017-04-20 11:49:25.874','0:0:0:0:0:0:0:1'),(36,'system','admin','login','登录成功','2017-04-20 11:49:56.94','0:0:0:0:0:0:0:1'),(37,'system','admin','login','登录成功','2017-04-24 15:10:30.706','0:0:0:0:0:0:0:1'),(38,'system','admin','login','登录成功','2017-04-24 15:20:35.538','0:0:0:0:0:0:0:1'),(39,'system','admin','login','登录成功','2017-04-24 16:26:09.806','0:0:0:0:0:0:0:1'),(40,'system','admin','login','登录成功','2017-04-24 19:02:30.252','0:0:0:0:0:0:0:1'),(41,'system','admin','login','登录成功','2017-04-25 09:50:59.342','0:0:0:0:0:0:0:1'),(42,'system','admin','login','登录成功','2017-04-25 10:48:28.659','0:0:0:0:0:0:0:1'),(43,'system','admin','login','登录成功','2017-04-25 13:40:27.527','0:0:0:0:0:0:0:1'),(44,'system','admin','login','登录成功','2017-04-25 14:16:18.135','0:0:0:0:0:0:0:1'),(45,'system','admin','login','登录成功','2017-04-25 15:27:02.7','0:0:0:0:0:0:0:1'),(46,'system','admin','login','登录成功','2017-04-25 15:27:44.304','0:0:0:0:0:0:0:1'),(47,'system','admin','login','登录成功','2017-04-25 15:29:17.306','0:0:0:0:0:0:0:1'),(48,'system','admin','login','登录成功','2017-04-25 15:32:14.933','0:0:0:0:0:0:0:1'),(49,'system','admin','login','登录成功','2017-04-25 16:41:46.939','192.168.0.120'),(50,'system','admin','login','登录成功','2017-04-25 17:30:03.176','0:0:0:0:0:0:0:1'),(51,'system','admin','login','登录成功','2017-04-26 09:20:56.712','0:0:0:0:0:0:0:1'),(52,'system','admin','login','登录成功','2017-04-26 09:28:47.88','0:0:0:0:0:0:0:1'),(53,'system','admin','login','登录成功','2017-04-26 09:52:29.914','0:0:0:0:0:0:0:1'),(54,'system','王武超','login','登录成功','2017-04-26 09:54:51.143','0:0:0:0:0:0:0:1'),(55,'system','admin','login','登录成功','2017-04-26 10:03:43.148','0:0:0:0:0:0:0:1'),(56,'system','王武超','login','登录成功','2017-04-26 10:04:08.93','0:0:0:0:0:0:0:1'),(57,'system','admin','login','登录成功','2017-04-26 10:35:21.032','0:0:0:0:0:0:0:1'),(58,'system','admin','login','登录成功','2017-04-26 11:07:14.596','0:0:0:0:0:0:0:1'),(59,'system','principal','login','登录成功','2017-04-26 11:33:50.457','0:0:0:0:0:0:0:1'),(60,'system','王武超','login','登录成功','2017-04-26 11:55:39.784','0:0:0:0:0:0:0:1'),(61,'system','王武超','login','登录成功','2017-04-26 13:39:27.036','0:0:0:0:0:0:0:1'),(62,'system','admin','login','登录成功','2017-04-26 16:15:09.532','0:0:0:0:0:0:0:1'),(63,'system','王武超','login','登录成功','2017-04-26 16:15:18.204','0:0:0:0:0:0:0:1'),(64,'system','王武超','login','登录成功','2017-04-26 16:20:17.759','0:0:0:0:0:0:0:1'),(65,'system','王武超','login','登录成功','2017-04-26 16:36:16.538','0:0:0:0:0:0:0:1'),(66,'system','王武超','login','登录成功','2017-04-26 16:56:56.921','0:0:0:0:0:0:0:1'),(67,'system','陈菲','login','登录成功','2017-04-26 17:09:03.904','0:0:0:0:0:0:0:1'),(68,'system','admin','login','登录成功','2017-04-26 17:09:27.82','0:0:0:0:0:0:0:1'),(69,'system','陈菲','login','登录成功','2017-04-26 17:11:18.116','0:0:0:0:0:0:0:1'),(70,'system','admin','login','登录成功','2017-04-26 17:13:15.586','0:0:0:0:0:0:0:1'),(71,'system','principal','login','登录成功','2017-04-26 17:13:36.655','0:0:0:0:0:0:0:1'),(72,'system','admin','login','登录成功','2017-04-26 17:16:27.124','0:0:0:0:0:0:0:1'),(73,'system','小强','login','登录成功','2017-04-26 17:22:34.487','0:0:0:0:0:0:0:1');
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
-- Table structure for table `t_reservation`
--

DROP TABLE IF EXISTS `t_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `placeName` varchar(45) NOT NULL COMMENT '借用场地名称',
  `placeDepartment` varchar(45) NOT NULL COMMENT '该场地所属部门',
  `title` varchar(128) DEFAULT NULL COMMENT '场地借用描述',
  `startTime` datetime NOT NULL COMMENT '场地借用开始时间',
  `endTime` datetime NOT NULL COMMENT '场地借用归还时间',
  `applicant` varchar(45) NOT NULL COMMENT '借用场地人账号（即用于登录的登录账号）',
  `userName` varchar(45) NOT NULL COMMENT '本次借用场地人姓名（在申请页面中手动填写）',
  `mobile` varchar(45) NOT NULL COMMENT '借用场地负责人联系方式',
  `check1` tinyint(1) DEFAULT NULL COMMENT '场地申请1级审核（1级审核通过后才能进行2级审核）1表示审核通过，0表示审核不通过，null表示未审核',
  `check2` tinyint(1) DEFAULT NULL COMMENT '场地申请2级审核（1级审核通过后才能进行2级审核）1表示审核通过，0表示审核不通过，null表示未审核',
  `gmtCreate` datetime DEFAULT NULL,
  `gmtModify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_reservation`
--

LOCK TABLES `t_reservation` WRITE;
/*!40000 ALTER TABLE `t_reservation` DISABLE KEYS */;
INSERT INTO `t_reservation` VALUES (1,'体育大馆','体军部','运动会','2017-04-25 11:15:00','2017-04-25 23:00:00','信息学院','王武超','18268176416',0,0,'2017-04-24 08:00:00','2017-04-24 08:00:00'),(2,'体育大馆','体军部','篮球赛','2017-04-26 07:55:00','2017-04-26 22:55:00','王武超','王晨','234454656',NULL,NULL,'2017-04-26 17:08:02',NULL);
/*!40000 ALTER TABLE `t_reservation` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (5,'小强','$2a$10$MOLV5P4BHCfIPhESuk2IiuC0f0n.RG6I6ZdKxbqHEKXD6vTjT4Ca6','departmentLeader','aaaa','1999-01-01 00:00:00','2017-04-26 17:22:34','1999-01-01 00:00:00'),(8,'admin','$2a$10$SGu8x9msG468ByKJIQeaOe/3b1OzWGVK.ahyt9w8x4y7vZ9pIBeDC','admin','','2017-04-20 10:30:23','2017-04-26 17:16:27','2017-04-26 09:28:48'),(9,'小戴','$2a$10$eXb.KtyvKKcl.iuRuSw74.0eZt1.FEMv1r9e14HLC9JRP3U979HCO','departmentPrincipal','体军部','2017-04-25 17:30:52','2017-04-26 17:17:26',NULL),(11,'武超','$2a$10$aTpiPudNyBEfvOmMbj9Uwedy81WqtB/KOyvRYUIAXWCBI7cih6ony','applicant','信息学院','2017-04-26 09:50:28','2017-04-26 17:17:50',NULL);
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

-- Dump completed on 2017-04-26 17:26:27
