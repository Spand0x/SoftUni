USE bank;
DELIMITER $$
CREATE PROCEDURE udp_clientinfo(full_name VARCHAR(40))
BEGIN
    SELECT full_name,age,ba.account_number,CONCAT('$',ba.balance)
        FROM bank_accounts AS ba
    JOIN clients AS c ON ba.client_id = c.id
    WHERE c.full_name = full_name;
end $$
CALL udp_clientinfo('Hunter Wesgate');