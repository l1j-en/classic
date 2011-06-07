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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import l1j.server.Config;

public class BinaryOutputStream extends OutputStream {
	private static final String CLIENT_LANGUAGE_CODE = Config
			.CLIENT_LANGUAGE_CODE;

	private final ByteArrayOutputStream _bao = new ByteArrayOutputStream();

	public BinaryOutputStream() {
	}

	@Override
	public void write(int b) throws IOException {
		_bao.write(b);
	}

	public void writeD(int value) {
		_bao.write(value & 0xff);
		_bao.write(value >> 8 & 0xff);
		_bao.write(value >> 16 & 0xff);
		_bao.write(value >> 24 & 0xff);
	}

	public void writeH(int value) {
		_bao.write(value & 0xff);
		_bao.write(value >> 8 & 0xff);
	}

	public void writeC(int value) {
		_bao.write(value & 0xff);
	}

	public void writeP(int value) {
		_bao.write(value);
	}

	public void writeL(long value) {
		_bao.write((int) (value & 0xff));
	}

	public void writeF(double org) {
		long value = Double.doubleToRawLongBits(org);
		_bao.write((int) (value & 0xff));
		_bao.write((int) (value >> 8 & 0xff));
		_bao.write((int) (value >> 16 & 0xff));
		_bao.write((int) (value >> 24 & 0xff));
		_bao.write((int) (value >> 32 & 0xff));
		_bao.write((int) (value >> 40 & 0xff));
		_bao.write((int) (value >> 48 & 0xff));
		_bao.write((int) (value >> 56 & 0xff));
	}

	public void writeS(String text) {
		try {
			if (text != null) {
				_bao.write(text.getBytes(CLIENT_LANGUAGE_CODE));
			}
		} catch (Exception e) {
		}

		_bao.write(0);
	}

	public void writeByte(byte[] text) {
		try {
			if (text != null) {
				_bao.write(text);
			}
		} catch (Exception e) {
		}
	}

	public int getLength() {
		return _bao.size() + 2;
	}

	public byte[] getBytes() {
		return _bao.toByteArray();
	}
}
