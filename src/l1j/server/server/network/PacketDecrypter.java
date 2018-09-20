package l1j.server.server.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import l1j.server.server.encryptions.LineageEncryption;
import l1j.server.server.encryptions.NoEncryptionKeysSelectedException;
import l1j.server.server.utils.ByteArrayUtil;

public class PacketDecrypter extends ChannelInboundHandlerAdapter {
	static int i = 0;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		// System.out.println(msg);
		System.out.println("Start read");
		readPacket((byte[]) msg, ctx);
		// m.release();

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) {
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) {

	}

	public void readPacket(byte[] data, ChannelHandlerContext ctx) {
		System.out.println("First readable: " + data.length);
		System.out.println("og packet: " + new ByteArrayUtil(data).dumpToString());
		Client client = NetworkServer.getInstance().getClients().get(ctx.channel().id());

		try {
			byte[] decrypted = LineageEncryption.decrypt(data, data.length, client.get_clkey());
			System.out.println("encrypted packet: " + new ByteArrayUtil(decrypted).dumpToString());
			client.getQueue().offer(decrypted);
			NetworkServer.getInstance().getClientQueue().offer(client);
		} catch (NoEncryptionKeysSelectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}