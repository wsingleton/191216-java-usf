/*
joins 
    types: 
        INNER JOIN
        OUTER JOIN
        LEFT JOIN
        RIGHT JOIN
        CROSS JOIN
        SELF JOIN
        
        

*/

-- INNER JOIN

SELECT emp_id , EMP_fn, EMP_ln , dept_name
from employees
join departments 
on employees.department_id = departments.dept_id;


SELECT emp_id , EMP_fn, EMP_ln , dept_name
from employees
inner join departments 
on employees.department_id = departments.dept_id;

/*
we can also alias table names similas to how we did colum aliasing 
within  select statement , this make dor caster easier 
*/

SELECT emp_id , EMP_fn, EMP_ln , dept_name
from employees e
inner join departments d
on e.department_id = d.dept_id;

ALTER table employees
RENAME COLUMN department_id
to dept_id;


/*

with nature join we can use the using keyword . this only worjs when the two tables using joining have a collummande share
*/

SELECT emp_id , EMP_fn, EMP_ln , dept_name
from employees e
join departments d
on e.dept_id = d.dept_id;


SELECT emp_id , EMP_fn, EMP_ln , dept_name
from employees e
join departments d
using (dept_ID);




SELECT emp_id , EMP_fn, EMP_ln , d.dept_name
from employees e
join departments d
on e.dept_id = d.dept_id;


SELECT emp_id , EMP_fn, EMP_ln , dept_name
from employees e, departments d
where e.dept_id = d.dept_id;

-- add a ,amager_id column to the employees table 

ALTER TABLE employees
ADD managerID NUMBER(5);

select * from employees order by dept_id, emp_id;

INSERT into employees
values (14,'al','green', date '1960-02-05',10000,4,date'2001-09-01','ceo', 'algreen',14);

update employees
set managerId = 1 
where dept_id = 1 and not emp_id = 1 ;

update employees
set managerId = 2
where dept_id = 2 and not emp_id = 2 ;

update employees
set managerId = 3
where dept_id = 3 and not emp_id = 3 ;

update employees
set managerId = 4
where dept_id = 4 and not(emp_id = 14 or emp_id = 4) ;

update employees
set managerId = 14
where managerid is NULL;

commit;


-- self joim 

select e.emp_id, e.emp_fn, e.emp_ln, e.monthly_income, e.managerid,
    em.emp_fn ||' '|| em.emp_ln as manager_name
    from employees e
    join employees em 
    on e.managerid = em.emp_id;

/*


    cross join 
        a cross join return " cartesian product" of the tables , all rows 
        from Table A are paired with each row of Table B, you can think 
        of a cross join as a join without any conditions 
*/

select *
from employees 
cross join departments;

-- cross join can be achieved without using the key phrase cross join 
-- but not recommend 





