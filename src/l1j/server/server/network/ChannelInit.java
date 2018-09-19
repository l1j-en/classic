package l1j.server.server.network;

import java.io.IOException;

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
		channel.pipeline().addLast(new PacketDecrypter(), new PacketDecoder());

	}

	@Override
	public void channelActive(final ChannelHandlerContext ctx) {
		System.out.println("New Connection2!");
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
		ctx.write(Bogus & 0xFF);
		ctx.write(Bogus >> 8 & 0xFF);

		ctx.write(0x7D); // 3.0 English Version Check.
		ctx.write((byte) (seed & 0xFF));
		ctx.write((byte) (seed >> 8 & 0xFF));
		ctx.write((byte) (seed >> 16 & 0xFF));
		ctx.write((byte) (seed >> 24 & 0xFF));
		ctx.write(FIRST_PACKET);
		ctx.flush();

		try {
			client.set_clkey(LineageEncryption.initKeys(ctx.channel().id(), seed));
		} catch (ClientIdExistsException e) {
		}
	}
}
