USE soft_uni;
SELECT town_id,name FROM towns
WHERE name REGEXP '^[MmKkBbEe]'
ORDER BY name;
