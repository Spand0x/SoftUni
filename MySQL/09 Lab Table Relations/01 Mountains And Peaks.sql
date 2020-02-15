USE camp;
CREATE TABLE mountains(
    id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL
);
CREATE TABLE peaks(
    id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    mountain_id INT NOT NULL,
    CONSTRAINT fk_peaks_mountain
    FOREIGN KEY (mountain_id)
    REFERENCES mountains(id)
);