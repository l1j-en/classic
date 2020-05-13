package l1j.server.server.log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.SQLUtil;

public class LogGiveItem {
	private static Logger _log = LoggerFactory.getLogger(LogGiveItem.class.getName());

	public void storeLogGiveItem(L1PcInstance pc, L1Character target, L1ItemInstance item,
			int before_inven, int after_inven, int before_target_inv, int after_target_inv, int count) {
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con
					.prepareStatement("INSERT INTO loggiveitem VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			Date time = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String dateFormatter = formatter.format(time.getTime());
			pstm.setString(1, dateFormatter);
			
			pstm.setString(2, pc.getNetConnection().getIp());
			pstm.setString(3, pc.getAccountName());
			pstm.setInt(4, pc.getId());
			pstm.setString(5, pc.getName());
			
			pstm.setInt(6, target.getId());
			pstm.setString(7, target.getName());
			
			pstm.setInt(8, item.getId());
			pstm.setString(9, item.getItem().getName());
			pstm.setInt(10, item.getEnchantLevel());
			pstm.setInt(11, before_inven);
			pstm.setInt(12, after_inven);
			pstm.setInt(13, before_target_inv);
			pstm.setInt(14, after_target_inv);
			pstm.setInt(15, count);
			pstm.execute();
		} catch (SQLException e) {
			_log.error(e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
}
