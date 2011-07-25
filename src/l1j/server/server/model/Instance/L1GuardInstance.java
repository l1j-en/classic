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

import java.util.logging.Logger;

import l1j.server.server.ActionCodes;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.L1World;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.types.Point;

public class L1GuardInstance extends L1NpcInstance {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger _log = Logger.getLogger(L1GuardInstance.class.getName());

	@Override
	public void searchTarget() {
		int npcid = getNpcTemplate().get_npcId();
		L1PcInstance targetPlayer = null;
		L1MonsterInstance targetMonster = null;
		for (L1Object obj : L1World.getInstance().getVisibleObjects(this)) {
		    if (obj instanceof L1MonsterInstance) {
		     L1MonsterInstance mon = (L1MonsterInstance) obj;
		     if(mon.getHiddenStatus() != 0 || mon.isDead()){
				continue;
		     }
		     // L1Guard Kill Monsters When They Are Near A Guard.
		     if(this.getNpcTemplate().get_npcId() == 45662 
		    		 || this.getNpcTemplate().get_npcId() == 60562
		    		 || this.getNpcTemplate().get_npcId() == 60560
		    		 || this.getNpcTemplate().get_npcId() == 60552
		    		 || this.getNpcTemplate().get_npcId() == 60549
		    		 || this.getNpcTemplate().get_npcId() == 60550
		    		 || this.getNpcTemplate().get_npcId() == 60540
		    		 || this.getNpcTemplate().get_npcId() == 60539
		    		 || this.getNpcTemplate().get_npcId() == 60538
		    		 || this.getNpcTemplate().get_npcId() == 60536
		    		 || this.getNpcTemplate().get_npcId() == 60535
		    		 || this.getNpcTemplate().get_npcId() == 60529
		    		 || this.getNpcTemplate().get_npcId() == 60525
		    		 || this.getNpcTemplate().get_npcId() == 60524
		    		 || this.getNpcTemplate().get_npcId() == 60514
		    		 || this.getNpcTemplate().get_npcId() == 60512
		    		 || this.getNpcTemplate().get_npcId() == 60511
		    		 || this.getNpcTemplate().get_npcId() == 45655
		    		 || this.getNpcTemplate().get_npcId() == 45656
		    		 || this.getNpcTemplate().get_npcId() == 45657
		    		 || this.getNpcTemplate().get_npcId() == 45658
		    		 || this.getNpcTemplate().get_npcId() == 45659
		    		 || this.getNpcTemplate().get_npcId() == 45660
		    		 || this.getNpcTemplate().get_npcId() == 45661
		    		 || this.getNpcTemplate().get_npcId() == 45662
		    		 || this.getNpcTemplate().get_npcId() == 60511
		    		 || this.getNpcTemplate().get_npcId() == 60501
		    		 || this.getNpcTemplate().get_npcId() == 60501
		    		 || this.getNpcTemplate().get_npcId() == 60502
		    		 || this.getNpcTemplate().get_npcId() == 60503
		    		 || this.getNpcTemplate().get_npcId() == 60504
		    		 || this.getNpcTemplate().get_npcId() == 60505
		    		 || this.getNpcTemplate().get_npcId() == 60506
		    		 || this.getNpcTemplate().get_npcId() == 60507
		    		 || this.getNpcTemplate().get_npcId() == 60508
		    		 || this.getNpcTemplate().get_npcId() == 60509
		    		 || this.getNpcTemplate().get_npcId() == 60510
		    		 || this.getNpcTemplate().get_npcId() == 60511
		    		 || this.getNpcTemplate().get_npcId() == 60512
		    		 || this.getNpcTemplate().get_npcId() == 60513
		    		 || this.getNpcTemplate().get_npcId() == 60517
		    		 || this.getNpcTemplate().get_npcId() == 60518
		    		 || this.getNpcTemplate().get_npcId() == 60519
		    		 || this.getNpcTemplate().get_npcId() == 60520
		    		 || this.getNpcTemplate().get_npcId() == 60521
		    		 || this.getNpcTemplate().get_npcId() == 60522
		    		 || this.getNpcTemplate().get_npcId() == 60523
		    		 || this.getNpcTemplate().get_npcId() == 60524
		    		 || this.getNpcTemplate().get_npcId() == 60525
		    		 || this.getNpcTemplate().get_npcId() == 60526
		    		 || this.getNpcTemplate().get_npcId() == 60527
		    		 || this.getNpcTemplate().get_npcId() == 60528
		    		 || this.getNpcTemplate().get_npcId() == 60530
		    		 || this.getNpcTemplate().get_npcId() == 60531
		    		 || this.getNpcTemplate().get_npcId() == 60532
		    		 || this.getNpcTemplate().get_npcId() == 60533
		    		 || this.getNpcTemplate().get_npcId() == 60534
		    		 || this.getNpcTemplate().get_npcId() == 60537
		    		 || this.getNpcTemplate().get_npcId() == 60538
		    		 || this.getNpcTemplate().get_npcId() == 60539
		    		 || this.getNpcTemplate().get_npcId() == 60540
		    		 || this.getNpcTemplate().get_npcId() == 60541
		    		 || this.getNpcTemplate().get_npcId() == 60542
		    		 || this.getNpcTemplate().get_npcId() == 60543
		    		 || this.getNpcTemplate().get_npcId() == 60544
		    		 || this.getNpcTemplate().get_npcId() == 60545
		    		 || this.getNpcTemplate().get_npcId() == 60546
		    		 || this.getNpcTemplate().get_npcId() == 60547
		    		 || this.getNpcTemplate().get_npcId() == 60548
		    		 || this.getNpcTemplate().get_npcId() == 60551
		    		 || this.getNpcTemplate().get_npcId() == 60553
		    		 || this.getNpcTemplate().get_npcId() == 60554
		    		 || this.getNpcTemplate().get_npcId() == 60555
		    		 || this.getNpcTemplate().get_npcId() == 60556
		    		 || this.getNpcTemplate().get_npcId() == 60557
		    		 || this.getNpcTemplate().get_npcId() == 60558
		    		 || this.getNpcTemplate().get_npcId() == 60559
		    		 || this.getNpcTemplate().get_npcId() == 60563
		    		 || this.getNpcTemplate().get_npcId() == 60564
		    		 || this.getNpcTemplate().get_npcId() == 60567
		    		 || this.getNpcTemplate().get_npcId() == 60521
		    		 || this.getNpcTemplate().get_npcId() == 60541
		    		 || this.getNpcTemplate().get_npcId() == 60564
		    		 || this.getNpcTemplate().get_npcId() == 60575
		    		 || this.getNpcTemplate().get_npcId() == 60646
		    		 || this.getNpcTemplate().get_npcId() == 60769
		    		 || this.getNpcTemplate().get_npcId() == 60793
		    		 || this.getNpcTemplate().get_npcId() == 60809
		    		 || this.getNpcTemplate().get_npcId() == 60857
		    		 || this.getNpcTemplate().get_npcId() == 71183
		    		 || this.getNpcTemplate().get_npcId() == 71185
		    		 || this.getNpcTemplate().get_npcId() == 71186		 
		    		 || this.getNpcTemplate().get_npcId() == 70703
		    		 || this.getNpcTemplate().get_npcId() == 70704
		    		 || this.getNpcTemplate().get_npcId() == 70827
		    		 || this.getNpcTemplate().get_npcId() == 80147
		    		 || this.getNpcTemplate().get_npcId() == 80148
		    		 || this.getNpcTemplate().get_npcId() == 80138
		    		 || this.getNpcTemplate().get_npcId() == 80139){
		    	 //Guards Kill These Monsters Near Town.
				if (mon.getNpcTemplate().get_npcId() == 45009 
						|| mon.getNpcTemplate().get_npcId() == 45008
						|| mon.getNpcTemplate().get_npcId() == 45016
						|| mon.getNpcTemplate().get_npcId() == 45017
						|| mon.getNpcTemplate().get_npcId() == 45019
						|| mon.getNpcTemplate().get_npcId() == 45023
						|| mon.getNpcTemplate().get_npcId() == 45024
						|| mon.getNpcTemplate().get_npcId() == 45027
						|| mon.getNpcTemplate().get_npcId() == 45034
						|| mon.getNpcTemplate().get_npcId() == 45035
						|| mon.getNpcTemplate().get_npcId() == 45036
						|| mon.getNpcTemplate().get_npcId() == 45037
						|| mon.getNpcTemplate().get_npcId() == 45038
						|| mon.getNpcTemplate().get_npcId() == 45039
						|| mon.getNpcTemplate().get_npcId() == 45040
						|| mon.getNpcTemplate().get_npcId() == 45041
						|| mon.getNpcTemplate().get_npcId() == 45042
						|| mon.getNpcTemplate().get_npcId() == 45043
						|| mon.getNpcTemplate().get_npcId() == 45044
						|| mon.getNpcTemplate().get_npcId() == 45045
						|| mon.getNpcTemplate().get_npcId() == 45046
						|| mon.getNpcTemplate().get_npcId() == 45047
						|| mon.getNpcTemplate().get_npcId() == 45048
						|| mon.getNpcTemplate().get_npcId() == 45049
						|| mon.getNpcTemplate().get_npcId() == 45050
						|| mon.getNpcTemplate().get_npcId() == 45051
						|| mon.getNpcTemplate().get_npcId() == 45053
						|| mon.getNpcTemplate().get_npcId() == 45054
						|| mon.getNpcTemplate().get_npcId() == 45056
						|| mon.getNpcTemplate().get_npcId() == 45058
						|| mon.getNpcTemplate().get_npcId() == 45064
						|| mon.getNpcTemplate().get_npcId() == 45065
						|| mon.getNpcTemplate().get_npcId() == 45066
						|| mon.getNpcTemplate().get_npcId() == 45067
						|| mon.getNpcTemplate().get_npcId() == 45068
						|| mon.getNpcTemplate().get_npcId() == 45071
						|| mon.getNpcTemplate().get_npcId() == 45078
						|| mon.getNpcTemplate().get_npcId() == 45079
						|| mon.getNpcTemplate().get_npcId() == 45081
						|| mon.getNpcTemplate().get_npcId() == 45082
						|| mon.getNpcTemplate().get_npcId() == 45083
						|| mon.getNpcTemplate().get_npcId() == 45084
						|| mon.getNpcTemplate().get_npcId() == 45086
						|| mon.getNpcTemplate().get_npcId() == 45090
						|| mon.getNpcTemplate().get_npcId() == 45091
						|| mon.getNpcTemplate().get_npcId() == 45092
						|| mon.getNpcTemplate().get_npcId() == 45093
						|| mon.getNpcTemplate().get_npcId() == 45094
						|| mon.getNpcTemplate().get_npcId() == 45095
						|| mon.getNpcTemplate().get_npcId() == 45096
						|| mon.getNpcTemplate().get_npcId() == 45099
						|| mon.getNpcTemplate().get_npcId() == 45101
						|| mon.getNpcTemplate().get_npcId() == 45104
						|| mon.getNpcTemplate().get_npcId() == 45105
						|| mon.getNpcTemplate().get_npcId() == 45107
						|| mon.getNpcTemplate().get_npcId() == 45108
						|| mon.getNpcTemplate().get_npcId() == 45109
						|| mon.getNpcTemplate().get_npcId() == 45111
						|| mon.getNpcTemplate().get_npcId() == 45114
						|| mon.getNpcTemplate().get_npcId() == 45122
						|| mon.getNpcTemplate().get_npcId() == 45123
						|| mon.getNpcTemplate().get_npcId() == 45124						
						|| mon.getNpcTemplate().get_npcId() == 45125
						|| mon.getNpcTemplate().get_npcId() == 45129
						|| mon.getNpcTemplate().get_npcId() == 45130
						|| mon.getNpcTemplate().get_npcId() == 45131
						|| mon.getNpcTemplate().get_npcId() == 45133
						|| mon.getNpcTemplate().get_npcId() == 45134
						|| mon.getNpcTemplate().get_npcId() == 45136
						|| mon.getNpcTemplate().get_npcId() == 45140
						|| mon.getNpcTemplate().get_npcId() == 45142
						|| mon.getNpcTemplate().get_npcId() == 45147
						|| mon.getNpcTemplate().get_npcId() == 45148
						|| mon.getNpcTemplate().get_npcId() == 45155
						|| mon.getNpcTemplate().get_npcId() == 45157
						|| mon.getNpcTemplate().get_npcId() == 45165
						|| mon.getNpcTemplate().get_npcId() == 45173
						|| mon.getNpcTemplate().get_npcId() == 45181
						|| mon.getNpcTemplate().get_npcId() == 45182
						|| mon.getNpcTemplate().get_npcId() == 45184
						|| mon.getNpcTemplate().get_npcId() == 45189
						|| mon.getNpcTemplate().get_npcId() == 45192
						|| mon.getNpcTemplate().get_npcId() == 45196
						|| mon.getNpcTemplate().get_npcId() == 45213
						|| mon.getNpcTemplate().get_npcId() == 45215
						|| mon.getNpcTemplate().get_npcId() == 45223
						|| mon.getNpcTemplate().get_npcId() == 45229
						|| mon.getNpcTemplate().get_npcId() == 45257
						|| mon.getNpcTemplate().get_npcId() == 45259
						|| mon.getNpcTemplate().get_npcId() == 45262
						|| mon.getNpcTemplate().get_npcId() == 45264
						|| mon.getNpcTemplate().get_npcId() == 45267
						|| mon.getNpcTemplate().get_npcId() == 45278
						|| mon.getNpcTemplate().get_npcId() == 45294
						|| mon.getNpcTemplate().get_npcId() == 45307
						|| mon.getNpcTemplate().get_npcId() == 45313
						|| mon.getNpcTemplate().get_npcId() == 45332
						|| mon.getNpcTemplate().get_npcId() == 45338
						|| mon.getNpcTemplate().get_npcId() == 45346
						|| mon.getNpcTemplate().get_npcId() == 45349
						|| mon.getNpcTemplate().get_npcId() == 45352
						|| mon.getNpcTemplate().get_npcId() == 45355
						|| mon.getNpcTemplate().get_npcId() == 45358
						|| mon.getNpcTemplate().get_npcId() == 45371
						|| mon.getNpcTemplate().get_npcId() == 45378
						|| mon.getNpcTemplate().get_npcId() == 45381
						|| mon.getNpcTemplate().get_npcId() == 45387
						|| mon.getNpcTemplate().get_npcId() == 45401
						|| mon.getNpcTemplate().get_npcId() == 45406
						|| mon.getNpcTemplate().get_npcId() == 45452
						|| mon.getNpcTemplate().get_npcId() == 45457
						|| mon.getNpcTemplate().get_npcId() == 45222) {
						targetMonster = mon;
						break;
					}
				}
				}
		for (L1PcInstance pc : L1World.getInstance().getVisiblePlayer(this)) {
			if (pc.getCurrentHp() <= 0 || pc.isDead() || pc.isGm()
					|| pc.isGhost()) {
				continue;
			}
			if (!pc.isInvisble() || getNpcTemplate().is_agrocoi())
			{
				//target pk'ers if not casle owners
				//custom, do not remove in merges
				if (pc.isWanted() && npcid == 60513 && checkHasCastle(pc,L1CastleLocation.KENT_CASTLE_ID)) {
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 60514 && checkHasCastle(pc,L1CastleLocation.KENT_CASTLE_ID)) {
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 70549 && checkHasCastle(pc,L1CastleLocation.KENT_CASTLE_ID)) {
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 70656 && checkHasCastle(pc,L1CastleLocation.KENT_CASTLE_ID)) {
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 81156 && checkHasCastle(pc,L1CastleLocation.DIAD_CASTLE_ID)) {
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 60533 && checkHasCastle(pc,L1CastleLocation.ADEN_CASTLE_ID)) { 
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 60534 && checkHasCastle(pc,L1CastleLocation.ADEN_CASTLE_ID)) { 
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 60530 && checkHasCastle(pc,L1CastleLocation.DOWA_CASTLE_ID)) { 
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 60531 && checkHasCastle(pc,L1CastleLocation.DOWA_CASTLE_ID)) { 
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 70857 && checkHasCastle(pc,L1CastleLocation.HEINE_CASTLE_ID)) {
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 60524 && checkHasCastle(pc,L1CastleLocation.GIRAN_CASTLE_ID)) {
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 60525 && checkHasCastle(pc,L1CastleLocation.GIRAN_CASTLE_ID)) {
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 60529 && checkHasCastle(pc,L1CastleLocation.GIRAN_CASTLE_ID)) {
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 60552 && checkHasCastle(pc,L1CastleLocation.OT_CASTLE_ID)) {
					targetPlayer = null;
				} else if (pc.isWanted() && npcid == 60560 && checkHasCastle(pc,L1CastleLocation.KENT_CASTLE_ID)) {	
					targetPlayer = null;
				} else if (!pc.isWanted()) {
					targetPlayer = null;
				} else {
					targetPlayer = pc;
					break;
				}
			}
		}
		if (targetPlayer != null) {
			_hateList.add(targetPlayer, 0);
			_target = targetPlayer;
	}
		}
	  if(targetMonster != null){ 
		_hateList.add(targetMonster, 0);
        _target = targetMonster; 
	  }
	}

