-- create VIEW `v_totstock` AS
    SELECT 
        SUM(`d`.`quantityOrdered`) AS `Tot`,
        `p`.`productName` AS `ProductName`,
        `pp`.`quantityInStock` AS `QuantityInStock`
        
    FROM
        (((`products` `p`
        JOIN `orderdetails` `d` ON ((`d`.`productCode` = `p`.`productCode`)))
        JOIN `products` `pp` ON ((`d`.`productCode` = `pp`.`productCode`)))
        JOIN `orders` `o` ON ((`o`.`orderNumber` = `d`.`orderNumber`)))
    GROUP BY `p`.`productName`
    ORDER BY `Tot`