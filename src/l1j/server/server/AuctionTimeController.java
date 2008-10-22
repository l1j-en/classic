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

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.TimeZone;

import l1j.server.Config;
import l1j.server.server.datatables.AuctionBoardTable;
import l1j.server.server.datatables.ClanTable;
import l1j.server.server.datatables.HouseTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.L1ItemId;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.storage.CharactersItemStorage;
import l1j.server.server.templates.L1AuctionBoard;
import l1j.server.server.templates.L1House;

public class AuctionTimeController implements Runnable 
 {
	private static Logger _log = Logger.getLogger(AuctionTimeController.class.getName());
	private static AuctionTimeController _instance;
	public static AuctionTimeController getInstance() {
		if (_instance == null) {
			_instance = new AuctionTimeController();
		}
		return _instance;
	}

	@Override
	public void run() {
		try {
			while (true) {
				checkAuctionDeadline();
				Thread.sleep(60000);
			}
		} catch (Exception e1) {
		}
	}

	public Calendar getRealTime() {
		TimeZone tz = TimeZone.getTimeZone(Config.TIME_ZONE);
		Calendar cal = Calendar.getInstance(tz);
		return cal;
	}

	private void checkAuctionDeadline() {
		AuctionBoardTable boardTable = new AuctionBoardTable();
		for (L1AuctionBoard board : boardTable.getAuctionBoardTableList()) {
			if (board.getDeadline().before(getRealTime())) {
				endAuction(board);
			}
		}
	}

	private void endAuction(L1AuctionBoard board) {
		int houseId = board.getHouseId();
		int price = board.getPrice();
		int oldOwnerId = board.getOldOwnerId();
		String bidder = board.getBidder();
		int bidderId = board.getBidderId();

		if (oldOwnerId != 0 && bidderId != 0) { // Previously, the successful bidder with owner
			L1PcInstance oldOwnerPc = (L1PcInstance) L1World.getInstance()
					.findObject(oldOwnerId);
			int payPrice = (int) (price * 0.9);
			if (oldOwnerPc != null) { // The previous owner online
				oldOwnerPc.getInventory().storeItem(L1ItemId.ADENA, payPrice);
				// Your house was owned by the Adena 1 percent in the final bid price. %n
				// Commission, excluding the remaining 10% percent of the amount of Adena 0% response. %n Thank you. %n%n
				oldOwnerPc.sendPackets(new S_ServerMessage(527, String.valueOf(payPrice)));
			} else { // During the previous owner is offline
				L1ItemInstance item = ItemTable.getInstance().createItem(L1ItemId.ADENA);
				item.setCount(payPrice);
				try {
					CharactersItemStorage storage = CharactersItemStorage.create();
					storage.storeItem(oldOwnerId, item);
				} catch (Exception e) {
					_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			}

			L1PcInstance bidderPc = (L1PcInstance) L1World.getInstance()
					.findObject(bidderId);
			if (bidderPc != null) { // A successful bidder online
				// Congratulations. %n You are joining in the final auction price %0 Adena bid price. %n
				// We like to buy a house that was immediately available. %n Thank you.%n%n
				bidderPc.sendPackets(new S_ServerMessage(524, String
						.valueOf(price), bidder));
			}
			deleteHouseInfo(houseId);
			setHouseInfo(houseId, bidderId);
			deleteNote(houseId);
		} else if (oldOwnerId == 0 && bidderId != 0) { // None of the previous owner and successful bidder
			L1PcInstance bidderPc = (L1PcInstance) L1World.getInstance()
					.findObject(bidderId);
			if (bidderPc != null) { // A successful bidder online
				// Congratulations. %n You are joining in the final auction price %0 Adena bid price. %n
				// We like to buy a house that was immediately available. %n Thank you. %n%n
				bidderPc.sendPackets(new S_ServerMessage(524, String
						.valueOf(price), bidder));
			}
			setHouseInfo(houseId, bidderId);
			deleteNote(houseId);
		} else if (oldOwnerId != 0 && bidderId == 0) { // Previously, the successful bidder without owner
			L1PcInstance oldOwnerPc = (L1PcInstance) L1World.getInstance()
					.findObject(oldOwnerId);
			if (oldOwnerPc != null) { // The previous owner online
				// You did you apply for the auction, the auction period, more than the amount offered to pay for it is expressed, in the end cancelled. %n
				// Therefore, ownership is returned to inform you. %n Thank you. %n%n
				oldOwnerPc.sendPackets(new S_ServerMessage(528));
			}
			deleteNote(houseId);
		} else if (oldOwnerId == 0 && bidderId == 0) { // None of the previous owner without winning bidder
			// Five days after a deadline set to re-auction
			Calendar cal = getRealTime();
			cal.add(Calendar.DATE, 5); // After 5, 2007
			cal.set(Calendar.MINUTE, 0); // Minutes and seconds are truncated
			cal.set(Calendar.SECOND, 0);
			board.setDeadline(cal);
			AuctionBoardTable boardTable = new AuctionBoardTable();
			boardTable.updateAuctionBoard(board);
		}
	}
	/**
	 * The previous owner put out a safe house
	 * 
	 * @param houseId
	 * 
	 * @return
	 */
	private void deleteHouseInfo(int houseId) {
		for (L1Clan clan : L1World.getInstance().getAllClans()) {
			if (clan.getHouseId() == houseId) {
				clan.setHouseId(0);
				ClanTable.getInstance().updateClan(clan);
			}
		}
	}
	/**
	 * To set the winning bidder's Hideout
	 * 
	 * @param houseId
	 *            bidderId
	 * 
	 * @return
	 */
	private void setHouseInfo(int houseId, int bidderId) {
		for (L1Clan clan : L1World.getInstance().getAllClans()) {
			if (clan.getLeaderId() == bidderId) {
				clan.setHouseId(houseId);
				ClanTable.getInstance().updateClan(clan);
				break;
			}
		}
	}
	/**
	 * Hideout auction set to OFF state, and disappear from BBS auction
	 * 
	 * @param houseId
	 * 
	 * @return
	 */
	private void deleteNote(int houseId) {
		// Hideout state auction set to OFF
		L1House house = HouseTable.getInstance().getHouseTable(houseId);
		house.setOnSale(false);
		Calendar cal = getRealTime();
		cal.add(Calendar.DATE, Config.HOUSE_TAX_INTERVAL);
		cal.set(Calendar.MINUTE, 0); 
		cal.set(Calendar.SECOND, 0);
		house.setTaxDeadline(cal);
		HouseTable.getInstance().updateHouse(house);

		// BBS disappear from public auction
		AuctionBoardTable boardTable = new AuctionBoardTable();
		boardTable.deleteAuctionBoard(houseId);
	}
}
