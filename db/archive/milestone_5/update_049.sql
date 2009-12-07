
-- update 49

# Setup droplist for Gludio Cemetary Ghosts Quest
insert into droplist values(45912,41327,1,1,50000);
insert into droplist values(45913,41327,1,1,50000);
insert into droplist values(45914,41327,1,1,50000);
insert into droplist values(45915,41327,1,1,50000);
insert into droplist values(45916,41328,1,1,1000000);

# Generate Missing Gludin Cemetary Ghost Boss - GM: Valakas
insert into spawnlist_boss values(105,'General Hamel Full of Resentment','Caspa',1,45916,0,32626,32658,0,0,0,0,0,0,4,4,1,0,1,0,100);

# Generate Missing Daid and Lasta Bosses - GM: Valakas
insert into spawnlist_boss values(41,'Dread Queen Laia','Aden',1,45677,0,33033,32935,0,0,0,0,0,0,6,320,0,100,0,0,100);
insert into spawnlist_boss values(66,'Teranus','Aden',1,45666,0,32773,32913,0,0,0,0,0,0,6,450,0,0,0,0,100);
insert into spawnlist_boss values(67,'Zyrus','Aden',1,45668,0,32771,32897,0,0,0,0,0,0,6,450,0,0,0,0,100);

# Correct invalid Lasta Boss Name
update npc set name = 'Dread Queen Laia' where npcid = 45677;
update npc set note = 'Diad Castle Gate Boss' where npcid = 45677;
update npc set note = 'Diad Castle Gate Boss' where npcid = 45651;

# Correct incorrect npcname for Gludin Cemetary Ghost
update npc set name = 'Ghost Woman Full of Resentment' where npcid = 45915;

# Generate Missing Gludin Cemetary Ghosts - GM: Valakas
insert into spawnlist values(27810,'Ghost Soldier Full of Resentment',1,45913,0,32605,32660,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27811,'Ghost Soldier Full of Resentment',1,45913,0,32602,32669,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27812,'Ghost Soldier Full of Resentment',1,45913,0,32615,32652,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27813,'Ghost Soldier Full of Resentment',1,45913,0,32624,32668,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27814,'Ghost Soldier Full of Resentment',1,45913,0,32615,32682,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27815,'Ghost Soldier Full of Resentment',1,45913,0,32601,32677,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27816,'Ghost Soldier Full of Resentment',1,45912,0,32603,32655,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27817,'Ghost Soldier Full of Resentment',1,45912,0,32595,32669,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27818,'Ghost Soldier Full of Resentment',1,45912,0,32625,32655,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27819,'Ghost Soldier Full of Resentment',1,45912,0,32628,32677,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27820,'Ghost Soldier Full of Resentment',1,45912,0,32610,32679,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27821,'Ghost Soldier Full of Resentment',1,45912,0,32614,32667,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27822,'Ghost Man Full of Resentment',1,45914,0,32608,32651,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27823,'Ghost Man Full of Resentment',1,45914,0,32605,32648,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27824,'Ghost Man Full of Resentment',1,45914,0,32625,32661,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27825,'Ghost Man Full of Resentment',1,45914,0,32632,32682,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27826,'Ghost Man Full of Resentment',1,45914,0,32606,32683,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27827,'Ghost Woman Full of Resentment',1,45915,0,32612,32663,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27828,'Ghost Woman Full of Resentment',1,45915,0,32610,32648,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27829,'Ghost Woman Full of Resentment',1,45915,0,32632,32664,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27830,'Ghost Woman Full of Resentment',1,45915,0,32623,32683,0,0,0,0,0,0,0,60,120,4,1,0,1,0);
insert into spawnlist values(27831,'Ghost Woman Full of Resentment',1,45915,0,32600,32685,0,0,0,0,0,0,0,60,120,4,1,0,1,0);

