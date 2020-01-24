/*
        SELECT statements, you need to specifiy at least:
        
        - the columns that your want to retrieve (column list)
        - the table where those values are stored (FROM  clause)

*/

SELECT *
FROM products;


SELECT prod_name, price
FROM products;


SELECT prod_id, prod_name, price
FROM products
WHERE price <= 10;

SELECT *
FROM products 
WHERE expriation_date < '01-APR-2019';


/*

    DISTICT keyword
*/

SELECT department_id
FROM employee;




SELECT DISTINCT department_id
FROM employees;


SELECT UNIQUE department_id
FROM employees;

/*
    ORDER BY clauses
*/



SELECT *
FROM employees
ORDER BY birthday ASC;

SELECT *
FROM employees
ORDER BY birthday DESC;

SELECT *
FROM employees
ORDER BY department_id DESC, monthly_income;

SELECT *
FROM DUAL;


SELECT 