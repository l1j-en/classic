-- Update illusionist buffs for larger range
update skills set range = -1 where skill_id = 204;
update skills set range = -1 where skill_id = 206;
update skills set range = -1 where skill_id = 209;
update skills set range = -1 where skill_id = 214;
update skills set range = -1 where skill_id = 211;
update skills set range = -1 where skill_id = 216;
update skills set range = -1 where skill_id = 219;

-- Increase duration of concentration, patience, and insight
-- to match str/dex
update skills set duration = 1200 where skill_id = 206;
update skills set duration = 1200 where skill_id = 211;
update skills set duration = 1200 where skill_id = 216;