# Generate missing Diad and Lasta Mobs - GM: Valakas
insert into spawnlist values(27798,'Dillo',1,45328,0,32745,32867,0,0,0,0,0,0,0,60,120,320,0,100,0,0);
insert into spawnlist values(27799,'Dillo',1,45328,0,32775,32852,0,0,0,0,0,0,0,60,120,320,0,100,0,0);
insert into spawnlist values(27800,'Dillo',1,45328,0,32787,32867,0,0,0,0,0,0,0,60,120,320,0,100,0,0);
insert into spawnlist values(27801,'Dillo',1,45328,0,32857,32927,0,0,0,0,0,0,0,60,120,320,0,100,0,0);
insert into spawnlist values(27802,'Dillo',1,45328,0,32859,32875,0,0,0,0,0,0,0,60,120,320,0,100,0,0);
insert into spawnlist values(27803,'Dillo',1,45328,0,32887,32860,0,0,0,0,0,0,0,60,120,320,0,100,0,0);
insert into spawnlist values(27804,'Mole',1,45311,0,32770,32877,0,0,0,0,0,0,0,60,120,320,0,100,0,0);
insert into spawnlist values(27805,'Mole',1,45311,0,32745,32852,0,0,0,0,0,0,0,60,120,320,0,100,0,0);
insert into spawnlist values(27806,'Mole',1,45311,0,32808,32867,0,0,0,0,0,0,0,60,120,320,0,100,0,0);
insert into spawnlist values(27807,'Mole',1,45311,0,32866,32904,0,0,0,0,0,0,0,60,120,320,0,100,0,0);
insert into spawnlist values(27808,'Mole',1,45311,0,32862,32858,0,0,0,0,0,0,0,60,120,320,0,100,0,0);
insert into spawnlist values(27809,'Mole',1,45311,0,32895,32878,0,0,0,0,0,0,0,60,120,320,0,100,0,0);
insert into spawnlist values(27832,'Mole',1,45214,0,32790,32922,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27833,'Mole',1,45214,0,32771,32924,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27834,'Mole',1,45214,0,32721,32913,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27835,'Mole',1,45214,0,32737,32876,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27836,'Mole',1,45214,0,32729,32824,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27837,'Mole',1,45214,0,32746,32796,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27838,'Mole',1,45214,0,32752,32842,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27839,'Mole',1,45214,0,32785,32885,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27840,'Mole',1,45214,0,32809,32858,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27841,'Mole',1,45214,0,32817,32891,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27842,'Black Tiger',1,45309,0,32797,32920,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27843,'Black Tiger',1,45309,0,32762,32926,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27844,'Black Tiger',1,45309,0,32723,32902,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27845,'Black Tiger',1,45309,0,32739,32869,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27846,'Black Tiger',1,45309,0,32726,32821,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27847,'Black Tiger',1,45309,0,32751,32799,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27848,'Black Tiger',1,45309,0,32752,32846,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27849,'Black Tiger',1,45309,0,32794,32882,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27850,'Black Tiger',1,45309,0,32803,32884,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27851,'Black Tiger',1,45309,0,32810,32852,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27852,'Black Tiger',1,45309,0,32816,32896,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27853,'Black Tiger',1,45309,0,32812,32932,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27854,'Black Tiger',1,45309,0,32839,32891,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27855,'Black Tiger',1,45309,0,32843,32887,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27856,'Black Tiger',1,45309,0,32838,32818,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27857,'Black Tiger',1,45309,0,32843,32809,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27858,'Black Tiger',1,45309,0,32866,32848,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27859,'Black Tiger',1,45309,0,32860,32903,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27860,'Beast Summoner',1,45323,0,32800,32914,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27861,'Beast Summoner',1,45323,0,32756,32929,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27862,'Beast Summoner',1,45323,0,32725,32892,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27863,'Beast Summoner',1,45323,0,32736,32861,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27864,'Beast Summoner',1,45323,0,32724,32807,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27865,'Beast Summoner',1,45323,0,32756,32803,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27866,'Beast Summoner',1,45323,0,32759,32848,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27867,'Beast Summoner',1,45323,0,32813,32881,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27868,'Beast Summoner',1,45323,0,32807,32847,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27869,'Beast Summoner',1,45323,0,32818,32904,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27870,'Beast Summoner',1,45323,0,32811,32938,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27871,'Beast Summoner',1,45323,0,32849,32882,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27872,'Beast Summoner',1,45323,0,32852,32875,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27873,'Beast Summoner',1,45323,0,32849,32804,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27874,'Beast Summoner',1,45323,0,32869,32856,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27875,'Beast Summoner',1,45323,0,32867,32862,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27876,'Beast Summoner',1,45323,0,32870,32911,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27877,'Dillo',1,45328,0,32799,32904,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27878,'Dillo',1,45328,0,32753,32923,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27879,'Dillo',1,45328,0,32721,32882,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27880,'Dillo',1,45328,0,32740,32850,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27881,'Dillo',1,45328,0,32728,32805,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27882,'Dillo',1,45328,0,32760,32810,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27883,'Dillo',1,45328,0,32759,32859,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27884,'Dillo',1,45328,0,32818,32883,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27885,'Dillo',1,45328,0,32801,32847,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27886,'Dillo',1,45328,0,32818,32912,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27887,'Dark Forester',1,45326,0,32789,32899,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27888,'Dark Forester',1,45326,0,32750,32928,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27889,'Dark Forester',1,45326,0,32759,32912,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27890,'Dark Forester',1,45326,0,32740,32850,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27891,'Dark Forester',1,45326,0,32742,32827,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27892,'Dark Forester',1,45326,0,32763,32819,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27893,'Dark Forester',1,45326,0,32755,32862,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27894,'Dark Forester',1,45326,0,32820,32878,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27895,'Dark Forester',1,45326,0,32796,32845,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27896,'Dark Forester',1,45326,0,32826,32913,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27897,'Dark Forester',1,45326,0,32821,32936,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27898,'Dark Forester',1,45326,0,32854,32865,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27899,'Dark Forester',1,45326,0,32857,32802,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27900,'Dark Forester',1,45326,0,32860,32808,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27901,'Dark Forester',1,45326,0,32867,32868,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27902,'Plate Worm',1,46017,0,32783,32894,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27903,'Plate Worm',1,46017,0,32744,32930,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27904,'Plate Worm',1,46017,0,32759,32904,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27905,'Plate Worm',1,46017,0,32744,32847,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27906,'Plate Worm',1,46017,0,32739,32825,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27907,'Plate Worm',1,46017,0,32760,32825,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27908,'Plate Worm',1,46017,0,32767,32860,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27909,'Plate Worm',1,46017,0,32825,32872,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27910,'Plate Worm',1,46017,0,32790,32847,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27911,'Plate Worm',1,46017,0,32829,32913,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27912,'Plate Worm',1,46017,0,32827,32932,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27913,'Plate Worm',1,46017,0,32850,32860,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27914,'Plate Worm',1,46017,0,32844,32857,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27915,'Plate Worm',1,46017,0,32859,32816,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27916,'Plate Worm',1,46017,0,32869,32805,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27917,'Plate Worm',1,46017,0,32869,32875,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27918,'Middle Oum',1,45331,0,32778,32895,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27919,'Middle Oum',1,45331,0,32729,32933,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27920,'Middle Oum',1,45331,0,32744,32900,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27921,'Middle Oum',1,45331,0,32727,32851,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27922,'Middle Oum',1,45331,0,32741,32814,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27923,'Middle Oum',1,45331,0,32760,32833,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27924,'Middle Oum',1,45331,0,32771,32866,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27925,'Middle Oum',1,45331,0,32824,32868,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27926,'Middle Oum',1,45331,0,32798,32865,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27927,'Middle Oum',1,45331,0,32829,32917,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27928,'Middle Oum',1,45331,0,32832,32935,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27929,'Middle Oum',1,45331,0,32841,32854,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27930,'Middle Oum',1,45331,0,32849,32849,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27931,'Middle Oum',1,45331,0,32835,32846,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27932,'Middle Oum',1,45331,0,32871,32810,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27933,'Middle Oum',1,45331,0,32865,32839,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27934,'Middle Oum',1,45331,0,32865,32880,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27935,'Black Wizard',1,46018,0,32774,32900,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27936,'Black Wizard',1,46018,0,32728,32922,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27937,'Black Wizard',1,46018,0,32739,32892,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27938,'Black Wizard',1,46018,0,32725,32847,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27939,'Black Wizard',1,46018,0,32739,32712,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27940,'Black Wizard',1,46018,0,32759,32839,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27941,'Black Wizard',1,46018,0,32759,32877,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27942,'Black Wizard',1,46018,0,32824,32863,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27943,'Black Wizard',1,46018,0,32787,32867,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27944,'Black Wizard',1,46018,0,32823,32925,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27945,'Black Wizard',1,46018,0,32834,32912,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27946,'Black Wizard',1,46018,0,32831,32843,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27947,'Black Wizard',1,46018,0,32867,32817,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27948,'Black Wizard',1,46018,0,32870,32885,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27949,'Black Wizard',1,46018,0,32870,32891,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27950,'Black Wizard',1,46018,0,32854,32929,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27951,'Heavy Oum',1,46016,0,32769,32916,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27952,'Heavy Oum',1,46016,0,32726,32917,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27953,'Heavy Oum',1,46016,0,32740,32881,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27954,'Heavy Oum',1,46016,0,32729,32831,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27955,'Heavy Oum',1,46016,0,32744,32801,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27956,'Heavy Oum',1,46016,0,32757,32842,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27957,'Heavy Oum',1,46016,0,32759,32882,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27958,'Heavy Oum',1,46016,0,32815,32862,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27959,'Heavy Oum',1,46016,0,32780,32864,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27960,'Heavy Oum',1,46016,0,32817,32930,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27961,'Heavy Oum',1,46016,0,32839,32905,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27962,'Heavy Oum',1,46016,0,32837,32826,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27963,'Heavy Oum',1,46016,0,32870,32823,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27964,'Heavy Oum',1,46016,0,32861,32829,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27965,'Heavy Oum',1,46016,0,32852,32826,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27966,'Heavy Oum',1,46016,0,32867,32899,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27967,'Heavy Oum',1,46016,0,32853,32906,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27968,'Heavy Oum',1,46016,0,32868,32922,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27969,'Heavy Oum',1,46016,0,32856,32927,0,0,0,0,0,0,0,60,120,310,0,100,0,0);
insert into spawnlist values(27970,'Heavy Oum',1,46016,0,32865,32931,0,0,0,0,0,0,0,60,120,310,0,100,0,0);

