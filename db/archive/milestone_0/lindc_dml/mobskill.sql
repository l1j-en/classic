-- update 1

-- add elder c-l cast
insert into `mobskill` values (45215, 0, 'Elder', 2, 35, 0, 0, -4, 0, 0, 0, 0, 0, 25, 34, 10, 0, 0, 0, 0, 0);



-- update 2

-- nerf elder c-l dmg
update mobskill set leverage = 5 where mobid = 45215 and actno = 0;

-- nerf Dark Elf c-l dmg
update mobskill set leverage = 15 where mobid = 45265 and actno = 0;
update mobskill set leverage = 30 where mobid = 45364 and actno = 0;

-- nerf Dark Elf Wizard coc and tornado dmg
update mobskill set leverage = 15 where mobid = 45447 and actno = 0;
update mobskill set leverage = 30 where mobid = 45447 and actno = 1;



-- update 4

-- reduce ancient giant's aoe range by 4 and reduce frequency ancient giant casts aoe
update mobskill set trirange = -7, trirnd = 20 where mobid = 45610 and actno = 0;

-- reduce magic dmg from normal/fi dark elf
update mobskill set leverage = 18 where mobid = 45265 and actno = 0;
update mobskill set leverage = 30 where mobid = 45363 and actno = 0;

-- add leverage to high cat and update mobname
update mobskill set leverage = 5, mobname = 'High Cat' where mobid = 45696 and actno = 0;



-- update 8

-- reduce cerenis full heal leverage (100 -> 50)
update mobskill set leverage = 50 where mobid = 45678 and actno = 0;

-- reduce doppel boss blizz leverage (30 -> 15)
update mobskill set leverage = 15 where mobid = 45546 and actno = 0;

-- reduce DK v-t leverage (50 -> 35)
update mobskill set leverage = 35 where mobid = 45601 and actno = 0;

-- reduce DK aoe leverage (30 -> 15) and trirnd (60 -> 45)
update mobskill set leverage = 15, trirnd = 45 where mobid = 45601 and actno = 1;

-- reduce cerenis blizz leverage (120 -> 40)
update mobskill set leverage = 40 where mobid = 45678 and actno = 1;



-- update 12

-- fix de wizard mobskill with a 75% leverage reduction
update mobskill set leverage = 4 where mobid = 45447 and actno = 0;
update mobskill set leverage = 9 where mobid = 45447 and actno = 1;



-- update 13

-- reduce normal ranged attack mobskill usage on fangs
-- fang of earth firearrow(?)
update mobskill set trirnd = 45 where mobid = 45416 and actno = 2;
-- Fang of Wind windshuriken
update mobskill set trirnd = 45 where mobid = 45418 and actno = 2;
-- Fang of Glacier ConeOfCold
update mobskill set trirnd = 45 where mobid = 45419 and actno = 1;
-- Fang of Flame  Stalac (?)
update mobskill set trirnd = 45 where mobid = 45424 and actno = 1;

-- reduce dv drake mobskill leverage (30 -> 25)
update mobskill set leverage = 25 where mobid = 45529 and actno = 0;

-- reduce fi de mobskill leverage (30 -> 15)
update mobskill set leverage = 15 where mobid = 45364 and actno = 0;

-- reduce mobskill leverage for normal de (18 -> 10)
update mobskill set leverage = 10 where mobid = 45265 and actno = 0;



-- update 14

-- reduce mobskill leverage on black wizard (30 -> 5)
update mobskill set leverage = 5 where mobid in (45405, 45425) and actno = 0;

-- reduce a-g's aoe skill range (-7 -> -6)
update mobskill set trirange = -6 where mobid = 45610 and actno = 1;



-- update 15 

-- reduce beast summoner mobskill leverage (30 -> 12)
update mobskill set leverage = 12 where mobid = 45368 and actno = 0;

-- slightly increase black wizard mobskill leverage (5 -> 7)
update mobskill set leverage = 7 where mobid = 45405 and actno = 0;



-- update 17

-- decrease bone dragon skill leverage (15 -> 3)
update mobskill set leverage = 3 where mobid = 45522 and actno = 0;

-- decrease damage from phoenix ranged attack, but increase range
update mobskill set leverage = 10, trirange = -8  where mobid = 45617 and actno = 0;



-- update 19

-- increase mobskill leverage of phoenix ranged attack (10 -> 12)
update mobskill set leverage = 12 where mobid = 45617 and actno = 0;

-- increase a-g's aoe range to prevent cliffing
update mobskill set trirange = -10 where mobid = 45610 and actno = 0;



-- update 23

-- swap beagle and fox skills
-- stalac for beagle, high beagle
update mobskill set skillid = 16 where mobid in (45046, 45692);
-- fire arrow for fox, high fox
update mobskill set skillid = 15 where mobid in (45048, 45694);



-- update 24

-- slightly reduce sema's magic damage to be more in line with the other members of caspa group
update mobskill set leverage = 35 where mobid = 45464 and actno = 0;

-- add mobskills for greater elf summons
insert into mobskill values (81050, 0, 'Summoned Spirit of Fire', 2, 100, 0, 0, -6, 0, 0, 0, 0, 0, 3, 15, 1801, 0, 0, 0, 0, 0); 
insert into mobskill values (81051, 0, 'Summoned Spirit of Water', 2, 100, 0, 0, -6, 0, 0, 0, 0, 0, 3, 6, 1797, 0, 0, 0, 0, 0); 
insert into mobskill values (81052, 0, 'Summoned Spirit of Wind', 2, 100, 0, 0, -6, 0, 0, 0, 0, 0, 3, 7, 1799, 0, 0, 0, 0, 0); 
insert into mobskill values (81053, 0, 'Summoned Spirit of Earth', 2, 100, 0, 0, -6, 0, 0, 0, 0, 0, 3, 16, 1583, 0, 0, 0, 0, 0); 

-- set elekkadoms to use mobskill
insert into mobskill values (45279, 0, 'Elekkadom', 2, 25, 0, 0, -1, 0, 0, 0, 0, 0, 8, 11000, 1714, 0, 0, 0, 0, 0);
insert into mobskill values (45819, 0, 'Elekkadom', 2, 25, 0, 0, -1, 0, 0, 0, 0, 0, 8, 11000, 1714, 0, 0, 0, 0, 0);
insert into mobskill values (45487, 0, 'Subterranean Elekkadom', 2, 30, 0, 0, -1, 0, 0, 0, 0, 0, 16, 11000, 1714, 0, 0, 0, 0, 0);
insert into mobskill values (45732, 0, 'Grave Elekkadom', 2, 30, 0, 0, -1, 0, 0, 0, 0, 0, 16, 11000, 1714, 0, 0, 0, 0, 0);



-- update 25

-- update mobskill mobnames
update mobskill ms set ms.mobname = (select n.name from npc n where n.npcid = ms.mobid);