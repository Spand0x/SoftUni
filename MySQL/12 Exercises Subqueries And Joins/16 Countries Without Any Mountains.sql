USE geography;
SELECT COUNT(c.country_code)
FROM countries AS c
LEFT JOIN mountains_countries mc on c.country_code = mc.country_code
WHERE mc.mountain_id IS NULL;