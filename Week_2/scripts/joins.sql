/*
    Joins
        
        Types:
            - INNER JOIN
            - OUTER JOIN
            - LEFT JOIN
            - RIGHT JOIN
            - CROSS JOIN
            - Self JOIN
*/

-- INNER JOINs

SELECT emp_id, emp_fn, emp_ln, dept_name
FROM employees
JOIN departments
ON employees.department_id = departments.dept_id;

-- The INNER keyword is implicit, if no join type is specified
SELECT emp_id, emp_fn, emp_ln, dept_name
FROM employees
INNER JOIN departments
ON employees.department_id = departments.dept_id;

/*
    We can also alias table names, similar to how we did column aliasing 
    within SELECT statements. This makes for easier referencing of a 
    table's columns within our statement (before or after the alias declaration)
*/
SELECT emp_id, emp_fn, emp_ln, dept_name
FROM employees e
INNER JOIN departments d
ON e.department_id = d.dept_id;

ALTER TABLE employees
RENAME COLUMN department_id
TO dept_id;

/*
    With natural joins, we can use the USING keyword. This only works when the 
    two tables being joined have a column name that is shared.
*/
-- Repeated for example-sake.
SELECT emp_id, emp_fn, emp_ln, dept_name
FROM employees e
JOIN departments d
ON e.dept_id = d.dept_id;

-- Equivalent to the above query, but with a cleaner syntax
SELECT emp_id, emp_fn, emp_ln, dept_name
FROM employees
JOIN departments
USING (dept_id);

-- Note that dept_id within the column list needs to be prefixed with an alias
SELECT emp_id, emp_fn, emp_ln, d.dept_id
FROM employees e
JOIN departments d
ON e.dept_id = d.dept_id;

-- We can achieve the same result without the JOIN keyword (not recommended!)
SELECT emp_id, emp_fn, emp_ln, dept_name
FROM employees e, departments d
WHERE e.dept_id = d.dept_id;

-- Add a manager_id column to the employees table
ALTER TABLE employees
ADD manager_id NUMBER(5);

SELECT *
FROM employees
ORDER BY dept_id, emp_id;

INSERT INTO employees
VALUES (14, 'AL', 'GREEN', date '1960-02-05', 10000, 4, date '2001-09-01', 'CEO', 'AGREEN', 14);

UPDATE employees
SET manager_id = 1
WHERE dept_id = 1 AND NOT emp_id = 1;

UPDATE employees
SET manager_id = 2
WHERE dept_id = 2 AND NOT emp_id = 2;

UPDATE employees
SET manager_id = 3
WHERE dept_id = 3 AND NOT emp_id = 3;

UPDATE employees
SET manager_id = 4
WHERE dept_id = 4 AND NOT (emp_id = 14 OR emp_id = 4);

UPDATE employees
SET manager_id = 14
WHERE manager_id IS NULL;

COMMIT;

-- Self JOIN
SELECT e.emp_id, e.emp_fn, e.emp_ln, e.monthly_income, e.manager_id, 
       em.emp_fn || ' ' || em.emp_ln AS manager_name
FROM employees e
JOIN employees em
ON e.manager_id = em.emp_id;

/*
    CROSS JOIN
    
        A CROSS JOIN returns "cartesian product" of the tables: all rows
        from Table A are paired with each row of Table B. You can think
        of a CROSS JOIN as a join without any conditions.
        
        Hint: Remember the t-shirt sizes and colors example
*/
SELECT *
FROM employees
CROSS JOIN departments;

-- CROSS JOINs can be achieved without using the keyphrase CROSS JOIN
-- but not recommended.
SELECT *
FROM employees, departments;

