package l1j.server.server.model.skill.executor;

import l1j.server.server.templates.L1Skill;

public class L1SkillExecutorImpl implements L1SkillExecutor {
	protected L1Skill _skill;

	@Override
	public void initialize(L1Skill skill) {
		_skill = skill;
	}
}
