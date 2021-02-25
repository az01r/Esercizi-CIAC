-- create view v_tot_products_expenses as
select p.productLine,
sum(p.buyPrice*p.quantityInStock)as TotExpenses,

max(p.buyPrice*p.quantityInStock)as MaxTotExpenses,

min(p.buyPrice*p.quantityInStock)as minTotExpenses,

count(p.productCode)as countProducts,
sum(p.buyPrice*p.quantityInStock)/count(p.productCode)as MediaGiacenza

from products p
join productlines
group by p.productLine
order by TotExpenses desc