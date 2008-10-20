-- update 32

-- the missing vegetations allready in the source implented
UPDATE etcitem SET itemdesc_id='2592' WHERE item_id ='41337'; 
UPDATE etcitem SET itemdesc_id='2593' WHERE item_id ='41338'; 

INSERT INTO `etcitem` VALUES ('41411', '', '$3025', 'potion', 'normal', 'vegetation', '0', '1396', '3461', '1101', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0'); 
INSERT INTO `etcitem` VALUES ('41412', '', '$3026', 'potion', 'normal', 'vegetation', '0', '1397', '3462', '1102', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0'); 
INSERT INTO `etcitem` VALUES ('41413', '', '$2580', 'potion', 'normal', 'vegetation', '6000', '1159', '3039', '920', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0'); 
INSERT INTO `etcitem` VALUES ('41414', '', '$2581', 'potion', 'normal', 'vegetation', '12000', '1160', '3040', '921', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0'); 
INSERT INTO `etcitem` VALUES ('41415', '', '$4913', 'potion', 'normal', 'glass', '9400', '2464', '5959', '296', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0'); 

-- food volume fix
UPDATE etcitem SET item_type='other',use_type='normal' WHERE item_id ='40070'; 
UPDATE etcitem SET food_volume='200' WHERE item_id ='41252'; 
UPDATE etcitem SET food_volume='80' WHERE item_id ='41266'; 
UPDATE etcitem SET food_volume='80' WHERE item_id ='41267'; 
UPDATE etcitem SET food_volume='100' WHERE item_id ='41274'; 
UPDATE etcitem SET food_volume='100' WHERE item_id ='41275'; 
UPDATE etcitem SET food_volume='100' WHERE item_id ='41276';

-- fixing some typos and spelling errors I noticed, using to get a feel
-- for how to use svn. Let me know if this is ok. - Tricid
update etcitem set name = 'Black Mithril Arrow' where item_id = 40747;
update etcitem set name = 'Black Lump of Pure Mithril' where item_id = 40443;

-- item gfxs fixes and weight and trade able
UPDATE`armor`SET`grdgfx`='6098' WHERE `item_id` ='20383'; 
UPDATE`armor`SET`grdgfx`='5964' WHERE `item_id` ='20419'; 
UPDATE`weapon`SET`add_hpr`='-30' WHERE `item_id` ='195'; 
UPDATE`etcitem`SET`grdgfx`='2475' WHERE `item_id` ='40726'; 
UPDATE`etcitem`SET`grdgfx`='2476' WHERE `item_id` ='40721'; 
UPDATE`etcitem`SET`grdgfx`='4377' WHERE `item_id` ='40623'; 
UPDATE`etcitem`SET`grdgfx`='4379' WHERE `item_id` ='40624'; 
UPDATE`etcitem`SET`grdgfx`='4381' WHERE `item_id` ='40625'; 
UPDATE`etcitem`SET`grdgfx`='4383' WHERE `item_id` ='40626'; 
UPDATE`etcitem`SET`grdgfx`='4385' WHERE `item_id` ='40627'; 
UPDATE`etcitem`SET`grdgfx`='4387' WHERE `item_id` ='40628'; 
UPDATE`etcitem`SET`grdgfx`='4389' WHERE `item_id` ='40629'; 
UPDATE`etcitem`SET`use_type`='normal' WHERE `item_id` ='41160'; 
UPDATE`shop`SET`pack_count`='1' WHERE `npc_id` ='70005' and `item_id` ='4'; 
UPDATE`etcitem`SET`trade`='1' WHERE `item_id` ='40733'; 
UPDATE`etcitem`SET`trade`='1' WHERE `item_id` ='40734'; 
UPDATE`etcitem`SET`trade`='1' WHERE `item_id` ='40735'; 
UPDATE`etcitem`SET`trade`='1' WHERE `item_id` ='40736'; 
UPDATE`etcitem`SET`trade`='1' WHERE `item_id` ='40641'; 
UPDATE`etcitem`SET`trade`='1' WHERE `item_id` ='41159'; 
UPDATE`etcitem`SET`locx`='32867',`locy`='32510' WHERE `item_id` ='40114'; 
UPDATE`etcitem`SET`locx`='32752',`locy`='32441' WHERE `item_id` ='40125'; 
UPDATE`etcitem`SET`locx`='32617',`locy`='33201' WHERE `item_id` ='40115'; 
UPDATE`etcitem`SET`locx`='33614',`locy`='33253' WHERE `item_id` ='40123'; 
UPDATE`etcitem`SET`locx`='32851',`locy`='32904' WHERE `item_id` ='40845'; 
UPDATE`etcitem`SET`item_type`='other',`material`='glass' WHERE `item_id` ='43000'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40623'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40624'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40625'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40626'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40627'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40628'; 
UPDATE`etcitem`SET`weight`='1000' WHERE `item_id` ='40629'; 
UPDATE`etcitem`SET`invgfx`='1786',`grdgfx`='4377' WHERE `item_id` ='40666'; 
UPDATE`armor`SET`weight`='10000',`use_royal`='0',`use_knight`='0',`use_mage`='0',`use_elf`='0' WHERE `item_id` ='20037'; 
UPDATE`etcitem`SET`use_type`='none' WHERE `item_id` ='40602'; 
UPDATE`droplist`SET`min`='30',`max`='100' WHERE `itemId` ='40742'; 
UPDATE`droplist`SET`min`='10',`max`='30' WHERE `itemId` ='40743'; 
UPDATE`droplist`SET`min`='10',`max`='30' WHERE `itemId` ='40744'; 
UPDATE`droplist`SET`min`='30',`max`='100' WHERE `itemId` ='40746'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='231'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='232'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='233'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='234'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='235'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='236'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='237'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='238'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='239'; 
UPDATE`weapon`SET`trade`='1' WHERE `item_id` ='240'; 
UPDATE`etcitem`SET`itemdesc_id`='17' WHERE `item_id` ='40013'; 
UPDATE`etcitem`SET`itemdesc_id`='17' WHERE `item_id` ='40018'; 
UPDATE`etcitem`SET`itemdesc_id`='1343' WHERE `item_id` ='40030'; 
UPDATE armor SET use_royal="0", use_mage="0", use_elf="0", use_darkelf="0" WHERE item_id="20026";
UPDATE etcitem SET stackable="0" WHERE item_id="40300";

-- sosc type set on item 40410
UPDATE`etcitem`SET`use_type`='sosc' WHERE `item_id` ='40410'; 

-- id fixes in etcitem to match the new quest and talk stuff
UPDATE etcitem SET itemdesc_id='2659' WHERE item_id ='41315'; 
UPDATE etcitem SET itemdesc_id='2670' WHERE item_id ='41316'; 
UPDATE etcitem SET itemdesc_id='2474' WHERE item_id ='41354'; 