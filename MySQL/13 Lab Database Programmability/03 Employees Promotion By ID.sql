USE soft_uni;
CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN
    START TRANSACTION;
    IF ((SELECT count(employee_id)
         FROM employees
         WHERE employee_id like id) <> 1) THEN
        ROLLBACK;
    ELSE
        UPDATE employees AS e
        SET salary = salary * 1.05
        WHERE e.employee_id = id;
    end if;
end;