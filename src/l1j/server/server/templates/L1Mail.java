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

package l1j.server.server.templates;

public class L1Mail {
	public L1Mail() {
	}

	private int _id;

	public int getId() {
		return _id;
	}

	public void setId(int i) {
		_id = i;
	}

	private int _type;

	public int getType() {
		return _type;
	}

	public void setType(int i) {
		_type = i;
	}

	private String _senderName;

	public String getSenderName() {
		return _senderName;
	}

	public void setSenderName(String s) {
		_senderName = s;
	}

	private String _receiverName;

	public String getReceiverName() {
		return _receiverName;
	}

	public void setReceiverName(String s) {
		_receiverName = s;
	}

	private String _date = null; // yy/mm/dd

	public String getDate() {
		return _date;
	}

	public void setDate(String s) {
		_date = s;
	}

	private int _readStatus = 0;

	public int getReadStatus() {
		return _readStatus;
	}

	public void setReadStatus(int i) {
		_readStatus = i;
	}

	private byte[] _subject = null;

	public byte[] getSubject() {
		return _subject;
	}

	public void setSubject(byte[] arg) {
		_subject = arg;
	}

	private byte[] _content = null;

	public byte[] getContent() {
		return _content;
	}

	public void setContent(byte[] arg) {
		_content = arg;
	}

}
