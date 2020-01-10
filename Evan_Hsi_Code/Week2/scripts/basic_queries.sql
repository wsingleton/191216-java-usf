/*
    
    In a SELECT statement, you need to specify at least:
    
        - the columns that you want to retrieve (column list)
        - the table where those values are stored (FROM clause)
    
*/

-- Get all information from the PRODUCTS table
SELECT * FROM products;

--Specify certain columns for retrieval
SELECT prod_name, price FROM products;

-- Not many restrictions on what columns can be included in the result set
SELECT prod_name, price, 'test', prod_name, (price/2) AS half_off -- column aliasing
FROM products;

SELECT emp_id, emp_fn, emp_ln, monthly_income, (monthly_income * 1.2) as pay_raise from employees;

/*

    WHERE clauses
    
*/

select prod_id, prod_name, price from products where price <= 10;

select * from products where expiration_date < '01-APR-2019';





/*

    DISTINCT keyword

*/

SELECT DISTINCT department_id FROM employees;

-- A record is considered to be duplicated if ALL of the retrieved values match

SELECT DISTINCT emp_fn, department_id FROM employees;

-- This works, but since UNIQUE is a constraint keyword, probably better not

SELECT UNIQUE department_id FROM employees;

/*

    ORDER BY clauses

*/

-- Selects all employees in ascending order by their birthdate

SELECT * FROM employees ORDER BY birthdate ASC;
-- ASC is implicit

SELECT * FROM employees ORDER BY birthdate DESC;

SELECT * FROM employees ORDER BY emp_fn;

SELECT * FROM employees ORDER BY department_id DESC, monthly_income;

-- We can use the column positions (indicies) instead of their names (not recommended)

SELECT * FROM employees ORDER BY 6 DESC, 5;

/*

    Scalar functions, aka single-row functions, return a value for every row that is processed in a query.
    There are 4 categories of scalar functions that we should be familiar with:
    
    - Numeric functions
        + ABS()
        + CEIL(), FLOOR()
        + TRUNC(), ROUND()
    
    
    - Character/Text functions
        + LOWER(), UPPER(), INITCAP()
        + LTRIM(), RTRIM(), TRIM()
        + SUBSTR()
        + LENGTH()
        
    
    - Date functions
        + ADD_MONTH()
        + MONTHS_BETWEEN()
        + SYSDATE
        + SYSTIMESTAMP
    
    
    - Conversion function
        + TO-CHAR()
        + TO-DATE()
        + TO_NUMBER()

*/

SELECT SUBSTR('test', 1, 3) FROM DUAL;

SELECT SYSTIMESTAMP FROM DUAL;

/*

    Aggregate functions
    
        Operations which can be performed on a group of records in order to provie a single value/result.

*/

SELECT MIN(price) AS min_price, MAX(price) AS max_price FROM products;

SELECT MIN(price), MAX(price), SUM(price), AVG(price) FROM products;

SELECT * FROM products;

ALTER TABLE products ADD alternate_name VARCHAR2(25);

UPDATE products SET alternate_name = SUBSTR(prod_name, 1, 3) WHERE prod_id < 4;

SELECT COUNT(prod_id), COUNT(alternate_name) FROM products;

/* 

    GROUP BY clauses
    
        retrieve all employees and group them by their department and then apply the COUNT function to each group.

*/

SELECT department_id, COUNT(*) FROM employees GROUP BY department_id ORDER BY department_id;


/*

    HAVING clauses
    
        The HAVING clause is used in a similar manner as the WHERE clause.
        HAVING clauses are used in combination with aggregate functions.

*/

-- Retrieve only departments whos smallest salary is less than 2000 or their highest salary is greater than 4000. 
-- The results should be displayed in descending order by the salaries

--SELECT department_id;

SELECT MIN(monthly_income), MAX(monthly_income) FROM employees;

SELECT department_ID from employees GROUP BY department_id HAVING MIN(monthly_income) < 2000 OR MAX(monthly_income) > 4000;

SELECT department_ID, MIN(monthly_income) AS mincome, MAX(monthly_income) AS max_income from employees
GROUP BY department_id
HAVING 
    MIN(monthly_income) < 2000 
    OR 
    MAX(monthly_income) > 4000
ORDER BY MIN(monthly_income) DESC;





