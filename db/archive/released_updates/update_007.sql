-- update 7

-- make normal succubus always drop adena
update droplist set chance = 1000000 where itemid = 40308 and mobid in (45394, 45393, 45451);

-- add i-visor, ipm, and ndai to horrific iron golem 
insert into droplist values (45479, 20003, 1, 1, 5000);
insert into droplist values (45479, 20091, 1, 1, 3000);
insert into droplist values (45479, 40087, 1, 1, 10000);

-- add bzel to fire ghost droplist
insert into droplist values (45519, 140074, 1, 1, 5000);

-- correct spelling of paralyze, immune, and tripleshot in skills
update skills set name = 'Paralyze' where skill_id = 33;
update skills set name = 'ImmuneToHarm' where skill_id = 68;
update skills set name = 'TripleShot' where skill_id = 132;

-- increase effectiveness of nature's blessing (dmg dice 12 -> 18)
update skills set damage_dice = 18 where skill_id = 164; 
