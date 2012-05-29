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

-- dk/kurtz sets usable by all
-- if you had early custom armor then use
-- update armor set use_dragonknight=1, use_illusionist=1, use_darkelf=1, use_mage=1, use_elf=1, use_knight=1, use_royal=1 where name like "%kurtz%" or name like "%death knight%";
update armor set use_dragonknight=1, use_illusionist=1, use_darkelf=1, use_mage=1, use_elf=1, use_knight=1, use_royal=1 where item_id=20010 or item_id=20041 or item_id=20100 or item_id=20150 or item_id=20166 or item_id=20184 or item_id=20198 or item_id=20214;
