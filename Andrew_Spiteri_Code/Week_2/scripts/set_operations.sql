--Does not work! DIfferent number of columns
SELECT *
FROM departments
UNION
SELECT department_id
FROM employees;

--WOrks but note that duplicate records are removed
SELECT dept_id
FROM departments
UNION
select department_id
FROM EMPLOYEES;

--Workd but the final result set is a but conrfusing (last names are under
--dept name)
SELECT emp_id, emp_ln
FROM employees
UNION
SELECT dept_id, dept_name
FROM departments;

--UNION ALL preserves duplicate records
SELECT dept_id
FROM departments
UNION ALL
SELECT department_id
FROM employees;

/*
    MINUS
        MINUS works by returning the results that are found in RS#1
        that are not found in RS#2.  
*/
SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 2500
MINUS
SELECT dept_id
FROM departments
WHERE monthly_budget > 15000;

SELECT dept_id
FROM departments
WHERE monthly_budget > 15000;
MINUS
SELECT department_id
FROM employees
WHERE monthly_income 
BETWEEN 2000 AND 2500;

/*
    INTERSECT
        INTERSECT returns only the rows which are returned by both queries.
        So, in order for a revord to be included in the final result set, it
        must be present in the individual result sets of query 1 and 2.
        
        Also after calculating the final result set intersection from the 
        component queries, fuplicate recourds are removed.
*/

SELECT dept_id
FROM departments
WHERE monthly_budget > 15000
INTERSECT
SELECT department_id
FROM employees
WHERE monthly_income 
BETWEEN 2000 AND 2500;