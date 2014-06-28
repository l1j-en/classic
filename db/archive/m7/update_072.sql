-- update 72

-- various skill adjustments

-- Light 2

-- Skill:Light-2 impl changed from None 
UPDATE skills SET impl = 'L1Light' WHERE skill_id = 2;

-- DecreaseWeight 14

-- Skill:DecreaseWeight-14 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 14;

-- Meditate 32

-- Skill:Meditate-32 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 32;

-- Silence 64

-- Skill:Silence-64 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 64;

-- LightningStorm 65

-- Skill:LightningStorm-65 area changed from 4 
UPDATE skills SET area = '3' WHERE skill_id = 65;

-- DecayPotion 71

-- Skill:DecayPotion-71 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 71;

-- VenomResist 104

-- Skill:VenomResist-104 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 104;

-- DressEvasion 111

-- Skill:DressEvasion-111 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 111;

-- TrueTarget 113

-- Skill:TrueTarget-113 type changed from 128 
UPDATE skills SET type = '2' WHERE skill_id = 113;

-- Glowing Aura 114

-- Skill:Glowing Aura-114 mpConsume changed from 30 
UPDATE skills SET mpConsume = '40' WHERE skill_id = 114;

-- CallPledgeMember 116

-- Skill:CallPledgeMember-116 sysmsgID_fail changed from 0 
UPDATE skills SET sysmsgID_fail = '280' WHERE skill_id = 116;

-- Skill:CallPledgeMember-116 mpConsume changed from 40 
UPDATE skills SET mpConsume = '30' WHERE skill_id = 116;

-- Skill:CallPledgeMember-116 area changed from -1 
UPDATE skills SET area = '0' WHERE skill_id = 116;

-- Teleport to Pledge Member 118

-- Skill:Teleport to Pledge Member-118 area changed from -1 
UPDATE skills SET area = '0' WHERE skill_id = 118;

-- CounterMirror 134

-- Skill:CounterMirror-134 target changed from buff 
UPDATE skills SET target = 'none' WHERE skill_id = 134;

-- Skill:CounterMirror-134 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 134;

-- ReturnToNature 145

-- Skill:ReturnToNature-145 sysmsgID_happen changed from 2245 
UPDATE skills SET sysmsgID_happen = '0' WHERE skill_id = 145;

-- Skill:ReturnToNature-145 castgfx changed from 19 
UPDATE skills SET castgfx = '2245' WHERE skill_id = 145;

-- EraseMagic 153

-- Skill:EraseMagic-153 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 153;

-- ElementalFire 171

-- Skill:ElementalFire-171 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 171;

-- Pollute Water 173

-- Skill:Pollute Water-173 probability_value changed from 40 
UPDATE skills SET probability_value = '33' WHERE skill_id = 173;

-- Skill:Pollute Water-173 probability_dice changed from 30 
UPDATE skills SET probability_dice = '50' WHERE skill_id = 173;

-- Skill:Pollute Water-173 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 173;

-- Striker Gale 174

-- Skill:Striker Gale-174 probability_value changed from 50 
UPDATE skills SET probability_value = '33' WHERE skill_id = 174;

-- Skill:Striker Gale-174 probability_dice changed from 0 
UPDATE skills SET probability_dice = '30' WHERE skill_id = 174;

-- Skill:Striker Gale-174 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 174;

-- Soul of Flame 175

-- Skill:Soul of Flame-175 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 175;

-- Additional Fire 176

-- Skill:Additional Fire-176 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 176;


-- DragonSkin 181

-- Skill:DragonSkin-181 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 181;

-- MortalBody 191

-- Skill:MortalBody-191 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 191;

-- ThunderGrab 192

-- Skill:ThunderGrab-192 probability_value changed from 10 
UPDATE skills SET probability_value = '50' WHERE skill_id = 192;

-- Skill:ThunderGrab-192 damage_dice_count changed from 2 
UPDATE skills SET damage_dice_count = '5' WHERE skill_id = 192;

-- Skill:ThunderGrab-192 damage_value changed from 50 
UPDATE skills SET damage_value = '40' WHERE skill_id = 192;

-- Skill:ThunderGrab-192 damage_dice changed from 10 
UPDATE skills SET damage_dice = '8' WHERE skill_id = 192;

-- Confusion 202

-- Skill:Confusion-202 buffDuration changed from 8 
UPDATE skills SET buffDuration = '0' WHERE skill_id = 202;

-- Skill:Confusion-202 action_id changed from 18 
UPDATE skills SET action_id = '19' WHERE skill_id = 202;

-- Skill:Confusion-202 damage_value changed from 10 
UPDATE skills SET damage_value = '2' WHERE skill_id = 202;

-- Smash 203

-- Skill:Smash-203 buffDuration changed from 0 
UPDATE skills SET buffDuration = '2' WHERE skill_id = 203;

-- Skill:Smash-203 probability_value changed from 0 
UPDATE skills SET probability_value = '45' WHERE skill_id = 203;

-- Skill:Smash-203 damage_dice_count changed from 2 
UPDATE skills SET damage_dice_count = '0' WHERE skill_id = 203;

-- Skill:Smash-203 damage_value changed from 50 
UPDATE skills SET damage_value = '15' WHERE skill_id = 203;

-- Skill:Smash-203 damage_dice changed from 10 
UPDATE skills SET damage_dice = '0' WHERE skill_id = 203;

-- Concentration 206

-- Skill:Concentration-206 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 206;

-- MindBreak 207

-- Skill:MindBreak-207 action_id changed from 18 
UPDATE skills SET action_id = '19' WHERE skill_id = 207;

-- Skill:MindBreak-207 ranged changed from 3 
UPDATE skills SET ranged = '5' WHERE skill_id = 207;

-- Skill:MindBreak-207 damage_value changed from 5 
UPDATE skills SET damage_value = '3.8' WHERE skill_id = 207;

-- BoneBreak 208

-- Skill:BoneBreak-208 probability_value changed from 40 
UPDATE skills SET probability_value = '45' WHERE skill_id = 208;

-- Skill:BoneBreak-208 action_id changed from 18 
UPDATE skills SET action_id = '19' WHERE skill_id = 208;

-- Patience 211

-- Skill:Patience-211 impl changed from None 
UPDATE skills SET impl = 'L1MarkerSkill' WHERE skill_id = 211;

-- Phantasm 212

-- Skill:Phantasm-212 sysmsgID_fail changed from 0 
UPDATE skills SET sysmsgID_fail = '280' WHERE skill_id = 212;

-- ArmBreaker 213

-- Skill:ArmBreaker-213 buffDuration changed from 12 
UPDATE skills SET buffDuration = '10' WHERE skill_id = 213;

-- Skill:ArmBreaker-213 probability_value changed from 0 
UPDATE skills SET probability_value = '50' WHERE skill_id = 213;

-- Insight 216

-- Skill:Insight-216 target_to changed from 1 
UPDATE skills SET target_to = '3' WHERE skill_id = 216;

-- Panic 217

-- Skill:Panic-217 type changed from 4 
UPDATE skills SET type = '2' WHERE skill_id = 217;

-- JoyofPain 218

-- Skill:JoyofPain-218 target changed from buff 
UPDATE skills SET target = 'attack' WHERE skill_id = 218;

-- fix strikers gale learning
UPDATE skills SET name='Strikers Gale' where skill_id=174;

