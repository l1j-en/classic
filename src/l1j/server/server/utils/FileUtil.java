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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileUtil {
	public static String getExtension(File file) {
		String fileName = file.getName();
		int index = fileName.lastIndexOf('.');
		if (index != -1) {
			return fileName.substring(index + 1, fileName.length());
		}
		return "";
	}

	public static String getNameWithoutExtension(File file) {
		String fileName = file.getName();
		int index = fileName.lastIndexOf('.');
		if (index != -1) {
			return fileName.substring(0, index);
		}
		return "";
	}
	
	public static void writeFile(String fileName, String contents) throws FileNotFoundException, UnsupportedEncodingException {
	    PrintWriter writer = new PrintWriter(fileName, "UTF-8");
	    writer.print(contents);
	    writer.close();
	}
	
	public static void copyFileUsingStream(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	}
}