-- create view v_mostImportantOrdersCompleted as
select c.customerNumber,c.customerName,o.orderNumber,o.orderDate,d.productCode,d.quantityOrdered,d.priceEach,d.priceEach*d.quantityOrdered as Tot
from customers c
join orders o on c.customerNumber=o.customerNumber
join orderdetails d on o.orderNumber=d.orderNumber
where o.status='Resolved'
order by Tot desc