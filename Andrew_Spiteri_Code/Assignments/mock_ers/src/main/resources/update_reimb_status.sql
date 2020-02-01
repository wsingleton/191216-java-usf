CREATE OR REPLACE PROCEDURE update_reimbs(reimb_in IN NUMBER, id_num IN NUMBER)
AS
reimb_status_id ers_reimbursement.reimb_status_id%TYPE;
BEGIN
UPDATE ers_reimbursement
SET reimb_status_id = reimb_in
where reimb_id = id_num;
END;
/

SELECT ers_app.update_reimbs(4,81)
FROM dual;