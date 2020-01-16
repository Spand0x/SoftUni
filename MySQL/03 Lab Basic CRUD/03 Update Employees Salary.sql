USE hospital;
UPDATE employees
SET salary = salary * 1.10
WHERE job_title = 'Therapist';
SELECT salary from employees order by salary;