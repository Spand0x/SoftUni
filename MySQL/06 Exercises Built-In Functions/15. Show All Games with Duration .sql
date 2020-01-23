USE diablo;
SELECT name AS 'game',
        IF(HOUR(start)>=0 AND HOUR(start) <12,'Morning',
            IF(HOUR(start)>=12 AND HOUR(start)<18,'Afternoon','Evening'))
            AS 'Part Of The Day',
       IF(duration<=3,'Extra Short',
           IF(duration>3 AND duration<=6,'Short',
           IF(duration>6 AND duration<=10,'Long','Extra Long')))
            AS 'Duration'
FROM games;

SELECT name AS game,
       CASE
            WHEN HOUR(start) BETWEEN 0 AND 11 THEN 'Morning'
            WHEN HOUR(start) BETWEEN 12 AND 17 THEN 'Afternoon'
            ELSE 'Evening'
        END AS 'Part of the Day',
       CASE
            WHEN duration <= 3 THEN 'Extra Short'
            WHEN duration BETWEEN 3 and 6 THEN 'Short'
            WHEN duration BETWEEN 7 and 10 THEN 'Long'
            ELSE 'Extra Long'
        END AS 'Duration'
FROM games;