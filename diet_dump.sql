-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: diet
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

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
-- Table structure for table `body_measurement`
--

DROP TABLE IF EXISTS `body_measurement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `body_measurement` (
  `id` bigint(20) NOT NULL,
  `date_of_inspection` date DEFAULT NULL,
  `fat_mass_kg` double NOT NULL,
  `fat_percent` double NOT NULL,
  `ffm_mass_kg` double NOT NULL,
  `ffm_percent` double NOT NULL,
  `height_cm` int(11) NOT NULL,
  `weight_kg` double NOT NULL,
  `patient_id` bigint(20) DEFAULT NULL,
  `bmi` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKel8qplcu1ccm6l6c3yva5583t` (`patient_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `body_measurement`
--

LOCK TABLES `body_measurement` WRITE;
/*!40000 ALTER TABLE `body_measurement` DISABLE KEYS */;
INSERT INTO `body_measurement` VALUES (5,'2018-11-21',25,29,35,44,175,75,2,0),(6,'2018-10-24',33,43,50,55,175,70,2,0),(7,'2018-08-18',23,30,35,40,175,73,2,0);
/*!40000 ALTER TABLE `body_measurement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (8),(8),(8);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `id` bigint(20) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pesel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (2,'1979-04-23','user1@mail.com','Jasinski','Grzegorz','79042369235'),(3,'1985-12-06','user2@mail.com','Kowalski','Jan','85061222226'),(4,'1978-02-09','lukas@gmail.com','Podolski','Lukas','78090264752');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_body_measurements`
--

DROP TABLE IF EXISTS `patient_body_measurements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_body_measurements` (
  `patient_id` bigint(20) NOT NULL,
  `body_measurements_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_2yb1ir1i2ks44h63gv8byo46e` (`body_measurements_id`),
  KEY `FKbb4vrg9f4f31bn93fbgr5rdh0` (`patient_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_body_measurements`
--

LOCK TABLES `patient_body_measurements` WRITE;
/*!40000 ALTER TABLE `patient_body_measurements` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_body_measurements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_roles`
--

DROP TABLE IF EXISTS `patient_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_roles` (
  `patient_id` bigint(20) NOT NULL,
  `roles_role_id` int(11) NOT NULL,
  PRIMARY KEY (`patient_id`,`roles_role_id`),
  KEY `FK40n57p3qsu2xhb8h59j80nsku` (`roles_role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_roles`
--

LOCK TABLES `patient_roles` WRITE;
/*!40000 ALTER TABLE `patient_roles` DISABLE KEYS */;
INSERT INTO `patient_roles` VALUES (2,1),(3,1),(4,1);
/*!40000 ALTER TABLE `patient_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_PATIENT'),(2,'ROLE_USER'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-04 18:23:39
