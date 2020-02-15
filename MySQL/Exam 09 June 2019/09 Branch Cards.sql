USE bank;
SELECT b.name,
       COUNT(c.id) AS count_of_cards
FROM branches AS b
LEFT JOIN employees AS e ON b.id = e.branch_id
LEFT JOIN employees_clients AS ec on e.id = ec.employee_id
LEFT JOIN bank_accounts AS ba on ec.client_id = ba.client_id
LEFT JOIN cards AS c on ba.id = c.bank_account_id
GROUP BY b.name
ORDER BY count_of_cards DESC,b.name;