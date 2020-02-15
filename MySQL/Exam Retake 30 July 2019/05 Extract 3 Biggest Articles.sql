USE colonial;
SELECT a.title,
       CONCAT(LEFT(content, 20), '...') AS summary
FROM (SELECT id, title, LENGTH(content), content
    FROM articles
    ORDER BY LENGTH(content) DESC
    LIMIT 3)
    AS a
ORDER BY a.id
LIMIT 3;