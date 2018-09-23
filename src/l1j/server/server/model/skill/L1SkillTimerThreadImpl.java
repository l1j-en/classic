package l1j.server.server.model.skill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.L1Character;

class L1SkillTimerThreadImpl extends Thread implements L1SkillTimer {
	private static Logger _log = LoggerFactory.getLogger(L1SkillTimerThreadImpl.class);

	public L1SkillTimerThreadImpl(L1Character cha, int skillId, int timeMillis) {
		_cha = cha;
		_skillId = skillId;
		_timeMillis = timeMillis;
	}

	@Override
	public void run() {
		for (int timeCount = _timeMillis / 1000; timeCount > 0; timeCount--) {
			try {
				Thread.sleep(1000);
				_remainingTime = timeCount;
			} catch (InterruptedException e) {
				return;
			}
		}
		try {
			_cha.removeSkillEffect(_skillId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error("",e);
		}
	}

	public int getRemainingTime() {
		return _remainingTime;
	}

	public void begin() {
		GeneralThreadPool.getInstance().execute(this);
	}

	public void end() {
		super.interrupt();
		L1SkillStop.stopSkill(_cha, _skillId);
	}

	public void kill() {
		if (Thread.currentThread().getId() == super.getId()) {
			return;
		}
		super.interrupt();
	}

	private final L1Character _cha;
	private final int _timeMillis;
	private final int _skillId;
	private int _remainingTime;
}