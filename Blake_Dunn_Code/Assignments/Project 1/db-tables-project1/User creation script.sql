--CREATE USER ersadmin
--IDENTIFIED BY smurf1924free
--DEFAULT TABLESPACE users
--TEMPORARY TABLESPACE temp
--QUOTA 10M ON users;
--
--GRANT connect to ersadmin;
--GRANT resource to ersadmin;
--GRANT create session TO ersadmin;
--GRANT create table TO ersadmin;
--GRANT create view TO ersadmin;


--CREATE USER ers_user
--IDENTIFIED BY p4ssw0rd;
--
--GRANT CONNECT TO ers_user;
--GRANT CREATE SESSION TO ers_user;
--GRANT SELECT, INSERT, UPDATE ON ersadmin.ers_users TO ers_user;
--GRANT SELECT ON ersadmin.ers_user_roles TO ers_user;
--GRANT SELECT, INSERT, UPDATE, DELETE ON ersadmin.ers_reimbursement TO ers_user;






