/*
    Subqueries
        A subquery is a SELECT statemnt that in included, or nested,
        within another SQL DML statment and are always included within
        parentheses.
*/

SELECT *
from employees
WHERE monthly_income = 
    (
        SELECT MAX(monthly_income)
        FROM employees
    );
    
/*
    Use IN to handle a subquery that possibly returns more than one record
    (however, not more than one column!)
*/
SELECT *
FROM employees
WHERE department_id IN 
    (
        SELECT dept_id
        FROM departments
        WHERE monthly_budget > 20000
    )
ORDER BY department_id, emp_id;