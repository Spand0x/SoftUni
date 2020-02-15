USE football_scout;
SELECT MAX(sd.speed) AS max_speed,
       tw.name
FROM players AS p
    RIGHT JOIN skills_data sd on p.skills_data_id = sd.id
    RIGHT JOIN teams t on p.team_id = t.id
    RIGHT JOIN stadiums s on t.stadium_id = s.id
    RIGHT JOIN towns tw on s.town_id = tw.id
WHERE t.name != 'Devify'
GROUP BY tw.name
ORDER BY max_speed DESC, tw.name;