-- create view v_TotRicavato as
select sum(totEarned) as TotRicavato, lastNameC,firstNameC,jobTitleC, year(orderDate) as Anno,month(orderDate) as Mese
from classicmodels.v_sales 
join v_organigramma 
on salesRepEmployeeNumber=employeeNumber
group by lastNameC,firstNameC,anno,mese
order by TotRicavato desc