USE soft_uni;
SELECT first_name,
       last_name,
       hire_date,
       d.name
FROM employees AS e
JOIN departments AS d ON e.department_id = d.department_id
WHERE DATE(e.hire_date) > '1999/1/1' AND
      d.name IN('Sales','Finance')
ORDER BY hire_date;