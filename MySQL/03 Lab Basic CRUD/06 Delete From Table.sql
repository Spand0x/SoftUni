USE hospital;
DELETE FROM employees
	WHERE department_id = 1 OR department_id = 2
    ORDER BY id;
    SELECT * FROM employees ORDER BY id; 