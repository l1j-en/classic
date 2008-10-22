-- update 1

-- set arrow sell price to 0 to prevent infinite money exploit
update shop set selling_price = 0 where item_id = 40743;



-- update 8

-- remove various items from shop lists (excluding gm shops)
-- ancient items
delete from shop where item_id in (20092, 20093, 20094, 20095, 67, 68, 179, 182) and npc_id < 81000 and selling_price = -1;
-- daggers/swords
delete from shop where item_id in (3, 5, 8, 9, 11, 12, 13, 14, 16, 17, 18, 19, 20, 22, 28, 30, 36, 42, 44, 45, 46, 47, 49, 50, 51, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 100008, 100009, 100028, 100042, 100049, 100057, 100062, 100064) and npc_id < 81000 and selling_price = -1;
-- edoryus
delete from shop where item_id in (70, 74, 78, 79, 81, 82, 83, 84, 85, 86, 100074, 100084) and npc_id < 81000 and selling_price = -1;
-- polearms
delete from shop where item_id in (88, 89, 99, 100, 107, 100099, 100107) and npc_id < 81000 and selling_price = -1;
-- staves
delete from shop where item_id in (108, 109, 110, 111, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 126, 127, 130, 131, 132, 133, 134, 100132) and npc_id < 81000 and selling_price = -1;
-- axes
delete from shop where item_id in (149, 151, 100151) and npc_id < 81000 and selling_price = -1;
-- claws
delete from shop where item_id in (155, 160, 162, 163, 164, 165, 166, 100164) and npc_id < 81000 and selling_price = -1;
-- bows
delete from shop where item_id in (167, 177, 178, 179, 180, 181, 183, 184, 185, 188, 189, 190, 192, 194, 100189) and npc_id < 81000 and selling_price = -1;
-- helms
delete from shop where item_id in (20003, 20004, 20005, 20009, 20010, 20016, 20017, 20018, 20020, 20021, 20022, 20024, 20025, 20027, 20029, 20030, 20031, 20033, 20035, 20039, 20040, 20041, 20042, 20046, 20047, 20048) and npc_id < 81000 and selling_price = -1;
-- cloaks
delete from shop where item_id in (20049, 20050, 20051, 20054, 20055, 20057, 20058, 20059, 20060, 20061, 20062, 20064, 20065, 20066, 20067, 20068, 20069, 20070, 20071, 20074, 20076, 20077, 20078, 20079, 20080) and npc_id < 81000 and selling_price = -1;
-- shirts
delete from shop where item_id in (20082, 20083, 20084, 20086, 20087, 20088) and npc_id < 81000 and selling_price = -1;
-- body armor
delete from shop where item_id in (20091, 20099, 20100, 20106, 20107, 20108, 20109, 20112, 20113, 20116, 20117, 20118, 20119, 20121, 20123, 20127, 20129, 20130, 20131, 20134, 20137, 20138, 20140, 20141, 20142, 20143, 20144, 20146, 20150, 20151, 20152, 20153, 20156, 20157, 20158, 20159, 20160) and npc_id < 81000 and selling_price = -1;
-- gloves
delete from shop where item_id in (20163, 20164, 20165, 20166, 20167, 20168, 20169, 20170, 20171, 20176, 20179, 20183, 20184, 20185, 20186, 20187, 20190) and npc_id < 81000 and selling_price = -1;
-- boots 
delete from shop where item_id in (20194, 20195, 20197, 20198, 20201, 20202, 20203, 20204, 20208, 20209, 20211, 20214, 20215, 20216, 20218) and npc_id < 81000 and selling_price = -1;
-- shields 
delete from shop where item_id in (20220, 20225, 20226, 20228, 20230, 20233, 20234, 20240) and npc_id < 81000 and selling_price = -1;
-- amulets 
delete from shop where item_id in (20243, 20244, 20245, 20246, 20247, 20248, 20249, 20250, 20251, 20252, 20253, 20254, 20255, 20256, 20257, 20258, 20259, 20260, 20261, 20262, 20263, 20264, 20265, 20266, 20267, 20268, 20269, 20270, 120244, 120245, 120246, 120247, 120248, 120249, 120254, 120256, 120264, 120266, 120267, 120268) and npc_id < 81000 and selling_price = -1;
-- rings
delete from shop where item_id in (20277, 20278, 20279, 20280, 20281, 20282, 20284, 20285, 20286, 20287, 20288, 20289, 20290, 20291, 20293, 20294, 20295, 20296, 20297, 20298, 20299, 20300, 20301, 20302, 20303, 20304, 20305, 120280, 120285, 120289, 120300, 120302, 120304) and npc_id < 81000 and selling_price = -1;
-- belts
delete from shop where item_id in (20306, 20307, 20308, 20309, 20310, 20311, 20312, 20313, 20314, 20315, 20316, 20317, 20318, 20319, 20320, 20321, 120306, 120307, 120308, 120309, 120310, 120311, 120312, 120316, 120317, 120319, 120320, 120321) and npc_id < 81000 and selling_price = -1;
-- misc armors
delete from shop where item_id in (20342, 20343, 20344, 20345, 20346, 20347, 20348, 20349, 20350, 20353, 20352, 120016, 120074, 120077, 120085, 120112) and npc_id < 81000 and selling_price = -1;
-- elixirs
delete from shop where item_id in (40033, 40034, 40035, 40036, 40037, 40038) and npc_id < 81000 and selling_price = -1;
-- toi charms
delete from shop where item_id in (20180, 40281, 40282, 40283, 40284, 40285, 40286, 40287, 40288, 40289, 40290, 40291, 40292, 40293, 40294, 40295, 40296, 40297) and npc_id < 81000 and selling_price = -1;
-- relics
delete from shop where item_id in (40304, 40305, 40306, 40307) and npc_id < 81000 and selling_price = -1;
-- misc items
delete from shop where item_id in (40162, 40308, 40314, 40316, 40330, 40466, 40513) and npc_id < 81000 and selling_price = -1;



