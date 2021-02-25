CREATE DATABASE  IF NOT EXISTS `parlamento` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `parlamento`;
-- MySQL dump 10.18  Distrib 10.3.27-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: parlamento
-- ------------------------------------------------------
-- Server version	10.3.27-MariaDB-0+deb10u1

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
-- Table structure for table `commenti`
--

DROP TABLE IF EXISTS `commenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commenti` (
  `idcommenti` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idargomento` int(10) unsigned NOT NULL,
  `idutente` int(10) unsigned NOT NULL,
  `testo` longtext NOT NULL,
  `rating` int(11) NOT NULL,
  `datacommento` datetime DEFAULT NULL,
  PRIMARY KEY (`idcommenti`),
  UNIQUE KEY `fk_argomenti_partititi` (`idutente`,`idargomento`),
  KEY `fk_partiti_idx` (`idutente`),
  KEY `fk_argomenti_idx` (`idargomento`),
  CONSTRAINT `fk_argomenti` FOREIGN KEY (`idargomento`) REFERENCES `argomenti` (`idargomento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_utenti` FOREIGN KEY (`idutente`) REFERENCES `utenti` (`idutente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `CHK_Rating` CHECK (`rating` > -6 and `rating` < 6)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commenti`
--

LOCK TABLES `commenti` WRITE;
/*!40000 ALTER TABLE `commenti` DISABLE KEYS */;
INSERT INTO `commenti` VALUES (1,1,1,'Phasellus quis maximus sem. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Suspendisse semper ipsum et enim fringilla, at pharetra tellus rutrum. Quisque tellus metus, bibendum eget justo in, iaculis accumsan neque. Donec nec erat porttitor, pellentesque sem non, tincidunt ante. Suspendisse sed nisi vitae lacus suscipit ultricies. Fusce rhoncus volutpat purus, eget mattis felis. Maecenas leo risus, placerat sit amet placerat in, bibendum finibus sapien.\n\nPhasellus in malesuada risus. Maecenas egestas blandit maximus. Aenean non erat non augue varius lacinia. Praesent pellentesque tincidunt justo, in aliquam est egestas ac. Morbi vehicula, nisi ut imperdiet varius, ante nulla accumsan eros, aliquam sodales metus libero eu arcu. Suspendisse ultricies lectus eget enim commodo, et venenatis velit vehicula. Proin lacinia scelerisque magna, ac auctor enim. Praesent ac tempor leo. Phasellus interdum lacus vel sodales tristique. Nam commodo felis est, nec dapibus lorem dignissim vitae. In hac habitasse platea dictumst. Proin tortor diam, egestas a laoreet nec, eleifend ac est. Duis vitae faucibus ante, et vestibulum sem. Praesent mattis a nulla vitae pellentesque. Proin arcu nisl, venenatis sed urna tincidunt, vehicula finibus lorem.',3,'2021-02-23 15:20:01'),(2,1,2,'Etiam auctor malesuada leo at aliquet. Phasellus quis suscipit magna. Aenean scelerisque dolor quis turpis luctus, et mollis tortor condimentum. Donec id est eget sapien bibendum ullamcorper. Proin tincidunt bibendum arcu, et euismod diam tincidunt non. Donec molestie leo ac risus elementum ornare. Donec neque lacus, cursus quis congue sed, laoreet et nunc.\n\nAliquam efficitur nibh vel volutpat ultricies. Pellentesque luctus tortor diam, sed tincidunt mauris semper sit amet. Quisque ultrices porttitor ipsum, et tristique nunc congue eget. Morbi pharetra fermentum ullamcorper. In hac habitasse platea dictumst. Proin vulputate, enim quis consequat sollicitudin, odio lectus convallis turpis, nec pharetra ante mi vel nisi. Nunc metus ligula, mattis nec libero vel, hendrerit consequat libero. Nam rutrum scelerisque urna quis maximus.',4,'2021-02-23 14:25:15'),(9,2,1,'Nullam id mauris ac turpis posuere congue sollicitudin sit amet dolor. Morbi id urna tellus. Aenean lorem dolor, varius sit amet rutrum vel, vehicula placerat augue. Fusce eget pharetra lacus. Quisque eget massa vel urna luctus volutpat. Cras tristique mattis dui et imperdiet. Aliquam ut urna non urna luctus egestas. Curabitur condimentum risus et nisl pulvinar, volutpat efficitur nulla vestibulum. Nam lobortis aliquam lectus, eget sodales arcu dictum vehicula. Nunc ultrices, leo eu dapibus semper, magna libero feugiat lacus, vitae iaculis felis tortor interdum lacus. Nulla bibendum diam sed elit vestibulum facilisis. Ut sed egestas arcu, sed imperdiet elit. Integer luctus nibh elit, ac mollis ante tincidunt sit amet. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. MOD',5,'2021-02-23 17:21:48'),(10,2,3,'Praesent fermentum scelerisque erat, sed imperdiet dolor condimentum nec. Morbi ullamcorper sed dolor et mattis. Suspendisse et sollicitudin ligula, ac suscipit tortor. Etiam ut molestie elit. Etiam nisl magna, tempus in sollicitudin eget, tempor ut justo. Nulla eu malesuada felis, suscipit lacinia enim. Donec magna velit, faucibus vel dapibus sed, euismod sit amet libero. Etiam interdum iaculis ante ac condimentum. Vivamus id est vulputate, consequat lectus in, sagittis arcu. Integer nec tempor tellus, at bibendum nisi. Praesent urna ipsum, semper in turpis et, venenatis dictum eros. Aliquam aliquam convallis purus, a vulputate justo blandit non. Duis mattis tortor velit, ac laoreet quam viverra eget.\n\nSuspendisse sed mauris dapibus, varius nibh eu, facilisis nibh. Donec ut augue metus. Ut facilisis diam sed aliquet tempus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer metus mauris, suscipit vel ligula et, ornare tempor neque. Duis pellentesque lacus eu molestie vehicula. Donec tincidunt lacinia eleifend. In accumsan nisl convallis nunc finibus pellentesque. Cras in cursus risus, a fringilla velit. Duis egestas augue in augue bibendum aliquam.',4,'2021-02-23 14:25:15'),(11,1,4,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi tincidunt rhoncus enim, sit amet fringilla libero semper ac. Donec nisl mauris, auctor et dui semper, gravida luctus leo. Nulla laoreet sem eu dolor maximus pellentesque. Cras rhoncus, erat non pretium tincidunt, ante dui elementum quam, ultricies pellentesque velit nisi sit amet lorem. Maecenas hendrerit ultricies blandit. Aliquam quis dolor quis erat suscipit tristique ut suscipit nisi. Etiam quis luctus erat. Integer bibendum ac sem eget accumsan. Aliquam mattis nibh ut metus cursus accumsan.',4,'2021-02-23 17:21:12'),(12,1,5,'Praesent fermentum scelerisque erat, sed imperdiet dolor condimentum nec. Morbi ullamcorper sed dolor et mattis. Suspendisse et sollicitudin ligula, ac suscipit tortor. Etiam ut molestie elit. Etiam nisl magna, tempus in sollicitudin eget, tempor ut justo. Nulla eu malesuada felis, suscipit lacinia enim. Donec magna velit, faucibus vel dapibus sed, euismod sit amet libero. Etiam interdum iaculis ante ac condimentum. Vivamus id est vulputate, consequat lectus in, sagittis arcu. Integer nec tempor tellus, at bibendum nisi. Praesent urna ipsum, semper in turpis et, venenatis dictum eros. Aliquam aliquam convallis purus, a vulputate justo blandit non. Duis mattis tortor velit, ac laoreet quam viverra eget.\n\nSuspendisse sed mauris dapibus, varius nibh eu, facilisis nibh. Donec ut augue metus. Ut facilisis diam sed aliquet tempus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer metus mauris, suscipit vel ligula et, ornare tempor neque. Duis pellentesque lacus eu molestie vehicula. Donec tincidunt lacinia eleifend. In accumsan nisl convallis nunc finibus pellentesque. Cras in cursus risus, a fringilla velit. Duis egestas augue in augue bibendum aliquam. MOD ',2,'2021-02-23 17:21:48'),(13,2,4,'Suspendisse sed mauris dapibus, varius nibh eu, facilisis nibh. Donec ut augue metus. Ut facilisis diam sed aliquet tempus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer metus mauris, suscipit vel ligula et, ornare tempor neque. Duis pellentesque lacus eu molestie vehicula. Donec tincidunt lacinia eleifend. In accumsan nisl convallis nunc finibus pellentesque. Cras in cursus risus, a fringilla velit. Duis egestas augue in augue bibendum aliquam.\n\nNullam id mauris ac turpis posuere congue sollicitudin sit amet dolor. Morbi id urna tellus. Aenean lorem dolor, varius sit amet rutrum vel, vehicula placerat augue. Fusce eget pharetra lacus. Quisque eget massa vel urna luctus volutpat. Cras tristique mattis dui et imperdiet. Aliquam ut urna non urna luctus egestas. Curabitur condimentum risus et nisl pulvinar, volutpat efficitur nulla vestibulum. Nam lobortis aliquam lectus, eget sodales arcu dictum vehicula. Nunc ultrices, leo eu dapibus semper, magna libero feugiat lacus, vitae iaculis felis tortor interdum lacus. Nulla bibendum diam sed elit vestibulum facilisis. Ut sed egestas arcu, sed imperdiet elit. Integer luctus nibh elit, ac mollis ante tincidunt sit amet. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.',1,'2021-02-23 14:25:15'),(15,3,1,'Suspendisse sed mauris dapibus, varius nibh eu, facilisis nibh. Donec ut augue metus. Ut facilisis diam sed aliquet tempus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer metus mauris, suscipit vel ligula et, ornare tempor neque. Duis pellentesque lacus eu molestie vehicula. Donec tincidunt lacinia eleifend. In accumsan nisl convallis nunc finibus pellentesque. Cras in cursus risus, a fringilla velit. Duis egestas augue in augue bibendum aliquam.\n\nNullam id mauris ac turpis posuere congue sollicitudin sit amet dolor. Morbi id urna tellus. Aenean lorem dolor, varius sit amet rutrum vel, vehicula placerat augue. Fusce eget pharetra lacus. Quisque eget massa vel urna luctus volutpat. Cras tristique mattis dui et imperdiet. Aliquam ut urna non urna luctus egestas. Curabitur condimentum risus et nisl pulvinar, volutpat efficitur nulla vestibulum. Nam lobortis aliquam lectus, eget sodales arcu dictum vehicula. Nunc ultrices, leo eu dapibus semper, magna libero feugiat lacus, vitae iaculis felis tortor interdum lacus. Nulla bibendum diam sed elit vestibulum facilisis. Ut sed egestas arcu, sed imperdiet elit. Integer luctus nibh elit, ac mollis ante tincidunt sit amet. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.',3,'2021-02-23 15:16:55'),(16,3,5,'Praesent fermentum scelerisque erat, sed imperdiet dolor condimentum nec. Morbi ullamcorper sed dolor et mattis. Suspendisse et sollicitudin ligula, ac suscipit tortor. Etiam ut molestie elit. Etiam nisl magna, tempus in sollicitudin eget, tempor ut justo. Nulla eu malesuada felis, suscipit lacinia enim. Donec magna velit, faucibus vel dapibus sed, euismod sit amet libero. Etiam interdum iaculis ante ac condimentum. Vivamus id est vulputate, consequat lectus in, sagittis arcu. Integer nec tempor tellus, at bibendum nisi. Praesent urna ipsum, semper in turpis et, venenatis dictum eros. Aliquam aliquam convallis purus, a vulputate justo blandit non. Duis mattis tortor velit, ac laoreet quam viverra eget.\n\nSuspendisse sed mauris dapibus, varius nibh eu, facilisis nibh. Donec ut augue metus. Ut facilisis diam sed aliquet tempus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer metus mauris, suscipit vel ligula et, ornare tempor neque. Duis pellentesque lacus eu molestie vehicula. Donec tincidunt lacinia eleifend. In accumsan nisl convallis nunc finibus pellentesque. Cras in cursus risus, a fringilla velit. Duis egestas augue in augue bibendum aliquam.',2,'2021-02-23 15:16:55'),(17,4,1,'Nullam id mauris ac turpis posuere congue sollicitudin sit amet dolor. Morbi id urna tellus. Aenean lorem dolor, varius sit amet rutrum vel, vehicula placerat augue. Fusce eget pharetra lacus. Quisque eget massa vel urna luctus volutpat. Cras tristique mattis dui et imperdiet. Aliquam ut urna non urna luctus egestas. Curabitur condimentum risus et nisl pulvinar, volutpat efficitur nulla vestibulum. Nam lobortis aliquam lectus, eget sodales arcu dictum vehicula. Nunc ultrices, leo eu dapibus semper, magna libero feugiat lacus, vitae iaculis felis tortor interdum lacus. Nulla bibendum diam sed elit vestibulum facilisis. Ut sed egestas arcu, sed imperdiet elit. Integer luctus nibh elit, ac mollis ante tincidunt sit amet. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.',1,'2021-02-23 15:16:55');
/*!40000 ALTER TABLE `commenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`tss`@`localhost`*/ /*!50003 TRIGGER `parlamento`.`commenti_BEFORE_INSERT` BEFORE INSERT ON `commenti` FOR EACH ROW
BEGIN
set new.datacommento = CURRENT_TIMESTAMP();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`tss`@`localhost`*/ /*!50003 TRIGGER `parlamento`.`commenti_partiti_BEFORE_UPDATE` BEFORE UPDATE ON `commenti` FOR EACH ROW
BEGIN
set new.datacommento = CURRENT_TIMESTAMP();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`tss`@`localhost`*/ /*!50003 TRIGGER `parlamento`.`commenti_BEFORE_UPDATE` BEFORE UPDATE ON `commenti` FOR EACH ROW 
BEGIN
INSERT INTO parlamento.log_commenti VALUES (old.idcommenti, old.idargomento, old.idutente, old.testo, old.rating, old.datacommento);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-24 10:06:13
