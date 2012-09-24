package l1j.server.server.model.Instance;

import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import l1j.server.server.datatables.NpcTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.model.Element;
import l1j.server.server.model.L1EquipmentTimer;
import l1j.server.server.model.L1ItemOwnerTimer;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Armor;
import l1j.server.server.templates.L1Item;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Pet;
import l1j.server.server.utils.BinaryOutputStream;
import static l1j.server.server.model.skill.L1SkillId.*;

public class L1ItemInstance extends L1Object {
	private static Logger _log = Logger.getLogger(L1ItemInstance.class.getName());

	private static final long serialVersionUID = 1L;

	private int _count;

	private int _itemId;

	private L1Item _item;

	private boolean _isActive = false;
	
	private boolean _isEquipped = false;

	private int _enchantLevel;

	private boolean _isIdentified = false;

	private int _durability;

	private int _chargeCount;

	private int _remainingTime;

	private Timestamp _lastUsed = null;

	private int _lastWeight;

	private final LastStatus _lastStatus = new LastStatus();

	private L1PcInstance _pc;

	private boolean _isRunning = false;

	private EnchantTimer _timer;

	private int _bless;

	private int _attrEnchantKind;

	private int _attrEnchantLevel;

	public L1ItemInstance() {
		_count = 1;
		_enchantLevel = 0;
	}

	public L1ItemInstance(L1Item item, int count) {
		this();
		setItem(item);
		setCount(count);
	}

	public boolean isIdentified() {
		return _isIdentified;
	}

	public void setIdentified(boolean identified) {
		_isIdentified = identified;
	}

	public String getName() {
		return _item.getName();
	}

	public int getCount() {
		return _count;
	}

	public void setCount(int count) {
		_count = count;
	}

	public boolean isEquipped() {
		return _isEquipped;
	}

	public void setEquipped(boolean equipped) {
		_isEquipped = equipped;
	}

	public L1Item getItem() {
		return _item;
	}

	public void setItem(L1Item item) {
		_item = item;
		_itemId = item.getItemId();
	}

	public int getItemId() {
		return _itemId;
	}

	public void setItemId(int itemId) {
		_itemId = itemId;
	}

	public boolean isStackable() {
		return _item.isStackable();
	}
	
	/* For illumination items*/ 
	public boolean isActive() { 
		return _isActive; 
	}  
	public void setActive(boolean isActive) { 
		_isActive = isActive; 
	} 
	
	@Override
	public void onAction(L1PcInstance player) {
	}

	public int getEnchantLevel() {
		return _enchantLevel;
	}

	public void setEnchantLevel(int enchantLevel) {
		_enchantLevel = enchantLevel;
	}

	public int get_gfxid() {
		return _item.getGfxId();
	}

	public int get_durability() {
		return _durability;
	}

	public int getChargeCount() {
		return _chargeCount;
	}

	public void setChargeCount(int i) {
		_chargeCount = i;
	}

	public int getRemainingTime() {
		return _remainingTime;
	}

	public void setRemainingTime(int i) {
		_remainingTime = i;
	}

	public void setLastUsed(Timestamp t) {
		_lastUsed = t;
	}

	public Timestamp getLastUsed() {
		return _lastUsed;
	}

	public int getLastWeight() {
		return _lastWeight;
	}

	public void setLastWeight(int weight) {
		_lastWeight = weight;
	}

	public void setBless(int i) {
		_bless = i;
	}

	public int getBless() {
		return _bless;
	}

	public void setAttrEnchantKind(int i) {
		_attrEnchantKind = i;
	}

	public int getAttrEnchantKind() {
		return _attrEnchantKind;
	}

	public void setAttrEnchantLevel(int i) {
		_attrEnchantLevel = i;
	}

	public int getAttrEnchantLevel() {
		return _attrEnchantLevel;
	}

	public int getMr() {
		int mr = _item.get_mdef();
		if (getItemId() == 20011 || getItemId() == 20110
				|| getItemId() == 21108 || getItemId() == 120011) {
			mr += getEnchantLevel();
		}
		if (getItemId() == 20056 || getItemId() == 120056
				|| getItemId() == 220056) {
			mr += getEnchantLevel() * 2;
		}
		mr += getMagicResist();
		return mr;
	}