# Update aggro settings for Gludio Ghosts, disable aggro modes
update npc set agrososc = 0 where npcid > 45911 and npcid < 45917;
update npc set agrocoi = 0 where npcid > 45911 and npcid < 45917;

# Add Skill description column to help identify type of mobskill assigned
ALTER TABLE mobskill ADD Skill_Description varchar(45) AFTER mobname; 

# Update mobskill descriptions
update mobskill set skill_description = 'Lesser Heal' where SkillId = 1;
update mobskill set skill_description = 'Energy Bolt' where SkillId = 4;
update mobskill set skill_description = 'Ice Dagger' where SkillId = 6;
update mobskill set skill_description = 'Wind Shuriken' where SkillId = 7;
update mobskill set skill_description = 'Chill Touch' where SkillId = 10;
update mobskill set skill_description = 'Fire Arrow' where SkillId = 15;
update mobskill set skill_description = 'Stalac' where SkillId = 16;
update mobskill set skill_description = 'Lightning' where SkillId = 17;
update mobskill set skill_description = 'Frost Cloud' where SkillId = 22;
update mobskill set skill_description = 'Fireball' where SkillId = 25;
update mobskill set skill_description = 'Vampiric Touch' where SkillId = 28;
update mobskill set skill_description = 'Slow' where SkillId = 29;
update mobskill set skill_description = 'Call Lightning' where SkillId = 34;
update mobskill set skill_description = 'Greater Heal' where SkillId = 35;
update mobskill set skill_description = 'Cone of Cold' where SkillId = 38;
update mobskill set skill_description = 'Mana Drain' where SkillId = 39;
update mobskill set skill_description = 'Haste' where SkillId = 43;
update mobskill set skill_description = 'Cancel' where SkillId = 44;
update mobskill set skill_description = 'Eruption' where SkillId = 45;
update mobskill set skill_description = 'Sunburst' where SkillId = 46;
update mobskill set skill_description = 'Weakness' where SkillId = 47;
update mobskill set skill_description = 'Tornado' where SkillId = 53;
update mobskill set skill_description = 'Full Heal' where SkillId = 57;
update mobskill set skill_description = 'Blizzard' where SkillId = 59;
update mobskill set skill_description = 'Earthquake' where SkillId = 62;
update mobskill set skill_description = 'Lightning Storm' where SkillId = 65;
update mobskill set skill_description = 'Firestorm' where SkillId = 70;
update mobskill set skill_description = 'Meteor Strike' where SkillId = 74;
update mobskill set skill_description = 'Mass Slow' where SkillId = 76;
update mobskill set skill_description = 'Destroy' where SkillId = 77;
update mobskill set skill_description = 'Shock Stun' where SkillId = 87;
update mobskill set skill_description = 'Ice Eruption' where SkillId = 10035;
update mobskill set skill_description = 'Root Debuff' where SkillId = 10071;

