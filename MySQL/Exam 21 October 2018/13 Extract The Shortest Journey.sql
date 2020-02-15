USE cjms;
SELECT j.id,
       p.name,
       sp.name,
       j.purpose
FROM journeys AS j
JOIN spaceports sp on j.destination_spaceport_id = sp.id
JOIN planets p on sp.planet_id = p.id
ORDER BY DATEDIFF(j.journey_end,j.journey_start)
LIMIT 1;
