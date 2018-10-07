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

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import l1j.server.Config;

/*
 * (Tricid)  New network server using netty.  Rather than needing one thread per client we will now use a proper
 * nio library and a producer/consumer model.  On start up this results in a few more threads but in exchange requires no
 * thread per client.  So in theory 1 player or 1000 players the thread count stays the same and performance is better for it. 
 */
public class NetworkServer implements Runnable {

	Logger _log = LoggerFactory.getLogger(NetworkServer.class);
	private static final NetworkServer instance = new NetworkServer();
	private ArrayBlockingQueue<Client> clientQueue;
	private ArrayList<String> ips = new ArrayList<String>();

	private NetworkServer() {

	}

	public static NetworkServer getInstance() {
		return instance;
	}

	private ConcurrentHashMap<ChannelId, Client> clients = new ConcurrentHashMap<ChannelId, Client>();

	@Override
	public void run() {
		_log.info("Starting networking");
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
							// Only add the pipeline that sends the first packet
							// It'll add the other pipelines when it's ready
							ch.pipeline().addLast(new ChannelInit());

						}
					}).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);

			// Listen for connections
			ChannelFuture f = b.bind(Config.GAME_SERVER_PORT).sync();

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

	public synchronized ArrayList<String> getIps() {
		return ips;
	}

	public void setIps(ArrayList<String> ips) {
		this.ips = ips;
	}
}