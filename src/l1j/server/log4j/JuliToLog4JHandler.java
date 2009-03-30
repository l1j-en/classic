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

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;

/**
 * This class forwards JULI logging requests to Log4j.<br>
 * List of JULI -> Log4J level mappings.
 * <ul>
 * <li>{@link java.util.logging.Level#OFF} -> {@link org.apache.log4j.Level#OFF}</li>
 * <li>{@link java.util.logging.Level#SEVERE} -> {@link org.apache.log4j.Level#ERROR}</li>
 * <li>{@link java.util.logging.Level#WARNING} -> {@link org.apache.log4j.Level#WARN}</li>
 * <li>{@link java.util.logging.Level#INFO} -> {@link org.apache.log4j.Level#INFO}</li>
 * <li>{@link java.util.logging.Level#CONFIG} -> {@link org.apache.log4j.Level#DEBUG}</li>
 * <li>{@link java.util.logging.Level#FINE} -> {@link org.apache.log4j.Level#DEBUG}</li>
 * <li>{@link java.util.logging.Level#FINER} -> {@link org.apache.log4j.Level#TRACE}</li>
 * <li>{@link java.util.logging.Level#FINEST} -> {@link org.apache.log4j.Level#TRACE}</li>
 * <li>{@link java.util.logging.Level#ALL} -> {@link org.apache.log4j.Level#ALL}</li>
 * </ul>
 * <p/> Custom levels are passed with the same integer priority. <br>
 * 
 */
public class JuliToLog4JHandler extends Handler
{

	/**
	 * Forwards JULI LogRecord to Log4J. This method resolves needed log4j level and fixes caller class issue so methods
	 * and lines are correctly displayed by log4j.
	 * 
	 * @param record
	 *            LogRecord to forward
	 */
	@Override
	public void publish(LogRecord record)
	{

		String loggerName = record.getLoggerName();
		if (loggerName == null)
		{
			loggerName = "";
		}

		Logger log = Logger.getLogger(loggerName);
		org.apache.log4j.Level level = toLog4jLevel(record.getLevel());
		log.log(java.util.logging.Logger.class.getName(), level, record.getMessage(), record.getThrown());
	}

	/**
	 * Converts JULI level to Log4J level.<br>
	 * TODO: Implement better handling of custom JULI levels here.
	 * 
	 * @param juliLevel
	 *            level that should be converted to log4j
	 * @return Log4J level
	 */
	protected org.apache.log4j.Level toLog4jLevel(Level juliLevel)
	{
		if (Level.OFF.equals(juliLevel))
		{
			return org.apache.log4j.Level.OFF;
		}
		else if (Level.SEVERE.equals(juliLevel))
		{
			return org.apache.log4j.Level.ERROR;
		}
		else if (Level.WARNING.equals(juliLevel))
		{
			return org.apache.log4j.Level.WARN;
		}
		else if (Level.INFO.equals(juliLevel))
		{
			return org.apache.log4j.Level.INFO;
		}
		else if (Level.CONFIG.equals(juliLevel) || Level.FINE.equals(juliLevel))
		{
			return org.apache.log4j.Level.DEBUG;
		}
		else if (Level.FINER.equals(juliLevel) || Level.FINEST.equals(juliLevel))
		{
			return org.apache.log4j.Level.TRACE;
		}
		else if (Level.ALL.equals(juliLevel))
		{
			return org.apache.log4j.Level.ALL;
		}
		else
		{
			// noinspection ThrowableInstanceNeverThrown
			LogLog.warn("Warning: usage of custom JULI level: " + juliLevel.getName(), new Exception());
			// Custom JULI Levels are cause of memory leaks with classloaders
			// Should not be used...
			// see:
			// http://blogs.sun.com/fkieviet/entry/classloader_leaks_the_dreaded_java
			// see: http://blogs.sun.com/fkieviet/entry/how_to_fix_the_dreaded
			// see:
			// http://blogs.sun.com/edwardchou/entry/javaone_bof_on_memory_leaks
			return new CustomLog4jLevel(juliLevel.intValue(), juliLevel.getName(), juliLevel.intValue());
		}
	}

	/**
	 * This method does nothing
	 */
	@Override
	public void flush()
	{
		// do nothing
	}

	/**
	 * This method does nothing
	 * 
	 * @throws SecurityException
	 *             never thrown
	 */
	@Override
	public void close() throws SecurityException
	{
		// do nothing
	}

	/**
	 * This class represents cutom level in Log4J. In best case it shouldn't be used at all.
	 */
	protected static class CustomLog4jLevel extends org.apache.log4j.Level
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Creates new Level of logging for Log4J
		 * 
		 * @param level
		 *            integer value of level
		 * @param levelStr
		 *            name of level
		 * @param syslogEquivalent
		 *            System log equvalent of level
		 */
		protected CustomLog4jLevel(int level, String levelStr, int syslogEquivalent)
		{
			super(level, levelStr, syslogEquivalent);
		}
	}
}
