USE soft_uni;
DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(in_balance DECIMAL(19, 2))
BEGIN
    SELECT first_name, last_name
    FROM account_holders AS ah
             JOIN accounts AS a ON ah.id = a.account_holder_id
    GROUP BY ah.id
    HAVING SUM(a.balance) > in_balance
    ORDER BY ah.id;
end $$

CALL usp_get_holders_with_balance_higher_than(7000);