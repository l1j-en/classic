CREATE TABLE boss_kills (
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	npcid INT (10) NOT NULL,
	boss_name VARCHAR(45) NOT NULL,
	locx INT (10) NOT NULL,
	locy INT (10) NOT NULL,
	mapid INT (10) NOT NULL,
	killer_name VARCHAR (45) NOT NULL,
	clan_name VARCHAR (45),
	kill_date DATETIME
);