CREATE DATABASE soft_uni;
USE soft_uni;
CREATE TABLE towns(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);
CREATE TABLE addresses(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    address_text VARCHAR(20) NOT NULL,
    town_id INT NOT NULL,
	CONSTRAINT fk_addresses_towns FOREIGN KEY (town_id)
		REFERENCES towns(id)
);
CREATE TABLE departments(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);
CREATE TABLE employees(
	id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    middle_name VARCHAR(20),
    last_name VARCHAR(20) NOT NULL,
    job_title VARCHAR(20) NOT NULL,
    department_id INT,
    hire_date DATE,
    salary DOUBLE(10,2),
    address_id INT,
    CONSTRAINT fk_employees_departments FOREIGN KEY (department_id)
		REFERENCES departments(id),
	CONSTRAINT fk_employees_addresses FOREIGN KEY (address_id)
		REFERENCES addresses(id)
);