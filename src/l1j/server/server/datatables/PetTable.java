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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.templates.L1Pet;
import l1j.server.server.templates.L1PetType;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server:
// IdFactory
public class PetTable {
	private static Logger _log = Logger.getLogger(PetTable.class.getName());
	private static PetTable _instance;
	private final HashMap<Integer, L1Pet> _pets = new HashMap<Integer, L1Pet>();
	private static Random _random = new Random();
	
	public static PetTable getInstance() {
		if (_instance == null) {
			_instance = new PetTable();
		}
		return _instance;
	}

	private PetTable() {
		load();
	}

	private void load() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM pets");
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1Pet pet = new L1Pet();
				int itemobjid = rs.getInt(1);
				pet.set_itemobjid(itemobjid);
				pet.set_objid(rs.getInt(2));
				pet.set_npcid(rs.getInt(3));
				pet.set_name(rs.getString(4));
				pet.set_level(rs.getInt(5));
				pet.set_hp(rs.getInt(6));
				pet.set_mp(rs.getInt(7));
				pet.set_exp(rs.getInt(8));
				pet.set_lawful(rs.getInt(9));
				pet.set_weapon(rs.getInt(10));
				pet.set_armor(rs.getInt(11));
				_pets.put(new Integer(itemobjid), pet);
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void storeNewPet(L1NpcInstance pet, int objid, int itemobjid) {
		L1Pet l1pet = new L1Pet();
		l1pet.set_itemobjid(itemobjid);
		l1pet.set_objid(objid);
		l1pet.set_npcid(pet.getNpcTemplate().get_npcId());
		l1pet.set_name(pet.getNpcTemplate().get_name());
		l1pet.set_level(pet.getNpcTemplate().get_level());
		l1pet.set_hp(pet.getMaxHp());
		l1pet.set_mp(pet.getMaxMp());
		l1pet.set_exp(750); // Lv.5 EXP
		l1pet.set_lawful(0);
		_pets.put(new Integer(itemobjid), l1pet);
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("INSERT INTO pets SET item_obj_id=?,objid=?,npcid=?,name=?,lvl=?,hp=?,mp=?,exp=?,lawful=?");
			pstm.setInt(1, l1pet.get_itemobjid());
			pstm.setInt(2, l1pet.get_objid());
			pstm.setInt(3, l1pet.get_npcid());
			pstm.setString(4, l1pet.get_name());
			pstm.setInt(5, l1pet.get_level());
			pstm.setInt(6, l1pet.get_hp());
			pstm.setInt(7, l1pet.get_mp());
			pstm.setInt(8, l1pet.get_exp());
			pstm.setInt(9, l1pet.get_lawful());
			pstm.execute();
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);

		}
	}

	public void storePet(L1Pet pet) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("UPDATE pets SET objid=?,npcid=?,name=?,lvl=?,hp=?,mp=?,exp=?,lawful=?,weapon=?,armor=? WHERE item_obj_id=?");
			pstm.setInt(1, pet.get_objid());
			pstm.setInt(2, pet.get_npcid());
			pstm.setString(3, pet.get_name());
			pstm.setInt(4, pet.get_level());
			pstm.setInt(5, pet.get_hp());
			pstm.setInt(6, pet.get_mp());
			pstm.setInt(7, pet.get_exp());
			pstm.setInt(8, pet.get_lawful());
			pstm.setInt(9, pet.get_weapon());
			pstm.setInt(10, pet.get_armor());
			pstm.setInt(11, pet.get_itemobjid());
			pstm.execute();
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public void deletePet(int itemobjid) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("DELETE FROM pets WHERE item_obj_id=?");
			pstm.setInt(1, itemobjid);
			pstm.execute();
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		_pets.remove(itemobjid);
	}

	/**
	 * Pets able name already exists or is returned.
	 * 
	 * @param nameCaseInsensitive
	 *            Check your pet's name. Case differences are ignored.
	 * @return If the name already exists true
	 */
	public static boolean isNameExists(String nameCaseInsensitive) {
		String nameLower = nameCaseInsensitive.toLowerCase();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT item_obj_id FROM pets WHERE LOWER(name)=?");
			pstm.setString(1, nameLower);
			rs = pstm.executeQuery();
			if (!rs.next()) { // Do not have the same name
				return false;
			}
			if (PetTypeTable.getInstance().isNameDefault(nameLower)) { // The default name is not regarded as duplicate
				return false;
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return true;
	}
public void buyNewPet(int petNpcId, int objid, int itemobjid, int upLv,
			int lvExp) {
		L1PetType petType = PetTypeTable.getInstance().get(petNpcId);
		L1Pet l1pet = new L1Pet();
		l1pet.set_itemobjid(itemobjid);
		l1pet.set_objid(objid);
		l1pet.set_npcid(petNpcId);
		l1pet.set_name(petType.getName());
		l1pet.set_level(upLv);
		int hpUpMin = petType.getHpUpRange().getLow();
		int hpUpMax = petType.getHpUpRange().getHigh();
		int mpUpMin = petType.getMpUpRange().getLow();
		int mpUpMax = petType.getMpUpRange().getHigh();
		short randomhp = (short) ((hpUpMin + hpUpMax) / 2);
		short randommp = (short) ((mpUpMin + mpUpMax) / 2);
		for (int i = 1; i < upLv; i++) {
			randomhp += (_random.nextInt(hpUpMax - hpUpMin) + hpUpMin + 1);
			randommp += (_random.nextInt(mpUpMax - mpUpMin) + mpUpMin + 1);
		}
		l1pet.set_hp(randomhp);
		l1pet.set_mp(randommp);
		l1pet.set_exp(lvExp); // upLv EXP
		l1pet.set_lawful(0);
		//l1pet.set_food(50);
		_pets.put(new Integer(itemobjid), l1pet);
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("INSERT INTO pets SET item_obj_id=?,objid=?," +
					"npcid=?,name=?,lvl=?,hp=?,mp=?,exp=?,lawful=?,food=?");
			pstm.setInt(1, l1pet.get_itemobjid());
			pstm.setInt(2, l1pet.get_objid());
			pstm.setInt(3, l1pet.get_npcid());
			pstm.setString(4, l1pet.get_name());
			pstm.setInt(5, l1pet.get_level());
			pstm.setInt(6, l1pet.get_hp());
			pstm.setInt(7, l1pet.get_mp());
			pstm.setInt(8, l1pet.get_exp());
			pstm.setInt(9, l1pet.get_lawful());
			//pstm.setInt(10, l1pet.get_food());
			pstm.execute();
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);

		}
	}
	public L1Pet getTemplate(int itemobjid) {
		return _pets.get(new Integer(itemobjid));
	}

	public L1Pet[] getPetTableList() {
		return _pets.values().toArray(new L1Pet[_pets.size()]);
	}
}
