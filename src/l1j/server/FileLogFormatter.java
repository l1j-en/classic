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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class FileLogFormatter extends Formatter {

	private SimpleDateFormat dateFmt = new SimpleDateFormat(
			"yyyy.MM.dd HH:mm:ss");

	@Override
	public String format(LogRecord record) {
		StringBuffer output = new StringBuffer();

		if (record.getLevel().intValue() == Level.CONFIG.intValue()) {
			output.append(record.getMessage());
			output.append("\r\n");
		} else {
			output.append(dateFmt.format(new Date(record.getMillis())));
			output.append(" ");
			output.append(record.getSourceClassName());
			output.append(".");
			output.append(record.getSourceMethodName());
			output.append(" ");
			output.append(record.getLevel());
			output.append(": ");
			output.append(record.getMessage());
			output.append("\r\n");
			if (record.getThrown() != null) {
				try {
					StringWriter sw = new StringWriter();
					PrintWriter pw = new PrintWriter(sw);
					record.getThrown().printStackTrace(pw);
					pw.close();
					output.append(dateFmt.format(new Date(record.getMillis())));
					output.append(" ");
					output.append(sw.toString());
					output.append("\r\n");
				} catch (Exception ex) {
				}
			}
		}
		return output.toString();
	}
}