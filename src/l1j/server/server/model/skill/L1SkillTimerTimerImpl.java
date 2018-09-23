package l1j.server.server.model.skill;

import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.L1Character;

class L1SkillTimerTimerImpl implements L1SkillTimer, Runnable {
	private static Logger _log = LoggerFactory.getLogger(L1SkillTimerTimerImpl.class
			.getName());
	private ScheduledFuture<?> _future = null;

	public L1SkillTimerTimerImpl(L1Character cha, int skillId, int timeMillis) {
		_cha = cha;
		_skillId = skillId;
		_timeMillis = timeMillis;

		_remainingTime = _timeMillis / 1000;
	}

	@Override
	public void run() {
		try {
		_remainingTime--;
		if (_remainingTime <= 0) {
			_cha.removeSkillEffect(_skillId);
		}
		} catch (Exception e) {
			_log.error("",e);
		}
	}

	@Override
	public void begin() {
		_future = GeneralThreadPool.getInstance().scheduleAtFixedRate(this,
				1000, 1000);
	}

	@Override
	public void end() {
		kill();
		try {
			L1SkillStop.stopSkill(_cha, _skillId);
		} catch (Throwable e) {
			_log.error(e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void kill() {
		if (_future != null) {
			_future.cancel(false);
		}
	}

	@Override
	public int getRemainingTime() {
		return _remainingTime;
	}

	private final L1Character _cha;
	private final int _timeMillis;
	private final int _skillId;
	private int _remainingTime;
}