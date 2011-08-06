package l1j.server.server.model.skill.executor;

import l1j.server.server.model.L1Character;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.templates.L1CharacterBuff;

public interface L1BuffSkillExecutor {
	public void addEffect(L1Character user, L1Character target, int durationSeconds);

	public void restoreEffect(L1PcInstance target, L1CharacterBuff buff);

	public void removeEffect(L1Character target);

	public L1CharacterBuff getCharacterBuff(L1PcInstance pc);
}
