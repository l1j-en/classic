
-- update 51

# Update misnamed item
update etcitem set name = 'Black Lump of Rough Mithril' where item_id = 40444;
update etcitem set name = 'Emerald karif Pouch' where item_id = 49005;
update etcitem set name_id = '$515 $3052' where item_id = 49005;
update etcitem set name = 'Ruby karif Pouch' where item_id = 49006;
update etcitem set name_id = '$513 $3052' where item_id = 49006;
update etcitem set name = 'Diamond karif Pouch' where item_id = 49007;
update etcitem set name_id = '$512 $3052' where item_id = 49007;
update etcitem set name = 'Sapphire karif Pouch' where item_id = 49008;
update etcitem set name_id = '$514 $3052' where item_id = 49008;
update etcitem set name = 'Emerald High Quality karif Pouch' where item_id = 49009;
update etcitem set name_id = '$515 $3184' where item_id = 49009;
update etcitem set name = 'Sapphire High Quality karif Pouch' where item_id = 49010;
update etcitem set name_id = '$514 $3184' where item_id = 49010;
update etcitem set name = 'Ruby High Quality karif Pouch' where item_id = 49012;
update etcitem set name_id = '$513 $3184' where item_id = 49012;
update etcitem set name = 'Diamond High Quality karif Pouch' where item_id = 49012;
update etcitem set name_id = '$512 $3184' where item_id = 49012;

# Change Edoryu of Rhonde to be non-damageable
update weapon set canbedmg = 0 where item_id=76;

# Added Pet Command to Gm Commands
INSERT INTO `commands` VALUES ('pet', '200', 'L1AddPet');
# Added findinvis command to Gm Commands
INSERT INTO `commands` VALUES ('findinvis', 200, 'L1FindInvis');

# Added Cant resurect to npc table
ALTER TABLE npc
ADD cant_resurrect tinyint(1) unsigned NOT NULL default 0;

# Update incorrect npc name spelling
update npc set name = 'Dark Elf Soldier' where npcid = 45830;

