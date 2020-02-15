USE cjms;
UPDATE journeys AS j
SET j.purpose = (
    CASE
        WHEN j.id % 2 THEN 'Medical'
        WHEN j.id % 3 THEN 'Technical'
        WHEN j.id % 5 THEN 'Educational'
        WHEN j.id % 7 THEN 'Military'
        ELSE j.purpose
        END
    );