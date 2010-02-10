
-- update 53

# Zylia
# Update Dungeon table note references

update dungeon set note = 'PI Dungeon 1F -> PI Dungeon Entry North' where src_y = 32737 and src_mapid = 441;
update dungeon set note = 'PI Dungeon 1F -> PI Dungeon Entry South' where src_y = 32861 and src_mapid = 441;

# Correct invalid spawn locations for Kuman
delete from spawnlist_boss where id = 18;
insert into spawnlist_boss values(18,'Kuman','etc1',1,45492,49,32767,32899,0,0,32673,32861,32834,32970,0,480,0,0,0,0,100);

# Correct class usage for Amulet of Eris
delete from armor where item_id = 20421;
insert into armor values (20421,'Amulet of Eris','$4341','amulet','gemstone',5000,2172,5314,2053,0,-1,1,1,1,1,1,1,0,1,0,0,-1,0,0,0,0,0,45,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0);

# Update droplist reference notes
update droplist set mob_name = 'Frog' where mobid = 45005;
update droplist set mob_name = 'Sea Anemone' where mobid = 45006;
update droplist set mob_name = 'Mambo Rabbit Blue Vest' where mobid = 45007;
update droplist set mob_name = 'Goblin' where mobid = 45008;
update droplist set mob_name = 'Orc' where mobid = 45009;
update droplist set mob_name = 'Rabbit' where mobid = 45010;
update droplist set mob_name = 'Rabbit' where mobid = 45012;
update droplist set mob_name = 'Kobold' where mobid = 45016;
update droplist set mob_name = 'Orc' where mobid = 45017;
update droplist set mob_name = 'Orc' where mobid = 45018;
update droplist set mob_name = 'Orc Archer' where mobid = 45019;
update droplist set mob_name = 'Monster Mushroom' where mobid = 45020;
update droplist set mob_name = 'Deer' where mobid = 45021;
update droplist set mob_name = 'Wild Boar' where mobid = 45023;
update droplist set mob_name = 'Werewolf' where mobid = 45024;
update droplist set mob_name = 'Gremlin' where mobid = 45025;
update droplist set mob_name = 'Mutated Alligator' where mobid = 45026;
update droplist set mob_name = 'Eidlon' where mobid = 45027;
update droplist set mob_name = 'Polluted Orc Zombie' where mobid = 45028;
update droplist set mob_name = 'Fungus' where mobid = 45029;
update droplist set mob_name = 'Fungus' where mobid = 45030;
update droplist set mob_name = 'Blob' where mobid = 45032;
update droplist set mob_name = 'Imp' where mobid = 45033;
update droplist set mob_name = 'Shepard' where mobid = 45034;
update droplist set mob_name = 'Escaped Black Knight' where mobid = 45035;
update droplist set mob_name = 'Valley Bear' where mobid = 45036;
update droplist set mob_name = 'Valley Lycanthrope' where mobid = 45037;
update droplist set mob_name = 'Valley Arachnevil' where mobid = 45038;
update droplist set mob_name = 'Cat' where mobid = 45039;
update droplist set mob_name = 'Bear' where mobid = 45040;
update droplist set mob_name = 'Dwarf' where mobid = 45041;
update droplist set mob_name = 'Doberman' where mobid = 45042;
update droplist set mob_name = 'Wolf' where mobid = 45043;
update droplist set mob_name = 'Raccoon' where mobid = 45044;
update droplist set mob_name = 'Beagle' where mobid = 45046;
update droplist set mob_name = 'Saint Bernard' where mobid = 45047;
update droplist set mob_name = 'Fox' where mobid = 45048;
update droplist set mob_name = 'Killer Rabbit' where mobid = 45049;
update droplist set mob_name = 'Orc Archer' where mobid = 45050;
update droplist set mob_name = 'Imp' where mobid = 45051;
update droplist set mob_name = 'Fatigued Ratman' where mobid = 45052;
update droplist set mob_name = 'Husky' where mobid = 45053;
update droplist set mob_name = 'Collie' where mobid = 45054;
update droplist set mob_name = 'Valley Owlbear' where mobid = 45056;
update droplist set mob_name = 'Mutated Lizardman' where mobid = 45057;
update droplist set mob_name = 'Wild Boar' where mobid = 45058;
update droplist set mob_name = 'Giant Spider' where mobid = 45059;
update droplist set mob_name = 'Rotting Skeleton Guard' where mobid = 45062;
update droplist set mob_name = 'Rotting Skeleton Marksman' where mobid = 45063;
update droplist set mob_name = 'Imp Elder' where mobid = 45064;
update droplist set mob_name = 'Zombie' where mobid = 45065;
update droplist set mob_name = 'Zombie' where mobid = 45066;
update droplist set mob_name = 'Valley Harpy' where mobid = 45067;
update droplist set mob_name = 'Floating Eye' where mobid = 45068;
update droplist set mob_name = 'Starved Troll' where mobid = 45069;
update droplist set mob_name = 'Island Ghast' where mobid = 45071;
update droplist set mob_name = 'Sewer Vakuuk' where mobid = 45072;
update droplist set mob_name = 'Rotting Skeleton Fighter' where mobid = 45073;
update droplist set mob_name = 'Underground Ramia' where mobid = 45074;
update droplist set mob_name = 'Underground Crabman' where mobid = 45075;
update droplist set mob_name = 'Underground Ramia' where mobid = 45076;
update droplist set mob_name = 'Stingray' where mobid = 45077;
update droplist set mob_name = 'Valley Ogre' where mobid = 45078;
update droplist set mob_name = 'Gnoll' where mobid = 45079;
update droplist set mob_name = 'Island Ghast Lord' where mobid = 45081;
update droplist set mob_name = 'Orc Fighter' where mobid = 45082;
update droplist set mob_name = 'Crawling Claw' where mobid = 45083;
update droplist set mob_name = 'Crawling Claw' where mobid = 45084;
update droplist set mob_name = 'Cursed Bugbear' where mobid = 45085;
update droplist set mob_name = 'Degenerated Beholder' where mobid = 45086;
update droplist set mob_name = 'Paper Man' where mobid = 45088;
update droplist set mob_name = 'Coelecanth' where mobid = 45089;
update droplist set mob_name = 'Valley Griffon' where mobid = 45090;
update droplist set mob_name = 'Valley Basilisk' where mobid = 45091;
update droplist set mob_name = 'Dwarf Warrior' where mobid = 45092;
update droplist set mob_name = 'Werewolf' where mobid = 45093;
update droplist set mob_name = 'Werewolf' where mobid = 45094;
update droplist set mob_name = 'Island Cockatrice' where mobid = 45095;
update droplist set mob_name = 'Island Crocadile' where mobid = 45096;
update droplist set mob_name = 'Acaleph' where mobid = 45097;
update droplist set mob_name = 'Gandi Orc' where mobid = 45098;
update droplist set mob_name = 'Betrayer\'s Skeleton Guardsman' where mobid = 45100;
update droplist set mob_name = 'Alligator' where mobid = 45101;
update droplist set mob_name = 'Maid of the Ice queen' where mobid = 45102;
update droplist set mob_name = 'Contaminted Fungus' where mobid = 45103;
update droplist set mob_name = 'Orc Zombie' where mobid = 45104;
update droplist set mob_name = 'Zombie' where mobid = 45105;
update droplist set mob_name = 'Skeleton' where mobid = 45107;
update droplist set mob_name = 'Skeleton' where mobid = 45108;
update droplist set mob_name = 'Orc Zombie' where mobid = 45109;
update droplist set mob_name = 'Cursed Ettin' where mobid = 45112;
update droplist set mob_name = 'Skeleton' where mobid = 45114;
update droplist set mob_name = 'Giant Ant' where mobid = 45115;
update droplist set mob_name = 'Vakuuk' where mobid = 45116;
update droplist set mob_name = 'Contaminated Orc' where mobid = 45117;
update droplist set mob_name = 'Contaminated Orc Archer' where mobid = 45118;
update droplist set mob_name = 'Orc Elder' where mobid = 45119;
update droplist set mob_name = 'Orc Fighter' where mobid = 45120;
update droplist set mob_name = 'Orc Wizard' where mobid = 45121;
update droplist set mob_name = 'Skeleton Archer' where mobid = 45122;
update droplist set mob_name = 'Skeleton Archer' where mobid = 45124;
update droplist set mob_name = 'Giran Imp' where mobid = 45125;
update droplist set mob_name = 'Stone Golem' where mobid = 45126;
update droplist set mob_name = 'Rova Orc' where mobid = 45127;
update droplist set mob_name = 'Contaminated Orc Warrior' where mobid = 45128;
update droplist set mob_name = 'Skeleton Archer' where mobid = 45129;
update droplist set mob_name = 'Skeleton Axeman' where mobid = 45130;
update droplist set mob_name = 'Skeleton Soldier' where mobid = 45131;
update droplist set mob_name = 'Snowman' where mobid = 45133;
update droplist set mob_name = 'Stone Golem' where mobid = 45134;
update droplist set mob_name = 'Betrayed Orc Archer' where mobid = 45135;
update droplist set mob_name = 'Arachnevil' where mobid = 45136;
update droplist set mob_name = 'Contaminated Cyclops' where mobid = 45137;
update droplist set mob_name = 'Orc Scout' where mobid = 45138;
update droplist set mob_name = 'Wild Venom' where mobid = 45139;
update droplist set mob_name = 'Hobgoblin' where mobid = 45140;
update droplist set mob_name = 'Mimic' where mobid = 45141;
update droplist set mob_name = 'Giran Ghast' where mobid = 45142;
update droplist set mob_name = 'Duda-Mara Orc' where mobid = 45143;
update droplist set mob_name = 'Lizardman' where mobid = 45144;
update droplist set mob_name = 'Lizardman' where mobid = 45145;
update droplist set mob_name = 'Owlbear' where mobid = 45147;
update droplist set mob_name = 'Owlbear' where mobid = 45148;
update droplist set mob_name = 'Atuba Orc' where mobid = 45149;
update droplist set mob_name = 'Contaminated Gandhi Orc' where mobid = 45150;
update droplist set mob_name = 'Contaminated Duda-Mara Orc' where mobid = 45151;
update droplist set mob_name = 'Contaminated Ent' where mobid = 45152;
update droplist set mob_name = 'Contaminated Fairy' where mobid = 45153;
update droplist set mob_name = 'Mermaid' where mobid = 45154;
update droplist set mob_name = 'Troglodyte' where mobid = 45155;
update droplist set mob_name = 'Giran Lizardman' where mobid = 45156;
update droplist set mob_name = 'Ghoul' where mobid = 45157;
update droplist set mob_name = 'Mad Lizardman' where mobid = 45158;
update droplist set mob_name = 'Merman' where mobid = 45159;
update droplist set mob_name = 'Shark' where mobid = 45160;
update droplist set mob_name = 'Spartoi' where mobid = 45161;
update droplist set mob_name = 'Silhouette' where mobid = 45162;
update droplist set mob_name = 'Wild Fang' where mobid = 45163;
update droplist set mob_name = 'Crabman' where mobid = 45164;
update droplist set mob_name = 'Black Knight' where mobid = 45165;
update droplist set mob_name = 'Jack-O-Lantern' where mobid = 45166;
update droplist set mob_name = 'Jack-O-Lantern' where mobid = 45167;
update droplist set mob_name = 'Giran Imp Elder' where mobid = 45168;
update droplist set mob_name = 'Giran Crabman' where mobid = 45169;
update droplist set mob_name = 'Giran Troglodyte' where mobid = 45170;
update droplist set mob_name = 'Neruga Orc' where mobid = 45171;
update droplist set mob_name = 'Dire Bat' where mobid = 45172;
update droplist set mob_name = 'Lycanthrope' where mobid = 45173;
update droplist set mob_name = 'Ghost - Red' where mobid = 45174;
update droplist set mob_name = 'Dark Elf Guard' where mobid = 45175;
update droplist set mob_name = 'Betrayed Orc Chief' where mobid = 45179;
update droplist set mob_name = 'Spartoi' where mobid = 45181;
update droplist set mob_name = 'Ice Golem' where mobid = 45182;
update droplist set mob_name = 'Contaminated Ogre' where mobid = 45183;
update droplist set mob_name = 'Arachnevil Elder' where mobid = 45184;
update droplist set mob_name = 'Orcish Court Guard' where mobid = 45185;
update droplist set mob_name = 'Contaminated Troll' where mobid = 45186;
update droplist set mob_name = 'Giran Vakuuk' where mobid = 45187;
update droplist set mob_name = 'Giran Ghast Lord' where mobid = 45188;
update droplist set mob_name = 'Doppleganger' where mobid = 45189;
update droplist set mob_name = 'Giant Soldier Ant' where mobid = 45190;
update droplist set mob_name = 'Ratman' where mobid = 45192;
update droplist set mob_name = 'Right-Hand Bandit' where mobid = 45194;
update droplist set mob_name = 'Aste' where mobid = 45195;
update droplist set mob_name = 'Alligator' where mobid = 45196;
update droplist set mob_name = 'Wild Magic' where mobid = 45197;
update droplist set mob_name = 'Ghost - Blue' where mobid = 45198;
update droplist set mob_name = 'Mutant Giant Soldier Ant' where mobid = 45199;
update droplist set mob_name = 'Salamander' where mobid = 45203;

