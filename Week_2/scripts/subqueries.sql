/*
    Subqueries
    
        A subquery is a SELECT statement that is included, or nested,
        within another SQL DML statement and are always included within
        parentheses.
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
WHERE emp_id = 1;

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