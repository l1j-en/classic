package l1j.server.server.model;

import java.util.logging.Logger;

public class Packet {
	private static Logger _log = Logger.getLogger(Packet.class.getName());
	
	private int _opCode;
	private String _packet;
	private long _timestamp;
	
	public int getOpCode() {
		return _opCode;
	}
	
	public String getPacket() {
		return _packet;
	}
	
	public long getTimestamp() {
		return _timestamp;
	}
	
	public Packet(int opCode, String packet) {
		_opCode = opCode;
		_packet = packet;
		_timestamp = System.currentTimeMillis();
	}
	
	public Packet (String packet) {
		String[] packetInfo = packet.split(",");
		
		int opCode = -1;
		try {
			opCode = Integer.parseInt(packetInfo[0]);
		} catch(NumberFormatException ex) { 
			_log.warning("Error parsing opcode for packet log: " + packet);
		}
		
		_opCode = opCode;
		_packet = packet;
		_timestamp = System.currentTimeMillis();
	}
}
