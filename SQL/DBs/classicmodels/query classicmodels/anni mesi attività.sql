-- create view v_mesianni_attivita as
select year(orderDate) as Anno, month(orderDate) as Mese
from orders
group by Anno,Mese