package l1j.server.server.model.skill.executor;

import l1j.server.server.model.L1Character;
import l1j.server.server.model.Instance.L1PcInstance;

public class L1Insight extends L1BuffSkillExecutorImpl {
	private static final int STR = 1;
	private static final int CON = 1;
	private static final int DEX = 1;
	private static final int WIS = 1;
	private static final int INT = 1;

	@Override
	public void addEffect(L1Character user, L1Character target, int durationSeconds) {
		if (target instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) target;
			pc.addStr(STR);
			pc.addCon(CON);
			pc.addDex(DEX);
			pc.addWis(WIS);
			pc.addInt(INT);
		}
	}

	@Override
	public void removeEffect(L1Character target) {
		if (target instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) target;
			pc.addStr(-STR);
			pc.addCon(-CON);
			pc.addDex(-DEX);
			pc.addWis(-WIS);
			pc.addInt(-INT);
		}
	}
}
