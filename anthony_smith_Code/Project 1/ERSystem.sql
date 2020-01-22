CREATE TABLE ERS_REIMBURSMENT_STATUS
(
    REIMB_STATUS_ID     NUMBER,
    REIMB_STATUS        VARCHAR2(10),
    
    CONSTRAINT REIMB_STATUS_PK PRIMARY KEY (REIMB_STATUS_ID)
)

------------------------------------------------------

CREATE TABLE ERS_REIMNURSEMENT_TYPE
(
    REIMB_TYPE_ID       NUMBER,
    REIMB_TYPE          VARCHAR2(10),
    
    CONSTRAINT REIMB_TYPE_PK PRIMARY KEY (REIMB_TYPE_ID)
)

-------------------------------------------------------

CREATE TABLE ERS_USER_ROLES
(
    ERS_USER_ROLE_ID    NUMBER,
    USER_ROLE           VARCHAR2(10),
    
    CONSTRAINT ERS_USER_ROLES_PK PRIMARY KEY (ERS_USER_ROLE_ID)
)

---------------------------------------------------------

