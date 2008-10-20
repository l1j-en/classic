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

package l1j.server.packethandler;

public class Opcodes {

	public Opcodes() {
	}

	// clientpackets
	public static final int C_OPCODE_USEITEM = 0;

	public static final int C_OPCODE_EXCLUDE = 2;

	public static final int C_OPCODE_CHARACTERCONFIG = 5;

	public static final int C_OPCODE_CHANGECHAR = 9;

	public static final int C_OPCODE_MOVECHAR = 12;

	public static final int C_OPCODE_TAXRATE = 13;

	public static final int C_OPCODE_RANK = 11;
	
	public static final int C_OPCODE_CHATPARTY = 131;
	
	public static final int C_OPCODE_WAR = 14;

	public static final int C_OPCODE_CHATGLOBAL = 15;

	public static final int C_OPCODE_CLIENTVERSION = 17;

	public static final int C_OPCODE_AMOUNT = 19;

	public static final int C_OPCODE_BOARDBACK = 20;

	public static final int C_OPCODE_ADDBUDDY = 21;

	public static final int C_OPCODE_FIX_WEAPON_LIST = 22;

	public static final int C_OPCODE_LOGINPACKET = 23;

	public static final int C_OPCODE_TELEPORT = 85;
	
	public static final int C_OPCODE_TRADEADDCANCEL = 25;

	public static final int C_OPCODE_CHATWHISPER = 27;

	public static final int C_OPCODE_TRADEADDITEM = 28;

	public static final int C_OPCODE_JOINCLAN = 29;

	public static final int C_OPCODE_KEEPALIVE = 30;

	public static final int C_OPCODE_NEWCHAR = 31;

	public static final int C_OPCODE_PLEDGE = 32;

	public static final int C_OPCODE_BOARD = 39;

	public static final int C_OPCODE_FISHCLICK = 40;

	public static final int C_OPCODE_ARROWATTACK = 41;

	public static final int C_OPCODE_BANCLAN = 42;

	public static final int C_OPCODE_DEPOSIT = 43;

	public static final int C_OPCODE_PARTY = 44;

	public static final int C_OPCODE_ENTERPORTAL = 45;

	public static final int C_OPCODE_DELETEINVENTORYITEM = 49;

	public static final int C_OPCODE_EXIT_GHOST = 50;

	public static final int C_OPCODE_SKILLBUY = 51;

	public static final int C_OPCODE_CHECKPK = 54;

	public static final int C_OPCODE_USESKILL = 55;

	public static final int C_OPCODE_SELECTLIST = 58;

	public static final int C_OPCODE_PICKUPITEM = 59;

	public static final int C_OPCODE_RESULT = 61;

	public static final int C_OPCODE_CHANGEWARTIME = 62;

	public static final int C_OPCODE_PRIVATESHOPLIST = 63;

	public static final int C_OPCODE_COMMONCLICK = 65;

	public static final int C_OPCODE_RETURNTOLOGIN = 67;

	public static final int C_OPCODE_ATTACK = 68;

	public static final int C_OPCODE_LEAVEPARTY = 69;

	public static final int C_OPCODE_SHOP = 71;

	public static final int C_OPCODE_CALL = 72;

	public static final int C_OPCODE_WHO = 75;

	public static final int C_OPCODE_LEAVECLANE = 76;

	public static final int C_OPCODE_EMBLEM = 77;

	public static final int C_OPCODE_BUDDYLIST = 79;

	public static final int C_OPCODE_DRAWAL = 80;

	public static final int C_OPCODE_GIVEITEM = 82;

	public static final int C_OPCODE_TRADE = 83;

	public static final int C_OPCODE_PETMENU = 84;

	public static final int C_OPCODE_DELETECHAR = 87;

	public static final int C_OPCODE_NPCACTION = 88;

	public static final int C_OPCODE_HIRESOLDIER = 90;

	public static final int C_OPCODE_BOARDDELETE = 91;

	public static final int C_OPCODE_EXTCOMMAND = 92;

	public static final int C_OPCODE_TITLE = 93;

	public static final int C_OPCODE_DOOR = 94;

	public static final int C_OPCODE_QUITGAME = 98;

	public static final int C_OPCODE_PROPOSE = 99;

	public static final int C_OPCODE_CREATECLAN = 100;

	public static final int C_OPCODE_BOOKMARK = 101;

	public static final int C_OPCODE_USEPETITEM = 103;

	public static final int C_OPCODE_BOOKMARKDELETE = 104;

	public static final int C_OPCODE_BANPARTY = 105;

	public static final int C_OPCODE_ATTR = 112;

	public static final int C_OPCODE_CHAT = 113;

	public static final int C_OPCODE_SELECTTARGET = 114;

	public static final int C_OPCODE_DROPITEM = 115;

	public static final int C_OPCODE_BOARDREAD = 116;

	public static final int C_OPCODE_RESTART = 117;

	public static final int C_OPCODE_SKILLBUYOK = 118;

	public static final int C_OPCODE_COMMONCLICK2 = 119;

	public static final int C_OPCODE_TRADEADDOK = 120;

	public static final int C_OPCODE_CHANGEHEADING = 122;

	public static final int C_OPCODE_DELBUDDY = 123;

	public static final int C_OPCODE_DELEXCLUDE = 124;

	public static final int C_OPCODE_LOGINTOSERVER = 125;

	public static final int C_OPCODE_BOARDWRITE = 126;

	public static final int C_OPCODE_LOGINTOSERVEROK = 127;

