package l1j.server.server.model.skill.executor;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.templates.L1CharacterBuff;

public abstract class L1BuffSkillExecutorImpl extends L1SkillExecutorImpl
		implements L1BuffSkillExecutor {
	@Override
	public void restoreEffect(L1PcInstance target, L1CharacterBuff buff) {
		addEffect(null, target, buff.getRemainingTime());
	}

	@Override
	public L1CharacterBuff getCharacterBuff(L1PcInstance pc) {
		return null;
	}
}
