CREATE OR REPLACE PROCEDURE update_reimbs(reimb_in IN NUMBER)
IS
DECLARE
reimb_status_id ers_reimbursement.reimb_status_id;
BEGIN
SELECT reimb_in
INTO reimb_status_id
FROM ers_reimbursement;

END;
/