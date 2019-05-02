-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: busdatabase
-- ------------------------------------------------------
-- Server version	5.6.40

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
-- Table structure for table `busdetails`
--

DROP TABLE IF EXISTS `busdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `busdetails` (
  `BusDetailid` int(11) NOT NULL,
  `CompanyName` varchar(45) DEFAULT NULL,
  `Make` varchar(45) DEFAULT NULL,
  `Type` varchar(45) DEFAULT NULL,
  `BusFareBase` varchar(45) DEFAULT NULL,
  `BusRouteId` varchar(45) DEFAULT NULL,
  `Active` varchar(45) DEFAULT NULL,
  `ArivalTime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`BusDetailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busdetails`
--

LOCK TABLES `busdetails` WRITE;
/*!40000 ALTER TABLE `busdetails` DISABLE KEYS */;
INSERT INTO `busdetails` VALUES (1,'GreeLine','Tata','General','50','1','Y','11:45'),(2,'Red Travels','L&T','Sleeper','50','2','Y','11:45'),(3,'SBSTC','Volvo','Semi Sleeper','50','1','Y','09:45'),(4,'Test Bus','Test','Test','50','2','Y','Test');
/*!40000 ALTER TABLE `busdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busroute`
--

DROP TABLE IF EXISTS `busroute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `busroute` (
  `idBusRoute` int(11) NOT NULL,
  `fromCity` varchar(45) DEFAULT NULL,
  `toCity` varchar(45) DEFAULT NULL,
  `fare` varchar(45) DEFAULT NULL,
  `active` varchar(45) DEFAULT NULL,
  `timeInterval` varchar(45) DEFAULT NULL,
  `routeorder` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busroute`
--

LOCK TABLES `busroute` WRITE;
/*!40000 ALTER TABLE `busroute` DISABLE KEYS */;
INSERT INTO `busroute` VALUES (1,'1','2','200','Y','1','1'),(1,'2','3','200','Y','1','2'),(1,'3','4','200','Y','1','3'),(2,'2','3','150','Y','1','1');
/*!40000 ALTER TABLE `busroute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `CityId` int(11) NOT NULL,
  `CityName` varchar(45) NOT NULL,
  `CityType` varchar(45) NOT NULL,
  `Active` varchar(45) NOT NULL,
  PRIMARY KEY (`CityId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Asansol','E','Y'),(2,'Durgapur','E','Y'),(3,'Bardhaman','M','Y'),(4,'Kolkata','E','Y'),(6,'Ranchi','E','Y'),(8,'Jamshedpur','','Y'),(10,'Bangalore','E','Y'),(12,'Hyderabaad','M','Y'),(14,'Mumbai','M','Y'),(16,'Pune','M','Y'),(18,'Berhumpore','E','Y');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otptable`
--

DROP TABLE IF EXISTS `otptable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `otptable` (
  `id` int(11) NOT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `otp` varchar(45) DEFAULT NULL,
  `valid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otptable`
--

LOCK TABLES `otptable` WRITE;
/*!40000 ALTER TABLE `otptable` DISABLE KEYS */;
INSERT INTO `otptable` VALUES (2,'9741790023','1258\r\n','F'),(4,'9741790023','4209\r\n','F'),(6,'9741790023','4709\r\n','F'),(8,'9741790023','7160\r\n','F'),(10,'Enter your mobile number or Email','6183\r\n','F'),(12,'Enter your mobile number or Email','7440\r\n','F'),(14,'Enter your mobile number or Email','1344\r\n','F'),(16,'Enter your mobile number or Email','0799\r\n','F'),(18,'Enter your mobile number or Email','3769\r\n','F'),(20,'9741790023','5462\r\n','F'),(22,'9741790023','6065\r\n','F'),(24,'9741790023','2816\r\n','F'),(26,'9741790023','3121\r\n','F'),(28,'9741790023','1562\r\n','F'),(30,'9741790023','5544\r\n','F'),(32,'9741790023','4388\r\n','F'),(34,'9741790023','0132\r\n','F'),(36,'9741790023','0264\r\n','F'),(38,'9741790023','6572\r\n','F'),(40,'9741790023','7041\r\n','F'),(42,'9741790023','6974\r\n','F'),(44,'9741790023','5903\r\n','F'),(46,'9741790023','3823\r\n','F'),(48,'9741790023','9774','F'),(50,'9741790023','1555','F'),(52,'974179023','1073','F'),(54,'974179023','4240','F'),(56,'974179023','3856','F'),(58,'974179023','8944','F'),(60,'974179023','2250','F'),(62,'9741790023','4661','F'),(64,'Enter your mobile number or Email','4249','F'),(66,'8095145554','5602','F'),(68,'8095145554','1953','F'),(70,'Enter your mobile number or Email','7422','F'),(72,'8095145554','1275','F'),(74,'8095145554','4331','F'),(76,'8095145554','8839','F'),(78,'8095145554','6980','F'),(80,'8095145554','4857','F'),(82,'8095145554','7226','F'),(84,'Enter your mobile number or Email','2165','Y'),(86,'8095145554','5944','F'),(88,'8095145554','4114','F'),(90,'8095145554','7563','F'),(92,'8095145554','1742','F'),(94,'8095145554','5369','F'),(96,'8095145554','1715','F'),(98,'8095145554','4444','F'),(100,'8095145554','5729','F'),(102,'8095145554','2624','F'),(104,'8095145554','4255','F'),(106,'8095145554','0324','F'),(108,'8095145554','7751','F'),(110,'974179023','1993','F'),(112,'974179023','8953','F'),(114,'8095145554','1534','F'),(116,'8095145554','4446','F'),(118,'8095145554','3576','F'),(120,'8095145554','0351','F'),(122,'8095145554','3945','F'),(124,'8095145554','5418','F'),(126,'8095145554','6819','F'),(128,'8095145554','2342','F'),(130,'8095145554','7806','F'),(132,'8095145554','1434','F'),(134,'8095145554','4876','F');
/*!40000 ALTER TABLE `otptable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservedseatinformation`
--

DROP TABLE IF EXISTS `reservedseatinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservedseatinformation` (
  `ID` int(11) NOT NULL,
  `busId` varchar(45) DEFAULT NULL,
  `routeid` varchar(45) DEFAULT NULL,
  `fromCity` varchar(45) DEFAULT NULL,
  `toCity` varchar(45) DEFAULT NULL,
  `BookedByEmail` varchar(45) DEFAULT NULL,
  `BookedByPhone` varchar(45) DEFAULT NULL,
  `PasengerName` varchar(45) DEFAULT NULL,
  `PassengerAge` varchar(45) DEFAULT NULL,
  `PassengerGender` varchar(45) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `seatnumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservedseatinformation`
--

LOCK TABLES `reservedseatinformation` WRITE;
/*!40000 ALTER TABLE `reservedseatinformation` DISABLE KEYS */;
INSERT INTO `reservedseatinformation` VALUES (2,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','asdf','asd','male','2019-05-18','24'),(3,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','asdfasdf','adsf','female','2019-05-18','29'),(4,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','asdf','asdf','male','2019-05-18','34'),(6,'1','0','1','2','rupaynirjhar@gmail.com','09741790023','dsfaasdf','asd','male','2019-05-18','23'),(7,'1','0','1','2','rupaynirjhar@gmail.com','09741790023','asdfasdf','asd','male','2019-05-18','28'),(8,'1','0','1','2','rupaynirjhar@gmail.com','09741790023','asdfasdf','asdf','male','2019-05-18','33'),(9,'1','0','1','2','rupaynirjhar@gmail.com','09741790023','asdfadsf','asdf','male','2019-05-18','38'),(10,'1','0','1','2','rupaynirjhar@gmail.com','09741790023','asdf','asdf','male','2019-05-18','43'),(11,'1','0','1','2','rupaynirjhar@gmail.com','09741790023','asdfa','asd','male','2019-05-18','48'),(12,'1','0','1','2','rupaynirjhar@gmail.com','09741790023','adsf','asd','male','2019-05-18','53'),(14,'1','0','1','2','rupaynirjhar@gmail.com','09741790023','sdafsadf','asdfasdf','male','2019-05-18','39'),(15,'1','0','1','2','rupaynirjhar@gmail.com','09741790023','asdfasdf','asdfasdf','male','2019-05-18','44'),(17,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','dasfd','asdf','male','2019-05-18','49'),(18,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','dsfg','sdfg','female','2019-05-18','54'),(20,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','dasfd','asdf','male','2019-05-18','49'),(21,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','dsfg','sdfg','female','2019-05-18','54'),(23,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','dasfd','asdf','male','2019-05-18','49'),(24,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','dsfg','sdfg','female','2019-05-18','54'),(26,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','asdfasdf','23','male','2019-05-11','39'),(27,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','asdfasdf','w','female','2019-05-11','54'),(29,'1','0','1','4','rupaynirjhar@gmail.com','09741790023','sdfg','23','male','2019-05-18','30'),(30,'1','0','1','4','rupaynirjhar@gmail.com','09741790023','sdfgsdfg','sfdg','female','2019-05-18','35'),(32,'1','0','1','4','rupaynirjhar@gmail.com','09741790023','sdfg','23','male','2019-05-18','30'),(33,'1','0','1','4','rupaynirjhar@gmail.com','09741790023','sdfgsdfg','sfdg','female','2019-05-18','35'),(35,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','asdfasdf','12','male','2019-05-18','40'),(37,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','kjhlkjhkj','d','female','2019-05-04','17'),(38,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','kjhkjhkjh','sdfadsfg','female','2019-05-04','22'),(39,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','dsfaadsfasdf','234','male','2019-05-04','27'),(41,'1','0','1','4','rupaynirjhar@gmail.com','09741790023','hlhkjhkh','87','male','2019-05-18','16'),(42,'1','0','1','4','rupaynirjhar@gmail.com','09741790023',';lkjlkjlkj','98','female','2019-05-18','21'),(43,'1','0','1','4','rupaynirjhar@gmail.com','09741790023','lkhkjhkjhkj','kjhj','null','2019-05-18','26'),(44,'1','0','1','4','rupaynirjhar@gmail.com','09741790023','mnmnjh','89','male','2019-05-18','31'),(46,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','nirjhar kumar paul','34','male','2019-05-18','36'),(48,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','nirjhar kumar paul','34','male','2019-05-18','36'),(50,'1','0','1','3','rupaynirjhar@gmail.com','9741790023','Nirjhar','23','male','2019-05-11','44'),(52,'1','0','1','3','rupaynirjhar@gmail.com','9741790023','Nirjhar','23','male','2019-05-11','44'),(54,'1','0','1','3','rupaynirjhar@gmail.com','09741790023','asdfasdf','34','male','2019-05-04','32');
/*!40000 ALTER TABLE `reservedseatinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `active` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'nirjhar kumar paul','rupaynirjhar@gmail.com','974179023','Thisisme@123','USER','Y'),(3,'Admin','admin@site.com','8095145554','Thissme@123','ADMIN','Y');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-03  1:05:53
