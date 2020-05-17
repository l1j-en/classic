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
package l1j.server.server.clientpackets;

import static l1j.server.server.model.skill.L1SkillId.ABSOLUTE_BARRIER;
import static l1j.server.server.model.skill.L1SkillId.CALL_CLAN;
import static l1j.server.server.model.skill.L1SkillId.FIRE_WALL;
import static l1j.server.server.model.skill.L1SkillId.LIFE_STREAM;
import static l1j.server.server.model.skill.L1SkillId.MASS_TELEPORT;
import static l1j.server.server.model.skill.L1SkillId.MEDITATION;
import static l1j.server.server.model.skill.L1SkillId.RUN_CLAN;
import static l1j.server.server.model.skill.L1SkillId.TELEPORT;
import static l1j.server.server.model.skill.L1SkillId.TRUE_TARGET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.datatables.SkillTable;
import l1j.server.server.model.AcceleratorChecker;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1BookMark;
import l1j.server.server.templates.L1Skill;


// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket
public class C_UseSkill extends ClientBasePacket {

	private static Logger _log = LoggerFactory.getLogger(C_UseSkill.class.getName());
	
	public C_UseSkill(byte abyte0[], Client client) throws Exception {
		super(abyte0);
		int row = readC();
		int column = readC();
		int skillId = (row * 8) + column + 1;
		String charName = null;
		String message = null;
		int targetId = 0;
		int targetX = 0;
		int targetY = 0;
		
		L1PcInstance pc = client.getActiveChar();

		if (pc.isTeleport() || pc.isDead()) {
			return;
		}

		if (!pc.getMap().isUsableSkill()) {
			pc.sendPackets(new S_ServerMessage(563)); // You can't use it here.
			return;
		}

		if (!pc.isSkillMastery(skillId)) {
			return;
		}

		if (Config.CHECK_SPELL_INTERVAL) {
			int result;
			// FIXME dir/no dir
			L1Skill skill = SkillTable.getInstance().findBySkillId(skillId);
			if (SkillTable.getInstance().findBySkillId(skillId).getActionId() == ActionCodes.ACTION_SkillAttack) {
				result = pc.getAcceleratorChecker().checkInterval(
						AcceleratorChecker.ACT_TYPE.SPELL_DIR, skill);
			} else {
				result = pc.getAcceleratorChecker().checkInterval(
						AcceleratorChecker.ACT_TYPE.SPELL_NODIR, skill);
			}
			if (result == AcceleratorChecker.R_LIMITEXCEEDED) {
				return;
			}
		}

		if (abyte0.length > 4) {
			try {
				if (skillId == CALL_CLAN || skillId == RUN_CLAN) {
					charName = readS();
					
					// fix for being able to double click names when using
					// call clan
					int bracketIndex = charName.indexOf("[");
					if(bracketIndex > -1) {
						charName = charName.substring(0,  bracketIndex);
					}
				} else if (skillId == TRUE_TARGET) {
					targetId = readD();
					targetX = readH();
					targetY = readH();
					message = readS();
				} else if (skillId == TELEPORT || skillId == MASS_TELEPORT) {
					int mapId = readH();
					int x = readH();
					int y = readH();
					
					L1BookMark bookmark = pc.getBookMarkByCoords(x, y, mapId);
					if(bookmark != null) {
						targetId = bookmark.getId();
					}
				} else if (skillId == FIRE_WALL || skillId == LIFE_STREAM) {
					targetX = readH();
					targetY = readH();
				} else {
					targetId = readD();
					targetX = readH();
					targetY = readH();
				}
			} catch (Exception e) {
				if (Config.LOGGING_INCOMING_PACKETS) 
					_log.warn("SKILL ERROR: skillid " + skillId + " has some sort of issue:\n" + e);
			}
		}

		if (pc.isTeleport()) {
			return;
		}

		if (pc.isDead()) {
			return;
		}

		if (pc.hasSkillEffect(ABSOLUTE_BARRIER)) {
			pc.killSkillEffectTimer(ABSOLUTE_BARRIER);
			pc.startHpRegeneration();
			pc.startMpRegeneration();
			pc.startMpRegenerationByDoll();
		}
		pc.killSkillEffectTimer(MEDITATION);

		try {
			if (skillId == CALL_CLAN || skillId == RUN_CLAN) {
				if (charName.isEmpty()) {
					return;
				}

				L1PcInstance target = L1World.getInstance().getPlayer(charName);

				if (target == null) {
					pc.sendPackets(new S_ServerMessage(73, charName)); // 'player' is not playing now.
					return;
				}

				if (pc.getClanid() != target.getClanid()) {
					pc.sendPackets(new S_ServerMessage(414)); // That person is not a member of the same Blood Pledge.
					return;
				}
				targetId = target.getId();
				if (skillId == CALL_CLAN) {
					int callClanId = pc.getCallClanId();
					if (callClanId == 0 || callClanId != targetId) {
						pc.setCallClanId(targetId);
						pc.setCallClanHeading(pc.getHeading());
					}
				}
			}
			L1SkillUse l1skilluse = new L1SkillUse();
			l1skilluse.handleCommands(pc, skillId, targetId, targetX, targetY,
					message, 0, L1SkillUse.TYPE_NORMAL);
		} catch (Exception e) {
			_log.error("",e);
		}
	}
}
