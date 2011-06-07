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

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.utils.SQLUtil;

public class NpcTable {
	static Logger _log = Logger.getLogger(NpcTable.class.getName());

	private final boolean _initialized;

	private static NpcTable _instance;

	private final HashMap<Integer, L1Npc> _npcs = new HashMap<Integer, L1Npc>();
	private final HashMap<String, Constructor<?>> _constructorCache = new HashMap<String, Constructor<?>>();

	private static final Map<String, Integer> _familyTypes = NpcTable
			.buildFamily();

	public static NpcTable getInstance() {
		if (_instance == null) {
			_instance = new NpcTable();
		}
		return _instance;
	}

	public boolean isInitialized() {
		return _initialized;
	}

	private NpcTable() {
		loadNpcData();
		_initialized = true;
	}

	private Constructor<?> getConstructor(String implName) {
		try {
			String implFullName = "l1j.server.server.model.Instance."
					+ implName + "Instance";
			Constructor<?> con = Class.forName(implFullName).getConstructors()[0];
			return con;
		} catch (ClassNotFoundException e) {
			_log.log(Level.WARNING, e.getLocalizedMessage(), e);
		}
		return null;
	}

	private void registerConstructorCache(String implName) {
		if (implName.isEmpty() || _constructorCache.containsKey(implName)) {
			return;
		}
		_constructorCache.put(implName, getConstructor(implName));
	}

	private void loadNpcData() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM npc");
			rs = pstm.executeQuery();
			while (rs.next()) {
				L1Npc npc = new L1Npc();
				int npcId = rs.getInt("npcid");
				npc.set_npcId(npcId);
				npc.set_name(rs.getString("name"));
				npc.set_nameid(rs.getString("nameid"));
				npc.setImpl(rs.getString("impl"));
				npc.set_gfxid(rs.getInt("gfxid"));
				npc.set_level(rs.getInt("lvl"));
				npc.set_hp(rs.getInt("hp"));
				npc.set_mp(rs.getInt("mp"));
				npc.set_ac(rs.getInt("ac"));
				npc.set_str(rs.getByte("str"));
				npc.set_con(rs.getByte("con"));
				npc.set_dex(rs.getByte("dex"));
				npc.set_wis(rs.getByte("wis"));
				npc.set_int(rs.getByte("intel"));
				npc.set_mr(rs.getInt("mr"));
				npc.set_exp(rs.getInt("exp"));
				npc.set_lawful(rs.getInt("lawful"));
				npc.set_size(rs.getString("size"));
				npc.set_weakAttr(rs.getInt("weakAttr"));
				npc.set_ranged(rs.getInt("ranged"));
				npc.setTamable(rs.getBoolean("tamable"));
				npc.set_passispeed(rs.getInt("passispeed"));
				npc.set_atkspeed(rs.getInt("atkspeed"));
				npc.setAltAtkSpeed(rs.getInt("alt_atk_speed"));
				npc.setAtkMagicSpeed(rs.getInt("atk_magic_speed"));
				npc.setSubMagicSpeed(rs.getInt("sub_magic_speed"));
				npc.set_undead(rs.getInt("undead"));
				npc.set_poisonatk(rs.getInt("poison_atk"));
				npc.set_paralysisatk(rs.getInt("paralysis_atk"));
				npc.set_agro(rs.getBoolean("agro"));
				npc.set_agrososc(rs.getBoolean("agrososc"));
				npc.set_agrocoi(rs.getBoolean("agrocoi"));
				Integer family = _familyTypes.get(rs.getString("family"));
				if (family == null) {
					npc.set_family(0);
				} else {
					npc.set_family(family.intValue());
				}
				int agrofamily = rs.getInt("agrofamily");
				if (npc.get_family() == 0 && agrofamily == 1) {
					npc.set_agrofamily(0);
				} else {
					npc.set_agrofamily(agrofamily);
				}
				npc.set_agrogfxid1(rs.getInt("agrogfxid1"));
				npc.set_agrogfxid2(rs.getInt("agrogfxid2"));
				npc.set_picupitem(rs.getBoolean("picupitem"));
				npc.set_digestitem(rs.getInt("digestitem"));
				npc.set_bravespeed(rs.getBoolean("bravespeed"));
				npc.set_hprinterval(rs.getInt("hprinterval"));
				npc.set_hpr(rs.getInt("hpr"));
				npc.set_mprinterval(rs.getInt("mprinterval"));
				npc.set_mpr(rs.getInt("mpr"));
				npc.set_teleport(rs.getBoolean("teleport"));
				npc.set_randomlevel(rs.getInt("randomlevel"));
				npc.set_randomhp(rs.getInt("randomhp"));
				npc.set_randommp(rs.getInt("randommp"));
				npc.set_randomac(rs.getInt("randomac"));
				npc.set_randomexp(rs.getInt("randomexp"));
				npc.set_randomlawful(rs.getInt("randomlawful"));
				npc.set_damagereduction(rs.getInt("damage_reduction"));
				npc.set_hard(rs.getBoolean("hard"));
				npc.set_doppel(rs.getBoolean("doppel"));
				npc.set_IsTU(rs.getBoolean("IsTU"));
				npc.set_IsErase(rs.getBoolean("IsErase"));
				npc.setBowActId(rs.getInt("bowActId"));
				npc.setKarma(rs.getInt("karma"));
				npc.setTransformId(rs.getInt("transform_id"));
				npc.setTransformGfxId(rs.getInt("transform_gfxid"));
				npc.setLightSize(rs.getInt("light_size"));
				npc.setAmountFixed(rs.getBoolean("amount_fixed"));
				npc.setChangeHead(rs.getBoolean("change_head"));
				npc.setCantResurrect(rs.getBoolean("cant_resurrect"));

				registerConstructorCache(npc.getImpl());
				_npcs.put(npcId, npc);
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	public L1Npc getTemplate(int id) {
		return _npcs.get(id);
	}

	public L1NpcInstance newNpcInstance(int id) {
		L1Npc npcTemp = getTemplate(id);
		if (npcTemp == null) {
			throw new IllegalArgumentException(String.format(
					"NpcTemplate: %d not found", id));
		}
		return newNpcInstance(npcTemp);
	}

	public L1NpcInstance newNpcInstance(L1Npc template) {
		try {
			Constructor<?> con = _constructorCache.get(template.getImpl());
			return (L1NpcInstance) con.newInstance(new Object[] { template });
		} catch (Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		return null;
	}

	public static Map<String, Integer> buildFamily() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("select distinct(family) as family from npc WHERE NOT trim(family) =''");
			rs = pstm.executeQuery();
			int id = 1;
			while (rs.next()) {
				String family = rs.getString("family");
				result.put(family, id++);
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return result;
	}

	public int findNpcIdByName(String name) {
		for (L1Npc npc : _npcs.values()) {
			if (npc.get_name().equals(name)) {
				return npc.get_npcId();
			}
		}
		return 0;
	}

	public int findNpcIdByNameWithoutSpace(String name) {
		for (L1Npc npc : _npcs.values()) {
			if (npc.get_name().replace(" ", "").equals(name)) {
				return npc.get_npcId();
			}
		}
		return 0;
	}
}
