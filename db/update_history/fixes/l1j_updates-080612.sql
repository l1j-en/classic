-- remove cat chill touch
delete from `mobskill` where mobid = 45039;

-- replace cat chill touch with correct trirnd/trirange/leverage
insert into `mobskill` values (45039, 0, 'Cat', 2, 50, 0, 0, -3, 0, 0, 0, 0, 0, 0, 10, 252, 0, 0, 0, 0, 0);


-- saint bernard/high saint bernard wind shuriken
insert into `mobskill` values (45047, 0, 'Saint Bernard', 2, 50, 0, 0, -6, 0, 0, 0, 0, 0, 0, 7, 1799, 0, 0, 0, 0, 0);
-- saint bernard's wind shuriken
--insert into `mobskill` values (45693, 0, 'High Saint Bernard', 2, 50, 0, 0, -6, 0, 0, 0, 0, 0, 0, 7, 1799, 0, 0, 0, 0, 0);

-- remove high beagle fire arrow
delete from `mobskill` where mobid = 45692;

-- beagle/high beagle stalac
insert into `mobskill` values (45046, 0, 'Beagle', 2, 50, 0, 0, -6, 0, 0, 0, 0, 0, 5, 15, 1583, 0, 0, 0, 0, 0);
insert into `mobskill` values (45692, 0, 'High Beagle', 2, 50, 0, 0, -6, 0, 0, 0, 0, 0, 5, 15, 1583, 0, 0, 0, 0, 0);

-- remove high fox stalac
delete from `mobskill` where mobid = 45694;

-- fox/high fox fire arrow
insert into `mobskill` values (45048, 0, 'Fox', 2, 50, 0, 0, -6, 0, 0, 0, 0, 0, 0, 16, 1801, 0, 0, 0, 0, 0);
insert into `mobskill` values (45694, 0, 'High Fox', 2, 50, 0, 0, -6, 0, 0, 0, 0, 0, 0, 16, 1801, 0, 0, 0, 0, 0);

-- raccoon/high raccoon  
insert into `mobskill` values (45044, 0, 'Raccoon', 2, 10, 0, 0, -1, 0, 0, 0, 0, 0, 5, 29, 752, 0, 0, 0, 0, 0);
insert into `mobskill` values (45697, 0, 'High Raccoon', 2, 10, 0, 0, -1, 0, 0, 0, 0, 0, 5, 29, 752, 0, 0, 0, 0, 0);

-- fix kurtz sword drop (currently drops kent dungeon sword)
update droplist set itemid = 54 where mobid = 45600 and itemid = 15;