	public void set_durability(int i) {
		if (i < 0) {
			i = 0;
		}

		if (i > 127) {
			i = 127;
		}
		_durability = i;
	}

	public int getWeight() {
		if (getItem().getWeight() == 0) {
			return 0;
		} else {
			return Math.max(getCount() * getItem().getWeight() / 1000, 1);
		}
	}


	public class LastStatus {
		public int count;

		public int itemId;

		public boolean isEquipped = false;

		public int enchantLevel;

		public boolean isIdentified = true;

		public int durability;

		public int chargeCount;

		public int remainingTime;

		public Timestamp lastUsed = null;

		public int bless;

		public int attrEnchantKind;

		public int attrEnchantLevel;

		public int earthResist;
		public int fireResist;
		public int waterResist;
		public int windResist;
		public int additionalHp;
		public int additionalMp;
		public int hpRegen;
		public int mpRegen;
		public int additionalSp;
		public int magicResist;

		public void updateAll() {
			count = getCount();
			itemId = getItemId();
			isEquipped = isEquipped();
			isIdentified = isIdentified();
			enchantLevel = getEnchantLevel();
			durability = get_durability();
			chargeCount = getChargeCount();
			remainingTime = getRemainingTime();
			lastUsed = getLastUsed();
			bless = getBless();
			attrEnchantKind = getAttrEnchantKind();
			attrEnchantLevel = getAttrEnchantLevel();
			earthResist = getEarthResist();
			fireResist = getFireResist();
			waterResist = getWaterResist();
			windResist = getWindResist();
			additionalHp = getAddHp();
			additionalMp = getAddMp();
			hpRegen = getAddHpRegen();
			mpRegen = getAddMpRegen();
			additionalSp = getAddSpellpower();
			magicResist = getMagicResist();
		}

		public void updateCount() {
			count = getCount();
		}

		public void updateItemId() {
			itemId = getItemId();
		}

		public void updateEquipped() {
			isEquipped = isEquipped();
		}

		public void updateIdentified() {
			isIdentified = isIdentified();
		}

		public void updateEnchantLevel() {
			enchantLevel = getEnchantLevel();
		}

		public void updateDuraility() {
			durability = get_durability();
		}

		public void updateChargeCount() {
			chargeCount = getChargeCount();
		}

		public void updateRemainingTime() {
			remainingTime = getRemainingTime();
		}

		public void updateLastUsed() {
			lastUsed = getLastUsed();
		}

		public void updateBless() {
			bless = getBless();
		}

		public void updateAttrEnchantKind() {
			attrEnchantKind = getAttrEnchantKind();
		}

		public void updateAttrEnchantLevel() {
			attrEnchantLevel = getAttrEnchantLevel();
		}

		public void updateFireResist() {
			;
		}

		public void updateWaterResist() {}
		public void updateEarthResist() {}
		public void updateWindResist() {}
		public void updateSpellpower() {}
		public void updateHp() {}
		public void updateMp() {}
		public void updateHpRegen() {}
		public void updateMpRegen() {}
		public void updateMagicResist() {}
	}

	public LastStatus getLastStatus() {
		return _lastStatus;
	}

