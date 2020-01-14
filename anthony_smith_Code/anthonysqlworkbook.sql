-- 2.1 ----------

-- Task _ 1
SELECT *
FROM employee ;

-- Task _ 2
SELECT *
FROM employee
WHERE last name = ‘King’;

--Task _ 3
Select *
FROM
WHERE first name = ‘Andrew’ AND reprotsto is null;


-- 2.2 ----------

-- Task _ 1

SELECT *
FROM album
ORDER BY title DESC; 


-- Task _ 2

SELECT *
FROM customer
ORDER BY firstname ASC;

-- 2.3 ----------

-- Task _ 1
INSERT INTO genre VALUES (26, ‘Audiobooks’);
INSERT INTO genre VALUES (27, ‘K-POP’);

-- Task _ 2

insert into employee 
values(9, ‘Moovan’, ‘Baudi’, ‘IT STAFF’, 6, TO_DATE(‘1958-12-8 00:00:00’, ‘yyyy-mm-dd hh24:mi:ss’)  
to_date(‘2002-5-1 00:00:00’, ‘yyyy-mm-dd hh24:mi:ss’), ‘12702 Bruce B Down’, ‘Tampa’, FL, ‘United States’, ‘33612’, ’+1(504)400-4242’, 
‘+1(504)400-5252’, ‘bananas@hollaback.com);

insert into employee 
values(9, ‘Green’, ‘John’, ‘IT STAFF’, 6, TO_DATE(‘1958-12-8 00:00:00’, ‘yyyy-mm-dd hh24:mi:ss’)  
to_date(‘2002-5-1 00:00:00’, ‘yyyy-mm-dd hh24:mi:ss’), ‘12702 Bruce B Down’, ‘Tampa’, FL, ‘United States’, ‘33612’, ’+1(504)490-4942’, 
‘+1(504)898-5252’, ‘jgreen@hollaback.com);


-- Task _ 3

INSERT INTO Customer (CustomerID, FIRSTNAME, LASTNAME, EMAIL) VALUES (60, ‘Dan’, ‘DaMan’, 'dan.daman@mcr.com');

INSERT INTO Customer (CustomerID, FIRSTNAME, LASTNAME, EMAIL) VALUES (61, ‘Frank’, ‘Ocean’, ‘frankieo@oddfuture.com’); 

-- 2.4 ----------

-- Task _1

UPDATE CUSTOMER 
SET firstname = 'Robert',  lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

-- Task _ 2
UPDATE Artist SET NAME =‘COR’ 
WHERE NAME = ‘Creedence Clearwater Revival’;

-- 2.5 ----------

-- Task _1
SELECT *
FROM invoice
WHERE billingaddress like ’T%’;

-- 2.6 ----------

-- Task _1

SELECT 
FROM invoice 
WHERE total BETWEEN 15 AND 50;

-- Task _2

SELECT *
FROM employee
WHERE hiredate BETWEEN ’01-JUN-03’ AND ’01-MAR-04’;

-- 2.7 ----------

-- Task _1

DELETE FROM INVOICELINE
WHERE INVOICEID = 245 OR INVOICEID = 268 OR INVOICEID = 290 OR INVOICEID = 342 OR INVOICEID = 50 OR INVOICEID = 61 OR INVOICEID = 116;
DELETE FROM INVOICE
WHERE customerid = 32;
DELETE FROM CUSTOMER 
WHERE CUSTOMERID =32;

-- 3.1 ----------

-- Task _1
CREATE OR REPLACE FUNCTION get_current_time
RETURN CHAR 
AS ctime CHAR(10 CHAR);
BEGIN 
SELECT TO_CHAR(SYSDATE, 'HH:MI:SS') 
INTO ctime
FROM dual;
RETURN(ctime);
END get_current_time;
/

-- Task _2


CREATE OR REPLACE FUNCTION get_media_length
RETURN NUMBER
IS media_length NUMBER;
BEGIN
SELECT LENGTH(name)
INTO media_length
FROM mediatype;
RETURN media_length;
END get_media_length;

-- 3.2 ----------

-- Task _1

CREATE OR REPLACE FUNCTION avg_total_invoices(total IN NUMBER)
RETURN NUMBER
AS avg_total NUMBER(10,2); 
BEGIN 
SELECT AVG(total)
INTO avg_total
FROM invoice;
RETURN avg_total;
END avg_total_invoices;
/


-- Task _2

CREATE OR REPLACE FUNCTION get_expensive_track
    RETURN NUMBER 
    AS expensive_track NUMBER;
BEGIN 
    SELECT MAX(unitprice)
    INTO expensive_track 
    FROM track;
RETURN expensive_track;    
END;
/

-- 3.3 --------


-- Task _1

CREATE OR REPLACE FUNCTION get_average_price
RETURN NUMBER
AS average_price NUMBER;
BEGIN 
SELECT AVG(unitprice)
INTO average_price
FROM invoiceline;
RETURN average_price;
END;

-- 3.4 ---------

-- Task _1


DECLARE
    v_cursor    SYS_REFCURSOR;
    v_fn        employee.firstname%TYPE;
    v_ln        employee.lastname%TYPE;
    v_bd        employee.birthdate%TYPE;
