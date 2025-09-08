-- IMPORTANT: THIS UPDATE IS NOT YET FINISHED, DONT USE!

-- Queries that are pending an update should be placed here. This allows them
-- to be verified as working together. Once complete, the -pending suffix will
-- be removed.

-- Add the door graphics for the TI Cave 2f doors
INSERT INTO door_gfxs (gfxid,note,direction,left_edge_offset,right_edge_offset) VALUES 
(88,'TICaves Doors',0,0,0),
(89,'TICaves Doors',1,0,0);

-- Add the actual doors to the game for TI Caves 2f. 6006 and 6007 are the golden/pale silver key doors
INSERT INTO spawnlist_door (id,mapid,location,gfxid,locx,locy,hp,keeper) VALUES 
(6001,2,'TI Caves 2f',92,32664,32807,0,0),
(6002,2,'TI Caves 2f',93,32673,32820,0,0),
(6003,2,'TI Caves 2f',92,32668,32833,0,0),
(6004,2,'TI Caves 2f',88,32661,32823,0,0),
(6005,2,'TI Caves 2f',89,32672,32858,0,0),
(6008,2,'TI Caves 2f',89,32678,32877,0,0),
(6009,2,'TI Caves 2f',89,32732,32872,0,0),
(6010,2,'TI Caves 2f',89,32736,32872,0,0),
(6011,2,'TI Caves 2f',89,32740,32872,0,0),
(6012,2,'TI Caves 2f',89,32795,32870,0,0),
(6013,2,'TI Caves 2f',88,32803,32862,0,0),
(6014,2,'TI Caves 2f',89,32806,32824,0,0),
(6015,2,'TI Caves 2f',88,32803,32832,0,0),
(6016,2,'TI Caves 2f',92,32798,32844,0,0),
(6017,2,'TI Caves 2f',93,32759,32847,0,0),
(6018,2,'TI Caves 2f',88,32808,32792,0,0),
(6019,2,'TI Caves 2f',93,32776,32806,0,0),
(6020,2,'TI Caves 2f',93,32775,32818,0,0),
(6021,2,'TI Caves 2f',88,32741,32804,0,0),
(6022,2,'TI Caves 2f',89,32740,32788,0,0),
(6023,2,'TI Caves 2f',89,32750,32793,0,0),
(6024,2,'TI Caves 2f',89,32766,32791,0,0),
(6025,2,'TI Caves 2f',93,32755,32818,0,0),
(6026,2,'TI Caves 2f',93,32726,32812,0,0),
(6027,2,'TI Caves 2f',93,32705,32816,0,0),
(6028,2,'TI Caves 2f',92,32698,32803,0,0),
(6029,2,'TI Caves 2f',92,32680,32797,0,0),
(6030,2,'TI Caves 2f',93,32707,32789,0,0),
(6031,2,'TI Caves 2f',92,32725,32795,0,0),
(6032,2,'TI Caves 2f',92,32667,32871,0,0);

-- add new template for the mobs with the pale silver key
INSERT INTO npc (npcid,name,nameid,note,impl,gfxid,lvl,hp,mp,ac,str,con,dex,wis,intel,mr,`exp`,lawful,`size`,weakAttr,ranged,tamable,passispeed,atkspeed,alt_atk_speed,atk_magic_speed,sub_magic_speed,undead,poison_atk,paralysis_atk,agro,agrososc,agrocoi,family,agrofamily,agrogfxid1,agrogfxid2,picupitem,digestitem,bravespeed,hprinterval,hpr,mprinterval,mpr,teleport,randomlevel,randomhp,randommp,randomac,randomexp,randomlawful,damage_reduction,hard,doppel,IsTU,IsErase,bowActId,karma,transform_id,transform_gfxid,light_size,amount_fixed,change_head,cant_resurrect) VALUES (92000, 'Skeleton Archer','$986','Pale silver key','L1Monster',1096,12,80,25,0,16,14,16,12,10,10,145,-12,'small',2,10,1,800,1120,920,1120,1120,1,0,0,1,1,0,'skeleton',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,66,0,-1,0,0,0,0,0),
(92001,'Skeleton Soldier','$988','Pale silver key','L1Monster',1106,13,90,15,8,16,14,15,12,10,10,170,-13,'small',2,2,1,640,880,840,880,880,1,0,0,1,1,0,'skeleton',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0),
('92002','Skeleton Axeman','$987','Pale silver key','L1Monster',1104,13,90,20,0,18,14,14,12,10,10,170,-13,'small',2,1,1,480,840,840,840,840,1,0,0,1,1,0,'skeleton',1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,-1,0,0,0,0,0);

