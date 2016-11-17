package com.logistics.model;

import java.util.Date;

public class AnnounceInfo {
	private int announce_Id;
	private String announce_Title;
	private String announce_Content;
	private Date writeTime;
	private int manager_id;

	public int getAnnounce_Id() {
		return announce_Id;
	}

	public void setAnnounce_Id(int announceId) {
		announce_Id = announceId;
	}

	public String getAnnounce_Title() {
		return announce_Title;
	}

	public void setAnnounce_Title(String announceTitle) {
		announce_Title = announceTitle;
	}

	public String getAnnounce_Content() {
		return announce_Content;
	}

	public void setAnnounce_Content(String announceContent) {
		announce_Content = announceContent;
	}

	public Date getWriteTime() {
		return writeTime;
	}

	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int managerId) {
		manager_id = managerId;
	}
}
