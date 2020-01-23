/*
    In a SELECT statement, you need to specify at least:
    
        - the columns that your want to retrieve (column list)
        - the table where those values are stored (FROM clause)
*/

-- Get all information from the PRODUCTS table
SELECT *
FROM products;

-- Specify certain columns for retrieval
SELECT prod_name, price
FROM products;

-- Not many restrictions on what columns can be included in the result set
-- This example demos "column aliasing" using the AS keyword
SELECT prod_name, price, 'test', prod_name, (price/2) AS half_off 
FROM products;

SELECT emp_id, emp_fn, emp_ln, monthly_income, (monthly_income * 1.2) as pay_raise
FROM employees;

/*
    WHERE clauses
*/

SELECT prod_id, prod_name, price
FROM products
WHERE price <= 10;

SELECT *
FROM products
WHERE expiration_date < '01-APR-2019';

SELECT *
FROM products
WHERE
    (
        prod_id < 5
        OR prod_name = 'Amoxicillin'
        AND price > 10
    )
    AND
    (
       price <= 10
       OR expiration_date = DATE '2018-04-30'
    );
    
/*
    DISTINCT keyword
*/
SELECT department_id
FROM employees;

-- eliminates duplicate query results
SELECT DISTINCT department_id
FROM employees;

-- a record is considered to be duplicated if ALL of the values retrieved match
SELECT DISTINCT emp_fn, department_id
FROM employees;

-- The UNIQUE keyword can be used in place of DISTINCT (not recommended)
SELECT UNIQUE department_id
FROM employees;

/*
    ORDER BY clauses
*/

-- Selects all employees in ascending order by their birthdate
SELECT *
FROM employees
ORDER BY birthdate ASC;

-- the ASC keyword is not required when sorting in ascending order
SELECT *
FROM employees
ORDER BY birthdate;

-- Same query, reverse order (descending)
SELECT *
FROM employees
ORDER BY birthdate DESC;

-- ORDER BY with strings (aka VARCHAR2)
SELECT *
FROM employees
ORDER BY emp_fn;

-- we can apply more than one sorting/ordering criteria
SELECT *
FROM employees
ORDER BY department_id DESC, monthly_income;

-- we can use the column positions instead of their names (not recommended)
SELECT *
FROM employees
ORDER BY 6 DESC, 5;

/*
    Scalar functions
    
        Scalar fuctons, aka single-row functions, return a value for 
        every row that is processed in a query. There are four types
        of scalar functions that we should be familiar with:
        
        - Numeric functions
            + ABS()
            + CEIL() and FLOOR()
            + TRUNC() and ROUND()
            
        - Character/Text functions
            + LOWER(), UPPER(), INITCAP()
            + LTRIM(), RTRIM(), TRIM()
            + SUBSTR()
            + LENGTH()
            
        - Date functions
            + ADD_MONTH()
            + MONTHS_BETWEEN()
            + SYSDATE and SYSTIMESTAMP
            
        - Conversion functions
            + TO_CHAR()
            + TO_DATE()
            + TO_NUMBER()
*/

-- using a scalar function (example)
SELECT SUBSTR('test', -1, 3)
FROM DUAL;

/*
    The DUAL table is used with SELECT statements when attempting to
    retrieve values that do not come from a particular table in the DB.
*/
SELECT *
FROM DUAL;

SELECT SYSTIMESTAMP
FROM DUAL;

SELECT SYSDATE
FROM DUAL;

/*
    Aggregate functions
    
        Operations which can be performed on a group of records in order to
        provide a single value/result.
*/

SELECT MIN(price) AS min_price, MAX(price) AS max_price
FROM products;

SELECT MIN(price), MAX(price), SUM(price), AVG(price)
from products;

SELECT *
FROM products;

SELECT COUNT(prod_name)
FROM products;

ALTER TABLE products
ADD alternate_name VARCHAR2(25);

UPDATE products
SET alternate_name = SUBSTR(prod_name, 1, 3)
WHERE prod_id < 4;

-- COUNT provides a count of the number of NON-NULL values in a column
SELECT COUNT(prod_id), COUNT(alternate_name)
FROM products;

/*
    GROUP BY clauses
*/

/*
    Retrieve all employees and group them by their department and then
    apply the COUNT function to each group.
*/
SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id
ORDER BY department_id;

/*
    HAVING clauses
    
        The HAVING clause is used in a similar manner as the WHERE clause. 
        HAVING clauses are used in combination with aggregate functions.
*/

-- Retrieves only departments whose smallest salary is less than 2000 or
-- their highest salary is greater than 4000. The results should be displayed
-- in descending order by the salaries.

SELECT department_id, MIN(monthly_income) AS min_income, MAX(monthly_income) AS max_income
FROM employees
GROUP BY department_id
    HAVING
        MIN(monthly_income) < 2000
        OR
        MAX(monthly_income) > 4000
ORDER BY MIN(monthly_income) DESC;


/*
    Logical Operators
    
    Logical operators are those that are true or false. The return true or false values to combine 
    one or more true or false values.
    
    - AND
        + compares between two Booleans as expression and returns true when both expressions are true.
    
    - OR
        + compares between two Booleans as expression and returns true when one of the expression is true.
    
    - NOT
        + takes a single Boolean as an argument and changes its value from false to true or from true 
        to false.
    
    - IN
        + checks a value within a set of values separated by commas and retrieve the rows from the 
          table which are matching.
    
    - BETWEEN
        + tests an expression against a range. The range consists of a beginning, followed by an AND 
          keyword and an end expression.
    
    - ANY
        + compares a value to each value in a list or results from a query and evaluates to true if the 
          result of an inner query contains at least one row.
    
    - ALL
        + used to select all records of a SELECT statement. It compares a value to every value in a list 
          or results from a query.
        + must be preceded by the comparison operators and evaluates to TRUE if the query returns no rows.
    
    - SOME
        + compare a value to each value in a list or results from a query and evaluate to true if the 
          result of an inner query contains at least one row.
    
    - EXISTS
        + checks the existence of a result of a subquery.
        + tests whether a subquery fetches at least one row
        + when no data is returned then this operator returns 'FALSE'.
*/