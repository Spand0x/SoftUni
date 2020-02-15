USE colonial;
UPDATE comments as c
SET c.comment =  (CASE
    WHEN c.id % 2 = 0 THEN 'Very good article.'
    WHEN c.id % 3 = 0 THEN 'This is interesting.'
    WHEN c.id % 5 = 0 THEN 'I definitely will read the article again.'
    WHEN c.id % 7 = 0 THEN 'The universe is such an amazing thing.'
    ELSE c.comment
    END
    )
WHERE c.id BETWEEN 1 AND 15;