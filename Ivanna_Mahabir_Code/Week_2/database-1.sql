CREATE USER CBANK
IDENTIFIED BY scotia1
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
QUOTA 10M ON USERS;
-- give the table permissions
GRANT CONNECT TO CBANK;
GRANT RESOURCE TO CBANK;
GRANT CREATE SESSION TO CBANK;
GRANT CREATE TABLE TO CBANK;
GRANT CREATE VIEW TO CBANK;