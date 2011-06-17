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
package l1j.server.server.utils;

import l1j.server.server.model.Instance.L1PcInstance;

public class CalcInitHpMp {

	private CalcInitHpMp() {
	}

	/**
	 * eNXHP
	 * 
	 * @param pc
	 * @return hp
	 * 
	 */
	public static int calcInitHp(L1PcInstance pc) {
		int hp = 1;
		if (pc.isCrown()) {
			hp = 14;
		} else if (pc.isKnight()) {
			hp = 16;
		} else if (pc.isElf()) {
			hp = 15;
		} else if (pc.isWizard()) {
			hp = 12;
		} else if (pc.isDarkelf()) {
			hp = 12;
		} else if (pc.isDragonKnight()) {
			hp = 15;
		} else if (pc.isIllusionist()) {
			hp = 15;
		}
		return hp;
	}

	/**
	 * eNXMP
	 * 
	 * @param pc
	 * @return mp
	 * 
	 */
	public static int calcInitMp(L1PcInstance pc) {
		int mp = 1;
		if (pc.isCrown()) {
			switch (pc.getWis()) {
			case 11:
				mp = 2;
				break;
			case 12:
			case 13:
			case 14:
			case 15:
				mp = 3;
				break;
			case 16:
			case 17:
			case 18:
				mp = 4;
				break;
			default:
				mp = 2;
				break;
			}
		} else if (pc.isKnight()) {
			switch (pc.getWis()) {
			case 9:
			case 10:
			case 11:
				mp = 1;
				break;
			case 12:
			case 13:
				mp = 2;
				break;
			default:
				mp = 1;
				break;
			}
		} else if (pc.isElf()) {
			switch (pc.getWis()) {
			case 12:
			case 13:
			case 14:
			case 15:
				mp = 4;
				break;
			case 16:
			case 17:
			case 18:
				mp = 6;
				break;
			default:
				mp = 4;
				break;
			}
		} else if (pc.isWizard()) {
			switch (pc.getWis()) {
			case 12:
			case 13:
			case 14:
			case 15:
				mp = 6;
				break;
			case 16:
			case 17:
			case 18:
				mp = 8;
				break;
			default:
				mp = 6;
				break;
			}
		} else if (pc.isDarkelf()) {
			switch (pc.getWis()) {
			case 10:
			case 11:
				mp = 3;
				break;
			case 12:
			case 13:
			case 14:
			case 15:
				mp = 4;
				break;
			case 16:
			case 17:
			case 18:
				mp = 6;
				break;
			default:
				mp = 3;
				break;
			}
		} else if (pc.isDragonKnight()) {
			switch (pc.getWis()) {
			case 12:
			case 13:
			case 14:
			case 15:
				mp = 4;
				break;
			case 16:
			case 17:
			case 18:
				mp = 6;
				break;
			default:
				mp = 4;
				break;
			}
		} else if (pc.isIllusionist()) {
			switch (pc.getWis()) {
			case 12:
			case 13:
			case 14:
			case 15:
				mp = 4;
				break;
			case 16:
			case 17:
			case 18:
				mp = 6;
				break;
			default:
				mp = 4;
				break;
			}
		}
		return mp;
	}
}