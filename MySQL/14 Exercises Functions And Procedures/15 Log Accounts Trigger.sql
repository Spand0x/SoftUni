USE soft_uni;
CREATE TABLE `logs` (
    `log_id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `account_id` INT(11) NOT NULL,
    `old_sum` DECIMAL(19, 4) NOT NULL,
    `new_sum` DECIMAL(19, 4) NOT NULL
);
CREATE TRIGGER tr_balance_update
    AFTER UPDATE
    ON accounts
    FOR EACH ROW
BEGIN
    INSERT INTO logs(account_id, old_sum, new_sum)
    VALUES (OLD.id,OLD.balance,NEW.balance);
end;