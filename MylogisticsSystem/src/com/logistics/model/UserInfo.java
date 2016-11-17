package com.logistics.model;

public class UserInfo {
	private int manager_id;
	private String manager_name;
	private String manager_password;
	private int role_id;
	private int center_id;

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int managerId) {
		manager_id = managerId;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String managerName) {
		manager_name = managerName;
	}

	public String getManager_password() {
		return manager_password;
	}

	public void setManager_password(String managerPassword) {
		manager_password = managerPassword;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int roleId) {
		role_id = roleId;
	}

	public int getCenter_id() {
		return center_id;
	}

	public void setCenter_id(int centerId) {
		center_id = centerId;
	}

}
