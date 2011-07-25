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

public class BinaryUtils {
	public static int getBit(int i, int bit) {
		return ((i >>> (bit - 1)) & 0x01) == 0x01 ? 1 : 0;
	}

	public static String byteToBinaryString(byte i) {
		StringBuilder result = new StringBuilder();
		result.append(getBit(i, 8));
		result.append(getBit(i, 7));
		result.append(getBit(i, 6));
		result.append(getBit(i, 5));
		result.append(" ");
		result.append(getBit(i, 4));
		result.append(getBit(i, 3));
		result.append(getBit(i, 2));
		result.append(getBit(i, 1));
		return result.toString();
	}
}