	public static final int C_OPCODE_NPCTALK = 129;

	public static final int C_OPCODE_CREATEPARTY = 130;

	// serverpackets
	// public static final int S_OPCODE_NEWCHARWRONG = 0;

	public static final int S_OPCODE_LETTER = 1;

	public static final int S_OPCODE_RANGESKILLS = 2; 

	public static final int S_OPCODE_DOACTIONGFX = 3;

	public static final int S_OPCODE_USEMAP = 5;

	public static final int S_OPCODE_ITEMSTATUS = 6;

	public static final int S_OPCODE_SELETESERVER = 7; 

	public static final int S_OPCODE_INVIS = 8;

	public static final int S_OPCODE_CHARDELETEOK = 10; 

	public static final int S_OPCODE_LAWFUL = 12;

	//Account has just logged in from
	public static final int S_OPCODE_BLUEMESSAGE2 = 13;

	public static final int S_OPCODE_SELECTLIST = 14;

	public static final int S_OPCODE_BOARDREAD = 15;

	public static final int S_OPCODE_SKILLBUY = 17;

	public static final int S_OPCODE_MATERIAL = 18; 

	public static final int S_OPCODE_HPUPDATE = 19;

	public static final int S_OPCODE_SHOWRETRIEVELIST = 20;

	public static final int S_OPCODE_DELSKILL = 21;

	public static final int S_OPCODE_NEWCHARPACK = 22;

	public static final int S_OPCODE_LOGINOK = 23;

	public static final int S_OPCODE_ADDITEM = 24;

	public static final int S_OPCODE_TAXRATE = 25;

	public static final int S_OPCODE_TRADEADDITEM = 26;

	public static final int S_OPCODE_MAPID = 27;

	public static final int S_OPCODE_UNDERWATER = 27;

	public static final int S_OPCODE_YES_NO = 28;

	public static final int S_OPCODE_DETELECHAROK = 29;

	public static final int S_OPCODE_TELEPORT = 30; 

	public static final int S_OPCODE_WHISPERCHAT = 33;

	public static final int S_OPCODE_REMOVE_OBJECT = 34;

	public static final int S_OPCODE_SERVERVERSION = 35;

	public static final int S_OPCODE_COMMONNEWS = 36;

	public static final int S_OPCODE_HOUSELIST = 37;

	public static final int S_OPCODE_ITEMNAME = 38;

	public static final int S_OPCODE_DEXUP = 39;

	public static final int S_OPCODE_SELECTTARGET = 40; 

	public static final int S_OPCODE_EMBLEM = 41;

	public static final int S_OPCODE_IDENTIFYDESC = 42;

	public static final int S_OPCODE_PINKNAME = 43;

	public static final int S_OPCODE_NEWMASTER = 44; 

	public static final int S_OPCODE_POISON = 45;

	public static final int S_OPCODE_BOOKMARKS = 49;

	public static final int S_OPCODE_PRIVATESHOPLIST = 50;

	public static final int S_OPCODE_TRADE = 51;

	public static final int S_OPCODE_INPUTAMOUNT = 52;

	public static final int S_OPCODE_PINGTIME = 53; 

	public static final int S_OPCODE_WAR = 54;

	public static final int S_OPCODE_MOVEOBJECT = 55;

	public static final int S_OPCODE_HOUSEMAP = 56;

	public static final int S_OPCODE_SHOWSHOPSELLLIST = 57;

	public static final int S_OPCODE_BLUEMESSAGE = 58;

	public static final int S_OPCODE_ATTACKPACKET = 59;

	public static final int S_OPCODE_WARTIME = 60;

	public static final int S_OPCODE_ITEMAMOUNT = 61;

	public static final int S_OPCODE_PACKETBOX = 62;

	public static final int S_OPCODE_ACTIVESPELLS = 62;

	public static final int S_OPCODE_SKILLICONGFX = 62;

	public static final int S_OPCODE_CURSEBLIND = 63;

	public static final int S_OPCODE_COMMONNEWS2 = 64; 

	public static final int S_OPCODE_STRUP = 65;

	public static final int S_OPCODE_UNKNOWN1 = 66;

	public static final int S_OPCODE_SPMR = 67;

	public static final int S_OPCODE_PUTSOLDIER = 68; 

	public static final int S_OPCODE_GAMETIME = 69;

	public static final int S_OPCODE_HPMETER = 70;

	public static final int S_OPCODE_MPMETER = 70;
	
	public static final int S_OPCODE_SYSMSG = 71;

	public static final int S_OPCODE_GLOBALCHAT = 71;

	public static final int S_OPCODE_SERVERMSG = 72;

	public static final int S_OPCODE_TELEPORTLOCK = 73; 

	public static final int S_OPCODE_CHARPACK = 74;

	public static final int S_OPCODE_DROPITEM = 74;

	public static final int S_OPCODE_CHANGENAME = 75; 

	public static final int S_OPCODE_SKILLHASTE = 77;

	public static final int S_OPCODE_ADDSKILL = 78;

	public static final int S_OPCODE_ABILITY = 79;

	public static final int S_OPCODE_SKILLSOUNDGFX = 80;

	public static final int S_OPCODE_ATTRIBUTE = 81;

	public static final int S_OPCODE_INVLIST = 82;

	public static final int S_OPCODE_CHARVISUALUPDATE = 84;

	public static final int S_OPCODE_OWNCHARATTRDEF = 85;

	public static final int S_OPCODE_EFFECTLOCATION = 86;

