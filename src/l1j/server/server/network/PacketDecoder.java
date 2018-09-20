package l1j.server.server.network;

import java.io.IOException;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import l1j.server.server.encryptions.ClientIdExistsException;
import l1j.server.server.encryptions.LineageEncryption;

public class PacketDecoder extends ByteToMessageDecoder {
	private static final byte[] FIRST_PACKET = { // 3.0 English KeyPacket
			(byte) 0x41, (byte) 0x5A, (byte) 0x9B, (byte) 0x01, (byte) 0xB6, (byte) 0x81, (byte) 0x01, (byte) 0x09,
			(byte) 0xBD, (byte) 0xCC, (byte) 0xC0 };

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
		final ByteBuf first = ctx.alloc().buffer(FIRST_PACKET.length + 7);
		System.out.println("New Connection1!");
		Client client = null;
		try {
			client = new Client(ctx.channel());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NetworkServer.getInstance().getClients().put(ctx.channel().id(), client);

		long seed = 0x7C98BDFA; // 3.0 English Packet Seed
		byte Bogus = (byte) (FIRST_PACKET.length + 7);

		first.writeByte(Bogus & 0xFF);
		first.writeByte(Bogus >> 8 & 0xFF);
		first.writeByte(0x7D);
		first.writeByte((byte) (seed & 0xFF));
		first.writeByte((byte) (seed >> 8 & 0xFF));
		first.writeByte((byte) (seed >> 16 & 0xFF));
		first.writeByte((byte) (seed >> 24 & 0xFF));
		first.writeBytes(FIRST_PACKET);
		ctx.writeAndFlush(first);

		try {
			client.set_clkey(LineageEncryption.initKeys(ctx.channel().id(), seed));
		} catch (ClientIdExistsException e) {
			e.printStackTrace();
		}
		System.out.println("done opening");
	}

	protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		System.out.println("readable " + in.readableBytes());
		int dataLength = 0;
		if (in.readableBytes() >= 2) {
			int hiByte = in.getByte(in.readerIndex()) & 0xff;
			int loByte = in.getByte(in.readerIndex() + 1) & 0xff;
			System.out.println("hi " + hiByte);
			System.out.println("lo " + loByte);
			dataLength = (loByte * 256 + hiByte) - 2;
		}
		System.out.println(dataLength);

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
