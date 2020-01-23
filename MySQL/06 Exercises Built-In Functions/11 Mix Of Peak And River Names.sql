USE geography;
SELECT peak_name,
       river_name,
       LOWER(CONCAT(peak_name,SUBSTRING(river_name,2))) AS MIX
       FROM peaks,rivers
    WHERE RIGHT(peak_name,1) = LEFT(river_name,1);