package l1j.server.server.serverpackets;

import l1j.server.packethandler.Opcodes;
import l1j.server.server.model.L1Character;

public class S_MpMeter extends ServerBasePacket {
	private static final String _typeString = "[S] S_HPMeter";

	private byte[] _byte = null;

	public S_MpMeter(int objId, int mpRatio) {
		buildPacket(objId, mpRatio);
	}

	public S_MpMeter(L1Character cha) {
		int objId = cha.getId();
		int mpRatio = 100;
		if (0 < cha.get_maxMp()) {
			mpRatio = 100 * cha.getCurrentMp() / cha.get_maxMp();
		}

		buildPacket(objId, mpRatio);
	}

	private void buildPacket(int objId, int mpRatio) {
		writeC(Opcodes.S_OPCODE_MPMETER);
		writeD(objId);
		writeC(mpRatio);
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = _bao.toByteArray();
		}

		return _byte;
	}

	public String getType() {
		return _typeString;
	}
}
