--Section 2
--Task: Select all records from the Employee table
SELECT * FROM employee;
--Task: Select all from Employee where last name is King
SELECT * FROM employee WHERE lastname='King';
--Task: Select all from Employee where first name is Andrew and ReportsTo is null
SELECT * FROM employee WHERE firstname='Andrew' AND reportsto IS NULL;
--Task: Select all from album and order in descending order
SELECT * FROM album ORDER BY albumid DESC;
--Task: Select first name from customer, order ascending
SELECT firstname FROM customer ORDER BY firstname ASC;
--Task: Insert two new records into the genre table
INSERT INTO genre VALUES (26, 'Symphonic Metal');
INSERT INTO genre VALUES (27, 'Swing');
--Task: Insert two new records into the employee table
INSERT INTO employee (employeeid, lastname, firstname) VALUES (9, 'Kerr', 'Macie');
INSERT INTO employee (employeeid, lastname, firstname) VALUES (10, 'Thane', 'Ian');
--Task: Insert two new records into the customer table
INSERT INTO customer (customerid, lastname, firstname, email) VALUES (60, 'Universe', 'Steven', 'steven@littlehomeschool.com');
INSERT INTO customer (customerid, lastname, firstname, email) VALUES (61, 'Maheswaren', 'Connie', 'violinknight@email.com');
--Task: Update customer Aaron Mitchell to Robert Walter
UPDATE customer SET firstname='Robert', lastname='Walter' WHERE firstname='Aaron' AND lastname='Mitchell';
--Task: Update artist name of Creedence Clearwater Revival to CCR
UPDATE artist SET name='CCR' WHERE name='Creedence Clearwater Revival';
--Task: Select all invoices with a billing address like 'T' - this task is ambiguous.  Like T how?  Starts with?  Ends with?  Contains?
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';
--Task: Select all invoices with a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
--Task: Select all employees hired between June 1, 2003 and March 1, 2004
SELECT * FROM employee WHERE hiredate BETWEEN date '2003-6-1' AND date '2004-3-1';
--Task: Delete customer Robert Walter from customers
ALTER TABLE invoice DROP CONSTRAINT fk_invoicecustomerid;
ALTER TABLE invoice ADD CONSTRAINT fk_invoicecustomerid FOREIGN KEY (customerid) REFERENCES customer(customerid) ON DELETE CASCADE;
ALTER TABLE invoiceline DROP CONSTRAINT fk_invoicelineinvoiceid;
ALTER TABLE invoiceline ADD CONSTRAINT fk_invoicelineinvoiceid FOREIGN KEY (invoiceid) REFERENCES invoice(invoiceid) ON DELETE CASCADE;
DELETE FROM customer WHERE firstname='Robert' AND lastname='Walter';
--Section 3
--Task: Create a function that returns the current time
SET SERVEROUTPUT ON;
SELECT systimestamp FROM dual;
--Task: Create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name) FROM mediatype;
--Task: Create a function that returns the average total of all invoices
--Rounding to two decimals because result is an infinitely repeating decimal
SELECT round(avg(total), 2) FROM invoice ;
--Task: Create a function that returns the most expensive track
SELECT MAX(unitprice) FROM track;
--Task: Create a function that returns the avg invoice line price in the invoice line table
--Once again, rounding to two decimals because of excessive length
SELECT round((avg(unitprice)*avg(quantity)),2) FROM invoiceline;
--Task: create a function that returns all employees born after 1968
create or replace function get_employees_born_after_1968 return SYS_REFCURSOR is cursor_1968 sys_refcursor;
begin
    open cursor_1968 for select lastname, firstname, birthdate from employee where birthdate>date'1968-12-31';
    return cursor_1968;
end;
/
--Section 4
--Task: Createa a stored procedure that selects the first and last names of all employees
create or replace procedure get_employee_names(empnames_cursor out sys_refcursor) is
begin
    open empnames_cursor for select lastname,firstname from employee order by lastname;
end;
/
declare
    fn      employee.firstname%type;
    ln      employee.lastname%type;
    curs    sys_refcursor;
begin
    get_employee_names(curs);
    loop
        fetch curs into ln, fn;
        exit when curs%notfound;
        dbms_output.put_line('Employee: ' || ln || ', ' || fn);
    end loop;
    close curs;
end;
/
--Task: Create a stored procedure that updates the personal information of an employee
create or replace procedure upd_emp_title(empid in number, emptitle in varchar2) is
begin
    update employee set title = emptitle where employeeid=empid;
end;
/
declare
    empid       number;
    emptitle    varchar2(25);
begin
    empid:=9;
    emptitle:='customer service';
    upd_emp_title(empid, emptitle);
end;
/
select * from employee where employeeid=9;
--Task: Create a stored procedure that returns the managers of an employee
create or replace procedure get_managers(mgrs out sys_refcursor) is
begin
    open mgrs for select a.firstname, a.lastname, a.reportsto, b.employeeid, b.firstname, b.lastname from employee a left join employee b on a.reportsto=b.employeeid ORDER BY a.employeeid;
