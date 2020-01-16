USE minions;
ALTER TABLE users
	DROP primary key,
    ADD CONSTRAINT PRIMARY KEY (id),
    ADD CONSTRAINT UNIQUE (username);