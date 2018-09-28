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
package l1j.server.server.model.classes;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.model.Instance.L1PcInstance;

public class L1ClassId {
	public static final int ROYAL = 0;
	public static final int KNIGHT = 1;
	public static final int ELF = 2;
	public static final int WIZARD = 3;
	public static final int DARK_ELF = 4;
	public static final int DRAGON_KNIGHT = 5;
	public static final int ILLUSIONIST = 6;
	public static final int Del_ROYAL = 32;
	public static final int Del_KNIGHT = 33;
	public static final int Del_ELF = 34;
	public static final int Del_WIZARD = 35;
	public static final int Del_DARK_ELF = 36;
	public static final int Del_DRAGON_KNIGHT = 37;
	public static final int Del_ILLUSIONIST = 38;
	
	// Really sprite ids.
	public static final int CLASSID_PRINCE = 0;
	public static final int CLASSID_PRINCESS = 1;
	public static final int CLASSID_ELF_MALE = 138;
	public static final int CLASSID_ELF_FEMALE = 37;
	public static final int CLASSID_KNIGHT_MALE = 61;
	public static final int CLASSID_KNIGHT_FEMALE = 48;
	public static final int CLASSID_WIZARD_MALE = 734;
	public static final int CLASSID_WIZARD_FEMALE = 1186;
	public static final int CLASSID_DARK_ELF_MALE = 2786;
	public static final int CLASSID_DARK_ELF_FEMALE = 2796;
	public static final int CLASSID_DRAGON_KNIGHT_MALE = 6658;
	public static final int CLASSID_DRAGON_KNIGHT_FEMALE = 6661;
	public static final int CLASSID_ILLUSIONIST_MALE = 6671;
	public static final int CLASSID_ILLUSIONIST_FEMALE = 6650;
	
	private static Logger _log = LoggerFactory.getLogger(L1ClassId.class.getName());
	
	public static String getSex(int classId) {
		if (isMale(classId)) {
			return "Male";
		}
		if (isFemale(classId)) {
			return "Female";
		}
		_log.error(
				"Unrecognized classId in #L1ClassId.getSex(). Check db.");
		throw new IllegalStateException("Unrecognized character class id.");
	}

	private static boolean isMale(int classId) {
		return classId == CLASSID_PRINCE
				|| classId == CLASSID_KNIGHT_MALE
				|| classId == CLASSID_ELF_MALE
				|| classId == CLASSID_WIZARD_MALE
				|| classId == CLASSID_DARK_ELF_MALE
				|| classId == CLASSID_DRAGON_KNIGHT_MALE
				|| classId == CLASSID_ILLUSIONIST_MALE;
	}

	private static boolean isFemale(int classId) {
		return classId == CLASSID_PRINCESS
				|| classId == CLASSID_KNIGHT_FEMALE
				|| classId == CLASSID_ELF_FEMALE
				|| classId == CLASSID_WIZARD_FEMALE
				|| classId == CLASSID_DARK_ELF_FEMALE
				|| classId == CLASSID_DRAGON_KNIGHT_FEMALE
				|| classId == CLASSID_ILLUSIONIST_FEMALE;
	}
	
	public static String getClass(int classId) {
		return getClass(classId, false);
	}

	public static String getClass(int classId, boolean ignoreErrors) {
		if (isRoyal(classId)) {
			return "Royal";
		}
		if (isKnight(classId)) {
			return "Knight";
		}
		if (isElf(classId)) {
			return "Elf";
		}
		if (isMage(classId)) {
			return "Mage";
		}
		if (isDarkElf(classId)) {
			return "Dark Elf";
		}
		if (isDragonKnight(classId)) {
			return "Dragon Knight";
		}
		if (isIllusionist(classId)) {
			return "Illusionist";
		}
		
		if(!ignoreErrors)
			_log.error(
				"Unrecognized classId in #L1ClassId.getClass(). Check db.");
		throw new IllegalStateException("Unrecognized character class id.");
	}
	
	public static String classCode(L1PcInstance pc) {
		int i = pc.getClassId();
		if (i == CLASSID_KNIGHT_MALE || i == CLASSID_KNIGHT_FEMALE) {
			return "K";
		} else if (i == CLASSID_ELF_MALE || i == CLASSID_ELF_FEMALE) {
			return "E";
		} else if (i == CLASSID_WIZARD_MALE || i == CLASSID_WIZARD_FEMALE) {
			return "W";
		} else if (i == CLASSID_DARK_ELF_MALE || i == CLASSID_DARK_ELF_FEMALE) {
			return "D";
		} else if (i == CLASSID_PRINCE || i == CLASSID_PRINCESS) {
			return "P";
		} else if (i == CLASSID_DRAGON_KNIGHT_MALE || i == CLASSID_DRAGON_KNIGHT_FEMALE) {
			return "R";
		} else if (i == CLASSID_ILLUSIONIST_MALE || i == CLASSID_ILLUSIONIST_FEMALE) {
			return "I";
		} else {
			return null;
		}
	}

	public static boolean isRoyal(int classId) {
		return classId == CLASSID_PRINCE || classId == CLASSID_PRINCESS;
	}

	public static boolean isKnight(int classId) {
		return classId == CLASSID_KNIGHT_MALE
				|| classId == CLASSID_KNIGHT_FEMALE;
	}

	public static boolean isElf(int classId) {
		return classId == CLASSID_ELF_MALE 
				|| classId == CLASSID_ELF_FEMALE;
	}

	public static boolean isMage(int classId) {
		return classId == CLASSID_WIZARD_MALE 
				|| classId == CLASSID_WIZARD_FEMALE;
	}

	public static boolean isDarkElf(int classId) {
		return classId == CLASSID_DARK_ELF_MALE
				|| classId == CLASSID_DARK_ELF_FEMALE;
	}

	public static boolean isDragonKnight(int classId) {
		return classId == CLASSID_DRAGON_KNIGHT_MALE
				|| classId == CLASSID_DRAGON_KNIGHT_FEMALE;
	}

	public static boolean isIllusionist(int classId) {
		return classId == CLASSID_ILLUSIONIST_MALE
				|| classId == CLASSID_ILLUSIONIST_FEMALE;
	}
}