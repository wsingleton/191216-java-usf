/*
db details for mock BANK application
*/

-- TABLE FOR USERS
CREATE TABLE users(
 user_id NUMBER NOT NULL,
 first_name VARCHAR2(50) NOT NULL,
 last_name VARCHAR2(50) NOT NULL,
 username VARCHAR2(10) UNIQUE NOT NULL,
 password VARCHAR2(10) NOT NULL,
 role VARCHAR2(50) DEFAULT 'Customer',
 CONSTRAINT pk_users
 PRIMARY KEY (user_Id)
);

--DROP TABLE users;
--DROP TABLE accounts;
--DROP TABLE activities;

-- TABLE TO HOLD ACCOUNTS
/*
accounts table rules
-   Unique account numbers
- Accessible by account Id.
- multiple users can share one account
Account access can be Personal or Shared.
*/
CREATE TABLE accounts(
account_id NUMBER NOT NULL,
account_type VARCHAR2(25) NOT NULL,
account_access VARCHAR2(25) DEFAULT 'personal',
date_opened DATE,
current_balance NUMBER(30,2) DEFAULT 0,

CONSTRAINT pk_accounts
PRIMARY KEY (account_id)

);

-- TABLE TO RECORD ACCOUNT ACCOUNT HISTORY
/*
Rules: 
- The table will register the type of activities performed and dates.
- Acivities can be Deposit or Saving
- A user id of the person who perfrmed the activity is recorded.
- if a shared account is used by multiple users, the activity log will log the individual responsible for the activity.
*/

CREATE TABLE activities(
activity_id NUMBER NOT NULL,
user_id NUMBER NOT NULL,
account_id NUMBER NOT NULL,
activity_date DATE NOT NULL,
transaction_details VARCHAR2(50) NOT NULL,
amount NUMBER (30,2) NOT NULL,

CONSTRAINT pk_activities
PRIMARY KEY (activity_id), 

CONSTRAINT fk_users
FOREIGN KEY (user_id)
REFERENCES users (user_id),

CONSTRAINT fk_accounts_table
FOREIGN KEY (account_id)
REFERENCES accounts (account_id)

);

/*
USERS_ACCOUNTS 

    this table is to bridge the users and their accounts. 
    1 user can have multiple accounts. 
    This is a third normal form concept to provide a safe link between the two 2 tables
    while avoiding duplicate information.

*/

CREATE TABLE users_accounts(
user_id NUMBER,
account_id NUMBER,

CONSTRAINT pk_users_accounts
PRIMARY KEY (user_id, account_id),

CONSTRAINT fk_users_accounts_users
FOREIGN KEY (user_id)
REFERENCES users (user_id),

CONSTRAINT fk_users_accounts_accounts
FOREIGN KEY (account_id)
REFERENCES accounts (account_id)

);

--COMMIT;

--SELECT * FROM users_accounts;


