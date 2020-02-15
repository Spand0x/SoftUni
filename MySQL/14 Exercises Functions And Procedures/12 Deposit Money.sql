USE soft_uni;
DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DOUBLE(19, 4))
BEGIN
    START TRANSACTION;
    UPDATE accounts AS ac
    SET ac.balance = ac.balance + money_amount
    WHERE ac.id = account_id;
    IF(money_amount < 0) THEN ROLLBACK;
        END IF;
END $$

CALL usp_deposit_money(1,10);