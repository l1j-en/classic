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

import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.apache.log4j.Hierarchy;
import org.apache.log4j.xml.DOMConfigurator;

import l1j.server.log4j.exceptions.Log4jInitializationError;

public class LoggingService
{

	/**
	 * Property that represents {@link org.apache.log4j.spi.LoggerFactory} class
	 */
	public static final String	LOGGER_FACTORY_CLASS_PROPERTY	= "log4j.loggerfactory";

	/**
	 * Default log4j configuration file
	 */
	public static final String	LOGGER_CONFIG_FILE				= "config/log4j.xml";

	/**
	 * Is Logging initialized or not?
	 */
	private static boolean		initialized;

	/**
	 * Initializes logging system with {@link #LOGGER_CONFIG_FILE default} config file
	 * 
	 * @throws com.aionemu.commons.log4j.exceptions.Log4jInitializationError
	 *             if can't initialize logging
	 */
	public static void init() throws Log4jInitializationError
	{
		File f = new File(LOGGER_CONFIG_FILE);

		if (!f.exists())
		{
			throw new Log4jInitializationError("Missing file " + f.getPath());
		}

		try
		{
			init(f.toURI().toURL());
		}
		catch (MalformedURLException e)
		{
			throw new Log4jInitializationError("Can't initalize logging", e);
		}
	}

	/**
	 * Initializes logging system with config file from URL
	 * 
	 * @param url
	 *            config file location
	 * @throws com.aionemu.commons.log4j.exceptions.Log4jInitializationError
	 *             if can't initialize logging
	 */
	public static void init(URL url) throws Log4jInitializationError
	{
		synchronized (LoggingService.class)
		{
			if (initialized)
			{
				return;
			}
			else
			{
				initialized = true;
			}
		}

		try
		{
			DOMConfigurator.configure(url);
		}
		catch (Exception e)
		{
			throw new Log4jInitializationError("Can't initialize logging", e);
		}

		overrideDefaultLoggerFactory();

		// Initialize JULI to Log4J bridge
		Logger logger = LogManager.getLogManager().getLogger("");
		for (Handler h : logger.getHandlers())
		{
			logger.removeHandler(h);
		}

		logger.addHandler(new JuliToLog4JHandler());
	}

	/**
	 * This method uses some reflection to hack default log4j log facrory. <p/>
	 * 
	 * Log4j uses this Hierarchy for loggers that don't have exact name match and element categoryFactory for loggers
	 * with names that matches specified names in log4j.xml. <p/>
	 * 
	 * See log4j.xml for detailed description of Log4j behaviour.
	 */
	private static void overrideDefaultLoggerFactory()
	{
		// Hack here, we have to overwrite default logger factory
		Hierarchy lr = (Hierarchy) org.apache.log4j.LogManager.getLoggerRepository();
		try
		{
			Field field = lr.getClass().getDeclaredField("defaultFactory");
			field.setAccessible(true);
			String cn = System.getProperty(LOGGER_FACTORY_CLASS_PROPERTY, ThrowableAsMessageAwareFactory.class
				.getName());
			Class<?> c = Class.forName(cn);
			field.set(lr, c.newInstance());
			field.setAccessible(false);
		}
		catch (NoSuchFieldException e)
		{
			// never thrown
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			// never thrown
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			throw new Log4jInitializationError("Can't found log4j logger factory class", e);
		}
		catch (InstantiationException e)
		{
			throw new Log4jInitializationError("Can't instantiate log4j logger factory", e);
		}
	}
}
