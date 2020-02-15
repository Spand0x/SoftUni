USE colonial;
SELECT a.title,
       COUNT(c.id) AS comments
FROM articles AS a
JOIN comments c on a.id = c.article_id
JOIN categories c2 on a.category_id = c2.id
WHERE c2.category = 'Social'
GROUP BY a.id
ORDER BY comments DESC
LIMIT 1;