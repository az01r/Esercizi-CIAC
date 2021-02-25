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
-- Dumping routines for database 'parlamento'
--
/*!50003 DROP PROCEDURE IF EXISTS `procedure_commenti_utente_argomento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`tss`@`localhost` PROCEDURE `procedure_commenti_utente_argomento`( in id int(10), arg varchar(50))
BEGIN 
select commenti.testo AS Commenti
from commenti
join argomenti on commenti.idargomento=argomenti.idargomento
where (commenti.idutente=id  and argomenti.macroargomento = arg);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary table structure for view `vista_n_commenti_per_argomento`
--

DROP TABLE IF EXISTS `vista_n_commenti_per_argomento`;
/*!50001 DROP VIEW IF EXISTS `vista_n_commenti_per_argomento`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vista_n_commenti_per_argomento` (
  `Ambito` tinyint NOT NULL,
  `Argomento` tinyint NOT NULL,
  `N° commenti` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vista_ultimi_commenti_per_argomento`
--

DROP TABLE IF EXISTS `vista_ultimi_commenti_per_argomento`;
/*!50001 DROP VIEW IF EXISTS `vista_ultimi_commenti_per_argomento`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vista_ultimi_commenti_per_argomento` (
  `argomento` tinyint NOT NULL,
  `testo` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vista_completa`
--

DROP TABLE IF EXISTS `vista_completa`;
/*!50001 DROP VIEW IF EXISTS `vista_completa`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vista_completa` (
  `Ambito` tinyint NOT NULL,
  `Argomento` tinyint NOT NULL,
  `Descrizione` tinyint NOT NULL,
  `Nominativo` tinyint NOT NULL,
  `Tipo` tinyint NOT NULL,
  `Sigla Partito` tinyint NOT NULL,
  `Commento` tinyint NOT NULL,
  `Rating` tinyint NOT NULL,
  `Data Commento` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vista_media_valutazioni`
--

DROP TABLE IF EXISTS `vista_media_valutazioni`;
/*!50001 DROP VIEW IF EXISTS `vista_media_valutazioni`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vista_media_valutazioni` (
  `Argomento` tinyint NOT NULL,
  `Data Commento` tinyint NOT NULL,
  `Media Valutazioni` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vista_n_commenti_per_argomento`
--

/*!50001 DROP TABLE IF EXISTS `vista_n_commenti_per_argomento`*/;
/*!50001 DROP VIEW IF EXISTS `vista_n_commenti_per_argomento`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_n_commenti_per_argomento` AS select `argomenti`.`macroargomento` AS `Ambito`,`argomenti`.`argomento` AS `Argomento`,count(`commenti`.`testo`) AS `N° commenti` from (`argomenti` join `commenti` on(`commenti`.`idargomento` = `argomenti`.`idargomento`)) group by `argomenti`.`argomento` order by 'N° commenti' desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_ultimi_commenti_per_argomento`
--

/*!50001 DROP TABLE IF EXISTS `vista_ultimi_commenti_per_argomento`*/;
/*!50001 DROP VIEW IF EXISTS `vista_ultimi_commenti_per_argomento`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_ultimi_commenti_per_argomento` AS select `argomenti`.`argomento` AS `argomento`,`commenti`.`testo` AS `testo` from (`argomenti` join `commenti` on(`commenti`.`idargomento` = `argomenti`.`idargomento`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_completa`
--

/*!50001 DROP TABLE IF EXISTS `vista_completa`*/;
/*!50001 DROP VIEW IF EXISTS `vista_completa`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_completa` AS select `argomenti`.`macroargomento` AS `Ambito`,`argomenti`.`argomento` AS `Argomento`,`argomenti`.`testo` AS `Descrizione`,concat(`utenti`.`nome`,' ',`utenti`.`cognome`) AS `Nominativo`,`utenti`.`tipo` AS `Tipo`,`utenti`.`siglapartito` AS `Sigla Partito`,`commenti`.`testo` AS `Commento`,`commenti`.`rating` AS `Rating`,`commenti`.`datacommento` AS `Data Commento` from ((`argomenti` join `commenti` on(`commenti`.`idargomento` = `argomenti`.`idargomento`)) join `utenti` on(`commenti`.`idutente` = `utenti`.`idutente`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_media_valutazioni`
--

/*!50001 DROP TABLE IF EXISTS `vista_media_valutazioni`*/;
/*!50001 DROP VIEW IF EXISTS `vista_media_valutazioni`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_media_valutazioni` AS select `argomenti`.`argomento` AS `Argomento`,`commenti`.`datacommento` AS `Data Commento`,avg(`commenti`.`rating`) AS `Media Valutazioni` from (`argomenti` join `commenti` on(`commenti`.`idargomento` = `argomenti`.`idargomento`)) group by `argomenti`.`argomento` order by 'Argomento',`commenti`.`datacommento`,'Media Valutazioni' */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Dumping events for database 'parlamento'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-24 10:06:13
