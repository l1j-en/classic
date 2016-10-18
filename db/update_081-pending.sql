-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.
INSERT INTO commands (name, access_level, class_name, help_text, run_on_login) VALUES('createpet', 200, 'L1CreatePet', 'Lets to create a pet with a level of your choice', 0);

-- add back the lancemaster polymorph!
insert into polymorphs values (7332,'spearm 52',7332,52,1080,4095,1,7);
insert into polymorphs values (7338,'spearm 55',7338,55,1080,4095,1,7);
insert into polymorphs values (7339,'spearm 60',7339,60,1080,4095,1,7);
insert into polymorphs values (7340,'spearm 65',7340,65,1080,4095,1,7);
insert into polymorphs values (7341,'spearm 70',7341,70,1080,4095,1,7);

CREATE TABLE `log_jail` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `jailed_char_name` varchar(50) NOT NULL,
  `jailer` varchar(50) NOT NULL,
  `message` varchar(100) NOT NULL,
  `unjail` timestamp NOT NULL,
  `status` varchar(10) NOT NULL,
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;