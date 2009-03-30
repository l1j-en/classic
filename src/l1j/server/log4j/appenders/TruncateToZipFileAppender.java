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

package l1j.server.log4j.appenders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.FileAppender;
import org.apache.log4j.helpers.LogLog;

import l1j.server.log4j.exceptions.AppenderInitializationError;

/**
 * This class is appender that zips old file instead of appending it.<br>
 * File is recognized as old if it's lastModified() is < JVM startup time.<br>
 * So we can have per-run appending.<p/> <br>
 * 
 * Unfortunaltely, UNIX systems doesn't support file creation date, so we have to use lastModified(), windows only
 * solution is not good.
 * 
 */
public class TruncateToZipFileAppender extends FileAppender
{

	/**
	 * String that points to root directory for backups
	 */
	private String	backupDir			= "log/backup";

	/**
	 * String that represents date format for backup files
	 */
	private String	backupDateFormat	= "yyyy-MM-dd HH-mm-ss";

	/**
	 * <p>
	 * Sets and <i>opens</i> the file where the log output will go. The specified file must be writable. <p/>
	 * <p>
	 * If there was already an opened file, then the previous file is closed first. <p/>
	 * <p>
	 * <b>Do not use this method directly. To configure a FileAppender or one of its subclasses, set its properties one
	 * by one and then call activateOptions.</b> <p/> <br>
	 * Truncation is done by {@link #truncate(java.io.File)}
	 * 
	 * @param fileName
	 *            The path to the log file.
	 * @param append
	 *            If true will append to fileName. Otherwise will truncate fileName.
	 */
	@Override
	public void setFile(String fileName, boolean append, boolean bufferedIO, int bufferSize) throws IOException
	{

		if (!append)
		{
			truncate(new File(fileName));
		}

		super.setFile(fileName, append, bufferedIO, bufferSize);
	}

	/**
	 * This method creates archive with file instead of deleting it.
	 * 
	 * @param file
	 *            file to truncate
	 */
	protected void truncate(File file)
	{
		LogLog.debug("Compression of file: " + file.getAbsolutePath() + " started.");

		// Linux systems doesn't provide file creation time, so we have to hope
		// that log files
		// were not modified manually after server starup
		// We can use here Windowns-only solution but that suck :(
		if (FileUtils.isFileOlder(file, ManagementFactory.getRuntimeMXBean().getStartTime()))
		{
			File backupRoot = new File(getBackupDir());
			if (!backupRoot.exists() && !backupRoot.mkdirs())
			{
				throw new AppenderInitializationError("Can't create backup dir for backup storage");
			}

			SimpleDateFormat df;
			try
			{
				df = new SimpleDateFormat(getBackupDateFormat());
			}
			catch (Exception e)
			{
				throw new AppenderInitializationError(
					"Invalid date formate for backup files: " + getBackupDateFormat(), e);
			}
			String date = df.format(new Date(file.lastModified()));

			File zipFile = new File(backupRoot, file.getName() + "." + date + ".zip");

			ZipOutputStream zos = null;
			FileInputStream fis = null;
			try
			{
				zos = new ZipOutputStream(new FileOutputStream(zipFile));
				ZipEntry entry = new ZipEntry(file.getName());
				entry.setMethod(ZipEntry.DEFLATED);
				entry.setCrc(FileUtils.checksumCRC32(file));
				zos.putNextEntry(entry);
				fis = FileUtils.openInputStream(file);

				byte[] buffer = new byte[1024];
				int readed;
				while ((readed = fis.read(buffer)) != -1)
				{
					zos.write(buffer, 0, readed);
				}

			}
			catch (Exception e)
			{
				throw new AppenderInitializationError("Can't create zip file", e);
			}
			finally
			{
				if (zos != null)
				{
					try
					{
						zos.close();
					}
					catch (IOException e)
					{
						// not critical error
						LogLog.warn("Can't close zip file", e);
					}
				}

				if (fis != null)
				{
					try
					{
						// not critical error
						fis.close();
					}
					catch (IOException e)
					{
						LogLog.warn("Can't close zipped file", e);
					}
				}
			}

			if (!file.delete())
			{
				throw new AppenderInitializationError("Can't delete old log file " + file.getAbsolutePath());
			}
		}
	}

	/**
	 * Returns root directory for backups
	 * 
	 * @return root directory for backups
	 */
	public String getBackupDir()
	{
		return backupDir;
	}

	/**
	 * Sets root directory for backups
	 * 
	 * @param backupDir
	 *            new root directory for backups
	 */
	public void setBackupDir(String backupDir)
	{
		this.backupDir = backupDir;
	}

	/**
	 * Returns date format that should be used for backup files represented as string
	 * 
	 * @return date formate for backup files
	 */
	public String getBackupDateFormat()
	{
		return backupDateFormat;
	}

	/**
	 * Sets date format for bakcup files represented as string
	 * 
	 * @param backupDateFormat
	 *            date format for backup files
	 */
	public void setBackupDateFormat(String backupDateFormat)
	{
		this.backupDateFormat = backupDateFormat;
	}
}
