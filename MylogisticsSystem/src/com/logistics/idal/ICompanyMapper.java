package com.logistics.idal;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.logistics.model.CompanyInfo;
import com.logistics.model.ContractInfo;

public interface ICompanyMapper {
    
	@Select("CALL getCompanyInfo()")
	@Options(statementType = StatementType.CALLABLE)
	public CompanyInfo getCompanyInfo();
	
	@Select("CALL getCompanyListCount()")
	@Options(statementType = StatementType.CALLABLE)
	public int getContractAndCarrierListCount();

	@Select("CALL getCompanyList(#{0},#{1})")
	@Options(statementType = StatementType.CALLABLE)
	public List<CompanyInfo> getCompanyList(int startIndex, int pageSize);
	
	@Delete("CALL delCompanyInfo(#{company_id})")
	@Options(statementType = StatementType.CALLABLE)
	public int delCompanyInfo(int companyid);
	
	@Insert("CALL createCompany(#{company_id},#{company_name},#{company_code},#{company_license},#{company_address},#{company_tel},#{company_content})")
	@Options(statementType = StatementType.CALLABLE)
	public int createCompany(CompanyInfo ci);


}
