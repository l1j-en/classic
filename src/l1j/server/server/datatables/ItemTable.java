package l1j.server.server.datatables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.templates.L1Armor;
import l1j.server.server.templates.L1EtcItem;
import l1j.server.server.templates.L1Item;
import l1j.server.server.templates.L1Weapon;
import l1j.server.server.utils.SQLUtil;
import l1j.server.server.utils.collections.Maps;

public class ItemTable {
	private static final long serialVersionUID = 1L;
	private static Logger _log = Logger.getLogger(ItemTable.class.getName());
	private static final Map<String, Integer> _armorTypes = Maps.newHashMap();
	private static final Map<String, Integer> _weaponTypes = Maps.newHashMap();
	private static final Map<String, Integer> _weaponId = Maps.newHashMap();
	private static final Map<String, Integer> _materialTypes = Maps
			.newHashMap();
	private static final Map<String, Integer> _etcItemTypes = Maps.newHashMap();
	private static final Map<String, Integer> _useTypes = Maps.newHashMap();
	private static ItemTable _instance;
	private L1Item _allTemplates[];
	private final Map<Integer, L1EtcItem> _etcitems;
	private final Map<Integer, L1Armor> _armors;
	private final Map<Integer, L1Weapon> _weapons;

	static {
		_etcItemTypes.put("arrow", Integer.valueOf(0));
		_etcItemTypes.put("wand", Integer.valueOf(1));
		_etcItemTypes.put("light", Integer.valueOf(2));
		_etcItemTypes.put("gem", Integer.valueOf(3));
		_etcItemTypes.put("totem", Integer.valueOf(4));
		_etcItemTypes.put("firecracker", Integer.valueOf(5));
		_etcItemTypes.put("potion", Integer.valueOf(6));
		_etcItemTypes.put("food", Integer.valueOf(7));
		_etcItemTypes.put("scroll", Integer.valueOf(8));
		_etcItemTypes.put("questitem", Integer.valueOf(9));
		_etcItemTypes.put("spellbook", Integer.valueOf(10));
		_etcItemTypes.put("petitem", Integer.valueOf(11));
		_etcItemTypes.put("other", Integer.valueOf(12));
		_etcItemTypes.put("material", Integer.valueOf(13));
		_etcItemTypes.put("event", Integer.valueOf(14));
		_etcItemTypes.put("sting", Integer.valueOf(15));
		_etcItemTypes.put("treasure_box", Integer.valueOf(16));

		_useTypes.put("none", Integer.valueOf(-1)); // Unavailable
		_useTypes.put("normal", Integer.valueOf(0));
		_useTypes.put("weapon", Integer.valueOf(1));
		_useTypes.put("armor", Integer.valueOf(2));
		// _useTypes.put("wand1", Integer.valueOf(3));
		// _useTypes.put("wand", Integer.valueOf(4));
		// Wand to wave to take action(C_RequestExtraCommand Is sent)
		_useTypes.put("spell_long", Integer.valueOf(5)); // The ground / object
															// selection
															// (long-distance)
		_useTypes.put("ntele", Integer.valueOf(6));
		_useTypes.put("identify", Integer.valueOf(7));
		_useTypes.put("res", Integer.valueOf(8));
		_useTypes.put("letter", Integer.valueOf(12));
		_useTypes.put("letter_w", Integer.valueOf(13));
		_useTypes.put("choice", Integer.valueOf(14));
		_useTypes.put("instrument", Integer.valueOf(15));
		_useTypes.put("sosc", Integer.valueOf(16));
		_useTypes.put("spell_short", Integer.valueOf(17)); // The ground /
															// object selection
															// (short-range)
		_useTypes.put("T", Integer.valueOf(18));
		_useTypes.put("cloak", Integer.valueOf(19));
		_useTypes.put("glove", Integer.valueOf(20));
		_useTypes.put("boots", Integer.valueOf(21));
		_useTypes.put("helm", Integer.valueOf(22));
		_useTypes.put("ring", Integer.valueOf(23));
		_useTypes.put("amulet", Integer.valueOf(24));
		_useTypes.put("shield", Integer.valueOf(25));
		_useTypes.put("guarder", Integer.valueOf(25));
		_useTypes.put("dai", Integer.valueOf(26));
		_useTypes.put("zel", Integer.valueOf(27));
		_useTypes.put("blank", Integer.valueOf(28));
		_useTypes.put("btele", Integer.valueOf(29));
		_useTypes.put("spell_buff", Integer.valueOf(30)); // Selected object
															// (long-distance)
															// Ctrl and not push
															// packet is dead?
		_useTypes.put("ccard", Integer.valueOf(31));
		_useTypes.put("ccard_w", Integer.valueOf(32));
		_useTypes.put("vcard", Integer.valueOf(33));
		_useTypes.put("vcard_w", Integer.valueOf(34));
		_useTypes.put("wcard", Integer.valueOf(35));
		_useTypes.put("wcard_w", Integer.valueOf(36));
		_useTypes.put("belt", Integer.valueOf(37));
		// _useTypes.put("spell_long2", Integer.valueOf(39)); // The ground /
		// object selection (long-distance) and the same?
		_useTypes.put("earring", Integer.valueOf(40));
		_useTypes.put("fishing_rod", Integer.valueOf(42));
		_useTypes.put("del", Integer.valueOf(46));

		_armorTypes.put("none", Integer.valueOf(0));
		_armorTypes.put("helm", Integer.valueOf(1));
		_armorTypes.put("armor", Integer.valueOf(2));
		_armorTypes.put("T", Integer.valueOf(3));
		_armorTypes.put("cloak", Integer.valueOf(4));
		_armorTypes.put("glove", Integer.valueOf(5));
		_armorTypes.put("boots", Integer.valueOf(6));
		_armorTypes.put("shield", Integer.valueOf(7));
		_armorTypes.put("amulet", Integer.valueOf(8));
		_armorTypes.put("ring", Integer.valueOf(9));
		_armorTypes.put("belt", Integer.valueOf(10));
		_armorTypes.put("ring2", Integer.valueOf(11));
		_armorTypes.put("earring", Integer.valueOf(12));
		_armorTypes.put("guarder", Integer.valueOf(13));

		_weaponTypes.put("sword", Integer.valueOf(1));
		_weaponTypes.put("dagger", Integer.valueOf(2));
		_weaponTypes.put("tohandsword", Integer.valueOf(3));
		_weaponTypes.put("bow", Integer.valueOf(4));
		_weaponTypes.put("spear", Integer.valueOf(5));
		_weaponTypes.put("blunt", Integer.valueOf(6));
		_weaponTypes.put("staff", Integer.valueOf(7));
		_weaponTypes.put("throwingknife", Integer.valueOf(8));
		_weaponTypes.put("arrow", Integer.valueOf(9));
		_weaponTypes.put("gauntlet", Integer.valueOf(10));
		_weaponTypes.put("claw", Integer.valueOf(11));
		_weaponTypes.put("edoryu", Integer.valueOf(12));
		_weaponTypes.put("singlebow", Integer.valueOf(13));
		_weaponTypes.put("singlespear", Integer.valueOf(14));
		_weaponTypes.put("tohandblunt", Integer.valueOf(15));
		_weaponTypes.put("tohandstaff", Integer.valueOf(16));
		_weaponTypes.put("kiringku", Integer.valueOf(17));
		_weaponTypes.put("chainsword", Integer.valueOf(18));

		_weaponId.put("sword", Integer.valueOf(4));
		_weaponId.put("dagger", Integer.valueOf(46));
		_weaponId.put("tohandsword", Integer.valueOf(50));
		_weaponId.put("bow", Integer.valueOf(20));
		_weaponId.put("blunt", Integer.valueOf(11));
		_weaponId.put("spear", Integer.valueOf(24));
		_weaponId.put("staff", Integer.valueOf(40));
		_weaponId.put("throwingknife", Integer.valueOf(2922));
		_weaponId.put("arrow", Integer.valueOf(66));
		_weaponId.put("gauntlet", Integer.valueOf(62));
		_weaponId.put("claw", Integer.valueOf(58));
		_weaponId.put("edoryu", Integer.valueOf(54));
		_weaponId.put("singlebow", Integer.valueOf(20));
		_weaponId.put("singlespear", Integer.valueOf(24));
		_weaponId.put("tohandblunt", Integer.valueOf(11));
		_weaponId.put("tohandstaff", Integer.valueOf(40));
		_weaponId.put("kiringku", Integer.valueOf(58));
		_weaponId.put("chainsword", Integer.valueOf(24));

		_materialTypes.put("none", Integer.valueOf(0));
		_materialTypes.put("liquid", Integer.valueOf(1));
		_materialTypes.put("web", Integer.valueOf(2));
		_materialTypes.put("vegetation", Integer.valueOf(3));
		_materialTypes.put("animalmatter", Integer.valueOf(4));
		_materialTypes.put("paper", Integer.valueOf(5));
		_materialTypes.put("cloth", Integer.valueOf(6));
		_materialTypes.put("leather", Integer.valueOf(7));
		_materialTypes.put("wood", Integer.valueOf(8));
		_materialTypes.put("bone", Integer.valueOf(9));
		_materialTypes.put("dragonscale", Integer.valueOf(10));
		_materialTypes.put("iron", Integer.valueOf(11));
		_materialTypes.put("steel", Integer.valueOf(12));
		_materialTypes.put("copper", Integer.valueOf(13));
		_materialTypes.put("silver", Integer.valueOf(14));
		_materialTypes.put("gold", Integer.valueOf(15));
		_materialTypes.put("platinum", Integer.valueOf(16));
		_materialTypes.put("mithril", Integer.valueOf(17));
		_materialTypes.put("blackmithril", Integer.valueOf(18));
		_materialTypes.put("glass", Integer.valueOf(19));
		_materialTypes.put("gemstone", Integer.valueOf(20));
		_materialTypes.put("mineral", Integer.valueOf(21));
		_materialTypes.put("oriharukon", Integer.valueOf(22));
	}

