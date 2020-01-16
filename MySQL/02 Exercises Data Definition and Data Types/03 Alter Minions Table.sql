USE minions;
ALTER TABLE minions
	ADD town_id INT NOT NULL;
ALTER TABLE minions
	ADD CONSTRAINT town_id
	FOREIGN KEY (town_id) REFERENCES towns(id);