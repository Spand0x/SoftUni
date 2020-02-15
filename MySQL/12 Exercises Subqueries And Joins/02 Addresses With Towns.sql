USE soft_uni;
SELECT first_name,
       last_name,
       t.name,
       address_text
FROM employees AS e
INNER JOIN addresses a on e.address_id = a.address_id
JOIN towns t on a.town_id = t.town_id
ORDER BY first_name,last_name
LIMIT 5;
