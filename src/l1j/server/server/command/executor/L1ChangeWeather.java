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
package l1j.server.server.command.executor;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.serverpackets.S_Weather;

public class L1ChangeWeather implements L1CommandExecutor {

	private L1ChangeWeather() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1ChangeWeather();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			String args[] = arg.split(" ");
			
			if(arg.trim().equals(""))
				throw new Exception();
			
			String weatherString = args[0].toLowerCase();
			int weatherCode = 0;
			
			if(args.length == 2) {
				if(weatherString.equals("rain"))
					weatherCode = 16;
				else if(weatherString.equals("snow"))
					weatherCode = 0;
				
				int intensity = Integer.parseInt(args[1]);
				
				if(intensity < 1 || intensity > 3)
					throw new Exception();
				
				weatherCode += intensity;
			}

			L1World.getInstance().setWeather(weatherCode);
			L1World.getInstance().broadcastPacketToAll(new S_Weather(weatherCode));
			
			// not sure why, but rain requires a follow-up 0 packet
			if(weatherCode > 10)
				L1World.getInstance().broadcastPacketToAll(new S_Weather(0));
			else if(weatherCode == 0)
				L1World.getInstance().broadcastPacketToAll(new S_Weather(16));

		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage("." + cmdName + " [rain/snow/stop] [1-3]"));
		}
	}
}
