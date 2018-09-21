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
package l1j.server.server.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_NpcChatPacket;
import l1j.server.server.templates.L1NpcChat;

public class L1NpcChatTimer implements Runnable {
	private static final Logger _log = LoggerFactory.getLogger(L1NpcChatTimer.class
			.getName());
	private final L1NpcInstance _npc;
	private final int chatTiming;
	private final int chatInterval;
	private final boolean isShout;
	private final boolean isWorldChat;
	private final String[] chatIds;

	public L1NpcChatTimer(L1NpcInstance npc, L1NpcChat chat) {
		_npc = npc;
		chatTiming = chat.getChatTiming();
		chatInterval = chat.getChatInterval();
		isShout = chat.isShout();
		isWorldChat = chat.isWorldChat();
		chatIds = new String[] { chat.getChatId1(), chat.getChatId2(),
				chat.getChatId3(), chat.getChatId4(), chat.getChatId5(), };
	}

	@Override
	public void run() {
		try {
			if (_npc == null
					|| _npc._destroyed
					|| _npc.getHiddenStatus() != L1NpcInstance.HIDDEN_STATUS_NONE) {
				return;
			}

			for (int i = 0; i < chatIds.length; i++) {
				if (!chatIds[i].equals("")) {
					if (i != 0)
						Thread.sleep(chatInterval);
					chat(_npc, chatTiming, chatIds[i], isShout, isWorldChat);
				}
			}
		} catch (Throwable e) {
			_log.warn(e.getLocalizedMessage(), e);
		}
	}

	private void chat(L1NpcInstance npc, int chatTiming, String chatId,
			boolean isShout, boolean isWorldChat) {
		if (npc.isDead()
				&& (chatTiming == L1NpcInstance.CHAT_TIMING_APPEARANCE || chatTiming == L1NpcInstance.CHAT_TIMING_HIDE)) {
			return;
		}
		if (chatTiming == L1NpcInstance.CHAT_TIMING_DEAD && !npc.isDead()) {
			return;
		}

		if (!isShout) {
			npc.broadcastPacket(new S_NpcChatPacket(npc, chatId, 0));
		} else {
			npc.wideBroadcastPacket(new S_NpcChatPacket(npc, chatId, 2));
		}

		if (isWorldChat) {
			for (L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
				if (pc != null) {
					pc.sendPackets(new S_NpcChatPacket(npc, chatId, 3));
				}
				break;
			}
		}
	}
}
