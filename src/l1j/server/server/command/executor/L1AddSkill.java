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

import org.apache.log4j.Logger;

import l1j.server.server.datatables.SkillsTable;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_AddSkill;
import l1j.server.server.serverpackets.S_SkillSound;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Skills;

public class L1AddSkill implements L1CommandExecutor {
	private static Logger log = Logger.getLogger(L1AddSkill.class.getName());

	private L1AddSkill() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1AddSkill();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			int cnt = 0; 
			String skill_name = ""; 
			int skill_id = 0; 

			int object_id = pc.getId(); 
			pc.sendPackets(new S_SkillSound(object_id, '\343')); 
			pc.broadcastPacket(new S_SkillSound(object_id, '\343'));

			if (pc.isCrown()) {
				pc.sendPackets(new S_AddSkill(255, 255, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 255, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				for (cnt = 1; cnt <= 16; cnt++) 
				{
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(
							cnt); 
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id,
							skill_name, 0, 0); 
				}
				for (cnt = 113; cnt <= 120; cnt++) 
				{
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(
							cnt); 
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id,
							skill_name, 0, 0); 
				}
			} else if (pc.isKnight()) {
				pc.sendPackets(new S_AddSkill(255, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						192, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				for (cnt = 1; cnt <= 8; cnt++) 
				{
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(
							cnt); 
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id,
							skill_name, 0, 0); 
				}
				for (cnt = 87; cnt <= 91; cnt++) 
				{
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(
							cnt); 
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id,
							skill_name, 0, 0); 
				}
			} else if (pc.isElf()) {
				pc.sendPackets(new S_AddSkill(255, 255, 127, 255, 255, 255, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 127, 3, 255, 255, 255, 255,
						0, 0));
				for (cnt = 1; cnt <= 48; cnt++) 
				{
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(
							cnt); 
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id,
							skill_name, 0, 0); 
				}
				for (cnt = 129; cnt <= 176; cnt++) 
				{
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(
							cnt); 
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id,
							skill_name, 0, 0); 
				}
			} else if (pc.isWizard()) {
				pc.sendPackets(new S_AddSkill(255, 255, 127, 255, 255, 255,
						255, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0));
				for (cnt = 1; cnt <= 80; cnt++) 
				{
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(
							cnt); 
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id,
							skill_name, 0, 0); 
				}
			} else if (pc.isDarkelf()) {
				pc.sendPackets(new S_AddSkill(255, 255, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 255, 127, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				for (cnt = 1; cnt <= 16; cnt++) 
				{
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(
							cnt); 
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id,
							skill_name, 0, 0); 
				}
				for (cnt = 97; cnt <= 111; cnt++) 
				{
					L1Skills l1skills = SkillsTable.getInstance().getTemplate(
							cnt); 
					skill_name = l1skills.getName();
					skill_id = l1skills.getSkillId();
					SkillsTable.getInstance().spellMastery(object_id, skill_id,
							skill_name, 0, 0); 
				}
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(cmdName + " has failed."));
		}
	}
}
