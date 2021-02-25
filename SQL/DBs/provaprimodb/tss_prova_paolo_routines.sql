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
-- Temporary view structure for view `v_stat`
--

DROP TABLE IF EXISTS `v_stat`;
/*!50001 DROP VIEW IF EXISTS `v_stat`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_stat` AS SELECT 
 1 AS `Nominativo`,
 1 AS `count(*)`,
 1 AS `Totale`,
 1 AS `Massimo`,
 1 AS `Minimo`,
 1 AS `Media`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_rend_corsi_all`
--

DROP TABLE IF EXISTS `v_rend_corsi_all`;
/*!50001 DROP VIEW IF EXISTS `v_rend_corsi_all`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_rend_corsi_all` AS SELECT 
 1 AS `nomeCorso`,
 1 AS `Totale`,
 1 AS `numIscritti`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_rend_corsi_attivi`
--

DROP TABLE IF EXISTS `v_rend_corsi_attivi`;
/*!50001 DROP VIEW IF EXISTS `v_rend_corsi_attivi`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_rend_corsi_attivi` AS SELECT 
 1 AS `id_corso`,
 1 AS `nomeCorso`,
 1 AS `Totale`,
 1 AS `numIscritti`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_stat`
--

/*!50001 DROP VIEW IF EXISTS `v_stat`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_stat` AS select concat(`a`.`nome`,' ',`a`.`cognome`) AS `Nominativo`,count(0) AS `count(*)`,sum((`c`.`costo` + `i`.`bollo`)) AS `Totale`,max((`c`.`costo` + `i`.`bollo`)) AS `Massimo`,min((`c`.`costo` + `i`.`bollo`)) AS `Minimo`,avg((`c`.`costo` + `i`.`bollo`)) AS `Media` from ((`tab_anagrafica` `a` join `tab_iscrizioni` `i` on((`a`.`id_anagrafica` = `i`.`id_anagrafica`))) join `tab_corsi` `c` on((`i`.`id_corso` = `c`.`id_corso`))) group by `Nominativo` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_rend_corsi_all`
--

/*!50001 DROP VIEW IF EXISTS `v_rend_corsi_all`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_rend_corsi_all` AS select `c`.`nomeCorso` AS `nomeCorso`,(`c`.`costo` * count(`i`.`id_iscrizione`)) AS `Totale`,count(`i`.`id_iscrizione`) AS `numIscritti` from (`tab_corsi` `c` left join `tab_iscrizioni` `i` on((`i`.`id_corso` = `c`.`id_corso`))) group by `c`.`id_corso`,`c`.`nomeCorso` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_rend_corsi_attivi`
--

/*!50001 DROP VIEW IF EXISTS `v_rend_corsi_attivi`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_rend_corsi_attivi` AS select `c`.`id_corso` AS `id_corso`,`c`.`nomeCorso` AS `nomeCorso`,sum(`c`.`costo`) AS `Totale`,count(0) AS `numIscritti` from (`tab_corsi` `c` join `tab_iscrizioni` `i` on((`i`.`id_corso` = `c`.`id_corso`))) group by `c`.`id_corso`,`c`.`nomeCorso` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Dumping events for database 'tss_prova_paolo'
--

--
-- Dumping routines for database 'tss_prova_paolo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-23 19:41:03
