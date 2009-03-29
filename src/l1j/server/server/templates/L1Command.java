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
package l1j.server.server.templates;

public class L1Command {
	private final String _name;
	private final int _level;
	private final String _executorClassName;

	public L1Command(String name, int level, String executorClassName) {
		_name = name;
		_level = level;
		_executorClassName = executorClassName;
	}

	public String getName() {
		return _name;
	}

	public int getLevel() {
		return _level;
	}

	public String getExecutorClassName() {
		return _executorClassName;
	}
}
