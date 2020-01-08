/*
    In a SELECT statement, you need to specify the columns that you want to retrieve (columns list),
    and the table where those values are stored (FROM clause)
*/

--Get all information from PRODUCTS table
SELECT *
FROM products;

--Specify certain columns for retrieval
SELECT prod_name, price
FROM products;

--Not may restrictions on what columns cvan be included in the result set
--This demos "column aliasing" using the AS keyword
SELECT prod_name, price, 'test', prod_name, (price/2) AS half_off --COLUMN ALIASING
FROM products;

SELECT emp_id, emp_fn, emp_ln, montly_income, (monthly_income*1.2) as pay_raise
FROM employees;

/*
    WHERE clauses
*/
SELECT prod_id, prod_name, price 
FROM products
WHERE price < 10;

SELECT *
FROM products
WHERE expiration_date < '01-APR-2019';

SELECT *
FROM products
WHERE (
prod_id < 5 
OR prod_name = 'Amoxicilin'
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

--elimaates duplicate query results
SELECT DISTINCT department_id
FROM employees;

--a record is considered to be duplicated if ALL of the values retrieved match
SELECT DISTINCT emp_fn, department_id
FROM employees;

--bad practice
SELECT UNIQUE department_id
FROM employees;

/*
    ORDER BY clause
*/
--SELECT all employees in ascending order by their birthdate
SELECT *
FROM employees
ORDER BY birthdate ASC;
--the ASC keyword is not required when sorting in ascending order

--Same query in descending order
SELECT *
FROM employees
ORDER BY birthdate DESC;

--ORDER BY with strings
SELECT *
FROM employees
ORDER BY emp_fn;

--we can apply more than one sorting/ordering criteria
SELECT * 
FROM employees
ORDER BY department_id DESC, monthly_income;

--WE can use the column positions or indices instead of their names (nto recommended)
SELECT *
FROM employees
ORDER BY 6 DESC, 5;

/*
    Scalar functions
        Scalar functions, also known as single row functions, return a calue for 
        every row that is processed in a query.  There are four types of
        scalar functions we should be familiar with
            
            Numeric functions
                ABS()
                CEIL() and FLOOR()
                TRUNC()
                ROUND()
                
            Character/Text functions
                LOWER(), UPPER(), INITCAP()
                LTRIM(), RTRIM(), TRIM()
                SUBSTR()
                LENGTH()
                
            Dater functions
                ADD_MONTH()
                MONTHS_BETWEEN()
                SYSDATE()
                SYSTIMESTAMP()
                
            Conversion functions
                TO_CHAR()
                TO_DATE()
                TO_NUMBER()
                
*/

/*
    Aggregate functions
        Operations which can be performed on a gtroup of records in order to procide a single value/result.
*/

SELECT MIN(price) AS minimum_price, MAX(price) AS max_price
FROM products;

SELECT MIN(price), MAX(price), SUM(price), AVG(price)
FROM products;

SELECT COUNT(prod_name)
FROM products;

ALTER TABLE products
ADD alternate_name VARCHAR(25);

UPDATE products
SET alternate_name = SUBSTR(prod_name, 1, 3)
WHERE prod_id < 4;

--COUNT provides a count of the number of non-null values in a column
SELECT COUNT(prod_id), COUNT (alternate_name)
FROM products;

/*
    GROUP BY clause
*/

/*
    Retrieve all the rows in all employees and group them by their dept_id
    and then I will apply the COUNT func to each group
*/
SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id
ORDER BY department_id;

/*
  HAVING clause
    Used in a similar manner as the WHERE clause. HAVING clauses are used in 
    combination with aggregate functions.  
*/
--Retrieves only 
SELECT department_id, MIN(monthly_income) AS min_income, MAX(monthly_income) AS max_income
from employees
group by department_id
    HAVING
        MIN(monthly_income) < 2000
        OR
        MAX(monthly_income) > 5000
ORDER BY department_id DESC;

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