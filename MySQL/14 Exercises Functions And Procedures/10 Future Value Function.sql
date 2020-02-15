USE soft_uni;
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19,4),yearly_interest_rate DOUBLE, number_of_years INT)
RETURNS  DOUBLE
BEGIN
    RETURN (sum) * (POW(1+yearly_interest_rate,number_of_years));
end $$

SELECT ufn_calculate_future_value(1000,0.1,5);

