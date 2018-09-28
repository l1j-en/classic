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
package l1j.server.server.templates;

public class L1EtcItem extends L1Item {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public L1EtcItem() {
	}

	private boolean _stackable;

	private int _locx;

	private int _locy;

	private short _mapid;

	private int _delay_id;

	private int _delay_time;

	private int _delay_effect;

	private int _maxChargeCount;

	private boolean _isCanSeal;

	@Override
	public boolean isStackable() {
		return _stackable;
	}

	public void set_stackable(boolean stackable) {
		_stackable = stackable;
	}

	public void set_locx(int locx) {
		_locx = locx;
	}

	@Override
	public int get_locx() {
		return _locx;
	}

	public void set_locy(int locy) {
		_locy = locy;
	}

	@Override
	public int get_locy() {
		return _locy;
	}

	public void set_mapid(short mapid) {
		_mapid = mapid;
	}

	@Override
	public short get_mapid() {
		return _mapid;
	}

	public void set_delayid(int delay_id) {
		_delay_id = delay_id;
	}

	@Override
	public int get_delayid() {
		return _delay_id;
	}

	public void set_delaytime(int delay_time) {
		_delay_time = delay_time;
	}

	@Override
	public int get_delaytime() {
		return _delay_time;
	}

	public void set_delayEffect(int delay_effect) {
		_delay_effect = delay_effect;
	}

	public int get_delayEffect() {
		return _delay_effect;
	}

	public void setMaxChargeCount(int i) {
		_maxChargeCount = i;
	}

	@Override
	public int getMaxChargeCount() {
		return _maxChargeCount;
	}

	@Override
	public boolean isCanSeal() {
		return _isCanSeal;
	}

	public void setCanSeal(boolean flag) {
		_isCanSeal = flag;
	}

}
