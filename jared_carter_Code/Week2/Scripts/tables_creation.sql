-- This is a single line comment

/* This is a multi-line 
comment block
*/

--Create the departments table and define its columns and their constraints
CREATE TABLE departments(
dept_id   NUMBER(5) CONSTRAINT pk_departments PRIMARY KEY,

dept_name VARCHAR2(50) UNIQUE,

monthly_budget NUMBER(8,2)
);

CREATE TABLE employees(
emp_id  NUMBER(5),
emp_fn VARCHAR2(25),
emp_ln VARCHAR2(25),
birthdate DATE,
monthly_income NUMBER(7,2),
department_id NUMBER(5),
hire_date DATE,
job_title  VARCHAR2(25),
email VARCHAR2(255) UNIQUE,

CONSTRAINT pk_employees
PRIMARY KEY (emp_id),

CONSTRAINT fk_employee_department
FOREIGN KEY (department_id)
REFERENCES departments(dept_id)
);

/* CREATE TABLE products (
    prod_id NUMBER(5),
    prod_name VARCHAR2(50) NOT NULL,
);