	public static final int S_OPCODE_DRAWAL = 87;

	public static final int S_OPCODE_DISCONNECT = 88;

	public static final int S_OPCODE_OWNCHARSTATUS = 89;

	public static final int S_OPCODE_RESURRECTION = 90;

	public static final int S_OPCODE_EXP = 91;

	public static final int S_OPCODE_SHOWHTML = 92;

	public static final int S_OPCODE_TRUETARGET = 93;

	public static final int S_OPCODE_HIRESOLDIER = 94;

	public static final int S_OPCODE_LOGINRESULT = 95;

	public static final int S_OPCODE_BOARD = 96;

	public static final int S_OPCODE_CHARLOCK = 97;

	public static final int S_OPCODE_NEWCHARWRONG = 98; 

	public static final int S_OPCODE_SHOWSHOPBUYLIST = 99;

	public static final int S_OPCODE_BLESSOFEVA = 100;

	public static final int S_OPCODE_RESTART = 101; 

	public static final int S_OPCODE_DEPOSIT = 102;

	public static final int S_OPCODE_NORMALCHAT = 103;

	public static final int S_OPCODE_CHANGEHEADING = 105;

	public static final int S_OPCODE_UNKNOWN2 = 105;

	public static final int S_OPCODE_TRADESTATUS = 106;

	public static final int S_OPCODE_CASTLEMASTER = 107;

	public static final int S_OPCODE_OWNCHARSTATUS2 = 108;

	public static final int S_OPCODE_CHARTITLE = 109;

	public static final int S_OPCODE_PARALYSIS = 111;

	public static final int S_OPCODE_POLY = 112;

	public static final int S_OPCODE_SKILLICONSHIELD = 114;

	public static final int S_OPCODE_SOUND = 116;

	public static final int S_OPCODE_CHARAMOUNT = 117;

	public static final int S_OPCODE_CHARLIST = 118;

	public static final int S_OPCODE_MPUPDATE = 119;

	public static final int S_OPCODE_DELETEINVENTORYITEM = 120;

	public static final int S_OPCODE_ITEMCOLOR = 121;

	public static final int S_OPCODE_SERVERSTAT = 122;

	public static final int S_OPCODE_WEATHER = 122;

	public static final int S_OPCODE_LIQUOR = 123;

	public static final int S_OPCODE_SKILLBRAVE = 124;

	public static final int S_OPCODE_LIGHT = 126;

	public static final int S_OPCODE_NPCSHOUT = 127;

