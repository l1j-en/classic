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

import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.controllers.AuctionTimeController;
import l1j.server.server.controllers.CrackOfTimeController;
import l1j.server.server.controllers.FishingTimeController;
import l1j.server.server.controllers.HomeTownTimeController;
import l1j.server.server.controllers.HouseTaxTimeController;
import l1j.server.server.controllers.JailController;
import l1j.server.server.controllers.LightTimeController;
import l1j.server.server.controllers.LoginController;
import l1j.server.server.controllers.NpcChatTimeController;
import l1j.server.server.controllers.RankingsController;
import l1j.server.server.controllers.UbTimeController;
import l1j.server.server.controllers.WarTimeController;
import l1j.server.server.datatables.AccessLevelTable;
import l1j.server.server.datatables.CastleTable;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.ChatLogTable;
import l1j.server.server.datatables.ClanTable;
import l1j.server.server.datatables.DoorTable;
import l1j.server.server.datatables.DropItemTable;
import l1j.server.server.datatables.DropTable;
import l1j.server.server.datatables.FurnitureSpawnTable;
import l1j.server.server.datatables.GetBackRestartTable;
import l1j.server.server.datatables.IpTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.datatables.LightSpawnTable;
import l1j.server.server.datatables.MailTable;
import l1j.server.server.datatables.MapsTable;
import l1j.server.server.datatables.MobGroupTable;
import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.datatables.NpcActionTable;
import l1j.server.server.datatables.NpcChatTable;
import l1j.server.server.datatables.NpcSpawnTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.datatables.PetTypeTable;
import l1j.server.server.datatables.PolyTable;
import l1j.server.server.datatables.ResolventTable;
import l1j.server.server.datatables.ShopTable;
import l1j.server.server.datatables.SkillTable;
import l1j.server.server.datatables.SpawnTable;
import l1j.server.server.datatables.SprTable;
import l1j.server.server.datatables.UBSpawnTable;
import l1j.server.server.datatables.WeaponSkillTable;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.Dungeon;
import l1j.server.server.model.ElementalStoneGenerator;
import l1j.server.server.model.Getback;
import l1j.server.server.model.L1BossCycle;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1DeleteItemOnGround;
import l1j.server.server.model.L1NpcRegenerationTimer;
import l1j.server.server.model.L1World;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.model.item.L1TreasureBox;
import l1j.server.server.model.map.L1WorldMap;
import l1j.server.server.model.trap.L1WorldTraps;

public class GameServerThread {
	
	private static Logger _log = Logger.getLogger(GameServerThread.class.getName());

	private static GameServerThread _instance;
	private LoginController _loginController;
	private int chatlvl;

	public static GameServerThread getInstance() throws Exception {
		if (_instance == null) {
			_instance = new GameServerThread();
		}
		return _instance;
	}

