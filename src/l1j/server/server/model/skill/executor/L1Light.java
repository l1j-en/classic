package l1j.server.server.model.skill.executor;

import l1j.server.server.model.L1Character;

public class L1Light extends L1BuffSkillExecutorImpl {
	@Override
	public void addEffect(L1Character user, L1Character target,
			int durationSeconds) {
		if (!target.isInvisble()) {
			target.updateLight();
		}
	}

	@Override
	public void removeEffect(L1Character target) {
		if (!target.isInvisble()) {
			target.updateLight();
		}
	}
}
