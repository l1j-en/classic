-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 71

ALTER TABLE skills ADD impl varchar(255) DEFAULT NULL;

update skills set impl = "L1Light" where skill_id = 2;

update skills set impl = "L1MarkerSkill" where skill_id = 14 or skill_id = 32 or skill_id = 64 or skill_id = 71 or skill_id = 104 or skill_id = 111 or skill_id = 134 or skill_id = 153 or skill_id = 171 or skill_id > 172 and skill_id < 177 or skill_id = 181 or skill_id = 191 or skill_id = 206 or skill_id = 211;

update skills set impl = "L1Weakness" where skill_id = 47;

update skills set impl = "L1Berserkers" where skill_id = 55;

update skills set impl = "L1Disease" where skill_id = 56;

update skills set impl = "L1AbsoluteBarrier" where skill_id = 78;

update skills set impl = "L1ElementalFallDown" where skill_id = 133;

update skills set impl = "L1NaturesTouch" where skill_id = 158;

update skills set impl = "L1WindShackle" where skill_id = 167;

update skills set impl = "L1GuardBrake" where skill_id = 183;

update skills set impl = "L1HorrorOfDeath" where skill_id = 193;

update skills set impl = "L1IllusionOgre" where skill_id = 204;

update skills set impl = "L1Insight" where skill_id = 216;

update skills set impl = "L1Panic" where skill_id = 217;

update skills set impl = "L1DishBuff" where skill_id > 2999 and skill_id < 3048;


