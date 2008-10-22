-- update 19.1

-- cleanup invalid droplist items
delete from droplist where mobid = 45772 and itemid = 141087;
delete from droplist where mobid = 45772 and itemid = 141074;
delete from droplist where mobid = 45795 and itemid = 141087;
delete from droplist where mobid = 45795 and itemid = 141074;
delete from droplist where mobid = 45273 and itemid = 85000;
