USE football_scout;
UPDATE coaches AS c
    JOIN players_coaches p on c.id = p.coach_id
SET coach_level = coach_level + 1
WHERE LEFT(first_name, 1) = 'A'
  AND c.id IN(p.coach_id);