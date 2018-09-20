package l1j.server.server.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import l1j.server.server.encryptions.LineageEncryption;
import l1j.server.server.encryptions.NoEncryptionKeysSelectedException;

public class PacketDecrypter extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		readPacket((byte[]) msg, ctx);
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
		Client client = NetworkServer.getInstance().getClients().get(ctx.channel().id());

		try {
			byte[] decrypted = LineageEncryption.decrypt(data, data.length, client.get_clkey());
			client.getQueue().offer(decrypted);
			NetworkServer.getInstance().getClientQueue().offer(client);
		} catch (NoEncryptionKeysSelectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}