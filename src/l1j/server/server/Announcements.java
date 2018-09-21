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
package l1j.server.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.utils.StreamUtil;

public class Announcements {
	private static Logger _log = LoggerFactory.getLogger(Announcements.class.getName());

	private static Announcements _instance;

	private final List<String> _announcements = new ArrayList<String>();

	private Announcements() {
		loadAnnouncements();
	}

	public static Announcements getInstance() {
		if (_instance == null) {
			_instance = new Announcements();
		}

		return _instance;
	}

	private void loadAnnouncements() {
		_announcements.clear();
		File file = new File("data/announcements.txt");
		if (file.exists()) {
			readFromDisk(file);
		} else {
			_log.info("data/announcements.txt doesn't exist.");
		}
	}

	public void showAnnouncements(L1PcInstance showTo) {
		for (String msg : _announcements) {
			showTo.sendPackets(new S_SystemMessage(msg));
		}
	}

	private void readFromDisk(File file) {
		LineNumberReader lnr = null;
		try {
			int i = 0;
			String line = null;
			lnr = new LineNumberReader(new FileReader(file));
			while ((line = lnr.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\n\r");
				if (st.hasMoreTokens()) {
					String announcement = st.nextToken();
					_announcements.add(announcement);
					i++;
				}
			}
			_log.info("Notification " + i + " read.");
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			StreamUtil.close(lnr);
		}
	}

//	private void saveToDisk() {
//		File file = new File("data/announcements.txt");
//		FileWriter save = null;
//
//		try {
//			save = new FileWriter(file);
//			for (String msg : _announcements) {
//				save.write(msg);
//				save.write("\r\n");
//			}
//		} catch (IOException e) {
//			_log.error("Saving the announcements file has failed.",
//					e);
//		} finally {
//			StreamUtil.close(save);
//		}
//	}

	public void announceToAll(String msg) {
		L1World.getInstance().broadcastServerMessage(msg);
	}
}
