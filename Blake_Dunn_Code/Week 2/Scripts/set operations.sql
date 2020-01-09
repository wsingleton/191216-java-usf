/*
    SET Operations
    
        - UNION
        - UNION ALL
        - MINUS
        - INTERSECT
*/

/*
    UNION
    
        UNION is a set operatio that is used to combine the result sets of 
        two or more queries. It also will remove any duplicate results found
        in those queries
        
        Rules for union-ing query result sets:
            + Both query result sets must have the same number of columns
            + The datatypes of each column must be compatiable with their counterpart
*/

-- Does not work!! (# of columns in each result set does not match 


-- Works, bt note that duplicate records are removed
SELECT dept_id
FROM departments
UNION
SELECT department_id
FROM employees;

-- Works but the final result set is a bit confusing (last names are under dept_name
SELECT emp_id, emp_ln
FROM employees
UNION
SELECT dept_id, dept_name
FROM departments;

-- UNION ALL preserves diplicate records!!
SELECT dept_id
FROM departments
UNION ALL
SELECT department_id
FROM employees;

/*
    MINUS
    
        MINUS works by returning the results that are found in RS#1 that are
        not found in RS#2
*/

-- Returns '2'
SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 2500
MINUS
SELECT dept_id
FROM departments
WHERE monthly_budget > 15000;

SELECT dept_id
FROM departments
WHERE monthly_budget > 15000
MINUS
SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 2500;


/*
    INTERSECT
    
        INTERSECT returns only the rows which are returned by both quereies.
        So, in order for a record to be included in the final result set, it 
        must be present in the individual result sets of query 1 and 2
        
        Also, after calculating the final result set (intersection) from the 
        component queries, duplicate records are removed. 
*/

SELECT dept_id
FROM departments
WHERE monthly_budget > 15000
INTERSECT
SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 2500;