# update skills name identifiers for missing references
update skills set name = 'Root Debuff' where skill_id = 10071;

# correct name for Sand Tomb
update npc set name = 'Sand Tomb' where npcid = 45743;

#correct name for huge pumpkin seed to Giant
update etcitem set name = 'Giant Pumpkin Seed' where item_id = 40721;

# Adjust Engraved Visor weight from 350 to 50
update armor set weight = 50000 where item_id = 29503;

# Update missing mobskills
Update mobskill set Skill_Description = 'Bite Attack' where mobid = 45512 and actNo = 0;
INSERT INTO mobskill VALUES (45512,1,'Hell Bound','Fire Breath',1,50,0,0,1,0,0,3,1,2,15,0,0,18,0,0,0,0);

# update missing npc names for dolls
update npc set name = 'Werewolf Magic Doll' where npcid = 80108;
update npc set name = 'Bugbear Magic Doll' where npcid = 80106;
update npc set name = 'Succubus Magic Doll' where npcid = 80107;

# Update incorrect weapon name Lastabad to Lastavard
update weapon set name = 'Lastavard Dagger' where item_id = 6;
update weapon set name = 'Lastavard Blade' where item_id = 10;
update weapon set name = 'Lastavard Long Sword' where item_id = 38;
update weapon set name = 'Lastavard Edoryu' where item_id = 82;
update weapon set name = 'Lastavard One-Handed Spear' where item_id = 101;
update weapon set name = 'Lastavard Staff' where item_id = 122;

