USE minions;
CREATE TABLE people(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture BLOB,
    height DOUBLE(3,2),
    weight DOUBLE(3,2),
    gender ENUM('m','f') NOT NULL,
    birthdate DATE NOT NULL,
    biography LONGTEXT    
);
INSERT INTO people(name,gender,birthdate) 
	VALUES
    ('Pesho', 'm' , '1980-02-11'),
    ('Gosho', 'm' , '1981-05-17'),
    ('Mitko', 'm' , '1982-07-15'),
    ('Sasha', 'f' , '1983-01-20'),
    ('Tosho', 'm' , '1984-09-30');