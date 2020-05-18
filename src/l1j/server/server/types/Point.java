/* This program is free software; you can redistribute it and/or modify
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
package l1j.server.server.types;


public class Point {

	protected int _x = 0;
	protected int _y = 0;

	public Point() {
	}

	public Point(int x, int y) {
		_x = x;
		_y = y;
	}

	public Point(Point pt) {
		_x = pt._x;
		_y = pt._y;
	}

	public int getX() {
		return _x;
	}

	public void setX(int x) {
		_x = x;
	}

	public int getY() {
		return _y;
	}

	public void setY(int y) {
		_y = y;
	}

	public void set(Point pt) {
		_x = pt._x;
		_y = pt._y;
	}

	public void set(int x, int y) {
		_x = x;
		_y = y;
	}

	private static final int HEADING_TABLE_X[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	private static final int HEADING_TABLE_Y[] = { -1, -1, 0, 1, 1, 1, 0, -1 };

	/**
	 * The coordinates to return to the straight line distance.
	 * 
	 * @param heading
	 *            (0~7)
	 */
	public void forward(int heading) {
		_x += HEADING_TABLE_X[heading];
		_y += HEADING_TABLE_Y[heading];
	}

	/**
	 * wtWiB
	 * 
	 * @param heading
	 *            (0~7)
	 */
	public void backward(int heading) {
		_x -= HEADING_TABLE_X[heading];
		_y -= HEADING_TABLE_Y[heading];
	}

	/**
	 * wWB
	 * 
	 * @param pt
	 *            WPointIuWFNg
	 * @return W
	 */
	public double getLineDistance(Point pt) {
		long diffX = pt.getX() - this.getX();
		long diffY = pt.getY() - this.getY();
		return Math.sqrt((diffX * diffX) + (diffY * diffY));
	}

	/**
	 * The number of tiles to coordinate the return straight.
	 * 
	 * @param pt
	 *            Point object to hold coordinate
	 * @return The straight line up to coordinate the number of tiles.
	 */
	public int getTileLineDistance(Point pt) {
		return Math.max(Math.abs(pt.getX() - getX()),
				Math.abs(pt.getY() - getY()));
	}

	/**
	 * The number of tiles to coordinate returned.
	 * 
	 * @param pt
	 *            Point object to hold coordinate
	 * @return The number of tiles to coordinate.
	 */
	public int getTileDistance(Point pt) {
		return Math.abs(pt.getX() - getX()) + Math.abs(pt.getY() - getY());
	}

	/**
	 * The object is to see a return to the screen
	 * 
	 * Players to coordinate (0,0) assuming that coordinates of the sight of The
	 * upper left (2, 18) on the right (18, -2) lower left (-18,2) lower-right
	 * (-2,18).
	 * 
	 * @param pt
	 *            Point object to hold coordinate
	 * @return The object is to see whether the screen.
	 */
	public boolean isInScreen(Point pt) {
		
		int dist = this.getTileDistance(pt);

		if (dist > 22) {
			return false;
		} else if (dist <= 18) {
			return true;
		} else {
			int dist2 = Math.abs(pt.getX() - (this.getX() - 18))
					+ Math.abs(pt.getY() - (this.getY() - 18));
			if (19 <= dist2 && dist2 <= 52) {
				return true;
			}
			return false;
		}
	}

	public boolean isSamePoint(Point pt) {
		return (pt.getX() == getX() && pt.getY() == getY());
	}

	@Override
	public int hashCode() {
		return 7 * getX() + getY();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point)) {
			return false;
		}
		Point pt = (Point) obj;
		return (this.getX() == pt.getX()) && (this.getY() == pt.getY());
	}

	@Override
	public String toString() {
		return String.format("(%d, %d)", _x, _y);
	}
}