# Update Shop Data for Lastavard - From Valakas
ALTER TABLE shop ADD NPC_Name varchar(45) AFTER npc_id;
ALTER TABLE shop ADD Item_Name varchar(45) AFTER item_id;
insert into shop values (71127,'Squaroo',40056,'Meat',0,1,0,0);
insert into shop values (71127,'Squaroo',40317,'Whetstone',1,247,0,95);
insert into shop values (71127,'Squaroo',40010,'Lesser Healing Potion',2,60,0,23);
insert into shop values (71127,'Squaroo',40011,'Healing Potion',3,247,0,95);
insert into shop values (71127,'Squaroo',40012,'Greater Healing Potion',4,495,0,190);
insert into shop values (71127,'Squaroo',40017,'Cure Poison Potion',5,114,0,44);
insert into shop values (71127,'Squaroo',40013,'Haste Potion',6,330,0,127);
insert into shop values (71127,'Squaroo',40018,'Greater Haste Potion',7,2477,0,952);
insert into shop values (71127,'Squaroo',40126,'Scroll of Identify',8,198,0,76);
insert into shop values (71127,'Squaroo',40100,'Scroll of Teleportation',9,114,0,44);
insert into shop values (71127,'Squaroo',40089,'Scroll of Ressurrection',10,1651,0,635);
insert into shop values (71127,'Squaroo',40079,'Scroll of Escape',11,198,0,76);
insert into shop values (71127,'Squaroo',40022,'Ancient Lesser Healing Potion',12,104,0,40);
insert into shop values (71127,'Squaroo',40023,'Ancient Healing Potion',13,619,0,238);
insert into shop values (71127,'Squaroo',40024,'Ancient Greater Healing Potion',14,1634,0,628);