-- update 9

-- fix infinite money exploit for bp return scrolls
delete from shop where purchasing_price = 210;



-- update 13

-- increase buy price of b-scimitar (660 -> 1320)
update shop set purchasing_price = 1320 where item_id = 100027;

-- decrease buy price of c-scimitar (11000 -> 320)
update shop set purchasing_price = 320 where item_id = 200027;

-- remove duplicate shop buylist entries
delete from shop where item_id = 4 and order_id = 0 and selling_price = -1 and npc_id in (70018, 70021, 70030, 70045, 70063, 70074);
delete from shop where item_id = 20213 and order_id = 0 and selling_price = -1 and npc_id in (70014, 70045, 70074, 70079);
delete from shop where item_id = 40001 and order_id = 0 and selling_price = -1 and npc_id in (70045, 70074);
delete from shop where item_id = 40002 and order_id = 0 and selling_price = -1 and npc_id in (70014, 70045, 70074, 70079);
delete from shop where item_id = 40003 and order_id = 0 and selling_price = -1 and npc_id in (70014, 70045, 70074, 70079);
delete from shop where item_id = 40009 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40010 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40011 and order_id = 0 and selling_price = -1 and npc_id in (70074, 70079);
delete from shop where item_id = 40012 and order_id = 0 and selling_price = -1 and npc_id in (70074, 70079);
delete from shop where item_id = 40013 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40017 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40018 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40022 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40023 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40024 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40100 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40119 and order_id = 0 and selling_price = -1 and npc_id in (70074, 70079);
delete from shop where item_id = 40126 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40310 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40311 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40315 and order_id = 0 and selling_price = -1 and npc_id in (70074, 70079);
delete from shop where item_id = 40317 and order_id = 0 and selling_price = -1 and npc_id in (70074);
delete from shop where item_id = 40380 and order_id = 0 and selling_price = -1 and npc_id in (70014, 70018, 70021, 70030, 70045, 70063, 70074, 70079);

-- fix maple buy price on shops 70079, 70014
update shop set purchasing_price = 1000 where item_id = 4008 and npc_id in (70079, 70014);

-- remove evolution fruit from shop buylist
delete from shop where item_id = 40070 and selling_price = -1;

-- remove ancient scroll from shop buylist
delete from shop where item_id = 40076 and selling_price = -1;

-- swap shop prices for b-pm and pm
update shop set purchasing_price = 18500 where item_id = 20154 and purchasing_price = 25900;
update shop set purchasing_price = 25900 where item_id = 120154 and purchasing_price = 18500;



-- update 16

-- add light scroll to skt shop
insert into shop values (70074, 40860, 49, 127, 0, 0);

-- remove duplicate candy from skt shop
delete from shop where npc_id = 70074 and item_id = 40065 and selling_price = -1;

-- remove duplicate esc scroll from skt shop
delete from shop where npc_id = 70074 and item_id = 40079 and selling_price = -1;

-- remove duplicate res scroll from skt shop
delete from shop where npc_id = 70074 and item_id = 40089 and selling_price = -1;

-- fix hbow sell to store price
update shop set purchasing_price = 2500 where item_id = 169 and purchasing_price = 25;



-- update 19

-- set berserker axe to sell for 900a (was 1a)
update shop set purchasing_price = 900 where item_id = 145 and npc_id in (70074, 70018, 70021, 70030, 70045, 70063, 70079, 70014);



-- update 21

-- remove spell scroll: light from skt shop, since lanterns work now
delete from shop where item_id = 40860;



-- update 24

-- remove invalid items in shop table
delete from shop where item_id in (0, 210001, 210002, 210003, 210004, 210005, 210006);



-- update 25

-- remove elf crystals from the buy lists of all shops that only purchase
-- them (to exclude gmshop and IT shop, which sell these)
delete from shop where item_id between 40232 and 40264 and selling_price = -1;

