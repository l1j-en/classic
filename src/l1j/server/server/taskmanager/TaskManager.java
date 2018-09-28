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
package l1j.server.server.taskmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javolution.util.FastList;
import javolution.util.FastMap;
import l1j.server.L1DatabaseFactory;
import l1j.server.server.taskmanager.tasks.TaskRestart;
import l1j.server.server.taskmanager.tasks.TaskShutdown;
import l1j.server.server.utils.SQLUtil;

/**
 * @author Layane
 * 
 */
public final class TaskManager {
	protected static final Logger _log = LoggerFactory.getLogger(TaskManager.class
			.getName());
	private static TaskManager _instance;

	protected static final String[] SQL_STATEMENTS = {
			"SELECT id,task,type,last_activation,param1,param2,param3 FROM global_tasks",
			"UPDATE global_tasks SET last_activation=? WHERE id=?",
			"SELECT id FROM global_tasks WHERE task=?",
			"INSERT INTO global_tasks (task,type,last_activation,param1,param2,param3) VALUES(?,?,?,?,?,?)" };

	private final FastMap<Integer, Task> _tasks = new FastMap<Integer, Task>();
	protected final FastList<ExecutedTask> _currentTasks = new FastList<ExecutedTask>();

	public class ExecutedTask implements Runnable {
		int _id;
		long _lastActivation;
		Task _task;
		TaskTypes _type;
		String[] _params;
		ScheduledFuture<?> _scheduled;

		public ExecutedTask(Task task, TaskTypes type, ResultSet rset)
				throws SQLException {
			_task = task;
			_type = type;
			_id = rset.getInt("id");
			_lastActivation = rset.getLong("last_activation");
			_params = new String[] { rset.getString("param1"),
					rset.getString("param2"), rset.getString("param3") };
		}

		public void run() {
			Thread.currentThread().setName("TaskManager");
			_task.onTimeElapsed(this);
			_lastActivation = System.currentTimeMillis();
			java.sql.Connection con = null;
			PreparedStatement pstm = null;
			try {
				con = L1DatabaseFactory.getInstance().getConnection();
				pstm = con.prepareStatement(SQL_STATEMENTS[1]);
				pstm.setLong(1, _lastActivation);
				pstm.setInt(2, _id);
				pstm.executeUpdate();
			} catch (SQLException e) {
				_log.warn("cannot updated the Global Task " + _id + ": "
						+ e.getMessage());
			} finally {
				SQLUtil.close(pstm);
				SQLUtil.close(con);
			}
		}

		@Override
		public boolean equals(Object object) {
			return _id == ((ExecutedTask) object)._id;
		}
		
		@Override
		public int hashCode() {
			return _id;
		}
		public Task getTask() {
			return _task;
		}

		public TaskTypes getType() {
			return _type;
		}

		public int getId() {
			return _id;
		}

		public String[] getParams() {
			return _params;
		}

		public long getLastActivation() {
			return _lastActivation;
		}

		public void stopTask() {
			_task.onDestroy();
			if (_scheduled != null) {
				_scheduled.cancel(true);
			}
			_currentTasks.remove(this);
		}
	}

	public static TaskManager getInstance() {
		if (_instance == null) {
			_instance = new TaskManager();
		}
		return _instance;
	}

	public TaskManager() {
		initializate();
		startAllTasks();
	}

	private void initializate() {
		registerTask(new TaskRestart());
		registerTask(new TaskShutdown());
	}

	public void registerTask(Task task) {
		int key = task.getName().hashCode();
		if (!_tasks.containsKey(key)) {
			_tasks.put(key, task);
			task.initializate();
		}
	}

	private void startAllTasks() {
		java.sql.Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement(SQL_STATEMENTS[0]);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Task task = _tasks.get(rs.getString("task").trim()
						.toLowerCase().hashCode());

				if (task == null) {
					continue;
				}
				// TODO Not used
				//TaskTypes type = TaskTypes.valueOf(rs.getString("type"));
				// TaskTypes type = TaskTypes.valueOf(rs.getString("type"));
			}
		} catch (Exception e) {
			_log.error("error while loading Global Task table", e);
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException ignore) {
					// ignore
				}
				rs = null;
			}
			if (null != pstm) {
				try {
					pstm.close();
				} catch (SQLException ignore) {
					// ignore
				}
				pstm = null;
			}
			if (null != con) {
				try {
					con.close();
				} catch (SQLException ignore) {
					// ignore
				}
				con = null;
			}
		}
	}

//	private boolean launchTask(ExecutedTask task) {
//		final ThreadPoolManager scheduler = ThreadPoolManager.getInstance();
//		final TaskTypes type = task.getType();
//
//		if (type == TYPE_GLOBAL_TASK) {
//			long interval = Long.valueOf(task.getParams()[0]) * 86400000L;
//			String[] hour = task.getParams()[1].split(":");
//
//			if (hour.length != 3) {
//				_log.warn("Task " + task.getId()
//						+ " has incorrect parameters");
//				return false;
//			}
//			Calendar check = Calendar.getInstance();
//			check.setTimeInMillis(task.getLastActivation() + interval);
//			Calendar min = Calendar.getInstance();
//			try {
//				min.set(Calendar.HOUR_OF_DAY, Integer.valueOf(hour[0]));
//				min.set(Calendar.MINUTE, Integer.valueOf(hour[1]));
//				min.set(Calendar.SECOND, Integer.valueOf(hour[2]));
//			} catch (Exception e) {
//				_log.warn("Bad parameter on task " + task.getId() + ": "
//						+ e.getMessage());
//				return false;
//			}
//			long delay = min.getTimeInMillis() - System.currentTimeMillis();
//
//			if (check.after(min) || delay < 0) {
//				delay += interval;
//			}
//			task._scheduled = scheduler.scheduleGeneralAtFixedRate(task, delay,
//					interval);
//			return true;
//		}
//		return false;
//	}

	public static boolean addUniqueTask(String task, TaskTypes type,
			String param1, String param2, String param3) {
		return addUniqueTask(task, type, param1, param2, param3, 0);
	}

	public static boolean addUniqueTask(String task, TaskTypes type,
			String param1, String param2, String param3, long lastActivation) {
		//java.sql.Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try (Connection con = L1DatabaseFactory.getInstance().getConnection();){
			//con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement(SQL_STATEMENTS[2]);
			pstm.setString(1, task);
			rs = pstm.executeQuery();
			pstm.close();
			if (!rs.next()) {
				pstm = con.prepareStatement(SQL_STATEMENTS[3]);
				pstm.setString(1, task);
				pstm.setString(2, type.toString());
				pstm.setLong(3, lastActivation);
				pstm.setString(4, param1);
				pstm.setString(5, param2);
				pstm.setString(6, param3);
				pstm.execute();
			}
			return true;
		} catch (SQLException e) {
			_log.warn("cannot add the unique task: " + e.getMessage());
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			//SQLUtil.close(con);
		}
		return false;
	}

	public static boolean addTask(String task, TaskTypes type, String param1,
			String param2, String param3) {
		return addTask(task, type, param1, param2, param3, 0);
	}

	public static boolean addTask(String task, TaskTypes type, String param1,
			String param2, String param3, long lastActivation) {
		java.sql.Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement(SQL_STATEMENTS[3]);
			pstm.setString(1, task);
			pstm.setString(2, type.toString());
			pstm.setLong(3, lastActivation);
			pstm.setString(4, param1);
			pstm.setString(5, param2);
			pstm.setString(6, param3);
			pstm.execute();
			return true;
		} catch (SQLException e) {
			_log.error("cannot add the task", e);
		} finally {
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
		return false;
	}
}