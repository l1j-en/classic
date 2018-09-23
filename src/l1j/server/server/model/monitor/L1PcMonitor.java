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
package l1j.server.server.model.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;

public abstract class L1PcMonitor implements Runnable {

	private static Logger _log = LoggerFactory.getLogger(L1PcMonitor.class);

	protected int _id;

	public L1PcMonitor(int oId) {
		_id = oId;
	}

	@Override
	public final void run() {
		try {
			Thread.currentThread().setName("L1PcMonitor");
			L1PcInstance pc = (L1PcInstance) L1World.getInstance().findObject(_id);
			if (pc == null || pc.getNetConnection() == null) {
				return;
			}
			execTask(pc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error("",e);
		}
	}

	public abstract void execTask(L1PcInstance pc);
}