	public int getRecordingColumns() {
		int column = 0;

		if (getCount() != _lastStatus.count) {
			column += L1PcInventory.COL_COUNT;
		}
		if (getItemId() != _lastStatus.itemId) {
			column += L1PcInventory.COL_ITEMID;
		}
		if (isEquipped() != _lastStatus.isEquipped) {
			column += L1PcInventory.COL_EQUIPPED;
		}
		if (getEnchantLevel() != _lastStatus.enchantLevel) {
			column += L1PcInventory.COL_ENCHANTLVL;
		}
		if (get_durability() != _lastStatus.durability) {
			column += L1PcInventory.COL_DURABILITY;
		}
		if (getChargeCount() != _lastStatus.chargeCount) {
			column += L1PcInventory.COL_CHARGE_COUNT;
		}
		if (getLastUsed() != _lastStatus.lastUsed) {
			column += L1PcInventory.COL_DELAY_EFFECT;
		}
		if (isIdentified() != _lastStatus.isIdentified) {
			column += L1PcInventory.COL_IS_ID;
		}
		if (getRemainingTime() != _lastStatus.remainingTime) {
			column += L1PcInventory.COL_REMAINING_TIME;
		}
		if (getBless() != _lastStatus.bless) {
			column += L1PcInventory.COL_BLESS;
		}
		if (getAttrEnchantKind() != _lastStatus.attrEnchantKind) {
			column += L1PcInventory.COL_ATTR_ENCHANT_KIND;
		}
		if (getAttrEnchantLevel() != _lastStatus.attrEnchantLevel) {
			column += L1PcInventory.COL_ATTR_ENCHANT_LEVEL;
		}

		return column;
	}

	public int getRecordingColumnsEnchantAccessory() {
		int column = 0;

		if (getAddHp() != _lastStatus.additionalHp) {
			column += L1PcInventory.COL_ADDHP;
		}
		if (getAddMp() != _lastStatus.additionalMp) {
			column += L1PcInventory.COL_ADDMP;
		}
		if (getAddHpRegen() != _lastStatus.hpRegen) {
			column += L1PcInventory.COL_HPR;
		}
		if (getAddMpRegen() != _lastStatus.mpRegen) {
			column += L1PcInventory.COL_MPR;
		}
		if (getAddSpellpower() != _lastStatus.additionalSp) {
			column += L1PcInventory.COL_ADDSP;
		}
		if (getMagicResist() != _lastStatus.magicResist) {
			column += L1PcInventory.COL_M_DEF;
		}
		if (getEarthResist() != _lastStatus.earthResist) {
			column += L1PcInventory.COL_EARTHMR;
		}
		if (getFireResist() != _lastStatus.fireResist) {
			column += L1PcInventory.COL_FIREMR;
		}
		if (getWaterResist() != _lastStatus.waterResist) {
			column += L1PcInventory.COL_WATERMR;
		}
		if (getWindResist() != _lastStatus.windResist) {
			column += L1PcInventory.COL_WINDMR;
		}

		return column;
	}



	public String getNumberedViewName(int count) {
		StringBuilder name = new StringBuilder(getNumberedName(count));
		int itemType2 = getItem().getType2();
		int itemId = getItem().getItemId();

		if (itemId == 40314 || itemId == 40316) { //
			L1Pet pet = PetTable.getInstance().getTemplate(getId());
			if (pet != null) {
				L1Npc npc = NpcTable.getInstance().getTemplate(pet.get_npcid());
				// name.append("[Lv." + pet.get_level() + " "
				// + npc.get_nameid() + "]");
				name.append("[Lv." + pet.get_level() + " " + pet.get_name()
						+ "]HP" + pet.get_hp() + " " + npc.get_nameid());
			}
		}

		if (getItem().getType2() == 0 && getItem().getType() == 2) {
			if (isNowLighting()) {
				name.append(" ($10)");
			}
			if (itemId == 40001 || itemId == 40002) {
				if (getRemainingTime() <= 0) {
					name.append(" ($11)");
				}
			}
		}

		if (isEquipped()) {
			if (itemType2 == 1) {
				name.append(" ($9)"); //(Armed)
			} else if (itemType2 == 2) {
				name.append(" ($117)"); // 
			} else if (itemType2 == 0 && getItem().getType() == 11) { // petitem
				name.append(" ($117)"); //
			}
		}
		return name.toString();
	}

	public String getViewName() {
		return getNumberedViewName(_count);
	}

	public String getLogName() {
		return getNumberedName(_count);
	}

