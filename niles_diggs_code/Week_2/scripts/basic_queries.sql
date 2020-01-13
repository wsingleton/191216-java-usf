/*
 *  In a select statment, you need to specify at least:
 * 		- the columns that you want to retreive (column list)
 * 		- the table where those values are stored (from clause)
 * 
 * 
 * 
 */


-- GET ALL infor FROM the products TABLE

SELECT *
FROM PRODUCTS;

-- specify certain columns FOR retreival

SELECT prod_name, price
FROM PRODUCTS;

-- NOT many restrictions ON what columns can be included IN the RESULT SET
-- this example demos "column aliasing" using the AS keyword

SELECT prod_name, price, 'test', prod_name, (price/2) AS half_off
FROM PRODUCTS;

SELECT emp_id, emp_fn, emp_ln, monthly_income, (monthly_income * 1.2) AS pay_raise
FROM EMPLOYEES;


/*
		where clauses
*/

SELECT prod_id, prod_name, price
FROM PRODUCTS
WHERE price <= 10;

SELECT *
FROM PRODUCTS
WHERE expiration_date < '01-APR-2019';

SELECT *
FROM PRODUCTS
WHERE
	(
		prod_id < 5
		OR PROD_NAME = 'Amoxicillin'
		AND price > 10
		)
		AND
		(
			price <= 10
			OR EXPIRATION_DATE = DATE '2018-04-30')
		);
		
	
/*
	DISTINCT keyword
*/
	
SELECT department_id
FROM EMPLOYEES;

-- eliminates deuplicate query results
SELECT DISTINCT department_id
FROM EMPLOYEES;

-- a record is considered to be duplicated if all of the values retreived match
SELECT emp_fn, department_id
FROM EMPLOYEES;

--the UNIQUE keyword can be used IN place OF DISTINCT (not recommended)
SELECT UNIQUE
FROM EMPLOYEES;

/*
	ORDER BY clause
*/

-- Selects ALL employees BY ascending ORDER BY their birthdate

SELECT *
FROM EMPLOYEES
ORDER BY BIRTHDATE ASC;
-- the asc keyword is not required when sorting in ascending order

-- same query in reverse order, using dsc
SELECT *
FROM EMPLOYEES
ORDER BY BIRTHDATE DESC;

-- order by with strings (aka varchar2)
SELECT *
FROM EMPLOYEES
ORDER BY EMP_FN;

-- we can apply more than one sorting/ordering criteria

SELECT *
FROM EMPLOYEES
ORDER BY DEPARTMENT_ID DESC, MONTHLY_INCOME;

-- we cna use the column positions instead of their names (not recommended)

SELECT *
FROM EMPLOYEES
ORDER BY 6 DESC, 5;

/*
 * 
 * Scalar functions
 * 			
 * 
 * 		Scalar functions, aka single-row function, return a  value for every row
 * 
 * 
 * 
 * 		-Numeric functions
 * 			ABS()
 * 			CEIL() AND FLOOR()
 * 			TRUNC() AND ROUND()
 * 
 * 		-Character/text functions
 * 			LOWER(), UPPER(), INITCAP()
 * 			LTRIM(), RTRIM(), TRIM()
 * 			SUBSTR()
 * 			LNEGTH()
 * 
 * 		-Date functions
 * 			ADD_MONTH()
 * 			MONTHS_BETWEEN()
 * 			SYSDATE and SYSTIMESTAMP
 * 
 * 		-Conversion functions
			TO_CHAR()
			TO_DATE()
			TO_NUMBER()
*/


/*
 * 		Aggregate funcitons
 * 
 * 			Operations which can be performed on a group of records in order to provide a single value/result
 */

SELECT MIN(price) AS min_price, MAX(price) AS max_price
FROM PRODUCTS

SELECT MIN(price), MAX(price), SUM(price), AVG(price)
FROM PRODUCTS

SELECT COUNT(prod_name)
FROM PRODUCTS;

ALTER TABLE products
ADD alternate_name VARCHAR2(25);

UPDATE PRODUCTS
SET alternate_name = SUBSTR(prod_name, 1, 3)
WHERE PROD_ID < 4;

SELECT COUNT(prod_id), COUNT(alternate_name)
FROM PRODUCTS;

/*
 * 		GROUP BY
 */

-- Retreive all the employees and group them by their department and then apply the count to eact group

SELECT department_id, COUNT(*)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID;
ORDER BY department_id;

/*
 * 		HAVING clauses
 * 
 * 			the HAVING clause is used in a similar mannter as the where clause.
 * 			HAVING clauses are used in combination with aggregate functions.
 */

-- retreive only departments whose smallest salary is less than 2000 or their highest salary is greater than 4000. results displayed dsc by sal

SELECT department_id, MIN(MONTHLY_INCOME) AS min_income, MAX(MONTHLY_INCOME) AS max_income
FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID
	HAVING
		MIN(MONTHLY_INCOME) < 2000
		OR
		MAX(MONTHLY_INCOME) > 4000
ORDER BY MIN(MONTHLY_INCOME) DESC;

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
