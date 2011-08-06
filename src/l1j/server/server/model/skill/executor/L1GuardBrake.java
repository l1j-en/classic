package l1j.server.server.model.skill.executor;

import l1j.server.server.model.L1Character;

public class L1GuardBrake extends L1BuffSkillExecutorImpl {

	private static final int AC = 15;

	@Override
	public void addEffect(L1Character user, L1Character target, int durationSeconds) {
		target.addAc(AC);
	}

	@Override
	public void removeEffect(L1Character target) {
		target.addAc(-AC);
	}
}