	/*
	 * clientpackets for Episode6
	 * 
	 * public static final int C_OPCODE_QUITGAME = 0;
	 * 
	 * public static final int C_OPCODE_EXCLUDE = 1;
	 * 
	 * public static final int C_OPCODE_SHOP = 2;
	 * 
	 * public static final int C_OPCODE_CHARACTERCONFIG = 3;
	 * 
	 * public static final int C_OPCODE_CHECKPK = 6;
	 * 
	 * public static final int C_OPCODE_PROPOSE = 8;
	 * 
	 * public static final int C_OPCODE_REQUESTCHAT = 9;
	 * 
	 * public static final int C_OPCODE_JOINCLAN = 10;
	 * 
	 * public static final int C_OPCODE_SKILLBUYOK = 12;
	 * 
	 * public static final int C_OPCODE_RETURNTOLOGIN = 14;
	 * 
	 * public static final int C_OPCODE_COMMONCLICK = 15;
	 * 
	 * public static final int C_OPCODE_BOOKMARK = 17;
	 * 
	 * public static final int C_OPCODE_DEPOSIT = 20;
	 * 
	 * public static final int C_OPCODE_LOGINTOSERVER = 21;
	 * 
	 * public static final int C_OPCODE_CREATECLAN = 22;
	 * 
	 * public static final int C_OPCODE_REQUESTARROWATTACK = 24;
	 * 
	 * public static final int C_OPCODE_TRADE = 25;
	 * 
	 * public static final int C_OPCODE_TRADEADDCANCEL = 26;
	 * 
	 * public static final int C_OPCODE_REQUESTDOOR = 27;
	 * 
	 * public static final int C_OPCODE_BANPARTY = 28;
	 * 
	 * public static final int C_OPCODE_REQUESTTITLE = 29;
	 * 
	 * public static final int C_OPCODE_NPCTALK = 31;
	 * 
	 * public static final int C_OPCODE_REQUESTRESULT = 32;
	 * 
	 * public static final int C_OPCODE_KEEPALIVE = 34;
	 * 
	 * public static final int C_OPCODE_REQUESTPARTY = 35;
	 * 
	 * public static final int C_OPCODE_REQUESTEMBLEM = 37;
	 * 
	 * public static final int C_OPCODE_BOOKMARKDELETE = 40;
	 * 
	 * public static final int C_OPCODE_DELBUDDY = 42;
	 * 
	 * public static final int C_OPCODE_LEAVECLANE = 43;
	 * 
	 * public static final int C_OPCODE_REQUESTCHANGECHAR = 44;
	 * 
	 * public static final int C_OPCODE_REQUESTCHATGLOBAL = 46;
	 * 
	 * public static final int C_OPCODE_REQUESTWHO = 50;
	 * 
	 * public static final int C_OPCODE_REQUESTBUDDYLIST = 51;
	 * 
	 * public static final int C_OPCODE_USESKILL = 52;
	 * 
	 * public static final int C_OPCODE_FIX_WEAPON_LIST = 53;
	 * 
	 * public static final int C_OPCODE_ADDBUDDY = 54;
	 * 
	 * public static final int C_OPCODE_DELETECHAR = 57;
	 * 
	 * public static final int C_OPCODE_TAXRATE = 60;
	 * 
	 * public static final int C_OPCODE_REQUESTPLEDGE = 61;
	 * 
	 * public static final int C_OPCODE_CHANGEHEADING = 62;
	 * 
	 * public static final int C_OPCODE_REQUESTPICKUPITEM = 63;
	 * 
	 * public static final int C_OPCODE_REQUESTRESTART = 64;
	 * 
	 * public static final int C_OPCODE_TRADEADDOK = 65;
	 * 
	 * public static final int C_OPCODE_BOARD = 66;
	 * 
	 * public static final int C_OPCODE_BOARDREAD = 67;
	 * 
	 * public static final int C_OPCODE_BOARDWRITE = 68;
	 * 
	 * public static final int C_OPCODE_NPCACTION = 70;
	 * 
	 * public static final int C_OPCODE_BOARDDELETE = 72;
	 * 
	 * public static final int C_OPCODE_ENTERPORTAL = 76;
	 * 
	 * public static final int C_OPCODE_USEITEM = 77;
	 * 
	 * public static final int C_OPCODE_LOGINTOSERVEROK = 78;
	 * 
	 * public static final int C_OPCODE_SELECTLIST = 79;
	 * 
	 * public static final int C_OPCODE_SKILLBUY = 82;
	 * 
	 * public static final int C_OPCODE_LOGINPACKET = 83;
	 * 
	 * public static final int C_OPCODE_EXTCOMMAND = 86;
	 * 
	 * public static final int C_OPCODE_REQUESTDROPITEM = 87;
	 * 
	 * public static final int C_OPCODE_CALL = 88;
	 * 
	 * public static final int C_OPCODE_REQUESTAMOUNT = 92;
	 * 
	 * public static final int C_OPCODE_REQUESTWAR = 94;
	 * 
	 * public static final int C_OPCODE_REQUESTATTR = 97;
	 * 
	 * public static final int C_OPCODE_CLIENTVERSION = 98;
	 * 
	 * public static final int C_OPCODE_EXIT_GHOST = 99;
	 * 
	 * public static final int C_OPCODE_BANCLAN = 101;
	 * 
	 * public static final int C_OPCODE_REQUESTLEAVEPARTY = 104;
	 * 
	 * public static final int C_OPCODE_REQUESTCHATWHISPER = 107;
	 * 
	 * public static final int C_OPCODE_TRADEADDITEM = 109;
	 * 
	 * public static final int C_OPCODE_DELETEINVENTORYITEM = 112;
	 * 
	 * public static final int C_OPCODE_PRIVATESHOPLIST = 116;
	 * 
	 * public static final int C_OPCODE_BOARDBACK = 118;
	 * 
	 * public static final int C_OPCODE_NEWCHAR = 120;
	 * 
	 * public static final int C_OPCODE_WITHDRAWPET = 121;
	 * 
	 * public static final int C_OPCODE_REQUESTMOVECHAR = 124;
	 * 
	 * public static final int C_OPCODE_DRAWAL = 125;
	 * 
	 * public static final int C_OPCODE_REQUESTATTACK = 126;
	 * 
	 * public static final int C_OPCODE_HIRESOLDIER = 127;
	 * 
	 * public static final int C_OPCODE_GIVEITEM = 128;
	 * 
	 * public static final int C_OPCODE_CHANGEWARTIME = 129;
	 * 
	 * public static final int C_OPCODE_CREATEPARTY = 130;
	 * 
	 * serverpackets for Episode6
	 * 
	 * public static final int S_OPCODE_HPUPDATE = 0;
	 * 
	 * public static final int S_OPCODE_LIGHT = 2;
	 * 
	 * public static final int S_OPCODE_DETELECHAROK = 4;
	 * 
	 * public static final int S_OPCODE_ATTRIBUTE = 7;
	 * 
	 * public static final int S_OPCODE_MOVEOBJECT = 8;
	 * 
	 * public static final int S_OPCODE_TAXRATE = 9;
	 * 
	 * public static final int S_OPCODE_HIRESOLDIER = 10;
	 * 
	 * public static final int S_OPCODE_EFFECTLOCATION = 11;
	 * 
	 * public static final int S_OPCODE_OWNCHARATTRDEF = 12;
	 * 
	 * public static final int S_OPCODE_CHANGECHARNAME = 13;
	 * 
	 * public static final int S_OPCODE_OWNCHARSTATUS2 = 14;
	 * 
	 * public static final int S_OPCODE_LOGINRESULT = 15;
	 * 
	 * public static final int S_OPCODE_DISCONNECT = 17;
	 * 
	 * public static final int S_OPCODE_DELSKILL = 18;
	 * 
	 * public static final int S_OPCODE_CHANGEHEADING = 19;
	 * 
	 * public static final int S_OPCODE_UNKNOWN2 = 19;
	 * 
	 * public static final int S_OPCODE_TRUETARGET = 21;
	 * 
	 * public static final int S_OPCODE_INVLIST = 23;
	 * 
	 * public static final int S_OPCODE_ADDITEM = 24;
	 * 
	 * public static final int S_OPCODE_ITEMCOLOR = 25;
	 * 
	 * public static final int S_OPCODE_CHARAMOUNT = 26;
	 * 
	 * public static final int S_OPCODE_CHARLIST = 27;
	 * 
	 * public static final int S_OPCODE_INVIS = 29;
	 * 
	 * public static final int S_OPCODE_TRADE = 30;
	 * 
	 * public static final int S_OPCODE_HOUSEMAP = 31;
	 * 
	 * public static final int S_OPCODE_EMPLOY = 32;
	 * 
	 * public static final int S_OPCODE_SKILLHASTE = 33;
	 * 
	 * public static final int S_OPCODE_WHOPET = 35;
	 * 
	 * public static final int S_OPCODE_DOACTIONGFX = 36;
	 * 
	 * public static final int S_OPCODE_EMBLEM = 37;
	 * 
	 * public static final int S_OPCODE_CURSEBLIND = 38;
	 * 
	 * public static final int S_OPCODE_SKILLSOUNDGFX = 39;
	 * 
	 * public static final int S_OPCODE_UNKNOWN1 = 40;
	 * 
	 * public static final int S_OPCODE_USEMAP = 41;
	 * 
	 * public static final int S_OPCODE_HOUSELIST = 42;
	 * 
	 * public static final int S_OPCODE_OWNCHARSTATUS = 43;
	 * 
	 * public static final int S_OPCODE_NPCSHOUT = 44;
	 * 
	 * public static final int S_OPCODE_POLY = 45;
	 * 
	 * public static final int S_OPCODE_PARALYSIS = 46;
	 * 
	 * public static final int S_OPCODE_INPUTAMOUNT = 47;
	 * 
	 * public static final int S_OPCODE_BOARD = 48;
	 * 
	 * public static final int S_OPCODE_CHARPACK = 49;
	 * 
	 * public static final int S_OPCODE_DROPITEM = 49;
	 * 
	 * public static final int S_OPCODE_SERVERVERSION = 50;
	 * 
	 * public static final int S_OPCODE_CANTMOVE = 51;
	 * 
	 * public static final int S_OPCODE_RESURRECTION = 52;
	 * 
	 * public static final int S_OPCODE_DRAWAL = 53;
	 * 
	 * public static final int S_OPCODE_LAWFUL = 54;
	 * 
	 * public static final int S_OPCODE_DEPOSIT = 55;
	 * 
	 * public static final int S_OPCODE_PINGSERVER = 56;
	 * 
	 * public static final int S_OPCODE_ATTACKPACKET = 57;
	 * 
	 * public static final int S_OPCODE_CHARINFO3 = 58;
	 * 
	 * public static final int S_OPCODE_SELECTLIST = 59;
	 * 
	 * public static final int S_OPCODE_RETURNLOGIN = 60;
	 * 
	 * public static final int S_OPCODE_CHARTITLE = 62;
	 * 
	 * public static final int S_OPCODE_PRIVATESHOPLIST = 63;
	 * 
	 * public static final int S_OPCODE_SOUND = 65;
	 * 
	 * public static final int S_OPCODE_ITEMNAME = 66;
	 * 
	 * public static final int S_OPCODE_NEWCHARPACK = 67;
	 * 
	 * public static final int S_OPCODE_SERVERSTAT = 68;
	 * 
	 * public static final int S_OPCODE_WEATHER = 68;
	 * 
	 * public static final int S_OPCODE_BUY002 = 69;
	 * 
	 * public static final int S_OPCODE_ADDSKILL = 70;
	 * 
	 * public static final int S_OPCODE_COMMONNEWS = 73;
	 * 
	 * public static final int S_OPCODE_ABILITY = 74;
	 * 
	 * public static final int S_OPCODE_BOARDREAD = 75;
	 * 
	 * public static final int S_OPCODE_MPUPDATE = 76;
	 * 
	 * public static final int S_OPCODE_LOGINOK = 78;
	 * 
	 * public static final int S_OPCODE_SYSMSG = 79;
	 * 
	 * public static final int S_OPCODE_GLOBALCHAT = 79;
	 * 
	 * public static final int S_OPCODE_SHOWHTML = 80;
	 * 
	 * public static final int S_OPCODE_BONUSSTATS = 80;
	 * 
	 * public static final int S_OPCODE_DELETEINVENTORYITEM = 81;
	 * 
	 * public static final int S_OPCODE_MAPID = 82;
	 * 
	 * public static final int S_OPCODE_UNDERWATER = 82;
	 * 
	 * public static final int S_OPCODE_REMOVE_OBJECT = 83;
	 * 
	 * public static final int S_OPCODE_HPMETER = 84;
	 * 
	 * public static final int S_OPCODE_POISON = 85;
	 * 
	 * public static final int S_OPCODE_BLESSOFEVA = 86;
	 * 
	 * public static final int S_OPCODE_CASTLEMASTER = 87;
	 * 
	 * public static final int S_OPCODE_SPMR = 89;
	 * 
	 * public static final int S_OPCODE_GMACCOUNTMSG = 90;
	 * 
	 * public static final int S_OPCODE_CANTMOVEBEFORETELE = 91;
	 * 
	 * public static final int S_OPCODE_CHARVISUALUPDATE = 92;
	 * 
	 * public static final int S_OPCODE_NEWCHARWRONG = 93;
	 * 
	 * public static final int S_OPCODE_WARTIME = 95;
	 * 
	 * public static final int S_OPCODE_GAMETIME = 96;
	 * 
	 * public static final int S_OPCODE_SELECTTARGET = 97;
	 * 
	 * public static final int S_OPCODE_NORMALCHAT = 98;
	 * 
	 * public static final int S_OPCODE_TRADESTATUS = 99;
	 * 
	 * public static final int S_OPCODE_SKILLICONSHIELD = 100;
	 * 
	 * public static final int S_OPCODE_SHOWRETRIEVELIST = 101;
	 * 
	 * public static final int S_OPCODE_SERVERMSG = 102;
	 * 
	 * public static final int S_OPCODE_SKILLBRAVE = 103;
	 * 
	 * public static final int S_OPCODE_SHOWSHOPSELLLIST = 105;
	 * 
	 * public static final int S_OPCODE_WAR = 106;
	 * 
	 * public static final int S_OPCODE_WEIGHT = 107;
	 * 
	 * public static final int S_OPCODE_PACKETBOX = 107;
	 * 
	 * public static final int S_OPCODE_ACTIVESPELLS = 107;
	 * 
	 * public static final int S_OPCODE_SKILLICONGFX = 107;
	 * 
	 * public static final int S_OPCODE_STRUP = 109;
	 * 
	 * public static final int S_OPCODE_LIQUOR = 110;
	 * 
	 * public static final int S_OPCODE_WHISPERCHAT = 112;
	 * 
	 * public static final int S_OPCODE_BLUEMESSAGE = 113;
	 * 
	 * public static final int S_OPCODE_TRADEADDITEM = 115;
	 * 
	 * public static final int S_OPCODE_LETTER = 116;
	 * 
	 * public static final int S_OPCODE_EXP = 118;
	 * 
	 * public static final int S_OPCODE_BOOKMARKS = 119;
	 * 
	 * public static final int S_OPCODE_SHOWSHOPBUYLIST = 120;
	 * 
	 * public static final int S_OPCODE_IDENTIFYDESC = 121;
	 * 
	 * public static final int S_OPCODE_DEXUP = 122;
	 * 
	 * public static final int S_OPCODE_PINKNAME = 123;
	 * 
	 * public static final int S_OPCODE_ITEMSTATUS = 124;
	 * 
	 * public static final int S_OPCODE_ITEMAMOUNT = 125;
	 * 
	 * public static final int S_OPCODE_YES_NO = 126;
	 * 
	 * public static final int S_OPCODE_SKILLBUY = 127;
	 */

