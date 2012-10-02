-- To reset those who have already finished Longbow of Moon Quest
-- Only need to run once if someone has finished the quest before the C_NPCAction.java update

update character_quests set quest_step=0 where quest_id=40 AND quest_step=255;