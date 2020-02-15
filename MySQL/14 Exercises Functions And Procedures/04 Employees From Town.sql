USE soft_uni;
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(in_town_name VARCHAR(40))
BEGIN
    SELECT e.first_name,e.last_name FROM employees AS e
    JOIN addresses AS a ON e.address_id = a.address_id
    JOIN towns AS t ON a.town_id = t.town_id
    WHERE t.name = in_town_name
    ORDER BY first_name,last_name,e.employee_id;
end $$

CALL usp_get_employees_from_town('Sofia');