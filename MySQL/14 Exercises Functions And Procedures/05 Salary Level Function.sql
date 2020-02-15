USE soft_uni;
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(employee_salary DECIMAL(19,4))
RETURNS VARCHAR(10)
BEGIN
    RETURN CASE
        WHEN employee_salary<30000 THEN 'Low'
        WHEN employee_salary BETWEEN 30000 AND 50000 THEN 'Average'
        ELSE 'High'
        END;
end $$
SELECT ufn_get_salary_level(13500.00);
SELECT ufn_get_salary_level(43300.00);
SELECT ufn_get_salary_level(125500.00);