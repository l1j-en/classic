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
package l1j.server.server.model.trap;

import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_EffectLocation;
import l1j.server.server.storage.TrapStorage;

public abstract class L1Trap {
	protected final int _id;
	protected final int _gfxId;
	protected final boolean _isDetectionable;

	public L1Trap(TrapStorage storage) {
		_id = storage.getInt("id");
		_gfxId = storage.getInt("gfxId");
		_isDetectionable = storage.getBoolean("isDetectionable");
	}

	public L1Trap(int id, int gfxId, boolean detectionable) {
		_id = id;
		_gfxId = gfxId;
		_isDetectionable = detectionable;
	}

	public int getId() {
		return _id;
	}

	public int getGfxId() {
		return _gfxId;
	}

	protected void sendEffect(L1Object trapObj) {
		if (getGfxId() == 0) {
			return;
		}
		S_EffectLocation effect = new S_EffectLocation(trapObj.getLocation(),
				getGfxId());

		for (L1PcInstance pc : L1World.getInstance()
				.getRecognizePlayer(trapObj)) {
			pc.sendPackets(effect);
		}
	}

	public abstract void onTrod(L1PcInstance trodFrom, L1Object trapObj);

	public void onDetection(L1PcInstance caster, L1Object trapObj) {
		if (_isDetectionable) {
			sendEffect(trapObj);
		}
	}

	public static L1Trap newNull() {
		return new L1NullTrap();
	}
}

class L1NullTrap extends L1Trap {
	public L1NullTrap() {
		super(0, 0, false);
	}

	@Override
	public void onTrod(L1PcInstance trodFrom, L1Object trapObj) {
	}
}
