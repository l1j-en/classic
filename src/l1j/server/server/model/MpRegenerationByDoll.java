package l1j.server.server.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.model.Instance.L1PcInstance;

public class MpRegenerationByDoll implements Runnable {
	private static Logger _log = LoggerFactory.getLogger(MpRegenerationByDoll.class
			.getName());

	private final L1PcInstance _pc;

	public MpRegenerationByDoll(L1PcInstance pc) {
		_pc = pc;
	}

	@Override
	public void run() {
		try {
			if (_pc.isDead()) {
				return;
			}
			regenMp();
		} catch (Throwable e) {
			_log.warn(e.getLocalizedMessage(), e);
		}
	}

	public void regenMp() {
		int newMp = _pc.getCurrentMp() + 15;
		if (newMp < 0) {
			newMp = 0;
		}
		_pc.setCurrentMp(newMp);
	}

}
