USE colonial;
INSERT INTO likes(article_id, comment_id, user_id)
SELECT IF (u.id % 2 = 0,LENGTH(u.username),NULL) AS article_id,
       IF (u.id % 2 = 0,NULL,LENGTH(u.email)) AS comment_id,
       u.id AS user_id
FROM users AS u
WHERE u.id BETWEEN 16 AND 20;