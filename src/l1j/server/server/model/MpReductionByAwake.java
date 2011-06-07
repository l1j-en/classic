package l1j.server.server.model;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.model.L1Awake;
import l1j.server.server.model.Instance.L1PcInstance;

public class MpReductionByAwake extends TimerTask {
	private static Logger _log = Logger.getLogger(MpReductionByAwake.class
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
			_log.log(Level.WARNING, e.getLocalizedMessage(), e);
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
