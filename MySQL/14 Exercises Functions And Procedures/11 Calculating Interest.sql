USE soft_uni;


DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19,4),yearly_interest_rate DOUBLE, number_of_years INT)
RETURNS  DECIMAL(19,4)
BEGIN
    RETURN (sum) * (POW(1+yearly_interest_rate,number_of_years));
end $$

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest_rate DECIMAL(19,4))
BEGIN

SELECT a.id AS account_id,
       ac.first_name,
       ac.last_name,
       a.balance AS current_balance,
       ROUND(ufn_calculate_future_value(a.balance,interest_rate,5),4) AS balance_in_5_years
       FROM account_holders AS ac
        JOIN accounts AS a ON ac.id = a.account_holder_id
        WHERE a.id = account_id;
end $$

CALL usp_calculate_future_value_for_account(1,0.1);