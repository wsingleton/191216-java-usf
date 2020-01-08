SELECT dept_id, dept_name
FROM departments
UNION 
SELECT emp_id, emp_ln
FROM employees;


SELECT dept_id
FROM departments
UNION ALL 
SELECT department_id
FROM employees;

SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 25000
MINUS   
SELECT dept_id
FROM departments
WHERE monthly_budget > 15000;

SELECT dept_id
FROM departments
WHERE monthly_budget > 1500
INTERSECT 
SELECT department_id
FROM employees
WHERE monthly_income BETWEEN 2000 AND 2500;


SELECT *
FROM employees
WHERE monthly_income =
    (   
        SELECT MAX(monthly_income)
        FROM employees
    );
    
    
    
UPDATE employees
SET monthly_income = 6000
WHERE emp_id = 1;


UPDATE employees
SET monthly_income = 10000
WHERE emp_id =1;

SELECT *
FROM employess
WHERE dept_id IN
(
        SELECT dept_id
        FROM departments 
        WHERE monthly_bidget > 200000
)
ORDER BY dept_id, emp_id;
