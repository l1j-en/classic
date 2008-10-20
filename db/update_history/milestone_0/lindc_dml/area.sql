-- update 21

-- Change GMRoom (Jail) so that you cant restart to get out from it
update area set x1 = 32767, y1 = 32796, x2 = 32767, y2 = 32796, flag = 2, restart = 99 where mapid = 99;



-- update 22

-- Update for Silent Cavern starting area escape
UPDATE area SET x1 = 32872, y1 = 32914, x2 = 32872, y2 = 32906, restart = 304 WHERE mapid = 304;