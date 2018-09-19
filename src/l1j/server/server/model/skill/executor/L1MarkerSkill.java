package l1j.server.server.model.skill.executor;

import l1j.server.server.model.L1Character;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.serverpackets.S_SkillIconAura;

public class L1MarkerSkill extends L1BuffSkillExecutorImpl {

	@Override
	public void addEffect(L1Character user, L1Character target,
			int durationSeconds) {
	}

	@Override
	public void removeEffect(L1Character target) {
		// TODO: you might be able to do if impl = 'L1MarkerSkill' and use the getSkillId() - 1
		// but will leave that for future testing
		if(_skill.getSkillId() == L1SkillId.ERASE_MAGIC && target instanceof L1PcInstance)
			((L1PcInstance)target).sendPackets(new S_SkillIconAura(152, 0));
	}
}
