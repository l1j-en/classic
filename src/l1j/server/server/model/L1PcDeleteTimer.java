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
package l1j.server.server.model;

import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_Disconnect;

public class L1PcDeleteTimer implements Runnable {
	private static final Logger _log = LoggerFactory.getLogger(L1PcDeleteTimer.class
			.getName());
	private ScheduledFuture<?> future;

	public L1PcDeleteTimer(L1PcInstance pc) {
		_pc = pc;
	}

	@Override
	public void run() {
		try {
			_log.info("L1PcDeleteTimer: sending disconnect packet");
			_pc.sendPackets(new S_Disconnect());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error("",e);
		}
	}

	public void begin() {
		future = GeneralThreadPool.getInstance().schedule(this, 10 * 60 * 1000);
	}
	
	public void cancel() {
		try {
			future.cancel(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error("",e);
		}
	}

	private final L1PcInstance _pc;

}
