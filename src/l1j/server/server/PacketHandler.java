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
package l1j.server.server;

import static l1j.server.server.encryptions.Opcodes.C_OPCODE_ADDBUDDY;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_AMOUNT;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_ARROWATTACK;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_ATTACK;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_ATTR;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_BANCLAN;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_BANPARTY;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_BOARD;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_BOARDBACK;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_BOARDDELETE;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_BOARDREAD;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_BOARDWRITE;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_BOOKMARK;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_BOOKMARKDELETE;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_BUDDYLIST;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CAHTPARTY;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CALL;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CHANGECHAR;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CHANGEHEADING;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CHANGEWARTIME;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CHARACTERCONFIG;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CHARRESET;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CHAT;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CHATGLOBAL;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CHATWHISPER;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CHECKPK;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CLAN;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CLIENTVERSION;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_COMMONCLICK;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CREATECLAN;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_CREATEPARTY;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_DELBUDDY;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_DELETECHAR;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_DELETEINVENTORYITEM;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_DEPOSIT;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_DOOR;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_DRAWAL;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_DROPITEM;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_EMBLEM;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_ENTERPORTAL;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_EXCLUDE;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_EXIT_GHOST;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_EXTCOMMAND;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_FIGHT;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_FISHCLICK;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_FIX_WEAPON_LIST;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_GIVEITEM;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_HIRESOLDIER;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_JOINCLAN;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_KEEPALIVE;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_LEAVECLANE;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_LEAVEPARTY;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_LOGINPACKET;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_LOGINTOSERVER;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_LOGINTOSERVEROK;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_MAIL;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_MOVECHAR;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_NEWCHAR;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_NPCACTION;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_NPCTALK;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_PARTY;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_PETMENU;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_PICKUPITEM;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_PLEDGE;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_PRIVATESHOPLIST;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_PROPOSE;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_QUITGAME;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_RANK;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_RESTART;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_RESULT;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_RETURNTOLOGIN;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_SELECTLIST;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_SELECTTARGET;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_SHIP;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_SHOP;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_SKILLBUY;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_SKILLBUYOK;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_TAXRATE;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_TELEPORT;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_TITLE;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_TRADE;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_TRADEADDCANCEL;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_TRADEADDITEM;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_TRADEADDOK;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_USEITEM;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_USEPETITEM;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_USESKILL;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_WAR;
import static l1j.server.server.encryptions.Opcodes.C_OPCODE_WHO;

