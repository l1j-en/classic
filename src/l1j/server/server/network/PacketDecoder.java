package l1j.server.server.network;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class PacketDecoder extends ByteToMessageDecoder {

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void channelInactive(final ChannelHandlerContext ctx) {
		Client client = NetworkServer.getInstance().getClients().get(ctx.channel().id());
		client.handleDisconnect();
	}

	@Override
	public void channelActive(final ChannelHandlerContext ctx) {

	}

	protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		System.out.println("readable " + in.readableBytes());
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
