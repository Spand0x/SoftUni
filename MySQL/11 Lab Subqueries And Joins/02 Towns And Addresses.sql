USE soft_uni;
SELECT t.town_id,
       t.name,
       a.address_text
FROM towns AS t
INNER JOIN addresses AS a
    ON a.town_id = t.town_id
WHERE t.name IN('San Francisco','Sofia','Carnation')
ORDER BY t.town_id,a.address_id;