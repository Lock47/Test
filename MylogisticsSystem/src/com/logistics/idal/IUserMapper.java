package com.logistics.idal;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.logistics.model.DepartmentInfo;
import com.logistics.model.UserInfo;

public interface IUserMapper {


	@Select("CALL validateLogin(#{0},#{1})")
	@Options(statementType = StatementType.CALLABLE)
	public UserInfo validateLogin(String username, String password);

	@Select("CALL getUserList()")
	@Options(statementType = StatementType.CALLABLE)
	public List<UserInfo> getUserList();
	
	@Select("CALL getNoSetCenterManagerList()")
	@Options(statementType = StatementType.CALLABLE)
	public List<UserInfo> getNoSetCenterManagerList();

}
