USE football_scout;
CREATE procedure udp_find_playmaker(min_dribble_points INT, team_name VARCHAR(45))
BEGIN
    SELECT CONCAT(p.first_name, ' ', p.last_name) AS full_name,
           p.age,
           p.salary,
           sd.dribbling,
           sd.speed,
           tm.name                                AS team_name
    FROM players AS p
             JOIN skills_data sd ON p.skills_data_id = sd.id
             JOIN teams tm ON p.team_id = tm.id
    WHERE tm.name = team_name
      AND sd.dribbling > min_dribble_points
      AND speed > (SELECT AVG(sd2.speed) FROM skills_data AS sd2)
    ORDER BY speed DESC
    LIMIT 1;
end;