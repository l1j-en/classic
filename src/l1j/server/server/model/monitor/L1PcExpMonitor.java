package l1j.server.server.model.monitor;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_Lawful;

public class L1PcExpMonitor extends L1PcMonitor {

	private int _oldLawful;
	private int _oldExp;

	public L1PcExpMonitor(final int id) {
		super(id);
	}

	@Override
	public void execTask(final L1PcInstance pc) {
		int currentLawful = pc.getLawful();
		if (_oldLawful != currentLawful) {
			_oldLawful = currentLawful;
			S_Lawful packet = new S_Lawful(pc.getId(), _oldLawful);
			pc.sendPackets(packet);
			pc.broadcastPacket(packet);
		}

		int currentExp = pc.getExp();
		if (_oldExp != currentExp) {
			_oldExp = currentExp;
			pc.onChangeExp();
		}
	}
}
