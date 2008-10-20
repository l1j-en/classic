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

package l1j.server.server.serverpackets;

import java.util.concurrent.atomic.AtomicInteger;

import l1j.server.packethandler.Opcodes;
import l1j.server.server.ActionCodes;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.Instance.L1PcInstance;
import static l1j.server.server.model.skill.L1SkillId.*;
import l1j.server.server.types.Point;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_UseAttackSkill extends ServerBasePacket {

	private static final String S_USE_ATTACK_SKILL = "[S] S_UseAttackSkill";
	private static AtomicInteger _sequentialNumber = new AtomicInteger(0);
	private byte[] _byte = null;
	private boolean _isL1PcInstance = false;
	private boolean _isArrowType = false;

	public S_UseAttackSkill(L1Character caster, L1Character target, int spellgfx, boolean motion) {
		Point pt = target.getLocation();
		buildPacket(caster, target.getId(), spellgfx, pt.getX(), pt.getY(), false, ActionCodes.ACTION_SkillAttack, 6, motion);
	}

	public S_UseAttackSkill(L1Character cha, int targetobj, int spellgfx, int x, int y) {
		buildPacket(cha, targetobj, spellgfx, x, y, false, ActionCodes.ACTION_SkillAttack, 6, true);
	}

	public S_UseAttackSkill(L1Character cha, int targetobj, int spellgfx, int x, int y, boolean isArrowType) {
		buildPacket(cha, targetobj, spellgfx, x, y, isArrowType, ActionCodes.ACTION_SkillAttack, 6, true);
	}

	public S_UseAttackSkill(L1Character cha, int targetobj, int spellgfx, int x, int y, int aid) {
		buildPacket(cha, targetobj, spellgfx, x, y, false, aid, 6, true);
	}

	public S_UseAttackSkill(L1Character cha, int targetobj, int spellgfx, int x, int y, int aid, int isHit) {
		buildPacket(cha, targetobj, spellgfx, x, y, false, aid, isHit, true);
	}

	private void buildPacket(L1Character cha, int targetobj, int spellgfx, int x, int y, boolean isArrowType, int aid, int isHit,
			boolean withCastMotion) {
		// save
		_isArrowType = isArrowType;
		if (cha instanceof L1PcInstance) {
			_isL1PcInstance = true;
			// Shadow system transforms into a magic during the attack and 
			// the client to use a provisional to fall into the corresponding
			if (cha.hasSkillEffect(SHAPE_CHANGE)
					&& aid == ActionCodes.ACTION_SkillAttack) {
				int tempchargfx = cha.getTempCharGfx();
				if (tempchargfx == 5727 || tempchargfx == 5730) {
					aid = ActionCodes.ACTION_SkillBuff;
				} else if (tempchargfx == 5733 || tempchargfx == 5736) {
					// Auxiliary and the magic of motion graphics and magic attacks
					// Damage to the motion is occurring because
					// Attack as a substitute motion
					aid = ActionCodes.ACTION_Attack;
				}
			}
		}
		// Salamander's main attack is the default graphics magic is not forced to replace
		// Elsewhere it is better managed?
		if (cha.getTempCharGfx() == 4013) {
			aid = ActionCodes.ACTION_Attack;
		}

		int newheading = calcheading(cha.getX(), cha.getY(), x, y);
		cha.setHeading(newheading);
		writeC(Opcodes.S_OPCODE_ATTACKPACKET);
		writeC(aid);
		writeD(withCastMotion ? cha.getId() : 0);
		writeD(targetobj);
		writeC(isHit);
		writeC(newheading);
		if (_isL1PcInstance || _isArrowType) {
			writeD(_sequentialNumber.incrementAndGet()); // DABURANAI number to send.
		} else {
			writeD(0);
		}
		writeH(spellgfx);
		writeC(6); // TAKEJJIZONGU: 6, and TAKEJJIZONGU range: 8, Range: 0
		writeH(cha.getX());
		writeH(cha.getY());
		writeH(x);
		writeH(y);
		// writeC(228);
		// writeC(231);
		// writeC(95);
		// writeC(82);
		// writeC(170);
		writeC(0);
		writeC(0);
		writeC(0);
		writeC(0);
		writeC(0);
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = _bao.toByteArray();
		} else {
			if (_isL1PcInstance || _isArrowType) {
				// sequentialNumber Rewriting
				int seq = _sequentialNumber.incrementAndGet();
				_byte[12] = (byte) (seq & 0xff);
				_byte[13] = (byte) (seq >> 8 & 0xff);
				_byte[14] = (byte) (seq >> 16 & 0xff);
				_byte[15] = (byte) (seq >> 24 & 0xff);
			}
		}

		return _byte;
	}

	private static int calcheading(int myx, int myy, int tx, int ty) {
		int newheading = 0;
		if (tx > myx && ty > myy) {
			newheading = 3;
		}
		if (tx < myx && ty < myy) {
			newheading = 7;
		}
		if (tx > myx && ty == myy) {
			newheading = 2;
		}
		if (tx < myx && ty == myy) {
			newheading = 6;
		}
		if (tx == myx && ty < myy) {
			newheading = 0;
		}
		if (tx == myx && ty > myy) {
			newheading = 4;
		}
		if (tx < myx && ty > myy) {
			newheading = 5;
		}
		if (tx > myx && ty < myy) {
			newheading = 1;
		}
		return newheading;
	}

	public String getType() {
		return S_USE_ATTACK_SKILL;
	}
}