package l1j.server.server.serverpackets;

import l1j.server.server.encryptions.Opcodes;

public class S_SendLocation extends ServerBasePacket {
	private static final String S_SEND_LOCATION = "[S] S_SendLocation";

	public S_SendLocation(int type, String senderName, int mapId, int x, int y, int msgId) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(0x6f);
		writeS(senderName);
		writeH(mapId);
		writeH(x);
		writeH(y);
		writeC(msgId);
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return S_SEND_LOCATION;
	}
}