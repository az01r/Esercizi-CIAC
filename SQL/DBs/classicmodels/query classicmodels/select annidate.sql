SELECT * FROM customers c where customerNumber in (
	select customerNumber from orders o where o.status="Cancelled"
    -- IMPORTANTE la selct interna deve ritornare un solo campo
)