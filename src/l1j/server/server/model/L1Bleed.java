package l1j.server.server.model;

import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.ActionCodes;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.random.RandomGenerator;
import l1j.server.server.random.RandomGeneratorFactory;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Bleed  extends TimerTask {
	private static Logger _log = Logger.getLogger(L1Bleed.class.getName());

	private int _duration = 1;
	private ScheduledFuture<?> _future = null;
	private int _timeCounter = 0;
	private final L1PcInstance _pc;
	private final L1Character _cha;
	
	public L1Bleed(L1PcInstance pc, L1Character cha) {
		_cha = cha;
		_pc = pc;
	}
	
	public void run() {
		try {
			if (_cha == null || _cha.isDead()) {
				stop();
				return;
			}
			
			attack();
			_timeCounter++;
			
			if (_timeCounter >= _duration) {
				_pc.sendPackets(new S_SystemMessage("\\fTYour wound has healed!"));
				stop();
				return;
			}
		} catch (Throwable e) {
			_log.log(Level.WARNING, e.getLocalizedMessage(), e);
		}
	}

	public void begin() {
		if(_cha.hasSkillEffect(L1SkillId.BLEEDING)) {
			return;
		}
		
		RandomGenerator random = RandomGeneratorFactory.getSharedRandom();
		
		int durationCalculator = random.nextInt(400);
		int duration = 1;
		
		if(durationCalculator >= 335) {
			duration = 8; // 16% chance for 8 second
		} else if(durationCalculator >= 210) {
			duration = 6; // 32% chance for 6 second
		} else if(durationCalculator >= 80) {
			duration = 4; // 31% chance for 2 second
		} 
		
		_duration = duration;
		_pc.sendPackets(new S_SystemMessage("\\fYA wound has hindered your movement."));
		
		_future = GeneralThreadPool.getInstance().scheduleAtFixedRate(this, 0, 1000);
		
		_cha.setSkillEffect(L1SkillId.BLEEDING,  0);
	}

	public void stop() {
		_cha.killSkillEffectTimer(L1SkillId.BLEEDING);
		
		if (_future != null) {
			_future.cancel(true);
		}
	}
	
	private void attack() {			
		double damage = 5;
		
		if (_cha.getCurrentHp() - (int) damage <= 0 && _cha.getCurrentHp() != 1) {
			damage = _cha.getCurrentHp() - 1;
		} else if (_cha.getCurrentHp() == 1) {
			damage = 0;
		}
		
		if (_cha instanceof L1PcInstance) {
			L1PcInstance pc = (L1PcInstance) _cha;
			pc.sendPackets(new S_DoActionGFX(pc.getId(), ActionCodes.ACTION_Damage));
			pc.broadcastPacket(new S_DoActionGFX(pc.getId(), ActionCodes.ACTION_Damage));
			pc.receiveDamage(_pc, (int) damage, false);
		}
	}
}
