--working union with duplicate records removed
Select dept_id
from departments
union
select department_id
from employees;

--union all preserves duplicate records
Select dept_id
from departments
union all
select department_id
from employees;

select department_id
from employees
where monthly_income between 2000 and 2500
minus
select dept_id 
from departments
where monthly_budget >15000



select dept_id 
from departments
where monthly_budget >15000
minus
select department_id
from employees
where monthly_income between 2000 and 2500

select dept_id
from departments
where monthly_budget > 15000
intersect
select department_id
from employees
where monthly_income between 2000 and 2500

select * 
from employees
where monthly_income = 
(
select Max(monthly_income)
from employees);

select * 
from employees
where department_id in 
(
select dept_id
from departments
where monthly_budget>20000)
order by department_id,emp_id;