update droplist set item_name = 'Adena' where itemid = 40308;

update npc set name = 'Ghost - Red' where npcid = 45174;
update npc set name = 'Ghost - Blue' where npcid = 45198;


# Valakas
# remove & re-add correct Gold Dragon's breath attacks
delete from skills where skill_id > 20003 and skill_id < 20006;

delete from mobskill where mobid > 46045 and mobid < 46047;

insert into skills values 
(20004,'Gold Dragon Fire Ball',0,0,5,0,0,0,0,0,'attack',3,5,10,5,0,0,2,64,0,6,0,0,64,'Gold Dragon Fire Ball',19,5214,0,0,0);
insert into skills values 
(20005,'Gold Dragon Fire Breath',0,0,10,0,0,0,0,0,'attack',3,10,15,5,0,0,2,64,0,2,2,0,0,'Gold Dragon Fire Breath',18,6398,0,0,0);
insert into mobskill values 
(46046,0,'Gold Dragon','Fire Ball',2,50,0,0,-8,0,0,0,0,0,20,20004,5214,19,0,0,0,0);
insert into mobskill values 
(46046,1,'Gold Dragon','Fire Breath',2,50,0,0,-2,0,0,2,1,2,10,20005,6398,18,0,0,0,0);

#Fuzzy
# Add Gold Dragon Npc for Evolving
Update pettypes set NpcIdForEvolving = '46046' where BaseNpcId > 45685 and BaseNpcId < 45698; 
Update pettypes set NpcIdForEvolving = '46046' where BaseNpcId = 45710; 
Update pettypes set NpcIdForEvolving = '46046' where BaseNpcId = 45712;


