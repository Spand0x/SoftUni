CREATE DATABASE Hotel;
USE Hotel;
CREATE TABLE employees(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
    first_name VARCHAR(30) NOT NULL, 
    last_name VARCHAR(30) NOT NULL, 
    title VARCHAR(30) NOT NULL, 
    notes TEXT
);
INSERT INTO employees (first_name, last_name, title)
VALUES
	("Pesho","Peshov","Mr."),
	("Gosho","Peshov","Mr."),
	("Tosho","Peshov","Mr.");
    
CREATE TABLE customers(
	account_number INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
    first_name VARCHAR(30) NOT NULL, 
    last_name VARCHAR(30) NOT NULL, 
    phone_number VARCHAR(30) NOT NULL, 
    emergency_name VARCHAR(30),
	emergency_number VARCHAR(30), 
    notes TEXT
);
INSERT INTO customers (first_name, last_name, phone_number)
VALUES
	("Pesho","Name","333"),
	("Gosho","Name","333"),
	("Tosho","Name","333");
CREATE TABLE room_status(
	room_status VARCHAR(30) PRIMARY KEY NOT NULL UNIQUE, 
    notes TEXT
);
INSERT INTO room_status(room_status)
VALUES
	("Occupied"),
	("For Clean"),
	("Free");
CREATE TABLE room_types(
	room_type VARCHAR(30) PRIMARY KEY NOT NULL UNIQUE, 
    notes TEXT
);
INSERT INTO room_types(room_type)
VALUES
	("Double"),
	("Single"),
	("Apartment");
CREATE TABLE bed_types(
	bed_type VARCHAR(30) PRIMARY KEY NOT NULL UNIQUE, 
    notes TEXT
);
INSERT INTO bed_types(bed_type)
VALUES
	("King"),
	("Single"),
	("Queen");
CREATE TABLE rooms(
	room_number INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
    room_type VARCHAR(30) NOT NULL, 
    bed_type VARCHAR(30) NOT NULL, 
    rate DOUBLE DEFAULT 0, 
    room_status VARCHAR(30) NOT NULL, 
    notes TEXT
);
INSERT INTO rooms(room_type,bed_type,room_status)
VALUES
	("Double","King","Free"),
	("Double","King","Free"),
	("Double","King","Free");
CREATE TABLE payments(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
    employee_id INT NOT NULL, 
    payment_date DATE NOT NULL, 
    account_number INT NOT NULL, 
    first_date_occupied DATE,
	last_date_occupied DATE, 
    total_days INT, 
    amount_charged DOUBLE, 
    tax_rate DOUBLE, 
    tax_amount DOUBLE, 
    payment_total DOUBLE,
	notes TEXT
);
INSERT INTO payments(employee_id,payment_date,account_number)
VALUES
	(1,CURDATE(),123),
	(2,CURDATE(),456),
	(3,CURDATE(),789);
CREATE TABLE occupancies(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
    employee_id INT NOT NULL, 
    date_occupied DATE NOT NULL, 
    account_number INT NOT NULL, 
    room_number INT NOT NULL, 
    rate_applied DOUBLE,
	phone_charge DOUBLE, 
    notes TEXT
);
INSERT INTO occupancies(employee_id,date_occupied,account_number,room_number)
VALUES
	(1,CURDATE(),123,1),
	(2,CURDATE(),456,2),
	(3,CURDATE(),789,3);
