USE colonial;
SELECT c.category,
       COUNT(a.category_id) AS articls,
       (SELECT COUNT(l.article_id)
           FROM likes AS l
           JOIN articles a2 on l.article_id = a2.id
           JOIN categories c2 on a2.category_id = c2.id
           WHERE c.id = c2.id) AS likes
FROM categories AS c
JOIN articles a on c.id = a.category_id
GROUP BY c.id
ORDER BY likes DESC, articls DESC,c.id;