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
package l1j.server.server.types;

/**
 * Handles 32 bit unsigned long conversions, due to the lack in the java core.
 * 
 * @author Storm
 */
public class ULong32 {
	public final static long MAX_UNSIGNEDLONG_VALUE = 2147483647L;

	/**
	 * Converts a 8 bit char buffer to a 32 bit unsigned long.
	 * 
	 * @param buff
	 *            the buffer to convert
	 * @return long unsigned long value stored as a long
	 */
	public static long fromArray(char[] buff) {
		return fromLong64(((buff[3] & 0xFF) << 24) | ((buff[2] & 0xFF) << 16)
				| ((buff[1] & 0xFF) << 8) | (buff[0] & 0xFF));
	}

	/**
	 * Converts a 8 bit byte buffer to a 32 bit unsigned long.
	 * 
	 * @param buff
	 *            the buffer to convert
	 * @return long unsigned long value stored as a long
	 */
	public static long fromArray(byte[] buff) {
		return fromLong64(((buff[3] & 0xFF) << 24) | ((buff[2] & 0xFF) << 16)
				| ((buff[1] & 0xFF) << 8) | (buff[0] & 0xFF));
	}

	/**
	 * Converts a 64 bit, java's standard, long to a 32 bit unsigned long. Chops
	 * away the high 32 bits
	 * 
	 * @param l
	 *            the long value to convert
	 * @return long unsigned long value stored as a long
	 */
	public static long fromLong64(long l) {
		return (((l << 32) >>> 32) & 0xFFFFFFFF);
	}

	/**
	 * Converts a 32 bit, java's standard, int to a 32 bit unsigned long.
	 * 
	 * @param i
	 *            the int value to convert
	 * @return long unsigned long value stored as a long
	 */
	public static long fromInt32(int i) {
		return ((((long) i << 32) >>> 32) & 0xFFFFFFFF);
	}

	/**
	 * Adds two 32 bit unsigned/signed long values
	 * 
	 * @param l1
	 *            the addee
	 * @param l2
	 *            to be added
	 * @return long unsigned long value stored as a long
	 */
	public static long add(long l1, long l2) {
		return fromInt32((int) l1 + (int) l2);
	}

	/**
	 * Subtracts two 32 bit unsigned/signed long values
	 * 
	 * @param l1
	 *            the subtractee
	 * @param l2
	 *            to be subtracted
	 * @return long unsigned long value stored as a long
	 */
	public static long sub(long l1, long l2) {
		return fromInt32((int) l1 - (int) l2);
	}
}
