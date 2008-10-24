package l1j.server.server.model;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.L1SkillId;

public class MpRegeneration extends TimerTask {
	private static Logger _log = Logger.getLogger(MpRegeneration.class
			.getName());

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

			if (64 <= _regenPoint) {
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

		if (_pc.hasSkillEffect(L1SkillId.STATUS_BLUE_POTION) == true) { 
			if (wis < 11) {
				wis = 11;
			}
			// probably should change this to class based.
			// doesn't make sense for knight to get 6MP/tick, for example.
			baseMpr += wis - 10 + 5;
		}
		if (_pc.hasSkillEffect(L1SkillId.MEDITATION) == true) { 
			baseMpr += 5;
		}
		if (_pc.hasSkillEffect(L1SkillId.COOKING_1_2_N)
				|| _pc.hasSkillEffect(L1SkillId.COOKING_1_2_S)) {
			baseMpr += 3;
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
		if (pc.hasSkillEffect(L1SkillId.EXOTIC_VITALIZE)
				|| pc.hasSkillEffect(L1SkillId.ADDITIONAL_FIRE)) {
			return false;
		}

		return (14 < pc.getInventory().getWeight30()) ? true : false;
	}
}
