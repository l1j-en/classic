/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package l1j.server.server.encryptions;

public class Opcodes {
	public Opcodes() {
	}
	
	 public static final int C_OPCODE_ADDBUDDY = 99;
	 public static final int C_OPCODE_AMOUNT = 109;
	 public static final int C_OPCODE_ARROWATTACK = 247;
	 public static final int C_OPCODE_ATTACK = 68;
	 public static final int C_OPCODE_ATTR = 61;
	 public static final int C_OPCODE_BANCLAN = 222;
	 public static final int C_OPCODE_BANPARTY = 70;
	 public static final int C_OPCODE_BOARD = 73;
	 public static final int C_OPCODE_BOARDBACK = 87; // missing in new client?
	 public static final int C_OPCODE_BOARDDELETE = 12;
	 public static final int C_OPCODE_BOARDREAD = 59;
	 public static final int C_OPCODE_BOARDWRITE = 14;
	 public static final int C_OPCODE_BOOKMARK = 134;
	 public static final int C_OPCODE_BOOKMARKDELETE = 223;
	 public static final int C_OPCODE_BUDDYLIST = 60;
	 public static final int C_OPCODE_CHATPARTY = 113;
	 public static final int C_OPCODE_CALL = 144;
	 public static final int C_OPCODE_CHANGECHAR = 237;
	 public static final int C_OPCODE_CHANGEHEADING = 65;
	 public static final int C_OPCODE_CHANGEWARTIME = 4;
	 public static final int C_OPCODE_CHARACTERCONFIG = 129;
	 public static final int C_OPCODE_CHARRESET = 236;
	 public static final int C_OPCODE_CHAT = 190;
	 public static final int C_OPCODE_CHATGLOBAL = 62;
	 public static final int C_OPCODE_CHATWHISPER = 122;
	 public static final int C_OPCODE_CHECKPK = 137;
	 public static final int C_OPCODE_CLAN = 246;
	 public static final int C_OPCODE_CLIENTVERSION = 127;
	 public static final int C_OPCODE_COMMONCLICK = 53;
	 public static final int C_OPCODE_CREATECLAN = 154;
	 public static final int C_OPCODE_CREATEPARTY = 166;
	 public static final int C_OPCODE_DELBUDDY = 211;
	 public static final int C_OPCODE_DELETECHAR = 10;
	 public static final int C_OPCODE_DELETEINVENTORYITEM = 209;
	 public static final int C_OPCODE_DEPOSIT = 35;
	 public static final int C_OPCODE_DOOR = 199;
	 public static final int C_OPCODE_DRAWAL = 192;
	 public static final int C_OPCODE_DROPITEM = 54;
	 public static final int C_OPCODE_EMBLEM = 107;
	 public static final int C_OPCODE_ENTERPORTAL = 249;
	 public static final int C_OPCODE_EXCLUDE = 101;
	 public static final int C_OPCODE_EXIT_GHOST = 210;
	 public static final int C_OPCODE_EXTCOMMAND = 157;
	 public static final int C_OPCODE_FIGHT = 47;
	 public static final int C_OPCODE_FISHCLICK = 26;
	 public static final int C_OPCODE_FIX_WEAPON_LIST = 106;
	 public static final int C_OPCODE_GIVEITEM = 244;
	 public static final int C_OPCODE_HIRESOLDIER = 97;
	 public static final int C_OPCODE_JOINCLAN = 30;
	 public static final int C_OPCODE_KEEPALIVE = 182;
	 public static final int C_OPCODE_LEAVECLAN = 121;
	 public static final int C_OPCODE_LEAVEPARTY = 204;
	 public static final int C_OPCODE_LOGINPACKET = 57;
	 public static final int C_OPCODE_LOGINTOSERVER = 131;
	 public static final int C_OPCODE_LOGINTOSERVEROK = 75;
	 public static final int C_OPCODE_MAIL = 22;
	 public static final int C_OPCODE_MOVECHAR = 95;
	 public static final int C_OPCODE_NEWCHAR = 253;
	 public static final int C_OPCODE_NPCACTION = 37;
	 public static final int C_OPCODE_NPCTALK = 58;
	 public static final int C_OPCODE_PARTY = 42;
	 public static final int C_OPCODE_PETMENU = 217;
	 public static final int C_OPCODE_PICKUPITEM = 188;
	 public static final int C_OPCODE_PLEDGE = 225;
	 public static final int C_OPCODE_PRIVATESHOPLIST = 193;
	 public static final int C_OPCODE_PROPOSE = 185;
	 public static final int C_OPCODE_QUITGAME = 104;
	 public static final int C_OPCODE_RANK = 88;
	 public static final int C_OPCODE_RESTART = 162;
	 public static final int C_OPCODE_RESULT = 40;
	 public static final int C_OPCODE_RETURNTOLOGIN = 218;
	 public static final int C_OPCODE_SELECTLIST = 238;
	 public static final int C_OPCODE_SELECTTARGET = 155;
	 public static final int C_OPCODE_SENDLOCATION = 41;
	 public static final int C_OPCODE_SHIP = 117;
	 public static final int C_OPCODE_SHOP = 16;
	 public static final int C_OPCODE_SKILLBUY = 173;
	 public static final int C_OPCODE_SKILLBUYOK = 207;
	 public static final int C_OPCODE_TAXRATE = 200;
	 public static final int C_OPCODE_TELEPORT = 242;
	 public static final int C_OPCODE_TITLE = 96;
	 public static final int C_OPCODE_TRADE = 103;
	 public static final int C_OPCODE_TRADEADDCANCEL = 167;
	 public static final int C_OPCODE_TRADEADDITEM = 241;
	 public static final int C_OPCODE_TRADEADDOK = 110;
	 public static final int C_OPCODE_USEITEM = 44;
	 public static final int C_OPCODE_USEPETITEM = 213;
	 public static final int C_OPCODE_USESKILL = 115;
	 public static final int C_OPCODE_WAR = 235;
	 public static final int C_OPCODE_WHO = 49;
	 
