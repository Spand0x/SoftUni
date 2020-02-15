USE soft_uni;
DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    START TRANSACTION;
    UPDATE accounts AS ac
    SET ac.balance = ac.balance - money_amount
    WHERE ac.id = account_id;
    IF (money_amount < 0 OR ((
        SELECT balance FROM accounts
        WHERE id = account_id))<0) THEN
        ROLLBACK;
    END IF;
end $$