/*
SELECT
In select statement, you need to specify at least the table you are querring from and a column. 
*/

-- general SELECT statement
SELECT *
FROM products;

-- specifying certain columns for retrieval
SELECT prod_name, price
FROM products;

-- you can alias column using "as" keyword and perform calculations as well as adding new columns and data. 
SELECT  prod_name, price, 'test', prod_name, price/2 AS half_off
FROM products;

SELECT emp_ln, emp_fn, monthly_income, 'raise', (monthly_income * 1.25) AS raised_salary
FROM employees;

-- we can do conditional statements for accessing data in the database
SELECT *
FROM products 
WHERE
(
prod_id < 5 
AND price > 10
);

-- eliminates duplicates
SELECT DISTINCT price
FROM products;

-- we can order data. It's Ascending by default
SELECT *
FROM employees
ORDER BY birthday;

SELECT *
FROM employees
ORDER BY birthday DESC;

-- ORDER BY STRINGS (varchar2)
SELECT *
FROM employees
ORDER BY emp_fn;

-- we can apply more than 1 sorting criteria
SELECT *
FROM employees
ORDER BY birthday DESC, emp_fn DESC;

/*

SCALAR FUNCTIONS

Scalar functions, single row functiomns, return a value fot every row that is processed in a query. there are four types opf scalar
functions that we should be familiar with: 

- Numeric function: 
ABS()
CELL() AND FLOOR()
TRUNC() AND ROUND()

- Character / text function
LOWER(), UPPER(), INTCAP(), 
LTRIM(), RTRIM(), TRIM(), SUBSTR(), LENGTH()

- date functions

ADD_MONTH(),
MONTH_BETWEEN,
SYSDATAE and SYSTIMESTAMP

- conversion functions
TO_CHAR()
TO_DATE()
TO_NUMBER


// DUAL table is a dummy table provided by Oracle. 
*/

-- Dummy dual table provided by Oracle by default.
SELECT *
FROM dual;

SELECT SYSDATE
FROM employees;

/*
Aggregate functions 

    operations which can be perdomred o a group of records in irder ot provide a sinlge value/ result.

*/

SELECT MIN (price), MAX(price), SUM(price), AVG(price)
FROM products;

SELECT COUNT(prod_id)
FROM products;

-- ALTER TABLE
ALTER TABLE products
ADD alternate_name VARCHAR2(50);

SELECT * FROM products;

-- UPDATE THE TABLE
UPDATE products
SET alternate_name = SUBSTR(prod_name, 1, 3)
WHERE prod_id < 4;

/*
HAVING CLAUSES
    Having clause is used in a similar manner as the wehere clause.
    Having claues are used in comnbination with aggregate functions. 

*/

-- Retrieves only departments whose smallest salary is less than 2000 or
-- their highest salary is greater than 4000. The results should be displayed
-- in descending order by the salaries.

SELECT *
FROM employees;

SELECT department_id, MIN(monthly_income) AS min_income, MAX(monthly_income) AS max_income
FROM employees
GROUP BY department_id
HAVING
MIN(monthly_income) < 2000
OR MAX (monthly_income) > 4000;




