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
package l1j.server.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

public class ThrowableAsMessageAwareFactory implements LoggerFactory
{

	/**
	 * Creates new logger with given name
	 * 
	 * @param name
	 *            new logger's name
	 * @return new logger instance
	 */
	@Override
	public Logger makeNewLoggerInstance(String name)
	{
		return new ThrowableAsMessageLogger(name);
	}
}
