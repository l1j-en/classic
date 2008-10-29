/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package l1j.server.server.utils;

import java.util.logging.Logger;

import javolution.util.FastMap;
import javolution.util.FastMap.Entry;
import l1j.server.Config;
import l1j.server.server.model.gametime.L1GameTime;

/*By Darkwolf*/
public class FloodProtector
{
	private static final Logger _log = Logger.getLogger(FloodProtector.class.getName());
	
	private static FloodProtector _instance;
	
	public static final FloodProtector getInstance()
	{
		if (_instance == null)
		{
			_instance = new FloodProtector();
		}
		return _instance;
	}
	
	// =========================================================
	// Data Field
	private FastMap<Integer, Integer[]> _floodClient;
	
	// =========================================================
	
	// reuse delays for protected actions (in game ticks 1 tick = 100ms)
	private static final int[] REUSEDELAY = new int[]
	{
		4, 42, 42, 16, 100, 10, 20, 50
	};
	
	// protected actions
	// if there are more exploits or packet floods add them here and in the packet
	public static final int PROTECTED_USEITEM = 0;
	public static final int PROTECTED_PICKUPITEM = 1;// need to do
	public static final int PROTECTED_DELETEINVENTORYITEM = 2; // need to do
	public static final int PROTECTED_DROPITEM = 3;//need to do
	public static final int PROTECTED_GIVEITEM = 4;// need to do

	// =========================================================
	// Constructor
	private FloodProtector()
	{
		_log.info("Initializing FloodProtector");
		_floodClient = new FastMap<Integer, Integer[]>(Config.FLOODPROTECTOR_INITIALSIZE).setShared(true);
	}
	
	/**
	 * Add a new player to the flood protector (should be done for all players
	 * when they enter the world)
	 * 
	 * @param playerObjId
	 */
	public void registerNewPlayer(int playerObjId)
	{
		// create a new array
		Integer[] array = new Integer[REUSEDELAY.length];
		for (int i = 0; i < array.length; i++)
			array[i] = 0;
		
		// register the player with an empty array
		_floodClient.put(playerObjId, array);
	}
	
	/**
	 * Remove a player from the flood protector (should be done if player loggs
	 * off)
	 * 
	 * @param playerObjId
	 */
	public void removePlayer(int playerObjId)
	{
		_floodClient.remove(playerObjId);
	}
	
	/**
	 * Return the size of the flood protector
	 * 
	 * @return size
	 */
	public int getSize()
	{
		return _floodClient.size();
	}
	
	/**
	 * Try to perform the requested action
	 * 
	 * @param playerObjId
	 * @param action
	 * @return true if the action may be performed
	 */
	public boolean tryPerformAction(int playerObjId, int action)
	{
		Entry<Integer, Integer[]> entry = _floodClient.getEntry(playerObjId);
		if (entry == null)
			return false; // player just disconnected
		Integer[] value = entry.getValue();
		
		if (value[action] < L1GameTime.getSeconds())
		{
			value[action] = L1GameTime.getSeconds() + REUSEDELAY[action];
			entry.setValue(value);
			return true;
		}
		return false;
	}
}