	public String getNumberedName(int count) {
		StringBuilder name = new StringBuilder();

		if (isIdentified()) {
			if (getItem().getType2() == 1) { 
				int attrEnchantLevel = getAttrEnchantLevel();
				if (attrEnchantLevel > 0) {
					String attrStr = null;
					switch (getAttrEnchantKind()) {
					case Element.Earth: 
						if (attrEnchantLevel == 1) {
							attrStr = "$6124";
						} else if (attrEnchantLevel == 2) {
							attrStr = "$6125";
						} else if (attrEnchantLevel == 3) {
							attrStr = "$6126";
						}
						break;
					case Element.Fire: 
						if (attrEnchantLevel == 1) {
							attrStr = "$6115";
						} else if (attrEnchantLevel == 2) {
							attrStr = "$6116";
						} else if (attrEnchantLevel == 3) {
							attrStr = "$6117";
						}
						break;
					case Element.Water: 
						if (attrEnchantLevel == 1) {
							attrStr = "$6118";
						} else if (attrEnchantLevel == 2) {
							attrStr = "$6119";
						} else if (attrEnchantLevel == 3) {
							attrStr = "$6120";
						}
						break;
					case Element.Wind: 
						if (attrEnchantLevel == 1) {
							attrStr = "$6121";
						} else if (attrEnchantLevel == 2) {
							attrStr = "$6122";
						} else if (attrEnchantLevel == 3) {
							attrStr = "$6123";
						}
						break;
					default:
						break;
					}
					name.append(attrStr + " ");
				}
			}
			if (getItem().getType2() == 1 || getItem().getType2() == 2) {
				if (getEnchantLevel() >= 0) {
					name.append("+" + getEnchantLevel() + " ");
				} else if (getEnchantLevel() < 0) {
					name.append(String.valueOf(getEnchantLevel()) + " ");
				}
			}
		}
		if (isIdentified()) {
			name.append(_item.getIdentifiedNameId());
		} else {
			name.append(_item.getUnidentifiedNameId());
		}
		if (isIdentified()) {
			if (getItem().getMaxChargeCount() > 0) {
				name.append(" (" + getChargeCount() + ")");
			}
			if (getItem().getItemId() == 20383) {
				name.append(" (" + getChargeCount() + ")");
			}
			if (getItem().getMaxUseTime() > 0 && getItem().getType2() != 0) { //
				name.append(" (" + getRemainingTime() + ")");
			}
		}

		if (count > 1) {
			name.append(" (" + count + ")");
		}

		return name.toString();
	}

