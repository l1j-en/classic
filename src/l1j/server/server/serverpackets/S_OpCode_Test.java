package l1j.server.server.serverpackets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1SummonInstance;

public class S_OpCode_Test extends ServerBasePacket {

	public S_OpCode_Test(int OpCodeID, int TestLevel, L1PcInstance Player) {
		_opcodeid = OpCodeID;
		_testlevel = TestLevel;
		_gm = Player;
	}

	@Override
	public byte[] getContent() {
		writeC(_opcode[_testlevel][_opcodeid]);
		// jump examined test data such as mackerel
		int objid = 0;
		Object[] petList = _gm.getPetList().values().toArray();
		for (Object pet : petList) {
			if (pet instanceof L1SummonInstance) {
				L1SummonInstance summon = (L1SummonInstance) pet;
				objid = summon.getId();
				break;
			}
		}
		writeD(objid);
		writeC(25);
		return getBytes();
	}

	public String getInfo() {
		StringBuilder info = new StringBuilder();
		info.append(".opc Operation ID number, and then please.\n");
		info.append("[Ver] ").append(_version);
		info.append(" [Level] ").append(_testlevel);
		info.append(" [IdRange] 0 - ").append(_opcode[_testlevel].length - 1)
				.append("\n");
		info.append("[Just before take action] ").append(_action).append("\n");
		info.append("what").append(_status).append("\n");
		return info.toString();
	}

	public String getCode() {
		StringBuilder info = new StringBuilder();
		info.append("[OpCodeId] ").append(_opcodeid).append(" [OpCode] ")
				.append(_opcode[_testlevel][_opcodeid]);
		return info.toString();
	}

	public String getCodeList() {
		StringBuilder info = new StringBuilder();
		info.append(".opcid Operation ID number, and then please.\n");
		info.append("Lv").append(_testlevel).append("\n");
		int t = 0;
		int tc = 10;
		for (int i = 0; i < _opcode[_testlevel].length; i++) {
			if (tc == 10) {
				if (t > 0) {
					info.append("\n");
				}
				info.append(padt(t));
				t++;
				tc = 0;
			}
			info.append(pad(_opcode[_testlevel][i]));
			tc++;
		}
		return info.toString();
	}

	private String pad(int i) {
		if (i < 10) {
			return (new StringBuilder()).append(" 00").append(i).toString();
		} else if (i < 100) {
			return (new StringBuilder()).append(" 0").append(i).toString();
		}
		return (new StringBuilder()).append(" ").append(i).toString();
	}

	private String padt(int i) {
		if (i < 10) {
			return (new StringBuilder()).append("0").append(i).append(" ")
					.toString();
		}
		return (new StringBuilder()).append(i).append(" ").toString();
	}

	public String getType() {
		return S_OpCode_Test;
	}

	private static final String S_OpCode_Test = "[S] S_OpCode_Test";
	@SuppressWarnings("unused")
	private static Logger _log = LoggerFactory			.getLogger(S_OpCode_Test.class.getName());
	private int _opcodeid;
	private int _testlevel;
	private L1PcInstance _gm;

	// xxx report is like a version for
	private final String _version = "S_HPMeter1.0";

	// just before you take action
	private final String _action = "Summon the only one to put out";

	// correct operation code is sent when it is expected that the state
	private final String _status = "Summon the HP meter fluctuate by 25%";

	// Clarification of the operation code is already set to Lower Level
	// Upper stage (Level0) mackerel in the current 137 number not completely
	// used. Opc. Opcid for
	// Mid (Level1) is currently defined 137 mackerel that it is really code for
	// the code and make sure you do not
	// "Etc / opcode Resources. Txt" writes the sort of thing only and do not
	// know
	// 130 to 139 (between 0 to 129 is high possibility, so I think) regions.
	// Opc2. Opcid2 for
	// Lower Level (Level2) currently used in 137 mackerel and working of the
	// things (in order to prepare just in case). Opc3. Opcid3 for
	// If you were not at middle and upper level of the mid even if it was not
	// in it in the bottom tier
	int[][] _opcode = {
			{ 2, 3, 4, 6, 8, 16, 17, 18, 19, 22, 24, 27, 31, 33, 34, 35, 37,
					38, 40, 43, 47, 48, 49, 52, 54, 62, 65, 70, 72, 73, 74, 75,
					76, 78, 80, 83, 84, 86, 87, 88, 89, 90, 91, 92, 93, 95, 98,
					99, 101, 102, 104, 105, 107, 110, 112, 113, 114, 116, 117,
					118, 119, 120, 121, 122, 124, 127, 128 },

			{ 0, 5, 9, 13,

			42, 44, 50, 53, 55, 58, 60, 64, 77,

			111, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139 },

			{ 1, 7, 10, 11, 12, 15, 20, 21, 23, 25, 26, 28, 29, 30, 32, 36, 39,
					41, 45, 46, 51, 56, 57, 59, 61, 63, 66, 67, 68, 69, 71, 79,
					81, 82, 85, 94, 96, 97, 100, 103, 106, 108, 109, 115, 123,
					125, 126 } };
}
