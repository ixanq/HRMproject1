-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: hrmproject
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Table structure for table `advertises`
--

DROP TABLE IF EXISTS `advertises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertises` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `advertise_name` varchar(40) NOT NULL,
  `salary` varchar(30) NOT NULL,
  `need_person_number` int(11) NOT NULL,
  `advertise_descreption` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='招聘信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertises`
--

LOCK TABLES `advertises` WRITE;
/*!40000 ALTER TABLE `advertises` DISABLE KEYS */;
INSERT INTO `advertises` VALUES (3,'高级程序员','5000-1000',22,'写程序'),(4,'aaa','5000-1000',2,'fef'),(5,'ggdsg','5000-9000',22,'dfgfdggd'),(6,'dfggdfg','dfgfdgdfg',3434,'fdgdfgdfg'),(7,'高级程序员','6000-8000',22,'gdfgdfgdfd'),(8,'fgffgfgdfg','5000-9000',3,'gdfgfdgdg');
/*!40000 ALTER TABLE `advertises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `check_work_attendance`
--

DROP TABLE IF EXISTS `check_work_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `check_work_attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `begin_work` datetime NOT NULL,
  `end_work` datetime NOT NULL,
  `is_late` varchar(30) NOT NULL,
  `is_leave` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='考勤';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `check_work_attendance`
--

LOCK TABLES `check_work_attendance` WRITE;
/*!40000 ALTER TABLE `check_work_attendance` DISABLE KEYS */;
INSERT INTO `check_work_attendance` VALUES (13,18,'2018-10-23 00:35:41','2018-10-23 19:35:58','正常','正常'),(14,18,'2018-10-24 08:36:24','2018-10-24 20:36:43','正常','正常'),(15,18,'2018-10-25 08:37:06','2018-10-25 16:37:23','正常','早退'),(16,18,'2018-10-26 09:37:45','2018-10-26 17:37:57','迟到','早退'),(17,18,'2018-10-29 05:38:47','2018-10-29 17:39:05','正常','早退'),(18,18,'2018-10-30 00:40:29','2000-12-12 12:12:12','正常','待定'),(19,18,'2018-10-31 11:41:58','2018-10-31 18:42:12','迟到','早退');
/*!40000 ALTER TABLE `check_work_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='部门';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (18,'财务部','2018-10-22'),(19,'技术部','2018-10-22'),(21,'bbb','2018-10-22');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `real_name` varchar(30) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `age` int(11) NOT NULL DEFAULT '18',
  `degree` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `begin_time` date NOT NULL,
  `status` varchar(30) NOT NULL,
  `work_position_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='员工';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (18,'aaa','aaa','李四','男',26,'本科','234213423@qq.com','2018-10-22','在职',16),(19,'youke1','12345','游客1','男',26,'硕士','22@qq.com','2018-10-23','离职',24);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeeinfo`
--

DROP TABLE IF EXISTS `employeeinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employeeinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `train_id` int(11) NOT NULL,
  `salary_id` int(11) NOT NULL,
  `reward_id` int(11) NOT NULL,
  `checkworkattend_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  `workposition_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='员工信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeeinfo`
--

LOCK TABLES `employeeinfo` WRITE;
/*!40000 ALTER TABLE `employeeinfo` DISABLE KEYS */;
INSERT INTO `employeeinfo` VALUES (5,18,-1,-1,-1,-1,18,16),(6,19,-1,-1,-1,-1,19,24);
/*!40000 ALTER TABLE `employeeinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `go_interview`
--

DROP TABLE IF EXISTS `go_interview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `go_interview` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_name` varchar(30) NOT NULL,
  `view_status` varchar(30) NOT NULL,
  `pass_status` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `go_interview`
--

LOCK TABLES `go_interview` WRITE;
/*!40000 ALTER TABLE `go_interview` DISABLE KEYS */;
INSERT INTO `go_interview` VALUES (15,'aaa','已查看','已录用'),(16,'youke1','已查看','已录用');
/*!40000 ALTER TABLE `go_interview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interview`
--

DROP TABLE IF EXISTS `interview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interview` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_name` varchar(30) NOT NULL,
  `advertise_id` int(11) NOT NULL,
  `view_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COMMENT='面试邀请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview`
--

LOCK TABLES `interview` WRITE;
/*!40000 ALTER TABLE `interview` DISABLE KEYS */;
INSERT INTO `interview` VALUES (7,'aaa',3,'2018-10-26'),(8,'youke1',3,'2018-10-26');
/*!40000 ALTER TABLE `interview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'manager1','manager1'),(2,'admin','123456'),(3,'zzz','zzz');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manageresume`
--

DROP TABLE IF EXISTS `manageresume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manageresume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resumer` int(11) NOT NULL,
  `mailing_time` date NOT NULL,
  `look_status` varchar(30) NOT NULL,
  `exam_status` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应聘管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manageresume`
--

LOCK TABLES `manageresume` WRITE;
/*!40000 ALTER TABLE `manageresume` DISABLE KEYS */;
/*!40000 ALTER TABLE `manageresume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reconsider`
--

DROP TABLE IF EXISTS `reconsider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reconsider` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `content` varchar(200) NOT NULL,
  `time` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='复议';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reconsider`
--

LOCK TABLES `reconsider` WRITE;
/*!40000 ALTER TABLE `reconsider` DISABLE KEYS */;
/*!40000 ALTER TABLE `reconsider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume`
--

DROP TABLE IF EXISTS `resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_name` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `political_status` varchar(30) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `last_work` varchar(50) NOT NULL,
  `salary` varchar(40) NOT NULL,
  `department_id` int(11) NOT NULL,
  `work_position_id` int(11) NOT NULL,
  `master` varchar(20) NOT NULL,
  `work_background` varchar(200) NOT NULL,
  `hobbies` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='简历';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume`
--

LOCK TABLES `resume` WRITE;
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
INSERT INTO `resume` VALUES (4,'aaa','张三','男',26,'共青团员','17333334455','234213423@qq.com','程序员','6000-7000',19,22,'本科','有有有有有有有有有有有有有有有有有','玩'),(5,'333','猫猫','男',5,'党员','12345678910','333@qq.com','无','6000-7000',19,22,'硕士','啦啦啦啦啦啦啦','看书'),(6,'youke1','游客1','男',33,'共青团员','98765432110','22@qq.com','啦啦啦啦','7000-9000',19,23,'硕士','无','看书');
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume_for_manager`
--

DROP TABLE IF EXISTS `resume_for_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resume_for_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `advertise_id` int(11) NOT NULL,
  `visitor_name` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `political_status` varchar(30) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `last_work` varchar(50) NOT NULL,
  `salary` varchar(40) NOT NULL,
  `department_id` int(11) NOT NULL,
  `work_position_id` int(11) NOT NULL,
  `master` varchar(20) NOT NULL,
  `work_background` varchar(200) NOT NULL,
  `hobbies` varchar(200) DEFAULT NULL,
  `status` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume_for_manager`
--

LOCK TABLES `resume_for_manager` WRITE;
/*!40000 ALTER TABLE `resume_for_manager` DISABLE KEYS */;
INSERT INTO `resume_for_manager` VALUES (12,3,'aaa','张三','男',26,'共青团员','17333334455','234213423@qq.com','程序员','6000-7000',19,22,'本科','有有有有有有有有有有有有有有有有有','玩','已读'),(13,3,'youke1','游客1','男',33,'共青团员','98765432110','22@qq.com','啦啦啦啦','7000-9000',19,23,'硕士','无','看书','已读'),(14,4,'youke1','游客1','男',33,'共青团员','98765432110','22@qq.com','啦啦啦啦','7000-9000',19,23,'硕士','无','看书','已读'),(15,8,'youke1','游客1','男',33,'共青团员','98765432110','22@qq.com','啦啦啦啦','7000-9000',19,23,'硕士','无','看书','已读');
/*!40000 ALTER TABLE `resume_for_manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reward`
--

DROP TABLE IF EXISTS `reward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reward` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `reason` varchar(30) NOT NULL,
  `money` int(11) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='奖赏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reward`
--

LOCK TABLES `reward` WRITE;
/*!40000 ALTER TABLE `reward` DISABLE KEYS */;
INSERT INTO `reward` VALUES (11,18,'新入职奖励',200,'2018-10-22'),(12,18,'早退2小时',-40,'2018-10-25'),(13,18,'迟到1小时',-20,'2018-10-26'),(14,18,'早退1小时',-20,'2018-10-26'),(15,18,'早退1小时',-20,'2018-10-29'),(16,18,'迟到3小时',-60,'2018-10-31');
/*!40000 ALTER TABLE `reward` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salarys`
--

DROP TABLE IF EXISTS `salarys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salarys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salary` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `work_day` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='薪资';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salarys`
--

LOCK TABLES `salarys` WRITE;
/*!40000 ALTER TABLE `salarys` DISABLE KEYS */;
INSERT INTO `salarys` VALUES (1,1540,18,10,2018,6);
/*!40000 ALTER TABLE `salarys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `train_time` date NOT NULL,
  `department` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='培训';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` VALUES (6,'技术培训','2018-12-14','技术部'),(9,'财务管理','2018-10-19','财务部');
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitor`
--

DROP TABLE IF EXISTS `visitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='游客';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor`
--

LOCK TABLES `visitor` WRITE;
/*!40000 ALTER TABLE `visitor` DISABLE KEYS */;
INSERT INTO `visitor` VALUES (3,'bbb','222'),(24,'aaa','111'),(25,'aaa1','111'),(26,'hhh','hhh'),(27,'111','111'),(28,'123','11'),(29,'333','333'),(30,'zxc','zxc'),(31,'youke1','12345');
/*!40000 ALTER TABLE `visitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_position`
--

DROP TABLE IF EXISTS `work_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `department_id` int(11) NOT NULL,
  `create_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='职位';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_position`
--

LOCK TABLES `work_position` WRITE;
/*!40000 ALTER TABLE `work_position` DISABLE KEYS */;
INSERT INTO `work_position` VALUES (16,'结账员',18,'2018-10-22'),(17,'总会计师',18,'2018-10-22'),(18,'财务总监',18,'2018-10-22'),(19,'资金总监',18,'2018-10-22'),(20,'会计',18,'2018-10-22'),(21,'收银员',18,'2018-10-22'),(22,'程序员',19,'2018-10-22'),(23,'硬件工程师',19,'2018-10-22'),(24,'单片机工程师',19,'2018-10-22'),(28,'bbb1',21,'2018-10-22'),(29,'bbb2',21,'2018-10-22');
/*!40000 ALTER TABLE `work_position` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-24  8:53:19
