/*
    Union
    
        UNION is a set operator that is used to combine the result sets of
        two or more querires. It will remove any duplicate results found
        in those queries.
        
        Rules for unioning query result sets:
            +Both query result sets must have the same number of columns
            +The datatypes of each column must be compatible with their counterpart. 
            
*/

--Does not work (# of columns in each result set does not match)
SELECT *
FROM departments
UNION
SELECT department_id
FROM employees;

--works, but note that duplicate records are removed
SELECT dept_id
FROM departments 
UNION
SELECT department_id
FROM employees;

--works but the final result set is a bit confusing
SELECT dept_id, dept_name
FROM departments
UNION
SELECT emp_id, emp_ln
FROM employees;

/*
    minus
    
        
        Minus works by retunring the results that are found in rs#1 that are
        not found in rs#2.
        
*/

SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 2500
MINUS SELECT dept_id 
FROM departments
WHERE monthly_budget>15000;

SELECT dept_id
FROM departments
WHERE monthly_budget >15000
MINUS 
SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 2500;

/*
    
*/

SELECT dept_id
FROM departments
WHERE montly_budget >15000
INTERSECT
SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 2500;