package l1j.server.server.network;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import l1j.server.server.encryptions.ClientIdExistsException;
import l1j.server.server.encryptions.LineageEncryption;

public class ChannelInit extends ChannelInitializer<Channel> {

	private static final byte[] FIRST_PACKET = { // 3.0 English KeyPacket
			(byte) 0x41, (byte) 0x5A, (byte) 0x9B, (byte) 0x01, (byte) 0xB6, (byte) 0x81, (byte) 0x01, (byte) 0x09,
			(byte) 0xBD, (byte) 0xCC, (byte) 0xC0 };

	@Override
	protected void initChannel(Channel channel) throws Exception {
		final ByteBuf first = channel.alloc().buffer(FIRST_PACKET.length + 7);
		Client client = null;
		try {
			client = new Client(channel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NetworkServer.getInstance().getClients().put(channel.id(), client);

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
		channel.writeAndFlush(first);

		try {
			client.set_clkey(LineageEncryption.initKeys(channel.id(), seed));
		} catch (ClientIdExistsException e) {
			e.printStackTrace();
		}
		channel.pipeline().addLast(new PacketDecrypter(), new PacketDecoder());

	}

	@Override
	public void channelActive(final ChannelHandlerContext channel) {

	}
}
