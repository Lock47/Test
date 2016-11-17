package com.logistics.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.logistics.idal.IUserMapper;
import com.logistics.model.UserInfo;
import com.logistics.mybatisutil.MyBatisUtil;

public class UserMapper {

	SqlSession session = MyBatisUtil.getsqlSession(true);

	IUserMapper mapper = session.getMapper(IUserMapper.class);

	public UserInfo validateLogin(String username, String password) {

		UserInfo u = mapper.validateLogin(username, password);
		return u;
	}

	public List<UserInfo> getUserList() {
		List<UserInfo> userlist = mapper.getUserList();
		return userlist;
	}

	public List<UserInfo> getNoSetCenterManagerList() {
        return mapper.getNoSetCenterManagerList();
	}
}
