package com.logistics.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.logistics.idal.IDepartmentMapper;
import com.logistics.model.DepartmentInfo;
import com.logistics.mybatisutil.MyBatisUtil;

public class DepartmentMapper {
	// 调用我的SqlSession
	SqlSession session = MyBatisUtil.getsqlSession(true);
	// 得到ICityMapper接口的实现类对象，ICityMapper接口的实现类对象由sqlSession.getMapper(ICityMapper.class)动态构建出来
	IDepartmentMapper mapper = session.getMapper(IDepartmentMapper.class);

	// 创建二级分拣中心
	public boolean createCenter(DepartmentInfo ci) {
		int count = mapper.createCenter(ci);
		if (count > 0)
			return true;
		else
			return false;
	}

	// 获取二级分拣中心信息列表列数——分页
	// 包括设置和未设置管理员账户的
	public int getCenterAndManagerListCount() {
		return mapper.getCenterAndManagerListCount();
	}

	// 获取二级分拣中心信息列表
	// 包括设置和未设置管理员账户的
	public List<DepartmentInfo> getCenterAndManagerList(Map<String, Object> map) {
		return mapper.getCenterAndManagerList(
				Integer.parseInt(map.get("startIndex").toString()),
				Integer.parseInt(map.get("pageSize").toString()));
	}

	// 获取二级分拣中心信息列表——分页——优化
	// 包括设置和未设置管理员账户的
	public List<DepartmentInfo> getCenterList(Map<String, Object> map) {
		return mapper.getCenterList(
				Integer.parseInt(map.get("startIndex").toString()),
				Integer.parseInt(map.get("pageSize").toString()));
	}
	
	
}
