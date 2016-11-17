package com.logistics.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.logistics.idal.IMenuMapper;
import com.logistics.idal.IUserMapper;
import com.logistics.model.MenuInfo;
import com.logistics.model.UserInfo;
import com.logistics.mybatisutil.MyBatisUtil;

public class MenuMapper {

	SqlSession session = MyBatisUtil.getsqlSession(true);

	IMenuMapper mapper = session.getMapper(IMenuMapper.class);

	public boolean validateMenu(int role_id, String validateMenuPath) {
		int result = mapper.validateMenu(role_id, validateMenuPath);
		if (result > 0)
			return true;
		else
			return false;

	}

//	public List<MenuInfo> getMenuList() {
//		List<MenuInfo> menulist = mapper.getMenuList();
//		return menulist;
//	}

	public List<MenuInfo> getTopMenu(int role_id) {
		// TODO Auto-generated method stub
		List<MenuInfo> menulist=mapper.getTopMenu(role_id);
		//session.close();
		return menulist;
	}
	public List<MenuInfo> getSecondMenu(int role_id,int upMenuId) {
		// TODO Auto-generated method stub
		List<MenuInfo> menulist=mapper.getSecondMenu(role_id,upMenuId);
		return menulist;
	}
}
