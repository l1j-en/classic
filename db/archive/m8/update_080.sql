-- Create log_ban table..
CREATE TABLE `log_ban` (
       id SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
       `action` VARCHAR(10) NOT NULL,
       `target_account` VARCHAR(50) NOT NULL,
       `actioner_account` VARCHAR(50) NOT NULL,
       `message` VARCHAR(100) NOT NULL,
       `timestamp` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create boss_kills table.
CREATE TABLE boss_kills (
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	npcid INT (10) NOT NULL,
	boss_name VARCHAR(45) NOT NULL,
	locx INT (10) NOT NULL,
	locy INT (10) NOT NULL,
	mapid INT (10) NOT NULL,
	killer_objid INT(11) NOT NULL,
	killer_name VARCHAR (45) NOT NULL,
	clan_name VARCHAR (45),
	kill_date DATETIME
);

-- Update bugs structure.
ALTER TABLE bugs ADD title VARCHAR(20) NOT NULL;
ALTER TABLE bugs ADD submitted DATETIME NOT NULL;
INSERT INTO spawnlist_npc VALUES(1900020, 'Bug board', 1, 81126, 32736, 32793, 0, 0, 0, 0, 99, 9);

-- Add the ranking board to oren.
INSERT INTO `npc` VALUES ('81150', 'Ranking Board', 'Ranking Board', '', 'L1Board', '2205', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0');
INSERT INTO `spawnlist_npc` VALUES ('1900021', 'Oren Ranking Board', '1', '81150', '34053', '32277', '0', '0', '6', '0', '4', '0');

ALTER TABLE character_pvp ADD killer_pledge VARCHAR(45) DEFAULT NULL;
ALTER TABLE character_pvp ADD victim_pledge VARCHAR(45) DEFAULT NULL;

-- Update lancemaster sprite speeds.
-- 52 lancemaster
INSERT INTO spr_action VALUES ('7332', '0', '16', '24');
INSERT INTO spr_action VALUES ('7332', '1', '16', '24');
INSERT INTO spr_action VALUES ('7332', '2', '14', '24');
INSERT INTO spr_action VALUES ('7332', '3', '40', '24');
INSERT INTO spr_action VALUES ('7332', '8', '56', '24');
INSERT INTO spr_action VALUES ('7332', '18', '19', '24');
INSERT INTO spr_action VALUES ('7332', '19', '22', '24');
INSERT INTO spr_action VALUES ('7332', '24', '16', '24');
INSERT INTO spr_action VALUES ('7332', '25', '16', '24');
INSERT INTO spr_action VALUES ('7332', '26', '14', '24');
INSERT INTO spr_action VALUES ('7332', '27', '40', '24');
-- 55 lancemaster
INSERT INTO spr_action VALUES ('7338', '0', '16', '24');
INSERT INTO spr_action VALUES ('7338', '1', '15', '24');
INSERT INTO spr_action VALUES ('7338', '2', '14', '24');
INSERT INTO spr_action VALUES ('7338', '3', '40', '24');
INSERT INTO spr_action VALUES ('7338', '8', '56', '24');
INSERT INTO spr_action VALUES ('7338', '18', '17', '24');
INSERT INTO spr_action VALUES ('7338', '19', '21', '24');
INSERT INTO spr_action VALUES ('7338', '24', '16', '24');
INSERT INTO spr_action VALUES ('7338', '25', '15', '24');
INSERT INTO spr_action VALUES ('7338', '26', '14', '24');
INSERT INTO spr_action VALUES ('7338', '27', '40', '24');
-- 60 lancemaster
INSERT INTO spr_action VALUES ('7339', '0', '16', '24');
INSERT INTO spr_action VALUES ('7339', '1', '15', '24');
INSERT INTO spr_action VALUES ('7339', '2', '14', '24');
INSERT INTO spr_action VALUES ('7339', '3', '40', '24');
INSERT INTO spr_action VALUES ('7339', '8', '56', '24');
INSERT INTO spr_action VALUES ('7339', '18', '17', '24');
INSERT INTO spr_action VALUES ('7339', '19', '20', '24');
INSERT INTO spr_action VALUES ('7339', '24', '16', '24');
INSERT INTO spr_action VALUES ('7339', '25', '15', '24');
INSERT INTO spr_action VALUES ('7339', '26', '14', '24');
INSERT INTO spr_action VALUES ('7339', '27', '40', '24');
-- 65 lancemaster
INSERT INTO spr_action VALUES ('7340', '0', '16', '24');
INSERT INTO spr_action VALUES ('7340', '1', '15', '24');
INSERT INTO spr_action VALUES ('7340', '2', '14', '24');
INSERT INTO spr_action VALUES ('7340', '3', '40', '24');
INSERT INTO spr_action VALUES ('7340', '8', '56', '24');
INSERT INTO spr_action VALUES ('7340', '18', '16', '24');
INSERT INTO spr_action VALUES ('7340', '19', '20', '24');
INSERT INTO spr_action VALUES ('7340', '24', '16', '24');
INSERT INTO spr_action VALUES ('7340', '25', '15', '24');
INSERT INTO spr_action VALUES ('7340', '26', '14', '24');
INSERT INTO spr_action VALUES ('7340', '27', '40', '24');
-- 70 lancemaster
INSERT INTO spr_action VALUES ('7341', '0', '16', '24');
INSERT INTO spr_action VALUES ('7341', '1', '15', '24');
INSERT INTO spr_action VALUES ('7341', '2', '14', '24');
INSERT INTO spr_action VALUES ('7341', '3', '40', '24');
INSERT INTO spr_action VALUES ('7341', '8', '56', '24');
INSERT INTO spr_action VALUES ('7341', '18', '16', '24');
INSERT INTO spr_action VALUES ('7341', '19', '18', '24');
INSERT INTO spr_action VALUES ('7341', '24', '16', '24');
INSERT INTO spr_action VALUES ('7341', '25', '15', '24');
INSERT INTO spr_action VALUES ('7341', '26', '14', '24');
INSERT INTO spr_action VALUES ('7341', '27', '40', '24');

-- Set certain commands to run automatically on login.
ALTER table commands ADD COLUMN `help_text` TEXT CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI;
ALTER TABLE commands ADD COLUMN run_on_login bool NOT NULL default false;

UPDATE commands SET run_on_login = '1' WHERE name = 'invul';
UPDATE commands SET run_on_login = '1' WHERE name = 'appearoffline';
UPDATE commands SET run_on_login = '1' WHERE name = 'invis';

DELETE FROM commands WHERE name = 'show';
UPDATE commands SET `help_text` = 'Ban a user from chatting for x minutes.' WHERE name = 'chatng';
UPDATE commands SET `help_text` = 'Move a user to a safe place before kicking.' WHERE name = 'skick';
UPDATE commands SET `help_text` = 'Resurrects or heals a specified player or all players on screen.' WHERE name = 'ress';
UPDATE commands SET `help_text` = 'Starts or ends a polymorph event. This will not persist after server restart.' WHERE name = 'polyevent';
UPDATE commands SET `help_text` = 'Give a player or yourself x adena.' WHERE name = 'adena';
UPDATE commands SET `help_text` = 'Enable or disable whether players can drop items on the ground.' WHERE name = 'dropitems';
UPDATE commands SET `help_text` = 'Polymorph yourself or another player.' WHERE name = 'poly';
UPDATE commands SET `help_text` = 'Teleport into a GM room.' WHERE name = 'gmroom';
UPDATE commands SET `help_text` = 'Allows you to see invisible players.' WHERE name = 'findinvis';
UPDATE commands SET `help_text` = 'Put a player in the jail.' WHERE name = 'jail';
UPDATE commands SET `help_text` = 'Give all users within a specific level range a present.' WHERE name = 'lvpresent';
UPDATE commands SET `help_text` = 'Increase your speed.' WHERE name = 'speed';
UPDATE commands SET `help_text` = 'Shut down the server!' WHERE name = 'shutdown';
UPDATE commands SET `help_text` = 'Modify an attribute of yourself or another player.' WHERE name = 'setting';
UPDATE commands SET `help_text` = 'Resolve a specific bug.' WHERE name = 'resolve';
UPDATE commands SET `help_text` = 'Change the ingame weather.' WHERE name = 'weather';
UPDATE commands SET `help_text` = 'Teleport to a specific player.' WHERE name = 'goto';
UPDATE commands SET `help_text` = 'Bring a specific player, or all players, to you.' WHERE name = 'recall';
UPDATE commands SET `help_text` = 'Create any item of any enchant level for yourself.' WHERE name = 'create';
UPDATE commands SET `help_text` = 'Give yourself or another player all buffs.' WHERE name = 'allbuff';
UPDATE commands SET `help_text` = 'Toggle whether you are invisible or not.' WHERE name = 'invis';
UPDATE commands SET `help_text` = 'Kill someone! Mwahahaaha!' WHERE name = 'kill';
UPDATE commands SET `help_text` = 'A list of all commands or help text for a specific command.' WHERE name = 'help';
UPDATE commands SET `help_text` = 'Enable or disable buy/sell of a specific or all shops.' WHERE name = 'toggleshop';
UPDATE commands SET `help_text` = 'Enable or disable global chat.' WHERE name = 'chat';
UPDATE commands SET `help_text` = 'Just displays whatever you type as a system message to yourself.' WHERE name = 'echo';
UPDATE commands SET `help_text` = 'Deletes all items from the ground.' WHERE name = 'cleaning';
UPDATE commands SET `help_text` = 'Gives you all of your classes skills.' WHERE name = 'addskill';
UPDATE commands SET `help_text` = 'Set a player or your own level.' WHERE name = 'level';
UPDATE commands SET `help_text` = 'Improved loc command that gives x and y, as well as map id.' WHERE name = 'loc';
UPDATE commands SET `help_text` = 'A more detailed who command for GMs' WHERE name = 'who';
UPDATE commands SET `help_text` = 'Create an itemset for yourself.' WHERE name = 'itemset';
UPDATE commands SET `help_text` = 'Ban an IP address from playing on the server.' WHERE name = 'banip';
UPDATE commands SET `help_text` = 'Kicks a player out of the game, causing them to have to re-login.' WHERE name = 'kick';
UPDATE commands SET `help_text` = 'Kicks a player while banning their IP address. Their account is NOT banned.' WHERE name = 'powerkick';
UPDATE commands SET `help_text` = 'Teleport yourself somewhere!' WHERE name = 'tele';
UPDATE commands SET `help_text` = 'Find the ID of armor, weapons, etcitems, polymorphs, npcs, or maps.' WHERE name = 'find';
UPDATE commands SET `help_text` = 'Lists basic stats for yourself.' WHERE name = 'desc';
UPDATE commands SET `help_text` = 'Display HP bars above all players, summons, pets, and monsters for yourself only.' WHERE name = 'hpbar';
UPDATE commands SET `help_text` = 'Gives a specific player a present.' WHERE name = 'present';
UPDATE commands SET `help_text` = 'Buffs a specific player, all players, or youself with the buff specified.' WHERE name = 'buff';
UPDATE commands SET `help_text` = 'Run a specific skill animation on yourself.' WHERE name = 'burf';
UPDATE commands SET `help_text` = 'Brings up the patrol window with name, clan, and login datetime of all online players. Double clicking a name will teleport you to them.' WHERE name = 'patrol';
UPDATE commands SET `help_text` = 'Set a specific command as a favourite. Once set, .f will run the saved command.' WHERE name = 'f';
UPDATE commands SET `help_text` = 'Kick and ban a specific player.' WHERE name = 'accbankick';
UPDATE commands SET `help_text` = 'Lists a specific accounts characters and adena.' WHERE name = 'account';
UPDATE commands SET `help_text` = 'Make your character display a specific action sprite.' WHERE name = 'action';
UPDATE commands SET `help_text` = 'Lists a players active buffs and their duration.' WHERE name = 'buffcheck';
UPDATE commands SET `help_text` = 'Starts a specific death match.' WHERE name = 'dm';
UPDATE commands SET `help_text` = 'Brings you to the location a specific bug was reported.' WHERE name = 'gotobug';
UPDATE commands SET `help_text` = 'Runs the daily or monthly tax updates.' WHERE name = 'hometown';
UPDATE commands SET `help_text` = 'Finds the ID for a skill name or the name of a skill ID.' WHERE name = 'findskill';
UPDATE commands SET `help_text` = 'Displays graphics x through y on the ground.' WHERE name = 'gfxid';
UPDATE commands SET `help_text` = 'Displays inventory graphics x through y in your inventory as a candle.' WHERE name = 'invgfxid';
UPDATE commands SET `help_text` = 'Insert a spawnpoint for a specific mob or npc at your location. This is a permanent spawn.' WHERE name = 'insert';
UPDATE commands SET `help_text` = 'Lists a players IP address.' WHERE name = 'ipcheck';
UPDATE commands SET `help_text` = 'Lists what mobs drop a specific item at what % chance.' WHERE name = 'item';
UPDATE commands SET `help_text` = 'Lists what items a mob drops and % chance.' WHERE name = 'mob';
UPDATE commands SET `help_text` = 'Teleports a players entire party to you.' WHERE name = 'partyrecall';
UPDATE commands SET `help_text` = 'Lists the current server rates and allows you to modify/reset them.' WHERE name = 'rates';
UPDATE commands SET `help_text` = 'Refresh your screen.' WHERE name = 'reload';
UPDATE commands SET `help_text` = 'See the description of a reported bug.' WHERE name = 'viewbug';
UPDATE commands SET `help_text` = 'Teleports you to a specified spawn ID.' WHERE name = 'tospawn';
UPDATE commands SET `help_text` = 'Summons a monster or npc at your location.' WHERE name = 'summon';

REPLACE INTO commands (`name`, `access_level`, `class_name`, `help_text`, `run_on_login`)
        VALUES('appearoffline', '100', 'L1AppearOffline', 'Hides you from the /who command.', 0);
REPLACE INTO commands (`name`, `access_level`, `class_name`, `help_text`, `run_on_login`)
        VALUES('snoop', '100', 'L1Snoop', 'View a users inventory, storage, elf storage, or pledge storage.', 0);
REPLACE INTO commands (`name`, `access_level`, `class_name`, `help_text`, `run_on_login`)
        VALUES('follow', '100', 'L1Follow', 'Makes your character auto-follow the specified player.', 0);
REPLACE INTO commands (`name`, `access_level`, `class_name`, `help_text`, `run_on_login`)
        VALUES('lazygm', '100', 'L1LazyGm', 'Loops through online players, teleporting you to each of them for x seconds and auto-following them.', 0);
REPLACE INTO commands (`name`, `access_level`, `class_name`, `help_text`, `run_on_login`)
        VALUES('pledge', '100', 'L1Pledge', 'Displays all members in a pledge.', 0);
REPLACE INTO commands (`name`, `access_level`, `class_name`, `help_text`, `run_on_login`)
        VALUES('accountips', '100', 'L1AccountIps', 'Display all IP addresses that have accessed an account and their last login date.', 0);
REPLACE INTO commands (`name`, `access_level`, `class_name`, `help_text`, `run_on_login`)
        VALUES('trace', '100', 'L1Trace', 'Displays all accounts that IP has accessed and when.', 0);
REPLACE INTO commands (`name`, `access_level`, `class_name`, `help_text`, `run_on_login`)
        VALUES('invul', '100', 'L1Invul', 'Makes you invulnerable to skills and attacks.', 1);
REPLACE INTO commands (`name`, `access_level`, `class_name`, `help_text`, `run_on_login`)
        VALUES('movechar', '100', 'L1MoveChar', 'Allows you to move a character (online or offline) to a specific location.', 0);

UPDATE commands SET access_level = '100' WHERE name = 'resolve';
UPDATE commands
       SET `help_text` = 'Resolve a specific bug. Use .resolve -n # to notify the reporter.'
       WHERE name = 'resolve';
INSERT INTO `commands` (`name`, `access_level`, `class_name`, `help_text`, `run_on_login`)
       VALUES('spoof', 100, 'L1SpoofName', 'Allows you to appear as a different name.', 0);
INSERT INTO `commands` (`name`, `access_level`, `class_name`, `help_text`, `run_on_login`)
       VALUES('cancel', 100, 'L1Cancel', 'Cancels all skills on a user.', 0);
INSERT INTO `commands` (`name`, `access_level`, `class_name`, `help_text`, `run_on_login`)
       VALUES('scan', 100, 'L1ScanArea', 'Scans the area and returns details about the subject of the scan.', 0);
INSERT INTO `commands` (`name`, `access_level`, `class_name`, `help_text`, `run_on_login`)
       VALUES('promote', '200', 'L1Promote', 'Modifies a players access level.', 0);

-- Update Dagger shop
delete from shop where npc_id = 81003;
insert into shop values
   (81003,null,1,'Orcish Dagger',0,1,0,1),
   (81003,null,2,'Dice Dagger',1,1,0,1),
   (81003,null,4,'Dagger',2,1,0,1),
   (81003,null,5,'Elven Dagger',3,1,0,1),
   (81003,null,6,'Lastavard Dagger',4,1,0,1),
   (81003,null,7,'Ivory Tower Dagger',5,1,0,1),
   (81003,null,8,'Mithril Dagger',6,1,0,1),
   (81003,null,9,'Oriharukon Dagger',7,1,0,1),
   (81003,null,10,'Lastavard Blade',8,1,0,1),
   (81003,null,11,'Dagger of Crystal',9,1,0,1),
   (81003,null,12,'Wind Blade Dagger',10,1,0,1),
   (81003,null,13,'Finger of Death',11,1,0,1),
   (81003,null,14,'Claw of Chaos',12,1,0,1),
   (81003,null,34,'Sword of Red Desire',13,1,0,1),
   (81003,null,228,'Sword of Legend',14,1,0,1),
   (81003,null,231,'Dagger of Blue Sky',15,1,0,1),
   (81003,null,100004,'Dagger',16,1,0,1),
   (81003,null,100005,'Elven Dagger',17,1,0,1),
   (81003,null,100008,'Mithril Dagger',18,1,0,1),
   (81003,null,100009,'Oriharukon Dagger',19,1,0,1),
   (81003,null,200001,'Orcish Dagger',20,1,0,1),
   (81003,null,200002,'Dice Dagger',21,1,0,1),
   (81003,null,259,'Dagger of Magic Power',22,1,0,1);

-- Update Swords ( Consolidate 1h + 2h )
-- Note, check out (81004,null,264,'Thunder God\'s Sword',100,1,0,1) in other
-- tables
-- This had a weird character for the apostrophe
update spawnlist_npc set location = 'Shop (Swords)' where id = 89510;
update npc set name = 'Shop (Swords)', nameid = 'Shop (Swords)' where npcid = 81004;
delete from shop where npc_id = 81004;
insert into shop values
   (81004,null,3,'Body of Shortsword',0,1,0,1),
   (81004,null,15,'Sword of Kurtz',1,1,0,1),
   (81004,null,16,'Blade of Revenge',2,1,0,1),
   (81004,null,17,'Sealed Forgotten Great Sword',3,1,0,1),
   (81004,null,18,'Sealed Forgotten Sword',4,1,0,1),
   (81004,null,19,'Body of Long Sword',5,1,0,1),
   (81004,null,20,'Body of Oriharukon Sword',6,1,0,1),
   (81004,null,21,'Orcish Short Sword',7,1,0,1),
   (81004,null,22,'Mail Breaker',8,1,0,1),
   (81004,null,23,'Broad Sword',9,1,0,1),
   (81004,null,24,'Short Sword',10,1,0,1),
   (81004,null,25,'Silver Sword',11,1,0,1),
   (81004,null,26,'Dwarvish Short Sword',12,1,0,1),
   (81004,null,27,'Scimitar',13,1,0,1),
   (81004,null,28,'Elven Short Sword',14,1,0,1),
   (81004,null,29,'Long Silver Sword',15,1,0,1),
   (81004,null,30,'Sword of the Red Knight',16,1,0,1),
   (81004,null,31,'Long Sword',17,1,0,1),
   (81004,null,32,'Gradius',18,1,0,1),
   (81004,null,33,'Sword of Honor',19,1,0,1),
   (81004,null,35,'IT One-Handed Sword',20,1,0,1),
   (81004,null,36,'Eva\'s Scorn',21,1,0,1),
   (81004,null,37,'Damascus Sword',22,1,0,1),
   (81004,null,38,'Lastavard Long Sword',23,1,0,1),
   (81004,null,39,'Cutlass',24,1,0,1),
   (81004,null,40,'Large Sword of Blood',25,1,0,1),
   (81004,null,41,'Katana',26,1,0,1),
   (81004,null,42,'Rapier',27,1,0,1),
   (81004,null,43,'Shamshir',28,1,0,1),
   (81004,null,44,'Sword of Ancient Elf',29,1,0,1),
   (81004,null,45,'Sword of Lord Porche',30,1,0,1),
   (81004,null,46,'Sword of Life',31,1,0,1),
   (81004,null,47,'Sword of Silence',32,1,0,1),
   (81004,null,48,'IT Two-Handed Sword',33,1,0,1),
   (81004,null,49,'Long Sword of Pretender King',34,1,0,1),
   (81004,null,50,'Sword of Flames',35,1,0,1),
   (81004,null,51,'Gold Scepter',36,1,0,1),
   (81004,null,52,'Two Handed Sword',37,1,0,1),
   (81004,null,53,'Sword of Brave Lizardman Soldier',38,1,0,1),
   (81004,null,54,'Sword of Kurtz',39,1,0,1),
   (81004,null,55,'Blade of Darkness',40,1,0,1),
   (81004,null,56,'Death Blade',41,1,0,1),
   (81004,null,57,'Tsurugi',42,1,0,1),
   (81004,null,58,'Fire Sword of Death Knight',43,1,0,1),
   (81004,null,59,'Sword of Knight Vald',44,1,0,1),
   (81004,null,60,'Doom Blade',45,1,0,1),
   (81004,null,61,'Executuion Sword of Fidelity',46,1,0,1),
   (81004,null,62,'Two-Handed Sword of Pretender King',47,1,0,1),
   (81004,null,63,'Devil\'s Knife',48,1,0,1),
   (81004,null,64,'Great Sword',49,1,0,1),
   (81004,null,65,'Sword of Heaven',50,1,0,1),
   (81004,null,66,'Dragon Slayer',51,1,0,1),
   (81004,null,67,'Ancient Great Sword',52,1,0,1),
   (81004,null,68,'Ancient Sword',53,1,0,1),
   (81004,null,112,'Elven Sword of Magic Resistance',54,1,0,1),
   (81004,null,113,'Elven Sword of Dexterity',55,1,0,1),
   (81004,null,195,'Cursed Sword of Dantes',56,1,0,1),
   (81004,null,196,'Two-Handed Sword of Varlok',57,1,0,1),
   (81004,null,197,'Two-Handed Sword of Varlok',58,1,0,1),
   (81004,null,198,'Two-Handed Sword of Varlok',59,1,0,1),
   (81004,null,199,'Two-Handed Sword of Varlok',60,1,0,1),
   (81004,null,200,'Two-Handed Sword of Varlok',61,1,0,1),
   (81004,null,201,'Two-Handed Sword of Varlok',62,1,0,1),
   (81004,null,202,'Two-Handed Sword of Varlok',63,1,0,1),
   (81004,null,203,'Two-Handed Sword of Varlok',64,1,0,1),
   (81004,null,206,'Dark Elf\'s Training Sword',65,1,0,1),
   (81004,null,208,'Elven Sword of Constitution',66,1,0,1),
   (81004,null,209,'Elven Short Sword of Constitution',67,1,0,1),
   (81004,null,217,'Sword of Girtas',68,1,0,1),
   (81004,null,225,'Apprentice Sword',69,1,0,1),
   (81004,null,226,'Apprentice Knight Sword',70,1,0,1),
   (81004,null,232,'Sword of Blue Sky',71,1,0,1),
   (81004,null,233,'Great Sword of Blue Sky',72,1,0,1),
   (81004,null,100025,'Silver Sword',73,1,0,1),
   (81004,null,100027,'Scimitar',74,1,0,1),
   (81004,null,100028,'Elven Short Sword',75,1,0,1),
   (81004,null,100029,'Long Silver Sword',76,1,0,1),
   (81004,null,100037,'Damascus Sword',77,1,0,1),
   (81004,null,100041,'Katana',78,1,0,1),
   (81004,null,100042,'Rapier',79,1,0,1),
   (81004,null,100049,'Long Sword of Pretender King',80,1,0,1),
   (81004,null,100052,'Two-Handed Sword',81,1,0,1),
   (81004,null,100057,'Tsurugi',82,1,0,1),
   (81004,null,100062,'Two-Handed Sword of Pretender King',83,1,0,1),
   (81004,null,100064,'Great Sword',84,1,0,1),
   (81004,null,200027,'Scimitar',85,1,0,1),
   (81004,null,200032,'Gradius',86,1,0,1),
   (81004,null,200041,'Katana',87,1,0,1),
   (81004,null,200052,'Two-Handed Sword',88,1,0,1),
   (81004,null,450000,'Thor\'s Hammer',89,1,0,1),
   (81004,null,450001,'Paagrio\'s Hatred',90,1,0,1),
   (81004,null,450004,'Diamond Sword',91,1,0,1),
   (81004,null,246,'Sword of Ordeal',92,1,0,1),
   (81004,null,247,'Sword of Ordeal',93,1,0,1),
   (81004,null,248,'Sword of Ordeal',94,1,0,1),
   (81004,null,249,'Sword of Ordeal',95,1,0,1),
   (81004,null,251,'Two-Handed Sword of Illusion',96,1,0,1),
   (81004,null,256,'Pumpkin Sword',97,1,0,1),
   (81004,null,266,'Two-handed Sword of Thebes Osiris',98,1,0,1),
   (81004,null,262,'Great Sword of Destruction',99,1,0,1),
   (81004,null,264,'Thunder God\'s Sword',100,1,0,1),
   (81004,null,275,'Two-handed Sword of Dragonknight',101,1,0,1),
   (81004,null,450005,'Spirit Defender',102,1,0,1);

-- Update for chain swords and kiringku
update spawnlist_npc set location = 'Shop (New classes)' where id = 89510;
update npc set name = 'Shop (New classes)', nameid = 'Shop (New classes)' where npcid = 81005;
delete from shop where npc_id = 81005;
insert into shop values
   (81005,null,270,'Sapphire Kiringku',0,1,0,1),
   (81005,null,271,'Obsidian Kiringku',1,1,0,1),
   (81005,null,272,'Destructor\'s Chain Sword',2,1,0,1),
   (81005,null,273,'Collapsed One\'s Chain Sword',3,1,0,1);

-- Update Polearm
delete from shop where npc_id = 81006;
insert into shop values
   (81006,null,88,'Pan\'s Horn',0,1,0,1),
   (81006,null,89,'Mithril-coated Horn',1,1,0,1),
   (81006,null,90,'Bardiche',2,1,0,1),
   (81006,null,91,'Orcish Spear',3,1,0,1),
   (81006,null,92,'Bill-guisarme',4,1,0,1),
   (81006,null,93,'Trident',5,1,0,1),
   (81006,null,94,'Partisan',6,1,0,1),
   (81006,null,95,'Lance',7,1,0,1),
   (81006,null,96,'Spear',8,1,0,1),
   (81006,null,97,'Guisarme',9,1,0,1),
   (81006,null,98,'Glaive',10,1,0,1),
   (81006,null,99,'Elven Spear',11,1,0,1),
   (81006,null,100,'Oriharukon-coated Horn',12,1,0,1),
   (81006,null,101,'Lastavard One-Handed Spear',13,1,0,1),
   (81006,null,102,'Lucern Hammer',14,1,0,1),
   (81006,null,103,'Halbred',15,1,0,1),
   (81006,null,104,'Fauchard',16,1,0,1),
   (81006,null,105,'Ivory Tower Spear',17,1,0,1),
   (81006,null,106,'Bec de Corbin',18,1,0,1),
   (81006,null,107,'Crimson Lance',19,1,0,1),
   (81006,null,210,'Spear of Sheba Human',20,1,0,1),
   (81006,null,211,'Unicorn Horn',21,1,0,1),
   (81006,null,212,'Trident of the Sea God',22,1,0,1),
   (81006,null,234,'Spear of Blue Sky',23,1,0,1),
   (81006,null,100095,'Lance',24,1,0,1),
   (81006,null,100098,'Glaive',25,1,0,1),
   (81006,null,100099,'Elven Spear',26,1,0,1),
   (81006,null,100102,'Lucern Hammer',27,1,0,1),
   (81006,null,100103,'Halberd',28,1,0,1),
   (81006,null,100107,'Crimson Lance',29,1,0,1),
   (81006,null,100212,'Trident of the Sea God',30,1,0,1),
   (81006,null,263,'Spear of Intense Winter',31,1,0,1);

-- Update Blunts
delete from shop where npc_id = 81007;
insert into shop values
   (81007,null,114,'Symbol of Dignity',0,1,0,1),
   (81007,null,136,'Axe',1,1,0,1),
   (81007,null,137,'Athame',2,1,0,1),
   (81007,null,138,'Club',3,1,0,1),
   (81007,null,139,'Flail',4,1,0,1),
   (81007,null,140,'Mace',5,1,0,1),
   (81007,null,141,'War Hammer',6,1,0,1),
   (81007,null,142,'Silver Axe',7,1,0,1),
   (81007,null,143,'Battle Axe',8,1,0,1),
   (81007,null,144,'Dwarvish Axe',9,1,0,1),
   (81007,null,145,'Berserker Axe',10,1,0,1),
   (81007,null,146,'Morning Star',11,1,0,1),
   (81007,null,147,'Ivory Tower Axe',12,1,0,1),
   (81007,null,148,'Great Axe',13,1,0,1),
   (81007,null,149,'Axe of Minotaur',14,1,0,1),
   (81007,null,150,'Hammer of the Heavens',15,1,0,1),
   (81007,null,151,'Demon Axe',16,1,0,1),
   (81007,null,218,'Iron Mace of Angus',17,1,0,1),
   (81007,null,219,'Axe of Maphr',18,1,0,1),
   (81007,null,235,'Axe of Blue Sky',19,1,0,1),
   (81007,null,245,'Small Hammer of Happiness',20,1,0,1),
   (81007,null,100143,'Battle Axe',21,1,0,1),
   (81007,null,100146,'Morning Star',22,1,0,1),
   (81007,null,100151,'Demon Axe',23,1,0,1),
   (81007,null,450002,'Maphr\'s Retribution',24,1,0,1),
   (81007,null,450003,'Orcish Bume Smache',25,1,0,1),
   (81007,null,100114,'Symbol of Dignity',26,1,0,1),
   (81007,null,260,'Axe of Raging Wind',27,1,0,1);

-- Update Edoryu
delete from shop where npc_id = 81008;
insert into shop values
   (81008,null,69,'Bronze Edoryu',0,1,0,1),
   (81008,null,70,'Edoryu of Auger Blade',1,1,0,1),
   (81008,null,71,'Steel Edoryu',2,1,0,1),
   (81008,null,72,'Shadow Edoryu',3,1,0,1),
   (81008,null,73,'Ivory Tower Edoryu',4,1,0,1),
   (81008,null,74,'Silver Edoryu',5,1,0,1),
   (81008,null,75,'Dark Edoryu',6,1,0,1),
   (81008,null,76,'Edoryu of Ronde',7,1,0,1),
   (81008,null,77,'Stealth Edoryu',8,1,0,1),
   (81008,null,78,'Assassin Sword of Assassin King',9,1,0,1),
   (81008,null,79,'Edoryu of Abyss',10,1,0,1),
   (81008,null,80,'Damascus Edoryu',11,1,0,1),
   (81008,null,81,'Edoryu of Bravery',12,1,0,1),
   (81008,null,82,'Lastavard Edoryu',13,1,0,1),
   (81008,null,83,'Diad Fortress Edoryu',14,1,0,1),
   (81008,null,84,'Kaiser Edoryu',15,1,0,1),
   (81008,null,85,'Devil\'s Edoryu',16,1,0,1),
   (81008,null,86,'Edoryu of Red Shadow',17,1,0,1),
   (81008,null,236,'Edoryu of Blue Sky',18,1,0,1),
   (81008,null,100074,'Silver Edoryu',19,1,0,1),
   (81008,null,100084,'Kaiser Edoryu',20,1,0,1),
   (81008,null,265,'Edoryu of Thebes Osiris',21,1,0,1);

-- Update Claws
delete from shop where npc_id = 81009;
insert into shop values
   (81009,null,152,'Bronze Claw',0,1,0,1),
   (81009,null,153,'Steel Claw',1,1,0,1),
   (81009,null,154,'Shadow Claw',2,1,0,1),
   (81009,null,155,'Claw of Magic Power King',3,1,0,1),
   (81009,null,156,'Ivory Tower Claw',4,1,0,1),
   (81009,null,157,'Silver Claw',5,1,0,1),
   (81009,null,158,'Dark Claw',6,1,0,1),
   (81009,null,159,'Stealth Claw',7,1,0,1),
   (81009,null,160,'Claw of Savage King',8,1,0,1),
   (81009,null,161,'Damascus Claw',9,1,0,1),
   (81009,null,162,'Claw of Bravery',10,1,0,1),
   (81009,null,163,'Claw of Baranka',11,1,0,1),
   (81009,null,164,'Kaiser Claw',12,1,0,1),
   (81009,null,165,'Devil\'s Claw',13,1,0,1),
   (81009,null,166,'Claw of Hate',14,1,0,1),
   (81009,null,207,'Claw of Purgatory',15,1,0,1),
   (81009,null,237,'Claw of Blue Sky',16,1,0,1),
   (81009,null,100164,'Kaiser Claw',17,1,0,1),
   (81009,null,100157,'Silver Claw',18,1,0,1),
   (81009,null,100207,'Claw of Purgatory',19,1,0,1);

-- Update Staves
-- Check
    -- (81010,null,261,'Arch Mage`s Staff',32,1,0,1),
delete from shop where npc_id = 81010;
insert into shop values
   (81010,null,108,'Staff of Demon',0,1,0,1),
   (81010,null,109,'Staff of Baphomet',1,1,0,1),
   (81010,null,110,'Staff of Beleth',2,1,0,1),
   (81010,null,111,'Staff of Ice Queen',3,1,0,1),
   (81010,null,115,'Crystal Staff',4,1,0,1),
   (81010,null,116,'Staff of Black Wizard',5,1,0,1),
   (81010,null,117,'Wand of Laia',6,1,0,1),
   (81010,null,118,'Jet-Black Crystal Ball',7,1,0,1),
   (81010,null,119,'Staff of Demon',8,1,0,1),
   (81010,null,120,'Ivory Tower Staff',9,1,0,1),
   (81010,null,121,'Staff of Ice Queen',10,1,0,1),
   (81010,null,122,'Lastavard Staff',11,1,0,1),
   (81010,null,123,'Staff of Beleth',12,1,0,1),
   (81010,null,124,'Staff of Baphomet',13,1,0,1),
   (81010,null,125,'Staff of Sorcery',14,1,0,1),
   (81010,null,126,'Staff of Mana',15,1,0,1),
   (81010,null,127,'Steel Staff of Mana',16,1,0,1),
   (81010,null,128,'Oak Staff',17,1,0,1),
   (81010,null,129,'Wizard\'s Staff',18,1,0,1),
   (81010,null,130,'Staff of Red Crystal',19,1,0,1),
   (81010,null,131,'Staff of Strength',20,1,0,1),
   (81010,null,132,'Staff of New King',21,1,0,1),
   (81010,null,133,'Wisdom of the Ancient People',22,1,0,1),
   (81010,null,134,'Crystalized Staff',23,1,0,1),
   (81010,null,213,'Staff of Kirtas',24,1,0,1),
   (81010,null,220,'Apprentice Wizard Staff',25,1,0,1),
   (81010,null,223,'Mystery Staff',26,1,0,1),
   (81010,null,224,'Ivory Tower Staff',27,1,0,1),
   (81010,null,238,'Staff of Blue Sky',28,1,0,1),
   (81010,null,243,'Magic Wand of Shaman',29,1,0,1),
   (81010,null,100132,'Staff of New King',30,1,0,1),
   (81010,null,268,'Staff of Thebes Osiris',31,1,0,1),
   (81010,null,261,'Arch Mage\'s Staff',32,1,0,1),
   (81010,null,269,'Wand of Illusionist',33,1,0,1),
   (81010,null,274,'Ken Rauhel\'s Baton',34,1,0,1);

-- Update Bows
delete from shop where npc_id = 81011;
insert into shop values
   (81011,null,167,'Sealed Forgotten Bowgun',0,1,0,1),
   (81011,null,168,'Dark Crossbow',1,1,0,1),
   (81011,null,169,'Hunter Bow',2,1,0,1),
   (81011,null,170,'Elven Bow',3,1,0,1),
   (81011,null,171,'Orcish Bow',4,1,0,1),
   (81011,null,172,'Bow',5,1,0,1),
   (81011,null,173,'Short Bow',6,1,0,1),
   (81011,null,174,'Ivory Tower Stone Bow',7,1,0,1),
   (81011,null,175,'Ivory Tower Bow',8,1,0,1),
   (81011,null,176,'Lastabad Bow',9,1,0,1),
   (81011,null,177,'Crossbow of Bravery',10,1,0,1),
   (81011,null,178,'Crossbow of Silence',11,1,0,1),
   (81011,null,179,'Bow of Ancient Elf',12,1,0,1),
   (81011,null,180,'Crossbow',13,1,0,1),
   (81011,null,181,'Yumi',14,1,0,1),
   (81011,null,182,'Ancient Bowgun',15,1,0,1),
   (81011,null,183,'Bow of Illusion',16,1,0,1),
   (81011,null,184,'Bow of Flames',17,1,0,1),
   (81011,null,185,'Devil\'s Crossbow',18,1,0,1),
   (81011,null,186,'Diad Fortress Crossbow',19,1,0,1),
   (81011,null,187,'Lastabad Cross Bow',20,1,0,1),
   (81011,null,188,'Lastabad Heavy Cross Bow',21,1,0,1),
   (81011,null,189,'Kaiser Crossbow',22,1,0,1),
   (81011,null,190,'Sayhas Bow',23,1,0,1),
   (81011,null,191,'Bow of Cold Mastery',24,1,0,1),
   (81011,null,192,'Bow of Ancients',25,1,0,1),
   (81011,null,193,'Gauntlet',26,1,0,1),
   (81011,null,194,'Jin Gauntlet',27,1,0,1),
   (81011,null,204,'Impartial Arbalest',28,1,0,1),
   (81011,null,205,'Longbow of Moon',29,1,0,1),
   (81011,null,214,'Heavy Throwing Knife',30,1,0,1),
   (81011,null,215,'Elven Bow of Dexterity',31,1,0,1),
   (81011,null,216,'Apprentice Elf Bow',32,1,0,1),
   (81011,null,239,'Bow of Blue Sky',33,1,0,1),
   (81011,null,240,'Gauntlet of Blue Sky',34,1,0,1),
   (81011,null,100169,'Hunters Bow',35,1,0,1),
   (81011,null,100170,'Elven Bow',36,1,0,1),
   (81011,null,100172,'Bow',37,1,0,1),
   (81011,null,100180,'Crossbow',38,1,0,1),
   (81011,null,100181,'Yumi',39,1,0,1),
   (81011,null,100189,'Kaiser Crossbow',40,1,0,1),
   (81011,null,200171,'Orcish Bow',41,1,0,1),
   (81011,null,100204,'Indiscriminate Avarist',42,1,0,1),
   (81011,null,267,'Bow of Thebes Osiris',43,1,0,1);

-- Update Helmets
-- Check
-- (81012,null,20005,'Knight`s Hood',4,1,0,1),
-- (81012,null,20006,'Knight`s Visor',5,1,0,1),
-- (81012,null,20027,'Red Knight`s Hood',26,1,0,1),
-- (81012,null,20388,'Dark Elf`s Training Helmet',60,1,0,1),
-- (81012,null,20458,'Red Orc`s Mask',67,1,0,1),
delete from shop where npc_id = 81012;
insert into shop values
   (81012,null,20001,'Leather Cap',0,1,0,1),
   (81012,null,20002,'Leather Helmet',1,1,0,1),
   (81012,null,20003,'Iron Visor',2,1,0,1),
   (81012,null,20004,'Shadow Mask',3,1,0,1),
   (81012,null,20005,'Knight\'s Hood',4,1,0,1),
   (81012,null,20006,'Knight\'s Visor',5,1,0,1),
   (81012,null,20007,'Dwarvish Iron Helm',6,1,0,1),
   (81012,null,20008,'Old Helm of Wind',7,1,0,1),
   (81012,null,20009,'Demon Helmet',8,1,0,1),
   (81012,null,20010,'Death Knight Helmet',9,1,0,1),
   (81012,null,20011,'Helmet of Magic Resistance',10,1,0,1),
   (81012,null,20012,'Wizard Cap',11,1,0,1),
   (81012,null,20013,'Helm of Magic: Speed',12,1,0,1),
   (81012,null,20014,'Helm of Magic: Healing',13,1,0,1),
   (81012,null,20015,'Helm of Magic: Power',14,1,0,1),
   (81012,null,20016,'Mambo Hat',15,1,0,1),
   (81012,null,20017,'Crown of Mummy Lord',16,1,0,1),
   (81012,null,20018,'Cap of Merkyor',17,1,0,1),
   (81012,null,20019,'Crown',18,1,0,1),
   (81012,null,20020,'Helm of Pretender King',19,1,0,1),
   (81012,null,20021,'Elven Helm of Dexterity',20,1,0,1),
   (81012,null,20022,'Helmet of Baranka',21,1,0,1),
   (81012,null,20023,'Helm of Wind',22,1,0,1),
   (81012,null,20024,'Helmet of the Pretender King',23,1,0,1),
   (81012,null,20025,'Cap of Baltuzar',24,1,0,1),
   (81012,null,20026,'Night Vision Hood',25,1,0,1),
   (81012,null,20027,'Red Knight\'s Hood',26,1,0,1),
   (81012,null,20028,'Ivory Tower Leather Helm',27,1,0,1),
   (81012,null,20029,'Cap of Sema',28,1,0,1),
   (81012,null,20030,'Helm of New King',29,1,0,1),
   (81012,null,20031,'Helm of Yahee',30,1,0,1),
   (81012,null,20032,'Dark Headband',31,1,0,1),
   (81012,null,20033,'Bless of Elm',32,1,0,1),
   (81012,null,20034,'Orcish Helm',33,1,0,1),
   (81012,null,20035,'Elven Leather Helm',34,1,0,1),
   (81012,null,20036,'Helm of Infravision',35,1,0,1),
   (81012,null,20037,'Mask of Truth',36,1,0,1),
   (81012,null,20038,'Studded Leather Cap',37,1,0,1),
   (81012,null,20039,'Elven Helm of Constitution',38,1,0,1),
   (81012,null,20040,'Cap of Caspa',39,1,0,1),
   (81012,null,20041,'Helmet of Kurtz',40,1,0,1),
   (81012,null,20042,'Circlet of Cerenis',41,1,0,1),
   (81012,null,20043,'Helmet',42,1,0,1),
   (81012,null,20044,'Blue Pirate Bandanna',43,1,0,1),
   (81012,null,20045,'Skull Helmet',44,1,0,1),
   (81012,null,20046,'Pumpkin Mask',45,1,0,1),
   (81012,null,20047,'Pumpkin Costume',46,1,0,1),
   (81012,null,20048,'Helm of Chaos',47,1,0,1),
   (81012,null,20343,'Easter Bunny Hat',48,1,0,1),
   (81012,null,20344,'Easter Bunny Hat w/Carrot',49,1,0,1),
   (81012,null,20351,'Carrot',50,1,0,1),
   (81012,null,20356,'Helm of Legend',51,1,0,1),
   (81012,null,20380,'Halloween Blessing Cap',52,1,0,1),
   (81012,null,20381,'Hair Clip of Lucidity',53,1,0,1),
   (81012,null,20382,'Red Mask',54,1,0,1),
   (81012,null,20383,'Helmet for Horse Riding',55,1,0,1),
   (81012,null,20384,'Apprentice Prince Helm',56,1,0,1),
   (81012,null,20385,'Apprentice Knight Helm',57,1,0,1),
   (81012,null,20386,'Apprentice Elf Helm',58,1,0,1),
   (81012,null,20387,'Apprentice Wizard Cap',59,1,0,1),
   (81012,null,20388,'Dark Elf\'s Training Helmet',60,1,0,1),
   (81012,null,20389,'Elven Helm of %i',61,1,0,1),
   (81012,null,20390,'Helm of Fidelity',62,1,0,1),
   (81012,null,20452,'Drake Captain Transformation Turban',63,1,0,1),
   (81012,null,20453,'Iris Transformation Turban',64,1,0,1),
   (81012,null,20454,'Knight Vald Transformation Turban',65,1,0,1),
   (81012,null,20455,'Succubus Queen Transformation Turban',66,1,0,1),
   (81012,null,20458,'Red Orc\'s Mask',67,1,0,1),
   (81012,null,120011,'Helmet of Magic Resistance',68,1,0,1),
   (81012,null,120016,'Mambo Hat',69,1,0,1),
   (81012,null,120043,'Helmet',70,1,0,1),
   (81012,null,220034,'Orcish Helm',71,1,0,1),
   (81012,null,220043,'Helmet',72,1,0,1),
   (81012,null,21035,'Helm of Illusion',73,1,0,1),
   (81012,null,21039,'Burning Circlet',74,1,0,1),
   (81012,null,21051,'Wet Helmet',75,1,0,1),
   (81012,null,30014,'Dark Elf Circlet',76,1,0,1);

-- Update Shields
delete from shop where npc_id = 81013;
insert into shop values
   (81013,null,20219,'Leather Shield',0,1,0,1),
   (81013,null,20220,'Iron Shield',1,1,0,1),
   (81013,null,20221,'Bone Shield',2,1,0,1),
   (81013,null,20222,'Wooden Shield',3,1,0,1),
   (81013,null,20223,'Dwarvish Round Shield',4,1,0,1),
   (81013,null,20224,'Lastabad Round Shield',5,1,0,1),
   (81013,null,20225,'Mana Crystal Ball',6,1,0,1),
   (81013,null,20226,'Book of Magic Powers',7,1,0,1),
   (81013,null,20227,'Shield of Medusa',8,1,0,1),
   (81013,null,20228,'Shield of Pretender King',9,1,0,1),
   (81013,null,20229,'Shield of Reflection',10,1,0,1),
   (81013,null,20230,'Shield of Red Knight',11,1,0,1),
   (81013,null,20231,'Tower Shield',12,1,0,1),
   (81013,null,20232,'Ivory Tower Leather Shield',13,1,0,1),
   (81013,null,20233,'Scroll of New King',14,1,0,1),
   (81013,null,20234,'Shield of Faith',15,1,0,1),
   (81013,null,20235,'Shield of Eva',16,1,0,1),
   (81013,null,20236,'Elven Shield',17,1,0,1),
   (81013,null,20237,'Orcish Shield',18,1,0,1),
   (81013,null,20238,'Shield of the Silver Knight',19,1,0,1),
   (81013,null,20239,'Small Shield',20,1,0,1),
   (81013,null,20240,'Armor of Death Piece',21,1,0,1),
   (81013,null,20241,'Studded Leather Shield',22,1,0,1),
   (81013,null,20242,'Large Shield',23,1,0,1),
   (81013,null,20357,'Shield of Legend',24,1,0,1),
   (81013,null,20396,'Shield of Sheba Human',25,1,0,1),
   (81013,null,20397,'Apprentice Prince Shield',26,1,0,1),
   (81013,null,20398,'Apprentice Knight Shield',27,1,0,1),
   (81013,null,120242,'Large Shield',28,1,0,1),
   (81013,null,220237,'Orcish Shield',29,1,0,1),
   (81013,null,21037,'Shield of Illusion',30,1,0,1),
   (81013,null,21040,'Burning Shield',31,1,0,1),
   (81013,null,21056,'Wet Shield',32,1,0,1),
   (81013,null,21101,'Spellbook of Illusionist',33,1,0,1),
   (81013,null,21103,'Dragon Scale Guarder',34,1,0,1),
   (81013,null,21104,'Crystal Guarder',35,1,0,1),
   (81013,null,21105,'Guarder of Ancient Archer',36,1,0,1),
   (81013,null,21106,'Guarder of Ancient Warrior',37,1,0,1);

-- Update Gloves
-- Check
-- (81014,null,20186,'Tarak`s Gloves',24,1,0,1),
delete from shop where npc_id = 81014;
insert into shop values
   (81014,null,20162,'Leather Gloves',0,1,0,1),
   (81014,null,20163,'Iron Gloves',1,1,0,1),
   (81014,null,20164,'Shadow Gloves',2,1,0,1),
   (81014,null,20165,'Demon Gloves',3,1,0,1),
   (81014,null,20166,'Death Knight Gloves',4,1,0,1),
   (81014,null,20167,'Gloves of Lizardman Hero',5,1,0,1),
   (81014,null,20168,'Gloves of Pretender King',6,1,0,1),
   (81014,null,20169,'Gloves of Baranka',7,1,0,1),
   (81014,null,20170,'Gloves of the Pretender King',8,1,0,1),
   (81014,null,20171,'Gloves of Protection',9,1,0,1),
   (81014,null,20172,'Glove of Ice Spirit',10,1,0,1),
   (81014,null,20173,'Ivory Tower Leather Gloves',11,1,0,1),
   (81014,null,20174,'Snow Gloves',12,1,0,1),
   (81014,null,20175,'Crystal Gloves',13,1,0,1),
   (81014,null,20176,'Gloves of the New King',14,1,0,1),
   (81014,null,20177,'Glove of Dark Spirit',15,1,0,1),
   (81014,null,20178,'Gloves of Assassin King',16,1,0,1),
   (81014,null,20179,'Gloves of Yahee',17,1,0,1),
   (81014,null,20180,'Dark Gloves',18,1,0,1),
   (81014,null,20181,'Glove of Fire Spirit',19,1,0,1),
   (81014,null,20182,'Gloves',20,1,0,1),
   (81014,null,20183,'Scale of Death',21,1,0,1),
   (81014,null,20184,'Gloves of Kurtz',22,1,0,1),
   (81014,null,20185,'Gloves of Cerenis',23,1,0,1),
   (81014,null,20186,'Tarak\'s Gloves',24,1,0,1),
   (81014,null,20187,'Power Gloves',25,1,0,1),
   (81014,null,20188,'Blue Pirate Gloves',26,1,0,1),
   (81014,null,20189,'Glove of Wind Spirit',27,1,0,1),
   (81014,null,20190,'Finger of Chaos',28,1,0,1),
   (81014,null,20191,'Bracer',29,1,0,1),
   (81014,null,20355,'Gloves of Legend',30,1,0,1),
   (81014,null,20409,'Elven Gloves of %i',31,1,0,1),
   (81014,null,20410,'Gloves of Fidelity',32,1,0,1),
   (81014,null,120182,'Gloves',33,1,0,1),
   (81014,null,21042,'Burning Gloves',34,1,0,1),
   (81014,null,21054,'Wet Gloves',35,1,0,1),
   (81014,null,30010,'Hand of the Reaper',36,1,0,1);

-- Update Boots
-- Check for weird chars:
-- (81015,null,20216,'Tarak's Boots',24,1,0,1),
-- (81015,null,20405,'Dark Elf's Training Boots',31,1,0,1),
delete from shop where npc_id = 81015;
insert into shop values
   (81015,null,20192,'Leather Boots',0,1,0,1),
   (81015,null,20193,'Leather Sandal',1,1,0,1),
   (81015,null,20194,'Iron Boots',2,1,0,1),
   (81015,null,20195,'Shadow Boots',3,1,0,1),
   (81015,null,20196,'Boots of Dark Forester',4,1,0,1),
   (81015,null,20197,'Demon Boots',5,1,0,1),
   (81015,null,20198,'Death Knight Boots',6,1,0,1),
   (81015,null,20199,'Lastabad Boots',7,1,0,1),
   (81015,null,20200,'Boots of Evil Power King',8,1,0,1),
   (81015,null,20201,'Boots of Pretender King',9,1,0,1),
   (81015,null,20202,'Boots of Baranka',10,1,0,1),
   (81015,null,20203,'Boots of the Pretender King',11,1,0,1),
   (81015,null,20204,'Boots of Beleth',12,1,0,1),
   (81015,null,20205,'Boots',13,1,0,1),
   (81015,null,20206,'Ivory Tower Leather Sandals',14,1,0,1),
   (81015,null,20207,'Underwater Boots',15,1,0,1),
   (81015,null,20208,'Boots of New King',16,1,0,1),
   (81015,null,20209,'Boots of Yahee',17,1,0,1),
   (81015,null,20210,'Dark Boots',18,1,0,1),
   (81015,null,20211,'Alluring Sandals of Ice Queen',19,1,0,1),
   (81015,null,20212,'Studded Leather Sandals',20,1,0,1),
   (81015,null,20213,'Low Boots',21,1,0,1),
   (81015,null,20214,'Boots of Kurtz',22,1,0,1),
   (81015,null,20215,'Boots of Cerenis',23,1,0,1),
   (81015,null,20216,'Tarak\'s Boots',24,1,0,1),
   (81015,null,20217,'Blue Pirate Boots',25,1,0,1),
   (81015,null,20218,'Sandals of Dark Elder',26,1,0,1),
   (81015,null,20352,'Stocking',27,1,0,1),
   (81015,null,20354,'Boots of Legend',28,1,0,1),
   (81015,null,20403,'Apprentice Elf Boots',29,1,0,1),
   (81015,null,20404,'Apprentice Wizard Boots',30,1,0,1),
   (81015,null,20405,'Dark Elf\'s Training Boots',31,1,0,1),
   (81015,null,20406,'Elven Boots of %i',32,1,0,1),
   (81015,null,20407,'Militia Boots',33,1,0,1),
   (81015,null,20408,'Boots of Fidelity',34,1,0,1),
   (81015,null,220213,'Low Boots',35,1,0,1),
   (81015,null,21038,'Boots of Illusion',36,1,0,1),
   (81015,null,21041,'Burning Boots',37,1,0,1),
   (81015,null,21055,'Wet Boots',38,1,0,1),
   (81015,null,30013,'Dark Elf Sandals',39,1,0,1);

-- Update Shirts
-- Check for weird char:
    -- (81016,null,21063,'Swimwear Men`s Briefs',19,1,0,1),
    -- (81016,null,21064,'Swimwear Men`s Trunks',20,1,0,1),
    -- (81016,null,21065,'Swimwear Female`s One Piece',21,1,0,1),
    -- (81016,null,21066,'Swimwear Female`s Bikini',22,1,0,1),
    -- (81016,null,21108,'T-shirt with %i`s Mana',23,1,0,1),
delete from shop where npc_id = 81016;
insert into shop values
   (81016,null,20082,'Ivory Tower T-Shirt',0,1,0,1),
   (81016,null,20083,'Shirt of Yahee',1,1,0,1),
   (81016,null,20084,'Elven T-Shirt',2,1,0,1),
   (81016,null,20085,'T-Shirt',3,1,0,1),
   (81016,null,20086,'Doublet Lomejeech',4,1,0,1),
   (81016,null,20087,'Doublet Lomebuich',5,1,0,1),
   (81016,null,20088,'Doublet Lomechech',6,1,0,1),
   (81016,null,20456,'Red Soccer Uniform',7,1,0,1),
   (81016,null,20457,'Blue Soccer Uniform',8,1,0,1),
   (81016,null,120085,'T-Shirt',9,1,0,1),
   (81016,null,21028,'T-shirt with %i\'s Strength',10,1,0,1),
   (81016,null,21029,'T-shirt with %i\'s Agility',11,1,0,1),
   (81016,null,21030,'T-shirt with %i\'s Charm',12,1,0,1),
   (81016,null,21031,'T-shirt with %i\'s Magic Power',13,1,0,1),
   (81016,null,21032,'T-shirt with %i\'s Physical Strength',14,1,0,1),
   (81016,null,21033,'T-shirt with %i\'s Mana',15,1,0,1),
   (81016,null,21036,'T-Shirt of Illusion',16,1,0,1),
   (81016,null,21061,'T-Shirt of Ghost Man',17,1,0,1),
   (81016,null,21062,'T-Shirt of Ghost Woman',18,1,0,1),
   (81016,null,21063,'Swimwear Men\'s Briefs',19,1,0,1),
   (81016,null,21064,'Swimwear Men\'s Trunks',20,1,0,1),
   (81016,null,21065,'Swimwear Female\'s One Piece',21,1,0,1),
   (81016,null,21066,'Swimwear Female\'s Bikini',22,1,0,1),
   (81016,null,21108,'T-shirt with %i\'s Mana',23,1,0,1),
   (81016,null,30000,'Reinforced T-Shirt',24,1,0,1),
   (81016,null,30001,'Fortified T-Shirt',25,1,0,1);

-- Update Armor
-- Check
-- (81017,null,20152,'Tarak\'s Robe',63,1,0,1),
delete from shop where npc_id = 81017;
insert into shop values
   (81017,null,20089,'Leather Armor',0,1,0,1),
   (81017,null,20090,'Leather Vest',1,1,0,1),
   (81017,null,20091,'Iron Plate Mail',2,1,0,1),
   (81017,null,20092,'Ancient Leather Armor',3,1,0,1),
   (81017,null,20093,'Ancient Robe',4,1,0,1),
   (81017,null,20094,'Ancient Scale Mail',5,1,0,1),
   (81017,null,20095,'Ancient Plate Mail',6,1,0,1),
   (81017,null,20096,'Ring Mail',7,1,0,1),
   (81017,null,20097,'Wooden Armor',8,1,0,1),
   (81017,null,20098,'Armor of Dark Forester',9,1,0,1),
   (81017,null,20099,'Demon Armor',10,1,0,1),
   (81017,null,20100,'Death Knight Armor',11,1,0,1),
   (81017,null,20101,'Banded Mail',12,1,0,1),
   (81017,null,20102,'Lastabad Leather Armor',13,1,0,1),
   (81017,null,20103,'Lastabad Robe',14,1,0,1),
   (81017,null,20104,'Lastabad Studded Leather Armor',15,1,0,1),
   (81017,null,20105,'Lastabad Chain Mail',16,1,0,1),
   (81017,null,20106,'Robe of Laia',17,1,0,1),
   (81017,null,20107,'Lich Robe',18,1,0,1),
   (81017,null,20108,'Magical Armor of Lindvior',19,1,0,1),
   (81017,null,20109,'Robe of Evil Spirit King',20,1,0,1),
   (81017,null,20110,'Chain Mail of Magic Resistance',21,1,0,1),
   (81017,null,20111,'Wizard Clothing',22,1,0,1),
   (81017,null,20112,'Mambo Coat',23,1,0,1),
   (81017,null,20113,'Armor of Pretender King',24,1,0,1),
   (81017,null,20114,'Cotton Robe',25,1,0,1),
   (81017,null,20115,'Splint Mail',26,1,0,1),
   (81017,null,20116,'Armor of Baranka',27,1,0,1),
   (81017,null,20117,'Armor of Baphomet',28,1,0,1),
   (81017,null,20118,'Armor of the Pretender King',29,1,0,1),
   (81017,null,20119,'Magical Armor of Valakas',30,1,0,1),
   (81017,null,20120,'Leather Vest with Belt',31,1,0,1),
   (81017,null,20121,'Robe of Black Wizard',32,1,0,1),
   (81017,null,20122,'Scale Mail',33,1,0,1),
   (81017,null,20123,'Robe of Beast Summoner',34,1,0,1),
   (81017,null,20124,'Bone Armor',35,1,0,1),
   (81017,null,20125,'Chain Mail',36,1,0,1),
   (81017,null,20126,'Ivory Tower Leather Armor',37,1,0,1),
   (81017,null,20127,'Blue Dragon Armor',38,1,0,1),
   (81017,null,20128,'Crystal Plate Mail',39,1,0,1),
   (81017,null,20129,'Robe of New King',40,1,0,1),
   (81017,null,20130,'Magical Armor of Antharas',41,1,0,1),
   (81017,null,20131,'Armor of Yahee',42,1,0,1),
   (81017,null,20132,'Dark Robe',43,1,0,1),
   (81017,null,20133,'Darkness Dealer Plate Mail',44,1,0,1),
   (81017,null,20134,'Alluring Dress of Ice Queen',45,1,0,1),
   (81017,null,20135,'Orcish Ring Mail',46,1,0,1),
   (81017,null,20136,'Orcish Chain Mail',47,1,0,1),
   (81017,null,20137,'Elven Chain Mail',48,1,0,1),
   (81017,null,20138,'Elven Plate Mail',49,1,0,1),
   (81017,null,20139,'Elven Breast Plate',50,1,0,1),
   (81017,null,20140,'Forgotten Leather Armor',51,1,0,1),
   (81017,null,20141,'Forgotten Robe',52,1,0,1),
   (81017,null,20142,'Forgotten Scale Mail',53,1,0,1),
   (81017,null,20143,'Forgotten Plate Mail',54,1,0,1),
   (81017,null,20144,'Armor of Death',55,1,0,1),
   (81017,null,20145,'Hard Leather Vest',56,1,0,1),
   (81017,null,20146,'Green Dragon Armor',57,1,0,1),
   (81017,null,20147,'Studded Leather Armor',58,1,0,1),
   (81017,null,20148,'Studded Leather Vest',59,1,0,1),
   (81017,null,20149,'Bronze Plate Mail',60,1,0,1),
   (81017,null,20150,'Armor of Kurtz',61,1,0,1),
   (81017,null,20151,'Robe of Cerenis',62,1,0,1),
   (81017,null,20152,'Tarak\'s Robe',63,1,0,1),
   (81017,null,20153,'Magical Armor of Fafurion',64,1,0,1),
   (81017,null,20154,'Plate Mail',65,1,0,1),
   (81017,null,20155,'Blue Pirate Leather Armor',66,1,0,1),
   (81017,null,20156,'White Dragon Armor',67,1,0,1),
   (81017,null,20157,'Plate Worm Rind Armor',68,1,0,1),
   (81017,null,20158,'Emblem of Chaos',69,1,0,1),
   (81017,null,20159,'Red Dragon Armor',70,1,0,1),
   (81017,null,20160,'Robe of Dark Elder',71,1,0,1),
   (81017,null,20161,'Armor of Illusion',72,1,0,1),
   (81017,null,20322,'Leather Jacket',73,1,0,1),
   (81017,null,20353,'Armor of Legend',74,1,0,1),
   (81017,null,20391,'Apprentice Prince Armor',75,1,0,1),
   (81017,null,20392,'Apprentice Elf Armor',76,1,0,1),
   (81017,null,20393,'Elven Armor of %i',77,1,0,1),
   (81017,null,20394,'Apprentice Knight Armor',78,1,0,1),
   (81017,null,20395,'Armor of Fidelity',79,1,0,1),
   (81017,null,120101,'Splint Mail',80,1,0,1),
   (81017,null,120112,'Mambo Coat',81,1,0,1),
   (81017,null,120128,'Crystal Plate Mail',82,1,0,1),
   (81017,null,120137,'Elven Chain Mail',83,1,0,1),
   (81017,null,120149,'Bronze Plate Mail',84,1,0,1),
   (81017,null,120154,'Plate Mail',85,1,0,1),
   (81017,null,220101,'Banded Mail',86,1,0,1),
   (81017,null,220115,'Splint Mail',87,1,0,1),
   (81017,null,220122,'Scale Mail',88,1,0,1),
   (81017,null,220125,'Chain Mail',89,1,0,1),
   (81017,null,220135,'Orcish Ring Mail',90,1,0,1),
   (81017,null,220136,'Orcish Chain Mail',91,1,0,1),
   (81017,null,220147,'Studded Leather Armor',92,1,0,1),
   (81017,null,220154,'Plate Mail',93,1,0,1),
   (81017,null,29001,'Wooden Jacket',94,1,0,1),
   (81017,null,21053,'Wet Armor',95,1,0,1),
   (81017,null,21060,'Halloween Pumpkin Armor',96,1,0,1),
   (81017,null,21067,'Pumpkin Armor',97,1,0,1),
   (81017,null,21068,'Ultimate Halloween Pumpkin Armor',98,1,0,1),
   (81017,null,21107,'Wooden Jacket',99,1,0,1),
   (81017,null,30012,'Dark Elf Tunic',100,1,0,1);

-- Update Cloaks
-- Check for weird chars:
    -- (81018,null,20051,'Soverign`s Majesty',2,1,0,1),
    -- (81018,null,20062,'Varlok`s Blood-Colored Cloak',13,1,0,1),
    -- (81018,null,20076,'Tarak`s Cloak',27,1,0,1),
    -- (81018,null,20400,'Dark Elf`s Training Cloak',37,1,0,1),
delete from shop where npc_id = 81018;
insert into shop values
   (81018,null,20049,'Golden Wing of Giant Ant Queen',0,1,0,1),
   (81018,null,20050,'Silver Wing of Giant Ant Queen',1,1,0,1),
   (81018,null,20051,'Soverign\'s Majesty',2,1,0,1),
   (81018,null,20052,'Dwarvish Cloak',3,1,0,1),
   (81018,null,20053,'Wolf Skin Cloak',4,1,0,1),
   (81018,null,20054,'Earth Cloak',5,1,0,1),
   (81018,null,20055,'Cloak of Mana',6,1,0,1),
   (81018,null,20056,'Cloak of Magic Resistance',7,1,0,1),
   (81018,null,20057,'Cloak of Arcane King',8,1,0,1),
   (81018,null,20058,'Cloak of Pretender King',9,1,0,1),
   (81018,null,20059,'Water Cloak',10,1,0,1),
   (81018,null,20060,'Cloak of Sea',11,1,0,1),
   (81018,null,20061,'Wind Cloak',12,1,0,1),
   (81018,null,20062,'Varlok\'s Blood-Colored Cloak',13,1,0,1),
   (81018,null,20063,'Cloak of Protection',14,1,0,1),
   (81018,null,20064,'Red Knight Cloak',15,1,0,1),
   (81018,null,20065,'Red Cloak',16,1,0,1),
   (81018,null,20066,'Black Tiger Leather Cloak',17,1,0,1),
   (81018,null,20067,'Cloak of New King',18,1,0,1),
   (81018,null,20068,'Cloak of the Aden Knights',19,1,0,1),
   (81018,null,20069,'Cloak of Yahee',20,1,0,1),
   (81018,null,20070,'Dark Cloak',21,1,0,1),
   (81018,null,20071,'Fire Cloak',22,1,0,1),
   (81018,null,20072,'Orcish Cloak',23,1,0,1),
   (81018,null,20073,'Elven Cloak',24,1,0,1),
   (81018,null,20074,'Silver Cloak',25,1,0,1),
   (81018,null,20075,'Cloak of Death',26,1,0,1),
   (81018,null,20076,'Tarak\'s Cloak',27,1,0,1),
   (81018,null,20077,'Cloak of Invisibility',28,1,0,1),
   (81018,null,20078,'Cloak of Chaos',29,1,0,1),
   (81018,null,20079,'Cloak of Vampire',30,1,0,1),
   (81018,null,20080,'Cloak of Passage',31,1,0,1),
   (81018,null,20081,'Oilskin Cloak',32,1,0,1),
   (81018,null,20342,'Cloak of Sashin',33,1,0,1),
   (81018,null,20347,'Hakama',34,1,0,1),
   (81018,null,20348,'Holiday Attire',35,1,0,1),
   (81018,null,20399,'Apprentice Wizard Cloak',36,1,0,1),
   (81018,null,20400,'Dark Elf\'s Training Cloak',37,1,0,1),
   (81018,null,20401,'Elven Cloak of %i',38,1,0,1),
   (81018,null,20402,'Cloak of Fidelity',39,1,0,1),
   (81018,null,120056,'Cloak of Magic Resistance',40,1,0,1),
   (81018,null,120074,'Silver Cloak',41,1,0,1),
   (81018,null,120077,'Cloak of Invisibility',42,1,0,1),
   (81018,null,220056,'Cloak of Magic Resistance',43,1,0,1),
   (81018,null,21052,'Wet Cloak',44,1,0,1),
   (81018,null,21057,'Cloak of Training Knight',45,1,0,1),
   (81018,null,21058,'Cloak of Training Knight',46,1,0,1),
   (81018,null,21059,'Cloak of Poison Serpent',47,1,0,1),
   (81018,null,21100,'Earring of the Great Wizard',48,1,0,1),
   (81018,null,21102,'Cloak of Dragon Knight',49,1,0,1),
   (81018,null,30011,'Cloak of Illusionist',50,1,0,1);

-- Update Amulets
-- Check
-- (81019,null,30008,'Mermaid`s Necklace',79,1,0,1),
delete from shop where npc_id = 81019;
insert into shop values
   (81019,null,20243,'Hidden Valley Amulet',0,1,0,1),
   (81019,null,20244,'Old Amulet of Charisma',1,1,0,1),
   (81019,null,20245,'Old Amulet of Dexterity',2,1,0,1),
   (81019,null,20246,'Old Amulet of Strength',3,1,0,1),
   (81019,null,20247,'Old Amulet of Inteligence',4,1,0,1),
   (81019,null,20248,'Old Amulet of Wisdom',5,1,0,1),
   (81019,null,20249,'Old Amulet of Constitution',6,1,0,1),
   (81019,null,20250,'Necklace of Doppelganger Boss',7,1,0,1),
   (81019,null,20251,'Silver Serpent Amulet',8,1,0,1),
   (81019,null,20252,'Necklace of Laia',9,1,0,1),
   (81019,null,20253,'Amulet of Dread Queen',10,1,0,1),
   (81019,null,20254,'Amulet of Charisma',11,1,0,1),
   (81019,null,20255,'Ring of Arcane King',12,1,0,1),
   (81019,null,20256,'Amulet of Dexterity',13,1,0,1),
   (81019,null,20257,'Amulet of Black Wizard',14,1,0,1),
   (81019,null,20258,'Amulet of Beast Summoner',15,1,0,1),
   (81019,null,20259,'Amulet of Singing Island',16,1,0,1),
   (81019,null,20260,'Amulet of Iris',17,1,0,1),
   (81019,null,20261,'Amulet of Yahee',18,1,0,1),
   (81019,null,20262,'Amulet of Vigor',19,1,0,1),
   (81019,null,20263,'Amulet of Orc Warrior',20,1,0,1),
   (81019,null,20264,'Amulet of Strength',21,1,0,1),
   (81019,null,20265,'Seal of Harmony',22,1,0,1),
   (81019,null,20266,'Amulet of Intelligence',23,1,0,1),
   (81019,null,20267,'Amulet of Wisdom',24,1,0,1),
   (81019,null,20268,'Amulet of Constitution',25,1,0,1),
   (81019,null,20269,'Skeleton Amulet',26,1,0,1),
   (81019,null,20270,'Silver Serpent Amulet',27,1,0,1),
   (81019,null,20345,'High Collie Choker',28,1,0,1),
   (81019,null,20346,'High Raccoon Choker',29,1,0,1),
   (81019,null,20349,'Amulet of Beagle',30,1,0,1),
   (81019,null,20350,'Amulet of Snow Man',31,1,0,1),
   (81019,null,20358,'Amulet of Kahel 1',32,1,0,1),
   (81019,null,20359,'Amulet of Kahel 2',33,1,0,1),
   (81019,null,20360,'Amulet of Kahel 3',34,1,0,1),
   (81019,null,20361,'Amulet of Kahel 4',35,1,0,1),
   (81019,null,20362,'Amulet of Kahel 5',36,1,0,1),
   (81019,null,20363,'Amulet of Kahel 6',37,1,0,1),
   (81019,null,20364,'Amulet of Kahel 7',38,1,0,1),
   (81019,null,20365,'Amulet of Kahel 8',39,1,0,1),
   (81019,null,20376,'Amulet of the Royalty',40,1,0,1),
   (81019,null,20377,'Amulet of the Knight',41,1,0,1),
   (81019,null,20378,'Amulet of the Elf',42,1,0,1),
   (81019,null,20379,'Amulet of the Wizard',43,1,0,1),
   (81019,null,20411,'Amulet of Suffering',44,1,0,1),
   (81019,null,20412,'Amulet of Anguish',45,1,0,1),
   (81019,null,20413,'Amulet of Hope',46,1,0,1),
   (81019,null,20414,'Amulet of Luck',47,1,0,1),
   (81019,null,20415,'Amulet of Passion',48,1,0,1),
   (81019,null,20416,'Amulet of Truth',49,1,0,1),
   (81019,null,20417,'Amulet of Miracle',50,1,0,1),
   (81019,null,20418,'Amulet of Affection',51,1,0,1),
   (81019,null,20419,'High Bear Choker',52,1,0,1),
   (81019,null,20420,'Lucky Cat Scarf',53,1,0,1),
   (81019,null,20421,'Amulet of Eris',54,1,0,1),
   (81019,null,20422,'Shiny Ancient Necklace',55,1,0,1),
   (81019,null,20423,'Amulet of Red Curse',56,1,0,1),
   (81019,null,20424,'Amulet of Blue Curse',57,1,0,1),
   (81019,null,20425,'Amulet of Green Curse',58,1,0,1),
   (81019,null,20426,'Necklace of Light',59,1,0,1),
   (81019,null,20427,'Talisman',60,1,0,1),
   (81019,null,20460,'Amulet of Glory',61,1,0,1),
   (81019,null,120244,'Old Amulet of Charisma',62,1,0,1),
   (81019,null,120245,'Old Amulet of Dexterity',63,1,0,1),
   (81019,null,120246,'Old Amulet of Strength',64,1,0,1),
   (81019,null,120247,'Old Amulet of Intelligence',65,1,0,1),
   (81019,null,120248,'Old Amulet of Wisdom',66,1,0,1),
   (81019,null,120249,'Old Amulet of Constitution',67,1,0,1),
   (81019,null,120254,'Amulet of Charisma',68,1,0,1),
   (81019,null,120256,'Amulet of Dexterity',69,1,0,1),
   (81019,null,120264,'Amulet of Strength',70,1,0,1),
   (81019,null,120266,'Amulet of Intelligence',71,1,0,1),
   (81019,null,120267,'Amulet of Wisdom',72,1,0,1),
   (81019,null,120268,'Amulet of Constitution',73,1,0,1),
   (81019,null,21043,'Talisman of Ironclad',74,1,0,1),
   (81019,null,21044,'Talisman of Jiedi',75,1,0,1),
   (81019,null,21045,'Talisman of Secret Maneuvers',76,1,0,1),
   (81019,null,21046,'Talisman of Mercy',77,1,0,1),
   (81019,null,21050,'Repaired Necklace',78,1,0,1),
   (81019,null,30008,'Mermaid\'s Necklace',79,1,0,1),
   (81019,null,30007,'Amulet',80,1,0,1);

-- Update Rings
-- Check
-- (81020,null,30006,'Mermaid`s Ring',67,1,0,1),
-- (81020,null,30009,'KillGlance`s Ring',72,1,0,1)
delete from shop where npc_id = 81020;
insert into shop values
   (81020,null,20277,'Right-Hand Ring of Doppelganger Boss',0,1,0,1),
   (81020,null,20278,'Left-Hand Ring of Doppelganger Boss',1,1,0,1),
   (81020,null,20279,'Ring of Laia',2,1,0,1),
   (81020,null,20280,'Ring of Immunity to Magic',3,1,0,1),
   (81020,null,20281,'Ring of Polymorph Control',4,1,0,1),
   (81020,null,20282,'Ivory Tower Ring',5,1,0,1),
   (81020,null,20284,'Ring of Summon Control',6,1,0,1),
   (81020,null,20285,'Ring of Water Resistance',7,1,0,1),
   (81020,null,20286,'Ring of Vitality',8,1,0,1),
   (81020,null,20287,'Ring of Gaurdian',9,1,0,1),
   (81020,null,20288,'Ring of Teleport Control',10,1,0,1),
   (81020,null,20289,'Abyss Ring',11,1,0,1),
   (81020,null,20290,'Ring of Yahee',12,1,0,1),
   (81020,null,20291,'Ring of Vigor',13,1,0,1),
   (81020,null,20293,'Cursed Diamond Ring',14,1,0,1),
   (81020,null,20294,'Cursed Ruby Ring',15,1,0,1),
   (81020,null,20295,'Cursed Sapphire Ring',16,1,0,1),
   (81020,null,20296,'Cursed Emerald Ring',17,1,0,1),
   (81020,null,20297,'Seal of Mental Ability',18,1,0,1),
   (81020,null,20298,'Ring of Zenith',19,1,0,1),
   (81020,null,20299,'Payment for Death',20,1,0,1),
   (81020,null,20300,'Ring of Earth Resistance',21,1,0,1),
   (81020,null,20301,'Seal of Physical Ability',22,1,0,1),
   (81020,null,20302,'Ring of Wind Resistance',23,1,0,1),
   (81020,null,20303,'Ring of Magic Resistance',24,1,0,1),
   (81020,null,20304,'Ring of Fire Resistance',25,1,0,1),
   (81020,null,20305,'Ring',26,1,0,1),
   (81020,null,20428,'Ring of Hope',27,1,0,1),
   (81020,null,20429,'Ring of Passion',28,1,0,1),
   (81020,null,20430,'Ring of Luck',29,1,0,1),
   (81020,null,20431,'Ring of Truth',30,1,0,1),
   (81020,null,20432,'Ring of Miracles',31,1,0,1),
   (81020,null,20433,'Ring of Bravery',32,1,0,1),
   (81020,null,20434,'Ring of Eris',33,1,0,1),
   (81020,null,20435,'Crafted Ring of Hero 1 (Earth Spirit)',34,1,0,1),
   (81020,null,20436,'Crafted Ring of Hero 1 (Water Spirit)',35,1,0,1),
   (81020,null,20437,'Crafted Ring of Hero 1 (Fire Spirit)',36,1,0,1),
   (81020,null,20438,'Crafted Ring of Hero 1 (Wind Spirit)',37,1,0,1),
   (81020,null,20439,'Crafted Ring of Hero 2 (Earth Spirit)',38,1,0,1),
   (81020,null,20440,'Crafted Ring of Hero 2 (Water Spirit)',39,1,0,1),
   (81020,null,20441,'Crafted Ring of Hero 2 (Fire Spirit)',40,1,0,1),
   (81020,null,20442,'Crafted Ring of Hero 2 (Wind Spirit)',41,1,0,1),
   (81020,null,20443,'Crafted Ring of Hero 3 (Earth Spirit)',42,1,0,1),
   (81020,null,20444,'Crafted Ring of Hero 3 (Water Spirit)',43,1,0,1),
   (81020,null,20445,'Crafted Ring of Hero 3 (Fire Spirit)',44,1,0,1),
   (81020,null,20446,'Crafted Ring of Hero 3 (Wind Spirit)',45,1,0,1),
   (81020,null,20447,'Ring of Hero (Earth Spirit)',46,1,0,1),
   (81020,null,20448,'Ring of Hero (Water Spirit)',47,1,0,1),
   (81020,null,20449,'Ring of Hero (Fire Spirit)',48,1,0,1),
   (81020,null,20450,'Ring of Hero (Wind Spirit)',49,1,0,1),
   (81020,null,20451,'Ring of Hero',50,1,0,1),
   (81020,null,120280,'Ring of Immunity to Magic',51,1,0,1),
   (81020,null,120285,'Ring of Water Resistance',52,1,0,1),
   (81020,null,120289,'Abyss Ring',53,1,0,1),
   (81020,null,120300,'Ring of Earth Resistance',54,1,0,1),
   (81020,null,120302,'Ring of Wind Resistance',55,1,0,1),
   (81020,null,120304,'Ring of Fire Resistance',56,1,0,1),
   (81020,null,220293,'Cursed Diamond Ring',57,1,0,1),
   (81020,null,220294,'Cursed Ruby Ring',58,1,0,1),
   (81020,null,220295,'Cursed Sapphire Ring',59,1,0,1),
   (81020,null,220296,'Cursed Emerald Ring',60,1,0,1),
   (81020,null,21034,'Rabbit Ring',61,1,0,1),
   (81020,null,21047,'Lucky Coin',62,1,0,1),
   (81020,null,21048,'Repaired Ring',63,1,0,1),
   (81020,null,21092,'??????',64,1,0,1),
   (81020,null,21093,'Ring of Thebes Osiris',65,1,0,1),
   (81020,null,21094,'Ring of Thebes Anubis',66,1,0,1),
   (81020,null,30006,'Mermaid\'s Ring',67,1,0,1),
   (81020,null,30002,'Ruby Ring',68,1,0,1),
   (81020,null,30003,'Sapphire Ring',69,1,0,1),
   (81020,null,30004,'Moonstone Ring',70,1,0,1),
   (81020,null,30005,'Carnelian Ring',71,1,0,1),
   (81020,null,30009,'KillGlance\'s Ring',72,1,0,1);

-- Update Belt
delete from shop where npc_id = 81021;
insert into shop values
   (81021,null,20306,'Old Belt of Body',0,1,0,1),
   (81021,null,20307,'Old Belt of Soul',1,1,0,1),
   (81021,null,20308,'Old Belt of Mind',2,1,0,1),
   (81021,null,20309,'Shining Belt of Body',3,1,0,1),
   (81021,null,20310,'Shining Belt of Soul',4,1,0,1),
   (81021,null,20311,'Shining Belt of Mind',5,1,0,1),
   (81021,null,20312,'Belt of Body',6,1,0,1),
   (81021,null,20313,'Belt of Darkness',7,1,0,1),
   (81021,null,20314,'Ring of Ancient Giant',8,1,0,1),
   (81021,null,20315,'Belt of Vigor',9,1,0,1),
   (81021,null,20316,'Belt of Soul',10,1,0,1),
   (81021,null,20317,'Ogre Belt',11,1,0,1),
   (81021,null,20318,'Belt of Bravery',12,1,0,1),
   (81021,null,20319,'Belt of Mind',13,1,0,1),
   (81021,null,20320,'Titan Belt',14,1,0,1),
   (81021,null,20321,'Troll Belt',15,1,0,1),
   (81021,null,120306,'Old Belt of Body',16,1,0,1),
   (81021,null,120307,'Old Belt of Soul',17,1,0,1),
   (81021,null,120308,'Old Belt of Mind',18,1,0,1),
   (81021,null,120309,'Shining Belt of Body',19,1,0,1),
   (81021,null,120310,'Shining Belt of Soul',20,1,0,1),
   (81021,null,120311,'Shining Belt of Mind',21,1,0,1),
   (81021,null,120312,'Belt of Body',22,1,0,1),
   (81021,null,120316,'Belt of Soul',23,1,0,1),
   (81021,null,120317,'Ogre Belt',24,1,0,1),
   (81021,null,120319,'Belt of Mind',25,1,0,1),
   (81021,null,120320,'Titan Belt',26,1,0,1),
   (81021,null,120321,'Troll Belt',27,1,0,1),
   (81021,null,21073,'Belt of New Life (Earth)',28,1,0,1),
   (81021,null,21072,'Belt of New Life (Fire)',29,1,0,1),
   (81021,null,21071,'Belt of New Life (Wind)',30,1,0,1),
   (81021,null,21070,'Belt of New Life (Water)',31,1,0,1),
   (81021,null,21069,'Belt of New Life',32,1,0,1),
   (81021,null,21095,'Belt of Thebes Osiris',33,1,0,1);

-- Update Magic - Spellbooks
-- Including DK and Illusionist spells in here
delete from shop where npc_id = 81022;
insert into shop values
   (81022,null,40170,'Spellbook(Fireball)',0,1,0,1),
   (81022,null,40171,'Spellbook(EnchantDex)',1,1,0,1),
   (81022,null,40172,'Spellbook(WeaponBreak)',2,1,0,1),
   (81022,null,40173,'Spellbook(VampiricTouch)',3,1,0,1),
   (81022,null,40174,'Spellbook(Slow)',4,1,0,1),
   (81022,null,40175,'Spellbook(EarthJail)',5,1,0,1),
   (81022,null,40176,'Spellbook(CounterMagic)',6,1,0,1),
   (81022,null,40177,'Spellbook(Meditate)',7,1,0,1),
   (81022,null,40178,'Spellbook(Paralyze)',8,1,0,1),
   (81022,null,40179,'Spellbook(CallLightning)',9,1,0,1),
   (81022,null,40180,'Spellbook(GreaterHeal)',10,1,0,1),
   (81022,null,40181,'Spellbook(TameMonster)',11,1,0,1),
   (81022,null,40182,'Spellbook(RemoveCurse)',12,1,0,1),
   (81022,null,40183,'Spellbook(ConeOfCold)',13,1,0,1),
   (81022,null,40184,'Spellbook(ManaDrain)',14,1,0,1),
   (81022,null,40185,'Spellbook(Darkness)',15,1,0,1),
   (81022,null,40186,'Spellbook(CreateZombie)',16,1,0,1),
   (81022,null,40187,'Spellbook(EnchantStr)',17,1,0,1),
   (81022,null,40188,'Spellbook(Haste)',18,1,0,1),
   (81022,null,40189,'Spellbook(Cancel)',19,1,0,1),
   (81022,null,40190,'Spellbook(Eruption)',20,1,0,1),
   (81022,null,40191,'Spellbook(SunBurst)',21,1,0,1),
   (81022,null,40192,'Spellbook(Weakness)',22,1,0,1),
   (81022,null,40193,'Spellbook(BlessWeapon)',23,1,0,1),
   (81022,null,40194,'Spellbook(HealPledge)',24,1,0,1),
   (81022,null,40195,'Spellbook(IceLance)',25,1,0,1),
   (81022,null,40196,'Spellbook(Summon)',26,1,0,1),
   (81022,null,40197,'Spellbook(HolyWalk)',27,1,0,1),
   (81022,null,40198,'Spellbook(Tornado)',28,1,0,1),
   (81022,null,40199,'Spellbook(GreaterHaste)',29,1,0,1),
   (81022,null,40200,'Spellbook(Berzerkers)',30,1,0,1),
   (81022,null,40201,'Spellbook(Disease)',31,1,0,1),
   (81022,null,40202,'Spellbook(FullHeal)',32,1,0,1),
   (81022,null,40203,'Spellbook(Firewall)',33,1,0,1),
   (81022,null,40204,'Spellbook(Blizzard)',34,1,0,1),
   (81022,null,40205,'Spellbook(Invisibility)',35,1,0,1),
   (81022,null,40206,'Spellbook(Resurrection)',36,1,0,1),
   (81022,null,40207,'Spellbook(Earthquake)',37,1,0,1),
   (81022,null,40208,'Spellbook(LifeStream)',38,1,0,1),
   (81022,null,40209,'Spellbook(Silence)',39,1,0,1),
   (81022,null,40210,'Spellbook(LightningStorm)',40,1,0,1),
   (81022,null,40211,'Spellbook(FogOfSleeping)',41,1,0,1),
   (81022,null,40212,'Spellbook(Polymorph)',42,1,0,1),
   (81022,null,40213,'Spellbook(ImmuneToHarm)',43,1,0,1),
   (81022,null,40214,'Spellbook(MassTeleport)',44,1,0,1),
   (81022,null,40215,'Spellbook(FireStorm)',45,1,0,1),
   (81022,null,40216,'Spellbook(DecayPotion)',46,1,0,1),
   (81022,null,40217,'Spellbook(CounterDetection)',47,1,0,1),
   (81022,null,40218,'Spellbook(CreateMagicalWeapon)',48,1,0,1),
   (81022,null,40219,'Spellbook(MeteorStrike)',49,1,0,1),
   (81022,null,40220,'Spellbook(GreaterResurrection)',50,1,0,1),
   (81022,null,40221,'Spellbook(MassSlow)',51,1,0,1),
   (81022,null,40222,'Spellbook(Destroy)',52,1,0,1),
   (81022,null,40223,'Spellbook(AbsoluteBarrier)',53,1,0,1),
   (81022,null,40224,'Spellbook(AdvanceSpirit)',54,1,0,1),
   (81022,null,40225,'Spellbook(FreezingBlizzard)',55,1,0,1),
   (81022,null,45000,'Spellbook(LesserHeal)',56,1,0,1),
   (81022,null,45001,'Spellbook(Light)',57,1,0,1),
   (81022,null,45002,'Spellbook(Shield)',58,1,0,1),
   (81022,null,45003,'Spellbook(EBolt)',59,1,0,1),
   (81022,null,45004,'Spellbook(Teleport)',60,1,0,1),
   (81022,null,45005,'Spellbook(IceDagger)',61,1,0,1),
   (81022,null,45006,'Spellbook(WindShuriken)',62,1,0,1),
   (81022,null,45007,'Spellbook(HolyWeapon)',63,1,0,1),
   (81022,null,45008,'Spellbook(CurePoison)',64,1,0,1),
   (81022,null,45009,'Spellbook(ChillTouch)',65,1,0,1),
   (81022,null,45010,'Spellbook(Poison)',66,1,0,1),
   (81022,null,45011,'Spellbook(EnchantWeapon)',67,1,0,1),
   (81022,null,45012,'Spellbook(Detection)',68,1,0,1),
   (81022,null,45013,'Spellbook(DecreaseWeight)',69,1,0,1),
   (81022,null,45014,'Spellbook(FireArrow)',70,1,0,1),
   (81022,null,45015,'Spellbook(Stalac)',71,1,0,1),
   (81022,null,45016,'Spellbook(Lightning)',72,1,0,1),
   (81022,null,45017,'Spellbook(TurnUndead)',73,1,0,1),
   (81022,null,45018,'Spellbook(Heal)',74,1,0,1),
   (81022,null,45019,'Spellbook(Blind)',75,1,0,1),
   (81022,null,45020,'Spellbook(EnchantArmor)',76,1,0,1),
   (81022,null,45021,'Spellbook(FrostCloud)',77,1,0,1),
   (81022,null,45022,'Spellbook(WeakElemental)',78,1,0,1),
   (81022,null,49102,'Dragon Tablet(DragonSkin)',79,1,0,1),
   (81022,null,49103,'Dragon Tablet(BurningSlash)',80,1,0,1),
   (81022,null,49104,'Dragon Tablet(GuardBreak)',81,1,0,1),
   (81022,null,49105,'Dragon Tablet(MagmaBreath)',82,1,0,1),
   (81022,null,49106,'Dragon Tablet(AwakenAntharas)',83,1,0,1),
   (81022,null,49107,'Dragon Tablet(BloodLust)',84,1,0,1),
   (81022,null,49108,'Dragon Tablet(FoeSlayer)',85,1,0,1),
   (81022,null,49109,'Dragon Tablet(ResistFear)',86,1,0,1),
   (81022,null,49110,'Dragon Tablet(ShockSkin)',87,1,0,1),
   (81022,null,49111,'Dragon Tablet(AwakenFafurion)',88,1,0,1),
   (81022,null,49112,'Dragon Tablet(MortalBody)',89,1,0,1),
   (81022,null,49113,'Dragon Tablet(ThunderGrab)',90,1,0,1),
   (81022,null,49114,'Dragon Tablet(HorrorOfDeath)',91,1,0,1),
   (81022,null,49115,'Dragon Tablet(FreezingBreath)',92,1,0,1),
   (81022,null,49116,'Dragon Tablet(AwakenValakas)',93,1,0,1),
   (81022,null,49117,'Memory Crystal(MirrorImage)',94,1,0,1),
   (81022,null,49118,'Memory Crystal(Confusion)',95,1,0,1),
   (81022,null,49119,'Memory Crystal(Smash)',96,1,0,1),
   (81022,null,49120,'Memory Crystal(IllusionOgre)',97,1,0,1),
   (81022,null,49121,'Memory Crystal(CubeIgnition)',98,1,0,1),
   (81022,null,49122,'Memory Crystal(Concentration)',99,1,0,1),
   (81022,null,49123,'Memory Crystal(MindBreak)',100,1,0,1),
   (81022,null,49124,'Memory Crystal(BoneBreak)',101,1,0,1),
   (81022,null,49125,'Memory Crystal(IllusionLich)',102,1,0,1),
   (81022,null,49126,'Memory Crystal(CubeQuake)',103,1,0,1),
   (81022,null,49127,'Memory Crystal(Patience)',104,1,0,1),
   (81022,null,49128,'Memory Crystal(Phantasm)',105,1,0,1),
   (81022,null,49129,'Memory Crystal(ArmBreaker)',106,1,0,1),
   (81022,null,49130,'Memory Crystal(IllusionDiaGolem)',107,1,0,1),
   (81022,null,49131,'Memory Crystal(CubeShock)',108,1,0,1),
   (81022,null,49132,'Memory Crystal(Insight)',109,1,0,1),
   (81022,null,49133,'Memory Crystal(Panic)',110,1,0,1),
   (81022,null,49134,'Memory Crystal(JoyofPain)',111,1,0,1),
   (81022,null,49135,'Memory Crystal(IllusionAvatar)',112,1,0,1),
   (81022,null,49136,'Memory Crystal(CubeBalance)',113,1,0,1);

-- Update Magic - Elf
delete from shop where npc_id = 81023;
insert into shop values
   (81023,null,40232,'Spirit Crystal(ResistMagic)',0,1,0,1),
   (81023,null,40233,'Spirit Crystal(BodytoMind)',1,1,0,1),
   (81023,null,40234,'Spirit Crystal(TeleportToMotherTree)',2,1,0,1),
   (81023,null,40235,'Spirit Crystal(ClearMind)',3,1,0,1),
   (81023,null,40236,'Spirit Crystal(ResistElemental)',4,1,0,1),
   (81023,null,40237,'Spirit Crystal(ReturnToNature)',5,1,0,1),
   (81023,null,40238,'Spirit Crystal(BloodtoSoul)',6,1,0,1),
   (81023,null,40239,'Spirit Crystal(ProtectionFromElemental)',7,1,0,1),
   (81023,null,40240,'Spirit Crystal(TripleShot)',8,1,0,1),
   (81023,null,40241,'Spirit Crystal(ElementalFallDown)',9,1,0,1),
   (81023,null,40242,'Spirit Crystal(EraseMagic)',10,1,0,1),
   (81023,null,40243,'Spirit Crystal(SummonLesserElement)',11,1,0,1),
   (81023,null,40244,'Spirit Crystal(AreaOfSilence)',12,1,0,1),
   (81023,null,40245,'Spirit Crystal(SummonGreaterElement)',13,1,0,1),
   (81023,null,40246,'Spirit Crystal(CounterMirror)',14,1,0,1),
   (81023,null,40247,'Spirit Crystal(EarthSkin)',15,1,0,1),
   (81023,null,40248,'Spirit Crystal(Entangle)',16,1,0,1),
   (81023,null,40249,'Spirit Crystal(EarthBind)',17,1,0,1),
   (81023,null,40250,'Spirit Crystal(BlessOfEarth)',18,1,0,1),
   (81023,null,40251,'Spirit Crystal(IronSkin)',19,1,0,1),
   (81023,null,40252,'Spirit Crystal(ExoticVitalize)',20,1,0,1),
   (81023,null,40253,'Spirit Crystal(WaterLife)',21,1,0,1),
   (81023,null,40254,'Spirit Crystal(NaturesTouch)',22,1,0,1),
   (81023,null,40255,'Spirit Crystal(NaturesBlessing)',23,1,0,1),
   (81023,null,40256,'Spirit Crystal(FireWeapon)',24,1,0,1),
   (81023,null,40257,'Spirit Crystal(BlessOfFire)',25,1,0,1),
   (81023,null,40258,'Spirit Crystal(BurningWeapon)',26,1,0,1),
   (81023,null,40259,'Spirit Crystal(ElementalFire)',27,1,0,1),
   (81023,null,40260,'Spirit Crystal(WindShot)',28,1,0,1),
   (81023,null,40261,'Spirit Crystal(WindWalk)',29,1,0,1),
   (81023,null,40262,'Spirit Crystal(EyeofStorm)',30,1,0,1),
   (81023,null,40263,'Spirit Crystal(StormShot)',31,1,0,1),
   (81023,null,40264,'Spirit Crystal(WindShackle)',32,1,0,1),
   (81023,null,41149,'Spirit Crystal(Soul of Flame)',33,1,0,1),
   (81023,null,41150,'Spirit Crystal(Additional Fire)',34,1,0,1),
   (81023,null,41151,'Spirit Crystal(Aqua Protect)',35,1,0,1),
   (81023,null,41152,'Spirit Crystal(Pollute Water)',36,1,0,1),
   (81023,null,41153,'Spirit Crystal(Strikers Gale)',37,1,0,1),
   (81023,null,50001,'Spirit Crystal(NaturesMiracle)',38,1,0,1);

-- Update Magic - Dark Elf
delete from shop where npc_id = 81024;
insert into shop values
   (81024,null,40265,'Dark Spirit Crystal(BlindHiding)',0,1,0,1),
   (81024,null,40266,'Dark Spirit Crystal(EnchantVenom)',1,1,0,1),
   (81024,null,40267,'Dark Spirit Crystal(ShadowArmor)',2,1,0,1),
   (81024,null,40268,'Dark Spirit Crystal(PurifyStone)',3,1,0,1),
   (81024,null,40269,'Dark Spirit Crystal(DressMighty)',4,1,0,1),
   (81024,null,40270,'Dark Spirit Crystal(MovingAcceleration)',5,1,0,1),
   (81024,null,40271,'Dark Spirit Crystal(BurningSpirit)',6,1,0,1),
   (81024,null,40272,'Dark Spirit Crystal(DarkBlind)',7,1,0,1),
   (81024,null,40273,'Dark Spirit Crystal(VenomResist)',8,1,0,1),
   (81024,null,40274,'Dark Spirit Crystal(DressDex)',9,1,0,1),
   (81024,null,40275,'Dark Spirit Crystal(DoubleBreak)',10,1,0,1),
   (81024,null,40276,'Dark Spirit Crystal(UncannyDodge)',11,1,0,1),
   (81024,null,40277,'Dark Spirit Crystal(ShadowFang)',12,1,0,1),
   (81024,null,40278,'Dark Spirit Crystal(FinalBurn)',13,1,0,1),
   (81024,null,40279,'Dark Spirit Crystal(DressEvasion)',14,1,0,1);

-- Update Magic - Knight
delete from shop where npc_id = 81025;
insert into shop values
   (81025,null,40164,'TechnicalDocument(ShockStun)',0,1,0,1),
   (81025,null,40165,'TechnicalDocument(ReductionArmor)',1,1,0,1),
   (81025,null,40166,'TechnicalDocument(BounceAttack)',2,1,0,1),
   (81025,null,41147,'TechnicalDocument(SolidCarriage)',3,1,0,1),
   (81025,null,41148,'TechnicalDocument(CounterBarrier)',4,1,0,1);

-- Update Magic - Royal
delete from shop where npc_id = 81026;
insert into shop values
   (81026,null,40226,'Spellbook(TrueTarget)',0,1,0,1),
   (81026,null,40227,'Spellbook(Glowing Aura)',1,1,0,1),
   (81026,null,40228,'Spellbook(CallPledgeMember)',2,1,0,1),
   (81026,null,40229,'Spellbook(Shining Aura)',3,1,0,1),
   (81026,null,40230,'Spellbook(Brave Aura)',4,1,0,1),
   (81026,null,40231,'Spellbook(Teleport to Pledge Member)',5,1,0,1);

-- Update Pots

-- Update Scrolls

-- Update Tel Scrolls

-- Update Earrings

-- Sharna scroll graphics fix.
REPLACE INTO spr_action VALUES ('6822', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6822', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6822', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6822', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6822', '4', '18', '24');
REPLACE INTO spr_action VALUES ('6822', '5', '23', '24');
REPLACE INTO spr_action VALUES ('6822', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6822', '7', '44', '24');
REPLACE INTO spr_action VALUES ('6822', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6822', '11', '18', '24');
REPLACE INTO spr_action VALUES ('6822', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6822', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6822', '14', '44', '24');
REPLACE INTO spr_action VALUES ('6822', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6822', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6822', '18', '24', '24');
REPLACE INTO spr_action VALUES ('6822', '19', '28', '24');
REPLACE INTO spr_action VALUES ('6822', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6822', '21', '25', '24');
REPLACE INTO spr_action VALUES ('6822', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6822', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6822', '24', '19', '24');
REPLACE INTO spr_action VALUES ('6822', '25', '20', '24');
REPLACE INTO spr_action VALUES ('6822', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6822', '27', '44', '24');
REPLACE INTO spr_action VALUES ('6822', '40', '17', '24');
REPLACE INTO spr_action VALUES ('6822', '41', '19', '24');
REPLACE INTO spr_action VALUES ('6822', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6822', '43', '44', '24');
REPLACE INTO spr_action VALUES ('6822', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6822', '47', '21', '24');
REPLACE INTO spr_action VALUES ('6822', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6822', '49', '44', '24');
REPLACE INTO spr_action VALUES ('6822', '50', '17', '24');
REPLACE INTO spr_action VALUES ('6822', '51', '18', '24');
REPLACE INTO spr_action VALUES ('6822', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6822', '53', '44', '24');
REPLACE INTO spr_action VALUES ('6822', '55', '23', '24');
REPLACE INTO spr_action VALUES ('6822', '66', '44', '24');
REPLACE INTO spr_action VALUES ('6822', '67', '38', '24');
REPLACE INTO spr_action VALUES ('6822', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6822', '69', '40', '24');
REPLACE INTO spr_action VALUES ('6822', '70', '44', '24');
REPLACE INTO spr_action VALUES ('6822', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6823', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6823', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6823', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6823', '3', '60', '24');
REPLACE INTO spr_action VALUES ('6823', '4', '18', '24');
REPLACE INTO spr_action VALUES ('6823', '5', '23', '24');
REPLACE INTO spr_action VALUES ('6823', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6823', '7', '60', '24');
REPLACE INTO spr_action VALUES ('6823', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6823', '11', '18', '24');
REPLACE INTO spr_action VALUES ('6823', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6823', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6823', '14', '60', '24');
REPLACE INTO spr_action VALUES ('6823', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6823', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6823', '18', '24', '24');
REPLACE INTO spr_action VALUES ('6823', '19', '28', '24');
REPLACE INTO spr_action VALUES ('6823', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6823', '21', '25', '24');
REPLACE INTO spr_action VALUES ('6823', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6823', '23', '60', '24');
REPLACE INTO spr_action VALUES ('6823', '24', '19', '24');
REPLACE INTO spr_action VALUES ('6823', '25', '20', '24');
REPLACE INTO spr_action VALUES ('6823', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6823', '27', '60', '24');
REPLACE INTO spr_action VALUES ('6823', '40', '17', '24');
REPLACE INTO spr_action VALUES ('6823', '41', '19', '24');
REPLACE INTO spr_action VALUES ('6823', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6823', '43', '60', '24');
REPLACE INTO spr_action VALUES ('6823', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6823', '47', '21', '24');
REPLACE INTO spr_action VALUES ('6823', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6823', '49', '60', '24');
REPLACE INTO spr_action VALUES ('6823', '50', '17', '24');
REPLACE INTO spr_action VALUES ('6823', '51', '18', '24');
REPLACE INTO spr_action VALUES ('6823', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6823', '53', '60', '24');
REPLACE INTO spr_action VALUES ('6823', '55', '23', '24');
REPLACE INTO spr_action VALUES ('6823', '66', '48', '24');
REPLACE INTO spr_action VALUES ('6823', '67', '54', '24');
REPLACE INTO spr_action VALUES ('6823', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6823', '69', '42', '24');
REPLACE INTO spr_action VALUES ('6823', '70', '48', '24');
REPLACE INTO spr_action VALUES ('6823', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6824', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6824', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6824', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6824', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6824', '4', '18', '24');
REPLACE INTO spr_action VALUES ('6824', '5', '22', '24');
REPLACE INTO spr_action VALUES ('6824', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6824', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6824', '8', '40', '24');
REPLACE INTO spr_action VALUES ('6824', '11', '18', '24');
REPLACE INTO spr_action VALUES ('6824', '12', '18', '24');
REPLACE INTO spr_action VALUES ('6824', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6824', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6824', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6824', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6824', '18', '24', '24');
REPLACE INTO spr_action VALUES ('6824', '19', '28', '24');
REPLACE INTO spr_action VALUES ('6824', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6824', '21', '25', '24');
REPLACE INTO spr_action VALUES ('6824', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6824', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6824', '24', '19', '24');
REPLACE INTO spr_action VALUES ('6824', '25', '20', '24');
REPLACE INTO spr_action VALUES ('6824', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6824', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6824', '40', '17', '24');
REPLACE INTO spr_action VALUES ('6824', '41', '20', '24');
REPLACE INTO spr_action VALUES ('6824', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6824', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6824', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6824', '47', '21', '24');
REPLACE INTO spr_action VALUES ('6824', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6824', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6824', '50', '17', '24');
REPLACE INTO spr_action VALUES ('6824', '51', '18', '24');
REPLACE INTO spr_action VALUES ('6824', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6824', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6824', '55', '22', '24');
REPLACE INTO spr_action VALUES ('6824', '56', '18', '24');
REPLACE INTO spr_action VALUES ('6824', '66', '80', '24');
REPLACE INTO spr_action VALUES ('6824', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6824', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6824', '69', '56', '24');
REPLACE INTO spr_action VALUES ('6824', '70', '80', '24');
REPLACE INTO spr_action VALUES ('6824', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6825', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6825', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6825', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6825', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6825', '4', '18', '24');
REPLACE INTO spr_action VALUES ('6825', '5', '22', '24');
REPLACE INTO spr_action VALUES ('6825', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6825', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6825', '8', '76', '24');
REPLACE INTO spr_action VALUES ('6825', '11', '18', '24');
REPLACE INTO spr_action VALUES ('6825', '12', '18', '24');
REPLACE INTO spr_action VALUES ('6825', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6825', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6825', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6825', '17', '33', '24');
REPLACE INTO spr_action VALUES ('6825', '18', '24', '24');
REPLACE INTO spr_action VALUES ('6825', '19', '28', '24');
REPLACE INTO spr_action VALUES ('6825', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6825', '21', '25', '24');
REPLACE INTO spr_action VALUES ('6825', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6825', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6825', '24', '19', '24');
REPLACE INTO spr_action VALUES ('6825', '25', '20', '24');
REPLACE INTO spr_action VALUES ('6825', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6825', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6825', '40', '17', '24');
REPLACE INTO spr_action VALUES ('6825', '41', '20', '24');
REPLACE INTO spr_action VALUES ('6825', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6825', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6825', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6825', '47', '21', '24');
REPLACE INTO spr_action VALUES ('6825', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6825', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6825', '50', '17', '24');
REPLACE INTO spr_action VALUES ('6825', '51', '18', '24');
REPLACE INTO spr_action VALUES ('6825', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6825', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6825', '55', '22', '24');
REPLACE INTO spr_action VALUES ('6825', '56', '18', '24');
REPLACE INTO spr_action VALUES ('6825', '66', '76', '24');
REPLACE INTO spr_action VALUES ('6825', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6825', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6825', '69', '65', '24');
REPLACE INTO spr_action VALUES ('6825', '70', '76', '24');
REPLACE INTO spr_action VALUES ('6825', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6826', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6826', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6826', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6826', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6826', '4', '18', '24');
REPLACE INTO spr_action VALUES ('6826', '5', '21', '24');
REPLACE INTO spr_action VALUES ('6826', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6826', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6826', '8', '28', '24');
REPLACE INTO spr_action VALUES ('6826', '11', '18', '24');
REPLACE INTO spr_action VALUES ('6826', '12', '19', '24');
REPLACE INTO spr_action VALUES ('6826', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6826', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6826', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6826', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6826', '18', '26', '24');
REPLACE INTO spr_action VALUES ('6826', '19', '28', '24');
REPLACE INTO spr_action VALUES ('6826', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6826', '21', '23', '24');
REPLACE INTO spr_action VALUES ('6826', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6826', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6826', '24', '19', '24');
REPLACE INTO spr_action VALUES ('6826', '25', '21', '24');
REPLACE INTO spr_action VALUES ('6826', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6826', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6826', '40', '17', '24');
REPLACE INTO spr_action VALUES ('6826', '41', '21', '24');
REPLACE INTO spr_action VALUES ('6826', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6826', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6826', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6826', '47', '19', '24');
REPLACE INTO spr_action VALUES ('6826', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6826', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6826', '66', '52', '24');
REPLACE INTO spr_action VALUES ('6826', '67', '60', '24');
REPLACE INTO spr_action VALUES ('6826', '68', '44', '24');
REPLACE INTO spr_action VALUES ('6826', '69', '37', '24');
REPLACE INTO spr_action VALUES ('6826', '70', '52', '24');
REPLACE INTO spr_action VALUES ('6826', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6827', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6827', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6827', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6827', '3', '40', '24');
REPLACE INTO spr_action VALUES ('6827', '4', '18', '24');
REPLACE INTO spr_action VALUES ('6827', '5', '21', '24');
REPLACE INTO spr_action VALUES ('6827', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6827', '7', '40', '24');
REPLACE INTO spr_action VALUES ('6827', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6827', '11', '18', '24');
REPLACE INTO spr_action VALUES ('6827', '12', '19', '24');
REPLACE INTO spr_action VALUES ('6827', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6827', '14', '40', '24');
REPLACE INTO spr_action VALUES ('6827', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6827', '17', '37', '24');
REPLACE INTO spr_action VALUES ('6827', '18', '26', '24');
REPLACE INTO spr_action VALUES ('6827', '19', '28', '24');
REPLACE INTO spr_action VALUES ('6827', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6827', '21', '23', '24');
REPLACE INTO spr_action VALUES ('6827', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6827', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6827', '24', '19', '24');
REPLACE INTO spr_action VALUES ('6827', '25', '24', '24');
REPLACE INTO spr_action VALUES ('6827', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6827', '27', '40', '24');
REPLACE INTO spr_action VALUES ('6827', '40', '17', '24');
REPLACE INTO spr_action VALUES ('6827', '41', '21', '24');
REPLACE INTO spr_action VALUES ('6827', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6827', '43', '40', '24');
REPLACE INTO spr_action VALUES ('6827', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6827', '47', '19', '24');
REPLACE INTO spr_action VALUES ('6827', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6827', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6827', '66', '60', '24');
REPLACE INTO spr_action VALUES ('6827', '67', '48', '24');
REPLACE INTO spr_action VALUES ('6827', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6827', '69', '38', '24');
REPLACE INTO spr_action VALUES ('6827', '70', '60', '24');
REPLACE INTO spr_action VALUES ('6827', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6828', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6828', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6828', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6828', '3', '36', '24');
REPLACE INTO spr_action VALUES ('6828', '4', '18', '24');
REPLACE INTO spr_action VALUES ('6828', '5', '24', '24');
REPLACE INTO spr_action VALUES ('6828', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6828', '7', '36', '24');
REPLACE INTO spr_action VALUES ('6828', '8', '60', '24');
REPLACE INTO spr_action VALUES ('6828', '11', '18', '24');
REPLACE INTO spr_action VALUES ('6828', '12', '20', '24');
REPLACE INTO spr_action VALUES ('6828', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6828', '14', '36', '24');
REPLACE INTO spr_action VALUES ('6828', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6828', '17', '31', '24');
REPLACE INTO spr_action VALUES ('6828', '18', '20', '24');
REPLACE INTO spr_action VALUES ('6828', '19', '22', '24');
REPLACE INTO spr_action VALUES ('6828', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6828', '21', '25', '24');
REPLACE INTO spr_action VALUES ('6828', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6828', '23', '36', '24');
REPLACE INTO spr_action VALUES ('6828', '24', '19', '24');
REPLACE INTO spr_action VALUES ('6828', '25', '22', '24');
REPLACE INTO spr_action VALUES ('6828', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6828', '27', '36', '24');
REPLACE INTO spr_action VALUES ('6828', '31', '20', '24');
REPLACE INTO spr_action VALUES ('6828', '40', '17', '24');
REPLACE INTO spr_action VALUES ('6828', '41', '22', '24');
REPLACE INTO spr_action VALUES ('6828', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6828', '43', '36', '24');
REPLACE INTO spr_action VALUES ('6828', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6828', '47', '23', '24');
REPLACE INTO spr_action VALUES ('6828', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6828', '49', '36', '24');
REPLACE INTO spr_action VALUES ('6828', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6828', '67', '44', '24');
REPLACE INTO spr_action VALUES ('6828', '68', '48', '24');
REPLACE INTO spr_action VALUES ('6828', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6828', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6828', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6829', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6829', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6829', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6829', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6829', '4', '18', '24');
REPLACE INTO spr_action VALUES ('6829', '5', '24', '24');
REPLACE INTO spr_action VALUES ('6829', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6829', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6829', '8', '44', '24');
REPLACE INTO spr_action VALUES ('6829', '11', '18', '24');
REPLACE INTO spr_action VALUES ('6829', '12', '20', '24');
REPLACE INTO spr_action VALUES ('6829', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6829', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6829', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6829', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6829', '18', '20', '24');
REPLACE INTO spr_action VALUES ('6829', '19', '22', '24');
REPLACE INTO spr_action VALUES ('6829', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6829', '21', '25', '24');
REPLACE INTO spr_action VALUES ('6829', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6829', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6829', '24', '19', '24');
REPLACE INTO spr_action VALUES ('6829', '25', '22', '24');
REPLACE INTO spr_action VALUES ('6829', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6829', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6829', '31', '20', '24');
REPLACE INTO spr_action VALUES ('6829', '40', '17', '24');
REPLACE INTO spr_action VALUES ('6829', '41', '22', '24');
REPLACE INTO spr_action VALUES ('6829', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6829', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6829', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6829', '47', '23', '24');
REPLACE INTO spr_action VALUES ('6829', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6829', '49', '32', '24');
REPLACE INTO spr_action VALUES ('6829', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6829', '68', '36', '24');
REPLACE INTO spr_action VALUES ('6829', '67', '63', '24');
REPLACE INTO spr_action VALUES ('6829', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6829', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6829', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6832', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6832', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6832', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6832', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6832', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6832', '5', '22', '24');
REPLACE INTO spr_action VALUES ('6832', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6832', '7', '44', '24');
REPLACE INTO spr_action VALUES ('6832', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6832', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6832', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6832', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6832', '14', '44', '24');
REPLACE INTO spr_action VALUES ('6832', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6832', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6832', '18', '24', '24');
REPLACE INTO spr_action VALUES ('6832', '19', '26', '24');
REPLACE INTO spr_action VALUES ('6832', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6832', '21', '25', '24');
REPLACE INTO spr_action VALUES ('6832', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6832', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6832', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6832', '25', '20', '24');
REPLACE INTO spr_action VALUES ('6832', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6832', '27', '44', '24');
REPLACE INTO spr_action VALUES ('6832', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6832', '41', '19', '24');
REPLACE INTO spr_action VALUES ('6832', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6832', '43', '44', '24');
REPLACE INTO spr_action VALUES ('6832', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6832', '47', '20', '24');
REPLACE INTO spr_action VALUES ('6832', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6832', '49', '44', '24');
REPLACE INTO spr_action VALUES ('6832', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6832', '51', '18', '24');
REPLACE INTO spr_action VALUES ('6832', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6832', '53', '44', '24');
REPLACE INTO spr_action VALUES ('6832', '55', '22', '24');
REPLACE INTO spr_action VALUES ('6832', '66', '44', '24');
REPLACE INTO spr_action VALUES ('6832', '67', '38', '24');
REPLACE INTO spr_action VALUES ('6832', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6832', '69', '40', '24');
REPLACE INTO spr_action VALUES ('6832', '70', '44', '24');
REPLACE INTO spr_action VALUES ('6832', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6833', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6833', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6833', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6833', '3', '60', '24');
REPLACE INTO spr_action VALUES ('6833', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6833', '5', '22', '24');
REPLACE INTO spr_action VALUES ('6833', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6833', '7', '60', '24');
REPLACE INTO spr_action VALUES ('6833', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6833', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6833', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6833', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6833', '14', '60', '24');
REPLACE INTO spr_action VALUES ('6833', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6833', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6833', '18', '24', '24');
REPLACE INTO spr_action VALUES ('6833', '19', '26', '24');
REPLACE INTO spr_action VALUES ('6833', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6833', '21', '25', '24');
REPLACE INTO spr_action VALUES ('6833', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6833', '23', '60', '24');
REPLACE INTO spr_action VALUES ('6833', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6833', '25', '20', '24');
REPLACE INTO spr_action VALUES ('6833', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6833', '27', '60', '24');
REPLACE INTO spr_action VALUES ('6833', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6833', '41', '19', '24');
REPLACE INTO spr_action VALUES ('6833', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6833', '43', '60', '24');
REPLACE INTO spr_action VALUES ('6833', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6833', '47', '20', '24');
REPLACE INTO spr_action VALUES ('6833', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6833', '49', '60', '24');
REPLACE INTO spr_action VALUES ('6833', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6833', '51', '18', '24');
REPLACE INTO spr_action VALUES ('6833', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6833', '53', '60', '24');
REPLACE INTO spr_action VALUES ('6833', '55', '22', '24');
REPLACE INTO spr_action VALUES ('6833', '66', '48', '24');
REPLACE INTO spr_action VALUES ('6833', '67', '54', '24');
REPLACE INTO spr_action VALUES ('6833', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6833', '69', '42', '24');
REPLACE INTO spr_action VALUES ('6833', '70', '48', '24');
REPLACE INTO spr_action VALUES ('6833', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6834', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6834', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6834', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6834', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6834', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6834', '5', '21', '24');
REPLACE INTO spr_action VALUES ('6834', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6834', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6834', '8', '40', '24');
REPLACE INTO spr_action VALUES ('6834', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6834', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6834', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6834', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6834', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6834', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6834', '18', '24', '24');
REPLACE INTO spr_action VALUES ('6834', '19', '26', '24');
REPLACE INTO spr_action VALUES ('6834', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6834', '21', '25', '24');
REPLACE INTO spr_action VALUES ('6834', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6834', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6834', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6834', '25', '20', '24');
REPLACE INTO spr_action VALUES ('6834', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6834', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6834', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6834', '41', '20', '24');
REPLACE INTO spr_action VALUES ('6834', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6834', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6834', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6834', '47', '20', '24');
REPLACE INTO spr_action VALUES ('6834', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6834', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6834', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6834', '51', '18', '24');
REPLACE INTO spr_action VALUES ('6834', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6834', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6834', '55', '21', '24');
REPLACE INTO spr_action VALUES ('6834', '56', '18', '24');
REPLACE INTO spr_action VALUES ('6834', '66', '80', '24');
REPLACE INTO spr_action VALUES ('6834', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6834', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6834', '69', '56', '24');
REPLACE INTO spr_action VALUES ('6834', '70', '80', '24');
REPLACE INTO spr_action VALUES ('6834', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6835', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6835', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6835', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6835', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6835', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6835', '5', '21', '24');
REPLACE INTO spr_action VALUES ('6835', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6835', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6835', '8', '76', '24');
REPLACE INTO spr_action VALUES ('6835', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6835', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6835', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6835', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6835', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6835', '17', '33', '24');
REPLACE INTO spr_action VALUES ('6835', '18', '24', '24');
REPLACE INTO spr_action VALUES ('6835', '19', '26', '24');
REPLACE INTO spr_action VALUES ('6835', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6835', '21', '25', '24');
REPLACE INTO spr_action VALUES ('6835', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6835', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6835', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6835', '25', '20', '24');
REPLACE INTO spr_action VALUES ('6835', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6835', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6835', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6835', '41', '20', '24');
REPLACE INTO spr_action VALUES ('6835', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6835', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6835', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6835', '47', '20', '24');
REPLACE INTO spr_action VALUES ('6835', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6835', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6835', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6835', '51', '18', '24');
REPLACE INTO spr_action VALUES ('6835', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6835', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6835', '55', '21', '24');
REPLACE INTO spr_action VALUES ('6835', '56', '18', '24');
REPLACE INTO spr_action VALUES ('6835', '66', '76', '24');
REPLACE INTO spr_action VALUES ('6835', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6835', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6835', '69', '65', '24');
REPLACE INTO spr_action VALUES ('6835', '70', '76', '24');
REPLACE INTO spr_action VALUES ('6835', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6836', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6836', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6836', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6836', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6836', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6836', '5', '20', '24');
REPLACE INTO spr_action VALUES ('6836', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6836', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6836', '8', '28', '24');
REPLACE INTO spr_action VALUES ('6836', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6836', '12', '18', '24');
REPLACE INTO spr_action VALUES ('6836', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6836', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6836', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6836', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6836', '18', '26', '24');
REPLACE INTO spr_action VALUES ('6836', '19', '26', '24');
REPLACE INTO spr_action VALUES ('6836', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6836', '21', '23', '24');
REPLACE INTO spr_action VALUES ('6836', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6836', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6836', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6836', '25', '21', '24');
REPLACE INTO spr_action VALUES ('6836', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6836', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6836', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6836', '41', '21', '24');
REPLACE INTO spr_action VALUES ('6836', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6836', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6836', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6836', '47', '18', '24');
REPLACE INTO spr_action VALUES ('6836', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6836', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6836', '66', '52', '24');
REPLACE INTO spr_action VALUES ('6836', '67', '60', '24');
REPLACE INTO spr_action VALUES ('6836', '68', '44', '24');
REPLACE INTO spr_action VALUES ('6836', '69', '37', '24');
REPLACE INTO spr_action VALUES ('6836', '70', '52', '24');
REPLACE INTO spr_action VALUES ('6836', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6837', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6837', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6837', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6837', '3', '40', '24');
REPLACE INTO spr_action VALUES ('6837', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6837', '5', '20', '24');
REPLACE INTO spr_action VALUES ('6837', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6837', '7', '40', '24');
REPLACE INTO spr_action VALUES ('6837', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6837', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6837', '12', '18', '24');
REPLACE INTO spr_action VALUES ('6837', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6837', '14', '40', '24');
REPLACE INTO spr_action VALUES ('6837', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6837', '17', '37', '24');
REPLACE INTO spr_action VALUES ('6837', '18', '26', '24');
REPLACE INTO spr_action VALUES ('6837', '19', '26', '24');
REPLACE INTO spr_action VALUES ('6837', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6837', '21', '23', '24');
REPLACE INTO spr_action VALUES ('6837', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6837', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6837', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6837', '25', '24', '24');
REPLACE INTO spr_action VALUES ('6837', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6837', '27', '40', '24');
REPLACE INTO spr_action VALUES ('6837', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6837', '41', '21', '24');
REPLACE INTO spr_action VALUES ('6837', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6837', '43', '40', '24');
REPLACE INTO spr_action VALUES ('6837', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6837', '47', '18', '24');
REPLACE INTO spr_action VALUES ('6837', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6837', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6837', '66', '60', '24');
REPLACE INTO spr_action VALUES ('6837', '67', '48', '24');
REPLACE INTO spr_action VALUES ('6837', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6837', '69', '38', '24');
REPLACE INTO spr_action VALUES ('6837', '70', '60', '24');
REPLACE INTO spr_action VALUES ('6837', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6838', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6838', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6838', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6838', '3', '36', '24');
REPLACE INTO spr_action VALUES ('6838', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6838', '5', '23', '24');
REPLACE INTO spr_action VALUES ('6838', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6838', '7', '36', '24');
REPLACE INTO spr_action VALUES ('6838', '8', '60', '24');
REPLACE INTO spr_action VALUES ('6838', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6838', '12', '19', '24');
REPLACE INTO spr_action VALUES ('6838', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6838', '14', '36', '24');
REPLACE INTO spr_action VALUES ('6838', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6838', '17', '31', '24');
REPLACE INTO spr_action VALUES ('6838', '18', '20', '24');
REPLACE INTO spr_action VALUES ('6838', '19', '22', '24');
REPLACE INTO spr_action VALUES ('6838', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6838', '21', '25', '24');
REPLACE INTO spr_action VALUES ('6838', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6838', '23', '36', '24');
REPLACE INTO spr_action VALUES ('6838', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6838', '25', '22', '24');
REPLACE INTO spr_action VALUES ('6838', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6838', '27', '36', '24');
REPLACE INTO spr_action VALUES ('6838', '31', '20', '24');
REPLACE INTO spr_action VALUES ('6838', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6838', '41', '22', '24');
REPLACE INTO spr_action VALUES ('6838', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6838', '43', '36', '24');
REPLACE INTO spr_action VALUES ('6838', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6838', '47', '22', '24');
REPLACE INTO spr_action VALUES ('6838', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6838', '49', '36', '24');
REPLACE INTO spr_action VALUES ('6838', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6838', '67', '44', '24');
REPLACE INTO spr_action VALUES ('6838', '68', '48', '24');
REPLACE INTO spr_action VALUES ('6838', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6838', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6838', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6839', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6839', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6839', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6839', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6839', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6839', '5', '23', '24');
REPLACE INTO spr_action VALUES ('6839', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6839', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6839', '8', '44', '24');
REPLACE INTO spr_action VALUES ('6839', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6839', '12', '19', '24');
REPLACE INTO spr_action VALUES ('6839', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6839', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6839', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6839', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6839', '18', '20', '24');
REPLACE INTO spr_action VALUES ('6839', '19', '22', '24');
REPLACE INTO spr_action VALUES ('6839', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6839', '21', '25', '24');
REPLACE INTO spr_action VALUES ('6839', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6839', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6839', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6839', '25', '22', '24');
REPLACE INTO spr_action VALUES ('6839', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6839', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6839', '31', '20', '24');
REPLACE INTO spr_action VALUES ('6839', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6839', '41', '22', '24');
REPLACE INTO spr_action VALUES ('6839', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6839', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6839', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6839', '47', '22', '24');
REPLACE INTO spr_action VALUES ('6839', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6839', '49', '32', '24');
REPLACE INTO spr_action VALUES ('6839', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6839', '68', '36', '24');
REPLACE INTO spr_action VALUES ('6839', '67', '63', '24');
REPLACE INTO spr_action VALUES ('6839', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6839', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6839', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6842', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6842', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6842', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6842', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6842', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6842', '5', '16', '24');
REPLACE INTO spr_action VALUES ('6842', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6842', '7', '44', '24');
REPLACE INTO spr_action VALUES ('6842', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6842', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6842', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6842', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6842', '14', '44', '24');
REPLACE INTO spr_action VALUES ('6842', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6842', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6842', '18', '19', '24');
REPLACE INTO spr_action VALUES ('6842', '19', '22', '24');
REPLACE INTO spr_action VALUES ('6842', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6842', '21', '20', '24');
REPLACE INTO spr_action VALUES ('6842', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6842', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6842', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6842', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6842', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6842', '27', '44', '24');
REPLACE INTO spr_action VALUES ('6842', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6842', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6842', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6842', '43', '44', '24');
REPLACE INTO spr_action VALUES ('6842', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6842', '47', '15', '24');
REPLACE INTO spr_action VALUES ('6842', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6842', '49', '44', '24');
REPLACE INTO spr_action VALUES ('6842', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6842', '51', '18', '24');
REPLACE INTO spr_action VALUES ('6842', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6842', '53', '44', '24');
REPLACE INTO spr_action VALUES ('6842', '55', '16', '24');
REPLACE INTO spr_action VALUES ('6842', '66', '44', '24');
REPLACE INTO spr_action VALUES ('6842', '67', '38', '24');
REPLACE INTO spr_action VALUES ('6842', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6842', '69', '40', '24');
REPLACE INTO spr_action VALUES ('6842', '70', '44', '24');
REPLACE INTO spr_action VALUES ('6842', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6843', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6843', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6843', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6843', '3', '60', '24');
REPLACE INTO spr_action VALUES ('6843', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6843', '5', '16', '24');
REPLACE INTO spr_action VALUES ('6843', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6843', '7', '60', '24');
REPLACE INTO spr_action VALUES ('6843', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6843', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6843', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6843', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6843', '14', '60', '24');
REPLACE INTO spr_action VALUES ('6843', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6843', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6843', '18', '19', '24');
REPLACE INTO spr_action VALUES ('6843', '19', '22', '24');
REPLACE INTO spr_action VALUES ('6843', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6843', '21', '20', '24');
REPLACE INTO spr_action VALUES ('6843', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6843', '23', '60', '24');
REPLACE INTO spr_action VALUES ('6843', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6843', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6843', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6843', '27', '60', '24');
REPLACE INTO spr_action VALUES ('6843', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6843', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6843', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6843', '43', '60', '24');
REPLACE INTO spr_action VALUES ('6843', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6843', '47', '15', '24');
REPLACE INTO spr_action VALUES ('6843', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6843', '49', '60', '24');
REPLACE INTO spr_action VALUES ('6843', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6843', '51', '18', '24');
REPLACE INTO spr_action VALUES ('6843', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6843', '53', '60', '24');
REPLACE INTO spr_action VALUES ('6843', '55', '16', '24');
REPLACE INTO spr_action VALUES ('6843', '66', '48', '24');
REPLACE INTO spr_action VALUES ('6843', '67', '54', '24');
REPLACE INTO spr_action VALUES ('6843', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6843', '69', '42', '24');
REPLACE INTO spr_action VALUES ('6843', '70', '48', '24');
REPLACE INTO spr_action VALUES ('6843', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6844', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6844', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6844', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6844', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6844', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6844', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6844', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6844', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6844', '8', '40', '24');
REPLACE INTO spr_action VALUES ('6844', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6844', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6844', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6844', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6844', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6844', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6844', '18', '19', '24');
REPLACE INTO spr_action VALUES ('6844', '19', '22', '24');
REPLACE INTO spr_action VALUES ('6844', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6844', '21', '20', '24');
REPLACE INTO spr_action VALUES ('6844', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6844', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6844', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6844', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6844', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6844', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6844', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6844', '41', '16', '24');
REPLACE INTO spr_action VALUES ('6844', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6844', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6844', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6844', '47', '15', '24');
REPLACE INTO spr_action VALUES ('6844', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6844', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6844', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6844', '51', '17', '24');
REPLACE INTO spr_action VALUES ('6844', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6844', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6844', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6844', '56', '17', '24');
REPLACE INTO spr_action VALUES ('6844', '66', '80', '24');
REPLACE INTO spr_action VALUES ('6844', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6844', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6844', '69', '56', '24');
REPLACE INTO spr_action VALUES ('6844', '70', '80', '24');
REPLACE INTO spr_action VALUES ('6844', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6845', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6845', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6845', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6845', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6845', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6845', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6845', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6845', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6845', '8', '76', '24');
REPLACE INTO spr_action VALUES ('6845', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6845', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6845', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6845', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6845', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6845', '17', '33', '24');
REPLACE INTO spr_action VALUES ('6845', '18', '19', '24');
REPLACE INTO spr_action VALUES ('6845', '19', '22', '24');
REPLACE INTO spr_action VALUES ('6845', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6845', '21', '20', '24');
REPLACE INTO spr_action VALUES ('6845', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6845', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6845', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6845', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6845', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6845', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6845', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6845', '41', '16', '24');
REPLACE INTO spr_action VALUES ('6845', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6845', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6845', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6845', '47', '15', '24');
REPLACE INTO spr_action VALUES ('6845', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6845', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6845', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6845', '51', '17', '24');
REPLACE INTO spr_action VALUES ('6845', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6845', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6845', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6845', '56', '17', '24');
REPLACE INTO spr_action VALUES ('6845', '66', '76', '24');
REPLACE INTO spr_action VALUES ('6845', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6845', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6845', '69', '65', '24');
REPLACE INTO spr_action VALUES ('6845', '70', '76', '24');
REPLACE INTO spr_action VALUES ('6845', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6846', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6846', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6846', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6846', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6846', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6846', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6846', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6846', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6846', '8', '28', '24');
REPLACE INTO spr_action VALUES ('6846', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6846', '12', '18', '24');
REPLACE INTO spr_action VALUES ('6846', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6846', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6846', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6846', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6846', '18', '19', '24');
REPLACE INTO spr_action VALUES ('6846', '19', '22', '24');
REPLACE INTO spr_action VALUES ('6846', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6846', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6846', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6846', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6846', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6846', '25', '17', '24');
REPLACE INTO spr_action VALUES ('6846', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6846', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6846', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6846', '41', '16', '24');
REPLACE INTO spr_action VALUES ('6846', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6846', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6846', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6846', '47', '15', '24');
REPLACE INTO spr_action VALUES ('6846', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6846', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6846', '66', '52', '24');
REPLACE INTO spr_action VALUES ('6846', '67', '60', '24');
REPLACE INTO spr_action VALUES ('6846', '68', '44', '24');
REPLACE INTO spr_action VALUES ('6846', '69', '37', '24');
REPLACE INTO spr_action VALUES ('6846', '70', '52', '24');
REPLACE INTO spr_action VALUES ('6846', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6847', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6847', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6847', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6847', '3', '40', '24');
REPLACE INTO spr_action VALUES ('6847', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6847', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6847', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6847', '7', '40', '24');
REPLACE INTO spr_action VALUES ('6847', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6847', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6847', '12', '18', '24');
REPLACE INTO spr_action VALUES ('6847', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6847', '14', '40', '24');
REPLACE INTO spr_action VALUES ('6847', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6847', '17', '37', '24');
REPLACE INTO spr_action VALUES ('6847', '18', '19', '24');
REPLACE INTO spr_action VALUES ('6847', '19', '22', '24');
REPLACE INTO spr_action VALUES ('6847', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6847', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6847', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6847', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6847', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6847', '25', '20', '24');
REPLACE INTO spr_action VALUES ('6847', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6847', '27', '40', '24');
REPLACE INTO spr_action VALUES ('6847', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6847', '41', '16', '24');
REPLACE INTO spr_action VALUES ('6847', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6847', '43', '40', '24');
REPLACE INTO spr_action VALUES ('6847', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6847', '47', '15', '24');
REPLACE INTO spr_action VALUES ('6847', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6847', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6847', '66', '60', '24');
REPLACE INTO spr_action VALUES ('6847', '67', '48', '24');
REPLACE INTO spr_action VALUES ('6847', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6847', '69', '38', '24');
REPLACE INTO spr_action VALUES ('6847', '70', '60', '24');
REPLACE INTO spr_action VALUES ('6847', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6848', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6848', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6848', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6848', '3', '36', '24');
REPLACE INTO spr_action VALUES ('6848', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6848', '5', '16', '24');
REPLACE INTO spr_action VALUES ('6848', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6848', '7', '36', '24');
REPLACE INTO spr_action VALUES ('6848', '8', '60', '24');
REPLACE INTO spr_action VALUES ('6848', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6848', '12', '18', '24');
REPLACE INTO spr_action VALUES ('6848', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6848', '14', '36', '24');
REPLACE INTO spr_action VALUES ('6848', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6848', '17', '31', '24');
REPLACE INTO spr_action VALUES ('6848', '18', '19', '24');
REPLACE INTO spr_action VALUES ('6848', '19', '22', '24');
REPLACE INTO spr_action VALUES ('6848', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6848', '21', '20', '24');
REPLACE INTO spr_action VALUES ('6848', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6848', '23', '36', '24');
REPLACE INTO spr_action VALUES ('6848', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6848', '25', '17', '24');
REPLACE INTO spr_action VALUES ('6848', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6848', '27', '36', '24');
REPLACE INTO spr_action VALUES ('6848', '31', '19', '24');
REPLACE INTO spr_action VALUES ('6848', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6848', '41', '16', '24');
REPLACE INTO spr_action VALUES ('6848', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6848', '43', '36', '24');
REPLACE INTO spr_action VALUES ('6848', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6848', '47', '15', '24');
REPLACE INTO spr_action VALUES ('6848', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6848', '49', '36', '24');
REPLACE INTO spr_action VALUES ('6848', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6848', '67', '44', '24');
REPLACE INTO spr_action VALUES ('6848', '68', '48', '24');
REPLACE INTO spr_action VALUES ('6848', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6848', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6848', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6849', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6849', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6849', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6849', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6849', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6849', '5', '16', '24');
REPLACE INTO spr_action VALUES ('6849', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6849', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6849', '8', '44', '24');
REPLACE INTO spr_action VALUES ('6849', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6849', '12', '18', '24');
REPLACE INTO spr_action VALUES ('6849', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6849', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6849', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6849', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6849', '18', '19', '24');
REPLACE INTO spr_action VALUES ('6849', '19', '22', '24');
REPLACE INTO spr_action VALUES ('6849', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6849', '21', '20', '24');
REPLACE INTO spr_action VALUES ('6849', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6849', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6849', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6849', '25', '17', '24');
REPLACE INTO spr_action VALUES ('6849', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6849', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6849', '31', '19', '24');
REPLACE INTO spr_action VALUES ('6849', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6849', '41', '16', '24');
REPLACE INTO spr_action VALUES ('6849', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6849', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6849', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6849', '47', '15', '24');
REPLACE INTO spr_action VALUES ('6849', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6849', '49', '32', '24');
REPLACE INTO spr_action VALUES ('6849', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6849', '68', '36', '24');
REPLACE INTO spr_action VALUES ('6849', '67', '63', '24');
REPLACE INTO spr_action VALUES ('6849', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6849', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6849', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6852', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6852', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6852', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6852', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6852', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6852', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6852', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6852', '7', '44', '24');
REPLACE INTO spr_action VALUES ('6852', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6852', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6852', '12', '16', '24');
REPLACE INTO spr_action VALUES ('6852', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6852', '14', '44', '24');
REPLACE INTO spr_action VALUES ('6852', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6852', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6852', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6852', '19', '21', '24');
REPLACE INTO spr_action VALUES ('6852', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6852', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6852', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6852', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6852', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6852', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6852', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6852', '27', '44', '24');
REPLACE INTO spr_action VALUES ('6852', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6852', '41', '14', '24');
REPLACE INTO spr_action VALUES ('6852', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6852', '43', '44', '24');
REPLACE INTO spr_action VALUES ('6852', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6852', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6852', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6852', '49', '44', '24');
REPLACE INTO spr_action VALUES ('6852', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6852', '51', '17', '24');
REPLACE INTO spr_action VALUES ('6852', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6852', '53', '44', '24');
REPLACE INTO spr_action VALUES ('6852', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6852', '66', '44', '24');
REPLACE INTO spr_action VALUES ('6852', '67', '38', '24');
REPLACE INTO spr_action VALUES ('6852', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6852', '69', '40', '24');
REPLACE INTO spr_action VALUES ('6852', '70', '44', '24');
REPLACE INTO spr_action VALUES ('6852', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6853', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6853', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6853', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6853', '3', '60', '24');
REPLACE INTO spr_action VALUES ('6853', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6853', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6853', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6853', '7', '60', '24');
REPLACE INTO spr_action VALUES ('6853', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6853', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6853', '12', '16', '24');
REPLACE INTO spr_action VALUES ('6853', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6853', '14', '60', '24');
REPLACE INTO spr_action VALUES ('6853', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6853', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6853', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6853', '19', '21', '24');
REPLACE INTO spr_action VALUES ('6853', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6853', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6853', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6853', '23', '60', '24');
REPLACE INTO spr_action VALUES ('6853', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6853', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6853', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6853', '27', '60', '24');
REPLACE INTO spr_action VALUES ('6853', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6853', '41', '14', '24');
REPLACE INTO spr_action VALUES ('6853', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6853', '43', '60', '24');
REPLACE INTO spr_action VALUES ('6853', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6853', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6853', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6853', '49', '60', '24');
REPLACE INTO spr_action VALUES ('6853', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6853', '51', '17', '24');
REPLACE INTO spr_action VALUES ('6853', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6853', '53', '60', '24');
REPLACE INTO spr_action VALUES ('6853', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6853', '66', '48', '24');
REPLACE INTO spr_action VALUES ('6853', '67', '54', '24');
REPLACE INTO spr_action VALUES ('6853', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6853', '69', '42', '24');
REPLACE INTO spr_action VALUES ('6853', '70', '48', '24');
REPLACE INTO spr_action VALUES ('6853', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6854', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6854', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6854', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6854', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6854', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6854', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6854', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6854', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6854', '8', '40', '24');
REPLACE INTO spr_action VALUES ('6854', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6854', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6854', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6854', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6854', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6854', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6854', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6854', '19', '21', '24');
REPLACE INTO spr_action VALUES ('6854', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6854', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6854', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6854', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6854', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6854', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6854', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6854', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6854', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6854', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6854', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6854', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6854', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6854', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6854', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6854', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6854', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6854', '51', '16', '24');
REPLACE INTO spr_action VALUES ('6854', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6854', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6854', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6854', '56', '18', '24');
REPLACE INTO spr_action VALUES ('6854', '66', '80', '24');
REPLACE INTO spr_action VALUES ('6854', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6854', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6854', '69', '56', '24');
REPLACE INTO spr_action VALUES ('6854', '70', '80', '24');
REPLACE INTO spr_action VALUES ('6854', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6855', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6855', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6855', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6855', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6855', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6855', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6855', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6855', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6855', '8', '76', '24');
REPLACE INTO spr_action VALUES ('6855', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6855', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6855', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6855', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6855', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6855', '17', '33', '24');
REPLACE INTO spr_action VALUES ('6855', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6855', '19', '21', '24');
REPLACE INTO spr_action VALUES ('6855', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6855', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6855', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6855', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6855', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6855', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6855', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6855', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6855', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6855', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6855', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6855', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6855', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6855', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6855', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6855', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6855', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6855', '51', '16', '24');
REPLACE INTO spr_action VALUES ('6855', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6855', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6855', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6855', '56', '18', '24');
REPLACE INTO spr_action VALUES ('6855', '66', '76', '24');
REPLACE INTO spr_action VALUES ('6855', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6855', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6855', '69', '65', '24');
REPLACE INTO spr_action VALUES ('6855', '70', '76', '24');
REPLACE INTO spr_action VALUES ('6855', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6856', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6856', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6856', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6856', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6856', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6856', '5', '14', '24');
REPLACE INTO spr_action VALUES ('6856', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6856', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6856', '8', '28', '24');
REPLACE INTO spr_action VALUES ('6856', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6856', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6856', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6856', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6856', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6856', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6856', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6856', '19', '21', '24');
REPLACE INTO spr_action VALUES ('6856', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6856', '21', '18', '24');
REPLACE INTO spr_action VALUES ('6856', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6856', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6856', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6856', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6856', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6856', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6856', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6856', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6856', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6856', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6856', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6856', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6856', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6856', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6856', '66', '52', '24');
REPLACE INTO spr_action VALUES ('6856', '67', '60', '24');
REPLACE INTO spr_action VALUES ('6856', '68', '44', '24');
REPLACE INTO spr_action VALUES ('6856', '69', '37', '24');
REPLACE INTO spr_action VALUES ('6856', '70', '52', '24');
REPLACE INTO spr_action VALUES ('6856', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6857', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6857', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6857', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6857', '3', '40', '24');
REPLACE INTO spr_action VALUES ('6857', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6857', '5', '14', '24');
REPLACE INTO spr_action VALUES ('6857', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6857', '7', '40', '24');
REPLACE INTO spr_action VALUES ('6857', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6857', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6857', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6857', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6857', '14', '40', '24');
REPLACE INTO spr_action VALUES ('6857', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6857', '17', '37', '24');
REPLACE INTO spr_action VALUES ('6857', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6857', '19', '21', '24');
REPLACE INTO spr_action VALUES ('6857', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6857', '21', '18', '24');
REPLACE INTO spr_action VALUES ('6857', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6857', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6857', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6857', '25', '19', '24');
REPLACE INTO spr_action VALUES ('6857', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6857', '27', '40', '24');
REPLACE INTO spr_action VALUES ('6857', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6857', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6857', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6857', '43', '40', '24');
REPLACE INTO spr_action VALUES ('6857', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6857', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6857', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6857', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6857', '66', '60', '24');
REPLACE INTO spr_action VALUES ('6857', '67', '48', '24');
REPLACE INTO spr_action VALUES ('6857', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6857', '69', '38', '24');
REPLACE INTO spr_action VALUES ('6857', '70', '60', '24');
REPLACE INTO spr_action VALUES ('6857', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6858', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6858', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6858', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6858', '3', '36', '24');
REPLACE INTO spr_action VALUES ('6858', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6858', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6858', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6858', '7', '36', '24');
REPLACE INTO spr_action VALUES ('6858', '8', '60', '24');
REPLACE INTO spr_action VALUES ('6858', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6858', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6858', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6858', '14', '36', '24');
REPLACE INTO spr_action VALUES ('6858', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6858', '17', '31', '24');
REPLACE INTO spr_action VALUES ('6858', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6858', '19', '21', '24');
REPLACE INTO spr_action VALUES ('6858', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6858', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6858', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6858', '23', '36', '24');
REPLACE INTO spr_action VALUES ('6858', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6858', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6858', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6858', '27', '36', '24');
REPLACE INTO spr_action VALUES ('6858', '31', '17', '24');
REPLACE INTO spr_action VALUES ('6858', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6858', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6858', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6858', '43', '36', '24');
REPLACE INTO spr_action VALUES ('6858', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6858', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6858', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6858', '49', '36', '24');
REPLACE INTO spr_action VALUES ('6858', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6858', '67', '44', '24');
REPLACE INTO spr_action VALUES ('6858', '68', '48', '24');
REPLACE INTO spr_action VALUES ('6858', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6858', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6858', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6859', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6859', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6859', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6859', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6859', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6859', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6859', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6859', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6859', '8', '44', '24');
REPLACE INTO spr_action VALUES ('6859', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6859', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6859', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6859', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6859', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6859', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6859', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6859', '19', '21', '24');
REPLACE INTO spr_action VALUES ('6859', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6859', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6859', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6859', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6859', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6859', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6859', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6859', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6859', '31', '17', '24');
REPLACE INTO spr_action VALUES ('6859', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6859', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6859', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6859', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6859', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6859', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6859', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6859', '49', '32', '24');
REPLACE INTO spr_action VALUES ('6859', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6859', '68', '36', '24');
REPLACE INTO spr_action VALUES ('6859', '67', '63', '24');
REPLACE INTO spr_action VALUES ('6859', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6859', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6859', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6862', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6862', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6862', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6862', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6862', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6862', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6862', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6862', '7', '44', '24');
REPLACE INTO spr_action VALUES ('6862', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6862', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6862', '12', '16', '24');
REPLACE INTO spr_action VALUES ('6862', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6862', '14', '44', '24');
REPLACE INTO spr_action VALUES ('6862', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6862', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6862', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6862', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6862', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6862', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6862', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6862', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6862', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6862', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6862', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6862', '27', '44', '24');
REPLACE INTO spr_action VALUES ('6862', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6862', '41', '14', '24');
REPLACE INTO spr_action VALUES ('6862', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6862', '43', '44', '24');
REPLACE INTO spr_action VALUES ('6862', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6862', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6862', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6862', '49', '44', '24');
REPLACE INTO spr_action VALUES ('6862', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6862', '51', '17', '24');
REPLACE INTO spr_action VALUES ('6862', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6862', '53', '44', '24');
REPLACE INTO spr_action VALUES ('6862', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6862', '66', '44', '24');
REPLACE INTO spr_action VALUES ('6862', '67', '38', '24');
REPLACE INTO spr_action VALUES ('6862', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6862', '69', '40', '24');
REPLACE INTO spr_action VALUES ('6862', '70', '44', '24');
REPLACE INTO spr_action VALUES ('6862', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6863', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6863', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6863', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6863', '3', '60', '24');
REPLACE INTO spr_action VALUES ('6863', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6863', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6863', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6863', '7', '60', '24');
REPLACE INTO spr_action VALUES ('6863', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6863', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6863', '12', '16', '24');
REPLACE INTO spr_action VALUES ('6863', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6863', '14', '60', '24');
REPLACE INTO spr_action VALUES ('6863', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6863', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6863', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6863', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6863', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6863', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6863', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6863', '23', '60', '24');
REPLACE INTO spr_action VALUES ('6863', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6863', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6863', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6863', '27', '60', '24');
REPLACE INTO spr_action VALUES ('6863', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6863', '41', '14', '24');
REPLACE INTO spr_action VALUES ('6863', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6863', '43', '60', '24');
REPLACE INTO spr_action VALUES ('6863', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6863', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6863', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6863', '49', '60', '24');
REPLACE INTO spr_action VALUES ('6863', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6863', '51', '17', '24');
REPLACE INTO spr_action VALUES ('6863', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6863', '53', '60', '24');
REPLACE INTO spr_action VALUES ('6863', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6863', '66', '48', '24');
REPLACE INTO spr_action VALUES ('6863', '67', '54', '24');
REPLACE INTO spr_action VALUES ('6863', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6863', '69', '42', '24');
REPLACE INTO spr_action VALUES ('6863', '70', '48', '24');
REPLACE INTO spr_action VALUES ('6863', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6864', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6864', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6864', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6864', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6864', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6864', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6864', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6864', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6864', '8', '40', '24');
REPLACE INTO spr_action VALUES ('6864', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6864', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6864', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6864', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6864', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6864', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6864', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6864', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6864', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6864', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6864', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6864', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6864', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6864', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6864', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6864', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6864', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6864', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6864', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6864', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6864', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6864', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6864', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6864', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6864', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6864', '51', '16', '24');
REPLACE INTO spr_action VALUES ('6864', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6864', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6864', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6864', '56', '18', '24');
REPLACE INTO spr_action VALUES ('6864', '66', '80', '24');
REPLACE INTO spr_action VALUES ('6864', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6864', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6864', '69', '56', '24');
REPLACE INTO spr_action VALUES ('6864', '70', '80', '24');
REPLACE INTO spr_action VALUES ('6864', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6865', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6865', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6865', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6865', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6865', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6865', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6865', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6865', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6865', '8', '76', '24');
REPLACE INTO spr_action VALUES ('6865', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6865', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6865', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6865', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6865', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6865', '17', '33', '24');
REPLACE INTO spr_action VALUES ('6865', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6865', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6865', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6865', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6865', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6865', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6865', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6865', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6865', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6865', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6865', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6865', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6865', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6865', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6865', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6865', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6865', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6865', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6865', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6865', '51', '16', '24');
REPLACE INTO spr_action VALUES ('6865', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6865', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6865', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6865', '56', '18', '24');
REPLACE INTO spr_action VALUES ('6865', '66', '76', '24');
REPLACE INTO spr_action VALUES ('6865', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6865', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6865', '69', '65', '24');
REPLACE INTO spr_action VALUES ('6865', '70', '76', '24');
REPLACE INTO spr_action VALUES ('6865', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6866', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6866', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6866', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6866', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6866', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6866', '5', '14', '24');
REPLACE INTO spr_action VALUES ('6866', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6866', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6866', '8', '28', '24');
REPLACE INTO spr_action VALUES ('6866', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6866', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6866', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6866', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6866', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6866', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6866', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6866', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6866', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6866', '21', '18', '24');
REPLACE INTO spr_action VALUES ('6866', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6866', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6866', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6866', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6866', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6866', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6866', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6866', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6866', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6866', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6866', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6866', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6866', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6866', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6866', '66', '52', '24');
REPLACE INTO spr_action VALUES ('6866', '67', '60', '24');
REPLACE INTO spr_action VALUES ('6866', '68', '44', '24');
REPLACE INTO spr_action VALUES ('6866', '69', '37', '24');
REPLACE INTO spr_action VALUES ('6866', '70', '52', '24');
REPLACE INTO spr_action VALUES ('6866', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6867', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6867', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6867', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6867', '3', '40', '24');
REPLACE INTO spr_action VALUES ('6867', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6867', '5', '14', '24');
REPLACE INTO spr_action VALUES ('6867', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6867', '7', '40', '24');
REPLACE INTO spr_action VALUES ('6867', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6867', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6867', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6867', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6867', '14', '40', '24');
REPLACE INTO spr_action VALUES ('6867', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6867', '17', '37', '24');
REPLACE INTO spr_action VALUES ('6867', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6867', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6867', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6867', '21', '18', '24');
REPLACE INTO spr_action VALUES ('6867', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6867', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6867', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6867', '25', '19', '24');
REPLACE INTO spr_action VALUES ('6867', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6867', '27', '40', '24');
REPLACE INTO spr_action VALUES ('6867', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6867', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6867', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6867', '43', '40', '24');
REPLACE INTO spr_action VALUES ('6867', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6867', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6867', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6867', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6867', '66', '60', '24');
REPLACE INTO spr_action VALUES ('6867', '67', '48', '24');
REPLACE INTO spr_action VALUES ('6867', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6867', '69', '38', '24');
REPLACE INTO spr_action VALUES ('6867', '70', '60', '24');
REPLACE INTO spr_action VALUES ('6867', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6868', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6868', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6868', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6868', '3', '36', '24');
REPLACE INTO spr_action VALUES ('6868', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6868', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6868', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6868', '7', '36', '24');
REPLACE INTO spr_action VALUES ('6868', '8', '60', '24');
REPLACE INTO spr_action VALUES ('6868', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6868', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6868', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6868', '14', '36', '24');
REPLACE INTO spr_action VALUES ('6868', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6868', '17', '31', '24');
REPLACE INTO spr_action VALUES ('6868', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6868', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6868', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6868', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6868', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6868', '23', '36', '24');
REPLACE INTO spr_action VALUES ('6868', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6868', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6868', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6868', '27', '36', '24');
REPLACE INTO spr_action VALUES ('6868', '31', '17', '24');
REPLACE INTO spr_action VALUES ('6868', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6868', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6868', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6868', '43', '36', '24');
REPLACE INTO spr_action VALUES ('6868', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6868', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6868', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6868', '49', '36', '24');
REPLACE INTO spr_action VALUES ('6868', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6868', '67', '44', '24');
REPLACE INTO spr_action VALUES ('6868', '68', '48', '24');
REPLACE INTO spr_action VALUES ('6868', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6868', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6868', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6869', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6869', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6869', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6869', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6869', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6869', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6869', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6869', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6869', '8', '44', '24');
REPLACE INTO spr_action VALUES ('6869', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6869', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6869', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6869', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6869', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6869', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6869', '18', '17', '24');
REPLACE INTO spr_action VALUES ('6869', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6869', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6869', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6869', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6869', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6869', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6869', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6869', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6869', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6869', '31', '17', '24');
REPLACE INTO spr_action VALUES ('6869', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6869', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6869', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6869', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6869', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6869', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6869', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6869', '49', '32', '24');
REPLACE INTO spr_action VALUES ('6869', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6869', '68', '36', '24');
REPLACE INTO spr_action VALUES ('6869', '67', '63', '24');
REPLACE INTO spr_action VALUES ('6869', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6869', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6869', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6872', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6872', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6872', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6872', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6872', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6872', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6872', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6872', '7', '44', '24');
REPLACE INTO spr_action VALUES ('6872', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6872', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6872', '12', '16', '24');
REPLACE INTO spr_action VALUES ('6872', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6872', '14', '44', '24');
REPLACE INTO spr_action VALUES ('6872', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6872', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6872', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6872', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6872', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6872', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6872', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6872', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6872', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6872', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6872', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6872', '27', '44', '24');
REPLACE INTO spr_action VALUES ('6872', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6872', '41', '14', '24');
REPLACE INTO spr_action VALUES ('6872', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6872', '43', '44', '24');
REPLACE INTO spr_action VALUES ('6872', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6872', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6872', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6872', '49', '44', '24');
REPLACE INTO spr_action VALUES ('6872', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6872', '51', '17', '24');
REPLACE INTO spr_action VALUES ('6872', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6872', '53', '44', '24');
REPLACE INTO spr_action VALUES ('6872', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6872', '66', '44', '24');
REPLACE INTO spr_action VALUES ('6872', '67', '38', '24');
REPLACE INTO spr_action VALUES ('6872', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6872', '69', '40', '24');
REPLACE INTO spr_action VALUES ('6872', '70', '44', '24');
REPLACE INTO spr_action VALUES ('6872', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6873', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6873', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6873', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6873', '3', '60', '24');
REPLACE INTO spr_action VALUES ('6873', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6873', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6873', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6873', '7', '60', '24');
REPLACE INTO spr_action VALUES ('6873', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6873', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6873', '12', '16', '24');
REPLACE INTO spr_action VALUES ('6873', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6873', '14', '60', '24');
REPLACE INTO spr_action VALUES ('6873', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6873', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6873', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6873', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6873', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6873', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6873', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6873', '23', '60', '24');
REPLACE INTO spr_action VALUES ('6873', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6873', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6873', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6873', '27', '60', '24');
REPLACE INTO spr_action VALUES ('6873', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6873', '41', '14', '24');
REPLACE INTO spr_action VALUES ('6873', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6873', '43', '60', '24');
REPLACE INTO spr_action VALUES ('6873', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6873', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6873', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6873', '49', '60', '24');
REPLACE INTO spr_action VALUES ('6873', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6873', '51', '17', '24');
REPLACE INTO spr_action VALUES ('6873', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6873', '53', '60', '24');
REPLACE INTO spr_action VALUES ('6873', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6873', '66', '48', '24');
REPLACE INTO spr_action VALUES ('6873', '67', '54', '24');
REPLACE INTO spr_action VALUES ('6873', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6873', '69', '42', '24');
REPLACE INTO spr_action VALUES ('6873', '70', '48', '24');
REPLACE INTO spr_action VALUES ('6873', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6874', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6874', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6874', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6874', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6874', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6874', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6874', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6874', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6874', '8', '40', '24');
REPLACE INTO spr_action VALUES ('6874', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6874', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6874', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6874', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6874', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6874', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6874', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6874', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6874', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6874', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6874', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6874', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6874', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6874', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6874', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6874', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6874', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6874', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6874', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6874', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6874', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6874', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6874', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6874', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6874', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6874', '51', '16', '24');
REPLACE INTO spr_action VALUES ('6874', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6874', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6874', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6874', '56', '18', '24');
REPLACE INTO spr_action VALUES ('6874', '66', '80', '24');
REPLACE INTO spr_action VALUES ('6874', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6874', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6874', '69', '56', '24');
REPLACE INTO spr_action VALUES ('6874', '70', '80', '24');
REPLACE INTO spr_action VALUES ('6874', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6875', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6875', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6875', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6875', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6875', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6875', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6875', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6875', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6875', '8', '76', '24');
REPLACE INTO spr_action VALUES ('6875', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6875', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6875', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6875', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6875', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6875', '17', '33', '24');
REPLACE INTO spr_action VALUES ('6875', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6875', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6875', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6875', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6875', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6875', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6875', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6875', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6875', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6875', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6875', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6875', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6875', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6875', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6875', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6875', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6875', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6875', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6875', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6875', '51', '16', '24');
REPLACE INTO spr_action VALUES ('6875', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6875', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6875', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6875', '56', '18', '24');
REPLACE INTO spr_action VALUES ('6875', '66', '76', '24');
REPLACE INTO spr_action VALUES ('6875', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6875', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6875', '69', '65', '24');
REPLACE INTO spr_action VALUES ('6875', '70', '76', '24');
REPLACE INTO spr_action VALUES ('6875', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6876', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6876', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6876', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6876', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6876', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6876', '5', '14', '24');
REPLACE INTO spr_action VALUES ('6876', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6876', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6876', '8', '28', '24');
REPLACE INTO spr_action VALUES ('6876', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6876', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6876', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6876', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6876', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6876', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6876', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6876', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6876', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6876', '21', '18', '24');
REPLACE INTO spr_action VALUES ('6876', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6876', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6876', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6876', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6876', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6876', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6876', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6876', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6876', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6876', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6876', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6876', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6876', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6876', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6876', '66', '52', '24');
REPLACE INTO spr_action VALUES ('6876', '67', '60', '24');
REPLACE INTO spr_action VALUES ('6876', '68', '44', '24');
REPLACE INTO spr_action VALUES ('6876', '69', '37', '24');
REPLACE INTO spr_action VALUES ('6876', '70', '52', '24');
REPLACE INTO spr_action VALUES ('6876', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6877', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6877', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6877', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6877', '3', '40', '24');
REPLACE INTO spr_action VALUES ('6877', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6877', '5', '14', '24');
REPLACE INTO spr_action VALUES ('6877', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6877', '7', '40', '24');
REPLACE INTO spr_action VALUES ('6877', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6877', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6877', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6877', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6877', '14', '40', '24');
REPLACE INTO spr_action VALUES ('6877', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6877', '17', '37', '24');
REPLACE INTO spr_action VALUES ('6877', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6877', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6877', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6877', '21', '18', '24');
REPLACE INTO spr_action VALUES ('6877', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6877', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6877', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6877', '25', '19', '24');
REPLACE INTO spr_action VALUES ('6877', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6877', '27', '40', '24');
REPLACE INTO spr_action VALUES ('6877', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6877', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6877', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6877', '43', '40', '24');
REPLACE INTO spr_action VALUES ('6877', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6877', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6877', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6877', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6877', '66', '60', '24');
REPLACE INTO spr_action VALUES ('6877', '67', '48', '24');
REPLACE INTO spr_action VALUES ('6877', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6877', '69', '38', '24');
REPLACE INTO spr_action VALUES ('6877', '70', '60', '24');
REPLACE INTO spr_action VALUES ('6877', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6878', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6878', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6878', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6878', '3', '36', '24');
REPLACE INTO spr_action VALUES ('6878', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6878', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6878', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6878', '7', '36', '24');
REPLACE INTO spr_action VALUES ('6878', '8', '60', '24');
REPLACE INTO spr_action VALUES ('6878', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6878', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6878', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6878', '14', '36', '24');
REPLACE INTO spr_action VALUES ('6878', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6878', '17', '31', '24');
REPLACE INTO spr_action VALUES ('6878', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6878', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6878', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6878', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6878', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6878', '23', '36', '24');
REPLACE INTO spr_action VALUES ('6878', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6878', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6878', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6878', '27', '36', '24');
REPLACE INTO spr_action VALUES ('6878', '31', '16', '24');
REPLACE INTO spr_action VALUES ('6878', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6878', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6878', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6878', '43', '36', '24');
REPLACE INTO spr_action VALUES ('6878', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6878', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6878', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6878', '49', '36', '24');
REPLACE INTO spr_action VALUES ('6878', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6878', '67', '44', '24');
REPLACE INTO spr_action VALUES ('6878', '68', '48', '24');
REPLACE INTO spr_action VALUES ('6878', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6878', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6878', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6879', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6879', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6879', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6879', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6879', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6879', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6879', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6879', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6879', '8', '44', '24');
REPLACE INTO spr_action VALUES ('6879', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6879', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6879', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6879', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6879', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6879', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6879', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6879', '19', '20', '24');
REPLACE INTO spr_action VALUES ('6879', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6879', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6879', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6879', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6879', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6879', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6879', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6879', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6879', '31', '16', '24');
REPLACE INTO spr_action VALUES ('6879', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6879', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6879', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6879', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6879', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6879', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6879', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6879', '49', '32', '24');
REPLACE INTO spr_action VALUES ('6879', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6879', '68', '36', '24');
REPLACE INTO spr_action VALUES ('6879', '67', '63', '24');
REPLACE INTO spr_action VALUES ('6879', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6879', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6879', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6882', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6882', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6882', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6882', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6882', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6882', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6882', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6882', '7', '44', '24');
REPLACE INTO spr_action VALUES ('6882', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6882', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6882', '12', '16', '24');
REPLACE INTO spr_action VALUES ('6882', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6882', '14', '44', '24');
REPLACE INTO spr_action VALUES ('6882', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6882', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6882', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6882', '19', '18', '24');
REPLACE INTO spr_action VALUES ('6882', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6882', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6882', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6882', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6882', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6882', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6882', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6882', '27', '44', '24');
REPLACE INTO spr_action VALUES ('6882', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6882', '41', '14', '24');
REPLACE INTO spr_action VALUES ('6882', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6882', '43', '44', '24');
REPLACE INTO spr_action VALUES ('6882', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6882', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6882', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6882', '49', '44', '24');
REPLACE INTO spr_action VALUES ('6882', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6882', '51', '17', '24');
REPLACE INTO spr_action VALUES ('6882', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6882', '53', '44', '24');
REPLACE INTO spr_action VALUES ('6882', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6882', '66', '44', '24');
REPLACE INTO spr_action VALUES ('6882', '67', '38', '24');
REPLACE INTO spr_action VALUES ('6882', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6882', '69', '40', '24');
REPLACE INTO spr_action VALUES ('6882', '70', '44', '24');
REPLACE INTO spr_action VALUES ('6882', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6883', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6883', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6883', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6883', '3', '60', '24');
REPLACE INTO spr_action VALUES ('6883', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6883', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6883', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6883', '7', '60', '24');
REPLACE INTO spr_action VALUES ('6883', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6883', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6883', '12', '16', '24');
REPLACE INTO spr_action VALUES ('6883', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6883', '14', '60', '24');
REPLACE INTO spr_action VALUES ('6883', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6883', '17', '30', '24');
REPLACE INTO spr_action VALUES ('6883', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6883', '19', '18', '24');
REPLACE INTO spr_action VALUES ('6883', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6883', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6883', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6883', '23', '60', '24');
REPLACE INTO spr_action VALUES ('6883', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6883', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6883', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6883', '27', '60', '24');
REPLACE INTO spr_action VALUES ('6883', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6883', '41', '14', '24');
REPLACE INTO spr_action VALUES ('6883', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6883', '43', '60', '24');
REPLACE INTO spr_action VALUES ('6883', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6883', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6883', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6883', '49', '60', '24');
REPLACE INTO spr_action VALUES ('6883', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6883', '51', '17', '24');
REPLACE INTO spr_action VALUES ('6883', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6883', '53', '60', '24');
REPLACE INTO spr_action VALUES ('6883', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6883', '66', '48', '24');
REPLACE INTO spr_action VALUES ('6883', '67', '54', '24');
REPLACE INTO spr_action VALUES ('6883', '68', '46', '24');
REPLACE INTO spr_action VALUES ('6883', '69', '42', '24');
REPLACE INTO spr_action VALUES ('6883', '70', '48', '24');
REPLACE INTO spr_action VALUES ('6883', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6884', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6884', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6884', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6884', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6884', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6884', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6884', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6884', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6884', '8', '40', '24');
REPLACE INTO spr_action VALUES ('6884', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6884', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6884', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6884', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6884', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6884', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6884', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6884', '19', '18', '24');
REPLACE INTO spr_action VALUES ('6884', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6884', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6884', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6884', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6884', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6884', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6884', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6884', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6884', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6884', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6884', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6884', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6884', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6884', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6884', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6884', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6884', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6884', '51', '16', '24');
REPLACE INTO spr_action VALUES ('6884', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6884', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6884', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6884', '56', '18', '24');
REPLACE INTO spr_action VALUES ('6884', '66', '80', '24');
REPLACE INTO spr_action VALUES ('6884', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6884', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6884', '69', '56', '24');
REPLACE INTO spr_action VALUES ('6884', '70', '80', '24');
REPLACE INTO spr_action VALUES ('6884', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6885', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6885', '1', '20', '24');
REPLACE INTO spr_action VALUES ('6885', '2', '14', '24');
REPLACE INTO spr_action VALUES ('6885', '3', '52', '24');
REPLACE INTO spr_action VALUES ('6885', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6885', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6885', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6885', '7', '52', '24');
REPLACE INTO spr_action VALUES ('6885', '8', '76', '24');
REPLACE INTO spr_action VALUES ('6885', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6885', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6885', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6885', '14', '52', '24');
REPLACE INTO spr_action VALUES ('6885', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6885', '17', '33', '24');
REPLACE INTO spr_action VALUES ('6885', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6885', '19', '18', '24');
REPLACE INTO spr_action VALUES ('6885', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6885', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6885', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6885', '23', '52', '24');
REPLACE INTO spr_action VALUES ('6885', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6885', '25', '15', '24');
REPLACE INTO spr_action VALUES ('6885', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6885', '27', '52', '24');
REPLACE INTO spr_action VALUES ('6885', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6885', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6885', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6885', '43', '52', '24');
REPLACE INTO spr_action VALUES ('6885', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6885', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6885', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6885', '49', '52', '24');
REPLACE INTO spr_action VALUES ('6885', '50', '16', '24');
REPLACE INTO spr_action VALUES ('6885', '51', '16', '24');
REPLACE INTO spr_action VALUES ('6885', '52', '14', '24');
REPLACE INTO spr_action VALUES ('6885', '53', '52', '24');
REPLACE INTO spr_action VALUES ('6885', '55', '15', '24');
REPLACE INTO spr_action VALUES ('6885', '56', '18', '24');
REPLACE INTO spr_action VALUES ('6885', '66', '76', '24');
REPLACE INTO spr_action VALUES ('6885', '67', '68', '24');
REPLACE INTO spr_action VALUES ('6885', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6885', '69', '65', '24');
REPLACE INTO spr_action VALUES ('6885', '70', '76', '24');
REPLACE INTO spr_action VALUES ('6885', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6886', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6886', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6886', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6886', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6886', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6886', '5', '14', '24');
REPLACE INTO spr_action VALUES ('6886', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6886', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6886', '8', '28', '24');
REPLACE INTO spr_action VALUES ('6886', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6886', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6886', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6886', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6886', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6886', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6886', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6886', '19', '18', '24');
REPLACE INTO spr_action VALUES ('6886', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6886', '21', '18', '24');
REPLACE INTO spr_action VALUES ('6886', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6886', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6886', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6886', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6886', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6886', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6886', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6886', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6886', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6886', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6886', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6886', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6886', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6886', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6886', '66', '52', '24');
REPLACE INTO spr_action VALUES ('6886', '67', '60', '24');
REPLACE INTO spr_action VALUES ('6886', '68', '44', '24');
REPLACE INTO spr_action VALUES ('6886', '69', '37', '24');
REPLACE INTO spr_action VALUES ('6886', '70', '52', '24');
REPLACE INTO spr_action VALUES ('6886', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6887', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6887', '1', '19', '24');
REPLACE INTO spr_action VALUES ('6887', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6887', '3', '40', '24');
REPLACE INTO spr_action VALUES ('6887', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6887', '5', '14', '24');
REPLACE INTO spr_action VALUES ('6887', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6887', '7', '40', '24');
REPLACE INTO spr_action VALUES ('6887', '8', '48', '24');
REPLACE INTO spr_action VALUES ('6887', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6887', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6887', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6887', '14', '40', '24');
REPLACE INTO spr_action VALUES ('6887', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6887', '17', '37', '24');
REPLACE INTO spr_action VALUES ('6887', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6887', '19', '18', '24');
REPLACE INTO spr_action VALUES ('6887', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6887', '21', '18', '24');
REPLACE INTO spr_action VALUES ('6887', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6887', '23', '40', '24');
REPLACE INTO spr_action VALUES ('6887', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6887', '25', '19', '24');
REPLACE INTO spr_action VALUES ('6887', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6887', '27', '40', '24');
REPLACE INTO spr_action VALUES ('6887', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6887', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6887', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6887', '43', '40', '24');
REPLACE INTO spr_action VALUES ('6887', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6887', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6887', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6887', '49', '40', '24');
REPLACE INTO spr_action VALUES ('6887', '66', '60', '24');
REPLACE INTO spr_action VALUES ('6887', '67', '48', '24');
REPLACE INTO spr_action VALUES ('6887', '68', '52', '24');
REPLACE INTO spr_action VALUES ('6887', '69', '38', '24');
REPLACE INTO spr_action VALUES ('6887', '70', '60', '24');
REPLACE INTO spr_action VALUES ('6887', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6888', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6888', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6888', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6888', '3', '36', '24');
REPLACE INTO spr_action VALUES ('6888', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6888', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6888', '6', '12', '24');
REPLACE INTO spr_action VALUES ('6888', '7', '36', '24');
REPLACE INTO spr_action VALUES ('6888', '8', '60', '24');
REPLACE INTO spr_action VALUES ('6888', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6888', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6888', '13', '12', '24');
REPLACE INTO spr_action VALUES ('6888', '14', '36', '24');
REPLACE INTO spr_action VALUES ('6888', '15', '16', '24');
REPLACE INTO spr_action VALUES ('6888', '17', '31', '24');
REPLACE INTO spr_action VALUES ('6888', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6888', '19', '18', '24');
REPLACE INTO spr_action VALUES ('6888', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6888', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6888', '22', '12', '24');
REPLACE INTO spr_action VALUES ('6888', '23', '36', '24');
REPLACE INTO spr_action VALUES ('6888', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6888', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6888', '26', '12', '24');
REPLACE INTO spr_action VALUES ('6888', '27', '36', '24');
REPLACE INTO spr_action VALUES ('6888', '31', '16', '24');
REPLACE INTO spr_action VALUES ('6888', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6888', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6888', '42', '12', '24');
REPLACE INTO spr_action VALUES ('6888', '43', '36', '24');
REPLACE INTO spr_action VALUES ('6888', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6888', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6888', '48', '12', '24');
REPLACE INTO spr_action VALUES ('6888', '49', '36', '24');
REPLACE INTO spr_action VALUES ('6888', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6888', '67', '44', '24');
REPLACE INTO spr_action VALUES ('6888', '68', '48', '24');
REPLACE INTO spr_action VALUES ('6888', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6888', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6888', '71', '48', '24');
REPLACE INTO spr_action VALUES ('6889', '0', '16', '24');
REPLACE INTO spr_action VALUES ('6889', '1', '22', '24');
REPLACE INTO spr_action VALUES ('6889', '2', '12', '24');
REPLACE INTO spr_action VALUES ('6889', '3', '32', '24');
REPLACE INTO spr_action VALUES ('6889', '4', '16', '24');
REPLACE INTO spr_action VALUES ('6889', '5', '15', '24');
REPLACE INTO spr_action VALUES ('6889', '6', '14', '24');
REPLACE INTO spr_action VALUES ('6889', '7', '32', '24');
REPLACE INTO spr_action VALUES ('6889', '8', '44', '24');
REPLACE INTO spr_action VALUES ('6889', '11', '16', '24');
REPLACE INTO spr_action VALUES ('6889', '12', '17', '24');
REPLACE INTO spr_action VALUES ('6889', '13', '14', '24');
REPLACE INTO spr_action VALUES ('6889', '14', '32', '24');
REPLACE INTO spr_action VALUES ('6889', '15', '13', '24');
REPLACE INTO spr_action VALUES ('6889', '17', '28', '24');
REPLACE INTO spr_action VALUES ('6889', '18', '16', '24');
REPLACE INTO spr_action VALUES ('6889', '19', '18', '24');
REPLACE INTO spr_action VALUES ('6889', '20', '16', '24');
REPLACE INTO spr_action VALUES ('6889', '21', '19', '24');
REPLACE INTO spr_action VALUES ('6889', '22', '14', '24');
REPLACE INTO spr_action VALUES ('6889', '23', '32', '24');
REPLACE INTO spr_action VALUES ('6889', '24', '16', '24');
REPLACE INTO spr_action VALUES ('6889', '25', '16', '24');
REPLACE INTO spr_action VALUES ('6889', '26', '14', '24');
REPLACE INTO spr_action VALUES ('6889', '27', '32', '24');
REPLACE INTO spr_action VALUES ('6889', '31', '16', '24');
REPLACE INTO spr_action VALUES ('6889', '40', '16', '24');
REPLACE INTO spr_action VALUES ('6889', '41', '15', '24');
REPLACE INTO spr_action VALUES ('6889', '42', '14', '24');
REPLACE INTO spr_action VALUES ('6889', '43', '32', '24');
REPLACE INTO spr_action VALUES ('6889', '46', '16', '24');
REPLACE INTO spr_action VALUES ('6889', '47', '14', '24');
REPLACE INTO spr_action VALUES ('6889', '48', '14', '24');
REPLACE INTO spr_action VALUES ('6889', '49', '32', '24');
REPLACE INTO spr_action VALUES ('6889', '66', '64', '24');
REPLACE INTO spr_action VALUES ('6889', '68', '36', '24');
REPLACE INTO spr_action VALUES ('6889', '67', '63', '24');
REPLACE INTO spr_action VALUES ('6889', '69', '52', '24');
REPLACE INTO spr_action VALUES ('6889', '70', '64', '24');
REPLACE INTO spr_action VALUES ('6889', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7139', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7139', '1', '20', '24');
REPLACE INTO spr_action VALUES ('7139', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7139', '3', '48', '24');
REPLACE INTO spr_action VALUES ('7139', '8', '64', '24');
REPLACE INTO spr_action VALUES ('7139', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7139', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7139', '18', '26', '24');
REPLACE INTO spr_action VALUES ('7139', '19', '28', '24');
REPLACE INTO spr_action VALUES ('7139', '4', '18', '24');
REPLACE INTO spr_action VALUES ('7139', '5', '23', '24');
REPLACE INTO spr_action VALUES ('7139', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7139', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7139', '11', '18', '24');
REPLACE INTO spr_action VALUES ('7139', '12', '17', '24');
REPLACE INTO spr_action VALUES ('7139', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7139', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7139', '24', '19', '24');
REPLACE INTO spr_action VALUES ('7139', '25', '21', '24');
REPLACE INTO spr_action VALUES ('7139', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7139', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7139', '41', '21', '24');
REPLACE INTO spr_action VALUES ('7139', '50', '17', '24');
REPLACE INTO spr_action VALUES ('7139', '51', '18', '24');
REPLACE INTO spr_action VALUES ('7139', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7139', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7139', '55', '18', '24');
REPLACE INTO spr_action VALUES ('7139', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7139', '63', '24', '24');
REPLACE INTO spr_action VALUES ('7139', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7139', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7139', '66', '80', '24');
REPLACE INTO spr_action VALUES ('7139', '67', '64', '24');
REPLACE INTO spr_action VALUES ('7139', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7139', '69', '48', '24');
REPLACE INTO spr_action VALUES ('7139', '70', '80', '24');
REPLACE INTO spr_action VALUES ('7139', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7140', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7140', '1', '23', '24');
REPLACE INTO spr_action VALUES ('7140', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7140', '3', '52', '24');
REPLACE INTO spr_action VALUES ('7140', '8', '56', '24');
REPLACE INTO spr_action VALUES ('7140', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7140', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7140', '18', '26', '24');
REPLACE INTO spr_action VALUES ('7140', '19', '28', '24');
REPLACE INTO spr_action VALUES ('7140', '4', '18', '24');
REPLACE INTO spr_action VALUES ('7140', '5', '23', '24');
REPLACE INTO spr_action VALUES ('7140', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7140', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7140', '11', '18', '24');
REPLACE INTO spr_action VALUES ('7140', '12', '17', '24');
REPLACE INTO spr_action VALUES ('7140', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7140', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7140', '24', '19', '24');
REPLACE INTO spr_action VALUES ('7140', '25', '21', '24');
REPLACE INTO spr_action VALUES ('7140', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7140', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7140', '41', '21', '24');
REPLACE INTO spr_action VALUES ('7140', '50', '17', '24');
REPLACE INTO spr_action VALUES ('7140', '51', '18', '24');
REPLACE INTO spr_action VALUES ('7140', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7140', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7140', '55', '18', '24');
REPLACE INTO spr_action VALUES ('7140', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7140', '63', '24', '24');
REPLACE INTO spr_action VALUES ('7140', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7140', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7140', '66', '60', '24');
REPLACE INTO spr_action VALUES ('7140', '67', '56', '24');
REPLACE INTO spr_action VALUES ('7140', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7140', '69', '44', '24');
REPLACE INTO spr_action VALUES ('7140', '70', '60', '24');
REPLACE INTO spr_action VALUES ('7140', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7143', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7143', '1', '20', '24');
REPLACE INTO spr_action VALUES ('7143', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7143', '3', '48', '24');
REPLACE INTO spr_action VALUES ('7143', '8', '64', '24');
REPLACE INTO spr_action VALUES ('7143', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7143', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7143', '18', '26', '24');
REPLACE INTO spr_action VALUES ('7143', '19', '26', '24');
REPLACE INTO spr_action VALUES ('7143', '4', '16', '24');
REPLACE INTO spr_action VALUES ('7143', '5', '22', '24');
REPLACE INTO spr_action VALUES ('7143', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7143', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7143', '11', '16', '24');
REPLACE INTO spr_action VALUES ('7143', '12', '17', '24');
REPLACE INTO spr_action VALUES ('7143', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7143', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7143', '24', '16', '24');
REPLACE INTO spr_action VALUES ('7143', '25', '20', '24');
REPLACE INTO spr_action VALUES ('7143', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7143', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7143', '41', '20', '24');
REPLACE INTO spr_action VALUES ('7143', '50', '17', '24');
REPLACE INTO spr_action VALUES ('7143', '51', '18', '24');
REPLACE INTO spr_action VALUES ('7143', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7143', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7143', '55', '18', '24');
REPLACE INTO spr_action VALUES ('7143', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7143', '63', '23', '24');
REPLACE INTO spr_action VALUES ('7143', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7143', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7143', '66', '80', '24');
REPLACE INTO spr_action VALUES ('7143', '67', '64', '24');
REPLACE INTO spr_action VALUES ('7143', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7143', '69', '48', '24');
REPLACE INTO spr_action VALUES ('7143', '70', '80', '24');
REPLACE INTO spr_action VALUES ('7143', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7144', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7144', '1', '23', '24');
REPLACE INTO spr_action VALUES ('7144', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7144', '3', '52', '24');
REPLACE INTO spr_action VALUES ('7144', '8', '56', '24');
REPLACE INTO spr_action VALUES ('7144', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7144', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7144', '18', '26', '24');
REPLACE INTO spr_action VALUES ('7144', '19', '26', '24');
REPLACE INTO spr_action VALUES ('7144', '4', '16', '24');
REPLACE INTO spr_action VALUES ('7144', '5', '22', '24');
REPLACE INTO spr_action VALUES ('7144', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7144', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7144', '11', '16', '24');
REPLACE INTO spr_action VALUES ('7144', '12', '17', '24');
REPLACE INTO spr_action VALUES ('7144', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7144', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7144', '24', '16', '24');
REPLACE INTO spr_action VALUES ('7144', '25', '20', '24');
REPLACE INTO spr_action VALUES ('7144', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7144', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7144', '41', '20', '24');
REPLACE INTO spr_action VALUES ('7144', '50', '17', '24');
REPLACE INTO spr_action VALUES ('7144', '51', '18', '24');
REPLACE INTO spr_action VALUES ('7144', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7144', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7144', '55', '18', '24');
REPLACE INTO spr_action VALUES ('7144', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7144', '63', '23', '24');
REPLACE INTO spr_action VALUES ('7144', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7144', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7144', '66', '60', '24');
REPLACE INTO spr_action VALUES ('7144', '67', '56', '24');
REPLACE INTO spr_action VALUES ('7144', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7144', '69', '44', '24');
REPLACE INTO spr_action VALUES ('7144', '70', '60', '24');
REPLACE INTO spr_action VALUES ('7144', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7147', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7147', '1', '20', '24');
REPLACE INTO spr_action VALUES ('7147', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7147', '3', '48', '24');
REPLACE INTO spr_action VALUES ('7147', '8', '64', '24');
REPLACE INTO spr_action VALUES ('7147', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7147', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7147', '18', '19', '24');
REPLACE INTO spr_action VALUES ('7147', '19', '22', '24');
REPLACE INTO spr_action VALUES ('7147', '4', '16', '24');
REPLACE INTO spr_action VALUES ('7147', '5', '16', '24');
REPLACE INTO spr_action VALUES ('7147', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7147', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7147', '11', '16', '24');
REPLACE INTO spr_action VALUES ('7147', '12', '17', '24');
REPLACE INTO spr_action VALUES ('7147', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7147', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7147', '24', '16', '24');
REPLACE INTO spr_action VALUES ('7147', '25', '16', '24');
REPLACE INTO spr_action VALUES ('7147', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7147', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7147', '41', '16', '24');
REPLACE INTO spr_action VALUES ('7147', '50', '16', '24');
REPLACE INTO spr_action VALUES ('7147', '51', '17', '24');
REPLACE INTO spr_action VALUES ('7147', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7147', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7147', '55', '17', '24');
REPLACE INTO spr_action VALUES ('7147', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7147', '63', '19', '24');
REPLACE INTO spr_action VALUES ('7147', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7147', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7147', '66', '80', '24');
REPLACE INTO spr_action VALUES ('7147', '67', '64', '24');
REPLACE INTO spr_action VALUES ('7147', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7147', '69', '48', '24');
REPLACE INTO spr_action VALUES ('7147', '70', '80', '24');
REPLACE INTO spr_action VALUES ('7147', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7148', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7148', '1', '23', '24');
REPLACE INTO spr_action VALUES ('7148', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7148', '3', '52', '24');
REPLACE INTO spr_action VALUES ('7148', '8', '56', '24');
REPLACE INTO spr_action VALUES ('7148', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7148', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7148', '18', '19', '24');
REPLACE INTO spr_action VALUES ('7148', '19', '22', '24');
REPLACE INTO spr_action VALUES ('7148', '4', '16', '24');
REPLACE INTO spr_action VALUES ('7148', '5', '16', '24');
REPLACE INTO spr_action VALUES ('7148', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7148', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7148', '11', '16', '24');
REPLACE INTO spr_action VALUES ('7148', '12', '17', '24');
REPLACE INTO spr_action VALUES ('7148', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7148', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7148', '24', '16', '24');
REPLACE INTO spr_action VALUES ('7148', '25', '16', '24');
REPLACE INTO spr_action VALUES ('7148', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7148', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7148', '41', '16', '24');
REPLACE INTO spr_action VALUES ('7148', '50', '16', '24');
REPLACE INTO spr_action VALUES ('7148', '51', '17', '24');
REPLACE INTO spr_action VALUES ('7148', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7148', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7148', '55', '17', '24');
REPLACE INTO spr_action VALUES ('7148', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7148', '63', '19', '24');
REPLACE INTO spr_action VALUES ('7148', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7148', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7148', '66', '60', '24');
REPLACE INTO spr_action VALUES ('7148', '67', '56', '24');
REPLACE INTO spr_action VALUES ('7148', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7148', '69', '44', '24');
REPLACE INTO spr_action VALUES ('7148', '70', '60', '24');
REPLACE INTO spr_action VALUES ('7148', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7151', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7151', '1', '20', '24');
REPLACE INTO spr_action VALUES ('7151', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7151', '3', '48', '24');
REPLACE INTO spr_action VALUES ('7151', '8', '64', '24');
REPLACE INTO spr_action VALUES ('7151', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7151', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7151', '18', '17', '24');
REPLACE INTO spr_action VALUES ('7151', '19', '21', '24');
REPLACE INTO spr_action VALUES ('7151', '4', '16', '24');
REPLACE INTO spr_action VALUES ('7151', '5', '15', '24');
REPLACE INTO spr_action VALUES ('7151', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7151', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7151', '11', '16', '24');
REPLACE INTO spr_action VALUES ('7151', '12', '16', '24');
REPLACE INTO spr_action VALUES ('7151', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7151', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7151', '24', '16', '24');
REPLACE INTO spr_action VALUES ('7151', '25', '15', '24');
REPLACE INTO spr_action VALUES ('7151', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7151', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7151', '41', '15', '24');
REPLACE INTO spr_action VALUES ('7151', '50', '16', '24');
REPLACE INTO spr_action VALUES ('7151', '51', '16', '24');
REPLACE INTO spr_action VALUES ('7151', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7151', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7151', '55', '16', '24');
REPLACE INTO spr_action VALUES ('7151', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7151', '63', '18', '24');
REPLACE INTO spr_action VALUES ('7151', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7151', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7151', '66', '80', '24');
REPLACE INTO spr_action VALUES ('7151', '67', '64', '24');
REPLACE INTO spr_action VALUES ('7151', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7151', '69', '48', '24');
REPLACE INTO spr_action VALUES ('7151', '70', '80', '24');
REPLACE INTO spr_action VALUES ('7151', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7152', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7152', '1', '23', '24');
REPLACE INTO spr_action VALUES ('7152', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7152', '3', '52', '24');
REPLACE INTO spr_action VALUES ('7152', '8', '56', '24');
REPLACE INTO spr_action VALUES ('7152', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7152', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7152', '18', '17', '24');
REPLACE INTO spr_action VALUES ('7152', '19', '21', '24');
REPLACE INTO spr_action VALUES ('7152', '4', '16', '24');
REPLACE INTO spr_action VALUES ('7152', '5', '15', '24');
REPLACE INTO spr_action VALUES ('7152', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7152', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7152', '11', '16', '24');
REPLACE INTO spr_action VALUES ('7152', '12', '16', '24');
REPLACE INTO spr_action VALUES ('7152', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7152', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7152', '24', '16', '24');
REPLACE INTO spr_action VALUES ('7152', '25', '15', '24');
REPLACE INTO spr_action VALUES ('7152', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7152', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7152', '41', '15', '24');
REPLACE INTO spr_action VALUES ('7152', '50', '16', '24');
REPLACE INTO spr_action VALUES ('7152', '51', '16', '24');
REPLACE INTO spr_action VALUES ('7152', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7152', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7152', '55', '16', '24');
REPLACE INTO spr_action VALUES ('7152', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7152', '63', '18', '24');
REPLACE INTO spr_action VALUES ('7152', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7152', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7152', '66', '60', '24');
REPLACE INTO spr_action VALUES ('7152', '67', '56', '24');
REPLACE INTO spr_action VALUES ('7152', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7152', '69', '44', '24');
REPLACE INTO spr_action VALUES ('7152', '70', '60', '24');
REPLACE INTO spr_action VALUES ('7152', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7155', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7155', '1', '20', '24');
REPLACE INTO spr_action VALUES ('7155', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7155', '3', '48', '24');
REPLACE INTO spr_action VALUES ('7155', '8', '64', '24');
REPLACE INTO spr_action VALUES ('7155', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7155', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7155', '18', '17', '24');
REPLACE INTO spr_action VALUES ('7155', '19', '20', '24');
REPLACE INTO spr_action VALUES ('7155', '4', '16', '24');
REPLACE INTO spr_action VALUES ('7155', '5', '15', '24');
REPLACE INTO spr_action VALUES ('7155', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7155', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7155', '11', '16', '24');
REPLACE INTO spr_action VALUES ('7155', '12', '16', '24');
REPLACE INTO spr_action VALUES ('7155', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7155', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7155', '24', '16', '24');
REPLACE INTO spr_action VALUES ('7155', '25', '15', '24');
REPLACE INTO spr_action VALUES ('7155', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7155', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7155', '41', '15', '24');
REPLACE INTO spr_action VALUES ('7155', '50', '16', '24');
REPLACE INTO spr_action VALUES ('7155', '51', '16', '24');
REPLACE INTO spr_action VALUES ('7155', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7155', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7155', '55', '16', '24');
REPLACE INTO spr_action VALUES ('7155', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7155', '63', '18', '24');
REPLACE INTO spr_action VALUES ('7155', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7155', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7155', '66', '80', '24');
REPLACE INTO spr_action VALUES ('7155', '67', '64', '24');
REPLACE INTO spr_action VALUES ('7155', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7155', '69', '48', '24');
REPLACE INTO spr_action VALUES ('7155', '70', '80', '24');
REPLACE INTO spr_action VALUES ('7155', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7156', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7156', '1', '23', '24');
REPLACE INTO spr_action VALUES ('7156', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7156', '3', '52', '24');
REPLACE INTO spr_action VALUES ('7156', '8', '56', '24');
REPLACE INTO spr_action VALUES ('7156', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7156', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7156', '18', '17', '24');
REPLACE INTO spr_action VALUES ('7156', '19', '20', '24');
REPLACE INTO spr_action VALUES ('7156', '4', '16', '24');
REPLACE INTO spr_action VALUES ('7156', '5', '15', '24');
REPLACE INTO spr_action VALUES ('7156', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7156', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7156', '11', '16', '24');
REPLACE INTO spr_action VALUES ('7156', '12', '16', '24');
REPLACE INTO spr_action VALUES ('7156', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7156', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7156', '24', '16', '24');
REPLACE INTO spr_action VALUES ('7156', '25', '15', '24');
REPLACE INTO spr_action VALUES ('7156', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7156', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7156', '41', '15', '24');
REPLACE INTO spr_action VALUES ('7156', '50', '16', '24');
REPLACE INTO spr_action VALUES ('7156', '51', '16', '24');
REPLACE INTO spr_action VALUES ('7156', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7156', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7156', '55', '16', '24');
REPLACE INTO spr_action VALUES ('7156', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7156', '63', '18', '24');
REPLACE INTO spr_action VALUES ('7156', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7156', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7156', '66', '60', '24');
REPLACE INTO spr_action VALUES ('7156', '67', '56', '24');
REPLACE INTO spr_action VALUES ('7156', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7156', '69', '44', '24');
REPLACE INTO spr_action VALUES ('7156', '70', '60', '24');
REPLACE INTO spr_action VALUES ('7156', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7159', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7159', '1', '20', '24');
REPLACE INTO spr_action VALUES ('7159', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7159', '3', '48', '24');
REPLACE INTO spr_action VALUES ('7159', '8', '64', '24');
REPLACE INTO spr_action VALUES ('7159', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7159', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7159', '18', '16', '24');
REPLACE INTO spr_action VALUES ('7159', '19', '20', '24');
REPLACE INTO spr_action VALUES ('7159', '4', '16', '24');
REPLACE INTO spr_action VALUES ('7159', '5', '15', '24');
REPLACE INTO spr_action VALUES ('7159', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7159', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7159', '11', '16', '24');
REPLACE INTO spr_action VALUES ('7159', '12', '16', '24');
REPLACE INTO spr_action VALUES ('7159', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7159', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7159', '24', '16', '24');
REPLACE INTO spr_action VALUES ('7159', '25', '15', '24');
REPLACE INTO spr_action VALUES ('7159', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7159', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7159', '41', '15', '24');
REPLACE INTO spr_action VALUES ('7159', '50', '16', '24');
REPLACE INTO spr_action VALUES ('7159', '51', '16', '24');
REPLACE INTO spr_action VALUES ('7159', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7159', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7159', '55', '16', '24');
REPLACE INTO spr_action VALUES ('7159', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7159', '63', '18', '24');
REPLACE INTO spr_action VALUES ('7159', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7159', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7159', '66', '80', '24');
REPLACE INTO spr_action VALUES ('7159', '67', '64', '24');
REPLACE INTO spr_action VALUES ('7159', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7159', '69', '48', '24');
REPLACE INTO spr_action VALUES ('7159', '70', '80', '24');
REPLACE INTO spr_action VALUES ('7159', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7160', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7160', '1', '23', '24');
REPLACE INTO spr_action VALUES ('7160', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7160', '3', '52', '24');
REPLACE INTO spr_action VALUES ('7160', '8', '56', '24');
REPLACE INTO spr_action VALUES ('7160', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7160', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7160', '18', '16', '24');
REPLACE INTO spr_action VALUES ('7160', '19', '20', '24');
REPLACE INTO spr_action VALUES ('7160', '4', '16', '24');
REPLACE INTO spr_action VALUES ('7160', '5', '15', '24');
REPLACE INTO spr_action VALUES ('7160', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7160', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7160', '11', '16', '24');
REPLACE INTO spr_action VALUES ('7160', '12', '16', '24');
REPLACE INTO spr_action VALUES ('7160', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7160', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7160', '24', '16', '24');
REPLACE INTO spr_action VALUES ('7160', '25', '15', '24');
REPLACE INTO spr_action VALUES ('7160', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7160', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7160', '41', '15', '24');
REPLACE INTO spr_action VALUES ('7160', '50', '16', '24');
REPLACE INTO spr_action VALUES ('7160', '51', '16', '24');
REPLACE INTO spr_action VALUES ('7160', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7160', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7160', '55', '16', '24');
REPLACE INTO spr_action VALUES ('7160', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7160', '63', '18', '24');
REPLACE INTO spr_action VALUES ('7160', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7160', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7160', '66', '60', '24');
REPLACE INTO spr_action VALUES ('7160', '67', '56', '24');
REPLACE INTO spr_action VALUES ('7160', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7160', '69', '44', '24');
REPLACE INTO spr_action VALUES ('7160', '70', '60', '24');
REPLACE INTO spr_action VALUES ('7160', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7163', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7163', '1', '20', '24');
REPLACE INTO spr_action VALUES ('7163', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7163', '3', '48', '24');
REPLACE INTO spr_action VALUES ('7163', '8', '64', '24');
REPLACE INTO spr_action VALUES ('7163', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7163', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7163', '18', '16', '24');
REPLACE INTO spr_action VALUES ('7163', '19', '18', '24');
REPLACE INTO spr_action VALUES ('7163', '4', '16', '24');
REPLACE INTO spr_action VALUES ('7163', '5', '15', '24');
REPLACE INTO spr_action VALUES ('7163', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7163', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7163', '11', '16', '24');
REPLACE INTO spr_action VALUES ('7163', '12', '16', '24');
REPLACE INTO spr_action VALUES ('7163', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7163', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7163', '24', '16', '24');
REPLACE INTO spr_action VALUES ('7163', '25', '15', '24');
REPLACE INTO spr_action VALUES ('7163', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7163', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7163', '41', '15', '24');
REPLACE INTO spr_action VALUES ('7163', '50', '16', '24');
REPLACE INTO spr_action VALUES ('7163', '51', '16', '24');
REPLACE INTO spr_action VALUES ('7163', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7163', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7163', '55', '16', '24');
REPLACE INTO spr_action VALUES ('7163', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7163', '63', '18', '24');
REPLACE INTO spr_action VALUES ('7163', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7163', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7163', '66', '80', '24');
REPLACE INTO spr_action VALUES ('7163', '67', '64', '24');
REPLACE INTO spr_action VALUES ('7163', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7163', '69', '48', '24');
REPLACE INTO spr_action VALUES ('7163', '70', '80', '24');
REPLACE INTO spr_action VALUES ('7163', '71', '48', '24');
REPLACE INTO spr_action VALUES ('7164', '0', '16', '24');
REPLACE INTO spr_action VALUES ('7164', '1', '23', '24');
REPLACE INTO spr_action VALUES ('7164', '2', '14', '24');
REPLACE INTO spr_action VALUES ('7164', '3', '52', '24');
REPLACE INTO spr_action VALUES ('7164', '8', '56', '24');
REPLACE INTO spr_action VALUES ('7164', '15', '14', '24');
REPLACE INTO spr_action VALUES ('7164', '17', '26', '24');
REPLACE INTO spr_action VALUES ('7164', '18', '16', '24');
REPLACE INTO spr_action VALUES ('7164', '19', '18', '24');
REPLACE INTO spr_action VALUES ('7164', '4', '16', '24');
REPLACE INTO spr_action VALUES ('7164', '5', '15', '24');
REPLACE INTO spr_action VALUES ('7164', '6', '14', '24');
REPLACE INTO spr_action VALUES ('7164', '7', '48', '24');
REPLACE INTO spr_action VALUES ('7164', '11', '16', '24');
REPLACE INTO spr_action VALUES ('7164', '12', '16', '24');
REPLACE INTO spr_action VALUES ('7164', '13', '14', '24');
REPLACE INTO spr_action VALUES ('7164', '14', '48', '24');
REPLACE INTO spr_action VALUES ('7164', '24', '16', '24');
REPLACE INTO spr_action VALUES ('7164', '25', '15', '24');
REPLACE INTO spr_action VALUES ('7164', '26', '14', '24');
REPLACE INTO spr_action VALUES ('7164', '27', '48', '24');
REPLACE INTO spr_action VALUES ('7164', '41', '15', '24');
REPLACE INTO spr_action VALUES ('7164', '50', '16', '24');
REPLACE INTO spr_action VALUES ('7164', '51', '16', '24');
REPLACE INTO spr_action VALUES ('7164', '52', '14', '24');
REPLACE INTO spr_action VALUES ('7164', '53', '48', '24');
REPLACE INTO spr_action VALUES ('7164', '55', '16', '24');
REPLACE INTO spr_action VALUES ('7164', '62', '16', '24');
REPLACE INTO spr_action VALUES ('7164', '63', '18', '24');
REPLACE INTO spr_action VALUES ('7164', '64', '14', '24');
REPLACE INTO spr_action VALUES ('7164', '65', '48', '24');
REPLACE INTO spr_action VALUES ('7164', '66', '60', '24');
REPLACE INTO spr_action VALUES ('7164', '67', '56', '24');
REPLACE INTO spr_action VALUES ('7164', '68', '52', '24');
REPLACE INTO spr_action VALUES ('7164', '69', '44', '24');
REPLACE INTO spr_action VALUES ('7164', '70', '60', '24');
REPLACE INTO spr_action VALUES ('7164', '71', '48', '24');

-- Scalable access levels

-- Modify the access levels to the new system.
CREATE TABLE `access_levels` (
       id SMALLINT PRIMARY KEY NOT NULL,
       name VARCHAR(50) NOT NULL,
       chat_prefix VARCHAR(3),
       access_level SMALLINT NOT NULL default 0
);
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

-- Update these to short because that is what we use everywhere in code.
ALTER TABLE `accounts` MODIFY access_level SMALLINT DEFAULT 0;
ALTER TABLE `characters` MODIFY accesslevel SMALLINT DEFAULT 0;
ALTER TABLE `characters` ADD CONSTRAINT fk_accesslevel FOREIGN KEY (accesslevel) REFERENCES access_levels(id);
ALTER TABLE `accounts` ADD CONSTRAINT fk_access_level FOREIGN KEY (access_level) REFERENCES access_levels(id);

-- Since the system is scalable, lets let everyone use help as long as they are
-- not a regular player.
UPDATE `commands` set access_level = '1' WHERE name = 'help';
