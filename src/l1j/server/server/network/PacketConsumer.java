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

package l1j.server.server.network;

/*
 * (Tricid)  These are the packet consumers for the new network model.  They try to pull from a queue that contains
 * clients (not packets), blocking on the queue when it's empty.  Once they get a client it runs a client method that 
 * processes any packets it may have.  That's a bit weird.
 * 
 *  I didn't do a direct packet queue because:  I didn't want two+ consumers working on any one client at the same time;
 *  I also didn't want one client filling up the queue.  I have no idea if that was even necessary.  During further testing
 *  I might tweak how that works.  
 *  
 *  Additionally, if I ever get motivated in the future to implement my speed hack fix I've done on other servers, this is
 *  the model it relies on.  It'll make sense when/if I implement it for l1j
 */
public class PacketConsumer implements Runnable {

	String name;

	public PacketConsumer(String name) {

		// all threads deserve names!
		this.name = name;

	}

	/*
	 * Infinite loop. It will try to take a packet from the queue, then do whatever
	 * work is needed, then try to grab another. If there are no packets to take it
	 * will wait until something is available, so no wasted CPU cycles when there is
	 * nothing to do.
	 */
	@Override
	public final void run() {

		Thread.currentThread().setName(name);

		while (true) {
			// logger.info(name + " is running.");
			Client client = null;

			try {
				client = NetworkServer.getInstance().getClientQueue().take();
				client.run();
			} catch (Exception e) {
				// logger.error("", e);
			}
		}

	}

}
