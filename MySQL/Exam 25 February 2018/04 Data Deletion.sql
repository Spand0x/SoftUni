USE buhtig;
DELETE FROM repositories AS r
WHERE r.id NOT IN( SELECT repository_id FROM issues);