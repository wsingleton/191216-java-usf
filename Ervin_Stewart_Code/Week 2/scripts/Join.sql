--inner join
select emp_id,emp_fn, emp_ln, dept_id,dept_name 
from employees
join departments
on employees.department_id = departments.dept_id;
--the inner keyword is implicit if no join type is specified
select emp_id,emp_fn, emp_ln, dept_id,dept_name 
from employees
inner join departments
on employees.department_id = departments.dept_id;
/*
we can alias table name, similar to how we did column alaising
within SELECT statements. This makes for easier referencing of a table's
columns within our statment (before or ater the alas declartion)
*/
select emp_id, emp_fn, emp_ln, dept_id,dept_name 
from employees
inner join departments
on e.department_id = d.dept_id;

alter table employees
rename column department_id
to dept_id;

/*with natural joins, we can use the USING keyword. this only works when the two 
tables being joined have a column name that is shared
*/
select emp_id,emp_fn, emp_ln, dept_id,dept_name 
from employees e
join departments d
on e.dept_id = d.dept_id;

-- equivalent to above query with cleaner syntax
select emp_id,emp_fn, emp_ln, dept_id,dept_name 
from employees 
join departments 
using (dept_id);

select emp_id,emp_fn, emp_ln, dept_id,dept_name 
from employees e
join departments d
on e.dept_id = d.dept_id;

-- add manager id column to employees table
Alter table employees
add manager_id number(5);

insert into employees
values(14, 'AL', 'GREEN',date '1960-02-05',10000,4,date '2001-09-01', 'CEO', 'AGREEN',14);

update employees
set manager_id = 1
where dept_id = 1 and not emp_id = 1;

update employees
set manager_id = 2
where dept_id = 2 and not emp_id = 2;

update employees
set manager_id = 3
where dept_id = 3 and not emp_id = 3;

update employees
set manager_id = 4
where dept_id = 4 and not (emp_id = 14 or emp_id = 4);

update employees
set manager_id = 14
where manager_id is null;

commit;

--self join
select e.emp_id,e.emp_fn,e.emp_ln,e.monthly_income,e.manager_id,
    em.emp_fn || ' ' || em.emp_ln AS manager_name
from employees e
join employees em
on e.manager_id = em.emp_id;

--cross join
select *
from employees
cross join departments;
