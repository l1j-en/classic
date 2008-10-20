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
package l1j.server.server.model;

public class L1NpcTalkData {

	int ID;

	int NpcID;

	String normalAction;

	String caoticAction;

	String teleportURL;

	String teleportURLA;

	/**
	 * @return Returns the normalAction.
	 */
	public String getNormalAction() {
		return normalAction;
	}

	/**
	 * @param normalAction
	 *            The normalAction to set.
	 */
	public void setNormalAction(String normalAction) {
		this.normalAction = normalAction;
	}

	/**
	 * @return Returns the caoticAction.
	 */
	public String getCaoticAction() {
		return caoticAction;
	}

	/**
	 * @param caoticAction
	 *            The caoticAction to set.
	 */
	public void setCaoticAction(String caoticAction) {
		this.caoticAction = caoticAction;
	}

	/**
	 * @return Returns the teleportURL.
	 */
	public String getTeleportURL() {
		return teleportURL;
	}

	/**
	 * @param teleportURL
	 *            The teleportURL to set.
	 */
	public void setTeleportURL(String teleportURL) {
		this.teleportURL = teleportURL;
	}

	/**
	 * @return Returns the teleportURLA.
	 */
	public String getTeleportURLA() {
		return teleportURLA;
	}

	/**
	 * @param teleportURLA
	 *            The teleportURLA to set.
	 */
	public void setTeleportURLA(String teleportURLA) {
		this.teleportURLA = teleportURLA;
	}

	/**
	 * @return Returns the iD.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param id
	 *            The iD to set.
	 */
	public void setID(int id) {
		ID = id;
	}

	/**
	 * @return Returns the npcID.
	 */
	public int getNpcID() {
		return NpcID;
	}

	/**
	 * @param npcID
	 *            The npcID to set.
	 */
	public void setNpcID(int npcID) {
		NpcID = npcID;
	}

}
