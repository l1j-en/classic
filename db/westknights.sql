-- Westknights has a number of secret db changes (a couple of added drops); this
-- is for public tweaks that other servers might want.

update skills set stack_limit=6 where name="HolyWalk";

update skills set target_to=24 where name="NaturesBlessing";
update skills set target_to=12 where name="Brave Aura" or name="Shining Aura" or name="Glowing Aura";