# Update to prevent players from resurrecting bosses
update npc set cant_resurrect = 1 where npcid = 45007; # Mambo Rabbit Blue Vest
update npc set cant_resurrect = 1 where npcid = 45034; # Shepard
update npc set cant_resurrect = 1 where npcid = 45039; # Cat
update npc set cant_resurrect = 1 where npcid = 45040; # Bear
update npc set cant_resurrect = 1 where npcid = 45042; # Doberman
update npc set cant_resurrect = 1 where npcid = 45043; # Wolf
update npc set cant_resurrect = 1 where npcid = 45044; # Raccoon
update npc set cant_resurrect = 1 where npcid = 45046; # Beagle
update npc set cant_resurrect = 1 where npcid = 45047; # Saint Bernard
update npc set cant_resurrect = 1 where npcid = 45048; # Fox
update npc set cant_resurrect = 1 where npcid = 45049; # Killer Rabbit
update npc set cant_resurrect = 1 where npcid = 45053; # Husky
update npc set cant_resurrect = 1 where npcid = 45054; # Collie
update npc set cant_resurrect = 1 where npcid = 45110; # Lesser Succubus Queen
update npc set cant_resurrect = 1 where npcid = 45112; # Cursed Ettin
update npc set cant_resurrect = 1 where npcid = 45271; # Greater Dark Elemental
update npc set cant_resurrect = 1 where npcid = 45300; # Ancient Apparition
update npc set cant_resurrect = 1 where npcid = 45301; # Sin of Sepia
update npc set cant_resurrect = 1 where npcid = 45302; # Giant Guardian
update npc set cant_resurrect = 1 where npcid = 45303; # Spirit of Fire
update npc set cant_resurrect = 1 where npcid = 45304; # Spirit of Water
update npc set cant_resurrect = 1 where npcid = 45305; # Spirit of Wind
update npc set cant_resurrect = 1 where npcid = 45306; # Spirit of Earth
update npc set cant_resurrect = 1 where npcid = 45310; # Summon Elemental
update npc set cant_resurrect = 1 where npcid = 45313; # Tiger
update npc set cant_resurrect = 1 where npcid = 45315; # Incarnation of Varlok
update npc set cant_resurrect = 1 where npcid = 45342; # Giant Mutant Ant Queen
update npc set cant_resurrect = 1 where npcid = 45343; # Darkmar
update npc set cant_resurrect = 1 where npcid = 45344; # Betrayer of Undead
update npc set cant_resurrect = 1 where npcid = 45357; # Black Tiger
update npc set cant_resurrect = 1 where npcid = 45413; # Diego
update npc set cant_resurrect = 1 where npcid = 45458; # Captain Drake
update npc set cant_resurrect = 1 where npcid = 45459; # Guardian of Earth Spirit
update npc set cant_resurrect = 1 where npcid = 45460; # Guardian of Water Spirit
update npc set cant_resurrect = 1 where npcid = 45461; # Guardian of Wind Spirit
update npc set cant_resurrect = 1 where npcid = 45462; # Guardian of Fire Spirit
update npc set cant_resurrect = 1 where npcid = 45464; # Sema
update npc set cant_resurrect = 1 where npcid = 45465; # Guardian of Darkness Spirit
update npc set cant_resurrect = 1 where npcid = 45473; # Baltuzar
update npc set cant_resurrect = 1 where npcid = 45483; # Black Tiger
update npc set cant_resurrect = 1 where npcid = 45488; # Caspa
update npc set cant_resurrect = 1 where npcid = 45492; # Kuman
update npc set cant_resurrect = 1 where npcid = 45497; # Merkyor
update npc set cant_resurrect = 1 where npcid = 45513; # Zenith Queen
update npc set cant_resurrect = 1 where npcid = 45515; # Ifrit
update npc set cant_resurrect = 1 where npcid = 45534; # Mambo Rabbit Pink Vest
update npc set cant_resurrect = 1 where npcid = 45535; # Mambo Rabbit Orange Vest
update npc set cant_resurrect = 1 where npcid = 45547; # Seer
update npc set cant_resurrect = 1 where npcid = 45548; # Jose
update npc set cant_resurrect = 1 where npcid = 45550; # Dark Elder
update npc set cant_resurrect = 1 where npcid = 45562; # Guardian Armor
update npc set cant_resurrect = 1 where npcid = 45573; # Baphomet
update npc set cant_resurrect = 1 where npcid = 45574; # Palace General Kyte
update npc set cant_resurrect = 1 where npcid = 45577; # Brigade Dark Fencer
update npc set cant_resurrect = 1 where npcid = 45583; # Beleth
update npc set cant_resurrect = 1 where npcid = 45584; # Greater Minotaur
update npc set cant_resurrect = 1 where npcid = 45585; # Squad Leader Blaze
update npc set cant_resurrect = 1 where npcid = 45588; # Division Commander Sinclair
update npc set cant_resurrect = 1 where npcid = 45590; # Reaper
update npc set cant_resurrect = 1 where npcid = 45595; # Iris
update npc set cant_resurrect = 1 where npcid = 45600; # Kurtz
update npc set cant_resurrect = 1 where npcid = 45601; # Death Knight
update npc set cant_resurrect = 1 where npcid = 45602; # Evil Magic Quad Leader Carmiel
update npc set cant_resurrect = 1 where npcid = 45603; # Large Grave Guardian
update npc set cant_resurrect = 1 where npcid = 45604; # Marquise Vampire
update npc set cant_resurrect = 1 where npcid = 45606; # Vampire
update npc set cant_resurrect = 1 where npcid = 45607; # Evil Power Quad Leader Kybar
update npc set cant_resurrect = 1 where npcid = 45608; # Mercenary Commander Mephaisto
update npc set cant_resurrect = 1 where npcid = 45609; # Ice Queen
update npc set cant_resurrect = 1 where npcid = 45610; # Ancient Giant
update npc set cant_resurrect = 1 where npcid = 45611; # Incarnation of Varlok
update npc set cant_resurrect = 1 where npcid = 45612; # Temple Head Bounty
update npc set cant_resurrect = 1 where npcid = 45613; # Varlok
update npc set cant_resurrect = 1 where npcid = 45614; # Giant Ant Queen
update npc set cant_resurrect = 1 where npcid = 45615; # Bright Magic Troup Leader Crepus
update npc set cant_resurrect = 1 where npcid = 45616; # Mummy Lord
update npc set cant_resurrect = 1 where npcid = 45617; # Phoenix
update npc set cant_resurrect = 1 where npcid = 45618; # Knight Vald
update npc set cant_resurrect = 1 where npcid = 45619; # Great Spirit of Earth
update npc set cant_resurrect = 1 where npcid = 45620; # Great Spirit of Water
update npc set cant_resurrect = 1 where npcid = 45621; # Great Spirit of Wind
update npc set cant_resurrect = 1 where npcid = 45622; # Great Spirit of Fire
update npc set cant_resurrect = 1 where npcid = 45625; # Chaos
update npc set cant_resurrect = 1 where npcid = 45640; # Unicorn
update npc set cant_resurrect = 1 where npcid = 45641; # Nightmare
update npc set cant_resurrect = 1 where npcid = 45642; # Great Spirit of Earth
update npc set cant_resurrect = 1 where npcid = 45643; # Great Spirit of Water
update npc set cant_resurrect = 1 where npcid = 45644; # Great Spirit of Wind
update npc set cant_resurrect = 1 where npcid = 45645; # Great Spirit of Fire
update npc set cant_resurrect = 1 where npcid = 45646; # Abyss Master
update npc set cant_resurrect = 1 where npcid = 45649; # Demon
update npc set cant_resurrect = 1 where npcid = 45650; # Zombie Lord
update npc set cant_resurrect = 1 where npcid = 45651; # Dread King Baranka
update npc set cant_resurrect = 1 where npcid = 45652; # Cougar
update npc set cant_resurrect = 1 where npcid = 45653; # Mummy Lord
update npc set cant_resurrect = 1 where npcid = 45654; # Iris
update npc set cant_resurrect = 1 where npcid = 45664; # Knight Vald
update npc set cant_resurrect = 1 where npcid = 45665; # Baras
update npc set cant_resurrect = 1 where npcid = 45666; # Teranus
update npc set cant_resurrect = 1 where npcid = 45667; # Kunos
update npc set cant_resurrect = 1 where npcid = 45668; # Zyrus
update npc set cant_resurrect = 1 where npcid = 45671; # Ariorc
update npc set cant_resurrect = 1 where npcid = 45672; # Lich
update npc set cant_resurrect = 1 where npcid = 45673; # Grim Reaper
update npc set cant_resurrect = 1 where npcid = 45674; # Death
update npc set cant_resurrect = 1 where npcid = 45675; # Yahee
update npc set cant_resurrect = 1 where npcid = 45676; # Bright Magic King Hellvine
update npc set cant_resurrect = 1 where npcid = 45677; # Dread Queen Laia
update npc set cant_resurrect = 1 where npcid = 45678; # Cerenis
update npc set cant_resurrect = 1 where npcid = 45680; # Ken Rauhel
update npc set cant_resurrect = 1 where npcid = 45681; # Lindvior
update npc set cant_resurrect = 1 where npcid = 45682; # Antharas
update npc set cant_resurrect = 1 where npcid = 45683; # Fafurion
update npc set cant_resurrect = 1 where npcid = 45684; # Valakas
update npc set cant_resurrect = 1 where npcid = 45685; # Tarak
update npc set cant_resurrect = 1 where npcid = 45686; # High Wolf
update npc set cant_resurrect = 1 where npcid = 45687; # High Shepard
update npc set cant_resurrect = 1 where npcid = 45688; # High Doberman
update npc set cant_resurrect = 1 where npcid = 45689; # High Husky
update npc set cant_resurrect = 1 where npcid = 45690; # High Bear
update npc set cant_resurrect = 1 where npcid = 45691; # High Collie
update npc set cant_resurrect = 1 where npcid = 45692; # High Beagle
update npc set cant_resurrect = 1 where npcid = 45693; # High St. Bernard
update npc set cant_resurrect = 1 where npcid = 45694; # High Fox
update npc set cant_resurrect = 1 where npcid = 45695; # High Rabbit
update npc set cant_resurrect = 1 where npcid = 45696; # High Cat
update npc set cant_resurrect = 1 where npcid = 45697; # High Raccoon
update npc set cant_resurrect = 1 where npcid = 45710; # Battle Tiger
update npc set cant_resurrect = 1 where npcid = 45711; # Jindo Puppy
update npc set cant_resurrect = 1 where npcid = 45712; # Jindo Dog
update npc set cant_resurrect = 1 where npcid = 45734; # Giant King Squid
update npc set cant_resurrect = 1 where npcid = 45735; # Chief Mermaid
update npc set cant_resurrect = 1 where npcid = 45752; # Varlok
update npc set cant_resurrect = 1 where npcid = 45753; # Varlok
update npc set cant_resurrect = 1 where npcid = 45782; # Polluted Great Spirit's Dirty Sycophant
update npc set cant_resurrect = 1 where npcid = 45783; # Polluted Great Spirit of Darkness
update npc set cant_resurrect = 1 where npcid = 45784; # Polluted Great Spirit of Light
update npc set cant_resurrect = 1 where npcid = 45785; # Polluted Great Spirit of Earth
update npc set cant_resurrect = 1 where npcid = 45786; # Polluted Great Spirit of Fire
update npc set cant_resurrect = 1 where npcid = 45787; # Polluted Great Spirit of Wind
update npc set cant_resurrect = 1 where npcid = 45788; # Polluted Great Spirit of Water
update npc set cant_resurrect = 1 where npcid = 45794; # Servant of Spirit
update npc set cant_resurrect = 1 where npcid = 45795; # Spirit
update npc set cant_resurrect = 1 where npcid = 45801; # Diamond Golem of Maino Shaman
update npc set cant_resurrect = 1 where npcid = 45802; # Maino Shaman
update npc set cant_resurrect = 1 where npcid = 45828; # Doppleganger Boss
update npc set cant_resurrect = 1 where npcid = 45829; # Barbados
update npc set cant_resurrect = 1 where npcid = 45836; # Black Tiger
update npc set cant_resurrect = 1 where npcid = 45844; # Dread King Baranka
update npc set cant_resurrect = 1 where npcid = 45854; # Guardian of Earth Spirit
update npc set cant_resurrect = 1 where npcid = 45855; # Guardian of Water Spirit
update npc set cant_resurrect = 1 where npcid = 45856; # Guardian of Wind Spirit
update npc set cant_resurrect = 1 where npcid = 45857; # Guardian of Fire Spirit
update npc set cant_resurrect = 1 where npcid = 45858; # Guardian of Darkness Spirit
update npc set cant_resurrect = 1 where npcid = 45863; # Dread Queen Laia
update npc set cant_resurrect = 1 where npcid = 45878; # Spirit of Drake
update npc set cant_resurrect = 1 where npcid = 45910; # Greater Dark Elemental
update npc set cant_resurrect = 1 where npcid = 45916; # General Hamel Full of Resentment
update npc set cant_resurrect = 1 where npcid = 45923; # Evil Spirit of Heine
update npc set cant_resurrect = 1 where npcid = 45931; # Spirit of Water
update npc set cant_resurrect = 1 where npcid = 45943; # Kapu
update npc set cant_resurrect = 1 where npcid = 45944; # Giant Worm
update npc set cant_resurrect = 1 where npcid = 45952; # Giant Guarding Ant
update npc set cant_resurrect = 1 where npcid = 45955; # Supreme Court Justice Kenya
update npc set cant_resurrect = 1 where npcid = 45956; # Supreme Court Justice Viatas
update npc set cant_resurrect = 1 where npcid = 45957; # Supreme Court Justice Baromes
update npc set cant_resurrect = 1 where npcid = 45958; # Supreme Court Justice Endias
update npc set cant_resurrect = 1 where npcid = 45959; # Supreme Court Justice Edea
update npc set cant_resurrect = 1 where npcid = 45960; # Supreme Court Justice Tiames
update npc set cant_resurrect = 1 where npcid = 45961; # Supreme Court Justice Ramias
update npc set cant_resurrect = 1 where npcid = 45962; # Supreme Court Justice Barode
update npc set cant_resurrect = 1 where npcid = 45963; # New King Adjutant Cassandra
update npc set cant_resurrect = 1 where npcid = 45983; # Guardian of Earth Spirit
update npc set cant_resurrect = 1 where npcid = 45984; # Guardian of Water Spirit
update npc set cant_resurrect = 1 where npcid = 45985; # Guardian of Fire Spirit
update npc set cant_resurrect = 1 where npcid = 45986; # Guardian of Wind Spirit
update npc set cant_resurrect = 1 where npcid = 45987; # Guardian of Darkness Spirit
update npc set cant_resurrect = 1 where npcid = 45988; # Greater Dark Elemental
update npc set cant_resurrect = 1 where npcid = 46013; # Royal Guard Head Shaibbulit
update npc set cant_resurrect = 1 where npcid = 46024; # Count Elite Guard General
update npc set cant_resurrect = 1 where npcid = 46025; # Count Taros
update npc set cant_resurrect = 1 where npcid = 46026; # Mammon
update npc set cant_resurrect = 1 where npcid = 46035; # Corrupt Zombie Lord
update npc set cant_resurrect = 1 where npcid = 46036; # Corrupt Skeleton Knight
update npc set cant_resurrect = 1 where npcid = 46037; # Dark Wizard Maya
update npc set cant_resurrect = 1 where npcid = 46042; # Baby Kangaroo
update npc set cant_resurrect = 1 where npcid = 46043; # Kangaroo of Fire
update npc set cant_resurrect = 1 where npcid = 46044; # Baby Panda
update npc set cant_resurrect = 1 where npcid = 46045; # Horrific Panda
update npc set cant_resurrect = 1 where npcid = 46046; # Gold Dragon
update npc set cant_resurrect = 1 where npcid = 46053; # Evil Spirit of Ship

