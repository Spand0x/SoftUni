USE colonial;
CREATE FUNCTION udf_users_articles_count(username VARCHAR(30))
    RETURNS INT
BEGIN
    DECLARE count INT;
    SET count := (
        SELECT COUNT(*)
        FROM articles
                 JOIN users_articles ua on articles.id = ua.article_id
                 JOIN users u on ua.user_id = u.id
        WHERE u.username = username
    );
    RETURN count;
end;

SELECT u.username, udf_users_articles_count('UnderSinduxrein') AS count
FROM articles AS a
JOIN users_articles ua
ON a.id = ua.article_id
JOIN users u
ON ua.user_id = u.id
WHERE u.username = 'UnderSinduxrein'
GROUP BY u.id;
