--2.1
SELECT  *
FROM employee;

SELECT * FROM employee WHERE lastname = 'King';

SELECT *FROM employee 
WHERE firstname = 'Andrew' and reportsto = null;

--2.2
SELECT *
FROM album 
ORDER by albumid DESC;

SELECT firstname FROM customer ORDER BY firstname ASC;

--2.3
INSERT INTO genre VALUES(26,'Country');
INSERT INTO genre VALUES(27,'Music');

INSERT INTO employee VALUES(9,'Le', 'Hoang','Staff',5,date  '1990-08-30',date '2019-12-16','1503 N Mckinley ave','Chicago', 'IL','USA','61821','217-281-2842','2172812842','Hoangle@gmail.com');
INSERT INTO employee VALUES(10,'Le1', 'Hoang11','Staff1',5,date  '1990-08-30',date '2019-12-16','11234 N University ave','Champaign', 'IL','USA','61822','217-281-2842','2172812842','Hoangle111@gmail.com');

INSERT INTO customer VALUES(60,'Le', 'Hoang','Revature','1503 N Mckinley ave','Chicago', 'IL','USA','61821','217-281-2842','2172812842','Hoangle@gmail.com', 3);
INSERT INTO customer VALUES(61,'Le1', 'Hoang11','Revature','1503 N Univesity ave','Champaign', 'IL','USA','61822','217-281-2842','2172812842','Hoangle111@gmail.com', 3);

COMMIT ;

--2.4
UPDATE customer SET firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';

UPDATE artist SET name = 'CCR' where name = 'Creedence Clearwater Revival';
COMMIT ;
--2.5

SELECT * FROM invoice where billingaddress LIKE '%T%';
--2.6
SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 50;

SELECT *
FROM employee
WHERE hiredate BETWEEN  date '2003-06-01' AND date '2004-04-01';

--2.7
-- frist use select to get customer id 
Select * FROM customer  WHERE firstname = 'Robert'and lastname = 'Walter';
-- we got customer id is 32, then get all invoice that have customerid = 32 in invoiceline
Select * FROM invoice  WHERE customerid = 32;
-- we got 245,268,290,342,50,61,116. then we delete all the invoiceline that have invoic id same with these id
DELETE FROM invoiceline  WHERE invoiceid = 245;
DELETE FROM invoiceline  WHERE invoiceid = 268;
DELETE FROM invoiceline  WHERE invoiceid = 290;
DELETE FROM invoiceline  WHERE invoiceid = 342;
DELETE FROM invoiceline  WHERE invoiceid = 50;
DELETE FROM invoiceline  WHERE invoiceid = 61;
DELETE FROM invoiceline  WHERE invoiceid = 116;

-- now delete all invoice that have customer id = 32 

DELETE FROM invoice  WHERE customerid = 32;
-- finally delete Robert Walter
DELETE FROM customer  WHERE firstname = 'Robert'and lastname = 'Walter';

COMMIT ;



-- section 3

--3.1
-- a
create or replace function getSysdate
return TIMESTAMP is

  l_sysdate TIMESTAMP;

begin

  select systimestamp
    into l_sysdate
    from dual;

  return l_sysdate;

end;
/

select getSysdate() from dual;


-- b

create or replace function getlength(id number)
return number as

  thislength number;

begin

  select LENGTH(name)
    into thislength
    from mediatype
    where mediatypeid = id;

  return thislength;

end;
/

select getlength(1) from dual;


--3.2

CREATE OR REPLACE FUNCTION findAvg
        RETURN NUMBER AS thisavg NUMBER;
        
BEGIN
          SELECT AVG(total) INTO thisavg FROM invoice;
          RETURN thisavg;
 END;
 /
 select findavg() from dual;



CREATE OR REPLACE FUNCTION findmax
        RETURN NUMBER AS thismax NUMBER;
        
BEGIN
          SELECT max(unitprice) INTO thismax FROM track;
          RETURN thismax;
 END;
 /
 select findmax() from dual;



--3.3

CREATE OR REPLACE FUNCTION findavg2
        RETURN NUMBER AS thisavg2 NUMBER;
        
BEGIN
          SELECT ROUND(AVG(unitprice),2) INTO thisavg2 FROM invoiceline;
          RETURN thisavg2;
 END;
 /
 select findavg2() from dual;

--3.4

create or replace FUNCTION after_1968
    RETURN SYS_REFCURSOR
    is my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor for 
    Select firstname,lastname,birthdate
    From employee 
    where birthdate > date'1968-12-31';

    return my_cursor;
END;
/

select after_1968() from dual;

-- Section 4

 -- 4.1
 
create or replace PROCEDURE get_all_employee(my_cursor out SYS_REFCURSOR)
is
BEGIN
    OPEN my_cursor for 
    SELECT employeeid,lastname,firstname 
    FROM employee
    ORDER BY employeeid;
END;

--- 4.2

CREATE OR REPLACE PROCEDURE updateEmployee(id IN NUMBER, fn IN VARCHAR2, ln IN VARCHAR2) 
IS
BEGIN
    
    UPDATE employee SET firstname = fn, lastname = ln WHERE employeeid = id;
    
END;
/

BEGIN
    updateEmployee(9, 'hoangupdate', 'hello');
END;
/



CREATE OR REPLACE PROCEDURE returnManagers(emid IN NUMBER, mnfname OUT VARCHAR2, mnlname OUT VARCHAR2)
IS 
mnid NUMBER;

BEGIN

    SELECT reportsto INTO mnid FROM employee WHERE employeeid = emid;
    
    SELECT firstname, lastname INTO mnfname, mnlname FROM employee WHERE employeeid = mnid;
    
END;
/


DECLARE
    fn    VARCHAR2(25);
    ln    VARCHAR2(25);

BEGIN
    returnManagers(2, fn, ln);
    DBMS_OUTPUT.PUT_LINE(fn || ' ,' || ln);
END;
/

-- 4.3
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


--section 5

CREATE OR REPLACE PROCEDURE deleteInvoice(id IN NUMBER)
AS

BEGIN
    
    DELETE FROM invoice WHERE invoiceid = id;
    
END;
/

BEGIN
    deleteInvoice(216);
END;
/




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


--section 6
-- 6.1
--a
create or replace trigger newhire_id after insert on employee for each row
begin
    dbms_output.put_line('Employee inserted.');
end;
/

--b
create or replace trigger artist_namechange after update on artist for each row
begin
    dbms_output.put_line('Artist renamed');
end;
/

--c

CREATE OR REPLACE TRIGGER afterDeleteCustomer AFTER DELETE ON customer

BEGIN

    DBMS_OUTPUT.PUT_LINE('DELETE trigger');

END;
/

--6.2
CREATE OR REPLACE TRIGGER beforeDelete BEFORE DELETE ON invoice
FOR EACH ROW
BEGIN
        IF :OLD.total > 50 THEN
            RAISE_APPLICATION_ERROR(-20000, 'Invoice is bigger then 50$, cant delete ');
        END IF;
END;
/

--section 7 
--7.1
SELECT firstname, lastname, invoiceid FROM customer
JOIN invoice
USING (customerid);
--7.2
SELECT customerid, firstname, lastname, invoiceid, total FROM customer
FULL OUTER JOIN invoice
USING ( customerid );
--7.3
SELECT name, title FROM artist
RIGHT JOIN album
USING (artistid);
--7.4
SELECT name, title FROM artist
CROSS JOIN album
ORDER BY name ASC;
--7.5
SELECT * FROM employee
SELF JOIN employee 
USING (reportsto);


--section 8 
create index media on mediatype(mediatypeid);


