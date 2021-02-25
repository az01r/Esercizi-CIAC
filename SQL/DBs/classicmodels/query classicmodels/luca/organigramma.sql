-- create view v_organigramma as
Select
    e.employeeNumber,
    e.lastName,
    e.firstName,
    e.jobTitle,
    c.lastName As lastNameC,
    c.firstName As firstNameC,
    c.jobTitle As jobTitleC,
    cc.lastName As lastNameCC,
    cc.firstName As firstNameCC,
    cc.jobTitle As jobTitleCC,
    ccc.lastName As lastNameCCC,
    ccc.firstName As firstNameCCC,
    ccc.jobTitle As jobTitleCCC,
    o.city,
    o.country,
    o.territory,
    o.officeCode
From
    classicmodels.employees e Inner Join
    classicmodels.offices o On o.officeCode = e.officeCode Left Join
    classicmodels.employees c On c.employeeNumber = e.reportsTo Left Join
    classicmodels.employees cc On cc.employeeNumber = c.reportsTo Left Join
    classicmodels.employees ccc On ccc.employeeNumber = cc.reportsTo
order by ccc.reportsTo,cc.reportsTo,c.reportsTo,e.reportsTo