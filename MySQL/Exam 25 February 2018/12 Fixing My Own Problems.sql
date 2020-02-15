USE buhtig;
SELECT u.id,
       u.username,
       (SELECT COUNT(c.id) FROM commits AS c
           JOIN issues i on c.issue_id = i.id
           WHERE  u.id = i.assignee_id AND c.contributor_id = u.id ) AS commits
FROM users AS u
LEFT JOIN commits c on u.id = c.contributor_id
GROUP BY u.id
ORDER BY commits DESC, u.id;