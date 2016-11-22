package com.logistics.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.logistics.idal.IContractMapper;
import com.logistics.model.ContractInfo;
import com.logistics.model.DepartmentInfo;
import com.logistics.mybatisutil.MyBatisUtil;

public class ContractMapper {
	SqlSession session = MyBatisUtil.getsqlSession(true);
	IContractMapper mapper = session.getMapper(IContractMapper.class);

	// 添加合同
	public boolean createContract(ContractInfo ci) {
		int count = mapper.createContract(ci);
		if (count > 0)
			return true;
		else
			return false;
	}
	
	// 获取合同信息列表列数——分页
	// 负责人
	public int getContractAndCarrierListCount() {
		return mapper.getContractAndCarrierListCount();
	}

	// 获取二级分拣中心信息列表——分页——优化
	// 包括设置和未设置管理员账户的
	public List<ContractInfo> getContractList(Map<String, Object> map) {
		return mapper.getContractList(
				Integer.parseInt(map.get("startIndex").toString()),
				Integer.parseInt(map.get("pageSize").toString()));
	}

	public List getContractInfo(int contractid) {
		// TODO Auto-generated method stub
		return mapper.getContractInfo(contractid);
	}
    //删除合同
	public boolean delContract(int contractid) {
		// TODO Auto-generated method stub
		int count = mapper.delContract(contractid);
		if (count > 0)
			return true;
		else
			return false;
	}
	
	public List<ContractInfo> getContractListByID(Map<String, Object> map) {
		return mapper.getContractListByID(
				Integer.parseInt(map.get("startIndex").toString()),
				Integer.parseInt(map.get("pageSize").toString()),
				Integer.parseInt(map.get("searchInfo").toString())
		);
	}

}
