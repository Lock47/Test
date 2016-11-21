package com.logistics.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.logistics.idal.ICompanyMapper;
import com.logistics.model.CompanyInfo;
import com.logistics.model.ContractInfo;
import com.logistics.mybatisutil.MyBatisUtil;

public class CompanyMapper {
	// 调用我的SqlSession
	SqlSession session = MyBatisUtil.getsqlSession(true);
	ICompanyMapper mapper = session.getMapper(ICompanyMapper.class);

	// 实现方法
	public CompanyInfo getCompanyInfo() {
		return mapper.getCompanyInfo();
	}

	public int getCompanyListCount() {
		// TODO Auto-generated method stub
		return mapper.getContractAndCarrierListCount();
	}

	public List<CompanyInfo> getCompanyList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.getCompanyList(
				Integer.parseInt(map.get("startIndex").toString()),
				Integer.parseInt(map.get("pageSize").toString()));
	}
	
	public boolean delCompanyInfo(int companyid) {
		// TODO Auto-generated method stub
		int count = mapper.delCompanyInfo(companyid);
		if (count > 0)
			return true;
		else
			return false;
	}

	public boolean createCompany(CompanyInfo ci) {
		// TODO Auto-generated method stub
		int count = mapper.createCompany(ci);
		if (count > 0)
			return true;
		else
			return false;
	}
}