	public static ItemTable getInstance() {
		if (_instance == null) {
			_instance = new ItemTable();
		}
		return _instance;
	}

	private ItemTable() {
		_etcitems = allEtcItem();
		_weapons = allWeapon();
		_armors = allArmor();
		buildFastLookupTable();
	}

	private Map<Integer, L1EtcItem> allEtcItem() {
		Map<Integer, L1EtcItem> result = new HashMap<Integer, L1EtcItem>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		L1EtcItem item = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("select * from etcitem");
			rs = pstm.executeQuery();
			while (rs.next()) {
				item = new L1EtcItem();
				item.setItemId(rs.getInt("item_id"));
				item.setName(rs.getString("name"));
				item.setUnidentifiedNameId(rs.getString("unidentified_name_id"));
				item.setIdentifiedNameId(rs.getString("identified_name_id"));
				item.setType((_etcItemTypes.get(rs.getString("item_type")))
						.intValue());
				item.setUseType(_useTypes.get(rs.getString("use_type"))
						.intValue());
				item.setType2(0);
				item.setMaterial((_materialTypes.get(rs.getString("material")))
						.intValue());
				item.setWeight(rs.getInt("weight"));
				item.setGfxId(rs.getInt("invgfx"));
				item.setGroundGfxId(rs.getInt("grdgfx"));
				item.setItemDescId(rs.getInt("itemdesc_id"));
				item.setMinLevel(rs.getInt("min_lvl"));
				item.setMaxLevel(rs.getInt("max_lvl"));
				item.setBless(rs.getInt("bless"));
				item.setTradable(rs.getInt("trade") == 0 ? true : false);
				item.setCantDelete(rs.getInt("cant_delete") == 1 ? true : false);
				item.setCanSeal(rs.getInt("can_seal") == 1 ? true : false);
				item.setDmgSmall(rs.getInt("dmg_small"));
				item.setDmgLarge(rs.getInt("dmg_large"));
				item.set_stackable(rs.getInt("stackable") == 1 ? true : false);
				item.setMaxChargeCount(rs.getInt("max_charge_count"));
				item.set_locx(rs.getInt("locx"));
				item.set_locy(rs.getInt("locy"));
				item.set_mapid(rs.getShort("mapid"));
				item.set_delayid(rs.getInt("delay_id"));
				item.set_delaytime(rs.getInt("delay_time"));
				item.set_delayEffect(rs.getInt("delay_effect"));
				item.setFoodVolume(rs.getInt("food_volume"));
				item.setToBeSavedAtOnce((rs.getInt("save_at_once") == 1) ? true
						: false);
				result.put(new Integer(item.getItemId()), item);
			}
		} catch (NullPointerException e) {
			_log.log(
					Level.SEVERE,
					new StringBuilder().append(item.getName())
							.append("(" + item.getItemId() + ")")
							.append(" Failed to load.").toString());
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return result;
	}

