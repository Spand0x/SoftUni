USE minions;
CREATE TABLE users(
	id INT UNIQUE AUTO_INCREMENT NOT NULL PRIMARY KEY,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(26) NOT NULL,
    profile_picture BLOB,
    last_login_time TIMESTAMP,
    is_deleted BOOLEAN
);
INSERT INTO users(username,password,last_login_time,is_deleted)
	VALUES ('Gosho','GoshoPass',NOW(),FALSE),
    ('Pesho','PeshoPass',NOW(),FALSE),
    ('Tisho','TishoPass',NOW(),TRUE),
    ('Maria','MariaPass',NOW(),FALSE),
    ('Penka','PenkaPass',NOW(),TRUE);