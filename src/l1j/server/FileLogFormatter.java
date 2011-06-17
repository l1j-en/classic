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
package l1j.server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class FileLogFormatter extends Formatter {
	private static final String CRLF = "\r\n";
	private static final String _ = "\t";
	private SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss,SSS");

	@Override
	public String format(LogRecord record) {
		StringBuffer output = new StringBuffer();
		output.append(dateFmt.format(new Date(record.getMillis())));
		output.append(_);
		output.append(record.getLevel().getName());
		output.append(_);
		output.append(record.getThreadID());
		output.append(_);
		output.append(record.getLoggerName());
		output.append(_);
		output.append(record.getMessage());
		output.append(CRLF);
		return output.toString();
	}
}