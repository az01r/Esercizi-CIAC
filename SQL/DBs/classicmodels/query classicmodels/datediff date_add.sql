select orderNumber, orderDate,shippedDate,
datediff(shippedDate,orderDate)as diff,
date_add(orderDate,interval 120 DAY)as 120gg
from classicmodels.orders;