-- add elf crystal purchasing from NPC Melissa in Aden
-- Spirit Crystal(ResistMagic)
insert into shop values (70052, 40232, 0, -1, 0, 500);
-- Spirit Crystal(BodytoMind)
insert into shop values (70052, 40233, 0, -1, 0, 500);
-- Spirit Crystal(TeleportToMotherTree)
insert into shop values (70052, 40234, 0, -1, 0, 500);
-- Spirit Crystal(ClearMind)
insert into shop values (70052, 40235, 0, -1, 0, 1000);
-- Spirit Crystal(ResistElemental) 
insert into shop values (70052, 40236, 0, -1, 0, 1000);
-- Spirit Crystal(ReturnToNature)
insert into shop values (70052, 40237, 0, -1, 0, 1500);
-- Spirit Crystal(BloodtoSoul)
insert into shop values (70052, 40238, 0, -1, 0, 1500);
-- Spirit Crystal(ProtectionFromElemental)
insert into shop values (70052, 40239, 0, -1, 0, 1500);
-- Spirit Crystal(TripleShot)
insert into shop values (70052, 40240, 0, -1, 0, 1500);
-- Spirit Crystal(ElementalFallDown)
insert into shop values (70052, 40241, 0, -1, 0, 2000);
-- Spirit Crystal(EraseMagic)
insert into shop values (70052, 40242, 0, -1, 0, 2000);
-- Spirit Crystal(SummonLesserElement)
insert into shop values (70052, 40243, 0, -1, 0, 2000);
-- Spirit Crystal(AreaOfSilence)
insert into shop values (70052, 40244, 0, -1, 0, 2500);
-- Spirit Crystal(SummonGreaterElement)
insert into shop values (70052, 40245, 0, -1, 0, 2500);
-- Spirit Crystal(CounterMirror)
insert into shop values (70052, 40246, 0, -1, 0, 2500);
-- Spirit Crystal(EarthSkin)
insert into shop values (70052, 40247, 0, -1, 0, 1500);
-- Spirit Crystal(Entangle)
insert into shop values (70052, 40248, 0, -1, 0, 1500);
-- Spirit Crystal(EarthBind)
insert into shop values (70052, 40249, 0, -1, 0, 2000);
-- Spirit Crystal(BlessOfEarth)
insert into shop values (70052, 40250, 0, -1, 0, 2000);
-- Spirit Crystal(IronSkin)
insert into shop values (70052, 40251, 0, -1, 0, 2500);
-- Spirit Crystal(ExoticVitalize)
insert into shop values (70052, 40252, 0, -1, 0, 2500);
-- Spirit Crystal(WaterLife)
insert into shop values (70052, 40253, 0, -1, 0, 1500);
-- Spirit Crystal(NaturesTouch)
insert into shop values (70052, 40254, 0, -1, 0, 2000);
-- Spirit Crystal(NaturesBlessing)
insert into shop values (70052, 40255, 0, -1, 0, 2500);
-- Spirit Crystal(FireWeapon)
insert into shop values (70052, 40256, 0, -1, 0, 1500);
-- Spirit Crystal(BlessOfFire)
insert into shop values (70052, 40257, 0, -1, 0, 2000);
-- Spirit Crystal(BurningWeapon)
insert into shop values (70052, 40258, 0, -1, 0, 2500);
-- Spirit Crystal(ElementalFire)
insert into shop values (70052, 40259, 0, -1, 0, 2500);
-- Spirit Crystal(WindShot)
insert into shop values (70052, 40260, 0, -1, 0, 1500);
-- Spirit Crystal(WindWalk)
insert into shop values (70052, 40261, 0, -1, 0, 1500);
-- Spirit Crystal(EyeofStorm)
insert into shop values (70052, 40262, 0, -1, 0, 2000);
-- Spirit Crystal(StormShot) 
insert into shop values (70052, 40263, 0, -1, 0, 2500);
-- Spirit Crystal(WindShackle) 
insert into shop values (70052, 40264, 0, -1, 0, 2500);

-- set Orim nzel price to 30k
update shop set selling_price = 30000, purchasing_price = 15000 where item_id = 40074 and npc_id = 70017;

-- Spirit Crystal(Natures Miracle)  Fix for melissa 
insert into shop values (70052, 41243, 0, -1, 0, 2500);

-- upped NPC pot merchant Rozen's prices. Should be tax-free, but cost more (+20%)
update shop set selling_price = 44 where npc_id = 70049 and item_id = 40010;
update shop set selling_price = 180 where npc_id = 70049 and item_id = 40011;
update shop set selling_price = 360 where npc_id = 70049 and item_id = 40012;
update shop set selling_price = 84 where npc_id = 70049 and item_id = 40017;
update shop set selling_price = 1800 where npc_id = 70049 and item_id = 40018;
