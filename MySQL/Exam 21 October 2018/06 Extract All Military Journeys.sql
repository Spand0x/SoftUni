USE cjms;
SELECT id,
       journey_start,
       journey_end
FROm journeys
WHERE purpose = 'Military'
ORDER BY journey_start;