USE soft_uni;
SELECT e.employee_id,
       first_name,
       p.name
FROM employees AS e
JOIN employees_projects AS ep ON ep.employee_id = e.employee_id
JOIN projects AS p ON p.project_id = ep.project_id
WHERE DATE(p.start_date) > '2002/08/13' AND p.end_date IS NULL
ORDER BY first_name,p.name
LIMIT 5;