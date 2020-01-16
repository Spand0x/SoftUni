CREATE DATABASE Movies;
USE Movies;
CREATE TABLE directors(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    director_name VARCHAR(30) NOT NULL,
    notes TEXT
);
CREATE TABLE genres(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    genre_name VARCHAR(30) NOT NULL,
    notes TEXT
);
CREATE TABLE categories(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    category_name VARCHAR(30) NOT NULL,
    notes TEXT
);
CREATE TABLE movies(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    title VARCHAR(30) NOT NULL,
    director_id INT NOT NULL,
    copyright_year YEAR NOT NULL,
    length TIME NOT NULL,
    genre_id INT NOT NULL,
    category_id INT NOT NULL,
    rating DOUBLE NOT NULL DEFAULT 0,
    notes TEXT
);

INSERT INTO directors(id,director_name,notes)
VALUES
	(1,"Gosho","Nice Movie 1"),
	(2,"Pesho","Nice Movie 2"),
	(3,"Maria","Nice Movie 3"),
	(4,"Tosho","Nice Movie 4"),
	(5,"Penka","Nice Movie 5");
    
INSERT INTO genres(id,genre_name,notes)
VALUES
	(1,"Action","What a Movie 1"),
	(2,"Action","What a Movie 2"),
	(3,"Action","What a Movie 3"),
	(4,"Action","What a Movie 4"),
	(5,"Action","What a Movie 5");
    
INSERT INTO categories(id,category_name)
VALUES
	(1,"Fun Movie 1"),
	(2,"Fun Movie 2"),
	(3,"Fun Movie 3"),
	(4,"Fun Movie 4"),
	(5,"Fun Movie 5");
    
    INSERT INTO movies(id,title,director_id,copyright_year,length,genre_id,category_id)
    VALUES
		(1,"Gosho's Mission",1,2020,2,1,1),
		(2,"Pesho's Mission",2,2020,2,2,2),
		(3,"Maria's Mission",3,2020,2,3,3),
		(4,"Tosho's Mission",4,2020,2,4,4),
		(5,"Penka's Mission",5,2020,2,5,5);