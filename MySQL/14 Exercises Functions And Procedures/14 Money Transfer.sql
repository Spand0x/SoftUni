USE soft_uni;
DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19, 2))
BEGIN
    START TRANSACTION;
        UPDATE accounts AS ac
        SET ac.balance = ac.balance + amount
        WHERE ac.id = to_account_id;
        UPDATE accounts AS ac
        SET ac.balance = ac.balance - amount
        WHERE ac.id = from_account_id;
        IF(from_account_id <= 0 OR from_account_id > (SELECT MAX(id) FROM accounts))
            THEN ROLLBACK;
        ELSEIF(to_account_id <= 0 OR to_account_id > (SELECT MAX(id) FROM accounts))
            THEN ROLLBACK;
        ELSEIF(amount <= 0)
            THEN ROLLBACK;
        ELSEIF((SELECT balance FROM accounts WHERE id = from_account_id) < 0)
            THEN ROLLBACK;
        ELSEIF(from_account_id = to_account_id)
            THEN ROLLBACK;
        ELSE
            COMMIT ;
        END IF;
end $$

CALL usp_transfer_money(1,2,10);
SELECT a.id AS account_id,
       a.account_holder_id AS account_holder_id,
       a.balance
FROM accounts AS a
WHERE id IN(1,2);
