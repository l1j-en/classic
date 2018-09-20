package l1j.server.server.network;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import l1j.server.server.PacketHandler;

public class NetworkServer implements Runnable {

	int port = 2000;
	private static final NetworkServer instance = new NetworkServer();
	private ArrayBlockingQueue<Client> clientQueue;
	private NetworkServer() {

        
	}

	public static NetworkServer getInstance() {
		return instance;
	}

	private ConcurrentHashMap<ChannelId, Client> clients = new ConcurrentHashMap<ChannelId, Client>();

	public void run() {
		System.out.println("Starting new network connection");
		setClientQueue(new ArrayBlockingQueue<Client>(1024));
		ExecutorService packetexecutor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new PacketConsumer("PacketConsumer" + i);
			packetexecutor.execute(worker);
		}
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch) throws Exception {
							// Takes input data and once a complete packet is formed
							// passes it along
							// takes complete packets from above and decrypts them
							ch.pipeline().addLast("decoder", new PacketDecoder());
							ch.pipeline().addLast(new PacketDecrypter());
							ch.pipeline().addLast(new ChannelInit());

						}
					}).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);

			// Listen for connections
			ChannelFuture f = b.bind(port).sync();

			// Halts here until server is closed
			f.channel().closeFuture().sync();
		} catch (Exception e) {
		} finally {

			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public ConcurrentHashMap<ChannelId, Client> getClients() {
		return clients;
	}

	public void setClients(ConcurrentHashMap<ChannelId, Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the clientQueue
	 */
	public ArrayBlockingQueue<Client> getClientQueue() {
		return clientQueue;
	}

	/**
	 * @param clientQueue the clientQueue to set
	 */
	public void setClientQueue(ArrayBlockingQueue<Client> clientQueue) {
		this.clientQueue = clientQueue;
	}
}