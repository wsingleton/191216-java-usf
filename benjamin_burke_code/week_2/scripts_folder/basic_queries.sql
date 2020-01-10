/*
    In a SELECT statement, you need to speify at least:
    
    -the columns that your want to retreive (column list)
    -the table where those values are stored (FROM clause)
*/

--Get all infomration from the PRODUCT TABLE
SELECT *
FROM products;

--specifify certain columns from retreive
SELECT prod_name, price
FROM products;

SELECT prod_name, price, 'test', prod_name, (price/2) AS half_off
FROM products;

SELECT emp_id, emp_fn, emp_ln, monthly_income, (monthly_income * 1.2) as pay_raises
FROM employees;

SELECT prod_id, prod_name, price
FROM products
WHERE price<=10;

SELECT *
FROM products
WHERE expiration_date< '01-APR-2019';

SELECT * 
FROM products
WHERE
    (
    prod_id <5
    OR prod_name = 'Amoxicillin'
    AND price >10
    )
    AND
    (
    price <=10
    OR expiration_date = DATE '2018-04-30'
    );
    
    /*
    DISTINCT keyword
    */
    SELECT department_id
    FROM employees;
    
    SELECT DISTINCT department_id
    FROM employees;
    
    SELECT DISTINCT emp_fn, department_id
    FROM employees;
    
    --The UNIQUE keyword can be used in place of DISTINCT (not recommended)
    SELECT UNIQUE department_id
    FROM employees;
    
    /*
    ORDER by clauses
    */
    
    --Selects all employees in ascending order by theri birthdate
    SELECT *
    FROM employees 
    ORDER BY birthdate ASC;
    
    SELECT *
    FROM employees
    ORDER BY birthdate DESC;
    
    SELECT *
    FROM employees
    ORDER BY emp_fn;
    
    SELECT *
    FROM employees
    ORDER BY department_id DESC, monthly_income;
    
    SELECT *
    FROM employees
    ORDER BY 6 DESC, 5;
    
    /*
    Scalar functions
    
        scalar functions, aka single-row functions, retun a value for
        every row that is processed in a query. There are four types
        of scalar functions that we should be familiar with:
        
        -Numeric Functions
            +ABS()
            +CEIL() and FLOOR()
            +TRUNK() and ROUND()
            
        
        -character/text functions
            +LOWER(), UPPER(), INTICAP()
            +LTRIM(), RTRIM(), TRIM()
            +SUBSTR()
            +LENGTH()
        
        -date functions
            +ADD_MONTH()
            +MONTHS_BETWEEN()
            +SYSDATE_ and SUSTIMESTAMP
        
            
        -conversion functions
            +TO_CHAR()
            +TO_DATE()
            +TO_NUMBER()
        
        
        SELECT SUBSTR('test', -1, 3)
        FROM DUAL;
        
        SELECT SYSDATESTAMP
        FROM DAUL;
            
SELECT SYSDATE
FROM DAUL;
  
    */
    
SELECT MIN(price) AS min_price, MAX(price) AS max_price
FROM products;

SELECT MIN(price), MAX(price), SUM(price), AVG(price)
from products;

SELECT COUNT(prod_name)
FROM products;

ALTER TABLE products
ADD alternate_name VARCHAR2(25);

UPDATE products
SET alternate_name = SUBSTR(prod_name, 1,3)
WHERE prod_id<4;

SELECT COUNT(prod_id), COUNT(alternate_name)
FROM products;

/*
    GROUP BY clauses are 
*/

/*
    Retreive all employess and group them by their department and then
    apply the count function to each group;
*/

SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id
ORDER BY department_id;

/*
    Having clauses
    
        The HAVING clause is used in a similar manner as the WHERE cluase;
        HAVING clauses are used in combintation with aggregate function
        
*/

-- Retrieves only departments whose smallest salary is less than 2000 or
-- their highest salary is greater than 4000. The results should be displayed
-- in descending order by the salaries.


SELECT department_id, MIN(monthly_income) AS min_income, MAX(monthly_income) AS max_income
FROM employees
GROUP BY department_id
    HAVING
        MIN(monthly_income)<2000
        OR
        MAX(monthly_income)>4000
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
