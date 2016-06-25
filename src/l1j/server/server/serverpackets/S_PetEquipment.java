package l1j.server.server.serverpackets;

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1PetInstance;

public class S_PetEquipment extends ServerBasePacket {
	private static final String S_PET_EQUIPMENT = "[S] S_PetEquipment";

	public S_PetEquipment(int i, L1PetInstance pet, int j) {
		writeC(Opcodes.S_OPCODE_PACKETBOX);
		writeC(0x25);
		writeC(i);
		writeD(pet.getId());
		writeC(j);
		writeC(pet.getAc());
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return S_PET_EQUIPMENT;
	}
}
