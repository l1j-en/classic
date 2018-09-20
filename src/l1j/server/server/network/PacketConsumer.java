package l1j.server.server.network;

/*
 * This thread just processes any received packets that it pulls from the queue.
 * I separated it to make sure none of this processing could hang the actual sending
 * and receiving of packets.  I might later on decide that this would be better served
 * by a thread pool even, instead of just one thread.
 */
public class PacketConsumer implements Runnable {

	String name;

	public PacketConsumer(String name) {

		// all threads deserve names!
		this.name = name;

	}

	/*
	 * Infinite loop. It will try to take a packet from the queue, then do whatever
	 * work is needed, then try to grab another. If there are no packets to take it
	 * will wait until something is available, so no wasted CPU cycles when there is
	 * nothing to do.
	 */
	@Override
	public final void run() {

		Thread.currentThread().setName(name);

		while (true) {
			// logger.info(name + " is running.");
			Client client = null;

			try {
				client = NetworkServer.getInstance().getClientQueue().take();
				System.out.println("Consuming");
				client.run();
				System.out.println("Consumed");

			} catch (Exception e) {
				// logger.error("", e);
			}
		}

	}

}
