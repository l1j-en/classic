package l1j.server.server.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.model.Instance.L1PcInstance;

public class MpReductionByAwake implements Runnable {
	private static Logger _log = LoggerFactory.getLogger(MpReductionByAwake.class
			.getName());

	private final L1PcInstance _pc;

	public MpReductionByAwake(L1PcInstance pc) {
		_pc = pc;
	}

	@Override
	public void run() {
		try {
			if (_pc.isDead()) {
				return;
			}
			decreaseMp();
		} catch (Throwable e) {
			_log.warn(e.getLocalizedMessage(), e);
		}
	}

	public void decreaseMp() {
		int newMp = _pc.getCurrentMp() - 8;
		if (newMp < 0) {
			newMp = 0;
			L1Awake.stop(_pc);
		}
		_pc.setCurrentMp(newMp);
	}

}
