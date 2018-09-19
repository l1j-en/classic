package l1j.server.server.network;
import java.io.IOException;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import l1j.server.server.encryptions.ClientIdExistsException;
import l1j.server.server.encryptions.LineageEncryption;
import l1j.server.server.encryptions.NoEncryptionKeysSelectedException;
import l1j.server.server.utils.ByteArrayUtil;

public class PacketDecrypter extends ChannelInboundHandlerAdapter {
	static int i = 0;
	private static final byte[] FIRST_PACKET = { // 3.0 English KeyPacket
	(byte) 0x41, (byte) 0x5A, (byte) 0x9B, (byte) 0x01, (byte) 0xB6,
			(byte) 0x81, (byte) 0x01, (byte) 0x09, (byte) 0xBD, (byte) 0xCC,
			(byte) 0xC0 };
	
	
	@Override
	public void channelActive(final ChannelHandlerContext ctx) {
		System.out.println("New Connection!");
		Client client = null;
		try {
			client = new Client(ctx.channel());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//client.channel = ctx.channel();
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
//	@Override
//	public void channelActive(final ChannelHandlerContext ctx) {
//		Client client = new Client();
//		client.channel = ctx.channel();
//		NetworkServer.getInstance().getClients().put(ctx.channel().id(), client);
//	}

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
		// System.out.println("returning");
		// System.out.println(LineageClient._clkey);
		// buf.discardReadBytes();
		if (i == 0) {
			i++;
			// System.out.println(data);
			client.getQueue().offer(data);
			//Client.process(data);

		} else {
			try {
				// System.out.println("encrypted packet: " + new
				// ByteArrayUtil(LineageEncryption.decrypt(data, dataLength,
				// LineageClient._clkey)).dumpToString());
				//Client.process(LineageEncryption.decrypt(data, data.length, Client._clkey));
				client.getQueue().offer(LineageEncryption.decrypt(data, data.length, client.get_clkey()));
			} catch (NoEncryptionKeysSelectedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// return LineageEncryption.decrypt(data, dataLength, _clkey);
		}

	}
}