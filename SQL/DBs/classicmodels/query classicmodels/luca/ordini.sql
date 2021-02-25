-- customer -> ordine -> dettagliOrdine -> prodotto
-- create view v_sales as
SELECT c.customerNumber,c.salesRepEmployeeNumber,customerName,o.orderNumber,orderDate,p.productCode,priceEach,quantityOrdered,buyPrice,productName,productLine,
priceEach*quantityOrdered as TotSold,buyPrice*quantityOrdered as TotSpent,priceEach*quantityOrdered-buyPrice*quantityOrdered as TotEarned
FROM classicmodels.customers c
inner join orders o on c.customerNumber = o.customerNumber
inner join orderdetails d on d.orderNumber=o.orderNumber
inner join products p on p.productCode=d.productCode
