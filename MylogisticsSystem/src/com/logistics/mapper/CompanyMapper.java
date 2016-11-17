package com.logistics.mapper;

import org.apache.ibatis.session.SqlSession;

import com.logistics.idal.ICompanyMapper;
import com.logistics.model.CompanyInfo;
import com.logistics.mybatisutil.MyBatisUtil;

public class CompanyMapper {
	// 调用我的SqlSession
	SqlSession session = MyBatisUtil.getsqlSession(true);
	ICompanyMapper mapper = session.getMapper(ICompanyMapper.class);

	// 实现方法
	public CompanyInfo getCompanyInfo() {
		return mapper.getCompanyInfo();
	}
}
