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

public class ByteArrayUtil {
	private final byte[] _byteArray;

	public ByteArrayUtil(byte[] byteArray) {
		_byteArray = byteArray;
	}

	public String getTerminatedString(int i) {
		StringBuffer stringbuffer = new StringBuffer();
		for (int j = i; j < _byteArray.length && _byteArray[j] != 0; j++) {
			stringbuffer.append((char) _byteArray[j]);
		}
		return stringbuffer.toString();
	}

	public String dumpToString() {
		StringBuffer stringbuffer = new StringBuffer();
		int j = 0;
		for (int k = 0; k < _byteArray.length; k++) {
			if (j % 16 == 0) {
				stringbuffer.append((new StringBuilder()).append(fillHex(k, 4))
						.append(": ").toString());
			}
			stringbuffer.append((new StringBuilder())
					.append(fillHex(_byteArray[k] & 0xff, 2)).append(" ")
					.toString());
			if (++j != 16) {
				continue;
			}
			stringbuffer.append("   ");
			int i1 = k - 15;
			for (int l1 = 0; l1 < 16; l1++) {
				byte byte0 = _byteArray[i1++];
				if (byte0 > 31 && byte0 < 128) {
					stringbuffer.append((char) byte0);
				} else {
					stringbuffer.append('.');
				}
			}
			stringbuffer.append("\n");
			j = 0;
		}

		int l = _byteArray.length % 16;
		if (l > 0) {
			for (int j1 = 0; j1 < 17 - l; j1++) {
				stringbuffer.append("   ");
			}

			int k1 = _byteArray.length - l;
			for (int i2 = 0; i2 < l; i2++) {
				byte byte1 = _byteArray[k1++];
				if (byte1 > 31 && byte1 < 128) {
					stringbuffer.append((char) byte1);
				} else {
					stringbuffer.append('.');
				}
			}
			stringbuffer.append("\n");
		}
		return stringbuffer.toString();
	}
	
	public static int[] convertToInt(byte[] input)
	{
	    int[] ret = new int[input.length];
	    for (int i = 0; i < input.length; i++)
	    {
	        ret[i] = input[i] & 0xff; // Range 0 to 255, not -128 to 127
	    }
	    return ret;
	}

	private String fillHex(int i, int j) {
		String s = Integer.toHexString(i);
		for (int k = s.length(); k < j; k++) {
			s = (new StringBuilder()).append("0").append(s).toString();
		}
		return s;
	}
	
	public static void writeShort(int value, byte[] array, int offset) {
		array[offset] = (byte) (value & 0xFF);
		array[offset + 1] = (byte) (value >> 8 & 0xFF);
	}
	
	public static void writeInteger(int value, byte[] array, int offset) {
		writeShort(value, array, offset);
		writeShort((value >> 16) & 0xFFFF, array, offset + 2);
	}
}
