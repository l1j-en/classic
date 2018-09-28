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

/*
 * (Tricid) This is the second class in the pipeline that handles packets (after ChannelInit).
 * All this is doing is continually reading bytes until a proper packet is formed.  Afterwards, it passes it
 * to the next in the pipeline (the decrypter). 
 */
package l1j.server.server.network;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class PacketDecoder extends ByteToMessageDecoder {

	Logger _log = LoggerFactory.getLogger(PacketDecoder.class);

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) {
		// its likely already closed at this point
		// but lets make sure
		try {
			ctx.close();
		} catch (Exception e) {
		}
		
		Client client = NetworkServer.getInstance().getClients().get(ctx.channel().id());

		if (client != null) {
			try {
				client.handleDisconnect();
			} catch (Exception e) {
				_log.error("", e);
			}
		}

		try {
			NetworkServer.getInstance().getClients().remove(ctx.channel().id());
		} catch (Exception e) {
		}
		_log.error("", cause);

	}

	@Override
	public void channelInactive(final ChannelHandlerContext ctx) {
		Client client = NetworkServer.getInstance().getClients().get(ctx.channel().id());

		if (client != null) {
			try {
				client.handleDisconnect();
			} catch (Exception e) {
				_log.error("", e);
			}
		}
		NetworkServer.getInstance().getClients().remove(ctx.channel().id());
	}

	@Override
	public void channelActive(final ChannelHandlerContext ctx) {

	}

	protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		int dataLength = 0;
		if (in.readableBytes() >= 2) {
			int hiByte = in.getByte(in.readerIndex()) & 0xff;
			int loByte = in.getByte(in.readerIndex() + 1) & 0xff;
			dataLength = (loByte * 256 + hiByte) - 2;
		}

		if (in.readableBytes() >= dataLength + 2) {
			byte[] frame = new byte[dataLength];
			in.getBytes(in.readerIndex() + 2, frame, 0, dataLength);
			in.readerIndex(in.readerIndex() + dataLength + 2);
			return frame;
		}
		return null;
	}

	@Override
	protected final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		Object decoded = decode(ctx, in);
		if (decoded != null) {
			out.add(decoded);
		}
	}

}
