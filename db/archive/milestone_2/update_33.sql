-- update 33

-- getback restarts on ships.
insert into getback_restart values 
(158, 5, 'Talking Island Ship to Aden Mainland', 32631, 32983, 0), 
(159, 6, 'Aden Mainland Ship to Talking Island', 32543, 32728, 4), 
(160, 83, 'Aden Mainland Ship to Forgotten Island', 33426, 33499, 4), 
(161, 84, 'Forgotten Island Ship to Aden Mainland', 32936, 33057, 70), 
(162, 446, 'Ship Pirate island to Hidden dock', 32297, 33087, 440), 
(163, 447, 'Ship Hidden dock to Pirate island', 32750, 32874, 445);

-- mobgroup black knight party
insert into mobgroup values 
(50, 'Black Knight Party(8)', 45165, 45165, 7, 0, 0, 0, 0, 0, 0, 0, 0);

-- Black Knight Party Spawn fix
UPDATE spawnlist SET group_id='50' WHERE npc_templateid ='45165' and id ='8330'; 
UPDATE spawnlist SET group_id='50' WHERE npc_templateid ='45165' and id ='8331'; 
UPDATE spawnlist SET group_id='50' WHERE npc_templateid ='45165' and id ='8332'; 
UPDATE spawnlist SET group_id='50' WHERE npc_templateid ='45165' and id ='8333'; 
UPDATE spawnlist SET group_id='50' WHERE npc_templateid ='45165' and id ='8334'; 
UPDATE spawnlist SET group_id='50' WHERE npc_templateid ='45165' and id ='8342';

-- add a missing note column to npc (though having a note here is kinda dumb)
alter table npc add column note varchar(45) NOT NULL default '' after nameid;

-- L1 FieldObject light added
INSERT INTO `npc` VALUES ('81177', '', '', '', 'L1FieldObject', '85', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '14', '0', '0', '0');
INSERT INTO `npc` VALUES ('81178', '', '', '', 'L1FieldObject', '1648', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '14', '0', '0', '0');
INSERT INTO `npc` VALUES ('81179', '', '', '', 'L1FieldObject', '1522', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '14', '0', '0', '0');
INSERT INTO `npc` VALUES ('81180', '', '', '', 'L1FieldObject', '764', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '14', '0', '0', '0');
INSERT INTO `npc` VALUES ('81181', '', '', '', 'L1FieldObject', '2394', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '10', '0', '0', '0');

INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32703', '32801', '0', '0', '0', '0', '3', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32711', '32791', '0', '0', '0', '0', '3', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32711', '32795', '0', '0', '0', '0', '3', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32668', '32804', '0', '0', '0', '0', '3', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32668', '32810', '0', '0', '0', '0', '3', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32695', '32791', '0', '0', '0', '0', '3', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32695', '32795', '0', '0', '0', '0', '3', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32691', '32801', '0', '0', '0', '0', '3', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32666', '32803', '0', '0', '0', '0', '1', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32670', '32803', '0', '0', '0', '0', '1', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32736', '32784', '0', '0', '0', '0', '1', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32662', '32790', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32667', '32790', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32667', '32803', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32662', '32803', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32663', '32846', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32668', '32846', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32673', '32846', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32782', '32844', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32782', '32848', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32769', '32844', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32769', '32848', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32746', '32845', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32746', '32850', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32717', '32843', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32717', '32850', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32710', '32858', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32703', '32858', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32696', '32850', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32696', '32843', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32703', '32836', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32711', '32836', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32795', '32824', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32795', '32828', '0', '0', '0', '0', '2', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32743', '32792', '0', '0', '0', '0', '82', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32732', '32818', '0', '0', '0', '0', '82', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32693', '32814', '0', '0', '0', '0', '82', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32677', '32796', '0', '0', '0', '0', '82', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32672', '32830', '0', '0', '0', '0', '82', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32670', '32869', '0', '0', '0', '0', '82', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32692', '32845', '0', '0', '0', '0', '82', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32725', '32844', '0', '0', '0', '0', '82', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32886', '32770', '0', '0', '0', '0', '78', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32902', '32770', '0', '0', '0', '0', '78', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32876', '32791', '0', '0', '0', '0', '78', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32903', '32743', '0', '0', '0', '0', '78', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32904', '32791', '0', '0', '0', '0', '78', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32743', '32807', '0', '0', '0', '0', '79', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32755', '32807', '0', '0', '0', '0', '79', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32762', '32833', '0', '0', '0', '0', '79', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32741', '32848', '0', '0', '0', '0', '79', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32774', '32826', '0', '0', '0', '0', '79', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32783', '32826', '0', '0', '0', '0', '79', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32795', '32820', '0', '0', '0', '0', '79', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32788', '32800', '0', '0', '0', '0', '79', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32796', '32835', '0', '0', '0', '0', '79', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32789', '32866', '0', '0', '0', '0', '79', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32753', '32804', '0', '0', '0', '0', '80', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32741', '32804', '0', '0', '0', '0', '80', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32736', '32814', '0', '0', '0', '0', '80', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32728', '32814', '0', '0', '0', '0', '80', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32750', '32828', '0', '0', '0', '0', '80', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32761', '32819', '0', '0', '0', '0', '80', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32771', '32819', '0', '0', '0', '0', '80', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32750', '32836', '0', '0', '0', '0', '80', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32733', '32833', '0', '0', '0', '0', '80', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32767', '32843', '0', '0', '0', '0', '80', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32779', '32843', '0', '0', '0', '0', '80', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32801', '32820', '0', '0', '0', '0', '80', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32784', '32812', '0', '0', '0', '0', '80', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32773', '32840', '0', '0', '0', '0', '81', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32773', '32851', '0', '0', '0', '0', '81', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32765', '32858', '0', '0', '0', '0', '81', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32778', '32812', '0', '0', '0', '0', '81', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32756', '32811', '0', '0', '0', '0', '81', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32751', '32811', '0', '0', '0', '0', '81', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32760', '32834', '0', '0', '0', '0', '81', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32732', '32834', '0', '0', '0', '0', '81', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32738', '32804', '0', '0', '0', '0', '81', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32750', '32792', '0', '0', '0', '0', '81', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32762', '32792', '0', '0', '0', '0', '81', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32745', '32839', '0', '0', '0', '0', '81', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81179', '32739', '32847', '0', '0', '0', '0', '81', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32810', '32733', '0', '0', '0', '0', '53', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32810', '32728', '0', '0', '0', '0', '53', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32810', '32797', '0', '0', '0', '0', '54', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32810', '32791', '0', '0', '0', '0', '54', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32732', '32728', '0', '0', '0', '0', '55', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32738', '32728', '0', '0', '0', '0', '55', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32771', '32731', '0', '0', '0', '0', '56', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32766', '32731', '0', '0', '0', '0', '56', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32793', '32748', '0', '0', '0', '0', '9', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32796', '32751', '0', '0', '0', '0', '9', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32804', '32731', '0', '0', '0', '0', '8', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32807', '32734', '0', '0', '0', '0', '8', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32773', '32761', '0', '0', '0', '0', '8', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32767', '32761', '0', '0', '0', '0', '8', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32773', '32768', '0', '0', '0', '0', '8', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32766', '32768', '0', '0', '0', '0', '8', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32748', '32798', '0', '0', '0', '0', '8', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32751', '32798', '0', '0', '0', '0', '8', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32750', '32735', '0', '0', '0', '0', '8', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32747', '32735', '0', '0', '0', '0', '8', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32772', '32731', '0', '0', '0', '0', '8', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32777', '32731', '0', '0', '0', '0', '8', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32734', '32729', '0', '0', '0', '0', '8', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32733', '32783', '0', '0', '0', '0', '7', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32729', '32783', '0', '0', '0', '0', '7', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32739', '32759', '0', '0', '0', '0', '7', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32735', '32759', '0', '0', '0', '0', '7', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32790', '32763', '0', '0', '0', '0', '7', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32797', '32763', '0', '0', '0', '0', '7', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32790', '32773', '0', '0', '0', '0', '7', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32797', '32773', '0', '0', '0', '0', '7', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32732', '32732', '0', '0', '0', '0', '7', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32810', '32725', '0', '0', '0', '0', '7', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32813', '32725', '0', '0', '0', '0', '7', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32720', '32799', '0', '0', '0', '0', '9', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32719', '32776', '0', '0', '0', '0', '9', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32788', '32788', '0', '0', '0', '0', '9', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32785', '32785', '0', '0', '0', '0', '9', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32799', '32785', '0', '0', '0', '0', '9', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32802', '32788', '0', '0', '0', '0', '9', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32780', '32766', '0', '0', '0', '0', '9', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32783', '32769', '0', '0', '0', '0', '9', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32762', '32792', '0', '0', '0', '0', '9', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32760', '32791', '0', '0', '0', '0', '9', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32719', '32787', '0', '0', '0', '0', '9', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32761', '32774', '0', '0', '0', '0', '10', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32765', '32774', '0', '0', '0', '0', '10', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32769', '32753', '0', '0', '0', '0', '10', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32765', '32753', '0', '0', '0', '0', '10', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32743', '32749', '0', '0', '0', '0', '10', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32749', '32739', '0', '0', '0', '0', '10', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32740', '32730', '0', '0', '0', '0', '10', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32730', '32736', '0', '0', '0', '0', '10', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32730', '32724', '0', '0', '0', '0', '11', '0'); 
INSERT INTO `spawnlist_npc` VALUES (default, 'FieldLightObject', '1', '81177', '32726', '32724', '0', '0', '0', '0', '11', '0');

-- correct kennel dog spawn on PI
update spawnlist set count = 1 where npc_templateid in (45042, 45034, 45043) and mapid = 440;