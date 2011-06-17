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

import java.io.IOException;
import java.io.InputStream;

public class BinaryInputStream extends InputStream {
	InputStream _in;

	public BinaryInputStream(InputStream in) {
		_in = in;
	}

	@Override
	public long skip(long n) throws IOException {
		return _in.skip(n);
	}

	@Override
	public int available() throws IOException {
		return _in.available();
	}

	@Override
	public void close() throws IOException {
		_in.close();
	}

	@Override
	public int read() throws IOException {
		return _in.read();
	}

	public int readByte() throws IOException {
		return _in.read();
	}

	public int readShort() throws IOException {
		return _in.read() | ((_in.read() << 8) & 0xFF00);
	}

	public int readInt() throws IOException {
		return readShort() | ((readShort() << 16) & 0xFFFF0000);
	}
}