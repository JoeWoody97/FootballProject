DROP TABLE IF EXISTS `team` CASCADE;
CREATE TABLE team (
	id BIGINT AUTO_INCREMENT,
	team_name VARCHAR(225),
	captain VARCHAR(225),
	kit_colour VARCHAR(225),
	squad_size INTEGER NOT NULL,
	location VARCHAR(225),
	contact_details VARCHAR(225),
	PRIMARY KEY (id)
);