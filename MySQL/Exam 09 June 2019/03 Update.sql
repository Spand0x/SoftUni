USE bank;
UPDATE employees_clients AS ec
JOIN (
    SELECT ec2.employee_id FROM employees_clients AS ec2
    GROUP BY ec2.employee_id
    ORDER BY COUNT(ec2.client_id),ec2.employee_id
    LIMIT 1
        ) AS 'result'
SET ec.employee_id = result.employee_id
WHERE ec.employee_id = ec.client_id;
