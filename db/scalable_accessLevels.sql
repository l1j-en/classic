-- set certain commands to run automatically on login
ALTER TABLE commands ADD COLUMN run_on_login bool NOT NULL default false;
UPDATE commands SET run_on_login = '1' WHERE name = 'invul';
UPDATE commands SET run_on_login = '1' WHERE name = 'appearoffline';
UPDATE commands SET run_on_login = '1' WHERE name = 'invis';

-- modify the access levels to the new system
CREATE TABLE `access_levels` (id SMALLINT PRIMARY KEY NOT NULL, name VARCHAR(50) NOT NULL, chat_prefix VARCHAR(3), access_level SMALLINT NOT NULL default 0);
INSERT INTO `access_levels` VALUES (0, 'Player', NULL, 0);
INSERT INTO `access_levels` VALUES ('1', 'GameMaster', 'GM', 200);
INSERT INTO `access_levels` VALUES ('2', 'Monitor', 'MON', 100);
INSERT INTO `access_levels` (`id`, `name`, `access_level`) VALUES ('3', 'Player', 0);
UPDATE `characters` set accesslevel = '3' WHERE accesslevel != '200' AND accesslevel != '100';
UPDATE `characters` set accesslevel = '1' WHERE accesslevel = '200';
UPDATE `characters` set accesslevel = '2' WHERE accesslevel = '100';
UPDATE `accounts` set access_level = '3' WHERE access_level != '200' AND access_level != '100';
UPDATE `accounts` set access_level = '1' WHERE access_level = '200';
UPDATE `accounts` set access_level = '2' WHERE access_level = '100';

-- Update these to short because that is what we use everywhere in code
ALTER TABLE `accounts` MODIFY access_level SMALLINT DEFAULT 0;
ALTER TABLE `characters` MODIFY accesslevel SMALLINT DEFAULT 0;
ALTER TABLE `characters` ADD CONSTRAINT fk_accesslevel FOREIGN KEY (accesslevel) REFERENCES access_levels(id);
ALTER TABLE `accounts` ADD CONSTRAINT fk_access_level FOREIGN KEY (access_level) REFERENCES access_levels(id);

-- since the system is scalable, lets let everyone use help as long as they are not a regular player
UPDATE `commands` set access_level = '1' WHERE name = 'help';

-- command to promote/demote players
INSERT INTO `commands` VALUES('promote', '200', 'L1Promote', 'Modifies a players access level.', '0');
