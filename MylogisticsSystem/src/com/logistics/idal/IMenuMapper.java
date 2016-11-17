package com.logistics.idal;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.logistics.model.MenuInfo;


public interface IMenuMapper {
	@Select("CALL getTopMenu(#{role_id})")
	@Options(statementType = StatementType.CALLABLE)
	public List<MenuInfo> getTopMenu(int role_id);
	
	
	@Select("CALL getSecondMenu(#{0},#{1})")
	@Options(statementType = StatementType.CALLABLE)
	public List<MenuInfo> getSecondMenu(int roleId, int upMenuId);

	@Select("CALL validateMenu(#{0},#{1})")
	@Options(statementType = StatementType.CALLABLE)
	public int validateMenu(int roleId, String validateMenuPath);
}
