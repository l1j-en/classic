-- update 15 

-- fix rk shield ac (-2 -> -3)
update armor set ac = -3 where item_id = 20230;

-- reduce beast summoner mobskill leverage (30 -> 12)
update mobskill set leverage = 12 where mobid = 45368 and actno = 0;

-- slightly increase black wizard mobskill leverage (5 -> 7)
update mobskill set leverage = 7 where mobid = 45405 and actno = 0;

-- reduce dark forester magic skill damage_value (50 -> 30)
update skills set damage_value = 30 where skill_id = 10043;

-- fix name for Old Belt of Soul (was Old Belt of Mind)
update armor set name = 'Old Belt of Soul' where item_id = 20307;

-- fix name for Old Belt of Mind (was Old Belt of Soul)
update armor set name = 'Old Belt of Mind' where item_id = 20308;

-- increase sb:gres droprate from medusa
update droplist set chance = 5000 where mobid = 45380 and itemid = 40220;
