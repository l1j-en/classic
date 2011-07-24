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

import java.sql.SQLException;

/**
 * @see SQLException
 * @see L1QueryUtil
 */
public class L1SQLException extends RuntimeException {
	private static final long serialVersionUID = -2466780963010001937L;

	public L1SQLException(SQLException e) {
		super(e);
	}

	public L1SQLException(String message, SQLException e) {
		super(message, e);
	}
}