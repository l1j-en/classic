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
package l1j.server.server.utils;

public class RandomArrayList {
	private static int listint = 0;
	private static double[] ArrayDouble = new double[32767];

	public static void setArrayList() {
		for (listint = 0; listint < 32767; listint++) {
			ArrayDouble[listint] = Math.random();
		}
	}

    private static int getlistint() {
        if (listint < 32766)
                return ++listint;
        else
                return listint = 0;
    }

    public static void getByte(byte[] arr) {
        for(int i = 0; i < arr.length; i++)
                arr[i] = (byte) getValue(128);
    }

    private static boolean haveNextGaussian = false;
    private static double nextGaussian;

    public static double getGaussian() {
        if (haveNextGaussian) {
                haveNextGaussian = false;
                return nextGaussian;
        } else {
                double v1, v2, s;
                do {
                        v1 = 2 * ArrayDouble[getlistint()] - 1;   // between -1.0 and 1.0
                        v2 = 2 * ArrayDouble[getlistint()] - 1;   // between -1.0 and 1.0
                        s = v1 * v1 + v2 * v2;
                } while (s >= 1 || s == 0);
                double multiplier = Math.sqrt(-2 * Math.log(s)/s);
                nextGaussian = v2 * multiplier;
                haveNextGaussian = true;
                return v1 * multiplier;
         }
    }

    private static double getValue() {
        return ArrayDouble[getlistint()];
    }

    private static double getValue(int rang) {
        return getValue() * rang;
    }

    private static double getValue(double rang) {
        return getValue() * rang;
    }

	public static int getInt(int rang) {
		return (int) (ArrayDouble[getlistint()] * rang);
	}
	public static int getInt(double rang) {
		return (int) (ArrayDouble[getlistint()] * rang);
	}

	public static int getInc(int rang, int increase) {
		return getInt(rang) + increase;
	}
	public static int getInc(double rang, int increase) {
		return getInt(rang) + increase;
	}
}