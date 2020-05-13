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

import java.util.Map;

import l1j.server.server.encryptions.Opcodes;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.ByteArrayUtil;
import l1j.server.server.utils.IntRange;
import l1j.server.server.utils.collections.Maps;
import static l1j.server.server.model.skill.L1SkillId.*;

//activeSpells (L1PcInstance pc)
//I tried putting 100 in each value of data and tested whether the icon came out
//For most skills, 4 times the number of seconds is displayed as the remaining time
//Some skills display 16 times the number of seconds, so we described that skill as coefficient 16.
//0: meditation
//1: None
//2: None
//3: Decrease wait (coefficient 16)
//4: Decay potion
//5: Absolute barrier
//6: silence
//7: Venom resist
//8: Weakness
//9: Diseases
//10-16: None
//17: Dress Evasion
//18: Berserker
//19: Nature's Touch
//20: Wind shackle
//21: Erase Magic?
//22: Counter mirror?
//23: Additional fire (coefficient 16)
//24: Elemental falldown
//25: None
//26: Elemental Fire
//27: None
//28: Turn off the sign so that the monsters will not notice (?)
//29: None
//30: Striker Gail
//31: Soul of Flame
//32: Polut water
//33-40: None
//44: Spell power will increase
//45-51: None
//52: Concentration (Coefficient 16)
//53: Insight (coefficient 16)
//54: Panic (coefficient 16)
//55: Mortal body
//56: Horror of Death
//57: Fear
//58: Patience
//59: Guard break
//60: Dragon skin (coefficient 16)
//61: The moving speed becomes faster
//62-101: None
//102-103 :?

public class S_ActiveSpells extends ServerBasePacket {
	private byte[] _byte = null;
	private static final Map<Integer, ActiveSkill> _indexes = Maps.newHashMap();
	
	private static class ActiveSkill {
		public final int id;
		public final int timeCoefficient;
		public ActiveSkill(int skillId, int timeCoefficient) {
			this.id = skillId;
			this.timeCoefficient = timeCoefficient;
		}
	}

	private static void addIndex(int skillIndex, int skillId) {
		addIndex(skillIndex, skillId, 4);
	}
	
	static {
		addIndex(0, MEDITATION);
		addIndex(3, DECREASE_WEIGHT, 16);
		addIndex(4, DECAY_POTION);
		addIndex(5, ABSOLUTE_BARRIER);
		addIndex(6, SILENCE);
		addIndex(7, VENOM_RESIST);
		addIndex(8, WEAKNESS);
		addIndex(9, DISEASE);
		addIndex(17, DRESS_EVASION);
		addIndex(18, BERSERKERS);
		addIndex(19, NATURES_TOUCH);
		// addIndex(20, WIND_SHACKLE); // Attack speed does not decrease even if sent here
		addIndex(21, ERASE_MAGIC);
		addIndex(22, COUNTER_MIRROR);
		addIndex(23, ADDITIONAL_FIRE, 16);
		addIndex(24, ELEMENTAL_FALL_DOWN);
		addIndex(26, ELEMENTAL_FIRE);
		// addIndex(28, /* Turn off the sign so that the monsters will not notice it (?) */);
		addIndex(30, STRIKER_GALE);
		addIndex(31, SOUL_OF_FLAME);
		addIndex(32, POLLUTE_WATER);
		// addIndex(44, /* Increases spell power */);
		addIndex(52, CONCENTRATION, 16);
		addIndex(53, INSIGHT, 16);
		addIndex(54, PANIC, 16); // TODO implement
		addIndex(55, MORTAL_BODY);
		addIndex(56, HORROR_OF_DEATH);
		// addIndex(57, /*フィアー*/);
		addIndex(58, PATIENCE);
		addIndex(59, GUARD_BRAKE);
		addIndex(60, DRAGON_SKIN, 16);
		// addIndex(61, /*Moves faster */);
	}

	private static void addIndex(int skillIndex, int skillId, int timeCoefficient) {
		ActiveSkill skill = new ActiveSkill(skillId, timeCoefficient);
		_indexes.put(skillIndex, skill);
	}
	
	private byte getTime(L1PcInstance pc, int skillIndex) {
		ActiveSkill skill = _indexes.get(skillIndex);
		if (skill == null) {
			return 0;
		}
		int time = pc.getSkillEffectTimeSec(skill.id);
		if (time == -1) {
			return 0;
		}
		time /= skill.timeCoefficient;
		if (!IntRange.includes(time, 0, 255)) {
			time = 255;
		}
		return (byte) time;
	}

	public S_ActiveSpells(L1PcInstance pc) {
		buildPacket(pc);
	}

	private void buildPacket(L1PcInstance pc) {
		writeC(Opcodes.S_OPCODE_ACTIVESPELLS);
		writeC(0x14);
		writeBytes(activeSpells(pc));
	}
	
	private byte[] activeSpells(L1PcInstance pc) {
		final int SIZE_OF_SPELLS = 104;
		byte[] data = new byte[SIZE_OF_SPELLS];
		
		for (int i = 0; i < SIZE_OF_SPELLS; i++) {
			data[i] = getTime(pc, i);
		}
		
		// Unknown
		int unixTime = (int) (System.currentTimeMillis() / 1000);
		ByteArrayUtil.writeInteger(unixTime, data, 72);
		return data;
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = _bao.toByteArray();
		}
		return _byte;
	}
}