	 public static final int S_OPCODE_ABILITY = 116;
	 public static final int S_OPCODE_ACTIVESPELLS = 40;
	 public static final int S_OPCODE_ADDITEM = 63;
	 public static final int S_OPCODE_ADDSKILL = 48;
	 public static final int S_OPCODE_ATTACKPACKET = 142;
	 public static final int S_OPCODE_ATTRIBUTE = 35;
	 public static final int S_OPCODE_BLESSOFEVA = 12;
	 public static final int S_OPCODE_BLUEMESSAGE = 59;
	 public static final int S_OPCODE_BOARD = 64;
	 public static final int S_OPCODE_BOARDREAD = 56;
	 public static final int S_OPCODE_BOOKMARKS = 11;
	 public static final int S_OPCODE_CASTLEMASTER = 66;
	 public static final int S_OPCODE_CHANGEHEADING = 199;
	 public static final int S_OPCODE_CHANGENAME = 81;
	 public static final int S_OPCODE_CHARAMOUNT = 126;
	 public static final int S_OPCODE_CHARLIST = 184;
	 public static final int S_OPCODE_CHARLOCK = 117; //can't find
	 public static final int S_OPCODE_CHARPACK = 3;
	 public static final int S_OPCODE_CHARRESET = 33;
	 public static final int S_OPCODE_CHARTITLE = 202;
	 public static final int S_OPCODE_CHARVISUALUPDATE = 113;
	 public static final int S_OPCODE_CLAN = 29;
	 public static final int S_OPCODE_COMMONNEWS = 30;
	 public static final int S_OPCODE_CURSEBLIND = 238;
	 public static final int S_OPCODE_DELETEINVENTORYITEM = 148;
	 public static final int S_OPCODE_DELSKILL = 18;
	 public static final int S_OPCODE_DEPOSIT = 203;
	 public static final int S_OPCODE_DETELECHAROK = 5;
	 public static final int S_OPCODE_DEXUP = 28;
	 public static final int S_OPCODE_DISCONNECT = 95;
	 public static final int S_OPCODE_DOACTIONGFX = 218;
	 public static final int S_OPCODE_DRAWAL = 224;
	 public static final int S_OPCODE_DROPITEM = 3;
	 public static final int S_OPCODE_EFFECTLOCATION = 112;
	 public static final int S_OPCODE_EMBLEM = 50;
	 public static final int S_OPCODE_EXP = 121;
	 public static final int S_OPCODE_GAMETIME = 194;
	 public static final int S_OPCODE_GLOBALCHAT = 10;
	 public static final int S_OPCODE_HIRESOLDIER = 126;
	 public static final int S_OPCODE_HOUSELIST = 24;
	 public static final int S_OPCODE_HOUSEMAP = 44;
	 public static final int S_OPCODE_HPMETER = 128;
	 public static final int S_OPCODE_HPUPDATE = 42;
	 public static final int S_OPCODE_IDENTIFYDESC = 43;
	 public static final int S_OPCODE_INITPACKET = 161;
	 public static final int S_OPCODE_INPUTAMOUNT = 253;
	 public static final int S_OPCODE_INVIS = 57;
	 public static final int S_OPCODE_INVLIST = 180;
	 public static final int S_OPCODE_ITEMAMOUNT = 127;
	 public static final int S_OPCODE_ITEMCOLOR = 144;
	 public static final int S_OPCODE_ITEMNAME = 195;
	 public static final int S_OPCODE_ITEMSTATUS = 127;
	 public static final int S_OPCODE_LAWFUL = 140;
	 public static final int S_OPCODE_LIGHT = 53;
	 public static final int S_OPCODE_LIQUOR = 31;
	 public static final int S_OPCODE_LOGINRESULT = 51;
	 public static final int S_OPCODE_LOGINTOGAME = 131;
	 public static final int S_OPCODE_MAIL = 1;
	 public static final int S_OPCODE_MAPID = 150;
	 public static final int S_OPCODE_MOVEOBJECT = 122;
	 public static final int S_OPCODE_MPUPDATE = 73;
	 public static final int S_OPCODE_NEWCHARPACK = 212;
	 public static final int S_OPCODE_NEWCHARWRONG = 153;
	 public static final int S_OPCODE_NEWMASTER = 39; // can't find
	 public static final int S_OPCODE_NORMALCHAT = 76;
	 public static final int S_OPCODE_NPCSHOUT = 133;
	 public static final int S_OPCODE_OWNCHARATTRDEF = 15;
	 public static final int S_OPCODE_OWNCHARSTATUS = 145; //charstatus2 also exists?
	 public static final int S_OPCODE_OWNCHARSTATUS2 = 216;
	 public static final int S_OPCODE_PACKETBOX = 40;
	 public static final int S_OPCODE_PARALYSIS = 165;
	 public static final int S_OPCODE_PETCTRL = 33;
	 public static final int S_OPCODE_PINGTIME = 100; // can't find
	 public static final int S_OPCODE_PINKNAME = 252;
	 public static final int S_OPCODE_POISON = 93;
	 public static final int S_OPCODE_POLY = 164;
	 public static final int S_OPCODE_PRIVATESHOPLIST = 190;
	 public static final int S_OPCODE_PUTSOLDIER = 45; // can't find
	 public static final int S_OPCODE_RANGESKILLS = 16;
	 public static final int S_OPCODE_REMOVE_OBJECT = 185;
	 public static final int S_OPCODE_RESTART = 97; // can't find
	 public static final int S_OPCODE_RESURRECTION = 227;
	 public static final int S_OPCODE_SELECTLIST = 208;
	 public static final int S_OPCODE_SELECTTARGET = 177;
	 public static final int S_OPCODE_SERVERMSG = 14;
	 public static final int S_OPCODE_SERVERSTAT = 55; //can't find
	 public static final int S_OPCODE_SERVERVERSION = 151;
	 public static final int S_OPCODE_SHOWHTML = 119;
	 public static final int S_OPCODE_SHOWRETRIEVELIST = 250;
	 public static final int S_OPCODE_SHOWSHOPBUYLIST = 254;
	 public static final int S_OPCODE_SHOWSHOPSELLLIST = 170;
	 public static final int S_OPCODE_SKILLBRAVE = 200;
	 public static final int S_OPCODE_SKILLBUY = 222;
	 public static final int S_OPCODE_SKILLHASTE = 149;
	 public static final int S_OPCODE_SKILLICONGFX = 40;
	 public static final int S_OPCODE_SKILLICONSHIELD = 69;
	 public static final int S_OPCODE_SKILLSOUNDGFX = 232;
	 public static final int S_OPCODE_SOUND = 84;
	 public static final int S_OPCODE_SPMR = 174;
	 public static final int S_OPCODE_STRUP = 120;
	 public static final int S_OPCODE_SYSMSG = 10;
	 public static final int S_OPCODE_TAXRATE = 72;
	 public static final int S_OPCODE_TELEPORT = 4;
	 public static final int S_OPCODE_TELEPORTLOCK = 135;
	 public static final int S_OPCODE_TRADE = 77;
	 public static final int S_OPCODE_TRADEADDITEM = 86;
	 public static final int S_OPCODE_TRADESTATUS = 239;
	 public static final int S_OPCODE_TRUETARGET = 110;
	 public static final int S_OPCODE_UNDERWATER = 42;
	 public static final int S_OPCODE_UNKNOWN1 = 116; //can't find
	 public static final int S_OPCODE_USEMAP = 100;
	 public static final int S_OPCODE_WAR = 123;
	 public static final int S_OPCODE_WARTIME = 150;
	 public static final int S_OPCODE_WEATHER = 193;
	 public static final int S_OPCODE_WHISPERCHAT = 255;
	 public static final int S_OPCODE_YES_NO = 155;
}