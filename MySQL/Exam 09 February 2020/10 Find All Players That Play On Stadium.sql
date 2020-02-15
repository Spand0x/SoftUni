USE football_scout;
CREATE FUNCTION udf_stadium_players_count(stadium_name VARCHAR(30))
RETURNS INT
BEGIN
    DECLARE result INT;
    SET result := (
        SELECT COUNT(p.first_name) FROM players AS p
        RIGHT JOIN teams t on p.team_id = t.id
        RIGHT JOIN stadiums s on t.stadium_id = s.id
        WHERE s.name = stadium_name
        group by s.name
        );
    RETURN result;
end;