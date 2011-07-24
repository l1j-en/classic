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
import java.util.Properties;

public class L1Properties {
	private final Properties _props;

	public L1Properties(Properties props) throws IllegalArgumentException {
		if (props == null) {
			throw new IllegalArgumentException("props is null");
		}
		_props = props;
	}

	public void load(InputStream inStream) throws IOException {
		_props.load(inStream);
	}

	public boolean getBoolean(String key, boolean defaultValue) {
		String value = _props.getProperty(key, String.valueOf(defaultValue));
		return Boolean.parseBoolean(value);
	}

	public int getInteger(String key, int defaultValue) {
		String value = _props.getProperty(key, String.valueOf(defaultValue));
		return Integer.parseInt(value);
	}

	public String getString(String key, String defaulValue) {
		return _props.getProperty(key, defaulValue);
	}

	public String getProperty(String key, String defaulValue) {
		return getString(key, defaulValue);
	}
}