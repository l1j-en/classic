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
package l1j.server.server.serverpackets;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.encryptions.Opcodes;

public class S_CustomBoardRead extends ServerBasePacket {
	private static final String S_CustomBoardRead = "[C] S_CustomBoardRead";
	private static Logger _log = LoggerFactory.getLogger(S_BoardRead.class.getName());
	private byte[] _byte = null;
	
	public S_CustomBoardRead(String title, String name, String content) {
		buildPacket(title, name, content);
	}
	
	private void buildPacket(String title, String name, String content) {	
		try {
			
				writeC(Opcodes.S_OPCODE_BOARDREAD);
				writeD(0);
				writeS(name);
				writeS(title);
				writeS(getCurrentTimeStamp());
				writeS(content);
		} catch (Exception e) {
			_log.error(e.getLocalizedMessage(), e);
		} 
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}

	@Override
	public String getType() {
		return S_CustomBoardRead;
	}
	
	private static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yy/MM/dd");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
}