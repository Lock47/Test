package com.logistics.idal;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.logistics.model.DepartmentInfo;

public interface IDepartmentMapper {
	// 创建二级分拣中心
	// department_name varchar(255),city_name varchar(50),center_code
	// varchar(50),district_name varchar(50),department_address
	// varchar(255),department_manager varchar(50),department_tel
	// varchar(50),department_mobile varchar(50)
	@Insert("CALL createCenter(#{department_name},#{city_name},#{department_code},#{district_name},#{department_address},#{department_manager},#{manager_id},#{department_tel},#{department_mobile})")
	@Options(statementType = StatementType.CALLABLE)
	public int createCenter(DepartmentInfo ci);

	// 获取二级分拣中心信息列表列数——分页
	// 包括设置和未设置管理员账户的
	@Select("CALL getCenterAndManagerListCount()")
	@Options(statementType = StatementType.CALLABLE)
	public int getCenterAndManagerListCount();

	// 获取二级分拣中心信息列表——分页
	// 包括设置和未设置管理员账户的
	@Select("CALL getCenterAndManagerList(#{0},#{1})")
	@Options(statementType = StatementType.CALLABLE)
	public List<DepartmentInfo> getCenterAndManagerList(int startIndex,
			int pageSize);

	// 获取二级分拣中心信息列表——分页——优化
	// 包括设置和未设置管理员账户的
	@Select("CALL getMyCenterList(#{0},#{1})")
	@Options(statementType = StatementType.CALLABLE)
	public List<DepartmentInfo> getCenterList(int startIndex,
			int pageSize);
}
