CREATE DATABASE exercises;
USE exercises;
CREATE TABLE persons
(
    person_id   INT NOT NULL UNIQUE AUTO_INCREMENT,
    first_name  VARCHAR(20),
    salary      DECIMAL(10, 2),
    passport_id INT UNIQUE
);
CREATE TABLE passports
(
    passport_id     INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    passport_number VARCHAR(20) UNIQUE
);
ALTER TABLE passports AUTO_INCREMENT=101;
INSERT INTO persons(first_name, salary, passport_id)
VALUES ('Roberto', 43300, 102),
       ('Tom', 56100, 103),
       ('Yana', 60200, 101);

INSERT INTO passports(passport_number)
    VALUES ('N34FG21B'),
           ('K65LO4R7'),
           ('ZE657QP2');
ALTER TABLE persons
    ADD CONSTRAINT pk_persons
        PRIMARY KEY (person_id),
    ADD CONSTRAINT fk_passport_id
        FOREIGN KEY (passport_id)
            REFERENCES passports (passport_id);
