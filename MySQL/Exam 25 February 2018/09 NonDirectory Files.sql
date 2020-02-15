USE buhtig;
SELECT f.id,
       f.name,
       CONCAT(f.size,'KB') AS size
FROM files AS f
LEFT JOIN files AS d ON f.id = d.parent_id
WHERE d.id IS NULL
ORDER BY f.id;