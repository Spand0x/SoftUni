USE cjms;
SELECT s.name,
       s.manufacturer
FROM spaceships AS s
         JOIN journeys j on s.id = j.spaceship_id
         JOIN travel_cards tc on j.id = tc.journey_id
         JOIN colonists c on tc.colonist_id = c.id
WHERE c.birth_date > DATE_SUB('2019-01-01', INTERVAL 30 YEAR) AND tc.job_during_journey = 'Pilot'
GROUP BY s.name
ORDER BY s.name;