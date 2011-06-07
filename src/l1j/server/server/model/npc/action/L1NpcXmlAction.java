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
package l1j.server.server.model.npc.action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.w3c.dom.Element;

import l1j.server.server.model.L1Object;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.npc.L1NpcHtml;
import l1j.server.server.utils.IntRange;

public abstract class L1NpcXmlAction implements L1NpcAction {
	private String _name;
	private final int _npcIds[];
	private final IntRange _level;
	private final int _questId;
	private final int _questStep;
	private final int _classes[];

	public L1NpcXmlAction(Element element) {
		_name = element.getAttribute("Name");
		_name = _name.equals("") ? null : _name;
		_npcIds = parseNpcIds(element.getAttribute("NpcId"));
		_level = parseLevel(element);
		_questId = L1NpcXmlParser.parseQuestId(element.getAttribute("QuestId"));
		_questStep = L1NpcXmlParser.parseQuestStep(element
				.getAttribute("QuestStep"));

		_classes = parseClasses(element);
	}

	private int[] parseClasses(Element element) {
		String classes = element.getAttribute("Class").toUpperCase();
		int result[] = new int[classes.length()];
		int idx = 0;
		for (Character cha : classes.toCharArray()) {
			result[idx++] = _charTypes.get(cha);
		}
		Arrays.sort(result);
		return result;
	}

	private IntRange parseLevel(Element element) {
		int level = L1NpcXmlParser.getIntAttribute(element, "Level", 0);
		int min = L1NpcXmlParser.getIntAttribute(element, "LevelMin", 1);
		int max = L1NpcXmlParser.getIntAttribute(element, "LevelMax", 99);
		return level == 0 ? new IntRange(min, max) : new IntRange(level, level);
	}

	private final static Map<Character, Integer> _charTypes = new HashMap<Character, Integer>();
	static {
		_charTypes.put('P', 0);
		_charTypes.put('K', 1);
		_charTypes.put('E', 2);
		_charTypes.put('W', 3);
		_charTypes.put('D', 4);
		_charTypes.put('R', 5);
		_charTypes.put('I', 6);
	}

	private int[] parseNpcIds(String npcIds) {
		StringTokenizer tok = new StringTokenizer(npcIds.replace(" ", ""), ",");
		int result[] = new int[tok.countTokens()];
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt(tok.nextToken());
		}
		Arrays.sort(result);
		return result;
	}

	private boolean acceptsNpcId(L1Object obj) {
		if (0 < _npcIds.length) {
			if (!(obj instanceof L1NpcInstance)) {
				return false;
			}
			int npcId = ((L1NpcInstance) obj).getNpcTemplate().get_npcId();

			if (Arrays.binarySearch(_npcIds, npcId) < 0) {
				return false;
			}
		}
		return true;
	}

	private boolean acceptsLevel(int level) {
		return _level.includes(level);
	}

	private boolean acceptsCharType(int type) {
		if (0 < _classes.length) {
			if (Arrays.binarySearch(_classes, type) < 0) {
				return false;
			}
		}
		return true;
	}

	private boolean acceptsActionName(String name) {
		if (_name == null) {
			return true;
		}
		return name.equals(_name);
	}

	private boolean acceptsQuest(L1PcInstance pc) {
		if (_questId == -1) {
			return true;
		}
		if (_questStep == -1) {
			return 0 < pc.getQuest().get_step(_questId);
		}
		return pc.getQuest().get_step(_questId) == _questStep;
	}

	public boolean acceptsRequest(String actionName, L1PcInstance pc,
			L1Object obj) {
		if (!acceptsNpcId(obj)) {
			return false;
		}
		if (!acceptsLevel(pc.getLevel())) {
			return false;
		}
		if (!acceptsQuest(pc)) {
			return false;
		}
		if (!acceptsCharType(pc.getType())) {
			return false;
		}
		if (!acceptsActionName(actionName)) {
			return false;
		}
		return true;
	}

	public abstract L1NpcHtml execute(String actionName, L1PcInstance pc,
			L1Object obj, byte args[]);

	public L1NpcHtml executeWithAmount(String actionName, L1PcInstance pc,
			L1Object obj, int amount) {
		return null;
	}
}
