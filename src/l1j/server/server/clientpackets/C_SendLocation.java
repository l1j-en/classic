package l1j.server.server.clientpackets;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.network.Client;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_SendLocation;
import l1j.server.server.templates.L1BookMark;

public class C_SendLocation extends ClientBasePacket {
	private static final String C_SEND_LOCATION = "[C] C_SendLocation";
	private static Logger _log = LoggerFactory.getLogger(C_SendLocation.class.getName());

	public C_SendLocation(byte abyte0[], Client client) {
		super(abyte0);
		int type = readC();

		// This is an unknown packet.. Don't know what it is, but it currently needs to be dropped
		if (type == 0x0d) {
			return;
		}

		if (type == 0x0b) {
			String name = readS();
			int mapId = readH();
			int x = readH();
			int y = readH();
			int msgId = readC();

			if (name.isEmpty()) {
				return;
			}
			
			L1PcInstance target = L1World.getInstance().getPlayer(name);
			if (target != null) {
				L1PcInstance pc = client.getActiveChar();
				String sender = pc.getName();
				target.sendPackets(new S_SendLocation(type, sender, mapId, x, y, msgId));
			}
		} else if(type == 0x27) { //rename bookmark
			int count = readCH();
			readC(); //unknown
			
			for(int i = 0; i < count; i++) {		
				int bookmarkId = readD();
				String bookmarkName = readS();

				L1PcInstance pc = client.getActiveChar();
				L1BookMark existing = pc.getBookMark(bookmarkId);
				if(existing != null) {
					L1BookMark.updateBookmark(pc, bookmarkId, bookmarkName);
				}
			}
		} else if(type == 0x22) { //save bookmarks
			L1PcInstance pc = client.getActiveChar();
			
			int size = pc.getBookMarkSize();
			readC();
			// clear the quicklist to save the new one
            for (int i = 0; i < size; i++) {
                int index = readC();
                
                L1BookMark bookmark = pc.getBookMarkByIndex(index);
            	if(bookmark == null) {
            		_log.warn(String.format("User %s attempted to update a bookmark not in their current bookmark list!",
            				pc.getName()));
            		continue;
            	}
            	
            	bookmark.setQuick(false);
            }
            
            ArrayList<Integer> quickLinks = new ArrayList<Integer>();
            // check for the quicklist bookmarks
            for (int i = 0; i < 5; i++) {
            	int index = readC();
            	
            	if (index == 255) 
            		break;
            	
            	L1BookMark bookmark = pc.getBookMarkByIndex(index);
            	if(bookmark == null) {
            		_log.warn(String.format("User %s attempted to add a quicklist bookmark not in their current bookmark list!",
            				pc.getName()));
            		continue;
            	}
            	
            	bookmark.setQuick(true);
            	quickLinks.add(bookmark.getId());
            }
            
        	L1BookMark.setQuickList(pc, quickLinks);
		} else if (type == 0x06) { //TODO -- Dragon Raid
			/*int objectId = readD();
			int gate = readD();
			int dragonGate[] = {91051, 91052, 91053, 91054 };
			L1PcInstance pc = client.getActiveChar();
			if (gate >= 0 && gate <= 3) {
				Calendar nowTime = Calendar.getInstance();
				if (nowTime.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY
						&& nowTime.get(Calendar.HOUR_OF_DAY) >= 8
						&& nowTime.get(Calendar.HOUR_OF_DAY) < 12) {
					pc.sendPackets(new S_ServerMessage(1643));
					// 火曜日午前7時から10時まではドラゴンキーを使用できません。
				} else {
					boolean limit = true;
					switch (gate) {
					case 0: // アンタラス
						for (int i = 0; i < 6; i++) {
							if (!L1DragonSlayer.getInstance().getPortalNumber()[i]) {
								limit = false;
								break;
							}
						}
						break;
					case 1: // パプリオン
						for (int i = 6; i < 12; i++) {
							if (!L1DragonSlayer.getInstance().getPortalNumber()[i]) {
								limit = false;
								break;
							}
						}
						break;
					case 2: // リンドビオル
						for (int i = 12; i < 18; i++) {
							if (!L1DragonSlayer.getInstance().getPortalNumber()[i]) {
								limit = false;
								break;
							}
						}
						break;
					case 3: // ヴァラカス
						for (int i = 18; i < 24; i++) {
							if (!L1DragonSlayer.getInstance().getPortalNumber()[i]) {
								limit = false;
								break;
							}
						}
						break;
					}
					if (!limit) { // インスタンスダンジョンの空きがある場合
						if (!pc.getInventory().consumeItem(50501, 1)) {
							pc.sendPackets(new S_ServerMessage(1566));
							// ドラゴンキーが必要です。
							return;
						}
						L1SpawnUtil.spawn(pc, dragonGate[gate], 0, 60 * 60 * 2 * 1000); // 2時間
						for (L1PcInstance listner : L1World.getInstance().getAllPlayers()) {
							if (!listner.getExcludingList().contains(pc.getName())) {
								if (listner.isShowTradeChat() || listner.isShowWorldChat()) {
									listner.sendPackets(new S_ServerMessage(2921));
									// 鋼鉄ギルド ドワーフ：うむ…ドラゴンの鳴き声がここまで聞こえてくる。
									// きっと誰かがドラゴンポータルを開いたに違いない！
									// 準備ができたドラゴン スレイヤーに栄光と祝福を！
								}
							}
						}
					}
				}
			}*/
		} else if (type == 0x09){
			L1PcInstance pc = client.getActiveChar();
			pc.sendPackets(new S_PacketBox(S_PacketBox.DISPLAY_MAP_TIME,
					pc.getEnterTime(53),   // Giran Prison
					pc.getEnterTime(78),   // Ivory Tower
					pc.getEnterTime(451),  // Lastabad
					pc.getEnterTime(30))); // Dragon Valley
		} else if (type == 0x13) { // web center
			// not yet
		} else if (type == 0x2C) { // Reset monsters killed
			L1PcInstance pc = client.getActiveChar();
			pc.setMonsterKill(0);
		}
	}

	@Override
	public String getType() {
		return C_SEND_LOCATION;
	}
}
