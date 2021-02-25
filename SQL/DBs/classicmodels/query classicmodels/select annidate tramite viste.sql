SELECT * FROM customers where salesRepEmployeeNumber in (
	select v_top5employees.employeeNumber from v_top5employees
)
-- trova i clienti che hanno acquistato dai top 5 venditori