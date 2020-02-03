INSERT INTO ERS_USERS (ers_username, ers_password, user_first_name,
                        user_last_name, user_email, user_role_id)
VALUES ('asmith', 'p4ssw0rd', 'Anthony', 'Smith', 'asmith@ers.com', 1 );

INSERT INTO ERS_USERS (ers_username, ers_password, user_first_name,
                        user_last_name, user_email, user_role_id)
VALUES ('charris', 'p4ssw0rd2', 'Calvin', 'Harris', 'charris@ers.com', 2 );

INSERT INTO ERS_USERS (ers_users_id ,ers_username, ers_password, user_first_name,
                        user_last_name, user_email, user_role_id)
VALUES ('0', 'dummy2','p4ssw0rd5', 'dummy2', 'dummy2', 'dummy2@dummy.com', 2 );



INSERT INTO ers_reimbursement_type
VALUES(1, 'LODGING');

INSERT INTO ers_reimbursement_type
VALUES(2, 'TRAVEL');

INSERT INTO ers_reimbursement_type
VALUES(3, 'FOOD');

INSERT INTO ers_reimbursement_type
VALUES(4, 'OTHER');



INSERT INTO ERS_USER_ROLES
VALUES(1, 'Manager');

INSERT INTO ERS_USER_ROLES
VALUES(2, 'User');



INSERT INTO ers_reimbursement_status
VALUES(1, 'PENDING');

INSERT INTO ers_reimbursement_status
VALUES(2, 'APPROVE');

INSERT INTO ers_reimbursement_status
VALUES(3, 'DENY');


INSERT INTO ers_reimbursement VAULES