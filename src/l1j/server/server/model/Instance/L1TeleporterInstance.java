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

package l1j.server.server.model.Instance;

import java.util.Random;
import java.util.logging.Logger;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.controllers.dungeon.GiranPrisonController;
import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.L1Quest;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.npc.L1NpcHtml;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.templates.L1Npc;

// Referenced classes of package l1j.server.server.model:
// L1NpcInstance, L1Teleport, L1NpcTalkData, L1PcInstance,
// L1TeleporterPrices, L1TeleportLocations

public class L1TeleporterInstance extends L1NpcInstance {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public L1TeleporterInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void onAction(L1PcInstance player) {
		L1Attack attack = new L1Attack(player, this);
		attack.calcHit();
		attack.addPcPoisonAttack(player, this);
		attack.action();
	}

	@Override
	public void onTalkAction(L1PcInstance player) {
		int objid = getId();
		L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(
				getNpcTemplate().get_npcId());
		int npcid = getNpcTemplate().get_npcId();
		L1Quest quest = player.getQuest();
		String htmlid = null;

		if (talking != null) {
			if (npcid == 50014) {
				if (player.isWizard()) {
					if (quest.get_step(L1Quest.QUEST_LEVEL30) == 1
							&& !player.getInventory().checkItem(40579)) {
						htmlid = "dilong1";
					} else {
						htmlid = "dilong3";
					}
				}
			} else if (npcid == 70779) {
				if (player.getTempCharGfx() == 1037) {
					htmlid = "ants3";
				} else if (player.getTempCharGfx() == 1039) {
					if (player.isCrown()) {
						if (quest.get_step(L1Quest.QUEST_LEVEL30) == 1) {
							if (player.getInventory().checkItem(40547)) {
								htmlid = "antsn";
							} else {
								htmlid = "ants1";
							}
						} else {
							htmlid = "antsn";
						}
					} else {
						htmlid = "antsn";
					}
				}
			} else if (npcid == 70853) {
				if (player.isElf()) {
					if (quest.get_step(L1Quest.QUEST_LEVEL30) == 1) {
						if (!player.getInventory().checkItem(40592)) {
							Random random = new Random();
							if (random.nextInt(100) < 50) {
								htmlid = "fairyp2";
							} else {
								htmlid = "fairyp1";
							}
						}
					}
				}
			} else if (npcid == 50031) {
				if (player.isElf()) {
					if (quest.get_step(L1Quest.QUEST_LEVEL45) == 2) {
						if (!player.getInventory().checkItem(40602)) {
							htmlid = "sepia1";
						}
					}
				}
			} else if (npcid == 50043) {
				if (quest.get_step(L1Quest.QUEST_LEVEL50) == L1Quest.QUEST_END) {
					htmlid = "ramuda2";
				} else if (quest.get_step(L1Quest.QUEST_LEVEL50) == 1) {
					if (player.isCrown()) {
						if (_isNowDely) {
							htmlid = "ramuda4";
						} else {
							htmlid = "ramudap1";
						}
					} else {
						htmlid = "ramuda1";
					}
				} else {
					htmlid = "ramuda3";
				}
			} else if (npcid == 50082) {
				if (player.getLevel() < 13) {
					htmlid = "en0221";
				} else {
					if (player.isElf()) {
						htmlid = "en0222e";
					} else if (player.isDarkelf()) {
						htmlid = "en0222d";
					} else {
						htmlid = "en0222";
					}
				}
			} else if (npcid == 50001) {
				if (player.isElf()) {
					htmlid = "barnia3";
				} else if (player.isKnight() || player.isCrown()) {
					htmlid = "barnia2";
				} else if (player.isWizard() || player.isDarkelf()) {
					htmlid = "barnia1";
				}
			} else if (npcid == 50055) {
				if (player.getLevel() < 15) {
					htmlid = "drist2";
				} else {
					htmlid = "drist1";
				}
			} else if (npcid == 81258) {
				if (player.isIllusionist()) {
					htmlid = "asha1";
				} else {
					htmlid = "asha2";
				}
			} else if (npcid == 81259) {
				if (player.isDragonKnight()) {
					htmlid = "feaena1";
				} else {
					htmlid = "feaena2";
				}
			} else if (npcid == 71013) {
				if (player.isDarkelf()) {
					if (player.getLevel() < 14) {
						htmlid = "karen1";
					} else {
						htmlid = "karen4";
					}
				} else {
					htmlid = "karen2";
				}
			}
			if (htmlid != null) {
				player.sendPackets(new S_NPCTalkReturn(objid, htmlid));
			} else {
				if (player.getLawful() < -1000) {
					player.sendPackets(new S_NPCTalkReturn(talking, objid, 2));
				} else {
					player.sendPackets(new S_NPCTalkReturn(talking, objid, 1));
				}
			}
		} else {
			_log.finest((new StringBuilder())
					.append("No actions for npc id : ").append(objid)
					.toString());
		}
	}

