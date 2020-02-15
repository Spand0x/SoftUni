CREATE DATABASE company;
USE company;
CREATE TABLE clients(
    id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    client_name VARCHAR(100) NOT NULL
);
CREATE TABLE projects(
    id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    client_id INT NOT NULL,
    project_lead_id INT NOT NULL,
    CONSTRAINT fk_client_id
    FOREIGN KEY (client_id)
    REFERENCES clients(id)
);
CREATE TABLE employees(
    id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    project_id INT,
    CONSTRAINT fk_employee_project
    FOREIGN KEY (project_id)
    REFERENCES projects(id)
);
ALTER TABLE projects
    ADD CONSTRAINT fk_project_employee
    FOREIGN KEY (project_lead_id)
    REFERENCES employees(id);