	public byte[] getStatusBytes() {
		int itemType2 = getItem().getType2();
		int itemId = getItemId();
		BinaryOutputStream os = new BinaryOutputStream();
		
		if (itemType2 == 0) { // etcitem
			switch (getItem().getType()) {
			case 2: // light
				os.writeC(22); 
				os.writeH(getItem().getLightRange());
				break;
			case 7: // food
				os.writeC(21);
				os.writeH(getItem().getFoodVolume());
				break;
			case 0: // arrow
			case 15: // sting
				os.writeC(1); 
				os.writeC(getItem().getDmgSmall());
				os.writeC(getItem().getDmgLarge());
				break;
			default:
				os.writeC(23);
				break;
			}
			os.writeC(getItem().getMaterial());
			os.writeD(getWeight());
			
		} else if (itemType2 == 1 || itemType2 == 2) { // weapon | armor
			if (itemType2 == 1) { // weapon
				os.writeC(1);
				os.writeC(getItem().getDmgSmall());
				os.writeC(getItem().getDmgLarge());
				os.writeC(getItem().getMaterial());
				os.writeD(getWeight());
			} else if (itemType2 == 2) { // armor
				// AC
				os.writeC(19); 
				int ac = ((L1Armor) getItem()).get_ac();
				if (ac < 0) {
					ac = ac - ac - ac;
				}
				os.writeC(ac);
				os.writeC(getItem().getMaterial());
				// US clients aren't expecting this so it messes up the
				// displayed weight for armor.
				// os.writeC(getItem().getGrade());
				os.writeD(getWeight());
			}
			if (getEnchantLevel() != 0) {
				os.writeC(2);
				if (getItem().getType2() == 2 && getItem().getType() >= 8 &&
						getItem().getType() <= 12) {
					os.writeC(0);
				} else {
					os.writeC(getEnchantLevel());
				}
			}
			if (get_durability() != 0) {
				os.writeC(3);
				os.writeC(get_durability());
			}
			if (getItem().isTwohandedWeapon()) {
				os.writeC(4);
			}
			
			if (itemType2 == 1) { // weapon
				if (getItem().getHitModifier() != 0) {
					os.writeC(5);
					os.writeC(getItem().getHitModifier());
				}
			} else if (itemType2 == 2) { // armor
				if (getItem().getHitModifierByArmor() != 0) {
					os.writeC(5);
					os.writeC(getItem().getHitModifierByArmor());
				}
			}

			if (itemType2 == 1) { // weapon
				if (getItem().getDmgModifier() != 0) {
					os.writeC(6);
					os.writeC(getItem().getDmgModifier());
				}
			} else if (itemType2 == 2) { // armor
				if (getItem().getDmgModifierByArmor() != 0) {
					os.writeC(6);
					os.writeC(getItem().getDmgModifierByArmor());
				}
			}

			int bit = 0;
			bit |= getItem().isUseRoyal()   ? 1 : 0;
			bit |= getItem().isUseKnight()  ? 2 : 0;
			bit |= getItem().isUseElf()     ? 4 : 0;
			bit |= getItem().isUseMage()    ? 8 : 0;
			bit |= getItem().isUseDarkelf() ? 16 : 0;
			bit |= getItem().isUseDragonknight() ? 32 : 0;
			bit |= getItem().isUseIllusionist() ? 64 : 0;
			// bit |= getItem().isUseHiPet() ? 64 : 0; 
			os.writeC(7);
			os.writeC(bit);

			if (getItem().getBowHitModifierByArmor() != 0) {
				os.writeC(24);
				os.writeC(getItem().getBowHitModifierByArmor());
			}

			if (getItem().getBowDmgModifierByArmor() != 0) {
				os.writeC(35);
				os.writeC(getItem().getBowDmgModifierByArmor());
			}

			if (itemId == 126 || itemId == 127) { 
				os.writeC(16);
			}
		
			if (itemId == 262) { 
				os.writeC(34);
			}
			// STR~CHA
			if (getItem().get_addstr() != 0) {
				os.writeC(8);
				os.writeC(getItem().get_addstr());
			}
			if (getItem().get_adddex() != 0) {
				os.writeC(9);
				os.writeC(getItem().get_adddex());
			}
			if (getItem().get_addcon() != 0) {
				os.writeC(10);
				os.writeC(getItem().get_addcon());
			}
			if (getItem().get_addwis() != 0) {
				os.writeC(11);
				os.writeC(getItem().get_addwis());
			}
			if (getItem().get_addint() != 0) {
				os.writeC(12);
				os.writeC(getItem().get_addint());
			}
			if (getItem().get_addcha() != 0) {
				os.writeC(13);
				os.writeC(getItem().get_addcha());
			}
			// HP, MP
			if (getItem().get_addhp() != 0 || getAddHp() != 0) {
				os.writeC(14);
				os.writeH(getItem().get_addhp() + getAddHp());
			}
			if (getItem().get_addmp() != 0 || getAddMp() != 0) {
				os.writeC(32);
				os.writeC(getItem().get_addmp() + getAddMp());
			}
			if (getMr() != 0) {
				os.writeC(15);
				os.writeH(getMr());
			}
			if (getItem().get_addsp() != 0 || getAddSpellpower() != 0) {
				os.writeC(17);
				os.writeC(getItem().get_addsp() + getAddSpellpower());
			}
			if (getItem().isHasteItem()) {
				os.writeC(18);
			}
			if (getItem().get_defense_fire() != 0 || getFireResist() != 0) {
				os.writeC(27);
				os.writeC(getItem().get_defense_fire() + getFireResist());
			}
			if (getItem().get_defense_water() != 0 || getWaterResist() != 0) {
				os.writeC(28);
				os.writeC(getItem().get_defense_water() + getWaterResist());
			}
			if (getItem().get_defense_wind() != 0 || getWindResist() != 0) {
				os.writeC(29);
				os.writeC(getItem().get_defense_wind() + getWindResist());
			}
			if (getItem().get_defense_earth() != 0 || getEarthResist() != 0) {
				os.writeC(30);
				os.writeC(getItem().get_defense_earth() + getEarthResist());
			}
			if (getItem().get_resist_freeze() != 0) {
				os.writeC(15);
				os.writeH(getItem().get_resist_freeze());
				os.writeC(33);
				os.writeC(1);
			}
			if (getItem().get_resist_stone() != 0) {
				os.writeC(15);
				os.writeH(getItem().get_resist_stone());
				os.writeC(33);
				os.writeC(2);
			}
			if (getItem().get_resist_sleep() != 0) {
				os.writeC(15);
				os.writeH(getItem().get_resist_sleep());
				os.writeC(33);
				os.writeC(3);
			}
			if (getItem().get_resist_blind() != 0) {
				os.writeC(15);
				os.writeH(getItem().get_resist_blind());
				os.writeC(33);
				os.writeC(4);
			}
			if (getItem().get_resist_stun() != 0) {
				os.writeC(15);
				os.writeH(getItem().get_resist_stun());
				os.writeC(33);
				os.writeC(5);
			}
			if (getItem().get_resist_sustain() != 0) {
				os.writeC(15);
				os.writeH(getItem().get_resist_sustain());
				os.writeC(33);
				os.writeC(6);
			}
			if (getMagicResist() != 0) {
				os.writeC(15);
				os.writeH(getMagicResist());
			}
			if (getItem().get_addhpr() != 0 || getAddHpRegen() != 0) {
				os.writeC(37);
				os.writeC(getItem().get_addhpr() + getAddHpRegen());
			}
			if (getItem().get_addmpr() != 0 || getAddMpRegen() != 0) {
				os.writeC(38);
				os.writeC(getItem().get_addmpr() + getAddMpRegen());
			}

			// if (getItem.getLuck() != 0) {
			// os.writeC(20);
			// os.writeC(val);
			// }
			// if (getItem.getDesc() != 0) {
			// os.writeC(25);
			// os.writeH(val); // desc.tbl ID
			// }
			// if (getItem.getLevel() != 0) {
			// os.writeC(26);
			// os.writeH(val);
			// }
		}
		return os.getBytes();
	}

