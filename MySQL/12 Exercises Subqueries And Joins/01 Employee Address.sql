USE soft_uni;
SELECT employee_id,
       job_title,
       employees.address_id,
       address_text
FROM employees
INNER JOIN addresses ON employees.address_id = addresses.address_id
ORDER BY addresses.address_id
LIMIT 5;