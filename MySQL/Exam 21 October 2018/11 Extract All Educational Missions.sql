USE cjms;
SELECT p.name,
       sp.name
FROM planets AS p
JOIN spaceports AS sp ON p.id = sp.planet_id
JOIN journeys j on sp.id = j.destination_spaceport_id
WHERE j.purpose = 'Educational'
ORDER BY sp.name DESC;