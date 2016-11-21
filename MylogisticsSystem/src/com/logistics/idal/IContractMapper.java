package com.logistics.idal;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.logistics.model.ContractInfo;


public interface IContractMapper {
	//contract_id,contract_name,customer_id,contract_customer,contract_carrier,contract_customertel,contract_carriertel,contract_signdate,contract_duedate,contract_content
	@Insert("CALL createContract(#{contract_id},#{contract_name},#{contract_money},#{customer_id},#{contract_customer},#{contract_carrier},#{contract_customertel},#{contract_carriertel},#{contract_signdate},#{contract_duedate},#{contract_content})")
	@Options(statementType = StatementType.CALLABLE)
	public int createContract(ContractInfo ci);
   
	//获取数量
	@Select("CALL getContractAndCarrierListCount()")
	@Options(statementType = StatementType.CALLABLE)
	public int getContractAndCarrierListCount();
	
	
	// 获取合同信息列表——分页——优化
	@Select("CALL getMyContractList(#{0},#{1})")
	@Options(statementType = StatementType.CALLABLE)
	public List<ContractInfo> getContractList(int startIndex,
			int pageSize);
	//获取合同详细信息
	@Select("CALL getContractInfo(#{contract_id})")
	@Options(statementType = StatementType.CALLABLE)
	public List<ContractInfo> getContractInfo(int contractid);

	@Delete("CALL delContractInfo(#{contract_id})")
	@Options(statementType = StatementType.CALLABLE)
	public int delContract(int contractid);
	
}
