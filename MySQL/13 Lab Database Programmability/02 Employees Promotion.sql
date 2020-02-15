USE soft_uni;
DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(45))
BEGIN
    UPDATE employees AS e
    JOIN departments AS d on e.department_id = d.department_id
    SET salary = salary * 1.05
    WHERE d.name = department_name;
end $$