package l1j.server.server.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Packet {
	private static Logger _log = LoggerFactory.getLogger(Packet.class.getName());
	
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
			_log.warn("Error parsing opcode for packet log: " + packet);
		}
		
		_opCode = opCode;
		_packet = packet;
		_timestamp = System.currentTimeMillis();
	}
}
