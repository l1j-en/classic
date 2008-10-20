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

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class IterableElementList implements Iterable<Element> {
	IterableNodeList _list;

	private class MyIterator implements Iterator<Element> {
		private Iterator<Node> _itr;
		private Element _next = null;

		public MyIterator(Iterator<Node> itr) {
			_itr = itr;
			updateNextElement();
		}

		private void updateNextElement() {
			while (_itr.hasNext()) {
				Node node = _itr.next();
				if (node instanceof Element) {
					_next = (Element) node;
					return;
				}
			}
			_next = null;
		}

		@Override
		public boolean hasNext() {
			return _next != null;
		}

		@Override
		public Element next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Element result = _next;
			updateNextElement();
			return result;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public IterableElementList(NodeList list) {
		_list = new IterableNodeList(list);
	}

	@Override
	public Iterator<Element> iterator() {
		return new MyIterator(_list.iterator());
	}

}
