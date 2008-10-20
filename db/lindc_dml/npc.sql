-- update 32

-- the npcs for there quest
INSERT INTO `npc` VALUES ('71198', 'Tion', '$5030', '', 'L1Merchant', '1659', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0'); 
INSERT INTO `npc` VALUES ('71199', 'Jeron', '$5029', '', 'L1Merchant', '1254', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '-1', '-1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0'); 

-- make elders aggro to chao
update npc set aggrochao = 1 where npcid = 45215;

-- correct some transform_ids in npc table
update npc set transform_id = 45976 where npcid = 45964;
update npc set transform_id = 45977 where npcid = 45966;
update npc set transform_id = 45980 where npcid = 45965;
update npc set transform_id = 45981 where npcid = 45969;
update npc set transform_id = 45982 where npcid = 45967;
update npc set transform_id = 45990 where npcid = 45968;
update npc set transform_id = 45991 where npcid = 45971;
update npc set transform_id = 45992 where npcid = 45972;
update npc set transform_id = 45993 where npcid = 45971;
update npc set transform_id = 45996 where npcid = 45970;
update npc set transform_id = 45997 where npcid = 45973;
update npc set transform_id = 46005 where npcid = 45974;
update npc set transform_id = 46011 where npcid = 45975;