	public void setTarget(L1PcInstance targetPlayer) {
		L1MonsterInstance targetMonster = null;
		if (targetPlayer != null) {
			_hateList.add(targetPlayer, 0);
			_target = targetPlayer;
		}
	if(targetMonster != null){ 
		_hateList.add(targetMonster, 0);
        _target = targetMonster; 
		}
	}

	public boolean noTarget(int depth) {
		if (getLocation()
				.getTileLineDistance(new Point(getHomeX(), getHomeY())) > 0) {
			int dir = moveDirection(getHomeX(), getHomeY());
			if (dir != -1) {
				setDirectionMove(dir);
				setSleepTime(calcSleepTime(getPassispeed(), MOVE_SPEED));
			} else 
			{
				teleport(getHomeX(), getHomeY(), 1);
			}
		} else {
			if (L1World.getInstance().getRecognizePlayer(this).size() == 0) {
				return true; 
			}
		}
		return false;
	}

	public L1GuardInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void onNpcAI() {
		if (isAiRunning()) {
			return;
		}
		setActived(false);
		startAI();
		startChat(CHAT_TIMING_APPEARANCE); 
	}

	@Override
	public void onAction(L1PcInstance pc) {
		if (!isDead()) {
			if (getCurrentHp() > 0) {
				L1Attack attack = new L1Attack(pc, this);
				if (attack.calcHit()) {
					attack.calcDamage();
					attack.calcStaffOfMana();
					attack.addPcPoisonAttack(pc, this);
					attack.addChaserAttack();
				}
				attack.action();
				attack.commit();
			} else {
				L1Attack attack = new L1Attack(pc, this);
				attack.calcHit();
				attack.action();
			}
		}
	}

