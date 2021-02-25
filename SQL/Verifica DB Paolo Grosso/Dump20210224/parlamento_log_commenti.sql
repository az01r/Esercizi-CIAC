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
-- Table structure for table `log_commenti`
--

DROP TABLE IF EXISTS `log_commenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_commenti` (
  `idlog_commento` int(10) unsigned NOT NULL,
  `idargomento` int(10) unsigned NOT NULL,
  `idutente` int(10) unsigned NOT NULL,
  `testo` longtext NOT NULL,
  `rating` int(11) NOT NULL,
  `datacommento` datetime DEFAULT NULL,
  PRIMARY KEY (`idlog_commento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_commenti`
--

LOCK TABLES `log_commenti` WRITE;
/*!40000 ALTER TABLE `log_commenti` DISABLE KEYS */;
INSERT INTO `log_commenti` VALUES (11,1,4,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi tincidunt rhoncus enim, sit amet fringilla libero semper ac. Donec nisl mauris, auctor et dui semper, gravida luctus leo. Nulla laoreet sem eu dolor maximus pellentesque. Cras rhoncus, erat non pretium tincidunt, ante dui elementum quam, ultricies pellentesque velit nisi sit amet lorem. Maecenas hendrerit ultricies blandit. Aliquam quis dolor quis erat suscipit tristique ut suscipit nisi. Etiam quis luctus erat. Integer bibendum ac sem eget accumsan. Aliquam mattis nibh ut metus cursus accumsan. MOD',4,'2021-02-23 17:16:32'),(12,1,5,'Praesent fermentum scelerisque erat, sed imperdiet dolor condimentum nec. Morbi ullamcorper sed dolor et mattis. Suspendisse et sollicitudin ligula, ac suscipit tortor. Etiam ut molestie elit. Etiam nisl magna, tempus in sollicitudin eget, tempor ut justo. Nulla eu malesuada felis, suscipit lacinia enim. Donec magna velit, faucibus vel dapibus sed, euismod sit amet libero. Etiam interdum iaculis ante ac condimentum. Vivamus id est vulputate, consequat lectus in, sagittis arcu. Integer nec tempor tellus, at bibendum nisi. Praesent urna ipsum, semper in turpis et, venenatis dictum eros. Aliquam aliquam convallis purus, a vulputate justo blandit non. Duis mattis tortor velit, ac laoreet quam viverra eget.\n\nSuspendisse sed mauris dapibus, varius nibh eu, facilisis nibh. Donec ut augue metus. Ut facilisis diam sed aliquet tempus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer metus mauris, suscipit vel ligula et, ornare tempor neque. Duis pellentesque lacus eu molestie vehicula. Donec tincidunt lacinia eleifend. In accumsan nisl convallis nunc finibus pellentesque. Cras in cursus risus, a fringilla velit. Duis egestas augue in augue bibendum aliquam. ',2,'2021-02-23 17:20:34');
/*!40000 ALTER TABLE `log_commenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-24 10:06:13
