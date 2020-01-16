CREATE DATABASE car_rental;
USE car_rental;
CREATE TABLE categories(
	id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    category VARCHAR(30) NOT NULL,
    daily_rate DOUBLE NOT NULL,
    weekly_rate DOUBLE NOT NULL,
    monthly_rate DOUBLE NOT NULL,
    weekend_rate DOUBLE NOT NULL    
);

INSERT INTO categories(id,category,daily_rate,weekly_rate,monthly_rate,weekend_rate)
VALUES
	(1,"ACTION",2.2,14.0,200.5,8.6),
	(2,"ACTION",5.2,20.0,220.5,12.6),
	(3,"ACTION",8.2,30.0,260.5,19.6);

CREATE TABLE cars(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
    plate_number VARCHAR(20) NOT NULL, 
    make VARCHAR(20) NOT NULL, 
    model VARCHAR(20) NOT NULL, 
    car_year YEAR NOT NULL, 
    category_id INT NOT NULL, 
    doors TINYINT NOT NULL, 
    picture BLOB, 
    car_condition VARCHAR(20),
	available BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO cars (id, plate_number, make, model, car_year, category_id, doors)
VALUES
	(1,"ASD123","make 1","model 1", 2020, 1, 2),
	(2,"ASD456","make 2","model 2", 2020, 2, 4),
	(3,"ASD789","make 3","model 3", 2020, 3, 5);

CREATE TABLE employees(
	id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT, 
    first_name VARCHAR(20) NOT NULL, 
    last_name VARCHAR(20) NOT NULL, 
    title VARCHAR(20) NOT NULL, 
    notes TEXT
);

INSERT INTO employees (id, first_name, last_name, title)
VALUES
	(1,"Gosho", "Goshev", "Mr"),
	(2,"Pesho", "Goshev", "Mr"),
	(3,"Maria", "Gosheva", "Mrs");
    
CREATE TABLE customers(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
	driver_licence_number VARCHAR(30) NOT NULL, 
	full_name VARCHAR(60) NOT NULL, 
	address VARCHAR(50) NOT NULL, 
	city VARCHAR(20) NOT NULL, 
	zip_code INT(4) NOT NULL, 
	notes TEXT
);

INSERT INTO customers (id, driver_licence_number, full_name, address, city, zip_code)
VALUES
	(1,"ASD132","Penka Pesheva","address 1","Sofia","1111"),
	(2,"ASD465","Maria Pesheva","address 2","Sofia","1112"),
	(3,"ASD789","Goshka Pesheva","address 3","Sofia","1113");
    
CREATE TABLE rental_orders(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
    employee_id INT NOT NULL, 
    customer_id INT NOT NULL, 
    car_id INT NOT NULL, 
    car_condition VARCHAR(20), 
    tank_level DOUBLE,
	kilometrage_start DOUBLE, 
    kilometrage_end DOUBLE, 
    total_kilometrage DOUBLE, 
    start_date DATE, 
    end_date DATE,
	total_days INT, 
    rate_applied DOUBLE, 
    tax_rate DOUBLE, 
    order_status VARCHAR(30), 
    notes TEXT
    );
    
INSERT INTO rental_orders(id, employee_id, customer_id, car_id, start_date)
VALUES
	(1,1,1,1,NOW()),
	(2,2,2,2,NOW()),
	(3,3,3,3,NOW());
