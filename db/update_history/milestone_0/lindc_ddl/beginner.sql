-- update 22

alter table beginner add column identified int(1) default 0;



-- update 23

-- Make beginner table in line with charcter_items table
ALTER TABLE beginner CHANGE COLUMN identified is_id  int(1) default 0;