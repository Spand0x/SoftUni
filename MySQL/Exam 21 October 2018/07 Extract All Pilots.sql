USE cjms;
SELECT c.id,
       CONCAT(c.first_name,' ',c.last_name) AS full_name
FROM colonists AS c
JOIN travel_cards tc on c.id = tc.colonist_id
WHERE tc.job_during_journey = 'Pilot'
ORDER BY id;