	public void onAction(L1MonsterInstance mon) {
		if (!isDead()) {
			if (getCurrentHp() > 0) {
				L1Attack attack = new L1Attack(mon, this);
				if (attack.calcHit()) {
					attack.calcDamage();
				}
				attack.action();
				attack.commit();
			} else {
				L1Attack attack = new L1Attack(mon, this);
				attack.calcHit();
				attack.action();
			}
			}
		}
	@Override
	public void onTalkAction(L1PcInstance player) {
		int objid = getId();
		L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(
				getNpcTemplate().get_npcId());
		int npcid = getNpcTemplate().get_npcId();
		String htmlid = null;
		String[] htmldata = null;
		boolean hascastle = false;
		String clan_name = "";
		String pri_name = "";

		if (talking != null) {

			if (npcid == 70549 || 
					npcid == 70985) { 
				hascastle = checkHasCastle(player,
						L1CastleLocation.KENT_CASTLE_ID);
				if (hascastle) { 
					htmlid = "gateokeeper";
					htmldata = new String[] { player.getName() };
				} else {
					htmlid = "gatekeeperop";
				}
			} else if (npcid == 70656) {
				hascastle = checkHasCastle(player,
						L1CastleLocation.KENT_CASTLE_ID);
				if (hascastle) {
					htmlid = "gatekeeper";
					htmldata = new String[] { player.getName() };
				} else {
					htmlid = "gatekeeperop";
				}
			} else if (npcid == 70600 ||
					npcid == 70986) {
				hascastle = checkHasCastle(player,
						L1CastleLocation.OT_CASTLE_ID);
				if (hascastle) { 
					htmlid = "orckeeper";
				} else {
					htmlid = "orckeeperop";
				}
			} else if (npcid == 70687 || 
					npcid == 70987) {
				hascastle = checkHasCastle(player,
						L1CastleLocation.WW_CASTLE_ID);
				if (hascastle) { 
					htmlid = "gateokeeper";
					htmldata = new String[] { player.getName() };
				} else {
					htmlid = "gatekeeperop";
				}
			} else if (npcid == 70778) { 
				hascastle = checkHasCastle(player,
						L1CastleLocation.WW_CASTLE_ID);
				if (hascastle) { 
					htmlid = "gatekeeper";
					htmldata = new String[] { player.getName() };
				} else {
					htmlid = "gatekeeperop";
				}
			} else if (npcid == 70800
					|| 
					npcid == 70988 || npcid == 70989 || npcid == 70990
					|| npcid == 70991) {
				hascastle = checkHasCastle(player,
						L1CastleLocation.GIRAN_CASTLE_ID);
				if (hascastle) { 
					htmlid = "gateokeeper";
					htmldata = new String[] { player.getName() };
				} else {
					htmlid = "gatekeeperop";
				}
			} else if (npcid == 70817) { 
				hascastle = checkHasCastle(player,
						L1CastleLocation.GIRAN_CASTLE_ID);
				if (hascastle) {
					htmlid = "gatekeeper";
					htmldata = new String[] { player.getName() };
				} else {
					htmlid = "gatekeeperop";
				}
			} else if (npcid == 70862 || 
					npcid == 70992) {
				hascastle = checkHasCastle(player,
						L1CastleLocation.HEINE_CASTLE_ID);
				if (hascastle) { 
					htmlid = "gateokeeper";
					htmldata = new String[] { player.getName() };
				} else {
					htmlid = "gatekeeperop";
				}
			} else if (npcid == 70863) { 
				hascastle = checkHasCastle(player,
						L1CastleLocation.HEINE_CASTLE_ID);
				if (hascastle) { 
					htmlid = "gatekeeper";
					htmldata = new String[] { player.getName() };
				} else {
					htmlid = "gatekeeperop";
				}
			} else if (npcid == 70993 ||
					npcid == 70994) {
				hascastle = checkHasCastle(player,
						L1CastleLocation.DOWA_CASTLE_ID);
				if (hascastle) { 
					htmlid = "gateokeeper";
					htmldata = new String[] { player.getName() };
				} else {
					htmlid = "gatekeeperop";
				}
			} else if (npcid == 70995) { 
				hascastle = checkHasCastle(player,
						L1CastleLocation.DOWA_CASTLE_ID);
				if (hascastle) { 
					htmlid = "gatekeeper";
					htmldata = new String[] { player.getName() };
				} else {
					htmlid = "gatekeeperop";
				}
			} else if (npcid == 70996) { 
				hascastle = checkHasCastle(player,
						L1CastleLocation.ADEN_CASTLE_ID);
				if (hascastle) { 
					htmlid = "gatekeeper";
					htmldata = new String[] { player.getName() };
				} else {
					htmlid = "gatekeeperop";
				}
			}
			else if (npcid == 60514) {
				for (L1Clan clan : L1World.getInstance().getAllClans()) {
					if (clan.getCastleId()
					== L1CastleLocation.KENT_CASTLE_ID) {
						clan_name = clan.getClanName();
						pri_name = clan.getLeaderName();
						break;
					}
				}
				htmlid = "ktguard6";
				htmldata = new String[] { getName(), clan_name, pri_name };
			} else if (npcid == 60560) { 
				for (L1Clan clan : L1World.getInstance().getAllClans()) {
					if (clan.getCastleId()
					== L1CastleLocation.OT_CASTLE_ID) {
						clan_name = clan.getClanName();
						pri_name = clan.getLeaderName();
						break;
					}
				}
				htmlid = "orcguard6";
				htmldata = new String[] { getName(), clan_name, pri_name };
			} else if (npcid == 60552) {
				for (L1Clan clan : L1World.getInstance().getAllClans()) {
					if (clan.getCastleId() 
					== L1CastleLocation.WW_CASTLE_ID) {
						clan_name = clan.getClanName();
						pri_name = clan.getLeaderName();
						break;
					}
				}
				htmlid = "wdguard6";
				htmldata = new String[] { getName(), clan_name, pri_name };
			} else if (npcid == 60524 || npcid == 60525 || npcid == 60529) { 
				for (L1Clan clan : L1World.getInstance().getAllClans()) {
					if (clan.getCastleId() 
					== L1CastleLocation.GIRAN_CASTLE_ID) {
						clan_name = clan.getClanName();
						pri_name = clan.getLeaderName();
						break;
					}
				}
				htmlid = "grguard6";
				htmldata = new String[] { getName(), clan_name, pri_name };
			} else if (npcid == 70857) { 
				for (L1Clan clan : L1World.getInstance().getAllClans()) {
					if (clan.getCastleId() == L1CastleLocation.HEINE_CASTLE_ID) {
						clan_name = clan.getClanName();
						pri_name = clan.getLeaderName();
						break;
					}
				}
				htmlid = "heguard6";
				htmldata = new String[] { getName(), clan_name, pri_name };
			} else if (npcid == 60530 || 
					npcid == 60531) {
				for (L1Clan clan : L1World.getInstance().getAllClans()) {
					if (clan.getCastleId() == L1CastleLocation.DOWA_CASTLE_ID) {
						clan_name = clan.getClanName();
						pri_name = clan.getLeaderName();
						break;
					}
				}
				htmlid = "dcguard6";
				htmldata = new String[] { getName(), clan_name, pri_name };
			} else if (npcid == 60533 || 
					npcid == 60534) {
				for (L1Clan clan : L1World.getInstance().getAllClans()) {
					if (clan.getCastleId() == L1CastleLocation.ADEN_CASTLE_ID) {
						clan_name = clan.getClanName();
						pri_name = clan.getLeaderName();
						break;
					}
				}
				htmlid = "adguard6";
				htmldata = new String[] { getName(), clan_name, pri_name };
			} else if (npcid == 81156) { 
				for (L1Clan clan : L1World.getInstance().getAllClans()) {
					if (clan.getCastleId() == L1CastleLocation.DIAD_CASTLE_ID) {
						clan_name = clan.getClanName();
						pri_name = clan.getLeaderName();
						break;
					}
				}
				htmlid = "ktguard6";
				htmldata = new String[] { getName(), clan_name, pri_name };
			}

			// html
			if (htmlid != null) { // htmlid
				if (htmldata != null) { // html
					player.sendPackets(new S_NPCTalkReturn(objid, htmlid, htmldata));
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

	public void onFinalAction() {

	}

	public void doFinalAction() {

	}

	@Override
	public void receiveDamage(L1Character attacker, int damage) {
		if (getCurrentHp() > 0 && !isDead()) {
			if (damage >= 0) {
				if (!(attacker instanceof L1EffectInstance)) {
					setHate(attacker, damage);
				}
			}
			if (damage > 0) {
				removeSkillEffect(L1SkillId.FOG_OF_SLEEPING);
			}

			onNpcAI();

			if (attacker instanceof L1PcInstance && damage > 0) {
				L1PcInstance pc = (L1PcInstance) attacker;
				pc.setPetTarget(this);
			}

			int newHp = getCurrentHp() - damage;
			if (newHp <= 0 && !isDead()) {
				setCurrentHpDirect(0);
				setDead(true);
				setStatus(ActionCodes.ACTION_Die);
				Death death = new Death(attacker);
				GeneralThreadPool.getInstance().execute(death);
			}
			if (newHp > 0) {
				setCurrentHp(newHp);
			}
		} else if (getCurrentHp() == 0 && !isDead()) {
		} else if (!isDead()) { 
			setDead(true);
			setStatus(ActionCodes.ACTION_Die);
			Death death = new Death(attacker);
			GeneralThreadPool.getInstance().execute(death);
		}
	}

	@Override
	public void setCurrentHp(int i) {
		int currentHp = i;
		if (currentHp >= getMaxHp()) {
			currentHp = getMaxHp();
		}
		setCurrentHpDirect(currentHp);

		if (getMaxHp() > getCurrentHp()) {
			startHpRegeneration();
		}
	}

	class Death implements Runnable {
		L1Character _lastAttacker;

		public Death(L1Character lastAttacker) {
			_lastAttacker = lastAttacker;
		}

		@Override
		public void run() {
			setDeathProcessing(true);
			setCurrentHpDirect(0);
			setDead(true);
			setStatus(ActionCodes.ACTION_Die);

			getMap().setPassable(getLocation(), true);

			broadcastPacket(new S_DoActionGFX(getId(), ActionCodes.ACTION_Die));

			startChat(CHAT_TIMING_DEAD);

			setDeathProcessing(false);

			allTargetClear();

			startDeleteTimer();
		}
	}

	private boolean checkHasCastle(L1PcInstance pc, int castleId) {
		boolean isExistDefenseClan = false;
		for (L1Clan clan : L1World.getInstance().getAllClans()) {
			if (castleId == clan.getCastleId()) {
				isExistDefenseClan = true;
				break;
			}
		}
		if (!isExistDefenseClan) { 
			return true;
		}

		if (pc.getClanid() != 0) { 
			L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				if (clan.getCastleId() == castleId) {
					return true;
				}
			}
		}
		return false;
	}
}
