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

import l1j.server.Config;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.types.Point;
import l1j.server.server.model.map.Maps;
import static l1j.server.server.model.skill.L1SkillId.*;

public class MpRegeneration extends TimerTask {
	
	private static Logger _log = Logger.getLogger(MpRegeneration.class.getName());
	private final L1PcInstance _pc;
	private int _regenPoint = 0;
	private int _curPoint = 4;

	public MpRegeneration(L1PcInstance pc) {
		_pc = pc;
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

			if (64 <= (_regenPoint * Config.RATE_MP_REGEN)) {
				_regenPoint = 0;
				regenMp();
			}
		} catch (Throwable e) {
			_log.log(Level.WARNING, e.getLocalizedMessage(), e);
		}
	}

	public void regenMp() {
		int baseMpr = 1;
		int wis = _pc.getWis();
		if (wis == 15 || wis == 16) {
			baseMpr = 2;
		} else if (wis >= 17) {
			baseMpr = 3;
		}

		if (_pc.hasSkillEffect(STATUS_BLUE_POTION)) { 
			if (wis < 11) { 
				wis = 11;
			}
			// probably should change this to class based.
			// doesn't make sense for knight to get 6MP/tick, for example.
			baseMpr += wis - 5;
		}
		if (_pc.hasSkillEffect(MEDITATION) == true) { 
			baseMpr += 5;
		}
		if (_pc.hasSkillEffect(CONCENTRATION)) {
			baseMpr += 2;
		}
		if (_pc.hasSkillEffect(COOKING_1_2_N) || _pc.hasSkillEffect(COOKING_1_2_S)) {
			baseMpr += 3;
		}
 		if (_pc.hasSkillEffect(COOKING_2_4_N) || _pc.hasSkillEffect(COOKING_2_4_S) 
 				|| _pc.hasSkillEffect(COOKING_3_5_N) || _pc.hasSkillEffect(COOKING_3_5_S)) {
			baseMpr += 2;
		}
		// You can only be in one place at once...
		if (L1HouseLocation.isInHouse(_pc.getX(), _pc.getY(), _pc.getMapId())) {
			baseMpr += Config.RATE_MP_HOUSE;
		} else if (Maps.isInInn(_pc)) {
			baseMpr += Config.RATE_MP_HOTEL;
		} else if (Maps.isInCastle(_pc)) {
        	baseMpr += Config.RATE_MP_CASTLE;
		} else if (_pc.isElf() && Maps.atMotherTree(_pc)) {
			baseMpr += Config.RATE_HP_MOTHERTREE;
		} else if (_pc.isIllusionist() && Maps.atSilveriaCenter(_pc)) {
			baseMpr += Config.RATE_HP_ILLUSIONISTTOWN;
        } else if (_pc.isDragonKnight() && Maps.atBehimousCenter(_pc)) {
			baseMpr += Config.RATE_HP_DRAGONKNIGHTTOWN;
        }

 		if (_pc.getOriginalMpr() > 0) { 
 			baseMpr += _pc.getOriginalMpr();
 		}

		int itemMpr = _pc.getInventory().mpRegenPerTick();
		itemMpr += _pc.getMpr();

		if (_pc.get_food() < 3 || isOverWeight(_pc)) {
			baseMpr = 0;
			if (itemMpr > 0) {
				itemMpr = 0;
			}
		}
		int mpPluss = _pc.getWis() - 12;
		if (mpPluss <= 12){
			mpPluss = 12;
		}
		int mpr = baseMpr + itemMpr + mpPluss;
		int newMp = _pc.getCurrentMp() + mpr;
		if (newMp < 0) {
			newMp = 0;
		}
		_pc.setCurrentMp(newMp);
	}

	private boolean isOverWeight(L1PcInstance pc) {
		if (pc.hasSkillEffect(EXOTIC_VITALIZE) ||
				pc.hasSkillEffect(ADDITIONAL_FIRE)) {
			return false;
		}
		return 120 <= pc.getInventory().getWeight240();
	}
}
