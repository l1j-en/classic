package l1j.server.server.model.skill.executor;

import l1j.server.server.model.L1Character;
import l1j.server.server.model.skill.L1SkillId;

public class L1NaturesTouch extends L1BuffSkillExecutorImpl {
	@Override
	public void addEffect(L1Character user, L1Character target, int durationSeconds) {
		target.removeSkillEffect(L1SkillId.WATER_LIFE);
	}

	@Override
	public void removeEffect(L1Character target) {
	}
}
