USE buhtig;
SELECT r.id,
       r.name,
       (SELECT COUNT(*) FROM commits AS c WHERE c.repository_id = r.id ) AS commits,
       COUNT(rc.contributor_id) AS contributors
FROM repositories AS r
JOIN repositories_contributors rc on r.id = rc.repository_id
GROUP BY r.id
ORDER BY contributors DESC,r.id
LIMIT 1;