/*
*	The idea is simple.  Recreate the same condition that causes the 
*	MP Regen bug on live, which I've narrowed down to connection
*	errors hanging up the flush() in clientpackets, then causing
*	any method that calls that method (directly or indirectly)
*	to hang up as well.  For things like regen, it hangs the entire 
*	thread since its stuck on one sendpacket(). If the conditions are 
*	perfect it'll hang until the 11 minute default tcp timeout comes.
*	
*	This class creates two threads, one that recursively calls on
*	sendpacket for every char in game after placing that char's object
*	and a random number in a variable.
*
*	The second thread, on a slightly slower timer, checks that last 
*	player and last random variable.  If it hasn't changed since its
*	last check, the other thread must be held up, so it then forces
*	the affected socket to close.  
*
*	With this, the "mp bug" should only
*	be able to last a max of 5-10 seconds, which typically wont cause
*	any player deaths and may just feel like a lag spike to some players,
*	and cause a dc for one.
*
*	(The true fix would be to use non blocking i/o, but this should be a 
*	good enough bandaid until someone feels like doing that. This is probably
*	less complicated as well)
*
*	- Tricid
*/

package l1j.server.server.model;

import java.util.Random;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_GameTime;

public class MpBugTest {

	//Last player we attempted to communicate with
	private L1PcInstance _lastpc;
	//Last random number generated to go along with that player
	private int _lastrand;

	//Last player we've already checked and its associated random number
	private L1PcInstance _checkedpc;
	private int _checkedrand;
	
	private Random _random = new Random();
	
	private MpBugTestTimer _MpBugTestTimer;
	private MpBugCheckTimer _MpBugCheckTimer;
	public MpBugTest() {
	}

	//This is the thread that sends the test packets, waiting to lock up.
	private class MpBugTestTimer implements Runnable {
		
		public MpBugTestTimer() {
		}

		@Override
		public void run() {
			int time = 2000;
			for (;;) {
				try {
					Thread.sleep(time);
				} catch (Exception exception) {
					//_log.warning("MpBugTest error: " + exception);
					break;
				}
				sendTestPackets();
			}
		}
	}



	//This is the thread that checks for a lockup
	private class MpBugCheckTimer implements Runnable {
	
		public MpBugCheckTimer() {
		}

		@Override
		public void run() {
			int time = 5000;
			for (;;) {
				try {
					Thread.sleep(time);
					} catch (Exception exception) {
					//_log.warning("MpBugCheck error: " + exception);
					break;
				}
				checkLast();
			}
		}
	}

	//Called from GameServer to activate the threads
	public void initialize() {
		_MpBugCheckTimer = new MpBugCheckTimer();
		GeneralThreadPool.getInstance().execute(_MpBugCheckTimer);		
		_MpBugTestTimer = new MpBugTestTimer();
		GeneralThreadPool.getInstance().execute(_MpBugTestTimer); 
		System.out.println("* * * MP Bug Check Is Active * * *");
		
	}

	//Recursively send a packet to every player in game, hoping that the same network
	//error that causes the "mp bug" also locks the test thread above.
	public void sendTestPackets() {
		for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
			_lastpc = pc;
			//we use a random number here, because as the population is lower
			//the odds of the last player being the same as the last check increase.
			//The random number should make false positives VERY uncommon
			_lastrand = _random.nextInt(100000);
			pc.sendPackets(new S_GameTime());
		}
	}

	//If the last player communicated with, plus the last random number generated
	//are the same as the last time this check ran, then more than likely, there is
	//a lockup condition with the socket.  synchronized just in case the test thread
	//moves on in the middle of this check.
	public synchronized void checkLast() {
		if (_lastrand == 0 || _lastrand != _checkedrand) {
			_checkedrand = _lastrand;
			_checkedpc = _lastpc;
		} else if (L1World.getInstance().getAllPlayers().size() > 1 &&
				_checkedrand == _lastrand && _checkedpc == _lastpc) {			
			System.out.println("* * * MP BUG DETECTED	* * *");
			try {
				System.out.println("* * * Rescuing thread pool	* * *");
				_checkedpc.getNetConnection().rescue();
			} catch (Exception e) {
				System.out.println("* * * Rescue failed	* * *");
				System.out.println(e);
			}
			//try {
			//	System.out.println("* * * Interrupting client thread * * *");
			//	_checkedpc.getNetConnection().mpbug = true;
			//} catch (Exception e) { 
			//	System.out.println("* * * Failed to interrupt thread * * *");				
			//	System.out.println(e); 
			//}
			System.out.println("* * * Killed player " + _checkedpc.getName() + "	* * *");
		}
	}

}

