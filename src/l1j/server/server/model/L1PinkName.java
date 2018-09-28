package l1j.server.server.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.controllers.WarTimeController;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_PinkName;

// Referenced classes of package l1j.server.server.model:
// L1PinkName
public class L1PinkName {
	
	private static Logger _log = LoggerFactory.getLogger(L1PinkName.class);

	private L1PcInstance _pc = null;
	protected PinkNameTimer _timer = null;

	public L1PinkName(L1PcInstance pc) {
		_pc = pc;
	}

	protected static class PinkNameTimer implements Runnable {
		private L1PcInstance _attacker = null;
		private int _secondsLeft = 180;
		private L1PinkName _parent = null;

		public PinkNameTimer(L1PinkName parent, L1PcInstance attacker) {
			_parent = parent;
			_attacker = attacker;
		}

		@Override
		public void run() {
			try {
				Thread.currentThread().setName("L1PinkName");
				while ( _secondsLeft > 0) {
					_secondsLeft--;
					try {
						Thread.sleep(1000);
					} catch (Exception exception) {
						break;
					}
					// if they're dead and not pink anymore
					// the not pink check is added to ensure that the
					// death method has run before un-pinking
					if (_attacker.isDead() && !_attacker.isPinkName()) {
						break;
					}
					if (_attacker.getLawful() < 0 && !Config.CHAO_PINK) {
						_attacker.setPinkName(false);
						break;
					}
				}
				stopPinkName(_attacker);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.error("",e);
			}
		}

		private void stopPinkName(L1PcInstance attacker) {
			attacker.sendPackets(new S_PinkName(attacker.getId(), 0));
			attacker.broadcastPacket(new S_PinkName(attacker.getId(), 0));
			// BCM: added this, as pinkname flag wasn't getting reset properly
			// on timeout, affecting -warp usage.
			_attacker.setPinkName(false);
			_parent._timer = null;
		}
		
		protected void reset() {
			_secondsLeft = 180;
		}
		
		public int getSecondsLeft() {
			return _secondsLeft;
		}
	}

	public void onAction(L1PcInstance victim) {
		L1PcInstance attacker = _pc;
		if (attacker == null || victim == null) {
			return;
		}

		if (!(attacker instanceof L1PcInstance)) {
			return;
		}
		if (victim.getId() == attacker.getId()) {
			return;
		}
		if (attacker.getFightId() == victim.getId()) {
			return;
		}

		boolean isNowWar = false;
		int castleId = L1CastleLocation.getCastleIdByArea(victim);
		if (castleId != 0) {
			isNowWar = WarTimeController.getInstance().isNowWar(castleId);
		}
		
		boolean isGmSpoofing = victim.isGm() && victim.getSpoofMob() != null;

		if (!isGmSpoofing && victim.getLawful() >= 0
				&& (!victim.isPinkName() || Config.DUAL_PINK)
				&& (attacker.getLawful() >= 0 || Config.CHAO_PINK)
				&& victim.getZoneType() == ZoneType.Normal
					&& attacker.getZoneType() == ZoneType.Normal
					&& isNowWar == false) {
			if (_timer == null) {
				broadcastPink();
				_timer = new PinkNameTimer(this, attacker);
				GeneralThreadPool.getInstance().execute(_timer);					
			}
			if (_timer.getSecondsLeft() <= 90) {
				broadcastPink();
				_timer.reset();
			}
		}
	}
	
	private void broadcastPink() {
		L1PcInstance attacker = _pc;
		attacker.setPinkName(true);
		attacker.sendPackets(new S_PinkName(attacker.getId(), 180));
		if (!attacker.isGmInvis()) {
			attacker.broadcastPacket(new S_PinkName(attacker.getId(),
					180));
		}
	}
	
	public int getSecondsLeft() {
		return _timer.getSecondsLeft();
	}
}
