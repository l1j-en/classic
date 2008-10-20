package l1j.server.server.model; 
 
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger; 

import l1j.server.server.model.Instance.L1PcInstance; 
import l1j.server.server.model.skill.L1SkillId;  
import l1j.server.server.serverpackets.S_SkillSound; 
 
public class HpRegenerationByDoll extends TimerTask { 
    private static Logger _log = Logger.getLogger(HpRegenerationByDoll.class  
            .getName());
 
    private final L1PcInstance _pc; 
 
    public HpRegenerationByDoll(L1PcInstance pc) {  
        _pc = pc; 
    }  
 
    @Override 
    public void run() {  
        try { 
            if (_pc.isDead()) {  
                return;   
            }
            regenHp();  
        } catch (Throwable e) {  
            _log.log(Level.WARNING, e.getLocalizedMessage(), e);  
        }  
    }   

    public void regenHp() {
        int mpr = 40; 
        if (_pc.get_food() < 3 || isOverWeight(_pc)) {
            mpr = 0; 
        } 
        int newHp = _pc.getCurrentHp() + mpr;
        if (newHp < 0) {
            newHp = 0; 
        }

        _pc.sendPackets(new S_SkillSound(_pc.getId(), 6506));
        _pc.broadcastPacket(new S_SkillSound(_pc.getId(), 6506));
        _pc.setCurrentHp(newHp);
    }

    private boolean isOverWeight(L1PcInstance pc) {

        if (pc.hasSkillEffect(L1SkillId.EXOTIC_VITALIZE)  
                || pc.hasSkillEffect(L1SkillId.ADDITIONAL_FIRE)) { 
            return false; 
        } 

        return (14 < pc.getInventory().getWeight30()) ? true : false;
    } 
}   
