USE cjms;
SELECT p.name,
       COUNT(*) AS journeys_count
FROM planets AS p
JOIN spaceports s on p.id = s.planet_id
JOIN journeys j on s.id = j.destination_spaceport_id
GROUP BY p.name
ORDER BY journeys_count DESC,p.name;