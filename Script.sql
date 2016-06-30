CREATE DATABASE  IF NOT EXISTS `dbbookmgt` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dbbookmgt`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbbookmgt
-- ------------------------------------------------------
-- Server version	5.7.9

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Rest API with JAVA','restjava.png','Jonhan',30),(2,'Spring Web Framework','springwebframework.png','Stef',40),(3,'Spring with Hibernate','springhibernate.png','Luc',20),(4,'Rest with Spring','restspring.png','Andrew',29),(5,'Web Development with Java','webjava.pnh','Wim',40),(8,'Spring and Hibernate','springhibernate.png','KAL',33),(9,'Web Development with Java EE','webjava.pnh','Wim',40),(10,'JAVA APP Development with Java SE','webjava.pnh','Wim Polet',40),(11,'JAVA APP Development with Java SE','webjava.pnh','Wim Polet',40),(12,'JAVA APP Development with Java SE','webjava.pnh','Wim Polet',40),(13,'JAVA APP Development with Java SE','webjava.pnh','Wim Polet',40),(14,'JAVA APP Development with Java SE','webjava.pnh','Wim Polet',40),(15,'JAVA APP Development with Java SE','webjava.pnh','Wim Polet',40),(16,'JAVA APP Development with Java SE','webjava.pnh','Wim Polet',40),(17,'JAVA APP Development with Java SE','webjava.pnh','Wim Polet',40),(18,'JAVA Java SE','webjava.pnh','Polet',40);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-28 17:11:39
