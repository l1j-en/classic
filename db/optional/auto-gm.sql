-- Optional trigger to enable auto GM mode for all newly created characters
-- This is mainly to support test/dev servers where you need access and dont want to have to 
-- update the database each time you create a new character / rebuild the server
create trigger auto_gm before insert on characters for each row set NEW.accesslevel = 1;
