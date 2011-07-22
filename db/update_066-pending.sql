-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- update 66

-- merge the differences between us and jp on these mobs
-- this may give us a slightly more sane starting point for further adjusting
-- some of our values were obviously wrong just by glancing at them


-- reverse the id's on solidcarriage and counterbarrier
-- this should fix issue #25, and also matches l1j-jp

-- Skill:SolidCarriage-90 id changed from 4 
UPDATE skills SET id = `2` WHERE skill_id = 90

-- Skill:CounterBarrier-91 probability_value changed from 50 
UPDATE skills SET probability_value = `25` WHERE skill_id = 91

-- Skill:CounterBarrier-91 id changed from 2 
UPDATE skills SET id = `4` WHERE skill_id = 91





-- Unchosen One 46069

-- atk_magic_speed changed from 880
UPDATE npc SET atk_magic_speed = 840 WHERE npcid = 46069;



--

-- Unchosen One 46073

-- atk_magic_speed changed from 1120
UPDATE npc SET atk_magic_speed = 1000 WHERE npcid = 46073;



--

-- Unchosen One 46080

-- atkspeed changed from 1120
UPDATE npc SET atkspeed = 1040 WHERE npcid = 46080;



--

-- Unchosen One 46081

-- atkspeed changed from 1120
UPDATE npc SET atkspeed = 1040 WHERE npcid = 46081;



--

-- Patrol 1 46082

-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46082;

-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46082;



--

-- Patrol 2 46083

-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46083;

-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46083;



--

-- Patrol 3 46084

-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46084;

-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46084;



--

-- Patrol 4 46085

-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46085;

-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46085;



--

-- Patrol 5 46086

-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46086;

-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46086;



--

-- Patrol 6 46087

-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46087;

-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46087;



--

-- Patrol 7 46088

-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46088;

-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46088;



--

-- Patrol 8 46089

-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46089;

-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46089;



--

-- Patrol 9 46090

-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46090;

-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46090;



--

-- Guard 46091

-- atk_magic_speed changed from 720
UPDATE npc SET atk_magic_speed = 1040 WHERE npcid = 46091;

-- sub_magic_speed changed from 720
UPDATE npc SET sub_magic_speed = 1200 WHERE npcid = 46091;



--

-- Unchosen One 46092

-- atk_magic_speed changed from 1172
UPDATE npc SET atk_magic_speed = 1160 WHERE npcid = 46092;

-- passispeed changed from 1500
UPDATE npc SET passispeed = 1440 WHERE npcid = 46092;

-- atkspeed changed from 1172
UPDATE npc SET atkspeed = 1120 WHERE npcid = 46092;



--

-- Unchosen One 46093

-- atk_magic_speed changed from 1000
UPDATE npc SET atk_magic_speed = 1360 WHERE npcid = 46093;

-- passispeed changed from 1336
UPDATE npc SET passispeed = 1280 WHERE npcid = 46093;

-- atkspeed changed from 1000
UPDATE npc SET atkspeed = 960 WHERE npcid = 46093;

-- sub_magic_speed changed from 1000
UPDATE npc SET sub_magic_speed = 1760 WHERE npcid = 46093;



--

-- Unchosen One 46094

-- atk_magic_speed changed from 1344
UPDATE npc SET atk_magic_speed = 1680 WHERE npcid = 46094;

-- passispeed changed from 1500
UPDATE npc SET passispeed = 1440 WHERE npcid = 46094;

-- atkspeed changed from 1344
UPDATE npc SET atkspeed = 1280 WHERE npcid = 46094;



--

-- Unchosen One 46095

-- atk_magic_speed changed from 1125
UPDATE npc SET atk_magic_speed = 1880 WHERE npcid = 46095;

-- passispeed changed from 1500
UPDATE npc SET passispeed = 1440 WHERE npcid = 46095;

-- atkspeed changed from 1125
UPDATE npc SET atkspeed = 1080 WHERE npcid = 46095;



--

-- Unchosen One 46096

-- atk_magic_speed changed from 1172
UPDATE npc SET atk_magic_speed = 1200 WHERE npcid = 46096;

-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46096;

-- atkspeed changed from 1172
UPDATE npc SET atkspeed = 1120 WHERE npcid = 46096;

-- Skill: TriRnd changed from 10 
UPDATE mobskill SET TriRnd = 20 WHERE mobid = 46096 and actNo = 0;

-- Skill: TriRnd changed from 10 
UPDATE mobskill SET TriRnd = 100 WHERE mobid = 46096 and actNo = 1;



--

-- Patrol 1 46097

-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46097;

-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46097;



--

-- Patrol 2 46098

-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46098;

-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46098;



--

-- Patrol 3 46099

-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46099;

-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46099;



--

-- Patrol 4 46100

-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46100;

-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46100;



--

-- Patrol 5 46101

-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46101;

-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46101;



--

-- Patrol 6 46102

-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46102;

-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46102;



--

-- Patrol 7 46103

-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46103;

-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46103;



--

-- Patrol 8 46104

-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46104;

-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46104;



--

-- Patrol 9 46105

-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46105;

-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46105;



--

-- Guard 46106

-- passispeed changed from 1000
UPDATE npc SET passispeed = 960 WHERE npcid = 46106;

-- atkspeed changed from 750
UPDATE npc SET atkspeed = 720 WHERE npcid = 46106;


