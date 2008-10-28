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

import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.datatables.TownTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.L1Quest;
import l1j.server.server.model.L1TownLocation;
import l1j.server.server.model.L1World;
import l1j.server.server.model.gametime.L1GameTimeClock;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Npc;

public class L1MerchantInstance extends L1NpcInstance {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param template
	 */
	public L1MerchantInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void onAction(L1PcInstance player) {
		L1Attack attack = new L1Attack(player, this);
			attack.addPcPoisonAttack(player, this);
	    	attack.action();
	    	attack.commit();
	}
	@Override
	public void onTalkAction(L1PcInstance player) {
		int objid = getId();
		L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(
				getNpcTemplate().get_npcId());
		int npcid = getNpcTemplate().get_npcId();
		L1Quest quest = player.getQuest();
		String htmlid = null;
		String[] htmldata = null;

		if (talking != null) {
			if (npcid == 70841) {
				if (player.isElf()) {
					htmlid = "luudielE1";
				} else if (player.isDarkelf()) {
					htmlid = "luudielCE1";
				} else {
					htmlid = "luudiel1";
				}
			} else if (npcid == 70522) {
				if (player.isCrown()) {
					if (player.getLevel() >= 15) {
						int lv15_step = quest.get_step(L1Quest.QUEST_LEVEL15);
						if (lv15_step == 2 || lv15_step == L1Quest.QUEST_END) { 
							htmlid = "gunterp11";
						} else {
							htmlid = "gunterp9";
						}
					} else { // Lv15
						htmlid = "gunterp12";
					}
				} else if (player.isKnight()) {
					int lv30_step = quest.get_step(L1Quest.QUEST_LEVEL30);
					if (lv30_step == 0) {
						htmlid = "gunterk9";
					} else if (lv30_step == 1) {
						htmlid = "gunterkE1";
					} else if (lv30_step == 2) {
						htmlid = "gunterkE2";
					} else if (lv30_step >= 3) {
						htmlid = "gunterkE3";
					}
				} else if (player.isElf()) {
					htmlid = "guntere1";
				} else if (player.isWizard()) {
					htmlid = "gunterw1";
				} else if (player.isDarkelf()) {
					htmlid = "gunterde1";
				}
			} else if (npcid == 70653) {
				if (player.isCrown()) {
					if (player.getLevel() >= 45) {
						if (quest.isEnd(L1Quest.QUEST_LEVEL30)) { // lv30
							int lv45_step = quest
									.get_step(L1Quest.QUEST_LEVEL45);
							if (lv45_step == L1Quest.QUEST_END) {
								htmlid = "masha4";
							} else if (lv45_step >= 1) {
								htmlid = "masha3";
							} else {
								htmlid = "masha1";
							}
						}
					}
				} else if (player.isKnight()) {
					if (player.getLevel() >= 45) {
						if (quest.isEnd(L1Quest.QUEST_LEVEL30)) {
							int lv45_step = quest
									.get_step(L1Quest.QUEST_LEVEL45);
							if (lv45_step == L1Quest.QUEST_END) {
								htmlid = "mashak3";
							} else if (lv45_step == 0) {
								htmlid = "mashak1";
							} else if (lv45_step >= 1) {
								htmlid = "mashak2";
							}
						}
					}
				} else if (player.isElf()) {
					if (player.getLevel() >= 45) {
						if (quest.isEnd(L1Quest.QUEST_LEVEL30)) { // Lv30
							int lv45_step = quest
									.get_step(L1Quest.QUEST_LEVEL45);
							if (lv45_step == L1Quest.QUEST_END) {
								htmlid = "mashae3";
							} else if (lv45_step >= 1) {
								htmlid = "mashae2";
							} else {
								htmlid = "mashae1";
							}
						}
					}
				}
			} else if (npcid == 70554) {
				if (player.isCrown()) {
					if (player.getLevel() >= 15) {
						int lv15_step = quest.get_step(L1Quest.QUEST_LEVEL15);
						if (lv15_step == 1) {
							htmlid = "zero5";
						} else if (lv15_step == L1Quest.QUEST_END) {
							htmlid = "zero6";
						} else {
							htmlid = "zero1";
						}
					} else { // Lv15
						htmlid = "zero6";
					}
				}
			} else if (npcid == 70783) {
				if (player.isCrown()) {
					if (player.getLevel() >= 30) {
						if (quest.isEnd(L1Quest.QUEST_LEVEL15)) { // lv15
							int lv30_step = quest
									.get_step(L1Quest.QUEST_LEVEL30);
							if (lv30_step == L1Quest.QUEST_END) {
								htmlid = "aria3";
							} else if (lv30_step == 1) {
								htmlid = "aria2";
							} else {
								htmlid = "aria1";
							}
						}
					}
				}
			} else if (npcid == 70782) {
				if (player.getTempCharGfx() == 1037) {
					if (player.isCrown()) {
						if (quest.get_step(L1Quest.QUEST_LEVEL30) == 1) {
							htmlid = "ant1";
						} else {
							htmlid = "ant3";
						}
					} else {
						htmlid = "ant3";
					}
				}
			} else if (npcid == 70545) {
				if (player.isCrown()) {
					int lv45_step = quest.get_step(L1Quest.QUEST_LEVEL45);
					if (lv45_step >= 1 && lv45_step != L1Quest.QUEST_END) {
						if (player.getInventory().checkItem(40586)) {
							htmlid = "richard4";
						} else {
							htmlid = "richard1";
						}
					}
				}
			} else if (npcid == 70776) {
				if (player.isCrown()) {
					int lv45_step = quest.get_step(L1Quest.QUEST_LEVEL45);
					if (lv45_step == 1) {
						htmlid = "meg1";
					} else if (lv45_step == 2) {
						htmlid = "meg2";
					} else if (lv45_step >= 3) {
						htmlid = "meg3";
					}
				}
			} else if (npcid == 70751) {
				if (player.isCrown()) {
					if (player.getLevel() >= 45) {
						if (quest.get_step(L1Quest.QUEST_LEVEL45) == 2) {
							htmlid = "brad1";
						}
					}
				}
			} else if (npcid == 70798) {
				if (player.isKnight()) {
					if (player.getLevel() >= 15) {
						int lv15_step = quest.get_step(L1Quest.QUEST_LEVEL15);
						if (lv15_step >= 1) {
							htmlid = "riky5";
						} else {
							htmlid = "riky1";
						}
					} else { // Lv15
						htmlid = "riky6";
					}
				}
			} else if (npcid == 70802) {
				if (player.isKnight()) {
					if (player.getLevel() >= 15) {
						int lv15_step = quest.get_step(L1Quest.QUEST_LEVEL15);
						if (lv15_step == L1Quest.QUEST_END) {
							htmlid = "aanon7";
						} else if (lv15_step == 1) {
							htmlid = "aanon4";
						}
					}
				}
			} else if (npcid == 70775) {
				if (player.isKnight()) {
					if (player.getLevel() >= 30) {
						if (quest.isEnd(L1Quest.QUEST_LEVEL15)) {
							int lv30_step = quest
									.get_step(L1Quest.QUEST_LEVEL30);
							if (lv30_step == 0) {
								htmlid = "mark1";
							} else {
								htmlid = "mark2";
							}
						}
					}
				}
			} else if (npcid == 70794) {
				if (player.isCrown()) {
					htmlid = "gerardp1";
				} else if (player.isKnight()) {
					int lv30_step = quest.get_step(L1Quest.QUEST_LEVEL30);
					if (lv30_step == L1Quest.QUEST_END) {
						htmlid = "gerardkE5";
					} else if (lv30_step < 3) {
						htmlid = "gerardk7";
					} else if (lv30_step == 3) {
						htmlid = "gerardkE1";
					} else if (lv30_step == 4) {
						htmlid = "gerardkE2";
					} else if (lv30_step == 5) {
						htmlid = "gerardkE3";
					} else if (lv30_step >= 6) {
						htmlid = "gerardkE4";
					}
				} else if (player.isElf()) {
					htmlid = "gerarde1";
				} else if (player.isWizard()) {
					htmlid = "gerardw1";
				} else if (player.isDarkelf()) {
					htmlid = "gerardde1";
				}
			} else if (npcid == 70555) {
				if (player.getTempCharGfx() == 2374) {
					if (player.isKnight()) {
						if (quest.get_step(L1Quest.QUEST_LEVEL30) == 6) {
							htmlid = "jim2";
						} else {
							htmlid = "jim4";
						}
					} else {
						htmlid = "jim4";
					}
				}
			} else if (npcid == 70715) {
				if (player.isKnight()) {
					int lv45_step = quest.get_step(L1Quest.QUEST_LEVEL45);
					if (lv45_step == 1) {
						htmlid = "jimuk1";
					} else if (lv45_step >= 2) {
						htmlid = "jimuk2";
					}
				}
			} else if (npcid == 70711) {
				if (player.isKnight()) {
					int lv45_step = quest.get_step(L1Quest.QUEST_LEVEL45);
					if (lv45_step == 2) {
						if (player.getInventory().checkItem(20026)) {
							htmlid = "giantk1";
						}
					} else if (lv45_step == 3) {
						htmlid = "giantk2";
					} else if (lv45_step >= 4) {
						htmlid = "giantk3";
					}
				}
			} else if (npcid == 70826) {
				if (player.isElf()) {
					if (player.getLevel() >= 15) {
						if (quest.isEnd(L1Quest.QUEST_LEVEL15)) {
							htmlid = "oth5";
						} else {
							htmlid = "oth1";
						}
					} else {
						htmlid = "oth6";
					}
				}
			} else if (npcid == 70844) {
				if (player.isElf()) {
					if (player.getLevel() >= 30) {
						if (quest.isEnd(L1Quest.QUEST_LEVEL15)) { // Lv15
							int lv30_step = quest
									.get_step(L1Quest.QUEST_LEVEL30);
							if (lv30_step == L1Quest.QUEST_END) {
								htmlid = "motherEE3";
							} else if (lv30_step >= 1) {
								htmlid = "motherEE2";
							} else if (lv30_step <= 0) {
								htmlid = "motherEE1";
							}
						} else { // Lv15
							htmlid = "mothere1";
						}
					} else { // Lv30
						htmlid = "mothere1";
					}
				}
			} else if (npcid == 70724) {
				if (player.isElf()) {
					int lv45_step = quest.get_step(L1Quest.QUEST_LEVEL45);
					if (lv45_step >= 4) {
						htmlid = "heit5";
					} else if (lv45_step >= 3) {
						htmlid = "heit3";
					} else if (lv45_step >= 2) {
						htmlid = "heit2";
					} else if (lv45_step >= 1) {
						htmlid = "heit1";
					}
				}
			} else if (npcid == 70531) {
				if (player.isWizard()) {
					if (player.getLevel() >= 15) {
						if (quest.isEnd(L1Quest.QUEST_LEVEL15)) {
							htmlid = "jem6";
						} else {
							htmlid = "jem1";
						}
					}
				}
			} else if (npcid == 70009) {
				if (player.isCrown()) {
					htmlid = "gerengp1";
				} else if (player.isKnight()) {
					htmlid = "gerengk1";
				} else if (player.isElf()) {
					htmlid = "gerenge1";
				} else if (player.isWizard()) {
					if (player.getLevel() >= 30) {
						if (quest.isEnd(L1Quest.QUEST_LEVEL15)) {
							int lv30_step = quest
									.get_step(L1Quest.QUEST_LEVEL30);
							if (lv30_step >= 4) {
								htmlid = "gerengw3";
							} else if (lv30_step >= 3) {
								htmlid = "gerengT4";
							} else if (lv30_step >= 2) {
								htmlid = "gerengT3";
							} else if (lv30_step >= 1) {
								htmlid = "gerengT2";
							} else {
								htmlid = "gerengT1";
							}
						} else { // Lv15
							htmlid = "gerengw3";
						}
					} else { // Lv30
						htmlid = "gerengw3";
					}
				} else if (player.isDarkelf()) {
					htmlid = "gerengde1";
				}
			} else if (npcid == 70763) {
				if (player.isWizard()) {
					int lv30_step = quest.get_step(L1Quest.QUEST_LEVEL30);
					if (lv30_step == L1Quest.QUEST_END) {
						if (player.getLevel() >= 45) {
							int lv45_step = quest
									.get_step(L1Quest.QUEST_LEVEL45);
							if (lv45_step >= 1
									&& lv45_step != L1Quest.QUEST_END) {
								htmlid = "talassmq2";
							} else if (lv45_step <= 0) {
								htmlid = "talassmq1";
							}
						}
					} else if (lv30_step == 4) {
						htmlid = "talassE1";
					} else if (lv30_step == 5) {
						htmlid = "talassE2";
					}
				}
			} else if (npcid == 81105) {
				if (player.isWizard()) {
					int lv45_step = quest.get_step(L1Quest.QUEST_LEVEL45);
					if (lv45_step >= 3) {
						htmlid = "stoenm3";
					} else if (lv45_step >= 2) {
						htmlid = "stoenm2";
					} else if (lv45_step >= 1) {
						htmlid = "stoenm1";
					}
				}
			} else if (npcid == 70739) {
				if (player.getLevel() >= 50) {
					int lv50_step = quest.get_step(L1Quest.QUEST_LEVEL50);
					if (lv50_step == L1Quest.QUEST_END) {
						if (player.isCrown()) {
							htmlid = "dicardingp3";
						} else if (player.isKnight()) {
							htmlid = "dicardingk3";
						} else if (player.isElf()) {
							htmlid = "dicardinge3";
						} else if (player.isWizard()) {
							htmlid = "dicardingw3";
						} else if (player.isDarkelf()) {
							htmlid = "dicarding";
						}
					} else if (lv50_step >= 1) {
						if (player.isCrown()) {
							htmlid = "dicardingp2";
						} else if (player.isKnight()) {
							htmlid = "dicardingk2";
						} else if (player.isElf()) {
							htmlid = "dicardinge2";
						} else if (player.isWizard()) {
							htmlid = "dicardingw2";
						} else if (player.isDarkelf()) {
							htmlid = "dicarding";
						}
					} else if (lv50_step >= 0) {
						if (player.isCrown()) {
							htmlid = "dicardingp1";
						} else if (player.isKnight()) {
							htmlid = "dicardingk1";
						} else if (player.isElf()) {
							htmlid = "dicardinge1";
						} else if (player.isWizard()) {
							htmlid = "dicardingw1";
						} else if (player.isDarkelf()) {
							htmlid = "dicarding";
						}
					} else {
						htmlid = "dicarding";
					}
				} else { // Lv50
					htmlid = "dicarding";
				}
			} else if (npcid == 70885) {
				if (player.isDarkelf()) {
					if (player.getLevel() >= 15) {
						int lv15_step = quest.get_step(L1Quest.QUEST_LEVEL15);
						if (lv15_step == L1Quest.QUEST_END) {
							htmlid = "kanguard3";
						} else if (lv15_step >= 1) {
							htmlid = "kanguard2";
						} else {
							htmlid = "kanguard1";
						}
					} else { // Lv15
						htmlid = "kanguard5";
					}
				}
			} else if (npcid == 70892) {
				if (player.isDarkelf()) {
					if (player.getLevel() >= 30) {
						if (quest.isEnd(L1Quest.QUEST_LEVEL15)) {
							int lv30_step = quest
									.get_step(L1Quest.QUEST_LEVEL30);
							if (lv30_step == L1Quest.QUEST_END) {
								htmlid = "ronde5";
							} else if (lv30_step >= 2) {
								htmlid = "ronde3";
							} else if (lv30_step >= 1) {
								htmlid = "ronde2";
							} else {
								htmlid = "ronde1";
							}
						} else { // Lv15
							htmlid = "ronde7";
						}
					} else { // Lv30
						htmlid = "ronde7";
					}
				}
			} else if (npcid == 70895) {
				if (player.isDarkelf()) {
					if (player.getLevel() >= 45) {
						if (quest.isEnd(L1Quest.QUEST_LEVEL30)) {
							int lv45_step = quest
									.get_step(L1Quest.QUEST_LEVEL45);
							if (lv45_step == L1Quest.QUEST_END) {
								if (player.getLevel() < 50) { // Lv50
									htmlid = "bluedikaq3";
								} else {
									int lv50_step = quest
											.get_step(L1Quest.QUEST_LEVEL50);
									if (lv50_step == L1Quest.QUEST_END) {
										htmlid = "bluedikaq8";
									} else {
										htmlid = "bluedikaq6";
									}
								}
							} else if (lv45_step >= 1) {
								htmlid = "bluedikaq2";
							} else {
								htmlid = "bluedikaq1";
							}
						} else { // Lv30
							htmlid = "bluedikaq5";
						}
					} else { // Lv45
						htmlid = "bluedikaq5";
					}
				}
			} else if (npcid == 70904) {
				if (player.isDarkelf()) {
					if (quest.get_step(L1Quest.QUEST_LEVEL45) == 1) {
						htmlid = "koup12";
					}
				}
			} else if (npcid == 70824) {
					if (player.isDarkelf()) {
						if (player.getTempCharGfx() == 3634) {
						int lv45_step = quest.get_step(L1Quest.QUEST_LEVEL45);
						if (lv45_step == 1) {
							htmlid = "assassin1";
						} else if (lv45_step == 2) {
							htmlid = "assassin2";
						} else {
							htmlid = "assassin4";
						}
					} else {
						htmlid = "assassin3";
					}
				}
			} else if (npcid == 70744) {
				if (player.isDarkelf()) {
					int lv45_step = quest.get_step(L1Quest.QUEST_LEVEL45);
					if (lv45_step >= 5) {
						htmlid = "roje14";
					} else if (lv45_step >= 4) {
						htmlid = "roje13";
					} else if (lv45_step >= 3) {
						htmlid = "roje12";
					} else if (lv45_step >= 2) {
						htmlid = "roje11";
					} else {
						htmlid = "roje15";
					}
				}
			} else if (npcid == 70811) {
				if (quest.get_step(L1Quest.QUEST_LYRA) >= 1) {
					htmlid = "lyraEv3";
				} else {
					htmlid = "lyraEv1";
				}
			} else if (npcid == 70087) {
				if (player.isDarkelf()) {
					htmlid = "sedia";
				}
			} else if (npcid == 70099) {
				if (!quest.isEnd(L1Quest.QUEST_OILSKINMANT)) {
					if (player.getLevel() > 13) {
						htmlid = "kuper1";
					}
				}
			} else if (npcid == 70796) {
				if (!quest.isEnd(L1Quest.QUEST_OILSKINMANT)) {
					if (player.getLevel() > 13) {
						htmlid = "dunham1";
					}
				}
			} else if (npcid == 70011) {
				int time = L1GameTimeClock.getInstance().getGameTime()
						.getSeconds() % 86400;
				if (time < 60 * 60 * 6 || time > 60 * 60 * 20) { // 20:00 6:00
					htmlid = "shipEvI6";
				}
			} else if (npcid == 70553) {
				boolean hascastle = checkHasCastle(player,
						L1CastleLocation.KENT_CASTLE_ID);
				if (hascastle) {
					if (checkClanLeader(player)) {
						htmlid = "ishmael1";
					} else {
						htmlid = "ishmael6";
						htmldata = new String[] { player.getName() };
					}
				} else {
					htmlid = "ishmael7";
				}
			} else if (npcid == 70822) {
				boolean hascastle = checkHasCastle(player,
						L1CastleLocation.OT_CASTLE_ID);
				if (hascastle) {
					if (checkClanLeader(player)) {
						htmlid = "seghem1";
					} else {
						htmlid = "seghem6";
						htmldata = new String[] { player.getName() };
					}
				} else {
					htmlid = "seghem7";
				}
			} else if (npcid == 70784) {
				boolean hascastle = checkHasCastle(player, L1CastleLocation.WW_CASTLE_ID);
				if (hascastle) {
					if (checkClanLeader(player)) {
						htmlid = "othmond1";
					} else {
						htmlid = "othmond6";
						htmldata = new String[] { player.getName() };
					}
				} else {
					htmlid = "othmond7";
				}
			} else if (npcid == 70623) {
				boolean hascastle = checkHasCastle(player,
						L1CastleLocation.GIRAN_CASTLE_ID);
				if (hascastle) {
					if (checkClanLeader(player)) {
						htmlid = "orville1";
					} else {
						htmlid = "orville6";
						htmldata = new String[] { player.getName() };
					}
				} else {
					htmlid = "orville7";
				}
			} else if (npcid == 70880) {
				boolean hascastle = checkHasCastle(player,
						L1CastleLocation.HEINE_CASTLE_ID);
				if (hascastle) {
					if (checkClanLeader(player)) {
						htmlid = "fisher1";
					} else {
						htmlid = "fisher6";
						htmldata = new String[] { player.getName() };
					}
				} else {
					htmlid = "fisher7";
				}
			} else if (npcid == 70665) {
				boolean hascastle = checkHasCastle(player,
						L1CastleLocation.DOWA_CASTLE_ID);
				if (hascastle) {
					if (checkClanLeader(player)) {
						htmlid = "potempin1";
					} else {
						htmlid = "potempin6";
						htmldata = new String[] { player.getName() };
					}
				} else {
					htmlid = "potempin7";
				}
			} else if (npcid == 70721) {
				boolean hascastle = checkHasCastle(player,
						L1CastleLocation.ADEN_CASTLE_ID);
				if (hascastle) {
					if (checkClanLeader(player)) {
						htmlid = "timon1";
					} else {
						htmlid = "timon6";
						htmldata = new String[] { player.getName() };
					}
				} else {
					htmlid = "timon7";
				}
			} else if (npcid == 81155) {
				boolean hascastle = checkHasCastle(player,
						L1CastleLocation.DIAD_CASTLE_ID);
				if (hascastle) {
					if (checkClanLeader(player)) {
						htmlid = "olle1";
					} else {
						htmlid = "olle6";
						htmldata = new String[] { player.getName() };
					}
				} else {
					htmlid = "olle7";
				}
			} else if (npcid == 80057) {
				switch (player.getKarmaLevel()) {
				case 0:
					htmlid = "alfons1";
					break;
				case -1:
					htmlid = "cyk1";
					break;
				case -2:
					htmlid = "cyk2";
					break;
				case -3:
					htmlid = "cyk3";
					break;
				case -4:
					htmlid = "cyk4";
					break;
				case -5:
					htmlid = "cyk5";
					break;
				case -6:
					htmlid = "cyk6";
					break;
				case -7:
					htmlid = "cyk7";
					break;
				case -8:
					htmlid = "cyk8";
					break;
				case 1:
					htmlid = "cbk1";
					break;
				case 2:
					htmlid = "cbk2";
					break;
				case 3:
					htmlid = "cbk3";
					break;
				case 4:
					htmlid = "cbk4";
					break;
				case 5:
					htmlid = "cbk5";
					break;
				case 6:
					htmlid = "cbk6";
					break;
				case 7:
					htmlid = "cbk7";
					break;
				case 8:
					htmlid = "cbk8";
					break;
				default:
					htmlid = "alfons1";
					break;
				}
			} else if (npcid == 80058) {
				int level = player.getLevel();
				if (level <= 44) {
					htmlid = "cpass03";
				} else if (level <= 51 && 45 <= level) {
					htmlid = "cpass02";
				} else {
					htmlid = "cpass01";
				}
			} else if (npcid == 80059) {
				if (player.getKarmaLevel() > 0) {
					htmlid = "cpass03";
				} else if (player.getInventory().checkItem(40921)) {
					htmlid = "wpass02";
				} else if (player.getInventory().checkItem(40917)) {
					htmlid = "wpass14";
				} else if (player.getInventory().checkItem(40912)
						|| player.getInventory().checkItem(40910)
						|| player.getInventory().checkItem(40911)) {
					htmlid = "wpass04";
				} else if (player.getInventory().checkItem(40909)) {
					int count = getNecessarySealCount(player);
					if (player.getInventory().checkItem(40913, count)) {
						createRuler(player, 1, count);
						htmlid = "wpass06";
					} else {
						htmlid = "wpass03";
					}
				} else if (player.getInventory().checkItem(40913)) {
					htmlid = "wpass08";
				} else {
					htmlid = "wpass05";
				}
			} else if (npcid == 80060) {
				if (player.getKarmaLevel() > 0) {
					htmlid = "cpass03";
				} else if (player.getInventory().checkItem(40921)) {
					htmlid = "wpass02";
				} else if (player.getInventory().checkItem(40920)) {
					htmlid = "wpass13";
				} else if (player.getInventory().checkItem(40909)
						|| player.getInventory().checkItem(40910)
						|| player.getInventory().checkItem(40911)) {
					htmlid = "wpass04";
				} else if (player.getInventory().checkItem(40912)) {
					int count = getNecessarySealCount(player);
					if (player.getInventory().checkItem(40916, count)) {
						createRuler(player, 8, count);
						htmlid = "wpass06";
					} else {
						htmlid = "wpass03";
					}
				} else if (player.getInventory().checkItem(40916)) {
					htmlid = "wpass08";
				} else {
					htmlid = "wpass05";
				}
			} else if (npcid == 80061) {
				if (player.getKarmaLevel() > 0) {
					htmlid = "cpass03";
				} else if (player.getInventory().checkItem(40921)) {
					htmlid = "wpass02";
				} else if (player.getInventory().checkItem(40918)) {
					htmlid = "wpass11";
				} else if (player.getInventory().checkItem(40909)
						|| player.getInventory().checkItem(40912)
						|| player.getInventory().checkItem(40911)) {
					htmlid = "wpass04";
				} else if (player.getInventory().checkItem(40910)) {
					int count = getNecessarySealCount(player);
					if (player.getInventory().checkItem(40914, count)) {
						createRuler(player, 4, count);
						htmlid = "wpass06";
					} else {
						htmlid = "wpass03";
					}
				} else if (player.getInventory().checkItem(40914)) {
					htmlid = "wpass08";
				} else {
					htmlid = "wpass05";
				}
			} else if (npcid == 80062) {
				if (player.getKarmaLevel() > 0) {
					htmlid = "cpass03";
				} else if (player.getInventory().checkItem(40921)) {
					htmlid = "wpass02";
				} else if (player.getInventory().checkItem(40919)) {
					htmlid = "wpass12";
				} else if (player.getInventory().checkItem(40909)
						|| player.getInventory().checkItem(40912)
						|| player.getInventory().checkItem(40910)) {
					htmlid = "wpass04";
				} else if (player.getInventory().checkItem(40911)) {
					int count = getNecessarySealCount(player);
					if (player.getInventory().checkItem(40915, count)) {
						createRuler(player, 2, count);
						htmlid = "wpass06";
					} else {
						htmlid = "wpass03";
					}
				} else if (player.getInventory().checkItem(40915)) {
					htmlid = "wpass08";
				} else {
					htmlid = "wpass05";
				}
			} else if (npcid == 80065) {
				if (player.getKarmaLevel() < 3) {
					htmlid = "uturn0";
				} else {
					htmlid = "uturn1";
				}
			} else if (npcid == 80047) {
				if (player.getKarmaLevel() > -3) {
					htmlid = "uhelp1";
				} else {
					htmlid = "uhelp2";
				}
			} else if (npcid == 80049) {
				if (player.getKarma() <= -10000000) {
					htmlid = "betray11";
				} else {
					htmlid = "betray12";
				}
			} else if (npcid == 80050) {
				if (player.getKarmaLevel() > -1) {
					htmlid = "meet103";
				} else {
					htmlid = "meet101";
				}
			} else if (npcid == 80053) {
				int karmaLevel = player.getKarmaLevel();
				if (karmaLevel == 0) {
					htmlid = "aliceyet";
				} else if (karmaLevel >= 1) {
					if (player.getInventory().checkItem(196)
							|| player.getInventory().checkItem(197)
							|| player.getInventory().checkItem(198)
							|| player.getInventory().checkItem(199)
							|| player.getInventory().checkItem(200)
							|| player.getInventory().checkItem(201)
							|| player.getInventory().checkItem(202)
							|| player.getInventory().checkItem(203)) {
						htmlid = "alice_gd";
					} else {
						htmlid = "gd";
					}
				} else if (karmaLevel <= -1) {
					if (player.getInventory().checkItem(40991)) {
						if (karmaLevel <= -1) {
							htmlid = "Mate_1";
						}
					} else if (player.getInventory().checkItem(196)) {
						if (karmaLevel <= -2) {
							htmlid = "Mate_2";
						} else {
							htmlid = "alice_1";
						}
					} else if (player.getInventory().checkItem(197)) {
						if (karmaLevel <= -3) {
							htmlid = "Mate_3";
						} else {
							htmlid = "alice_2";
						}
					} else if (player.getInventory().checkItem(198)) {
						if (karmaLevel <= -4) {
							htmlid = "Mate_4";
						} else {
							htmlid = "alice_3";
						}
					} else if (player.getInventory().checkItem(199)) {
						if (karmaLevel <= -5) {
							htmlid = "Mate_5";
						} else {
							htmlid = "alice_4";
						}
					} else if (player.getInventory().checkItem(200)) {
						if (karmaLevel <= -6) {
							htmlid = "Mate_6";
						} else {
							htmlid = "alice_5";
						}
					} else if (player.getInventory().checkItem(201)) {
						if (karmaLevel <= -7) {
							htmlid = "Mate_7";
						} else {
							htmlid = "alice_6";
						}
					} else if (player.getInventory().checkItem(202)) {
						if (karmaLevel <= -8) {
							htmlid = "Mate_8";
						} else {
							htmlid = "alice_7";
						}
					} else if (player.getInventory().checkItem(203)) {
						htmlid = "alice_8";
					} else {
						htmlid = "alice_no";
					}
				}
			} else if (npcid == 80055) {
				int amuletLevel = 0;
				if (player.getInventory().checkItem(20358)) {
					amuletLevel = 1;
				} else if (player.getInventory().checkItem(20359)) {
					amuletLevel = 2;
				} else if (player.getInventory().checkItem(20360)) {
					amuletLevel = 3;
				} else if (player.getInventory().checkItem(20361)) {
					amuletLevel = 4;
				} else if (player.getInventory().checkItem(20362)) {
					amuletLevel = 5;
				} else if (player.getInventory().checkItem(20363)) {
					amuletLevel = 6;
				} else if (player.getInventory().checkItem(20364)) {
					amuletLevel = 7;
				} else if (player.getInventory().checkItem(20365)) {
					amuletLevel = 8;
				}
				if (player.getKarmaLevel() == -1) {
					if (amuletLevel >= 1) {
						htmlid = "uamuletd";
					} else {
						htmlid = "uamulet1";
					}
				} else if (player.getKarmaLevel() == -2) {
					if (amuletLevel >= 2) {
						htmlid = "uamuletd";
					} else {
						htmlid = "uamulet2";
					}
				} else if (player.getKarmaLevel() == -3) {
					if (amuletLevel >= 3) {
						htmlid = "uamuletd";
					} else {
						htmlid = "uamulet3";
					}
				} else if (player.getKarmaLevel() == -4) {
					if (amuletLevel >= 4) {
						htmlid = "uamuletd";
					} else {
						htmlid = "uamulet4";
					}
				} else if (player.getKarmaLevel() == -5) {
					if (amuletLevel >= 5) {
						htmlid = "uamuletd";
					} else {
						htmlid = "uamulet5";
					}
				} else if (player.getKarmaLevel() == -6) {
					if (amuletLevel >= 6) {
						htmlid = "uamuletd";
					} else {
						htmlid = "uamulet6";
					}
				} else if (player.getKarmaLevel() == -7) {
					if (amuletLevel >= 7) {
						htmlid = "uamuletd";
					} else {
						htmlid = "uamulet7";
					}
				} else if (player.getKarmaLevel() == -8) {
					if (amuletLevel >= 8) {
						htmlid = "uamuletd";
					} else {
						htmlid = "uamulet8";
					}
				} else {
					htmlid = "uamulet0";
				}
			} else if (npcid == 80056) {
				if (player.getKarma() <= -10000000) {
					htmlid = "infamous11";
				} else {
					htmlid = "infamous12";
				}
			} else if (npcid == 80064) {
				if (player.getKarmaLevel() < 1) {
					htmlid = "meet003";
				} else {
					htmlid = "meet001";
				}
			} else if (npcid == 80066) {
				if (player.getKarma() >= 10000000) {
					htmlid = "betray01";
				} else {
					htmlid = "betray02";
				}
			} else if (npcid == 80071) {
				int earringLevel = 0;
				if (player.getInventory().checkItem(21020)) {
					earringLevel = 1;
				} else if (player.getInventory().checkItem(21021)) {
					earringLevel = 2;
				} else if (player.getInventory().checkItem(21022)) {
					earringLevel = 3;
				} else if (player.getInventory().checkItem(21023)) {
					earringLevel = 4;
				} else if (player.getInventory().checkItem(21024)) {
					earringLevel = 5;
				} else if (player.getInventory().checkItem(21025)) {
					earringLevel = 6;
				} else if (player.getInventory().checkItem(21026)) {
					earringLevel = 7;
				} else if (player.getInventory().checkItem(21027)) {
					earringLevel = 8;
				}
				if (player.getKarmaLevel() == 1) {
					if (earringLevel >= 1) {
						htmlid = "lringd";
					} else {
						htmlid = "lring1";
					}
				} else if (player.getKarmaLevel() == 2) {
					if (earringLevel >= 2) {
						htmlid = "lringd";
					} else {
						htmlid = "lring2";
					}
				} else if (player.getKarmaLevel() == 3) {
					if (earringLevel >= 3) {
						htmlid = "lringd";
					} else {
						htmlid = "lring3";
					}
				} else if (player.getKarmaLevel() == 4) {
					if (earringLevel >= 4) {
						htmlid = "lringd";
					} else {
						htmlid = "lring4";
					}
				} else if (player.getKarmaLevel() == 5) {
					if (earringLevel >= 5) {
						htmlid = "lringd";
					} else {
						htmlid = "lring5";
					}
				} else if (player.getKarmaLevel() == 6) {
					if (earringLevel >= 6) {
						htmlid = "lringd";
					} else {
						htmlid = "lring6";
					}
				} else if (player.getKarmaLevel() == 7) {
					if (earringLevel >= 7) {
						htmlid = "lringd";
					} else {
						htmlid = "lring7";
					}
				} else if (player.getKarmaLevel() == 8) {
					if (earringLevel >= 8) {
						htmlid = "lringd";
					} else {
						htmlid = "lring8";
					}
				} else {
					htmlid = "lring0";
				}
			} else if (npcid == 80072) {
				int karmaLevel = player.getKarmaLevel();
				if (karmaLevel == 1) {
					htmlid = "lsmith0";
				} else if (karmaLevel == 2) {
					htmlid = "lsmith1";
				} else if (karmaLevel == 3) {
					htmlid = "lsmith2";
				} else if (karmaLevel == 4) {
					htmlid = "lsmith3";
				} else if (karmaLevel == 5) {
					htmlid = "lsmith4";
				} else if (karmaLevel == 6) {
					htmlid = "lsmith5";
				} else if (karmaLevel == 7) {
					htmlid = "lsmith7";
				} else if (karmaLevel == 8) {
					htmlid = "lsmith8";
				} else {
					htmlid = "";
				}
			} else if (npcid == 80074) {
				if (player.getKarma() >= 10000000) {
					htmlid = "infamous01";
				} else {
					htmlid = "infamous02";
				}
			} else if (npcid == 80104) { 
				if (!player.isCrown()) { 
					htmlid = "horseseller4";
				}
			} else if (npcid == 70528) {
				htmlid = talkToTownmaster(player,
						L1TownLocation.TOWNID_TALKING_ISLAND);
			} else if (npcid == 70546) { 
				htmlid = talkToTownmaster(player, L1TownLocation.TOWNID_KENT);
			} else if (npcid == 70567) {
				htmlid = talkToTownmaster(player, L1TownLocation.TOWNID_GLUDIO);
			} else if (npcid == 70815) { 
				htmlid = talkToTownmaster(player,
						L1TownLocation.TOWNID_ORCISH_FOREST);
			} else if (npcid == 70774) { 
				htmlid = talkToTownmaster(player,
						L1TownLocation.TOWNID_WINDAWOOD);
			} else if (npcid == 70799) {
				htmlid = talkToTownmaster(player,
						L1TownLocation.TOWNID_SILVER_KNIGHT_TOWN);
			} else if (npcid == 70594) { 
				htmlid = talkToTownmaster(player, L1TownLocation.TOWNID_GIRAN);
			} else if (npcid == 70860) {
				htmlid = talkToTownmaster(player, L1TownLocation.TOWNID_HEINE);
			} else if (npcid == 70654) {
				htmlid = talkToTownmaster(player, L1TownLocation.TOWNID_WERLDAN);
			} else if (npcid == 70748) {
				htmlid = talkToTownmaster(player, L1TownLocation.TOWNID_OREN);
			} else if (npcid == 70534) {
				htmlid = talkToTownadviser(player,
						L1TownLocation.TOWNID_TALKING_ISLAND);
			} else if (npcid == 70556) {
				htmlid = talkToTownadviser(player, L1TownLocation.TOWNID_KENT);
			} else if (npcid == 70572) {
				htmlid = talkToTownadviser(player, L1TownLocation.TOWNID_GLUDIO);
			} else if (npcid == 70830) {
				htmlid = talkToTownadviser(player,
						L1TownLocation.TOWNID_ORCISH_FOREST);
			} else if (npcid == 70788) {
				htmlid = talkToTownadviser(player,
						L1TownLocation.TOWNID_WINDAWOOD);
			} else if (npcid == 70806) {
				htmlid = talkToTownadviser(player,
						L1TownLocation.TOWNID_SILVER_KNIGHT_TOWN);
			} else if (npcid == 70631) {
				htmlid = talkToTownadviser(player, L1TownLocation.TOWNID_GIRAN);
			} else if (npcid == 70876) {
				htmlid = talkToTownadviser(player, L1TownLocation.TOWNID_HEINE);
			} else if (npcid == 70663) {
				htmlid = talkToTownadviser(player,
						L1TownLocation.TOWNID_WERLDAN);
			} else if (npcid == 70761) {
				htmlid = talkToTownadviser(player, L1TownLocation.TOWNID_OREN);
			} else if (npcid == 70997) {
				htmlid = talkToDoromond(player);
			} else if (npcid == 70998) {
				htmlid = talkToSIGuide(player);
			} else if (npcid == 70999) {
				htmlid = talkToAlex(player);
			} else if (npcid == 71000) {
				htmlid = talkToAlexInTrainingRoom(player);
			} else if (npcid == 71002) {
				htmlid = cancellation(player);
			} else if (npcid == 70506) {
				htmlid = talkToRuba(player);
			} else if (npcid == 71005) {
				htmlid = talkToPopirea(player);
			} else if (npcid == 71009) {
				if (player.getLevel() < 13) {
					htmlid = "jpe0071";
				}
			} else if (npcid == 71011) {
				if (player.getLevel() < 13) {
					htmlid = "jpe0061";
				}
			} else if (npcid == 71013) {
				if (player.isDarkelf()) {
					if (player.getLevel() <= 3) {
						htmlid = "karen1";
					} else if (player.getLevel() > 3 && player.getLevel() < 50) {
						htmlid = "karen3";
					} else if (player.getLevel() >= 50) {
						htmlid = "karen4";
					}
				}
			} else if (npcid == 71014) {
				if (player.getLevel() < 13) {
					htmlid = "en0241";
				}
			} else if (npcid == 71015) {
				if (player.getLevel() < 13) {
					htmlid = "en0261";
				} else if (player.getLevel() >= 13 && player.getLevel() < 25) {
					htmlid = "en0262";
				}
			} else if (npcid == 71031) {
				if (player.getLevel() < 25) {
					htmlid = "en0081";
				}
			} else if (npcid == 71032) {
				if (player.isElf()) {
					htmlid = "en0091e";
				} else if (player.isDarkelf()) {
					htmlid = "en0091d";
				} else if (player.isKnight()) {
					htmlid = "en0091k";
				} else if (player.isWizard()) {
					htmlid = "en0091w";
				} else if (player.isCrown()) {
					htmlid = "en0091p";
				}
			} else if (npcid == 71034) {
				if (player.getInventory().checkItem(41227)) {
					if (player.isElf()) {
						htmlid = "en0201e";
					} else if (player.isDarkelf()) {
						htmlid = "en0201d";
					} else if (player.isKnight()) {
						htmlid = "en0201k";
					} else if (player.isWizard()) {
						htmlid = "en0201w";
					} else if (player.isCrown()) {
						htmlid = "en0201p";
					}
				}
			} else if (npcid == 71033) {
				if (player.getInventory().checkItem(41228)) {
					if (player.isElf()) {
						htmlid = "en0211e";
					} else if (player.isDarkelf()) {
						htmlid = "en0211d";
					} else if (player.isKnight()) {
						htmlid = "en0211k";
					} else if (player.isWizard()) {
						htmlid = "en0211w";
					} else if (player.isCrown()) {
						htmlid = "en0211p";
					}
				}
			} else if (npcid == 71026) {
				if (player.getLevel() < 10) {
					htmlid = "en0113";
				} else if (player.getLevel() >= 10 && player.getLevel() < 25) {
					htmlid = "en0111";
				} else if (player.getLevel() > 25) {
					htmlid = "en0112";
				}
			} else if (npcid == 71027) {
				if (player.getLevel() < 10) {
					htmlid = "en0283";
				} else if (player.getLevel() >= 10 && player.getLevel() < 25) {
					htmlid = "en0281";
				} else if (player.getLevel() > 25) {
					htmlid = "en0282";
				}
			} else if (npcid == 71021) {
				if (player.getLevel() < 12) {
					htmlid = "en0197";
				} else if (player.getLevel() >= 12 && player.getLevel() < 25) {
					htmlid = "en0191";
				}
			} else if (npcid == 71022) {
				if (player.getLevel() < 12) {
					htmlid = "jpe0155";
				} else if (player.getLevel() >= 12 && player.getLevel() < 25) {
					if (player.getInventory().checkItem(41230)
							|| player.getInventory().checkItem(41231)
							|| player.getInventory().checkItem(41232)
							|| player.getInventory().checkItem(41233)
							|| player.getInventory().checkItem(41235)
							|| player.getInventory().checkItem(41238)
							|| player.getInventory().checkItem(41239)
							|| player.getInventory().checkItem(41240)) {
						htmlid = "jpe0158";
					}
				}
			} else if (npcid == 71023) {
				if (player.getLevel() < 12) {
					htmlid = "jpe0145";
				} else if (player.getLevel() >= 12 && player.getLevel() < 25) {
					if (player.getInventory().checkItem(41233)
							|| player.getInventory().checkItem(41234)) {
						htmlid = "jpe0143";	
					} else if (player.getInventory().checkItem(41238)
							|| player.getInventory().checkItem(41239)
							|| player.getInventory().checkItem(41240)) {
						htmlid = "jpe0147";
					} else if (player.getInventory().checkItem(41235)
							|| player.getInventory().checkItem(41236)
							|| player.getInventory().checkItem(41237)) {
						htmlid = "jpe0144";
					}
				}
			} else if (npcid == 71020) {
				if (player.getLevel() < 12) {
					htmlid = "jpe0125";
				} else if (player.getLevel() >= 12 && player.getLevel() < 25) {
					if (player.getInventory().checkItem(41231)) {
						htmlid = "jpe0123";	
					} else if (player.getInventory().checkItem(41232)
							|| player.getInventory().checkItem(41233)
							|| player.getInventory().checkItem(41234)
							|| player.getInventory().checkItem(41235)
							|| player.getInventory().checkItem(41238)
							|| player.getInventory().checkItem(41239)
							|| player.getInventory().checkItem(41240)) {
						htmlid = "jpe0126";
					}
				}
			} else if (npcid == 71019) {
				if (player.getLevel() < 12) {
					htmlid = "jpe0114";
				} else if (player.getLevel() >= 12 && player.getLevel() < 25) {
					if (player.getInventory().checkItem(41239)) {
						htmlid = "jpe0113";
					} else {
						htmlid = "jpe0111";
					}
				}
			} else if (npcid == 71018) {
				if (player.getLevel() < 12) {
					htmlid = "jpe0133";
				} else if (player.getLevel() >= 12 && player.getLevel() < 25) {
					if (player.getInventory().checkItem(41240)) {
						htmlid = "jpe0132";
					} else {
						htmlid = "jpe0131";
					}
				}
			} else if (npcid == 71025) {
				if (player.getLevel() < 10) {
					htmlid = "jpe0086";
				} else if (player.getLevel() >= 10 && player.getLevel() < 25) {
					if (player.getInventory().checkItem(41226)) {
						htmlid = "jpe0084";
					} else if (player.getInventory().checkItem(41225)) {
						htmlid = "jpe0083";
					} else if (player.getInventory().checkItem(40653)
							|| player.getInventory().checkItem(40613)) {
						htmlid = "jpe0081";
					}
				}
			} else if (npcid == 70512) {
				if (player.getLevel() >= 25) {
					htmlid = "jpe0102";
				}
			} else if (npcid == 70514) {
				if (player.getLevel() >= 25) {
					htmlid = "jpe0092";
				}
			} else if (npcid == 71038) {
				if (player.getInventory().checkItem(41060)) {
					if (player.getInventory().checkItem(41090)
							|| player.getInventory().checkItem(41091)
							|| player.getInventory().checkItem(41092)) {
						htmlid = "orcfnoname7";
					} else {
						htmlid = "orcfnoname8";
					}
				} else {
					htmlid = "orcfnoname1";
				}
			} else if (npcid == 71040) {
				if (player.getInventory().checkItem(41060)) {
					if (player.getInventory().checkItem(41065)) {
						if (player.getInventory().checkItem(41086)
								|| player.getInventory().checkItem(41087)
								|| player.getInventory().checkItem(41088)
								|| player.getInventory().checkItem(41089)) {
							htmlid = "orcfnoa6";
						} else {
							htmlid = "orcfnoa5";
						}
					} else {
						htmlid = "orcfnoa2";
					}
				} else {
					htmlid = "orcfnoa1";
				}
			} else if (npcid == 71041) {
				if (player.getInventory().checkItem(41060)) {
					if (player.getInventory().checkItem(41064)) {
						if (player.getInventory().checkItem(41081)
								|| player.getInventory().checkItem(41082)
								|| player.getInventory().checkItem(41083)
								|| player.getInventory().checkItem(41084)
								|| player.getInventory().checkItem(41085)) {
							htmlid = "orcfhuwoomo2";
						} else {
							htmlid = "orcfhuwoomo8";
						}
					} else {
						htmlid = "orcfhuwoomo1";
					}
				} else {
					htmlid = "orcfhuwoomo5";
				}
			} else if (npcid == 71042) {
				if (player.getInventory().checkItem(41060)) {
					if (player.getInventory().checkItem(41062)) {
						if (player.getInventory().checkItem(41071)
								|| player.getInventory().checkItem(41072)
								|| player.getInventory().checkItem(41073)
								|| player.getInventory().checkItem(41074)
								|| player.getInventory().checkItem(41075)) {
							htmlid = "orcfbakumo2";
						} else {
							htmlid = "orcfbakumo8";
						}
					} else {
						htmlid = "orcfbakumo1";
					}
				} else {
					htmlid = "orcfbakumo5";
				}
			} else if (npcid == 71043) {
				if (player.getInventory().checkItem(41060)) {
					if (player.getInventory().checkItem(41063)) {
						if (player.getInventory().checkItem(41076)
								|| player.getInventory().checkItem(41077)
								|| player.getInventory().checkItem(41078)
								|| player.getInventory().checkItem(41079)
								|| player.getInventory().checkItem(41080)) {
							htmlid = "orcfbuka2";
						} else {
							htmlid = "orcfbuka8";
						}
					} else {
						htmlid = "orcfbuka1";
					}
				} else {
					htmlid = "orcfbuka5";
				}
			} else if (npcid == 71044) {
				if (player.getInventory().checkItem(41060)) {
					if (player.getInventory().checkItem(41061)) {
						if (player.getInventory().checkItem(41066)
								|| player.getInventory().checkItem(41067)
								|| player.getInventory().checkItem(41068)
								|| player.getInventory().checkItem(41069)
								|| player.getInventory().checkItem(41070)) {
							htmlid = "orcfkame2";
						} else {
							htmlid = "orcfkame8";
						}
					} else {
						htmlid = "orcfkame1";
					}
				} else {
					htmlid = "orcfkame5";
				}
			} else if (npcid == 71055) {
				if (player.getQuest().get_step(L1Quest.QUEST_RESTA) == 3) {
					htmlid = "lukein13";
				} else if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1)
						== L1Quest.QUEST_END
						&& player.getQuest().get_step(L1Quest.QUEST_RESTA)
						== 2
						&& player.getInventory().checkItem(40631)) {
					htmlid = "lukein10";
				} else if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1)
						== L1Quest.QUEST_END) {
					htmlid = "lukein0";
				} else if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1)
						== 11) {
					if (player.getInventory().checkItem(40716)) {
						htmlid = "lukein9";
					}
				} else if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1)
						>= 1
						&& player.getQuest().get_step(L1Quest.QUEST_LUKEIN1)
						<= 10) {
					htmlid = "lukein8";
				}
			} else if (npcid == 71063) {
				if (player.getQuest().get_step(L1Quest.QUEST_TBOX1)
						== L1Quest.QUEST_END) {
				} else if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1)
						== 1) {
					htmlid = "maptbox";
				}
			} else if (npcid == 71064) {
				if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 2) {
					htmlid = talkToSecondtbox(player);
				}
			} else if (npcid == 71065) {
				if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 3) {
					htmlid = talkToSecondtbox(player);
				}
			} else if (npcid == 71066) {
				if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 4) {
					htmlid = talkToSecondtbox(player);
				}
			} else if (npcid == 71067) {
				if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 5) {
					htmlid = talkToThirdtbox(player);
				}
			} else if (npcid == 71068) {
				if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 6) {
					htmlid = talkToThirdtbox(player);
				}
			} else if (npcid == 71069) {
				if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 7) {
					htmlid = talkToThirdtbox(player);
				}
			} else if (npcid == 71070) {
				if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 8) {
					htmlid = talkToThirdtbox(player);
				}
			} else if (npcid == 71071) {
				if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 9) {
					htmlid = talkToThirdtbox(player);
				}
			} else if (npcid == 71072) {
				if (player.getQuest().get_step(L1Quest.QUEST_LUKEIN1) == 10) {
					htmlid = talkToThirdtbox(player);
				}
			} else if (npcid == 71056) {
				if (player.getQuest().get_step(L1Quest.QUEST_RESTA)
						== 4) {
					if (player.getInventory().checkItem(40631)) {
						htmlid = "SIMIZZ11";
					} else {
						htmlid = "SIMIZZ0";
					}
				} else if (player.getQuest().get_step(L1Quest.QUEST_SIMIZZ)
						== 2) {
					htmlid = "SIMIZZ0";
				} else if (player.getQuest().get_step(L1Quest.QUEST_SIMIZZ)
						== L1Quest.QUEST_END) {
					htmlid = "SIMIZZ15";
				} else if (player.getQuest().get_step(L1Quest.QUEST_SIMIZZ)
						== 1) {
					htmlid = "SIMIZZ6";
				}
			} else if (npcid == 71057) {
				if (player.getQuest().get_step(L1Quest.QUEST_DOIL)
						== L1Quest.QUEST_END) {
					htmlid = "doil4b";
				}
			} else if (npcid == 71059) {
				if (player.getQuest().get_step(L1Quest.QUEST_RUDIAN)
						== L1Quest.QUEST_END) {
					htmlid = "rudian1c";
				} else if (player.getQuest().get_step(L1Quest.QUEST_RUDIAN)
						== 1) {
					htmlid = "rudian7";
				} else if (player.getQuest().get_step(L1Quest.QUEST_DOIL)
						== L1Quest.QUEST_END) {
					htmlid = "rudian1b";
				} else {
					htmlid = "rudian1a";
				}
			} else if (npcid == 71060) {
				if (player.getQuest().get_step(L1Quest.QUEST_RESTA)
						== L1Quest.QUEST_END) {
					htmlid = "resta1e";
				} else if (player.getQuest().get_step(L1Quest.QUEST_SIMIZZ)
						== L1Quest.QUEST_END) {
					htmlid = "resta14";
				} else if (player.getQuest().get_step(L1Quest.QUEST_RESTA)
						== 4) {
					htmlid = "resta13";
				} else if (player.getQuest().get_step(L1Quest.QUEST_RESTA)
						== 3) {
					htmlid = "resta11";
					player.getQuest().set_step(L1Quest.QUEST_RESTA, 4);
				} else if (player.getQuest().get_step(L1Quest.QUEST_RESTA)
						== 2) {
					htmlid = "resta16";
				} else if (player.getQuest().get_step(L1Quest.QUEST_SIMIZZ)
						== 2 
							&& player.getQuest().get_step(L1Quest.
									QUEST_CADMUS) == 1
							|| player.getInventory().checkItem(40647)) {
					htmlid = "resta1a";
				} else if (player.getQuest().get_step(L1Quest.QUEST_CADMUS)
						== 1 
						|| player.getInventory().checkItem(40647)) {
					htmlid = "resta1c";
				} else if (player.getQuest().get_step(L1Quest.QUEST_SIMIZZ)
						== 2) {
					htmlid = "resta1b";
				}
			} else if (npcid == 71061) {
				if (player.getQuest().get_step(L1Quest.QUEST_CADMUS)
						== L1Quest.QUEST_END) {
					htmlid = "cadmus1c";
				} else if (player.getQuest().get_step(L1Quest.QUEST_CADMUS)
						== 3) {
					htmlid = "cadmus8";
				} else if (player.getQuest().get_step(L1Quest.QUEST_CADMUS)
						== 2) {
					htmlid = "cadmus1a";
				} else if (player.getQuest().get_step(L1Quest.QUEST_DOIL)
						== L1Quest.QUEST_END) {
					htmlid = "cadmus1b";
				}
			} else if (npcid == 71062) {
				if (player.getQuest().get_step(L1Quest.QUEST_CADMUS)
						>= 3) {
					htmlid = "kamit2";
				} else if (player.getQuest().get_step(L1Quest.QUEST_CADMUS)
						== 2) {
					htmlid = "kamit1b";
				}
			} else if (npcid == 71036) {
				if (player.getQuest().get_step(L1Quest.QUEST_KAMYLA)
						== L1Quest.QUEST_END) {
					htmlid = "kamyla26";
				} else if (player.getQuest().get_step(L1Quest.QUEST_KAMYLA)
						== 4 && player.getInventory().checkItem(40717)) {
					htmlid = "kamyla15";
				} else if (player.getQuest().get_step(L1Quest.QUEST_KAMYLA)
						== 4 ) {
					htmlid = "kamyla14";
				} else if (player.getQuest().get_step(L1Quest.QUEST_KAMYLA)
						== 3 && player.getInventory().checkItem(40630)) {
					htmlid = "kamyla12";
				} else if (player.getQuest().get_step(L1Quest.QUEST_KAMYLA)
						== 3 ) {
					htmlid = "kamyla11";
				} else if (player.getQuest().get_step(L1Quest.QUEST_KAMYLA)
						== 2 && player.getInventory().checkItem(40644)) {
					htmlid = "kamyla9";
				} else if (player.getQuest().get_step(L1Quest.QUEST_KAMYLA)
						== 1 ) {
					htmlid = "kamyla8";
				} else if (player.getQuest().get_step(L1Quest.QUEST_CADMUS)
						==  L1Quest.QUEST_END && player.getInventory()
							.checkItem(40621)) {
					htmlid = "kamyla1";
				}
			} else if (npcid == 71089) {
				if (player.getQuest().get_step(L1Quest.QUEST_KAMYLA)
						== 2 ) {
					htmlid = "francu12";
				}
			} else if (npcid == 71090) {
				if (player.getQuest().get_step(L1Quest.QUEST_CRYSTAL)
						== 1 && player.getInventory().checkItem(40620)) {
					htmlid = "jcrystal2";
				} else if (player.getQuest().get_step(L1Quest.QUEST_CRYSTAL)
						== 1){
					htmlid = "jcrystal3";
				}
			} else if (npcid == 71091) {
				if (player.getQuest().get_step(L1Quest.QUEST_CRYSTAL)
						== 2 && player.getInventory().checkItem(40654)) {
					htmlid = "jcrystall2";
				}
			} else if (npcid == 71074) { 
				if (player.getQuest().get_step(L1Quest.QUEST_LIZARD)
						== L1Quest.QUEST_END) {
					htmlid = "lelder0";
				} else if (player.getQuest().get_step(L1Quest.QUEST_LIZARD)
						== 3  && player.getInventory().checkItem(40634)) {
					htmlid = "lelder12";
				} else if (player.getQuest().get_step(L1Quest.QUEST_LIZARD)
						== 3) {
					htmlid = "lelder11";
				} else if (player.getQuest().get_step(L1Quest.QUEST_LIZARD)
						== 2  && player.getInventory().checkItem(40633)) {
					htmlid = "lelder7";
				} else if (player.getQuest().get_step(L1Quest.QUEST_LIZARD)
						== 2) {
					htmlid = "lelder7b";
				} else if (player.getQuest().get_step(L1Quest.QUEST_LIZARD)
						== 1) {
					htmlid = "lelder7b";
				} else if (player.getLevel() >= 40) {
					htmlid = "lelder1";
				}
			} else if (npcid == 71075) {
				if (player.getQuest().get_step(L1Quest.QUEST_LIZARD)
						== 1) {
					htmlid = "llizard1b";
				} else {
				}
			} else if (npcid == 71076) {
				if (player.getQuest().get_step(L1Quest.QUEST_LIZARD)
						== L1Quest.QUEST_END) {
					htmlid = "ylizardb";
				} else {
				}
			} else if (npcid == 80079) { 
				if (player.getQuest().get_step(L1Quest.QUEST_KEPLISHA)
						== L1Quest.QUEST_END
								&& !player.getInventory().checkItem(41312)) {
					htmlid = "keplisha6";
				} else {
					if (player.getInventory().checkItem(41314)) { 
						htmlid = "keplisha3";
					} else if (player.getInventory().checkItem(41313)) { 
						htmlid = "keplisha2";
					} else if (player.getInventory().checkItem(41312)) { 
						htmlid = "keplisha4";
					}
				}
			} else if (npcid == 80102) {
				if (player.getInventory().checkItem(41329)) { 
					htmlid = "fillis3";
				}
			} else if (npcid == 71167) { 
				if (player.getTempCharGfx() == 3887) {
					htmlid = "frim1";
				}
			} else if (npcid == 71141) { //
				if (player.getTempCharGfx() == 3887) {//
					htmlid = "moumthree1";
				}
			} else if (npcid == 71142) { //
				if (player.getTempCharGfx() == 3887) {//
					htmlid = "moumtwo1";
				}
			} else if (npcid == 71145) { //
				if (player.getTempCharGfx() == 3887) {//
					htmlid = "moumone1";
				}
			} else if (npcid == 71198) { //
				if (player.getQuest().get_step(71198) == 1) {
					htmlid = "tion4";
				} else if (player.getQuest().get_step(71198) == 2) {
					htmlid = "tion5";
				} else if (player.getQuest().get_step(71198) == 3) {
					htmlid = "tion6";
				} else if (player.getQuest().get_step(71198) == 4) {
					htmlid = "tion7";
				} else if (player.getQuest().get_step(71198) == 5) {
					htmlid = "tion5";
				} else if (player.getInventory().checkItem(21059, 1)) {
					htmlid = "tion19";
				}
			} else if (npcid == 71199) {
				if (player.getQuest().get_step(71199) == 1) {
					htmlid = "jeron3";
				} else if (player.getInventory().checkItem(21059, 1)
						|| player.getQuest().get_step(71199) == 255) {
					htmlid = "jeron7";
				}
			}
			if (htmlid != null) {
				if (htmldata != null) {
					player.sendPackets(new S_NPCTalkReturn(objid, htmlid,
							htmldata));
				} else {
					player.sendPackets(new S_NPCTalkReturn(objid, htmlid));
				}
			} else {
				if (player.getLawful() < -1000) {
					player.sendPackets(new S_NPCTalkReturn(talking, objid, 2));
				} else {
					player.sendPackets(new S_NPCTalkReturn(talking, objid, 1));
				}
			}
		}
	}

	private static String talkToTownadviser(L1PcInstance pc, int town_id) {
		String htmlid;
		if (pc.getHomeTownId() == town_id
				&& TownTable.getInstance().isLeader(pc, town_id)) {
			htmlid = "secretary1";
		} else {
			htmlid = "secretary2";
		}

		return htmlid;
	}

	private static String talkToTownmaster(L1PcInstance pc, int town_id) {
		String htmlid;
		if (pc.getHomeTownId() == town_id) {
			htmlid = "hometown";
		} else {
			htmlid = "othertown";
		}
		return htmlid;
	}

	@Override
	public void onFinalAction(L1PcInstance player, String action) {
	}

	public void doFinalAction(L1PcInstance player) {
	}

	private boolean checkHasCastle(L1PcInstance player, int castle_id) {
		if (player.getClanid() != 0) {
			L1Clan clan = L1World.getInstance().getClan(player.getClanname());
			if (clan != null) {
				if (clan.getCastleId() == castle_id) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkClanLeader(L1PcInstance player) {
		if (player.isCrown()) {
			L1Clan clan = L1World.getInstance().getClan(player.getClanname());
			if (clan != null) {
				if (player.getId() == clan.getLeaderId()) {
					return true;
				}
			}
		}
		return false;
	}

	private int getNecessarySealCount(L1PcInstance pc) {
		int rulerCount = 0;
		int necessarySealCount = 10;
		if (pc.getInventory().checkItem(40917)) {
			rulerCount++;
		}
		if (pc.getInventory().checkItem(40920)) {
			rulerCount++;
		}
		if (pc.getInventory().checkItem(40918)) {
			rulerCount++;
		}
		if (pc.getInventory().checkItem(40919)) {
			rulerCount++;
		}
		if (rulerCount == 0) {
			necessarySealCount = 10;
		} else if (rulerCount == 1) {
			necessarySealCount = 100;
		} else if (rulerCount == 2) {
			necessarySealCount = 200;
		} else if (rulerCount == 3) {
			necessarySealCount = 500;
		}
		return necessarySealCount;
	}

	private void createRuler(L1PcInstance pc, int attr, int sealCount) {
		int rulerId = 0;
		int protectionId = 0;
		int sealId = 0;
		if (attr == 1) {
			rulerId = 40917;
			protectionId = 40909;
			sealId = 40913;
		} else if (attr == 2) {
			rulerId = 40919;
			protectionId = 40911;
			sealId = 40915;
		} else if (attr == 4) {
			rulerId = 40918;
			protectionId = 40910;
			sealId = 40914;
		} else if (attr == 8) {
			rulerId = 40920;
			protectionId = 40912;
			sealId = 40916;
		}
		pc.getInventory().consumeItem(protectionId, 1);
		pc.getInventory().consumeItem(sealId, sealCount);
		L1ItemInstance item = pc.getInventory().storeItem(rulerId, 1);
		if (item != null) {
			pc.sendPackets(new S_ServerMessage(143,
					getNpcTemplate().get_name(), item.getLogName()));
		}
	}

	private String talkToDoromond(L1PcInstance pc) {
		String htmlid = "";
		if (pc.getQuest().get_step(L1Quest.QUEST_DOROMOND) == 0) {
			htmlid = "jpe0011";
		} else if (pc.getQuest().get_step(L1Quest.QUEST_DOROMOND) == 1) {
			htmlid = "jpe0015";
		}

		return htmlid;
	}

	private String talkToAlex(L1PcInstance pc) {
		String htmlid = "";
		if (pc.getLevel() < 3) {
			htmlid = "jpe0021";
		} else if (pc.getQuest().get_step(L1Quest.QUEST_DOROMOND) < 2) {
			htmlid = "jpe0022";
		} else if (pc.getQuest().get_step(L1Quest.QUEST_AREX) == L1Quest.QUEST_END) {
			htmlid = "jpe0023";
		} else if (pc.getLevel() >= 10 && pc.getLevel() < 25) {
			if (pc.getInventory().checkItem(41227)) {
				htmlid = "jpe0023";
			} else if (pc.isCrown()) {
				htmlid = "jpe0024p";
			} else if (pc.isKnight()) {
				htmlid = "jpe0024k";
			} else if (pc.isElf()) {
				htmlid = "jpe0024e";
			} else if (pc.isWizard()) {
				htmlid = "jpe0024w";
			} else if (pc.isDarkelf()) {
				htmlid = "jpe0024d";
			}
		} else if (pc.getLevel() > 25) {
			htmlid = "jpe0023";
		} else {
			htmlid = "jpe0021";
		}
		return htmlid;
	}

	private String talkToAlexInTrainingRoom(L1PcInstance pc) {
		String htmlid = "";
		if (pc.getLevel() < 3) {
			htmlid = "jpe0031";
		} else {
			if (pc.getQuest().get_step(L1Quest.QUEST_DOROMOND) < 2) {
				htmlid = "jpe0035";
			} else {
				htmlid = "jpe0036";
			}
		}

		return htmlid;
	}

	private String cancellation(L1PcInstance pc) {
		String htmlid = "";
		if (pc.getLevel() < 13) {
			htmlid = "jpe0161";
		} else {
			htmlid = "jpe0162";
		}

		return htmlid;
	}

	private String talkToRuba(L1PcInstance pc) {
		String htmlid = "";

		if (pc.isCrown() || pc.isWizard()) {
			htmlid = "en0101";
		} else if (pc.isKnight() || pc.isElf() || pc.isDarkelf()) {
			htmlid = "en0102";
		}

		return htmlid;
	}

	private String talkToSIGuide(L1PcInstance pc) {
		String htmlid = "";
		if (pc.getLevel() < 3) {
			htmlid = "en0301";
		} else if (pc.getLevel() >= 3 && pc.getLevel() < 7) {
			htmlid = "en0302";
		} else if (pc.getLevel() >= 7 && pc.getLevel() < 9) {
			htmlid = "en0303";
		} else if (pc.getLevel() >= 9 && pc.getLevel() < 12) {
			htmlid = "en0304";
		} else if (pc.getLevel() >= 12 && pc.getLevel() < 13) {
			htmlid = "en0305";
		} else if (pc.getLevel() >= 13 && pc.getLevel() < 25) {
			htmlid = "en0306";
		} else {
			htmlid = "en0307";
		}
		return htmlid;
	}

	private String talkToPopirea(L1PcInstance pc) {
		String htmlid = "";
		if (pc.getLevel() < 25) {
			htmlid = "jpe0041";
			if (pc.getInventory().checkItem(41209)
					|| pc.getInventory().checkItem(41210)
					|| pc.getInventory().checkItem(41211)
					|| pc.getInventory().checkItem(41212)) {
				htmlid = "jpe0043";
			}
			if (pc.getInventory().checkItem(41213)) {
				htmlid = "jpe0044";
			}
		} else {
			htmlid = "jpe0045";
		}
		return htmlid;
	}

	private String talkToSecondtbox(L1PcInstance pc) {
		String htmlid = "";
		if (pc.getQuest().get_step(L1Quest.QUEST_TBOX1) ==  L1Quest.QUEST_END) {
			if (pc.getInventory().checkItem(40701)) {
				htmlid = "maptboxa";
			} else {
				htmlid = "maptbox0";
			}
		} else {
			htmlid = "maptbox0";
		}
		return htmlid;
	}

	private String talkToThirdtbox(L1PcInstance pc) {
		String htmlid = "";
		if (pc.getQuest().get_step(L1Quest.QUEST_TBOX2) ==  L1Quest.QUEST_END) {
			if (pc.getInventory().checkItem(40701)) {
				htmlid = "maptboxd";
			} else {
				htmlid = "maptbox0";
			}
		} else {
			htmlid = "maptbox0";
		}
		return htmlid;
	}

}
