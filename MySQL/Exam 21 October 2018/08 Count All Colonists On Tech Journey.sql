USE cjms;
SELECT COUNT(*)
FROM colonists
JOIN travel_cards tc on colonists.id = tc.colonist_id
JOIN journeys j on tc.journey_id = j.id
WHERE j.purpose = 'Technical';