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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import l1j.server.server.encryptions.L1JEncryption;
import l1j.server.server.encryptions.NoEncryptionKeysSelectedException;

/*
 * (Tricid) The last step in the pipeline.  This class should receive only complete packets/frames to decrypt then pass along
 * to the queue to be processed.  
 */
public class PacketDecrypter extends ChannelInboundHandlerAdapter {

	private static Logger _log = LoggerFactory.getLogger(PacketDecrypter.class);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		readPacket((byte[]) msg, ctx);
	}

	public void readPacket(byte[] data, ChannelHandlerContext ctx) {
		Client client = NetworkServer.getInstance().getClients().get(ctx.channel().id());

		try {
			byte[] decrypted = L1JEncryption.decrypt(data, data.length, client.get_clkey());
			client.getQueue().offer(decrypted);
			NetworkServer.getInstance().getClientQueue().offer(client);
		} catch (NoEncryptionKeysSelectedException e) {
			// TODO Auto-generated catch block
			_log.error("", e);
		}

	}

	@Override
	public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) {
		// its likely already closed at this point
		// but lets make sure
		try {
			ctx.close();
		} catch (Exception e) {
		}

		// I think this will silence those annoying exceptions on disconnects
		if (cause instanceof java.io.IOException) {
		} else {
			_log.error("", cause);
		}

	}
}