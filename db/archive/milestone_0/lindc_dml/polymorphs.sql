-- update 13

-- remove weaponequip on baranka morph (192 -> 0)
update polymorphs set weaponequip = 0 where id = 3664;



-- update 24

-- disable 55+ DE polys (reenable these after ep6/u merge)
-- ancient black assassin morph (polyid: 5727)
update polymorphs set minlevel = 99 where id = 5727;
-- ancient silver assassin morph (polyid: 5730)
update polymorphs set minlevel = 99 where id = 5730;
-- ancient gold assassin morph (polyid: 5733)
update polymorphs set minlevel = 99 where id = 5733;
-- ancient platinum assassin morph (polyid: 5736)
update polymorphs set minlevel = 99 where id = 5736;

-- disable red orc poly (crashes ep5 clients)
update polymorphs set minlevel = 99 where id = 6010;



-- update 25

-- reactivate 65+ DE morphs
-- ancient gold assassin morph (polyid: 5733)
update polymorphs set minlevel = 65 where id = 5733;
-- ancient platinum assassin morph (polyid: 5736)
update polymorphs set minlevel = 70 where id = 5736;