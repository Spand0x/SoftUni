USE bank;
DELIMITER $$
CREATE FUNCTION udf_client_cards_count(name VARCHAR(30))
    RETURNS INT
BEGIN
    DECLARE c_count INT;
    SET c_count := (
        SELECT COUNT(ca.bank_account_id)
        FROM clients AS c
                 JOIN bank_accounts ba on c.id = ba.client_id
                 JOIN cards ca on ba.id = ca.bank_account_id
        WHERE full_name = name);
    RETURN c_count;
end$$

SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards` FROM clients c
WHERE c.full_name = 'Baxy David';
