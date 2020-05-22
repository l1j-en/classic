package l1j.server.server.serverpackets;

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1PcInstance;

public class S_ClanName extends ServerBasePacket {
    private static final String S_ClanName = "[S] S_ClanName";

    private byte[] _byte = null;

    public S_ClanName(L1PcInstance pc, int emblemId, int rank) {
        writeC(Opcodes.S_OPCODE_CLAN);
        writeD(pc.getId());
        writeS(rank > 0 ? pc.getClanname() : "");
        writeC(0);
        writeD(emblemId);
        writeC(rank > 0 ? rank : 0x00);
        writeH(0x00);
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
        return S_ClanName;
    }
}
