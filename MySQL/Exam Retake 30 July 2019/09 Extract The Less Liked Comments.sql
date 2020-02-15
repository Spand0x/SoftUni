USE colonial;
SELECT CONCAT(substring(c.comment,1,20),'...') AS summary
FROM comments AS c
LEFT JOIN likes l on c.id = l.comment_id
WHERE l.comment_id IS NULL
ORDER BY c.id DESC;