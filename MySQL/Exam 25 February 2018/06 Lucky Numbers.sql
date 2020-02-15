USE buhtig;
SELECT repository_id,contributor_id FROM repositories_contributors
WHERE repository_id = contributor_id
ORDER BY repository_id;