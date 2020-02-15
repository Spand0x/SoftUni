USE cjms;
SELECT tc.job_during_journey AS job_name
FROM travel_cards AS tc
WHERE tc.journey_id = (
    SELECT id FROM journeys
    ORDER BY DATEDIFF(journey_start, journey_end)
    LIMIT 1
)
GROUP BY tc.job_during_journey
ORDER BY COUNT(*)
LIMIT 1;

