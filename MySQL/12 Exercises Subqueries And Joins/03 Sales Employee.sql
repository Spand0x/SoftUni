USE soft_uni;
SELECT employee_id,
       first_name,
       last_name,
       d.name
FROM employees
JOIN departments d ON d.department_id = employees.department_id
WHERE d.name = 'Sales'
ORDER BY employee_id DESC;