	/*
	 * clientpackets for Episode5
	 * 
	 * public static final int C_OPCODE_REQUESTDOOR = 0;
	 * 
	 * public static final int C_OPCODE_REQUESTTITLE = 5;
	 * 
	 * public static final int C_OPCODE_REQUESTRANGEATTACK = 6;
	 * 
	 * public static final int C_OPCODE_BOARDDELETE = 8;
	 * 
	 * public static final int C_OPCODE_REQUESTPLEDGE = 9;
	 * 
	 * public static final int C_OPCODE_CHANGEHEADING = 11;
	 * 
	 * public static final int C_OPCODE_NPCACTION = 12;
	 * 
	 * public static final int C_OPCODE_ASKDISMISSPET = 12;
	 * 
	 * public static final int C_OPCODE_USESKILL = 14;
	 * 
	 * public static final int C_OPCODE_REQUESTEMBLEM = 15;
	 * 
	 * public static final int C_OPCODE_TRADEADDCANCEL = 18;
	 * 
	 * public static final int C_OPCODE_CHANGEWARTIME = 22;
	 * 
	 * public static final int C_OPCODE_BOOKMARK = 25;
	 * 
	 * public static final int C_OPCODE_CREATECLAN = 26;
	 * 
	 * public static final int C_OPCODE_CLIENTVERSION = 27;
	 * 
	 * public static final int C_OPCODE_PROPOSE = 29;
	 * 
	 * public static final int C_OPCODE_SKILLBUY = 31;
	 * 
	 * public static final int C_OPCODE_BOARDBACK = 38;
	 * 
	 * public static final int C_OPCODE_SHOP = 39;
	 * 
	 * public static final int C_OPCODE_BOARDREAD = 40;
	 * 
	 * public static final int C_OPCODE_TRADE = 42;
	 * 
	 * public static final int C_OPCODE_DELETECHAR = 48;
	 * 
	 * public static final int C_OPCODE_KEEPALIVE = 49;
	 * 
	 * public static final int C_OPCODE_REQUESTATTR = 51;
	 * 
	 * public static final int C_OPCODE_LOGINPACKET = 52;
	 * 
	 * public static final int C_OPCODE_REQUESTRESULT = 54;
	 * 
	 * public static final int C_OPCODE_DEPOSIT = 56;
	 * 
	 * public static final int C_OPCODE_LOGINTOSERVEROK = 57;
	 * 
	 * public static final int C_OPCODE_SKILLBUYOK = 58;
	 * 
	 * public static final int C_OPCODE_TRADEADDITEM = 61;
	 * 
	 * public static final int C_OPCODE_ADDBUDDY = 63;
	 * 
	 * public static final int C_OPCODE_RETURNTOLOGIN = 65;
	 * 
	 * public static final int C_OPCODE_REQUESTCHAT = 68;
	 * 
	 * public static final int C_OPCODE_TRADEADDOK = 69;
	 * 
	 * public static final int C_OPCODE_CHECKPK = 70;
	 * 
	 * public static final int C_OPCODE_TAXRATE = 74;
	 * 
	 * public static final int C_OPCODE_REQUESTCHANGECHAR = 75;
	 * 
	 * public static final int C_OPCODE_REQUESTBUDDYLIST = 76;
	 * 
	 * public static final int C_OPCODE_REQUESTDROPITEM = 77;
	 * 
	 * public static final int C_OPCODE_REQUESTLEAVEPARTY = 78;
	 * 
	 * public static final int C_OPCODE_REQUESTATTACK = 79;
	 * 
	 * public static final int C_OPCODE_QUITGAME = 81;
	 * 
	 * public static final int C_OPCODE_BANCLAN = 82;
	 * 
	 * public static final int C_OPCODE_BOARD = 84;
	 * 
	 * public static final int C_OPCODE_DELETEINVENTORYITEM = 85;
	 * 
	 * public static final int C_OPCODE_REQUESTCHATWHISPER = 86;
	 * 
	 * public static final int C_OPCODE_REQUESTPARTY = 87;
	 * 
	 * public static final int C_OPCODE_REQUESTPICKUPITEM = 88;
	 * 
	 * public static final int C_OPCODE_REQUESTWHO = 89;
	 * 
	 * public static final int C_OPCODE_GIVEITEM = 90;
	 * 
	 * public static final int C_OPCODE_REQUESTMOVECHAR = 91;
	 * 
	 * public static final int C_OPCODE_BOOKMARKDELETE = 93;
	 * 
	 * public static final int C_OPCODE_REQUESTRESTART = 94;
	 * 
	 * public static final int C_OPCODE_LEAVECLANE = 98;
	 * 
	 * public static final int C_OPCODE_NPCTALK = 100;
	 * 
	 * public static final int C_OPCODE_BANPARTY = 102;
	 * 
	 * public static final int C_OPCODE_DELBUDDY = 106;
	 * 
	 * public static final int C_OPCODE_REQUESTWAR = 109;
	 * 
	 * public static final int C_OPCODE_LOGINTOSERVER = 111;
	 * 
	 * public static final int C_OPCODE_PRIVATESHOPLIST = 113;
	 * 
	 * public static final int C_OPCODE_REQUESTCHATGLOBAL = 114;
	 * 
	 * public static final int C_OPCODE_JOINCLAN = 115;
	 * 
	 * public static final int C_OPCODE_COMMONCLICK = 117;
	 * 
	 * public static final int C_OPCODE_NEWCHAR = 118;
	 * 
	 * public static final int C_OPCODE_EXTCOMMAND = 123;
	 * 
	 * public static final int C_OPCODE_BOARDWRITE = 124;
	 * 
	 * public static final int C_OPCODE_USEITEM = 129;
	 * 
	 * public static final int C_OPCODE_CREATEPARTY = 130;
	 * 
	 * serverpackets for Episode5
	 * 
	 * public static final int S_OPCODE_TPGFX = 0;
	 * 
	 * public static final int S_OPCODE_DELETENEWOBJECT = 0;
	 * 
	 * public static final int S_OPCODE_DELETEOBJECTFROMSCREEN = 0;
	 * 
	 * public static final int S_OPCODE_KILL = 0;
	 * 
	 * public static final int S_OPCODE_UNKNOWN1 = 1;
	 * 
	 * public static final int S_OPCODE_OWNCHARSTATUS2 = 2;
	 * 
	 * public static final int S_OPCODE_CHARSTATUS = 3;
	 * 
	 * public static final int S_OPCODE_SERVERSTAT = 4;
	 * 
	 * public static final int S_OPCODE_SKILLICONSHIELD = 5;
	 * 
	 * public static final int S_OPCODE_NEWCHARWRONG = 7;
	 * 
	 * public static final int S_OPCODE_CASTLEMASTER = 8;
	 * 
	 * public static final int S_OPCODE_RESURRECTION = 9;
	 * 
	 * public static final int S_OPCODE_LAWFUL = 10;
	 * 
	 * public static final int S_OPCODE_CHARAMOUNT = 11;
	 * 
	 * public static final int S_OPCODE_LOGINRESULT = 12;
	 * 
	 * public static final int S_OPCODE_SKILLHASTE = 14;
	 * 
	 * public static final int S_OPCODE_DOACTIONGFX = 15;
	 * 
	 * public static final int S_OPCODE_NPCNORMALCHAT = 16;
	 * 
	 * public static final int S_OPCODE_CURSEBLIND = 17;
	 * 
	 * public static final int S_OPCODE_BOARD = 18;
	 * 
	 * public static final int S_OPCODE_INVLIST = 20;
	 * 
	 * public static final int S_OPCODE_INVENTORYPACK = 20;
	 * 
	 * public static final int S_OPCODE_DELETEOBJECT = 21;
	 * 
	 * public static final int S_OPCODE_HPUPDATE = 23;
	 * 
	 * public static final int S_OPCODE_SHOWPOLYLIST = 23;
	 * 
	 * public static final int S_OPCODE_BLUEMESSAGE = 24;
	 * 
	 * public static final int S_OPCODE_MAPID = 25;
	 * 
	 * public static final int S_OPCODE_UNDERWATER = 25;
	 * 
	 * public static final int S_OPCODE_POLY = 26;
	 * 
	 * public static final int S_OPCODE_WAR = 27;
	 * 
	 * public static final int S_OPCODE_CHARTITLE = 28;
	 * 
	 * public static final int S_OPCODE_NORMALCHAT = 29;
	 * 
	 * public static final int S_OPCODE_SHOWSHOPBUYLIST = 30;
	 * 
	 * public static final int S_OPCODE_MOVEOBJECT = 32;
	 * 
	 * public static final int S_OPCODE_SPMR = 33;
	 * 
	 * public static final int S_OPCODE_SERVERVERSION = 36;
	 * 
	 * public static final int S_OPCODE_EMBLEM = 37;
	 * 
	 * public static final int S_OPCODE_CHARVISUALUPDATE = 39;
	 * 
	 * public static final int S_OPCODE_DISCONNECT = 41;
	 * 
	 * public static final int S_OPCODE_TRADESTATUS = 42;
	 * 
	 * public static final int S_OPCODE_PINKNAME = 44;
	 * 
	 * public static final int S_OPCODE_BOOKMARKS = 45;
	 * 
	 * public static final int S_OPCODE_OWNCHARSTATUS = 46;
	 * 
	 * public static final int S_OPCODE_PARALYSIS = 47;
	 * 
	 * public static final int S_OPCODE_LIQUOR = 49;
	 * 
	 * public static final int S_OPCODE_DELSKILL = 50;
	 * 
	 * public static final int S_OPCODE_GLOBALCHAT = 51;
	 * 
	 * public static final int S_OPCODE_SYSMSG = 51;
	 * 
	 * public static final int S_OPCODE_BLESSOFEVA = 53;
	 * 
	 * public static final int S_OPCODE_SKILLBRAVE = 55;
	 * 
	 * public static final int S_OPCODE_DELETEMOBOBJECT = 55;
	 * 
	 * public static final int S_OPCODE_LIGHT = 56;
	 * 
	 * public static final int S_OPCODE_UNKNOWN2 = 57;
	 * 
	 * public static final int S_OPCODE_CHANGEHEADING = 57;
	 * 
	 * public static final int S_OPCODE_SERVERMSG = 59;
	 * 
	 * public static final int S_OPCODE_TRUETARGET = 60;
	 * 
	 * public static final int S_OPCODE_HPMETER = 61;
	 * 
	 * public static final int S_OPCODE_SENDITEMAMOUNTUPDATE = 62;
	 * 
	 * public static final int S_OPCODE_ADDSKILL = 63;
	 * 
	 * public static final int S_OPCODE_WARHOUSELIST = 64;
	 * 
	 * public static final int S_OPCODE_DETELECHAROK = 66;
	 * 
	 * public static final int S_OPCODE_NEWCHARPACK = 67;
	 * 
	 * public static final int S_OPCODE_CHARPACK = 68;
	 * 
	 * public static final int S_OPCODE_DROPITEM = 68;
	 * 
	 * public static final int S_OPCODE_DELETEINVENTORYITEM = 71;
	 * 
	 * public static final int S_OPCODE_POISON = 75;
	 * 
	 * public static final int S_OPCODE_CHARINVVISUALUPDATE = 79;
	 * 
	 * public static final int S_OPCODE_SHOWHTML = 81;
	 * 
	 * public static final int S_OPCODE_TPUNK1 = 81;
	 * 
	 * public static final int S_OPCODE_EXP = 81;
	 * 
	 * public static final int S_OPCODE_INVIS = 82;
	 * 
	 * public static final int S_OPCODE_DEPOSIT = 83;
	 * 
	 * public static final int S_OPCODE_WHISPERCHAT = 85;
	 * 
	 * public static final int S_OPCODE_DEXUP = 86;
	 * 
	 * public static final int S_OPCODE_MESSAGE = 87;
	 * 
	 * public static final int S_OPCODE_OWNCHARATTRDEF = 88;
	 * 
	 * public static final int S_OPCODE_AUTHSERVERTIME = 89;
	 * 
	 * public static final int S_OPCODES_ABILITY = 93;
	 * 
	 * public static final int S_OPCODE_ATTACKPACKET = 94;
	 * 
	 * public static final int S_OPCODE_ACTIVESPELLS = 96;
	 * 
	 * public static final int S_OPCODE_SHOWRETRIEVELIST = 96;
	 * 
	 * public static final int S_OPCODE_CHARLIST = 97;
	 * 
	 * public static final int S_OPCODE_BECOMEYOURPET = 100;
	 * 
	 * public static final int S_OPCODE_SHOWSELLLIST = 100;
	 * 
	 * public static final int S_OPCODE_TAXRATE = 102;
	 * 
	 * public static final int S_OPCODE_SHOWSHOPSELLLIST = 103;
	 * 
	 * public static final int S_OPCODE_SKILLBUY = 104;
	 * 
	 * public static final int S_OPCODE_SKILLSOUNDGFX = 106;
	 * 
	 * public static final int S_OPCODE_WEATHER = 108;
	 * 
	 * public static final int S_OPCODE_PRIVATESHOPLIST = 107;
	 * 
	 * public static final int S_OPCODE_GAMETIME = 109;
	 * 
	 * public static final int S_OPCODE_BOARDREAD = 110;
	 * 
	 * public static final int S_OPCODE_YES_NO = 111;
	 * 
	 * public static final int S_OPCODE_WARTIME = 113;
	 * 
	 * public static final int S_OPCODE_STRUP = 114;
	 * 
	 * public static final int S_OPCODE_USEMAP = 115;
	 * 
	 * public static final int S_OPCODE_TRADE = 119;
	 * 
	 * public static final int S_OPCODE_TRADEADDITEM = 121;
	 * 
	 * public static final int S_OPCODE_SKILLICONGFX = 123;
	 * 
	 * public static final int S_OPCODE_COMMONNEWS = 125;
	 * 
	 * public static final int S_OPCODE_MPUPDATE = 126;
	 */
}