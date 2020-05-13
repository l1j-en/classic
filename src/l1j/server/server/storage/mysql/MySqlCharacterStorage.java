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
package l1j.server.server.storage.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.datatables.AccessLevelTable;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.storage.CharacterStorage;
import l1j.server.server.utils.SQLUtil;

public class MySqlCharacterStorage implements CharacterStorage {
	private static Logger _log = LoggerFactory.getLogger(MySqlCharacterStorage.class
			.getName());

	@Override
	public L1PcInstance loadCharacter(String charName) {
		L1PcInstance pc = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM characters WHERE char_name=?");
			pstm.setString(1, charName);

			rs = pstm.executeQuery();
			if (!rs.next()) {
				return null;
			}
			pc = new L1PcInstance();
			pc.setAccountName(rs.getString("account_name"));
			pc.setId(rs.getInt("objid"));
			pc.setName(rs.getString("char_name"));
			pc.setBirthday((Timestamp) rs.getTimestamp("birthday"));
			pc.setHighLevel(rs.getInt("HighLevel"));
			pc.setExp(rs.getInt("Exp"));
			pc.addBaseMaxHp(rs.getShort("MaxHp"));
			short currentHp = rs.getShort("CurHp");
			if (currentHp < 1) {
				currentHp = 1;
			}
			pc.setCurrentHpDirect(currentHp);
			pc.setDead(false);
			pc.setStatus(0);
			pc.addBaseMaxMp(rs.getShort("MaxMp"));
			pc.setCurrentMpDirect(rs.getShort("CurMp"));
			pc.addBaseStr(rs.getByte("Str"));
			pc.addBaseCon(rs.getByte("Con"));
			pc.addBaseDex(rs.getByte("Dex"));
			pc.addBaseCha(rs.getByte("Cha"));
			pc.addBaseInt(rs.getByte("Intel"));
			pc.addBaseWis(rs.getByte("Wis"));
			int status = rs.getInt("Status");
			pc.setCurrentWeapon(status);
			int classId = rs.getInt("Class");
			pc.setClassId(classId);
			pc.setTempCharGfx(classId);
			pc.setGfxId(classId);
			pc.set_sex(rs.getInt("Sex"));
			pc.setType(rs.getInt("Type"));
			int head = rs.getInt("Heading");
			if (head > 7) {
				head = 0;
			}
			pc.setHeading(head);
			pc.setX(rs.getInt("locX"));
			pc.setY(rs.getInt("locY"));
			pc.setMap(rs.getShort("MapID"));
			pc.set_food(rs.getInt("Food"));
			pc.setLawful(rs.getInt("Lawful"));
			pc.setTitle(rs.getString("Title"));
			pc.setClanid(rs.getInt("ClanID"));
			pc.setClanname(rs.getString("Clanname"));
			pc.setClanRank(rs.getInt("ClanRank"));
			pc.setBonusStats(rs.getInt("BonusStatus"));
			pc.setElixirStats(rs.getInt("ElixirStatus"));
			pc.setElfAttr(rs.getInt("ElfAttr"));
			pc.set_PKcount(rs.getInt("PKcount"));
			pc.setPkCountForElf(rs.getInt("PkCountForElf"));
			pc.setExpRes(rs.getInt("ExpRes"));
			pc.setPartnerId(rs.getInt("PartnerID"));
			pc.setGmInvis(false);
			pc.setAccessLevel(AccessLevelTable.getInstance().getAccessLevel((short)rs.getInt("AccessLevel")));
			
			if (pc.getAccessLevel().getLevel() >= Config.MIN_GM_ACCESS_LEVEL)
				pc.setGm(true);
			
			pc.setOnlineStatus(rs.getInt("OnlineStatus"));
			pc.setHomeTownId(rs.getInt("HomeTownID"));
			pc.setContribution(rs.getInt("Contribution"));
			pc.setHellTime(rs.getInt("HellTime"));
			pc.setBanned(rs.getBoolean("Banned"));
			pc.setKarma(rs.getInt("Karma"));
			pc.setLastPk(rs.getTimestamp("LastPk"));
			pc.setLastPkForElf(rs.getTimestamp("LastPkForElf"));
			pc.setDeleteTime(rs.getTimestamp("DeleteTime"));
			pc.setOriginalStr(rs.getInt("OriginalStr"));
			pc.setOriginalCon(rs.getInt("OriginalCon"));
			pc.setOriginalDex(rs.getInt("OriginalDex"));
			pc.setOriginalCha(rs.getInt("OriginalCha"));
			pc.setOriginalInt(rs.getInt("OriginalInt"));
			pc.setOriginalWis(rs.getInt("OriginalWis"));
			
			Timestamp lastJoinedPledge = rs.getTimestamp("date_joined_pledge");
			pc.setLastJoinedPledge(lastJoinedPledge == null ? 0 : lastJoinedPledge.getTime());
			
			pc.refresh();
			pc.setMoveSpeed(0);
			pc.setBraveSpeed(0);
			_log.trace("restored char data: ");
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
			return null;
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return pc;
	}

