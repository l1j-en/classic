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

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class InfoUtil {
	private static Logger _log = Logger.getLogger(InfoUtil.class.getName());

	public static String[] getMemoryInfo() {
		double max = Runtime.getRuntime().maxMemory() / 1024; // maxMemory is the upper limit the jvm can use
		double allocated = Runtime.getRuntime().totalMemory() / 1024; // totalMemory the size of the current allocation pool
		double nonAllocated = max - allocated; // non allocated memory till jvm limit
		double cached = Runtime.getRuntime().freeMemory() / 1024; // freeMemory the unused memory in the allocation pool
		double used = allocated - cached; // really used memory
		double useable = max - used; // allocated, but non-used and non-allocated memory
		DecimalFormat df = new DecimalFormat(" (0.0000'%')");
		DecimalFormat df2 = new DecimalFormat(" # 'KB'");

		return new String[] {
		    "+----",
			"| Memory Usage" + getRealTime().toString() + ":",
			"| Allow Memory Usage : " + df2.format(max),
			"| Dynamic Allocation Memory : " + df2.format (allocated) + df.format (allocated / max * 100),
			"| Non-dynamic Memory : " + df2.format (nonAllocated) + df.format (nonAllocated / max * 100),
			"| Dynamic Allocated Memory : " + df2.format (allocated),
			"| Using memory : " + df2.format (used) + df.format (used / max * 100),
			"| Unused (cache) memory : " + df2.format (cached) + df.format (cached/ max * 100),
			"| Available memory : " + df2.format (useable) + df.format (useable / max * 100),
			"+----"
		};
	}

	public static String[] getCPUInfo() {
		return new String[] {
		    "System Processor Unit : " + Runtime.getRuntime().availableProcessors(),
			"Processor Identification code : " + System.getenv("PROCESSOR_IDENTIFIER"),
			"=================================================",
		};
	}

	public static String[] getOSInfo() {
		return new String[] {
		    "System : " + System.getProperty("os.name") + " Build: " + System.getProperty("os.version"),
			"Operation System Version : " + System.getProperty("os.arch"),
			"=================================================",
		};
	}

	public static String[] getJREInfo() {
		return new String[] {
			"Java Platform Information",
			"Java Runtime Name : " + System.getProperty("java.runtime.name"),
			"Java Version : " + System.getProperty("java.version"),
			"Java Class Version : " + System.getProperty("java.class.version"),
			"=================================================",
		};
	}

	public static String[] getJVMInfo() {
		return new String[] {
			"JAVA virtual machine (JVM)",
			"JVM name:" + System.getProperty ("Java.VM.name"),
			"JVM installation directory :" +System.getProperty ("Java.home"),
			"JVM version :" + System.getProperty ("Java.VM.version"),
			"JVM production companies :" +System.getProperty ("Java.VM.vendor"),
			"JVM mode :" + System.getProperty ("Java.VM.info"),
			"=================================================",
		};
	}

	public static String getRealTime() {
		SimpleDateFormat String = new SimpleDateFormat("H:mm:ss");

		return String.format(new Date());
	}

	public static void printMemoryInfo() {
		for (String line : getMemoryInfo()) {
			_log.info(line);
		}
	}

	public static void printCPUInfo() {
		for (String line : getCPUInfo()) {
			_log.info(line);
		}
	}

	public static void printOSInfo() {
		for (String line : getOSInfo()) {
			_log.info(line);
		}
	}

	public static void printJREInfo() {
		for (String line : getJREInfo()) {
			_log.info(line);
		}
	}

	public static void printJVMInfo() {
		for (String line : getJVMInfo()) {
			_log.info(line);
		}
	}

	public static void printRealTime() {
		_log.info(getRealTime().toString());
	}

	public static void printAllInfos() {
		printOSInfo();
		printCPUInfo();
		printJREInfo();
		printJVMInfo();
		printMemoryInfo();
	}
}