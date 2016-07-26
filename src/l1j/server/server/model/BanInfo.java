package l1j.server.server.model;

import java.util.Date;

public class BanInfo {
	private String _action;
	private String _targetAccountName;
	private String _actionerAccountName;
	private String _message;
	private Date _actionDate;
	
	public String getAction(){
		return this._action;
	}
	
	public String getTargetAccountName() {
		return this._targetAccountName;
	}
	
	public String getActionerAccountName() {
		return this._actionerAccountName;	
	}
	
	public String getMessage() {
		return this._message;
	}
	
	public Date getActionDate() {
		return this._actionDate;
	}
	
	public BanInfo(String action, String targetAccountName, String actionerAccountName, String message,
			Date actionDate) {
		this._action = action;
		this._targetAccountName = targetAccountName;
		this._actionerAccountName = actionerAccountName;
		this._message = message;
		this._actionDate = actionDate;
	}
}
