package l1j.server.server.serverpackets;

import l1j.server.server.Opcodes;
import l1j.server.server.model.L1Character;

public class S_HPMeter extends ServerBasePacket {
	private static final String _typeString = "[S] S_HPMeter";

	private byte[] _byte = null;

	public S_HPMeter(int objId, int hpRatio) {
		buildPacket(objId, hpRatio);
	}

	public S_HPMeter(L1Character cha) {
		int objId = cha.getId();
		int hpRatio = 100;
		if (0 < cha.getMaxHp()) {
			hpRatio = 100 * cha.getCurrentHp() / cha.getMaxHp();
		}

		buildPacket(objId, hpRatio);
	}

	private void buildPacket(int objId, int hpRatio) {
		writeC(Opcodes.S_OPCODE_HPMETER);
		writeD(objId);
		writeC(hpRatio);
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = _bao.toByteArray();
		}

		return _byte;
	}

	@Override
	public String getType() {
		return _typeString;
	}
}
