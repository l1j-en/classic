package l1j.server.server.templates;


public class L1CharacterBuff {
	private final int _characterId;
	private final int _skillId;
	private final int _remainingTime;
	private final int _polyId;
	private final int _attrKind;

	public L1CharacterBuff(int charcterId, int skillId, int remainingTime,
			int polyId, int attrKind) {
		_characterId = charcterId;
		_skillId = skillId;
		_remainingTime = remainingTime;
		_polyId = polyId;
		_attrKind = attrKind;
	}

	public int getCharcterId() {
		return _characterId;
	}

	public int getSkillId() {
		return _skillId;
	}

	public int getRemainingTime() {
		return _remainingTime;
	}

	public int getPolyId() {
		return _polyId;
	}

	public int getAttrKind() {
		return _attrKind;
	}
}
