CREATE DATABASE  IF NOT EXISTS `tss_prova_paolo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tss_prova_paolo`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: tss_prova_paolo
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
-- Table structure for table `tab_iscrizioni`
--

DROP TABLE IF EXISTS `tab_iscrizioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_iscrizioni` (
  `id_iscrizione` int NOT NULL AUTO_INCREMENT,
  `id_anagrafica` int unsigned NOT NULL,
  `id_corso` int unsigned NOT NULL,
  `dataIscritzione` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `attivo` tinyint DEFAULT '0',
  `bollo` int DEFAULT '20',
  PRIMARY KEY (`id_iscrizione`),
  UNIQUE KEY `uq_anagCorso` (`id_anagrafica`,`id_corso`),
  KEY `idx_anagrafica` (`id_anagrafica`) /*!80000 INVISIBLE */,
  KEY `idx_corso` (`id_corso`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_anagrafica` FOREIGN KEY (`id_anagrafica`) REFERENCES `tab_anagrafica` (`id_anagrafica`),
  CONSTRAINT `fk_corsi` FOREIGN KEY (`id_corso`) REFERENCES `tab_corsi` (`id_corso`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_iscrizioni`
--

LOCK TABLES `tab_iscrizioni` WRITE;
/*!40000 ALTER TABLE `tab_iscrizioni` DISABLE KEYS */;
INSERT INTO `tab_iscrizioni` VALUES (1,2,1,'2021-01-12 14:17:24',0,5),(2,1,3,'2021-01-12 14:17:24',0,10),(3,2,4,'2021-01-12 14:17:24',0,20),(4,1,1,'2021-01-19 14:54:12',0,20),(5,3,1,'2021-01-19 14:54:12',0,20),(6,4,1,'2021-01-19 14:54:12',0,20),(7,5,1,'2021-01-19 14:54:12',0,20);
/*!40000 ALTER TABLE `tab_iscrizioni` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-23 19:41:03
