SELECT a.acct_id, a.balance
FROM accounts a
JOIN users_accounts b
ON a.acct_id = b.acct_id
JOIN users u
ON u.user_id = b.user_id
WHERE u.user_id = 1;

UPDATE accounts
SET balance = 10000
WHERE acct_id = 2;

SELECT balance FROM accounts WHERE acct_id = 1;
