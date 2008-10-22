-- update 32

UPDATE armor SET regist_stone='20',regist_freeze='0' WHERE item_id ='20229';
UPDATE armor SET regist_stan='0',regist_stone='1' WHERE item_id ='20443';
UPDATE armor SET regist_stan='0',regist_freeze='1' WHERE item_id ='20444';
UPDATE armor SET regist_stan='0',regist_sleep='1' WHERE item_id ='20446';
UPDATE armor SET regist_stan='0',regist_stone='1' WHERE item_id ='20447';
UPDATE armor SET regist_stan='0',regist_freeze='1' WHERE item_id ='20448';
UPDATE armor SET regist_stan='0',regist_sleep='1' WHERE item_id ='20450';
UPDATE armor SET regist_sustain='7' WHERE item_id ='21060';
UPDATE armor SET material='leather',invgfx='2259',ac='-1' WHERE item_id ='20380'; 
UPDATE armor SET regist_freeze='8' WHERE item_id ='120016';

-- resist fix
UPDATE armor SET regist_freeze='0',regist_sustain='5' WHERE item_id ='20412'; 
UPDATE armor SET regist_stone='20' WHERE item_id ='20365';