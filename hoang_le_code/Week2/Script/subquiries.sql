Select* 
from employees
where monthly_income = 
( select max(monthly_income) from employees);

update employees
set monthly_income = 10000
where emp_id = 1;

-- use IN to handle a sub query that possibly return more than one record ( howerver, not motr than one colum)

select *
from employees
where department_id in
(
select dept_ID
from departments
where monthly_income >20000
)
ORDER BY department_id,emp_id;