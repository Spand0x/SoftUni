USE football_scout;
SELECT p.id,
       CONCAT(p.first_name, ' ', p.last_name) AS full_name,
       p.age,
       p.position,
       p.hire_date
FROM players as p
         JOIN skills_data sd on p.skills_data_id = sd.id
WHERE age < 23
  AND position = 'A'
  AND hire_date IS NULL
  AND sd.strength > 50
ORDER BY salary,age;
