package l1j.server.server.network;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.ServerBasePacket;

public class DelayedPacket implements Runnable  {
	private ServerBasePacket _packet;
	private L1PcInstance _player;
	
	public DelayedPacket(ServerBasePacket packet, L1PcInstance player) {
		_packet = packet;
		_player = player;
	}
	
	@Override
	public void run() {
			_player.sendPackets(_packet);	
	}

}
