USE buhtig;
SELECT i.id,
       CONCAT(u.username, ' : ', i.title) AS issue_assignee
FROM issues AS i
JOIN users u on i.assignee_id = u.id
ORDER BY i.id DESC ;