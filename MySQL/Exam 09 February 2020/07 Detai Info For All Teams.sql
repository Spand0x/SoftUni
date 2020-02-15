USE football_scout;
SELECT t.name,
       t.established,
       t.fan_base,
       COUNT(p.id) AS count_of_players
FROM teams AS t
LEFT JOIN players p on t.id = p.team_id
GROUP BY t.name, t.established, t.fan_base
ORDER BY count_of_players DESC ,fan_base DESC ;