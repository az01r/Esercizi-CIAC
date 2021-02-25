CREATE DATABASE  IF NOT EXISTS `classicmodels` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `classicmodels`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: classicmodels
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `argomenti`
--

DROP TABLE IF EXISTS `argomenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `argomenti` (
  `idargomento` int unsigned NOT NULL AUTO_INCREMENT,
  `argomento` varchar(45) NOT NULL,
  `testo` longtext NOT NULL,
  `macroargomento` varchar(45) NOT NULL,
  `img` varchar(45) DEFAULT NULL,
  `fonti` mediumtext,
  PRIMARY KEY (`idargomento`),
  KEY `fk_argomenti_idx` (`macroargomento`),
  CONSTRAINT `fk_argomento` FOREIGN KEY (`macroargomento`) REFERENCES `macroargomenti` (`macroargomento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `argomenti`
--

LOCK TABLES `argomenti` WRITE;
/*!40000 ALTER TABLE `argomenti` DISABLE KEYS */;
INSERT INTO `argomenti` VALUES (1,'MES','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas rutrum bibendum lectus eu aliquam. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas et facilisis nibh. Duis a justo eu est mollis bibendum nec id lorem. Quisque in enim tortor. Aliquam non ornare ipsum. Vestibulum venenatis ultrices arcu, quis auctor purus consequat quis. Etiam vitae finibus urna. Donec sagittis porttitor nisi ac bibendum. Vivamus laoreet imperdiet ligula, bibendum pellentesque libero varius eu. Aliquam ut facilisis felis, sit amet blandit orci. Proin gravida suscipit enim. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin tempus felis finibus congue facilisis. Nunc vel sem rutrum, semper turpis in, facilisis ipsum.','Economia',NULL,'https://www.lipsum.com/feed/html'),(2,'TAV','Sed consectetur tempor elit a sodales. In hac habitasse platea dictumst. Maecenas fringilla nunc id nulla congue, ut molestie nisi ultricies. Duis at tempor ante. Duis malesuada porttitor semper. Etiam non ultrices lectus, nec dapibus nulla. Nunc pulvinar consequat nulla, eu ultrices odio bibendum eget. Praesent porttitor, augue nec vehicula viverra, elit sem hendrerit mi, auctor blandit nunc dolor id tellus. Maecenas dapibus metus eu aliquet pulvinar. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras aliquam posuere tincidunt. Fusce mi dolor, tincidunt ut congue sit amet, elementum eget purus.','Trasporti',NULL,'https://www.lipsum.com/feed/html'),(3,'Recovery Found','Fusce a porttitor enim, vel convallis ex. Nullam enim lacus, mollis et justo sed, viverra rutrum libero. Donec blandit, nulla quis porttitor posuere, tellus dui facilisis quam, accumsan porta nisl tortor eu dolor. Maecenas eu accumsan ipsum. Nulla facilisi. Fusce in velit velit. Nunc viverra dignissim augue ac gravida. Morbi lacinia arcu eu lectus aliquet fermentum. Vestibulum fermentum cursus risus, ac finibus mauris. Vivamus ut fermentum enim.\n\nInteger vestibulum eget purus in faucibus. Etiam eget vehicula velit. Sed metus libero, tincidunt vitae diam eu, aliquet sagittis metus. Duis consectetur ante odio, ut suscipit mauris consequat vel. Aenean consequat mollis mattis. Integer non dui in est sodales dapibus. Sed sagittis condimentum augue. Nulla id tortor vestibulum, condimentum mauris ac, bibendum magna. Aenean finibus est diam, vel finibus mauris pulvinar at.','Economia',NULL,'https://www.lipsum.com/feed/html'),(4,'Migranti','Sed consectetur tempor elit a sodales. In hac habitasse platea dictumst. Maecenas fringilla nunc id nulla congue, ut molestie nisi ultricies. Duis at tempor ante. Duis malesuada porttitor semper. Etiam non ultrices lectus, nec dapibus nulla. Nunc pulvinar consequat nulla, eu ultrices odio bibendum eget. Praesent porttitor, augue nec vehicula viverra, elit sem hendrerit mi, auctor blandit nunc dolor id tellus. Maecenas dapibus metus eu aliquet pulvinar. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras aliquam posuere tincidunt. Fusce mi dolor, tincidunt ut congue sit amet, elementum eget purus.\n\nEtiam eleifend lorem purus, hendrerit bibendum orci imperdiet id. Ut ac purus ut ipsum sodales tempor. Duis quis urna nunc. Donec augue ante, finibus sed nunc ac, auctor fermentum lectus. Nulla egestas lacus sem, in gravida justo volutpat vel. Suspendisse justo orci, ornare quis nulla sit amet, pellentesque tincidunt velit. Suspendisse lobortis consectetur hendrerit. Donec commodo blandit urna volutpat varius. Suspendisse ut lorem pulvinar, varius mauris in, aliquam augue. Ut tristique scelerisque dictum.','Aiuti Umanitari',NULL,'');
/*!40000 ALTER TABLE `argomenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-23 19:41:02