import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.clientpackets.C_AddBookmark;
import l1j.server.server.clientpackets.C_AddBuddy;
import l1j.server.server.clientpackets.C_Amount;
import l1j.server.server.clientpackets.C_Attack;
import l1j.server.server.clientpackets.C_Attr;
import l1j.server.server.clientpackets.C_AuthLogin;
import l1j.server.server.clientpackets.C_BanClan;
import l1j.server.server.clientpackets.C_BanParty;
import l1j.server.server.clientpackets.C_Board;
import l1j.server.server.clientpackets.C_BoardBack;
import l1j.server.server.clientpackets.C_BoardDelete;
import l1j.server.server.clientpackets.C_BoardRead;
import l1j.server.server.clientpackets.C_BoardWrite;
import l1j.server.server.clientpackets.C_Buddy;
import l1j.server.server.clientpackets.C_CallPlayer;
import l1j.server.server.clientpackets.C_ChangeHeading;
import l1j.server.server.clientpackets.C_ChangeWarTime;
import l1j.server.server.clientpackets.C_CharReset;
import l1j.server.server.clientpackets.C_CharcterConfig;
import l1j.server.server.clientpackets.C_Chat;
import l1j.server.server.clientpackets.C_ChatParty;
import l1j.server.server.clientpackets.C_ChatWhisper;
import l1j.server.server.clientpackets.C_CheckPK;
import l1j.server.server.clientpackets.C_Clan;
import l1j.server.server.clientpackets.C_CommonClick;
import l1j.server.server.clientpackets.C_CreateChar;
import l1j.server.server.clientpackets.C_CreateClan;
import l1j.server.server.clientpackets.C_CreateParty;
import l1j.server.server.clientpackets.C_DelBuddy;
import l1j.server.server.clientpackets.C_DeleteBookmark;
import l1j.server.server.clientpackets.C_DeleteChar;
import l1j.server.server.clientpackets.C_DeleteInventoryItem;
import l1j.server.server.clientpackets.C_Deposit;
import l1j.server.server.clientpackets.C_Disconnect;
import l1j.server.server.clientpackets.C_Door;
import l1j.server.server.clientpackets.C_Drawal;
import l1j.server.server.clientpackets.C_DropItem;
import l1j.server.server.clientpackets.C_Emblem;
import l1j.server.server.clientpackets.C_EnterPortal;
import l1j.server.server.clientpackets.C_Exclude;
import l1j.server.server.clientpackets.C_ExitGhost;
import l1j.server.server.clientpackets.C_ExtraCommand;
import l1j.server.server.clientpackets.C_Fight;
import l1j.server.server.clientpackets.C_FishClick;
import l1j.server.server.clientpackets.C_FixWeaponList;
import l1j.server.server.clientpackets.C_GiveItem;
import l1j.server.server.clientpackets.C_HireSoldier;
import l1j.server.server.clientpackets.C_ItemUSe;
import l1j.server.server.clientpackets.C_JoinClan;
import l1j.server.server.clientpackets.C_KeepALIVE;
import l1j.server.server.clientpackets.C_LeaveClan;
import l1j.server.server.clientpackets.C_LeaveParty;
import l1j.server.server.clientpackets.C_LoginToServer;
import l1j.server.server.clientpackets.C_LoginToServerOK;
import l1j.server.server.clientpackets.C_Mail;
import l1j.server.server.clientpackets.C_MoveChar;
import l1j.server.server.clientpackets.C_NPCAction;
import l1j.server.server.clientpackets.C_NPCTalk;
import l1j.server.server.clientpackets.C_NewCharSelect;
import l1j.server.server.clientpackets.C_Party;
import l1j.server.server.clientpackets.C_PetMenu;
import l1j.server.server.clientpackets.C_PickUpItem;
import l1j.server.server.clientpackets.C_Pledge;
import l1j.server.server.clientpackets.C_Propose;
import l1j.server.server.clientpackets.C_Rank;
import l1j.server.server.clientpackets.C_Restart;
import l1j.server.server.clientpackets.C_Result;
import l1j.server.server.clientpackets.C_ReturnToLogin;
import l1j.server.server.clientpackets.C_SelectList;
import l1j.server.server.clientpackets.C_SelectTarget;
import l1j.server.server.clientpackets.C_ServerVersion;
import l1j.server.server.clientpackets.C_Ship;
import l1j.server.server.clientpackets.C_Shop;
import l1j.server.server.clientpackets.C_ShopList;
import l1j.server.server.clientpackets.C_SkillBuy;
import l1j.server.server.clientpackets.C_SkillBuyOK;
import l1j.server.server.clientpackets.C_TaxRate;
import l1j.server.server.clientpackets.C_Teleport;
import l1j.server.server.clientpackets.C_Title;
import l1j.server.server.clientpackets.C_Trade;
import l1j.server.server.clientpackets.C_TradeAddItem;
import l1j.server.server.clientpackets.C_TradeCancel;
import l1j.server.server.clientpackets.C_TradeOK;
import l1j.server.server.clientpackets.C_UsePetItem;
import l1j.server.server.clientpackets.C_UseSkill;
import l1j.server.server.clientpackets.C_War;
import l1j.server.server.clientpackets.C_Who;
import l1j.server.server.datatables.LogPacketsTable;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.ByteArrayUtil;
import l1j.server.server.utils.IntArrayUtil;

// Referenced classes of package l1j.server.server:
// Opcodes, LoginController, ClientThread, Logins
public class PacketHandler {
	private static Logger _log = Logger
			.getLogger(PacketHandler.class.getName());
	private final ClientThread _client;

	public PacketHandler(ClientThread clientthread) {
		_client = clientthread;
	}

