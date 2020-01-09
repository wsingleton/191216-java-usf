-- Inner Join

SELECT  emp_id , emp_fn, emp_ln, dept_name
FROM  employees
JOIN departments
ON employees.departmen_id = departments.dept_id;

SELECT  emp_id , emp_fn, emp_ln, dept_name
FROM  employees
INNER JOIN departments
ON employees.departmen_id = departments.dept_id;

SELECT  emp_id , emp_fn, emp_ln, dept_name
FROM  employees e
INNER JOIN departments d
ON e.departmen_id = d.dept_id;


ALTER TABLE employees
RENAME COLUMN department_id
TO dept_id;

-- With natural joins , we can use the USING Keyword. This only works when the two tables being joined have a column name
-- that is shared


ALTER TABLE employees
ADD manager_id NUMBER(5);

INSERT INTO employees
VALUES(14, 'AL', 'GREEN', date '1960-02-05', 10000, 4, date '2001-09-01', 'CEO', 'AGREEN', 14);

UPDATE employees
SET manager_id = 1
WHERE dept_id = 1 AND NOT emp_id =1;

UPDATE employees
SET manager_id = 2
WHERE dept_id = 2 AND NOT emp_id=2;

UPDATE employees
SET manager_id = 3
WHERE dept_id = 3 AND NOT emp_id=3;

UPDATE employees
SET manager_id = 4
WHERE dept_id = 4 AND NOT (emp_id=14 or emp_id =4);

UPDATE employees
SET manager_id = 14
WHERE manager_id IS NULL;

COMMIT;

-- SELF JPINF 
SELECT e.emp_id, e.emp_fn, e.emp_ln, e.monthly_income, e.manger_id, em.emp_fn || ' ' || em.emp_ln AS manager_name
FROM employees
JOIN employees
on e.manager_id = em.emp_id;
