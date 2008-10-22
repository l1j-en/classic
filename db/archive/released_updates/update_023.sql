-- update 23

-- swap beagle and fox skills
-- stalac for beagle, high beagle
update mobskill set skillid = 16 where mobid in (45046, 45692);
-- fire arrow for fox, high fox
update mobskill set skillid = 15 where mobid in (45048, 45694);
