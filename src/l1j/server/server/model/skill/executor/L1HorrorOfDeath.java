package l1j.server.server.model.skill.executor;

import l1j.server.server.model.L1Character;

public class L1HorrorOfDeath extends L1BuffSkillExecutorImpl {
	private static final int STR = -5;
	private static final int INT = -5;

	@Override
	public void addEffect(L1Character user, L1Character target, int durationSeconds) {
		target.addStr(STR);
		target.addInt(INT);
	}

	@Override
	public void removeEffect(L1Character target) {
		target.addStr(-STR);
		target.addInt(-INT);
	}
}
