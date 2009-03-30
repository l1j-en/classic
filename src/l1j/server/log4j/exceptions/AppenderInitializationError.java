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
package l1j.server.log4j.exceptions;

/**
 * This error will be thrown if any of custom appenders won't be able to initialize. We have some logs there, so we
 * shouldn't do any actions with them in case of errors.
 * 
 * @author SoulKeeper
 */
public class AppenderInitializationError extends Error
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new Error
	 */
	public AppenderInitializationError()
	{
	}

	/**
	 * Creates new error
	 * 
	 * @param message
	 *            error description
	 */
	public AppenderInitializationError(String message)
	{
		super(message);
	}

	/**
	 * Creates new error
	 * 
	 * @param message
	 *            error description
	 * @param cause
	 *            reason of this error
	 */
	public AppenderInitializationError(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * Creates new error
	 * 
	 * @param cause
	 *            reason of this error
	 */
	public AppenderInitializationError(Throwable cause)
	{
		super(cause);
	}
}
