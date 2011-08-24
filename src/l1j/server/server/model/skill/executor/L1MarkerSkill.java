package l1j.server.server.model.skill.executor;

import l1j.server.server.model.L1Character;

/**
 * SkillTimerに登録するだけで効力を持ち、追加や削除に特別な処理の必要ないスキル
 * 
 */
public class L1MarkerSkill extends L1BuffSkillExecutorImpl {

	@Override
	public void addEffect(L1Character user, L1Character target, int durationSeconds) {
	}

	@Override
	public void removeEffect(L1Character target) {
	}
}
