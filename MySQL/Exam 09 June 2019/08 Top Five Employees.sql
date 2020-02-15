USE bank;
SELECT CONCAT(e.first_name,' ',e.last_name) AS name,
       e.started_on,
       COUNT(ec.client_id) AS count_of_clients
FROM employees AS e
JOIN employees_clients AS ec ON e.id = ec.employee_id
GROUP BY employee_id
ORDER BY count_of_clients DESC, employee_id
LIMIT 5;