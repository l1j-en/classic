package l1j.server.server.controllers.dungeon;

import l1j.server.server.model.Instance.L1PcInstance;

public interface TimedDungeonInstance {
	public String getName();
	public void enter(L1PcInstance player);
	public void run();
	public void reset();
}
