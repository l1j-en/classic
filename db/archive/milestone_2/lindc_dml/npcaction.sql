-- update 32

-- missing npc actions
INSERT INTO `npcaction` VALUES ('71198', 'tion1', 'tion1', '', ''); 
INSERT INTO `npcaction` VALUES ('71199', 'jeron1', 'jeron1', '', ''); 

-- chao npcs if you talk to them they will answer a different txt
UPDATE npcaction SET caotic_action="dorinl" WHERE npcid="60001"; 
UPDATE npcaction SET caotic_action="thraml" WHERE npcid="60003"; 
UPDATE npcaction SET caotic_action="denitzl" WHERE npcid="60004"; 
UPDATE npcaction SET caotic_action="lukul" WHERE npcid="60005"; 
UPDATE npcaction SET caotic_action="jiankul" WHERE npcid="60006"; 
UPDATE npcaction SET caotic_action="kariml" WHERE npcid="60007"; 
UPDATE npcaction SET caotic_action="nodiml" WHERE npcid="60008"; 
UPDATE npcaction SET caotic_action="sauraml" WHERE npcid="60009"; 
UPDATE npcaction SET caotic_action="kashaml" WHERE npcid="60010"; 
UPDATE npcaction SET caotic_action="kuronl" WHERE npcid="60011"; 
UPDATE npcaction SET caotic_action="axellonl" WHERE npcid="60013"; 
UPDATE npcaction SET caotic_action="jukel" WHERE npcid="60016"; 
UPDATE npcaction SET caotic_action="karudiml" WHERE npcid="60017"; 
UPDATE npcaction SET caotic_action="kamul" WHERE npcid="60018"; 
UPDATE npcaction SET caotic_action="timpukinl" WHERE npcid="60019"; 
UPDATE npcaction SET caotic_action="tulakl" WHERE npcid="60020"; 
UPDATE npcaction SET caotic_action="hiriml" WHERE npcid="60021"; 
UPDATE npcaction SET caotic_action="tarkinl" WHERE npcid="60023"; 
UPDATE npcaction SET caotic_action="gothaml" WHERE npcid="60024"; 
UPDATE npcaction SET caotic_action="kusianl" WHERE npcid="60025"; 
UPDATE npcaction SET caotic_action="kuhatinl" WHERE npcid="60027"; 
UPDATE npcaction SET caotic_action="hakiml" WHERE npcid="60030"; 
UPDATE npcaction SET caotic_action="rayearth2" WHERE npcid="60031"; 
UPDATE npcaction SET caotic_action="garinl" WHERE npcid="60032"; 
UPDATE npcaction SET caotic_action="gawll" WHERE npcid="60033"; 
UPDATE npcaction SET caotic_action="kuudl" WHERE npcid="60034"; 
UPDATE npcaction SET caotic_action="zadarl" WHERE npcid="60035"; 
UPDATE npcaction SET caotic_action="tigusl" WHERE npcid="60036";