BEGIN
    v_cursor := after_1968();
    
    LOOP
        FETCH v_cursor
        INTO v_fn, v_ln, v_bd;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_fn || ' ' || v_ln || ' was born on ' || v_bd);
    END LOOP;
    CLOSE v_cursor;
END;/


-- 4.1 -----------

-- Task _1

CREATE OR REPLACE PROCEDURE get_customer_name(my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT *
    FROM customer
    ORDER BY lastname;
END;
/

-- 4.2 -------------

-- Task _1

CREATE OR REPLACE PROCEDURE update_employee(eid employee.employeeid%TYPE, f_name employee.firstname%TYPE, 
l_name employee.lastname%TYPE)
IS
BEGIN
    UPDATE employee
    SET firstname = f_name,lastname = l_name
    WHERE eid = employeeid;
    
    COMMIT;
END;



-- Task _2

CREATE OR REPLACE PROCEDURE get_manager(eid NUMBER)
IS employee_manager_id NUMBER;
BEGIN 
    SELECT reportsto
    INTO employee_manager_id
    FROM employee
    WHERE eid = employeeid;
    DBMS_OUTPUT.PUT_LINE(employee_manager_id);
    END;/
    
    
-- 4.3 -----------

-- Task _1

CREATE OR REPLACE PROCEDURE get_name_and_comapny(cid NUMBER)
IS c_contact customer%ROWTYPE;
BEGIN 
    SELECT *
    INTO c_contact
    FROM customer
    WHERE cid = customerid;
    DBMS_OUTPUT.PUT_LINE(c_contact.company || ' ' ||c_contact.firstname ||' '|| c_contact.lastname);
    END;/
    
    
-- 5.1 ----------

-- Task -1
CREATE OR REPLACE PROCEDURE delete_invoice(inv_id NUMBER)
IS
BEGIN
DELETE 
FROM invoice
WHERE inv_id = invoiceId;
END;
/

-- Task -2

CREATE OR REPLACE PROCEDURE insert_customer(
    c_id    customer.customerid%TYPE,
    c_fn    customer.firstname%TYPE,
    c_ln    customer.lastname%TYPE,
    c_comp  customer.company%TYPE,
    c_add   customer.address%TYPE,
    c_city  customer.city%TYPE,
    c_state customer.state%TYPE,
    c_coun  customer.country%TYPE,
    c_pc    customer.postalcode%TYPE,
    c_phone customer.phone%TYPE,
    c_fax   customer.fax%TYPE,
    c_email customer.email%TYPE,
    c_supid customer.supportrepid%TYPE)
IS
BEGIN 

    INSERT INTO customer("CUSTOMERID", "FIRSTNAME","LASTNAME","COMPANY",
     "ADDRESS", "CITY", "STATE", "COUNTRY", "POSTALCODE", "PHONE",
    "FAX","EMAIL", "SUPPORTREPID") VALUES (c_id, c_fn, c_ln, c_comp, c_add, c_city, c_state, c_coun, c_pc, c_phone, c_fax, c_email, c_supid);
    
    COMMIT;
    
END;
/


-- 6.1 -------------

-- Task -1

CREATE OR REPLACE TRIGGER new_employee_trigger 
AFTER  INSERT 
ON employee
BEGIN
DBMS_OUTPUT.PUT_LINE('New Employee added ');
END;
/

-- Task -2

CREATE OR REPLACE TRIGGER new_album_trigger
AFTER INSERT 
ON album
BEGIN
    DBMS_OUTPUT.PUT_LINE('New Album added');
    RETURN;
END;

-- Task -3 

CREATE OR REPLACE TRIGGER customer_delete 
AFTER DELETE
ON customer 
BEGIN 
    DBMS_OUTPUT.PUT_LINE('Customer Deleted');
END;

-- 6.2 ------------

-- Task - 1


CREATE OR REPLACE TRIGGER checkbalance 
BEFORE DELETE ON invoice
FOR EACH ROW
BEGIN 
IF invoice.total > 50 THEN
    RAISE_APPLICATION_ERROR(-1500, 'Invoice > 50');
END IF;

END;
/

-- 7.1 ----------

-- Task _1

DELETE FROM CUSTOMER; 
SELECT customer.firstname, customer.lastname, invoice.invoiceid 
FROM customer
JOIN invoice 
USING (customerid);


-- 7.2 ----------

-- Task _1

SELECT customerid, firstname, lastname, invoiceId, total
FROM customer 
FULL OUTER JOIN invoice
USING (customerid);


-- 7.3 ----------

-- Task _1

SELECT album.title, artist.name
FROM album
RIGHT JOIN artist
USING (artistid);

-- 7.4 ----------

-- Task _1

SELECT *
FROM album
CROSS JOIN artist
ORDER BY artist.name ASC;



-- 7.5 ----------

-- Task _1

SELECT * 
FROM employee 
SELF JOIN employee 
USING (reportsto);



-- 8.1 ----------

-- Task _1

CREATE INDEX idx_customer on customer(customerid);