	@Override
	public void createCharacter(L1PcInstance pc) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			int i = 0;
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("INSERT INTO characters SET account_name=?,objid=?,char_name=?,birthday=?,level=?,HighLevel=?,Exp=?,MaxHp=?,CurHp=?,MaxMp=?,CurMp=?,Ac=?,Str=?,Con=?,Dex=?,Cha=?,Intel=?,Wis=?,Status=?,Class=?,Sex=?,Type=?,Heading=?,LocX=?,LocY=?,MapID=?,Food=?,Lawful=?,Title=?,ClanID=?,Clanname=?,ClanRank=?,BonusStatus=?,ElixirStatus=?,ElfAttr=?,PKcount=?,PkCountForElf=?,ExpRes=?,PartnerID=?,AccessLevel=?,OnlineStatus=?,HomeTownID=?,Contribution=?,Pay=?,HellTime=?,Banned=?,Karma=?,LastPk=?,LastPkForElf=?,DeleteTime=?");
			pstm.setString(++i, pc.getAccountName());
			pstm.setInt(++i, pc.getId());
			pstm.setString(++i, pc.getName());
			pstm.setTimestamp(++i, pc.getBirthday());
			pstm.setInt(++i, pc.getLevel());
			pstm.setInt(++i, pc.getHighLevel());
			pstm.setInt(++i, pc.getExp());
			pstm.setInt(++i, pc.getBaseMaxHp());
			int hp = pc.getCurrentHp();
			if (hp < 1) {
				hp = 1;
			}
			pstm.setInt(++i, hp);
			pstm.setInt(++i, pc.getBaseMaxMp());
			pstm.setInt(++i, pc.getCurrentMp());
			pstm.setInt(++i, pc.getAc());
			pstm.setInt(++i, pc.getBaseStr());
			pstm.setInt(++i, pc.getBaseCon());
			pstm.setInt(++i, pc.getBaseDex());
			pstm.setInt(++i, pc.getBaseCha());
			pstm.setInt(++i, pc.getBaseInt());
			pstm.setInt(++i, pc.getBaseWis());
			pstm.setInt(++i, pc.getCurrentWeapon());
			pstm.setInt(++i, pc.getClassId());
			pstm.setInt(++i, pc.get_sex());
			pstm.setInt(++i, pc.getType());
			pstm.setInt(++i, pc.getHeading());
			pstm.setInt(++i, pc.getX());
			pstm.setInt(++i, pc.getY());
			pstm.setInt(++i, pc.getMapId());
			pstm.setInt(++i, pc.get_food());
			pstm.setInt(++i, pc.getLawful());
			pstm.setString(++i, pc.getTitle());
			pstm.setInt(++i, pc.getClanid());
			pstm.setString(++i, pc.getClanname());
			pstm.setInt(++i, pc.getClanRank());
			pstm.setInt(++i, pc.getBonusStats());
			pstm.setInt(++i, pc.getElixirStats());
			pstm.setInt(++i, pc.getElfAttr());
			pstm.setInt(++i, pc.get_PKcount());
			pstm.setInt(++i, pc.getPkCountForElf());
			pstm.setInt(++i, pc.getExpRes());
			pstm.setInt(++i, pc.getPartnerId());
			pstm.setShort(++i, pc.getAccessLevel().getId());
			pstm.setInt(++i, pc.getOnlineStatus());
			pstm.setInt(++i, pc.getHomeTownId());
			pstm.setInt(++i, pc.getContribution());
			pstm.setInt(++i, 0);
			pstm.setInt(++i, pc.getHellTime());
			pstm.setBoolean(++i, pc.isBanned());
			pstm.setInt(++i, pc.getKarma());
			pstm.setTimestamp(++i, pc.getLastPk());
			pstm.setTimestamp(++i, pc.getLastPkForElf());
			pstm.setTimestamp(++i, pc.getDeleteTime());
			pstm.execute();
			_log.trace("stored char data: " + pc.getName());
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	@Override
	public void deleteCharacter(String accountName, String charName)
			throws Exception {
		//Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try (Connection con = L1DatabaseFactory.getInstance().getConnection();){
			//con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("SELECT * FROM characters WHERE account_name=? AND char_name=?");
			pstm.setString(1, accountName);
			pstm.setString(2, charName);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				_log.warn("invalid delete char request: account="
						+ accountName + " char=" + charName);
				throw new RuntimeException("could not delete character");
			}
			pstm.close();
			pstm = con
					.prepareStatement("DELETE FROM character_buddys WHERE char_id IN (SELECT objid FROM characters WHERE char_name = ?)");
			pstm.setString(1, charName);
			pstm.execute();
			pstm = con
					.prepareStatement("DELETE FROM character_buff WHERE char_obj_id IN (SELECT objid FROM characters WHERE char_name = ?)");
			pstm.setString(1, charName);
			pstm.execute();
			pstm = con
					.prepareStatement("DELETE FROM character_config WHERE object_id IN (SELECT objid FROM characters WHERE char_name = ?)");
			pstm.setString(1, charName);
			pstm.execute();
			pstm = con
					.prepareStatement("DELETE FROM character_items WHERE char_id IN (SELECT objid FROM characters WHERE char_name = ?)");
			pstm.setString(1, charName);
			pstm.execute();
			pstm = con
					.prepareStatement("DELETE FROM character_quests WHERE char_id IN (SELECT objid FROM characters WHERE char_name = ?)");
			pstm.setString(1, charName);
			pstm.execute();
			pstm = con
					.prepareStatement("DELETE FROM character_skills WHERE char_obj_id IN (SELECT objid FROM characters WHERE char_name = ?)");
			pstm.setString(1, charName);
			pstm.execute();
			pstm = con
					.prepareStatement("DELETE FROM character_teleport WHERE char_id IN (SELECT objid FROM characters WHERE char_name = ?)");
			pstm.setString(1, charName);
			pstm.execute();
			pstm = con
					.prepareStatement("DELETE FROM characters WHERE char_name=?");
			pstm.setString(1, charName);
			pstm.execute();
		} catch (SQLException e) {
			throw e;
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			//SQLUtil.close(con);
		}
	}

	@Override
	public void storeCharacter(L1PcInstance pc) {
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			int i = 0;
			String statement = "UPDATE characters SET level=?,HighLevel=?,Exp=?,MaxHp=?,CurHp=?,MaxMp=?,CurMp=?,Ac=?,Str=?,Con=?,Dex=?,Cha=?,Intel=?,Wis=?,Status=?,Class=?,Sex=?,Type=?,Heading=?,LocX=?,LocY=?,MapID=?,Food=?,Lawful=?,Title=?,ClanID=?,Clanname=?,ClanRank=?,BonusStatus=?,ElixirStatus=?,ElfAttr=?,PKcount=?,PkCountForElf=?,ExpRes=?,PartnerID=?,AccessLevel=?,OnlineStatus=?,HomeTownID=?,Contribution=?,HellTime=?,Banned=?,Karma=?,LastPk=?,LastPkForElf=?,DeleteTime=? WHERE objid=?";
			
			if(pc.getLastJoinedPledge() > 0) {
				statement = statement.replace(" WHERE objid=?", ",date_joined_pledge=?  WHERE objid=?");
			}
			
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement(statement);
			pstm.setInt(++i, pc.getLevel());
			pstm.setInt(++i, pc.getHighLevel());
			pstm.setInt(++i, pc.getExp());
			pstm.setInt(++i, pc.getBaseMaxHp());
			int hp = pc.getCurrentHp();
			if (hp < 1) {
				hp = 1;
			}
			pstm.setInt(++i, hp);
			pstm.setInt(++i, pc.getBaseMaxMp());
			pstm.setInt(++i, pc.getCurrentMp());
			pstm.setInt(++i, pc.getAc());
			pstm.setInt(++i, pc.getBaseStr());
			pstm.setInt(++i, pc.getBaseCon());
			pstm.setInt(++i, pc.getBaseDex());
			pstm.setInt(++i, pc.getBaseCha());
			pstm.setInt(++i, pc.getBaseInt());
			pstm.setInt(++i, pc.getBaseWis());
			pstm.setInt(++i, pc.getCurrentWeapon());
			pstm.setInt(++i, pc.getClassId());
			pstm.setInt(++i, pc.get_sex());
			pstm.setInt(++i, pc.getType());
			pstm.setInt(++i, pc.getHeading());
			pstm.setInt(++i, pc.getX());
			pstm.setInt(++i, pc.getY());
			pstm.setInt(++i, pc.getMapId());
			pstm.setInt(++i, pc.get_food());
			pstm.setInt(++i, pc.getLawful());
			pstm.setString(++i, pc.getTitle());
			pstm.setInt(++i, pc.getClanid());
			pstm.setString(++i, pc.getClanname());
			pstm.setInt(++i, pc.getClanRank());
			pstm.setInt(++i, pc.getBonusStats());
			pstm.setInt(++i, pc.getElixirStats());
			pstm.setInt(++i, pc.getElfAttr());
			pstm.setInt(++i, pc.get_PKcount());
			pstm.setInt(++i, pc.getPkCountForElf());
			pstm.setInt(++i, pc.getExpRes());
			pstm.setInt(++i, pc.getPartnerId());
			pstm.setShort(++i, pc.getAccessLevel().getId());
			pstm.setInt(++i, pc.getOnlineStatus());
			pstm.setInt(++i, pc.getHomeTownId());
			pstm.setInt(++i, pc.getContribution());
			pstm.setInt(++i, pc.getHellTime());
			pstm.setBoolean(++i, pc.isBanned());
			pstm.setInt(++i, pc.getKarma());
			pstm.setTimestamp(++i, pc.getLastPk());
			pstm.setTimestamp(++i, pc.getLastPkForElf());
			pstm.setTimestamp(++i, pc.getDeleteTime());
			
			if(pc.getLastJoinedPledge() > 0) {
				pstm.setTimestamp(++i, new Timestamp(pc.getLastJoinedPledge()));
			}
			
			pstm.setInt(++i, pc.getId());
			
			pstm.execute();
			_log.trace("stored char data:" + pc.getName());
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
}