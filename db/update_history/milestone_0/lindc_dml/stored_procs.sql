-- create stored procedures (use `call' to execute)


-- list all stored procs
drop procedure if exists dc_CheckStoredProcs;
DELIMITER //
create procedure dc_CheckStoredProcs ()
BEGIN
        SELECT routine_name, routine_type, definer, routine_definition
        FROM   information_schema.routines
        WHERE routine_schema LIKE 'l1j_new';
END;
//
DELIMITER ;

-- check online chars/accts
drop procedure if exists dc_CheckAccounts;
DELIMITER //
create procedure dc_CheckAccounts ()
BEGIN
  select char_name, account_name from characters where onlinestatus = 1;
END;
//
DELIMITER ;


-- full carried items audit
drop procedure if exists dc_CheckItemsAllChars;
DELIMITER //
create procedure dc_CheckItemsAllChars ()
BEGIN
  select c.char_name, ci.item_name, ci.item_id, ci.enchantlvl, ci.count from characters c,

character_items ci where c.objid = ci.char_id and c.isgm = 0 order by c.char_name;

END;
//
DELIMITER ;


-- carried items audit per character
drop procedure if exists dc_CheckItemsChar;
DELIMITER //
create procedure dc_CheckItemsChar ( IN CharName VARCHAR(64) CHARACTER SET utf8 )
BEGIN
  select c.char_name, ci.item_name, ci.item_id, ci.enchantlvl, ci.count from characters c,

character_items ci where c.objid = ci.char_id and c.char_name = CharName;

END;
//
DELIMITER ;

-- list of mops and chances for item drop by itemid
drop procedure if exists dc_CheckDropMops;
DELIMITER //
create procedure dc_CheckDropMops ( IN ItemID INT )
BEGIN
  select n.name, n.npcid, d.chance from npc n, droplist d where n.npcid = d.mobid and

d.itemid = ItemID;

END;
//
DELIMITER ;

-- list of drops and chances for mob by npcid
drop procedure if exists dc_CheckMopDrops;
DELIMITER //
create procedure dc_CheckMopDrops ( IN NpcID INT )
BEGIN
        select  n.name, a.name, a.item_id, d.chance
        from npc n, droplist d, armor a
        where n.npcid = d.mobid and a.item_id = d.itemid and n.npcid = NpcID;
        select  n.name, i.name, i.item_id, d.chance
        from npc n, droplist d, etcitem i
        where n.npcid = d.mobid and i.item_id = d.itemid and n.npcid = NpcID;
        select  n.name, w.name, w.item_id, d.chance
        from npc n, droplist d, weapon w
        where n.npcid = d.mobid and w.item_id = d.itemid and n.npcid = NpcID;
END;
//
DELIMITER ;


-- unstuck a character by name (moves them to lower SKT)
drop procedure if exists dc_SetUnstuckChar;
DELIMITER //
create procedure dc_SetUnstuckChar ( IN CharName VARCHAR(64) CHARACTER SET utf8 )
BEGIN
  update characters set LocX = 33080, LocY = 33395, mapid = 4 where char_name = CharName;

END;
//
DELIMITER ;

-- rename a character
drop procedure if exists dc_SetCharRename;
DELIMITER //
create procedure dc_SetCharRename (
        IN OldCharName VARCHAR(64) CHARACTER SET utf8,
        IN NewCharName VARCHAR(64) CHARACTER SET utf8 )
BEGIN

END;
//
DELIMITER ;
