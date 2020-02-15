USE colonial;
CREATE PROCEDURE udp_like_article(username VARCHAR(30), title VARCHAR(30))
BEGIN
    IF ((SELECT COUNT(u.username) FROM users AS u WHERE username = u.username) = 0)
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Non-existent user.';
    ELSEIF ((SELECT COUNT(a.title) FROM articles AS a WHERE title = a.title) = 0)
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Non-existent article.';
    ELSE
        INSERT INTO likes(article_id, comment_id, user_id)
        SELECT (SELECT a.id FROM articles AS a WHERE a.title = title)    AS article_id,
               NULL                                                      AS comment_id,
               (SELECT u.id FROM users AS u WHERE u.username = username) AS user_id;
    end if;
end ;
CALL udp_like_article('BlaAntigadsa', 'Donnybrook, Victoria');
SELECT a.title, u.username
FROM articles a
         JOIN likes l
              ON a.id = l.article_id
         JOIN users u
              ON l.user_id = u.id
WHERE u.username = 'BlaAntigadsa'
  AND a.title = 'Donnybrook, Victoria';
