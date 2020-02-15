USE soft_uni;
CREATE TABLE notification_emails
(
    id        INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    recipient INT,
    subject   VARCHAR(40),
    body      TEXT
);
CREATE TRIGGER tr_notification_emails
    AFTER UPDATE
    ON accounts
    FOR EACH ROW
BEGIN
    INSERT INTO notification_emails(recipient, subject, body)
    VALUES (OLD.id,
            CONCAT('Balance change for account: ',OLD.id),
            CONCAT('ON ',NOW(),' your balance was changed from ',OLD.balance,' to ', NEW.balance,'.'));
end;
UPDATE `accounts`
SET `balance` = `balance` + 10
WHERE `id` = 1;