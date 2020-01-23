USE book_library;
SELECT concat_ws(' ',first_name,last_name) AS 'Full Name',
	timestampdiff(DAY,born,died) 'Days Lived'
FROM authors;