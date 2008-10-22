-- update 32

-- move action_id column in skills table to after castgfx
-- remove old action_id column
alter table skills drop column action_id;
-- more skills table changes/additions
alter table skills add column action_id int(10) unsigned NOT NULL default 0 after castgfx;
-- reinsert action_id data
update skills set action_id = 19;
update skills set action_id = 18 where skill_id in (4, 6, 7, 10, 11, 15, 16, 17, 22, 25, 28, 30, 34, 38, 45, 
46, 50, 53, 58, 59, 62, 65, 70, 74, 77, 80, 108, 132, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 
10008, 10009, 10010, 10011, 10012, 10013, 10014, 10015, 10016, 10017, 10018, 10019, 10020, 10021, 10022, 10023, 
10024, 10025, 10026, 10027, 10028, 10029, 10030, 10031, 10032, 10033, 10034, 10035, 10036, 10037, 10038, 10039, 
10040, 10041, 10042, 10043, 10044, 10045, 10046, 10047, 10048, 10049, 10050, 10051, 10052, 10053, 10054, 10055, 
10056, 10058, 10059, 10060, 10061, 10062, 10063, 10064, 10065, 10066, 10067, 10068, 10069, 10070, 10072, 10073, 
10074, 10075, 10076, 10077, 10078, 10079, 10080, 10081, 10082, 10083, 10084, 10085, 10086, 10087, 10088, 10089);
