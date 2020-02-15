USE cjms;
SELECT s.name,
       s2.name
FROM spaceships AS s
JOIN journeys j on s.id = j.spaceship_id
JOIN spaceports s2 on j.destination_spaceport_id = s2.id
ORDER BY s.light_speed_rate DESC
LIMIT 1;