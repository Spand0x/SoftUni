USE soft_uni;
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with (start_string_town VARCHAR(40))
BEGIN
   SELECT t.name FROM towns AS t
    WHERE t.name LIKE CONCAT(start_string_town,'%')
   ORDER BY t.name;
end $$

CALL usp_get_towns_starting_with('b');
