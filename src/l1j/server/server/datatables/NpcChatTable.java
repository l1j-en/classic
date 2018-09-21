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
package l1j.server.server.datatables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.templates.L1NpcChat;
import l1j.server.server.utils.SQLUtil;

public class NpcChatTable {
	private final static Logger _log = LoggerFactory.getLogger(NpcChatTable.class
			.getName());
	private static NpcChatTable _instance;
	private final Map<Integer, L1NpcChat> _npcChatAppearance = new HashMap<Integer, L1NpcChat>();
	private final Map<Integer, L1NpcChat> _npcChatDead = new HashMap<Integer, L1NpcChat>();
	private final Map<Integer, L1NpcChat> _npcChatHide = new HashMap<Integer, L1NpcChat>();
	private final Map<Integer, L1NpcChat> _npcChatGameTime = new HashMap<Integer, L1NpcChat>();

	public static NpcChatTable getInstance() {
		if (_instance == null) {
			_instance = new NpcChatTable();
		}
		return _instance;
	}

	private NpcChatTable() {
		FillNpcChatTable();
	}

	private void FillNpcChatTable() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM npcchat");
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1NpcChat npcChat = new L1NpcChat();
				npcChat.setNpcId(rs.getInt("npc_id"));
				npcChat.setChatTiming(rs.getInt("chat_timing"));
				npcChat.setStartDelayTime(rs.getInt("start_delay_time"));
				npcChat.setChatId1(rs.getString("chat_id1"));
				npcChat.setChatId2(rs.getString("chat_id2"));
				npcChat.setChatId3(rs.getString("chat_id3"));
				npcChat.setChatId4(rs.getString("chat_id4"));
				npcChat.setChatId5(rs.getString("chat_id5"));
				npcChat.setChatInterval(rs.getInt("chat_interval"));
				npcChat.setShout(rs.getBoolean("is_shout"));
				npcChat.setWorldChat(rs.getBoolean("is_world_chat"));
				npcChat.setRepeat(rs.getBoolean("is_repeat"));
				npcChat.setRepeatInterval(rs.getInt("repeat_interval"));
				npcChat.setGameTime(rs.getInt("game_time"));
				Integer npcId = Integer.valueOf(npcChat.getNpcId());
				switch (npcChat.getChatTiming()) {
				case L1NpcInstance.CHAT_TIMING_APPEARANCE:
					_npcChatAppearance.put(npcId, npcChat);
					break;
				case L1NpcInstance.CHAT_TIMING_DEAD:
					_npcChatDead.put(npcId, npcChat);
					break;
				case L1NpcInstance.CHAT_TIMING_HIDE:
					_npcChatHide.put(npcId, npcChat);
					break;
				case L1NpcInstance.CHAT_TIMING_GAME_TIME:
					_npcChatGameTime.put(npcId, npcChat);
					break;
				default:
				}
			}
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public L1NpcChat getTemplateAppearance(int i) {
		return _npcChatAppearance.get(Integer.valueOf(i));
	}

	public L1NpcChat getTemplateDead(int i) {
		return _npcChatDead.get(Integer.valueOf(i));
	}

	public L1NpcChat getTemplateHide(int i) {
		return _npcChatHide.get(Integer.valueOf(i));
	}

	public L1NpcChat getTemplateGameTime(int i) {
		return _npcChatGameTime.get(Integer.valueOf(i));
	}

	public L1NpcChat[] getAllGameTime() {
		return _npcChatGameTime.values().toArray(
				new L1NpcChat[_npcChatGameTime.size()]);
	}
}