# Update Shop Data item descriptors
update shop set Item_Name = 'Orcish Dagger' where item_id = 1;
update shop set Item_Name = 'Dice Dagger' where item_id = 2;
update shop set Item_Name = 'Dagger' where item_id = 4;
update shop set Item_Name = 'Elven Dagger' where item_id = 5;
update shop set Item_Name = 'Lastavard Dagger' where item_id = 6;
update shop set Item_Name = 'Ivory Tower Dagger' where item_id = 7;
update shop set Item_Name = 'Mithril Dagger' where item_id = 8;
update shop set Item_Name = 'Oriharukon Dagger' where item_id = 9;
update shop set Item_Name = 'Lastavard Blade' where item_id = 10;
update shop set Item_Name = 'Wind Blade Dagger' where item_id = 12;
update shop set Item_Name = 'Finger of Death' where item_id = 13;
update shop set Item_Name = 'Claw of Chaos' where item_id = 14;
update shop set Item_Name = 'Sword of Kurtz' where item_id = 15;
update shop set Item_Name = 'Blade of Revenge' where item_id = 16;
update shop set Item_Name = 'Orcish Short Sword' where item_id = 21;
update shop set Item_Name = 'Broad Sword' where item_id = 23;
update shop set Item_Name = 'Short Sword' where item_id = 24;
update shop set Item_Name = 'Silver Sword' where item_id = 25;
update shop set Item_Name = 'Dwarvish Short Sword' where item_id = 26;
update shop set Item_Name = 'Scimitar' where item_id = 27;
update shop set Item_Name = 'Long Silver Sword' where item_id = 29;
update shop set Item_Name = 'Long Sword' where item_id = 31;
update shop set Item_Name = 'Gradius' where item_id = 32;
update shop set Item_Name = 'Sword of Honor' where item_id = 33;
update shop set Item_Name = 'Sword of Red Desire' where item_id = 34;
update shop set Item_Name = 'IT One-Handed Sword' where item_id = 35;
update shop set Item_Name = 'Damascus Sword' where item_id = 37;
update shop set Item_Name = 'Lastavard Long Sword' where item_id = 38;
update shop set Item_Name = 'Cutlass' where item_id = 39;
update shop set Item_Name = 'Large Sword of Blood' where item_id = 40;
update shop set Item_Name = 'Katana' where item_id = 41;
update shop set Item_Name = 'Shamshir' where item_id = 43;
update shop set Item_Name = 'IT Two-Handed Sword' where item_id = 48;
update shop set Item_Name = 'Long Sword of Pretender King' where item_id = 49;
update shop set Item_Name = 'Sword of Flames' where item_id = 50;
update shop set Item_Name = 'Two-Handed Sword' where item_id = 52;
update shop set Item_Name = 'Sword of Brave Lizardman Soldier' where item_id = 53;
update shop set Item_Name = 'Sword of Kurtz' where item_id = 54;
update shop set Item_Name = 'Blade of Darkness' where item_id = 55;
update shop set Item_Name = 'Tsurugi' where item_id = 57;
update shop set Item_Name = 'Fire Sword of Death Knight' where item_id = 58;
update shop set Item_Name = 'Sword of Knight Vald' where item_id = 59;
update shop set Item_Name = 'Doom Blade' where item_id = 60;
update shop set Item_Name = 'Two-Handed Sword of Pretender King' where item_id = 62;
update shop set Item_Name = 'Devil\'s Knife' where item_id = 63;
update shop set Item_Name = 'Great Sword' where item_id = 64;
update shop set Item_Name = 'Dragon Slayer' where item_id = 66;
update shop set Item_Name = 'Ancient Great Sword' where item_id = 67;
update shop set Item_Name = 'Ancient Sword' where item_id = 68;
update shop set Item_Name = 'Bronze Edoryu' where item_id = 69;
update shop set Item_Name = 'Steel Edoryu' where item_id = 71;
update shop set Item_Name = 'Shadow Edoryu' where item_id = 72;
update shop set Item_Name = 'Ivory Tower Edoryu' where item_id = 73;
update shop set Item_Name = 'Silver Edoryu' where item_id = 74;
update shop set Item_Name = 'Dark Edoryu' where item_id = 75;
update shop set Item_Name = 'Edoryu of Ronde' where item_id = 76;
update shop set Item_Name = 'Stealth Edoryu' where item_id = 77;
update shop set Item_Name = 'Assassin Sword of Assassin King' where item_id = 78;
update shop set Item_Name = 'Edoryu of Abyss' where item_id = 79;
update shop set Item_Name = 'Damascus Edoryu' where item_id = 80;
update shop set Item_Name = 'Lastavard Edoryu' where item_id = 82;
update shop set Item_Name = 'Diad Fortress Edoryu' where item_id = 83;
update shop set Item_Name = 'Kaiser Edoryu' where item_id = 84;
update shop set Item_Name = 'Devil\'s Edoryu' where item_id = 85;
update shop set Item_Name = 'Unknown Spear' where item_id = 87;
update shop set Item_Name = 'Bardiche' where item_id = 90;
update shop set Item_Name = 'Orcish Spear' where item_id = 91;
update shop set Item_Name = 'Bill-Guisarme' where item_id = 92;
update shop set Item_Name = 'Trident' where item_id = 93;
update shop set Item_Name = 'Partisan' where item_id = 94;
update shop set Item_Name = 'Lance' where item_id = 95;
update shop set Item_Name = 'Spear' where item_id = 96;
update shop set Item_Name = 'Guisarme' where item_id = 97;
update shop set Item_Name = 'Glaive' where item_id = 98;
update shop set Item_Name = 'Elven Spear' where item_id = 99;
update shop set Item_Name = 'Lastavard One-Handed Spear' where item_id = 101;
update shop set Item_Name = 'Lucern Hammer' where item_id = 102;
update shop set Item_Name = 'Halberd' where item_id = 103;
update shop set Item_Name = 'Fauchard' where item_id = 104;
update shop set Item_Name = 'Ivory Tower Spear' where item_id = 105;
update shop set Item_Name = 'Bec de Corbin' where item_id = 106;
update shop set Item_Name = 'Crimson Lance' where item_id = 107;
update shop set Item_Name = 'Crystal Staff' where item_id = 115;
update shop set Item_Name = 'Staff of Black Wizard' where item_id = 116;
update shop set Item_Name = 'Jet-Black Crystal Ball' where item_id = 118;
update shop set Item_Name = 'Staff of Demon' where item_id = 119;
update shop set Item_Name = 'Staff of Ice Queen' where item_id = 121;
update shop set Item_Name = 'Lastavard Staff' where item_id = 122;
update shop set Item_Name = 'Staff of Baphomet' where item_id = 124;
update shop set Item_Name = 'Staff of Sorcery' where item_id = 125;
update shop set Item_Name = 'Staff of Mana' where item_id = 126;
update shop set Item_Name = 'Oak Staff' where item_id = 128;
update shop set Item_Name = 'Wizard\'s Staff' where item_id = 129;
update shop set Item_Name = 'Staff of Strength' where item_id = 131;
update shop set Item_Name = 'Unknown Axe' where item_id = 135;
update shop set Item_Name = 'Axe' where item_id = 136;
update shop set Item_Name = 'Athame' where item_id = 137;
update shop set Item_Name = 'Club' where item_id = 138;
update shop set Item_Name = 'Flail' where item_id = 139;
update shop set Item_Name = 'Mace' where item_id = 140;
update shop set Item_Name = 'War Hammer' where item_id = 141;
update shop set Item_Name = 'Silver Axe' where item_id = 142;
update shop set Item_Name = 'Battle Axe' where item_id = 143;
update shop set Item_Name = 'Dwarvish Axe' where item_id = 144;
update shop set Item_Name = 'Berserker Axe' where item_id = 145;
update shop set Item_Name = 'Morning Staf' where item_id = 146;
update shop set Item_Name = 'Ivory Tower Axe' where item_id = 147;
update shop set Item_Name = 'Great Axe' where item_id = 148;
update shop set Item_Name = 'Axe of Minotaur' where item_id = 149;
update shop set Item_Name = 'Hammer of the Heavens' where item_id = 150;
update shop set Item_Name = 'Demon Axe' where item_id = 151;
update shop set Item_Name = 'Bronze Claw' where item_id = 152;
update shop set Item_Name = 'Steel Claw' where item_id = 153;
update shop set Item_Name = 'Shadow Claw' where item_id = 154;
update shop set Item_Name = 'Claw of Magic Power King' where item_id = 155;
update shop set Item_Name = 'Ivory Tower Claw' where item_id = 156;

# Update Market Zones to no longer allow pets/summons
update mapids set take_pets = 0 where mapid = 340;
update mapids set take_pets = 0 where mapid = 350;
update mapids set take_pets = 0 where mapid = 360;
update mapids set take_pets = 0 where mapid = 370;
update mapids set recall_pets = 0 where mapid = 340;
update mapids set recall_pets = 0 where mapid = 350;
update mapids set recall_pets = 0 where mapid = 360;
update mapids set recall_pets = 0 where mapid = 370;
update mapids set penalty = 0 where mapid = 340;
update mapids set penalty = 0 where mapid = 350;
update mapids set penalty = 0 where mapid = 360;
update mapids set penalty = 0 where mapid = 370;