end;
/
declare
    fn      employee.firstname%type;
    ln      employee.lastname%type;
    mgrid   employee.reportsto%type;
    mgr     employee.employeeid%type;
    mgrfn   employee.firstname%type;
    mgrln   employee.lastname%type;
    curs    sys_refcursor;
begin
    get_managers(curs);
    loop
        fetch curs into fn, ln, mgrid, mgr, mgrfn, mgrln;
        exit when curs%notfound;
        dbms_output.put_line('Employee: ' || ln || ', ' || fn || ' reports to ' || mgrln || ', ' || mgrfn);
    end loop;
    close curs;
end;
/
--Task: Create a procedure that returns the name and company of a customer
create or replace procedure get_customers_by_company(cust_curs out sys_refcursor) is
begin
    open cust_curs for select lastname, firstname, company from customer order by lastname;
end;
/
declare
    ln      customer.lastname%type;
    fn      customer.firstname%type;
    c       customer.company%type;
    curs    sys_refcursor;
begin
    get_customers_by_company(curs);
    loop
        fetch curs into ln, fn, c;
        exit when curs%notfound;
        dbms_output.put_line('Customer: ' || ln || ', ' || fn || ' - ' || c);
    end loop;
    close curs;
end;
/
--Section 5
--Task: Create a transaction that, given an invoice id, will delete that invoice
declare
    invid   number;   
begin
    invid:=&x;
    delete from invoice where invoiceid=invid;
end;
/
--tested with record 377, process successful
select * from invoice where invoiceid=377;
--reinserting data related to record 377:
INSERT INTO Invoice (InvoiceId, CustomerId, InvoiceDate, BillingAddress, BillingCity, BillingCountry, BillingPostalCode, Total) VALUES (377, 45, TO_DATE('2013-7-20 00:00:00','yyyy-mm-dd hh24:mi:ss'), 'Erzsébet krt. 58.', 'Budapest', 'Hungary', 'H-1073', 0.99);
INSERT INTO InvoiceLine (InvoiceLineId, InvoiceId, TrackId, UnitPrice, Quantity) VALUES (2050, 377, 2017, 0.99, 1);
--Task: Create a transaction nested within a stored procedure that inserts a new record into the Customer table
create or replace procedure new_customer(custid in number, custfn in varchar2, custln in varchar2, custemail in varchar2) is
begin
    insert into customer (customerid, firstname, lastname, email) values (custid, custfn, custln, custemail);
end;
/
declare
    custid      customer.customerid%type;
    custfn      customer.firstname%type;
    custln      customer.lastname%type;
    custemail   customer.email%type;
begin
    custid:=&CustomerID;
    custfn:=('&CustomerFirstName');
    custln:=('&CustomerLastName');
    custemail:=('&CustomerEmail');
    new_customer(custid, custfn, custln, custemail);
end;
/
--tested using inputs 999, test, test, test@sample.email
select * from customer where customerid=999;
--Section 6
--Task: Create an after-insert trigger on the employee table fired after a new record is inserted
create or replace trigger newhire_id after insert on employee for each row
begin
    dbms_output.put_line('Employee inserted.');
end;
/
insert into employee (employeeid, firstname, lastname, title, email) values (11, 'Ilsabet', 'Voss', 'contractor', 'ilya.voss@gmail.com');
--Task: Create an after-update trigger on the album table fired after a row is updated
create or replace trigger artist_namechange after update on artist for each row
begin
    dbms_output.put_line('Artist renamed');
end;
/
insert into artist values (0, 'Turisa');
update artist set name='Turisas' where name='Turisa';
--Task: Create an after-delete trigger on the customer table fired after a row is deleted
create or replace trigger customer_deleted after delete on customer for each row
begin
    dbms_output.put_line('Customer deleted.');
end;
/
delete from customer where customerid=999;
--Task: Create a before trigger that restricts the deletion of any invoice priced over $50
create or replace trigger deletion_limit_50 before delete on invoice for each row
begin
    if (:old.total > 50) then raise_application_error (-20987, 'Invoices over $50 may not be deleted.');
    end if;
end;
/
--Section 7
--Task: Inner join customers and invoices, specifying cutomer and invoice id
select c.firstname, c.lastname, i.customerid, i.invoiceid from customer c join invoice i on c.customerid=i.customerid;
--Task: Outer join customers and invoices: customer id, first name, last name, invoice id, total
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total from customer c full join invoice i on c.customerid=i.customerid;
--Task: Right join album and artist: artist name, title
select al.title, ar.name from album al right join artist ar on ar.artistid = al.artistid;
--Task: Cross join album and artist, sort by artist name in ascending order
select * from album cross join artist order by artist.name asc;
--Task: Self join employee table on reports to column
select a.firstname, a.lastname, a.reportsto, b.employeeid, b.firstname, b.lastname from employee a left join employee b on a.reportsto=b.employeeid order by a.employeeid;
--Section 8
--Task: Create an index on any table
create index albumlist on album(title);