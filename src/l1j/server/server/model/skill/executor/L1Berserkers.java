package l1j.server.server.model.skill.executor;

import l1j.server.server.model.L1Character;

public class L1Berserkers extends L1BuffSkillExecutorImpl {
	private static final int AC = 10;
	private static final int DMGUP = 5;
	private static final int HITUP = 2;

	@Override
	public void addEffect(L1Character user, L1Character target, int durationSeconds) {
		target.addAc(AC);
		target.addDmgup(DMGUP);
		target.addHitup(HITUP);
	}

	@Override
	public void removeEffect(L1Character target) {
		target.addAc(-AC);
		target.addDmgup(-DMGUP);
		target.addHitup(-HITUP);
	}
}
