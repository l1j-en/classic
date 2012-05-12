-- Westknights has a number of secret db changes (a couple of added drops); this
-- is for public tweaks that other servers might want.

-- skill durations
update skills set stack_limit=6 where name="HolyWalk";

-- skill targets
update skills set target_to=24 where name="NaturesBlessing";
update skills set target_to=12 where name="Brave Aura" or name="Shining Aura" or name="Glowing Aura";

-- item stacking
update etcitem set stackable=1 where name like "%dragon tablet%";
update etcitem set stackable=1 where name like "%memory crystal%"; 
update etcitem set stackable=1 where name="Crystal Ball of Necromancer";
update etcitem set stackable=1 where item_id=41243 or item_id=41244; -- lasta boxes
