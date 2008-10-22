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

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

import l1j.server.server.model.Instance.L1EffectInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.L1SkillId;

public class HpRegeneration extends TimerTask {

	private static Logger _log = Logger.getLogger(HpRegeneration.class.getName());

	private final L1PcInstance _pc;

	private int _regenMax = 0;

	private int _regenPoint = 0;

	private int _curPoint = 4;

	private static Random _random = new Random();

	public HpRegeneration(L1PcInstance pc) {
		_pc = pc;

		updateLevel();
	}

	public void setState(int state) {
		if (_curPoint < state) {
			return;
		}

		_curPoint = state;
	}

	@Override
	public void run() {
		try {
			if (_pc.isDead()) {
				return;
			}

			_regenPoint += _curPoint;
			_curPoint = 4;

			synchronized (this) {
				if (_regenMax <= _regenPoint) {
					_regenPoint = 0;
					regenHp();
				}
			}
		} catch (Throwable e) {
			_log.log(Level.WARNING, e.getLocalizedMessage(), e);
		}
	}

	public void updateLevel() {
		final int lvlTable[] = new int[] { 30, 25, 20, 16, 14, 12, 11, 10, 9,
				3, 2 };

		int regenLvl = Math.min(10, _pc.getLevel());
		if (30 <= _pc.getLevel() && _pc.isKnight()) {
			regenLvl = 11;
		}

		synchronized (this) {
			_regenMax = lvlTable[regenLvl - 1] * 4;
		}
	}

	public void regenHp() {
		if (_pc.isDead()) {
			return;
		}

		int maxBonus = 1;

		if (11 < _pc.getLevel() && 14 <= _pc.getCon()) {
			maxBonus = _pc.getCon() - 12;
			if (25 < _pc.getCon()) {
				maxBonus = 14;
			}
		}

		int equipHpr = _pc.getInventory().hpRegenPerTick();
		equipHpr += _pc.getHpr();
		int bonus = _random.nextInt(maxBonus) + 1;

		if (_pc.hasSkillEffect(L1SkillId.NATURES_TOUCH)) {
			bonus += 15;
		}
		if (_pc.hasSkillEffect(L1SkillId.COOKING_1_5_N)
				|| _pc.hasSkillEffect(L1SkillId.COOKING_1_5_S)) {
			bonus += 3;
		}

		boolean inLifeStream = false;
		if (isPlayerInLifeStream(_pc)) {
			inLifeStream = true;
			bonus += 3;
		}

		if (_pc.get_food() < 3 || isOverWeight(_pc) || _pc.hasSkillEffect(L1SkillId.BERSERKERS)) {
			bonus = 0;
			if (equipHpr > 0) {
				equipHpr = 0;
			}
		}
        
		int conHp = _pc.getCon() - 10;
		
		if (conHp < 0) 
		{
			conHp = 1;
		}
		int newHp = _pc.getCurrentHp();
		newHp += bonus + equipHpr + conHp;

		if (newHp < 1) {
			newHp = 1;
		}

		if (isUnderwater(_pc)) {
			newHp -= 20;
			if (newHp < 1) {
				if (_pc.isGm()) {
					newHp = 1;
				} else {
					_pc.death(null);
				}
			}
		}
		// Lv50
		if (isLv50Quest(_pc) && !inLifeStream) {
			newHp -= 10;
			if (newHp < 1) {
				if (_pc.isGm()) {
					newHp = 1;
				} else {
					_pc.death(null);
				}
			}
		}
		if (_pc.getMapId() == 410 && !inLifeStream) {
			newHp -= 10;
			if (newHp < 1) {
				if (_pc.isGm()) {
					newHp = 1;
				} else {
					_pc.death(null);
				}
			}
		}

		if (!_pc.isDead()) {
			_pc.setCurrentHp(Math.min(newHp, _pc.getMaxHp()));
		}
	}

	private boolean isUnderwater(L1PcInstance pc) {
		if (pc.getInventory().checkEquipped(20207)) {
			return false;
		}
		if (pc.hasSkillEffect(L1SkillId.STATUS_UNDERWATER_BREATH)) {
			return false;
		}
		if (pc.getInventory().checkEquipped(21048)
				&& pc.getInventory().checkEquipped(21049)
				&& pc.getInventory().checkEquipped(21050)) {
			return false;
		}

		return pc.getMap().isUnderwater();
	}

	private boolean isOverWeight(L1PcInstance pc) {
		if (pc.hasSkillEffect(L1SkillId.EXOTIC_VITALIZE) || pc.hasSkillEffect(L1SkillId.ADDITIONAL_FIRE)) {
			return false;
		}
		if (pc.getInventory().checkEquipped(20049)) {
			return false;
		}

		return (14 < pc.getInventory().getWeight30()) ? true : false;
	}

	private boolean isLv50Quest(L1PcInstance pc) {
		int mapId = pc.getMapId();
		return (mapId == 2000 || mapId == 2001) ? true : false;
	}

	private static boolean isPlayerInLifeStream(L1PcInstance pc) {
		for (L1Object object : pc.getKnownObjects()) {
			if (object instanceof L1EffectInstance == false) {
				continue;
			}
			L1EffectInstance effect = (L1EffectInstance) object;
			if (effect.getNpcId() == 81169 && effect.getLocation()
					.getTileLineDistance(pc.getLocation()) < 4) {
				return true;
			}
		}
		return false;
	}
}
