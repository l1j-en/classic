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
package l1j.server.server.command.executor;

import static l1j.server.server.model.skill.L1SkillId.ABSOLUTE_BARRIER;
import static l1j.server.server.model.skill.L1SkillId.ADVANCE_SPIRIT;
import static l1j.server.server.model.skill.L1SkillId.AWAKEN_ANTHARAS;
import static l1j.server.server.model.skill.L1SkillId.AWAKEN_FAFURION;
import static l1j.server.server.model.skill.L1SkillId.AWAKEN_VALAKAS;
import static l1j.server.server.model.skill.L1SkillId.BLESSED_ARMOR;
import static l1j.server.server.model.skill.L1SkillId.BONE_BREAK;
import static l1j.server.server.model.skill.L1SkillId.CANCELLATION;
import static l1j.server.server.model.skill.L1SkillId.CONFUSION;
import static l1j.server.server.model.skill.L1SkillId.COOKING_BEGIN;
import static l1j.server.server.model.skill.L1SkillId.COOKING_END;
import static l1j.server.server.model.skill.L1SkillId.COUNTER_BARRIER;
import static l1j.server.server.model.skill.L1SkillId.ENCHANT_WEAPON;
import static l1j.server.server.model.skill.L1SkillId.MASS_SHOCK_STUN;
import static l1j.server.server.model.skill.L1SkillId.REDUCTION_ARMOR;
import static l1j.server.server.model.skill.L1SkillId.SHADOW_FANG;
import static l1j.server.server.model.skill.L1SkillId.SHOCK_STUN;
import static l1j.server.server.model.skill.L1SkillId.SKILLS_BEGIN;
import static l1j.server.server.model.skill.L1SkillId.SKILLS_END;
import static l1j.server.server.model.skill.L1SkillId.SOLID_CARRIAGE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_BEGIN;
import static l1j.server.server.model.skill.L1SkillId.STATUS_END;
import static l1j.server.server.model.skill.L1SkillId.STATUS_FREEZE;
import l1j.server.server.datatables.SkillTable;
import l1j.server.server.model.L1PolyMorph;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_CharVisualUpdate;
import l1j.server.server.serverpackets.S_SkillHaste;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Skill;
import l1j.server.server.utils.collections.IntArrays;

public class L1Cancel implements L1CommandExecutor {
	private static final int[] UNCANCELABLE = { ENCHANT_WEAPON, BLESSED_ARMOR,
		ABSOLUTE_BARRIER, ADVANCE_SPIRIT, SHOCK_STUN, SHADOW_FANG,
		REDUCTION_ARMOR, SOLID_CARRIAGE, COUNTER_BARRIER, AWAKEN_ANTHARAS,
		AWAKEN_FAFURION, AWAKEN_VALAKAS, BONE_BREAK, MASS_SHOCK_STUN,
		CONFUSION };
	
	private L1Cancel() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Cancel();
	}
	
	@Override
	public void execute(L1PcInstance pc, String cmdName, String char_name) {
		try {
			L1PcInstance target = L1World.getInstance().getPlayer(char_name);
			
			if(target == null) {
				pc.sendPackets(new S_SystemMessage(
						String.format("Player '%1$s' is not online!", char_name)));
				return;
			}
			
			this.cancelPlayer(target);
			
			pc.sendPackets(new S_SystemMessage(
					String.format("Player '%1$s' has been cancelled!", char_name)));
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(
					String.format(".%1$s <player_name>", cmdName)));
		}
	}
	
	private void cancelPlayer(L1PcInstance player) throws Exception {
		if(player == null) {
			throw new Exception();
		}
		
		if (player.isInvisble()) {
			player.delInvis();
		}
		
		for (int skillNum = SKILLS_BEGIN; skillNum <= SKILLS_END; skillNum++) {
			// if it isn't a cancellable skill, we need to send the packet manually to the client
			if(IntArrays.sContains(UNCANCELABLE, skillNum)) {
				player.killSkillEffectTimer(skillNum);
			}

			player.removeSkillEffect(skillNum);
		}

		player.curePoison();
		player.cureParalaysis();
		for (int skillNum = STATUS_BEGIN; skillNum <= STATUS_END; skillNum++) {
			player.removeSkillEffect(skillNum);
		}

		for (int skillNum = COOKING_BEGIN; skillNum <= COOKING_END; skillNum++) {
			player.removeSkillEffect(skillNum);
		}

		L1PolyMorph.undoPoly(player);
		player.sendPackets(new S_CharVisualUpdate(player));
		player.broadcastPacket(new S_CharVisualUpdate(player));

		if (player.getHasteItemEquipped() > 0) {
			player.setMoveSpeed(0);
			player.sendPackets(new S_SkillHaste(player.getId(), 0, 0));
			player.broadcastPacket(new S_SkillHaste(player.getId(), 0, 0));
		}
		
		player.removeSkillEffect(STATUS_FREEZE);
		player.sendPackets(new S_CharVisualUpdate(player));
		player.broadcastPacket(new S_CharVisualUpdate(player));
		
		L1Skill skill = SkillTable.getInstance().findBySkillId(CANCELLATION);
		
		player.sendPackets(new S_SkillSound(player.getId(), skill.getCastGfx()));
		player.broadcastPacket(new S_SkillSound(player.getId(), skill.getCastGfx()));
	}
}