	public void handlePacket(byte abyte0[], L1PcInstance object)
			throws Exception {
		int i = abyte0[0] & 0xff;
		if (Config.LOGGING_INCOMING_PACKETS) {
			_log.info("Packet sent from client: " + i);
			if (_client.getActiveChar() != null) {
				if (_client.getActiveChar().isGm()) {
					_client.getActiveChar().sendPackets(
							new S_SystemMessage("Sent from client: " + i));
				}
			}
		}
		
		if(object != null && object.isLoggingPackets()) {
			String packet = IntArrayUtil.toCsv(ByteArrayUtil.convertToInt(abyte0));
			LogPacketsTable.storeLogPacket(object.getId(), object.getName(), object.getTempCharGfx(), i, packet);
		}
		
		switch (i) {
		case C_OPCODE_EXCLUDE:
			new C_Exclude(abyte0, _client);
			break;
		case C_OPCODE_CHARACTERCONFIG:
			new C_CharcterConfig(abyte0, _client);
			break;
		case C_OPCODE_DOOR:
			new C_Door(abyte0, _client);
			break;
		case C_OPCODE_TITLE:
			new C_Title(abyte0, _client);
			break;
		case C_OPCODE_BOARDDELETE:
			new C_BoardDelete(abyte0, _client);
			break;
		case C_OPCODE_PLEDGE:
			new C_Pledge(abyte0, _client);
			break;
		case C_OPCODE_CHANGEHEADING:
			new C_ChangeHeading(abyte0, _client);
			break;
		case C_OPCODE_NPCACTION:
			new C_NPCAction(abyte0, _client);
			break;
		case C_OPCODE_USESKILL:
			new C_UseSkill(abyte0, _client);
			break;
		case C_OPCODE_EMBLEM:
			new C_Emblem(abyte0, _client);
			break;
		case C_OPCODE_TRADEADDCANCEL:
			new C_TradeCancel(abyte0, _client);
			break;
		case C_OPCODE_CHANGEWARTIME:
			new C_ChangeWarTime(abyte0, _client);
			break;
		case C_OPCODE_BOOKMARK:
			new C_AddBookmark(abyte0, _client);
			break;
		case C_OPCODE_CREATECLAN:
			new C_CreateClan(abyte0, _client);
			break;
		case C_OPCODE_CLIENTVERSION:
			new C_ServerVersion(abyte0, _client);
			break;
		case C_OPCODE_PROPOSE:
			new C_Propose(abyte0, _client);
			break;
		case C_OPCODE_SKILLBUY:
			new C_SkillBuy(abyte0, _client);
			break;
		case C_OPCODE_BOARDBACK:
			new C_BoardBack(abyte0, _client);
			break;
		case C_OPCODE_SHOP:
			new C_Shop(abyte0, _client);
			break;
		case C_OPCODE_BOARDREAD:
			new C_BoardRead(abyte0, _client);
			break;
		case C_OPCODE_TRADE:
			new C_Trade(abyte0, _client);
			break;
		case C_OPCODE_DELETECHAR:
			new C_DeleteChar(abyte0, _client);
			break;
		case C_OPCODE_KEEPALIVE:
			new C_KeepALIVE(abyte0, _client);
			break;
		case C_OPCODE_ATTR:
			new C_Attr(abyte0, _client);
			break;
		case C_OPCODE_LOGINPACKET:
			new C_AuthLogin(abyte0, _client);
			break;
		case C_OPCODE_RESULT:
			new C_Result(abyte0, _client);
			break;
		case C_OPCODE_DEPOSIT:
			new C_Deposit(abyte0, _client);
			break;
		case C_OPCODE_DRAWAL:
			new C_Drawal(abyte0, _client);
			break;
		case C_OPCODE_LOGINTOSERVEROK:
			new C_LoginToServerOK(abyte0, _client);
			break;
		case C_OPCODE_SKILLBUYOK:
			new C_SkillBuyOK(abyte0, _client);
			break;
		case C_OPCODE_TRADEADDITEM:
			new C_TradeAddItem(abyte0, _client);
			break;
		case C_OPCODE_ADDBUDDY:
			new C_AddBuddy(abyte0, _client);
			break;
		case C_OPCODE_RETURNTOLOGIN:
			new C_ReturnToLogin(abyte0, _client);
			break;
		case C_OPCODE_CHAT:
			new C_Chat(abyte0, _client);
			break;
		case C_OPCODE_TRADEADDOK:
			new C_TradeOK(abyte0, _client);
			break;
		case C_OPCODE_CHECKPK:
			new C_CheckPK(abyte0, _client);
			break;
		case C_OPCODE_TAXRATE:
			new C_TaxRate(abyte0, _client);
			break;
		case C_OPCODE_CHANGECHAR:
			new C_NewCharSelect(abyte0, _client);
			new C_CommonClick(_client);
			break;
		case C_OPCODE_BUDDYLIST:
			new C_Buddy(abyte0, _client);
			break;
		case C_OPCODE_DROPITEM:
			new C_DropItem(abyte0, _client);
			break;
		case C_OPCODE_LEAVEPARTY:
			new C_LeaveParty(abyte0, _client);
			break;
		case C_OPCODE_ATTACK:
		case C_OPCODE_ARROWATTACK:
			new C_Attack(abyte0, _client);
			break;
		case C_OPCODE_QUITGAME:
			new C_Disconnect(abyte0, _client);
			break;
		case C_OPCODE_BANCLAN:
			new C_BanClan(abyte0, _client);
			break;
		case C_OPCODE_BOARD:
			new C_Board(abyte0, _client);
			break;
		case C_OPCODE_DELETEINVENTORYITEM:
			new C_DeleteInventoryItem(abyte0, _client);
			break;
		case C_OPCODE_CHATWHISPER:
			new C_ChatWhisper(abyte0, _client);
			break;
		case C_OPCODE_PARTY:
			new C_Party(abyte0, _client);
			break;
		case C_OPCODE_PICKUPITEM:
			new C_PickUpItem(abyte0, _client);
			break;
		case C_OPCODE_WHO:
			new C_Who(abyte0, _client);
			break;
		case C_OPCODE_GIVEITEM:
			new C_GiveItem(abyte0, _client);
			break;
		case C_OPCODE_MOVECHAR:
			new C_MoveChar(abyte0, _client);
			break;
		case C_OPCODE_BOOKMARKDELETE:
			new C_DeleteBookmark(abyte0, _client);
			break;
		case C_OPCODE_RESTART:
			new C_Restart(abyte0, _client);
			break;
		case C_OPCODE_LEAVECLANE:
			new C_LeaveClan(abyte0, _client);
			break;
		case C_OPCODE_NPCTALK:
			new C_NPCTalk(abyte0, _client);
			break;
		case C_OPCODE_BANPARTY:
			new C_BanParty(abyte0, _client);
			break;
		case C_OPCODE_DELBUDDY:
			new C_DelBuddy(abyte0, _client);
			break;
		case C_OPCODE_WAR:
			new C_War(abyte0, _client);
			break;
		case C_OPCODE_LOGINTOSERVER:
			new C_LoginToServer(abyte0, _client);
			break;
		case C_OPCODE_PRIVATESHOPLIST:
			new C_ShopList(abyte0, _client);
			break;
		case C_OPCODE_CHATGLOBAL:
			new C_Chat(abyte0, _client);
			break;
		case C_OPCODE_JOINCLAN:
			new C_JoinClan(abyte0, _client);
			break;
		case C_OPCODE_COMMONCLICK:
			new C_CommonClick(_client);
			break;
		case C_OPCODE_NEWCHAR:
			new C_CreateChar(abyte0, _client);
			break;
		case C_OPCODE_EXTCOMMAND:
			new C_ExtraCommand(abyte0, _client);
			break;
		case C_OPCODE_BOARDWRITE:
			new C_BoardWrite(abyte0, _client);
			break;
		case C_OPCODE_USEITEM:
			new C_ItemUSe(abyte0, _client);
			break;
		case C_OPCODE_CREATEPARTY:
			new C_CreateParty(abyte0, _client);
			break;
		case C_OPCODE_ENTERPORTAL:
			new C_EnterPortal(abyte0, _client);
			break;
		case C_OPCODE_AMOUNT:
			new C_Amount(abyte0, _client);
			break;
		case C_OPCODE_FIX_WEAPON_LIST:
			new C_FixWeaponList(abyte0, _client);
			break;
		case C_OPCODE_SELECTLIST:
			new C_SelectList(abyte0, _client);
			break;
		case C_OPCODE_EXIT_GHOST:
			new C_ExitGhost(abyte0, _client);
			break;
		case C_OPCODE_CALL:
			new C_CallPlayer(abyte0, _client);
			break;
		case C_OPCODE_HIRESOLDIER:
			new C_HireSoldier(abyte0, _client);
			break;
		case C_OPCODE_FISHCLICK:
			new C_FishClick(abyte0, _client);
			break;
		case C_OPCODE_SELECTTARGET:
			new C_SelectTarget(abyte0, _client);
			break;
		case C_OPCODE_PETMENU:
			new C_PetMenu(abyte0, _client);
			break;
		case C_OPCODE_USEPETITEM:
			new C_UsePetItem(abyte0, _client);
			break;
		case C_OPCODE_TELEPORT:
			new C_Teleport(abyte0, _client);
			break;
		case C_OPCODE_RANK:
			new C_Rank(abyte0, _client);
			break;
		case C_OPCODE_CAHTPARTY:
			new C_ChatParty(abyte0, _client);
			break;
		case C_OPCODE_FIGHT:
			new C_Fight(abyte0, _client);
			break;
		case C_OPCODE_SHIP:
			new C_Ship(abyte0, _client);
			break;
		case C_OPCODE_MAIL:
			new C_Mail(abyte0, _client);
			break;
		case C_OPCODE_CHARRESET:
			new C_CharReset(abyte0, _client);
			break;
		case C_OPCODE_CLAN:
			new C_Clan(abyte0, _client);
			break;
		default:
			// String s = Integer.toHexString(abyte0[0] & 0xff);
			// _log.warning("");
			// _log.warning((new StringBuilder()).append("").append(s)
			// .toString());
			// _log.warning(new ByteArrayUtil(abyte0).dumpToString());
			break;
		}
	}
}