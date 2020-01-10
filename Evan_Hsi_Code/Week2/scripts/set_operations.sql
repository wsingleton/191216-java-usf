/*

    -Union
    -Union All
    -Minus
    -Intersect

*/

/*

    UNION
        
        Union is a set operator that is used to combine the result sets of two or more queries. 
        It will also remove any duplicate results found in those queries
        
        Rues for union-ing query result sets:
            + Both query result sets must have the same number of columns
            + The data types of the columns need to be compatible

*/

-- Number of columns does not match, doesn't work.

SELECT * FROM departments UNION SELECT department_id FROM employees;

-- Works, but note that duplicate records are removed.

SELECT dept_id FROM departments UNION SELECT department_id FROM employees;

-- Works, but the final result doesn't make any sense (last names are under dept_name)

SELECT dept_id, dept_name FROM departments UNION SELECT emp_id, emp_ln FROM employees;

-- Does not remove duplicates

SELECT dept_id FROM departments UNION ALL SELECT department_id FROM employees;

/*

    MINUS
    
        MINUS works by returning the results that are found in RS#1 that are not contained in RS#2

*/

-- Returns '2'

SELECT department_id FROM employees WHERE monthly_income BETWEEN 2000 AND 2500
MINUS
SELECT dept_id FROM departments WHERE monthly_budget > 15000;


-- Returns '1'

SELECT dept_id FROM departments WHERE monthly_budget > 15000
MINUS
SELECT department_id FROM employees WHERE monthly_income BETWEEN 2000 AND 2500;

/*

    INTERSECT
        
        INTERSECT returns only the rows which are returned by both queries.
        So, in order for a record to be included in the final result set, 
        it must be present in the individual result sets of query 1 and 2.
        
        Also, after calculating the final result set (intersection) from the 
        component queries, duplicate records are removed.

*/
SELECT department_id FROM employees WHERE monthly_income BETWEEN 2000 AND 2500
INTERSECT
SELECT dept_id FROM departments WHERE monthly_budget > 15000;