	private Map<Integer, L1Weapon> allWeapon() {
		Map<Integer, L1Weapon> result = new HashMap<Integer, L1Weapon>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		L1Weapon weapon = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("select * from weapon");
			rs = pstm.executeQuery();
			while (rs.next()) {
				weapon = new L1Weapon();
				weapon.setItemId(rs.getInt("item_id"));
				weapon.setName(rs.getString("name"));
				weapon.setUnidentifiedNameId(rs
						.getString("unidentified_name_id"));
				weapon.setIdentifiedNameId(rs.getString("identified_name_id"));
				weapon.setType((_weaponTypes.get(rs.getString("type")))
						.intValue());
				weapon.setType1((_weaponId.get(rs.getString("type")))
						.intValue());
				weapon.setType2(1);
				weapon.setUseType(1);
				weapon.setMaterial((_materialTypes.get(rs.getString("material")))
						.intValue());
				weapon.setWeight(rs.getInt("weight"));
				weapon.setGfxId(rs.getInt("invgfx"));
				weapon.setGroundGfxId(rs.getInt("grdgfx"));
				weapon.setItemDescId(rs.getInt("itemdesc_id"));
				weapon.setDmgSmall(rs.getInt("dmg_small"));
				weapon.setDmgLarge(rs.getInt("dmg_large"));
				weapon.setRange(rs.getInt("range"));
				weapon.set_safeenchant(rs.getInt("safenchant"));
				weapon.setUseRoyal(rs.getInt("use_royal") == 0 ? false : true);
				weapon.setUseKnight(rs.getInt("use_knight") == 0 ? false : true);
				weapon.setUseElf(rs.getInt("use_elf") == 0 ? false : true);
				weapon.setUseMage(rs.getInt("use_mage") == 0 ? false : true);
				weapon.setUseDarkelf(rs.getInt("use_darkelf") == 0 ? false
						: true);
				weapon.setUseDragonknight(rs.getInt("use_dragonknight") == 0 ? false
						: true);
				weapon.setUseIllusionist(rs.getInt("use_illusionist") == 0 ? false
						: true);
				weapon.setHitModifier(rs.getInt("hitmodifier"));
				weapon.setDmgModifier(rs.getInt("dmgmodifier"));
				weapon.set_addstr(rs.getByte("add_str"));
				weapon.set_adddex(rs.getByte("add_dex"));
				weapon.set_addcon(rs.getByte("add_con"));
				weapon.set_addint(rs.getByte("add_int"));
				weapon.set_addwis(rs.getByte("add_wis"));
				weapon.set_addcha(rs.getByte("add_cha"));
				weapon.set_addhp(rs.getInt("add_hp"));
				weapon.set_addmp(rs.getInt("add_mp"));
				weapon.set_addhpr(rs.getInt("add_hpr"));
				weapon.set_addmpr(rs.getInt("add_mpr"));
				weapon.set_addsp(rs.getInt("add_sp"));
				weapon.set_mdef(rs.getInt("m_def"));
				weapon.setDoubleDmgChance(rs.getInt("double_dmg_chance"));
				weapon.setMagicDmgModifier(rs.getInt("magicdmgmodifier"));
				weapon.set_canbedmg(rs.getInt("canbedmg"));
				weapon.setMinLevel(rs.getInt("min_lvl"));
				weapon.setMaxLevel(rs.getInt("max_lvl"));
				weapon.setBless(rs.getInt("bless"));
				weapon.setTradable(rs.getInt("trade") == 0 ? true : false);
				weapon.setCantDelete(rs.getInt("cant_delete") == 1 ? true
						: false);
				weapon.setHasteItem(rs.getInt("haste_item") == 0 ? false : true);
				weapon.setMaxUseTime(rs.getInt("max_use_time"));
				result.put(new Integer(weapon.getItemId()), weapon);
			}
		} catch (NullPointerException e) {
			_log.log(
					Level.SEVERE,
					new StringBuilder().append(weapon.getName())
							.append("(" + weapon.getItemId() + ")")
							.append(" Failed to load.").toString());
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);

		}
		return result;
	}

	private Map<Integer, L1Armor> allArmor() {
		Map<Integer, L1Armor> result = new HashMap<Integer, L1Armor>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		L1Armor armor = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("select * from armor");
			rs = pstm.executeQuery();
			while (rs.next()) {
				armor = new L1Armor();
				armor.setItemId(rs.getInt("item_id"));
				armor.setName(rs.getString("name"));
				armor.setUnidentifiedNameId(rs
						.getString("unidentified_name_id"));
				armor.setIdentifiedNameId(rs.getString("identified_name_id"));
				armor.setType((_armorTypes.get(rs.getString("type")))
						.intValue());
				armor.setType2(2);
				armor.setUseType((_useTypes.get(rs.getString("type")))
						.intValue());
				armor.setMaterial((_materialTypes.get(rs.getString("material")))
						.intValue());
				armor.setWeight(rs.getInt("weight"));
				armor.setGfxId(rs.getInt("invgfx"));
				armor.setGroundGfxId(rs.getInt("grdgfx"));
				armor.setItemDescId(rs.getInt("itemdesc_id"));
				armor.set_ac(rs.getInt("ac"));
				armor.set_safeenchant(rs.getInt("safenchant"));
				armor.setUseRoyal(rs.getInt("use_royal") == 0 ? false : true);
				armor.setUseKnight(rs.getInt("use_knight") == 0 ? false : true);
				armor.setUseElf(rs.getInt("use_elf") == 0 ? false : true);
				armor.setUseMage(rs.getInt("use_mage") == 0 ? false : true);
				armor.setUseDarkelf(rs.getInt("use_darkelf") == 0 ? false
						: true);
				armor.setUseDragonknight(rs.getInt("use_dragonknight") == 0 ? false
						: true);
				armor.setUseIllusionist(rs.getInt("use_illusionist") == 0 ? false
						: true);
				armor.set_addstr(rs.getByte("add_str"));
				armor.set_addcon(rs.getByte("add_con"));
				armor.set_adddex(rs.getByte("add_dex"));
				armor.set_addint(rs.getByte("add_int"));
				armor.set_addwis(rs.getByte("add_wis"));
				armor.set_addcha(rs.getByte("add_cha"));
				armor.set_addhp(rs.getInt("add_hp"));
				armor.set_addmp(rs.getInt("add_mp"));
				armor.set_addhpr(rs.getInt("add_hpr"));
				armor.set_addmpr(rs.getInt("add_mpr"));
				armor.set_addsp(rs.getInt("add_sp"));
				armor.setMinLevel(rs.getInt("min_lvl"));
				armor.setMaxLevel(rs.getInt("max_lvl"));
				armor.set_mdef(rs.getInt("m_def"));
				armor.setDamageReduction(rs.getInt("damage_reduction"));
				armor.setWeightReduction(rs.getInt("weight_reduction"));
				armor.setHitModifierByArmor(rs.getInt("hit_modifier"));
				armor.setDmgModifierByArmor(rs.getInt("dmg_modifier"));
				armor.setBowHitModifierByArmor(rs.getInt("bow_hit_modifier"));
				armor.setBowDmgModifierByArmor(rs.getInt("bow_dmg_modifier"));
				armor.setHasteItem(rs.getInt("haste_item") == 0 ? false : true);
				armor.setBless(rs.getInt("bless"));
				armor.setTradable(rs.getInt("trade") == 0 ? true : false);
				armor.setCantDelete(rs.getInt("cant_delete") == 1 ? true
						: false);
				armor.set_defense_earth(rs.getInt("defense_earth"));
				armor.set_defense_water(rs.getInt("defense_water"));
				armor.set_defense_wind(rs.getInt("defense_wind"));
				armor.set_defense_fire(rs.getInt("defense_fire"));
				armor.set_resist_stun(rs.getInt("regist_stun"));
				armor.set_resist_stone(rs.getInt("regist_stone"));
				armor.set_resist_sleep(rs.getInt("regist_sleep"));
				armor.set_resist_freeze(rs.getInt("regist_freeze"));
				armor.set_resist_sustain(rs.getInt("regist_sustain"));
				armor.set_resist_blind(rs.getInt("regist_blind"));
				armor.setMaxUseTime(rs.getInt("max_use_time"));
				armor.setGrade(rs.getInt("grade"));
				result.put(new Integer(armor.getItemId()), armor);
			}
		} catch (NullPointerException e) {
			_log.log(
					Level.SEVERE,
					new StringBuilder().append(armor.getName())
							.append("(" + armor.getItemId() + ")")
							.append(" Failed to load.").toString());
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);

		}
		return result;
	}

	private void buildFastLookupTable() {
		int highestId = 0;

		Collection<L1EtcItem> items = _etcitems.values();
		for (L1EtcItem item : items) {
			if (item.getItemId() > highestId) {
				highestId = item.getItemId();
			}
		}

		Collection<L1Weapon> weapons = _weapons.values();
		for (L1Weapon weapon : weapons) {
			if (weapon.getItemId() > highestId) {
				highestId = weapon.getItemId();
			}
		}

		Collection<L1Armor> armors = _armors.values();
		for (L1Armor armor : armors) {
			if (armor.getItemId() > highestId) {
				highestId = armor.getItemId();
			}
		}

		_allTemplates = new L1Item[highestId + 1];

		for (Iterator<Integer> iter = _etcitems.keySet().iterator(); iter
				.hasNext();) {
			Integer id = iter.next();
			L1EtcItem item = _etcitems.get(id);
			_allTemplates[id.intValue()] = item;
		}

		for (Iterator<Integer> iter = _weapons.keySet().iterator(); iter
				.hasNext();) {
			Integer id = iter.next();
			L1Weapon item = _weapons.get(id);
			_allTemplates[id.intValue()] = item;
		}

		for (Iterator<Integer> iter = _armors.keySet().iterator(); iter
				.hasNext();) {
			Integer id = iter.next();
			L1Armor item = _armors.get(id);
			_allTemplates[id.intValue()] = item;
		}
	}

	public L1Item getTemplate(int id) {
		return _allTemplates[id];
	}

	public L1ItemInstance createItem(int itemId) {
		L1Item temp = getTemplate(itemId);
		if (temp == null) {
			return null;
		}
		L1ItemInstance item = new L1ItemInstance();
		item.setId(IdFactory.getInstance().nextId());
		item.setItem(temp);
		L1World.getInstance().storeObject(item);
		return item;
	}

	public int findItemIdByName(String name) {
		int itemid = 0;
		for (L1Item item : _allTemplates) {
			if (item != null && item.getName().equals(name)) {
				itemid = item.getItemId();
				break;
			}
		}
		return itemid;
	}

	public int findItemIdByNameWithoutSpace(String name) {
		int itemid = 0;
		for (L1Item item : _allTemplates) {
			if (item != null && item.getName().replace(" ", "").equals(name)) {
				itemid = item.getItemId();
				break;
			}
		}
		return itemid;
	}
}
