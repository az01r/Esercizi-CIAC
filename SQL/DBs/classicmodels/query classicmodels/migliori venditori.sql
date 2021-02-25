-- CREATE view v_top5employees as
    SELECT 
        `o`.`territory` AS `territory`,
        `e`.`employeeNumber` AS `employeeNumber`,
        `e`.`lastName` AS `lastName`,
        `e`.`firstName` AS `firstName`,
        `o`.`country` AS `country`,
        `e`.`email` AS `email`,
        SUM(`p`.`amount`) AS `TotSold`
    FROM
        (((`employees` `e`
        JOIN `offices` `o` ON ((`e`.`officeCode` = `o`.`officeCode`)))
        JOIN `customers` `c` ON ((`e`.`employeeNumber` = `c`.`salesRepEmployeeNumber`)))
        JOIN `payments` `p` ON ((`c`.`customerNumber` = `p`.`customerNumber`)))
    GROUP BY `o`.`territory` , `e`.`employeeNumber`
    ORDER BY `o`.`territory` , `TotSold` DESC
    LIMIT 5