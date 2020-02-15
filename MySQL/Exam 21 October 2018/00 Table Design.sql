CREATE DATABASE cjms;
USE cjms;
CREATE TABLE planets
(
    id   INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL
);
CREATE TABLE spaceports
(
    id        INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(50) NOT NULL,
    planet_id INT,
    CONSTRAINT fk_spaceports_planets
        FOREIGN KEY (planet_id)
            REFERENCES planets (id)
);
CREATE TABLE spaceships
(
    id               INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name             VARCHAR(50) NOT NULL,
    manufacturer     VARCHAR(30) NOT NULL,
    light_speed_rate INT DEFAULT 0
);
CREATE TABLE colonists
(
    id         INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name  VARCHAR(20) NOT NULL,
    ucn        VARCHAR(10) NOT NULL,
    birth_date DATE        NOT NULL
);

CREATE TABLE journeys
(
    id                       INT                                                   NOT NULL PRIMARY KEY AUTO_INCREMENT,
    journey_start            DATE                                                  NOT NULL,
    journey_end              DATE                                                  NOT NULL,
    purpose                  ENUM ('Medical','Technical','Educational','Military') NOT NULL,
    destination_spaceport_id INT,
    spaceship_id             INT,
    CONSTRAINT fk_journeys_spaceports
        FOREIGN KEY (destination_spaceport_id)
            REFERENCES spaceports (id),
    CONSTRAINT fk_journeys_spaceships
        FOREIGN KEY (spaceship_id)
            REFERENCES spaceships (id)
);
CREATE TABLE travel_cards
(
    id                 INT                                                  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    card_number        VARCHAR(10) UNIQUE                                   NOT NULL,
    job_during_journey ENUM ('Pilot','Engineer','Trooper','Cleaner','Cook') NOT NULL,
    colonist_id        INT,
    journey_id         INT,
    CONSTRAINT fk_travel_cards_colonists
        FOREIGN KEY (colonist_id)
            REFERENCES colonists (id),
    CONSTRAINT fk_travel_cards_journeys
        FOREIGN KEY (journey_id)
            REFERENCES journeys (id)
);