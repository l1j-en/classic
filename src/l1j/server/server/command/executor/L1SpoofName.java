package l1j.server.server.command.executor;

import static l1j.server.server.model.skill.L1SkillId.GMSTATUS_FINDINVIS;

import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.model.L1PolyMorph;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_OtherCharPacks;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.templates.L1Npc;

public class L1SpoofName implements L1CommandExecutor {
	private L1SpoofName() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1SpoofName();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
		try {
			if(arg.toLowerCase().equals("-revert")) {
				pc.setSpoofName(null);
				
				if(pc.getSpoofMob() != null) {
					if(!pc.isGmInvis()) {
						pc.broadcastPacket(new S_RemoveObject(pc.getSpoofMob()));
					}
					
					pc.setSpoofMob(null);
					L1PolyMorph.doPoly(pc, pc.getGfxId(), 0, L1PolyMorph.MORPH_BY_GM);
				}
				
				pc.sendPackets(new S_SystemMessage("Spoofing stopped"));
				L1Teleport.teleport(pc, pc.getX(), pc.getY(), pc.getMapId(), 5,
						false);
				
				if(!pc.isGmInvis()) {
					pc.broadcastPacket(new S_OtherCharPacks(pc, pc.hasSkillEffect(GMSTATUS_FINDINVIS)));
				}
				
				return;
			} else if(arg.toLowerCase().equals("-status")) {
				L1NpcInstance spoofedMob = pc.getSpoofMob();
				
				if(spoofedMob == null) {
					pc.sendPackets(new S_SystemMessage("You are not currently spoofing a mob!"));
				} else {
					pc.sendPackets(new S_SystemMessage(String.format("Currently spoofing %s (LvL %d)!",
							spoofedMob.getName(), spoofedMob.getLevel())));
				}
				
				return;
			}
			
			String[] args = arg.split(" ");
			
			if(args.length > 1) {
				boolean isMobArgument = args[0].toLowerCase().equals("-mob");
				
				if(!isMobArgument) {
					throw new Exception();
				}
				
				int mobId = -1;
				
				try{
					mobId = Integer.parseInt(args[1]);
				} catch(NumberFormatException nfe){
					pc.sendPackets(new S_SystemMessage("When spoofing a mob, you must use the template ID!"));
					pc.sendPackets(new S_SystemMessage("Use the .scan command to find the template ID of mobs around you!"));
					return;
				}
				
				L1Npc npcTemplate = NpcTable.getInstance().getTemplate(mobId);
				
				if(npcTemplate == null) {
					pc.sendPackets(new S_SystemMessage(
							String.format("Unable to find a mob with id %d!", mobId)));
					return;
				}
				
				L1MonsterInstance spoofMob = new L1MonsterInstance(npcTemplate);			
				pc.setSpoofMob(spoofMob);
				
				L1PolyMorph.doPoly(pc, spoofMob.getGfxId(), 7200, L1PolyMorph.MORPH_BY_GM);
				
				if(!pc.isGmInvis()) {
					pc.broadcastPacket(new S_RemoveObject(pc));
					pc.broadcastPacket(new S_OtherCharPacks(pc, pc.hasSkillEffect(GMSTATUS_FINDINVIS)));
				}
				
				pc.sendPackets(new S_SystemMessage(String.format("Now spoofing %s (LvL %d)!",
						spoofMob.getName(),
						spoofMob.getLevel())));
			} else {
				if(arg.contains("-")) {
					throw new Exception();
				}
				
				L1PcInstance playerToSpoof = L1World.getInstance().getPlayer(arg);
				
				if(playerToSpoof == null) {
					playerToSpoof = CharacterTable.getInstance().restoreCharacter(arg);
				}
				
				if(playerToSpoof == null ||
						playerToSpoof.getAccessLevel().getLevel() < pc.getAccessLevel().getLevel()) {
					pc.setSpoofName(arg);
					
					L1Teleport.teleport(pc, pc.getX(), pc.getY(), pc.getMapId(), 5,
							false);
				} else {
					pc.sendPackets(new S_SystemMessage("You cannot spoof someone with a higher access level than yourself!"));
				}
			}
		} catch (Exception e) {
			pc.sendPackets(new S_SystemMessage(".spoof [-revert|-status|-mob] [name/npcid]"));
		}
	}
}
