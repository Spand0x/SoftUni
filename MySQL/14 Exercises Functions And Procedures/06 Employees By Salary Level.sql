USE soft_uni;
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(10))
BEGIN
    SELECT e.first_name,e.last_name FROM employees AS e
    WHERE
    CASE
        WHEN salary < 30000 THEN 'Low'
        WHEN salary BETWEEN 30000 AND 50000 THEN 'Average'
        ELSE 'High'
        END = salary_level
    ORDER BY first_name DESC,last_name DESC ;
end $$
CALL usp_get_employees_by_salary_level('high');