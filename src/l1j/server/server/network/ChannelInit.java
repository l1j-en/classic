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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import l1j.server.Config;
import l1j.server.server.datatables.IpTable;
import l1j.server.server.encryptions.ClientIdExistsException;
import l1j.server.server.encryptions.L1JEncryption;
import l1j.server.server.encryptions.Opcodes;

/*
 * (Tricid)  This is the first class in the pipeline that handles new connections. Right now I'm only
 * using it to send the first packet that the client expects.
 */
public class ChannelInit extends ChannelInitializer<Channel> {

	private static Logger _log = LoggerFactory.getLogger(ChannelInit.class);

	private static final byte[] FIRST_PACKET = {
			(byte) 0x4d, (byte) 0xa7, (byte) 0x32, (byte) 0x5b, (byte) 0x2e,
			(byte) 0x7e, (byte) 0xed, (byte) 0x25, (byte) 0xa5, (byte) 0x54,
			(byte) 0xb3 };

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

	@Override
	protected void initChannel(Channel channel) throws Exception {

		String ip = ((InetSocketAddress) channel.remoteAddress()).getAddress().getHostAddress().toString();

		// check if banned, close and return if yes
		if (IpTable.getInstance().isBannedIp(ip)) {
			channel.close();
			return;
		}

		// check if connections from this IP exceed limits
		int ipcount = Collections.frequency(NetworkServer.getInstance().getIps(), ip);

		if (ipcount >= Config.CONNECTIONS_PER_IP) {
			channel.close();
			return;
		} else {
			NetworkServer.getInstance().getIps().add(ip);
		}

		// prepare first packet buffer
		final ByteBuf first = channel.alloc().buffer(FIRST_PACKET.length + 7);

		// Prepare a new Client, replaces ClientThread
		Client client = null;
		try {
			client = new Client(channel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			_log.error("", e);
		}

		// collections for connections in case we need to find it later
		NetworkServer.getInstance().getClients().put(channel.id(), client);

		String keyHax = Integer.toHexString((int) (Math.random() * 2147483647) + 1);
		int seed = Integer.parseInt(keyHax, 16);
		byte Bogus = (byte) (FIRST_PACKET.length + 7);

		first.writeByte(Bogus & 0xFF);
		first.writeByte(Bogus >> 8 & 0xFF);
		first.writeByte(Opcodes.S_OPCODE_INITPACKET);
		first.writeByte((byte) (seed & 0xFF));
		first.writeByte((byte) (seed >> 8 & 0xFF));
		first.writeByte((byte) (seed >> 16 & 0xFF));
		first.writeByte((byte) (seed >> 24 & 0xFF));
		first.writeBytes(FIRST_PACKET);
		channel.writeAndFlush(first);

		try {
			client.set_clkey(L1JEncryption.initKeys(channel.id(), seed));
		} catch (ClientIdExistsException e) {
			_log.error("", e);
		}
		channel.pipeline().addLast(new PacketDecoder(), new PacketDecrypter());

	}

}
