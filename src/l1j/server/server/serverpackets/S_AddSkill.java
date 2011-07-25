/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package l1j.server.server.serverpackets;

import java.util.List;

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.datatables.SkillsTable;
import l1j.server.server.templates.L1Skills;
import l1j.server.server.utils.IntRange;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket
public class S_AddSkill extends ServerBasePacket {
	private static final String S_ADD_SKILL = "[S] S_AddSkill";
	private byte[] _byte = null;

	public S_AddSkill(int level1, int level2, int level3, int level4,
			int level5, int level6, int level7, int level8, int level9,
			int level10, int knight, int l2, int de1, int de2, int royal,
			int l3, int elf1, int elf2, int elf3, int elf4, int elf5, int elf6,
			int k5, int l5, int m5, int n5, int o5, int p5) {
		int i6 = level5 + level6 + level7 + level8;
		int j6 = level9 + level10;
		writeC(Opcodes.S_OPCODE_ADDSKILL);
		if (i6 > 0 && j6 == 0) {
			writeC(50);
		} else if (j6 > 0) {
			writeC(100);
		} else {
			writeC(32);
		}
		writeC(level1);
		writeC(level2);
		writeC(level3);
		writeC(level4);
		writeC(level5);
		writeC(level6);
		writeC(level7);
		writeC(level8);
		writeC(level9);
		writeC(level10);
		writeC(knight);
		writeC(l2);
		writeC(de1);
		writeC(de2);
		writeC(royal);
		writeC(l3);
		writeC(elf1);
		writeC(elf2);
		writeC(elf3);
		writeC(elf4);
		writeC(elf5);
		writeC(elf6);
		writeC(k5);
		writeC(l5);
		writeC(m5);
		writeC(n5);
		writeC(o5);
		writeC(p5);
		writeD(0);
		writeD(0);
	}

	public S_AddSkill(List<L1Skills> skills) {
		if (skills == null) {
			throw new IllegalArgumentException();
		}
		buildPacket(makeLevels(skills));
	}

	private void buildPacket(int[] levels) {
		writeC(Opcodes.S_OPCODE_ADDSKILL);
		writeC(getHeader(levels));
		for (int i : levels) {
			writeC(i);
		}
		// unknown 5 bytes
		writeC(0);
		writeC(0);
		writeC(0);
		writeC(0);
		writeC(0);
	}

	public S_AddSkill(L1Skills skill) {
		buildPacket(makeLevels(skill));
	}

	private int[] makeLevels(L1Skills skill) {
		int[] result = new int[28];
		result[skill.getSkillLevel() - 1] = skill.getId();
		return result;
	}

	private int[] makeLevels(List<L1Skills> skills) {
		int[] result = new int[28];
		IntRange levelRange = new IntRange(1, 28);
		for (L1Skills skill : skills) {
			L1Skills skillTemp = SkillsTable.getInstance().findBySkillId(
					skill.getSkillId());
			int level = skillTemp.getSkillLevel();
			if (levelRange.includes(level)) {
				result[level - 1] |= skillTemp.getId();
			}
		}
		return result;
	}

	private int getHeader(int[] levels) {
		boolean level5To8 = (levels[4] + levels[5] + levels[6] + levels[7]) > 0;
		boolean level9And10 = (levels[8] + levels[9]) > 0;
		if (level5To8 && !level9And10) {
			return 50;
		} else if (level9And10) {
			return 100;
		}
		return 32;
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}

	@Override
	public String getType() {
		return S_ADD_SKILL;
	}
}