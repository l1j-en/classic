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
package l1j.server.server.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.Announcements;
import l1j.server.server.datatables.UBTable;
import l1j.server.server.model.L1UltimateBattle;

public class UbTimeController implements Runnable {
	private static Logger _log = LoggerFactory.getLogger(UbTimeController.class
			.getName());
	private static UbTimeController _instance;

	public static UbTimeController getInstance() {
		if (_instance == null) {
			_instance = new UbTimeController();
		}
		return _instance;
	}

	@Override
	public void run() {
		Thread.currentThread().setName("UbTimeController");
		try {
			while (true) {
				checkUbTime(); // UB Check the time to start
				Thread.sleep(15000);
			}
		} catch (Exception e1) {
			_log.warn(e1.getMessage());
		}
	}

	private void checkUbTime() {
		for (L1UltimateBattle ub : UBTable.getInstance().getAllUb()) {
			if (ub.checkUbTime() && !ub.isActive()) {
				ub.start(); // UB Start
				Announcements.getInstance().announceToAll(
						"\\fR[******] The " + ub.getUbName()
								+ " deathmatch will begin in 5");
				Announcements
						.getInstance()
						.announceToAll(
								"\\fR         minutes. Please enter the colosseum now.");
			}
		}
	}
}