	public GameServerThread() throws Exception {
		double rateXp = Config.RATE_XP;
		double LA = Config.RATE_LA;
		double rateKarma = Config.RATE_KARMA;
		double rateDropItems = Config.RATE_DROP_ITEMS;
		double rateDropAdena = Config.RATE_DROP_ADENA;
		double hpregen = Config.RATE_HP_REGEN;
		double mpregen = Config.RATE_MP_REGEN;
		double castlehp = Config.RATE_HP_CASTLE;
		double househp = Config.RATE_HP_HOUSE;
		double hotelhp = Config.RATE_HP_HOTEL;
		double motherhp = Config.RATE_HP_MOTHERTREE;
		double hpill = Config.RATE_HP_ILLUSIONISTTOWN;
		double hpdrgn = Config.RATE_HP_DRAGONKNIGHTTOWN;
		double mpcastle = Config.RATE_MP_CASTLE;
		double mphouse = Config.RATE_MP_HOUSE;
		double mphotel = Config.RATE_MP_HOTEL;
		double mpmother = Config.RATE_MP_MOTHERTREE;
		double mpill = Config.RATE_MP_ILLUSIONISTTOWN;
		double mpdrgn = Config.RATE_MP_DRAGONKNIGHTTOWN;
		chatlvl = Config.GLOBAL_CHAT_LEVEL;

		_log.config("HP-REGEN RATE              = " + hpregen);
		_log.config("MP-REGEN RATE              = " + mpregen);
		_log.config("HP-CASTLE RATE             = " + castlehp);
		_log.config("MP-CASTLE RATE             = " + mpcastle);
		_log.config("HP-HOUSE RATE              = " + househp);
		_log.config("MP-HOUSE RATE              = " + mphouse);
		_log.config("HP-HOTEL RATE              = " + hotelhp);
		_log.config("MP-HOTEL RATE              = " + mphotel);
		_log.config("HP-MOTHERTREE RATE         = " + motherhp);
		_log.config("MP-MOTHERTREE RATE         = " + mpmother);
		_log.config("HP-ILLUSIONISTTOWN RATE    = " + hpill);
		_log.config("MP-ILLUSIONISTTOWN RATE    = " + mpill);
		_log.config("HP-DRAGONKNIGHTTOWN RATE   = " + hpdrgn);
		_log.config("MP-DRAGONKNIGHTTOWN RATE   = " + mpdrgn);
		_log.config("PartyExp RATE              = "
				+ (Config.PARTYEXP_RATE));
		_log.config("PetExp RATE                = "
				+ (Config.PETEXP_RATE));
		_log.config("XP RATE                    = " + rateXp);
		_log.config("Lawful RATE                = " + LA);
		_log.config("Karma RATE                 = " + rateKarma);
		_log.config("Drop RATE                  = " + rateDropItems);
		_log.config("Adena RATE                 = " + rateDropAdena);
		_log.config("EnchantWeapon Change       = "
				+ (Config.ENCHANT_CHANCE_WEAPON) + "%");
		_log.config("EnchantArmor Change        = "
				+ (Config.ENCHANT_CHANCE_ARMOR) + "%");
		_log.config("AttrEnchant Change         = "
				+ (Config.ATTR_ENCHANT_CHANCE) + "%");
		_log.config("Global Chat LvL            = " + (chatlvl));
		_log.config("Whisper Chat LvL           = "
				+ (Config.WHISPER_CHAT_LEVEL));

		if (Config.ALT_NONPVP) { // Non-PvP Setting
			_log.config("PvP                        = On");
		} else {
			_log.config("PvP                        = Off");
		}

		// Announce Chat Cycle
		Announcecycle.getInstance();

		if (Config.Use_Show_INGAMENEWS_Time) {
			_log.config("IngameNews                 = On");
		} else {
			_log.config("InGameNews                 = Off");
		}

		System.gc();

		int maxOnlineUsers = Config.MAX_ONLINE_USERS;
		_log.config("Max online users           = " + (maxOnlineUsers));

		IdFactory.getInstance();

		L1WorldMap.getInstance();

		_loginController = LoginController.getInstance();
		_loginController.setMaxAllowedOnlinePlayers(maxOnlineUsers);
		
		//Access Levels
		AccessLevelTable.getInstance();

		// CharacterTable
		CharacterTable.getInstance().loadAllCharName();

		// Reset status online
		CharacterTable.clearOnlineStatus();

		// Game Time Clock
		L1GameTimeClock.init();

		// UB Time Controllers
		UbTimeController ubTimeContoroller = UbTimeController.getInstance();
		GeneralThreadPool.getInstance().execute(ubTimeContoroller);

		// Controllers time of war
		WarTimeController warTimeController = WarTimeController.getInstance();
		GeneralThreadPool.getInstance().execute(warTimeController);

		// Elemental stone spawn
		if (Config.ELEMENTAL_STONE_AMOUNT > 0) {
			ElementalStoneGenerator elementalStoneGenerator = ElementalStoneGenerator
					.getInstance();
			GeneralThreadPool.getInstance().execute(elementalStoneGenerator);
		}

		// Hometown
		HomeTownTimeController.getInstance();

		// Controllers auction time Hideout
		AuctionTimeController auctionTimeController = AuctionTimeController
				.getInstance();
		GeneralThreadPool.getInstance().execute(auctionTimeController);

		// HouseTax Update Controller
		HouseTaxTimeController houseTaxTimeController = HouseTaxTimeController
				.getInstance();
		GeneralThreadPool.getInstance().execute(houseTaxTimeController);

		// Fishing Time Controller
		FishingTimeController fishingTimeController = FishingTimeController
				.getInstance();
		GeneralThreadPool.getInstance().execute(fishingTimeController);

		// Npc And Monster Chat Controller
		NpcChatTimeController npcChatTimeController = NpcChatTimeController
				.getInstance();
		GeneralThreadPool.getInstance().execute(npcChatTimeController);

		// LightTime Controller
		LightTimeController lightTimeController = LightTimeController
				.getInstance();
		GeneralThreadPool.getInstance().execute(lightTimeController);
		
		// Rankings Board Controller
		RankingsController rankingsController = RankingsController.getInstance();
		GeneralThreadPool.getInstance().execute(rankingsController);
		
		// Unjail controller
		JailController jailController = JailController.getInstance();
		GeneralThreadPool.getInstance().execute(jailController);

		CrackOfTimeController.getStart();

		// AnnounceMents
		Announcements.getInstance();

		// Npc Table
		NpcTable.getInstance();

		// Delete Items On Ground
		L1DeleteItemOnGround deleteitem = new L1DeleteItemOnGround();
		deleteitem.initialize();

		if (!NpcTable.getInstance().isInitialized()) {
			throw new Exception("Could not initialize the npc table");
		}
		SpawnTable.getInstance();
		MobGroupTable.getInstance();
		SkillTable.getInstance();
		PolyTable.getInstance();
		ItemTable.getInstance();
		DropTable.getInstance();
		DropItemTable.getInstance();
		ShopTable.getInstance();
		NPCTalkDataTable.getInstance();
		L1World.getInstance();
		L1WorldTraps.getInstance();
		Dungeon.getInstance();
		NpcSpawnTable.getInstance();
		IpTable.getInstance();
		MapsTable.getInstance();
		UBSpawnTable.getInstance();
		PetTable.getInstance();
		ClanTable.getInstance();
		CastleTable.getInstance();
		L1CastleLocation.setCastleTaxRate(); // This must be after the initial
												// CastleTable
		GetBackRestartTable.getInstance();
		DoorTable.initialize();
		GeneralThreadPool.getInstance();
		L1NpcRegenerationTimer.getInstance();
		ChatLogTable.getInstance();
		WeaponSkillTable.getInstance();
		NpcActionTable.load();
		GMCommandsConfig.load();
		Getback.loadGetBack();
		PetTypeTable.load();
		L1BossCycle.load();
		L1TreasureBox.load();
		SprTable.getInstance();
		ResolventTable.getInstance();
		FurnitureSpawnTable.getInstance();
		NpcChatTable.getInstance();
		LightSpawnTable.getInstance();
		MailTable.getInstance();
		_log.config("Database tables loaded successfully!");
	}
}