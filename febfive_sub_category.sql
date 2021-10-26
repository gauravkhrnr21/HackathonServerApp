-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: febfive
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_category` (
  `sub_category_id` int NOT NULL AUTO_INCREMENT,
  `category_id` int DEFAULT NULL,
  `sub_category_name` varchar(255) NOT NULL,
  `group_name` varchar(255) NOT NULL,
  PRIMARY KEY (`sub_category_id`),
  KEY `FKl65dyy5me2ypoyj8ou1hnt64e` (`category_id`),
  CONSTRAINT `FKl65dyy5me2ypoyj8ou1hnt64e` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_category`
--

LOCK TABLES `sub_category` WRITE;
/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
INSERT INTO `sub_category` VALUES (2,1,'FOOT BALL','sport/fitness'),(4,1,'TREKKING','sport/fitness'),(5,1,'CARROM','sport/fitness'),(6,1,'BADMITTON','sport/fitness'),(7,1,'CRICKET','sport/fitness'),(8,1,'CYCLING','sport/fitness'),(10,1,'BOATING','sport/fitness'),(11,1,'MARATHON','sport/fitness'),(12,1,'TABLE TENNIS','sport/fitness'),(13,1,'WORKOUT','sport/fitness'),(14,2,'VEG','food'),(15,2,'NON VEG','food'),(16,3,'ZOOMBA','creativity'),(17,3,'TRADITIONAL DANCE','creativity'),(18,3,'MUSIC','creativity'),(20,3,'ART','creativity'),(21,3,'POEM','creativity'),(22,3,'LITERATURE','creativity'),(23,3,'ART & CRAFT','creativity'),(24,4,'JAVA','technology'),(25,4,'SQL','technology'),(26,4,'CLOUD','technology'),(27,4,'ANGULAR','technology'),(28,4,'NODE JS','technology'),(29,5,'EQUITY','stock updates'),(30,5,'IPO','stock updates'),(31,5,'MUTUAL FUNDS','stock updates'),(32,6,'BABY FOOD/HEALTH','parenting'),(33,6,'CHILD PSYCHOLOGY','parenting'),(34,6,'CHILDREN SPORTS','parenting'),(35,6,'ROOMMATE','parenting'),(36,7,'GARMENTS','shopping'),(37,7,'GROCERY','shopping'),(38,7,'SPORT EQUIPMENT','shopping'),(39,7,'ELECTRONICS','shopping');
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-26 13:22:06
