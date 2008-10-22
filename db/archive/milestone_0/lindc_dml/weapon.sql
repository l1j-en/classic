-- update 0

-- fix eva's scorn stats. should be 9/9, +1 dmg, +1 hit (currently just 10/10)
update weapon set dmg_small = 9, dmg_large = 9, hitmodifier = 1, dmgmodifier = 1 where item_id = 36;



-- update 2

-- fix eva's name
update weapon set name_id = 'Eva\'s Scorn' where item_id = 36;

-- fix thor's name
update weapon set name_id = 'Thor\'s Hammer', name = 'Thor\'s Hammer' where item_id = 450000;



-- update 3

-- fix brave claw, edoryu, xbow names
update weapon set name_id = '$2449 $2453' where item_id = 81;
update weapon set name_id = '$372 $2453' where item_id = 162;
update weapon set name_id = '$2451 $2453' where item_id = 177;



-- update 4

-- correct staff of sorcery name
update weapon set name = 'Staff of Sorcery' where item_id = 125;

-- change Cursed Katana name to just Katana
update weapon set name = 'Katana' where item_id = 200041;



-- update 8

-- fixed cursed orcish dagger name (was elven dagger)
update weapon set name = 'Orcish Dagger' where item_id = 200001;

-- correct name of Bow (was Elven Bow)
update weapon set name = 'Bow' where item_id in (170, 100172);

-- correct name of dark crossbow
update weapon set name = 'Dark Crossbow' where item_id = 168;



-- update 13

-- correct name of c-orcish bow (was Bow)
update weapon set name = 'Orcish Bow' where item_id = 200171;



-- update 14

-- correct name for Unknown Spear (was nothing)
update weapon set name = 'Unknown Spear' where item_id = 87;

-- correct name for Crimson Lance (was nothing)
update weapon set name = 'Crimson Lance' where item_id = 100107;

-- add diamond sword
INSERT INTO `weapon` VALUES ('450004', 'Diamond Sword', 'Diamond Sword', 'sword', 'steel', '90000', '1350', '26', '0', '14', '12', '6', '1', '0', '0', '0', '0', '2', '0', '0', '0', '2', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '50', '0', '1', '0');



-- update 19

-- make kurtz sword tradable
update weapon set trade = 0 where item_id = 54;

-- correct name of Elven Bow (was Bow)
update weapon set name = 'Elven Bow' where item_id = 170;

-- correct name of Ivory Tower Bow (was Elven Bow)
update weapon set name = 'Ivory Tower Bow' where item_id = 175;

-- correct name of Bow (was Short Bow)
update weapon set name = 'Bow' where item_id = 172;

-- correct name of Short Bow (was Stupid Bow)
update weapon set name = 'Short Bow' where item_id = 173;


-- update 20

-- correct name of Sword of Dantes (was 195)
update weapon set name = 'Sword of Dantes' where item_id = 195;

-- correct name of Two-Handed Sword of Varlok (was 196)
update weapon set name = 'Two-Handed Sword of Varlok' where item_id = 196;

