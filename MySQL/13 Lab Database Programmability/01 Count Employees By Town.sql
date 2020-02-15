USE soft_uni;
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(45))
    RETURNS INT
BEGIN
    DECLARE e_count DOUBLE;
    SET e_count := (
        SELECT COUNT(e.employee_id)
        FROM employees AS e
        JOIN addresses AS a ON e.address_id = a.address_id
        JOIN towns AS t ON a.town_id = t.town_id
        WHERE t.name = town_name);
    RETURN e_count;
end;