USE football_scout;
SELECT cn.name,
       COUNT(p.id) AS total_count_of_players,
       SUM(p.salary) AS total_sum_of_salaries
FROM countries AS cn
LEFT JOIN towns t on cn.id = t.country_id
LEFT JOIN stadiums s on t.id = s.town_id
LEFT JOIN teams t2 on s.id = t2.stadium_id
LEFT JOIN players p on t2.id = p.team_id
GROUP BY cn.name
ORDER BY total_count_of_players DESC, cn.name;
