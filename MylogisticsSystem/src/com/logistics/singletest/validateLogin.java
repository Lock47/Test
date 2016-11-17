package com.logistics.singletest;

import java.util.List;

import org.junit.Test;

import com.logistics.mapper.UserMapper;
import com.logistics.model.UserInfo;

public class validateLogin {

	@Test
	public void test() {
		UserMapper um = new UserMapper();
		UserInfo u = um.validateLogin("admin", "admin");
		if (u != null) {
			System.out.println(u.getRole_id());
		}
		/*
		 * List<UserInfo> userlist=um.getUserList(); for(UserInfo u:userlist){
		 * System.out.println(u.getManager_name()); }
		 */
	}

}
