USE soft_uni;
CREATE VIEW v_employees_hired_after_2000(first_name,last_name) AS
    SELECT first_name,last_name FROM employees
    WHERE YEAR(hire_date) > 2000;
SELECT * FROM v_employees_hired_after_2000;