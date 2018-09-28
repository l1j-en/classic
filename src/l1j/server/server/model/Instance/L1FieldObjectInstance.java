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
package l1j.server.server.model.Instance;

import static l1j.server.server.model.skill.L1SkillId.CANCELLATION;

import l1j.server.server.datatables.ItemTable;
import l1j.server.server.model.L1HauntedHouse;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.ServerBasePacket;
import l1j.server.server.templates.L1Npc;

public class L1FieldObjectInstance extends L1NpcInstance {

	private static final long serialVersionUID = 1L;

	public L1FieldObjectInstance(L1Npc template) {
		super(template);
	}

	@Override
	public void onAction(L1PcInstance pc) {
		if (getNpcTemplate().get_npcId() != 81171)
			return;

		L1HauntedHouse house = L1HauntedHouse.getInstance();
		if (house.getHauntedHouseStatus() != L1HauntedHouse.STATUS_PLAYING)
			return;

		int winnersCount = house.getWinnersCount();
		int goalCount = house.getGoalCount();
		if (winnersCount == goalCount + 1) {
			L1ItemInstance item = ItemTable.getInstance().createItem(49280);
			item.setCount(1);
			checkAddNotify(pc, item);
			house.endHauntedHouse();
		} else if (winnersCount > goalCount + 1) {
			house.setGoalCount(goalCount + 1);
			// TODO something is happening that is not teleporting winners out of the
			// HH when they win when there can be multiple winners.
			// Commented out this line to ensure they get removed at least when the game ends
			//house.removeMember(pc);
			L1ItemInstance item = null;
			if (winnersCount == 3) {
				if (goalCount == 1) {
					item = ItemTable.getInstance().createItem(49278);
				} else if (goalCount == 2) {
					item = ItemTable.getInstance().createItem(49279);
				}
			} else if (winnersCount == 2) {
				item = ItemTable.getInstance().createItem(49279);
			}
			item.setCount(1);
			checkAddNotify(pc, item);
			L1SkillUse l1skilluse = new L1SkillUse();
			l1skilluse.handleCommands(pc, CANCELLATION, pc.getId(), pc.getX(),
					pc.getY(), null, 0, L1SkillUse.TYPE_LOGIN);
			L1Teleport.teleport(pc, 32624, 32813, (short) 4, 5, true);
		}
	}

	private static void checkAddNotify(final L1PcInstance player,
			final L1ItemInstance item) {
		if (player.getInventory().checkAddItem(item, item.getCount()) != L1Inventory.OK)
			return;
		player.getInventory().storeItem(item);
		player.sendPackets(new S_ServerMessage(403, item.getLogName()));
	}

	@Override
	public void deleteMe() {
		_destroyed = true;
		if (getInventory() != null) {
			getInventory().clearItems();
		}
		L1World.getInstance().removeVisibleObject(this);
		L1World.getInstance().removeObject(this);
		ServerBasePacket removeMe = new S_RemoveObject(this);
		for (L1PcInstance pc : L1World.getInstance().getRecognizePlayer(this)) {
			pc.removeKnownObject(this);
			pc.sendPackets(removeMe);
		}
		removeAllKnownObjects();
	}
}
