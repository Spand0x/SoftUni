USE soft_uni;
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(in_salary DECIMAL(19,4))
BEGIN
 SELECT e.first_name,e.last_name
        FROM employees AS e
            WHERE e.salary >= in_salary
    ORDER BY e.first_name,e.last_name,e.employee_id;
end $$

CALL usp_get_employees_salary_above(48100);