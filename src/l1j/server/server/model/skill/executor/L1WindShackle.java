package l1j.server.server.model.skill.executor;

import l1j.server.server.model.L1Character;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SkillIconWindShackle;
import l1j.server.server.templates.L1CharacterBuff;

public class L1WindShackle extends L1BuffSkillExecutorImpl {

	@Override
	public void addEffect(L1Character user, L1Character target,
			int durationSeconds) {
		if (!(target instanceof L1PcInstance)) {
			return;
		}

		L1PcInstance pc = (L1PcInstance) target;
		pc.sendPackets(new S_SkillIconWindShackle(pc.getId(), durationSeconds));
		pc.broadcastPacket(new S_SkillIconWindShackle(pc.getId(),
				durationSeconds));
	}

	@Override
	public void removeEffect(L1Character target) {
		addEffect(null, target, 0);
	}

	@Override
	public void restoreEffect(L1PcInstance target, L1CharacterBuff buff) {
		addEffect(null, target, buff.getRemainingTime());
	}
}
