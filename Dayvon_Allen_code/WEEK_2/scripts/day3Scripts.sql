SELECT dept_id
FROM departments
UNION
SELECT department_id
FROM employees;


SELECT emp_id, emp_ln
FROM employees
UNION
SELECT dept_id, dept_name
FROM departments;