	class EnchantTimer extends TimerTask {
		public EnchantTimer() { }

		@Override public void run() {
			try {
				int type = getItem().getType();
				int type2 = getItem().getType2();
				int itemId = getItem().getItemId();
				if (_pc != null && _pc.getInventory().checkItem(itemId)) {
					if (type == 2 && type2 == 2 && isEquipped()) {
						_pc.addAc(3);
						_pc.sendPackets(new S_OwnCharStatus(_pc));
					}
				}
				setAcByMagic(0);
				setDmgByMagic(0);
				setHolyDmgByMagic(0);
				setHitByMagic(0);
				_pc.sendPackets(new S_ServerMessage(308, getLogName()));
				_isRunning = false;
				_timer = null;
			} catch (Exception e) {
			}
		}
	}

	private int _acByMagic = 0;

	public int getAcByMagic() {
		return _acByMagic;
	}

	public void setAcByMagic(int i) {
		_acByMagic = i;
	}

	private int _dmgByMagic = 0;

	public int getDmgByMagic() {
		return _dmgByMagic;
	}

	public void setDmgByMagic(int i) {
		_dmgByMagic = i;
	}

	private int _holyDmgByMagic = 0;

	public int getHolyDmgByMagic() {
		return _holyDmgByMagic;
	}

	public void setHolyDmgByMagic(int i) {
		_holyDmgByMagic = i;
	}

	private int _hitByMagic = 0;

	public int getHitByMagic() {
		return _hitByMagic;
	}

	public void setHitByMagic(int i) {
		_hitByMagic = i;
	}

	private int _fireResist;
	private int _waterResist;
	private int _earthResist;
	private int _windResist;
	private int _addSpellpower;
	private int _addHpRegen;
	private int _addMpRegen;
	private int _addHp;
	private int _addMp;
	private int _addMr;

