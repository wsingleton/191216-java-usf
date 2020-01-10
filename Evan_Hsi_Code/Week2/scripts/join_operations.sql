/*

    Join
    
        Types:
            - INNER JOIN
            - OUTER JOIN
            - LEFT JOIN
            - RIGHT JOIN
            - CROSS JOIN
            - SELF JOIN
            
*/

-- joins are implicitly INNER

SELECT emp_id, emp_fn, emp_ln, dept_name
FROM employees
INNER JOIN departments
ON employees.department_id = departments.dept_id;

/*

    We can also alias table names, similarly to how we can alias columns with SELECT statements.
    This makes for easier referencing of a table's columns within our statement (before or after the alias declaration)
    
*/

SELECT emp_id, emp_fn, emp_ln, dept_name FROM employees e
INNER JOIN departments d
ON e.department_id = d.dept_id;

ALTER TABLE employees
RENAME COLUMN department_id TO dept_id;

/*

    With natural joins, we can use the USING keyword. This only works when the two
    tables being joined have a column name that is shared.

*/

SELECT emp_id, emp_fn, emp_ln, dept_name FROM employees
INNER JOIN departments
USING( dept_id );

-- Same name columns in different tables need prefixes ie. d.dept_id

SELECT emp_id, emp_fn, emp_ln, d.dept_id
FROM employees e
Join departments d
On e.dept_id = d.dept_id;

-- This returns the same result, but is bad practice since we are performing a
-- join without using the keyword (clarity issue)

SELECT emp_id, emp_fn, emp_ln, dept_name
FROM employees e, departments d
WHERE e.dept_id = d.dept_id;

--Add a manager_id column to the employees table

ALTER TABLE employees
ADD manager_id NUMBER(5);

SELECT * FROM employees;

INSERT INTO employees
VALUES (14, 'AL', 'GREEN', date '1960-02-05', 10000, 4, date '2001-09-01', 'CEO', 'AGREEN', 14);

UPDATE employees SET manager_id = 1
WHERE dept_id = 1 AND NOT emp_id = 1;

UPDATE employees SET manager_id = 2
WHERE dept_id = 2 AND NOT emp_id = 2;

UPDATE employees SET manager_id = 3
WHERE dept_id = 3 AND NOT emp_id = 3;

UPDATE employees SET manager_id = 4
WHERE dept_id = 4 AND NOT emp_id = 4;

UPDATE employees SET manager_id = NULL
WHERE emp_id = 14;

UPDATE employees SET manager_id = 14
WHERE emp_id = 1 OR emp_id = 2 OR emp_id = 3 OR emp_id = 4;

commit;

SELECT e.emp_id, e.emp_fn, e.emp_ln, e.monthly_income, e.manager_id, 
    em.emp_fn || ' ' || em.emp_ln AS manager_name
FROM employees e
JOIN employees em
ON e.manager_id = em.emp_id;


/*

    CROSS JOIN
        
        A CROSS JOIN returns a "cartesion product" of the tables: all rows from Table A
        are paired with each row of Table B, You can think of a CROSS JOIN as a join 
        without any conditions.
        
        HINT: Remember the t-shirt sizes and colors example ( combinatorics );

*/

Select * FROM employees
CROSS JOIN departments;

-- CROSS JOINS can be performed with out the keyword, don't.

SELECT * FROM employees, departments;
