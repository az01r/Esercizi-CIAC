-- create view v_tipo_customers as
select customers.*,
-- if(creditlimit>100000,"GOLD","STD") as tipo,
case
	when creditlimit<credit1 then msg1
    when creditlimit<credit2 then msg2
    when creditlimit<credit3 then msg3
    else msgover
end as tipo
from classicmodels.customers,params;