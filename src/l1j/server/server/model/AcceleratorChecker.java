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

package l1j.server.server.model;

import java.util.EnumMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.server.datatables.SprTable;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Skill;

public class AcceleratorChecker {

	private static final Logger _log = LoggerFactory.getLogger(AcceleratorChecker.class);

	private final L1PcInstance _pc;

	private int _injusticeCount;

	private int _justiceCount;

	private static final int INJUSTICE_COUNT_LIMIT = Config.INJUSTICE_COUNT;

	private static final int JUSTICE_COUNT_LIMIT = Config.JUSTICE_COUNT;

	private static final double CHECK_STRICTNESS = Config.CHECK_STRICTNESS / 100D;

	private static final double HASTE_RATE = 0.745;

	private static final double WAFFLE_RATE = 0.874;

	private final EnumMap<ACT_TYPE, Long> _actTimers = new EnumMap<ACT_TYPE, Long>(
			ACT_TYPE.class);

	private final EnumMap<ACT_TYPE, Long> _checkTimers = new EnumMap<ACT_TYPE, Long>(
			ACT_TYPE.class);

	public static enum ACT_TYPE {
		MOVE, ATTACK, SPELL_DIR, SPELL_NODIR
	}

	public static final int R_OK = 0;

	public static final int R_DETECTED = 1;

	public static final int R_LIMITEXCEEDED = 2;

	public AcceleratorChecker(L1PcInstance pc) {
		_pc = pc;
		_injusticeCount = 0;
		_justiceCount = 0;
		long now = System.currentTimeMillis();
		for (ACT_TYPE each : ACT_TYPE.values()) {
			_actTimers.put(each, now);
			_checkTimers.put(each, now);
		}
	}
	
	public int checkInterval(ACT_TYPE type) {
		return checkInterval(type, null);
	}

	public int checkInterval(ACT_TYPE type, L1Skill skill) {
		int result = R_OK;
		long now = System.currentTimeMillis();
		long interval = now - _actTimers.get(type);
		int rightInterval = getRightInterval(type, skill);

		interval *= CHECK_STRICTNESS;

		if (0 < interval && interval < rightInterval) {
			_injusticeCount++;
			_justiceCount = 0;
			
			if (_injusticeCount >= INJUSTICE_COUNT_LIMIT) {
				doFail(interval, rightInterval, type, true);
				return R_LIMITEXCEEDED;
			}
			
			doFail(interval, rightInterval, type, false);
			result = R_DETECTED;
		} else if (interval >= rightInterval) {
			_justiceCount++;
			if (_justiceCount >= JUSTICE_COUNT_LIMIT) {
				_injusticeCount = 0;
				_justiceCount = 0;
			}
		}

		_actTimers.put(type, now);
		return result;
	}

	private void doFail(long interval, int rightInterval, ACT_TYPE type, boolean sendMessage) {
		String dbgInfo = String.format("\nInterval: " + interval
				+ " RightInterval: " + rightInterval + " Morph: "
				+ _pc.getTempCharGfx() + " Weapon: "
				+ (_pc.getCurrentWeapon() + 1) + " Act type: " + type);
		if (!_pc.isGm()) {
			_log.info(String
					.format("Injustice count limit exceeded for player: "
							+ _pc.getName() + dbgInfo));
			
			if(sendMessage) {
				_pc.sendPackets(new S_SystemMessage(
						"Lag limit exceeded. If this happens with a specific polymorph file a bug."));
			}
		} else {
			if(sendMessage) {
				_pc.sendPackets(new S_SystemMessage("Injustice count limit exceeded." + dbgInfo));
			}
			
			_injusticeCount = 0;
		}
	}

	private int getRightInterval(ACT_TYPE type, L1Skill skill) {
		int interval;

		switch (type) {
		case ATTACK:
			interval = SprTable.getInstance().getAttackSpeed(
					_pc.getTempCharGfx(), _pc.getCurrentWeapon() + 1);
			break;
		case MOVE:
			interval = SprTable.getInstance().getMoveSpeed(
					_pc.getTempCharGfx(), _pc.getCurrentWeapon());
			break;
		case SPELL_DIR:
			interval = SprTable.getInstance().getDirSpellSpeed(
				_pc.getTempCharGfx());
			break;
		case SPELL_NODIR:
			interval = SprTable.getInstance().getNodirSpellSpeed(
				_pc.getTempCharGfx());
			break;
		default:
			return Config.ANIMATION_SPEED;
		}
		
		if(skill != null) {
			int skillInterval = skill.getReuseDelay();
			// if the skill has a delay longer than the animation, let's use that
			if(skillInterval > interval)
				interval = skillInterval;
		}

		if (_pc.isHaste()) {
			interval *= HASTE_RATE;
		}
		if (type.equals(ACT_TYPE.MOVE) && _pc.isFastMovable()) {
			interval *= HASTE_RATE;
		}
		if (type.equals(ACT_TYPE.ATTACK) && _pc.isFastAttackable()) {
			interval *= HASTE_RATE;
		}
		if (_pc.isBrave()) {
			interval *= HASTE_RATE;
		}
		if (_pc.isElfBrave()) {
			interval *= WAFFLE_RATE;
		}

		return interval;
	}
}
