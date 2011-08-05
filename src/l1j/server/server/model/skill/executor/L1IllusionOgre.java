package l1j.server.server.model.skill.executor;

import l1j.server.server.model.L1Character;

public class L1IllusionOgre extends L1BuffSkillExecutorImpl {
	private static final int DMGUP = 4;
	private static final int HITUP = 4;

	@Override
	public void addEffect(L1Character user, L1Character target,
			int durationSeconds) {
		target.addDmgup(DMGUP);
		target.addHitup(HITUP);
		target.addBowDmgup(DMGUP);
		target.addBowHitup(HITUP);
	}

	@Override
	public void removeEffect(L1Character target) {
		target.addDmgup(-DMGUP);
		target.addHitup(-HITUP);
		target.addBowDmgup(-DMGUP);
		target.addBowHitup(-HITUP);
	}
}
