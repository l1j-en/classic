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

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.ClientThread;
import l1j.server.server.model.AcceleratorChecker;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.L1SkillId;
import static l1j.server.server.model.Instance.L1PcInstance.REGENSTATE_ATTACK;
import l1j.server.server.serverpackets.S_AttackMissPacket;
import l1j.server.server.serverpackets.S_AttackStatus;
import l1j.server.server.serverpackets.S_ServerMessage;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

public class C_Attack extends ClientBasePacket {
	private static final String C_Attack = "[C] C_Attack";

	public C_Attack(byte[] decrypt, ClientThread client) {
		super(decrypt);
		int targetId = readD();
		int x = readH();
		int y = readH();

		L1PcInstance pc = client.getActiveChar();

		if (pc.isGhost() || pc.isDead() || pc.isTeleport()) {
			return;
		}

		L1Object target = L1World.getInstance().findObject(targetId);

		if (pc.getInventory().getWeight30() > 24) { 
			pc.sendPackets(new S_ServerMessage(110)); 
			return;
		}

		if (pc.isInvisble()) { 
			return;
		}

		if (pc.isInvisDelay()) {
			return;
		}

		if (target instanceof L1Character) {
			if (target.getMapId() != pc.getMapId()
					|| pc.getLocation().getLineDistance(target.getLocation()) > 20D) { 
				return;
			}
		}

		if (target instanceof L1NpcInstance) {
			if (((L1NpcInstance) target).getHiddenStatus() != 0) { 
				return;
			}
		}

		if (Config.CHECK_ATTACK_INTERVAL) {
			int result;
			result = pc.getAcceleratorChecker()
					.checkInterval(AcceleratorChecker.ACT_TYPE.ATTACK);
			if (result == AcceleratorChecker.R_DISCONNECTED) {
				return;
			}
		}

		if (pc.hasSkillEffect(L1SkillId.ABSOLUTE_BARRIER)) { 
			pc.killSkillEffectTimer(L1SkillId.ABSOLUTE_BARRIER);
			pc.startHpRegeneration();
			pc.startMpRegeneration();
			pc.startMpRegenerationByDoll();
			pc.startHpRegenerationByDoll();
		}
		pc.killSkillEffectTimer(L1SkillId.MEDITATION);

		pc.delInvis(); 

		pc.setRegenState(REGENSTATE_ATTACK);

		if (target != null && !((L1Character) target).isDead()) {
			target.onAction(pc);
		} else { 
			pc.setHeading(pc.targetDirection(x, y));
			pc.sendPackets(new S_AttackStatus(pc, 0,ActionCodes.ACTION_Attack));
			pc.broadcastPacket(new S_AttackStatus(pc, 0,ActionCodes.ACTION_Attack));
			
			if (!(target != null && ((L1MonsterInstance)target).receiveDamage)) {
				target.onAction(pc); 
			pc.CalcStat(null);
			pc.setHeading(pc.targetDirection(x, y));
			pc.sendPackets(new S_AttackMissPacket(pc, 0,ActionCodes.ACTION_Attack));
			pc.broadcastPacket(new S_AttackMissPacket(pc, 0,ActionCodes.ACTION_Attack));
		   }
	    }
	}
@Override
public String getType() {
	return C_Attack;
}
}