USE cjms;
CREATE FUNCTION udf_count_colonists_by_destination_planet(planet_name VARCHAR(30))
RETURNS INT
BEGIN
    DECLARE counter INT;
    SET counter := (SELECT COUNT(*) FROM colonists AS c
    JOIN travel_cards AS tc ON c.id = tc.colonist_id
    JOIN journeys AS j ON tc.journey_id = j.id
    JOIN spaceports AS sp ON j.destination_spaceport_id = sp.id
    JOIN planets AS p ON sp.planet_id = p.id
    WHERE p.name = planet_name);
    RETURN counter;
end;

SELECT p.name, udf_count_colonists_by_destination_planet('Otroyphus') AS count
FROM planets AS p
WHERE p.name = 'Otroyphus';