	@Override
	public void onFinalAction(L1PcInstance player, String action) {
		int objid = getId();
		L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(
				getNpcTemplate().get_npcId());
		String[] price = null;
		if (action.equalsIgnoreCase("teleportURL")) {
			L1NpcHtml html = new L1NpcHtml(talking.getTeleportURL());
			int npcid = getNpcTemplate().get_npcId();
			switch (npcid) {
			case 50015: {
				price = new String[] { "1500" };
			}
				break;
			case 50020: {
				price = new String[] { "55", "55", "55", "180", "180", "180",
						"180", "270", "270", "300", "300", "900", "10650" };
			}
				break;
			case 50024: {
				price = new String[] { "55", "55", "55", "55", "198", "55",
						"132", "264", "55", "198", "264", "220", "220", "550",
						"7480" };
			}
				break;
			case 50036: {
				price = new String[] { "55", "55", "55", "180", "180", "180",
						"180", "270", "270", "450", "450", "1050", "11100" };
			}
				break;
			case 50039: {
				price = new String[] { "55", "55", "180", "180", "270", "270",
						"270", "360", "360", "600", "600", "1200", "11550" };
			}
				break;
			case 50044: {
				price = new String[] { "50", "120", "120", "180", "180", "180",
						"240", "240", "300", "500", "500", "900", "7400" };
			}
				break;
			case 50046: {
				price = new String[] { "50", "120", "120", "120", "180", "180",
						"180", "240", "300", "500", "500", "900", "7400" };
			}
				break;
			case 50051: {
				price = new String[] { "55", "180", "270", "270", "360", "360",
						"360", "450", "450", "750", "750", "1350", "12000" };
			}
				break;
			case 50054: {
				price = new String[] { "55", "55", "55", "180", "180", "270",
						"270", "360", "450", "300", "300", "750", "9750" };
			}
				break;
			case 50056: {
				price = new String[] { "55", "55", "55", "132", "132", "132",
						"198", "198", "880", "880", "264", "330", "330", "880",
						"7480" };
			}
				break;
			case 50066: {
				price = new String[] { "55", "55", "55", "132", "132", "132",
						"198", "198", "264", "440", "440", "880", "7810" };
			}
				break;
			case 50068: {
				price = new String[] { "1500", "800", "600", "1800", "1800",
						"1000" };
			}
				break;
			case 50026: {
				price = new String[] { "550", "700", "810" };
			}
				break;
			case 50033: {
				price = new String[] { "560", "720", "560" };
			}
				break;
			case 50049: {
				price = new String[] { "1150", "980", "590" };
			}
				break;
			case 50059: {
				price = new String[] { "580", "680", "680" };
			}
				break;
			case 50072: {
				price = new String[] { "2200", "1800", "1000", "1600", "2200",
						"1200", "1300", "2000", "2000", "500", "500", "700",
						"650", "700", "800", "800", "1000" };
			}
				break;
			case 50073: {
				price = new String[] { "2200", "1800", "1000", "1600", "2200",
						"1200", "1300", "0", "2000", "2000" };
			}
				break;
			case 50079: {
				price = new String[] { "550", "550", "600", "550", "700",
						"600", "600", "750", "750", "500", "500", "700", "650",
						"700", "800", "800", "1000" };
			}
				break;
			case 50080: {
				price = new String[] { "15" };
			}
				break;
			case 71039: {
				price = new String[] { "10000" };
			}
				break;
			case 71078: {
				price = new String[] { "10000" };
			}
				break;
			case 71080: {
				price = new String[] { "10000" };
			}
				break;
			case 80132: {
				price = new String[] { "132", "55", "55", "55", "132", "132",
						"132", "132", "198", "198", "246", "330", "330", "770",
						"7480" };
			}
				break;
			case 80146: {
				price = new String[] { "132", "55", "55", "55", "132", "132",
						"132", "198", "198", "300", "246", "330", "330", "770",
						"7480" };
			}
				break;
			default: {
				price = new String[] { "" };
			}
			}
			player.sendPackets(new S_NPCTalkReturn(objid, html, price));
		} else if (action.equalsIgnoreCase("teleportURLA")) {
			String html = "";
			int npcid = getNpcTemplate().get_npcId();
			switch (npcid) {
			case 50020: {
				html = "telekent3";
				price = new String[] { "150", "330", "330", "330", "330",
						"330", "495", "495", "495", "660", "660" };
			}
				break;
			case 50024: {
				html = "telegludin3";
				price = new String[] { "140", "308", "308", "308", "462",
						"462", "462", "462", "616", "770", "770" };
			}
				break;
			case 50036: {
				html = "telegiran3";
				price = new String[] { "150", "150", "150", "330", "330",
						"330", "330", "495", "495", "495", "660" };
			}
				break;
			case 50039: {
				html = "televala3";
				price = new String[] { "150", "330", "330", "330", "495",
						"495", "495", "495", "495", "660", "660" };
			}
				break;
			case 50044: {
				html = "sirius3";
				price = new String[] { "100", "220", "220", "220", "330",
						"330", "440", "440", "550", "550", "550" };
			}
				break;
			case 50051: {
				html = "kirius3";
				price = new String[] { "150", "330", "495", "495", "495",
						"660", "660", "825", "825", "825", "825" };
			}
				break;
			case 50046: {
				html = "elleris3";
				price = new String[] { "100", "220", "220", "220", "330",
						"330", "440", "440", "550", "550", "550" };
			}
				break;
			case 50054: {
				html = "telewoods3";
				price = new String[] { "150", "150", "330", "330", "495",
						"495", "495", "495", "660", "825", "825" };
			}
				break;
			case 50056: {
				html = "telesilver3";
				price = new String[] { "150", "150", "330", "330", "330",
						"330", "495", "495", "495", "495", "495" };
			}
				break;
			case 50066: {
				html = "teleheine3";
				price = new String[] { "110", "110", "242", "242", "242",
						"242", "363", "363", "484", "484", "605" };
			}
				break;
			case 80132: {
				html = "dekabia3";
				price = new String[] { "100", "220", "220", "220", "330",
						"330", "330", "330", "440", "440" };
			}
				break;
			case 80146: {
				html = "sharial3";
				price = new String[] { "220", "330", "330", "330", "440",
						"440", "550", "550", "550", "550" };
			}
				break;
			default: {
				price = new String[] { "" };
			}
			}
			player.sendPackets(new S_NPCTalkReturn(objid, html, price));
		} else if (action.equalsIgnoreCase("teleportURLA")) {
			L1NpcHtml html = new L1NpcHtml(talking.getTeleportURLA());
			player.sendPackets(new S_NPCTalkReturn(objid, html));
		} else if (action.equalsIgnoreCase("teleportURLC")) {
			String htmlid = "guide_1_2";
			price = new String[] { "403", "403", "403", "403", "923", "923" };
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, price));
		} else if (action.equalsIgnoreCase("teleportURLB")) {
			String htmlid = "guide_1_1";
			price = new String[] { "390", "390", "390", "390" };
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, price));
		} else if (action.equalsIgnoreCase("teleportURLD")) {
			String htmlid = "guide_1_3";
			price = new String[] { "480", "480", "480", "480", "630", "1080",
					"630" };
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, price));
		} else if (action.equalsIgnoreCase("teleportURLF")) {
			String htmlid = "guide_2_2";
			price = new String[] { "533", "533", "793", "663" };
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, price));
		} else if (action.equalsIgnoreCase("teleportURLE")) {
			String htmlid = "guide_2_1";
			price = new String[] { "600", "600", "750", "750" };
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, price));
		} else if (action.equalsIgnoreCase("teleportURLG")) {
			String htmlid = "guide_2_3";
			price = new String[] { "630", "780", "630", "1080", "930" };
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, price));
		} else if (action.equalsIgnoreCase("teleportURLI")) {
			String htmlid = "guide_3_2";
			price = new String[] { "663", "663", "663", "663", "1313", "1053",
					"793" };
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, price));
		} else if (action.equalsIgnoreCase("teleportURLH")) {
			String htmlid = "guide_3_1";
			price = new String[] { "750", "750", "750", "1200", "1050" };
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, price));
		} else if (action.equalsIgnoreCase("teleportURLJ")) {
			String htmlid = "guide_3_3";
			price = new String[] { "780", "780", "780", "780", "780", "1230",
					"1080" };
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, price));
		} else if (action.equalsIgnoreCase("teleportURLK")) {
			String htmlid = "guide_4";
			price = new String[] { "676", "676", "676", "676", "676", "1066",
					"936" };
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, price));
		} else if (action.equalsIgnoreCase("teleportURLA")) {
			String htmlid = "dekabia3";
			price = new String[] { "100", "220", "220", "220", "330", "330",
					"330", "330", "440", "440" };
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, price));
		} else if (action.equalsIgnoreCase("teleportURLA")) {
			String htmlid = "sharial3";
			price = new String[] { "220", "330", "330", "330", "440", "440",
					"550", "550", "550", "550" };
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid, price));
		}
		if (action.startsWith("teleport ")) {
			_log.finest((new StringBuilder()).append("Setting action to : ")
					.append(action).toString());
			doFinalAction(player, action);
		}
	}

	private void doFinalAction(L1PcInstance player, String action) {
		int objid = getId();

		int npcid = getNpcTemplate().get_npcId();
		String htmlid = null;
		boolean isTeleport = true;

		if (npcid == 50014) {
			if (!player.getInventory().checkItem(40581)) {
				isTeleport = false;
				htmlid = "dilongn";
			}
		} else if (npcid == 50043) {
			if (_isNowDely) {
				isTeleport = false;
			}
		} else if (npcid == 50625) {
			if (_isNowDely) {
				isTeleport = false;
			}
		}

		if (isTeleport) {
			try {
				if (action.equalsIgnoreCase("teleport mutant-dungen")) {
					//
					for (L1PcInstance otherPc : L1World.getInstance()
							.getVisiblePlayer(player, 3)) {
						if (otherPc.getClanid() == player.getClanid()
								&& otherPc.getId() != player.getId()) {
							L1Teleport.teleport(otherPc, 32740, 32800,
									(short) 217, 5, true);
						}
					}
					L1Teleport.teleport(player, 32740, 32800, (short) 217, 5,
							true);
				} else if (action
						.equalsIgnoreCase("teleport mage-quest-dungen")) {
					L1Teleport.teleport(player, 32791, 32788, (short) 201, 5,
							true);
				} else if (action.equalsIgnoreCase("teleport 29")) { //
					L1PcInstance kni = null;
					L1PcInstance elf = null;
					L1PcInstance wiz = null;
					for (L1PcInstance otherPc : L1World.getInstance()
							.getVisiblePlayer(player, 3)) {
						L1Quest quest = otherPc.getQuest();
						if (otherPc.isKnight()
								&& quest.get_step(L1Quest.QUEST_LEVEL50) == 1) {
							if (kni == null) {
								kni = otherPc;
							}
						} else if (otherPc.isElf()
								&& quest.get_step(L1Quest.QUEST_LEVEL50) == 1) {
							if (elf == null) {
								elf = otherPc;
							}
						} else if (otherPc.isWizard()
								&& quest.get_step(L1Quest.QUEST_LEVEL50) == 1) {
							if (wiz == null) {
								wiz = otherPc;
							}
						}
					}
					if (kni != null && elf != null && wiz != null) {
						L1Teleport.teleport(player, 32723, 32850, (short) 2000,
								2, true);
						L1Teleport.teleport(kni, 32750, 32851, (short) 2000, 6,
								true);
						L1Teleport.teleport(elf, 32878, 32980, (short) 2000, 6,
								true);
						L1Teleport.teleport(wiz, 32876, 33003, (short) 2000, 0,
								true);
						TeleportDelyTimer timer = new TeleportDelyTimer();
						GeneralThreadPool.getInstance().execute(timer);
					}
				} else if (action.equalsIgnoreCase("teleport barlog")) {
					L1Teleport.teleport(player, 32755, 32844, (short) 2002, 5,
							true);
					TeleportDelyTimer timer = new TeleportDelyTimer();
					GeneralThreadPool.getInstance().execute(timer);
				} else if(action.equalsIgnoreCase("teleport giranD")) {
					GiranPrisonController.getInstance().enter(player);
				}
			} catch (Exception e) {
			}
		}
		if (htmlid != null) {
			player.sendPackets(new S_NPCTalkReturn(objid, htmlid));
		}
	}

	class TeleportDelyTimer implements Runnable {

		public TeleportDelyTimer() {
		}

		public void run() {
			Thread.currentThread().setName("L1TeleporterInstance-DelyTimer");
			try {
				_isNowDely = true;
				Thread.sleep(900000);
			} catch (Exception e) {
				_isNowDely = false;
			}
			_isNowDely = false;
		}
	}

	private boolean _isNowDely = false;
	private static Logger _log = Logger
			.getLogger(l1j.server.server.model.Instance.L1TeleporterInstance.class
					.getName());

}
