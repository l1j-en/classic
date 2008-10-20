-- update 9

-- fix infinite money exploit for bp return scrolls
delete from shop where purchasing_price = 210;
