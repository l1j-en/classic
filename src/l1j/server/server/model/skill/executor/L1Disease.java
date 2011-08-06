package l1j.server.server.model.skill.executor;

import l1j.server.server.model.L1Character;

public class L1Disease extends L1BuffSkillExecutorImpl {
	private static final int AC = 12;
	private static final int DMGUP = -6;

	@Override
	public void addEffect(L1Character user, L1Character target, int durationSeconds) {
		target.addDmgup(DMGUP);
		target.addAc(AC);
	}

	@Override
	public void removeEffect(L1Character target) {
		target.addDmgup(-DMGUP);
		target.addAc(-AC);
	}
}
