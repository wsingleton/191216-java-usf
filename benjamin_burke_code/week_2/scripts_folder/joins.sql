/*
    
    JOINS
        types;
            -INNER
            -OUTER
            -LEFT
            -RIGHT
    
    
    
*/

SELECT emp_id, emp_fn, emp_ln, dept_name
FROM employees
JOIN departments
ON employees.department_id = departments.dept_id;


SELECT emp_id, emp_fn, emp_ln, dept_name
FROM EMPLOYEES
INNER JOIN departments
ON employees.department_id = departments.dept_id;

SELECT emp_id, emp_fn, emp_ln, dept_name
FROM employees e
INNER JOIN departments d
ON e.department_id = d.dept_id;

ALTER TABLE employees
RENAME COLUMN department_id
TO dept_id;

SELECT emp_id, emp_fn, emp_ln, dept_name
FROM employees e
JOIN departments d
ON e.dept_id = d.dept_id;

SELECT emp_id, emp_fn, emp_ln, d.dept_id
FROM employees e
JOIN departments d
ON e.dept_id = d.dept_id;

--
SELECT emp_id, emp_fn, emp_ln, dept_name
FROM employees e, departments d
WHERE e.dept_id = d.dept_id;

ALTER TABLE employees
ADD manager_id NUMBER(5);

SELECT *
FROM employees;

INSERT INTO employees
VALUES (14, 'AL', 'GREEN', date '1960-02-05', 10000, 4, DATE '2001-09-01','CEO', 'AGREEN', 14);

UPDATE employees
SET manager_id = 1
WHERE dept_id = 2 AND NOT emp_id =1;

UPDATE employees
SET manager_id = 2
WHERE dept_id =2 AND NOT emp_id = 2;

COMMIT;

