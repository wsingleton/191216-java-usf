-- this is a single line comment
/*
This is multiline comment
block
*/

-- create a table.
-- a department table with constraints 
-- format for column naming: column name, data type,and constraint.

CREATE TABLE departments(

dept_id NUMBER(5) CONSTRAINT pk_departments PRIMARY KEY,
dept_name VARCHAR2(50) UNIQUE,
monthly_budget NUMBER(8,2)

);

SELECT emp_fn FROM depart ments INNER JOIN employees ON (employees.department_id = departments.dept_id);

CREATE TABLE employees (
emp_id NUMBER(5),
emp_fn VARCHAR2(50),
emp_ln VARCHAR(50),
birthday DATE,
monthly_income NUMBER(8,2),
department_id NUMBER(5),
hire_date DATE,
job_title VARCHAR(20),
email VARCHAR(20) UNIQUE,

CONSTRAINT pk_employees
PRIMARY KEY (emp_id),

CONSTRAINT fk_employees_department
FOREIGN KEY (department_id)
REFERENCES departments(dept_id)
);

CREATE TABLE products(

prod_id NUMBER(5),
prod_name VARCHAR (50) NOT NULL,
price NUMBER(8,2),
expiration_date DATE NOT NULL

)

ALTER TABLE products
MODIFY prod_id
CONSTRAINT pk_products PRIMARY KEY;

INSERT INTO departments VALUES (3, 'IT', 30000);
INSERT INTO departments VALUES (4, 'HR', 25000);
INSERT INTO departments VALUES (5, 'CUSTOMER SERVICE', 2000);
INSERT INTO departments VALUES (6, 'REGULATORY AFFAIRS', 5000);
-- Adding values to the employees table using INSERT
INSERT INTO employees VALUES (1, 'JOHN', 'SMITH', date '1995-01-01', 4000.00, 1, date '2015-03-28', 'AC_ACCOUNT', 'JSMITH');
INSERT INTO employees VALUES (2, 'JAMES', 'BOSH', date '1992-02-15', 3500.00, 2, date '2014-07-01', 'MK_REP', 'JBOSH');
INSERT INTO employees VALUES (3, 'LUISA', 'JACKSON', date '1970-03-08', 4500.00, 3, date '2013-08-29', 'IT_PROG', 'LJACKSON');
INSERT INTO employees VALUES (4, 'STUART', 'GARCIA', date '1965-04-12', 2000.00, 4, date '2010-02-15', 'HR_REP', 'SGARCIA');
INSERT INTO employees VALUES (5, 'JUSTIN', 'BLACK', date '1990-05-16', 2550.00, 1, date '2015-05-02', 'AC_ACCOUNT', 'JBLACK');
INSERT INTO employees VALUES (6, 'ANGIE', 'CROOD', date '1998-06-22', 1500.00, 1, date '2015-07-01', 'AC_ACCOUNT', 'ACROOD');
INSERT INTO employees VALUES (7, 'CHARLES', 'DEAN', date '1973-06-08', 2250.00, 3, date '2002-03-01', 'IT_PROG', 'CDEAN');
INSERT INTO employees VALUES (8, 'EDDIE', 'FARREL', date '1980-07-28', 3000.00, 1, date '2009-04-20', 'AC_ACCOUNT', 'EFARREL');
INSERT INTO employees VALUES (9, 'GEORGE', 'HAYES', date '1982-08-03', 2500.00, 2, date '2012-09-22', 'MK_REP', 'GHAYES');
INSERT INTO employees VALUES (10, 'IGOR', 'OSBOURNE', date '1987-09-11', 6000.00, 3, date '2014-11-14', 'IT_PROG', 'IKEYS');
INSERT INTO employees VALUES (11, 'LUKE', 'MINT', date '1985-10-19', 5000.00, 4, date '2011-01-08', 'HR_REP', 'LMINT');
INSERT INTO employees VALUES (12, 'NIGEL', 'OAKS', date '1997-11-05', 4750.00, 4, date '2014-10-01', 'HR_REP', 'NOAKS');
INSERT INTO employees VALUES (13, 'LUKE', 'GREEN', date '1995-02-05', 4750.00, 4, date '2015-09-01', 'HR_REP', 'LGREEN');
-- Adding values to the products table using INSERT
INSERT INTO products VALUES (1, 'Aspirin', 5.00, DATE '2020-12-31');
INSERT INTO products VALUES (2, 'Penicillin', 10.00, DATE '2019-04-30');
INSERT INTO products VALUES (3, 'Insulin', 25.00, DATE '2018-05-31');
INSERT INTO products VALUES (4, 'Acetaminophen', 5.00, DATE '2019-01-31');
INSERT INTO products VALUES (5, 'Amoxicillin', 8.00, DATE '2018-07-31');

COMMIT;

SELECT * FROM departments;



