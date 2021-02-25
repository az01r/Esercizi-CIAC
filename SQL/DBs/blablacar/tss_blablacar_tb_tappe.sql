CREATE DATABASE  IF NOT EXISTS `tss_blablacar` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tss_blablacar`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: tss_blablacar
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
-- Table structure for table `tb_tappe`
--

DROP TABLE IF EXISTS `tb_tappe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tappe` (
  `idtb_tappa` int unsigned NOT NULL AUTO_INCREMENT,
  `idtb_cittaT` int unsigned NOT NULL,
  `indirizzo` varchar(145) NOT NULL,
  `dataOra` datetime NOT NULL,
  `idtb_viaggioT` int unsigned NOT NULL,
  `ordineSosta` tinyint NOT NULL,
  PRIMARY KEY (`idtb_tappa`),
  KEY `idx_viaggioT` (`idtb_viaggioT`),
  KEY `fk_cittaT_idx` (`idtb_cittaT`),
  CONSTRAINT `fk_cittaT` FOREIGN KEY (`idtb_cittaT`) REFERENCES `tb_citta` (`idtb_citta`),
  CONSTRAINT `fk_viaggiT` FOREIGN KEY (`idtb_viaggioT`) REFERENCES `tb_viaggi` (`idtb_viaggio`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tappe`
--

LOCK TABLES `tb_tappe` WRITE;
/*!40000 ALTER TABLE `tb_tappe` DISABLE KEYS */;
INSERT INTO `tb_tappe` VALUES (1,1,'Via Bertolotti','2021-01-22 14:00:00',1,1),(2,3,'via qe','2021-01-22 14:10:00',1,2),(3,2,'viaqeqwe','2021-01-22 15:00:00',1,3);
/*!40000 ALTER TABLE `tb_tappe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-23 19:41:04
