-- update 25

-- update board_auction house_name and location fields
update board_auction ba set 
ba.house_name = (select h.house_name from house h where h.house_id = ba.house_id), 
ba.location = (select h.location from house h where h.house_id = ba.house_id);