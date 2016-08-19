-- Make "Amulet of Suffering" and "Amulet of Anguish" High Grade enchantable.
update armor set grade = 0 where item_id in (20411, 20412);
