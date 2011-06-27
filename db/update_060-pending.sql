-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 60

-- Change AS back to 1200 sec.
update skills set buffDuration = 1200 where skill_id = 79;
-- De-aggro Minotaur (axe).
update npc set agro = 0, agrososc = 0, agrocoi = 0 where npcid = 45390;


-- walking npcaction fixes
INSERT INTO npcaction VALUES ('70901', 'jeti1', '', '', '');
INSERT INTO npcaction VALUES ('70604', 'bridget1', '', '', '');
INSERT INTO npcaction VALUES ('70615', 'alda1', '', '', '');
INSERT INTO npcaction VALUES ('70619', 'alice1', '', '', '');
INSERT INTO npcaction VALUES ('70621', 'evelyn1', '', '', '');
INSERT INTO npcaction VALUES ('70624', 'oliver1', '', '', '');
INSERT INTO npcaction VALUES ('70626', 'jack1', '', '', '');
INSERT INTO npcaction VALUES ('70634', 'tanya1', '', '', '');
INSERT INTO npcaction VALUES ('70582', 'neil1', '', '', '');
INSERT INTO npcaction VALUES ('70583', 'nelson1', '', '', '');
INSERT INTO npcaction VALUES ('70606', 'victor1', '', '', '');
INSERT INTO npcaction VALUES ('70608', 'shalina1', '', '', '');
INSERT INTO npcaction VALUES ('70825', 'ellne1', '', '', '');
INSERT INTO npcaction VALUES ('70839', 'doettCE1', '', '', '');
INSERT INTO npcaction VALUES ('70854', 'hurindalien1', '', '', '');
INSERT INTO npcaction VALUES ('70803', 'anotte1', '', '', '');
INSERT INTO npcaction VALUES ('70858', 'derick1', '', '', '');
INSERT INTO npcaction VALUES ('70581', 'gulian1', '', '', '');
INSERT INTO npcaction VALUES ('70586', 'daisy1', '', '', '');
INSERT INTO npcaction VALUES ('70592', 'leal1', '', '', '');
INSERT INTO npcaction VALUES ('70593', 'manus1', '', '', '');
INSERT INTO npcaction VALUES ('70589', 'laban1', '', '', '');
INSERT INTO npcaction VALUES ('70591', 'lina1', '', '', '');
INSERT INTO npcaction VALUES ('70637', 'tovia1', '', '', '');
INSERT INTO npcaction VALUES ('70630', 'giles1', '', '', '');
INSERT INTO npcaction VALUES ('70639', 'ferdinand1', '', '', '');
INSERT INTO npcaction VALUES ('70576', 'garth1', '', '', '');
INSERT INTO npcaction VALUES ('70640', 'pierre1', '', '', '');
INSERT INTO npcaction VALUES ('70834', 'torban1', '', '', '');
INSERT INTO npcaction VALUES ('70833', 'tommy1', '', '', '');
INSERT INTO npcaction VALUES ('70828', 'ofo1', '', '', '');
INSERT INTO npcaction VALUES ('70821', 'sanita1', '', '', '');
INSERT INTO npcaction VALUES ('70814', 'ruka1', '', '', '');
INSERT INTO npcaction VALUES ('70812', 'rohan1', '', '', '');
INSERT INTO npcaction VALUES ('70819', 'bob1', '', '', '');
INSERT INTO npcaction VALUES ('70767', 'haro1', '', '', '');
INSERT INTO npcaction VALUES ('70735', 'garuga1', '', '', '');
INSERT INTO npcaction VALUES ('70736', 'derian1', '', '', '');
INSERT INTO npcaction VALUES ('70741', 'dima1', '', '', '');
INSERT INTO npcaction VALUES ('70752', 'biyan1', '', '', '');
INSERT INTO npcaction VALUES ('70746', 'rotus1', '', '', '');
INSERT INTO npcaction VALUES ('70659', 'atara1', '', '', '');
INSERT INTO npcaction VALUES ('70648', 'daley1', '', '', '');
INSERT INTO npcaction VALUES ('70647', 'gavin1', '', '', '');
INSERT INTO npcaction VALUES ('70867', 'shannon1', '', '', '');
INSERT INTO npcaction VALUES ('70871', 'annabel1', '', '', '');
INSERT INTO npcaction VALUES ('70877', 'trion1', '', '', '');
INSERT INTO npcaction VALUES ('70878', 'felix1', '', '', '');