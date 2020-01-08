/*
    JOINs
        Types:
            INNER JOIN
            OUTER JOIN
            LEFT JOIN
            RIGHT JOIN
            CROSS JOIN
            Self JOIN
*/

--INNER JOINs
SELECT emp_id, emp_fn, emp_ln, dept_name
from employees
join departments
on employees.department_id = departments.dept_id;

--JOINs without a type associated with them are implicitly INNER JOIN
SELECT emp_id, emp_fn, emp_ln, dept_name
from employees
inner join departments
on employees.department_id = departments.dept_id;

/*
    We can also alias table name, similar to how we did column aliasing
    within SELECT statements.  This makes for easier referecing of a 
    table's columns within our statement (before or after the alias declaration)
*/
SELECT emp_id, emp_fn, emp_ln, dept_name
from employees e
inner join departments d
on e.department_id = d.dept_id;

ALTER table employees
RENAME COLUMN department_id
to dept_id;

/*
    With natural joins, we can use the USING keyword.  THis only works when the 
    two tables bbeing joined have a column name that is shared
*/
SELECT emp_id, emp_fn, emp_ln, dept_name
from employees 
inner join departments 
USING (dept_id); 

--Add a manager_id column to the employees table
ALTER TABLE employees
ADD manager_id NUMBER(5);

INSERT INTO employees
VALUES(14,'AL','GREEN', DATE '1960-02-05', 10000, 4,DATE '2001-09-01', 'CEO', 'AGREEN', 14);

UPDATE employees
SET manager_id = 1
where dept_id = 1 AND NOT emp_id = 1;

SELECT * 
FROM employees
ORDER BY dept_id, emp_id;

UPDATE employees
SET manager_id = 2
WHERE dept_id = 2 AND not emp_id = 2;

UPDATE employees
SET manager_id = 3
WHERE dept_id = 3 AND not emp_id = 3;

UPDATE employees
SET manager_id = 4
WHERE dept_id = 4 AND not (emp_id = 3 OR emp_id = 14);

UPDATE employees
SET manager_id = 14
WHERE manager_id IS NULL;

COMMIT;

--Self JOIN

SELECT e.emp_id, e.emp_fn, e.emp_ln, e.monthly_income, e.manager_id, 
    em.emp_fn || ' ' || em.emp_ln as manager_name
from employees e
JOIN employees em
on e.manager_id = em.emp_id;

--Cross JOIN
/*
    Returns a Cartesian product of the tables.  All rows from table A are
    paired with each row of table B.  You can think of a CROSS JOIN as a join
    without any conditions.
*/
SELECT *
FROM employees
CROSS JOIN departments;

