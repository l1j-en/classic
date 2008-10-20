-- update 17

-- remove invalid drop from ghost
delete from droplist where mobid = 45198 and itemid = 45174;

-- correct glowing aura mp cost (40 -> 30)
update skills set mpconsume = 30 where skill_id = 114;

-- increase undead key droprate from lvl 30 mage quest mop (50000 -> 250000)
update droplist set chance = 250000 where itemid = 40581 and mobid = 45100;

-- correct name of Totem of Rova (was Totem of Neruga)
update etcitem set name = 'Totem of Rova' where item_id = 40132;

-- decrease bone dragon skill leverage (15 -> 3)
update mobskill set leverage = 3 where mobid = 45522 and actno = 0;

-- correct name of Ivory Tower Scroll of Identify (was Scroll of Identify)
update etcitem set name = 'Tower Scroll of Identify' where item_id = 40098;

-- correct id scroll drops from dancing sword (was IT id scroll)
update droplist set itemid = 40126 where mobid = 45386 and itemid = 40098;

-- decrease damage from phoenix ranged attack, but increase range
update mobskill set leverage = 10, trirange = -8  where mobid = 45617 and actno = 0;

-- modify existing seer drops
-- increase tsu droprate from seer (5000 -> 5500)
update droplist set chance = 5500 where itemid = 57 and mobid = 45547;
-- increase tqd droprate from seer (8000 -> 1000)
update droplist set chance = 10000 where itemid = 40052 and mobid = 45547;

-- modify existing vampire drops
-- increase silver cloak droprate from vampire (1000 -> 5000)
update droplist set chance = 5000 where itemid = 20074 and mobid = 45606;
-- increase sof droprate from vampire (5000 -> 10000)
update droplist set chance = 10000 where itemid = 131 and mobid = 45606;
-- increase tsu droprate from vampire (5000 -> 5500)
update droplist set chance = 5500 where itemid = 57 and mobid = 45606;

-- modify existing zombie lord drops
-- increase tsu droprate from zombie lord (5000 -> 6500)
update droplist set chance = 6500 where itemid = 57 and mobid = 45650;
-- increase k-edo droprate from zombie lord (500 -> 1200)
update droplist set chance = 1200 where itemid = 84 and mobid = 45650;

-- modify existing cougar drops
-- increase nkat droprate from cougar (50000 -> 150000)
update droplist set chance = 150000 where itemid = 41 and mobid = 45652;
-- increase tsu droprate from cougar (2000 -> 7500)
update droplist set chance = 7500 where itemid = 57 and mobid = 45652;

-- modify existing mummy lord drops
-- increase helm of mummy lord droprate from mummy lord (500 -> 750)
update droplist set chance = 750 where itemid = 20017 and mobid = 45652;
-- increase roe droprate from mummy lord (4500 -> 9500)
update droplist set chance = 9500 where itemid = 20300 and mobid = 45652;
-- increase row, roa, rof droprate from mummy lord (1000 -> 3000)
update droplist set chance = 3000 where itemid in (20285, 20302, 20304) and mobid = 45652;
-- increase sb:decay pot droprate from mummy lord (1000 -> 2500)
update droplist set chance = 2500 where itemid = 40216 and mobid = 45652;
-- increase tsu droprate from mummy lord (2000 -> 6500)
update droplist set chance = 6500 where itemid = 57 and mobid = 45652;

-- modify existing iris drops
-- increase row, rof droprate from iris (1500 -> 2500)
update droplist set chance = 2500 where itemid in (20285, 20304) and mobid = 45654;
-- increase roe, roa droprate from iris (3000 -> 5000)
update droplist set chance = 5000 where itemid in (20300, 20302) and mobid = 45654;
-- increase pg droprate from iris (15000 -> 16000)
update droplist set chance = 16000 where itemid = 20187 and mobid = 45654;
-- increase dice dagger droprate from iris (50000 -> 300000)
update droplist set chance = 300000 where itemid = 2 and mobid = 45654;
-- increase nkat droprate from iris (50000 -> 150000)
update droplist set chance = 150000 where itemid = 41 and mobid = 45654;
-- increase tsu droprate from iris (2000 -> 7500)
update droplist set chance = 7500 where itemid = 57 and mobid = 45654;

-- modify existing knight vald drops
-- increase pg droprate from knight vald (10000 -> 12000)
update droplist set chance = 12000 where itemid = 20187 and mobid = 45618;
-- increase tsu droprate from knight vald (5000 -> 7500)
update droplist set chance = 7500 where itemid = 57 and mobid = 45618;
-- increase kv sword droprate from knight vald (100 -> 600)
update droplist set chance = 800 where itemid = 59 and mobid = 45618;

-- modify existing lich drops
-- increase silver cloak droprate from lich (2500 -> 10000)
update droplist set chance = 10000 where itemid = 20074 and mobid = 45672;
-- increase bzel droprate from lich (50000 -> 500000)
update droplist set chance = 500000 where itemid = 140074 and mobid = 45672;
-- increase bdai droprate from lich (25000 -> 300000)
update droplist set chance = 300000 where itemid = 140087 and mobid = 45672;
-- increase sb:destroy droprate from lich (2000 -> 5000)
update droplist set chance = 5000 where itemid = 40222 and mobid = 45672;
-- increase sb:ab droprate from lich (20000 -> 5000)
update droplist set chance = 5000 where itemid = 40223 and mobid = 45672;
-- increase bkat droprate from lich (50000 -> 150000)
update droplist set chance = 150000 where itemid = 100041 and mobid = 45672;
-- increase tsu droprate from lich (5000 -> 7000)
update droplist set chance = 7000 where itemid = 57 and mobid = 45672;

-- modify sb:hw to drake droplist chance
update droplist set chance = 5000 where mobid = 45529;