-- correct name of Sword of Legend (was Gm's Wrath)
update weapon set name = 'Sword of Legend' where item_id = 228;

-- correct name of Morning Star (was 100146)
update weapon set name = 'Morning Star' where item_id = 100146;

-- correct name of Crossbow (was 100180)
update weapon set name = 'Crossbow' where item_id = 100180;

-- correct name of Yumi (was 100181)
update weapon set name = 'Yumi' where item_id = 100181;

-- correct name of Trident of the Sea God (was 100212)
update weapon set name = 'Trident of the Sea God' where item_id = 100212;

-- correct name of Elven Short Sword (was 100028)
update weapon set name = 'Elven Short Sword' where item_id = 100028;

-- correct name of Elven Dagger (was 100005)
update weapon set name = 'Elven Dagger' where item_id = 100005;

-- correct name of Bow of Cold Mystery (was 191)
update weapon set name = 'Bow of Cold Mystery' where item_id = 191;



-- update 22

-- fix all misnamed weapons
update weapon set name = 'Ivory Tower Dagger' where item_id = 7;
update weapon set name = 'Wind Blade Dagger' where item_id = 12;
update weapon set name = 'Sword of Kurtz' where item_id = 15;
update weapon set name = 'Sealed Forgotten Great Sword' where item_id = 17;
update weapon set name = 'Sealed Forgotten Sword' where item_id = 18;
update weapon set name = 'Sword of the Red Knight' where item_id = 30;
update weapon set name = 'Sword of Red Desire' where item_id = 34;
update weapon set name = 'Damascus Sword' where item_id = 37;
update weapon set name = 'Gold Scepter' where item_id = 51;
update weapon set name = 'Mithril-coated Horn' where item_id = 89;
update weapon set name = 'Bill-guisarme' where item_id = 92;
update weapon set name = 'Oriharukon-coated Horn' where item_id = 100;
update weapon set name = 'Lastabad One-Handed Spear' where item_id = 101;
update weapon set name = 'Staff of Demon' where item_id = 108;
update weapon set name = 'Staff of Baphomet' where item_id = 109;
update weapon set name = 'Staff of Beleth' where item_id = 110;
update weapon set name = 'Staff of Ice Queen' where item_id = 111;
update weapon set name = 'Elven Sword of Magic Resistance' where item_id = 112;
update weapon set name = 'Elven Sword of Dexterity' where item_id = 113;
update weapon set name = 'Symbol of Dignity' where item_id = 114;
update weapon set name = 'Crystal Staff' where item_id = 115;
update weapon set name = 'Staff of Black Wizard' where item_id = 116;
update weapon set name = 'Jet-Black Crystal Ball' where item_id = 118;
update weapon set name = 'Staff of Demon' where item_id = 119;
update weapon set name = 'Wizard\'s Staff' where item_id = 129;
update weapon set name = 'War Hammer' where item_id = 141;
update weapon set name = 'Axe of Minotaur' where item_id = 149;
update weapon set name = 'Hammer of the Heavens' where item_id = 150;
update weapon set name = 'Claw of Savage King' where item_id = 160;
update weapon set name = 'Claw of Hate' where item_id = 166;
update weapon set name = 'Sealed Forgotten Bowgun' where item_id = 167;
update weapon set name = 'Bow of Ancient Elf' where item_id = 179;
update weapon set name = 'Crossbow' where item_id = 180;
update weapon set name = 'Lastabad Cross Bow' where item_id = 187;
update weapon set name = 'Lastabad Heavy Cross Bow' where item_id = 188;
update weapon set name = 'Bow of Cold Mastery' where item_id = 191;
update weapon set name = 'Cursed Sword of Dantes' where item_id = 195;
update weapon set name = 'Two-Handed Sword of Varlok' where item_id = 196;
update weapon set name = 'Two-Handed Sword of Varlok' where item_id = 197;
update weapon set name = 'Two-Handed Sword of Varlok' where item_id = 198;
update weapon set name = 'Two-Handed Sword of Varlok' where item_id = 199;
update weapon set name = 'Two-Handed Sword of Varlok' where item_id = 200;
update weapon set name = 'Two-Handed Sword of Varlok' where item_id = 201;
update weapon set name = 'Two-Handed Sword of Varlok' where item_id = 202;
update weapon set name = 'Two-Handed Sword of Varlok' where item_id = 203;
update weapon set name = 'Impartial Arbalest' where item_id = 204;
update weapon set name = 'Longbow of Moon' where item_id = 205;
update weapon set name = 'Dark Elf\'s Training Sword' where item_id = 206;
update weapon set name = 'Claw of Purgatory' where item_id = 207;
update weapon set name = 'Elven Sword of Spellpower', invgfx = 235 where item_id = 208;
update weapon set name = 'Elven Sword of Constitution', invgfx = 235 where item_id = 208;
update weapon set name = 'Spear of Sheba Human' where item_id = 210;
update weapon set name = 'Trident of the Sea God' where item_id = 212;
update weapon set name = 'Staff of Kirtas' where item_id = 213;
update weapon set name = 'Heavy Throwing Knife', invgfx = 1145 where item_id = 214;
update weapon set name = 'Apprentice Elf Bow' where item_id = 216;
update weapon set name = 'Sword of Kirtas' where item_id = 217;
update weapon set name = 'Iron Mace of Angus' where item_id = 218;
-- unknown invgfx for this item currently
update weapon set name = 'Axe of Maphr' where item_id = 219; 
update weapon set name = 'Apprentice Wizard Staff', invgfx = 297 where item_id = 220;
update weapon set name = 'Mystery Staff', invgfx = 946 where item_id = 223;
update weapon set name = 'Ivory Tower Staff' where item_id = 224;
update weapon set name = 'Apprentice Sword', invgfx = 2 where item_id = 225;
update weapon set name = 'Apprentice Knight Sword', invgfx = 2 where item_id = 226;
update weapon set name = 'Sword of Legend' where item_id = 228;
update weapon set name = 'Sword of Kirtas' where item_id = 230;
update weapon set name = 'Unknown 231' where item_id = 231;
update weapon set name = 'Unknown 232' where item_id = 232;
update weapon set name = 'Unknown 233' where item_id = 233;
update weapon set name = 'Unknown 234' where item_id = 234;
update weapon set name = 'Unknown 235' where item_id = 235;
update weapon set name = 'Unknown 236' where item_id = 236;
update weapon set name = 'Unknown 237' where item_id = 237;
update weapon set name = 'Unknown 238' where item_id = 238;
update weapon set name = 'Unknown 239' where item_id = 239;
update weapon set name = 'Unknown 240' where item_id = 240;
update weapon set name = 'Unknown 241', name_id = 'Unknown 241' where item_id = 241;
update weapon set name = 'Unknown 242', name_id = 'Unknown Crossbow'  where item_id = 242;
update weapon set name = 'Unknown 243', name_id = 'Unknown Quaterstaff'  where item_id = 243;
update weapon set name = 'Unknown 244', name_id = 'Unknown Claw'  where item_id = 244;
update weapon set name = 'Unknown 245' where item_id = 245;
update weapon set name = 'Elven Dagger' where item_id = 100005;
update weapon set name = 'Mithril Dagger' where item_id = 100008;
update weapon set name = 'Oriharukon Dagger' where item_id = 100009;
update weapon set name = 'Elven Short Sword' where item_id = 100028;
update weapon set name = 'Damascus Sword' where item_id = 100037;
update weapon set name = 'Morning Star' where item_id = 100146;
update weapon set name = 'Elven Bow' where item_id = 100170;
update weapon set name = 'Crossbow' where item_id = 100180;
update weapon set name = 'Yumi' where item_id = 100181;
update weapon set name = 'Trident of the Sea God' where item_id = 100212;
update weapon set name = 'Gradius' where item_id = 200032;
