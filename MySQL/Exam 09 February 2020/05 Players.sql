USE football_scout;
SELECT p.first_name,
       p.age,
       p.salary
FROM players AS p
ORDER BY p.salary DESC;