	public void setFireResist(int resist) { _fireResist = resist; }
	public int getFireResist() { return _fireResist; }
	public void setWaterResist(int resist) { _waterResist = resist; }
	public int getWaterResist() { return _waterResist; }
	public void setEarthResist(int resist) { _earthResist = resist; }
	public int getEarthResist() { return _earthResist; }
	public void setWindResist(int resist) { _windResist = resist; }
	public int getWindResist() { return _windResist; }
	public void setAddSpellpower(int spellpower) { _addSpellpower = spellpower; }
	public int getAddSpellpower() { return _addSpellpower; }
	public void setAddHpRegen(int regen) { _addHpRegen = regen; }
	public int getAddHpRegen() { return _addHpRegen; }
	public void setAddMpRegen(int regen) { _addMpRegen = regen; }
	public int getAddMpRegen() { return _addMpRegen; }
	public void setAddHp(int points) { _addHp = points; }
	public int getAddHp() { return _addHp; }
	public void setAddMp(int points) { _addMp = points; }
	public int getAddMp() { return _addMp; }
	public void setMagicResist(int resist) { _addMr = resist; }
	public int getMagicResist() { return _addMr; }

	public void setSkillArmorEnchant(L1PcInstance pc, int skillId, 
			int skillTime) {
		int type = getItem().getType();
		int type2 = getItem().getType2();
		if (_isRunning) {
			_timer.cancel();
			int itemId = getItem().getItemId();
			if (pc != null && pc.getInventory().checkItem(itemId)) {
				if (type == 2 && type2 == 2 && isEquipped()) {
					pc.addAc(3);
					pc.sendPackets(new S_OwnCharStatus(pc));
				}
			}
			setAcByMagic(0);
			_isRunning = false;
			_timer = null;
		}

		if (type == 2 && type2 == 2 && isEquipped()) {
			pc.addAc(-3);
			pc.sendPackets(new S_OwnCharStatus(pc));
		}
		setAcByMagic(3);
		_pc = pc;
		_timer = new EnchantTimer();
		(new Timer()).schedule(_timer, skillTime);
		_isRunning = true;
	}

	public void setSkillWeaponEnchant(L1PcInstance pc, int skillId,
			int skillTime) {
		if (getItem().getType2() != 1) {
			return;
		}
		if (_isRunning) {
			_timer.cancel();
			setDmgByMagic(0);
			setHolyDmgByMagic(0);
			setHitByMagic(0);
			_isRunning = false;
			_timer = null;
		}

		switch(skillId) {
			case HOLY_WEAPON:
				setHolyDmgByMagic(1);
				setHitByMagic(1);
				break;

			case ENCHANT_WEAPON:
				setDmgByMagic(2);
				break;

			case BLESS_WEAPON:
				setDmgByMagic(2);
				setHitByMagic(2);
				break;

			case SHADOW_FANG:
				setDmgByMagic(5);
				break;

			default:
				break;
		}

		_pc = pc;
		_timer = new EnchantTimer();
		(new Timer()).schedule(_timer, skillTime);
		_isRunning = true;
	}

	private int _itemOwnerId = 0;

	public int getItemOwnerId() {
	return _itemOwnerId;
	}

	public void setItemOwnerId(int i) {
		_itemOwnerId = i;
	}

	public void startItemOwnerTimer(L1PcInstance pc) {
		setItemOwnerId(pc.getId());
		L1ItemOwnerTimer timer = new L1ItemOwnerTimer(this, 10000);
		timer.begin();
	}

	private L1EquipmentTimer _equipmentTimer;

	public void startEquipmentTimer(L1PcInstance pc) {
		if (getRemainingTime() > 0) {
			_equipmentTimer = new L1EquipmentTimer(pc, this);
			Timer timer = new Timer(true);
			timer.scheduleAtFixedRate(_equipmentTimer, 1000, 1000);
		}
	}

	public void stopEquipmentTimer(L1PcInstance pc) {
		if (getRemainingTime() > 0) {
			_equipmentTimer.cancel();
			_equipmentTimer = null;
		}
	}

	private boolean _isNowLighting = false;

	public boolean isNowLighting() {
	return _isNowLighting;
	}

	public void setNowLighting(boolean flag) {
		_isNowLighting = flag;
	}

}
