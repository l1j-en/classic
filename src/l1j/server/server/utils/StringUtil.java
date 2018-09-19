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

import java.util.List;

public class StringUtil {
	public static String[] newArray(Object... obj) {
		String[] result = new String[obj.length];
		for (int i = 0; i < obj.length; i++) {
			result[i] = obj[i].toString();
		}
		return result;
	}

	public static String complementClassName(String className,
			String defaultPackage) {
		if (className.contains(".")) {
			return className;
		}
		return defaultPackage + "." + className;
	}

	public static <T> String join(List<T> list, String with) {
		StringBuffer buf = new StringBuffer();
		for (T s : list) {
			if (buf.length() > 0) {
				buf.append(with);
			}
			buf.append(s);
		}
		return buf.toString();
	}
}