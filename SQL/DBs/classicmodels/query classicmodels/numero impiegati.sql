create view v_employeesNumber as
select
	o.city,o.country,o.territory,o.postalCode,count(e.employeeNumber) as EmployeesNumber
    from offices o
    join employees e on e.officeCode=o.officeCode
    group by o.officeCode
    order by country asc