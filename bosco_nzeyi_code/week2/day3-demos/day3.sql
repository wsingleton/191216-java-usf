/*
        - SET
       
       
        - INTERSECT
        
        
        - UNION
     
     Union is set operator that is used to combine the result sets of two or more queries. It also will remove any duplicate 
     results found in those queries. 
     
     Rules for unioning query results set:
     *both query results sets must have the same number of columns
     *the datatypes of each column must be compatible with their counterpart.
        

*/

--- this does not work
SELECT *
FROM departments
UNION 
SELECT department_id
FROM employees;

---- this work but duplicates are removed
SELECT dept_id
FROM departments
UNION 
SELECT department_id
FROM employees;

SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 2500;


/*
    INTERSECT 

Intersect returns only the rows which are returned by both queries. So, in order for the record to be included in the final 
results set, it must be present in the individual result sets of query 1 and 2. 

Also, after calculating the final result set (intersection) from the component queries, duplicate records are removed. 
*/

SELECT dept_id
FROM departments
WHERE monthly_budget > 15000
INTERSECT
SELECT department_id
FROM employees
WHERE employees.monthly_income > 2000;

/*
    Subqueries
    
        A subqueries is a SELECT statememt that is included, 
        or nested, within another SQL DML statment and are always included within paranthesis.
*/
SELECT *
FROM employees
WHERE monthly_income = 
(
    SELECT MAX(monthly_income)
    FROM employees

);

UPDATE employees
SET monthly_income = 10000
WHERE emp_id = 10;

--- INNER JOINS
SELECT emp_id, emp_fn, emp_ln, employees.department_id, departments.dept_name
FROM employees
JOIN departments
ON employees.department_id = dept_id;


SELECT emp_id, emp_fn, emp_ln
FROM employees
JOIN departments
USING (dept_id);


---- self join
SELECT e.emp_fn, e.emp_ln, e.email,
em.emp_ln ||' ' || em.emp_fn AS fullname
FROM employees e
JOIN employees em
ON e.emp_id = em.emp_id;





















