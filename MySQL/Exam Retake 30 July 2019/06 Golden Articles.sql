USE colonial;
SELECT id AS article_id,
       title
    FROM articles
JOIN users_articles ua on articles.id = ua.article_id
WHERE id = ua.user_id
ORDER BY id;