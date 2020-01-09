/*

in a sellect statement , you need to specify at least :
- the colums that you want to retieve ( colum list)
the table where those values are stored 
*/

select * from products;

select prod_name, price from products;

-- not many retriction on what colum be includeted 

select prod_name, price, (price/2) as half_price , prod_name from products;

select emp_fn, emp_ln, emp_id, monthly_income, (monthly_income/2) from employees;

-- where clause

select prod_id, prod_name, price
from products where price <= 10;

SELECT * 
from products
WHERE expiration_date< '01-APR-2019';        

select * FROM products
where (
prod_id < 15 
or prod_name = 'Amoxcillin' and price > 10
)
and (price <=10 or expiration_date = Date '2018-04-30');    


-- distind keyword

select department_id from employees;

--elliminate dup 

select DISTINCT department_id from employees;

-- a recode considerd to be dup if all of the calue retrive match 

select DISTINCT emp_fn, department_id from employees;

-- the unique keyword can be used in place of distinct (not recommend )
select UNIQUE department_id from employees;


-- order by clause 

select * 
from employees
ORDER by birthdate ASC;

-- the asc keyword is not require when sorting in assending order 
select * 
from employees
ORDER by birthdate;

-- same query , reverst order (descending)

select * 
from employees
ORDER by birthdate DESC;


-- orde by string 

select * 
from employees
ORDER by emp_fn DESC;

-- we can apply more than one sorting/orderinf criteria 

select * 
from employees
ORDER by department_id desc, monthly_income;

-- we can use colum positions instead od their name (not recommend)

select * 
from employees
ORDER by 6 desc, 5;

/*
Scalar functions 
    also know as single row dunctions, it return a value for every row that is processed in a query, threr are 
    four typr of scalar dunction that we should be famulliar with 
    
    - numeric functions 
        + abs()
        + Cell() and floor()
        + Trumc() and round()
    - character/text functions 
        +LOWER(), UPPER(), INICAP() 
        +LTRIM(), RTRIM(),TRIM()
        +SUBSTR()
        +LENGTH()
        
    -date_ functions 
        +ADD MONTH()
        +MONTH_BETWEEN()
        +SYSDATE() and SYSTIMESTAMP()
    - conversion function 
        + TO_CHAR()
        + TO_DATE()
        + TO_NUMBER()
        
*/


-- using a scalar function exp

select SUBSTR('test',-1,3)
from dual;


/*
 the DUAL table is dumb table 
*/
select * from dual;


select SYSTIMESTAMP AT TIME ZONE 'UTC' from dual;

/*
Aggregate function 
    operation which can be performed on a group of record in order to provide a single calue/result .
*/

select min(price) as min_price, Max(price)as max_price, sum(price), avg(price) from products;

select count(prod_name) from products;

select * from products;


ALTER table products 
add alternate_name VARCHAR2(25);

UPDATE products 
set alternate_name = SUBSTR(prod_name, 1, 3)
where prod_id<5;


-- count provide a count of the number of non null value in a colum 
select count(prod_id), count(alternate_name) from products;

/*
GROUP BY
*/

-- retrive all employee and group them by their department and then allpyy the count function to each group 

select department_id, count (*)
from employees
group by department_id;

select department_id, count (*)
from employees
group by department_id
order by department_id;

/*
HAVING clause 
     the having clause os used in  a similat maner as the where clause , haceing clause are used to combiation with aggregate funtions
*/

-- Retrieves only departments whose smallest salary is less than 2000 or
-- their highest salary is greater than 4000. The results should be displayed
-- in descending order by the salaries.

select department_id , min(monthly_income), max(monthly_income)
from employees 
group by department_id
having min(Monthly_income) < 2000 or max(monthly_income)> 4000
order by min(monthly_income) desc ;


select department_id , min(monthly_income), max(monthly_income)
from employees
group by department_id; 



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