-- add the spawns for the pale silver key 
INSERT INTO spawnlist (location,count,npc_templateid,group_id,locx,locy,randomx,randomy,locx1,locy1,locx2,locy2,heading,min_respawn_delay,max_respawn_delay,mapid,respawn_screen,movement_distance,rest,near_spawn,spawn_home,spawn_home_range,spawn_home_count,spawn_home_delay) VALUES 
('Skeleton Axeman - PSK',3,92002,0,32736,32848,5,5,32730,32848,32740,32858,5,0,0,2,0,20,0,0,1,8,2,100),
('Skeleton Soldier - PSK',3,92001,0,32736,32848,5,5,32730,32848,32740,32858,5,0,0,2,0,20,0,0,1,8,2,100),
('Skeleton Archer - PSK',3,92000,0,32736,32848,5,5,32730,32848,32740,32858,5,0,0,2,0,20,0,0,1,8,2,100);

-- add the pale silver key to the spawns at at 7.5% drop rate
INSERT INTO droplist (mobId,mob_name,itemId,item_name,min,max,chance) VALUES 
(92000,'Skeleton Archer',172,'Bow',1,1,50000),
(92000,'Skeleton Archer',20043,'Helmet',1,1,50000),
(92000,'Skeleton Archer',20056,'Cloak of Magic Resistance',1,1,50000),
(92000,'Skeleton Archer',40013,'Haste Potion',1,1,50000),
(92000,'Skeleton Archer',40018,'Greater Haste Potion',1,1,50000),
(92000,'Skeleton Archer',40171,'Spellbook(EnchantDex)',1,1,10000),
(92000,'Skeleton Archer',40240,'Spirit Crystal(TripleShot)',1,1,5000),
(92000,'Skeleton Archer',40308,'Adena',33,65,1000000),
(92000,'Skeleton Archer',40407,'Bone Piece',1,1,50000),
(92000,'Skeleton Archer',40313,'Pale silver key',1,1,75000),
(92001,'Skeleton Soldier',96,'Spear',1,1,10000),
(92001,'Skeleton Soldier',20056,'Cloak of Magic Resistance',1,1,50000),
(92001,'Skeleton Soldier',40013,'Haste Potion',1,1,50000),
(92001,'Skeleton Soldier',40018,'Greater Haste Potion',1,1,50000),
(92001,'Skeleton Soldier',40171,'Spellbook(EnchantDex)',1,1,10000),
(92001,'Skeleton Soldier',40308,'Adena',37,72,1000000),
(92001,'Skeleton Soldier',40407,'Bone Piece',1,1,50000),
(92001,'Skeleton Soldier',40739,'Throwing Knife',1,1,10000),
(92001,'Skeleton Archer',40313,'Pale silver key',1,1,75000),
(92002,'Skeleton Axeman',136,'Axe',1,1,50000),
(92002,'Skeleton Axeman',20056,'Cloak of Magic Resistance',1,1,50000),
(92002,'Skeleton Axeman',40006,'Pine Wand',1,1,10000),
(92002,'Skeleton Axeman',40013,'Haste Potion',1,1,50000),
(92002,'Skeleton Axeman',40018,'Greater Haste Potion',1,1,50000),
(92002,'Skeleton Axeman',40171,'Spellbook(EnchantDex)',1,1,10000),
(92002,'Skeleton Axeman',40187,'Spellbook(EnchantStr)',1,1,10000),
(92002,'Skeleton Axeman',40308,'Adena',37,72,1000000),
(92002,'Skeleton Axeman',40407,'Bone Piece',1,1,50000),
(92002,'Skeleton Archer',40313,'Pale silver key',1,1,75000);

-- add hidden valley dungeon boss to enable theo quest
INSERT INTO spawnlist_boss VALUES 
(300, 'Cursed Ettin', 'Caspa', 1, 45112, 0, 32929, 32735, 0, 0, 0, 0, 0, 0, 0, 86, 1, 0, 0, 0, 100);