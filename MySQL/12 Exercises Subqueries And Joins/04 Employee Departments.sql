USE soft_uni;
SELECT employee_id,
       first_name,
       salary,
       d.name
FROM employees
JOIN departments d ON d.department_id = employees.department_id
WHERE salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;