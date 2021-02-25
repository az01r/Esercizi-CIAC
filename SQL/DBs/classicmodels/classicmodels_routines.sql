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
-- Temporary view structure for view `v_top5employees`
--

DROP TABLE IF EXISTS `v_top5employees`;
/*!50001 DROP VIEW IF EXISTS `v_top5employees`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_top5employees` AS SELECT 
 1 AS `territory`,
 1 AS `employeeNumber`,
 1 AS `lastName`,
 1 AS `firstName`,
 1 AS `country`,
 1 AS `email`,
 1 AS `TotSold`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_sales`
--

DROP TABLE IF EXISTS `v_sales`;
/*!50001 DROP VIEW IF EXISTS `v_sales`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_sales` AS SELECT 
 1 AS `customerNumber`,
 1 AS `salesRepEmployeeNumber`,
 1 AS `customerName`,
 1 AS `orderNumber`,
 1 AS `orderDate`,
 1 AS `productCode`,
 1 AS `priceEach`,
 1 AS `quantityOrdered`,
 1 AS `buyPrice`,
 1 AS `productName`,
 1 AS `productLine`,
 1 AS `TotSold`,
 1 AS `TotSpent`,
 1 AS `TotEarned`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_totsold_totiva`
--

DROP TABLE IF EXISTS `v_totsold_totiva`;
/*!50001 DROP VIEW IF EXISTS `v_totsold_totiva`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_totsold_totiva` AS SELECT 
 1 AS `TotSold`,
 1 AS `TotIVA`,
 1 AS `TotNoIVA`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_organigramma`
--

DROP TABLE IF EXISTS `v_organigramma`;
/*!50001 DROP VIEW IF EXISTS `v_organigramma`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_organigramma` AS SELECT 
 1 AS `employeeNumber`,
 1 AS `lastName`,
 1 AS `firstName`,
 1 AS `jobTitle`,
 1 AS `lastNameC`,
 1 AS `firstNameC`,
 1 AS `jobTitleC`,
 1 AS `lastNameCC`,
 1 AS `firstNameCC`,
 1 AS `jobTitleCC`,
 1 AS `lastNameCCC`,
 1 AS `firstNameCCC`,
 1 AS `jobTitleCCC`,
 1 AS `city`,
 1 AS `country`,
 1 AS `territory`,
 1 AS `officeCode`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_totricavato`
--

DROP TABLE IF EXISTS `v_totricavato`;
/*!50001 DROP VIEW IF EXISTS `v_totricavato`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_totricavato` AS SELECT 
 1 AS `TotRicavato`,
 1 AS `lastNameC`,
 1 AS `firstNameC`,
 1 AS `jobTitleC`,
 1 AS `Anno`,
 1 AS `Mese`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_tipo_customers`
--

DROP TABLE IF EXISTS `v_tipo_customers`;
/*!50001 DROP VIEW IF EXISTS `v_tipo_customers`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_tipo_customers` AS SELECT 
 1 AS `customerNumber`,
 1 AS `customerName`,
 1 AS `contactLastName`,
 1 AS `contactFirstName`,
 1 AS `phone`,
 1 AS `addressLine1`,
 1 AS `addressLine2`,
 1 AS `city`,
 1 AS `state`,
 1 AS `postalCode`,
 1 AS `country`,
 1 AS `salesRepEmployeeNumber`,
 1 AS `creditLimit`,
 1 AS `tipo`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_employeesnumber`
--

DROP TABLE IF EXISTS `v_employeesnumber`;
/*!50001 DROP VIEW IF EXISTS `v_employeesnumber`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_employeesnumber` AS SELECT 
 1 AS `city`,
 1 AS `country`,
 1 AS `territory`,
 1 AS `postalCode`,
 1 AS `EmployeesNumber`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_tot_products_expenses`
--

DROP TABLE IF EXISTS `v_tot_products_expenses`;
/*!50001 DROP VIEW IF EXISTS `v_tot_products_expenses`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_tot_products_expenses` AS SELECT 
 1 AS `productLine`,
 1 AS `TotExpenses`,
 1 AS `MaxTotExpenses`,
 1 AS `minTotExpenses`,
 1 AS `countProducts`,
 1 AS `MediaGiacenza`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_totstock`
--

DROP TABLE IF EXISTS `v_totstock`;
/*!50001 DROP VIEW IF EXISTS `v_totstock`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_totstock` AS SELECT 
 1 AS `Tot`,
 1 AS `ProductName`,
 1 AS `QuantityInStock`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_mostimportantorderscompleted`
--

DROP TABLE IF EXISTS `v_mostimportantorderscompleted`;
/*!50001 DROP VIEW IF EXISTS `v_mostimportantorderscompleted`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_mostimportantorderscompleted` AS SELECT 
 1 AS `customerNumber`,
 1 AS `customerName`,
 1 AS `orderNumber`,
 1 AS `orderDate`,
 1 AS `productCode`,
 1 AS `quantityOrdered`,
 1 AS `priceEach`,
 1 AS `Tot`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_mesianni_attivita`
--

DROP TABLE IF EXISTS `v_mesianni_attivita`;
/*!50001 DROP VIEW IF EXISTS `v_mesianni_attivita`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_mesianni_attivita` AS SELECT 
 1 AS `Anno`,
 1 AS `Mese`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_top5employees`
--

/*!50001 DROP VIEW IF EXISTS `v_top5employees`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_top5employees` AS select `o`.`territory` AS `territory`,`e`.`employeeNumber` AS `employeeNumber`,`e`.`lastName` AS `lastName`,`e`.`firstName` AS `firstName`,`o`.`country` AS `country`,`e`.`email` AS `email`,sum(`p`.`amount`) AS `TotSold` from (((`employees` `e` join `offices` `o` on((`e`.`officeCode` = `o`.`officeCode`))) join `customers` `c` on((`e`.`employeeNumber` = `c`.`salesRepEmployeeNumber`))) join `payments` `p` on((`c`.`customerNumber` = `p`.`customerNumber`))) group by `o`.`territory`,`e`.`employeeNumber` order by `o`.`territory`,`TotSold` desc limit 5 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_sales`
--

/*!50001 DROP VIEW IF EXISTS `v_sales`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_sales` AS select `c`.`customerNumber` AS `customerNumber`,`c`.`salesRepEmployeeNumber` AS `salesRepEmployeeNumber`,`c`.`customerName` AS `customerName`,`o`.`orderNumber` AS `orderNumber`,`o`.`orderDate` AS `orderDate`,`p`.`productCode` AS `productCode`,`d`.`priceEach` AS `priceEach`,`d`.`quantityOrdered` AS `quantityOrdered`,`p`.`buyPrice` AS `buyPrice`,`p`.`productName` AS `productName`,`p`.`productLine` AS `productLine`,(`d`.`priceEach` * `d`.`quantityOrdered`) AS `TotSold`,(`p`.`buyPrice` * `d`.`quantityOrdered`) AS `TotSpent`,((`d`.`priceEach` * `d`.`quantityOrdered`) - (`p`.`buyPrice` * `d`.`quantityOrdered`)) AS `TotEarned` from (((`customers` `c` join `orders` `o` on((`c`.`customerNumber` = `o`.`customerNumber`))) join `orderdetails` `d` on((`d`.`orderNumber` = `o`.`orderNumber`))) join `products` `p` on((`p`.`productCode` = `d`.`productCode`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_totsold_totiva`
--

/*!50001 DROP VIEW IF EXISTS `v_totsold_totiva`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_totsold_totiva` AS select `v_sales`.`TotSold` AS `TotSold`,(`v_sales`.`TotSold` * `params`.`ivaSTD`) AS `TotIVA`,(`v_sales`.`TotSold` / (1 + `params`.`ivaSTD`)) AS `TotNoIVA` from (`v_sales` join `params`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_organigramma`
--

/*!50001 DROP VIEW IF EXISTS `v_organigramma`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_organigramma` AS select `e`.`employeeNumber` AS `employeeNumber`,`e`.`lastName` AS `lastName`,`e`.`firstName` AS `firstName`,`e`.`jobTitle` AS `jobTitle`,`c`.`lastName` AS `lastNameC`,`c`.`firstName` AS `firstNameC`,`c`.`jobTitle` AS `jobTitleC`,`cc`.`lastName` AS `lastNameCC`,`cc`.`firstName` AS `firstNameCC`,`cc`.`jobTitle` AS `jobTitleCC`,`ccc`.`lastName` AS `lastNameCCC`,`ccc`.`firstName` AS `firstNameCCC`,`ccc`.`jobTitle` AS `jobTitleCCC`,`o`.`city` AS `city`,`o`.`country` AS `country`,`o`.`territory` AS `territory`,`o`.`officeCode` AS `officeCode` from ((((`employees` `e` join `offices` `o` on((`o`.`officeCode` = `e`.`officeCode`))) left join `employees` `c` on((`c`.`employeeNumber` = `e`.`reportsTo`))) left join `employees` `cc` on((`cc`.`employeeNumber` = `c`.`reportsTo`))) left join `employees` `ccc` on((`ccc`.`employeeNumber` = `cc`.`reportsTo`))) order by `ccc`.`reportsTo`,`cc`.`reportsTo`,`c`.`reportsTo`,`e`.`reportsTo` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_totricavato`
--

/*!50001 DROP VIEW IF EXISTS `v_totricavato`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_totricavato` AS select sum(`v_sales`.`TotEarned`) AS `TotRicavato`,`v_organigramma`.`lastNameC` AS `lastNameC`,`v_organigramma`.`firstNameC` AS `firstNameC`,`v_organigramma`.`jobTitleC` AS `jobTitleC`,year(`v_sales`.`orderDate`) AS `Anno`,month(`v_sales`.`orderDate`) AS `Mese` from (`v_sales` join `v_organigramma` on((`v_sales`.`salesRepEmployeeNumber` = `v_organigramma`.`employeeNumber`))) group by `v_organigramma`.`lastNameC`,`v_organigramma`.`firstNameC`,`Anno`,`Mese` order by `TotRicavato` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_tipo_customers`
--

/*!50001 DROP VIEW IF EXISTS `v_tipo_customers`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_tipo_customers` AS select `customers`.`customerNumber` AS `customerNumber`,`customers`.`customerName` AS `customerName`,`customers`.`contactLastName` AS `contactLastName`,`customers`.`contactFirstName` AS `contactFirstName`,`customers`.`phone` AS `phone`,`customers`.`addressLine1` AS `addressLine1`,`customers`.`addressLine2` AS `addressLine2`,`customers`.`city` AS `city`,`customers`.`state` AS `state`,`customers`.`postalCode` AS `postalCode`,`customers`.`country` AS `country`,`customers`.`salesRepEmployeeNumber` AS `salesRepEmployeeNumber`,`customers`.`creditLimit` AS `creditLimit`,(case when (`customers`.`creditLimit` < `params`.`credit1`) then `params`.`msg1` when (`customers`.`creditLimit` < `params`.`credit2`) then `params`.`msg2` when (`customers`.`creditLimit` < `params`.`credit3`) then `params`.`msg3` else `params`.`msgover` end) AS `tipo` from (`customers` join `params`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_employeesnumber`
--

/*!50001 DROP VIEW IF EXISTS `v_employeesnumber`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_employeesnumber` AS select `o`.`city` AS `city`,`o`.`country` AS `country`,`o`.`territory` AS `territory`,`o`.`postalCode` AS `postalCode`,count(`e`.`employeeNumber`) AS `EmployeesNumber` from (`offices` `o` join `employees` `e` on((`e`.`officeCode` = `o`.`officeCode`))) group by `o`.`officeCode` order by `o`.`country` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_tot_products_expenses`
--

/*!50001 DROP VIEW IF EXISTS `v_tot_products_expenses`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_tot_products_expenses` AS select `p`.`productLine` AS `productLine`,sum((`p`.`buyPrice` * `p`.`quantityInStock`)) AS `TotExpenses`,max((`p`.`buyPrice` * `p`.`quantityInStock`)) AS `MaxTotExpenses`,min((`p`.`buyPrice` * `p`.`quantityInStock`)) AS `minTotExpenses`,count(`p`.`productCode`) AS `countProducts`,(sum((`p`.`buyPrice` * `p`.`quantityInStock`)) / count(`p`.`productCode`)) AS `MediaGiacenza` from (`products` `p` join `productlines`) group by `p`.`productLine` order by `TotExpenses` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_totstock`
--

/*!50001 DROP VIEW IF EXISTS `v_totstock`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_totstock` AS select sum(`d`.`quantityOrdered`) AS `Tot`,`p`.`productName` AS `ProductName`,`pp`.`quantityInStock` AS `QuantityInStock` from (((`products` `p` join `orderdetails` `d` on((`d`.`productCode` = `p`.`productCode`))) join `products` `pp` on((`d`.`productCode` = `pp`.`productCode`))) join `orders` `o` on((`o`.`orderNumber` = `d`.`orderNumber`))) group by `p`.`productName` order by `Tot` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_mostimportantorderscompleted`
--

/*!50001 DROP VIEW IF EXISTS `v_mostimportantorderscompleted`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_mostimportantorderscompleted` AS select `c`.`customerNumber` AS `customerNumber`,`c`.`customerName` AS `customerName`,`o`.`orderNumber` AS `orderNumber`,`o`.`orderDate` AS `orderDate`,`d`.`productCode` AS `productCode`,`d`.`quantityOrdered` AS `quantityOrdered`,`d`.`priceEach` AS `priceEach`,(`d`.`priceEach` * `d`.`quantityOrdered`) AS `Tot` from ((`customers` `c` join `orders` `o` on((`c`.`customerNumber` = `o`.`customerNumber`))) join `orderdetails` `d` on((`o`.`orderNumber` = `d`.`orderNumber`))) where (`o`.`status` = 'Resolved') order by (`d`.`priceEach` * `d`.`quantityOrdered`) desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_mesianni_attivita`
--

/*!50001 DROP VIEW IF EXISTS `v_mesianni_attivita`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_mesianni_attivita` AS select year(`orders`.`orderDate`) AS `Anno`,month(`orders`.`orderDate`) AS `Mese` from `orders` group by `Anno`,`Mese` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Dumping events for database 'classicmodels'
--

--
-- Dumping routines for database 'classicmodels'
--
/*!50003 DROP PROCEDURE IF EXISTS `deleteorderdetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteorderdetails`(in id_order int, out nr int)
BEGIN
delete from orderdetails where orderNumber = id_order;
select row_count() into nr;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getOffices` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getOffices`(codeParam int)
BEGIN
	select * from offices where officeCode=codeParam;
END ;;
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

-- Dump completed on 2021-02-23 19:41:03
