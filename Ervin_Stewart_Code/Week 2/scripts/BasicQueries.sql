/*
in a select statement you need to specify the following:
-the columns you want to retrieve(column list)
-the table where those values are stored (FROM clause)
*/

-- get all information from the products table
SELECT *
FROM products;

--specifiy certaim colums for retrieval
SELECT prod_name,price
FROM products;

-- not many restrictions on what colums can be inclucded in the result set
SELECT prod_name, price, 'test', prod_name, (price/2) AS half_off
FROM products;

SELECT emp_id, emp_fn, emp_ln, monthly_income, (monthly_income *1.2) as pay_raise
FROM employees;

SELECT prod_id, prod_name,price
from products
where price<= 10;

Select*
from products
where expiration_date < '01-APR-2019';

/*
Distinct keyword
*/

SELECT department_id
FRom employees;
 --eliminates duplicate query results
Select distinct department_id
from employees;
-- a record is considered to be duplicated if all of the values retrieved match

--the unique keyword can be used in-place of distinct (not recommended)

/*
Order BY clause
*/
--select all employees in ascending order by their birthdates
Select *
From employees
Order by birthdate asc;
--the ASC keyword is not required when sorting in ascending order
select *
From employees
Order by birthdate;
-- descending
Select *
From employees
Order by birthdate desc;
--ORDER BY with string (varchar2)
select *
From employees
Order by emp_fn;

--we can apply more than one sorting/ordring criteria
select *
From employees
Order by department_id DEsc, monthly_income;
-- can also sort by column position but not recommended
/*
Scalar functions 

numeric functions 
+ABS()
+CEIL() and FLOOR()
+TRUNC() and ROUND()

-Character/Text functions
+LOWER(), UPPER(), INITCAP()
+LTRIM(),RTRIM(), TRIM()
+SUBSTR()
+Length()

-Date function
+ADD_MONTH()
+MONTHS_BETWEEN()
+SYSDATE and SYSTEMSTAMP

-conversion function
+TO_CHAR()
+TO_DATES()
+TO_NUMBER()
*/
/*
AGGREGATE FUNCTIONS 

        operations which can be performed on a group of records in order to 
        provide a single value/result.
*/
select min (price) as min_price, max (price) as max_price
from products;

Alter table products
add alternate_name varchar2(25);

update products
set alternate_name = SUBSTR(prod_name, 1,3)
where prod_id <4;
--COUNT provides a count of the number of NON-NULL values in s colum

select department_id, min(monthly_income) as min_income,max(monthly_income) as max_income 
from employees
where (monthly_income <2000) or (monthly_income>4000)
order by monthly_income desc;