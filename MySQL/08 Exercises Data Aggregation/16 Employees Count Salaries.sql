USE soft_uni;
SELECT COUNT(employee_id)
    FROM employees
    WHERE manager_id IS NULL